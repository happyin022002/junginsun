<%--=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : CESD_SCE_108.jsp
*@FileTitle : Exception Reason 추가 및 Insert 방식 변경
*Open Issues :
*Change history : 
* 2008-07-07 Jeong-Seon An Exception Reason Table 참조
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2008-07-21 Hun-Il Jung
* 1.0 최초 생성
=========================================================--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.common.util.basic.CodeUtilBCImpl" %>
<%@ page import="com.hanjin.apps.alps.esd.sce.common.util.basic.CodeUtilBC" %>

<%
	CodeUtilBC codeUtil = new CodeUtilBCImpl() ;

	String dist  = JSPUtil.getNull(request.getParameter("dist"));
	String rsncd = JSPUtil.getNull(request.getParameter("rsncd"));    
	String insrtcd = JSPUtil.getNull(request.getParameter("insrtcd"));
    String rsnNames = codeUtil.searchCodeNameListString(dist,(dist.equals("expt_rsn_inq")?rsncd:insrtcd),"sce_expt_rsn_mst", "cop_expt_rsn_cd", "cop_expt_rsn_nm","");

    

%>

<html>
<head>
<%if (dist.equals("expt_rsn_inq")){ %>
<title>Exception Reason</title>
<%}else{%>
<title>Exception Reason Insert</title>
<% }%>	

</head>

<!-- 
showErrMessage를 써주지 않으면 에러 발생시 처리가 불가합니다.
그리고 지금은 showErrMessage()으로 되어있지만 추후에 고객님이 변덕을 일으켜서 웹페이지를 호출하라고 할경우를 
대비해서 직접 showErrMessage() 하지 마시고 꼭 showErrMessage를 써주십시오. 한방에 바꾸게요. 표준을 안따르면 나중에 후회합니다.  
-->

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" "> <!-- onload="javascript:setupPage(); -->
<form method="post" name="form" onSubmit="return false;">
<input    type="hidden" name="f_cmd"> 
<input type="hidden" name="dist" value='<%=dist%>'>

<!-- OUTER - POPUP (S)tart -->
<table width="800" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<%if (dist.equals("expt_rsn_inq")){ %>
		<tr><td height="79" class="title"><img src="/hanjin/img/alps/ico_t1.gif" width="20" height="12">Exception Reason</td></tr>
		<%}else{%>
		<tr><td height="79" class="title"><img src="/hanjin/img/alps/ico_t1.gif" width="20" height="12">Exception Reason Insert</td></tr>	
		<% }%>		
		</table>
		<!-- : ( Title ) (E) -->

		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button">
       	<tr><td class="align">

		   <table class="button">
			<tr><td><!--  <img class="cursor" src="/hanjin/img/alps/button/btn_retrieve.gif" width="66" height="20" border="0" name="btn_retrieve">--></td>
				<td><!--  <img class="cursor" src="/hanjin/img/alps/button/btn_new.gif" width="66" height="20" border="0" name="btn_new">--></td>
			</table>

		</td></tr>
		</table>
    	<!-- TABLE '#D' : ( Button : Main ) (E) -->

		<!-- TABLE '#D' : ( Search Options : Scenario ID ) (S) -->
		<table class="search">
			<tr>
				<td class="bg_a">


				<!-- : ( Scenario ID ) (S) -->
				<table class="search" border="0" style="width:100%;">
				<tr class="h23">
				<%if (dist.equals("expt_rsn_inq")){ %>
                <%=rsnNames%>     
					
				<%}else{ %>
                <%=rsnNames%>     

				<% }%>	

				</table>
				<!-- : ( Scenario ID ) (E) -->

			</tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : Scenario ID ) (E) -->

		<table class="height_15"><tr><td></td></tr></table>






</td></tr>
</table>
<!-- OUTER - POPUP (E)nd -->



<table class="height_10"><tr><td></td></tr></table>


<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
		<tr><td height="71" class="popup">

			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
	       		<tr><td class="btn3_bg">
			    <table border="0" cellpadding="0" cellspacing="0">
			    <tr>

					<!-- Repeat Pattern -->
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_ok" id="btn_ok">Ok</td><td class="btn1_right"></td></tr></table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new">New</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->

				</tr>
			</table>

		</td></tr>
</table>
<!-- : ( Button : Sub ) (E) -->


</form>
</body>
</html>



<%@include file="../../../common/commonpopup/include/common.jsp"%>


