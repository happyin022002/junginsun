<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0034_02.jsp
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
	Exception serverException = null; //error from server
	String strErrMsg = ""; //error message
	int rowCount = 0; //count of DB resultSET list

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

		// getting data from server when load the initial screen
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
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" value="<%=pageRows %>" id="pagerows" />
<input type="hidden" name="fwdr_ibflag" id="fwdr_ibflag" />
<input type="hidden" name="antf_ibflag" id="antf_ibflag" />
<input type="hidden" name="tab_no" value="2" id="tab_no" />
<input type="hidden" name="bl_no" id="bl_no" />
<input type="hidden" name="fwdr_bkg_cust_tp_cd" value="F" id="fwdr_bkg_cust_tp_cd" />
<input type="hidden" name="antf_bkg_cust_tp_cd" value="A" id="antf_bkg_cust_tp_cd" />
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
	                    <th>F/Forward</th>
                        <td colspan="3">
                        <input type="text" name="fwdr_cust_cnt_cd" style="width:30; ime-mode: disabled"dataformat="engup" maxlength="2" fullfill caption="F/Fowarder Country Code" class="input"><!-- 
                         -->
                        <input type="text" name="fwdr_cust_seq" style="width:60;text-align:right; ime-mode: disabled"dataformat="engup" maxlength="6" caption="F/Fowarder Customer Seq." class="input"><!-- 
				 		  --><button type="button" class="btn_down_list" name="btn_cust_f" id="btn_cust_f"></button>
                        </td>
	                </tr>
	                <tr>
	                    <th>Name</th>
	                    <td colspan="3"><textarea name="fwdr_cust_nm" id="fwdr_cust_nm" style="width:100%;overflow-y:hidden;resize:none" rows="2"></textarea></td>
	                </tr>
	                <tr>
	                    <th>Address</th>
	                    <td colspan="3"><textarea name="fwdr_cust_addr" id="fwdr_cust_addr" style="width:100%;overflow-y:hidden;resize:none" rows="3"></textarea></td>
	                </tr>
	                <tr>
	                    <th>Tel.</th>
	                    <td><input type="text" name="fwdr_phn_no" style="width:100px;" class="input" id="shpr_phn_no" /> </td>
	                    <th>Fax.</th>
	                    <td><input type="text" name="fwdr_fax_no" style="width:100px;" class="input" id="shpr_fax_no" /> </td>
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
                         <th>A/Notify</th>
                         <td colspan="3">
                         <input type="text" name="antf_cust_cnt_cd" style="width:30; ime-mode: disabled" dataformat="engup" maxlength="2" fullfill caption="A/Notify Country Code" class="input"><!-- 
                          --><input type="text" name="antf_cust_seq" style="width:60;text-align:right; ime-mode: disabled" dataformat="engup" maxlength="6" caption="A/Notify Customer Seq." class="input"><!-- 
				 		  --><button type="button" class="btn_down_list" name="btn_cust_a" id="btn_cust_a"></button>
                          </td>
                    </tr>
                     <tr>
                     	 <th>Name</th>
                         <td colspan="3"><textarea name="antf_cust_nm" style="width:100%;overflow-y:hidden;resize:none" rows="2"></textarea></td>
                     </tr>
                     <tr>
                         <th>Address</th>
                         <td colspan="3"><textarea name="antf_cust_addr" style="width:100%;overflow-y:hidden;resize:none" rows="3"></textarea></td>
                     </tr>

                     <tr>
                         <th>Tel.</th>
                         <td><input type="text" name="antf_phn_no" style="width:100px;" class="input" id="antf_phn_no" /> </td>
                         <th>Fax.</th>
                         <td><input type="text" name="antf_fax_no" style="width:100px;" class="input" id="antf_fax_no" /> </td>
                    </tr>
				</tbody>
			</table>
		</div>
    </div>
</div>

<!-- opus_design_grid(S) -->
 <div class="opus_design_grid" style="display:none">
		<script type="text/javascript">ComSheetObject('t2sheet1');</script>
		<script type="text/javascript">ComSheetObject('t2sheet2');</script>
</div>
	<!-- opus_design_grid(E) -->

</form>
