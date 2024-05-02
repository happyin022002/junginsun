<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_FCM_0053.jsp
*@FileTitle : Trend Line Setup
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.02
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.12.07
* 1.0 Creation
*
* History
* 2012.07.03 진마리아 팝업 화면의 이름이 잘못되어 있어서 수정함
* 2013.01.02 진마리아 CHM-201322241-01 FCM 사용 하지않는 소스 및 화면 정리
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.fcm.simulation.simulation.event.VopFcm0053Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopFcm0053Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String cntrDznCapa      = "";
	Logger log = Logger.getLogger("com.hanjin.apps.SchedulePlanningOperation.ProformaScheduleMgt");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (VopFcm0053Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		cntrDznCapa = eventResponse.getETCData("cntr_dzn_capa");
		cntrDznCapa = cntrDznCapa==null?"":cntrDznCapa;
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Trend Line Setup</title>
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

<body  class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="cntr_dzn_capa_list" value="<%=cntrDznCapa%>">
<input type="hidden" name="trnd_line_tp_cd">
<input type="hidden" name="trnd_line_cht_tp_cd">
<input type="hidden" name="vsl_clss_cd">
<input type="hidden" name="vsl_clss_sub_cd">
<input type="hidden" name="cntr_dzn_capa">
<input type="hidden" name="sub_cntr_dzn_capa">

<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S) -->
		<table width="100%" class="popup" cellpadding="10" border="0"> 
		<tr><td class="top"></td></tr>
		<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Trend Line Setup </td></tr>
		</table>
		<!-- : ( Title ) (E) -->
			<!--biz page (S)-->
			<table class="search"> 
       			<tr>
       				<td class="bg">
						<!--  biz_1  (S) -->
						<table class="search" border="0" style="width:100%;"> 
							<tr class="h23">
								<td width="80">Lane</td>
								<td width="150"><input type="text" style="width:60;ime-mode:disabled;text-align:center" name="vsl_slan_cd" class="input2" maxlength="3" dataformat="uppernum" value="" tabIndex="1" readOnly>&nbsp;</td>
								<td width="150">P/F SKD Type</td>
								<td width="150"><input type="text" style="width:60;ime-mode:disabled;text-align:center" name="pf_svc_tp_cd" class="input2" dataformat="uppernum" maxlength="4" value="" tabIndex="2" readOnly>&nbsp;</td> 								
								<td width="100">Frequency</td>
								<td width="150"><input type="text" style="width:50;ime-mode:disabled;text-align:right" name="brth_itval_dys" maxlength="2" dataformat="int" class="input2"  value="" readOnly></td> 
								<td width="100">Duration</td>
								<td width="150"><input type="text" style="width:50;ime-mode:disabled;text-align:right" name="svc_dur_dys" maxlength="4" dataformat="int" class="input2" value="" tabIndex="9" readOnly></td> 
							    <td  width=""></td>
							</tr>
						</table>
						<table class="search" border="0" style="width:100%;">
							<tr class="h23">
								<td width="100">Design Capacity</td>
								<td width="500">
								<input type="text" style="width:50;ime-mode:disabled" name="n1st_vsl_clss_cd" maxlength="5" dataformat="int" class="input2" value="" tabIndex="4">&nbsp;&nbsp;<input type="text" style="width:20;ime-mode:disabled;text-align:right" name="n1st_vsl_clss_knt" maxlength="2" dataformat="int" class="input2" value="" tabIndex="4">&nbsp;&nbsp;
								<!-- input type="text" style="width:50;ime-mode:disabled" name="n2nd_vsl_clss_cd" class="input" maxlength="5" dataformat="int" value="" tabIndex="5" onKeyPress="if(event.keyCode==13) doSearch();" -->
								<input type="text" style="width:50;ime-mode:disabled" name="n2nd_vsl_clss_cd" class="input2" maxlength="5" dataformat="int" value="" tabIndex="5" >&nbsp;<input type="text" style="width:20;ime-mode:disabled;text-align:right" name="n2nd_vsl_clss_knt" maxlength="2" dataformat="int" class="input2" value="" tabIndex="6">&nbsp;&nbsp;
								<!-- input type="text" style="width:50;ime-mode:disabled" name="n3rd_vsl_clss_cd" maxlength="5" dataformat="int" class="input" value="" tabIndex="7" onKeyPress="if(event.keyCode==13) doSearch();" -->
								<input type="text" style="width:50;ime-mode:disabled" name="n3rd_vsl_clss_cd" maxlength="5" dataformat="int" class="input2" value="" tabIndex="7">&nbsp;<input type="text" style="width:20;ime-mode:disabled;text-align:right" name="n3rd_vsl_clss_knt" maxlength="2" dataformat="int" class="input2" value="" tabIndex="8" ></td>
								<td  width=""></td>													
							</tr>							
						</table>
					</td></tr></table>
					
						<!--  biz_1   (E) -->
						<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
						<!--  biz_2  (S) -->
						<!-- Grid  (S) -->
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet1');</script>
									<!-- <script language="javascript">ComSheetObject('sheet2');</script> -->
								</td>							
							</tr>
							<tr>
								<td width="100%">
									<!-- : ( Button : Sub ) (S) -->
									<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:0;"> 
									    <tr>
									        <td class="btn2_bg">
										        <table border="0" cellpadding="0" cellspacing="0">
										    		<tr>
										    			<!-- 
														<td>
															<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																<tr>
																	<td class="btn2_left"></td>
																	<td class="btn2" name="btn_RowAdd">Row Add</td>
																	<td class="btn2_right"></td>
																</tr>
															</table>
														</td>
														<td>
															<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																<tr>
																	<td class="btn2_left"></td>
																	<td class="btn2" name="btn_RowDelete">Row Delete</td>
																	<td class="btn2_right"></td>
																</tr>
															</table>
														</td>
														<td>
															<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																<tr>
																	<td class="btn2_left"></td>
																	<td class="btn2" name="btn_Save">Save</td>
																	<td class="btn2_right"></td>
																</tr>
															</table>
														</td>
														 -->				
													</tr>
												</table>
											</td>
										</tr>
									</table>
									<!-- : ( Button : Sub ) (E) -->
								</td></tr></table> 									
						<!-- Grid  (E) -->
						<!--  biz_2   (E) -->
					</td>
				</tr>
			</table>
	<!--biz page (E)-->
	
<table class="height_5"><tr><td></td></tr></table> 
</td></tr>
</table>
<!-- OUTER - POPUP (E) -->
	
<!-- : ( Button : Pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_OK">OK</td>
								<td class="btn1_right"></td>
								</tr>
								</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right">
				</tr></table></td>
			</tr>
		</table></td>
			</tr>
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