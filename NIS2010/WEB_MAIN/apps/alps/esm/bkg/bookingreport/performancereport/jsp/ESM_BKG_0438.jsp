<%
/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0438.jsp
 *@FileTitle : Queue Detail
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.13
 *@LastModifier : 김경섭
 *@LastVersion : 1.0
 * 2009.05.13 김경섭
 * 1.0 Creation
 * --------------------------------------------------------
 * History
 * 2011.05.11 김상수 [CHM-201109394-01] DPCS 고도화 요청 - B/L Turn Time Report (ESM_BKG_0067) 화면에서 호출할 때 하단 버튼들 숨김
 * 2011.05.16 김상수 [CHM-201109394-01] DPCS 고도화 요청 - B/L Turn Time Report (ESM_BKG_0067) 화면에서 호출할 때 (수정)
 * 2011.10.04 정선용 [CHM-201112445] SI Automation System 구축 
 * 2013.02.04 김진주 [CHM-201322653] Pending부킹에 한해 DPCS Queue List 상 Queue Details의 Retrieve 버튼 비활성화(삭제)
 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0438Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0438Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	boolean bBtn_Disabled = true;
	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0438Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request
				.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
	  String bkg_no   			= JSPUtil.getNull(JSPUtil.getParameter(request,"bkg_no"));
	  String sr_kind  			= JSPUtil.getNull(JSPUtil.getParameter(request,"sr_kind"));
	  String sr_no    			= JSPUtil.getNull(JSPUtil.getParameter(request,"sr_no"));
	  String pnd_flg  			= JSPUtil.getNull(JSPUtil.getParameter(request,"pnd_flg"));
	  String src_cd   			= JSPUtil.getNull(JSPUtil.getParameter(request,"src_cd"));
	  String sr_crnt_info_cd 	= JSPUtil.getNull(JSPUtil.getParameter(request,"sr_crnt_info_cd"));
	  String sr_crnt_sts_cd  	= JSPUtil.getNull(JSPUtil.getParameter(request,"sr_crnt_sts_cd"));
	  String ui_id           	= JSPUtil.getNull(JSPUtil.getParameter(request,"ui_id"));
	  String grp_cd				= JSPUtil.getNull(JSPUtil.getParameter(request,"grp_cd"));
	  String bl_doc_inp_flg  	= JSPUtil.getNull(JSPUtil.getParameter(request,"bl_doc_inp_flg"));
	  String bl_rt_flg		 	= JSPUtil.getNull(JSPUtil.getParameter(request,"bl_rt_flg"));
	  String bl_aud_flg		 	= JSPUtil.getNull(JSPUtil.getParameter(request,"bl_aud_flg"));
	  String bl_drft_fax_out_flg= JSPUtil.getNull(JSPUtil.getParameter(request,"bl_drft_fax_out_flg"));

	  String sr_wrk_sts_cd		= JSPUtil.getNull(JSPUtil.getParameter(request,"sr_wrk_sts_cd"));
	  String xter_sndr_id		= JSPUtil.getNull(JSPUtil.getParameter(request,"xter_sndr_id"));
	  String row_idx			= JSPUtil.getNull(JSPUtil.getParameter(request,"row_idx"));

	  String bl_doc_inp_flg_r 		= null;
	  String bl_rt_flg_r  			= null;
	  String bl_aud_flg_r           = null;
	  String bl_drft_fax_out_flg_r  = null;
	  // pop_mode
	  String popMode = JSPUtil.getNull(JSPUtil.getParameter(request,"pop_mode"));
	  String mrdSaveDialogDir = "";
	  
	  String strTemp1 = System.getProperty("user.home");
	  if (strTemp1 != null) {		  
	  } else {
		  strTemp1 = "";
	  }
	  String strTemp2 = System.getProperty("file.separator");
	  if (strTemp2 != null) {		  
	  } else {
		  strTemp2 = "";
	  }
	  mrdSaveDialogDir = strTemp1 + strTemp2;

%>
<html>
<head>
<title>Queue  Detail</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		//alert("<%= sr_no %>");
		document.form.bkg_no.value = "<%= bkg_no %>";

		loadPage();
	}
</script>
</head>

<body class="popup_bg" onLoad="setupPage();" onUnLoad="setStsCd('E');">
<div id="debug"></div>
<form name="form">
<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdArguments">
<input type="hidden" name="com_mrdBodyTitle" value="e-Booking &amp; SI Preview">
<input type="hidden" name="com_zoomIn" value="3">
<input type="hidden" name="com_mrdSaveDialogDir" value="<%=mrdSaveDialogDir%>">
<input type="hidden" name="com_mrdSaveDialogFileName">
<input type="hidden" name="com_mrdSaveDialogFileExt" value="pdf">
<input type="hidden" name="com_mrdSaveDialogFileExtLimit" value="xls@pdf@bmp@tif">
<input type="hidden" name="com_mrdTitle">
<input type="hidden" name="com_mrdDisableToolbar" value="3">
<input type="hidden" name="com_zoomIn">

	<input type="hidden" name="f_cmd"> 
	<input type="hidden" name="pagerows">
	<input type="hidden" name="sr_kind"      		value="<%=sr_kind%>">
	<input type="hidden" name="sr_no"      			value="<%=sr_no%>">
	<input type="hidden" name="pnd_flg"      		value="<%=pnd_flg%>">
	<input type="hidden" name="grp_cd"      		value="<%=grp_cd%>">
	<input type="hidden" name="usr_id"      		value="<%=strUsr_id%>">
	<input type="hidden" name="usr_nm"      		value="<%=strUsr_nm%>">
	<input type="hidden" name="src_cd"      		value="<%=src_cd%>">
	<input type="hidden" name="sr_crnt_info_cd"     value="<%=sr_crnt_info_cd%>">
	<input type="hidden" name="sr_crnt_sts_cd"      value="<%=sr_crnt_sts_cd%>">
	<input type="hidden" name="ui_id"      			value="<%=ui_id%>">
	<input type="hidden" name="sr_crnt_info_cd"     value="">
	<input type="hidden" name="com_flg" >
	<input type="hidden" name="xter_rqst_no" >
	<input type="hidden" name="xter_rqst_seq" >
	<input type="hidden" name="xter_sndr_id"        value="<%=xter_sndr_id%>">
	<input type="hidden" name="sr_wrk_sts_cd" 		value="<%=sr_wrk_sts_cd%>">
	<input type="hidden" name="sr_wrk_sts_usr_id"   value="">
	<input type="hidden" name="sr_wrk_sts_t"   		value="N">
	<input type="hidden" name="row_idx" 			value="<%=row_idx%>">

	<input type="hidden" name="input_flg" >
	<input type="hidden" name="rate_flg" >
	<input type="hidden" name="us_inp_flg" >
	<input type="hidden" name="ca_inp_flg" >
	<input type="hidden" name="rtn_from" >
	<input type="hidden" name="sr_amd_tp_cd">
	<input type="hidden" name="call_pgm_type">
	<input type="hidden" name="source">
	<input type="hidden" name="fax_log_ref_no">
	<input type="hidden" name="sr_knd_cd">
	<input type="hidden" name="tmplt_par_rto">
	<input type="hidden" name="wrk_st_tm">
<!-- 개발자 작업	-->
<table width="100%"  class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
	<tr>
		<td valign="top">
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0">
		<tr><td class="title"><img src="./img/icon_title_dot.gif" align="absmiddle">&nbsp;Queue Detail</td></tr>
		</table>
		<!--Page Title, Historical (E)--> <!-- : ( Search Options ) (S) -->

			<!--biz page (S)-->
		<table class="search">
       	<tr><td class="bg">

					<!--  biz_1  (S) -->
					<table class="search" border="0" style="width:940;">
					<tr class="h23">
						<td width="">Booking No.</td>
						<td width=""><input type="text" style="width:100" value="" class="input2" readonly name="bkg_no"></td>
						<td width="">SI No.</td>
						<td width=""><input type="text" style="width:100" value="" class="input2" readonly name="sr_no_r"></td>
						<td width="">SI Kind</td>
						<td width=""><input type="text" style="width:66" value="" class="input2" readonly name="sr_kind_r"></td>
						<td width="">Urgency</td>
						<td width=""><input type="text" style="width:66" value="" class="input2" readonly name="urgency"></td>
						<td width="">Source</td>
						<td width=""><input type="text" style="width:75" value="" class="input2" readonly name="xter_si_cd"></td>
					</tr>
					<tr class="h23">
						<td width="">VVD</td>
						<td width=""><input type="text" style="width:100" value="" class="input2" readonly name="vvd">&nbsp;
						<td width="">POL</td>
						<td width=""><input type="text" style="width:66" value="" class="input2" readonly name="pol_cd"></td>
						<td width="">POD</td>
						<td width=""><input type="text" style="width:66" value="" class="input2" readonly name="pod_cd"></td>
						<td width="">Pages of SI</td>
						<td width=""><input type="text" style="width:75" value="" class="input2" readonly name="page"></td>
					</tr>
					<tr class="h23">
						<td width="">Shipper</td>
						<td width="" colspan="5"><input type="text" style="width:30" value="" class="input2" readonly name="shipper_cnt_cd">&nbsp;
						<input type="text" style="width:61" value="" class="input2" readonly name="shipper_seq">&nbsp;
						<input type="text" style="width:403" value="" class="input2" readonly name="shipper_nm"></td>
						<td width="">Input&nbsp;<input type="text" style="width:30;text-align:center;" value="" class="input2" readonly name="bl_doc_inp_flg"></td>
						<td width="">Rate&nbsp;<input type="text" style="width:30;text-align:center;" value="" class="input2" readonly name="bl_rt_flg"></td>
						<td width="">QA&nbsp;<input type="text" style="width:30;text-align:center;" value="" class="input2" readonly name="bl_aud_flg"></td>
						<td width="">BL Proof&nbsp;<input type="text" style="width:30;text-align:center;" value="" class="input2" readonly name="bl_drft_fax_out_flg"></td>
					</tr>
					</table>

					<table class="search" border="0" style="width: 940;">
						<tr class="h23">
							<td width="76">Message</td>
							<td><textarea cols="8" rows="3" style="width: 850" name="message"></textarea></td>
						</tr>
					</table>

				<!--  biz_1   (E) -->

					<table class="search" border="0">
						<tr><td class="title_h"></td>
						<td class="title_s">Queue  History</td></tr>
						<tr><td class="height_5"></td></tr>
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

				</td>
			</tr>
		</table>

<!--Button (S) -->
		<table width="100%" class="button" border="0" name="table_btn" id="table_btn" cellpadding="0" cellspacing="0" style="padding-top:5px;<%if("2".equals(popMode) || "".equals(grp_cd) || sr_wrk_sts_cd.equals("D")){out.print("display:none");}%>">
			<tr>
				<td class="btn1_bg">

					<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td id="div_retrieve">
							<table width="100%" border="0" cellpadding="0" cellspacing="0"
								class="button">
								<tr>
									<td class="btn1_left" id="div_retrieve_l"></td>
									<td class="btn1" name="btn_Retrieve" id="div_retrieve_c">Retrieve</td>
									<td class="btn1_right" id="div_retrieve_r"></td>
								</tr>
							</table>
							</td>
							<td id="div_ebkg">
							<table width="100%" border="0" cellpadding="0" cellspacing="0"
								class="button">
								<tr>
									<td class="btn1_left" id="btn_ebkg_l"></td>
									<td class="btn1" name="btn_ebkg" id="btn_ebkg_c">Go to BKG</td>
									<td class="btn1_right" id="btn_ebkg_r"></td>
								</tr>
							</table>
							</td>
							<!--<td class="btn1_line"></td>
							--><td id="div_input_completed">
							<table width="100%" border="0" cellpadding="0" cellspacing="0"
								class="button">
								<tr>
									<td class="btn1_left" id="btn_input_completed_l"></td>
									<td class="btn1" name="btn_input_completed" id="btn_input_completed_c">Input&nbsp;End</td>
									<td class="btn1_right" id="btn_input_completed_r"></td>
								</tr>
							</table>
							</td>
							
							<td id="div_bkg">
							<table width="100%" border="0" cellpadding="0" cellspacing="0"
								class="button">
								<tr>
									<td class="btn1_left" id="btn_bkg_l"></td>
									<td class="btn1" name="btn_bkg" id="btn_bkg_c">Go to Rate</td>
									<td class="btn1_right" id="btn_bkg_r"></td>
								</tr>
							</table>
							</td>
							<td id="div_rating_completed">
							<table width="100%" border="0" cellpadding="0" cellspacing="0"
								class="button">
								<tr>
									<td class="btn1_left" id="btn_rating_completed_l"></td>
									<td class="btn1" name="btn_rating_completed" id="btn_rating_completed_c">Rate&nbsp;End</td>
									<td class="btn1_right" id="btn_rating_completed_r"></td>
								</tr>
							</table>
							</td>
							<td id="div_qa_completed">
							<table width="100%" border="0" cellpadding="0" cellspacing="0"
								class="button">
								<tr>
									<td class="btn1_left" id="btn_qa_completed_l"></td>
									<td class="btn1" name="btn_qa_completed" id="btn_qa_completed_c">QA&nbsp;End</td>
									<td class="btn1_right" id="btn_qa_completed_r"></td>
								</tr>
							</table>
							</td>
							<td id="div_fax">
							<table width="100%" border="0" cellpadding="0" cellspacing="0"
								class="button">
								<tr>
									<td class="btn1_left" id="btn_fax_l"></td>
									<td class="btn1" name="btn_fax" id="btn_fax_c">Go to Fax</td>
									<td class="btn1_right" id="btn_fax_r"></td>
								</tr>
							</table>
							</td>
							<td id="div_pending">
							<table width="100%" border="0" cellpadding="0" cellspacing="0"
								class="button">
								<tr>
									<td class="btn1_left" id="btn_pending_l"></td>
									<td class="btn1" name="btn_pending" id="btn_pending_c">DC&nbsp;Pending</td>
									<td class="btn1_right" id="btn_pending_r"></td>
								</tr>
							</table>
							</td>
							<td style="display:none" id="div_fopending">
							<table width="100%" border="0" cellpadding="0" cellspacing="0"
								class="button">
								<tr>
									<td class="btn1_left" id="btn_fopending_l"></td>
									<td class="btn1" name="btn_fopending" id="btn_fopending_c">FO&nbsp;Pending</td>
									<td class="btn1_right" id="btn_fopending_r"></td>
								</tr>
							</table>
							</td>
							<td style="display:none" id="div_unpending">
							<table width="100%" border="0" cellpadding="0" cellspacing="0"
								class="button">
								<tr>
									<td class="btn1_left" id="btn_unpending_l"></td>
									<td class="btn1" name="btn_unpending" id="btn_unpending_c">UnPend</td>
									<td class="btn1_right" id="btn_unpending_r"></td>
								</tr>
							</table>
							</td>
							<td id="div_return">
							<table width="100%" border="0" cellpadding="0" cellspacing="0"
								class="button">
								<tr>
									<td class="btn1_left" id="btn_return_l"></td>
									<td class="btn1" name="btn_return" id="btn_return_c">Return</td>
									<td class="btn1_right" id="btn_return_r"></td>
								</tr>
							</table>
							</td>
							<td id="div_return_to_return">
							<table width="100%" border="0" cellpadding="0" cellspacing="0"
								class="button" id="div_return_to_return_bg">
								<tr>
									<td class="btn1_left" id="btn_return_to_return_l"></td>
									<td class="btn1" id="btn_return_to_return_c" name="btn_return_to_return">RTN&nbsp;to&nbsp;RTN</td>
									<td class="btn1_right" id="btn_return_to_return_r"></td>
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
<!--Button (E) -->
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

		<table width="100%" class="button" border="0" cellpadding="0"	cellspacing="0" style="padding-top:5; padding-bottom:10;">
			<tr>
				<td class="btn3_bg">
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>

							<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>

		<!--Button (E) -->

	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
<table width="100%"  id="rdTable"> 
	<tr>
		<td width="100%">
		<script language="javascript">comRdObject('Rd');</script>
		</td>
	</tr>
</table>
<!-- 개발자 작업  끝 -->
</form>
<form name="form2" method="POST">
	<input type="hidden" name="message">
</form>
</body>
</html>
<%@include file="../../../../../../../bizcommon/include/common_alps.jsp"%>