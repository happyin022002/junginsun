<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_3005.jsp
*@FileTitle  : Tariff Fomula Rule Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/03
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.triproposal.trinoteconversionproposal.event.EsmPri3005Event"%>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri3005Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";

	
	String[] srchTrfCd = null;		    //TARIFF CODE
	String[] ruleApplChgTpCd = null;	//TYPE
	String[] rtApplTpCd = null;		    //APLICATION
	String[] bkgPrcCgoTpCd = null;    	//CARGO TYPE
	String[] rtOpCd = null;    			//CAL.
	String[] payTermCd = null;    		//PAY TERM
	String[] bkgUsaSvcModCd = null;    	//US SVC MODE
	String[] bkgRatUtCd = null;			//PER TYPE
	String[] currCd = null;				//CURRENCY
	String[] convRatUtCd = null;		//PER TYPE(in S/C)
	String[] convPrcCgoTpCd = null;		//CARGO TYPE(in S/C)
	String[] bkgRcvTermCd = null;		//RECEIVING TERM
	String[] bkgDeTermCd = null;		//DELIVERY TERM
	//String[] ruleCd = null;			//NOTE CONVERSION RULE CODE 
	//String[] chargeCd = null;    		//SCOPE CHARGE CODE LIST
	
	Logger log = Logger.getLogger("com.clt.apps.TRIProposal.TRINoteConversionProposal");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri3005Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
				
		//COMMBO LIST		
		srchTrfCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("SRCH_TRF_CD"));
		ruleApplChgTpCd = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("RULE_APPL_CHG_TP_CD"), false);
        rtApplTpCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("RT_APPL_TP_CD"), false);
        bkgPrcCgoTpCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("BKG_PRC_CGO_TP_CD"), false);       
        rtOpCd 			= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("RT_OP_CD"));      
        payTermCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("PAY_TERM_CD"), false);      
        bkgUsaSvcModCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("BKG_USA_SVC_MOD_CD"), false);       
        bkgRatUtCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("BKG_RAT_UT_CD"), false);      
        currCd 			= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("CURR_CD"), false);
        convRatUtCd		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("CONV_RAT_UT_CD"), false);      
        convPrcCgoTpCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("CONV_PRC_CGO_TP_CD"), false);  
        bkgRcvTermCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("BKG_RCV_TERM_CD"), false);  
        bkgDeTermCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("BKG_DE_TERM_CD"), false);  
        //ruleCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("RULE_CD"));       
        //chargeCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("CHARGE_CD"));

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">

	var srchTrfCdComboValue = "<%=srchTrfCd[0]%>";
    var srchTrfCdComboText = "<%=srchTrfCd[1]%>";
    
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
    
    var bkgRatUtCdComboValue = " |<%=bkgRatUtCd[0]%>";   
    var bkgRatUtCdComboText = " |<%=bkgRatUtCd[1]%>";
    
    var currCdComboValue = "<%=currCd[0]%>";   
    var currCdComboText = "<%=currCd[1]%>";
       
    var convRatUtCdComboValue = " |<%=convRatUtCd[0]%>";   
    var convRatUtCdComboText = " |<%=convRatUtCd[1]%>";
 
    var convPrcCgoTpCdComboValue = " |<%=convPrcCgoTpCd[0]%>";
    var convPrcCgoTpCdComboText = " |<%=convPrcCgoTpCd[1]%>";

    var bkgRcvTermCdComboValue = " |<%=bkgRcvTermCd[0]%>";
    var bkgRcvTermCdComboText = " |<%=bkgRcvTermCd[1]%>";
    
    var bkgDeTermCdComboValue = " |<%=bkgDeTermCd[0]%>";
    var bkgDeTermCdComboText = " |<%=bkgDeTermCd[1]%>";
               
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" 				id="f_cmd" />
<input type="hidden" name="pagerows" 			id="pagerows" />
<input type="hidden" name="trf_pfx_cd" 			id="trf_pfx_cd" />
<input type="hidden" name="trf_no" 				id="trf_no" />
<input type="hidden" name="tri_prop_no" 		id="tri_prop_no" />
<input type="hidden" name="amdt_seq" 			id="amdt_seq" />
<input type="hidden" name="note_conv_mapg_id" 	id="note_conv_mapg_id" />
<input type="hidden" name="cfm_flg" 			id="cfm_flg" />
<input type="hidden" name="cd" 					id="cd" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" 			id="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_new"  			id="btn_new">New</button><!--
		--><button type="button" class="btn_normal" name="btn_save" 			id="btn_save">Save</button><!--
		--><button type="button" class="btn_normal" name="btn_confirm" 			id="btn_confirm">Confirm</button><!--
		--><button type="button" class="btn_normal" name="btn_confirmcancel" 	id="btn_confirmcancel">Confirm Cancel</button><!--
		--><button type="button" class="btn_normal" name="btn_delete" 			id="btn_delete">Delete</button><!--
		--><button type="button" class="btn_normal" name="btn_copy" 			id="btn_copy">Copy</button>	
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry wFit">
	<table>
		<tbody>
			<colgroup>
				<col width="70">
				<col width="60">
				<col width="320">
				<col width="60">
				<col width="250">
				<col width="70">
				<col width="80">
				<col width="*">
		    </colgroup>
			<tr class="h23">
				<th>Tariff Code</th>
				<td><script type="text/javascript">ComComboObject("srch_trf_cd", 2, 90, 0, 1, 0, false);</script></td>
				<td><input type="text" name="srch_trf_nm" id="srch_trf_nm" style="width:293px;" class="input2" value=""></td>
				<th>Duration</th>
				<td><script type="text/javascript">ComComboObject("note_seq", 3, 90, 0, 1, 0, true);</script><!-- 
				 --><input name="eff_dt" 						id="eff_dt" type="hidden" value="" class="input1" caption="Effective Date" required="true"><!-- 
				 --><input name="eff_dt_hidden" 				id="eff_dt_hidden" type="hidden" value="" class="input1"><!--  
				 --><input type="text" name="exp_dt" 			id="exp_dt" style="width:80px;text-align:center;" class="" value="" caption="Expire Date" maxlength="10" dataformat="ymd" ><!--  
				 --><input type="hidden" name="exp_dt_hidden" 	id="exp_dt_hidden" style="width:80px;text-align:center;">
				<!-- <img src="img/btns_calendar.gif" name="btns_calendar" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td> -->
				<button type="button" class="calendar" name="btns_calendar" id="btns_calendar"></button>
				<th>Confirmation</th>
				<td><input name="cfm_flg_nm" 					id="cfm_flg_nm" type="text" style="width:70px;text-align:center;" class="input2" value="" readonly="true" caption="Confirmation"></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</div>
<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
<!-- opus_design_grid(S) -->	
<div class="opus_design_grid">
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_rowadd" 	id="btn_rowadd">Row Add</button>
		<button type="button" class="btn_accent" name="btn_rowcopy" 	id="btn_rowcopy">Row Copy</button>
		<button type="button" class="btn_accent" name="btn_rowdelete" 	id="btn_rowdelete">Delete</button>	
	</div>
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
<!-- opus_design_grid(E) -->
</div>
</form>