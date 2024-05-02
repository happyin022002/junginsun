<%
/*=========================================================
*Copyright(c) 2015 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SCO_0500.jsp
*@FileTitle  : SAKURA Interface Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2015/11/12
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%--<%@ page import="com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.event.StmSar2002Event"   %> --%>
<%@ page import="com.clt.apps.opus.stm.sco.statementcommon.statementcommon.event.StmSco0500Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.bizcommon.util.BizComUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.OfficeCodeMgr"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>

<%
	//StmSar9998Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//DB ResultSet Count of list
	String pageRows  	    = "1000";			//paging - how many rows are showed for one page.
	
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";
	List<String> rhqOfcList = null;
	//Logger log = Logger.getLogger("com.clt.apps.opus.stm.sar.accountreceivablecollect.AccountReceivableCollectSC");
	//Logger log = Logger.getLogger("com.clt.apps.opus.stm.sar.accountreceivablecommon.AccountReceivableCommonSC");
	Logger log = Logger.getLogger("com.clt.apps.opus.stm.sco.statementcommon.StatementCommonSC");
	
	String sysCurrdate = JSPUtil.getKST("yyyy-MM-dd");
	String sysStartDate = JSPUtil.getKST("yyyy-MM") + "-01";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();

		//event = (StmSar9998Event)request.getAttribute("Event");
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
		if (errMessage.lengupth >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows"  id="pagerows" value="<%=pageRows%>">
<input type="hidden" name="iPage"> 
<input type="hidden" name="cust_cnt_cd" id="cust_cnt_cd" />
<input type="hidden" name="cust_seq" id="cust_seq" />
<!-- <input type="hidden" name="bank_ctrl_cd" id="bank_ctrl_cd" /> -->
<!--<input type="hidden" name="bank_acct_seq" id="bank_acct_seq" /> -->
<input type="hidden" name="selOfcCds" id="selOfcCds" />
<input type="hidden" name="rct_ofc_cd" id="rct_ofc_cd" />
<input type="hidden" name="rct_dt_fm" value="" id="rct_dt_fm" />
<input type="hidden" name="rct_dt_to" value="" id="rct_dt_to" />
<input type="hidden" name="rct_dps_dt_fm" value="" id="rct_dps_dt_fm" />
<input type="hidden" name="rct_dps_dt_to" value="" id="rct_dps_dt_to" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2> 
	<!--<h2 class="page_title"><button type="button">SAKURA Interface Inquiry（STM_SCO_0500）</span></button></h2>-->
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button><!--
		--><button class="btn_normal" name="btn_downexcel" id="btn_downexcel" type="button">Down Excel</button><!--
		--></div>
	<!-- opus_design_btn (E) -->
	
  	<!-- page_location(S) -->
  	
	<div class="location">	
		<span id="navigation"></span>
	</div>	
	
	<!-- page_location(E) -->
	
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table>
			<colgroup>
				<col width="100" />				
				<col width="250" />				
				<col width="100" />				
				<col width="250" />		
				<col width="150" />						
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
		   			<th>Posting Date</th>
	                <td><input type="text" style="width:80px;" class="input1" name="pst_dt_fm"  required dataformat="ymd" maxlength="8"  caption="Start Date" id="pst_dt_fm" cofield="pst_dt_to" /><!-- 
	                 --><button type="button" id="btn_cal_pst_dt_fm" name="btn_cal_pst_dt_fm" class="calendar ir"></button>~&nbsp;<!-- 
	                  --><input type="text" style="width:80px;" class="input1" name="pst_dt_to" required dataformat="ymd" maxlength="8"  caption="End Date" id="pst_dt_to" cofield="pst_dt_fm"/><!-- 
	                   --><button type="button" id="btn_cal_pst_dt_to" name="btn_cal_pst_dt_to" class="calendar ir"></button></td>	   			
		   			
		   			<th>I/F Date</th>
	                <td><input type="text" style="width:80px;" class="input1" name="if_dt_fm" required dataformat="ymd" maxlength="8"  caption="Start Date" id="if_dt_fm" cofield="if_dt_to"/><!-- 
	                 --><button type="button" id="btn_cal_if_dt_fm" name="btn_cal_if_dt_fm" class="calendar ir"></button>~&nbsp;<!-- 
	                  --><input type="text" style="width:80px;" class="input1" name="if_dt_to" required dataformat="ymd" maxlength="8"  caption="End Date" id="if_dt_to" cofield="if_dt_fm"/><!-- 
	                   --><button type="button" id="btn_cal_if_dt_to" name="btn_cal_if_dt_to" class="calendar ir"></button></td>		 
		   			
	                <th>Assignment No.</th>
	                <td><input type="text" style="width:140px;" class="input" name="asgn_no" value="" dataformat="engup" maxlength='18' id="asgn_no" /> </td>	                
	                
		   		</tr>
		   </tbody>
		</table>
		<div class="line_bluedot"></div>
		<table>
			<colgroup>
				<col width="100" />				
				<col width="190" />				
				<col width="100" />				
				<col width="170" />				
				<col width="100" />
				<col width="170" />
				<col width="100" />
				<col width="*" />					
		   </colgroup> 
		   <tbody>
		   		<tr>
		   			<th>Ref Doc No.</th>
	                <td><input type="text" style="width:130px;" class="input" name="ref_doc_no" value="" dataformat="engup" maxlength='16' id="ref_doc_no" /> </td>
	                <th>Doc Type</th>
	                <td><script type="text/javascript">ComComboObject('if_doc_tp_cd', 2, 100, 1, 0);</script></td>
	                <th>I/F Flag</th>
	                <td><select name="if_flg" id="if_flg" class="input" style="width:100px;">
	                    <option value="">All </option>
	                    <option value="Y">Yes </option>
	                    <option value="N">No </option>
	                  </select></td>
	                <th>Module</th>
	                <td><select name="module" id="module" class="input" style="width:100px;">
	                    <option value="">All </option>
	                    <option value="AR">A/R </option>
	                    <option value="AP">A/P </option>
	                  </select></td>
		   		</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" >
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
</div>

</form>

<%@include file="/bizcommon/include/common_opus.jsp"%>