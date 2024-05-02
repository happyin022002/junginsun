<%
/*=========================================================
* Copyright(c) 2014 CyberLogitec
* @FileName : ESM_MAS_0279.jsp
* @FileTitle : DEM/DET Cost Report by BKG (Detail)
* Open Issues :
* Change history : 
* @LastModifyDate : 2015-03-17
* @LastModifier : Je Ryang Yoo
* @LastVersion : 1.0
*  2015-03-17 Je Ryang Yoo
*  1.0 최초 생성

HISTORY
2016.03.08 조회조건 추가
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%> 
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%
    Exception serverException   = null;             //서버에서 발생한 에러
    String strErrMsg    = "";                       //에러메세지
        
    Logger log = Logger.getLogger("com.hanjin.alps.esm.mas.ESM_MAS_0279");
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
    
    String f_chkprd = JSPUtil.getNull(JSPUtil.getParameter(request,"f_chkprd"));
    String f_year   = JSPUtil.getNull(JSPUtil.getParameter(request,"f_year"));
    String f_fm_mon = JSPUtil.getNull(JSPUtil.getParameter(request,"f_fm_mon"));
    String f_to_mon = JSPUtil.getNull(JSPUtil.getParameter(request,"f_to_mon"));
    String f_fm_wk  = JSPUtil.getNull(JSPUtil.getParameter(request,"f_fm_wk"));
    String f_to_wk  = JSPUtil.getNull(JSPUtil.getParameter(request,"f_to_wk"));
    String f_status = JSPUtil.getNull(JSPUtil.getParameter(request,"f_status"));
    //String f_c_ofc  = JSPUtil.getNull(JSPUtil.getParameter(request,"f_c_ofc"));
    String f_sc 	= JSPUtil.getNull(JSPUtil.getParameter(request,"f_sc"));
    String f_rfa 	= JSPUtil.getNull(JSPUtil.getParameter(request,"f_rfa"));
    String f_por 	= JSPUtil.getNull(JSPUtil.getParameter(request,"f_por"));
    String f_del 	= JSPUtil.getNull(JSPUtil.getParameter(request,"f_del"));
    String f_tpsz 	= JSPUtil.getNull(JSPUtil.getParameter(request,"f_tpsz"));
    
 	// pop_mode    
    String popMode = JSPUtil.getNull(request.getParameter("pop_mode"));
    if(popMode == null || popMode.equals("")){
    	popMode = "N";
    } else {
    	popMode = "Y";
    }
%>
<html>
<head>
<title>DEM/DET Cost Report by BKG (Detail)</title>
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


<% if (popMode.equals("Y")) { %>

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<table width="100%" class="popup" cellpadding="10" border="0">
  <tr><td class="top"></td></tr>
  <tr>
    <td valign="top">
      <!-- : ( Title ) (S) -->
      <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;DEM/DET Cost Report by BKG (Detail)</td></tr>
      </table>
      <!-- : ( Title ) (E) -->

<% } else { %>

<body onLoad="setupPage();">
<form name="form">
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
  <tr>
    <td valign="top">
      <!-- Page Title, Historical (S) -->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
      </table>
      <!-- Page Title, Historical (E) -->
<% } %>

<input type="hidden" name="f_cmd" id ="f_cmd">
<input type="hidden" name="p_chkprd"  value="<%=f_chkprd%>">
<input type="hidden" name="p_year"    value="<%=f_year%>">
<input type="hidden" name="p_fm_mon"  value="<%=f_fm_mon%>">
<input type="hidden" name="p_to_mon"  value="<%=f_to_mon%>">
<input type="hidden" name="p_fm_wk"   value="<%=f_fm_wk%>">
<input type="hidden" name="p_to_wk"   value="<%=f_to_wk%>">
<input type="hidden" name="f_status"  value="<%=f_status%>">
<%-- <input type="hidden" name="f_c_ofc"   value="<%=f_c_ofc%>"> --%>
<input type="hidden" name="f_sc"      value="<%=f_sc%>">
<input type="hidden" name="f_rfa"     value="<%=f_rfa%>">
<input type="hidden" name="f_por"     value="<%=f_por%>">
<input type="hidden" name="f_del"     value="<%=f_del%>">
<input type="hidden" name="f_tpsz"    value="<%=f_tpsz%>">
<input type="hidden" name="popMode"   value="<%=popMode%>">


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
					<td width="720px">
						<!-- <script language="javascript">masPeriod1_ofc();</script> -->
						<table border='0'>
						    <tr class='h23'>
						        <td width='50'>&nbsp;&nbsp;W/M</td>
						        <td width='360'>
						            <div id='div_wm' style='display:inline;border:solid 0;'>
						            <input type='radio' value='W' name='f_chkprd' class='trans' onClick="chk_WM('W','1');changeCostYrmon(this.value);" tabindex="1" checked>&nbsp;Week                                                                                                                                                                                                                       
						            <input type='radio' value='M' name='f_chkprd' class='trans' onClick="chk_WM('M','1');changeCostYrmon(this.value);" tabindex="1">&nbsp;Month
						            <input type='radio' value='F' name='f_chkprd' class='trans' onClick="chk_WM('F','1');changeCostYrmon(this.value);chk_DT();" tabindex="1">From Date                                                                                                                                                                                                                              
						            </div>
						        </td>
						        <td width='85' class='sm'>
						        <div id="div_mw">
						        	Year
						        	<% if (f_chkprd.equals("M")) { %>
						        		<input type='text' style='width:40;text-align:center;' class='input1' name='f_year' maxlength='4' style='ime-mode:disabled' onKeyUp="moveTab(this, f_fm_mon); ComKeyEnter('LengthNextFocus');" onKeyPress='ComKeyOnlyNumber(window);' onChange='setPeriod(this);changeCostYrmon(this.value);' tabindex="2">
						        	<% } else { %>	
						        		<input type='text' style='width:40;text-align:center;' class='input1' name='f_year' maxlength='4' style='ime-mode:disabled' onKeyUp="moveTab(this, f_fm_wk); ComKeyEnter('LengthNextFocus');" onKeyPress='ComKeyOnlyNumber(window);' onChange='setPeriod(this);changeCostYrmon(this.value);' tabindex="2">
						        	<% } %>	
						       	</div>
						        </td>                                                                                                                  
						        <td width='240' class='sm'>
						            <div id='div_month' style='display:none;border:solid 0;width:140;height:16'>                                                                                                                                                                                                                                                                                 
						            Month&nbsp;
						            <input type='text' style='width:30;text-align:center;' class='input1' name='f_fm_mon' maxlength='2' style='ime-mode:disabled' onKeyPress='ComKeyOnlyNumber(window);' onBlur="if(this.value!=''){this.value=ComLpad(this, 2, '0');changeTomon(this.value);}" onKeyUp="ComKeyEnter('LengthNextFocus')" onChange='setPeriod(this);changeCostYrmon(this.value);' tabindex="3"><!-- &nbsp;&nbsp;~&nbsp; --> 
						            <input type='text' style='display:none;width:30;text-align:center;' class='input1' name='f_to_mon' maxlength='2' style='ime-mode:disabled' onKeyPress='ComKeyOnlyNumber(window);' onBlur="if(this.value!=''){this.value=ComLpad(this, 2, '0');}" onChange="if(this.value!=''){this.value=ComLpad(this, 2, '0'); setPeriod(this);}">
						            </div>
						            <div id='div_week' style='display:inline;border:solid 0;width:140;height:16'>                                                                                                                                                                                                                                                                                
						            Week&nbsp;&nbsp;&nbsp;                                                                                                                                                                                                                                                                                                                                       
						            <input type='text' style='width:30;text-align:center;' class='input1' name='f_fm_wk' maxlength='2' style='ime-mode:disabled' onKeyPress='ComKeyOnlyNumber(window);' onBlur="if(this.value!=''){this.value=ComLpad(this, 2, '0');}" onKeyUp="ComKeyEnter('LengthNextFocus')" onChange='setPeriod(this);' tabindex="3">&nbsp;&nbsp;~&nbsp;                             
						            <input type='text' style='width:30;text-align:center;' class='input1' name='f_to_wk' maxlength='2' style='ime-mode:disabled' onKeyPress='ComKeyOnlyNumber(window);' onBlur="if(this.value!=''){this.value=ComLpad(this, 2, '0');}" onChange="if(this.value!=''){this.value=ComLpad(this, 2, '0'); setPeriod(this);}" tabindex="4">                                    
						            </div>
									<div id='div_from' style='display:none;border:solid 0;width:240;height:16'>
										<input type="text" style="width:72px" class="input" name="f_fmyearmonth" value="" maxlength="8" onfocus="javascript:fyearmonthInputChange(this);this.select();" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled" onKeyPress="ComKeyOnlyNumber('uppernum')" onblur="fnYearSet(this)">
										&nbsp;~&nbsp;<input type="text" style="width:72px" class="input" name="f_toyearmonth" value="" maxlength="8" onfocus="javascript:fyearmonthInputChange(this);this.select();" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled" onKeyPress="ComKeyOnlyNumber('uppernum')" onblur="fnYearSet(this)">
										&nbsp;<img src="img/btns_calendar.gif" name="btns_calendar" width="19"height="20"alt=""border="0"align="absmiddle" class="cursor">
						        </td>
						        <td class='sm' width="220px"><div id='div_period'></div></td>                                                                                                                                                                                                                                                                                                                  
						    </tr>                                                                                                                                                                                                                                                                                                                                                                
						</table>
					</td>
					<td width="50px">Fm&nbsp;Location</td>
					<td width="100px"><input type="text" style="width:80px" class="input" name="f_node" value="" maxlength="5" onBlur="" onKeyUp="moveTab(this, f_cntrno);" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')" tabindex="5"></td>
					<td width="20px"></td><td width="50px"></td><td width="20px"></td>
				</tr>
			</table>
            
            <table class="search_in" border="0">
				<tr><td class="" style="height:4;"></td></tr>
			</table>
						
            <table class="search_in" border="0">
              <tr class="h23">
              <!-- 2016.03.08 조회조건 추가 -->
				<td width="70px"><input type='radio' value='W' name='f_chkbkg' class='trans' onClick="chk_BKG();" tabindex="1">BKG</td>
				<td width="220px"><input type="text" style="width:120px" class="input1" name="f_bkgno" value="" maxlength="15" onfocus="javascript:fbkgnoInputChange(this);this.select();" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')">
				<img src="img/btns_multisearch.gif"
							name="btns_multisearch1" width="19"height="20"alt=""border="0"align="absmiddle" class="cursor" onClick="doProcessPopup('m_bkg_no')"></td>										
				<td width="40px">CNTR</td>
				<td width="190px"><input type="text" style="width:120px" class="input" name="f_cntrno" value="" maxlength="15" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')" tabindex="6">
				<img src="img/btns_multisearch.gif"
							name="btns_multisearch1" width="19"height="20"alt=""border="0"align="absmiddle" class="cursor" onClick="doProcessPopup('m_cntr_no')"></td>
				<td width="40">Bound
				<%-- <%=JSPUtil.getCodeCombo("f_cntr_tpsz_cd", "", "tabindex='11' style='width:50px;'", "tpSz", 0, "")%>&nbsp; --%>
				</td>
                <td width="80">&nbsp;<script language="javascript">ComComboObject('f_bnd_cd', 1, 50, 0)</script></td>
                <td width="40">TP/SZ
				<%-- <%=JSPUtil.getCodeCombo("f_cntr_tpsz_cd", "", "tabindex='11' style='width:50px;'", "tpSz", 0, "")%>&nbsp; --%>
				</td>
                <td width="80">&nbsp;<script language="javascript">ComComboObject('f_cntr_tpsz_cd', 1, 50, 0)</script></td>
				<td width="50px">Status</td>
				<td width="100px">
					<script language="javascript">ComComboObject('f_cntr_sts', 1, 70 , 0, 0 )</script>
				</td>
				<td width="50px">&nbsp;Item</td>
				<td width="">
					<script language="javascript">ComComboObject('f_items', 1, 170 , 0, 0 )</script>
				</td>
			  </tr>
			  <tr><td class="" style="height:4;"></td></tr>
              <tr class="h23">
              <!-- 2016.03.08 조회조건 추가 -->
				<!-- <td width="140px"><input type='radio' value='W' name='f_chkdt' class='trans' onClick="chk_DT();" tabindex="1">From Date</td> -->
				
								
			<% if (popMode.equals("Y")) { %>
				<td width="30px">&nbsp;&nbsp;S/C</td>
				<td width="90px"><input type="text" style="width:80px" class="input" name="f_sc_no" value="<%=f_sc%>" maxlength="20" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')" tabindex="7"></td>
				<td width="30px">RFA</td>
				<td width="90px"><input type="text" style="width:80px" class="input" name="f_rfa_no" value="<%=f_rfa%>" maxlength="20" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')" tabindex="8"></td>
				<td width="30px">&nbsp;POR</td>
				<td width="60px"><input type="text" style="width:50px" class="input" name="f_por_no" value="<%=f_por%>" maxlength="7" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')" tabindex="9"></td>
				<td width="30px">&nbsp;DEL</td>
				<td width="50px"><input type="text" style="width:50px" class="input" name="f_del_no" value="<%=f_del%>" maxlength="7" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')" tabindex="10"></td>
			<% } else { %>
				<td width="30px">&nbsp;&nbsp;S/C</td>
				<td width="90px"><input type="text" style="width:80px" class="input" name="f_sc_no" value="" maxlength="20" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')" tabindex="7"></td>
				<td width="30px">RFA</td>
				<td width="90px"><input type="text" style="width:80px" class="input" name="f_rfa_no" value="" maxlength="20" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')" tabindex="8"></td>
				<td width="30px">&nbsp;POR</td>
				<td width="60px"><input type="text" style="width:50px" class="input" name="f_por_no" value="" maxlength="7" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')" tabindex="9"></td>
				<td width="30px">&nbsp;DEL</td>
				<td width="50px"><input type="text" style="width:50px" class="input" name="f_del_no" value="" maxlength="7" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')" tabindex="10"></td>
			<% } %>
				<td width="20px"></td><td width="50px"></td><td width="100px"></td>
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
	
<% if (popMode.equals("Y")) { %>
      <!-- : ( Button : pop ) (S) -->
      <table width="100%" class="sbutton">
		<tr><td height="71" class="popup">
				<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
		       	<tr><td class="btn3_bg">
				    <table border="0" cellpadding="0" cellspacing="0">
				    <tr>		
						<!-- Repeat Pattern -->
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
						<!-- Repeat Pattern -->		
					</tr>
				</table>		
			</td></tr>
	  </table>
      
      <!-- <table width="100%" class="sbutton">
        <tr>
          <td height="71" class="popup"><table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
              <tr>
                <td class="btn3_bg"><table border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="72"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn1_left"></td>
                            <td class="btn1" name="btn_close">Close</td>
                            <td class="btn1_right"></td>
                          </tr>
                        </table></td>
                    </tr>
                  </table></td>
              </tr>
            </table></td>
        </tr>
      </table> -->
      <!-- : ( Button : pop ) (E) -->

<% } %>

	</td>
  </tr>
</table>
<!-- Outer Table (E)-->
	
</form>
</body>
</html>