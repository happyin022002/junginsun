<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0311.jsp
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.10
*@LastModifier : 김종옥
*@LastVersion : 1.0
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    Logger log = Logger.getLogger("com.hanjin.alps.esm.mas.ESM_MAS_0311");
    String stnd_cost_cd = ((request.getParameter("stnd_cost_cd")==null )?"":request.getParameter("stnd_cost_cd"));
    String f_yearweek = "";
    try {
        //추가----------------------------------------------------------------------------------------- START
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        f_yearweek = request.getParameter("f_yearweek");
        //yearWeek = "2014-48";
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        //추가----------------------------------------------------------------------------------------- END
    }catch(Exception e) {
        log.error("ESM_MAS_0311 Exception : "+e.toString());
    }

%>
<html>
<head>
<title>Missing List</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
    function setupPage() {
        loadPage();
    }
</script>
</head>

<body onload="javascript:setupPage();" onunload="callParentFnc();">
<form method="post" name="form" onKeyUp="ComKeyEnter();">
<input type="hidden" name="f_cmd">
<input type="hidden" name ="stnd_cost_cd" value="<%=stnd_cost_cd%>">

<!-- OUTER - POPUP (S)tart -->
<table width="900" class="popup" cellpadding="10" border="0">
  <tr><td class="top"></td></tr>
  <tr>
    <td valign="top">

      <!-- : ( Title ) (S) -->
      <table width="100%" border="0">
        <tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp; MAS 사선고정비 메뉴얼 비용 수정</td></tr>
      </table>
      <!-- : ( Title ) (E) -->

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
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_Create" name="btn_Create">Create</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
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

      <div id="layer" style="display:none">
      <input type="radio" name="f_yrtype" class="trans" value="yrwk" checked>
      </div>
      
      <!-- TABLE '#D' : ( Search Options : Speed ) (S) -->
      <table class="search">
        <tr>
          <td class="bg">
            <table class="search" border="0">
              <tr class="h23">
                <td width="8%">YYYY-WW</td>
                <td width="9%"><input type="text" class="input1" style="width:60" name="f_yearweek" value="<%=f_yearweek%>" maxlength="6" onkeyPress="ComKeyOnlyNumber(window);" onfocus="ComClearSeparator(this,'', '-');this.select();" onblur="javascript:fnYearWeekSet(this);"></td>
                <td width="20%" class="sm"><div id="div_period"></div></td>
                <td width="8%">Cost Item</td>
                <td width="25%">&nbsp;<script language="javascript">ComComboObject('f_cobcost',1, 180 , 0 )</script></td>
                <td width="8%">Amount</td>
                <td width=""><input type="text" style="width:160;text-align:right;" name="f_ttl_amt" value="" maxlength="25" onkeyPress="ComKeyOnlyNumber(window);" onfocus="ComClearSeparator(this,'', ',');this.select();" onblur="javascript:fnAmountSet(this);"></td>
              </tr>
            </table>
            <table class="line_bluedot"><tr><td></td></tr></table>
            <!-- : ( Speed ) (S) -->
            <table width="100%" id="mainTable">
              <tr>
                <td><script language="javascript">ComSheetObject('sheet1');</script></td>
              </tr>
            </table>
            <!-- : ( Speed ) (E) -->
          </td>
        </tr>
      </table>
      <!-- TABLE '#D' : ( Search Options : Speed ) (E) -->

    </td>
  </tr>
</table>
<!-- OUTER - POPUP (E)nd -->


<table class="height_5"><tr><td></td></tr></table>


<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
  <tr>
    <td height="71" class="popup">
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
        <tr>
          <td class="btn3_bg">
            <table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <!-- Repeat Pattern -->
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_Close" id="btn_Close">Close</td>
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
    </td>
  </tr>
</table>
<!-- : ( Button : pop ) (E) -->


</form>
</body>
</html>

