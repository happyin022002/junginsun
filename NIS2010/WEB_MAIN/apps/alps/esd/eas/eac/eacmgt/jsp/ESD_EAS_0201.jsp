<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESD_EAS_0201.jsp
*@FileTitle :  EAC Registration
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.29
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2014.10.29 백형인
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
<%@ page import="com.hanjin.apps.alps.esd.eas.eac.eacmgt.event.EsdEas0201Event"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>

<%
	EsdEas0201Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String pageRows  = "100";

	// SignOnUserAccount Info
	String usr_id 					= "";
	String strUsr_nm				= "";
	String ofc_cd					= "";
	
	String eac_no				= StringUtil.xssFilter(request.getParameter("EAC_NO"))!=null&&!StringUtil.xssFilter(request.getParameter("EAC_NO")).equals("")?StringUtil.xssFilter(request.getParameter("EAC_NO")):""; 
	String read_only_flg			= StringUtil.xssFilter(request.getParameter("READ_ONLY_FLG"))!=null&&!StringUtil.xssFilter(request.getParameter("READ_ONLY_FLG")).equals("")?StringUtil.xssFilter(request.getParameter("READ_ONLY_FLG")):""; 
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_nm 			= account.getUsr_nm();
		usr_id       		= account.getUsr_id();      
		ofc_cd      		= account.getOfc_cd();      
	

		event = (EsdEas0201Event)request.getAttribute("Event");
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
<title> EAC Registration</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
	<%= JSPUtil.getIBCodeCombo("s_expt_ofc_cd", "", "CD03398", 0, "")%>
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="session_usr_nm" value="<%=strUsr_nm%>">
<input type="hidden" name="eac_sts_cd">
<input type="hidden" name="eac_sys_if_cd">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="code_key">
<input type="hidden" name="vndr_cntc_pnt_seq">
<input type="hidden" name="s_vndr_seq">
<input type="hidden" name="s_vndr_cust_div_cd">
<input type="hidden" name="s_trd_party_val">
<input type="hidden" name="tpb_vndr_cnt_cd">
<input type="hidden" name="tpb_vndr_seq">
<input type="hidden" name="cust_cnt_cd">
<input type="hidden" name="cust_seq">
<input type="hidden" name="n3pty_ofc_cd">
<input type="hidden" name="offce_lvl">
<input type="hidden" name="read_only_flg" value ="<%=read_only_flg%>">
<input type="hidden" name="usr_id" 		  value="<%=usr_id%>" >
<input type="hidden" name="ofc_cd" 		  value="<%=ofc_cd%>" >

<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
<tr>
	<td valign="top">	
	
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->

			
		<!--Button (S) -->
	    <table width="998" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;">
		<tr>
			<td class="btn1_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
<!-- 					<td> -->
<!-- 						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button"> -->
<!-- 						<tr> -->
<!-- 							<td class="btn1_left"></td> -->
<!-- 							<td class="btn1" name="btn_retrieve" >Retrieve</td> -->
<!-- 							<td class="btn1_right"></td> -->
<!-- 						</tr> -->
<!-- 						</table> -->
<!-- 					</td> -->
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_new" >New</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_save">Save</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_delete" id="btn_delete">Delete</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_issue" id="btn_issue">Issue</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_print" id="btn_print">Print</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
<!-- 					<td class="btn1_line"></td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"	class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_close">Close</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td> -->
				</tr>
				</table>
			</td>
		</tr>
		</table>
		<!--Button (E) -->
		 
		<!--biz page (S)-->
		<table class="search"  style="width: 969;"> 
       	<tr><td class="bg">		
			<!-- biz_1  (S) -->
			<table class="search" border="0" style="width: 979;">
				<tr class="h23">
					<td width="90">Entered Date</td>
					<td width="100">
						<input type="text" dataformat="ymd" style="width: 100; text-align:center;" class="input2" name="eac_inp_dt" readonly="readonly"> 
					</td>
	                <td width="95"></td>
					<td width="118">Auditor</td>
					<td width="50">
						<input type="text" dataformat="engup" style="width: 50; text-align:left;" class="input2" maxlength="8" name="audr_ofc_cd" readonly="readonly"> 
					</td>
					<td width="80">
						<input type="text" style="width: 80; text-align:left;" class="input2" name="eac_reg_usr_nm" readonly="readonly"> 
					</td>
	                <td width="38"></td>
					<td width="101">Audit Type</td>
					<td width="100" style="padding-left:0;">
						<script language="javascript">ComComboObject('eac_apro_tp_cd',1,100,1,1,0,0);</script>
					</td>
	                <td width="11"></td>
					<td width="89">EAC No</td>
					<td width="107">
						<input type="text"  style="width: 107; text-align:center;" class="input2" name="eac_no" value = "<%=eac_no %>" readonly="readonly"> 
					</td>
					<td width="0"></td>
				</tr>
			</table>
							
			<table class=""><tr><td colspan="6"></td></tr></table>
					
			<table class="search" border="0" style="width: 979;" >
				<tr class="h23">
					<td width="90">Expense Type</td>
					<td width="100" style="padding-left:2;">
						<script language="javascript">ComComboObject('eac_expn_tp_cd',1,100,0,1,0,0);</script>
					</td>
					
					<td width="94" ></td>
					<td width="120">EAC Type</td>
					<td width="100" style="padding-left:2;">
						<script language="javascript">ComComboObject('eac_tp_cd',1,100,1,1,0);</script>
					</td>
					<td width="160" style="padding-left:2;">
						<script language="javascript">ComComboObject('eac_bil_tp_cd',1,160,1,1,0);</script>
					</td>
					<td width="68"></td>				
					<td width="140">Cost/Account Code</td>
					<td width="100">
						<input name="eac_cost_desc" type="text" style="width:100; text-align:Left;" class="input">
					</td>
					<td width="7"></td>
				</tr>
			</table>
										
			<table class="search" border="0"  style="width: 979;" >
				<tr class="h23">
					<td width="90">S/P Code</td>
					<td width="80" align="left">
						<input name="vndr_seq" dataformat ="float" type="text" style="width:50; text-align:right;" class="input1">
						<img class="cursor" src="img/btns_search.gif" width="20" height="20" border="0" align="absmiddle" name="btn_vndr_seq">
					</td>
					<td width="100">
						<input name="vndr_nm" type="text" style="width:100; text-align:right;" class="input2" readonly="readonly">
					</td>
					
					<td width="14"></td>
					<td width="119">Invoice No/Date</td>
					<td width="85">
						<input name="n3pty_src_no" type="text" style="width:85; text-align:Left;" class="input1">
					</td>
					<td width="75" >
						<input name="n3pty_src_dt" type="text" style="width:75; text-align:center;" dataformat="ymd"  class="input">
					</td>
					
					<td width="5"></td>
					<td width="101">Resp. Office</td>
					<td width="100" >
						<input name="respb_ofc_cd" type="text" dataformat="engup"  style="width:100; text-align:center;" class="input1">
					</td>				
					
					<td width="10"></td>
					<td width="90">Location</td>
					<td width="100">
						<input name="yd_cd" type="text" style="width:70; text-align:center;" class="input">
						<img class="cursor" src="img/btns_search.gif" width="20" height="20" border="0" align="absmiddle" name="btn_location">
					</td>				
					<td width="10"></td>
				</tr>
			</table>
										
			<table class="search" border="0"  style="width: 979;" >
				<tr class="h23">
					<td width="89">VVD</td>
					<td width="100">
						<input name="vvd_cd_ctnt" type="text" style="width:100; text-align:left;" class="input">
					</td>
					
					<td width="93"></td>				
					<td width="120">Work order No</td>
					<td width="100">
						<input name="wo_no_ctnt" type="text" style="width:100; text-align:left;" class="input">
					</td>				
					<td width="68"></td>
					<td width="100">Currency</td>
					<td width="100" style="padding-left:0;">
						<script language="javascript">ComComboObject('curr_cd',1,100,0,1,0);</script>
					</td>								
					<td width="209"></td>
					
				</tr>
			</table>
			
			
			<table class="search" border="0" style="width: 979;">
				<tr class="h23">

					
					<td width="89">Inv.Amount</td>
					<td width="100">
						<input type="text" dataformat="float" style="width: 100; text-align:right;" class="input" name="inv_amt"> 
					</td>
					
					<td width="92"></td>	
					<td width="122">Should be Amount</td>
					<td width="100">
						<input type="text" dataformat="float" style="width: 100; text-align:right;" class="input" name="inv_cng_amt"> 
					</td>
					
					<td width="68"></td>	
					<td width="101">Audit Amount</td>
					<td width="100">
						<input type="text" dataformat="float" style="width: 100; text-align:right;" class="input1" name="inv_aud_amt"> 
					</td>
					<td width="10"></td>	
					<td width="91">USD Amount</td>
					<td width="100">
						<input type="text" dataformat="float" style="width: 100; text-align:right;" class="input1" name="inv_aud_usd_amt"> 
					</td>
					<td width="6"></td>
				</tr>
			</table>			
			</td>
		</tr>
	</table>

							
<table class="height_8"><tr><td></td></tr></table>

		
		<!-- Tab (S) -->
     	<table class="tab" border="0" cellpadding="0" cellspacing="0"> 
       	<tr><td><script language="javascript">ComTabObject('tab1', null, 997, 27, true)</script></td></tr>
		</table>
		<!-- Tab (E) -->
				
<!--TAB Audit Detail (S) -->
<div id="tabLayer" style="display:inline" >
   	<table class="search" style="width: 959;"> 
      	<tr>
       		<td class="bg">
				<table class="search" border="0">
					<tr class="h23">
						<td align="left">
							<table width="489" border="0" cellpadding="0" cellspacing="0">
 								<tr>
									<td width="140">Audit Month</td>
									<td width="110" style="padding-left:1;">
										<input type="text" dataformat="ym" style="width: 80; text-align:center;" class="input2" name="eac_yrmon" readonly="readonly">
										<img class="cursor" src="img/btns_calendar.gif" width="20" height="20" border="0" align="absmiddle" name="btn_audit_month">
									</td>
									<td width="30"></td>
									<td width="85">Action Type</td>
									<td width="120" style="padding-left:0;">
										<script language="javascript">ComComboObject('eac_rsn_cd',1,118,0,1,0);</script>
									</td>
									<td width="20"></td>
								</tr>																
								<tr>
									<td >Audit Detail (Reason)</td>
									<td colspan="5">
										<textarea name="eac_desc" rows="13" cols="63" class="textarea1"></textarea>
									</td>
								</tr>


								<tr>
									<td >Action taken</td>
									<td colspan="5">
										<textarea name="eac_rsn_desc" rows="4" cols="63" class="textarea1"></textarea>
									</td>
								</tr>	
 								<tr>
									<td>Relevant Evidence. No.</td>
									<td colspan="5" style="padding-left:1;">
										<input type="text" style="width: 336; text-align:left;" class="input" name="expn_evid_desc">
									</td>
								</tr>
								<tr>
									<td>Completion</td>
									<td style="padding-left:3;">
										<script language="javascript">ComComboObject('eac_cmpl_cd',1,100,1,0,0);</script>
									</td>
									<td colspan="4">Settled Amount(US$) &nbsp;&nbsp
									<input type="text" dataformat="float" style="width: 92; text-align:right;" class="input" name="stl_amt">
									</td>

								</tr>		
																		
 								<tr>
									<td >Attach</td>
									<td  colspan="5" style="padding-left:1;">
										<input type="text" style="width: 50; text-align:left;" class="input2" name="atch_file_id" readonly="readonly">
										<img class="cursor" src="img/btns_search.gif" width="20" height="20" border="0" align="absmiddle" name="btn_attach">
									</td>
								</tr>																
							</table>
						</td>
						<td align="left">
							<table width="490" border="0" cellpadding="0" cellspacing="0">
 								<tr>
									<td>Status</td>
									<td style="padding-left:3;">
									    <script language="javascript">ComComboObject('dis_eac_sts_cd',1,120,1,3,0);</script>
										<input type="hidden" name="eac_sts_nm">
									</td>
									<td>Auditor</td>
									<td style="padding-left:1;">
										<input type="text" dataformat="engup" style="width: 120; text-align:left;" class="input2" name="apro_usr_nm" readonly="readonly">
									</td>
								</tr>
 								<tr>
									<td>KPI Office</td>
									<td style="padding-left:1;">
										<input type="text" dataformat="engup" style="width: 100; text-align:center;" class="input2" name="kpi_ofc_cd" readonly="readonly">
									</td>
								</tr>
															
								<tr>
									<td width="140">Internal note</td>
									<td width="350" colspan="3">
										<textarea name="eac_inter_rmk" rows="11" cols="60" ></textarea>
									</td>
								</tr>
		
 								<tr>
									<td>Rejected by</td>
									<td style="padding-left:1;" colspan="3">
										<input type="text"  style="width: 100; text-align:center;" class="input2" readonly="readonly" name="eac_rjct_ofc_cd">
										<input type="text"  style="width: 217; text-align:center;" class="input2" readonly="readonly" name="eac_rjct_usr_nm">
									</td>
									
								</tr>										
								

								<tr>
									<td>Reason of Unapproval</td>
									<td style="padding-left:0;" colspan="3">
										<textarea  class="textarea2"  name="eac_rjct_rsn" rows="7" cols="60" readonly="readonly" ></textarea>
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
<!-- TAB Audit Detail (E) -->

<!--TAB Rejection Notice (S) -->
<div id="tabLayer" style="display:none">
   	<table class="search"  style="width: 959;"> 
      	<tr>
       		<td class="bg">
					<table class="search" border="0" width=100%>
						<tr class="h23">
							<td align="left">
								<table width="330" border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td width="120">No. of notice</td>
										<td width="180">
											<input type="text"  style="width: 180; text-align:left;" class="input2" name="ntc_his_seq" readonly="readonly">
										</td>
									</tr>								
									<tr>
										<td width="120">S/P Name</td>
										<td width="180">
											<input type="text"  style="width: 180; text-align:left;" class="input2" name="vndr_lgl_eng_nm" readonly="readonly">
										</td>
									</tr>
									<tr>
										<td width="120">Address</td>
										<td width="180">
											<input type="text"  style="width: 180; text-align:left;" class="input2" name="eng_addr" readonly="readonly">
										</td>
									</tr>
									<tr>
										<td width="120">ZIP Code</td>
										<td width="180">
											<input type="text"  style="width: 180; text-align:left;" class="input2" name="zip_cd" readonly="readonly">
										</td>
									</tr>
									<tr>
										<td width="120">Contact Point</td>
										<td width="180" style="padding-left:2;">
											<script language="javascript">ComComboObject('vndr_cntc_pnt_nm',1,180,1,0,0);</script>
										</td>
									</tr>
									<tr>
										<td width="120">E-mail</td>
										<td width="180">
											<input type="text"  style="width: 180; text-align:left;" class="input2" name="vndr_eml" readonly="readonly">
										</td>
									</tr>
									<tr>
										<td width="120">Phone</td>
										<td width="180">
											<input type="text"  style="width: 180; text-align:left;" class="input2" name="phn_no" readonly="readonly">
										</td>
									</tr>
									<tr>
										<td width="120">FAX</td>
										<td width="180">
											<input type="text"  style="width: 180; text-align:left;" class="input2" name="fax_no" readonly="readonly">
										</td>
									</tr>
									<tr>
										<td width="0" height="110"></td>
									</tr>									
								</table>
							</td>

							<td align="left">
								<table width="649"  border="0" cellpadding="0" cellspacing="0" style="padding-top: 0; padding-bottom: 2;">
									    <tr><td width="2" height="10" colspan="2"></td></tr>
									    
									    <tr>
										   <td align="left" width="110">Mail Subject</td>
										   <td>
											   <textarea name="eml_subj_ctnt" rows="2" cols="100" ></textarea>
										   </td>
									    </tr>		

									    <tr>
										   <td align="left">Body of mail</td>
										   <td>
											   <textarea name="eml_ctnt" rows="10" cols="100" ></textarea>
										   </td>
									    </tr>										    									

									    <tr>
										   <td align="left">Reason of rejection</td>
										   <td>
											   <textarea name="eac_rjct_desc" rows="8" cols="100"  class="textarea"  ></textarea>
										   </td>
									    </tr>										    									
									    <tr><td width="2" height="20" colspan="2"></td></tr>
									<tr>

									</tr>									    
								</table>
							</td>
						</tr>
						<tr>
							<td  class="btn1_bg" colspan="2" align="right">
								<table border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td>
											<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr>
												<td class="btn1_left"></td>
												<td class="btn1" name="btng_preview" id="btng_preview" >Preview & Send</td>
												<td class="btn1_right"></td>
											</tr>
											</table>
										</td>												
										<td>
											<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr>
												<td class="btn1_left"></td>
												<td class="btn1" name="btng_history" id="btng_history">History</td>
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
<!-- TAB Rejection Notice (E) -->


<!--TAB TPB I/F (S) -->
<div id="tabLayer" style="display:none">
   	<table class="search" style="width: 959;"> 
      	<tr>
       		<td class="bg">
					<table class="search" border="0" width=100%>
						<tr class="h23">
							<td align="left">
								<table width="959" border="0" cellpadding="0" cellspacing="0">
	 								<tr><td>
										<table class="search" border="0" width=100%>	 								
											<tr>
												<td width="102">TPB Exp.Type</td>
												<td width="136" >
													<script language="javascript">ComComboObject('n3pty_expn_tp_cd',1,98,1,0,0);</script> 
												</td>
												<td width="83">TPB Code</td>
												<td width="217">
													<script language="javascript">ComComboObject('n3pty_bil_tp_cd',1,199,1,1,0);</script> 
												</td>
												<td width="420"></td>
											</tr>
										</table>
				                         </td>
									</tr>				
	 								<tr><td>
										<table class="search" border="0"  width=100%>	 								
											<tr>
												<td width="100">Booking No.</td>
												<td width="139">
													<input type="text"  style="width: 99; text-align:center;" class="input1" name="bkg_no"> 
												</td>
												<td width="80">B/L No.</td>
												<td width="120">
													<input type="text"  style="width: 99; text-align:center;" class="input"  name="bl_no"> 
												</td>
												<td width="91">3RD Party</td>
												<td width="429" style="padding-left:0;">
													<script language="javascript">ComComboObject('vndr_cust_div_cd',1,80,1,1,0);</script>
													<input type="text" style="width: 80; text-align:left" class="input" name="trd_party_val" > 
													<img class="cursor" style="padding-left:0;" src="img/btns_search.gif" width="20" height="20" border="0" align="absmiddle" name="btn_party_val" >
													<input type="text" style="width: 205; text-align:left;" class="input2" name="trd_party_nm" readonly="readonly"> 
												</td>
											</tr>
										</table>
				                         </td>
									</tr>					
		 							<tr><td>
										<table class="search" border="0"  width=100%>	 								
											<tr>
												<td width="100">TPB No.</td>
												<td width="139">
													<input type="text" style="width: 110; text-align:center;" class="input2" name="n3pty_no" readonly="readonly"> 
													<img class="cursor" style="padding-left:0;" src="img/btns_search.gif" width="20" height="20" border="0" align="absmiddle" name="btn_n3pty_no" >
												</td>
											    
												<td width="80">TPB Office</td>
												<td width="120">
													<input type="text" dataformat="engup" style="width: 99; text-align:center;" class="input2" maxlength="8" name="tpb_ofc_cd" readonly="readonly"> 
												</td>
											    
												<td width="90">TPB Status</td>
												<td width="120">
													<input type="text" style="width: 99; text-align:left;" class="input2" name="ots_sts_nm" readonly="readonly"> 
												</td>
												
												<td width="100">Recovery(US$)</td>
												<td width="120" style="padding-left:0;">
													<input type="text" dataformat="float" style="width: 119; text-align:right;" class="input2" name="tpb_inv_amt" readonly="readonly"> 
												</td>
												<td width="90"></td>
											</tr>
										</table>
				                         </td>
									</tr>		
	 								<tr>
										<td>
											<!-- Grid  (S) -->														
											<table width="100%" id="mainTable"> 
												<tr>
													<td width="100%">
														<script language="javascript">ComSheetObject('sheet1');</script>
													</td>
												</tr>
											</table> 
											<!-- Grid (E) -->
										</td>
									</tr>																
								</table>
							</td>
						</tr>
					</table>
					<!--  Button_Sub (S) -->
					<table width="979" class="button">
						<tr>
							<td class="btn2_bg">
							<table border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td>
										<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr>
												<td class="btn2_left"></td>
												<td class="btn2" name="btng_RowAdd">Row&nbsp;Add</td>
												<td class="btn2_right"></td>
											</tr>
										</table>
									</td>
									<td>
										<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr>
												<td class="btn2_left"></td>
												<td class="btn2" name="btng_RowDel">Row Delete</td>
												<td class="btn2_right"></td>
											</tr>
										</table>
									</td>
									<td>
			                               <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			                                   <tr>
			                                       <td class="btn2_left"></td>
			                                       <td class="btn2" name="btng_tpb_if">TPB I/F</td>
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
					

			</td>
		</tr>
		
	</table>
</div>
<!-- TAB TPB I/F (E) -->

<!-- Grid  (S) -->														
<table width="100%" id="mainTable"> 
<tr>
	<td width="100%">
		<script language="javascript">ComSheetObject('sheet2');</script>
	</td>
</tr>
</table> 
<!-- Grid (E) -->

<!-- Grid  (S) -->														
<table width="100%" id="mainTable"> 
<tr>
	<td width="100%">
		<script language="javascript">ComSheetObject('sheet3');</script>
	</td>
</tr>
</table> 
<!-- Grid (E) -->


<!-- Grid  (S) -->														
<table width="100%" id="mainTable"> 
<tr>
	<td width="100%">
		<script language="javascript">ComSheetObject('sheet4');</script>
	</td>
</tr>
</table> 
<!-- Grid (E) -->

<!-- 개발자 작업  끝 -->
			</td>
		</tr>
	</table>
</form>
</body>
</html>