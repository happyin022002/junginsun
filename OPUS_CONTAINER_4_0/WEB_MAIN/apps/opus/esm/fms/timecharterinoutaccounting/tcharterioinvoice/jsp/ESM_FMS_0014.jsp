<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_FMS_0014.jsp
*@FileTitle  : Off-Hire Expenses
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/18
=========================================================*/
%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	Exception serverException = null;			//Error from Server
	String strErrMsg = "";	

	String usrId = "";
	String strUsr_nm		= "";
	String strOfc_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.TimeCharterInOutAccounting.TCharterIOInvoice");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	usrId = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_nm = account.getOfc_eng_nm();

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

	}catch(Exception e) {
		log.error(e.getMessage(),e);
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
<input type="hidden" name="ibflag" id="ibflag" />
<input type="hidden" name="inv_seq" id="inv_seq" />
<input type="hidden" name="offh_seq" id="offh_seq" />
<input type="hidden" name="ppay_hir_no" id="ppay_hir_no" />
<input type="hidden" name="ori_eff_dt" id="ori_eff_dt" />
<input type="hidden" name="ori_exp_dt" id="ori_exp_dt" />
<input type="hidden" name="ori_inv_usd_dys" id="ori_inv_usd_dys" />
<input type="hidden" name="flet_ctrt_tp_gb" id="flet_ctrt_tp_gb" />
<input type="hidden" name="search_yn" id="search_yn" />
<input type="hidden" name="curr_cd" id="curr_cd" />
<input type="hidden" name="inv_desc" id="inv_desc" />
<input type="hidden" name="usr_id" value="<%=usrId%>" id="usr_id" />

<input type="hidden" name="usr_nm" value="<%=strUsr_nm%>" id="usr_nm" />
<input type="hidden" name="ofc_nm" value="<%=strOfc_nm%>" id="ofc_nm" />
<input type="hidden" name="flet_offh_rsn_nm" id="flet_offh_rsn_nm" />
<!-- Input Box for Report Designer -->
<input type="hidden" name="com_mrdPath" value="" id="com_mrdPath" />
<input type="hidden" name="com_mrdArguments" value="" id="com_mrdArguments" />
<input type="hidden" name="com_mrdTitle" value="Statement of Hire Deduction" id="com_mrdTitle" />
<input type="hidden" name="com_mrdBodyTitle" value="Statement of Hire Deduction" id="com_mrdBodyTitle" />
<input type="hidden" name="com_mrdSaveDialogFileExt" value="ppt" id="com_mrdSaveDialogFileExt" />
<input type="hidden" name="com_mrdSaveDialogFileExtLimit" value="xls@pdf@doc@ppt" id="com_mrdSaveDialogFileExtLimit" />
<input type="hidden" name="com_mrdSaveDialogFileName" value="Statement of Hire Deduction" id="com_mrdSaveDialogFileName" />
<input type="hidden" name="com_mrdSaveDialogDir" value="" id="com_mrdSaveDialogDir" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
			<button class="btn_normal" type="button" name="btn_execute" id="btn_execute">Execute</button><!--
		--><button class="btn_accent" type="button" name="btn_new" id="btn_new">New</button><!--
		--><button class="btn_normal" type="button" name="btn_save" id="btn_save" >Save</button><!--
		--><button class="btn_normal" type="button" style="display:none" name="btn_delete2" id="btn_delete2" >Delete</button><!--
		--><button class="btn_normal" type="button" style="display:none" name="btn_print" id="btn_print" >Print</button><!--
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
		<table class="search_in">	
			<tbody>
			<colgroup>
				<col width="80px"/>
				<col width="*"/>
			</colgroup>
				<tr height="30px">
					<th>Condition</th>
					<td><input type="radio" class="trans" name="condition" value="C" checked onClick="setCondition('C');"><!-- 
						 --><label for="radio_snc_sc">Creation</label><!-- 
						 --><input type="radio" class="trans" name="condition" value="I" onClick="setCondition('I');"><!-- 
						 --><label for="radio_snc_sc">Inquiry</label></td>
			 	</tr>	
			</tbody>
		</table>
		<table>
			<colgroup>
				<col width="80px"/>
				<col width="250px"/>
				<col width="90px"/>
				<col width="150px"/>
				<col width="165px"/>			
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
		   			<th>Vessel Code</th>
					<td><input type="text" style="width:54px;text-align:center;ime-mode:disabled" class="input1" maxlength="4" dataformat="engup" name="vsl_cd" id="vsl_cd" required fullfill caption="Vessel Code"><!-- 
					 --><button type="button" name="btn_vslpop" id="btn_vslpop"  class="input_seach_btn"></button><!-- 
					 --><input type="text" style="width:162px;" class="input2" name="vsl_eng_nm" id="vsl_eng_nm" readonly></td> 
					<th>Contract No.</th>
					<td><input type="text" style="width:120px;text-align:center;" class="input1" maxlength="15" name="flet_ctrt_no" fullfill caption="Contract No." required readonly><!-- 
					 --><button type="button" name="contract_no" id="contract_no"  class="input_seach_btn"></button></td>
					<th>Contract TP</th>
					<td><input type="text" style="width:70px;text-align:center;" class="input2" name="flet_ctrt_tp_cd" id="flet_ctrt_tp_cd" readonly></td>
		   		</tr>
		   </tbody>
		</table>
		
		<table>
			<colgroup>
				<col width="80px"/>
				<col width="500px"/>
				<col width="165px"/>
				<col width="*"/>			
		   </colgroup> 
			<tr class="h23">
				<th>Owner Code</th>
				<td><input type="text" style="width:30px;text-align:center;" class="input2" name="cust_cnt_cd" id="cust_cnt_cd" readonly><!-- 
				 --><input type="text" style="width:67px;text-align:center;" class="input2" name="cust_seq" id="cust_seq" readonly><!-- 
				  --><input type="text" style="width:390px;" class="input2" name="vndr_lgl_eng_nm" readonly></td> 
				<th>Owner Name</th><!-- width:185 -->
				<td><input type="text" style="width:333px;" class="input2" name="ownr_nm" readonly></td>
			</tr>
		</table>
		
		<table>
		<colgroup>
			<col width="80px"/>
			<col width="502px"/>
			<col width="165px"/>
			<col width="130px"/>
			<col width="10px"/>
			<col width="*" />		
	   </colgroup> 
		<tr class="h23">
			<th>Duration</th>
			<td><input type="text" style="width:75px;text-align:center;" class="input" name="eff_dt" id="eff_dt" dataformat="ymd"><!-- 
			 --><input type="text" style="width:50px;text-align:center;" class="input" name="from_time" id="from_time" maxlength="4" dataformat="hm"><!-- 
			 --><button type="button" name="ef_dt" id="ef_dt"  class="calendar ir"></button><!-- 
			 --> ~ <!-- 
			 --><input type="text" style="width:75px;text-align:center;" class="input" name="exp_dt" id="exp_dt" dataformat="ymd"><!-- 
			 --><input type="text" style="width:50px;text-align:center;" class="input" name="to_time" id="to_time" maxlength="4" dataformat="hm"><!-- 
			 --><button type="button" name="ex_dt" id="ex_dt"  class="calendar ir"></button><!-- 
			 --><input type="text" style="width:60px;text-align:right" class="input2" name="inv_usd_dys" readOnly onfocus="test()" > Days <!-- 
			 --><button type="button" name="duration" id="duration" class="input_seach_btn"></button></td>
			<th>Address Comm.</th>
			<td><input type="text" style="width:45px;text-align:right;" class="input2" name="acmm_rt_amt" dataformat="float" maxlength="6" pointcount="2" caption="Address Comm." readonly> % <input type="checkbox" value="N" class="trans" name="acmm_flg" id="acmm_flg"></td>
			<th>Brokerage</th>
			<td><input type="text" style="width:45px;text-align:right;" class="input2" name="flet_brog_rt_amt" dataformat="float" maxlength="6" pointcount="2" caption="Brokerage" readonly> % <input type="checkbox" value="N" class="trans" name="brog_flg" id="brog_flg"></td>
		</tr>
		</table>
		
		<table>
			<colgroup>
				<col width="80px">				
				<col width="173">				
				<col width="75">				
				<col width="215">				
				<col width="133">
				<col width="93">
				<col width="107">				
				<col width="*">				
		   </colgroup> 
		   <tbody>
		   		<tr>
		   			<th>VVD CD</th> 
					<td><select style="width:115px;" class="noinput" name="bunker_vvd" id="bunker_vvd"></select></td>
					<th>Accident Type</th> 
					<td><select style="width:89px;" class="noinput" name="flet_offh_rsn_cd" id="flet_offh_rsn_cd"></select></td>
		   			<td></td>
					<td></td>
					<td></td>
					<td></td>
		   		</tr>
		   </tbody>
		</table>
		</div>
		<table class="line_bluedot">  <tr><td></td></tr></table>
		<div class="opus_design_inquiry wFit">
		<h3 class="title_design">Hire Information</h3>
		<table> 
			<colgroup>
				<col width="80px">	
				<col width="*">			
			</colgroup>
           <tr class="h23">
               <th>Hire</th>
               <td><input type="text" style="width:76px;text-align:center;" class="input2" name="hir_eff_dt" readonly><!-- 
                -->
               <input type="text" style="width:45px;text-align:center;" class="input2" name="hir_eff_dt_time" readonly><!-- 
                --> ~ <!-- 
                 --><input type="text" style="width:76px;text-align:center;" class="input2" name="hir_exp_dt" readonly> <input type="text" style="width:45px;text-align:center;" class="input2" name="hir_exp_dt_time" readonly>&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" style="width:40px;text-align:center;" class="input2" name="hir_hir_curr_n1st_cd" readonly> <input type="text" style="width:95px;text-align:right;" class="input2" name="hir_hir_rt_n1st_amt" readonly>&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" style="width:40px;text-align:center;" class="input2" name="hir_hir_curr_n2nd_cd" readonly> <input type="text" style="width:95px;text-align:right;" class="input2" name="hir_hir_rt_n2nd_amt" readonly></td>
            </tr>
        </table>
		
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<h3 class="title_design">Other(s) Lump sum information</h3>
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_add" id="btn_add" type="button">Row Add</button><!--
			--><button class="btn_normal" name="btn_del" id="btn_del" type="button">Row Del</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	<!-- opus_design_data(S) -->
	<div class="opus_design_data">
		<table style="width:100%; text-align:right;">
			<colgroup>
				<col width="400px" />				
				<col width="90px" />				
				<col width="147px" />										
				<col width="*" />				
		   </colgroup>    
			<tr id="totalAmount" style="display:none;">
				<td></td>
				<th valign="absmiddle">Total Amount</th>
				<td id="totalAmount1" valign="top" width="100px"></td>
				<td id="totalAmount2" valign="top" width="100px"></td>
			</tr>
		</table>
	</div>
<!-- opus_design_data(E) -->
</div>
</form>