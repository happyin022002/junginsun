<%
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_BKG_1081.jsp
*@FileTitle : Autorating Accuracy Monitoring Report
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingreport.performancereport.event.EsmBkg1081Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1081Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//occurring error in server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//list count of DB resultSet 

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


		event = (EsmBkg1081Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//When initial screen loading, adding logic extrat data obtained from the server.
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
<input type="hidden" name="sel_ofc_cd">
<input type="hidden" name="sel_scp_cd">

	<!-- page_title_area(S) -->
	<div class="page_title_area clear ">
		<!-- page_title(S) -->
		<h2 class="page_title">
			<button type="button">
				<span id="title">Autorating Accuracy Monitoring Report</span>
			</button>
		</h2>
		<!-- page_title(E) -->
	
		    <!-- opus_design_btn(S) -->
		    <div class="opus_design_btn">
		        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
				<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button>
				<button type="button" class="btn_normal" name="btn_New"   id="btn_New">New</button>
				<button type="button" class="btn_normal" name="btn_DownExcel_Summary"   id="btn_DownExcel_Summary">Down Excel-Summary</button>
				<button type="button" class="btn_normal" name="btn_DownExcel_Detail"   id="btn_DownExcel_Detail">Down Excel-B/L List</button>
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
	<div class="opus_design_inquiry wFit">
	
	    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <table>
	         <colgroup>
	            <col width="10">
	            <col width="410">
	            <col width="70">
	            <col width="70">
	            <col width="70">
	            <col width="*">
	        </colgroup>
				<tr class="h23">
					<td> </td>
					<td>
						<table class="search_sm2" border="0"> 
						<tr>
							<td width="220">
										<input type="radio" name="dt_option" value="R" checked class="trans">Rating Date&nbsp;&nbsp
										<input type="radio" name="dt_option" value="S" class="trans">Sailing Date&nbsp;&nbsp
							</td>
							<td width="220">
								<input type="text" name="fr_dt" style="width:80px;" class="input1" value=""   dataformat="ymd" caption="Start Date" maxlength="10"  cofield="to_dt" required>
								~&nbsp;
								<input type="text" name="to_dt" style="width:80px;" class="input1" value=""    dataformat="ymd" caption="End Date" maxlength="10"  cofield="fr_dt" required><!-- 
								 --><button type="button" id="btnCalFr" name="btnCalFr" class="calendar ir" onClick="callDatePop('BKG_DATE')"></button>
							</td>
						</table>
					</td>
					<th>HQ Office</th>
					<td>
						<script language="javascript">ComComboObject('region', 1, 80, 0,1,0);</script>
					</td>
					<th>Contract</th>
					<td>
						<script language="javascript">ComComboObject('ctrt_cd', 1, 60, 0,0,0);</script>
					</td>
				</tr>
				
		</table>
	    <!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    
	    <!-- 조회영역2 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <table>
	         <colgroup>
	            <col width="10" />
	            <col width="50" />
	            <col width="60" />
	            <col width="60" />
	            <col width="100" />
	            <col width="100" />
	            <col width="80" />
	            <col width="1	00" />
	            <col width="40" />
	            <col width="80" />
	            <col width="40" />
	            <col width="*" />
	        </colgroup> 
	        <tbody>
				<tr class="h23">
					<td> </td>
					<th>SVC Scope</th>
					<td>
						<input type="text" name="svc_scp_cd" style="width:50px;" class="input1" value="" style="ime-mode:disabled" 
							dataformat="enguponly"  caption="SVC Scope" maxlength="3" >
					</td>
					<th>S/C No</th>
					<td>
						<input type="text" name="sc_no" style="width:90px;" class="input1" value="" style="ime-mode:disabled" 
						dataformat="engup"  caption="SVC Scope" maxlength="20" >
					</td>
					<th>Booking Office</th>
					<td>
						<input type="text" name="bkg_ofc_cd" style="width:60px;" class="input1" value="" style="ime-mode:disabled" 
						dataformat="enguponly"  caption="BKG Office" maxlength="6" >
					</td>
					<th>Incl. Sub OFC</th>
					<td>
						<input type="checkbox" name="ofc_inc_sub" value="Y" class="trans">
					</td>
					<th>Auto Status</th>
					<td>
						<input type="checkbox" name="auto_rat_cd" value="Y" class="trans">
					</td>
					<td> </td>
				</tr>
				
			</tbody>
		</table>
	    <!-- 조회영역2 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	</div>
	<!-- opus_design_inquiry(E) -->
	
		
	
	<!-- opus_design_grid(S) -->
	<div class="wrap_result">
					<div class="layout_wrap">
						<div class="layout_vertical_2 pad_rgt_12">
					    		<h3 class="title_design">Autorating Accuracy Ratio</h3>
								<script language="javascript">ComSheetObject('sheet1');</script>
												
						</div>
						<div class="layout_vertical_2" style="width:50%">
								<h3 class="title_design" id = "span_autorated_bl">Non Autorated B/L List</h3>
								<script language="javascript">ComSheetObject('sheet2');</script>
												
						</div>		
				</div>
		</div>

	<!-- opus_design_grid(E) -->
	
	

</form>

