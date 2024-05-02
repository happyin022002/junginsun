<%/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : cps_cni_0032.jsp
 *@FileTitle : [CPS_CNI_0020] Report-Settlement Analysis
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.07
 *@LastModifier : 양정란
 *@LastVersion : 1.0
 * 2009.04.17 양정란
 * 1.0 Creation
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@page import="com.hanjin.apps.alps.cps.cni.containercargoclaimreport.containercargoclaimreport.event.CpsCni0020Event"%>
<%@page import="com.hanjin.apps.alps.cps.cni.common.CniUtil"%>
<%@page import="com.hanjin.framework.component.util.io.HttpUtil"%>
<%
	CpsCni0020Event event = null;
    Exception serverException = null;
    String strErrMsg = "";
    int rowCount = 0;

    String successFlag = "";
    String codeList = "";
    String pageRows = "100";

    String userId = "";
    String userName = "";
    String userOffice = "";
    String userArea = "";
	String schFromStrGmt = "";
	String schToStrGmt = "";//조회조건의 to날짜(GMT)

    Logger log = Logger.getLogger("com.hanjin.apps.alps.cps.cni.containercargoclaim.ContainerCargoClaimSC");
	String xml = HttpUtil.makeXML(request,response);
	SignOnUserAccount account = null;

    try
    {

        account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        userId = account.getUsr_id();
        userName = account.getUsr_nm();
        userOffice = account.getOfc_cd();

        event = (CpsCni0020Event) request.getAttribute("Event");
        serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null)
        {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		schFromStrGmt = eventResponse.getETCData("schToDate").substring(0,4) + "-01" + "-01";
		schToStrGmt = eventResponse.getETCData("schToDate");

    }
    catch (Exception e)
    {
        out.println(e.toString());
    }
    
    // 사용자 roles
    String roles = CniUtil.getRoles(account);
    String area =  CniUtil.getAreaInfo(account);
    String ofcCd = account.getOfc_cd();

%>


<%@page import="com.hanjin.apps.alps.cps.gem.common.GemUtil"%>
<%@page import="com.hanjin.framework.component.util.StringUtil"%>

<html>
<head>
<title>Report-Settlement Analysis</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
function setupPage(){
	var errMessage = "<%=strErrMsg%>";
	if (errMessage.length >= 1) {
		showErrMessage(errMessage);
	} // end if
	loadPage();
}
</script>
<script language="javascript" src="rpt/script/rdviewer50.js"></script>
</head>

<body  onLoad="setupPage();">
<form name="form2">
<input type="hidden" name="sXml" value="<%=xml%>">
</form>
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows" value="100">
<input type="hidden" name="page_no" value="1">

<!-- 개발자 작업 -->
<!-- PRINT  -->
<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdArguments">
<input type="hidden" name="com_mrdTitle">
<input type="hidden" name="com_mrdBodyTitle">
<input type="hidden" name="usr_area" value="<%=area%>">
<!-- 조회조건  -->
<input type="hidden" name="schFromStrGmt" value="<%=schFromStrGmt%>">
<input type="hidden" name="schToStrGmt" value="<%=schToStrGmt%>">
<input type="hidden" name="userId" value="<%=userId%>">
<input type="hidden" name="userOffice" value="<%=userOffice%>">
<!--RD 를 위한변수-->
<input type="hidden" name="rd_title" value="">
<input type="hidden" name="rd_title_nm" value="">
<input type="hidden" name="rd_report_by" value="">
<input type="hidden" name="clm_area_cd" value="">
<input type="hidden" name="cgo_clm_sts_cd" value="">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
<tr>
<td valign="top">

    <!--Page Title, Historical (S)-->
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
    </table>
    <!--Page Title, Historical (E)-->

		<!--biz page (S)-->

<table class="search" id="mainTable">
    <tr><td class="bg">

			<table class="search" border="0" style="width:979;">
			<tr class="h23">
				<td width="74">Report by</td>
				<td width="140"><select name="report_by" style="width:100;" class="input1">
						<option value="09" selected>Area</option>
						<option value="08">Status</option>
						<option value="HOFC">HOFC</option>
						<option value="HANDLER">Handler</option>
						<option value="LP_HOFC">LP HOFC</option>
						<option value="LIABLE_PARTY">Liable Party</option>
						<option value="SURVEYOR">Surveyor</option>
						<option value="ROFC">ROFC</option>
						<option value="CLAIMANT">Claimant</option>
						<option value="CLAIMANT_AGENT">Claimant’s Agent</option>
						<option value="SALVAGER">Salvager</option>
						<option value="INSURER">Insurer</option>
						<option value="VVD">VVD</option>
						<option value="POR">POR</option>
						<option value="POL">POL</option>
						<option value="POD">POD</option>
						<option value="DEL">DEL</option>
						<option value="FVD">FVD</option>
						<option value="PRE_POT">PRE_POT</option>
						<option value="ON_POT">ON_POT</option>
						<option value="CT">CT</option>
						<option value="14">POI</option>
						<option value="LANE">Lane</option>
						<option value="15">Cargo</option>
						<option value="11">TOC</option>
						<option value="02">CODL</option>
						<option value="05">3rd Liable Party</option>
						<option value="LITIGATION">Litigation</option>
						<option value="07">TOS</option>
						<option value="CLAIM_AMOUNT">Claim Amount</option>
						<option value="SETTLED_AMOUNT">Settled Amount</option>
						<option value="MONTH">Month</option>
						<option value="YEAR">Year</option>
						</select></td>
				<td width="45">Period</td>
				<td width="340"><script language="javascript">ComComboObject("period", 2, 67, 1);</script>&nbsp;<input type="text" name="from_period" style="width:80;" value="" class="input1" required maxlength="8" dataformat="ymd" caption="Period(From Date)">&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="btns_from_period" width="19" height="20" border="0" align="absmiddle">&nbsp;~&nbsp;<input type="text" name="to_period" style="width:80;" value="" class="input1" required maxlength="8" dataformat="ymd" caption="Period(To Date)">&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="btns_to_period" width="19" height="20" border="0" align="absmiddle"></td>
				<td width="30">Area</td>
				<td width="90"><script language="javascript">ComComboObject("area", 2, 67, 1);</script></td>
				<td width="30">Status</td>
				<td width="110"><script language="javascript">ComComboObject("status", 2, 67, 1);</script></td>
				<td width="28">Class</td>
				<td width=""><select style="width:70;" name="vt" class="input1">
						<option value="All" selected>ALL</option>
						<option value="G">GEN</option>
						<option value="I">INC</option>
						<option value="O">OTH</option>
						</select></td>
				</tr>
			</table>
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="36" title="Handling Office">HOFC</td>
					<td width="70"><input type="text" name="hdlr_ofc_cd" style="width:60;text-align:center" value="" class="input" dataformat="engup" maxlength="6" caption="HOFC"></td>
					<td width="58">Handler</td>
					<td width="95"><input type="text" name="hdlr_usr_id" style="width:60;text-align:center" value="" class="input" dataformat="engup" maxlength="20"></td>
					<td width="77">Manager</td>
					<td width="95"><input type="text" name="mgr_usr_id"  style="width:65;" value="" class="input" dataformat="engup"></td>
					<td width="60">LP HOFC</td>
					<td width="110"><input type="text" style="width:80;text-align:center;" name="hndl_ofc_cd" value="" class="input"   dataformat="engup" maxlength="6" caption="LP HOFC">&nbsp;<img src="img/btns_search.gif" name="btns_hndl_ofc_cd" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
					</td>
					<td width="74">Liable Party<input type="hidden" name="labl_clm_pty_no"></td>
					<td width="110"><input type="text" name="clm_liable_pty_abbr_nm" style="width:70;" value="" class="input" dataformat="engup" maxlength="20">&nbsp;<img class="cursor" name="btn1_Liable_Party" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="50">Surveyor<input type="hidden" name="svey_clm_pty_no"></td>
					<td width=""><input type="text" name="clm_surveyor_pty_abbr_nm" style="width:70;" value="" class="input" dataformat="engup" maxlength="20">&nbsp;<img class="cursor" name="btn1_Surveyor"  src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
				</tr>
				<tr class="h23">
					<td width="" title="Received Office">ROFC</td>
					<td width=""><input type="text" name="fmal_clm_rcv_ofc_cd" style="width:60;text-align:center;" value="" class="input"></td>
					<td width="">Claimant<input type="hidden" name="clmt_clm_pty_no"></td>
					<td width=""><input type="text" name="clmt_clm_pty_abbr_nm" style="width:60;" value="" class="input" dataformat="engup" maxlength="20">&nbsp;<img class="cursor" name="btn1_Claimant" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="">Claimant's Agent<input type="hidden" name="clmt_clm_agn_pty_no"></td>
					<td width=""><input type="text" name="clmt_clm_agn_pty_abbr_nm"  style="width:65;" value="" class="input" dataformat="engup" maxlength="20">&nbsp;<img class="cursor" name="btn1_Claimant_Agent" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="">Salvager<input type="hidden" name="slv_clm_pty_no"></td>
					<td width=""><input type="text" name="slv_clm_pty_abbr_nm" style="width:80;" value="" class="input" dataformat="engup" maxlength="20">&nbsp;<img class="cursor" name="btn1_Salvager" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="">Insurer<input type="hidden" name="insur_clm_pty_no"></td>
					<td width="" colspan="3"><input type="text" name="insur_clm_pty_abbr_nm" style="width:70;" value="" class="input" dataformat="engup" maxlength="20">&nbsp;<img class="cursor" name="btn1_Insurer" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
				</tr>
			</table>
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="36">VVD</td>
					<td width="77"><input type="text" name="trnk_ref_vvd_no" style="width:60;text-align:center;" value="" class="input" dataformat="engup" maxlength="20"></td>
					<td width="28" title="Place of Receipt">POR</td>
					<td width="95"><input type="text" name="por_cd" style="width:60;text-align:center;" value="" class="input" dataformat="engup" maxlength="5">&nbsp;<img class="cursor" name="btn1_POR" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="28" title="Port of Loading">POL</td>
					<td width="80"><input type="text" name="pol_cd" style="width:50;text-align:center;" value="" class="input" dataformat="engup" maxlength="5"></td>
					<td width="28" title="Port of Discharging">POD</td>
					<td width="75"><input type="text" name="pod_cd" style="width:53;text-align:center;" value="" class="input" dataformat="engup" maxlength="5"></td>
					<td width="28" title="Place of Delivery">DEL</td>
					<td width="100"><input type="text" name="del_cd" style="width:50;text-align:center;" value="" class="input" dataformat="engup" maxlength="5">&nbsp;<img class="cursor" name="btn1_DEL" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="37">FVD</td>
					<td width="100"><input type="text" name="fvd" style="width:76;text-align:center;" value="" class="input" dataformat="engup" maxlength="20"></td>
					<td width="50">PRE_POT</td>
					<td width="80"><input type="text" name="n1st_pre_ts_loc_cd" style="width:50;text-align:center;" value="" class="input" dataformat="engup" maxlength="5"></td>
					<td width="50">POS_POT</td>
					<td><input type="text"  name="n1st_pst_ts_loc_cd" style="width:100%;text-align:center;" value="" class="input" dataformat="engup" maxlength="5"></td>
				</tr>
			</table>
			<table class="search" border="0" style="width:979;"> 	
				<tr class="h23">
					<td width="37">CT</td>
					<td width="60" style="padding-left:2px"><script language="javascript">ComComboObject("crr_term_cd", 2, 45, 1);</script></td>
					<td width="26" title="Place of Incident">POI</td>
					<td width="70"><script language="javascript">ComComboObject("inci_plc_tp_cd", 2, 60, 1);</script></td>
					<td width="26">Lane</td>
					<td width="60"><input type="text" name="slan_cd" style="width:50;text-align:center;" value="" class="input" dataformat="engup" maxlength="3"></td>
					<td width="28">Cargo</td>
					<td width=""><input type="text" name="clm_cgo_tp_cd" style="width:30;text-align:center;"  value="" class="input" dataformat="engup" maxlength="6">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btn1_Cargo" width="19" height="20" border="0" align="absmiddle">&nbsp;<input type="text" name="clm_cgo_tp_nm" style="width:160;"  value="" class="input2" readonly="readonly"></td>
					<td width="28" title="Type of Cargo Claim">TOC</td>
					<td width=""><script language="javascript">ComComboObject("cgo_clm_tp_cd", 2, 60, 1);</script></td>
					<td width="" title="Cause of Damage or Loss">CODL</td>
					<td width=""><input type="text" name="mjr_clm_dmg_lss_cd" style="width:52;text-align:center;" value="" class="input" dataformat="engup" maxlength="6">&nbsp;<img class="cursor" name="btn1_CODL1" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="" title="No 3rd Liable Party">3LP</td>
					<td width=""><input type="text" name="n3rd_labl_pty_cd" style="width:50;text-align:center;" value="" class="input" dataformat="engup" maxlength="6">&nbsp;<img class="cursor" name="btn1_CODL2" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="">Litigation</td>
					<td><select style="width:40;" name="lit">
					    <option value="" selected></option>
						<option value="Y">Y</option>
						<option value="N">N</option>
						</select></td>
				</tr>
				</table> 				
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="34" title="Type Of Settlement">TOS</td>
					<td width="76">&nbsp;<script language="javascript">ComComboObject("cgo_clm_stl_tp_cd", 2, 60, 1);</script></td>
					<td width="92">Claim Amount</td>
					<td width="251"><input type="text" name="from_clmt_usd_amt" style="width:110;text-align:right" value="" dataformat="float" class="input">&nbsp;~&nbsp;<input type="text" name="to_clmt_usd_amt" style="width:104;text-align:right" dataformat="float" value="" class="input"></td>
					<td width="100">Settled Amount</td>
					<td width="255"><input type="text" name="from_cgo_clm_stl_usd_amt" style="width:110;text-align:right" value="" dataformat="float" class="input">&nbsp;~&nbsp;<input type="text" name="to_cgo_clm_stl_usd_amt" style="width:110;text-align:right" dataformat="float" value="" class="input"></td>
					<td width="50">INC No.</td>
					<td><input type="text" name="cgo_clm_inci_no" style="width:100%;" value="" class="input" dataformat="engup" maxlength="11"></td>
				</tr>
				</table>
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
	<!-- Grid  (S) -->
			<table width="100%"  id="mainTable">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table>
	<!-- Grid  (E) -->
		</td>
			</tr>
			</table>
			<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Retrieve">Retrieve</td>
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
					<td class="btn1" name="btn1_Down_Excel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Print">Print</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->



    <!--biz page (E)-->

</td>
</tr>
</table>


<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
