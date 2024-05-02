﻿<%/*=========================================================
     *Copyright(c) 2009 CyberLogitec
     *@FileName : cps_cni_0018.jsp
     *@FileTitle : [CPS_CNI_0018] Status
     *Open Issues :
     *Change history :
     *@LastModifyDate : 2011.05.20
     *@LastModifier : 표준희
     *@LastVersion : 1.0
     * 2009.11.05 표준희
     * 1.0 Creation
     *----------------------------------------------------------
     * History
     * 2010.05.20 [CHM-201110840-01] 표준희
     * 제목 :CNI Status 화면-조회 옵션 보완
     * 내용 : Area 조회 옵션의 Dropdown 
     * Dropdown에 체크 박스를 두어 멀티 선택이 가능하도록 한다
     * Multi 선택 시, 선택 표시 창에 약자를 (,)를 두어 모두 표시한다
     * ex) America, Europe 선택 시 -> A, E
 =========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@page import="com.hanjin.framework.component.util.io.HttpUtil"%>
<%@ page import="com.hanjin.apps.alps.cps.cni.common.CniUtil"%>
<%
    Exception serverException = null;
    String strErrMsg = "";

    String pageRows = "100";

    String userId = "";
    String userName = "";
    String userOffice = "";
    String userArea = "";
    
    String roles = "";
    String area = "";
    
    Logger log = Logger.getLogger("com.hanjin.apps.alps.cps.cni.containercargoclaimreport.ContainerCargoClaimReportSC");
    
    String xml = HttpUtil.makeXML(request,response);   

    try
    {
        SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        userId = account.getUsr_id();
        userName = account.getUsr_nm();
        userOffice = account.getOfc_cd();
  
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
%>
<html>
<head>
<title>Status</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
</head>
<script language="javascript">
	 
    function setupPage(){ 
    	var errMessage = "<%=strErrMsg.replace("\"","'")%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
      
	    loadPage();
    }
</script>
<body  onLoad="setupPage();"> 

<form name="form2">
<input type="hidden" name="sXml" value="<%=xml.replace("\"","'")%>">
</form>
<form name="form">
<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdArguments">
<input type="hidden" name="com_mrdTitle">
<input type="hidden" name="com_mrdBodyTitle">

<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows" value="100">
<input type="hidden" name="page_no" value="1">
<input type="hidden" name="usr_area" value="">
<input type="hidden" name="ofc_cd" value="<%=userOffice%>"/>
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
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
				<td width="130">
					<table width="125" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
							<td class="btn2_3" name="btn1_Inquiry by Class" >Inquiry by Class</td>
							<td class="btn2_right"></td>
						</tr>
					</table>
				</td>
				<td width="140"><input type="text" name="report_title"  class="input2" readonly="readonly" value="ByArea"><input type="hidden" name="report_id" ></td>
				<td width="35">Period</td>
				<td width="360">&nbsp;<script language="javascript">ComComboObject("period", 2, 80, 1);</script>&nbsp;
				<input type="text" value="" name="from_period" class="input1" style="width:75;ime-mode:disabled;text-align:center" required maxlength="8" dataformat="ymd" fullfill caption="Period(From Date)">&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="btns_from_period" width="19" height="20" border="0" align="absmiddle">&nbsp;~&nbsp;
				<input type="text" value="" name="to_period" style="width:75;ime-mode:disabled;text-align:center"  class="input1" required maxlength="8" dataformat="ymd" fullfill caption="Period(To Date)">&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="btns_to_period" width="19" height="20" border="0" align="absmiddle"></td>
				<td width="30">Area</td>
				<td width="100"><script language="javascript">ComComboObject("area", 2, 80, 1);</script></td>
				<td width="30">Status</td>
				<td width="100">&nbsp;<script language="javascript">ComComboObject("status", 2, 57, 1);</script></td>
				<td width="30">Class</td>
				<td width=""><select style="width:57;" name="vt" class="input1">
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
					<td width="70"><input type="text" name="hdlr_ofc_cd" style="width:60;text-align:center" dataformat="engup" value="" class="input"></td>
					<td width="58">Handler</td>
					<td width="95"><input type="text" name="hdlr_usr_id" style="width:60;text-align:center" value="" class="input">&nbsp;<img class="cursor" name="btn1_Handler" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="77">Manager</td>
					<td width="95"><input type="text" name="mgr_usr_id"  style="width:65;" value="" class="input"></td>
					<td width="60">LP HOFC</td>
					<td width="110"><input type="text" style="width:80;text-align:left;" name="hndl_ofc_cd" dataformat="engup" value="" class="input" caption="LP HOFC">&nbsp;<img src="img/btns_search.gif" name="btns_hndl_ofc_cd" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
					</td>
					<td width="74">Liable Party<input type="hidden" name="labl_clm_pty_no" ></td>
					<td width="110"><input type="text" name="clm_liable_pty_abbr_nm" style="width:70;" value="" class="input" readonly="readonly">&nbsp;<img class="cursor" name="btn1_Liable_Party" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="50">Surveyor<input type="hidden" name="svey_clm_pty_no"></td>
					<td width=""><input type="text" name="clm_surveyor_pty_abbr_nm" style="width:70;" value="" class="input" readonly="readonly">&nbsp;<img class="cursor" name="btn1_Surveyor"  src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
				</tr>
				<tr class="h23">
					<td width="" title="Receiving Office">ROFC</td>
					<td width=""><input type="text" name="fmal_clm_rcv_ofc_cd" style="width:60;" dataformat="engup" value="" class="input"></td>
					<td width="">Claimant<input type="hidden" name="clmt_clm_pty_no"></td>
					<td width=""><input type="text" name="clmt_clm_pty_abbr_nm" style="width:60;" value="" class="input" readonly="readonly">&nbsp;<img class="cursor" name="btn1_Claimant" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="">Claimant's Agent<input type="hidden" name="clmt_clm_agn_pty_no"></td>
					<td width=""><input type="text" name="clmt_clm_agn_pty_abbr_nm"  style="width:65;" value="" class="input" readonly="readonly" >&nbsp;<img class="cursor" name="btn1_Claimant_Agent" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="">Salvager<input type="hidden" name="slv_clm_pty_no"></td>
					<td width=""><input type="text" name="slv_clm_pty_abbr_nm" style="width:80;" value="" class="input" readonly="readonly">&nbsp;<img class="cursor" name="btn1_Salvager" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="">Insurer<input type="hidden" name="insur_clm_pty_no"></td>
					<td width=""><input type="text" name="insur_clm_pty_abbr_nm" style="width:70;" value="" class="input" readonly="readonly">&nbsp;<img class="cursor" name="btn1_Insurer" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="">Approver</td>
					<td width=""><input type="text" name="clm_stl_auth_usr_id" style="width:70;" value="" class="input">&nbsp;<img class="cursor" name="btn1_Approver" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
				</tr>
			</table> 
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="36" title="Vessel Voyage Direction">VVD</td>
					<td width="115"><input type="text" name="trnk_ref_vvd_no" dataformat="engup" style="width:100;" value="" class="input"></td>
					<td width="28" title="Place of Receipt">POR</td>
					<td width="95"><input type="text" name="por_cd" style="width:60;" dataformat="engup" value="" class="input">&nbsp;<img class="cursor" name="btn1_POR" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="28" title="Port of Loading">POL</td>
					<td width="62"><input type="text" name="pol_cd" style="width:50;" dataformat="engup" value="" class="input"></td>
					<td width="28" title="Port of Discharge">POD</td>
					<td width="64"><input type="text" name="pod_cd" style="width:53;" dataformat="engup" value="" class="input"></td>
					<td width="38" title="Place of Delivery">DEL</td>
					<td width="100"><input type="text" name="del_cd" style="width:50;" dataformat="engup" value="" class="input">&nbsp;<img class="cursor" name="btn1_DEL" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="37" title="Feeder Voyage Direction">FVD</td>
					<td width="90"><input type="text" name="fvd" style="width:76;" dataformat="engup" value="" class="input"></td>
					<td width="60" title="Pre-Carriage Port of Transhipment">PRE-POT</td>
					<td width="70"><input type="text" name="n1st_pre_ts_loc_cd" style="width:50;" dataformat="engup" value="" class="input"></td>
					<td width="50" title="On-Carriage Port of Transhipment">ON-POT</td>
					<td><input type="text"  name="n1st_pst_ts_loc_cd" style="width:100%;" dataformat="engup" value="" class="input"></td>
				</tr>
			</table>
			<table class="search" border="0" style="width:979;"> 	
				<tr class="h23">
					<td width="36" title="Carriage Term">CT</td>
					<td width="60" style="padding-left:2px"><script language="javascript">ComComboObject("crr_term_cd", 2, 45, 1);</script></td>
					<td width="26" title="Place of Incident">POI</td>
					<td width="70"><script language="javascript">ComComboObject("inci_plc_tp_cd", 2, 60, 1);</script></td>
					<td width="26">Lane</td>
					<td width="60"><input type="text" name="slan_cd" style="width:50;" value="" class="input"></td>
					<td width="28">Cargo</td>
					<td width=""><input type="text" name="clm_cgo_tp_cd" style="width:30;"  value="" class="input">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btn1_Cargo" width="19" height="20" border="0" align="absmiddle">&nbsp;<input type="text" name="clm_cgo_tp_nm" style="width:160;"  value="" class="input2" readonly="readonly"></td>
					<td width="28" title="Type of Claim">TOC</td>
					<td width=""><script language="javascript">ComComboObject("cgo_clm_tp_cd", 2, 60, 1);</script></td>
					<td width="" title="Cause of Damage / Loss">CODL</td>
					<td width=""><input type="text" name="mjr_clm_dmg_lss_cd" style="width:52;" value="" class="input">&nbsp;<img class="cursor" name="btn1_CODL1" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="" title="No 3rd Liable Party">3rd LP</td>
					<td width=""><input type="text" name="n3rd_labl_pty_cd" style="width:50;" value="" class="input">&nbsp;<img class="cursor" name="btn1_CODL2" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
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
					<td width="35" title="Type Of Settlement">TOS</td>
					<td width="76">&nbsp;<script language="javascript">ComComboObject("cgo_clm_stl_tp_cd", 2, 60, 1);</script></td>
					<td width="92">Claim Amount</td>
					<td width="251"><input type="text" name="from_clmt_usd_amt" style="width:110;text-align:right" value="" dataformat="float" class="input">&nbsp;~&nbsp;<input type="text" name="to_clmt_usd_amt" style="width:104;text-align:right" dataformat="float" value="" class="input"></td>
					<td width="100">Settled Amount</td>
					<td width="255"><input type="text" name="from_cgo_clm_stl_usd_amt" style="width:110;text-align:right" value="" dataformat="float" class="input">&nbsp;~&nbsp;<input type="text" name="to_cgo_clm_stl_usd_amt" style="width:110;text-align:right" dataformat="float" value="" class="input"></td>
					<td width="50">INC No.</td>
					<td><input type="text" name="cgo_clm_inci_no" style="width:100%;" value="" class="input"></td>
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
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
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
					<td class="btn1" name="btn1_DownExcel">Down Excel</td>
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
	
	</td></tr>
		</table>
	
</body>
</html>
