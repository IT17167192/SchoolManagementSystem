$(function() {
	$("#fullName").focus().select();
	//enter key press event
	$(document).keypress(function (e) {
		if (e.which === 13) {
			e.preventDefault();
			if (e.target.id === 'fullName') {
				if (validateRequired('fullName')) {
					$("#firstName").focus().select();					
				}
			}else if(e.target.id === 'firstName'){
				if (validateRequired('fullName')) {
					$("#lastName").focus().select();					
				}
			}else if(e.target.id === 'lastName'){
				if (validateRequired('lastName')) {
					$("#dob").focus().select();					
				}
			}else if(e.target.id === 'dob'){
				if (validateRequired('dob')) {
					$("#address").focus().select();					
				}
			}else if(e.target.id === 'address'){
				if (validateRequired('address')) {
					$("#guardian").focus().select();					
				}
			}else if(e.target.id === 'guardian'){
				if (validateRequired('guardian')) {
					$("#cNumber").focus().select();					
				}
			}else if(e.target.id === 'cNumber'){
				if (validateRequired('cNumber')) {
					$("#occupation").focus().select();					
				}
			}else if(e.target.id === 'occupation'){
				if (validateRequired('occupation')) {
					$("#addmissionDate").focus().select();					
				}
			}else if(e.target.id === 'addmissionDate'){
				if (validateRequired('addmissionDate')) {
					$("#admissionNo").focus().select();					
				}
			}else if(e.target.id === 'admissionNo'){
				if (validateRequired('admissionNo')) {
					validateSubmit(e);					
				}
			}
		}
	});
});

const validateSubmit = (event) => {
	event.preventDefault();
	console.log("Validate began");
	let err = 0;
	
	if(!validateRequired('fullName')){
		validateRequired('fullName');
		err++;
	}
	
	if(!validateRequired('firstName')){
		validateRequired('firstName');
		err++;
	}
	
	if(!validateRequired('lastName')){
		validateRequired('lastName');
		err++;
	}
	
	if(!validateRequired('dob')){
		validateRequired('dob');
		err++;
	}
	
	if(!validateRequired('address')){
		validateRequired('address');
		err++;
	}
	
	if(!validateRequired('guardian')){
		validateRequired('guardian');
		err++;
	}
	
	if(!validateRequired('cNumber')){
		validateRequired('cNumber');
		err++;
	}
	
	if(!validateRequired('occupation')){
		validateRequired('occupation');
		err++;
	}
	
	if(!validateRequired('addmissionDate')){
		validateRequired('addmissionDate');
		err++;
	}
	
	if(!validateRequired('admissionNo')){
		validateRequired('admissionNo');
		err++;
	}
	
	if(err == 0){
		 document.addStudentForm.submit();
	}else{
		return false;
	}
}
