$(document).ready(function(){
	$.validator.addMethod('customphone', function (value, element) {
        return this.optional(element) || /^(?:(?:\+|0{0,2})91(\s*[\-]\s*)?|[0]?)?[789]\d{9}$/.test(value);
    }, "Please enter a valid phone number");
	 $.validator.addMethod('strongPassword', function(value, element) {
		    return this.optional(element) 
		      || value.length >= 6
		      && /\d/.test(value)
		      && /[a-z]/i.test(value);
		  }, 'Your password must be at least 6 characters long and contain at least one number and one char\'.');
	
$("#registerform").validate({
    rules: {
    	ename:{
    		required:true
    	},
    	email:{
    		required:true,
    		email:true
    	},
      pass: {
          required: true,
          strongPassword: true
        },
      cpass: {
          required: true,
          equalTo: '#pass'
        },
        date:{
        	required:true
        },
        mobile: {
       	 required:true,
       	 customphone:true
         },
        photo:{
        	required:true
        }
    },
    messages: {
   
    }
  });
});