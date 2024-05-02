<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_BKG_1033.jsp
*@FileTitle  : Bangladesh Cargo Manifest
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/17
=========================================================*/
%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.bangladesh.event.EsmBkg1033Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg1033Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id	= "";
	String strUsr_nm	= "";
	String strCnt_cd	= "";
	String strOfc_cd	= "";

	String strBtnChk = "";

	String strPgmNo		= "";
	//boolean saveCsvFlg  = false;  // Save CSV button valid checking
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");

	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strCnt_cd = account.getCnt_cd();
		strOfc_cd = account.getOfc_cd();

		event = (EsmBkg1033Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		strPgmNo = JSPUtil.getParameter(request, "pgmNo");
		//strTransMode = event.getTransMode();

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script language="javascript">
	var pgmno= "<%=strPgmNo.substring(13)%>";
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
<input type="hidden" name="pgm_no" value="<%=strPgmNo%>">
<input type="hidden" name="io_flag">
<input type="hidden" name="data_flag">

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!--
		 --><button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
		 --><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!--
		 --><button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button><!--
		 --><button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button><!--
		 --><button type="button" class="btn_normal" name="btn_PopUp" id="btn_PopUp">Freight Forward License</button><!--
		 --><button type="button" class="btn_normal" name="btn_Transmit" id="btn_Transmit">EDI Transmit</button><!--
	 --></div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->
<div class= "wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class= "opus_design_inquiry wFit">
		<table>
		<colgroup>
		   <col width="165" />
		   <col width="60" />
		   <col width="100" />
		   <col width="50" />
		   <col width="100" />
		   <col width="62" />
		   <col width="100" />
		   <col width="215" />
		   <col width="90" />
		   <col width="*" />
		  </colgroup>
				<tr>
				<td>
					<table class="sm">
					<tr>
					<th>Data</th>
					<td><input type="radio" name="data_type" value="B" class="trans" checked>&nbsp;&nbsp;B/L List&nbsp;
						<input type="radio" name="data_type" value="D" class="trans">D/L List</td>
					</tr>
					</table>
				</td>
				<th>VVD</th>
				<td><input type="text" style="width:90px;ime-mode:disabled" class="input1" name="vvd" dataformat="engup" maxlength="9" required caption="VVD"></td>
				<th>POL</th>
				<%
					if(strPgmNo.endsWith("01")){
				%>
					<td><input type="text" style="width:50px;ime-mode:disabled" class="input1" name="pol_code" dataformat="engup" maxlength="5" required caption="POL"><!--
					 --><input type="text" style="width:30px;ime-mode:disabled" class="input" name="pol_yd" dataformat="engup" maxlength="2" caption="pol_yd"></td>
				<%
					}else{
				%>
					<td><input type="text" style="width:50px;ime-mode:disabled" class="input" name="pol_code" dataformat="engup" maxlength="5" caption="pol_cd"><!--
					 --><input type="text" style="width:30px;ime-mode:disabled" class="input" name="pol_yd" dataformat="engup" maxlength="2" caption="pol_yd"></td>
				<%  }
				%>
				<th>POD</th>
				<%
					if(strPgmNo.endsWith("01")){
				%>
					<td><input type="text" style="width:50px;ime-mode:disabled" class="input" name="pod_code" dataformat="engup" maxlength="5" caption="pod_cd"><!--
					 --><input type="text" style="width:30px;ime-mode:disabled" class="input" name="pod_yd" dataformat="engup" maxlength="2" caption="pod_yd"></td>
				<%
					}else{
				%>
					<td><input type="text" style="width:50px;ime-mode:disabled" class="input1" name="pod_code" dataformat="engup" maxlength="5" required caption="POD"><!--
					 --><input type="text" style="width:30px;ime-mode:disabled" class="input" name="pod_yd" dataformat="engup" maxlength="2" caption="pod_yd"></td>
				<%  }
				%>
				<td>
					<table class="sm">
					<tr>
					<th>Cargo Type</th>
					<td><input type="radio" name="bkg_cgo_tp_code" value="A" class="trans">All&nbsp;
						<input type="radio" name="bkg_cgo_tp_code" value="F" class="trans" checked>Full&nbsp;
						<input type="radio" name="bkg_cgo_tp_code" value="P" class="trans">&nbsp;Empty</td>
					</tr>
					</table>
				</td>
				<th>B/L No.</th>
				<td><input type="text" style="width:100px;ime-mode:disabled" class="input" name="bl_no" dataformat="eng" maxlength="13" caption="bl_no"></td>
				</tr>
				</table>

				<table class="">
					 <col width="10" />
					 <col width="30" />
					 <col width="108" />
					 <col width="30" />
					 <col width="109" />
					 <col width="30" />
					 <col width="99" />
					 <col width="95" />
					 <col width="90" />
					 <col width="82" />
					 <col width="*" />
				  </colgroup>
				<tr>
				<th>Sailed Year</th>
				<td>
				<input type="text" style="width:80px;ime-mode:disabled" name="sail_dt" dataformat="ymd" class="input" maxlength="10"><!--
					 --><button type="button" class="calendar" name="btn_Sailed" id="btn_Sailed"></button>
				</td>
				<td>
					<button type="button" class="btn_etc" name="btn_Assign" id="btn_Assign">Assign</button>
				</td>
				<th>Vessel Name</th>
				<td><input type="text" style="width:90px;ime-mode:disabled" class="input" name="vsl_nm" dataformat="engup" caption="vsl_nm" disabled></td>
				<th>Voy. No.</th>
				<td><input type="text" style="width:40px" class="input" name="voy_no" catpion="voy_no" disabled></td>
				<%
					if(strPgmNo.endsWith("01")){
				%>
					<th>Export Rot Number</th>
				<%
					}else{
				%>
					<th>Import Rot Number</th>
				<%  }
				%>
				<td><input type="text" style="width:100px;ime-mode:disabled" class="input" name="rot_no" maxlength="14" caption="rot_no"></td>
				<th>MLO Code</th>
				<td><input type="text" style="width:90px;ime-mode:disabled" lass="input" name="mlo_cd" dataformat="eng" maxlength="11" caption="mlo_cd"></td>
				</tr>
			</table>
	</div>
</div>
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<%
			if(strPgmNo.endsWith("01")){
		%>
			<!-- Mode Outbound ====================-->
				<!-- Grid  (S) -->
					<script language="javascript">ComSheetObject('sheet2');</script>
					<script language="javascript">ComSheetObject('sheet4');</script>
				<!-- Grid (E) -->
		<%
			} else {
		%>
			<!-- Mode Inbound  ====================-->
				<!-- Grid  (S) -->
					<script language="javascript">ComSheetObject('sheet1');</script>
					<script language="javascript">ComSheetObject('sheet3');</script>
				<!-- Grid (E) -->
		<%  }
		%>
	</div>
	<!-- opus_design_grid(E) -->
</div>
<!-- opus_design_inquiry(E) -->
</form>


<iframe name="download" id="download" style="display:none;width:1px;height:1px;"></iframe>
