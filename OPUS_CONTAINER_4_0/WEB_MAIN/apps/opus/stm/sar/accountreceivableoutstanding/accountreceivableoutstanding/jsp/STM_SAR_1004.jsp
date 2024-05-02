<%@page import="com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.event.StmSar1004Event"%>
<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAR_1004.jsp
*@FileTitle  : Outstanding Aging Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/06
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

    StmSar1004Event event = null;               //PDTO(Data Transfer Object including Parameters)
    Exception serverException = null;           //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지

    String strUsr_id = "";
    String strUsr_nm = "";
    String strUsr_ofc_cd = "";
    Logger log = Logger.getLogger("com.clt.apps.opus.stm.sar.accountreceivableoutstanding.AccountReceivableOutstandingSC");
    
    String dueDt = JSPUtil.getKST("yyyy-MM-dd");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strUsr_ofc_cd = account.getOfc_cd();

        event = (StmSar1004Event)request.getAttribute("Event");
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
<style type="text/css">
	table tbody tr th {
		font-weight: bold !important;
	}
</style>
<script type="text/javascript" src="/opuscntr/rpt/script/common_rd.js"></script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="multi_clt_ofc_cd" id="multi_clt_ofc_cd" />
<input type="hidden" name="com_mrdArguments" id="com_mrdArguments" />
<input type="hidden" name="com_mrdBodyTitle" id="com_mrdBodyTitle" />
<input type="hidden" name="com_mrdPath" id="com_mrdPath" />
<input type="hidden" name="com_mrdXmlData" id="com_mrdXmlData" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button><!--
		--><button class="btn_normal" name="btn_print" id="btn_print" type="button">Print</button><!--
		--><button class="btn_normal" name="btn_excel" id="btn_excel" type="button">Down Excel</button><!--
		--></div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->
<!-- wrap_search(S) -->
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table>
			<colgroup>
				<col width="70" />				
				<col width="120" />				
				<col width="50" />				
				<col width="70" />				
				<col width="50" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
					<th>As of Date</th>
               	 	<td><input type="text" name="due_dt" style="width:80px;" class="input1" dataformat="ymd" id="due_dt"  value="<%=dueDt%>"/><button type="button" id="btn_due_dt" name="btn_due_dt" class="calendar ir"></button><input type="hidden" name="ots_src_cd" id="ots_src_cd" value=""></td>
               	 	<th>BL/INV</th>
               		<td><select name="bl_inv_tp" class="input1" style="width:50px;">
	                    <option value="">All</option>
	                    <option value="BL">BL</option>
	                    <option value="INV">Invoice</option>
                  		</select></td>
	                <th>Office</th>
	                <td><script type="text/javascript">ComComboObject('combo1', 1, 120, 1, 0, 0, true);</script></td>
	                <td><input type="text" style="width:80px;display:none;" class="input1" value="" name="rhq" id="rhq"/></td>
		   		</tr>
		   </tbody>
		</table>
		<table>
			<colgroup>
				<col width="70" />				
				<col width="170" />				
				<col width="390" />				
				<col width="70" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
					<th>By</th>
	                <td><input type="radio" name="sum_ofc_cust_tp" id="sum_ofc_cust_tp0" checked="checked" class="trans" value="OFC" alt="Office" onclick="javascript:sum_ofc_cust_tp_onclick(this);" id="sum_ofc_cust_tp" /><!-- 
	                 --><label for="sum_ofc_cust_tp0">Office</label>&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="sum_ofc_cust_tp" class="trans" value="CUST" alt="Customer" onclick="javascript:sum_ofc_cust_tp_onclick(this);" id="sum_ofc_cust_tp1" /><label for="sum_ofc_cust_tp1">Customer</label></td>
	                <td><input type="text" style="width:30px;" class="input2" name="rct_cust_cnt_cd" maxlength="2" dataformat="engup" id="rct_cust_cnt_cd" /><input type="text" style="width:66px;" class="input2" name="rct_cust_seq" maxlength="6" dataformat="num" id="rct_cust_seq" /><button type="button" id="btn_cust" name="btn_cust" class="input_seach_btn"></button><input type="text" style="width:239px;" class="input2" name="rct_cust_nm" readonly tabindex="-1" id="rct_cust_nm" /><input type="hidden" name="bil_to_cust_cnt_cd" id="bil_to_cust_cnt_cd" /><input type="hidden" name="bil_to_cust_seq" id="bil_to_cust_seq" /><input type="hidden" name="cust_cnt_cd" id="cust_cnt_cd" /><input type="hidden" name="cust_seq" id="cust_seq" /></td>
	                <th>Office Sum</th>
	                <td><select name="sum_tp" id="sum_tp" class="input" style="width:150px;">
	                    <option value="OFC">Each Sum Offices</option>
	                    <option value="">Sum of Offices</option>                    
	                  </select></td>
		   		</tr>
		   </tbody>
		</table>
		<table>
			<colgroup>
				<col width="70">				
				<col width="50">				
				<col width="50">				
				<col width="60">				
				<col width="70">				
				<col width="125">				
				<col width="50">				
				<col width="90">				
				<col width="50">				
				<col width="*">				
		   </colgroup> 
		   <tbody>
		   		<tr>
					<th>Bucket</th>
	                <td><input type="text" name="bk1" style="width:50px;" class="input1" value="30" id="bk1" maxlength="3" /><!--
	                --><input type="text" name="bk2" style="width:50px;" class="input1" value="60" id="bk2" maxlength="3" /><!--
	                --><input type="text" name="bk3" style="width:50px;" class="input1" value="90" id="bk3" maxlength="3" /><!--
	                --><input type="text" name="bk4" style="width:50px;" class="input1" value="120" id="bk4" maxlength="3" /><!--
	                --><input type="text" name="bk5" style="width:50px;" class="input1" value="180" id="bk5" maxlength="3" /></td>
	                <th>Over</th>
	                <td><input type="text" name="bk6" style="width:50px;" class="input1" value="180" id="bk6" maxlength="3" /></td>
	                <th>Currency</th>
	                <td><span style="font-weight:normal"><input type="radio" name="bl_curr_cd" class="trans" value="USD" checked="checked" id="bl_curr_cd0"><label for="bl_curr_cd0">USD</label>&nbsp;&nbsp;<input type="radio" name="bl_curr_cd" class="trans" value="LCL" id="bl_curr_cd1"><label for="bl_curr_cd1">LCL</label></span></td>
	                <th>B/L Sum</th>
	                <td><select name="bl_sum_tp" id="bl_sum_tp" class="input" style="width:100px;">
	                    <option value="">All</option>
	                    <option value="OTS" selected="selected">Outstanding</option>
	                    <option value="OPY">Overpaid</option> 
	                  </select></td>
	                <th>Credit</th>
	                <td><select name="cr_mk_flg" id="cr_mk_flg" class="input" style="width:70px;">
	                    <option value="">All</option>
	                    <option value="Y">Yes</option>
	                    <option value="N">No</option>
	                  </select></td>
		   		</tr>
		   </tbody>
		</table>

    <div class="line_bluedot"></div>
    
		<table>
			<colgroup>
				<col width="70" />				
				<col width="100" />				
				<col width="80" />				
				<col width="100" />				
				<col width="140" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
					<th>Office</th>
	                <td><input type="text" readonly="readonly" name="clt_ofc_cd" style="width:100px;" class="input2" id="clt_ofc_cd" /> </td>
	                <th>Customer</th>
	                <td><input type="text" readonly="readonly" name="cust_num" style="width:100px;" class="input2" id="cust_num" /><input type="text" readonly="readonly" name="cust_nm" style="width:350px;" class="input2" id="cust_nm" /></td>
	                <td><button type="button" class="btn_etc" name="btn_previous" id="btn_previous">Previous</button><button type="button" class="btn_etc" name="btn_next" id="btn_next">Next</button></td>
	                <td align="left"><span id="paging_info"></span></td>
		   		</tr>
		   </tbody>
		</table>
		
    <div class="line_bluedot"></div>

		<table class="grid_2 wFit">
			<colgroup>
				<col width="50" />				
				<col width="148" />				
				<col width="148" />				
				<col width="148" />				
				<col width="190" />				
				<col width="148" />				
				<col width="148" />				
				<col width="148" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
		   			<th rowspan="3">Bound</th>
	                <th>No Ex. Rate Count</th>
	                <th>Count</th>
	                <th>Bad Outstanding</th>
	                <th></th>
	                <th>Count</th>
	                <th>Below <span id="h_bk1" style="font-weight: bold;">30</span> D</th>
	                <th>Count</th>
	                <th>Below <span id="h_bk4" style="font-weight: bold;">120</span> D</th>
		   		</tr>
		   		<tr>
	                <th>Not Arrived</th>
	                <th>Count</th>
	                <th>Within Term</th>
	                <th>TTL Long Term Outstanding</th>
	                <th>Count</th>
	                <th>Below <span id="h_bk2" style="font-weight: bold;">60</span> D</th>
	                <th>Count</th>
	                <th>Below <span id="h_bk5" style="font-weight: bold;">180</span> D</th>
                </tr>
                <tr>                
	                <th>Not Arrived Count</th>
	                <th>Count</th>
	                <th>TTL Outstanding</th>
	                <th>Long Term Count</th>
	                <th>Count</th>
	                <th>Below <span id="h_bk3" style="font-weight: bold;">90</span> D</th>
	                <th>Count</th>
	                <th>Over <span id="h_bk6" style="font-weight: bold;">180</span> D</th>
	            </tr>
	            <tr>                                
	                <th rowspan="3"><span style="font-weight: bold;">O/B</span></th>
	                <td><input type="text" readonly="readonly" style="text-align: right;width:  75%; margin: auto 16px;" dataformat="num" name="col02" id="col02" /> </td>
	                <td><input type="text" readonly="readonly" style="text-align: right;width:  75%; margin: auto 16px;" dataformat="num" name="col03" id="col03" /> </td>
	                <td><input type="text" readonly="readonly" style="text-align: right;width:  75%; margin: auto 16px;" dataformat="float" name="col04" id="col04" /> </td>
	                <td></td>
	                <td><input type="text" readonly="readonly" style="text-align: right;width:  75%; margin: auto 16px;" dataformat="num" name="col06" id="col06" /> </td>
	                <td><input type="text" readonly="readonly" style="text-align: right;width:  75%; margin: auto 16px;" dataformat="float" name="col07" id="col07" /> </td>
	                <td><input type="text" readonly="readonly" style="text-align: right;width:  75%; margin: auto 16px;" dataformat="num" name="col08" id="col08" /> </td>
	                <td><input type="text" readonly="readonly" style="text-align: right;width:  75%; margin: auto 16px;" dataformat="float" name="col09" id="col09" /> </td>
	              </tr>
	            <tr>
	                <td><input type="text" readonly="readonly" style="text-align: right;width:  75%; margin: auto 16px;" dataformat="float" name="col11" id="col11" /> </td>
	                <td><input type="text" readonly="readonly" style="text-align: right;width:  75%; margin: auto 16px;" dataformat="num" name="col12" id="col12" /> </td>
	                <td><input type="text" readonly="readonly" style="text-align: right;width:  75%; margin: auto 16px;" dataformat="float" name="col13" id="col13" /> </td>
	                <td><input type="text" readonly="readonly" style="text-align: right;width:  75%; margin: auto 16px;" dataformat="float" name="col14" id="col14" /> </td>
	                <td><input type="text" readonly="readonly" style="text-align: right;width:  75%; margin: auto 16px;" dataformat="num" name="col15" id="col15" /> </td>
	                <td><input type="text" readonly="readonly" style="text-align: right;width:  75%; margin: auto 16px;" dataformat="float" name="col16" id="col16" /> </td>
	                <td><input type="text" readonly="readonly" style="text-align: right;width:  75%; margin: auto 16px;" dataformat="num" name="col17" id="col17" /> </td>
	                <td><input type="text" readonly="readonly" style="text-align: right;width:  75%; margin: auto 16px;" dataformat="float" name="col18" id="col18" /> </td>
               </tr>
               <tr>
                  <td><input type="text" readonly="readonly" style="text-align: right;width:  75%; margin: auto 16px;" dataformat="num" name="col20" id="col20" /> </td>
                  <td><input type="text" readonly="readonly" style="text-align: right;width:  75%; margin: auto 16px;" dataformat="num" name="col21" id="col21" /> </td>
                  <td><input type="text" readonly="readonly" style="text-align: right;width:  75%; margin: auto 16px;" dataformat="float" name="col22" id="col22" /> </td>
                  <td><input type="text" readonly="readonly" style="text-align: right;width:  75%; margin: auto 16px;" dataformat="num" name="col23" id="col23" /> </td>
                  <td><input type="text" readonly="readonly" style="text-align: right;width:  75%; margin: auto 16px;" dataformat="num" name="col24" id="col24" /> </td>
                  <td><input type="text" readonly="readonly" style="text-align: right;width:  75%; margin: auto 16px;" dataformat="float" name="col25" id="col25" /> </td>
                  <td><input type="text" readonly="readonly" style="text-align: right;width:  75%; margin: auto 16px;" dataformat="num" name="col26" id="col26" /> </td>
                  <td><input type="text" readonly="readonly" style="text-align: right;width:  75%; margin: auto 16px;" dataformat="float" name="col27" id="col27" /> </td>
              </tr>
              <tr>                                
                 <th rowspan="3"><span style="font-weight: bold;">I/B</span></th>
                 <td><input type="text" readonly="readonly" style="text-align: right;width:  75%; margin: auto 16px;" dataformat="num" name="col29" id="col29" /> </td>
                 <td><input type="text" readonly="readonly" style="text-align: right;width:  75%; margin: auto 16px;" dataformat="num" name="col30" id="col30" /> </td>
                 <td><input type="text" readonly="readonly" style="text-align: right;width:  75%; margin: auto 16px;" dataformat="float" name="col31" id="col31" /> </td>
                 <td></td>
                 <td><input type="text" readonly="readonly" style="text-align: right;width:  75%; margin: auto 16px;" dataformat="num" name="col33" id="col33" /> </td>
                 <td><input type="text" readonly="readonly" style="text-align: right;width:  75%; margin: auto 16px;" dataformat="float" name="col34" id="col34" /> </td>
                 <td><input type="text" readonly="readonly" style="text-align: right;width:  75%; margin: auto 16px;" dataformat="num" name="col35" id="col35" /> </td>
                 <td><input type="text" readonly="readonly" style="text-align: right;width:  75%; margin: auto 16px;" dataformat="float" name="col36" id="col36" /> </td>
               </tr>
               <tr>
                  <td><input type="text" readonly="readonly" style="text-align: right;width:  75%; margin: auto 16px;" dataformat="float" name="col38" id="col38" /> </td>
                  <td><input type="text" readonly="readonly" style="text-align: right;width:  75%; margin: auto 16px;" dataformat="num" name="col39" id="col39" /> </td>
                  <td><input type="text" readonly="readonly" style="text-align: right;width:  75%; margin: auto 16px;" dataformat="float" name="col40" id="col40" /> </td>
                  <td><input type="text" readonly="readonly" style="text-align: right;width:  75%; margin: auto 16px;" dataformat="float" name="col41" id="col41" /> </td>
                  <td><input type="text" readonly="readonly" style="text-align: right;width:  75%; margin: auto 16px;" dataformat="num" name="col42" id="col42" /> </td>
                  <td><input type="text" readonly="readonly" style="text-align: right;width:  75%; margin: auto 16px;" dataformat="float" name="col43" id="col43" /> </td>
                  <td><input type="text" readonly="readonly" style="text-align: right;width:  75%; margin: auto 16px;" dataformat="num" name="col44" id="col44" /> </td>
                  <td><input type="text" readonly="readonly" style="text-align: right;width:  75%; margin: auto 16px;" dataformat="float" name="col45" id="col45" /> </td>
                </tr>
                <tr>
                   <td><input type="text" readonly="readonly" style="text-align: right;width:  75%; margin: auto 16px;" dataformat="num" name="col47" id="col47" /> </td>
                   <td><input type="text" readonly="readonly" style="text-align: right;width:  75%; margin: auto 16px;" dataformat="num" name="col48" id="col48" /> </td>
                   <td><input type="text" readonly="readonly" style="text-align: right;width:  75%; margin: auto 16px;" dataformat="float" name="col49" id="col49" /> </td>
                   <td><input type="text" readonly="readonly" style="text-align: right;width:  75%; margin: auto 16px;" dataformat="num" name="col50" id="col50" /> </td>
                   <td><input type="text" readonly="readonly" style="text-align: right;width:  75%; margin: auto 16px;" dataformat="num" name="col51" id="col51" /> </td>
                   <td><input type="text" readonly="readonly" style="text-align: right;width:  75%; margin: auto 16px;" dataformat="float" name="col52" id="col52" /> </td>
                   <td><input type="text" readonly="readonly" style="text-align: right;width:  75%; margin: auto 16px;" dataformat="num" name="col53" id="col53" /> </td>
                   <td><input type="text" readonly="readonly" style="text-align: right;width:  75%; margin: auto 16px;" dataformat="float" name="col54" id="col54" /> </td>
                 </tr>
                 <tr>                                
                   <th rowspan="3"><span style="font-weight: bold;">TTL</span></th>
                   <td><input type="text" readonly="readonly" style="text-align: right;width:  75%; margin: auto 16px;" dataformat="num" name="col56" id="col56" /> </td>
                   <td><input type="text" readonly="readonly" style="text-align: right;width:  75%; margin: auto 16px;" dataformat="num" name="col57" id="col57" /> </td>
                   <td><input type="text" readonly="readonly" style="text-align: right;width:  75%; margin: auto 16px;" dataformat="float" name="col58" id="col58" /> </td>
                   <td></td>
                   <td><input type="text" readonly="readonly" style="text-align: right;width:  75%; margin: auto 16px;" dataformat="num" name="col60" id="col60" /> </td>
                   <td><input type="text" readonly="readonly" style="text-align: right;width:  75%; margin: auto 16px;" dataformat="float" name="col61" id="col61" /> </td>
                   <td><input type="text" readonly="readonly" style="text-align: right;width:  75%; margin: auto 16px;" dataformat="num" name="col62" id="col62" /> </td>
                   <td><input type="text" readonly="readonly" style="text-align: right;width:  75%; margin: auto 16px;" dataformat="float" name="col63" id="col63" /> </td>
                 </tr>
                 <tr>
                   <td><input type="text" readonly="readonly" style="text-align: right;width:  75%; margin: auto 16px;" dataformat="float" name="col65" id="col65" /> </td>
                   <td><input type="text" readonly="readonly" style="text-align: right;width:  75%; margin: auto 16px;" dataformat="num" name="col66" id="col66" /> </td>
                   <td><input type="text" readonly="readonly" style="text-align: right;width:  75%; margin: auto 16px;" dataformat="float" name="col67" id="col67" /> </td>
                   <td><input type="text" readonly="readonly" style="text-align: right;width:  75%; margin: auto 16px;" dataformat="float" name="col68" id="col68" /> </td>
                   <td><input type="text" readonly="readonly" style="text-align: right;width:  75%; margin: auto 16px;" dataformat="num" name="col69" id="col69" /> </td>
                   <td><input type="text" readonly="readonly" style="text-align: right;width:  75%; margin: auto 16px;" dataformat="float" name="col70" id="col70" /> </td>
                   <td><input type="text" readonly="readonly" style="text-align: right;width:  75%; margin: auto 16px;" dataformat="num" name="col71" id="col71" /> </td>
                   <td><input type="text" readonly="readonly" style="text-align: right;width:  75%; margin: auto 16px;" dataformat="float" name="col72" id="col72" /> </td>
                 </tr>
                 <tr>
                   <td><input type="text" readonly="readonly" style="text-align: right;width:  75%; margin: auto 16px;" dataformat="num" name="col74" id="col74" /> </td>
                   <td><input type="text" readonly="readonly" style="text-align: right;width:  75%; margin: auto 16px;" dataformat="num" name="col75" id="col75" /> </td>
                   <td><input type="text" readonly="readonly" style="text-align: right;width:  75%; margin: auto 16px;" dataformat="float" name="col76" id="col76" /> </td>
                   <td><input type="text" readonly="readonly" style="text-align: right;width:  75%; margin: auto 16px;" dataformat="num" name="col77" id="col77" /> </td>
                   <td><input type="text" readonly="readonly" style="text-align: right;width:  75%; margin: auto 16px;" dataformat="num" name="col78" id="col78" /> </td>
                   <td><input type="text" readonly="readonly" style="text-align: right;width:  75%; margin: auto 16px;" dataformat="float" name="col79" id="col79" /> </td>
                   <td><input type="text" readonly="readonly" style="text-align: right;width:  75%; margin: auto 16px;" dataformat="num" name="col80" id="col80" /> </td>
                   <td><input type="text" readonly="readonly" style="text-align: right;width:  75%; margin: auto 16px;" dataformat="float" name="col81" id="col81" /> </td>
                 </tr>
		   </tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_search(E) -->
</form>
<!-- wrap_result(S) -->
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" style="display: none;">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
</div>

