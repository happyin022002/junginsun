<%
/*=========================================================
* Copyright(c) 2006 CyberLogitec
* @FileName : ESM_BSA_0032.jsp
* @FileTitle : Inquire/Edit Supply & Slot-swap By VVD
* Open Issues :
* Change history :
* @LastModifyDate : 2006-09-18
* @LastModifier : Kim Jong Beom
* @LastVersion : 1.0
*  2006-09-18 Kim Jong Beom
*  1.0 최초 생성
* =========================================================
* History :
* 2008.02.27 PEJ N200801154874 주간 대상항차 기준 변경 관련 요청
*    변경사항 : Year, Month, Week관련 화면변경
* 2008.05.07 PEJ R200804296325 css 파일 참조 확인 및 수정 요청
* 2009.09.28 남궁진호 ALPS 전환작업  ESM_BSA_0032.jsp 로 1.0 Creation
* 2010.10.04 이행지 [CHM-201005758-01] BSA  Architecture 위배사항 수정 (CommonSC)
* 2011.04.04 이관샨 [CHM-201109933-01] 화면상 불필요한 선 정리 
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bsa.common.vo.CommonBsaRsVO"%>
<%@ page import="com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.event.EsmBsa0032Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBsa0032Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.BSAManage.SPCManage");
	String prevWeek = "";
	String xml = "";
	
	//Combo Data : getCodeCombo('태그명','초기값', '추가요소', '업무명', '조건코드', '전체유무', '추가옵션')
	//String cobTrade   = ComboUtil.getCodeCombo("cobTrade", "", " onChange='cobTrade_OnChange(this);'  style='width:70'", "trade", "", "All", "");
	//String cobLane    = ComboUtil.getCodeCombo("cobLane",  "", " style='width:80'", "rLane", "", "All", "");
	//String cobDir     = JSPUtil.getCodeCombo("cobDir", "", " style='width:70'", "CD00593", 0, "000001: :All");
	//String cobIOC     = JSPUtil.getCodeCombo("cobIOC", "", " style='width:80'", "CD00206", 0, "000020: :All");
	//String cobCarrier = ComboUtil.getCodeCombo("cobCarrier", "", " onChange='cobCarrier_onChange(this);' style='width:70'", "BSACarrier", "J", "N", "");


	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBsa0032Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		CommonBsaRsVO retVo = (CommonBsaRsVO)eventResponse.getCustomData("retVo");
    	prevWeek =eventResponse.getETCData("prevWk");
    	
        xml = HttpUtil.makeXML(request,response); 
        xml = xml.replaceAll("\"", "'");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Step Up/Down by VVD </title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage() {
		var formObj = document.form;

		loadPage();

        formObj.txtYear.value = ComGetNowInfo("yy");  
        formObj.txtFmMonth.value = ComGetNowInfo("mm"); 
        formObj.txtToMonth.value = ComGetNowInfo("mm"); 
        formObj.txtFmMonth.value = ComLpad(formObj.txtFmMonth, 2, '0');
        formObj.txtToMonth.value = ComLpad(formObj.txtToMonth, 2, '0');
        formObj.txtFmWeek.value = "<%=prevWeek%>";
        formObj.txtToWeek.value = "<%=prevWeek%>";

        setPeriod(formObj.txtToWeek);
	}
</script>
</head>

<!-- 개발자 작업	-->
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<iframe height="0" width="0" name="frmHidden" id="frmHidden"></iframe>

<form method="post" name="form" onSubmit="return false;" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="iPage">
<input type="hidden" name="param1"> <!-- Gubun   |  Methode Name -->
<input type="hidden" name="param2"> <!-- Year    |  vsl_cd       -->
<input type="hidden" name="param3"> <!--         |  skd_voy_no   -->
<input type="hidden" name="param4"> <!--         |  dir_cd       -->
<input type="hidden" name="param5"> <!-- sMonth  |               -->
<input type="hidden" name="param6"> <!-- eMonth  |               -->
<input type="hidden" name="param7"> <!-- sWeek   |               -->
<input type="hidden" name="param8"> <!-- eWeek   |               -->
<input type="hidden" name="sXml" value="<%= xml %>">

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>


		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->


	<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
	       	<tr><td class="btn1_bg">

				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<!-- Repeat Pattern -->
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>


					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_downexcel" name="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->

				</tr></table>

			</td></tr>
		</table>
	<!-- TABLE '#D' : ( Button : Main ) (E) -->



	<!-- TABLE '#D' : ( Search Options ) (S) -->
 	<table class="search">
   	<tr><td class="bg">

			<!-- : ( Year ) (S) -->
			<table class="search_in" border="0">
			<tr class="h23">
				<td><script language="javascript">initPeriod();</script></td>
			</tr>
			</table>
			<table class="search_in" border="0">
			<tr><td class="line_bluedot"></td></tr>
			</table>
			<table class="search_in" border="0">
			<tr class="h23">
				<td width="55" style="text-indent:7;">Trade</td>
				<td width="130"><script language="javascript">ComComboObject('cobTrade', 1, 70 , 0 )</script></td>
				<td width="40">Lane</td>
				<td width="130"><div id="div_rLane"><script language="javascript">ComComboObject('cobLane', 1, 80 , 0 )</script></div></td>
				<td width="30">Dir.</td>
				<td width="130"><script language="javascript">ComComboObject('cobDir', 1, 70 , 0 )</script></td>
				<td width="30">IOC</td>
				<td><script language="javascript">ComComboObject('cobIOC', 1, 80 , 0 )</script></td></tr>
			</table>
			<!-- : ( Year ) (E) -->


		</td></tr>
	</table>
	<!-- TABLE '#D' : ( Search Options ) (E) -->

	<table class="height_10"><tr><td></td></tr></table>


	<!-- TABLE '#D' : ( Search Options ) (S) -->
 	<table class="search">
   	<tr><td class="bg">


			<!-- : ( Option ) (S) -->
			<table class="search" border="0" style="width:100%;">
			<tr class="h23">
				<td width="55" style="text-indent:7;">Carrier</td>
				<td width="18%" style="padding-left:1">
					<script language="javascript">ComComboObject('cobCarrier', 1, 70 , 0 )</script>
				</td>
				<td width="56%">
					<input type="radio" value="007" class="trans" name="rdoCode" onClick="rdoCode_onClick('BSA');" checked>&nbsp;BSA  &nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" value="015" class="trans" name="rdoCode" onClick="rdoCode_onClick('Slot Price');">&nbsp;Slot Price  &nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" value="016" class="trans" name="rdoCode" onClick="rdoCode_onClick('Weight Limit');">&nbsp;Weight Limit
				</td>
				<td width="20%" align="right" valign="bottom" style="padding-right:3;">
			        <div id="div_zoom_in" style="display:inline"> <!-- absolute / relative -->
					<img class="cursor" src="/hanjin/img/bu_prev01.gif" width="20" height="11" border="0" name="bu_zoom_in" alt="Zoom in(+)">
					</div>
					<div id="div_zoom_out" style="display:none">
					<img class="cursor" src="/hanjin/img/bu_next01.gif" width="20" height="11" border="0" name="bu_zoom_out" alt="Zoom out(-)">
					</div>
				</td>

			</tr>
			<tr><td class="height_2" colspan="3"></td></tr>
			</table>
			<!-- : ( Option ) (E) -->

			<!-- : ( POR ) (S) -->
			<table width="100%">
			<tr>
				<td width="69%">
					<table width="100%" id="mainTable1">
					<tr>
						<td><script language="javascript">ComSheetObject('sheet1');</script></td>
					</tr>
					</table>

					<!-- : ( Button : Grid ) (S) -->
					<table width="100%" class="button">
						<tr><td class="btn2_bg">
							<table border="0" cellpadding="0" cellspacing="0">
								<tr>
									<!-- Repeat Pattern -->
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td><td class="btn2" name="btn_skdinquiry" id="btn_skdinquiry">SKD Inquiry</td>
									<td class="btn2_right"></td></tr></table></td>
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td><td class="btn2" name="btng_save1" id="btng_save1">Save</td>
									<td class="btn2_right"></td></tr></table></td>
									<!-- Repeat Pattern -->
								</tr>
							</table>
						</td></tr>
					</table>
		    	<!-- : ( Button : Grid ) (E) -->
				</td>
				<td width="2%"></td>
				<td width="29%">
					<table width="100%" id="mainTable2">
					<tr>
						<td><script language="javascript">ComSheetObject('sheet2');</script></td>
					</tr>
					</table>

					<!-- : ( Button : Grid ) (S) -->
					<table width="100%" class="button">
						<tr><td class="btn2_bg">
							<table border="0" cellpadding="0" cellspacing="0">
								<tr>
									<!-- Repeat Pattern -->
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td><td class="btn2" name="btng_portadd" id="btng_portadd">Port Add</td>
									<td class="btn2_right"></td></tr></table></td>
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td><td class="btn2" name="btng_save" id="btng_save">Save</td>
									<td class="btn2_right"></td></tr></table></td>
									<!-- Repeat Pattern -->
								</tr>
							</table>
						</td></tr>
					</table>
		    	<!-- : ( Button : Grid ) (E) -->
				</td>
			</tr>
			</table>
			<!-- : ( POR ) (E) -->

		</td></tr>
	</table>
	<!-- TABLE '#D' : ( Search Options ) (E) -->
    </td></tr>
</table>
<!-- Outer Table (E)-->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>


<script language="javascript">
<!--
	with(document.form) {
		cobCarrier.value = "SML";
		if (cobCarrier.value == "") { cobCarrier[0].selected = true; }

		//초기값 샛팅
		//if (txtYear.value == "") { txtYear.value = getCurrDate("-").substring(0,4); } /* 현재년  */
		//if (txtSMonth.value == "") { txtSMonth.value = '01'; }
		//if (txtEMonth.value == "") { txtEMonth.value = '12'; }
		//setPeriod(txtEMonth);
	}
-->
</script>