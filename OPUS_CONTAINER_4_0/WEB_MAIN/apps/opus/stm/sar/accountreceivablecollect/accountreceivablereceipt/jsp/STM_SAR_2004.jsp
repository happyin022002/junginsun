<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAR_2004.jsp
*@FileTitle  : Office Code
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.event.StmSar2004Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.bizcommon.util.BizComUtil"%>


<%
	StmSar2004Event event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	
	String strUsr_id = "";
	String strUsr_nm = "";
	
	String fmRctDt = "";
	String toRctDt = "";
	String fmRctDpsDt = "";
	String toRctDpsDt = "";
	
	Logger log = Logger.getLogger("com.clt.apps.opus.stm.sar.accountreceivablecollect.AccountReceivableCollectSC");
		
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
		event = (StmSar2004Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		/*
		fmRctDt 	= request.getParameter("fm_rct_dt");
		toRctDt 	= request.getParameter("to_rct_dt");
		fmRctDpsDt 	= request.getParameter("fm_rct_dps_dt");
		toRctDpsDt 	= request.getParameter("to_rct_dps_dt");

		
		fmRctDt 	= fmRctDt==null?"":fmRctDt;
		toRctDt 	= toRctDt==null?"":toRctDt;
		fmRctDpsDt 	= fmRctDpsDt==null?"":fmRctDpsDt;
		toRctDpsDt 	= toRctDpsDt==null?"":toRctDpsDt;
		*/
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
				
	} catch(Exception ex) {
		log.error("err " + ex.toString(), ex);
		//out.println(e.toString());
	}
%>

<script type="text/javascript">
 
    <%=BizComUtil.getIBCodeCombo("curr", "", "CURR", 2, "0: : ")%>

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
<input type="hidden" name="zzz" value="<%=fmRctDt%>" id="zzz" />
<input type="hidden" name="bank_ctrl_cd" id="bank_ctrl_cd" />
<input type="hidden" name="bank_acct_seq" id="bank_acct_seq" />
<input type="hidden" name="selOfcCds" id="selOfcCds" />
<input type="hidden" name="rct_ofc_cd" id="rct_ofc_cd" />
<input type="hidden" name="rct_dps_dt_fm" value="" id="rct_dps_dt_fm" />
<input type="hidden" name="rct_dps_dt_to" value="" id="rct_dps_dt_to" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button><!--
		--><button class="btn_normal" name="btn_downexcel" id="btn_downexcel" type="button">Down Excel</button>
	</div>
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
				<col width="65">
				<col width="130">
				<col width="35">
				<col width="265">
				<col width="85">
				<col width="115">
				<col width="50">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
                	<th height="25">Date Type</th>
                	<td><select name="rct_dt_tp_cd" id="rct_dt_tp_cd" class="input1" style="width:100px;">
                    		<option  value="RECEIPT">Receipt </option>
                    		<option  value="DEPOSIT">Deposit</option>
                  		</select>
                  	</td>
                <th>Date</th>
                <td>
                	<input type="text" style="width:80px;" class="input1" value=" " name="rct_dt_fm" id="rct_dt_fm" dataformat="ymd" maxlength="8" cofield="rct_dt_to" caption="Start Date"><!--  
                	--><button type="button" class="calendar" name="btns_calRecFr" id="btns_calRecFr"></button><span class="dash">~</span><!--  
                	--><input type="text" style="width:80px;" class="input1" value=" "  name="rct_dt_to" id="rct_dt_to" dataformat="ymd" maxlength="8" cofield="rct_dt_fm" caption="End Date"><!--  
                	--><button type="button" class="calendar" name="btns_calRecTo" id="btns_calRecTo"></button>
                 <th>Currency</th>
                <td><script type="text/javascript">ComComboObject('rct_curr_cd', 1, 70, 0, 0, 0, false, 1);</script></td>
                <th>Office</th>
                <td><input type="text" style="width:80px;" class="input1" name="rct_ofc_cd1" readonly tabindex="-1"><!--  
                	--><button type="button" class="input_seach_btn" name="btn_multi_office_popup" id="btn_multi_office_popup"></button>
                </td>
              </tr>
			</tbody>
		</table>
	</div>
	<div class="line_bluedot"></div>
	<div class="opus_design_inquiry">
		<table>
			<colgroup>
				<col width="65">
				<col width="138">
				<col width="85">
				<col width="207">
				<col width="85">
				<col width="115">
				<col width="50">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
	               	<th height="25" >Status</th>
	               	<td><select name="rct_sts_cd" id="rct_sts_cd" class="input" style="width:100px;">
	                   		<option value="ALL"> All </option>
	                   		<option value="RECEIPT"> Receipt </option>
	                  			<option value="CANCEL"> Cancel </option>
	                 		</select>
	                 	</td>
	               	<th>Bank</th>
	               	<td><input type="text" style="width:145px;" class="input" name="bank_acct_name" id="bank_acct_name" readonly tabindex="-1"><!--  
	               		--><button type="button" class="input_seach_btn" name="btns_bank" id="btns_bank"></button>
	               	</td>
	               	<th>Receipt Type</th>
	               	<td><script type="text/javascript">ComComboObject('rct_tp_cd', 1, 70, 1, 0);</script></td>
	               	<th>User ID</th>
	               	<td><input type="text" style="width:80px;" class="input" value=""  name="rct_usr_id" id="rct_usr_id" auth="R"><!--  
	               		--><button type="button" class="input_seach_btn" name="btns_search_usrid" id="btns_search_usrid"></button>
	               	</td>
	            	</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<div class="opus_design_inquiry"><h3 class="title_design">Summary By Date</h3></div>
	<div class="opus_Design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
<div class="wrap_result">
	<div class="opus_design_inquiry"><h3 class="title_design">Summary By Bank</h3></div>
	<div class="opus_Design_grid">
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
</div>
</form>
