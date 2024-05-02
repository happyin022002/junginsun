<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0648.jsp
*@FileTitle  : BL Copy 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/29
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
<%@ page import="com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg0648Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0648Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			// error from server
	String strErrMsg = "";						// error message
	int rowCount	 = 0;						// count of DB resultSET list
	String successFlag = "";
	String codeList    = "";
	String pageRows    = "100";
	String strUsr_id   = "";
	String strUsr_nm   = "";
	String isPop       = "";
	Logger log = Logger.getLogger("com.clt.apps.OutboundBLMgt.BLDocumentation");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		isPop     = JSPUtil.getParameter(request, "isPop");
		event = (EsmBkg0648Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
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
<input type="hidden" name="bkg_no" id="bkg_no">
<input type="hidden" name="bkgStatus" id="bkgStatus">
<input type="hidden" name="bdrFlg" id="bdrFlg">
<input type="hidden" name="shprCd" id="shprCd">
<input type="hidden" name="isPop" id="isPop" value="<%=isPop%>">

<%-- <%@include file="/apps/opus/esm/bkg/bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp" %> --%>


<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><span>B/L Copy</span></h2>
	
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
		--><button type="button" class="btn_normal" name="btn_copy" id="btn_copy">Copy</button><!--
		--><button class="btn_normal" name="btn_Close" id="btn_Close" type="button">Close</button>
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
		    <colgroup>
				<col width="120px" />
				<col width="130px" />
				<col width="*%" />
			</colgroup>
		<tbody>
			<tr>
		    	<th>Original Booking No.</th>
				<td>
					<input type="text" name="s_bkg_no" id="s_bkg_no" value="" style="width:128px" class="input1" minlength="11" maxLength="13" dataformat="engup" required caption="Original Booking No">
				</td>
				<td></td>
			</tr>
			<tr>
				<th>Shipper</th>
				<td>
					<input type="text" name="cust_cnt_cd" id="cust_cnt_cd" value="" style="width:60px;" disabled="disabled" class="input2" readonly="readonly">
					<input type="text" name="cust_seq" id="cust_seq" value="" style="width:60px;" disabled="disabled" class="input2" readonly="readonly">
					<input type="text" name="cust_nm" id="cust_nm" value="" style="width:240px;" disabled="disabled" class="input2" readonly="readonly">
				</td>
				<td></td>
			</tr>
			<tr>
				<th>Commodity</th>
				<td>
					<input type="text" name="cmdt_cd" id="cmdt_cd" value="" style="width:60px;" disabled="disabled" class="input2" readonly="true">
					<input type="text" name="rep_cmdt_cd" id="rep_cmdt_cd" value="" style="width:60px;" disabled="disabled" class="input2" readonly="true">
					<input type="text" name="cmdt_nm" id="cmdt_nm" value="" style="width:240px;" disabled="disabled" class="input2" readonly="true">
				</td>
				<td></td>
			</tr>
		</tbody>
	</table>
<!-- 	<table class="search"> -->
<!-- 		<colgroup> -->
<!-- 				<col width="15px"/> -->
<!-- 				<col width="5px"/> -->
<!-- 				<col width="30px"/> -->
<!-- 				<col width="*"/> -->
<!-- 		</colgroup> -->
<!-- 		<tr> -->
<!-- 			<td></td> -->
<!-- 			<td class="title_h"></td> -->
<!-- 			<td class="title_s" style="padding-left: 5px;">Copy Item</td> -->
<!-- 			<td></td> -->
<!-- 		</tr> -->
<!-- 	</table> -->
	<h3 class="title_design">Copy Item</h3>
	<table>
		<tr>
			<td></td>
		</tr>
	</table>
    <table>
		<tbody>
			<colgroup>
				<col width="300"/>
				<col width="*"/>
			</colgroup>
			<tr style="height:30px">
				<td  class="sm" >
					<label for="cust_flg">Customer</label><input type="checkbox" name="cust_flg" id="cust_flg" value="Y" class="trans" checked>
					<label for="mark_flg">Marks & Nos</label><input type="checkbox" name="mark_flg" id="mark_flg" value="Y" class="trans">
					<label for="desc_flg">Description of Goods</label><input type="checkbox" name="desc_flg" id="desc_flg" value="Y" class="trans">
				</td>
				<td></td>
			</tr>
		</tbody>
	</table>
	<table>
		<tr>
			<td></td>
		</tr>
	</table>
<!-- 	<table class="search"> -->
<!-- 		<colgroup> -->
<!-- 				<col width="15px"/> -->
<!-- 				<col width="5px"/> -->
<!-- 				<col width="30px"/> -->
<!-- 				<col width="*"/> -->
<!-- 		</colgroup> -->
<!-- 		<tr> -->
<!-- 			<td></td> -->
<!-- 			<td class="title_h"></td> -->
<!-- 			<td class="title_s" style="padding-left: 5px;">Copy To</td> -->
<!-- 			<td></td> -->
<!-- 		</tr> -->
<!-- 	</table> -->
<h3 class="title_design">Copy To</h3>
 
</div>
<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
<!-- opus_design_grid(S) -->	
<div class="opus_design_grid">
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_add" id="btn_add">Row Add</button><!--
		--><button type="button" class="btn_normal" name="btn_delete" id="btn_delete">Row Delete</button>
	</div>
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
</div>
<!-- opus_design_grid(E) -->

</form>
