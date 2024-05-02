<%
/*=========================================================
* Copyright(c) 2014 CyberLogitec
* @FileName : ESM_MAS_0271.jsp
* @FileTitle : DEM/DET Cost Daily Batch Result
* Open Issues :
* Change history : 
* @LastModifyDate : 2015-01-15
* @LastModifier : Je Ryang Yoo
* @LastVersion : 1.0
*  2015-01-15 Je Ryang Yoo
*  1.0 최초 생성
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%> 
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%
    Exception serverException   = null;             //서버에서 발생한 에러
    String strErrMsg    = "";                       //에러메세지
    //String xml = "";    
    Logger log = Logger.getLogger("com.hanjin.alps.esm.mas.ESM_MAS_0271");
    
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
<title>DEM/DET Cost Daily Batch Result</title>
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
<!-- <input type="hidden" name="f_tmp_inputType"> -->
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
          <!-- <td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span>&nbsp;DEM/DET Cost Daily Batch Result</span></td> -->
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
            <table class="search" border="0" style="width:975px;">
              <tr class="h23">
					<td width="60px"><input type="radio" class="trans" name="f_selinputtype" value="selInputDate" onClick="changeInputType(this.value);" checked><label style="padding-left:2;"> Date</label></td>
					<td width="70px">Batch Date</td>
					<td width="200px" colspan="2"><input type="text" style="width:70px" class="input1" name="f_fmyearmonth" value="" maxlength="8" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')"  onblur="fnYearSet(this)" caption="Batch From Date" >					
					&nbsp;~&nbsp;&nbsp;<input type="text" style="width:70px" class="input1" name="f_toyearmonth" value="" maxlength="8" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')"  onblur="fnYearSet(this)" caption="Batch To Date" >
					&nbsp;<img src="img/btns_calendar.gif" name="btns_calendar" width="19"height="20"alt=""border="0"align="absmiddle" class="cursor"></td>
					
					<td width="330px" colspan="5">
						<table class="search_sm2" width="325px">
							<td width="110px" colspan="2"><select name="f_sto_cntr_chss"  style="width:110px" class="input1">									
									<OPTION value='ST'>Storage</OPTION>
									<OPTION value='CN'>Container Cost</OPTION>
									<OPTION value='CH'>Chassis Cost</OPTION>
								</select></td>
							<td width="80px" colspan="2">From Location</td>
							<td width="90px"><input type="text" style="width:80px" name="f_fm_nod" class="input1" value="" maxlength="5" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')"></td>							
						</table>
					</td>										
					<td width="70px"></td>
					<td width="70px"></td>															
			  </tr>
			  <tr><td class="line_bluedot" colspan="12"></td></tr>			  
			  <tr class="h23">
					<td width="60px"><input type="radio" class="trans" name="f_selinputtype" value="selInputNo" onClick="changeInputType(this.value);"><label style="padding-left:2;"> BKG/CNTR</label></td>
					<td width="70px">BKG No.</td>
					<td width="150px" colspan="2"><input type="text" style="width:130px" class="input" name="f_bkgno" value="" maxlength="20" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')"></td>										
					<td width="70px">CNTR No.</td>
					<td width="150px"><input type="text" style="width:130px" class="input" name="f_cntrno" value="" maxlength="20" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')"></td>
					<td width="70px" colspan="6"></td>																			
			  </tr>              
              <!-- <tr class="h23">                	              
                <td width="65%"><table border="0" class="search_sm2">
                    <tr>
                	  <td>Batch Date&nbsp;<input type="text" class="input1" style="width:70px" id="f_yearmonth" name="f_yearmonth" maxlength="8" onKeyPress="ComKeyOnlyNumber(window)" onblur="javascript:fnYearMonthSet(this);" onKeyUp="ComKeyEnter('LengthNextFocus')">&nbsp;
               			  Storage FM Node&nbsp;<input type="text" style="width:50px" id="f_sto_fm_nod" name="f_sto_fm_nod"  value="" maxlength="5" onKeyUp="ComKeyEnter('LengthNextFocus');" onKeyPress="ComKeyOnlyAlphabet('uppernum');">&nbsp;
               			  Container FM Node&nbsp;<input type="text" style="width:50px" id="f_cntr_fm_nod" name="f_cntr_fm_nod"  value="" maxlength="5" onKeyUp="ComKeyEnter('LengthNextFocus');" onKeyPress="ComKeyOnlyAlphabet('uppernum');">&nbsp;
               			  Chassis FM Node&nbsp;<input type="text" style="width:50px" id="f_chss_fm_nod" name="f_chss_fm_nod"  value="" maxlength="5" onKeyUp="ComKeyEnter('LengthNextFocus');" onKeyPress="ComKeyOnlyAlphabet('uppernum');">&nbsp;</td>
                    </tr>
                </table></td>
                <td width="35%"><table border="0" class="">
                    <tr>                      
                      <td>CNTR No.&nbsp;<input type="text" style="width:100px" id="f_cntrno" name="f_cntrno"  value="" maxlength="20" onKeyUp="ComKeyEnter('LengthNextFocus');" onKeyPress="ComKeyOnlyAlphabet('uppernum');">&nbsp;
               			  BKG No.&nbsp;<input type="text" style="width:100px" id="f_bkgno" name="f_bkgno"  value="" maxlength="20" onKeyUp="ComKeyEnter('LengthNextFocus');" onKeyPress="ComKeyOnlyAlphabet('uppernum');"></td>
                    </tr>
                </table></td>	               												                
              </tr> -->
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
			
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_movement">CNTR MVMT</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_bkginq">BKG Inquiry</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>												
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			
			</td></tr>
      </table>  
	  
    </td>
  </tr>
</table>
<!-- Outer Table (E)-->
	
</form>
</body>
</html>