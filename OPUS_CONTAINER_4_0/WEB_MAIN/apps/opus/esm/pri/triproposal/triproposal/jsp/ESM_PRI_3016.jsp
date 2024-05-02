﻿<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_3016.jsp
*@FileTitle  : TRI Creation & Amendment - Route Point
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/07
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
<%@ page import="com.clt.apps.opus.esm.pri.triproposal.triproposal.event.EsmPri3016Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
    EsmPri3016Event event = null; //PDTO(Data Transfer Object including Parameters)
    Exception serverException = null; //Error from Server
    String strErrMsg = ""; //Error Message
    int rowCount = 0; //Number of DB ResultSet List

    String successFlag = "";
    String codeList = "";
    String pageRows = "100";

    String strUsr_id = "";
    String strUsr_nm = "";
    String prop_sts_cd= JSPUtil.getNull(request.getParameter("prop_sts_cd"));
    Logger log = Logger.getLogger("com.clt.apps.TRIProposal.TRIRateProposal");

    try {
        SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();

        event = (EsmPri3016Event) request.getAttribute("Event");
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

<input type="hidden" name="tri_prop_no" value="<%=StringUtil.xssFilter(request.getParameter("tri_prop_no")) %>" id="tri_prop_no" />
<input type="hidden" name="amdt_seq" value="<%=StringUtil.xssFilter(request.getParameter("amdt_seq")) %>" id="amdt_seq" />
<input type="hidden" name="prop_sts_cd" value="<%=StringUtil.xssFilter(request.getParameter("prop_sts_cd")) %>" id="prop_sts_cd" />
<input type="hidden" name="tri_no" value="<%=StringUtil.xssFilter(request.getParameter("tri_no")) %>" id="tri_no" />
<input type="hidden" name="is_req_usr" value="<%=StringUtil.xssFilter(request.getParameter("is_req_usr")) %>" id="is_req_usr" />
<input type="hidden" name="is_apro_usr" value="<%=StringUtil.xssFilter(request.getParameter("is_apro_usr")) %>" id="is_apro_usr" />
<input type="hidden" name="org_dest_tp_cd" value="<%=StringUtil.xssFilter(request.getParameter("org_dest_tp_cd")) %>" id="org_dest_tp_cd" />
<input type="hidden" name="pnt_via_tp_cd" value="<%=StringUtil.xssFilter(request.getParameter("pnt_via_tp_cd")) %>" id="pnt_via_tp_cd" />


<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><span>TRI Creation & Amendment - Route Point</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_ok" 	id="btn_ok">OK</button>
			<button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->
	</div>
	<!-- page_title_area(E) -->
</div>

<div class="layer_popup_contents">
	<div class= "wrap_search">
		<div class= "opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="90" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
	                    <th>Route Point</th>
	                    <td>
	                        <input type="radio" id="pointType1" name="rt_pnt" value="0" class="trans" checked /><label for="pointType1">Origin</label> 
	                         <input type="radio" id="pointType2" name="rt_pnt" value="1" class="trans" /><label for="pointType2">Origin Via</label> 
	                         <input type="radio" id="pointType3" name="rt_pnt" value="2" class="trans" /><label for="pointType3">Destination Via</label> 
	                         <input type="radio" id="pointType4" name="rt_pnt" value="3" class="trans" /><label for="pointType4">Destination</label>
	                 </tr>
				</tbody>
			</table>
		</div>
	</div>		
	<!-- opus_design_grid(S) -->	
	<div class="wrap_result">
		<div class="opus_design_grid clear" id="mainTable" >
				<div class="opus_design_btn">
					<button type="button" class="btn_accent" name="btn_add" 	id="btn_add" suppressWait="Y">Row Add</button>
					<button type="button" class="btn_normal" name="btn_delete" id="btn_delete" suppressWait="Y">Delete</button>
				</div>
				<div id="sheetLayer" style="display:none">
               		 <script type="text/javascript">ComSheetObject('sheet1');</script>
                </div>
                <div id="sheetLayer" style="display:none">
                	<script type="text/javascript">ComSheetObject('sheet2');</script>
                </div>
                <div id="sheetLayer" style="display:none">
                	<script type="text/javascript">ComSheetObject('sheet3');</script>
                </div>
                <div id="sheetLayer" style="display:none">
                	<script type="text/javascript">ComSheetObject('sheet4');</script>
                </div>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>