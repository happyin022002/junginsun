<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0221.jsp
*@FileTitle : EMU Cost Table
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%
    Exception serverException = null;	//서버에서 발생한 에러
    String strErrMsg = "";              //에러메세지
    Logger log = Logger.getLogger("com.hanjin.alps.esm.mas.ESM_MAS_00221");
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
<title>EMU Cost Table</title>
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

<form method="post" name="form" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">

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
            <table class="search_in" border="0">
              <tr class="h23">
                <td width="75">&nbsp;YYYY-MM</td>
               	<td width="90"><input type="text" class="input1" name="f_cost_yrmon" style="width:60" maxlength="7" onKeyPress="ComKeyOnlyNumber(window)" 
               					onBlur="addDash(this , 4);"  onFocus="this.value=ComReplaceStr(this.value, '-', '');" dataformat="ym">
                </td>
                <td width="80">TYPE/SIZE</td>
                <td width="90">&nbsp;<script language="javascript">ComComboObject('f_type_cd',1, 80 , 1 )</script></td>
                <td width="150">&nbsp;<script language="javascript">ComComboObject('f_cntr_tpsz_cd',1, 120 , 1 )</script></td>                 
                 
                <td width="70">Ratio&Amount</td>
                <td width="120">&nbsp;<script language="javascript">ComComboObject('f_selclass',1, 120 , 1 )</script></td>
                <td width="250">&nbsp;</td>      
               
           <!--    </tr>
            </table>
            <table class="search_in" border="1"> -->
            
              <tr><td class="line_bluedot" colspan="10"></td></tr>
              <tr class="h23">
                <td >&nbsp;</td>
               	<td >&nbsp;</td>
                <td >Location</td>
                <td >&nbsp;<script language="javascript">ComComboObject('f_group',1, 80 , 1 )</script></td>
                <td >&nbsp;<input type="text" dataformat="engup" size="5" maxlength="5" style="width:50;" class="input0" name="f_loc_cd" value="" > 
		                   <img src="img/btns_search.gif" name="btn_loc_cd" width="19" height="20" border="0" align="absmiddle" class="cursor"></td>     
                
                <td >Rule</td>
                <td >&nbsp;<script language="javascript">ComComboObject('f_sts_cd',1, 60 , 1 )</script></td>
                <td >&nbsp;</td>      
               
              </tr>
            </table>
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
                <td class="title_s">EMU Credit Table</td>
                <td width="30%" valign="middle" align="right">&nbsp;</td>
                <td class="gray"><span id="unit_type">[Unit : %]</span></td>
              </tr>
              <tr><td height="2" colspan="4"></td></tr>
            </table>

            <!-- : ( Trade ) (S) -->
            <table width="100%" id="mainTable">
              <tr>
                <td><script language="javascript">ComSheetObject('sheet1');</script></td>
              </tr>
            </table>
            <!-- : ( Trade ) (E) -->
            
            
			<!-- : ( Remark ) (E) -->
			<table width="100%" class="button">
			    <tr><td><img src="/hanjin/img/ico_star.gif" border=0> <strong>EMU CREDIT CALCULATION PROCESS:</strong></td>			        
			    </tr>
				<tr><td class="sm">
					<img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0" vspace="4">
						DEL Credit Ratio Table  :  Check the EMU CREDIT ratio (%) of the destination(SCC/ECC) where you send the cargoes. <br>
						&nbsp;&nbsp;&nbsp;** If you can't find the SCC/ECC that you are looking for on the DEL table (below), it means that no EMU CREDIT is applicable to the destination. <br>
					<img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0" vspace="4">
						Origin (OP Location) Credit Amount Table :  Check the EMU credit amount of the origin MT P/up location (SCC/ECC) of your BKG <br>
						&nbsp;&nbsp;&nbsp;** OP Credit Ratio (%) : Some European Locations will have OP Credit Ratio range from 0% to 100%. (newly introduced from July <br>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						The OP Credit Amount of this handbook is the final credit amount mutiplied by OP credit ratio.<br>
					<img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0" vspace="4">
						POD Credit Amount Table :  Check the EMU credit amount of the POD (ECC) where you send the cargoes. <br>
					<img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0" vspace="4">
						Calculation  :  Now you have three information ; DEL Credit %, OP Credit Amount and POD Credit Amount <br>
						<font color="#0000FF"><b>&nbsp;&nbsp;&nbsp; ** EMU CREDIT =  DEL Credit (%)  x  (Origin Credit Amount + POD Credit Amount )</b></font><br>
					</td>
				
				</tr>
			</table>
            
            
            
            
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
