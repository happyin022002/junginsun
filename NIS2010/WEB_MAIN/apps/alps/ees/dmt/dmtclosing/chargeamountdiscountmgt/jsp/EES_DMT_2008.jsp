<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_2008.jsp
*@FileTitle : DEM/DET Adjustment Request - After Booking Request
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
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.event.EesDmt2008Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt2008Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();
		
		event = (EesDmt2008Event)request.getAttribute("Event");
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
<title>DEM/DET Adjustment Request - After Booking Request</title>
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
<input type="hidden" name="apro_ofc_cd">
<input type="hidden" name="prog_rmk">
<!-- 서버모듈 호출 후 응답받은 결과를 임시 저장하기 위해서 사용하는 변수 -->
<input type="hidden" name="result">
<input type="hidden" name="result2">
<input type="hidden" name="result3">
<!-- Local Currency 조회를 위해 사용되는 변수 -->
<input type="hidden" name="cnt_cd">
<input type="hidden" name="usr_ofc_cd" value="<%= strUsr_ofc %>">
<!-- PreCalc -->
<input type="hidden" name="preCalcFlg">
<input type="hidden" name="freeTimeFlg">
<input type="hidden" name="intg_cd_id">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->
	
	<table class="search"> 
       		<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="80">APVL Office</td>
						<td width="130"><select name="approvalOfcCd" style="width:80;" class="input1">
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
						<td width="160"><input type="text" name="darNo" style="width:120;ime-mode:disabled" class="input" dataformat="engup" maxlength="15"></td>
						<td width="60">APVL No.</td>
						<td width="160"><input type="text" name="apvlNo" style="width:120;;ime-mode:disabled" class="input" dataformat="engup" maxlength="15"></td>
						<td width="50">Status</td>
						<td width=""><input type="text" name="status" style="width:120;" class="input2"></td>
					</tr>
				</table>
				
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="80">S/C No. </td>
						<td width="130"><input type="text" name="scNo" style="width:80;" class="input2"></td>
						<td width="55">RFA No.</td>
						<td width="160"><input type="text" name="rfaNo" style="width:120;" class="input2"></td>
						<td width="60">Customer</td>
						<td width=""><input type="text" name="custCd" style="width:70;" class="input2">&nbsp;<input type="text" name="custNm" style="width:256;" class="input2"></td>
					</tr>
				</table>
				
				<!--  biz_1 ( E) -->
		</td></tr>
	</table>			
		
	<table class="height_8"><tr><td></td></tr></table>		
	
	<table class="search"> 
       		<tr><td class="bg">
				
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
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_AddBkgReq">Row&nbsp;Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_DelBkgReq">Row Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
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
						<td width="190"><table width="190" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td>
											<td class="btn2" name="btn_PreCalc" id="btn_PreCalc">D/C AMT or Ratio Pre Cal.</td>
											<td class="btn2_right"></td>
											</tr>
											</table></td>
						<td width="74"><table width="74" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td>
											<td class="btn2" name="btn_Reset">Reset</td>
											<td class="btn2_right"></td>
											</tr>
											</table></td>
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
							<tr><td class="title_h"></td>
								<td class="title_s">Comment History</td></tr>
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
						    <td width="350"><script language="javascript">ComComboObject('dmdt_expt_rqst_rsn_cd',2,350,1,1,1);</script></td></tr> 
						</table>
						<table class="search">
							<tr class="h23"><td class="title_s" width="205"><input type="checkbox" name="chkComment" class="trans" onClick="checkComment()">Comment </td>
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
			
			
				
					
			</td></tr>
		</table>
		
<!-- : ( Search Options ) (E) -->
 
			
			
					
					
			
			</td></tr>
		</table>
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<!-- 
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Request">Request</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				 -->
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Cancel">Cancel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
		</table></td>
			</tr>
		</table>
    <!--Button (E) -->
	</td></tr>
</table>
	</td></tr>
</table>

</form>
</body>
</html>