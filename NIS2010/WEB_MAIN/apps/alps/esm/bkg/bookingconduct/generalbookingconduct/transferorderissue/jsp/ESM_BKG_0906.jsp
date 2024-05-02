<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0906.jsp
*@FileTitle : TRO-Confirm
*Open Issues : ESM_BKG_0079_02C 화면의 TRO - Confirm 팝업 
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.07.02 이남경
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.event.EsmBkg0906Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0906Event  event = null;			    //PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
/*	
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
*/

	Logger log = Logger.getLogger("com.hanjin.apps.GeneralBookingConduct.TransferOrderIssue");
	
	try {	
/* 		
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   */ 
	
		event = (EsmBkg0906Event)request.getAttribute("Event");		
	   
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");


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
<title>TRO-Confirm</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		}
		loadPage();
	}
</script>
</head>

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="io_bnd_cd"   value="">
<input type="hidden" name="cct_ofc_cd"  value="">
<input type="hidden" name="loc_cfm_cd"  value="">
<input type="hidden" name="cntr_tpsz_cd"  value="">
<input type="hidden" name="optm_flag"  value="Y">
<input type="hidden" name="bse_port_loc_cd"  value="">
<input type="hidden" name="pnt_loc_cd"  value="">
<input type="hidden" name="rf_flag"  value="">
<input type="hidden" name="awk_flag"  value="">
<input type="hidden" name="dg_flag"  value="">
<input type="hidden" name="trsp_chg_flg"  value="">
<input type="hidden" name="trsp_mode_cd"  value="">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;TRO Confirm</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
			
				<!--  biz_1 (S) -->
				<table class="search" border="0" style="width:100%;"> 
					<tr class="h23">
						<td width="80">Booking No.</td>
						<td width=""><input type="text" name="bkg_no" style="width:100;" class="input2" value="" readonly></td>
					</tr>
				</table>
				<!--  biz_1   (E) -->	
				
				<div name="div_inbound" id="div_inbound" style="disply:none">
					<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>				
					<table width="500" class="search_sm"> 				
						<tr>
							<td width="90"><input  type="radio" name="rdo_cct_ofc_cd" class="trans">&nbsp;TRO&nbsp;&nbsp;</td>
							<td width="100"><input type="text"  name="cre_ofc_cd"     value="" class="input2" maxlength="6" style="width:50;"></td>
							<td width="110"><input type="radio" name="rdo_cct_ofc_cd" class="trans">&nbsp;CCT at B/L&nbsp;&nbsp;</td>
							<td width="220"><input type="text"  name="clt_ofc_cd"     value="" class="input" maxlength="6" dataformat="engup" style="width:50;"></td>
						</tr>
						<tr>
							<td width="90">&nbsp;Actual Payer</td>
							<td colspan="3">
							    <input type="text" name="payer_cnt_cd"  style="width:40;"  class="input"  maxlength="2"  dataformat="engup">
							    <input type="text" name="payer_seq"     style="width:60;"  class="input"  maxlength="6"  dataformat="int">
							    <input type="text" name="payer_nm"      style="width:270;" class="input2"  maxlength="50" dataformat="uppernum"></td>
						</tr>
					</table>
					<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				</div>
				
						
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) -->	
				
				<!--  biz_2 (S) -->
				<table width="100%" class="search_sm"> 	
					<tr>
						<td width="94">Selection Range</td>
						<!-- td width="90"-->
						<td width=""><input type="text" name="chk_range_1" style="width:30;" class="input" value="">&nbsp;~&nbsp; 
						             <input type="text" name="chk_range_2" style="width:30;" class="input" value=""></td>
			            <!-- td width=""><table width="67" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_chkRange">Check</td>
								<td class="btn1_right"></td>
							</tr></table></td-->
					</tr>
				</table>
				<!--  biz_2   (E) -->	
				
			</td></tr>
		</table>
		<!--biz page (E)--> 
<table class="height_5"><tr><td></td></tr></table>
</td></tr></table>

	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

    	<!--Button (S) -->	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Confirm">Confirm</td>
					<td class="btn1_right"></td>
				</tr></table></td>
			<td class="btn1_line"></td>		
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right"></td>
				</tr></table></td>
			</tr>
		</table></td>
			</tr>
		</table>
    	<!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>

<SCRIPT LANGUAGE="javascript">
<!--
      /* 
       * 유저가 입력한 정보를 event를 통해서 다시 넘겨받아 화면에 뿌려주는 부분
       */
      with(document.form)
      {
        <%
        if(event != null){ 
            String bkgNo   = event.getBkgNo();
            String ioBndCd = event.getIoBndCd();
        %>    
            eval("bkg_no").value    = "<%=bkgNo%>";
            eval("io_bnd_cd").value = "<%=ioBndCd%>";
        <% } %>
       }
-->
</SCRIPT>
<%@include file="/bizcommon/include/common_alps.jsp"%>
