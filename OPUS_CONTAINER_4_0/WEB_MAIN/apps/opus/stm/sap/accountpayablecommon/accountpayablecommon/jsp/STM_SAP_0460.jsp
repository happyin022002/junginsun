<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAP_0460.jsp
*@FileTitle  : INTER COMPANY POPUP 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/
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
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.StringUtil" %>

<%
	Exception serverException = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	String f_intercom = "";
	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.opus.stm.sap.accountpayablecommon.AccountPayableCommonSC");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

// 		event = (StmSap0460Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		f_intercom = StringUtil.xssFilter(request.getParameter("f_intercom"));
		f_intercom = f_intercom==null?"":f_intercom;

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	} catch(Exception ex) {
		log.error("err " + ex.toString(), ex);
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

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />

<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title">
			<span>INTER COMPANY</span>
		</h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn (S) --> 
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
			--><button class="btn_normal" name="btn_OK" id="btn_OK" type="button">OK</button><!--
			--><button class="btn_normal" name="btn_Close" id="btn_Close" type="button">Close</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
	</div>
	<!-- page_title_area(E) -->
</div>

<div class="layer_popup_contents">
	<!-- opus_design_grid(S) -->	
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry">
			<table>
				<tbody>
					<colgroup>
						<col width="50" />
						<col width="*" />
					</colgroup>
					<tr>
						<th>Inter Company</th>
	                   	<td><input type="text" name="f_intercom" dataformat="engup" style="width:120px;" class="input" value="<%=f_intercom%>" id="f_intercom" /></td>                        
					</tr> 
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>

    <div class="wrap_result" >
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>	
	<!-- opus_design_grid(E) -->
</div>

</form>
<%@include file="/bizcommon/include/common_opus.jsp"%>