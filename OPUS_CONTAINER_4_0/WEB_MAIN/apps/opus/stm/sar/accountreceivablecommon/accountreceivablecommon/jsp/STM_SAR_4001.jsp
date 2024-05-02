<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAR_4001.jsp
*@FileTitle  : Account Matrix
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/06
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.event.StmSar4001Event"%>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.OfficeCodeMgr"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List"%>

<%
    StmSar4001Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//DB ResultSet Count of list

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";	
	String acctTpCd         = "";

	Logger log = Logger.getLogger("com.clt.apps.opus.stm.sar.accountreceivablecommon.AccountReceivableCommonSC");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();

		event = (StmSar4001Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// in loading page, Get data from server
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
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="f_dup_chk" id="f_dup_chk" />
<input type="hidden" name="f_dup_acct_ctnt1" id="f_dup_acct_ctnt1" />
<input type="hidden" name="f_dup_acct_ctnt2" id="f_dup_acct_ctnt2" />
<input type="hidden" name="f_dup_acct_ctnt3" id="f_dup_acct_ctnt3" />
<input type="hidden" name="f_dup_acct_ctnt4" id="f_dup_acct_ctnt4" />
<input type="hidden" name="f_dup_acct_tp_cd" id="f_dup_acct_tp_cd" />
<input type="hidden" name="pagerows" id="pagerows" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
	<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
	--><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button><!--
	--><button class="btn_normal" name="btn_save" id="btn_save" type="button">Save</button><!--
	--></div>
	<!-- opus_design_btn (E) -->
	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->
<!-- wrap_search(S) -->
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="70" />				
				<col width="100" />				
				<col width="80" />				
				<col width="110" />				
				<col width="80" />
				<col width="110" />
				<col width="80" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
	                <th>Account Content1</th>
	                <td><script type="text/javascript">ComComboObject('f_acct_ctnt1', 2, 100, 1, 0, 0,false,1);</script></td>
	                <th>Account Content2</th>
	                <td><script type="text/javascript">ComComboObject('f_acct_ctnt2', 2, 100, 1, 0, 0,false,1);</script></td>
	                <th>Account Content3</th>
	                <td><script type="text/javascript">ComComboObject('f_acct_ctnt3', 2, 100, 1, 0, 0,false,1);</script></td>
	                <th>Account Content4</th>
	                <td><script type="text/javascript">ComComboObject('f_acct_ctnt4', 2, 100, 1, 0, 0,false,1);</script></td>
               </tr>
               <tr>     
	                <th>Account Division</th>
	                <td><script type="text/javascript">ComComboObject('f_rev_acct_div_cd', 2, 100, 1, 0, 0,false,1);</script></td>
	                <th>Account Type</th>
	                <td><input type="text" style="width:100px;" class="input" name="f_acct_tp_cd" readonly value="<%=acctTpCd%>" id="f_acct_tp_cd" /><button type="button" id="btns_search_acct_type" name="btns_search_acct_type" class="input_seach_btn"></button></td>
	                <th>Delete</th>
	                <td><script type="text/javascript">ComComboObject('f_delt_flg', 1, 50, 1, 0, 0,false,1);</script></td>      
	                <th>AR Account</th>
	                <td><input type="text" style="width:100px;" class="input" name="f_ar_acct_cd" readonly value="" id="f_ar_acct_cd" /><button type="button" id="btns_search_ar_acct" name="btns_search_ar_acct" class="input_seach_btn"></button></td>
	           </tr>
		   </tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_search(E) -->
<!-- wrap_result(S) -->
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_add" id="btn_add" type="button">Row Add</button><!--
			--><button class="btn_normal" name="btn_del" id="btn_del" type="button">Row Delete</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(E) -->            
</form>
