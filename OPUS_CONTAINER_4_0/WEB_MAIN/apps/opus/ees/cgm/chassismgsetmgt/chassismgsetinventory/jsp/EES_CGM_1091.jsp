<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_CGM_1091.jsp
*@FileTitle  : Chassis Inventory List
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/07
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.event.EesCgm1091Event"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EesCgm1091Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.ChassisMgsetAgreementInvoice.ChassisMgsetAgreement");
	
	String programId = "";
	String eqKndCd = "";
	String stsEvntDtFr = "";
	String stsEvntDtTo = "";
	String stsEvntOfcCd = "";
	String oldAgmtOfcCtyCd = "";
	String oldAgmtSeq = "";
	String newAgmtOfcCtyCd = "";
	String newAgmtSeq = "";
	String eqTpszCd = "";
	String s2EqTpszCd = "";
	
	String crntLocCd = "";
	String crntYdCd = "";
	String aciacDivCd = "";
	String chssPoolCd = "";
	String includeNp = "";
	String stayingDays = "";
	String group1 = "";
	String group2 = "";
	String group3 = "";
	String groupValue1 = "";
	String groupValue2 = "";
	String groupValue3 = "";
	String agmtLstmCd = "";
	String sAgmtLstmCd = "";
	String vndrSeq = "";
	String chssMvmtStsCd = "";
	
	//choi 
	String eqAsetStsCd  = "";
	String location     = "";
	String sccCd        = "";
	String stsEvntLocCd = "";
	String kind         = "";
	
	//chungpa 1092
	String inqFmDys	= "";
	String inqToDys	= "";
	String includeStatusLst = "";
	String includeOutGated = "";

	//chungpa 1098
	String agmt_no = "";
	
	//chungpa shassis common
	String sGroup1 = "";
    String sGroup1Val = "";
    String s2Group1 = "";
    String s2Group1Val = "";
    String s2Group2="";
    String s2Group2Val="";
    String s2Group3="";
    String s2Group3Val="";  
    String s3Gtotal = "";
    
    String old_agmt_lstm_cd = "";
    String new_agmt_lstm_cd = "";
    
    // chungpa 20091123 1092
    String atch_bare = "";
    String dmg_snd = "";
 
    
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EesCgm1091Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		// 파라메터 변수 설정
		programId 		= StringUtil.xssFilter(request.getParameter("program_id"));
		eqKndCd 		= StringUtil.xssFilter(request.getParameter("eq_knd_cd"));
		stsEvntDtFr 	= StringUtil.xssFilter(request.getParameter("sts_evnt_dt_fr"));
		stsEvntDtTo 	= StringUtil.xssFilter(request.getParameter("sts_evnt_dt_to"));
		stsEvntOfcCd 	= StringUtil.xssFilter(request.getParameter("sts_evnt_ofc_cd"));
		oldAgmtOfcCtyCd = StringUtil.xssFilter(request.getParameter("old_agmt_ofc_cty_cd"));
		oldAgmtSeq 		= StringUtil.xssFilter(request.getParameter("old_agmt_seq"));
		newAgmtOfcCtyCd = StringUtil.xssFilter(request.getParameter("new_agmt_ofc_cty_cd"));
		newAgmtSeq 		= StringUtil.xssFilter(request.getParameter("new_agmt_seq"));
		eqTpszCd 		= StringUtil.xssFilter(request.getParameter("eq_tpsz_cd"));
		
		crntLocCd 		= StringUtil.xssFilter(request.getParameter("crnt_loc_cd"));
		crntYdCd 		= StringUtil.xssFilter(request.getParameter("crnt_yd_cd"));
		aciacDivCd 		= StringUtil.xssFilter(request.getParameter("aciac_div_cd"));
		chssPoolCd 		= StringUtil.xssFilter(request.getParameter("chss_pool_cd"));
		includeNp 		= StringUtil.xssFilter(request.getParameter("include_np"));
		stayingDays 	= StringUtil.xssFilter(request.getParameter("staying_days"));
		group1 			= StringUtil.xssFilter(request.getParameter("group1"));
		group2 			= StringUtil.xssFilter(request.getParameter("group2"));
		group3 			= StringUtil.xssFilter(request.getParameter("group3"));
		groupValue1 	= StringUtil.xssFilter(request.getParameter("group_value1"));
		groupValue2 	= StringUtil.xssFilter(request.getParameter("group_value2"));
		groupValue3 	= StringUtil.xssFilter(request.getParameter("group_value3"));
		agmtLstmCd 		= StringUtil.xssFilter(request.getParameter("agmt_lstm_cd"));
		sAgmtLstmCd     = StringUtil.xssFilter(request.getParameter("s_agmt_lstm_cd"));
		vndrSeq 		= StringUtil.xssFilter(request.getParameter("vndr_seq"));
		chssMvmtStsCd 	= StringUtil.xssFilter(request.getParameter("chss_mvmt_sts_cd"));
		
		//choi
		eqAsetStsCd     = StringUtil.xssFilter(request.getParameter("eq_aset_sts_cd"));
		location        = StringUtil.xssFilter(request.getParameter("location"));
		sccCd           = StringUtil.xssFilter(request.getParameter("scc_cd"));
		stsEvntLocCd    = StringUtil.xssFilter(request.getParameter("sts_evnt_loc_cd"));
		kind            = StringUtil.xssFilter(request.getParameter("kind"));
		
		//chungpa 1092
		inqFmDys		= StringUtil.xssFilter(request.getParameter("inq_fm_dys"));
		inqToDys		= StringUtil.xssFilter(request.getParameter("inq_to_dys"));
		includeStatusLst= StringUtil.xssFilter(request.getParameter("include_status_lst"));
		includeOutGated = StringUtil.xssFilter(request.getParameter("include_out_gated"));
		
		//chungpa 1098
		agmt_no			= StringUtil.xssFilter(request.getParameter("agmt_no"));
		
		//chungpa shassis common
		s2EqTpszCd      = StringUtil.xssFilter(request.getParameter("s2_eq_tpsz_cd"));
		
		sGroup1         = StringUtil.xssFilter(request.getParameter("s_group1"));
        sGroup1Val      = StringUtil.xssFilter(request.getParameter("s_group1_val"));
        
	    s2Group1        = StringUtil.xssFilter(request.getParameter("s2_group1"));
	    s2Group1Val     = StringUtil.xssFilter(request.getParameter("s2_group1_val"));
        s2Group2        = StringUtil.xssFilter(request.getParameter("s2_group2"));
        s2Group2Val     = StringUtil.xssFilter(request.getParameter("s2_group2_val"));
        s2Group3        = StringUtil.xssFilter(request.getParameter("s2_group3"));
        s2Group3Val     = StringUtil.xssFilter(request.getParameter("s2_group3_val")); 
	    s3Gtotal        = StringUtil.xssFilter(request.getParameter("s3_gtotal"));
	    
	    old_agmt_lstm_cd = StringUtil.xssFilter(request.getParameter("old_agmt_lstm_cd")); 
	    new_agmt_lstm_cd = StringUtil.xssFilter(request.getParameter("new_agmt_lstm_cd"));
	    
	    atch_bare       = StringUtil.xssFilter(request.getParameter("atch_bare"));
	    dmg_snd         = StringUtil.xssFilter(request.getParameter("dmg_snd"));
	    
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script language="javascript">
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
<!-- developer working -->
<input type="hidden" name="program_id" value="<%=programId %>" id="program_id" />
<input type="hidden" name="eq_knd_cd" value="<%=eqKndCd %>" id="eq_knd_cd" />
<input type="hidden" name="sts_evnt_dt_fr" value="<%=stsEvntDtFr %>" id="sts_evnt_dt_fr" />
<input type="hidden" name="sts_evnt_dt_to" value="<%=stsEvntDtTo %>" id="sts_evnt_dt_to" />
<input type="hidden" name="sts_evnt_ofc_cd" value="<%=stsEvntOfcCd %>" id="sts_evnt_ofc_cd" />
<input type="hidden" name="old_agmt_ofc_cty_cd" value="<%=oldAgmtOfcCtyCd %>" id="old_agmt_ofc_cty_cd" />
<input type="hidden" name="old_agmt_seq" value="<%=oldAgmtSeq %>" id="old_agmt_seq" />
<input type="hidden" name="new_agmt_ofc_cty_cd" value="<%=newAgmtOfcCtyCd %>" id="new_agmt_ofc_cty_cd" />
<input type="hidden" name="new_agmt_seq" value="<%=newAgmtSeq %>" id="new_agmt_seq" />
<input type="hidden" name="eq_tpsz_cd" value="<%=eqTpszCd %>" id="eq_tpsz_cd" />
<input type="hidden" name="crnt_loc_cd" value="<%=crntLocCd %>" id="crnt_loc_cd" />
<input type="hidden" name="crnt_yd_cd" value="<%=crntYdCd %>" id="crnt_yd_cd" />
<input type="hidden" name="aciac_div_cd" value="<%=aciacDivCd %>" id="aciac_div_cd" />
<input type="hidden" name="chss_pool_cd" value="<%=chssPoolCd %>" id="chss_pool_cd" />
<input type="hidden" name="include_np" value="<%=includeNp %>" id="include_np" />
<input type="hidden" name="staying_days" value="<%=stayingDays %>" id="staying_days" />
<input type="hidden" name="group1" value="<%=group1 %>" id="group1" />
<input type="hidden" name="group2" value="<%=group2 %>" id="group2" />
<input type="hidden" name="group3" value="<%=group3 %>" id="group3" />
<input type="hidden" name="group_value1" value="<%=groupValue1 %>" id="group_value1" />
<input type="hidden" name="group_value2" value="<%=groupValue2 %>" id="group_value2" />
<input type="hidden" name="group_value3" value="<%=groupValue3 %>" id="group_value3" />
<input type="hidden" name="agmt_lstm_cd" value="<%=agmtLstmCd %>" id="agmt_lstm_cd" />
<input type="hidden" name="s_agmt_lstm_cd" value="<%=sAgmtLstmCd %>" id="s_agmt_lstm_cd" />
<input type="hidden" name="vndr_seq" value="<%=vndrSeq %>" id="vndr_seq" />
<input type="hidden" name="chss_mvmt_sts_cd" value="<%=chssMvmtStsCd %>" id="chss_mvmt_sts_cd" />
<input type="hidden" name="eq_aset_sts_cd" value="<%=eqAsetStsCd %>" id="eq_aset_sts_cd" />
<input type="hidden" name="location" value="<%=location %>" id="location" />
<input type="hidden" name="scc_cd" value="<%=sccCd %>" id="scc_cd" />
<input type="hidden" name="sts_evnt_loc_cd" value="<%=stsEvntLocCd %>" id="sts_evnt_loc_cd" />
<input type="hidden" name="kind" value="<%=kind %>" id="kind" />
<input type="hidden" name="inq_fm_dys" value="<%=inqFmDys %>" id="inq_fm_dys" />
<input type="hidden" name="inq_to_dys" value="<%=inqToDys %>" id="inq_to_dys" />
<input type="hidden" name="include_status_lst" value="<%=includeStatusLst %>" id="include_status_lst" />
<input type="hidden" name="include_out_gated" value="<%=includeOutGated %>" id="include_out_gated" />
<input type="hidden" name="agmt_no" value="<%=agmt_no%>" id="agmt_no" />
<input type="hidden" name="s_group1" value="<%=sGroup1 %>" id="s_group1" />
<input type="hidden" name="s_group1_val" value="<%=sGroup1Val %>" id="s_group1_val" />
<input type="hidden" name="s2_group1" value="<%=s2Group1 %>" id="s2_group1" />
<input type="hidden" name="s2_group1_val" value="<%=s2Group1Val %>" id="s2_group1_val" />
<input type="hidden" name="s2_group2" value="<%=s2Group2 %>" id="s2_group2" />
<input type="hidden" name="s2_group2_val" value="<%=s2Group2Val %>" id="s2_group2_val" />
<input type="hidden" name="s2_group3" value="<%=s2Group3 %>" id="s2_group3" />
<input type="hidden" name="s2_group3_val" value="<%=s2Group3Val %>" id="s2_group3_val" />
<input type="hidden" name="s3_gtotal" value="<%=s3Gtotal %>" id="s3_gtotal" />
<input type="hidden" name="s2_eq_tpsz_cd" value="<%=s2EqTpszCd %>" id="s2_eq_tpsz_cd" />
<input type="hidden" name="old_agmt_lstm_cd" value="<%=old_agmt_lstm_cd %>" id="old_agmt_lstm_cd" />
<input type="hidden" name="new_agmt_lstm_cd" value="<%=new_agmt_lstm_cd %>" id="new_agmt_lstm_cd" />
<input type="hidden" name="atch_bare" value="<%=atch_bare %>" id="atch_bare" />
<input type="hidden" name="dmg_snd" value="<%=dmg_snd %>" id="dmg_snd" />
<div class="layer_popup_contents">
	<div class="layer_popup_title">
		<!-- page_title_area(S) -->
		<div class="page_title_area clear">
		   <!-- page_title(S) -->
			<h2 class="page_title"><span>Chassis Inventory List</span></h2>
			<!-- page_title(E) -->
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_downexcel" 	id="btn_downexcel">Down Excel</button><!--
				--><button type="button" class="btn_normal" name="btn_close"  		id="btn_close">Close</button>	
			</div>
			<!-- opus_design_btn(E) -->
			<!-- page_location(S) -->
			<!-- page_location(E) -->
		</div>
		<!-- page_title_area(E) -->
	</div>
	<!-- opus_design_grid(S) -->
	<div class="wrap_result">
		<div class="opus_design_grid clear" >
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>