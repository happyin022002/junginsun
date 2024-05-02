<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_1025.jsp
*@FileTitle : Booking split_TRO/O Split
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.event.EsmBkg1025Event"%>
<%@ page import="org.apache.log4j.Logger" %>
 

<%
	EsmBkg1025Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strBkg_no		= "";
	String strSplit_Reason  = "";
	String strSplitCntrSplitNo		= "";
	String strLastSplitNo = "";
	String strOrgSplit="";
	String strValidateSplitNo="";
	String strBkgSplitNo ="";
	 
	int iSplitCount =0;
 
	Logger log = Logger.getLogger("com.clt.apps.GeneralBookingConduct.GeneralBookingSplitCombine");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg1025Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		strBkg_no = event.getBkgBlNoVO().getBkgNo();
		strSplit_Reason = event.getSplitReason();  //M:Memo C:Customer
		iSplitCount = (event.getSplitCnt().length()<1)? 0:Integer.parseInt(event.getSplitCnt())+Integer.parseInt(event.getLastSplitNo());
		strSplitCntrSplitNo = event.getSplitCntrSplitNo();
		strLastSplitNo =event.getLastSplitNo();
		strOrgSplit = event.getOrgSplit();
		strValidateSplitNo =  event.getValidateSplitNo();
		strBkgSplitNo = event.getBkgSplitNo();
	 
		 
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Booking split_TRO/O Split</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="bkg_no" value="<%=strBkg_no%>">
<input type="hidden" name="splitCnt" value="<%=iSplitCount%>"> 
<input type="hidden" name="splitReason" value="<%=strSplit_Reason%>">
<input type="hidden" name="splitCntrSplitNo" value="<%=strSplitCntrSplitNo%>">
<input type="hidden" name="lastSplitNo" value="<%=strLastSplitNo%>">
<input type="hidden" name="orgSplit" value="<%=strOrgSplit%>">
<input type="hidden" name="validateSplitNo" value="<%=strValidateSplitNo%>">
<input type="hidden" name="bkgsplitno" value="<%=strBkgSplitNo%>"> 


<!-- OUTER - POPUP (S)tart -->
<table width="500" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; TRO/O Split</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
       		
       			
		<!-- : ( Grid ) (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject1('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- : ( Grid ) (E) -->	
				
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
</td></tr>
</table> 

<table class="height_5"><tr><td></td></tr></table>
	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_ok">OK</td>
					<td class="btn1_right">
				</tr></table></td>
			<td class="btn1_line"></td>		
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
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
<%@include file="/bizcommon/include/common_opus.jsp"%>