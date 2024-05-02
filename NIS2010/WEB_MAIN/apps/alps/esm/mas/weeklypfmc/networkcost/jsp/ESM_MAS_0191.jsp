<%
/*=========================================================
* Copyright(c) 2014 CyberLogitec
* @FileName : ESM_MAS_0191.jsp
* @FileTitle : MAS Create Monitor
* Open Issues :
* Change history : 
* @LastModifyDate : 2015-06-26
* @LastModifier : Je Ryang Yoo
* @LastVersion : 1.0
*  2015-06-26 Je Ryang Yoo
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
        
    Logger log = Logger.getLogger("com.hanjin.alps.esm.mas.ESM_MAS_0191");
    
    String userId = "";    
    try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        } else {
			SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
				        
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
					<td colspan="2">
						<!-- <script language="javascript">masPeriod1_ofc();</script> -->
						<table border='0'>
						    <tr class='h23'>
						        <td width='50'>&nbsp;&nbsp;W/M</td>
						        <td width='160'>
						            <div id='div_wm' style='display:inline;border:solid 0;'>
						            <input type='radio' value='W' name='f_chkprd' class='trans' onClick="chk_WM('W','1');changeCostYrmon(this.value);" tabindex="1" checked>&nbsp;Week                                                                                                                                                                                                                       
						            <input type='radio' value='M' name='f_chkprd' class='trans' onClick="chk_WM('M','1');changeCostYrmon(this.value);" tabindex="1">&nbsp;Month                                                                                                                                                                                                                              
						            </div>
						        </td>
						        <td width='25' class='sm'>Year</td>
						        <td width='60'>
						        	<input type='text' style='width:40;text-align:center;' class='input1' name='f_year' maxlength='4' style='ime-mode:disabled' onKeyUp="ComKeyEnter('LengthNextFocus');" onKeyPress='ComKeyOnlyNumber(window);' onChange='setPeriod(this);changeCostYrmon(this.value);' tabindex="2">
						        </td>                                                                                                                  
						        <td width='90' class='sm'>
						            <div id='div_month' style='display:none;border:solid 0;width:80;height:16'>                                                                                                                                                                                                                                                                                 
						            Month&nbsp;
						            <input type='text' style='width:30;text-align:center;' class='input1' name='f_fm_mon' maxlength='2' style='ime-mode:disabled' onKeyPress='ComKeyOnlyNumber(window);' onBlur="if(this.value!=''){this.value=ComLpad(this, 2, '0');changeTomon(this.value);}" onKeyUp="ComKeyEnter('LengthNextFocus')" onChange='setPeriod(this);changeCostYrmon(this.value);' tabindex="3"><!-- &nbsp;&nbsp;~&nbsp; --> 
						            <input type='text' style='display:none;width:10;text-align:center;' class='input1' name='f_to_mon' maxlength='2' style='ime-mode:disabled' onKeyPress='ComKeyOnlyNumber(window);' onBlur="if(this.value!=''){this.value=ComLpad(this, 2, '0');}" onChange="if(this.value!=''){this.value=ComLpad(this, 2, '0'); setPeriod(this);}">
						            </div>
						            <div id='div_week' style='display:inline;border:solid 0;width:80;height:16'>
						            Week&nbsp;&nbsp;&nbsp;
						            <input type='text' style='width:30;text-align:center;' class='input1' name='f_fm_wk' maxlength='2' style='ime-mode:disabled' onKeyPress='ComKeyOnlyNumber(window);' onBlur="if(this.value!=''){this.value=ComLpad(this, 2, '0');changeTowk(this.value);}" onKeyUp="ComKeyEnter('LengthNextFocus')" onChange='setPeriod(this);' tabindex="3"><!-- &nbsp;&nbsp;~&nbsp; -->
						            <input type='text' style='display:none;width:10;text-align:center;' class='input1' name='f_to_wk' maxlength='2' style='ime-mode:disabled' onKeyPress='ComKeyOnlyNumber(window);' onBlur="if(this.value!=''){this.value=ComLpad(this, 2, '0');}" onChange="if(this.value!=''){this.value=ComLpad(this, 2, '0'); setPeriod(this);}" tabindex="4">                                    
						            </div>
						        </td>
						        <td class='sm'><div id='div_period'></div></td>
						    </tr>
						</table>
					</td>
					<td width="45px">Cost</td>
					<td width="170">			
						<script language="javascript">ComComboObject('f_chkcost', 1, 100 , 0, 0 )</script>
					</td>
					<td width="40"></td><td width="40"></td><td width="40"></td>
				</tr>
			</table>
            
            <!-- <table class="search_in" border="0">
				<tr><td class="" style="height:8;"></td></tr>
			</table>
            
            <table class="search_in" border="0">
              <tr class="h23">
				<td width="40px">&nbsp;&nbsp;C.OFC</td>
				<td width="50px"><input type="text" style="width:50px" class="input" name="f_c_ofc" value="" maxlength="10" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')"></td>										
				<td width="30px">&nbsp;&nbsp;S/C</td>
				<td width="95px"><input type="text" style="width:95px" class="input" name="f_sc" value="" maxlength="20" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')"></td>
				<td width="30px">&nbsp;RFA</td>
				<td width="95px"><input type="text" style="width:95px" class="input" name="f_rfa" value="" maxlength="11" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')"></td>
				<td width="30px">&nbsp;POR</td>
				<td width="50px"><input type="text" style="width:50px" class="input" name="f_por" value="" maxlength="7" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')"></td>
				<td width="30px">&nbsp;DEL</td>
				<td width="50px"><input type="text" style="width:50px" class="input" name="f_del" value="" maxlength="7" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')"></td>				
				<td width="40px">&nbsp;TPSZ</td>
				<td width="40px"><input type="text" style="width:40px" class="input" name="f_tpsz" value="" maxlength="4" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')"></td>
				<td width="20px"></td><td width="20px"></td><td width="20px"></td><td width="20px"></td>
				<td width="30px"></td><td width="30px"></td><td width="30px"></td><td width="30px"></td>
				<td width="30px"></td><td width="30px"></td><td width="30px"></td>
              </tr>
            </table> -->
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