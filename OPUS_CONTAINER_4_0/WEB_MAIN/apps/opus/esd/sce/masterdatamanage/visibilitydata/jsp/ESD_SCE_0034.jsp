<%
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0034.jsp
*@FileTitle : Visibility Subscriber Information Search
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
%>

<%
	int rowSize = 50 ;
%>

<html>
<head>
<title>Welcome to OPUS!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">

    function setupPage(){

        loadPage();
    }

</script>
</head>

<body onLoad="setupPage();">

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>


		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->


		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
		<form name="form">
		<input type="hidden" name="f_cmd">
		<input type="hidden" name="row_size" value="<%=rowSize%>">
				<tr><td class="btn1_bg">

						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new">New</td><td class="btn1_right"></td></tr></table></td>
							<td class="btn1_line"></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
							<!-- Repeat Pattern -->

						</tr></table>

				</td></tr>
		</table>
		<!-- TABLE '#D' : ( Button : Main ) (E) -->









		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="7%">Customer</td>
							<td width="38%"><!-- select style="width:90;">&nbsp;
							<option value="0" selected>KR123456</option>
							<option value="1"></option>
							</select-->
							<input name="crm_cust_cd" type="text" class="input" style="width:90" value="">&nbsp;<input name="crm_cust_nm" type="text" class="input" style="width:160" value="" readonly></td>
							<td width="6%">S/C No.</td>
							<td><!-- select style="width:90;">&nbsp;
							<option value="0" selected>KR123456</option>
							<option value="1"></option>
							</select-->
							<input name="sc_no" type="text" class="input" style="width:90" value=""></td>
						</tr>

					</table>

				</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->


		<table class="height_10"><tr><td></td></tr></table>



		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
     	<table class="search" border="0">
			<tr>
				<td class="bg">
					<table class="height_10"><tr><td></td></tr></table>

                    <table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet');</script>
                        </td></tr>
                    </table>

				<!-- : ( Speed ) (E) -->

			</td></tr>
		</form>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
		<!-- ####### TABLE '#D' ::: 'RIGHT' FRAME (END) ####### -->
		<table class="height_10"><tr><td></td></tr></table>

    </td></tr>
</table>
<!-- Outer Table (E)-->

</body>
</html>

