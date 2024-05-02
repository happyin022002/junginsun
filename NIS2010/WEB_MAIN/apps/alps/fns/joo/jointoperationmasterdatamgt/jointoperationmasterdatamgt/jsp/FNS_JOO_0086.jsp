<%
	/*=========================================================
	 *Copyright(c) 2011 CyberLogitec
	 *@FileName : fns_joo_0086.jsp
	 *@FileTitle : Add Carriers POP UP화면
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2012.01.04
	 *@LastModifier : 김영오
	 *@LastVersion : 1.0
	 * 2012.01.04 김영오
	 * 1.0 Creation
	 =========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.event.FnsJoo0086Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	FnsJoo0086Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	
	String crrCdList = "";
	String trdLaneCrrList = "";

	String csrNo = StringUtil.xssFilter(request.getParameter("csrNo"));
	String joRefNo = StringUtil.xssFilter(request.getParameter("jo_ref_no"));
	if (csrNo == null) {
		csrNo = "";
	}
	if (joRefNo == null) {
		joRefNo = "";
	}

	Logger log = Logger.getLogger("com.hanjin.apps.JointOperationAgreementSettlement.JointOperationConsultation");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (FnsJoo0086Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

//bkgNo = event.getCopInquiryVO().getBkgNo(); jo_ref_no


		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		crrCdList      = eventResponse.getETCData("CRR_CD_LIST");
		trdLaneCrrList = eventResponse.getETCData("TRD_LANE_CRR_LIST");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>CSR Approval - CSR Details POP UP화면</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
var gCrrCd = "<%=crrCdList%>";
var gTrdLaneCrr = "<%=trdLaneCrrList%>";
var gJoSrcCd = ("<%=crrCdList%>").split("|");
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="save_chk">
<input type="hidden" name="add_chk">
<input type="hidden" name="old_jo_crr_cd2">
<input type="hidden" name="old_jo_crr_cd3">
<input type="hidden" name="pagerows"> <!-- 개발자 작업	--> <!-- OUTER - POPUP (S)tart -->
<input type="hidden" name="jo_ref_no" value="<%=joRefNo%>"> <!--2012.06.04-->
<table width="100%" class="popup" cellpadding="10" border="0">
	<tr>
		<td class="top"></td>
	</tr>
	<tr>
		<td valign="top"><!-- : ( Title ) (S) -->
		<table width="100%" border="0">
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Sub Carriers</td>
			</tr>
		</table>
		<!-- : ( Title ) (E) --> <!-- : ( Search Options ) (S) --> <!--biz page (S)-->
		<!--table class="search">
			<tr>
				<td class="bg">//biz_1  (S)
				<table class="search" border="0" style="width: 797;">
					<tr class="h23">
						<td width="35">Lane</td>
						<td width="100"><script language="javascript">ComComboObject('rlane_cd',1,80,0,0);</script></td>
						<td width="75">Rep. Carrier</td>
						<td width=""><script language="javascript">ComComboObject('jo_crr_cd',1,55,0,0);</script></td>
					</tr>
				</table>

				//biz_1   (E)</td>
			</tr>
		</table-->

		<table class="height_10">
			<tr>
				<td></td>
			</tr>
		</table>

		<!-- Tab BG Box  (S) -->
		<table class="search">
			<tr>
				<td class="bg"><!-- : ( Grid ) (S) -->
				<table width="100%" id="mainTable" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td width="100%"><!--시트--> <script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				
				<table width="100%"  id="mainTable" style="display:none">
	                 <tr>
	                     <td width="100%" id="mainTable">
	                         <script language="javascript">ComSheetObject('sheet2');</script>
	                     </td>
	                 </tr>
	             </table>
				<table width="100%"  id="mainTable" style="display:none">
	                 <tr>
	                     <td width="100%" id="mainTable">
	                         <script language="javascript">ComSheetObject('sheet3');</script>
	                     </td>
	                 </tr>
	             </table>
				<!-- : ( Grid ) (E) --> <!-- Grid  (S) --> <!-- Grid (E) --></td>
			</tr>
		</table>
		<!-- Tab BG Box  (S) --> <!-- : ( Button : pop ) (S) -->
		<table width="100%" class="button">
			<tr>
				<td class="btn1_bg">
				<table border="1" cellpadding="0" cellspacing="0">					
					<!--td>
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn2_left"></td>
							<td class="btn2" id="btns_add" name="btns_add" auth="C">Row Add</td>
							<td class="btn2_right"></td>
						</tr>
					</table>
					</td>
					<td>
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn2_left"></td>
							<td class="btn2" id="btns_insert" name="btns_insert" auth="C">Row Insert</td>
							<td class="btn2_right"></td>
						</tr>
					</table>
					</td>
					<td>
					<table width="" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn2_left"></td>
							<td class="btn2" id="btns_del" name="btns_del" auth="C">Row Delete</td>
							<td class="btn2_right"></td>
						</tr>
					</table>
					</td-->

					
					<td>
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_save">Save</td>
							<td class="btn1_right"></td>
						</tr>
					</table>
					</td>
					<td>
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_Close">Close</td>
							<!--td class="btn1" name="btn_downexcel">Down Excel</td-->
							<td class="btn1_right"></td>
						</tr>
					</table>
					</td>

				</table>
				</td>
			</tr>
		</table>

		<!-- Tab BG Box  (S) --> <!--Button (S) -->
		<!--table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
			<tr>
				<td class="btn1_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_retrieve">Retrieve</td>
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
						<td>
						<td width="72"></td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_save">Save</td>
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
					</tr>
				</table>
				</td>
			</tr>
		</table-->
		</td>
	</tr>
</table>

<!--table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup">
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
			<tr>
				<td class="btn3_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td width="72">
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Close">Close</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		</td>
	</tr>
</table-->
<!-- : ( Button : pop ) (E) --> <!-- 개발자 작업  끝 --></form>
</body>
</html>