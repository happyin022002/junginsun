<%/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : cps_cni_0034.jsp
 *@FileTitle : [CPS_CNI_0034] View-Contract of Carriage-Main
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.11.23
 *@LastModifier : 박제성
 *@LastVersion : 1.0
 * 2009.11.23 박제성
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
<%@page import="com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.event.CpsCni0010Event"%>
<%@page import="com.hanjin.apps.alps.cps.cni.common.CniUtil"%>
<%
	CpsCni0010Event event = null;
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

    try
    {

		reqCgoClmNo  = JSPUtil.getParameter(request, "cgo_clm_no","");

        SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
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

        event = (CpsCni0010Event) request.getAttribute("Event");
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


<%@page import="com.hanjin.apps.alps.cps.gem.common.GemUtil"%>
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
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="cgo_clm_ref_bl_no">
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
				<td width="67">Claim  No.</td>
				<td width="145"><input type="text" style="width:80;text-align:center" name="cgo_clm_no" value="<%=userCgoClmNo%>" required maxlength="10" caption="Claim  No" onKeyPress="ComKeyOnlyAlphabet('uppernum')" class="input1">&nbsp;<input type="text" style="width:20;" name="clm_area_cd" value="" class="input2" readonly></td>
				<td width="35">HOFC</td>
				<td width="70"><input type="text" style="width:50;text-align:center" name="hdlr_ofc_cd" value="" class="input2"  readonly></td>
				<td width="50">Handler</td>
				<td width="105"><input type="text" style="width:75;text-align:center" name="hdlr_usr_id" value="" class="input2"  readonly>&nbsp;<img class="cursor" src="img/btns_search.gif" name="btn1_Handler" width="19" height="20" border="0" align="absmiddle"></td>
				<td width="30">DOU</td>
				<td width="90"><input type="text" style="width:76;text-align:center" name="upd_dt" value="" class="input2"  readonly></td>
				<td width="75">Incident No.</td>
				<td width="110"><input type="text" style="width:95;text-align:center" name="cgo_clm_inci_no" value="" class="input2"  readonly></td>
				<td width="50">VOC No.</td>
				<td width=""><input type="text" style="width:100%;text-align:center" name="crm_voc_no" value="" class="input2"  readonly></td>
				</tr>
			</table>
			<table class="search" border="0" style="width:979;">
			<tr class="h23">
				<td width="67">Status</td>
				<td width="120"><input type="text" style="width:103;text-align:center" name="clm_misc_nm" value="" class="input2"  readonly><input type="hidden" name="clm_misc_cd" value=""></td>
				<td width="60"><span title="Handling Period">HPD</span>/<span title="Net Handling Period">NHP</span></td>
				<td width="120"><input type="text" style="width:40;text-align:center" name="hpc" value="" class="input2"  readonly>&nbsp;/&nbsp;<input type="text" style="width:40;" name="nhp" value="" class="input2"  readonly></td>
				<td width="30" title="Type Of Settlement" >TOS</td>
				<td width="60"><input type="text" style="width:45;text-align:center" name="cgo_clm_stl_tp_cd" value="" class="input2"  readonly></td>
				<td width="30" title="Date Of Close">DOC</td>
				<td width="90"><input type="text" style="width:76;text-align:center" name="cs_clz_dt" value="" class="input2"  readonly></td>
				<td width="40" title="Time Barred Date" >DOTB</td>
				<td width="130"><input type="text" style="width:90;text-align:center" name="clm_tm_bar_dt" value="" class="input2" readonly></td>
				<td width="140">Summons Served Date</td>
				<td width=""><input type="text" style="width:90;text-align:center" name="smns_sve_dt" value="" class="input2" readonly></td>
				</tr>
			</table>
			
			<table class="line_bluedot"><tr><td></td></tr></table>
			
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="67">Claimant</td><input type="hidden" name="clmt_clm_pty_no">
				<td width="390"><input type="text" style="width:70;text-align:center" name="clm_pty_abbr_nm" value="" class="input2" readonly>&nbsp;<input type="text" style="width:282;" name="pty_nm" value="" class="input2" readonly>&nbsp;<input type="text" style="width:20;" name="clmt_clm_tp_cd" value="" class="input2" readonly></td>
				<td width="65"><span title="Received Office">ROFC</span>/<span title="Date of Formal Claim">DOF</span></td>
				<td width=""><input type="text" style="width:75;text-align:center" name="fmal_clm_rcv_ofc_cd" value="" class="input2" readonly>&nbsp;/&nbsp;<input type="text" style="width:80;text-align:center" name="fmal_clm_rcv_dt" value="" class="input2" readonly></td>
				</tr>
			</table> 
			
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="67" title="Type of Cargo Claim">TOC</td>
				<td width="120"><input type="text" style="width:70;text-align:center" name="cgo_clm_tp_cd" value="" class="input2" readonly></td>
				<td width="47" title="Cause of Damage / Loss">CODL</td>
				<td width="68"><input type="text" style="width:40;text-align:center" name="mjr_clm_dmg_lss_cd" value="" class="input2" readonly></td>
				<td width="110" title="No 3rd Liable Party">3rd Liable Party</td>
				<td width="73"><input type="text" style="width:40;text-align:center" name="n3rd_labl_pty_cd" value="" class="input2" readonly></td>
				<td width="30" title="Place of Incident">POI</td>
				<td width="50"><input type="text" style="width:40;text-align:center" name="inci_plc_tp_cd" value="" class="input2" readonly></td>
				<td width="30" title="Date of Incident">DOI</td>
				<td width="140"><input type="text" style="width:75;text-align:center" name="inci_occr_dt" value="" class="input2" readonly></td>
				<td width="90"> Claim Amount</td>
				<td width="" class="stm"><input type="text" style="width:130;text-align:right" name="clmt_usd_amt" value="" class="input2" readonly >&nbsp;&nbsp;USD</td>
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


	
		<div id="tabLayer1" style="display:inline">	
		<table class="search" id="mainTable"> 
		<tr><td class="bg">	
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
						<td width="300" valign="top">
						<table class="search" border="0" style="width:270;"> 
						<tr class="h23">
						<td width="110">
						<table class="search" border="0">
						<tr><td class="title_h"></td>
						<td class="title_s">B / L</td></tr>
						</table>
						
						
						<td align="right"><table width="80" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2_3" name="btn_BLPreview" >B/L View</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						</tr>
						</table> 


						<!-- Grid  (S) -->
						<table width="270"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table>
						<!-- Grid  (E) -->

						</td>
						
						<td width="350" valign="top">
						<table class="search" border="0" style="width:320;"> 
							<tr class="h23">
								<td width="80">Trunk VVD</td>
								<td colspan="3"><input type="text" style="width:100;" name="trnk_ref_vvd_no" value="" class="input2" readonly></td>
								
								<td width=""><table width="100" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2_3" name="btn2_Upload_07" >File Upload</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
						
							</tr>
							</table>
						<table class="height_5"><tr><td></td></tr></table>
						<table class="search" border="0" style="width:320;"> 
						<tr class="h23">
								<td width="80">Lane</td>
								<td width="105"><input type="text" style="width:50;text-align:center" name="slan_cd" value="" class="input2" readonly></td>
								<td width="30">Term</td>
								<td><input type="text" style="width:50;text-align:center" name="crr_term_cd" value="" class="input2" readonly></td>
								</tr>
						</table> 
						<table class="height_5"><tr><td></td></tr></table>
						<table class="search" border="0" style="width:320;"> 
							<tr class="h23">
								<td width="80">POR / DOR</td>
								<td width="105"><input type="text" style="width:100;text-align:center" name="por_cd" value="" class="input2" readonly></td>
								<td width="30"><img class="cursor" src="img/btns_search.gif" name="btns_por_cd" width="19" height="20" border="0" align="absmiddle">&nbsp;/</td>
								<td><input type="text" style="width:100;text-align:center" name="rct_dt" value="" class="input2" readonly></td>
							</tr>
							<tr class="h23">
								<td width="80">POL&nbsp; / <span title="Date of Loading">DOL</span></td>
								<td width="105"><input type="text" style="width:100;text-align:center" name="pol_cd" value="" class="input2" readonly></td>
								<td width="30"><img class="cursor" src="img/btns_search.gif" name="btns_pol_cd" width="19" height="20" border="0" align="absmiddle">&nbsp;/</td>
								<td><input type="text" style="width:100;text-align:center" name="lodg_dt" value="" class="input2" readonly></td>
							</tr>
							<tr class="h23">
								<td width="80" title="Port of Discharge/Date of Discharge">POD / DOD</td>
								<td width="105"><input type="text" style="width:100;text-align:center" name="pod_cd" value="" class="input2" readonly></td>
								<td width="30"><img class="cursor" src="img/btns_search.gif" name="btns_pod_cd" width="19" height="20" border="0" align="absmiddle">&nbsp;/</td>
								<td><input type="text" style="width:100;text-align:center" name="dchg_dt" value="" class="input2"></td>
							</tr>
							<tr class="h23">
								<td width="80"><span title="Place of Delivery">DEL</span>&nbsp; / DDL</td>
								<td width="105"><input type="text" style="width:100;text-align:center" name="del_cd" value="" class="input2" readonly></td>
								<td width="30"><img class="cursor" src="img/btns_search.gif" name="btns_del_cd" width="19" height="20" border="0" align="absmiddle">&nbsp;/</td>
								<td><input type="text" style="width:100;text-align:center" name="de_dt" value="" class="input2" readonly></td>
							</tr>
						</table> 
						</td>
						
						<td  valign="top">
						<table class="search" border="0" style="width:100%;"> 
						<tr class="h23">
						<td>
						<table class="search" border="0">
						<tr><td class="title_h"></td>
						<td class="title_s">CNTR</td></tr>
						</table>
						
						<td align="right"><table width="150" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2_3" name="btn_Movement" >Movement History</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						</tr>
						</table>
						
						<!-- Grid  (S) -->
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet2');</script>
								</td>
							</tr>
						</table>
						<!-- Grid  (E) -->
			
			
						</td>
			</tr>
			</table> 
			<table class="height_5"><tr><td></td></tr></table>
			
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="70">Shipper</td>
				<td width="580"><input type="text" style="width:546;" name="shpr_nm" value="" class="input2" readonly></td>
				<td width="110">Cargo & Quantity</td>
				<td width="" colspan="3">
				<input type="text" style="width:40;text-align:center" name="clm_cgo_tp_cd" value="" class="input2" readonly>
				<input type="text" style="width:170;" name="cgo_qlty_desc" value="" class="input2" readonly caption="Cargo & Quantity"></td>
			</tr>
			<tr class="h23">
				<td width="70">Consignee</td>
				<td width="580"><input type="text" style="width:546;" name="cnee_nm" value="" class="input2" readonly></td>
				<td width="110">Freight</td>
				<td width="" colspan="3"><input type="text" style="width:140;text-align:right" name="clm_ofrt_amt" value="" class="input2" readonly>&nbsp;&nbsp;USD</td>
			</tr>
			<tr class="h23">
				<td width="70">Notify</td>
				<td width="580"><input type="text" style="width:546;" name="ntfy_nm" value="" class="input2" readonly></td>
				<td width="110">Payment Term </td>
				<td width="80" style="padding-left:2">
				<script language="javascript">ComComboObject("clm_ofrt_term_cd", 2, 60, 1);</script>
				</td>
				<td width="76">Paid or not </td>
				<td width="">
				<script language="javascript">ComComboObject("clm_ofrt_flg", 2, 60, 1);</script>
				</td>
			</tr>
		    </table>
					</td></tr>
		</table>
</div>	
<div id="tabLayer1" style="display:none">
<table class="search">
    <tr><td class="bg" valign="top" style="height:240;">	
				
			<table class="search" border="0" style="width:979;">
			<tr class="h23">
				<td width="55">Pre-VVD</td>
				<td width="55" class="stm">Pre-VVD1</td>
				<td width="85"><input type="text" style="width:80;text-align:center" name="n1st_pre_ref_vvd_no" value="" class="input2" readonly></td>
				<td width="170"><table width="100" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2_3" name="btn2_Upload_01" >File Upload</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				<td width="60" class="stm">Pre-VVD2</td>
				<td width="85"><input type="text" style="width:80;text-align:center" name="n2nd_pre_ref_vvd_no" value="" class="input2" readonly></td>
				<td width="163"><table width="100" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2_3" name="btn2_Upload_02" >File Upload</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				<td width="60" class="stm">Pre-VVD3</td>
				<td width="85"><input type="text" style="width:80;text-align:center" name="n3rd_pre_ref_vvd_no" value="" class="input2" readonly></td>
				<td width=""><table width="100" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2_3" name="btn2_Upload_03" >File Upload</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
			</tr>
			</table>
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="55">&nbsp;</td>
				<td width="" class="stm">Pre-POT1/Pre-DOT1</td>
				<td width=""><input type="text" style="width:45;text-align:center" name="n1st_pre_ts_loc_cd" value="" class="input2" readonly>&nbsp;<img class="cursor" src="img/btns_search.gif" name="btns_n1st_pre_ts_loc_cd" width="19" height="20" border="0" align="absmiddle">&nbsp;/&nbsp;
					<input type="text" style="width:75;text-align:center" name="n1st_pre_ts_dt" dataformat="ymd" maxlength="8" value="" class="input2" readonly></td>
				<td width="" class="stm">Pre-POT2/Pre-DOT2</td>
				<td width=""><input type="text" style="width:45;text-align:center" name="n2nd_pre_ts_loc_cd" value="" class="input2" readonly>&nbsp;<img class="cursor" src="img/btns_search.gif" name="btns_n2nd_pre_ts_loc_cd" width="19" height="20" border="0" align="absmiddle">&nbsp;/&nbsp;
					<input type="text" style="width:75;text-align:center" name="n2nd_pre_ts_dt" dataformat="ymd" maxlength="8" value="" class="input2" readonly></td>
				<td width="" class="stm">Pre-POT3/Pre-DOT3</td>
				<td width=""><input type="text" style="width:45;text-align:center" name="n3rd_pre_ts_loc_cd" value="" class="input2" readonly>&nbsp;<img class="cursor" src="img/btns_search.gif" name="btns_n3rd_pre_ts_loc_cd" width="19" height="20" border="0" align="absmiddle">&nbsp;/</td>
				<td width=""><input type="text" style="width:75;text-align:center" name="n3rd_pre_ts_dt" dataformat="ymd" maxlength="8" value="" class="input2" readonly></td>
			</tr>
			<tr class="h23"><td width="55">&nbsp;</td></tr>	
		</table>
		<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
   <table class="search" border="0" style="width:979;">
   			<tr class="h23"><td width="55">&nbsp;</td></tr>  
			<tr class="h23">
				<td width="55">On-VVD</td>
				<td width="55" class="stm">On-VVD1</td>
				<td width="85"><input type="text" style="width:80;text-align:center" name="n1st_pst_ref_vvd_no" value="" class="input2" readonly></td>
				<td width="170"><table width="100" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2_3" name="btn2_Upload_04" >File Upload</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				<td width="60" class="stm">On-VVD2</td>
				<td width="85"><input type="text" style="width:80;text-align:center" name="n2nd_pst_ref_vvd_no" value="" class="input2" readonly></td>
				<td width="163"><table width="100" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2_3" name="btn2_Upload_05" >File Upload</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				<td width="60" class="stm">On-VVD3</td>
				<td width="85"><input type="text" style="width:80;text-align:center" name="n3rd_pst_ref_vvd_no" value="" class="input2" readonly></td>
				<td width=""><table width="100" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2_3" name="btn2_Upload_06" >File Upload</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
			</tr>
			</table>
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="55">&nbsp;</td>
				<td width="" class="stm">On-POT1 / On-DOT1</td>
				<td width=""><input type="text" style="width:45;text-align:center" name="n1st_pst_ts_loc_cd" value="" class="input2" readonly>&nbsp;<img class="cursor" src="img/btns_search.gif" name="btns_n1st_pst_ts_loc_cd" width="19" height="20" border="0" align="absmiddle">&nbsp;/&nbsp;
					<input type="text" style="width:75;text-align:center" name="n1st_pst_ts_dt" dataformat="ymd" maxlength="8" value="" class="input2" readonly></td>
				<td width="" class="stm">On-POT2 / On-DOT2</td>
				<td width=""><input type="text" style="width:45;text-align:center" name="n2nd_pst_ts_loc_cd" value="" class="input2" readonly>&nbsp;<img class="cursor" src="img/btns_search.gif" name="btns_n2nd_pst_ts_loc_cd" width="19" height="20" border="0" align="absmiddle">&nbsp;/&nbsp;
					<input type="text" style="width:75;text-align:center" name="n2nd_pst_ts_dt" dataformat="ymd" maxlength="8" value="" class="input2" readonly></td>
				<td width="" class="stm">On-POT3 / On-DOT3</td>
				<td width=""><input type="text" style="width:45;text-align:center" name="n3rd_pst_ts_loc_cd" value="" class="input2" readonly>&nbsp;<img class="cursor" src="img/btns_search.gif" name="btns_n3rd_pst_ts_loc_cd" width="19" height="20" border="0" align="absmiddle">&nbsp;/</td>
				<td width=""><input type="text" style="width:75;text-align:center" name="n3rd_pst_ts_dt" dataformat="ymd" maxlength="8" value="" class="input2" readonly></td>
			</tr>
			
		</table>
	</td></tr>
	
		</table>
</div>
		<!--biz page (E)-->	

	

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
				
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
		</table>
	


<!-- 개발자 작업  끝 -->
</form>
<div style="display: none;"><script language="javascript">ComSheetObject('sheet3');</script></div>
</body>
</html>
