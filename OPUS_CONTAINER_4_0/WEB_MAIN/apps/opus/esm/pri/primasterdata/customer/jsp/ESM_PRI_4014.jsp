<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved. 
*@FileName   : ESM_PRI_4014.jsp
*@FileTitle  : Customer Inquiry
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
<%@ page import="com.clt.apps.opus.esm.pri.primasterdata.customer.event.EsmPri4014Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmPri4014Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //Error from Server
	String strErrMsg = ""; //Error Message
	int rowCount = 0; //Number of DB ResultSet List

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.PRIMasterData.Customer");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmPri4014Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		// Adding Logic extracting data from server when loading initial window ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request
				.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
	
	String nmdCustFlg = null;
	String custCntCd = null;
	String custSeq = null;
	String custNm = null;
	String isPopup = null;
	String rtnFunc = null;
	
	nmdCustFlg = JSPUtil.getNull(request.getParameter("nmd_cust_flg")); //Including Named Customer or not
	custCntCd = JSPUtil.getNull(request.getParameter("cust_cnt_cd"));
	custSeq = JSPUtil.getNull(request.getParameter("cust_seq"));
	custNm = JSPUtil.getNull(request.getParameter("cust_nm"));
	isPopup = JSPUtil.getNull(request.getParameter("is_popup")); //POP UP Screen or not
	rtnFunc = JSPUtil.getNull(request.getParameter("rtnFunc")); //Return function name
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

<form name="form" onKeyUp="ComKeyEnter('LengthNextFocus')">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />

<input type="hidden" name="nmd_cust_flg" value="<%=nmdCustFlg%>" id="nmd_cust_flg" />
<input type="hidden" name="is_popup" value="<%=isPopup%>" id="is_popup" />
<input type="hidden" name="rtnFunc" value="<%=rtnFunc %>" id="rtnFunc" />
<%
    if (isPopup.equals("true")) {
%>
<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><span>Customer Inquiry</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
		    <button type="button" class="btn_accent" name="btn_retrieve"   id="btn_retrieve">Retrieve</button>
			<button type="button" class="btn_accent" name="btn_ok" 			id="btn_ok">OK</button>
			<button type="button" class="btn_accent" name="btn_close" 		id="btn_close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->
	</div>
	<!-- page_title_area(E) -->
</div>
<%
    } else {
%>
<!-- page_title_area(S) -->
<div class="page_title_area clear">

 <!-- page_title(S) -->
 <h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
 <!-- page_title(e) -->
 
 <!-- opus_design_btn(S) -->
 <div class="opus_design_btn">
  <button type="button" class="btn_accent" name="btn_retrieve"   id="btn_retrieve">Retrieve</button>
 </div>
 <!-- opus_design_btn(e) -->

 <!-- page_location(S) -->
 <div class="location"> 
  <span id="navigation"></span>
 </div>
 <!-- page_location(e) -->
 
</div>
<!-- page_title_area(e) -->
<%
    }
%>
<%
    if (isPopup.equals("true")) {
%>
<div class="layer_popup_contents">
<%
    }
%>
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
		    <table>
		        <tbody>
					<tr>
						<th width="60">Customer Code</th>
						<td>
						
						<input type="text" name="cust_cnt_cd" value="<%=custCntCd%>" dataformat="enguponly" maxlength="2" minlength="2" style="width: 35px; ime-mode:disabled" class="input" >
						<input type="text" name="cust_seq"  value="<%=custSeq%>" dataformat="num" maxlength="6" minlength="1" style="width: 50px; ime-mode:disabled" class="input">
						
						</td>
					</tr>
					<tr>
						<th>Customer Name</th>
						<td><input type="text" name="cust_lgl_eng_nm" value="<%=custNm%>" maxlength="100" style="width: 200px; ime-mode:disabled" class="input" value=""></td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	
	<!-- opus_design_grid(S) -->
	<div class="wrap_result">
		<div class="opus_design_grid">
		    <script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
	<!-- opus_design_grid(E) -->

<%
    if (isPopup.equals("true")) {
%>
</div>
<%
    }
%>

</form>