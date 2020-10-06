<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Teacher</title>
<!-- Custom fonts for this template-->
        <link href="../../vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
        <link rel="stylesheet" href="../../plugins/select2/css/select2.min.css">
        <link rel="stylesheet" href="../../plugins/select2-bootstrap4-theme/select2-bootstrap4.min.css">
        <!-- Custom styles for this template-->
        <link href="../../css/sb-admin-2.min.css" rel="stylesheet">
</head>
<body id="page-top">

        <!-- Page Wrapper -->
        <div id="wrapper">

            <!-- Sidebar -->
           	<jsp:include page="../common/sidebar.jsp" />
            <!-- End of Sidebar -->

            <!-- Content Wrapper -->
            <div id="content-wrapper" class="d-flex flex-column">

                <!-- Main Content -->
                <div id="content">

                    <!-- Topbar -->
                    <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                        <!-- Sidebar Toggle (Topbar) -->
                        <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                            <i class="fa fa-bars"></i>
                        </button>




                        <!-- Topbar Navbar -->
                        <ul class="navbar-nav ml-auto">

                            <div class="topbar-divider d-none d-sm-block"></div>

                            <!-- Nav Item - User Information -->
                            <li class="nav-item dropdown no-arrow">
                                <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <span class="mr-2 d-none d-lg-inline text-gray-600 small">Janith Sameera</span>
                                    <img class="img-profile rounded-circle" src="https://source.unsplash.com/QAB-WJcbgJk/60x60">
                                </a>
                                <!-- Dropdown - User Information -->
                                <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">

                                    <div class="dropdown-divider"></div>
                                    <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                                        <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                        Logout
                                    </a>
                                </div>
                            </li>

                        </ul>

                    </nav>

                    <div class="container-fluid">

                        <h1 class="h3 mb-4 text-gray-800">Add Teacher Details</h1>

                        <form class="user" id="addTeacherForm">
                        	<div class="form-group">
                                <span id="newId" class="badge badge-success"></span>
                                <input type="hidden" id="nextId">
                            </div>
                            
                            <div class="form-group">
                                <label>Full Name</label>
                                <input type="text" id="fullName" class="form-control form-control-user" placeholder="Full Name">
                            </div>

                            <div class="form-group">
                                <label>Select Gender</label>
                                <select id="gender" class="form-control">
                                    <option value="1">Male</option>
                                    <option value="2">Female</option>
                                </select>
                            </div>

                            <div class="form-group">
                                <label>Date Of Birth</label>
                                <input type="date" id="dob" class="form-control form-control-user" id="exampleInputEmail">
                            </div>

                            <div class="form-group">
                                <label>NIC</label>
                                <input type="text" id="nic" class="form-control form-control-user" id="exampleInputEmail" placeholder="NIC">
                            </div>

                            <div class="form-group">
                                <label>Join Date</label>
                                <input type="date" id="joinDate" class="form-control form-control-user" id="exampleInputEmail">
                            </div>

                            <div class="card">

                                <div class="card-body">
                                    <h2 class="h3 mb-4 text-gray-800">Qualifications</h2>
                                    <div class="form-group">
                                        <label>Description</label>
                                        <input type="text" id="description" class="form-control form-control-user" placeholder="Description">
                                    </div>
                                    <input type="button" onclick="addToQualificationTable(event)" class="btn btn-danger btn-user btn-block" id="addQualification" value="Add Qualification">
                                    <br><br>
                                    <table id="tblQualifications" class="table table-bordered table-striped">
                                        <thead>
											<tr>
												<th>Teacher Name</th>
                                               <th>Description</th>
                                               <th>Close</th>
											</tr>
										</thead>
                                       
                                        <tbody>

                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <br><br>
                            <input type="submit" onclick="validateSubmit(event)" id="submitBtn" class="btn btn-primary btn-user btn-block" value="Save Teacher">
                            <hr>
                        </form>


                    </div>
                    <!-- /.container-fluid -->

                </div>
                <!-- End of Main Content -->

                <!-- Footer -->
                <footer class="sticky-footer bg-white">
                    <div class="container my-auto">

                    </div>
                </footer>
                <!-- End of Footer -->

            </div>
            <!-- End of Content Wrapper -->

        </div>
        <!-- End of Page Wrapper -->

        <!-- Scroll to Top Button-->
        <a class="scroll-to-top rounded" href="#page-top">
            <i class="fas fa-angle-up"></i>
        </a>

        <!-- Logout Modal-->
        <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                        <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">×</span>
                        </button>
                    </div>
                    <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                    <div class="modal-footer">
                        <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                        <a class="btn btn-primary" href="login.html">Logout</a>
                    </div>
                </div>
            </div>
        </div>

        <!-- Bootstrap core JavaScript-->
        <script src="../../vendor/jquery/jquery.min.js"></script>
        <script src="../../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="../../vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="../../js/sb-admin-2.min.js"></script>
        <script src="../../plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="../../plugins/select2/js/select2.full.min.js"></script>
        <script src="../../js/custom/teachers/addTeacher.js"></script>
    </body>
</html>