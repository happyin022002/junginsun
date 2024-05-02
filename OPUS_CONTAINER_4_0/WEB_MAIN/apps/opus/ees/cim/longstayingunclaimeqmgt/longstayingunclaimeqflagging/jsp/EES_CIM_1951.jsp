 <%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CIM_1951.jsp
*@FileTitle  : OP Inventory for Pseudo Booking
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/11
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.event.EesCim1951Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCim1951Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

    String cnmv_sts_cd = "";
    String cnmv_sts_nm = "";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.LongstayingUnclaimEQMgt.LongstayingUnclaimEQFlagging");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesCim1951Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
					
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript">
	function setupPage(){
		loadPage();
	}
</script>
</head>
<body onLoad="setupPage();"> 

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />

<input type="hidden" name="inquiryLevel" value="" id="inquiryLevel" />
<input type="hidden" name="location" value="" id="location" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
<!-- page_title(E) -->
<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
		</div>
		<!-- opus_design_btn(E) -->	
<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_location(E) -->
<div class= "wrap_search_tab">
<div class= "opus_design_inquiry wFit">
	<!-- layout_wrap(S) -->
	  <table>
		<tbody>
		<colgroup>
				<col width="10"/>
				<col width="140"/>
				<col width="50"/>
				<col width="10"/>
				<col width="40"/>				
				<col width="*" />
			</colgroup>
			<tr>
				<th>RHQ</th>
				<td><input type="text" class="input" name="rhq_cd" style="ime-mode:disabled" dataformat="engup" size="7" maxlength="6" fulfill="" value="" id="rhq_cd" /><!--   
				 --><button type="button" id="btn_rhq_cd" name="btn_rhq_cd" class="input_seach_btn"></button></td>					
				<td></td>
				<th>Booking Office</th>
				<td><input type="text" class="input" name="bkg_ofc_cd" style="ime-mode:disabled" dataformat="enguponly" size="20" maxlength="6" fulfill="" value="" id="bkg_ofc_cd" /><!--   
				 --><button type="button" id="btn_bkg_ofc_cd" name="btn_bkg_ofc_cd" class="input_seach_btn"></button></td>
				<td></td>									
			</tr>
		</tbody>
	  </table>
      <table>
		<tbody>
		<colgroup>
			<col width="50"/>
			<col width="127"/>
			<col width="50"/>
			<col width="80"/>
			<col width="50"/>			
			<col width="*"/>
		</colgroup>
				<tr>
					<th>Search Option by Booking Wise</th>
					<th>Booking Number</th>
					<td><input type="text" class="input" name="bkg_no" style="ime-mode:disabled" dataformat="engup" size="20" maxlength="13" fulfill="" value="" id="bkg_no" /> </td>
					<th>Search Option by Logistics Wise</th>
					<th>OP Location</th>
					<td><input type="text" class="input" name="op_loc_cd" style="ime-mode:disabled" dataformat="engup" size="5" maxlength="5" fulfill="" value="" id="op_loc_cd" /><!--   
					 --><button type="button" id="btn_op_loc_cd" name="btn_op_loc_cd" class="input_seach_btn"></button></td>
				</tr> 
				<tr> 
				    <td></td>
					<th>Customer Code</th>
					<td><input type="text" class="input" name="cust_cd" style="ime-mode:disabled" dataformat="engup" size="20" maxlength="8" fulfill="" value="" id="cust_cd" /><!--  
					  --><button type="button" id="btn_cust_cd" name="btn_cust_cd" class="input_seach_btn"></button></td>
				    <td></td>
					<th>Staying Days</th>
					<td><input type="text" class="input" name="stay_days" style="ime-mode:disabled" dataformat="num" size="5" maxlength="5" fulfill="" value="" id="stay_days" /> <b> or over</b> </td>
				</tr> 
				<tr> 
				    <td></td>
					<th>Customer Name</th>
					<td><input type="text" class="input" name="cust_nm" style="ime-mode:disabled; width:184px" dataformat="engup" size="100" maxlength="200" fulfill="" value="" id="cust_nm" /> </td>
					<td><td>
					<td><td>
					<td><td>
				</tr> 
		</table>
	</div>
</div>
<div class="wrap_result">
    <div class="opus_design_tab sm" >
		<script type="text/javascript">ComTabObject("tab1")</script>
	</div>
	<div class="opus_design_grid"  id="tabLayer" style="display:inline">
 		<script type="text/javascript">ComSheetObject('sheet1');</script>
    </div>
    <div class="opus_design_grid"  id="tabLayer" style="display:none">
 		<script type="text/javascript">ComSheetObject('sheet2');</script>
    </div>
</div>			
</form>				
