<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName       : VOP_FCM_0056.jsp
*@FileTitle      : Standard FOC
*Open Issues     :
*Change history  :
*@LastModifyDate : 2014.04.16
*@LastModifier   : 
*@LastVersion    : 1.0
* 2014.04.16 [CHM-201429874] Standard FOC 생성 및 단계별 저장 기능 개발
* 1.0 Creation
*
* History
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.fcm.simulation.simulation.event.VopFcm0056Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopFcm0056Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";	// Office Code 삭제시 Delete 버튼 활성화 여부 확인.
	
	Logger log = Logger.getLogger("com.clt.apps.vop.fcm.simulation.simulation");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (VopFcm0056Event)request.getAttribute("Event");
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
<title>Standard FOC</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	var gOfcCd = "<%=strOfc_cd%>";
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();"> 

<form name="form">
<!-- 기본 필수 hidden -->
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- 추가 hidden -->
<!-- Added By 2014.07.08 Lee Byoung Hoon -->
<input type="hidden" name="selectedRow">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;padding-right:5;">
	<tr><td valign="top">
			
			<!-- Title, Navigation 고정 -->
			<!--Page Title, Historical (S)-->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
			<!--Page Title, Historical (E)-->
			
			<!-- 메인 화면 : biz page (S)-->
			<table class="search">
				<tr><td class="bg">
						<!-- 메인 조건부 : biz_1  (S) -->
						<table class="search" border="0" style="width:100%;">
							<tr class="h23">
								<td width="30">VVD</td>
								<td width="150"><input type="text" name="vsl_cd" style="width:40;text-align:center;ime-mode:disabled;" class="input1" value="" maxlength="4" onfocus="this.select();">&nbsp;<input type="text" name="skd_voy_no" style="width:40;text-align:center;ime-mode:disabled;" class="input1" value="" maxlength="4" onfocus="this.select();">&nbsp;<input type="text" name="skd_dir_cd" style="width:25;text-align:center;ime-mode:disabled;" class="input1" value="" maxlength="1" onfocus="this.select();">&nbsp;<img class="cursor" name="btn_vvd" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
								<td width="50">Lane</td>
								<td><input type="text" style="width:50;text-align:center;" class="input2" maxlength="15" name="lane_cd" readonly></td>
							</tr>
						</table>
						<table class="search" border="0" style="width:100%;">
							<tr class="h23">
								<td style="width:220;text-align:right;">Bound</td>
								<td width="75">
									<select name="vvd_seq" style="width:50;margin-left:10;">
										<option value="1">1</option>
										<option value="3" selected>3</option>
										<option value="5">5</option>
									</select>
								</td>
								<td width="75">Trend Line</td>
								<td width="190"><input type="text" name="trnd_line_no" style="width:150;text-align:center;ime-mode:disabled;" class="input2" readonly>
												<img class="cursor" name="btn_trnd_line_no" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle">
								</td>
								<td width="30">Slip</td>
								<td width="75"><input type="text" style="width:60;text-align:center;" class="input2" maxlength="10" name="slip" readonly></td>
								<td width="85">FOC Formula</td>
								<td><input type="text" style="width:200;text-align:center;" class="input2" name="foml_desc" readonly></td>
							</tr>
						</table>
						<!--  biz_1   (E) -->
						
						<!-- 중간 점선 -->
						<table class="line_bluedot"><tr><td></td></tr></table>
						
						<!-- 그리드부 : biz_2  (S) -->
						<!-- Grid  (S) -->
						<table width="100%" id="mainTable">
							<tr>
								<td width="100%">
									<!--시트-->
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table>
						<table width="100%" id="mainTable">
							<tr>
								<td width="100%">
									<!--시트-->
									<script language="javascript">ComSheetObject('sheet_trend_line');</script>
								</td>
							</tr>
						</table>
						<!-- Grid (E) -->
						
						<!--  Button_Sub (S) -->
						<table width="100%" class="button">
							<tr><td class="btn2_bg">
									<table border="0" cellpadding="0" cellspacing="0">
										<tr>
											<!-- Added By 2014.07.08 Lee Byoung Hoon -->
											<td><table border="0" cellpadding="0" cellspacing="0" class="button"><tr>
											<td class="btn2_left"></td>
											<td class="btn2" name="btn_Delete">Delete</td>
											<td class="btn2_right"></td></tr></table></td>
										
											<td><table border="0" cellpadding="0" cellspacing="0" class="button"><tr>
											<td class="btn2_left"></td>
											<td class="btn2" name="btn_Selection">Selection</td>
											<td class="btn2_right"></td></tr></table></td>
											
											<td><table border="0" cellpadding="0" cellspacing="0" class="button"><tr>
											<td class="btn2_left"></td>
											<td class="btn2" name="btn_Calculation">Calculation</td>
											<td class="btn2_right"></td></tr></table></td>
											
											<td><table id="expand_div" border="0" cellpadding="0" cellspacing="0" class="button"><tr>
											<td class="btn2_left"></td>
											<td class="btn2" name="btn_Expand">Expand</td>
											<td class="btn2_right"></td></tr></table></td>
											
											<td><table id="reduce_div" border="0" cellpadding="0" cellspacing="0" class="button" style="display:none"><tr>
											<td class="btn2_left"></td>
											<td class="btn2" name="btn_Reduce">Reduce</td>
											<td class="btn2_right"></td></tr></table></td>
											
										</tr>
									</table>
							</td></tr>
						</table>
						<!-- Button_Sub (E) width:979; 886 -->
				</td></tr>
			</table>
			<!--biz page (E)-->
	</td></tr>
</table>

<!-- 메인 화면 바깐쪽 화면 하단 버튼 부 -->
<!--Button (S) -->
<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
	<tr><td class="btn1_bg">
			<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
								<td class="btn1_right"></td>
								
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_New" id="btn_New">New</td>
								<td class="btn1_right"></td>
								
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Save" id="btn_Save">Save</td>
								<td class="btn1_right"></td>
							</tr>
					</table></td>
				</tr>
			</table>
	</td></tr>
</table>		
<!--Button (E) -->
    
</form>			
</body>
</html>