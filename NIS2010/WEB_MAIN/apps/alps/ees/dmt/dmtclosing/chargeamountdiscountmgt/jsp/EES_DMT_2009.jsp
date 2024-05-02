<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_2009.jsp
*@FileTitle : DEM/DET Adjustment Request - After Booking Approval
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.21
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.07.21 이성훈
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
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.event.EesDmt2009Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt2009Event  event 	= null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg 		= "";				//에러메세지
	int rowCount	 		= 0;				//DB ResultSet 리스트의 건수
	
	String successFlag 		= "";
	String codeList  		= "";
	String pageRows  		= "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";
	String strUsr_rhq		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt");
	
	String darNo 	= request.getParameter("dar_no") 	!= null ? (String)request.getParameter("dar_no") 	: "" ;	
	String caller 	= request.getParameter("caller") 	!= null ? (String)request.getParameter("caller") 	: "" ;
	String sheetId 	= request.getParameter("sheetId") 	!= null ? (String)request.getParameter("sheetId") 	: "" ;
	
	String bodyTag	= null;
	String tableTag	= null;

	if (darNo.length() > 0 && caller.length() > 0) {
		//PopUp 화면일 경우
		bodyTag		= "<body class=\"popup_bg\" onLoad=\"setupPage();\">";
		tableTag 	= "<table width=\"100%\" class=\"popup\" cellpadding=\"5\" border=\"0\">";
	}
	else {
		//Main 화면일 경우
		bodyTag		= "<body onLoad=\"setupPage();\">";
		tableTag 	= "<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"padding-top:2;padding-left:5;\">";
	}
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id 	= account.getUsr_id();
		strUsr_nm 	= account.getUsr_nm();
		strUsr_ofc 	= account.getOfc_cd();
		strUsr_rhq 	= account.getRhq_ofc_cd();
		
		
		event = (EesDmt2009Event)request.getAttribute("Event");
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
<title>DEM/DET Adjustment Request - After Booking Approval</title>
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

<%= bodyTag %>
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="caller"  value="<%= caller %>">
<input type="hidden" name="sheetId" value="<%= sheetId %>">
<input type="hidden" name="popup_flag">
<input type="hidden" name="popup_upd_dt">
<input type="hidden" name="apvl_ofc_cd">
<input type="hidden" name="dar_no">
<input type="hidden" name="apvl_no">
<input type="hidden" name="bkg_no">
<input type="hidden" name="bl_no">
<input type="hidden" name="tariff">
<input type="hidden" name="is_cntr">
<input type="hidden" name="pod">
<input type="hidden" name="pol">
<input type="hidden" name="del">
<input type="hidden" name="por">
<!-- Charge Detail per BKG 정보 조회시 After Booking 에서 읽어올  
	 것인지 Charge Calculation 에서 읽어올 것인지를 구분해 주는 변수 -->
<input type="hidden" name="is_aft_bkg_cntr">
<!-- Request 호출시 사용되는 변수 -->
<input type="hidden" name="aft_expt_dar_no">
<input type="hidden" name="aft_expt_adj_seq">
<input type="hidden" name="dmdt_expt_rqst_sts_cd">
<input type="hidden" name="apro_ofc_cd" >
<input type="hidden" name="prog_rmk">
<!-- 서버모듈 호출 후 응답받은 결과를 임시 저장하기 위해서 사용하는 변수 -->
<input type="hidden" name="result">
<input type="hidden" name="result2">
<input type="hidden" name="result3">
<!-- Local Currency 조회를 위해 사용되는 변수 -->
<input type="hidden" name="cnt_cd">
<!-- 권한체크를 위해 사용되는 변수 -->
<input type="hidden" name="role_permit">
<input type="hidden" name="role_auth">
<input type="hidden" name="usr_id" 		value="<%= strUsr_id %>">
<input type="hidden" name="usr_role_cd" value="DMT01,DMT02,DMT03">
<input type="hidden" name="pgm_no" 		value="EES_DMT_2009">
<input type="hidden" name="usr_rhq_cd" 	value="<%= strUsr_rhq%>">
<input type="hidden" name="usr_ofc_cd" 	>
<!-- RHQ OFC CD -->
<input type="hidden" name="etc1" 		value="<%= strUsr_rhq %>">
<!-- APVL OFC CD -->
<input type="hidden" name="etc2" 		value="">
<!-- LOGIN OFC CD -->
<input type="hidden" name="etc3" 		value="<%= strUsr_ofc %>">
<!-- AFT_EXPT_DAR_NO -->
<input type="hidden" name="etc4" 		value="">
<!-- BKG_NO -->
<input type="hidden" name="etc5" 		value="">
<!-- DMDT_TRF_CD -->
<input type="hidden" name="etc6" 		value="">
<!-- 승인처리를 위해 사용되는 변수 -->
<input type="hidden" name="sc_no">
<input type="hidden" name="rfa_no">
<input type="hidden" name="cust_cd">
<input type="hidden" name="cust_nm">
<input type="hidden" name="dmdt_expt_rqst_sts_desc">
<!-- BackEndJob -->
<input type="hidden" name="job_key"> 
<!-- reason Combo -->
<input type="hidden" name="intg_cd_id">

<!-- [CHM-201433113] APVL OFC : SELHO인 경우 로그인 OFC의 OFC LEVEL '1'이 아닌경우 제한  2014.12.09 -->
<input type="hidden" name="user_ofc_lvl">

<%= tableTag %>
<tr><td class="top"></td></tr>
<tr><td valign="top">
		
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<script language="javascript">DmtComPageTitle(<%=(caller.length() > 0 ? "true" : "false")%>);</script>
		</table>
	<!--Page Title, Historical (E)-->	
	
		<table class="search"> 
		<tr>
			<td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="80">APVL Office</td>
					<td width="120"><select name="approvalOfcCd" style="width:80;" class="input1">
					<option value=""></option>
					<option value="NYCRA">NYCRA</option>
					<option value="HAMRU">HAMRU</option>
					<option value="SHARC">SHARC</option>
					<option value="SELHO">SELHO</option>
					<option value="SELIB">SELIB</option>
					<option value="TYOIB">TYOIB</option>
					<option value="SINRS">SINRS</option>
					<option value="VVOIA">VVOIA</option>
					<!-- <option value="SELHO">SELHO</option> -->
					</select></td>
					<td width="55">DAR No. </td>
					<td width="160"><input type="text" name="darNo" style="width:120;ime-mode:disabled" value="<%=darNo%>" class="input" dataformat="engup" maxlength="15"></td>
					<td width="60">APVL No.</td>
					<td width="160"><input type="text" name="apvlNo" style="width:120;ime-mode:disabled" class="input" dataformat="engup" maxlength="15"></td>
					<td width="50">Status</td>
					<td width=""><input type="text" name="status" style="width:120;" class="input2"></td>
				</tr>
				</table>
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="80">S/C No. </td>
					<td width="120"><input type="text" name="scNo" style="width:80;" class="input2"></td>
					<td width="55">RFA No.</td>
					<td width="160"><input type="text" name="rfaNo" style="width:120;" class="input2"></td>
					<td width="60">Customer</td>
					<td width=""><input type="text" name="custCd" style="width:70;" class="input2">&nbsp;<input type="text" name="custNm" style="width:256;" class="input2"></td>
				</tr>
				</table>
				
				<!--  biz_1 ( E) -->
			</td>
		</tr>
		</table>			
		
		<table class="height_8"><tr><td></td></tr></table>		
	
		<table class="search"> 
       	<tr>
       		<td class="bg">
				
			<!-- Grid  (S) -->
				<table width="100%" id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
				</table>
			<!-- Grid  (E) -->
			<!--  Button_Sub (S) -->
				<table width="100%" class="button"> 
	       		<tr>
	       			<td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0"><tr>
							<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td class="btn2_left"></td>
									<td class="btn2" name="btn_AddBkgReq">Row&nbsp;Add</td>
									<td class="btn2_right"></td>
								</tr>
								</table>
							</td>
							<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td class="btn2_left"></td>
									<td class="btn2" name="btn_DelBkgReq">Row Delete</td>
									<td class="btn2_right"></td>
								</tr>
								</table>
							</td>
						</tr>
						</table>
					</td>
				</tr>
				</table>
	    	<!-- Button_Sub (E) -->
			
				<table class="height_8"><tr><td></td></tr></table>
		
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="210" class="title_s">&nbsp;Charge Detail per BKG</td>
					<td width="70">CNTR Q'ty</td>
					<td width="70"><input type="text" name="cntrQty" style="width:40;text-align:right;" class="input2"></td>
					<td width="25">Cur.</td>
					<td width="80"><input type="text" name="curr" style="width:40;text-align:center;" class="input2"></td>
					<td width="110">Final Billable AMT</td>
					<td width="145"><input type="text" name="totalBillAmt" id="totalBillAmt" style="width:100;text-align:right;" class="input2"></td>
					<td>&nbsp;</td>
					<td width="190" align="right">
						<table width="190" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn2_left"></td>
							<td class="btn2" name="btn_PreCalc" id="btn_PreCalc" >D/C AMT or Ratio Pre Cal.</td>
							<td class="btn2_right"></td>
						</tr>
						</table>
					</td>
					<td width="74" align="right">
						<table width="74" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn2_left"></td>
							<td class="btn2" name="btn_Reset" >Reset</td>
							<td class="btn2_right"></td>
						</tr>
						</table>
					</td>
				</tr>
				</table>
		
				<!-- Grid  (S) -->
				<table width="100%" id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet2');</script>
					</td>
				</tr>
				</table>
				<!-- Grid  (E) -->
				
				<table class="height_8"><tr><td></td></tr></table>
		
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="480" valign="top">
						<table class="search" border="0">
						<tr>
							<td class="title_h"></td>
							<td class="title_s">Comment History</td>
						</tr>
						</table>
						
						<table class="height_5"><tr><td></td></tr></table>
						
						<!-- Grid  (S) -->
						<table width="100%" id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet3');</script>
							</td>
						</tr>
						</table>
						<!-- Grid  (E) -->
					</td>
					<td width="19"></td>
					<td width="480" valign="top">
						<table class="search">
							<tr class="h23"><td width="140">&nbsp;Reason for Request</td>
						    <td width="350"><script language="javascript">ComComboObject('dmdt_expt_rqst_rsn_cd',2,350,1,3,1);</script></td></tr> 
						</table>
						
						<table class="search">
						<tr class="h23">
							<td class="title_s" width="205"><input type="checkbox" name="chkComment" class="trans" onClick="checkComment()">Comment </td>
						</tr> 
						</table>
						
						<table width="100%" class="search"> 
						<tr class="h23">
							<td width="%"><textarea name="comment" dataformat="engup3" style="width:480;height:57;" class="input1"></textarea></td>
						</tr>
						</table>
					
					</td>
				</tr>
				</table>
			
			</td>
		</tr>
		</table>
		
<!-- : ( Search Options ) (E) -->
 
	</td>
</tr>
</table>
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->

<!-- : ( Button : Main ) (S) -->
<div id="btnMainLayer" style="display:none">	
<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
<tr>
	<td class="btn1_bg">
		<table border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td>
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr>
					<td class="btn1_left"></td>
					<td class="btn1_1" name="no_btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
				</tr>
				</table>
			</td>
			<td>
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr>
					<td class="btn1_left"></td>
					<td class="btn1_1" name="no_btn_New">New</td>
					<td class="btn1_right"></td>
				</tr>
				</table>
			</td>
			<td class="btn1_line"></td>
			<!-- 
			<td>
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr>
					<td class="btn1_left"></td>
					<td class="btn1_1" name="no_btn_Request">Request</td>
					<td class="btn1_right"></td>
				</tr>
				</table>
			</td> 
			-->
			<td>
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr>
					<td class="btn1_left"></td>
					<td class="btn1_1" name="no_btn_Cancel">Cancel</td>
					<td class="btn1_right"></td>
				</tr>
				</table>
			</td>
			<td>
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr>
					<td class="btn1_left"></td>
					<td class="btn1_1" name="no_btn_Approval">Approval</td>
					<td class="btn1_right"></td>
				</tr>
				</table>
			</td>
			<td>
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr>
					<td class="btn1_left"></td>
					<td class="btn1_1" name="no_btn_CounterOffer">Counter Offer</td>
					<td class="btn1_right"></td>
				</tr>
				</table>
			</td>
			<td>
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr>
					<td class="btn1_left"></td>
					<td class="btn1_1" name="no_btn_Reject">Reject</td>
					<td class="btn1_right"></td>
				</tr>
				</table>
			</td>
		</tr>
		</table>
	</td>
</tr>
</table>
</div>

<!-- : ( Button : pop ) (S) -->
<div id="btnPopUpLayer" style="display:none">
<table width="100%" class="sbutton">
<tr>
	<td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr>
       		<td class="btn3_bg">
		    	<table border="0" cellpadding="0" cellspacing="0">
		    	<tr>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1_1" name="no_btn_Retrieve" id="btn_Retrieve">Retrieve</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1_1" name="no_btn_New">New</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
					<td class="btn1_line"></td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1_1" name="no_btn_Request">Request</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1_1" name="no_btn_Cancel">Cancel</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1_1" name="no_btn_Approval">Approval</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1_1" name="no_btn_CounterOffer">Counter Offer</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1_1" name="no_btn_Reject">Reject</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
					<td class="btn1_line"></td> 
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_Close">Close</td>
							<td class="btn1_right">
						</tr>
						</table>
					</td>
				</tr>
				</table>
			</td>
		</tr>
		</table>
		
	</td>
</tr>
</table>
</div>
<!--Button (E) -->

</form>
</body>
</html>