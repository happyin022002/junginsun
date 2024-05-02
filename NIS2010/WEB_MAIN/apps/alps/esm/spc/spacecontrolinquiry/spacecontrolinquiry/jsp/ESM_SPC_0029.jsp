<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0029.jsp
*@FileTitle : Send Mail
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.03
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2011.06.03 김종준
* 1.0 Creation
* 2011.09.22 김종준 [CHM-201113515-01] SPC내에서 사용하고 있는 Tag Library 제거 작업
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event.EsmSpc0029Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSpc0029Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.Spacecontrolinquiry.Spacecontrolinquiry");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	
	
		event = (EsmSpc0029Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
	
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	
	}catch(Exception e) {
		out.println(e.toString());
	}
	
	boolean isAdmin = false;
	String rhq_cd   = "";
	String aq_cd    = "";
	String rgn_cd   = "";
	String ofc_cd   = event.getSignOnUserAccount().getOfc_cd();
	
	if (serverException == null) {
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		isAdmin = eventResponse.getETCData("adm").equals("Y");
		rhq_cd  = eventResponse.getETCData("rhq_cd");	
		aq_cd   = eventResponse.getETCData("aq_cd");	
		rgn_cd  = eventResponse.getETCData("rgn_ofc_cd");		
		//ofc_cd  = eventResponse.getETCData("rhq_cd");
	}
%>
<html>
<head>
<title>Send Mail</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" type="text/javascript" src="/hanjin/syscommon/common/fckeditor/ckeditor.js"></script>

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
<input type="hidden" name="chkview">
<input type="hidden" name="login_ofc_cd" value="<%=ofc_cd%>">
<input type="hidden" name="login_rhq_cd" value="<%=rhq_cd%>">
<input type="hidden" name="login_aq_cd" value="<%=aq_cd%>">
<input type="hidden" name="login_rgn_cd" value="<%=rgn_cd%>">
<input type="hidden" name="contents">

<!-- 개발자 작업	-->
<!-- OUTER - POPUP (S)tart -->
<table width="800" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">


		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title" id="popup_title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp; Send Mail</td></tr>
		</table>
		<!-- : ( Title ) (E) -->

		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">
					<table class="search" border="0">
						<tr class="h23">
							<td width="85"><img class="nostar">Start Week</td>
							<td width="140">
								<select class="input1" name="year1" style="width:60;"></select>
								<select class="input1" name="week1" style="width:40;"></select>
							</td>
							<td width="70"><img class="nostar">Duration</td>
							<td width="70">
							<select class="input1" name="duration" size="1">
		<%					for(int i=1; i<=6; i++){ %>
								<option value="<%=i%>"><%=i%></option>
		<%					} %>
		                    </select>
							</td>
							<td width="50"><img class="nostar">RHQ</td>
							<td><script language="javascript">ComComboObject('rhq',2, 100 , 1,1);</script></td>
						</tr>
						
						<tr class="h23">
							<td width="50"><img class="nostar">Trade</td>
							<td style="padding-left:2px;">
								<script language="javascript">ComComboObject('trade',2, 80 , 1,1);</script>
							</td>					                   				
							<td width="60"><img class="nostar">Bound</td>
							<td><script language="javascript">ComComboObject('bound',2, 80 , 1,0);</script></td>
							<td width="80">&nbsp;&nbsp;Sub Trade</td>
							<td width="120"><script language="javascript">ComComboObject('subtrade1',3, 100 , 1,0);</script></td>					
							<td width="50"><img class="nostar">Lane</td> 
							<td><script language="javascript">ComComboObject('rlane1',4, 100 , 1,0);</script></td>	
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (S) -->

		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
		<table width="100%" id="mainTable">
			<tr>
				<td width=""><textarea class="ckeditor" name="tcontents" id="tcontents" style="width:99%;height:220;"></textarea> <!-- Grid  (E) --></td>
			</tr> 				
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->

		</td>
	</tr>
</table>
<!-- OUTER - POPUP (E)nd -->

<table class="height_5"><tr><td></td></tr></table>


<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>

				<!-- Repeat Pattern -->
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_send" id="btn_send">Send</td><td class="btn1_right"></td></tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
				<!-- Repeat Pattern -->

			</tr>
		</table>

	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->



	<div id="hiddenLayer2" style="display:none">
	<!-- : ( Grid ) (S) -->
	<table width="100%" id="mainTable">
		<tr><td>
			<script language="javascript">ComSheetObject('sheet1');</script>
		</td></tr>
	</table>
	</div>

<!-- 개발자 작업  끝 -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>