
jQuery(document).ready(function() {
	
    $('.register form').submit(function(event){
    	event.preventDefault(event);
        $(this).find("label[for='firstName']").html('First Name');
        $(this).find("label[for='lastName']").html('Last Name');
        $(this).find("label[for='houseName']").html('House name');
        $(this).find("label[for='fatherName']").html("Father's Name");
        $(this).find("label[for='motherName']").html("Mother's Name");
        $(this).find("label[for='mobile']").html('Mobile');
        ////
        var firstName = $(this).find('input#firstName').val();
        var lastName = $(this).find('input#lastName').val();
        var houseName = $(this).find('input#houseName').val();
        var fatherName = $(this).find('input#fatherName').val();
        var motherName = $(this).find('input#motherName').val();
        var mobile = $(this).find('input#mobile').val();
        if(firstName == '') {
            $(this).find("label[for='firstName']").append("<span style='display:none' class='red'> - Please enter your first name.</span>");
            $(this).find("label[for='firstName'] span").fadeIn('medium');
            return false;
        }
        if(lastName == '') {
            $(this).find("label[for='lastName']").append("<span style='display:none' class='red'> - Please enter your last name.</span>");
            $(this).find("label[for='lastName'] span").fadeIn('medium');
            return false;
        }
        if(houseName == '') {
            $(this).find("label[for='houseName']").append("<span style='display:none' class='red'> - Please enter a valid houseName.</span>");
            $(this).find("label[for='houseName'] span").fadeIn('medium');
            return false;
        }
        if(fatherName == '') {
            $(this).find("label[for='fatherName']").append("<span style='display:none' class='red'> - Please enter a valid fatherName.</span>");
            $(this).find("label[for='fatherName'] span").fadeIn('medium');
            return false;
        }
        if(motherName == '') {
            $(this).find("label[for='motherName']").append("<span style='display:none' class='red'> - Please enter a valid motherName.</span>");
            $(this).find("label[for='motherName'] span").fadeIn('medium');
            return false;
        }
        if(mobile == '') {
            $(this).find("label[for='mobile']").append("<span style='display:none' class='red'> - Please enter a valid mobile.</span>");
            $(this).find("label[for='mobile'] span").fadeIn('medium');
            return false;
        }
        
      var userData="&firstName="+firstName+"&lastName="+lastName+"&houseName="+houseName+"&fatherName="+fatherName+"&motherName="+motherName+"&mobile="+mobile;
        $.ajax({
        	
			  type: "POST",
			  url: "../Locale/RegisterServlet",
			  data:userData,
        }) .done(function ( responseText ) {
			    	
				  if(responseText=="Done")
					  {
					  		$.confirm({
							'title'		: 'Registration Successfull!!!',
							'message'	: 'You have successfully inserted the Details. <br />What do you want to do next?',
							'buttons'	: {
								'Register'	: {
									'class'	: 'blue',
									'action': function(){
										window.location.replace("index.html");
									}
								},
								'Search'	: {
									'class'	: 'gray',
									'action': function(){
										window.location.replace("search.html");
									}
								}
							}
						});
					  }
				  else
					  {
					  
					  $.confirm({
							'title'		: 'Registration Failed!!!',
							'message'	: 'Some error occured while inserting Details. <br />What do you want to do next?',
							'buttons'	: {
								'Register'	: {
									'class'	: 'blue',
									'action': function(){
									}
								},
								'Search'	: {
									'class'	: 'gray',
									'action': function(){
										window.location.replace("search.html");
									}
								}
							}
						});
					  }
					  
			    
			});
    });


});


