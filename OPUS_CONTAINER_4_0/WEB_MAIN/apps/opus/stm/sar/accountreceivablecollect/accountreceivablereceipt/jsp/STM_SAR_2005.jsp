<%@page import="com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.event.StmSar2005Event"%>
<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAR_2005.js
*@FileTitle  : Receipts View Accounting
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/02
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>


<%

   StmSar2005Event event = null;               //PDTO(Data Transfer Object including Parameters)
   Exception serverException = null;           //서버에서 발생한 에러
   String strErrMsg = "";                      //에러메세지
   
   String strUsr_id = "";
   String strUsr_nm = "";
   String strUsr_ofc_cd = "";
   Logger log = Logger.getLogger("com.clt.apps.opus.stm.sar.accountreceivablecollect.AccountReceivableCollectSC");
   
   try {
       SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
       strUsr_id = account.getUsr_id();
       strUsr_nm = account.getUsr_nm();
       strUsr_ofc_cd = account.getOfc_cd();
       
      
       event = (StmSar2005Event)request.getAttribute("Event");
       serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
       
       if (serverException != null) {
           strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
       }
      
       
   } catch(Exception ex) {
       log.error("err " + ex.toString(), ex);
   }
   
%>

<script type="text/javascript">

   var strUsr_id = "<%=strUsr_id%>";
   var strUsr_nm = "<%=strUsr_nm%>";
   var strUsr_ofc_cd = "<%=strUsr_ofc_cd%>";

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
<input type="hidden" name="ots_smry_cd" value="<%=event.getRctViewAccountingListVO().getOtsSmryCd() %>">
<!-- page_title_area(S) -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Receipts View Accounting</span></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_excel" id="btn_excel" type="button">Down Excel</button><!--
			--><button class="btn_normal" name="btn_close" id="btn_close" type="button">Close</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
	</div>
</div>
<!-- page_title_area(E) -->
<!-- wrap_search(S) -->
<div class="layer_popup_contents">
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="10" />
					<col width="100" />
					<col width="70" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
		              <th>Receipt No</th>
		              <td><input type="text" value="<%=event.getRctViewAccountingListVO().getRctNo()%>" name="rct_no" readonly="readonly" style="width:150px;text-align: center;" class="input2" id="rct_no" /></td>
		              <th>Office</th>
		              <td><input type="text" value="<%=event.getRctViewAccountingListVO().getRctOfcCd()%>" name="rct_ofc_cd" readonly="readonly" style="width: 70px;text-align: center;" class="input2" id="rct_ofc_cd" /></td>
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
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
</div>
<!-- wrap_result(E) -->   
</form>

