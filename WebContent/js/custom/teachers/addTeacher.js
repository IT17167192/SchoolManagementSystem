$(function() {
	$('.select2').select2();
	$('.select2bs4').select2({
		theme : 'bootstrap4'
	});
});

$('#add_qua').click(function() {
	var name = document.getElementById('name').value;
	var des = document.getElementById('des').value;
	if (name == "") {
		alert("Please enter teacher's name !");
	} else if (des == "") {
		alert("Please enter Qualification !");
	} else {
		var table = document.getElementById('tbl').insertRow(1);
		var c1 = table.insertCell(0);
		var c2 = table.insertCell(1);
		c1.innerHTML = name;
		c2.innerHTML = des;
	}
});