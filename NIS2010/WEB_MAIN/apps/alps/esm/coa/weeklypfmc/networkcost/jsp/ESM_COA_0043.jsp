<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_COA_0043.jsp
*@FileTitle : Average-hire by Own Wessel 조회/변경
*Open Issues :
*Change history :
* 2008.09.22 김태윤 N200808278919 Spilt 01-COA_Report내 수정사항 (메뉴명과 윈도우 타이틀명 일치.)
* 2009.10.23 김기대 New FrameWork 적용
* 2010.09.01 이일민 Ticket ID:CHM-201004982-01 COA Architecture 위배사항 수정
*@LastModifyDate : 2009.10.23
*@LastModifier : 김기대
*@LastVersion : 1.0

* 2012.08.14 이석준 [CHM-201219592-01] AVG-hire by Own-VSL (PA) 화면에 Load excel 기능 추가
* 2013.05.07 성미영 [SRM-201334889] AVG-hire by Own-VSL (PA) 전월 copy 기능 추가
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%
    Exception serverException = null;	//서버에서 발생한 에러
    String strErrMsg = "";              //에러메세지
    Logger log = Logger.getLogger("com.hanjin.alps.esm.coa.ESM_COA_0043");
    try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
	} catch(Exception e) {
		log.error("JSP Exception : " + e.toString());
	}
%>
<html>
<head>
<title>AVG-hire by Own-VSL (PA)</title>
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
<body onload="javascript:setupPage();form.f_yearweek.focus();">
<form method="post" name="form" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="f_header">

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
                      <td class="btn1" id="btn_Month_Copy" name="btn_Month_Copy">Month Copy</td>
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
                <!-- 
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_Loadexcel" name="btn_Loadexcel">Load Excel</td>
                      <td class="btn1_right"></td>
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
      <!--Button_L (E) -->


      <!-- TABLE '#D' : ( Search Options ) (S) -->
      <table class="search">
        <tr>
          <td class="bg">
            <!-- : ( Year ) (S) -->
            <table class="search_in" border="0">
              <tr class="h23">
                <td width="20%">
                     YYYY-MM <input type="radio" name="f_yrtype" class="trans" value="yrmon" onClick="setYrMon()" checked="true">&nbsp;&nbsp;
                     YYYY-WW <input type="radio" name="f_yrtype" class="trans" value="yrwk">&nbsp;&nbsp;
                </td>
                <td width="8%"><input type="text" style="width:60" class="input1" name="f_yearweek" maxlength="6" onkeyPress="ComKeyOnlyNumber(window);" onfocus="ComAddSeparator_Local(this, '-');this.select();" onblur="javascript:fnYearWeekSet(this);" ></td>
                <td width="22%" class="sm"><div id="div_period"></div></td>
                <td width="6%">Vessel</td>
                <td>&nbsp;<script language="javascript">ComComboObject('f_selvessel',1, 80 , 0 )</script></td>
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
                <td>
                  <script language="javascript">ComSheetObject('sheet1');</script>
                </td>
              </tr>
            </table>
            <!-- : ( POR ) (E) -->
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
                <td class="title_s">Average By Class</td>
              </tr>
              <tr><td class="height_5"></td></tr>
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
    </td>
  </tr>
</table>
<!-- Outer Table (E)-->


</form>
</body>
</html>