<%
/*=========================================================
* Copyright(c) 2006 CyberLogitec
* @FileName : ESM_MAS_0118.jsp
* @FileTitle : Terminal Internal Pricing (PA/RA) 
* Open Issues :
* Change history :
* @LastModifyDate : 2006-12-07
* @LastModifier : Kim Jong Beom
* @LastVersion : 1.0
*  2006-12-07 Kim Jong Beom
*  1.0 최초 생성
* 2008-04-29 전성진 R200804296328 css 파일 참조 확인 및 수정 요청
* 2008.09.22 김태윤 N200808278919 Spilt 01-MAS_Report내 수정사항 (메뉴명과 윈도우 타이틀명 일치.)
* 2009.09.28 박수훈 0118 화면 New FrameWork 적용
* 2010.08.25 이윤정 [CHM-201005513] 현재 입력건의 경우 ESM_MAS_0118 화면상 "Curr."를 Local AMT가 아닌 Unit Cost에 대한 Curr.로 사용 변경
* 2010.09.01 이일민 Ticket ID:CHM-201004982-01 MAS Architecture 위배사항 수정
* 2011.07.20 최성민 [CHM-201112295-01] [MAS] 내부거래단가 조건추가 : Actual Lane 정보
* 2015.08.31 손진환 [CHM-201536958] Split15-[그룹사 표준 코드 시행] SML 프로그램 대응 및 데이타 마이그레이션 작업 요청
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.mas.common.Utils"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%>
<%
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	String strUsr_id		= "";
	String strOfc_cd		= "";
	String strTeam_cd		= "";
	String xml = "";
	Logger log = Logger.getLogger("com.hanjin.apps.WeeklyPFMC.WeeklyCM");
	GeneralEventResponse eventResponse =  null;
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strOfc_cd =	account.getOfc_cd();
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
			strTeam_cd = JSPUtil.getNull(eventResponse.getETCData("strTeam_cd"));
		}
		

        xml = HttpUtil.makeXML(request,response); 
        xml = xml.replaceAll("\"", "'");
	} catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Terminal Internal Pricing (PA/RA) </title>
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
<form method="post" name="form" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="sXml" value="<%=xml%>"> 

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
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_Retrieve" name="btn_Retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>

					<td class="btn1_line"></td>

					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_DownExcel" name="btn_DownExcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->

				</tr></table>

			</td></tr>
		</table>
		<!--Button_L (E) -->


<!-- TABLE '#D' : ( Search Options ) (S) -->
<table class="search">
<tr><td class="bg">

		<table class="search_in" border="0">
		<tr class="h23">
			<td width="7%">YYYY-MM</td>
			<td width="15%">
				<input type="text" name="f_cost_yrmon" class="input1" style="width:60" value="" maxlength="7" onKeyPress="ComKeyOnlyNumber(this)" onFocus="ComClearSeparator(this, 'ym','-');this.select();" onBlur="addDash(this , 4);"  ></td>
			<td width="7%">Terminal</td>
			<td>
			<select name="f_tml_cd" style='width:70'>
				<option value="">ALL</option>
				<option value="JPOSAY1">JPOSAY1</option>
				<option value="JPTYOY1">JPTYOY1</option>
				<option value="KRKANY4">KRKANY4</option>
				<option value="KRPUSKC">KRPUSKC</option>
				<option value="KRPUSYG">KRPUSYG</option>
				<option value="KRPUSYK">KRPUSYK</option>
				<option value="KRPUSHN">KRPUSHN</option>
				<option value="TWKHHHT">TWKHHHT</option>
				<option value="USLGBPT">USLGBPT</option>
				<option value="USOAKM1">USOAKM1</option>
				<option value="USSEAM1">USSEAM1</option>
			</select>
			</td>			
			<td width="7%">Type/Size</td>
			<td>
			<select name="f_cntr_tpsz_cd" style='width:70'>
				<option value="">ALL</option>
				<option value="20">20</option>
				<option value="40">40</option>
				<option value="45">45</option>
			</select>
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
		<table class="search" border="0">
		<tr><td class="title_h"></td>
			<td class="title_s">Create TML Internal Pricing PFMC</td>
			<td class="gray"><img class="cursor" src="/hanjin/img/alps/ico_newwin.gif" width="11" height="12" align="absmiddle" hspace="5"><a href="javascript:ComOpenWindow2('ESM_MAS_0119.do', '', 'width=900,height=500,menubar=0,status=0,scrollbars=0,resizable=0')" class="purple">SRC Code Setting</a></td></tr>
		<tr><td height="3" colspan="3"></td></tr>
		</table>

		<!-- : ( POR ) (S) -->
		<table width="100%">
		<tr>
			<td width="100%">
				<table width="100%" id="mainTable">
				<tr><td><script language="javascript">ComSheetObject('sheet1');</script></td></tr>
				</table>
			</td>
		</tr>
		</table>
		<!-- : ( POR ) (E) -->


		<!--  Button_Sub (S) -->
		<%
			//CDA, COL에만 권한, admin
			if( "SELOP".equals(strTeam_cd) ||"SELAPM".equals(strTeam_cd) ||"SELCSG".equals(strTeam_cd)||"system1".equals(strUsr_id) ||"SELOPA".equals(strOfc_cd)){
		%>

		<table width="100%" class="button">
	       	<tr><td class="btn2_bg">
			<table border="0" cellpadding="0" cellspacing="0">
			<tr>

				<!-- Repeat Pattern -->
				<td>
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr>
						<td class="btn2_left"></td>
						<td class="btn2" id="btn_rowadd" name="btn_rowadd">Row Add</td>
						<td class="btn2_right"></td>
					</tr>
				</table>
				</td>
				<td>
				
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr>
						<td class="btn2_left"></td>
						<td class="btn2" id="btn_rowdelete" name="btn_rowdelete">Row Delete</td>
						<td class="btn2_right"></td>
					</tr>
				</table>
				</td>
				<td class="btn2_left"></td><td class="btn2" id="btng_Save" name="btng_Save">Save</td><td class="btn2_right"></td></tr></table></td> 
				<!-- Repeat Pattern -->


			</tr></table>
		</td></tr>
		</table>
		<%
		}
		%>
    	<!-- Button_Sub (E) -->


	</td>
</tr>
</table>
<!-- TABLE '#D' : ( Search Options ) (E) -->

<!-- Outer Table (E)-->

</form>
</body>
</html>
