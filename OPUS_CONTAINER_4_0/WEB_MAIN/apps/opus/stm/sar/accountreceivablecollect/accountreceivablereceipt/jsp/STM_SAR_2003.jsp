<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAR_2003.jsp
*@FileTitle  : Receipt Inquery BANK
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
<%@ page import="com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.event.StmSar2003Event"%> 
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.bizcommon.util.BizComUtil"%>


<%
	StmSar2003Event event = null;				//PDTO(Data Transfer Object including Parameters)
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
	   
		event = (StmSar2003Event)request.getAttribute("Event");
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
<input type="hidden" name="cust_cnt_cd" id="cust_cnt_cd" />
<input type="hidden" name="cust_seq" id="cust_seq" />
<input type="hidden" name="bank_ctrl_cd" id="bank_ctrl_cd" />
<input type="hidden" name="bank_acct_seq" id="bank_acct_seq" />
<input type="hidden" name="selOfcCds" id="selOfcCds" />
<input type="hidden" name="rct_ofc_cd" id="rct_ofc_cd" />
<input type="hidden" name="rct_dps_dt_fm" value="" id="rct_dps_dt_fm" />
<input type="hidden" name="rct_dps_dt_to" value="" id="rct_dps_dt_to" />

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
		 --><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
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
	<div class= "opus_design_inquiry">
	<table>
		<colgroup>
			<col width="70">
			<col width="170">
			<col width="100">
			<col width="310">
			<col width="90">
			<col width="*">
		</colgroup>
		<tbody>
			<tr>
	            <th>Date Type</th>
	            <td><select name="rct_dt_tp_cd" id="rct_dt_tp_cd" class="input1" style="width:100px">
	                <option  value="RECEIPT">Receipt </option>
	                <option  value="DEPOSIT">Deposit</option>
	              </select></td>
	            <th>Date</th>
	            <td><input type="text" style="width:80px;" class="input1" value=" " name="rct_dt_fm" dataformat="ymd" maxlength="8" cofield="rct_dt_to" caption="Start Date" id="rct_dt_fm" /><!-- 
	               --><button type="button" id="btns_calRecFr" name="btns_calRecFr" class="calendar ir"></button>~&nbsp;<!-- 
	               --><input type="text" style="width:80px;" class="input1" value=" " name="rct_dt_to" dataformat="ymd" maxlength="8" cofield="rct_dt_fm" caption="End Date" id="rct_dt_to" /><!-- 
	               --><button type="button" id="btns_calRecTo" name="btns_calRecTo" class="calendar ir"></button>
	            <th>Office</th>
	            <td><input type="text" style="width:100px;" class="input1" name="rct_ofc_cd1" readonly="" tabindex="-1" id="rct_ofc_cd1" /><button type="button" id="btn_multi_office_popup" name="btn_multi_office_popup" class="input_seach_btn"></button></td>
			</tr>
	   	</tbody>
   	</table>
    <div class="line_bluedot"></div>
   	<table>
		<colgroup>
			<col width="70">
			<col width="250">
			<col width="100">
			<col width="160">
			<col width="82">
			<col width="70">
			<col width="*">
		</colgroup>
		<tbody>	
		<tr>
            <th>Type 1</th>
            <td><select name="rct_sts_cd" id="rct_sts_cd" class="input" style="width:100px">
                <option value="ALL"> All </option>
                <option value="RECEIPT"> Receipt </option>
                <option value="CANCEL"> Cancel </option>
              </select></td>
            <th>Type 2</th>
            <td><select name="rct_unpay_sts_flg" id="rct_unpay_sts_flg" class="input" style="width:160px">
                <option value="ALL">All </option>
                <option value="UNAPP">Unapplied/Unidentified</option>
              </select></td>
            <td></td>
            <th>Customer</th>
            <td><input type="text" style="width:30px;" class="input" name="rct_cust_cnt_cd" maxlength="2" dataformat="engup" id="rct_cust_cnt_cd" /><input type="text" style="width:66px;" class="input" name="rct_cust_seq" maxlength="6" dataformat="num" id="rct_cust_seq" /><button type="button" id="btns_cust_info" name="btns_cust_info" class="input_seach_btn"></button><input type="text" style="width:239px;" class="input2" name="rct_cust_nm" readonly tabindex="-1" id="rct_cust_nm" /><button type="button" id="btns_cust" name="btns_cust" class="input_seach_btn"></button></td>
		</tr>
		</tbody>
   	</table>
   	<table>
		<colgroup>
			<col width="70">
			<col width="250">
			<col width="100">
			<col width="190">
			<col width="130">
			<col width="210">
			<col width="*">
		</colgroup>
		<tbody>	
			<tr>
	            <th>Bank</th>
	            <td><input type="text" style="width:180px;" class="input" name="bank_acct_name" readonly tabindex="-1" id="bank_acct_name" /><button type="button" id="btns_bank" name="btns_bank" class="input_seach_btn"></button></td>
	            <th>Cancel Reason</th>
	            <td><script type="text/javascript">ComComboObject('rct_cxl_rsn_cd', 2, 100, 1, 0);</script></td>
	            <th>User ID</th>
	            <td><input type="text" style="width:100px;" class="input" value="" name="rct_usr_id" auth="R" id="rct_usr_id" /><button type="button" id="btns_search_usrid" name="btns_search_usrid" class="input_seach_btn"></button></td>
	            <td><b>Receipt Type</b> <script type="text/javascript">ComComboObject('rct_tp_cd', 1, 84, 1, 0);</script></td>
			</tr>
		</tbody>
   	</table>
   	<table>
		<colgroup>
			<col width="70">
			<col width="250">
			<col width="100">
			<col width="150">
			<col width="163">
			<col width="*">
		</colgroup>
		<tbody>	
			<tr>
	            <th>Cheque No</th>
	            <td><input type="text" style="width:140px;" class="input" value="" name="chq_no" maxlength="17" dataformat="engup" id="chq_no" /> </td>
	            <th>Receipt No</th>
	            <td><input type="text" style="width:150px;" class="input" value="" name="rct_no" maxlength="20" dataformat="engup" id="rct_no" /> </td>
	            <th>ASA No</th>
	            <td><input type="text" style="width:129px;" class="input" value="" name="asa_no" dataformat="engup" id="asa_no" /> </td>
	          </tr>
     	</tbody>
	</table>
  </div>
</div>      
<!-- opus_design_inquiry(E) -->
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
</form>  
 