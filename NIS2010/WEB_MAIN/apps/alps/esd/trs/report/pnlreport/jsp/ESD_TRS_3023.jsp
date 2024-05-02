<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TRS_3023.jsp
*@FileTitle : Profit & Loss report for Europe Inland Biz
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
===============================================================================
 History
 2012.07.17 변종건 [CHM-201217633] Profit & Loss Report for Europe Inland BIZ 생성
 2012.08.24 변종건 [CHM-201219884-01] TRS - P&L REPORT 기능 추가 보완
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.bizcommon.util.BizComUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.report.pnlreport.event.EsdTrs3023Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdTrs3023Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id	= "";
	String strUsr_nm	= "";
	String strRhq_ofc_cd= "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strRhq_ofc_cd  = account.getRhq_ofc_cd();

		event = (EsdTrs3023Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String transModeCdOut  = JSPUtil.getCodeCombo("f_rhq_cd" , "01", "style='width:120'", "CD00961", 0, "000010:ALL:ALL");
%>
<html>
<head>
<title>Profit & Loss report for Europe Inland BIZ</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">

	<%=JSPUtil.getIBCodeCombo("f_rhq_cd" , "", "CD00961", 0, "")%>
	<%=BizComUtil.getIBCodeCombo("po_local_curr_cd", "01", "CURR", 2, "")%>
	
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form  name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="s_fm_date" value="">
<input type="hidden" name="s_to_date" value="">
<input type="hidden" name="s_svc_scp" value="">
<input type="hidden" name="s_cust_tp" value="">
<input type="hidden" name="s_pnl_div" value="">
<input type="hidden" name="s_pnl_tp" value="">
<input type="hidden" name="s_rev_tp" value="">
<input type="hidden" name="s_rd_term" value="">
<input type="hidden" name="s_search" value="">
<input type="hidden" name="s_param" value="">

<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;padding-right:5;">
	<tr>
		<td valign="top">
			<!--Page Title, Historical (S)-->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
			<!--Page Title, Historical (E)-->
	
	    	<!--Button (S) -->
	        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
		        <tr>
			        <td class="btn1_bg">
			            <table border="0" cellpadding="0" cellspacing="0">
				            <tr>
				                <td>
				                	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					                    <tr>
						                    <td class="btn1_left"></td>
						                    <td class="btn1" name="btn_retrieve">Retrieve</td>
						                    <td class="btn1_right"></td>
					                    </tr>
				                	</table>
				                </td>
				                <td>
				                	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					                    <tr>
						                    <td class="btn1_left"></td>
						                    <td class="btn1" name="btn_new">New</td>
						                    <td class="btn1_right"></td>
					                    </tr>
				                	</table>
				                </td>
				                <td>
				                	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					                    <tr>
						                    <td class="btn1_left"></td>
						                    <td class="btn1" name="btn_downexcel">Down Excel</td>
						                    <td class="btn1_right"></td>
					                    </tr>
				                	</table>
				                </td>
				            </tr>
			            </table>
			        </td>
		        </tr>
	        </table>
	    	<!--Button (E) -->
    	
			<!--biz page (S)-->
			<table class="search"> 
	       		<tr>
	       			<td class="bg">
						<!-- biz_1  (S) -->
						<table class="search" border="0" style="width:979;">
							<tr class="h23">
								<td class="sm">
									<table border="0" class="sm">
										<tr class="h23">
											<td width="40"></td>
											<td width="60">View</td>
											<td width="">
												<input type="radio" value="S" name="r_view" class="trans" onClick="javascript:chkView('S');" checked>&nbsp;Sales View&nbsp;&nbsp;
												<input type="radio" value="O" name="r_view" class="trans" onClick="javascript:chkView('O');">&nbsp;Operation View
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			
			<table class="height_8"><tr><td></td></tr></table>
			
			<table class="search"> 
	       		<tr>
	       			<td class="bg">
						<!-- biz_1  (S) -->
						<table class="search" border="0" style="width:979;">
							<tr class="h23">
								<td class="sm">
									<table border="0" class="sm">
										<tr class="h23">
											<td width="40"><input type="radio" value="P" name="r_prd_bkg_div" class="trans" onClick="javascript:chkOptTp('P');" checked></td>
											<td width="60" style="background-color: #E9E9E9;">W/M</td>
											<td width="250" style="background-color: #E9E9E9;">
												<input type="radio" value="W" name="f_chkprd" class="trans" onClick="javascript:chkWM('W');">&nbsp;Week&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												<input type="radio" value="M" name="f_chkprd" class="trans" onClick="javascript:chkWM('M');" checked>&nbsp;Month
											</td>
											<td width="40" class="sm" style="background-color: #E9E9E9;">Year</td>
											<td width="60" style="background-color: #E9E9E9;">
												<input type="text" dataformat="num" style="width:40;text-align:center;" class="input1" name="f_year" maxlength="4" style="ime-mode:disabled" onBlur="if(this.value!=''){setPeriod(this);}">
											</td>
											<td width="40" class="sm" style="background-color: #E9E9E9;"><div id="div_wm">Month</td>
											<td width="100" style="background-color: #E9E9E9;">
												<input type="text" dataformat="num" style="width:30;text-align:center;" class="input1" name="i_fm_wm" maxlength="2" style="ime-mode:disabled" onBlur="if(this.value!=''){setPeriod(this);}">&nbsp;&nbsp;~&nbsp;
												<input type="text" dataformat="num" style="width:30;text-align:center;" class="input1" name="i_to_wm" maxlength="2" style="ime-mode:disabled" onBlur="if(this.value!=''){setPeriod(this);}">
											</td>
											<td width="150" class="sm" style="background-color: #E9E9E9;"><div id="div_period"></div></td>
											<td width="110"></td>
											<td width=""><input type="checkbox" name="c_xcld_ofc" value="Y" class="trans" checked>Excluding AARBA</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td>
									<div id="div_sales_view" style="display:inline">
										<table border="0">
											<tr class="h23">
												<td width="40"></td>
												<td width="140">Contract Office Code</td>
												<td width="255" style="background-color: #E9E9E9;">
													<input type="text" name="s_ctrt_ofc_cd1" dataformat="engup" style="width:80;" maxlength="6">
													<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_ctrt_office1">&nbsp;
													<input type="checkbox" name="c_ctrt_sub_ofc1" value="Y" class="trans" onClick="javascript:chkSubOfc(this);">Incl. Sub OFC
												</td>
												<td width="90">Service Scope</td>
												<td width="105"><script language="javascript">ComComboObject('combo_svc_scp', 1, 55, 1)</script></td>
												<td width="110">W/O Office Code</td>
												<td width="">
													<input type="text" name="s_wo_ofc_cd1" dataformat="engup" style="width:80;" maxlength="6">
													<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_wo_office1">&nbsp;
													<input type="checkbox" name="c_wo_sub_ofc1" value="Y" class="trans" onClick="javascript:chkSubOfc(this);">Incl. Sub OFC
												</td>
											</tr>
										</table>
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<div id="div_operation_view" style="display:none">
										<table border="0">
											<tr class="h23">
												<td width="40"></td>
												<td width="140">W/O Office Code</td>
												<td width="305">
													<input type="text" name="s_wo_ofc_cd2" dataformat="engup" style="width:80;" maxlength="6">
													<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_wo_office2">&nbsp;
													<input type="checkbox" name="c_wo_sub_ofc2" value="Y" class="trans" onClick="javascript:chkSubOfc(this);">Incl. Sub OFC
												</td>
												<td width="45">Bound</td>
												<td width="80">
													<select name="s_io_bnd_cd" style="width:45;">
														<option value="" selected>All</option>
														<option value="I">In</option>
														<option value="O">Out</option>
													</select>
												</td>
												<td width="130">Contract Office Code</td>
												<td width="" style="background-color: #E9E9E9;">
													<input type="text" name="s_ctrt_ofc_cd2" dataformat="engup" style="width:80;" maxlength="6">
													<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_ctrt_office2">&nbsp;
													<input type="checkbox" name="c_ctrt_sub_ofc2" value="Y" class="trans" onClick="javascript:chkSubOfc(this);">Incl. Sub OFC
												</td>
										</table>
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<table border="0">
										<tr class="h23">
											<td width="40"></td>
											<td width="140">Customer Type</td>
											<td width="305"><script language="javascript">ComComboObject('combo_cust_tp', 1, 105, 1)</script></td>
											<td width="90">Customer</td>
											<td width="">
												<input type="text" name="s_cust_cd" dataformat="engupnum" style="width:115;" maxlength="8">
												<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_customer">
												<input type="text" name="s_cust_nm" style="width:250;" class="input2" readOnly>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td>
									<table border="0">
										<tr class="h23">
											<td width="40"></td>
											<td width="255"><script language="javascript">ComComboObject('combo_pnl_div', 1, 245, 1)</script></td>
											<td width="190"><script language="javascript">ComComboObject('combo_pnl_tp', 1, 160, 1)</script></td>
											<td width="92">Revenue Type</td>
											<td width="165"><script language="javascript">ComComboObject('combo_rev_tp', 1, 110, 1)</script></td>
											<td width="80">R/D Term</td>
											<td width=""><script language="javascript">ComComboObject('combo_rd_term', 1, 80, 1)</script></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>	
						<!-- biz_1  (E) -->
					</td>
				</tr>
			</table>
			
			<table class="height_8"><tr><td></td></tr></table>
			
			<table class="search"> 
	       		<tr>
	       			<td class="bg">
						<!-- biz_1  (S) -->
						<table class="search" border="0" style="width:979;">
							<tr class="h23">
								<td class="sm">
									<table border="0" class="sm">
										<tr class="h23">
											<td width="40"><input type="radio" value="B" name="r_prd_bkg_div" class="trans" onClick="javascript:chkOptTp('B');"></td>
											<td width="140">Booking No</td>
											<td width="307"><input type="text" name="s_bkg_no" dataformat="engupnum" style="width:105;" maxlength="13"></td>
											<td width="90">RFA No</td>
											<td width=""><input type="text" name="s_rfa_no" dataformat="engupnum" style="width:110;" maxlength="11"></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
					
			<table class="height_8"><tr><td></td></tr></table>

			<table class="search"> 
				<tr>
					<td class="bg" style="height:315" valign="top">
						<div id="sheetLayer" style="display:inline">
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
						
						<div id="sheetLayer" style="display:none">
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
					       	<tr>
						       	<td class="btn2_bg">
									<table border="0" cellpadding="0" cellspacing="0">
										<tr>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_detail">Go to Detail</td>
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
		</td>
	</tr>
</table>

<div id="tabLayer" style="display:none">
	<table class="search" id="mainTable"> 
      	<tr><td class="bg">	
			<table width="100%"  id="mainTable">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet3');</script>
					</td>
				</tr>
			</table>
		</td></tr>
	</table>
</div>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>