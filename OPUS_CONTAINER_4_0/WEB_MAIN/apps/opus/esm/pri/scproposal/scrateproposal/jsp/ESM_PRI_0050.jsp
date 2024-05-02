<%  
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0050.jsp
*@FileTitle : S/C Proposal General/Special Rate - Origin & Destination Inquiry
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 
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
<%@ page import="com.clt.apps.opus.esm.pri.scproposal.scrateproposal.event.EsmPri0050Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
    EsmPri0050Event event = null; //PDTO(Data Transfer Object including Parameters)
    Exception serverException = null; //error from server
    String strErrMsg = ""; //error message
    int rowCount = 0; //count of DB resultSET list

    String successFlag = "";
    String codeList = "";
    String pageRows = "100";

    String strUsr_id = "";
    String strUsr_nm = "";
    Logger log = Logger.getLogger("com.clt.apps.SCProposal.SCRateProposal");

    try {
        SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();

        event = (EsmPri0050Event) request.getAttribute("Event");
        serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        

    } catch (Exception e) {
        out.println(e.toString());
    }
%>

<script language="javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if
        
        loadPage();
    }

</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- developer job -->
<input type="hidden" name="prop_no" value="<%=StringUtil.xssFilter(request.getParameter("prop_no"))%>">
<input type="hidden" name="amdt_seq" value="<%=StringUtil.xssFilter(request.getParameter("amdt_seq"))%>">
<input type="hidden" name="svc_scp_cd" value="<%=StringUtil.xssFilter(request.getParameter("svc_scp_cd"))%>">
<input type="hidden" name="gen_spcl_rt_tp_cd" value="<%=StringUtil.xssFilter(request.getParameter("gen_spcl_rt_tp_cd"))%>">
<input type="hidden" name="cmdt_hdr_seq" value="<%=StringUtil.xssFilter(request.getParameter("cmdt_hdr_seq"))%>">
<input type="hidden" name="rout_seq" value="<%=StringUtil.xssFilter(request.getParameter("rout_seq"))%>">
<input type="hidden" name="org_dest_tp_cd" value="<%=StringUtil.xssFilter(request.getParameter("org_dest_tp_cd"))%>">
<input type="hidden" name="pnt_via_tp_cd" value="<%=StringUtil.xssFilter(request.getParameter("pnt_via_tp_cd"))%>">

<div class="layer_popup_title"> 
	<div class="page_title_area clear">
	   	<!-- page_title(S) -->
		<h2 class="page_title"><span>S/C Proposal General/Special Rate - Origin & Destination Inquiry</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">	
			<button type="button" class="btn_accent" name="btn_close" 		id="btn_close">Close</button>
		</div>
	</div>
</div>
	<!-- opus_design_btn(E) -->
<div class="layer_popup_contents"> 	
	 <div class="wrap_search">
			<div class="opus_design_inquiry wFit">
			<table>
				<tbody>
					<colgroup>
						<col width="100px">
						<col width="800px">
						<col width="*">
				    </colgroup>
					<tr>
						<th>Route Point</th>
						<td>
							<input type="radio" id="pointType" name="rt_pnt" value="0" class="trans"> <span id="dest_tp_cd1">Origin</span>&nbsp;&nbsp;&nbsp;&nbsp;
	                        <input type="radio" id="pointType" name="rt_pnt" value="1" class="trans"> <span id="dest_tp_cd1">Origin Via</span>&nbsp;&nbsp;&nbsp;&nbsp;
	                        <input type="radio" id="pointType" name="rt_pnt" value="2" class="trans"> <span id="dest_tp_cd1">Destination Via</span>&nbsp;&nbsp;&nbsp;&nbsp;
	                        <input type="radio" id="pointType" name="rt_pnt" value="3" class="trans"> <span id="dest_tp_cd1">Destination</span>                        
						</td>
						<td></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>	

	<!-- opus_design_grid(S) -->
	<div class="wrap_result">
		<div class="opus_design_grid" id="sheetLayer" style="display:none">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<div class="opus_design_grid" id="sheetLayer" style="display:none">	
		 	<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
		 <div class="opus_design_grid" id="sheetLayer" style="display:none">	
		 	<script type="text/javascript">ComSheetObject('sheet3');</script>
		</div>
		<div class="opus_design_grid" id="sheetLayer" style="display:none">	
		 	<script type="text/javascript">ComSheetObject('sheet4');</script>
		</div>
	</div>	
</div>
</form>