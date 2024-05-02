<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_POPUP_TITLE.jsp
*@FileTitle : ESM_BKG_POPUP_TITLE
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.19
*@LastModifier : KIM TAE KYOUNG
*@LastVersion : 1.0
* 2010.02.19 KIM TAE KYOUNG
* 1.0 Creation	
=========================================================*/

%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%
String mainPage = JSPUtil.getNull(request.getParameter("main_page"));
%>
<%
	if(mainPage.equals("true")){
%>

<table width="100%" border="0" cellpadding="0" cellspacinng="0"  style="padding-top: 2; padding-left: 5; padding-right:5;">
		<tr>
			<td valign="top">
					<!--Page Title, Historical (S)-->
					<table width="100%" border="0" cellpadding="0" cellspacing="0"	   class="title">
						<tr>
							<td class="history"><img src="img/icon_history_dot.gif"
													 align="absmiddle"><span id="navigation"></span></td>
						</tr>
						<tr>
							<td class="title"><img src="img/icon_title_dot.gif"
												   align="absmiddle"><span id="title"></span></td>
						</tr>
					  </table>
					  <!--Page Title, Historical (E)--> <!-- Grid BG Box  (S) -->
				
<%
}else {
%>					  												   
		<table width="100%" class="popup" cellpadding="10" border="0"> 
			<tr><td class="top"></td></tr>
			<tr>
				<td valign="top">
					<table width="100%" border="0">
					<tr><td height="79" class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;<span id="title"></span></td></tr>
					</table>
				
<%
}
%>          												   													 

	