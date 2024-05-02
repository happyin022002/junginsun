<%/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESD_SCE_0156.jsp
*@FileTitle : SCE
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.25
*@LastModifier : 이수진
*@LastVersion : 1.0
* 2011.07.25 이수진
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.dwellnotification.event.EsdSce0152Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	String emlSndDt = request.getParameter("eml_snd_dt");
	String custCd = request.getParameter("cust_cd");
	String dwllTp = request.getParameter("dwll_tp");
%>

<html>
<head>
<title>Dwell Notification Email</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script> 

<script language="javascript">
	function setupPage() {
		loadPage();
	}
</script>
</head>

<body  class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="eml_snd_dt_param" value='<%=emlSndDt%>'>
<input type="hidden" name="cust_cd_param" value='<%=custCd%>'>
<input type="hidden" name="dwll_tp_param" value='<%=dwllTp%>'>
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0">
  <tr>
    <td class="top"></td>
  </tr>
  <tr>
    <td valign="top"><!-- : ( Title ) (S) -->
      <!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<table class="search"><tr><td class="height_10"></td></tr></table>

				<!-- TABLE '#E' : ( Graph BG ) (S) -->
		     	<table border="1" style="width:100%;" height="700" class="grid" >
		       	<tr><td>
					<script language='javascript'>comRdObject('dwll_report');</script>
					</td></tr>
				</table>
				<!-- TABLE '#E' : ( Graph BG ) (E) -->
			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->
      <!-- : ( Search Options ) (E) --></td>
  </tr>
</table>
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
  <tr>
    <td height="71" class="popup"><table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
        <tr>
          <td class="btn3_bg"><table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td width="72"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_close">Close</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table></td>
              </tr>
            </table></td>
        </tr>
      </table>
      <!--Button (E) --></td>
  </tr>
</table>
<!-- : ( Button : pop ) (E) -->

</form>

</body>
</html>
