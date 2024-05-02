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

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String frm_prop_mqc_qty = "";
	String frm_prop_no = "";
	String frm_amdt_seq = "";
	String frm_cntr_lod_ut_cd = "";
	String frm_cntr_lod_ut_text = "";
	String is_req_usr = "";
	String is_apro_usr = "";
	String prc_prop_sts_cd = "";
	
	
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
		frm_amdt_seq		=  JSPUtil.getParameter(request,"frm_amdt_seq");
		frm_prop_mqc_qty = JSPUtil.getParameter(request,"frm_prop_mqc_qty");
		frm_cntr_lod_ut_cd = JSPUtil.getParameter(request,"frm_cntr_lod_ut_cd");
		frm_cntr_lod_ut_text = JSPUtil.getParameter(request,"frm_cntr_lod_ut_text");
		is_req_usr = JSPUtil.getParameter(request,"is_req_usr");
		is_apro_usr = JSPUtil.getParameter(request,"is_apro_usr");
		prc_prop_sts_cd = JSPUtil.getParameter(request,"prc_prop_sts_cd");
		
			
 

		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>SC Proposal MQC estimate</title>
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

<input type="hidden" name="frm_prop_mqc_qty" value="<%=frm_prop_mqc_qty %>">
<input type="hidden" name="frm_cntr_lod_ut_cd"	  value = "<%=frm_cntr_lod_ut_cd%>">  
<input type="hidden" name="frm_cntr_lod_ut_text"  value = "<%=frm_cntr_lod_ut_text%>">
<input type="hidden" name="is_req_usr"  value = "<%=is_req_usr%>">  
<input type="hidden" name="is_apro_usr"  value = "<%=is_apro_usr%>">
<input type="hidden" name="prc_prop_sts_cd"  value = "<%=prc_prop_sts_cd%>">      
 

    <!-- OUTER - POPUP (S)tart -->
    <table width="500" class="popup" cellpadding="10" border="0"> 
    <tr><td class="top"></td></tr>
    <tr><td valign="top">
    	
    		<!-- : ( Title ) (S) -->
    		<table width="100%" border="0">
    		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;MQC estimate(PRS purpose only)</td>
    		</tr>
    		</table>
    		<!-- : ( Title ) (E) -->
    		
    		<!-- : ( Search Options ) (S) -->
     
    			<table class="search"> 
           		<tr><td class="bg">
           		
				<table class="search_sm2" border="0" style="width:400;"> 
							<tr class="h23">
								<td width="100">&nbsp;Proposal No.</td>
								<td class="stm"  width="110"><input type="text" value="<%=frm_prop_no%>" style="width: 80; text-align: left;" class="input2" readonly></td>
								<td width="40">&nbsp;MQC</td>
								<td class="stm"><input type="text" value="<%=frm_prop_mqc_qty%>" style="width: 80; text-align: right" class="input2" readonly>
									<input type="text" value="<%=frm_cntr_lod_ut_text%>" style="width: 30; text-align: center" class="input2" readonly></td>
							</tr>
				</table>
				           		
    			
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
    				
    			
    		
    			
    				<table class="search" border="0" style="width:100%;"> 
    				<tr class="h23">
    					<td width="80" valign="TOP">Remark(s)</td>
    					<td class="SM">&raquo; Please input estimated MQC data in order to have more accurate<BR>
    					 &nbsp;&nbsp;&nbsp;CM/OP data through PRS calculation<br>
    &raquo; Once you input estimated MQC on the pop-up screen,<BR> 
    &nbsp;&nbsp;&nbsp;please click [OK] to proceed calculation .<BR>
    &raquo; Please keep in mind that inputted MQC data is not reflected on contract.
    </td>
    				</tr>	
    				</table>
    					
    			
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
						<td class="btn1" name="btn1_OK">OK</td>
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