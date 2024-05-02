<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1032.jsp
*@FileTitle  : CTA : Transmit History
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
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.eur.event.EsmBkg1032Event"%>

<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg1032Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //occurring error in server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //list count of DB ResultSet
    
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
       
        event = (EsmBkg1032Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        //When initial screen loading, adding logic extrat data obtained from the server.
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
    }catch(Exception e) {
        out.println(e.toString());
    }
%>

<script language="javascript">
    function setupPage(){

        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } 
        
        loadPage();
    }
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
        
   	<!-- page_title(S) -->
    <h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
    <!-- page_title(E) -->
    
    <!-- opus_design_btn(S) -->
    <div class="opus_design_btn">
        <button type="button" class="btn_accent" name="btn_retrieve"  id="btn_retrieve">Retrieve</button>
        <button type="button" class="btn_normal" name="btn_exceldown" id="btn_exceldown">Down Excel</button>
    </div>
    <!-- opus_design_btn(E) -->
    
    <!-- page_location(S) -->
    <div class="location">
        <span id="navigation"></span>
    </div>
    <!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<!-- opus_design_inquiry(S) -->
<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
	    <table>
	        <colgroup>
	            <col width="120px" />
	            <col width="120px" />
	            <col width="80px"  />
	            <col width="120px" />
	            <col width="100px"  />
	            <col width="120px"  />
	            <col width="80px"  />
	            <col width="50px"  />
	            <col width="60px"  />
	            <col width=""      />
	        </colgroup>
	        <tbody>
	            <tr>
	                <th>Acknowledge Date</th>
	                <td colspan="7">
	                    <input type="text" style="width: 85px; ime-mode: disabled" class="input" maxlength="10" dataformat="ymd" name="s_vps_eta_dt" id="s_vps_eta_dt" caption="ETA" cofield="e_vps_eta_dt">
	                    &nbsp;~&nbsp; 
	                    <input type="text" style="width: 85px; ime-mode: disabled" class="input" maxlength="10" dataformat="ymd" name="e_vps_eta_dt" id="e_vps_eta_dt" caption="ETA" cofield="s_vps_eta_dt">
	                    <button type="button" class="calendar ir" name="btn_calendar" id="btn_calendar"></button>
	                </td>
	            </tr>
	            <tr>
	                <th>VVD</th>
	                <td>
	                    <input type="text" style="width:100px;text-align:center; ime-mode:disabled" name="vvd" id="vvd" class="input" align="middle" maxlength="9" dataformat="engup">
	                </td>
	                <th>BL No.</th>
	                <td>
	                    <input type="text" style="width:110px; ime-mode:disabled" name="bl_no" id="bl_no" class="input" dataformat="engup" maxlength="12" caption="BL No">
	                </td>
	                <th>Container No.</th>
	                <td width="">
	                    <input type="text" style="width:110px; ime-mode:disabled" name="cntr_no" id="cntr_no" class="input" dataformat="engup" maxlength="14" caption="Container No">
	                </td>
	                <th>FR Ack.</th>
	                <td>
	                    <input type="checkbox" value="" class="trans" name="fr_ack">
	                </td>
	                <th>VVD for FR.</th>
	                <td>
	                    <input type="text" style="width:140px; ime-mode:disabled" name="vvd_for_fr" readOnly class="input" dataformat="engup" maxlength="14" caption="VVD for FR">
	                </td>
	            </tr>
	        </tbody>
	    </table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->

<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid">
	    <script language="javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
<!-- opus_design_grid(E) -->            

<!-- Developer Work End -->
</form>