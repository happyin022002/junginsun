<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0540.jsp
*@FileTitle  : Entry Type Set-Up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.usa.event.EsmBkg0540Event"%>
<%@ page import="com.clt.syscommon.common.table.MdmCountryVO" %>
<%@ page import="com.clt.syscommon.common.table.MdmPortVO" %>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List" %>
<%
	EsmBkg0540Event  event = null;                    //PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id    = "";
	String strUsr_nm    = "";
	String strOfc_cd    = "";

	String strCustCode  = "";
	String strCreOfcCd  = "";
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");
	String mainPage = JSPUtil.getNull(request.getParameter("mainPage"));
	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EsmBkg0540Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// If you imported data from the server initialization when loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		strCustCode = JSPUtil.getNullNoTrim(request.getParameter("cust_cnt_cd"));
		strCustCode = strCustCode + JSPUtil.getNullNoTrim(request.getParameter("cust_seq"));
		strCreOfcCd = JSPUtil.getNullNoTrim(request.getParameter("ofc_cd"));

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script  type="text/javascript">
	var userOfficeCode = "<%=strOfc_cd%>";
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
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="usr_id" value="<%=strUsr_id%>" id="usr_id" />
<input type="hidden" name="strCustCntCd" id="strCustCntCd" />
<input type="hidden" name="strCustSeq" id="strCustSeq" />
<input type="hidden" name="strCmdtCd" id="strCmdtCd" />
<input type="hidden" name="strLocCd" id="strLocCd" />
<input type="hidden" name="strPod" id="strPod" />
<input type="hidden" name="strDel" id="strDel" />
<input type="hidden" name="strScNo" id="strScNo" />

<!-- page_title_area(S) -->
<% if (!mainPage.equals("true")) { %>
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Entry Type Setup ( ESM_BKG_0540 )</span></h2>
<%}else{%>
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
<% } %>

	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" 	 id="btn_Retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_New" 		 id="btn_New">New</button><!--
		--><button type="button" class="btn_normal" name="btn_Save" 	 id="btn_Save">Save</button><!--
		--><button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button><!--
		--><% if (!mainPage.equals("true")) { %><!--
		--><button type="button" class="btn_normal" name="btn_Close" 	id="btn_Close">Close</button>
		<% } %>
	</div>
<% if (!mainPage.equals("true")) { %>
	</div>
</div>
<%}else{%>
	<!-- opus_design_btn(E) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<% } %>
<!-- page_title_area(E) -->

<%if (!mainPage.equals("true")) { %><div class="layer_popup_contents"><%}%>
<!-- opus_design_inquiry(S) -->
<div class= "wrap_search">
	<div class= "opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="80"/>
					<col width="100"/>
					<col width="80"/>
					<col width="100"/>
					<col width="50"/>
					<col width="100"/>
					<col width="50"/>
					<col width="100"/>
					<col width="80"/>
					<col width="*"/>
				</colgroup>
				<tr>
					<th>Customer Code</th>
					<td><input type="text" name="cust_cd" id="cust_cd" style="width:70px; ime-mode: disabled;" class="input" value="<%=strCustCode%>" dataformat="engup" maxlength="8" caption="Customer Code"></td>
					<th>S/C No.</th>
					<td><input type="text" name="sc_no" id="sc_no" style="width:80px; ime-mode: disabled;" class="input" dataformat="engup" maxlength="9" caption="S/C No."></td>
					<th title="Port of Discharging">POD</th>
					<td><input type="text" name="pod_cd" id="pod_cd" style="width:80px; ime-mode: disabled;" class="input" dataformat="engup" maxlength="5" fullfill caption="POD"></td>
					<th title="Place of Delivery">DEL</th>
					<td><input type="text" name="del_cd" id="del_cd" style="width:80px; ime-mode: disabled;" class="input" dataformat="engup" maxlength="5" fullfill caption="DEL"></td>
					<th>Create Office</th>
					<td><input type="text" name="cre_ofc_cd" id="cre_ofc_cd" style="width:80px; ime-mode: disabled;" class="input" value="<%="".equals(strCreOfcCd) ? strOfc_cd : strCreOfcCd%>"  dataformat="engup" minlength="5" maxlength="6" caption="Create Office"></td>
				</tr>
				<tr>
					<th>Entry Type</th>
					<td><%=JSPUtil.getCodeCombo("etr_tp", "", "width:70;", "CD01597", 1, "")%></td>
					<th>FTZ</th>
					<td><select id="ftz_flg"name="ftz_flg" style="width:80px;" class="input"><option value="" selected>All</option><option value="Y">Yes</option><option value="N">No</option></select></td>
					<th >Commodity Code</th>
					<td colspan="5"><input type="text" name="cmdt_cd" id="cmdt_cd" style="width:80px; ime-mode: disabled;" class="input" dataformat="num" maxlength="6" fullfill caption="Commodity Code"></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->
<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid clear" >
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_RowAdd" id="btn_RowAdd">Row Add</button><!--
			--><button type="button" class="btn_normal" name="btn_Copy" 	id="btn_Copy">Row Copy</button><!--
			--><button type="button" class="btn_normal" name="btn_Delete" 	id="btn_Delete">Row Delete</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
<%if (!mainPage.equals("true")) { %></div><%}%>
<!-- opus_design_grid(E) -->
</form>
<!-- <script type="text/javascript">ComAddBeginComboItem(form.etr_tp,"All","") ComSetObjValue(form.etr_tp,'' );</script> -->