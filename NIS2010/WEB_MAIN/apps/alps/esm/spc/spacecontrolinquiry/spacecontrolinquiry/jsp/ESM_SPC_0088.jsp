<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0088.jsp
*@FileTitle : T/S Plan Guide Attachment
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.21
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2016.04.21 이혜민
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
<%@ page import="com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event.EsmSpc0088Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSpc0088Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	// Main에서 Parameter 받기
	String repTrdCd = "";
	String repSubTrdCd = "";
	String rlaneCd = "";
	String vvdCd = "";
	String irrPortCd = "";
	String irrYdCd = "";
	String plnSeq = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmSpc0088Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		repTrdCd 	= JSPUtil.getParameter(request, "rep_trd_cd");
		repSubTrdCd = JSPUtil.getParameter(request, "rep_sub_trd_cd");
		rlaneCd 	= JSPUtil.getParameter(request, "rlane_cd");
		vvdCd 		= JSPUtil.getParameter(request, "vvd_cd");
		irrPortCd 	= JSPUtil.getParameter(request, "irr_port_cd");
		irrYdCd 	= JSPUtil.getParameter(request, "irr_yd_cd");
		plnSeq	 	= JSPUtil.getParameter(request, "pln_seq");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>T/S Plan & Guide Attachment</title>
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
<input type="hidden" name="rep_trd_cd" value="<%=repTrdCd%>"> 
<input type="hidden" name="rep_sub_trd_cd" value="<%=repSubTrdCd%>"> 
<input type="hidden" name="rlane_cd" value="<%=rlaneCd%>"> 
<input type="hidden" name="vvd_cd" value="<%=vvdCd%>"> 
<input type="hidden" name="irr_port_cd" value="<%=irrPortCd%>"> 
<input type="hidden" name="irr_yd_cd" value="<%=irrYdCd%>">
<input type="hidden" name="pln_seq" value="<%=plnSeq%>"> 

<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;T/S Plan & Guide Attachment</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
		
				<!--  biz_1  (S) -->
			<!--	<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="90">VVD</td>
					<td><input type="text" name ='vvd_cd' style="width:110;" class="input2" value="<%=JSPUtil.getParameter(request, "vvd_cd")%>"></td>
				</tr> 
				</table>
				-->
							
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