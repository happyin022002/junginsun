<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0152.jsp
*@FileTitle  : Delivery Mode
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/24
=========================================================
--%>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.china.event.EsmBkg0152Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0152Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strCnt_cd		= "";
	String strOfc_cd   = "";

	String strBtnChk = "";
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");

	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strCnt_cd = account.getCnt_cd();
		strOfc_cd = account.getOfc_cd();

		event = (EsmBkg0152Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// get data from server when load page ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		if(strCnt_cd.startsWith("CN")){  // local in china (except Hong Kong)
			if(strOfc_cd.startsWith("HKG")){
				strBtnChk = "N";
			}else{
				strBtnChk = "Y";
			}
		}
		else{
			strBtnChk = "N";
		}

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="btn_chk" value="<%=strBtnChk%>">
<input type="hidden" name="pgm_no" value="ESM_BKG_0152">

<!-- page(S) -->
<!-- page_title_area(S) -->
<div class="page_title_area clear">
<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button>
		<button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button>
		<button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button>
		<button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down&nbsp;Excel</button>
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<div class= "wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table>
			<colgroup>
				<col width="60px" />
				<col width="80px" />
				<col width="60px" />
				<col width="" />
			</colgroup>
			<tbody>
				<tr>
					<th title="Port of Discharging">POD</th>
					<td>
						<input type="text" style="width:60; ime-mode: disabled; text-align:center;" class="input" name="pod_cd" dataformat="engup" maxlength="5">
					</td>
					<th title="Place of Delivery">DEL</th>
					<td width="">
						<input type="text" style="width:60; ime-mode: disabled; text-align:center;" class="input" name="del_cd" dataformat="engup" maxlength="5">
					</td>
				</tr>
			</tbody>
		</table>
		<!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
</div>
	<!-- opus_design_inquiry(E) -->
<div class="wrap_result">
	<div class="opus_design_grid">
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_RowAdd" id="btn_RowAdd">Row Add</button>
			<button type="button" class="btn_normal" name="btn_Delete" id="btn_Delete">Row Delete</button>
		</div>
		<!-- opus_design_btn(E) -->
		<script language="javascript">ComSheetObject('sheet1');</script>
	</div>
</div>

</form>
