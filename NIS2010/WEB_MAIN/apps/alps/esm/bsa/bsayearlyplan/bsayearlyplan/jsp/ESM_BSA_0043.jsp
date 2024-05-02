<%
/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_BSA_0043.jsp
*@FileTitle : Target VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.24
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2011.01.24 최성민
* 1.0 Creation
*=========================================================
* History :
* 2011.04.04 이관샨 [CHM-201109933-01] 화면상 불필요한 선 정리 
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.event.EsmBsa0043Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%>

<%
	EsmBsa0043Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.BSAYearlyPlan.BSAYearlyPlan");
	String xml = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBsa0043Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		xml = HttpUtil.makeXML(request,response); 
        xml = xml.replaceAll("\"", "'");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Target VVD</title>
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
<iframe height="0" width="0" name="frmHidden"></iframe>
<iframe height="0" width="0" name="frmHidden2"></iframe>

<form name="form" onKeyUp="ComKeyEnter();" >
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="iPage">
<input type="hidden" name="f_flag">
<input type="hidden" name="f_sRow">
<input type="hidden" name="f_trd_cd"> <!-- sheet의 trade combo or form의 trade combo가 변경된 trade 코드-->
<input type="hidden" name="f_type_cd"><!-- creation 시 팝업에서 받은 type코드 -->

<input type="hidden" name="fm_date" value="20090101"><!-- 배치용 시작일자 -->
<input type="hidden" name="to_date" value="99991231"><!-- 배치용 종료일자 -->
<input type="hidden" name="sXml" value="<%=xml%>"> 

<input type="hidden" name="backendjob_key">

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
  <tr>
    <td>
      <!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr>
          <td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td>
        </tr>
        <tr>
          <td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td>
        </tr>
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


                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_Auto" name="btn_Auto">Creation</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_Downexcel" name="btn_Downexcel">Down Excel</td>
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
      <!--Button_L (E) -->


      <!-- TABLE '#D' : ( Search Options ) (S) -->
      <table class="search">
        <tr>
          <td class="bg">
            <!-- : ( Year ) (S) -->
            <table class="search_in" border="0">
              <tr class="h23">
                <td colspan="8">
                  <script language="javascript">coaPeriod1();</script>
                </td>
                <td>VVD</td>
                <td colspan="4">
                  <input type="text" size="4" name="f_vsl_cd"     maxlength="4" onKeyPress="ComKeyOnlyAlphabet('uppernum');" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled; width:60;" >
                  <input type="text" size="4" name="f_skd_voy_no" maxlength="4" onKeyPress="ComKeyOnlyNumber(window);" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled; width:60;">
                  <input type="text" size="1" name="f_dir_cd"     maxlength="1" onKeyPress="ComKeyOnlyAlphabet('upper');" style="ime-mode:disabled; width:30;" >
                </td>
              </tr>
              <tr>
                <td class="line_bluedot" colspan="12"></td>
              </tr>
              <tr class="h23">
                <td width="50" style="text-indent:7;">Trade</td>
                <td width="130">
                	<script language="javascript">ComComboObject('f_seltrade',1, 100 , 0 )</script>
                </td>
                <td width="50">R/Lane</td>
                <td width="130">
                	<script language="javascript">ComComboObject('f_selrlane',1, 100 , 0 )</script>
                </td>
                <td width="50">S/Lane</td>
                <td width="130">
                	<script language="javascript">ComComboObject('f_selslane',1, 100 , 0 )</script>
                </td>
                <td width="60">Direction</td>
                <td width="120">
                	<script language="javascript">ComComboObject('f_seldir',1, 80 , 0 )</script>
                </td>
                <td width="25">IOC</td>
                <td width="110">
                	<script language="javascript">ComComboObject('f_selioc',1, 80 , 0 )</script>
                </td>
                <td>
                <!--<input type="checkbox" name="f_chkdel" value="Y" class="trans" onClick="chgViewColumn();">&nbsp;Deleted Data
                --></td>
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
            <!-- : ( POR ) (S) -->
            <table width="100%" id="mainTable">
              <tr>
                <td align="right" valign="bottom">
                  <div id="div_zoom_in" style="display:inline"> <!-- absolute / relative -->
                  <img class="cursor" src="/hanjin/img/bu_prev01.gif" width="20" height="11" border="0" name="bu_zoom_in" alt="Zoom in(+)">
                  </div>
                  <div id="div_zoom_out" style="display:none">
                  <img class="cursor" src="/hanjin/img/bu_next01.gif" width="20" height="11" border="0" name="bu_zoom_out" alt="Zoom out(-)">
                  </div>
                </td>
              </tr>
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

</form>
</body>
</html>