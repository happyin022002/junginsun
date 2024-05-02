<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0102.jsp
*@FileTitle : Note Conversion History - Special Note Conversion Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.07.03 최성민
* 1.0 Creation
=========================================================
* History
* 2012.01.13 서미진 [CHM-201215426] Special Note , Rate 의 Commodity 별, Route 별 Note conversion 항목에 By Charge 컬럼 추가
* 2014.08.08 송호진 [CHM-201431411] Split 01-S/C Note conversion상에 컬럼 추가 - Rate indicator 앞 Pattern type 컬럼 추가 및 autorating 로직 추가
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.scproposal.scnoteconversionproposal.event.EsmPri0102Event"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri0102Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

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
    String reqUsrFlg        = "";

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
	String[] rtPattTpCd = null;			//RATE PATTERN TYPE CODE
	
	Logger log = Logger.getLogger("com.hanjin.apps.SCProposal.SCNoteConversionProposal");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri0102Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
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

    	rtPattTpCd 			= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("RT_PATT_TP_CD"), false); 

        prcPropCreTpCd		= (String)eventResponse.getCustomData("PRC_PROP_CRE_TP_CD");
        convCfmFlg			= (String)eventResponse.getCustomData("CONV_CFM_FLG");
        lgcyIfFlg			= (String)eventResponse.getCustomData("LGCY_IF_FLG");
        ofcAuthYn			= (String)eventResponse.getCustomData("OFC_AUTH_YN");
        reqUsrFlg           = (String)eventResponse.getCustomData("REQ_USR_FLG");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Note Conversion History - Special Note Conversion Creation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
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

    var chargeCdComboValue = " |<%=chargeCd[0]%>";  
    var chargeCdComboText = " |<%=chargeCd[1]%>";  
                
    var rtPattTpCdComboValue = " |<%=rtPattTpCd[0]%>";  
    var rtPattTpCdComboText = " |<%=rtPattTpCd[1]%>";  
    
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="cd">
<input type="hidden" name="svc_scp_cd" value="<%=svcScpCd%>">
<input type="hidden" name="prop_no" value="<%=propNo%>">
<input type="hidden" name="amdt_seq" value="<%=amdtSeq%>">
<input type="hidden" name="eff_dt" value="<%=effDt%>">
<input type="hidden" name="exp_dt" value="<%=expDt%>">
<input type="hidden" name="note_seq" value="<%=noteSeq%>">
<input type="hidden" name="note_ctnt_seq" value="<%=noteCtntSeq%>">
<input type="hidden" name="note_conv_mapg_id" value="<%=noteConvMapgId%>">
<input type="hidden" name="note_tp_cd" value="<%=noteTpCd%>">
<input type="hidden" name="master_seq" value="<%=masterSeq%>">
<input type="hidden" name="detail_seq" value="<%=detailSeq%>">
<input type="hidden" name="prop_sts_cd" value="<%=propStsCd%>">
<input type="hidden" name="conv_cfm_flg" value="<%=convCfmFlg%>"> <!-- CONVERSION 입력가능유무 체크 -->
<input type="hidden" name="note_conv_tp_cd" value="P">
<input type="hidden" name="note_tp_cd" value="P">
<input type="hidden" name="prc_prop_cre_tp_cd" value="<%=prcPropCreTpCd%>"> <!-- 이행된 데이터를 구분하기 위해 사용 -->
<input type="hidden" name="lgcy_if_flg" value="<%=lgcyIfFlg%>"> <!-- Legacy I/F Flag -->
<input type="hidden" name="ofc_auth_yn" value="<%=ofcAuthYn%>"> <!-- 입력권한설정에 사용 -->
<input type="hidden" name="con_chk" value="<%=conChk%>"> <!-- CONVERSION 체크유무 -->
<input type="hidden" name="req_usr_flg" value="<%=reqUsrFlg%>"> <!-- 입력권한설정에 사용 -->

<!-- OUTER - POPUP (S)tart -->
<table width="1000" class="popup" cellpadding="10" border="0">
	<tr>
		<td class="top"></td>
	</tr>
	<tr>
		<td valign="top"><!-- : ( Title ) (S) -->
		<table width="100%" border="0">
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif"
					align="absmiddle">&nbsp; Note Conversion History - Special Note Conversion Creation</td>
			</tr>
		</table>
		<!-- : ( Title ) (E) --> <!-- 1 (S) -->
		<table class="search" id="mainTable">
			<tr>
				<td class="bg"><!-- grid box (S) -->
				<table class="search">
					<tr>
						<td valign="top" width="38%"><!-- Grid-1  (S) -->
						<table width="100%" id="mainTable">
							<tr>
								<td width="100%" style="padding-left:3"><script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table>
						<!-- Grid-1 (E) --></td>
						<td width="5%" align="center"><img src="img/btn_add.gif"
							width="26" height="26" alt="" border="0" align="absmiddle"></td>

						<td valign="top" width="57%"><!-- Grid-2  (S) -->
						<table width="100%" id="mainTable">
							<tr>
								<td width="100%"><script language="javascript">ComSheetObject('sheet2');</script>
								</td>
							</tr>
						</table>
						<!-- Grid-2 (E) --></td>
					</tr>
					<tr>
						<td colspan="3">
						<table class="height_8">
							<tr>
								<td></td>
							</tr>
						</table>
						<table class="search">
							<tr class="h23">
								<td>
								<textarea name="note_ctnt" style="width: 979; height: 90; maxlength:2000;" class="textarea2" readonly="true">
								</textarea></td>
							</tr>
						</table>
						<table class="line_bluedot">
							<tr>
								<td height="23"></td>
							</tr>
						</table>


						<!--  biz_1  (S) -->
						<table class="search" border="0" style="width: 400;">
							<tr class="h23">
								<td width="15%">C/TYPE</td>
								<td width=""><script language="javascript">ComComboObject("note_chg_tp_cd", 1, 130, 1, 1, 0, false);</script>
								</td>
							</tr>

						</table>
						<table class="height_2">
							<tr>
								<td></td>
							</tr>
						</table>
						<!--  biz_1   (E) --> <!-- Grid  (S) -->
						<table width="100%" id="mainTable">
							<tr>
								<td width="100%"><script language="javascript">ComSheetObject('sheet3');</script>
								</td>
							</tr>
						</table>
						<!-- Grid (E) --> <!--  Button_Sub (S) -->
						<table width="100%" class="button">
							<tr>
								<td class="btn2_bg">
								<table border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td>
										<table width="100%" border="0" cellpadding="0" cellspacing="0"
											class="button">
											<tr>
												<td class="btn2_left"></td>
												<td class="btn2" name="btn_copy">Copy</td>
												<td class="btn2_right"></td>
											</tr>
										</table>
										</td>
										<td>
										<table width="100%" border="0" cellpadding="0" cellspacing="0"
											class="button">
											<tr>
												<td class="btn2_left"></td>
												<td class="btn2" name="btn_paste">Paste</td>
												<td class="btn2_right"></td>
											</tr>
										</table>
										</td>
										<td>
										<table width="100%" border="0" cellpadding="0" cellspacing="0"
											class="button">
											<tr>
												<td class="btn2_left"></td>
												<td class="btn2" name="btn_rowadd">Row&nbsp;Add</td>
												<td class="btn2_right"></td>
											</tr>
										</table>
										</td>

										<td>
										<table width="100%" border="0" cellpadding="0" cellspacing="0"
											class="button">
											<tr>
												<td class="btn2_left"></td>
												<td class="btn2" name="btn_rowcopy">Row&nbsp;Copy</td>
												<td class="btn2_right"></td>
											</tr>
										</table>
										</td>

										<td>
										<table width="100%" border="0" cellpadding="0" cellspacing="0"
											class="button">
											<tr>
												<td class="btn2_left"></td>
												<td class="btn2" name="btn_delete">Delete</td>
												<td class="btn2_right"></td>
											</tr>
										</table>
										</td>

									</tr>
								</table>
								</td>
							</tr>
						</table>
						<!-- Button_Sub (E) --></td>
					</tr>
				</table>
				<!-- grid box (E) --></td>
			</tr>
		</table>
		<!-- 1 (E) --></td>
	</tr>
</table>

<table class="height_5">
	<tr>
		<td></td>
	</tr>
</table>

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup"><!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0"
			cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
			<tr>
				<td class="btn3_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_retrieve">Retrieve</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_save">Save</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td class="btn1_line"></td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_close">Close</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		<!--Button (E) -->
		</td>
	</tr>
</table>
<!-- : ( Button : pop ) (E) --> <!-- 개발자 작업  끝 -->
</form>
</body>
</html>