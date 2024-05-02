<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_7003.jsp
*@FileTitle  : Calculation Type Inquiry 
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
<%@ page import="com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.event.EesDmt7003Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt7003Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	
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
	   
	   
		event = (EesDmt7003Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// Retrieving the parameter values ​​for calls to pop-up page ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script language="javascript">
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

<!-- page(S) -->
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	
	<!-- page_title(S) -->
    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--  
		--><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!--  
		--><button type="button" class="btn_normal" name="btn_Minimize" id="btn_Minimize">Minimize</button><!--  
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

<!-- opus_design_inquiry(S) -->
<div class="wrap_search">
<div class="opus_design_inquiry">
    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
    <div id="sch_cond_div" style='display:block;'>
    <table>
    	<colgroup>
            <col width="70" />
            <col width="90" />
            <col width="105" />
            <col width="130" />
            <col width="60" />
            <col width="" />
        </colgroup>
        <tbody>
			<tr>
				<th>Country</th>
				<td style="padding-left:2"><script language="javascript">ComComboObject('combo1', 2, 60, 0, 0, 0, true);</script></td>
				<th><span id="Region">Region</span></th>
				<td><script language="javascript">ComComboObject('combo2', 2, 60, 0, 0, 0, true);</script></td>
				<th>Location</th>
				<td>
					<input type="text" style="width:50px;" class="input" name="location" value="" maxlength="5" dataformat="engup" OnKeyUp="checkLocation()">
				</td>
			</tr>
			<tr>
				<th>Bound</th>
				<td>
					<select name="io_bnd_cd" style="width:60px;" class="input">
						<option value="" selected>All</option>
						<option value="I">Inbound</option>
						<option value="O">Outbound</option>
					</select>
				</td>
				<th>Calculation Type</th>
				<td width="">
					<select name="dmdt_calc_tp_cd" style="width:100px;" class="input">
						<option value="" selected>All</option>
						<option value="C">Combined</option>
						<option value="D">Dual</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>Validity</th>
				<td class="sm"><input type="checkbox" name="val_curr" value="Y" class="trans" checked>Current</td>
				<td class="sm"><input type="checkbox" name="val_tobe" value="Y" class="trans" checked>To-be</td>
				<td class="sm"><input type="checkbox" name="val_exp" value="Y" class="trans">Expired</td>
			</tr>
		</tbody>
	</table>
	</div>
	<!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
</div>
</div>
<!-- opus_design_inquiry(E) -->

<!-- opus_design_grid(S) -->
<div class="wrap_result">
<div class="opus_design_grid">
	<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
    <script language="javascript">ComSheetObject('sheet1');</script>
    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
    
    <div class="grid_option_left" style="width:100%;">
    	<div class="mar_top_8 mar_btm_8">
    		* Coverage :Booking DEL (Inbound) & Booking POR(Outbound)<br>    	
			* Effective Date:  POD ETA(Inbound) & OP Movement(Outbound)
		</div>
		<table class="grid2" border="0">
			<tr>
				<td class="sm" style="width:200px;" align="center">Exception Remark(s)</td>
				<td class="pad_top_8 pad_rgt_8 pad_btm_8 pad_left_8">
					<!-- POD: HKHKG, DEL: HK -> Dual<br>
					POD: US, DEL: MX -> Dual -->
				</td>
			</tr>
		</table>
	</div>
</div>
</div>
<!-- opus_design_grid(E) -->
<!-- page(E) -->

</form>