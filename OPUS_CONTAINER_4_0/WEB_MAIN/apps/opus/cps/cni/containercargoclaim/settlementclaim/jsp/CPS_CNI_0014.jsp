<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CPS_CNI_0014.jsp
*@FileTitle  : Settlement - Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/
=========================================================
*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.clt.apps.opus.cps.cni.containercargoclaim.settlementclaim.event.CpsCni0014Event"%>
<%@ page import="com.clt.apps.opus.cps.cni.common.CniUtil"%>
<%@ page import="com.clt.framework.component.util.io.HttpUtil"%>
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


<%@page import="com.clt.apps.opus.cps.gem.common.GemUtil"%>
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
<input type="hidden" name="cgo_clm_stl_tp_cd" id="cgo_clm_stl_tp_cd" />
<input type="hidden" name="clm_stl_auth_cd" id="clm_stl_auth_cd" />
<input type="hidden" name="insur_rcvr_usd_amt" id="insur_rcvr_usd_amt" />

<input type="hidden" name="usr_id" value="<%=userId%>" id="usr_id" readonly="readonly"/>
<input type="hidden" name="usr_roles" value="<%=roles%>" id="usr_roles" readonly="readonly"/>
<input type="hidden" name="usr_area" value="<%=area%>" id="usr_area" readonly="readonly"/>
<input type="hidden" name="usr_office" value="<%=ofcCd%>" id="usr_office" readonly="readonly"/>
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn1_Retrieve" 		id="btn1_Retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn1_New" 			id="btn1_New">New</button><!-- 
		 --><button type="button" class="btn_normal" name="btn1_Save" 			id="btn1_Save">Save</button><!-- 
		 --><button type="button" class="btn_normal" name="btn1_Cancel" 			id="btn1_Cancel">Cancel</button><!-- 
		 --><button type="button" class="btn_normal" name="btn1_Approval" 			id="btn1_Approval">Approval</button><!-- 
		 --><button type="button" class="btn_normal" name="btn1_Reject" 			id="btn1_Reject">Reject</button><!-- 
		 --><button type="button" class="btn_normal" name="btn1_Payment" 			id="btn1_Payment">Payment</button>			
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
	
</div>
<!-- page_title_area(E) -->
<!-- wrap_search(S) -->
<div class="wrap_search_tab">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry">
	<table>
		<tbody>
			<colgroup>
				<col width="65" />
				<col width="120" />
				<col width="70" />
				<col width="110" />
				<col width="60" />
				<col width="130" />
				<col width="60" />
				<col width="100" />
				<col width="138" />
				<col width="120" />
				<col width="60" />
				<col width="*" />
			</colgroup>
			<tr>
				<th>Claim  No.</th>
				<td><input type="text" style="width:85px;text-align:center" name="cgo_clm_no" value="<%=userCgoClmNo%>" required maxlength="10" caption="Claim  No" dataformat="engup" class="input1" id="cgo_clm_no" /><input type="text" style="width:20px;" name="clm_area_cd" value="" class="input2" readonly id="clm_area_cd" /></td>
				<th title="Handling Office">HOFC</th>
				<td><input type="text" style="width:50px;text-align:center" name="hdlr_ofc_cd" value="" class="input2" readonly id="hdlr_ofc_cd" /></td>
				<th>Handler</th>
				<td><input type="text" style="width:80px;text-align:center" name="hdlr_usr_id" value="" class="input2" readonly id="hdlr_usr_id" /><button type="button" id="btn1_Handler" name="btn1_Handler" class="input_seach_btn"></button></td>
				<th title="Date Of Updated">DOU</th>
				<td><input type="text" style="width:76px;text-align:center" name="upd_dt" value="" class="input2" readonly id="upd_dt" /></td>
				<th>Incident No.</th>
				<td><input type="text" style="width:95px;text-align:center" name="cgo_clm_inci_no" value="" class="input2" readonly id="cgo_clm_inci_no" /></td>
				<th>VOC No.</th>
				<td><input type="text" style="width:100px;text-align:center" name="crm_voc_no" value="" class="input2" readonly id="crm_voc_no" /></td>
			</tr>
		</tbody>
	</table>
	<table>
		<tbody>
			<colgroup>
				<col width="65" />
				<col width="120" />
				<col width="70" />
				<col width="110" />
				<col width="60" />
				<col width="130" />
				<col width="60" />
				<col width="100" />
				<col width="60" />
				<col width="*" />
			</colgroup>
			<tr>
				<th>Status</th>
				<td><input type="text" style="width:90px;;text-align:center" name="clm_misc_nm" value="" class="input2" readonly id="clm_misc_nm" /> <input type="hidden" name="clm_misc_cd" value="" id="clm_misc_cd" /></td>
				<th><span title="Handling Period">HPC</span>/<span title="Net Handling Period">NHP</span></th>
				<td><input type="text" style="width:40px;;text-align:center" name="hpc" value="" class="input2" readonly id="hpc" />/ <input type="text" style="width:40px;text-align:center" name="nhp" value="" class="input2" readonly id="nhp" /></td>
				<th title="Time Barred Date">DOTB</th>
				<td><input type="text" style="width:80px;text-align:center" name="clm_tm_bar_dt" value="" class="input2" readonly id="clm_tm_bar_dt" /></td>
				<th title="LP Time Barred Date">LP DOTB</th>
				<td><input type="text" style="width:80px;text-align:center" name="tm_bar_dt" value="" class="input2" readonly id="tm_bar_dt" /></td>
				<th>Summons Served Date</th>
				<td><input type="text" style="width:100px;%;;text-align:center" name="smns_sve_dt" value="" class="input2" readonly id="smns_sve_dt" /></td>
			</tr>
		</tbody>
	</table>
	<div><table class="line_bluedot"><tr><td colspan="6"></td></tr> </table></div> 
	<table>
		<tbody>
			<colgroup>
				<col width="60" />
				<col width="50" />
				<col width="50" />
				<col width="50" />
				<col width="*" />
			</colgroup>
			<tr>
				<th>Claimant</th>
				<td><input type="hidden" name="clm_pty_no" id="clm_pty_no" /><input type="hidden" name="clm_pty_abbr_nm" id="clm_pty_abbr_nm" /><input type="text" style="width:220px;" name="pty_nm" value="" class="input2" readonly id="pty_nm" /></td>
				<td><button type="button" class="btn_etc" id="btns_style" name="btns_style" >Style</button></td>
				<th>Type</th>
				<td><input type="text" style="width:35px;text-align:center" name="" value="" class="input2" readonly id="" /></td>
			</tr>
		</tbody>
	</table>
	<table>
		<tbody>
			<colgroup>
				<col width="60" />
				<col width="50" />
				<col width="176" />
				<col width="73" />
				<col width="50" />
				<col width="50" />
				<col width="50" />
				<col width="50" />
				<col width="50" />
				<col width="50" />
				<col width="50" />
				<col width="*" />
			</colgroup>
			<tr>
				<th>Cargo</th>
				<td><input type="text" style="width:150px;text-align:left" name="cgo_qlty_desc" value="" class="input2" readonly id="cgo_qlty_desc" /> 
				<input type="hidden" name="clm_cgo_tp_cd" id="clm_cgo_tp_cd" /></td>
				<th title="Type of Cargo Claim">TOC</th>
				<td><input type="text" style="width:35px;text-align:center" name="cgo_clm_tp_cd" value="" class="input2" readonly id="cgo_clm_tp_cd" /></td>
				<th title="Cause of Damage / Loss">CODL 1</th>
				<td><input type="text" style="width:35px;text-align:center" name="mjr_clm_dmg_lss_cd" value="" class="input2" readonly id="mjr_clm_dmg_lss_cd" /></td>
				<th title="Cause of Damage / Loss">2</th>
				<td><input type="text" style="width:35px;text-align:center" name="minr_clm_dmg_lss_cd" value="" class="input2" readonly id="minr_clm_dmg_lss_cd" /></td>
				<th title="Place of Incident">POI</th>
				<td><input type="text" style="width:35px;text-align:center" name="inci_plc_tp_cd" value="" class="input2" readonly id="inci_plc_tp_cd" /></td>
				<th title="Date of Incident">DOI</th>
				<td><input type="text" style="width:100px;text-align:center" name="inci_occr_dt" value="" class="input2" readonly id="inci_occr_dt" /></td>
			</tr>
		</tbody>
	</table>
	<table>
		<tbody>
			<colgroup>
				<col width="60">
				<col width="90">
				<col width="50">
				<col width="147">
				<col width="135">
				<col width="150">
				<col width="124">
				<col width="*">
			</colgroup>
			<tr>
				<th title="Type Of Settlement">TOS</th>
				<td><script type="text/javascript">ComComboObject("combo1", 2, 60, 1,1);</script></td>
				<th title="Date Of Settlement">DOS</th>
				<td><input type="text" style="width:80px;text-align:center" name="cgo_clm_stl_dt" dataformat="ymd" maxlength="10" value="" class="input1" required="" caption="DOS" id="cgo_clm_stl_dt" /><button type="button" id="btns_cgo_clm_stl_dt" name="btns_cgo_clm_stl_dt" class="calendar ir"></button></td>
				<th>Settled Amount</th>
				<td><input type="text" style="width:130px;text-align:right" name="cgo_clm_stl_locl_amt" value="" class="input1" required dataFormat="float" caption="Settled Amount" id="cgo_clm_stl_locl_amt" /><input type="text" style="width:40px;text-align:center" dataformat="enguponly" name="cgo_clm_stl_locl_curr_cd" value="" class="input1" maxlength="3" minlength="3" onblur="javascript:setCurrRt()" id="cgo_clm_stl_locl_curr_cd" /><button type="button" id="btns_currency" name="btns_currency" class="input_seach_btn"></button></td>
				<th title="Rate of Exchange">R.O.E</th>
				<td class="stm"><input type="text" style="width:66px;text-align:right" name="cgo_clm_stl_xch_rt"  value="" class="input1" required caption=" R.O.E" id="cgo_clm_stl_xch_rt" /><button type="button" id="btns_roe" name="btns_roe" class="input_seach_btn"></button><input type="text" style="width:130px;text-align:right" name="cgo_clm_stl_usd_amt" value="" class="input2" readonly id="cgo_clm_stl_usd_amt" /></td>
			</tr>
		</tbody>
	</table>
    <table>
		<tbody>
			<colgroup>
				<col width="200">
				<col width="147">
				<col width="50">
				<col width="150">
				<col width="153">
				<col width="*">
			</colgroup>
			<tr>
				<th title="Date of Formal Claim">DOF</th>
				<td><input type="text" style="width:79px;text-align:center" name="fmal_clm_rcv_dt" value="" class="input2" readonly id="fmal_clm_rcv_dt" /> </td>
				<th>Claim Amount</th>
				<td><input type="text" style="width:130px;text-align:right" name="clmt_locl_amt" value="" class="input2" readonly id="clmt_locl_amt" /><input type="text" style="width:40px;text-align:center" name="clmt_locl_curr_cd" value="" class="input2" readonly id="clmt_locl_curr_cd" /> </td>
				<th title="Rate of Exchange">R.O.E</th>
				<td><input type="text" style="width:66px;text-align:right" name="clmt_locl_xch_rt" value="" class="input2" readonly id="clmt_locl_xch_rt" /><input type="text" style="width:130px;text-align:right" name="clmt_usd_amt" value="" class="input2" readonly id="clmt_usd_amt" />   USD</td>
			</tr>
			<tr>
				<th title="LP Date of Formal Claim">LP DOF</th>
				<td><input type="text" style="width:79px;text-align:center" name="labl_pty_fmal_clm_dt" value="" class="input2" readonly id="labl_pty_fmal_clm_dt" /> </td>
				<th>LP Claim Amount</th>
				<td><input type="text" style="width:130px;text-align:right" name="labl_pty_dmnd_amt" value="" class="input2" readonly id="labl_pty_dmnd_amt" /><input type="text" style="width:40px;text-align:center" name="labl_pty_dmnd_curr_cd" value="" class="input2" readonly id="labl_pty_dmnd_curr_cd" /> </td>
				<th title="Rate of Exchange">R.O.E</th>
				<td><input type="text" style="width:66px;text-align:right" name="labl_pty_xch_rt" value="" class="input2" readonly id="labl_pty_xch_rt" /><input type="text" style="width:130px;text-align:right" name="labl_pty_dmnd_usd_amt" value="" class="input2" readonly id="labl_pty_dmnd_usd_amt" />   USD</td>
			</tr>
			<tr>
				<th title="LP Date of Receipt">LP DOR</th>
				<td><input type="text" style="width:79px;text-align:center" name="labl_pty_rcvr_dt" value="" class="input2" readonly id="labl_pty_rcvr_dt" /> </td>
				<th>LP Recovered Amount</th>
				<td><input type="text" style="width:130px;text-align:right" name="labl_pty_rcvr_locl_amt" value="" class="input2" readonly id="labl_pty_rcvr_locl_amt" /><input type="text" style="width:40px;text-align:center" name="labl_pty_rcvr_locl_curr_cd" value="" class="input2" readonly id="labl_pty_rcvr_locl_curr_cd" /> </td>
				<th title="Rate of Exchange">R.O.E</th>
				<td><input type="text" style="width:66px;text-align:right" name="labl_pty_rcvr_locl_xch_rt" value="" class="input2" readonly id="labl_pty_rcvr_locl_xch_rt" /><input type="text" style="width:130px;text-align:right" name="labl_pty_rcvr_usd_amt" value="" class="input2" readonly id="labl_pty_rcvr_usd_amt" />   USD</td>
			</tr>
		</tbody>
	</table>
</div>
<!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_search(E) -->
<!-- wrap_result(S) -->
<div class="wrap_result">
	<div class="opus_design_tab">
	<script type="text/javascript">ComTabObject('tab1')</script>
	</div>
	<div id="tabLayer">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table>
			<tbody>
				<colgroup>	
					<col width="*" />
				</colgroup>
				<tr>
					<td><textarea style="width:100%" name="cgo_clm_stl_desc" id="cgo_clm_stl_desc" required rows="15" class="textarea" ></textarea></td>
				</tr>
			</tbody>
		</table>
		<table>
			<tbody>
				<colgroup>
					<col width="50" />
					<col width="50" />
					<col width="50" />
					<col width="50" />
					<col width="50" />
					<col width="50" />
					<col width="50" />
					<col width="50" />
					<col width="50" />
					<col width="50" />
					<col width="50" />
					<col width="*" />
				</colgroup>
				<tr>
					<th>Applied on</th>
					<td><input type="text" style="width:80px;text-align:center" name="clm_stl_appl_dt" value="" class="input2" readonly id="clm_stl_appl_dt" /> </td>
					<th>by</th>
					<td><input type="text" style="width:80px;text-align:center" name="clm_stl_appl_usr_id" value="" class="input2" readonly id="clm_stl_appl_usr_id" /> </td>
					<th>for</th>
					<td><input type="text" style="width:58px;text-align:center" name="clm_stl_appl_ofc_cd" value="" class="input2" readonly id="clm_stl_appl_ofc_cd" /> </td>
					<th>Approved on</th>
					<td><input type="text" style="width:80px;text-align:center" name="clm_stl_auth_dt" value="" class="input2" readonly id="clm_stl_auth_dt" /> </td>
					<th>by</th>
					<td><input type="text" style="width:80px;text-align:center" name="clm_stl_auth_usr_id" value="" class="input2" readonly id="clm_stl_auth_usr_id" /> </td>
					<th>for</th>
					<td><input type="text" style="width:58px;text-align:center" name="clm_stl_auth_ofc_cd" value="" class="input2" readonly id="clm_stl_auth_ofc_cd" /> </td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
	</div>
	<div id="tabLayer" style ="display:none">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table>
			<tbody>
				<colgroup>	
					<col width="*" />
				</colgroup>
				<tr>
					<td><textarea style="width:100%" name="clm_stl_auth_rmk" id="clm_stl_auth_rmk" rows="15" class="textarea2" ></textarea></td>
				</tr>
			</tbody>
		</table>
		<table>
			<tbody>
				<colgroup>
					<col width="50" />
					<col width="50" />
					<col width="50" />
					<col width="50" />
					<col width="50" />
					<col width="50" />
					<col width="50" />
					<col width="50" />
					<col width="50" />
					<col width="50" />
					<col width="50" />
					<col width="*" />
				</colgroup>
				<tr>
					<th>Applied on </th>
					<td><input type="text" style="width:80px;text-align:center" name="clm_stl_appl_dt3" value="" class="input2" readonly id="clm_stl_appl_dt3" /> </td>
					<th>by</th>
					<td><input type="text" style="width:80px;text-align:center" name="clm_stl_appl_usr_id3" value="" class="input2" readonly id="clm_stl_appl_usr_id3" /> </td>
					<th>for</th>
					<td><input type="text" style="width:58px;text-align:center" name="clm_stl_appl_ofc_cd3" value="" class="input2" readonly id="clm_stl_appl_ofc_cd3" /> </td>
					<th>Approved on</th>
					<td><input type="text" style="width:80px;text-align:center" name="clm_stl_auth_dt3" value="" class="input2" readonly id="clm_stl_auth_dt3" /> </td>
					<th>by</th>
					<td><input type="text" style="width:80px;text-align:center" name="clm_stl_auth_usr_id3" value="" class="input2" readonly id="clm_stl_auth_usr_id3" /> </td>
					<th>for</th>
					<td><input type="text" style="width:58px;text-align:center" name="clm_stl_auth_ofc_cd3" value="" class="input2" readonly id="clm_stl_auth_ofc_cd3" /> </td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
	</div>
	<div id="tabLayer" style= "display:none">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table>
			<tbody>
				<colgroup>	
					<col width="*" />
				</colgroup>
				<tr>
					<td><textarea style="resize: none; width:100%" name="cgo_clm_stl_rmk" id="cgo_clm_stl_rmk" rows="15" class="textarea1" readonly caption="Opinion on Settlement"></textarea></td>
				</tr>
			</tbody>
		</table>
		<table>
			<tbody>
				<colgroup>
					<col width="50" />
					<col width="50" />
					<col width="50" />
					<col width="50" />
					<col width="50" />
					<col width="50" />
					<col width="50" />
					<col width="50" />
					<col width="50" />
					<col width="50" />
					<col width="50" />
					<col width="*" />
				</colgroup>
				<tr>
					<th>Applied on</th>
					<td><input type="text" style="width:80px;text-align:center" name="clm_stl_appl_dt2" value="" class="input2" readonly id="clm_stl_appl_dt2" /> </td>
					<th>by</th>
					<td><input type="text" style="width:80px;text-align:center" name="clm_stl_appl_usr_id2" value="" class="input2" readonly id="clm_stl_appl_usr_id2" /> </td>
					<th>for</th>
					<td><input type="text" style="width:58px;text-align:center" name="clm_stl_appl_ofc_cd2" value="" class="input2" readonly id="clm_stl_appl_ofc_cd2" /> </td>
					<th>Approved on</th>
					<td><input type="text" style="width:80px;text-align:center" name="clm_stl_auth_dt2" value="" class="input2" readonly id="clm_stl_auth_dt2" /> </td>
					<th>by</th>
					<td><input type="text" style="width:80px;text-align:center" name="clm_stl_auth_usr_id2" value="" class="input2" readonly id="clm_stl_auth_usr_id2" /> </td>
					<th>for</th>
					<td><input type="text" style="width:58px;text-align:center" name="clm_stl_auth_ofc_cd2" value="" class="input2" readonly id="clm_stl_auth_ofc_cd2" /></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
	</div>
	<div class="opus_design_grid">
	<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(E) -->

		
</form>

