<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_2084.jsp
*@FileTitle : M.G.Set Inventory List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.13
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.07.13 김창식
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
<%@ page import="com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.event.EesCgm2084Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil"%>

<%
	EesCgm2084Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.ChassisMgsetAgreementInvoice.ChassisMgsetAgreement");
	
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
    
    // 2012.10.05 조경완 
    String disp_cd = "";
    
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EesCgm2084Event)request.getAttribute("Event");
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
	      
		
		sCrntOfcCd    	= StringUtil.xssFilter(request.getParameter("s_crnt_ofc_cd"));
		sVndrSeq      	= StringUtil.xssFilter(request.getParameter("s_vndr_seq"));
		sAgmtLstmCd   	= StringUtil.xssFilter(request.getParameter("s_agmt_lstm_cd"));
		s2AgmtNo      	= StringUtil.xssFilter(request.getParameter("s2_agmt_no"));
		s2AgmtRefNo   	= StringUtil.xssFilter(request.getParameter("s2_agmt_ref_no"));
		
		s1InqFmDys     	= StringUtil.xssFilter(request.getParameter("s1_inq_fm_dys"));
		s1InqToDys     	= StringUtil.xssFilter(request.getParameter("s1_inq_to_dys"));
		
		s2LocCd       	= StringUtil.xssFilter(request.getParameter("s2_loc_cd"));
	    
		s3Gtotal      	= StringUtil.xssFilter(request.getParameter("s3_gtotal"));
		
        atch_bare       = StringUtil.xssFilter(request.getParameter("atch_bare"));
        dmg_snd         = StringUtil.xssFilter(request.getParameter("dmg_snd"));
        
        disp_cd 	    = StringUtil.xssFilter(request.getParameter("disp_cd"));
        
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>M.G.Set Inventory List</title>
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
<form name="form2">
<input type="hidden" name="sXml" value="<%=xml.replace("\"","'")%>">
</form>
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

<input type="hidden" name="s_location" value="<%=sLocation %>">
<input type="hidden" name="s_crnt_loc_cd" value="<%=sCrntLocCd %>">
<input type="hidden" name="s_crnt_yd_cd" value="<%=sCrntYdCd %>">
<input type="hidden" name="s_aciac_div_cd" value="<%=sAciacDivCd %>">
<input type="hidden" name="s_eq_tpsz_cd" value="<%=sEqTpszCd %>">
<input type="hidden" name="s_group1" value="<%=sGroup1 %>"> 
<input type="hidden" name="s_group1_val" value="<%=sGroup1Val %>">
<input type="hidden" name="s2_group1" value="<%=s2Group1 %>">
<input type="hidden" name="s2_group1_val" value="<%=s2Group1Val %>">
<input type="hidden" name="s2_group2" value="<%=s2Group2 %>">
<input type="hidden" name="s2_group2_val" value="<%=s2Group2Val %>">
<input type="hidden" name="s2_group3" value="<%=s2Group3 %>">
<input type="hidden" name="s2_group3_val" value="<%=s2Group3Val %>">
<input type="hidden" name="s2_agmt_lstm_cd" value="<%=s2AgmtLstmCd %>">
<input type="hidden" name="s2_eq_tpsz_cd" value="<%=s2EqTpszCd %>">


<input type="hidden" name="s_crnt_ofc_cd" value="<%=sCrntOfcCd %>">
<input type="hidden" name="s_vndr_seq" value="<%=sVndrSeq %>">
<input type="hidden" name="s_agmt_lstm_cd" value="<%=sAgmtLstmCd %>">
<input type="hidden" name="s2_agmt_no" value="<%=s2AgmtNo %>">
<input type="hidden" name="s2_agmt_ref_no" value="<%=s2AgmtRefNo %>">

<input type="hidden" name="s1_inq_fm_dys" value="<%=s1InqFmDys %>">
<input type="hidden" name="s1_inq_to_dys" value="<%=s1InqToDys %>">

<input type="hidden" name="s2_loc_cd" value="<%=s2LocCd %>">

<input type="hidden" name="s3_gtotal" value="<%=s3Gtotal %>">

<input type="hidden" name="atch_bare" value="<%=atch_bare %>">
<input type="hidden" name="dmg_snd" value="<%=dmg_snd %>">
<input type="hidden" name="disp_cd" value="<%=disp_cd %>">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;M.G.Set Inventory List</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
			
		<!-- : ( Search Options ) (E) -->
		<table class="height_10"><tr><td colspan="8"></td></tr></table>
		
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
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
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
<!-- : ( Button : pop ) (E) -->


<!-- 개발자 작업  끝 -->
</form>
</body>
</html>