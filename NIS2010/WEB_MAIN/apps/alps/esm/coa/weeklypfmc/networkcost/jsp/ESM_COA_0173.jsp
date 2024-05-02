<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_COA_173.jsp
*@FileTitle :Average U/C Copy
*Open Issues :
*Change history :
	' 2010.01.07 김기식  ALPS FrameWork 적용
*@LastModifyDate :
*@LastModifier : 
*@LastVersion :
* 2009-09-10 CHOI IN KYUNG
* 1.0 최초 생성
=============================================================================
* History
* 2010.06.10 송호진 [Legacy전환] UI 표준안 적용 요청 관련 수정 :
                   CHM-200901714, CHM-200901715, CHM-200901716, CHM-200901717, CHM-200901718, CHM-200901719
* 2011.03.08 김상수 Ticket ID:CHM-201109234-01 lane simulation 기능 보완
*                    - showErrMessage -> ComShowMessage로 수정
* 2011.05.26 최성민 [CHM-201006017-01] COA 약정율 로직 추가 - Title Name 변경
* 2011.12.23 최성민 [CHM-201114896-01] [COA] CM2 추가 개발 요청
* 2012.09.10 이석준 [CHM-201220070-01] EQ Repo Cost (PA) 화면에 Month Copy 기능 추가
=========================================================*/
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
	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		classId = request.getParameter("classId");			
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
<input	type="hidden" name="f_cost_use_tp_cd">
<input type="hidden" name="backendjob_key">

<!-- OUTER - POPUP (S)tart -->
<table width="580" class="popup" cellpadding="10">
	<tr><td class="top"></td></tr>
	<tr><td valign="top">

		<!-- : ( Title ) (S) -->
        <table width="100%" border="0">
            <tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp; Month Copy</td></tr>
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
                                <td width="20%">Source Month</td>
								<td width="25%">
							        <input type="text" style="width:60" name="f_src_mon" maxlength="7"
							        	onKeyPress="ComKeyOnlyNumber(this)"
							        	onFocus="this.value=ComReplaceStr(this.value, '-', '');" onBlur="this.value=ComGetMaskedValue(this.value,'ym');" >
								</td>
                            </tr>
                            <tr>
                                <td width="20%">Target Month</td>
								<td>
									<input type="text" style="width:60" name="f_tar_mon" maxlength="7"
							        	onKeyPress="ComKeyOnlyNumber(window);"
							        	onFocus="this.value=ComReplaceStr(this.value, '-', '');" onBlur="this.value=ComGetMaskedValue(this.value,'ym');">
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