
function closeDirectionMapWindow(){
  $('#weatherMapPopupWindow').remove();
}
function displayDirectionMapWindow(cityfrom,cityto){
     $('body').append(
        $('<div id="weatherMapPopupWindow"/>')

      );
     //console.log(city);
    openDirectionMap('weatherMapPopupWindow',cityfrom,cityto);
}


function openDirectionMap(mapElementID,cityfrom,cityto){
	var map;

	//add search 
	var mapElement=document.getElementById(mapElementID);
	mapElement.innerHTML='<div id="mapSearchPanel">\
		'+cityfrom+'  TO  '+cityto+'\
      <input onclick="closeDirectionMapWindow()" type="button" id="mapCloseBtn" value="Close"/>\
    </div><div id="mapContainer"></div>';
    
    var mapContainer=document.getElementById("mapContainer");
	//init the map object
	var lat= 41.01776;
	var lng= -91.9674;
	var mapOptions = {
		zoom: 10,
		center: {lat:lat,lng:lng}
	};
	
	map = new google.maps.Map(mapContainer,mapOptions);
	var directionsService = new google.maps.DirectionsService;
    var directionsDisplay = new google.maps.DirectionsRenderer;
    directionsDisplay.setMap(map);
    directionsService.route({
	    origin: cityfrom,
	    destination: cityto,
	    travelMode: google.maps.TravelMode.DRIVING
	  }, function(response, status) {
	    if (status === google.maps.DirectionsStatus.OK) {
	      directionsDisplay.setDirections(response);
	    } else {
	      window.alert('Directions request failed due to ' + status);
	    }
	  });
    
		//end function
    
}

 
    
    
  
  

