<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_3002.jsp
*@FileTitle  : TRI Creation &amp; Amendment - Note Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/1
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.triproposal.triproposal.event.EsmPri3002Event"%>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="java.net.URLDecoder"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri3002Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	String effDt = "";
	String expDt = "";
	String noteCtnt = "";
	String noteConvMapgId = "";
	String trfPfxCd = "";
	String trfNo = "";
	String triPropNo = "";
	String amdtSeq = "";
	String isEditable = "";
		
	String[] rtApplTpCd = null;		    //APLICATION
	String[] bkgPrcCgoTpCd = null;    	//CARGO TYPE
	String[] rtOpCd = null;    			//CAL.
	String[] payTermCd = null;    		//PAY TERM
	String[] bkgHngrBarTpCd = null;    	//US SVC MODE
	String[] bkgRatUtCd = null;			//PER TYPE
	String[] currCd = null;				//CURRENCY
	String[] ruleCd = null;				//NOTE CONVERSION RULE CODE 
	String[] chargeCd = null;    		//SCOPE CHARGE CODE LIST
	String[] bkgEsvcTpCd = null;    	//B/I
	
	Logger log = Logger.getLogger("com.clt.apps.TRIProposal.TRIProposal");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmPri3002Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
				
		//PARAM
		effDt = JSPUtil.getNull(request.getParameter("eff_dt"));
		expDt = JSPUtil.getNull(request.getParameter("exp_dt"));
		//noteCtnt = JSPUtil.getNull(URLDecoder.decode(request.getParameter("note_ctnt"), "utf-8"));
		noteCtnt = JSPUtil.getNull(request.getParameter("note_ctnt"));
		noteConvMapgId = JSPUtil.getNull(request.getParameter("note_conv_mapg_id"));
		trfPfxCd = JSPUtil.getNull(request.getParameter("trf_pfx_cd"));
		trfNo = JSPUtil.getNull(request.getParameter("trf_no"));
		triPropNo = JSPUtil.getNull(request.getParameter("tri_prop_no"));
		amdtSeq = JSPUtil.getNull(request.getParameter("amdt_seq"));
		isEditable = JSPUtil.getNull(request.getParameter("is_editable"));
				
		//COMMBO LIST
        rtApplTpCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("RT_APPL_TP_CD"), false);
        bkgPrcCgoTpCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("BKG_PRC_CGO_TP_CD"), false);       
        rtOpCd 			= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("RT_OP_CD"));      
        payTermCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("PAY_TERM_CD"), false);      
        bkgHngrBarTpCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("BKG_HNGR_BAR_TP_CD"), false);       
        bkgRatUtCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("BKG_RAT_UT_CD"), false);      
        currCd 			= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("CURR_CD"), false);       
        ruleCd 			= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("RULE_CD"));       
        chargeCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("CHARGE_CD"));
        bkgEsvcTpCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("BKG_ESVC_TP_CD"), false);  


	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">

	var rtApplTpCdComboValue = " |<%=rtApplTpCd[0]%>";
    var rtApplTpCdComboText = " |<%=rtApplTpCd[1]%>";

    var bkgPrcCgoTpCdComboValue = " |<%=bkgPrcCgoTpCd[0]%>";
    var bkgPrcCgoTpCdComboText = " |<%=bkgPrcCgoTpCd[1]%>";
        
    var rtOpCdComboValue = "<%=rtOpCd[0]%>";   
    var rtOpCdComboText = "<%=rtOpCd[1]%>";

    var payTermCdComboValue = " |<%=payTermCd[0]%>";   
    var payTermCdComboText = " |<%=payTermCd[1]%>";
    
    var bkgHngrBarTpCdComboValue = " |<%=bkgHngrBarTpCd[0]%>";   
    var bkgHngrBarTpCdComboText = " |<%=bkgHngrBarTpCd[1]%>";
    
    var bkgRatUtCdComboValue = " |<%=bkgRatUtCd[0]%>";   
    var bkgRatUtCdComboText = " |<%=bkgRatUtCd[1]%>";
    
    var currCdComboValue = "<%=currCd[0]%>";   
    var currCdComboText = "<%=currCd[1]%>";
        
    var chargeRuleCdComboValue = " |<%=(chargeCd[0].length()>0)? ruleCd[0]+"|"+chargeCd[0]:ruleCd[0]%>";   
    var chargeRuleCdComboText = " |<%=(chargeCd[0].length()>0)? ruleCd[1]+"|"+chargeCd[1]:ruleCd[1]%>";  
    
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
<input type="hidden" name="eff_dt" value="<%=effDt%>" id="eff_dt" />
<input type="hidden" name="exp_dt" value="<%=expDt%>" id="exp_dt" />
<input type="hidden" name="note_conv_mapg_id" value="<%=noteConvMapgId%>" id="note_conv_mapg_id" />
<input type="hidden" name="note_conv_tp_cd" value="R" id="note_conv_tp_cd" />

<input type="hidden" name="trf_pfx_cd" value="<%=trfPfxCd%>" id="trf_pfx_cd" />
<input type="hidden" name="trf_no" value="<%=trfNo%>" id="trf_no" />
<input type="hidden" name="tri_prop_no" value="<%=triPropNo%>" id="tri_prop_no" />
<input type="hidden" name="amdt_seq" value="<%=amdtSeq%>" id="amdt_seq" />
<input type="hidden" name="is_editable" value="<%=isEditable%>" id="is_editable" />

<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	
		<!-- page_title(S) -->
		<h2 class="page_title"><span>TRI Creation & Amendment - Note Creation</span></h2>
		<!-- page_title(E) -->
	
		<!-- opus_design_btn(S) -->
	    <div class="opus_design_btn">
			 <button type="button"  class="btn_accent"  name="btn_copy" id="btn_copy">Copy</button>
			  <button type="button"  class="btn_normal"  name="btn_paste" id="btn_paste">Paste</button> 
			  <button type="button"  class="btn_normal"  name="btn_ok" id="btn_ok">Ok</button>
			  <button type="button"  class="btn_normal"  name="btn_close" id="btn_close">Close</button>
	    </div>
		 <!-- opus_design_btn(E) -->
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_result">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<h3 style="margin-bottom:0" class="title_design">Note</h3>
			<table>
				<colgroup>
					<col width="*" />
			    </colgroup>
			 	<tbody>
					<tr>
						<td><textarea name="note_ctnt" id="note_ctnt" style="resize:none;width:100%; height:70px;word-break:break-all;"><%=noteCtnt%></textarea></td>
					</tr>
				</tbody>
			</table>
		</div>
		
		<table class="line_bluedot"><tr><td></td></tr></table>
	
		<h3 style="margin-bottom:0" class="title_design">Conversion</h3>
		<div class="opus_design_grid">
			<div class="opus_design_btn">
			  <button type="button"  class="btn_normal"  name="btn_rowadd" id="btn_rowadd">Row Add</button> 
			  <button type="button"  class="btn_normal"  name="btn_rowcopy" id="btn_rowcopy">Row Copy</button>
			  <button type="button"  class="btn_normal"  name="btn_delete" id="btn_delete">Row Delete</button>
	    </div>
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
</div>
</form>