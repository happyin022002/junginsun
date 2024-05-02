<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_2008.jsp
*@FileTitle  : DEM/DET Adjustment Request - After Booking Request
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
<%@ page import="com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.event.EesDmt2008Event"%>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.OfficeCodeMgr"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List"%>

<%
	EesDmt2008Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//DB ResultSet Count of list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";
	String strRhq_ofc_cd		= "";
	List<String> rhqOfcList = null;
	Logger log = Logger.getLogger("com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();
		strRhq_ofc_cd = account.getRhq_ofc_cd();
		
		event = (EesDmt2008Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// in loading page, Get data from server
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		rhqOfcList = OfficeCodeMgr.getOfficeCodeList("000004","COM");//RHQ_OFC_LIST
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
</head>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="apvl_ofc_cd">
<input type="hidden" name="dar_no">
<input type="hidden" name="apvl_no">
<input type="hidden" name="bkg_no">
<input type="hidden" name="bl_no">
<input type="hidden" name="tariff">
<input type="hidden" name="is_cntr">
<input type="hidden" name="pod">
<input type="hidden" name="pol">
<input type="hidden" name="del">
<input type="hidden" name="por">
<!-- Parameters is separated getting from After Booking or Charge Calculation when it is Retrieved Charge Detail per BKG information  After Booking  
	 when it is Retrieved Charge Detail per BKG information  After Booking -->
<input type="hidden" name="is_aft_bkg_cntr">
<!-- Parameters for Requesting -->
<input type="hidden" name="aft_expt_dar_no">
<input type="hidden" name="aft_expt_adj_seq">
<input type="hidden" name="dmdt_expt_rqst_sts_cd">
<input type="hidden" name="apro_ofc_cd">
<input type="hidden" name="prog_rmk">
<!-- Parameters is saved returns from Server temporary -->
<input type="hidden" name="result">
<input type="hidden" name="result2">
<input type="hidden" name="result3">
<!-- Parameters for searching Local Currency  -->
<input type="hidden" name="cnt_cd">
<input type="hidden" name="usr_ofc_cd" value="<%= strUsr_ofc %>">
<input type="hidden" name="usr_rhq_ofc_cd"		value="<%=strRhq_ofc_cd%>">
	
		
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->			
   
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button>
		<button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button>
		<button type="button" class="btn_normal" name="btn_Request" id="btn_Request">Request</button>
		<button type="button" class="btn_normal" name="btn_Cancel" id="btn_Cancel">Cancel</button>
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
	            <col width="80px" />
	            <col width="130px" />
	            <col width="55px" />
	            <col width="160px" />
	            <col width="60px" />
	            <col width="160px" />
	            <col width="50px" />
	            <col width="120px" />
	            <col width="" />
	        </colgroup>
	        <tbody>
				<tr class="h23">
					<th>APVL Office</th>
					<td>
					<!-- 
					<select name="approvalOfcCd" id="approvalOfcCd" style="width:85px;" class="input1">
						<%--
							String rhqOfc = "";
							for(int i = 0 ; i < rhqOfcList.size() ; i++) {
								rhqOfc = (String)rhqOfcList.get(i);
						--%>
						<option value="<%---=rhqOfc --%>"><%--=rhqOfc --%></option>
						<%--
							}
						--%>
					</select>
					 -->
					 <script type="text/javascript">ComComboObject('approvalOfcCd', 1 ,80 , 0 , 1 , 0, true);</script>
					
					</td>
					<th>DAR No. </th>
					<td><input type="text" name="darNo" id="darNo" style="width:120px;ime-mode:disabled" class="input" dataformat="engup" maxlength="15"></td>
					<th>APVL No.</th>
					<td><input type="text" name="apvlNo" id="apvlNo" style="width:130px;;ime-mode:disabled" class="input" dataformat="engup" maxlength="15"></td>
					<th>Status</th>
					<td><input type="text" name="status" id="status" style="width:122px;" class="input2"></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	    <!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    
	    <table>
	        <colgroup>
	        	<col width="80px" />
	            <col width="130px" />
	            <col width="55px" />
	            <col width="160px" />
	            <col width="60px" />
	            <col width="70px" />
	            <col width="" />
	        </colgroup>
	        <tbody>
				<tr class="h23">
					<th>S/C No. </th>
					<td><input type="text" name="scNo" id="scNo" style="width:85px;" class="input2"></td>
					<th>RFA No.</th>
					<td><input type="text" name="rfaNo" id="rfaNo" style="width:120px;" class="input2"></td>
					<th>Customer</th>
					<td><input type="text" name="custCd" id="custCd" style="width:70px;" class="input2"><input type="text" name="custNm" id="custNm" style="width:256px;" class="input2"></td>
					<td></td>
				</tr>
			</tbody>
		</table>
		
	</div>
	<!-- opus_design_inquiry(E) -->
</div>	
	
<div class="wrap_result">	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
	    
	     <!-- opus_grid_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_AddBkgReq" id="btn_AddBkgReq">Row Add</button>
			<button type="button" class="btn_normal" name="btn_DelBkgReq" id="btn_DelBkgReq">Row Delete</button>
		</div>
		
	    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script type="text/javascript">ComSheetObject('sheet1');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_grid(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
	    
		<!-- opus_grid_left(S)-->
			<div class="grid_option_left">
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="210" class="title_s"><b>Charge Detail per BKG</b></td>
					<td width="70"><b>CNTR Q'ty</b></td>
					<td width="70"><input type="text" name="cntrQty" id="cntrQty" style="width:40;text-align:right;" class="input2"></td>
					<td width="25"><b>Cur.</b></td>
					<td width="80"><input type="text" name="curr" id="curr" style="width:40;text-align:center;" class="input2"></td>
					<td width="110"><b>Total Billable AMT</b></td>
					<td width="145"><input type="text" name="totalBillAmt" id="totalBillAmt" id="totalBillAmt" style="width:100;text-align:right;" class="input2"></td>
					<td>&nbsp;</td>
				</tr>
				</table>
			</div>
		<!-- opus_grid_left(E)-->
			    
	     <!-- opus_grid_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_PreCalc" id="btn_PreCalc">D/C AMT or Ratio Pre Cal.</button>
			<button type="button" class="btn_normal" name="btn_Reset" id="btn_Reset">Reset</button>
		</div>
		
	    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script type="text/javascript">ComSheetObject('sheet2');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_grid(E) -->

	<!-- layout_wrap(S) -->
	<div class="layout_wrap" style="width: 100%">
		<!-- layout_vertical_2(S) -->
		<div class="layout_vertical_2" style="width: 49%;margin-right: 2%;">
			<!-- opus_design_grid(S) -->
			<h3 class="title_design">Comment History</h3>
			<div class="opus_design_grid">
				<script type="text/javascript">ComSheetObject('sheet3');</script>		
			</div>
			<!-- opus_design_grid(E) -->
		</div>
	     <!-- layout_vertical_2(E) -->
		<!-- layout_vertical_2(S) -->
		<div class="layout_vertical_2" style="width: 49%">
			<!-- opus_design_grid(S) -->
			<h3><input type="checkbox" name="chkComment" id="chkComment" class="trans" onClick="checkComment()">&nbsp;Comment </h3>
			<div class="opus_design_grid">
				<textarea name="comment" id="comment" dataformat="engup" otherchar="<%=getSpecialChars()%>" style="width:100%;height:96px;background-color:#E8E7EC;"></textarea>		
			</div>
			<!-- opus_design_grid(E) -->
		</div>
	     <!-- layout_vertical_2(E) -->
	</div>
	<!-- layout_wrap(E) -->
</div>

<%!

	public String getSpecialChars() {
		return " ~!@#$%^&*()`_+-={}|[]\\\"\\':;,./?"; 
	}
		
%>
<!-- wrap_result(E) -->

</form>