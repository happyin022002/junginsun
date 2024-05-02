<%
/*=========================================================
 * Copyright(c) 2006 CyberLogitec
 * @FileName : ESM_BSA_0028.jsp
 * @FileTitle : Slot Price Creation/Update
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2007-01-18
 * @LastModifier : Kim Jong Beom
 * @LastVersion : 1.0
 *  2007-01-18 Kim Jong Beom
 *  1.0 최초 생성
 =========================================================
 * History :
 * 2008.05.07 PEJ R200804296325 css 파일 참조 확인 및 수정 요청
 *                -Script처리시 프로세스바 표현
 * 2009.05.21 김종열 N200904020151 Legacy 전환 요건 협의 결과 요청사항 ( JOO vs BSA)
 * 2009.08.24 남궁진호ALPS 전환 ESM_BSA_0028.js (1.0 Creation)
 * 2010.10.04 이행지 [CHM-201005758-01] BSA  Architecture 위배사항 수정 (CommonSC)
 * 2011.04.04 이관샨 [CHM-201109933-01] 화면상 불필요한 선 정리 
 * 2011.07.18 이행지 [CHM-201112101-01] Currency 항목 추가
 * 2014.07.02 김용습 R4J 패치 사전 작업
 * 2015.01.23 김용습 [CHM-201533808] Check Date 버튼 추가
 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%>
<%@ page
	import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page
	import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page
	import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bsa.common.vo.CommonBsaRsVO"%>
<%@ page
	import="com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.event.EsmBsa0028Event"%>
<%@ page
	import="com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.SearchBsaCrrRgstListVO"%>
<%@ page import="org.apache.log4j.Logger"%>


<%
	EsmBsa0028Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = "";
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String headSet = "";
	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger
			.getLogger("com.hanjin.apps.BSAManage.BSAManage");

	int trdCnt = 0;
	List<SearchBsaCrrRgstListVO> list = null;
	SearchBsaCrrRgstListVO vo = null;

	String bsa_op_jb_cd = "";
	String bsa_op_jb_nm = "";
	String crr_cd = "";
	
	int head_cnt = 0;
	String xml = "";
	
	//2014.07.02 김용습 R4J 패치 사전 작업
	StringBuffer out1 = new StringBuffer();
	StringBuffer out2 = new StringBuffer();

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBsa0028Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		} else {
			// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
			GeneralEventResponse eventResponse = (GeneralEventResponse) request
					.getAttribute("EventResponse");
			CommonBsaRsVO commonVO = (CommonBsaRsVO) (eventResponse
					.getCustomData("rtnVo"));
			list = (List<SearchBsaCrrRgstListVO>) commonVO
					.getResultVOList();
			headSet = commonVO.getStrTemp();
			rowCount = list.size();

			for (int j = 0; j < rowCount; j++) {
				vo = (SearchBsaCrrRgstListVO) list.get(j);				
				
				//2014.07.02 김용습 R4J 패치 사전 작업
				//bsa_op_jb_cd = bsa_op_jb_cd + "|" + vo.getBsaOpJbCd();
				
				out1.append("|").append(vo.getBsaOpJbCd());
				
				if (vo.getBsaOpJbCd().equals("001")) {
					bsa_op_jb_nm = bsa_op_jb_nm + "|"
							+ vo.getBsaOpJbNm();
					;
				} else {
					bsa_op_jb_nm = bsa_op_jb_nm + "|"
							+ vo.getBsaOpJbNm();
				}
				//2014.07.02 김용습 R4J 패치 사전 작업
				//crr_cd = crr_cd + "|" + vo.getCrrCd();
				
				out2.append("|").append(vo.getCrrCd());

			}
			bsa_op_jb_cd = out1.toString();
			crr_cd = out2.toString();
			
		} // end else
		//추가----------------------------------------------------------------------------------------- END

		xml = HttpUtil.makeXML(request, response);
		xml = xml.replaceAll("\"", "'");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<%-- = ibTrade --%>
<%--= crr_cd --%>
<%--= headSet--%>
<html>
<head>
<title>Inquire/Edit Slot-Cost</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage() {
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if

		loadPage("<%=bsa_op_jb_nm%>","<%=crr_cd%>","<%=headSet%>");
		document.form.txtSDate.focus();
	}
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0"
	onload="javascript:setupPage();">
<iframe height="0" width="0" name="frmHidden" id="frmHidden"></iframe>

<form method="post" name="form" onSubmit="return false;"
	onKeyDown="ComKeyEnter();"><input type="hidden" name="f_cmd">
<input type="hidden" name="iPage"> <input type="hidden"
	name="param1"> <!-- Gubun   |  Method Name  --> <input
	type="hidden" name="param2"> <!-- Year    |  vsl_cd       --> <input
	type="hidden" name="param3"> <!--         |  skd_voy_no   --> <input
	type="hidden" name="param4"> <!--         |  dir_cd       --> <input
	type="hidden" name="param5"> <!-- sMonth  |               --> <input
	type="hidden" name="param6"> <!-- eMonth  |               --> <input
	type="hidden" name="param7"> <!-- sWeek   |               --> <input
	type="hidden" name="param8"> <!-- eWeek   |               --> <input
	type="hidden" name="head_cnt" value="<%=head_cnt%>"> <input
	type="hidden" name="bsa_op_jb_cd" value="<%=bsa_op_jb_cd%>"> <input
	type="hidden" name="bsa_op_jb_nm" value="<%=bsa_op_jb_nm%>"> <input
	type="hidden" name="crr_cd" value="<%=crr_cd%>"> <input
	type="hidden" name="header2" value="<%=headSet%>"> <input
	type="hidden" name="trdCnt" value="<%=trdCnt%>"> <input
	type="hidden" name="bsa_op_jb_cd_len" value=""> <!-- ALPS 변환중 추가 -->
<input type="hidden" name="crr_cd_len" value=""> <!-- ALPS 변환중 추가 -->
<input type="hidden" name="sXml" value="<%=xml%>"> <!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	class="bodypadding">
	<tr>
		<td><!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
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
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) --> <!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0"
			cellspacing="0" style="padding-bottom: 5;">
			<tr>
				<td class="btn1_bg">

				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<!-- Repeat Pattern -->
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>


						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_save" id="btn_save">Save</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_downexcel" id="btn_downexcel">Down
								Excel</td>
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
		<!-- TABLE '#D' : ( Button : Main ) (E) --> <!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search" border='0'>
			<tr>
				<td class="bg">

				<table class="search_in" border="0">
					<tr class="h23">
						<td width="55" style="text-indent: 7;">Period</td>
						<td width="250"><input class="input1" type="text"
							dataformat="ymd" name="txtSDate"
							style="width: 75; text-align: center; ime-mode: disabled;"
							maxlength="8" onKeyPress="ComKeyOnlyNumber(this, '-');"
							onKeyUp="ComKeyEnter('LengthNextFocus');"
							OnBeforeDeactivate="ComAddSeparator(this);"
							OnBeforeActivate="ComClearSeparator(this);"> <img
							name="btns_calendar1" src="/hanjin/img/button/btns_calendar.gif"
							class="cursor" width="19" height="20" border="0"
							align="absmiddle"> &nbsp;~&nbsp; <input class=""
							type="text" dataformat="ymd" name="txtEDate"
							style="width: 75; text-align: center; ime-mode: disabled;"
							maxlength="8" onKeyPress="ComKeyOnlyNumber(this, '-');"
							onKeyUp="ComKeyEnter('LengthNextFocus');"
							OnBeforeDeactivate="ComAddSeparator(this);"
							OnBeforeActivate="ComClearSeparator(this);"> <img
							name="btns_calendar2" src="/hanjin/img/button/btns_calendar.gif"
							class="cursor" width="19" height="20" border="0"
							align="absmiddle"></td>
						<td width="150" class="stm">(ETD of 1st Port)</td>

						<td width="40">Trade</td>
						<td width="100"><script language="javascript">ComComboObject('cobTrade', 1, 70 , 0 )</script></td>

						<td width="35">Lane</td>
						<td width="100">
						<div id="div_rLane"><script language="javascript">ComComboObject('cobLane', 1, 70 , 0 )</script></div>
						</td>

						<td width="30">Dir.</td>
						<td><script language="javascript">ComComboObject('cobDir', 1, 70 , 0 )</script></td>
						
						<td width="40">Curr.</td>
                        <td><script language="javascript">ComComboObject('cobCurr', 1, 60 , 0 )</script></td>
					</tr>
				</table>
				<table class="search_in" border="0">
					<tr>
						<td class="line_bluedot"></td>
					</tr>
				</table>
				<table class="search_in" border="0">
					<tr class="h23">
						<td width="50%"><input type="radio" name="rdoType"
							value="017" class="trans" onClick="changeSheet(this.value);"
							checked>Basic Slot Price &nbsp;&nbsp;&nbsp; <input
							type="radio" name="rdoType" value="018" class="trans"
							onClick="changeSheet(this.value);">Reefer Surcharge
						&nbsp;&nbsp;&nbsp; <input type="radio" name="rdoType" value="020"
							class="trans" onClick="changeSheet(this.value);">Over
						Used Surcharge &nbsp;&nbsp;&nbsp;</td>
						<td>Carriers with BSA only&nbsp;<input type="checkbox"
							name="isExcludZero" value="1" class="trans"></td>

					</tr>
				</table>

				</td>
			</tr>
		</table>

		<!-- TABLE '#D' : ( Search Options ) (E) -->
		<table class="height_10">
			<tr>
				<td></td>
			</tr>
		</table>


		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
			<tr>
				<td class="bg"><!-- : ( POR ) (S) -->
				<table width="100%" border="0">
					<tr height="12">
						<td width="100%" align="right" valign="bottom"
							style="padding-right: 1;">
						<div id="div_zoom_in" style="display: inline"><!-- absolute / relative -->
						<img class="cursor" src="/hanjin/img/bu_prev01.gif" width="20"
							height="11" border="0" name="bu_zoom_in" alt="Zoom in(+)">
						</div>
						<div id="div_zoom_out" style="display: none"><img
							class="cursor" src="/hanjin/img/bu_next01.gif" width="20"
							height="11" border="0" name="bu_zoom_out" alt="Zoom out(-)">
						</div>
						</td>
					</tr>

					<!-------------------------slot hire start---------------------------------------->
					<tr class="h23" id="tr_opt" style="display: none">
						<td colspan="2"><input type="radio" name="rdoType2" value="0"
							class="trans" onClick="changeSheet(this.value);" checked>Long
						Leg &nbsp;&nbsp;&nbsp; <input type="radio" name="rdoType2"
							value="1" class="trans" onClick="changeSheet(this.value);">Short
						Leg &nbsp;&nbsp;&nbsp;</td>
					</tr>
					<tr class="h23" id="tr_slot" style="display: inline">
						<td width="100%">

						<table width="100%" id="mainTable1">
							<tr>
								<td><script language="javascript">ComSheetObject('sheet1');</script></td>
							</tr>
						</table>

						</td>
					</tr>


					<!-------------------------slot hire end---------------------------------------->

					<!-- ----------------------rf chg start------------------------------------------>
					<!-- Legacy 전환 요건 협의 결과 요청사항 ( JOO vs BSA) -->

					<tr class="h23" id="tr_rf_l" style="display: none">
						<td width="100%">
						<table width="100%" id="mainTable2">
							<tr>
								<td><script language="javascript">ComSheetObject('sheet2');</script></td>
							</tr>
						</table>
						</td>
					</tr>
					<tr class="h23" id="tr_rf_s" style="display: none">
						<td width="100%">
						<table width="100%" id="mainTable3">
							<tr>
								<td><script language="javascript">ComSheetObject('sheet3');</script></td>
							</tr>
						</table>
						</td>
					</tr>
					<!-------------------------rf chg end------------------------------------------->

					<!-- ----------------------over used start------------------------------------------>

					<tr class="h23" id="tr_over_l" style="display: none">
						<td width="100%">
						<table width="100%" id="mainTable4">
							<tr>
								<td><script language="javascript">ComSheetObject('sheet4');</script></td>
							</tr>
						</table>
						</td>
					</tr>
					<tr class="h23" id="tr_over_s" style="display: none">
						<td width="100%">
						<table width="100%" id="mainTable5">
							<tr>
								<td><script language="javascript">ComSheetObject('sheet5');</script></td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				<!-- ----------------------over used end------------------------------------------>

				<!-- : ( Button : Sub ) (S) -->
				<table width="100%" class="button">
					<tr>
						<td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>

								<!-- Repeat Pattern -->
								<td id="td_checkdate_btn">
                       				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
						 					<td class="btn2_left"></td>
						 					<td class="btn2_3" id="btng_checkdate" name="btng_checkdate" title="A cell causing a date period overlap will turn red if you click this button.">Check Date</td>
						 					<td class="btn2_right"></td>
										</tr>
					   				</table>
					  			</td>
								<td id="td_rowadd_btn" style="display: none">
								<table width="100%" border="0" cellpadding="0" cellspacing="0"
									class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btng_rowadd" id="btng_rowadd">Row
										Add</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0"
									class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btng_rowcopy" id="btng_rowcopy">Row
										Copy</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>
								<!-- Repeat Pattern -->

							</tr>
						</table>
						</td>
					</tr>
				</table>
				<!-- : ( Button : Sub ) (E) --></td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) --> <!-- --------------------------------------------------------------------------------------------------------- -->
		</td>
	</tr>
</table>
<!-- Outer Table (E)--></form>
</body>
</html>
