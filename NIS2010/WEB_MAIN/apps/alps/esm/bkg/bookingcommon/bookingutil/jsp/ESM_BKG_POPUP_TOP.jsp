<%

	String mainPage = JSPUtil.getNull(request.getParameter("mainPage"));
%>
<% 
if(mainPage.equals("true")){
%>


<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top: 2; padding-left: 5; padding-right:5;" >
            
                <tr>
                    <td valign="top">
                        <!--Page Title, Historical (S)-->
                        <table width="100%" border="0" cellpadding="0" cellspacing="0"
                               class="title">
                            <tr>
                                <td class="history"><img src="img/icon_history_dot.gif"  align="absmiddle"><span id="navigation"></span></td>
                            </tr>
                            <tr>
                                <td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td>
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