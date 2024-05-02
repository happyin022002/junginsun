<%
/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESD_SCE_0164.jsp
*@FileTitle : Copy E-mail sending option
*Open Issues :
*@LastModifyDate : 2012-05-21
*@LastModifier : Chae chang Ho
*@LastVersion : 1.0
* 1.0 최초 생성
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>

<%

	
	String dist = JSPUtil.getNull(request.getParameter("dist"));
    String cntr_no = JSPUtil.getNull(request.getParameter("cntr_no"));
    String cntr_count = JSPUtil.getNull(request.getParameter("cntr_count"));
    String snd_dt = JSPUtil.getNull(request.getParameter("search_dt"));
    String cntr_list = JSPUtil.getNull(request.getParameter("cntr_list"));
    String f_cmd = JSPUtil.getNull(request.getParameter("f_cmd"));
	
%>
<html>
<head>
<title>Welcome to enis!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">

    function setupPage(){
        loadPage();
    }

</script>
</head>
<body onLoad="setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="dist" value='<%=dist%>'>
<input type="hidden" name="cntr_list" value='<%=cntr_list%>'>
<input type="hidden" name="search_dt" value='<%=snd_dt%>'>
<input type="hidden" name="cntr_no" value='<%=cntr_no%>'>
<input type="hidden" name="cntr_count" value='<%=cntr_count%>'>

<!-- OUTER - POPUP (S)tart -->
<table width="500" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;Copy E-mail sending option</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">
					<table class="search" border="0" >
					<tr class="h23">
						  <td width="160">Orginal Container Number</td>
                          <td width="100"><input name="cntr_no_1" caption="CNTR NO" type="text" style="width:95;ime-mode:disabled; " class="input" value='<%=cntr_no%>' maxlength="11" disabled></td>
                          <td width="100">Number of Copy</td>
                          <td width="80"><input name="cntr_count" caption="count_no" type="text" style="width:60;ime-mode:disabled; " class="input" value='<%=cntr_count%>' maxlength="11" disabled ></td>
                    </tr>
					</table>

				</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->


		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Tab ) (E) -->

		<div id="tabLayer" style="display:inline">
		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
     	<table class="search" border="0">
			<tr>
				<td class="bg">
				    <table width="100%" id="mainTable">
                        <tr>
                        	<td>
                             	Please check original container number to copy its E-mail list.<br>
								The number is right, please click 'OK'<br>
								if the number is wrong, Please inert a correct number.
                        	</td>
                        </tr>
                    </table>
				<!-- : ( Speed ) (E) -->

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
        </div>
		<!-- ####### TABLE '#D' ::: 'RIGHT' FRAME (END) ####### -->


	</td></tr>
</table>
<!-- TABLE '#B' : 'Left + Right Body' Table (E)nd -->
<!-- ################# TABLE '#B' ::: 'LEFT + RIGHT' FRAME (END) ################## -->

</td></tr>

<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
		<tr><td height="71" class="popup">

			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
	       		<tr><td class="btn3_bg">
			    <table border="0" cellpadding="0" cellspacing="0">
			    <tr>

					<!-- Repeat Pattern -->
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_ok" id="btn_ok">Ok</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td>
						<table width="100%" class="search" border="0" cellpadding="0" cellspacing="0">
							<tr class="h23">
								<td width="120">&nbsp;&nbsp;Save as other no</td>
 								<td width="100"><input name="cntr_no1" caption="CNTR NO" type="text" style="width:98;ime-mode:disabled; " class="input" value="" maxlength="11"></td>	
					    	</tr>
					    </table>
					</td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
						<td>&nbsp;&nbsp;</td>
						<td class="btn1_left"></td>
						<td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table>
					</td>
					<!-- Repeat Pattern -->

				</tr>
			</table>

		</td></tr>
</table>

</form>
</body>
<%
	if(!f_cmd.equals("")){
	    Exception serverException = null;                     //서버에서 발생한 에러	
	    String strErrMsg = "";                                //에러메세지
	    String locCd = null;
	    try {
	        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
	        if (serverException != null) {
	            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
	        }
	       
	    }catch(Exception e) {
	        out.println(e.toString());
	    }		
%>
<script>
	  var opener = window.dialogArguments;
	  if("<%=strErrMsg%>" == ''){
	        ComShowMessage(ComGetMsg("SCE90058"));
			self.close();
		}

</script>

<%
	}
%>
</html>

