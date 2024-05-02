<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAR_0241.jsp
*@FileTitle  : Offset AR Search Popup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/12
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.event.StmSar0241Event"%>
<%@ page import="com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.AROfficeListVO"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
    StmSar0241Event event = null;               //PDTO(Data Transfer Object including Parameters)
    Exception serverException = null;           //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지

    String strUsr_id = "";
    String strUsr_nm = "";
    Logger log = Logger.getLogger("com.clt.apps.opus.stm.sar.accountreceivablecollect.AccountReceivableCollectSC");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        event = (StmSar0241Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);        
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();            
        }

    } catch(Exception ex) {
        log.error("err " + ex.toString(), ex);
        //out.println(e.toString());
    }

    // required parameter
    String ofcCd = JSPUtil.getParameter(request, "ofc_cd", "");

    String otsSmryCdName = "B/L No";
    AROfficeListVO ofcVO = event.getArOfficeListVO();
    if ("INV".equals(ofcVO.getOtsSmryCd())) {
    	otsSmryCdName = "Invoice No";    
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
<!-- Login office  info -->
<input type="hidden" name="ots_smry_cd" value="<%=ofcVO.getOtsSmryCd()%>" id="ots_smry_cd" />
<input type="hidden" name="rhq_cd" value="<%=ofcVO.getRhqCd()%>" id="rhq_cd" />
<input type="hidden" name="ots_cd" value="<%=ofcVO.getOtsCd()%>" id="ots_cd" />
<input type="hidden" name="rep_ots_ofc_cd" value="<%=ofcVO.getRepOtsOfcCd()%>" id="rep_ots_ofc_cd" />
<input type="hidden" name="offst_curr_cd" value="<%=event.getOffsetARPopupListVO().getOffstCurrCd()%>" id="offst_curr_cd" />
<input type="hidden" name="cust_cnt_cd">
<input type="hidden" name="cust_seq">
<!-- page_title_area(S) -->
<div class="layer_popup_title">	
	<div class="page_title_area clear">

		<!-- page_title(S) -->
		<h2 class="page_title"><span>Offset AR Search</span></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" type="button" name="btn_searchlist" id="btn_searchlist">Retrieve</button><!--
			--><button class="btn_normal" type="button" name="btn_OK" id="btn_OK" >Select</button><!--
			--><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>	</div>
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
					<col width="60">				
					<col width="870">				
					<col width="70">				
					<col width="*">				
			   </colgroup>
			   <tbody>
					<tr>
						<th>Customer</th>
	                    <td>
	                    <input id="bil_to_cust_cnt_cd" style="width:30px;" class="input" name="bil_to_cust_cnt_cd" maxlength="2" dataformat="enguponly" type="text" /><input id="bil_to_cust_seq" style="width:62px;" class="input" name="bil_to_cust_seq" maxlength="6" dataformat="num" type="text" /><button type="button" id="btn_pop_credit_cust" name="btn_pop_credit_cust" class="input_seach_btn"></button><input id="cust_lgl_eng_nm" style="width:330px;" class="input2" name="cust_lgl_eng_nm" readonly="readonly" tabindex="-1" type="text" /><button class="input_seach_btn" name="btns_cust" id="btns_cust" type="button"></button>
	                    </td>
	                    <th>Office</th>
	                    <td><input name="inv_ofc_cd" id="inv_ofc_cd" type="text" style="width:100px;" class="input2" readonly="readonly" value="<%=event.getOffsetARPopupListVO().getInvOfcCd()%>"></td>
					</tr>
				</tbody>
			</table>
			<table>
				<colgroup>
					<col width="40">				
					<col width="890">				
					<col width="70">				
					<col width="*">				
			   </colgroup>
			   <tbody>
					<tr>
						<th><%=otsSmryCdName%></th>
						<td></td>
	                    <th>V.V.D</th>
                      	<td><input id="vvd_cd" name="vvd_cd" style="width:100px;ime-mode:disabled" maxlength="9" dataformat="engup" class="input" type="text" /> </td>
					</tr>					
			   </tbody>
			</table>
			<table>
				<colgroup>
					<col width="110" />				
					<col width="110" />				
					<col width="110" />				
					<col width="110" />				
					<col width="490" />	
					<col width="70" />	
					<col width="*" />				
			   </colgroup> 
			   <tbody>
					<tr>
                      <td><input id="bl_inv_no" name="bl_inv_no" class="input" style="ime-mode:disabled;width:100px;" maxlength="50" dataformat="engup" type="text" /> </td>
                      <td><input id="bl_inv_no" name="bl_inv_no" class="input" style="ime-mode:disabled;width:100px;" maxlength="50" dataformat="engup" type="text" /> </td>
                      <td><input id="bl_inv_no" name="bl_inv_no" class="input" style="ime-mode:disabled;width:100px;" maxlength="50" dataformat="engup" type="text" /> </td>
                      <td><input id="bl_inv_no" name="bl_inv_no" class="input" style="ime-mode:disabled;width:100px;" maxlength="50" dataformat="engup" type="text" /> </td>
                      <td><input id="bl_inv_no" name="bl_inv_no" class="input" style="ime-mode:disabled;width:100px;" maxlength="50" dataformat="engup" type="text" /> </td>
                      <th>Currency</th>
                      <td><script type="text/javascript">ComComboObject('bl_curr_cd', 1, 100, 0, 0,0, false);</script></td>
                    </tr>
                    <tr>
                      <td><input id="bl_inv_no" name="bl_inv_no" class="input" style="ime-mode:disabled;width:100px;" maxlength="50" dataformat="engup" type="text" /> </td>
                      <td><input id="bl_inv_no" name="bl_inv_no" class="input" style="ime-mode:disabled;width:100px;" maxlength="50" dataformat="engup" type="text" /> </td>
                      <td><input id="bl_inv_no" name="bl_inv_no" class="input" style="ime-mode:disabled;width:100px;" maxlength="50" dataformat="engup" type="text" /> </td>
                      <td><input id="bl_inv_no" name="bl_inv_no" class="input" style="ime-mode:disabled;width:100px;" maxlength="50" dataformat="engup" type="text" /> </td>
                      <td><input id="bl_inv_no" name="bl_inv_no" class="input" style="ime-mode:disabled;width:100px;" maxlength="50" dataformat="engup" type="text" /> </td>
                      <th>Charge Type</th>
                      <td><script type="text/javascript">ComComboObject('chg_tp_cd', 1, 100, 0, 0,0, false);</script></td>
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
		<!-- opus_design_data(S) -->
		<div class="opus_design_data">
			<table>
				<colgroup>
					<col width="70">				
					<col width="140">				
					<col width="90">				
					<col width="*">				
			   </colgroup>
			   <tbody>
					<tr>
						<th>B/L Count </th>
                      	<td><input id="bl_count" name="bl_count" style="width:100px;text-align: right" class="input2" readonly="readonly" type="text" /> </td>
                      	<th>Total Amount</th>
                      	<td><input id="total_amount" name="total_amount" style="width:100px;;text-align: right" class="input2" readonly="readonly" type="text" /> </td>
					</tr>
			   </tbody>
			</table>
		</div>
		<!-- opus_design_data(E) -->
	</div>
	<!-- wrap_result(E) -->
</div>
</form>
<%@include file="/bizcommon/include/common_opus.jsp"%>
