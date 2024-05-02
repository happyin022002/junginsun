<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0269.jsp
*@FileTitle : Freight & Charge_S/C Information
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.26
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2009.06.26 이진서
* 1.0 Creation
* ========================================================
* History
* 2012.01.09 금병주 [CHM-201115389-01] bkg 화면에 Port skip일 경우 표기 요청
* 2012.02.06 정선용 [CHM-201215875-01]	S/C Information 화면의 lane 정보 추가 요청
* 2012.10.05 조정민 [CHM-201219854] [BKG] BKG 생성시 S/C 에 운임 조회 후 부재시 G/W 메일 SALES REP/PRICING STAFF 전송 기능 추가
* 2012.10.18 조정민 [CHM-201220680] s/c information 화면에 scope 추가로 복수 scope 일때 user select 후 조회토록 로직 변경
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.event.EsmBkg0269Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0269Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String isBkg  = "N";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.BlRating.BlRating");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0269Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		isBkg  = JSPUtil.getParameter(request, "is_bkg");
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Freight & Charge_S/C Information</title>
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

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="bkg_no" value='<%=JSPUtil.getParameter(request, "bkg_no")%>'>
<input type="hidden" name="sc_no" value='<%=JSPUtil.getParameter(request, "sc_no")%>'>
<input type="hidden" name="application_date" value='<%=JSPUtil.getParameter(request, "application_date")%>'>
<input type="hidden" name="tp_sz" value='<%=JSPUtil.getParameter(request, "tp_sz")%>'>
<input type="hidden" name="cgo" value='<%=JSPUtil.getParameter(request, "cgo")%>'>
<input type="hidden" name="qty" value='<%=JSPUtil.getParameter(request, "qty")%>'>
<input type="hidden" name="brk_dwn_flg" value='<%=JSPUtil.getParameter(request, "brk_dwn_flg")%>'>
<input type="hidden" name="frm_t10sheet1_brk_dwn_flg" value='<%=JSPUtil.getParameter(request, "frm_t10sheet1_brk_dwn_flg")%>'>
<input type="hidden" name="svc_scp_cd" value='<%=JSPUtil.getParameter(request, "svc_scp_cd")%>'>
<input type="hidden" name="term_cd" value='<%=JSPUtil.getParameter(request, "frt_term_cd")%>'>
<input type="hidden" name="ca_flg" value='<%=JSPUtil.getParameter(request, "ca_flg")%>'>
<input type="hidden" name="is_bkg" value='<%=isBkg%>'>
<input type="hidden" name="bl_no" value='<%=JSPUtil.getParameter(request, "bl_no")%>'>

<!-- Groupmail시 반영될 Hidden --> 
<input type="hidden" name="gw_subject">
<input type="hidden" name="gw_contents">

<input type="hidden" name="frm_svc_scp_cd">
<input type="hidden" name="frm_bdr_cng_flg">
<input type="hidden" name="frm_appldt">
<input type="hidden" name="frm_cmdtcd">
<input type="hidden" name="frm_repcmdtcd">
<input type="hidden" name="ctrt_tp_cd" value ="S">
<input type="hidden" name="rt_aud_tp_cd" value ="R">
<input type="hidden" name="cmdt_cd_old" >
<input type="hidden" name="sc_code" >
<input type="hidden" name="frm_bkg_vvd" >
<input type="hidden" name="srep_eml" >
<input type="hidden" name="usr_eml" >
<input type="hidden" name="ob_srep_eml" >
<input type="hidden" name="scp_cd" >
<input type="hidden" name="chk_oft" value ="N">
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; S/C Information</td></tr>
		</table>
		<!-- : ( Title ) (E) -->

		<!-- : ( Search Options ) (S) -->

			<table class="search">
       		<tr><td class="bg">

			<table class="search" border="0" style="width:100%;">
				<tr class="h23">
					<td width="60">&nbsp;BKG No.</td>
					<td width="150"><input type="text" style="width:110" class="input" name="frm_bkg_no" value="<%=JSPUtil.getParameter(request, "bkg_no")%>" readonly></td>
					<td width="30">CRD</td>
					<td width="150"><input type="text" style="width:80;text-align: center" class="input1" maxlength="8" dataformat="ymd" style="ime-mode:disabled" name="frm_cntr_cdr_dt" value="<%=JSPUtil.getParameter(request, "application_date")%>" >
					<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="pop_on_board_date">
					</td>
					<td width="60">&nbsp;S/C No.</td>
					<td width=""><input type="text" style="width:110" class="input" name="frm_fsc_no" value="<%=JSPUtil.getParameter(request, "sc_no")%>" readonly></td>
					</tr>
			</table>

			<table class="height_5"><tr><td></td></tr></table>

			<table class="search" border="0" style="width:100%;">
				<tr class="h23">
					<td width="690" valign="top">
						<table width="100%" class="grid2">
							<tr align="center">
								<td width="100" class="tr2_head"> Shipper	</td>
								<td width="30" class="input2">
								<input type="text" style="width: 100%; text-align: center" class="noinput2" name="frm_s_cust_cnt_cd" value='' readonly>
								</td>
								<td width="60" class="input2">
								<input type="text" style="width: 100%; text-align: right" class="noinput2" name="frm_s_cust_seq" value='' readonly>
								</td>
								<td align="left" class="input2">
								<input type="text" style="width: 100%; text-align: left"class="noinput2" name="frm_s_cust_nm" value='' readonly>
								</td>
							</tr>
							<tr align="center">
								<td width="100" class="tr2_head"> Consignee	</td>
								<td width="30" class="input2"><input type="text" style="width: 100%; text-align: center" class="noinput2" name="frm_c_cust_cnt_cd" value='' readonly>	</td>
								<td width="60" class="input2"><input type="text" style="width: 100%; text-align: right" class="noinput2" name="frm_c_cust_seq" value='' readonly>	</td>
								<td align="left" class="input2"><input type="text" style="width: 100%; text-align: left" class="noinput2" name="frm_c_cust_nm" value='' readonly></td>
							</tr>
							<tr align="center">
								<td width="100" class="tr2_head">Notify</td>
								<td width="30" class="input2"><input type="text" style="width: 100%; text-align: center" class="noinput2" name="frm_n_cust_cnt_cd" value='' readonly>	</td>
								<td width="60" class="input2"><input type="text" style="width: 100%; text-align: right" class="noinput2" name="frm_n_cust_seq" value='' readonly>	</td>
								<td align="left" class="input2"><input type="text" style="width: 100%; text-align: left" class="noinput2" name="frm_n_cust_nm" value='' readonly></td>
							</tr>
							<tr align="center">
								<td width="100" class="tr2_head">Also NTFY</td>
								<td width="30" class="input2"><input type="text" style="width: 100%; text-align: center" class="noinput2" name="frm_a_cust_cnt_cd" value='' readonly>	</td>
								<td width="60" class="input2"><input type="text" style="width: 100%; text-align: right" class="noinput2" name="frm_a_cust_seq" value='' readonly>	</td>
								<td align="left" class="input2"><input type="text" style="width: 100%; text-align: left" class="noinput2" name="frm_a_cust_nm" value='' readonly></td>
							</tr>
							<tr align="center">
								<td width="100" class="tr2_head"> SC customer</td>
								<td width="30" class="input2"><input type="text" style="width: 100%; text-align: center" class="noinput2" name="frm_p_cust_cnt_cd" value='' readonly></td>
								<td width="60" class="input2"><input type="text" style="width: 100%; text-align: right" class="noinput2" name="frm_p_cust_seq" value='' readonly>	</td>
								<td align="left" class="input2"><input type="text" style="width: 100%; text-align: left" class="noinput2" name="frm_p_cust_nm" value='' readonly>	</td>
							</tr>
							<tr align="center">
								<td width="100" class="tr2_head"> Commodity	<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_pop_Commodity" ></td>
								<td colspan="2" class="input2"><input type="text" style="width: 100%; text-align: right" class="input" name="frm_cmdt_cd" maxlength="6" value=''onChange="javascript:searchCmdt(this);" >	</td>
								<td align="left" class="input2"><input type="text" style="width: 100%; text-align: left" class="noinput2" name="frm_cmdt_nm" value='' readonly></td>
							</tr> 
							<tr align="center">
								<td width="100" class="tr2_head"> Rep. Commodity</td>
								<td colspan="2" class="input2"><input type="text" style="width: 100%; text-align: right" class="noinput2" name="frm_rep_cmdt_cd" value='' readonly></td>
								<td align="left" class="input2"><input type="text" style="width: 100%; text-align: left" class="noinput2" name="frm_rep_cmdt_nm" value='' readonly></td></td>
							</tr>
							<tr align="center">
								<td width="100" class="tr2_head"> Service Scope</td>
								<td colspan="3" class="input2">						
									<select style="width: 100%; text-align: right" name ="set_svc_scp_cd" class="input2" readonly></select>
								</td>
							</tr>
						</table>

					</td>
					<td width="20" valign="top"></td>
					<td width="330" valign="top">

					<table width="330"  id="mainTable0">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet0');</script>
							</td>
						</tr>
					</table>

						</td>
				</tr>
			</table>

			<table class="height_5"><tr><td></td></tr></table>

			<table class="search" border="0" style="width:100%;">
				<tr class="h23">
					<td width="60">&nbsp;Weight</td>
					<td width="177"><input type="text" style="width:108;text-align:right;" class="input2" name="frm_act_wgt" value="" readonly>&nbsp;<input type="text" style="width:30;text-align:right;" class="input2" name="" value="" ></td>
					<td width="55">Measure</td>
					<td width=""><input type="text" style="width:110;text-align:right;" class="input2" name="frm_meas_qty" value="" readonly>&nbsp;<input type="text" style="width:40;text-align:center;" class="input2" name="frm_meas_ut_cd" value="" readonly></td>
				</tr>					
			</table>
			
			
			<table class="search" border="0" style="width:100%;">
				<tr class="h23">
									<td width="190">&nbsp;Booking Route Information</td>
									<td width="240">
									<input type="text" style="width:50;" class="input2" name="frm_bkg_por_cd" value="" readonly>
									<input type="text" style="width:50;" class="input2" name="frm_bkg_pol_cd" value="" readonly>
									<input type="text" style="width:50;" class="input2" name="frm_bkg_pod_cd" value="" readonly>
									<input type="text" style="width:50;" class="input2" name="frm_del_cd" value="" readonly>
									</td>
									<td width="25">Lane</td>
									<td width="50"><input type="text" style="width:35;text-align:center;" class="input2"  name="frm_slan_cd"  value="" readonly></td>
									<td width="25">Pre</td>
									<td width="70"><input type="text" style="width:50;text-align:center;" class="input2"  name="frm_vv_pol_cd"  value="" readonly></td>
									<td width="32">Post</td>
									<td width="70"><input type="text" style="width:50;text-align:center;" class="input2"  name="frm_vv_pod_cd" value="" readonly></td>
									<td width="60">Port Skip</td>
									<td width="30"><input type="text" style="width:18;text-align:center;" class="input2"  name="frm_port_skp_flg" value="" readonly></td>
									<td width="25">R/D</td>
									<td width="50"><input type="text" style="width:18;text-align:center;" class="input2"  name="frm_rcv_term_cd" value="" readonly>&nbsp;<input type="text" style="width:18;text-align:center;" class="input2"  name="frm_de_term_cd"  value="" readonly></td>
									<td width="50">Special</td>
									<td width="30"><input type="text" style="width:18;text-align:center;" class="input2"  name="frm_special" value="" readonly></td>
									<td width="60">FRT Term</td>
									<td width=""><input type="text" style="width:18;text-align:center;" class="input2"  name="frm_frt_term_cd" value="<%=JSPUtil.getParameter(request, "frt_term_cd")%>" readonly></td>
				</tr>
			</table>
			
						
			
			
			
<div style="display:none"><script language="javascript">ComSheetObject('sheet1');</script></div>
<div style="display:none"><script language="javascript">ComSheetObject('sheet2');</script></div>

			<table class="height_5"><tr><td></td></tr></table>


				<!-- : ( Grid ) (S) -->
				<table width="979"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet3');</script>
						</td>
					</tr>
				</table>
				<table width="979"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet4');</script>
						</td>
					</tr>
				</table>
				<table width="979"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet5');</script>
						</td>
					</tr>
				</table>
				<!-- : ( Grid ) (E) -->
		    <!-- : ( Button : Grid ) (E) -->

			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->

<table class="height_5"><tr><td></td></tr></table>
</td></tr>
</table>


<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup">

		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
			<tr>
				<td class="btn3_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>					
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Retrieve">Retrieve</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
					<%if("".equals(isBkg)){%>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Select">Select</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td class="btn1_line"></td>
					<%}%> 
						<td>
						<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Close">Close</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
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
		<!-- : ( Button : pop ) (E) --> <!-- 개발자 작업  끝 -->
		</form>
</body>
</html>