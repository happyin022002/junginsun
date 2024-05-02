<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0607.jsp
*@FileTitle : Harmonized Tariff Code(HT Code 조회 화면)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.08
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.05.08 김기종
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg0607Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0607Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String hamo_tp_cd		= "";
	String hamo_trf_cd		= "";
	String hamo_cd_desc		= "";
	String calllFunc 		= "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.BookingMasterData.BookingMasterMgt");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmBkg0607Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		hamo_tp_cd =  JSPUtil.getNull(JSPUtil.getParameter(request, "hamo_tp_cd"),"T");
		hamo_trf_cd =  JSPUtil.getParameter(request, "hamo_trf_cd");
		hamo_cd_desc =  JSPUtil.getParameter(request, "hamo_cd_desc");
		
		calllFunc  = JSPUtil.getParameter(request, "func");
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Harmonized Tariff Code(HTS code)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
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
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="calllFunc" value="<%=calllFunc%>">
<input type="hidden" name="sel_hamo_tp_cd" value="<%=hamo_tp_cd%>">
<!-- 개발자 작업	-->

	<!-- : ( Title ) (S) -->
		 <%@include file="../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TITLE.jsp"%>
		<!-- : ( Title ) (E) -->
	
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="104">Code Type</td>
					<td width="150">
						<script language="javascript">ComComboObject('hamo_tp_cd', 2, 60, 0,0,0);</script>
					</td>
					<td width="124"><span id="cd_title">HTS</span> Code</td>
					<td width="120"><input type="text" name="hamo_trf_cd" style="width:96;" class="input" value="<%=hamo_trf_cd%>" style="ime-mode:disabled" dataformat="int" caption="Harmonized Tariff Code" maxlength="10"></td>
					<td width="" colspan=2></td>
				</tr>
				<tr class="h23">
					<td width="104">Description</td>
					<td width="" colspan="3">
					<input type="text" name="hamo_cd_desc" style="width:370" class="input" value="<%=hamo_cd_desc%>" style="ime-mode:disabled" dataformat="engupspace"  caption="Description">
					</td>
					<td width="" colspan=2></td>
				</tr>
				<tr class="h23">
					<td width="104">Category</td>
					<td width="">
						<input type="text" name="hamo_cate_ctnt" style="width:100;" class="input" value="" style="ime-mode:disabled" caption="Category" maxlength="50">
					</td>
					<td width="">FDA P/N</td>
					<td width="">
						<select name="fda_decl_flg" style="width:60;">
							<option value="" selected>ALL</option>
							<option value="Y">Y</option>
							<option value="N">N</option>
						</select>
					</td>			
					<td width="150">Including Deleted Code</td>
						<td width=""><input type="checkbox" name="delt_flg" class="trans" ></td>
					<td width=""></td>
		
				</tr>
				</table>
		<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable">
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
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
				    <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_add">Row&nbsp;Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_del">Row&nbsp;Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				    
				    <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_confirm">Select</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_confirm_6digit">Select 6 Digit</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
							
					
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			
				</td></tr>
			</table>
	<!-- Grid BG Box  (S) -->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				<td class="btn1_line"></td>
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DownExcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td></tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	<!--biz page (E)-->
	
	
			</td></tr>
	</table>
	

<%@include file="../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_CLOSE.jsp"%>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp"%>