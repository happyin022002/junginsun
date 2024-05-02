<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<HTML>
	
	<HEAD>
		<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=UTF-8">
		<TITLE>Sample JasperReport</TITLE>
		<link rel="stylesheet" type="text/css" href="css/jqgrid/jquery-ui-1.10.3.custom.css" />
   		<link rel="stylesheet" type="text/css" href="css/jqgrid/ui.jqgrid.css" />
		<script type="text/javascript" src="js/jqgrid/jquery-1.9.0.min.js"></script>
		<script type="text/javascript">
			var jq = jQuery.noConflict();
		</script>
		<script type="text/javascript" src="js/jqgrid/jquery-ui-1.10.3.custom.js"></script>
		<script type="text/javascript" src="js/jqgrid/grid.locale-en.js"></script>
		<script type="text/javascript" src="js/jqgrid/jquery.jqGrid.min.js"></script>
		<script type="text/javascript" src="sample/jasper/JasperSample.js"></script>
	</HEAD>

	<BODY>
		<form name="form" action="" method="post" target="">
			<input type="hidden" name="f_cmd">
			<table>
				<tr>
					<td>Pgm No.</td>
					<td colspan="3"><input name="pgm_no" type="text"></td>
				</tr>
				<tr>
					<td><input type="button" value="grid" onclick="searchAJAX();"></td>
					<td><input type="button" value="XML" onclick="searchXML();"></td>
					<td><input type="button" value="JSON" onclick="searchJSON();"></td>
					<td><input type="button" value="Export" onclick="exportVOS();"></td>
					<td><input type="button" value="SubReport" onclick="exportRowset();"></td>
				</tr>
			</table>
		</form>
		
		<div id="jaspergrid">
			<table id="main-grid"></table>
			<div id="pager"></div>
		</div>
		
	</BODY>
</HTML>