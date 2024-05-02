<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0746.jsp
*@FileTitle  : Vessel Utilization Status vs. BSA by Lane
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/07
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingreport.performancereport.event.EsmBkg0746Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0746Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.BookingReport.PerformanceReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0746Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
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
<!-- 개발자 작업	-->

<input type="hidden" name="cost_yrmon">
<input type="hidden" name="vvds">

<input type="hidden" name="com_mrdTitle">
<input type="hidden" name="com_mrdBodyTitle">
<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdArguments">


	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	    
	    <!-- page_title(S) -->
	    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	    <h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	    <!-- page_title(E) -->
	         
	   
	    <!-- opus_design_btn(S) -->
	    <div class="opus_design_btn">
	        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
			<button type="button" class="btn_accent" name="btn_Retrieve"     id="btn_Retrieve">Retrieve</button><!--
			--><button type="button" class="btn_normal" name="btn_New"          id="btn_New">New</button><!--
			--><button type="button" class="btn_normal" name="btn_DownExcel" 	 id="btn_DownExcel">Down Excel</button><!--		
			<button type="button" class="btn_normal" name="btn_Rawdata" 	 id="btn_Rawdata">Down Raw Data</button>
			--><button type="button" class="btn_normal" name="btn_Print" 	 	 id="btn_Print">Print</button>
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
	<div class="opus_design_inquiry">
	    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <table>
	        <colgroup>
	        	<col width="40px" />
	            <col width="90px" />
	            <col width="65px" />
	            <col width="110px" />
	            <col width="45px" />
	            <col width="80px" />
	            <col width="400px" />
	            <col width="" />	            
	        </colgroup>
	        <tbody>
				<tr>
					<th>Trade</th>
					<td>
						<script language="javascript">ComComboObject('trd_cd', 1, 60, 1);</script>
					</td>
					<th>Sub Trade</th>
					<td>
						<script language="javascript">ComComboObject('sub_trd_cd', 1, 60, 1);</script>
					</td>
					<th>Bound</th>
					<td>
						<script language="javascript">ComComboObject('vsl_slan_dir_cd', 1, 60, 1);</script>
					</td>										
					<td rowspan="2">
						<table class="search_sm"> 
							<tr>
								<th style="text-align:left;" width="130px"><input type="radio" name="dt_tp" value="0" class="trans" checked>Port ETD</th>								                                                                                   	
								<td width="">
									<input type="text" style="width:75px;" value="" class="input1" dataformat="ymd" name="etd_from_dt" maxlength="10" size="10" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)" onClick="javascript:choiceDt('ymd');">&nbsp;~&nbsp;<input type="text" style="width:75;" value="" class="input1" dataformat="ymd" name="etd_to_dt" maxlength="10" size="10" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)" onClick="javascript:choiceDt('ymd');"><!-- 
								 --><button type="button" class="calendar" name="btn_calendar" id="btn_calendar" onClick="javascript:choiceDt('ymd');"></button>
								</td>
							</tr>
							<tr>
								<th  style="text-align:left;"	><input type="radio" name="dt_tp" value="1" class="trans">Performance Year</th>
								<td width="" class="stm"><input type="text" style="width:40px;" value="" class="input1" name="cost_year" dataformat="num" maxlength="4" size="4" onClick="javascript:choiceDt('week');">&nbsp;&nbsp;&nbsp;Month&nbsp;<input type="text" style="width:26;" value="" class="input1" name="cost_morth" dataformat="num" maxlength="2" size="2" onClick="javascript:choiceDt('week');">&nbsp;&nbsp;&nbsp;Week&nbsp;<input type="text" style="width:26;" value="" class="input" name="cost_wk" dataformat="num" maxlength="2" size="2" onClick="javascript:choiceDt('week');"></td>
							</tr>
						</table>
					</td>
					<td  rowspan="2"></td>
				</tr>
				<tr>
					<th width="40px">Lane</th>
					<td width="80px"><input type="text" style="width:60px;" value="" class="input1" name="slan_cd" dataformat="engup" maxlength="3"></td>
					<th width="65px">VVD</th>
					<td width="80px"><input type="text" style="width:80px;" value="" class="input" name="vvd" dataformat="engup" maxlength="9"></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->	
</div>
<div class="wrap_result">	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid"  id="mainTable">
	    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script type="text/javascript">ComSheetObject('sheet1');</script>	    
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<div class="opus_design_grid" id="downSheet" style="display:none">
	    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->	    
	    <script type="text/javascript">ComSheetObject('sheet2');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_grid(E) -->
</div>
<!--biz page (E)-->	

<!-- 개발자 작업  끝 -->
</form>

