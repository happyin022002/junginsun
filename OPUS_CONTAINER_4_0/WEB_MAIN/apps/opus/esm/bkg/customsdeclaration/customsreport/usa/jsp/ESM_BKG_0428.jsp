<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0428.jsp
*@FileTitle  : US AMS: Receive History
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/01
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>

<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.event.EsmBkg0428Event"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Locale" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg0428Event  event 		= null;	//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag 	= "";
	String codeList  	= "";
	String pageRows  	= "1000";
	String strUsr_id	= "";
	String strUsr_nm	= "";

	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.CustomsReport");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0428Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// getting data from server when load the initial screen
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

<form name="form" method="post" value="">
<input type="hidden" name="f_cmd" value="">
<input type="hidden" name="pagerows" value=<%=pageRows%>>
<input type="hidden" name="vsl_cd" value="">
<input type="hidden" name="skd_voy_no" value="">
<input type="hidden" name="skd_dir_cd" value="">

<input type="hidden" name="msg_tp_id" value="">
<input type="hidden" name="vvd2" value="">
<input type="hidden" name="pol" value="">
<input type="hidden" name="pod" value="">
<input type="hidden" name="bl_no" value="">
<input type="hidden" name="batch_no" value="">
<input type="hidden" name="cnt_cd" value="">
<input type="hidden" name="io_bnd_cd" value="">
<input type="hidden" name="rcv_date"  value="">
<input type="hidden" name="rcv_seq" value="">


<!-- page_title_area(S) -->
<div class="page_title_area clear ">
	<!-- page_title(S) -->
	<h2 class="page_title">
		<button type="button">
			<span id="title"></span>
		</button>
	</h2>
	<!-- page_title(E) -->

	    <!-- opus_design_btn(S) -->
	    <div class="opus_design_btn">
	    <button type="button" class="btn_accent" name="btn_retrieve"  id="btn_retrieve">Retrieve</button>
		<button type="button" class="btn_normal" name="btn_new"       id="btn_new">New</button>
	    <button type="button" class="btn_normal" name="btn_view"      id="btn_view">View Receive File</button>
		<button type="button" class="btn_normal" name="btn_Downexcel" id="btn_Downexcel">Down Excel</button>
	    </div>
	    <!-- opus_design_btn(E) -->
    
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->

</div>
<!-- page_title_area(E) -->
	
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit" id="mainTable">
	    <table>
        	<colgroup>
	            <col width="70" />
	            <col width="70" />
	            <col width="140" />
	            <col width="70" />
	            <col width="100" />
	            <col width="50" />
	            <col width="94" />
	            <col width="290" />
	            <col width="*" />
        	</colgroup> 
			<tr>
				<th class="sm">MSG Type</th>
				<th title="Vessel Voyage Direction">VVD</th>
				<td><input type="text" style="width:80px; ime-mode: disabled" class="input" dataformat="engup" name="vvd" maxlength="9" fullfill caption="VVD"></td>
				<th title="Port of Loading">POL</th>
				<td><input type="text" style="width:60px; ime-mode: disabled" class="input" dataformat="engup" name="pol_cd" maxlength="5" fullfill caption="POL"></td>
				<th>Customs</th>
				<td><input type="text" style="width:60px; ime-mode: disabled" class="input" dataformat="engup" name="pod_cd" maxlength="5" fullfill caption="POD">
				<td class="sm"><input type="checkbox" name="gubun" id="gubun" class="trans"><strong>  Receive Date</strong></td>
				<td></td>
			</tr>
		</table>
		<table>
			<colgroup>
	            <col width="70" />
	            <col width="70" />
	            <col width="140" />
	            <col width="70" />
	            <col width="250" />
	            <col width="290" />
	            <col width="*" />
        	</colgroup>
			<tr>
				<td class="sm"><script type="text/javascript">ComComboObject('rcv_msg_tp_id', 2, 60, 1, 1);</script></td>			
				<th>B/L No.</th>
				<td><input type="text" style="width:112px; ime-mode: disabled" class="input" dataformat="engup" name="bl_nos"  caption="B/L No."></td> 
				<th>Batch No.</th>
				<td><input type="text" style="width:60px; ime-mode: disabled" class="input" dataformat="num" name="cstms_bat_no" maxlength="5" fullfill caption="Batch No."></td>
				<td class="sm"><input type="text" style="width: 75px; ime-mode: disabled" class="input1" value="" disabled required dataformat="ymd" name="fromd" id="fromd" maxlength="10" caption="Receive Date" cofield="tod"><input type="text" name="fromt" maxlength="5" style="width:40px" dataformat="hm" value="00:00" class="input1" disabled>~ <input type="text" style="width: 75px; ime-mode: disabled" class="input1" value="" disabled required dataformat="ymd" name="tod" id="tod" maxlength="10" caption="Receive Date" cofield="fromd"><input type="text" name="tot" maxlength="5" style="width:40px" dataformat="hm" value="23:59" class="input1" disabled><button class="calendar ir" name="btn_calendar" id="btn_calendar" type="button"></button></td>
				<td></td>
			</tr>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>	
	
<div class="wrap_result">	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
	    
	    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script type="text/javascript">ComSheetObject('sheet1');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>
