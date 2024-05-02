<%
/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : ESM_SQM_0018.jsp
*@FileTitle      : QTA Set up by Head Office RHQ QTA Summary
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.08
*@LastModifier   : JEONGMIN CHO
*@LastVersion    : 1.0
* 2013.05.08 JEONGMIN CHO
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
<%@ page import="com.hanjin.apps.alps.esm.sqm.planning.planning.event.EsmSqm0018Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%

	String p_bse_tp_cd  = JSPUtil.getParameter(request, "f_bse_tp_cd", "");
	String p_bse_yr     = JSPUtil.getParameter(request, "f_bse_yr", "");
	String p_bse_qtr_cd = JSPUtil.getParameter(request, "f_bse_qtr_cd", "");
	String div_period   = JSPUtil.getParameter(request, "div_period", "");
	String p_ofc_vw_cd  = JSPUtil.getParameter(request, "f_ofc_vw_cd", "");
	String p_trd_cd     = JSPUtil.getParameter(request, "f_trd_cd", "");
	String p_rlane_cd   = JSPUtil.getParameter(request, "f_rlane_cd", "");
	String p_dir_cd     = JSPUtil.getParameter(request, "f_dir_cd", "");
	String p_trd_dir    = JSPUtil.getParameter(request, "f_trd_dir", "");
	String p_ob_div_cd  = JSPUtil.getParameter(request, "f_ob_div_cd", "");
	String p_rhq_cd     = JSPUtil.getParameter(request, "f_rhq_cd", "");
	String p_click      = JSPUtil.getParameter(request, "f_click", "");

	EsmSqm0018Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.datamanage.basicdata");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmSqm0018Event)request.getAttribute("Event");
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
<title>QTA Set up by Head Office_RHQ QTA Summary</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	var curTitle = "QTA Set up by Head Office_RHQ QTA Summary";
	var curDescription = "QTA Set up by Head Office_RHQ QTA Summary";
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

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="f_ofc_vw_cd" value="<%=p_ofc_vw_cd%>">


<!-- 개발자 작업	-->

<!-- Outer Table (S)-->
<table width="100%" class="popup" cellpadding="10" border="0"> 
	<tr><td class="top"></td></tr>
	<tr>
		<td valign="top">
			<!-- : ( Title ) (S) -->
			<table width="100%" border="0">
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
			<!-- : ( Title ) (E) -->
			
			<table class="height_10"><tr><td></td></tr></table>
			<!-- TABLE '#D' : ( Search Options ) (S) -->
			<table class="search">
				<tr>
					<td class="bg">
						<table class="search">
							<tr>
								<td width="105" rowspan="2">
									<table class="search_sm2" width="95">
										<tr class="h23"><td><input type="radio" name="f_bse_tp_cd" class="trans" value="Y" disabled><label style="padding-left:2;">Yearly</label></td></tr>
										<tr class="h23"><td><input type="radio" name="f_bse_tp_cd" class="trans" value="Q" disabled><label style="padding-left:2;">Quarterly</label></td></tr>
									</table>
								</td>
								<td>
									<table class="search" border="0">
										<tr class="h23">
											<td width="40">Year</td>
											<td width="60"><input type="text" style="text-align:center;width:45;" class="input2" name="f_bse_yr" value="<%=p_bse_yr%>" readOnly></td>
											<td width="90"><div id="div_qtr">Quarter</div></td>
											<td width="55"><input type="text" style="text-align:center;width:40;" class="input2" name="f_bse_qtr_cd" value="<%=p_bse_qtr_cd%>" readOnly></td>
											<td width="140" class="sm"><div id="div_period"></div></td>
											<td width="75">Office View</td>
											<td><input type="text" style="text-align:center;width:65;" class="input2" name="ofc_vw_cd" readOnly></td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td>
									<table class="search" border="0">
										<tr class="h23">
											<td width="40">Trade</td>
											<td width="60"><input type="text" style="text-align:center;width:45;" name="f_trd_cd" class="input2" readOnly value="<%=p_trd_cd%>"></td>
											<td width="90"><div id="div_dir">Trade Bound</div></td>
											<td width="55"><div id="dir_cd"><input type="text" style="text-align:center;width:40; ime-mode:disabled" name="f_dir_cd" class="input2" maxlength="20" readOnly value="<%=p_dir_cd%>"></div>
											<div id="trd_dir" style="display:none;"><input type="text" style="text-align:center;width:40; ime-mode:disabled" name="f_trd_dir" class="input2" maxlength="20" readOnly value="<%=p_trd_dir%>"></div></td>
											<td width="25"><input type="checkbox" name="f_click" class="trans" <%=p_click.equals("on")? "checked":"" %>></td>
											<td width="115">Trade Dir.</td>
											<td width="75">N.OB/OB</td>
											<td width="80"><input type="text" style="text-align:center;width:65;" name="f_ob_div_cd" class="input2" readOnly value="<%=p_ob_div_cd%>"></td>
											<td width="40">RHQ</td>
											<td><input type="text" style="text-align:center;width:65;" name="f_rhq_cd" class="input2" readOnly value="<%=p_rhq_cd%>"></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<!-- TABLE '#D' : ( Search Options ) (E) -->
			
			<table class="height_10"><tr><td></td></tr></table>
			<!-- TABLE '#D' : ( Search Options ) (S) -->
			<table class="search" border="0">
				<tr>
					<td class="bg_b1">
						<table class="height_10"><tr><td></td></tr></table>
						
						<table width="100%" class="search">
							<tr>
								<td style="text-align:right;">[Unit : TEU, %, $]</td>
							</tr>
						</table>
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
			
			
			<!-- TABLE '#D' : ( Button : pop ) (S) -->
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
														<td class="btn1" id="btn_DownExcel" name="btn_DownExcel">Down Excel</td>
														<td class="btn1_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn1_left"></td>
														<td class="btn1" id="btn_close" name="btn_close">Close</td>
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
			<!-- TABLE '#D' : ( Button : pop ) (E) -->
		</td>
	</tr>
</table>
<!-- Outer Table (E)-->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>