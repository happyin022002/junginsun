<%  
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_3012.js
*@FileTitle  : TRI GRI Calculation - Route Point Select 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/
=========================================================
*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.triproposal.trigricalculationproposal.event.EsmPri3012Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%
    EsmPri3012Event event=null; //PDTO(Data Transfer Object including Parameters)
    Exception serverException=null; //error from server
    String strErrMsg=""; //error message
    int RowCount =0; //count of DB resultSET list
    String successFlag="";
    String codeList="";
    String pageRows="100";
    String strUsr_id="";
    String strUsr_nm="";
    Logger log=Logger.getLogger("com.clt.apps.TRIProposal.TRIGRICalculationProposal");
    try {
        SignOnUserAccount account=(SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id=account.getUsr_id();
        strUsr_nm=account.getUsr_nm();
        event=(EsmPri3012Event) request.getAttribute("Event");
        serverException=(Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg=new ErrorHandler(serverException).loadPopupMessage();
        }
        GeneralEventResponse eventResponse=(GeneralEventResponse) request.getAttribute("EventResponse");
    } catch (Exception e) {
        out.println(e.toString());
    }
%>

<script type="text/javascript">
    function setupPage(){
        var errMessage="<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            //showErrMessage(errMessage);
        } // end if
        loadPage();
    }
</script>

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- developer performance -->
<input type="hidden" name="trf_pfx_cd" value="<%=StringUtil.xssFilter(request.getParameter("trf_pfx_cd"))%>">
<input type="hidden" name="trf_no" value="<%=StringUtil.xssFilter(request.getParameter("trf_no"))%>">
<input type="hidden" name="gri_grp_seq" value="<%=StringUtil.xssFilter(request.getParameter("gri_grp_seq"))%>">
<input type="hidden" name="gri_appl_flg" value="<%=StringUtil.xssFilter(request.getParameter("gri_appl_flg"))%>">
<input type="hidden" name="is_req_usr" value="<%=StringUtil.xssFilter(request.getParameter("is_req_usr"))%>">
<input type="hidden" name="is_apro_usr" value="<%=StringUtil.xssFilter(request.getParameter("is_apro_usr"))%>">
<input type="hidden" name="org_dest_tp_cd" value="<%=StringUtil.xssFilter(request.getParameter("org_dest_tp_cd"))%>">
<input type="hidden" name="pnt_via_tp_cd" value="<%=StringUtil.xssFilter(request.getParameter("pnt_via_tp_cd"))%>">

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><span>TRI GRI Calculation - Route Point Select</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_ok" 	id="btn_ok">OK</button>
		<button type="button" class="btn_normal" name="btn_close" 	id="btn_close">Close</button>
	</div>
	<!-- opus_design_btn(E) -->	
	
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
		<table>
		   <colgroup>
		   		<col width="100"/>
		   		<col width="400"/>
		   		<col width="*"/>
		   </colgroup>
           <tr>
           		<td><strong>Route Point</strong></td>
                <td width="400" class="sm">
                   <input type="radio" id="pointType1" name="rt_pnt" value="0" class="trans" id="pointType1"><label for="pointType1"><strong>Origin</strong></label>
                   <input type="radio" id="pointType2" name="rt_pnt" value="1" class="trans" id="pointType2"><label for="pointType2"><strong>Origin Via</strong></label>
                   <input type="radio" id="pointType3" name="rt_pnt" value="2" class="trans" id="pointType3"><label for="pointType3"><strong>Destination Via</strong></label>
                   <input type="radio" id="pointType4" name="rt_pnt" value="3" class="trans" id="pointType4"><label for="pointType4"><strong>Destination</strong></label>
                </td>
                <td></td>
           </tr>
        </table>
	</div>
</div>

<div class="wrap_result">
	<div class="opus_design_grid">
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_add" 	id="btn_add">Row Add</button>
			<button type="button" class="btn_normal" name="btn_delete" 	id="btn_delete">Delete</button>
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
</form>