<%
/*=========================================================
* Copyright(c) 2006 CyberLogitec
* @FileName : ESM_BSA_0030.jsp
* @FileTitle : BSA Inquiry by VVD
* Open Issues :
* Change history :
* @LastModifyDate : 2006.12.21
* @LastModifier : Park Eun Ju
* @LastVersion : 1.0
* 2006.12.21 Park Eun Ju   1.0 최초 생성
=========================================================
* History :
* 2008.02.27 PEJ N200801154874 주간 대상항차 기준 변경 관련 요청
*    변경사항 : Year, Month, Week관련 화면변경
* 2008.05.07 PEJ R200804296325 css 파일 참조 확인 및 수정 요청
* 2008.09.22 김태윤 N200808278919 Spilt 01-COA_Report내 수정사항 (메뉴명과 윈도우 타이틀명 일치.)
* 2008.10.24 전성진 CSR No.N200810100017
*                  - Slot Price 및 TEU & Slot Price 화면 추가
* 2009.03.13 김태윤 N200903110001 - VVD Code에 영문 외 숫자도 입력가능하게 수정
* 2009.03.16 김종열 N200903100130 - VVD Code에 영문 외 숫자도 입력가능하게 수정
* 2009.09.10 남궁진호 ALPS 전환작업 1.0 Creation
* 2010.10.04 이행지 [CHM-201005758-01] BSA  Architecture 위배사항 수정 (CommonSC)
* 2011.04.04 이관샨 [CHM-201109933-01] 화면상 불필요한 선 정리 
* 2011.08.05 이행지 [CHM-201112101-01] Slottage => Slot Price 용어 변경
* 2014.07.02 김용습 R4J 패치 사전 작업
* 2014.12.15 김용습 [CHM-201433095] Error Finder 버튼 추가
2016.01.29 김성욱 [CHM-201539410] BSA System 개선의 건 / 동일 날짜에 서로 다른 항차 BSA 입력 가능 실현
==========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%> 
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bsa.common.vo.CommonBsaRsVO"%>
<%@ page import="com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.event.EsmBsa0030Event"%>
<%@ page import="com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.vo.SearchOpJobCarrierListVO "%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBsa0030Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.BSAManage.SPCManage");
	
	String tmp = "";
	String prevWeek = "";
	String crrCD = "";
	String saveNM = "";			// sheet의 save name
	String crr_cnt = "";	    // op_job_cd에 들어 있는 crr_cd의 갯수
	List<SearchOpJobCarrierListVO> list = null;	
	SearchOpJobCarrierListVO vo = null;
    String xml = "";
    
    //2014.07.02 김용습 R4J 패치 사전 작업
  	StringBuffer out1 = new StringBuffer();
  	StringBuffer out2 = new StringBuffer(); 
    
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBsa0030Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
    	CommonBsaRsVO commonVO = (CommonBsaRsVO)(eventResponse.getCustomData("rtnVo"));
    	prevWeek =eventResponse.getETCData("prevWk");
    	
		list = commonVO.getResultVOList();
		rowCount = list.size();
		
		int cnt = 0;
	    // sheet의 Header 항목을 위한 처리작업
	    //---------------------------------------------------------------------------------
		for(int j=0; j<rowCount; j++){
			vo = list.get(j);
			
			//2014.07.02 김용습 R4J 패치 사전 작업
			//saveNM = saveNM + vo.getCrrCd() + vo.getBsaOpJbCd() + "|";
			//crrCD = crrCD + vo.getCrrCd() + "|";		
			out1.append(vo.getCrrCd()).append(vo.getBsaOpJbCd()).append("|");
			out2.append(vo.getCrrCd()).append("|");
			
			if(tmp.equals("") || vo.getBsaOpJbCd().equals(tmp)){
				cnt++;
			} else {
				crr_cnt = crr_cnt + cnt +"|";
				cnt = 1;
			}
			tmp = vo.getBsaOpJbCd();
		}
		//2014.07.02 김용습 R4J 패치 사전 작업
		saveNM = out1.toString();
		crrCD = out2.toString();
		
		crr_cnt = crr_cnt + cnt ;
		saveNM = saveNM.substring(0, saveNM.length()-1);
		crrCD = crrCD.substring(0, crrCD.length()-1);
		
		log.debug("crr_cnt   : " + crr_cnt);
		log.debug("crrCD     : " + crrCD);
		log.debug("saveNM    : " + saveNM);
				
        xml = HttpUtil.makeXML(request,response); 
        xml = xml.replaceAll("\"", "'");
	   
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>BSA & Slot-swap by VVD </title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		var formObj = document.form;
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		
        document.form.txtYear.focus();		
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

<iframe height="0" width="0" name="frmHidden"></iframe>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;" >
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="flag">
<input type="hidden" name="reset_flag">
<input type="hidden" name="header" value="<%= saveNM %>">
<input type="hidden" name="param1"> <!-- Gubun   |   Methode Name   | codeItem     -->
<input type="hidden" name="param2"> <!-- Year    |   vsl_cd         | All /        -->
<input type="hidden" name="param3"> <!--         |   skd_voy_no     | Methode Name -->
<input type="hidden" name="param4"> <!--         |   dir_cd         | trd_cd       -->
<input type="hidden" name="param5"> <!-- fmMonth |                  |              -->
<input type="hidden" name="param6"> <!-- toMonth |                  |              -->
<input type="hidden" name="param7"> <!-- fmWeek  |                  |              -->
<input type="hidden" name="param8"> <!-- toWeek  |                  |              -->

<input type="hidden" name="crr_cnt" value="<%= crr_cnt%>">
<input type="hidden" name="crr_cd" value="<%= crrCD %>">
<input type="hidden" name="saveNM" value="<%= saveNM %>">
<input type="hidden" name="hValue">
<input type="hidden" name="sXml"          value="<%=xml%>"> 

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>

		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->


		<!--Button_L (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
	       	<tr><td class="btn1_bg">

				<table border="0" cellpadding="0" cellspacing="0">
				<tr>

					<!-- Repeat Pattern -->
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
				<!-- 김성욱 추가 -->
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_save" name="btn_save">Save</td><td class="btn1_right"></td></tr></table></td>

					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_downexcel" name="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->

				</tr></table>

			</td></tr>
		</table>
		<!--Button_L (E) -->


					<!-- TABLE '#D' : ( Search Options ) (S) -->
					<table class="search">
						<tr>
							<td class="bg">

								<!-- : ( Year ) (S) -->
								<table class="search_in" border="0">
									<tr class="h23">
										<td width="700"><script language="javascript">initPeriod();</script></td>
										<td>Carriers with BSA only<input type="checkbox" name="isExcludZero" value="1" class="trans"></td>
									</tr>
								</table>
								<table class="search_in" border="0">
									<tr><td class="line_bluedot"></td></tr>
								</table>
								<table class="search_in" border="0">
									<tr class="h23">
										<td width="55" style="text-indent:7;">Trade</td>
										<td width="130"><script language="javascript">ComComboObject('cobTrade', 1, 70 , 0 )</script></td>
										
										<td width="35">Lane</td>
										<td width="130"><script language="javascript">ComComboObject('cobLane', 1, 70 , 0 )</script></td>
										
										<td width="60">Direction</td>
										<td width="130"><script language="javascript">ComComboObject('cobDir', 1, 70 , 0 )</script></td>
										
										<td width="30">IOC</td>
										<td width="130"><script language="javascript">ComComboObject('cobIOC', 1, 70 , 0 )</script></td>
										
										<td width="30">VVD</td>
										<td><input type="text" size="4" name="txtVsl_cd"     maxlength="4" onKeyPress="ComKeyOnlyAlphabet('uppernum');" onKeyUp="moveTab(this, txtSkd_voy_no);" style="ime-mode:disabled; width:65;" >
											<input type="text" size="4" name="txtSkd_voy_no" maxlength="4" onKeyPress="ComKeyOnlyNumber(window);" onKeyUp="moveTab(this, txtDir_cd);" style="ime-mode:disabled; width:65;" >
											<input type="text" size="1" name="txtDir_cd"     maxlength="1" onKeyPress="ComKeyOnlyAlphabet('upper');" onBlur="chkVVD();" style="ime-mode:disabled; width:30;" ></td>
									</tr>
								</table>
								<!-- : ( Year ) (E) -->

							</td>
						</tr>
					</table>
					<!-- TABLE '#D' : ( Search Options ) (E) -->

					<table class="height_10"><tr><td></td></tr></table>

					<!-- TABLE '#D' : ( Search Options ) (S) -->
					<table class="search">
						<tr>
							<td class="bg">

								<!-- : ( Option ) (S) -->
								<table class="search" border="0" style="width:100%;">
									<tr class="h23">
										<td>
											<input type="radio" value="T" class="trans" name="rdoPerf" onClick="InvOnChange(0);" checked>&nbsp;BSA&nbsp;&nbsp;&nbsp;
											<input type="radio" value="S" class="trans" name="rdoPerf" onClick="InvOnChange(1);">&nbsp;Slot Price&nbsp;&nbsp;&nbsp;
											<input type="radio" value="D" class="trans" name="rdoPerf" onClick="InvOnChange(2);">&nbsp;BSA & Slot Price&nbsp;&nbsp;&nbsp;
											<input type="radio" value="P" class="trans" name="rdoPerf" onClick="InvOnChange(3);">&nbsp;Slot Price Total
										</td>
										<!--
			                            <td width="300"class="gray">
			                                <img class="cursor" src="/hanjin/img/ico_newwin.gif" width="11" height="12" align="absmiddle" hspace="5">
			                                <a href="javascript:viewPopUp();" class="purple"> View Management</a>
			                            </td>
			                             -->
			                            <td align="right" class="gray">* Price Currency= USD(U$)</td>
			                            <td width="30" align="right" valign="bottom" style="padding-right:2;">
									        <div id="div_zoom_in" style="display:inline"> <!-- absolute / relative -->
											<img class="cursor" src="/hanjin/img/bu_prev01.gif" width="20" height="11" border="0" name="bu_zoom_in" alt="Zoom in(+)">
											</div>
											<div id="div_zoom_out" style="display:none">
											<img class="cursor" src="/hanjin/img/bu_next01.gif" width="20" height="11" border="0" name="bu_zoom_out" alt="Zoom out(-)">
											</div>
										</td>
									</tr>
									<tr><td class="height_2"></td></tr>
								</table>

								<!-- : ( Option ) (E) -->
								<div id="RadioLayer0" style="display:inline">
									<!-- : ( POR ) (S) -->
									<table width="100%" id="mainTable1">
										<tr>
											<td>
												<script language="javascript">ComSheetObject('sheet0');</script>
											</td>
										</tr>
									</table>
									<!-- : ( POR ) (E) -->

									<!--  Button_Sub (S) -->
									<table width="100%" class="button">
									<tr>
									<td><table>
										<td wdith="50%" class="gray_tit" align="left">
											* Basic Slots = Basic slot allocation among joint operating carriers
											<br>
											* Basic Lease = Slots leased by SML to other carriers
											<br>
											* Basic Chartered = Slots chartered by SML from other carriers
											<br>
											* Additional Lease = Additional slots leased by SML to other carriers
											<br>
											* Additional Chartered = Additional slots chartered by SML from other carriers						
										</td>
									</table></td>
									<td class="btn2_bg" valign="top" >
										<table border="0" cellpadding="0" cellspacing="0" >
										<tr>
											<!-- Repeat Pattern -->
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td><td class="btn2_3" id="btng_error_finder0" name="btng_error_finder0">Error Finder</td><td class="btn2_right"></td></tr></table></td>
											
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td><td class="btn2" id="btng_creation" name="btng_creation">Creation</td><td class="btn2_right"></td></tr></table></td>

											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td><td class="btn2" id="btn_skdinquiry0" name="btn_skdinquiry0">SKD Inquiry</td><td class="btn2_right"></td></tr></table></td>

											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td><td class="btn2" id="btng_reset0" name="btng_reset0">Reset</td><td class="btn2_right"></td></tr></table></td>
											<!-- Repeat Pattern -->
										</tr>
										</table>
									</td>											
									</tr>
									</table>
											
							    	<!-- Button_Sub (E) -->
							    </div>


								<div id="RadioLayer1" style="display:inline">
									<!-- : ( POR ) (S) -->
									<table width="100%" id="mainTable2">
										<tr>
											<td>
												<script language="javascript">ComSheetObject('sheet1');</script>
											</td>
										</tr>
									</table>
									<!-- : ( POR ) (E) -->

									<!--  Button_Sub (S) -->
									<table width="100%" class="button">
								       	<tr>
								       	<td><table>
										<td wdith="50%" class="gray_tit" align="left">
											* Basic Slots = Basic slot allocation among joint operating carriers
											<br>
											* Basic Lease = Slots leased by SML to other carriers
											<br>
											* Basic Chartered = Slots chartered by SML from other carriers
											<br>
											* Additional Lease = Additional slots leased by SML to other carriers
											<br>
											* Additional Chartered = Additional slots chartered by SML from other carriers						
										</td>
									</table></td>
									<td class="btn2_bg" valign="top" >
										<table border="0" cellpadding="0" cellspacing="0">
										<tr>
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td><td class="btn2_3" id="btng_error_finder1" name="btng_error_finder1">Error Finder</td><td class="btn2_right"></td></tr></table></td>

											<!-- Repeat Pattern -->
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td><td class="btn2" id="btn_skdinquiry1" name="btn_skdinquiry1">SKD Inquiry</td><td class="btn2_right"></td></tr></table></td>

											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td><td class="btn2" id="btng_reset1" name="btng_reset1">Reset</td><td class="btn2_right"></td></tr></table></td>
											<!-- Repeat Pattern -->


										</tr></table>
									</td></tr>
									</table>
							    	<!-- Button_Sub (E) -->
								</div>

								<!-- : ( Option ) (E) -->
								<div id="RadioLayer2" style="display:inline">
									<!-- : ( POR ) (S) -->
									<table width="100%" id="mainTable1">
										<tr>
											<td>
												<script language="javascript">ComSheetObject('sheet2');</script>
											</td>
										</tr>										
									</table>
									<!-- : ( POR ) (E) -->

									<!--  Button_Sub (S) -->
									<table width="100%" class="button">
								       	<tr>
								       	<td><table>
										<td wdith="50%" class="gray_tit" align="left">
											* Basic Slots = Basic slot allocation among joint operating carriers
											<br>
											* Basic Lease = Slots leased by SML to other carriers
											<br>
											* Basic Chartered = Slots chartered by SML from other carriers
											<br>
											* Additional Lease = Additional slots leased by SML to other carriers
											<br>
											* Additional Chartered = Additional slots chartered by SML from other carriers						
										</td>
									</table></td>
									<td class="btn2_bg" valign="top" >
										<table border="0" cellpadding="0" cellspacing="0">
										<tr>
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td><td class="btn2_3" id="btng_error_finder2" name="btng_error_finder2">Error Finder</td><td class="btn2_right"></td></tr></table></td>

											<!-- Repeat Pattern -->
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td><td class="btn2" id="btn_skdinquiry2" name="btn_skdinquiry2">SKD Inquiry</td><td class="btn2_right"></td></tr></table></td>

											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td><td class="btn2" id="btng_reset2" name="btng_reset2">Reset</td><td class="btn2_right"></td></tr></table></td>
											<!-- Repeat Pattern -->


										</tr></table>
									</td></tr>
									</table>
							    	<!-- Button_Sub (E) -->
								</div>


								<div id="RadioLayer3" style="display:inline">
									<!-- : ( POR ) (S) -->
									<table width="100%" id="mainTable4">
										<tr>
											<td>
												<script language="javascript">ComSheetObject('sheet3');</script>
											</td>
										</tr>
									</table>
									<!-- : ( POR ) (E) -->

									<!--  Button_Sub (S) -->
									<table width="100%" class="button">
								       	<tr>
								       	<td><table>
										<td wdith="50%" class="gray_tit" align="left">
											* Basic Slots = Basic slot allocation among joint operating carriers
											<br>
											* Basic Lease = Slots leased by SML to other carriers
											<br>
											* Basic Chartered = Slots chartered by SML from other carriers
											<br>
											* Additional Lease = Additional slots leased by SML to other carriers
											<br>
											* Additional Chartered = Additional slots chartered by SML from other carriers						
										</td>
									</table></td>
									<td class="btn2_bg" valign="top" >
										<table border="0" cellpadding="0" cellspacing="0">
										<tr>											
											<!-- Repeat Pattern -->
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td><td class="btn2_3" id="btng_error_finder3" name="btng_error_finder3">Error Finder</td><td class="btn2_right"></td></tr></table></td>
											
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td><td class="btn2" id="btn_skdinquiry3" name="btn_skdinquiry3">SKD Inquiry</td><td class="btn2_right"></td></tr></table></td>

											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td><td class="btn2" id="btng_reset3" name="btng_reset3">Reset</td><td class="btn2_right"></td></tr></table></td>
											<!-- Repeat Pattern -->
										</tr></table>
									</td></tr>
									</table>
							    	<!-- Button_Sub (E) -->
								</div>

							</td>
						</tr>
					</table>
					<!-- TABLE '#D' : ( Search Options ) (E) -->


</td></tr>
</table>
<!-- Outer Table (E)-->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>