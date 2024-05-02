<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_OPF_9501.jsp
*@FileTitle : Bay Plan
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.03
*@LastModifier : 김도현
*@LastVersion : 1.0
* 2009.07.20 김도현
* 1.0 Creation
=========================================================
* History
*=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.opf.opfstowagemgt.opfstowagemgt.event.VopOpf9501Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	VopOpf9501Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
%>
<html>
<head>
<title>COD Approve Main Screen</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<script language="javascript">
	var frDt = ComGetDateAdd('<%=JSPUtil.getKST("yyyy-MM-dd")%>', "M", -30);
	var toDt = ComGetDateAdd('<%=JSPUtil.getKST("yyyy-MM-dd")%>', "M", 1);

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
<input type="hidden" name="sheet1_old_row">
<input type="hidden" name="sheet1_old_col">
<input type="hidden" name="sheet3_old_row">
<input type="hidden" name="sheet3_old_col">
<input type="hidden" name="bg_colr_r">
<input type="hidden" name="bg_colr_g">
<input type="hidden" name="bg_colr_b">
<input type="hidden" name="vvd_port_gb">
<input type="hidden" name="vsl_cd">
<input type="hidden" name="skd_voy_no">
<input type="hidden" name="skd_dir_cd">
<input type="hidden" name="call_ind">



<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	</table>
	<!--Page Title, Historical (E)-->
	
	<!--biz page (S)-->
	<table class="search" id="mainTable"> 
      	<tr><td class="bg">
			<!-- biz_1  (S) -->
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="60">&nbsp;CNTR No</td>
				<td width="120">
					<input name="cntr_id" type="text" required fullfill style="width:100;" class="input1" value="" caption="CNTR No" maxlength="11" dataformat="engup" style="ime-mode:disabled">
				</td>
				<td width="35">&nbsp;VVD</td>
				<td width="130">
					<script language="javascript">ComComboObject('vvd', 2, 120, 1, 1);</script>
				</td>
				<td width="40">&nbsp;PORT</td>
				<td width="90">
					<script language="javascript">ComComboObject('port_cd', 4, 80, 1, 1);</script>
				</td> 
				<td width="35">&nbsp;BAY</td>
				<td width="55">
					<script language="javascript">ComComboObject('bay_idx', 1, 45, 1, 1);</script>
					<script language="javascript">ComComboObject('cntr_bay_idx', 1, 0, 0);</script>
				</td>
				<td title="Requested date" width="45">&nbsp;Period</td>
				<td title="Requested date" colspan="5"><input type="text" name="eta_fr_dt" style="width:80; text-align:center;" class="input1" dataformat="ymd" maxlength="8" caption="the from date" value="">&nbsp;~&nbsp;<input type="text" name="eta_to_dt" style="width:80; text-align:center;" class="input1" dataformat="ymd" maxlength="8" caption="the to date" value="">&nbsp;<img src="img/btns_calendar.gif" id="btns_period" name="btns_period" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
			</tr>
			</table>	
		</td></tr>
	</table>		
			
   <table class="height_8"><tr><td></td></tr></table>	
	<!-- Tab (S) -->
	<!-- Tab (E) -->
	<table class="search" id="mainTable"> 
    <tr><td class="bg" style="height:454" valign="top">
		<!-- biz_1  (S) -->
			<table width="979"> 
				<tr>
					<td width="200">
						<!-- Grid  (S) -->
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">&nbsp;&nbsp;
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
							<tr>
								<td width="100%"></td>
							</tr>
							<tr>
								<td width="100%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<script language="javascript">ComSheetObject('sheet2');</script>
								</td>
							</tr>
							<tr>
								<td width="100%"></td>
							</tr>
							<tr>
								<td width="100%">&nbsp;&nbsp;
									<script language="javascript">ComSheetObject('sheet3');</script>
								</td>
							</tr>
						</table> 			
						<!-- Grid (E) -->
					</td>
					<td width="20"></td>
					<td width="" valign="top">
						<!--  biz_1  (S) -->
						<table class="search" border="1" style="width:100%;"> 
							<tr class="h23">
								<td colspan="4">&nbsp;&nbsp;#.CNTR Information</td>
							</tr>
							<tr class="h23">
								<td width="280">&nbsp;CNTR PSN</td>
								<td ><input type="text" name="frm_cntr_psn" style="width:55;" readonly value=""><input type="text" name="frm_deck_psn" style="width:44;" readonly value=""></td>
								<td width="280">&nbsp;CNTR No.</td>
								<td ><input type="text" name="frm_id" style="width:100;" readonly value=""></td>
							</tr>
							<tr class="h23">
								<td width="280">&nbsp;POL</td>
								<td ><input type="text" name="frm_pol" style="width:100;" readonly value=""></td>
								<td width="280">&nbsp;OPT</td>
								<td ><input type="text" name="frm_opr_cd" style="width:100;" readonly value=""></td>
							</tr>
							<tr class="h23">
								<td width="280">&nbsp;POD</td>
								<td ><input type="text" name="frm_pod" style="width:100;" readonly value=""></td>
								<td width="280">&nbsp;Type/Size</td>
								<td ><input type="text" name="frm_sztp" style="width:25;" readonly value="">
									 <input type="text" name="frm_sztp_iso" style="width:45;" readonly value="">
									 <input type="text" name="frm_fe" style="width:20;" readonly value="">
								</td>
							</tr>
							<tr class="h23">
								<td width="280">&nbsp;2ndPod</td>
								<td ><input type="text" name="frm_pod2" style="width:100;" readonly value=""></td>
								<td width="280">&nbsp;Weight</td>
								<td ><input type="text" name="frm_weight" style="width:74;" readonly value="">&nbsp;<input type="text" name="frm_wgt_group" style="width:20;" readonly value=""></td>
							</tr>
							<tr class="h23">
								<td width="280">&nbsp;POR</td>
								<td ><input type="text" name="frm_por" style="width:100;" readonly value=""></td>
								<td width="280">&nbsp;Cargo Type</td>
								<td ><input type="text" name="frm_cargo_type" style="width:100;" readonly value=""></td>
							</tr>
							<tr class="h23">
								<td width="280">&nbsp;F/POD</td>
								<td ><input type="text" name="frm_fpod" style="width:100;" readonly value=""></td>
								<td width="280">&nbsp;Temp(C)</td>
								<td ><input type="text" name="frm_temp" style="width:100;" readonly value=""></td>
							</tr>
							<tr class="h23">
								<td width="280">&nbsp;Dest</td>
								<td ><input type="text" name="frm_fdest" style="width:100;" readonly value=""></td>
								<td width="280">&nbsp;Delv</td>
								<td ><input type="text" name="frm_delv_cd" style="width:100;" readonly value=""></td>
							</tr>
							<tr class="h23">
								<td width="280">&nbsp;B/L No.</td>
								<td ><input type="text" name="frm_bl_no" style="width:100;" readonly value=""></td>
								<td width="280">&nbsp;BKG No.</td>
								<td ><input type="text" name="frm_booking_no" style="width:100;" readonly value=""></td>
							</tr>
							<tr class="h23">
								<td colspan="4">&nbsp;&nbsp;#.IMDG</td>
							</tr>
							<tr class="h23">
								<td width="280">&nbsp;IMDG</td>
								<td ><input type="text" name="frm_imdg" style="width:100;" readonly value=""></td>
								<td width="280">&nbsp;UN NO.</td>
								<td ><input type="text" name="frm_unno" style="width:100;" readonly value=""></td>
							</tr>
							<tr class="h23">
								<td colspan="4">&nbsp;&nbsp;#.Over Dimension</td>
							</tr>
							<tr class="h23">
								<td width="280">&nbsp;Height</td>
								<td >
									<input type="text" name="frm_ovh_slot" style="width:20;" readonly value="">
									<input type="text" name="frm_ovh" style="width:75;" readonly value="">
								</td>
								<td width="280">&nbsp;Fote</td>
								<td >
									<input type="text" name="frm_ovf_slot" style="width:20;" readonly value="">
									<input type="text" name="frm_ovf" style="width:75;" readonly value="">
								</td>
							</tr>
							<tr class="h23">
								<td width="280">&nbsp;Aft</td>
								<td >
									<input type="text" name="frm_ova_slot" style="width:20;" readonly value="">
									<input type="text" name="frm_ova" style="width:75;" readonly value="">
								</td>
								<td width="280">&nbsp;Port</td>
								<td >
									<input type="text" name="frm_ovp_slot" style="width:20;" readonly value="">
									<input type="text" name="frm_ovp" style="width:75;" readonly value="">
								</td>
							</tr>
							<tr class="h23">
								<td width="280">&nbsp;Stb'd</td>
								<td >
									<input type="text" name="frm_ovs_slot" style="width:20;" readonly value="">
									<input type="text" name="frm_ovs" style="width:75;" readonly value="">
								</td>
							</tr>
							<tr class="h23">
								<td width="230" colspan="4">&nbsp;&nbsp;</td>
							</tr>
						</table>
						<table class="search" border="0" style="width:100%;"> 
							<tr class="h23">
								<td width="230" colspan="2">&nbsp;&nbsp;#.Port Color Information</td>
							</tr>
						</table>
						<table class="search" border="0" style="width:100%;"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet4');</script>
								</td>
							</tr>
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet5');</script>
								</td>
							</tr>
						</table>
						<!--  biz_1   (E) -->
					</td>
				</tr>
			</table>		
		
			<!--  Button_Sub (S) -->
			
	    	<!-- Button_Sub (E) --> 
			</td></tr>
		</table>
		<!-- Tab BG Box(E) -->
	<!--biz page (E)-->
	
		<!--Button (S) -->
		<!-- Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
		<!-- Button (E) -->
	</td></tr>
</table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>