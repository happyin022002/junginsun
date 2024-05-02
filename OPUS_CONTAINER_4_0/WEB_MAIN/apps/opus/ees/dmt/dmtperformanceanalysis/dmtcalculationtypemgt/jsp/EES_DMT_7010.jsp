<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_7010.jsp
*@FileTitle  : Calculation Type Entry
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
<%@ page import="com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.event.EesDmt7010Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt7010Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//server exception
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//DB ResultSet count
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.DMTPerformanceAnalysis.DMTCalculationTypeMgt");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EesDmt7010Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
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

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="cnt_cd">
<input type="hidden" name="rgn_cd">
<input type="hidden" name="ste_cd">
<input type="hidden" name="loc_cd">
<input type="hidden" name="retry">
<input type="hidden" name="io_bnd_cd">
<input type="hidden" name="dmdt_calc_tp_cd">
<input type="hidden" name="val_curr" value="Y">
<input type="hidden" name="val_tobe" value="Y">
<input type="hidden" name="result">

<!-- page(S) -->
<!-- page_title_area(S) -->
<div class="page_title_area clear" >
	
	<!-- page_title(S) -->
    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--  
		--><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!-- 
		--><button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button>
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
            <col width="45px" />
            <col width="120px" />
            <col width="70px" />
            <col width="120px" />
            <col width="70px" />
            <col width="*" />
        </colgroup>
        <tbody>
			<tr>
				<th>Country</th>
				<td><script type="text/javascript">ComComboObject('combo1', 2, 60, 0);</script></td>
				<th><span id="Region">Region</span></th>
				<td><script type="text/javascript">ComComboObject('combo2', 2, 60, 0, 0, 0, true);</script></td>
				<th>Location</th>
				<td>
					<input type="text" style="width:50;" class="input" name="location" value="" maxlength="5" dataformat="engup"  OnKeyUp="checkLocation()">
				</td>
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
	<!-- opus_grid_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_normal" name="t1btng_rowadd" id="t1btng_rowadd">Row Add</button><!--  
		--><button type="button" class="btn_normal" name="t1btng_delete" id="t1btng_delete">Delete</button><!-- 
		--><button type="button" class="btn_normal" name="t1btng_save" id="t1btng_save">Save</button>
	</div>
	<!-- opus_grid_btn(E) -->

	<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
    <script type="text/javascript">ComSheetObject('sheet1');</script>
    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
 
    <div class="mar_top_8 mar_btm_8">
     * Coverage :Booking DEL (Inbound) & Booking POR(Outbound)<br>   
	 * Effective Date:  POD ETA(Inbound) & OP Movement(Outbound)
	</div>
	
	<table class="grid2" style="width:100%;"> 
		<tr>
			<th style="width:200px;" align="center">Exception Remark(s)</th>
			<td class="pad_top_8 pad_rgt_8 pad_btm_8 pad_left_8"><!-- POD: HKHKG, DEL: HK -> Dual<br>POD: US, DEL: MX -> Dual -->
			</td>
		</tr>
	</table>
</div>
<!-- opus_design_grid(E) -->
<!-- page(E) -->
</div>
</form>