<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0235.jsp
*@FileTitle : MNR Release Order Transmission
*Open Issues :     
*Change history :  
*@LastModifyDate : 2010.01.14
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2010.01.14 김완규
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
<%@ page import="com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.event.EesMnr0235Event" %>
<%@ page import="org.apache.log4j.Logger" %>

<%

	EesMnr0235Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	 
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100"; 
 	 
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String rhqOfcCd         = "";
	String currOfcCd        = "";
	String currOfcEngNm     = "";
	
	String dispNo			= "";
	String userNm			= "";
	String mnrPrnrCntCd		= "";
	String mnrPrnrSeq		= "";
	String faxNo			= "";
	String mnrPrnrEml		= "";
	 
	Logger log = Logger.getLogger("com.hanjin.apps.OperationManage.RepairMgt");
	        
	try {     
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id       = account.getUsr_id();
		strUsr_nm       = account.getUsr_nm(); 
		rhqOfcCd        = account.getRhq_ofc_cd();
		currOfcCd       = account.getOfc_cd();
		currOfcEngNm    = account.getOfc_eng_nm();
	       
		event = (EesMnr0235Event)request.getAttribute("Event"); 
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
 
		if (serverException != null) {   
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();  
		}       
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	    
		dispNo = JSPUtil.getParameter(request, "disp_no");
		userNm = JSPUtil.getParameter(request, "user_nm");
		mnrPrnrCntCd = JSPUtil.getParameter(request, "mnr_prnr_cnt_cd");
		mnrPrnrSeq = JSPUtil.getParameter(request, "mnr_prnr_seq");
		faxNo = JSPUtil.getParameter(request, "fax_no");
		mnrPrnrEml = JSPUtil.getParameter(request, "mnr_prnr_eml");

		
	}catch(Exception e) {   
		out.println(e.toString());
	}
%>
<html>
<head>
<title>MNR Release Order Transmission</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
<script language="javascript">
    var currOfcCd = "<%=currOfcCd.trim() %>";
    var rhqOfcCd  = "<%=rhqOfcCd.trim() %>";
    var HOOfc     = "";
    
    var dispNo			= "<%=dispNo%>";
    var userNm			= "<%=strUsr_nm%>";
    var mnrPrnrCntCd	= "<%=mnrPrnrCntCd%>";
    var mnrPrnrSeq		= "<%=mnrPrnrSeq%>";
    var faxNo			= "<%=faxNo%>";
    var mnrPrnrEml		= "<%=mnrPrnrEml%>";
        
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<script language="javascript">ComSheetObject('sheet1');</script>
</head>

<body  onLoad="setupPage();"> 
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="disp_no" value="<%= dispNo%>">
<input type="hidden" name="user_nm" value="<%= userNm%>">
<input type="hidden" name="mnr_prnr_cnt_cd" value="<%= mnrPrnrCntCd%>">
<input type="hidden" name="mnr_prnr_seq" value="<%= mnrPrnrSeq%>">

<!-- OUTER - POPUP (S)tart -->
<table width="900" height="500" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">   MNR Release Order Transmission</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
<!--biz page (S)-->
		<!-- 1 (S) -->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
				<td width="100%">
				
				<!--  biz  (S) -->
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="115">Transmission Type</td>
					<td width="" style="padding-left:0"><script language="javascript">ComComboObject('trsm_mod_cd', 1, 60, 1, 1)</script>&nbsp;<input id="iFax_no" type="text" name="fax_no" style="width:170" class="input1" dataformat="engup" maxLength="20"><input id="iMnr_prnr_eml" type="text" name="mnr_prnr_eml" style="width:200" class="input1" maxLength="200"></td>
				</tr> 
				</table>				
				<!--  biz   (E) -->
				
				</td>
				</tr>
			</table>

		</td></tr>
		</table>	
		<!-- 1 (E) -->
		
		<!-- 2 (S) -->		
		<table class="height_8"><tr><td></td></tr></table>	
		<table class="search" id="mainTable"  width="100%" height="350"> 
       		<tr><td class="bg">	
				<!-- Grid  (S) -->
				<script language="javascript">comRdObject('TestRd');</script>
				<!-- Grid (E) -->	
		</td></tr>
		</table>
		<!-- 2 (E) -->		
		<!--biz page (E)--> 
				
</td></tr></table>


<!-- : ( Button : pop ) (S) -->
<table width="100%"  class="sbutton">
<tr><td height="100%" class="popup">

    	<!--Button (S) -->	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>		
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DOCSend">Doc Send</td>
					<td class="btn1_right">
				</tr></table></td>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Print">Print</td>
					<td class="btn1_right">
				</tr></table></td>	
			<td class="btn1_line"></td>		
			<td class="btn3_bg">
		    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
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
			
</form>	
</body>
</html>
