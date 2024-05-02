<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0456.jsp
*@FileTitle  : ESM_BKG-0456
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/26
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.event.EsmBkg0456Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0456Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //error from server
	String strErrMsg = ""; //error message
	//int rowCount = 0; //count of DB resultSET list

	//String successFlag = "";
	//String codeList = "";
	//String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	//Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0456Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// getting data from server when load the initial screen
		//GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		}
		loadPage();
	}
</script>

<form name="form">
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />

<!-- 개발자 작업 -->
<!-- popup_title_area(S) -->
<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Manifest Registration(MFR)_Customer Info</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button><!--
		 --><button type="button" class="btn_normal"  name="btn_close" id="btn_close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->
	</div>
	<!-- page_title_area(E) -->
</div>
<!-- popup_title_area(E) -->

<!-- popup_contens_area(S) -->
<div class="layer_popup_contents">
<input id="cust_type" name="cust_type" type="hidden" />
<input id="form1_bl_number" name="form1_bl_number" type="hidden" />
<input type="hidden" name="bl_number" id="bl_number" value="<%=JSPUtil.getParameter(request, "bl_no")%>">
<input type="hidden" name="form1_vvd_cd" id="form1_vvd_cd">
<input type="hidden" name="vvd_cd" id="vvd_cd" value="<%=JSPUtil.getParameter(request, "vvd_cd")%>">
<input type="hidden" name="form1_pod_cd" id="form1_pod_cd">
<input type="hidden" name="pod_cd" id="pod_cd" value="<%=JSPUtil.getParameter(request, "pod_cd")%>">


	<!-- wrap_search(S) -->
	<div class= "wrap_search">
		<div class= "opus_design_inquiry wFit">
			<h3 class="title_design">Customer  Information</h3>
			<table>
				<tbody>
					<colgroup>
						<col width="80"/>
						<col width="80"/>
						<col width="80"/>
						<col width="80"/>
						<col width="80"/>
						<col width="*"/>
					</colgroup>
					<tr>
						<th>Shipper</th>
						<td><input type="text" style="width:30px;" dataformat="engup" name="form1_cust_cnt_cd" maxlength="2" dataformat="engup">&nbsp;<input type="text" dataformat="num2" style="width:100px;text-align:right" name="form1_cust_seq" maxlength="6">&nbsp;<img class="cursor" src="img/btns_inquiry.gif" width="19px" height="20px" border="0" name="btn_cust" align="absmiddle"></td>
						<th>Tel.</th>
						<td><input type="text" style="width:100px;" dataformat="num" maxlength="20" name="form1_phn_no"></td>
						<th>Fax</th>
						<td><input type="text" style="width:155px;" dataformat="num" maxlength="20" name="form1_fax_no"></td>
					</tr>
				</tbody>
			</table>
			<table>
				<tbody>
					<colgroup>
						<col width="80"/>
						<col width="80"/>
						<col width="60"/>
						<col width="*"/>
					</colgroup>
					<tr>
						<th>Name</th>
						<td><textarea  rows="3" dataformat="engupetc" maxlength="500" name="form1_cust_nm" style="resize:none;width:183px"></textarea></td>
						<th>Address</th>
						<td><textarea  rows="3" dataformat="engupetc" maxlength="500" name="form1_cust_addr" style="resize:none; width:342px"></textarea></td>
					</tr>
				</tbody>
			</table>
			<table class="line_bluedot"><tr><td></td></tr></table>
			<table>
				<tbody>
					<colgroup>
						<col width="80"/>
						<col width="80"/>
						<col width="80"/>
						<col width="80"/>
						<col width="80"/>
						<col width="*"/>
					</colgroup>
					<tr>
						<th>Consignee</th>
						<td><input type="text" style="width:30px;" dataformat="engup" name="form1_cust_cnt_cd2" maxlength="2" dataformat="engup">&nbsp;<input type="text" dataformat="num2" style="width:100px;text-align:right" name="form1_cust_seq2" maxlength="6">&nbsp;<img class="cursor" src="img/btns_inquiry.gif" width="19px" height="20px" border="0" name="btn_cust2" align="absmiddle"></td>
						<th>Tel.</th>
						<td><input type="text" style="width:100px;" dataformat="num" maxlength="20" name="form1_phn_no2"></td>
						<th>Fax</th>
						<td><input type="text" style="width:155px;" dataformat="num" maxlength="20" name="form1_fax_no2"></td>
					</tr>
				</tbody>
			</table>

			<table>
				<tbody>
					<colgroup>
						<col width="80"/>
						<col width="80"/>
						<col width="60"/>
						<col width="*"/>
					</colgroup>
					<tr>
						<th>Name</th>
						<td><textarea rows="3" dataformat="engupetc" maxlength="500" name="form1_cust_nm2" style="resize:none;width:183px"></textarea></td>
						<th>Address</th>
						<td><textarea  rows="3" dataformat="engupetc" maxlength="500" name="form1_cust_addr2" style="resize:none;width:342px"></textarea></td>
					</tr>
				</tbody>
			</table>
			<table class="line_bluedot"><tr><td></td></tr></table>
			<table>
				<tbody>
					<colgroup>
						<col width="80"/>
						<col width="80"/>
						<col width="80"/>
						<col width="80"/>
						<col width="80"/>
						<col width="*"/>
					</colgroup>
					<tr>
						<th>Notify</th>
						<td><input type="text"  dataformat="engup" name="form1_cust_cnt_cd3" style="width:30px;" maxlength="2" dataformat="engup">&nbsp;<input type="text" dataformat="num2" style="width:100px;text-align:right" name="form1_cust_seq3" maxlength="6">&nbsp;<img class="cursor" src="img/btns_inquiry.gif" width="19px" height="20px" border="0" name="btn_cust3" align="absmiddle"></td>
						<th>Tel.</th>
						<td><input type="text" dataformat="num" maxlength="20" name="form1_phn_no3" style="width:100px;"></td>
						<th>Fax</th>
						<td><input type="text" dataformat="num" maxlength="20" name="form1_fax_no3" style="width:155px;"></td>
					</tr>
				</tbody>
			</table>
			<table>
				<tbody>
					<colgroup>
						<col width="80"/>
						<col width="80"/>
						<col width="60"/>
						<col width="*"/>
					</colgroup>
					<tr>
						<th>Name</th>
						<td><textarea rows="3" dataformat="engupetc" maxlength="500" name="form1_cust_nm3" style="width:183px; resize:none"></textarea></td>
						<th>Address</th>
						<td><textarea  rows="3" dataformat="engupetc" maxlength="500"name="form1_cust_addr3" style="width:342px; resize:none"></textarea></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<!-- wrap_search(E) -->
</div>

<!-- hidden wrap_result(S) -->
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject("sheet1");</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
<!-- hidden wrap_result(E) -->

</form>
