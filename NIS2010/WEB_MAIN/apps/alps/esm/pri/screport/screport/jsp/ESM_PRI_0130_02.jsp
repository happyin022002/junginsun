<%
/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ESM_PRI_0130_02.jsp
*@FileTitle : Charge Summary Report - Detail View
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.29
*@LastModifier : 이혜민
*@LastVersion : 1.0
=========================================================                                                                                                                                                                                                                                                                                                                                                                                                               
* History                                                                                                                                                                                                                                                                                                                                                                                                                                                               
* 2013.06.24 송호진 [CHM-201324516] MDM_CHARGE 에 새로 추가된 MDT_RAT_FLG 적용      
* 2014.02.26 전윤주 [CHM-201429075] Charge Summary Report_Detail view 조회 기능 추가    
=========================================================*/                                                                                                                                                                                                                                                                                                                                                                                                             
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.screport.screport.event.EsmPri013002Event"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%@ page import="com.hanjin.syscommon.common.table.MdmChargeVO"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List"%>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%>

<%
	EsmPri013002Event  event = null;					
	Exception serverException   = null;			
	String strErrMsg = "";						
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.SCReport.SCReport");
    String[] svcScpCds = null;
    String[] rhqs = null;
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmPri013002Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
			log.debug(serverException);
		}
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		// Service Scope Combo Data 생성
       svcScpCds = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("svcScpCd"));
        // rhq Combo Data 생성
       rhqs = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("rhq"));
	} catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Charge Summary Report - Summary View</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	var svcScpComboValue = "<%=svcScpCds[0]%>";
	var svcScpComboText = "<%=svcScpCds[1]%>";

	var rhqComboValue = "|<%=rhqs[0]%>";
	var rhqComboText = "|<%=rhqs[1]%>";
	
    function setupPage(){
        var errMessage  = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }
</script>
</head>

<body onload="javascript:setupPage();">
<form name="form">
<input  type="hidden" name="f_cmd">
<input  type="hidden" name="ofc_cd">
<input  type="hidden" name="chg_cd">
<input  type="hidden" name="cgo_cate_cd">
<input  type="hidden" name="svc_scp_cd">
<input  type="hidden" name="per_cd">
<input  type="hidden" name="bkg_ofc_cd">
<input  type="hidden" name="jb_id">
<input  type="hidden" name="f_excel">

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
  <tr>
    <td>
	      
      <!-- TABLE '#D' : ( Search Options ) (S) -->
      <table class="search">
        <tr>
          <td class="bg">
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
	                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
	                    <tr>
	                      <td class="btn1_left"></td>
	                      <td class="btn1" id="btn_New" name="btn_New">New</td>
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
	                      <td class="btn1" id="btn_BLinquiry" name="btn_BLinquiry">BL Inquiry</td>
	                      <td class="btn1_right"></td>
	                    </tr>
	                  </table>
	                </td>
	                <td>
	                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
	                    <tr>
	                      <td class="btn1_left"></td>
	                      <td class="btn1" id="btn_BLinquiryexcel" name="btn_BLinquiryexcel">BL Inquiry Down Excel</td>
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
		    <!-- : ( Year) (E) -->
            <table class="search" border="0">
        		<tr><td class="line_bluedot" style="height:11;"></td></tr>
        	</table>   
			<!-- : ( Year) (S) -->
            <table border='0'>  
				<tr class='h23'>  
					<td width='70'>W/M/A</td>  
					<td width='235'>  
					    <div id='div_wm' style='display:inline;border:solid 0;'>  
					    <input type='radio' value='W' name='f_chkprd' class='trans' onClick="chkWM('W');" checked>&nbsp;Week  
					    <input type='radio' value='M' name='f_chkprd' class='trans' onClick="chkWM('M');">&nbsp;Month  
					    <input type='radio' value='A' name='f_chkprd' class='trans' onClick="chkWM('A');">&nbsp;Appl.  
					    </div>  
					</td>  
					<td width='450' class='sm'>  
					    <div id='div_year' style='display:inline;border:solid 0;width:80;height:16'>Year&nbsp; 
					    <input type='text' style='width:40;text-align:center;' class='input1' name='f_year' maxlength='4' style='ime-mode:disabled' onKeyPress='ComKeyOnlyNumber(window);' > 
					    </div>  
					
					    <div id='div_month' style='display:none;border:solid 0;width:140;height:16'>Month&nbsp; 
					    <input type='text' style='width:30;text-align:center;' class='input1' name='f_fm_mon' maxlength='2' style='ime-mode:disabled' onKeyPress='ComKeyOnlyNumber(window);' >&nbsp;&nbsp;~&nbsp; 
					    <input type='text' style='width:30;text-align:center;' class='input1' name='f_to_mon' maxlength='2' style='ime-mode:disabled' onKeyPress='ComKeyOnlyNumber(window);' > 
					    </div>  
					    
					    <div id='div_week' style='display:inline;border:solid 0;width:200;height:16'>Month&nbsp; 
					    <input type='text' style='width:30;text-align:center;' name='f_sls_mon' maxlength='2' style='ime-mode:disabled' onKeyPress='ComKeyOnlyNumber(window);'>&nbsp;&nbsp; 
					    Week&nbsp;
					    <input type='text' style='width:30;text-align:center;' class='input1' name='f_fm_wk' maxlength='2' style='ime-mode:disabled' onKeyPress='ComKeyOnlyNumber(window);' >&nbsp;&nbsp;~&nbsp; 
					    <input type='text' style='width:30;text-align:center;' class='input1' name='f_to_wk' maxlength='2' style='ime-mode:disabled' onKeyPress='ComKeyOnlyNumber(window);' > 
					    </div>  
					    
						<div id='div_period'></div>
						
					    <div id='div_appl' style='display:none;border:solid 0;width:255;height:16'>  
					    <input type="text" name="start_dt" style="width:80;text-align:center;readonly" class="input1" dataformat="ymd" tabindex="4" maxlength="8" size="10" onKeyPress='ComKeyOnlyNumber(window);'>
						&nbsp;<img src="img/btns_calendar.gif" name="btn_Calendar1" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
						<input type="text" style="width:15;text-align:center;background-color:#f3f2f8;border:0px" value="~"  tabindex="-1">
						<input type="text" name="end_dt" style="width:80;text-align:center;readonly" class="input1" dataformat="ymd"  tabindex="4" maxlength="8" size="10" onKeyPress='ComKeyOnlyNumber(window);'>
						&nbsp;<img src="img/btns_calendar.gif" name="btn_Calendar2" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
					    </div>  
					</td>  
					
				</tr>  
			</table> 
            <!-- : ( Year) (E) -->
            <table class="search" border="0">
        		<tr><td class="line_bluedot" style="height:11;"></td></tr>
        	</table>      
            <!-- : ( 조회조건 ) (S) -->
            <table border="0">
              <tr class="h23">
                <td width="100">Charge Code</td>
			    <td width="200">
                	<script language="javascript">ComComboObject('chg_cd_multi', 2, 200, 1, 1, 0, false);</script>
                </td>	
                <td width="4"></td>
                <td width="126">
                	<img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle">
                </td>
                <td width="65">Scope</td>
                <td width="200">
                	<script language="javascript">ComComboObject('svc_scp_cd_multi', 2, 200, 1, 1, 0, false);</script>
                </td>
                <td width="4"></td>
                <td>    
                	<img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle">
                </td>
                <td width="20">&nbsp</td>
                <td width="150">Mandatory Rating</td>
			    <td width="60">
                	<select style="width:50;" class="input1" name="mdtr_cd" tabindex="1">
                        <option value="A" selected>ALL</option>
                        <option value="Y">YES</option>
                        <option value="N">NO</option>
                    </select>
                </td>
                <td width=""></td>
              </tr>
            </table>
            <!-- : ( 조회조건 ) (E) -->
            <table class="search" border="0">
        		<tr><td class="line_bluedot" style="height:11;"></td></tr>
        	</table>
            <!-- : ( 조회조건2 ) (S) -->
            <table border="0">
              <tr class="h23">
                <td width="100">POR</td>
                <td width="107"><input type="text" style="width:50;text-align:center;ime-mode:disabled;" class="input" value="" maxlength="5" dataformat="engup" name="por_cd">
                				<img class="cursor" src="img/btns_search.gif" name="btn_por_cd" width="19" height="20" border="0" align="absmiddle"></td>
                
                <td width="50">POL</td>
                <td width="107"><input type="text" style="width:50;text-align:center;ime-mode:disabled;" class="input" value="" maxlength="5" dataformat="engup" name="pol_cd">
                				<img class="cursor" src="img/btns_search.gif" name="btn_pol_cd" width="19" height="20" border="0" align="absmiddle"></td>
 				
				<td width="50">POD</td>
                <td width="106"><input type="text" style="width:50;text-align:center;ime-mode:disabled;" class="input" value="" maxlength="5" dataformat="engup" name="pod_cd">
                				<img class="cursor" src="img/btns_search.gif" name="btn_pod_cd" width="19" height="20" border="0" align="absmiddle"></td>
                
                <td width="58">DEL</td>
                <td width="110"><input type="text" style="width:50;text-align:center;ime-mode:disabled;" class="input" value="" maxlength="5" dataformat="engup" name="del_cd">
                				<img class="cursor" src="img/btns_search.gif" name="btn_del_cd" width="19" height="20" border="0" align="absmiddle"></td>
              </tr>
            </table>
            <table class="search" border="0">
        		<tr><td class="line_bluedot" style="height:11;"></td></tr>
        	</table>
            <table border="0">
              <tr class="h23">
                <td width="100">RHQ</td>
                <td width="160">
                	<script language="javascript">ComComboObject('rhq_cd', 1, 93, 1, 0, 0, false);</script>
                </td>           
                <td width="103">BKG. OFC</td>
			    <td width="320">
                	<input type='text' name='bkg_ofc_cd_multi' style='width:265;ime-mode:disabled;' dataformat="engupcomma" >
                	<img class="cursor" name="btn_bkg_ofc_cd" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
                	<img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle">
                </td>
                <td width = "55"></td>
                <td width="65">Per</td>
			    <td width="150">
                	<script language="javascript">ComComboObject('per_cd_multi', 1, 150, 1, 0, 0, false);</script>
                </td>
                <td width="4"></td>
                <td>    
                	<img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle">
                </td>
                <td width=""></td>
              </tr>
            </table>
            <!-- : ( 조회조건2 ) (E) -->
            <table class="search" border="0">
        		<tr><td class="line_bluedot" style="height:11;"></td></tr>
        	</table>
            <!-- : ( 조회조건3 ) (S) -->
            <table border="0">
              <tr class="h23">
               <td width="95">Cargo Type</td>
               <td class="sm">
				 <nobr>
				   <input type="checkbox" class="trans"  id="chkDisplay" name="cgo_cate_cd_multi" value="DR"  >&nbsp;DR&nbsp;&nbsp;&nbsp;&nbsp;
				   <input type="checkbox" class="trans"  id="chkDisplay" name="cgo_cate_cd_multi" value="RF"   >&nbsp;RF&nbsp;&nbsp;&nbsp;&nbsp;
				   <input type="checkbox" class="trans"  id="chkDisplay" name="cgo_cate_cd_multi" value="DG"   >&nbsp;DG&nbsp;&nbsp;&nbsp;&nbsp;
				   <input type="checkbox" class="trans"  id="chkDisplay" name="cgo_cate_cd_multi" value="AK"   >&nbsp;AK&nbsp;&nbsp;&nbsp;
				   <input type="checkbox" class="trans"  id="chkDisplay" name="cgo_cate_cd_multi" value="BB"   >&nbsp;BB
				  </nobr>
			    </td>
              </tr>
            </table>
            <!-- : ( 조회조건3 ) (E) -->
          </td>
        </tr>
      </table>
      <!-- TABLE '#D' : ( Search Options ) (E) -->
      <table class="height_10"><tr><td></td></tr></table>
      <!-- TABLE '#D' : ( Search Options ) (S) -->
      <table class="search" border="0">
        <tr>
          <td class="bg">
            <!-- : ( SHEET ) (S) -->
            <table width="100%" id="mainTable" border="0">
              <tr><td width="100%" align="right">(CUR : USD)</td></tr>
              <tr><td><script language="javascript">ComSheetObject('sheet1');</script></td></tr>
            </table>
            <!-- : ( SHEET ) (E) -->
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