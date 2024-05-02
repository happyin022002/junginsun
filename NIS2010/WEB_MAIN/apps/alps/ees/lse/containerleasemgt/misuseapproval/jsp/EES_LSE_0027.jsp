<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_LSE_0027.jsp
*@FileTitle : Mis Use In & Out Request
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.07.14 장준우
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
<%@ page import="com.hanjin.apps.alps.ees.lse.containerleasemgt.misuseapproval.event.EesLse0027Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesLse0027Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String strCur_dt		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.alps.ees.lse.containerleasemgt.misuseapproval");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EesLse0027Event)request.getAttribute("Event");
		strCur_dt = EesLse0027Event.getCurrentDate("yyyy-MM-dd");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Mis Use In & Out Request</title>
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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">

	</td></tr>



	<tr><td valign="top">
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->


	<table class="search">
       		<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="90">Request No.</td>
					<td width="253"><input type="text" name="rqst_no" caption="Request No." style="width:150" value="" class="input2" readonly></td>
					<td width="89">Request OFC</td>
					<td width="228"><input type="text" name="rqst_ofc_cd" caption="Request OFC"  style="width:80;text-align:center;" value="<%= strOfc_cd %>" class="input2" readonly></td>
					<td width="110">Request User ID</td>
					<td width=""><input type="text" name="rqst_usr_id" caption="Request User ID" style="width:80;text-align:center;color:blue;cursor:hand;" value="<%= strUsr_id %>" class="input2" readonly></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="90">Approval OFC</td>
					<td width="245"><input type="text" name="apro_ofc_cd" caption="Approval OFC" style="width:83;text-align:center;" value="SELCON" class="input2" readonly></td>
					<td width="325">
						<table class="search_sm2" border="0" style="width:230;">
							<tr>
								<td width="95">&nbsp;<strong>Request Case</strong></td>
								<td class="noinput1">
									<input type="radio" name="mss_rqst_io_mod_cd" value="O" class="trans" checked>MO&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="radio" name="mss_rqst_io_mod_cd" value="I" class="trans">MI&nbsp;&nbsp;&nbsp;</td>
							</tr>
						</table>
					</td>
					<td width="110">Date</td>
					<td width=""><input type="text" name="rqst_dt" caption="Date" style="width:80;text-align:center;" value="<%= strCur_dt %>" class="input2" readonly></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
						<td width="90">Return SCC</td>
						<td width="570"><input type="text" name="rtrn_loc" caption="Return SCC" style="width:60;text-align:center;ime-mode:disabled;" value="" class="input" maxlength="5" dataformat="engup">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btns_search" width="19" height="20" border="0" align="absmiddle">
							<input type="text" name="n1st_ref_ofc_cd" style="width:50;text-align:center;" value="" class="input" maxlength="5" dataformat="engup">
							<input type="text" name="n2nd_ref_ofc_cd" style="width:50;text-align:center;" value="" class="input" maxlength="5" dataformat="engup">
							<input type="text" name="n3rd_ref_ofc_cd" style="width:50;text-align:center;" value="" class="input" maxlength="5" dataformat="engup">
							<input type="text" name="n4th_ref_ofc_cd" style="width:50;text-align:center;" value="" class="input" maxlength="5" dataformat="engup">
						</td>
					<td width="110">Currency</td>
					<td width=""><input type="text" name="curr_cd" caption="Currency" style="width:58;text-align:center;" value="" class="input" maxlength="3" dataformat="engup">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btns_search2" width="19" height="20" border="0" align="absmiddle"></td>

				</tr>
				</table>

			</td></tr>
		</table>
	<!-- Tab BG Box  (S) -->
	<table class="height_8"><tr><td></td></tr></table>
		<table class="search" id="mainTable">
       		<tr><td class="bg" style="height:415" valign="top">

			<!-- Grid  (S) -->
			<table width="100%"  id="sheetTable">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table>
			<!-- Grid (E) -->

			<!--  Button_Sub (S) -->
			<table width="100%" class="button">
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_RowAdd">Row&nbsp;Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Delete">Row&nbsp;Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->

	    	<table class="height_8"><tr><td></td></tr></table>


				<table class="grid2" border="0" style="width:100%;">
				<tr>
					<td class="tr2_head" width="95">Remark(s)</td>
					<td><textarea name="diff_rmk" caption="Remarks" rows="5" style="width:100%;height:70;"></textarea></td>
				</tr>
				</table>
	    </td></tr>
		</table>
	<!--biz page (E)-->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;">
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
		</td></tr>
		</table>
    <!--Button (E) -->
	</td></tr>
</table>
	</td></tr>
</table>
<script language="javascript">ComUploadObject('upload1', '<%=session.getId()%>');</script>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>