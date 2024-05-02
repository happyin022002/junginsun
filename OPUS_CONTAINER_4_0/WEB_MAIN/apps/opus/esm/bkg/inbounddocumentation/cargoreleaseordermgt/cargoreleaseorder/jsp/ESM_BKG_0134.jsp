<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1034.js
*@FileTitle  : Cargo Release Order_E-D/O inquiry _Main(Korea e-D/O Sent History, D/O EDI Transmit log List Inquiry)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/24
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0134Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg0134Event  event = null;              //PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    Logger log = Logger.getLogger("com.clt.apps.InboundBLMgtSC.FullReleaseOrderBC");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();


        event = (EsmBkg0134Event)request.getAttribute("Event");
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
        
        $('<button type="button" class="btn_accent" name="btn_Retrieve"	id="btn_Retrieve">Retrieve</button>').appendTo("#btnArea");
        $('<button type="button" class="btn_normal" name="btn_new"  	id="btn_new">New</button>').appendTo("#btnArea");
        $('#btn_new').after($('#btn_Close'));
        
        /* document.getElementById("title").innerHTML = "Korea e-D/O Sent History"; */
        
        loadPage();
    }
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />

<input type="hidden" name="autoSearchFlg" value="<%=JSPUtil.getNull(request.getParameter(" autosearchflg")) %>" id="autoSearchFlg" />
<input type="hidden" name="frm_edo_rqst_dt_s" value="<%=JSPUtil.getNull(request.getParameter(" edo_rqst_dt_s")) %>" id="frm_edo_rqst_dt_s" />
<input type="hidden" name="frm_edo_rqst_dt_e" value="<%=JSPUtil.getNull(request.getParameter(" edo_rqst_dt_e")) %>" id="frm_edo_rqst_dt_e" />
<input type="hidden" name="frm_bl_no" value="<%=JSPUtil.getNull(request.getParameter("bl_no")) %>" id="frm_bl_no" />
<input type="hidden" name="frm_sch_tp" value="" id="frm_sch_tp" />


<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp"%>	
<%if(!mainPage.equals("true")){%><div class="layer_popup_contents"><%}%>
<!-- popup_contens_area(S) -->
	<div class="wrap_search">	
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
	    <table>
	    <colgroup>
			<col width="75"/>
			<col width="110"/>
			<col width="220"/>
			<col width="*"/>
		</colgroup>
		<tbody>	
		<tr>
            <th><input type="radio" value="B" class="trans" name="sch_tp" id="sch_tp1" checked ="true"><label for ="sch_tp1">B/L No</label></th>
            <td><input type="text" name="bl_no" id="bl_no" style="width:100px;" class="input" value="<%=JSPUtil.getNull(request.getParameter("bl_no"))%>" maxlength="12" dataformat="engup" style="ime-mode:disabled" onFocus="form.sch_tp[0].checked=true;"></td>
            <th><input type="radio" value="A" class="trans" name="sch_tp" id="sch_tp2"><label for ="sch_tp2">Error Message Received Date</label></th>
            <td><input type="text" name="rcv_fm_dt" style="width:80px;" class="input1" value="" caption="Error Message Received Date(From)" dataformat="ymd" onFocus="form.sch_tp[1].checked=true;">~	<input type="text" name="rcv_to_dt" style="width:80px;" class="input1" value="" caption="Error Message Received Date(To)" dataformat="ymd"><button class="calendar ir" name="btns_calendar2" id="btns_calendar2" type="button"></button></td>				                
		</tr>
	</tbody>
	</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->
	<div class="wrap_result">	    
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid"  id="mainTable">
		    <script type="text/javascript">ComSheetObject('sheet1');</script>
		  </div>  
	</div>
	<!-- opus_design_grid(E) -->
<!-- popup_contens_area(E) -->
<%if(!mainPage.equals("true")){	%></div><%}%>
</form>
 