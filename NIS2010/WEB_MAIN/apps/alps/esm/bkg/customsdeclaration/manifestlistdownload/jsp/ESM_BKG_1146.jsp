<%
/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_1146.jsp
 *@FileTitle : ESM_BKG_1146
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.05.24
 *@LastModifier : 김보배
 *@LastVersion : 1.0
 * 2012.05.24 김보배
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event.EsmBkg1146Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1146Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag	= "";
	String codeList		= "";
	String pageRows		= "100";

	String strUsr_id	= "";
	String strUsr_nm	= "";
	String strPgmNo     = "";
	String strBlNo      = "";
	String strPolCd		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg1146Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		strBlNo = JSPUtil.getNull(request.getParameter("bl_no"));
        strPgmNo = JSPUtil.getNull(request.getParameter("pgmNo"));
        strPolCd = JSPUtil.getNull(request.getParameter("pol_cd"));

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>ESM_BKG_1146</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
	
	function endPage() {
		doActionIBSheet(sheetObjects[0], document.form, COMMAND01);
	}
	
</script>
</head>

<body class="popup_bg" onLoad="setupPage();" onbeforeunload="endPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="pol_cd" value="<%=strPolCd%>">
<input type="hidden" name="pgm_no" value="<%=strPgmNo%>">
<input type="hidden" name="cnt_cd" value="">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> Previous Doc Reference No. Pop-up </span></td></tr>
		</table>	
		<!-- : ( Title ) (E) -->
		
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
			
				<!--  biz_1 (S) -->
				<table class="search" border="0" style="width:500;">
				<tr class="h23">
					<td width="50">B/L No.</td>
					<td width="100">
						<input type="text" name="bl_no" style="width:110; ime-mode: disabled;" class="input2" value="<%=strBlNo%>" dataformat="eng" maxlength="12" caption="B/L No." Readonly>
					</td>
					<td width="300"></td>
				</tr>
				</table>
				
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) -->		
				
				<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"  id="tb_RowAdd"> 
       			<tr><td class="btn2_bg">
       				<table border="0" cellpadding="0" cellspacing="0">
		    		<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_RowAdd">Row Add</td>
							<td class="btn2_right"></td>
						</tr></table></td>
					</tr></table>
				</td></tr>
				</table>

			</td></tr>
		</table>
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
		    <tr>
		    <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
				</tr></table></td>
		    <td id ="td_save"><table width="70" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Save</td>
					<td class="btn1_right">
				</tr></table></td>
			<td><table width="70" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Select">Select</td>
					<td class="btn1_right">
				</tr></table></td>	
			<td class="btn1_line"></td>
			<td><table width="70" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right">
				</tr></table></td>
			</tr>
		</table></td>
			</tr>
		</table>
    	<!--Button (E) -->
	
	</td></tr>
</table>
</form>
</body>
</html>