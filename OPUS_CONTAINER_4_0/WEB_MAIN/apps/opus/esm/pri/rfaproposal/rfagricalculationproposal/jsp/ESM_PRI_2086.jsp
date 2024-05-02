<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_PRI_2086.jsp
*@FileTitle  : GRI Calculation - Route Point Select
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/25
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
<%@ page import="com.clt.apps.opus.esm.pri.rfaproposal.rfagricalculationproposal.event.EsmPri2086Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
    EsmPri2086Event event = null; //PDTO(Data Transfer Object including Parameters)
    Exception serverException = null; //error from server
    String strErrMsg = ""; //error message
    int rowCount = 0; //count of DB resultSET list

    String successFlag = "";
    String codeList = "";
    String pageRows = "100";

    String strUsr_id = "";
    String strUsr_nm = "";
    Logger log = Logger.getLogger("com.clt.apps.RFAProposal.RFAGRICalculationProposal");

    try {
        SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();

        event = (EsmPri2086Event) request.getAttribute("Event");
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
            //showErrMessage(errMessage);
        } // end if
        loadPage();
    }

</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="prop_no" value="<%=StringUtil.xssFilter(request.getParameter("prop_no"))%>">
<input type="hidden" name="amdt_seq" value="<%=StringUtil.xssFilter(request.getParameter("amdt_seq"))%>">
<input type="hidden" name="svc_scp_cd" value="<%=StringUtil.xssFilter(request.getParameter("svc_scp_cd"))%>">
<input type="hidden" name="gri_grp_seq" value="<%=StringUtil.xssFilter(request.getParameter("gri_grp_seq"))%>">
<input type="hidden" name="gri_appl_flg" value="<%=StringUtil.xssFilter(request.getParameter("gri_appl_flg"))%>">
<input type="hidden" name="is_req_usr" value="<%=StringUtil.xssFilter(request.getParameter("is_req_usr"))%>">
<input type="hidden" name="is_apro_usr" value="<%=StringUtil.xssFilter(request.getParameter("is_apro_usr"))%>">
<input type="hidden" name="org_dest_tp_cd" value="<%=StringUtil.xssFilter(request.getParameter("org_dest_tp_cd"))%>">
<input type="hidden" name="pnt_via_tp_cd" value="<%=StringUtil.xssFilter(request.getParameter("pnt_via_tp_cd"))%>">

<!-- OUTER - POPUP (S)tart -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>GRI Calculation Commodity/Actual Customer Select</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_ok" id="btn_ok">OK</button>
			<button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
			<table border="0" style="width:550px;" class="search_sm"> 
                <tr class="h23">
                <th width="90px">Route Point</th>
                <td width="450px" class="stm" style="font-size:12;">
                    <input type="radio" id="rt_pnt" name="rt_pnt" value="0" class="trans">&nbsp;Origin&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="radio" id="rt_pnt" name="rt_pnt" value="1" class="trans">&nbsp;Origin Via&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="radio" id="rt_pnt" name="rt_pnt" value="2" class="trans">&nbsp;Destination Via&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="radio" id="rt_pnt" name="rt_pnt" value="3" class="trans">&nbsp;Destination</td>
                    </tr>
            </table>
		</div>
	</div>
	<div class="wrap_result">
		<div class="opus_design_grid" >
			<div class="opus_design_grid">
				<!-- opus_grid_btn(S) -->
				<div class="opus_design_btn">
					<button type="button" class="btn_normal" name="btn_add" id="btn_add">Row Add</button>
					<button type="button" class="btn_normal" name="btn_delete" id="btn_delete">Delete</button>
				</div>
				<!-- opus_grid_btn(E) -->
			</div>
			
			<div id="sheetLayer" style="display:none">
	           <script language="javascript">ComSheetObject('sheet1');</script>
	        </div>
	        <div id="sheetLayer" style="display:none">
	           <script language="javascript">ComSheetObject('sheet2');</script>
	        </div>
	        <div id="sheetLayer" style="display:none">
	           <script language="javascript">ComSheetObject('sheet3');</script>
	        </div>
	        <div id="sheetLayer" style="display:none">
	           <script language="javascript">ComSheetObject('sheet4');</script>
	        </div>
		</div>
	</div>
</div>
</form>