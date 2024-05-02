<%
/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   ESM_BKG_0607.jsp
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
<%@ page import="com.clt.framework.core.controller.util.WebKeys"%>
<%@ page import="com.clt.framework.core.view.template.Screen"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg0607Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0607Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//DB ResultSet List count
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String hamo_tp_cd		= "";
	String hamo_trf_cd		= "";
	String hamo_cd_desc		= "";
	String calllFunc 		= "";
	String main_page="";
	String screenName		= "";
	String hs_aply_dt		= "";

	Logger log = Logger.getLogger("com.clt.apps.BookingMasterData.BookingMasterMgt");
	
	try {
		main_page=request.getParameter("main_page");
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmBkg0607Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		log.debug("====================================");
		Screen screen = (Screen) request.getAttribute(WebKeys.CURRENT_SCREEN);
		screenName = screen.getName();
		log.debug("===================================="+screenName+":"+screenName.indexOf("POP"));
		
		hamo_tp_cd =  JSPUtil.getNull(JSPUtil.getParameter(request, "hamo_tp_cd"),"T");
		hamo_trf_cd =  JSPUtil.getParameter(request, "hamo_trf_cd");
		hamo_cd_desc =  JSPUtil.getParameter(request, "hamo_cd_desc");
		hs_aply_dt =  JSPUtil.getParameter(request, "hs_aply_dt");
		log.debug("===================================="+hs_aply_dt);
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
<input type="hidden" name="hs_aply_dt" 	id="hs_aply_dt" value="<%=hs_aply_dt%>">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!--
	--><button type="button" class="btn_accent" name="btn_Retrieve" 	id="btn_Retrieve">Retrieve</button><!--
	--><button type="button" class="btn_normal" name="btn_DownExcel"  	id="btn_DownExcel">Down Excel</button><!--
	--><% if (!"true".equals(request.getParameter("main_page"))) { %><!--
	--><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button><!--
	--><%} %><!--
	--></div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>

<!-- page_title_area(E) -->

<!-- wrap_search (S) -->
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
			 		<col width="80"/>
					<col width="200"/>
					<col width="80"/>
					<col width="200" />
					<col width="80" />
			    </colgroup>
			    <tr>
					<th>Code Type</th>
					<td><script type="text/javascript">ComComboObject('hamo_tp_cd', 2, 60, 0,0,0);</script></td>				
					<th id="cd_title">HTS Code</th>				
					<td><input type="text" name="hamo_trf_cd" id="hamo_trf_cd" class="input" style="width:95px;" value="<%=hamo_trf_cd%>" style="ime-mode:disabled" dataformat="num" caption="Harmonized Tariff Code" maxlength="10"></td>
					<th style="text-align:left;">Application Date</th>
					<td><input type="text" name="exp_dt" id="exp_dt" class="input" style="width:95px;" value="<%=hs_aply_dt%>" style="ime-mode:disabled" dataformat="ymd" caption="Harmonized Tariff Code" maxlength="10"></td>
					
					<td align="left" style="color: red;">&nbsp;<span id="span_hs_aply_dt_msg"/></span></td>
					
					<td></td>
					<td></td>
				</tr>
			</tbody>
		</table>
		<table>
			<tbody>
				<colgroup>
			 		<col width="80"/>
					<col width="*" />
			    </colgroup>
				<tr>
					<th>Description</th>
					<td><input type="text" name="hamo_cd_desc" id="hamo_cd_desc" class="input" style="width:375px; text-align:left;" value="<%=hamo_cd_desc%>" style="ime-mode:disabled" dataformat="eng"   caption="Description" otherchar=" "></td>
				</tr>
			</tbody>
		</table>
		<table>
			<tbody>
				<colgroup>
			 		<col width="80"/>
					<col width="200"/>
					<col width="80"/>
					<col width="*" />
			    </colgroup>
			    <tr>
					<th>Category</th>
					<td><input type="text" name="hamo_cate_ctnt" id="hamo_cate_ctnt" class="input" style="width:100px;" value="" style="ime-mode:disabled" caption="Category" maxlength="50"></td>
					<th>FDA P/N</th>
					<td><!--
					--><select name="fda_decl_flg" style="width:60px;"><!--
						--><option value="" selected>ALL</option><!--
						--><option value="Y">Y</option><!--
						--><option value="N">N</option><!--
					--></select><!--
					--></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_search (E) -->

<!-- wrap_result (S) -->
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
	<% if (screenName.indexOf("POP") > 0){ %>
		<!-- Button_Sub (E) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_confirm" 		id="btn_confirm">Select</button>
			<button type="button" class="btn_accent" name="btn_confirm_6digit" 	id=btn_confirm_6digit>Select 6 Digit</button>
		</div>
		<!-- Button_Sub (E) -->
	<%} %>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
<!-- wrap_result (E) -->

</form>
<%@include file="/bizcommon/include/common_opus.jsp"%>