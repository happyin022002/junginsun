<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName       : ESM_COA_0152.jsp
*@FileTitle      : MRI 운임수입 단가관리
*Open Issues     :
*Change history  :
*@LastModifyDate : 2008-04-30
*@LastModifier   : PEJ
*@LastVersion    : 1.0
* 2008-04-30 PEJ
* 1.0 최초 생성
===========================================================
* History 
* 2008.05.26 PEJ N200805260007 COA_Misc OP Rev 반영 관련
*                Rlane/Bound 별로 가지고 있던 단가를 Trade/Bound 레벨까지 관리하면서 화면단도 수정
* 2008.09.22 김태윤 N200808278919 Spilt 01-COA_Report내 수정사항 (메뉴명과 윈도우 타이틀명 일치.)
* 2009.09.14 장영석 New frame work 적용
* 2010.09.01 김기종 CSR No. CHM-201004982-01 COA Architecture 위배사항 수정 (CommonSC)
* 2015.07.07 이윤정 [CHM-201536740] COA 내 화면의 조회 기능 (Retrieve, Down Excel)을 뺀 나머지 버튼들을 비활성화 요청 CSR
=========================================================*/ 
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%> 
<%@ page import="org.apache.log4j.Logger"%>
<%
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";
	String strUsr_id = "";
	String strUsr_nm = "";
	String xml = "";
	Logger log = Logger.getLogger("com.hanjin.apps.STDUnitCost.MRIInquiry");
	
	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		xml = HttpUtil.makeXML(request,response); 
        xml = xml.replaceAll("\"", "'");
        
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
<title>MRI Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		var formObj = document.form;
		
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();		
	}
</script>
</head>

<body onLoad="setupPage();">
<form method="post" name="form" onSubmit="return false;" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows"> 
<input type="hidden" name="iPage">
<input type="hidden" name="sXml" value="<%=xml%>"> 

<!-- hidden form's iframe -->
<iframe height="0" width="0" name="frmHidden"></iframe>
<!-- hidden form's iframe -->


<!-- 개발자 작업	--> 
<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
	<tr>
		<td><!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr>
				<td class="history"><img src="img/icon_history_dot.gif"	align="absmiddle">
				<span id="navigation"></span>
				</td>
			</tr>
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif"	align="absmiddle">
				<span id="title"></span></td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) --> <!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0"cellspacing="0" style="padding-bottom: 5;">
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
								<td class="btn1" id="btn_DownExcel" name="btn_DownExcel">Down Excel</td>
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
		<table class="search">
			<tr>
				<td class="bg"><!-- : ( Year ) (S) -->
				<table class="search_in" border="0">
					<tr class="h23">
						<td width="7%">YYYY-MM</td>
						<td width="14%"><input type="text" name="f_rev_yrmon" class="input1" style="width:70" value="" maxlength="7"  onKeyPress="ComKeyOnlyNumber(window)" onFocus="this.value=ComReplaceStr(this.value, '-', '');" onBlur="addDash(this , 4);"></td>
						<td colspan="7">&nbsp;</td>
					</tr>
					<tr class="h23">
						<td colspan="2">Trade <input type="radio" class="trans"	name="istrade" value="YES" onClick="chgItem('YES');">
						&nbsp; Lane <input type="radio" class="trans" name="istrade"value="NO" onClick="chgItem('NO');" checked></td>
						<td width="4%">Trade</td>
						<td width="15%" style="padding-left: 5;">
							<script language="javascript">ComComboObject('f_trd_cd',1, 110 , 0 )</script>
						</td>
						<td width="3%">Lane</td>
						<td width="16%" style="padding-left: 5;">
							<script language="javascript">ComComboObject('f_rlane_cd',1, 110 , 0 )</script>
						</td>
						<td width="2%">Dir.</td>
						<td style="padding-left: 7;">
							<script language="javascript">ComComboObject('f_dir_cd',1, 110 , 0 )</script>
						</td>
					</tr>
				</table>
				<!-- : ( Year ) (E) --></td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

		<table class="height_10">
			<tr>
				<td></td>
			</tr>
		</table>



		<!-- **************** Tab BG Box - 'A' (OutSide) (S) ********************* -->
		<!-- TABLE '#D' : ( Tab BG Box - 'A' ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">


				<table class="search" border="0">
					<tr>
						<td class="title_h"></td>
						<td class="title_s">MRI Inquiry</td>
					</tr>
					<tr>
						<td class="height_8"></td>
					</tr>
				</table>

				<!-- : ( Grid : No. ) (S) -->
				<table width="100%" id="mainTable">
					<tr>
						<td><script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- : ( Grid : No. ) (E) --> <!-- : ( Button : Grid ) (S) -->
				<table width="100%" class="button">
					<tr>
						<td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>

								<!-- Repeat Pattern -->
								<!--
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" id="btng_RowAdd" name="btng_RowAdd">RowAdd</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>

								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" id="btng_Save" name="btng_Save">Save</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>
								-->
								<!-- Repeat Pattern -->


							</tr>
						</table>
						</td>
					</tr>
				</table>
				<!-- : ( Button : Grid ) (E) --></td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box - 'A' ) (E) --></td>
	</tr>
</table>
<!-- Outer Table (E)--></form>
</body>
</html>

<!-- 개발자 작업  끝 -->
