<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0232.jsp
*@FileTitle : Target VVD & Remark(s)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.26
*@LastModifier : 정진우
*@LastVersion : 1.0
* 2009.08.26 정진우
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
<%@ page import="com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.event.VopVsk0232Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0232Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.ActualScheduleManagement.OnTimeResultAnalysis");

	String vsl_cd = "";
	String voy_no = "";
	String dir_cd = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopVsk0232Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		vsl_cd = event.getAttribute("vsl_cd") == null ? "" : event.getAttribute("vsl_cd").toString();	
		voy_no = event.getAttribute("voy_no") == null ? "" : event.getAttribute("voy_no").toString();	
		dir_cd = event.getAttribute("dir_cd") == null ? "" : event.getAttribute("dir_cd").toString();	

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
<title>SKD for Conversion</title>
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

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="fm_dt">
<input type="hidden" name="to_dt">
<input type="hidden" name="ig_flg">
<input type="hidden" name="vsl_slan_cd">
<input type="hidden" name="lane_grp_nm">
<input type="hidden" name="vsl_cd">
<input type="hidden" name="vps_port_cd">
<input type="hidden" name="crr_cd">
<input type="hidden" name="tab_flg">
<input type="hidden" name="grp_flg">
<input type="hidden" name="condition">
<input type="hidden" name="port_skp_tp_cd">
<!-- 개발자 작업	-->


<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
	<!-- : ( Title ) (S) -->
	<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Target VVD & Remark(s) </td></tr>
	</table>
	<!-- : ( Title ) (E) -->
		
	<!-- : ( Search Options ) (S) -->
 			
	<table class="search"> 
       	<tr><td class="bg">
			<!--  biz_1  (S) -->
				
			<table class="search"> 
       			<tr>
					<td width="100%">
						<!-- : ( Grid ) (S) -->
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table> 						
						<!-- : ( Grid ) (E) -->	
					</td>
				</tr>
			</table>
			<!--  biz_1   (E) -->
				
				
		    <!-- : ( Button : Grid ) (E) -->	
			
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
    <!--Button (E) -->
	
		</td></tr>
	</table>
	
</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
<%@include file="/bizcommon/include/common_nis2010.jsp" %>