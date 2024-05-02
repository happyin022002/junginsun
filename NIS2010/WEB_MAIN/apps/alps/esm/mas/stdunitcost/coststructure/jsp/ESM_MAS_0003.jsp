<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_MAS_0003.jsp
*@FileTitle : 물류비용 코드 등록
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-13
*@LastModifier : OKYOUNG IM
*@LastVersion : 1.0
* 2006-10-13 OKYOUNG IM
* 1.0 최초 생성
* =========================================================
* History
* 2008.05.02 임옥영 R200804296327 CSS파일 경로 변경
* 2009.09.16 김기식 Alps전환작업 
* 2010.05.28 송호진 [Legacy전환] UI 표준안 적용 요청 관련 수정 : 
                   CHM-200901714, CHM-200901715, CHM-200901716, CHM-200901717, CHM-200901718, CHM-200901719
* 2010.09.01 김기종 Ticket ID:CHM-201004982-01 MAS Architecture 위배사항 수정
* 2014.05.09 박다은 [CHM-201430133] [MAS] Register Cost Item의 Save 기능 제한 요청
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.vo.CostStructureSoCodeRtnVO"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>

<%
	Exception serverException   = null;								//서버에서 발생한 에러
	String strErrMsg = "";													//에러메세지
	GeneralEventResponse eventResponse = null;
	String hdCode = "";
	String hdText = "";
	String strOfc_cd = "";
	
	try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strOfc_cd = account.getOfc_cd();        
		
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{
			eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
        }	
	}catch(Exception e) {
		out.println(e);
	}
	if (eventResponse != null) {
    	CostStructureSoCodeRtnVO retVo = (CostStructureSoCodeRtnVO)eventResponse.getCustomData("retVo");
    	
    	hdCode = retVo.getHeaderCode();
    	hdText = retVo.getHeaderText();			
    }
%>
<html>
<head>
<title>Register Cost Item</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage('<%=hdCode%>', '<%=hdText%>');
	}
</script>

</head>
<iframe height="0" width="0" name="frmHidden"></iframe>
<form name = "hiddenF" mehhod="post">
<input type="hidden" name="f_cmd">
</form>

<body onload="javascript:setupPage();">
<form method="post" name="form" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="f_header_code" value="<%=hdCode%>">
<input type="hidden" name="f_header_text" value="<%=hdText%>">

<!-- OUTER FRAME : "to make sum of components' HEIGHTS 100%" (S)tart -->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>
<!-- main 영역 시작 -->
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"> Sales Management > Managerial Accounting System > Cost Table > Set-Up C/A Code > Register Cost Item</td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> Register Cost Item</td></tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->

		 <!--Button (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
		       	<tr><td class="btn1_bg">

					<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<!-- Repeat Pattern -->
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>

						<td class="btn1_line"></td>

						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1" id="btn_downexcel" name="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
						<!-- Repeat Pattern -->

					</tr></table>

				</td></tr>
			</table>
		<!--Button (E) -->

		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
		<tr><td class="bg">

				<!-- : ( Location ) (S) -->
				<table class="search_in" border="0">
				<tr class="h23">
					<td width="290"><input type="radio" value="1" class="trans"  name="code" onClick="goURL(1)">&nbsp;Cost Element&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" value="2" class="trans" name="code" checked>&nbsp;So Cost Code</td>
					<td width="75">Sub Group</td>
					<td width="250">
						<!--사이즈 가변 처리 요망 -->
						<script language="javascript">ComComboObject('f_sgrp_cost_cd',1, 220 , 0 )</script>
					</td>
					<td width="70">MAS Code</td>
					<td>
						<script language="javascript">ComComboObject('f_stnd_cost_cd',1, 220 , 0 )</script>
					</td>
				</tr>
				</table>
				<!-- : ( Location ) (E) -->

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>
	<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
		<tr><td class="bg">

				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Register Cost Items</td>
					<td align="right">
							<table border="0" cellpadding="0" cellspacing="0">
							<tr>

								<!-- Repeat Pattern -->
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" id="btng_hidecheckbox" name="btng_hidecheckbox">Hide Check Box</td><td class="btn2_right"></td></tr></table></td>
								<!-- Repeat Pattern -->

							</tr></table>					</td>
				<tr><td class="height_5"></td>
				</tr>
				</table>

				<!-- : ( From Location ) (S) -->
				<table width="100%" id="mainTable">
					<tr><td>
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td></tr>
				</table>
				<!-- : ( From Location ) (E) -->

				<!-- : ( Button : Grid ) (S) -->
				<table width="100%" class="button">
			       	<tr><td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0">
					<tr>
					<%
						// [CHM-201430133] [MAS] Register Cost Item의 Save 기능 제한 요청
						if( "SELOPA".equals(strOfc_cd)|| "SELAPM".equals(strOfc_cd)|| "SELCSG".equals(strOfc_cd)) {
					%>
						<!-- Repeat Pattern -->
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td><td class="btn2" id="btng_rowadd" name="btng_rowadd">Row Add</td><td class="btn2_right"></td></tr></table></td>

						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td><td class="btn2" id="btng_save" name="btng_save">Save</td><td class="btn2_right"></td></tr></table></td>
					<%
					}
					%> 
						<!-- Repeat Pattern -->


					</tr></table>
				</td></tr>
				</table>
				<!-- : ( Button : Grid ) (E) -->

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->
<!-- main  영역 끝 -->


</td></tr>
</table>
<!-- OUTER FRAME : "to make sum of components' HEIGHTS 100%" (E)nd -->

</form>
</body>
</html>