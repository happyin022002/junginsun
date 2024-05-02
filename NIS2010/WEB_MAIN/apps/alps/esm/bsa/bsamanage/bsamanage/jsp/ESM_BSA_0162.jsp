<%
/*=========================================================
* Copyright(c) 2006 CyberLogitec
* @FileName : ESM_BSA_0162.jsp
* @FileTitle : Inquire/Edit Over Used Slot Price
* Open Issues :
* Change history :
* @LastModifyDate : 2008-10-01
* @LastModifier : 전성진
* @LastVersion : 1.0
* 2007-01-18 전성진   1.0 최초 생성
=========================================================
' History :
' 2008.10.01 전성진 CSR No.N200809059194
'					: Over Used Slot Price Table 생성
* 2009.10.16 남궁진호 ALPS 전환 1.0 Creation
* 2010.10.04 이행지 [CHM-201005758-01] BSA  Architecture 위배사항 수정 (CommonSC)
* 2011.04.04 이관샨 [CHM-201109933-01] 화면상 불필요한 선 정리 
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%> 
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.event.EsmBsa0162Event"%>
<%@ page import="com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.SearchBsaCrrRgstListVO"%>
<%@ page import="com.hanjin.apps.alps.esm.bsa.common.vo.CommonBsaRsVO"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBsa0162Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.BSAManage.BSAManage");
	
	String bsa_op_jb_cd = "";
	String bsa_op_jb_nm = "";
	String crr_cd = "";
	int head_cnt = 0;
	List<SearchBsaCrrRgstListVO> list = null;	
	SearchBsaCrrRgstListVO vo = null;
    String xml = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBsa0162Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

    	CommonBsaRsVO rtnVo = (CommonBsaRsVO)(eventResponse.getCustomData("rtnVo"));
    	
		list = rtnVo.getResultVOList();
		rowCount = list.size();
		
		for(int j=0; j<rowCount; j++){
			vo = list.get(j);
			bsa_op_jb_cd = bsa_op_jb_cd + "|" + vo.getBsaOpJbCd();
			if(vo.getBsaOpJbCd().equals("001")){
				bsa_op_jb_nm = bsa_op_jb_nm + "|Joint Operating Carrier's Slot Price";
			} else {
				bsa_op_jb_nm = bsa_op_jb_nm + "|" + vo.getBsaOpJbNm();
			}
			crr_cd       = crr_cd       + "|" + vo.getCrrCd();
			head_cnt++;

		} //end of for
		
        xml = HttpUtil.makeXML(request,response); 
        xml = xml.replaceAll("\"", "'");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Inquire/Edit Over Used Slot Price</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage("<%=bsa_op_jb_nm%>","<%=crr_cd%>");
		document.form.txtSDate.focus();
	}
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<iframe height="0" width="0" name="frmHidden" id="frmHidden"></iframe>

<form method="post" name="form" onSubmit="return false;" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="param1"> <!-- Gubun   |  Method Name  -->
<input type="hidden" name="param2"> <!-- Year    |  vsl_cd       -->
<input type="hidden" name="param3"> <!--         |  skd_voy_no   -->
<input type="hidden" name="param4"> <!--         |  dir_cd       -->
<input type="hidden" name="param5"> <!-- sMonth  |               -->
<input type="hidden" name="param6"> <!-- eMonth  |               -->
<input type="hidden" name="param7"> <!-- sWeek   |               -->
<input type="hidden" name="param8"> <!-- eWeek   |               -->

<input type="hidden" name="head_cnt"     value="<%=head_cnt%>">
<input type="hidden" name="bsa_op_jb_cd" value="<%=bsa_op_jb_cd%>">
<input type="hidden" name="bsa_op_jb_nm" value="<%=bsa_op_jb_nm%>">
<input type="hidden" name="crr_cd"       value="<%=crr_cd%>">
<input type="hidden" name="sXml"         value="<%=xml%>"> 
<!-- 개발자 작업	-->
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
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>


							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_save" id="btn_save">Save</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
							<!-- Repeat Pattern -->

						</tr></table>

				</td></tr>
		</table>
<!-- TABLE '#D' : ( Button : Main ) (E) -->

<!-- TABLE '#D' : ( Search Options ) (S) -->
<table class="search">
<tr>
	<td class="bg">

		<table class="search_in" border="0">
		<tr class="h23">
			<td width="55" style="text-indent:7;">Period</td>
			<td width="280">
				<input class="input1" type="text" dataformat="ymd" name="txtSDate" style="width:75;text-align:center;ime-mode:disabled;" maxlength="8" 
				       onKeyPress="ComKeyOnlyNumber(this, '-');"   onKeyUp="ComKeyEnter('LengthNextFocus');" 
				       OnBeforeDeactivate="ComAddSeparator(this);"  
				       OnBeforeActivate="ComClearSeparator(this);">
				<img name="btns_calendar1" src="/hanjin/img/button/btns_calendar.gif" class="cursor"
				     width="19" height="20" border="0" align="absmiddle">
				&nbsp;~&nbsp;
				<input class="" type="text" dataformat="ymd"  name="txtEDate" style="width:75;text-align:center;ime-mode:disabled;" maxlength="8"
				       onKeyPress="ComKeyOnlyNumber(this, '-');"   onKeyUp="ComKeyEnter('LengthNextFocus');" 
				       OnBeforeDeactivate="ComAddSeparator(this);"  
				       OnBeforeActivate="ComClearSeparator(this);">
				<img name="btns_calendar2" src="/hanjin/img/button/btns_calendar.gif" class="cursor"
				     width="19" height="20" border="0" align="absmiddle">
			</td>
			<td width="" class="stm">(ETD of 1st Port)</td>
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
			<td width="130"><div id="div_rLane"><script language="javascript">ComComboObject('cobLane', 1, 70 , 0 )</script></div></td>

			<td width="30">Dir.</td>
			<td width="130"><script language="javascript">ComComboObject('cobDir', 1, 70 , 0 )</script></td>
			<td>
				Carriers with BSA only&nbsp;<input type="checkbox" name="isExcludZero" value="1" class="trans">
			</td>

		</tr>
		</table>

	</td>
</tr>
</table>

<!-- TABLE '#D' : ( Search Options ) (E) -->
<table class="height_10"><tr><td></td></tr></table>


<!-- TABLE '#D' : ( Search Options ) (S) -->
<table class="search">
<tr><td class="bg">

		<!-- : ( POR ) (S) -->
		<table width="100%">
		<tr height="12">
			<td width="100%" align="right" valign="bottom" style="padding-right:1;">
		        <div id="div_zoom_in" style="display:inline"> <!-- absolute / relative -->
				<img class="cursor" src="/hanjin/img/bu_prev01.gif" width="20" height="11" border="0" name="bu_zoom_in" alt="Zoom in(+)">
				</div>
				<div id="div_zoom_out" style="display:none">
				<img class="cursor" src="/hanjin/img/bu_next01.gif" width="20" height="11" border="0" name="bu_zoom_out" alt="Zoom out(-)">
				</div>
			</td>
		</tr>
		<tr><td width="100%">
				<table width="100%" id="mainTable">
				<tr><td><script language="javascript">ComSheetObject('sheet1');</script></td></tr>
				</table>
			</td>
		</tr>
		</table>
		<!-- : ( POR ) (E) -->

		<!-- : ( Button : Sub ) (S) -->
		<table width="100%" class="button">
					<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>

							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="btng_rowadd" id="btng_rowadd">Row Add</td>
							<td class="btn2_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="btng_rowcopy" id="btng_rowcopy">Row Copy</td>
							<td class="btn2_right"></td></tr></table></td>
							<!-- Repeat Pattern -->

							</tr>
						</table>
					</td></tr>
				</table>
		<!-- : ( Button : Sub ) (E) -->

	</td>
</tr>
</table>
<!-- TABLE '#D' : ( Search Options ) (E) -->


			<!-- --------------------------------------------------------------------------------------------------------- -->
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
		//초기값 샛팅
		//if (txtSDate.value == "") { txtSDate.value = getCurrDate("-"); } /* 현재일자  */
	}
-->
</script>
