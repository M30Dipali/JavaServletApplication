$(document).ready(function(){
	
$("#validation").validate({
    rules: {
    	email:{
    		required:true,
    		email:true
    	},
      pass: {
        required: true            
      }
    },
    messages: {
      
    }
  });
});