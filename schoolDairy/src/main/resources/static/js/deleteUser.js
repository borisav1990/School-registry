$(document).ready(function(){
	$('.table .delBtn').on('click', function(event){
		event.preventDefault();
     var firstName = $(this).data('name');
     var lastName = $(this).data('last');
     var href= $(this).attr('href');
         $('#myModal #deleteLearner').text("Желите ли да обришете корисника "+ firstName+" "+lastName);
		 $('#myModal #delRef').attr('href',href);
		 $('#myModal').modal();
		 });
	}); 
