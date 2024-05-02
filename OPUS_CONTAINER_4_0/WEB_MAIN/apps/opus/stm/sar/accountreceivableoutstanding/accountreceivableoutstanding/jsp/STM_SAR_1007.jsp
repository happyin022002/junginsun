<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAR_1007.jsp
*@FileTitle  : Outstanding Item Correction
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================*/
%>
	<%@ page import="com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.event.StmSar1007Event"%>
	<%@ page contentType="text/html; charset=UTF-8"%>
	<%@ page import="com.clt.framework.component.util.JSPUtil"%>
	<%@ page import="com.clt.framework.component.util.DateTime"%>
	<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
	<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
	<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
	<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
	<%@ page import="org.apache.log4j.Logger" %>
	<%
	    StmSar1007Event event = null;               //PDTO(Data Transfer Object including Parameters)
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


	        event = (StmSar1007Event)request.getAttribute("Event");
	        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

	        if (serverException != null) {
	            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
	        }

	    } catch(Exception ex) {
	        log.error("err " + ex.toString(), ex);
	    }

	    String blNo = JSPUtil.getParameter(request, "bl_no", "");
	    String invNo = JSPUtil.getParameter(request, "inv_no", "");
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
	<input type="hidden" name="rhq_cd" id="rhq_cd" />
	<input type="hidden" name="ots_ofc_cd" id="ots_ofc_cd" />
	<input type="hidden" name="bl_no" value="<%=blNo%>" id="bl_no" />
	<input type="hidden" name="inv_no" value="<%=invNo%>" id="inv_no" />

	<input type="hidden" name="ots_grp_tp_cd" id="ots_grp_tp_cd" />
	<input type="hidden" name="ots_tp_cd" id="ots_tp_cd" />
	<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_searchlist" id="btn_searchlist" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button><!--
		--><button class="btn_normal" name="btn_save" id="btn_save" type="button">Save</button><!--
		--><button class="btn_normal" name="btn_history" id="btn_history" type="button">History</button><!--
		--><button class="btn_normal" name="btn_view_accounting" id="btn_view_accounting" type="button">View Accounting</button><!--
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
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="70" />				
				<col width="160" />				
				<col width="70" />				
				<col width="170" />				
				<col width="60" />				
				<col width="160" />				
				<col width="50" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
					<th>B/L|ASA No.</th>
	                <td><input name="cond_bl_no" dataformat="engup" value="<%=blNo%>" maxlength="12" type="text" style="width:140px;" class="input" id="cond_bl_no" /> 	                </td>
	                <th>Invoice No</th>
	                <td><input name="cond_inv_no" readonly="readonly" value="<%=invNo%>" maxlength="50" type="text" style="width:150px;" dataformat="eng" class="input2" id="cond_inv_no" /></td>
	                <th>BKG No</th>
	                <td><input name="cond_bkg_no" dataformat="engup" maxlength="13" type="text" style="width:140px;" class="input" id="cond_bkg_no" /></td>
	                <th>Office</th>
	                <td><script type="text/javascript">ComComboObject('combo1', 1, 80, 1, 0, 0, true);</script></td> 
		   		</tr>
		   </tbody>
		</table>
	</div>
	<div class="opus_design_inquiry">
		<div class="line_bluedot"></div>
	</div>
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="70" />				
				<col width="285" />				
				<col width="110" />				
				<col width="240" />				
				<col width="83" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
					<th>Actual CUST</th>
	                <td><input name="cust_num" readonly="readonly" type="text" style="width:70px;text-align: center;" class="input2" id="cust_num" />
	                <input name="cust_nm" readonly="readonly" type="text" style="width:215px;" class="input2" id="cust_nm" /></td>
	                <th>Customer</th>
	                <td><input name="ship_cust_num" readonly="readonly" type="text" style="width:137px;text-align: center;" class="input2" id="ship_cust_num" />
	                <input name="ship_cust_nm" readonly="readonly" type="text" style="width:150px;" class="input2" id="ship_cust_nm" /></td>
	                <th>Booking No.</th>
	                <td><input name="bkg_no" readonly="readonly" type="text" style="width:122px;text-align: center;" class="input2" id="bkg_no" /></td> 
		   		</tr>
		   </tbody>
		</table>
		<table>
			<colgroup>
				<col width="70">				
				<col width="60">				
				<col width="95">				
				<col width="135">				
				<col width="112">				
				<col width="106">				
				<col width="84">				
				<col width="110">				
				<col width="80">				
				<col width="*">				
		   </colgroup> 
		   <tbody>
		   		<tr>
					<th>Credit CUR</th>
	                <td><input name="cr_curr_cd" readonly="readonly" type="text" style="width:50px;text-align: center;" class="input2" id="cr_curr_cd" /></td>
	                <th>Credit Limit</th>
	                <td><input name="cr_amt" readonly="readonly" type="text" style="width:135px;text-align: center;" class="input2" id="cr_amt" /></td>
	                <th>O/B Term</th>
	                <td><input name="ob_cr_term_dys" readonly="readonly" type="text" style="width:50px;text-align: center;" class="input2" id="ob_cr_term_dys" /></td>
	                <th>I/B Term</th>
	                <td><input name="ib_cr_term_dys" readonly="readonly" type="text" style="width:100px;text-align: center;" class="input2" id="ib_cr_term_dys" /></td>
	                <th>Rate</th>
	                <td><input name="ots_rt_flg" readonly="readonly" type="text" style="width:50px;text-align: center;" class="input2" id="ots_rt_flg" /></td> 
		   		</tr>
		   </tbody>
		</table>
		<table>
			<colgroup>
				<col width="70">				
				<col width="120">				
				<col width="70">				
				<col width="120">				
				<col width="100">				
				<col width="120">				
				<col width="70">				
				<col width="120">				
				<col width="70">				
				<col width="*">				
		   </colgroup> 
		   <tbody>
		   		<tr>
					<th title="Vessel Voyage Direction">VVD</th>
	                <td><input name="vvd" readonly="readonly" type="text" style="width:100px;text-align: center;" class="input2" id="vvd" /></td>
	                <th>Trunk/VVD</th>
	                <td><input name="trnk_vvd_cd" readonly="readonly" type="text" style="width:100px;text-align: center;" class="input2" id="trnk_vvd_cd" /></td>
	                <th>S/A Date</th>
	                <td><input name="sail_arr_dt" readonly="readonly" type="text" style="width:100px;text-align: center;" class="input2" dataformat="ymd" id="sail_arr_dt" /></td>
	                <th>SCP/Lane</th>
	                <td><input name="svc_scp_cd" readonly="readonly" type="text" style="width:47px;text-align: center;" class="input2" id="svc_scp_cd" /><input name="lane_cd" readonly="readonly" type="text" style="width:49px;" class="input2" id="lane_cd" /></td>
	                <th>Bound</th>
	                <td><input name="bkg_io_bnd_cd" readonly="readonly" type="text" style="width:50px;text-align: center;" class="input2" id="bkg_io_bnd_cd" /></td> 
		   		</tr>
		   		<tr>
	                <th>POR/POL</th>
	                <td><input name="por_cd" readonly="readonly" type="text" style="width:47px;text-align: center;" class="input2" id="por_cd" /><input name="pol_cd" readonly="readonly" type="text" style="width:49px;" class="input2" id="pol_cd" /></td>
	                <th>POD/DEL</th>
	                <td><input name="pod_cd" readonly="readonly" type="text" style="width:47px;text-align: center;" class="input2" id="pod_cd" /><input name="del_cd" readonly="readonly" type="text" style="width:49px;" class="input2" id="del_cd" /></td>
	                <th>Due Date</th>
	                <td><input name="due_dt" readonly="readonly" type="text" style="width:100px;text-align: center;" class="input2" dataformat="ymd" id="due_dt" /></td>
	                <th>Overdue</th>
	                <td><input name="over_due" readonly="readonly" type="text" style="width:100px;text-align: center;" class="input2" dataformat="ymd" id="over_due" /></td>
	                <th>Source</th>
	                <td><input name="ots_src_cd" readonly="readonly" type="text" style="width:50px;text-align: center;" class="input2" id="ots_src_cd" /></td>
              </tr>
              <tr>
                <th>Reference</th>
                <td><input name="bkg_ref_no" readonly="readonly" type="text" style="width:100px;text-align: center;" class="input2" id="bkg_ref_no" /></td>
                <th>Issue Date</th>
                <td><input name="inv_dt" readonly="readonly" type="text" style="width:100px;;text-align: center;" class="input2" dataformat="ymd" id="inv_dt" /></td>
                <th>Sales REP</th>
                <td><input name="cust_srep_cd" readonly="readonly" type="text" style="width:100px;text-align: center;" class="input2" id="cust_srep_cd" /></td>
                <th>Office</th>
                <td><input name="clt_ofc_cd" readonly="readonly" type="text" style="width:100px;text-align: center;" class="input2" id="clt_ofc_cd" /></td>
              </tr>
		   </tbody>
		</table>
		<table>
			<colgroup>
				<col width="70">				
				<col width="340">				
				<col width="70">				
				<col width="*">				
		   </colgroup>
			<tbody>
				<tr>
                  <th>OTS Group</th>
                  <td><script type="text/javascript">ComComboObject('combo2' , 2, 110, 1, 0, 0,false ,1);</script><input type="text" style="width:176px;" class="input2"  name="ots_grp_tp_cd_nm" readonly="readonly"></td>
                  <th>OTS Type</th>
                  <td><script type="text/javascript">ComComboObject('combo3' , 3, 100, 1, 0, 0,false ,1);</script><input type="text" style="width:172;" class="input2"  name="ots_tp_cd_nm" readonly="readonly"></td>
           	   </tr>  
			</tbody>
		</table>
		<table>
			<colgroup>
				<col width="70">				
				<col width="*">				
		   </colgroup>
			<tbody>
				<tr>
	               <th>Remark</th>
	               <td><input name="ots_rmk" type="text" style="width:802px;" class="input1" id="ots_rmk" dataformat="excepthan"/></td>
              </tr>
              <tr>
	               <th>CNTR No</th>
	               <td><input name="sc_no" readonly="readonly" type="text" style="width:802px;" class="input2" id="sc_no" /></td>
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
	
	<!-- opus_design_inquiry(S) -->
	<div class="layout_flex_fixed" style="width:50%">
		<table>
			<tr>
				<th width="20%">Invoice Currency</th>
				<td width="20%"><input name="inv_curr_cd" readonly="readonly" type="text" style="width:80px;" class="input2" id="inv_curr_cd" /></td>
				<td width="60%"></td>
			</tr>
		</table>
	</div>
	
	<div class="layout_flex_fixed" style="width:50%">
		<table class="grid_2">
	       <tr>
	         <th width="20%">&nbsp;</th>
	         <th width="20%"><strong>Invoice</strong></th>
	         <th width="20%"><strong>Receipt</strong></th>
	         <th width="20%"><strong>Adjust</strong></th>
	         <th width="20%"><strong>Balances</strong></th>
	       </tr>
	       <tr>
	         <th style="text-align:center"><strong>Updated</strong></th>
	         <td align="center"><span id="udt_inv"></span></td>
	         <td align="center"><span id="udt_rct"></span></td>
	         <td align="center"><span id="udt_adj"></span></td>						         
	         <td align="center"><span id="udt_bal"></span></td>
	       </tr>          
           <tr>
             <th style="text-align:center"><strong>LCL Total</strong></th>
             <td align="right"><span id="lcl_inv"></span></td>
             <td align="right"><span id="lcl_rct"></span></td>
             <td align="right"><span id="lcl_adj"></span></td>
             <td align="right"><span id="lcl_bal"></span></td>
           </tr>                               
           <tr>
             <th style="text-align:center"><strong>USD Total</strong></th>
             <td align="right"><span id="usd_inv"></span></td>
             <td align="right"><span id="usd_rct"></span></td>
             <td align="right"><span id="usd_adj"></span></td>
             <td align="right"><span id="usd_bal"></span></td>
           </tr>
         </table> 
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_result(E) -->	      
	      
</form>
