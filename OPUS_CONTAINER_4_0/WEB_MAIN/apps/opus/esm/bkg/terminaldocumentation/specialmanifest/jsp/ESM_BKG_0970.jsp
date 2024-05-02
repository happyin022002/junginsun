<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ESM_BKG_0970.jsp
*@FileTitle : ESM_BKG_0970
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/12
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.event.EsmBkg0970Event"%>

<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0970Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd 		= "";
	String callGubun = "";
	String dType = "";
	String vvdCd = "";
	String portCd = "";
	String blNo = "";
	String cntrNo = "";
	String cntrCgoSeq = "";
	String pgmNo = "";
	String main_page = "";
	Logger log = Logger.getLogger("com.clt.apps.TerminalDocumentation.SpecialManifest");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		main_page = JSPUtil.getNull(request.getParameter("main_page"));
		event = (EsmBkg0970Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		callGubun 	= (StringUtil.xssFilter(request.getParameter("callGubun")) == null) ? "" : StringUtil.xssFilter(request.getParameter("callGubun"));
		dType 		= (StringUtil.xssFilter(request.getParameter("d_type")) == null) ? "" : StringUtil.xssFilter(request.getParameter("d_type"));
		vvdCd 		= (StringUtil.xssFilter(request.getParameter("vvd_cd")) == null) ? "" : StringUtil.xssFilter(request.getParameter("vvd_cd"));
		portCd 		= (StringUtil.xssFilter(request.getParameter("port_cd")) == null) ? "" : StringUtil.xssFilter(request.getParameter("port_cd"));
		blNo 		= (StringUtil.xssFilter(request.getParameter("bl_no")) == null) ? "" : StringUtil.xssFilter(request.getParameter("bl_no"));
		cntrNo 		= (StringUtil.xssFilter(request.getParameter("cntr_no")) == null) ? "" : StringUtil.xssFilter(request.getParameter("cntr_no"));
		cntrCgoSeq 	= (StringUtil.xssFilter(request.getParameter("cntr_cgo_seq")) == null) ? "" : StringUtil.xssFilter(request.getParameter("cntr_cgo_seq"));
		pgmNo 		= (StringUtil.xssFilter(request.getParameter("pgmNo")) == null) ? "" : StringUtil.xssFilter(request.getParameter("pgmNo"));
		if("".equals(callGubun)) {
				callGubun = "ESM_BKG_0966";
		}
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		
        /* $('<button type="button" class="btn_normal" name="btn_Retrieve" id="btn_Retrieve" style="display:none">History</button>').appendTo("#btnArea");
        $('<button type="button" class="btn_normal" name="btn1_DownExcel" id="btn1_DownExcel" style="display:none">B/L Preview</button>').appendTo("#btnArea");
        
        $('#btn1_DownExcel').after($('#btn_Close'));
        document.getElementById("title").innerHTML = "Transit (Sending Results) by Container No"; */
        
		loadPage('<%=dType%>', '<%=callGubun%>');
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="call_gubun" value="<%=callGubun%>">
<input type="hidden" name="pgmNo" value="<%=pgmNo%>">

<%-- <%@include file="../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp" %> --%>

<%if(!main_page.equals("true")){%>
	<div class="layer_popup_title">	
		<!-- page_title_area(S) -->
		<!-- page_title_area(S) -->
		<div class="page_title_area clear">
		    
		    <!-- page_title(S) -->
		    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		   	<h2 class="page_title"><span>Transit (Sending Results) by Container No</span></h2>
		    <!-- page_title(E) -->
	
	    	<!-- opus_design_btn(S) -->
		    <div class="opus_design_btn"><!-- 
				--><button type="button" class="btn_normal" name="btn_Retrieve" id="btn_Retrieve" >Retrieve</button><!-- 
				 --><button type="button" class="btn_normal" name="btn1_DownExcel" id="btn1_DownExcel">Down Excel</button><!-- 
				  --><button type="button" class="btn_normal" name="btn_Close"	id="btn_Close" onclick="ComClosePopup()">Close</button><!-- 
		    --></div>
		    <!-- opus_design_btn(E) -->
		 </div>
		<!-- page_title_area(E) -->
	</div>
	<%}else{%>
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	    
	    <!-- page_title(S) -->
	    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	   	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	    <!-- page_title(E) -->

    	<!-- opus_design_btn(S) -->
	    <div class="opus_design_btn"><!-- 
	    		--><button type="button" class="btn_normal" name="btn_Retrieve" id="btn_Retrieve" >Retrieve</button><!-- 
				 --><button type="button" class="btn_normal" name="btn1_DownExcel" id="btn1_DownExcel" >Down Excel</button>
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
	<%} %>
<%if(!main_page.equals("true")){%>
<div class="layer_popup_contents">
<%} %>
<div class="wrap_search">
<!-- 검색영역 -->
	<div class="opus_design_inquiry">		
		<table> 
		<tr>
			<td width="400px">
			<div class="sm pad_btm_16" style="width:380px">
		<%
			if(callGubun.equals("ESM_BKG_0965")) {
		%>
				<table style="width:390px;"> 
					<tr>
						<th width="80px" rowspan="2">&nbsp;Declaration </th> 
						<td width="" class="stm">
							<input type="checkbox" name="d_type0" value="" class="trans">All &nbsp;
							<input type="checkbox" name="d_type1" value="D" class="trans">Discharging &nbsp;
							<input type="checkbox" name="d_type2" value="T" class="trans">Transit &nbsp;
							<input type="checkbox" name="d_type3" value="L" class="trans">Loading
						</td>	
					</tr>
					<tr>
						<td>
							<input type="checkbox" name="d_type4" value="P" class="trans">Pre-carriage  &nbsp;
							<input type="checkbox" name="d_type5" value="O" class="trans">On-Carriage
						</td>	
					</tr>
				</table>
				<input type="hidden" name="d_type" caption="Declaration">
		<%
			} else {
		%>
				<table border="0" style="width:390px;"> 
					<tr>
						<th width="80px" rowspan="2">&nbsp;Declaration </th> 
						<td width="" class="stm">
							<input type="radio" name="d_type" value="" class="trans" checked>All &nbsp;
							<input type="radio" name="d_type" value="D" class="trans">Import &nbsp;
							<input type="radio" name="d_type" value="T" class="trans">Transit &nbsp;
							<input type="radio" name="d_type" value="L" class="trans">Export
						</td>	
					</tr>
				</table>
		<%
			}
		%>					
			</div>
			</td> 
			<td width="" valign="top">
				<div class="sm pad_btm_16" style="width:600px">
					<table>
						<tr>
							<td width="300px">
								<input type="radio" name="search_type" value="1" class="trans" checked>&nbsp;VVD&nbsp;
								<input type="text" style="width:90px;"  class="input1" name="vvd_cd" dataformat="engup"  maxlength="9" caption="VVD">&nbsp;&nbsp;Port&nbsp;
								<input type="text" style="width:65px;"  class="input1" name="port_cd" dataformat="enguponly"  maxlength="5"  caption="Port">
							</td> 
							<td>
								<input type="radio" name="search_type" value="2" class="trans">Transmit Date&nbsp;<input type="text"  style="width: 90px; ime-mode: disabled" class="input1" maxlength="10" dataformat="ymd" name="snd_dt_from"  caption="Transmit Date From" cofield="snd_dt_from"><input type="text" style="width: 90px; ime-mode: disabled" class="input1" maxlength="10" dataformat="ymd" name="snd_dt_to"  caption="Transmit Date To" cofield="snd_dt_to"><button type="button" class="calendar ir" name="btn_calendar" id="btn_calendar"></button>										
							</td> 
						</tr>
					</table>
				</div>
			</td> 
		</tr>
	</table>
	<table> 
		<tr>
		<% if(callGubun.equals("ESM_BKG_0965")) { %>
			<th width="50px">B/L No.</th> 
			<td width="123px">
				<input type="text" style="width:110px;" value="<%= blNo %>" class="input1" name="bl_no" dataformat="engup" maxlength="12" caption="B/L No.">
			</td>
			<th width="90px">Container No.</th> 
			<td width="140px">
				<input type="text" style="width:110px;" value="<%= cntrNo %>" class="input1" name="cntr_no" dataformat="engup" maxlength="14" caption="Container No.">
			</td>
		<% } else { %>
			<td width="50px"></td> 
			<td width="123px"><input type="hidden" style="width:110px;" class="input1" name="bl_no" dataformat="engup" maxlength="12" caption="B/L No."></td>
			<td width="90px"></td> 
			<td width="125px"><input type="hidden" style="width:110px;" class="input1" name="cntr_no" dataformat="engup" maxlength="14" caption="Container No."></td>
		<% } %>
			<th width="90px">Message Type</th> 
			<td width="">
				<select style="width:200;" class="input1" name="msg_type">
					<option value="" selected>All</option>
					<option value="E" >Empty Message not sent</option>
					<option value="P" >Processing</option>
					<option value="A" >Sent, Accepted</option>
					<option value="C" >Sent, Wrong but Acceptable</option>
					<option value="R" >Sent, Not Acceptable</option>
					</select>
			</td>
		</tr>
	</table>
	</div>
<!-- 검색영역 -->
</div>

<div class="wrap_result">
	<!-- 시트영역 -->
	<div class="opus_design_grid">		
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- 시트영역 -->
</div>
<%if(!main_page.equals("true")){	%></div><%}%>
</form>
	
