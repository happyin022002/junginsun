<%
/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ESM_PRI_0130_01.jsp
*@FileTitle : Charge Summary Report - Summary View
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.13
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.07.04 전윤주 [CHM-201325625] Customer Classification 조건을 CC, RC, LC로 수정
*=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.screport.screport.event.EsmPri013001Event"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%@ page import="com.hanjin.syscommon.common.table.MdmChargeVO"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List"%>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%>

<%
	EsmPri013001Event  event = null;					
	Exception serverException   = null;			
	String strErrMsg = "";						
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.SCReport.SCReport");
	String[] rhqs = null;
	String[] repChgCd = null;
    String[] svcScpCds = null;
    String[] custTpCds = null;
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmPri013001Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
			log.debug(serverException);
		}
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		// rhq Combo Data 생성
        rhqs = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("rhq"));
		//Rep. Charge Code Combo Date 생성
		repChgCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("repChgCd"));
		// Service Scope Combo Data 생성
        svcScpCds = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("svcScpCd"));
     	// Customer Type Combo Data 생성
        custTpCds = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("custTpCd"), true , "|", "\t", "getCode", "getName");
	} catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Charge Summary Report - Summary View</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	var rhqComboValue = "|<%=rhqs[0]%>";
	var rhqComboText = "|<%=rhqs[1]%>";
	
	var repChgComboValue = " |<%=repChgCd[0]%>";  
    var repChgComboText = " |<%=repChgCd[1]%>";
    
    var svcScpComboValue = "<%=svcScpCds[0]%>";
    var svcScpComboText = "<%=svcScpCds[1]%>";

    var custTpCdComboValue = "A|<%=custTpCds[0]%>";
    var custTpCdComboText = "ALL|<%=custTpCds[1]%>";

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
<input  type="hidden" name="cust_grp_id">
<input  type="hidden" name="cust_cd">
<input  type="hidden" name="svc_scp_cd">
<input  type="hidden" name="per_cd">
<input  type="hidden" name="ctrt_ofc_cd">
<input  type="hidden" name="jb_id">
<input  type="hidden"   name="f_excel">

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
                <td width="160">Rep.Charge</td>
                <td width="140">
                	<script language="javascript">ComComboObject('rep_chg_cd', 2, 93, 1, 1, 0, false);</script>
                </td>
                <td width="90">Charge Code</td>
			    <td width="290">
                	<script language="javascript">ComComboObject('chg_cd_multi', 2, 290, 1, 1, 0, false);</script>
                </td>	
                <td width="4"></td>
                <td width="96">
                	<img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle">
                </td>
                <td width="120">Mandatory Rating</td>
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
                <td width="160">Customer Classification</td>
                <td width="360">
                	<select style="width:93;" class="input" name="cust_clss" tabindex="1">
                        <option value="A" selected>ALL</option>
                        <option value="CC">CC</option>
                        <option value="RC">RC</option>
                        <option value="LC">LC</option>
                    </select>
                </td>
                <td width="121">Customer Type</td>
			    <td width="130">
                	<script language="javascript">ComComboObject('cust_tp_cd', 2, 103, 1, 1, 0, false);</script>
                </td>
              </tr>
            </table> 
            <table border="0">
              <tr class="h23">    
                <td width="160">Group Customer Code</td>
			    <td width="360">
                	<input type='text' name='cust_grp_id_multi' readonly style='ime-mode:disabled;readonly;width:265;'>
                	<img class="cursor" name="btn_cust_grp_id" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
                	<img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle">
                	<img class="cursor" name="btn_del_cust_grp_id" src="img/btn_del.gif" width="19" height="20" border="0" align="absmiddle">
                </td>
                <td width="120">Customer Code</td>
			    <td width="340">
                	<input type='text' name='cust_cd_multi' readonly style='ime-mode:disabled;readonly;width:265;'>
                	<img class="cursor" name="btn_cust_cd" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
                	<img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle">
                	<img class="cursor" name="btn_del_cust_cd" src="img/btn_del.gif" width="19" height="20" border="0" align="absmiddle">
                </td>
              </tr>
            </table>
            <!-- : ( 조회조건2 ) (E) -->
            <table class="search" border="0">
        		<tr><td class="line_bluedot" style="height:11;"></td></tr>
        	</table>
            <!-- : ( 조회조건3 ) (S) -->
            <table border="0">
              <tr class="h23">
                <td width="160">RHQ</td>
                <td width="360">
                	<script language="javascript">ComComboObject('rhq_cd', 1, 93, 1, 0, 0, false);</script>
                </td>
                <td width="120">C.OFC</td>
			    <td width="315">
                	<input type='text' name='ctrt_ofc_cd_multi' style='width:265;ime-mode:disabled;' dataformat="engupcomma" >
                	<img class="cursor" name="btn_ctrt_ofc_cd" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
                	<img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle">
                </td>
                <td width=""></td>
              </tr>
            </table>
            <!-- : ( 조회조건3 ) (E) -->
            <table class="search" border="0">
        		<tr><td class="line_bluedot" style="height:11;"></td></tr>
        	</table>
            <!-- : ( 조회조건4 ) (S) -->
            <table border="0">
              <tr class="h23">
                <td width="160">Scope</td>
                <td width="290">
                	<script language="javascript">ComComboObject('svc_scp_cd_multi', 2, 290, 1, 0, 0, false);</script>
                </td>
                <td width="4"></td>
                <td width="66">	
                	<img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle">
                </td>
                <td width="121">Per</td>
			    <td width="290">
                	<script language="javascript">ComComboObject('per_cd_multi', 1, 290, 1, 0, 0, false);</script>
                </td>
                <td width="4"></td>
                <td>    
                	<img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle">
                </td>
                <td width=""></td>
              </tr>
            </table>
            <!-- : ( 조회조건4 ) (E) -->
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