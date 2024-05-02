<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0574.jsp
*@FileTitle  : Auto Filing NVOCC Transmission Status
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>


<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page
	import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page
	import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page
	import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page
	import="com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.event.EsmBkg0574Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0574Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	//int rowCount	 = 0;						//count of DB resultSET list

	//String successFlag = "";
	//String codeList = "";
	//String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	//Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0574Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		// 
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
		} // end if
		loadPage();
	}
</script>



<form name="form"><input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows"> 
<input type="hidden" name="vsl_cd"> 
<input type="hidden" name="skd_voy_no"> 
<input type="hidden" name="skd_dir_cd"> 

<!-- page_title_area(S) -->
<div class="page_title_area clear">

   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" 	id="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_DownExcel" 	id="btn_DownExcel">Down Excel</button><!--
		--><button type="button" class="btn_normal" name="btn_nvoccscac" 	id="btn_transmit">NVOCC SCAC</button>
	</div>
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
<div class="opus_design_inquiry">
		<table>
			<colgroup>
	            <col width="30" />
	            <col width="130" />
	            <col width="50" />
	            <col width="90" />
	            <col width="50" />
	            <col width="90" />
	            <col width="50" />
	            <col width="90" />
	            <col width="50" />
	            <col width="130" />
	            <col width="50" />
	            <col width="130" />
	            <col width="*" />
	        </colgroup>  
			<tbody>
				<tr>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input type="text" name="vvd" style="width:90px; 
						ime-mode: disabled;" class="input1" dataformat="engup" maxlength="9" fullfill required caption="VVD"></td>
					<th title="Port of Discharging">POD</th>
					<td><input type="text" name="pod" style="width:60px;ime-mode: disabled" class="input1" dataformat="engup" maxlength="5" fullfill onBlur='call_ams_pod();' required caption="POD"></td>
					<th>AMS POD</th>
					<td><input type="text" name="ams_pod" style="width:60px;ime-mode: disabled" class="input2" readonly></td>
					<th>SCAC</th>
					<td><input type="text" name="scac" style="width:60px;ime-mode: disabled" class="input" dataformat="engup" maxlength="4"></td>
					<th>M.B/L No.</th>
					<td><input type="text" name="mbl" style="width:100px;ime-mode: disabled" class="input" dataformat="engup" maxlength="12"></td>
					<th>H.B/L No.</th>
					<td><input type="text" name="hbl" style="width:100px;ime-mode: disabled" class="input" dataformat="engup" maxlength="20"></td>
					
					<td><input type="checkbox" name="err" class="trans"> Error</td>
				</tr>
			</tbody>
		</table>
</div>
</div>
<!-- opus_design_inquiry(E) -->
<div class="wrap_result">
<!-- opus_design_grid(S) -->
<div class="opus_design_grid">
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
</div>
<!-- opus_design_grid(E) -->	
</form>