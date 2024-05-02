<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_LSE_0001.jsp
*@FileTitle  : Lease Agreement Creation & Update
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/30
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.lse.containerleaseagreementregistration.agreementregistration.event.EesLse0001Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.OfficeCodeMgr"%>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr"%>



<%
	EesLse0001Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_off_cd    = "";
	String strCntrTpSzCd    = "";
	Logger log = Logger.getLogger("com.clt.apps.ContainerLeaseAgreementRegistration.AgreementRegistration");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id     = account.getUsr_id();
		strUsr_nm     = account.getUsr_nm();
		strUsr_off_cd = account.getOfc_cd();

		event = (EesLse0001Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		strCntrTpSzCd = (String)eventResponse.getCustomData("cntr_tpsz_cd");
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
<%=OfficeCodeMgr.getOfficeCodeListToJS("000001", "LSE")%>
<%= JSPUtil.getIBCodeCombo("eq_loc_tp_cd",         "", "CD30026", 0, "")%>
<%=ConstantMgr.getBaseLocationCodeToJS()%>

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
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="usr_ofc_cd" value="<%= strUsr_off_cd %>" id="usr_ofc_cd" />
<input type="hidden" name="org_cntr_tpsz_cd" value="<%= strCntrTpSzCd %>" id="org_cntr_tpsz_cd" />
<input type="hidden" name="agmt_act_flg" id="agmt_act_flg" />
<input type="hidden" name="lstm_cd" id="lstm_cd" />
<input type="hidden" name="cntr_dpc_lvl_cd" id="cntr_dpc_lvl_cd" />
<input type="hidden" name="itchg_fee_flg" id="itchg_fee_flg" />
<input type="hidden" name="slb_flg" id="slb_flg" />
<input type="hidden" name="agmt_lst_ver_seq" id="agmt_lst_ver_seq" />
<input type="hidden" name="dpc_val_flg" id="dpc_val_flg" />

<input type="hidden" name="delYn1" id="delYn1" />
<input type="hidden" name="delYn2" id="delYn2" />
<input type="hidden" name="delYn3" id="delYn3" />
<input type="hidden" name="delYn4" id="delYn4" />
<input type="hidden" name="delYn6" id="delYn6" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!--
		--><button type="button" class="btn_normal" name="btn_Create" id="btn_Create">New AGMT Creation</button><!--
		--><button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button><!--
		--><button type="button" class="btn_normal" name="btn_VersionUp"  id="btn_VersionUp">Version Up</button>	
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->
<!-- opus_design_inquiry(S) -->
<div class= "wrap_search_tab">
	<div class= "opus_design_inquiry wFit">
		<table id="mainTable" name="mainTable">
			<tbody>
				<colgroup>
					<col width="80"/>
					<col width="100"/>
					<col width="60"/>
					<col width="100"/>
					<col width="80"/>
					<col width="100"/>
					<col width="80"/>
					<col width="80"/>
					<col width="*"/>
			    </colgroup>
				<tr>
					<th>AGMT No.</th>
					<td><input type="text" name="agmt_cty_cd" caption="AGMT No." style="width:35px;text-align:center;" class="input2" value="HHO" readonly="" id="agmt_cty_cd" /><!--
						--><input type="text" name="agmt_seq" caption="AGMT No." style="width:50px;text-align:center" class="input" value="" dataformat="num" maxlength="6" id="agmt_seq" /><!--
						--><input type="text" name="agmt_ver_seq" caption="AGMT No." style="width:20px;" class="input2" value="" dataformat="num" maxlength="3" readonly="" id="agmt_ver_seq" /><!--						
						--><button type="button" id="btns_search1" name="btns_search1" class="input_seach_btn"></button></td>
					<td colspan="2"><span style="padding:0px; font-family: Tahoma,verdana,arial,dotum,gulim; font-size: 12px; word-spacing:-0px;"><b><label for="chk_agmt_act_flg">InActive</label></b></span><!--
						--><input type="checkbox" name="chk_agmt_act_flg" caption="InActive" value="" class="trans" disabled="" id="chk_agmt_act_flg" /></td>
					<th>Term</th>
					<td><script type="text/javascript">ComComboObject('combo1', 2, 75, 0, 1);</script></td>
					<th>Depr</th>
					<td colspan="2"><input type="text" name="dpc_rto" caption="Yearly Depr" style="width:60px;text-align:right" class="input" value="" maxlength="6" dataformat="float" pointcount="2" minnum="0" maxnum="100.0" id="dpc_rto" /><b>%</b></td>	
				</tr>	
				<tr>
					<th>Effective Date</th>
					<td colspan="3"><input type="text" name="eff_dt" caption="Effective Date" style="width:75px;text-align:center;" class="input1" value="" dataformat="ymd" !cofield="exp_dt" id="eff_dt" />~&nbsp;<!--
									--><input type="text" name="exp_dt" caption="Expired Date" style="width:75px;text-align:center;" class="input1" value="" dataformat="ymd" !cofield="eff_dt" id="exp_dt" /><!--
									--><button type="button" id="btns_calendar1" name="btns_calendar1" class="calendar ir"></button></td>
					<th>Duration</th>
					<td><input type="text" name="dt_drtn" caption="Duration" style="width:79px;text-align:right;" class="input2" value="" dataformat="num" readonly="" id="dt_drtn" /></td>
					<th>Max Depr</th>
					<td colspan="2"><input type="text" name="max_dpc_rto" caption="Max Depr" style="width:60px;text-align:right" class="input" value="" maxlength="6" dataformat="float" pointcount="2" minnum="0" maxnum="100.0" id="max_dpc_rto" /><b>%</b></td>		
				</tr>	
				<tr>
					<th>Lessor</th>
					<td colspan="3"><input type="text" name="vndr_seq" caption="Lessor" style="width:55px;text-align:center;" class="input1" value="" dataformat="num" maxlength="6" id="vndr_seq" /><!--
									--><button type="button" id="btns_search2" name="btns_search2" class="input_seach_btn"></button><!--
									--><input type="text" name="vndr_nm" caption="Lessor" style="width:229px;" class="input2" value="" readonly="" id="vndr_nm" /></td>
					<th>URL</th>
					<td><input type="text" name="lse_vndr_url" caption="URL" style="width:150px;ime-mode:disabled;" class="input" value="" id="lse_vndr_url" /></td>
					<th>Depr Level</th>
					<td colspan="2"><script type="text/javascript">ComComboObject('combo2', 1, 70,  0, 1);</script><!--
						--><script type="text/javascript">ComComboObject('combo3', 1, 125, 0, 1);</script></td>
				</tr>
				<tr>
					<th>Contract No.</th>
					<td><input type="text" name="lse_ctrt_no" caption="Contract No" style="width:130px;" class="input1" value="" maxlength="20" dataformat="excepthan" id="lse_ctrt_no" /></td>
					<th>Ref. No.</th>
					<td><input type="text" name="ref_no" caption="Ref. No" style="width:102px;ime-mode:disabled;" class="input1" value="" maxlength="20" !dataformat="eng" id="ref_no" /></td>
					<th>AGMT Date</th>
					<td><input type="text" name="agmt_dt" caption="AGMT Date" style="width:79px;text-align:center;" class="input" value="" dataformat="ymd" id="agmt_dt" /><!--
						--><button type="button" id="btns_calendar2" name="btns_calendar2" class="calendar ir"></button></td>
					<th><label for="chk_itchg_fee_flg">ICF Flag</label></th>
					<td colspan="2"><input type="checkbox" name="chk_itchg_fee_flg" caption="ICF Flag" value="" class="trans" id="chk_itchg_fee_flg" /></td>
				</tr>
				<tr>
					<th>AGMT Office</th>
					<td><input type="text" name="ofc_cd" caption="AGMT Office" style="width:75px;text-align:center;" class="input2" value="<%= strUsr_off_cd %>" readonly id="ofc_cd" /></td>
					<th>Old AGMT No.</th>
					<td><input type="text" name="old_agmt_no" caption="Old AGMT No." style="width:102px;" class="input" value="" maxlength="20" id="old_agmt_no" /></td>
					<th>Pay Term</th>
					<td><input type="text" name="lse_pay_term_dys" caption="Pay Term" style="width:79px;text-align:right;" class="input" value="" maxlength="5" dataformat="num" id="lse_pay_term_dys" /></td>
					<th>DPP Coverage</th><!-- 
					Cannot use <label for="id"> for the radio controls below because there is other event using their ID. Don't change if you not sure ! If you change please test carefully 
					--><td class="sm pad_left_8"><input type="radio" name="dpp_tp_cd" id="dpp_tp_cd" value="Y" class="trans">Yes <input type="radio" name="dpp_tp_cd" id="dpp_tp_cd" value="N" class="trans">No</td>
					<td></td>
				</tr>
				<tr> 
					<th>Build Up</th>
					<td><input type="text" name="bld_up_dt" caption="Build Up" style="width:75px;text-align:center;" class="input" value="" dataformat="ymd" id="bld_up_dt" /><!--
									--><button type="button" id="btns_calendar3" name="btns_calendar3" class="calendar ir"></button></td>
                    <th>Sale and Leaseback Flag</th>
                    <td><input type="checkbox" name="chk_slb_flg" caption="SLB Flag" value="" class="trans" id="chk_slb_flg" /></td>        									
					<th>Currency</th>
					<td><input type="text" name="curr_cd" caption="Currency" style="width:79px;text-align:center;" class="input1" value="" maxlength="3" dataformat="engup" id="curr_cd" /><!--
						--><button type="button" id="btns_search3" name="btns_search3" class="input_seach_btn"></button></td>
					<th>DII/DIO Fee</th>
					<td colspan="2"><input type="text" name="dir_itchg_fee_amt" caption="DII/DIO Fee" style="width:75px;text-align:right" class="input" value="" maxlength="6" dataformat="float" pointcount="2" id="dir_itchg_fee_amt" /></td>
				</tr>
				<tr>
					<th>Free Days</th>
					<td colspan="1"><input type="text" name="lse_free_dys" caption="Free Days" style="width:75px;text-align:right;" class="input" value="" maxlength="5" dataformat="num" id="lse_free_dys" /></td>
					<th>Payment Type</th>
					<td><script type="text/javascript">ComComboObject('lse_pay_tp_cd', 2, 102, 0, 1);</script></td>
					<th>Create/Update User</th>
					<td><input type="text" name="cre_usr_id" caption="Create User" style="width:150px;text-align:center;" class="input2" value="" readonly="" id="cre_usr_id" /></td>
					<th>Create/Update Date</th>
					<td colspan="2"><input type="text" id="cre_dt" name="cre_dt" caption="Create Date" style="width:150px;text-align:center;" class="input2" value="" readonly=""/></td>
				</tr>
				<tr>
					<th>Remark(s)</th>
					<td colspan="8"><textarea id="agmt_rmk" name="agmt_rmk" rows="6" style="width:850px;ime-mode:disabled"></textarea></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->

<div class="wrap_result">
	<!-- opus_tab_btn(S) -->
		<div class="opus_design_tab sm">
			<script type="text/javascript">ComTabObject('tab1')</script>
		</div>
	<!-- opus_tab_btn(E) -->
	<div id="tabLayer" name="tabLayer" style="display:inline">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid clear" >
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_t1RowAdd" id="btn_t1RowAdd">Row Add</button><!--
				--><button type="button" class="btn_normal" name="btn_t1RowDelete" 	id="btn_t1RowDelete">Row Delete</button><!--
				--><button type="button" class="btn_normal" name="btn_t1LoadExcel" 	id="btn_t1LoadExcel">Load Excel</button><!--
				--><button type="button" class="btn_normal" name="btn_t1DownExcel" 	id="btn_t1DownExcel">Down Excel</button>
			</div>
			<script type="text/javascript">ComSheetObject('t1sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
	
	<div id="tabLayer" name="tabLayer" style="display:none">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid clear" >
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_t2RowAdd" id="btn_t2RowAdd">Row Add</button><!--
				--><button type="button" class="btn_normal" name="btn_t2RowDelete" 	id="btn_t2RowDelete">Row Delete</button><!--
				--><button type="button" class="btn_normal" name="btn_t2LoadExcel" 	id="btn_t2LoadExcel">Load Excel</button><!--
				--><button type="button" class="btn_normal" name="btn_t2DownExcel" 	id="btn_t2DownExcel">Down Excel</button>
			</div>
			<script type="text/javascript">ComSheetObject('t2sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
	
	<div id="tabLayer" name="tabLayer" style="display:none">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid clear" >
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_t3RowAdd" id="btn_t3RowAdd">Row Add</button><!--
				--><button type="button" class="btn_normal" name="btn_t3RowDelete" 	id="btn_t3RowDelete">Row Delete</button><!--
				--><button type="button" class="btn_normal" name="btn_t3LoadExcel" 	id="btn_t3LoadExcel">Load Excel</button><!--
				--><button type="button" class="btn_normal" name="btn_t3DownExcel" 	id="btn_t3DownExcel">Down Excel</button>
			</div>
			<script type="text/javascript">ComSheetObject('t3sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
	
	<div id="tabLayer" name="tabLayer" style="display:none">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid clear" >
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_t4RowAdd" id="btn_t4RowAdd">Row Add</button><!--
				--><button type="button" class="btn_normal" name="btn_t4RowDelete" 	id="btn_t4RowDelete">Row Delete</button><!--
				--><button type="button" class="btn_normal" name="btn_t4LoadExcel" 	id="btn_t4LoadExcel">Load Excel</button><!--
				--><button type="button" class="btn_normal" name="btn_t4DownExcel" 	id="btn_t4DownExcel">Down Excel</button>
			</div>
			<script type="text/javascript">ComSheetObject('t4sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid clear" >
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_t4RowAdd2" id="btn_t4RowAdd2">Row Add</button><!--
				--><button type="button" class="btn_normal" name="btn_t4RowDelete2" 	id="btn_t4RowDelete2">Row Delete</button>
			</div>
			<script type="text/javascript">ComSheetObject('t4sheet2');</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
	
	<div id="tabLayer" name="tabLayer" style="display:none">		
		<!-- opus_design_inquiry(S) -->
		<div class= "opus_design_inquiry">
			<table>
				<tbody>
					<colgroup>
						<col width="120"/>
						<col width="*"/>
					</colgroup>
					<tr>
						<th>Build Down Date</th>
						<td>
						<input type="hidden" name="agmt_chg_val" style="width:45px;text-align:right;ime-mode:disabled;" class="input1" value="" dataformat="num" maxlength="3" caption="Build Down Period" id="agmt_chg_val" />
						<input type="text" name="bld_dwn_end_dt" caption="Build Up" style="width:75px;text-align:center;" class="input1" value="" dataformat="ymd" id="bld_dwn_end_dt" /><!--
									--><button type="button" id="btns_calendar4" name="btns_calendar4" class="calendar ir"></button>&nbsp;&nbsp;</td>
					</tr>
					<tr>
						<td colspan="2"><h3 class="title_design" style="margin:10px 0 0 0;">Post Build Down Penalty</h3></td>
					</tr>	
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid clear" >
			<script type="text/javascript">ComSheetObject('t5sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
	
	<div id="tabLayer" name="tabLayer" style="display:none">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid clear" >
			<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_t6RowAdd2" id="btn_t6RowAdd2">Row Add</button><!--
				--><button type="button" class="btn_normal" name="btn_t6RowDelete2" 	id="btn_t6RowDelete2">Row Delete</button><!--
				--><button type="button" class="btn_normal" name="btn_t6LoadExcel" 	id="btn_t6LoadExcel">Load Excel</button><!--
				--><button type="button" class="btn_normal" name="btn_t6DownExcel" 	id="btn_t6DownExcel">Down Excel</button>
			</div>
			<script type="text/javascript">ComSheetObject('t6sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
</div>
</form>
