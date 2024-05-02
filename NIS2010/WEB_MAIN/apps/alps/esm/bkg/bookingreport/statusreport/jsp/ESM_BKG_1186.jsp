<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ui_bkg_1186.jsp
*@FileTitle : VGM Closing Status Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.24
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.04.24 김민정
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.event.EsmBkg1186Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1186Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	boolean isCA_Usr 		= false;
	String strCnt_cd		= "CA";
	
	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg1186Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

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
<title>Canada ACI: Manifest Transmit</title>
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

<body  onLoad="setupPage();">
<form name="form" method="post">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows"> 
<input type="hidden" name="ch_usr_id">
<input type="hidden" name="curr_page"      value="1">
<input type="hidden" name="rows_per_page"  value="50">

<input type="hidden" name="mst_bkg_no">
<input type="hidden" name="ca_rsn_cd">
<input type="hidden" name="ca_remark">
<input type="hidden" name="backendjob_key" value="">
<input type="hidden" name="multi_vvd">
<input type="hidden" name="dirty_flag">
<input type="hidden" name="vvd_tmp">
<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr>
		<td valign="top">

<!--Page Title, Historical (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
</table>
<!--Page Title, Historical (E)-->

<!--biz page (S)-->


<table class="search">
	<tr>
		<td class="bg">
			<table class="search" border="0" style="width:979;"> 
				<tr class="h25">
					<td width="66">Multi-VVD</td>
					<td width="190">
	                   	<table class="search" border="0">
	                       	<tr class="h25">
	                            <td valign="top" id="td_vvd_no" width="180">
	                               	<input type="text" name="vvd_sig" dataformat="engupnum" maxlength="9" class="input" style="width:80;" value="" onChange="javascript:insertItm(this);">&nbsp;
	                               	<script language="javascript">ComComboObject('p_vvd', 1, 100, 1);</script>
	                           	</td>
	                          	</tr>
	                       </table>
					</td> 
					<td width="184">
						<input type="radio" id="p_dt_type" name="p_dt_type" value="ETD" class="trans" checked> ETD
						<input type="radio" id="p_dt_type" name="p_dt_type" value="VGM" class="trans" > VGM Cut Off Time&nbsp;
					</td>
					<td width="192">
						<input type="text" name="p_atd" class="input1" style="width:75;" value="" dataformat="ymd" caption="ETD START DATE" maxlength="10"  style="ime-mode:disabled"    cofield="etd">&nbsp;~
						<input type="text" name="p_etd" class="input1" style="width:75;" value="" dataformat="ymd" caption="ETD END DATE" maxlength="10"  style="ime-mode:disabled" cofield="atd">
						<img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" onClick="callDatePop('ETD')">
					</td>
					<td width="20">POL</td>
					<td width="60"><input type="text" style="width:50" value="" name="p_pol_cd" maxlength='5' dataformat='engupnum' style="ime-mode:disabled" class="input"></td>
					<td width="25">L/T</td>
					<td width="90">
						<select style="width:60;" class="input" name="p_pol_lt" id="p_pol_lt">
							<option value="">ALL</option>
							<option value="LC" Selected>Local</option>
							<option value="TS">T/S</option>
						</select>
					</td>
					<td width="50">BKG OFC</td>
					<td width="90" class="sm"><input type="text" style="width: 45" value="" class="input" name="p_bkg_ofc_cd" maxlength='6' dataformat='engup' style="ime-mode:disabled">
											  <input type="checkbox" value="Y" class="trans" name="p_ofc_cd">Sub</td>					
				</tr>
				</table>	
				<table class="search" border="0" style="width:979;">				
				<tr class="h25">
				    <td width="80">VGM STATUS</td>
					<td width="100">
						<select style="width: 100;" class="input" name="p_vgm_flg">
							<option value="">ALL</option>
							<option value="Y">YES</option>
							<option value="I">INCOMPLETE</option>								
							<option value="N">NO</option>
						</select>
					</td>
					<td width="105"></td>					
					<td width="30">RHQ</td>
					<td width="60">
						<script language="javascript">ComComboObject('p_rhq_cd', 1, 60, 1);</script>
					</td>
				    <td colspan="5"></td>
				</tr>				
			</table>
		</td>
	</tr>
</table>
<table class="height_8"><tr><td colspan="8"></td></tr></table>
		
<table class="search" id="mainTable"> 
	<tr>
		<td class="bg">
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>



<br>

<div id="tabLayer">
  <table class="search"> 
       	<tr><td class="bg">
				<table border="0" style="width:979"> 
				<tr class="h23">
					<td width="80">No. of BKG</td>
					<td width="80"><input type="text" style="width:60;text-align:right;padding-right: 5px"  class="input" ID="total_bkg" value="" readonly ></td> 
					<td width="80">No. of CNTR</td>
					<td width="80"><input type="text" style="width:60;text-align:right;padding-right: 5px" class="input" ID="total_cntr_cnt" value=""  readonly ></td> 
					<td width="80">No. of VGM</td>
					<td width="80"><input type="text" style="width:60;text-align:right;padding-right: 5px" class="input" ID="total_vgm_cnt" value=""  readonly ></td> 
					<td width="80">Non VGM</td>
					<td width="80"><input type="text" style="width:60;text-align:right;padding-right: 5px" class="input" ID="total_no_vgm_cnt" value=""  readonly ></td>
					<td width="*">&nbsp;</td>					
			</tr>
		</table>
	    </td></tr>
</table>

        
<!--Button (S) -->
<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
	<tr>
		<td class="btn1_bg">
    		<table border="0" cellpadding="0" cellspacing="0">
    			<tr>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
							<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td class="btn1_line"></td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_new">New</td>
							<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td class="btn1_line"></td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
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

<!-- 본문끝 -->
		</td>
	</tr>
</table>
<!-- 본문끝 -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>