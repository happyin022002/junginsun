<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0138.jsp
*@FileTitle : Inquiry Office
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.19
*@LastModifier : 송호진
*@LastVersion : 1.0
*  2007-04-24 Jeon Yun Ju
*  1.0 최초 생성
* =========================================================
* History
* 2008.05.02 임옥영 R200804296327 CSS파일 경로 변경
* 2008.09.05 전성진 CSR No.N200809030003
* 						- 7레벨 추가로 크기 변경
* 2009.03.10 임옥영 R200903100006   MAS Office Report-Graph 오류
* 2009.11.19 송호진 ALPS FW 적용
* 2010.06.10 송호진 [Legacy전환] UI 표준안 적용 요청 관련 수정 : 
	               CHM-200901714, CHM-200901715, CHM-200901716, CHM-200901717, CHM-200901718, CHM-200901719
* 2010.09.01 김기종 Ticket ID:CHM-201004982-01 MAS Architecture 위배사항 수정	               
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.event.EsmMas0138Event"%>
<%@ page import="com.hanjin.apps.alps.esm.mas.common.Utils"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
//	EsmMas0138Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.STDUnitCost.CostStructure");
	
    Utils utils = new Utils();

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Inquiry Office</title>
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
<iframe height="0" width="0" name="frmHidden" id="frmHidden"></iframe>

<form method="post" name="form" onSubmit="return false;" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="f_ofc_cd" value="">
<input type="hidden" name="f_ofc_lvl" value="">
<!-- design start -->
<!-- OUTER - POPUP (S)tart -->
<table width="800" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">


		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp; Inquiry Office</td></tr>
		</table>
		<!-- : ( Title ) (E) -->



<!-- TABLE '#D' : ( Button : Main ) (S) -->
<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
     	<tr><td class="btn1_bg">

		<table border="0" cellpadding="0" cellspacing="0">
		<tr>
			<!-- Repeat Pattern -->
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td><td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>

			<td class="btn1_line"></td>

			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td><td class="btn1" id="btn_downexcel" name="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
			<!-- Repeat Pattern -->

		</tr></table>

	</td></tr>
</table>
<!-- TABLE '#D' : ( Button : Main ) (E) -->

<!-- TABLE '#D' : ( Search Options ) (S) -->
<table class="search">
<tr><td class="bg">

		 <!-- : ( By Office ) (S) -->
          <table border="0">
            <tr class="h23">
               <td width="90" class="gray_tit"><img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">&nbsp;By Office</td>
               <td width="85">Office Level</td>
               <td width="160">
               		<script language="javascript">ComComboObject('f_rhq_cd',1, 100 , 0 )</script>
               <td width="50">Office</td>
               <td>
               		<script language="javascript">ComComboObject('f_sls_ofc_cd',1, 80 , 0 )</script>
               </td>
            </tr>
     	  </table>
		 <!-- : ( By Office ) (S) -->

<table class="line_bluedot"><tr><td></td></tr></table>

		<table width="100%">
		<tr><td width="100%">

			<!-- : ( Grid ) (S) -->
				<table width="100%" id="mainTable">
				<tr><td><script language="javascript">ComSheetObject('sheet1');</script></td></tr>
				</table>

			<!-- : ( Grid ) (E) -->

			</td>
		</tr>
		</table>


	</td>
</tr>
</table>
<!-- TABLE '#D' : ( Search Options ) (E) -->




	</td></tr>
</table>
<!-- OUTER - POPUP (E)nd -->


<table class="height_5"><tr><td></td></tr></table>


<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>

				<!-- Repeat Pattern -->
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
				<!-- Repeat Pattern -->

			</tr>
		</table>

	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
<!-- design end -->
</form>
</body>
</html>