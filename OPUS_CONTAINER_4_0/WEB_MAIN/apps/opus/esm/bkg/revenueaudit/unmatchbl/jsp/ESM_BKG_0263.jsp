<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0263
*@FileTitle  : Self Audit
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/29
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.event.EsmBkg0263Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg0263Event  event = null;              //PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
    
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String blNo = "";
    String caflg = "";
    
    Logger log = Logger.getLogger("com.clt.apps.RevenueAudit.UnmatchBL");
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        
        blNo = JSPUtil.getNullNoTrim(request.getParameter("bl_no"));
        caflg = JSPUtil.getNullNoTrim(request.getParameter("ca_flg"));
        event = (EsmBkg0263Event)request.getAttribute("Event");
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

<form name="form"> 
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="cd" id="cd" />
<input type="hidden" name="bl_no_org" value="<%=blNo%>" id="bl_no_org" />
<input type="hidden" name="ca_flg" value="<%=caflg%>">
<input type="hidden" name="key">  <!-- BackEndJob -->

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Self Audit</span></h2>
		
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
		 --><button class="btn_normal" name="btn_New" id="btn_New" type="button">New</button><!--
		 --><button class="btn_normal" name="btn_Close" id="btn_Close" type="button">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<div class="opus_design_inquiry">
			<table>
				<tbody>
					<tr>
						<th width="50">B/L No.</th>
						<td width="130"><input type="text" name="bl_no style="ime-mode:disabled" class="input1" caption="B/L No" dataformat="engup" maxlength="12" id="bl_no" /></td>
						<th width="80">Audit Result</th>
						<td><input type="text" name="audit_result" class="input1" value="" readonly id="audit_result" /></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	
	<div class="wrap_result">
		<div class="opus_design_grid" id="mainTable" >
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
</div>
</form>