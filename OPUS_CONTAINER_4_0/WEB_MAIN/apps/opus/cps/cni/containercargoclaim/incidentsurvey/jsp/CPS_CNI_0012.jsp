<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : cps_cni_0012.jsp
*@FileTitle  : [CPS_CNI_0012] Survey
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/24
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@page import="com.clt.apps.opus.cps.cni.containercargoclaim.incidentsurvey.event.CpsCni0012Event"%>
<%@page import="com.clt.apps.opus.cps.cni.common.CniUtil"%>
<%@page import="com.clt.framework.component.util.io.HttpUtil"%>
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

    Logger log = Logger.getLogger("com.clt.apps.opus.cps.cni.containercargoclaim.ContainerCargoClaimSC");
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
<%@page import="com.clt.framework.component.util.StringUtil"%>
<script type="text/javascript">
function setupPage(){
	var errMessage = "<%=strErrMsg%>";
	if (errMessage.length >= 1) {
		showErrMessage(errMessage);
	} // end if
	loadPage();
}
</script>
<form name="form2">
<input type="hidden" name="sXml" value="<%=xml%>" id="sXml" />
</form>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="clss_clm_misc_cd" id="clss_clm_misc_cd" />

<input type="hidden" name="cgo_clm_no_old" value="" id="cgo_clm_no_old" />

<input type="hidden" name="usr_id" value="<%=userId%>" id="usr_id" readonly="readonly"/>
<input type="hidden" name="usr_roles" value="<%=roles%>" id="usr_roles" readonly="readonly"/>
<input type="hidden" name="usr_area" value="<%=area%>" id="usr_area" readonly="readonly"/>
<input type="hidden" name="usr_office" value="<%=ofcCd%>" id="usr_office" readonly="readonly"/>
<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
	<button class="btn_accent" name="btn1_Retrieve" id="btn1_Retrieve" type="button">Retrieve</button><!--
	--><button class="btn_normal" name="btn1_New" id="btn1_New" type="button">New</button><!--
	--><button class="btn_normal" name="btn1_Save" id="btn1_Save" type="button">Save</button><!--
	--><button class="btn_normal" name="btn1_Handling_Costs" id="btn1_Handling_Costs" type="button">Handling Costs</button><!--
	--></div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table>
			<colgroup>
				<col width="100" />				
				<col width="123" />				
				<col width="75" />				
				<col width="100" />				
				<col width="50" />				
				<col width="135" />				
				<col width="30" />				
				<col width="100" />				
				<col width="75" />				
				<col width="110" />				
				<col width="140" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
		   		<th>Claim  No.</th>
					<td><input type="text" style="width:85px;text-align:center" dataformat="engup" name="cgo_clm_no" value="<%=userCgoClmNo%>" required="" maxlength="10" caption="Claim  No" onkeypress="ComKeyOnlyAlphabet('uppernum')" class="input1" id="cgo_clm_no" /><input type="text" style="width:20px;" name="clm_area_cd" value="" class="input2" readonly id="clm_area_cd" /> </td>
					<th title="Handling Office">HOFC</th>
					<td><input type="text" style="width:50px;text-align:center" name="hdlr_ofc_cd" value="" class="input2" readonly id="hdlr_ofc_cd" /> </td>
					<th>Handler</th>
					<td><input type="text" style="width:90px;text-align:center" name="hdlr_usr_id" value="" class="input2" readonly id="hdlr_usr_id" /><button type="button" id="btn1_Handler" name="btn1_Handler" class="input_seach_btn"></button></td>
					<th title="Date Of Updated">DOU</th>
					<td><input type="text" style="width:76px;text-align:center" name="upd_dt" value="" class="input2" readonly id="upd_dt" /> </td>
					<th>Incident No.</th>
					<td><input type="text" style="width:90px;text-align:center" name="cgo_clm_inci_no" value="" class="input2" readonly id="cgo_clm_inci_no" /> </td>
					<th>VOC No.</th>
					<td><input type="text" style="width:169px;text-align:center" name="crm_voc_no" value="" class="input2" readonly id="crm_voc_no" /> </td>
		   		</tr>
		   </tbody>
		</table>
		<table>
			<colgroup>
				<col width="100" />				
				<col width="123" />				
				<col width="75" />				
				<col width="100" />				
				<col width="51" />				
				<col width="135" />				
				<col width="30" />				
				<col width="100" />				
				<col width="74" />				
				<col width="110" />				
				<col width="140" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
		   		<th>Status</th>
					<td><input type="text" style="width:88px;text-align:center" name="clm_misc_nm" value="" class="input2" readonly id="clm_misc_nm" /> <input type="hidden" name="clm_misc_cd" value="" id="clm_misc_cd" /> </td>
					<th title="Handling Period / Net Handling Period">&nbsp; HPC / NHP</th>
					<td><input type="text" style="width:40px;text-align:center" name="hpc" value="" class="input2" readonly id="hpc" />/ <input type="text" style="width:40px;text-align:center" name="nhp" value="" class="input2" readonly id="nhp" /> </td>
					<th title="Type Of Settlement">TOS</th>
					<td><input type="text" style="width:45px;text-align:center" name="cgo_clm_stl_tp_cd" value="" class="input2" readonly id="cgo_clm_stl_tp_cd" /> </td>
					<th title="Date Of Close">DOC</th>
					<td><input type="text" style="width:76px;text-align:center" name="cs_clz_dt" value="" class="input2" readonly id="cs_clz_dt" /> </td>
					<th title="Time Bar Date">T/B Date</th>
					<td><input type="text" style="width:90px;text-align:center" name="clm_tm_bar_dt" value="" class="input2" readonly id="clm_tm_bar_dt" /> </td>
					<th>Summons Served Date</th>
					<td><input type="text" style="width:100px;text-align:center" name="smns_sve_date" value="" class="input2" readonly id="smns_sve_date" /> </td>
		   		</tr>
		   </tbody>
		</table>
		<table>
			<colgroup>
				<col width="100" />				
				<col width="123" />				
				<col width="75" />				
				<col width="55" />				
				<col width="30" />				
				<col width="90" />				
				<col width="50" />				
				<col width="250" />				
				<col width="101" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
		   		<th title="Type of Claim">TOC</th>
					<td><input type="text" style="width:50px;text-align:center" name="cgo_clm_tp_cd" value="" class="input2" readonly id="cgo_clm_tp_cd" /> </td>
					<th title="Cause of Damage or Loss">CODL 1</th>
					<td><input type="text" style="width:40px;text-align:center" name="mjr_clm_dmg_lss_cd" value="" class="input2" readonly id="mjr_clm_dmg_lss_cd" /> </td>
					<th> 2</th>
					<td><input type="text" style="width:40px;text-align:center" name="minr_clm_dmg_lss_cd" value="" class="input2" readonly id="minr_clm_dmg_lss_cd" /> </td>
					<th> Cargo</th>
					<td><input type="text" style="width:45px;text-align:center" name="clm_cgo_tp_cd" value="" class="input2" readonly id="clm_cgo_tp_cd" /><input type="text" style="width:195px;" name="cgo_qlty_desc" value="" class="input2" readonly id="cgo_qlty_desc" /> </td>
					<th> Claim Amount</th>
					<td><input type="text" style="width:165px;text-align:right" name="clmt_usd_amt" value="" class="input2" readonly dataformat="float" id="clmt_usd_amt" />   USD</td>
		   		</tr>
		   </tbody>
		</table>
		<table>
			<colgroup>
				<col width="100">				
				<col width="123">				
				<col width="75">				
				<col width="55">				
				<col width="30">				
				<col width="90">				
				<col width="50">				
				<col width="252">				
				<col width="101">				
				<col width="*">				
		   </colgroup>
		   <tbody>
		   		<tr>
		   		<th>Lane</th>
					<td><input type="text" style="width:50px;text-align:center" name="slan_cd" value="" class="input2" readonly id="slan_cd" /> </td>
					<th title="Place of Incident">POI</th>
					<td><input type="text" style="width:40px;text-align:center" name="clm_inci_plc_tp_cd" value="" class="input2" readonly id="clm_inci_plc_tp_cd" /> </td>
					<th title="Date of Incident">DOI</th>
					<td><input type="text" style="width:80px;text-align:center" name="inci_occr_dt" value="" class="input2" readonly dataformat="ymd" id="inci_occr_dt" /> </td>
					<th>Insurer</th>
					<td><input type="text" style="width:53px;text-align:center" name="clm_pty_abbr_nm1" value="" class="input2" readonly id="clm_pty_abbr_nm1" /> </td>
					<th>Insurer Ref No.</th>
					<td><input type="text" style="width:225px;text-align:center" name="insur_ref_no" value="" class="input2" readonly id="insur_ref_no" /> </td>
		   		</tr>
		   </tbody>
		</table>
		<table class="line_bluedot"><tr><td></td></tr></table>
		<table>
			<colgroup>
				<col width="100">				
				<col width="333">				
				<col width="120">				
				<col width="73">				
				<col width="115">				
				<col width="75">				
				<col width="50">				
				<col width="*">				
								
		   </colgroup>
		   <tbody>
		   		<tr>
		   			<th>Surveyor</th>
					<td><input type="hidden" style="width:80px;" name="clm_pty_no" value="" class="input1" required="" caption="Surveyor" id="clm_pty_no" /> <input type="text" style="width:80px;" name="clm_pty_abbr_nm2" value="" class="input1" readonly required="" caption="Surveyor" id="clm_pty_abbr_nm2" /><button type="button" id="btns_surveyor" name="btns_surveyor" class="input_seach_btn"></button><input type="text" style="width:220px;" name="pty_nm" value="" class="input2" readonly id="pty_nm" /> </td>
					<td><button class="btn_etc" name="btns_style" id="btns_style" type="button">Style</button></td>
					<th>Type</th>
					<td><script type="text/javascript">ComComboObject("svyr_tp_cd", 2, 50, 1);</script></td>
					<th>SV Ref No.</th>
					<td><input type="text" style="width:100px;text-align:center;ime-mode:disabled" name="ref_svyr_no" value="" class="input" maxlength="20" id="ref_svyr_no" /> </td>
					<td><button class="btn_etc" name="btn1_File_Upload" id="btn1_File_Upload" type="button">File Upload</button></td>
		   		</tr>
		   </tbody>
		</table>
		<table>
			<colgroup>
				<col width="100">				
				<col width="119">				
				<col width="163">				
				<col width="137">				
				<col width="115">				
				<col width="115">				
				<col width="75">				
				<col width="*">					
		   </colgroup>
		   <tbody>
		   		<tr>
		   			<th>Appointed  Date</th>
					<td><input type="text" style="width:76px;text-align:center" name="svyr_apnt_dt" value="" class="input" dataformat="ymd" maxlength="10"  id="svyr_apnt_dt" /><button type="button" id="btns_date_cal1" name="btns_date_cal1" class="calendar ir"></button></td>
					<th>Surveyed Date</th>
					<td><input type="text" style="width:78px;text-align:center" name="svey_inp_dt" value="" class="input" dataformat="ymd" maxlength="10"  id="svey_inp_dt" /><button type="button" id="btns_date_cal2" name="btns_date_cal2" class="calendar ir"></button></td>
					<th>SV Updater</th>
					<td><input type="text" style="width:70px;text-align:center" name="upd_usr_id" value="" readonly class="input2" id="upd_usr_id" /> </td>
					<th>SV DOU</th>
					<td><input type="text" style="width:100px;text-align:center" name="upd_dt2" value="" readonly class="input2" id="upd_dt2" /> </td>
		   		</tr>
		   </tbody>
		</table>
		<table>
			<colgroup>
				<col width="100">				
				<col width="211">				
				<col width="100">				
				<col width="211">				
				<col width="35">				
				<col width="*">				
		   </colgroup>
		   <tbody>
		   		<tr>
		   			<th>Survey Fee</th>
					<td><input type="text" style="width:146px;text-align:right;ime-mode:disabled" class="input2" name="svyr_fee_usd_amt" value="" dataformat="float" maxlength="19" pointcount="2" readonly id="svyr_fee_usd_amt" />   USD</td>
					<th>Equivalent to</th>
					<td><input type="text" style="width:130px;text-align:right;ime-mode:disabled" class="input2" name="svyr_fee_locl_amt" value="" dataformat="float" maxlength="19" pointcount="2" caption="Survey Fee" readonly id="svyr_fee_locl_amt" /><input type="text" style="width:38px;" class="input" name="svyr_locl_curr_cd" value="" maxlength="3" minlength="3" id="svyr_locl_curr_cd" dataformat="enguponly" /><button type="button" id="btns_currency" name="btns_currency" class="input_seach_btn"></button></td>
					<th title="Rate of Exchange">R.O.E</th>
					<td><input type="text" style="width:70px;text-align:right;ime-mode:disabled" class="input" name="svyr_xch_rt" value="" dataformat="float" maxlength="12" pointcount="5" caption="R.O.E" id="svyr_xch_rt" /><button type="button" id="btns_roe" name="btns_roe" class="input_seach_btn"></button> </td>
		   		</tr>
		   </tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid wFit">
		<h3 class="title_design mar_btm_8">Surveyor's Fact Finding</h3>
		<textarea name="svyr_fact_fnd_desc" caption="Surveyor's Fact Finding" style="width:101%;ime-mode:disabled" rows="20" class="textarea1" required></textarea>
	</div>
</div>
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" style="display: none;">
		<script type="text/javascript">ComSheetObject('sheet1');</script>	
	</div>
</div>

</form>
