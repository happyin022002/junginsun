<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0735.jsp
*@FileTitle  : Dangerous cargo application Copy
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/04
=========================================================
*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.event.EsmBkg0735Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0735Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String copyFlg = "";
	Logger log = Logger.getLogger("com.clt.apps.SpecialCargoBookingConduct.SpecialCargoReceipt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0735Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		copyFlg =  JSPUtil.getParameter(request, "copyFlg");
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>DG application copy</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){	
	
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" id="copyFlg" name="copyFlg" value="<%=copyFlg%>">

	<!-- popup_title_area(S) -->
 <div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>DG Application Copy</span></h2>
		<!-- page_title(E) -->
			
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_ok" id="btn_ok">OK</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->	
	</div>
	<!-- page_title_area(E) -->
</div>
<!-- popup_title_area(E) -->

<!-- popup_contens_area(S) -->
<div class="layer_popup_contents">
	<div class="wrap_result">
	<% if(copyFlg.equals("Y")){ %>
		<div class="opus_design_inquiry">
			<table> 
				<tbody>
					<tr>
					
						<th>No. of New Seq.</th>
						<td>
							<input id="radioChk1" name="radioChk1" type="hidden" value="1">
							<input id="chk1text" name="chk1text" type="text" style="width:150" value="">
						</td>		
					</tr>
				</tbody>
			</table>
		</div>
	<% }else{ %>
		<div class="opus_design_inquiry">
			<table> 
				<tbody>
					<tr>
						<td>
						<input id="radioChk1" name="radioChk1" type="hidden" value="2"><label for="radioChk2_new">Copy cargo Sequence</label>
						</td>
						<td>No. of New Seq.</td>
								
					</tr>
					<tr>
					<td>
						<input id="radioChk2_new" name="radioChk2" type="radio" value="1"><label for="radioChk2">To New CNTR Seq.</label>
						
					</td>
					<td><input id="chk2text" name="chk2text" type="text" style="width:150" value="">
					</td>
					</tr>
					<tr>
						<td colspan="2"><input id="radioChk2_exist" name="radioChk2" type="radio" value="2" class="trans"><label for="radioChk2_exist">To Existing CNTR Seq.</label></td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
	    </div>
	<% } %>
	</div>
</div>
<!-- popup_contens_area(E) -->

</form>