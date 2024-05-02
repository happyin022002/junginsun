<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0020.jsp
*@FileTitle : Network Cost Exception List
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.27
*@LastModifier : 
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
    Logger log = Logger.getLogger("com.hanjin.alps.esm.mas.ESM_MAS_0020");
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
<input type="hidden" name="inquiryLevel">
<input type="hidden" name="location">

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
					<td width="5%" align="right">YYYY-MM</td>
					<td width="20%">&nbsp;<input type="text" class="input1" name="f_cost_yrmon" style="width:70" value="" maxlength="7" onKeyPress="ComKeyOnlyNumber(this);" onBlur="addDash(this, 4);" onFocus="ComClearSeparator(this, 'ym','-');this.select();" >
							<input type="radio" value="0" class="trans"  name="code" checked onClick="setCode('0')">Average&nbsp;&nbsp;<input type="radio" value="1" class="trans"  name="code" onClick="setCode('1')">All
					</td>
					<td width="5%" align="right">TP/SZ</td>
					<td width="19%">&nbsp;<script language="javascript">ComComboObject('f_cntr_tpsz_cd', 1, 80 , 2 )</script></td>	
					<td width="5%" align="right">LANE</td>
					<td width="10%">&nbsp;<input type="text" class="input" name="f_lane_cd" style="width:60" maxlength="5" onKeyPress="ComKeyOnlyAlphabet('uppernum')"></td>
					<td width="5%" align="right">Filter</td>
					<td colspan="4">&nbsp;<script language="javascript">ComComboObject('f_eq_itm', 1, 80 , 2 )</script> &nbsp;<input type="text" class="input" name="f_eq_days" style="width:60" maxlength="5" onKeyPress="ComKeyOnlyNumber(this);"> or over</td>					
					<td></td>
              </tr>
              <tr class="h23"> 
					<td width="7%" align="right">POR</td>
					<td width="200">
					<select style="width:80;" class="input1" name="location_by_por" >
						<!-- <option value="AR" selected >ALL(by RCC)    </option> -->
						<!-- <option value="AC"          >ALL(by Country)</option> -->
						<option value="RL"          >RCC    </option>
						<!-- <option value="RE"          >RCC(by ECC)    </option> -->
						<option value="LE"          >LCC    </option>
						<!-- <option value="LS"          >LCC(by SCC)    </option> -->
						<option value="ES"          >ECC    </option>
						<option value="CC"          >Location        </option>
						<!-- <option value="SS"          >SCC            </option> -->
						<!-- <option value="YY"          >Yard           </option> -->
						</select>
						<input type="text"  style="width:60;" class="input" value="" style="ime-mode:disabled" name="location_por" maxlength="7"  onKeyPress="ComKeyOnlyAlphabet('uppernum');">
						<img class="cursor" name="btn_loc_cd_por" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="7%" align="right">DEL</td>
					<td width="200" colspan="3">
					<select style="width:80;" class="input1" name="location_by_del" >
						<!-- <option value="AR" selected >ALL(by RCC)    </option> -->
						<!-- <option value="AC"          >ALL(by Country)</option> -->
						<option value="RL"          >RCC    </option>
						<!-- <option value="RE"          >RCC(by ECC)    </option> -->
						<option value="LE"          >LCC    </option>
						<!-- <option value="LS"          >LCC(by SCC)    </option> -->
						<option value="ES"          >ECC    </option>
						<option value="CC"          >Location        </option>
						<!-- <option value="SS"          >SCC            </option> -->
						<!-- <option value="YY"          >Yard           </option> -->
						</select>
						<input type="text"  style="width:60;" class="input" value="" style="ime-mode:disabled" name="location_del" maxlength="7"  onKeyPress="ComKeyOnlyAlphabet('uppernum');">
						<img class="cursor" name="btn_loc_cd_del" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>				
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
		<div id="tabLayer1" style="display:inline">
		<table width="100%"  id="mainTable">
			<tr>
				<td width="100%">
					<script language="javascript">ComSheetObject('sheet1');</script>
				</td>
			</tr>
		</table>
		</div>
		<div id="tabLayer2" style="display:inline">
		<table width="100%" id="mainTable2">
			<tr>
				<td>
					<script language="javascript">ComSheetObject('sheet2');</script>
				</td>
			</tr>
		</table>
		</div>
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
