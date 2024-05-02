﻿<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName       : ESM_SQM_0215.jsp
*@FileTitle      : QTA Set up by Head Office for IAS Sector_Add Freezing
*Open Issues     :
*Change history  :
*@LastModifyDate : 2014.01.23
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2014.01.23 SQM USER
* 1.0 Creation
* 2014.08.25 이혜민 [CHM-201431601] 팝업 오픈시 부모창 조회조건을 자동세팅하도록 수정
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.sqm.planning.planning.event.EsmSqm0215Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	String p_bse_tp_cd   = JSPUtil.getParameter(request, "f_bse_tp_cd", "");
	String p_bse_yr      = JSPUtil.getParameter(request, "f_bse_yr", "");
	String p_bse_qtr_cd  = JSPUtil.getParameter(request, "f_bse_qtr_cd", "");
	String p_c_cnt 		 = JSPUtil.getParameter(request, "f_c_cnt", "");
	String p_sub_trd_cd  = JSPUtil.getParameter(request, "f_sub_trd_cd", "");
	String p_ias_rgn_cd  = JSPUtil.getParameter(request, "f_ias_rgn_cd", "");
	String p_rlane_cd    = JSPUtil.getParameter(request, "f_rlane_cd", "");
	
	EsmSqm0215Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.planning.planning");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmSqm0215Event)request.getAttribute("Event");
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
<title>QTA Set up by Head Office for IAS Sector_Add Freezing</title>
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
<input type="hidden" name="p_bse_tp_cd" value="<%= p_bse_tp_cd%>">
<input type="hidden" name="f_c_cnt" value="<%= p_c_cnt%>"> 
<input type="hidden" name="f_ias_sctr_flg" value="Y">
<input type="hidden" name="f_add_flg" value="Y"> <!--  SQM_CFM_QTA 데이터 싱크할 때 사용-->
<input type="hidden" name="p_sub_trd_cd" value="<%= p_sub_trd_cd%>">
<input type="hidden" name="p_ias_rgn_cd" value="<%= p_ias_rgn_cd%>">
<input type="hidden" name="p_rlane_cd"   value="<%= p_rlane_cd%>">
<!-- 개발자 작업	-->

<!-- Outer Table (S)-->
<table width="850" class="popup" cellpadding="10" border="0">
	<tr><td class="top"></td></tr>
	<tr>
		<td valign="top">
			<!-- : ( Title ) (S) -->
			<table width="850" border="0">
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;&nbsp;QTA Set up by Head Office for IAS Sector_Add Freezing</td></tr>
			</table>
			<!-- : ( Title ) (E) -->

			<!-- TABLE '#D' : ( Search Options ) (S) -->
			<table class="search" width="850" border="0">
				<tr>
					<td class="bg">
						<table >
							<tr>
								<td width="105" rowspan="2">
									<table class="search_sm2" width="95">
										<tr class="h23"><td><input type="radio" name="f_bse_tp_cd" class="trans" value="Y" disabled><label style="padding-left:2;">Yearly</label></td></tr>
										<tr class="h23"><td><input type="radio" name="f_bse_tp_cd" class="trans" value="Q" disabled><label style="padding-left:2;">Quarterly</label></td></tr>
									</table>
								</td>
								<td width="">
									<table class="search" border="0">
										<tr class="h23">
											<td width="75">Year</td>
											<td width="85"><input type="text" name="f_bse_yr" style="width:70;text-align:center;ime-mode:disabled;" readonly class="input2" value="<%= p_bse_yr%>"></td>
											<td width="80"><div id="div_qtr">Quarter</div></td>
											<td width="90"><input type="text" name="f_bse_qtr_cd" style="width:70;text-align:center;ime-mode:disabled;" readonly class="input2" value="<%= p_bse_qtr_cd%>"></td>
											<td width="" class='sm' colspan="2"><div id="div_period"></div></td>
										</tr>
										<tr class="h23">
											<td width="77">Sub Trade</td>
											<td width="83"><script language="javascript">ComComboObject('f_sub_trd_cd', 1, 70, 1, 1)</script></td>
											<td width="82">IAS Region</td>
                                            <td width="90"><script language="javascript">ComComboObject('f_ias_rgn_cd', 1, 85, 1, 0)</script></td>
											<td width="60">R/Lane</td>
											<td width=""><script language="javascript">ComComboObject('f_rlane_cd', 1, 70, 1, 1)</script></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<!-- TABLE '#D' : ( Search Options ) (E) -->

			<table class="height_10"><tr><td></td></tr></table>

			<!-- TABLE '#D' : ( Search Options ) (S) -->
			<table width="850" class="search" border="0">
				<tr>
					<td class="bg_b1">
						<table width="850" border="0" class="height_10"><tr><td></td></tr></table>
						<!-- : ( POR ) (S) -->
						<table width="850" border="0" id="mainTable">
							<tr>
								<td><script language="javascript">ComSheetObject('sheet1');</script></td>
							</tr>
						</table>
						<!-- : ( POR ) (E) -->
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>

<table width="850" class="height_5"><tr><td></td></tr></table>

<!-- : ( Button : pop ) (S) -->
<table width="900" class="sbutton">
	<tr>
		<td height="71" class="popup">
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
				<tr>
					<td class="btn3_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<!-- Repeat Pattern -->
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Freezing" id="btn_Freezing">Freezing</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td class="btn1_line"></td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Close" id="btn_Close">Close</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<!-- Repeat Pattern -->
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>