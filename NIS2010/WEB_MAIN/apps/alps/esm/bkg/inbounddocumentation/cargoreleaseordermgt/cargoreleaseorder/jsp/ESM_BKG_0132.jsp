<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0132.jsp
*@FileTitle : Cargo Release Order_E-D/O inquiry _Main
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.16
*@LastModifier : 안진응
*@LastVersion : 1.0
* 2009.05.19 안진응
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0132Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0132Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.InboundBLMgtSC.FullReleaseOrderBC");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmBkg0132Event)request.getAttribute("Event");
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
<title>INQUIRY OF eDO</title>
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

<body onLoad="setupPage();" onKeyDown="enterKeySearch();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
  

<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp"%>

	
	
		<!--Button (S) -->
		
    	<!--Button (E) -->
		
		<!--biz page (S)-->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_self">자가운송승인</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_boseApproval">보세운송승인</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				
			</tr>
			</table>
		</td></tr>
		</table>
		
		
<table class="search" id="mainTable"> 
    <tr><td class="bg">	
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="100">Request Date</td>
				<td width="215"><input type="text" name="edo_rqst_dt_s" style="width:80;" class="input1" value="" caption="Request Date(From)" maxlength="8" dataformat="ymd">&nbsp;~&nbsp;<input type="text" name="edo_rqst_dt_e" style="width:80;" class="input1" value="" caption="Request Date(To)" maxlength="8" dataformat="ymd">&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="btns_calendar2" width="19" height="20" border="0" align="absmiddle"></td>
				<td width="125">Handling Office</td>
				<td width="110"><input type="text" name="hndl_ofc_cd" style="width:60;" class="input" value="" maxlength="6" dataformat="engup" style="ime-mode:disabled"></td>
				<td width="55">접수지</td>
				<td width="80"><input type="text" name="edo_rct_loc_cd" style="width:60;" class="input" value="<%=JSPUtil.getNull(request.getParameter("edo_rct_loc_cd"))%>" maxlength="5" dataformat="eng" style="ime-mode:disabled"></td>
				<td width="90">POD</td>
				<td width="85"><input type="text" name="pod_cd" style="width:50;" class="input" value="" maxlength="5" dataformat="eng" style="ime-mode:disabled"></td>
				<td width="87">DEL</td>
				<td width=""><input type="text" name="del_cd" style="width:50;" class="input" value="" maxlength="5" dataformat="eng" style="ime-mode:disabled"></td>
				
			</tr>
			<tr class="h23">
				<td width="">B/L No</td>
				<td width=""><input type="text" name="bl_no" style="width:103;" class="input" value="" maxlength="12" dataformat="eng" style="ime-mode:disabled"></td>
				<td width="">Vessel Name</td>
				<td width="" colspan="3"><input type="text" name="vsl_nm" style="width:180;" class="input" value="" maxlength="50" dataformat="eng" style="ime-mode:disabled"></td>
				
				<td>Vessel Code</td>
				<td width=""><input type="text" style="width:53;" class="input" name="vsl_cd" caption="Vessel Code"  value="" maxlength="4" size="4" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum');"> </td>
			    <td width="87">Doc. Type</td>
				<td width=""><select style="width:90;" name="edo_tp_cd">				
						<option value="5JN" selected>D/O 발급</option>
						<option value="5JM">자가요청</option>
						<option value="5JK">보운동의</option>
						</select></td>
			</tr>
			<tr class="h23">
				<td width="">Consignee</td>
				<td width=""><input type="text" name="cn_nm" style="width:200;" class="input" value="" maxlength="500"></td>
				<td width=""> D/O No.</td>
				<td width="" ><input type="text" name="do_no" style="width:90;" class="input" value="" maxlength="12" dataformat="eng" style="ime-mode:disabled"></td>
			
			   <td width=""  >Delete</td>
				<td width=""><select style="width:51;" name="delt_flg">
						<option value="N" selected>N</option>
						<option value="Y">Y</option>
						</select></td>
			    <td width="">Handing Sts</td>
				<td width="" colspan=""><select style="width:90;" name="edo_ack_cd">
						<option value="Z" selected>All</option>
						<option value="Q">R-Request</option>
						<option value="A">A-Approval</option>
						<option value="R">X-Reject</option>
						<option value="P">P-Pending</option>
						<option value="E">E-Error</option>
						</select></td>
				<td width="">Cargo Type</td>
				<td width="" ><select style="width:75;" name="cntr_tp_cd">
						<option value="Z" selected>All</option>
						<option value="R">Reefer</option>
						<option value="O">Other</option>
						</select></td>
			</tr>
			
			</table> 
			
				</td></tr>
		</table>
		<!--biz page (E)-->
			
		<!-- Tab (S) -->
     	
		<!-- Tab (E) -->
		
		<!--biz page (S)-->
		<table class="height_8"><tr><td></td></tr></table>
		
<table class="search" id="mainTable"> 
    <tr><td class="bg">	

				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
							<script language="javascript">ComSheetObject('sheet2');</script>
							<script language="javascript">ComSheetObject('sheet3');</script>
						</td>
					</tr>
				</table>			
			<!-- Grid (E) -->
				
		
			<!--  Button_Sub (S) -->
			
	    	<!-- Button_Sub (E) -->
			
			
			</td></tr>
		</table>
		<!--biz page (E)-->	

<!--Button (S) -->
		
    <!--Button (E) -->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_delete">Delete</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_cargo">Cargo Release</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_do">D/O 신청 명세</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_jaga">자가 운송 명세</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve2">자가 운송 D/L</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_bose">보세 운송 명세</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_check">Check Error</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
		</table>
	
<input type='hidden' name ='frm_sheet2_edo_rqst_no'>
<input type='hidden' name ='frm_sheet2_edo_tp_cd'>
<input type='hidden' name='autoSearchFlg' value ="<%=JSPUtil.getNull(request.getParameter("autoSearchFlg"))%>">
<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_CLOSE.jsp"%>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>