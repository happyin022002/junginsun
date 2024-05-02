<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0034_01.jsp
*@FileTitle  : B/L Inquiry_Customs
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/09
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.event.EsmBkg0034Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
    EsmBkg0034Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.SCGuideline.SCGuidelineMain");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0034Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// If you imported data from the server initialization when loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" value="<%=pageRows %>" id="pagerows" />
<input type="hidden" name="shpr_ibflag" id="shpr_ibflag" />
<input type="hidden" name="cnee_ibflag" id="cnee_ibflag" />
<input type="hidden" name="ntfy_ibflag" id="ntfy_ibflag" />
<input type="hidden" name="tab_no" value="1" id="tab_no" />
<input type="hidden" name="bl_no" id="bl_no" />
<input type="hidden" name="shpr_bkg_cust_tp_cd" value="S" id="shpr_bkg_cust_tp_cd" />
<input type="hidden" name="cnee_bkg_cust_tp_cd" value="C" id="cnee_bkg_cust_tp_cd" />
<input type="hidden" name="ntfy_bkg_cust_tp_cd" value="N" id="ntfy_bkg_cust_tp_cd" />
<input type="hidden" name="cust_tp" id="cust_tp" />


<!-- layout_wrap(S) -->
<div class="layout_wrap">
    <div class="layout_vertical_2">
    	<div class="opus_design_inquiry pad_4">
			<table class="grid_2">
				<colgroup>
					<col width="80px" />
					<col width="50px" />
					<col width="50px" />
					<col width="50px" />
					<col width="50px" />
					<col width="50px" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
	                    <td style="background-color:#F3F2F8;border-top:1px solid #E8EFF9;border-right:1px solid #E8EFF9;border-left:1px solid #E8EFF9;text-align:center; ">Shipper</td>
	                    <td colspan="3">
		                    <input type="text" name="shpr_cust_cnt_cd" style="width:20; ime-mode: disabled" dataformat="engup" maxlength="2" fullfill caption="Shipper Country Code" class="input" />
		                    <input type="text" name="shpr_cust_seq" style="width:60;text-align:right; ime-mode: disabled" dataformat="engup" maxlength="6" caption="Consignee Customer Seq." class="input" />
		                    <button type="button" class="btn_down_list" name="btn_cust_s" id="btn_cust_s"></button>
	                    </td>
	                </tr>
	                <tr>
	                    <th>Name</th>
	                    <td colspan="3"><textarea name="shpr_cust_nm" style="width:100%;overflow-y:hidden;resize:none" rows="2"></textarea></td>
	                </tr>
	                <tr>
	                    <th>Address</th>
	                    <td colspan="3"><textarea name="shpr_cust_addr" style="width:100%;overflow-y:hidden;resize:none" rows="3"></textarea></td>
	                </tr>
					<tr>
						<th>City / State</th>
						<td><input type="text" name="shpr_cust_cty_nm" style="width:210px;text-transform:uppercase;" class="input" value="" dataformat="exceptengdn" otherchar=" "  maxlength="30"/>
						<input type="text" name="shpr_cust_ste_cd" style="width:30px;text-transform:uppercase;" class="input" value="" maxlength="2" dataformat="engup"/></td>
						<th>Country</th>
						<td><input type="text" name="shpr_cstms_decl_cnt_cd" style="width:30px;text-transform:uppercase;" class="input" value="" maxlength="2" dataformat="engup"/></td>
					</tr>
					<tr>
						<th>Street / P.O.Box</th>
						<td><input type="text" name="shpr_eur_cstms_st_nm" style="width:250px;text-transform:uppercase;" class="input" value="" dataformat="exceptengdn"  maxlength="50"/> </td>
						<th>ZIP Code</th>
						<td><input type="text" name="shpr_cust_zip_id" style="width:74px;" class="input" value="" dataformat="engup" otherchar="-\s" maxlength="10"/></td>
					</tr>
	                <tr>
	                    <th>Tel.</th>
	                    <td><input type="text" name="shpr_phn_no" style="width:100px;%;"  class="input" id="shpr_phn_no" /> </td>
	                    <th>Fax.</th>
	                    <td><input type="text" name="shpr_fax_no" style="width:100px;%;"  class="input" id="shpr_fax_no" /> </td>
	                </tr>
				</tbody>
			</table>
		</div>
    </div>
    <div class="layout_vertical_2">
    	<div class="opus_design_inquiry pad_4">
			<table class="grid_2">
				<colgroup>
					<col width="80px" />
					<col width="50px" />
					<col width="50px" />
					<col width="50px" />
					<col width="50px" />
					<col width="50px" />
					<col width="*" />
				</colgroup>
				<tbody>
                	<tr>
                         <td style="background-color:#F3F2F8;border-top:1px solid #E8EFF9;border-right:1px solid #E8EFF9;border-left:1px solid #E8EFF9;text-align:center;">Notify</td>
                         <td colspan="3"><input type="text" name="ntfy_cust_cnt_cd" style="width:30; ime-mode: disabled" dataformat="engup" maxlength="2" fullfill caption="Notify Country Code" class="input"><!--
                          -->
                         <input type="text" name="ntfy_cust_seq" style="width:60;text-align:right; ime-mode: disabled" dataformat="engup" maxlength="6" caption="Consignee Customer Seq." class="input"><!-- 
				 		  --><button type="button" class="btn_down_list" name="btn_cust_n" id="btn_cust_n"></button>
                         </td>
                    </tr>
                     <tr>
                     	 <th>Name</th>
                         <td colspan="3"><textarea name="ntfy_cust_nm" style="width:100%;overflow-y:hidden;resize:none" rows="2"></textarea></td>
                     </tr>
                     <tr>
                         <th>Address</th>
                         <td colspan="3"><textarea name="ntfy_cust_addr" style="width:100%;overflow-y:hidden;resize:none" rows="3"></textarea></td>
                     </tr>
					<tr>
						<th>City / State</th>
						<td><input type="text" name="ntfy_cust_cty_nm" style="width:210px;text-transform:uppercase;" class="input" value="" dataformat="exceptengdn" otherchar=" "  maxlength="30"/>
						<input type="text" name="ntfy_cust_ste_cd" style="width:30px;text-transform:uppercase;" class="input" value="" maxlength="2" dataformat="engup" /></td>
						<th>Country</th>
						<td><input type="text" name="ntfy_cstms_decl_cnt_cd" style="width:30px;text-transform:uppercase;" class="input" value="" maxlength="2" dataformat="engup"/></td>
					</tr>
					<tr>
						<th>Street / P.O.Box</th>
						<td><input type="text" name="ntfy_eur_cstms_st_nm" style="width:250px;text-transform:uppercase;" class="input" value="" dataformat="exceptengdn"  maxlength="50"/> </td>
						<th>ZIP Code</th>
						<td><input type="text" name="ntfy_cust_zip_id" style="width:74px;" class="input" value="" dataformat="engup" otherchar="-\s" maxlength="10"/></td>
					</tr>

                     <tr>
                         <th>Tel.</th>
                         <td><input type="text" name="ntfy_phn_no" style="width:100px;%;"  class="input" id="ntfy_phn_no" /> </td>
                         <th>Fax.</th>
                         <td><input type="text" name="ntfy_fax_no" style="width:100px;%;"  class="input" id="ntfy_fax_no" /> </td>
                    </tr>
				</tbody>
			</table>
		</div>
    </div>
    <div class="layout_vertical_2">
    	<div class="opus_design_inquiry pad_4">
			<table class="grid_2">
				<colgroup>
					<col width="80px" />
					<col width="50px" />
					<col width="50px" />
					<col width="50px" />
					<col width="50px" />
					<col width="50px" />
					<col width="*" />
				</colgroup>
				<tbody>
				 <tr>
                        <td style="background-color:#F3F2F8;border-top:1px solid #E8EFF9;border-right:1px solid #E8EFF9;border-left:1px solid #E8EFF9;text-align:center;">Consignee</td>
                        <td colspan="3"><input type="text" name="cnee_cust_cnt_cd" style="width:30; ime-mode: disabled" dataformat="engup" maxlength="2" fullfill caption="Consignee Country Code" class="input"><!-- 
                         --><input type="text" name="cnee_cust_seq" style="width:60;text-align:right; ime-mode: disabled" dataformat="engup" maxlength="6" caption="Consignee Customer Seq." class="input"><!-- 
				 		  --><button type="button" class="btn_down_list" name="btn_cust_c" id="btn_cust_c"></button>
				 		  </td>
                    </tr>
                    <tr>
                        <th>Name</th>
                        <td colspan="3"><textarea name="cnee_cust_nm" style="width:100%;overflow-y:hidden;resize:none" rows="2"></textarea></td>
                    </tr>
                    <tr>
                        <th>Address</th>
                        <td colspan="3"><textarea name="cnee_cust_addr" style="width:100%;overflow-y:hidden;resize:none" rows="3"></textarea></td>
                    </tr>
					<tr>
						<th>City / State</th>
						<td><input type="text" name="cnee_cust_cty_nm" style="width:210px;text-transform:uppercase;" class="input" value="" dataformat="exceptengdn" otherchar=" "  maxlength="30"/>
						<input type="text" name="cnee_cust_ste_cd" style="width:30px;text-transform:uppercase;" class="input" value="" maxlength="2" dataformat="engup" /></td>
						<th>Country</th>
						<td><input type="text" name="cnee_cstms_decl_cnt_cd" style="width:30px;text-transform:uppercase;" class="input" value="" maxlength="2" dataformat="engup"/></td>
					</tr>
					<tr>
						<th>Street / P.O.Box</th>
						<td><input type="text" name="cnee_eur_cstms_st_nm" style="width:250px;text-transform:uppercase;" class="input" value="" dataformat="exceptengdn"  maxlength="50"/> </td>
						<th>ZIP Code</th>
						<td><input type="text" name="cnee_cust_zip_id" style="width:74px;" class="input" value="" dataformat="engup" otherchar="-\s" maxlength="10"/></td>
					</tr>
                    <tr>
                        <th>Tel.</th>
                        <td><input type="text" name="cnee_phn_no" style="width:100px;%;"  class="input" id="cnee_phn_no" /> </td>
                        <th>Fax.</th>
                        <td><input type="text" name="cnee_fax_no" style="width:100px;%;"  class="input" id="cnee_fax_no" /> </td>
                    </tr>
				</tbody>
			</table>
		</div>
    </div>
</div>

	<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" style="display:none">
			<script type="text/javascript">ComSheetObject('t1sheet1');</script>
			<script type="text/javascript">ComSheetObject('t1sheet2');</script>
		</div>
	<!-- opus_design_grid(E) -->

</form>
</body>