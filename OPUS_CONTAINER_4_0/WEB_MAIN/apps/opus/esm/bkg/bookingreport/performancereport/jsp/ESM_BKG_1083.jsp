<%
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_BKG_1083.jsp
*@FileTitle : B/L Detail 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingreport.performancereport.event.EsmBkg1083Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.SearchBookingTrendReportVO"%>

<%
	EsmBkg1083Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			// error from server
	String strErrMsg = "";						// error message
	int rowCount	 = 0;						// count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	SearchBookingTrendReportVO vo = null;
	
	Logger log = Logger.getLogger("com.clt.apps.BookingReport.PerformanceReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg1083Event)request.getAttribute("Event");
		vo = event.getSearchBookingTrendReportVO();
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
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


<input type="hidden" name="vvd_sig" value="<%=vo.getVvdSig()%>">
<input type="hidden" name="etd_wk" value="<%=vo.getEtdWk()%>">
<input type="hidden" name="dis_op" value="<%=vo.getDisOp()%>">
<input type="hidden" name="bl_no" value="<%=vo.getBlNo()%>">
<input type="hidden" name="c_feu" value="<%=vo.getCFeu()%>">
<input type="hidden" name="ob_srep_cd" value="<%=vo.getObSrepCd()%>">
<input type="hidden" name="c_teu" value="<%=vo.getCTeu()%>">
<input type="hidden" name="pol_cd" value="<%=vo.getPolCd()%>">
<input type="hidden" name="sel_ob_srep_cd" value="<%=vo.getSelObSrepCd()%>">
<input type="hidden" name="sel_vvd" value="<%=vo.getSelVvd()%>">
<input type="hidden" name="bkg_cre_dt" value="<%=vo.getBkgCreDt()%>">
<input type="hidden" name="ob_sls_ofc_cd" value="<%=vo.getObSlsOfcCd()%>">
<input type="hidden" name="cust_cnt_cd" value="<%=vo.getCustCntCd()%>">
<input type="hidden" name="grp_op" value="<%=vo.getGrpOp()%>">
<input type="hidden" name="bkg_ofc_cd" value="<%=vo.getBkgOfcCd()%>">
<input type="hidden" name="from_wk" value="<%=vo.getFromWk()%>">
<input type="hidden" name="sel_etd_dt" value="<%=vo.getSelEtdDt()%>">
<input type="hidden" name="trnk_vvd_cd" value="<%=vo.getTrnkVvdCd()%>">
<input type="hidden" name="del_cd" value="<%=vo.getDelCd()%>">
<input type="hidden" name="bkg_cre_wk" value="<%=vo.getBkgCreWk()%>">
<input type="hidden" name="cmpb" value="<%=vo.getCmpb()%>">
<input type="hidden" name="vvd" value="<%=vo.getVvd()%>">
<input type="hidden" name="pod_cd" value="<%=vo.getPodCd()%>">
<input type="hidden" name="unit_op" value="<%=vo.getUnitOp()%>">
<input type="hidden" name="pol_etd_fr_dt" value="<%=vo.getPolEtdFrDt()%>">
<input type="hidden" name="cntr_tp_sz" value="<%=vo.getCntrTpSz()%>">
<input type="hidden" name="bkg_no" value="<%=vo.getBkgNo()%>">
<input type="hidden" name="cm" value="<%=vo.getCm()%>">
<input type="hidden" name="cost_wk" value="<%=vo.getCostWk()%>">
<input type="hidden" name="cust_cd" value="<%=vo.getCustCd()%>">
<input type="hidden" name="xter_rmk" value="<%=vo.getXterRmk()%>">
<input type="hidden" name="load" value="<%=vo.getLoad()%>">
<input type="hidden" name="sel_slan_cd" value="<%=vo.getSelSlanCd()%>">
<input type="hidden" name="por_cd" value="<%=vo.getPorCd()%>">
<input type="hidden" name="cust_nm" value="<%=vo.getCustNm()%>">
<input type="hidden" name="trade" value="<%=vo.getTrade()%>">
<input type="hidden" name="bkg_ofc_sub" value="<%=vo.getBkgOfcSub()%>">
<input type="hidden" name="bkg_sts_cd" value="<%=vo.getBkgStsCd()%>">
<input type="hidden" name="chk_cxl_bkg_only" value="<%=vo.getChkCxlBkgOnly()%>">
<input type="hidden" name="ob_sls_ofc_sub" value="<%=vo.getObSlsOfcSub()%>">
<input type="hidden" name="s_trade" value="<%=vo.getSTrade()%>">
<input type="hidden" name="inter_rmk" value="<%=vo.getInterRmk()%>">
<input type="hidden" name="cmdt_cd" value="<%=vo.getCmdtCd()%>">
<input type="hidden" name="bkg_cxl_dt" value="<%=vo.getBkgCxlDt()%>">
<input type="hidden" name="to_wk" value="<%=vo.getToWk()%>">
<input type="hidden" name="dis_val" value="<%=vo.getDisVal()%>">
<input type="hidden" name="sel_cust_cd" value="<%=vo.getSelCustCd()%>">
<input type="hidden" name="coa_year" value="<%=vo.getCoaYear()%>">
<input type="hidden" name="etd_dt" value="<%=vo.getEtdDt()%>">
<input type="hidden" name="cust_seq" value="<%=vo.getCustSeq()%>">
<input type="hidden" name="cmdt_nm" value="<%=vo.getCmdtNm()%>">
<input type="hidden" name="bkg_cxl_wk" value="<%=vo.getBkgCxlWk()%>">
<input type="hidden" name="vvd_slan_cd" value="<%=vo.getVvdSlanCd()%>">
<input type="hidden" name="bkg_cxl_fr_dt" value="<%=vo.getBkgCxlFrDt()%>">
<input type="hidden" name="cm_cur" value="<%=vo.getCmCur()%>">
<input type="hidden" name="bkg_cxl_to_dt" value="<%=vo.getBkgCxlToDt()%>">
<input type="hidden" name="sel_op" value="<%=vo.getSelOp()%>">
<input type="hidden" name="slan_cd" value="<%=vo.getSlanCd()%>">
<input type="hidden" name="sel_cost_wk" value="<%=vo.getSelCostWk()%>">
<input type="hidden" name="sel_pol_cd" value="<%=vo.getSelPolCd()%>">
<input type="hidden" name="pk_tp" value="<%=vo.getPkTp()%>">
<input type="hidden" name="dis_days" value="<%=vo.getDisDays()%>">
<input type="hidden" name="pol_etd_to_dt" value="<%=vo.getPolEtdToDt()%>">


<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;B/L Detail</td></tr>
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
										<script language="javascript">ComSheetObject('sheet1');</script>
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

</form>
</body>
</html>