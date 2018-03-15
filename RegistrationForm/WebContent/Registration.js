
 
$(function() {
  $.validator.addMethod('strongPassword', function(value, element) {
    return this.optional(element) 
      || value.length >= 6
      && /\d/.test(value)
      && /[a-z]/i.test(value);
  }, 'Your password must be at least 6 characters long and contain at least one number and one char\'.');

  
		$.validator.addMethod('customphone', function (value, element) {
	        return this.optional(element) || /^(?:(?:\+|0{0,2})91(\s*[\-]\s*)?|[0]?)?[789]\d{9}$/.test(value);
	    }, "Please enter a valid phone number");
  $("#registerform").validate({
    rules: {
    	ename:{
    		required:true,
    		minlength:5
    	},
      email: {
        required: true,
        email: true,
        remote: "http://localhost:3000/inputValidator"
      },
      pass: {
        required: true,
        strongPassword: true
      },
      cpass: {
        required: true,
        equalTo: '#pass'
      },
     
      mobile: {
    	  required=true,
    	customphone=true
      },
      
      address: {
        required: true
      }
      
    },
    messages: {
      email: {
        required: 'Please enter an email address.',
        email: 'Please enter a <em>valid</em> email address.',
        remote: $.validator.format("{0} is already associated with an account.")
      }
    }
  });

});