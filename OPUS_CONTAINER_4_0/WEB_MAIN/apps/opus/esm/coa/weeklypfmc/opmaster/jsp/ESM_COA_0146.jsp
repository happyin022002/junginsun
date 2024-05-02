<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0146.jsp
*@FileTitle  : Creation, Inquiry & Update Vessel for BSA
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/01
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.apps.opus.esm.coa.weeklypfmc.opmaster.event.EsmCoa0146Event"%>
<%@ page import="com.clt.framework.component.util.io.HttpUtil"%>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr"%>
<%
    EsmCoa0146Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    GeneralEventResponse eventResponse = null;  //RDTO(Data Transfer Object including DB ResultSet)
    Exception serverException   = null;             //Error from server
    String strErrMsg    = "";                       //Error message
    Logger log = Logger.getLogger("com.clt.apps.opus.esm.coa.ESM_COA_0146");

    //String successFlag    = "";
    String ibVslSubTrd  = "";
    String xml = "";

    String stVslCd = "";

    //HashMap bb = new HashMap();
    try {

        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        //----------------------------------------------------------------------------------------- START
        event = (EsmCoa0146Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{
            eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
            stVslCd = JSPUtil.getNull(request.getParameter("f_vsl_cd"));
            
            xml = HttpUtil.makeXML(request,response); 
            xml = xml.replaceAll("\"", "'");
            
            ibVslSubTrd = eventResponse.getETCData("ibVslSubTrd");
        } // end else
        
    }catch(Exception e) {
        log.error("ESM_COA_0146 Exception : " + e.toString());
        out.println(e.toString());
    }
%>

<script>
function Exit() {
    opener.retrieve();
}
</script>

<script type="text/javascript" event="onunload" for="window">
    Exit();
</script>
<script type="text/javascript">
<%=ConstantMgr.getCompanyCodeToJS()%> 
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage("<%= ibVslSubTrd %>");
    }
</script>

<form method="post" name="form" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="f_header" id="f_header" value="<%=ibVslSubTrd%>"> 
<input type="hidden" name="sXml" id="sXml" value="<%=xml%>"> 

<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Vessel History</span></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
		<button type="button" id="btn_Retrieve" name="btn_Retrieve" class="btn_accent">Retrieve</button><!--
		--><button type="button" id="btng_Rowadd" name="btng_Rowadd" class="btn_normal">Row Add</button><!--
		--><button type="button" id="btn_Save" name="btn_Save" class="btn_normal">Save</button><!--
		--><button type="button" id="btn_Downexcel" name="btn_Downexcel" class="btn_normal">Down Excel</button><!--
		--><button type="button" id="btn_Close" name="btn_Close" class="btn_normal">Close</button><!--
		--></div>
		<!-- opus_design_btn (E) -->
	
	</div>
	<!-- page_title_area(E) -->
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="50"/>
					<col width="*" />				
				</colgroup>
				<tr> 
	               	<th>Vessel</th>
	               	<td><input type="text" style="width:80px" name="f_vsl_cd" id="f_vsl_cd" maxlength="4" onKeyPress="onlyEngNumber();" style="ime-mode:disabled" value="<%=stVslCd%>" dataformat="engup"></td>
	           	</tr>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">	
			<script type="text/javascript">ComSheetObject('sheet1');</script>		
		</div>
		<!-- opus_design_grid(E) -->
	</div>
</div>
</form>