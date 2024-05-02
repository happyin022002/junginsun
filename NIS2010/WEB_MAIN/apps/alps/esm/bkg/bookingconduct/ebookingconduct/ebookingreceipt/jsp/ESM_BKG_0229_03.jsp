﻿<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0229_03.jsp
*@FileTitle : e-Booking & SI Process Detail(CONTAINER)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.10
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.06.10 전용진
* 1.0 Creation
===============================================================================
 History
 2010.09.13 이일민 [CHM-201005276-01] ALPS-[BKG/DOC]주요UI버턴-단축키 기능개발
 2012.10.30 이재위 [CHM-201220674] [ALPS BKG] Split 01-Container Loading List 화면상 Seal KindCode 추가 요청
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg022903Event"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.common.*" %>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO" %>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.*" %>
<%@ page import="com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.ContainerVO" %>
<%@ page import="com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrInfoOutVO" %>
<%@ page import="com.hanjin.syscommon.common.table.*" %>
<%@ page import="com.hanjin.framework.core.controller.DefaultViewAdapter" %>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List" %>

<%
	EsmBkg022903Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.EBookingConduct.EBookingReceipt");

	List<BkgComboVO> seal_knd_cd 			= null;
	List<BkgComboVO> seal_pty_tp_cd 			= null;
	List<BkgComboVO> wgt_cd 			= null;
	List<BkgComboVO> meas_cd 			= null;
	List<BkgComboVO> rcv_term_cd		= null;
	List<BkgComboVO> de_term_cd		= null;
//	List<AlpsCntrVO> alpsCntrList = null;
//	List<BkgCntrSealNoVO> alpsCntrSealNoList = null;
	List<ContainerVO> alpsCntrList = null;
	List<BkgCntrSealNoVO> alpsCntrSealNoList = null;
	List<XterCntrVO> xterCntrList = null;
	List<BkgXterCntrSealNoVO> xterCntrSealNoList = null;
	String sXml = null;
	
	String seal_knd_cd_list = "";
	String seal_pty_tp_cd_list = "";
	String wgt_cd_list = "";
	String wgt_nm_list = "";
	String meas_cd_list = "";
	String meas_nm_list = "";
	String rcv_term_cd_list = "";
	String de_term_cd_list =  "";

	String fnl_cfm_flg = "";
	String evnt_usr_id = "";
	String evnt_dt = "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg022903Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		DefaultViewAdapter adapter = new DefaultViewAdapter();
		sXml = adapter.makeXML(request, response);

		ExternalRqstCntrVO rqstCnrtVo = (ExternalRqstCntrVO) eventResponse.getCustomData("externalRqstCntrVO");
		CntrInfoOutVO bkgCntrVO  = (CntrInfoOutVO) eventResponse.getCustomData("bkgCntrVO");
		alpsCntrList = bkgCntrVO.getCntrs();
		alpsCntrSealNoList = bkgCntrVO.getCntrSealNos();
		
		xterCntrList = rqstCnrtVo.getXterCntrVO();
		xterCntrSealNoList = rqstCnrtVo.getBkgXterCntrSealNoVO();
		  
		seal_knd_cd 			= (List<BkgComboVO>) eventResponse.getCustomData("seal_knd_cd");
		seal_pty_tp_cd 			= (List<BkgComboVO>) eventResponse.getCustomData("seal_pty_tp_cd");
		wgt_cd 			= (List<BkgComboVO>) eventResponse.getCustomData("wgt_cd");
		meas_cd 		= (List<BkgComboVO>) eventResponse.getCustomData("meas_cd");
		rcv_term_cd    	= (List<BkgComboVO>) eventResponse.getCustomData("rcv_term_cd");
		de_term_cd    	= (List<BkgComboVO>) eventResponse.getCustomData("de_term_cd");
		fnl_cfm_flg     = eventResponse.getETCData("fnl_cfm_flg");
		evnt_usr_id     = eventResponse.getETCData("evnt_usr_id");
		evnt_dt     	= eventResponse.getETCData("evnt_dt");
		
		for(int i=0;i<seal_knd_cd.size();i++){
			if ( i == 0 ) {
				seal_knd_cd_list = "|" + ((BkgComboVO )seal_knd_cd.get(i)).getVal();
			} else {
				seal_knd_cd_list = seal_knd_cd_list + "|" + ((BkgComboVO )seal_knd_cd.get(i)).getVal();
			}			
		}
		for(int i=0;i<seal_pty_tp_cd.size();i++){
			if ( i == 0 ) {
				seal_pty_tp_cd_list = "|" + ((BkgComboVO )seal_pty_tp_cd.get(i)).getVal();
			} else {
				seal_pty_tp_cd_list = seal_pty_tp_cd_list + "|" + ((BkgComboVO )seal_pty_tp_cd.get(i)).getVal();
			}			
		}
		for(int i=0;i<wgt_cd.size();i++){
			if ( i == 0 ) {
				wgt_cd_list = ((BkgComboVO )wgt_cd.get(i)).getVal();
				wgt_nm_list = ((BkgComboVO )wgt_cd.get(i)).getName();
			} else {
				wgt_cd_list = wgt_cd_list + "|" + ((BkgComboVO )wgt_cd.get(i)).getVal();
				wgt_nm_list = wgt_nm_list + "|" + ((BkgComboVO )wgt_cd.get(i)).getName();
			}			
		}
		for(int i=0;i<meas_cd.size();i++){
			if ( i == 0 ) {
				meas_cd_list = ((BkgComboVO )meas_cd.get(i)).getVal();
				meas_nm_list = ((BkgComboVO )meas_cd.get(i)).getName();
			} else {
				meas_cd_list = meas_cd_list + "|" + ((BkgComboVO )meas_cd.get(i)).getVal();
				meas_nm_list = meas_nm_list + "|" + ((BkgComboVO )meas_cd.get(i)).getName();
			}			
		}
		for(int i=0;i<rcv_term_cd.size();i++){
			if ( i == 0 ) {
				rcv_term_cd_list = ((BkgComboVO )rcv_term_cd.get(i)).getVal();
			} else {
				rcv_term_cd_list = rcv_term_cd_list + "|" + ((BkgComboVO )rcv_term_cd.get(i)).getVal();
			}			
		}
		for(int i=0;i<de_term_cd.size();i++){
			if ( i == 0 ) {
				de_term_cd_list = ((BkgComboVO )de_term_cd.get(i)).getVal();
			} else {
				de_term_cd_list = de_term_cd_list + "|" + ((BkgComboVO )de_term_cd.get(i)).getVal();
			}			
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>e-Booking & SI Process Detail(CONTAINER)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		
		seal_knd_cd_list = 	"<%=seal_knd_cd_list%>";
		seal_pty_tp_cd_list = 	"<%=seal_pty_tp_cd_list%>";
		wgt_cd_list = 	"<%=wgt_cd_list%>";
		wgt_nm_list = 	"<%=wgt_nm_list%>";
		meas_cd_list =  "<%=meas_cd_list%>";
		meas_nm_list =  "<%=meas_nm_list%>";
		rcv_term_cd_list = 	"<%=rcv_term_cd_list%>";
		de_term_cd_list =  "<%=de_term_cd_list%>";
			    
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;padding-left:0;">
	<tr><td valign="top">
		<!--biz page (S)-->
		<!-- Grid BG Box  (S) -->
     	<table class="search" id="mainTable" style="width:958;height:595;">
       	<tr><td class="bg" valign="top">

				<table class="search" border="0" style="width:958;"> 
				<tr class="h23">
					
					<td width="480" valign="top">
					<!--  biz_1  (S) -->
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="cntr_no">
<input type="hidden" name="bkg_no" value="<%=StringUtil.xssFilter(request.getParameter("bkg_no"))%>">
<input type="hidden" name="rqst_no" value="<%=StringUtil.xssFilter(request.getParameter("rqst_no"))%>">
<input type="hidden" name="rqst_seq" value="<%=StringUtil.xssFilter(request.getParameter("rqst_seq"))%>">
<input type="hidden" name="sender_id" value="<%=StringUtil.xssFilter(request.getParameter("sender_id"))%>">
<input type="hidden" name="cntr_nis" value="<%//=(alpsCntrList.size() > 0)?"Y":"N"%>">
<input type="hidden" name="cntr_esvc" value="<%=(xterCntrList.size() > 0)?"Y":"N"%>">
<!-- CNTR Flag	-->
<input type="hidden" name="dirty_flag" value="Y">
<input type="hidden" name="bdr_flg" value="N">
<input type="hidden" name="fnl_cfm_flg" value="<%=fnl_cfm_flg%>">
<input type="hidden" name="modify_fnl_cfm_flg">
<input type="hidden" name="rsk_flg" value="N">

<input type="hidden" name="sXml" value="<%=JSPUtil.replace(sXml, "\"", "&quot;")%>">					
					<table class="search" border="0">
						<tr>
							<td width="220"><table class="search" border="0">
									<tr><td class="title_h"></td>
										<td class="title_s">Booking Data ALPS</td></tr>
									<tr><td class="height_5"></td></tr>
								</table>
							</td>
							<td width="100">
								<b>Show VGM</b> <input type="checkbox" name="showVgmChk">
							</td>
							<td  width="150" align="right"><table width="150"  border="0" cellpadding="0" cellspacing="0" class="button">
								<tr></td>
								<td class="btn2_left"></td>
								<td class="btn2" name="btn_cancelcopydata">Cancel&nbsp;Copy&nbsp;Data</td>
								<td class="btn2_right"></td>
								</tr>
							</table></td>
						</tr>
					</table>
					<table class="search_ssm" border="0" style="width:480;">
					<tr class="h23"><td>
						<table class="search" border="0">
							<tr class="h23">
								<td width="10"></td>
								<td>Booking No.&nbsp;&nbsp;<input type="text" name="bkg_no2" style="width:119;" class="input2" value="<%=StringUtil.xssFilter(request.getParameter("bkg_no"))%>" readOnly></td>
								<td>Final Confirm&nbsp;<input type="text" name="evnt_usr_id2" style="width:80;" class="input2" value="<%=evnt_usr_id%>" readOnly>
								<input type="text" name="evnt_dt2" style="width:70;" class="input2" value="<%=evnt_dt%>" readOnly></td>
							</tr>
						</table>
<%
	int seq = 0;
	String tmpSealKndCd = "";
	String tmpSealPtyTpCd = "";
	for (int i=0;i<alpsCntrList.size();i++) {
		seq = i+1;
		tmpSealKndCd = "";
		tmpSealPtyTpCd = "";
		ContainerVO alpsCntr = (ContainerVO) alpsCntrList.get(i);		
%>
<div id="table_<%=seq%>">
						<table id="table<%=seq%>" class="search" border="0" >
							<tr>
							<input type="hidden" name="table<%=seq%>" value="table<%=seq%>">
							<input type="hidden" name="cntr_no_hidden__<%=seq%>" value="<%=alpsCntr.getCntrNo()%>1">	<!-- e-svc는 컨테이너 Seq가 있으므로 alps에 없는 Seq를 맞추기 위해 1이 있음 -->
							<input type="hidden" name="ibflag__<%=seq%>" value="U">							
							</tr>
							<tr class="h23">
								<td width="30" rowspan="6" valign="top"><input type="text" name="cntr_seq__<%=seq%>" style="width:25;text-align:center;" class="input" value="<%=seq%>" readOnly></td>
								<td width="62">CNTR No.</td>
								<td width="130"><input type="text" name="cntr_no__<%=seq%>" style="width:94;" maxlength="14" dataformat="engup" class="<%=("Y".equals(fnl_cfm_flg))?"input2":"input" %>" value="<%=alpsCntr.getCntrNo()%>" onChange="javascript:changeCntrTpszCd(this);">
								&nbsp;<input type="text" name="cntr_tpsz_cd__<%=seq%>" style="width:21;" maxlength="4" dataformat="engup" readOnly class=<%=("Y".equals(fnl_cfm_flg))?"input2":"input" %> value="<%=alpsCntr.getCntrTpszCd()%>"></td>
								<td width="68">&nbsp;</td>
								<td width="128">&nbsp;</td>
								<td width="">P&nbsp;<input type="checkbox" value="" class="trans" name="cntr_prt_flg__<%=seq%>" value="<%=alpsCntr.getCntrPrtFlg()%>" <%=("Y".equals(alpsCntr.getCntrPrtFlg()))?"checked":""%> <%=("Y".equals(fnl_cfm_flg))?"disabled":""%>></td>
							</tr>
							<tr class="h23">
								<td>Seal No.</td>
								<td>
								<select name="cntr_seal_no__<%=seq%>" style="width:117;" onChange="changeBkgSealNo(this.name, this.selectedIndex)">&nbsp;
								<script language="javascript">
									sealKndCdArr[<%=seq%>] = new Array(); 
									sealPtyTpCdArr[<%=seq%>] = new Array();
								</script>	
<%
	for (int j=0;j<alpsCntrSealNoList.size();j++) {
		BkgCntrSealNoVO alpsCntrSealNo = (BkgCntrSealNoVO) alpsCntrSealNoList.get(j);
		if ( alpsCntrSealNo.getCntrNo().equals(alpsCntr.getCntrNo()) ) {
			if( alpsCntrSealNo.getCntrSealSeq().equals("1") ) {
				tmpSealKndCd = alpsCntrSealNo.getSealKndCd();
				tmpSealPtyTpCd = alpsCntrSealNo.getSealPtyTpCd();
			}
%>
									<option value="<%=replaceNull(alpsCntrSealNo.getCntrSealNo())%>"><%=replaceNull(alpsCntrSealNo.getCntrSealNo())%></option>
<%
			if ( !alpsCntrSealNo.getSealKndCd().equals("") ) {
%>
									<script language="javascript">
										if(sealKndCdArr.length>0){
											sealKndCdArr[<%=seq%>][(<%=alpsCntrSealNo.getCntrSealSeq()%>-1)] = <%="\"" + alpsCntrSealNo.getSealKndCd() + "\""%>; 
										}
									</script>	
<%
			}
			if ( !alpsCntrSealNo.getSealPtyTpCd().equals("") ) {
%>
									<script language="javascript">
										if(sealPtyTpCdArr.length>0){
											sealPtyTpCdArr[<%=seq%>][(<%=alpsCntrSealNo.getCntrSealSeq()%>-1)] = <%="\"" + alpsCntrSealNo.getSealPtyTpCd() + "\""%>;
										}
									</script>	
<%
			}
		}
	}
%>
								</select>
								</td>
								<td>KIND/CODE</td>
								<td colspan="2"><%=HTMLUtil.getComboString2("seal_knd_cd__"+seq, "width:41;", "", "javascript:changeBkgSealKndCd(this.name);", tmpSealKndCd, "", seal_knd_cd)%>
								<%=HTMLUtil.getComboString2("seal_pty_tp_cd__"+seq, "width:41;", "", "javascript:changeBkgSealPtyTpCd(this.name);", tmpSealPtyTpCd, "", seal_pty_tp_cd)%></td>
							</tr>
							<tr class="h23">
								<td>Package</td>
								<td><input type="text" name="pck_qty__<%=seq%>" style="width:65;text-align:right" maxlength="12" dataformat="int" class="input" value="<%=alpsCntr.getPckQty()%>">
								&nbsp;<input type="text" name="pck_tp_cd__<%=seq%>" style="width:27;" dataformat="engup" class="input" value="<%=alpsCntr.getPckTpCd()%>">
								&nbsp;<a href="javascript:comBkgCallPop0696_position('setCallBack0696', document.form.pck_tp_cd__<%=seq%>.value, '<%=seq%>');"><img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
								<td>Weight</td>
								<td>&nbsp;<input type="text" name="cntr_wgt__<%=seq%>" style="width:70;text-align:right" maxlength="18" dataformat="float" pointcount="3" class="input" value="<%=alpsCntr.getCntrWgt()%>">
								<%=HTMLUtil.getComboString("wgt_cd__"+seq, "width:41;", "", "",alpsCntr.getWgtUtCd(), "", wgt_cd)%></td>								
								<td valign="bottom" rowspan="1">
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
<%
	if ( "Y".equals(fnl_cfm_flg) ) {
%>
									<td class="btn2" name="btn_delete<%=seq%>">Delete</td>
<script>ComBtnDisable("btn_delete<%=seq%>")</script>
<%
	} else {
%>
									<a href="javascript:btn_deleteTable('table<%=seq%>','<%=seq%>');"><td class="btn2" name="btn_delete<%=seq%>">Delete</td>
<%
	}
%>
									<td class="btn2_right"></td>
									</tr>
									</table>
								</td>
							</tr>
							<tr class="h23 vgm_b_div">								
								<td>VGM</td>
								<td>&nbsp;<input type="text" name="vgm_wgt__<%=seq%>" style="width:70;text-align:right" maxlength="18" dataformat="float" pointcount="3" class="input" value="<%=alpsCntr.getVgmWgt()%>">
								<%=HTMLUtil.getComboString("vgm_wgt_ut_cd__"+seq, "width:41;", "", "",alpsCntr.getVgmWgtUtCd(), "", wgt_cd)%>
								</td>
								<td class="vgm_div" style="display:none;">Signature</td>
								<td colspan="2" class="vgm_div" style="display:none;"><input type="text" name="vgm_vrfy_sig_ctnt__<%=seq%>" style="width:110;text-align:left" maxlength="100" dataformat="eng" class="input" value="<%=alpsCntr.getVgmVrfySigCtnt()%>" readonly></td>
							</tr>
							<tr class="h23 vgm_div" style="display:none;">								
								<td>Verf. Date</td>
								<td colspan="1">&nbsp;<input type="text" name="vgm_vrfy_dt__<%=seq%>" style="width:70;text-align:right" maxlength="18" dataformat="" pointcount="3" class="input" value="<%=alpsCntr.getVgmVrfyDt()%>" readonly>
								</td>								
								<td colspan="1">Method
								</td>			
								<td colspan="2">									
									<select name="vgm_mzd_tp_cd__<%=seq%>" class="input2" style="width:110;" >
										<option value="" ></option>
										<option value="SM1" <%= "SM1".equals(alpsCntr.getVgmMzdTpCd()) ? "selected" : "" %>>Method 1 : Weighting of a packed container.</option>
										<option value="SM2" <%= "SM2".equals(alpsCntr.getVgmMzdTpCd()) ? "selected" : "" %>>Method 2 : Calculating VGM (Cargo weight + packing material + container tare weight )</option>
									</select>
									<input type="hidden" name="vgm_dtmn_dt__<%=seq%>" value="">
								</td>
								
							</tr>
							<tr class="h23">
								<td>Measure</td>
								<td><input type="text" name="meas_qty__<%=seq%>" style="width:65;text-align:right" maxlength="12" dataformat="float" pointcount="3" class="input" value="<%=alpsCntr.getMeasQty()%>">
								<%=HTMLUtil.getComboString("meas_cd__"+seq, "width:51;", "", "",alpsCntr.getMeasUtCd(), "", meas_cd)%>
								</td>
								<td>R/D Term</td>
								<td>
									<!-- <script language="javascript">ComComboObject('rcv_term_cd__<%//=seq%>', 1, 45, 2, 0, 0)</script>&nbsp;
									<script language="javascript">ComComboObject('de_term_cd__<%//=seq%>', 1, 45, 2, 0, 0)</script>  -->
									<%=HTMLUtil.getComboString("rcv_term_cd__"+seq, "width:51;", "", "",alpsCntr.getRcvTermCd(), "", rcv_term_cd)%>
									<%=HTMLUtil.getComboString("de_term_cd__"+seq, "width:51;", "", "",alpsCntr.getDeTermCd(), "", de_term_cd)%>
								</td>
							</tr>
							<tr>
								<!-- <td>P/O No.</td> -->
								<td><input type="hidden" name="po_no__<%=seq%>" style="width:115;" maxlength="20" dataformat="engup" class="input" value="<%=alpsCntr.getPoNo()%>"></td>
							</tr>
							<tr class="height_10"><td colspan="8"></td></tr>
						</table>
</div>
<%
	}
%>

<span id="INS_TABLES">
</span>

					</td></tr>
					</table>
</form>
					<!--  biz_1  (E) -->
					</td>
					<td width="12">&nbsp;</td>
					<!--  biz_2  (S) -->
					<td width="479" valign="top">
<form name="form2">
					<table class="search" border="0">
						<tr>
							<td width="240"><table class="search" border="0">
									<tr><td class="title_h"></td>
										<td class="title_s">From e- Service</td></tr>
									<tr><td class="height_5"></td></tr>
								</table>
							</td>
							<td  width="240" align="right"><table width="150" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn_datacopytoalps">Data&nbsp;Copy&nbsp;to&nbsp;ALPS</td>
								<td class="btn2_right"></td>
								</tr>
								</table>
							</td>
							</tr>
					</table>
					<table class="search_ssm1" border="0" style="width:479;">
					<tr class="h23"><td valign="top">
						<table class="search" border="0">
							<tr class="h23">
								<td width="15"> </td>
								<td>Request No.&nbsp;&nbsp;<input type="text" name="rqst_no2" style="width:170;" class="input2" value="<%=StringUtil.xssFilter(request.getParameter("rqst_no"))%>" readOnly></td>
							</tr>
						</table>
<%
	int seq2 = 0;
	for (int i=0;i<xterCntrList.size();i++) {
		seq2 = i+1;
		XterCntrVO xterCntr = (XterCntrVO) xterCntrList.get(i);
%>
						<table class="search" border="0">
							<tr>
							<input type="hidden" name="cntr_no_hidden__<%=seq2%>" value="<%=xterCntr.getCntrNo()%><%=xterCntr.getCntrSeq()%>">
							</tr>
							<tr class="h23">
								<td width="30" rowspan="6" valign="top"><input type="text" name="cntr_seq__<%=seq2%>" style="width:25;text-align:center;" class="input2" value="<%=seq2%>" readOnly></td>
								<td width="62">CNTR No.</td>
								<td width="130"><input type="text" name="cntr_no__<%=seq2%>" style="width:90;" class="input2" value="<%=xterCntr.getCntrNo()%>" readOnly>
								&nbsp;<input type="text" name="cntr_tpsz_cd__<%=seq2%>" style="width:26;" class="input2" value="<%=xterCntr.getCntrTpszCd()%>" readOnly></td>
								<td width="70">&nbsp;</td>
								<td width="90">&nbsp;</td>
								<td width="">P&nbsp;<input type="checkbox" name="prt_flg__<%=seq2%>" value="<%=xterCntr.getPrtFlg()%>" <%=("Y".equals(xterCntr.getPrtFlg()))?"checked":""%> class="trans" disabled></td>
							</tr>
							<tr class="h23">
								<td>Seal No.</td>
								<td>
								<select name="cntr_seal_no__<%=seq2%>" class="input2" style="width:118;" onChange="changeXterSealNo(this.name, this.selectedIndex)">&nbsp;
<%
	for (int j=0;j<xterCntrSealNoList.size();j++) {
		BkgXterCntrSealNoVO xterCntrSealNo = (BkgXterCntrSealNoVO) xterCntrSealNoList.get(j);
		if ( xterCntrSealNo.getCntrNo().equals(xterCntr.getCntrNo()) ) {
%>
									<option value="<%=replaceNull(xterCntrSealNo.getXterCntrSealNo())%>"><%=replaceNull(xterCntrSealNo.getXterCntrSealNo())%></option>
<%
		}
	}
%>
								</select>
								</td>
								<td>KIND/CODE</td>
								<td colspan="2">
								<select disabled="disabled" name="seal_knd_cd__<%=seq2%>" class="input2" style="width:40;">&nbsp;
<%
	for (int j=0;j<xterCntrSealNoList.size();j++) {
		BkgXterCntrSealNoVO xterCntrSealNo = (BkgXterCntrSealNoVO) xterCntrSealNoList.get(j);
		if ( xterCntrSealNo.getCntrNo().equals(xterCntr.getCntrNo()) ) {
%>
									<option value="<%=replaceNull(xterCntrSealNo.getSealKndCd())%>"><%=replaceNull(xterCntrSealNo.getSealKndCd())%></option>
<%
		}
	}
%>
								</select>
								<select disabled="disabled" name="seal_pty_tp_cd__<%=seq2%>" class="input2" style="width:40;">&nbsp;
<%
	for (int j=0;j<xterCntrSealNoList.size();j++) {
		BkgXterCntrSealNoVO xterCntrSealNo = (BkgXterCntrSealNoVO) xterCntrSealNoList.get(j);
		if ( xterCntrSealNo.getCntrNo().equals(xterCntr.getCntrNo()) ) {
%>
									<option value="<%=replaceNull(xterCntrSealNo.getSealPtyNm())%>"><%=replaceNull(xterCntrSealNo.getSealPtyNm())%></option>
<%
		}
	}
%>
								</select>						
								</td>
							</tr>
							<tr class="h23">
								<td>Package</td>
								<td><input type="text" name="pck_qty__<%=seq2%>" style="width:65;text-align:right" class="input2" value="<%=xterCntr.getPckQty()%>" readOnly>
								&nbsp;<input type="text" name="pck_tp_cd__<%=seq2%>" style="width:51;" class="input2" value="<%=xterCntr.getPckTpCd()%>" readOnly></td>
								<td>Weight</td>
								<td colspan="2">&nbsp;<input type="text" name="cntr_wgt__<%=seq2%>" style="width:70;text-align:right" class="input2" value="<%=xterCntr.getCntrWgt()%>" readOnly>
								<input type="text" name="wgt_cd__<%=seq2%>" style="width:43;" class="input2" value="<%=xterCntr.getWgtUtCd()%>" readOnly>
								</td>
							</tr>
							<tr class="h23 vgm_b_div">								
								<td>VGM</td>
								<td colspan="1">&nbsp;<input type="text" name="vgm_wgt__<%=seq2%>" style="width:70;text-align:right" class="input2" value="<%=xterCntr.getVgmWgt()%>" readOnly>
								<input type="text" name="vgm_wgt_ut_cd__<%=seq2%>" style="width:43;" class="input2" value="<%=xterCntr.getVgmWgtUtCd()%>" readOnly>
								</td>
								<td class="vgm_div" style="display:none;">Signature</td>
								<td colspan="2" class="vgm_div" style="display:none;"><input type="text" name="vgm_vrfy_sig_ctnt__<%=seq2%>"style="width:110;text-align:left" class="input2" value="<%=xterCntr.getVgmVrfySigCtnt()%>" readOnly></td>								
							</tr>
							<tr class="h23 vgm_div" style="display:none;">								
								<td>Verf. Date</td>
								<td colspan="1">&nbsp;<input type="text" name="vgm_vrfy_dt__<%=seq2%>" style="width:70;text-align:right" class="input2" value="<%=xterCntr.getVgmVrfyDt()%>" readOnly>
								</td>
								<td>Method
								</td>
								<td colspan="2">									
									<input type="text" style="width:110;" readonly class="input2" name="vgm_mzd_tp_cd__<%=seq2%>" value="<%=xterCntr.getVgmMzdTpCd()%>">									
									<input type="hidden" name="vgm_dtmn_dt__<%=seq2%>" value="">
								</td>
							</tr>
							<tr class="h23">
								<td>Measure</td>
								<td><input type="text" name="meas_qty__<%=seq2%>" style="width:65;text-align:right" class="input2" value="<%=xterCntr.getMeasQty()%>" readOnly>
								<input type="text" name="meas_cd__<%=seq2%>" style="width:52;" class="input2" value="<%=xterCntr.getMeasUtCd()%>" readOnly>
								</td>
								<td>R/D Term</td>
								<td colspan="2">&nbsp;<input type="text" name="rcv_term_cd__<%=seq2%>" style="width:45;" class="input2" value="" readOnly>
								<input type="text" name="de_term_cd__<%=seq2%>" style="width:45;" class="input2" value="" readOnly>
								</td>
							</tr>
							<tr>								
								<!-- <td>P/O No.</td>  -->
								<td colspan="2"><input type="hidden" name="po_no__<%=seq2%>" style="width:117;" class="input2" value="<%=xterCntr.getPoNo()%>" readOnly></td>
							</tr>
							<tr class="height_10"><td colspan="8"></td></tr>
						</table>
<%
	}
%>
					</td></tr>
					</table>
					<!--  biz_2  (E) -->
</form>						
					</td></tr>
				</table>
			</td></tr>
		</table>
		<!-- Grid BG Box  (S) -->
		<!--Button (S) -->
		<!-- <table width="980" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_upload">Upload</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				</tr>
			</table></td>
		</tr>
		</table> -->
    	<!--Button (E) -->	
	</td></tr>
</table>																													
<!--biz page (E)-->
<table width="958"  id="mainTable"> 
	<tr>
		<td width="100%">
			<script language="javascript">ComSheetObject('sheet1');</script>
		</td>
	</tr>
</table> 
<table width="500"  id="mainTable"> 
	<tr>
		<td width="100%">
			<script language="javascript">ComSheetObject('sheet2');</script>
		</td>
	</tr>
</table> 
</body>
</html>
<%!public String replaceNull(String str) {
		return (str == null || str.trim().length() == 0 || "null".equals(str)) ? ""
				: str;
	}%>