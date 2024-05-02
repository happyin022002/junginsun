<%
/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : ESM_SQM_0009.jsp
*@FileTitle      : Lane-Office Relation Setting_New Lane Add Pop-up
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.20
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2013.05.20 SQM USER
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
<%@ page import="com.hanjin.apps.alps.esm.sqm.datamanage.officemapping.event.EsmSqm0009Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	String p_bse_tp_cd  = JSPUtil.getParameter(request, "f_bse_tp_cd", "");
	String p_bse_yr     = JSPUtil.getParameter(request, "f_bse_yr", "");
	String p_bse_qtr_cd = JSPUtil.getParameter(request, "f_bse_qtr_cd", "");
	String div_period   = JSPUtil.getParameter(request, "div_period", "");
	String p_ofc_vw_cd  = JSPUtil.getParameter(request, "f_text", "");

	EsmSqm0009Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.datamanage.officemapping");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		
		event = (EsmSqm0009Event)request.getAttribute("Event");
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
<title>Lane-Office Relation Setting_New Lane Add</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">

	var curTitle = "Lane-Office Relation Setting_New Lane Add";
	var curDescription = "Lane-Office Relation Setting_New Lane Add";
	var p_bse_tp_cd = "<%=p_bse_tp_cd%>";
	
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

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0">
	<tr><td class="top"></td></tr>
	<tr>
		<td valign="top">
			<!-- : ( Title ) (S) -->
			<table width="100%" border="0">
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
			<!-- : ( Title ) (E) -->
			
			<!-- : ( Search Options ) (S) -->
			<table class="search">
				<tr>
					<td class="bg">
						<table class="search">
							<tr>
								<td width="170">
									<table class="search_sm2" width="160">
										<tr class="h23">
											<td width="65"><input type="radio" class="trans" name="f_bse_tp_cd" value="Y" disabled><label style="padding-left:2;">Yearly</label></td>
											<td><input type="radio" class="trans" name="f_bse_tp_cd" value="Q" disabled><label style="padding-left:2;">Quarterly</label></td>
										</tr>
									</table>
								</td>
								<td>
									<table class="search" border="0">
										<tr class="h23">
											<td width="40">Year</td>
											<td width="60"><input type="text" style="text-align:center;" class="input2" size="4" name="f_bse_yr" value="<%=p_bse_yr%>" readOnly></td>
											<td width="60"><div id="div_qtr">Quarter</div></td>
											<td width="60"><input type="text" style="text-align:center;" class="input2" size="3" name="f_bse_qtr_cd" value="<%=p_bse_qtr_cd%>" readOnly></td>
											<td width="145" class='sm'><div id="div_period"></div></td>
											<td width="85">Office View</td>
											<td><input type="text" style="text-align:center;" class="input2" size="6" name="f_ofc_vw_cd" value="<%=p_ofc_vw_cd%>" readOnly></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
						<table class="search"><tr><td class="line_bluedot" style="height:11;"></td></tr></table>
						<table class="search">
							<tr class="h23">
								<td class="gray_tit"><img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">New Lane Info</td>
								<td width="85">
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" id="btn_Retrieve" name="btn_Retrieve">Retrieve</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td>
									<table class="search" border="0">
										<tr class="h23">
											<td width="50">Trade</td>
											<td width="75"><script language="javascript">ComComboObject('f_trd_cd', 1, 60, 0, 1)</script></td>
											<td width="70">Sub Trade</td>
											<td width="65"><script language="javascript">ComComboObject('f_sub_trd_cd', 1, 50, 0, 1)</script></td>
											<td width="85">Lane Bound</td>
											<td width="60"><script language="javascript">ComComboObject('f_dir_cd', 1, 45, 0, 1)</script></td>
											<td width="60">R/Lane</td>
											<td><script language="javascript">ComComboObject('f_rlane_cd', 1, 70, 0, 1)</script></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<!-- : ( Search Options ) (E) -->
			
			<table class="height_10"><tr><td></td></tr></table>
			
			<!-- TABLE '#D' : ( Search Options ) (S) -->
			<table class="search" border="0">
				<tr>
					<td class="bg_b1">
						<table class="height_10"><tr><td></td></tr></table>
						
						<!-- : ( POR ) (S) -->
						<table width="100%" id="mainTable">
							<tr>
								<td><script language="javascript">ComSheetObject('sheet1');</script></td>
							</tr>
						</table>
						<!-- : ( POR ) (E) -->
						
					</td>
				</tr>
			</table>
			<!-- TABLE '#D' : ( Search Options ) (E) -->
		</td>
	</tr>
</table>
<!-- OUTER - POPUP (E) -->

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
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Apply" id="btn_Apply">New Setting Apply</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td class="btn1_line"></td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Close" id="btn_Close">Close</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<!-- Repeat Pattern -->
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>