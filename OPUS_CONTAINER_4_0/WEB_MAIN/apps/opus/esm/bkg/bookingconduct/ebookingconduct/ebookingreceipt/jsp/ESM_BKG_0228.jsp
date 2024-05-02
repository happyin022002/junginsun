<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0228.jsp
*@FileTitle  : e-Booking n SI Process
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
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg0228Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List" %>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO" %>
<%@ page import="com.clt.apps.opus.esm.bkg.common.*" %>
<%@ page import="com.clt.framework.core.controller.DefaultViewAdapter"%>

<%
	EsmBkg0228Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	Logger log = Logger.getLogger("com.clt.apps.EBookingConduct.EBookingReceipt");
	String sXml = null;
	StringBuffer fileDir = new StringBuffer();
	String home = System.getProperty("user.home");
	if (home !=null) fileDir.append(home);
	String separator = System.getProperty("file.separator");
	if (separator !=null) fileDir.append(separator);

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();	   
		event = (EsmBkg0228Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		// getting data from server when load the initial screen 
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		DefaultViewAdapter adapter = new DefaultViewAdapter();
		sXml = adapter.makeXML(request, response);	
	} catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
	var userOfc_cd = "<%=strOfc_cd%>";
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			// showErrorMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" value="<%=pageRows%>" type="hidden" />
<input type="hidden" name="sXml" id="sXml" value="<%=JSPUtil.replace(sXml, "\"", "&quot;")%>">
<input id="com_mrdPath" name="com_mrdPath" type="hidden" />
<input id="com_mrdArguments" name="com_mrdArguments" type="hidden" />
<input id="com_mrdBodyTitle" name="com_mrdBodyTitle" value="e-Booking &amp; SI Preview" type="hidden" />
<input id="com_zoomIn" name="com_zoomIn" value="3" type="hidden" />
<input id="usr_ofc_cd" name="usr_ofc_cd" value="<%=strOfc_cd%>" type="hidden" />
<input id="vvd2" name="vvd2" value="" type="hidden" />
<input id="vsl_nm2" name="vsl_nm2" value="" type="hidden" />
<input id="bkg_por_cd2" name="bkg_por_cd2" value="" type="hidden" />
<input id="por_nm2" name="por_nm2" value="" type="hidden" />
<input id="bkg_pol_cd2" name="bkg_pol_cd2" value="" type="hidden" />
<input id="pol_nm2" name="pol_nm2" value="" type="hidden" />
<input id="bkg_pod_cd2" name="bkg_pod_cd2" value="" type="hidden" />
<input id="pod_nm2" name="pod_nm2" value="" type="hidden" />
<input id="bkg_del_cd2" name="bkg_del_cd2" value="" type="hidden" />
<input id="del_nm2" name="del_nm2" value="" type="hidden" />
<input id="com_mrdSaveDialogDir" name="com_mrdSaveDialogDir" value="<%=fileDir.toString()%>" type="hidden" />
<input id="com_mrdSaveDialogFileName" name="com_mrdSaveDialogFileName" type="hidden" />
<input id="com_mrdSaveDialogFileExt" name="com_mrdSaveDialogFileExt" value="pdf" type="hidden" />
<input id="com_mrdSaveDialogFileExtLimit" name="com_mrdSaveDialogFileExtLimit" value="xls@pdf@bmp@tif" type="hidden" />
<input id="com_mrdTitle" name="com_mrdTitle" type="hidden" />
<input id="com_mrdDisableToolbar" name="com_mrdDisableToolbar" value="3" type="hidden" />
<input id="com_zoomIn" name="com_zoomIn" type="hidden" />
<input id="usr_id" name="usr_id" value="<%=strUsr_id%>" type="hidden" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
		  --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
		  --><button type="button" class="btn_normal" name="btn_exceldown" id="btn_exceldown">Down Excel</button>
<!-- 		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button> -->
<!-- 		<button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button> -->
<!-- 		<button type="button" class="btn_normal" name="btn_preview" id="btn_preview">Preview</button> -->
<!-- 		<button type="button" class="btn_normal" name="btn_previewprint" id="btn_previewprint">Multi Print</button> -->
<!-- 		<button type="button" class="btn_normal" name="btn_bkg_no_save" id="btn_bkg_no_save">BKG No Save</button> -->
<!-- 		<button type="button" class="btn_normal" name="btn_previewprint" id="btn_previewprint">Multi Print</button> -->
<!-- 		<button type="button" class="btn_normal" name="btn_bkg_no_save" id="btn_bkg_no_save">BKG No Save</button> -->
<!-- 		<button type="button" class="btn_normal" name="btn_upload" id="btn_upload">Upload</button> -->
<!-- 		<button type="button" class="btn_normal" name="btn_reject" id="btn_reject">Reject</button> -->
<!-- 		<button type="button" class="btn_normal" name="btn_delete" id="btn_delete">Delete</button> -->
<!-- 		<button type="button" class="btn_normal" name="btn_pending" id="btn_pending">Pending</button> -->
	</div>
	<!-- opus_design_btn(E) -->
	
	<!-- page_location(S) -->
	<div class="location"><span id="navigation"></span></div>
	<!-- page_location(E) -->
	
</div>
<!-- page_title_area(E) -->


<div class="wrap_search">
	<!-- inquiry_area(S) -->
	<div class="opus_design_inquiry wFit">   <!-- no TAB  -->
		<table> 
			<colgroup>
				<col width="10" />
				<col width="60" />
				<col width="200" />
				<col width="60" />
				<col width="150" />
				<col width="150" />
				<col width="150" />
				<col width="50" />
				<col width="100" />
				<col width="50" />
				<col width="150" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<td></td>
					<th>Request Date</th>
					<td><input type="text" style="width: 80px"  class="input1" name="rqst_from_dt" id="rqst_from_dt" caption="Request DT" dataformat="ymd" tabindex="1"><span class="dash">~</span><input type="text" style="width: 80px"  class="input1" name="rqst_to_dt"  id="rqst_to_dt" caption="Request DT" dataformat="ymd" tabindex="2"><button type="button" class="calendar ir" name="btns_calendar" id="btns_calendar"></button></td>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input type="text" style="width: 90px;" maxlength="9" dataformat="engup" class="input" name="vvd" id="vvd" value="" tabindex="3"></td>
					<th>Booking Agent Code</th>
					<td><input type="text" style="width: 30px;" maxlength="2" dataformat="engup" class="input" name="chn_agn_cd" id="chn_agn_cd" value="" tabindex="4"></td>
					<th>Lane</th>
		            <td><input type="text" size="3" style="width: 60px;ime-mode:disabled" dataformat="engup" name="lane"  id="lane" maxlength="3" value="" tabindex="5"></td>
					<th>Set Search</th>
					<td><button type="button" class="input_seach_btn" name="btn_SRCH_SET" id="btn_SRCH_SET"></button>&nbsp;<input type="checkbox" value="Y" name="set_slct_flg" id="set_slct_flg" class="trans" tabindex="6" id="chk1"><label for="chk1"></label></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<th>Request No.</th>
					<td><input type="text" style="width: 160px;" caption="Request No." class="input" maxlength="30" name="xter_rqst_no"  id="xter_rqst_no" value="" tabindex="11"><input type="text" style="width:22px;" class="input" name="xter_rqst_seq" id="xter_rqst_seq" maxlength="2" dataformat="int" value="" tabindex="12"></td>
					<th>Via</th>
					<td><script type="text/javascript">ComComboObject('xter_rqst_via_cd', 2, 147, '');</script></td>
					<th>Doc Type</th>
					<td><script type="text/javascript">ComComboObject('doc_tp_cd',2, 125, '');</script></td>  
					<th>Origin</th>
					<td><input type="text" style="width:30px;" maxlength="2" dataformat="engup" class="input" name="origin" id="origin" value="" tabindex="15"></td>
					<th>Delivery</th>
					<td><script type="text/javascript">ComComboObject('delivery',2, 108, '');</script></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<th>Booking No.</th>
					<td>
						<input type="text" style="width: 140px;" dataformat="engup" maxlength="13" class="input" name="bkg_no" id="bkg_no" value="" tabindex="20"/>
						Split&nbsp;<input type="checkbox" value="Y" name="split" id="split" class="trans" tabindex="6">
					</td> 
					<th>Request Status</th>
					<td><script type="text/javascript">ComComboObject('xter_bkg_rqst_sts_cd',2, 147, '');</script></td>
					<th>Handling Office</th>
					<td><input type="text" style="width: 85px;" class="input" dataformat="engup" name="hndl_ofc_cd" id="hndl_ofc_cd" maxlength="5" value="<%=strOfc_cd%>" tabindex="22"></td>
					<th title="Port of Loading">POL</th>
					<td><input type="text" style="width: 70px;" class="input" dataformat="engup" name="pol_cd" id="pol_cd" maxlength="5" value="" tabindex="23"></td>
					<th title="Port of Discharging">POD</th>
					<td><input type="text" style="width:70px;" class="input" dataformat="engup" name="pod_cd" id="pod_cd" maxlength="5" value="" tabindex="24"></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<th>P/O No.</th>
					<td><input type="text" style="width: 160px;" class="input" dataformat="engup" maxlength="30" name="po_no" id="po_no" value="" tabindex="30"></td>
					<th>Upload Status</th>
					<td><script type="text/javascript">ComComboObject('bkg_upld_sts_cd',2, 147, '');</script></td>
					<th>Upload Office</th>
					<td><input type="text" style="width: 85px;" class="input" name="ofc_cd"  id="ofc_cd" maxlength="5" dataformat="engup" value="" tabindex="32"></td>
					<th title="Place of Receipt">POR</th>
					<td><input type="text" style="width: 70px;" class="input" dataformat="engup" name="por_cd" id="por_cd"  maxlength="5" value="" tabindex="33"></td>
					<th title="Place of Delivery">DEL</th>
					<td><input type="text" style="width: 70px;" class="input" dataformat="engup" name="del_cd" id="del_cd" maxlength="5" value="" tabindex="34"></td>
					<td></td>
				</tr>	
			</tbody>
		</table>
		<table> 
			<colgroup>
				<col width="30" />
				<col width="60" />
				<col width="537" />
				<col width="70" />
				<col width="70" />
				<col width="68" />
				<col width="150" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<td></td>
					<th>Customer</th>
					<td><script type="text/javascript">ComComboObject('bkg_cust_tp_cd', 2, 57, 1, 0, 0)</script><input type="text" style="width: 30px;" class="input" dataformat="engup" maxlength="2" name="cust_cnt_cd" id="cust_cnt_cd" value="" tabindex="41"><input type="text" style="width: 60px;" class="input" dataformat="num" maxlength="6" name="cust_seq" id="cust_seq"  value=""  tabindex="42"><input type="text" style="width: 229px;" class="input" dataformat="engup" maxlength="500" name="cust_nm" id="cust_nm" value="" tabindex="43" otherchar=" " /></td>
					<th>EDI ID</th>
					<td><input type="text" style="width: 125px;" class="input" dataformat="engup" name="xter_sndr_id" id="xter_sndr_id" value="" tabindex="44"></td>
					<th>E-mail</th>
					<td><input type="text" style="width: 230px;" class="input" name="cntc_eml" id="cntc_eml"  value="" tabindex="45"></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- inquiry_area(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) --> 
	<div class="opus_design_grid">
	  	 <div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_reroute" id="btn_reroute">Reroute</button>
			<button type="button" class="btn_normal" name="btn_preview" id="btn_preview">Preview</button>
			<button type="button" class="btn_normal" name="btn_previewprint" id="btn_previewprint">MultiPrint</button>
			<button type="button" class="btn_normal" name="btn_bkg_no_save" id="btn_bkg_no_save">BKG No Save</button>
			<button type="button" class="btn_normal" name="btn_upload" id="btn_upload">Upload</button>
			<button type="button" class="btn_normal" name="btn_reject" id="btn_reject">Reject</button>
			<button type="button" class="btn_normal" name="btn_delete" id="btn_delete">Delete</button>
			<button type="button" class="btn_normal" name="btn_pending" id="btn_pending">Pending</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
</form>
<script language="javascript" for="sheet1" event="OnMouseMove(Button, Shift, X, Y)">
  Row = MouseRow;
  Col = MouseCol;
  if (Col == 29) {
	  sText = CellText(Row,"upld_usr_nm");
	  MouseToolTipText = sText
	  MousePointer = "Hand";
	  window.status = MousePointer;
  }
</script>