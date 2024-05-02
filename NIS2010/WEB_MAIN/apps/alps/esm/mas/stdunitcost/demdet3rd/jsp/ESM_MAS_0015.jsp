<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0015.jsp
*@FileTitle : DEM/DET 3RD조회수정
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.24
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2009.08.24 송호진
* 1.0 Creation
* 2008-04-21 전성진 CSR No.N200804105939
*					Vol Discount 추가 화면명 변경.
* 2008.05.07 PEJ R200804296325 css 파일 참조 확인 및 수정 요청
* 2008.09.22 김태윤 N200808278919 Spilt 01-MAS_Report내 수정사항 (메뉴명과 윈도우 타이틀명 일치.)
* 2009.08.28 송호진 ALPS 전환
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.mas.stdunitcost.demdet3rd.event.EsmMas0015Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List"%>

<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>

<%
//	EsmMas0015Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
    String[] appCd = null;
	Logger log = Logger.getLogger("com.hanjin.apps.STDUnitCost.DemDet3rd");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

//		event = (EsmMas0015Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        appCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("appList"), true);

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>DEM/DET 3RD조회수정</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
var tpSzValue = " |DRY|SPC";
var tpSzText = " |DRY|SPC";
var trdCdValue = " |<%=appCd[0]%>";
var trdCdText = " |<%=appCd[1]%>";   
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		ComSetFocus(document.form.f_cost_yrmon); 
	}
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onLoad="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;" onKeyDown="ComKeyEnter();" >
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="v_ofc_cd" value="<%=strOfc_cd %>">

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
					
                   <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_Month_Copy" name="btn_Month_Copy">Month Copy</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>		
                  </td>			
					
					<!-- Repeat Pattern -->

				</tr></table>

			</td></tr>
		</table>
        <!-- TABLE '#D' : ( Button : Main ) (E) -->


		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
		<tr><td class="bg">

		<!-- : ( Month ) (S) -->
		<table class="search_in" border="0">
		<tr class="h23">
			<td width="7%">YYYY-MM</td> <!--   -->
			<td width="15%"><input type="text" class="input1" name="f_cost_yrmon" style="width:60" value="" maxlength="7" onKeyPress="ComKeyOnlyNumber(this);" onBlur="addDash(this, 4);" onFocus="ComClearSeparator(this, 'ym','-');this.select();" ></td>
			<td width="71"></td>
		<tr><td class="height_5" colspan="2"></td></tr>
		</table>
		<!-- : ( Month ) (E) -->

		</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>


		<!-- TABLE '#D' : ( Tab BG Box - 'A' ) (S) -->
		<table class="search" border="0">
		<tr><td class="bg">

				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">DEM/DET, Vol Discount Inquiry</td></tr>
				</table>


				<!-- : ( Demurrage ) (S) -->
				<!--
				<table class="search" border="0" style="width:100%;">
				<tr class="h23">
					<td width="70%">
					<input type="radio" value="" class="trans" name="code" checked>&nbsp;Demurrage / Detention&nbsp;&nbsp;&nbsp;
					<input type="radio" value="" class="trans" name="code" >&nbsp;3rd Party Billing</td>
					<td width="30%" class="gray" rowspan="2">(USD)</td></tr>
				<tr><td class="height_2"></td></tr>
				</table>
				 -->
				<!-- : ( Demurrage ) (E) -->


				<!-- : ( Grid : Week ) (S) -->
				<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,
					 'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->
					<table width="100%" id="mainTable">
						<tr><td>
						 	<script language="javascript">ComSheetObject('sheet1');</script>
						</td></tr>
					</table>
				<!-- : ( Grid : Week ) (E) -->


				<!--  Button_Sub (S) -->
				<table width="100%" class="button" id="btn_control">
			       	<tr><td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0">
					<tr>

						<!-- Repeat Pattern -->
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>

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
                                 <td class="btn2" id="btng_RowDel" name="btng_RowDel">RowDel</td>
                                 <td class="btn2_right"></td>
                             </tr>
                         </table>
                         </td>
                         						
						<td class="btn2_left"></td><td class="btn2" id="btng_save" name="btng_save">Save</td><td class="btn2_right"></td>
						
						
						</tr></table></td>
						<!-- Repeat Pattern -->

					</tr></table>
				</td></tr>
				</table>
	    		<!-- Button_Sub (E) -->


			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box - 'A' ) (E) -->


</td></tr>
</table>
<!-- Outer Table (E)-->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>