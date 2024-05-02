<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_EAS_0977.jsp
*@FileTitle : Change Detail Attachment
*Open Issues :
*Change history :
*@LastModifyDate : 2017-05-16
*@LastModifier : 이선묵
*@LastVersion : 1.0
* 2017-05-16 이선묵
* 1.0 Creation
*----------------------------------------------------------
* History
=========================================================*/
%>


<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.common.fileattach.event.EsdTrs0977Event"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%
	EsdTrs0977Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String mdl_tp_cd		= StringUtil.xssFilter(request.getParameter("mdl_tp_cd"))!=null&&!StringUtil.xssFilter(request.getParameter("mdl_tp_cd")).equals("")?StringUtil.xssFilter(request.getParameter("mdl_tp_cd")):""; 
	String atch_file_lnk_id	= StringUtil.xssFilter(request.getParameter("atch_file_lnk_id"))!=null&&!StringUtil.xssFilter(request.getParameter("atch_file_lnk_id")).equals("")?StringUtil.xssFilter(request.getParameter("atch_file_lnk_id")):""; 
	String attchRow		    = StringUtil.xssFilter(request.getParameter("attchRow"))!=null&&!StringUtil.xssFilter(request.getParameter("attchRow")).equals("")?StringUtil.xssFilter(request.getParameter("attchRow")):"";
	String call_menu_id		= StringUtil.xssFilter(request.getParameter("call_menu_id"))!=null&&!StringUtil.xssFilter(request.getParameter("call_menu_id")).equals("")?StringUtil.xssFilter(request.getParameter("call_menu_id")):"";
	String key1		        = StringUtil.xssFilter(request.getParameter("key1"))!=null&&!StringUtil.xssFilter(request.getParameter("key1")).equals("")?StringUtil.xssFilter(request.getParameter("key1")):""; 
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsdTrs0977Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
	        strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>TRS File Attachment</title>
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

<body class="popup_bg" onLoad="setupPage();" onUnLoad="fnRtnFileY();">
<form name="form">
<input type="hidden" name="attchRow"         value = "<%=attchRow %>">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="mdl_tp_cd" 		 value = "<%=mdl_tp_cd %>">
<input type="hidden" name="atch_file_lnk_id" value = "<%=atch_file_lnk_id %>">
<input type="hidden" name="call_menu_id"     value = "<%=call_menu_id %>">
<input type="hidden" name="key1"             value = "<%=key1 %>">

<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
			<tr>
				<td class="title">
					<img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;  File Attachment
				</td>
			</tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr>
       			<td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:100%;"> 
					<tr class="h23">
						<td><input type="hidden" name ='eac_no' style="width:110;" class="input2" value="<%=JSPUtil.getParameter(request, "inv_no")%>"></td>
						<td class="sm"  style= "color:#CC3D3D;text-align:right">File Maximun Size 5.0 MB. </td>
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
					<td class="btn1" id="btng_upload" name="btng_upload">File Upload</td>
					<td class="btn1_right"></td>	
				</tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" id="btng_remove" name="btng_remove">File Delete</td>
					<td class="btn1_right"></td>	
				</tr></table></td>	
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btng_close">Close</td>
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