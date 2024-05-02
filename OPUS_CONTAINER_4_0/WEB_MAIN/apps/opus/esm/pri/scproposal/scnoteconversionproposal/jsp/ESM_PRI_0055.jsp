<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0055.jsp
*@FileTitle  : Special Note Conversion - Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/27
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
<%@ page import="com.clt.apps.opus.esm.pri.scproposal.scnoteconversionproposal.event.EsmPri0055Event"%>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri0055Event  event = null;					// PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";

	String[] noteClssSd = null;			//NOTE CLASSIFICATION CODE
	String[] multRuleApplChgTpCd = null;//TYPE(MULTI COMBO)
	String[] ruleApplChgTpCd = null;	//TYPE
	String[] rtApplTpCd = null;		    //APLICATION
	String[] payTermCd = null;    		//PAY TERM
	String[] bkgUsaSvcModCd = null;    	//US SVC MODE
	String[] bkgRcvTermCd = null;    	//RECEIVING TERM
	String[] bkgDeTermCd = null;    	//DELIVERY TERM
	String[] bkgOrgTrspModCd = null;    //ORG. TRANS. MODE
	String[] bkgDestTrspModCd = null;  	//DEST. TRANS. MODE
	String[] bkgMstHblTpCd = null;    	//BL TYPE

	String[] genSpclRtTpCd = null;    	//RATE INDICATOR
	String[] convPrcRcvTermCd = null;   //ORG. TRANS. MODE (in S/C)
	String[] convPrcDeTermCd = null;    //DEST. TRANS. MODE (in S/C)
	String[] bkgScgGrpCmdtCd = null;	//GRI Commodity

	String[] bkgIoGaCd = null;			//IN/OUT GAUGE
	String[] bkgCnlTzCd = null;    		//CANAL
	String[] bkgEsvcTpCd = null;    	//B/I

	Logger log = Logger.getLogger("com.clt.apps.SCProposal.SCNoteConversionProposal");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmPri0055Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		//COMMBO LIST
		noteClssSd 			= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("NOTE_CLSS_CD"), false);
		multRuleApplChgTpCd = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("RULE_APPL_CHG_TP_CD"), false);

		ruleApplChgTpCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("RULE_APPL_CHG_TP_CD"), false);
        rtApplTpCd 			= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("RT_APPL_TP_CD"), false);
        payTermCd 			= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("PAY_TERM_CD"), false);   
        bkgUsaSvcModCd		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("BKG_USA_SVC_MOD_CD"), false);
        bkgRcvTermCd		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("BKG_RCV_TERM_CD"), false);
        bkgDeTermCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("BKG_DE_TERM_CD"), false); 

        bkgOrgTrspModCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("BKG_ORG_TRSP_MOD_CD"), false); 
        bkgDestTrspModCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("BKG_DEST_TRSP_MOD_CD"), false); 
        bkgMstHblTpCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("BKG_MST_HBL_TP_CD"), false);
        genSpclRtTpCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("GEN_SPCL_RT_TP_CD"), false); 
        convPrcRcvTermCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("CONV_PRC_RCV_TERM_CD"), false); 
        convPrcDeTermCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("CONV_PRC_DE_TERM_CD"), false);
        bkgScgGrpCmdtCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("BKG_SCG_GRP_CMDT_CD"), false);

    	bkgIoGaCd 			= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("BKG_IO_GA_CD"), false);      
    	bkgCnlTzCd 			= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("BKG_CNL_TZ_CD"), false);
    	bkgEsvcTpCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("BKG_ESVC_TP_CD"), false);

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	var noteClssSdComboValue = " |<%=noteClssSd[0]%>";
    var noteClssSdComboText = " |<%=noteClssSd[1]%>";

	var multRuleApplChgTpCdComboValue = " |<%=multRuleApplChgTpCd[0]%>";
    var multRuleApplChgTpCdComboText = " |<%=multRuleApplChgTpCd[1]%>";

	var ruleApplChgTpCdComboValue = " |<%=ruleApplChgTpCd[0]%>";
    var ruleApplChgTpCdComboText = " |<%=ruleApplChgTpCd[1]%>";

	var rtApplTpCdComboValue = " |<%=rtApplTpCd[0]%>";
    var rtApplTpCdComboText = " |<%=rtApplTpCd[1]%>";

    var payTermCdComboValue = " |<%=payTermCd[0]%>";   
    var payTermCdComboText = " |<%=payTermCd[1]%>";

    var bkgUsaSvcModCdComboValue = " |<%=bkgUsaSvcModCd[0]%>";   
    var bkgUsaSvcModCdComboText = " |<%=bkgUsaSvcModCd[1]%>";

    var bkgRcvTermCdComboValue = " |<%=bkgRcvTermCd[0]%>";   
    var bkgRcvTermCdComboText = " |<%=bkgRcvTermCd[1]%>";

    var bkgDeTermCdComboValue = " |<%=bkgDeTermCd[0]%>";   
    var bkgDeTermCdComboText = " |<%=bkgDeTermCd[1]%>";

    var bkgOrgTrspModCdComboValue = " |<%=bkgOrgTrspModCd[0]%>";   
    var bkgOrgTrspModCdComboText = " |<%=bkgOrgTrspModCd[1]%>";

    var bkgDestTrspModCdComboValue = " |<%=bkgDestTrspModCd[0]%>";   
    var bkgDestTrspModCdComboText = " |<%=bkgDestTrspModCd[1]%>";

    var genSpclRtTpCdComboValue = " |<%=genSpclRtTpCd[0]%>";   
    var genSpclRtTpCdComboText = " |<%=genSpclRtTpCd[1]%>";

    var bkgMstHblTpCdValue = " |<%=bkgMstHblTpCd[0]%>";   
    var bkgMstHblTpCdText = " |<%=bkgMstHblTpCd[1]%>";

    var convPrcRcvTermCdComboValue = " |<%=convPrcRcvTermCd[0]%>";   
    var convPrcRcvTermCdComboText = " |<%=convPrcRcvTermCd[1]%>";

    var convPrcDeTermCdComboValue = " |<%=convPrcDeTermCd[0]%>";   
    var convPrcDeTermCdComboText = " |<%=convPrcDeTermCd[1]%>";

    var bkgIoGaCdComboValue = " |<%=bkgIoGaCd[0]%>";   
    var bkgIoGaCdComboText = " |<%=bkgIoGaCd[1]%>";

    var bkgCnlTzCdComboValue = " |<%=bkgCnlTzCd[0]%>";   
    var bkgCnlTzCdComboText = " |<%=bkgCnlTzCd[1]%>";

    var bkgEsvcTpCdComboValue = " |<%=bkgEsvcTpCd[0]%>";   
    var bkgEsvcTpCdComboText = " |<%=bkgEsvcTpCd[1]%>";

    var bkgScgGrpCmdtCdComboValue = " |<%=bkgScgGrpCmdtCd[0]%>";   
    var bkgScgGrpCmdtCdComboText = " |<%=bkgScgGrpCmdtCd[1]%>";

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />

<input type="hidden" name="cd" id="cd" />
<input type="hidden" name="svc_scp_cd" value="<%=StringUtil.xssFilter(request.getParameter("svc_scp_cd")) %>" id="svc_scp_cd" />
<input type="hidden" name="prop_no" value="<%=StringUtil.xssFilter(request.getParameter("prop_no")) %>" id="prop_no" />
<input type="hidden" name="amdt_seq" value="<%=StringUtil.xssFilter(request.getParameter("amdt_seq")) %>" id="amdt_seq" />
<input type="hidden" name="eff_dt" value="<%=StringUtil.xssFilter(request.getParameter("eff_dt")) %>" id="eff_dt" />
<input type="hidden" name="exp_dt" value="<%=StringUtil.xssFilter(request.getParameter("exp_dt")) %>" id="exp_dt" />
<input type="hidden" name="note_seq" value="<%=StringUtil.xssFilter(request.getParameter("note_seq")) %>" id="note_seq" />
<input type="hidden" name="note_ctnt_seq" value="<%=StringUtil.xssFilter(request.getParameter("note_ctnt_seq")) %>" id="note_ctnt_seq" />
<input type="hidden" name="note_conv_mapg_id" value="<%=StringUtil.xssFilter(java.net.URLDecoder.decode(request.getParameter("note_conv_mapg_id"), "UTF-8")) %>" id="note_conv_mapg_id" />
<input type="hidden" name="note_tp_cd" value="<%=StringUtil.xssFilter(request.getParameter("note_tp_cd")) %>" id="note_tp_cd" />
<input type="hidden" name="master_seq" value="<%=StringUtil.xssFilter(request.getParameter("master_seq")) %>" id="master_seq" />
<input type="hidden" name="detail_seq" value="<%=StringUtil.xssFilter(request.getParameter("detail_seq")) %>" id="detail_seq" />
<input type="hidden" name="note_conv_tp_cd" value="P" id="note_conv_tp_cd" />

<div class="layer_popup_title">
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><span>Special Note Conversion - Inquiry</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" 	id="btn_retrieve">Retrieve</button>
		<button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
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
	<div class="wrap_result">
		<!-- layout_wrap(S) -->
		<div class="layout_wrap">
		   <!-- layout_flex_fixed(S) -->
		   <div class="layout_flex_fixed" style="width:400px">
		       <!-- opus_design_grid(S) -->
		       <div class="opus_design_grid">
		           <script type="text/javascript">ComSheetObject('sheet1');</script>
		       </div>
		       <!-- opus_design_grid(E) -->
		   </div>
		   <!-- layout_flex_fixed(E) -->
		   <!-- layout_flex_fixed(S) -->
		   <div class="pad_left_8 layout_flex_fixed" style="width:30px">
		   		<div style="height: 40px;">&nbsp;</div>
			 	<button type="button" class="btn_right"></button>
		   </div>
		   <!-- layout_flex_fixed(E) -->
		   <!-- layout_flex_flex(S) -->
		   <div class="layout_flex_flex" style="padding-left:438px">
		   		<!-- opus_design_grid(S) -->
		       <div class="opus_design_grid">
		           <script type="text/javascript">ComSheetObject('sheet2');</script>
		       </div>
		       <!-- opus_design_grid(E) -->
		   </div>
		   <!-- layout_flex_flex(E) -->
		</div>
		<!-- layout_wrap(E) -->
		<div class= "opus_design_inquiry" style="margin-top:30px">
			<table>
				<colgroup>
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<td><textarea name="note_ctnt" style="width: 100%; height: 90px; resize:none; maxlength:2000;" class="textarea2" readonly="readonly"></textarea></td>
					</tr>
				</tbody>
			</table>
			<table class="line_bluedot"><tr><td></td></tr></table>
			<table>
				<colgroup>
					<col width="50" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th>C/TYPE</th>
						<td width=""><script type="text/javascript">ComComboObject("note_chg_tp_cd", 1, 130, 1, 1, 0, false);</script>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_grid(S) -->
       <div class="opus_design_grid">
           <script type="text/javascript">ComSheetObject('sheet3');</script>
       </div>
       <!-- opus_design_grid(E) -->
	</div>		
	
</div>
</form>