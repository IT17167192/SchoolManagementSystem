$(function() {
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
			}
		}
	});
});
