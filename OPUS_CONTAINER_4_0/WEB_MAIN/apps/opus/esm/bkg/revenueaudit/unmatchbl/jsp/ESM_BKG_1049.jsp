<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1049.jsp
*@FileTitle  : Error Details
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/31
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
<%@ page import="com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.event.EsmBkg1049Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg1049Event  event = null;              //PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//serverException
	String strErrMsg = "";						//error massage
	int rowCount	 = 0;						//DB ResultSet list count
    
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    
    String blNo = "";
    String bkgNo = "";
    String umchBkgSeq = "";
    
    Logger log = Logger.getLogger("com.clt.apps.RevenueAudit.UnmatchBL");
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
       
        event = (EsmBkg1049Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        
      	//when open screen, get data in server..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
        blNo = StringUtil.xssFilter(request.getParameter("bl_no"));
        bkgNo = StringUtil.xssFilter(request.getParameter("bkg_no"));
        umchBkgSeq = StringUtil.xssFilter(request.getParameter("umch_bkg_seq"));
        
    }catch(Exception e) {
        out.println(e.toString());
    }
    
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
<!-- definition for Office Code Validation ckeck -->
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="cd" id="cd" />
<input type="hidden" name="backendjob_key" id="backendjob_key" />
<!-- Form Hidden -->
<input type="hidden" name="bkg_no" value="<%=bkgNo%>" id="bkg_no" />
<input type="hidden" name="umch_bkg_seq" value="<%=umchBkgSeq%>" id="umch_bkg_seq" />

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Error Details</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry">
			 <table> 
	            <tbody>
	            	<tr>
						<th width="50">B/L No.</th>
						<td width="130"><input type="text" name="bl_no" id="bl_no" style="width:120px;text-align:center;" class="input1" value="<%=blNo%>" readonly></td>
	                    <th width="80">Audit Result</th>
	                    <td><input type="text" name="audit_result" id="audit_result" style="width:120px;text-align:center;" class="input1" value="" readonly></td>
	   				</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="mainTable" >										
			 <script type="text/javascript">ComSheetObject('sheet1');</script>
		<!-- opus_design_grid(E) -->
		</div>
	</div>
</div>
</form>