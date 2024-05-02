<%--
/*=========================================================
*Copyright(c) 2009 CyberLogitec 
*@FileName : ESD_EAS_0362.jsp
*@FileTitle : M&R Pre-Audit Criterion By Error Code
*Open Issues :
*Change history :
*@LastModifyDate : 2015-05-08
*@LastModifier : YulKyu Lee
*@LastVersion : 1.0
* 1.0 최초 생성 
-------------------------------------------------------------------
* History

=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.eas.mnradvanceaudit.event.EsdEas0360Event"%>
<%
	String strUsr_id = "";
	String strOfcCd = "";
	String strRhqOfcCd = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	strUsr_id = account.getUsr_id();
		strOfcCd = account.getOfc_cd();
		strRhqOfcCd = account.getRhq_ofc_cd();
	
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>M&R Pre-Audit Criterion By Error Code</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		loadPage();
	}
</script>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="code_key">
<input type="hidden" name="s_mnr_code_type">
<input type="hidden" name="login_usr_id" value="<%=strUsr_id%>">
<input type="hidden" name="ofc_cd"		 value="<%=strOfcCd%>">
<input type="hidden" name="ofclevel">
<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>
			<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
				</table>
			<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->

			<!-- TABLE '#D' : ( Button : Main ) (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr><td class="btn1_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new">New</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_save" id="btn_save">Save</td><td class="btn1_right"></td></tr></table></td>
							<td class="btn1_line"></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
							<!-- Repeat Pattern -->
						</tr></table>
				</td></tr>
			</table>
			<!-- TABLE '#D' : ( Button : Main ) (E) -->

			<!-- TABLE '#D' : ( Search Options ) (S) -->
	     	<table width="100%" class="search" border="0">
	       	<tr>
	       		<td class="bg">
						<!-- : ( Week ) (S) -->
							<!-- [1]--------------------------------------------------------- -->
							<table class="search_in" border="0">
								<tr class="h23">
									<td width="50">RHQ</td>
									<td width="200" style="padding-left:2"><script language="javascript">ComComboObject('s_rhq_ofc_cd',1,80,1,0);</script>
									</td>
									<td width="50">Office</td>
									<td width="240" style="padding-left:2"><script language="javascript">ComComboObject('s_ofc_cd',1,80,0,0);</script>
									</td>
									<td width="50">Type</td>
									<td width="240" style="padding-left:2"><script language="javascript">ComComboObject('s_type',1,100,0,0);</script>
									</td>
									<td width="200"><input type="checkbox" id="s_set_data_only" name="s_set_data_only"  maxlength="6" style="width:20;text-align:center;ime-mode:disabled;border=0;" class="checkbox" value="1" border="0px">Set Data Only</td>
									</td>
								</tr>								
							</table>
						<!-- : ( Week ) (E) -->
						</td>
					</tr>
				</table>
				<!-- TABLE '#D' : ( Search Options ) (E) -->			

			<table class="height_10"><tr><td></td></tr></table>

			<!-- TABLE '#D' : ( Grid ) (S) -->
	     	<table class="search">
	       		<tr><td class="bg">
					<!-- <table class="height_10"><tr><td></td></tr></table> -->
					<!-- : ( POR ) (S) -->
					<table width="100%" id="mainTable">
			              <tr><td>
			                     <script language="javascript">ComSheetObject('sheet1');</script>
			              </td></tr>
					</table>
					<!-- : ( POR ) (E) -->

					<!-- : ( Button : Grid ) (S) -->
					<table width="100%" class="button">
						<tr><td class="btn2_bg">
							<table border="0" cellpadding="0" cellspacing="0">
								<tr class="h23">

								<!-- Repeat Pattern -->
								<td width="75">Office Code:</td><td width="100"><input type="text" name="i_ofc_cd"  style="width:80; ime-mode:inactive;"  class="input"  maxlength="6" dataformat="engup" onchange="javascript:setgetUpper(this)"></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btn_add_office" id="btn_add_office">Add Office</td>
								<td class="btn2_right"></td></tr></table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btn_delete_office" id="btn_delete_office">Delete Office</td>
								<td class="btn2_right"></td>
								</tr></table></td>
								<!-- Repeat Pattern -->

								</tr>
							</table>
						</td></tr>
					</table>
			    	<!-- : ( Button : Grid ) (E) -->

				</td></tr>
			</table>
			<!-- TABLE '#D' : ( Grid ) (E) -->

    </td></tr>
</table>
<table width="100%" style="display:none"> 
	<tr>
		<td width="100%">
			<script language="javascript">ComSheetObject('sheet2');</script>
		</td>
	</tr>
</table> 
<!-- Outer Table (E)-->

</form>
</body>
</html>