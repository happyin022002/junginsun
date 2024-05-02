<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_2005.jsp
*@FileTitle : DEM/DET Adjustment Request - Before Booking Approval
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.12
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.06.12 이성훈
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
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.event.EesDmt2005Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt2005Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag 	= "";
	String codeList  	= "";
	String pageRows  	= "100";

	String strUsr_id	= "";
	String strUsr_nm	= "";
	String strOfc_cd	= "";
	String strUsr_rhq 	= "";

	Logger log = Logger.getLogger("com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt");
	
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
		strUsr_id 	  	= account.getUsr_id();
		strUsr_nm 	  	= account.getUsr_nm();
		strOfc_cd 	  	= account.getOfc_cd();
		strUsr_rhq 		= account.getRhq_ofc_cd();
		
		// 사용자가 '1010100' 인 경우 RHQ OFC 는 HAMRU 이다. 2015.08.27
		//if ("1010100".equals(strUsr_id)) strUsr_rhq = "HAMRU";
	   
		event = (EesDmt2005Event)request.getAttribute("Event");
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
<title>DEM/DET Adjustment Request - Before Booking Approval</title>
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
<input type="hidden" name="caller" 	value="<%= caller %>">
<input type="hidden" name="sheetId" value="<%= sheetId %>">
<input type="hidden" name="popup_flag">
<input type="hidden" name="popup_upd_dt">
<input type="hidden" name="prop_no">
<input type="hidden" name="cust_seq">
<input type="hidden" name="cust_cnt_cd">
<input type="hidden" name="rfa_expt_dar_no">
<input type="hidden" name="rfa_expt_mapg_seq">
<input type="hidden" name="rfa_expt_ver_seq">
<input type="hidden" name="rfa_rqst_dtl_seq">
<input type="hidden" name="rfa_expt_apro_no">
<input type="hidden" name="apro_ofc_cd">
<!-- Comment History 를 저장하기 위한 매개변수  -->
<input type="hidden" name="prog_seq">
<input type="hidden" name="prog_rmk">
<!-- CNTR/Cargo Type 공통코드를 불러오기 위한 매개변수 -->
<input type="hidden" name="code1" value="CD02053">
<input type="hidden" name="code2" value="CD01963">
<!-- Common 인지 Rep Commodity 인지를 구분해서 조회하기 위한  매개변수 -->
<input type="hidden" name="prc_cmdt_tp_cd">
<input type="hidden" name="dmdt_expt_rqst_sts_cd">
<input type="hidden" name="dmdt_expt_rqst_sts_desc">
<input type="hidden" name="conti_cd">
<input type="hidden" name="cnt_cd">
<input type="hidden" name="rgn_cd">
<input type="hidden" name="ste_cd">
<input type="hidden" name="loc_cd">
<!-- BKG POR(O) or DEL(I) 에 입력된 CN 의 Continent 와 Coverage 의 Continent 와 비교를 위한 매개변수  -->
<input type="hidden" name="fnl_dest_cnt_cd">
<input type="hidden" name="pagerows">
<!-- 버튼 권한 체크를 위해서 사용하는 매개변수 -->
<input type="hidden" name="role_permit">
<input type="hidden" name="role_auth">
<input type="hidden" name="usr_id" 		value="<%= strUsr_id %>">
<input type="hidden" name="usr_role_cd" value="DMT01,DMT05">
<input type="hidden" name="pgm_no" 		value="EES_DMT_2005">
<input type="hidden" name="ofc_cd" >
<input type="hidden" name="rhq_ofc_cd" 	value="<%= strUsr_rhq %>">
<!-- Calculation Type Check 를 위한 매개변수  -->
<input type="hidden" name="chk_calc_tp_in">
<input type="hidden" name="dmdt_ctrt_expt_tp_cd" value="B">
<input type="hidden" name="chk_calc_tp_combined">
<input type="hidden" name="result">
<input type="hidden" name="result_cnt">
<input type="hidden" name="result_ste">
<input type="hidden" name="result_rgn">
<input type="hidden" name="result_loc">
<!-- Approval, Counter Offer, Reject 시 메일을 전송하기 위해서 사용되는 매개변수 -->
<input type="hidden" name="rfa_no">
<input type="hidden" name="cust_cd">
<input type="hidden" name="cust_nm">
<!-- 중복 체크 위하여 -->
<input type="hidden" name="max_ver_status">
<input type="hidden" name="max_ver">
<input type="hidden" name="sheet1_cnt">
<input type="hidden" name="sheet2_cnt">
<input type="hidden" name="sheet3_cnt">

<%= tableTag %>
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<script language="javascript">DmtComPageTitle(<%=(caller.length() > 0 ? "true" : "false")%>);</script>
		</table>
	<!--Page Title, Historical (E)-->	
		
		<table class="search"> 
       		<tr><td class="bg">
			
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="60">RFA No.</td>
					<td width="110"><input type="text" name="rFANo" style="width:90;" class="input2"></td>
					<td width="80">Proposal No.</td>
					<td width="140"><input type="text" name="proposalNo" style="width:94;" class="input2">&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" onClick="openWinSearchRFA()"></td>
					<td width="110">DAR History&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" onClick="openWinSearchDARHistory()"></a></td>
					<td width="63">Customer</td>
					<td width=""><input type="text" name="custCd" style="width:70;" class="input2">&nbsp;<input type="text" name="custNm" style="width:250;" class="input2"></td>
					<td id="tdBtnAffiliate" align="right" width"80">
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn2_left"></td>
							<td class="btn2" name="btn_Affiliate">Affiliate</td>
							<td class="btn2_right"></td>
						</tr>
						</table>
					</td>
				</tr> 
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="60">APVL OFC</td>
					<td width="110"><input type="text" name="approvalOfcCd" style="width:90;" class="input2"></td>
					<td width="80">DAR No.</td>
					<td width="140"><input type="text" name="darNo" style="width:120;ime-mode:disabled" value="<%=darNo%>" class="input2" dataformat="engup" maxlength="15"></td>
					<td width="47">Version</td>
					<td width="65"><select name="version" style="width:50;" class="input" onChange="checkRFAByVersion()"></select></td>
					<td width="61">APVL No.</td>
					<td width="170"><input type="text" name="approvalNo" style="width:120;ime-mode:disabled" class="input2" dataformat="engup"></td>
					<td width="45">Status</td>
					<td width=""><input type="text" name="status" style="width:109;" class="input2"></td>				
				</tr> 
				</table>
			<!--  biz_1  (E) -->
				<!--  biz_2  (S) -->
				
				<!-- Grid  (S) -->
					<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
			<!-- Grid  (E) -->
				
				<!--  biz_2  (E) -->
			<table class="height_8"><tr><td></td></tr></table>
				<!--  biz_3  (S) -->
		
				<!--  biz_4  (S) -->
						
				<!--  biz_5  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="380" valign="top">
					<!--  biz_5_1  (S) -->
						<table class="search">
							<tr class="h23"><td class="title_s" width="205"><input type="checkbox" name="chkMultiOrgDest" class="trans">Multi Origin or Destination</td>
							</tr> 
						</table>
						<table class="search" border="0" style="width:380;"> 
							<tr class="h23">
								<td>
									<!--grid  (S)-->
									<table width="100%"  id="mainTable"> 
										<tr>
											<td width="100%">
												<script language="javascript">ComSheetObject('sheet2');</script>
											</td>
										</tr>
									</table>
									<!--grid  (E)-->
								</td>
							</tr> 
						</table>
					
					<!--  biz_5_1  (E) -->
					<!--  biz_5_1  (E) -->
					</td>
					<td width="19">&nbsp;&nbsp;&nbsp;</td>
					<td width="580" valign="top">
					<!--  biz_5_2  (S) -->
						<table class="search">
							<tr class="h23"><td class="title_s" width="205"><input type="checkbox" name="chkRateAdjustment" class="trans">Rate Adjustment</td>
								<td>
									<table class="search" border="0">
										<tr class="h23">
											<td width="60">Currency</td>
											<td width=""><input type="text" name="currency" style="width:70;" class="input2"></td>
										</tr> 
									</table>
								</td>
								
							</tr> 
						</table>
						<table class="search" border="0" style="width:100%;"> 
							<tr class="h23">
								<td>
									<!--grid  (S)-->
									<table width="100%"  id="mainTable"> 
										<tr>
											<td width="100%">
												<script language="javascript">ComSheetObject('sheet3');</script>
											</td>
										</tr>
									</table>
									<!--grid  (E)-->
								</td>
							</tr> 
						</table>
					<!--  biz_5_2  (E) -->
					
					</td>
					</tr> 
				</table>
				
				
				<!--  biz_5  (E) -->
				<table class="height_8"><tr><td></td></tr></table>		
				<!--  biz_6  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="599" valign="top">
						<!--  biz_6_1  (S) -->
						<table class="search" border="0">
						<tr height="28">
							<td class="title_h"></td>
							<td class="title_s">Comment History</td>
						</tr>
						</table>
						<!--grid  (S)-->
						<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet4');</script>
							</td>
						</tr>
						</table>
						<!--grid  (E)-->
					
						<!--  biz_6_1  (E) -->
					</td>
					<td width="19">&nbsp;&nbsp;&nbsp;</td>
					<td width="480" valign="top">
						<!--  biz_6_2  (S) -->
						<table class="search">
						<tr class="h23">
							<td class="title_s"><input type="checkbox" name="chkComment" class="trans" onClick="checkComment()">Comment </td>
						</tr>
						</table>						
						<table class="grid2" border="0" width="480">
						<tr>
							<td align="center"><textarea name="comment" dataformat="engup3" style="width:100%;height:60;" class="textarea1"></textarea></td>
						</tr>								
						</table>
					<!--  biz_6_2  (E) -->
					</td>
				</tr> 
				</table>
				<!--  biz_6  (E) -->
			</td>
		</tr>
		</table>	
	</td>
</tr>
</table>

	
<!-- : ( Search Options ) (E) -->
</td></tr>
</table> 

<!-- : ( Button : Main ) (S) -->
<div id="btnMainLayer" style="display:none">
<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"> 
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
							<td class="btn1_right"></td>
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

<!-- : ( Button : pop ) (S) -->
<div id="btnCloseLayer" style="display:none">
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
							<td class="btn1" name="btn_Close">Close</td>
							<td class="btn1_right"></td>
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
