
<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : esm_bkg_0922.jsp
	 *@FileTitle : Office Search(Agent List) Popup Option
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.05.13
	 *@LastModifier : 김경섭
	 *@LastVersion : 1.0
	 * 2009.05.13 김경섭
	 * 1.0 Creation
	 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page
	import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page
	import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.event.EsmBkg0922Event"%>	
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0922Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	boolean bBtn_Disabled = true;
	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0922Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request
				.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
	  String ofc_cd   = JSPUtil.getParameter(request,"ofc_cd");
	  String custFunc       = JSPUtil.getNull(request.getParameter("func"));	  
%>
<html>
<head>
<title>Office Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">

	    if(!opener) opener = window.dialogArguments;
		<%
				if(!custFunc.equals("")) {					
		%>
		var callbackMethod = opener.<%= custFunc%>;
		//var callbackMethod = <%= custFunc%>;
		<%
				} else{
		%>
			var callbackMethod = null; 
		<%
				}
		%>
		
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body class="popup_bg" onLoad="setupPage();">
<div id="debug"></div>
<form name="form">
	<input type="hidden" name="f_cmd"> 
	<input type="hidden" name="pagerows"> 
	<input type="hidden" name="usr_id"      value="<%=strUsr_id%>">
	<input type="hidden" name="bl_prn_dvc_nm"      value="">
<!-- 개발자 작업	-->
<table width="100%" class="popup" cellpadding="10" border="0"> 
	<tr><td class="top"></td></tr>
	<tr>
		<td valign="top">
		<!--Page Title, Historical (S)-->
		
		<table width="100%" border="0">
		<tr><td class="title"><img src="./img/icon_title_dot.gif" align="absmiddle">&nbsp;Office Inquiry</td></tr>
		</table>
		<!--Page Title, Historical (E)--> <!-- : ( Search Options ) (S) -->

			<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">

				<!-- : ( Search Options ) (S) -->
 
				<table class="search" border="0"> 
				<tr class="h23">
					<td width="105">&nbsp;&nbsp;Office Code</td> 
					<td width=""><input type="text" style="width:60;text-align:center;" dataformat='engup' style="ime-mode:disabled" class="input1" value="<%=ofc_cd%>" name="ofc_cd"></td>
				</tr>
				</table>
			
				
			
				<table class="grid2" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="100" class="tr2_head">Name</td> 
					<td><input type="text" style="width:100%" dataformat='eng' style="ime-mode:disabled" class="noinput" value="" name="eng_nm"></td>
				</tr>
				<tr class="h23">
					<td width="" class="tr2_head">Address</td> 
					<td><textarea  style="width:100%;height:40;" name="address"></textarea></td>
				</tr>
				<tr class="h23">
					<td width="100" class="tr2_head">Country</td> 
					<td><input type="text" style="width:100%" class="noinput" value="" name="country"></td>
				</tr>
				<tr class="h23">
					<td width="100" class="tr2_head">Phone No.(Rep.)	</td> 
					<td><input type="text" style="width:100%" class="noinput" value="" name="phone_no"></td>
				</tr>
				<tr class="h23">
					<td width="100" class="tr2_head">Fax No.(Rep.)	</td> 
					<td><input type="text" style="width:100%" class="noinput" value="" name="fax_no"></td>
				</tr>
				
				</table>
				
			
			
				</td></tr>
			</table>
	<!-- : ( Search Options ) (E) -->

<table class="height_5"><tr><td></td></tr></table>
</td></tr>
</table>
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>

				<td>
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td class="btn1_left"></td>
									<td class="btn1" name="btn_Retrieve"  id="btn_Retrieve">Retrieve</td>
									<td class="btn1_right"></td>
								</tr>
							</table>
							</td>
				<td id="div_bkg">
							<table width="100%" border="0" cellpadding="0" cellspacing="0"
								class="button">
								<tr>
									<td class="btn1_left"></td>
									<td class="btn1" name="btn_copy">Copy</td>
									<td class="btn1_right"></td>
								</tr>
							</table>
							</td>
					<td class="btn1_line"></td>
				<td id="div_fax">
							<table width="100%" border="0" cellpadding="0" cellspacing="0"
								class="button">
								<tr>
									<td class="btn1_left"></td>
									<td class="btn1" name="btn_close">Close</td>
									<td class="btn1_right"></td>
								</tr>
							</table>
							</td>
			</tr>
		</table>
    <!--Button (E) -->
	</td></tr>
</table>

	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->


<!-- 개발자 작업  끝 -->
</form>
<div style="display:none" id="mainTable"><script language="javascript">ComSheetObject('sheet1');</script></div>
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp"%>