<%
/*=========================================================
* Copyright(c) 2016 CyberLogitec
* @FileName : ESM_MAS_0017.jsp
* @FileTitle : Container PDM by Inventory
* Open Issues :
* Change history : 
* @LastModifyDate : 2016-03-18
* @LastModifier : Young-Heon Lee
* @LastVersion : 1.0
*  2016-03-18 Young-Heon Lee
*  1.0 최초 생성
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%> 
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%
    Exception serverException   = null;             //서버에서 발생한 에러
    String strErrMsg    = "";                       //에러메세지
    String xml = "";    
    Logger log = Logger.getLogger("com.hanjin.alps.esm.mas.ESM_MAS_0017");
    
    String userId = "";
    String ofc_cd = "";
    try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

		xml = HttpUtil.makeXML(request,response); 
        xml = xml.replaceAll("\"", "'");
        
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		userId = account.getUsr_id();
		ofc_cd = account.getOfc_cd();
        
    } catch(Exception e) {
        log.error("JSP Exception : " + e.toString());
    }
%>
<html>
<head>
<title>Container PDM by Inventory</title>
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
<!-- <body onload="javascript:setupPage();form.f_yearweek.select()"> -->
<body onload="setupPage();">
<iframe height="0" width="0" name="frmHidden"></iframe>
<form method="post" name="form" onKeyDown="ComKeyEnter();">
<input  type="hidden" name="f_cmd"> 
<input type="hidden" name="sXml" value="<%=xml%>"> 

<!-- <input type="hidden" name="backendjob_key">
<input type="hidden" name="button_key"> --> <!-- 이벤트를 구분하기 위함 -->

<input type="hidden" name="f_cost_yr">
<input type="hidden" name="f_cost_qtr_cd">
<input type="hidden" name="v_ofc_cd"  value="<%=ofc_cd%>">


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
                  <table id="hidden_Save" width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_save" name="btn_save">Save</td>
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
                      <td class="btn1" id="btn_Loadexcel" name="btn_Loadexcel">Load Excel</td>
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
                <td width="45%">From Year&nbsp;<input type="text" class="input1" style="width:40" id="fr_year" name="fr_year" maxlength="4" onKeyPress="ComKeyOnlyNumber(window)" onKeyUp="ComKeyEnter('LengthNextFocus')">&nbsp;
                				QTR&nbsp;&nbsp;<input type="text" class="input1" style="width:20" id="fr_qtr" name="fr_qtr"  value="" maxlength="1" onKeyPress="ComKeyOnlyNumber(window)" onKeyUp="ComKeyEnter('LengthNextFocus')">
                				&nbsp;&nbsp;~&nbsp;&nbsp;
                				To Year&nbsp;<input type="text" class="input1" style="width:40" id="to_year" name="to_year" maxlength="4" onKeyPress="ComKeyOnlyNumber(window)" onKeyUp="ComKeyEnter('LengthNextFocus')">&nbsp;
                				QTR&nbsp;&nbsp;<input type="text" class="input1" style="width:20" id="to_qtr" name="to_qtr"  value="" maxlength="1" onKeyPress="ComKeyOnlyNumber()"></td><!-- onKeyPress="ComKeyOnlyAlphabet('uppernum');" -->								                
              </tr>
            </table>		            
            <!-- : ( Year ) (E) -->

          </td>
        </tr>
      </table>
      <!-- TABLE '#D' : ( Search Options ) (E) -->
      
      <table class="height_10"><tr><td></td></tr></table>
            
	  <table class="search">
	  	<tr><td class="bg">

		<table class="search" border="0">
			<tr>
				<td class="title_h"></td>
				<td class="title_s">Container PDM by Inventory</td>
			</tr>
		</table>

		<table width="100%" id="mainTable">
			<tr>
				<td>
					<script language="javascript">ComSheetObject('sheet1');</script>
                </td>
            </tr>
        </table>
        
        <table width="100%" class="button">
		       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
					
					<!-- Repeat Pattern -->
					<td><table id="hidden_Add" width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td><td class="btn2" id="btn_rowadd" name="btn_rowadd">Row Add</td><td class="btn2_right"></td></tr></table></td>
					<!-- Repeat Pattern -->

					</tr>
				</table>
				</td></tr>
			</table>
        </td>
        </tr>
      </table>
      
    </td>
  </tr>
</table>
<!-- Outer Table (E)-->
	
</form>
</body>
</html>