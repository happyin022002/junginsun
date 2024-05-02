
<%
/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_PRI_0082.jsp
 *@FileTitle : Customer Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2013.05.28
 *@LastModifier : 이혜민
 *@LastVersion : 1.0
 * 2009.04.29 김재연
 * 1.0 Creation
 * =========================================================
 * History
 * 2013.05.28 이혜민 [CHM-201324516-01] Surcharge 종합체계 구축 T/F - Surcharge Summary Report 화면 신규개발
 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.event.EsmPri0082Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmPri0082Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.hanjin.apps.PRIMasterData.Customer");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmPri0082Event) request.getAttribute("Event");
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
	
	String nmdCustFlg = null;
	String custCntCd = null;
	String custSeq = null;
	String custNm = null;
	String isPopup = null;
	
	nmdCustFlg = JSPUtil.getNull(request.getParameter("nmd_cust_flg")); //Named Customer 포함 여부
	custCntCd = JSPUtil.getNull(request.getParameter("cust_cnt_cd"));
	custSeq = JSPUtil.getNull(request.getParameter("cust_seq"));
	custNm = JSPUtil.getNull(request.getParameter("cust_nm"));
	isPopup = JSPUtil.getNull(request.getParameter("is_popup")); //POP UP 화면 여부
%>
<html>
<head>
<title>Customer Inquiry</title>
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

<body onLoad="setupPage();">
<form name="form" onKeyUp="ComKeyEnter('LengthNextFocus')">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="nmd_cust_flg" value="<%=nmdCustFlg%>"> 
<input type="hidden" name="is_popup" value="<%=isPopup%>">

<input type="hidden" name="prop_no" value="<%=request.getParameter("prop_no")%>">
<input type="hidden" name="amdt_seq" value="<%=request.getParameter("amdt_seq")%>">
<input type="hidden" name="svc_scp_cd" value="<%=request.getParameter("svc_scp_cd")%>">
<input type="hidden" name="gen_spcl_rt_tp_cd" value="<%=request.getParameter("gen_spcl_rt_tp_cd")%>">


<%
    if (isPopup.equals("true")) {
%>
<!-- OUTER - POPUP (S)tart -->
<table width="400" class="popup" cellpadding="10" border="0">
	<tr>
		<td class="top"></td>
	</tr>
	<tr>
		<td valign="top"><!-- : ( Title ) (S) -->
		<table width="100%" border="0">
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif"
					align="absmiddle">&nbsp;Customer Inquiry</td>
			</tr>
		</table>
<%
    } else {
%>
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	</table>
	<!--Page Title, Historical (E)-->
<%
    }
%>
		<!-- : ( Title ) (E) --> <!-- : ( Search Options ) (S) -->

		<table class="search">
			<tr>
				<td class="bg">
					<div id="radioLayer1" style="display:none">
					<table class="search_sm" border="0" style="width:350;"> 
						<tr class="h23">
							<td width="15%">Type</td>
						    <td width="" class="stm">
						    	<input type="radio" name="radio_type" value="G" class="trans" >Group Customer code&nbsp;&nbsp;
						    	<input type="radio" name="radio_type" value="C" class="trans">Customer Code&nbsp;&nbsp;
							</td>
						</tr>
					</table>
					</div>
					<div id="radioLayer2" style="display:inline">
					<table class="search" border="0" style="width: 600;">
						<tr class="h23">
							<td width="17%">Customer Code</td>
							<td width="">
								<input type="text" name="cust_cnt_cd" value="<%=custCntCd%>" dataformat="eng" maxlength="2" minlength="2" style="text-align:center; width: 30; ime-mode:disabled" class="input" required>&nbsp;<input type="text" name="cust_seq"  value="<%=custSeq%>" dataformat="int" maxlength="6" minlength="3" style="text-align:center; width: 50; ime-mode:disabled" class="input"></td>
						</tr>
						<tr class="h23">
							<td width="">Customer Name</td>
							<td width=""><input type="text" name="cust_lgl_eng_nm" value="<%=custNm%>" maxlength="100" style="width: 200; ime-mode:disabled" class="input" value=""></td>
						</tr>
					</table>
					</div>
					<div id="radioLayer3" style="display:none">
					<table class="search" border="0" style="width: 600;">
						<tr class="h23">
							<td width="27%">Group Customer Code</td>
							<td width="">
								<input type="text" name="cust_grp_id" align="center"  maxlength="1" minlength="1" style="text-align:center; width: 20; ime-mode:disabled" class="input" onKeyPress="ComKeyOnlyAlphabet('uppernum');" >&nbsp;-&nbsp;<input type="text" name="cust_grp_id_seq"  maxlength="8" style="text-align:center; width: 80; ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum');" class="input"></td>
						</tr>
						<tr class="h23">
							<td width="">Group Customer Name</td>
							<td width=""><input type="text" name="cust_grp_nm" maxlength="100" style="width: 200; ime-mode:disabled" class="input" value=""></td>
						</tr>
					</table>
					</div>
					<table class="line_bluedot">
						<tr>
							<td colspan="8"></td>
						</tr>
					</table>

					<!-- : ( Grid ) (S) -->
					<div id="sheetLayer1" style="display:inline">
					<table width="100%" id="mainTable">
						<tr>
							<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
					</div>
					<div id="sheetLayer2" style="display:none">
					<table width="100%" id="mainTable">
						<tr>
							<td width="100%"><script language="javascript">ComSheetObject('sheet2');</script>
							</td>
						</tr>
					</table>
					</div>
					<!-- : ( Grid ) (E) --> <!--  Button_Sub (S) -->
					<table width="100%" class="button" border="0">
						<tr>
							<td class="btn2_bg">
								<table border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td>
											<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr>
													<td class="btn2_left"></td>
													<td class="btn2" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
													<td class="btn2_right"></td>
												</tr>
											</table>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
					<!-- Button_Sub (E) -->
				</td>
			</tr>
		</table>
		<!-- : ( Search Options ) (E) --></td>
	</tr>
</table>
<!-- : ( Button : pop ) (S) -->
<%
    if (isPopup.equals("true")) {
%>
<table class="height_5">
	<tr>
		<td></td>
	</tr>
</table>
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup">
		<table width="100%" class="button" border="0" cellpadding="0"
			cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
			<tr>
				<td class="btn3_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td width="72">
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_ok">OK</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td class="btn1_line"></td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_close">Close</td>
								<td class="btn1_right"></td>
							</tr>	
						</table>
						</td>
					</tr>
				</table>
				<!--Button (E) --></td>
			</tr>
		</table>
		</td>
	</tr>
</table>
<% 
	} 
%>
		<!-- : ( Button : pop ) (E) --> <!-- 개발자 작업  끝 -->
</form>
</body>
</html>