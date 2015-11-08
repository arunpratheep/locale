$(document).ready(function() {
	$("#Nametable").hide();
	var id;
	var iden;
	$("#search").click(function() {
		var name = $("#searchterm").val();
		var func = "name";
		var userData = "firstName=" + name + "&func=" + func;
		var i = 1;
		$.ajax({

			type : "POST",
			url : "../Locale/SearchServlet",
			data : userData,
		}).done(function(jsonResponse) {
			$("#grid").bootgrid().bootgrid("append", jsonResponse);
		});
		$("#Nametable").show();
	});
	
	
	$("#searchHouse").click(function() {
		var name = $("#searchterm1").val();
		var func = "house";
		var userData = "houseName=" + name + "&func=" + func;
		var i = 1;
		$.ajax({

			type : "POST",
			url : "../Locale/SearchServlet",
			data : userData,
		}).done(function(jsonResponse) {
			$("#grid").bootgrid().bootgrid("append", jsonResponse);
		});
		
		$("#Nametable").show();
		
	});


	
    
	var rowIds = [];
	var grid = $("#grid").bootgrid({
	    selection:true,
	    multiSelect: false,
	    rowSelect : true,
	    formatters: {
	        "commands": function(column, row)
	        {
	            return "<button type=\"button\" class=\"btn btn-success\" disabled id=\""+ row.id +"\" data-row-id=\"" + row.id + "\">Edit	</button> " + 
	                "<button type=\"button\" class=\"btn btn-danger\" id=\""+ row.id +"d\" disabled data-row-id=\"" + row.id + "\">Delete</button>";
	            
	        }
	    }
	}).on("loaded.rs.jquery.bootgrid", function()
			{
	    grid.find(".btn-success").on("click", function(e)
	    {
	    	$("#divdeps").dialog('open');
	    }).end().find(".btn-danger").on("click", function(e)
	    {

	    	var userData="&id="+iden;
	        $.ajax({
	        	
				  type: "POST",
				  url: "../Locale/DeleteServlet",
				  data:userData,
	        }) .done(function ( responseText ) {
	        	$("#divdeps").dialog('close');
					  if(responseText=="Done")
						  {
						  		$.confirm({
								'title'		: 'Delete Successfull!!!',
								'message'	: 'You have successfully deleted the Details. <br />What do you want to do next?',
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
								'title'		: 'Deletion Failed!!!',
								'message'	: 'Some error occured while deleting Details. <br />What do you want to do next?',
								'buttons'	: {
									'Search'	: {
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
	
	$("#divdeps").dialog({
	    autoOpen: false,
	    show: 'slide',
	    resizable: false,
	    modal: true
	});

    $("#grid").bootgrid()
    .on("selected.rs.jquery.bootgrid", function (e,rows)
    {
    	$("#firstName").val(rows[0].firstName);
    	$("#lastName").val(rows[0].lastName);
    	$("#houseName").val(rows[0].houseName);
    	$("#fatherName").val(rows[0].fatherName);
    	$("#motherName").val(rows[0].motherName);
    	$("#mobile").val(rows[0].mobile);
    	var id="#"+rows[0].id;
    	iden=rows[0].id;
    	$(id).removeAttr("disabled");
    	var id="#"+rows[0].id+"d";
    	$(id).removeAttr("disabled");
    	
    }).on("deselected.rs.jquery.bootgrid", function(e, rows){
    	var id="#"+rows[0].id;
    	$(id).attr("disabled",true);
    	var id="#"+rows[0].id+"d";
    	$(id).attr("disabled",true);
    	
    });
    
    $('.register form').submit(function(event){
    	event.preventDefault(event);
    	var id=iden;
    	var firstName = $(this).find('input#firstName').val();
        var lastName = $(this).find('input#lastName').val();
        var houseName = $(this).find('input#houseName').val();
        var fatherName = $(this).find('input#fatherName').val();
        var motherName = $(this).find('input#motherName').val();
        var mobile = $(this).find('input#mobile').val();
        var userData="&id="+id+"&firstName="+firstName+"&lastName="+lastName+"&houseName="+houseName+"&fatherName="+fatherName+"&motherName="+motherName+"&mobile="+mobile;
        $.ajax({
        	
			  type: "POST",
			  url: "../Locale/UpdateServlet",
			  data:userData,
        }) .done(function ( responseText ) {
        	$("#divdeps").dialog('close');
				  if(responseText=="Done")
					  {
					  		$.confirm({
							'title'		: 'Update Successfull!!!',
							'message'	: 'You have successfully updated the Details. <br />What do you want to do next?',
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
							'title'		: 'Update Failed!!!',
							'message'	: 'Some error occured while updating Details. <br />What do you want to do next?',
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
    
   $("#cancel").on("click",function(){
	   $("#divdeps").dialog('close');
   });

});