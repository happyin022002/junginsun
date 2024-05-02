<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0023.jsp
*@FileTitle : W/O 발행화면
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.20
*@LastModifier : 최 선
*@LastVersion : 1.2
* 2006.11.21 조풍연
* 1.0 최초 생성
*----------------------------------------------------------
* History
* 2009.03.17 양봉준    1.1 N200902240180 [TRS] TPB 대상 건 I/F 가능 시점 추가 요청 (09.03.17)
* 2011.07.20 최 선        1.2 [] UI 상단 공백 제거
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.bizcommon.util.BizComUtil"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.workordermanage.workorderissue.event.EsdTrs0023Event"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.invoicemanage.surchargeinputinquiry.event.EsdTrs0918Event"%>

<%
	EsdTrs0023Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수

	SignOnUserAccount account = null;

	try {

		account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

		event = (EsdTrs0023Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
    
	String unique_cd = JSPUtil.getNull(request.getParameter("unique_cd"));
	String open_mode = JSPUtil.getNull(request.getParameter("open_mode")); //input/modify/search
	String step_cd = JSPUtil.getNull(request.getParameter("step_cd"));
	String trsp_so_ofc_cty_cd = JSPUtil.getNull(request.getParameter("trsp_so_ofc_cty_cd"));
	String trsp_so_seq = JSPUtil.getNull(request.getParameter("trsp_so_seq"));
	String main_row = JSPUtil.getNull(request.getParameter("main_row"));
    String rate = JSPUtil.getNull(request.getParameter("rate"));
	String cal_logic = JSPUtil.getNull(request.getParameter("cal_logic")); // TM(곱하기)/DV(나누기)
	String sheet_arr_no = JSPUtil.getNull(request.getParameter("sheet_arr_no"));//bySheet일경우 parent의 surcharge sheet array no
	String bkg_no = JSPUtil.getNull(request.getParameter("bkg_no"));
	String eq_no = JSPUtil.getNull(request.getParameter("eq_no"));
	String wo_no = JSPUtil.getNull(request.getParameter("wo_no"));
	String curr_cd = JSPUtil.getNull(request.getParameter("curr_cd"));
%>
<html>
<head>
<title>3rd Party Billing</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">

<%=JSPUtil.getIBCodeCombo("bill_case", "01", "CD00946", 0, " |")%>

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		initCurrency();
		callCurrency();
	}
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type='hidden' name='curr_cd' value='<%=curr_cd%>'>
<input type='hidden' name='apply_currency' value='<%=curr_cd%>'>
<input type='hidden' name='unique_cd' value='<%=unique_cd%>'>
<input type='hidden' name='open_mode' value='<%=open_mode%>'>
<input type='hidden' name='step_cd' value='<%=step_cd%>'>
<input type='hidden' name='trsp_so_ofc_cty_cd' value='<%=trsp_so_ofc_cty_cd%>'>
<input type='hidden' name='trsp_so_seq' value='<%=trsp_so_seq%>'>
<input type='hidden' name='ofc_cty_cd' value='<%=trsp_so_ofc_cty_cd%>'>
<input type='hidden' name='so_seq' value='<%=trsp_so_seq%>'>
<input type='hidden' name='main_row' value='<%=main_row%>'>
<input type='hidden' name='rate' value='<%=rate%>'>
<input type='hidden' name='cal_logic' value='<%=cal_logic%>'>
<input type='hidden' name='sheet_arr_no' value='<%=sheet_arr_no%>'>
<input type='hidden' name='prefix' value='surcharge_'>
<input type="hidden" name="FORM_CRE_USR_ID" value="<%=account.getUsr_id()%>">
<input type="hidden" name="FORM_USR_OFC_CD" value="<%=account.getOfc_cd()%>">

<!-- OUTER - POPUP (S)tart -->
<table width="600" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp; 3rd Party Interface</td></tr>
		</table>
		<!-- : ( Title ) (E) -->

		<!-- : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<table class="search" border="0">
				<tr class="h23">
					<td width="18%">Booking No.</td>
					<td width="30%"><input name="text22" type="text" class="input2" style="width:100" ReadOnly value="<%=bkg_no%>"></td>
					<td width="17%">Equipment No.</td>
					<td><input name="text22" type="text" class="input2" style="width:100" ReadOnly value="<%=eq_no%>"></td></tr>

				<tr class="h23">
					<td>Work Order No.</td>
					<td><input name="text22" type="text" class="input2" style="width:100" ReadOnly value="<%=wo_no%>"></td>
					<td>Currency</td>
					<td><input name="text22" type="text" class="input2" style="width:100" ReadOnly value="<%=curr_cd%>"></td>
				</tr>
				</table>

				<table class="search"><tr><td class="line_bluedot"></td></tr></table>


				<!-- : (grid ) (S) -->
					<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet1');</script>
                        </td></tr>
		            </table>
				<!-- : ( grid ) (E) -->
				<!-- : (grid ) (S) -->
					<table width="100%" id="hiddenTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet2');</script>
                        </td></tr>
		            </table>
				<!-- : ( grid ) (E) -->
				<!-- : ( Button_ Sub ) (S) -->
					<table width="100%" id="hiddenTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet3');</script>
                        </td></tr>
		            </table>
				<!-- : ( grid ) (E) -->
				<!-- : ( Button_ Sub ) (S) -->
					<table width="100%" id="hiddenTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet4');</script>
                        </td></tr>
		            </table>
				<!-- : ( grid ) (E) -->


				<!-- : ( Button_ Sub ) (S) -->
				<table width="100%" class="button">
			       	<tr><td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0">
					<tr>

						<!-- Repeat Pattern -->
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td><td class="btn2" id="btng_save" name="btng_save">Save</td><td class="btn2_right"></td></tr></table></td>
						<!-- Repeat Pattern -->


					</tr></table>
				</td></tr>
				</table>
				<!-- : ( Button_ Sub ) (E) -->

			</td></tr>
		</table>
		<!-- : ( Search Options ) (E) -->


</td></tr>
</table>
<!-- OUTER - POPUP (E)nd -->



<table class="height_5"><tr><td></td></tr></table>


<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>

				<!-- Repeat Pattern -->
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_ok" id="btn_ok">OK</td><td class="btn1_right"></td></tr></table></td>

				<td class="btn1_line"></td>

				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
				<!-- Repeat Pattern -->

			</tr>
		</table>

	</td></tr>
</table>
<!-- : ( Button : Sub ) (E) -->

</body>
</html>

