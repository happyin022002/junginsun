<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_2001.jsp
*@FileTitle : DEM/DET Exception - S/C Exception Terms Entryno
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.05.20 이성훈
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
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.event.EesDmt2001Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt2001Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg 	 = "";						//에러메세지
	int rowCount	 	 = 0;						//DB ResultSet 리스트의 건수
	 
	String successFlag 	 = "";
	String codeList   	 = "";
	String pageRows  	 = "100";

	String strUsr_id	 = "";
	String strUsr_nm	 = "";
	String strOfc_cd	 = "";
	String strRhq_ofc_cd = "";
	Logger log 			 = Logger.getLogger("com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt");
	
	String proposalNo 	 = request.getParameter("prop_no") 		!= null ? request.getParameter("prop_no") 	: "" ;
	String scrnAuth 	 = request.getParameter("scrn_auth") 	!= null ? request.getParameter("scrn_auth") : "Y" ;
	String amdtSeq 		 = request.getParameter("amdt_seq") 	!= null ? request.getParameter("amdt_seq") 	: "" ;
	String caller 		 = request.getParameter("caller") 		!= null ? request.getParameter("caller") 	: "" ;
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id 	  = account.getUsr_id();
		strUsr_nm 	  = account.getUsr_nm();
		strOfc_cd 	  = account.getOfc_cd();
		strRhq_ofc_cd = account.getRhq_ofc_cd();
	   
		event = (EesDmt2001Event)request.getAttribute("Event");
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
<title>DEM/DET Exception - S/C Exception Terms Entry</title>
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

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="max_version">
<input type="hidden" name="caller" value="<%= caller %>">
<!-- S/C Exception Tariff 의 Group Seq. 에 대한 하위항목을 조회하기 위한 매개변수 -->
<input type="hidden" name="prop_no">
<input type="hidden" name="sc_expt_ver_seq">
<input type="hidden" name="sc_expt_prev_ver_seq">
<input type="hidden" name="sc_expt_grp_seq">
<!-- Rep.Commodity, Actual Customer, Commodity 조회하기 위한 매개변수 -->
<input type="hidden" name="amdt_seq" value="<%= amdtSeq %>">
<input type="hidden" name="cust_type">
<!-- Common 인지 Rep Commodity 인지를 구분해서 조회하기 위한  매개변수 -->
<input type="hidden" name="prc_cmdt_tp_cd">
<input type="hidden" name="dmdt_expt_ver_sts_cd">
<input type="hidden" name="conti_cd">
<input type="hidden" name="cnt_cd">
<input type="hidden" name="rgn_cd">
<input type="hidden" name="ste_cd">
<input type="hidden" name="loc_cd">
<!-- BKG POR(O) or DEL(I) 에 입력된 CN 의 Continent 와 Coverage 의 Continent 와 비교를 위한 매개변수  -->
<input type="hidden" name="fnl_dest_cnt_cd">
<input type="hidden" name="cust_cnt_cd">
<input type="hidden" name="cust_seq">
<input type="hidden" name="pagerows">
<!-- Calculation Type Check 를 위한 매개변수  -->
<input type="hidden" name="chk_calc_tp_in">
<input type="hidden" name="chk_calc_tp_combined">
<input type="hidden" name="result">
<input type="hidden" name="result_cnt">
<input type="hidden" name="result_ste">
<input type="hidden" name="result_rgn">
<input type="hidden" name="result_loc">
<!-- Rate Adjustment 필수여부를 체크하기 위한  매개변수  -->
<input type="hidden" name="dmdt_trf_cd">
<input type="hidden" name="eff_dt">
<input type="hidden" name="exp_dt">
<input type="hidden" name="dmdt_cntr_cgo_tp_cd">
<!-- 현 팝업화면에 대한 수정권한 변수 -->
<input type="hidden" name="isEditable" value="<%= scrnAuth %>">
<!-- Contract Party 에서 조회된 Customer Seq.-->
<input type="hidden" name="custSeq">
<!-- 2103 화면에서 복사된 정보를 입력할 때, 기존 버전의 상태가 수정일 경우 기존 버전의 정보를 삭제하기 위해 필요한 매개변수 -->
<input type="hidden" name="hist_prop_no">
<input type="hidden" name="sc_expt_hist_ver_seq">
<!-- S/C Duration 정보를 저장하기 위한 매개변수  -->
<input type="hidden" name="sc_eff_dt">
<input type="hidden" name="sc_exp_dt">
<!-- Accept, Accept Cancel 할 수 있는 권한이 있는지 조회를 위한 매개변수 -->
<input type="hidden" name="ofc_cd" value="<%= strOfc_cd %>">
<input type="hidden" name="isAcceptAuth">
<!-- Multi Coverage 조회를 위해서 사용하는 매개변수 -->
<input type="hidden" name="select_row">
<!-- 중복체크를 위해서 사용하는 매개변수 -->
<input type="hidden" name="sc_expt_fm_conti_cd">
<input type="hidden" name="sc_expt_fm_cnt_cd">
<input type="hidden" name="sc_expt_fm_rgn_cd">
<input type="hidden" name="sc_expt_fm_ste_cd">
<input type="hidden" name="sc_expt_fm_loc_cd">
<input type="hidden" name="fnl_dest_rgn_cd">
<input type="hidden" name="fnl_dest_ste_cd">
<input type="hidden" name="fnl_dest_loc_cd">
<input type="hidden" name="rcv_de_term_cd">
<input type="hidden" name="coverage_list">
<input type="hidden" name="act_cust_list">
<input type="hidden" name="cmdt_list">
<input type="hidden" name="max_ver_status">
<input type="hidden" name="max_ver">
<input type="hidden" name="sheet1_cnt">
<input type="hidden" name="sheet2_cnt">
<input type="hidden" name="sheet3_cnt">
<input type="hidden" name="sheet4_cnt">
<input type="hidden" name="sheet5_cnt">
<input type="hidden" name="sheet6_cnt">


<!-- 개발자 작업	-->
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> DEM/DET Exception - S/C Exception Terms Entry</td></tr>
		</table>
	<!--Page Title, Historical (E)-->
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
				
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:965;"> 
				<tr class="h23">
					<td width="50">S/C No.</td>
					<td width="90"><input type="text" name=sCNo style="width:80;" class="input2"></td>
					<td width="80">Proposal No.</td>
					<td width="95"><input type="text" name="proposalNo" style="width:85;" class="input2" value="<%= proposalNo %>"></td>
					<td width="40"><input type="text" name="custTpCd" style="width:30;" class="input2""></td>
					<td width="50">Version</td>
					<td width="60"><select name="version" style="width:50;" class="input" onChange="doActionRetrieveByVer(0)"></td>
					<td width="25">STS</td>
					<td width="110"><input type="text" name="status" style="width:80;" class="input2" value="">&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" onClick="openWinSearchTariffHistory()"></td>
					<td width="100">Contract Party</td>
					<td width=""><input type="text" name="custCd" style="width:65;" class="input2">&nbsp;<input type="text" name="custNm" style="width:200;" class="input2"></td>
					</tr> 
				</table>
				<!--  biz_1  (E) -->
				
				
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
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
				<!--  Button_Sub (S) -->
					<table width="100%" class="button"> 
					<tr>
						<td class="btn2_bg">
							<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
									<div id="btnAddSCLayer" style="display:inline">
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2_1" name="no_btn_AddGroup" id="btn_AddGroup">Row Add</td>
										<td class="btn2_right"></td>
									</tr>
									</table>
									</div>
								</td>
								<td>
									<div id="btnCopySCLayer" style="display:inline">
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2_1" name="no_btn_CopyGroup">Row&nbsp;Copy</td>
										<td class="btn2_right"></td>
									</tr>
									</table>
									</div>
								</td>
								<td>
									<div id="btnSaveSCLayer" style="display:inline">
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2_1" name="no_btn_SaveGroup">Save</td>
										<td class="btn2_right"></td>
									</tr>
									</table>
									</div>
								</td>									
								<td>
									<div id="btnDelSCLayer" style="display:inline">
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2_1" name="no_btn_DelGroup">Delete</td>
										<td class="btn2_right"></td>
									</tr>
									</table>
									</div>
								</td>
								<td>
									<div id="btnDownSCLayer" style="display:inline">
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2_1" name="no_btn_DownExcel">Down Excel</td>
										<td class="btn2_right"></td>
									</tr>
									</table>
									</div>
								</td>
							</tr>
							</table>
						</td>
					</tr>
					</table>
	    							<!-- Button_Sub (E) -->
					<!--  biz_2  (E) -->
				
				
					<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
					<!--  biz_3 (S) -->
					<table class="search" border="0" style="width:965;"> 
					<tr class="h23">
						<td width="275" valign="top">
					
							<table class="search" border="0">
							<tr>
								<td class="title_s"><input type="checkbox" name="chkMultiCoverage" value="" class="trans" disabled>&nbsp;Multi Coverage</td>
							</tr>
							</table>
							
							<!-- Grid  (S) -->
							<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet2');</script>
								</td>
							</tr>
							</table>
							<!-- Grid (E) -->
					
							<!--  Button_Sub (S) -->
							<table width="100%" class="button"> 
	       					<tr>
	       						<td class="btn2_bg">
									<table border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td>
											<div id="btnAddMultiCoverageLayer" style="display:inline">
											<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr>
												<td class="btn2_left"></td>
												<td class="btn2_1" name="no_btn_AddMultiCoverage">Row Add</td>
												<td class="btn2_right"></td>
											</tr>
											</table>
											</div>
										</td>
										<td>
											<div id="btnDelMultiCoverageLayer" style="display:inline">
											<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr>
												<td class="btn2_left"></td>
												<td class="btn2_1" name="no_btn_DelMultiCoverage">Row Delete</td>
												<td class="btn2_right"></td>
											</tr>
											</table>
											</div>
										</td>
									</tr>
									</table>
								</td>
							</tr>
							</table>
	    					<!-- Button_Sub (E) -->
					
					
						</td>
						<td width="15"></td>
						<td width="180" valign="top">
					
					
							<table class="search" border="0">
							<tr>
								<td class="title_s"><input type="checkbox" name="chkFreeTime" value="" class="trans" disabled>&nbsp;Tiered Free Time</td>
							</tr>
							</table>
						
							<!-- Grid  (S) -->
							<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet3');</script>
								</td>
							</tr>
							</table>
							
							<!-- Grid (E) -->
					
							<!--  Button_Sub (S) -->
							<table width="100%" class="button"> 
	       					<tr>
	       						<td class="btn2_bg">
									<table border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td>
											<div id="btnAddFreeTimeLayer" style="display:inline">
											<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr>
												<td class="btn2_left"></td>
												<td class="btn2_1" name="no_btn_AddFreeTime">Row Add</td>
												<td class="btn2_right"></td>
											</tr>
											</table>
											</div>
										</td>
										<td>
											<div id="btnDelFreeTimeLayer" style="display:inline">
											<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr>
												<td class="btn2_left"></td>
												<td class="btn2_1" name="no_btn_DelFreeTime">Row Delete</td>
												<td class="btn2_right"></td>
											</tr>
											</table>
											</div>
										</td>
									</tr>
									</table>
								</td>
							</tr>
							</table>
	    							<!-- Button_Sub (E) -->
					
						</td>
						<td width="15"></td>
						<td width="480" valign="top">
					
						<table class="search" border="0">
						<tr>
							<td class="title_s" width="150"><input type="checkbox" name="chkRateAdjustment" value="" class="trans" onClick="checkRateAdjustment()">&nbsp;Rate Adjustment</td>
							<td>Currency &nbsp;&nbsp;<select name="currency" style="width:60;" class="input" onChange="setCurrencyVal()"></select></td>
						</tr>
						</table>
						
						<!-- Grid  (S) -->
						<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet4');</script>
							</td>
						</tr>
						</table>
						<!-- Grid (E) -->
					
						<!--  Button_Sub (S) -->
						<table width="100%" class="button"> 
	       				<tr>
	       					<td class="btn2_bg">
								<table border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td>
										<div id="btnAddRateAdjustmentLayer" style="display:inline">
										<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn2_left"></td>
											<td class="btn2_1" name="no_btn_AddRateAdjustment">Row Add</td>
											<td class="btn2_right"></td>
										</tr>
										</table>
										</div>
									</td>
									<td>
										<div id="btnDelRateAdjustmentLayer" style="display:inline">
										<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn2_left"></td>
											<td class="btn2_1" name="no_btn_DelRateAdjustment">Row Delete</td>
											<td class="btn2_right"></td>
										</tr>
										</table>
										</div>
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
				
				<!--  biz_3  (E) -->
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				<!--  biz_4 (S) -->
				<table class="search" border="0" style="width:965;"> 
				<tr class="h23">
					<td width="470" valign="top">
					
						<table class="search" border="0">
						<tr>
							<td class="title_h"></td>
						<td class="title_s" width="80">Customer</td><td><select name="customerType" style="width:150;" class="input" onChange="searchCustomerByTypeChange()">  -->
							<option value="Y" selected>Actual Customer</option>
							<option value="N">Affiliate</option>
							</select></td>
						</tr>
						</table>
					
						<!-- Grid  (S) -->
						<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet5');</script>
							</td>
						</tr>
						</table>
						<!-- Grid (E) -->
					
						<!--  Button_Sub (S) -->
						<table width="100%" class="button"> 
	       				<tr>
	       					<td class="btn2_bg">
								<table border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td>
										<div id="btnAddCustomerLayer" style="display:inline">
										<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn2_left"></td>
											<td class="btn2_1" name="no_btn_AddCustomer">Row Add</td>
											<td class="btn2_right"></td>
										</tr>
										</table>
										</div>
									</td>
									<td>
										<div id="btnDelCustomerLayer" style="display:inline">
										<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn2_left"></td>
											<td class="btn2_1" name="no_btn_DelCustomer">Row Delete</td>
											<td class="btn2_right"></td>
										</tr>
										</table>
										</div>
									</td>
								</tr>
								</table>
							</td>
						</tr>
						</table>
	    				
	    				<!-- Button_Sub (E) -->
					</td>
					<td width="15"></td>
					<td width="480" valign="top">
					
					<table class="search" border="0">
					<tr>
						<td class="title_h"></td>
						<td class="title_s">Commodity</td>
					</tr>
					</table>
					
					<!-- Grid  (S) -->
					<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet6');</script>
						</td>
					</tr>
					</table>
					<!-- Grid (E) -->
					
					<!--  Button_Sub (S) -->
					<table width="100%" class="button"> 
	       			<tr>
	       				<td class="btn2_bg">
							<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
									<div id="btnAddCommodityLayer" style="display:inline">
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2_1" name="no_btn_AddCommodity">Row Add</td>
										<td class="btn2_right"></td>
									</tr>
									</table>
									</div>
								</td>
								<td>
									<div id="btnDelCommodityLayer" style="display:inline">
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2_1" name="no_btn_DelCommodity">Row Delete</td>
										<td class="btn2_right"></td>
									</tr>
									</table>
									</div>
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
			<!--  biz_4  (E) -->
		
		</td>
	</tr>
	</table>
<!-- : ( Search Options ) (E) -->

<table class="height_5"><tr><td></td></tr></table>	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr>
	<td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr>
       		<td class="btn3_bg">
		    	<table border="0" cellpadding="0" cellspacing="0">
		    	<tr>
					<td>
						<div id="btnNewLayer" style="display:inline">
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1_1" name="no_btn_New">New</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
						</div>
					</td>
					<td>
						<div id="btnUpdateLayer" style="display:inline">
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1_1" name="no_btn_Update">Update</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
						</div>
					</td>
					<td>
						<div id="btnSaveLayer" style="display:inline">
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1_1" name="no_btn_Request">Request</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
						</div>
					</td>
					<td>
						<div id="btnDeleteLayer" style="display:inline">
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1_1" name="no_btn_Delete">Delete</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
						</div>
					</td>
					<td>
						<div id="btnAcceptLayer" style="display:inline">
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1_1" name="no_btn_Accept">Accept</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
						</div>
					</td>
					<td>
						<div id="btnAcceptCancelLayer" style="display:inline">
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1_1" name="no_btn_AcceptCancel">Accept&nbsp;Cancel</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
						</div>
					</td>
					<td>
						<div id="btnLineLayer" style="display:inline">
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_line"></td>
						</tr>
						</table>
						</div>				
					</td>
					<td width="72">
						<div id="btnCloseLayer" style="display:inline">
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_Close">Close</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
						</div>
					</td>
				</tr>
				</table>
			</td>
		</tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
						
</form>
</body>
</html>