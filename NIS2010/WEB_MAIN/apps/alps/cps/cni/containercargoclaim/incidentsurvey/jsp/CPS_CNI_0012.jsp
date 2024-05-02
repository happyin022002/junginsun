<%/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : cps_cni_0012.jsp
 *@FileTitle : [CPS_CNI_0012] Survey
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
<%@page import="com.hanjin.apps.alps.cps.cni.containercargoclaim.incidentsurvey.event.CpsCni0012Event"%>
<%@page import="com.hanjin.apps.alps.cps.cni.common.CniUtil"%>
<%@page import="com.hanjin.framework.component.util.io.HttpUtil"%>
<%
	CpsCni0012Event event = null;
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
	String userCgoClmNo = "";//session claimNo 변수
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

        event = (CpsCni0012Event) request.getAttribute("Event");
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
    
    //roles = "CNI01";
    //area =  "H";
    //ofcCd = "GOABB";
    //userId = "003997933";
%>



<%@page import="com.hanjin.framework.component.util.StringUtil"%>

<html>
<head>
<title>Survey</title>
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
<input type="hidden" name="clss_clm_misc_cd"/>

<input type="hidden" name="cgo_clm_no_old" value=""/><!--file upload 위한 old값.-->

<input type="hidden" name="usr_id" value="<%=userId%>">
<input type="hidden" name="usr_roles" value="<%=roles%>">
<input type="hidden" name="usr_area" value="<%=area%>">
<input type="hidden" name="usr_office" value="<%=ofcCd%>">

<!-- 개발자 작업 -->
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
				<td width="57">Claim  No.</td>
				
				<td width="123"><input type="text" style="width:80;text-align:center" name="cgo_clm_no" value="<%=userCgoClmNo%>" required maxlength="10" caption="Claim  No" onKeyPress="ComKeyOnlyAlphabet('uppernum')" class="input1">&nbsp;<input type="text" style="width:20;" name="clm_area_cd" value="" class="input2" readonly></td>
				<td width="30" title="Handling Office">HOFC</td>
				<td width="70"><input type="text" style="width:50;text-align:center" name="hdlr_ofc_cd" value="" class="input2"  readonly></td>
				<td width="50">Handler</td>
				
				<td width="135"><input type="text" style="width:90;text-align:center" name="hdlr_usr_id" value="" class="input2"  readonly>&nbsp;<img class="cursor" src="img/btns_search.gif" name="btn1_Handler" width="19" height="20" border="0" align="absmiddle"></td>
				<td width="30" title="Date Of Updated">DOU</td>
				<td width="100"><input type="text" style="width:76;text-align:center" name="upd_dt" value="" class="input2"  readonly></td>
				<td width="75">Incident No.</td>
				<td width="110"><input type="text" style="width:90;text-align:center" name="cgo_clm_inci_no" value="" class="input2"  readonly></td>
				<td width="50">VOC No.</td>
				<td width=""><input type="text" style="width:100%;text-align:center" name="crm_voc_no" value="" class="input2"  readonly></td>
				</tr>
			</table>
			<table class="search" border="0" style="width:979;">
			<tr class="h23">
				<td width="57">Status</td>
				<td width="90"><input type="text" style="width:88;text-align:center" name="clm_misc_nm" value="" class="input2"  readonly><input type="hidden" name="clm_misc_cd" value=""></td>
				<td width="75" title="Handling Period / Net Handling Period">&nbsp; HPC / NHP</td>
				<td width="125"><input type="text" style="width:40;text-align:center" name="hpc" value="" class="input2"  readonly>&nbsp;&nbsp;/&nbsp;&nbsp;<input type="text" style="width:40;text-align:center" name="nhp" value="" class="input2"  readonly></td>
				<td width="30" title="Type Of Settlement">TOS</td>
				<td width="90"><input type="text" style="width:45;text-align:center" name="cgo_clm_stl_tp_cd" value="" class="input2"  readonly></td>
				<td width="30" title="Date Of Close">DOC</td>
				<td width="100"><input type="text" style="width:76;text-align:center" name="cs_clz_dt" value="" class="input2" readonly></td>
				<td width="55" title="Time Bar Date">T/B Date</td>
				<td width="110"><input type="text" style="width:90;text-align:center" name="clm_tm_bar_dt" value="" class="input2" readonly></td>
				<td width="140">Summons Served Date</td>
				<td width=""><input type="text" style="width:100%;text-align:center" name="smns_sve_date" value="" class="input2" readonly></td>
				</tr>
			</table>

			<table class="search" border="0" style="width:979;">
			<tr class="h23">
				<td width="57" title="Type of Claim">TOC</td>
				<td width="78"><input type="text" style="width:50;text-align:center" name="cgo_clm_tp_cd" value="" class="input2"  readonly></td>
				<td width="47" title="Cause of Damage or Loss">CODL</td>
				<td width="49"><input type="text" style="width:40;text-align:center" name="mjr_clm_dmg_lss_cd" value="" class="input2"  readonly></td>
				<td width="100">3rd Liable Party</td>
				<td width="53"><input type="text" style="width:40;text-align:center" name="n3rd_labl_pty_cd" value="" class="input2"  readonly></td>
				<td width="39"> Cargo</td>
				<td width="260"><input type="text" style="width:45;text-align:center" name="clm_cgo_tp_cd" value="" class="input2"  readonly>&nbsp;<input type="text" style="width:195;" name="cgo_qlty_desc" value="" class="input2"  readonly></td>
				<td width="90"> Claim Amount</td>
				<td width="" class="stm" align="right"><input type="text" style="width:165;text-align:right" name="clmt_usd_amt" value="" class="input2" readonly dataformat="float">&nbsp;&nbsp;USD</td>
				</tr>

			</table>
			<table class="search" border="0" style="width:979;">
			<tr class="h23">
				<td width="57">Lane</td>
				<td width="98"><input type="text" style="width:50;text-align:center" name="slan_cd" value="" class="input2" readonly></td>
				<td width="27" title="Place of Incident">POI</td>
				<td width="55"><input type="text" style="width:40;text-align:center" name="clm_inci_plc_tp_cd" value="" class="input2" readonly></td>
				<td width="28" title="Date of Incident">DOI</td>
				<td width="253"><input type="text" style="width:80;text-align:center" name="inci_occr_dt" value="" class="input2" readonly dataformat="ymd"></td>
				<td width="50">Insurer</td>
				<td width="110"><input type="text" style="width:53;text-align:center" name="clm_pty_abbr_nm1" value="" class="input2" readonly></td>
				<td width="101">Insurer Ref No.</td>
				<td width="" class="stm" align="right"><input type="text" style="width:100%;text-align:center" name="insur_ref_no" value="" class="input2" readonly></td>
				</tr>
			</table>

			<table class="line_bluedot"><tr><td></td></tr></table>

			<table class="search" border="0" style="width:979;">
			<tr class="h23">
				<td width="67">Surveyor</td>
				<td width="333"><input type="hidden" style="width:80;" name="clm_pty_no" value="" class="input1" required caption="Surveyor"><input type="text" style="width:80;" name="clm_pty_abbr_nm2" value="" class="input1" readonly required caption="Surveyor">&nbsp;<img src="img/btns_search.gif" name="btns_surveyor" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">&nbsp;<input type="text" style="width:220;" name="pty_nm" value="" class="input2" readonly ></td>
				<td width="120"><table width="60" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2_3" name="btns_style">Style</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				<td width="73">Type</td>
				<td width="115"><script language="javascript">ComComboObject("svyr_tp_cd", 2, 50, 1);</script></td>
				<td width="75">SV Ref No.</td>
				<td width=""><input type="text" style="width:100;text-align:center;ime-mode:disabled" name="ref_svyr_no" value="" class="input" maxlength="20"></td>
				<td width="91"><table width="90" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2_3" name="btn1_File_Upload">File&nbsp;Upload</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</tr>
			</table>
			<table class="search" border="0" style="width:979;">
			<tr class="h23">
				<td width="100">Appointed  Date</td>
				<td width="119"><input type="text" style="width:76;text-align:center" name="svyr_apnt_dt" value="" class="input" dataformat="ymd" maxlength="8"  minlength="8">&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="btns_date_cal1" width="19" height="20" border="0" align="absmiddle"></td>
				<td width="97">Surveyed Date</td>
				<td width="205"><input type="text" style="width:78;text-align:center" name="svey_inp_dt" value="" class="input" dataformat="ymd" maxlength="8"  minlength="8">&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="btns_date_cal2" width="19" height="20" border="0" align="absmiddle"></td>
				<td width="70">SV Updater</td>
				<td width="115"><input type="text" style="width:70;text-align:center" name="upd_usr_id" value="" readonly class="input2"></td>
				<td width="75">SV DOU</td>
				<td width=""><input type="text" style="width:100;text-align:center" name="upd_dt2" value="" readonly class="input2"></td>
				</tr>
			</table>
			<table class="search" border="0" style="width:100%;">
				<tr class="h23">
					<td width="100">Survey Fee</td>
					<td width="211" class="stm"><input type="text" style="width:146;text-align:right;ime-mode:disabled" class="input2" name="svyr_fee_usd_amt" value="" dataformat="float" maxlength="19" pointcount="2" readonly>&nbsp;&nbsp;USD</td>
					<td width="100">Equivalent to</td>
					<td width="211" class="stm"><input type="text" style="width:130;text-align:right;ime-mode:disabled" class="input2" name="svyr_fee_locl_amt" value="" dataformat="float" maxlength="19" pointcount="2"  caption="Survey Fee" readonly>&nbsp;<input type="text" style="width:38;" class="input" name="svyr_locl_curr_cd" value="" maxlength="3" minlength="3" style="text-align:center;ime-mode:disabled" >&nbsp;<img src="img/btns_search.gif" name="btns_currency" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
					<td width="35" title="Rate Of Exchange">R.O.E</td>
					<td width=""><input type="text" style="width:70;text-align:right;ime-mode:disabled" class="input" name="svyr_xch_rt" value="" dataformat="float" maxlength="12" pointcount="5" caption="R.O.E" >&nbsp;<img src="img/btns_search.gif" name="btns_roe" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">&nbsp;</td>
				   </tr>
				</table>
			<table class="height_8"><tr><td></td></tr></table>
			<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Surveyor's Fact Finding</td></tr>
				</table>
			<table border="0" style="width:100%; background-color:white;" class="grid2">
				<tr>
					<td><textarea name="svyr_fact_fnd_desc" caption="Surveyor's Fact Finding" style="width:100%;ime-mode:disabled" rows="20" class="textarea1" required></textarea></td>
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
					<td class="btn1_2" name="btn1_Handling_Costs">Handling&nbsp;Costs</td>
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
<div style="display: none;"><script language="javascript">ComSheetObject('sheet1');</script></div>
</body>
</html>
