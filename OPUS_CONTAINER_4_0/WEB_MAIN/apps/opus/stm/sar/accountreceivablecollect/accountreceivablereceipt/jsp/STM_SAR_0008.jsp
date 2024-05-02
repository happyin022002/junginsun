<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAR_0008.jsp
*@FileTitle  : Receipt Refund Information Popup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/07
=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.event.StmSar0008Event"%>
<%@ page import="java.util.List"%>


<%

	StmSar0008Event event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String strUsr_id = "";
	String strUsr_nm = "";

	String rctDpsDt = "";
	String aplyFlg = "";
	String apOfcCd = "";
	String wrtfRmk = "";
	String vndrNo = "";
	String apGlDt = "";
	String apRmk = "";


	Logger log = Logger.getLogger("com.clt.apps.opus.stm.sar.accountreceivablecollect.AccountReceivableCollectSC"); //수정

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (StmSar0008Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		// Get main parameter value
		rctDpsDt = JSPUtil.getNull(request.getParameter("rct_dps_dt"));
		aplyFlg = JSPUtil.getNull(request.getParameter("aply_flg"));
		apOfcCd = JSPUtil.getNull(request.getParameter("ap_ofc_cd"));
		wrtfRmk = JSPUtil.getNull(request.getParameter("wrtf_rmk"));
		vndrNo = JSPUtil.getNull(request.getParameter("vndr_no"));
		apGlDt = JSPUtil.getNull(request.getParameter("ap_gl_dt"));
		apRmk = JSPUtil.getNull(request.getParameter("ap_rmk"));

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

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="rct_dps_dt" value="<%=rctDpsDt%>" id="rct_dps_dt" />

<div class="layer_popup_title">
	<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><span>Receipt Refund  Information</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
		<% // receipt No 가 없을 경우 신규입력
                   if(aplyFlg==null || aplyFlg.equals("") || aplyFlg.equals("N")) { %><!--     
			 --><button type="button" class="btn_accent" name="btn_Ok" 	id="btn_Ok">OK</button><!-- 
	 --><% } else {  // receipt No 가 있을 경우 단순 조회 %><!--
			--><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button><!-- 
     --><%} %><!--
		--></div>
		<!-- opus_design_btn(E) -->
		<!-- page_location(S) -->
		<div class="location">
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->
	</div>
	<!-- page_title_area(E) -->
	</div>
</div>
<div class="layer_popup_contents">
	<% // receipt No 가 없을 경우 신규입력
   if(aplyFlg==null || aplyFlg.equals("") || aplyFlg.equals("N")) { %> 
	<div class= "wrap_search">
		<div class= "opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="80"/>
					<col width="350"/>
					<col width="100"/>
					<col width="350"/>
					<col width="100"/>
					<col width="*" />
				</colgroup>
				<tbody>
                    <tr>
	                      <th>AR Remark</th>
	                      <td colspan="5"><input type="text" style="width:100%;" class="input" name="wrtf_rmk" value="<%=wrtfRmk%>" id="wrtf_rmk" /> </td>
                   </tr>
                   <tr><td colspan="6"><hr size="1px" color="#dadada"></td></tr>
                    <tr>
	                      <th>AP Office</th>
						  <td><input type="text" style="width:100px;" class="input1" name="ap_ofc_cd" maxlength="8" dataformat="engup" value="<%=apOfcCd%>" id="ap_ofc_cd" /><button type="button" id="btns_search_ofc" name="btns_search_ofc" class="input_seach_btn"></button></td>
	                      <th>Vendor Code</th>
	                      <td><input type="text" style="width:100px;" class="input1" name="vndr_no" maxlength="8" dataformat="engup" value="<%=vndrNo%>" id="vndr_no" /><button type="button" id="btns_search_vndr" name="btns_search_vndr" class="input_seach_btn"></button></td>
	                      <th>AP GL Date</th>
	                      <td><input type="text" style="width:80px;" class="input1" name="ap_gl_dt" maxlength="8" dataformat="ymd" value="<%=apGlDt%>" id="ap_gl_dt" /><button type="button" id="btn_apgl_calendar" name="btn_apgl_calendar" class="calendar ir"></button></td>
                    </tr>
                    <tr>
	                      <th>AP Remark</th>
	                      <td colspan="5"><input type="text" style="width:100%;" class="input1" name="ap_rmk" value="<%=apRmk%>" id="ap_rmk" /> </td>
                    </tr>
				</tbody>
			</table>
		</div>
	</div>		
	<% } else {  // receipt No 가 있을 경우 단순 조회 %>
	<div class= "wrap_search">
		<div class= "opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="80"/>
					<col width="350"/>
					<col width="100"/>
					<col width="350"/>
					<col width="100"/>
					<col width="*" />
				</colgroup>
					<tbody>
	                    <tr>
		                      <th>AR Remark</th>
		                      <td colspan="5"><input type="text" style="width:100%;" readonly class="input2" name="wrtf_rmk" value="<%=wrtfRmk%>" id="wrtf_rmk" /> </td>
	                   </tr>
	                   <tr><td colspan="6"><hr size="1px" color="#dadada"></td></tr>
	                    <tr>
		                      <th>AP Office</th>
							  <td><input type="text" style="width:100px;" readonly class="input2" name="ap_ofc_cd" value="<%=apOfcCd%>" id="ap_ofc_cd" /> </td>
		                      <th>Vendor Code</th>
		                      <td><input type="text" style="width:100px;" readonly class="input2" name="vndr_no" value="<%=vndrNo%>" id="vndr_no" /> </td>
		                      <th>AP GL Date</th>
		                      <td><input type="text" style="width:80px;" readonly class="input2" name="ap_gl_dt" maxlength="8" dataformat="ymd" value="<%=apGlDt%>" id="ap_gl_dt" /> </td>
	                    </tr>
	                     <tr>
		                      <th>AP Remark</th>
		                      <td colspan="5"><input type="text" style="width:100%;" readonly class="input2" name="ap_rmk" value="<%=apRmk%>" id="ap_rmk" /> </td>
	                    </tr>
					</tbody>
			</table>
		</div>
	</div>
	 <%} %>
	<!-- opus_design_grid(S) -->	
	<div class="wrap_result">
		<div class="opus_design_grid clear" id="mainTable"  style="display:none">
				<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>


<%@include file="/bizcommon/include/common_opus.jsp"%>	