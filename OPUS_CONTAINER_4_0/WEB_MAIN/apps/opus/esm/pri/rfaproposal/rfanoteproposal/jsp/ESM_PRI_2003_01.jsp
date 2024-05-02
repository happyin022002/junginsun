<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2003_01.jsp
*@FileTitle  : Proposal & Amendment Creation - Special Note 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/
=========================================================
*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.rfaproposal.rfanoteproposal.event.EsmPri200301Event"%>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri200301Event  event = null;			//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String[] srcInfoCd = null;		    //SOURCE
	String[] prcProgStsCd = null;		//STATUS
	String[] rtApplTpCd = null;		    //APLICATION
	String[] bkgPrcCgoTpCd = null;    	//CARGO TYPE
	String[] rtOpCd = null;    			//CAL.
	String[] payTermCd = null;    		//PAY TERM
	String[] bkgHngrBarTpCd = null;    	//US SVC MODE
	String[] bkgRatUtCd = null;			//PER TYPE
	String[] currCd = null;				//CURRENCY
	String[] bkgCnlTzCd = null;    		//CANAL
	String[] bkgEsvcTpCd = null;    	//B/I
	
	Logger log = Logger.getLogger("com.clt.apps.SCProposal.SCNoteProposal");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmPri200301Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		//COMMBO LIST
		srcInfoCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("SRC_INFO_CD"), false);
		prcProgStsCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("PRC_PROG_STS_CD"), false);
        rtApplTpCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("RT_APPL_TP_CD"), false);
        bkgPrcCgoTpCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("BKG_PRC_CGO_TP_CD"), false);       
        rtOpCd 			= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("RT_OP_CD"));      
        payTermCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("PAY_TERM_CD"), false);      
        bkgHngrBarTpCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("BKG_HNGR_BAR_TP_CD"), false);       
        bkgRatUtCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("BKG_RAT_UT_CD"), false);      
        currCd 			= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("CURR_CD"), false);   
        bkgCnlTzCd 	    = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("BKG_CNL_TZ_CD"), false);
        bkgEsvcTpCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("BKG_ESVC_TP_CD"), false);  
        //ruleCd 			= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("RULE_CD"));       
        //chargeCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("CHARGE_CD"));
	} catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	var srcInfoCdComboValue = "<%=srcInfoCd[0]%>";
    var srcInfoCdComboText = "<%=srcInfoCd[1]%>";
    var prcProgStsCdComboValue = "<%=prcProgStsCd[0]%>";
    var prcProgStsCdComboText = "<%=prcProgStsCd[1]%>";
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
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />
	<!-- developer job	-->
<input id="prop_no" name="prop_no" type="hidden" />
<input id="amdt_seq" name="amdt_seq" type="hidden" />
<input id="svc_scp_cd" name="svc_scp_cd" type="hidden" />
<input id="pre_amdt_seq" name="pre_amdt_seq" type="hidden" />
<input id="prop_sts_cd" name="prop_sts_cd" type="hidden" />
<input id="eff_dt" name="eff_dt" type="hidden" />
<input id="exp_dt" name="exp_dt" type="hidden" />
<input id="pre_exp_dt" name="pre_exp_dt" type="hidden" />
<input id="cd" name="cd" type="hidden" />
<input id="req_usr_flg" name="req_usr_flg" type="hidden" />
<input id="apro_usr_flg" name="apro_usr_flg" type="hidden" />
<input id="dur_dup_flg" name="dur_dup_flg" type="hidden" />
<input id="note_seq" name="note_seq" type="hidden" />
<input id="note_tp_cd" name="note_tp_cd" value="P" type="hidden" />
<input id="master_del_chk" name="master_del_chk" type="hidden" />
<input id="amend_func" name="amend_func" type="hidden" />
<input id="note_ctnt_seq" name="note_ctnt_seq" type="hidden" />
<input id="note_conv_mapg_id" name="note_conv_mapg_id" type="hidden" />

<div class="opus_design_inquiry">
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_acceptall" id="btn_acceptall">Accept All</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_cancelall" id="btn_cancelall">Accept Cancel</button>
	</div>
	<!-- opus_design_btn(E) -->
</div>

<!-- opus_design_grid(S) -->
<div class="opus_design_grid">
	<div class="opus_design_btn">
		<button type="button" class="btn_normal" name="btn_rowadd1" id="btn_rowadd1">Row Add</button><!-- 
 		--><button type="button" class="btn_normal" name="btn_delete1" id="btn_delete1">Delete</button><!-- 
		-->
	</div>
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
<!-- opus_design_grid(E) -->
	
<!-- opus_design_grid(S) -->
<div class="opus_design_grid">
	<div class="opus_design_btn">
		<button type="button" class="btn_normal" name="btn_rowadd2" id="btn_rowadd2">Row Add</button><!-- 
 		--><button type="button" class="btn_normal" name="btn_delete2" id="btn_delete2">Delete</button><!-- 
 		--><button type="button" class="btn_normal" name="btn_amend" id="btn_amend">Amend</button><!-- 
 		--><button type="button" class="btn_normal" name="btn_amendcancel" id="btn_amendcancel">Amend Cancel</button><!-- 
 		--><button type="button" class="btn_normal" name="btn_accept" id="btn_accept">Accept</button><!-- 
 		--><button type="button" class="btn_normal" name="btn_acceptcancel" id="btn_acceptcancel">Accept Cancel</button><!-- 
		-->
	</div>
	<script type="text/javascript">ComSheetObject('sheet2');</script>
 </div>
<!-- opus_design_grid(E) -->
	
<!-- opus_design_grid(S) -->
<div class="opus_design_grid">
	<h3 class="title_design">Conversion</h3>
	<div class="opus_design_btn"> 
	    <button type="button" class="btn_accent" name="btn_autoword" id="btn_autoword">Auto Wording</button><!-- 
		--><button type="button" class="btn_normal" name="btn_copy" id="btn_copy">Copy</button><!-- 
		--><button type="button" class="btn_normal" name="btn_paste" id="btn_paste">Paste</button><!-- 
		--><input class="floatL mar_rgt_none mar_left_4" type="text" style="width: 40px;text-align:right;" name="txt_rowcnt" id="txt_rowcnt" dataformat="int" class="input" maxlength=2><!-- 
		--><button type="button" class="btn_normal" name="btn_rowadd3" id="btn_rowadd3">Row Add</button><!-- 
		--><button type="button" class="btn_normal" name="btn_rowcopy" id="btn_rowcopy">Row Copy</button><!-- 
		--><button type="button" class="btn_normal" name="btn_delete3" id="btn_delete3">Delete</button><!-- 
		-->
	</div>
	<script type="text/javascript">ComSheetObject('sheet3');</script>
</div>
<!-- opus_design_grid(E) -->
	
</form>