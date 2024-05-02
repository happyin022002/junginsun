<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0056.jsp
*@FileTitle : S/C No. Assignement
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.07.10 공백진
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.event.EsmPri0056Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmPri0056Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.SCProposal.SCProposalMain");
	
	String propNo = "";
	String ctrtEffDt = "";
	String ctrtExpDt = "";
	
	String svcScpCd = "";
	String svcCnt = "";
	String ofcCd = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   	   
		event = (EsmPri0056Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
				
		propNo = request.getParameter("sPropNo");
		ctrtExpDt = request.getParameter("sCtrtExpDt");
		ctrtEffDt = request.getParameter("sCtrtEffDt");		
		svcScpCd = request.getParameter("svcScpCd");
		svcCnt = request.getParameter("svcCnt");		
		ofcCd = request.getParameter("sOfcCd");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>S/C No. Assignement</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
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
<input type="hidden" name="svc_scp_cd" value="<%=svcScpCd %>">
<input type="hidden" name="svcCnt" value="<%=svcCnt %>"> 
<input type="hidden" name="ofc_cd" value="<%=ofcCd %>"> 
<!-- OUTER - POPUP (S)tart -->
<table width="400" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;S/C No. Assignement</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search" id="mainTable">  
       		<tr><td class="bg">
				<table class="search" border="0" style="width:500;"> 
				<tr class="h23">
					<td width="17%">Proposal No.</td>
					<td width="30%">
					<input type="text" name="prop_no" style="width:80;" class="input2" value="<%=propNo %>"></td>
					<td width="10%">Duration</td>
					<td>
						<input type="text" name="ctrt_eff_dt" style="width:70;" class="input2" value="<%=ctrtEffDt %>">&nbsp;<img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="">&nbsp;~&nbsp;
						<input type="text" name="ctrt_exp_dt" style="width:70;" class="input2" value="<%=ctrtExpDt %>">&nbsp;<img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class=""></td> </tr>
				</table>
				
				<table class="height_5"><tr><td></td></tr></table>
				
				<table border="0" style="width:100%;" class="search_sm"> 
						<tr class="h23">
						<td width="26%"><input type="radio" name="opt_sc" class="trans" checked>&nbsp;General S/C  No.</td>
						<td width="23%">
							<input type="text" name="spre_fix" dataformat="engup" style="width:35;" maxlength="3" minlength="3" fulfil class="input" caption="S/C PreFix">
							<input type="text" name="ssc_no"   dataformat="int"   style="width:50;" maxlength="6"  minlength="6"  fulfil class="input" caption="S/C no"></td>
						<td width="26%">
						<input type="radio" name="opt_sc" class="trans">&nbsp;Global S/C  No.</td>
						<td width="">
							<input type="text" name="gpre_fix" fulfil dataformat="engup" maxlength="3" style="width:35;" class="input" value="GLO">
							<input type="text" name="gsc_no"   fulfil dataformat="int" style="width:50;" maxlength="6" class="input" caption="S/C no"></td>
						</tr>
						</table>
				
				
	    	<!-- Button_Sub (E) -->
		    <!-- : ( Button : Grid ) (E) -->	
			
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
</td></tr>
</table> 

 <table width="100%" style="display:inline;">
     <tr>
         <td width="100%">
             <script language="javascript">ComSheetObject('sheet1');</script>
         </td>
     </tr>
 </table>    

<table class="height_5"><tr><td></td></tr></table>
	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td width="72">
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Ok">OK</td>
					<td class="btn1_right"></td>					
					</tr>
				</table>
				</td>
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