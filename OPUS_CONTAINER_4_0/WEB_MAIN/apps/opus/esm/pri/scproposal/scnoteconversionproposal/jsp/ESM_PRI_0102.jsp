<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0102.jsp
*@FileTitle  : Note Conversion History - Special Note Conversion
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/15
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.scproposal.scnoteconversionproposal.event.EsmPri0102Event"%>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri0102Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";

	String svcScpCd 		= "";
	String propNo 			= "";
	String amdtSeq 			= "";
	String effDt 			= "";
	String expDt 			= "";
	String noteSeq 			= "";
	String noteCtntSeq 		= "";
	String noteConvMapgId	= "";
	String noteTpCd 		= "";
	String masterSeq 		= "";
	String detailSeq 		= "";	
	String propStsCd 		= "";
	String convCfmFlg 		= "";
	String prcPropCreTpCd 	= "";
	String lgcyIfFlg		= "";
	String ofcAuthYn		= "";
	String conChk			= "";
	
	String[] noteClssSd = null;			//NOTE CLASSIFICATION CODE
	String[] multRuleApplChgTpCd = null;//TYPE(MULTI COMBO)
	String[] ruleApplChgTpCd = null;	//TYPE
	String[] rtApplTpCd = null;		    //APLICATION
	String[] bkgPrcCgoTpCd = null;    	//CARGO TYPE
	String[] rtOpCd = null;    			//CAL.
	String[] payTermCd = null;    		//PAY TERM
	String[] bkgUsaSvcModCd = null;    	//US SVC MODE
	String[] bkgRcvTermCd = null;    	//RECEIVING TERM
	String[] bkgDeTermCd = null;    	//DELIVERY TERM
	String[] convPrcCgoTpCd = null;    	//CARGO TYPE(in S/C)
	String[] bkgOrgTrspModCd = null;    //ORG. TRANS. MODE
	String[] bkgDestTrspModCd = null;  	//DEST. TRANS. MODE
	String[] bkgMstHblTpCd = null;    	//BL TYPE
	
	String[] genSpclRtTpCd = null;    	//RATE INDICATOR
	String[] convPrcRcvTermCd = null;   //ORG. TRANS. MODE (in S/C)
	String[] convPrcDeTermCd = null;    //DEST. TRANS. MODE (in S/C)
	
	String[] bkgRatUtCd = null;			//PER TYPE
	String[] currCd = null;				//CURRENCY
	String[] convRatUtCd = null;		//PER TYPE( IN S/C)
	String[] bkgScgGrpCmdtCd = null;	//GRI Commodity
	String[] ruleCd = null;				//NOTE CONVERSION RULE CODE 
	String[] chargeCd = null;    		//SCOPE CHARGE CODE LIST

	String[] bkgIoGaCd = null;			//IN/OUT GAUGE
	String[] bkgCnlTzCd = null;    		//CANAL
	String[] bkgEsvcTpCd = null;    	//B/I
	
	Logger log = Logger.getLogger("com.clt.apps.SCProposal.SCNoteConversionProposal");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri0102Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		//PARAM
		svcScpCd 		= JSPUtil.getNull(request.getParameter("svc_scp_cd"));
		propNo 			= JSPUtil.getNull(request.getParameter("prop_no"));
		amdtSeq 		= JSPUtil.getNull(request.getParameter("amdt_seq"));
		effDt 			= JSPUtil.getNull(request.getParameter("eff_dt"));
		expDt 			= JSPUtil.getNull(request.getParameter("exp_dt"));
		noteSeq 		= JSPUtil.getNull(request.getParameter("note_seq"));
		noteCtntSeq 	= JSPUtil.getNull(request.getParameter("note_ctnt_seq"));
		noteConvMapgId	= JSPUtil.getNull(request.getParameter("note_conv_mapg_id"));
		noteTpCd 		= JSPUtil.getNull(request.getParameter("note_tp_cd"));
		masterSeq 		= JSPUtil.getNull(request.getParameter("master_seq"));
		detailSeq 		= JSPUtil.getNull(request.getParameter("detail_seq"));
		propStsCd 		= JSPUtil.getNull(request.getParameter("prop_sts_cd"));
		conChk 			= JSPUtil.getNull(request.getParameter("con_chk"));

		//COMMBO LIST
		noteClssSd 			= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("NOTE_CLSS_CD"), false);
		multRuleApplChgTpCd = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("RULE_APPL_CHG_TP_CD"), false);
		
		ruleApplChgTpCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("RULE_APPL_CHG_TP_CD"), false);
        rtApplTpCd 			= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("RT_APPL_TP_CD"), false);
        bkgPrcCgoTpCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("BKG_PRC_CGO_TP_CD"), false);       
        rtOpCd 				= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("RT_OP_CD"));      
        payTermCd 			= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("PAY_TERM_CD"), false);   
        bkgUsaSvcModCd		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("BKG_USA_SVC_MOD_CD"), false);
        bkgRcvTermCd		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("BKG_RCV_TERM_CD"), false);
        bkgDeTermCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("BKG_DE_TERM_CD"), false);  
        convPrcCgoTpCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("CONV_PRC_CGO_TP_CD"), false);
        
        bkgOrgTrspModCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("BKG_ORG_TRSP_MOD_CD"), false); 
        bkgDestTrspModCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("BKG_DEST_TRSP_MOD_CD"), false); 
        bkgMstHblTpCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("BKG_MST_HBL_TP_CD"), false);
        genSpclRtTpCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("GEN_SPCL_RT_TP_CD"), false); 
        convPrcRcvTermCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("CONV_PRC_RCV_TERM_CD"), false); 
        convPrcDeTermCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("CONV_PRC_DE_TERM_CD"), false);
        
        bkgRatUtCd 			= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("BKG_RAT_UT_CD"), false);      
        currCd 				= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("CURR_CD"), false);   
        convRatUtCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("CONV_RAT_UT_CD"), false);      
        bkgScgGrpCmdtCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("BKG_SCG_GRP_CMDT_CD"), false);       
        ruleCd 				= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("RULE_CD"));       
        chargeCd 			= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("CHARGE_CD"));

    	bkgIoGaCd 			= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("BKG_IO_GA_CD"), false);      
    	bkgCnlTzCd 			= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("BKG_CNL_TZ_CD"), false);
    	bkgEsvcTpCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("BKG_ESVC_TP_CD"), false);

        prcPropCreTpCd		= (String)eventResponse.getCustomData("PRC_PROP_CRE_TP_CD");
        convCfmFlg			= (String)eventResponse.getCustomData("CONV_CFM_FLG");
        lgcyIfFlg			= (String)eventResponse.getCustomData("LGCY_IF_FLG");
        ofcAuthYn			= (String)eventResponse.getCustomData("OFC_AUTH_YN");
 
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

    var bkgPrcCgoTpCdComboValue = " |<%=bkgPrcCgoTpCd[0]%>";
    var bkgPrcCgoTpCdComboText = " |<%=bkgPrcCgoTpCd[1]%>";
        
    var rtOpCdComboValue = "<%=rtOpCd[0]%>";   
    var rtOpCdComboText = "<%=rtOpCd[1]%>";

    var payTermCdComboValue = " |<%=payTermCd[0]%>";   
    var payTermCdComboText = " |<%=payTermCd[1]%>";
    
    var bkgUsaSvcModCdComboValue = " |<%=bkgUsaSvcModCd[0]%>";   
    var bkgUsaSvcModCdComboText = " |<%=bkgUsaSvcModCd[1]%>";
    
    var bkgRcvTermCdComboValue = " |<%=bkgRcvTermCd[0]%>";   
    var bkgRcvTermCdComboText = " |<%=bkgRcvTermCd[1]%>";
    
    var bkgDeTermCdComboValue = " |<%=bkgDeTermCd[0]%>";   
    var bkgDeTermCdComboText = " |<%=bkgDeTermCd[1]%>";
    
    var convPrcCgoTpCdComboValue = " |<%=convPrcCgoTpCd[0]%>";   
    var convPrcCgoTpCdComboText = " |<%=convPrcCgoTpCd[1]%>";
    
    var bkgOrgTrspModCdComboValue = " |<%=bkgOrgTrspModCd[0]%>";   
    var bkgOrgTrspModCdComboText = " |<%=bkgOrgTrspModCd[1]%>";
    
    var bkgDestTrspModCdComboValue = " |<%=bkgDestTrspModCd[0]%>";   
    var bkgDestTrspModCdComboText = " |<%=bkgDestTrspModCd[1]%>";
    
    var bkgMstHblTpCdValue = " |<%=bkgMstHblTpCd[0]%>";   
    var bkgMstHblTpCdText = " |<%=bkgMstHblTpCd[1]%>";
    
    var genSpclRtTpCdComboValue = " |<%=genSpclRtTpCd[0]%>";   
    var genSpclRtTpCdComboText = " |<%=genSpclRtTpCd[1]%>";
    
    var convPrcRcvTermCdComboValue = " |<%=convPrcRcvTermCd[0]%>";   
    var convPrcRcvTermCdComboText = " |<%=convPrcRcvTermCd[1]%>";
    
    var convPrcDeTermCdComboValue = " |<%=convPrcDeTermCd[0]%>";   
    var convPrcDeTermCdComboText = " |<%=convPrcDeTermCd[1]%>";
        
    var bkgRatUtCdComboValue = " |<%=bkgRatUtCd[0]%>";   
    var bkgRatUtCdComboText = " |<%=bkgRatUtCd[1]%>";
    
    var currCdComboValue = "<%=currCd[0]%>";   
    var currCdComboText = "<%=currCd[1]%>";
    
    var convRatUtCdComboValue = " |<%=convRatUtCd[0]%>";   
    var convRatUtCdComboText = " |<%=convRatUtCd[1]%>";
    
    var bkgScgGrpCmdtCdComboValue = " |<%=bkgScgGrpCmdtCd[0]%>";   
    var bkgScgGrpCmdtCdComboText = " |<%=bkgScgGrpCmdtCd[1]%>";
        
    var chargeRuleCdComboValue = " |<%=(chargeCd[0].length()>0)? ruleCd[0]+"|"+chargeCd[0]:ruleCd[0]%>";   
    var chargeRuleCdComboText = " |<%=(chargeCd[0].length()>0)? ruleCd[1]+"|"+chargeCd[1]:ruleCd[1]%>";  

    var bkgIoGaCdComboValue = " |<%=bkgIoGaCd[0]%>";   
    var bkgIoGaCdComboText = " |<%=bkgIoGaCd[1]%>";
    
    var bkgCnlTzCdComboValue = " |<%=bkgCnlTzCd[0]%>";   
    var bkgCnlTzCdComboText = " |<%=bkgCnlTzCd[1]%>";

    var bkgEsvcTpCdComboValue = " |<%=bkgEsvcTpCd[0]%>";   
    var bkgEsvcTpCdComboText = " |<%=bkgEsvcTpCd[1]%>";
                
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
<input type="hidden" name="svc_scp_cd" value="<%=svcScpCd%>" id="svc_scp_cd" />
<input type="hidden" name="prop_no" value="<%=propNo%>" id="prop_no" />
<input type="hidden" name="amdt_seq" value="<%=amdtSeq%>" id="amdt_seq" />
<input type="hidden" name="eff_dt" value="<%=effDt%>" id="eff_dt" />
<input type="hidden" name="exp_dt" value="<%=expDt%>" id="exp_dt" />
<input type="hidden" name="note_seq" value="<%=noteSeq%>" id="note_seq" />
<input type="hidden" name="note_ctnt_seq" value="<%=noteCtntSeq%>" id="note_ctnt_seq" />
<input type="hidden" name="note_conv_mapg_id" value="<%=noteConvMapgId%>" id="note_conv_mapg_id" />
<input type="hidden" name="note_tp_cd" value="<%=noteTpCd%>" id="note_tp_cd" />
<input type="hidden" name="master_seq" value="<%=masterSeq%>" id="master_seq" />
<input type="hidden" name="detail_seq" value="<%=detailSeq%>" id="detail_seq" />
<input type="hidden" name="prop_sts_cd" value="<%=propStsCd%>" id="prop_sts_cd" />
<input type="hidden" name="conv_cfm_flg" value="<%=convCfmFlg%>" id="conv_cfm_flg" />
<input type="hidden" name="note_conv_tp_cd" value="P" id="note_conv_tp_cd" />
<input type="hidden" name="note_tp_cd" value="P" id="note_tp_cd" />
<input type="hidden" name="prc_prop_cre_tp_cd" value="<%=prcPropCreTpCd%>" id="prc_prop_cre_tp_cd" />
<input type="hidden" name="lgcy_if_flg" value="<%=lgcyIfFlg%>" id="lgcy_if_flg" />
<input type="hidden" name="ofc_auth_yn" value="<%=ofcAuthYn%>" id="ofc_auth_yn" />
<input type="hidden" name="con_chk" value="<%=conChk%>" id="con_chk" /> 

<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Note Conversion History - Special Note Conversion Creation</span></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
			--><button class="btn_normal" name="btn_save" id="btn_save" type="button">Save</button><!--
			--><button class="btn_normal" name="btn_close" id="btn_close" type="button">Close</button>
		</div>
		<!-- opus_design_btn (E) -->
	</div>
	<!-- page_title_area(E) -->
</div>

<div class="layer_popup_contents">
	<div class="wrap_result">
		<!-- layout_wrap(S) -->
		<div class="layout_wrap">
		    <div class="layout_vertical_3" style="width:38%;">
		        <!-- opus_design_grid(S) -->
		        <div class="opus_design_grid" id="mainTable">
		            <script type="text/javascript">ComSheetObject('sheet1');</script>
		        </div>
		        <!-- opus_design_grid(E) -->
		    </div>
		    <div class="layout_vertical_3" style="width:5%;">
		    	<table style="height:105px; vertical-align: middle;">
					<colgroup>
						<col width="*">
					</colgroup>
					<tbody>
						<tr>
							<td align="center"><button type="button" class="btn_right" ></button></td>
							<!-- <td align="center"><img src="img/btn_add.gif" width="26" height="26" alt="" border="0" align="absmiddle" style="cursor: pointer;"></td> -->
						</tr>
					</tbody>
				</table>
		    </div>
		    <div class="layout_vertical_3" id="mainTable" style="width:57%;">
		        <!-- opus_design_grid(S) -->
		        <div class="opus_design_grid">
		            <script type="text/javascript">ComSheetObject('sheet2');</script>
		        </div>
		        <!-- opus_design_grid(E) -->
		    </div>
		</div>
		<!-- layout_wrap(E) -->
		<div class="opus_design_data">
			<table class="grid_2">
				<colgroup>
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<td><textarea name="note_ctnt" id="note_ctnt" style="width: width:100%; height: 90px; maxlength:2000;resize:none;" class="textarea2" readonly="true"></textarea></td>
					</tr>
				</tbody>
			</table>
			<table class="line_bluedot"><tr><td></td></tr></table>
		</div>
		<div class="layout_flex_fixed" style="width:50%"> 
		<div class="opus_design_inquiry">
			<table>
				<colgroup>
					<col width="60">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th>C/TYPE</th>
						<td><script type="text/javascript">ComComboObject("note_chg_tp_cd", 1, 130, 1, 1, 0, false);</script></td>
					</tr>
				</tbody>
			</table>
		</div>
			</div>
		<!-- opus_design_grid(S) -->
		<div class="layout_flex_fixed" style="width:50%"> 
        <div class="opus_design_grid">
        	<div class="opus_design_btn">
        		<button class="btn_normal" name="btn_copy" id="btn_copy" type="button">Copy</button><!--  
        		--><button class="btn_normal" name="btn_paste" id="btn_paste" type="button">Paste</button><!--  
        		--><button class="btn_normal" name="btn_rowadd" id="btn_rowadd" type="button">Row Add</button><!--  
        		--><button class="btn_normal" name="btn_rowcopy" id="btn_rowcopy" type="button">Row Copy</button><!--  
        		--><button class="btn_normal" name="btn_delete" id="btn_delete" type="button">Delete</button>
        	</div>
            
        </div>
        	</div>
        	<script type="text/javascript">ComSheetObject('sheet3');</script>
        <!-- opus_design_grid(E) -->
	</div>
</div>
</form>
