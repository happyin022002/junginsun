<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_2084.jsp
*@FileTitle  : M.G.Set Inventory List 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/13
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.event.EesCgm2084Event"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.io.HttpUtil"%>

<%
	EesCgm2084Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.ChassisMgsetAgreementInvoice.ChassisMgsetAgreement");

	String xml = HttpUtil.makeXML(request,response);

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

	//chungpa 20090909 2076 list 추가.
    String sLocation="";
    String sCrntLocCd="";
    String sCrntYdCd="";
    String sAciacDivCd="";
    String sEqTpszCd="";
    String sGroup1=""; 
    String sGroup1Val="";
    String s2Group1="";
    String s2Group1Val="";
    String s2Group2="";
    String s2Group2Val="";
    String s2Group3="";
    String s2Group3Val="";    
    String s2AgmtLstmCd="";
    String s2EqTpszCd="";

    //chungpa 20090910 2077 list 추가
    String sCrntOfcCd="";
    String sVndrSeq="";
    String sAgmtLstmCd="";

    //String sGroup1=""; 
    //String sGroup1Val="";
    //String s2Group1="";
    //String s2Group1Val="";

    String s2AgmtNo="";
    String s2AgmtRefNo="";
    //String s2EqTpszCd="";

    //chungpa 20090915 2080 list 추가
    String s2LocCd="";

    //chungpa 20090915 2079 from-to dys추가 
    String s1InqFmDys="";
    String s1InqToDys="";

    //chungpa 20090916 2076,2077,2078,2079,2078 GTOTAL 추가 
    String s3Gtotal="";

    // chungpa 20091123 2076
    String atch_bare = "";
    String dmg_snd = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EesCgm2084Event)request.getAttribute("Event");
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

		sLocation       = StringUtil.xssFilter(request.getParameter("s_location"));
		sCrntLocCd      = StringUtil.xssFilter(request.getParameter("s_crnt_loc_cd"));
		sCrntYdCd       = StringUtil.xssFilter(request.getParameter("s_crnt_yd_cd"));
		sAciacDivCd     = StringUtil.xssFilter(request.getParameter("s_aciac_div_cd"));
		sEqTpszCd       = StringUtil.xssFilter(request.getParameter("s_eq_tpsz_cd"));
		sGroup1         = StringUtil.xssFilter(request.getParameter("s_group1")); 
		sGroup1Val      = StringUtil.xssFilter(request.getParameter("s_group1_val"));
		s2Group1        = StringUtil.xssFilter(request.getParameter("s2_group1"));
		s2Group1Val     = StringUtil.xssFilter(request.getParameter("s2_group1_val"));
        s2Group2        = StringUtil.xssFilter(request.getParameter("s2_group2"));
        s2Group2Val     = StringUtil.xssFilter(request.getParameter("s2_group2_val"));
        s2Group3        = StringUtil.xssFilter(request.getParameter("s2_group3"));
        s2Group3Val     = StringUtil.xssFilter(request.getParameter("s2_group3_val"));        
		s2AgmtLstmCd    = StringUtil.xssFilter(request.getParameter("s2_agmt_lstm_cd"));
		s2EqTpszCd      = StringUtil.xssFilter(request.getParameter("s2_eq_tpsz_cd"));


		sCrntOfcCd    = StringUtil.xssFilter(request.getParameter("s_crnt_ofc_cd"));
		sVndrSeq      = StringUtil.xssFilter(request.getParameter("s_vndr_seq"));
		sAgmtLstmCd   = StringUtil.xssFilter(request.getParameter("s_agmt_lstm_cd"));
	    //sGroup1     = request.getParameter("s_group1"); 
		//sGroup1Val  = request.getParameter("s_group1_val");
		//s2Group1    = request.getParameter("s2_group1");
		//s2Group1Val = request.getParameter("s2_group1_val");
		s2AgmtNo      = StringUtil.xssFilter(request.getParameter("s2_agmt_no"));
		s2AgmtRefNo   = StringUtil.xssFilter(request.getParameter("s2_agmt_ref_no"));
		//s2EqTpszCd  = request.getParameter("s2_eq_tpsz_cd");

		s1InqFmDys     = StringUtil.xssFilter(request.getParameter("s1_inq_fm_dys"));
		s1InqToDys     = StringUtil.xssFilter(request.getParameter("s1_inq_to_dys"));

		s2LocCd       = StringUtil.xssFilter(request.getParameter("s2_loc_cd"));

		s3Gtotal      = StringUtil.xssFilter(request.getParameter("s3_gtotal"));

        atch_bare       = StringUtil.xssFilter(request.getParameter("atch_bare"));
        dmg_snd         = StringUtil.xssFilter(request.getParameter("dmg_snd"));

	}catch(Exception e) {
		out.println(e.toString());
	}
%>



<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if

		loadPage();
	}
</script>

<body class="popup_bg" onLoad="setupPage();">
<form name="form2">
<input type="hidden" name="sXml" value="<%=xml.replace(" \"","'") %>" id="sXml" />
</form>
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

<input type="hidden" name="s_location" value="<%=sLocation %>" id="s_location" />
<input type="hidden" name="s_crnt_loc_cd" value="<%=sCrntLocCd %>" id="s_crnt_loc_cd" />
<input type="hidden" name="s_crnt_yd_cd" value="<%=sCrntYdCd %>" id="s_crnt_yd_cd" />
<input type="hidden" name="s_aciac_div_cd" value="<%=sAciacDivCd %>" id="s_aciac_div_cd" />
<input type="hidden" name="s_eq_tpsz_cd" value="<%=sEqTpszCd %>" id="s_eq_tpsz_cd" />
<input type="hidden" name="s_group1" value="<%=sGroup1 %>" id="s_group1" />
<input type="hidden" name="s_group1_val" value="<%=sGroup1Val %>" id="s_group1_val" />
<input type="hidden" name="s2_group1" value="<%=s2Group1 %>" id="s2_group1" />
<input type="hidden" name="s2_group1_val" value="<%=s2Group1Val %>" id="s2_group1_val" />
<input type="hidden" name="s2_group2" value="<%=s2Group2 %>" id="s2_group2" />
<input type="hidden" name="s2_group2_val" value="<%=s2Group2Val %>" id="s2_group2_val" />
<input type="hidden" name="s2_group3" value="<%=s2Group3 %>" id="s2_group3" />
<input type="hidden" name="s2_group3_val" value="<%=s2Group3Val %>" id="s2_group3_val" />
<input type="hidden" name="s2_agmt_lstm_cd" value="<%=s2AgmtLstmCd %>" id="s2_agmt_lstm_cd" />
<input type="hidden" name="s2_eq_tpsz_cd" value="<%=s2EqTpszCd %>" id="s2_eq_tpsz_cd" />


<input type="hidden" name="s_crnt_ofc_cd" value="<%=sCrntOfcCd %>" id="s_crnt_ofc_cd" />
<input type="hidden" name="s_vndr_seq" value="<%=sVndrSeq %>" id="s_vndr_seq" />
<input type="hidden" name="s_agmt_lstm_cd" value="<%=sAgmtLstmCd %>" id="s_agmt_lstm_cd" />
<input type="hidden" name="s2_agmt_no" value="<%=s2AgmtNo %>" id="s2_agmt_no" />
<input type="hidden" name="s2_agmt_ref_no" value="<%=s2AgmtRefNo %>" id="s2_agmt_ref_no" />

<input type="hidden" name="s1_inq_fm_dys" value="<%=s1InqFmDys %>" id="s1_inq_fm_dys" />
<input type="hidden" name="s1_inq_to_dys" value="<%=s1InqToDys %>" id="s1_inq_to_dys" />

<input type="hidden" name="s2_loc_cd" value="<%=s2LocCd %>" id="s2_loc_cd" />

<input type="hidden" name="s3_gtotal" value="<%=s3Gtotal %>" id="s3_gtotal" />

<input type="hidden" name="atch_bare" value="<%=atch_bare %>" id="atch_bare" />
<input type="hidden" name="dmg_snd" value="<%=dmg_snd %>" id="dmg_snd" />

<div class="layer_popup_contents">
	<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><span>M.G.Set Inventory List</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_downexcel" 	id="btn_downexcel">Down Excel</button><!--
			--><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button><!--
		--></div>
		<!-- opus_design_btn(E) -->
		<!-- page_location(S) -->
		<div class="location">
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->
	</div>
	<!-- page_title_area(E) -->
	</div>
	
	<!-- opus_design_grid(S) -->	
	<div class="wrap_result">
		<div class="opus_design_grid clear" id="mainTable" >
				<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>