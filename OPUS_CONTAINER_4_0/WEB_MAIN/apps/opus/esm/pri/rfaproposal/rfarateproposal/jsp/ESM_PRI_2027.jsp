<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2027.jsp
*@FileTitle  : RFA Proposal Inquiry - Rate (Route Point)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/29
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
<%@ page import="com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.event.EsmPri2027Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
    EsmPri2027Event event = null; //PDTO(Data Transfer Object including Parameters)
    Exception serverException = null; //error from server
    String strErrMsg = ""; //error message
    int rowCount = 0; //count of DB resultSET list

    String successFlag = "";
    String codeList = "";
    String pageRows = "100";

    String strUsr_id = "";
    String strUsr_nm = "";
    Logger log = Logger.getLogger("com.clt.apps.RFAProposal.RFARateProposal");

    try {
        SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();

        event = (EsmPri2027Event) request.getAttribute("Event");
        serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

    } catch (Exception e) {
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

<input type="hidden" name="prop_no" value="<%=StringUtil.xssFilter(request.getParameter("prop_no")) %>" id="prop_no" />
<input type="hidden" name="amdt_seq" value="<%=StringUtil.xssFilter(request.getParameter("amdt_seq")) %>" id="amdt_seq" />
<input type="hidden" name="svc_scp_cd" value="<%=StringUtil.xssFilter(request.getParameter("svc_scp_cd")) %>" id="svc_scp_cd" />
<input type="hidden" name="cmdt_hdr_seq" value="<%=StringUtil.xssFilter(request.getParameter("cmdt_hdr_seq")) %>" id="cmdt_hdr_seq" />
<input type="hidden" name="rout_seq" value="<%=StringUtil.xssFilter(request.getParameter("rout_seq")) %>" id="rout_seq" />
<input type="hidden" name="org_dest_tp_cd" value="<%=StringUtil.xssFilter(request.getParameter("org_dest_tp_cd")) %>" id="org_dest_tp_cd" />
<input type="hidden" name="pnt_via_tp_cd" value="<%=StringUtil.xssFilter(request.getParameter("pnt_via_tp_cd")) %>" id="pnt_via_tp_cd" />

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>RFA Proposal Inquiry - Rate (Route Point)</span></h2>
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_close" id="btn_close" type="button">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="70" />				
					<col width="400" />				
					<col width="*" />				
			   </colgroup> 
			   <tbody>
			   		<tr>
			   			<th>Route Point</th>
	                    <td class="sm pad_left_4" style="font-size:12;">
	                        <input type="radio" id="pointType" name="rt_pnt" id="rt_pnt0" value="0" class="trans"><label for="rt_pnt0">Origin</label>&nbsp;&nbsp;&nbsp;&nbsp;<!-- 
	                         --><input type="radio" id="pointType" name="rt_pnt" id="rt_pnt1" value="1" class="trans"><label for="rt_pnt1">Origin Via</label>&nbsp;&nbsp;&nbsp;&nbsp;<!-- 
	                         --><input type="radio" id="pointType" name="rt_pnt" id="rt_pnt2" value="2" class="trans"><label for="rt_pnt2">Destination Via</label>&nbsp;&nbsp;&nbsp;&nbsp;<!-- 
	                         --><input type="radio" id="pointType" name="rt_pnt" id="rt_pnt3" value="3" class="trans"><label for="rt_pnt3">Destination</label></td>
	                    <td></td>
			   		</tr>
			   </tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
		
		</div>
		<!-- opus_design_grid(E) -->
		
		<div id="sheetLayer" style="display:none">
			<!-- opus_design_grid(S) -->
			<div class="opus_design_grid">
				<script type="text/javascript">ComSheetObject('sheet1');</script>
			</div>
			<!-- opus_design_grid(E) -->
	   </div>
	   <div id="sheetLayer" style="display:none">
	   		<!-- opus_design_grid(S) -->
			<div class="opus_design_grid">
				<script type="text/javascript">ComSheetObject('sheet2');</script>
			</div>
			<!-- opus_design_grid(E) -->
	   </div>
	   <div id="sheetLayer" style="display:none">
	   		<!-- opus_design_grid(S) -->
			<div class="opus_design_grid">
				 <script type="text/javascript">ComSheetObject('sheet3');</script>
			</div>
			<!-- opus_design_grid(E) -->
	   </div>
	   <div id="sheetLayer" style="display:none">
	   		<!-- opus_design_grid(S) -->
			<div class="opus_design_grid">
				  <script type="text/javascript">ComSheetObject('sheet4');</script>
			</div>
			<!-- opus_design_grid(E) -->
	   </div>
	</div>
</div>
</form>