<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_6037.jsp
*@FileTitle : CMPB Guideline Creation - Origin & Destination
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.07.10 이승준
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

<%@ page import="org.apache.log4j.Logger" %>

<%
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.ProfitabilitySimulation.CMPBGuideline");

	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		//svcScpCd = request.getParameter("svc_scp_cd");
		//glineSeq = request.getParameter("gline_seq");
		//prcCustTpCd = request.getParameter("prc_cust_tp_cd");
		//CmdtHrdSeq = request.getParameter("cmdt_hdr_seq");
		//routSeq = request.getParameter("rout_seq");
		//orgDestTpCd = request.getParameter("org_dest_tp_cd");
		//pntViaTpCd = request.getParameter("pnt_via_tp_cd");

		
		//svcScpCd="ACE";
		//glineSeq ="1";
		//prcCustTpCd="A";
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>CMPB Guideline Creation - Origin & Destination</title>
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
<input type="hidden" name="cd" value="">
<input type="hidden" name="svc_scp_cd" value="<%=request.getParameter("svc_scp_cd")%>" >
<input type="hidden" name="cre_ofc_cd" value="<%=request.getParameter("cre_ofc_cd")%>">
<input type="hidden" name="gline_seq" value="<%=request.getParameter("gline_seq")%>">
<input type="hidden" name="prs_cust_tp_cd" value="<%=request.getParameter("prs_cust_tp_cd")%>">
<input type="hidden" name="bse_seq" value="<%=request.getParameter("bse_seq")%>">
<input type="hidden" name="org_dest_tp_cd" value="<%=request.getParameter("org_dest_tp_cd")%>">
<input type="hidden" name="pnt_via_tp_cd" value="<%=request.getParameter("pnt_via_tp_cd")%>">

<!-- OUTER - POPUP (S)tart -->
<table width="700" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; CMPB Guideline Creation - Origin & Destination</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
				
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="%">
						<table border="0" style="width:90%;" class="search_sm"> 
						<tr class="h23">
						<td width="20%">Route Point</td>
						<td width="" class="stm">
						<input type="radio" class="trans" name="rt_pnt" value="5" checked>&nbsp;Origin&nbsp;&nbsp;
						<input type="radio" class="trans" name="rt_pnt" value="6" >&nbsp;Origin Via&nbsp;&nbsp;
						<input type="radio" class="trans" name="rt_pnt" value="7" >&nbsp;Destination Via&nbsp;&nbsp;
						<input type="radio" class="trans" name="rt_pnt" value="8" >&nbsp;Destination
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
				<!-- : ( Button : Grid ) (S) -->
				<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_RowAdd">Row Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_RowDel">Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>						
				</table>
			</td></tr>
			</table>			
			
	    	<!-- Button_Sub (E) -->			
		    <!-- : ( Button : Grid ) (E) -->			
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
		
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
					<td class="btn1" name="btn_Ok">OK</td>
					<td class="btn1_right"></td>
			</tr>
			</table>
			<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left">
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right">
					</tr>
				</table></td>
		</td></tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
<div id="hiddenSheetLayer" style="display: none "> 
<script language="javascript">ComSheetObject('sheet2');</script>
<script language="javascript">ComSheetObject('sheet3');</script>
<script language="javascript">ComSheetObject('sheet4');</script>
<script language="javascript">ComSheetObject('sheet5');</script>
</div>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>