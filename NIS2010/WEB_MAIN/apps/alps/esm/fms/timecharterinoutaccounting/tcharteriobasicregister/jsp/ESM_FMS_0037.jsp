<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_fms_0037.jsp
*@FileTitle : Revenue VVD Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.01
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.06.01 윤세영
* 1.0 Creation
* --------------------------------------------------------------
* History
* 2010.10.11 원종규 [CHM-201006364-01] FMS SYSTEM 변경 적용 - 추정 결산 항차 관련 NE4와 같이 Lane 숫자 포함되어지므로 숫자 혼용 가능하게 수정
* 2011.01.19 이준범 [CHM-201108373-01] Revenuse VVD Creation 관련
* 작업내용 : 1) ERP Target VVD 선정 I/F 시 FMS에 임의로 생성된 VVD 삭제
*          2) hidden 컬럼 생성 (finalizing_flg, processing_flg)
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.event.EsmFms0037Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmFms0037Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.TimeCharterInOutAccounting.TCharterIOBasicRegister");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmFms0037Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		//GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Revenue VVD Creation</title>
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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="finalizing_flg">
<input type="hidden" name="processing_flg">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">

	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->
	
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Revenue VVD Creation - Master</td></tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="60">&nbsp;&nbsp;Period</td>
					<td><input type="text" name="rev_yrmon" style="width:60;;text-align:center;ime-mode:disabled;" class="input1" maxlength="6" dataformat="ym" required fullfill caption="Period" >&nbsp;<img src="img/btns_calendar.gif" name="btn_period" style="cursor:hand" width="19" height="20" alt="" border="0" align="absmiddle"></td></tr>
				</table>
				<table class="search_sm2" border="0" style="width:300;"> 
				<tr class="">
					<td width="92"><strong>Created Type</strong></td>
					<td class="noinput1"><input type="radio" name="created_type" required value="C" class="trans" checked>Creation&nbsp;&nbsp;&nbsp;<input type="radio" name="created_type" required value="A" class="trans">Amend</td></tr>
				</table>
				<table class="height_2"><tr><td></td></tr></table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="330">
						<table class="search_sm2" border="0" style="width:300;"> 
							<tr class="h23">
								<td width="92">Condition</td>
								<td class="stm"><input type="radio" name="condition" value="S" class="trans" checked>Service&nbsp;&nbsp;&nbsp;<input type="radio" name="condition" value="R" class="trans">Revenue</td></tr>
						</table>
					</td>
					<td width="80">Service Lane</td>
					<td width="150"><input type="text" name="slan_cd" maxlength="3" style="width:60;text-align:center;ime-mode:disabled;" dataformat="engup" class="input" value="">&nbsp;<img src="img/btns_search.gif" name="btn_lanepop" style="cursor:hand" width="19" height="20" alt="" border="0" align="absmiddle"></td>
					<td width="90">Revenue Lane</td>
					<td width=""><input type="text" name="rlane_cd" maxlength="5" style="width:60;text-align:center;ime-mode:disabled;" dataformat="engup" class="input" value=""></td></tr>
				</table>
				<!--  biz_1   (E) -->
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
				<!--  biz_2  (S) -->
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Revenue VVD Creation -Grid</td></tr>
				</table>
				<!-- Grid  (S) -->
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table>
						<!-- Grid (E) -->
						<!--  Grid_button (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_add">Row&nbsp;Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_ins">Row&nbsp;Ins.</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_del">Row&nbsp;Del</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</table>
			</td></tr>
			</table>
	    	<!-- Grid_button (E) -->
				
				<!--  biz_2   (E) -->
				</td></tr>
			</table>
	
	<!--biz page (E)-->
	
	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       		<tr><td class="btn1_bg">
		    	<table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_savetofile">Down&nbsp;Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_vvdcreation">VVD CD&nbsp;Creation&nbsp;In&nbsp;FMS</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_vvdfinalizing">VVD CD&nbsp;Finalizing&nbsp;From&nbsp;ERP</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_vvdprocessing">VVD CD&nbsp;Processing&nbsp;From&nbsp;ERP</td>
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
		
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>