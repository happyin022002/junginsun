<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CPS_CNI_0034.jsp
*@FileTitle  : [CPS_CNI_0034] View-Contract of Carriage-Main 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/23
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
<%@ page import="com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.event.CpsCni0010Event"%>
<%@ page import="com.clt.apps.opus.cps.cni.common.CniUtil"%>
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
    Logger log = Logger.getLogger("com.clt.apps.opus.cps.cni.containercargoclaim.ContainerCargoClaimSC");
    try
    {
		reqCgoClmNo  = JSPUtil.getParameter(request, "cgo_clm_no","");
        SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        userId = account.getUsr_id();
        userName = account.getUsr_nm();
        userOffice = account.getOfc_cd();
		//session start
		if (!reqCgoClmNo.equals("")){//req 있으면 req claimNo 로 세팅.
			userCgoClmNo = reqCgoClmNo;
		} else{//req 없으면 session 에 있는지 체크.
			if(!CniUtil.getCargoClaimNo(account).equals("")){//session 에 있으면 session 값으로 세팅
				userCgoClmNo = CniUtil.getCargoClaimNo(account);
			}
		}
		userCgoClmNo = CniUtil.getCargoClaimNo(account);
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
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />
<input id="cgo_clm_ref_bl_no" name="cgo_clm_ref_bl_no" type="hidden" />
<input id="bkg_no" name="bkg_no" type="hidden" />
<!-- PRINT  -->
<input id="com_mrdPath" name="com_mrdPath" type="hidden" />
<input id="com_mrdArguments" name="com_mrdArguments" type="hidden" />
<input id="com_mrdTitle" name="com_mrdTitle" type="hidden" />
<input id="com_mrdBodyTitle" name="com_mrdBodyTitle" type="hidden" />
<!--RD 를 위한변수-->
<input id="rd_title" name="rd_title" value="" type="hidden" />
<input id="rd_title_nm" name="rd_title_nm" value="" type="hidden" />
<input id="rd_report_by" name="rd_report_by" value="" type="hidden" />
<input id="usr_id" name="usr_id" value="<%=userId%>" type="hidden" />
<!-- 개발자 작업 -->


<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button type="button" id="btn1_Retrieve" name="btn1_Retrieve" class="btn_accent">Retrieve</button><!--
		--><button type="button" id="btn1_New" name="btn1_New" class="btn_normal">New</button><!--
		--></div>
	<!-- opus_design_btn (E) -->
	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<div class="wrap_search_tab">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table>
			<tbody>
				<colgroup>
					<col width="10" />
					<col width="40" />
					<col width="170" />
					<col width="40" />
					<col width="170" />
					<col width="40" />
					<col width="170" />
					<col width="40" />
					<col width="170" />
					<col width="40" />
					<col width="170" />
					<col width="40" />
					<col width="170" />
					<col width="*" />
				</colgroup>
				<tr>
					<td></td>
					<th>Claim  No.</th>
					<td><input  style="width:85px; text-align:center" name="cgo_clm_no" id="cgo_clm_no"  value="<%=userCgoClmNo%>" required="" maxlength="10" caption="Claim  No" dataformat="engup" class="input1" type="text" /><input id="clm_area_cd" style="width:20px;" name="clm_area_cd" value="" class="input2" readonly type="text" /> </td>
					<th title="Handling Office">HOFC</th>
					<td><input id="hdlr_ofc_cd" style="width:50px; text-align:center" name="hdlr_ofc_cd" value="" class="input2" readonly type="text" /> </td>
					<th>Handler</th>
					<td><input id="hdlr_usr_id" style="width:80px; text-align:center" name="hdlr_usr_id" value="" class="input2" readonly type="text" /><button class="input_seach_btn" name="btn1_Handler" id="btn1_Handler" type="button"></button></td>
					<th title="Date Of Updated">DOU</th>
					<td><input id="upd_dt" style="width:76px; text-align:center" name="upd_dt" value="" class="input2" readonly type="text" /> </td>
					<th>Incident No.</th>
					<td><input id="cgo_clm_inci_no" style="width:95px; text-align:center" name="cgo_clm_inci_no" value="" class="input2" readonly type="text" /> </td>
					<th>VOC No.</th>
					<td><input id="crm_voc_no" style="width:100px; text-align:center" name="crm_voc_no" value="" class="input2" readonly type="text" /> </td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<th>Status</th>
					<td><input id="clm_misc_nm" style="width:108px; text-align:center" name="clm_misc_nm" value="" class="input2" readonly type="text" /> <input id="clm_misc_cd" name="clm_misc_cd" value="" type="hidden" /> </td>
					<th><span title="Handling Period">HPD</span>/<span title="Net Handling Period">NHP</span></th>
					<td><input id="hpc" style="width:40px; text-align:center" name="hpc" value="" class="input2" readonly type="text" />/&nbsp;<input id="nhp" style="width:40px;" name="nhp" value="" class="input2" readonly type="text" /> </td>
					<th title="Type Of Settlement">TOS</th>
					<td><input id="cgo_clm_stl_tp_cd" style="width:45px; text-align:center" name="cgo_clm_stl_tp_cd" value="" class="input2" readonly type="text" /> </td>
					<th title="Date Of Close">DOC</th>
					<td><input id="cs_clz_dt" style="width:76px; text-align:center" name="cs_clz_dt" value="" class="input2" readonly type="text" /> </td>
					<th title="Time Bar Date">DOTB</th>
					<td><input id="clm_tm_bar_dt" style="width:90px; text-align:center" name="clm_tm_bar_dt" value="" class="input2" readonly type="text" /> </td>
					<th>Summons Served Date</th>
					<td><input id="smns_sve_dt" style="width:90px; text-align:center" name="smns_sve_dt" value="" class="input2" readonly type="text" /> </td>
					<td></td>
				</tr>
			</tbody>
		</table>
		
		<div class="opus_design_inquiry"><table class="line_bluedot"><tr><td></td></tr></table></div>
		
		<table>
			<tbody>
				<colgroup>
					<col width="68" />
					<col width="*" />
				</colgroup>
				<tr>
					<th>Claimant <input type="hidden" name="clmt_clm_pty_no" id="clmt_clm_pty_no"></th>
					<td><input id="clm_pty_abbr_nm" style="width:70px; text-align:center" name="clm_pty_abbr_nm" value="" class="input2" readonly type="text" /><input id="pty_nm" style="width:282px;" name="pty_nm" value="" class="input2" readonly type="text" /><input id="clmt_clm_tp_cd" style="width:21px;" name="clmt_clm_tp_cd" value="" class="input2" readonly type="text" /><label></label><strong><span title="Received Office">ROFC</span>/<span title="Date of Formal Claim">DOF</span></strong><input id="fmal_clm_rcv_ofc_cd" style="width:75px;text-align:center" name="fmal_clm_rcv_ofc_cd" value="" class="input2" readonly type="text" />/&nbsp;<input id="fmal_clm_rcv_dt" style="width:80px; text-align:center" name="fmal_clm_rcv_dt" value="" class="input2" readonly type="text" /></td>
					
				</tr>
			</tbody>
		</table>
		<table>
			<tbody>
				<colgroup>
					<col width="27" />
					<col width="40" />
					<col width="100" />
					<col width="40" />
					<col width="58" />
					<col width="40" />
					<col width="55" />
					<col width="40" />
					<col width="80" />
					<col width="40" />
					<col width="120" />
					<col width="40" />
					<col width="120" />
					<col width="*" />
				</colgroup>
				<tr>
					<td></td>
					<th title="Type of Claim">TOC</th>
					<td><input id="cgo_clm_tp_cd" style="width:70px; text-align:center" name="cgo_clm_tp_cd" value="" class="input2" readonly type="text" /> </td>
					<th title="Cause of Damage or Loss">CODL 1</th>
					<td><input id="mjr_clm_dmg_lss_cd" style="width:40px; text-align:center" name="mjr_clm_dmg_lss_cd" value="" class="input2" readonly type="text" /> </td>
					<th title="Cause of Damage / Loss">2</th>
					<td><input id="minr_clm_dmg_lss_cd" style="width:40px; text-align:center" name="minr_clm_dmg_lss_cd" value="" class="input2" readonly type="text" /> </td>
					<th title="Place of Incident">POI</th>
					<td><input id="inci_plc_tp_cd" style="width:40px; text-align:center" name="inci_plc_tp_cd" value="" class="input2" readonly type="text" /> </td>
					<th title="Date of Incident">DOI</th>
					<td><input id="inci_occr_dt" style="width:75px; text-align:center" name="inci_occr_dt" value="" class="input2" readonly type="text" /> </td>
					<th> Claim Amount</th>
					<td><input id="clmt_usd_amt" style="width:130px; text-align:right" name="clmt_usd_amt" value="" class="input2" readonly type="text" />   USD</td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_tab_btn(S) -->
	<div class="opus_design_tab">
		<script type="text/javascript">ComTabObject('tab1')</script>
	</div>
	<!-- opus_tab_btn(E) -->
				
	<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">
		<!-- layout_wrap (S) -->
		<div class="layout_wrap">
		    <div class="layout_vertical_2" style="width: 22%">
		    	<h3 class="title_design">B/L</h3>
		        <div class="opus_design_grid">
		        	<div class="opus_design_btn">
		        		<button type="button" class="btn_normal" id="btn_BLPreview" name="btn_BLPreview">B/L View</button>
		        	</div>
		            <script type="text/javascript">ComSheetObject('sheet1');</script>
		        </div>
		    </div>
		    
		    <div class="layout_vertical_2" style="width: 5%">
		    	<table>
		    		<tr>
		    			<td>&nbsp;</td>
		    		</tr>
		    	</table>
		    </div>
  		    <div class = "opus_design_inquiry wFit">
		    <div class="layout_vertical_2" style="width: 25%">
				<table class="search">
					<tr>
						<th>Trunk VVD</th>
						<td><input id="trnk_ref_vvd_no" style="width:100px;" name="trnk_ref_vvd_no" value="" class="input2" readonly type="text" /><button type="button" class="btn_etc" id="btn2_Upload_07" name="btn2_Upload_07">File Upload</button></td>
					</tr>
					<tr>
						<th>Lane</th>
						<td><input id="slan_cd" style="width:50px;text-align:center" name="slan_cd" value="" class="input2" readonly type="text" /><label></label><label></label><label></label><strong>Term</strong> <input id="crr_term_cd" style="width:50px;text-align:center" name="crr_term_cd" value="" class="input2" readonly type="text" /></td>
					</tr> 
					<tr>
						<th>POR / DOR</th>
						<td><input id="por_cd" style="width:100px;text-align:center" name="por_cd" value="" class="input2" readonly type="text" /><button type="button" class="input_seach_btn" name="btns_por_cd" id="btns_por_cd"></button>/&nbsp;<input id="rct_dt" style="width:100px;text-align:center" name="rct_dt" value="" class="input2" readonly type="text" /></td>
					</tr>
					<tr>
						<th title="Port of Loading">POL / <span title="Date of Loading">DOL</span></th>
						<td><input id="pol_cd" style="width:100px;text-align:center" name="pol_cd" value="" class="input2" readonly type="text" /><button type="button" class="input_seach_btn" name="btns_pol_cd" id="btns_pol_cd"></button>/&nbsp;<input id="lodg_dt" style="width:100px;text-align:center" name="lodg_dt" value="" class="input2" readonly type="text" /></td>
					</tr>
					<tr>
						<th>POD / DOD</th>
						<td><input id="pod_cd" style="width:100px;text-align:center" name="pod_cd" value="" class="input2" readonly type="text" /><button type="button" class="input_seach_btn" name="btns_pod_cd"  id="btns_pod_cd" ></button>/&nbsp;<input id="dchg_dt" style="width:100px;text-align:center" name="dchg_dt" value="" class="input2" type="text" /></td>
					</tr>
					<tr>
						<th><span title="Place of Delivery">DEL</span> / DDL</th>
						<td><input id="del_cd" style="width:100px;text-align:center" name="del_cd" value="" class="input2" readonly type="text" /><button type="button" class="input_seach_btn" name="btns_del_cd" id="btns_del_cd"></button>/&nbsp;<input id="de_dt" style="width:100px;text-align:center" name="de_dt" value="" class="input2" readonly type="text" /></td>
					</tr>
				</table> 
		    </div>
		    
		    <div class="layout_vertical_2" style="width: 3%">
		    	<table>
		    		<tr>
		    			<td>&nbsp;</td>
		    		</tr>
		    	</table>
		    </div>
		    
		     <div class="layout_vertical_2" style="width: 35%">
		    	<h3 class="title_design">CNTR</h3>
		        <div class="opus_design_grid">
		        	<div class="opus_design_btn">
		        		<button type="button" class="btn_normal" id="btn_Movement" name="btn_Movement">Movement History</button>
		        	</div>
		            <script type="text/javascript">ComSheetObject('sheet2');</script>
		        </div>
		    </div>
		</div>
		</div>
		<!-- layout_wrap (E) -->
		
		<div>
	    	<table>
	    		<tr>
	    			<td>&nbsp;</td>
	    		</tr>
	    	</table>
	    </div>
		<div class = "opus_design_inquiry wFit">    
		<table class="search"> 
			<colgroup>
				<col width="50" />
				<col width="550" />
				<col width="250" />
				<col width="*" />
			</colgroup>
			<tr>
				<th>Shipper</th>
				<td><input id="shpr_nm" style="width: 545px;" name="shpr_nm" value="" class="input2" readonly type="text" /> </td>
				<th>Cargo & Quantity</th>
				<td><input id="clm_cgo_tp_cd" style="width: 40px; text-align:center" name="clm_cgo_tp_cd" value="" class="input2" readonly="" type="text" /><input id="cgo_qlty_desc" style="width: 170px;" name="cgo_qlty_desc" value="" class="input2" readonly="" caption="Cargo & Quantity" type="text" /></td>
			</tr>
			<tr>
				<th>Consignee</th>
				<td><input id="cnee_nm" style="width: 545px;" name="cnee_nm" value="" class="input2" readonly type="text" /> </td>
				<th>Freight</th>
				<td><input id="clm_ofrt_amt" style="width:140px;text-align:right" name="clm_ofrt_amt" value="" class="input2" readonly type="text" /> <strong>USD</strong></td>
			</tr>
			<tr>
				<th>Notify</th>
				<td><input id="ntfy_nm" style="width: 545px;" name="ntfy_nm" value="" class="input2" readonly type="text" /> </td>
				<th>Payment Term </th>
				<td><script type="text/javascript">ComComboObject("clm_ofrt_term_cd", 2, 60, 1);</script><label></label><strong>Paid or not</strong> <script type="text/javascript">ComComboObject("clm_ofrt_flg", 2, 60, 1);</script></td>
			</tr>
	    </table>
	</div>
	</div>
	<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">
	<div class = "opus_design_inquiry wFit">  
		<table class="search">
			<tr>
				<th>Pre-VVD</th>
				<th>Pre-VVD1</th>
				<td><input id="n1st_pre_ref_vvd_no" style="width:80px;text-align:center" name="n1st_pre_ref_vvd_no" value="" class="input2" readonly type="text" /><button type="button" class="btn_etc" id="btn2_Upload_01" name="btn2_Upload_01">File Upload</button></td>
				<th>Pre-VVD2</th>
				<td><input id="n2nd_pre_ref_vvd_no" style="width:80px;text-align:center" name="n2nd_pre_ref_vvd_no" value="" class="input2" readonly type="text" /><button type="button" class="btn_etc" id="btn2_Upload_02" name="btn2_Upload_02">File Upload</button></td>
				<th>Pre-VVD3</th>
				<td><input id="n3rd_pre_ref_vvd_no" style="width:80px;text-align:center" name="n3rd_pre_ref_vvd_no" value="" class="input2" readonly type="text" /><button type="button" class="btn_etc" id="btn2_Upload_03" name="btn2_Upload_03">File Upload</button></td>
			</tr>
			<tr>
				<th></th>
				<th>Pre-POT1/Pre-DOT1</th>
				<td><input id="n1st_pre_ts_loc_cd" style="width:45px;text-align:center" name="n1st_pre_ts_loc_cd" value="" class="input2" readonly type="text" /><button class="input_seach_btn" name="btns_n1st_pre_ts_loc_cd" id="btns_n1st_pre_ts_loc_cd" type="button"></button>/&nbsp;<input id="n1st_pre_ts_dt" style="width:75px;text-align:center" name="n1st_pre_ts_dt" dataformat="ymd" maxlength="10" value="" class="input2" readonly="" type="text" /></td>
				<th>Pre-POT2/Pre-DOT2</th>
				<td><input id="n2nd_pre_ts_loc_cd" style="width:45px;text-align:center" name="n2nd_pre_ts_loc_cd" value="" class="input2" readonly type="text" /><button class="input_seach_btn" name="btns_n2nd_pre_ts_loc_cd" id="btns_n2nd_pre_ts_loc_cd" type="button"></button>/&nbsp;<input id="n2nd_pre_ts_dt" style="width:75px;text-align:center" name="n2nd_pre_ts_dt" dataformat="ymd" maxlength="10" value="" class="input2" readonly="" type="text" /></td>
				<th>Pre-POT3/Pre-DOT3</th>
				<td><input id="n3rd_pre_ts_loc_cd" style="width:45px;text-align:center" name="n3rd_pre_ts_loc_cd" value="" class="input2" readonly type="text" /><button class="input_seach_btn" name="btns_n3rd_pre_ts_loc_cd" id="btns_n3rd_pre_ts_loc_cd" type="button"></button>/&nbsp;<input id="n3rd_pre_ts_dt" style="width:75px;text-align:center" name="n3rd_pre_ts_dt" dataformat="ymd" maxlength="10" value="" class="input2" readonly type="text" /></td>
			</tr>
		</table>
		
		<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
		
		<table class="search" style="width:979;">
			<tr>
				<th>On-VVD</th>
				<th>On-VVD1</th>
				<td><input id="n1st_pst_ref_vvd_no" style="width:80px;text-align:center" name="n1st_pst_ref_vvd_no" value="" class="input2" readonly type="text" /><button type="button" class="btn_etc" id="btn2_Upload_04" name="btn2_Upload_04">File Upload</button></td>
				<th>On-VVD2</th>
				<td><input id="n2nd_pst_ref_vvd_no" style="width:80px;text-align:center" name="n2nd_pst_ref_vvd_no" value="" class="input2" readonly type="text" /><button type="button" class="btn_etc" id="btn2_Upload_05" name="btn2_Upload_05">File Upload</button></td>
				<th>On-VVD3</th>
				<td><input id="n3rd_pst_ref_vvd_no" style="width:80px;text-align:center" name="n3rd_pst_ref_vvd_no" value="" class="input2" readonly type="text" /><button type="button" class="btn_etc" id="btn2_Upload_06" name="btn2_Upload_06">File Upload</button></td>
			</tr>
			<tr>
				<th></th>
				<th>On-POT1 / On-DOT1</th>
				<td><input id="n1st_pst_ts_loc_cd" style="width:45px;text-align:center" name="n1st_pst_ts_loc_cd" value="" class="input2" readonly type="text" /><button class="input_seach_btn" name="btns_n1st_pst_ts_loc_cd" id="btns_n1st_pst_ts_loc_cd" type="button"></button>/&nbsp;<input id="n1st_pst_ts_dt" style="width:75px;text-align:center" name="n1st_pst_ts_dt" dataformat="ymd" maxlength="10" value="" class="input2" readonly="" type="text" /></td>
				<th>On-POT2 / On-DOT2</th>
				<td><input id="n2nd_pst_ts_loc_cd" style="width:45px;text-align:center" name="n2nd_pst_ts_loc_cd" value="" class="input2" readonly type="text" /><button class="input_seach_btn" name="btns_n2nd_pst_ts_loc_cd" id="btns_n2nd_pst_ts_loc_cd" type="button"></button>/&nbsp;<input id="n2nd_pst_ts_dt" style="width:75px;text-align:center" name="n2nd_pst_ts_dt" dataformat="ymd" maxlength="10" value="" class="input2" readonly="" type="text" /></td>
				<th>On-POT3 / On-DOT3</th>
				<td><input id="n3rd_pst_ts_loc_cd" style="width:45px;text-align:center" name="n3rd_pst_ts_loc_cd" value="" class="input2" readonly type="text" /><button class="input_seach_btn" name="btns_n3rd_pst_ts_loc_cd" id="btns_n3rd_pst_ts_loc_cd" type="button"></button>/&nbsp;<input id="n3rd_pst_ts_dt" style="width:75px;text-align:center" name="n3rd_pst_ts_dt" dataformat="ymd" maxlength="10" value="" class="input2" readonly type="text" /></td>
			</tr>
		</table>
	</div>
</div>
</div>
<div style="display: none;">
	<script type="text/javascript">ComSheetObject('sheet3');</script>
</div>
</form>