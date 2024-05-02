
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.dwellnotification.event.EsdSce0151Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.common.AbstractValueObject"%>

<%
	EsdSce0151Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.DwellNotification.DwellNotification");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsdSce0151Event)request.getAttribute("Event");
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
<title><span id="title"></span></title>
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
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
  <tr>
    <td valign="top"><!--Page Title, Historical (S)-->
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->
     <!--Page Title, Historical (E)-->
      <!--Button (S) -->
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;">
        <tr>
          <td class="btn1_bg"><table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table></td>
                <td class="btn1_line"></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_new" id="btn_new">New</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table></td>
                <td class="btn1_line"></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btng_save" id="btng_save">Save</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table></td>
              </tr>
            </table></td>
        </tr>
      </table>
      <!--Button (E) -->
      <!--biz page (S)-->
      <table class="search">
        <tr>
          <td class="bg"><!-- biz_1  (S) -->
            <table class="search" border="0" style="width:979;">
              <tr class="h23">
                <td width="10">
                  <input type="radio" class="trans" name='sch_tp' value='S' checked>
                 </td>
                 <td width="84">Customer</td>
							<td width="232"><input type="text" style="width:25;" class="input" name="cust_cnt_cd" OnKeyup='focusCustSeq()' OnChange='changeCustNoText()'  dataformat="engup" maxlength="2" minlength="2">&nbsp;<input type="text" style="width:55;" class="input" name="cust_seq" OnChange='changeCustNoText()' dataformat="int" maxlength="6">&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btn_ctrt_cust" class="cursor"></td>
                 <td width="10"><p>
                    <input type="radio" class="trans" name='sch_tp' value='P'>
                   </td>
              <td width="40">Period&nbsp;</td>
               <td width="300">&nbsp;
               	<input type="text" style="width:80;" name="ctrt_exp_dt" class="input"  dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)" maxLength="10">
               	&nbsp;~&nbsp;
                            <input type="text" style="width:80;" name="ctrt_eff_dt" class="input" dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)" maxLength="10">
                            <img src="img/btns_calendar.gif" alt="" width="19" height="20" align="absmiddle" style="cursor:hand" onClick="callDatePop('EFF Date')"></td>
                            <td width="*">Exception&nbsp;<input type="checkbox" class="trans" name="f_expt_flg" value="0" onClick="changeExptFlg()"></td>
						
              </tr>
            </table>
            <table class="height_5">
              <tr>
                <td></td>
              </tr>
            </table>
            
            <!-- Grid  (S) -->
            <table width="100%" id="mainTable">
             <tr><td>
			 <script language="javascript">ComSheetObject('sheet1');</script>
			</td></tr>
           </table>
					<table width="100%" class="button">
				       	<tr>To block dwell notification completely, it is required to check both exceptions, " Dwell Notification Excption by types" and "Dwell Notification Excption from collected e-mail list in Arival Notice"<td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
						<!-- Repeat Pattern -->
						 <td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="btng_rowadd" id="btng_rowadd">Row Add</td><td class="btn2_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                           <tr>
                            <td class="btn2_left"></td>
                            <td class="btn2" name="btng_rowdelete" id="btng_rowdelete">Row Delete</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table></td>
						<!-- Repeat Pattern -->
					</tr></table>
					</td></tr>
					</table>
					<!-- Button : Sub (E) -->
      <!-- Tab BG Box(E) -->
      <!--biz page (E)--></td>
  </tr>
</table>
</body>
</html>
