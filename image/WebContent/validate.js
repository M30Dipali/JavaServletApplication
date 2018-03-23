$(document).ready(function(){
	$.validator.addMethod('customphone', function (value, element) {
        return this.optional(element) || /^(?:(?:\+|0{0,2})91(\s*[\-]\s*)?|[0]?)?[789]\d{9}$/.test(value);
    }, "Please enter a valid phone number");
$("#validation").validate({
    rules: {
    	name:{
    		required:true,
    		minlength:5
    	},
      photo: {
        required: true            
      },
      phone: {
    	 required:true,
    	 customphone:true
      }
      
    },
    messages: {
      
    }
  });
});