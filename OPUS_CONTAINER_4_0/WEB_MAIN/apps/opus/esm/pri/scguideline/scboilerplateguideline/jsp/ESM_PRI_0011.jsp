<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0011.jsp
*@FileTitle  : Boiler Plate Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.scguideline.scboilerplateguideline.event.EsmPri0011Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmPri0011Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //error from server
	String strErrMsg = ""; //error message
	int rowCount = 0; //count of DB resultSET list

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.SCGuideline.SCBoilerPlateGuideline");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmPri0011Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="blpl_hdr_seq" value="">
<input type="hidden" name="blpl_seq" value="">
<input type="hidden" name="blpl_nm" value=" ">
<!-- seleted Duration -->
<input type="hidden" name="eff_dt_hidden" value="">
<input type="hidden" name="exp_dt_hidden" value="">

<!-- page(S) -->
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	
	<!-- page_title(S) -->
    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button>
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

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
	    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <table>
	    	<colgroup>
	            <col width="40" />
	            <col width="170" />
	            <col width="60" />
	            <col width="230" />
	            <col width="85" />
	            <col width="" />
	        </colgroup>
	        <tbody>
				<tr>
					<th>Year</th>
					<td class="stm">
					<script type="text/javascript">ComComboObject('blpl_ref_yr', 1, 65, 1, 2);</script>
					&nbsp;Boiler Plate
					</td>
					<th>Duration</th>
					<td>
						<script>ComComboObject('eff_dt', 2, 95, 1, 2);</script>												
						<span class="dash">~</span>						
						 <input name="exp_dt" 	id="exp_dt" 	type="text" 	style="width: 80px;"  value="" class="input1" caption="Expire Date" maxlength="10" dataformat="ymd" required>						 
					</td>
					<th>Confirmation</th>
					<td><input name="cfm_flg" type="text"	style="width: 58px;" value="" class="input1" readonly	caption="Confirmation"></td>
				</tr>
			</tbody>
		</table>
		<!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
	    <script>ComSheetObject('sheet0');</script>
	</div>
	<!-- opus_design_grid(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
	    <script>ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
	    <script>ComSheetObject('sheet2');</script>
	</div>
	<!-- opus_design_grid(E) -->

<!-- developer performance  end -->
</div>
</form>