<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0247.jsp
*@FileTitle : SHA Loadable weight 계산/조회
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.01
*@LastModifier : Jung Jinwoo
*@LastVersion : 1.0
* 2009.07.01 Jung Jinwoo
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0247Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0247Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.VSKCommon.VSKCodeFinder");
	
	String vpsPortCd = "";
	String vslCd = "";
	String skdVoyNo = "";
	String skdDirCd = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (VopVsk0247Event)request.getAttribute("Event");
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
<title>Welcome to nis2010!</title>
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
<input type="hidden" name="vps_port_cd">
<input type="hidden" name="clpt_ind_seq">
<input type="hidden" name="call_ind_cd">
<input type="hidden" name="loc_cd">
<input type="hidden" name="post_type">
<input type="hidden" name="wgt_vsl_cd">
<input type="hidden" name="wgt_skd_voy_no">
<input type="hidden" name="wgt_skd_dir_cd">
<input type="hidden" name="wgt_clpt_ind_seq">

<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;SHA Loadable weight Calculation  </td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 			
		<table class="search"> 
       		<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:780;"> 
				<tr class="h23">
					<td width="30">VVD</td>   
					<td width="150"><input type="text" name="vsl_cd" style="width:45;text-align:center;" class="input2" value="" readonly="readonly" maxlength="4">&nbsp;<input type="text" name="skd_voy_no" style="width:45;text-align:center;" class="input2" value="" readonly="readonly" maxlength="4">&nbsp;<input type="text" name="skd_dir_cd" style="width:20;text-align:center;" class="input2" value="" readonly="readonly" maxlength="1"></td>
					<td width="60">ETA Date</td>  
					<td width="150"><input type="text" name="vps_eta_dt" style="width:115;text-align:center;" class="input2" value="" readonly="readonly" maxlength=""></td>
					<td width="60">ETD Date</td>  
					<td width="150"><input type="text" name="vps_etd_dt" style="width:115;text-align:center;" class="input2" value="" readonly="readonly" maxlength=""></td>
					<td width="90">Call Indicator</td>
					<td width=""><input type="text" name="call_ind_nm" style="width:60;text-align:center;" class="input2" value="" readonly="readonly"></td>
					</tr>
				</table>
				<!--  biz_1   (E) -->
				
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
				
				<!--  biz_1  (S) -->
				<table class="search_sm" border="0" style="width:220;"> 
				<tr class="h23">
					<td width=""><input type="radio" name="rdo_tran" value="" class="trans" checked="checked">ARRIVAL&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="rdo_tran" value="" class="trans">DEPARTURE</td> 
					</tr>
				</table>
				<!--  biz_1   (E) -->
				
				
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
				
				<table class="search" border="0">
					<tr><td class="title_h"></td>
						<td class="title_s"><div id="titleLayer" style="display:inline">Calculation Cargo Weight for the ARR. Draft</div></td>
					</tr>
				</table>
				<table width="100%" class="grid2"> 
					<tr>
					<td class="tr2_head" width="16%">Vessel Class</td>
					<td width="16%" class="noinput2"><input type="text" name="vsl_class" style="width:100%;text-align:center;" class="noinput2" value="" readonly="readonly"></td>
					<td class="tr2_head" width="16%">Fuel Oil	</td>
					<td width="16%" class="noinput"><input type="text" name="fuel_oil" style="width:100%;text-align:right;" class="noinput" value="" maxlength="10"> </td>
					<td class="" width="%" colspan="2"></td>
					</tr>
					
					<tr>
					<td class="tr2_head" width="16%">Light Ship</td>
					<td width="16%" class="noinput2"><input type="text" name="light_ship" style="width:100%;text-align:right;" class="noinput2" value="" readonly="readonly"></td>
					<td class="tr2_head" width="16%">Diesel Oil	</td>
					<td width="16%" class="noinput"><input type="text" name="diesel_oil" style="width:100%;text-align:right;" class="noinput" value="" maxlength="10"></td>
					<td class="tr2_head" width="16%">Draft(at FW)</td>
					<td width="%" class="noinput2"><input type="text" name="draft" style="width:100%;text-align:right;" class="noinput2" value="" readonly="readonly"></td>
					</tr>
					<tr>
					<td class="tr2_head" width="16%">TPC</td>
					<td width="16%" class="noinput2"><input type="text" name="tpc" style="width:100%;text-align:right;" class="noinput2" value="" readonly="readonly"></td>
					<td class="tr2_head" width="16%">Fresh Water</td>
					<td width="16%" class="noinput"><input type="text" name="fresh_water" style="width:100%;text-align:right;" class="noinput" value="" maxlength="10"></td>
					<td class="tr2_head" width="16%">Cargo Weight</td>
					<td width="%" class="noinput2"><input type="text" name="cargo_weight" style="width:100%;text-align:right;color:red" class="noinput2" value="" readonly="readonly"></td>
					</tr>
					<tr>
					<td class="tr2_head" width="16%">Constant</td>
					<td width="16%" class="noinput1"><input type="text" name="constant" style="width:100%;text-align:right;" class="noinput1" value="" maxlength="10"></td>
					<td class="tr2_head" width="16%">Ballast</td>
					<td width="16%" class="noinput"><input type="text" name="ballast" style="width:100%;text-align:right;" class="noinput" value="" maxlength="10"></td>
					<td class="tr2_head" width="16%">Displacement</td>
					<td width="%" class="noinput2"><input type="text" name="displacement" style="width:100%;text-align:right;" class="noinput2" value="" readonly="readonly"></td>
					</tr>
				</table>
				
				
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
				
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:780;"> 
				<tr class="h23">
					<td width="30" valign="top">Port</td>   
					<td width="80" valign="top">
						<script language="javascript">ComComboObject('wgt_port_cd', 3, 75, 1, 0, 1);</script>
						<!-- <select style="width:75;" name="wgt_port_cd">
						<option value="0" selected="selected">CNHKG</option>
						<option value="1"></option>
						</select> -->
					</td>
					<td width="670">
						<!-- Grid  (S) -->
						<table width="100%" border="0" class="search"  id="mainTable" > 
							<tr>
								<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table> 						
						<!-- Grid (E) -->
				<!--  biz_1   (E) -->
		    	<!--  Button_Sub (S) -->
						<table width="100%" class="button"> 
				       	<tr><td class="btn2_bg">
							<table border="0" cellpadding="0" cellspacing="0">
							<tr><td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
								<td class="btn2_left"></td>
								<td class="btn2" name="btn_calculaton">Calculaton</td>
								<td class="btn2_right"></td>
								</tr>
								</table>
							</td></tr>
							</table>
						</td></tr>
						</table>
				<!-- Button_Sub (E) -->
					</td>
				</tr>
				</table>
<!-- : ( Search Options ) (E) -->
			</td></tr>
		</table> 
		<table class="height_5"><tr><td></td></tr></table>
</td></tr>
</table> 

	
	
<!-- : ( Button : pop ) (S) -->
		<table width="100%" class="sbutton">
		<tr><td height="71" class="popup">
				<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
		       	<tr><td class="btn3_bg">
				    <table border="0" cellpadding="0" cellspacing="0">
				    <tr><td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_close">Close</td>
							<td class="btn1_right"></td>
							</tr>
						</table>
					</td></tr>
					</table>
				</td></tr>
				</table>
		    <!--Button (E) -->
		</td></tr>
		</table>
<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp"%>