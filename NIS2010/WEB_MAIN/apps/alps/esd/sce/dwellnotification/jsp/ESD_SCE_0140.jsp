<%--
/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESD_SCE_0140.jsp
*@FileTitle : SCEM - Dwell Status Inquiry by Dwell Type
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.06
*@LastModifier : 손은주
*@LastVersion : 1.3
* 2011.07.06 손은주
* 1.0 최초 생성
*----------------------------------------------------------
* History

=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.net.URLEncoder"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.dwellnotification.event.EsdSce0140Event" %>
<%@ page import="com.hanjin.apps.alps.esd.sce.dwellnotification.vo.SearchDwellVO" %>
<%@ page import="com.hanjin.apps.alps.esd.sce.common.util.basic.CodeUtilBCImpl" %>
<%@ page import="com.hanjin.apps.alps.esd.sce.common.util.basic.CodeUtilBC" %>
<%@ page import="org.apache.log4j.Logger" %>
<%
EsdSce0140Event  event = null;				//PDTO(Data Transfer Object including Parameters)
Exception serverException   = null;			//서버에서 발생한 에러
String strErrMsg = "";								 //에러메세지
int rowCount	 = 0;								  //DB ResultSet 리스트의 건수
String dwll_tm_tp_cd = "";
//String currentDay = DateTime.addDays(DateTime.getFormatString("yyyy-MM-dd"), -1);

String currentDay = null;
SignOnUserAccount account= null;
try {

   account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

	event = (EsdSce0140Event)request.getAttribute("Event");
	SearchDwellVO searchDwellVO = event.getSearchDwellVO();
	if( searchDwellVO != null ) dwll_tm_tp_cd = searchDwellVO.getDwllTmTpCd();
	serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

    if (serverException != null) {
		strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
	}

    // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
    GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
    String cDay = eventResponse.getETCData("dflt_eml_snd_dt"); 
    currentDay = cDay.substring(0,4) + "-" + cDay.substring(4,6) + "-" + cDay.substring(6);

}catch(Exception e) {
	out.println(e.toString());
}
%>
<html>
<head>
<title>SCEM - Dwell Status Inquiry by Dwell Type</title>
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
<input type="hidden" name="t_cntr_no">
<input type="hidden" name="t_cntr_tpsz_cd">
<input type="hidden" name="dwll_tm_tp_cd" value="<%=dwll_tm_tp_cd%>">
<input type="hidden" name="t1_load_flg" value="N">
<input type="hidden" name="t2_load_flg" value="N">
<input type="hidden" name="t3_load_flg" value="N">
<input type="hidden" name="t4_load_flg" value="N">
<input type="hidden" name="btn_action" value="">
<input type="hidden" name="new_target_flag_hidden" value=''>
<input type="hidden" name="cust_cd">
<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>
	<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->
	
	<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr><td class="btn1_bg">

						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new">New</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_clm" id="btn_clm">CLM</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_cntrhis" id="btn_cntrhis">CNTR History</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_excel" id="btn_excel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_text" id="btn_text">Down Text</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_print" id="btn_print">Print</td><td class="btn1_right"></td></tr></table></td>
							<!-- Repeat Pattern -->

						</tr></table>

				</td></tr>
		</table>
		<!-- TABLE '#D' : ( Button : Main ) (E) -->

      <!-- TABLE '#D' : ( Search Options ) (S) -->
      <!--biz page (S)-->
      <table class="search">
        <tr>
          <td class="bg"><!-- biz_1  (S) -->
            <table class="search_in" border="0">
              <tr class="h23">
                <td width="80">Date (LMT)</td>
                <td width="120"><input type="text" caption="Date (LMT)" required="true" style="width:75;text-align:left;" class="input1" name="search_dt" minlength="8" maxlength="10" dataformat="ymd" value="<%=currentDay %>"><img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btns_calendar"></td>
                <!--  td width="70">S/C No.</td>
				<td width="160"><input id="sc_no" name="sc_no" type="text" style="width:123; " value="">&nbsp;<img name="btn_scpopup" class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td-->
				<td width="100">Contract Office</td>
				<td width="140"> <input type="text" name="ctrt_ofc_cd" style="width:84;text-align:center;ime-mode:disabled" class="input" dataformat="engup" maxLength="6"> <img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="ComOpenPopupWithTarget"></td>
				<td width="70">S/C No.</td>
				<td width="200">
					<script language="javascript">ComComboObject('sc_no', 2, 80, 0, 1, 0, false);</script>&nbsp;<input type="text" style="width:75;text-align:left;ime-mode:disabled;" class="input2" name="sc_no2" maxlength="17"><input type="checkbox" name="SCNoFlg"  class="trans"  onClick="changeSCNoFlg()" checked>	
				</td>
				<td width="84">Customer</td>
				<td width="140"><input type="text" style="width:25;" class="input" name="cust_cnt_cd" OnKeyup='focusCustSeq()' OnChange='changeCustNoText()'  maxlength="2" minlength="2"> <input type="text" style="width:55;" class="input" name="cust_seq" OnChange='changeCustNoText()'  maxlength="6"> <img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btn_ctrt_cust" class="cursor"></td>
		        </tr>
               </table> 
               
               <table class="search_in" border="0">		
              
               <tr class="h23">
               	<td width="40">POD</td>
				<!--  POD 멀티체크박스&&& -->
				<td width="100"><input name="pod_cd" caption="POD" type="text" class="input" style="width:60 ;ime-mode:disabled;" minlength="2" maxlength="5">&nbsp;<!-- img onClick="openLocPopUp(true,'pod_cd')" class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"--></td>
				
                <td width="40">DEL</td>
                <td width="100"><input name="del_cd" caption="DEL" type="text" style="width:60;ime-mode:disabled; " class="input" minlength="2" maxlength="5"></td>
               
               	<td width="40">VVD</td>
				<td width="100"><input name="vvd" caption="VVD" type="text" style="width:70; text-align:left;ime-mode:disabled; " maxlength="9">&nbsp;<!-- img onClick="openVVDPopUp(true)" class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"--></td>
				
                <td width="70">Rail Dest</td>
                <td width="100"><input name="rail_dest" caption="Rail Dest" type="text" style="width:80;ime-mode:disabled; " class="input" minlength="2" maxlength="7"></td>
                <td width="50">Mode</td>
                <td width="120"><select name="rail_so_flg" style="width:80;" class="input">
                    <option value="" selected>All</option>
                    <option value="N">Port Local</option>
                    <option value="Y">Rail</option>
                  </select></td>
                <td width="60">BKG NO</td>
                <td width="140"><input name="bkg_no" caption="BKG NO" type="text" style="width:98;ime-mode:disabled; " class="input" value="" maxlength="13"></td>
                
                 </tr>
               </table> 
               
               <table class="search_in" border="0">	
               <tr class="h23">
                <td width="40">BL NO</td>
                <td width="100"><input name="bl_no" caption="BL NO" type="text" style="width:100;ime-mode:disabled; " class="input" value="" maxlength="12"></td>
                <td width="60">CNTR NO</td>
                <td width="100"><input name="cntr_no" caption="CNTR NO" type="text" style="width:98;ime-mode:disabled; " class="input" value="" maxlength="11"></td>
                <td width="40">Sent</td>
                <td width="92"><select name="sent" style="width:80;" class="input">
                    <option value="" selected>All</option>
                    <option value="Y">Yes</option>
                    <option value="N">No</option>
                  </select></td>
                <td width="300"></td> 
              </tr>
            </table></td>
        </tr>
      </table>
      
      <table class="height_10"><tr><td></td></tr></table>
      
      <!-- TABLE '#D' : ( Tab ) (S) -->
     	<table class="tab" border="0" cellpadding="0" cellspacing="0" width="100%"> 
     		<tr><td width="100%">
			<script language="javascript">ComTabObject('tab1')</script>
			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Tab ) (E) -->
		
		<div id="tabLayer" style="display:inline">
			<iframe name="t1frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="400" src="about:blank"  ></iframe>
        </div>

        <div id="tabLayer" style="display:inline">
			<iframe name="t2frame" id="t2frame" frameborder="0" scrolling="no" width="100%" height="400" src="about:blank" ></iframe>
		</div>

        <div id="tabLayer" style="display:none">
			<iframe name="t3frame" id="t3frame" frameborder="0" scrolling="no" width="100%" height="400" src="about:blank" ></iframe>
		</div>
        <div id="tabLayer" style="display:none">
			<iframe name="t4frame" id="t4frame" frameborder="0" scrolling="no" width="100%" height="400" src="about:blank" ></iframe>
		</div>
		
      <!--biz page (E)--></td>
  </tr>
</table>
<!--Sheet (S) -->
<table width="98%" height="0" id="mainTable">
	<tr>
		<td width="98%"><script language="javascript">ComSheetObject("sheet1");</script>
		</td>
	</tr>
</table>
   <table width="98%" border=0 cellpadding=0 cellspacing=0 style="align: left">
	   <tr>
	      <td width=98%><font size="2.9"> * The columns having same number are for same customer : (1) S/C Customer (2) Consignee (3)Notify </font>
	      </td>
	   </tr>
	  </table>
<!--Sheet (E) -->
</form>
</body>
</html>

