<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_vsk_0238.jsp
*@FileTitle : Berth Window (Pop-Up)
*Open Issues : 1
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 서창열
*@LastVersion : 1.0
* 2009.05.25 서창열
* 1.0 Creation 
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.event.VopVsk0238Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import = "com.clt.framework.component.util.StringUtil" %> 
<%
	VopVsk0238Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String paramVslSlanCd = "";
	String paramPfSvcTpCd = "";
	String paramSeq = "";
	String paramDuration = "";
	
	Logger log = Logger.getLogger("com.clt.apps.SchedulePlanningOperation.ProformaScheduleMgt");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		
	    paramVslSlanCd = request.getParameter("vsl_slan_cd");
	    paramPfSvcTpCd = request.getParameter("pf_svc_tp_cd");
	    paramSeq = request.getParameter("seq");
	    paramDuration = request.getParameter("dur");

		event = (VopVsk0238Event)request.getAttribute("Event");
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
<title>Berth Window (Pop-Up)</title>
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
<input type="hidden" name="pf_svc_tp_cd" value="<%=StringUtil.xssFilter(paramPfSvcTpCd)%>">
<!-- 개발자 작업	-->
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
	<tr>
		<td class="top"></td>
	</tr>
	<tr>
		<td valign="top">
			<!-- : ( Title ) (S) -->
			<table width="100%" border="0">
				<tr>
					<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; Berth Window</td>
				</tr>
			</table>
			<!-- : ( Title ) (E) -->
			<!-- : ( Search Options ) (S) -->
			<table class="search"> 
       			<tr>
       				<td class="bg"> 
					<!--  biz_1  (S) -->
						<table class="search" border="0" style="width:700;"> 
							<tr class="h23">
								<td width="65">Lane Code</td>   
								<td width="90"><input type="text" style="width:60;text-align:center" class="input2"  name="vsl_slan_cd" readOnly="readonly" value="<%=StringUtil.xssFilter(paramVslSlanCd)%>"></td>
								<td width="45">Duration</td>   
								<td width="90"><input type="text" style="width:40;text-align:right" class="input2"  name="duration" readOnly="readonly" value="<%=StringUtil.xssFilter(paramDuration)%>"></td>
								<td width="65">Frequency</td>   
								<td><input type="text" style="width:25;text-align:right" class="input2" name="seq"  readOnly="readonly" value="<%=StringUtil.xssFilter(paramSeq)%>"></td>
							</tr>
						</table>
						<table class="line_bluedot"><tr><td></td></tr></table>
						<!--  biz_1   (E) -->
						<!-- : ( Grid ) (S) -->
						<table width="100%"  id="mainTable">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet1');</script>
									<script language="javascript">ComSheetObject('sheet2');</script>
									<script language="javascript">ComSheetObject('sheet3');</script>
								</td>
							</tr>
						</table>
						<!-- : ( Grid ) (E) -->	
		  				<!--  Button_Sub (S) -->
						<table width="100%" class="button"> 
	       					<tr>
	       						<td class="btn2_bg">
									<table border="0" cellpadding="0" cellspacing="0">
										<tr>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_DownExcel">Down&nbsp;Excel</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
	    				<!-- Button_Sub (E) -->
					</td>
				</tr>
			</table>
			<table class="height_5"><tr><td></td></tr></table>
		</td>
	</tr>
</table> 

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup">
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       			<tr>
       				<td class="btn3_bg">
		    			<table border="0" cellpadding="0" cellspacing="0">
		    				<tr>
		    					<td>
		    						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Close">Close</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
    					<!--Button (E) -->
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</form>
</body>
</html>