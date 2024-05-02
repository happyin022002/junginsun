<%/*=========================================================
     *Copyright(c) 2009 CyberLogitec
     *@FileName : cps_cni_0037.jsp
     *@FileTitle : [CPS_CNI_0037] Claim Reopen
     *Open Issues :
     *Change history :
     *@LastModifyDate : 2009.11.19
     *@LastModifier : 정행룡
     *@LastVersion : 1.0
     * 2009.11.19 정행룡
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
<%@ page import="com.hanjin.apps.alps.cps.cni.common.CniUtil"%>
<%
    Exception serverException = null;
    String strErrMsg = "";
    String userId = "";
    String userName = "";
    String userOffice = "";
    String roles = "";
    String area = "";
    
    Logger log = Logger.getLogger("com.hanjin.apps.alps.cps.cni.containercargoclaim.ContainerCargoClaimSC");
    
    String cgoClmNo = JSPUtil.getParameter(request, "cgo_clm_no" , "");
    
    try
    {
        SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        userId = account.getUsr_id();
        userName = account.getUsr_nm();
        userOffice = account.getOfc_cd();
        // 사용자 roles
        roles = CniUtil.getRoles(account);
        area =  CniUtil.getAreaInfo(account);
        
        serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null)
        {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
  		
      //세션에 Claim No가 존재하면
        String ssCgoClmNo =  eventResponse.getETCData("CGO_CLM_NO");
        if ( cgoClmNo.equals("") && !ssCgoClmNo.equals("")) {
        	cgoClmNo = ssCgoClmNo;
        }
        
    }
    catch (Exception e)
    {
        out.println(e.toString());
    }
    
 
%>

<html>
<head>
<title>Claim Reopen</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<script language="javascript">
	 
    function setupPage(){ 
    	var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
      
	    loadPage();
    }
</script>
<body  onLoad="setupPage();"> 

<form name="form1">
<input type="hidden" name="f_cmd"/>
<input type="hidden" name="clss_clm_misc_cd"/>
<input type="hidden" name="ofc_cd" value="<%=userOffice%>"/>
<input type="hidden" name="trns_seq" value=""/>
<input type="hidden" name="bfr_cgo_clm_sts_cd" value=""/> 
<input type="hidden" name="pre_cgo_clm_clz_cd" value=""/>  
<input type="hidden" name="usr_id" value="<%=userId%>">
<input type="hidden" name="usr_roles" value="<%=roles%>">
<input type="hidden" name="usr_area" value="<%=area%>">
<input type="hidden" name="usr_office" value="<%=userOffice%>">

<table width="100%" border="0" cellpadding="0" cellspacing="0"
	style="padding-top: 2; padding-left: 5;">
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
			<tr>
				<td class="bg">
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="57">Claim No.</td>
						<td width="120"><input type="text" name="cgo_clm_no" dataformat="engup"  maxlength="10" fullfill class="input1"
							style="width: 80; ime-mode: disabled" value="<%=cgoClmNo%>" required>&nbsp;<input
							type="text" name="clm_area_cd" style="width: 20;" value="" class="input2" readonly="readonly"></td>
						<td width="35">HOFC</td>
						<td width="70"><input type="text" name="hdlr_ofc_cd" style="width: 50;text-align:center"
							value="" class="input2" readonly="readonly"></td>
						<td width="50">Handler</td>
						<td width="120"><input type="text" name="hdlr_usr_id" style="width: 75;text-align:center"
							value="" class="input2" readonly="readonly">&nbsp;<img
							class="cursor" src="img/btns_search.gif" width="19"
							name="btns_hanlder_history" height="20" border="0"
							align="absmiddle"></td>
						<td width="29" title="Date Of Updated">DOU</td>
						<td width="100"><input type="text" name="upd_dt" dataformat="ymd"
							style="width: 75;text-align:center" value="" class="input2" readonly="readonly"></td>
						<td width="75">Incident No.</td>
						<td width="100"><input type="text" name="cgo_clm_inci_no" dataformt="engup"  maxlength="13" style="width: 90;" value="" class="input2" readonly="readonly"></td>
						<td width="50">VOC No.</td>
						<td width=""><input type="text" name="crm_voc_no" dataformt="engup" maxlength="15" style="width: 100%;" value="" class="input2" readonly="readonly"></td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="57">Status</td>
						<td width="120"><input type="hidden" name="cgo_clm_sts_cd"/><input type="text" name="cgo_clm_sts_nm"
							style="width: 105;text-align:center" value="" class="input2" readonly="readonly"></td>
						<td width="65"><span title="Handling Period">HPD</span>/<span title="Net Handling Period">NHP</span></td>
						<td width="115"><input type="text" name="hpd" style="width: 40;text-align:center"
							value="" class="input2" readonly="readonly">&nbsp;/&nbsp;<input
							type="text" name="nhp" style="width: 40;text-align:center" value="" class="input2"
							readonly="readonly"></td>
						<td width="30" title="Type Of Settlement" >TOS</td>
						<td width="60"><input type="text" name="cgo_clm_stl_tp_cd"
							style="width: 44;text-align:center" value="" class="input2" readonly="readonly"></td>
						<td width="30" title="Date Of Close">DOC</td>
						<td width="120"><input type="text" name="cs_clz_dt"
							dataformat="ymd" maxlength="8"
							style="width: 75; text-align: center; ime-mode: disabled"
							value="" class="input2" readonly="readonly">&nbsp;</td>
						<td width="55" title="Date Of Time Barred" >DOTB</td>
						<td width="110"><input type="text" name="clm_tm_bar_dt"
							dataformat="ymd" maxlength="8"
							style="width: 75; text-align: center; ime-mode: disabled" class="input2" readonly="readonly"
							value="">&nbsp;</td>
						<td width="140">Summons Served Date</td>
						<td width=""><input name="smns_sve_dt" type="text" dataformat="ymd" maxlength="8"
							style="width: 75; text-align: center; ime-mode: disabled" value="" class="input2" readonly="readonly"></td>
					</tr>
				</table>

				<table class="line_bluedot">
					<tr>
						<td></td>
					</tr>
				</table>

				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="178" ></td>
						<td width="45" title="Date Of Acknowledgement">DOACK</td>
						<td width="117"><input type="text" name="cgo_clm_acknak_dt"
							dataformat="ymd" maxlength="8"
							style="width: 75; text-align: center; ime-mode: disabled"
							value="" class="input2" readonly="readonly" dataformat="ymd"></td>
						<td width="30" title="Date Of Fact Finding">DOFF</td>
						<td width="125"><input name="fact_fnd_dt" type="text"
							dataformat="ymd" maxlength="8"
							style="width: 75; text-align: center; ime-mode: disabled"
							value="" class="input2" readonly="readonly"></td>
						<td width="80">LP DOTB</td>
						<td width="110"><input type="text" name="labl_tm_bar_dt"
							style="width: 75;" value="" class="input2" readonly="readonly"></td>
						<td width="125">Transfer&nbsp;<input type="checkbox"
							name="trns_flg" value="Y" class="trans" onclick = "javascript:return false"  onfocus="this.blur">
							<input
							type="text" name="clm_trns_auth_cd" readonly="readonly"
							style="width: 30;" value="" class="input2"></td>
						<td width="60">Reopen</td>
						<td width=""><input type="hidden" name="cs_clz_ropn_flg" value=""><input name="cs_clz_ropn_dt" dataformat="ymd"
							maxlength="8" type="text"
							style="width: 75; text-align: center; ime-mode: disabled"
							value="" class="input2" readonly="readonly"></td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		<table class="height_8">
			<tr>
				<td></td>
			</tr>
		</table>

		<!-- Tab (S) -->
		<table class="tab" border="0" cellpadding="0" cellspacing="0"
			width=100%>
			<tr>
				<td width="100%"><script language="javascript">ComTabObject('tab1')</script>
				</td>
			</tr>
		</table>
		<!-- Tab (E) --> <!-- Tab1 (S) -->
		<div id="tabLayer1" style="display: inline">
		<table class="search">
			<tr>
				<td class="bg">
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="90">
						<table class="search_sm2" border="0" style="width: 80;">
							<tr class="h23">
								<td><input name="cgo_clm_div_cd" type="radio" value="G"	class="trans" disabled>&nbsp;&nbsp;GEN</td>
							</tr>
							<tr class="h23">
								<td><input name="cgo_clm_div_cd" type="radio" value="I"	class="trans" disabled>&nbsp;&nbsp;INC</td>
							</tr>
							<tr class="h23">
								<td><input name="cgo_clm_div_cd" type="radio" value="O"	class="trans" disabled>&nbsp;&nbsp;OTH</td>
							</tr>
						</table>
						</td>
						<td width="">
						<table class="search" border="0" style="width: ;">
							<tr class="h23">
								<td width="56">B/L No.</td>
								<td width="110"><input type="text" dataformat="engup" name="cgo_clm_ref_bl_no"  caption="B/L No."
									style="width: 100; text-align:center" maxlength="12" value="" class="input2" readonly="readonly"></td>
								<td width="80">&nbsp;</td>
								<td width="30">DOL</td>
								<td width="102"><input type="text" name="lodg_dt" dataformat="ymd" maxlength="8"
									style="width: 75;text-align:center" value="" class="input2" readonly="readonly"></td>
								<td width="57"><span title="Place of Delivery">DEL</span>/<span  title="Date of Delivery">DDL</span></td>
								<td width="170"><input type="text" name="del_cd" dataformat="engup" style="width: 50;text-align:center"
									value="" class="input2" readonly="readonly" caption="Place of Delivery" >&nbsp;/&nbsp;<input
									type="text" name="de_dt" dataformat="ymd" maxlength="8" style="ime-mode:disabled"  style="width: 75; text-align:center" value=""
									class="input2" readonly="readonly"></td>
								<td width="35">Term</td>
								<td width="70"><input type="text" name="crr_term_cd" style="width:50;text-align:center" value="" class="input2" readonly="readonly">
								</td>
								<td width="90">Surveyed Date</td>
								<td width=""><input type="text" style="width: 100%;text-align:center;" name="svey_inp_dt" dataformat="ymd" maxlength="8"
									value="" style="ime-mode:disabled" class="input2" readonly="readonly"></td>
							</tr>
						</table>
						<table class="search" border="0" style="width: ;">
							<tr class="h23">
								<td width="56">VVD</td>
								<td width="283"><input type="text" name="trnk_ref_vvd_no" maxlength="20" dataformat="engup" style="width: 80;text-align:center"
									value="" class="input2" readonly="readonly">&nbsp;<input type="text" name="vsl_eng_nm"
									style="width: 193;" value="" class="input2" readonly="readonly"></td>
								<td width="57"><input type="text" name="insur_vsl_tp_cd" style="width: 100%;"
									value="" class="input2" readonly="readonly"></td>
								<td width="125"><input type="text" name="insur_vsl_oshp_cd" style="width: 53;"
									value="" class="input2" readonly="readonly"></td>
								<td width="80">C/P & Dated</td>
								<td width=""><input type="text" name="cp_desc" style="width: 100%;"	maxlength="500" value="" class="input2" readonly="readonly"></td>

							</tr>
						</table>

						<table class="search" border="0" style="width: ;">
							<tr class="h23">
								<td width="56">Claimant</td>
								<td width="361"><input type="text" name="clmt_clm_pty_abbr_nm" maxlength="8" dataformat="engup" style="width: 80;text-align:center"
									value="" class="input2" caption="Claimant" readonly="readonly">&nbsp;<input type="text" name="clmt_clm_pty_nm" maxlength="200"
									style="width: 269;" value="" readonly="readonly" class="input2">
									<input type="hidden" name="clmt_clm_pty_no" >
								</td>
								<td width="75">
								<table width="56" border="0" cellpadding="0" cellspacing="0"
									class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2_3" name="btn1_Style" >Style</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>
								<td width="32">Type</td>
								<td width="125"><input type="text" name="clmt_clm_tp_cd" style="width: 50;text-align:center" value=""	class="input2" readonly="readonly">
								</td>
								<td width="110">Claimant Ref No.</td>
								<td width=""><input type="text" name="clmt_ref_no" style="width: 100%;"
									value="" class="input2" readonly="readonly"></td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="73" title="Notice Of Preliminary Claim">&nbsp;&nbsp;DON</td>
						<td width="122"><input type="text" name="prlm_clm_ntc_dt"
							dataformat="ymd" maxlength="8"
							style="width: 75; text-align: center; ime-mode: disabled"
							value="" class="input2" readonly="readonly"></td>
						<td width="77"><span title="Received Office">ROFC</span>/<span title="Date of Formal Claim">DOF</span></td>
						<td width="308"><input type="text" name="fmal_clm_rcv_ofc_cd" style="width: 59;text-align:center" dataformat="engup"
							value="" class="input2" readonly="readonly">&nbsp;/&nbsp;<input type="text" name="fmal_clm_rcv_dt" dataformat="ymd" maxlength="8"
							style="width: 80;text-align:center" value="" class="input2" readonly="readonly"></td>
						<td width="52">Insurer</td>
						<td width="135"><input type="text" name="insur_clm_pty_abbr_nm" style="width: 80;text-align:center" maxlength="10" dataformat="engup"
							value="" maxlength="10" class="input2" readonly="readonly" caption="Insurer">
							<input type="hidden" name="insur_clm_pty_no" value="">
						</td>
						<td width="100">Insurer Ref No.</td>
						<td width=""><input type="text" name="insur_ref_no" style="width: 100%;text-align:center" maxlength="20" value="" class="input2" readonly="readonly"></td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="73" title="Type of Cargo Claim">&nbsp;&nbsp;TOC</td>
						<td width="87"><input type="text" name="cgo_clm_tp_cd" style="width: 60;text-align:center" dataformat="engup"
							value="" maxlength="3" class="input2" readonly="readonly" caption="TOC">&nbsp;</td>
						<td width="50" title="Cause of Damage / Loss">CODL</td>
						<td width="85"><input type="text" name="mjr_clm_dmg_lss_cd" style="width: 50;text-align:center" dataformat="engup"
							value="" maxlength="2" class="input2" readonly="readonly">&nbsp;</td>
						<td width="105" title="No 3rd Liable Party">3rd Liable Party</td>
						<td width="84"><input type="text" name="n3rd_labl_pty_cd" style="width: 50;text-align:center" dataformat="engup"
							value="" maxlength="3" class="input2" readonly="readonly">&nbsp;</td>
						<td width="25" title="Place of Incident">POI</td>
						<td width="60"><input type="text" name="inci_plc_tp_cd" style="width: 35;text-align:center" dataformat="engup"
							value="" maxlength="3" class="input2" readonly="readonly">&nbsp;</td>
						<td width="25" title="Date of Incident">DOI</td>
						<td width="90"><input type="text" name="inci_occr_dt"
							dataformat="ymd" maxlength="8" type="text"
							style="width: 75; text-align: center; ime-mode: disabled"
							value="" class="input2" readonly="readonly"></td>
						<td width="40">Cargo</td>
						<td width=""><input type="text" name="clm_cgo_tp_cd" style="width: 34;text-align:center" dataformat="engup"
							value="" class="input2" readonly="readonly" caption="Cargo">&nbsp;<input type="text" name="cgo_qlty_desc"
							style="width: 212;" value="" class="input2" readonly="readonly" caption="Cargo Description"></td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="73">&nbsp;&nbsp;Lane</td>
						<td width="127"><input type="text" name="slan_cd" style="width: 60;text-align:center" dataformat="engup"
							value="" maxlength="3" class="input2" readonly="readonly" caption="Lane"></td>
						<td width="100">Claim Amount</td>
						<td width="249"><input type="text" name="clmt_locl_amt" dataformat="float"
							style="width: 165; text-align: right" value=""
							class="input2" readonly="readonly">&nbsp;<input type="text" name="clmt_locl_curr_cd"  dataformat="engup" maxlength="3" style="width: 35; text-align:center"
							value="" class="input2" readonly="readonly">&nbsp;</td>
						<td width="40">R.O.E</td>
						<td width="" class="stm"><input type="text" name="clmt_locl_xch_rt" dataformat="float"
							style="width: 60; text-align: right" value=""
							class="input2" readonly="readonly">&nbsp;<input type="text" name="clmt_usd_amt" dataformat="float"
							style="width: 142; text-align: right" value=""
							class="input2" readonly="readonly">&nbsp;USD</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>

		</div>
		<div id="tabLayer1" style="display: none">
		<table class="search">
			<tr>
				<td class="bg">
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="75">CNTR No.</td>
						<td width="466"><input type="text" name="cgo_clm_ref_cntr_no" style="width: 387;"
							value="" class="input2" readonly="readonly"></td>
						<td width="65">O.FRT</td>
						<td width="150"><input type="text" name="clm_ofrt_amt" dataformat="float"
							style="width: 140; text-align: right" value="" readonly="readonly"
							class="input2"></td>
						<td width="">USD / &nbsp;<input type="text" name="clm_ofrt_term_cd"
							style="width: 50;text-align:center" value="" class="input2" readonly="readonly">&nbsp;<input 
							type="text" name="clm_ofrt_flg" style="width: 26;text-align:center" value="" class="input2" readonly="readonly"></td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="75">POR/DOR</td>
						<td width="182"><input type="text" name="por_cd" style="width: 45;"
							value="" class="input2" readonly="readonly" >&nbsp;/&nbsp;<input
							type="text" name="rct_dt"  dataformat="ymd" style="width:80; text-align: center" value="" class="input2" readonly="readonly"></td>
						<td width="63">POL/DOL</td>
						<td width="221"><input type="text" name="pol_cd" style="width: 46;"
							value="" class="input2" readonly="readonly">&nbsp;/&nbsp;<input 
							type="text" name="lodg_dt" dataformat="ymd" style="width: 75; text-align:center" value="" class="input2" readonly="readonly"></td>
						<td width="65">POD/DOD</td>
						<td width="170"><input type="text" name="pod_cd" style="width: 45;text-align:center"
							value="" class="input2" readonly="readonly">&nbsp;/&nbsp;<input
							type="text" name="dchg_dt" dataformat="ymd" style="width: 80;text-align: center" value="" class="input2" readonly="readonly"></td>
						<td width="" align="right">DEL/DDL&nbsp;<input type="text" name="del_cd"
							style="width: 45;text-align:center" value="" class="input2" readonly="readonly">&nbsp;&nbsp;/&nbsp;<input
							type="text" name="de_dt" dataformat="ymd" style="width: 80;text-align: center" value="" class="input2" readonly="readonly"></td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="75">Pre-VVD 1</td>
						<td width="90"><input type="text" style="width:80;" name="n1st_pre_ref_vvd_no"
							value="" class="input2" readonly="readonly"></td>
						<td width="15">2</td>
						<td width="90"><input type="text" style="width: 80;" name="n2nd_pre_ref_vvd_no"
							value="" class="input2" readOnly="readOnly"></td>
						<td width="15">3</td>
						<td width="256"><input type="text" style="width: 80;"  name="n3rd_pre_ref_vvd_no"
							value="" class="input2" readonly="readonly"></td>
						<td width="65">On-VVD 1</td>
						<td width="90"><input type="text" name="n1st_pst_ref_vvd_no" style="width: 80;"
							value="" class="input2" readonly="readonly"></td>
						<td width="15">2</td>
						<td width="90"><input type="text" name="n2nd_pst_ref_vvd_no" style="width: 80;"
							value="" class="input2" readonly="readonly"></td>
						<td width="">3&nbsp;<input type="text"  name="n3rd_pst_ref_vvd_no" style="width: 80;"
							value="" class="input2" readonly="readonly"></td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="75">Pre-POT 1</td>
						<td width="182"><input type="text" name="n1st_pre_ts_loc_cd" style="width: 45;" 
							value="" class="input2" readonly="readonly">&nbsp;/&nbsp;<input
							type="text" name="n1st_pre_ts_dt" dataformat="ymd" style="width: 80;text-align:center" value="" class="input2" readonly="readonly"></td>
						<td width="63">Pre-POT 2</td>
						<td width="221"><input type="text" name="n2nd_pre_ts_loc_cd" style="width:46;"
							value="" class="input2" readonly="readonly">&nbsp;/&nbsp;<input
							type="text" name="n2nd_pre_ts_dt" style="width: 80;text-align:center" value="" class="input2" readonly="readonly"></td>
						<td width="65">On-POT1</td>
						<td width="170"><input type="text" name="n1st_pst_ts_loc_cd" style="width: 45;"
							value="" class="input2" readonly="readonly">&nbsp;/&nbsp;<input 
							type="text" name="n1st_pst_ts_dt" dataformat="ymd" style="width: 80;text-align:center" value="" class="input2" readonly="readonly"></td>
						<td width="" align="right">On-POT2&nbsp;<input type="text" name="n2nd_pst_ts_loc_cd"
							style="width: 45;" value="" class="input2" readonly="readonly">&nbsp;&nbsp;/&nbsp;<input
							type="text" name="n2nd_pst_ts_dt" dataformat="ymd" style="width: 80;text-align:center" value="" class="input2" readonly="readonly"></td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="75">Surveyor</td>
						<td width="">
							<input type="hidden" name="svey_clm_pty_no" value="">
							<input type="text" style="width: 387;" name="svey_clm_pty_abbr_nm" value="" class="input2" readonly="readonly">&nbsp;<input type="text"
							name="svyr_tp_cd" style="width: 25;" value="" class="input2" readonly="readonly">
						</td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="75">Liable Party</td>
						<td width="467"><input type="hidden" name="labl_clm_pty_no" value="">
							<input type="text" name="labl_clm_pty_abbr_nm" style="width: 387;"
							value="" class="input2" readonly="readonly"></td>
						<td width="65">LP DOF</td>
						<td width=""><input type="text" name="labl_pty_fmal_clm_dt" dataformat="ymd" style="width: 80; text-align:center"
							value="" class="input2" readonly="readonly">&nbsp;<input
							type="text" name="labl_pty_dmnd_usd_amt" dataformat="float" caption="LP DOF" style="width: 140;text-align:right" value=""
							class="input2" readonly="readonly">&nbsp;USD</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		</div>
		<div id="tabLayer1" style="display: none">
		<table class="search">
			<tr>
				<td class="bg">
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="100">Plaintiff</td>
						<td width="716"><input type="text" name="plt_nm" style="width: 587;" value="" class="input2" readonly="readonly"></td>
						<td width="" align="right">LT Updated&nbsp;<input type="text" name="ligt_upd_dt" dataformat="ymd" 
							style="width:80;text-align:center" value="" class="input2" readOnly="readonly"></td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="100">Defendant</td>
						<td width="666"><input type="text" name="deft_nm" style="width: 587;"
							value="" class="input2" readonly="readonly"></td>
						<td width="" align="right">LT Updater&nbsp;<input type="text" name="ligt_upd_usr_id"
							style="width: 80; text-align:center" value="" class="input2" readonly="readonly"></td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="102">Def. Attorney</td>
						<td width="595"><input type="hidden" name="deft_atty_clm_pty_no" value="" >
						<input type="text" name="deft_atty_clm_pty_abbr_nm" style="width: 80;text-align:center" value="" class="input2" readonly="readonly">&nbsp;
						<input type="text" name ="deft_atty_clm_pty_nm"
							style="width: 499;"
							value=""
							class="input2" readonly="readonly"></td>
						<td width="100">
						<table width="70" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn2_left"></td>
								<td class="btn2_3" name="btn3_Style" >Style</td>
								<td class="btn2_right"></td>
							</tr>
						</table>
						</td>
						<td width="" align="right">&nbsp;</td>

					</tr>
				</table>
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="100">Appointed Date</td>
						<td width="282"><input name="deft_atty_apnt_dt" type="text" dataformat="ymd" maxlength="8"
							style="width: 80; text-align:center" value="" class="input2" readonly="readonly"></td>
						<td width="153">Def. Attorney's Ref No.</td>
						<td width=""><input type="text" name="ref_deft_atty_no" style="width: 152;"	value="" class="input2" readonly="readonly"></td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="100">Court</td>
						<td width="282"><input type="text" name="crt_nm" style="width: 230;"
							value="" class="input2" readonly="readonly"></td>
						<td width="153">Case No.</td>
						<td width="180"><input type="text" name="crt_cs_no" style="width: 152;"
							value="" class="input2" readonly="readonly"></td>
						<td>Filed Date&nbsp;<input name="cpln_file_dt" type="text" dataformat="ymd" maxlength="8"
							style="width: 80;text-align:center" value="" class="input2" readonly="readonly"></td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="140">Final Judgment / Date</td>
						<td width=""><input type="text" name="jmt_rslt_nm" style="width: 120;" value=""	class="input2" readonly="readonly">&nbsp;/
						&nbsp;<input name="jmt_rslt_dt" type="text" dataformat="ymd" maxlength="8"
							style="width: 77;text-align:center" value="" class="input2" readonly="readonly"></td>
					</tr>
				</table>


				</td>
			</tr>
		</table>

		</div>

		<table class="height_8">
			<tr>
				<td></td>
			</tr>
		</table>
		<!-- Tab (S) -->
		<table class="tab" border="0" cellpadding="0" cellspacing="0"
			width="100%">
			<tr>
				<td width="100%"><script language="javascript">ComTabObject('tab2')</script>
				</td>
			</tr>
		</table>
		<!-- Tab (E) --> <!-- Tab1 (S) -->
		<div id="tabLayer2" style="display: inline">
		<table class="search">
			<tr>
				<td class="bg">
				<table class="search" border="0" style="width: 100%;">
					<tr class="h23">
						<td><textarea name="clm_cuz_desc" style="width: 100%" rows="8" class="textarea2"  caption="Cause of Claim" readonly="readonly"></textarea></td>
					</tr>
				</table>


				</td>
			</tr>
		</table>
		<!--biz page (E)--></div>
		<!-- Tab1 (E) --> <!-- Tab2 (S) -->
		<div id="tabLayer2" style="display: none">
		<table class="search">
			<tr>
				<td class="bg">
				<table class="search" border="0" style="width: 100%;">
					<tr class="h23">
					    <td><textarea style="width: 100%" rows="8" class="textarea2" name="fact_fnd_desc"  caption="Fact Findings & Assessment" readonly="readonly"></textarea></td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		</div>
		<!-- Tab1 (E) --> <!-- Tab2 (S) -->
		<div id="tabLayer2" style="display: none">
		<table class="search">
			<tr>
				<td class="bg">
				<table class="search" border="0" style="width: 100%;">
					<tr class="h23">
						<td><textarea style="width: 100%" rows="8" class="textarea2"  caption="Main Issue Review & DV"
							name="clm_rvw_desc"  readonly="readonly"></textarea></td>
					</tr>
				</table>


				</td>
			</tr>
		</table>
		</div>
		</div>
		<!-- Tab2 (S) -->
		<div id="tabLayer2" style="display: none">
		<table class="search">
			<tr>
				<td class="bg">
				<table class="search" border="0" style="width: 100%;">
					<tr class="h23">
						<td width="110">Claimant's Agent</td>
						<td width="325">
							<input type="hidden" name="clm_agn_clm_pty_no" value="">
							<input type="text" name="clm_agn_clm_pty_abbr_nm" style="width: 60;" dataformat="engup"
							value="" class="input2" readonly="readonly">&nbsp;<input type="text" name="clm_agn_clm_pty_nm"
							style="width: 249;" value=""
							class="input2" readonly="readonly"></td>
						<td width="130">
						<table width="70" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn2_left"></td>
								<td class="btn2_3" name="btn4_Style" >Style</td>
								<td class="btn2_right"></td>
							</tr>
						</table>
						</td>
						<td width="40">Type</td>
						<td width="150"><input type="text" name="clmt_agn_tp_cd" style="width: 50;" value=""	class="input2" readonly="readonly">
						</td> 
						<td width="120">CA Appointed Date</td>
						<td width=""><input type="text" name="clmt_agn_apnt_dt" dataformat="ymd" maxlength="8" style="width: 80px;text-align:center"
							value="" class="input2" readonly="readonly"></td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 100%;">
					<tr class="h23">
						<td width="25">Tel.</td>
						<td width="210"><input type="text" name="clm_agn_intl_phn_no" style="width: 35;"
							value="" class="input2" readonly="readonly">&nbsp;<input type="text" name="clm_agn_phn_no" style="width: 160;"
							value="" class="input2" readonly="readonly"></td>
						<td width="40">E-Mail</td>
						<td width="290"><input type="text" name="clm_agn_pty_eml" style="width: 236;"
							value="" class="input2" readonly="readonly"></td>
						<td width="160">Claimant's Agent Ref No.</td>
						<td width=""><input type="text" name="clmt_agn_ref_no" style="width: 100%;"
							value="" class="input2" readonly="readonly"></td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		</div>
		<!-- Tab2 (S) -->
		<div id="tabLayer2" style="display: none">
		<table class="search">
			<tr>
				<td class="bg">
				<table class="search" border="0" style="width: 100%;">
					<tr class="h23">
						<td width="110">Insurer's Agent</td>
						<td width="325"><input type="hidden" name="insur_agn_clm_pty_no" value="">
						    <input type="text"  name="insur_agn_clm_pty_abbr_nm" style="width: 60;" dataformat="engup"
							value="" class="input2" readonly="readonly">&nbsp;<input type="text" name="insur_agn_clm_pty_nm"
							style="width: 249;" value=""
							class="input2" readonly="readonly"></td>
						<td width="130">
						<table width="70" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn2_left"></td>
								<td class="btn2_3" name="btn5_Style" >Style</td>
								<td class="btn2_right"></td>
							</tr>
						</table>
						</td>
						<td width="40">Type</td>
						<td width="150"><input type="text" name="agn_crspn_tp_cd" style="width: 50;" value=""	class="input2" readonly="readonly">
						</td>
						<td width="120">IA Appointed Date</td>
						<td width=""><input type="text" name="agn_crspn_apnt_dt" dataformat="ymd"  maxlength="8" style="width:80px;text-align:center"
							value="" class="input2" readonly="readonly"></td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 100%;">
					<tr class="h23">
						<td width="25">Tel.</td>
						<td width="210"><input type="text" name="insur_agn_intl_phn_no" style="width: 35;"
							value="" class="input2" readonly="readonly">&nbsp;<input type="text" name="insur_agn_phn_no" style="width: 160;"
							value="" class="input2" readonly="readonly"></td>
						<td width="40">E-Mail</td>
						<td width="290"><input type="text" name="insur_agn_pty_eml" style="width: 236;"
							value="" class="input2" readonly="readonly"></td>
						<td width="160">Insurer's Agent Ref No.</td>
						<td width=""><input type="text" name="agn_crspn_ref_no" style="width: 100%;"
							value="" class="input2" readonly="readonly"></td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		</div>
		<!-- Tab2 (S) -->
		<div id="tabLayer2" style="display: none">
		<table class="search">
			<tr>
				<td class="bg">
				<table class="search" border="0" style="width: 100%;">
					<tr class="h23">
						<td><textarea name="ltgt_cs_desc" style="width: 100%"  caption="Case Summary & DV" rows="9" class="textarea2" readonly="readonly"></textarea></td>
					</tr>
				</table>


				</td>
			</tr>
		</table>
		</div>
		</div>
		<!--Button (S) --> <!--Button (E) --> <!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0"
			cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
			<tr>
				<td class="btn1_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn1_Retrieve">Retrieve</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn1_Reopen">Reopen</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn1_New">New</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td class="btn1_line"></td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1_2" name="btn1_Payment" >Payment</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1_2" name="btn1_Handling_Costs" >Handling&nbsp;Costs</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		<!--Button (E) --></td>
	</tr>
</table>
</form>
<div style="display: none;"><script language="javascript">ComSheetObject('sheet1');</script></div>
	</body>
</html>
