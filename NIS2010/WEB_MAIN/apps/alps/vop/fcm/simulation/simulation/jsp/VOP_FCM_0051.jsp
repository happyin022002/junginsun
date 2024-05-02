<%
/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : VOP_FCM_0051.jsp
*@FileTitle : 화면명
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.04
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.10.04 유혁
* 1.0 Creation
*
* History
* 2012.04.04 진마리아 CHM-201216636-01 [FCM] ALPS 모델 및 DB 구조 불일치 복구
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.fcm.simulation.simulation.event.VopFcm0051Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopFcm0051Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";	// Office Code 삭제시 Delete 버튼 활성화 여부 확인.
	
	Logger log = Logger.getLogger("com.hanjin.apps.vop.fcm.simulation.simulation");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (VopFcm0051Event)request.getAttribute("Event");
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
<title>Fuel Consumption Inquiry</title>
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

<!-- 업무용 hidden -->
<!-- 
<input type="hidden" name="vsl_clss_cd">
<input type="hidden" name="vsl_clss_sub_cd">
<input type="hidden" name="vsl_slan_cd">
<input type="hidden" name="trnd_line_vsl_cd">
<input type="hidden" name="trnd_line_skd_dir_cd">
<input type="hidden" name="trnd_line_tp_sub_cd">
<input type="hidden" name="trnd_line_fm_dt">
<input type="hidden" name="trnd_line_to_dt">
<input type="hidden" name="trnd_line_use_tp_cd">
<input type="hidden" name="trnd_line_seq">
 -->

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
					<td width="30" rowspan="">VVD</td>   
					<td width="160"><input type="text" name="vsl_cd" style="width:40;text-align:center;ime-mode:disabled;" class="input1" value="" maxlength="4" onfocus="this.select();">&nbsp;<input type="text" name="skd_voy_no" style="width:40;text-align:center;ime-mode:disabled;" class="input1" value="" maxlength="4" onfocus="this.select();">&nbsp;<input type="text" name="skd_dir_cd" style="width:25;text-align:center;ime-mode:disabled;" class="input1" value="" maxlength="1" onfocus="this.select();">&nbsp;<img class="cursor" name="btn_vvd" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="30">Lane</td>
					<td width="180">&nbsp;
						<input type="text" style="width:50;text-align:center;" class="input2" maxlength="15" name="lane_cd" readonly>
					</td>
					<td width="110">Trend Line Type</td>
					<td width="130"><script language="javascript">ComComboObject('trnd_line_tp_cd',1,125,1,3);</script></td>
					<td width="200"><input type="text" name="trnd_line_no" style="width:150;text-align:center;ime-mode:disabled;" class="input2" readonly>
					<img class="cursor" name="btn_trnd_line_no" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle">
					</td>
					<td width="">&nbsp;</td>
				</tr>
				</table>	
				<table class="search" border="0" style="width:100%;">
				<tr class="h23">		
					<td width="100">Simulation No.</td>
                    <td width="150"><input type="text" style="width:100;text-align:center;" class="input2" maxlength="15" name="sim_no" fullfill caption="Contract No." readonly>&nbsp;<img class="cursor" src="img/btns_search.gif" name="btn_sim_no" width="19" height="20" alt="" border="0" align="absmiddle"></td>					
					<td width="50">Bound</td>
					<td width="100">&nbsp;
						<select name="vvd_seq" style="width:45;">
						    <option value="1">1</option>							
						    <option value="2">2</option>
						    <option value="3" selected>3</option>
						    <option value="4">4</option>
						    <option value="5">5</option>
						</select>
						 <!-- <input type="text" name="vvd_seq" style="width:45;text-align:center;ime-mode:disabled;" class="input" value=""></input> -->
					</td>
					<td width="200">Requested to supply Bunker</td>
					<td width="30">Port</td>
					<td width="120">&nbsp;
						<input type="text" style="width:80;text-align:center;" class="input2" maxlength="15" name="flet_ctrt_no" fullfill caption="Contract No." readonly>
					</td>
					<td width="30">Q'ty</td>
					<td width="120">&nbsp;
						<input type="text" style="width:80;text-align:center;" class="input2" maxlength="15" name="flet_ctrt_no" fullfill caption="Contract No." readonly>
					</td>
					<td width="">&nbsp;</td>
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
					<table border="0" cellpadding="0" cellspacing="0"><tr>
							<td><table border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_Row_Hide">Row Hide</td>
							<td class="btn2_right"></td></tr></table></td>
							<td><table border="0" cellpadding="0" cellspacing="0" class="button"><tr>
							<td class="btn2_left"></td>
							<td class="btn2" name="btn_Row_Hide_Cancel">Row Hide Cancel</td>
							<td class="btn2_right"></td></tr></table></td>
							<td><table id="expand_div" border="0" cellpadding="0" cellspacing="0" class="button"><tr>
							<td class="btn2_left"></td>
							<td class="btn2" name="btn_Expand">Expand</td>
							<td class="btn2_right"></td>
							</tr></table></td>
							<td><table id="reduce_div" border="0" cellpadding="0" cellspacing="0" class="button" style="display:none"><tr>
							<td class="btn2_left"></td>
							<td class="btn2" name="btn_Reduce">Reduce</td>
							<td class="btn2_right"></td>
							</tr></table></td>
							</tr></table></td>						
						</tr></table>
				</td></tr>
				</table>
		    	<!-- Button_Sub (E) width:979; 886 -->
							
				</td></tr>
			</table>
	
	<!--biz page (E)-->
	
	<!-- 메인 화면 바깐쪽 화면 하단 버튼 부 -->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					<td class="btn1_left"></td>
					<td class="btn1" name="btn_New" id="btn_New">New</td>
					<td class="btn1_right"></td>
					<!-- 
					<td class="btn1_left"></td>
					<td class="btn1" name="btn_Simulation" id="btn_Simulation">Simulation</td>
					<td class="btn1_right"></td>
					 -->
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
    
</td></tr>
</table>

</form>			
</body>
</html>