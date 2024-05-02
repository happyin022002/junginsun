<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAP_0080.jsp
*@FileTitle  : Bank Branch
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
<%-- <%@ page import="com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.event.StmSap0080Event"%> --%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.bizcommon.util.BizComUtil"%>

<%
//     StmSap0080Event event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.opus.stm.sap.accountpayablecommon.AccountPayableCommonSC");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

// 		event = (StmSap0080Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

	} catch(Exception ex) {
		log.error("err " + ex.toString(), ex);
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
<input type="hidden" name="bank_brnc_seq" id="bank_brnc_seq" />


<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button><!--
		--><button class="btn_normal" name="btn_save" id="btn_save" type="button">Save</button><!--
		--></div>
	<!-- opus_design_btn (E) -->
	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table>
            <colgroup>
	            <col width="100"/>
  				<col width="220"/>
  				<col width="100"/>
  				<col width="220"/>
  				<col width="100"/>
  				<col width="*"/>
            </colgroup>
            <tbody>
             <tr>
                 <th>Bank Branch Name</th>
                 <td colspan="5"><input type="text" style="width:100px;" name="sch_bank_brnc_nm" class="input2" readonly value="" caption="Bank Branch Name" id="sch_bank_brnc_nm" /><button type="button" id="btn_bank_brnc_nm" name="btn_bank_brnc_nm" class="input_seach_btn"></button></td>
             </tr>
             <tr class="line_bluedot" style="height:18px;"><td colspan="6"></td></tr>
             <tr><td colspan="6"><h3 class="title_design">Bank Information</h3></td></tr>
             <tr>
                  <th>Bank Name </th>
                  <td><input type="text" required name="bank_nm" style="width:200px;" class="input1" value="" maxlength="50" caption="Bank Name" id="bank_nm" /> </td>
                  <th>ALT Bank Name</th>
                  <td><input type="text" required name="bank_altn_nm" style="width:200px;" class="input1" value="" maxlength="100" caption="ALT Bank Name" id="bank_altn_nm" /> </td>
                  <th>Bank Number</th>
                  <td><input type="text" required name="bank_no" dataformat="engup" style="width: 110px;" class="input1" value="" maxlength="30" caption="Bank Number" id="bank_no" /> </td>
                  
              </tr>
              <tr class="line_bluedot" style="height:18px;"><td colspan="6"></td></tr>
               <tr><td colspan="6"><h3 class="title_design">Branch Information</h3></td></tr>
	                <tr>
	                   <th>Branch Name </th>
	                   <td><input type="text" required name="bank_brnc_nm" style="width:200px;" class="input1" value="" maxlength="50" caption="Branch Name" id="bank_brnc_nm" /> </td>
	                   <th>ALT Branch Name</th>
	                   <td><input type="text" required name="bank_brnc_altn_nm" style="width:200px;" class="input1" value="" maxlength="100" caption="ALT Branch Name" id="bank_brnc_altn_nm" /> </td>
	                   <th>Branch Number</th>
	                   <td><input type="text" required name="brnc_no" dataformat="engup" style="width: 110px;" maxlength="25" class="input1" value="" caption="Branch Number" id="brnc_no" /> </td>
	               </tr>
	               <tr>
	                   <th>Branch Type </th>
	                   <td colspan="3"><script type="text/javascript">ComComboObject('bank_brnc_tp_nm', 1, 100, 1, 1,0,false,1);</script></td>
	                   <th>Inactive On</th>
	               	   <td><input type="text" style="width:80px;" class="input" name="bank_end_dt" maxlength="20" dataformat="ymd" id="bank_end_dt" /><button type="button" id="btn_cal" name="btn_cal" class="calendar ir"></button></td>
	               	   
	               </tr>
	               <tr>
	                   <th> Description</th>
	                   <td colspan="5"><input type="text" required name="bank_brnc_desc" style="width:768px;" class="input1" value="" maxlength="500" caption="Description" id="bank_brnc_desc" /> </td>
	                
	               </tr>               
	               <tr>
	                   <th>Country </th>
	                   <td><input type="text" name="brnc_cnt_cd" style="width:50px;" class="input2"  dataformat="engup" readonly maxlength="2" readonly value="" caption="Country" id="brnc_cnt_cd" /><button type="button" class="input_seach_btn" id="btn_cnt" name="btn_cnt"></button><input type="text" name="brnc_cnt_nm" name="brnc_cnt_nm" style="width:150;" class="input2" readonly value=""></td>
	                   <th>Address</th>
	                   <td colspan="3"><input type="text" name="bank_addr1" required style="width:431px;" class="input1" value="" maxlength="200" caption="Address" id="bank_addr1" /> </td>
	               </tr>
               <tr class="line_bluedot" style="height:18px;"><td colspan="6"></td></tr>
               <tr><td colspan="6"><h3 class="title_design">Contact Information</h3></td></tr>
       	 	 <tr>
                   <th>Name</th>
                   <td><input type="text" name="cntc_nm" style="width:200px;" maxlength="100" class="input" value="" id="cntc_nm" /> </td>
                   <th>Title</th>
                   <td><input type="text" name="cntc_tit_nm" style="width:200px;" maxlength="30" class="input" value="" id="cntc_tit_nm" /> </td>
                   <th>Prefix</th>
                   <td>
	                    <select name="cntc_pfx_cd"  id="cntc_pfx_cd" class="input" style="width:110px ">
		                      <option value=""></option>
		                      <option value="Mr.">Mr.</option>
		                      <option value="Ms.">Ms.</option>
	                    </select>
                   </td>
           	  </tr>
          	  <tr>
                  <th>Phone</th>
                  <td><input type="text" name="cntc_phn_no" style="width:200px;" class="input" maxlength="20" value="" id="cntc_phn_no" /></td>
                  <th>E-mail</th>
                  <td colspan="3"><input type="text" name="cntc_eml" style="width:200px;" class="input" maxlength="50" value="" id="cntc_eml" /></td>
                  
          	  </tr>
          	 </tbody>
          </table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result" style="display: none;">
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet');</script>
	</div>
</div>	

</form>