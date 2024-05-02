<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CPS_CNI_0305.jsp
*@FileTitle : Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.10.12 윤세영
* 1.0 Creation
=========================================================*/%>

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

	String strUsr_id		= "";
	String strUsr_nm		= "";

	Logger log = Logger.getLogger("com.hanjin.apps.DryWetClaim.DryWetClaim");

    String pop_flag = JSPUtil.getNull(request.getParameter("pop_flag"));
    String pop_title = JSPUtil.getNull(request.getParameter("pop_title"));
    String pop_desc = JSPUtil.getNull(request.getParameter("pop_desc"));
    String pop_cont_col = JSPUtil.getNull(request.getParameter("pop_cont_col"));
    String pop_cont = JSPUtil.getNull(request.getParameter(pop_cont_col));
    String dw_clm_no = JSPUtil.getNull(request.getParameter("dw_clm_no"));
    String dw_clm_tp_cd = JSPUtil.getNull(request.getParameter("dw_clm_tp_cd"));
    String dw_co_cd = JSPUtil.getNull(request.getParameter("dw_co_cd"));

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		//GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>DWC Detail</title>
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

<body  onLoad="setupPage();" class="popup_bg">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="pop_cont_col" value="<%=pop_cont_col%>">
<input type="hidden" name="pop_cont_hidden" value="<%=pop_cont%>">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;DWC Detail</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
<table class="search" id="mainTable"> 
    <tr><td class="bg">	
			<table class="search" border="0" style="width:100%;"> 
			<tr class="h23">
				<td width="85">&nbsp;&nbsp;Case No.</td>
				<td width="190"><input type="text" name="dw_clm_no" readonly style="width:100;" value="<%=dw_clm_no%>" class="input2"></td>
				<td width="31">&nbsp;&nbsp;TOC</td>
				<td width="140"><input type="text" name="dw_clm_tp_cd" readonly style="width:50;" value="<%=dw_clm_tp_cd%>" class="input2"></td>
				<td width="76">&nbsp;&nbsp;Company</td>
				<td width="420"><input type="text" name="dw_co_cd" readonly style="width:50;" value="<%=dw_co_cd%>" class="input2"></td>
			</tr>
			<tr class="h23">
				<%
					if (pop_flag.equals("TAB")) {
				%>
				<td colspan="6">&nbsp;&nbsp;<%=pop_title%></td>
				<%
					} else {
				%>
				<td>&nbsp;&nbsp;<%=pop_title%></td>
				<td colspan="5">
				<input type="text" name="pop_desc" readonly style="width:100%;" value="<%=pop_desc%>" class="input2">
				</td>
				<%
					}
				%>
			</tr>
			<tr class="h23">
				<td width="" colspan="6"><textarea name="contents" caption="Contents" value="<%=pop_cont%>" style="width:100%" rows="30"></textarea></td>
			</tr>
			</table> 
				
			
		
	</td>
	</tr></table> 

<table class="height_5"><tr><td></td></tr></table>

</td></tr>
</table> 
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_confirm">Save</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
	
</form>
</body>
</html>