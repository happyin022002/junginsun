<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0918.jsp
*@FileTitle : surcharge 입력/수정/삭제화면
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.21
*@LastModifier :  최 선
*@LastVersion : 1.2
* 2006.11.09 조풍연
* 1.0 최초 생성
*----------------------------------------------------------
* History
* 2009.03.17 양봉준    1.1 [N200902240180] [TRS] TPB 대상 건 I/F 가능 시점 추가 요청
* 2010.12.21  최 선	1.2 [CHM-201007798] [TRS] W/O Addional 상 항목추가 요청
* 2012.05.08 김종호 [CHM-201217449] [TRS] Additional 칼럼, Other S/O creation 화면 입력기능 일부 변경
=========================================================*/
--%> 

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.invoicemanage.surchargeinputinquiry.event.EsdTrs0918Event"%>
<%@ page import="com.hanjin.bizcommon.util.BizComUtil"%>
<%
	EsdTrs0918Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수

	try {
		event = (EsdTrs0918Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}

	String unique_cd			= JSPUtil.getNull(request.getParameter("unique_cd"));
	String open_mode			= JSPUtil.getNull(request.getParameter("open_mode")); //input/modify/search/multiple
	String step_cd				= JSPUtil.getNull(request.getParameter("step_cd"));
	String ofc_cty_cd			= JSPUtil.getNull(request.getParameter("ofc_cty_cd"));
	String so_seq				= JSPUtil.getNull(request.getParameter("so_seq"));
	String main_row				= JSPUtil.getNull(request.getParameter("main_row"));
	String rate					= JSPUtil.getNull(request.getParameter("rate"));
	String cal_logic			= JSPUtil.getNull(request.getParameter("cal_logic")); // TM(곱하기)/DV(나누기)
	String sheet_arr_no			= JSPUtil.getNull(request.getParameter("sheet_arr_no"));//bySheet일경우 parent의 surcharge sheet array no
	String curr_cd				= JSPUtil.getNull(request.getParameter("curr_cd"));
	String inv_etc_add_amt		= JSPUtil.getNull(request.getParameter("inv_etc_add_amt"));
	String cgo_tp_cd			= JSPUtil.getNull(request.getParameter("cgo_tp_cd"));
	String agmt_flg				= JSPUtil.getNull(request.getParameter("agmt_flg"));
//	String chasis_type_size		= BizComUtil.getCodeCombo("chasis_type_size", "", " disabled ", "CHASSIS", 1, "0::"); 
//	String chasis_drayage_type_size = BizComUtil.getCodeCombo("chasis_drayage_type_size", "", " disabled ", "CHASSIS", 1, "0::"); 
	String getset_tp_sz			= BizComUtil.getCodeCombo("getset_tp_sz", "", " disabled ", "GENSET", 1, "0::"); 

	String multi_ofc_cty_cdStr	= "";
	String multi_so_seqStr		= "";
	String multi_cgo_tp_cdStr	= "";
	String check_rowStr			= "";

	//부모창 sheetObjects[3] 에서 추출해온 금액 단위 값 
	String weightUnitParam		= JSPUtil.getNull(request.getParameter("weightUnitParam"));
	
	if(cgo_tp_cd != null && cgo_tp_cd.equals("F")) cgo_tp_cd = "C";
	else cgo_tp_cd = "M";
%>
<html>
<head>
<title>Surcharge Input</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
<%
	if("multiple".equals(open_mode)){
		multi_ofc_cty_cdStr		= request.getParameter("multi_ofc_cty_cd");
		multi_so_seqStr			= request.getParameter("multi_so_seq");
		multi_cgo_tp_cdStr		= request.getParameter("multi_cgo_tp_cd");
		check_rowStr			= request.getParameter("check_row");

%>
	var multi_ofc_cty_cdStr		= '<%=StringUtil.xssFilter(multi_ofc_cty_cdStr)%>';
	var multi_ofc_cty_cdArray	= multi_ofc_cty_cdStr.split('|');
	var multi_so_seqStr			= '<%=StringUtil.xssFilter(multi_so_seqStr)%>';
	var multi_so_seqArray		= multi_so_seqStr.split('|');
	var multi_cgo_tp_cdStr		= '<%=StringUtil.xssFilter(multi_cgo_tp_cdStr)%>';
	var multi_cgo_tp_cdArray	= multi_cgo_tp_cdStr.split('|');
	var check_rowStr			= '<%=StringUtil.xssFilter(check_rowStr)%>';
	var check_rowArray			= check_rowStr.split('|');

<%
	}
%>

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if

		loadPage();
	}
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type='hidden' name='curr_cd' value='<%=curr_cd%>'>
<input type='hidden' name='unique_cd' value='<%=unique_cd%>'>
<input type='hidden' name='open_mode' value='<%=open_mode%>'>
<input type='hidden' name='step_cd' value='<%=step_cd%>'>
<input type='hidden' name='ofc_cty_cd' value='<%=ofc_cty_cd%>'>
<input type='hidden' name='so_seq' value='<%=so_seq%>'>
<input type='hidden' name='main_row' value='<%=main_row%>'>
<input type='hidden' name='rate' value='<%=rate%>'>
<input type='hidden' name='cal_logic' value='<%=cal_logic%>'>
<input type='hidden' name='sheet_arr_no' value='<%=sheet_arr_no%>'>
<input type='hidden' name='inv_etc_add_amt' value='<%=inv_etc_add_amt%>'>
<input type='hidden' name='prefix' value='surcharge_'>
<input type='hidden' name='cgo_tp_cd' value='<%=cgo_tp_cd%>'>
<input type='hidden' name='agmt_flg' value='<%=agmt_flg%>'>
<input type='hidden' name='weightUnitParam' value='<%=weightUnitParam%>'>

<!-- OUTER - POPUP (S)tart -->
<table width="1050" class="popup" cellpadding="10" border="0">
	<tr><td class="top"></td></tr>
	<tr>
		<td valign="top">
	
	
			<!-- : ( Title ) (S) -->
			<table width="100%" border="0">
			<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp; Surcharge</td></tr>
			</table>
			<!-- : ( Title ) (E) -->
	
			<!-- : ( Search Options ) (S) -->
			<table class="search"  width="100%"  border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td class="bg">
						<table width="100%"  border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td valign="top">
									<table  class="search" border="0" style="width:100%;" cellpadding="0" cellspacing="0">
										<tr class="h23" id='SCALAL_01'>
											<td width="24%"><input name="SCALAL_chk" type="checkbox" onClick='setCheckedForm(this)' class="trans">Additional Labor</td>
											<td width="8%"><input name="SCALAL_txt" type="text" maxlength=11 class="input2"  style="width:75; text-align:right" onChange='getSumTotalAmount(this)' disabled></td>
											<td width="68%">
												<table class="h23" id='SCALAL_02'>
													<tr>
														<td>&nbsp;</td>
														<td>&nbsp;</td>
													</tr>
												</table>
											</td>
										</tr>
										<tr class="h23" id='SCLWAL_01'>
											<td><input name="SCLWAL_chk" type="checkbox" onClick='setCheckedForm(this)' class="trans">
												<font title="Barge Low Water,Winter,Congestion,Canal Fee" style="cursor:hand;" >Seasonal Surcharge</font></td>
											<td><input name="SCLWAL_txt" type="text" maxlength=11 class="input2" style="width:75; text-align:right" onChange='getSumTotalAmount(this)' disabled></td>
											<td >
												<table class="h23" id='SCLWAL_02'>
													<tr>
														<td>&nbsp;</td>
														<td>&nbsp;</td>
													</tr>
												</table>
											</td>
										</tr>
										<tr class="h23" id='SCCDAL_01'>
											<td><input name="SCCDAL_chk" type="checkbox" onClick='setCheckedForm(this)' class="trans">Chassis Drayage </td>
											<td><input name="SCCDAL_txt" type="text" maxlength=11 class="input2" style="width:75; text-align:right" onChange='getSumTotalAmount(this)' disabled></td>
											<td>
												<table>
													<tr class="h23" id='SCCDAL_02'>
														<td >Chassis No.</td>
														<td >&nbsp;<input name="chss_no" type="text" maxlength="11" class="input2" style="width:100;" disabled></td>
														<td>&nbsp;&nbsp;&nbsp;Incurred Date</td>
														<td>&nbsp;
															<input name="incur_dt" type="text" class="input2" style="width:100;" onBlur='checkIncurredDate(this)' disabled maxlength=8>
															<img class="cursor" img src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar2">
														</td>	
													</tr>
												</table>
											</td>
										</tr>
										<tr class="h23" id='SCDPAL_01'>
											<td ><input name="SCDPAL_chk" type="checkbox" onClick='setCheckedForm(this)' class="trans">Drop&amp;Pull(Drop&amp;Pick up/Bob tail) </td>
											<td ><input name="SCDPAL_txt" type="text" maxlength=11 class="input2" style="width:75; text-align:right" onChange='getSumTotalAmount(this)' disabled></td>
											<td>
												<table>
													<tr class="h23" id='SCDPAL_02'>
														<td >&nbsp;</td>
														<td >&nbsp;</td>
													</tr>
												</table>
											</td>
										</tr>
										<tr class="h23" id='SCDRAL_01'>
											<td><input name="SCDRAL_chk" type="checkbox" onClick='setCheckedForm(this)' class="trans">Dry Run</td>
											<td ><input name="SCDRAL_txt" type="text" maxlength=11 class="input2" style="width:75; text-align:right" onChange='getSumTotalAmount(this)' disabled></td>
											<td>
												<table>
													<tr class="h23" id='SCDRAL_02'>
														<td>Liable Party </td>
														<td class="sm">
															<input type="radio" class="trans" name='reliable_party' value='HJ' disabled>
															SML &nbsp;&nbsp;&nbsp;&nbsp;
															<input type="radio" class="trans" name='reliable_party' value='CS' disabled>Customer
														</td>
												</table>
											</td>	
										</tr>
										<tr class="h23" id='SCFRAL_01'>
											<td><input name="SCFRAL_chk" type="checkbox" onClick='setCheckedForm(this)' class="trans">Ferry Cost</td>
											<td><input name="SCFRAL_txt" type="text" maxlength=11 class="input2" style="width:75; text-align:right" onChange='getSumTotalAmount(this)' disabled></td>
											<td>
												<table>
													<tr class="h23" id='SCFRAL_02'>
														<td>&nbsp;</td>
														<td>&nbsp;</td>
													</tr>
												</table>
											</td>
										</tr>
										<tr class="h23"  id='SCFIAL_01'>
											<td><input name="SCFIAL_chk" type="checkbox" onClick='setCheckedForm(this)' class="trans">Fine </td>
											<td><input name="SCFIAL_txt" type="text" maxlength=11 class="input2" style="width:75; text-align:right" onChange='getSumTotalAmount(this)' disabled></td>
											<td>
												<table>
													<tr class="h23" id='SCFIAL_02'>
														<td width=60>Cause </td>
														<td>&nbsp;&nbsp;&nbsp;<input name="cause" type="text" class="input2" style="width:200;" disabled></td>
													</tr>
												</table>
											</td>	
										</tr>
										<tr class="h23" id='SCFGAL_01'>
											<td><input name="SCFGAL_chk" type="checkbox" onClick='setCheckedForm(this)' class="trans">Fumigation / Cleaning</td>
											<td ><input name="SCFGAL_txt" type="text" maxlength=11 class="input2" style="width:75; text-align:right" onChange='getSumTotalAmount(this)' disabled></td>
											<td>
												<table>
													<tr class="h23" id='SCFGAL_02'>
														<td >Cost</td>
														<td span class="sm">
															<input type="radio" class="trans" name='cost_rdo' value='FE' disabled>SCFGAL + Extra Drayage
															<input type="radio" class="trans" name='cost_rdo' value='ED' disabled>Drayage Only
															<input type="radio" class="trans" name='cost_rdo' value='FC' disabled>Cleaning 
														</td>
													</tr>
												</table>
											</td>
										</tr>
										<tr class="h23" id='SCGNAL_01'>
											<td><input name="SCGNAL_chk" type="checkbox" onClick='setCheckedForm(this)' class="trans">Reefer</td>
											<td><input name="SCGNAL_txt" type="text" maxlength=11 class="input2" style="width:75; text-align:right" onChange='getSumTotalAmount(this)' disabled></td>
											<td>
												<table>
													<tr class="h23" id='SCGNAL_02'>
														<td ><input type="checkbox" name='flg_reefer_hd' class="trans" disabled>Handling</td>
														<td><input type="checkbox" name='flg_reefer_gs' class="trans" disabled>Gen-Set Usage</TD> 	
														<td>&nbsp;&nbsp;&nbsp;Gen-Set Type/Size <%=getset_tp_sz%></td>
													</tr>
												</table>
											</td>
										</tr>
										<tr class="h23" id='SCHZAL_01'>
											<td><input name="SCHZAL_chk" type="checkbox" onClick='setCheckedForm(this)' class="trans">HAZMAT(DG)</td>
											<td><input name="SCHZAL_txt" type="text" maxlength=11 class="input2" style="width:75; text-align:right" onChange='getSumTotalAmount(this)' disabled></td>
											<td>
												<table>
													<tr class="h23" id='SCHZAL_02'>
														<td>&nbsp;</td>
														<td>&nbsp;</td>
													</tr>
												</table>
											</td>
										</tr>
										<tr class="h23" id='SCINAL_01'>
											<td><input name="SCINAL_chk" type="checkbox" onClick='setCheckedForm(this)' class="trans">
												Inspection</td>
											<td ><input name="SCINAL_txt" type="text" maxlength=11 class="input2" style="width:75; text-align:right" onChange='getSumTotalAmount(this)' disabled></td>
											<td>
												<table>
													<tr class="h23" id='SCINAL_02'>
														<td width="100%"><input type="radio" class="trans" name='reefer_rdo' value='RP' disabled>
															Reefer PTI &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
															<input type="radio" class="trans" name='reefer_rdo' value='CS' disabled>
															Customs
														</td>
													</tr>
												</table>
											</td>		
										</tr>
										<tr class="h23" id='SCLFAL_01'>
											<td><input name="SCLFAL_chk" type="checkbox" onClick='setCheckedForm(this)' class="trans">Lifting Charge</td>
											<td ><input name="SCLFAL_txt" type="text" maxlength=11 class="input2" style="width:75; text-align:right" onChange='getSumTotalAmount(this)' disabled></td>
											<td>
												<table>
													<tr class="h23" id='SCLFAL_02'>
														<td width="28%">Number Of Lifting</td>
														<td width="34%" class="sm" ><input name="number_lifting" type="text" class="input2" style="width:100;" disabled>&nbsp;Lift(s)</td>
														<td width="9%" >&nbsp;Cause </td>
														<td><input name="number_cause" type="text" class="input2" style="width:100%;" disabled></td>
													</tr>
												</table>
											</td>
										</tr>
										<tr class="h23" id='SCMDAL_01'>
											<td><input name="SCMDAL_chk" type="checkbox" onClick='setCheckedForm(this)' class="trans">Multiple Delivery</td>
											<td ><input name="SCMDAL_txt" type="text" maxlength=11 class="input2" style="width:75; text-align:right" onChange='getSumTotalAmount(this)' disabled></td>
											<td>
												<table>
													<tr class="h23" id='SCMDAL_02'>
														<td>Stop Location </td>
														<td>
															<table class="search" border="0" style="width:100%;">
																<tr class="h23">
																	<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name="stop_loc" type="text" class="input2" style="width:100;" name='stop_loc' onBlur='getComboList(this)' onKeyup='enterCheck(this)' maxlength=5 disabled></td>
																	<td>&nbsp;<script language="javascript">ComComboObject('stop_yard', 1, 60, 0);</script></td>
																	<td>&nbsp;<img class="cursor" img src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_stop_loc"></td>
																</tr>
															</table>
														</td>
													</tr>
												</table>
											</td>
										</tr>
										<tr class="h23" id='SCOSAL_01'>
											<td><input name="SCOSAL_chk" type="checkbox" onClick='setCheckedForm(this)' class="trans">Over Size(OOG) </td>
											<td><input name="SCOSAL_txt" type="text" maxlength=11 class="input2" style="width:75; text-align:right" onChange='getSumTotalAmount(this)' disabled></td>
											<td>
												<table>
													<tr class="h23" id='SCOSAL_02'>
														<td>&nbsp;</td>
														<td>&nbsp;</td>
													</tr>
												</table>
											</td>
										</tr>
										<tr class="h23" id='SCOWAL_01'>
											<td><input name="SCOWAL_chk" type="checkbox" onClick='setCheckedForm(this)' class="trans">Over Weight</td>
											<td><input name="SCOWAL_txt" type="text" maxlength=11 class="input2" style="width:75; text-align:right" onChange='getSumTotalAmount(this)' disabled></td>
											<td>
												<table class="search" border="0" style="width:100%;">
													<tr class="h23" id='SCOWAL_02'>
														<td style="width:70;"><input name="flg_tri_axle" type="checkbox"  class="trans" disabled>Tri-axle</td>
														<td>Gross Weight
															<input name="gross_weight" type="text" style="width:80;" disabled> 
															<select name="weightUnit" class="input2" disabled>
																<option value="LBS">LBS</option>
																<option value="KGS">KGS</option>
															</select>
															
															&nbsp;&nbsp;<input name="flg_permit" type="checkbox" class="trans" disabled>Permit/Handling
															
															&nbsp;&nbsp;<input name="flg_others" type="checkbox" class="trans" disabled>Others
															&nbsp;Remarks&nbsp;<input name="gross_weight_rmk" type="text" class="input2" disabled>
														</td>
														<td></td>
													</tr>
												</table>
											</td>
										</tr>
										<tr class="h23" id='SCPPAL_01'>
											<td><input name="SCPPAL_chk" type="checkbox" onClick='setCheckedForm(this)' class="trans">Pre -Pull </td>
											<td><input name="SCPPAL_txt" type="text" maxlength=11 class="input2" style="width:75; text-align:right" onChange='getSumTotalAmount(this)' disabled></td>
											<td>
												<table>	
													<tr class="h23" id='SCPPAL_02'>
														<td >Incurred Date </td>
														<td >
															&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name="incurred_date" type="text" class="input2" style="width:100;" onBlur='checkIncurredDate(this)' disabled maxlength=8>
															<img class="cursor" img src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar">
														</td>
													</tr>
												</table>
											</td>
										</tr>
										<tr class="h23" id='SCRCAL_01'>
											<td><input name="SCRCAL_chk" type="checkbox" onClick='setCheckedForm(this)' class="trans">Redirection Charge</td>
											<td ><input name="SCRCAL_txt" type="text" maxlength=11 class="input2" style="width:75; text-align:right" onChange='getSumTotalAmount(this)' disabled></td>
											<td>
												<table>
													<tr class="h23" id='SCRCAL_02'>
														<td>&nbsp;</td>
														<td>&nbsp;</td>
													</tr>
												</table>
											</td>
										</tr>
										<tr class="h23" id='SCSSAL_01'>
											<td><input name="SCSSAL_chk" type="checkbox" onClick='setCheckedForm(this)' class="trans">Scale Stop</td>
											<td><input name="SCSSAL_txt" type="text" maxlength=11 class="input2" style="width:75; text-align:right" onChange='getSumTotalAmount(this)' disabled></td>
											<td>
												<table>
													<tr class="h23" id='SCSSAL_02'>
														<td>Scale Stop Place</td>
														<td>
															<table class="search" border="0" style="width:100%;">
																<tr class="h23">
																	<td >
																		&nbsp;<input name="scale_loc" type="text" class="input2" style="width:100;" name='stop_loc' onBlur='getComboList(this)' onKeyup='enterCheck(this)' maxlength=5 disabled>
																	</td>
																	<td >
																		&nbsp;<script language="javascript">ComComboObject('scale_yard', 1, 60, 0);</script>
																	</td>
																	<td>
																		&nbsp;<img class="cursor" img src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_scale_loc">
																	</td>
																</tr>
															</table>
														</td>
													</tr>
												</table>
											</td>
										</tr>
										<tr class="h23" id='SCSRAL_01'>
											<td><input name="SCSRAL_chk" type="checkbox" onClick='setCheckedForm(this)' class="trans">Storage </td>
											<td><input name="SCSRAL_txt" type="text" maxlength=11 class="input2" style="width:75; text-align:right" onChange='getSumTotalAmount(this)' disabled></td>
											<td>
												<table>
													<tr class="h23" id='SCSRAL_02'>
														<td class="sm" ><input name="days" type="text" class="input2" style="width:100;" maxlength='6' disabled>&nbsp;Day (s)</td>
													</tr>
												</table>
											</td>
										</tr>
										<tr class="h23" id='SCSTAL_01'>
											<td><input name="SCSTAL_chk" type="checkbox" onClick='setCheckedForm(this)' class="trans">Street Turn </td>
											<td><input name="SCSTAL_txt" type="text" maxlength=11 class="input2" style="width:75; text-align:right" onChange='getSumTotalAmount(this)' disabled></td>
											<td>
												<table>
													<tr class="h23" id='SCSTAL_02'>
														<td width="50%">Outbound Booking No.</td>
														<td width="50%"><input name="outbound_booking_no" type="text" class="input2" style="width:100%;" disabled></td>
													</tr>
										       </table>
										    </td>
										</tr>
										<tr class="h23" id='SCSNAL_01'>
											<td><input name="SCSNAL_chk" type="checkbox" onClick='setCheckedForm(this)' class="trans"> Weekend / Holiday</td>
											<td><input name="SCSNAL_txt" type="text" maxlength=11 class="input2" style="width:75; text-align:right" onChange='getSumTotalAmount(this)' disabled></td>
											<td>
												<table>
													<tr class="h23" id='SCSNAL_02'>
														<td width="">&nbsp;</td>
														<td width="">&nbsp;</td>
													</tr>
												</table>
											</td>
										</tr>
										<tr class="h23" id='SCSFAL_01'>
											<td><input name="SCSFAL_chk" type="checkbox" onClick='setCheckedForm(this)' class="trans">
												Swing / Flip </td>
											<td ><input name="SCSFAL_txt" type="text" maxlength=11 class="input2" style="width:75; text-align:right" onChange='getSumTotalAmount(this)' disabled></td>
											<td>
												<table>
													<tr class="h23" id='SCSFAL_02'>
														<td width="">&nbsp;</td>
														<td width="">&nbsp;</td>
													</tr>
												</table>
											</td>	
										</tr>
										<tr class="h23" id='SCTDAL_01'>
											<td><input name="SCTDAL_chk" type="checkbox" onClick='setCheckedForm(this)' class="trans">
												T-DOC Fee </td>
											<td ><input name="SCTDAL_txt" type="text" maxlength=11 class="input2" style="width:75; text-align:right" onChange='getSumTotalAmount(this)' disabled></td>
											<td>
												<table>
													<tr class="h23" id='SCTDAL_02'>
														<td width="">&nbsp;</td>
														<td width="">&nbsp;</td>
													</tr>
												</table>
											</td>
										</tr>
										<tr class="h23" id='SCTLAL_01'>
											<td><input name="SCTLAL_chk" type="checkbox" onClick='setCheckedForm(this)' class="trans">Toll </td>
											<td><input name="SCTLAL_txt" type="text" maxlength=11 class="input2" style="width:75; text-align:right" onChange='getSumTotalAmount(this)' disabled></td>
											<td>
												<table>
													<tr class="h23" id='SCTLAL_02'>
														<td width="">&nbsp;</td>
														<td width="">&nbsp;</td>
													</tr>
												</table>
											</td>
										</tr>
										<tr class="h23" id='SCWTAL_01'>
											<td><input name="SCWTAL_chk" type="checkbox" onClick='setCheckedForm(this)' class="trans">
												Waiting Charges </td>
											<td ><input name="SCWTAL_txt" type="text" maxlength=11 class="input2" style="width:75; text-align:right" onChange='getSumTotalAmount(this)' disabled></td>
											<td colspan ="2">
												<table>
													<tr class="h23" id='SCWTAL_02'>
														<td width="28%">Waiting Hour </td>
														<td width="72%" class="sm" ><input name="waiting_hour" type="text" class="input2" style="width:100;" disabled>&nbsp;Hour(s) </td>
													</tr>
												</table>
											</td>
										</tr>
										<tr class="h23" id='SCOTAL_01'>
											<td><input name="SCOTAL_chk" type="checkbox" onClick='setCheckedForm(this)' class="trans">
												Other Surcharge </td>
											<td ><input name="SCOTAL_txt" type="text" maxlength=11 class="input2" style="width:75; text-align:right" onChange='getSumTotalAmount(this)' disabled></td>
											<td>
												<table>
													<tr class="h23" id='SCOTAL_02'>
														<td >Remarks</td>
														<td >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name="remarks" type="text" class="input2" style="width:300;" disabled></td>
													</tr>
												</table>
											</td>
										</tr>
										<tr class="h23" id='SCENAL_01'>
											<td><input name="SCENAL_chk" type="checkbox" onClick='setCheckedForm(this)' class="trans">ENSF </td>
											<td ><input name="SCENAL_txt" type="text" maxlength=11 class="input2" style="width:75; text-align:right" onChange='getSumTotalAmount(this)' disabled></td>
											<td>
												<table>
													<tr class="h23" id='SCENAL_02'>
														<td width="">&nbsp;</td>
														<td width="">&nbsp;</td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
	
									<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
	
									<table class="search" border="0" style="width:100%;">
										<tr class="h23">
											<td width="70%" class="tr_head3"><strong>&nbsp;&nbsp;Surcharge Total Amount </strong></td>
											<td width="30%"><input name="surcharge_total" type="text" maxlength=13 class="input2" style="width:100; text-align:right" disabled></td>
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
<!-- OUTER - POPUP (E)nd -->

<table class="height_5"><tr><td></td></tr></table>


<!-- : ( Button : pop ) (S) -->
<table width="1050" class="sbutton">
	<tr>
		<td height="71" class="popup">

			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
    		   	<tr>
    		   		<td class="btn3_bg">
					    <table border="0" cellpadding="0" cellspacing="0">
						    <tr>
								<!-- Repeat Pattern -->
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left" name="btn_save_left" id ="btn_save_left"></td>
											<td class="btn1" name="btn_save" onClick='processButtonClick()' id="btn_save">Save</td>
											<td class="btn1_right" name="btn_save_right" id ="btn_save_right"></td>
										</tr>
									</table>
								</td>
								<td class="btn1_line" name="btn1_line" id ="btn1_line"></td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_close" onClick='processButtonClick()' id="btn_close">Close</td>
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
<!-- : ( Button : pop ) (E) -->

<table width="100%" id="mainTable" cellpadding="10" border="0">
	<tr>
		<td>
			 <script language="javascript">ComSheetObject('sheet1');</script>
			 <script language="javascript">ComSheetObject('sheet2');</script>
	 		 <script language="javascript">ComSheetObject('sheet3');</script>
		</td>
	</tr>
</table>


</form>
</body>
</html>
