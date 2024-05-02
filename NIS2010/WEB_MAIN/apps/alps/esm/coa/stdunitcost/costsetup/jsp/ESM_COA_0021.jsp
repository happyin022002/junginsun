<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_COA_0021.js
*@FileTitle : Manual Cost Set up
*Open Issues :
*Change history :
* 2012.10.15 이석준 [CHM-201220161-01] 실시간 영업현황 관련 UI
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%
    Exception serverException = null;	//서버에서 발생한 에러
    String strErrMsg = "";              //에러메세지
    Logger log = Logger.getLogger("com.hanjin.alps.esm.coa.ESM_COA_0110");
    try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
    } catch(Exception e) {
        log.error(e.toString());
    }
%>

<html>
<head>
<title>Network Cost by VVD </title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
    function setupPage() {
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }
</script>
</head>

<body onload="javascript:setupPage();">

<form method="post" name="form" onKeyDown="keyEnter_loc();" onKeyUp="ComKeyEnter();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="f_chkprevcre" value="N">
<input type="hidden" name="f_cost_stup_ind">

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
  <tr>
    <td>
      <!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
      </table>
      <!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->

      <!--Button_L (S) -->
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
        <tr>
          <td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <!-- Repeat Pattern -->
                <!-- 
                 <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_Month_copy" name="btn_Month_copy">Month Copy</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                 -->
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
                      <td class="btn1" id="btn_Creation" name="btn_Creation">Create</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_save" name="btn_save">Save</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                 -->
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_down_excel" name="btn_down_excel">Down Excel</td>
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
            <table class="search_in" border="0">
              <tr class="h23">
                <td width="20%">
                     YYYY-MM <input type="radio" name="f_yrtype" class="trans" value="yrmon"  onClick="setYrMon()">&nbsp;&nbsp;
                     YYYY-WW <input type="radio" name="f_yrtype" class="trans" value="yrwk" checked>&nbsp;&nbsp;
                </td>
                <td width="8%"><input type="text" class="input1" style="width:60" name="f_yearweek" maxlength="6" onkeyPress="ComKeyOnlyNumber(window);" onfocus="ComClearSeparator(this,'', '-');this.select();" onblur="javascript:fnYearWeekSet(this);"></td>
                <td class="sm"><div id="div_period"></div></td>
              </tr>
            </table>
          </td>
        </tr>
      </table>

      <!-- TABLE '#D' : ( Search Options ) (E) -->
      <table class="height_10"><tr><td></td></tr></table>

      <!-- TABLE '#D' : ( Tab ) (S) -->
      <table class="tab">
        <tr><td><script language="javascript">ComTabObject('tab1')</script></td></tr>
      </table>
      <!-- TABLE '#D' : ( Tab ) (E) -->

      <!-- TABLE '#D' : ( Search Options ) (S) -->

            <div id="tabLayer" style="display:inline">

            <!-- TABLE '#D' : ( Grid  ) (S) -->
           <table class="search"><tr><td class="bg" valign="top">
            
            <table width="100%" id="mainTable1">
              <tr><td><script language="javascript">ComSheetObject('sheet1');</script></td></tr>
            </table>
            
       
			<table class="search" style="width:800px" border = "0">
			<tr><td height="18" colspan="10"><img src="/hanjin/img/ico_star.gif" border="0" hspace="3" align="absmiddle"><strong>Remark</strong></td></tr>
			
			<tr>
				<td style="padding-left:11;" colspan="10" class="sm"><img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0" vspace="3">
				<b>Deferred Expense : MAS Month : <input type="text" name="mon_def_amt" style="font-weight:bold;text-align:left;padding-top:5px;width:55;border:0px;color:blue;background-color:#F3F2F8;" readOnly></b>
				</td>
			</tr>
			<tr>
				<td style="padding-left:11;" colspan="10" class="sm"><img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0" vspace="3">
			    <b>Total :&nbsp;<input type="text" name="ttl_def_amt" style="text-align:left;padding-top:5px;border:0px;color:blue;background-color:#F3F2F8;" readOnly></b>
				</td>
			</tr>
			
			<tr>
				<td style="padding-left:30;" class="sm" width="30" height="9" ><b>TPS :</b></td>
				<td width="130" align="left"><input type="text" size="16" name="tps_def_amt" style="text-align:left;padding-top:5px;border:0px;color:blue;background-color:#F3F2F8;padding-top:3px;" readOnly></td>
				<td width="30" class="sm"><b>AES :</b></td>
				<td width="130" align="left"><input type="text" name="aes_def_amt" size="16" style="text-align:left;padding-top:5px;border:0px;color:blue;background-color:#F3F2F8;padding-top:3px;" readOnly></td>
				<td width="30" class="sm"><b>TAS :</b></td>
				<td width="130" align="left" ><input type="text" name="tas_def_amt" size="16" style="text-align:left;padding-top:5px;border:0px;color:blue;background-color:#F3F2F8;padding-top:3px;" readOnly></td>
				<td width="30" class="sm"><b>IAS :</b></td>
				<td width="130" align="left" ><input type="text" size="16"  name="ias_def_amt"  style="text-align:left;padding-top:5px;border:0px;color:blue;background-color:#F3F2F8;padding-top:3px;" readOnly></td>
				<td width="30" class="sm"><b>EMS :</b></td>
				<td width="130" align="left" ><input type="text" size="16"  name="ems_def_amt"  style="text-align:left;padding-top:5px;border:0px;color:blue;background-color:#F3F2F8;padding-top:3px;" readOnly></td>
				
			</tr>					       
			</table>
			
			
            </td></tr></table>
            <!-- TABLE '#D' : ( Grid  ) (E) -->
			
		

            </div>

            <div id="tabLayer" style="display:none">
            <!-- TABLE '#D' : ( Grid  ) (S) -->
            <table class="search"><tr><td class="bg" valign="top">
            <table width="100%" id="mainTable2">
              <tr><td><script language="javascript">ComSheetObject('sheet2');</script></td></tr>
            </table>
            </td></tr></table>
            <!-- TABLE '#D' : ( Grid  ) (E) -->
            </div>

      <!-- TABLE '#D' : ( Search Options ) (E) -->
    </td>
  </tr>
</table>
<!-- Outer Table (E)-->

</form>
</body>
</html>
