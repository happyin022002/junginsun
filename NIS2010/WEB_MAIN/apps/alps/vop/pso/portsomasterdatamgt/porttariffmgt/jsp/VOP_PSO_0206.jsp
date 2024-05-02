<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_PSO_0206.jsp
*@FileTitle : Service Provider Help
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 박명종
*@LastVersion : 1.0
* 2009.06.02 박명종
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.event.VopPso0206Event"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopPso0206Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_Ofc_cd      = "";
	String sheetIndex       = "";

	Logger log = Logger.getLogger("com.hanjin.apps.PortSOMasterDataMgt.PortTariffMgt");
	
	String sType = StringUtil.xssFilter(request.getParameter("type")) == null ? "B" : StringUtil.xssFilter(request.getParameter("type"));
	String sXml  = StringUtil.xssFilter(request.getParameter("sXml")) == null ? "" : StringUtil.xssFilter(request.getParameter("sXml"));
	String sCondNo = StringUtil.xssFilter(request.getParameter("cond_no")) == null ? "" : StringUtil.xssFilter(request.getParameter("cond_no"));
	String popTitle = StringUtil.xssFilter(request.getParameter("pop_title_0206")) == null ? "" : StringUtil.xssFilter(request.getParameter("pop_title_0206"));
	
	String title = "";
	
	if( sType.equals("B"))
		title = "Base Condition"; 
	else if(sType.equals("S"))
		title = "Surcharge Condition"; 	
	else if(sType.equals("D"))
		title = "Discount Condition"; 	
	
	String seq = StringUtil.xssFilter(request.getParameter("seq")) == null ? "10" : StringUtil.xssFilter(request.getParameter("seq"));
	sheetIndex = StringUtil.xssFilter(request.getParameter("sheetIndex")) == null ? "5" : StringUtil.xssFilter(request.getParameter("sheetIndex"));

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_Ofc_cd = account.getOfc_cd();
	   
		event = (VopPso0206Event)request.getAttribute("Event");
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
<title><%= popTitle%></title>
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
<form name="form" onKeyDown="ComKeyEnter()">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="type" value="<%=sType %>" >
<input type="hidden" name="seq" value="<%=seq %>" >
<input type="hidden" name="sheetIndex" value="<%=sheetIndex %>" >
<input type="hidden" name="sXml" value="<%=sXml %>" >
<input type="hidden" name="cond_no" value="<%=sCondNo %>" >



<!-- 개발자 작업	-->
<!-- OUTER - POPUP (S)tart -->
<table width="800" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">

	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><!--img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span--></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><!--span id="title"--> <%= popTitle%><!--/span--></td></tr>
		</table>
	<!--Page Title, Historical (E)-->	

		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			
		
			<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td  class="title_s"><%=title %></td></tr>
				</table>
			<!-- Grid  (S) -->
			<table width="100%" id="mainTable">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table>
			<!-- Grid (E) -->
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       			<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_RowAdd">Row&nbsp;Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Delete">Row&nbsp;Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						
					</tr></table>
			</td></tr>
			</table>
	    		<!-- Button_Sub (E) -->	
	    		
		</td></tr>
		</table>
		<!--biz page (E)--> 

</td></tr></table>

<table class="height_5"><tr><td></td></tr></table>
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

    	<!--Button (S) -->	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr>
			<td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
		    	<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_OK">OK</td>
					<td class="btn1_right">
				</tr>
			    </table>
			</td>	
		    	<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Close">Close</td>
					<td class="btn1_right">
				</tr>
			    </table>
			</td>	
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