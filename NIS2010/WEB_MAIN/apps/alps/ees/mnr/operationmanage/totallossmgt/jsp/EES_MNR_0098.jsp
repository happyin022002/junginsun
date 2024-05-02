<%/*=========================================================
*Copyright(c) 2009 CyberLogitec 
*@FileName : EES_MNR_0098.jsp
*@FileTitle : Total Loss Collection & Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.28	 
*@LastModifier : 박명신	 
*@LastVersion : 1.0 
* 2009.09.28 박명신 
* 1.0 Creation
* History
* 2011.03.12 김영오 [CHM-201110723-01] Close Type, Close Date 두 개 항목에 대하여  로그인 오피스가 SELCON인 경우에만 활성화 처리 나머지 비활성화 처리
* 2012.03.06 신혜정 [CHM-201216409] 1. 3rd Party 탭 invoice no drop list box 추가(조회결과 invoice no list로 생성)
                                    2. [CHNG INV No] 버튼 추가. 클릭시 invoice no 업데이트
                                    3. [Invoice Preview] 클릭시 invoice no 묶음단위 조회 	
* 2012.04.26 신혜정 [CHM-201217485] 3rd Party, disposal 탭에 [Row Add] 버튼 기능 추가                                    
* 2012.06.26 김창헌 [CHM-201218561-01] 3rd Party 탭에서 SCAC Code를 입력 가능한 조건 추가
* 2015.07.01 이율규 [CHM-201536623] REQUEST OFFICE가 PKGSC 한 적용되는 RD 추가 & Excel Down 기능 추가
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.event.EesMnr0098Event"%>
<%@ page import="org.apache.log4j.Logger" %> 
					   
<% 					
	EesMnr0098Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";  
	String strUsr_nm		= "";   
	String rhqOfcCd         = ""; 
	String currOfcCd       = "";
	String currOfcEngNm     = ""; 
	Logger log = Logger.getLogger("com.hanjin.apps.operationmanage.totallossmgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id    =	account.getUsr_id();
		strUsr_nm    = 	account.getUsr_nm(); 
		rhqOfcCd     = 	account.getRhq_ofc_cd();
		currOfcCd    = 	account.getOfc_cd();
		currOfcEngNm = 	account.getOfc_eng_nm();
		
		event = (EesMnr0098Event)request.getAttribute("Event");
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
	var currOfcCd = "<%=currOfcCd.trim() %>";
	var usrId     = "<%=strUsr_id.trim()%>";
	var rhqOfcCd  = "<%=rhqOfcCd.trim()%>";	
	var currOfcUS = "";
	
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}	
</script>
<script language="javascript">ComSheetObject('sheet1');</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">   
<input type="hidden" name="pagerows">
<input type="hidden" name="work_type" value="collection">  
		
<!-- 기존로직용  --> 	
<input type="hidden" name="log_ofc_cd" value="<%=currOfcCd%>"> 	 
<input type="hidden" name="self_ofc" value="<%=currOfcCd%>">  
<input type="hidden" name="rhq_ofc_cd" value="<%=rhqOfcCd%>"> 	 
<input type="hidden" name="ttl_lss_no" value="">  
<input type="hidden" name="search_ttl_lss_no" value="">    
<input type="hidden" name="rqst_ofc_cd" value="">  
<input type="hidden" name="rqst_dt" value=""> 
<input type="hidden" name="ttl_lss_sts_cd" value="">     
<input type="hidden" name="ttl_lss_dt" value="">   
<input type="hidden" name="apro_ofc_cd" value="">   
<input type="hidden" name="file_seq">   	 
<input type="hidden" name="mnr_sts_ref_no">
<input type="hidden" name="respb_ofc_nm" value=""><!-- 참조로만 저장시 VO 필요없음 -->
<input type="hidden" name="com_mrdArguments">
<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdBodyTitle">
<input type="hidden" name="ttl_lss_cfm_dt">		
<input type="hidden" name="combo_ttl_lss_cmpl_cd">		
<input type="hidden" name="page_separator"><!-- Total Loss By Accident일 경우 Y -->
<input type="hidden" name="acc_flg"><!-- Total Loss By Accident일 경우 Y -->
<input type="hidden" name="ttl_lss_no_tmp" value=""> <!-- Accident Check 후 자동 재조회를 위해 임시로 Total Loss Number를 저장 -->

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
					<td class="btn1" name="btn_Retrieve">Retrieve</td>
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
					<td class="btn1" name="btn_Delete">Delete</td>
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
					<td class="btn1" name="btn_Complete">Complete</td>
					<td class="btn1_right"></td>
					</tr> 
				</table></td>
				</tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->
		
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			
				<!--  biz_1  (S) -->	
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="30%" valign="top">
						<table class="search_" border="0" style="width:295;">
							<tr class="h23">  
								<td width="95"><script language="javascript">ComComboObject('in_search_dt_tp',1, 100 , 1,1)</script></td>	     
								<td width="200">	 	
									<input required type="text" name="in_st_dt" dataformat="ymd"    caption="from date"        maxlength="8"  size="9"  cofield="in_end_dt" value="" class="input1">      
      									~ <input required type="text" name="in_end_dt" dataformat="ymd"    caption="to date"        maxlength="8"  size="9"  cofield="in_st_dt" class="input1">&nbsp;<img name="btn_period" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
								</td>   	 		
							</tr>    	
							<tr class="h23">   
								<td width="95">TLL&nbsp;No.</td>  
								<td width=""><input type="text" name="in_ttl_lss_no" style="width:162;text-align:Left" class="input" dataformat="engup" maxlength="400">&nbsp;<img src="img/btns_multisearch.gif" name="btn_ttl_lss_no_multi"width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
								</td>		
							</tr>	  	   
							<tr class="h23"> 
								<td width="95"><script language="javascript">ComComboObject('in_ofc_cd_tp',1, 100 , 1,1)</script></td>   
								<td width=""><input type="text" name="in_rqst_ofc_cd" style="width:162" value="<%=currOfcCd%>" class="input2" dataformat="engup" readOnly></td>
							</tr>				 
							<tr class="h23"> 
								<td width="95">Status</td>   
								<td width="" style="padding-left:2px;"><script language="javascript">ComComboObject('in_status_tp',1, 100 , 1,1)</script></td>
							</tr>	
							<tr class="h23">	 
								<td width="95">EQ No.</td>			   	 
								<td width=""><input name="in_rqst_eq_no" type="text" style="width:162" class="input" dataformat="engup" value="">&nbsp;<img src="img/btns_multisearch.gif" name="eq_no_multi1" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
							</tr>	
						</table>	
					</td>
					<td width="70%">  
					<!-- Grid  1(S) -->
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%"> 
									<script language="javascript">ComSheetObject('sheet2');</script>
								</td>
							</tr>
						</table>
						<!-- Grid  1(E) -->
					</td>
					</tr> 
				</table>				
				<!--  biz_1   (E) -->
		</td></tr></table>
		
		<table class="height_8"><tr><td></td></tr></table>	
		<!-- 1 (S) -->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="55">TLL&nbsp;No.</td>	
					<td width="145"><input type="text" name="ttl_lss_no_text" style="width:125;text-align:center" class="input2" maxlength="20" readonly></td>
					<td width="105">Responsible&nbsp;OFC</td>
					<td width="140"><input type="text" name="respb_ofc_cd" style="width:100;" class="input"  maxlength="6" dataformat="engup">&nbsp;<img name="respb_ofc_cd_popup" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
					<td width="85">REQ&nbsp;OFC</td>
					<td width="100"><input type="text" name="rqst_ofc_cd_nm" style="width:80;" class="input2" readOnly="true"></td>
					<td width="60">REQ&nbsp;DT</td>
					<td width="100"><input type="text" name="rqst_dt_text" style="width:80;text-align:center" class="input2" dataformat="ymd" readOnly="true"></td>
					<td width="">&nbsp;</td>	
				</tr> 
				</table>
				<table class="search" border="0" style="width:985;"> 
				<tr class="h23">
					<td width="55">Status</td>
					<td width="145"><input type="text" name="ttl_lss_sts_cd_nm" style="width:125;" class="input2" readOnly="true"></td>
					<td width="86">Main Reason</td>
					<td width="150"><script language="javascript">ComComboObject('ttl_lss_rsn_cd', 1, 100, 1, 1);</script></td>
					<td width="90">&nbsp;&nbsp;Sub Reason</td>
					<td width="105"><script language="javascript">ComComboObject('ttl_lss_dtl_rsn_cd', 1, 100, 1, 1);</script></td>					
					<td width="59">TLL DT</td>
					<td width="100"><input type="text" name="ttl_lss_dt_text" style="width:80;text-align:center" class="input2"   readOnly="true">&nbsp;</td>
					<td width="65">APP OFC</td>
					<td width="100"><input type="text" name="apro_ofc_cd_nm" style="width:60;text-align:center" class="input2" readOnly="true"></td>
					<td width="">&nbsp;</td>							
				</tr> 
				</table>
				<table class="search" border="0" id = "ByAccident" style='display:none;' > 
				<tr class="h23">
					<td width="100">Accident DT</td>
					<td width="93" align="left"><input type="text" name="acc_dt" style="width:80;text-align:center" class="input2"  dataformat="ymd" maxlength="8" readOnly="true">&nbsp;</td>
					<td width="50">&nbsp;&nbsp;VSL</td>
					<td width="134"><input type="text" name="acc_vsl_cd" style="width:40;text-align:center;ime-mode:disabled;" class="input2" value="" maxlength="4" onfocus="this.select();" readOnly="true">&nbsp;<input type="text" name="acc_skd_voy_no" style="width:40;text-align:center;ime-mode:disabled;" class="input2" value="" maxlength="4" onfocus="this.select();" readOnly="true">&nbsp;<input type="text" name="acc_skd_dir_cd" style="width:25;text-align:center;ime-mode:disabled;" class="input2" value="" maxlength="1" onfocus="this.select();" readOnly="true">&nbsp;</td>					
					<td width="64">&nbsp;&nbsp;Port</td>
					<td width=""><input type="text" name="acc_port_cd" style="width:50;text-align:center;ime-mode:disabled;" class="input2" value="" maxlength="5" onfocus="this.select();" readOnly="true">&nbsp;</td>
					<td align="right">Total Loss By Accident&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					</tr> 
				</table>				
				<!--  biz_1   (E) -->
			
		</td></tr></table>
		<!-- 1 (E) -->
		
		<!-- 3 (S) -->
		<table class="height_8"><tr><td></td></tr></table>	
		
		<table class="search" border="0" style="width:100%;"> 
		<tr class="h23">
		<td width="50%" valign="top">
	
		<!-- Tab (S) -->
   		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%>
     		<tr><td width="100%">
					<script language="javascript">ComTabObject('tab1')</script>
					<!-- img src="img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
				</td></tr>
		</table>
		<!-- Tab (E) -->

		<!--TAB D.V Expense (S) -->
		<div id="tabLayer" style="display:inline">
		
				<table class="search" id="mainTable">
		       		<tr><td class="bg">
		
					<!-- Grid - 2 (S) -->
						<table width="100%"  id="mainTable">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('t1sheet1');</script>
								</td>
							</tr>
						</table>
					<!-- Grid - 2 (E) -->
		
					
		
					<!--  Button_Sub (S) -->
					<table width="100%" class="button">
			       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_t1ChangeInvNo">Chng Inv No</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>							
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_t1InvoicePreview">Invoice Preview</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>						
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_t1RowDel">Row Delete</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
							
							</tr></table>
					</td></tr>
					</table>
			    	<!-- Button_Sub (E) -->
		
					</td></tr>
				</table>
				<!-- 3 (E) -->
		
		</div>
		<!--TAB D.V Expense (E) -->
		
		
		<!--TAB 3rd Party (S) -->
		<div id="tabLayer" style="display:none">
		
				<table class="search" id="mainTable"> 
		       		<tr><td class="bg">	
		
					<!-- Grid - 2 (S) -->
						<table width="100%"  id="mainTable">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('t2sheet1');</script>
								</td>
							</tr>
						</table>
					<!-- Grid - 2 (E) -->	
		
							
					
					<!--  Button_Sub (S) -->
					<table width="100%" class="button"> 
			       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_t2ChangeInvNo">Chng Inv No</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>													
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_t2InvoicePreview">Invoice Preview</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_t2RowAdd">Row Add</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td> 							
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_t2RowDel">Row Delete</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
							
							</tr></table>
					</td></tr>
					</table>
			    	<!-- Button_Sub (E) -->
					
					</td></tr>
				</table>
				<!-- 3 (E) -->
		
		</div>
		<!--TAB 3rd Party (E) -->
		
		
		<!--TAB Disposal (S) -->
		<div id="tabLayer" style="display:none">
		
				<table class="search" id="mainTable"> 
		       		<tr><td class="bg">	
		
					<!-- Grid - 2 (S) -->
						<table width="100%"  id="mainTable">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('t3sheet1');</script>
								</td>
							</tr>
						</table>
					<!-- Grid - 2 (E) -->	
		
				
					<!--  Button_Sub (S) -->
					<table width="100%" class="button"> 
			       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_t3ChangeInvNo">Chng Inv No</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>													
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_t3InvoicePreview">Invoice Preview</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
						    <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_t3RowAdd">Row Add</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>							
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_t3RowDel">Row Delete</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
							
							</tr></table>
					</td></tr>
					</table>
			    	<!-- Button_Sub (E) -->
					
					</td></tr>
				</table>
				<!-- 3 (E) -->
		
		</div>
		<!--TAB Disposal (E) -->
		
		
		<!--TAB Scrapping (S) -->
		<div id="tabLayer" style="display:none">
		
				<table class="search" id="mainTable"> 
		       		<tr><td class="bg">	
		
					<!-- Grid - 2 (S) -->
						<table width="100%"  id="mainTable">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('t4sheet1');</script>
								</td>
							</tr>
						</table>
					<!-- Grid - 2 (E) -->	
		
				
					
					<!--  Button_Sub (S) -->
					<table width="100%" class="button"> 
			       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_t4InvoicePreview">Invoice Preview</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>							
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_t4RowDel">Row Delete</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
							
							</tr></table>
					</td></tr>
					</table>
			    	<!-- Button_Sub (E) -->
					
					</td></tr>
				</table>
				<!-- 3 (E) -->
		
		</div>
		<!--TAB Scrapping (E) -->
		
		
		<!--TAB Insurance(TT Club) (S) -->
		<div id="tabLayer" style="display:none">
		
				<table class="search" id="mainTable"> 
		       		<tr><td class="bg">	
		
					<!-- Grid - 2 (S) -->
						<table width="100%"  id="mainTable">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('t5sheet1');</script>
								</td>
							</tr>
						</table>
					<!-- Grid - 2 (E) -->	
		
					
					
					<!--  Button_Sub (S) -->
					<table width="100%" class="button"> 
			       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr> 
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_t5InvoicePreview">Invoice Preview</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>							
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_t5RowDel">Row Delete</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td> 
							
							</tr></table>
					</td></tr>
					</table> 
			    	<!-- Button_Sub (E) -->
					
					</td></tr>
				</table>
				<!-- 3 (E) -->
		
		</div>
		<!--TAB Insurance(TT Club) (E) -->
		</td>  
		 	
		<td width="2%">&nbsp;</td>
		<td width="48%">   
		<table class="search" id="mainTable">
       	<tr><td class="bg" width="100%" valign="top" style="padding-top:15;"> 
		<table class="search" border="0">
			<tr><td class="title_h"></td>
				<td class="title_s"> Total Loss Collection &amp; Adjustment</td></tr>
		</table>
		<!-- Grid 4 (S) -->
		 <table width="100%"  id="mainTable"> 
			<tr>
				<td width="100%">
					<script language="javascript">ComSheetObject('sheet3');</script>
				</td>
			</tr>
		</table>
		<!-- Grid 4(E) -->		
		
		<!--  Button_Sub (S) -->
		<table width="100%" class="button" border=0>  
       	<tr><td class="btn2_bg">
			<table border="0" cellpadding="0" cellspacing="0"><tr class="h23">
					<td><table border="0"> 
						<tr>
							<td  align="right"><nobr><b>Collection Total</b>&nbsp; </nobr></td>
							<td><input type="text" name="tCollectionTotal" style="width:120;text-align:right;" class="input2" dataformat="float" maxlength="13" pointcount="2" caption="실수(최대최소)" readOnly="true"></td>
							<td width=20></td>
						</tr> 
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_Col_Add">Row Add</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_Col_Delete">Row Delete</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td> 
				</tr></table>
		</td></tr>
		</table>
		</td>	
		</tr></table>
		</td>	
		</tr></table>
		<table class="height_8"><tr><td></td></tr></table>	
		<!-- 1 (S) -->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
				<!--  Total  (S) -->
				<table border="0" width="100%"> 
					<tr>
						<td width="150" align="right"><b>Recovery Plan Total</b>&nbsp;</td>
						<td><input type="text" name="t1RecPlnTotal" style="width:120;text-align:right;" class="input2" dataformat="float" maxlength="13" pointcount="2" caption="실수(최대최소)" readOnly="true"></td>
						<td width="120" align="right"><b>Loss Total</b>&nbsp;</td>
						<td><input type="text" name="t1LossTotal" style="width:120;text-align:right;" class="input2" dataformat="float" maxlength="13" pointcount="2" caption="실수(최대최소)" readOnly="true"></td>
						<td width="110" align="right"><b>Balance Total</b>&nbsp;</td>
						<td><input type="text" name="t1BalanceTotal" style="width:120;text-align:right;" class="input2" dataformat="float" maxlength="13" pointcount="2" caption="실수(최대최소)" readOnly="true"></td>
						<td width="20" align="center"></td>
					</tr> 
				</table>				
				<!--  Total  (E) -->	
		</td></tr></table>
		<!-- 1 (E) -->
		<!-- 4 (S) -->
		<table class="height_8"><tr><td></td></tr></table>	
		<table class="search" id="mainTable">
       	<tr><td class="bg" width="100%" valign="top">
			<table class="search" border="0">
			<tr><td class="title_h"></td>
				<td class="title_s"> Total Loss History</td></tr>
			</table>
			
			
			<!-- Grid - 3,4 (S) -->
			<table class="search" width="100%">
			<tr><td width="75%" style="padding-right:20" valign="top">
			

					<!-- Grid - 3  (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet4');</script>
						</td>
					</tr>
				</table>
					<!-- Grid - 3 (E) -->	

					<!--  Button_Sub (S) -->
					<table width="100%" class="button"> 
			       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_RowAdd2">Row Add</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
							
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_RowDel2">Row Delete</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
							
							
							</tr></table>
					</td></tr>
					</table>
			    	<!-- Button_Sub (E) -->

				</td>
				<td width="25%" valign="top">
					
					<!-- Grid - 4 - Evidence Attached (S) -->
				<table width="100%"  id="mainTable">
					<tr> 
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet5');</script>
						</td> 
					</tr>
				</table>
					<!-- Grid - 4 - Evidence Attached (E) -->
					

					<!--  Button_Sub (S) -->
					<table width="100%" class="button"> 
			       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_FileAdd">Row Add</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
							
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_FileDel">Row Delete</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
							
							</tr></table>
					</td></tr>
					</table>
			    	<!-- Button_Sub (E) -->
				
				</td></tr>
			</table>	
			<!-- Grid - 3,4 (E) -->

		
		</td></tr>
		</table>		
		<!-- 4 (E) -->		
			
		
		<!--biz page (E)-->

	
	
	</td></tr>
		</table>
	

	<table class="height_10"><tr><td colspan="8"></td></tr></table>
<script language="javascript">ComUploadObject('upload1', '<%=session.getId()%>',0,0);</script>

</form>
</body>
</html>