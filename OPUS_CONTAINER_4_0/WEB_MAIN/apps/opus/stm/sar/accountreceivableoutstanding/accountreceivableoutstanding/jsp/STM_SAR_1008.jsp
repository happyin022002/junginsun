<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAR_1008.jsp
*@FileTitle  : Outstanding View Accounting
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/06
=========================================================*/
%>
<%@page import="com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.event.StmSar1008Event"%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>


<%

   StmSar1008Event event = null;               //PDTO(Data Transfer Object including Parameters)
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


       event = (StmSar1008Event)request.getAttribute("Event");
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
<!-- page_title_area(S) -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><span>Outstanding View Accounting</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!-- 
			 --><button type="button" class="btn_normal" name="btn_excel" 	id="btn_excel">Down Excel</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_close" 	id="btn_close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->
	
		<!-- page_location(S) -->
		<div class="location">
			<!-- location 내용 동적생성 (별도 코딩 불필요) -->
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->
	</div>
</div>
<!-- page_title_area(E) -->

<div class="layer_popup_contents" style="overflow:hidden">
	<div class="wrap_result">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry">
			<table>
				<colgroup>
					<col width="40">
					<col width="120">
					<col width="40">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
					<% if("BL".equals(event.getOtsViewAccountingListVO().getOtsSmryCd())) { %>
						<th>B/L No</th>
                        <td><input type="text" value="<%=event.getOtsViewAccountingListVO().getBlNo()%>" name="bl_no" readonly="readonly" style="width:100px;text-align: center;" class="input2" id="bl_no" /><input type="hidden" name="inv_no" id="inv_no" value="<%=event.getOtsViewAccountingListVO().getInvNo()%>" /></td>
					<% } else { %> 
						<th>Invoice No</th>
                        <td><input type="text" value="<%=event.getOtsViewAccountingListVO().getInvNo()%>" name="inv_no" readonly="readonly" style="width:100px;text-align: center;" class="input2" id="inv_no" /><input type="hidden" name="bl_no" id="bl_no" value="<%=event.getOtsViewAccountingListVO().getBlNo()%>" /></td>
					<% } %>  						
                        <th>Office</th>
                        <td><input type="text" value="<%=event.getOtsViewAccountingListVO().getOtsOfcCd()%>" name="ots_ofc_cd" readonly="readonly" style="width:50px;text-align: center;" class="input2" id="ots_ofc_cd" /></td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid(S) -->
	</div>
</div>
</form>