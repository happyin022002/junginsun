<!--%/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_028.jsp
*@FileTitle : Cost Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-05
*@LastModifier : jongbaemoon
*@LastVersion : 1.0
* 2006-09-05 jongbaemoon
* 1.0 최초 생성
=========================================================*%-->
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.tes.codemanage.codemanage.event.EsdTes0028Event"%>
<%
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";								 //에러메세지
	
	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
	
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	} catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Cost Code Inquiry</title>
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
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="lgs_cost_subj_cd1">
<input type="hidden" name="lgs_cost_dtl_cd1">
<input type="hidden" name="command_h">

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
							<!-- Repeat Pattern -->

						</tr></table>

				</td></tr>
		</table>
    	<!-- TABLE '#D' : ( Button : Main ) (E) -->




		<!-- TABLE '#D' : ( Search Options :  ) (S) -->
     	<table class="search">
       	<tr><td class="bg">
				<!-- : ( Week ) (S) -->
				<table class="search_in" border="0">

				<tr class="h23">
					<td width="100"><img class="nostar">Subject Code</td>
					<td width="200"><!--<select style="width:150;">
						<option value="0" selected>SV</option>
						</select>--><script language="javascript">ComComboObject('lgs_cost_subj_cd',1, 90 , 0, 1)</script></td>
					<td width="80">Detail Code</td>
					<td width=""><!--<select style="width:150;">
						<option value="0" selected>SVLD</option>
						</select>--><script language="javascript">ComComboObject('lgs_cost_dtl_cd',1, 90 , 0 )</script></td></tr>
				</table>
				<!-- : ( Week ) (E) -->


			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : ) (E) -->
		<table class="height_10"><tr><td></td></tr></table>


		<!-- TABLE '#D' : ( Search Options : Detail Explanation ) (S) -->
     	<table class="search">
       		<tr><td class="bg">


				<!-- : ( From Location ) (S) -->
					<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet1');</script>
                        </td></tr>
		            </table>
				<!-- : ( From Location ) (E) -->



			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : Detail Explanation) (E) -->



		<table class="height_10"><tr><td></td></tr></table>


		<!-- TABLE '#D' : ( Search Options : Detail Explanation ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<!-- : ( Detail Explanation ) (S) -->
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Detail Explanation</td></tr>
				<tr><td class="height_5"></td></tr>
				</table>

				<table border="0" style="width:975;" class="search">
				<tr>
					<td><input type="radio" name="del_flg_y" value="" disabled class="trans">Live&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="del_flg_n" disabled class="trans">Delete</td></tr>
				<tr>
					<td><textarea name="txtEvent" style="width:975; height:100;" readonly></textarea>
					</td></tr>
				</table>
				<!-- : ( Detail Explanation ) (E) -->




			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : Detail Explanation) (E) -->

</td></tr>
</table>
<!-- Outer Table (E)-->

</form>
</body>
</html>
<DIV style="display:none">
				<!-- : ( From Location ) (S) -->
					<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet2');</script>
                        </td></tr>
		            </table>
				<!-- : ( From Location ) (E) -->
</DIV>				