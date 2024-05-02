<%  
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESM_PRI_2024.js
*@FileTitle : RFA Proposal Creation - Rate (Route Note)
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
<%@ page import="com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.event.EsmPri2024Event"%>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
    EsmPri2024Event event = null; //PDTO(Data Transfer Object including Parameters)
    Exception serverException = null; //error from server
    String strErrMsg = ""; //error message
    int rowCount = 0; //count of DB resultSET list

    String successFlag = "";
    String codeList = "";
    String pageRows = "100";

    String strUsr_id = "";
    String strUsr_nm = "";

	String[] rtApplTpCd = null;		    //APLICATION
	String[] bkgPrcCgoTpCd = null;    	//CARGO TYPE
	String[] rtOpCd = null;    			//CAL.
	String[] payTermCd = null;    		//PAY TERM
	String[] bkgHngrBarTpCd = null;    	//BAR TYPE
	String[] bkgRatUtCd = null;			//PER TYPE
	String[] currCd = null;				//CURRENCY
	String[] ruleCd = null;				//NOTE CONVERSION RULE CODE 
	String[] chargeCd = null;    		//SCOPE CHARGE CODE LIST
	String[] bkgCnlTzCd = null;    		//CANAL
	String[] bkgEsvcTpCd = null;    	//B/I

	String beforeExpDt = null;    		//MAIN-BEFORE_EXP_DT
	
    Logger log = Logger.getLogger("com.clt.apps.RFAProposal.RFARateProposal");

    try {
        SignOnUserAccount account = (SignOnUserAccount) session
                .getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();

        event = (EsmPri2024Event) request.getAttribute("Event");
        serverException = (Exception) request
                .getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

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
        bkgCnlTzCd 	    = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("BKG_CNL_TZ_CD"), false);  
        bkgEsvcTpCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("BKG_ESVC_TP_CD"), false); 

        beforeExpDt		= (String)eventResponse.getCustomData("BEFORE_EXP_DT");
    } catch (Exception e) {
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
    
    var bkgCnlTzCdComboValue = " |<%=bkgCnlTzCd[0]%>";   
    var bkgCnlTzCdComboText = " |<%=bkgCnlTzCd[1]%>";
    
    var bkgEsvcTpCdComboValue = " |<%=bkgEsvcTpCd[0]%>";   
    var bkgEsvcTpCdComboText = " |<%=bkgEsvcTpCd[1]%>";
   
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
<!-- developer performance -->
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

<input type="hidden" name="note_conv_mapg_id" value="<%=StringUtil.xssFilter(request.getParameter("note_conv_mapg_id")) %>" id="note_conv_mapg_id" />
<input type="hidden" name="cd" id="cd" />

<input type="hidden" name="before_exp_dt" value="<%=beforeExpDt%>" id="before_exp_dt" />

<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>RFA Proposal Creation - Rate (Route Note)</span></h2>
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
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<div class="opus_design_btn">
				<button class="btn_normal" name="btn_add" id="btn_add" type="button" suppressWait="Y">Row Add</button><!--  
				--><button class="btn_normal" name="btn_delete" id="btn_delete" type="button" suppressWait="Y">Delete</button><!--  
				--><button class="btn_normal" name="btn_amend" id="btn_amend" type="button" suppressWait="Y">Amend</button><!--  
				--><button class="btn_normal" name="btn_amendcancel" id="btn_amendcancel" type="button" suppressWait="Y">Amend Cancel</button><!--  
				--><button class="btn_normal" name="btn_accept" id="btn_accept" type="button">Accept</button><!--  
				--><button class="btn_normal" name="btn_acceptcancel" id="btn_acceptcancel" type="button">Accept Cancel</button>
			</div>
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<div class="opus_design_data">
			<table class="grid2">
				<colgroup>
					<col width="100">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th align="center"><strong>Route Note</strong></th>
						<td><textarea name="ta_note_ctnt" id="ta_note_ctnt" style="width:100%;height:80px;resize:none;" ></textarea></td>
					</tr>
				</tbody>
			</table>
			<table class="line_bluedot"><tr><td></td></tr></table>
		</div>
		<div class="opus_design_grid">
			<h3 class="title_design">Conversion</h3>
			<div class="opus_design_btn"> 
				<button class="btn_accent" name="btn_autoword" id="btn_autoword" type="button" >Auto Wording</button><!-- 
		        --><button class="btn_normal" name="btn_copy" id="btn_copy" type="button">Copy</button><!--  
				--><button class="btn_normal" name="btn_paste" id="btn_paste" type="button">Paste</button><!-- 
				--><input class="floatL mar_rgt_none mar_left_4" type="text" style="width: 40px;text-align:right;" name="txt_rowcnt" id="txt_rowcnt" dataformat="int" class="input" maxlength=2><!--  
				--><button class="btn_normal" name="btn_rowadd3" id="btn_rowadd3" type="button" suppressWait="Y">Row Add</button><!--  
				--><button class="btn_normal" name="btn_rowcopy" id="btn_rowcopy" type="button" suppressWait="Y">Row Copy</button><!--  
				--><button class="btn_normal" name="btn_delete3" id="btn_delete3" type="button">Delete</button>
			</div>
			<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
</div>
</form>