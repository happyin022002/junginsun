<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_2006.jsp
*@FileTitle  :  DEM/DET Adjustment Request & Approval Status
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
<%@ page import="com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.event.EesDmt2006Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt2006Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id	 = "";
	String strUsr_nm	 = "";
	String strOfc_cd	 = "";
	String strRhq_ofc_cd = "";
	Logger log = Logger.getLogger("com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id 	  = account.getUsr_id();
		strUsr_nm 	  = account.getUsr_nm();
		strOfc_cd 	  = account.getOfc_cd();
		strRhq_ofc_cd = account.getRhq_ofc_cd();
	   
		event = (EesDmt2006Event)request.getAttribute("Event");
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
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<!-- The parameters used for retrieving status of Request & Approval of S/C and DAR -->
<input type="hidden" name="group_by">
<input type="hidden" name="dmdt_trf_cd">
<input type="hidden" name="type">
<input type="hidden" name="cond_tp">
<input type="hidden" name="tab_tp">
<input type="hidden" name="fm_dt">
<input type="hidden" name="to_dt">
<input type="hidden" name="sc_no">
<input type="hidden" name="rfa_no">
<input type="hidden" name="prop_no">
<input type="hidden" name="dar_no">
<input type="hidden" name="apvl_no">
<input type="hidden" name="bkg_no">
<input type="hidden" name="bl_no">
<input type="hidden" name="to_cc">
<input type="hidden" name="usr_id">
<input type="hidden" name="usr_ofc_cd">
<input type="hidden" name="usr_ofc_only">
<input type="hidden" name="usr_role_cd" value="DMT03">
<!-- Office Code used to query the actual value of parameters for stored temporarily -->
<input type="hidden" name="ofc_cd">
<input type="hidden" name="cust_cd">
<!-- Type the parameters used for setting -->
<input type="hidden" name="login_usr_id" value="<%=strUsr_id%>">
<input type="hidden" name="login_usr_nm" value="<%=strUsr_nm%>">
<input type="hidden" name="login_ofc_cd" value="<%=strOfc_cd%>">
<input type="hidden" name="login_rhqofc_cd" value="<%=strRhq_ofc_cd%>">
<!-- Customer Name parameter is used to look up -->
<input type="hidden" name="cust_seq">
<input type="hidden" name="cust_cnt_cd">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
    
    <!-- page_title(S) -->
    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
    <h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
    <!-- page_title(E) -->

    <!-- opus_design_btn(S) -->
    <div class="opus_design_btn">
        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button>
		<button type="button" class="btn_normal" name="btn_new"      id="btn_new">New</button>
		<button type="button" class="btn_normal" name="btn_minimize" id="btn_minimize">Minimize</button>
		<button type="button" class="btn_normal" name="btn_detail"   id="btn_detail">Detail</button>
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
  

<!-- inquiry_area(S) -->
<div class="wrap_search_tab">
<div class="opus_design_inquiry wFit"  id="conditionLayer" style="display:block">
	<table> 
	<colgroup>
        <col width="30" />
       <col width="70" />
       <col width="230" />
       <col width="80" />
       <col width="50" />
       <col width="80" />
       <col width="130" />
       <col width="100" />
       <col width="*" />
     </colgroup>
	
		<tbody>
			<tr>
				<th class="sm" >Type</th>
				<td  class="sm" colspan="2">
					<input type="checkbox" name="searchType" onClick="displayGridByType()" class="trans" id="chk1">
					<label for="chk1">S/C</label>
					<input type="checkbox" name="searchType" onClick="displayGridByType()" class="trans" id="chk2">
					<label for="chk2">Before</label>
					<input type="checkbox" name="searchType" onClick="displayGridByType()" class="trans" id="chk3">
					<label for="chk3">After</label>
				</td>
				<th>Group by</th>
				<td>
					<select name="groupBy" class="input" style="width:90px;">
						<option value="DAR" selected>S/C & DAR</option>
						<option value="CVRG">Coverage </option>
					</select>
				</td>
				<th>Tariff Type</th>
				<td colspan="2">
					<script language="javascript">ComComboObject('combo1', 2, 250, 0, 1)</script><!-- 
				 --><button type="button" class="multiple_inq"></button>					
				</td>
				<td colspan="3"></td>
			</tr>
			
			<tr class="sm">
				<th><input type="radio" name="cond_type" value="date" id="rdo1"><label for="rdo1">Date</label></th>
				<th class="stm">Update</th>
				<td  class="stm">
					<span class="inquiry_calendar">
						<input type="text" name="updDtFm" id="updDtFm" class="input1"  style="width:80px;text-align:center;ime-mode:disabled" dataformat="ymd" maxlength='8'  readonly />
						<span class="dash">-</span> 
						<span class="calendar_input">
						<input type="text" name="updDtTo" id="updDtTo" class="input1" style="width:80px;text-align:center;ime-mode:disabled" dataformat="ymd" maxlength='8' readonly /><!-- 
					 --><button type="button" class="calendar ir" name="btns_calendar" id="btns_calendar"></button>
					</span>
				</td>
				<th class="stm">Office</th>
				<td><input type="text" name="office" id="office" dataformat="engup" style="width:55px;" ></td>
				<th class="stm">To/Cc</th>
				<td><select name="toCc"  id="toCc" style="width:70px;" class="input">
					<option value="" selected>All</option>
					<option value="to">To</option>
					<option value="cc">Cc</option>
					</select>
				</td>
				<td class="stm"><input type="checkbox" name="userOfficeOnly" id="chk4" class="trans"><label for="chk4">User Office Only</label></td>
				<td><input type="checkbox" name="userOnly" onClick="modifyToCc()" id="chk5" class="trans"><label for="chk5">User Only</label></td>
				
			</tr>
			<tr class="sm">
				<th rowspan="2" valign="top"><input type="radio" name="cond_type" id="cond_type" value="dar" id="rdo2" class="trans"><label for="rdo2">DAR</label>
				</th>
				<th>S/C No.</th>
				<td><input type="text" name="sCNo" id="sCNo" style="width:120px;ime-mode:disabled" class="input" dataformat="engup" maxlength="9"></td>
				<th>RFA No.</th>
				<td><input type="text" name="rFANo" id="rFANo" style="width:120px;ime-mode:disabled" class="input"  dataformat="engup" maxlength="11"></td>
				<th>Proposal No.</th>
				<td><input type="text" name="proposalNo" id="proposalNo" style="width:110px;ime-mode:disabled" class="input"  dataformat="engup" maxlength="11"></td>
				<td></td>
				<td></td>
				
			</tr>
			<tr class="sm">
				<th>DAR No.</th>
				<td class="stm">
					<input type="text" name="darNo" id="darNo" style="width:120px;ime-mode:disabled" class="input" dataformat="engup" maxlength="15"></td>
				<th class="stm">APVL No.</th>
				<td><input type="text" name="approvalNo" id="approvalNo" style="width:120px;ime-mode:disabled" class="input" dataformat="engup" maxlength="15"></td>
				<th class="stm">BKG No.</th>
				<td><input type="text" name="bkgNo" id=""bkgNo style="width:110px;ime-mode:disabled" class="input" dataformat="engup" maxlength="13"></td>
				<th class="stm">B/L No.</th>
				<td><input type="text" name="blNo" id="blNo" style="width:110px;ime-mode:disabled" class="input" dataformat="engup" maxlength="12"></td>
				
			</tr>
			
			<tr>
				<th>Customer</th>
				<td colspan="8">
					<input type="text" name="custCd" id="custCd" dataformat="engup"  style="width:70px;" class="input_search"><button type="button" class="input_seach_btn" onClick="openWinSearchCustomer('cust_cd')"></button><!-- 
					--><input type="text" name="custNm" id="custNm" style="width:880px;" class="input2">	</td>	
				</tr>
		</tbody>
	</table>
</div>
</div>
<div class="wrap_result">
	<!-- opus_tab_btn(E) -->
	<div class="opus_design_tab">
			<script language="javascript">ComTabObject('tab1')</script>
	</div>
	<!-- opus_tab_btn(E) -->
	
<div id="tabLayer" style="display:block">
		<!-- opus_design_grid(S) -->
	<div class="opus_design_grid"  id="receivedTabSCTariffLayer" style="display:block">
		<h3 class="title_design">S/C Exception Tariff</h3>
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<!-- 그리드 버튼 영역(데이터 그리드 상단에 위치) -->
			<!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
			<button type="button" class="btn_normal" name="t1btn_SCdownexcel" id="t1btn_SCdownexcel">S/C Exception Tariff Down Excel</button>
		</div>
		<!-- opus_design_btn(E) -->
		   
			<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
			<script language="javascript">ComSheetObject('t1sheet1');</script><!--W/O Issue-->
			<!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_grid(E) -->

			<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="receivedTabBeforeBookingLayer" style="display:block">
		<h3 class="title_design">Before Booking DAR</h3>
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<!-- 그리드 버튼 영역(데이터 그리드 상단에 위치) -->
			<!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
			<button type="button" class="btn_normal" name="t1btn_Beforedownexcel" id="t1btn_Beforedownexcel">Before BKG DAR Down Excel</button>
		</div>
		<!-- opus_design_btn(E) -->
		   
			<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
			<script language="javascript">ComSheetObject('t1sheet2');</script><!--W/O Issue-->
			<!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_grid(E) -->

				<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="receivedTabAfterBookingLayer" style="display:block">
		<h3 class="title_design">After Booking DAR</h3>
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<!-- 그리드 버튼 영역(데이터 그리드 상단에 위치) -->
			<!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
			<button type="button" class="btn_normal" name="t1btn_Afterdownexcel" id="t1btn_Afterdownexcel">After BKG DAR Down Excel</button>
		</div>
		<!-- opus_design_btn(E) -->
		   
			<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
			<script language="javascript">ComSheetObject('t1sheet3');</script><!--W/O Issue-->
			<!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_grid(E) -->
	
</div>
			

<div id="tabLayer" style="display:none">
		<!-- opus_design_grid(S) -->
	<div class="opus_design_grid"  id="sentTabSCTariffLayer" style="display:block">
		<h3 class="title_design">S/C Exception Tariff</h3>
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<!-- 그리드 버튼 영역(데이터 그리드 상단에 위치) -->
			<!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
			
			<button type="button" class="btn_normal" name="t2btn_SCdownexcel" id="t2btn_SCdownexcel">S/C Exception Tariff Down Excel</button>
		</div>
		<!-- opus_design_btn(E) -->
		   
			<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
			<script language="javascript">ComSheetObject('t2sheet1');</script><!--W/O Issue-->
			<!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_grid(E) -->

			<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="sentTabBeforeBookingLayer" style="display:block">
		<h3 class="title_design">Before Booking DAR</h3>
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<!-- 그리드 버튼 영역(데이터 그리드 상단에 위치) -->
			<!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
			<button type="button" class="btn_normal" name="t2btn_Beforedownexcel" id="t2btn_Beforedownexcel">Before BKG DAR Down Excel</button>
		</div>
		<!-- opus_design_btn(E) -->
		   
			<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
			<script language="javascript">ComSheetObject('t2sheet2');</script><!--W/O Issue-->
			<!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_grid(E) -->

				<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="sentTabAfterBookingLayer" style="display:block">
		<h3 class="title_design">After Booking DAR</h3>
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<!-- 그리드 버튼 영역(데이터 그리드 상단에 위치) -->
			<!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
			<button type="button" class="btn_normal" name="t2btn_Afterdownexcel" id="t2btn_Afterdownexcel">After BKG DAR Down Excel</button>
		</div>
		<!-- opus_design_btn(E) -->
		   
			<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
			<script language="javascript">ComSheetObject('t2sheet3');</script><!--W/O Issue-->
			<!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_grid(E) -->
</div>	
</div>
</form>
