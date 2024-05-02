<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_S041.jsp
*@FileTitle : MNR Invoice Creation & Correction
*Open Issues :     
*Change history :  
*@LastModifyDate : 2009.08.17
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2009.08.17 함형석
* 1.0 Creation    
* --------------------------------------------------------
* 2011.10.24 신혜정 [CHM-201114131-01] SPP Portal - invoice creation 화면 날짜입력 로직 보완  
=========================================================*/
%> 


<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.mnr.accountmanage.expensemgt.event.EesMnrS041Event" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnrS041Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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
	String strVndr_seq		= "";
	String strVndr_nm		= "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		strRhq_ofc_cd  = account.getRhq_ofc_cd();
		strVndr_seq = account.getOfc_eng_nm();
		strVndr_nm 	= account.getOfc_krn_nm();
		
		
		event = (EesMnrS041Event)request.getAttribute("Event");
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
<title>Invoice Creation & Correction_Work</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--MNR 공용 사용  -->       
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
<input type="hidden" name="mnr_grp_tp_cd">
<input type="hidden" name="iss_ofc_cd" value="<%=strOfc_cd%>">
<input type="hidden" name="inv_rgst_no">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	
        <!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		    <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">Invoice Creation & Correction</td></tr>
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
				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Request">Request</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				</tr>
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
						<table class="search" border="0" style="width:180;" align="left"> 
							<tr class="h23">
								<td width="35">KIND</td>
								<td width="120">
								<script language="javascript">ComComboObject('combo1',1, 120 , 1,1);</script>
								</td></tr>
						</table>
<!-- Select Tab [ Web Import ] (S) -->
<div id="selectLayer" style="display:none">
						
						<table class="search" border="2" style="width:100%;"> 
							<tr class="h23">
								<td width="80">Req. Date</td>
								<td width="">
								<input name="t1_from_dt" type="text" style="width:99" class="input" dataformat="ymd">&nbsp;~&nbsp;
								<input name="t1_to_dt" type="text" style="width:99" class="input" dataformat="ymd">&nbsp;<img name="btn_t1_calendar" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
							</tr>
							<tr class="h23">
								<td>INV No.</td>
								<td><input name="t1_mnr_ord_seq" type="text" style="width:221;" dataformat="engup" >&nbsp;<img name="btn_t1_req_multy" src="img/btns_multisearch.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
							</tr>
							<tr class="h23">
								<td>S/Provider</td>
								<td>
								<input type="text" name="t1_vndr_seq" style="width:57;text-align:center" class="input2" readOnly="true" value="<%=strVndr_seq %>">&nbsp;
								<input type="text" name="t1_vndr_lgl_eng_nm" style="width:152" class="input2" readOnly="true" value="<%=strVndr_nm %>">
								</td>
							</tr>
						</table>						
						<table height="10"><tr><td></td></tr></table>
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
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn_t1_Clear">New</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn_t1_DetailRetrieve">Detail&nbsp;Retrieve</td>
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
								<td width="80">W/O Date</td>
								<td width="">
								<input name="t2_from_dt" type="text" style="width:80" class="input" dataformat="ymd">&nbsp;~&nbsp;
								<input name="t2_to_dt" type="text" style="width:80" class="input" dataformat="ymd">&nbsp;<img name="btn_t2_calendar" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
							</tr>
							<tr class="h23">
								<td>W/O No.</td>
								<td><input name="t2_mnr_ord_seq" type="text" style="width:182;" dataformat="engup" >&nbsp;<img name="btn_t2_req_multy" src="img/btns_multisearch.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
							</tr>
							<tr class="h23">
								<td>S/Provider</td>
								<td><input type="text" name="t2_vndr_seq" style="width:50;text-align:center" class="input2" value="<%=strVndr_seq %>" readOnly="true">
								<input type="text" name="t2_vndr_lgl_eng_nm" style="width:150" class="input2" readOnly="true" value="<%=strVndr_nm %>">
								</td>
							</tr>
						</table>						
						<table height="10"><tr><td></td></tr></table>
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
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn_t2_Clear">New</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn_t2_DetailRetrieve">Detail&nbsp;Retrieve</td>
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
								<td width="80">INV Date</td>
								<td width="" >
								<input name="t3_from_dt" type="text" style="width:80" class="input" dataformat="ymd">&nbsp;~&nbsp;
								<input name="t3_to_dt" type="text" style="width:80" class="input" dataformat="ymd">&nbsp;<img name="btn_t3_calendar" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
							</tr>
							<tr class="h23">
								<td>INV No.</td>
								<td ><input name="t3_mnr_ord_seq" type="text" style="width:182;" dataformat="engup" >&nbsp;<img name="btn_t3_req_multy" src="img/btns_multisearch.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
							</tr>
							<tr class="h23">
								<td>S/Provider</td>
								<td>
								<input type="text" name="t3_vndr_seq" style="width:50;text-align:center" class="input2" value="<%=strVndr_seq %>" readOnly="true">
								<input type="text" name="t3_vndr_lgl_eng_nm" style="width:150" class="input2" readOnly="true" value="<%=strVndr_nm %>">
								</td>
							</tr>
						</table>						
						<table height="10"><tr><td></td></tr></table>
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
							<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn_t3_Clear">New</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
							    <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn_t3_DetailRetrieve">Detail&nbsp;Retrieve</td>
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
					
					<td width="" valign="top" style="padding-left:15;" width="500">
					
						<table class="search" border="0">
						<tr><td class="title_h"></td>
							<td class="title_s">Invoice Information</td></tr>
						</table>
						<!--  biz_2 (S) -->
						<table class="search" border="0" style="width:100%;"> 
							<tr class="h23">
								<td width="80">Inv. No.</td>
								<td width="200"><input name="inv_no" type="text" style="width:110;" maxlength="20" class="input1" dataformat="engup" ></td>
								<td width="75" align="center">Inv. Status</td>
								<td width=""><input name="inv_status" type="text" style="width:90;" class="input2" readOnly="true">
											<script language="javascript">ComComboObject('combo2',1, 0 , 1,3);</script></td>
							</tr>
						</table>	
						<table class="search" border="0" style="width:100%;"> 
							<tr class="h23">
							<td width="80">Issue DT</td>
								<td width="200"><input name="iss_dt" type="text" style="width:85;"  class="input1" dataformat="ymd">&nbsp;<img name="btn_isu_dt" src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
							
								<td width="75">Request DT</td>
								<td>
									<input name="rcv_dt" type="text" style="width:90;" class="input1" dataformat="ymd">&nbsp;<img name="btn_rcv_dt" src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
								</td>
								</tr>
						</table>
						<table class="search" border="0" style="width:100%;"> 
							<tr class="h23">
								<td width="80">W/O S/P</td>
								<td width="240"><input name="ord_vndr_seq" type="text" style="width:80;" class="input2" readOnly="true">&nbsp;<input name="ord_vndr_seq_nm" type="text" style="width:140;" class="input2" readOnly="true"></td>
								<td width="68" >INV Office</td>
								<td width=""><input name="agmt_ofc_cd" type="text" style="width:80;" class="input2" readOnly="true"></td>
							</tr>
						</table>
						<table class="search" border="0" style="width:100%;"> 
							<tr class="h23">
								<td width="80">Pay S/P</td>
								<td width=""><input required  type="text" name="mnr_prnr_seq" caption="Service Provider" style="width:55;text-align:left;" class="input1" value="" dataformat="engup" maxlength="6">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btn_vndr" width="19" height="20" border="0" align="absmiddle">&nbsp;<input type="text" name="vndr_nm" caption="Service Provider" style="width:147;" class="input2" value="" readonly>							  
								</td>
																
							</tr>
						</table>
						<table class="search" border="0" style="width:100%;"> 
							
							<tr class="h23">
								<td width="80">Currency</td>
								<td width="240"><input name="curr_cd" type="text" style="width:80;" class="input2" readOnly="true"></td>
								<td width="68">Pay Term</td>
								<td width=""><input name="gen_pay_term_cd" type="text" style="width:80; text-align:right;" class="input2" readOnly="true"></td>
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
								<td width="95">V.A.Tax</td>
								<td width="95"><input name="vat_amt" type="text" style="width:70; text-align:right;" class="input" dataformat="float"></td>
								<td width="75">Sales Tax</td>	
								<td width="95"><input name="sls_tax_amt" type="text" style="width:80; text-align:right;" class="input" dataformat="float"></td>
								<td width="60">W.H.Tax</td>
								<td width=""><input name="whld_tax_amt" type="text" style="width:86; text-align:right;" class="input" dataformat="float"></td>
							</tr>
							<tr class="h23" id="sbcTax" style='display:none;' >
								<td width="95">SBC Tax</td>
								<td width=""><input name="env_chg_tax" type="text" style="width:70; text-align:right;" class="input" dataformat="float"></td>
							</tr>								
							<tr class="h23">					
								<td width="95">Remark</td>	
								<td colspan="5"><input name="mnr_inv_rmk" type="text" style="width:100%;" class="input" maxlength="4000"></td>
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
						<script language="javascript">ComSheetObject('sheet3');</script>	
						</td>
					</tr>
				</table>

				<!-- Grid (E) -->			
				</div>
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
						<td class="btn2" name="btn_Del">Row&nbsp;Del</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_RepairDetail">Repair&nbsp;Detail</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_DownExcel">Down&nbsp;Excel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_LoadExcel">Load&nbsp;Excel</td>
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
	

	<table class="height_10"><tr><td colspan="8"></td></tr></table>
	
</form>
</body>
</html>
