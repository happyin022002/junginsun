<%
/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : ESM_SQM_0601.jsp
*@FileTitle      : KPI Upload
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.07.30
*@LastModifier   : 이혜민
*@LastVersion    : 1.0
* 2013.07.30 이혜민
* 1.0 Creation
* 2015.04.15 김용습 [CHM-201535206] KPI Management "Week" 조건 추가
* 2015.04.27 김용습 [CHM-201535626] (SQM) TPS 자리수 Validation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.sqm.keyaccountkpi.keyaccountkpi.event.EsmSqm0601Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSqm0601Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.specialkpi.planning");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmSqm0601Event)request.getAttribute("Event");
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
<title>KPI Upload</title>
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
<input type="hidden" name="dataCnt">
<!-- 개발자 작업	-->

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
	<tr>
		<td>
			<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
			<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->
			
			<!--Button_L (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr>
					<td class="btn1_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<!-- Repeat Pattern -->
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" id="btn_Retrieve" name="btn_Retrieve">Retrieve</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td class="btn1_line"></td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" id="btn_Save" name="btn_Save">Save</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" id="btn_DownExcel" name="btn_DownExcel">Down Excel</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" id="btn_LoadExcel" name="btn_LoadExcel">Load Excel</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<div id="div_1QTransfer" style="display:none">
										<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr>
												<td class="btn1_left"></td>
												<td class="btn1" id="btn_1qTransfer" name="btn_1qTransfer">1Q Transfer</td>
												<td class="btn1_right"></td>
											</tr>
										</table>
									</div>
								</td>

								<!-- Repeat Pattern -->
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<!--Button_L (E) -->
		
			<!-- TABLE '#D' : ( Search Options ) (S) -->
			<table class="search" width="100%">
				<tr>
					<td class="bg">
						<table class="search_in"  width="100%" >
							<tr>
								<td width="105" rowspan="2">
									<table class="search_sm2" width="95">
										<tr class="h23">
											<td><input type="radio" name="f_bse_tp_cd" class="trans" value="Y" ><label style="padding-left:2;">Yearly</label></td>
										</tr>
										<tr class="h23">
											<td><input type="radio" name="f_bse_tp_cd" class="trans" value="Q" checked><label style="padding-left:2;">Quarterly</label></td>
										</tr>
									</table>
								</td>
								<td>
									<table class="search" border="0">
										<tr class="h23">
											<td width="50">Year</td>
											<td width="85"><script language="javascript">ComComboObject('f_bse_yr', 1, 73, 1, 1)</script></td>
											<td width="55"><div id="div_qtr">Quarter</div></td>
											<td width="85"><script language="javascript">ComComboObject('f_bse_qtr_cd', 1, 70, 1, 1)</script></td>
											<td width="160" class='sm'><div id="div_period"></div></td>
											<td width="105">Account Group</td>
											<td width="115"><script language="javascript">ComComboObject('f_acct_tgt_cd', 1, 100, 1)</script></td>
											<td width="110">Group Customer</td>
											<td><script language="javascript">ComComboObject('f_cust_grp_id', 2, 100, 1)</script></td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td>
									<table class="search" border="0">
										<tr class="h23">
											<td width="48">Week</td>
											<td width="87">
												<script language="javascript">ComComboObject('f_to_wk', 1, 50, 0)</script>
											</td>
											<td width="55">Trade</td>
											<td width="85"><script language="javascript">ComComboObject('f_trd_cd', 1, 70, 1)</script></td>
											<td width="45">Bound</td>
											<td width="115"><script language="javascript">ComComboObject('f_conv_dir_cd', 1, 70, 1)</script></td>
											<td width="105"><!-- Month --></td>
											<td width="115">
												<!-- <input type="text" style="width:27;text-align:center;" class="input" size="3" maxlength="2"  onKeyPress='ComKeyOnlyNumber(window);' name="f_fm_mon">
													~&nbsp;
													<input type="text" style="width:27;text-align:center;" class="input" size="3"  onKeyPress='ComKeyOnlyNumber(window);' maxlength="2" name="f_to_mon"> -->
											</td>
											<td width="110"><!-- Sub Trade --></td>
											<td><!-- <script language="javascript">ComComboObject('f_sub_trd_cd', 1, 70, 1)</script> -->&nbsp;</td>
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
			<table class="search" border="0">
				<tr>
					<td class="bg_b1">
						<table class="height_10"><tr><td></td></tr></table>
						
						<table width="100%" class="search">
							<tr>
								<td width="500"><font color="blue" >[ Contract ONLY ]</font></td>
								<td style="text-align:right;">[Unit : TEU, TEU/$, $]</td>
							</tr>
						</table>
						<!-- : ( POR ) (S) -->
						<table width="100%" id="mainTable">
							<tr>
								<td><script language="javascript">ComSheetObject('sheet1');</script></td>
							</tr>
						</table>
						<!-- : ( POR ) (E) -->
					</td>
				</tr>
			</table>
			<!-- TABLE '#D' : ( Search Options ) (E) -->
		</td>
	</tr>
</table>
<!-- Outer Table (E)-->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>