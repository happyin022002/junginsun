<%
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0046.jsp
*@FileTitle : Train & Rail Car Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-16
*@LastModifier : Seong-mun Kang
*@LastVersion : 2.0
* 2006-11-16 Seong-mun Kang
* 1.0 최초생성
=========================================================*/
%>

<%@ page import="com.hanjin.framework.component.util.DateTime" %>

<%
	int    rowSize = 50 ;
	String toDate  = DateTime.getFormatString("yyyy-MM-dd") ;
	String fmDate  = DateTime.addMonths(toDate, -3, "yyyy-MM-dd") ;
%>
<html>
<head>
<title>Welcome to YMS!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">

    function setupPage(){

        loadPage();
    }

</script>
</head>

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="row_size" value="<%=rowSize%>">
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
								<tr><td class="btn1_bg">

										<table border="0" cellpadding="0" cellspacing="0">
										<tr>
											<!-- Repeat Pattern -->
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
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
							<td width="60">Duration</td>
							<td width="240"><input type="text" value="<%=fmDate%>" style="width:78 ; text-transform:uppercase;" name="arr_dt1"  maxlength="10"  dataformat="ymd"  required  onBlur='ComChkObjValid(this, false, false, true)' >&nbsp;~&nbsp;<input type="text" style="width:78" name="arr_dt2" value="<%=toDate%>" maxlength="10" dataformat="ymd"  required   onBlur='ComChkObjValid(this, false, false, true)' > <img name="btns_calendar" class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
							<td width="35">Train</td>
							<td width="100"><input name="trn_no" type="text" class="input" style="width:60; text-transform:uppercase;" maxlength="12" onBlur='javascript:this.value=this.value.toUpperCase();'></td>
							<td width="55">Flat Car</td>
							<td><input name="fcar_no" type="text" class="input" style="width:80; text-transform:uppercase;" maxlength="10" onBlur='javascript:this.value=this.value.toUpperCase();'></td>
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


					<!-- : ( grid ) (S) -->
                    <table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet');</script>
                        </td></tr>
                    </table>

				<!-- : ( grid ) (E) -->


			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->




    </td></tr>
</table>
<!-- Outer Table (E)-->
</form>
</body>
</html>

