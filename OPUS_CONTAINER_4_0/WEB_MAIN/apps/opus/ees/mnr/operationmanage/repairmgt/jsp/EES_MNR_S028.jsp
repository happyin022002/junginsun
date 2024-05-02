<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_S028.jsp
*@FileTitle  : M&R Repair Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/08
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.event.EesMnrS028Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnrS028Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100"; 

	String strUsr_id		= ""; 
	String strUsr_nm		= "";  
	String strOfc_cd		= "";  
	String strVndr_seq		= "";
	String strVndr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.OperationManage.RepairMgt");

	try {     
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();       
		strUsr_nm = account.getUsr_nm();    
	    strOfc_cd = account.getOfc_cd(); 
		strVndr_seq = account.getOfc_eng_nm();
		strVndr_nm 	= account.getOfc_krn_nm();

		event = (EesMnrS028Event)request.getAttribute("Event"); 
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
<!--MNR 공용 사용  -->	                
<script type="text/javascript"> 
    var strVndrSeq = "<%=strVndr_seq%>";
    strVndrSeq = ComLpad(strVndrSeq,6,"0");
	function setupPage(){  
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if	 	 
		loadPage(); 
	}
</script> 
<script type="text/javascript">ComSheetObject('sheet1');</script>     
<form name="form"> 
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<!-- 견적서발급과 감사를 구분하기위한 rqst_cre/rqst_aud-->
<input type="hidden" name="tpb_only" value="N" id="tpb_only" />
<input type="hidden" name="rpr_rqst_seq" id="rpr_rqst_seq" />
<input type="hidden" name="rpr_rqst_ver_no" id="rpr_rqst_ver_no" />
<input type="hidden" name="user_nm" value="<%=strUsr_nm%>" id="user_nm" />

<!-- RD용  --> 
<input type="hidden" name="com_mrdPath" value="" id="com_mrdPath" />
<input type="hidden" name="com_mrdArguments" value="" id="com_mrdArguments" />
<input type="hidden" name="com_mrdBodyTitle" value="" id="com_mrdBodyTitle" />
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" type="button" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
			--><button class="btn_normal" type="button" name="btn_New" id="btn_New">New</button><!--
			--></div>
		<!-- opus_design_btn (E) -->

		<!-- page_location(S) -->
		<div class="location">	
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->
	</div>
	<!-- page_title_area(E) -->
	<!-- wrap_search(S) -->
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="70" />				
					<col width="150" />				
					<col width="60" />				
					<col width="140" />				
					<col width="70" />				
					<col width="240" />				
					<col width="45" />				
					<col width="*" />				
			   </colgroup> 
			   <tbody>
					<tr>
						<th>W/O Type </th>
						<td><script type="text/javascript">ComComboObject('wo_type', 1, 95, 1, 0,0,false,0);</script></td> 
						<th>EQ Type</th>
						<td><script type="text/javascript">ComComboObject('eq_knd_cd', 1, 100, 1, 0,0,false,0);</script></td> 
						<th>Input Dt.</th>
						<td><input style="width:80px;" requiredtype="text" name="fm_est_dt" dataformat="ymd" caption="from date" maxlength="10" size="9" cofield="to_est_dt" value="" class="input1" id="fm_est_dt" />~ <input style="width:80px;" required="" type="text" name="to_est_dt" dataformat="ymd" caption="to date" maxlength="10" size="9" cofield="fm_est_dt" class="input1" id="to_est_dt" /><button type="button" id="btn_calendar" name="btn_calendar" class="calendar ir"></button></td>
						<th>Status</th>
						<td><script type="text/javascript">ComComboObject('status_cd', 1, 110, 1, 0,0,false,0);</script></td>
					</tr>
					<tr>
						<th>EQ No.</th>
						<td><input name="rqst_eq_no" type="text" style="width:98px;" class="input" dataformat="engup" value="" id="rqst_eq_no" /><button type="button" id="eq_no_multi1" name="eq_no_multi1" class="multiple_inq ir"></button></td>
						<th>EST No.</th>
						<td><input name="rqst_ref_no" type="text" style="width:70px;" class="input" dataformat="engup" value="" id="rqst_ref_no" /><button type="button" id="eq_no_multi2" name="eq_no_multi2" class="multiple_inq ir"></button></td>
						<th>W/O No.</th>
						<td><input name="wo_no" type="text" style="width:132px;" class="input" dataformat="engup" value="" id="wo_no" /><button type="button" id="eq_no_multi3" name="eq_no_multi3" class="multiple_inq ir"></button></td>
						<td colspan="2"><label for="temp_tpb_only">TPB Request Only</label><input name="temp_tpb_only" type="checkbox" value="Y" class="trans" id="temp_tpb_only" /></td>
					</tr>
					<tr>
						<th>Service Provider</th>
						<td colspan="3"><input type="text" name="vndr_seq" caption="Service Provider" style="width:55px;text-align:center;" class="input2" dataformat="num" value="" readonly id="vndr_seq" /><input type="text" name="vndr_nm" caption="Service Provider" style="width:250px;" class="input2" value="<%=strVndr_nm %>" readonly id="vndr_nm" /> </td>
						<th>C.Office</th>
						<td colspan="3"><input name="cost_ofc_cd" type="text" style="width:98px;" class="input2" dataformat="engup" value="<%=strOfc_cd %>" readonly id="cost_ofc_cd" /> </td>
					</tr>
			   </tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	<!-- wrap_search(E) -->

	<!-- wrap_result(S) -->
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<h3 class="title_design">D/dock Schedule Input / Master</h3>
			<!-- opus_design_btn (S) -->
			<div class="opus_design_btn">
				<button class="btn_accent" name="btn_DownExcel" id="btn_DownExcel" type="button">Down Excel</button><!--
				--><button class="btn_normal" name="btn_Detail" id="btn_Detail" type="button">Detail(s)</button><!--
				--><button class="btn_normal" name="btn_Print" id="btn_Print" type="button">Print</button><!--
				--></div>
			<!-- opus_design_btn (E) -->
			<script type="text/javascript">ComSheetObject('sheet2');</script>		
		</div>
		<!-- opus_design_grid(E) -->
	</div>
	<!-- wrap_result(E) -->
  		
</form>