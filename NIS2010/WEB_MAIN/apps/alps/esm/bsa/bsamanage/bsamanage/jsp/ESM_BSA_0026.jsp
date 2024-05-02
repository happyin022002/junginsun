<%
/*=========================================================
* Copyright(c) 2006 CyberLogitec
* @FileName : ESM_BSA_0026.jsp
* @FileTitle : Inquire/Edit Step-up/Down by Port
* Open Issues :
* Change history :
* @LastModifyDate : 2006-09-18
* @LastModifier : Kim Jong Beom
* @LastVersion : 1.0
*  2006-09-18 Kim Jong Beom
*  1.0 최초 생성
* 2009-08-21 Kim Ki Dae
*             ENIS ---> ALPS 변환 작업및 소스정리
*=========================================================
* History :
* 2008.05.07 PEJ R200804296325 css 파일 참조 확인 및 수정 요청
* 2009.08.01 김기대 ENIS ---> ALPS 변환
* 2010.10.04 이행지 [CHM-201005758-01] BSA  Architecture 위배사항 수정 (CommonSC)
* 2011.04.04 이관샨 [CHM-201109933-01] 화면상 불필요한 선 정리 
=========================================================
*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.event.EsmBsa0026Event"%>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%> 
<%
	EsmBsa0026Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String headSet = "";
	String pageRows  = "100";
	String flag = "N";
	
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.BSAManage.BSAManage");
    String xml = "";
    
    try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBsa0026Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		//ESM_BSA_021에서 호출시 처리
		flag = JSPUtil.getNull(request.getParameter("flag"));
	    flag = (flag=="") ? "N" : flag;

        xml = HttpUtil.makeXML(request,response); 
        xml = xml.replaceAll("\"", "'");
    }catch(Exception e) {
		out.println(e.toString());
	}
%>

<html>
<head>
<title>Inquire/Edit Step-up/Down by Port SC</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
    function setupPage() {
        loadPage();
        document.form.txtSDate.focus();
    }
</script>

</head>

<body onload="javascript:setupPage();">
<iframe height="0" width="0" name="frmHidden" id="frmHidden"></iframe>

<form method="post" name="form" onSubmit="return false;" onKeyDown="keyEnter_loc();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="flag" value="<%= flag %>">
<input type="hidden" name="param1"> <!-- Gubun   |  Method Name -->
<input type="hidden" name="param2"> <!-- Year    |  vsl_cd      -->
<input type="hidden" name="param3"> <!--         |  skd_voy_no  -->
<input type="hidden" name="param4"> <!--         |  dir_cd      -->
<input type="hidden" name="param5"> <!-- sMonth  |              -->
<input type="hidden" name="param6"> <!-- eMonth  |              -->
<input type="hidden" name="param7"> <!-- sWeek   |              -->
<input type="hidden" name="param8"> <!-- eWeek   |              -->
<input type="hidden" name="sXml"          value="<%=xml%>"> 
<input type="hidden" name="carrierCd" value="SML"> 

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
  <tr>
    <td>
	  <!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<%
		if (flag == "N") { // 정상적인 좌측메뉴 클릭시
			flag = "N";
		%>
		 <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
	        <tr>
	          <td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td>
	        </tr>
	        <tr>
	          <td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td>
	        </tr>
	      </table>
		<%
		} else {
			flag = "Y";
		%>
		 <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr>
			<td class="history"><img src="img/icon_history_dot.gif" align="absmiddle">&nbsp;BSA > BSA Table > Manage BSA-Contract</td></tr>
		<tr>
			<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;&nbsp;Port Step Up/Down</td></tr>
		</table>
		<%
		}
		%>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->	
      <!-- ----------------------------------------------------------------------------------------------- -->

      <!-- TABLE '#D' : ( Button : Main ) (S) -->
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
                      <td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
               
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td>
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
      <!-- TABLE '#D' : ( Button : Main ) (E) -->

      <!-- TABLE '#E' : ( Search Options ) (S) -->
      <table class="search">
        <tr>
          <td class="bg">
            <table class="search_in" border="0">
              <tr class="h23">
                <td width="60" style="text-indent:7;">Period</td>
                <td width="280">
                    <input class="input1" type="text" name="txtSDate" style="width:75;text-align:center;" maxlength="8"
                           onkeyPress="ComKeyOnlyNumber(window);" onKeyUp="ComKeyEnter('LengthNextFocus');" 
                    	   onBlur="this.value = ComGetMaskedValue(this.value, 'ymd');" 
                    	   onFocus="ComClearSeparator(this,'ymd','-');this.select();">&nbsp;
                    <img name="btns_calendar1" src="/hanjin/img/button/btns_calendar.gif" class="cursor"
                         width="19" height="20" border="0" align="absmiddle">
                    &nbsp;~&nbsp;
                    <input type="text" name="txtEDate" style="width:75;text-align:center;" maxlength="8"
                           onkeyPress="ComKeyOnlyNumber(window);" onKeyUp="ComKeyEnter('cobTrade');"
                           onBlur="this.value = ComGetMaskedValue(this.value, 'ymd');" onFocus="ComClearSeparator(this,'ymd','-');this.select();">
                    <img name="btns_calendar2" src="/hanjin/img/button/btns_calendar.gif" class="cursor"
                         width="19" height="20" border="0" align="absmiddle">
                </td>
                <td width="150" class="stm">(ETD of 1st Port)</td>
                <td width="40">Trade</td>
                <td width="130"><script language="javascript">ComComboObject('cobTrade', 1, 60 , 0 )</script></td>
                <td width="35">Lane</td>
                <td width="130"><div id="div_rLane"><script language="javascript">ComComboObject('cobLane', 1, 60 , 0 )</script></div></td>
                <td width="30">Dir.</td>
                <td><script language="javascript">ComComboObject('cobDir', 1, 60 , 0 )</script></td>
              </tr>
            </table>
            <table class="search_in" border="0">
              <tr><td class="line_bluedot" colspan="9"></td></tr>
            </table>
            <table class="search_in" border="0">
              <tr class="h23">
                <td colspan="4">
                  <input type="radio" value="J" class="trans" name="rdoOp_cd" checked>Joint Operating&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  <input type="radio" value="S" class="trans" name="rdoOp_cd">Space Chartering
                </td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
      <!-- TABLE '#E' : ( Search Options ) (E) -->

      <table class="height_10"><tr><td></td></tr></table>


      <!-- TABLE '#F' : (S) -->
      <table class="search">
        <tr>
          <td class="bg">
            <!-- table class="search" border="0" style="width:737;" -->
            <table class="search_in" border="0" style="width:100%;">
              <tr class="h23">
                <td width="80%">
                  <input type="radio" name="rdoType" value="007" text="BSA(TEU)"     class="trans" checked>&nbsp;BSA&nbsp;&nbsp;&nbsp;
                  <input type="radio" name="rdoType" value="015" text="Slot Price"   class="trans">&nbsp;Slot Price&nbsp;&nbsp;&nbsp;
                  <input type="radio" name="rdoType" value="016" text="Weight Limit" class="trans">&nbsp;Weight Limit&nbsp;&nbsp;&nbsp;
                  &nbsp;&nbsp;&nbsp;
                  <div id="div_carrier" style="display:inline" >
                  Carrier&nbsp;&nbsp;<script language="javascript">ComComboObject('cobCarrier', 1, 60 , 0 )</script>
                  </div>
                </td>
                <td width="20%" align="right" valign="bottom" style="padding-right:5;">
                  <div id="div_zoom_in" style="display:inline"> <!-- absolute / relative -->
                  <img class="cursor" src="/hanjin/img/bu_prev01.gif" width="20" height="11" border="0" name="bu_zoom_in" alt="Zoom in(+)">
                  </div>
                  <div id="div_zoom_out" style="display:none">
                  <img class="cursor" src="/hanjin/img/bu_next01.gif" width="20" height="11" border="0" name="bu_zoom_out" alt="Zoom out(-)">
                  </div>
                </td>
              </tr>
            </table>

            <table width="100%">

              <tr>
                <td width="100%">
                  <div id="tabLayer1" style="display:inline">
                  <table width="100%">
                    <tr>
                      <td width="69%">
                        <table width="100%" id="mainTable1">
                          <tr><td><script language="javascript">ComSheetObject('sheet1');</script></td></tr>
                        </table>
                      </td>
                      <td width="2%"></td>
                      <td width="29%">
                        <table width="100%" id="mainTable2">
                          <tr><td><script language="javascript">ComSheetObject('sheet2');</script></td></tr>
                        </table>
                      </td>
                    </tr>
                  </table>
                  </div>

                  <div id="tabLayer2" style="display:inline">
                  <table width="100%">
                    <tr>
                      <td width="69%">
                        <table width="100%" id="mainTable3">
                          <tr>
                            <td><script language="javascript">ComSheetObject('sheet3');</script></td>
                          </tr>
                        </table>
                      </td>
                      <td width="2%"></td>
                      <td width="29%">
                        <table width="100%" id="mainTable4">
                          <tr>
                            <td><script language="javascript">ComSheetObject('sheet4');</script></td>
                          </tr>
                        </table>
                      </td>
                    </tr>
                  </table>
                  </div>
                </td>
              </tr>


              <tr>
                <td width="100%">
                  <table width="100%">
                    <tr>
                      <td width="70%">
                        <!-- : ( Button : Sub ) (S) -->
                        <table width="100%" class="button">
                          <tr>
                            <td class="btn2_bg">
                              <table border="0" cellpadding="0" cellspacing="0">
                                <tr>
                                  <!-- Repeat Pattern -->
                                  <td>
                                  <div id="div_save" style="display:none">
                                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                      <tr>
                                        <td class="btn2_left"></td>
                                        <td class="btn2" name="btng_save1" id="btng_save1">Save</td>
                                        <td class="btn2_right"></td>
                                      </tr>
                                    </table>
                                  </div>
                                  </td>
                                  <td>
                                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                      <tr>
                                        <td class="btn2_left"></td>
                                        <td class="btn2" name="btng_reset" id="btng_reset">Reset</td>
                                        <td class="btn2_right"></td>
                                      </tr>
                                    </table>
                                  </td>
                                  <!-- Repeat Pattern -->
                                </tr>
                              </table>
                          </td></tr>
                        </table>
                      </td>
                      <td width="30%">
                        <table width="100%" class="button">
                          <tr>
                            <td class="btn2_bg">
                              <table border="0" cellpadding="0" cellspacing="0">
                                <tr>
                                  <!-- Repeat Pattern -->
                                  <td>
                                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                      <tr>
                                        <td class="btn2_left"></td>
                                        <td class="btn2" name="btng_portadd" id="btng_portadd">Port Add</td>
                                        <td class="btn2_right"></td>
                                      </tr>
                                    </table>
                                  </td>
                                  <td>
                                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                      <tr>
                                        <td class="btn2_left"></td>
                                        <td class="btn2" name="btng_save2" id="btng_save2">Save</td>
                                        <td class="btn2_right"></td>
                                      </tr>
                                    </table>
                                  </td>
                                  <td>
                                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                      <tr>
                                        <td class="btn2_left"></td>
                                        <td class="btn2" name="btng_creation" id="btng_creation">Creation</td>
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
                        <!-- : ( Button : Sub ) (E) -->
                      </td>
                    </tr>
                  </table>
                </td>
              </tr>


            </table>
          </td>
        </tr>
      </table>
      <!-- TABLE '#F' : (E) -->

      <!-- ----------------------------------------------------------------------------------------------- -->

    </td>
  </tr>
</table>
<!-- Outer Table (E)-->

</form>
</body>
</html>

<script language="javascript">
<!--
    with(document.form) {
    <%
        //ESM_BSA_021에서 호출시 처리
        //String bsa_op_cd = JSPUtil.getParameter(request, "bsa_op_cd");
        //if( bsa_op_cd == null || bsa_op_cd.equals("") || bsa_op_cd.equals("null") ) {
        //  bsa_op_cd = "J";
        //}
    %>
        //기본처리
        cobCarrier.value = "SML";
        if (cobCarrier.value == "") { cobCarrier[0].selected = true; }

        //초기값 샛팅
        //if (txtSDate.value == "") { txtSDate.value = getCurrDate("-"); } /* 현재일자  */
    }
-->
</script>
