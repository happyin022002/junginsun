<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_AGT_041.jsp
*@FileTitle : Customized Report Form Pop-up 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2007-03-15
*@LastModifier : Hwang GyeongNam
*@LastVersion : 1.0
* 2007-03-15 Hwang GyeongNam
* 1.0 최초 생성
* 2009-10-01 : Ho-Jin Lee Alps 전환
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.event.EsmAgt0041Event"%>
<%@ page import="com.hanjin.apps.alps.esm.agt.common.Utils" %>
<%@ page import="com.hanjin.apps.alps.esm.agt.common.CodeUtil" %>
<%@ page import="com.hanjin.apps.alps.esm.agt.common.ComboUtil" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmAgt0041Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;				//서버에서 발생한 에러
	
	String strErrMsg = "";							//에러메세지
	String userId = "";
	String cboRptGroup = "";

try {

    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    userId = account.getUsr_id();

	event = (EsmAgt0041Event)request.getAttribute("Event");
	serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

	if (serverException != null) {
		strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
	} //else {
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
//	} // end else

	//Combo Data : getCodeCombo('태그명','초기값', '추가요소', '업무명', '조건코드', '전체유무', '추가옵션')
	cboRptGroup = ComboUtil.getCodeCombo("slct_itm_fom_seq", "",  " onChange='cboRptGroup_OnChange(this);' style='width:120'", "rptGroup", userId, " ", "");

} catch (Exception e) {
	out.println(e.toString());
}
%>
<html>
<head>
<title>Customized Report Form Pop-up</title>
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

<body onload="javascript:setupPage();">
<iframe height="0" width="0" name="frmHidden"></iframe>

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="txtGroup">
<input type="hidden" name="groupSeq">
<input type="hidden" name="saveFlag">
<input type="hidden" name="userId" value="<%=userId %>">
<input type="hidden" name="param1"> <!-- divNm -->
<input type="hidden" name="param2"> <!-- cboNm -->
<input type="hidden" name="param3"> <!-- defaultValue -->
<input type="hidden" name="param4"> <!-- addProperties -->
<input type="hidden" name="param5"> <!-- workName -->
<input type="hidden" name="param6"> <!-- param -->
<input type="hidden" name="param7"> <!-- allYN -->
<input type="hidden" name="param8"> <!-- addOption -->

<!-- OUTER - POPUP (S)tart -->
<table width="600" class="popup" cellpadding="10" border="0">
	<tr>
		<td class="top"></td>
	</tr>
	<tr>
		<td valign="top">
			<!-- : ( Title ) (S) -->
			<table width="100%" border="0">
				<tr>
					<td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp; Customized Report Form</td>
				</tr>
			</table>
			<!-- : ( Title ) (E) -->
			<!-- Search BG (S) -->
	 		<table class="search">
	   			<tr>
	   				<td class="bg">
						<!-- : ( Select Customized Form ) (S) -->
						<table class="search" border="0">
							<tr class="h23">
								<td width="145">Customized RPT Form</td>
								<td><div id="div_rptGroup"><%=cboRptGroup%></div></td>
							</tr>
						</table>
						<!-- : ( Select Customized Form ) (E) -->
						<table class="line_bluedot"><tr><td></td></tr></table>
						<!-- : ( Grid ) (S) -->
						<table class="search">
							<tr>
								<td width="46%">
									<table width="100%" id="mainTable">
		    				            <tr>
		    				            	<td><script language="javascript">ComSheetObject('sheet1');</script></td>
		    				            </tr>
		                			</table>
								</td>
								<td width="8%" valign="middle" align="center">
									<img src="/hanjin/img/button/btns_add.gif" width="26" height="26" border="0" name="btns_add"><br><br>
									<img src="/hanjin/img/button/btns_del.gif" width="26" height="26" border="0" name="btns_del">
								</td>
								<td width="46%">
									<table width="100%" id="mainTable">
		    				            <tr>
		    				            	<td><script language="javascript">ComSheetObject('sheet2');</script></td>
		    				            </tr>
		                			</table>
				                </td>
							</tr>
							<tr><td colspan="3" class="height_10"></td></tr>
							<tr><td colspan="3" class="stm"><input type="radio" class="trans" name="save_yn" value="N" onClick="btnCtrl('N');">&nbsp;Use This Setting At This Time Only</td></tr>
							<tr>
								<td colspan="3" class="stm">
									<input type="radio" class="trans" name="save_yn" value="Y" checked onClick="btnCtrl('Y');">&nbsp;Save This Setting As&nbsp;&nbsp;
									<input type="text" style="width:160;" name="save_name">
								</td>
							</tr>
						</table>
						<!-- : ( Grid ) (E) -->
					</td>
				</tr>
			</table>
			<!-- Search BG (S) -->
		</td>
	</tr>
</table>
<!-- OUTER - POPUP (E)nd -->
<table class="height_5"><tr><td></td></tr></table>
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup">
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
    		   	<tr>
    		   		<td class="btn3_bg">
		    			<table border="0" cellpadding="0" cellspacing="0">
		    				<tr>
								<!-- Repeat Pattern -->
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new">New</td><td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td class="btn1_line"></td>
								<td>
									<div id="div_save" style="display:block">
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_save" id="btn_save">Save</td><td class="btn1_right"></td>
										</tr>
									</table>
									</div>
									<div id="div_ok" style="display:none">
										<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr>
												<td class="btn1_left"></td><td class="btn1" name="btn_ok" id="btn_ok">OK</td><td class="btn1_right"></td>
											</tr>
										</table>
									</div>
								</td>
								<td class="btn1_line"></td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td><td class="btn1" name="btn_delete" id="btn_delete">Delete</td><td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td class="btn1_line"></td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<!-- Repeat Pattern -->
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<!-- : ( Button : pop ) (E) -->
		</td>
	</tr>
</table>
</form>
</body>
</html>
<%@include file="../../../common/include/common.jsp"%>