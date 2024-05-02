<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_AGT_042.jsp
*@FileTitle : Other Commission Request
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-16
*@LastModifier : JungHyung, Kim
*@LastVersion : 1.0
* 2007-01-16 JungHyung, Kim
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
<%@ page import="com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.event.EsmAgt0042Event"%>
<%@ page import="com.hanjin.bizcommon.util.BizComUtil"%>
<%
	EsmAgt0042Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	DBRowSet rowSet = null; //DB ResultSet
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String ofcCd = "";
	String arOfcCd = "";
	String ar_ofc_cd = "";
	String cbAccountCode = "";
	String account_code = "";
	String account_name = "";

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        ofcCd = account.getOfc_cd();
		event = (EsmAgt0042Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}

	//로그인한 USER가 속한 부서의 A/R Office Code를 구한다.
	ar_ofc_cd = CodeUtil.getInstance().getCodeInfo("arOfcCd", ofcCd);

	//Combo Data : getCodeCombo('태그명','초기값', '추가요소', '업무명', '조건코드', '전체유무', '추가옵션')
	ar_ofc_cd = ComboUtil.getCodeCombo("ar_ofc_cd",ar_ofc_cd," onChange='ar_ofc_cd_OnChange(this);' style='width:85', class='input1'","arOfcCd", ofcCd, "&lt;&lt;select&gt;&gt;", "");

	cbAccountCode = ComboUtil.getIBCodeCombo("", "", "", "mdmAccountList", "", "", "");
	//out.println(cbAccountCode);
	if (cbAccountCode != null && cbAccountCode.length() > 8) {
		account_code = cbAccountCode.substring(cbAccountCode.indexOf("Code = \"") + 8, cbAccountCode.lastIndexOf("\""));
		account_name = cbAccountCode.substring(cbAccountCode.indexOf("Text = \"") + 8, cbAccountCode.indexOf("\";"));
	}
%>

<html>
<head>
<title>Other Commission Request</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
<%=BizComUtil.getIBCodeCombo("curr", "", "CURR", 2, "0: :ALL")%>
</script>
<script language="javascript">
        function setupPage(){
                var errMessage = "<%=strErrMsg%>";

                if (errMessage.length >= 1) {
                        ComShowMessage(errMessage);
                } // end if

                loadPage("<%=account_code%>", "<%=account_name%>");
        }
</script>
</head>

<body onload="javascript:setupPage();">
<iframe height="0" width="0" name="frmHidden"></iframe>

<form method="post" name="form" onSubmit="return false;">
 <input type="hidden" name="f_cmd">
 <input type="hidden" name="gubun">
 <input type="hidden" name="iPage">
 <input type="hidden" name="param1"> <!-- 선택한 A/R Office -->
 <input type="hidden" name="param2"> <!-- 입력한 Apply Date -->
 <input type="hidden" name="param3"> <!-- 선택한 A/R Office의 Vendor Country -->
 <input type="hidden" name="param4"> <!-- 선택한 A/R Office의 Vendor Seq -->
 <input type="hidden" name="param5"> <!-- 선택한 A/R Office의 Name -->
 <input type="hidden" name="param6"> <!-- 선택한 A/R Office의 Office -->
 <input type="hidden" name="param7"> <!-- 선택한 A/R Office의 City -->
 <input type="hidden" name="param8"> <!-- 선택한 A/R Office의 Center -->
 <input type="hidden" name="param9"> <!-- 선택한 A/R Office의 Curr -->
 <input type="hidden" name="param10"> <!-- 선택한 A/R Office의 xchRt -->
 <input type="hidden" name="office_code" value="<%=ofcCd%>"> <!-- 로그인한 Office Code -->


<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	class="bodypadding">
	<tr>
		<td><!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			class="title">
			<tr>
				<td class="history"><img src="img/icon_history_dot.gif"
					align="absmiddle"><span id="navigation"></span></td>
			</tr>
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif"
					align="absmiddle"><span id="title"></span></td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) --> <!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0"
			cellspacing="0" style="padding-bottom: 5;">
			<tr>
				<td class="btn1_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_retrieve">Retrieve</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td class="btn1_line"></td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_save">Save</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_request">Request</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_downexcel">Down Excel</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Button : Main ) (E) --> <!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">
				<table class="search_in" border="0">
					<tr class="h23">
						<td width="5%">Office</td>
						<td width="15%"><%=ar_ofc_cd%></td>
						<td width="11%">Subject Month</td>
						<td width="7%"><input type="text" style="width: 55"
							class="input1" maxlength="7" value="" dataformat="ym" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)"
							name="comm_yrmon"></td>
						<td class="sm">(YYYY-MM)</td>
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
				<td class="bg"><!-- : ( Other Commission Cost Creation ) (S) -->
				<table class="height_5">
					<tr>
						<td></td>
					</tr>
				</table>

				<!-- : ( grid ) (S) -->
				<table width="100%" id="mainTable">
					<tr>
						<td><script language="javascript">ComSheetObject('sheet1');</script></td>
					</tr>
				</table>
				<!-- : ( grid ) (E) --> <!-- : ( Button : Sub ) (S) -->
				<table width="100%" class="button">
					<tr>
						<td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0"
									class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btng_rowadd">Row Add</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				<!-- : ( Button : Sub ) (E) --> <!-- : ( Other Commission Cost Creation ) (E) -->

				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) --></td>
	</tr>
</table>
<!-- Outer Table (E)--></form>
</body>

</html>

