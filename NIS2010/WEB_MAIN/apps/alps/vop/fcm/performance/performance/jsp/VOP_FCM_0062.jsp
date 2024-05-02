<%
/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : VOP_FCM_9999.jsp
*@FileTitle : 화면명
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.04
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2011.10.04 유혁
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
<%@ page import="com.hanjin.apps.alps.vop.fcm.performance.performance.event.VopFcm0062Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopFcm0062Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";	// Office Code 삭제시 Delete 버튼 활성화 여부 확인.
	
	Logger log = Logger.getLogger("com.hanjin.apps.vop.fcm.performance.performance");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (VopFcm0062Event)request.getAttribute("Event");
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
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="50">Item</td>
					<td width="140">&nbsp;
						<select name="sav_itm_cd" style="width:120;">
						    <option value="01">T/C Cut off</option>
							<option value="02">Fuel Additive</option>
							<option value="03">Hull Paint</option>
						</select>
					</td>
					<td width="50">Month</td>
					<td width="230">	
					 <input type="text" style="width:75;text-align:center;" class="input1" name="fm_yrmon" maxlength="6" dataformat="ym" caption="Target Month">
					 <img class="cursor" src="img/btns_calendar.gif" name="btn_month1" width="19" height="20" alt="" border="0" align="absmiddle">
					 ~
					 <input type="text" style="width:75;text-align:center;" class="input1" name="to_yrmon" maxlength="6" dataformat="ym" caption="Target Month">
					 <img class="cursor" src="img/btns_calendar.gif" name="btn_month2" width="19" height="20" alt="" border="0" align="absmiddle">
					</td>
					<td width="70">Lane Code</td>
                    <td width="100"><input type="text" style="width:60;ime-mode:disabled;text-align:center" name="vsl_slan_cd" class="input" maxlength="3" dataformat="uppernum" value="">&nbsp;<img src="img/btns_search.gif" name="btns_search1"  class="cursor" width="19" height="20" alt="" border="0" align="absmiddle"></td>
					<td width="60">Vessel</td>
                    <td width="100"><input type="text" style="width:60;ime-mode:disabled;text-align:center" name="vsl_cd" class="input" maxlength="4" dataformat="uppernum" value="">&nbsp;<img src="img/btns_search.gif" name="btns_search2"  class="cursor" width="19" height="20" alt="" border="0" align="absmiddle"></td>		
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
				<!-- Grid (E) -->
			
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