<%
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_PRI_6090.jsp
*@FileTitle : SC Proposal MQC estimate
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.10
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.05.10 송민석
* 1.0 Creation 
*=========================================================
* History :
* 2012.04.18 이석준[CHM-201217045-01] S/C Filed Cancel 기능및 조회 기능 추가
* 2013.01.21 이은섭[CHM-201322418-01] S/C 의 "Flied Cancel" 기능 관련 변경 - Approval staff 정보 읽어와서 저장
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.event.EsmPri6090Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri6090Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag      = "";
	String codeList         = "";
	String pageRows         = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String frm_sc_no = "";
	String frm_prop_no = "";
	String frm_amdt_seq = "";
	String frm_upd_dt = "";
	String frm_prop_apro_ofc_cd = "";
	String frm_prop_apro_staff_id = "";
		
	Logger log = Logger.getLogger("com.hanjin.apps.SCProposal.SCProposalMain");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri6090Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	 
		frm_prop_no          = JSPUtil.getParameter(request,"frm_prop_no");   
		frm_amdt_seq		 = JSPUtil.getParameter(request,"frm_amdt_seq");
		frm_sc_no            = JSPUtil.getParameter(request,"frm_sc_no");
		frm_upd_dt           = JSPUtil.getParameter(request,"upd_dt");
		frm_prop_apro_ofc_cd           = JSPUtil.getParameter(request,"prop_apro_ofc_cd");
		frm_prop_apro_staff_id           = JSPUtil.getParameter(request,"prop_apro_staff_id");
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>S/C Filed Cancel</title>
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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->

<input type="hidden" name="frm_prop_no"	  value = "<%=frm_prop_no%>">  
<input type="hidden" name="frm_amdt_seq"  value = "<%=frm_amdt_seq%>">      
<input type="hidden" name="frm_sc_no"     value = "<%=frm_sc_no%>">
<input type="hidden" name="frm_upd_dt"    value = "<%=frm_upd_dt%>">
<input type="hidden" name="in_usr_id"     value = "<%=strUsr_id%>"> 
<input type="hidden" name="in_usr_nm"     value = "<%=strUsr_nm%>">  
<input type="hidden" name="frm_prop_apro_ofc_cd"     value = "<%=frm_prop_apro_ofc_cd%>">  
<input type="hidden" name="frm_prop_apro_staff_id"     value = "<%=frm_prop_apro_staff_id%>">  

    <!-- OUTER - POPUP (S)tart -->
    <table width="100%" class="popup" cellpadding="10" border="0"> 
    <tr><td class="top"></td></tr>
    <tr><td valign="top">
    	
    		<!-- : ( Title ) (S) -->
    		<table width="100%" border="0">
    		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;S/C Filed Cancel</td>
    		</tr>
    		</table>
    		<!-- : ( Title ) (E) -->
    		
    		<!-- : ( Search Options ) (S) -->
     
    			<table class="search"> 
           		<tr><td class="bg">	
    			
    				<table class="search" border="0">
    				<tr> 
    					
    	 
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

    	</td></tr>
    		</table>
    <!-- : ( Button : pop ) (S) -->


    <table class="height_5"><tr><td></td></tr></table>

    <!-- : ( Button : pop ) (S) -->
    <table width="100%" class="sbutton">
    <tr><td height="71" class="popup">
    	
    		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
           	<tr><td class="btn3_bg">
    		    <table border="0" cellpadding="0" cellspacing="0">
    		    <tr>
    				
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn1_filed_cancel">Filed Cancel</td>
						<td class="btn1_right"></td></tr></table></td>
						
					<td class="btn1_line"></td>    				
    				
    				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
    					<tr><td class="btn1_left"></td>
    					<td class="btn1" name="btn1_Close">Close</td>
    					<td class="btn1_right"></td>
    					</table>
    			</td>
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