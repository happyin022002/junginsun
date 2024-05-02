<%
/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : ESM_MAS_0251.jsp
*@FileTitle : U/C by Customer
*Open Issues :
*@LastModifyDate : 2017-08-14
*@LastModifier : Dong Ho Kim
*@LastVersion :
*  2017-08-14 Dong Ho Kim
*  1.0 최초 생성
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.event.EsmMas0251Event"%>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%> 
<%
    Exception serverException   = null;             //서버에서 발생한 에러
    String strErrMsg    = "";                       //에러메세지
    String xml = "";
    String strOfc_cd		= "";
    Logger log = Logger.getLogger("com.hanjin.alps.esm.mas.ESM_MAS_0251");
    try {
    	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    	strOfc_cd = account.getOfc_cd();
    	
    	serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
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
<title>Exception List Management</title>
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
	<body class="popup_bg"  onload="setupPage();">
		<iframe height="0" width="0" name="frmHidden"></iframe>
		<form method="post" name="form" onKeyDown="ComKeyEnter();">
		<input  type="hidden" name="f_cmd">
		<input type="hidden" name="sXml" value="<%=xml%>"> 
		<input type="hidden" name="v_ofc_cd" value="<%=strOfc_cd %>">
		
		<!-- OUTER - POPUP (S)tart -->
		<!-- Outer Table (S)-->
		<!-- <table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding"> -->
		<table class="popup" width="100%" border="0" cellpadding="10" cellspacing="0">
		  <tr><td class="top"></td></tr>
		  <tr>
		    <td>
		      <!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		        <!-- <tr>
		          <td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td>
		        </tr> -->
		        <tr>
		          <!-- <td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td> -->
		          <td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span>&nbsp;Unit Cost by Customer (Door. CY Exception)</span></td>
		        </tr>
		      </table>
		      <!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->
		
		
		      <!--Button_L (S) -->
		      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
		        <tr>
		          <td class="btn1_bg" class="popup">
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
		                <td id="btn_Savecon">
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
		                <td id="btn_Loadexcelcon">
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
		      <table class="search" style="width:100%;">
		        <tr>
		          <td class="bg">
		
		            <!-- : ( Year ) (S) -->
		            <table class="search_in" border="0" style="width:100%;">		              
		              <tr class="h23">
		              <td width="100%">From&nbsp;&nbsp;<input type="text" class="input1" style="width:60" id="f_fm_mon" name="f_fm_mon" maxlength="6" onKeyPress="ComKeyOnlyNumber(window)" onKeyUp="ComKeyEnter('LengthNextFocus')">&nbsp;&nbsp;~&nbsp;&nbsp;                	  
		                			  To&nbsp;&nbsp;<input type="text" class="input1" style="width:60" id="f_to_mon" name="f_to_mon" maxlength="6" onKeyPress="ComKeyOnlyNumber(window)" onKeyUp="ComKeyEnter('LengthNextFocus')">&nbsp;&nbsp;&nbsp;
                					  Contract No&nbsp;&nbsp;<input type="text" style="width:170" id="f_sc_no" name="f_sc_no"  value="" maxlength="20" onKeyUp="ComKeyEnter('LengthNextFocus');" onKeyPress="ComKeyOnlyAlphabet('uppernum');" ></td>                												                
              		  </tr>
		            </table>		            
		            <!-- : ( Year ) (E) -->
		
		          </td>
		        </tr>
		      </table>
		      <!-- TABLE '#D' : ( Search Options ) (E) -->
		      <table class="height_10"><tr><td></td></tr></table>
		      <!-- TABLE '#D' : ( Search Options ) (S) -->
		      <table class="search" style="width:100%;">
		        <tr>
		          <td class="bg">		
		            
		            <!-- Grid (S) -->
		            <!-- <table border="0" style="width:100%;" id="mainTable"> -->
		            <table border="0" style="width:100%;" id="sheetTable">
		              <tr>
		                <td width="100%">
		                  <script language="javascript">ComSheetObject('sheet1');</script>
		                </td>
		              </tr>
		            </table>
		            <!-- Grid (E) -->  
		            
		            <!-- : ( Button : Grid ) (S) -->
					<table width="100%" class="button" id="btn_control">
				       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
							
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btn_rowadd" name="btn_rowadd">Row Add</td><td class="btn2_right"></td></tr></table></td>
		
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btn_rowdel" name="btn_rowdel">Row Del.</td><td class="btn2_right"></td></tr></table></td>
							<!-- Repeat Pattern -->
		
							</tr>
						</table>
						</td></tr>
					</table>
			    	<!-- : ( Button : Grid ) (E) -->                     
		            
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
<%@include file="/bizcommon/include/common_alps.jsp" %>