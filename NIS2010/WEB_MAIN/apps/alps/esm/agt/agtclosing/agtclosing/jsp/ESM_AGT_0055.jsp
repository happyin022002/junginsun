<%--
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_AGT_0055.jsp
*@FileTitle : Estimated Performanace Report by R.VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2010-10-20
*@LastModifier : Jeongsoo Lee
*@LastVersion : 1.0
* 2010-10-20 Jeongsoo Lee
* 1.0 최초 생성
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.agt.common.Utils"%>
<%@ page import="com.hanjin.apps.alps.esm.agt.common.CodeUtil"%>
<%@ page import="com.hanjin.apps.alps.esm.agt.common.ComboUtil"%>
<%@ page import="com.hanjin.apps.alps.esm.agt.agtclosing.agtclosing.event.EsmAgt0055Event"%>
<%@ page import="com.hanjin.bizcommon.util.BizComUtil"%>
<%@ page import="org.apache.log4j.Logger"%>
<%
	EsmAgt0055Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	DBRowSet rowSet = null; //DB ResultSet
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.AGTClosing.AGTClosing");

	String userId = "";
	String ofcCd = "";
	String arOfcCd = "";
	String ar_ofc_cd = "";
	String agn_cd = "";

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		userId = account.getUsr_id();
		ofcCd = account.getOfc_cd();
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmAgt0055Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request
				.getAttribute("EventResponse");
	} catch (Exception e) {
		out.println(e.toString());
	}

	//로그인한 USER가 속한 부서의 A/R Office Code를 구한다.
	arOfcCd = CodeUtil.getInstance().getCodeInfo("arOfcCd", ofcCd);

	//Combo Data : getCodeCombo('태그명','초기값', '추가요소', '업무명', '조건코드', '전체유무', '추가옵션')
	ar_ofc_cd = ComboUtil
			.getCodeCombo(
					"ar_ofc_cd",
					arOfcCd,
					" onChange='ar_ofc_cd_OnChange(this);' style='width:85', class='input1'",
					"arOfcCd", ofcCd, "&lt;&lt;select&gt;&gt;", "");
	//agn_cd = ComboUtil.getCodeCombo("agn_cd", ofcCd, " style='width:100'", "sbOfcCd", arOfcCd, "&lt;&lt;select&gt;&gt;", "");
	agn_cd = ComboUtil
			.getCodeCombo(
					"agn_cd",
					arOfcCd,
					" onChange='agn_cd_OnChange(this);' style='width:100', class='input1'",
					"sbOfcCd", arOfcCd, "&lt;&lt;select&gt;&gt;", "");
%>
<html>
<head>
<title>Estimated Performance Report by R.VVD</title>
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
<iframe height="0" width="0" name="frmHidden"></iframe>

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage"> 
<input type="hidden" name="param1"><!-- ComboUtil에서 사용하는 codeItem --> 
<input type="hidden" name="param2"><!-- All Display 유무(Y, N, [All]) --> 
<input type="hidden" name="param3"><!-- Object Name --> 
<input type="hidden" name="param4"><!-- arOfcCd Code --> <input type="hidden" name="param5"><!-- BL No --> <!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
	<tr>
		<td><!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr>
				<td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td>
			</tr>
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) --> <!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom: 5;">
			<tr>
				<td class="btn1_bg">

				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<!-- Repeat Pattern -->
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_retrieve">Retrieve</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>

						<td class="btn1_line"></td>

						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_new">New</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_creation">Source Data Creation</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_downexcel">Down Excel</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<!-- Repeat Pattern -->

					</tr>
				</table>

				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Button : Main ) (E) --> <!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
			<tr><td class="bg">
				<table class="search_in" border="0">
					<tr class="h23">
						<td width="50">Period</td>
						<td width="220" align="left" >
							<input type="text" style="width: 55"	class="input1" maxlength="6" value="" dataformat="ym" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)"  name="search_dt_fr">&nbsp;~&nbsp;
							<input type="text" style="width: 55"	class="input1" maxlength="6" value="" dataformat="ym" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)"  name="search_dt_to">
						</td>
						<!--<td width="270" align="left" ><input type="text" name="search_dt_fr" style="width:75;ime-mode:disabled" dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)" maxlength="10">&nbsp;
							<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" 	name="btn_dt_fr"> ~ 
							<input type="text" name="search_dt_to" style="width:75;ime-mode:disabled;" dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)" maxlength="10">&nbsp;
							<img	class="cursor" src="/hanjin/img/button/btns_calendar.gif"	width="19" height="20" border="0" align="absmiddle"	name="btn_dt_to">
						</td>
											
						--><td width="50">R.VVD</td>
						<td width="180">
							<input type="text" name="s_r_vvd" style="width: 100; ime-mode: disabled;" onkeypress="ComKeyOnlyAlphabet('uppernum')" maxlength="10" onfocus="rvvd_onfocus(this)" onblur="rvvd_validate(this)">
							<img src="img/btns_search.gif" name="btn_0B2pop" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
						</td>
						
						<td align="left">
							<table class="search_sm2" border="0" width="330">
								<tr class="h23">
									<td width="70">&nbsp;&nbsp;IOC Type</td>
									<td class="stm">
										<input type="checkbox" name="s_ia_flg" value= "Y"  class="trans">&nbsp;IA&nbsp;&nbsp;
										<input type="checkbox" name="s_ie_flg"   value= "Y"  class="trans">&nbsp;IE&nbsp;&nbsp;
										<input type="checkbox" name="s_im_flg" value= "Y"  class="trans">&nbsp;IM&nbsp;&nbsp;
										<input type="checkbox" name="s_oo_flg" value= "Y"  class="trans">&nbsp;OO&nbsp;&nbsp;
										<input type="checkbox" name="s_xx_flg" value= "Y"  class="trans">&nbsp;XX
									</td>
								</tr>
							</table>
						
						</td>
						
						
					</tr>
				</table>
			</td>
		</tr>
	</table>
				<table class="height_10">
					<tr>
						<td></td>
					</tr>
				</table>
				<!-- TABLE '#D' : ( Search Options ) (E) --> <!-- TABLE '#D' : ( Search Options ) (S) -->
				<table class="search">
					<tr>
						<td class="bg"><!-- : ( Agent Commission Request ) (S) --> <!-- : ( grid ) (S) -->
						<table width="100%" id="mainTable">
							<tr>
								<td><script language="javascript">ComSheetObject('sheet1');</script></td>
							</tr>
						</table>
						<!-- : ( grid ) (E) --> <!-- : ( Agent Commission Request ) (E) --> <!-- <textarea name="sXml" cols="150" rows="10" ></textarea> --></td>
					</tr>
				</table>
				<!-- TABLE '#D' : ( Search Options ) (E) --></td>

			</tr>
		</table>
		<!-- Outer Table (E)-->


		</form>
</body>

</html>

