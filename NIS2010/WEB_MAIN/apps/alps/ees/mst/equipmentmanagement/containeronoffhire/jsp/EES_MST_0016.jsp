<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_mst_0016.jsp
*@FileTitle : Own Container Creation (New Van)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.10
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2009.06.10 민정호
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
<%@ page import="com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.event.EesMst0016Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMst0016Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.EquipmentManagement.ContainerOnOffhire");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EesMst0016Event)request.getAttribute("Event");
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
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name ="cntr_mtrl_cd" value="">
<!-- 계약번호, 제작일자, 행거랙, Plasti Floor 수정시에만 -->
<input type="hidden" name ="org_agmt_no">
<input type="hidden" name ="org_mft_dt">
<input type="hidden" name ="org_cntr_hngr_rck_cd">
<input type="hidden" name ="org_plst_flr_flg">
<input type="hidden" name ="org_fctry_spec_no">
<input type="hidden" name ="org_de_yrmon">		
<input type="hidden" name ="org_certi_no">		
<input type="hidden" name ="org_diff_rmk">	
<input type="hidden" name ="org_mft_vndr_seq">	
<input type="hidden" name ="org_apro_csc_no">
<input type="hidden" name ="org_apro_tir_no">
<input type="hidden" name ="org_apro_uic_no">
<input type="hidden" name ="org_apro_tct_no">
<input type="hidden" name ="mft_vndr_seq">	
<input type="hidden" name ="org_unit_type">

<input type="hidden" name ="org_rf_mkr_seq">	
<input type="hidden" name ="org_rf_mdl_nm">
<input type="hidden" name ="org_rf_rfr_no">
<input type="hidden" name ="org_min_temp">
<input type="hidden" name ="org_max_temp">

<!-- 계약번호, 제작일자 -->
<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">	
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->
			<table class="search"> 
       		<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="70">Lot No.</td>
					<td><input type="text" style="width:130" class="input" value="" name="lot_no" style="text-align:center" readonly>&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="ComOpenPopupWithTarget1"></td>					
				</tr> 
				</table>
				
				</td></tr>
			</table>
			
			<table class="height_8"><tr><td></td></tr></table>
			
			<table class="search"> 
       		<tr><td class="bg" style="height:460;" valign="top">			
				<table class="search" border="0">
					<tr><td class="title_h"></td>
					<td class="title_s">Agreement</td></tr>
				</table>			
				<!--  biz_3  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="70">AGMT No.</td>
					<td width="280"><input type="text" style="width:130" class="input1" value="" name="agmt_no" readonly style="text-align:center">&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="ComOpenPopupWithTarget2"></td>
					<td width=100>Lease Term</td>
					<td width="150"><input type="text" style="width:50" class="input2" value="" name="lstm_cd" style="text-align:center" readonly></td>
					<td width="90">Effective Date</td>
					<td><input type="text" style="width:80" class="input2" value="" name="eff_dt" style="text-align:center" readonly>&nbsp;~&nbsp;<input type="text" style="width:80" class="input2" value="" name="exp_dt" style="text-align:center" readonly></td>
				</tr> 
				<tr class="h23">
					<td>Financier</td>
					<td colspan="5"><input type="text" style="width:76" class="input2" value="" name="vndr_seq" readonly style="text-align:center">&nbsp;<input type="text" style="width:350" class="input2" value="" name="vndr_lgl_eng_nm" readonly style="text-align:center"></td>
				</tr>
				</table>
				<!--  biz_3  (E) -->				
			
			
				<table class="line_bluedot"><tr><td></td></tr></table>
			
				<table class="search" border="0">
					<tr><td class="title_h"></td>
					<td class="title_s">Owners Inspection</td></tr>
				</table>
			
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="110">SPEC No.</td>
					<td width="240"><input type="text" style="width:130" class="input1" value="" name="cntr_spec_no" readonly style="text-align:center">&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="ComOpenPopupWithTarget3"></td>					
					<td width="100">TP/SZ</td>
					<td width="150"><input type="text" style="width:50" class="input2" value="" name="cntr_tpsz_cd" style="text-align:center" readonly></td>
					<td width="90">CERTI No.</td>
					<td><input type="text" style="width:178" class="input1" value="" name="certi_no" maxlength="25" style="ime-mode:disabled"></td>
				</tr> 
				<tr class="h23">
					<td width="">M/Facturer</td>
					<td width=""><input type="text" style="width:153" class="input2" value="" name="vndr_abbr_nm" readonly></td>
					<td width="">F. Spec. No.</td>
					<td width=""><input type="text" style="width:110" class="input" value="" name="fctry_spec_no" maxlength="20"></td>
					<td width="">CSC No.</td>
					<td><input type="text" style="width:178" class="input1" value="" name="apro_csc_no" style="ime-mode:disabled"></td>
				</tr>						
				<tr class="h23">
					<td>M/Facturer Place</td>
					<td style="padding-left:2;"><script language="javascript">ComComboObject('lot_loc_cd',2,153,0,1,0);</script></td>
					<td>M/Facture Date</td>
					<td><input type="text" style="width:75" class="input1" name="mft_dt" style="text-align:center" dataformat="ymd" readonly>&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar1"></td>
					<td>TIR No.</td>
					<td><input type="text" style="width:178" class="input1" value="" name="apro_tir_no" style="ime-mode:disabled"></td>
				</tr>						
				<tr class="h23">
					<td>S/N Range</td>
					<td colspan="3" style="padding-left:2;"><script language="javascript">ComComboObject('lot_cntr_pfx_cd',1,60,1,1,0);</script>&nbsp;<input type="text" style="width:60" class="input1" value="" name="fm_ser_no" maxlength="6" dataformat="int" style="ime-mode:disabled" style="text-align:center">&nbsp;-&nbsp;<input type="text" style="width:55" class="input1" value="" name="to_ser_no" maxlength="6" dataformat="int" style="ime-mode:disabled" style="text-align:center">&nbsp;<input type="text" style="width:40" class="input2" value="" name="range_count" readonly style="text-align:center"></td>
					<td>UIC No.</td>
					<td><input type="text" style="width:178" class="input" value="" name="apro_uic_no" style="ime-mode:disabled"></td>
				</tr>						
				<tr class="h23">
					<td>Delivery Month</td>
					<td colspan="3"><input type="text" style="width:78" class="input1" value="" name="de_yrmon" style="text-align:center" readonly>&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar2"></td>
					<td>TCT No.</td>
					<td><input type="text" style="width:178" class="input" value="" name="apro_tct_no"></td>
				</tr></table>						
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="350">
						<table class="search_sm2" border="0" style="width:213;">
							<tr class="h23">
								<td><input type="checkbox" value="Y" class="trans" name="plst_flr_flg">Plastic Floor&nbsp;&nbsp;<input type="checkbox" value="O" class="trans" name="cntr_hngr_rck_cd">Hanger Rack</td>
							</tr>
						</table>
					</td>
					<td width="100">Unit Type</td>
					<td width="150"><script language="javascript">ComComboObject('unit_type',1,104,1,0,0);</script></td>
					<td width="57">ERP I/F</td>
					<td><input type="text" style="width:30" class="input2" value="" name="fa_if_grp_sts_cd" readonly style="text-align:center"></td>
				</tr>
				</table>
				<!--  biz_1  (E) -->				
				<table class="line_bluedot"><tr><td></td></tr></table>
				
				<table class="search" border="0">
					<tr><td class="title_h"></td>
					<td class="title_s">RF Unit</td></tr>
				</table>
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="70">Maker</td>
					<td width="140"><script language="javascript">ComComboObject('rf_mkr_seq',2,133,0,1,1);</script></td>
					<td width="70">Model No.</td>
					<td width="180"><input type="text" style="width:150;" class="input2"   maxlength=20 readOnly value="" name = "rf_mdl_nm" style="text-align:center"></td>
					<td width="60">Refrigerant</td>
					<td width="150"><input type="text" style="width:120;" class="input2"   maxlength=10 readOnly value="" name = "rf_rfr_no" style="text-align:center"></td>
					<td width="120">Max Setting Temp</td>
					<td width=""><input type="text" style="width:45;" class="input2" dataformat="float" caption="float(min/max)" readOnly value="" pointcount="2" maxlength="8"  size="7" name = "min_temp" style="text-align:right">
					 ~ <input type="text" style="width:45;" class="input2" dataformat="float" caption="float(min/max)" readOnly value="" pointcount="2" maxlength="8"  size="7" name = "max_temp" style="text-align:right">&nbsp;℃</td>
				</tr>
				</table>
				
				<table class="line_bluedot"><tr><td></td></tr></table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="70" valign="top" style="padding-top:2;">Remark(s)</td>
					<td><textarea style="width:100%;height:80;" name="diff_rmk" style="ime-mode:disabled"></textarea></td>	
				</tr> 
				</table>
			</td></tr>
		</table>
	<!--biz page (E)-->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
		</td></tr>
		</table>
    <!--Button (E) -->
	</td></tr>
</table></td></tr>
</table>
<!-- Grid  (S) -->														
<table width="100%" id="mainTable"> 
<tr>
	<td width="100%">
		<script language="javascript">ComSheetObject('sheet1');</script>
	</td>
</tr>
</table> 
<!-- Grid (E) -->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>