<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_9463.jsp
*@FileTitle : B/L Attachment
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.04.30 김병규
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg9463Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg9463Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	// Main에서 Parameter 받기
	String bkgNo = "";
	String polCd = "";
	String n3ptyOfcCd = "";
	String payrCustCntCd = "";
	String payrCustSeq = "";
	String oblIssOfcCd = "";
	String n3ptyBlChgTtlAmt = "";
	String frtTermCd = "";
	
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmBkg9463Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		bkgNo  = JSPUtil.getParameter(request, "bkg_no");
		polCd = JSPUtil.getParameter(request, "pol_cd");
		n3ptyOfcCd = JSPUtil.getParameter(request, "n3pty_ofc_cd");
		payrCustCntCd = JSPUtil.getParameter(request, "payr_cust_cnt_cd");
		payrCustSeq = JSPUtil.getParameter(request, "payr_cust_seq");
		oblIssOfcCd = JSPUtil.getParameter(request, "obl_iss_ofc_cd");
		n3ptyBlChgTtlAmt = JSPUtil.getParameter(request, "n3pty_bl_chg_ttl_amt");
		frtTermCd = JSPUtil.getParameter(request, "frt_term_cd");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>B/L Attachment</title>
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

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="pol_cd" value="<%=polCd%>"> 
<input type="hidden" name="n3pty_ofc_cd" value="<%=n3ptyOfcCd%>"> 
<input type="hidden" name="payr_cust_cnt_cd" value="<%=payrCustCntCd%>"> 
<input type="hidden" name="payr_cust_seq" value="<%=payrCustSeq%>"> 
<input type="hidden" name="obl_iss_ofc_cd" value="<%=oblIssOfcCd%>"> 
<input type="hidden" name="n3pty_bl_chg_ttl_amt" value="<%=n3ptyBlChgTtlAmt%>"> 
<input type="hidden" name="frt_term_cd" value="<%=frtTermCd%>"> 
<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;  B/L Attachment</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
		
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="90">Booking No.</td>
					<td><input type="text" name ='bkg_no' style="width:110;" class="input2" value="<%=JSPUtil.getParameter(request, "bkg_no")%>"></td>
				</tr> 
				</table>
							
				<!--  biz_1   (E) -->
			
				<!-- Grid_1 (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>				
				
				<!-- Grid_1 (E) -->		

		</td></tr></table>
		<!--biz page (E)--> 

<table class="height_5"><tr><td></td></tr></table>

</td></tr></table>
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

    	<!--Button (S) -->	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" id="btn_upload" name="btn_upload">File Upload</td>
					<td class="btn1_right"></td>	
				</tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" id="btn_delete" name="btn_delete">File Delete</td>
					<td class="btn1_right"></td>	
				</tr></table></td>	
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" id="btn_save" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>		
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"></td>	
				</tr></table></td>	
				
			</tr>
		</table></td>	
				
			</tr>
		</table>
    	<!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
			
<script language="javascript">ComUploadObject('upload1', '<=session.getId()%>');</script>
<!-- 개발자 작업  끝 -->
</form>
<iframe name="hiddenFrame" style="visibility:hiddden" height="0" width="0"></iframe>
</body>
</html>