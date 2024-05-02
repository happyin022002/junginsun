<%
/*=========================================================
* Copyright(c) 2014 CyberLogitec
* @FileName : ESM_MAS_0273.jsp
* @FileTitle : Chassis Cost Report
* Open Issues :
* Change history : 
* @LastModifyDate : 2015-04-23
* @LastModifier : Je Ryang Yoo
* @LastVersion : 1.0
*  2015-04-23 Je Ryang Yoo
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
        
    Logger log = Logger.getLogger("com.hanjin.alps.esm.mas.ESM_MAS_0273");
    String xml = HttpUtil.makeXML(request,response);
    String userId = "";
    try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		userId = account.getUsr_id();
        
    } catch(Exception e) {
        log.error("JSP Exception : " + e.toString());
    }
%>
<html>
<head>
<title>Storage Calculation Exception Node</title>
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
<body onload="setupPage();">
<!-- <iframe height="0" width="0" name="frmHidden"></iframe> -->
<form method="post" name="form" id ="form" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd" id ="f_cmd">
<%-- <input type="hidden" name="sXml" value="<%=sXml%>"> --%> 

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
                <!-- <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_New" name="btn_New">New</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td> -->
                <td class="btn1_line"></td>
                <!-- <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_Save" name="btn_Save">Save</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td> -->
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_Downexcel" name="btn_Downexcel">Down Excel</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <!-- <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_Loadexcel" name="btn_Loadexcel">Load Excel</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td> -->
                <!-- <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_Create" name="btn_Create">Create</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td> -->
                <!-- <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_ExceptionList" name="btn_ExceptionList">Exception List</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td> -->
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
              	<td width="70px">Rev YrMon</td>
				<td width="50px"><input type="text" style="width:50px" class="input" name="f_revyrmon" value="" maxlength="6" onfocus="javascript:frevyrmonInputChange(this);this.select();" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')">&nbsp;</td>
              	<td width="5px"></td>
              	<td width="230px">
					<table class="search_sm2" width="230px">
						<td width="80px">MVMT(Date)</td>
						<td width="65px"><input type="text" style="width:65px" class="input" name="f_fmyearmonth" value="" maxlength="8" onfocus="javascript:fyearmonthInputChange(this);this.select();" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled" onKeyPress="ComKeyOnlyNumber('uppernum')">&nbsp;~&nbsp;</td>
						<td width="65px"><input type="text" style="width:65px" class="input" name="f_toyearmonth" value="" maxlength="8" onfocus="javascript:fyearmonthInputChange(this);this.select();" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled" onKeyPress="ComKeyOnlyNumber('uppernum')"></td>
					</table>
				</td>           
				<td width="5px"></td>	
				<td width="40px">&nbsp;C.OFC</td>
				<td width="50px"><input type="text" style="width:50px" class="input" name="f_c_ofc" value="" maxlength="10" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')"></td>										
				<td width="5px"></td>
				<td width="30px">&nbsp;S/C</td>
				<td width="95px"><input type="text" style="width:95px" class="input" name="f_sc" value="" maxlength="20" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')"></td>
				<td width="5px"></td>
				<td width="30px">&nbsp;RFA</td>
				<td width="95px"><input type="text" style="width:95px" class="input" name="f_rfa" value="" maxlength="11" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')"></td>
				<td width="5px"></td>
				<td width="30px">&nbsp;POR</td>
				<td width="50px"><input type="text" style="width:50px" class="input" name="f_por" value="" maxlength="7" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')"></td>
				<td width="5px"></td>
				<td width="30px">&nbsp;DEL</td>
				<td width="50px"><input type="text" style="width:50px" class="input" name="f_del" value="" maxlength="7" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')"></td>
				<td width="5px"></td>
				<td width="40px">&nbsp;TPSZ</td>
				<td width="40px"><input type="text" style="width:40px" class="input" name="f_tpsz" value="" maxlength="4" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')"></td>
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
			<!-- Grid  (S) -->
			<table width="100%"  id="sheetTable">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table>
			<!-- Grid (E) -->
			</td></tr>
		</table> 
			  
    </td>
  </tr>
</table>
<!-- Outer Table (E)-->
	
</form>
</body>
</html>