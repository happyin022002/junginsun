<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0190.jsp
*@FileTitle : Network Cost Exception List
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.27
*@LastModifier : 유제량
*@LastVersion : 1.0 
=========================================================
* History
=========================================================
*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%
    Exception serverException = null;	//서버에서 발생한 에러
    String strErrMsg = "";              //에러메세지
    Logger log = Logger.getLogger("com.hanjin.alps.esm.mas.ESM_MAS_0190");
	String userId = "";
	//String ofc_cd = "";	
    try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        } else {
			SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
			userId = account.getUsr_id();
	        // ofc_cd = account.getOfc_cd(); //getUserOffice2();
        }
    } catch(Exception e) {
        log.error(e.toString());
    }
%>
<html>
<head>
<title>Network Cost Exception List</title>
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

<body onload="javascript:setupPage();">
<form method="post" name="form" onKeyDown="ComKeyEnter();">
<input  type="hidden" name="f_cmd">
<!-- <input type="hidden" name="iPage"> -->
<%-- <input type="hidden" name="v_ofc_cd"  value="<%=ofc_cd%>"> --%>
<input type="hidden" name="f_stnd_cost_cd">
<input type="hidden" name ="f_yrtype" value="yrwk">

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
                <!--  Repeat Pattern -->
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
                <!-- <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_create" name="btn_create">Create</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td> -->                
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_Save" name="btn_Save">Save</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <!-- <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_Month_Copy" name="btn_Month_Copy">Month Copy</td>
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
                <td width="60">YYYY-WW</td>
                <td width="65">&nbsp;<input type="text" style="width:60" class="input1" name="f_yearweek" maxlength="6" onkeyPress="ComKeyOnlyNumber(window);" onfocus="ComAddSeparator_Local(this, '-');this.select();" onKeyUp="ComKeyEnter('LengthNextFocus');" onblur="javascript:fnYearWeekSet(this);">
                </td>
                <td width="150" class="sm"><div id="div_period"></div></td>
                <td width="30">Cost</td>
                <td width="180">&nbsp;<script language="javascript">ComComboObject('f_selcost', 2, 180, 1)</script></td>
                <td width="50">&nbsp;&nbsp;Vessel</td>
                <td width="100"><input type="hidden" name="f_vsl_cd">&nbsp;<script language="javascript">ComComboObject('select1',1, 70 , 0 )</script></td>
				<td width="50"></td>
				<td width="50"></td>
				<td width="60"></td>
				<td width="20"></td>				
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
		<table width="100%"  id="mainTable">
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
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn2_left"></td>
                      <td class="btn2" id="btn_Rowdelete" name="btn_Rowdelete">Row Del</td>
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
