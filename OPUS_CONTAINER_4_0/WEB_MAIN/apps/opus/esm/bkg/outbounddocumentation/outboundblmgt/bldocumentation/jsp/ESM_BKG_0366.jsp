<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0632.jsp
*@FileTitle  : Marks And Number/Description of Goods
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/02
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg0366Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.core.view.template.Screen"%>
<%@ page import="com.clt.framework.core.controller.util.WebKeys"%>

<%
    EsmBkg0366Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			// error from server
	String strErrMsg = "";						// error message
	int rowCount	 = 0;						// count of DB resultSET list
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String isInquiry = "N";	
	Logger log = Logger.getLogger("com.clt.apps.OutboundBLMgt.BLDocumentationBL");
	String bkgNo      = "";
	String blNo       = "";
	String blTpCd     = "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmBkg0366Event)request.getAttribute("Event");
		bkgNo      = event.getBkgNo();
		blNo       = event.getBlNo();
		blTpCd     = event.getBlTpCd();
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		Screen screen = (Screen) request.getAttribute(WebKeys.CURRENT_SCREEN);
		if (screen.getName().indexOf("Q") >= 0){
			isInquiry = "Y";
		} else {
			isInquiry = "N";			
		}
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch(Exception e) {
		out.println(e.toString());
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
<input type="hidden" name="f_cmd" 		id="f_cmd">
<input type="hidden" name="pagerows" 	id="pagerows">
<input type="hidden" name="dirty_flag"  id="dirty_flag">
<input type="hidden" name="bkg_sts_cd"  id="bkg_sts_cd">
<input type="hidden" name="bdr_flg" 	id="bdr_flg">
<input type="hidden" name="corr_flg" 	id="corr_flg">
<input type="hidden" name="ca_flg" 		id="ca_flg">
<input type="hidden" name="ca_exist_flg" id="ca_exist_flg">
<input type="hidden" name="cnd_flg" 	 id="cnd_flg">
<input type="hidden" name="org_bl_no"    id="org_bl_no">
<input type="hidden" name="org_cntr_mf_no" 		id="org_cntr_mf_no">
<input type="hidden" name="default_wgt_ut_cd" 	id="default_wgt_ut_cd">
<input type="hidden" name="default_meas_ut_cd"  id="default_meas_ut_cd">
<input type="hidden" name="hts_flg" 	id="hts_flg">
<input type="hidden" name="bkg_mk_desc" id="bkg_mk_desc">
<input type="hidden" name="bkg_cstms_desc" id="bkg_cstms_desc">
<input type="hidden" name="isInquiry" id="isInquiry" value="<%=isInquiry%>">
<input type="hidden" name="obl_iss_flg" id="obl_iss_flg">
<input type="hidden" name="bl_tp_cd" id="bl_tp_cd" value="<%=blTpCd%>">

<input type="hidden" name="bkg_pck_qty" id="bkg_pck_qty">
<input type="hidden" name="bkg_pck_unit" id="bkg_pck_unit">
<input type="hidden" name="bkg_wgt_qty" id="bkg_wgt_qty">
<input type="hidden" name="bkg_wgt_unit" id="bkg_wgt_unit">
<input type="hidden" name="bkg_meas_qty" id="bkg_meas_qty">
<input type="hidden" name="bkg_meas_unit" id="bkg_meas_unit">


<div class="opus_design_btn opus_design_normal2">
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_addHBl" id="btn_addHBl">Add H.B/L</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_deleteHBl" id="btn_deleteHBl">Delete H.B/L</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_copyHBl" id="btn_copyHBl">Copy H.B/L</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_copyCM" id="btn_copyCM">Copy C/M</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_amsFileNoAssign" id="btn_amsFileNoAssign">Manifest File No. Assign</button>
	</div>
	<!-- opus_design_btn(E) -->
</div>

<span class="clear"></span>

<div class="wrap_search coupled_btn_normal2">
	<div class="opus_design_inquiry wFit">
		  <table>
		  <colgroup>
			<col width="68"/>
			<col width="100"/>
			<col width="135"/>
			<col width="*"/>
		   </colgroup>
		    <tbody>
		      <tr>
		        <th width="54">BKG No.</th>
				<td><input name="bkg_no" id="bkg_no" value="<%=bkgNo%>" type="text" style="ime-mode:disabled; width:110px;" dataformat="engup" class="input1"><button type="button" name="btn_splitPop" id="btn_splitPop" class="btn_down_list" onClick="openPopup('cust_cd')"></button>
				</td>
		        <th width="60">B/L No.</th>
			    <td><input type="text" name="bl_no" id="bl_no" value="<%=blNo%>" style="ime-mode:disabled; width:110px;" dataformat="engup" class="input"></td>
			    <td></td>
			  </tr>
		    </tbody>
		  </table>
	</div>
</div>

<!-- wrap_search (S)  -->
<div class="opus_design_inquiry wFit mar_btm_4">
	<div class="opus_design_inquiry wFit ">
	<table class="mar_top_8">
		<tbody>
		<colgroup>
			<col width="80"/>
			<col width="200"/>
			<col width="120"/>
			<col width="50"/>
			<col width="40"/>
			<col width="1"/>
			<col width="*"/>
		</colgroup>
			<tr>
				<th>Route</th>
				<td><input type="text" name="por_cd" id="por_cd" style="ime-mode:disabled;width:48px;" dataformat="engup" class="input2" readOnly><!--  
					--><input type="text" name="pol_cd" id="pol_cd" style="ime-mode:disabled;width:48px;" dataformat="engup" class="input2" readOnly><!--
					--><input type="text" name="pod_cd" id="pod_cd" style="ime-mode:disabled;width:48px;" dataformat="engup" class="input2" readOnly><!--
					--><input type="text" name="del_cd" id="del_cd" style="ime-mode:disabled;width:48px;" dataformat="engup" class="input2" readOnly>
				</td>
				<th>Master B/L Filer</th>
				<th>US</th>
				<td><input type="text" name="usa_cstms_file_cd" id="usa_cstms_file_cd" style="ime-mode:disabled;width:23px;" dataformat="engup" class="input2" readOnly></td>
				<th>CA</th>
				<td><input type="text" name="cnd_cstms_file_cd" id="cnd_cstms_file_cd" style="ime-mode:disabled;width:23px;" dataformat="engup" class="input2" readOnly></td>
			 </tr>
			</tbody>
		</table>

	  <table>
		<tbody>
		<colgroup>
			<col width="80"/>
			<col width="225"/>
			<col width="110"/>
			<col width="130"/>
			<col width="65"/>
			<col width="40"/>
			<col width="1"/>
			<col width="140"/>
			<col width="58"/>
			<col width="120"/>
			<col width="1"/>
			<col width="*"/>			
		</colgroup>
			<tr>
				<th>H.B/L Seq.</th>
				<td><select name="hbl_seq" id="hbl_seq" style="width:50px;"><option value="0" selected>0</option></select><input type="text" name="hbl_ttl_knt" id="hbl_ttl_knt" style="ime-mode:disabled;width:28px;" dataformat="int" class="input2" readOnly></td>
				<th>Manifest File No.</th>
				<td><input type="text" name="cntr_mf_no" id="cntr_mf_no" style="ime-mode:disabled;width:100px;" dataformat="engup" class="input2" readOnly></td>
				<th>Split</th>
				<td>
				<button type="button" name="btn_split" id="btn_split" class="input_seach_btn" onClick="openPopup('cust_cd')"></button>
				</td>
				<th>House B/L No.</th>
				<td><input type="text" name="hbl_no" id="hbl_no" style="ime-mode:disabled;width:120px;" dataformat="engup" class="input"></td>
				<th>IEC</th>
				<td><input type="text" name="ida_iec_no" id="ida_iec_no" style="ime-mode:disabled;width:100px;" dataformat="engup" class="input" maxlength="11"></td>
				<th>ACI Type</th>
				<td><%=JSPUtil.getCodeCombo("hbl_mf_tp_cd", "", "", "CD20056", 0, "000001: :")%>
				</td>
			 </tr>
		</tbody>
	</table>
</div>
</div>
<!-- wrap_search (E)  -->

<!-- bmj start  -->

<!-- wrap_result (S)  -->
<div class="wrap_result coupled_btn_normal2">

<!-- Block 1ST :layout_wrap (s) -->
<div class="layout_wrap">
	<div class="layout_flex_fixed" style="width:510px">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry sm">
	<table>
		<tbody>
		<colgroup>
			<col width="80"/>
			<col width="465"/>
			<col width="106"/>
			<col width="*"/>
		</colgroup>
			<tr>
				<th rowspan="2">Actual<br>Shipper</th>
				<td><textarea name="shpr_nm" id="shpr_nm" rows="3" cols="35" style=" resize: none; ime-mode:disabled; font-family:Courier New;  font-size:14px;text-indent:0px;;overflow-x:hidden;overflow-y:scroll;" dataformat="engup" wrap="hard" class="input1" otherchar="<%=getSpecialChars()%>" onpaste="javascript:mousePaste(this)"></textarea></td>								
			</tr>
			<tr >
				<td><textarea name="shpr_addr" id="shpr_addr"  rows="3" cols="35" style=" resize: none;ime-mode:disabled;font-family:Courier New;
				 font-size:14px;text-indent:0px;;overflow-x:hidden;overflow-y:scroll;" dataformat="engup" wrap="hard" class="input1" otherchar="<%=getSpecialChars()%>" onpaste="javascript:mousePaste(this)"></textarea></td>	 
			</tr>
		</tbody>
	 </table>
	 
	<table>
		<tbody>
		<colgroup>
			<col width="87"/>
			<col width="160"/>
			<col width="63"/>
			<col width="35"/>
			<col width="75"/>
			<col width="*"/>
		</colgroup>
			<tr>
				<th>City / State</th>
				<td><input type="text" name="shpr_cty_nm" id="shpr_cty_nm" style="ime-mode:disabled;width:120px;" dataformat="exceptengdn" class="input"><input type="text" name="shpr_ste_cd" id="shpr_ste_cd" style="ime-mode:disabled;width:30px;" dataformat="engup" class="input" maxlength="2"></td>
				<th>Country</th>
				<td><input type="text" name="shpr_cnt_cd" id="shpr_cnt_cd" style="ime-mode:disabled;width:30px;" dataformat="engup" class="input" maxlength="2"></td>
				<th>ZIP Code</th>
				<td><input type="text" name="shpr_zip_cd" id="shpr_zip_cd" style="ime-mode:disabled;width:100px; margin-right:0px !important;" dataformat="exceptengdn" class="input" maxlength="10"></td>		
			</tr>
			</tbody>
		</table>
		</div>
</div>
<div class="layout_flex_flex" style="padding-left:520px">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry sm">
	<table>
		<tbody>
		<colgroup>
			<col width="80"/>
			<col width="438"/>
			<col width="106"/>
			<col width="*"/>
		</colgroup>
			<tr>
				<th rowspan="2">Actual<br>Notify</th>
				<td>
					<textarea name="noti_nm" id="noti_nm" rows="3" cols="35" style="resize: none; ime-mode:disabled;font-family:Courier New;
				 	font-size:14px;text-indent:0px;;overflow-x:hidden;overflow-y:scroll;" dataformat="engup" wrap="hard" class="textarea" otherchar="<%=getSpecialChars()%>" onpaste="javascript:mousePaste(this)"></textarea></td>			
			</tr>
			<tr>
				<td>
					<textarea name="noti_addr" id="noti_addr" rows="3" cols="35" style="resize: none; ime-mode:disabled;font-family:Courier New; 
					font-size:14px;text-indent:0px;;overflow-x:hidden;overflow-y:scroll;" dataformat="engup" wrap="hard" class="textarea" otherchar="<%=getSpecialChars()%>" onpaste="javascript:mousePaste(this)"></textarea></td>
				<td colspan="2"></td>

				

			</tr>
			</tbody>
		</table>
		
	<table>
		<tbody>
		<colgroup>
			<col width="80"/>
			<col width="160"/>
			<col width="63"/>
			<col width="35"/>
			<col width="75"/>
			<col width="*"/>
		</colgroup>
			<tr >
				<th>City / State</th>
				<td ><input type="text"name="noti_cty_nm" id="noti_cty_nm" style="ime-mode:disabled;width:120px;" dataformat="exceptengdn" class="input"><input type="text" name="noti_ste_cd" id="noti_ste_cd" style="ime-mode:disabled;width:30px;" dataformat="engup" class="input" maxlength="2"></td>
				<th>Country</th>
				<td><input type="text"  name="noti_cnt_cd" id="noti_cnt_cd" style="ime-mode:disabled;width:30px;" dataformat="engup" class="input" maxlength="2"></td>
				<th >ZIP Code</th>
				<td><input type="text" name="noti_zip_cd" id="noti_zip_cd" style="ime-mode:disabled;width:100px;" dataformat="exceptengdn" class="input" maxlength="10"></td>
				
			</tr>
		</tbody>
	</table>
	</div>
	</div>
</div>
<!-- Block 1ST :layout_wrap (E) -->

<!-- Block 2ST :layout_wrap (s) -->
	
<div class="layout_wrap">
	<div class="layout_flex_fixed" style="width:510px">
    <!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry sm">
	<table>
		<tbody>
		<colgroup>
			<col width="78"/>
			<col width="425"/>
			<col width="106"/>
			<col width="*"/>
		</colgroup>	
			<tr>
				<th rowspan="2">Actual<br>Consignee</th>
				<td>
				<textarea name="cnee_nm" id="cnee_nm" rows="3" cols="35" style=" resize: none;ime-mode:disabled;font-family:Courier New; 
				font-size:14px;text-indent:0px;;overflow-x:hidden;overflow-y:scroll;" dataformat="engup" wrap="hard" class="input1" otherchar="<%=getSpecialChars()%>" onpaste="javascript:mousePaste(this)"></textarea></td>
			</tr>
			<tr>
				<td>
				<textarea name="cnee_addr" id="cnee_addr" rows="3" cols="35" style="resize: none;ime-mode:disabled;font-family:Courier New;
				 font-size:14px;text-indent:0px;;overflow-x:hidden;overflow-y:scroll;" dataformat="engup" wrap="hard" class="input1" otherchar="<%=getSpecialChars()%>" onpaste="javascript:mousePaste(this)"></textarea></td>

			</tr>
			</tbody>
		</table>
	<table>
		<tbody>
		<colgroup>
			<col width="87"/>
			<col width="160"/>
			<col width="63"/>
			<col width="35"/>
			<col width="75"/>
			<col width="*"/>
		</colgroup>
			<tr>
				<th>City / State</th>
				<td><input type="text"  name="cnee_cty_nm" id="cnee_cty_nm" style="ime-mode:disabled;width:120px;" dataformat="exceptengdn" class="input"><input type="text" name="cnee_ste_cd"  id="cnee_ste_cd" style="ime-mode:disabled;width:30px;" dataformat="engup" class="input" maxlength="2"></td>
				<th>Country</th>
				<td><input type="text" name="cnee_cnt_cd" id="cnee_cnt_cd" style="ime-mode:disabled;width:30px;" dataformat="engup" class="input" maxlength="2"></td>
				<th>ZIP Code</th>
				<td><input type="text" name="cnee_zip_cd"  id="cnee_zip_cd" style="ime-mode:disabled;width:100px;margin-right:0px !important;" dataformat="exceptengdn" class="input" maxlength="10"></td>
			</tr>
		</tbody>
		</table>
		</div>
	</div>
	
	<div class="layout_flex_flex" style="padding-left:520px;">
	<div class="layout_vertical_2" style ="width:190px;">
	<div class="opus_design_inquiry sm" style="height:160px;">
	<table>
		<tbody>
		<colgroup>
			<col width="1"/>
			<col width="1"/>
			<col width="*"/>
		</colgroup>
			<tr>
					<td></td>
					<th style="text-align:left !important;">Mark & NOS</th>
					<td></td>
			</tr>
			<tr>
					<td></td>
					<td>
					<textarea name="bl_mk_desc" id="bl_mk_desc"  rows="5" style="resize: none;ime-mode:disabled;width:170px;font-family:Courier New;
					 font-size:12px;text-indent:0px;;overflow-x:hidden;overflow-y:scroll;" dataformat="engup" wrap="hard" class="textarea" otherchar="<%=getSpecialChars()%>" onpaste="javascript:mousePaste(this)"></textarea></td>
					<td></td>
			</tr>
		</tbody>
		</table>
		</div>
	</div>
	</div>
	
	<div class="" style="padding-left:720px">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry sm" style="height:158px;">
    <table>
		<tbody>
		<colgroup>
			<col width="300"/>
			<col width="*"/>
		</colgroup>
		<tr>
			
			<th style="text-align:left !important;">Description</th>
			<td></td>
					
		</tr>
		<tr>			
			<td>
				<textarea name="bl_gds_desc" id="bl_gds_desc"  rows="5" style="resize: none;ime-mode:disabled;width:295px;font-family:Courier New;
			 	font-size:12px;text-indent:0px;;overflow-x:hidden;overflow-y:scroll;" dataformat="engup" wrap="hard" class="textarea" otherchar="<%=getSpecialChars()%>" onpaste="javascript:mousePaste(this)"></textarea>
			</td>	
			<td></td>			 
		</tr>
		<tr>		 	
			<td align="right"><button type="button" class="btn_etc" name="btn_hbl_tmplt" id="btn_hbl_tmplt" >House B/L Template</button></td>		
			<td></td>		
		</tr>
	</tbody>
	</table>
	</div>
  </div>
</div>
<!-- Block 2ST :layout_wrap (E) -->

<div class="opus_design_inquiry wFit"  >
	<table>
		<tbody>
		<colgroup>
				<col width="1"/>
				<col width="1"/>
				<col width="1"/>
				<col width="1"/>
				<col width="1"/>
				<col width="*"/>
			</colgroup>				
				<tr>
					<th>Total Package</th>
					<td><input type="text" name="pck_qty" id="pck_qty" style="width:80px;text-align:right;" dataformat="int" maxlength="7" class="input1"><input type="text" name="pck_tp_cd" id="pck_tp_cd" style="ime-mode:disabled;width:28px;" dataformat="engup" maxlength="2" class="input1"><button type="button" name="btn_PCKPop" id="btn_PCKPop" class="input_seach_btn" onClick="openPopup('cust_cd')"></button>
					</td>
					<th>Total Weight</th>
					<th><input type="text" name="hbl_wgt" id="hbl_wgt" style="width:68px;text-align:right;" dataformat="float" maxlength="13" pointcount="3" class="input1"><select name="wgt_ut_cd" id="wgt_ut_cd" style="width:66PX;" class="input1"><option value="KGS">KGS</option><option value="LBS">LBS</option></select></td>
					<th>Total Measure</th>
					<td><input type="text" name="cmdt_meas_qty" id="cmdt_meas_qty" style="width:48px;text-align:right;" dataformat="float" maxlength="9" pointcount="3" class="input"><select name="cmdt_meas_ut_cd" id="cmdt_meas_ut_cd" style="width:69px;"><option value="CBM">CBM</option><option value="CBF">CBF</option></select></td>
				 </tr>
			</tbody>
		</table>
	<!-- <table class="line_bluedot" style = "width: 1000px"><tr><td></td></tr></table> -->	
</div>		
<!-- opus_design_inquiry(E) -->	

<div class="line_bluedot"></div>


<div class="opus_design_grid">
<!-- layout_wrap(S) -->
<div class="layout_wrap">
    <div class="layout_vertical_2" style ="width:30%">
        <!--opus_design_grid(S) -->
        <div style="height: 29px;"></div>
        <div class="opus_design_grid" style="margin-right:8px;">    
		
            <script type="text/javascript">ComSheetObject('sheet1');</script>
        </div>
        <!--opus_design_grid(E) -->
    </div>
    
    <div class="layout_vertical_2" style="width:70%" >
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
        <!--opus_design_grid(S) -->
        <div class="opus_design_grid">
        <div class="opus_design_btn">		
			<button type="button" class="btn_normal" name="btn_add" id="btn_add">Row Add</button>
			<button type="button" class="btn_normal" name="btn_delete" id="btn_delete">Row Delete</button>
			<button type="button" class="btn_normal" name="btn_t9CopyMnd" id="btn_t9CopyMnd">Copy from M&amp;D</button>
		</div>
            <script type="text/javascript">ComSheetObject('sheet2');</script>
        </div>
       <!--opus_design_grid(E) -->
    </div>
    </div>
</div>
<!-- layout_wrap(E) -->							 
<!-- opus_design_inquiry(S) -->
<div class="opus_design_data sm mar_top_4">
	<table class="mar_btm_4">
		<tbody>
			<colgroup>
				<col width="120"/>
				<col width="1"/>
				<col width="80"/>
				<col width="1"/>
				<col width="100"/>
				<col width="80"/>
				<col width="1"/>
				<col width="1"/>
				<col width="100"/>
				<col width="*"/>
			</colgroup>		
			<tr>

				<th>Container Total :</th>
				<td></td>
				<th>Package</th>
				<td></td>
				<td><input type="text" name="cm_pck_qty" id="cm_pck_qty" style="width:90px;text-align:right;" class="input2" readOnly></td>
				<th>Weight</th>
				<td></td>
				<td><input type="text" name="cm_wgt_qty" id="cm_wgt_qty" style="width:130px;text-align:right;" class="input2" readOnly></td>
				<th>Measure</th>
				<td></td>
				<td><input type="text" name="cm_meas_qty" id="cm_meas_qty" style="width:130px;text-align:right;" class="input2" readOnly></td>
			 </tr>
		</tbody>
	</table>
	
	<table>	
			<colgroup>
				<col width="120"/>
				<col width="1"/>
				<col width="80"/>
				<col width="1"/>
				<col width="100"/>
				<col width="80"/>
				<col width="1"/>
				<col width="1"/>
				<col width="100"/>
				<col width="*"/>
			</colgroup>	
			<tbody>
				<tr>

					<th>House B/L Total :</th>
					<td></td>
					<th>Package</th>
					<td></td>
					<td><input type="text" name="bk_pck_qty" id="bk_pck_qty" style="width:90px;text-align:right;" class="input2" readOnly></td>
					<th>Weight</th>
					<td></td>
					<th><input type="text" name="bk_wgt_qty" id="bk_wgt_qty" style="width:130px;text-align:right;" class="input2" readOnly></td>
					<th>Measure</th>
					<td></td>
					<td><input type="text" name="bk_meas_qty" id="bk_meas_qty" style="width:130px;text-align:right;" class="input2" readOnly></td>
				 </tr>
			</tbody>
	</table>
</div>
</div>
</div>
</div>

</form>
<!-- opus_design_grid(S) -->
<div class="opus_design_grid">
   <script type="text/javascript">ComSheetObject('sheet3');</script>
</div>
<!-- opus_design_grid(E) -->
<div id="layList" name="layList" style="position:absolute;z-index:999;display:none">
	<IFRAME id="ifrm" name="ifrm" src="apps/opus/esm/bkg/bookingcommon/bookingutil/jsp/esm_booking_split_no.html" width="115px" height="82px" style="position:absolute;border:1 #e9e9e9 solid" scrolling="no"></IFRAME>
</div>
<form name="form2">
<input type="hidden" name="func" id="func">
<input type="hidden" name="mk_desc" id="mk_desc">
<input type="hidden" name="gds_desc" id="gds_desc">
</form>

<%!

	public String getSpecialChars() {
		return " ~!@#$%^&*()`_+-={}|[]\\\"\\':;,./?"; 
	}
		
%>