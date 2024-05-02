<%
/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ESM_PRI_8004.jsp
*@FileTitle : Awkward Cargo Pricing Application
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.26
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.02.12 문동선
* 1.0 Creation
=========================================================
* History 
* 2013.06.26 이혜민 [CHM-201325215] Special cargo Quotation System 수정 요청 - Approval, Application 화면에 Approver Name 추가, Request ID는 Requester Name으로 변경
* 2013.07.25 송호진 [CHM-201325102] Approval Cancel 기능 추가
* 2014.09.11 송호진 [CHM-201431718] SCQ System 기능 추가 개발 요청 - Actual Customer란
* 2015.04.23 송호진 [CHM-201533702] SCQ내에 Unit Dual (cm/Inch) System 개발 요청
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.event.EsmPri8004Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.core.config.SiteConfigFactory"%>
<%@ page import="java.util.List"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>

<%
	EsmPri8004Event event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc       = "";//
	String strUsrSrepCd     = "";//
	Logger log = Logger.getLogger("com.hanjin.apps.specialcargoquotation.scqawkward");
	String[] measSysCd = null;

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();//
		strUsrSrepCd = account.getSrep_cd();//

		event = (EsmPri8004Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		measSysCd       = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("MEAS_SYS_CD"), false);

	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String pDate2 = "";
	String pDate1 = "";
	String aDate2 = "";
	String aDate1 = "";
	
	// pop_mode
	String popMode = (request.getParameter("pop_mode") == null)? "N": "Y";	
	
	String p_rqstno = (request.getParameter("p_rqstno") == null)? "": request.getParameter("p_rqstno");
	String p_verno = (request.getParameter("p_verno") == null)? "": request.getParameter("p_verno");

	String[] svcScpCd = null;   
	
%>
<html>
<head>
<title>Awkward Cargo Pricing Application</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	var server_url = "<%=SiteConfigFactory.get("COM.HANJIN.SYSTEM.DOMAIN_URL") %>";
	var measSysCdValue = "<%=measSysCd[0]%>";
	var measSysCdText = "<%=measSysCd[1]%>";

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<!-- 개발자 작업	-->
	
<% if (popMode.equals("Y")) { %>

<body class="popup_bg" onLoad="setupPage();" onBeforeUnload="check_temporary_data_exists();" >
<form name="form">
<table width="100%" class="popup" cellpadding="10" border="0">
  <tr><td class="top"></td></tr>
  <tr>
    <td valign="top">
      <!-- : ( Title ) (S) -->
      <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Awkward Cargo Rate Approval</td></tr>
      </table>
      <!-- : ( Title ) (E) -->

<% } else { %>

<body onLoad="setupPage();" onBeforeUnload="check_temporary_data_exists();" >
<form name="form">
<table border="0" cellpadding="0" cellspacing="0" style="padding: 5 0 0 2;">
  <tr>
    <td valign="top">
      <!-- Page Title, Historical (S) -->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
      </table>
      <!-- Page Title, Historical (E) -->
<% } %>

<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows">
<!--<input type="hidden" name="scq_rqst_no">-->
<input type="hidden" name="scq_ver_no">
<input type="hidden" name="cd">
<input type="hidden" name="p_rqstno" value="<%=p_rqstno%>">
<input type="hidden" name="p_verno" value="<%=p_verno%>">
 
<input type="hidden" name="in_usr_ofc_cd" value="<%=strUsr_ofc%>"> 
<input type="hidden" name="in_usr_srep_cd" value="<%=strUsrSrepCd%>">
<input type="hidden" name="in_usr_nm" value="<%=strUsr_nm%>"> 
<input type="hidden" name="in_usr_id" value="<%=strUsr_id%>">
<input type="hidden" name="oti_eff_dt">
<input type="hidden" name="oti_exp_dt"> 
<input type="hidden" name="oti_amt">
<input type="hidden" name="oti_lic_no">
<input type="hidden" name="first_cre_usr_id">

<input type="hidden" name="send_usr_nm" value="<%=strUsr_nm%>"> 
<input type="hidden" name="gw_subject"> 
<input type="hidden" name="gw_contents"> 
<input type="hidden" name="gw_template">
<input type="hidden" name="gw_args"> 
<input type="hidden" name="scq_ver_no_tmp"> 

      <!-- Button (S) -->
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;">
        <tr>
          <td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
              <tr>
               <% if (popMode.equals("Y")) { %>
                <td>
                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_previous">Previous</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_next">Next</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
              <% } %>
                <td>
                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_retrieve">Retrieve</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_new">New</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table></td>
<!--                <td>-->
<!--                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">-->
<!--                    <tr>-->
<!--                      <td class="btn1_left"></td>-->
<!--                      <td class="btn1" name="btn_copy">Copy</td>-->
<!--                      <td class="btn1_right"></td>-->
<!--                    </tr>-->
<!--                  </table>-->
<!--                </td>-->
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_pending">Pending</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_approval">Approval</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_reject">Reject</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_delete">Delete</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_cancel">Cancel</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_sendmail">Send&nbsp;Mail</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_attachfile">Attach&nbsp;File</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
      <!-- Button (E) -->
      
      <table class="height_8"><tr><td colspan="8"></td></tr></table>
    
      <!-- biz page (S) -->

      
      
      <table class="search">
        <tr>
          <td class="bg">

            <!-- biz_1 (S) -->
            <table class="search" border="0" style="width:979;">
              <tr class="h23">
              	<td width="90">Request OFC.</td>
				<td width="90"><input type="text" style="width: 72;" name="rqst_ofc_cd" dataformat="engup" class="input2" maxlength="5" readonly required></td>
				<td width="70">Sales Rep.</td>
				<td width="169" style="display:none"><script language="javascript">ComComboObject('prop_srep_cd_combo', 3, 61, 0, 0);</script></td>                                </td>
                <td width="169"><input type="text" style="width: 60;" name="prop_srep_cd" readonly class="input2">
                                <input type="text" style="width: 83;" name="prop_srep_nm" readonly class="input2"></td>                
				<td width="90">Approval OFC.</td>
                <td width="100"><input type="text" style="width: 72;" name="apro_ofc_cd" dataformat="engup" class="input2" maxlength="6" required></td>
                <td width="80">Request No.</td>
				<td width="123"><input type="text" style="width: 110;" name="scq_rqst_no" dataformat="uppernum" class="input" maxlength="15"></td>
				<td width="60"><script language="javascript">ComComboObject('scq_ver_no_combo', 3, 55, 1, 0);</script></td>
				<td width="115"><input type="text" style="width:100;" class="input2" maxlength="10" name="prog_sts_nm" readonly></td>
                
              </tr>
            </table>
            <!-- biz_1 (E) -->

          </td>
        </tr>
      </table>

			
      <table class="height_8"><tr><td colspan="8"></td></tr></table>

      <table class="search">
        <tr>
          <td class="bg" valign="top">
          	<table class="search" border="0" style="width:979;">
              <tr class="h23">
                <td width="30">POR</td>
                <td width="80"><input type="text" style="width:50;" class="input2" value="" maxlength="5" dataformat="uppernum" name="por_cd">
                				<img class="cursor" src="img/btns_search.gif" name="btn_por_cd" width="19" height="20" border="0" align="absmiddle"></td>
                <td width="10"></td>
                
                <td width="30">POL</td>
                <td width="105"><input type="text" style="width:50;" class="input2" value="" maxlength="5" dataformat="uppernum" name="pol_cd" style="ime-mode:disabled">
                				<input type="text" style="width:25;" class="input2" value="" maxlength="2" dataformat="uppernum" name="pol_yd_cd">
                				<img class="cursor" src="img/btns_search.gif" name="btn_pol_cd" width="19" height="20" border="0" align="absmiddle"></td>
				<td width="60"><table width="99%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn_pol_info">Info.</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
 				<td width="10"></td>
 				
				<td width="30">POD</td>
                <td width="105"><input type="text" style="width:50;" class="input2" value="" maxlength="5" dataformat="uppernum" name="pod_cd">
                				<input type="text" style="width:25;" class="input2" value="" maxlength="2" dataformat="uppernum" name="pod_yd_cd">
                				<img class="cursor" src="img/btns_search.gif" name="btn_pod_cd" width="19" height="20" border="0" align="absmiddle"></td>
				<td width="60"><table width="99%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn_pod_info">Info.</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
                <td width="10"></td>
                
                <td width="30">DEL</td>
                <td width="80"><input type="text" style="width:50;" class="input2" value="" maxlength="5" dataformat="uppernum" name="del_cd">
                				<img class="cursor" src="img/btns_search.gif" name="btn_del_cd" width="19" height="20" border="0" align="absmiddle"></td>
                <td width="16"></td>
                
                <td width="130"><table width="99%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn_productCatalog">Product Catalog</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
                <td width="21"></td>
                
                <td width="97">Service Scope</td>
				<td width="75" style="display:none"><script language="javascript">ComComboObject('svc_scp_cd_combo', 2, 70, 0, 1);</script></td>
				<td width="75"><input type="text" style="width:70;" class="input2" value="" maxlength="5" dataformat="engup" name="svc_scp_cd"></td>
              </tr>
            </table>

			<table class="search" border="0" style="width:979;">
              <tr class="h23">
                <td width="120">Customer</td>
                <td width="84"><input type="text" style="width:26;" class="input2" value="" maxlength="2" dataformat="engup" name="cust_cnt_cd">
                                <input type="text" style="width:50;" class="input2" value="" maxlength="6" dataformat="int" name="cust_seq">
                                <img style="display:none" class="cursor" src="img/btns_search.gif" name="btn_customer" width="19" height="20" border="0" align="absmiddle"></td>
                <td width="325"><input type="text" style="width:230;" class="input2" value="" name="ctrt_pty_nm" readonly></td>
                <td width="127">Awkward Term</td>
                <td width="45"><script language="javascript">ComComboObject('rcv_term_cd', 2, 40, 0, 0, 0, false);</script></td>
                <td width="45"><script language="javascript">ComComboObject('de_term_cd', 2, 40, 0, 0, 0, false);</script></td>
                <td width="61"></td>
                <td width="172">AWK/BB Handling Info. 
                                <img class="cursor" src="img/btns_search.gif" name="btn_commonattach" width="19" height="20" border="0" align="absmiddle"></td>           
              </tr>
            </table>


			<table class="search" border="0" style="width:979;">
              <tr class="h23">
                <td width="120">Act. Customer</td>
                <td width="84"><input type="text" style="width:25;" class="input2" value="" maxlength="2" dataformat="engup" name="act_cust_cnt_cd" readonly>
                                <input type="text" style="width:51;" class="input2" value="" maxlength="6" dataformat="int" name="act_cust_seq" readonly>
                                <img style="display:none" class="cursor" src="img/btns_search.gif" name="btn_customer2" width="19" height="20" border="0" align="absmiddle"></td>
                <td width="325"><input type="text" style="width:230;" class="input2" value="" name="act_cust_nm" readonly></td>
                <td width="127">Bidding Flag</td>
                <td width="90"><script language="javascript">ComComboObject('scq_bid_flg', 2, 80, 1, 0, 0, false);</script></td>
                <td width="90">&nbsp;</td>
                <td width="130">&nbsp;</td>           
              </tr>
            </table>
                        
            <table class="search" border="0" style="width:979;">
              <tr class="h23">
                <td width="120">Proposal Duration</td>
                <td width="225"><input type="text" style="width:80;ime-mode:disabled;" class="input2" value="<%=pDate1%>" maxlength="10" dataformat="ymd" name="p_date1">&nbsp;~
                    <input type="text" style="width:80;ime-mode:disabled;" class="input2" value="<%=pDate2%>" maxlength="10" dataformat="ymd" name="p_date2">
                    <img src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" style="cursor:hand;" name="btn_Calendar1"></td>
                <td width="125">Approval Duration</td>
                <td width="230"><input type="text" style="width:80;ime-mode:disabled;" class="input1" value="<%=aDate1%>" maxlength="10" dataformat="ymd" name="a_date1">&nbsp;~
                    <input type="text" style="width:80;ime-mode:disabled;" class="input1" value="<%=aDate2%>" maxlength="10" dataformat="ymd" name="a_date2">
                    <img src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" style="cursor:hand;" name="btn_Calendar2"></td>    
                <td width="68">Requester</td>
                <td width="95"><input type="text" style="width:75;ime-mode:disabled;" class="input2" name="first_cre_usr_nm" readonly></td>
              	<td width="68">Approver</td>
              	<td width="80"><input type="text" style="width:75;ime-mode:disabled;" class="input2" name="apro_usr_nm" readonly></td>
              </tr>
            </table>
			
      <table class="height_8"><tr><td colspan="8"></td></tr></table>

        <!-- biz_2 (S) -->
        <table class="search" border="0">
          <tr>
            <td class="title_h"></td>
            <td class="title_s" width="200" >Rate & Cargo Information</td>
            <td width="120"><b>Measurement Unit</b></td>
            <td width="*"><script language="javascript">ComComboObject('meas_sys_cd_vw', 1, 130, 1, 0, 0, false);</script></td>           
          </tr>
        </table>
        <!-- Grid (S) -->
        <table width="100%"  border="0" id="mainTable" style="width:979;">
          <tr>
          <td width="100%">
          <script language="javascript">ComSheetObject('sheet1');</script>
          </td>
          </tr>
        </table>
        <!-- Grid (E) -->
            
<!--        <table width="979" class="button">-->
<!--          <tr><td class="btn2_bg">-->
<!--            <table border="0" cellpadding="0" cellspacing="0"><tr>-->
<!--              <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">-->
<!--              <tr><td class="btn2_left"></td>-->
<!--              <td class="btn2" name="btn_rowadd">Row&nbsp;Add</td>-->
<!--              <td class="btn2_right"></td>-->
<!--              </tr>-->
<!--              </table></td>-->
<!--              <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">-->
<!--              <tr><td class="btn2_left"></td>-->
<!--              <td class="btn2" name="btn_rowdel">Row&nbsp;Del</td>-->
<!--              <td class="btn2_right"></td>-->
<!--              </tr>-->
<!--              </table></td></tr>-->
<!--            </table>-->
<!--          </td></tr>-->
<!--        </table>-->
            
            
        <!-- biz_2 (E) -->
        
        <table class="height_8"><tr><td colspan="8"></td></tr></table>
        
        <table class="search" border="0" style="width:979;">
          <tr>
            <td width="689">
              <table class="search" border="0">
                <tr>
                  <td class="title_h"></td>
                  <td class="title_s">Handling Cost by Route (USD)</td>
                </tr>
                
              </table>	
            </td>
            <td width="10"></td>  
            <td width="280">
              <table class="search" border="0">
                <td class="title_h"></td>
                <td class="title_s" width="80">Total Rate</td>
                <td width="95" align="center">Basic&nbsp;</td>
                <td width="95" align="center">Void&nbsp;</td>
              </table>
            </td>
          </tr>   	
         
          <tr>
            <td>
            <!-- Grid  (S) -->
              <table width="100%"  id="mainTable">
                <tr>
                  <td width="100%"><script language="javascript">ComSheetObject('sheet2');</script></td>
                </tr>
              </table>
              <table width="100%" class="button">
                <tr class="h23">
                  <td ><font color="red" id="red_msg"></font></td>
                  <td class="btn2_bg">
                  <table border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                          <td class="btn2" name="btn_calculation">Calculation</td>
                          <td class="btn2_right"></td>
                        </tr>
                        </table></td>
                     </tr>
                  </table>
                </td></tr>
              </table>
              <!-- Grid (E) -->
            </td>
            <td></td>
            <td>
                  <table class="search" border="0" style="width:100%;">
                    <tr>
                      <td width="80">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Proposal</td>
                      <td width="200"><input type="text" style="width:95;ime-mode:disabled;" class="input2" readonly name="rqst_basic_rate">
                                      <input type="text" style="width:95;ime-mode:disabled;" class="input2" readonly name="rqst_void_rate"></td>
                    </tr>
                    <tr>
                      <td width="80">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Approval</td>
                      <td width="200"><input type="text" style="width:95;ime-mode:disabled;" class="input2" readonly name="apro_basic_rate">
                                      <input type="text" style="width:95;ime-mode:disabled;" class="input2" readonly name="apro_void_rate"></td>    
                    </tr>
                  </table>
            
                  <table class="search" border="0">
                    <td class="title_h"></td>
                    <td class="title_s">Remark</td>
                  </table>
            
                  <table border="0" style="width:100%; background-color:white;" class="grid2"> 
                    <tr>
                      <td width="15%" class="tr2_head"> Req.</td>
                      <td width="%"><textarea name="rmk_req" class="textarea2" readonly style="width:100%;height:57"></textarea></td>
                    </tr>
                    <tr>
                      <td width="15%" class="tr2_head"> Appr.</td>
                      <td width="%"><textarea name="rmk_appr" class="textarea2" style="width:100%;height:57"></textarea></td>
                    </tr>
                  </table>
            </td>
          </tr>
		</table>   

        <table class="search" border="0" style="width:979;display:none;" ><tr><td>
            <!-- Grid  (S) -->
              <table width="100%" id="mainTable">
                <tr>
                  <td width="100%"><script language="javascript">ComSheetObject('sheet3');</script></td>
                </tr>
                <tr>
                  <td width="100%"><script language="javascript">ComSheetObject('sheet4');</script></td>
                </tr>
              </table>
              <!-- Grid (E) -->
        </td></tr></table>
           
    
    
          </td>
        </tr>
      </table>
    </td>
        </tr>
      </table>  
      <!-- biz page (E) -->


<% if (popMode.equals("Y")) { %>
      <!-- : ( Button : pop ) (S) -->
      <table width="100%" class="sbutton">
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
      </table>
      <!-- : ( Button : pop ) (E) -->
<% } %>
          

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>