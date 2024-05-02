<%
/*=========================================================
* Copyright(c) 2014 CyberLogitec
* @FileName : ESM_MAS_0276.jsp
* @FileTitle : DEM/DET Cost Report by BKG
* Open Issues :
* Change history : 
* @LastModifyDate : 2015-04-24
* @LastModifier : Young-Heon Lee
* @LastVersion : 1.0
*  2015-03-24 Je Ryang Yoo
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
        
    Logger log = Logger.getLogger("com.hanjin.alps.esm.mas.ESM_MAS_0276");
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
<input type="hidden" name="sXml" value="<%=xml%>">

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
					<td colspan="10" width="70%"><script language="javascript">masPeriod3_ofc();</script></td>
					<td width="93px">&nbsp;From Location</td>
					<td width="170px"><input type="text" style="width:60px" class="input" name="f_loc_cd" value="" maxlength="7" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')"></td>
				</tr>
			</table>
			
			<table class="search_in" border="0">
				<tr><td class="line_bluedot" style="height:15;"></td></tr>
			</table>
			
            <table class="search_in" border="0">
              <tr class="h23">
              	<td width="45px">&nbsp;Booking</td>
              	<td width="110px"><input type="text" style="width:100px" class="input" name="f_bkg_no" value="" maxlength="13" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')"></td>
              	<td width="35px">&nbsp;CNTR</td>
				<td width="120px"><input type="text" style="width:110px" class="input" name="f_cntr_no" value="" maxlength="14" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')"></td>
				<td width="42px">&nbsp;TPSZ</td>
				<td width="470px">
					<!-- <input type="text" style="width:80px" class="input" name="f_cntr_tpsz_cd" value="" maxlength="3" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')"> -->
					&nbsp;<script language="javascript">ComComboObject('f_cntr_tpsz_cd', 1, 60, 0)</script>
				</td>
			 </tr>
			</table>
			
			<table class="search_in" border="0">
				<tr><td class="line_bluedot" style="height:15;"></td></tr>
			</table>
			
			<table class="search_in" border="0">
			 <tr class="h23">
				<td width="50px">&nbsp;S/C</td>
				<td width="100px"><input type="text" style="width:100px" class="input" name="f_sc_no" value="" maxlength="20" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')"></td>
				<td width="32px">&nbsp;RFA</td>
				<td width="110px"><input type="text" style="width:100px" class="input" name="f_rfa_no" value="" maxlength="11" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')"></td>
				<td width="30px">&nbsp;C.OFC</td>
				<td width="80px"><input type="text" style="width:60px" class="input" name="f_cntr_ofc_cd" value="" maxlength="6" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')"></td>										
				<td width="30px">&nbsp;POR</td>
				<td width="70px"><input type="text" style="width:60px" class="input" name="f_por_cd" value="" maxlength="5" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')"></td>
				<td width="30px">&nbsp;DEL</td>
				<td width="70px"><input type="text" style="width:60px" class="input" name="f_del_cd" value="" maxlength="5" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')"></td>
				<td width="40px">&nbsp;Status</td>
                <td width="105px">
                	<script language="javascript">ComComboObject('f_status',1, 90, 1)</script>
                </td>
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
					<td width="30%"><input type="radio" value="1" class="trans" name="f_sheet_form"  checked onClick="javascript:changeViewColumn();">&nbsp;Summary&nbsp;<input type="radio" value="2" class="trans" name="f_sheet_form" onClick="javascript:changeViewColumn();">&nbsp;By Account</td>
				</tr>
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