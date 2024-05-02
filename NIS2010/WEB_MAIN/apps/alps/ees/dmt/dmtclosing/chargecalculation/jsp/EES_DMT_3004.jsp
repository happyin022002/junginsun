<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_dmt_3004.jsp
*@FileTitle : Charge Inquiry by Office Or VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.07.02 황효근
* 1.0 Creation
* ---------------------------------------------------------
* History
* 2013.04.18 임창빈 [CHM-201324214] [DMT] 미주 MT Notification data display 요청
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.event.EesDmt3004Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt3004Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";
	String strUsr_Cnt_cd	= "";
	String strRhq_ofc_cd	= "";
	Logger log = Logger.getLogger("com.hanjin.apps.DMTClosing.ChargeCalculation");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id		= account.getUsr_id();
		strUsr_nm		= account.getUsr_nm();
		strUsr_ofc		= account.getOfc_cd();
		strUsr_Cnt_cd	= account.getCnt_cd();
		strRhq_ofc_cd	= account.getRhq_ofc_cd();

		event = (EesDmt3004Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
	//String dmdtCntrTpCd  = JSPUtil.getCodeCombo("f_dmdt_cntr_tp_cd" , "01", "style='width:120'", "CD03124", 0, "000010:ALL:ALL");
%>
<html>
<head>
<title>Charge Inquiry by Office Or VVD</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	<%= JSPUtil.getIBCodeCombo("f_dmdt_cntr_tp_cd" , "", "CD03124", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("f_dmdt_bkg_cgo_tp_cd" , "", "CD03125", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("f_bkg_rcv_term_cd" , "", "CD00764", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("f_bkg_de_term_cd" , "", "CD00765", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("f_fm_mvmt_sts_cd" , "", "CD02158", 0, "")%>
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
<input type="hidden" name="usr_ofc_cd"			value="<%=strUsr_ofc%>">
<input type="hidden" name="usr_cnt_cd"			value="<%=strUsr_Cnt_cd%>">
<input type="hidden" name="usr_rhq_ofc_cd"		value="<%=strRhq_ofc_cd%>">
<input type="hidden" name="usr_trf_tp">
<input type="hidden" name="ofc_cd">
<input type="hidden" name="cng_rhq_ofc_cd">
<input type="hidden" name="tmp_ofc_cd">
<input type="hidden" name="dmdt_trf_cd">
<input type="hidden" name="dmdt_chg_sts_cd">
<input type="hidden" name="fm_mvmt_yd_cd">
<input type="hidden" name="to_mvmt_yd_cd">
<input type="hidden" name="pol_cd">
<input type="hidden" name="pod_cd">
<input type="hidden" name="fm_mvmt_dt">
<input type="hidden" name="to_mvmt_dt">
<input type="hidden" name="fm_bzc_trf_aply_dt">
<input type="hidden" name="to_bzc_trf_aply_dt">
<input type="hidden" name="fm_loc_cd">
<input type="hidden" name="to_loc_cd">
<input type="hidden" name="cost_yrmon">
<input type="hidden" name="yd_cd1">
<input type="hidden" name="loc_cd">
<input type="hidden" name="chk_yd_cd" value="Y">
<input type="hidden" name="chk_loc_cd" value="Y">
<input type="hidden" name="us_ofc_yn">

<!-- 지정 화면 Access 권한 정보 조회용  -->
<input type="hidden" name="role_permit">
<input type="hidden" name="role_auth">

<input type="hidden" name="inact_sts_cd">
<input type="hidden" name="aft_dar_sts_cd">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->
	
	
	<table class="search"> 
       		<tr><td class="bg">
       		<div id="sch_cond_div" style=display:inline;>
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:985;"> 
					<tr class="h23">
						<td width="35">Office</td>
						<td width="180" class="sm">
						<script language="javascript">ComComboObject('office',2,70,0,1,0,true);</script><img src="img/btns_multisearch.gif" 
							width="15" height="20" alt="" border="0" align="absmiddle" class="cursor"><input type="checkbox" 
							name="chk_sub_ofc" value="Y" onClick="doInclSubOfc()" class="trans">Incl. Sub Office</td>
						<td width="65">Tariff Type</td>
						<td width="85"><script language="javascript">ComComboObject('tariff_type',2,85,1,1);</script>
						</td>
						<td width="38">Status</td>
						<td width="78"><script language="javascript">ComComboObject('status',2,78,1,1);</script>
						</td>
						<td id="tdGB" width="20">G/B</td>
						<td width="68"><select name="chg_type" style="width:68;" class="input">
						<option value="" selected>All</option>
						<option value="G">General</option>
						<option value="B">Balance</option>
						</select></td>
						<td width="20">A/R</td>
						<td width="40"><select name="dmdt_ar_if_cd" style="width:40;" class="input">
						<option value="ALL" selected>All</option>
						<option value="Y">Y</option>
						<option value="N">N</option>
						</select>
						<td id="tdUC" width="20">UC</td>
						<td width="45"><select name="uclm_flg" style="width:40;" class="input" onChange="changeDate(this.value)" >
						<option value="ALL" selected>All</option>
						<option value="Y">Y</option>
						<option value="N">N</option>
						</select></td>
						<td width="80">F/T Over Day </td>
						<td width="30"><input type="text" name="fx_ft_ovr_dys" dataformat="int" maxlength="3" minnum='0' caption='F/Time Over Day'  style="width:30;text-align:right" class="input" value="0"></td>
						
						<td width="25">O/T</td>
						<td width="40"><select name="ofc_trns_rhq_cng_flg" style="width:40;" class="input">
						<option value="ALL" selected>All</option>
						<option value="Y">Y</option>
						<option value="N">N</option>
						</select></td>
						
					</tr>
				</table>
				
				<table class="search_sm2" border="0" style="width:100%;"> 
					<tr class="h23"><td>
			
				<table class="search" border="0" style="width:985;"> 
					<tr class="h23">
						<td width="50"><input type="radio" name="cond_type" value="date" class="trans" checked>Date</td>
						
						<td width="110" class="stm">
						<select name="opt_date" style="width:110;" class="input" onChange="optDate(this.value)"> 
						<option value="MVMT_DT" selected>MVMT</option>
						<option value="APP_DT">Applicable Date</option>
						<!-- option value="REV_MON">R. Month</option -->
						</select>
						</td>
						
						<td>
						<div id="mvmtDt" style="display:inline">
						<table class="search" border="0">
						  <tr class="h23">
						  	<td width="200">
							<input type="text" style="width:70;" class="input1" name="fm_mvmt_dt1" maxlength="8" dataformat="ymd" style="text-align:center" caption="Period From Date">&nbsp;~
							<input type="text" style="width:70;" class="input1" name="to_mvmt_dt1" maxlength="8" dataformat="ymd" style="text-align:center"  caption="Period To Date" >&nbsp;<img src="img/btns_calendar.gif" 
							name="btns_calendar" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor"></td>
							</tr>
							</table>
						</div>
						<div id="appDt" style="display:none">
						<table class="search" border="0" >
						<tr class="h23">
							<td width="200">
							<input type="text" style="width:70;" class="input1" name="fm_bzc_trf_aply_dt1" maxlength="8" dataformat="ymd" style="text-align:center" caption="Period From Date">&nbsp;~
							<input type="text" style="width:70;" class="input1" name="to_bzc_trf_aply_dt1" maxlength="8" dataformat="ymd" style="text-align:center"  caption="Period To Date" >&nbsp;<img src="img/btns_calendar.gif" 
							name="btns_calendar1" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor"></td>
							</tr>
						</table>	
						</div>
						<div id="revMon" style="display:none">
							<table class="search" border="0">
							<tr>
							<td width="200">
							<input type="text" style="width:70;" class="input1" name="cost_yrmon1" maxlength="8" style="text-align:center" dataformat="ym"  caption="Period To Date" >&nbsp;<img src="img/btns_calendar.gif" 
							name="btns_calendar2" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor"></td>
							</tr>
							</table>
						</div>
						</td>			
						<td width="25" class="stm">Yard</td>
						<td width="235" class="sm"><input type="radio" name="yard_fmto" value="yard_fm"  checked class="trans">From<input type="radio" name="yard_fmto" 
							value="yard_to" class="trans">To&nbsp;&nbsp;<input type="text" name="yd_cd" dataformat="engup" maxlength="5" OnKeyUp="obj_keyup()" 
							style="width:49;" class="input">&nbsp;
							<script language="javascript">ComComboObject('yd_cd2', 2, 45 , 0);</script></td>
						
						<td width="20" class="stm">Org.</td>
						<td width="57"><select name="org_gubun_cd" style="width:55;" class="input" onChange="orgNDestMaxLengthChange(this.name, this.value)">
						<option value="" selected></option>
						<option value="CONTI_CD">Conti.</option>
						<option value="POR_CD">POR</option>
						<option value="POL_CD">POL</option>
						</select></td>
						<td>
						<div id="orgConti" style="display:inline">
						<table class="search" border="0">
						  <tr class="h23">
						  	<td width="75"><select name="fm_loc_cd1" style="width:70;" class="input">
							<option value="" selected></option>
							<option value="A">Asia</option>
							<option value="E">Europe</option>
							<option value="M">America</option>
							<option value="F">Africa</option>
							</select></td></tr></table></div>
						<div id="orgLoc" style="display:inline">
						<table class="search" border="0">
						  <tr class="h23">
							<td width="75" class="stm"><input type="text" name="fm_loc_cd2"  dataformat="engup" maxlength=0  style="width:70;" class="input2" style="text-align:center" value="" caption="From Loc."></td>
							</tr></table></div>
						</td>
						
						<td width="40" class="stm">&nbsp;&nbsp;Dest.</td>
						<td width="57"><select name="dest_gubun_cd" style="width:55;" class="input" onChange="orgNDestMaxLengthChange(this.name, this.value)">
						<option value="" selected></option>
						<option value="CONTI_CD">Conti.</option>
						<option value="POD_CD">POD</option>
						<option value="DEL_CD">DEL</option>
						</select></td>
						<td>
						<div id="destConti" style="display:inline">
						<table class="search" border="0">
						  <tr class="h23">
						  	<td width="75"><select name="to_loc_cd1" style="width:70;" class="input">
							<option value="" selected></option>
							<option value="A">Asia</option>
							<option value="E">Europe</option>
							<option value="M">America</option>
							<option value="F">Africa</option>
							</select></td></tr></table></div>
						<div id="destLoc" style="display:inline">
						<table class="search" border="0">
						  <tr class="h23">
							<td width="75" class="stm"><input type="text" name="to_loc_cd2"  dataformat="engup" maxlength=0  style="width:70;" class="input2" style="text-align:center" value="" caption="From Loc."></td>
							</tr></table></div>
						</td>
						<td width="32"></td>
					</tr>
				</table>
				
				<table class="search" border="0" style="width:100%;"> 
					<tr class="h23">
						<td width="80"><input type="radio" name="cond_type" value="vvd_cd" class="trans">VVD CD</td>
						<td width="50" class="stm">VVD CD</td>
						<td width="235" class="sm"><input type="text" name="vvd_cd" dataformat="engup"  maxlength="9"  style="width:80;" class="input" value=""></td>
						<td width="45" class="stm">Port</td>
						<td width="140" class="stm"><input type="text" name="tmnl_cd" dataformat="engup" maxlength="5" OnKeyUp="obj_keyup()" style="width:50;" class="input" value="">&nbsp;</td>
						<td width="75"></td>
						<td width="62" class="stm">DEM Type</td>
						<td width="130" class="stm"><select name="dem_type" style="width:98;" class="input">
						<option value="" selected>All</option>
						<option value="I">Intransit </option>
						<option value="L">Local</option>
						</select></td>
						<td width="" class="stm">&nbsp;</td>
					</tr>
				</table>
				
				<table class="search" border="0" style="width:100%;"> 
					<tr class="h23">
						<td width="80"><input type="radio" name="cond_type" value="cntr" class="trans">CNTR</td>
						<td width="50" class="stm">BKG No.</td>
						<td width="235" class="sm"><input type="text" name="bkg_no" dataformat="engup2" maxlength="" style="width:100;" class="input" value="">&nbsp;<img src="img/btns_multisearch.gif"
							name="btns_multisearch1" width="19"height="20"alt=""border="0"align="absmiddle" class="cursor" onClick="doProcessPopup('m_bkg_no')"></td>
						<td width="45" class="stm">B/L No.</td>
						<td width="140" class="stm"><input type="text" name="bl_no" dataformat="engup2" maxlength="" style="width:100;" class="input" value="">&nbsp;<img src="img/btns_multisearch.gif"
							name="btns_multisearch2" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor" onClick="doProcessPopup('m_bl_no')"></td>
						<td width="75"></td>
						<td width="60" class="stm">CNTR No.</td>
						<td width="131" class="stm" style="padding-left:2"><input type="text" name="cntr_no" dataformat="engup2" maxlength=""  style="width:98;" class="input" value="">&nbsp;<img src="img/btns_multisearch.gif"
							name="btns_multisearch3" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor" onClick="doProcessPopup('m_cntr_no')"></td>
						<td width="" class="stm">&nbsp;</td>
					</tr>
				</table>
				
				</td></tr></table>
				
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="50">Customer</td>
						<td width="185"><select name="cust_type" style="width:56;" class="input">
						<option value="" selected>ALL</option>
						<option value="P">Payer</option>
						<option value="S">SHPR</option>
						<option value="C">CNEE</option>
						<option value="N">NTFY</option>
						<option value="A">A/R</option>
						</select>&nbsp;<input type="text" name="cust_cd"  dataformat="engup"  maxlength=8  style="width:100;" class="input" caption="Customer Code">&nbsp;<img src="img/btns_search.gif"
							name="btns_search1" width="19"height="20"alt=""border="0" align="absmiddle"class="cursor"	onClick="doProcessPopup('cust_cd')"></td>
						<td width="10">S/P</td>
						<td width="130" class="stm"><input type="text" name="svc_provdr" maxlength="6"  dataformat="int" fulfill style="width:100;"  class="input" value="" caption="Service Provider">&nbsp;<img src="img/btns_search.gif"
							name="btns_search2" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor" onClick="doProcessPopup('svc_provdr')"></td>
						<td width="48">S/C No.</td>
						<td width="105" class="stm" style="padding-left:2"><input type="text" name="sc_no" dataformat="engup" maxlength=20  style="width:98;"  class="input" value="" caption="S/C No."></td>
						<td width="48">RFA No.</td>
						<td width="110" class="stm"><input type="text" name="rfa_no"  dataformat="engup" maxlength=11  style="width:105;" class="input" value="" caption="RFA No."></td>
						<td width="60">R/D Term </td>
						<td width="56"><script language="javascript">ComComboObject('bkg_rcv_term_cd',1,55,1);</script></td>
						<td width="56"><script language="javascript">ComComboObject('bkg_de_term_cd',1,55,1);</script></td>
					</tr>
				</table>
				
					<!--  biz_1  (E) -->
					<div id="" style="">
					<table class="search" border="0" style="width:979;">
					<tr class="h23">
					<td> 
					<table id="cs_webmt_chk" class="search_sm2" border="0" style="width:350;display:none;">
					<tr class="h23"> 
							<td width="330"><input type="checkbox" name="cs" value="Y" class="trans">Clock Stop Only&nbsp;&nbsp;&nbsp;<input type="checkbox" name="web_mt" value="Y" class="trans" >Web Empty Notification Only</td>
							</tr>
					</table>
					</td>
					<td>
					<table class="search" border="0" style="width:870;">
					<tr class="h23">
							<td width="80">&nbsp;&nbsp;&nbsp;CNTR Type </td>
							<td width="102"><script language="javascript">ComComboObject('dmdt_cntr_tp_cd',1,100,1);</script></td>
							<td width="80">&nbsp;&nbsp;Cargo Type </td>
							<td width="122"><script language="javascript">ComComboObject('dmdt_bkg_cgo_tp_cd',1,120,1);</script></td>
							<td width="88">&nbsp;FM/TO MVMT </td>
							<td width="56"><script language="javascript">ComComboObject('fm_mvmt_sts_cd',1,55,1);</script></td>
							<td width="56"><script language="javascript">ComComboObject('to_mvmt_sts_cd',1,55,1);</script></td>
							<td width="95">&nbsp;Display Option </td>
							<td width="80"><script language="javascript">ComComboObject('opt_item_list',1,180,1);</script></td>
							</tr>
					</table>
					</td>
					</tr>
					</table>
					</div>
				
				<table class="search" border="0" style="width:100%;"> 
					<tr class="h23">
						<td width="120">Inactive Status</td>
						<td width="220" class="sm"><script language="javascript">ComComboObject('inact_sts',1,180,0,0,0,true);</script></td>
						<td width="130">After DAR Status</td>
						<td width="" class="sm"><script language="javascript">ComComboObject('aft_dar_sts',1,180,0,0,0,true);</script></td>
					</tr>
				</table>
				
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				</div>
				
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>				
				<!-- Grid  (e) -->
				
			
			</td></tr>
		</table>
		
<!-- : ( Search Options ) (E) -->
			
	</td></tr>
		</table>
			
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"> 
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
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Minimize">Minimize</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<!-- td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DelReqCancel" id="btn_DelReqCancel">Inactive REQ Cancel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td-->
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_ByBKG">by BKG</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_ByCNTR">by CNTR</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_MVMTInq">MVMT Inq.</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DownExcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
			</td></tr>
		</table>
    <!--Button (E) -->
	</td></tr>
</table>
	</td></tr>
</table>
	

<div id="topdeck" style="position:absolute;visibility:hidden;z-index:200;"></div>


<!-- 개발자 작업  끝 -->
</form>
</body>
</html>