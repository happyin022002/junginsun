<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_MAS_068.jsp
*@FileTitle : EQ 회송기여도 RPT 조회 3
*Open Issues :
*Change history : CSR No. R200804296329 내부 경로 변경
*@LastModifyDate : 2006-12-08
*                : 2008-05-06
*@LastModifier : Chilseo_Park
*              : 전윤주
*@LastVersion : 1.0
* 2006-12-08 Chilseo_Park
* 2008-05-06 전윤주
* 1.0 최초 생성
* =========================================================
* History
* 2008.09.22 김태윤 N200808278919 Spilt 01-MAS_Report내 수정사항 (메뉴명과 윈도우 타이틀명 일치.)
* 2009.09.16 김기식 Alps전환작업
=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>

<%
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";								 //에러메세지
	String cntrString = "";

	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		GeneralEventResponse eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
		cntrString = eventResponse.getETCData("cntrString");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>PFMC by BKG</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var cntrs = '<%=cntrString%>';
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if

		loadPage(cntrs);
		ComSetFocus(document.form.f_bkg_no);
	}
</script>
</head>

<body onLoad="javascript:setupPage();">
<form method="post" name="form" onKeyDown="ComKeyEnter();">
  <input	type="hidden" name="f_cmd">
  <input type="hidden" name="iPage">
  <input type="hidden" name="f_cntrNo" value="">
  <input type="hidden" name="cntrs" value="<%=cntrString%>">


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

					<td class="btn1_line"></td>

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

              <!-- : ( Booking ) (S) -->
              <table class="search_in" border="0">
                <tr class="h23">
					<td width="90">Booking</td>
					<td><input type="text" style="width:157" class="input1" name="f_bkg_no" value="" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')" maxlength="13" >
						<!--input type="text" style="width:25" class="input1" name="f_bkg_no_split" value="" maxlength="2"--></td>
                </tr>
              </table>
              <!-- : ( Booking ) (E) -->
            </td>
          </tr>
        </table>
        <!-- TABLE '#D' : ( Search Options ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>

	    <!-- TABLE '#D' : ( Search Options ) (S) -->
	    <table class="search">
	    <tr><td class="bg">

	          <!-- : ( Year ) (S) -->
	          <table class="search_in" border="0" >
	          <tr><td class="title_h"></td>
	              <td class="title_s">BKG Performance Inquiry</td></tr>
	          <tr><td class="height_5"></td></tr>
	          </table>

	          <table class="search_in" border="0">
	          <tr class="h23">
	              <td>Booking No.</td>
	              <td colspan="3"><input type="text" style="width:157" name="f_bkg_split" value=""  disabled class="input2"></td>
	              <td>Sales Office</td>
	              <td><input type="text" style="width:81" name="f_ofc" value=""  disabled class="input2"></td>
	              <td>Shipper</td>
	              <td colspan="3" class="stm"><input type="text" style="width:122" name="f_shipper" disabled class="input2"></td>
	              <td colspan="2" class="stm" align="left"><div id="div_shipper"></div></td>
	            </tr>

	            <tr class="h23">
	              <td width="90">IOC</td>
	              <td width="47"><input type="text" style="width:20" name="f_ioc" value="" disabled class="input2"></td>
	              <td width="48">R/Lane</td>
	              <td width="110"><input type="text" style="width:62" name="f_rlane" value="" disabled class="input2"></td>
	              <td width="80">VVD</td>
	              <td width="130"><input type="text" style="width:81" name="f_vvd" value="" disabled class="input2"></td>
	              <td width="55">R/Term</td>
	              <td width="50"><input type="text" style="width:20" name="f_rterm" value="" disabled class="input2"></td>
	              <td width="52">D/Term</td>
	              <td width="70"><input type="text" style="width:20" name="f_dterm" value="" disabled class="input2"></td>
	              <td width="109">Rep. Commodity</td>
	              <td class="stm" align="left"><input type="text" style="width:50" name="f_rcmdt" value="" disabled class="input2"></td>
	              <!--<td class="stm"><div id="div_rcmdt"></div></td>  -->
	            </tr>
	          </table>

             <table class="line_bluedot"><tr><td></td></tr></table>

	         <!-- : ( POR ) (S) -->
	          <table width="100%" id="mainTable">
	            <tr>
	              <td>
	                <script language="javascript">ComSheetObject('sheet1');</script>
	              </td>
	            </tr>
	          </table>
	          <!-- : ( POR ) (E) -->

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

	          <!-- : ( POR ) (S) -->
	          <table width="100%" id="mainTable">
	            <tr>
	              <td>
	                <script language="javascript">ComSheetObject('sheet2');</script>
	              </td>
	            </tr>
	          </table>
	          <!-- : ( POR ) (E) -->


	        </td>
	      </tr>
	    </table>
	    <!-- TABLE '#D' : ( Search Options ) (E) -->



</td></tr>
</table>
<!-- Outer Table (E)-->


</form>
</body>
</html>