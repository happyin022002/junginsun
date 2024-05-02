<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_2003.jsp
*@FileTitle : DEM/DET Adjustment Request - Before Booking Request
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
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.event.EesDmt2003Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt2003Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id	 = "";
	String strUsr_nm	 = "";
	String strOfc_cd	 = "";
	String strRhq_ofc_cd = "";
	Logger log = Logger.getLogger("com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt");
	
	String proposalNo 	= request.getParameter("prop_no") 		!= null ? request.getParameter("prop_no") 		: "" ;
	String scrnAuth 	= request.getParameter("scrn_auth") 	!= null ? request.getParameter("scrn_auth") 	: "Y" ;
	String amdtSeq 		= request.getParameter("amdt_seq") 		!= null ? request.getParameter("amdt_seq") 		: "" ;	
	String caller 		= request.getParameter("caller") 		!= null ? request.getParameter("caller") 		: "" ;

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id 	  = account.getUsr_id();
		strUsr_nm 	  = account.getUsr_nm();
		strOfc_cd 	  = account.getOfc_cd();
		strRhq_ofc_cd = account.getRhq_ofc_cd();
	   
		event = (EesDmt2003Event)request.getAttribute("Event");
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
<title>DEM/DET Adjustment Request - Before Booking Request</title>
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
<input type="hidden" name="caller" value="<%= caller %>">
<!-- Actual Customer 조회하기 위한 매개변수 -->
<input type="hidden" name="prop_no">
<input type="hidden" name="amdt_seq" value="<%= amdtSeq %>">
<input type="hidden" name="cust_seq">
<input type="hidden" name="cust_cnt_cd">
<input type="hidden" name="rfa_expt_dar_no">
<input type="hidden" name="rfa_expt_mapg_seq">
<input type="hidden" name="rfa_expt_ver_seq">
<input type="hidden" name="rfa_expt_prev_ver_seq">
<input type="hidden" name="rfa_rqst_dtl_seq">
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
<input type="hidden" name="ofc_cd" 		value="<%= strOfc_cd %>">
<input type="hidden" name="rhq_ofc_cd" 	value="<%= strRhq_ofc_cd %>">
<!-- Calculation Type Check 를 위한 매개변수  -->
<input type="hidden" name="chk_calc_tp_in">
<input type="hidden" name="dmdt_ctrt_expt_tp_cd" value="B">
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
<!-- 2105 화면에서 복사된 정보를 입력할 때, 기존 버전의 상태가 수정일 경우 기존 버전의 정보를 삭제하기 위해 필요한 매개변수 -->
<input type="hidden" name="rfa_expt_hist_dar_no">
<input type="hidden" name="rfa_expt_hist_mapg_seq">
<input type="hidden" name="rfa_expt_hist_ver_seq">
<!-- Approval, Counter Offer, Reject 시 메일을 전송하기 위해서 사용되는 매개변수 -->
<input type="hidden" name="rfa_expt_apro_no">
<input type="hidden" name="rfa_no">
<input type="hidden" name="cust_cd">
<input type="hidden" name="cust_nm">
<!-- Multi Origin or Dest. 조회를 위해서 사용하는 매개변수 -->
<input type="hidden" name="select_row">
<!-- 중복체크를 위해서 사용하는 매개변수 -->
<input type="hidden" name="dmdt_cntr_tp_cd">
<input type="hidden" name="dmdt_cgo_tp_cd">
<input type="hidden" name="cvrg_cnt_cd">
<input type="hidden" name="cvrg_rgn_cd">
<input type="hidden" name="cvrg_ste_cd">
<input type="hidden" name="cvrg_loc_cd">
<input type="hidden" name="fnl_dest_rgn_cd">
<input type="hidden" name="fnl_dest_ste_cd">
<input type="hidden" name="fnl_dest_loc_cd">
<input type="hidden" name="act_cust_seq">
<input type="hidden" name="act_cust_cnt_cd">
<input type="hidden" name="coverage_list">
<input type="hidden" name="max_ver_status">
<input type="hidden" name="max_ver">
<input type="hidden" name="dar_no_check">
<input type="hidden" name="ft_use_flg">
<!-- APVL No. 로 조회된 결과를 저장하기 위해서 사용하는 매개변수 -->
<input type="hidden" name="apvlno_ofc">
<input type="hidden" name="apvlno_dar">
<input type="hidden" name="apvlno_ver">
<input type="hidden" name="sheet1_cnt">
<input type="hidden" name="sheet2_cnt">
<input type="hidden" name="sheet3_cnt">
<!-- Basic RFA 인지 여부를 보여줍니다. -->
<input type="hidden" name="bzc_rfa_yn">
<input type="hidden" name="mst_rfa_ver_uppr_yn">
<!-- BBE( Before Booking Exception ) 등록여부 -->
<input type="hidden" name="exist_rfa_yn">
<input type="hidden" name="mst_prop_no">
<input type="hidden" name="bzc_prop_no">
<input type="hidden" name="cpy_tp_cd">

<!-- 개발자 작업	-->
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="5" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">

	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> DEM/DET Adjustment Request - Before Booking Request</td></tr>
		</table>
	<!--Page Title, Historical (E)-->
		
		<!-- : ( Search Options ) (S) -->
 
		<table class="search"> 
      	<tr>
      		<td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="50">RFA No.</td>
					<td width="110"><input type="text" name="rFANo" style="width:90;" class="input2"></td>
					<td width="80">Proposal No.</td>
					<td width="130"><input type="text" name="proposalNo" style="width:90;" class="input2" value="<%= proposalNo %>" dataformat="engup">&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" onClick="openWinSearchRFA()"></td>
					<td width="110">DAR History&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" onClick="openWinSearchDARHistory()"></a></td>
					<td width="60">Customer</td>
					<td width="312"><input type="text" name="custCd" style="width:70;" class="input2">&nbsp;<input type="text" name="custNm" style="width:230;" class="input2"></td>
					<td>
						<table width="100" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn2_left"></td>
							<td class="btn2" name="btn_Affiliate">Affiliate</td>
							<td class="btn2_right"></td>
						</tr>
						</table>
					</td>
				</tr>
				</table>
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="60">APVL OFC</td>
					<td width="100"><select name="approvalOfcCd" style="width:80;" class="input1" onChange="doActionRetrieveByApprovalOfc()">
						<option value=""></option>
						<option value="NYCRA">NYCRA</option>
						<option value="HAMRU">HAMRU</option>
						<option value="SHARC">SHARC</option>
						<option value="SELIB">SELIB</option>
						<option value="TYOIB">TYOIB</option>
						<option value="SINRS">SINRS</option>
						<option value="VVOIA">VVOIA</option>
						<option value="SELHO">SELHO</option>
						<option value="PHXSA">PHXSA</option>
						</select></td>
					<td width="55">DAR No.</td>
					<td width="155"><script language="javascript">ComComboObject('combo1', 1, 140, 1, 0, 0, true)</script></td>
					<td width="47">Version</td>
					<td width="65"><select name="version" style="width:50;" class="input" onChange="doActionRetrieveByVerChange()"></select></td>
					<td width="60">APVL No.</td>
					<td width="140"><script language="javascript">ComComboObject('combo2', 1, 135, 1, 0, 0, true)</script></td>
					<td width="45">Status</td>
					<td width="125"><input type="text" name="status" style="width:117;" class="input2"></td>
					<td>&nbsp;</td>
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
				<!--  Button_Sub (S) -->
				<table width="100%" class="button"> 
				<tr>
					<td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td>
								<div id="btnAddRFALayer" style="display:inline">
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td class="btn2_left"></td>
									<td class="btn2_1" name="no_btn_AddBKGReqDetail">Row Add</td>
									<td class="btn2_right"></td>
								</tr>
								</table>
								</div>
							</td>
							<td>
								<div id="btnCopyRFALayer" style="display:inline">
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td class="btn2_left"></td>
									<td class="btn2_1" name="no_btn_CopyBKGReqDetail">Row&nbsp;Copy</td>
									<td class="btn2_right"></td>
								</tr>
								</table>
								</div>
							</td>
							<td>
								<div id="btnSaveRFALayer" style="display:inline">
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td class="btn2_left"></td>
									<td class="btn2_1" name="no_btn_SaveBKGReqDetail">Save</td>
									<td class="btn2_right"></td>
								</tr>
								</table>
								</div>
							</td>							
							<td>
								<div id="btnDelRFALayer" style="display:inline">
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td class="btn2_left"></td>
									<td class="btn2_1" name="no_btn_DelBKGReqDetail">Delete</td>
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
				<table class="height_10">
				<tr>
					<td></td>
				</tr>
				</table>
				<!--  biz_3  (S) -->
				
				<!--  biz_4  (S) -->
				<table class="search" border="0">
				<tr>
					<td width="680" valign="top">

						<!--  biz_5  (S) -->
						<table class="search" border="0" style="width:965;"> 
						<tr class="h23">
							<td width="480" valign="top">
							<!--  biz_5_1  (S) -->
								<table class="search">
								<tr class="h23">
							    	<td class="title_s" width="205"><input type="checkbox" name="chkMultiOrgDest" class="trans" disabled>Multi Origin or Destination</td>
								</tr> 
								</table>
								<table class="search" border="0" style="width:370;"> 
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
									
										<!--  Button_Sub (S) -->
										<table width="100%" class="button"> 
	       								<tr>
	       									<td class="btn2_bg">
												<table border="0" cellpadding="0" cellspacing="0">
												<tr>
													<td>
														<div id="btnAddMultiOrgDestLayer" style="display:inline">
														<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td>
															<td class="btn2_1" name="no_btn_AddMultiOrgDest">Row&nbsp;Add</td>
															<td class="btn2_right"></td>
														</tr>
														</table>
														</div>
													</td>
													<td>
														<div id="btnDelMultiOrgDestLayer" style="display:inline">
														<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn2_left"></td>
															<td class="btn2_1" name="no_btn_DelMultiOrgDest">Row&nbsp;Delete</td>
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
					
					<!--  biz_5_1  (E) -->
					</td>
					<td width="19">&nbsp;&nbsp;&nbsp;</td>
					<td width="470" valign="top">
					<!--  biz_5_2  (S) -->
						<table class="search">
						<tr class="h23">
							<td class="title_s" width="205"><input type="checkbox" name="chkRateAdjustment" class="trans"  onClick="checkRateAdjustment()">Rate Adjustment</td>
							<td>
								<table class="search" border="0">
								<tr class="h23">
									<td width="60">Currency</td>
									<td width=""><select name="currency" style="width:80;" class="input" onChange="setCurrencyVal()"></select></td>
								</tr> 
								</table>
							</td>
						</tr> 
						</table>
						<table class="search" border="0" style="width:580;"> 
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
								<!--  Button_Sub (S) -->
								<table width="100%" class="button"> 
       							<tr>
       								<td class="btn2_bg">
										<table border="0" cellpadding="0" cellspacing="0">
										<tr>
											<td>
												<div id="btnAddAdjustmentLayer" style="display:inline">
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr>
													<td class="btn2_left"></td>
													<td class="btn2_1" name="no_btn_AddRateAdjustment">Row&nbsp;Add</td>
													<td class="btn2_right"></td>
												</tr>
												</table>
												</div>
											</td>
											<td>
												<div id="btnDelAdjustmentLayer" style="display:inline">
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr>
													<td class="btn2_left"></td>
													<td class="btn2_1" name="no_btn_DelRateAdjustment">Row&nbsp;Delete</td>
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
					
					<!--  biz_5_2  (E) -->
					</td>
				</tr> 
				</table>
		
				<!--  biz_5  (E) -->
				<table class="height_8"><tr><td></td></tr></table>		

				<!--  biz_6  (S) -->
				<table class="search" border="0" style="width:965;"> 
				<tr class="h23">
					<td width="480" valign="top">
						<!--  biz_6_1  (S) -->
						<table class="search">
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
					<td width="470" valign="top">
					<!--  biz_6_2  (S) -->
						<table class="search">
						<tr class="h23">
							<td class="title_s"><input type="checkbox" name="chkComment" class="trans" onClick="checkComment()">Comment </td>
						</tr>
						</table>
						<table class="grid2" width="470">
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
<table class="height_5"><tr><td></td></tr></table>
<!-- : ( Search Options ) (E) -->
</td></tr>
</table> 



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
							<td class="btn1_1" name="no_btn_Update" id="no_btn_Update">Update</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
						</div>
					</td>
					<td>
						<div id="btnRequestLayer" style="display:inline">
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
						<div id="btnCancelLayer" style="display:inline">
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1_1" name="no_btn_Cancel">Cancel</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
						</div>
					</td>
					<td>
						<div id="btnApprovalLayer" style="display:inline">
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1_1" name="no_btn_Approval">Approval</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
						</div>
					</td>
					<td>
						<div id="btnCounterOfferLayer" style="display:inline">
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1_1" name="no_btn_CounterOffer">Counter Offer</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
						</div>
					</td>
					<td>
						<div id="btnRejectLayer" style="display:inline">
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1_1" name="no_btn_Reject">Reject</td>
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
					<td>
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
    <!--Button (E) -->
			</td>
		</tr>
		</table>
	</td>
</tr>
</table>
<!-- : ( Button : pop ) (E) -->
<div id="topdeck" style="position:absolute;visibility:hidden;z-index:200;"></div>

</form>			
</body>
</html>