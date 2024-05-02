<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_PSO_0038.jsp
*@FileTitle  : Tariff Simulation 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/06
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
<%@ page import="com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.event.VopPso0038Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopPso0038Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.EstimateInvoiceAudit.GeneralInvoiceAudit");
	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (VopPso0038Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch(Exception e) {
		out.println(e.toString());
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

<form name="form" id="form">
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />
<input id="yd_chg_no" name="yd_chg_no" value="" type="hidden" />
<input id="yd_chg_ver_seq" name="yd_chg_ver_seq" value="" type="hidden" />
<input id="curr_cd" name="curr_cd" value="" type="hidden" />
<input id="upd_usr_id" name="upd_usr_id" value="" type="hidden" />
<input id="upd_dt" name="upd_dt" value="" type="hidden" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!-- 
		 --><button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Calculation" id="btn_Calculation">Calculation</button><!-- 
	 --></div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->


<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry wFit">
	<table>
		<tbody>
			<colgroup>
				<col width="30px" />
				<col width="200px" />
				<col width="75px" />
				<col width="300px" />
				<col width="75px" />
				<col width="300px" />
				<col width="200px" />
				<col width="*" />
			</colgroup>
				<th>Port</th>
				<td><input id="port_cd" name="port_cd" dataformat="engup" style="width: 50px;" class="input1" value="" size="5" maxlength="5" type="text" /><button class="input_seach_btn" name="btn_port_cd" id="btn_port_cd" type="button"></button><script type="text/javascript">ComComboObject('yard_cd',2, 50, 0, 1);</script></td>
				<th>Account CD</th>
				<td><script type="text/javascript">ComComboObject('acct_cd',2, 96, 0, 1);</script><input id="account_nm" name="account_nm" style="width: 180px; text-align:left" class="input2" value="" readonly type="text" /></td>
				<th>Cost  CD</th>
				<td><script type="text/javascript">ComComboObject('cost_cd',2, 90, 0, 1);</script><input id="lgs_cost_nm" name="lgs_cost_nm" style="width: 240px; text-align:left" class="input2" value="" readonly type="text" /></td>
				<td align="left"><input type="checkbox" id="cpls_flg" name="cpls_flg" value="N" class="trans"/><label for= "cpls_flg"><b>Excl. tariffs not to be estimated</b></label></td>
				<td></td>
			</tr>
			<tr>
				<th title="Vessel Voyage Direction">VVD</th>
				<td><input id="vsl_cd" onpaste='clipboardDataEvent(event)' name="vsl_cd" dataformat="engup" style="width: 50px; ime-mode:disabled; text-align:center;" class="input" value="" maxlength="4" type="text" /><!-- 
				 --><input id="skd_voy_no" name="skd_voy_no" dataformat="num" style="width: 40px;ime-mode:disabled;text-align:center;" class="input" value="" maxlength="4" type="text" /><!-- 
				 --><input id="skd_dir_cd" name="skd_dir_cd" dataformat="engup" style="width: 25px; ime-mode:disabled;text-align:center;" class="input" value="" maxlength="1" type="text" /><!-- 
				 --><button class="input_seach_btn" name="btn_vvd_search" id="btn_vvd_search" type="button"></button><!-- 
				 -->&nbsp;<script type="text/javascript">ComComboObject('clpt_ind_seq', 0, 40, 0, 0);</script></td>
				<th>Issue Date</th>
				<td><input id="issue_date" name="issue_date" dataformat="ymd" maxlength="8" style="width: 75px; ime-mode:disabled" class="input1" value="" type="text" /><button class="calendar ir" name="btns_Calendar1" id="btns_Calendar1" type="button"></button></td>
				<th>Service Provider</th>
				<td><script type="text/javascript">ComComboObject('vndr_seq',2, 96, 0, 1);</script><input type="text" name="vndr_lgl_eng_nm" id="vndr_lgl_eng_nm" style="width: 180px; text-align:left" class="input2" value="" readonly></td>
				<td align="left"><input id="radioflag" name="radioflag" value="1" class="trans" checked="" type="radio" />&nbsp;&nbsp;<b>LOCAL</b><label></label><input id="radioflag" name="radioflag" value="2" class="trans" type="radio" />&nbsp;&nbsp;<b>USD</b></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</div>
<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- layout_wrap (S) -->
	<div class="layout_wrap">
	    <div class="layout_vertical_2" style="width: 32%">
	    	<!-- opus_design_grid(S) -->
		       <div class="opus_design_grid">
					<script type="text/javascript">ComSheetObject('sheet1');</script>
		       </div>
			<!-- opus_design_grid(E) -->
	    </div>
	    
	    <div class="layout_vertical_2" style="width: 2%;">
	       <table>
	       		<tr>
	       			<td>&nbsp;</td>
	       		</tr>
	       </table>
	    </div>
	    
	     <div class="layout_vertical_2" style="width: 32%">
	     	<!-- opus_design_grid(S) -->
		       <div class="opus_design_grid">
					<script type="text/javascript">ComSheetObject('sheet2');</script>
		       </div>
			<!-- opus_design_grid(E) -->
	    </div>
	    
	     <div class="layout_vertical_2" style="width: 2%;">
	       <table>
	       		<tr>
	       			<td>&nbsp;</td>
	       		</tr>
	       </table>
	    </div>
	    
	    <div class="layout_vertical_2" style="width: 32%">
	    	<!-- opus_design_grid(S) -->
		       <div class="opus_design_grid">
					<script type="text/javascript">ComSheetObject('sheet3');</script>
		       </div>
			<!-- opus_design_grid(E) -->
	    </div>
	</div>
	<!-- layout_wrap (E) -->

	<!-- opus_design_grid(S) -->
      <div class="opus_design_grid">
	      	<h3 class="title_design mar_btm_8">Tariff Cost Detail</h3>
	      	<br/>
			<script type="text/javascript">ComSheetObject('sheet4');</script>
      </div>
	<!-- opus_design_grid(E) -->

	<!-- opus_design_grid(S) -->
      <div class="opus_design_grid">
	      	<h3 class="title_design mar_btm_8">Invoice Detail</h3>
	      	<br/>
			<script type="text/javascript">ComSheetObject('sheet5');</script>
      </div>
	<!-- opus_design_grid(E) -->

	<!-- opus_design_grid(S) -->
      <div class="opus_design_grid" style="display: none;">
			<script type="text/javascript">ComSheetObject('sheet6');</script>
      </div>
	<!-- opus_design_grid(E) -->
</div>
</form>
