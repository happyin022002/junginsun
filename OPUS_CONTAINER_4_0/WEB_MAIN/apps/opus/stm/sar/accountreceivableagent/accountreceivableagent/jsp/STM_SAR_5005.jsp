<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : stm_sar_5005.jsp
*@FileTitle  : Agent Collection Inquiry
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
<%@ page import="com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.event.StmSar5005Event"%> 
<%@ page import="org.apache.log4j.Logger" %>
<%
    StmSar5005Event event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			
	String strErrMsg = "";						

	String asa_no  = "";

	String strUsr_id = "";
	String strUsr_nm = "";
	String strUsr_ofc = "";
	Logger log = Logger.getLogger("com.clt.apps.opus.stm.sar.accountreceivableagent.AccountreceivableagentSC"); //?섏젙

	String glmonFm = JSPUtil.getKST("yyyy-MM-dd");
	String glmonTo = JSPUtil.getKST("yyyy-MM-dd");

	String duedtFm = ""; //JSPUtil.getKST("yyyy-MM-dd");
	String duedtTo = "";   //JSPUtil.getKST("yyyy-MM-dd");
	try {

	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();

		event = (StmSar5005Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		asa_no = request.getParameter("asa_no");
		asa_no = asa_no==null?"":asa_no;
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
		loadPage();  // .js 
	}

</script>

<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="ar_ofc_cd" id="ar_ofc_cd" />
<input type="hidden" name="curr_cd" id="curr_cd" /> 
<input type="hidden" name="dp_prcs_knt" id="dp_prcs_knt" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
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
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="60" />				
				<col width="190" />				
				<col width="70" />				
				<col width="250" />				
				<col width="70" />	
				<col width="150" />	
				<col width="70" />	
				<col width="90" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
		   			<th>Agent</th>
		            <td><script type="text/javascript">ComComboObject('agn_ofc_cd', 1, 80, 1, 1);</script></td>  
		            <th> A.S.A No</th>
		            <td><input name="asa_no1" type="text" class="input1" style="width:50px;" value="" dataformat="engup" maxlength="3" readonly id="asa_no1" />-&nbsp;<!--  
					    --><input name="asa_no2" type="text" class="input1" style="width:50px;" value="" dataformat="num" maxlength="3" readonly="" id="asa_no2" />-&nbsp;<!-- 
					    --><input name="asa_no3" type="text" class="input1" style="width:50px;" value="" dataformat="num" maxlength="4" readonly="" id="asa_no3" /><!-- 
		                --><button type="button" id="btn_pop_asa_cd" name="btn_pop_asa_cd" class="input_seach_btn"></button></td>
		             <th>Period</th>
		             <td><input name="gl_yrmon_fm" type="text" style="width:70px;" class="input2" value="" dataformat="ymd" maxlength="8" readonly id="gl_yrmon_fm" />-&nbsp;<!-- 
		                 --><input name="gl_yrmon_to" type="text" style="width:70px;" class="input2" value="" dataformat="ymd" maxlength="8" readonly="" id="gl_yrmon_to" />
		            <th>Currency</th>
		             <td><input name="asa_curr_cd" type="text" class="input2" style="width:50px;" value="" readonly id="asa_curr_cd" /> </td>
            		<td></td>
		   		</tr>
		   		<tr>
		             <th>Option1</th>
		             <td class="pad_left_8" colspan="2"><span style="font-weight:normal"><input type="radio" name="option1" value="ALL" class="trans" checked="" id="option11" /><label for="option11">All</label><input type="radio" name="option1" value="C" class="trans" checked="" id="option0" /><label for="option0">Collection</label><!-- 
		                   --><input type="radio" name="option1" value="R" class="trans" id="option12" /><label for="option12">Refund</label></span></td>
<!-- 
		             <th>Bound</th>
		             <td><select name="bnd" id="bnd" class="input1" style="width:85px;">
		                    <option value="ALL" selected>All</option>
							<option value="I">Inbound</option>
							<option value="O">Outbound</option>
		                  </select></td>
		             <th>SCP/Port</th>
		             <td><input name="svc_scp_cd" type="text" class="input" dataformat="engup" style="width:40px;" id="svc_scp_cd" />/&nbsp;<input name="port_cd" type="text" class="input" dataformat="engup" style="width:40px;" id="port_cd" /> </td>
		             <td></td>
		             <td></td>
		             <td></td>
-->
        		 </tr>
<%--
         		<tr>
		             <th>Option2</th>
		             <td class="pad_left_8"><span style="font-weight:normal"> 
		              <input type="radio" name="option2" value="D" class="trans" checked="checked" id="option3" onclick="change_event_radio2();"/><label for="option3">Due Date</label> 
		              <input type="radio" name="option2" value="V" class="trans" id="option4" onclick="change_event_radio2();"/><label for="option4">VVD</label></span></td>
		             <th>Due Date</th>
		             <td><input name="due_dt_fm" type="text" style="width:70px;" class="input" value="<%=duedtFm%>" dataformat="ymd" maxlength="8" id="due_dt_fm" /> 
		              <button type="button" id="btnCalduedtFm" name="btnCalduedtFm" class="calendar ir"></button>-&nbsp; 
		              <input name="due_dt_to" type="text" style="width:70px;" class="input" value="<%=duedtTo%>" dataformat="ymd" maxlength="8" id="due_dt_to" /> 
		              <button type="button" id="btnCalduedtTo" name="btnCalduedtTo" class="calendar ir"></button></td>
		             <th title="Vessel Voyage Direction">VVD</th>
		             <td><input name="vvd_cd" type="text" class="input" style="width:95px;" dataformat="engup" id="vvd_cd" /> </td>
			          <td></td>
			          <td></td>
			          <td></td>
		        </tr>
--%>
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

</form>

<%@include file="/bizcommon/include/common_alps.jsp"%>
