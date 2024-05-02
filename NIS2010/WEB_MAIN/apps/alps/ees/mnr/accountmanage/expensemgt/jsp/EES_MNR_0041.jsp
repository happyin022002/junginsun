<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0041.jsp
*@FileTitle : MNR Invoice Creation & Correction
*Open Issues :     
*Change history :  
*@LastModifyDate : 2009.08.17
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2009.08.17 함형석
* 1.0 Creation
* History
* 10만불 비용지급 결재 3차 Invoice File Attatch 기능 추가 : 2014-11-12
* 2015.10.29 박정민 M&R - Invoice creation 화면에서 EAS 시스템 결과 확인 요청 기능 개발, Auto Audit 항목 추가 및 데이터 연계
=========================================================*/
%> 


<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.mnr.accountmanage.expensemgt.event.EesMnr0041Event" %>
<%@ page import="com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.basic.GeneralCodeSearchMgtBCImpl"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0041Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd        = "";
	String strRhq_ofc_cd         = "";
	Logger log = Logger.getLogger("com.hanjin.apps.test.test");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		strRhq_ofc_cd  = account.getRhq_ofc_cd();
		
		event = (EesMnr0041Event)request.getAttribute("Event");
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
	var currOfcCd = '<%=strOfc_cd %>';
	var rhqOfcCd  = '<%=strRhq_ofc_cd %>';
	
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
<input type="hidden" name="key_value">  
<input type="hidden" name="usr" value="<%=strUsr_id %>">
<input type="hidden" name="ar_hd_qtr_cd">
<input type="hidden" name="ofc_cd">
<input type="hidden" name="inv_search_tp">
<input type="hidden" name="from_dt">
<input type="hidden" name="to_dt">
<input type="hidden" name="mnr_ord_seq">
<input type="hidden" name="vndr_seq">
<input type="hidden" name="inv_sch_type_code">
<input type="hidden" name="mnr_inv_sts_cd">
<input type="hidden" name="pay_inv_seq">
<input type="hidden" name="iss_ofc_cd" value="<%=strOfc_cd%>">
<input type="hidden" name="mnr_grp_tp_cd">
<input type="hidden" name="inv_rgst_no">
<input type="hidden" name="conv_dp_prcs_knt">
<input type="hidden" name="file_seq" value="">
<input type="hidden" name="cnt_cd" value="">
<input type="hidden" name="list_kind" value="">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	
        <!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		    <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table> 
		<!--Page Title, Historical (E)-->        
	
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
       	<tr><td class="btn1_bg">
		
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_AllNew">New</td>
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
					<td class="btn1" name="btn_Delete">Delete</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Confirm">Confirm</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>			
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Return">Reject</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td></tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->
		
		<!--biz page - TOP (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
				
				<!-- biz_frame - 1 (S) -->
				<table class="search" style="width:100%;">
				<tr><td valign="top" style="padding-right:15;">
				
					<table class="search" border="0" width="100%">
						<tr><td class="title_h"></td>
							<td class="title_s" width="340">Invoice List</td>
							<td class="btn2_bg" style="padding:0,0,3,0;">
							<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn_New">New</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>							
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn_Retrieve">Retrieve</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
								
							</tr></table>
						</td></tr>
						</table>
						<!--  Button_Sub (S) -->
						
				    	<!-- Button_Sub (E) -->

						<!--  biz_1 (S) -->
						<table class="search" border="0" style="width:155;" align="left"> 
							<tr class="h23">
								<td width="45">KIND</td>
								<td width="110">
								<script language="javascript">ComComboObject('combo1',1, 100 , 1,1);</script>
								</td></tr>
							<tr class="h23" id="selectComboLayer" style="display:none">
								<td width="45">W/O Office</td>
								<td width="110">
								<script language="javascript">ComComboObject('wo_ofc_cd',2, 100 , 0,1);</script>
								</td>
								</tr>		
						</table>

<!-- Select Tab [ Web Import ] (S) -->
<div id="selectLayer" style="display:none">
						
						<table class="search" border="0" style="width:309;"> 
							<tr class="h23">
								<td width="75">Req. Date</td>
								<td width="">
								<input name="t1_from_dt" type="text" style="width:99" class="input" dataformat="ymd" cofield="t1_to_dt">&nbsp;~&nbsp;
								<input name="t1_to_dt" type="text" style="width:99" class="input" dataformat="ymd" cofield="t1_from_dt">&nbsp;<img name="btn_t1_calendar" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
							</tr>
							<tr class="h23">
								<td>INV No.</td>
								<td><input name="t1_mnr_ord_seq" type="text" style="width:221;" dataformat="engup" >&nbsp;<img name="btn_t1_req_multy" src="img/btns_multisearch.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
							</tr>
							<tr class="h23">
								<td>S/Provider</td>
								<td>
								<input type="text" name="t1_vndr_seq" style="width:57;text-align:center" class="input" maxlength="6" dataformat="engup">&nbsp;<img name="btn_t1_provider_popup" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">&nbsp;<input type="text" name="t1_vndr_lgl_eng_nm" style="width:160" class="input2" readOnly="true">
								</td>
							</tr>
						</table>
						<!--  biz_1   (E) -->						
						
						<!-- Grid  (S) -->
						<table width="100%"  id="mainTable" border="0" > 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('t1sheet1');</script>
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
								<tr><td><img src="img/btn_2_left_down.gif" width="17" height="19" alt="" border="0"></td>
								<td class="btn2" name="btn_t1_Clear">New</td>	
								<td class="btn2_right"></td>
								</tr>
								</table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td><img src="img/btn_2_left_down.gif" width="17" height="19" alt="" border="0"></td>
								<td class="btn2" name="btn_t1_DetailRetrieve">Detail Retrieve</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
								
								</tr></table>
						</td></tr>
						</table>
				    	<!-- Button_Sub (E) -->
			
</div>
<!-- Select Tab [ Web Import ] (E) -->


<!-- Select Tab [ Work Order ] (S) -->
<div id="selectLayer" style="display:inline">

						<table class="search" border="0" style="width:309;"> 
							<tr class="h23">
								<td width="75" >W/O Date</td>
								<td width="">
								<input name="t2_from_dt" type="text" style="width:99" class="input" dataformat="ymd">&nbsp;~&nbsp;
								<input name="t2_to_dt" type="text" style="width:99" class="input" dataformat="ymd">&nbsp;<img name="btn_t2_calendar" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
							</tr>
							<tr class="h23">
								<td>W/O No.</td>
								<td><input name="t2_mnr_ord_seq" type="text" style="width:221;" dataformat="engup" >&nbsp;<img name="btn_t2_req_multy" src="img/btns_multisearch.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
							</tr>
							<tr class="h23">
								<td>S/Provider</td>
								<td>
								<input type="text" name="t2_vndr_seq" style="width:57;text-align:center" class="input" maxlength="6" dataformat="engup">&nbsp;<img name="btn_t2_provider_popup" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">&nbsp;<input type="text" name="t2_vndr_lgl_eng_nm" style="width:160" class="input2" readOnly="true">
								</td>
							</tr>
						</table>						
						<!--  biz_1   (E) -->	
						
						
						<!-- Grid  (S) -->
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('t2sheet1');</script>
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
								<tr><td><img src="img/btn_2_left_down.gif" width="17" height="19" alt="" border="0"></td>
								<td class="btn2" name="btn_t2_Clear">New</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td><img src="img/btn_2_left_down.gif" width="17" height="19" alt="" border="0"></td>
								<td class="btn2" name="btn_t2_DetailRetrieve">Detail Retrieve</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
								
								</tr></table>
						</td></tr>
						</table>
				    	<!-- Button_Sub (E) -->

</div>
<!-- Select Tab [ Work Order ] (E) -->


<!-- Select Tab [ Invoice Correction ] (S) -->
<div id="selectLayer" style="display:none">
						<table class="search" border="0" style="width:309;"> 
							<tr class="h23">
								<td width="75">INV Date</td>
								<td width="">
								<input name="t3_from_dt" type="text" style="width:99" class="input" dataformat="ymd">&nbsp;~&nbsp;
								<input name="t3_to_dt" type="text" style="width:99" class="input" dataformat="ymd">&nbsp;<img name="btn_t3_calendar" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
							</tr>
							<tr class="h23">
								<td>INV No.</td>
								<td><input name="t3_mnr_ord_seq" type="text" style="width:221;" dataformat="engup" >&nbsp;<img name="btn_t3_req_multy" src="img/btns_multisearch.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
							</tr>
							<tr class="h23">
								<td>S/Provider</td>
								<td>
								<input type="text" name="t3_vndr_seq" style="width:57;text-align:center" class="input" maxlength="6"  dataformat="engup">&nbsp;<img name="btn_t3_provider_popup" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">&nbsp;<input type="text" name="t3_vndr_lgl_eng_nm" style="width:160" class="input2" readOnly="true">
								</td>
							</tr>
						</table>						
						<!--  biz_1   (E) -->	
						
						<!-- Grid  (S) -->
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('t3sheet1');</script>
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
								<tr><td><img src="img/btn_2_left_down.gif" width="17" height="19" alt="" border="0"></td>
								<td class="btn2" name="btn_t3_Clear">New</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td><img src="img/btn_2_left_down.gif" width="17" height="19" alt="" border="0"></td>
								<td class="btn2" name="btn_t3_DetailRetrieve">Detail Retrieve</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
								
								</tr></table>
						</td></tr>
						</table>
				    	<!-- Button_Sub (E) -->


</div>
<!-- Select Tab [ Invoice Correction] (E) -->

					</td>
					
					<td width="50%" valign="top" style="padding-left:15;">
					
						<table class="search" border="0">
						<tr><td class="title_h"></td>
							<td class="title_s">Invoice Information</td></tr>
						</table>
						<!--  biz_2 (S) -->
						<table class="search" border="0" style="width:474;"> 
							<tr class="h23">
								<td width="75">Invoice No.</td>
								<td width="205"><input name="inv_no" type="text" size="30" maxlength="20" class="input1" dataformat="engup" ></td>
								<td width="98">Invoice Status</td>
								<td width="" ><input name="inv_status" type="text" style="width:92;" class="input2" readOnly="true">
											<script language="javascript">ComComboObject('combo2',1, 0 , 1,3);</script></td>
							</tr>
						</table>	
						<table class="search" border="0" style="width:474;"> 
							<tr class="h23">
								<td width="75">Receive DT</td>
								<td width="100"><input name="rcv_dt" type="text" style="width:70;" class="input1" dataformat="ymd">&nbsp;<img name="btn_rcv_dt" src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
								<td width="60" align="right">Issue DT&nbsp;</td>
								<td width=""><input name="iss_dt" type="text" style="width:70;"  class="input1" dataformat="ymd">&nbsp;<img name="btn_isu_dt" src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>

							</tr>
						</table>
						<table class="search" border="0" style="width:474;"> 
							<tr class="h23">
								<td width="75">W/O S/P</td>
								<td width="250"><input name="ord_vndr_seq" type="text" style="width:70;" class="input2" readOnly="true">&nbsp;<input name="ord_vndr_seq_nm" type="text" style="width:155;" class="input2" readOnly="true"></td>
								<td width="60">INV Office</td>
								<td width=""><input name="agmt_ofc_cd" type="text" style="width:86;" class="input2" readOnly="true"></td>
							</tr>
						</table>
						<table class="search" border="0" style="width:474;"> 
							<tr class="h23">
								<td width="75">Pay S/P</td>
								<td width="250"><input required  type="text" name="mnr_prnr_seq" caption="Service Provider" style="width:55;text-align:left;" class="input1" value="" dataformat="engup" maxlength="6">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btn_vndr" width="19" height="20" border="0" align="absmiddle">&nbsp;<input type="text" name="vndr_nm" caption="Service Provider" style="width:147;" class="input2" value="" readonly>							  
								</td>
								<td width="60">Pay Term</td>
								<td><input name="gen_pay_term_cd" type="text" style="width:51; text-align:right;" class="input2" readOnly="true"></td>

							</tr>	
						</table>
						<table class="search" border="0" style="width:474;"> 
							
							<tr class="h23">
								<td width="75">INV Curr</td>
								<td width="80"><input name="curr_cd" type="text" style="width:70;" class="input2" readOnly="true"></td>
								<td width="75">Conv Curr</td>
								<td><script language="javascript">ComComboObject('target_curr_cd',2, 50 , 1,0);</script>&nbsp;&nbsp;</td>			
								<td>EX.Rate <input name="curr_rt" type="text" style="width:70; text-align:right;" class="input" dataformat="float">&nbsp;</td>										    						
								<td width="">
								
									<table border="0" cellpadding="0" cellspacing="0">
										<tr>
											<td>
												<table border="0" cellpadding="0" cellspacing="0">
													<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr><td><img src="img/btn_2_left_down.gif" width="17" height="19" alt="" border="0"></td>
													<td class="btn2" name="btn_Convert">Conv</td>
													<td class="btn2_right"></td>
													</tr>
													</table></td>
													</tr></table>
											</td>
									  	</tr>
									</table>		
																
								</td>
							</tr>
						</table>	
						<table class="search" border="0" style="width:474;">
							<tr class="h23">		
								<td width="95">Invoice Total</td>
								<td colspan="5"><input name="ttl_amt" type="text" style="width:100%; text-align:right;" class="input1" dataformat="float"></td>
							</tr>  	
							<tr class="h23">			
								<td width="95">SML Amount</td>
								<td colspan="5"><input name="bzc_amt" type="text" style="width:100%; text-align:right;" class="input2" dataformat="float" readOnly="true"></td>
							</tr>
							<tr class="h23">					
								<td width="95" id="vatTax">V.A.Tax</td>
								<td width="95"><input name="vat_amt" type="text" style="width:70; text-align:right;" class="input" dataformat="float"></td>
								<td width="75">Sales Tax</td>	
								<td width="95"><input name="sls_tax_amt" type="text" style="width:80; text-align:right;" class="input" dataformat="float"></td>
								<td width="60">W.H.Tax</td>
								<td width=""><input name="whld_tax_amt" type="text" style="width:86; text-align:right;" class="input" dataformat="float"></td>
							</tr>
							<tr class="h23" id="sbcTax" style='display:;' >
								<td width="95">SBC Tax</td>
								<td width=""><input name="env_chg_tax" type="text" style="width:70; text-align:right;" class="input" dataformat="float"></td>
							</tr>
						</table>
						<table class="search" border="0" style="width:474;">
							<tr class="h23" id="idaGstTax" style='display:none;' >
								<td width="35">CGST</td>
								<td width=""><input name="ida_cgst_amt" type="text" style="width:65; text-align:right;" class="input2" dataformat="float" readOnly="true"></td>
								<td width="35">SGST</td>
								<td width=""><input name="ida_sgst_amt" type="text" style="width:65; text-align:right;" class="input2" dataformat="float" readOnly="true"></td>
								<td width="35">IGST</td>
								<td width=""><input name="ida_igst_amt" type="text" style="width:65; text-align:right;" class="input2" dataformat="float" readOnly="true"></td>
								<td width="35">UGST</td>
								<td width=""><input name="ida_ugst_amt" type="text" style="width:65; text-align:right;" class="input2" dataformat="float" readOnly="true"></td>
							</tr>
							<tr class="h23" id="idaGstInfo" style='display:none;' >
								<td width="100" colspan="2">GSTIN/UIN</td>
								<td colspan="2"><input name="ida_gst_rgst_no" type="text" style="width:100; text-align:left;" class="input2" readOnly="true"></td>
								<td width="35">State</td>
								<td colspan="4"><input name="ida_ste_cd" type="text" style="width:50; text-align:center;" class="input2" readOnly="true">&nbsp;<input name="ida_ste_nm" type="text" style="width:130;" class="input2" readOnly="true"></td>
							</tr>
						</table>
						<table class="search" border="0" style="width:474;">
							<tr class="h23">
								<td width="85">Remark</td>
								<td colspan="5"><input name="mnr_inv_rmk" type="text" style="width:100%;" class="input" maxlength="4000"></td>
							</tr>								
							<tr class="h23">
								<td width="85">Auto Audit</td>
								<td colspan="2"><input name="eas_audit_desc" type="text" style="width:150px" class="input2" readonly maxlength="20"></td>
								<td colspan="3">
									<table border="0" cellpadding="0" cellspacing="0">
										<tr>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td><img src="img/btn_2_left_down.gif" width="17" height="19" alt="" border="0"></td>
														<td class="btn2" name="btn_audit_detail">Detail</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					
						<!--  biz_2   (E) -->	
					
					</td>
				</tr>
				</table>
				<!-- biz_frame - 1 (E) -->
				
			</td></tr>
		</table>
		<!--biz page - TOP (E)-->


		<!--biz page - MIDDLE (Grid) (S)-->
		<table class="height_8"><tr><td></td></tr></table>
		<!-- Tab (S) -->
		<table class="tab" border="0" cellpadding="0" cellspacing="0" width="100%"> 
           		 <tr><td width="100%">
				<script language="javascript">ComTabObject('tab1')</script>
			</td></tr>
		</table>
		<!-- Tab (E) -->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">				
				
				<!-- Tab div (S) -->
				 <div id="tabLayer" style="display:inline">
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>

				<!-- Grid (E) -->			
				</div>
				 <div id="tabLayer" style="display:none">
				 <!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
						<script language="javascript">ComSheetObject('sheet2');</script>	
						<script language="javascript">ComSheetObject('sheet3');</script>
						<script language="javascript">ComSheetObject('sheet4');</script>	
						</td>
					</tr>
				</table>
				<!-- Grid (E) -->
				
				</div>
				<div id="tabLayer" style="display:none">
				
				<!--  Button_File (S) -->
				<table width="100%" class="button"> 
				<tr><td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_File_Add">File Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_File_Del">File Remove</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr>
					</table>
				</td></tr>
				</table>
				<!-- Button_File (E) -->
				<table><tr><td height="7"></td></tr></table>
				<!-- Grid  (S) -->
				<table width="100%" id="mainTable"> 
					<tr>
						<td width="100%">
						<script language="javascript">ComSheetObject('sheetFile');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) -->			
				</div>
				<!-- Tab div (E) -->
				<!--  Button_Sub (S) -->
				<table width="100%" class="button"> 
		       	<tr><td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Store">Verify</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Del">Row Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_RepairDetail">Repair Detail</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_DownExcel">Down Excel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_LoadExcel">Load  Excel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						
						</tr></table>
				</td></tr>
				</table>
		    	<!-- Button_Sub (E) -->
			
		<!--biz page - MIDDLE (Grid) (E)-->
			
		</td></tr>
		</table>		
		<!-- 5 (E) -->	
		<!--biz page - BOTTOM (E)-->
		
		<table class="height_5"><tr><td></td></tr></table>

	</td></tr>
		</table>
	
<script language="javascript">ComUploadObject('upload1', '<=session.getId()%>');</script>	
</form>
</body>
</html>
