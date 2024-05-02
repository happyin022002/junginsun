<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0042.jsp
*@FileTitle  : MNR Invoice Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/19
=========================================================
--%>


<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.accountmanage.expensemgt.event.EesMnr0042Event" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0042Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//count of DB resultSet list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd        = "";
	String strRhq_ofc_cd         = "";
	Logger log = Logger.getLogger("com.clt.apps.test.test");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		strRhq_ofc_cd  = account.getRhq_ofc_cd();
		
		event = (EesMnr0042Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from sever when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<title><span id="title"></span></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript">   
	var currOfcCd = '<%=strOfc_cd %>';
	var rhqOfcCd  = '<%=strRhq_ofc_cd %>';
	
	function setupPage(){    
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<!-- <body  onLoad="setupPage();">  -->
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="key_value" id="key_value">  
<input type="hidden" name="inv_sch_type_code" id="inv_sch_type_code">
<input type="hidden" name="input_date_type_code" id="input_date_type_code">
<input type="hidden" name="input_type_code" id="input_type_code">
<input type="hidden" name="mnr_inv_sts_cd" id="mnr_inv_sts_cd">
<!-- Developer's task	-->   
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
<!-- page_title(E) -->
<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button>
		<button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button>
	</div>
<!-- opus_design_btn(E) -->
<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_location(E) -->
<div class= "wrap_search">
		<div class= "opus_design_inquiry wFit">
<!-- opus_design_inquiry(S) -->
	<table>
		<tbody>
			<colgroup>
				<col width="98px"/>
				<col width="330px"/>
				<col width="80px"/>
				<col width="130px"/>
				<col width="83px"/>
				<col width="130px"/>
				<col width="80px"/>
				<col width="80px"/>
				<col width="70px"/>
				<col width="*" />
			</colgroup>
				<tr class="h23">
					<th>Date</th>
					<td>
					   <script type="text/javascript">ComComboObject('combo1',1, 102 , 0,1);</script><!-- 
					 --><input type="text" style="width:80px" class="input1" name="from_dt" id="from_dt" id="from_dt" dataformat="ymd" cofield="to_dt">
					    <span class="dash">~</span>
						<input type="text" style="width:80px" class="input1" name="to_dt" dataformat="ymd" cofield="from_dt"><!-- 
					 --><button type="button" class="calendar ir" name="btn_calendar" id="btn_calendar"></button>
					</td>
					<th>Input Type</th>	
					<td><script type="text/javascript">ComComboObject('combo2',1, 90 , 0,0);</script></td>					
					<th>Status</th>
					<td><script type="text/javascript">ComComboObject('combo3',1, 90 , 0,0);</script></td>
					<th>INV OFC</th>
					<td><input type="text" style="width:55px" class="input"  name="inv_ofc_cd" id="inv_ofc_cd" value="<%=strOfc_cd %>" maxlength="6" dataformat="engup">&nbsp;</td>
					<th>W/O OFC</th>
					<td><input type="text" style="width:55px" class="input" name="cost_ofc_cd" id="cost_ofc_cd" dataformat="engup" maxlength="6" >&nbsp;</td>
				</tr>
		</tbody>
	</table>
	<table>
	<tbody>
			<colgroup>
		       <col width="98px"/>
				<col width="330px"/>
				<col width="80px"/>
				<col width="130px"/>
				<col width="80px"/>
				<col width="130px"/>
				<col width="80px"/>
				<col width="*" />
			</colgroup>
				<tr class="h23">
					<th>Service Provider</th>

					<td><input type="text" name="vndr_seq" id="vndr_seq" style="width:57px;text-align:center" class="input" maxlength="6" dataformat="num"><!--
					 --><button type="button" name="btn_provider_popup" id="btn_provider_popup" class="input_seach_btn"></button><!-- 
					 --><input type="text" name="vndr_lgl_eng_nm" id="vndr_lgl_eng_nm" style="width:178px" class="input2" readOnly="true"></td>
					<th>INV No.</th>	
					<td><input type="text" style="width:97px" dataformat="engupetc" class="input" name="inv_no" id="inv_no" ><!-- 
					--><button type="button" class="multiple_inq ir"  name="btn_inv_no_multy" id="btn_inv_no_multy"></button>
					</td>
					<th>W/O No.</th>	
					<td><input type="text" style="width:90px" dataformat="engup" class="input" name="inv_wo_no" id="inv_wo_no" otherchar="-,"><!-- 
					--><button type="button" class="multiple_inq ir"  name="btn_wo_no_multy" id="btn_wo_no_multy"></button>
					</td>
					<th>CSR No.</th>
					<td><input type="text" style="width:90px" dataformat="engup" class="input" name="csr_no" otherchar="-,"><!-- 
					--><button type="button" class="multiple_inq ir"  name="btn_csr_no_multy" id="btn_csr_no_multy"></button>
					</td>
				</tr>
		</tbody>		
	</table>
</div>
</div>
<!-- opus_design_inquiry(E) -->
<!-- opus_design_inquiry(E) -->
<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid clear" >
		<h3 id="tr_title1" class="title_design"> M&R Invoice List</h3>
	<div class="opus_design_btn">		
			<button type="button" class="btn_normal" name="btn_DetailRetrieve" id="btn_DetailRetrieve">Invoice Detail(s)</button>
			<button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button>
	</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
<!-- opus_design_grid(E) -->
<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" >
	<h3 id="tr_title1" class="title_design">M&R Invoice Detail Information</h3>
	<div class="opus_design_btn">
			
			<button type="button" class="btn_normal" name="btn_DownExcelDtl" id="btn_DownExcelDtl">Down Excel</button>
	</div>
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	</div>
<!-- opus_design_grid(E) -->
</form>