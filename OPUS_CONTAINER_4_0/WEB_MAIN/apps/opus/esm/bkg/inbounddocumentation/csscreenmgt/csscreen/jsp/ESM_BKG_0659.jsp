<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESM_BKG_0659.jsp
*@FileTitle : DG Cargo Detail Pop-up
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.event.EsmBkg0659Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0659Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//DB ResultSet List count
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.CsScreenMgt.CsScreen");
	
    // Param : bl_no, bl_tp_cd, bkg_no
    String blNo       = "";
    String blTpCd     = "";
    String bkgNo      = "";
    String cntrNo     = "";
    String blTpCdClass = "input2";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmBkg0659Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

        if(event != null) {         
            blNo       = event.getBlNo();
            blTpCd     = event.getBlTpCd();
            bkgNo      = event.getBkgNo();
            cntrNo     = event.getCntrNo();

            if ("W".equals(blTpCd) || "S".equals(blTpCd)) {
                blTpCdClass = "input2_1";
            }    
        }
		
	} catch(Exception e) {
		out.println(e.toString());
	}

%>

<script language="javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if
        
        with(document.form){
            eval("bl_no").value        = "<%=blNo%>";
            eval("bl_tp_cd").value     = "<%=blTpCd%>";
            eval("bkg_no").value       = "<%=bkgNo%>";
            eval("cntr_no").value      = "<%=cntrNo%>";
            
            eval("bl_tp_cd").className = "<%=blTpCdClass%>";
        }
        
        loadPage();
    }
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="bkg_no"       required="" caption="Booking No." />
<input type="hidden" name="cntr_no"      caption="Container No." />


<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><span>DG Cargo Detail Pop-up</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button><!--
		--></div>
		<!-- opus_design_btn(E) -->
	</div>
	<!-- page_title_area(E) -->
</div>

<div class="layer_popup_contents">	
	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
		<table>
			<tr>
				<th style="text-align:left; width:50px;">B/L No.</th>
				<td>
 					<input type="text" style="width:98px;" class="input2" name="bl_no"    required="" caption="B/L No."  readonly="readonly" /><!-- 
                     --><input type="text" style="width:25px;" class="input2" name="bl_tp_cd" caption="B/L Type" readonly="readonly" />
				</td>
			</tr>
		</table>
	</div>
	</div>
	<!-- opus_design_grid(S) -->	
	<div class="wrap_result">
		<div class="opus_design_grid clear" id="mainTable" >
				<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>
<%@include file="/bizcommon/include/common_opus.jsp"%>