<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0518.jsp
*@FileTitle  : B/L Inquiry by Container 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/07
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>

<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.event.EsmBkg0518Event"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Locale" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg0518Event  event 		= null;	//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;	// error from server
	String strErrMsg 			= "";	// error message
	int rowCount	 			= 0;	// count of DB resultSET list

	String successFlag 	= "";
	String codeList  	= "";
	String pageRows  	= "100";
	String strUsr_id	= "";
	String strUsr_nm	= "";
	
	String strCntrNo	= "";
	String strVvd		= "";

	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.CustomsReport");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0518Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		strCntrNo = JSPUtil.getNullNoTrim(request.getParameter("cntr_no"));
		strVvd = JSPUtil.getNullNoTrim(request.getParameter("vvd"));
		
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
		
		$('<button type="button" class="btn_accent" name="btn_Retrieve"	id="btn_Retrieve">Retrieve</button>').appendTo("#btnArea");
        $('<button type="button" class="btn_normal" name="btn_BLInquiry" id="btn_BLInquiry">Manifest(B/L)</button>').appendTo("#btnArea");
        $('<button type="button" class="btn_normal" name="btn_Excel" id="btn_Excel">Down Excel</button>').appendTo("#btnArea");

        $('#btn_Excel').after($('#btn_Close'));
        
		loadPage();
	}
</script>

<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="bl_no">

<%@include file="/apps/opus/esm/bkg/bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp" %>

	<!-- opus_design_inquiry(S) -->
	<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
	    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <table>
	         <colgroup>
	            <col width="60" />
	            <col width="130" />
	            <col width="100" />
	            <col width="" />
	        </colgroup> 
	        <tbody>
				<tr class="h23">
					<th>Container No.</th>
					<td>
						<input type="text" id="cntr_no" name="cntr_no" style="width:107px; ime-mode: disabled;" class="input1" value="<%=strCntrNo%>"
                        dataformat="engup" maxlength="11" fullfill caption="Container No.">
					</td>
					<th title="Vessel Voyage Direction">VVD</th>
					<td>
						<input type="text" id="vvd" name="vvd" style="width:90px; ime-mode: disabled;" class="input" value="<%=strVvd%>"
                        dataformat="engup" maxlength="9" fullfill caption="VVD">
					</td>
					<th title="B/L Type" style="width:70px;">B/L Type</th>
					<td>
						<select name="bl_type" class="input">
							<option value="0" selected>ALL</option>
							<option value="1">Master B/L</option>
							<option value="2">House B/L</option>
						</select>
					</td>
					<td style="width:500px;">&nbsp;</td>
				</tr>
				
			</tbody>
		</table>
	    <!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	</div>
	<!-- opus_design_inquiry(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="wrap_result">
	<div class="opus_design_grid">
	    
	    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script language="javascript">ComSheetObject('sheet1');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	</div>
	<!-- opus_design_grid(E) -->
	
</form>

