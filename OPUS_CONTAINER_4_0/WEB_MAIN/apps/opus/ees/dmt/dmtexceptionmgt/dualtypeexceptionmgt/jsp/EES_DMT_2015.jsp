<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   EES_DMT_2015.jsp
*@FileTitle  : Dual Type Exception Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/20
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.event.EesDmt2015Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt2015Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB ResultSet list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.DMTExceptionMgt.DualTypeExceptionMgt");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EesDmt2015Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// in loading page, Get data from server.
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
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
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="cust_cnt_cd" id="cust_cnt_cd" />
<input type="hidden" name="cust_seq" id="cust_seq" />
<input type="hidden" name="dul_expt_eff_dt" id="dul_expt_eff_dt" />
<input type="hidden" name="dul_expt_exp_dt" id="dul_expt_exp_dt" />
<input type="hidden" name="dul_expt_delt_flg" id="dul_expt_delt_flg" />
<!-- Parameters for Serarching Common code of RFA(Before Booking CNTR/Cargo Type) -->
<input type="hidden" name="code1" value="CD02053" id="code1" />
<input type="hidden" name="code2" value="CD01963" id="code2" />
<!-- Parameters for Serarching Common code of S/C CNTR/Cargo Type -->
<input type="hidden" name="intg_cd_id" value="CD01969" id="intg_cd_id" />
<!-- Parameters for Dual Type Exception Applied  -->
<input type="hidden" name="cust_cd" id="cust_cd" />
<input type="hidden" name="dmdt_ctrt_expt_tp_cd" id="dmdt_ctrt_expt_tp_cd" />
<input type="hidden" name="eff_dt" id="eff_dt" />
<input type="hidden" name="exp_dt" id="exp_dt" />
<input type="hidden" name="io_bnd_cd" id="io_bnd_cd" />
<input type="hidden" name="dmdt_cntr_cgo_tp_cd" id="dmdt_cntr_cgo_tp_cd" />
<input type="hidden" name="cnt_cd" id="cnt_cd" />
<input type="hidden" name="rgn_cd" id="rgn_cd" />
<input type="hidden" name="ste_cd" id="ste_cd" />
<input type="hidden" name="loc_cd" id="loc_cd" />

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
			--><button type="button" class="btn_normal" name="btn_MainDownExcel" id="btn_MainDownExcel">Down Excel</button>			
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
	
	<!-- wrap_search_tab(S) -->
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<!--  MiniLayer (S) -->
			<table>
				<colgroup>
		            <col width="80" />
		            <col width="200" />
		            <col width="125" />	            
		            <col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th>Customer</th>
						<td colspan="3">
							<script type="text/javascript">ComComboObject('combo1', 2, 90, 0, 0, 0, true)</script><!--
							--><input type="text" name="custNm" style="width:321px;" class="input2">
						</td>
					</tr>
					<tr>
						<th>Effective Date</th>
						<td><input type="text" name="effFmDt" style="width:80px;" class="input" dataformat="ymd" maxlength="8" onfocus="setEffectiveToDate()">~&nbsp;<!--
							--><input type="text" name="effToDt" style="width:80px;" class="input" dataformat="ymd" maxlength="8"><!--
							--><button type="button" class="calendar ir" name="btns_calendar" id="btns_calendar"></button>												
						</td>
						<th>Status</th>
						<td>
							<select name="status" id="status" style="width:80px;" class="input">
								<option value="" selected>ALL</option>
								<option value="Y">Deleted</option>
								<option value="N">Live</option>
							</select>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>	
	<!-- wrap_search_tab(S) -->
	
	<!-- wrap_result(S) -->
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="mainTable">
		
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn">
				<!-- 그리드 버튼 영역(데이터 그리드 상단에 위치) -->
				<!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
				<button type="button" class="btn_normal" name="btn_Detail" id="btn_Detail">Detail</button><!--
				--><button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button>			
			</div>
			  <!-- opus_design_btn(E) -->
			  <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
			  <script type="text/javascript">ComSheetObject('sheet1');</script>
			  <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
			  <div class="opus_design_inquiry">		  
			  	<table><tr><td class="stm">&nbsp;*&nbsp;&nbsp;Effective Date: S/C or Before Booking DAR should be effective within this period to be applicable </td></tr></table>
			  </div>
		</div>	
	
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="mainTable">
			<div class="opus_design_inquiry">
				<h3 class="title_design">Dual Type Exception Applied</h3><br/>
			</div>
			<!-- opus_design_btn(E) -->
			<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
			<script type="text/javascript">ComSheetObject('sheet2');</script>
			<!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
		</div>
		<!-- opus_design_grid(E) -->
	</div>
	<!-- wrap_result(S) -->
</form>