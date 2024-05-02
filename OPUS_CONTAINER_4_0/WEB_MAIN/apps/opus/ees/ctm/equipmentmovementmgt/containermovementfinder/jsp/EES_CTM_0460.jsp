<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CTM_0460.jsp
*@FileTitle  : VL/VD update status
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/27
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.event.EesCtm0460Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EesCtm0460Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //DB ResultSet list count

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    Logger log = Logger.getLogger("com.clt.apps.EquipmentMovementMgt.LongTxContainerMovementFinder");
    // current date
    String strEnddate = DateTime.getFormatDate(new java.util.Date(), "yyyy-MM-dd");
    // the date before 1 month
    String strStartdate = DateTime.addDays(strEnddate, -7, "yyyy-MM-dd");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();


        event = (EesCtm0460Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

    }catch(Exception e) {
        out.println(e.toString());
    }
%>

<script  type="text/javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="backendjob_key">
<!-- developer job  -->

<!-- page_title_area(S) -->
<div class="page_title_area clear">
    <!-- page_title(S) -->
    <h2 class="page_title">
        <button type="button">
            <span id="title"></span>
        </button>
    </h2>
    <!-- page_title(E) -->

    <!-- opus_design_btn(S) -->
    <div class="opus_design_btn"><!-- 
         --><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
         --><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!-- 
         --><button type="button" class="btn_normal" name="btn_Detl" id="btn_Detl">Detail</button><!-- 
     --></div>
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
	<div class="opus_design_inquiry">
	    <table>
	        <colgroup>
	            <col width="75"  />
	            <col width="230" />
	            <col width="35"  />
	            <col width="80"  />
	            <col width="70"  />
	            <col width="80"  />
	            <col width="25"  />
	            <col width="80"  />
	            <col width="60"  />
	            <col width=""    />
	        </colgroup>
	        <tbody>
	            <tr>
	                <th>ETA / ETD</th>
	                <td><!-- 
	                     --><input type="text" style="width:80px;ime-mode:disabled;" class="input1" value="<%=strStartdate%>" tabindex="1" name="p_date1" id="p_date1">~ <!-- 
	                     --><input type="text" style="width:80px;ime-mode:disabled;" class="input1" value="<%=strEnddate%>" tabindex="2" name="p_date2" id="p_date2"><!-- 
	                     --><button type="button" class="calendar ir" name="btn_Calendar2" id="btn_Calendar2"></button><!-- 
	                 --></td>
	                <th>Status</th>
	                <td><!-- 
	                     --><select style="width:55px;" class="input" name="p_status" id="p_status" tabindex="3"><!-- 
	                         --><option value="VL" selected>VL</option><!-- 
	                         --><option value="VD">VD</option><!-- 
	                     --></select><!-- 
	                 --></td>
	                <th>Trunk/Feeder</th>
	                <td><!-- 
	                     --><select style="width:85px;"class="input" name="p_vsl_svc_tp_cd" id="p_vsl_svc_tp_cd" tabindex="4"><!-- 
	                         --><option value="T" selected>Trunk</option><!-- 
	                         --><option value="F">Feeder</option><!-- 
	                     --></select><!-- 
	                 --></td>
	                <th>Port</th>
	                <td><input type="text" style="width:55px;" class="input1" dataformat="engup" maxlength="5" tabindex="5" name="p_yard1" id="p_yard1"></td>
	                <th>VVD Code</th>
	                <td><input type="text" style="width:80px;" class="input" tabindex="6" name="p_vvd" id="p_vvd" maxlength="9" dataformat="engup"></td>
	            </tr>
	        </tbody>
	    </table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" >
	    <script  type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>

</form>
