<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_FMS_0002.jsp
*@FileTitle  : Agreement Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/19
=========================================================*/
%>

<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="m2soft.rdsystem.server.core.rddbagent.util.serverexport.ExportInfo"%>

<%
	Exception serverException = null;			//Error from Server
	String strErrMsg = "";	
	String strUsr_email = "";

	String cre_usr_id = "";
	Logger log = Logger.getLogger("com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	cre_usr_id = account.getUsr_id();
		strUsr_email = account.getUsr_eml();
	   	
	   	serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
	}catch(Exception e) {
		log.error(e.getMessage(),e);
	}
%>

<script type="text/javascript">

    function setupPage(){  
		var errMessage = "<%=strErrMsg%>";
		
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		
        loadPage();
    }

</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="ibflag" id="ibflag" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="cnt_cd" id="cnt_cd" />
<input type="hidden" name="curr_cd" id="curr_cd" />
<input type="hidden" name="eff_dt" id="eff_dt" />
<input type="hidden" name="exp_dt" id="exp_dt" />
<input type="hidden" name="vndr_seq" id="vndr_seq" />

<!-- Mail Send -->
<input type="hidden" name="com_rdSubSysCd" value="FMS" id="com_rdSubSysCd" />
<input type="hidden" name="com_from" value="<%=strUsr_email%>" id="com_from" />
<input type="hidden" name="com_recipient" value="" id="com_recipient" />
<input type="hidden" name="com_carbonCopy" value="" id="com_carbonCopy" />
<input type="hidden" name="com_blindCarbonCopy" id="com_blindCarbonCopy" />
<input type="hidden" name="com_subject" value="" id="com_subject" />
<input type="hidden" name="com_fileKey" id="com_fileKey" />
<input type="hidden" name="com_content" id="com_content" />
<input type="hidden" name="com_templateMrd" value="" id="com_templateMrd" />
<input type="hidden" name="com_templateMrdArguments" id="com_templateMrdArguments" />
<input type="hidden" name="com_templateMrdDescription" value="" id="com_templateMrdDescription" />

<input type="hidden" name="com_rdExportFileName" value="" id="com_rdExportFileName" />
<input type="hidden" name="com_rdExportFileType" value="<%=ExportInfo.FTYPE_PDF%>" id="com_rdExportFileType" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_retrive" id="btn_retrive" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button>
	</div>
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
	<div class="opus_design_inquiry wFit">
		<table class="search">
			<tbody>
				<colgroup>
					<col width="80px">
					<col width="170px">
					<col width="80px">
					<col width="270px">
					<col width="90px">
					<col width="100px">
					<col width="90px">
					<col width="*">
				</colgroup>
				<tr class="h23">
                    <th>Contract No.</th>
                    <td><input type="text" style="width:120px;text-align:center;" class="input1" maxlength="15" name="flet_ctrt_no" id="flet_ctrt_no" fullfill caption="Contract No." readonly><button type="button" class="input_seach_btn" name="contract_no" id="contract_no"></button></td>
                    <th>Vessel Code</th>
                    <td><input type="text" style="width:54px;text-align:center;" class="input1" maxlength="4" name="vsl_cd" id="vsl_cd" caption="Vessel Code" dataformat="engup"><button type="button" class="input_seach_btn" name="btn_vslpop" id="btn_vslpop"></button><input type="text" style="width:161px;" class="input2" name="vsl_eng_nm" id="vsl_eng_nm" readonly></td> 
                    <th>Contract Type</th>
					<td><input type="text" style="width:70px;text-align:center;" class="input2" name="flet_ctrt_tp_cd" id="flet_ctrt_tp_cd" readonly></td>
                    <th>Contract Fact</th> 
					<td><input type="text" style="width:73px;text-align:center;" class="input2" name="flet_ctrt_fact_cd" id="flet_ctrt_fact_cd" readonly></td>
				</tr>
				<tr class="h23">
                    <th>CP Date</th>
                    <td><input type="text" style="width:80px;text-align:center;" class="input2" name="cp_dt" id="cp_dt" dataformat="ymd" caption="CP Date" readonly></td>
                    <th>CP Period</th>
                    <td colspan="4"><!-- 
                    	--><input type="text" style="width:76px;text-align:center;" class="input2" name="ori_eff_dt" id="ori_eff_dt" caption="CP Period From" dataformat="ymd" readonly><!-- 
                 	 	--><input type="text" style="width:45px;text-align:center;" class="input2" maxlength="4" dataformat="hm"  name="from_time" id="from_time" caption="CP Time" readonly>~ <input type="text" style="width:76px;text-align:center;" class="input2" name="ori_exp_dt" id="ori_exp_dt" caption="CP Period To" dataformat="ymd" cofield="ori_eff_dt" readonly><!-- 
                 		--><input type="text" style="width:45px;text-align:center;" class="input2" maxlength="4" name="to_time" id="to_time" dataformat="hm" caption="CP Time" readonly><!-- 
                   		--><input type="text" style="width:36;text-align:center;" class="input2" maxlength="3" name="flet_gmt_lmt_cd" readonly><!-- 
                    --></td>
                </tr>
                <tr class="h23">
                    <td colspan="2"><strong>Customs Declaration</strong>&nbsp;<input type="checkbox" value="N" class="trans" name="decl_flg" id="decl_flg" disabled></td>
                    <th>Owner Code</th>
                    <td colspan="2"><input type="text" style="width:30px;text-align:center;" class="input2" maxlength="2" name="cust_cnt_cd" id="cust_cnt_cd" readonly style="ime-mode:disabled">
                    				<input type="text" style="width:67px;text-align:center;" class="input2" maxlength="6" name="cust_seq" id="cust_seq" caption="Owner Code" dataformat="int" readonly>
                    				<input type="text" style="width:203px;" class="input2" name="vndr_lgl_eng_nm" id="vndr_lgl_eng_nm" caption="Owner Code" readonly></td><!-- required --> 
                    <td colspan="3"><strong>Owner Name</strong> <input type="text" style="width:400px;" class="input2" name="ownr_nm" id="ownr_nm" readonly></td>
                </tr>
			</tbody>
		</table>
	</div>
	<table class="line_bluedot"><tr><td></td></tr></table>
	<div class="opus_design_inquiry wFit">
		<table class="search">
			<tbody>
				<colgroup>
					<col width="100px">
					<col width="100px">
					<col width="130px">
					<col width="167px">
					<col width="80px">
					<col width="100px">
					<col width="90px">
					<col width="*">
				</colgroup>
				<tr class="h23">
                    <th>Address Comm.</th>
                    <td class="stm"><input type="text" style="width:48px;text-align:right;" class="input2" name="acmm_rt_amt" id="acmm_rt_amt" dataformat="float" maxlength="6" pointcount="2" caption="Address Comm." readonly>&nbsp;%</td>
                    <th>Outlay Comm.</th>
                    <td class="stm"><input type="text" style="width:48px;text-align:right;" class="input2" name="flet_olay_comm_rt_amt" id="flet_olay_comm_rt_amt" dataformat="float" maxlength="6" pointcount="2" caption="Outlay Comm" readonly>&nbsp;%</td>
                    <th>Flag Code</th>	
                    <td><input type="text" style="width:40px;text-align:center;" class="input2" maxlength="2" name="vsl_cnt_cd" id="vsl_cnt_cd" style="ime-mode:disabled" caption="Flag Code" readonly></td>
                    <th>Flag Name</th> 
                    <td><input type="text" style="width:184px;" class="input2" name="cnt_nm" id="cnt_nm" readonly></td>
                </tr>
                <tr class="h23">
                    <th>Brokerage</th>
                    <td class="stm"><input type="text" style="width:48px;text-align:right;" class="input2" name="flet_brog_rt_amt" id="flet_brog_rt_amt" dataformat="float" maxlength="6" pointcount="2" caption="Brokerage" readonly>&nbsp;%</td>
                    <th>Reservation of O/A</th>																																					<!-- width:60 -->
                    <td><input type="text" style="width:48px;text-align:center;" class="input2" name="oa_rsv_curr_cd" id="oa_rsv_curr_cd" maxlength="3" style="ime-mode:disabled" readonly>&nbsp;<input type="text" style="width:62px;text-align:right;" class="input2" name="oa_rsv_amt" id="oa_rsv_amt" dataformat="int" maxlength="5" readonly></td>
                </tr>
			</tbody>
		</table>
		<!-- layout_wrap(S) -->
		<div class="layout_wrap">
		    <div class="layout_vertical_2" style="height:140px;vertical-align: top;">
		    	<table style="height:56px"><tr><td></td></tr></table>
		        <table style="width:510px; background-color:white;" class="grid2">
					<tbody>
						<colgroup>
							<col width="13%">
							<col width="14%">
							<col width="14%">
							<col width="6%">
							<col width="15%">
							<col width="6%">
							<col width="15%">
							<col width="9%">
							<col width="9%">
						</colgroup>
						<tr class="tr2_head">
                            <th>Bunker TP</th>
							<th>F.O.</th>
							<th>D.O.</th>
							<th>&nbsp;</th>
							<th>Price of F.O.</th>
							<th>&nbsp;</th>
							<th>Price of D.O.</th>
							<th colspan="2">Del / Redel</th>
						</tr>
						<tr>
							<td class="tr2_head2">BOD</td>
                            <td><input type="text" style="width:100%;text-align:right;" class="noinput" name="act_foil_bod_qty" id="act_foil_bod_qty" dataformat="float" maxlength="13" pointcount="3" caption="BOD F.O." readonly></td> 
                            <td><input type="text" style="width:100%;text-align:right;" class="noinput" name="act_doil_bod_qty" id="act_doil_bod_qty"  dataformat="float" maxlength="13" pointcount="3" caption="BOD D.O." readonly></td>
                            <td class="tr2_head2">USD</td> 
                            <td><input type="text" style="width:100%;text-align:right;" class="noinput" name="foil_bod_out_prc" id="foil_bod_out_prc"  dataformat="float" maxlength="14" pointcount="2" caption="BOD Price of F.O." readonly></td>
                            <td class="tr2_head2">USD</td> 
                            <td><input type="text" style="width:100%;text-align:right;" class="noinput" name="doil_bod_out_prc" id="doil_bod_out_prc"  dataformat="float" maxlength="14" pointcount="2" caption="BOD Price of F.O." readonly></td>
                            <td colspan="2"><input type="text" style="width:100%;text-align:center;ime-mode:disabled;" class="noinput" name="bod_port_cd" id="bod_port_cd" maxlength="5" readonly></td>
                        </tr>
                        <tr>
                        	<td class="tr2_head2">BOR</td>
                            <td><input type="text" style="width:100%;text-align:right;" class="noinput" name="act_foil_bor_qty" id="act_foil_bor_qty" dataformat="float" maxlength="13" pointcount="3" caption="BOR F.O." readonly></td> 
                            <td><input type="text" style="width:100%;text-align:right;" class="noinput" name="act_doil_bor_qty" id="act_doil_bor_qty" dataformat="float" maxlength="13" pointcount="3" caption="BOR D.O." readonly></td>
                            <td class="tr2_head2">USD</td> 
                            <td><input type="text" style="width:100%;text-align:right;" class="noinput" name="foil_bor_out_prc" id="foil_bor_out_prc" dataformat="float" maxlength="14" pointcount="2" caption="BOR Price of F.O." readonly></td>
                            <td class="tr2_head2">USD</td> 
                            <td><input type="text" style="width:100%;text-align:right;" class="noinput" name="doil_bor_out_prc" id="doil_bor_out_prc" dataformat="float" maxlength="14" pointcount="2" caption="BOR Price of F.O." readonly></td>
                            <td colspan="2"><input type="text" style="width:100%;text-align:center;ime-mode:disabled;" class="noinput" name="bor_port_cd" id="bor_port_cd" maxlength="5" readonly></td>
                        </tr>
					</tbody>
				</table>
		    </div>
		    <div class="layout_vertical_2" style="height:140px;vertical-align: bottom;">
		    	<table class="grid2">
					<tbody>
						<colgroup>
							<col width="15%">
							<col width="15%">
							<col width="15%">
							<col width="15%">
						</colgroup>
						<tr><th class="tr_head">Built</th> 
                            <td align="left"><input type="text" style="width:100%;text-align:right;" class="noinput" name="vsl_bld_dt" id="vsl_bld_dt" dataformat="ymd" caption="Built" readonly></td>
                            <th class="tr_head">Speed</th>
                            <td align="left"><input type="text" style="width:100%;text-align:right;" class="noinput" maxlength="9" name="shp_spd_qty" id="shp_spd_qty" dataformat="float" maxlength="9" pointcount="2" caption="Speed" readonly></td>
                        </tr>
                        <tr><th class="tr_head">Max TEU</th> 
                            <td align="left"><input type="text" style="width:100%;text-align:right;" class="noinput" maxlength="5" name="vsl_dznd_capa" id="vsl_dznd_capa" dataformat="int" maxlength="5" caption="Max TEU" readonly></td>
                            <th class="tr_head">14 Ton</th>
                            <td align="left"><input type="text" style="width:100%;text-align:right;" class="noinput" maxlength="5" name="bse_14ton_vsl_capa" id="bse_14ton_vsl_capa" dataformat="int" maxlength="5" caption="14 Ton" readonly></td>
                        </tr>
                        <tr><th class="tr_head">Reefer Plug Qty</th> 
                            <td align="left"><input type="text"  style="width:100%;text-align:right;" class="noinput"  name="rf_cntr_plg_qty" id="rf_cntr_plg_qty" dataformat="int" maxlength="6" caption="Reefer Plug Qty" readonly></td>
                            <th class="tr_head">Geared / G.Less</th>
                            <td align="left"><input type="text" style="width:100%;text-align:right;" class="noinput"  name="gr_flg" id="gr_flg" readonly></td>
                        </tr>
                        <tr><th class="tr_head">Dead Weight</th> 
                            <td align="left"><input type="text"  style="width:100%;text-align:right;" class="noinput"  name="ddwt_cgo_capa_qty" id="ddwt_cgo_capa_qty" dataformat="int" maxlength="9" caption="Dead Weight" readonly></td>
                            <th class="tr_head">Gross Ton</th>
                            <td align="left"><input type="text"  style="width:100%;text-align:right;" class="noinput"  name="grs_wgt" id="grs_wgt" dataformat="int" maxlength="6" caption="Gross Ton" readonly></td>
                        </tr>
                        <tr><th class="tr_head">&nbsp;</th> 
                            <td align="left"><input type="text"  style="width:100%;text-align:right;" class="noinput" name="dumy" id="dumy" readonly></td>
                            <th class="tr_head">Net Ton</th>
                            <td align="left"><input type="text"  style="width:100%;text-align:right;" class="noinput" name="nrt_wgt" id="nrt_wgt" dataformat="int" maxlength="6" caption="Net Ton" readonly></td>
                        </tr>
					</tbody>
				</table>
		    </div>
		</div>
		<!-- layout_wrap(E) -->
	</div>
	<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
	<div class="opus_design_inquiry wFit">
		<h3 class="title_design">Hire Information</h3>
		<table style="width:665px;">
			<tbody>
				<colgroup>
					<col width="43px">
					<col width="*">
				</colgroup>
				<tr class="h23">
                    <th>Hire</th>
                    <td><input type="text" style="width:76px;" class="input2" name="hir_eff_dt" id="hir_eff_dt" readonly>&nbsp;
                    	<input type="text" style="width:45px;text-align:center;" class="input2" name="hir_eff_dt_time" id="hir_eff_dt_time" readonly>~&nbsp;
                    	<input type="text" style="width:76px;" class="input2" name="hir_exp_dt" id="hir_exp_dt" readonly>&nbsp;
                    	<input type="text" style="width:45px;text-align:center;" class="input2" name="hir_exp_dt_time" id="hir_exp_dt_time" readonly>
                    	<input type="text" style="width:40px;text-align:center;" class="input2" name="hir_hir_curr_n1st_cd" id="hir_hir_curr_n1st_cd" readonly>
                    	<input type="text" style="width:95px;text-align:right;" class="input2" name="hir_hir_rt_n1st_amt" id="hir_hir_rt_n1st_amt" readonly>
                    	<input type="text" style="width:40px;text-align:center;" class="input2" name="hir_hir_curr_n2nd_cd" id="hir_hir_curr_n2nd_cd" readonly>
                    	<input type="text" style="width:95px;text-align:right;" class="input2" name="hir_hir_rt_n2nd_amt" id="hir_hir_rt_n2nd_amt" readonly></td>
                </tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<div class="opus_design_data" style="width:700px;">
		<h3 class="title_design">Other Lumpsum information</h3>		
	</div>
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>

<div class="wrap_result">
<!-- opus_tab_btn(S) -->
<div class="opus_design_tab">
	<script type="text/javascript">ComTabObject('tab1')</script>
</div>
<!-- opus_tab_btn(E) -->

<!-- opus_design_grid(S) -->	
<div class="opus_design_grid clear" style="display:inline;" name="tabLayer" id="tabLayer">
	<script type="text/javascript">ComSheetObject('t1sheet1');</script>
</div>
	
<div class="opus_design_grid clear" style="display:none;" name="tabLayer" id="tabLayer">
	<script type="text/javascript">ComSheetObject('t2sheet1');</script>
</div>
	
<div class="opus_design_grid clear" style="display:none;" name="tabLayer" id="tabLayer">
	<script type="text/javascript">ComSheetObject('t3sheet1');</script>
</div>

<div class="opus_design_grid clear" style="display:none;" name="tabLayer" id="tabLayer">
	<script type="text/javascript">ComSheetObject('t4sheet1');</script>
</div>

<div class="opus_design_grid clear" style="display:none;" name="tabLayer" id="tabLayer">
	<div class="opus_design_btn">
		<button class="btn_normal" name="btn_t5E-mail" id="btn_t5E-mail" type="button">E-mail</button>
	</div>
	<script type="text/javascript">ComSheetObject('t5sheet1');</script>
</div>

<div class="opus_design_grid clear" style="display:none;" name="tabLayer" id="tabLayer">
	<div class="opus_design_btn">
		<button class="btn_normal" name="btn_t6E-mail" id="btn_t6E-mail" type="button">E-mail</button>
	</div>
	<script type="text/javascript">ComSheetObject('t6sheet1');</script>
</div>

<div class="opus_design_grid clear" style="display:none;" name="tabLayer" id="tabLayer">
	<script type="text/javascript">ComSheetObject('t7sheet1');</script>
</div>
<!-- opus_design_grid(E) -->
</div>
<div style="display:none">
<script type="text/javascript">ComUploadObject('upload1', '<=session.getId()%>');</script>
</div>
</form>