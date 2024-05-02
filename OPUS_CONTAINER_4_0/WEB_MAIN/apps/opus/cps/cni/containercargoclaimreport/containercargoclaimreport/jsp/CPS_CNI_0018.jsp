<%/*=========================================================

*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : cps_cni_0018.jsp
*@FileTitle  : [CPS_CNI_0018] Status
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/23

=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@page import="com.clt.framework.component.util.io.HttpUtil"%>
<%@ page import="com.clt.apps.opus.cps.cni.common.CniUtil"%>
<%
	String cookiesJSessionId="";
	Cookie[] cookies = request.getCookies();
	  if (cookies != null) {
	      for (int loop = 0; loop < cookies.length; loop++) {
	             if (cookies[loop].getName().equals("JSESSIONID")) {
	                     cookiesJSessionId=cookies[loop].getValue();
	              }
	      }
	}
    Exception serverException = null;
    String strErrMsg = "";

    String pageRows = "100";

    String userId = "";
    String userName = "";
    String userOffice = "";
    String userArea = "";

    String roles = "";
    String area = "";

    Logger log = Logger.getLogger("com.clt.apps.opus.cps.cni.containercargoclaimreport.ContainerCargoClaimReportSC");

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
<script type="text/javascript" src="/opuscntr/rpt/script/common_rd.js"></script>
</head>
<script type="text/javascript">

    function setupPage(){
    	var errMessage = "<%=strErrMsg.replace("\"","'")%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if

	    loadPage();
    }
</script>
<form name="form2">
<input type="hidden" name="sXml" value="<%=xml.replace(" \"","'") %>" id="sXml" />
</form>
<form name="form">
<input type="hidden" name="com_mrdPath" id="com_mrdPath" />
<input type="hidden" name="com_mrdArguments" id="com_mrdArguments" />
<input type="hidden" name="com_mrdTitle" id="com_mrdTitle" />
<input type="hidden" name="com_mrdBodyTitle" id="com_mrdBodyTitle" />

<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" value="100" id="pagerows" />
<input type="hidden" name="page_no" value="1" id="page_no" />
<input type="hidden" name="usr_area" value="" id="usr_area" />
<input type="hidden" name="ofc_cd" value="<%=userOffice%>" id="ofc_cd" />
<input type="hidden" name="jsession" id="jsession" value="<%=cookiesJSessionId %>"/>
<input type="hidden" name="status" value="" id="status" />

<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!--
	--><button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
	--><button type="button" class="btn_normal" name="btn1_New"  	id="btn1_New">New</button><!--
	--><button type="button" class="btn_normal" name="btn1_DownExcel" id="btn1_DownExcel">Down Excel</button><!--
	--><button type="button" class="btn_normal" name="btn1_Print"  	id="btn1_Print">Print</button><!--
	--></div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<div class="wrap_search">
	<div class="opus_design_inquiry wFit" style="margin-bottom:3px">
		<table>
			<colgroup>
				<col width="120">
				<col width="160">
				<col width="50">
				<col width="310">
				<col width="50">
				<col width="100">
				<col width="50">
				<col width="100">
				<col width="60">
				<col width="*">
			</colgroup>
			<tr>
				<td><button type="button" class="btn_etc" name="btn1_Inquiry by Class" id="btn1_Inquiry by Class">Inquiry by Class</button></td>
				<td><input type="text" name="report_title" class="input2" readonly="readonly" value="By Area" id="report_title" /><input type="hidden" name="report_id" id="report_id" /></td>
				<th>Period</th>
				<td><script type="text/javascript">ComComboObject("period", 2, 80, 1);</script><!--
				--><input type="text" value="" name="from_period" class="input1" style="width:75px;ime-mode:disabled;text-align:center" required dataformat="ymd"  caption="Period(From Date)" id="from_period" /><!--
				--><button type="button" class="calendar ir" name="btns_from_period" id="btns_from_period"></button><!--
				--><input type="text" value="" name="to_period" style="width:75px;ime-mode:disabled;text-align:center" class="input1" required dataformat="ymd"  caption="Period(To Date)" id="to_period" /><!--
				--><button type="button" class="calendar ir" name="btns_to_period" id="btns_to_period"></button></td>
				<th>Area</th>
				<td><script type="text/javascript">ComComboObject("area", 2, 80, 1);</script></td>
				<th>Status</th>
				<td><script type="text/javascript">ComComboObject("combo_status", 2, 57, 1);</script></td>
				<th>Class</th>
				<td><script type="text/javascript">ComComboObject("vt", 2, 57, 1);</script></td>
				</tr>
		</table>
	</div>
	<table class="line_bluedot"><tr><td></td></tr></table>
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="40">
				<col width="85">
				<col width="45">
				<col width="105">
				<col width="130">
				<col width="70">
				<col width="85">
				<col width="135">
				<col width="90">
				<col width="65">
				<col width="95">
				<col width="65">
				<col width="65">
				<col width="65">
				<col width="65">
				<col width="*">
			</colgroup>
			<tr>
				<th title="Handling Office">HOFC</th>
				<td><input type="text" name="hdlr_ofc_cd" style="width:60px;text-align:center" dataformat="engup" value="" class="input" id="hdlr_ofc_cd" /></td>
				<th>Handler</th>
				<td><input type="text" name="hdlr_usr_id" style="width:60px;text-align:center" value="" class="input" id="hdlr_usr_id" /><button type="button" id="btn1_Handler" name="btn1_Handler" class="input_seach_btn"></button></td>
				<th>Manager</th>
				<td><input type="text" name="mgr_usr_id" style="width:60px;" value="" class="input" id="mgr_usr_id" /> </td>
				<th>LP HOFC</th>
				<td><input type="text" style="width:70px;text-align:left;" name="hndl_ofc_cd" dataformat="engup" value="" class="input" caption="LP HOFC" id="hndl_ofc_cd" /><button type="button" id="btns_hndl_ofc_cd" name="btns_hndl_ofc_cd" class="input_seach_btn"></button></td>
				<th>Liable Party</th>
				<td><input type="text" name="clm_liable_pty_abbr_nm" style="width:60px;" value="" class="input" readonly="readonly" id="clm_liable_pty_abbr_nm" /><button type="button" id="btn1_Liable_Party" name="btn1_Liable_Party" class="input_seach_btn"></button></td>
				<th>Surveyor</th>
				<td><input type="text" name="clm_surveyor_pty_abbr_nm" style="width:70px;" value="" class="input" readonly="readonly" id="clm_surveyor_pty_abbr_nm" /><button type="button" id="btn1_Surveyor" name="btn1_Surveyor" class="input_seach_btn"></button></td>
				<td><input type="hidden" name="labl_clm_pty_no" id="labl_clm_pty_no" /></td>
				<td><input type="hidden" name="svey_clm_pty_no" id="svey_clm_pty_no" /></td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<th title="Receiving Office">ROFC</th>
				<td><input type="text" name="fmal_clm_rcv_ofc_cd" style="width:60px;" dataformat="engup" value="" class="input" id="fmal_clm_rcv_ofc_cd" /></td>
				<th>Claimant</th>
				<td><input type="text" name="clmt_clm_pty_abbr_nm" style="width:60px;" value="" class="input" readonly="readonly" id="clmt_clm_pty_abbr_nm" /><button type="button" id="btn1_Claimant" name="btn1_Claimant" class="input_seach_btn"></button></td>
				<th>Claimant's Agent</th>
				<td><input type="text" name="clmt_clm_agn_pty_abbr_nm" style="width:60px;" value="" class="input" readonly="readonly" id="clmt_clm_agn_pty_abbr_nm" /><button type="button" id="btn1_Claimant_Agent" name="btn1_Claimant_Agent" class="input_seach_btn"></button></td>
				<th>Salvager</th>
				<td><input type="text" name="slv_clm_pty_abbr_nm" style="width:70px;" value="" class="input" readonly="readonly" id="slv_clm_pty_abbr_nm" /><button type="button" id="btn1_Salvager" name="btn1_Salvager" class="input_seach_btn"></button></td>
				<th>Insurer</th>
				<td><input type="text" name="insur_clm_pty_abbr_nm" style="width:60px;" value="" class="input" readonly="readonly" id="insur_clm_pty_abbr_nm" /><button type="button" id="btn1_Insurer" name="btn1_Insurer" class="input_seach_btn"></button></td>
				<th>Approver</th>
				<td><input type="text" name="clm_stl_auth_usr_id" style="width:70px;" value="" class="input" id="clm_stl_auth_usr_id" /><button type="button" id="btn1_Approver" name="btn1_Approver" class="input_seach_btn"></button></td>
				<td><input type="hidden" name="clmt_clm_pty_no" id="clmt_clm_pty_no" /></td>
				<td><input type="hidden" name="slv_clm_pty_no" id="slv_clm_pty_no" /></td>
				<td><input type="hidden" name="insur_clm_pty_no" id="insur_clm_pty_no" /></td>
				<td><input type="hidden" name="clmt_clm_agn_pty_no" id="clmt_clm_agn_pty_no" /></td>
			</tr>
				<tr>
				<th title="Vessel Voyage Direction">VVD</th>
				<td><input type="text" name="trnk_ref_vvd_no" dataformat="engup" style="width:80px;" value="" class="input" id="trnk_ref_vvd_no" /> </td>
				<th title="Place of Receipt">POR</th>
				<td><input type="text" name="por_cd" style="width:60px;" dataformat="engup" value="" class="input" id="por_cd" /><button type="button" id="btn1_POR" name="btn1_POR" class="input_seach_btn"></button></td>
				<th title="Port of Loading">POL</th>
				<td><input type="text" name="pol_cd" style="width:60px;" dataformat="engup" value="" class="input" id="pol_cd" /></td>
				<th title="Port of Discharge">POD</th>
				<td><input type="text" name="pod_cd" style="width:70px;" dataformat="engup" value="" class="input" id="pod_cd" /></td>
				<th title="Place of Delivery">DEL</th>
				<td><input type="text" name="del_cd" style="width:60px;" dataformat="engup" value="" class="input" id="del_cd" /><button type="button" id="btn1_DEL" name="btn1_DEL" class="input_seach_btn"></button></td>
				<th title="Feeder Voyage Direction">FVD</th>
				<td><input type="text" name="fvd" style="width:70px;" dataformat="engup" value="" class="input" id="fvd" /></td>
				<th title="Pre-Carriage Port of Transhipment">PRE-POT</th>
				<td><input type="text" name="n1st_pre_ts_loc_cd" style="width:50px;" dataformat="engup" value="" class="input" id="n1st_pre_ts_loc_cd" /></td>
				<th title="On-Carriage Port of Transhipment">ON-POT</th>
				<td><input type="text" name="n1st_pst_ts_loc_cd" style="width:100px;" dataformat="engup" value="" class="input" id="n1st_pst_ts_loc_cd" /></td>
			</tr>
		</table>
		<table>
			<colgroup>
				<col width="40">
				<col width="50">
				<col width="40">
				<col width="60">
				<col width="50">
				<col width="60">
				<col width="50">
				<col width="75">
				<col width="40">
				<col width="50">
				<col width="70">
				<col width="80">
				<col width="30">
				<col width="50">
				<col width="58">
				<col width="*">
			</colgroup>
			<tr>
				<th title="Carriage Term">CT</th>
				<td><script type="text/javascript">ComComboObject("crr_term_cd", 2, 45, 1);</script></td>
				<th title="Place of Incident">POI</th>
				<td><script type="text/javascript">ComComboObject("inci_plc_tp_cd", 2, 60, 1);</script></td>
				<th>Lane</th>
				<td><input type="text" name="slan_cd" style="width:50px;" value="" class="input" id="slan_cd" /></td>
				<th>Cargo</th>
				<td><input type="text" name="clm_cgo_tp_cd" style="width:30px;" value="" class="input" id="clm_cgo_tp_cd" /><button type="button" id="btn1_Cargo" name="btn1_Cargo" class="input_seach_btn"></button><input type="text" name="clm_cgo_tp_nm" style="width:160px;" value="" class="input2" readonly="readonly" id="clm_cgo_tp_nm" /> </td>
				<th title="Type of Claim">TOC</th>
				<td><script type="text/javascript">ComComboObject("cgo_clm_tp_cd", 2, 60, 1);</script></td>
				<th title="Cause of Damage / Loss">CODL 1</th>
				<td><input type="text" name="mjr_clm_dmg_lss_cd" style="width:52px;" value="" class="input" id="mjr_clm_dmg_lss_cd" /><button type="button" id="btn1_CODL1" name="btn1_CODL1" class="input_seach_btn"></button></td>
				<th title="Cause of Damage / Loss">2</th>
				<td><input type="text" name="minr_clm_dmg_lss_cd" style="width:54px;" value="" class="input" id="minr_clm_dmg_lss_cd" /><button type="button" id="btn1_CODL2" name="btn1_CODL2" class="input_seach_btn"></button></td>
				<th>Litigation</th>
				<td><select style="width:50px;" name="lit"><!--
				--><option value="" selected></option><!--
				--><option value="Y">Y</option><!--
				--><option value="N">N</option><!--
				--></select></td>
			</tr>
		</table>
		<table>
			<colgroup>
				<col width="40">
				<col width="80">
				<col width="40">
				<col width="60">
				<col width="110">
				<col width="260">
				<col width="40">
				<col width="*">
			</colgroup>
			<tr>
				<th title="Type Of Settlement">TOS</th>
				<td><script type="text/javascript">ComComboObject("cgo_clm_stl_tp_cd", 2, 60, 1);</script></td>
				<th>Claim Amount</th>
				<td><input type="text" name="from_clmt_usd_amt" style="width:110px;text-align:right" value="" dataformat="float" class="input" id="from_clmt_usd_amt" /> ~ <input type="text" name="to_clmt_usd_amt" style="width:104px;text-align:right" dataformat="float" value="" class="input" id="to_clmt_usd_amt" /></td>
				<th>Settled Amount</th>
				<td><input type="text" name="from_cgo_clm_stl_usd_amt" style="width:110px;text-align:right" value="" dataformat="float" class="input" id="from_cgo_clm_stl_usd_amt" /> ~ <input type="text" name="to_cgo_clm_stl_usd_amt" style="width:110px;text-align:right" dataformat="float" value="" class="input" id="to_cgo_clm_stl_usd_amt" /> </td>
				<th>INC No.</th>
				<td><input type="text" name="cgo_clm_inci_no" style="width:105px;" value="" class="input" id="cgo_clm_inci_no" /></td>
			</tr>
		</table>
	</div>
</div>
<div class="wrap_result">
	<div class="opus_design_grid" id="mainTable">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
</form>