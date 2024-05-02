<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_COA_0069.jsp
*@FileTitle : EQ 회송기여도 RPT 조회 4
*Open Issues :
*Change history : CSR No. R200804296329 내부 경로 변경
*@LastModifyDate : 2006-12-08
*                : 2008-05-06
*@LastModifier : Chilseo_Park
*@LastVersion : 1.0
* 2006-12-08 Chilseo_Park
* 2008-05-06 전윤주
* 1.0 최초 생성
* =========================================================
* History
* 2008.09.22 김태윤 N200808278919 Spilt 01-COA_Report내 수정사항 (메뉴명과 윈도우 타이틀명 일치.)
* 2009.09.16 김기식 Alps전환작업
* 2010.05.28 송호진 [Legacy전환] UI 표준안 적용 요청 관련 수정 : 
                   CHM-200901714, CHM-200901715, CHM-200901716, CHM-200901717, CHM-200901718, CHM-200901719
* 2010.12.01 김기종 Ticket ID:CHM-201006305-01 COA Architecture 위배사항 수정
=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%> 
<%
Exception serverException   = null;			//서버에서 발생한 에러
String strErrMsg = "";								 //에러메세지
String cntrString = "";
String xml = "";
try {
	serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
	if (serverException != null) {
		strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
	}
	GeneralEventResponse eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
	cntrString = eventResponse.getETCData("cntrString");
	
	xml = HttpUtil.makeXML(request,response); 
    xml = xml.replaceAll("\"", "'");
}catch(Exception e) {
	out.println(e.toString());
}

%>
<html>
<head>
<title>Minimum G.RPB</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		var cntrs = '<%=cntrString%>';
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if

		loadPage(cntrs);
		ComSetFocus(document.form.f_cost_yrmon);
	}
</script>
</head>
<iframe height="0" width="0" name="frmHidden"></iframe>
<body onLoad="javascript:setupPage();">
<form method="post" name="form" onKeyDown="ComKeyEnter();">
  <input type="hidden" name="f_cmd">
  <input type="hidden" name="iPage">
  <input type="hidden" name="f_cntrNo" value="">
  
  <input type="hidden" name="f_dir_cd">
  <input type="hidden" name="f_rlane_cd">
  <input type="hidden" name="f_pol">
  <input type="hidden" name="f_pod">
  <input type="hidden" name="f_por">
  <input type="hidden" name="f_del">
  <input type="hidden" name="f_cntr_tpsz_cd">
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


                    <!-- : ( Year ) (S) -->
                    <table class="search_in" border="0">
                      <tr class="h23">
                        <td width="110"><img class="nostar">YYYY-MM</td>
                        <td >
                          <input type="text" style="width:80" class="input1" name="f_cost_yrmon" value="" maxlength="7" onKeyPress="ComKeyOnlyNumber(this);" onBlur="addDash(this , 4);" onFocus="this.value=ComReplaceStr(this.value, '-', '');" onKeyUp="ComKeyEnter('LengthNextFocus');">
                        </td>
                      </tr>
                    </table>
                    <!-- : ( Year ) (E) -->

					<table class="search_in" border="0">
					<tr><td class="line_bluedot" style="height:11;"></td></tr>
					</table>

                    <!-- : ( By Office ) (S) -->
                    <table class="search_in" border="0">
                      <tr class="h23">
                        <td width="110" class="gray_tit"><img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">By Route</td>
                        <td width="110">POR</td>
                        <td width="133"><input type="text"       style="width:80" name="f_por_s" value="" maxlength="5" onKeyUp="upper(this);ComKeyEnter('LengthNextFocus');"></td>
                        <td width="110">Revenue POL</td>
                        <td width="133"><input type="text" style="width:80" name="f_pol_s" value="" maxlength="5" onKeyUp="upper(this);ComKeyEnter('LengthNextFocus');"></td>
                        <td width="90">Revenue POD</td>
                        <td width="133"><input type="text" style="width:80" name="f_pod_s" value="" maxlength="5" onKeyUp="upper(this);ComKeyEnter('LengthNextFocus');"></td>
                        <td width="70">DEL</td>
                        <td><input type="text"      style="width:100%" name="f_del_s" value="" maxlength="5" onKeyUp="upper(this);"></td>
                      </tr>

                      <tr class="h23">
                        <td class="gray_tit"><img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">By Others</td>
                        <td>Rep. Commodity</td>
                        <td style="padding-left:2;">
                        	<script language="javascript">ComComboObject('f_r_cmdt', 3, 80 , 0 )</script>
                        </td>
                        <td>Commodity Code</td>
                        <td><input type="text" style="width:80" name="f_cmdt" onKeyPress="ComKeyOnlyNumber(this);" value="" maxlength="6" ></td>
                        <td>US Mode</td>
                        <td>
                        	<script language="javascript">ComComboObject('f_usa_mode',1, 80 , 0 )</script>
                        </td>
                        <td>Type/Size</td>
                        <td>
                        	<script language="javascript">ComComboObject('f_cntr_tpsz_cd_s', 1, 80, 1, 0, 2);</script>&nbsp;
                        </td>
                      </tr>
                    </table>
                    <!-- : ( By Office ) (E) -->
                  </td>
                </tr>
              </table>
              <!-- TABLE '#D' : ( Search Options ) (E) -->


              <table class="height_10"><tr><td></td></tr></table>


              <!-- TABLE '#D' : ( Search Options ) (S) -->
              <table class="search">
                <tr>
                  <td class="bg">


                    <table class="search" border="0">
                      <tr>
                        <td class="title_h"></td>
                        <td class="title_s">Performance Inquiry</td>
                      </tr>
                    </table>


                    <!-- : ( POR ) (S) -->
                    <table width="100%" id="mainTable">
                      <tr>
                        <td>
                          <script language="javascript">ComSheetObject('sheet1');</script>
                        </td>
                      </tr>
                    </table>
                    <!-- : ( POR ) (E) -->




					<!--  Button_Sub (S) -->
					<table width="100%" class="button">
				       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>

							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_costdetail" name="btng_costdetail">Cost Detail</td><td class="btn2_right"></td></tr></table></td>
							<!-- Repeat Pattern -->


						</tr></table>
					</td></tr>
					</table>
			    	<!-- Button_Sub (E) -->

                    <table class="search" border="0"><tr><td class="line_bluedot"></td></tr></table>

                    <table class="search" border="0">
                      <tr>
                        <td class="title_h"></td>
                        <td class="title_s">Cost Detail Inquiry</td>
                      </tr>
                    </table>


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
