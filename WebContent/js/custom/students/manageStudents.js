$(function() {
	getStudents();
});

const getStudents = () => {
	console.log("Get Students");
	$.ajax({
		type: "POST",
		url: "/SchoolManagementSystem/manageStudent?action=get",
		headers : {
			Accept : "application/json; charset=utf-8",
			"Content-Type" : "application/json; charset=utf-8"
		},
		success: function (data) {
			$('#tblViewStudents > tbody').html('');
			$.each(data, function (i, student) {
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
	
	const statusChangeBtn = '<button type="button" class="btn btn-danger btn-xs" id="' + item.id + 'changeStatus" onclick="changeStatus(\'' + item.id + '\',\'' + item.status + '\')"><span class="fas fa-trash-alt"></span>&nbsp;Change Status</button>';
	
	let statusBadge;
	if(item.status == 1){
		statusBadge = '<span class="badge badge-success">Active</span>'
	}else{
		statusBadge = '<span class="badge badge-danger">Inactive</span>'
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
			+ statusChangeBtn
		+ '</td>'
		+ '</tr>';
	return row;
};

const changeStatus = (id, status) => {
	console.log(id);
	console.log(status);
	$("#"+id+"changeStatus").prop("disabled", true);
	Swal.fire({
		title: 'Are you sure?',
		text: "Do you want to change status?",
		icon: 'warning',
		showCancelButton: true,
		confirmButtonColor: '#3085d6',
		cancelButtonColor: '#d33',
		confirmButtonText: 'Yes, proceed!'
	}).then((result) => {
		if (result.value) {
			$.ajax({
				type: "POST",
				url: "/SchoolManagementSystem/manageStudent?action=update&id="+id+"&status="+status,
				headers : {
					Accept : "application/json; charset=utf-8",
					"Content-Type" : "application/json; charset=utf-8"
				},
				success: function (data) {
					if(data){
						getStudents();						
					}
				}
			});
			$("#"+id+"changeStatus").prop("disabled", false);
		}else{
			$("#"+id+"changeStatus").prop("disabled", false);
		}
	})
};