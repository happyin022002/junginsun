<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0072.jsp
*@FileTitle : Cut-off VVD Entry for New A/R Office
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.05
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2009.06.05 한동훈
* 1.0 Creation
* --------------------------------------------------------
* History
* 2010.09.07 최도순 [CHM-201005726] ALPS > Cut Over VVD Creation for New A/R Office 보완 요청
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.event.FnsInv0072Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsInv0072Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.AccountReceivableInvoiceMasterDataMgt.GeneralARInvoiceMasterDataMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (FnsInv0072Event)request.getAttribute("Event");
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
<title>Cut-off VVD Entry for New A/R Office</title>
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
<input type="hidden" name="pagetype" value = "I">
<input type="hidden" name="old_ar_ofc_cd">
<input type="hidden" name="new_ar_ofc_cd">
<input type="hidden" name="slan_cd">
<input type="hidden" name="port_cd">
<input type="hidden" name="vsl_cd">
<input type="hidden" name="skd_voy_no">
<input type="hidden" name="skd_dir_cd">
<input type="hidden" name="io_bnd_cd">
<input type="hidden" name="ar_ofc_cd_all">

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
		<!--Page Title, Historical (E)--> <!--biz page (S)-->
		<table class="search">
			<tr>
				<td class="bg"><!-- biz_1  (S) -->
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="80">A/R Office</td>
						<td class="stm" width="20">Old</td>
						<td width="145"><!--
						<select style="width:117;" class="input1">
						<option value="0" selected>SYDBA</option>
						<option value="1"></option>
						</select>
						--> <script language="javascript">ComComboObject('old_ar_ofc_cd2', 2, 110, 0, 1, 0, true);</script>
						</td>
						<td class="stm" width="30">New</td>
						<td><!-- 
						<select style="width:117;" class="input1">
						<option value="0" selected>SYDBB</option>
						<option value="1"></option>
						</select>
						--> <script language="javascript">ComComboObject('new_ar_ofc_cd2', 2, 110, 0, 1, 0, true);</script>
						</td>
					</tr>
				</table>
				<!-- biz_1 (E) -->
				<table class="height_8">
					<tr>
						<td></td>
					</tr>
				</table>
				<!-- Grid (S) -->
				<table width="100%" id="mainTable">
					<tr>
						<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) --> <!--  Button_Sub (S) -->
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
										<td class="btn2" name="btn_RowCopy">Row Copy</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0"
									class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_Delete">Row&nbsp;Delete</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>

							</tr>
						</table>
						</td>
					</tr>
				</table>
				<!-- Button_Sub (E) --></td>
			</tr>
		</table>
		<!-- Tab BG Box(E) --> <!--biz page (E)--> <!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0"
			cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
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
						<table width="72" border="0" cellpadding="0" cellspacing="0"
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
						<table width="72" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Save">Save</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_DownExcel">Down Excel</td>
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

<!-- 개발자 작업  끝 --></form>
</body>
</html>