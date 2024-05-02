<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : cps_gem_0008_03.jsp
	 *@FileTitle : Expense Office Maintenance - Office Matrix per Office
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.05.27
	 *@LastModifier : 최정미
	 *@LastVersion : 1.0
	 * 2009.05.27 최정미
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
<%@ page import="com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.event.CpsGem000803Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	CpsGem000803Event event = null;			//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	
	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.hanjin.apps.TimeCharterInOutAccounting.TCharterIOBunkerRegister");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
		event = (CpsGem000803Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
				
	} catch(Exception ex) {
		log.error("err " + ex.toString(), ex);
		//out.println(e.toString());
	}
%>
<html>
<head>
<title>Expense Office Maintenance - Office Matrix per Office</title>
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
<form name="form">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows"> 

<!-- 개발자 작업 -->
<input type="hidden" name="sch_expn_group">

<!-- Search (S) -->
<table class="search">
	<tr>
		<td class="bg">
				
		<!--  biz_3  (S) -->
		<table class="search" border="0" style="width: 100%">
			<tr class="h23">
				<td width="25%">
				<table class="search_sm2" border="0" style="width: 93%;">
					<tr class="h23">
						<td>
							<input type="radio" value="Y" class="trans" name="sch_office_gbn" id="sch_office_gbn1" onclick="isOfficeGubun(this.value);">Office&nbsp;
							<input type="radio" value="N" class="trans" name="sch_office_gbn" id="sch_office_gbn2" onclick="isOfficeGubun(this.value);">Expense&nbsp;
							<input type="text" style="width: 70; text-align: center" class="input" name="sch_office_code" disabled="disabled" maxlength="6" style="ime-mode:disabled">
						</td>
					</tr>
				</table>
				</td>
				<td width="20%">
				<table class="search_sm2" border="0" style="width: 93%;">
					<tr class="h23">
						<td nowrap="nowrap">Expense Group</td>
						<td nowrap="nowrap"><script language="javascript">ComComboObject("combo1", 2, 75, 0, 0, 0, true);</script></td>
					</tr>
				</table>
				</td>
				<td width="10%" nowrap="nowrap">
				<table class="search_sm2" border="0" style="width: 93%;">
					<tr class="h23">
						<td>
							<input type="radio" value="K" class="trans" name="sch_lang" onclick="isLangCheck(this);" checked>KOR&nbsp;&nbsp;&nbsp;
							<input type="radio" value="E" class="trans" name="sch_lang" onclick="isLangCheck(this);">ENG
						</td>								
					</tr>
				</table>
				</td>
				<td width="15%" align="right">Deleted Data<input type="checkbox" value="Y" class="trans" name="sch_delt_flg" onclick="isDeltFlg(this);"></td>
				<td width="">&nbsp;</td>
			</tr>
		</table>
	
		<table class="line_bluedot">
			<tr>
				<td colspan="6"></td>
			</tr>
		</table>
	
		<!-- Grid  (S) -->
		<table width="100%" id="mainTable">
			<tr>
				<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script></td>
			</tr>
		</table>
		<!-- Grid (E) --> 
		
		<!--  Button_Sub (S) -->
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
								<td class="btn2" name="btn_RowAdd">Row&nbsp;Add</td>
								<td class="btn2_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn2_left"></td>
								<td class="btn2" name="btn_RowDelete">Row&nbsp;Delete</td>
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
		<!--  biz_3   (E) -->
		</td>
	</tr>
</table>
<!-- Search (E) --> 

<!--Button (S) -->
<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
	<tr>
		<td class="btn1_bg">
		<table border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td>
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr>
						<td class="btn1_left"></td>
						<td class="btn1" name="btn_Retrieve">Retrieve</td>
						<td class="btn1_right"></td>
					</tr>
				</table>
				</td>
				<td>
				<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr>
						<td class="btn1_left"></td>
						<td class="btn1" name="btn_New">New</td>
						<td class="btn1_right"></td>
					</tr>
				</table>
				</td>
				<td class="btn1_line"></td>

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
						<td class="btn1" name="btn_DownExcel">Down Excel</td>
						<td class="btn1_right"></td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		</td>
	</tr>
</table>
<!--Button (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>