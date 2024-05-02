<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_S027.jsp
*@FileTitle  : SPP Repair Cancellation and Deletion
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
<%@ page import="com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.event.EesMnrS027Event"%>
<%@ page import="org.apache.log4j.Logger" %>
 			 
<%
	EesMnrS027Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
						 
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";  
 				 
	String strUsr_id		= ""; 
	String strUsr_nm		= "";  
	String strOfc_cd		= "";  
	String strVndr_seq 		= "";
	String strVndr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.OperationManage.RepairMgt");
								        
	try {     
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();       
		strUsr_nm = account.getUsr_nm();    
	    strOfc_cd = account.getOfc_cd(); 
		strVndr_seq = account.getOfc_eng_nm();
		strVndr_nm 	= account.getOfc_krn_nm();
						
		event = (EesMnrS027Event)request.getAttribute("Event");
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
			showErrMessage(errMessage);
		} // end if	 	
		loadPage(); 
	}
</script> 
<script type="text/javascript">ComSheetObject('sheet1');</script>     
<form name="form"> 
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="wo_type" value="EST" id="wo_type" />
<input type="hidden" name="cost_ofc_cd" value="<%=strOfc_cd%>" id="cost_ofc_cd" />
<input type="hidden" name="screen_flag" value="DEL" id="screen_flag" />
		     
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" type="button" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
		--><button class="btn_normal" type="button" name="btn_New" id="btn_New">New</button><!--
		--><button class="btn_normal" type="button" name="btn_Delete" id="btn_Delete">Delete</button>
	</div>
	<!-- opus_design_btn (E) -->
	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->		     

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="50">
				<col width="160">
				<col width="50">
				<col width="200">
				<col width="50">
				<col width="180">
				<col width="100">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>EQ Type </th>
					<td><script type="text/javascript">ComComboObject('eq_knd_cd', 1, 90, 1, 0,0,false,0);</script></td>
					<th>S/P</th>
					<td>
						<input type="text" name="vndr_seq" style="width:40px;text-align:center;" class="input2" dataformat="num" value="<%=strVndr_seq %>" readonly id="vndr_seq" /><!-- 
						 --><input type="text" name="vndr_nm" style="width:110px;" class="input2" value="<%=strVndr_nm %>" readonly id="vndr_nm" />
					<th>C.OFC</th>
					<td><input type="text" style="width:50px;" name="cost_ofc_cd" class="input2" value="<%=strOfc_cd%>" readonly id="cost_ofc_cd" /> </td>
					<th>Input Date</th>
					<td>
						<input required type="text" name="fm_est_dt" dataformat="ymd" caption="from date" maxlength="10" size="10" cofield="to_est_dt" value="" class="input1" id="fm_est_dt" />~ <!-- 
						 --><input required type="text" name="to_est_dt" dataformat="ymd"    caption="to date"  maxlength="10"  size="10"  cofield="fm_est_dt" class="input1"><!--
						 --><button type="button" id="btns_calendar" name="btns_calendar" class="calendar ir"></button>
					</td>	
				</tr> 
				<tr>
					<th>EQ No. </th>
					<td>
						<input type="text" name="rqst_eq_no" style="width:80px;" class="input" value="" id="rqst_eq_no" /><!-- 
						 --><button type="button" id="eq_no_multi1" name="eq_no_multi1" class="multiple_inq"></button>
					</td>
					<th>EST No.</th>
					<td>
						<input type="text" name="rqst_ref_no" style="width:80px;" class="input" value="" id="rqst_ref_no" /><!--
						 --><button type="button" id="eq_no_multi2" name="eq_no_multi2" class="multiple_inq"></button>
					</td>
					<th>Status</th>
					<td><script type="text/javascript">ComComboObject('status_cd', 1, 160, 1, 0,0,false,0);</script></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
	<div class="opus_design_grid">
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_Detail" id="btn_Detail">Detail(s)</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
</div>	
</form>
</html>