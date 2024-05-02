<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAR_0013.jsp
*@FileTitle  : Receipt Cancel Information Popup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/07
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
   //StmSar0013Event event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String strUsr_id = "";
	String strUsr_nm = "";
	String rctDpsDt = "";
	String rctOfcCd = "";
	Logger log = Logger.getLogger("com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		//event = (StmSar0013Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		rctDpsDt = JSPUtil.getNull(request.getParameter("rct_dps_dt"));
		rctOfcCd = JSPUtil.getNull(request.getParameter("rct_ofc_cd"));

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

	} catch(Exception ex) {
		log.error("err " + ex.toString(), ex);
		//out.println(e.toString());
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
<link href="css/opus_contents.css" rel="stylesheet" type="text/css">
<link href="css/opus_menu.css" rel="stylesheet" type="text/css">
<body class="popup_bg"  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="eff_dt" value="<%=rctDpsDt%>" id="eff_dt" />
<input type="hidden" name="ofc_cd" value="<%=rctOfcCd%>" id="ofc_cd" />
<input type="hidden" name="sys_div_cd" value="26" id="sys_div_cd" />
<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Receipt Cancel Information</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" type="button" name="btn_Save" id="btn_Save">Save</button><!--
			--><button class="btn_normal" type="button" name="btn_Close" id="btn_Close" >Close</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
		<!-- page_location(S) -->
		<!-- <div class="location">	
			<span id="navigation"></span>
		</div> -->
		<!-- page_location(E) -->
	</div>
	<!-- page_title_area(E) -->
</div>
<div class="layer_popup_contents">
	<!-- wrap_search(S) -->
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="70" />				
					<col width="*" />				
			   </colgroup> 
			   <tbody>
					<tr>
						<th>Cancel Date</th>
                        <td><input type="text" style="width:80px;" class="input1" name="cancel_dt" value="<%=rctDpsDt%>" maxlength="8" dataformat="ymd" id="cancel_dt" /><button type="button" id="btns_calendar" name="btns_calendar" class="calendar ir"></button></td>
					</tr>
					<tr>
						<th>Cancel Category</th>
                        <td><script type="text/javascript">ComComboObject('receipt_cancel_category', 2, 60, 1, 1);</script><input name="receipt_cancel_category_nm" type="text" style="width:250px;" readonly class="input2" id="receipt_cancel_category_nm" /></td>
					</tr>
					<tr>
						<th>Cancel Reason</th>
	                    <td><script type="text/javascript">ComComboObject('receipt_cancel_reason', 2, 60, 1, 1);</script><input name="receipt_cancel_reason_nm" type="text" style="width:250px;" readonly class="input2" id="receipt_cancel_reason_nm" /> </td>
					</tr>
					<tr>
						<th>Cancel Remark</th>
	                    <td><input type="text" style="width:314px;" class="input" maxlength="500" name="cancel_rmk" id="cancel_rmk" /> </td>
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
		<div class="opus_design_grid" style="display:none">
			<script type="text/javascript">ComSheetObject('sheet1');</script>		
		</div>
		<!-- opus_design_grid(E) -->
	</div>
	<!-- wrap_result(E) -->
</div>

</form>
<%@include file="/bizcommon/include/common_opus.jsp"%>	