<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_PSO_0209.jsp
*@FileTitle : Search Formula & Condition ID
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 박명종
*@LastVersion : 1.0
* 2009.07.06 박명종
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.event.VopPso0209Event"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopPso0209Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_Ofc_cd      = "";
	
	String strTerminalList = "";
	String strAccountList = "";
	String strObjList = "";
	String formcond = "";
	String caller = "";	//쌀집에서 호출하면

	Logger log = Logger.getLogger("com.hanjin.apps.PortSOMasterDataMgt.PortTariffMgt");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_Ofc_cd = account.getOfc_cd();
	   
		event = (VopPso0209Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		formcond = StringUtil.xssFilter(request.getParameter("formcond")) == null ? "1" : StringUtil.xssFilter(request.getParameter("formcond"));
		caller = StringUtil.xssFilter(request.getParameter("caller")) == null ? "" : StringUtil.xssFilter(request.getParameter("caller"));

		if (serverException != null) {
	strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
//		strTerminalList = eventResponse.getETCData("lane");
//		strAccountList  = eventResponse.getETCData("account");
		strObjList  	= eventResponse.getETCData("objlist");
		
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Search Formula & Condition ID</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		TerminalList = "<%=strTerminalList%>";
		AccountList  = "<%=strAccountList%>";
		ObjList      = "<%=strObjList %>";
		
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body class="popup_bg" onLoad="setupPage();">
<form name="form" onKeyDown="ComKeyEnter()">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="sXml">
<input type="hidden" name="id_tp" value="<%=formcond.equals("1") ? "F" : "C" %>">
<input type="hidden" name="caller" value="<%=caller %>">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Search Formula & Condition ID</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
				<!--  biz_1  (S) -->
				
				<!--  biz_1  (S) -->
				
				<table class="search" border="0" style="width:100%;"> 
					<tr class="h23">
						<td width="220" rowspan="2">
							<table class="search_sm2" border="0" style="width:200;"> 
								<tr class="h23">
									<td><input name=formcond type="radio" value="1" class="trans" <%=formcond.equals("1") ? "checked" : "disabled" %> >Formula&nbsp;&nbsp;&nbsp;&nbsp;
									<input name=formCond type="radio" value="2" class="trans"  <%=formcond.equals("2") ? "checked" : "disabled" %> >Condition</td>
								</tr>
							</table>
						</td>
						<td width="80">ID No.</td>
						<td width="120"><script language="javascript">ComComboObject('combo1',1,90,0);</script></td>
						<td width="90">Created by ID</td>
						<td width=""><input name="cre_usr" type="text"  style="width:140;ime-mode:disabled;text-align:left" class="input0" value=""></td>
					</tr>
					<tr class="h23">
						<td width="">Charge Type</td>
						<td width=""><script language="javascript">ComComboObject('combo2',1,90,1);</script></td>
						<td width="90">Object</td>
						<td width="" style="padding-left:2"><script language="javascript">ComComboObject('combo3',2,140,0);</script></td>
					</tr>
				</table>
				<!--  biz_1   (E) -->
				
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table> 			
			<!-- Grid (E) -->	
			
			
		</td></tr>
		</table>
		<!--biz page (E)--> 

<table class="height_5"><tr><td></td></tr></table>

</td></tr></table>
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

    	<!--Button (S) -->	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr>
			<td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right">
				</tr></table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_OK">Ok</td>
					<td class="btn1_right">
				</tr></table></td>
				<td class="btn1_line">
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
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

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
<%@include file="/bizcommon/include/common_nis2010.jsp"%>