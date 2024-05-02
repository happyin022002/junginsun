<%
/*=========================================================
* Copyright(c) 2014 CyberLogitec
* @FileName : ESM_MAS_0327.jsp
* @FileTitle : General Expense Pre OP Cost
* Open Issues :
* Change history : 
* @LastModifyDate : 2014-12-12
* @LastModifier : Je Ryang Yoo
* @LastVersion : 1.0
*  2014-12-12 Je Ryang Yoo
*  1.0 최초 생성
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%
    Exception serverException = null;	//서버에서 발생한 에러
    String strErrMsg = "";              //에러메세지
    Logger log = Logger.getLogger("com.hanjin.alps.esm.mas.ESM_MAS_0327");
    
    String userId = "";    
    
    try {    	
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		userId = account.getUsr_id();        
        
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
	} catch(Exception e) {
		log.error("JSP Exception : " + e.toString());
	}
%>
<html>
<head>
<title>Missing List</title>
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
<!-- <body onload="javascript:setupPage();form.f_yearweek.focus();"> -->
<body onload="javascript:setupPage();">
<form method="post" name="form" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd">
<!-- <input type="hidden" name="f_header"> -->

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
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <!-- <td class="btn1" id="btn_Downexcel" name="btn_Creation">Creation</td> -->
                      <td class="btn1" id="btn_Creation" name="btn_Creation">Creation</td>
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
      <input type="radio" name="f_yrtype" class="trans" value="yrmon" checked>
      </div>

      <!-- TABLE '#D' : ( Search Options ) (S) -->
      <table class="search">
        <tr>
          <td class="bg">
            <!-- : ( Year ) (S) -->
            <table class="search_in" width="990" border="0">
              <tr class="h23">                
                <td width="55">YYYY-MM</td>
                <td width="60"><input type="text" style="width:60" class="input1" name="f_yearweek" maxlength="6" onkeyPress="ComKeyOnlyNumber(window);" onfocus="ComAddSeparator_Local(this, '-');this.select();" onblur="javascript:fnYearWeekSet(this);" onKeyUp="ComKeyEnter('LengthNextFocus')">&nbsp;</td>
                <td width="140" class="sm"><div id="div_period"></div></td>
                <td width="65">Trade Dir.</td>
                <td width="60">
                	<script language="javascript">ComComboObject('f_trd_cd',1, 60, 1 )</script>
                </td>
                <td width="35">&nbsp;Lane</td>
                <td width="80">
                	<script language="javascript">ComComboObject('f_rlane_cd',1, 80, 0 )</script>
                </td>
                <td width="50">&nbsp;Bound</td>
                <td width="50">
                	<script language="javascript">ComComboObject('f_dir_cd',1, 50, 1 )</script>
                </td>
                <td width="85">&nbsp;&nbsp;Start Month</td>
                <td width="60">
                	<input type="text" style="width:60" class="input1" name="f_syearmonth" maxlength="6" onkeyPress="ComKeyOnlyNumber(window);" onfocus="ComAddSeparator_Local(this, '-');this.select();" onblur="javascript:fnYearWeekSet(this);">&nbsp;
                </td>                
                <td width="50">Duration</td>
                <td width="50"><script language="javascript">ComComboObject('f_dur',1, 50 , 0 )</script></td>
              </tr>
            </table>
            <!-- : ( Year ) (E) -->
          </td>
        </tr>
      </table>
      <!-- TABLE '#D' : ( Search Options ) (E) -->           
            
      <table class="height_8"><tr><td colspan="8"></td></tr></table>
	  
	<div id="tabLayer" style="display:inline">
      <!-- TABLE '#D' : ( Search Options ) (S) -->
      <table class="search">
        <tr>
          <td class="bg">
          
       		<!--  Button_Sub (S) -->
			<table width="100%" class="button">
		       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>

					<!-- Repeat Pattern -->
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td><td class="btn2" id="btn_Costmodification" name="btn_Costmodification">Cost Modification</td><td class="btn2_right"></td></tr></table></td>

					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td><td class="btn2" id="btn_Lanecheck" name="btn_Lanecheck">Lane Check</td><td class="btn2_right"></td></tr></table></td>
					<!-- Repeat Pattern -->
					
				</tr></table>
			</td></tr>
			<tr><td class="height_5" colspan="3"></td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
	    	
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
	</div>

<!-- Outer Table (E)-->

</form>
</body>
</html>