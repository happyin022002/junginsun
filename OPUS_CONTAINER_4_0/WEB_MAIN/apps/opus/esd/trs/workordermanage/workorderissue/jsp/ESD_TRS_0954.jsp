<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0954.jsp
*@FileTitle  : 3rd Party Interface
*@author     : CLT
*@version    : 1.0
*@since      : 2014/
=========================================================
*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.bizcommon.util.BizComUtil"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.trs.workordermanage.workorderissue.event.EsdTrs0023Event"%>
<%@ page import="com.clt.apps.opus.esd.trs.invoicemanage.surchargeinputinquiry.event.EsdTrs0918Event"%>

<%
	EsdTrs0023Event  event = null;				
	Exception serverException   = null;			
	DBRowSet rowSet	  = null;							 
	String strErrMsg = "";								
	int rowCount	 = 0;								
	SignOnUserAccount account = null;
	try {
		account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		event = (EsdTrs0023Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	} catch(Exception e) {
		out.println(e.toString());
	}
	String unique_cd = JSPUtil.getNull(request.getParameter("unique_cd"));
	String open_mode = JSPUtil.getNull(request.getParameter("open_mode")); //input/modify/search
	String step_cd = JSPUtil.getNull(request.getParameter("step_cd"));
	String trsp_so_ofc_cty_cd = JSPUtil.getNull(request.getParameter("trsp_so_ofc_cty_cd"));
	String trsp_so_seq = JSPUtil.getNull(request.getParameter("trsp_so_seq"));
	String main_row = JSPUtil.getNull(request.getParameter("main_row"));
    String rate = JSPUtil.getNull(request.getParameter("rate"));
	String cal_logic = JSPUtil.getNull(request.getParameter("cal_logic")); // TM(multiplication)/DV(division)
	String sheet_arr_no = JSPUtil.getNull(request.getParameter("sheet_arr_no"));// surcharge sheet array no of parent when using 'bySheet' 
	String bkg_no = JSPUtil.getNull(request.getParameter("bkg_no"));
	String eq_no = JSPUtil.getNull(request.getParameter("eq_no"));
	String wo_no = JSPUtil.getNull(request.getParameter("wo_no"));
	String curr_cd = JSPUtil.getNull(request.getParameter("curr_cd"));
%>

<script type="text/javascript">
<%=JSPUtil.getIBCodeCombo("bill_case", "01", "CD00946", 0, " |")%>
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		initCurrency();
		callCurrency();
	}
</script>

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="curr_cd" value="<%=curr_cd%>" id="curr_cd" />
<input type="hidden" name="apply_currency" value="<%=curr_cd%>" id="apply_currency" />
<input type="hidden" name="unique_cd" value="<%=unique_cd%>" id="unique_cd" />
<input type="hidden" name="open_mode" value="<%=open_mode%>" id="open_mode" />
<input type="hidden" name="step_cd" value="<%=step_cd%>" id="step_cd" />
<input type="hidden" name="trsp_so_ofc_cty_cd" value="<%=trsp_so_ofc_cty_cd%>" id="trsp_so_ofc_cty_cd" />
<input type="hidden" name="trsp_so_seq" value="<%=trsp_so_seq%>" id="trsp_so_seq" />
<input type="hidden" name="ofc_cty_cd" value="<%=trsp_so_ofc_cty_cd%>" id="ofc_cty_cd" />
<input type="hidden" name="so_seq" value="<%=trsp_so_seq%>" id="so_seq" />
<input type="hidden" name="main_row" value="<%=main_row%>" id="main_row" />
<input type="hidden" name="rate" value="<%=rate%>" id="rate" />
<input type="hidden" name="cal_logic" value="<%=cal_logic%>" id="cal_logic" />
<input type="hidden" name="sheet_arr_no" value="<%=sheet_arr_no%>" id="sheet_arr_no" />
<input type="hidden" name="prefix" value="surcharge_" id="prefix" />
<input type="hidden" name="FORM_CRE_USR_ID" value="<%=account.getUsr_id()%>" id="FORM_CRE_USR_ID" />
<input type="hidden" name="FORM_USR_OFC_CD" value="<%=account.getOfc_cd()%>" id="FORM_USR_OFC_CD" />

<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title">
			<span>3rd Party Interface</span>
		</h2>
		<!-- page_title(E) -->
	</div>
	<!-- page_title_area(E) -->
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<tbody>
					<colgroup>
						<col width="50" />
						<col width="150" />
						<col width="35" />
						<col width="50" />
						<col width="150" />
						<col width="*" />
					</colgroup>
					<tr>
						<th>Booking No.</th>
						<td><input name="text22" type="text" class="input2" style="width:100px;" readonly value="<%=bkg_no%>" id="text22" /></td>
						<td></td>
						<th>Equipment No.</th>
						<td><input name="text22" type="text" class="input2" style="width:100px;" readonly value="<%=eq_no%>" id="text22" /></td>
						<td></td>
					</tr>
					<tr>
						<th>Work Order No.</th>
						<td><input name="text22" type="text" class="input2" style="width:100px;" readonly value="<%=wo_no%>" id="text22" /></td>
						<td></td>
						<th>Currency</th>
						<td><input name="text22" type="text" class="input2" style="width:100px;" readonly value="<%=curr_cd%>" id="text22" /></td>
						<td></td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	
	<div class="wrap_result">
		<div class="opus_design_grid" id="mainTable">
			<div class="opus_design_btn">
				<button type="button" class="btn_normal"  id="btng_save" name="btng_save" style="display:none">Save</button>
			</div>
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<div class="opus_design_grid" id="hiddenTable" style="display:none">
			<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
		<div class="opus_design_grid" id="hiddenTable" style="display:none">
			<script type="text/javascript">ComSheetObject('sheet3');</script>
		</div>
		<div class="opus_design_grid" id="hiddenTable" style="display:none">
			<script type="text/javascript">ComSheetObject('sheet4');</script>
		</div>
	</div>
</div>

</form>