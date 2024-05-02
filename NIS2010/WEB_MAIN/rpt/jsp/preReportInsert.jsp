<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>RD Insert</title>
<script type="text/javascript">
function callServer(){
	var formData = document.getElementById("form");
	formData.submit();
}
</script>
</head>
<body>
<form id="form" action="/hanjin/insertrpt.do">
	<fieldset>
	<legend><h2>RD Insert Test Page</h2></legend>
		<ol>
			<li>
				RD_SUB_SYS_CD
				<select NAME=rd_sub_sys_cd>
					<option value="NULL">------</option>
					<option value="BKG">BKG</option>
					<option value="OPF">OPF</option>
					<option value="COM">COM</option>
					<option value="SCE">SCE</option>
					<option value="EQR">EQR</option>
					<option value="TRS">TRS</option>
					<option value="TPB">TPB</option>
					<option value="CTM">CTM</option>
					<option value="JOO">JOO</option>
					<option value="TES">TES</option>
					<option value="INV">INV</option>
					<option value="DMT">DMT</option>
					<option value="ETS">ETS</option>
				</select>
			</li>
			<li>
				FAX_EML_DIV_CD
				<select NAME=fax_eml_div_cd>
					<option value="A">A</option>
					<option value="M">M</option>
					<option value="F">F</option>
				</select>
			</li>
			<li>
				RD_TMPLT_NM<INPUT TYPE=TEXT NAME=rd_tmplt_nm>
			</li>
			<li>
				JB_TIT_CTNT<INPUT TYPE=TEXT NAME=jb_tit_ctnt>
			</li>
			<li>
				JB_DESC<INPUT TYPE=TEXT NAME=jb_desc>
			</li>
		</ol>
		</fieldset>
		<fieldset>
			<input type="button" value="insert" onclick="callServer();">
		</fieldset>
</form>
</body>
</html>