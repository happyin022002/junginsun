<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_2103_06.jsp
*@FileTitle : RFA Proposal Affiliate Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.08.17 김재연 
* 1.0 Creation
=========================================================
* History
* 2014.09.15 최성환  [CHM-201431899] Guideline RFA 생성 요청
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
<%@ page import="com.hanjin.apps.alps.esm.pri.rfaproposal.rfaaffiliateproposal.event.EsmPri200306Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%
	EsmPri200306Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.SCProposal.RFAAffiliateProposal");

	String propNo = "";
	String amdtSeq = "";
	String preAmdtSeq = "";
	String propStsCd = "";
	String effDt = "";
	String expDt = "";
	String preExpDt = "";
	String rfaNo = "";
	String repUsrFlg = "";
	String aproUsrFlg = "";
	String ctrtExpDt = "";
	String ctrtEffDt = "";
	String durDupFlg = "";
	String[] srcInfoCd = null;
	String[] stsCd = null;
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri200306Event)request.getAttribute("Event");
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
		effDt = StringUtil.xssFilter(request.getParameter("sEffDt"));
		expDt = StringUtil.xssFilter(request.getParameter("sExpDt")); 
		preExpDt = StringUtil.xssFilter(request.getParameter("sPreExpDt"));
		rfaNo = StringUtil.xssFilter(request.getParameter("sRfaNo"));
		ctrtExpDt = StringUtil.xssFilter(request.getParameter("sCtrtExpDt"));
		ctrtEffDt = StringUtil.xssFilter(request.getParameter("sCtrtEffDt"));
		durDupFlg = StringUtil.xssFilter(request.getParameter("sDurDupFlg"));
		repUsrFlg = StringUtil.xssFilter(request.getParameter("sIsReqUsr"));
		aproUsrFlg = StringUtil.xssFilter(request.getParameter("sIsAproUsr"));
		
		/*
		propNo = "TES090001";
		amdtSeq = "2";
		//amdtSeq = "0";
		effDt="20090101";
		expDt="20091231";
		preExpDt="20081231";
		preAmdtSeq = "1";
		propStsCd="I";
		
		ctrtEffDt = "20091201";
		ctrtExpDt = "20100101";
		*/
		srcInfoCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("srcInfoList"), false ,"|","\t","getCode","getName");	
		stsCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("stsList"), false ,"|","\t","getCode","getName");	
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Proposal Affiliate Creation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
    var srcInfoCdValue = "<%=srcInfoCd[0]%>";
    var srcInfoCdText = "<%=srcInfoCd[1]%>";    
    var stsCdValue = "<%=stsCd[0]%>";
    var stsCdText = "<%=stsCd[1]%>"; 
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
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
<input type="hidden" name="pre_exp_dt" value="<%=preExpDt %>">
<input type="hidden" name="eff_dt" value="<%=effDt %>">
<input type="hidden" name="exp_dt" value="<%=expDt %>">
<input type="hidden" name="cd">
<input type="hidden" name="sts_cd">
<input type="hidden" name="mnl_chk">
<input type="hidden" name="req_usr_flg" value="<%=repUsrFlg%>">
<input type="hidden" name="apro_usr_flg" value="<%=aproUsrFlg%>">
<input type="hidden" name="dur_dup_flg" value="<%=durDupFlg%>">

<!-- OUTER - POPUP (S)tart -->
<table width="900" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Proposal Affiliate Creation</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
	
	
	
	
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="50">RFA No.</td>
					<td width="120">
					<input type="text" name="rfaNo" style="width:100;text-align:center;" class="input2" value="<%=rfaNo%>">&nbsp;
					<td width="55">AMD No.</td>
					<td width="80"><input type="text" name="amdt_seq" style="width:50;text-align:center;" class="input2" value="<%=amdtSeq %>"></td> 
					<td width="80">Proposal No.</td>
					<td width="130"><input type="text" name="prop_no" style="width:90;text-align:center;" class="input2" value="<%=propNo%>"></td>
					<td width="60">Duration</td>
					<td><input type="text" name="hdr_eff_dt" style="width:70;text-align:center;" class="input2" caption="Eff Date" maxlength="10" dataformat="ymd" value="<%=ctrtEffDt%>">&nbsp;~&nbsp;
						<input type="text" name="hdr_exp_dt" style="width:70;text-align:center;" class="input2" caption="Expire Date" maxlength="10" dataformat="ymd" value="<%=ctrtExpDt%>"></td>
 
					</tr>
					
				
				
				</table>
				<!--  biz_1   (E) -->
				
				<!--  biz_2  (S) -->
				<!-- Grid  (S) -->
							<table width="100%"  id="mainTable"> 
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('sheet1');</script>
									</td>
								</tr>
							</table> 
				<!-- Grid (E) -->
						
				<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_RowAdd">Row&nbsp;Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td width="72"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Delete">Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Amend">Amend</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_AmendCancel">Amend Cancel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Accept">Accept</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_AcceptCancel">Accept Cancel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</table>
			</td></tr>
			</table>
				<!--  biz_2   (E) -->
				</td></tr>
			</table>
	
	<!--biz page (E)-->
		</td></tr>
			</table>
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left">
					<td class="btn1" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right">
				</table></td>
				    <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Save</td>
					<td class="btn1_right"></td>
						</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_AcceptAll">Accept All</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_CancelAll">Cancel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
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