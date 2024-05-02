<%/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : vop_vsk_0203.jsp
*@FileTitle : Lane Code Help2
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.26
*@LastModifier : 정상기
*@LastVersion : 1.0
* 2009.04.27 정상기
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.event.VskGloEvent"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VskGloEvent  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.VSKCommon.VSKCodeFinder");
	String vsl_slan_cd = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (VskGloEvent)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		vsl_slan_cd = JSPUtil.replaceForHTML(request.getParameter("vsl_slan_cd"));
		vsl_slan_cd = vsl_slan_cd==null?"":vsl_slan_cd;

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
<title>Lane Code Help</title>
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
<input type="hidden" name="vsl_svc_tp_cd" value="CD00717">
<!-- 개발자 작업	-->
<table width="100%" class="popup" cellpadding="10" border="0"> 
	<tr>
		<td class="top"></td>
	</tr>
	<tr>
		<td valign="top">
			<!-- : ( Title ) (S) -->
			<table width="100%" border="0">
				<tr>
					<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Lane Code Inquiry</td>
				</tr>
			</table>
			<!-- : ( Title ) (E) -->
			<!-- : ( Search Options ) (S) -->
			<table class="search"> 
       			<tr>
       				<td class="bg">
						<!--  biz_1  (S) -->
						<table class="search" border="0" style="width:384;"> 
							<tr class="h23">
								<td width="70">Lane Code</td>   
								<td width="80" style="padding-left:2"><input type="text" style="width:40;ime-mode:disabled;text-align:center" class="input"  dataformat="uppernum" maxlength="3" name="vsl_slan_cd" value="<%=vsl_slan_cd%>" onKeyPress="if(event.keyCode==13) doSearch();"></td>
								<td width="120">Lane Service Type</td>   
								<td>
								<!-- 
								<select style="width:100;" name="vsl_svc_tp_cd">
									<option value="" selected>All</option>
									<option value="1">S - Space Charter SVC </option>
									<option value="2">J - Joint Operation SVC</option>
									<option value="3">I - Independent Operation SVC</option>
									<option value="4">O - CCA Feeder</option>
								</select>
								 -->
								 <script language="javascript">ComComboObject('combo1',2,120,0);</script>
								</td>
							</tr>
						</table>
						
						<table class="search" border="0" style="width:384;"> 
							<tr class="h23">
								<td width="70">Lane Name</td>   
								<td width=""><input type="text" style="width:100%;ime-mode:disabled" class="input" dataformat="uppernum" maxlength="50" name="vsl_slan_nm" value="" onKeyPress="if(event.keyCode==13) doSearch();"></td>
							</tr>
						</table>

						<table class="search" border="0" style="width:384;"> 
							<tr class="h23">
								<td width="70">Use&nbsp;&nbsp;<input type="checkbox" name="chk_use" class="trans" value="Y" checked></td>   
								<td width="">&nbsp;Period&nbsp;&nbsp;&nbsp;
									<input type="text" name="fm_dt" dataformat="ymd" style="width:75;text-align:center;" class="input" value="" maxlength="8" size="10">
									&nbsp;&nbsp;~&nbsp;&nbsp;
									<input type="text" name="to_dt" dataformat="ymd" style="width:75;text-align:center;" class="input" value="" maxlength="8" size="10">
									&nbsp;
									<div id="period" style="display: inline">
									<img class="cursor" name="btn_period" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
									</div>
								</td>
							</tr>
						</table>
												
						<!--  biz_1   (E) -->
						<!-- : ( Grid ) (S) -->
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table>
						<!-- : ( Grid ) (E) -->	
					    <!-- : ( Button : Grid ) (E) -->	
					</td>
				</tr>
			</table>
<!-- : ( Search Options ) (E) -->

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
											<td class="btn1" name="btn_retrieve">Retrieve</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Select">Select</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_close">Close</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
    <!--Button (E) -->
		</td>
	</tr>
</table>
<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp"%>