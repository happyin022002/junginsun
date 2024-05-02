<%  
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESM_PRI_2025.jsp
*@FileTitle : RFA Proposal Creation - Rate (Route Point)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/28
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
<%@ page import="com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.event.EsmPri2025Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
    EsmPri2025Event event = null; //PDTO(Data Transfer Object including Parameters)
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

        event = (EsmPri2025Event) request.getAttribute("Event");
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
<input type="hidden" name="pre_amdt_seq" value="<%=StringUtil.xssFilter(request.getParameter("pre_amdt_seq")) %>" id="pre_amdt_seq" />
<input type="hidden" name="prc_prop_sts_cd" value="<%=StringUtil.xssFilter(request.getParameter("prc_prop_sts_cd")) %>" id="prc_prop_sts_cd" />
<input type="hidden" name="eff_dt" value="<%=StringUtil.xssFilter(request.getParameter("eff_dt")) %>" id="eff_dt" />
<input type="hidden" name="exp_dt" value="<%=StringUtil.xssFilter(request.getParameter("exp_dt")) %>" id="exp_dt" />
<input type="hidden" name="pre_exp_dt" value="<%=StringUtil.xssFilter(request.getParameter("pre_exp_dt")) %>" id="pre_exp_dt" />
<input type="hidden" name="is_req_usr" value="<%=StringUtil.xssFilter(request.getParameter("is_req_usr")) %>" id="is_req_usr" />
<input type="hidden" name="is_apro_usr" value="<%=StringUtil.xssFilter(request.getParameter("is_apro_usr")) %>" id="is_apro_usr" />
<input type="hidden" name="dur_dup_flg" value="<%=StringUtil.xssFilter(request.getParameter("dur_dup_flg")) %>" id="dur_dup_flg" />
<input type="hidden" name="cmdt_hdr_seq" value="<%=StringUtil.xssFilter(request.getParameter("cmdt_hdr_seq")) %>" id="cmdt_hdr_seq" />
<input type="hidden" name="rout_seq" value="<%=StringUtil.xssFilter(request.getParameter("rout_seq")) %>" id="rout_seq" />
<input type="hidden" name="org_dest_tp_cd" value="<%=StringUtil.xssFilter(request.getParameter("org_dest_tp_cd")) %>" id="org_dest_tp_cd" />
<input type="hidden" name="pnt_via_tp_cd" value="<%=StringUtil.xssFilter(request.getParameter("pnt_via_tp_cd")) %>" id="pnt_via_tp_cd" />

<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>RFA Proposal Creation - Rate (Route Point)</span></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_ok" id="btn_ok" type="button">OK</button><!--
			--><button class="btn_normal" name="btn_close" id="btn_close" type="button">Close</button>
		</div>
		<!-- opus_design_btn (E) -->
	</div>
	<!-- page_title_area(E) -->
</div>

<div class="layer_popup_contents">
	<div class="wrap_result">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry">
			<table class="sm" style="width:550px;">
				<colgroup>
					<col width="90">
					<col width="410">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
	                    <th>Route Point</th>
	                    <td class="stm" style="font-size:12px;padding-left:15px;">
	                        <input type="radio" id="pointType1" name="rt_pnt" value="0" class="trans"> <label for="pointType1">Origin</label>&nbsp;&nbsp;&nbsp;&nbsp;<!--  
	                        --><input type="radio" id="pointType2" name="rt_pnt" value="1" class="trans"> <label for="pointType2">Origin Via</label>&nbsp;&nbsp;&nbsp;&nbsp;<!--  
	                        --><input type="radio" id="pointType3" name="rt_pnt" value="2" class="trans"> <label for="pointType3">Destination Via</label>&nbsp;&nbsp;&nbsp;&nbsp;<!--  
	                        --><input type="radio" id="pointType4" name="rt_pnt" value="3" class="trans"> <label for="pointType4">Destination</label></td>
	                        <td></td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
		<div class="opus_design_grid" id="mainTable">
			<div class="opus_design_btn">
				<button class="btn_normal" name="btn_add" id="btn_add" type="button" suppressWait="Y">Row Add</button><!--  
				--><button class="btn_normal" name="btn_copy" id="btn_copy" type="button" suppressWait="Y">Row Copy</button><!--  
				--><button class="btn_normal" name="btn_delete" id="btn_delete" type="button" suppressWait="Y">Delete</button><!--  
				--><button class="btn_normal" name="btn_amend" id="btn_amend" type="button" suppressWait="Y">Amend</button><!--  
				--><button class="btn_normal" name="btn_amendcancel" id="btn_amendcancel" type="button">Amend Cancel</button><!--  
				--><button class="btn_normal" name="btn_accept" id="btn_accept" type="button">Accept</button><!--  
				--><button class="btn_normal" name="btn_acceptcancel" id="btn_acceptcancel" type="button">Accept Cancel</button>
			</div>
			<div id="sheetLayer" style="display:none;">
            	<script type="text/javascript">ComSheetObject('sheet1');</script>
            </div>
            <div id="sheetLayer" style="display:none;">
            	<script type="text/javascript">ComSheetObject('sheet2');</script>
            </div>
            <div id="sheetLayer" style="display:none;">
            	<script type="text/javascript">ComSheetObject('sheet3');</script>
            </div>
            <div id="sheetLayer" style="display:none;">
            	<script type="text/javascript">ComSheetObject('sheet4');</script>
            </div>
		</div>
	</div>
</div>
</form>
