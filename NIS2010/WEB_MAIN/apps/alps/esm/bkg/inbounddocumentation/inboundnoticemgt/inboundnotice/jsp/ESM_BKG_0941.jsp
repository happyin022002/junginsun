<%
/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0941.jsp
 *@FileTitle : Consignee Code Error Report
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.28
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2009.04.28 박만건
 * 1.0 Creation
 =========================================================
 * History
 * 2009.11.05 박만건 수정 - 폼에 javascript 제거
 * 2010.10.14 변종건 [] 
 * 2012.02.14 변종건 [CHM-201215951] Customer Error Code Report 화면 보완 
 *                  - Including non-validated code 조건 추가 및 Customer Type Code 에 Per B/L Type 추가
 * 2013.02.12 김진주 [CHM-201322860] Customer Code Error Report 보완 요청
 * 2013.02.19 김진주 [CHM-201322860] Customer Code Error Report 보완 요청
 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0941Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg0941Event  event = null;          //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;      //서버에서 발생한 에러
    String strErrMsg = "";            //에러메세지
    int rowCount   = 0;            //DB ResultSet 리스트의 건수
    
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";
    
    String strUsr_id    = "";
    String strUsr_nm    = "";
    Logger log = Logger.getLogger("com.hanjin.apps.InboundBLMgt.ArrivalNotice");
    
    String code = "";  // Evaluation Result Code
    String value = "";
    String custCode = ""; // Customer Type Code
    String custValue = "";
    
    String userOfcCd = "";
    String userRhqOfcCd = "";
    
    // 임시
    StringBuffer tempData = new StringBuffer();
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        
        strUsr_id =  account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        userOfcCd = account.getOfc_cd();
        userRhqOfcCd = account.getRhq_ofc_cd();
        
        //임시

        tempData.append("UserId[").append(strUsr_id).append("] ");
        tempData.append("CntCd[").append(account.getCnt_cd()).append("] ");
        tempData.append("userRhqOfcCd[").append(account.getRhq_ofc_cd()).append("] ");
        tempData.append("userAuthTpCd[").append(account.getUsr_auth_tp_cd()).append("] ");
        tempData.append("userAuth[");
        String[] userAuth  = account.getUserAuth();
        if (userAuth != null && userAuth.length > 0) {
        	for (int i = 0; i < userAuth.length ; i ++ ) {
        		tempData.append(userAuth[i]);
        		if (i != userAuth.length - 1) {
        			tempData.append(",");
        		}
        	}
        	tempData.append("]");
        }
         
        event = (EsmBkg0941Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title>Consignee Code Error Report</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">

      
	var gUsrOfcCd = "<%=userOfcCd %>";
	var gUserRhqOfcCd = "<%=userRhqOfcCd %>";    

    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if
        loadPage();
    }
</script>
</head>

<body  onLoad="setupPage();">
<form name="form" >
<input name="f_cmd" type="hidden" />
<input type="hidden" name="pagerows" value="<%=pageRows %>">

<!-- 개발자 작업  -->

<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp" %>
    
      <!--biz page (S)-->
      <table class="search" id="mainTable"> 
        <tr>
          <td class="bg">  
            <table class="search" border="0" style="width:979;"> 
              <tr class="h23">
                <td width="">
	              <table class="search_sm2" border="0" style="width:93%;">
		              <tr class="h23">
		                <td width="220">
		                  <input type="radio" name="dt_option" value="B" checked class="trans">BKG&nbsp;&nbsp
		                  <input type="radio" name="dt_option" value="R" class="trans">Report&nbsp;&nbsp
		                  <input type="radio" name="dt_option" value="E" class="trans">ETA&nbsp;&nbsp
		                </td>
		                <td width="200" name="bkg_dt" id="bkg_dt">
		                  <input type="text" style="width:75;" class="input1" value="" dataformat="ymd" maxlength="10" 
		                         caption="BKG Period Start Date" required name="bkg_cre_dt_s" cofield="bkg_cre_dt_e" 
		                         style="ime-mode:disabled" onKeyPress="obj_KeyPress(this);" />&nbsp;~
		                  <input type="text" style="width:75;" class="input1" value="" dataformat="ymd" maxlength="10" 
		                         caption="BKG Period End Date" required name="bkg_cre_dt_e" cofield="bkg_cre_dt_s" 
		                         style="ime-mode:disabled" onKeyPress="obj_KeyPress(this);" />
		                  <img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" 
		                         class="cursor" name="btn_bkg_cre_dt" />
		                </td>
		                <td width="200" name="rpt_dt" id="rpt_dt" style="display:none;">
		                  <input type="text" style="width:75;" class="input1" value="" dataformat="ymd" maxlength="10" 
		                         caption="Report Period Start Date" name="val_dt_s" cofield="val_dt_e" 
		                         style="ime-mode:disabled" onKeyPress="obj_KeyPress(this);" />&nbsp;~
		                  <input type="text" style="width:75;" class="input1" value="" dataformat="ymd" maxlength="10" 
		                         caption="Report Period End Date" name="val_dt_e" cofield="val_dt_s" 
		                         style="ime-mode:disabled" onKeyPress="obj_KeyPress(this);" />
		                  <img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" 
		                         class="cursor" name="btn_val_dt" />
		                </td>
		                <td width="200" name="eta_dt" id="eta_dt" style="display:none;">
		                  <input type="text" style="width:75;" class="input1" value="" dataformat="ymd" maxlength="10" 
		                         caption="ETA Period Start Date" name="eta_dt_s" cofield="eta_dt_e" 
		                         style="ime-mode:disabled" onKeyPress="obj_KeyPress(this);" />&nbsp;~
		                  <input type="text" style="width:75;" class="input1" value="" dataformat="ymd" maxlength="10" 
		                         caption="ETA Period End Date" name="eta_dt_e" cofield="eta_dt_s" 
		                         style="ime-mode:disabled" onKeyPress="obj_KeyPress(this);" />
		                  <img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" 
		                         class="cursor" name="btn_eta_dt" />
		                </td>
		              </tr>
	              </table>
	            </td>

                  <td width="">
                  	 <table class="search_sm2" border="0" style="width:98%;">
                  	 <tr class="h23">    
                  	    <td width="120">Evaluation-result</td>            		
                		<td width="">All<input type="radio" name="mtch_flg" value="A" class="trans"></td>	
                		<td width="">Auto-matched<input type="radio" name="mtch_flg" value="Y" class="trans"></td>	
                		<td width="">Ok<input type="radio" name="mtch_flg" value="O" class="trans"></td>
                		<td width="200">Un-matched&nbsp;<input type="radio" name="mtch_flg" value="N" checked="true" class="trans">
                		<script language="javascript">ComComboObject('val_cd', 1, 100, 1, 0, 0);</script></td>             		
            		  </tr>
            			</table> 
                  </td>
               

              </tr>
            </table> 
            <table class="search" border="0" style="width:979;"> 
              <tr class="h23">
                <td width="100" align="center">RHQ</td>
                <td width="110">
                  <script language="javascript">ComComboObject('rhq_cd', 1, 100, 1,0,1);</script>
                </td>
                <td width="50" align="center">GSO</td>
                <td width="90" ><input type="text" style="width:60;" class="input1" name="gso_cd" caption="GSO"
                         minlength="5" maxlength="6" style="ime-mode:disabled" />
                  <img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" 
                       class="cursor" name="gso_cd_inq" />
                </td>
                <td width="90" align="center">
                	Office Type
                <td width="105">
                  <select name="ofc_tp_cd" style="width:105" >
								<option value="B" >Booking</option>
								<option value="I" >Code Input</option>
								<option value="V" >Code Validate</option>
								</select>
                  
                </td>
                <td width="100" align="right">Office</td>
                <td width="85">
                  <input type="text" style="width:60;" class="input1" name="ofc_cd" caption="Office"
                         minlength="5" maxlength="6" style="ime-mode:disabled" />
                  <img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" 
                       class="cursor" name="ofc_cd_inq" />
                </td>
                <td width="145" align="right">Error Customer Code</td>
                <td width="85">
                  <input type="text" style="width:60;" class="input"  name="cust_cd" caption="Error Customer Code"
                         maxlength="8" style="ime-mode:disabled" />
                  <img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" 
                       class="cursor" name="cust_cd_inq" />
                </td>
                  
                </td>
              </tr>
            </table> 
            <table class="search" border="0" style="width:979;"> 
              <tr class="h23">
                <td width="100" align="center">Customer Type</td>
                <td width="110">
                <script language="javascript">ComComboObject('cust_tp_cd', 1, 100, 1,0,1);</script>
                </td>                
                <td width="50" align="right">B/L No.</td>
                <td width="90"><input type="text" style="width:90;" class="input" name="bl_no" caption="bl_no" maxlength="20" style="ime-mode:disabled" /></td>                
     			<td width="90" align="right">Code Inputer</td>
                <td width="85"><input type="text" style="width:60;" class="input" name="doc_usr_id" caption="Inputer ID"
                         maxlength="20" style="ime-mode:disabled" />
                  <img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle"
                         class="cursor" name="doc_usr_id_inq"/>
                </td>      
                <td width="120" align="right">Code Validator</td>
                <td width="85"><input type="text" style="width:60;" class="input"  name="val_usr_id" caption="Reporter ID" maxlength="12" style="ime-mode:disabled"/>
                	<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="val_usr_id_inq" />
                </td>
                <td width="145" align="right"></td>
                <td width="85">

                 <!--  <td width="">
                  	 <table class="search_sm2" border="0" style="width:390;">
                  	 <tr class="h23">
                		 <td width=""><input type="checkbox" name="ob_ev_cd" value="1" class="trans">Wrong Evaluation&nbsp;&nbsp;&nbsp;
                					  <input type="checkbox" name="ib_ev_cd" value="1" class="trans">I/B Confirm&nbsp;&nbsp;&nbsp;
                					  <input type="checkbox" name="hq_ev_cd" value="1" class="trans">H/Q Confirm
                		 </td>
            		  </tr>
            			</table> 
                  </td>-->
              </tr>
            </table> 
            <table class="search" border="0" style="width:979;"> 
              <tr class="h23">
                <td width="725" align="right">Show total error code by reason<input type="checkbox" name="err_flg" value="" class="trans"></td>
                <td width="220" align="right">Including non-validated code<input type="checkbox" name="non_val_flg" value="Y" class="trans"></td>
              </tr>
            </table>
            <table class="height_5"><tr><td></td></tr></table>
      
            <!-- Grid  (S) -->
            <table width="100%"  id="mainTable"> 
              <tr>
                <td width="100%">
                  <script language="javascript">ComSheetObject('sheet1');</script>
                  <script language="javascript">ComSheetObject('sheet2');</script>
                </td>
              </tr>
            </table>
           	<table width="100%"  id="subTable"> 
			  <tr>
				<td width="100%">
					<script language="javascript">ComSheetObject('sheet3');</script>
				</td>
			  </tr>
			</table> 
            <!-- Grid  (E) -->
          </td>
        </tr>
      </table>
      <!--biz page (E)-->

      <!--Button (S) -->
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
        <tr>
          <td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_Retrieve" id="btn_Retrieve" >Retrieve</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td class="btn1_line"></td>
              <td>
                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                  <tr>
                    <td class="btn1_left"></td>
                    <td class="btn1" name="btn_Save">Save</td>
                    <td class="btn1_right"></td>
                  </tr>
                </table>
              </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_DownExcel">Down Excel</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
      <!--Button (E) -->
  
    </td>
  </tr>
</table>

<!-- 개발자 작업  끝 -->
<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_CLOSE.jsp" %>
</form>
</body>
</html>