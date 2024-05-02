<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_1091.jsp
*@FileTitle : Chassis Inventory List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.09
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.07.09 김창식
* 1.0 Creation
*--------------------------------------------------
* History
* 2015.04.28 Chang Young Kim [CHM-201534113] 2015년 1월 소스 보안 결함 건 조치 요청
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.event.EesCgm1091Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.StringUtil"%>

<%
	EesCgm1091Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.ChassisMgsetAgreementInvoice.ChassisMgsetAgreement");
	
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

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
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
		/* groupValue3 	= StringUtil.xssFilter(request.getParameter("agmt_lstm_cd")); */
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
<html>
<head>
<title>Chassis Inventory List</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		
		loadPage();
	}
</script>
</head>

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="program_id" value="<%=programId %>">
<input type="hidden" name="eq_knd_cd" value="<%=eqKndCd %>">
<input type="hidden" name="sts_evnt_dt_fr" value="<%=stsEvntDtFr %>">
<input type="hidden" name="sts_evnt_dt_to" value="<%=stsEvntDtTo %>">
<input type="hidden" name="sts_evnt_ofc_cd" value="<%=stsEvntOfcCd %>">
<input type="hidden" name="old_agmt_ofc_cty_cd" value="<%=oldAgmtOfcCtyCd %>">
<input type="hidden" name="old_agmt_seq" value="<%=oldAgmtSeq %>">
<input type="hidden" name="new_agmt_ofc_cty_cd" value="<%=newAgmtOfcCtyCd %>">
<input type="hidden" name="new_agmt_seq" value="<%=newAgmtSeq %>">
<input type="hidden" name="eq_tpsz_cd" value="<%=eqTpszCd %>">

<input type="hidden" name="crnt_loc_cd" value="<%=crntLocCd %>">
<input type="hidden" name="crnt_yd_cd" value="<%=crntYdCd %>">
<input type="hidden" name="aciac_div_cd" value="<%=aciacDivCd %>">
<input type="hidden" name="chss_pool_cd" value="<%=chssPoolCd %>">
<input type="hidden" name="include_np" value="<%=includeNp %>">
<input type="hidden" name="staying_days" value="<%=stayingDays %>">
<input type="hidden" name="group1" value="<%=group1 %>">
<input type="hidden" name="group2" value="<%=group2 %>">
<input type="hidden" name="group3" value="<%=group3 %>">
<input type="hidden" name="group_value1" value="<%=groupValue1 %>">
<input type="hidden" name="group_value2" value="<%=groupValue2 %>">
<input type="hidden" name="group_value3" value="<%=groupValue3 %>">
<input type="hidden" name="agmt_lstm_cd" value="<%=agmtLstmCd %>">
<input type="hidden" name="s_agmt_lstm_cd" value="<%=sAgmtLstmCd %>">
<input type="hidden" name="vndr_seq" value="<%=vndrSeq %>">
<input type="hidden" name="chss_mvmt_sts_cd" value="<%=chssMvmtStsCd %>">

<input type="hidden" name="eq_aset_sts_cd" value="<%=eqAsetStsCd %>">
<input type="hidden" name="location" value="<%=location %>">
<input type="hidden" name="scc_cd" value="<%=sccCd %>">
<input type="hidden" name="sts_evnt_loc_cd" value="<%=stsEvntLocCd %>">
<input type="hidden" name="kind" value="<%=kind %>">

<input type="hidden" name="inq_fm_dys" value="<%=inqFmDys %>">
<input type="hidden" name="inq_to_dys" value="<%=inqToDys %>">
<input type="hidden" name="include_status_lst" value="<%=includeStatusLst %>">
<input type="hidden" name="include_out_gated" value="<%=includeOutGated %>">

<input type="hidden" name="agmt_no" value="<%=agmt_no%>">

<input type="hidden" name="s_group1" value="<%=sGroup1 %>">
<input type="hidden" name="s_group1_val" value="<%=sGroup1Val %>">
<input type="hidden" name="s2_group1" value="<%=s2Group1 %>">
<input type="hidden" name="s2_group1_val" value="<%=s2Group1Val %>">
<input type="hidden" name="s2_group2" value="<%=s2Group2 %>">
<input type="hidden" name="s2_group2_val" value="<%=s2Group2Val %>">
<input type="hidden" name="s2_group3" value="<%=s2Group3 %>">
<input type="hidden" name="s2_group3_val" value="<%=s2Group3Val %>">
<input type="hidden" name="s3_gtotal" value="<%=s3Gtotal %>">

<input type="hidden" name="s2_eq_tpsz_cd" value="<%=s2EqTpszCd %>">

<input type="hidden" name="old_agmt_lstm_cd" value="<%=old_agmt_lstm_cd %>">
<input type="hidden" name="new_agmt_lstm_cd" value="<%=new_agmt_lstm_cd %>">

<input type="hidden" name="atch_bare" value="<%=atch_bare %>">
<input type="hidden" name="dmg_snd" value="<%=dmg_snd %>">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Chassis Inventory List</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
			
		<!-- : ( Search Options ) (E) -->
	
		<!-- Tab BG Box  (S) -->
     	<table class="search"> 
       	<tr><td class="bg">
			
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->
			
			</td></tr>
		</table>
	<!-- Tab BG Box  (S) -->
	<table class="height_5"><tr><td></td></tr></table>
</td></tr>
</table> 


	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel">Down&nbsp;Excel</td>
					<td class="btn1_right">
				</tr></table></td>
				<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right">
				</tr></table></td>
			</tr>
		</table></td>
			</tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>



<!-- 개발자 작업  끝 -->
</form>
</body>
</html>