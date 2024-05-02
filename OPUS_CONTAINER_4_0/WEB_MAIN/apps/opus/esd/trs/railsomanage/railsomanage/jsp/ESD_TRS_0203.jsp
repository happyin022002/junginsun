<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESD_TRS_0203.jsp
*@FileTitle  : Creating USA Rail Billing Empty Repo.
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/26
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.trs.railsomanage.railsomanage.event.EsdTrs0201Event"%>
<%
	SignOnUserAccount account = null;  
	EsdTrs0201Event  event = null;
	Exception serverException   = null;			
	String strErrMsg = "";								 

	String today = DateTime.getFormatString("yyyyMMdd");
	String beforeOneMonth = DateTime.addDays(today, 30);
	String selKIND = "";
	String selCntrSize = "";
	String optionStr = "000020:ALL:ALL";
	try {
		account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		selCntrSize  = JSPUtil.getCodeCombo("cntr_size", "01", "style=width:58", "CD00937", 0, optionStr);
		event = (EsdTrs0201Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		}
		loadPage();
	}
</script>

<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="hid_frmdate" value="">
<input type="hidden" name="hid_todate" value="">
<input type="hidden" name="hid_trsp_cost_mod_cd">
<input type="hidden" name="hid_ref_id">
<input type="hidden" name="hid_fm_nod_cd">
<input type="hidden" name="hid_to_nod_cd">
<input type="hidden" name="hid_eq_tpsz_cd">
<input type="hidden" name="rail_billing_type" value="M">
<input type="hidden" name="eq_no_verify" value="">
<input type="hidden" name="frm_node_verify" value="">
<input type="hidden" name="hid_cntr_no" value="">
<input type="hidden" name="hid_cntr_tpsz_cd" value="">
<input type="hidden" name="hid_more_qty" value="">
<input type="hidden" name="hid_curr_dt" value="">
<input type="hidden" name="page_type" value="">
<input type="hidden" name="to_nod_verify" value="">

	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		
		<!-- page_title(S) -->
	    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->
	
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
			--><button type="button" class="btn_normal" name="btn_reset" id="btn_reset">New</button><!--
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
	
		<!-- opus_design_inquiry(S) -->
<div class="wrap_search">		
	<div class="opus_design_inquiry" id="MiniLayer">
		<!--  MiniLayer (S) -->
		<table>
			<tr>
				<td>
					<table>
						<colgroup>				            
				            <col width="110" />
				            <col width="205" />
				            <col width="80" />
				            <col width="150" />	
				            <col width="100" />
				            <col width="120" />	
				            <col width="140" />
				            <col width="*" />
						</colgroup>
						<tbody>
							<tr>
								<th>Departure Date</th>
								<td>
									<input name="frm_plandate" type="text" dataformat="ymd" style="width:75px;" value="<%=today%>" maxlength="8" onFocus="javascript:delHypen(this);" onBlur="javascript:getHypen(this); getDateBetween(this);">~&nbsp;<!--
									--><input name="to_plandate" type="text" dataformat="ymd" style="width:75px;" value="<%=beforeOneMonth%>" maxlength="8" onFocus="javascript:delHypen(this);" onBlur="javascript:getHypen(this);" onKeyup="javascript:doSearchEnter();"><!--
									--><button type="button" class="calendar" id="btns_calendar" name="btns_calendar"></button>
								</td>
								<th>Office Code</th>
								<td>
									<input name="ctrl_ofc_cd" type="text" style="width:103px;" value="<%=account.getOfc_cd()%>" onBlur="setgetUpper(this);" readonly>	
								</td>
								<th>Reference No.</th>
								<td>
									<input name="refer_no" type="text" style="width:117px;" value="" dataformat="engup"><!--
									--><button type="button" class="multiple_inq" id="btns_multirefer" name="btns_multirefer"></button>																	
								</td>
								<th>Container No.</th>
								<td>
									<input name="cntr_no" type="text" style="width:116px;" value="" onKeyup="javascript:doSearchEnter();" onChange="javascript:this.value=cntrCheckDigit(this.value);" dataformat="engup"><!--
									--><button type="button" class="multiple_inq" id="btns_multicntr" name="btns_multicntr"></button>									
								</td>
								<td></td>
							</tr>
								<tr>

								<th>Rail Origin</th>
								<td><input name="frm_node" type="text" style="width:50px;" maxlength="5" onChange="getComboList(this,frm_yard, 'F');" dataformat="engup"><!--								
									--><script type="text/javascript">ComComboObject('frm_yard', 1, 49, 0)</script><!--
									--><button type="button" class="input_seach_btn" id="btns_frmnode" name="btns_frmnode"></button>									
								</td>
								<th>Rail Destination</th>
								<td><input name="to_node" type="text" style="width:48px;" maxlength="5" onChange="getComboList(this,to_yard, 'T');" dataformat="engup"><!--								
									--><script type="text/javascript">ComComboObject('to_yard', 1, 65, 0)</script><!--
									--><button type="button" class="input_seach_btn" id="btns_tonode" name="btns_tonode"></button>								
								</td>
								<th>Container Type/Size</th>
								<td><select name="cntr_type" id="cntr_type" style="width:59px;" onChange=""><!-- 
									--><option value="ALL" selected>ALL</option><!--
									--><option value="A">A</option><!--
									--><option value="D">D</option><!--
									--><option value="F">F</option><!--
									--><option value="O">O</option><!--
									--><option value="P">P</option><!--
									--><option value="R">R</option><!--
									--><option value="S">S</option><!--
									--><option value="T">T</option><!--
								--></select><!--
								--><%=selCntrSize%><!--
							--></td>								
							</tr>
						</tbody>
					</table>
				</td>
			</tr>
		</table>
	</div>
</div>	
<div class="wrap_result">	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable">
		<!-- opus_grid_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btng_apply" id="btng_apply">Apply</button>
		</div>
		<!-- opus_grid_btn(E) -->
		<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script type="text/javascript">ComSheetObject('sheet1');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->	    
	</div>
	<!-- opus_design_grid(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable">
		<!-- opus_grid_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btng_fillincontainers" id="btng_fillincontainers">Fill in CNTR No.</button><!--
			--><button type="button" class="btn_normal" name="btng_verify" id="btng_verify">Verify</button><!--
			--><button type="button" class="btn_normal" name="btng_irgadjust" id="btng_irgadjust">IRG Adjust</button><!--
			--><button type="button" class="btn_normal" name="btng_socreation" id="btng_socreation">S/O Creation</button>
		</div>
		<!-- opus_grid_btn(E) -->
		<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script type="text/javascript">ComSheetObject('sheet2');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->	    
	</div>
	<!-- opus_design_grid(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable">		
		<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script type="text/javascript">ComSheetObject('sheet3');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->	    
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>