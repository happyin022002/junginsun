<%
/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : EES_MNR_0019.jsp
 *@FileTitle  : Repair Estimate Creation
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/13
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.event.EesMnr0019Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0019Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Occurred error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//Row count of retrieved database data

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	
	Logger log = Logger.getLogger("com.clt.apps.OperationManage.RepairMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	    strOfc_cd = account.getOfc_cd();

		event = (EesMnr0019Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//Extracting retrieved data from server on load screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<!--Use a common at MNR  -->
<script type="text/javascript">
	var selfOfcCd = "<%=strOfc_cd%>";
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>


<form name="form" id="form">
<div style="display:none;"><script type="text/javascript">ComSheetObject('sheet1');</script></div>
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<!-- Variable for written estimates and inspection divide-->
<input type="hidden" name="rqst_type" value="rqst_cre" id="rqst_type" />
<!-- 이화면에서 입력되는 데이타는 전부  Manual -->
<input type="hidden" name="mnr_inp_tp_cd" value="M" id="mnr_inp_tp_cd" />
<input type="hidden" name="eq_tpsz_cd" value="" id="eq_tpsz_cd" />

<!-- AGMT데이타 콤보용  -->
<input type="hidden" name="edi_id" id="edi_id" />

<!-- AGMT추출용  -->
<input type="hidden" name="agmt_ofc_cty_cd" id="agmt_ofc_cty_cd" />
<input type="hidden" name="agmt_seq" id="agmt_seq" />
<input type="hidden" name="agmt_ver_no" id="agmt_ver_no" />

<!-- 견적서 저장용 키값  -->
<input type="hidden" name="rpr_rqst_seq" id="rpr_rqst_seq" />
<input type="hidden" name="rpr_rqst_ver_no" id="rpr_rqst_ver_no" />
<input type="hidden" name="rpr_sts_cd" id="rpr_sts_cd" />
<input type="hidden" name="rpr_offh_flg" value="N" id="rpr_offh_flg" />
<input type="hidden" name="disp_flg" value="N" id="disp_flg" />
<input type="hidden" name="rpr_rqst_tmp_seq" value="1" id="rpr_rqst_tmp_seq" />
<input type="hidden" name="rpr_rqst_lst_ver_flg" value="Y" id="rpr_rqst_lst_ver_flg" />
<input type="hidden" name="n3pty_flg" value="N" id="n3pty_flg" />
<input type="hidden" name="file_seq" value="" id="file_seq" />
<input type="hidden" name="rqst_usr_id" value="<%=strUsr_id%>" id="rqst_usr_id" />
<input type="hidden" name="rpr_dtl_sts_cd" value="1" id="rpr_dtl_sts_cd" />
<input type="hidden" name="apro_ofc_cd" value="<%=strOfc_cd%>" id="apro_ofc_cd" />
<input type="hidden" name="vndr_seq" id="vndr_seq" />

<!-- RD용  -->
<input type="hidden" name="com_mrdPath" value="apps/opus/ees/mnr/operationmanage/repairmgt/report/EES_MNR_0181.mrd" id="com_mrdPath" />
<input type="hidden" name="com_mrdArguments" value="" id="com_mrdArguments" />
<input type="hidden" name="com_mrdBodyTitle" value="" id="com_mrdBodyTitle" />

<!-- 오디팅용 컬럼  -->
<input type="hidden" name="auto_amt" id="auto_amt" />
<input type="hidden" name="appoval_amt" id="appoval_amt" />
<input type="hidden" name="uppr_ofc_cd" id="uppr_ofc_cd" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_New" id="btn_New" type="button">New</button><!--
		--><button class="btn_normal" name="btn_Save" id="btn_Save" type="button">Save</button><!--
		--><button class="btn_normal" name="btn_Delete" id="btn_Delete" type="button">Delete</button><!--
		--><button class="btn_normal" name="btn_Request" id="btn_Request" type="button">Request</button><!--
		--><button class="btn_normal" name="btn_Print" id="btn_Print" type="button">Print</button>
	</div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search_tab">
	<!-- layout_wrap(S) -->
	<div class="layout_wrap">
	    <div class="layout_vertical_2" style="width:410px;">
	    	<div class="opus_design_inquiry">
		        <table style="width:399px;">
					<tbody>
						<colgroup>
							<col width="110">
							<col width="*">
						</colgroup>
						<tr>
							<th>Service Provider</th>
							<td><script type="text/javascript">ComComboObject('combo_sp_name', 8, 280, 1, 1,0,false,1);</script></td>
						</tr>
					</tbody>
				</table>
				<table  style="width:399px;">
					<tbody>
						<colgroup>
							<col width="80">
							<col width="160">
							<col width="80">
							<col width="*">
						</colgroup>
						<tr>
							<th>Tariff No.</th>
							<td><input type="text" name="trf_no" id="trf_no" style="width:129px;" class="input2" value="" readOnly></td>
							<th>Cost Office</th>
							<td><input tabindex="0" type="text" name="cost_ofc_cd" id="cost_ofc_cd"  style="width:75px;" class = "input2" value = "<%=strOfc_cd%>" readOnly></td>
						</tr>
						<tr>
							<th>EQ Type</th>
							<td><script type="text/javascript">ComComboObject('eq_knd_cd', 1, 130, 1, 3,0,false,0);</script></td>
							<th>Currency</th>
							<td><input type="text" name="curr_cd" id="curr_cd" style="width:75px;" class="input2" value="" readOnly></td>
						</tr>
						<tr>
							<th>Transmission</th>
							<td><script type="text/javascript">ComComboObject('trsm_mod_cd', 1, 130, 1, 3,0,false,0);</script></td>
							<th>Measure</th>
							<td><input type="text" name="mnr_meas_ut_nm" id="mnr_meas_ut_nm" style="width:75px;" class="input2" value="" readOnly></td>
						</tr>
					</tbody>
				</table>
			</div>
	    </div>
	    <div class="layout_vertical_2" style="width:60%">
	        <!-- opus_design_grid(S) -->
	        <div class="opus_design_grid">
	            <script type="text/javascript">ComSheetObject('sheet2');</script>
	        </div>
	        <!-- opus_design_grid(E) -->
	    </div>
	    <table class="line_bluedot"><tr><td></td></tr></table>
	</div>
	<!-- layout_wrap(E) -->
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table >
			<tbody>
				<colgroup>
					<col width="85">
					<col width="150">
					<col width="80">
					<col width="140">
					<col width="80">
					<col width="140">
					<col width="90">
					<col width="*">
				</colgroup>
				<tr>
					<th>EQ No.</th>
					<td>
						<input required maxlength="14" style="width:120px;" type="text" name="rqst_eq_no" id="rqst_eq_no" value='' dataformat="engup" caption="EQ No" class="input1">
					</td>
					<th>Estimate No.</th>
					<td>
						<input maxlength="20" style="width:170px;" type="text" name="rqst_ref_no" id="rqst_ref_no" dataformat="engup" otherchar="-" caption="Estimate No" class="input">
					</td>
					<th>Repair Yard</th>
					<td>
						<input style="width:80px;" required type="text" name="rpr_yd_cd" id="rpr_yd_cd" value='' dataformat="engup" maxlength="7" caption="yard cd" class="input1"><!-- 
						<img src="img/btns_search.gif" name="btns_popup" width="19" height="20" alt="" border="0" align="absmiddle" style="cursor:pointer;cursor:hand">
						 --><button type="button" class="input_seach_btn" name="btns_popup" id="btns_popup"></button>
					</td>
					<th>Repair Status</th>
					<td colspan="2"><script type="text/javascript">ComComboObject('rpr_wrk_tp_cd', 1, 160, 1, 1, 0, false, 0);</script></td>
				</tr>
				<tr>
					<th>Damage Date</th>
					<td>
						<input name="eq_dmg_dt" id="eq_dmg_dt" type="text" style="width:80px;" class="input" value="" dataformat="ymd" maxlength="10">
						<!-- <img name="btns_calendar" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"> -->
						<button type="button" class="calendar" name="btns_calendar" id="btns_calendar"></button>
					</td>
					<th>Input User</th>
					<td>
						<input type="text" style="width:170px;" name="rqst_usr_nm" id="rqst_usr_nm" dataformat="engup" maxlength="50"  class="input2" size="10"  value="<%=strUsr_nm%>" readonly>
					</td>
					<th>Input Date</th>
					<td>
						<input type="text" style="width:80px;" name="rqst_dt" id="rqst_dt" dataformat="ymd" maxlength="10"  class="input2" size="10"  value="" readonly>
					</td>
					<td><lable for="rpr_offh_flg_temp">Off-hire</lable>&nbsp;<input name="rpr_offh_flg_temp" id="rpr_offh_flg_temp" type="checkbox" value="Y" class="trans"></td>
					<th width="80">Gate-In Date</th>
					<td><input type="text" style="width:80;" name="mvmt_dt" dataformat="ymd" maxlength="10"  class="input2" size="10"  value="" readonly></td>
				</tr>
			</tbody>
		</table>
	</div>
	<table class="line_bluedot"><tr><td></td></tr></table>
	<div class="opus_design_inquiry wFit">
		<table class="grid_2" style="width:979px">
			<tbody>
				<colgroup>
					<col width="50">
					<col width="100">
					<col width="60">
					<col width="80">
					<col width="50">
					<col width="20">
					<col width="50">
					<col width="20">
					<col width="70">
					<col width="70">
					<col width="100">
					<col width="100">
					<col width="*">
				</colgroup>
				<tr>
					<th style="text-align:center;">Repair</th>
					<td  id="Repair"> </td>
					<td>
						<button class="btn_etc" name="btn_detail" id="btn_detail" type="button">Detail(s)</button>
					</td>
					<th style="text-align:center;">IMM.EXIT</th>
					<td id="ImmExit"> </td>
					<th  style="text-align:center;">Off-Hire</th>
					<td id="OffHire"> </td>
					<th style="text-align:center;">Disposal</th>
					<td id="Disposal"> </td>
					<th style="text-align:center;">DPP (USD)</th>
					<td  id="DPP"> </td>
					<th style="text-align:center;">DV Value(USD)</th>
					<td id="DvValue"> </td>
				</tr>
				<tr>
					<th style="text-align:center;">MANU.DT</th>
					<td colspan="2" id="ManuDt"> </td>
					<th style="text-align:center;">TP/SZ</th>
					<td  id="TpSz"> </td>
					<th style="text-align:center;"> Term</th>
					<td align="center" id="Term"> </td>
					<th style="text-align:center;">Lessor</th>
					<td align="left" colspan="3" id="Lessor"> </td>
					<th style="text-align:center;">Warranty</th>
					<td align="center" id="Warranty"> </td>
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

<!-- opus_design_grid(S) -->	
<div class="opus_design_grid clear" name="tabLayer" id="tabLayer" style="display:inline;">
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_calc" id="btn_calc" type="button">Calculation</button><!--
		--><button class="btn_normal" name="btn_RowAdd" id="btn_RowAdd" type="button">Row Add</button><!--
		--><button class="btn_normal" name="btn_RowDel" id="btn_RowDel" type="button">Row Delete</button><!--
		--><button class="btn_normal" name="btn_DownExcel" id="btn_DownExcel" type="button">Down Excel</button>
		   <button class="btn_normal" name="btns_mvmt" id="btns_mvmt" type="button">Movement</button>
	</div>
	<script type="text/javascript">ComSheetObject('t1sheet1');</script>
	<div class="opus_design_inquiry">
		<table><tr><td height="5"></td></tr></table>
		<table  class="grid2" >
			<tbody>
				<colgroup>
					<col width="70">
					<col width="*">
				</colgroup>
				<tr>
					<th>Desc.</th>
					<td><input readonly name="mnr_desc" id="mnr_desc" type="text" style="width:99%;" class="input2" value=""></td>
				</tr>
				<tr>
					<th>Remark(s)</th>
					<td><textarea name="mnr_rpr_rmk" id="mnr_rpr_rmk" style="ime-mode:disabled;width:99%;height:22px;background-color:beige;resize:none;" maxlength="4000"></textarea></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_grid(E) -->

<!-- opus_design_grid(S) -->	
<div class="opus_design_grid clear" name="tabLayer" id="tabLayer" style="display:none;">
	<div class="layout_wrap">
	    <div class="layout_vertical_2" style="width:75%">
	       
        	<div id="t2_selection1" name="t2_selection1">
				<table >
					<tbody>
						<colgroup>
							<col width="150">
							<col width="*">
						</colgroup>
						<tr>
							<th>Damage Location Code</th>
							<td><input type="text" name="damageLocationCode" id="damageLocationCode" style="width:527px;" class="input2" value="" readOnly></td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="layout_wrap">
				<div id="t2_selection2" name="t2_selection2">
				    <div class="layout_vertical_2" style="width:170px;">
				    	<!-- opus_design_grid(S) -->
				    	<div class="opus_design_grid" style="height:150px;">
				    		<table style="width:160px;">
								<tbody>
									<colgroup>
										<col width="20">
										<col width="*">
									</colgroup>
									<tr>
										<th>
											<font size="5">D</font>
										</th>
										<td><script type="text/javascript">ComSheetObject('t2_sheet1');</script></td>
									</tr>
								</tbody>
							</table>
				    	</div>
				    	<div class="opus_design_grid" style="height:150px;">
				            <table  style="width:160px;">
								<tbody>
									<colgroup>
										<col width="20">
										<col width="*">
									</colgroup>
									<tr>
										<th>
											<font size="5">F</font>
										</th>
										<td><script type="text/javascript">ComSheetObject('t2_sheet2');</script></td>
									</tr>
								</tbody>
							</table>
				        </div>
				        <!-- opus_design_grid(E) -->
			        </div>			    	
			    
			    <div class="layout_vertical_2" style="width:360px;">
			        <!-- opus_design_grid(S) -->
			        <div class="opus_design_grid" style="height:150px;">
			            <table  style="width:350px;">
							<tbody>
								<colgroup>
									<col width="20">
									<col width="110">									
									<col width="*">
								</colgroup>
								<tr>
									<th>
										<font size="5">L</font>
									</th>
									<td colspan="2"><script type="text/javascript">ComSheetObject('t2_sheet3');</script></td>
								</tr>
								<tr>
									<td></td>
									<td align="left"><b>Front</b></td>
									<td align="right"><b>Door</b></td>
								</tr>
							</tbody>
						</table>
			        </div>
			        <div class="opus_design_grid" style="height:150px;">
			            <table  style="width:350px;">
							<tbody>
								<colgroup>
									<col width="20">
									<col width="110">
									<col width="*">
								</colgroup>
								<tr>
									<th>
										<font size="5">R</font>
									</th>
									<td colspan="2"><script type="text/javascript">ComSheetObject('t2_sheet4');</script></td>
								</tr>
								<tr>
									<td></td>
									<td align="left"><b>Front</b></td>
									<td align="right"><b>Door</b></td>
								</tr>
							</tbody>
						</table>
			        </div>
			        <!-- opus_design_grid(E) -->
			    </div>
			    <div class="layout_vertical_2" style="width:360px;">
			        <!-- opus_design_grid(S) -->
			        <div class="opus_design_grid">
			            <table  style="width:350px;">
							<tbody>
								<colgroup>
									<col width="20">
									<col width="110">
									<col width="*">
								</colgroup>
								<tr>
									<th>
										<font size="5">T</font>
									</th>
									<td colspan="2"><script type="text/javascript">ComSheetObject('t2_sheet5');</script></td>
								</tr>
								<tr>
									<td></td>
									<td align="left"><b>Front</b></td>
									<td align="right"><b>Door</b></td>
								</tr>
							</tbody>
						</table>
			        </div>
			        <div class="opus_design_grid">
			            <table  style="width:350px;">
							<tbody>
								<colgroup>
									<col width="20">
									<col width="110">
									<col width="*">
								</colgroup>
								<tr>
									<th>
										<font size="5">B</font>
									</th>
									<td colspan="2"><script type="text/javascript">ComSheetObject('t2_sheet6');</script></td>
								</tr>
								<tr>
									<td></td>
									<td align="left"><b>Front</b></td>
									<td align="right"><b>Door</b></td>
								</tr>
							</tbody>
						</table>
			        </div>
			        <div class="opus_design_grid">
			            <table  style="width:350px;">
							<tbody>
								<colgroup>
									<col width="20">
									<col width="*">
								</colgroup>
								<tr>
									<th>
										<font size="5">U</font>
									</th>
									<td><script type="text/javascript">ComSheetObject('t2_sheet7');</script></td>
								</tr>
							</tbody>
						</table>
			        </div>
			        <!-- opus_design_grid(E) -->
			    </div>
			</div>
	    </div>
	  </div>
	    <div class="layout_vertical_2" style="width:25%">
	    	<div class="opus_design_inquiry"><h3 class="title_design">Photo</h3></div>
	    	<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_FileAdd" id="btn_FileAdd">Row Add</button>
				<button type="button" class="btn_accent" name="btn_FileDel" id="btn_FileDel">Row Delete</button>
			</div>
	        <!-- opus_design_grid(S) -->
	        <div class="opus_design_grid">
	            <script type="text/javascript">ComSheetObject('t2_sheet8');</script>
	        </div>
	        <!-- opus_design_grid(E) -->
	    </div>
	</div>
</div>
</div>
<div style="display:none">
	<script type="text/javascript">ComUploadObject('upload1', '<%=session.getId()%>');</script>
</div>
<!-- Developer's task   -->
</form>