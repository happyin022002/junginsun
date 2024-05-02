<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_FMS_0017.jsp
*@FileTitle : SDMS - Windows
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.11
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.09.11 정윤태
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
<%@ page import="com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event.EsmFms0017Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmFms0017Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EsmFms0017Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

	}catch(Exception e) {
		log.error(e.getMessage(),e);
	}
	
	String fletCtrtNo = JSPUtil.replaceForHTML(request.getParameter("flet_ctrt_no"));
	String vslCd = JSPUtil.replaceForHTML(request.getParameter("vsl_cd"));
	
	String vslEngNm = JSPUtil.replaceForHTML(request.getParameter("vsl_eng_nm"));
	String ownrNm = JSPUtil.replaceForHTML(request.getParameter("ownr_nm"));
	String custCntcd = JSPUtil.replaceForHTML(request.getParameter("cust_cnt_cd"));
	String custSeq = JSPUtil.replaceForHTML(request.getParameter("cust_seq"));
%>

<html>
<head>
<title>Stevedore Damage Management System</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<body  onLoad="setupPage();"> 

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="usr_id" value="<%=strUsr_id%>">
<input type="hidden" name="slp_ofc_cd" value="<%=strOfc_cd%>">
<input type="hidden" name="curr_cd">
<input type="hidden" name="inv_no">
<input type="hidden" name="direction">
<input type="hidden" name="rev_yrmon">

<input type="hidden" name="ownr_nm" value="<%=ownrNm%>">
<input type="hidden" name="cust_cnt_cd" value="<%=custCntcd%>">
<input type="hidden" name="cust_seq" value="<%=custSeq%>">

<!-- OUTER - POPUP (S)tart -->
<table width="900" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Stevedore Damage Management System</td></tr>
		</table>
		<!--Page Title, Historical (E)-->
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:884;"> 
				<tr class="h23">
					<td width="80">Contract No.</td>
					<td width="150"><input type="text" style="width:120;text-align:center;" class="input2" name="flet_ctrt_no" value="<%=fletCtrtNo%>" readonly></td>
					<td width="75">Vessel Code</td>
					<td width="220"><input type="text" style="width:54;text-align:center;" class="input2" name="vsl_cd" value="<%=vslCd%>" readonly>&nbsp;<input type="text" style="width:140;" class="input2" name="vsl_eng_nm" value=" <%=vslEngNm%>" readonly></td> 
					<td width="70">INV Status</td>   
					<td><select style="width:60;" name="app_flg">
						<option value="N" selected>No</option>
						<option value="A">All</option>
						<option value="Y">Yes</option>
						</select></td></tr>
				<tr class="h23">
					<td width="60">Period</td>
					<td colspan="4"><input type="text" style="width:80;text-align:center;" class="input" name="from_pay_dt" maxlength="8" dataformat="ymd">&nbsp;<img src="img/btns_calendar.gif" class="cursor" name="from_dt_cal" width="19" height="20" alt="" border="0" align="absmiddle">&nbsp;~&nbsp;<input type="text" style="width:80;text-align:center;" class="input" name="to_pay_dt" maxlength="8" dataformat="ymd">&nbsp;<img src="img/btns_calendar.gif" class="cursor" name="to_dt_cal" width="19" height="20" alt="" border="0" align="absmiddle"></td></tr>
				</table>
				<!--  Grid_button (S) -->
						<table width="100%" class="button"> 
	       					<tr><td class="btn2_bg">
								<table border="0" cellpadding="0" cellspacing="0"><tr>
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
									<td class="btn2" name="btn_retrieve">Retrieve</td>
									<td class="btn2_right"></td>
									</tr>
									</table></td>
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
									<td class="btn2" name="btn_new">New</td>
									<td class="btn2_right"></td>
									</tr>
									</table></td>
								</tr></table></td>
						</tr></table>
	    				<!-- Grid_button (E) -->
				<!--  biz_1  (E) -->
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				<!--  biz_2  (S) -->
				<!-- Grid  (S) -->
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table>
						<!-- Grid (E) -->

						<!--  Grid_button (S) -->
						<table width="100%" class="button"> 
	       					<tr><td class="btn2_bg">
								<table border="0" cellpadding="0" cellspacing="0"><tr>
									<!--td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
									<td class="btn2" name="btn_save">Save</td>
									<td class="btn2_right"></td>
									</tr>
									</table></td-->
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
									<td class="btn2" name="btn_confirm">Confirm</td>
									<td class="btn2_right"></td>
									</tr>
									</table></td>
								</tr></table></td>
								</tr></table>
	    				<!-- Grid_button (E) -->
				
				<!--  biz_2   (E) -->
				
				
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
</td></tr>
</table> 
	
			</td></tr>
		</table>
<table class="height_5"><tr><td></td></tr></table>
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       		<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right">
				</tr></table></td>
			</tr>
			</table></td>
		</tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
			
</form>			
</body>
</html>