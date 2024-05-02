<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : STM_SAP_0032.js
*@FileTitle  : Supplier Bank Account
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.StringUtil" %>


<%
    //StmSap0032Event event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	
	String strUsr_id = "";
	String strUsr_nm = "";
	
	String vndr_seq  = "";
	String curr_cd   = "";
	String call_flag = "";
	String bank_acct_tp_nm = "";
	
	String vendor_class = "";
	String vndr_lgl_eng_nm = "";
	
	Logger log = Logger.getLogger("com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
		//event = (StmSap0032Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		vndr_seq = StringUtil.xssFilter(request.getParameter("vndr_seq")) != null ? StringUtil.xssFilter(request.getParameter("vndr_seq")) : "";
		curr_cd  = StringUtil.xssFilter(request.getParameter("curr_cd"))  != null ? StringUtil.xssFilter(request.getParameter("curr_cd")) : "";
		call_flag  = StringUtil.xssFilter(request.getParameter("call_flag"))  != null ? StringUtil.xssFilter(request.getParameter("call_flag")) : "";
		bank_acct_tp_nm  = StringUtil.xssFilter(request.getParameter("bank_acct_tp_nm"))  != null ? StringUtil.xssFilter(request.getParameter("bank_acct_tp_nm")) : "";
		vndr_lgl_eng_nm = StringUtil.xssFilter(request.getParameter("vndr_lgl_eng_nm")) != null ? StringUtil.xssFilter(request.getParameter("vndr_lgl_eng_nm")) : "";
		
		if("".equals(call_flag)){
			vendor_class = " class='input' ";
		} else {
			vendor_class = " class='input2' readonly ";
		}
	
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
				
	} catch(Exception ex) {
		log.error("err " + ex.toString(), ex);
		//out.println(e.toString());
	}
%>
<script  type="text/javascript">

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
	
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd"> 
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="curr_cd" id="curr_cd" value="<%=curr_cd%>">
<input type="hidden" name="bank_acct_tp_nm" id="bank_acct_tp_nm" value="<%=bank_acct_tp_nm%>">
<input type="hidden" name="call_flag" value="<%=call_flag%>">

<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><span>Supplier Bank Account</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_retrieve" 	id="btn_retrieve">Retrieve</button>
			<button type="button" class="btn_normal" name="btn_ok" 		id="btn_ok">OK</button>
			<button type="button" class="btn_normal" name="btn_close"  		id="btn_close">Close</button>	
		</div>
		<!-- opus_design_btn(E) -->
	</div>
	<!-- page_title_area(E) -->
</div>

<div class="layer_popup_contents">
	<!-- opus_design_grid(S) -->
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry">
			<table>
					<colgroup>
						<col width="80"/>
						<col width="80"/>
						<col width="80"/>
						<col width="*"/>
				    </colgroup>
				    <tbody>
					<tr>
						<th>Supplier Code</th>
						<td><input type="text" style="width:70px;" <%= vendor_class %>  name="vndr_seq"  id="vndr_seq"  value="<%=vndr_seq%>" maxlength="6" dataformat="engup" style="ime-mode:disabled"></td>
						<th>Supplier Name</th>
                        <td><input type="text" style="width:200px;" <%= vndr_lgl_eng_nm %>  name="vndr_name"   id="vndr_name"   value="<%=vndr_lgl_eng_nm%>" maxlength="100" > </td>
          					
					</tr>
				</tbody>
			</table>
		</div>	
		<!-- opus_design_inquiry(E) -->
 	</div>
 	 <div class="wrap_result" style="overflow:hidden; padding-bottom:30px !important;">
		<div class="opus_design_grid clear" >
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	 </div>
	<!-- opus_design_grid(E) -->
</div>
</form>
 <%@ include file="/bizcommon/include/common_opus.jsp"%>