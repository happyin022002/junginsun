<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0811.jsp
*@FileTitle : Container Selection
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2009.08.13 박성진
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
<%@ page import="com.hanjin.apps.alps.esd.tpb.candidatemanage.manualregister.event.EsdTpb0811Event"%>
<%@ page import="com.hanjin.apps.alps.esd.tpb.common.TPBUtils"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdTpb0811Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.CandidateManage.ManualRegister");

	String s_bkg_no = JSPUtil.getNull(request.getParameter("s_bkg_no")); 
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsdTpb0811Event)request.getAttribute("Event");
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
<title>Container Selection</title>
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
			<tr><td class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;BKG No. <%=s_bkg_no%></td></tr>
		</table>
		<!--Page Title, Historical (E)-->
				
		<!-- Grid (S) -->
		<table class="search"> 
       		<tr><td class="bg">
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
		</td></tr></table>
		<!-- Grid (E) -->	
		<!--biz page (E)-->
		<!-- : ( Button : Sub ) (S) -->
			<table width="100%" class="button"> 
			   <tr><td class="btn2_bg">
			           <table border="0" cellpadding="0" cellspacing="0">
			                <tr>
				                <td>
			                       <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<!-- Repeat Pattern -->
										<td><input type="text" dataformat="int" maxlength="3" name="s_add_cnt" style="text-align: right; width:50px; margin-right:3px;" value="1"></td>	
										<td>
											<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="btn_add_t">
												<tr>
													<td class="btn2_left"></td>
													<td class="btn2" name="btn_add" id="btn_add">Row&nbsp;Add&nbsp;</td>
													<td class="btn2_right"></td>
												</tr>
											</table>
										</td>
									<!-- Repeat Pattern -->
									</table>
				                </td>
				                <td>                      
									<!-- Row Add   Button (S) -->
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn2_left"></td>
											<td class="btn2" name="btn_save">OK</td>
											<td class="btn2_right"></td>
										</tr>
									</table>
									<!-- Row Add   Button (E) -->
				              	</td>
			              <td>                      
			                 <!—Row Add   Button (S) -->
			                       <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			                               <tr><td class="btn2_left"></td>
										   <td class="btn2" name="btn_close">Close</td>
										   <td class="btn2_right"></td>
										  </tr>
			                       </table>
			                 <!—Row Add   Button (E) -->
			              </td></tr>
			           </table>
			    </td></tr>
			</table>
			<!-- : ( Button : Sub ) (E) -->
			
						
			<!-- TABLE '#D' : ( Search Options ) (E) --> 	
		</td></tr>
	</table>
</td></tr>
</table>
<!-- OUTER FRAME : "to make sum of components' HEIGHTS 100%" (E)nd -->
</form>
</body>
</html>