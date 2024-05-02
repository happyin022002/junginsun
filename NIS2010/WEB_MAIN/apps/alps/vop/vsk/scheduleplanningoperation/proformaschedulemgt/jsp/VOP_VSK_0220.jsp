<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0220.jsp
*@FileTitle : Information Input for SKD Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : Jung Jinwoo
*@LastVersion : 1.0
* 2009.05.12 Jung Jinwoo
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.event.VopVsk0220Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0220Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.VSKCommon.VSKCodeFinder");
	
	String vslSlanCd = JSPUtil.getNull(request.getParameter("vsl_slan_cd"));
	String skdDirCd = JSPUtil.getNull(request.getParameter("skd_dir_cd"));
	String pfSvcTpCd = JSPUtil.getNull(request.getParameter("pf_svc_tp_cd"));
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (VopVsk0220Event)request.getAttribute("Event");
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
<title>Port Code Inquiry</title>
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
<input type="hidden" name="slan_stnd_flg">
<input type="hidden" name="skd_dir_cd" value="<%=skdDirCd%>">
<input type="hidden" name="clpt_seq" value="">
<!-- 개발자 작업	-->

<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Information Input for SKD Creation (P/F SKD Use)  </td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 			
			<table class="search" width="580"> 
       		<tr><td class="bg" valign="top" style="height:160;">
				<table class="search" border="0">
					<tr class="h23">
						<td width="125">Lane Code</td>
						<td width=""><input type="text" name="vsl_slan_cd" style="width:60;text-align:center;" value="<%=vslSlanCd %>" class="input2" readonly="readonly">&nbsp;<input type="text" name="vsl_slan_nm" style="width:270" value="" class="input2" readonly="readonly"> </td>
					</tr>
					<tr class="h23">
						<td width="">P/F SKD Type</td>
						<td width=""><input type="text" name="pf_svc_tp_cd" style="width:60;text-align:center;ime-mode:disabled;" value="<%=pfSvcTpCd %>" class="input1" maxlength="4">&nbsp;<img class="cursor" name="btn_pf_lane_help" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
					</tr>
					<tr class="h23">
						<td width="">Start Port /Day</td>
						<td width="" style="padding-left:2"><script language="javascript">ComComboObject('port_cd',3,60,1,0);</script>&nbsp;&nbsp;/&nbsp;&nbsp;<input type="text" style="width:40;text-align:center;" name="etb_dy_cd" value="" class="input2_1" readonly="readonly"></td>
							</tr>
					<tr class="h23">
						<td width="">Start Port ETB Date</td>
						<td width=""><input type="text" name="vps_etb_dt" maxlength="10" style="width:80;text-align:center;" value="" class="input1">&nbsp;<img class="cursor" name="btn_calendar" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
					</tr>
				</table>

						<!-- Grid  (S) -->
						<table width="100%" class="search"  id="mainTable" > 
							<tr>
								<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table> 						
							<!-- Grid (E) -->
					
				
				
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
		    <tr><td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_ok">OK</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr>
					<td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
    <!--Button (E) -->
	
			</td></tr>
		</table>
<!-- : ( Button : pop ) (E) -->

	</td></tr>
</table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp"%>