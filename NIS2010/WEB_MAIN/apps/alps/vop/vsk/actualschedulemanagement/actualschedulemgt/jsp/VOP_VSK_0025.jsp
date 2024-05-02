<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0025.jsp
*@FileTitle : Actual SKD Report Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.28
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.07.10 정진우
* 1.0 Creation
* ----------------------------------------------------------------------------------
* 2010.09.17 이준범 [CHM-201006029-01] Actual SKD Creation내 Delete 버튼에 대하여 권한 변경
* 현재 : PUSCOV, CLTCO 인 경우만 활성화
* 변경 : 지역(RHQ) 운항 담당자 권한이 있는 모든 사람에게 권한 부여
* 2010.12.20 진마리아 [CHM-201007578-01] FORM 항목추가(INP_DT , INP_USR_ID 관련)
* 2011.04.15 진마리아 padding-right 설정
* 2011.05.13 진마리아 [CHM-201110230-01] VSK-Actual SKD creation 화면 일부 수정 요청(EDI와 Departure Report 정보 구분)
* 2011.10.04 김민아 [CHM-201112983-01] Actual SKD Creation 및 Inquiry 화면 및 로직 변경 : Port및 Terminal, Calling Seq, 입력칼럼을 Select Box로 변경 /ATA,ATB,ATD 별 Remark 칼럼 추가 / Delay Time을 Hrs로 로직 변경
* 2012.01.20 진마리아 [CHM-201215858-01] Actual SKD Creation내 Delete 버튼 확성 rule 변경
* 2012.03.20 진마리아 [CHM-201216747-01] Coastal SKD내 Actual SKD 바로 가기 버튼 추가
* 2012.08.28 진마리아 CHM-201219486-01 VSK_DEP_RPT 차단(FCM_DEP_RPT 대체) / ACT SKD과 VMS Data를 구별하여 alert
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.event.VopVsk0025Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0025Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";	// Office Code 삭제시 Delete 버튼 활성화 여부 확인.
	String strUsrAuth		= "";
	
	String cstVslCd = "";
	String cstSkdVoyNo = "";
	String cstSkdDirCd = "";
	String cstYdCd = "";
	String cstClptIndSeq = "";
	String popYn = "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.ActualScheduleManagement.ActualScheduleMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		String[] aryUsrAuth = account.getUserAuth();
		
		StringBuffer sbUsrAuth	= new StringBuffer();
		
		for(int i=0; i<aryUsrAuth.length; i++){
			if(i==0){
				//::2014-04-18:://
				//strUsrAuth = aryUsrAuth[i];
				
				sbUsrAuth.append(aryUsrAuth[i]);
				
			}else{
				//::2014-04-18:://
				//strUsrAuth = strUsrAuth + "|" + aryUsrAuth[i];
				
				sbUsrAuth.append(strUsrAuth);
				sbUsrAuth.append("|");
				sbUsrAuth.append(aryUsrAuth[i]);
				
			}
		}
		
		strUsrAuth		= sbUsrAuth.toString();
		
		cstVslCd 		= JSPUtil.replaceForHTML(request.getParameter("vslCd"));
		cstVslCd 		= cstVslCd==null?"":cstVslCd;
		cstSkdVoyNo 	= JSPUtil.replaceForHTML(request.getParameter("skdVoyNo"));
		cstSkdVoyNo 	= cstSkdVoyNo==null?"":cstSkdVoyNo;
		cstSkdDirCd 	= JSPUtil.replaceForHTML(request.getParameter("skdDirCd"));
		cstSkdDirCd 	= cstSkdDirCd==null?"":cstSkdDirCd;
		cstYdCd 		= JSPUtil.replaceForHTML(request.getParameter("ydCd"));
		cstYdCd 		= cstYdCd==null?"":cstYdCd;
		cstClptIndSeq 	= JSPUtil.replaceForHTML(request.getParameter("clptIndSeq"));
		cstClptIndSeq 	= cstClptIndSeq==null?"":cstClptIndSeq;
		popYn 			= JSPUtil.replaceForHTML(request.getParameter("popYn"));
		popYn 			= popYn==null?"":popYn;

		event 			= (VopVsk0025Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg 	= new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Actual SKD Creation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	var gOfcCd = "<%=strOfc_cd%>";
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
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="port_skd_sts_cd">
<input type="hidden" name="org_port_skd_sts_cd">
<input type="hidden" name="clpt_seq">
<input type="hidden" name="turn_port_flg">
<input type="hidden" name="turn_port_ind_cd">
<input type="hidden" name="turn_skd_voy_no">
<input type="hidden" name="turn_skd_dir_cd">
<input type="hidden" name="turn_clpt_ind_seq">
<input type="hidden" name="pre_port_cd">
<input type="hidden" name="pre_etd_dt">
<input type="hidden" name="lst_eta_dt">
<input type="hidden" name="lst_etb_dt">
<input type="hidden" name="lst_etd_dt">
<input type="hidden" name="loc_cd">
<input type="hidden" name="slan_cd">
<input type="hidden" name="nxt_act_inp_flg">

<!-- CHM-201007578-01 -->
<input type="hidden" name="act_ata_inp_dt">
<input type="hidden" name="act_atb_inp_dt">
<input type="hidden" name="act_atd_inp_dt">
<input type="hidden" name="act_ata_inp_usr_id">
<input type="hidden" name="act_atb_inp_usr_id">
<input type="hidden" name="act_atd_inp_usr_id">

<input type="hidden" name="clpt_ind_seq">
<input type="hidden" name="yd_cd">

<input type="hidden" name="usr_auth" value="<%=strUsrAuth%>">
<input type="hidden" name="usr_id" value="<%=strUsr_id%>">

<!-- for popup of Cst SKD Update -->
<input type="hidden" name="cst_vsl_cd" value="<%=cstVslCd%>">
<input type="hidden" name="cst_skd_voy_no" value="<%=cstSkdVoyNo%>">
<input type="hidden" name="cst_skd_dir_cd" value="<%=cstSkdDirCd%>">
<input type="hidden" name="cst_yd_cd" value="<%=cstYdCd%>">
<input type="hidden" name="cst_clpt_ind_seq" value="<%=cstClptIndSeq%>">
<input type="hidden" name="pop_yn" value="<%=popYn %>">

<input type="hidden" name="act_skd_src_sys_cd"><!-- distinguish with Actual SKD and VMS  -->

<!-- 개발자 작업	-->
<% if(popYn.equals("Y")){ %>
<table width="100%" class="popup" cellpadding="10" border="0"> 
	<tr><td class="top"></td></tr>
	<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Actual SKD  Creation  </td></tr>
		</table>
		<!-- : ( Title ) (E) -->
	</td></tr>
</table>
<% }else{ %> 
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;padding-right:5;">
<tr><td valign="top">
	<!--Page Title, Historical (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	</table>
	<!--Page Title, Historical (E)-->
<% } %>	
	
	<!--biz page (S)-->
	<table class="search"> 
    	<tr><td class="bg">
				<!--  biz_1  (S) -->
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="105">VVD</td>
					<td width="180"><input type="text" name="vsl_cd" style="width:48;text-align:center;ime-mode:disabled;" class="input1" value="" maxlength="4" onfocus="this.select();">&nbsp;<input type="text" name="skd_voy_no" style="width:48;text-align:center;ime-mode:disabled;" class="input1" value="" maxlength="4" onfocus="this.select();">&nbsp;<input type="text" name="skd_dir_cd" style="width:25;text-align:center;ime-mode:disabled;" class="input1" value="" maxlength="1" onfocus="this.select();">&nbsp;<img class="cursor" name="btn_vvd" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle"></td>
					<td width="30">Port</td>
					<td width="390"><script language="javascript">ComComboObject('vps_port_cd', 4, 100, 1, 1, true);</script></td>
					<td width="84">Created Date</td>
					<td width=""><input type="text" name="cre_dt" style="width:110;text-align:center;" class="input2" value="" readonly="readonly">&nbsp;<input type="text" name="cre_usr_id" style="width:70;" class="input2" value="" readonly="readonly"></td>
				</tr>
				<tr class="h23">
					<td width="105">Vessel Condition</td>
					<td colspan="3"><input type="text" name="port_skd_sts_nm" style="width:80;text-align:center;" class="input2" value="" readonly="readonly"></td>
					<td width="">Updated Date</td>
					<td width=""><input type="text" name="upd_dt" style="width:110;text-align:center;" class="input2" value="" readonly="readonly">&nbsp;<input type="text" name="upd_usr_id" style="width:70;" class="input2"  value="" readonly="readonly"></td>	
				</tr>	
				</table>
				
				<table class="search" border="0" style="width:100%;"> 
					<tr class="h23">
						<td width="104">Remark(s)</td>
						<td width=""><textarea name="diff_rmk" style="width:870;height:40;ime-mode:disabled;"></textarea></td>
					</tr>	
				</table>
	
		</td></tr>	
	</table>
	<!--  biz_1   (E) -->
	<table class="height_8"><tr><td></td></tr></table>
	
	<!-- Tab ) (S) -->
   	<table class="tab" border="0" cellpadding="0" cellspacing="0" width="100%">
     		<tr><td width="100%">
				<script language="javascript">ComTabObject('tab1');</script>
				<!-- img src="img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
			</td></tr>
	</table>
	<!-- Tab ) (E) -->
		
	<!--TAB Vessel Movement (S) -->

	<div id="tabLayer" style="display:inline">
		
	<table class="search"> 
       	<tr><td class="bg" style="height:363;" valign="top">
     	
				<!--  biz_2  (S) -->
					<table width="100%" class="grid2">
						<tr class="tr2_head">
							<td width="12%"></td>
							<td width="15%">P/F SKD</td>
							<td width="15%">Estimate SKD</td>
							<td width="15%">Actual SKD</td>
							<td width="15%">Delay(Time)</td>
							<td colspan="3">Delay Reason</td>
						</tr> 
						
						<tr>
							<td class="tr2_head2"><strong>Arrival</strong></td>
							<td align="center" class="noinput2"><input type="text" name="pf_eta_dt" style="width:110;ime-mode:disabled;" class="noinput2" value="" readonly="readonly"></td>
							<td align="center" class="noinput2"><input type="text" name="vps_eta_dt" style="width:110;ime-mode:disabled;" class="noinput2" value="" readonly="readonly"></td>
							<td align="center" class="input1"><input type="text" name="act_arr_dt" dataformat="ymdhm" style="width:110;ime-mode:disabled;" class="noinput1" value="" maxlength="16"></td>
							<td width="" align="center" class="noinput2"><input type="text" name="dlay_arr_tm" style="width:50;text-align:center;" class="noinput2" value="" readonly="readonly"></td>
							<td width="3%" align="center"><script language="javascript">ComComboObject('vsl_arr_dlay_rsn_cd',2,60,1,0);</script></td>
							<td align="center" class="noinput2"><input type="text" name="vsl_arr_dlay_rsn_nm" style="width:103;" class="noinput2" value="" readonly="readonly"></td>
							<td align="center" class="noinput2"><a href="#" onmousemove="msgmove()" onmouseover="msgset(document.form.act_arr_rmk.value)" onmouseout="msghide()"><input type="text" name="act_arr_rmk" style="width:100;" class="noinput2" value="" readonly="readonly"></a><img class="cursor" name="btn_remark_arr" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle"></td>
						</tr>
						
						<tr>
							<td class="tr2_head2"><strong>Berthing</strong></td>
							<td align="center" class="noinput2"><input type="text" name="pf_etb_dt" style="width:110;ime-mode:disabled;" class="noinput2" value="" readonly="readonly"></td>
							<td align="center" class="noinput2"><input type="text" name="vps_etb_dt" style="width:110;ime-mode:disabled;" class="noinput2" value="" readonly="readonly"></td>
							<td align="center" class="input1"><input type="text" name="act_brth_dt" dataformat="ymdhm" style="width:110;ime-mode:disabled;" class="noinput1" value="" maxlength="16"></td>
							<td width="" align="center" class="noinput2"><input type="text" name="dlay_brth_tm" style="width:50;text-align:center;" class="noinput2" value="" readonly="readonly"></td>
							<td width="" align="center"><script language="javascript">ComComboObject('vsl_brth_dlay_rsn_cd',2,60,1,0);</script></td>
							<td align="center" class="noinput2"><input type="text" name="vsl_brth_dlay_rsn_nm" style="width:103;" class="noinput2" value="" readonly="readonly"></td>
							<td align="center" class="noinput2"><a href="#" onmousemove="msgmove()" onmouseover="msgset(document.form.act_brth_rmk.value)" onmouseout="msghide()"><input type="text" name="act_brth_rmk" style="width:100;" class="noinput2" value="" readonly="readonly"></a><img class="cursor" name="btn_remark_brth" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle"></td>
						</tr>
						
						<tr>
							<td class="tr2_head2"><strong>Departure</strong></td>
							<td align="center" class="noinput2"><input type="text" name="pf_etd_dt" style="width:110;ime-mode:disabled;" class="noinput2" value="" readonly="readonly"></td>
							<td align="center" class="noinput2"><input type="text" name="vps_etd_dt" style="width:110;ime-mode:disabled;" class="noinput2" value="" readonly="readonly"></td>
							<td align="center" class="input1"><input type="text" name="act_dep_dt" dataformat="ymdhm" style="width:110;ime-mode:disabled;" class="noinput1" value="" maxlength="16"></td>
							<td width="" align="center" class="noinput2"><input type="text" name="dlay_dep_tm" style="width:50;text-align:center;" class="noinput2" value="" readonly="readonly"></td>
							<td width="" align="center"><script language="javascript">ComComboObject('vsl_dep_dlay_rsn_cd',2,60,1,0);</script></td>
							<td align="center" class="noinput2"><input type="text" name="vsl_dep_dlay_rsn_nm" style="width:103;" class="noinput2" value="" readonly="readonly"></td>
							<td align="center" class="noinput2"><a href="#" onmousemove="msgmove()" onmouseover="msgset(document.form.act_dep_rmk.value)" onmouseout="msghide()"><input type="text" name="act_dep_rmk" style="width:100;" class="noinput2" value="" readonly="readonly"></a><img class="cursor" name="btn_remark_dep" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle"></td>
						</tr>
						
						<tr>
							<td class="tr2_head2" colspan="3"><strong>Last Pilot Off</strong></td>
							<td align="center" class="input"><input type="text" name="plt_lst_unld_dt" dataformat="ymdhm" style="width:110;ime-mode:disabled;" class="noinput" value="" maxlength="16"></td>
							<td align="center" class="noinput2" colspan="4">&nbsp;</td>
						</tr>
						
						<tr>
							<td class="tr2_head2" colspan="3"><strong>Anchor Drop/Away Before Berthing</strong></td>
							<td align="center" class="input"><input type="text" name="bfr_brth_ank_drp_dt" dataformat="ymdhm" style="width:110;ime-mode:disabled;" class="noinput" value="" maxlength="16"></td>
							<td width="" align="center"><input type="text" name="bfr_brth_ank_off_dt" dataformat="ymdhm" style="width:110;ime-mode:disabled;" class="noinput" value="" maxlength="16"></td>
							<td align="center" colspan="3" class="input2"></td>
						</tr>
						
						<tr>
							<td class="tr2_head2" colspan="3"><strong>Anchor Drop/Away After Departure</strong></td>
							<td align="center" class="input"><input type="text" name="aft_unbrth_ank_drp_dt" dataformat="ymdhm" style="width:110;ime-mode:disabled;" class="noinput" value="" maxlength="16"></td>
							<td width="" align="center"><input type="text" name="aft_unbrth_ank_off_dt" dataformat="ymdhm" style="width:110;ime-mode:disabled;" class="noinput" value="" maxlength="16"></td>
							<td align="center" colspan="3" class="input2"></td>
						</tr>
						
						<tr>
							<td class="tr2_head2" colspan="2"><strong>Next Port ETA</strong></td>
							<td align="center" class="noinput2"><input type="text" name="nxt_port_cd" style="width:110;" class="noinput2" value="" readonly="readonly"></td>
							<td align="center" class="noinput2"><input type="text" name="nxt_eta_dt" style="width:110;" class="noinput2" value="" readonly="readonly"></td>
							<td align="center" colspan="4" class="input2"></td>
						</tr>
					</table>
					
					<!-- Grid  (S) -->
					<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
					<!-- Grid (E) -->
				<!--  biz_1   (E) -->
				
				<!--biz page (E)-->
		</td></tr>
	</table>

	</div>
	<!--TAB Vessel Movement (E) -->


	<!--TAB Vessel Condition (S) -->

	<div id="tabLayer" style="display:none">

	<table class="search">
		<tr><td style="height:2"></td></tr><tr><td>
			<table height="8" align="right">
			<tr>
				<td width="20" bgcolor="DDDDFF"></td>
				<td width="10"></td>
				<td><font size="2"><b>Departure Report Data</b></font></td>
				<td width="10"></td>
			</tr>
			</table>
		</td></tr><tr><td style="height:2"></td></tr>
       	<tr><td class="bg" style="height:363;" valign="top">
				<!--  biz_2  (S) -->
					<table width="100%" class="grid2" id="tbl_vsl_cond">
						<tr class="tr2_head">
							<td width="21%"></td>
							<td width="24%" colspan="2">Arrival</td>
							<td width="3%"></td>
							<td width="24%" colspan="2">Departure</td>
							<td width="3%"></td>
							<td width="22%" colspan="2">Supply</td>
							<td width="3%"></td>
						</tr> 
						
						<tr>
							<td class="tr2_head2"><strong>Fuel Oil</strong></td>
							<td align="right" colspan="2"><input type="text" name="arr_foil_wgt" dataformat="float" caption="99,999.99" style="width:100%;text-align:right;" class="noinput" value="" maxlength="9"></td>
							<td align="center">M/T</td>
							<td align="right" colspan="2"><input type="text" name="dep_foil_wgt" dataformat="float" caption="99,999.99" style="width:100%;text-align:right;" class="noinput" value="" maxlength="9"></td>
							<td align="center">M/T</td>
							<td align="right" colspan="2"><input type="text" name="spl_foil_wgt" dataformat="float" caption="99,999.99" style="width:100%;text-align:right;" class="noinput" value="" maxlength="9"></td>
							<td align="center">M/T</td>
						</tr>
						
						<tr>
							<td class="tr2_head2"><strong>Low Sulphur Fuel Oil</strong></td>
							<td align="right" colspan="2"><input type="text" name="arr_low_sulp_foil_wgt" dataformat="float" caption="99,999.99" style="width:100%;text-align:right;" class="noinput" value="" maxlength="9"></td>
							<td align="center">M/T</td>
							<td align="right" colspan="2"><input type="text" name="dep_low_sulp_foil_wgt" dataformat="float" caption="99,999.99" style="width:100%;text-align:right;" class="noinput" value="" maxlength="9"></td>
							<td align="center">M/T</td>
							<td align="right" colspan="2"><input type="text" name="spl_low_sulp_foil_wgt" dataformat="float" caption="99,999.99" style="width:100%;text-align:right;" class="noinput" value="" maxlength="9"></td>
							<td align="center">M/T</td>
						</tr>
						
						<tr>
							<td class="tr2_head2"><strong>Diesel Oil</strong></td>
							<td align="right" colspan="2"><input type="text" name="arr_doil_wgt" dataformat="float" caption="99,999.99" style="width:100%;text-align:right;" class="noinput" value="" maxlength="9"></td>
							<td align="center">M/T</td>
							<td align="right" colspan="2"><input type="text" name="dep_doil_wgt" dataformat="float" caption="99,999.99" style="width:100%;text-align:right;" class="noinput" value="" maxlength="9"></td>
							<td align="center">M/T</td>
							<td align="right" colspan="2"><input type="text" name="spl_doil_wgt" dataformat="float" caption="99,999.99" style="width:100%;text-align:right;" class="noinput" value="" maxlength="9"></td>
							<td align="center">M/T</td>
						</tr>
						
						<tr>
							<td class="tr2_head2"><strong>Low Sulphur Diesel Oil</strong></td>
							<td align="right" colspan="2"><input type="text" name="arr_low_sulp_doil_wgt" dataformat="float" caption="99,999.99" style="width:100%;text-align:right;" class="noinput" value="" maxlength="9"></td>
							<td align="center">M/T</td>
							<td align="right" colspan="2"><input type="text" name="dep_low_sulp_doil_wgt" dataformat="float" caption="99,999.99" style="width:100%;text-align:right;" class="noinput" value="" maxlength="9"></td>
							<td align="center">M/T</td>
							<td align="right" colspan="2"><input type="text" name="spl_low_sulp_doil_wgt" dataformat="float" caption="99,999.99" style="width:100%;text-align:right;" class="noinput" value="" maxlength="9"></td>
							<td align="center">M/T</td>
						</tr>
						
						<tr>
							<td class="tr2_head2"><strong>Fresh Water</strong></td>
							<td align="right" colspan="2"><input type="text" name="arr_frsh_wtr_wgt" dataformat="float" caption="99,999.99" style="width:100%;text-align:right;" class="noinput" value="" maxlength="9"></td>
							<td align="center">M/T</td>
							<td align="right" colspan="2"><input type="text" name="dep_frsh_wtr_wgt" dataformat="float" caption="99,999.99" style="width:100%;text-align:right;" class="noinput" value="" maxlength="9"></td>
							<td align="center">M/T</td>
							<td align="right" colspan="2"><input type="text" name="spl_frsh_wtr_wgt" dataformat="float" caption="99,999.99" style="width:100%;text-align:right;" class="noinput" value="" maxlength="9"></td>
							<td align="center">M/T</td>
						</tr>
						
						<tr>
							<td class="tr2_head2"><strong>Ballast</strong></td>
							<td align="right" colspan="2"><input type="text" name="arr_blst_wgt" dataformat="float" caption="99,999.99" style="width:100%;text-align:right;" class="noinput" value="" maxlength="9"></td>
							<td align="center">M/T</td>
							<td align="right" colspan="2"><input type="text" name="dep_blst_wgt" dataformat="float" caption="99,999.99" style="width:100%;text-align:right;" class="noinput" value="" maxlength="9"></td>
							<td align="center">M/T</td>
							<td class="tr2_head" colspan="2"><strong>Discharging</strong></td>
							<td class="tr2_head"></td>
						</tr>
						
						<tr>
							<td class="tr2_head2"><strong>Draft Forward</strong></td>
							<td align="right" colspan="2"><input type="text" name="arr_fwddr_hgt" dataformat="float" caption="99.99" style="width:100%;text-align:right;" class="noinput" value="" maxlength="5"></td>
							<td align="center">M</td>
							<td align="right" colspan="2"><input type="text" name="dep_fwddr_hgt" dataformat="float" caption="99.99" style="width:100%;text-align:right;" class="noinput" value="" maxlength="5"></td>
							<td align="center">M</td>
							<td class="tr2_head2"><strong>Sludge</strong></td>
							<td align="right"><input type="text" name="ttl_slg_wgt" dataformat="float" caption="99,999.99" style="width:100%;text-align:right;" class="noinput" value="" maxlength="9"></td>
							<td align="center">M/T</td>
						</tr>
						
						<tr>
							<td class="tr2_head2"><strong>Draft After</strong></td>
							<td align="right" colspan="2"><input type="text" name="arr_aftdr_hgt" dataformat="float" caption="99.99" style="width:100%;text-align:right;" class="noinput" value="" maxlength="5"></td>
							<td align="center">M</td>
							<td align="right" colspan="2"><input type="text" name="dep_aftdr_hgt" dataformat="float" caption="99.99" style="width:100%;text-align:right;" class="noinput" value="" maxlength="5"></td>
							<td align="center">M</td>
							<td class="tr2_head2"><strong>Garbage</strong></td>
							<td align="right"><input type="text" name="ttl_gbg_qty" dataformat="float" caption="99,999.99" style="width:150;text-align:right;" class="noinput" value="" maxlength="9"></td>
							<td align="center">CBM</td>
						</tr>
						
						<tr>
							<td class="tr2_head2"><strong>GM</strong></td>
							<td align="right" colspan="2"><input type="text" name="arr_gm_hgt" dataformat="float" caption="99.99" style="width:100%;text-align:right;" class="noinput" value="" maxlength="5"></td>
							<td align="center">M</td>
							<td align="right" colspan="2"><input type="text" name="dep_gm_hgt" dataformat="float" caption="99.99" style="width:100%;text-align:right;" class="noinput" value="" maxlength="5"></td>
							<td align="center">M</td>
							<td align="center" class="input2" colspan="3"></td>
						</tr>
						
						<tr>
							<td class="tr2_head2"><strong>No.of TUG</strong></td>
							<td align="right" colspan="2"><input type="text" name="arr_tug_bot_knt" dataformat="float" caption="99" style="width:100%;text-align:right;" class="noinput" value="" maxlength="2"></td>
							<td align="center">EA</td>
							<td align="right" colspan="2"><input type="text" name="dep_tug_bot_knt" dataformat="float" caption="99" style="width:100%;text-align:right;" class="noinput" value="" maxlength="2"></td>
							<td align="center">EA</td>
							<td align="left" colspan="3" class="input2"></td>
						</tr>
					</table> 
				<!--  biz_1   (E) -->
				
				<!--biz page (E)-->
		</td></tr>
	</table>

	</div>

	<!--TAB Vessel Condition (E) -->
					
	
					
	
	
	
	<!--Button (S) -->
	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
      	<tr><td class="btn1_bg">
	    <table border="0" cellpadding="0" cellspacing="0">
	    <tr><td>
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
				<td class="btn1_right"></td>
				</tr>
			</table>
			</td>
			<td>
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_new" id="btn_new">New</td>
				<td class="btn1_right"></td>
				</tr>
			</table>
			</td>
			<td class="btn1_line"></td>
			<td>
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_save">Save</td>
				<td class="btn1_right"></td>
				</tr>
			</table>
			</td>
			
			<td>
			<div id="target_delete" style="display:none;">
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_delete">Delete</td>
				<td class="btn1_right"></td>
				</tr>
			</table>
			</div>
		</td></tr>
		</table>
	</td></tr>
	</table>	
    <!--Button (E) -->
    
    <!--Remark Tooltip (S) -->
    <div id="msg_box" style="display:none">
    <table width="100%" class="grid2">
    	<tr><td><div id="msg" style="position:absolute;left:0;top:0;width:0;height:0;"></div></td></tr>
    </table>
    </div>
    <!--Remark Tooltip (E) -->
</td></tr>
</table>

 <div class="layer_popup" style="position:absolute;margin-left:280px;top:198px;visibility:hidden" id="layer_popup"> 
 	<p align="center"> <a href="javascript:layer_popup_hide();">
 	<img src="/hanjin/img/alps/vop_vsk_layerpopup.gif" border="0" >
 	</a></p>
 </div>
 
<div id="popLayer" style="display:none">
<table class="height_5"><tr><td></td></tr></table>
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"> 
      		<tr><td class="btn3_bg">
	    	<table border="0" cellpadding="0" cellspacing="0">
	    	<tr>
			<td>
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_Close">Close</td>
				<td class="btn1_right"></td>
				</tr></table>
			</td></tr>
			</table>
		</td></tr>
	</table>
</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
</div>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>