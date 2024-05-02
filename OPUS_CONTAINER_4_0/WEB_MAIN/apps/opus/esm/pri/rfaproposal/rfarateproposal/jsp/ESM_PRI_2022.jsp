<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2022.jsp
*@FileTitle  : RFA Proposal Creation - Rate (Commodity Note)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/28
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.event.EsmPri2022Event"%>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
    EsmPri2022Event event = null; //PDTO(Data Transfer Object including Parameters)
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

        event = (EsmPri2022Event) request.getAttribute("Event");
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
<input type="hidden" name="f_cmd" 		id="f_cmd" />
<input type="hidden" name="pagerows" 	id="pagerows" />
<input type="hidden" name="prop_no" 		value="<%=StringUtil.xssFilter(request.getParameter("prop_no")) %>" 		id="prop_no" />
<input type="hidden" name="amdt_seq" 		value="<%=StringUtil.xssFilter(request.getParameter("amdt_seq")) %>" 	id="amdt_seq" />
<input type="hidden" name="svc_scp_cd" 		value="<%=StringUtil.xssFilter(request.getParameter("svc_scp_cd")) %>" 	id="svc_scp_cd" />
<input type="hidden" name="pre_amdt_seq" 	value="<%=StringUtil.xssFilter(request.getParameter("pre_amdt_seq")) %>" id="pre_amdt_seq" />
<input type="hidden" name="prc_prop_sts_cd" value="<%=StringUtil.xssFilter(request.getParameter("prc_prop_sts_cd")) %>" id="prc_prop_sts_cd" />
<input type="hidden" name="eff_dt" 			value="<%=StringUtil.xssFilter(request.getParameter("eff_dt")) %>" 		id="eff_dt" />
<input type="hidden" name="exp_dt" 			value="<%=StringUtil.xssFilter(request.getParameter("exp_dt")) %>" 		id="exp_dt" />
<input type="hidden" name="pre_exp_dt" 		value="<%=StringUtil.xssFilter(request.getParameter("pre_exp_dt")) %>" 	id="pre_exp_dt" />
<input type="hidden" name="is_req_usr" 		value="<%=StringUtil.xssFilter(request.getParameter("is_req_usr")) %>" 	id="is_req_usr" />
<input type="hidden" name="is_apro_usr" 	value="<%=StringUtil.xssFilter(request.getParameter("is_apro_usr")) %>" 	id="is_apro_usr" />
<input type="hidden" name="dur_dup_flg" 	value="<%=StringUtil.xssFilter(request.getParameter("dur_dup_flg")) %>" 	id="dur_dup_flg" />
<input type="hidden" name="cmdt_hdr_seq" 	value="<%=StringUtil.xssFilter(request.getParameter("cmdt_hdr_seq")) %>" id="cmdt_hdr_seq" />
<input type="hidden" name="select_row" 		value="<%=StringUtil.xssFilter(request.getParameter("select_row")) %>" 	id="select_row" />
<input type="hidden" name="note_conv_mapg_id" value="<%=StringUtil.xssFilter(request.getParameter("note_conv_mapg_id")) %>" id="note_conv_mapg_id" />
<input type="hidden" name="cd" id="cd" />
<input type="hidden" name="before_exp_dt" id="before_exp_dt" />

<div class="layer_popup_title">
<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><span>RFA Proposal Creation - Rate (Commodity Note)</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		   <button class="btn_accent" name="btn_ok" id="btn_ok" type="button">OK</button><!--
		--><button class="btn_normal" name="btn_close" id="btn_close" type="button">Close</button><!--
		--></div>
	<!-- opus_design_btn (E) -->
</div>
<!-- page_title_area(E) -->
</div>
<div class="layer_popup_contents">
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<div class="opus_design_grid">
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
		   <button class="btn_accent" name="btn_add" id="btn_add" type="button">Row Add</button><!--
		--><button class="btn_normal" name="btn_delete" id="btn_delete" type="button">Delete</button><!--
		--><button class="btn_normal" name="btn_amend" id="btn_amend" type="button">Amend</button><!--
		--><button class="btn_normal" name="btn_amendcancel" id="btn_amendcancel" type="button">Amend Cancel</button><!--
		--><button class="btn_normal" name="btn_accept" id="btn_accept" type="button">Accept</button><!--
		--><button class="btn_normal" name="btn_acceptcancel" id="btn_acceptcancel" type="button">Accept Cancel</button><!--
		--></div>
		<!-- opus_design_btn (E) -->
		<script type="text/javascript">ComSheetObject('sheet2');</script>		
	</div>
	<!-- opus_design_grid(E) -->
<div class="opus_design_data">
	<table class="grid_2">
		<colgroup>
			<col width="150" />				
			<col width="*" />				
	   </colgroup> 
	   <tbody>
	   		<tr>
	   		<th align="center">Commodity Note</th>
			<td><textarea name="ta_note_ctnt" id="ta_note_ctnt" style="resize:none;width:100%;height:80px" ></textarea></td>
			</tr>
		</tbody>
	</table>
</div>
<div class="opus_design_grid">
	<h3 style="margin-bottom:0" class="title_design">Conversion</h3>
	<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">  
		   <button class="btn_accent" name="btn_autoword" id="btn_autoword" type="button" >Auto Wording</button><!-- 
		--><button class="btn_normal" name="btn_copy" id="btn_copy" type="button">Copy</button><!--
		--><button class="btn_normal" name="btn_paste" id="btn_paste" type="button">Paste</button><!-- 
		--><input class="floatL mar_rgt_none mar_left_4" type="text" style="width: 40px;text-align:right;" name="txt_rowcnt" id="txt_rowcnt" dataformat="int" class="input" maxlength=2><!--
		--><button class="btn_normal" name="btn_rowadd3" id="btn_rowadd3" type="button">Row Add</button><!--
		--><button class="btn_normal" name="btn_rowcopy" id="btn_rowcopy" type="button">Row Copy</button><!--
		--><button class="btn_normal" name="btn_delete3" id="btn_delete3" type="button">Delete</button><!--
		--></div>
		<!-- opus_design_btn (E) -->
		<script type="text/javascript">ComSheetObject('sheet3');</script>		
</div>	   		
</div>
</div>
<div id="hiddenSheetLayer" style="display: none">
<script type="text/javascript">ComSheetObject('sheet4');</script>
</div>
</form>
