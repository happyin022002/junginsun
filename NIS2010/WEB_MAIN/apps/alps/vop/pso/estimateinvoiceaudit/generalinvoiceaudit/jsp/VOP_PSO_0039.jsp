<%
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VOP_PSO_0039.jsp
*@FileTitle : Tariff Simulation by VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.25
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.06.10 진마리아
* 1.0 Creation
* 
* History
* 2011.06.15 진마리아 CHM-201111910-01 [PSO] Tariff Simulation By VVD 신규화면 생성
* 2012.09.25 진마리아 CHM-201220208-01 YD/ACCT별 Detail 비용을 Excel Down 기능 추가
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.event.VopPso0039Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopPso0039Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.EstimateInvoiceAudit.GeneralInvoiceAudit");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopPso0039Event)request.getAttribute("Event");
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
<title>Port Charge Simulation</title>
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
<input type="hidden" name="f_cmd"/>
<input type="hidden" name="pagerows"/>
<input type="hidden" name="yd_chg_no" value="" />		<!-- Tariff No -->
<input type="hidden" name="yd_chg_ver_seq" value="" />	<!-- Tariff Version -->
<input type="hidden" name="curr_cd" value="" />			<!-- Tariff Currency -->
<input type="hidden" name="upd_usr_id" value="" />		<!-- Tariff User ID -->
<input type="hidden" name="upd_dt" value=""/>			<!-- Tariff Updated Date -->

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
							<td class="btn1" name="btn_New">New</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_DownExcel">Detail</td>
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
								<td width="36">VVD</td>
								<td width="162"><input type="text" name="vvd" dataformat="engup" style="width:105;ime-mode:disabled;text-align:center;" class="input1" value="" maxlength="9"></td>
								<td width="200" align="right">Apply Expense Ratio&nbsp;<input type="checkbox" name="exp_rto" value="Y" class="trans"></td>
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
														<td>
															<script language="javascript">ComSheetObject('sheet1');</script>
															<script language="javascript">ComSheetObject('sheet2');</script>
															<script language="javascript">ComSheetObject('sheet3');</script>
														</td>
													</tr>
												</table>
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