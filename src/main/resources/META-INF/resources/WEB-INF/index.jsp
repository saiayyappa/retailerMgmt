<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Retailer Detail</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<div class="container">
		<header>
			<h1 class="text-center">Retailer Details</h1>
		</header>
		<div class="row">
			<div class="col">
				<input class="form-control mb-2" type="number" id="rid"
					placeholder="Enter Retailer ID" tabindex="1" autofocus>

				<button class="btn btn-primary"
					onclick="search(document.getElementById('rid').value)">Search</button>
				<button class="btn btn-primary"
					onclick="addToTable(document.getElementById('rid').value)">Add</button>
			</div>
		</div>
		<br>
		<div class="row">
			<div class="col-12">
				<div id="retailDetail"></div>
				<div id="anotherDetail"></div>
				<div id="paginate"></div>
				<ul id="pageNumbers" class="pagination">
				</ul>
			</div>
		</div>

		<div class="row">
			<div class="col-12">
				<div id="countDiv"></div>
				<button id="countBtn" class="btn btn-primary" onclick="count()">Count</button>
			</div>
		</div>

		<script>
			var list = [];
			paginate(0, 0, 0);
			function toggleOrderOfName(order) {
				if (order == 0) {
					paginate(0, 0, 0);
				} else if (order == 1) {
					paginate(0, 0, 1);
				}
			}
			function toggleOrderOfAddress(order) {
				if (order == 0) {
					paginate(0, 1, 0);
				} else if (order == 1) {
					paginate(0, 1, 1);
				}
			}
			function toggleOrderOfEmail(order) {
				if (order == 0) {
					paginate(0, 2, 0);
				} else if (order == 1) {
					paginate(0, 2, 1);
				}
			}
			function toggleOrderOfMobile(order) {
				if (order == 0) {
					paginate(0, 3, 0);
				} else if (order == 1) {
					paginate(0, 3, 1);
				}
			}
			function search(rid) {
				var xhttp = new XMLHttpRequest();
				var url = "http://localhost:8082/getRetailer/" + rid;
				xhttp.onreadystatechange = function() {
					if (this.readyState == 4 && this.status == 200) {
						var retailDetail = document
								.getElementById('retailDetail');
						r = JSON.parse(this.responseText);
						var myTable = "<table class='table table-hover'><tr class='table-primary'><th>Name</th><td>"
								+ r.name + "</td></tr>";
						myTable += "<tr><th>State</th><td>" + r.state
								+ "</td></tr>";
						myTable += "<tr><th>Country</th><td>" + r.country
								+ "</td></tr>";
						myTable += "<tr><th>pincode</th><td>" + r.pincode
								+ "</td></tr>";
						myTable += "<tr><th>Mobile</th><td>" + r.mobile
								+ "</td></tr>";
						myTable += "<tr><th>email</th><td>" + r.email
								+ "</td></tr>";
						myTable += "</table>";
						retailDetail.innerHTML = myTable;

					} else if (this.status == 500) {
						var retailDetail = document
								.getElementById('retailDetail');
						retailDetail.innerHTML = "No Records with this id is found"
					}
				};
				xhttp.open("GET", url, true);
				xhttp.send();
			}

			function addToTable(rid) {
				document.getElementById('countBtn').style.visibility = 'visible';
				var xhttp = new XMLHttpRequest();
				var url = "http://localhost:8082/addToTable/" + rid;
				xhttp.onreadystatechange = function() {
					if (this.readyState == 4 && this.status == 200) {
						var retailDetail = document
								.getElementById('retailDetail');
						retailDetail.innerHTML = "<p class='text-center'>Added Successfully</p>";
						paginate(0);
						count();

					} else if (this.status == 500) {
						var retailDetail = document
								.getElementById('retailDetail');
						retailDetail.innerHTML = "<p class='text-center'>No Records with this id is found</p>";
					}
				};
				xhttp.open("GET", url, true);
				xhttp.send();
			}

			function paginate(pageNo, column, order) {
				var xhttp = new XMLHttpRequest();
				var url;
				url = "http://localhost:8082/paginate?page=" + pageNo
						+ "&size=5";
				if (column == 0 && order == 0) {
					url = "http://localhost:8082/sortByNameAsc?page=" + pageNo
							+ "&size=5";
				} else if (column == 1 && order == 0) {
					url = "http://localhost:8082/sortByAddressAsc?page="
							+ pageNo + "&size=5";
				} else if (column == 2 && order == 0) {
					url = "http://localhost:8082/sortByEmailAsc?page=" + pageNo
							+ "&size=5";
				} else if (column == 3 && order == 0) {
					url = "http://localhost:8082/sortByMobileAsc?page="
							+ pageNo + "&size=5";
				} else if (column == 0 && order == 1) {
					url = "http://localhost:8082/sortByNameDesc?page=" + pageNo
							+ "&size=5";
				} else if (column == 1 && order == 1) {
					url = "http://localhost:8082/sortByAddressDesc?page="
							+ pageNo + "&size=5";
				} else if (column == 2 && order == 1) {
					url = "http://localhost:8082/sortByEmailDesc?page="
							+ pageNo + "&size=5";
				} else if (column == 3 && order == 1) {
					url = "http://localhost:8082/sortByMobileDesc?page="
							+ pageNo + "&size=5";
				}

				xhttp.onreadystatechange = function() {
					if (this.readyState == 4 && this.status == 200) {
						document.getElementById('countBtn').style.visibility = 'visible';
						var paginate = document.getElementById('paginate');
						var pageNumbers = document
								.getElementById('pageNumbers');
						r = JSON.parse(this.responseText);
						list = r.content;
						var myTable = "<p class='text-right small'>max. record limit is 5 per page</p>";
						myTable += "<table class='table table-hover'><tr class='table-primary'><th id='name'>Name<br><button class='badge badge-light' onclick='toggleOrderOfName(0)'>A</button><button class='badge badge-light' onclick='toggleOrderOfName(1)'>D</button></th><th id='address'>Address<br><button class='badge badge-light' onclick='toggleOrderOfAddress(0)'>A</button><button class='badge badge-light' onclick='toggleOrderOfAddress(1)'>D</button></th></th><th id='email'>Email<br><button class='badge badge-light' onclick='toggleOrderOfEmail(0)'>A</button><button class='badge badge-light' onclick='toggleOrderOfEmail(1)'>D</button></th></th><th id='mobile'>Mobile<br><button class='badge badge-light' onclick='toggleOrderOfMobile(0)'>A</button><button class='badge badge-light' onclick='toggleOrderOfMobile(1)'>D</button></th></th></tr>"
						for (var i = 0; i < list.length; i++) {
							var address = list[i].state + ' ' + list[i].country
									+ ' ' + list[i].pincode;
							myTable += "<tr><td>" + list[i].name + "</td><td>"
									+ address + "</td><td>" + list[i].email
									+ "</td><td>" + list[i].mobile
									+ "</td></tr>";
						}
						myTable += "</table>";
						paginate.innerHTML = myTable;
						var p = "<li class='page-item disabled'><a class='page-link' href=''#' >Page Numbers</a></li>";
						for (var i = 0; i < Math.ceil(r.totalElements / 5); i++) {
							p += "<li class='page-item'><button class='page-link' onclick='paginate("
									+ i
									+ ", "
									+ column
									+ " , "
									+ order
									+ ")'>"
									+ (i + 1) + "</button></li>";
						}
						pageNumbers.innerHTML = p;
						if (r.totalElements == 0) {
							document.getElementById('countBtn').style.visibility = 'hidden';
							var retailDetail = document
									.getElementById('retailDetail');
							var retailDetail = document
									.getElementById('paginate');
							paginate.innerHTML = "";
							retailDetail.innerHTML = "<p class='text-center'>No Records. Add new records...</p>"
						}
					}
				};
				xhttp.open("GET", url, true);
				xhttp.send();
			}

			function count() {
				var xhttp = new XMLHttpRequest();
				var t;
				var url = "http://localhost:8082/allDetails";
				xhttp.onreadystatechange = function() {
					if (this.readyState == 4 && this.status == 200) {
						t = JSON.parse(this.responseText);
						var counter = {};
						t.forEach(function(obj) {
							var key = JSON.stringify(obj.name);
							counter[key] = (counter[key] || 0) + 1;
						});
						var countDiv = document.getElementById('countDiv');
						console.log(counter)
						var myTable1 = "<table class='table table-hover'><tr class='table-primary'><th>Name</th><th>Count</th></tr>";
						for ( var key in counter) {
							myTable1 += "<tr><td>" + key + "</td><td>"
									+ counter[key] + "</td></tr>";
						}
						myTable1 += "</table>";
						countDiv.innerHTML = myTable1;
					} else if (this.status == 500) {
						var retailDetail = document
								.getElementById('retailDetail');
						retailDetail.innerHTML = "No Records with this id is found"
					}
				};
				xhttp.open("GET", url, true);
				xhttp.send();
			}
		</script>
	</div>

</body>
</html>