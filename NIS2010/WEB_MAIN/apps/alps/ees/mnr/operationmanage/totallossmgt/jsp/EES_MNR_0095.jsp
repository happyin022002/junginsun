<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_mnr_0095.jsp
*@FileTitle : Total Loss Request
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.16
*@LastModifier : WanGyu Kim
*@LastVersion : 1.0
* 2009.09.16 WanGyu Kim
* 1.0 Creation
* --------------------------------------------------------
* 2011.08.09 신혜정 [CHM-201112812-01] TOTAL LOSS REQUEST 시 REASON 옵션 변경 
* 2012.06.26 김창헌 [CHM-201218561-01] 3rd Party 탭에서 SCAC Code를 입력 가능한 조건 추가
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.event.EesMnr0095Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0095Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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
	Logger log = Logger.getLogger("com.hanjin.apps.PlanManage.PlanMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id    =	account.getUsr_id();
		strUsr_nm    = 	account.getUsr_nm(); 
		rhqOfcCd     = 	account.getRhq_ofc_cd();
		currOfcCd    = 	account.getOfc_cd();
		currOfcEngNm = 	account.getOfc_eng_nm();
		
		event = (EesMnr0095Event)request.getAttribute("Event");
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
<input type="hidden" name="file_seq">
<input type="hidden" name="mnr_sts_ref_no">
<input type="hidden" name="work_type" value="request">
<input type="hidden" name="respb_ofc_nm" value=""><!-- 참조로만 저장시 VO 필요없음 -->
<input type="hidden" name="pagerows">
<input type="hidden" name="acc_flg" value="N">
<input type="hidden" name="page_separator"><!-- Total Loss By Accident일 경우 Y -->
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
				<td class="btn1_line"></td>
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
	
		<!--biz page (S)-->
		<!-- 1 (S) -->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			
				<!--  biz_1  (S) -->
				<table class="search" border="0" > 
				<tr class="h23">
					<td width="85">TLL No.</td>
					<td width="160"><input type="text" name="search_ttl_lss_no" style="width:130;text-align:center" class="input1" dataformat="engup" maxlength="20" required>&nbsp;<img name="ttl_lss_no_popup" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
					<input type="hidden" name="ttl_lss_no" class="input2" readOnly="true"></td>
					<td width="115">&nbsp;&nbsp;Responsible&nbsp;OFC</td>
					<td width="115"><input type="text" name="respb_ofc_cd" style="width:80;" class="input1"  maxlength="6" dataformat="engup">&nbsp;<img name="respb_ofc_cd_popup" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
					<td width="70">&nbsp;&nbsp;REQ&nbsp;OFC</td>
					<td width="90"><input type="text" name="rqst_ofc_cd" style="width:80;" class="input2" readOnly="true"></td>
					<td width="45">REQ&nbsp;DT</td>
					<td width="85"><input type="text" name="rqst_dt" style="width:80;text-align:center" class="input2" dataformat="ymd" maxlength="8" readOnly="true">&nbsp;<!-- img name="rqst_dt_cal" src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"--></td>
					<td width="60">Status</td>
					<td width=""><script language="javascript">ComComboObject('ttl_lss_sts_cd', 1, 135, 1, 0);</script></td>
				</tr> 
				</table>
				<table class="search" border="0" > 
				<tr class="h23">
					<td width="87">Main&nbsp;Reason</td>
					<td width="158"><script language="javascript">ComComboObject('ttl_lss_rsn_cd', 1, 100, 1, 1);</script></td>
					<td width="117">&nbsp;&nbsp;Sub&nbsp;Reason</td>
					<td width="113"><script language="javascript">ComComboObject('ttl_lss_dtl_rsn_cd', 1, 100, 1, 0);</script></td>					
					<td width="70">&nbsp;&nbsp;TLL&nbsp;DT</td>
					<td width="221"><input type="text" name="ttl_lss_dt" style="width:80;text-align:center" class="input"  dataformat="ymd" maxlength="8">&nbsp;<img name="ttl_lss_dt_cal" src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
					<td width="60">APP&nbsp;OFC</td>
					<td width="" align="left"><script language="javascript">ComComboObject('apro_ofc_cd', 1, 100, 1, 0);</script></td>					
					</tr> 
				</table>				
				<table class="search" border="0" id = "ByAccident" style='display:none;' > 
				<tr class="h23">
					<td width="85">Accident DT</td>
					<td width="160" align="left"><input type="text" name="acc_dt" style="width:80;text-align:center" class="input1"  dataformat="ymd" maxlength="8">&nbsp;<img name="acc_dt_cal" src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
					<td width="83">&nbsp;&nbsp;VSL</td>
					<td width="147"><input type="text" name="acc_vsl_cd" style="width:40;text-align:center;ime-mode:disabled;" class="input1" value="" maxlength="4" onfocus="this.select();">&nbsp;<input type="text" name="acc_skd_voy_no" style="width:40;text-align:center;ime-mode:disabled;" class="input1" value="" maxlength="4" onfocus="this.select();">&nbsp;<input type="text" name="acc_skd_dir_cd" style="width:25;text-align:center;ime-mode:disabled;" class="input1" value="" maxlength="1" onfocus="this.select();">&nbsp;<img class="cursor" name="btn_vvd_search" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>					
					<td width="69">&nbsp;&nbsp;Port</td>
					<td width=""><input type="text" name="acc_port_cd" style="width:50;text-align:center;ime-mode:disabled;" class="input" value="" maxlength="5" onfocus="this.select();">&nbsp;<img class="cursor" name="btn_port" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
					</tr> 
				</table>	
				<!--  biz_1   (E) -->
			
		</td></tr></table>
		<!-- 1 (E) -->
		
		
		<!-- 3 (S) -->
		<table class="height_8"><tr><td></td></tr></table>	
		
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
				<td>
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
				</td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_t1EQAdd">EQ Add</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					
				    <!-- td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_t1RowAdd">Row Add</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td-->

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
					<td>
						<!--  Total  (S) -->
						<table border="0" width="100%"> 
							<tr>
								<td width="150" align="right"><b>Recovery Plan Total</b>&nbsp;</td>
								<td><input type="text" name="t2RecPlnTotal" style="width:120;text-align:right;" class="input2" dataformat="float" maxlength="13" pointcount="2" caption="실수(최대최소)" readOnly="true"></td>
								<td width="120" align="right"><b>Loss Total</b>&nbsp;</td>
								<td><input type="text" name="t2LossTotal" style="width:120;text-align:right;" class="input2" dataformat="float" maxlength="13" pointcount="2" caption="실수(최대최소)" readOnly="true"></td>
								<td width="110" align="right"><b>Balance Total</b>&nbsp;</td>
								<td><input type="text" name="t2BalanceTotal" style="width:120;text-align:right;" class="input2" dataformat="float" maxlength="13" pointcount="2" caption="실수(최대최소)" readOnly="true"></td>
								<td width="20" align="center"></td>
							</tr> 
						</table>				
						<!--  Total  (E) -->	
					</td> 
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
					<td>
						<!--  Total  (S) -->
						<table border="0" width="100%"> 
							<tr>
								<td width="150" align="right"><b>Recovery Plan Total</b>&nbsp;</td>
								<td><input type="text" name="t3RecPlnTotal" style="width:120;text-align:right;" class="input2" dataformat="float" maxlength="13" pointcount="2" caption="실수(최대최소)" readOnly="true"></td>
								<td width="120" align="right"><b>Loss Total</b>&nbsp;</td>
								<td><input type="text" name="t3LossTotal" style="width:120;text-align:right;" class="input2" dataformat="float" maxlength="13" pointcount="2" caption="실수(최대최소)" readOnly="true"></td>
								<td width="110" align="right"><b>Balance Total</b>&nbsp;</td>
								<td><input type="text" name="t3BalanceTotal" style="width:120;text-align:right;" class="input2" dataformat="float" maxlength="13" pointcount="2" caption="실수(최대최소)" readOnly="true"></td>
								<td width="20" align="center"></td>
							</tr> 
						</table>				
						<!--  Total  (E) -->	
					</td>
				
				    <!--td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_t3RowAdd">Row Add</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td-->
					
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
					<td>
						<!--  Total  (S) -->
						<table border="0" width="100%"> 
							<tr>
								<td width="150" align="right"><b>Recovery Plan Total</b>&nbsp;</td>
								<td><input type="text" name="t4RecPlnTotal" style="width:120;text-align:right;" class="input2" dataformat="float" maxlength="13" pointcount="2" caption="실수(최대최소)" readOnly="true"></td>
								<td width="120" align="right"><b>Loss Total</b>&nbsp;</td>
								<td><input type="text" name="t4LossTotal" style="width:120;text-align:right;" class="input2" dataformat="float" maxlength="13" pointcount="2" caption="실수(최대최소)" readOnly="true"></td>
								<td width="110" align="right"><b>Balance Total</b>&nbsp;</td>
								<td><input type="text" name="t4BalanceTotal" style="width:120;text-align:right;" class="input2" dataformat="float" maxlength="13" pointcount="2" caption="실수(최대최소)" readOnly="true"></td>
								<td width="20" align="center"></td>
							</tr> 
						</table>				
						<!--  Total  (E) -->	
					</td>
					<!-- td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_t4RowAdd">Row Add</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td-->
					
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


<!--TAB Insurance (S) -->
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
					<td>
						<!--  Total  (S) -->
						<table border="0" width="100%"> 
							<tr>
								<td width="150" align="right"><b>Recovery Plan Total</b>&nbsp;</td>
								<td><input type="text" name="t5RecPlnTotal" style="width:120;text-align:right;" class="input2" dataformat="float" maxlength="13" pointcount="2" caption="실수(최대최소)" readOnly="true"></td>
								<td width="120" align="right"><b>Loss Total</b>&nbsp;</td>
								<td><input type="text" name="t5LossTotal" style="width:120;text-align:right;" class="input2" dataformat="float" maxlength="13" pointcount="2" caption="실수(최대최소)" readOnly="true"></td>
								<td width="110" align="right"><b>Balance Total</b>&nbsp;</td>
								<td><input type="text" name="t5BalanceTotal" style="width:120;text-align:right;" class="input2" dataformat="float" maxlength="13" pointcount="2" caption="실수(최대최소)" readOnly="true"></td>
								<td width="20" align="center"></td>
							</tr> 
						</table>				
						<!--  Total  (E) -->	
					</td>
				    <!-- td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_t5RowAdd">Row Add</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td-->
					
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
<!--TAB Insurance (E) -->
		

		<!-- 4 (S) -->
		<table class="height_8"><tr><td></td></tr></table>	
		<table class="search" id="mainTable">
       	<tr><td class="bg" width="100%" valign="top">

			
			<table class="search" border="0">
			<tr><td class="title_h"></td>
				<td class="title_s"> Total Loss History</td></tr>
			<tr><td class="height_5"></td></tr>
			</table>
			
			
			<!-- Grid - 3,4 (S) -->
			<table class="search" width="100%">
			<tr><td width="75%" style="padding-right:20" valign="top">
			

					<!-- Grid - 3  (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
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
							<script language="javascript">ComSheetObject('sheet3');</script>
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
							<td class="btn2" name="btn_FileAdd">File Add</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
							
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_FileDel">File Delete</td>
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
<script language="javascript">ComUploadObject('upload1', '<%=session.getId()%>');</script>

</form>
</body>
</html>