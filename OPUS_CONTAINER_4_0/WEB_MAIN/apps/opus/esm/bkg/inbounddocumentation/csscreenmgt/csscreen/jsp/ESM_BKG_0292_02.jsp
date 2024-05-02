<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0292_01.jsp
*@FileTitle  : Cargo Release Order_E-D/O inquiry _Main
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.event.EsmBkg029202Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg029202Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.CsScreenMgtSC.CsScreenBC");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmBkg029202Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch(Exception e) {
		out.println(e.toString());
	}
%>
<title>Inbound C/S Screen(Cargo Release)</title>

<script type="text/javascript">
	var strUsr_id    = "<%=strUsr_id%>";
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />
<input id="bl_no" name="bl_no" value="" type="hidden" />
<input id="bkg_no" name="bkg_no" value="<%=JSPUtil.getNull(request.getParameter("bkg_no")) %>" type="hidden" />
<input id="h_split" name="h_split" value="" type="hidden" />
<input id="h_mrd_id" name="h_mrd_id" value="" type="hidden" />
<input id="h_local_lang_flg" name="h_local_lang_flg" value="" type="hidden" />
<input id="invTotBilAmt" name="invTotBilAmt" type="hidden" />
<input id="h_old_bl_no" name="h_old_bl_no" value="" type="hidden" />
<input id="h_old_bkg_no" name="h_old_bkg_no" value="" type="hidden" />
<input id="com_mrdPath" name="com_mrdPath" value="" type="hidden" />
<input id="com_mrdArguments" name="com_mrdArguments" value="" type="hidden" />
<input id="com_mrdTitle" name="com_mrdTitle" value="" type="hidden" />
<input id="com_mrdDisableToolbar" name="com_mrdDisableToolbar" value="" type="hidden" />
<input id="com_mrdBodyTitle" name="com_mrdBodyTitle" value="" type="hidden" />
<input id="tpb_status" name="tpb_status" type="hidden" />
<input id="oaXmlData" name="oaXmlData" type="hidden" />
<input id="blInfo_do_split_flg" name="blInfo_do_split_flg" type="hidden" />
<input id="rlse_sts_cd" name="rlse_sts_cd" type="hidden" />
<input id="last_rlse_sts_cd" name="last_rlse_sts_cd" type="hidden" />
<input id="h_do_no" name="h_do_no" type="hidden" />
<input id="pre_ctnt" name="pre_ctnt" type="hidden" />
<input id="demDtlXmlData" name="demDtlXmlData" type="hidden" />

<!-- data_area(S) -->
<div class="opus_design_inquiry">
    <table> 
		<colgroup>
			<col width="80"/>
			<col width="150"/>
			<col width="*"/>
		</colgroup>
		<tbody>
			<tr>
				<th><h3 class="title_design">D/O No. Split By CNTR</h3></th>
				<td style="vertical-align :top;"><input type="radio" onclick="setSplitFlag('N');" class="trans" value="N" name="split_flg" id="rdo1" disabled><label for="rdo1">No</label><input type="radio" onclick="setSplitFlag('Y');" class="trans" value="Y" name="split_flg" id="rdo2" disabled><label for="rdo2">Yes</label></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</div>
<!-- data_area(E) -->

<div class="opus_design_grid" >
	<script type="text/javascript">ComSheetObject('blInfo');</script>
	<script type="text/javascript">ComSheetObject('euDoRlseStsCntr');</script>
	<script type="text/javascript">ComSheetObject('euDoRlseStsBl');</script>
</div>

<!-- layout_wrap(S) -->
<div class="layout_wrap">
    <div class="layout_vertical_3" style="width:600px">
        <div class="opus_design_inquiry">
	        <table>
				<colgroup>
					<col width="155"/>
					<col width="35"/>
					<col width="20"/>
					<col width="35"/>
					<col width="20"/>
					<col width="40"/>
					<col width="100"/>
					<col width="*"/>
				</colgroup>
	        	<tr>
	            	<td><h3 class="title_design">Bill of Lading Status</h3></td>
					<td><input id="blInfo_obl_rdem_flg" name="blInfo_obl_rdem_flg" style="width:25px; color:blue; font-weight:bold;text-align:center;" class="input2" readonly="true" type="text" /></td>
					<th>No</th>
					<td><input id="blInfo_obl_cpy_knt" name="blInfo_obl_cpy_knt" style="width:25px;color:black;text-align:center; font-weight:bold;" class="input2" readonly="true" type="text" /></td>
					<td></td>
					<th><h3 class="title_design">TPB</h3></th>
					<td><input id="tpb_cd" style="width: 20px; text-align:center;" name="tpb_cd" class="input2" readonly="true" type="text" /><button type="button" class="input_seach_btn" name="btn_tpb" id="btn_tpb"></button><input id="hold_flag" name="hold_flag" style="width: 50px; text-align:center;" class="input2_1" readonly="true" type="text" /><input id="blInfo_do_hld_flg" name="blInfo_do_hld_flg" type="hidden" /></td>
					<td></td>
	            </tr>
	        </table>
        </div>
        <div class="opus_design_inquiry" style="width:600px">
			 <table>
					<colgroup>
						<col width="150">
						<col width="50">
						<col width="50">
						<col width="100">
						<col width="50">
						<col width="200">
					</colgroup> 			 
	            <tr>
	                 <th>B/L Issue</th>
	                 <td><input id="blInfo_bl_tp_cd" name="blInfo_bl_tp_cd" style="width:25px;text-align:center;" class="input2" readonly type="text" /></td>
	                 <th>OFC</th>
	                 <td><input id="blInfo_obl_iss_ofc_cd" name="blInfo_obl_iss_ofc_cd" style="width:60px;" class="input2" readonly type="text" /><input id="blInfo_obl_iss_usr_id" name="blInfo_obl_iss_usr_id" style="width:70px;" class="input2" readonly type="text" /> </td>
	                 <th>DT</th>
	                 <td><input id="blInfo_obl_iss_dt" name="blInfo_obl_iss_dt" style="width:110px;" class="input2" readonly type="text" /><input style="width:20px;text-align:center;" value="" class="noinput2" readonly type="text" /> </td>
	           	</tr>
	            <tr>
	                 <th>B/L Receive</th>
	                 <td><input id="blInfo_obl_rdem_knt" name="blInfo_obl_rdem_knt" style="width:25px;text-align:center;" class="input2" readonly="true" type="text" /> </td>
	                 <th>OFC</th>
	                 <td><input id="blInfo_obl_rdem_ofc_cd" name="blInfo_obl_rdem_ofc_cd" style="width:60px;text-align:center;" class="input2" readonly="true" type="text" /><input id="blInfo_obl_rdem_usr_id" name="blInfo_obl_rdem_usr_id" style="width:70px;text-align:center;" class="input2" readonly="true" type="text" /> </td>
	                 <th>DT</th>
	                 <td><input id="blInfo_obl_rdem_dt" name="blInfo_obl_rdem_dt" style="width:110px;text-align:center;" class="input2" readonly="true" type="text" /><!-- 
	                  --><input id="bl_surr_rmk_flg" name="bl_surr_rmk_flg" style="width: 55px;text-align:center;" class="noinput2" readonly="true" type="text" /><button type="button" class="input_seach_btn" name="btn_bl_surr_rmk" id="btn_bl_surr_rmk"></button>
	                 </td>
	            </tr>
			 	<tr>
                    <th>Other DOC RCV</th>
                    <td><input id="blInfo_bl_otr_doc_rcv_cd" name="blInfo_bl_otr_doc_rcv_cd" style="width:25px;" class="input2" value="" readonly="true" type="text" /> </td>
                    <th>OFC</th>
                    <td><input id="blInfo_otr_doc_rcv_ofc_cd" name="blInfo_otr_doc_rcv_ofc_cd" style="width:60px;" class="input2" readonly="true" type="text" /><input id="blInfo_otr_doc_rcv_usr_id" name="blInfo_otr_doc_rcv_usr_id" style="width:70px;" class="input2" readonly="true" type="text" /> </td>
                    <th>DT</th>
                    <td><input id="blInfo_otr_doc_rcv_dt" name="blInfo_otr_doc_rcv_dt" style="width:110px;" class="input2" readonly="true" type="text" /><input id="blInfo_otr_doc_cgor_flg" name="blInfo_otr_doc_cgor_flg" style="width:83px;text-align:center;" class="input2" value="" readonly="true" type="text" /> </td>
                </tr>
				<tr>
                    <th>Inbond DOC RCV</th>
                    <td><input id="blInfo_ibd_doc_rcv_flg" name="blInfo_ibd_doc_rcv_flg" style="width:25px;" class="input2" value="" readonly="true" type="text" /> </td>
                    <th>OFC</th>
                    <td><input id="blInfo_ibd_doc_rcv_ofc_cd" name="blInfo_ibd_doc_rcv_ofc_cd" style="width:60px;" class="input2" value="" readonly="true" type="text" /><input id="blInfo_ibd_doc_rcv_usr_id" name="blInfo_ibd_doc_rcv_usr_id" style="width:70px;" class="input2" value="" readonly="true" type="text" /> </td>
                    <th>DT</th>
                    <td><input id="blInfo_ibd_doc_rcv_dt" name="blInfo_ibd_doc_rcv_dt" style="width:110px;" class="input2" value="" readonly="true" type="text" /><input style="width:20px;" class="noinput2" value="" readonly="true" type="text" /> </td>
                </tr>
			</table>
        </div>
    </div>
    <div class="layout_vertical_3" style="width:10px;">&nbsp;</div>
    <div class="layout_vertical_3" style="width:500px">
        <div class="opus_design_inquiry">
	        <table>
	        	<colgroup>
					<col width="10"/>
					<col width="80"/>
					<col width="150"/>
					<col width="*"/>
				</colgroup>
	        	<tr>
	        		<td></td>
	        		<th><h3 class="title_design">Freight Received Status</h3></th>
	                <td><input id="blInfo_tot_ots_sts_cd" style="width:20px;text-align:center;" class="input2_1" name="blInfo_tot_ots_sts_cd" type="text" /><select style="width: 150px; font-weight:bold;" class="input2" name="t3_tot_ots_amt"></select></td>
	                <td></td>
	        	</tr>
	        </table>
        </div>
        <div class="opus_design_inquiry">
			<table>
					<colgroup>
				 	  	 <col width="60">
				 	  	 <col width="50">
				 	  	 <col width="50">
				 	  	 <col width="20">
				 	  	 <col width="40">
				 	  	 <col width="*">			 	  	 
				 	  </colgroup>
            	<tr>
                	<th>PPD1</th>
                    <td><input id="blInfo_ppt_sts_cd" name="blInfo_ppt_sts_cd" style="width:27px;text-align:center;" class="input2" readonly="true" type="text" /></td>
                    <th>OFC</th>
                    <td><input id="blInfo_ppt_rcv_ofc_cd" name="blInfo_ppt_rcv_ofc_cd" style="width:60px;text-align:left;" class="input2" readonly type="text" /><input id="blInfo_ppt_rcv_usr_id" name="blInfo_ppt_rcv_usr_id" style="width:70px;text-align:left;" class="input2" readonly type="text" /> </td>
                    <th>DT</th>
                    <td><input id="blInfo_ppt_rcv_dt" name="blInfo_ppt_rcv_dt" style="width:115px;text-align:center;" class="input2" readonly type="text" /></td>
                </tr>
                <tr>
                    <th>CCT1</th>
                    <td><input id="blInfo_cct_sts_cd" name="blInfo_cct_sts_cd" style="width:27px;text-align:center;color:red;" class="input2" readonly="true" type="text" /><button type="button" id="div_btn_cct" class="input_seach_btn" name="btn_cct" id="btn_cct"></button></td>
                    <th>OFC</th>
                    <td><input id="blInfo_cct_rcv_ofc_cd" name="blInfo_cct_rcv_ofc_cd" style="width:60px;text-align:left;" class="input2" readonly="true" type="text" /><input id="blInfo_cct_rcv_usr_id" name="blInfo_cct_rcv_usr_id" style="width:70px;text-align:left;" class="input2" readonly="true" type="text" /> </td>
                    <th>DT</th>
                    <td><input id="blInfo_cct_rcv_dt" name="blInfo_cct_rcv_dt" style="width:115px;text-align:center;" class="input2" readonly="true" type="text" /></td>
                </tr>
				<tr>
                    <th>PPD2</th>
                    <td><input id="blInfo_n3pty_ppt_sts_cd" name="blInfo_n3pty_ppt_sts_cd" style="width:27px;text-align:center;" class="input2" readonly="true" type="text" /></td>
                    <th>OFC</th>
                    <td><input id="blInfo_n3pty_ppt_rcv_ofc_cd" name="blInfo_n3pty_ppt_rcv_ofc_cd" style="width:60px;text-align:left;" class="input2" readonly="true" type="text" /><input id="blInfo_n3pty_ppt_rcv_usr_id" name="blInfo_n3pty_ppt_rcv_usr_id" style="width:70px;text-align:left;" class="input2" readonly="true" type="text" /> </td>
                    <th>DT</th>
                    <td><input id="blInfo_n3pty_ppt_rcv_dt" name="blInfo_n3pty_ppt_rcv_dt" style="width:115px;text-align:center;" class="input2" readonly="true" type="text" /></td>
                </tr>
				<tr>
                    <th>CCT2</th>
                    <td><input id="blInfo_n3pty_cct_sts_cd" name="blInfo_n3pty_cct_sts_cd" style="width:27px;text-align:center;color:red;" class="input2" readonly="true" type="text" /><button type="button" class="input_seach_btn" name="btn_third_cct" id="div_btn_third_cct"></button></td>
                    <th>OFC</th>
                    <td><input id="blInfo_n3pty_cct_rcv_ofc_cd" name="blInfo_n3pty_cct_rcv_ofc_cd" style="width:60px;text-align:center;" class="input2" readonly="true" type="text" /><input id="blInfo_n3pty_cct_rcv_usr_id" name="blInfo_n3pty_cct_rcv_usr_id" style="width:70px;text-align:center;" class="input2" readonly="true" type="text" /> </td>
                    <th>DT</th>
                    <td><input id="blInfo_n3pty_cct_rcv_dt" name="blInfo_n3pty_cct_rcv_dt" style="width:115px;" class="input2" readonly="true" type="text" /></td>
                </tr>
			</table>
        </div>
    </div>
</div>
<!-- layout_wrap(E) -->
<!-- data_area(S) -->
<div class="opus_design_inquiry">
    <table> 
		<colgroup>
			<col width="120"/>
			<col width="250"/>
			<col width="50"/>
			<col width="100"/>
			<col width="100"/>
			<col width="200"/>
			<col width="*"/>
		</colgroup>
		<tbody>
			<tr>
				<td><h3 class="title_design">Demurrage Status/Outstanding</h3></td>
                <td><input type="text" name='demur_sts' style="width:25px; color:red; font-weight:bold;" class="input2" readonly="true"><select style="width:160px;font-weight:bold;" class="input2" name='t3_tot_bil_amt'></select></td>
      			<th>Demurrage Type</th>
      			<td><input type="text" name='demur_type' style="width:35px;" class="input2" readonly="true"></tds>
               	<th>Expect Delivery Date</th>
               	<td><input type="text" name='exp_del_dt' style="width:75px;ime-mode:disabled" class="input1" caption="Expect Delivery Date" dataformat="ymd" minlength="8" maxlength="8" required="true"><button type="button" class="calendar ir" name="img_exp_del_dt" id="img_exp_del_dt"></button><button type="button" class="btn_etc" name="btn_dem_retrieve" id="btn_dem_retrieve">Retrieve</button><button type="button" class="btn_etc" name="btn_dmdt" id="btn_dmdt">DMDT</button></td>
               	<td></td>
			</tr>
		</tbody>
	</table>
</div>
<div class="opus_design_grid" >
	<!--Demurrage-->
	<script type="text/javascript">ComSheetObject('demInfo');</script>
	<script type="text/javascript">ComSheetObject('demDtl');</script>			            
	<!--Total Billable Amount-->
	<script type="text/javascript">ComSheetObject('totBlbAmt');</script>
</div>
<!-- data_area(E) -->
<!-- layout_wrap(S) -->
<div class="layout_wrap">
    <div class="layout_vertical_2" style="width:49%">
        <div class="opus_design_inquiry">
			   <table class="grid2">
	               <tr><th class="align_center" style="height:26px;">O/B Remark(s)</th></tr>
	               <tr><td><textarea cols="80" style="width: 100%; height:30px; resize:none;" name='blInfo_obl_iss_rmk' id='blInfo_obl_iss_rmk' class="noinput2" readonly></textarea></td></tr>
	           </table>
        </div>
    </div>
    <div class="layout_vertical_2" style="width:2%">
        <table><tr><td>&nbsp;</td></tr></table>
    </div>
     <div class="layout_vertical_2" style="width:49%">
        <div class="opus_design_data">
			   <table class="grid2">
	               <tr>
	               		<th class="align_center" style="width:95%">Hold / Internal  Remark(s)</th>
	               		<td><button type="button" class="btn_etc" name="btn_save" id="btn_save">Save</button></td>
	               </tr>
	               <tr><td colspan="2"><textarea cols="80" style="width: 100%; height:30px; resize:none;" name='blInfo_inter_rmk' id='blInfo_inter_rmk' onKeyDown="fncTextareaMaxLine(this.value)"></textarea></td></tr>
	           </table>
        </div>
    </div>
</div>
<!-- layout_wrap(E) -->

</form>
 