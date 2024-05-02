<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   :ESM_BKG_0745.jsp
*@FileTitle  : ESM_BKG_0745 
*@author     : CLT
*@version    : 1.0
*@since      : 
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page
	import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page
	import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page
	import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page
	import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.brazil.event.EsmBkg0745Event"%>

<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0745Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //error from server
	String strErrMsg = ""; //error message
	int rowCount = 0; //count of DB resultSET list

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger
			.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");

	String ncmNo = "";

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		// parent window parameter setting
		ncmNo = (request.getParameter("ncm_no") == null) ? "" : request
				.getParameter("ncm_no");

		event = (EsmBkg0745Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		// If you imported data from the server initialization when loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request
				.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>


<script type="text/javascript">
	function setupPage() {
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end i
		loadPage();
	}
</script>
<form name="form">
	<input type="hidden" name="f_cmd"> 
	<input type="hidden" name="pagerows">
		<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	
	   <!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E)-->

		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
			--><button type="button" class="btn_normal" name="btn_Save"  	id="btn_Save">Save</button><!--
			--><button type="button" class="btn_normal" name="btn_DownExcel" 	id="btn_DownExcel">Down Excel</button>	
		</div>
		<!-- opus_design_btn(E) -->
	
		<!-- page_location(S) -->
		<div class="location">
			<!-- location ?? ???? (?? ?? ???) -->
			<span id="navigation"></span>
		</div>
	</div>
	
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->		
	<div class="opus_design_inquiry">
	<!--  biz_1 (S) -->
	<table>
	<colgroup>
	<col width="140"></col>
	<col width="120"></col>
	<col width="140"></col>
	<col width="*"></col>
	</colgroup>
		<tr>
			<th>Harmonized Tariff Code</th>
			<td><input type="text" name="brz_cmdt_cd" id="brz_cmdt_cd" style="width: 80px;" class="input" value="<%=StringUtil.xssFilter(ncmNo)%>"
			dataformat="engup" maxlength="8" caption="NCM(Harmonized Tariff Code)"></td>
			<th>Including Deleted Code</th>
			<td><input type="checkbox" name="del_check" class="input"></td>
		</tr>
		<tr>
			<th >Description</th>
			<td colspan="3"><input type="text" name="cmdt_desc" id="cmdt_desc" style="width: 600px;" class="input" maxlength="36px" caption="Description"></td>
			
		</tr>
	</table> 
<!--  biz_1   (E) -->
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
	 	<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn2_RowAdd" id="btn2_RowAdd">Row Add</button><!--  
			--><button type="button" class="btn_normal" name="btn2_Delete" 	id="btn2_Delete">Row Delete</button>
		</div> 
		<script type="text/javascript">ComSheetObject('sheet1');</script>											
	</div>
	<!-- opus_design_grid(S) -->
</div>			
</form>