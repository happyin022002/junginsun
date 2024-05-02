<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0058.jsp
*@FileTitle : Filing Eff. Date Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.07.10 공백진
* 1.0 Creation
* 2014.05.28 전윤주 [CHM-201430580] FMC 자동 filing 기능 추가
* 2014.09.17 송호진 [CHM-201430558] FMC Auto-filing 개발 요청
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.event.EsmPri0058Event"%>
<%@ page import="com.hanjin.syscommon.common.table.PriSpHdrVO"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmPri0058Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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
	String amdtSeq = "";
	String ctrtEffDt = "";
	String ctrtExpDt = "";
	String sc_no = "";
	String scNo1 = "";
	String scNo2 = "";
	String sCurrEffDt ="";
	String sSlsLdNo = "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   	   
		event = (EsmPri0058Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");		
		
		propNo = request.getParameter("sPropNo");
		amdtSeq = request.getParameter("amdt_seq");
		ctrtExpDt = request.getParameter("sCtrtExpDt");
		ctrtEffDt = request.getParameter("sCtrtEffDt");		
		sCurrEffDt = request.getParameter("sEffDt");	
		sSlsLdNo = request.getParameter("sSlsLdNo");
		sc_no = request.getParameter("sSc_No");
		if (sc_no != null && sc_no !="" && sc_no.length() >= 3){
			scNo1 = sc_no.substring(0,3);
			scNo2 = sc_no.substring(3,sc_no.length());
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Filing Eff. Date Creation</title>
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
<input type="hidden" name="amdt_seq" value="<%=amdtSeq%>" >
<input type="hidden" name="curr_eff_dt" value="<%=sCurrEffDt%>" >
<input type="hidden" name="change_dt" value="N" >
<input type="hidden" name="sls_ld_no" value="<%=sSlsLdNo%>" >
<input type="hidden" name="eff_dt_chg">
<input type="hidden" name="fmc_file_tp_cd">
<input type="hidden" name="sc_no" value="<%=sc_no%>" >
<input type="hidden" name="backendjob_key"> 
<input type="hidden" name="job_status"> 

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Filing Eff. Date Creation
</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
				<table class="search" border="0" style="width:700;"> 
				<tr class="h23">
					<td width="50">S/C No.</td>
					<td width="110">
					<input type="text"  name="scno1"  style="width:30;" class="input2" value="<%=scNo1%>">&nbsp;
					<input type="text" name="scno2"  style="width:60;" class="input2" value="<%=scNo2%>"></td>
					<td width="80">Proposal No.</td>
					<td width="100"><input type="text" name="prop_no" style="width:80;" class="input2" value="<%=propNo %>"></td>
					
					<td width="60">Duration</td>
					<td colspan="2">
					<input type="text" name="ctrt_eff_dt" style="width:70;" class="input2" value="<%=ctrtEffDt %>">&nbsp;<img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">&nbsp;~&nbsp;
					<input type="text" name="ctrt_exp_dt" style="width:70;" class="input2" value="<%=ctrtExpDt %>">&nbsp;<img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td></tr>
				</tr>
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
				
				
				<!-- : ( Button : Grid ) (S) -->
				<!--  Button_Sub (S) -->
			
	    	<!-- Button_Sub (E) -->
		    <!-- : ( Button : Grid ) (E) -->	
			
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
</td></tr>
</table> 

<table class="height_5"><tr><td></td></tr></table>
	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton"  height="20" >
<tr><td class="popup">	
		<table width="100%" class="search" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr class="h23" >
       	    <td width="300"><img src="/hanjin/img/ico_star.gif" border=0/><font size="1"><strong>Remark</strong></font></td>
       	    
       	    <td class="btn3_bg" rowspan="2" style="text-align:left">
		    <table border="0" cellpadding="0" cellspacing="0" >
			    <tr><td width="130">
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_sendFMC">FMC Auto-file</td>
						<td class="btn1_right"></td>					
						</tr>
					</table>
					</td>
					
					<td width="72">
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_correction"><img src="/hanjin/img/ico_star.gif" border=0/>C/T</td>
						<td class="btn1_right"></td>					
						</tr>
					</table>
					</td>			    
			    
			    	<td width="72">
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_save">Save</td>
						<td class="btn1_right"></td>					
						</tr>
					</table>
					</td>
					<td class="btn1_line"></td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_close">Close</td>
						<td class="btn1_right"></td>
						</tr>
						</table>
					</td></tr>
			</table>
		</td></tr>
		<tr class="h23" ><td class="sm">&nbsp;
			<img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" border="0" vspace="4"><font size="1">C/T:Correction Transmission within 48 hours after initial filing.</font><br>
			</td>
			
		</tr>

		</table>
	</td></tr>
</table>
			
    <!--Button (E) -->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>