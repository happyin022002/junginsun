<%
/*=========================================================
 *Copyright(c) 2013 CyberLogitec
 *@FileName : EES_CGM_1201.jsp
 *@FileTitle : Exception List Creation and Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2013.03.08
 *@LastModifier : 이영헌
 *@LastVersion : 1.0
 * 2013.03.08 이영헌
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
<%@ page import="com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.event.EesCgm1201Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%>
<%@ page import="com.hanjin.syscommon.common.util.UserRoleUtil" %>
<%@ page import="com.hanjin.syscommon.common.table.ComUsrRoleVO" %>

<%
	EesCgm1201Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt");

	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesCgm1201Event)request.getAttribute("Event");
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
<title>Exception List Creation and Inquiry</title>
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
<input type="hidden" name="ofc_cd">
<input type="hidden" name="rhq_cd">
<input type="hidden" name="cust_grp_id">
<input type="hidden" name="cust_grp_nm">
<input type="hidden" name="chk_cust_cd">
<input type="hidden" name="cust_nm">
<input type="hidden" name="chk_dup">
<input type="hidden" name="chk_sc_no">
<input type="hidden" name="chk_eff_yrmon">
<input type="hidden" name="chk_loc_cd">
<input type="hidden" name="scc_cd">
<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top: 2; padding-left: 5;">
	<tr>
		<td valign="top">
		
<!--Page Title, Historical (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
	<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
	<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
</table>

<!--Page Title, Historical (E)-->
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
								<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td>
						<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_new">New</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td class="btn1_line"></td>
					<td>
						<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_save">Save</td>
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
<!--biz page (S)-->
	<table class="search" id="mainTable">
		<tr>
			<td class="bg">
			<!--  biz_1  (S)  -->
			<table width="100%" class="search">
				<tr class="h23">
					<td width="75">EFF.Month</td>
					<td width="120" ><input type="text" style="width:80;ime-mode:disabled" class="input" value="" name="eff_yrmon" maxlength="6" dataformat="ym">
					<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar1"></td>
					<td width="55">S/C No.</td>
					<td width="135" ><input type="text" style="width:120;text-align:disabled" class="input" dataformat="engup" maxlength="20" value="" name="sc_no"></td>
					<td width="100">Contract Office</td>
					<td width="85" ><input type="text" style="width:70;text-align:disabled" class="input" dataformat="engup" maxlength="6" value="" name="ctrt_ofc_cd"></td>
					<td width="100">Creation Office</td>
					<td width="" ><input type="text" style="width:70;text-align:disabled" class="input" dataformat="engup" maxlength="6" value="" name="cre_ofc_cd"></td>
				</tr>
			</table>
			<!-- Grid  (S) -->
			<table width="100%" id="mainTable">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
						<div style="display: none;"><script language="javascript">ComSheetObject('sheet2');</script></div>
					</td>
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
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_RowAdd">Row&nbsp;Add</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
							</td>
							<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_RowDel">Row Delete</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
							</td>
							<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_loadexcel">Load Excel</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
							</td>
							<td>
                                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                    <tr>
                                        <td class="btn2_left"></td>
                                        <td class="btn2" name="btn_downexcel">Down Excel</td>
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
			<!--  biz_1  (E)  -->
			</td>
		</tr>
	</table>
	</td>
	</tr>
</table>
<!--biz page (E)-->

<!-- 개발자 작업  끝 -->
 </form>
</body>
</html>