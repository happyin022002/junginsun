<%
/*=========================================================
* Copyright(c) 2014 CyberLogitec
* @FileName : ESM_MAS_0275.jsp
* @FileTitle : Chassis Per Diem Upload
* Open Issues :
* Change history : 
* @LastModifyDate : 2015-02-06
* @LastModifier : Je Ryang Yoo
* @LastVersion : 1.0
*  2015-02-06 Je Ryang Yoo
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
    //String xml = "";    
    Logger log = Logger.getLogger("com.hanjin.alps.esm.mas.ESM_MAS_0275");
    
    String userId = "";
    try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

		//xml = HttpUtil.makeXML(request,response); 
        //xml = xml.replaceAll("\"", "'");
        
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		userId = account.getUsr_id();
        
    } catch(Exception e) {
        log.error("JSP Exception : " + e.toString());
    }
%>
<html>
<head>
<title>Chassis Per Diem Upload</title>
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
<form method="post" name="form" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd">
<%-- <input type="hidden" name="sXml" value="<%=xml%>"> --%> 

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
          <!-- <td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span>&nbsp;Chassis Per Diem Upload</span></td> -->
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
                      <td class="btn1" id="btn_Loadexcel" name="btn_Loadexcel">Load Excel</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
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
               	  <td width="100%"><!-- Batch Date&nbsp;&nbsp;<input type="text" class="input1" style="width:70" id="f_yearmonth" name="f_yearmonth" maxlength="8" onKeyPress="ComKeyOnlyNumber(window)" onblur="javascript:fnYearMonthSet(this);" onKeyUp="ComKeyEnter('LengthNextFocus')"> --><!-- &nbsp;&nbsp;~&nbsp;&nbsp;                	  
	                			  <input type="text" class="input1" style="width:70" id="t_yearmonth" name="t_yearmonth" maxlength="8" onKeyPress="ComKeyOnlyNumber(window)" onKeyUp="ComKeyEnter('LengthNextFocus')"> --><!-- &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; -->
               					  YYYYMM&nbsp;&nbsp;<input type="text" style="width:60" id="f_yearmonth" name="f_yearmonth"  value="" maxlength="6" onKeyPress="ComKeyOnlyNumber(window)" onblur="javascript:fnYearMonthSet(this);" onKeyUp="ComKeyEnter('LengthNextFocus');">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
               					  POOL&nbsp;&nbsp;<input type="text" style="width:100" id="f_poolno" name="f_poolno"  value="" maxlength="20" onKeyUp="ComKeyEnter('LengthNextFocus');" onKeyPress="ComKeyOnlyAlphabet('uppernum');" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
               					  SCC&nbsp;&nbsp;<input type="text" style="width:100" id="f_sccno" name="f_sccno"  value="" maxlength="20" onKeyUp="ComKeyEnter('LengthNextFocus');" onKeyPress="ComKeyOnlyAlphabet('uppernum');" ></td>                												                
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
		
		<!--  Button_Sub (S) -->
        <table width="100%" class="button">
          <tr>
            <td class="btn2_bg">
              <table border="0" cellpadding="0" cellspacing="0">
                <tr>
                  <!-- Repeat Pattern -->
                  <td>
                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                      <tr>
                        <td class="btn2_left"></td>
                        <td class="btn2" id="btn_Rowadd" name="btn_Rowadd">Row Add</td>
                        <td class="btn2_right"></td>
                      </tr>
                    </table>
                  </td>                  
                  <!-- Repeat Pattern -->
                </tr>
              </table>
            </td>
          </tr>
        </table>
        <!-- Button_Sub (E) --> 
	  
    </td>
  </tr>
</table>
<!-- Outer Table (E)-->
	
</form>
</body>
</html>