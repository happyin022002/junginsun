<%@page import="com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.event.StmSar3004Event"%>
<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAR_3004.jsp
*@FileTitle  : Adjust View Accounting
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
<%@ page import="org.apache.log4j.Logger" %>

<%
   StmSar3004Event event = null;               //PDTO(Data Transfer Object including Parameters)
   Exception serverException = null;           //서버에서 발생한 에러
   String strErrMsg = "";                      //에러메세지
   String strUsr_id = "";
   String strUsr_nm = "";
   String strUsr_ofc_cd = "";
   Logger log = Logger.getLogger("com.clt.apps.opus.stm.sar.accountreceivableoutstanding.AccountReceivableOutstandingSC");
   try {
       SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
       strUsr_id = account.getUsr_id();
       strUsr_nm = account.getUsr_nm();
       strUsr_ofc_cd = account.getOfc_cd();
       event = (StmSar3004Event)request.getAttribute("Event");
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
   $("body.body_main").css("overflow-y","hidden"); 
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="action_type" value="<%=event.getAdjViewAccountingListVO().getActionType()%>" id="action_type" />
<input type="hidden" name="pagerows" id="pagerows" />

<!-- page_title_area(S) -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span id="title"></span></h2>
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

<div class="layer_popup_contents">
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="90" />				
					<col width="180" />				
					<col width="50" />				
					<col width="*" />				
			   </colgroup> 
			   <tbody>
			   		<tr>
			   			 <td><b><span id="key_title"></span></b></td>
	                     <td><input type="text" value="<%=event.getAdjViewAccountingListVO().getAdjNo()%>" name="adj_no" id="adj_no" readonly="readonly" style="width:150px;text-align: center;" class="input2"></td>
	                     <td><b>Office<b></b></td>
	                     <td><input type="text" value="<%=event.getAdjViewAccountingListVO().getOtsOfcCd()%>" name="ots_ofc_cd" id="ots_ofc_cd" readonly="readonly" style="width:50px;text-align: center;" class="input2"></td>
			   		</tr>
			   </tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet1');</script>		
		</div>
		<!-- opus_design_grid(E) -->
	</div>
</div>
</form>
