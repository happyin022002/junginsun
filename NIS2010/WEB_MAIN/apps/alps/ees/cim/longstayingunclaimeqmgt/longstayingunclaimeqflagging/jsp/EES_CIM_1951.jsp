<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CIM_1951.jsp
*@FileTitle : OP Inventory for Pseudo Booking
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.01
*@LastModifier : 이영두
*@LastVersion : 1.0
* 2013.07.01 이영두
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.event.EesCim1951Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCim1951Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

    String cnmv_sts_cd = "";
    String cnmv_sts_nm = "";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.LongstayingUnclaimEQMgt.LongstayingUnclaimEQFlagging");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesCim1951Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
					
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Container Staying Days (Summary)</title>
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
<input type="hidden" name="pagerows">

<input type="hidden" name="inquiryLevel" value=""> 
<input type="hidden" name="location" value=""> 


<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	</table>
	
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
       	<tr><td class="btn1_bg">
		
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				</tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->

		<!--biz page (S)-->
		<!-- 1 (S) -->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="50">RHQ</td>
					<td width="150"><input type="text" class="input" name="rhq_cd" style="ime-mode:disabled" dataformat="engup" size="7" maxlength="6" fulfill  style="width:60;" class="input" value=""> <img class="cursor" src="img/btns_search.gif" name="btn_rhq_cd" width="19" height="20" border="0" align="absmiddle">
					</td>
					<td width="90"></td>					
					<td width="160">Booking Office</td>
					<td width="130"><input type="text" class="input" name="bkg_ofc_cd" style="ime-mode:disabled" dataformat="engup" size="7" maxlength="6" fulfill  style="width:60;" class="input" value=""> <img class="cursor" src="img/btns_search.gif" name="btn_bkg_ofc_cd" width="19" height="20" border="0" align="absmiddle">
					</td>
					<td width="300"></td>
					<td width="300"></td>
					<td width="300"></td>
				</tr>
				<tr><td style="height:1"></td></tr>
				</table>	
					
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="280">Search Option by Booking Wise</td>
					<td width="150">Booking Number</td>
					<td width=200><input type="text" class="input" name="bkg_no" style="ime-mode:disabled" dataformat="engup" size="13" maxlength="13" fulfill  style="width:120;" class="input" value="">
					</td>

					<td width="280">Search Option by Logistics Wise</td>
					<td width="100">OP Location</td>
					<td width="250"><input type="text" class="input" name="op_loc_cd" style="ime-mode:disabled" dataformat="engup" size="5" maxlength="5" fulfill  style="width:50;" class="input" value=""> <img class="cursor" src="img/btns_search.gif" name="btn_op_loc_cd" width="19" height="20" border="0" align="absmiddle">
					</td>
				</tr>
			
				<tr><td style="height:1"></td></tr>
				</table>
							
			    <table class="search" border="0" style="width:100%;"> 
				<tr class="h23"> 
				    <td width="260"></td>
					<td width="140">&nbsp;Customer Code</td>
					<td width="210">&nbsp;<input type="text" class="input" name="cust_cd" style="ime-mode:disabled" dataformat="engup" size="20" maxlength="8" fulfill  style="width:70;" class="input" value=""> <img class="cursor" src="img/btns_search.gif" name="btn_cust_cd" width="19" height="20" border="0" align="absmiddle">
					</td>
				    <td width="260"></td>
					<td width="100">Staying Days</td>
					<td width="220"><input type="text" class="input" name="stay_days" style="ime-mode:disabled" dataformat="int" size="5" maxlength="5" fulfill  style="width:40; text-align:right;" class="input" value="">&nbsp;&nbsp;or over
					</td>
				</tr> 
				<tr><td style="height:1"></td></tr>
				</table>
					
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23"> 
				    <td width="280">
					<td width="150">&nbsp;Customer Name</td>
					<td width="200"><input type="text" class="input" name="cust_nm" style="ime-mode:disabled" dataformat="engup" size="100" maxlength="200" fulfill  style="width:200;" class="input" value="">
					</td>
					<td width="280"><td>
					<td width="150"><td>
					<td width="200"><td>
				</tr> 
				</table>
				</table>	
						
			  </td></tr>
		</table> 
				<!--  biz_1   (E) -->

			
		<!-- 1 (E) -->
		
		<table class="height_8"><tr><td></td></tr></table>
		
		<!-- Tab ) (S) -->
     		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%> 
       		<tr><td width="100%">
						<script language="javascript">ComTabObject('tab1');</script>
						<!-- img src="img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
					</td></tr>
				</table>
		<!-- Tab ) (E) --> 			
			
			

			
			
<!--TAB  (S) -->
<div id="tabLayer" style="display:inline">			
		<!-- 2 (S) -->		
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
			
			<!-- Grid - 1 (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>			
			<!-- Grid - 1 (E) -->	
			
			</td></tr>
		</table>
		<!-- 2 (E) -->
</div>
<!--TAB  (E) -->		




<!--TAB  (S) -->
<div id="tabLayer" style="display:none">
		<!-- 2 (S) -->		
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
			
			<!-- Grid - 1 (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>			
			<!-- Grid - 1 (E) -->	
			
			
			</td></tr>
		</table>
		<!-- 2 (E) -->
</div>
<!--TAB  (E) --> 


</td></tr>
</table>

</form> 
</body>
</html>
