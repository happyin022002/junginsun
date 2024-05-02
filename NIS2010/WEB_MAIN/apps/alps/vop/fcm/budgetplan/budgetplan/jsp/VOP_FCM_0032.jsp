<%
/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : VOP_FCM_0032.jsp
*@FileTitle : Standard of FOC(Pop-up)
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
<%@ page import="com.hanjin.apps.alps.vop.fcm.budgetplan.budgetplan.event.VopFcm0032Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
VopFcm0032Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";	// Office Code 삭제시 Delete 버튼 활성화 여부 확인.
	String fm_date = DateTime.addDays(DateTime.getDateString(),-7,"yyyy.MM.dd");
	String chk_date = DateTime.addDays(DateTime.getDateString(),-90,"yyyy.MM.dd");
	fm_date = fm_date.replace(".","-").substring(0,7);
	chk_date = chk_date.replace(".","-").substring(0,7);	
	Logger log = Logger.getLogger("com.hanjin.apps.vop.fcm.budgetplan.budgetplan");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (VopFcm0032Event)request.getAttribute("Event");
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

<body class="popup_bg" onLoad="setupPage();"> 
<form name="form">
<!-- 기본 필수 hidden -->
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- 업무용 hidden -->
<input type="hidden" name="tmp_vsl_cd" value="">
<input type="hidden" name="tmp_crr_cd" value="">
<input type="hidden" name="inc_del_vsl" value="Y">
<input type="hidden" name="param_fm_dt">
<input type="hidden" name="param_to_dt">
<input type="hidden" name="chk_date" value="<%=chk_date%>">





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
					<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Standard of FOC</td>
				</tr>
			</table>
			<!-- : ( Title ) (E) -->
			<!-- : ( Search Options ) (S) -->
<table class="search"> 
	<tr><td class="bg">
     	
	    	<!-- 메인 조건부 : biz_1  (S) -->
			<!--  biz_1  (S) -->
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="100">Budget Period</td>
				<td class="stm">&nbsp;<input type="text" name="fm_dt" style="width:60;" class="input1" caption="Period FM" dataformat="ym" size="8" maxlength="8" fulfill required value="<%=fm_date %>">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendarfm"  id="btns_calendarfm">&nbsp;~&nbsp;&nbsp;&nbsp;<input type="text" name="to_dt" caption="Period To" dataformat="ym" size="8" maxlength="8" fulfill style="width:60;" class="input1" value="">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendarto"  id="btns_calendarto"></td>
				<td width="50">Status</td>  
				<td class="stm"><input type="text" name="remark" style="width:80;text-align:center;ime-mode:disabled;" class="input2" size="10" maxlength="10"></td>
				<td width="80">Bunker Price</td>  
				<td class="stm"><input type="text" name="remark" style="width:80;text-align:center;ime-mode:disabled;" class="input2" size="10" maxlength="10"></td>
			</tr>
			</table>
			<!--  biz_1   (E) -->
			<table class="height_8"><tr><td colspan="8"></td></tr></table>
			
			<!-- 메인 결과부 : biz_2  (S) -->
			<!--  biz_2  (S) -->
			<table class="search"> 
       		<tr><td class="bg">
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
				<!--Button (S) -->				
				<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
		       	<tr><td class="btn2_bg">
				    <table border="0" cellpadding="0" cellspacing="0">
				    <tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
							<td class="btn2_right"></td>
							</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_save">Save</td>
							<td class="btn2_right"></td>
							</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_downexcel">Down&nbsp;Excel</td>
							<td class="btn2_right"></td>
							</tr>
						</table></td>
					</tr>
					</table>
				</td></tr>
				</table>
				<!--Button (S) -->
			</td></tr>
			</table>
			<!--  biz_2  (E) -->
			
	</td></tr>
</table>
<table class="height_8"><tr><td colspan="8"></td></tr></table>	

		<table class="height_5"><tr><td></td></tr></table>
		</td>
	</tr>
</table> 
	
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
											<td class="btn1" name="btn_OK">OK</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
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
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp"%>