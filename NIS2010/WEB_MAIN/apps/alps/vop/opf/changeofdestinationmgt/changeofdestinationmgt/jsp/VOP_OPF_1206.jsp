<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_OPF_1206.jsp
*@FileTitle : Reject Reason Remarks
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.30
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.07.30 김종옥
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
<%@ page import="com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.event.VopOpf1206Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopOpf1206Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strIsPop			= "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.ChangeOfDestinationMgt.ChangeOfDestinationMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (VopOpf1206Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		strIsPop = event.getIsPop();
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Reject Reason Remarks</title>
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
<input type="hidden" name="isPop" value="<%=strIsPop%>">
<!-- 개발자 작업	-->
<!-- OUTER - POPUP (S)tart -->

<!-- OUTER - POPUP (S)tart -->
<table align="center" width="320" class="popup" style="background-color:#9999cc;"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
			<!-- : ( Title ) (S) -->
		<table width="100%" border="0" class="title" style="background-color:ffffff;">
		<tr><td class="title" style="padding-top:5;background-color:ffffff;"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;
        <%if (strIsPop.equals("C")){%>COD Remark<%}else if(strIsPop.equals("R")){%>Reject Reason Remarks<%}else if(strIsPop.equals("Q")){%>Quantity List<%}%>
		</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		<table class="search" style="width:318;border:1px solid #E8EFF9;" align="center"> 
       		<tr><td class="bg">
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="100%" align="center"><textarea style="width:98%" rows="5" name="rejectRmk" <%if (!strIsPop.equals("R")){%>readonly<%}%>></textarea></td>
				</tr>
				</table>
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
		<table class="height_5" style="background-color:#ffffff;width:100%"><tr><td></td></tr></table>
<!-- : ( Button : pop ) (S) -->
		<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;padding-bottom:10;"> 
   	<tr><td class="btn3_bg">
	    <table border="0" cellpadding="0" cellspacing="0">
	    	<tr>
<%if (strIsPop.equals("R")){%>		    
		    	<td width="">
		    		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_save">Save</td>
						<td class="btn1_right"></td>
						</tr>
					</table>
				</td>
<%}%>					
				<td width="">
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_close">Close</td>
						<td class="btn1_right"></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
   
	
	</td></tr>
</table>
</td></tr>
</table>
 <!--Button (E) -->
<!-- : ( Button : pop ) (E) -->



</td></tr>
</table> 


		













<!-- 개발자 작업  끝 -->
</form>
</body>
</html>