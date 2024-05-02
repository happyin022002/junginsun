<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0079.jsp
*@FileTitle : BKG Creation Main
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.14
*@LastModifier : KimByungKyu
*@LastVersion : 1.0
* 2009.05.14 KimByungKyu
* 1.0 Creation
===============================================================================
 History
 2010.09.13 이일민 [CHM-201005276-01] ALPS-[BKG/DOC]주요UI버턴-단축키 기능개발
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.core.controller.util.WebKeys"%>
<%@ page import="com.hanjin.framework.core.view.template.Screen"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.event.EsmBkg0079Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.core.controller.DefaultViewAdapter"%>

<%
    EsmBkg0079Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id	= "";
	String strUsr_nm	= "";
	String strUsr_ofc   = "";
	String sXml 		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.GeneralBookingConduct.GeneralBookingReceipt");
	
	String bkgNo   = "";
	String isPop   = "";
	String openTab = "";
	String troTab  = "";
	String shortcutTab = "";
	String isInquiry = "N";
	String fromBLIssue = "N";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();

		event = (EsmBkg0079Event)request.getAttribute("Event");

		bkgNo   = JSPUtil.getParameter(request, "bkg_no");
		isPop   = JSPUtil.getParameter(request, "isPop");
		openTab = JSPUtil.getParameter(request, "openTab");
		troTab  = JSPUtil.getParameter(request, "tro_tab");
		shortcutTab = JSPUtil.getParameter(request, "shortcutTab");

		Screen screen = (Screen) request.getAttribute(WebKeys.CURRENT_SCREEN);

		if (screen.getName().indexOf("Q") >= 0){
			isInquiry = "Y";
		}
		
		String fromUrl = JSPUtil.getNull(request.getParameter("pgmNo"));
		
		if (fromUrl.indexOf("ESM_BKG_0079-09") > -1){
			fromBLIssue = "Y";
		}
		
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		if(!"Y".equals(isPop)){
			DefaultViewAdapter adapter = new DefaultViewAdapter();
			sXml = adapter.makeXML(request, response);	
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<%if("Y".equals(isInquiry)){ %>
<title>Booking Inquiry</title>
<%}else{ %>
<title>Booking Creation</title>
<%} %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- input type="hidden" name="frm_change_flag" value="N" -->
<!-- input type="hidden" name="openTabIdx"      value="" -->
<input type="hidden" name="sXml" 			value="<%=JSPUtil.replace(sXml, "\"", "&quot;")%>">
<input type="hidden" name="openTab"         value="<%=openTab%>">
<input type="hidden" name="troTab"          value="<%=troTab%>">
<input type="hidden" name="isPop"           value="<%=isPop%>">
<input type="hidden" name="bkg_no"          value="<%=bkgNo%>" style="width:80;">
<input type="hidden" name="bl_no"           value=""           style="width:30;">
<input type="hidden" name="usr_id"          value="<%=strUsr_id%>">
<input type="hidden" name="usr_nm"          value="<%=strUsr_nm%>">
<input type="hidden" name="usr_ofc"         value="<%=strUsr_ofc%>">
<input type="hidden" name="ca_flg"          value="N" style="width:30;">
<input type="hidden" name="bdr_flg"         value="N" style="width:30;">
<input type="hidden" name="ca_exist_flg"    value="N" style="width:30;"><!-- CA 데이타가 존재 여부  -->
<input type="hidden" name="ca_rsn_cd"       value=""  style="width:30;"><!-- CA ReasonCd : 초기화 -->
<input type="hidden" name="ca_remark"       value=""  style="width:30;"><!-- CA Remark   : 초기화  -->
<input type="hidden" name="isInquiry"       value="<%=isInquiry%>">
<input type="hidden" name="fromBLIssue"       value="<%=fromBLIssue%>">
<input type="hidden" name="shortcutTab"     value="<%=shortcutTab%>">
<input type="hidden" name="bcc_exist_flg"   value="">
<!-- Groupmail시 반영될 Hidden --> 
<!--<input type="hidden" name="gw_subject">
<input type="hidden" name="gw_contents">
<input type="hidden" name="gw_template" value="ESM_BKG_0079T.html">
<input type="hidden" name="gw_args" value="title;">
<input type="hidden" name="gw_args" value="text;">-->

<input type="hidden" name="gw_subject">
<input type="hidden" name="gw_contents">
<input type="hidden" name="gw_template" value="ESM_BKG_COMM_01T.html">
<input type="hidden" name="gw_args" value="reqcontents;">

<%

	String mainPage = JSPUtil.getNull(request.getParameter("mainPage"));
%>
<% 
if(mainPage.equals("true")){
%>


<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top: 2; padding-left: 5; padding-right:5;" >
            
                <tr>
                    <td valign="top">
                        <!--Page Title, Historical (S)-->
                        <table width="100%" border="0" cellpadding="0" cellspacing="0"
                               class="title">
                            <tr>
                                <td class="history"><img src="img/icon_history_dot.gif"  align="absmiddle"><span id="navigation"></span></td>
                            </tr>
                            <tr>
                                <td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td>
                            </tr>

                        </table>
                        <!--Page Title, Historical (E)--> <!-- Grid BG Box  (S) -->
<%
}else {
%>     
		<table width="100%" class="popup" cellpadding="10" border="0"> 
			<tr><td class="top"></td></tr>
			<tr>
				<td valign="top">
					<table width="100%" border="0">
					<tr><td height="79" class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;<span id="title"></span></td></tr>
					</table>
<%
}
%>                   
<!-- 개발자 작업	-->
<!-- <table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><%// if("Y".equals(isInquiry)){
																							%> Booking Inquiy<% 
																					// }else{ 
																					  		%>Booking Creation<%
																					// } %></td></tr>
	</table> -->
	
	<!--Page Title, Historical (E)-->

	<!--Button (S) -->
		<table width="998" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td id="btn_History"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_History">History</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td id="btn_BLPreview"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_BLPreview">B/L Preview</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>				
				<td id="btn_CAIssue"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_CAIssue">C/A &nbsp;Issue</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td id="btn_CAReason"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_CAReason">C/A &nbsp;Reason</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>	
				<td id="btn_CACancel"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_CACancel">C/A &nbsp;Cancel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>	
				<td id="btn_CAConfirm"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_CAConfirm">C/A &nbsp;Confirm</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>	
				<td id="btn_CAInquiry"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_CAInquiry">C/A &nbsp;Inquiry</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td id="btn_BkgAttach"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_BkgAttach">Attachment</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
		<!-- Tab ) (S) -->
   		<table class="tab" border="0" cellpadding="0" cellspacing="0" style="width:998;" > 
     		<tr><td width="100%">
					<script language="javascript">ComTabObject('tab1')</script>
					<!-- img src="img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
				</td></tr>
		</table>
		<!-- Tab ) (E) -->
			
   		<table class="iframe" border="0" cellpadding="0" cellspacing="0" style="width:998px;" >
     		<tr><td width="100%">
				<!-- iframe name="outerFrame" id="outerFrame" src="" style="width:998px;height:640px;" frameborder="0" marginwidth="0" marginheight="0" scrolling="no"></iframe>
				
		<!-- Tab ) (E) --> <!-- iFrame (S) -->
		<div id="tabLayer" style="display: none">
		<iframe name="t1frame" id="t1frame" style="width:998px;height:640px;" frameborder="0" marginwidth="0" marginheight="0" scrolling="no" src="about:blank" onload="return setForceFocus()"></iframe></div>
		<div id="tabLayer" style="display: none">
		<iframe name="t2frame" id="t2frame" style="width:998px;height:640px;" frameborder="0" marginwidth="0" marginheight="0" scrolling="no" src="about:blank" onload="return setForceFocus()"></iframe></div>
		<div id="tabLayer" style="display: none">
		<iframe name="t3frame" id="t3frame" style="width:998px;height:640px;" frameborder="0" marginwidth="0" marginheight="0" scrolling="no" src="about:blank" onload="return setForceFocus()"></iframe></div>
		<div id="tabLayer" style="display: none">
		<iframe name="t4frame" id="t4frame" style="width:998px;height:710px;" frameborder="0" marginwidth="0" marginheight="0" scrolling="no" src="about:blank" onload="return setForceFocus()"></iframe></div>
		<div id="tabLayer" style="display: none">
		<iframe name="t5frame" id="t5frame" style="width:998px;height:900px;" frameborder="0" marginwidth="0" marginheight="0" scrolling="no" src="about:blank" onload="return setForceFocus()"></iframe></div>
		<div id="tabLayer" style="display: none">
		<iframe name="t6frame" id="t6frame" style="width:998px;height:640px;" frameborder="0" marginwidth="0" marginheight="0" scrolling="no" src="about:blank" onload="return setForceFocus()"></iframe></div>
		<div id="tabLayer" style="display: none">
		<iframe name="t7frame" id="t7frame" style="width:998px;height:640px;" frameborder="0" marginwidth="0" marginheight="0" scrolling="no" src="about:blank" onload="return setForceFocus()"></iframe></div>
		<div id="tabLayer" style="display: none">
		<iframe name="t8frame" id="t8frame" style="width:998px;height:650px;" frameborder="0" marginwidth="0" marginheight="0" scrolling="no" src="about:blank" onload="return setForceFocus()"></iframe></div>
		<div id="tabLayer" style="display: none">
		<iframe name="t9frame" id="t9frame" style="width:998px;height:660px;" frameborder="0" marginwidth="0" marginheight="0" scrolling="no" src="about:blank" onload="return setForceFocus()"></iframe></div>
		<div id="tabLayer" style="display: none">
		<iframe name="t10frame" id="t10frame" style="width:998px;height:640px;" frameborder="0" marginwidth="0" marginheight="0" scrolling="no" src="about:blank" onload="return setForceFocus()"></iframe></div>
		<div id="tabLayer" style="display: none">
		<iframe name="t11frame" id="t11frame" style="width:998px;height:640px;" frameborder="0" marginwidth="0" marginheight="0" scrolling="no" src="about:blank" onload="return setForceFocus()"></iframe></div>		
		<div id="tabLayer" style="display: none">
		<iframe name="t12frame" id="t12frame" style="width:998px;height:640px;" frameborder="0" marginwidth="0" marginheight="0" scrolling="no" src="about:blank" onload="return setForceFocus()"></iframe></div>		
		<!-- iFrame (E) -->				
			</td></tr>
		</table>
		<!-- Grid  (S) -->
		<table width="50%" id="mainTable"> 
			<tr>
				<td width="100%">
					<script language="javascript">ComSheetObject('h1sheet1');</script>
				</td>
			</tr>
		</table>
		<!-- Grid (E) -->
<%if(!"Y".equals(isPop)){ %>

<%
if(!mainPage.equals("true")){
%>
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
			
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       		<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    	<tr>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td>
										<td class="btn1" name="btn_Close" onClick="self.close()">Close</td>
										<td class="btn1_right"></td>
									</tr>
								</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<script>
	if(typeof(document.getElementById("title")) != "undefined"){
		document.getElementById("title").innerHTML = curTitle;
		document.body.className ="popup_bg";
	}
</script>
<%
}
%>
<%} %>
	<!-- </td></tr>
</table> -->

<!-- 개발자 작업  끝 -->
</td></tr></table>
</td></tr></table>
</form>
<span id="prd_form"></span>
</body>
</html>