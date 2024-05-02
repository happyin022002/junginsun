<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0127.jsp
*@FileTitle  : ESM_BKG_0127 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/09
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.brazil.event.EsmBkg0127Event"%>

<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0127Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.opus.CustomsDeclarationBrazil.BrcsCustomsTransmission");

	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmBkg0127Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
	}catch(Exception e) {
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
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="brz_cmdt_cd" id="brz_cmdt_cd" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		 <button class="btn_normal" name="btn_delete" id="btn_delete" type="button" style="display:none">Data Delete</button><!--  
		 --><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_datadl" id="btn_datadl">Data DownLoad</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_transmit" id="btn_transmit">Transmit</button><!-- 
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
 		 <col width="55">
		 <col width="100">
         <col width="60">
         <col width="50">
         <col width="30">
         <col width="50">
         <col width="30">
         <col width="123">
         <col width="100">
         <col width="150">
         <col width="90">
         <col width="*">          
        </colgroup>
			<tr>
				<th title="Vessel Voyage Direction">VVD</th>
				<td><input type="text" style="width:100px;ime-mode: disabled" class="input1" name="vvd_cd" dataformat="engup" maxlength="9" fullfill="" caption="VVD" id="vvd_cd" /></td>
				<th title="Port of Loading">POL</th>
				<td><input type="text" style="width:50px;ime-mode: disabled" class="input" name="pol_cd" value="" dataformat="engup" caption="POL" fullfill="" maxlength="5" id="pol_cd" /></td>
				<th title="Port of Discharging">POD</th>
				<td><input type="text" style="width:50px;ime-mode: disabled" class="input" name="pod_cd" dataformat="engup" caption="POD" fullfill="" maxlength="5" id="pod_cd" /></td>
				<th title="Place of Delivery">DEL</th>
				<td><input type="text" style="width:50px;ime-mode: disabled" class="input" name="del_cd" dataformat="engup" caption="DEL" fullfill="" maxlength="5" id="del_cd" /></td>
				<td class =  "sm pad_left_4">
					<input type="radio" name="io_type" value="O" checked class="trans" id="io_type" /><label for = "io_type"><strong>O/B</strong></label>
					<input type="radio" name="io_type" value="I" class="trans" id="io_type1" /><label for = "io_type1"><strong>I/B</strong></label>
					<input type="hidden" name="search_io_type" value="" id="search_io_type" />
				</td>
				<td class =  "sm pad_left_12">
					<input type="radio" name="error_type" value="1" checked class="trans" id="error_type" /><label for = "error_type"><strong>All</strong></label>
					<input type="radio" name="error_type" value="2" class="trans" id="error_type1" /><label for = "error_type1"><strong>Error B/L</strong></label>
				</td>
				<th>Cargo Type</th>
	     		<td>
	     			<select name="bkg_cgo_tp_cd" id="bkg_cgo_tp_cd" style="width:60px">
		                <option>All</option>
		                <option value="F" selected>Full</option>
		                <option value="P">Empty</option>
		            </select>
				</td>
			</tr>
		</table>
		<table>
	    	<colgroup>
		 		 <col width="55">
				 <col width="100">
		         <col width="60">
		         <col width="60">
		         <col width="68">
		         <col width="60">
		         <col width="90">
		         <col width="*">           
	        </colgroup>
				<tr>
					<th>B/L No.</th>
					<td><input type="text" style="width:100px;ime-mode: disabled" class="input1" name="bl_no" dataformat="engup" maxlength="12" id="bl_no" /></td>
					<th>CNPJ No.</th>
					<td><input type="text" style="width:100px;ime-mode: disabled" class="input" name="cnpj_no" dataformat="engup" caption="CNPJ No." fullfill="" maxlength="14" id="cnpj_no" /></td>
					<th>DUV</th>
					<td><input type="text" style="width:100px;ime-mode: disabled" class="input" name="br_duv" dataformat="engup" caption="DUV" fullfill="" maxlength="10" id="br_duv" /></td>
					<th>Manifest ID</th>
					<td><input type="text" style="width:105px;ime-mode: disabled" class="input" name="br_mid" dataformat="engup" caption="Manifest ID" fullfill="" maxlength="13" id="br_mid" /></td>
				</tr>
		</table>
	</div>
</div>
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
	    <script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
<!-- opus_design_inquiry(E) -->
</form>
