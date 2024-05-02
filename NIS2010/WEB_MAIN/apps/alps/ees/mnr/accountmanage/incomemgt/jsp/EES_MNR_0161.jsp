<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0161.jsp
*@FileTitle : Disposal Invoice Issue & Correction
*Open Issues :     
*Change history :  
*@LastModifyDate : 2009.09.21
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2009.09.21 함형석
* 1.0 Creation    
--------------------------------------------------------
* History
* 2012.07.09 신혜정 [CHM-201218398] Invoice Cancel/Delete 시 본부/지점 담당자 처리 불가 기능
* 2013.07.23  조경완  [CHM-201325777-01] ALPS-MNR-Disposal-Invoice Issuetl, Invoice Issue 및 Due Date 로직 변경 요청
* 2013.08.23 조경완 [CHM-201326149-01] ALPS - MNR-Disposal-Invoice Issue 화면 일부 수정 요청
=========================================================*/
%>
 

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.mnr.accountmanage.incomemgt.event.EesMnr0161Event" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0161Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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
		
		event = (EesMnr0161Event)request.getAttribute("Event");
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

<!--MNR 공용 사용  -->       
<script language="javascript">   
	var currOfcCd = '<%=strOfc_cd %>';
	var rhqOfcCd  = '<%=strRhq_ofc_cd %>';
	var self_usr_nm = "<%=strUsr_nm%>";
	 
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
<input type="hidden" name="rcv_inv_seq">
<input type="hidden" name="com_mrdArguments">
<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdBodyTitle">
<input type="hidden" name="cancel_yn">
<input type="hidden" name="mnr_grp_tp_cd">
<input type="hidden" name="mnr_prnr_tp_cd">
<input type="hidden" name="conv_dp_prcs_knt">
<input type="hidden" name="mnr_prnr_knd_cd">
<input type="hidden" name="g_real_amt">


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
					<td class="btn1" name="btn_New_All">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
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
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Preview">Invoice Preview</td>
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
							<td class="title_s" width="325">Invoice List</td>
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
						<table class="search" border="0" style="width:175;" align="left"> 
							<tr class="h23">
								<td width="70">KIND</td>
								<td width="105">
								<script language="javascript">ComComboObject('combo_kind',1, 100 , 1,1);</script>
								</td></tr>
							<tr class="h23">
								<td width="70">Buyer Type</td>
								<td width="105">
								<script language="javascript">ComComboObject('combo_buyer_type',1, 100 , 1,1);</script>
								</td></tr>			
							<tr class="h23">								
								<td width="175" colspan="2"><span id="spnForCel">For Cancel/Del.&nbsp;								
								<input name="for_cel_del" type="checkbox" value="Y" class="trans"></span>
								</td></tr>																								
						</table>

<!-- Select Tab [ Disposal No ] (S) -->
<div id="selectLayer" style="display:inline">
						
						<table class="search" border="0" style="width:305;"> 
							<tr class="h23">
								<td width="65">App Date</td>
								<td width="">
								<input name="t1_from_dt" type="text" style="width:70" class="input" dataformat="ymd" cofield="t1_to_dt">&nbsp;~&nbsp;
								<input name="t1_to_dt" type="text" style="width:70" class="input" dataformat="ymd" cofield="t1_from_dt">&nbsp;<img name="btn_t1_calendar" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
							</tr>
							<tr class="h23">
								<td>Disposal No.</td>
								<td><input name="t1_mnr_ord_seq" type="text" style="width:160;" dataformat="engup" >&nbsp;<img name="btn_t1_req_multy" src="img/btns_multisearch.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
							</tr>
							<tr class="h23">
								<td>Buyer&nbsp;</td>
								<td>
								<input type="text" name="t1_mnr_prnr_cnt_cd" style="width:25" value="" maxlength=2 class="input" dataformat="engup">
								<input type="text" name="t1_mnr_prnr_seq" style="width:50" value="" class="input" maxlength=9 dataformat="int">
								<img class="cursor" name="btn_t1_provider_popup" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
								<input type="text" name="t1_mnr_prnr_cnt_nm" style="width:120" value="" class="input2" readonly title="">
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
							<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
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
<!-- Select Tab [ Disposal No ] (E) -->


<!-- Select Tab [ Invoice Correction ] (S) -->
<div id="selectLayer" style="display:none">
						<table class="search" border="0" style="width:305;"> 
							<tr class="h23">
								<td width="75">INV Date&nbsp;</td>
								<td width="">
								<input name="t2_from_dt" type="text" style="width:70" class="input" dataformat="ymd">&nbsp;~&nbsp;
								<input name="t2_to_dt" type="text" style="width:70" class="input" dataformat="ymd">&nbsp;<img name="btn_t2_calendar" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
							</tr>
							<tr class="h23">
								<td>INV No.&nbsp;</td>
								<td><input name="t2_mnr_ord_seq" type="text" style="width:160;" dataformat="engup" >&nbsp;<img name="btn_t2_req_multy" src="img/btns_multisearch.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
							</tr>
							<tr class="h23">
								<td>Buyer&nbsp;</td>
								<td>
								<input type="text" name="t2_mnr_prnr_cnt_cd" style="width:25" value="" maxlength=2 class="input" dataformat="engup">
								<input type="text" name="t2_mnr_prnr_seq" style="width:50" value="" class="input" maxlength=9 dataformat="engup">
								<img class="cursor" name="btn_t2_provider_popup" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
								<input type="text" name="t2_mnr_prnr_cnt_nm" style="width:120" value="" class="input2" readonly title="">
								
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
							<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
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
								<td width="200"><input name="input_inv_no" type="text" style="width:140;" maxlength="20" class="input2" readOnly="true" dataformat="engup" ></td>
								<td width="100">Invoice Status</td>
								<td width="" ><input name="inv_status" type="hidden" style="width:100;" class="input2" readOnly="true">
											<script language="javascript">ComComboObject('combo_status',1, 100 , 1,3);</script></td>
							</tr>
						</table>	
						<table class="search" border="0" style="width:474;"> 
							<tr class="h23">
								<td width="75">Invoice DT</td>
								<td width="245"><input name="inv_dt" type="text" style="width:70;" class="input2" dataformat="ymd" readOnly="true">&nbsp;<!-- <img name="btn_inv_dt" src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"> --> </td>
								<td width="52">Due DT</td>
								<td><input name="inv_due_dt" type="text" style="width:75;"  class="input2" dataformat="ymd" readOnly="true">&nbsp; <!-- <img name="btn_due_dt" src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" >-->  </td>
							</tr>
						</table>
						<table class="search" border="0" style="width:474;"> 
							<tr class="h23">
								<td width="75">Currency</td>
								<td width="75"><input name="curr_cd" type="text" style="width:70;" class="input2" readOnly="true"></td>
								<td width="75" align="center">INV Office</td>
								<td width="95"><input name="iss_ofc_cd" type="text" style="width:80;" class="input2" ></td>
								<td width="85">Reference No.</td>
								<td width=""><input name="ref_no" type="text" style="width:65;" class="input"   maxlength="50" dataformat="engup"></td>
							</tr>
						</table>
						<table class="search" border="0" style="width:474;"> 
							<tr class="h23">
								<td width="75">Buyer</td>
								<td width=""><input name="buyer_cd" type="text" style="width:70;" class="input2" readOnly="true">&nbsp;<input name="buyer_nm"  type="text" style="width:226;" class="input2" readOnly="true">&nbsp;<input name="buyer_type" type="text" style="width:90;" class="input2" readOnly="true"></td>
							</tr>
						</table>
						<table class="search" border="0" style="width:474;"> 
							
							<tr class="h23">
								<td width="75">Bank Name</td>
								<td width="225"><input name="bank_nm" type="text" style="width:212;" class="input2" readOnly="true"></td>
								<td width="89">Bank Account</td>
								<td width=""><input name="bank_acct_no" type="text" style="width:80;" class="input2" readOnly="true"></td>
							</tr>
							<tr class="h23">
								<td>Bill to</td>
								<td colspan="5"><input name="mnr_bil_to_nm" type="text" style="width:394;" class="input2" readOnly="true" ></td>
							</tr>
						</table>						
						<table class="search" border="0" style="width:474;"> 
							<tr class="h23">
								<td width="75">INV AMT</td>
								<td width="95"><input name="amt" type="text" style="width:80; text-align:right;" readOnly="true" class="input2" dataformat="float" ></td>
								<td width="60">W.H.Tax</td>
								<td width=""><input name="wht" type="text" style="width:84; text-align:right;" class="input" dataformat="float"></td>
							</tr> 
						</table>
						<table class="search" border="0" style="width:474;">	
							<tr class="h23"> 
								<td width="75">V.A.Tax</td> 
								<td width="95"><input name="vat" type="text" style="width:80; text-align:right;" readOnly="true" class="input2" dataformat="float"></td>
								<td width="60">Tax Rate</td> 	 	 	
								<td width="70"><input name="vat_xch_rt" type="text" style="width:30; text-align:right;" class="input" dataformat="float" pointcount="2"></td>
								<td >EX.Rate <input name="chg_xch_rt" type="text" style="width:60; text-align:right;" class="input" dataformat="float">&nbsp;<script language="javascript">ComComboObject('chg_curr_cd',2, 55 , 0,0);</script></td>
							</tr>		
						</table>  				
						<table class="search" border="0" style="width:474;"> 							
							<tr class="h23">	  
								<td width="75">G.Amount</td>
								<td width="170"><input name="g_amt" type="text" style="width:155; text-align:right;" class="input2" readOnly="true" dataformat="float"></td>
								<td width="75">G.Amount(VAT Only)</td>
								<td><input name="g_vat_curr_amt" type="text" style="width:148; text-align:right;" class="input2" readOnly="true" dataformat="float"></td>
							</tr>		
						</table> 
						<table class="search" border="0" style="width:474;"> 	
							<tr class="h23">
								<td width="75">Remark(s)</td>
								<td><input name="mnr_inv_rmk" type="text" style="width:394;" class="input" maxlength="4000" dataformat="engup"></td>
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
						</td>
					</tr>
				</table>

				<!-- Grid (E) -->			
				</div>
				<!--  Button_Sub (S) -->
				<table width="100%" class="button"> 
		       	<tr><td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0">
					<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Store">Verify</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Del">Row Del</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>

						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_DownExcel">Down Excel</td>
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
		
	

	</td></tr>
		</table>
	

	<table class="height_5"><tr><td colspan="8"></td></tr></table>
	
</form>
</body>
</html>
