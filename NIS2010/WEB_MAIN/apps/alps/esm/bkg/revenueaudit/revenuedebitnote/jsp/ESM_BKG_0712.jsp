<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0712.jsp
*@FileTitle : RDN Receipt by Office
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.31
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.05.19 이승준
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.event.EsmBkg0712Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0712Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_office_cd = "";
	//String strUsr_office_nm = "";
	Logger log = Logger.getLogger("com.hanjin.apps.RevenueAudit.RevenueDebitNote");
	
	String rdn_no_pop = JSPUtil.getNull(request.getParameter("rdn_no"));
	String isPop = JSPUtil.getNull(request.getParameter("isPop"));

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		strUsr_office_cd =	account.getOfc_cd();
		//strUsr_office_nm =  account.getOfc_eng_nm();

		event = (EsmBkg0712Event)request.getAttribute("Event");
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
<title>RDN Receipt by Office</title>
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
 <form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- rdn_no -->
<input type="hidden" name="rdn_no" value="">
<!-- revise_seq -->
<input type="hidden" name="rvis_seq" value="">
<!-- PROG_SEQ -->
<input type="hidden" name="prog_seq" value="">
<!-- rdn status cd -->
<input type="hidden" name="rdn_sts_cd" value="">
<!--  FILE ATTACH -->
<input type="hidden" name="atch_file_lnk_id" value="">
<!-- combo -->
<input type="hidden" name="cd"   value=""> 
<input type="hidden" name="etc1" value="">
<input type="hidden" name="etc2" value="">
<input type="hidden" name="etc3" value="">

<!-- BOOKING -->
<input type="hidden" name="bkg_no"   	 value=""> 
<input type="hidden" name="bkg_no_split" value="">
<input type="hidden" name="umch_sub_tp_cd_hidden" value="">
<!-- ca no count -->
<!--<input type="hidden" name="count_bkg_corr_no"  value=""> -->

<!-- pop으로 호출시 rdn_no	-->
<input type="hidden" name="rdn_no_pop" value="<%=rdn_no_pop %>">

<!-- CTRT_TP_CD -->
<input type="hidden" name="ctrt_tp_cd" value=""> 

<!-- LOGIN OFFICE CODE -->
<input type="hidden" name="in_user_ofc_cd" value="<%=strUsr_office_cd%>"> 

<!-- Attachment -->
<input type="hidden" name="atch_file_lnk_id" value=""> 
<input type="hidden" name="file_cnt" value=""> 

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
	<%	if("Y".equals(isPop)) {		%>	
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;&nbsp;RDN Receipt by Office</td></tr>
		<tr>&nbsp;</tr>
	<%	} else { %>		
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
<%	}	%>			
	</table>
	<!--Page Title, Historical (E)-->
	
	<!-- Hidden sheet for Transaction (S) -->
		<script language="javascript">ComSheetObject('sheet0');</script>
	<!-- Hidden sheet for Transaction (E) -->
	
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="518" valign="top">
						<table class="search" border="0" style="width:100%;"> 
						<tr class="h23">
						<td width="90">RDN No. </td>
						<td width="130" style="padding-left:2"><script language="javascript"> ComComboObject('rdn_no_cd', 1, 125, 0, 1, 0, true);</script></td>
						<td width="90">RDN Kind </td>
						<td width=""><input type="text" style="width:125;text-align:center;ime-mode:disabled" name="rdn_knd_cd" class="input2" value="" caption="RDN Kind" readonly></td> 
						</tr>
						
						<tr class="h23">
						<td width="90">B/L No.</td>
						<td width="130"><input type="text" class="input" style="width:125;text-align:center;ime-mode:disabled" name="bl_no" value="" caption="B/L No" dataformat="uppernum" maxLength="12"></td>
						<td width="90">INV No.</td>
						<td width=""><input type="text" class="input" style="width:125;text-align:center;ime-mode:disabled" name="inv_no" value="" caption="Invoice No" dataformat="uppernum" maxLength="20"></td> 
						</tr>
						
						<tr class="h23">
						<td width="">Issue Office</td>
						<td width=""><input type="text" name="iss_ofc_cd" style="width:125;text-align:center;" class="input2" value="" readonly></td>
						<td width="">Status</td>
						<td width="100"><input type="text" name="rdn_sts_nm" style="width:125;text-align:center;" class="input2" value="" readonly></td>					
						</tr>
						
						<tr class="h23">
						<td width="">RHQ</td>
						<td width=""><input type="text" name="rct_rhq_cd" style="width:125;text-align:center;" class="input2" value="" readonly></td>
						<td width="">Receipt Office </td>
						<td width=""><input type="text" name="rct_ofc_cd" style="width:125;text-align:center;" class="input2" value="" readonly></td>					
						</tr>
						</table>
					</td>
					
					<td width="10"></td>
					
					<td width="">
						<table class="search" border="0" style="width:100%;">
						<tr class="h23">
						<td colspan="4"></td>
						</tr>
						
						<tr class="h23">
						<td width="85">VVD Code</td>
						<td width="130" style="padding-left:0"><input type="text" class="input" style="width:110;text-align:center;ime-mode:disabled" name="vvd_cd" value="" caption="VVD" dataformat="uppernum" maxLength="9"></td>
						<td width="100"></td>
						<td></td>
						</tr>
						
						<tr class="h23">
						<td width="85">Issue Date </td>
						<td width="130"><input type="text" name="rdn_iss_dt" style="width:110;text-align:center;" class="input2" value="" readonly></td> 
						<td width="100">Update Date</td>
						<td width=""><input type="text" name="sts_upd_dt" maxlength="10" style="width:110;text-align:center;" class="input2" value="" readonly></td> 
						</tr>
						
						<tr class="h23">
						<td width="">Resp. RHQ</td>
						<td width=""><input type="text" name="respb_rhq_cd" style="width:110;text-align:center;" class="input2" value="" readonly></td> 
						<td width="">Resp. Office</td>
						<td width=""><input type="text" name="respb_ofc_cd" style="width:110;text-align:center;" class="input2" value="" readonly></td> 
						</tr>
						</table>
					</td>
						
						
						
				
				</table>
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="518" valign="top">
						<table class="search" border="0" style="width:100%;"> 
						<tr class="h23">
						<td width="105">Error Kind</td>
						<td width="" style="padding-left:1"><input type="text" name="umch_tp_cd" style="width:125;" class="input2" value="" readonly>
						&nbsp;
						<script language="javascript"> ComComboObject('umch_sub_tp_cd', 1, 121, 0, 1, 0, false);</script>
						&nbsp;
						<!-- <input type="text" name="umch_sub_tp_cd" style="width:129;" class="input2" value="" readonly> -->
						<input type="text" name="rdn_iss_rsn_cd" style="width:125;" class="input2" value="" readonly></td>		
						</tr>
						<tr class="h23">
						<td width="">Error Remarks</td>
						<td width="" style="padding-left:1"><input type="text" name="umch_rmk" style="width:387;" class="input2" value="" readonly></td>		
						</tr>
						<tr class="h23">
						<td width="">Audit Tool</td>
						<td width="" style="padding-left:1"><input type="text" name="rev_aud_tool_cd" style="width:200;" class="input2" value="" readonly></td>		
						</tr>
						</table>
					</td>					
					<td width="10"></td>					
					<td width="">
						<table class="search" border="0" style="width:100%;"> 
							<tr class="h23">
							<td width="85">Contract No.</td>
							<td width="130"><input type="text" name="sc_rfa_no" style="width:110;text-align:center;" class="input2" value="" readonly></td>		
							<td width="100"></td>
							<td width="126"></td>
							</tr>
							<tr class="h23">
								<td width="459" colspan="4">
								<!-- Grid  (S) -->
								<table width="100%"  id="mainTable"> 
									<tr>
										<td width="100%">
											<script language="javascript">ComSheetObject('sheet1');</script>
										</td>
									</tr>
								</table>
								<table class="height_10"><tr><td colspan="4"></td></tr></table>
								<table class="height_10"><tr><td colspan="4"></td></tr></table>
						    	<!-- Button_Sub (E) -->
								</td>
							</tr>
							<tr class="h23">
							<td width="85">C/A No.</td>
							<td width="130"><input type="text" class="input" style="width:120;text-align:center;ime-mode:disabled" name="bkg_corr_no" value="" caption="C/A No"  fullfill maxLength="10"></td>		
							<td width="100">TPB Number</td>
							<td width=""><input type="text" class="input" style="width:120;text-align:center;ime-mode:disabled" name="n3pty_no" value="" caption="TPB Invoice No"  fullfill maxLength="14"></td>
							</tr>
						</table>
					</td>
						
				</tr>
				</table>
				
				<!--  biz_1   (E) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
				<td width="510"><table border="0" style="width:100%; background-color:white;" class="grid2"> 
							<tr><td width="50%%" class="tr2_head">Remarks (Auditor)</td>
							<td style="background-color:#F3F2F8; border:0px;"></td></tr>								
								<tr><td colspan="2"><textarea name="rdn_rmk" cols="" rows="4" style="width:100%" class="textarea2" readonly></textarea></td></tr></table>
					
				<td width="15"></td>
				<td width=""><table class="search" border="0" style="width:100%;"> 
							<tr class="h23"><table border="0" style="width:100%; background-color:white;" class="grid2"> 
							<tr><td width="50%" class="tr2_head">Remarks (Office)</td>
								<td style="background-color:#F3F2F8; border:0px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
							</tr>								
								<tr><td colspan="2"><textarea name="receiver_rmk" style="width:100%;ime-mode:disabled" cols="" rows="4"></textarea></td></tr></table></tr>
							</table>
			</td>
			</tr>
			</table>
			
			
			
				
					<!--  biz_2_1  (E) -->

					
					<!--Grid (S)-->
					
					<!--Grid (E)-->
					
					<!--  biz_2_2  (E) -->
					
				<!--  biz_2   (E) -->
				
		<!-- Tab ) (S) -->
     	
		<!-- Tab ) (E) -->
		
		<!-- Grid BG Box  (S) -->
     	
					<!--Grid (E)-->
				
				
				
				
				
				
			</td></tr>
		</table>
	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5; padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_retrieve">Retrieve</td>
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
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Accept">Accept</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_ReviseRequest">Revise Request </td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_CancelRequest">Cancel Request</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Attachment" id="btn_Attachment">Attachment</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<!-- td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Print">Print</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td-->
				<%	if("Y".equals(isPop)) {		%>	
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Attachment" id="btn_Attachment">Attachment</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			<%	} %>			
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
		</table>

</form>
</body>
</html>


<!-- 개발자 작업  끝 -->
