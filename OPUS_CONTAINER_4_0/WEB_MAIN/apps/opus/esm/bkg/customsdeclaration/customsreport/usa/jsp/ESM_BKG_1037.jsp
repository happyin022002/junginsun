<%
/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ESM_BKG_1037.jsp
 *@FileTitle : Rail AMS History
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/07/09
 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.event.EsmBkg1037Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%
	EsmBkg1037Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //error from the server
	String strErrMsg = ""; //error messege

	String strUsr_id = "";
	String strUsr_nm = "";
	String cntr_no = "";
	String vvd = "";

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg1037Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}
		
		cntr_no = request.getParameter("cntr_no");
		vvd = request.getParameter("vvd");
		
	} catch (Exception e) {
		out.println(e.toString());
	}
%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			//showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>


<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="pageno" value="ESM_BKG_1037" id="pageno" />
<input type="hidden" name="p_bl_no" id="p_bl_no" value="<%= request.getParameter("bl_no") == null ? "" : request.getParameter("bl_no") %>">
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><span>US AMS : Rail AMS History</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_Print" id="btn_Print">Print</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>			
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
	
</div>
<!-- page_title_area(E) -->
<!-- Wrap_Search_area(S) -->
<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
		<table>
					<tr>
						<th>Container No.</th>
						<td><input type="text" name="cntr_no" style="width:88px;ime-mode:disabled;" class="input1"  id="cntr_no"  maxlength="14" value="<%=StringUtil.xssFilter(cntr_no) %>" required readonly/> </td>
						<th>B/L No.</th>
						<td><script type="text/javascript">ComComboObject('bl_no', 1, 130, 0, 0);</script></td>
						<th>F</th>
						<td><input type="text" name="f" style="width:20px;" class="input2" value="" readonly id="f" /> </td>
						<th>O</th>
						<td><input type="text" name="o" style="width:20px;" class="input2" value="" readonly id="o" /> </td>
						<th>C</th>
						<td><input type="text" name="c" style="width:20px;" class="input2" value="" readonly title="" id="c" /> </td>
					</tr>
				</tbody>
			<colgroup>
				<col width="80">
				<col width="50">
				<col width="50">
				<col width="135">
				<col width="50">
				<col width="50">
				<col width="50">
				<col width="50">
				<col width="50">
				<col width="70">
				<col width="50">
				<col width="70">
				<col width="50">
				<col width="*">
			</colgroup>
					<tr>
						<th title="Vessel Voyage Direction">VVD</th>
						<td><input type="text" name="vvd" style="width:75px;" class="input2" value="<%=StringUtil.xssFilter(vvd) %>" readonly id="vvd" /><input type="text" name="vsl_nm" style="width:109px;" class="input2" value="" readonly id="vsl_nm" /> </td>
						<th title="Port of Loading">POL</th>
						<td><input type="text" name="pol" style="width:50px;" class="input2" value="" readonly id="pol" /> </td>
						<th title="Port of Discharging">POD</th>
						<td><input type="text" name="pod" style="width:50px;" class="input2" value="" readonly id="pod" /> </td>
						<th>ETA</th>
						<td><input type="text" name="eta" style="width:80px;" class="input2" value="" readonly id="eta" /> </td>
						<th title="Place of Delivery">DEL</th>
						<td><input type="text" name="del" style="width:50px;" class="input2" value="" readonly id="del" /> </td>
						<th>HUB</th>
						<td><input type="text" name="hub" style="width:50px;" class="input2" value="" readonly id="hub" /> </td>
						<th>R/D Term</th>
						<td><input type="text" name="r" style="width:20px;" class="input2" value="" readonly id="r" /><input type="text" name="d" style="width:20px;" class="input2" value="" readonly id="d" /> </td>
					</tr>
					<tr>
						<th>Q'ty</th>
						<td><input type="text" name="qty" style="width:75px;text-align:right;" class="input2" value="" readonly id="qty" /><input type="text" name="qty_tp" style="width:35px;" class="input2" value="" readonly id="qty_tp" /> </td>
						<th>WGT</th>
						<td><input type="text" name="wgt" style="width:72px;text-align:right;" class="input2" value="" readonly id="wgt" /><input type="text" name="wgt_up" style="width:35px;" class="input2" value="" readonly id="wgt_up" /> </td>
					</tr>
		</table>
</div>
</div>					

<div class="wrap_result">
<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
	<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>	
</div>
</form>	
	
	