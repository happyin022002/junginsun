<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0658.jsp
*@FileTitle  : Stop Off Cargo Order
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
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg0658Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0658Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String calllFunc 		= "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmBkg0658Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		calllFunc  = JSPUtil.getParameter(request, "func");
		
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

<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="calllFunc" id="calllFunc" value="<%=calllFunc%>">

<!-- popup_title_area(S) -->
 <div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Stop Off Cargo Order</span></h2>
		<!-- page_title(E) -->
			
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
       	    <button type="button" class="btn_normal" name="btn_Save" id="btn_Save">OK</button><!-- 
       	     --><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->	
	</div>
	<!-- page_title_area(E) -->
</div>
<!-- popup_title_area(E) -->

<!-- popup_contens_area(S) -->
<div class="layer_popup_contents">
	<div class="wrap_search">
	<div class="opus_design_inquiry">   <!-- no TAB  -->
		<table> 
			<colgroup>
				<col width="90" />
				<col width="110" />
				<col width="40" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<th>Location</th> 
					<td><input type="text" name="stop_off_loc_cd" style="width:100px;ime-mode:disabled;" class="input" maxlength=5></td>
					<th>Tel</th> 
					<td><input type="text" name="stop_off_cntc_phn_no" id="stop_off_cntc_phn_no" style="width:200px;ime-mode:disabled;" size="20" class="input" maxlength=20 otherchar="-"></td>
				</tr>
				<tr>
					<th>Contact Point</th> 
					<td colspan="3"><input type="text" name="stop_off_cntc_pson_nm" id="stop_off_cntc_pson_nm" style="width:350px; size="30" class="input" maxlength=30></td>
				</tr>
				<tr>
    				<th style="text-align:center;"> Remark(s)</th>
    				<td colspan="3"><textarea rows="6" style="width:350px;resize:none;" name="stop_off_diff_rmk"  id="stop_off_diff_rmk"></textarea></td>
				</tr>				
				<tr>
    				<td colspan="4">&nbsp;</td>
				</tr>				
			</tbody>
		</table>
	</div>

	<div class="opus_design_grid" >
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
</div>
</form>