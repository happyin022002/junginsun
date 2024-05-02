<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0063.jsp
*@FileTitle  : GRI Group Commodity Guideline Select 
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
<%@ page import="com.clt.apps.opus.esm.pri.scproposal.scproposalmain.event.EsmPri0063Event"%>
<%@ page import="com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RsltPriSgGrpCmdtVO"%>
<%@ page import="com.clt.syscommon.common.table.PriSpScpMnVO" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmPri0063Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //count of DB resultSET list

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";

    String propNo = null;
    String amdtSeq = null;
    String svcScpCd = null;

    String svcScpNm = null;
    String effDt = null;
    String expDt = null;
    String prcCustTpCd = null;
    PriSpScpMnVO spVo = null;

    Logger log = Logger.getLogger("com.clt.apps.SCProposal.SCProposalMain");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();

        event = (EsmPri0063Event)request.getAttribute("Event");

        RsltPriSgGrpCmdtVO vo = event.getRsltPriSgGrpCmdtVO();

        if (vo != null) {
            propNo   = vo.getPropNo();
            amdtSeq  = vo.getAmdtSeq();
            svcScpCd = vo.getSvcScpCd();
            prcCustTpCd = vo.getPrcCustTpCd();

            effDt = DateTime.getFormatDate(vo.getEffDt().replaceAll("-",""), "yyyyMMdd", "yyyy-MM-dd");
            expDt = DateTime.getFormatDate(vo.getExpDt().replaceAll("-",""), "yyyyMMdd", "yyyy-MM-dd");
        } else {
            propNo   = "";
            amdtSeq  = "";
            svcScpCd = "";
            prcCustTpCd = "";
            effDt = "";
            expDt = "";
        }

        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // adding logic to get data from server when first loading
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

        svcScpNm = (String)eventResponse.getCustomData("svcScpNm");

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

<input type="hidden" name="prop_no" value="<%=propNo   %>" id="prop_no" />
<input type="hidden" name="amdt_seq" value="<%=amdtSeq  %>" id="amdt_seq" />
<input type="hidden" name="svc_scp_cd" value="<%=svcScpCd %>" id="svc_scp_cd" />

<input type="hidden" name="gline_seq" id="gline_seq" />
<input type="hidden" name="grp_cmdt_seq" id="grp_cmdt_seq" />

<input type="hidden" name="eff_dt" value="<%=StringUtil.xssFilter(request.getParameter(" eff_dt")) %>" id="eff_dt" />
<!--<input type="hidden" name="prc_cust_tp_cd" value="<%=StringUtil.xssFilter(request.getParameter("prc_cust_tp_cd"))%>">-->

<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><span>GRI Group Commodity Guideline Select</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_OK" 	id="btn_OK">OK</button>
			<button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->
		<!-- page_location(S) -->
		<div class="location">
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->
	</div>
	<!-- page_title_area(E) -->
</div>
<div class="layer_popup_contents">	
	<div class= "wrap_search">
		<div class= "opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="80" />
					<col width="200" />
					<col width="100" />
					<col width="70" />
					<col width="100" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
	                    <th>SVC Scope.</th>
	                    <td><input type="text" style="width:200px;" class="input2" value="<%=svcScpNm %>" readonly="readonly" /></td>
	                    <th>Effective Date </th>
	                    <td><input type="text" style="width:70px;" class="input2" value="<%=effDt %>" readonly="readonly" />~ <input type="text" style="width:70px;" class="input2" value="<%=expDt %>" readonly="readonly" /></td>
	                    <th>Customer Type </th>
	                    <td><input type="text" name="prc_cust_tp_cd" style="width:20px;text-align:center;" class="input2" value="<%=prcCustTpCd %>" readonly="readonly" id="prc_cust_tp_cd" /></td>
	                </tr>
				</tbody>
			</table>
		</div>
	</div>		
	<div class="wrap_result">
		<!-- layout_wrap(S) -->
		<div class="layout_wrap">
		   <!-- layout_flex_fixed(S) -->
		   <div class="layout_flex_fixed" style="width:350px">
		       <!-- opus_design_grid(S) -->
		       <div class="opus_design_grid">
		       		<!-- opus_design_btn(S) -->
					<div class="opus_design_btn">
						<button type="button" class="btn_accent" name="btn_Retrieve" 	id="btn_Retrieve">Retrieve</button>
					</div>
					<!-- opus_design_btn(E) -->
		           <script type="text/javascript">ComSheetObject('sheet1');</script>
		       </div>
		       <!-- opus_design_grid(E) -->
		   </div>
		   <!-- layout_flex_fixed(E) -->
		   <!-- layout_flex_fixed(S) -->
		   <div class="pad_left_8 layout_flex_fixed" style="width:30px;margin-top:30px">
		       <button type="button" class="btn_right"></button>
		   </div>
		   <!-- layout_flex_fixed(E) -->
		   <!-- layout_flex_flex(S) -->
		   <div class="layout_flex_flex" style="padding-left:388px">
		   		<!-- opus_design_grid(S) -->
		       <div class="opus_design_grid">
		       		<!-- opus_design_btn(S) -->
					<div class="opus_design_btn">
						<button type="button" class="btn_accent" name="btn_CheckAll" 	id="btn_CheckAll">Check All</button>
						<button type="button" class="btn_normal" name="btn_UncheckAll" 	id="btn_UncheckAll">Uncheck All</button>
					</div>
					<!-- opus_design_btn(E) -->
		           <script type="text/javascript">ComSheetObject('sheet2');</script>
		       </div>
		       <!-- opus_design_grid(E) -->
		   </div>
		   <!-- layout_flex_flex(E) -->
		</div>
		<!-- layout_wrap(E) -->
	</div>	
</div>
</form>