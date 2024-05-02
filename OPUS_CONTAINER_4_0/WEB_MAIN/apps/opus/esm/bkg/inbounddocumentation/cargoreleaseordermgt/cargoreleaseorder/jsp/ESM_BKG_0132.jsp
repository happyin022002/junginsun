<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0132.jsp
*@FileTitle  : Cargo Release Order_E-D/O inquiry _Main
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/25
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0132Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0132Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from the server
	String strErrMsg = "";						//error messege
	int rowCount	 = 0;						//the number of DB ResultSet List
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.InboundBLMgtSC.FullReleaseOrderBC");
	String mainPage   = "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		mainPage = JSPUtil.getNull(request.getParameter("mainPage"));
	   
		event = (EsmBkg0132Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// extract additional data obtained from the server during Initial loading ..
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
		
	/* 	$('<button type="button" class="btn_accent" name="btn_Retrieve"	 id="btn_Retrieve">Retrieve</button>').appendTo("#btnArea");
        $('<button type="button" class="btn_normal" name="btn_delete"  	 id="btn_delete">Delete</button>').appendTo("#btnArea");
        $('<button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>').appendTo("#btnArea");
        $('<button type="button" class="btn_normal" name="btn_cargo"   	 id="btn_cargo">Cargo Release</button>').appendTo("#btnArea");
        $('<button type="button" class="btn_normal" name="btn_do"   	 id="btn_do">D/O Application Specification</button>').appendTo("#btnArea");
        $('<button type="button" class="btn_normal" name="btn_jaga"   	 id="btn_jaga">Self transport Specification</button>').appendTo("#btnArea");
        $('<button type="button" class="btn_normal" name="btn_Retrieve2" id="btn_Retrieve2">Self transportation D/L</button>').appendTo("#btnArea");
        $('<button type="button" class="btn_normal" name="btn_bose"   	 id="btn_bose">transport Specification</button>').appendTo("#btnArea");
        $('<button type="button" class="btn_normal" name="btn_check"   	 id="btn_check">Check Error</button>').appendTo("#btnArea"); */
		
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<%-- <%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp"%> --%>

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<%if (!"true".equals(mainPage)){%>
	<h2 class="page_title"><button type="button"><span id="title">Korea e-D/O Inquiry</span></button></h2>
	<%}else{%>
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<%}%>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
	<button type="button" id="btn_Retrieve" name="btn_Retrieve" class="btn_accent">Retrieve</button><!--
	--><button type="button" id="btn_delete" name="btn_delete" class="btn_normal">Delete</button><!--
	--><button type="button" id="btn_downexcel" name="btn_downexcel" class="btn_normal">Down Excel</button><!--
	--><button type="button" id="btn_cargo" name="btn_cargo" class="btn_normal">Cargo Release</button><!--
	--><button type="button" id="btn_do" name="btn_do" class="btn_normal">D/O Application Specification</button><!--
	--><button type="button" id="btn_jaga" name="btn_jaga" class="btn_normal">Self transport Specification</button><!--
	--><button type="button" id="btn_Retrieve2" name="btn_Retrieve2" class="btn_normal">Self transportation D/L</button><!--
	--><button type="button" id="btn_bose" name="btn_bose" class="btn_normal">transport Specification</button><!--
	--><button type="button" id="btn_check" name="btn_check" class="btn_normal">Check Error</button><!--
	--><%if (!"true".equals(mainPage)){%><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button><%}%><!--
	--></div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
	
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">		
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
	    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <table>
			 <colgroup>
		    	 <col width="85" />
		         <col width="260" />
		         <col width="95" />
		         <col width="80" />
		         <col width="40" />
		         <col width="90" />
		         <col width="27" />
		         <col width="102" />
		         <col width="87" />
		         <col width="*" />	            
		     </colgroup>
		     <tr>
				<th>Request Date</th>
				<td><input id="edo_rqst_dt_s" name="edo_rqst_dt_s" style="width:80px;" class="input1" value="" caption="Request Date(From)" dataformat="ymd" type="text" />~ <input id="edo_rqst_dt_e" name="edo_rqst_dt_e" style="width:80px;" class="input1" value="" caption="Request Date(To)" dataformat="ymd" type="text" /><button class="calendar ir" name="btns_calendar2" id="btns_calendar2" type="button"></button></td>
				<th>Handling Office</th>
				<td><input id="hndl_ofc_cd" name="hndl_ofc_cd" style="width:60px;" class="input" value="" maxlength="6" dataformat="engup" type="text" /> </td>
				<th>The place of receipt</th>
				<td><input id="edo_rct_loc_cd" name="edo_rct_loc_cd" style="width:60px;" class="input" value="<%=JSPUtil.getNull(request.getParameter(" edo_rct_loc_cd")) %>" type="text" maxlength="5" dataformat="engup" style="ime-mode:disabled"></td>
				<th title="Port of Discharging">POD</th>
				<td><input id="pod_cd" name="pod_cd" style="width:50px;" class="input" value="" maxlength="5" dataformat="engup" type="text" /> </td>
				<th>Doc. Type</th>
				<td><select style="width:95px;" name="edo_tp_cd" id="edo_tp_cd"><!-- 				
					--><option value="5JN" selected>D/O issue</option><!-- 
					--><option value="5JM">Self request</option><!-- 
					--><option value="5JK">Approval</option><!-- 
					--></select></td>
			</tr>
		</table>
		<table>
			<colgroup>
		    	 <col width="85" />
		         <col width="260" />
		         <col width="95" />
		         <col width="275" />
		         <col width="40" />
		         <col width="90" />
		         <col width="100" />
		         <col width="*" />	            
		     </colgroup>
			<tr>
				<th>B/L No</th>
				<td><input id="bl_no" name="bl_no" style="width:103px;" class="input" value="" maxlength="12" dataformat="eng" type="text" /> </td>
				<th>Vessel Name</th>
				<td><input id="vsl_nm" name="vsl_nm" style="width:180px;" class="input" value="" maxlength="50" dataformat="eng" type="text" /> </td>
				<th>Delete</th>
				<td><select style="width:51px;" name="delt_flg" id="delt_flg"><!-- 
				 --><option value="N" selected>N</option><!-- 
				 --><option value="Y">Y</option><!-- 
				 --></select></td>
				<th>Handing Status</th>
				<td width=""><select style="width:95px;" name="edo_ack_cd" id="edo_ack_cd"><!-- 
				 --><option value="Z" selected>All</option><!-- 
				 --><option value="Q">R-Request</option><!-- 
				 --><option value="A">A-Approval</option><!-- 
				 --><option value="R">X-Reject</option><!-- 
				 --><option value="P">P-Pending</option><!-- 
				 --><option value="E">E-Error</option><!-- 
				 --></select></td>
			</tr>
		</table>
		<table>
			<colgroup>
		    	 <col width="85" />
		         <col width="260" />
		         <col width="95" />
		         <col width="*" />	            
		     </colgroup>
			<tr>
				<th>Consignee</th>
				<td><input id="cn_nm" name="cn_nm" style="width:225px;" class="input" value="" maxlength="500" type="text" /> </td>
				<th> D/O No.</th>
				<td><input id="do_no" name="do_no" style="width:100px;" class="input" value="" maxlength="12" dataformat="eng" type="text" /> </td>
			</tr>
		</table>
	</div>	
</div>

<div class="wrap_result">		
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
	    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script type="text/javascript">ComSheetObject('sheet1');</script>
		<script type="text/javascript">ComSheetObject('sheet2');</script>
		<script type="text/javascript">ComSheetObject('sheet3');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_grid(E) -->
</div>
	
<input type='hidden' name ='frm_sheet2_edo_rqst_no'>
<input type='hidden' name ='frm_sheet2_edo_tp_cd'>
<input type='hidden' name='autoSearchFlg' id='autoSearchFlg' value ="<%=JSPUtil.getNull(request.getParameter("autoSearchFlg"))%>">
</form> 