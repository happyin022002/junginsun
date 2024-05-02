<%/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : cps_cni_0014.jsp
 *@FileTitle : [CPS_CNI_0014] Settlement Claim
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.11.24
 *@LastModifier : 박제성
 *@LastVersion : 1.0
 * 2009.11.24 박제성
 * 1.0 Creation
 * ---------------------------------------------------------
 * History
 * 2010.10.11 이준범[CHM-201006346-01] CNI UI 변경 요청
 * 1. UI_CNI_0014 : Settlement 
 *   1) Approval Status 및 Approval No. 의 위치 변경
 *   2) Approval No.의 Reading 자릿수 50자리로 늘림
 *      (GW 상의 Approval No (50자리)와의 일치 목적) 
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@page import="com.hanjin.apps.alps.cps.cni.containercargoclaim.settlementclaim.event.CpsCni0014Event"%>
<%@page import="com.hanjin.apps.alps.cps.cni.common.CniUtil"%>
<%@page import="com.hanjin.framework.component.util.io.HttpUtil"%>
<%
	CpsCni0014Event event = null;
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
    String xml = HttpUtil.makeXML(request,response);
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

        event = (CpsCni0014Event) request.getAttribute("Event");
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
<form name="form2">
<input type="hidden" name="sXml" value="<%=xml%>">
</form>
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="cgo_clm_stl_tp_cd">
<input type="hidden" name="insur_rcvr_usd_amt">

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
				<td width="135"><input type="text" style="width:80;;text-align:center" name="cgo_clm_no" value="<%=userCgoClmNo%>" required maxlength="10" caption="Claim  No" onKeyPress="ComKeyOnlyAlphabet('uppernum')" class="input1">&nbsp;<input type="text" style="width:20;" name="clm_area_cd" value="" class="input2" readonly></td>
				<td width="35" title="Handling Office">HOFC</td>
				<td width="70"><input type="text" style="width:50;;text-align:center" name="hdlr_ofc_cd" value="" class="input2"  readonly></td>
				<td width="50">Handler</td>
				<td width="105"><input type="text" style="width:75;;text-align:center" name="hdlr_usr_id" value="" class="input2"  readonly>&nbsp;<img class="cursor" src="img/btns_search.gif" name="btn1_Handler" width="19" height="20" border="0" align="absmiddle"></td>
				<td width="35" title="Date Of Updated">DOU</td>
				<td width="100"><input type="text" style="width:76;;text-align:center" name="upd_dt" value="" class="input2"  readonly></td>
				<td width="75">Incident No.</td>
				<td width="110"><input type="text" style="width:95;;text-align:center" name="cgo_clm_inci_no" value="" class="input2"  readonly></td>
				<td width="50">VOC No.</td>
				<td width=""><input type="text" style="width:100%;;text-align:center" name="crm_voc_no" value="" class="input2"  readonly></td>
				</tr>
			</table>
			<table class="search" border="0" style="width:979;">
			<tr class="h23">
				<td width="67">Status</td>
				<td width="100"><input type="text" style="width:90;;text-align:center" name="clm_misc_nm" value="" class="input2"  readonly><input type="hidden" name="clm_misc_cd" value=""></td>
				<td width="65"><span title="Handling Period">HPC</span>/<span title="Net Handling Period">NHP</span></td>
				<td width="120"><input type="text" style="width:40;;text-align:center" name="hpc" value="" class="input2"  readonly>&nbsp;&nbsp;/&nbsp;&nbsp;<input type="text" style="width:40;text-align:center" name="nhp" value="" class="input2"  readonly></td>
				 
				<td width="40" title="Time Barred Date" >DOTB</td>
				<td width="90"><input type="text" style="width:80;text-align:center" name="clm_tm_bar_dt" value="" class="input2" readonly></td>
				<td width="60" title="LP Time Barred Date" >LP DOTB</td>
				<td width="90"><input type="text" style="width:80;text-align:center" name="tm_bar_dt" value="" class="input2" readonly></td>
				<td width="160">Summons Served Date</td>
				<td width=""><input type="text" style="width:100%;;text-align:center" name="smns_sve_dt" value="" class="input2" readonly></td>
				</tr>
			</table>
			
			<table class="line_bluedot"><tr><td></td></tr></table>
			
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="67">Claimant</td>
				<input type="hidden" name="clm_pty_no">
				<input type="hidden" name="clm_pty_abbr_nm">
				<td width="227"><input type="text" style="width:220;" name=pty_nm value="" class="input2" readonly></td>
				<td width="150"><table width="60" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btns_style" style="color:#cc3300">Style</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				<td width="35">Type</td>
				<td width="" colspan="9"><input type="text" style="width:35;text-align:center" name="" value="" class="input2" readonly></td>
			</tr></table> 
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="0"></td>
				<td width="65">Cargo</td>
				<td width="247"><input type="text" style="width:220;;text-align:left" name="cgo_qlty_desc" value="" class="input2" readonly></td>
				<input type="hidden" name="clm_cgo_tp_cd">
				<td width="35" title="Type of Cargo Claim">TOC</td>
				<td width="80"><input type="text" style="width:35;text-align:center" name="cgo_clm_tp_cd" value="" class="input2" readonly></td>
				<td width="37" title="Cause of Damage / Loss">CODL</td>
				<td width="80"><input type="text" style="width:35;text-align:center" name="mjr_clm_dmg_lss_cd" value="" class="input2" readonly></td>
				<td width="100" title="No 3rd Liable Party">3rd Liable Party</td>
				<td width="75"><input type="text" style="width:35;text-align:center" name="n3rd_labl_pty_cd" value="" class="input2" readonly></td>
				<td width="25" title="Place of Incident">POI</td>
				<td width="70"><input type="text" style="width:45;text-align:center" name="inci_plc_tp_cd" value="" class="input2" readonly></td>
				<td width=35 title="Date of Incident">DOI</td>
				<td width="100"><input type="text" style="width:90;text-align:center" name="inci_occr_dt" value="" class="input2" readonly></td>
			</tr>
			</table> 
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="68" title="Type Of Settlement" >TOS</td>
				<td width="80">
				<script language="javascript">ComComboObject("combo1", 2, 60, 1);</script>
				</td>
				<td width="50" title="Date Of Settlement">DOS</td>
				<td width="120">				
				<input type="text" style="width:80;text-align:center" name="cgo_clm_stl_dt" dataformat="ymd" maxlength="8" value="" class="input1" required caption="DOS">
				<img src="img/btns_calendar.gif" name="btns_cgo_clm_stl_dt" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				</td>
				<td width="120">Settled Amount</td>
				<td width="220"><input type="text" style="width:130;text-align:right" name="cgo_clm_stl_locl_amt" value="" class="input1" required caption="Settled Amount">
				 					
					<input type="text" style="width:40;text-align:center" name="cgo_clm_stl_locl_curr_cd" value="" class="input1" maxlength="3" minlength="3" onBlur="javascript:setCurrRt()">
					<img src="img/btns_search.gif" name="btns_currency" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
				</td>
				<td width="40" title="Rate of Exchange">R.O.E</td>
				<td width="" class="stm">						
						<input type="text" style="width:66;text-align:right" name="cgo_clm_stl_xch_rt" value="" class="input1" required caption=" R.O.E">
						<img src="img/btns_search.gif" name="btns_roe" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
						<input type="text" style="width:130;text-align:right" name="cgo_clm_stl_usd_amt" value="" class="input2" readonly>&nbsp;&nbsp;USD</td>
			</tr>
			<tr class="h23">
				<td width="" colspan="2"></td>
				<td width="" title="Date of Formal Claim">DOF</td>
				<td width=""><input type="text" style="width:79;text-align:center" name="fmal_clm_rcv_dt" value="" class="input2" readonly></td>
				<td width="">Claim Amount</td>
				<td width=""><input type="text" style="width:130;text-align:right" name="clmt_locl_amt" value="" class="input2" readonly>&nbsp;<input type="text" style="width:40;text-align:center" name="clmt_locl_curr_cd" value="" class="input2" readonly></td>
				<td width="">R.O.E</td>
				<td width="" class="stm"><input type="text" style="width:66;text-align:right" name="clmt_locl_xch_rt" value="" class="input2" readonly>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" style="width:130;text-align:right" name="clmt_usd_amt" value="" class="input2" readonly>&nbsp;&nbsp;USD</td>
			</tr>
			<tr class="h23">
				<td width="" colspan="2"></td>
				<td width="" title="LP Date of Formal Claim">LP DOF</td>
				<td width=""><input type="text" style="width:79;text-align:center" name="labl_pty_fmal_clm_dt" value="" class="input2" readonly></td>
				<td width="">LP Claim Amount</td>
				<td width=""><input type="text" style="width:130;text-align:right" name="labl_pty_dmnd_amt" value="" class="input2" readonly>&nbsp;<input type="text" style="width:40;text-align:center" name="labl_pty_dmnd_curr_cd" value="" class="input2" readonly></td>
				<td width="">R.O.E</td>
				<td width="" class="stm"><input type="text" style="width:66;text-align:right" name="labl_pty_xch_rt" value="" class="input2" readonly>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" style="width:130;text-align:right" name="labl_pty_dmnd_usd_amt" value="" class="input2" readonly>&nbsp;&nbsp;USD</td>
			</tr>
			<tr class="h23">
				<td width="" colspan="2"></td>
				<td width="" title="LP Date of Receipt">LP DOR</td>
				<td width=""><input type="text" style="width:79;text-align:center" name="labl_pty_rcvr_dt" value="" class="input2" readonly></td>
				<td width="">LP Recovered Amount</td>
				<td width=""><input type="text" style="width:130;text-align:right" name="labl_pty_rcvr_locl_amt" value="" class="input2" readonly>&nbsp;<input type="text" style="width:40;text-align:center" name="labl_pty_rcvr_locl_curr_cd" value="" class="input2" readonly></td>
				<td width="">R.O.E</td>
				<td width="" class="stm"><input type="text" style="width:66;text-align:right" name="labl_pty_rcvr_locl_xch_rt" value="" class="input2" readonly>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" style="width:130;text-align:right" name="labl_pty_rcvr_usd_amt" value="" class="input2" readonly>&nbsp;&nbsp;USD</td>
			</tr>
			</table> 
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="198" align="right">Approval No.</td>
				<td width="300" class="stm"><input type="text" style="width:100%;text-align:center" name="clm_stl_auth_no" value="" class="input2" readonly></td>
				<td width="219" align="right">Approval Status&nbsp;</td>
				<td width=""><input type="text" style="width:66;text-align:center" name="clm_stl_auth_cd_nm" value="" class="input2" readonly>
				<input type="hidden" name="clm_stl_auth_cd"></td>				
			</tr>
			</table> 
			
		</td>
			</tr>
			</table> 
			
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
		
		
<!-- Tab1 (S) -->
<div id="tabLayer" style="display:inline">
        <table class="search">
            	<tr>
			<td class="bg">
				<table border="0" style="width:100%; background-color:white;" class="grid2"> 
				<tr>
					<td><textarea style="width:100%" name="cgo_clm_stl_rmk" rows="15" class="textarea1" required caption="Opinion on Settlement">

</textarea></td>
				</tr>
			</table> 
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="80">Applied on</td>
					<td width="110"><input type="text" style="width:80;text-align:center" name="clm_stl_appl_dt" value="" class="input2" readonly></td>
					<td width="20">by</td>
					<td width="110" class="stm"><input type="text" style="width:80;text-align:center" name="clm_stl_appl_usr_id" value="" class="input2" readonly></td>
					<td width="20">for</td>
					<td width="151"><input type="text" style="width:58;text-align:center" name="clm_stl_appl_ofc_cd" value="" class="input2" readonly></td>
					<td width="90">Approved on</td>
					<td width="110"><input type="text" style="width:80;text-align:center" name="clm_stl_auth_dt" value="" class="input2" readonly></td>
					<td width="20">by</td>
					<td width="110" class="stm"><input type="text" style="width:80;text-align:center" name="clm_stl_auth_usr_id" value="" class="input2" readonly></td>
					<td width="20">for</td>
					<td width=""><input type="text" style="width:58;text-align:center" name="clm_stl_auth_ofc_cd" value="" class="input2" readonly></td>
				</tr>
				</table> 
			</td>
		</tr>
	</table>
</div>
<!-- Tab1 (E) -->
	
<!-- Tab2 (S) -->
<div id="tabLayer" style="display:none">
	<table class="search">
            	<tr>
			<td class="bg">
				<table border="0" style="width:100%; background-color:white;" class="grid2"> 
				<tr>
					<td><textarea style="width:100%" name="cgo_clm_stl_desc" rows="15" class="textarea" >						
					</textarea></td>
				</tr>
			</table> 
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="80">Applied on </td>
					<td width="110"><input type="text" style="width:80;text-align:center" name="clm_stl_appl_dt2" value="" class="input2" readonly></td>
					<td width="20">by</td>
					<td width="110" class="stm"><input type="text" style="width:80;text-align:center" name="clm_stl_appl_usr_id2" value="" class="input2" readonly></td>
					<td width="20">for</td>
					<td width="151"><input type="text" style="width:58;text-align:center" name="clm_stl_appl_ofc_cd2" value="" class="input2" readonly></td>
					<td width="90">Approved on</td>
					<td width="110"><input type="text" style="width:80;text-align:center" name="clm_stl_auth_dt2" value="" class="input2" readonly></td>
					<td width="20">by</td>
					<td width="110" class="stm"><input type="text" style="width:80;text-align:center" name="clm_stl_auth_usr_id2" value="" class="input2" readonly></td>
					<td width="20">for</td>
					<td width=""><input type="text" style="width:58;text-align:center" name="clm_stl_auth_ofc_cd2" value="" class="input2" readonly></td>
				</tr>
				</table> 
			</td>
		</tr>
	</table>
</div>
<!-- Tab2 (E) -->

<!-- Tab3 (S) -->
<div id="tabLayer" style="display:none">
	<table class="search">
            	<tr>
			<td class="bg">
				<table border="0" style="width:100%; background-color:white;" class="grid2"> 
				<tr>
					<td><textarea style="width:100%" name="clm_stl_auth_rmk" rows="15" class="textarea2" readonly>
						
					</textarea></td>
				</tr>
			</table> 
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="80">Applied on </td>
					<td width="110"><input type="text" style="width:80;text-align:center" name="clm_stl_appl_dt3" value="" class="input2" readonly></td>
					<td width="20">by</td>
					<td width="110" class="stm"><input type="text" style="width:80;text-align:center" name="clm_stl_appl_usr_id3" value="" class="input2" readonly></td>
					<td width="20">for</td>
					<td width="151"><input type="text" style="width:58;text-align:center" name="clm_stl_appl_ofc_cd3" value="" class="input2" readonly></td>
					<td width="90">Approved on</td>
					<td width="110"><input type="text" style="width:80;text-align:center" name="clm_stl_auth_dt3" value="" class="input2" readonly></td>
					<td width="20">by</td>
					<td width="110" class="stm"><input type="text" style="width:80;text-align:center" name="clm_stl_auth_usr_id3" value="" class="input2" readonly></td>
					<td width="20">for</td>
					<td width=""><input type="text" style="width:58;text-align:center" name="clm_stl_auth_ofc_cd3" value="" class="input2" readonly></td>
				</tr>
				</table> 
			</td>
		</tr>
	</table>
</div>
<!-- Tab3 (E) -->

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
					<td class="btn1_2" name="btn1_Cancel">Cancel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1_2" name="btn1_Draft" >Draft</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1_2" name="btn1_Payment">Payment</td>
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
