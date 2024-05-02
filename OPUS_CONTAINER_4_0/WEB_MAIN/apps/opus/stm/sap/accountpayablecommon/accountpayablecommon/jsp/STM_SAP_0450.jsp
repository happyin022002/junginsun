<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAP_0450.js
*@FileTitle  : Account Popup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/14
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.event.StmSap0450Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.StringUtil" %>

<%
    StmSap0450Event event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String strUsr_id = "";
	String strUsr_nm = "";

	String acct_cd = "";
	String acct_nm = "";
	String acctg_mng_tp_cd       = "";
	String pnd_tgt_flg       = "";
	String line_type = "";
	Logger log = Logger.getLogger("com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (StmSap0450Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		acct_cd         = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("acct_cd")));
		acct_nm         = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("acct_nm")));
		acctg_mng_tp_cd = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("acctg_mng_tp_cd")));	
		pnd_tgt_flg     = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("pnd_tgt_flg")));   // unsettled_flag
		line_type         = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("line_type")));

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

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="pnd_tgt_flg" value="<%=pnd_tgt_flg%>" id="pnd_tgt_flg" />
<input type="hidden" name="acctg_mng_tp_cd" value="<%=acctg_mng_tp_cd%>" id="acctg_mng_tp_cd" />
<input type="hidden" name="line_type" value="<%=line_type%>" id="line_type" />

<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	    <!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><span>Account</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!-- 
			 --><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_ok"  	id="btn_ok">OK</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_close" 	id="btn_close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->
	</div>
	<!-- page_title_area(E) -->
</div>

<div class="layer_popup_contents">
	<!-- opus_design_grid(S) -->
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="60">
					<col width="90">
					<col width="60">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th>Account Code </th>
                        <td><input type="text" style="width:70px;" class="input" name="acct_cd" value="<%=acct_cd%>" maxlength="6" dataformat="engup" id="acct_cd" /></td>
						<th>Account Name</th>
                        <td><input type="text" style="width:150px;" class="input" name="acct_eng_nm" value="<%=acct_nm%>" id="acct_eng_nm" /></td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	
	<div class="wrap_result" >
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" >
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid(S) -->
	</div>
	<!-- opus_design_grid(E) -->
</div>

</form>
 <%@ include file="/bizcommon/include/common_opus.jsp"%>