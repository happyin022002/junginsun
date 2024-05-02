<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESD_PRD_0020.jsp
*@FileTitle  : Product Catalog Inquiry 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/22
=========================================================*/ 
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.event.EsdPrd0080Event"%>
<%

	EsdPrd0080Event  event = null;	
	Exception serverException   = null;
	String strErrMsg = "";

	try {
		event = (EsdPrd0080Event)request.getAttribute("Event");
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
		} // end if

		loadPage();
	}
</script>
<form method="post" name="form" id="form" action="">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="ld_dt" id="ld_dt">
<input type="hidden" name="iPage" id="iPage"> 
<input type="hidden" name="search_pctl_no" id="search_pctl_no">
<input type="hidden" name="por_n" id="por_n">
<input type="hidden" name="pol_n" id="pol_n">
<input type="hidden" name="pod_n" id="pod_n">
<input type="hidden" name="del_n" id="del_n">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!--
	--><button type="button" class="btn_accent" name="btn_retrieve" 		id="btn_retrieve">Retrieve</button><!--
	--><button type="button" class="btn_normal" name="btn_new" 			id="btn_new">New</button><!--
	--><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>									
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
	
</div>
<!-- page_title_area(E) -->
<div class= "wrap_search">

<!-- opus_design_inquiry(S) -->
		<div class= "opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="110" />
				<col width="140" />
				<col width="80" />
				<col width="120" />
				<col width="60" />
				<col width="120" />
				<col width="60" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<th title="Place of Receipt">POR</th>
						<td>
							<input type="text" name="por" id="por" class="input1" required dataformat="engup" caption="POR" maxlength="5" style="width:50px;text-align:center" value="" tabIndex="1" style="text-align:center"><!-- 
							 --><input name="por_yd_cd" id="por_yd_cd" type="text" dataformat="engup" maxlength="2" style="width:30px;" value="" tabIndex="2" ><!--
							 --><button type="button" class="input_seach_btn" name="btn_por" id="btn_por"></button>
						</td>
						<th title="Port of Loading">POL</th>
						<td>
							<input name="pol" id="pol" type="text" dataformat="engup" maxlength="5" style="width:50px;text-align:center" value="" tabIndex="3" style="text-align:center"><!--
							 --><input name="pol_yd_cd" id="pol_yd_cd" type="text" dataformat="engup" maxlength="2" style="width:30px;" value="" tabIndex="4" ><!--
							 --><button type="button" class="input_seach_btn" name="btn_pol" id="btn_pol"></button>
						</td>
						<th title="Port of Discharging">POD</th>
						<td>
							<input name="pod" id="pod" type="text" dataformat="engup" maxlength="5" style="width:50px;text-align:center" value="" tabIndex="5" style="text-align:center"><!--
							 --><input name="pod_yd_cd" id="pod_yd_cd" type="text" dataformat="engup" maxlength="2" style="width:30px;" value="" tabIndex="6" ><!--
							 --><button type="button" class="input_seach_btn" name="btn_pod" id="btn_pod"></button>
						</td>
						<th title="Place of Delivery">DEL</th>
						<td>
							<input name="del" id="del" type="text" class="input1" required dataformat="engup" caption="DEL" maxlength="5" style="width:50px;text-align:center" value="" tabIndex="7" style="text-align:center"><!--
							 --><input name="del_yd_cd" id="del_yd_cd" type="text" dataformat="engup" maxlength="2" style="width:30px;" value="" tabIndex="8" ><!--
							 --><button type="button" class="input_seach_btn" name="btn_del" id="btn_del"></button>
						</td>
				</tr>
				<tr>
					<th>R term</th>
					<td>
						<select name="rcv_t" id="rcv_t" class="input1" required style="width:50px" tabIndex="9" >
								<option value="Y" selected>Y</option>
								<option value="D">D</option>
						</select>
					</td>
					<th>D term</th>
					<td>
						<select name="del_t" id="del_t" class="input1" required style="width:50px"  tabIndex="10">
							<option value="Y" selected>Y</option>
							<option value="D">D</option>
						</select>
					</td>
					<th>TP/SZ</th>
					<td><input name="c_tpsz" id="c_tpsz" type="text" value="D4" class="input1" required caption="TP/SZ" dataformat="engup" maxlength="2" style="width:50px" tabIndex="11" onchange="FuncCheckTpSz(this)"></td>
					<th>Qty</th>
					<td><input name="c_qty" id="c_qty" type="text" value="1" class="input1" required caption="Qty" dataformat="float" maxlength="3" style="width:73px" value=""  tabIndex="12" onKeyDown="ComKeyEnter()" ></td>
				</tr>
				<tr>
					<th>Sailing Due Date</th>
					<td colspan="7"><input name="skd_date_fm" id="skd_date_fm" type="text" style="width:80px" dataformat="ymd" maxlength="12" tabIndex="13" onKeyDown="ComKeyEnter()" onKeyUp="chkField(this, 'date', false, null, null, '-')" onBlur="chkField(this, 'date', false, null, null, '-')"><!--
					 --><button type="button" class="calendar ir" name="btn_calendar" id="btn_calendar"></button>
					</td>
				</tr>				
			</tbody>
		</table>
	</div>
</div>
<div class="wrap_result">
<!-- opus_design_inquiry(E) -->

<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
    <!-- opus_design_btn(S) -->
	    <div class="opus_design_btn">
	    <!-- Content -->
			<button type="button" class="btn_normal" name="btng_dtl" id="btng_dtl">Detail</button>
	    </div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
		
	</div>
	
<!-- opus_design_grid(E) -->
<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btng_costdetail" id="btng_costdetail">Cost Detail</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet3');</script>
	</div>
</div>
<!-- opus_design_grid(E) -->
</form>