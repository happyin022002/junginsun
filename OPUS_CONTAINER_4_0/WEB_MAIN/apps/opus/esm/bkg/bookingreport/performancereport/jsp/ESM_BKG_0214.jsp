<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0214.jsp
*@FileTitle  :  Doc Performance Report
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
<%@ page import="com.clt.apps.opus.esm.bkg.bookingreport.performancereport.event.EsmBkg0214Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0214Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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


		event = (EsmBkg0214Event)request.getAttribute("Event");
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
<input type="hidden" name="class_type" value="4">
<input type="hidden" name="sel_bkg_ofc_cd" value="">
<input type="hidden" name="sel_gso_cd" value="">

<!-- 개발자 작업	-->
<!-- page_title_area(S) -->
<div class="page_title_area clear">
<!-- page_title(S) -->
<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
		  --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button>
		  <input type="radio"  id="office_list" name="report_type" value="ofc" class="trans" checked><label for="office_list">Office List</label><!--
		  --><input type="radio" id="bl_list" name="report_type" value="bl" class="trans"><label for="bl_list">B/L List</label><!--			
		  --><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
	</div>
	<!-- opus_design_btn(E) -->

<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>

<!-- page_title_area(E) -->
<!-- wrap_search(S) -->  
<div class="wrap_search_tab">

<!-- opus_design_inquiry (S) -->
<div class="opus_design_inquiry wFit">

	<table class="search">
		<colgroup>
			<col width="350px">
			<col width="50px">
			<col width="*">
		</colgroup> 
		<tr>
			<td class="sm" style="padding-left:30px">				
				<input type="radio" id="search_opt_a" name="search_opt" value="A"  onClick="setSchKey(this.value)" class="trans" checked><label for="search_opt_a">Date + BKG OFC</label><!--
				 --><input type="radio" id="search_opt_b" name="search_opt" value="B"  onClick="setSchKey(this.value)" class="trans"><label for="search_opt_b">VVD+POL</label><!-- 
				 --><input type="radio" id="search_opt_c" name="search_opt" value="C"  onClick="setSchKey(this.value)" class="trans"><label for="search_opt_c">Date +POL</label>
			</td>							
			<td><label id="lbPct" style="font-weight:bold;">PCT</label><label id="lbEta" style="display:none;font-weight:bold">ETA</label></td>
			<td>
<!-- 				<input type="text" name="fr_dt" style="width:80px;" class="input1" value="" dataformat="ymd" caption="Start Date" maxlength="10"  cofield="to_dt" required onFocus="this.select();"> -->
<!-- 				&nbsp;~&nbsp; -->
<!-- 				<input type="text" name="to_dt" style="width:80px;" class="input1" value="" dataformat="ymd" caption="End Date" maxlength="10"  cofield="fr_dt" required onFocus="this.select();"> -->
<!-- 				<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"  style="cursor:hand" onClick="callDatePop('BKG_DATE')"> -->				
				
			       <input type="text" name="fr_dt" style="width:80px;" class="input1" value="" dataformat="ymd" caption="Start Date" maxlength="10" required>
			       ~			       			       
			       <input type="text" name="to_dt" style="width:80px;" class="input1" value="" dataformat="ymd" caption="End Date" maxlength="10" required><!-- 		       
			       --><button type="button" class="calendar ir" name="btns_calendar" onClick="callDatePop('BKG_DATE')" id="btns_calendar"></button>					
		      					
			</td>			
		</tr>
	</table>
	
	<table class="search">
		<colgroup>
			<col width="60px">
			<col width="130px">
			<col width="50px">
			<col width="110px">
			<col width="50px">
			<col width="60px">
			<col width="100px">
			<col width="100px">
			<col width="74px">
			<col width="*">
		</colgroup> 
	 
		<tr>			
			<th style="text-align:left">T/VVD</th>
			<td><input type="text" name="vvd_cd"   style="width:80px;ime-mode:disabled" class="input" value="" dataformat="engup"  caption="VVD" maxlength="9" fullfill ></td>
			<th style="text-align:left">POL</th>
			<td><input type="text" name="pol_cd"  style="width:50px;ime-mode:disabled" value="" dataformat="engup"  caption="POL" maxlength="5" fullfill ></td>
			<th style="text-align:left">LANE</th>
			<td><input type="text" name="slan_cd"  style="width:40px;ime-mode:disabled" value="" dataformat="engup"  caption="LANE" maxlength="3" fullfill ></td>
			<th style="text-align:left">Region</th>
			<td><script type="text/javascript">ComComboObject('region', 1, 80, 0,1,0);</script></td>
			<th style="text-align:left">GSO</th>
			<td><input type="text" name="gso" style="width:60px;ime-mode:disabled"  class="input" value="" dataformat="enguponly"  caption="GSO" maxlength="6" ></td>
		</tr>
	</table>
	
	<table class="search">
		<colgroup>
			<col width="60px">
			<col width="130px">
			<col width="50px">
			<col width="220px">
			<col width="100px">
			<col width="100px">
			<col width="50px">
			<col width="*">
			
		</colgroup>  
		<tr>
			<th style="text-align:left">BKG No.</th>
			<td>
				<input type="text" style="width:100px;ime-mode:disabled" name="bkg_no" value="" class="input" dataformat="engup" caption="Booking No." maxlength="13">
			</td>
			<th style="text-align:left">B/L No.</th>
			<td>
				<input type="text" style="width:105px;ime-mode:disabled" name="bl_no" value="" class="input" dataformat="engup" caption="B/L No." maxlength="13">
			</td>
			<th style="text-align:left">Booking Office</th>
			<td>
				<input type="text" style="width:80px;ime-mode:disabled" name="bkg_ofc_cd"  value="" class="input" dataformat="enguponly" caption="Booking Office" maxlength="5"  fullfill >
			</td>
			<th style="text-align:left">Sales Office</th>
			<td>
				<input type="text" style="width:60px;ime-mode:disabled" name="ob_sls_ofc_cd"  value="" class="input" dataformat="enguponly" caption="Sales Office" maxlength="5"  fullfill>
			</td>
		</tr>
	</table>
	
</div>
<!-- opus_design_inquiry (E) -->
</div>
<!-- wrap_search(E) -->  
<div class="wrap_result">
<!-- opus_tab_btn(S) -->
<div class="opus_design_tab">
	<script type="text/javascript">ComTabObject('tab1')</script>
</div>
<!-- opus_tab_btn(E) -->
</div>
<div class="wrap_result">
<!--TAB  (S) -->
<div id="tabLayer" style="display:inline;visibility:none" >		
<!--<td style="padding-left: 84px;"><button type="button" class="btn_normal" name="btn_t1office" id="btn_t1office">Office</button></td>  -->					
<!--TAB  (E) -->

 	<%
       	for (int i = 1 ; i < 8 ; i++){
       		String ofcTabSheet = "t1sheet"+i;
       		String blTabSheet = "t1sheet"+(i+7);       		       		
       	%>
		<!-- layout_wrap(S) -->
		<div class="layout_wrap" id="mainTable">
			<div class="layout_flex_fixed" style="width:450px">
				<div class="opus_design_grid">
				 	<h3 class="title_design">Office List</h3>
					<script type="text/javascript">ComSheetObject('<%=ofcTabSheet%>');</script>
				</div>
			</div>
			     
			<div class="layout_flex_flex" style="padding-left:458px">
					<div class="opus_design_grid">
					 	<h3 class="title_design">B/L List</h3>
						<script type="text/javascript">ComSheetObject('<%=blTabSheet%>');</script>
					</div>
					<div class="opus_design_grid">
						<script type="text/javascript"></script>
					</div>
				</div>
			</div>
		<%
       	}
	    %>
	    
    <!--  Button_Sub (S) -->
		<table class="button"> 
	       	<tr>
	       		<td width="410px">	       		
	       			<label id="lbGoto1" style="display:none" >* To check detailed customer code accuracy of each office, please go to </label>
	       		</td>
	       		<td onClick="javscript:gotoCustCodeErrReport()">
	       			<label id="lbGoto2" style="display:none" in><U>Customer Code Error Report</U></label>
	       		</td>	       			       			       			       		
			</tr>
		</table>
	    	<!-- Button_Sub (E) -->	
<!-- 개발자 작업  끝 -->
</div>
</div>
</form>