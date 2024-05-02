<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : STM_SCO_0100.js
*@FileTitle  : STM Office Information
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/07
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.FormCommand"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.stm.sco.statementcommon.statementcommon.event.StmSco0100Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    StmSco0100Event event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			//Error occurred from server
	String strErrMsg = "";						//Error Message
	
	String strUsr_id = "";
	String strUsr_nm = "";
	

	Logger log = Logger.getLogger("com.clt.apps.opus.stm.sco.statementcommon.StatementCommonSC");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
		event = (StmSco0100Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}		     	
		
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
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
<input type="hidden" name="retrieve_chk" id="retrieve_chk" />
<input type="hidden" name="f_ots_if_flg_val" id="f_ots_if_flg_val" />
<input type="hidden" name="f_enbl_flg_val" id="f_enbl_flg_val" />
<input type="hidden" name="f_rct_unapy_flg_val" id="f_rct_unapy_flg_val" />
<input type="hidden" name="f_agn_ots_lmt_flg_val" id="f_agn_ots_lmt_flg_val" />
<input type="hidden" name="f_ots_if_flg" id="f_ots_if_flg" />

<input type="hidden" name="pagerows" id="pagerows" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" 	id="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_new" 		id="btn_new">New</button><!--
		--><button type="button" class="btn_normal" name="btn_save"  		id="btn_save">Save</button>	
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
				<col width="*"/>
			</colgroup>
			<tbody>
				<tr>
					<th>Office Code</th>
		           	<td><script type="text/javascript">ComComboObject('mdm_ofc_cd', 2, 100, 0, 0);</script></td>		           
				</tr>
			</tbody>
		</table>
		</div>
	<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
	<div class= "opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="80"/>
				<col width="160"/>
				<col width="80"/>
				<col width="160"/>
				<col width="80"/>
				<col width="*"/>
			</colgroup>
			<tbody>
				<tr><td colspan="6"><h3 class="title_design">AR Access Level</h3></td></tr>
				<tr>
					<th>Entry Level</th>
		            <td><script type="text/javascript">ComComboObject('f_ofc_entr_lvl_cd', 2, 100, 1, 1, 0,false,1);</script></td>
		            <th>Inquiry Level</th>
		            <td><script type="text/javascript">ComComboObject('f_ofc_inq_lvl_cd', 2, 100, 1, 1, 0,false,1);</script></td>
		            <th>BA Type</th>
		            <td><script type="text/javascript">ComComboObject('f_ofc_brnc_agn_tp_cd', 2, 100, 1, 1, 0,false,1);</script></td>
				</tr>
				<tr>
					<th>Bank Control</th>
		            <td><script type="text/javascript">ComComboObject('f_bank_ctrl_cd', 2, 100, 1, 0, 0,false,1);</script></td>
		            <th>Bank Office</th>
		            <td colspan="3"><script type="text/javascript">ComComboObject('f_bank_ofc', 1, 100, 0, 0);</script></td>
				</tr>
				</table>
		</div>
	<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
	<div class= "opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="80"/>
				<col width="160"/>
				<col width="80"/>
				<col width="160"/>
				<col width="80"/>
				<col width="160"/>
				<col width="80"/>
				<col width="*"/>
			</colgroup>
			<tbody>
				<tr><td colspan="8"><h3 class="title_design">Agent Information</h3></td></tr>
				<tr>
					<th>ASA Case</th>
					<td><script type="text/javascript">ComComboObject('f_agn_cmb_cd', 1, 100, 1, 0, 0,false,1);</script></td>
					<th>ASA Code</th>
					<td><input type="text" style="width:100px;" dataformat="enguponly" class="input" maxlength="3" name="f_agn_pfx_cd" value="" id="f_agn_pfx_cd" /></td>
					<th>Unreported OTS</th>
					<td><input type="text" style="width:100px;" dataformat="num" otherchar="-" class="input" name="f_agn_ots_lmt_amt" value="" id="f_agn_ots_lmt_amt" /></td>
					<th>Unreported OTS uncheck</th>
					<td><input type="checkbox" style="width:20px;" class="input" name="f_agn_ots_lmt_flg" value="" id="f_agn_ots_lmt_flg" /></td>
		        </tr>
		        </table>
		</div>
	<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
	<div class= "opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="80"/>
				<col width="160"/>
				<col width="80"/>
				<col width="160"/>
				<col width="80"/>
				<col width="*"/>
			</colgroup>
			<tbody>
		        <tr><td colspan="6"><h3 class="title_design">OTS Management</h3></td></tr>
		        <tr>
					<th>OTS Summary</th>
					<td><script type="text/javascript">ComComboObject('f_ots_cate_cd', 2, 100, 1, 1, 0,false,1);</script></td>
					<th>OTS</th>
					<td><script type="text/javascript">ComComboObject('f_ots_cd', 2, 100, 1, 1, 0,false,1);</script></td>
					<th>Rep. Office</th>
					<td><input type="text" style="width:100px;" dataformat="enguponly" class="input2" name="f_rep_ots_ofc_cd" value="" id="f_rep_ots_ofc_cd" /></td>
		        </tr>
		        <tr>
		        	<th>OPY Type</th>
		        	<td><script type="text/javascript">ComComboObject('f_ovpay_tp_cd', 2, 100, 1, 0, 0,false,1);</script></td>
		        	<th>ML Limitation</th>
		        	<td><input type="text" style="width:100px; text-align:right" class="input" dataformat="singledfloat" maxlength="6" pointcount="2"  name="f_misc_lss_lmt_amt" value="" id="f_misc_lss_lmt_amt" /></td>
		        	<th>MI Limitation</th>
		        	<td><input type="text" style="width:100px; text-align:right" class="input" dataformat="float" maxlength="5" pointcount="2" maxnum="99.99" name="f_misc_incm_lmt_amt" value="" id="f_misc_incm_lmt_amt" /></td>
		        </tr>
		      </table>
		</div>
	<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
	<div class= "opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="80"/>
				<col width="160"/>
				<col width="80"/>
				<col width="160"/>
				<col width="80"/>
				<col width="*"/>
			</colgroup>
			<tbody>
		        <tr><td colspan="6"><h3 class="title_design">Receipt Information</h3></td></tr>
		        <tr>
		        	<th>Receipt Type</th>
		        	<td><script type="text/javascript">ComComboObject('f_rct_tp_cd', 2, 100, 1, 0, 0,false,1);</script></td>
		        	<th>Receipt DOC </th>
		        	<td><script type="text/javascript">ComComboObject('f_rct_doc_cd', 2, 100, 1, 0, 0,false,1);</script></td>
		        	<th><label for="f_rct_unapy_flg">Unapplied</label></th>
		        	<td><input type="checkbox" style="width:20px;" class="input" name="f_rct_unapy_flg" value="" id="f_rct_unapy_flg" /></td>
		        </tr>
		        </table>
		</div>
	<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
	<div class= "opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="80"/>
				<col width="160"/>
				<col width="80"/>
				<col width="160"/>
				<col width="80"/>
				<col width="160"/>
				<col width="80"/>
				<col width="160"/>
				<col width="80"/>
				<col width="*"/>
			</colgroup>
			<tbody>
		        <tr><td colspan="6"><h3 class="title_design">Office Write-off</h3></td></tr>
		        <tr>
		        	<th>Type 1</th>	
                    <td><script type="text/javascript">ComComboObject('f_ofc_wrtf_tp_cd1', 2, 100, 1, 0, 0,false,1);</script></td>
                    <th>Type 2</th>	
                    <td><script type="text/javascript">ComComboObject('f_ofc_wrtf_tp_cd2', 2, 100, 1, 0, 0,false,1);</script></td>
                    <th>Type 3</th>
                    <td><script type="text/javascript">ComComboObject('f_ofc_wrtf_tp_cd3', 2, 100, 1, 0, 0,false,1);</script></td>
                    <th>Type 4</th>
                    <td><script type="text/javascript">ComComboObject('f_ofc_wrtf_tp_cd4', 2, 100, 1, 0, 0,false,1);</script></td>
                    <th>Type 5</th>
                    <td><script type="text/javascript">ComComboObject('f_ofc_wrtf_tp_cd5', 2, 100, 1, 0, 0,false,1);</script></td>                            
		        </tr>
		        </table>
		</div>
	<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
	<div class= "opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="80"/>
				<col width="160"/>
				<col width="80"/>
				<col width="160"/>
				<col width="80"/>
				<col width="160"/>
				<col width="80"/>
				<col width="160"/>
				<col width="80"/>
				<col width="*"/>
			</colgroup>
			<tbody>
		        <tr><td colspan="6"><h3 class="title_design">Office Adjustment</h3></td></tr>
		        <tr>
		        	<th>Type 1</th>	
                    <td><script type="text/javascript">ComComboObject('f_ofc_adj_tp_cd1', 2, 100, 1, 0, 0,false,1);</script></td>
                    <th>Type 2</th>	
                    <td><script type="text/javascript">ComComboObject('f_ofc_adj_tp_cd2', 2, 100, 1, 0, 0,false,1);</script></td>
                    <th>Type 3</th>
                    <td><script type="text/javascript">ComComboObject('f_ofc_adj_tp_cd3', 2, 100, 1, 0, 0,false,1);</script></td>
                    <th>Type 4</th>
                    <td><script type="text/javascript">ComComboObject('f_ofc_adj_tp_cd4', 2, 100, 1, 0, 0,false,1);</script></td>
                    <th>Type 5</th>
                    <td><script type="text/javascript">ComComboObject('f_ofc_adj_tp_cd5', 2, 100, 1, 0, 0,false,1);</script></td>                            
		        </tr>
		        </table>
		</div>
	<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
	<div class= "opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="123"/>
				<col width="160"/>
				<col width="80"/>
				<col width="160"/>
				<col width="80"/>
				<col width="*"/>
			</colgroup>
			<tbody>
		        <tr><td colspan="6"><h3 class="title_design">Letter Wording General</h3></td></tr>
		        <tr>
		        	<th>Office Title</th>
		            <td colspan="5">
					<textarea name="f_rct_ofc_tit_nm" cols="4" rows="2" style="width:500px; resize:none;" class="textarea" maxlength="200" id="f_rct_ofc_tit_nm"></textarea></td>
				</tr> 
				<tr>
		        	<th>Office Address</th>
		        	<td colspan="5">
		        	<textarea name="f_rct_ofc_addr" cols="4" rows="2" style="width:500px; resize:none;" class="textarea" maxlength="500" id="f_rct_ofc_addr"></textarea>
		        	</td>
				</tr> 
				<tr>
		        	<th>Office Tel no/Fax no</th>
		        	<td colspan="5"><input type="text" style="width:500px;" class="input" name="f_rct_ofc_telcm_fax_no_ctnt" value="" maxlength="200" id="f_rct_ofc_telcm_fax_no_ctnt" /></td>
				</tr> 
				</table>
		</div>
	<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
	<div class= "opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="123"/>
				<col width="160"/>
				<col width="80"/>
				<col width="160"/>
				<col width="80"/>
				<col width="*"/>
			</colgroup>
			<tbody>
				<tr><td colspan="6"><h3 class="title_design">Letter Wording Receipt</h3></td></tr>
				<tr>
		        	<th>Title</th>
		        	<td colspan="5"><input type="text" style="width:500px;" class="input" name="f_rct_tit_nm" value="" maxlength="200" id="f_rct_tit_nm" /></td>
				</tr> 
				<tr>
		        	<th>Remark</th>		        	
		        	<td colspan="5"><textarea name="f_rct_rmk" cols="4" rows="4" style="width:500px; resize:none;" class="textarea" maxlength="450" id="f_rct_rmk"></textarea></td>
				</tr> 
				<tr>
		        	<th>Special Remark</th>					
					<td colspan="5"><input type="text" style="width:500px;" class="input" name="f_rct_spcl_rmk" value="" maxlength="74" id="f_rct_spcl_rmk" /></td>
				</tr> 
				<tr>
		        	 <th>Office Special No</th>
		        	 <td colspan="5"><input type="text" style="width:500px;" class="input" name="f_rct_ofc_spcl_no_ctnt" value="" maxlength="74" id="f_rct_ofc_spcl_no_ctnt" /></td>
				</tr>
				</table>
		</div>
	<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
	<div class= "opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="123"/>
				<col width="160"/>
				<col width="80"/>
				<col width="160"/>
				<col width="80"/>
				<col width="*"/>
			</colgroup>
			<tbody>
				<tr><td colspan="6"><h3 class="title_design">Letter Wording Payment Request Letter</h3></td></tr>
				<tr>
		        	<th>Title</th>
		        	<td colspan="5"><input type="text" style="width:500px;" class="input" name="f_ar_prn_tit_nm" value="" maxlength="200" id="f_ar_prn_tit_nm" /></td>
				</tr> 
				<tr>
		        	<th>Remark<br>Credit Customer</th>
		        	<td colspan="5"><textarea name="f_ar_cr_cust_prn_ctnt" cols="5" rows="5" style="width:500px;resize:none;" class="textarea" maxlength="4000"></textarea></td>
				</tr>				
				<tr>
		        	<th>Remark<br>Non-Credit Customer</th>
		        	<td colspan="5"><textarea name="f_ar_prn_ctnt" cols="5" rows="5" style="width:500px;resize:none;" class="textarea" maxlength="4000"></textarea></td>
				</tr> 
			</tbody>
		</table>		
	</div>
	<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
	<div class= "opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="123"/>
				<col width="160"/>
				<col width="80"/>
				<col width="160"/>
				<col width="80"/>
				<col width="*"/>
			</colgroup>
			<tbody>
				<tr>
		        	<th>NYK BCC Mail &nbsp;</th>
		        	<td colspan="5"><input name="ref_eml" type="text" style="width:500px;" class="input" value="" id="ref_eml" /></td>
				</tr> 
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->
<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid clear" >
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
<!-- opus_design_grid(E) -->
 </form>