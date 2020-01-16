 $(document).ready(function(){
	
    	 
    	 $(".table .nBtn").click(function(event) {
    		 
    		 event.preventDefault();
    		 
    		 var href= $(this).attr('href');
    		
    	     $.get(href,function(grade,status){
    	    	 
    	    	 
    	    	 $('.myForm #exampleModal').modal();
        		 
    		 });
    		});
    	 }); 