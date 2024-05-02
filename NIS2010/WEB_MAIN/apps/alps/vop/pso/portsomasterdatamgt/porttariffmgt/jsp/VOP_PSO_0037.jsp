
<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : VOP_PSO_0037.jsp
	 *@FileTitle : Tariff Value Management
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2011.03.14
	 *@LastModifier : 진마리아
	 *@LastVersion : 1.0
	 * 2009.12.23 정명훈
	 * 1.0 Creation
	 *
	 * History
	 * 2011.03.14 진마리아 CHM-201109292-01 Location 조회불가건 수정 보완 요청
	 * 2014.03.12 박다은   CHM-201429104 	   [PSO] Tariff Attribute 내 불필요 Tariff 삭제 기능 요청
	 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.event.VopPso0037Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	VopPso0037Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.hanjin.apps.PortSOMasterDataMgt.PortTariffMgt");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (VopPso0037Event) request.getAttribute("Event");
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
<title>Tariff Value Management</title>
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

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top: 2; padding-left: 5;padding-right:5;">
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
		<table width="100%" class="button" border="0" cellpadding="0"
			cellspacing="0" style="padding-top: 0; , padding-bottom: 2;">
			<tr>
				<td class="btn1_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Retrieve">Retrieve</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_New">New</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td class="btn1_line"></td>
						<td>

						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Save">Save</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Delete">Delete</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
							<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Copy">Copy</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>

						</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>

		<!--Button (E) --> <!--biz page (S)-->
		<table class="search">
			<tr>
				<td class="bg">
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="80">Period</td>
						<td width="400"><input name="from_date" type="text" dataformat="ymd" maxlength="8" style="width: 73; ime-mode: disabled" class="input1" value="">&nbsp;<img class="cursor" name="btns_Calendar1" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">&nbsp;~&nbsp;<input type="text" name="to_date" maxlength="8" dataformat="ymd" style="width: 73; ime-mode: disabled" class="input1" value="">&nbsp;<img name="btns_Calendar2" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
						<td width="55">Port</td>
						<td width=""><input name="port_cd" type="text" dataformat="uppernum" style="width: 50" class="input" value="" size="5" maxlength="5">&nbsp;<img class="cursor" name="btn_port_cd" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">&nbsp; <script language="javascript">ComComboObject('yard_cd',2, 200, 0, 0);</script></td>
					</tr>
					<tr class="h23">
						<td width="">Account CD</td>
						<td width="" style="padding-left: 2"><script language="javascript">ComComboObject('acct_cd',2, 96, 0, 0);</script>&nbsp;<input type="text" name="acct_nm" style="width: 300; text-align: left" class="input2" value="" readonly></td>
						<td width="">Cost CD</td>
						<td width="" style="padding-left: 2"><script language="javascript">ComComboObject('cost_cd',2, 90, 0, 0);</script>&nbsp;<input type="text" name="cost_nm" style="width: 310; text-align: left" class="input2" value="" readonly></td>
					</tr>

				</table>
	
				<table class="line_bluedot"><tr><td></td></tr></table>

				<!--table class="search" border="0">
					<tr>
						<td class="title_h"></td>
						<td width="" class="title_s">Base</td>
					</tr>
				</table-->

				<table width="100%" class="search" border="0">
					<tr class="h23">
						<td width="72%" valign="top">
							<table width="100%" id="mainTable">
								<tr>
									<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script></td>
								</tr>
							</table>
						</td>
						<td width="1%" valign="top">&nbsp;</td>
						<td width="27%" valign="top">
							<table width="100%" id="mainTable">
								<tr>
									<td width="100%"><script language="javascript">ComSheetObject('sheet2');</script></td>
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
		</td>
	</tr>
</table>

<!-- 개발자 작업  끝 --></form>
</body>
</html>
<%@include file="/bizcommon/include/common_nis2010.jsp"%>