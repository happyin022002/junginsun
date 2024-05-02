<%
/*=========================================================
*Copyright(c) 2007 CyberLogitec
*@FileName : ESM_COA_0140.jsp
*@FileTitle : Feeder Term Ratio
*Open Issues : 
*Change history : 
*@LastModifyDate : 2009-08-03
*@LastModifier : 전윤주
*@LastVersion : 1.0
* 2007-05-22 HoIk_Lee
* 1.0 최초 생성
* 2008-04-29 전성진 R200804296328 css 파일 참조 확인 및 수정 요청 
* 2009-08-03 전윤주 New Framework 적용
* 2015.07.07 이윤정 [CHM-201536740] COA 내 화면의 조회 기능 (Retrieve, Down Excel)을 뺀 나머지 버튼들을 비활성화 요청 CSR
=========================================================*/ 
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	String f_calc_term_cd = JSPUtil.getNullNoTrim(request.getParameter("f_calc_term_cd"));
	String f_wtr_term_cd  = JSPUtil.getNullNoTrim(request.getParameter("f_wtr_term_cd"));	
	
	Logger log = Logger.getLogger("com.hanjin.apps.Stdunitcost.CostStructure");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

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
<title>Feeder Term Ratio</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		setRetrieveAction();
	}
</script>
</head>

<body  onLoad="setupPage();" >
<form name="form" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="f_calc_term_cd" value="<%= f_calc_term_cd %>">
<input type="hidden" name="f_wtr_term_cd"  value="<%= f_wtr_term_cd %>">
<!-- 개발자 작업	-->

<!-- design start -->
<!-- OUTER - POPUP (S)tart -->
<table width="900" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">



		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp; Feeder Term Ratio</td></tr>
		</table>
		<!-- : ( Title ) (E) -->


            <!--Button (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
		       	<tr><td class="btn1_bg">

					<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<!-- Repeat Pattern -->
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1" id="btn_retrieve" name="btn_Retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>

						<td class="btn1_line"></td>

						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1" id="btn_reset" name="btn_Reset">Reset</td><td class="btn1_right"></td></tr></table></td>
						<!--
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1" id="btn_save" name="btn_Save">Save</td><td class="btn1_right"></td></tr></table></td>
						-->
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1" id="btn_downexcel" name="btn_DownExcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
						<!--
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1" id="btn_loadexcel" name="btn_LoadExcel">Load Excel</td><td class="btn1_right"></td></tr></table></td>
						-->
						<!-- Repeat Pattern -->

					</tr></table>

				</td></tr>
			</table>
            <!--Button (E) -->


              <!-- TABLE '#D' : ( Search Options ) (S) -->
              <table class="search">
                <tr>
                  <td class="bg">

	                    <table width="100%" id="mainTable">
	                      <tr>
	                        <td>
	                          <script language="javascript">ComSheetObject('sheet1');</script>
	                        </td>
	                      </tr>
	                    </table>


						<!-- : ( Button : Grid ) (S) -->
						<table width="100%" class="button">
					       	<tr><td class="btn2_bg">
							<table border="0" cellpadding="0" cellspacing="0">
							<tr>

								<!-- Repeat Pattern -->
								<!--  
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" id="btng_rowadd" name="btng_RowAdd">Row Add</td><td class="btn2_right"></td></tr></table></td>

								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" id="btn_rowdel" name="btng_RowDel">Row Del.</td><td class="btn2_right"></td></tr></table></td>
								-->
								<!-- Repeat Pattern -->


							</tr></table>
						</td></tr>
						</table>
				    	<!-- : ( Button : Grid ) (E) -->
		</td></tr>
		</table>
		<!-- : ( Search Options ) (E) -->


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
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_Close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
				<!-- Repeat Pattern -->

			</tr>
		    </table>
		</td></tr>
		</table>
</td></tr>
</table>


<!-- : ( Button : pop ) (E) -->
<!-- design end -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>