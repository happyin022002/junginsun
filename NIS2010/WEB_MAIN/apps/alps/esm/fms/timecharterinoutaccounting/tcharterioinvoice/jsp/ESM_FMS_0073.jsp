<%
/*=========================================================
* Copyright(c) 2009 CyberLogitec
* @FileName : ESM_FMS_0073.jsp
* @FileTitle : Offhire Expenses from VMS
* Open Issues :
* Change history :
* @LastModifyDate : 2009.05.20
* @LastModifier : 정윤태
* @LastVersion : 1.0
* 2009.05.20 정윤태
* 1.0 최초 생성
=========================================================*/
%>

<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event.EsmFms0073Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmFms0073Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String strUsr_id = "";
	Logger log = Logger.getLogger("com.hanjin.apps.TimeCharterInOutAccounting.TCharterIOInvoice");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	strUsr_id = account.getUsr_id();
	   	
	   	event = (EsmFms0073Event)request.getAttribute("Event");
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
%>

<html>
<head>
<title>Offhire Expenses from VMS</title>
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

<body class="popup_bg" onLoad="setupPage();"> 
<form name="form"> 
<input type="hidden" name="f_cmd">
<input type="hidden" name="ibflag">

<!-- OUTER - POPUP (S)tart -->
<table width="900" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Off-Hire Expenses from VMS </td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:884;"> 
				<tr class="h23">
					<td width="80">Contract No.</td>
					<td width="140"><input type="text" style="width:120;text-align:center;" class="input2" name="flet_ctrt_no" value="<%=fletCtrtNo%>" readonly></td>
					<td width="75">Vessel Code</td>
					<td width="218"><input type="text" style="width:54;text-align:center;" class="input2" name="vsl_cd" value="<%=vslCd%>" readonly>&nbsp;<input type="text" style="width:140;" class="input2" name="vsl_eng_nm" value="<%=vslEngNm%>" readonly></td> 
					<td width="90">Accident Type</td>
					<td width="125">&nbsp;<select style="width:105;" name="flet_acc_tp_cd">
						<option value="" selected>All</option></td>
					<td width="95">FMS Approval</td>   
					<td><select style="width:60;" name="csr_slp_flg">
						<option value="N" selected>No</option>
						<option value="">All</option>
						<option value="Y">Yes</option>
						</select></td></tr>
				<tr class="h23">
					<td width="70">Off Hire Dt.</td>
					<td colspan="4"><input type="text" style="width:80;text-align:center;" class="input" name="offh_dt" maxlength="8" dataformat="ymd">&nbsp;<img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="from_dt">&nbsp;~&nbsp;<input type="text" style="width:80;text-align:center;" class="input" name="onh_dt" maxlength="8" dataformat="ymd">&nbsp;<img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="to_dt"></td></tr>
				</table>
				<!--  biz_1  (E) -->
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
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
									<td class="btn2" name="btn_price_retrieve">Price Retrieve</td>
									<td class="btn2_right"></td>
									</tr>
								</table></td><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
									<td class="btn2" name="btn_confirm">Confirm</td>
									<td class="btn2_right"></td>
									</tr>
								</table></td>
									<!-- 
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
									<td class="btn2" name="btn_confirm">Confirm</td>
									<td class="btn2_right"></td>
									</tr>
								</table></td>-->
							</tr></table>
	    				<!-- Grid_button (E) -->
				
				<!--  biz_2   (E) -->
				
				
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
	<table class="height_5"><tr><td></td></tr></table>
</td></tr>
</table> 
	
			</td></tr>
		</table>
	
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
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
			
</form>			
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp"%>