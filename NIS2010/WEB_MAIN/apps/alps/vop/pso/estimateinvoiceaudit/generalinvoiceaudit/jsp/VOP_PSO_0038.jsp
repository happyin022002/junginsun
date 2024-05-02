<%
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VOP_PSO_0038.jsp
*@FileTitle : Port Charge Simulation
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.30
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2010.01.14 정명훈
* 1.0 Creation
*
* History
* 2010.11.22 진마리아 CHM-201006692-01 Port charge simulation 이 터미널별로 한번에 계산이 될수 있도록 멀티 기능 추가
* 2011.03.14 진마리아 CHM-201109292-01 Location 조회불가건 수정 보완 요청
* 2011.03.30 진마리아 (CHM-201006692-01 관련) Locl Curr 가 섞였을 때, total 값을 표시하지 않는다.
* 2016.07.09 Arie Im CHM-201641447 PSO Auto Audit - Audit Tool(Tariff Simulation) 추가
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.event.VopPso0038Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopPso0038Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.EstimateInvoiceAudit.GeneralInvoiceAudit");
	
	//Audit화면에서 호출하는 경우 사용하는 변수
	String pUiId = "";
	String pPortCd = "";
	String pYardCd = "";
	String pAcctCd = "";
	String pCostCd = "";
	String pVvd = "";
	String pVndrSeq = "";
	String pIssueDate = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopPso0038Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		pUiId		= JSPUtil.getParameter(request, "pUiId",		"");
		pPortCd		= JSPUtil.getParameter(request, "pPortCd",		"");
		pYardCd		= JSPUtil.getParameter(request, "pYardCd",		"");
		pAcctCd    	= JSPUtil.getParameter(request, "pAcctCd",      "");
		pCostCd		= JSPUtil.getParameter(request, "pCostCd",		"");	
		pVvd   		= JSPUtil.getParameter(request, "pVvd",			"");	
		pVndrSeq    = JSPUtil.getParameter(request, "pVndrSeq",		"");	
		pIssueDate	= JSPUtil.getParameter(request, "pIssueDate",	"");	
		
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Port Charge Simulation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		var uiId = "<%=pUiId%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();

		if(uiId == 'ESD_EAS_0301') {
			simSearchAudit('<%= pPortCd %>', '<%= pYardCd %>', '<%= pAcctCd %>', '<%= pCostCd %>', '<%= pVvd %>', '<%= pVndrSeq %>', '<%= pIssueDate %>');
		}
		
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd"/>
<input type="hidden" name="pagerows"/>
<input type="hidden" name="yd_chg_no" value="" />		<!-- Tariff No -->
<input type="hidden" name="yd_chg_ver_seq" value="" />	<!-- Tariff Version -->
<input type="hidden" name="curr_cd" value="" />			<!-- Tariff Currency -->
<input type="hidden" name="upd_usr_id" value="" />		<!-- Tariff User ID -->
<input type="hidden" name="upd_dt" value=""/>			<!-- Tariff Updated Date -->
<input type="hidden" name="uiId" value="<%= pUiId %>"/>

<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;padding-right:5;">
	<tr>
		<td valign="top">
	
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
	
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
	       	<tr><td class="btn1_bg">
			    <table border="0" cellpadding="0" cellspacing="0">
				    <tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_Retrieve">Retrieve</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_New">New</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>
						<td class="btn1_line"></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_Calculation">Calculation</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>
					</tr>
				</table>
				</td>			
			</tr>
			</table>
		
			<table class="search"> 
		       	<tr>
		       		<td class="bg">
						<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
								<td width="37">Port</td>
								<td width="170"><input name="port_cd" type="text" dataformat="uppernum" style="width:50" class="input1" value="" size="5" maxlength="5">&nbsp;<img class="cursor" name="btn_port_cd" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">&nbsp;
								<script language="javascript">ComComboObject('yard_cd',2, 50, 0, 1);</script>
								</td>
								<td width="95"> Account  CD</td>
								<td width="98" style="padding-left:2"><script language="javascript">ComComboObject('acct_cd',2, 96, 0, 1);</script></td>
								<td width="202"><input type="text" name="account_nm" style="width:180;text-align:left" class="input2" value="" readonly></td>
								<td width="55"> Cost  CD</td>
								<td width="92" style="padding-left:2"><script language="javascript">ComComboObject('cost_cd',2, 90, 0, 1);</script></td>
								<td width=""><input type="text" name="lgs_cost_nm" style="width:240;text-align:left" class="input2" value="" readonly></td>
							</tr>
						</table>
						<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
								<td width="36">VVD</td>
								<td width="162"><input type="text" name="vsl_cd" dataformat="engup" style="width:40;ime-mode:disabled;text-align:center;" class="input" value="" maxlength="4">&nbsp;<input type="text" name="skd_voy_no" dataformat="int" style="width:40;ime-mode:disabled;text-align:center;" class="input" value=""  maxlength="4">&nbsp;<input type="text" name="skd_dir_cd" dataformat="engup" style="width:25;ime-mode:disabled;text-align:center;" class="input" value=""  maxlength="1">&nbsp;<img class="cursor" name="btn_vvd_search" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
<!--								<td width="53">Class</td>
								<td width="130"><script language="javascript">ComComboObject('cntr_vsl_clss_capa',2, 96, 0, 1);</script></td>
-->								
								<td width="92">Issue Date</td>
								<td width="140"><input name="issue_date" type="text" dataformat="ymd" maxlength="8" style="width:73;ime-mode:disabled" class="input1" value="">&nbsp;<img class="cursor" name="btns_Calendar1" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
								<td width="105">Service Provider</td>
								<td width="293"><script language="javascript">ComComboObject('vndr_seq',2, 96, 0, 1);</script>&nbsp;<input type="text" name="vndr_lgl_eng_nm" style="width:180;text-align:left" class="input2" value="" readonly></td>
								<!--<td width=""></td>
								 <td><input name="currType" type="radio" value="1" class="trans" checked>LOCAL&nbsp;
								<input name="currType" type="radio" value="2" class="trans">USD</td>
								 -->
								<td><table class="search_sm2" border="0"> 
									<tr class="h23">
										<td width="40">Curr</td>
										<td><input name="currType" type="radio" value="1" class="trans" checked>Tariff&nbsp;<input name="currType" type="radio" value="2" class="trans">USD</td>
									</tr>
								</table></td>
							</tr>
						</table>
				
						<table class="line_bluedot"><tr><td></td></tr></table>
						
						<table width="979" class="search" border="0" bordercolor="#000000">
							<tr class="h23">
								<td width="100%" valign="top">
									<table width="100%" border="0">
										<tr>
											<td>
												<table width="100%" id="mainTable"> 
													<tr>
														<td width="33%">
															<script language="javascript">ComSheetObject('sheet1');</script>
														</td>
														<td width="0.5%">&nbsp;</td>
														<td width="33%">
															<script language="javascript">ComSheetObject('sheet2');</script>
														</td>
														<td width="0.5%">&nbsp;</td>
														<td width="33%">
															<script language="javascript">ComSheetObject('sheet3');</script>
														</td>
													</tr>
												</table>
											</td>
										</tr>	
										<tr>
											<td>	
												<table class="search" border="0">
													<tr>
														<td colspan="3" height="13"></td>
													</tr>												
													<tr>
														<td class="title_h"></td>
														<td width="" class="title_s">Tariff Cost Detail</td>
													</tr>
												</table>
											</td>
										</tr>
										<tr>
											<td>
												<table width="100%" id="mainTable"> 
													<tr>
														<td>
															<script language="javascript">ComSheetObject('sheet4');</script>
														</td>
													</tr>
												</table>
											</td>
										</tr>		
									</table>
								</td>
								</tr>
							<tr class="h23">
								<td width="100%" valign="top" colspan="3">
									<table class="search" border="0">
										<tr>
											<td colspan="2" height="13">&nbsp;</td>
										</tr>
										<tr>
											<td class="title_h"></td>
											<td width="" class="title_s">Invoice Detail</td>
										</tr>
									</table>
									<table width="100%" id="mainTable"> 
										<tr>
											<td width="100%">
												<script language="javascript">ComSheetObject('sheet5');</script>
											</td>
										</tr>
									</table>
									<table width="100%" id="mainTable"> 
										<tr>
											<td width="100%">
												<script language="javascript">ComSheetObject('sheet6');</script>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<table class="height_10"><tr><td></td></tr></table>
		</td>
	</tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
<%@include file="/bizcommon/include/common_nis2010.jsp"%>