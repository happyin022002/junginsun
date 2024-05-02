<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0078.jsp
*@FileTitle : Contract Parties Information Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.05
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.10.05 공백진
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.scproposal.sccontractpartyproposal.event.EsmPri0078Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%
	EsmPri0078Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.SCProposal.SCContractPartyProposal");
	
	String propNo = "";	
	String amdtSeq = "";
	
	String sCustCntCd = "";
	String sCustSeq = "";
	String sCustNm ="";

	String scNo1 = "";
	String scNo2 = "";
	String[] srcInfoCd = null;
	String[] stsCd = null;	

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmPri0078Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		propNo = request.getParameter("sPropNo");
		amdtSeq = request.getParameter("sAmdtSeq");	
		sCustCntCd = request.getParameter("sCustCntCd");		
		sCustSeq = request.getParameter("sCustSeq");		
		sCustNm = request.getParameter("sCustNm");		
		scNo1 = request.getParameter("sSc_No1");
		scNo2 = request.getParameter("sSc_No2");
		srcInfoCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("srcInfoList"), false ,"|","\t","getCode","getName");	
		stsCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("stsList"), false ,"|","\t","getCode","getName");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Contract Parties Information Inquiry</title>
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
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="prop_no" value="<%=propNo %>">
<input type="hidden" name="cd">

<!-- OUTER - POPUP (S)tart -->
<table width="900" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Contract Parties Information Inquiry</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
		<table class="search"> 
       		<tr><td class="bg">
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="50">S/C No.</td>
					<td width="110">
						<input type="text" name="sc_no1" style="width:30;text-align:center;" class="input2" value="<%=scNo1%>">
						<input type="text" name="sc_no2" style="width:55;text-align:center;" class="input2" value="<%=scNo2%>"></td>
					<td width="55">AMD No.</td>
					<td width="60"><input type="text" name="amdt_seq" style="width:40;text-align:center;" class="input2" value="<%=amdtSeq %>"></td>
					<td width="80">Proposal No.</td>
					<td width="105"><input type="text" name="prop_no" style="width:85;text-align:center;" class="input2" value="<%=propNo %>"></td>
					<td width="65">Customer</td>
					<td width="320"><input type="text" name="cust_cd" style="width:30;text-align:center;" class="input2" value="<%=sCustCntCd %>">
						<input type="text" name="cust_seq" style="width:50;text-align:center;" class="input2" value="<%=sCustSeq %>">
						<input type="text" name="cust_nm" style="width:218;" class="input2" value="<%=sCustNm %>"></td></tr>
				</table>
			
			
		
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
	
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					
					<td width="%">
						<table border="0" style="width:40%;" class="search_sm2"> 
						<tr class="h23">
						
							<td width="40%">Contract Party</td>
						<td width="" id="prcCtrtPtyTpCd" class="sm">
						<input type="radio" name="prc_ctrt_pty_tp_cd" value="H"  class="trans" checked><span id="tp2">SML</span>&nbsp;
						<input type="radio" name="prc_ctrt_pty_tp_cd" value="C"  class="trans"><span id="tp1">Customer</span>
						
						</td>
						</tr>
						</table></td>
					</tr>	
				</table>
				<!-- : ( Grid ) (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- : ( Grid ) (E) -->	
				
			
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