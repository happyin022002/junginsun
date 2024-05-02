<%/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : cps_cni_0015.jsp
 *@FileTitle : [CPS_CNI_0015] Indemnity Claim
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.22
 *@LastModifier : 박제성
 *@LastVersion : 1.0
 * 2009.10.22 박제성
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
<%@page import="com.hanjin.apps.alps.cps.cni.containercargoclaim.indemnityclaim.event.CpsCni0015Event"%>
<%@page import="com.hanjin.apps.alps.cps.cni.common.CniUtil"%>
<%
	CpsCni0015Event event = null;
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
	String userCgoClmNo = "";
	String reqCgoClmNo = "";

    Logger log = Logger.getLogger("com.hanjin.apps.alps.cps.cni.containercargoclaim.ContainerCargoClaimSC");

    
    SignOnUserAccount account = null;
    
    try
    {

		reqCgoClmNo  = JSPUtil.getParameter(request, "cgo_clm_no","");

        account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        userId = account.getUsr_id();
        userName = account.getUsr_nm();
        userOffice = account.getOfc_cd();

		//session start
		if(!reqCgoClmNo.equals("")){//req 있으면 req claimNo 로 세팅.
			userCgoClmNo = reqCgoClmNo;
		}else{//req 없으면 session 에 있는지 체크.
			if(!CniUtil.getCargoClaimNo(account).equals("")){//session 에 있으면 session 값으로 세팅
				userCgoClmNo = CniUtil.getCargoClaimNo(account);
			}
		}

		userCgoClmNo = CniUtil.getCargoClaimNo(account);
		//session end

        event = (CpsCni0015Event) request.getAttribute("Event");
        serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null)
        {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

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
<title></title>
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

</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="bkg_no">

<!-- PRINT  -->
<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdArguments">
<input type="hidden" name="com_mrdTitle">
<input type="hidden" name="com_mrdBodyTitle">

<!--RD 를 위한변수-->
<input type="hidden" name="rd_title" value="">
<input type="hidden" name="rd_title_nm" value="">
<input type="hidden" name="rd_report_by" value="">

<input type="hidden" name="usr_id" value="<%=userId%>">
<input type="hidden" name="usr_roles" value="<%=roles%>">
<input type="hidden" name="usr_area" value="<%=area%>">
<input type="hidden" name="usr_office" value="<%=ofcCd%>">

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
				<td width="67">Claim  No.</td>
				<td width="143"><input type="text" style="width:80;;text-align:center" name="cgo_clm_no" value="<%=userCgoClmNo%>" required maxlength="10" caption="Claim  No" onKeyPress="ComKeyOnlyAlphabet('uppernum')" class="input1">&nbsp;<input type="text" style="width:20;" name="clm_area_cd" value="" class="input2" readonly></td>
				<td width="35" title="Handling Office">HOFC</td>
				<td width="62"><input type="text" style="width:50;;text-align:center" name="hdlr_ofc_cd" value="" class="input2"  readonly></td>
				<td width="50">Handler</td>
				<td width="110"><input type="text" style="width:75;;text-align:center" name="hdlr_usr_id" value="" class="input2"  readonly>&nbsp;<img class="cursor" src="img/btns_search.gif" name="btn1_Handler" width="19" height="20" border="0" align="absmiddle"></td>
				<td width="30" title="Date Of Updated">DOU</td>
				<td width="100"><input type="text" style="width:76;;text-align:center" name="upd_dt" value="" class="input2"  readonly></td>
				<td width="75">Incident No.</td>
				<td width="110"><input type="text" style="width:90;;text-align:center" name="cgo_clm_inci_no" value="" class="input2"  readonly></td>
				<td width="50">VOC No.</td>
				<td width=""><input type="text" style="width:100%;;text-align:center" name="crm_voc_no" value="" class="input2"  readonly></td>
				</tr>
			</table>
			<table class="search" border="0" style="width:979;">
			<tr class="h23">
				<td width="67">Status</td>
				<td width="120"><input type="text" style="width:104;;text-align:center" name="clm_misc_nm" value="" class="input2"  readonly><input type="hidden" name="clm_misc_cd" value=""></td>
				<td width="57"><span title="Handling Period">HPD</span>/<span title="Net Handling Period">NHP</span></td>
				<td width="115"><input type="text" style="width:40;;text-align:center" name="hpc" value="" class="input2"  readonly>&nbsp;/&nbsp;<input type="text" style="width:40;text-align:center" name="nhp" value="" class="input2"  readonly></td>
				<td width="30" title="Type Of Settlement" >TOS</td>
				<td width="60"><input type="text" style="width:45;;text-align:center" name="cgo_clm_stl_tp_cd" value="" class="input2"  readonly></td>
				<td width="30" title="Date Of Close">DOC</td>
				<td width="80"><input type="text" style="width:76;;text-align:center" name="cs_clz_dt" value="" class="input2" readonly></td>
				<td width="80" title="Time Barred Date" >
						<table width="80" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2_3" name="btns_TB_Date">DOTB</td>
										<td class="btn2_right"></td>
									</tr>
						</table></td>
				<td width="110"><input type="text" style="width:90;text-align:center" name="clm_tm_bar_dt" value="" class="input2" readonly></td>
				<td width="140">Summons Served Date</td>
				<td width=""><input type="text" style="width:100%;;text-align:center" name="smns_sve_date" value="" class="input2" readonly></td>
				</tr>
			</table>
			
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="67">B/L No. </td>
				<td width="100"><input type="text" style="width:95;" name="cgo_clm_ref_bl_no" value="" class="input2" readonly></td>
				<td width="90"><table width="80" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2_3" name="btn_BLPreview" >B/L View</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				<td width="27">Term</td>
				<td width="50"><input type="text" style="width:40;text-align:center" name="crr_term_cd" value="" class="input2" readonly></td>
				<td width="65" title="Place of Receipt/Date of Receipt">POR/DOR</td>
				<td width="155"><input type="text" style="width:50;" name="por_cd" value="" class="input2" readonly>&nbsp;/&nbsp;<input type="text" style="width:75;" name="rct_dt" value="" class="input2" readonly></td>
				<td width="25" title="Port of Loading">POL</td>
				<td width="82"><input type="text" style="width:50;" name="pol_cd" value="" class="input2" readonly></td>
				<td width="25" title="Port of Discharge">POD</td>
				<td width="70"><input type="text" style="width:50;" name="pod_cd" value="" class="input2" readonly></td>
				<td width="77"><span title="Place of Delivery">DEL</span>/DDL</td>
				<td width=""><input type="text" style="width:50;" name="del_cd" value="" class="input2" readonly>&nbsp;/&nbsp;<input type="text" style="width:75;" name="de_dt" value="" class="input2" readonly></td>
				</tr>
			</table> 
			
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="67" title="Type of Cargo Claim">TOC</td>
				<td width="88"><input type="text" style="width:50;;text-align:center" name="cgo_clm_tp_cd" value="" class="input2" readonly></td>
				<td width="47" title="Cause of Damage / Loss">CODL</td>
				<td width="60"><input type="text" style="width:40;;text-align:center" name="mjr_clm_dmg_lss_cd" value="" class="input2" readonly></td>
				<td width="100" title="No 3rd Liable Party">3rd Liable Party</td>
				<td width="73"><input type="text" style="width:40;;text-align:center" name="n3rd_labl_pty_cd" value="" class="input2" readonly></td>
				<td width="38" title="Place of Incident">POI</td>
				<td width="80"><input type="text" style="width:46;;text-align:center" name="inci_plc_tp_cd" value="" class="input2" readonly></td>
				<td width="30" title="Date of Incident">DOI</td>
				<td width="100"><input type="text" style="width:76;;text-align:center" name="inci_occr_dt" value="" class="input2" readonly></td>
				<td width="55"> Cargo</td>
				<td width="" class="stm" align="right"><input type="text" style="width:100%;;text-align:left" name="cgo_qlty_desc" value="" class="input2" readonly></td>
				<input type="hidden" name="clm_cgo_tp_cd">
					</tr>
			</table> 
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="110">Claim Amount</td>
				<td width="188"><input type="text" style="width:132;text-align:right" name="clmt_locl_amt" value="" class="input2" readonly >&nbsp;<input type="text" style="width:40;;text-align:center" name="clmt_locl_curr_cd" value="" class="input2" readonly></td>
				<td width="28" title="Date of Formal Claim">DOF</td>
				<td width="92"><input type="text" style="width:76;text-align:center" name="fmal_clm_rcv_dt" value="" class="input2" readonly></td>
				<td width="33" title="Rate of Exchange"> R.O.E</td>
				<td width="" class="stm" align=""><input type="text" style="width:70;text-align:right" name="clmt_locl_xch_rt" value="" class="input2" readonly>&nbsp;<input type="text" style="width:160;text-align:right" name="clmt_usd_amt" value="" class="input2" readonly >&nbsp;&nbsp;USD</td>
			</tr>
			<tr class="h23">
				<td width="">Settled Amount</td>
				<td width=""><input type="text" style="width:132;text-align:right" name="cgo_clm_stl_locl_amt" value="" class="input2" readonly >&nbsp;<input type="text" style="width:40;;text-align:center" name="cgo_clm_stl_locl_curr_cd" value="" class="input2" readonly></td>
				<td width="" title="Date Of Settlement">DOS</td>
				<td width=""><input type="text" style="width:76;text-align:center" name="cgo_clm_stl_dt" value="" class="input2" readonly></td>
				<td width="" title="Rate of Exchange"> R.O.E</td>
				<td width="" class="stm"  align=""><input type="text" style="width:70;text-align:right" name="cgo_clm_stl_xch_rt" value="" class="input2" readonly>&nbsp;<input type="text" style="width:160;text-align:right" name="cgo_clm_stl_usd_amt" value="" class="input2" readonly >&nbsp;&nbsp;USD</td>
			</tr>
			</table>			
			
			<table class="line_bluedot"><tr><td></td></tr></table>
			
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="90">Liable Party</td>
				<input type="hidden" name="clm_pty_no">
				<td width="333"><input type="text" style="width:80;" name="clm_pty_abbr_nm" value="" class="input1" required caption="Liable Party">&nbsp;<img src="img/btns_search.gif" name="btns_liable_party" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">&nbsp;<input type="text" style="width:220;" name="pty_nm" value="" class="input2" readonly></td>
				<td width="77"><table width="60" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2_3" name="btns_style" >Style</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				<td width="55">LP HOFC</td>
				<td width="">
						<input type="text" style="width:80;text-align:center;" name="hndl_ofc_cd" value="" class="input1"  required caption="LP HOFC">&nbsp;<img src="img/btns_search.gif" name="btns_hndl_ofc_cd" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
						</td>
				<td width="137"><table width="100" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2_3" name="btn1_File_Upload" >File Upload</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</tr>
			</table> 
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="188"></td>
				<td width="50" title="LP Date Of Preliminary Notice">LP DON</td>
				<td width="163"><input type="text" style="width:80; text-align: center; ime-mode: disabled" name="labl_pty_prlm_clm_ntfy_dt" dataformat="ymd" maxlength="8" value="" class="input1" required caption="LP NOPC Date">&nbsp;<img src="img/btns_calendar.gif" name="btns_labl_pty_prlm_clm_ntfy_dt" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				
				<td width="60" title="LP Time Barred Date">LP DOTB</td>
				<td width=""><input type="text" style="width:80; text-align: center; ime-mode: disabled" name="tm_bar_dt" dataformat="ymd" maxlength="8" value="" class="input1" required caption="LP T/B Date">&nbsp;<img src="img/btns_calendar.gif" name="btns_tm_bar_dt" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				
				
				
				</tr>
			</table> 
			
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="130">LP Claim Amount</td>
				<td width="259"><input type="text" style="width:132;text-align:right" name="labl_pty_dmnd_amt" value="" class="input" dataformat="float" caption="LP Claim Amount">&nbsp;<input type="text" style="width:40;text-align:center" name="labl_pty_dmnd_curr_cd" value="" class="input"  maxlength="3" minlength="3" onBlur="javascript:setXchRt()">&nbsp;<img src="img/btns_search.gif" name="btns_currency" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				<td width="60" title="LP Date of Formal Claim">LP DOF</td>
				<td width="193"><input type="text" style="width:80;text-align:center" name="labl_pty_fmal_clm_dt" dataformat="ymd" maxlength="8" value="" class="input" caption="LP DOF">&nbsp;<img src="img/btns_calendar.gif" name="btns_labl_pty_fmal_clm_dt" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				<td width="50" title="Rate of Exchange"> R.O.E</td>
				<td width=""  align="" class="stm"><input type="text" style="width:70;text-align:right" name="labl_pty_xch_rt" value="" class="input" caption=" R.O.E">&nbsp;<img src="img/btns_search.gif" name="btns_roe1" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">&nbsp;<input type="text" style="width:136;text-align:right" name="labl_pty_dmnd_usd_amt" value="" class="input2" dataformat="float" readonly>&nbsp;&nbsp;USD</td>
			</tr>
			<tr class="h23">
				<td width="">LP Recovered Amount</td>
				<td width=""><input type="text" style="width:132;text-align:right" name="labl_pty_rcvr_locl_amt" value="" class="input" dataformat="float" caption="LP Recovered Amount">&nbsp;<input type="text" style="width:40;text-align:center" name="labl_pty_rcvr_locl_curr_cd" value="" class="input" maxlength="3" minlength="3" onBlur="javascript:setLoclXchRt()">&nbsp;<img src="img/btns_search.gif" name="btns_currency2" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				<td width="" title="LP Date of Receipt">LP DOR</td>
				<td width=""><input type="text" style="width:80;text-align:center" name="labl_pty_rcvr_dt" dataformat="ymd" maxlength="8" value="" class="input" caption="LP DOR">&nbsp;<img src="img/btns_calendar.gif" name="btns_labl_pty_rcvr_dt" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				<td width="50" title="Rate of Exchange"> R.O.E</td>
				<td width=""  align="" class="stm"><input type="text" style="width:70;text-align:right" name="labl_pty_rcvr_locl_xch_rt" value="" class="input" caption=" R.O.E">&nbsp;<img src="img/btns_search.gif" name="btns_roe2" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">&nbsp;<input type="text" style="width:136;text-align:right" name="labl_pty_rcvr_usd_amt" value="" class="input2" dataformat="float" readonly>&nbsp;&nbsp;USD</td>
			</tr>
			</table> 
			
			<table class="height_8"><tr><td></td></tr></table>
			<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Development</td></tr>
				</table>
			<table border="0" style="width:100%; background-color:white;" class="grid2">
				<tr>
					<td><textarea name="labl_pty_clm_rmk" style="width:100%;;ime-mode:disabled" rows="15" class="textarea"></textarea></td>
				</tr>
			</table>
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
					<td class="btn1" name="btn1_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Cancel" >Cancel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1_2" name="btn1_Payment" >Payment</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1_2" name="btn1_Handling_Costs" >Handling&nbsp;Costs</td>
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


<!-- 개발자 작업  끝 -->
</form>
<div style="display: none;"><script language="javascript">ComSheetObject('sheet1');</script></div>
</body>
</html>
