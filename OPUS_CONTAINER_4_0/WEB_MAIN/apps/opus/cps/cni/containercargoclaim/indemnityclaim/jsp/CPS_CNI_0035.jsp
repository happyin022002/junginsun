<%
/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName : cps_cni_0035.jsp
 *@FileTitle: [CPS_CNI_0035] View-Indemnity Claim
 *@author   : CLT
 *@version  : 1.0
 *@since    : 2014/06/23
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
<%@page import="com.clt.apps.opus.cps.cni.containercargoclaim.indemnityclaim.event.CpsCni0015Event"%>
<%@page import="com.clt.apps.opus.cps.cni.common.CniUtil"%>
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

    Logger log = Logger.getLogger("com.clt.apps.opus.cps.cni.containercargoclaim.ContainerCargoClaimSC");

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


<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn1_Retrieve" id="btn1_Retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn1_New" id="btn1_New" type="button">New</button><!--
		--><button class="btn_normal" name="btn1_Payment" id="btn1_Payment" type="button">Payment</button><!--
		--><button class="btn_normal" name="btn1_Handling_Costs" id="btn1_Handling_Costs" type="button">Handling Costs</button>
	</div>
	<!-- opus_design_btn (E) -->
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->


<div class= "wrap_search">

	
	<!-- opus_design_inquiry(S) -->
		<div class= "opus_design_inquiry wFit">
			<table>
				<tbody>
					<colgroup>
						<col width="70"/>
						<col width="100"/>
						<col width="60"/>
						<col width="70"/>
						<col width="60"/>
						<col width="90"/>
						<col width="60"/>
						<col width="90"/>
						<col width="80"/>
						<col width="100"/>
						<col width="90"/>
						<col width="*"/>
				    </colgroup>
					<tr>
						<th>Claim  No.</th>
						<td><input type="text" style="width:80px;;text-align:center" name="cgo_clm_no" value="<%=userCgoClmNo%>" required="" maxlength="10" caption="Claim  No" onkeypress="ComKeyOnlyAlphabet('uppernum')" class="input1" id="cgo_clm_no" /><!-- 
							 --><input type="text" style="width:25px;" name="clm_area_cd" value="" class="input2" readonly id="clm_area_cd" /></td>
						<th title="Handling Office">HOFC</th>
						<td><input type="text" style="width:50px;;text-align:center" name="hdlr_ofc_cd" value="" class="input2" readonly id="hdlr_ofc_cd" /> </td>
						<th>Handler</th>
						<td><input type="text" style="width:75px;;text-align:center" name="hdlr_usr_id" value="" class="input2" readonly id="hdlr_usr_id" /><button type="button" id="btn1_Handler" name="btn1_Handler" class="input_seach_btn"></button></td>
						<th title="Date Of Updated">DOU</th>
						<td><input type="text" style="width:76px;;text-align:center" name="upd_dt" value="" class="input2" readonly id="upd_dt" /> </td>
						<th>Incident No.</th>
						<td><input type="text" style="width:90px;;text-align:center" name="cgo_clm_inci_no" value="" class="input2" readonly id="cgo_clm_inci_no" /> </td>
						<th>VOC No.</th>
						<td><input type="text" style="width:152px;;text-align:center" name="crm_voc_no" value="" class="input2" readonly id="crm_voc_no" /> </td>
					</tr>
				</tbody>
			</table>
			<table >
				<tbody>
					<colgroup>
						<col width="70"/>
						<col width="100"/>
						<col width="60"/>
						<col width="70"/>
						<col width="90"/>
						<col width="60"/>
						<col width="55"/>
						<col width="90"/>
						<col width="80"/>
						<col width="100"/>
						<col width="140"/>
						<col width="*"/>
				    </colgroup>
					<tr >
						<th>Status</th>
						<td><input type="text" style="width:110px;text-align:center" name="clm_misc_nm" value="" class="input2" readonly id="clm_misc_nm" /><!-- 
							 --><input type="hidden" name="clm_misc_cd" value="" id="clm_misc_cd" /></td>
						<td><span title="Handling Period"><b>HPD</b></span>/&nbsp;<span title="Net Handling Period"><b>NHP</b></span></td>
						<td><input type="text" style="width:40px;;text-align:center" name="hpc" value="" class="input2" readonly id="hpc" />/&nbsp;<input type="text" style="width:40px;text-align:center" name="nhp" value="" class="input2" readonly id="nhp" /> </td>
						<th title="Type Of Settlement">TOS</th>
						<td><input type="text" style="width:47px;;text-align:center" name="cgo_clm_stl_tp_cd" value="" class="input2" readonly id="cgo_clm_stl_tp_cd" /> </td>
						<th title="Date Of Close">DOC</th>
						<td><input type="text" style="width:76px;;text-align:center" name="cs_clz_dt" value="" class="input2" readonly id="cs_clz_dt" /> </td>
						<th title="Time Bar Date">DOTB</th>
						<td><input type="text" style="width:88px;text-align:center" name="clm_tm_bar_dt" value="" class="input2" readonly id="clm_tm_bar_dt" /> </td>
						<th>Summons Served Date</th>
						<td><input type="text" style="width:100px;;text-align:center" name="smns_sve_date" value="" class="input2" readonly id="smns_sve_date" /> </td>
					</tr>
					
				</tbody>
			</table>
			<table >
				<tbody>
					<colgroup>
						<col width="70"/>
						<col width="180"/>
						<col width="50"/>
						<col width="60"/>
						<col width="75"/>
						<col width="90"/>
						<col width="50"/>
						<col width="60"/>
						<col width="70"/>
						<col width="50"/>
						<col width="110"/>
						<col width="*"/>
				    </colgroup>
				    <tr>
						<th>B/L No.</th>
						<td><input type="text" style="width:95px;" name="cgo_clm_ref_bl_no" value="" class="input2" readonly id="cgo_clm_ref_bl_no" /><!-- 
							 --><button type="button" class="btn_etc" name="btn_BLPreview" id="btn_BLPreview">B/L View</button></td>
						<th>Term</th>
						<td><input type="text" style="width:40px;text-align:center" name="crr_term_cd" value="" class="input2" readonly id="crr_term_cd" /> </td>
						<th title="Place of Receipt/Date of Receipt">POR/DOR</th>
						<td><input type="text" style="width:47px;" name="por_cd" value="" class="input2" readonly id="por_cd" />/&nbsp;<input type="text" style="width:75px;" name="rct_dt" value="" class="input2" readonly id="rct_dt" /> </td>
						<th title="Port of Loading">POL</th>
						<td><input type="text" style="width:50px;" name="pol_cd" value="" class="input2" readonly id="pol_cd" /> </td>
						<th title="Port of Discharging">POD</th>
						<td><input type="text" style="width:54px;" name="pod_cd" value="" class="input2" readonly id="pod_cd" /></td>
						<td style="text-align:right"><span title="Place of Delivery"><b>DEL</b></span><b>/DDL</b></td>
						<td><input type="text" style="width:50px;" name="del_cd" value="" class="input2" readonly id="del_cd" />/&nbsp;<input type="text" style="width:75px;" name="de_dt" value="" class="input2" readonly id="de_dt" /> </td>
					</tr>
					
				</tbody>
			</table>
			<table>
				<tbody>
					<colgroup>
						<col width="70"/>
						<col width="60"/>
						<col width="70"/>
						<col width="60"/>
						<col width="40"/>
						<col width="70"/>
						<col width="65"/>
						<col width="60"/>
						<col width="60"/>
						<col width="90"/>
						<col width="90"/>
						<col width="*"/>
				    </colgroup>
					<tr>
						<th title="Type of Claim">TOC</th>
						<td><input type="text" style="width:50px;;text-align:center" name="cgo_clm_tp_cd" value="" class="input2" readonly id="cgo_clm_tp_cd" /> </td>
						<th title="Cause of Damage or Loss">CODL 1</th>
						<td><input type="text" style="width:40px;;text-align:center" name="mjr_clm_dmg_lss_cd" value="" class="input2" readonly id="mjr_clm_dmg_lss_cd" /> </td>
						<th title="Cause of Damage / Loss">2</th>
						<td><input type="text" style="width:40px;;text-align:center" name="minr_clm_dmg_lss_cd" value="" class="input2" readonly id="minr_clm_dmg_lss_cd" /> </td>
						<th title="Place of Incident">POI</th>
						<td><input type="text" style="width:46px;;text-align:center" name="inci_plc_tp_cd" value="" class="input2" readonly id="inci_plc_tp_cd" /> </td>
						<th title="Date of Incident">DOI</th>
						<td><input type="text" style="width:76px;;text-align:center" name="inci_occr_dt" value="" class="input2" readonly id="inci_occr_dt" /> </td>
						<th>Cargo</th>
						<td><input type="text" style="width:325px;;text-align:left" name="cgo_qlty_desc" value="" class="input2" readonly id="cgo_qlty_desc" />&nbsp;<input type="hidden" name="clm_cgo_tp_cd" id="clm_cgo_tp_cd" /></td>
					</tr>
				</tbody>
			</table>
			<table>
				<tbody>
					<colgroup>
						<col width="70"/>
						<col width="200"/>
						<col width="60"/>
						<col width="120"/>
						<col width="60"/>
						<col width="*"/>
				    </colgroup>
					<tr class="h23">
						<th>Claim Amount</th>
						<td><input type="text" style="width:132px;text-align:right" name="clmt_locl_amt" value="" class="input2" readonly id="clmt_locl_amt" /><input type="text" style="width:40px;;text-align:center" name="clmt_locl_curr_cd" value="" class="input2" readonly id="clmt_locl_curr_cd" /> </td>
						<th title="Date of Formal Claim">DOF</th>
						<td><input type="text" style="width:76px;text-align:center" name="fmal_clm_rcv_dt" value="" class="input2" readonly id="fmal_clm_rcv_dt" /> </td>
						<th> R.O.E</th>
						<td><input type="text" style="width:70px;text-align:right" name="clmt_locl_xch_rt" value="" class="input2" readonly id="clmt_locl_xch_rt" /><input type="text" style="width:160px;text-align:right" name="clmt_usd_amt" value="" class="input2" readonly id="clmt_usd_amt" /><b>USD</b></td>
					</tr>
					<tr class="h23">
						<th>Settled Amount</th>
						<td><input type="text" style="width:132px;text-align:right" name="cgo_clm_stl_locl_amt" value="" class="input2" readonly id="cgo_clm_stl_locl_amt" /><input type="text" style="width:40px;;text-align:center" name="cgo_clm_stl_locl_curr_cd" value="" class="input2" readonly id="cgo_clm_stl_locl_curr_cd" /> </td>
						<th title="Date Of Settlement">DOS</th>
						<td><input type="text" style="width:76px;text-align:center" name="cgo_clm_stl_dt" value="" class="input2" readonly id="cgo_clm_stl_dt" /> </td>
						<th> R.O.E</th>
						<td><input type="text" style="width:70px;text-align:right" name="cgo_clm_stl_xch_rt" value="" class="input2" readonly id="cgo_clm_stl_xch_rt" /><input type="text" style="width:160px;text-align:right" name="cgo_clm_stl_usd_amt" value="" class="input2" readonly id="cgo_clm_stl_usd_amt" /><b>USD</b></td>
					</tr>
				</tbody>
			</table>
			</div>
			<table class="line_bluedot"><tr><td></td></tr></table>
			<div class= "opus_design_inquiry wFit">
			<table>
				<tbody>
					<colgroup>
						<col width="70"/>
						<col width="350"/>
						<col width="80"/>
						<col width="*"/>
				    </colgroup>
					<tr>
						<th>Liable Party</th><!-- 
						--><input type="hidden" name="clm_pty_no" id="clm_pty_no" />
						<td><input type="text" style="width:80px;" name="clm_pty_abbr_nm" value="" class="input2" readonly id="clm_pty_abbr_nm" /><!-- 
							 --><input type="text" style="width:220px;" name="pty_nm" value="" class="input2" readonly="" id="pty_nm" /><!-- 
						     --><button class="btn_etc" name="btns_style" id="btns_style" type="button">Style</button></td>
						<th>LP HOFC</th>
						<td><input type="text" style="width:80px;text-align:center;" name="hndl_ofc_cd" value="" class="input2" readonly="" id="hndl_ofc_cd" /></td>
					</tr>			
				</tbody>
			</table>
			<table>
				<tbody>
					<colgroup>
						<col width="140"/>
						<col width="50"/>
						<col width="200"/>
						<col width="70"/>
						<col width="*"/>
				    </colgroup>
					<tr>
						<td></td>
						<th title="LP Date Of Preliminary Notice">LP DON</th>
						<td><input type="text" style="width:83px; text-align: center; ime-mode: disabled" name="labl_pty_prlm_clm_ntfy_dt" dataformat="ymd" maxlength="10" value="" class="input2" readonly id="labl_pty_prlm_clm_ntfy_dt" /><!-- 
						 	--><button type="button" id="btns_labl_pty_prlm_clm_ntfy_dt" name="btns_labl_pty_prlm_clm_ntfy_dt" class="calendar ir"></button></td>
						<th title="LP Time Barred Date">LP DOTB</th>
						<td><input type="text" style="width:75px;" name="tm_bar_dt" value="" class="input2" readonly id="tm_bar_dt" /> </td>
					</tr>
				</tbody>
			</table>
			
			<table>
				<tbody>
					<colgroup>
						<col width="140"/>
						<col width="250"/>
						<col width="70"/>
						<col width="120"/>
						<col width="80"/>
						<col width="*"/>
				    </colgroup>
					<tr>
						<th>LP Claim Amount</th>
						<td><input type="text" style="width:132px;text-align:right" name="labl_pty_dmnd_amt" value="" class="input2" dataformat="float" readonly id="labl_pty_dmnd_amt" /><input type="text" style="width:40px;text-align:center" name="labl_pty_dmnd_curr_cd" value="" class="input2" maxlength="3" minlength="3" onblur="javascript:setXchRt()" readonly id="labl_pty_dmnd_curr_cd" />  </td>
						<th title="LP Date of Formal Claim">LP DOF</th>
						<td><input type="text" style="width:80px;text-align:center" name="labl_pty_fmal_clm_dt" value="" class="input2" readonly id="labl_pty_fmal_clm_dt" /><button type="button" id="btns_labl_pty_fmal_clm_dt" name="btns_labl_pty_fmal_clm_dt" class="calendar ir"></button></td>
						<th> R.O.E</th>
						<td><input type="text" style="width:70px;text-align:right" name="labl_pty_xch_rt" value="" class="input2" readonly id="labl_pty_xch_rt" /><input type="text" style="width:136px;text-align:right" name="labl_pty_dmnd_usd_amt" value="" class="input2" dataformat="float" readonly id="labl_pty_dmnd_usd_amt" />&nbsp;<b>USD</b></td>
					</tr>
			
					<tr>
						<th>LP Recovered Amount</th>
						<td><input type="text" style="width:132px;text-align:right" name="labl_pty_rcvr_locl_amt" value="" class="input2" dataformat="float" readonly id="labl_pty_rcvr_locl_amt" /><input type="text" style="width:40px;text-align:center" name="labl_pty_rcvr_locl_curr_cd" value="" class="input2" maxlength="3" minlength="3" onblur="javascript:setLoclXchRt()" readonly id="labl_pty_rcvr_locl_curr_cd" />  </td>
						<th title="LP Date of Receipt">LP DOR</th>
						<td><input type="text" style="width:80px;text-align:center" name="labl_pty_rcvr_dt" value="" class="input2" readonly id="labl_pty_rcvr_dt" /><button type="button" id="btns_labl_pty_rcvr_dt" name="btns_labl_pty_rcvr_dt" class="calendar ir"></button></td>
						<th title="Rate of Exchange">R.O.E</th>
						<td><input type="text" style="width:70px;text-align:right" name="labl_pty_rcvr_locl_xch_rt" value="" class="input2" readonly id="labl_pty_rcvr_locl_xch_rt" /><input type="text" style="width:136px;text-align:right" name="labl_pty_rcvr_usd_amt" value="" class="input2" dataformat="float" readonly id="labl_pty_rcvr_usd_amt" />&nbsp;<b>USD</b></td>
					</tr>
					
				</tbody>
			</table>
			
			
		</div>
		<div class= "opus_design_inquiry">
			<table style="background-color:white;" class="grid_2"> 
				<tr>
					<td  class="sm" style="text-align:center;"><b>Development</b></td>
				</tr>
				<tr>
					<td><textarea name="labl_pty_clm_rmk" style="width:100%;ime-mode:disabled;resize:none;" rows="15" class="textarea2" readonly></textarea></td>
				</tr>
			</table>
			</div> 
	</div>


</form>
<!-- opus_design_grid(S) -->
<div style="display: none;"><script type="text/javascript">ComSheetObject('sheet1');</script></div>
