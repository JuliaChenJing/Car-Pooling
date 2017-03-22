
function closeWeatherMapWindow(){
  $('#weatherMapPopupWindow').remove();
}
function displayWeatherMapWindow(city){
     $('body').append(
        $('<div id="weatherMapPopupWindow"/>')

      );
     //console.log(city);
    openWeatherMap('weatherMapPopupWindow',city);
}


function openWeatherMap(mapElementID,city){
	var map;
	var geoJSON;
	var request;
	var gettingData = false;
	var openWeatherMapKey = "1d76ad8dbd7721d3ef6fdd670d748b91";
	var labelIndex=0;
	
	//add search 
	var mapElement=document.getElementById(mapElementID);
	mapElement.innerHTML='<div id="mapSearchPanel">\
      <input id="mapAddress" type="textbox" value="'+city+'">\
      <input id="mapSubmit" type="button" value="Search">\
      <input onclick="closeWeatherMapWindow()" type="button" id="mapCloseBtn" value="Close"/>\
    </div><div id="mapContainer"></div>';
    
    var mapContainer=document.getElementById("mapContainer");
	//init the map object
	var lat= 41.01776;
	var lng= -91.9674;
	var mapOptions = {
		zoom: 8,
		center: {lat:lat,lng:lng}
	};
	
	map = new google.maps.Map(mapContainer,mapOptions);

    ///////search//////////////
    var geocoder = new google.maps.Geocoder();
    document.getElementById('mapSubmit').addEventListener('click', function() {
    	var address = document.getElementById('mapAddress').value;
       geocodeAddress(geocoder, map,address);
 	});
    function geocodeAddress(geocoder, resultsMap,address) {
	  
	  geocoder.geocode({'address': address}, function(results, status) {
	    if (status === google.maps.GeocoderStatus.OK) {
	    	//console.log(results[0].geometry.location);
	    	var loc=results[0].geometry.location;
	      resultsMap.setCenter(loc);
	      //console.log(loc);
	      weatherRequest(loc.lat(),loc.lng());
	    } else {
	      alert('Geocode was not successful for the following reason: ' + status);
	    }
	  });
	}
	////////////
	////////////////////
	
	if(city!=''){
		geocodeAddress(geocoder, map,city);
	}
	else if(navigator.geolocation){
		    navigator.geolocation.getCurrentPosition(function(position) {
		      weatherRequest(position.coords.latitude,position.coords.longitude);
		  });
	}
	
	////////////////////////
    //map click event
    google.maps.event.addListener(map, 'click', mapOnClick);
     
    //
    function mapOnClick(event){
    	var lat=event.latLng.lat();
    	var lng= event.latLng.lng(); 
    	weatherRequest(lat,lng);
    }
    function weatherRequest(lat,lng){   	
    	var labelIndex=0;	 
    	var lat=lat;
    	var lng= lng; 

    	addMarker();
    	getWeather();

    	function addMarker() {
		  // Add the marker at the clicked location, and add the next-available label
		  // from the array of alphabetical characters.
		  var marker = new google.maps.Marker({
		  	position: {lat: lat,lng: lng},
		  	//label: 'label'+labelIndex,
		  	map: map
		  });
		  return marker;
	  	};
		//
	  	function addInfoWindow(info){
	  		var infowindow = new google.maps.InfoWindow();
	  		infowindow.setContent(info);
	  		infowindow.setOptions({
			position:{
			lat: lat,
			lng: lng
			},
	    	pixelOffset: {
	    			width: 0,
	    			height: -15
	    		}
	    	}
	    	);
	    	infowindow.open(map);
	  	};
	  	//
	  	function getWeather(){
	  		var requestString = "http://api.openweathermap.org/data/2.5/forecast?lat="
                    + lat + "&lon=" + lng 
                    + "&cluster=yes&format=json&&units=Imperial"
                    + "&APPID=" + openWeatherMapKey;
            //console.log(requestString);
            request = new XMLHttpRequest();
            request.onload = proccessResults;
            request.open("get", requestString, true);
            request.send();
        };
        //
        function proccessResults() {
		  	//console.log(this);
		  	var results = JSON.parse(this.responseText);
		  	var markup ="<div class='WeatherInfoWindow'>";
		  	//console.log(results);
		  	markup+='<h4>'+results.city.name+','+results.city.country+'</h4>';
		  	markup+='<hr/>'
		  	for (let i = 0; i < results.list.length; i++) {
	  			let item=results.list[i];
	  			markup+='<div>';
	  			markup+=item.dt_txt+' ';
	  			markup+='<img src="http://openweathermap.org/img/w/'+ item.weather[0].icon+'.png">';
	  			markup+=item.main.temp+'&#8457;';
	  			markup+='</div>';
	  			markup+='<hr/>'
	  		}
		  	markup+='</div>';
		  	//console.log(markup);
		  	addInfoWindow(markup);
		}
		//end function
    }
}

 
    
    
  
  

