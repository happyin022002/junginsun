<%
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0043.jsp
*@FileTitle : Car Location Message Inquiry
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

    String r_row_size = request.getParameter("row_size");
    String r_cntr_no  = request.getParameter("cntr_no");
	String r_toDate   = request.getParameter("arr_dt1");
	String r_fmDate   = request.getParameter("arr_dt2");
	String r_method   = request.getMethod();
	boolean getDecision = false;
	
	if(("".equals(r_toDate) || "".equals(r_fmDate) || "".equals(r_cntr_no)   || "".equals(r_row_size) ) ||
	   (r_toDate == null    || r_fmDate == null    || r_cntr_no == null      || r_row_size == null    )       
	   ){
	       getDecision  = false;
	   }else{
		   getDecision  = true;
	   }

%>

<html>
<head>
<title>Welcome to YMS!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">

    function setupPage(){
        loadPage();
    }


    function calanderSetting(){
	            var cal = new ComCalendarFromTo();
	            cal.select(form.arr_dt1,  form.arr_dt2,  'yyyy-MM-dd');
	}
</script>
</head>
<%if(getDecision){%>
<body>
<%}else{%>
<body onLoad="setupPage();">
<%}%>
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
							<td width="100"><img class="nostar">Container No.</td>
							<td width="250"><input name="cntr_no" type="text" class="input" style="width:90; text-transform:uppercase;" maxlength="14" value=""  onBlur='javascript:this.value=this.value.toUpperCase();'  onChange="CheckDigit(this)"  onKeyUp="CheckDigit(this)" >&nbsp;<input name="cntr_tpsz_cd" type="text" class="input" style="width:30" readonly ></td>
							<td width="60">Duration</td>
							<td><input name="arr_dt1" type="text" dataformat="ymd"  required  onBlur='ComChkObjValid(this, false, false, true)' class="input" style="width:75" value="<%=fmDate%>">&nbsp;~&nbsp;<input name="arr_dt2" type="text" dataformat="ymd"  required  onBlur='ComChkObjValid(this, false, false, true)'  class="input" style="width:75; text-transform:uppercase;" value="<%=toDate%>"> 
							
							<img name="btns_calendar" class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" onClick="calanderSetting();" style="cursor:hand" >
							</td>
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
                             <script language="javascript">ComSheetObject('sheet1');</script>
                        </td></tr>
                    </table>
				<!-- : ( grid ) (E) -->


			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
		<!-- ####### TABLE '#D' ::: 'RIGHT' FRAME (END) ####### -->


	</td></tr>
</table>
<!-- TABLE '#B' : 'Left + Right Body' Table (E)nd -->
    </td></tr>
</table>
<!-- Outer Table (E)-->
</form>
<%
    String opCode   =  "<script>" +
	                   "var r_cntr_tpsz_cd = document.forms[0].cntr_tpsz_cd.value;" + 
	                   "remoteOperation('" + r_row_size + "','" + r_cntr_no + "','" + r_toDate + "','" + r_fmDate + "');" + 
					   "</script>" ;
%>
<%if(getDecision){%>
<%=opCode%>
<%}%>
</body>
</html>

