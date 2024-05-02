<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAP_0060.jsp
*@FileTitle  : Payments
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.event.StmSap0060Event"%>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.OfficeCodeMgr"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List"%>
<%@ page import="com.clt.bizcommon.util.BizComUtil"%>

<%
    StmSap0060Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//DB ResultSet Count of list

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";
	List<String> rhqOfcList = null;
	Logger log = Logger.getLogger("com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment");
	
	String sysCurrdate = JSPUtil.getKST("yyyyMMdd");	
		
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();
		
		event = (StmSap0060Event)request.getAttribute("Event");
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
	<%=BizComUtil.getIBCodeCombo("curr", "", "CURR", 2, "0: :ALL")%>
	<%=JSPUtil.getIBCodeCombo("proTp", "", "CD00888", 0, "")%>
	
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
<input type="hidden" name="hid_local_sysdate" id="hid_local_sysdate" />
<input type="hidden" name="hid_func_curr_cd" id="hid_func_curr_cd" />
<input type="hidden" name="hid_func_curr_prcs" id="hid_func_curr_prcs" />
<input type="hidden" name="hid_login_ap_ofc" id="hid_login_ap_ofc" />
<input type="hidden" name="hid_login_curr_cd" id="hid_login_curr_cd" />
<input type="hidden" name="hid_login_loc_cd" id="hid_login_loc_cd" />
<input type="hidden" name="hid_pay_seq" id="hid_pay_seq" />
<!-- Input Box for Report Designer -->
<input type="hidden" name="com_mrdPath" value="" id="com_mrdPath" />
<input type="hidden" name="com_mrdArguments" value="" id="com_mrdArguments" />
<input type="hidden" name="com_mrdTitle" value="Payment Slip" id="com_mrdTitle" />
<input type="hidden" name="com_mrdBodyTitle" value="Payment Slip" id="com_mrdBodyTitle" />
<input type="hidden" name="com_mrdSaveDialogFileExt" value="ppt" id="com_mrdSaveDialogFileExt" />
<input type="hidden" name="com_mrdSaveDialogFileExtLimit" value="xls@pdf@doc@ppt" id="com_mrdSaveDialogFileExtLimit" />
<input type="hidden" name="com_mrdSaveDialogFileName" value="Payment Slip" id="com_mrdSaveDialogFileName" />
<input type="hidden" name="com_mrdSaveDialogDir" value="" id="com_mrdSaveDialogDir" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_delete" id="btn_delete">Delete</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_print" id="btn_print">Print</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_void" id="btn_void">Void</button>
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<div class= "wrap_search">
<!-- opus_design_inquiry(S) -->
	<div class= "opus_design_inquiry wFit">
	<table>
		<colgroup>
			<col width="90"/>
			<col width="230"/>
			<col width="170"/>
			<col width="50"/>
			<col width="200"/>
			<col width="*" />
		</colgroup>
		<tbody>
		 <tr>
             <th>Office</th>
             <td><input type="text" style="width:80px;" class="input1" name="ofc_cd" dataformat="engup" maxlength="6" id="ofc_cd" /><button type="button" id="btns_search_ofc" name="btns_search_ofc" class="input_seach_btn"></button></td>
             <th>Pay Group</th>
             <td><input type="text" style="width:170px;" class="input" name="vndr_pay_grp_cd" maxlength="20" id="vndr_pay_grp_cd" /><button type="button" id="btns_search_paygroup" name="btns_search_paygroup" class="input_seach_btn"></button></td>
             <th>Batch Name</th>
             <td><input type="text" style="width:170px;" class="input" name="pay_bat_nm" maxlength="20" id="pay_bat_nm" /><button type="button" id="btns_search_batch" name="btns_search_batch" class="input_seach_btn"></button></td>
         </tr>
         <tr>
             <th>Payment Date</th>
             <td><input type="text" style="width:80px;" value="" name="fr_dt" dataformat="ymd" maxlength="10" class="input1" required cofield="to_dt" caption="start date" id="fr_dt" /><button type="button" id="btns_calFr" name="btns_calFr" class="calendar ir"></button>~ <input type="text" style="width:80px;" value="" name="to_dt" dataformat="ymd" maxlength="10" class="input1" required cofield="fr_dt" caption="end date" id="to_dt" /><button type="button" id="btns_calTo" name="btns_calTo" class="calendar ir"></button></td>
             <th>Payment Method</th>
             <td><input type="text" style="width:170px;" class="input" name="pay_mzd_lu_cd" maxlength="20" id="pay_mzd_lu_cd" /><button type="button" id="btns_search_doc" name="btns_search_doc" class="input_seach_btn"></button></td>
             <th>Supplier</th>
             <td><input type="text" style="width:170px;" class="input" name="vndr_nm" maxlength="20" id="vndr_nm" /><button type="button" id="btns_search_supplier" name="btns_search_supplier" class="input_seach_btn"></button></td>
         </tr>
         <tr>
             <th>Bank Account</th>
             <td><input type="text" style="width:170px;" class="input" name="bank_acct_nm" maxlength="20" id="bank_acct_nm" /><button type="button" id="btns_search_bankAccount" name="btns_search_bankAccount" class="input_seach_btn"></button></td>
             <th>Voucher No</th>
             <td><input type="text" style="width:170px;" class="input" name="doc_seq" maxlength="20" dataformat="engup" id="doc_seq" /></td>
         </tr>
     </table>
  </div>
</div>
<!-- opus_design_inquiry(E) -->
<div class="wrap_result">
<!-- opus_design_grid(S) -->
<div>	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear">
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		 <button type="button" class="btn_normal" name="btn_sheet1RowAdd" id="btn_sheet1RowAdd">Row Add</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_sheet1RowDelete" id="btn_sheet1RowDelete">Row Delete</button>
	</div>
	<!-- opus_design_btn(E) -->
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
<!-- opus_design_grid(E) -->                  
            
<div>	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear">
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		 <button type="button" class="btn_normal" name="btn_sheet2RowAdd" id="btn_sheet2RowAdd">Row Add</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_sheet2RowDelete" id="btn_sheet2RowDelete">Row Delete</button>
	</div>
	<!-- opus_design_btn(E) -->
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
</div>
<!-- opus_design_grid(E) -->               
</div>
</form>           
