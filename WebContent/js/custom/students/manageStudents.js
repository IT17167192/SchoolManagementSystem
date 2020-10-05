$(function() {
	getStudents();
});

const getStudents = () => {
	console.log("Get Students");
	$.ajax({
		type: "POST",
		url: "/SchoolManagementSystem/manageStudent",
		headers : {
			Accept : "application/json; charset=utf-8",
			"Content-Type" : "application/json; charset=utf-8"
		},
		success: function (data) {
			$.each(data, function (i, student) {
				console.log(student);
				appendStudentTable(student);
			});
		}
	});
}

const appendStudentTable = (item) => {
	let textToInsert = '';
	textToInsert += addRow(item);
	$('#tblViewStudents > tbody').append(textToInsert);
};

const addRow = (item) => {
	
	const inactive = '<button type="button" class="btn btn-danger btn-xs" id="' + item.id + 'cancel"><span class="fas fa-trash-alt"></span>&nbsp;Change Status</button>';
	
	let statusBadge;
	if(item.status == 1){
		statusBadge = '<span class="badge badge-success">Active</span>'
	}else{
		statusBadge = '<span class="badge badge-danger">Active</span>'
	}
	
	let row = '<tr id="' + item.id + '">'
		+ '<td>' + item.fullName + '</td>'
		+ '<td>' + item.firstName + '</td>'
		+ '<td>' + item.lastName + '</td>'
		+ '<td>' + item.dob + '</td>'
		+ '<td>' + item.admissionDate + '</td>'
		+ '<td>' + item.addmissionNo + '</td>'
		+ '<td>' + item.guardianName + '</td>'
		+ '<td>' + item.cno + '</td>'
		+ '<td>' + statusBadge + '</td>'
		+ '<td>'
			+ inactive
		+ '</td>'
		+ '</tr>';
	return row;
};