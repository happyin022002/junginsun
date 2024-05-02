<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0801.jsp
*@FileTitle : TPB Duplication Check
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.31
*@LastModifier : 박성진
*@LastVersion : 1.1
* 2009.07.17 Sun, CHOI		1.0 Creation
* 2009.07.31 Park Sung-Jin	1.1 ALPS Migration
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.tpb.candidatemanage.manualregister.event.EsdTpb0801Event"%>
<%@ page import="com.hanjin.apps.alps.esd.tpb.common.TPBUtils"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdTpb0801Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.CandidateManage.ManualRegister");
	
	String s_if_ofc_cd = JSPUtil.getNull(request.getParameter("s_if_ofc_cd")); 
	String s_eq_no = JSPUtil.getNull(request.getParameter("s_eq_no")); 
	String s_bkg_no = JSPUtil.getNull(request.getParameter("s_bkg_no")); 
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsdTpb0801Event)request.getAttribute("Event");
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
<title>TPB Duplication Check</title>
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
<body onLoad="setupPage();">
<form method="post" name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="s_ofc_cd" value="<%=s_if_ofc_cd%>"> 
<input type="hidden" name="s_eq_no" value="<%=s_eq_no%>"> 
<input type="hidden" name="s_bkg_no" value="<%=s_bkg_no%>"> 

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
	<tr><td valign="top">
	<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td class="bodyright">
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"></td></tr>
			<tr><td class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;TPB Duplication Check</td></tr>
		</table>
		<!--Page Title, Historical (E)-->

		<table class="search"> 
			<tr>
				<td>			
					Please check below whether your TPB is already created.
				</td>
			</tr>
		</table>
				
		<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				
		<!-- Grid (S) -->
		<table class="search"> 
       		<tr>
       			<td class="bg">
					<table width="100%"  id="mainTable">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
				<!-- Grid (E) -->	
				</td>
			</tr>
		</table>
		<!-- 1 (E) -->	
		<!--biz page (E)-->
				
						
			<!-- TABLE '#D' : ( Search Options ) (E) --> 	
		</td></tr>
	</table>
</td></tr>
</table>

<!-- : ( Button : Sub ) (S) -->
<table width="100%" class=sbutton> 
   <tr><td height="71" class="popup">
           <table border="0" cellpadding="0" cellspacing="0">
                <tr><td>                      
                 <!—Row Add   Button (S) -->
                       <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					   		<tr>
					   			<td class="btn1_left"></td>
					   			<td class="btn1" name="btn_save">Save</td>
					   			<td class="btn1_right"></td>
					   		</tr>
                       </table>
                 <!—Row Add   Button (E) -->
              </td>
              <td>                      
                 <!—Row Add   Button (S) -->
                       <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
					   			<td class="btn1_left"></td>
					   			<td class="btn1" name="btn_close">Close</td>
					   			<td class="btn1_right"></td>
					   		</tr>
                       </table>
                 <!—Row Add   Button (E) -->
              </td></tr>
           </table>
    	</td>
    </tr>
</table>
<!-- : ( Button : Sub ) (E) -->
		
<!-- OUTER FRAME : "to make sum of components' HEIGHTS 100%" (E)nd -->
</form>
</body>
</html>