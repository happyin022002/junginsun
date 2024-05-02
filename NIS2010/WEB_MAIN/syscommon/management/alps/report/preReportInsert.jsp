<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>RD</title>
<script type="text/javascript">
	function rdinsert() {
		if (insertRD.rd_sub_sys_cd.value == "" || insertRD.rd_sub_sys_cd.value.indexOf(" ") > -1) {
			alert("모듈명을 선택해 주세요");
			return false;
		} else if (insertRD.fax_eml_div_cd.value == "" || insertRD.fax_eml_div_cd.value.indexOf(" ") > -1) {
			alert("RD종류를 선택해 주세요");
			return false;
		} else if (insertRD.rd_tmplt_nm.value == "" || insertRD.rd_tmplt_nm.value.indexOf(" ") > -1) {
			alert("파일명을 입력해 주세요");
			return false;
		} else if (insertRD.jb_tit_ctnt.value == "" || insertRD.jb_tit_ctnt.value.indexOf(" ") > -1) {
			alert("제목을 입력해 주세요");
			return false;
		} else if (insertRD.jb_desc.value == "" || insertRD.jb_desc.value.indexOf(" ") > -1) {
			alert("설명을 입력해 주세요");
			return false;
		}

		var formData = document.getElementById("insertRD");
		formData.action = "/hanjin/insertrpt.do";
		formData.submit();
	}
	function rdsearch() {
		if (insertRD.rd_sub_sys_cd.value == "" || insertRD.rd_sub_sys_cd.value.indexOf(" ") > -1) {
			alert("모듈명을 선택해 주세요");
			return false;
		}

		var formData = document.getElementById("insertRD");
		formData.action = "/hanjin/searchrpt.do"
		formData.target = "rdsearchframe"
		formData.submit();
	}
	function rdfax() {
		var formData = document.getElementById("faxRD");
		if (faxRD.fax_snd_no.value == "" || faxRD.fax_snd_no.value.indexOf(" ") > -1) {
			alert("조회년월일를 입력해주세요. ex)20130521");
			return false;
		}
		formData.action = "/hanjin/rdfax.do"
		formData.target = "rdsearchframe"
		formData.submit();
	}
	function rdeml() {
		var formData = document.getElementById("emlRD");
		if (emlRD.eml_snd_no.value == "" || emlRD.eml_snd_no.value.indexOf(" ") > -1) {
			alert("조회년월일를 입력해주세요. ex)20130521");
			return false;
		}
		formData.action = "/hanjin/rdeml.do"
		formData.target = "rdsearchframe"
		formData.submit();
	}
</script>
</head>
<body>
	<table>
		<tr>
			<form id="insertRD">
				<table border=1 cellspacing="1" cellpadding="1">
					<tr>
						<td bgcolor="FFFF99">RD 등록</td>
						<td><label for=rd_sub_sys_cd>모듈명 :</label> <select
							NAME=rd_sub_sys_cd>
								<option value=" ">모듈명</option>
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
						</select></td>
						<td><label for=fax_eml_div_cd>FAX/EMAIL :</label> 
						<select NAME=fax_eml_div_cd>
								<option value=" ">RD종류</option>
								<option value="A">A(메일팩스)</option>
								<option value="M">M(메일)</option>
								<option value="F">F(팩스)</option>
						</select></td>
						<td><label for=rd_tmplt_nm>RD파일명 :</label> <INPUT TYPE=TEXT NAME=rd_tmplt_nm></td>
						<td><label for=jb_tit_ctnt>제목 :</label> <INPUT TYPE=TEXT NAME=jb_tit_ctnt></td>
						<td><label for=jb_desc>설명 :</label> <INPUT TYPE=TEXT NAME=jb_desc></td>
						<td><input type="button" Name=insert style="font-size: 12pt; height: 25;" value="등록" onclick="rdinsert();"></td>
						<td><input type="button" Name=search style="font-size: 12pt; height: 25;" value="조회" onclick="rdsearch();"></td>
					</tr>
				</table>
		</form>
		</tr>
		<tr>
			<form id="faxRD">
				<table border=1 cellspacing="1" cellpadding="1">
					<tr>
						<td bgcolor="FFFF99">FAX RD 조회</td>
						<td><label for=fax_snd_no>조회년월일 :</label> <INPUT TYPE=TEXT NAME=fax_snd_no></td>
						<td><label for=rd_appl_cd>RD_APPL_CD :</label> <INPUT TYPE=TEXT NAME=rd_appl_cd></td>
						<td><label for=fax_proc_sts_cd>FAX_PROC_STS_CD :</label> <INPUT TYPE=TEXT NAME=fax_proc_sts_cd></td>
						<td><label for=ofc_cd>OFC_CD :</label> <INPUT TYPE=TEXT NAME=ofc_cd></td>
						<td><label for=fax_ip>FAX_IP :</label> <INPUT TYPE=TEXT NAME=fax_ip></td>
						<td><input type="button" Name="fax" style="font-size: 12pt; height: 25;" value="조회" onclick="rdfax();"></td>
					</tr>
				</table>
			</form>
		</tr>
		<tr>
			<form id="emlRD">
				<table border=1 cellspacing="1" cellpadding="1">
					<tr>
						<td bgcolor="FFFF99">EML RD 조회</td>
						<td><label for=eml_snd_no>조회년월일 :</label> <INPUT TYPE=TEXT NAME=eml_snd_no></td>
						<td><label for=rd_sub_sys_cd>RD_SUB_SYS_CD :</label> <INPUT TYPE=TEXT NAME=rd_sub_sys_cd></td>
						<td><label for=eml_proc_sts_cd>EML_PROC_STS_CD :</label> <INPUT TYPE=TEXT NAME=eml_proc_sts_cd></td>
						<td><label for=cre_usr_id>CRE_USR_ID :</label> <INPUT TYPE=TEXT NAME=cre_usr_id></td>
						<td><label for=smtp_ip>SMTP_IP :</label> <INPUT TYPE=TEXT NAME=smtp_ip></td>
						<td><input type="button" Name="eml"style="font-size: 12pt; height: 25;" value="조회"onclick="rdeml();"></td>
					</tr>
				</table>
			</form>
		</tr>
		<tr>
			<td colspan='2'><iframe name="rdsearchframe" frameborder=0 width=1550 height=800 scrolling="auto"></iframe></td>
		</tr>
	</table>
</body>
</html>