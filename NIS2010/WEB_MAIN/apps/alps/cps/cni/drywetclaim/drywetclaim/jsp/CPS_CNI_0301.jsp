<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CPS_CNI_0301.jsp
*@FileTitle : DW Claim Main
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.10.12 윤세영
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.event.CpsCni0301Event"%>
<%@ page import="com.hanjin.apps.alps.cps.cni.common.CniUtil"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	CpsCni0301Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.DryWetClaim.DryWetClaim");
	String strTodate        = DateTime.getDateString().substring(0,4)+"-"+DateTime.getDateString().substring(5,7)+"-"+DateTime.getDateString().substring(8,10);
	String dwClmNo          = JSPUtil.getNull(request.getParameter("dw_clm_no"));
	String popup			= JSPUtil.getNull(request.getParameter("popup"));
	
	SignOnUserAccount account = null;

	try {
	   	account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		if (dwClmNo.equals("")) {
			dwClmNo   = CniUtil.getDwClaimNo(account);
		}

		event = (CpsCni0301Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		//GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
    // 사용자 roles
    String roles = CniUtil.getRoles(account);
    String area =  CniUtil.getAreaInfo(account);
    String ofcCd = account.getOfc_cd(); 
    
    //roles = "CNI39";
    //strUsr_id = "2001702";	
%>
<html>
<head>
<title>DW Claim Main</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>

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
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="usr_id"				value="<%=strUsr_id%>" >
<input type="hidden" name="usr_ofc_cd"			value="<%=strOfc_cd%>" >
<input type="hidden" name="usr_nm"				value="<%=strUsr_nm%>" >
<input type="hidden" name="dw_clm_tp_cd" required caption="TOC">
<input type="hidden" name="inci_plc_tp_cd">
<input type="hidden" name="dw_co_cd" required caption="Company">
<input type="hidden" name="dw_clm_att_def_tp_cd">
<input type="hidden" name="clmt_agn_tp_cd">
<input type="hidden" name="deft_agn_tp_cd">
<input type="hidden" name="todate"				value="<%=strTodate%>" >
<input type="hidden" name="dw_clm_sts_cd_org">
<input type="hidden" name="pop_desc">

<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdArguments">
<input type="hidden" name="com_mrdTitle" value="Case Report">
<input type="hidden" name="com_mrdBodyTitle" value="Case Report">
<input type="hidden" name="com_mrdDisableToolbar">

<input type="hidden" name="usr_roles" value="<%=roles%>">
<input type="hidden" name="usr_area" value="<%=area%>">
<input type="hidden" name="usr_office" value="<%=ofcCd%>">

<input type="hidden" name="trns_seq" value=""/>

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	
		<!--Page Title, Historical (S)-->
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
<%if (popup.equals("yes")) { %>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">DW Claim Main</td></tr>
<% } else { %>
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
<% } %>
        </table>
		<!--Page Title, Historical (E)-->
	
	
		<!--Button (S) -->
		
    	<!--Button (E) -->
		
		<!--biz page (S)-->
		
<table class="search" id="mainTable"> 
    <tr><td class="bg">	
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="55">Case No.</td>
				<td width="98"><input type="text" name="dw_clm_no" style="width:90;" maxlength="11" dataformat="eng" fullfill caption="Case No." style="ime-mode:disabled" value="<%=dwClmNo%>"></td>
				<td width="28"><a title="Type of Case">TOC</a></td>
				<td width="78"><script language="javascript">ComComboObject("combo_dw_clm_tp_cd", 2, 70, 1, 1, 0, true);</script></td>
				<td width="66">Company</td>
				<td width="78"><script language="javascript">ComComboObject("combo_dw_co_cd", 2, 70, 1, 1, 0, true);</script></td>
				<td width="58">R. Office</td>
				<td width="68"><input type="text" name="cre_ofc_cd" readonly style="width:60;" value="<%=strOfc_cd%>" class="input2"></td>
				<td width="69">R. Handler</td>
				<td width="128"><input type="text" name="r_handler" readonly style="width:120;" value="<%=strUsr_nm%>" class="input2"></td>
				<td width="38">HOFC</td>
				<td width="70"><input type="text" name="hdlr_ofc_cd" readonly style="width:60;" value="<%=strOfc_cd%>" class="input2"></td>
				<td width="45" align="right">Handler</td>
				<td width="100" align="right"><input type="text" name="hdlr_usr_id" style="width:75;" value="<%=strUsr_id%>" class="input2" readonly="readonly">&nbsp;<img src="img/btns_search.gif" name="btns_hanlder_history" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				</tr>
			</table> 
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="55">Vessel</td>
				<td width=""><input type="text" name="dw_clm_ref_vvd_no" style="width:90;text-align:center;" class="input" value="" maxlength="10" dataformat="eng" caption="VVD" style="ime-mode:disabled">&nbsp;<img src="img/btns_search.gif" name="pop_dw_clm_ref_vvd_no" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
				<input type="text" name="vsl_eng_nm" style="width:148;" class="input" value="" maxlength="50" caption="VVD Name" style="ime-mode:disabled"></td>
				<td width="30"><a title="Place of Incident">POI</a></td>
				<td width="113"><script language="javascript">ComComboObject("combo_inci_plc_tp_cd", 2, 98, 1, 0, 0, true);</script></td>
				<td width="30"><a title="Date of Incident">DOI</a></td>
				<td width="111"><input type="text" name="inci_occr_dt" style="width:75;text-align:center;ime-mode:disabled;" maxlength="8" dataformat="ymd" fullfill value="" caption="DOI">&nbsp;<img src="img/btns_calendar.gif" name="cal_inci_occr_dt" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				<td width="64"><a title="Date of Time Bar">DOTB</a></td>
				<td width="106"><input type="text" name="tm_bar_dt" style="width:75;ime-mode:disabled;text-align:center" maxlength="8" dataformat="ymd" fullfill caption="T/B Date" value="">&nbsp;<img src="img/btns_calendar.gif" name="cal_tm_bar_dt" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				<td width="75">&nbsp;&nbsp;&nbsp;Litigated</td>
				<td width="105" align="right"><input type="text" name="lit_dt" style="width:75;ime-mode:disabled;text-align:center" maxlength="8" dataformat="ymd" fullfill caption="Litigated" value="">&nbsp;<img src="img/btns_calendar.gif" name="cal_lit_dt" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				</tr>
				</table> 
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="55">Status </td><div style="display:none"><select name="dw_clm_sts_cd" style="width:175;" ><option value="" selected></option></select></div>
				<td width=""><input type="text" name="dw_clm_sts_nm" readonly class="input2" style="width:113;" ></td>
				<td width="35"><a title="Type of Handling">TOH</a></td>
				<td width="90"><script language="javascript">ComComboObject("combo_dw_clm_att_def_tp_cd", 2, 75, 1, 0, 0, true);</script></td>
				<td width="30"><a title="Date of Notice of Preliminary Claim">DON</a></td>
				<td width="115"><input type="text" name="prlm_clm_ntfy_dt" caption="DON" style="width:75;ime-mode:disabled;text-align:center" maxlength="8" dataformat="ymd" fullfill caption="DON" value="">&nbsp;<img src="img/btns_calendar.gif" name="cal_prlm_clm_ntfy_dt" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				<td width="30"><a title="Date of Case Closed">DOC</a></td>
				<td width="90"><input type="text" name="cs_clz_dt" caption="DOC" readonly style="width:75;ime-mode:disabled;text-align:center" maxlength="8" dataformat="ymd" fullfill value="" class="input2"></td>
				<td width="30" title="Date of Update">DOU</td>
				<td width="90"><input type="text" name="upd_dt" style="width:75;ime-mode:disabled;text-align:center" value="" readonly class="input2">&nbsp;</td>
				<td width="110">Transfer&nbsp;<input type="checkbox"
							name="trns_flg" value="Y" class="trans" ><input
							type="text" name="clm_trns_auth_cd" readonly="readonly"
							style="width:30;" value="" class="input2"></td>
				<td width="70">Arbitrated</td>
				<td width="105" align="right"><input type="text" name="arbt_dt" caption="Arbitrated" style="width:75;ime-mode:disabled;text-align:center" maxlength="8" dataformat="ymd" fullfill value="">&nbsp;<img src="img/btns_calendar.gif" name="cal_arbt_dt" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
			</tr>
			</table> 
			
			<table class="line_bluedot"><tr><td></td></tr></table>
			
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="91"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_clmt_clm_pty_nm" style="color:#cc3300">Claimant</td>
						<td class="btn2_right"></td>
						</tr>
						</table>
				</td>
				<td width="290"><input type="hidden" name="clmt_clm_pty_no"><div style="display:none"><textarea name="clmt_ctnt"></textarea></div>
				<input type="text" name="clmt_clm_pty_nm" readonly style="width:250;" value="">&nbsp;<img src="img/btns_search.gif" name="pop_clmt_clm_pty_nm" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>	
				<td width="110" align="right">Insurer&nbsp;</td>
				<td width=""><input type="hidden" name="insur_clm_pty_no">
				<input type="text" name="insur_clm_pty_nm" readonly style="width:222;" value="">&nbsp;<img src="img/btns_search.gif" name="pop_insur_clm_pty_nm" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				<td width="75" align="right">Deductible&nbsp;</td>
				<td width="120" class="stm"><input type="text" name="ddct_usd_amt" caption="Deductible" dataformat="float" maxlength="18" style="width:97%;text-align:right" value="">&nbsp;</td><td width="21" class="stm">USD</td>
				</tr>
			</table> 
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="91"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_deft_clm_pty_nm" style="color:#cc3300">Defendant</td>
						<td class="btn2_right"></td>
						</tr>
						</table>
				</td>
				<td width="290"><input type="hidden" name="deft_clm_pty_no"><div style="display:none"><textarea name="deft_ctnt"></textarea></div>
				<input type="text" name="deft_clm_pty_nm" readonly style="width:250;" value="">&nbsp;<img src="img/btns_search.gif" name="pop_deft_clm_pty_nm" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>	
				<td width="110"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_labl_pty_clm_pty_nm" style="color:#cc3300">Liable Party</td>
						<td class="btn2_right"></td>
						</tr>
						</table>
				</td>
				<td width=""><input type="hidden" name="labl_pty_clm_pty_no">
				<input type="text" name="labl_pty_clm_pty_nm" readonly style="width:222;" value="">&nbsp;<img src="img/btns_search.gif" name="pop_labl_pty_clm_pty_nm" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>	
				<div style="display:none"><textarea name="labl_pty_ctnt"></textarea></div>
				<td width="75"><a title="LP Date of Time Bar">LP DOTB</a></td>
				<td width="105" align="right"><input type="text" name="labl_pty_tm_bar_dt" style="width:75;ime-mode:disabled;text-align:center" maxlength="8" dataformat="ymd" fullfill value="">&nbsp;<img src="img/btns_calendar.gif" name="cal_labl_pty_tm_bar_dt" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				</tr>
			</table> 
			
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="150">Claim Amount</td>
				<td width="210"><input type="text" name="clm_locl_amt" caption="Claim Amount" dataformat="float" maxlength="18" style="width:140;text-align:right" value="">&nbsp;<input type="text" name="clm_locl_curr_cd" caption="Claim Amount Currency" maxlength="3" dataformat="engup" fullfill style="width:33;text-align:center;ime-mode:disabled" value="">&nbsp;<img src="img/btns_search.gif" name="pop_clm_locl_curr_cd" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				<td width="140">Date of Formal Claim</td>
				<td width="138"><input type="text" name="fmal_clm_rcv_dt" caption="Date of Formal Claim" style="width:80;ime-mode:disabled;text-align:center" maxlength="8" dataformat="ymd" fullfill value="">&nbsp;<img src="img/btns_calendar.gif" name="cal_fmal_clm_rcv_dt" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				<td width="40" title="Rate of Exchange">R.O.E</td>
				<td width="117"><input type="text" name="clm_xch_rt" style="width:85;text-align:right" dataformat="float" value="">&nbsp;<img src="img/btns_search.gif" name="pop_clm_xch_rt" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				<td width="" class="stm"><input type="text" name="clm_usd_amt" dataformat="float" maxlength="18" style="width:160;text-align:right" value="">&nbsp;</td><td width="21" class="stm">USD</td>
				</tr>
				<tr class="h23">
				<td width="">Settled Amount</td>
				<td width=""><input type="text" name="clm_stl_locl_amt" caption="Settled Amount" dataformat="float" maxlength="18" style="width:140;text-align:right" value="">&nbsp;<input type="text" name="clm_stl_locl_curr_cd" caption="Settled Amount Currency" maxlength="3" dataformat="engup" fullfill style="width:33;text-align:center;ime-mode:disabled" value="">&nbsp;<img src="img/btns_search.gif" name="pop_clm_stl_locl_curr_cd" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				<td width="">Date of Settlement</td>
				<td width=""><input type="text" name="clm_stl_dt" caption="Date of Settlement" style="width:80;ime-mode:disabled;text-align:center" maxlength="8" dataformat="ymd" fullfill value="">&nbsp;<img src="img/btns_calendar.gif" name="cal_clm_stl_dt" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				<td width="" title="Rate of Exchange">R.O.E</td>
				<td width=""><input type="text" name="clm_stl_xch_rt" style="width:85;text-align:right" dataformat="float" value="">&nbsp;<img src="img/btns_search.gif" name="pop_clm_stl_xch_rt" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				<td width="" class="stm"><input type="text" name="clm_stl_usd_amt" dataformat="float" maxlength="18" style="width:160;text-align:right" value="">&nbsp;</td><td width="21" class="stm">USD</td>
				</tr>
				<tr class="h23">
				<td width="">LP Claim Amount</td>
				<td width=""><input type="text" name="labl_pty_file_locl_amt" caption="LP Claim Amount" dataformat="float" maxlength="18" style="width:140;text-align:right" value="">&nbsp;<input type="text" name="labl_pty_file_locl_curr_cd" caption="LP Claim Amount Currency" maxlength="3" dataformat="engup" fullfill style="width:33;text-align:center;ime-mode:disabled" value="">&nbsp;<img src="img/btns_search.gif" name="pop_labl_pty_file_locl_curr_cd" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				<td width="">Date of LP Claim</td>
				<td width=""><input type="text" name="labl_pty_file_dt" caption="Date of LP Claim" style="width:80;ime-mode:disabled;text-align:center" maxlength="8" dataformat="ymd" fullfill value="">&nbsp;<img src="img/btns_calendar.gif" name="cal_labl_pty_file_dt" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				<td width="" title="Rate of Exchange">R.O.E</td>
				<td width=""><input type="text" name="labl_pty_file_xch_rt" style="width:85;text-align:right" dataformat="float" value="">&nbsp;<img src="img/btns_search.gif" name="pop_labl_pty_file_xch_rt" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				<td width="" class="stm"><input type="text" name="labl_pty_file_usd_amt" dataformat="float" maxlength="18" style="width:160;text-align:right" value="">&nbsp;</td><td width="21" class="stm">USD</td>
				</tr>
				<tr class="h23">
				<td width="">LP Recovered Amount</td>
				<td width=""><input type="text" name="labl_pty_rcvr_locl_amt" caption="LP Recovered Amount" dataformat="float" maxlength="18" style="width:140;text-align:right" value="">&nbsp;<input type="text" name="labl_pty_rcvr_locl_curr_cd" caption="LP Recovered Amount Currency" maxlength="3" dataformat="engup" fullfill style="width:33;text-align:center;ime-mode:disabled" value="">&nbsp;<img src="img/btns_search.gif" name="pop_labl_pty_rcvr_locl_curr_cd" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				<td width="">Date of LP Recovery</td>
				<td width=""><input type="text" name="labl_pty_rcvr_dt" caption="Date of LP Recovery" style="width:80;ime-mode:disabled;text-align:center" maxlength="8" dataformat="ymd" fullfill value="">&nbsp;<img src="img/btns_calendar.gif" name="cal_labl_pty_rcvr_dt" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				<td width="" title="Rate of Exchange">R.O.E</td>
				<td width=""><input type="text" name="labl_pty_rcvr_xch_rt" style="width:85;text-align:right" dataformat="float" value="">&nbsp;<img src="img/btns_search.gif" name="pop_labl_pty_rcvr_xch_rt" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				<td width="" class="stm"><input type="text" name="labl_pty_rcvr_usd_amt" dataformat="float" maxlength="18" style="width:160;text-align:right" value="">&nbsp;</td><td width="21" class="stm">USD</td>
				</tr>
				<tr class="h23">
				<td width="">INS Claim Amount</td>
				<td width=""><input type="text" name="insur_file_locl_amt" caption="INS Claim Amount" dataformat="float" maxlength="18" style="width:140;text-align:right" value="">&nbsp;<input type="text" name="insur_file_locl_curr_cd" caption="INS Claim Amount Currency" maxlength="3" dataformat="engup" fullfill style="width:33;text-align:center;ime-mode:disabled" value="">&nbsp;<img src="img/btns_search.gif" name="pop_insur_file_locl_curr_cd" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				<td width="">Date of INS Claim</td>
				<td width=""><input type="text" name="insur_file_dt" caption="Date of INS Claim" style="width:80;ime-mode:disabled;text-align:center" maxlength="8" dataformat="ymd" fullfill value="">&nbsp;<img src="img/btns_calendar.gif" name="cal_insur_file_dt" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				<td width="" title="Rate of Exchange">R.O.E</td>
				<td width=""><input type="text" name="insur_file_xch_rt" style="width:85;text-align:right" dataformat="float" value="">&nbsp;<img src="img/btns_search.gif" name="pop_insur_file_xch_rt" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				<td width="" class="stm"><input type="text" name="insur_file_usd_amt" dataformat="float" maxlength="18" style="width:160;text-align:right" value="">&nbsp;</td><td width="21" class="stm">USD</td>
				</tr>
				<tr class="h23">
				<td width="">INS Recovered Amount</td>
				<td width=""><input type="text" name="insur_rcvr_locl_amt" caption="INS Recovered Amount" dataformat="float" maxlength="18" style="width:140;text-align:right" value="">&nbsp;<input type="text" name="insur_rcvr_locl_curr_cd" caption="INS Recovered Amount Currency" maxlength="3" dataformat="engup" fullfill style="width:33;text-align:center;ime-mode:disabled" value="">&nbsp;<img src="img/btns_search.gif" name="pop_insur_rcvr_locl_curr_cd" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				<td width="">Date of INS Recovery</td>
				<td width=""><input type="text" name="insur_rcvr_dt" caption="Date of INS Recovery" style="width:80;ime-mode:disabled;text-align:center" maxlength="8" dataformat="ymd" fullfill value="">&nbsp;<img src="img/btns_calendar.gif" name="cal_insur_rcvr_dt" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				<td width="" title="Rate of Exchange">R.O.E</td>
				<td width=""><input type="text" name="insur_rcvr_xch_rt" style="width:85;text-align:right" dataformat="float" value="">&nbsp;<img src="img/btns_search.gif" name="pop_insur_rcvr_xch_rt" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				<td width=""><input type="text" name="insur_rcvr_usd_amt" dataformat="float" maxlength="18" style="width:160;text-align:right" value="">&nbsp;</td><td width="21" class="stm">USD</td>
				</tr>
			</table> 
			
	</td></tr></table> 
			
	<table class="height_8"><tr><td></td></tr></table>		
	
	<!-- Tab (S) -->
     	<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%>
				<tr>
					<td width="100%">
						<script language="javascript">ComTabObject('tab1')</script>
					</td>
				</tr>
			</table>
		<!-- Tab (E) -->
		
	<table class="search" border="0" id="mainTable"> 
    <tr><td class="bg">	
	
	<div id="tabLayer" style="display:inline;height:180">
		<table class="search" border="0" style="width:979;"> 
		<tr class="h23">
			<td><textarea name="dw_clm_cs_desc" required caption="Case Summary" maxlength="4000" style="width:100%" rows="12" class="textarea1""></textarea></td>
			</tr>
		</table> 
	</div>

	<div id="tabLayer" style="display:none;height:180">
		<table class="search" border="0" style="width:979;"> 
		<tr class="h23">
			<td><textarea name="inci_dev_desc" style="width:100%" caption="Development" maxlength="4000" rows="12" class="textarea"></textarea></td>
			</tr>
		</table> 
	</div>
	
	<div id="tabLayer" style="display:none;height:180">
		<table class="search" border="0" style="width:979;"> 
		<tr class="h23">
			<td><textarea name="hdlr_stl_opin_desc" style="width:100%" caption="Handler's Opinion On Settlement" maxlength="4000" rows="12" class="textarea"></textarea></td>
			</tr>
		</table> 
	</div>
		
	<div id="tabLayer" style="display:none;height:180">
		<table class="search" border="0" style="width:979;"> 
		<tr class="h23">
			<td width="110">Claimant's Agent</td>
			<td width="97"><input type="text" name="clmt_agn_clm_pty_no" style="width:70;" readonly value="">&nbsp;<img src="img/btns_search.gif" name="pop_clmt_agn_clm_pty_no" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
			<td width="274"><input type="text" name="clmt_agn_clm_pty_nm" style="width:270;" readonly value="" class="input2"></td>
			<td width="85"><table width="60" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_ca_style" style="color:#cc3300">Style</td>
					<td class="btn2_right"></td>
					</tr>
				</table></td>
			<td width="69">Type of CA</td>
			<td width="120"><script language="javascript">ComComboObject("combo_clmt_agn_tp_cd", 2, 70, 1, 0, 0, true);</script></td>
			<td width="120">CA Appointed Date</td>
			<td width=""><input type="text" name="clmt_agn_apnt_dt" caption="CA Appointed Date" style="width:80;ime-mode:disabled;text-align:center" maxlength="8" dataformat="ymd" fullfill  value="">&nbsp;<img src="img/btns_calendar.gif" name="cal_clmt_agn_apnt_dt" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
			</tr>
		</table> 
		
		<table class="search" border="0" style="width:979;"> 
		<tr class="h23">
			<td width="20">Tel</td>
			<td width="230"><input type="text" name="clmt_agn_tel_no" readonly style="width:200;" value="" class="input2"></td>
			<td width="36">E-Mail</td>
			<td width="280"><input type="text" name="clmt_agn_email" readonly style="width:250;" value="" class="input2"></td>
			<td width="160">Claimant's Agent Ref No.</td>
			<td width=""><input type="text" name="clmt_agn_ref_no" caption="Claimant's Agent Ref No." maxlength="20" style="width:100%;ime-mode:disabled" value=""></td>
			</tr>
		</table> 
	</div>
		
	<div id="tabLayer" style="display:none;height:180">
		<table class="search" border="0" style="width:979;"> 
		<tr class="h23">
			<td width="120">Defendant's Agent</td>
			<td width="97"><input type="text" name="deft_agn_clm_pty_no" style="width:70;" readonly value="">&nbsp;<img src="img/btns_search.gif" name="pop_deft_agn_clm_pty_no" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
			<td width="274"><input type="text" name="deft_agn_clm_pty_nm" style="width:270;" readonly value="" class="input2"></td>
			<td width="75"><table width="60" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_da_style" style="color:#cc3300">Style</td>
					<td class="btn2_right"></td>
					</tr>
				</table></td>
			<td width="79">Type of DA</td>
			<td width="93"><script language="javascript">ComComboObject("combo_deft_agn_tp_cd", 2, 70, 1, 0, 0, true);</script></td>
			<td width="130">DA Appointed Date</td>
			<td width=""><input type="text" name="deft_agn_apnt_dt" caption="DA Appointed Date" style="width:80;ime-mode:disabled;text-align:center" maxlength="8" dataformat="ymd" fullfill  value="">&nbsp;<img src="img/btns_calendar.gif" name="cal_deft_agn_apnt_dt" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
			</tr>
		</table> 
		
		<table class="search" border="0" style="width:979;"> 
		<tr class="h23">
			<td width="20">Tel</td>
			<td width="230"><input type="text" name="deft_agn_tel_no" readonly style="width:200;" value="" class="input2"></td>
			<td width="36">E-Mail</td>
			<td width="280"><input type="text" name="deft_agn_email" readonly style="width:250;" value="" class="input2"></td>
			<td width="170">Defendant's Agent Ref No.</td>
			<td width=""><input type="text" name="deft_agn_ref_no" caption="Defendant's Agent Ref No." maxlength="20" style="width:100%;ime-mode:disabled" value=""></td>
			</tr>
		</table> 
	</div>
		
	<div id="tabLayer" style="display:none;height:180">
		<!-- Grid  (S) -->
		<table width="100%"  id="mainTable"> 
			<tr>
				<td width="100%">
					<script language="javascript">ComSheetObject('sheet1');</script>
				</td>
			</tr>
		</table> 
		<!-- Grid (E) -->
		<!--  Button_Sub (S) -->
		<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_Row_Add">Row&nbsp;Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_Row_Insert">Row Insert</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_Row_Delete">Row&nbsp;Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_Save">File Save</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
		</table>
	    	<!-- Button_Sub (E) -->
	</div>
	
	</td>
	</tr></table> 
			
		
			<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Retrieve" id="btn1_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_CaseClose" id="btn1_CaseClose">Case Close</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Reopen" id="btn1_Reopen">Reopen</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Cancel" id="btn1_Cancel">Cancel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Handling_Costs" style="color:#cc3300">Handling Costs</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Case_Report" style="color:#cc3300">Case Report</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
		</table>
<script language="javascript">ComUploadObject('upload1', '<=session.getId()%>');</script>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
