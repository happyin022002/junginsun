<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : STM_SAR_3002.js
*@FileTitle  : Offset Entry
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
<%@page import="com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.event.StmSar3002Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%

    StmSar3002Event event = null;               //PDTO(Data Transfer Object including Parameters)
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
        
       
        event = (StmSar3002Event)request.getAttribute("Event");
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
<input type="hidden" name="f_cmd" id="f_cmd"> 
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="offst_ofc_cd" id="offst_ofc_cd">
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_searchlist" 	id="btn_searchlist">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_new" 	id="btn_new">New</button><!--
		--><button type="button" class="btn_normal" name="btn_save" 	id="btn_save">Save</button><!--
		--><button type="button" class="btn_normal" name="btn_reverse" 	id="btn_reverse">Reverse</button><!--
		--><button type="button" class="btn_normal" name="btn_view_accounting" 	id="btn_view_accounting">View Accounting</button><!--
		--><button type="button" class="btn_normal" name="btn_excel"  	id="btn_excel">Down Excel</button>	
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->
<!-- opus_design_inquiry(S) -->
<div class= "wrap_search">
	<div class= "opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="80"/>
				<col width="100"/>
				<col width="90"/>
				<col width="100"/>
				<col width="80"/>
				<col width="*"/>
			</colgroup>
			<tbody>
				<tr>
					<th>Offset No</th>
                    <td><input type="text" name="ar_offst_no" style="width:150px;" class="input1" maxlength="30" dataformat="engup" id="ar_offst_no" /> </td>
                    <th>Offset CUR</th>
                    <td width=""><select name="offst_curr_cd" style="width:79;" class="input1" required onchange="change_event_combo()"></select></td>
                    <th>Office</th>
                    <td><script type="text/javascript">ComComboObject('combo1', 1, 80, 1, 0, 0, true);</script> </td>
				</tr>	
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->
<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid clear" >
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_ar_search" id="btn_ar_search">AR Search</button><!--
			--><button type="button" class="btn_normal" name="btn_ap_search" 	id="btn_ap_search">AP Search</button><!-- 
			--><button type="button" class="btn_normal" name="btn_delete" 	id="btn_delete">Row Delete</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<div class= "opus_design_inquiry">
		<table>
			<colgroup>
				<col width="*"/>
				<col width="120"/>
				<col width="80"/>
				<col width="120"/>
				<col width="90"/>
				<col width="120"/>
			</colgroup>
			<tbody>
				<tr>
					<th>AP Remark</th>
                    <td colspan="3"><input type="text" name="ap_remark" style="width:395px;" class="input" maxlength="150" id="ap_remark" /> </td>
                    <th>AP Due Date</th>
                    <td><input type="text" name="ap_duedate" style="width:85px;" class="input" dataformat="ymd" id="ap_duedate" /><button type="button" id="btns_ap_dudate" name="btns_ap_dudate" class="calendar ir"></button></td>
				</tr>	
				<tr>
					 <th>Total AR Offset Amount</th>
                     <td><input type="text" name="tot_ar_offst_amt" style="text-align:right;width:100px;" class="input2" readonly="readonly" id="tot_ar_offst_amt" /> </td>
                     <th>Total AP Offset Amount</th>
                     <td><input type="text" name="tot_ap_offst_amt" style="text-align:right;width:100px;" class="input2" readonly="readonly" id="tot_ap_offst_amt" /> </td>
                     <th>Balance</th>
                     <td><input type="text" name="offst_balance" style="text-align:right;width:115px;" class="input2" readonly="readonly" id="offst_balance" /> </td>
				</tr>	
				<tr>
					<th>Reverse G/L Date</th>
                    <td><input type="text" name="reverse_gl_dt" style="width:100px;" class="input2" readonly="readonly" id="reverse_gl_dt" /> </td>
                    <th>Offset Date</th>
                    <td><input type="text" name="ar_offst_dt" style="width:100px;" class="input2" readonly="readonly" id="ar_offst_dt" /> </td>
                    <th>G/L Date</th>
                    <td><input type="text" name="gl_dt" style="width:115px;" class="input2" readonly="readonly" id="gl_dt" /> </td>
				</tr>	
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_grid(E) -->
</form>