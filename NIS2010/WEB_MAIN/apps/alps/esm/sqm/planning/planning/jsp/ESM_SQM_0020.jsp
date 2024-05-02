<%
/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : ESM_SQM_0020.jsp
*@FileTitle      : RHQ Distribute Result
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
<%@ page import="com.hanjin.apps.alps.esm.sqm.planning.planning.event.EsmSqm0020Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSqm0020Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String trdCd = "";
	String rlaneCd = "";
	String dirCd = "";
	String ofcCd = "";
	String bseYr = "";
	String bseQtrCd = "";
	String bound = "";
	String officeView = "";
	String bseTpCd = "";
	String divPeriod = "";
	String trdDir = "";
	String f_click = "";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.datamanage.basicdata");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmSqm0020Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		trdCd = JSPUtil.getNull(request.getParameter("f_trd_cd"));
		rlaneCd = JSPUtil.getNull(request.getParameter("f_rlane_cd"));
		dirCd = JSPUtil.getNull(request.getParameter("f_dir_cd"));		
		ofcCd = JSPUtil.getNull(request.getParameter("f_rgn_ofc_cd"));
		bseYr = JSPUtil.getNull(request.getParameter("f_bse_yr"));
		bseQtrCd = JSPUtil.getNull(request.getParameter("f_bse_qtr_cd"));
		divPeriod = JSPUtil.getNull(request.getParameter("div_period"));
		bseTpCd = JSPUtil.getNull(request.getParameter("f_bse_tp_cd"));
		
		trdDir = JSPUtil.getNull(request.getParameter("f_trd_dir"));
		f_click = JSPUtil.getNull(request.getParameter("f_click"));
				
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>QTA Set-up by RHQ (O/B Loading)_Office Distribute Result</title>
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

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="f_ofc_vw_cd" value="L">
<input type="hidden" name="f_ob_div_cd" value="O">
<!-- 개발자 작업	-->

<!-- Outer Table (S)-->
<table width="100%" class="popup" cellpadding="10" border="0"> 
	<tr>
		<td>
			<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
			<table width="100%" border="0">
				<tr>
					<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;QTA Set-up by RHQ (O/B Loading)_Office Distribute Result</td>

				</tr>
			</table>
			<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->
			<!-- TABLE '#D' : ( Search Options ) (S) -->
			<table class="search">
				<tr>
					<td class="bg">
						<table class="search">
							<tr>
								<td width="100" rowspan="2">
									<table class="search_sm2" width="90">
										<tr class="h23"><td><input type="radio" name="f_bse_tp_cd" class="trans" value="Y" <%=bseTpCd.equals("Y")? "checked":"" %>><label style="padding-left:2;">Yearly</label></td></tr>
										<tr class="h23"><td><input type="radio" name="f_bse_tp_cd" class="trans" value="Q" <%=bseTpCd.equals("Q")? "checked":"" %>><label style="padding-left:2;">Quarterly</label></td></tr>
									</table>
								</td>
								<td>
									<table class="search" border="0">
										<tr class="h23">
											<td width="50">Year</td>
											<td width="65"><input type="text" style="width:50; ime-mode:disabled" name="f_bse_yr" class="input2" maxlength="20" readOnly value="<%=bseYr%>"></td>
											<td width="60"><div id="div_qtr">Quarter</div></td>
											<td width="70"><input type="text" style="width:50; ime-mode:disabled" name="f_bse_qtr_cd" class="input2" maxlength="20" readOnly value="<%=bseQtrCd%>"></td>
											<td width="210" class='sm'><div id="div_period"><%=divPeriod%></div></td>
											<td width="320"></td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td>
									<table class="search" border="0">
										<tr class="h23">
											<td width="50">Trade</td>
											<td width="65"><input type="text" style="width:50; ime-mode:disabled" name="f_trd_cd" class="input2" maxlength="20" readOnly value="<%=trdCd%>"></td>
											<td width="60">R/Lane</td>
											<td width="70"><input type="text" style="width:50; ime-mode:disabled" name="f_rlane_cd" class="input2" maxlength="20" readOnly value="<%=rlaneCd%>"></td>
											<td width="90"><div id="div_dir">Trade Bound</div></td>
											<td width="80"><div id="dir_cd"><input type="text" style="width:55; ime-mode:disabled" name="f_dir_cd" class="input2" maxlength="20" readOnly value="<%=dirCd%>"></div>
											<div id="trd_dir" style="display:none;"><input type="text" style="width:55; ime-mode:disabled" name="f_trd_dir" class="input2" maxlength="20" readOnly value="<%=trdDir%>"></div></td>
											<td width="25"><input type="checkbox" name="f_click" class="trans" <%=f_click.equals("on")? "checked":"" %>></td>
											<td width="80">Trade Dir.</td>
											<td width="50">Office</td>
											<td ><input type="text" style="width:65; ime-mode:disabled" name="f_rgn_ofc_cd" class="input2" maxlength="20" readOnly value="<%=ofcCd%>"></td>
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
						<tr><td class="gray" height="19" id="sheet_unit">[Unit: TEU, $]</td></tr>
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