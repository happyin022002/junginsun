<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : STM_SAP_0002.jsp
*@FileTitle  : Supplier Code
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
<%@ page import="com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.event.StmSap0002Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.StringUtil" %>

<%
    StmSap0002Event event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	
	String strUsr_id = "";
	String strUsr_nm = "";
	
	String vndr_lgl_eng_nm= "";
	String vndr_seq       = "";
	String delt_flg       = "";
	Logger log = Logger.getLogger("com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
		event = (StmSap0002Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		vndr_lgl_eng_nm = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("vndr_lgl_eng_nm")));
		vndr_seq        = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("vndr_seq")));	
		delt_flg        = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("delt_flg"))); 
		
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
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows">
<input type="hidden" name="delt_flg" value="<%=delt_flg%>">
	<div class="layer_popup_title">
		<!-- page_title_area(S) -->
		<div class="page_title_area clear">
		   <!-- page_title(S) -->
			<h2 class="page_title"><span>Supplier Code</span></h2>
			<!-- page_title(E) -->
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_retrieve" 	id="btn_retrieve">Retrieve</button><!--
				--><button type="button" class="btn_normal" name="btn_ok" 		id="btn_ok">OK</button><!--
				--><button type="button" class="btn_normal" name="btn_close"  		id="btn_close">Close</button>	
			</div>
			<!-- opus_design_btn(E) -->
		</div>
		<!-- page_title_area(E) -->
	</div>
	<!-- opus_design_inquiry(S) -->
	<div class="layer_popup_contents">
		<div class= "wrap_search">
			<div class= "opus_design_inquiry wFit">
				<table>
					<tbody>
						<colgroup>
							<col width="80"/>
							<col width="60"/>
							<col width="80"/>
							<col width="*"/>
					    </colgroup>
						<tr>
							<th>Supplier Code</th>
	                        <td><input type="text" style="width:60px;" class="input" name="vndr_seq" value="<%=vndr_seq%>" maxlength="6" dataformat="engup" id="vndr_seq" /> </td>
	                        <th>Supplier Name</th>
	                        <td><input type="text" style="width:170px;" class="input" name="vndr_lgl_eng_nm" value="<%=vndr_lgl_eng_nm%>" id="vndr_lgl_eng_nm" /> </td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<!-- opus_design_inquiry(E) -->
		<!-- opus_design_grid(S) -->
		<div class="wrap_result" style="overflow:hidden; padding-bottom:30px !important;">
			<div class="opus_design_grid clear" >
				<script type="text/javascript">ComSheetObject('sheet1');</script>
			</div>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
</form>
<%@ include file="/bizcommon/include/common_opus.jsp"%>