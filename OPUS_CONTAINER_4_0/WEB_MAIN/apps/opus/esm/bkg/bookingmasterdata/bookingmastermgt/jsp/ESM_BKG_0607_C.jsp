<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0607_C.jsp
*@FileTitle  : Harmonized Tariff Code(HT Code 조회 화면)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg0607Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0607Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			// error from server
	String strErrMsg = "";						// error message
	int rowCount	 = 0;						// count of DB resultSET list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String hamo_tp_cd		= "";
	String hamo_trf_cd		= "";
	String hamo_cd_desc		= "";
	String calllFunc 		= "";
	String main_page = "";
	Logger log = Logger.getLogger("com.clt.apps.BookingMasterData.BookingMasterMgt");
	
	try {
		main_page = request.getParameter("main_page");
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmBkg0607Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		hamo_tp_cd =  JSPUtil.getNull(JSPUtil.getParameter(request, "hamo_tp_cd"),"T");
		hamo_trf_cd =  JSPUtil.getParameter(request, "hamo_trf_cd");
		hamo_cd_desc =  JSPUtil.getParameter(request, "hamo_cd_desc");
		
		calllFunc  = JSPUtil.getParameter(request, "func");
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

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
<input type="hidden" name="f_cmd" 			id="f_cmd">
<input type="hidden" name="pagerows" 		id="pagerows">
<input type="hidden" name="calllFunc" 		id="calllFunc" 		value="<%=calllFunc%>">
<input type="hidden" name="sel_hamo_tp_cd" 	id="sel_hamo_tp_cd" value="<%=hamo_tp_cd%>">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" 		id="btn_Retrieve">Retrieve</button><!--  
		--><button type="button" class="btn_normal" name="btn_save"  			id="btn_save">Save</button><!--  
		--><button type="button" class="btn_normal" name="btn_DownExcel" 		id="btn_DownExcel">Down Excel</button><!--  
		--><%if(!"true".equals(main_page)) {%><!--  
		--><!-- <button type="button" class="btn_accent" name="btn_Close" 			id="btn_Close">Close</button> -->	
		<%} %>
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
<div class="opus_design_inquiry">
	<table>
		<tbody>
			<colgroup>
		 		<col width="1%"/>
				<col width="10%"/>
				<col width="4.5%"/>
				<col width="5%"/>
				<col width="5%"/>
				<col width="*" />
		    </colgroup>
		    <tr class="h23">
				<th style="text-align:left;">Code Type</th>
				<td>
					<script type="text/javascript">ComComboObject('hamo_tp_cd', 2, 60, 0,0,0);</script>
				</td>
				<th style="text-align:left;"><span id="cd_title">HTS</span> Code</th>
				<td><input type="text" name="hamo_trf_cd" id="hamo_trf_cd" class="input" style="width:90px; value="<%=hamo_trf_cd%>" style="ime-mode:disabled" dataformat="num" caption="Harmonized Tariff Code" maxlength="10"></td>
				<th style="text-align:left;">Application Date</th>
				<td><input type="text" name="exp_dt" id="exp_dt" class="input" style="width:96px; value="" class="input1" maxlength="10" dataformat="ymd"></td>
				<td></td>				
				<td></td>
				<td></td>
			</tr>
			<tr class="h23">
				<th style="text-align:left;">Description</th>
				<td colspan="3">
					<input type="text" name="hamo_cd_desc" id="hamo_cd_desc" class="input" style="width:370px;" value="<%=hamo_cd_desc%>" style="ime-mode:disabled" dataformat="eng"  caption="Description" maxlength="100" otherchar=" ">
				</td>
				<td></td>
				<td></td>
			</tr>
			<tr class="h23">
				<th style="text-align:left;">Category</th>
				<td>
					<input type="text" name="hamo_cate_ctnt" id="hamo_cate_ctnt" class="input" style="width:100px;" value="" style="ime-mode:disabled" caption="Category" maxlength="50">
				</td>
				<th style="text-align:left;">FDA P/N</th>
				<td>
					<select name="fda_decl_flg"style="width:60px;">
						<option value="" selected>ALL</option>
						<option value="Y">Y</option>
						<option value="N">N</option>
					</select>
				</td>			
				<th>Including Deleted Code</th>
				<td><input type="checkbox" name="delt_flg" id="delt_flg" class="trans"></td>	
			</tr>
		</tbody>
	</table>
</div>
</div>
<!-- opus_design_inquiry(E) -->

<!-- opus_design_grid(S) -->
<div class="wrap_result">
<div class="opus_design_grid">
	<!-- Button_Sub (E) -->
	<div class="opus_design_btn" style="text-align: right;">
		<button type="button" class="btn_accent" name="btn_add" 		id="btn_add">Row&nbsp;Add</button>
		<button type="button" class="btn_accent" name="btn_del" 		id=btn_del>Row&nbsp;Delete</button>
	</div>
	<!-- Button_Sub (E) -->
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>	
</div>
<!-- opus_design_grid(E) -->

	<!-- : ( Title ) (S) -->
		 <%-- <%@include file="../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TITLE.jsp"%> --%>
	<!-- : ( Title ) (E) -->

	<%-- <%@include file="../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_CLOSE.jsp"%> --%>
</form>
<%@include file="/bizcommon/include/common_opus.jsp"%>