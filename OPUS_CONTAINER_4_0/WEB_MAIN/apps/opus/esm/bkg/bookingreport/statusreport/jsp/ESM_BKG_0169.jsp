
<%
/*=========================================================
*Copyright(c) 2016 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0169.jsp
*@FileTitle  : 
*@author     : CLT
*@version    : 1.0
*@since      : 2016/05/10
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingreport.statusreport.event.EsmBkg0169Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg0169Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String bkg_no = "";
    Logger log = Logger.getLogger("com.clt.apps.InboundBLMgt.FullReleaseOrder");
    

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        bkg_no         = JSPUtil.getParameter(request,"bkg_no"        ,"" );

        event = (EsmBkg0169Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // If you imported data from the server initialization when loading
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
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input name='bkg_no' id='bkg_no' type="hidden" value='<%=bkg_no%>'>
<input name='bl_no' id='bl_no' type="hidden" value=''>
<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><span>VGM History</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Close" 		id="btn_Close">Close</button>
	</div>
	<!-- opus_design_btn(E) -->
	
<!-- page_title_area(E) -->
</div>

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="60"/>
				<col width="*" />				
			</colgroup> 
			 <tr>
                  <td>BKG No.</td>
                  <td><input name='bkg_no' id='bkg_no' type="text" style="width:110px;" class="input2" maxlength='12' readonly value='<%=bkg_no%>'></td>
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
</form>