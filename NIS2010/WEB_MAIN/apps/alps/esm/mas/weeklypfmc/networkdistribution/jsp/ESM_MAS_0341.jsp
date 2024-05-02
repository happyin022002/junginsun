<%
/*=========================================================
* Copyright(c) 2017 Hipluscard
* @FileName : ESM_MAS_0341.jsp
* @FileTitle : Allocation by Agreement  Inter To Inter
* Open Issues :
* Change history : 
* @LastModifyDate : 2017-07-25
* @LastModifier : SONG Min Seok
* @LastVersion : 1.0
*  2017-07-25 SONG Min Seok
*  1.0 최초 생성
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%> 
<%
    Exception serverException = null;	//서버에서 발생한 에러
    String strErrMsg = "";              //에러메세지
    Logger log = Logger.getLogger("com.hanjin.alps.esm.mas.ESM_MAS_0341");
    
    String userId = "";    
    String xml = "";
    try {    	
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		userId = account.getUsr_id();        
        
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        xml = HttpUtil.makeXML(request,response); 
        xml = xml.replaceAll("\"", "'");
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
<!-- <body onload="javascript:setupPage();form.f_cost_yrmon.focus();"> -->
<body onload="javascript:setupPage();">
<form method="post" name="form" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="sXml" value="<%=xml%>"> 
<input type="hidden" name="f_fm_mon">
<input type="hidden" name="f_to_mon">
<input type="hidden" name="cost_yrmon">
<input type="hidden" name="fm_cost_wk">
<input type="hidden" name="to_cost_wk">

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


	  
	<div id="tabLayer" style="display:inline">
      <!-- TABLE '#D' : ( Search Options ) (S) -->
      <table class="search">
        <tr>
          <td class="bg">
 
       <!-- TABLE '#D' : ( Search Options ) (S) -->
        <table class="search_in" border="0">
        <tr class="h23">
            <td colspan="3"><script language="javascript">masPeriod2();</script><!-- FormControl.js --></td>
        </tr>
 

        </table>
      <!-- TABLE '#D' : ( Search Options ) (E) -->           
            
      <table class="height_8"><tr><td colspan="8"></td></tr></table>
	    	
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