 $(document).ready(function(){
	
    	 
    	 $(".eBtn").click(function(event) {
    		 
    		 event.preventDefault();
    		 var href= $(this).attr('href');
    		
    		 var gradeId =  $(this).data('gradeid');
    		 var gradeLearner = $(this).data('learnerid');
    		 var gradeHeight =  $(this).data('gradeheight');
    		 var gradeSubject = $(this).data('gradesubject');
    		
    		 var gradeFinal = $(this).data('gradefinal');
    		 
    		 
    	     $('.myForm #gradeId').val(gradeId);
             $('.myForm #heightGrade').val(gradeHeight);
    	     $('.myForm #lernerId').val(gradeLearner);
             $('.myForm #subjectId').val(gradeSubject);
             
    	     
    	     $('.myForm #finalGrade').val(gradeFinal);
    	     
    	     $('.myForm #exampleModal').modal();
        		 //data-gradeid=${grade.id}, data-gradeheight=${grade.heightGrade}, data-grade=${grade.schoolSubject.id}, data-gradedate=${grade.createdDate}, data-gradefinal=${grade.finalGrade}"
    		
    	});
    	
    	
    	 
    	 $('.table .delBtn').on('click', function(event){
             event.preventDefault();
         
         var firstName = $(this).data('name');
         var lastName = $(this).data('last');
         
   		 var href= $(this).attr('href');
   		 
   		 
   		  $('#myModal #deleteLearner').text("Желите ли да обришете оцену од ученика "+ firstName+" "+lastName);
   		 $('#myModal #delRef').attr('href',href);
   		
   		 $('#myModal').modal();
   	     });
    	 
    	 
    	 }); 
