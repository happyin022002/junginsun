<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAR_0141.jsp
*@FileTitle  : Account Type Code Popup
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
<%@ page import="com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.event.StmSar0141Event"%>
<%@ page import="org.apache.log4j.Logger" %>


<%
    StmSar0141Event event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String strUsr_id      = "";
	String strUsr_nm      = "";
	Logger log = Logger.getLogger("com.clt.apps.opus.stm.sar.accountreceivablecommon.AccountReceivableCommonSC"); //error nessage

	String acctCntn1 = request.getParameter("acct_ctnt1") != null ? request.getParameter("acct_ctnt1") : "";
	String acctCntn2 = request.getParameter("acct_ctnt2") != null ? request.getParameter("acct_ctnt2") : "";
	String acctCntn3 = request.getParameter("acct_ctnt3") != null ? request.getParameter("acct_ctnt3") : "";
	String acctCntn4 = request.getParameter("acct_ctnt4") != null ? request.getParameter("acct_ctnt4") : "";
	String acctTpCd = request.getParameter("acct_tp_cd") != null ? request.getParameter("acct_tp_cd") : "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (StmSar0141Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

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


<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Account Type Code</span></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
			--><button class="btn_normal" name="btn_ok" id="btn_ok" type="button">OK</button><!--
			--><button class="btn_normal" name="btn_close" id="btn_close" type="button">Close</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
	</div>
	<!-- page_title_area(E) -->
</div>

<div class="layer_popup_contents">
	<div class="wrap_result">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry">
			<table>
				<colgroup>
					<col width="80" />				
					<col width="*" />				
			   </colgroup> 
			   <tbody>
			   		<tr>
			   			 <th>Account Type</th>
	                     <td><input type="text" dataformat="engup" otherchar="-" name="f_acct_tp_cd" id="f_acct_tp_cd" style="width:120px;" class="input" value="<%=acctTpCd%>"></td>
			   		</tr>
			   </tbody>
			</table>
		</div>
		<div class="opus_design_inquiry"><table class="line_bluedot"><tr><td></td></tr></table></div>
		<!-- opus_design_inquiry(E) -->
		
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet1');</script>		
		</div>
		<!-- opus_design_grid(E) -->
	</div>
</div>
<input type="hidden" name="f_acct_ctnt1" value="<%=acctCntn1%>">
<input type="hidden" name="f_acct_ctnt2" value="<%=acctCntn2%>">
<input type="hidden" name="f_acct_ctnt3" value="<%=acctCntn3%>">
<input type="hidden" name="f_acct_ctnt4" value="<%=acctCntn4%>">
</form>

<%@include file="/bizcommon/include/common_opus.jsp"%>	