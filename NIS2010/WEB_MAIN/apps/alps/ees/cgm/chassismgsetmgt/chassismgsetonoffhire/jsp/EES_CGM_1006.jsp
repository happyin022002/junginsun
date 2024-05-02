<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : ees_cgm_1006.jsp
	 *@FileTitle : Chassis Registration Inquiry/Update
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2013.07.09
	 *@LastModifier : 조경완
	 *@LastVersion : 1.0
	 * 2009.05.29 박의수
	 * 1.0 Creation
	 * --------------------------------------------------------
	 * History
	 * 2012.07.09 김창헌 [CHM-201218594-01] Enter나 Retrieve 하지 않고 자동적으로 조회되게 수정
	 * 2013.07.09 조경완 [CHM-201325340-01] Role Hard Coding 제거 및 대체 기능 개발
	 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event.EesCgm1006Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%>
<%@ page import="com.hanjin.syscommon.common.util.UserRoleUtil" %>
<%@ page import="com.hanjin.syscommon.common.table.ComUsrRoleVO" %>

<%
	EesCgm1006Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String tRole = "Authenticated"; //Transaction Role //chungpa 20100304 transaction role apply
	
	Logger log = Logger.getLogger("com.hanjin.apps.ChassisMgsetMgt.ChassisMgsetOnOffhire");
	String xml = HttpUtil.makeXML(request,response);
	
	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EesCgm1006Event) request.getAttribute("Event");
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
<title>Chassis Registration Inquiry/Update</title>
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
<form name="form2">
<input type="hidden" name="sXml" value="<%=xml.replace("\"","'")%>">
</form>
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- 개발자 작업	-->

<input type="hidden" name="eq_knd_cd" value = "Z">
<input type="hidden" name="eq_no_tmp">
<input type="hidden" name="chss_als_no">
<input type="hidden" name="chss_rgst_lic_noa">
<input type="hidden" name="trole" value="<%=tRole%>">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top: 2; padding-left: 5;">
	<tr>
		<td valign="top">
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
            <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
            <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->
		<!--biz page (S)-->
		<table class="search">
			<tr>
				<td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="70">Chassis No.</td>
						<td width="180">
							<input type="text" style="ime-mode:disabled;width: 80;" class="input" maxlength="10" dataformat="engup" name="eq_no_fm">&nbsp;-&nbsp;<input type="text" style="ime-mode:disabled;width: 60;" class="input" maxlength="6"  dataformat="isnum" name="eq_no_to">
						</td>
						<td width="70">License No.</td>
						<!-- <td width="230">  -->
						<td width="140">
							<input type="text" style="ime-mode:disabled;width: 100;" class="input" maxlength="12" dataformat="eng" name="chss_rgst_lic_no">&nbsp;
							<!-- 
							-&nbsp;<input type="text" style="ime-mode:disabled;width: 100;" class="input" maxlength="12" name="chss_rgst_lic_noa">
							 -->
						</td>
						<td width="90">Vehicle ID No.</td>
						<td width="160">
							<input type="text" style="ime-mode:disabled;width: 130;" class="input" maxlength="20" dataformat="eng" name="chss_veh_id_no">
						</td>
						<td width="70">Expire Year</td>
						<td width="">
							<input type="text" name="chss_rgst_exp_dt" dataformat="int"  maxlength="4"  style="width:50;text-align:center;" class="input" value="">&nbsp;and older
						</td>
						
						
						
					</tr>
				</table>

				<!--  biz_1   (E) -->
				<table class="line_bluedot">
					<tr>
						<td colspan="6"></td>
					</tr>
				</table>
				<!--  biz_2 (S) -->
				
				<!-- Grid  (S) -->
				<table width="100%" id="mainTable">
					<tr>
						<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script>
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
										<td class="btn2" name="btn_add">Row&nbsp;Add</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>

								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_del">Row Delete</td>
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
				<!--  biz_3   (E) -->
				</td>
			</tr>
		</table>


		<!--biz page (E)-->
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 5; , padding-bottom: 0;">
			<tr>
				<td class="btn1_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_retrieve" id="btn_Retrieve">Retrieve</td>
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
		</td>
	</tr>
</table>

<!-- 개발자 작업  끝 -->

</form>
</body>
</html>
