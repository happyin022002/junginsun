<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAR_1003.jsp
*@FileTitle  : Outstanding history Inquiry by Date 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/07
=========================================================*/
%>
<%@page import="com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.event.StmSar1003Event"%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>


<%

   StmSar1003Event event = null;               //PDTO(Data Transfer Object including Parameters)
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


       event = (StmSar1003Event)request.getAttribute("Event");
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
<input type="hidden" name="rhq_cd" value="<%=event.getOutstandingHisByDateVO().getRhqCd()%>" id="rhq_cd" />

	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><span>Outstanding history Inquiry by Date</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_search" 	id="btn_search">Retrieve</button><!--
			--><button type="button" class="btn_normal" name="btn_excel" id="btn_excel">Down Excel</button><!--
			--><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button><!--
		--></div>
		<!-- opus_design_btn(E) -->
		<!-- page_location(S) -->
		<div class="location">
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->
	</div>
	<!-- page_title_area(E) -->

	<div class= "wrap_search">
		<div class= "opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="60" />
					<col width="120" />
					<col width="70" />
					<col width="130" />
					<col width="50" />
					<col width="140" />
					<col width="45" />
					<col width="*" />
				</colgroup>
				<tbody>
                    <tr>
                      <th>Date Option</th>
                      <td colspan="2"><input type="radio" name="cond_gl_if" id="cond_gl_if1" value="G" class="trans" checked="checked"><label for="cond_gl_if1">G/L Date</label><input type="radio" name="cond_gl_if" id="cond_gl_if2" value="I" class="trans"><label for="cond_gl_if2">I/F Date</label><!-- 
		                     --></td>
		              <td><input type="text" name="cond_dt" style="width:100px;" class="input" dataformat="ymd" caption="Date Option" id="cond_dt" /><!-- 
	                         --><button type="button" id="btn_cond_dt" name="btn_cond_dt" class="calendar ir"></button></td>       
                        <th>CUR</th>
                        <td colspan="3"><script type="text/javascript">ComComboObject('curr_cd', 1, 80, 0, 0);</script></td>
                    </tr>
                    <tr>
                      <th>B/L No</th>
                      <td><input type="text" value="<%=event.getOutstandingHisByDateVO().getBlNo()%>" name="bl_no" readonly="readonly" style="width:100px;" class="input2" id="bl_no" /> </td>
                      <th>Invoice No</th>
                      <td><input type="text" value="<%=event.getOutstandingHisByDateVO().getInvNo()%>" name="inv_no" readonly="readonly" style="width:100px;" class="input2" id="inv_no" /> </td>
                      <th>BKG No</th>
                      <td><input type="text" value="<%=event.getOutstandingHisByDateVO().getBkgNo()%>" name="bkg_no" readonly="readonly" style="width:100px;" class="input2" id="bkg_no" /> </td>
                      <th>Office</th>
                      <td><input type="text" value="<%=event.getOutstandingHisByDateVO().getOtsOfcCd()%>" name="ots_ofc_cd" readonly="readonly" style="width:100px;" class="input2" id="ots_ofc_cd" /> </td>
                    </tr>
				</tbody>
			</table>
		</div>
	</div>		
	<!-- opus_design_grid(S) -->	
	<div class="wrap_result">
		<div class="opus_design_grid clear">
				<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
	<!-- opus_design_grid(E) -->

</form>