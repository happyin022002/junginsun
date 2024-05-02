<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_3014.jsp
*@FileTitle : Approval for Charge Inactivation
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.13
*@LastModifier : Kim Hyun Hwa
*@LastVersion : 1.0
* 2011.07.13 Kim Hyun Hwa
* 1.0 Creation 
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.event.EesDmt3014Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt3014Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String strRhq_ofc_cd	= "";
	Logger log = Logger.getLogger("com.hanjin.apps.DMTClosing.ChargeCalculation");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
        strRhq_ofc_cd = account.getRhq_ofc_cd();

		event = (EesDmt3014Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Approval for Charge Inactivation</title>
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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->

<input type="hidden" name="dmdt_chg_delt_rsn_cd">
<input type="hidden" name="usr_ofc_cd"	value="<%=strOfc_cd%>">
<input type="hidden" name="usr_rhq_ofc_cd"	value="<%=strRhq_ofc_cd%>">
<input type="hidden" name="apro_ofc_cd"	>
<!-- Deletion Authority Setup CSR 건 구현에 필요한 필드추가함 -->
<input type="hidden" name="dmdt_trf_cd" value="" />
<input type="hidden" name="chg_delt_proc_sts" value="" />
<!-- 로그인 사용자의 승인권한이 존재하는 승인단계 -->
<input type="hidden" name="chg_delt_path_cd" value="" />
<!-- DMT Office - Incl. Sub Office 조회에 사용되는 필드 추가함 -->
<input type="hidden" name="ofc_cd">
<input type="hidden" name="tmp_ofc_cd">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
  <tr>
    <td valign="top">
    <!--Page Title, Historical (S)-->
	    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">   
	        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>   
	        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>   
	    </table> 
      <!--Page Title, Historical (E)-->

      <!--biz page (S)-->
      <table class="search">
        <tr>
          <td class="bg"><!-- biz_1  (S) -->
            <table class="search" border="0" style="width:959;">
              <tr class="h23">
                <td width="67">DMT Office</td>
                <td width="335" colspan="3" class="stm">
                   <script language="javascript">ComComboObject('dmt_ofc_cd', 2, 200, 0, 1, 0, true);</script>&nbsp;<img src="img/btns_multisearch.gif" width="19" height="20" alt="" border="0" align="absmiddle">
							<input type="checkbox" name="chk_sub_ofc" value="Y" onClick="doInclSubOfc()" class="trans">&nbsp;Incl. Sub Office
                </td>
                <td width="95">Request Period</td>
                <td width="234">
              		<input type="text" name="fm_dt" maxlength="8" dataformat="ymd" style="width:80;" class="input1">&nbsp;~
					<input type="text" name="to_dt" maxlength="8" dataformat="ymd" style="width:80;" class="input1">
					<img src="img/btns_calendar.gif" name="btns_calendar" width="19" height="20" alt="" border="0" align="absmiddle" style="cursor:hand">
                </td>
                <td width="50">VVD CD</td>
                <td width="80"><input type="text" name="vvd_cd" dataformat="engup" maxlength="9" style="width:80;" class="input" value=""></td>
              </tr>
              <tr class="h23">
                <td width="67">Tariff Type</td>
                <td width="120"><script language="javascript">ComComboObject('cboTariff', 2, 96, 0, 0, 0, true)</script></td>              
              	<td width="95">Inactive STS.</td>
              	<td width="120"><script language="javascript">ComComboObject('cboChgDelProcSts', 2, 96, 0, 0, 0, true)</script></td>
                <td width="95">Booking</td>
                <td width="234"><input type="text" name="bkg_no" dataformat="engup2" maxlength="" style="width:200;ime-mode:disabled;" class="input" value="">&nbsp;
                   <img src="img/btns_multisearch.gif" name="btns_multisearch1" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor" onClick="openPopup('bkg_no')">
                </td>
                <td width="50">&nbsp;</td>
                <td width="80">&nbsp;</td>
              </tr>
            </table></td>
        </tr>
      </table>
      <table class="height_5">
        <tr>
          <td></td>
        </tr>
      </table>
      <table class="search">
        <tr>
          <td class="bg"><!-- biz_1  (S) -->
            <!-- Grid  (S) -->
          		<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
	<!--  			<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>  
					</tr> -->
				</table>			
            <!-- Grid (E) --></td>
        </tr>
      </table>
      <!--biz page (E)--></td>
      
      <!--Button (S) -->
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:2;">
        <tr>
          <td class="btn1_bg"><table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_retrieve">Retrieve</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table></td>
                <td class="btn1_line"></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_new">New</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_approval">Approval</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_reject">Reject</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_excel">Down Excel</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table></td>
              </tr>
            </table></td>
        </tr>
      </table>   
      <!--Button (E) -->
      
  </tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>