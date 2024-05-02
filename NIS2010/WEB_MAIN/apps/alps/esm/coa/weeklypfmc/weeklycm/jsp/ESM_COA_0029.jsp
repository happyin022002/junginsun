<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_COA_0029.jsp
*@FileTitle : 주간 대상항차 생성/조회/수정
*Open Issues :
*Change history :
    ' 2008.02.15 PEJ N200801154874 주간 대상항차 기준 변경 관련 요청
    '    변경사항 : Year, Month, Week관련 화면변경
    ' 2008.05.07 PEJ R200804296325 css 파일 참조 확인 및 수정 요청
    ' 2009.03.13 김태윤 N200903110001 - VVD Code에 영문 외 숫자도 입력가능하게 수정
    ' 2009.03.16 김종열 N200903100130 - VVD Code에 영문 외 숫자도 입력가능하게 수정
    ' 2009.05.18 배진환 N200905130071 - COA_조회 조건 입력 관련 수정
    ' 2009.10.23 김기대 New FrameWork 적용
    ' 2010.09.01 김기종 CSR No. CHM-201004982-01 COA Architecture 위배사항 수정 (CommonSC)
	' 2011.02.07 최성민 CHM-201108533-01 Validation 소스 정리
*@LastModifyDate : 2010.09.01
*@LastModifier : 김기종
*@LastVersion : 1.0
*=========================================================
* History
* 2011.04.18 이행지 [CHM-201110235-01] Target VVD 메뉴 내 버튼명 변경(Auto Creation-> BSA&VVD Creation) 및 위치변경, OPR 컬럼추가
* 2011.06.02 최성민 [CHM-201111115-01] Split 02-Split 03-ALPS Error 처리 요청  - backendjob_key 추가
*=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.apps.alps.esm.coa.common.Utils" %>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%> 
<%
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg    = "";                               //에러메세지
    Logger log = Logger.getLogger("com.hanjin.alps.esm.coa.ESM_COA_0029");
    String xml = "";
    try {
        //추가----------------------------------------------------------------------------------------- START
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        
        xml = HttpUtil.makeXML(request,response); 
        xml = xml.replaceAll("\"", "'");
        
    }catch(Exception e) {
        log.error("Exception : " + e.toString());
    }
%>
<html>
<head>
<title>Target VVD</title>
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


<body onload="javascript:setupPage();">
<iframe height="0" width="0" name="frmHidden"></iframe>
<iframe height="0" width="0" name="frmHidden2"></iframe>

<form method="post" name="form" onKeyUp="ComKeyEnter();" >
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="f_flag">
<input type="hidden" name="f_sRow">
<input type="hidden" name="f_trd_cd"> <!-- sheet의 trade combo or form의 trade combo가 변경된 trade 코드-->
<input type="hidden" name="f_type_cd"><!-- creation 시 팝업에서 받은 type코드 -->

<input type="hidden" name="fm_date" value="20090101"><!-- 배치용 시작일자 -->
<input type="hidden" name="to_date" value="99991231"><!-- 배치용 종료일자 -->
<input type="hidden" name="f_chkprevcre" value="N">
<input type="hidden" name="sXml" value="<%=xml%>"> 

<input type="hidden" name="backendjob_key">
<input type="hidden" name="button_key"> <!-- 이벤트를 구분하기 위함 -->

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

                <td class="btn1_line"></td>
<!-- 
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_Save" name="btn_Save">Save</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_Creation" name="btn_Creation">Creation</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                 -->
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
                <td colspan="5">
                  <input type="text" size="4" name="f_vsl_cd"     maxlength="4" onKeyPress="ComKeyOnlyAlphabet('uppernum');" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled; width:60;" >
                  <input type="text" size="4" name="f_skd_voy_no" maxlength="4" onKeyPress="ComKeyOnlyNumber(window);" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled; width:60;">
                  <input type="text" size="1" name="f_dir_cd"     maxlength="1" onKeyPress="ComKeyOnlyAlphabet('upper');" style="ime-mode:disabled; width:30;" >
                </td>
              </tr>
              <tr>
                <td class="line_bluedot" colspan="14"></td>
              </tr>
              <tr class="h23">
                <td width="50" style="text-indent:7;">Trade</td>
                <td width="80">
                	<script language="javascript">ComComboObject('f_seltrade',1, 70 , 0 )</script>
                </td>
                <td width="50">R/Lane</td>
                <td width="80">
                	<script language="javascript">ComComboObject('f_selrlane',1, 70 , 0 )</script>
                </td>
                <td width="50">S/Lane</td>
                <td width="70">
                	<script language="javascript">ComComboObject('f_selslane',1, 60 , 0 )</script>
                </td>
                <td width="60">Direction</td>
                <td width="60">
                	<script language="javascript">ComComboObject('f_seldir',1, 50 , 0 )</script>
                </td>
                <td width="70">Trade Dir.</td>
                <td width="70" style="padding-left:2px">
                	<script language="javascript">ComComboObject('f_hul_bnd_cd', 1, 60, 0)</script>
                </td>
                <td width="30">IOC</td>
                <td width="55">
                	<script language="javascript">ComComboObject('f_selioc',1, 45 , 0 )</script>
                </td>
                <td><input type="checkbox" name="f_chkdel" value="Y" class="trans">&nbsp;Deleted Data</td>
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


            <!--  Button_Sub (S) -->
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
                            <td class="btn2" id="btn_Rowadd" name="btn_Rowadd">Row Add</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table>
                      </td>
	                  <td>
	                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
	                      <tr>
	                        <td class="btn2_left"></td>
	                        <td class="btn2" id="btn_Auto" name="btn_Auto">BSA & VVD Creation</td>
	                        <td class="btn2_right"></td>
	                      </tr>
	                    </table>
	                  </td>

                      <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn2_left"></td>
                            <td class="btn2" id="btn_Tsqty" name="btn_Tsqty">Create T/S Q'ty</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table>
                      </td>
 -->
                      <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn2_left"></td>
                            <td class="btn2" id="btn_Skdinquiry" name="btn_Skdinquiry">SKD Inquiry</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table>
                      </td>

                      <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn2_left"></td>
                            <td class="btn2" id="btn_Vvdcheck" name="btn_Vvdcheck">VVD Check List</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table>
                      </td>

                      <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn2_left"></td>
                            <td class="btn2" id="btn_Monthvvd" name="btn_Monthvvd">Month VVD I/F</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table>
                      </td>
 <!-- 
                      <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn2_left"></td>
                            <td class="btn2" id="btn_Apply_bsa" name="btn_Apply_bsa">Apply BSA 0</td>
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
            <!-- Button_Sub (E) -->

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