<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_2045.jsp
*@FileTitle : Retroactive RFA Note
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.27
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2014.11.27 최성환
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.event.EsmPri2045Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri2045Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	
	String prop_no = "";
	String amdt_seq = "";
	
	prop_no = JSPUtil.getNull(request.getParameter("prop_no"));
	amdt_seq = JSPUtil.getNull(request.getParameter("amdt_seq"));

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.RFAProposal.RFAProposalMain");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmPri2045Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
		    strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Retroactive RFA Note</title>
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
<input type="hidden" name="prop_no" value="<%=prop_no%>">
<input type="hidden" name="amdt_seq" value="<%=amdt_seq%>">
<input type="hidden" name="rtro_note_cd">


<!-- OUTER - POPUP (S)tart -->
<table width="650" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; Retroactive RFA Note</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- 1 (S) -->
		<table class="search" id="mainTable"> 
       	<tr><td class="bg">	
				
				<!--  타이틀 시작 -->
				<table class="Search" border="0" style="width:100%;">
					<tr class="h23"><td>Attention !!!</td></tr>
					<tr class="h23"><td>Before approving this Retroactive RFA you are requested to check one of the following reasons.</td></tr>
				</table>								
				<table class="line_bluedot"><tr><td colspan="2"></td></tr></table>
				<!--  타이틀 끝 -->
					
				<!-- : ( Grid ) (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>		
				</table>
			
				<table class="grid2" border="0" style="width:100%;"> 
					<tr class="h23">
						<td width="65" class="tr2_head" >Remark(s)</td>
						<td class="noinput1"><textarea name="rtro_note_ctnt" style="width:100%;height:90; " class="textarea1"></textarea></td><!--  ime-mode:disabled; -->
					</tr>
				</table>
								
				<!-- : ( Grid ) (E) -->	             
                   
                </td></tr>
            </table>			<!-- Grid - 2 (S) -->

			<!-- Grid - 2 (E) -->	

			<!-- grid box (E) -->
			
			
		</td></tr>
		</table>			
		<!-- 1 (E) -->
		
<table class="height_5"><tr><td></td></tr></table>
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

    	<!--Button (S) -->	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				
				<td>
					<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_Save">Save</td>
							<td class="btn1_right"></td>
						</tr>
					</table>
				</td>	
				
				<td class="btn1_line"></td>		
			
				<td>
				    <table border="0" cellpadding="0" cellspacing="0">
				    <tr>
				    	<td>
				    		<table width="72 border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Close">Close</td>
								<td class="btn1_right"></td>
							</tr>
							</table>
						</td>
					</tr>
					</table>
				</td>	
			    <!--Button (E) -->
				
			</tr>
		</table>
<!-- : ( Button : pop ) (E) -->
		</td></tr>
		</table>
</td></tr>
</table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>