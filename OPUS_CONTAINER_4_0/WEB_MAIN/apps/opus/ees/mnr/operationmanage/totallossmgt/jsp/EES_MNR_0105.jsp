<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_MNR_0105.jsp
*@FileTitle  : Total Loss Payment to Lessor Report
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
<%@ page import="com.clt.apps.opus.ees.mnr.operationmanage.totallossmgt.event.EesMnr0105Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EesMnr0105Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Occurred error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//Row count of retrieved database data
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	Logger log = Logger.getLogger("com.clt.apps.OperationManage.TotalLossMgt");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		event = (EesMnr0105Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		//Extracting retrieved data from server on load screen
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
<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="ttl_lss_sts_cd" id="ttl_lss_sts_cd">
<input type="hidden" name="self_ofc_cd" id="self_ofc_cd" value="<%=strOfc_cd%>">
<input type="hidden" name="eq_type" id="eq_type">
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_new"  	id="btn_new">New</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_downexcel" 	id="btn_downexcel">Down Excel</button>			
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<!-- opus_design_inquiry(S) -->
<div class= "wrap_search">
	<div class="opus_design_inquiry wFit">
		<table>
		<colgroup>
          <col width="1" />
          <col width="100" />
          <col width="100" />
          <col width="100" />
          <col width="60" />
          <col width="100" />
          <col width="80" />
          <col width="*" />
          </colgroup>
		
			<tbody>
				<tr class="h23">
					<th>EQ Type</th>
					<td><script type="text/javascript">ComComboObject('combo_eq_type',1, 102 , 1,1)</script></td>
					<th>Period</th>
					<td><input required type="text" name="from_dt" id="from_dt" dataformat="ymd"    caption="from date"        maxlength="10"  size="10"  cofield="to_dt" value="" class="input1">~ <input required type="text" name="to_dt" id="to_dt" dataformat="ymd"    caption="to date"        maxlength="10"  size="10"  cofield="from_dt" class="input1"><button type="button" class="calendar ir" name="btn_calendar" id="btn_calendar"></button></td>
					<th>Status</th>
					<td><script type="text/javascript">ComComboObject('combo_ttl_lss_sts_cd',1, 135 , 1,1)</script></td>
					<td></td>
				</tr>
				<tr class="h23">
					<th>EQ No.</th>
					<td><input type="text" name="eq_no" id="eq_no" style="width:102px;" class="input" dataformat="engup"><!--
					--><button type="button" class="multiple_inq ir" name="eq_no_multi" id="eq_no_multi"></button></td>
					<th>Total Loss No.</th>
					<td><input type="text" name="total_loss_no" id="total_loss_no" style="width:100px;" class="input" dataformat="engup" otherchar="-,"><button type="button" class="multiple_inq ir" name="tln_multi" id="tln_multi"></button></td>
					<th>Lessor</th>
					<td style="padding-left: 2px;"><input type="text" name="lessor" id="lessor" caption="Lessor" style="width:57px;text-align:left;" class="input" value="" dataformat="engup" maxlength="6"><button type="button" class="input_seach_btn" name="btn_provider_popup" id="btn_provider_popup"></button><input type="text" name="vndr_lgl_eng_nm" id="vndr_lgl_eng_nm" style="width:152px;" class="input2" readOnly="true"></td>
					<th>Currency</th>
					<td>
						<select style="width:80px;" class="input" name="curr_cd" id="curr_cd" onChange="obj_change();">
                             <option value=""></option>
                             <option value="USD">USD</option>
                             <option value="JPY">JPY</option>
                         </select>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->
	<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid" id="mainTable" name="mainTable">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
<!-- opus_design_grid(E) -->	
</form>
