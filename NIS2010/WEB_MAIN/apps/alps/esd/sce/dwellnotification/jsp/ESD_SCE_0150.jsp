<%--
/*===========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESD_SCE_0150.jsp
*@FileTitle : SCEM - Dwell/Delay Notification Sending Status
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.20
*----------------------------------------------------------
* History
============================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.net.URLEncoder"%>
<%@ page import="java.util.Calendar"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.dwellnotification.event.EsdSce0150Event" %>
<%@ page import="com.hanjin.apps.alps.esd.sce.common.util.basic.CodeUtilBCImpl" %>
<%@ page import="com.hanjin.apps.alps.esd.sce.common.util.basic.CodeUtilBC" %>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.common.AbstractValueObject"%>
<%
	EsdSce0150Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수
	
	String startDay = null; // DateTime.getFormatString("yyyy-MM-dd").substring(0,8) + "01";
	
//	Calendar calendar = Calendar.getInstance(); 
/*	System.out.print("오늘 : "); 
	System.out.print(calendar.get(Calendar.YEAR) + "년 "); 
	System.out.print(calendar.get(Calendar.MONTH) + 1 + "월 "); 
	System.out.println(calendar.get(Calendar.DATE) + "일"); 

	System.out.println("이 달의 마지막 날의 날짜 : " + calendar.getActualMaximum(Calendar.DAY_OF_MONTH)); 
*/
	String endDay = null; // = DateTime.getFormatString("yyyy-MM-dd").substring(0,8) +	 calendar.getActualMaximum(Calendar.DAY_OF_MONTH);	
	
	SignOnUserAccount account= null;
	try {
	
	   account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	
		event = (EsdSce0150Event)request.getAttribute("Event");
		
		
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
	
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
	    GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	    String cDay = eventResponse.getETCData("dflt_fm_snd_dt"); 
	    startDay = cDay.substring(0,4) + "-" + cDay.substring(4,6) + "-" + cDay.substring(6);
	    cDay = eventResponse.getETCData("dflt_to_snd_dt"); 
	    endDay = cDay.substring(0,4) + "-" + cDay.substring(4,6) + "-" + cDay.substring(6);

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<html>
<head>
<title>Dwell/Delay Notification Sending Status</title>
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

<body onLoad="setupPage();">

<form name="form" onSubmit="return false;">

<input type="hidden" name="f_cmd">


<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
  <tr>
    <td valign="top"><!--Page Title, Historical (S)-->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
      </table>
      <!--Page Title, Historical (E)-->
      <!--Button (S) -->
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:5;">
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
                      <td class="btn1" name="btn_excel" id="btn_excel">Down Excel</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_text" id="btn_text">Down Text</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table></td>
                <td class="btn1_line"></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_print" id="btn_print"> Print</td>
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
              
                <td width="41">&nbsp;Period&nbsp;(LMT)&nbsp;</td>                                
                <td width="311">
                	<input type="text" style="width:80;" name="start_dt" class="input1" value="<%=startDay%>" dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)" maxLength="10">
          			&nbsp;~&nbsp;
                    <input type="text" style="width:80;" name="end_dt" class="input1" value="<%=endDay%>" dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)" maxLength="10">
                    <img src="img/btns_calendar.gif" alt="" width="19" height="20" align="absmiddle" style="cursor:hand" onClick="callDatePop('EFF Date')"></td>
                            
                <!-- 
                <input type="text" style="width:80;" class="input1" name="start_dt" maxlength="10" dataformat="ymd" value="<%=startDay%>">
                                &nbsp;~&nbsp;          
                                <input type="text" style="width:80;" class="input1" name="end_dt" maxlength="10" dataformat="ymd" value="<%=endDay%> ">
                   <img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" onClick="callDatePop('EFF Date')"></td>
                <img onClick="openCalendar('1')" class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
                
                
                <input name ="poletdDate1" type="text" class="input" style="width:70; text-transform:uppercase;" onKeyUp="chkField(this, 'date', false, null, null, '-')" onBlur="chkField(this, 'date', false, null, null, '-')">
					&nbsp;~&nbsp;
					<input name = "poletdDate2" type="text" class="input" style="width:70; text-transform:uppercase;" onKeyUp="chkField(this, 'date', false, null, null, '-')" onBlur="chkField(this, 'date', false, null, null, '-')">
					<img onClick="openCalendar('1')" class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
				</td>  -->
                                
				<td width="84">Customer</td>
							<td width="700"><input type="text" style="width:25;" class="input" name="cust_cnt_cd" OnKeyup='focusCustSeq()' OnChange='changeCustNoText()'  dataformat="engup" maxlength="2" minlength="2">&nbsp;<input type="text" style="width:55;" class="input" name="cust_seq" OnChange='changeCustNoText()' dataformat="int" maxlength="6">&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btn_ctrt_cust" class="cursor"></td>
                <!-- <td width="70">S/C No.</td>
				<td width="400">
					<script language="javascript">ComComboObject('sc_no', 2, 80, 1);</script>&nbsp;
					<input type="text" style="width:75;text-align:left;" class="input2" name="sc_no2" onKeyPress="ComKeyOnlyNumber(this);" maxlength="17" disabled><input type="checkbox" name="SCNoFlg"  class="trans"  onClick="changeSCNoFlg()" checked>
				</td> -->	
              </tr>
            </table>
            
            <!-- 
            <table class="height_5">
              <tr>
                <td></td>
              </tr>
            </table>
            <table class="search" border="0" style="width:979;">
              <tr class="h23">
                <td width="*">&nbsp;Period : 2011.01.01 ~ 2011.01.30</td>
              </tr>
            </table>
            -->
            
            <!-- Grid  (S) -->
            <table width="100%"  id="mainTable"> 
                <tr>
                    <td width="100%">
                        <script language="javascript">ComSheetObject('sheet1');</script>
                    </td>
                </tr>

            </table>            
            <!-- Grid (E) -->  
  </tr>
</table>
<!-- Copyright (S)
<table class="copy">
  <tr>
    <td class="familysite">&nbsp;
      <select name="sitelink" id="sitelink" class="select_family" onChange="javascript:go_sitelink(this);">
        <option selected>&nbsp;&nbsp;  -- Family Site --  &nbsp;&nbsp;</option>
        <option value=""></option>
        <option value=""></option>
        <option value=""></option>
      </select></td>
    <td class="copy"><img src="img/img_bottom_logo.gif" width="460" height="16" alt="" border="0"></td>
  </tr>
</table>
  Copyright(E)-->
</form>
</body>
</html>
