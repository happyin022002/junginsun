
<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : ESM_PRI_0011.jsp
	 *@FileTitle : Boiler Plate Inquiry
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.10.01
	 *@LastModifier : 공백진
	 *@LastVersion : 1.0
	 * 2009.10.01 공백진
	 * 1.0 Creation
	 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.scguideline.scboilerplateguideline.event.EsmPri0011Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmPri0011Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.hanjin.apps.SCGuideline.SCBoilerPlateGuideline");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmPri0011Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Boiler Plate Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="blpl_hdr_seq" value="">
<input type="hidden" name="blpl_seq" value="">
<input type="hidden" name="blpl_nm" value=" ">
<!-- seleted Duration -->
<input type="hidden" name="eff_dt_hidden" value="">
<input type="hidden" name="exp_dt_hidden" value="">

 <!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top: 2; padding-left: 5;">
	<tr>
		<td valign="top"><!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr>
				<td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td>
			</tr>
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td>
			</tr>
		</table>
		<!--Page Title, Historical (E)--> <!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 0; , padding-bottom: 2;">
			<tr>
				<td class="btn1_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_retrive">Retrieve</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		<!--Button (E) --> <!--biz page (S)-->
		<table class="search">
			<tr>
				<td class="bg"><!--  biz_1  (S) -->

				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="30">Year</td>
						<td width="150" class="stm"><script language="javascript">ComComboObject('blpl_ref_yr', 1, 55, 1, 3);</script>&nbsp;Boiler Plate</td>
						<td width="60">Duration</td>
						<td width="230">
						<script language="javascript">ComComboObject('eff_dt', 2, 90, 1, 3);</script> &nbsp;~ 
						<input name="exp_dt" type="text" style="width: 75;"	value="" class="input2" caption="Expire Date" maxlength="10" dataformat="ymd" readonly> 
						</td>
						<td width="85">Confirmation</td>
						<td width=""><input name="cfm_flg" type="text"	style="width: 58;" value="" class="input2" readonly	caption="Confirmation"></td>
					</tr>

				</table>
				<!--  biz_1   (E) --> 
				<!-- Hidden sheet for Transaction (S) --> 
				<script	language="javascript">ComSheetObject('sheet0');</script> 
				<!-- Hidden sheet for Transaction (E) -->
				</td>
			</tr>
		</table>

		<table class="height_8">
			<tr><td></td></tr>
		</table>


		<table class="search">
			<tr>
				<td class="bg">
				<!-- : ( Grid ) (S) -->
				<table width="100%" id="mainTable">
					<tr>
						<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- : ( Grid ) (E) -->

				<table class="line_bluedot">
					<tr><td colspan="6"></td></tr>
				</table>

				<!-- : ( Grid ) (S) -->
				<table width="100%" id="mainTable">
					<tr>
						<td width="100%"><script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>
				<!-- : ( Grid ) (E) --></td>
			</tr>
		</table>



		</td>
	</tr>
</table>


<!-- 개발자 작업  끝 -->
</form>
</body>
</html>