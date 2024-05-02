<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESD_TRS_0223.jsp
*@FileTitle  : Agreement USA Rail Surcharge
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/28
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%> 
<%@ page import="com.clt.bizcommon.util.BizComUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%
	Exception					serverException		= null;			
	String						strErrMsg			= "";			
	String	userId		= "";
	String	ofcCd		= "";

	try {
		SignOnUserAccount account	= (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	userId						= account.getUsr_id();
	   	ofcCd						= account.getOfc_cd();
		serverException				= (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
  <%= BizComUtil.getIBCodeCombo("default_curr", "01", "CURR", 2, "")%>
  <%= JSPUtil.getIBCodeCombo("rail_scg_code", "", "CD02586", 0, "")%>
  <%= JSPUtil.getIBCodeCombo("spcl_cgo_cntr_tp_cd", "", "CD01507", 0, "")%>
  function setupPage(){
    loadPage();
  }
</script>

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="fm_account_ofc_cd"	  value="<%=ofcCd%>">
<input type="hidden" name="fm_account_usr_id"	  value="<%=userId%>">
<input type="hidden" name="hid_eff_dt" value="">
<input type="hidden" name="f_cmd">
<input type="hidden" name="cntr_vndr_svc_cd">
<input type="hidden" name="vndr_cost_cd">
<input type="hidden" name="vndr_cnt_cd">
<input type="hidden" id="trsp_tmp_seq" name="trsp_tmp_seq" /><!-- deliver to Update after Verify -->

	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		
		<!-- page_title(S) -->
	    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->
	
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">			
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--		
			--><button type="button" class="btn_normal" name="btn_minimize" id="btn_minimize">Minimize</button>
		</div>
		<!-- opus_design_btn(E) -->
	
	   	<!-- page_location(S) -->
	   	<div class="location">
			<!-- location 내용 동적생성 (별도 코딩 불필요) -->
	        <span id="navigation"></span>
	   	</div>
	   	<!-- page_location(E) -->
	</div>
	<!-- page_title_area(E) -->
	
	<div class="wrap_search_tab">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry" id="MiniLayer">
			<!--  MiniLayer (S) -->
			<table >
				<colgroup>				            
					<col width="100px" />
					<col width="200px" />
					<col width="130px" />
					<col width="130px" />
					<col width="" />
				</colgroup>
				<tbody>
					<tr>
						<th>Rail Company</th>
						<td><!--
						--><script type="text/javascript">ComComboObject('rail_road_code',2, 80, 0, 1);</script><!--
						--><input name="fm_vndr_nm" type="text" style="width:320px;" readonly class="input2"  dataformat="engup">
						</td>
						<th>Effective Date(as of)</th>					
						<td><!--
						--><input name="eff_dt" type="text" style="width:80px;" class="input" value="" maxlength="8" dataformat="ymd"><!--
							--><button type="button" class="calendar" name="btns_calendar"></button>
						</td>
						<td></td>
					</tr>
					<tr>
						<th>Agreement No.</th>
						<td><!--
						--><input name="fm_agmtno" type="text" style="width:80px;" class="input" value="" onBlur="setgetUpper(this);" dataformat="engup"><!--
							--><button type="button" class="input_seach_btn" name="btn_agmtno"></button>
						</td>
						<th>Reference No.</th>
						<td><!--
						--><input name="agmt_ref_no" type="text" style="width:110px;" class="input" value="" maxlength="20" dataformat="engup">
						</td>
						<td></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	
	<div class="wrap_result">
		<!-- opus_grid_btn(E) -->
	    <div class="opus_design_tab">     	 	
	        <script type="text/javascript">ComTabObject('tab1')</script>
	    </div>
	
		<!-- opus_design_tab(S) -->
		<div class="opus_design_grid">
			<!-- opus_grid_btn(S) -->
			<div class="opus_design_btn">
				<button type="button" class="btn_normal" name="btng_reset" id="btng_reset">Reset</button>
				<button type="button" class="btn_normal" name="btng_loadexcel" id="btng_loadexcel">File Import</button>
				<button type="button" class="btn_normal" name="btng_verify" id="btng_verify">Verify</button>
				<button type="button" class="btn_normal" name="btng_history" id="btng_history">History</button>
				<button type="button" class="btn_normal" name="btng_rowadd" id="btng_rowadd">Row Add</button>
				<button type="button" class="btn_normal" name="btng_delete" id="btng_delete">Row Delete</button>
				<button type="button" class="btn_normal" name="btng_update" id="btng_update">Update</button>
				<button type="button" class="btn_normal" name="btng_downexcel" id="btng_downexcel">Down Excel</button>
			</div>		
		    
			<!-- opus_design_grid(S) -->
			<div class="opus_design_grid" name="tabLayer" id="tabLayer" style="display:inline">			
				<script type="text/javascript">ComSheetObject('sheet1');</script>
			</div>
			
			<!-- opus_design_grid(S) -->
			<div class="opus_design_grid" name="tabLayer" id="tabLayer" style="display:none">
				<script type="text/javascript">ComSheetObject('sheet2');</script>
			</div>
            <!-- receive return data and deliver main Sheet for Verify -->
            <div class="opus_design_grid" style="width:360px;">
            <script type="text/javascript">ComSheetObject('sheet3');</script>
            </div>
            <!-- receive return data and deliver main Sheet for Verify -->
            <div class="opus_design_grid" style="width:360px;">
            <script type="text/javascript">ComSheetObject('sheet4');</script>
            </div>
		</div>
	</div>
	<div class="header_fixed"></div>
</form>
