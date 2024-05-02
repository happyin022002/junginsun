<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_COA_9001.jsp
*@FileTitle :Week Copy
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion :
* 2014-06-18 CHOI DUK WOO 
* 1.0 최초 생성 
=============================================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="java.util.Enumeration"%>
<%
	Exception serverException   = null;				//서버에서 발생한 에러
	String strErrMsg = "";							//에러메세지
	String classId = "";
	String rlaneCd = "";
	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		classId = request.getParameter("classId");			
		rlaneCd = request.getParameter("rlane_cd");
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
		} // end else
			
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Month Copy </title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		var formObj = document.form;

		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if

		loadPage();


	}
</script>
</head>
<iframe height="0" width="0" name="frmHidden"></iframe>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onKeyDown="ComKeyEnter();">
<input	type="hidden" name="f_cmd">
<input	type="hidden" name="f_class_id" value="<%=classId%>">
<input	type="hidden" name="rlane_cd" value="<%=rlaneCd%>">
<input	type="hidden" name="f_cost_use_tp_cd">
<input type="hidden" name="backendjob_key">

<!-- OUTER - POPUP (S)tart -->
<table width="580" class="popup" cellpadding="10">
	<tr><td class="top"></td></tr>
	<tr><td valign="top">

		<!-- : ( Title ) (S) -->
        <table width="100%" border="0">
            <tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp; Week Copy</td></tr>
        </table>
        <!-- : ( Title ) (E) -->

		<table width="200"  border="0" cellpadding="0" cellspacing="0">
		<tr>
		<td class="bodyleft"></td>
		<td class="bodyright">
		<!-- ####### TABLE '#D' ::: 'RIGHT' FRAME (START) ####### -->


		<!-- : ( Search Options ) (S) -->
            <table class="search" align="center" style="width:200;">
                <tr>
                    <td class="bg">
                        <table class="search"  style="width:200;">
                            <tr>
                                <td width="20%">Source Week</td>
								<td width="25%">
							        <input type="text" style="width:60" name="f_src_week" maxlength="7"
							        	onKeyPress="ComKeyOnlyNumber(this)"
							        	onFocus="this.value=ComReplaceStr(this.value, '-', '');" onBlur="this.value=ComGetMaskedValue(this.value,'yw');" >
								</td>
                            </tr>
                            <tr>
                                <td width="20%">Target Week</td>
								<td>
									<input type="text" style="width:60" name="f_tar_week" maxlength="7"
							        	onKeyPress="ComKeyOnlyNumber(window);"
							        	onFocus="this.value=ComReplaceStr(this.value, '-', '');" onBlur="this.value=ComGetMaskedValue(this.value,'yw');">
								</td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
            <!-- : ( Search Options ) (E) -->
            <!--1 End-->
		</td>
    	</tr>
		</table>
		</td>
    </tr>
</table>
<!-- OUTER - POPUP (E)nd -->

<table class="height_5"><tr><td></td></tr></table>
<div id="tabLayer2" style="display:none">
				<table width="100%" id="mainTable2">
				<tr><td><script language="javascript">ComSheetObject('sheet1');</script></td></tr>
				</table>
</div>

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
    <tr>
        <td height="71" class="popup">
            <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
                <tr>
                    <td class="btn3_bg">
                        <table border="0" cellpadding="0" cellspacing="0">
                            <tr>
                            	<!-- Repeat Pattern -->
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td><td class="btn1" name="btn_save" id="btn_save">Save</td><td class="btn1_right"></td></tr></table></td>

								<td class="btn1_line"></td>

								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
								<!-- Repeat Pattern -->

                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>
<!-- : ( Button : pop ) (E) -->


</form>
</body>
</html>