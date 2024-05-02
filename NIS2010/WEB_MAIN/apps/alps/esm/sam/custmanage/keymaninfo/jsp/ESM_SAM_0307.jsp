<%

	/*=========================================================
	 *Copyright(c) 2017 
	 *@FileName : esm_sam_0307.jsp
	 *@FileTitle : KeyMan List조회 화면
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2017.07.04
	 *@LastModifier : 임진영
	 *@LastVersion : 1.0
	 =========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.sam.custmanage.keymaninfo.event.EsmSam0307Event"%>	
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmSam0307Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	boolean bBtn_Disabled = true;
	Logger log = Logger
			.getLogger("com.hanjin.apps.custmanage.keymaninfo");
	
	String custCd		= JSPUtil.getParameter(request, "cust_cd");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmSam0307Event) request.getAttribute("Event");
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
%>
<html>
<head>
<title>Welcome to alps!</title>
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
<!--DIV ID='debugdiv'></DIV-->
<form name="form">
	<input type="hidden" name="f_cmd"> 
	<input type="hidden" name="pagerows"> 
	<input type="hidden" name="ch_usr_id">
	<input type="hidden" name="cust_cnt_cd">
	<input type="hidden" name="cust_seq">
	<input type="hidden" name="keyman_seq">
    <input type="hidden" name="ibflag">
<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	style="padding-top: 2; padding-left: 5;">

	<tr>
		<td valign="top"><!--Page Title, Historical (S)-->
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
		<!--Page Title, Historical (E)--> <!-- : ( Search Options ) (S) -->

			<table class="search"> 
       	<tr><td class="bg">

					<!--  biz_1  (S) -->
					<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="100">Customer Code</td><!-- <%=custCd%> -->
						<td width="150"><input type="text" style="width:100; text-align: center;" value="" class="input" name="cust_cd" maxlength='8' required dataformat='engupnum' style="ime-mode:disabled">
						<img src="img/btns_search.gif" name="btn_com_ens_041" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td></td>
						<td width="70">First Name</td>
						<td width="150"><input type="text" style="width:100" value="" class="input" name="fst_name" maxlength='100' dataformat="uppernum" otherchar="!@&()_/\- " style="ime-mode:disabled"></td>
						<td width="70">Last Name</td>
						<td width="150"><input type="text" style="width:100" value="" class="input" name="last_name" maxlength='100' dataformat="uppernum" otherchar="!@&()_/\- " style="ime-mode:disabled"></td>
						<td width="35">S.Rep</td>
						<td width="150"><input type="text" style="width:100; text-align: center;" value="" class="input" name="srep_cd" maxlength='7' dataformat='engupnum' style="ime-mode:disabled"></td>
					</tr>

					</table>
				
				</td></tr>
			</table>

			<table class="height_8"><tr><td></td></tr></table>
			
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
				</td>
			</tr>
		</table>
		<!-- : ( Search Options ) (E) --></td>
	</tr>
</table>
<!--Button (S) -->
<table width="100%" class="button" border="0" cellpadding="0"
	cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
	<tr>
		<td class="btn1_bg">
		<table border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td>
				<table width="" border="0" cellpadding="0" cellspacing="0"class="button">
					<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
						<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="" border="0" cellpadding="0" cellspacing="0"class="button">
					<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Create" id="btn_Create">Create</td>
						<td class="btn1_right"></td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		</td>
	</tr>
</table>
<!--Button (E) --> <!--biz page (E)-->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>