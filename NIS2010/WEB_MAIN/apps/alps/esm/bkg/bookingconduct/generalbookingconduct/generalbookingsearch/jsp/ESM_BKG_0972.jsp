<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0972.jsp
*@FileTitle : Service Mode And Route
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.12
*@LastModifier : KimByungKyu
*@LastVersion : 1.0
* 2009.05.12 KimByungKyu
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg0972Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0972Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.GeneralBookingConduct.GeneralBookingSearch");

	// Main에서 Parameter 받기
	String bkgNo = "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmBkg0972Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		bkgNo  = JSPUtil.getParameter(request, "bkg_no");
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Service Mode And Route</title>
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

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="bkg_no" value="<%= bkgNo%>">
<!-- 개발자 작업	-->
<!-- OUTER - POPUP (S)tart -->
<div id="msg" style="position:absolute;left:0;top:0;width:0;height:0;"></div>

<table width="100%" class="popup" cellpadding="10" border="0"> 
	<tr><td class="top"></td></tr>
	<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;booking creation_service mode & route</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
		<table class="search"> 
       		<tr><td class="bg">			
				<table class="search" border="0" style="width:100%;"> 
					<tr class="h23"><td width="300">
						<!-- : ( Biz )1 (S) -->
						<table width="100%" class="grid2"> 
							<tr class="tr2_head">
								<td width="" colspan="4">Service Route	</td>
							</tr>
							<tr class="input" align="center">
								<td class="tr2_head" width="50">Origin			</td>
								<td width="65"><input type="text" style="width:100%;" class="noinput" name = "orgScontiCd"  readonly></td>
								<td class="tr2_head" width="70">Destination		</td>
								<td width="65"><input type="text" style="width:100%;" class="noinput" name="destScontiCd"  readonly></td>
							</tr>
						</table> 
						<!-- : ( Biz ) 1(E) -->	
					</td>
					<td width="20"></td>
					<td width="">
					<!-- : ( Biz ) (S) -->
						<table width="100%" class="grid2"> 
							<tr class="tr2_head">
								<td width="" colspan="6">Service Mode</td>
							</tr>
							<tr class="input" align="center">
								<td class="tr2_head" width="60">Origin</td>
								<td width="65"><input type="text" style="width:100%;" class="noinput" name="orgTrnsSvcModCd" onmousemove="msgmove('org')" onmouseover="msgset(document.form.org_trns_svc_mod_nm.value);return true;"  onmouseout="msghide();return true;" readonly></td>
								<td class="tr2_head" width="80">Destination	</td>
								<td width="65"><input type="text" style="width:100%;;" class="noinput" name="destTrnsSvcModCd" onmousemove="msgmove('dest')" onmouseover="msgset(document.form.dest_trns_svc_mod_nm.value);return true;"  onmouseout="msghide();return true;" readonly></td>
								<td class="tr2_head" width="100">Block Stowage</td>
								<td width="65"><input type="text" style="width:100%;;" class="noinput" name="blckStwgCd" readonly></td>
							</tr>
						</table> 
						<!-- : ( Biz ) (E) -->	
					</td></tr>
					
					<tr><td>
						<table class="height_8">
							<tr><td></td></tr>
						</table>
					</td></tr>
					
					<tr>
						<td width="300"></td>
						<td width="20"></td>
						<td width="">
						<!-- : ( Biz ) (S) -->
							<table width="100%" class="grid2"> 
								<tr class="input" align="center">
									<td class="tr2_head" width="205">Estimated ID Return CY</td>
									<td width=""><input type="text" style="width:100%;" class="noinput" name="estmIbMtyRtnYdCd" readonly></td>
								</tr>
							</table> 
							<!-- : ( Biz ) (E) -->	
						</td>
					</tr>
				</table>
			</td></tr>
		</table>
		<!-- : ( Search Options ) (E) -->
		<table class="height_5">
			<tr><td></td></tr>
		</table>
	</td></tr>
</table> 

<table width="100%"  id="mainTable"> 
	<tr>
		<td width="100%">
			<script language="javascript">ComSheetObject('sheet1');</script>
		</td>
	</tr>
</table>	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
	<tr><td height="71" class="popup">	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       		<tr><td class="btn3_bg">
			    <table border="0" cellpadding="0" cellspacing="0">
				    <tr><td>
						<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Close">Close</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td></tr>
				</table></td>
			</tr>
		</table>
    	<!--Button (E) -->	
	</td></tr>
</table>
<input type="hidden" name="org_trns_svc_mod_nm">
<input type="hidden" name="dest_trns_svc_mod_nm">
<!-- : ( Button : pop ) (E) -->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>