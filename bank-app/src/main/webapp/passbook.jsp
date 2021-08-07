<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
    <%@ page import="com.techlab.model.Transaction" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Passbook</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
</head>
<body>
<h1>Transaction List</h1>
<%
	List<Transaction> transactions=(List<Transaction>)request.getAttribute("transactionList");
	int count=transactions.size();
	out.println("<h3> No of Transactions Performed : " + count + "</h3>");
	out.print("<table class = 'table table-striped table-hover table-bordered'>" +
			"<thead>" +
					"<tr>" + 
						"<th>Name</th>" +
						"<th>Amount</th>" +
						"<th>Type</th>" +
					"</tr>" + 
			"</thead>");
	out.print("<tbody>");
	for (Transaction transaction : transactions)
	{
	out.print("<tr>");
		out.print("<td>" + transaction.getName() + "</td>");
		out.print("<td>" + transaction.getAmount() + "</td>");
		out.print("<td>" + transaction.getType() + "</td>");
	out.print("</tr>");
	}
	out.print("</tbody>");
	out.print("</table>");
%>
<button onclick="exportTableToCSV('passbook.csv')" class="btn btn-primary">Export Passbook</button>
<script>
function downloadCSV(csv, filename) {
    var csvFile;
    var downloadLink;

    csvFile = new Blob([csv], {type: "text/csv"});

    downloadLink = document.createElement("a");

    downloadLink.download = filename;

    downloadLink.href = window.URL.createObjectURL(csvFile);

    downloadLink.style.display = "none";

    document.body.appendChild(downloadLink);

    downloadLink.click();
}
function exportTableToCSV(filename) {
    var csv = [];
    var rows = document.querySelectorAll("table tr");
    
    for (var i = 0; i < rows.length; i++) {
        var row = [], cols = rows[i].querySelectorAll("td, th");
        
        for (var j = 0; j < cols.length; j++) 
            row.push(cols[j].innerText);
        
        csv.push(row.join(","));        
    }

    downloadCSV(csv.join("\n"), filename);
}

</script>
</body>
</html>