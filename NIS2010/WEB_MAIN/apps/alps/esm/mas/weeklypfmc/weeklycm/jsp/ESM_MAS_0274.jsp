<%
/*=========================================================
* Copyright(c) 2014 CyberLogitec
* @FileName : ESM_MAS_0274.jsp
* @FileTitle : Storage Calculation Exception Node
* Open Issues :
* Change history : 
* @LastModifyDate : 2015-02-10
* @LastModifier : Je Ryang Yoo
* @LastVersion : 1.0
*  2015-02-10 Je Ryang Yoo
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
	String strOfc_cd = "";
        
    Logger log = Logger.getLogger("com.hanjin.alps.esm.mas.ESM_MAS_0274");
    String xml = HttpUtil.makeXML(request,response);
    String userId = "";
    try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		userId = account.getUsr_id();
		strOfc_cd = account.getOfc_cd();
        
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
<input type="hidden" name ="nod_cd" id ="nod_cd" value="">
<input type="hidden" name ="f_exp_cust_cd" id ="f_exp_cust_cd" value="">
<input type="hidden" name ="tmp_f_ctrl_ofc_cd" id ="tmp_f_ctrl_ofc_cd" value="">
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
          <!-- <td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span>&nbsp;Storage Calculation Exception Node</span></td> -->
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
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_New" name="btn_New">New</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td class="btn1_line"></td>
				<%
					// Save 기능 제한 요청 - 신재훈 과장(2015.09.08)
					if( "SELOPA".equals(strOfc_cd)|| "SELOPB".equals(strOfc_cd)
					        || "SELCON".equals(strOfc_cd) ) {
				%>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_Save" name="btn_Save">Save</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
				<%
				}
				%>          
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
              	<td>Node Code</td>
                <td><input type="text" style="width:70px;" class="input" value="" name="f_nod_cd"id="f_nod_cd" maxlength="7" onkeypress="ComKeyOnlyAlphabet('uppernum')"  ></td>
                <td>Node Name</td>
                <td><input type="text" style="width:130px;" class="input" value="" name="f_nod_nm"id="f_nod_nm" onkeypress="ComKeyOnlyAlphabet('uppernum')" ></td>
                <td>Control Office</td>
                <td ><input type="text" style="width:100px;" class="input" value="" name="f_ctrl_ofc_cd"id="f_ctrl_ofc_cd"  onkeypress="ComKeyOnlyAlphabet('upper')" ></td>
                <td><table  border="0" class="search_sm2">
                    <tr>
                      <td><input type="checkbox" name="chk_office" value="Y" class="trans" onClick="javascript:fun_chkOffice();">Incl. Sub OFC  &nbsp;</td>
                      <td >&nbsp;</td>
                    </tr>
                 </table></td>	
                 <td>&nbsp;&nbsp;Delete Flag</td>  
                 <td><input type="radio" name="f_rdodelflg" value="" class="trans">&nbsp;ALL
					 <input type="radio" name="f_rdodelflg" value="Y" class="trans">&nbsp;Yes
					 <input type="radio" name="f_rdodelflg" value="N" class="trans" checked="">&nbsp;No</td>           		                
               	  
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
				<%
					// Save 기능 제한 요청 - 신재훈 과장(2015.09.08)
					if( "SELOPA".equals(strOfc_cd)|| "SELOPB".equals(strOfc_cd)
					        || "SELCON".equals(strOfc_cd)  ) {
				%>
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
                  <td>
                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                      <tr>
                        <td class="btn2_left"></td>
                        <td class="btn2" id="btn_Rowdelete" name="btn_Rowdelete">Row Delete</td>
                        <td class="btn2_right"></td>
                      </tr>
                    </table>
                  </td>                 
                  <!-- Repeat Pattern -->
				<%
				}
				%>          
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