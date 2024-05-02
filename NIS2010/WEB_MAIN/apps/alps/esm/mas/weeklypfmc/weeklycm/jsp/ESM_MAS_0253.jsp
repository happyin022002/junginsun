<%
/*=========================================================
* Copyright(c) 2014 CyberLogitec
* @FileName : ESM_MAS_0253.jsp
* @FileTitle : Chassis Cost
* Open Issues :
* Change history : 
* @LastModifyDate : 2014-11-19
* @LastModifier : Je Ryang Yoo
* @LastVersion : 1.0
*  2014-11-18 Je Ryang Yoo
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
    Logger log = Logger.getLogger("com.hanjin.alps.esm.mas.ESM_MAS_0253");
    
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
<title>Chassis Cost</title>
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
<input type="hidden" name="tab_item">
<!-- 
<input type="hidden" name="fm_date" value="20090101">배치용 시작일자
<input type="hidden" name="to_date" value="99991231">배치용 종료일자
 -->
<!-- <input type="hidden" name="f_chkprevcre" value="N"> -->
<input type="hidden" name="sXml" value="<%=xml%>"> 

<!-- <input type="hidden" name="backendjob_key">
<input type="hidden" name="button_key"> --> <!-- 이벤트를 구분하기 위함 -->

<input type="hidden" name="f_cost_yr">
<input type="hidden" name="f_cost_qtr_cd">
<input type="hidden" name="f_eff_fm_yrmon">
<input type="hidden" name="f_eff_to_yrmon">
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
                <!-- <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_Loadexcel" name="btn_Loadexcel">Load Excel</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_Create" name="btn_Create">Create</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td> -->
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_ExceptionList" name="btn_ExceptionList">Exception List</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_UCCustomer" name="btn_UCCustomer">U/C by Customer</td>
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
      
      <!-- <table class="height_10"><tr><td></td></tr></table> -->
            
      <table class="height_8"><tr><td colspan="8"></td></tr></table>
		
	  <!-- Tab (S) -->
      <table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%> 
      	<tr><td width="100%">
				<script language="javascript">ComTabObject('tab1')</script>
			</td>
		</tr>
	  </table>
	  <!-- Tab (E) -->
      
      
      <!--Tab1(Chassis Cost) (S) -->
	  <div id="tabLayer" style="display:inline">
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
       		
       		<!--  Button_Sub (S) -->
			<table width="100%" class="button">
		       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>

					<!-- Repeat Pattern -->
					<td><table id="hidden_Loadexcel" width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td><td class="btn2" id="btn_Loadexcel" name="btn_Loadexcel">Load Excel</td><td class="btn2_right"></td></tr></table></td>

					<td><table id="hidden_Create" width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td><td class="btn2" id="btn_Create" name="btn_Create">Creation</td><td class="btn2_right"></td></tr></table></td>					
					<!-- Repeat Pattern -->
					
				</tr></table>
			</td></tr>
			<tr><td class="height_5" colspan="3"></td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
       					
			<!-- Grid  (S) -->
			<table width="100%"  id="mainTable2">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table>
			<!-- Grid (E) -->
			
			<!-- : ( Button : Grid ) (S) -->
			<table width="100%" class="button">
		       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
					
					<!-- Repeat Pattern -->
					<td><table id="hidden_Add" width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td><td class="btn2" id="btn_rowadd" name="btn_rowadd">Row Add</td><td class="btn2_right"></td></tr></table></td>

					<td><table id="hidden_Del" width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td><td class="btn2" id="btn_rowdel" name="btn_rowdel">Row Del.</td><td class="btn2_right"></td></tr></table></td>
					<!-- Repeat Pattern -->

					</tr>
				</table>
				</td></tr>
			</table>
	    	<!-- : ( Button : Grid ) (E) -->			    			
						
			</td></tr>
		</table>
		<!--biz page (E)-->
	  </div>
	  <!--Tab1(Chassis Cost) (E) -->
	  
	  <!--TAB House B/L (S) -->
	  <div id="tabLayer" style="display:none">
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">		
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable2">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->				
			</td></tr>
		</table>
		<!--biz page (E)-->
	  </div>	
	  <!--TAB House B/L (E) -->	  
	  
            
      <!-- TABLE '#D' : ( Search Options ) (S) -->
      <!-- <table class="search">
        <tr>
          <td class="bg">		
            
            : ( POR ) (S)
            <table border="0" style="width:100%;" id="mainTable">
              <tr>
                <td>
                  <script language="javascript">ComSheetObject('sheet1');</script>
                </td>
              </tr>
            </table>
            : ( POR ) (E)                       
            
          </td>
        </tr>
      </table> -->
      <!-- TABLE '#D' : ( Search Options ) (E) -->
    </td>
  </tr>
</table>
<!-- Outer Table (E)-->
	
</form>
</body>
</html>