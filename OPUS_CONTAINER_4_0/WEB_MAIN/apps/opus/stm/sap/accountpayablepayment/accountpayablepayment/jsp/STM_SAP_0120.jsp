<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAP_0120.jsp
*@FileTitle  : Bank Balance Adjustment
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.event.StmSap0120Event"%>
<%@ page import="org.apache.log4j.Logger" %>


<%
    StmSap0120Event event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	
	String strUsr_id  = "";
	String strUsr_nm  = "";
	String strUsr_ofc = "";
	Logger log = Logger.getLogger("com.clt.apps.opus.stm.sap.accountpayablepayment.AccountpayablepaymentSC");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id  = account.getUsr_id();
		strUsr_nm  = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();
	   
		event = (StmSap0120Event)request.getAttribute("Event");
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
<input type="hidden" name="lgin_usr_ap_ofc" id="lgin_usr_ap_ofc" />
<input type="hidden" name="lgin_usr_locl_tm" id="lgin_usr_locl_tm" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		 <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_new"  	id="btn_new">New</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_recalculate" 	id="btn_recalculate">Recalculate</button><!--
		 --><button type="button" class="btn_normal" name="btn_bankAccountInquiry"  	id="btn_bankAccountInquiry">Bank Account Inquiry</button>
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<h3 class="title_design">Balance Adjustment By Manual</h3>
		<table>
			<colgroup>
				<col width="80">
				<col width="210">
				<col width="140">
				<col width="200">
				<col width="80">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<td class="sm pad_left_8"><strong>Office</strong></td>
                    <td class="sm pad_left_8"><input type="radio" name="ctrl_ofc" value="AP" class="trans" checked id="ctrl_ofc0" /><label for="ctrl_ofc0">AP</label><!-- 
         				 --><input type="radio" name="ctrl_ofc" value="AR" class="trans" id="ctrl_ofc1" /><label for="ctrl_ofc1">AR</label><!-- 
         				 --><input type="radio" name="ctrl_ofc" value="ALL" class="trans" id="ctrl_ofc2" /><label for="ctrl_ofc2">All</label><!--  
         				 --><input type="text" style="width:70px;text-align:left;" class="input1" name="ofc_cd" dataformat="enguponly" maxlength="6" id="ofc_cd" /><!--  
         				 --><button type="button" name="btns_search_ofc" id="btns_search_ofc" class="input_seach_btn"></button></td>
          			<th>Inquiry Date</th>
                   	<td><input type="text" style="width:90px;text-align:left;" class="input1" name="bank_stmt_dt" dataformat="ymd" maxlength="10" id="bank_stmt_dt" /><!--  
                   		--><button type="button" id="btns_calStmtDt" name="btns_calStmtDt" class="calendar ir"></button></td>
                   	<th>Currency</th>
                   	<td><script type="text/javascript">ComComboObject('inv_curr_cd', 1, 70, 0, 0, 0, false, 1);</script></td>
				</tr>
				<tr>
					<th>Account Type(L)</th>
	                <td><script type="text/javascript">ComComboObject('bank_acct_tp_mn_cd', 2, 50, 0, 0, 0, false ,1);</script><!-- 
	                     --><input type="text" style="width:120px;" class="input2" name="bank_acct_tp_mn_desc" readonly id="bank_acct_tp_mn_desc" /></td>
	                <th>Account Type(M)</th>
	                <td><script type="text/javascript">ComComboObject('bank_acct_tp_sub_cd', 2, 50, 0, 0, 0, false ,1);</script><!-- 
	                     --><input type="text" style="width:120px;" class="input2" name="bank_acct_tp_sub_desc" readonly id="bank_acct_tp_sub_desc" /></td>   
	                <th>&nbsp;</th>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable">
		<h3 class="title_design mar_btm_8">Inquiry And Adjustment</h3>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(S) -->
</div>
</form>