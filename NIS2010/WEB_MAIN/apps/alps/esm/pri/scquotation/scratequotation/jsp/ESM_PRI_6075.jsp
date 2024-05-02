<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_6075.jsp
*@FileTitle : SC CM/OP View All
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.07.17 송민석
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
<%@ page import="com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.event.EsmPri6075Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri6075Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String qttn_no		= null;
	String qttn_ver_no		= null;
	String cost_tp = null;
	String qttn_sts_cd = null;
	String auth_code = null;
	
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.SCProposal.SCRateProposal");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		qttn_no		= JSPUtil.getParameter(request,"qttn_no");
		qttn_ver_no		= JSPUtil.getParameter(request,"qttn_ver_no");
		cost_tp = JSPUtil.getParameter(request,"cost_tp");
		qttn_sts_cd = JSPUtil.getParameter(request,"qttn_sts_cd");
		auth_code = JSPUtil.getParameter(request,"auth_code");

		event = (EsmPri6075Event)request.getAttribute("Event");
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
<title>S/C CM/OP View All</title>
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
<input type="hidden" name="qttn_no" value="<%=qttn_no%>">
<input type="hidden" name="qttn_ver_no" value="<%=qttn_ver_no%>">
<input type="hidden" name="cost_tp" value="<%=cost_tp%>">
<input type="hidden" name="qttn_sts_cd" value="<%=qttn_sts_cd%>">
<input type="hidden" name="auth_code" value="<%=auth_code%>">



<!-- OUTER - POPUP (S)tart -->
<table width="1000" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title" ><img src="img/icon_title_dot.gif" align="absmiddle" >&nbsp;<span id="titletext"></span></td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
			
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="360">
						<table class="search_sm2" border="0" style="width:340;"> 
							<tr class="h23">
								<td width="70">&nbsp;Rate Type</td>
								<td class="stm"><input type="radio" name="rate_type" value="B" class="trans" >Both&nbsp;&nbsp;&nbsp;<input type="radio" name="rate_type" value="G" class="trans">General Rate&nbsp;&nbsp;&nbsp;<input type="radio" name="rate_type" value="S" class="trans">Special Rate</td>
							</tr>	
						</table>
					</td>
					<td width="230">
						<table class="search_sm2" border="0" style="width:200;"> 
							<tr class="h23">
								<td width="80">&nbsp;PFMC Unit</td>
								<td class="stm"><input type="radio" value="FEU" name="pfmc_unit" class="trans" checked>FEU&nbsp;&nbsp;&nbsp;<input type="radio" value="TEU" name="pfmc_unit" class="trans">TEU</td>
							</tr>	
						</table>
					</td>
				<td align="right" class="sm">[Unit: USD]</td>
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
				<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>									
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_Retrieve">Retrieve</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_Save">Save</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_DownExcel">Down Excel </td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>							
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			
		
			
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="60" valign="TOP">Remark</td>
					<td class="SM" ><span id="remarktext"></span></td>
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