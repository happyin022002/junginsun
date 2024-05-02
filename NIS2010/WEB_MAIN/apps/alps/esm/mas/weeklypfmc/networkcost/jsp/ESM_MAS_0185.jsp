<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0185.jsp
*@FileTitle : Port Tariff Modification
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.15
*@LastModifier : SJ KIM
*@LastVersion : 1.0 
=========================================================
* History
* =========================================================
*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%
    Exception serverException   = null;             //서버에서 발생한 에러
    String strErrMsg    = "";                       //에러메세지
    Logger log = Logger.getLogger("com.hanjin.alps.esm.mas.ESM_MAS_0185");
    try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
    } catch(Exception e) {
        log.error("JSP Exception : " + e.toString());
    }
    
    String f_yearweek = JSPUtil.getNull(JSPUtil.getParameter(request,"f_yearweek"));
%>
<html>
<head>
<title>Port Tariff Inquiry</title>
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

<body onload="javascript:setupPage();" >
<form method="post" name="form" onKeyDown="ComKeyEnter();">
<input  type="hidden" name="f_cmd">

<input type="hidden" name="backendjob_key">
<input type="hidden" name="f_yrtype"    value="<%="W"%>"> 
<input type="hidden" name="cost_wk" value="<%=f_yearweek %>"> 
<input type="hidden" name="cnt_cd" > 

<!-- Outer Table (S)-->
<table width="100%" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

      <!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr>
          <td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;&nbsp;Port Tariff Modification</td>
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
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_Close" name="btn_Close">Close</td>
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

            <table border="0">              
              <tr class="h23">                
                <td width="10%">YYYY-WW</td>
                <td width="10%"><input type="text" class="input1" style="width:60" name="f_yearweek" maxlength="6" onkeyPress="ComKeyOnlyNumber(window);" dataformat="yw" >&nbsp;</td>              
                <td class="sm"><span id="div_period"></span>&nbsp;</td>
                
                <td width="10%">Country&nbsp;</td>
                <td> <select id="f_cust_cnt_cd"name="f_cust_cnt_cd" class="input1" style="width:80" onchange="setName(this.value);">
                		<option value="CN" selected>China</option>
                		<option value="IT">Italy</option> 
                     </select>             
                </td>
                
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
            <!-- : ( Year ) (S) -->

            <table border="0">              
              <tr class="h23">                
                <td width="100">Weekly Cost&nbsp;</td>
                <td width="100"><input type="text" class="input2" name="cnt_nm" style="width:100;text-align:center" readonly></td>
                <td width="400"><input type="text" name="wk_ttl_amt" style="width:100;text-align:right" maxlength="15" onkeyPress="ComKeyOnlyNumber(window);"></td>
                <td width="600"></td>
              </tr>
            </table>
            <!-- : ( Year ) (E) -->
          </td>
        </tr>
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
      
    </td>
  </tr>
</table>
<!-- Outer Table (E)-->        


</form>
</body>
</html>
