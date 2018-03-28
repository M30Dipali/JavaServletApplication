$(document).ready(function(){
	
$("#validation").validate({
    rules: {
    	name:{
    		required:true
    		
    	},
      pass: {
        required: true            
      }
    },
    messages: {
      
    }
  });
});