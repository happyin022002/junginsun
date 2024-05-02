<%
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_BKG_1175.jsp
*@FileTitle : B/L Detail 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.05
*@LastModifier : 임재관
*@LastVersion : 1.0
* 2010.02.17 임재관
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.event.EsmBkg1175Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.SurchageSummaryInVO"%>

<%
	EsmBkg1175Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	SurchageSummaryInVO vo = null;
	
	Logger log = Logger.getLogger("com.hanjin.apps.BookingReport.StatusReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		
		event = (EsmBkg1175Event)request.getAttribute("Event");
		vo = event.getSurchageSummaryInVO();
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	String charge_cd = vo.getChargeCd();
%>
<html>
<head>
<title>B/L Detail </title>
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

<!-- 개발자 작업	-->
<input type="hidden" name="tab_cd" value="<%=1%>">
<input type="hidden" name="charge_cd" value="<%=vo.getChargeCd()%>">
<input type="hidden" name="ctr_rfa_cd" value="<%=vo.getCtrRfaCd()%>">
<input type="hidden" name="fr_dt" value="<%=vo.getFrDt()%>">
<input type="hidden" name="to_dt" value="<%=vo.getToDt()%>">
<input type="hidden" name="ctr_rfa_cd" value="<%=vo.getChargeCd()%>">
<input type="hidden" name="ctr_rfa_no" value="<%=vo.getCtrRfaNo()%>">
<input type="hidden" name="p_rhq_bkg_ofc_cd" value="<%=vo.getPRhqBkgOfcCd()%>">
<input type="hidden" name="p_gso_bkg_ofc_cd" value="<%=vo.getPGsoBkgOfcCd()%>">
<input type="hidden" name="p_rhq_ctrt_ofc_cd" value="<%=vo.getPRhqCtrtOfcCd()%>">
<input type="hidden" name="p_ctrt_ofc_cd" value="<%=vo.getPCtrtOfcCd()%>">
<input type="hidden" name="p_svc_scp_cd" value="<%=vo.getPSvcScpCd()%>">
<input type="hidden" name="p_por_cd" value="<%=vo.getPPorCd()%>">
<input type="hidden" name="p_pol_cd" value="<%=vo.getPPolCd()%>">
<input type="hidden" name="p_pod_cd" value="<%=vo.getPPodCd()%>">
<input type="hidden" name="p_del_cd" value="<%=vo.getPDelCd()%>">
<input type="hidden" name="p_sel_ofc_cd" value="<%=vo.getPSelOfcCd()%>">
<input type="hidden" name="p_sel_ofc_cd2" value="<%=vo.getPSelOfcCd2()%>">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><label id="lbTitle">&nbsp;B/L Detail</label></label></td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
		<!--biz page (S)-->
		
			<table class="search"> 
       		<tr><td class="bg">
			
				<!-- : ( Grid ) (S) -->
							<table width="100%"  id="mainTable"> 
								<tr>
									<td width="100%">
										<% if("4".equals(charge_cd)){ %>
											<script language="javascript">ComSheetObject('LBPsheet');</script>
										<% }else if("5".equals(charge_cd)){ %>
											<script language="javascript">ComSheetObject('TPFsheet');</script>
										<% }else if("6".equals(charge_cd) || "7".equals(charge_cd)){ %>
											<script language="javascript">ComSheetObject('CTC_LSIsheet');</script>
										<% }else{ %>
											<script language="javascript">ComSheetObject('sheet1');</script>
										<% } %>
										
									</td>
								</tr>
							</table>
				<!-- : ( Grid ) (E) -->	
			
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->

<table class="height_5"><tr><td></td></tr></table>
</td></tr>
</table> 
	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_excel">Down Excel</td>
					<td class="btn1_right">
				</tr></table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right">
				</tr></table></td>
			</tr>
		</table></td>
			</tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>

</body>
</html>