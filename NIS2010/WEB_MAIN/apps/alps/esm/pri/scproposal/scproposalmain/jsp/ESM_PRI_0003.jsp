<%
/*===============================================================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_PRI_0003.jsp
 *@FileTitle : Proposal & Amendment Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.08
 *@LastModifier : 변영주
 *@LastVersion : 1.0
 * 2009.05.08 변영주
 * 1.0 Creation 
 ===============================================================================================
 * History
 * 2011.04.21 서미진 [CHM-201110239-01] S/C Main 화면에서 "OTI No." 에서 "OTI Org No." 로 이름변경
 * 2011.10.05 서미진 [CHM-201113544] S/C 화면에서 복수의 Real customer 입력 가능토록 시스템 보완
 * 2012.02.13 서미진 [CHM-201216154] E-mail 버튼을 click 할 경우 자동으로 메일 창이 연결이 되어서 담당 sales rep 한테 메일 보낼 수 있는 환경 조성
 * 2012.04.18 이석준 [CHM-201217045-01] S/C Filed Cancel 기능및 조회 기능 추가
 * 2014.01.02 전윤주 [CHM-201328327] OTI Org No. 링크 변경 요청 
 * 2014.09.17 송호진 [CHM-201430558] FMC Auto-filing 개발 요청
 * 2014.11.20 송호진 [CHM-201432557] S/C scope duration 로직 수정 - 신규 Svc Scp 의 경우 Delete Button Enable
===============================================================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.event.EsmPri0003Event"%>
<%@ page import="com.hanjin.syscommon.common.table.PriSpMnVO"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="java.util.List"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>

<%
	EsmPri0003Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";
	String condPropNo = null;
	String strUsr_id = "";
	String strUsr_nm = "";
	String strUsr_ofc = "";
	String strUsrSrepCd = "";
	String strUsr_emal = "";
	String propNo = null;
	String searchFlg = null;
	Logger log = Logger.getLogger("com.hanjin.apps.SCProposal.SCProposalMain");
	String[] appCd = null;
	String[] appAllCd = null;
	String[] scopeCd = null;
	String[] custTpCd = null;	
	String[] lodUtCd = null;
	String[] scpStsCd = null;

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();
		strUsrSrepCd = account.getSrep_cd();
		strUsr_emal = account.getUsr_eml();
		event = (EsmPri0003Event) request.getAttribute("Event");

		PriSpMnVO vo = event.getPriSpMnVO();

		if (vo != null) {
			propNo = vo.getPropNo();
		} else {
			propNo = "";
		}
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		condPropNo = JSPUtil.getNull(request.getParameter("cond_prop_no"));
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..		
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");		

        appCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("appList"), true);
        appAllCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("appAllList"), true);
        scopeCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("scopeList"), true);
        custTpCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("custTypeList"), true ,"|","\t","getCode","getName");		
        lodUtCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("lodUtList"), false ,"|","\t","getCode","getName");	
        scpStsCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("scpStsList"), false ,"|","\t","getCode","getName");	
	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Proposal & Amendment Creation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
    var appCdValue = "<%=appCd[0]%>";
    var appCdText = "<%=appCd[1]%>";
    var appAllCdValue = "<%=appAllCd[0]%>";
    var appAllCdText = "<%=appAllCd[1]%>";
    var scopeCdValue = " |<%=scopeCd[0]%>";
    var scopeCdText = " |<%=scopeCd[1]%>";
    var custTpCdValue = "<%=custTpCd[0]%>";
    var custTpCdText = "<%=custTpCd[1]%>";
    var lodUtCdValue = "<%=lodUtCd[0]%>";
    var lodUtCdText = "<%=lodUtCd[1]%>";    
    var scpStsCdValue = "|<%=scpStsCd[0]%>";
    var scpStsCdText = "|<%=scpStsCd[1]%>";       
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows"> 
<input type="hidden" name="in_usr_ofc_cd" value="<%=strUsr_ofc%>"> 
<input type="hidden" name="in_usr_srep_cd" value="<%=strUsrSrepCd%>">
<input type="hidden" name="in_usr_nm" value="<%=strUsr_nm%>"> 
<input type="hidden" name="in_usr_id" value="<%=strUsr_id%>">
<input type="hidden" name="oti_eff_dt"> 
<input type="hidden" name="oti_exp_dt"> 
<input type="hidden" name="oti_amt">
<input type="hidden" name="oti_lic_no">
<input type="hidden" name="mst_prop_no" value="<%=propNo%>"> 
<input type="hidden" name="send_usr_nm" value="<%=strUsr_nm%>"> 
<input type="hidden" name="gw_subject"> 
<input type="hidden" name="gw_contents"> 
<input type="hidden" name="gw_template">
<input type="hidden" name="gw_args"> 
<input type="hidden" name="cond_prop_no" value="<%=condPropNo%>"> 
<input type="hidden" name="backendjob_key"> 
<input type="hidden" name="job_status"> 

<input type="hidden" name="ori_sc_no" >
<input type="hidden" name="ori_prop_no" >

<input type="hidden" name="sale_lead_ori" >

<input type="hidden" name="com_from" value="<%=strUsr_emal%>">
<input type="hidden" name="com_fromName" value="<%=strUsr_nm%>">
<input type="hidden" name="com_recipient" value="">
<input type="hidden" name="com_carbonCopy" value="">
<input type="hidden" name="com_blindCarbonCopy" value="">
<input type="hidden" name="com_subject" value="">
<input type="hidden" name="com_fileKey" value="">
<input type="hidden" name="com_content" value="">		
<input type="hidden" name="com_smtp" value="203.246.130.40">
<input type="hidden" name="com_groupwareMail" value="true">

<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	style="padding-top: 2; padding-left: 5;">
	<tr>
		<td valign="top"><!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr>
				<td class="history"><img src="img/icon_history_dot.gif"	align="absmiddle"><span id="navigation"></span></td>
			</tr>
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif"	align="absmiddle"><span id="title"></span></td>
			</tr>
		</table>

		<!--Page Title, Historical (E)--> <!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0"
			cellspacing="0" style="padding-top: 0; , padding-bottom: 2;">
			<tr>
				<td class="btn1_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
					
							<span id="span_cancel_filing" style="display:none">
 
 
							<table width="100%" border="0" cellpadding="0" cellspacing="0"	class="button">
								<tr>
									<td class="btn1_left"></td>
									<td class="btn1" name="btn_cancel_file" id="btn_cancel_file">Cancel Filing</td>
									<td class="btn1_right"></td>
								</tr>
							</table>
 
 
							</span>
					
						</td>
						
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"	class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"	class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_new">New</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td class="btn1_line"></td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"	class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_amend">Amend</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"	class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_save">Save</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>

						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"	class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_request">Request</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"	class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_coffer">C/offer</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"	class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_approve">Approve</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"	class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_scnoassign">S/C No. Assign</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"	class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_file">File</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"	class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_cancel" id="btn_cancel_txt">Cancel</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"	class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_copy">Copy</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>

						<td class="btn1_line"></td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"	class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_print">Print</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>

					</tr>
				</table>
				</td>
			</tr>
		</table>
		<!--Button (E) --> <!--biz page (S)--> <!-- Hidden sheet for Transaction (S) -->
		<script language="javascript">ComSheetObject('sheet1');</script> <!-- Hidden sheet for Transaction (E) -->
		<table class="search">
			<tr>
				<td class="bg"><!--  biz_1  (S) -->
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="48">S/C No.</td>
						<td width="90"><input type="text" style="width: 80; text-align: center;" name="sc_no" maxlength="20" class="input" dataformat="engup"></td>
						<td width="55">AMD No.</td>
						<td width="30"><input type="text" style="width: 22; text-align: center;" name="amdt_seq" readonly class="input2"></td>
						<td width="78">Proposal No.</td>
						<td width="79"><input type="text" style="width: 77; text-align: center;" name="prop_no" maxlength="10" class="input" dataformat="engup">&nbsp;</td>

						<td width="95">
						<table width="" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn2_left"></td>
								<td class="btn2"><img class="cursor" src="img/tab_icon1.gif" width="16" height="16" border="0" align="absmiddle" name="img_dur"></td>
								<td class="btn2" name="btn_dur_pop" id="btn_dur">Duration</td>
								<td class="btn2_right"></td>
							</tr>
						</table>
						</td>
						<td width="76">
						<input type="text" caption="Effective date" name="ctrt_eff_dt" cofield="ctrt_exp_dt" maxlength="10" dataformat="ymd" style="width: 72; text-align: center;" readonly class="input1" required></td>
						<td width="20">
						<table>
							<tr>
								<td><img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btns_calendar1" class="cursor"></td>
							</tr>
						</table>
						</td>
						<td width="92">&nbsp;~&nbsp;<input type="text" caption="Expiration date" name="ctrt_exp_dt" cofield="ctrt_eff_dt" maxlength="10" dataformat="ymd" style="width: 72; text-align: center;" readonly class="input1" required></td>
						<td width="22">
						<table>
							<tr>
								<td><img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btns_calendar2" class="cursor"></td>
							</tr>
						</table>
						</td>
						<td width="65"><input type="checkbox" name="rf_flg" value="" class="trans">Reefer</td>
						<td width="85"><input type="checkbox" name="gamt_flg" value="" class="trans">Garment</td>
						<td width="35">Status</td>
						<td width="67"><input type="text" style="width: 63;" name="prop_sts" readonly class="input2"></td>
						<td width="8">
						<table border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_bg">
								<table border="0" cellpadding="0" cellspacing="0" class="button">
									<tr>
										<td class="btn1_line"></td>
									</tr>
								</table>
								</td>
							</tr>
						</table>
						</td>
						<td width="" align="right"><img src="img/btns_inquiry.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btn_hidden" class="cursor"></td>
					</tr>
				</table>
				<!--  biz_1   (E) -->

				<table class="line_bluedot" style="width: 979;">
					<tr>
						<td colspan="8"></td>
					</tr>
				</table>

				<!-----div---->
				<div id="subterms"><!--  biz_2  (S) -->
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="58">Req. OFC</td>
						<td width="79"><input type="text" style="width: 72;" name="prop_ofc_cd" dataformat="engup" readonly class="input1" caption="Request Office Code" required></td>
						<td width="43">S.Rep.</td>
						<td width="169"><script language="javascript">ComComboObject('prop_srep_cd', 3, 61, 0, 1);</script><input type="text" style="width: 83;" name="prop_srep_nm" readonly class="input2">
						<img src="img/btng_mail.gif" width="18" height="20" alt="" border="0" name="btn_srep_mail" class="cursor" align="absmiddle"></td>
						<td width="63">APVL OFC</td>
						<td width="73"><script language="javascript">ComComboObject('prop_apro_ofc_cd', 2, 67, 0, 1);</script></td>
						<td width="60">APVL STF</td>
						<td width="145"><input type="text" style="width: 137;" name="prop_apro_staff" readonly class="input2"></td>
						<td width="75">Creation DT</td>
						<td width="80"><input type="text" maxlength="10" dataformat="ymd" style="width: 76;" name="cre_dt" readonly class="input2"></td>
						<td width="45">Eff. DT</td>
                        <td width="20">
                        <table>
                            <tr>
                                <td><img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btn_eff_dt" class="cursor"></td>
                            </tr>
                        </table>
                        </td>						
						<td><input type="text" maxlength="10" dataformat="ymd" style="width: 75;" name="file_dt" readonly class="input2"></td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="102">
						<table width="" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn2_left"></td>
								<td class="btn2"><img class="cursor" src="img/tab_icon1.gif" width="16" height="16" border="0" align="absmiddle" name="img_ctrt"></td>
								<td class="btn2" name="btn_ctrt_pty_pop" id="btn_ctrt_pty">Customer</td>
								<td class="btn2_right"></td>
							</tr>
						</table>
						</td>
						<td width="90">
							<input type="text" style="width: 25;" dataformat="engup" maxlength="2" minlength="2" name="cust_cnt_cd" readonly class="input1" caption="Customer Code" required>&nbsp;<input type="text" style="width: 55;" dataformat="int" name="cust_seq" maxlength="6" readonly class="input1" caption="Customer Code" required>&nbsp;</td>
						<td width="20">
						<table>
							<tr>
								<td><img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btn_ctrt_cust" class="cursor"></td>
							</tr>
						</table>
						</td>
						<td width="223"><input type="text" style="width: 220;" name="ctrt_pty_nm" readonly class="input2"></td>								
						<td width="12">
							<img src="img/tab_icon1.gif" width="16" height="16" border="0" align="absmiddle" name="img_ctrt_tpy">
						</td>													
						<td width="20">
						<table>
							<tr>
								<td>&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btn_ctrt_cust_tp_pop" class="cursor">&nbsp;</td>
							</tr>
						</table>
						</td>
						<td width="40"><script language="javascript">ComComboObject('prc_ctrt_cust_tp_cd', 2, 37, 0, 1);</script></td>
						<td width="98"><input type="text" style="width: 47;" name="ctrt_cust_val_sgm" readonly class="input2"> 
						<input type="text" style="width: 43;" name="ctrt_cust_sls_ofc_cd" readonly class="input2" caption="Customer Code"></td>
						<td width="67" style="padding-left: 2;"><script language="javascript">ComComboObject('ctrt_cust_srep_cd', 3, 65, 0, 1);</script></td>
						<td width="137"><input type="text" style="width: 129;" name="ctrt_cust_srep_nm" readonly class="input2"></td>
						<td width="80">OTI Org No.</td>
						<td id="oti_no_desc" >
							<input type="text" style="width: 52;" dataformat="" name="oti_no" readonly class="input2"  style="cursor:hand;" >&nbsp;<a href="https://www2.fmc.gov/oti/NVOCC.aspx" target="_blank"><img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></a></td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="102">Real Customer</td>
						<td width="90"><input type="text" style="width: 25;" name="real_cust_cnt_cd" maxlength="2" minlength="2" dataformat="engup" readonly class="input2">&nbsp;<input type="text" style="width: 55;" name="real_cust_seq" dataformat="int" maxlength="6" readonly class="input2">&nbsp;</td>
						<td width="20">
						<table>
							<tr>
								<td><img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btn_real_cust" class="cursor"></td>
							</tr>
						</table>
						</td>
						<td width="266">
							<input type="text" style="width: 260;" name="real_cust_nm" readonly class="input2"></td>
						<td width="40">
							<script language="javascript">ComComboObject('real_cust_tp_cd', 2, 37, 0);</script></td>
						<td width="98">
							<input type="text" style="width: 47;" name="real_cust_val_sgm" readonly class="input2"> 
							<input type="text" style="width: 43;" name="real_cust_sls_ofc_cd" readonly class="input2"></td>
						<td width="67" style="padding-left: 2;">
							<script language="javascript">ComComboObject('real_cust_srep_cd', 3, 65, 0);</script></td>
						<td width="137" >
							<input type="text" style="width: 129;" name="real_cust_srep_nm" readonly class="input2"></td>
						<td width="85"  ><span id="ct_available_time_td1" style="display:none;">C/T Available</span>&nbsp;</td>
						<td width="">&nbsp;<input  id="ct_available_time_td2"  style="display:none;" type="text" style="width: 65;"  name="ct_available_time" value="48H 50M" readonly class="input2"></td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="100">
						<table width="99" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn2_left"></td>
								<td class="btn2">
									<img class="cursor" src="img/tab_icon1.gif" width="16" height="16" border="0" align="absmiddle" name="img_mqc"></td>
								<td class="btn2" name="btn_prop_mqc_pop" id="btn_mqc">MQC</td>
								<td class="btn2_right"></td>
							</tr>
						</table>
						</td>
						<td width="112">
							<input type="text" style="width: 50; text-align: right;" name="prop_mqc_qty" readonly class="input1" caption="MQC" required dataformat="int">&nbsp;
							<script language="javascript">ComComboObject('cntr_lod_ut_cd', 1, 53, 0,1);</script></td>

						<td width="30">MVC</td>
						<td width="71">
							<input type="text" style="width: 30;text-align:right;" name="prop_mvc" readonly class="input2">&nbsp;
							<input type="text" style="width: 30;" name="prop_mvc_tp" readonly class="input2"></td>
						<td width="35">PFMC</td>
						<td width="100">
							<input type="text" style="width: 40; text-align: right;" name="prop_pfmc" readonly class="input2"> <input type="text" style="width: 26;" name="prop_pfmc_tp" readonly class="input2" value="FEU">
							<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" name="btn_prop_pfmc_pop" class="cursor" align="absmiddle"></td>

						<td width="70">Attainment</td>
						<td width="92">
							<input type="text" style="width: 40; text-align: right;" name="prop_atmt" readonly class="input2"> 
							<input type="text" style="width: 26;"	name="prop_atmt_tp" readonly class="input2" value="%"></td>
						<td width="67">Sales Lead</td>
						<td width="85"><script language="javascript">ComComboObject('sls_ld_no', 2, 80, 0, 0);</script></td>
						<td class="btn2_bg" width="180">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr><td>
								<table width="120" border="0" cellpadding="0" cellspacing="0"
									class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2"><img class="cursor" src="img/tab_icon1.gif" width="16" height="16" border="0" align="absmiddle" name="img_blpl"></td>
										<td class="btn2" name="btn_blpl_pop" id="btn_blpl">Boiler Plate</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>
								<td><table width="85" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
										<td class="btn2"><img class="cursor" src="img/tab_icon1.gif" width="16" height="16" border="0" align="absmiddle" name="img_affil"></td>
										<td class="btn2" name="btn_afil_pop" id="btn_afil">Affiliate</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td></tr>
						</table>
						</td>
					</tr>
				</table>

				<table class="search_sm2" border="0" style="width: 977;">
					<tr class="h23">
						<td width="35">PRS</td>
						<td width="58" class="stm">Actual CM</td>
						<td width="160">
							<input type="text" style="width: 110; text-align: right;" class="input2" readonly dataformat="int" name="prs_crnt_cm_amt">&nbsp;<input type="text" style="width: 30;" class="input2" value=" USD" readonly></td>
						<td width="50" class="stm">Est. CM</td>
						<td width="160">
							<input type="text" style="width: 110; text-align: right;" class="input2" readonly dataformat="int" name="prs_estm_cm_amt">&nbsp;<input type="text" style="width: 30;" class="input2" value=" USD" readonly></td>
						<td width="55" class="stm">CM (SUM)</td>
						<td width="160">
							<input type="text"	style="width: 110; text-align: right;" class="input2" readonly dataformat="int" name="prs_sum_cm_amt">&nbsp;<input type="text" style="width: 30;" class="input2" value=" USD" readonly></td>
						<td  width="110" class="stm">MQC Est.(PRS)&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btn_mqc_estimate" id="btn_mqc_estimate" class="cursor"></td>
						<td  width="40">	<img  src="img/tab_icon1.gif" width="16" height="16" border="0" align="absmiddle" name="img_lgcy">&nbsp;NIS</td>							
						<td >
						<input type="checkbox" name="conv_cfm_flg" value="" class="trans">Conversion update</td>
					</tr>
				</table>



				<!-- Grid  (S) -->
				<table width="100%" id="mainTable">
					<tr>
						<td width="100%"><script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) -->
				<table width="100%" class="button">
					<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
										<td class="btn2" name="btn_rowadd">Row&nbsp;Add</td>
										<td class="btn2_right"></td></tr></table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
										<td class="btn2" name="btn_delete" id="btn_delete">Delete</td>
										<td class="btn2_right"></td></tr></table></td></tr>
						</table></td></tr></table>
				<!--  biz_2   (E) -->
				</td>
			</tr>
		</table>
		<!--biz page (E)-->

		</div>
		<!-----div end---->

		<table class="height_8">
			<tr>
				<td></td>
			</tr>
		</table>

		<!-- Tab ) (S) -->
		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%>
			<tr><td width="100%"><script language="javascript">ComTabObject('tab1')</script>
				<!-- img src="/img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
				</td>
			</tr>
		</table>
		<!-- Tab ) (E) --> <!-- iFrame (S) -->
		<div id="tabLayer" style="display: none">
		<iframe name="t1frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="380" src="about:blank"></iframe></div>
		<div id="tabLayer" style="display: none">
		<iframe name="t2frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="380" src="about:blank"></iframe></div>
		<div id="tabLayer" style="display: none">
		<iframe name="t3frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="380" src="about:blank"></iframe></div>
		<div id="tabLayer" style="display: none">
		<iframe name="t4frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="380" src="about:blank"></iframe></div>
		<div id="tabLayer" style="display: none">
		<iframe name="t5frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="800" src="about:blank"></iframe></div>
		<div id="tabLayer" style="display: none">
		<iframe name="t6frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="380" src="about:blank"></iframe></div>
		<div id="tabLayer" style="display: none">
		<iframe name="t7frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="380" src="about:blank"></iframe></div>
		<div id="tabLayer" style="display: none">
		<iframe name="t8frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="380" src="about:blank"></iframe></div>
		<div id="tabLayer" style="display: none">
		<iframe name="t9frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="380" src="about:blank"></iframe></div>
		<div id="tabLayer" style="display: none">
		<iframe name="t10frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="380" src="about:blank"></iframe></div>
		<!-- iFrame (E) -->

		<table class="height_10">
			<tr>
				<td colspan="8"></td>
			</tr>
		</table>

		</td>
	</tr>
</table>
<!-- 개발자 작업  끝 --></form>
</body>
</html>