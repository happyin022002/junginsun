<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_2010.jsp
*@FileTitle : Duration
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.18
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.05.18 공백진
* 1.0 Creation
=========================================================
* History
* 2013.12.20 서미진 [CHM-201328281] RFA에 계약 구분인자 추가 (C : Contract, S : Spot)
* [CHM-201534517] 1월 소스 보안 결함 건 조치 요청
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.rfaproposal.rfadurationproposal.event.EsmPri2010Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%
	EsmPri2010Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.RFAProposal.RFADurationProposal");
	
	String propNo = "";
	String amdtSeq = "";
	String preAmdtSeq = "";
	String propStsCd = "";
	String rfaNo = "";
	//String rfaNo1 = "";
	//String rfaNo2 = "";
	String svcScpCd ="";
	String strUsr_ofc = "";	
	String repUsrFlg = "";
	String aproUsrFlg = "";
	String durDupFlg = "";

	//String repUsrFlg = "";
	//String aproUsrFlg = "";	
	//String effDt = "";
	//String expDt = "";
	//String preExpDt = "";
	String[] srcInfoCd = null;
	String[] stsCd = null;
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();
	   
		event = (EsmPri2010Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		propNo = StringUtil.xssFilter(request.getParameter("sPropNo"));
		amdtSeq = StringUtil.xssFilter(request.getParameter("sAmdtSeq"));
		

		preAmdtSeq = StringUtil.xssFilter(request.getParameter("sPreAmdtSeq"));
		propStsCd = StringUtil.xssFilter(request.getParameter("sPropStsCd"));
		rfaNo = StringUtil.xssFilter(request.getParameter("sRfaNo"));
		svcScpCd = StringUtil.xssFilter(request.getParameter("sSvcScpCd"));
		//sc_no = "TES090001";
		/*
		if (rfaNo != null && rfaNo !="" && rfaNo.length() >= 3){
			rfaNo1 = rfaNo.substring(0,3);
			rfaNo2 = rfaNo.substring(3,rfaNo.length());
		}
		*/
		repUsrFlg = StringUtil.xssFilter(request.getParameter("sIsReqUsr"));
		aproUsrFlg = StringUtil.xssFilter(request.getParameter("sIsAproUsr"));
		durDupFlg = StringUtil.xssFilter(request.getParameter("sDurDupFlg"));
		//repUsrFlg = request.getParameter("sRepUsrFlg");		
		//aproUsrFlg = request.getParameter("sAproUsrFlg");
		
		//effDt = request.getParameter("sEffDt");
		//expDt = request.getParameter("sExpDt"); 
		//preExpDt = request.getParameter("sPreExpDt");	

		srcInfoCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("srcInfoList"), false ,"|","\t","getCode","getName");	
		stsCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("stsList"), false ,"|","\t","getCode","getName");	

		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Duration</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
    var srcInfoCdValue = "<%=srcInfoCd[0]%>";
    var srcInfoCdText = "<%=srcInfoCd[1]%>";    
    var stsCdValue = "<%=stsCd[0]%>";
    var stsCdText = "<%=stsCd[1]%>"; 
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
	function closePage(){
		unloadPage();
	}		
</script>
</head>

<body  onLoad="setupPage();" onunLoad="closePage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="pre_amdt_seq" value="<%=preAmdtSeq %>">
<input type="hidden" name="prop_sts_cd" value="<%=propStsCd %>">
<input type="hidden" name="pre_exp_dt" >
<input type="hidden" name="eff_dt" >
<input type="hidden" name="exp_dt" >
<input type="hidden" name="cd">
<input type="hidden" name="svc_scp" value="<%=svcScpCd %>">

<input type="hidden" name="req_usr_flg" value="<%=repUsrFlg %>">
<input type="hidden" name="apro_usr_flg" value="<%=aproUsrFlg %>">
<input type="hidden" name="dur_dup_flg" value="<%=durDupFlg %>">
<input type="hidden" name="usr_id" value="<%=strUsr_id %>" >
<input type="hidden" name="srep_cd" value="<%=strUsr_ofc %>">
<input type="hidden" name="amend_flg" >
<input type="hidden" name="scp_accept" >
<input type="hidden" name="endExpDt"  value="<%=JSPUtil.getParameter(request, "endExpDt") %>">
<input type="hidden" name="addOnEndExpDt"  value="<%=JSPUtil.getParameter(request, "addOnEndExpDt") %>">  
<input type="hidden" name="rfa_ctrt_tp_cd" value="<%=JSPUtil.getParameter(request, "sRfaCtrtTpCd") %>">
<!-- OUTER - POPUP (S)tart -->
<table width="400" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Duration</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
				<table class="search" border="0" style="width:600;"> 
				<tr class="h23">
					<td width="75">RFA No.</td>
					<td width="120">
						<input type="text" name="rfaNo1" style="width:100;text-align:center;" class="input2" value="<%=rfaNo%>">
						</td>
					<td width="60">AMD No.</td>
					<td width="100"><input type="text" name="amdt_seq" style="width:40;text-align:center;" class="input2" value="<%=amdtSeq%>"></td>
					<td width="80">Proposal No.</td>
					<td width=""><input type="text" name="prop_no" style="width:80;text-align:center;" class="input2" value="<%=propNo%>"></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:600;"> 
				<tr class="h23">
					<td width="77">SVC Scope</td>
					<td width="52">
						<script language="javascript">ComComboObject('svc_scp_cd', 2, 50, 0, 1, 0, false);</script>
					</td>
					<td>
						<input name="svc_scp_nm" type="text" style="width:306;"  value="" class="input2" readonly caption="Service Scope">
						</td></tr>
				</table>
				
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
				
				
				<!-- : ( Grid ) (S) -->
							<table width="100%"  id="mainTable"> 
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('sheet1');</script>
									</td>
								</tr>
							</table> 
				<!-- : ( Grid ) (E) -->	
				<!--  Button_Sub (S) -->
			
<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0"> 
       	<tr><td class="btn2_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				
				<td id="Amend"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left">
					<td class="btn2" name="btn_Amend">Amend</td>
					<td class="btn2_right">
					</tr>
				</table></td>
				<td id="AmendCancel"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_AmendCancel">Amend Cancel</td>
					<td class="btn2_right"></td>
					</tr>
				</table></td>
				
				<td id="Accept"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left">
					<td class="btn2" name="btn_Accept">Accept</td>
					<td class="btn2_right">
					</tr>
				</table></td>
				<td id="AcceptCancel"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left">
					<td class="btn2" name="btn_AcceptCancel">Accept Cancel</td>
					<td class="btn2_right">
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
	    	<!-- Button_Sub (E) -->
		    <!-- : ( Button : Grid ) (E) -->	
			
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->

<table class="height_5"><tr><td></td></tr></table>
		
		
		
</td></tr>
</table> 

<!-- : ( Button : pop ) (S) -->




<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
				<td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Save</td>
					<td class="btn1_right"></td>
				<td class="btn1_line"></td>	
				<td width="72"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right"></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>