<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_MNR_0102.jsp
*@FileTitle  : Total Loss Performance 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/19
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.reportmanage.performancereport.event.EesMnr0102Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0102Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//count of DB resultSet list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	String strOfc_cd        = "";
	String rhqOfcCd         = ""; 
	Logger log = Logger.getLogger("com.clt.apps.ReportManage.PerformanceReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		
		strOfc_cd = account.getOfc_cd();
		rhqOfcCd  = account.getRhq_ofc_cd();

		event = (EesMnr0102Event)request.getAttribute("Event");
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
<script type="text/javascript">
	var currOfcCd = '<%=strOfc_cd %>';
	var rhqOfcCd  = '<%=rhqOfcCd %>';
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<!-- Developer's task	-->
<input type="hidden" name="eq_kind" id="eq_kind">   
<input type="hidden" name="rhq" id="rhq">
<input type="hidden" name="ofc_cd" id="ofc_cd">   
<input type="hidden" name="hid_rulabel_type" id="hid_rulabel_type" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button>
		<button type="button" class="btn_normal" name="btn_New"  	id="btn_New">New</button>
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table>
			<tbody>
				<colgroup>
					<col width="50"/>				
					<col width="140"/>
					<col width="78"/>
					<col width="140"/>
					<col width="50"/>
					<col width="120"/>
					<col width="80"/>	
					<col width="*" />
				</colgroup>
				<tr>
					<th>EQ Kind</th>
					<td><script type="text/javascript">ComComboObject('combo_eq_kind',1, 102 , 1,1)</script></td>
					<th>Regional HQ</th>
					<td><script type="text/javascript">ComComboObject('combo_rhq',2, 102 , 0, 1);</script></td>
					<th>Office</th>
					<td><script type="text/javascript">ComComboObject('combo_office',    2, 80 , 0, 1, '', 0, '');</script></td>
					<td><script type="text/javascript"> ComComboObject('in_search_dt_tp', 1, 120, 1, 1);</script></td>
					<td><span class="inquiry_calendar"><input type="text" style="width:80px;" class="input1" name="fm_dt" id="fm_dt" dataformat="ymd"  maxlength="10"  size="10"  cofield="to_dt" value="">~<input type="text" style="width:80px;" class="input1" name="to_dt" id="to_dt" dataformat="ymd"  maxlength="10"  size="10"  cofield="fm_dt"><a class="calendar ir" name="cre_dt_cal" id="cre_dt_cal" style="cursor:pointer">calendar</a></span></td>
				</tr>
				<tr> 
					<th>EQ No.</th>
					<td><input type="text" name="eq_no" id="eq_no" style="width:100px;" class="input" dataformat="engup"><button type="button" class="multiple_inq ir" name="eq_no_multi" id="eq_no_multi"></button></td>
					<th>Total Loss No.</th>
					<td><input type="text" name="total_loss_no" id="total_loss_no" style="width:100px;" class="input" dataformat="engup" otherchar="-"><button type="button" class="multiple_inq ir" name="tln_multi" id="tln_multi"></button></td>
					<th>Main Reason</th>
					<td><script type="text/javascript">ComComboObject('rsn_cd', 1, 80, 1, 0);</script></td>		
					<th>Sub Reason</th>	 
					<td><script type="text/javascript">ComComboObject('ttl_lss_dtl_rsn_cd', 1, 100, 1, 0);</script></td>
				</tr> 
				<tr>
					<th>Status</th>   	
					<td><script type="text/javascript">ComComboObject('in_status_tp',1, 100 , 1,0)</script></td>
					<th>Close Type</th>	
					<td><script type="text/javascript">ComComboObject('ttl_lss_cmpl_cd',1, 100 , 1,0)</script></td>
					<th>Lessor</th>		 	
					<td colspan=3><input type="text" name="vndr_seq" id="vndr_seq" caption="Service Provider" style="width:55px;text-align:left;" class="input" value="" dataformat="num" maxlength="6"><!-- 
						 --><button type="button" name="btn_vndr" id="btn_vndr" class="input_seach_btn"></button><!-- 
						 --><input type="text" name="vndr_nm" id="vndr_nm" caption="Lessor" style="width:260px;" class="input2" value="" readonly></td>	
				</tr>			
				<tr> 
					<th>RU Label</th>
					<td><input type="text"  name="rstr_usg_lbl" id="rstr_usg_lbl"   style="ime-mode:inactive;background-color:#ffffff"  style="width:150px;" class="input" value=""> <button type="button" id="btn_rulabel_cd" name="btn_rulabel_cd" class="input_seach_btn"></button></td>
					<td  colspan="6"></td>
				</tr>  
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->
<div class="wrap_result">
<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_Excel" 	id="btn_Excel">Down Excel</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_Detail" 	id="btn_Detail">Detail</button><!-- 	
		 --></div>
			<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
<!-- opus_design_grid(E) -->	
</form>