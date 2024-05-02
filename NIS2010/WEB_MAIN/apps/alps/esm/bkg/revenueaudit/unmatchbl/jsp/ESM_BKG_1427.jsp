<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_1427.jsp
*@FileTitle : Multi Rate BKG List for Audit(1)
*Open Issues :
*Change history :
*@LastModifyDate : 2017.10.24
*@LastModifier : 전두태
*@LastVersion : 1.0
* 2017.10.24 전두태
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.event.EsmBkg1427Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.revenueauditcommon.rascommon.rascommon.vo.RsltCdListVO"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.revenueauditcommon.rascommon.rascommon.vo.RsltContiListVO"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.revenueauditcommon.common.RASUtil"%>
<%@ page import="com.hanjin.framework.component.common.AbstractValueObject"%>
<%@ page import="java.util.List"%>
<%
	EsmBkg1427Event event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount = 0;							//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String strRhq_ofc_cd = "";
	String strOfc_cd = "";
	
    String[] rhqs = null;
	String[] scps = null;
    String[] contractTypes = null;

	Logger log = Logger.getLogger("com.hanjin.apps.RevenueAudit.UnmatchBL");

	try {
	   	SignOnUserAccount account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strRhq_ofc_cd = account.getRhq_ofc_cd();
		strOfc_cd = account.getOfc_cd();

		event = (EsmBkg1427Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
        // rhq
        rhqs = RASUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("rhq"));
		// service scope
		scps = RASUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("scp"));
		
        contractTypes = RASUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("contractType"), false , "|", "\t", "getCode", "getName");
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Multi Rate BKG List for Audit(1)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
    var rhqComboValue = "|<%=rhqs[0]%>";
    var scpComboValue = "|<%=scps[0]%>";
    var scpComboText = "|<%=scps[1]%>";
    var contractTypeComboValue = "|<%=contractTypes[0]%>";
    var contractTypeComboText = "|<%=contractTypes[1]%>";
	
	function setupPage() {
		var errMessage = "<%=strErrMsg%>";
		
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		}	// end if

		loadPage();
	}
</script>
</head>
<body onLoad="setupPage();">
	<form name="form">
		<input type="hidden" name="f_cmd">
		<input type="hidden" name="pagerows">
		<!-- 개발자 작업	-->
		<!-- combo -->
		<input type="hidden" name="cd" value="">
		<input type="hidden" name="etc1" value="">
		<input type="hidden" name="etc2" value="">
		<input type="hidden" name="etc3" value="">
		<input type="hidden" name="rdn_no_pop" value="">
		<input type="hidden" name="strRhq_ofc_cd" value="<%=strRhq_ofc_cd%>">
		<input type="hidden" name="strOfc_cd" value="<%=strOfc_cd%>">
		
		<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top: 2; padding-left: 5;">
			<tr>
				<td valign="top">
					<!--Page Title, Historical (S)-->
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
						<tr>
							<td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td>
						</tr>
						<tr>
							<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td>
						</tr>
					</table>
					<!--Page Title, Historical (E)-->
					
					<!--Button (S) -->
					<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 0; padding-bottom: 2;">
						<tr>
							<td class="btn1_bg">
								<table border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr>
													<td class="btn1_left"></td>
													<td class="btn1" name="btn_Retrieve" id="btn_retrieve">Retrieve</td>
													<td class="btn1_right"></td>
												</tr>
											</table></td>
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr>
													<td class="btn1_left"></td>
													<td class="btn1" name="btn_New">New</td>
													<td class="btn1_right"></td>
												</tr>
											</table></td>
										<td class="btn1_line"></td>
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr>
													<td class="btn1_left"></td>
													<td class="btn1" name="btn_Save">Save</td>
													<td class="btn1_right"></td>
												</tr>
											</table></td>
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr>
													<td class="btn1_left"></td>
													<td class="btn1" name="btn_DownExcel">Down Excel</td>
													<td class="btn1_right"></td>
												</tr>
											</table></td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
					<!--Button (E) -->
					
					<!--biz page (S)-->
					<table class="search" id="mainTable">
						<tr>
							<td class="bg">
								<!--  biz_1 (S) -->
								<table class="search" border="0" style="width: 979;">
									<tr class="h23">
										<td width="40">RHQ</td>
										<td width="110"><script language="javascript">
											ComComboObject('rct_rhq_cd', 1, 90, 0, 1, 0, false);
										</script></td>
										<td width="45">Office</td>
										<td width="125"><script language="javascript">
											ComComboObject('bkg_ofc_cd', 1, 80, 0, 0, 0, false);
										</script></td>
										<td>
											<table class="search_sm2" border="0" style="width: 350;">
												<tr class="h23">
													<td>Date</td>
													<td width="" class="stm"><input type="radio" class="trans" name="dt_type" value="BKG">BKG&nbsp;&nbsp;<input type="radio" class="trans" name="dt_type" value="APPL" checked>Appl.&nbsp;&nbsp;<input type="radio" name="dt_type" value="ETD" class="trans">ETD&nbsp;</td>
													<td width=""><nobr>
															<input type="text" style="width: 75; text-align: center;" class="input1" value="" caption="From Date" name="from_dt" dataformat="ymd" maxLength="10" minlength="8">&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="btns_calendar1" width="19" height="20" border="0" align="absmiddle">
															&nbsp;~&nbsp; <input type="text" style="width: 75; text-align: center;" class="input1" value="" caption="To Date" name="to_dt" dataformat="ymd" maxLength="10" minlength="8">&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="btns_calendar2" width="19" height="20" border="0" align="absmiddle">
														</nobr></td>
												</tr>
											</table>
										</td>
										<td width="60">&nbsp;Scope</td>
										<td width="85"><script language="javascript">
											ComComboObject('svc_scp_cd', 2, 60, 0, 0, 0, false);
										</script></td>
										<td width="45">T/VVD</td>
										<td width="130"><nobr>
												<input type="text" class="input" style="width: 90; text-align: center; ime-mode: disabled" name="t_vvd" dataformat=uppernum caption="T/VVD" maxlength="9" fullfill> <img class="cursor" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btn_com_ens_ob2">
											</nobr></td>
									</tr>
								</table>
								<table class="search" border="0" style="width: 979;">
									<tr class="h23">
										<td width="95"><nobr>Contract Type</nobr></td>
										<td width="65"><script language="javascript">
											ComComboObject('bkg_ctrt_tp_cd', 1, 50, 0, 0, 0, false);
										</script></td>
										<td width="93">Contract No.</td>
										<td width="115"><input input type="text" class="input" value="" style="width: 105; text-align: center; ime-mode: disabled" name="ctrt_no" dataformat=uppernum caption="Contract No" maxlength="12"></td>
										<td width="40" align="center"><nobr>POR</nobr></td>
										<td width="70"><input input type="text" class="input" value="" style="width: 60; text-align: center; ime-mode: disabled" name="por_cd" dataformat=engup caption="POR" maxlength="5"></td>
										<td width="40" align="center"><nobr>POL</nobr></td>
										<td width="70"><input input type="text" class="input" value="" style="width: 60; text-align: center; ime-mode: disabled" name="pol_cd" dataformat=engup caption="POL" maxlength="5"></td>
										<td width="40" align="center"><nobr>POD</nobr></td>
										<td width="70"><input input type="text" class="input" value="" style="width: 60; text-align: center; ime-mode: disabled" name="pod_cd" dataformat=engup caption="POD" maxlength="5"></td>
										<td width="40" align="center"><nobr>DEL</nobr></td>
										<td width="70"><input input type="text" class="input" value="" style="width: 60; text-align: center; ime-mode: disabled" name="del_cd" dataformat=engup caption="DEL" maxlength="5"></td>
										<td width="80" align="center">BDR Status</td>
										<td width="86"><script language="javascript">
											ComComboObject('bdr_flg', 1, 62, 0, 0, 0, false);
										</script></td>
										<td width="">&nbsp;</td>
									</tr>
								</table>
								<table class="search" border="0" style="width: 979;">
									<tr class="h23">
										<td width="95"><nobr>POR = POL</nobr></td>
										<td width="65"><script language="javascript">
											ComComboObject('por_pol_equals', 1, 50, 0, 0, 0, false);
										</script></td>
										<td width="95"><nobr>POD = DEL</nobr></td>
										<td width="65"><script language="javascript">
											ComComboObject('pod_del_equals', 1, 50, 0, 0, 0, false);
										</script></td>
										<td width="95"><nobr>Multi CNTR</nobr></td>
										<td width="65"><script language="javascript">
											ComComboObject('multi_cntr', 1, 50, 0, 0, 0, false);
										</script></td>
										<td width="95"><nobr>SM Prime</nobr></td>
										<td width="65"><script language="javascript">
											ComComboObject('sm_prime', 1, 50, 0, 0, 0, false);
										</script></td>
										<td width="95"><nobr>Audit Amount</nobr></td>
										<td width="65"><script language="javascript">
											ComComboObject('usr_ins_amt', 1, 50, 0, 0, 0, false);
										</script></td>
										<td width="">&nbsp;</td>
									</tr>
								</table>
								<table class="search" border="0" style="width: 979;">
									<tr class="h23">
										<td width="95"><nobr>Single/Multi</nobr></td>
										<td width="65"><script language="javascript">
											ComComboObject('sgl_mlt_cd', 1, 50, 0, 0, 0, false);
										</script></td>
										<td width="95"><nobr>OFT CNT</nobr></td>
										<td width="65"><script language="javascript">
											ComComboObject('oft_cnt', 1, 50, 0, 0, 0, false);
										</script></td>
										<td width="95"><nobr>CNTR TP CNT</nobr></td>
										<td width="65"><script language="javascript">
											ComComboObject('tpsz_cnt', 1, 50, 0, 0, 0, false);
										</script></td>
										<td width="95"><nobr>BKG - 1st</nobr></td>
										<td width="65"><script language="javascript">
											ComComboObject('pls_zr_mnus_cd_1', 1, 50, 0, 0, 0, false);
										</script></td>
										<td width="95"><nobr>BKG - 2nd</nobr></td>
										<td width="65"><script language="javascript">
											ComComboObject('pls_zr_mnus_cd_2', 1, 50, 0, 0, 0, false);
										</script></td>
										<td width="95"><nobr>BKG-Commodity</nobr></td>
										<td width="65"><script language="javascript">
											ComComboObject('pls_zr_mnus_cd_3', 1, 50, 0, 0, 0, false);
										</script></td>
										<td width="95"><nobr>Confirm</nobr></td>
										<td width="65"><script language="javascript">
											ComComboObject('usr_upd_cfm_flg', 1, 50, 0, 0, 0, false);
										</script></td>
										<td width="">&nbsp;</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
					<!--  biz_1   (E) -->
				</td>
			</tr>
		</table>
		<table class="height_8">
			<tr>
				<td></td>
			</tr>
		</table>
		<table class="search" id="mainTable">
			<tr>
				<td class="bg">
					<table width="100%">
						<tr>
							<td class="btn2_bg" align="right">
								<table border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td><table width="100%" border="0" cellpadding="0"
												cellspacing="0" class="search">
												<tr class="h23">
													<td><nobr>B/L Count&nbsp;</nobr></td>
												</tr>
											</table></td>
										<td><input type="text" style="width: 60; text-align: right" class="input" value="" name="bl_cnt" readonly></td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
					<!-- Grid  (S) -->
					<table width="100%" id="mainTable">
						<tr>
							<td width="100%"><script language="javascript">
								ComSheetObject('sheet1');
							</script>
							</td>
						</tr>
					</table>
					<!-- Grid (E) -->
					
					<table width="100%">
						<tr>
							<td class="btn2_bg" align="right"></td>
						</tr>
					</table>
					
					<!--Button (S) -->
					<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5; padding-bottom:10;">
						<tr>
							<td class="btn1_bg">
								<table border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td width="260">
											<input input type="text" class="input" value="" style="width: 250; ime-mode: inactive" name="remarks_update" caption="Remarks Update">
										</td>
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr>
													<td class="btn1_left"></td>
													<td class="btn1" name="btn_Remarks_Update">Remarks Update</td>
													<td class="btn1_right"></td>
												</tr>
											</table></td>
										<td class="btn1_line"></td>
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr>
													<td class="btn1_left"></td>
													<td class="btn1" name="btn_Confirm">Confirm</td>
													<td class="btn1_right"></td>
												</tr>
											</table></td>
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr>
													<td class="btn1_left"></td>
													<td class="btn1" name="btn_Release">Release</td>
													<td class="btn1_right"></td>
												</tr>
											</table></td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
					<!--Button (E) -->
				</td>
			</tr>
		</table>
		<!--biz page (E)-->

	<!-- 개발자 작업  끝 -->
	</form>
</body>
</html>