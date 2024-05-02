<%/*=========================================================
 *Copyright(c) 2010 CyberLogitec
 *@FileName : esm_bkg_1107.js
 *@FileTitle : Europe Advanced Manifest : B/L Inquiry - customer Information
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010-09-29
 *@LastModifier : 계기훈
 *@LastVersion : 1.0
 * 2010-09-29 계기훈
 * 1.0 Creation
 *---------------------------------------------------------
 * 2010.11.30 김영철 [] R4J - 61줄 catch 밑에 out.println 없어 문제임.
 * 2011.12.05 박성진 [CHM-201114538-01][BKG_MFT][BKG Main 고객정보 내부테이블 및 ENS BL inquiry] FWD의 상세주소 데이터로직 보완
 * 2012.11.30 김보배 [CHM-201221610] [BKG] [ENS] ENS Download&Transmit 화면상 전송 대상 수정 요청
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%> 
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event.EsmBkg1107Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%	EsmBkg1107Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList    = "";
	String pageRows    = "100";

	String strUsr_id   = "";
	String strUsr_nm   = "";
	String strCnt_cd   = "";
    String strOfc_cd   = "";
	
	String strPgmNo     = "";
	String prtPgmNo	= "";
	String strBlNo      = "";
	String strTransMode = "";      
	String title_type	= "";
	String ata_chk_flg	= "Y";
	Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.Customstransmission");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strCnt_cd = account.getCnt_cd();
        strOfc_cd = account.getOfc_cd();

		event = (EsmBkg1107Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        strBlNo = JSPUtil.getNull(request.getParameter("bl_no"));
        strPgmNo = JSPUtil.getNull(request.getParameter("pgmNo"));
        prtPgmNo = JSPUtil.getNull(request.getParameter("parentPgmNo"));
        codeList = HttpUtil.makeXML(request,response);
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>esm_bkg_1107</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
function setupPage(){
	var errMessage = "<%=strErrMsg%>";
	if (errMessage.length >= 1) {
		//showErrMessage(errMessage);
	} // end if
	loadPage();
}
</script>
</head>
<body onLoad="setupPage();">
<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="cstms_port_cd" >
<input type="hidden" name="code_list" value="<%=codeList%>">
<input type="hidden" name="cust_type">
<input type="hidden" name="mk_desc">
<input type="hidden" name="gds_desc">
<input type="hidden" name="func">
<input type="hidden" name="cn_flg" value="Y">
<input type="hidden" name="eur_flg" value="Y">
<input type="hidden" name="s_ibflag">
<input type="hidden" name="f_ibflag">
<input type="hidden" name="n_ibflag">
<input type="hidden" name="c_ibflag">
<input type="hidden" name="cstms_yd_cd" >
<input type="hidden" name="pol_cd" >
<input type="hidden" name="kts_send_dt" >
<input type="hidden" name="rcv_mvmt_ref_no" >
<input type="hidden" name="strPgmNo"  value="<%=strPgmNo%>">
<input type="hidden" name="prtPgmNo"  value="<%=prtPgmNo%>">
<input type="hidden" name="trsm_blck_flg">
<input type="hidden" name="mrn_flg">
<input type="hidden" name="eu_1st_port_clpt_seq">

<!-- 개발자 작업	-->

<% if ( "ESM_BKG_1107_P".equals(request.getParameter("pgmNo")) ) { %>
	<% if ( "ESM_BKG_1106".equals(request.getParameter("parentPgmNo")) || "ESM_BKG_1108_1".equals(request.getParameter("parentPgmNo")) ) {
		title_type = "ENS B/L Inquiry (Origin)";
		ata_chk_flg = "Y";
	 } else if ( "ESM_BKG_1108_2".equals(request.getParameter("parentPgmNo")) ) {
		title_type = "ENS B/L Inquiry (EU Office)";
		ata_chk_flg = "N";
	 } %>
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="./img/icon_title_dot.gif" align="absmiddle">&nbsp;<%=title_type%></td></tr>
		</table>	
	</td></tr>
</table>
<% } else { %>
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->
	</td></tr>
</table>
<% } %>
<input type="hidden" name="ata_chk_flg" value="<%=ata_chk_flg%>">
		
<!--biz page (S)-->
<table class="search" id="mainTable">
	<tr>
		<td class="bg">
		
			<table class="search" border="0" style="width:880;">
				<tr class="h23">
					<td width="80">B/L No.</td>
					<td width="100">
						<input type="text" name="bl_no" style="width:110; ime-mode: disabled;" class="input1" value="<%=strBlNo%>" dataformat="eng" maxlength="12" <%="".equals(strBlNo) ? "required" : "readonly"%> caption="B/L No.">
					</td>
                    <td width="55" align=right>Type&nbsp;</td>
					<td width="80">
						<select name="type_cd" style="width:80">
			             <option value="I" selected>Import</option>
			             <option value="O">Export</option>
			             </select>					
					</td>
					<td width="70" align=right>Status&nbsp;</td>
					<td width="160">
						<input type="text" name="msg_func_id" style="width:100;" class="input2" readonly>
					    <!-- input type="text" name="msg_func_dt" style="width:150;" class="input2" readonly-->
					</td>
					<td width="45" align=right>MRN&nbsp;</td>
					<td width="">
						<input type="text" name="mvmt_ref_no" style="width:150;" class="input2" readonly>
					</td>
				</tr>
			</table>
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			<table class="search" border="0" style="width:980;">
				<tr class="h23">
					<td width="80">VVD</td>
					<td width="120">
						<script language="javascript">ComComboObject('vvd', 2, 120, 0, 0,0);</script>
					</td>
					<td width="90" align=right>Vessel Name&nbsp;</td>
					<td width="200"><input type="text" name="vsl_eng_nm" style="width:180;" class="input2" readonly></td>
					<td width="110" align=right>IMO(Lloyd) Code&nbsp;</td>
					<td width=""><input type="text" name="lloyd_no" style="width:80;" class="input2" readonly></td>
				</tr>
			</table>
			<table class="search" border="0" style="width:980;">
				<tr class="h23">
					<td width="80">POR</td>
					<td width="70"><input type="text" name="por_cd" style="width:60;" class="input" maxlength="5"></td>
					<td width="55" align=right>POL&nbsp;</td>
					<td width="70"><input type="text" name="bkg_pol_cd" style="width:60;" class="input" maxlength="5"></td>
					<td width="55" align=right>POD&nbsp;</td>
					<td width="70"><input type="text" name="bkg_pod_cd" style="width:60;" class="input" maxlength="5"></td>
					<td width="55" align=right>DEL&nbsp;</td>
					<td width="70"><input type="text" name="del_cd" style="width:60;" class="input" maxlength="5"></td>
					<td width="75" align=right>R/D Term&nbsp;</td>
					<td width="">
						<input type="text" name="rcv_term_cd" style="width:25;" class="input2" readonly> /
					    <input type="text" name="de_term_cd" style="width:25;" class="input2" readonly>
					</td>
				</tr>
			</table>
			<table class="search" border="0" style="width:980;">
				<tr class="h23">
					<td width="80">Package</td>
					<td width="169">
						<input type="text" name="pck_qty" style="width:105; text-align:right;" class="input" dataformat="float" maxlength="15" caption="Package">
						<input type="text" name="pck_tp_cd" style="width:35;" class="input" >
					</td>
					<td width="56" align=right>Weight&nbsp;</td>
					<td width="235">
						<input type="text" name="act_wgt" style="width:100; text-align:right;" class="input" dataformat="float" maxlength="23" caption="Weight">&nbsp;
							<select name="wgt_ut_cd" style="width:80">
				             <option value="KGS" selected>KGS</option>
				             <option value="LBS">LBS</option>
				             </select>
					</td>
					<td width="60" align=right>Measure&nbsp;</td>
					<td width="">
						<input type="text" name="meas_qty" style="width:100; text-align:right;" class="input" dataformat="float" maxlength="15" caption="Measure">&nbsp;
						<select name="meas_ut_cd" style="width:80">
				             <option value="CBM" selected>CBM</option>
				             <option value="CBF">CBF</option>
						</select>
					</td>	
				</tr>
			</table>	
			<table class="search" border="0" style="width:980;">
				<tr class="h23">
					<td width="80">Cargo Desc.</td>
					<td width=""><input type="text" name="cstms_desc" style="width:380;" class="input"></td>	
				</tr>
			</table>
		</td>
	</tr>
</table>
<table width="100%" id="mainTable" style="display:none">
	<tr>
		<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script></td>
	</tr>
</table>
<table class="height_8"><tr><td></td></tr></table>

<!-- Tab (S) -->
<table class="tab" border="0" cellpadding="0" cellspacing="0" width="100%">
	<tr>
		<td width="100%">
			<script language="javascript">ComTabObject('tab1')</script>
		</td>
	</tr>
</table>
<!-- Tab (E) -->
<!-- (TAB) Customer Info(S) -->
<div id="tabLayer" style="display:inline">
<table class="search">
	<tr>
		<td class="bg">
			<table class="search" border="0" style="width:970;">
				<tr class="h23">
					<td width="480">
						<table class="grid2" border="0" style="width:100%;">
							<tr class="h23">
								<td width="110" style="text-align:center; background-color:#F3F2F8;border-top:1px solid #E8EFF9;border-right:1px solid #E8EFF9;border-left:1px solid #E8EFF9;">Shipper</td>
								<td colspan="5" style=" background-color:#F3F2F8;border-top:1px solid #E8EFF9;border-right:1px solid #E8EFF9;">
									<input type="text" style="width:30;" class="input" name="s_cust_cnt_cd" maxlength="2" required fullfill dataformat="engup" caption="Shipper Country Code">&nbsp;
									<input type="text" style="width:60;text-align:right;" class="input" name="s_cust_seq" maxlength="6" dataformat="eng" caption="Shipper Sequence">&nbsp;
									<img class="cursor" name="pop_shipper" src="img/btns_inquiry.gif" width="19" height="20" border="0" align="absmiddle">
								</td>
							</tr>
							<tr class="h23">
								<td class="tr_head2">Name</td>
								<td colspan="3"><textarea rows="2" name="s_cust_nm" maxlength="500" dataformat="etc" caption="Shipper Name" 	style="width:100%;text-indent:0px;overflow-y:scroll;overflow-x:hidden" class="textarea_img2" wrap="physical"></textarea></td>
							</tr>
							<tr class="h23">
								<td class="tr_head2">Address</td>
								<td colspan="5"><textarea rows="3" name="s_cust_addr" maxlength="350" dataformat="etc" caption="Shipper Address" style="width:100%;text-indent:0px;overflow-y:scroll;overflow-x:hidden" class="textarea_img3" wrap="physical"></textarea></td>
							</tr>
							<tr class="h23">
						 		<td class="tr_head2">City</td>
								<td width="200">
									<input type="text" style="width:135;" class="input" name="s_cust_cty_nm" maxlength="500" dataformat="etc" caption="Shipper City">
								</td>
						 		<td class="tr_head2">Country</td>
								<td width="30">
									<input type="text" style="width:25;" class="input" name="s_cstms_decl_cnt_cd" maxlength="2" dataformat="eng" caption="Shipper Country">
								</td>
						 		<td width="70" class="tr_head2">Zip</td>
								<td width="">
									<input type="text" style="width:87;" class="input" name="s_cust_zip_id" maxlength="10" dataformat="etc" caption="Shipper Zip">
								</td>
							</tr>
							<tr class="h23">
								<td class="tr_head2">Street</td>
								<td width="170">
									<input type="text" name="s_eur_cstms_st_nm" dataformat="etc" style="width:150;" maxlength="50" class="input" style="ime-mode:disabled">
								</td>
						 		<td width="70" class="tr_head2">EORI#</td>
								<td width="120" colspan=5>
									<input type="text" name="s_eori_no" dataformat="etc" style="width:80;" maxlength="20" class="input" style="ime-mode:disabled">
									<input type="hidden" name="s_eori_no_ori" dataformat="etc" style="width:80;" maxlength="20" class="input" style="ime-mode:disabled">
								</td>
							</tr>
						</table>
						
						<table class="height_8"><tr><td></td></tr></table>
						<table class="grid2" border="0" style="width:100%;">
							<tr class="h23">
								<td width="110" style="text-align:center; background-color:#F3F2F8;border-top:1px solid #E8EFF9;border-right:1px solid #E8EFF9;border-left:1px solid #E8EFF9;">Consignee</td>
								<td colspan="5" style=" background-color:#F3F2F8;border-top:1px solid #E8EFF9;border-right:1px solid #E8EFF9;">
									<input type="text" style="width:30;" class="input" name="c_cust_cnt_cd" maxlength="2" dataformat="engup" caption="Consignee Country Code">&nbsp;
									<input type="text" style="width:60;text-align:right;" class="input"  name="c_cust_seq" maxlength="6" dataformat="eng" caption="Consignee Sequence">&nbsp;
									<img class="cursor" name="pop_consignee" src="img/btns_inquiry.gif" width="19" height="20" border="0" align="absmiddle">
								</td>
							</tr>
							<tr class="h23">
								<td class="tr_head2">Name</td>
								<td colspan="3"><textarea rows="2" name="c_cust_nm" maxlength="500" dataformat="etc" caption="Consignee Name" 	style="width:100%;text-indent:0px;overflow-y:scroll;overflow-x:hidden" class="textarea_img2" wrap="physical"></textarea></td>
							</tr>
							<tr class="h23">
								<td class="tr_head2">Address</td>
								<td colspan="5"><textarea rows="3" name="c_cust_addr" maxlength="350" dataformat="etc" caption="Consignee Address" style="width:100%;text-indent:0px;overflow-y:scroll;overflow-x:hidden" class="textarea_img3" wrap="physical"></textarea></td>
							</tr>
							<tr class="h23">
						 		<td class="tr_head2">City</td>
								<td width="200">
									<input type="text" style="width:135;" class="input" name="c_cust_cty_nm" maxlength="500" dataformat="etc" caption="Consignee City">
								</td>
						 		<td class="tr_head2">Country</td>
								<td width="30">
									<input type="text" style="width:25;" class="input" name="c_cstms_decl_cnt_cd" maxlength="2" dataformat="eng" caption="Consignee Country">
								</td>
						 		<td width="70" class="tr_head2">Zip</td>
								<td width="">
									<input type="text" style="width:87;" class="input" name="c_cust_zip_id" maxlength="10" dataformat="etc" caption="Consignee Zip">
								</td>
							</tr>
							<tr class="h23">
								<td class="tr_head2">Street</td>
								<td width="170">
									<input type="text" name="c_eur_cstms_st_nm" dataformat="etc" style="width:150;" maxlength="50" class="input" style="ime-mode:disabled">
								</td>
						 		<td width="70" class="tr_head2">EORI#</td>
								<td width="120" colspan=5>
									<input type="text" name="c_eori_no" dataformat="etc" style="width:80;" maxlength="20" class="input" style="ime-mode:disabled">
									<input type="hidden" name="c_eori_no_ori" dataformat="etc" style="width:80;" maxlength="20" class="input" style="ime-mode:disabled">
								</td>
							</tr>
						</table>
						</td> 
						<td width="20"></td>
						<td width="480">
						<table class="grid2" border="0" style="width:100%;">
							<tr class="h23">
								<td width="110" style="text-align:center; background-color:#F3F2F8;border-top:1px solid #E8EFF9;border-right:1px solid #E8EFF9;border-left:1px solid #E8EFF9;">FWRD</td>
								<td colspan="5" style=" background-color:#F3F2F8;border-top:1px solid #E8EFF9;border-right:1px solid #E8EFF9;">
									<input type="text" style="width:30;" class="input" name="f_cust_cnt_cd" maxlength="2" dataformat="engup" caption="Forwarder Country Code">&nbsp;
									<input type="text" style="width:60;text-align:right;" class="input"  name="f_cust_seq" maxlength="6" dataformat="eng" caption="Forwarder Sequence">&nbsp;
									<img class="cursor" name="pop_fwrd" src="img/btns_inquiry.gif" width="19" height="20" border="0" align="absmiddle">
								</td>
							</tr>
							<tr class="h23">
								<td class="tr_head2">Name</td>
								<td colspan="3"><textarea rows="2" name="f_cust_nm" maxlength="500" dataformat="etc" caption="Forwarder Name" 	style="width:100%;text-indent:0px;overflow-y:scroll;overflow-x:hidden" class="textarea_img2" wrap="physical"></textarea></td>
							</tr>
							<tr class="h23">
								<td class="tr_head2">Address</td>
								<td colspan="5"><textarea rows="3" name="f_cust_addr" maxlength="350" dataformat="etc" caption="Forwarder Address" style="width:100%;text-indent:0px;overflow-y:scroll;overflow-x:hidden" class="textarea_img3" wrap="physical"></textarea></td>
							</tr>
							<tr class="h23" style="display:none;">
						 		<td class="tr_head2">City</td>
								<td width="200">
									<input type="text" style="width:135;" class="input" name="f_cust_cty_nm" maxlength="500" dataformat="etc" caption="Forwarder City">
								</td>
						 		<td class="tr_head2">Country</td>
								<td width="30">
									<input type="text" style="width:25;" class="input" name="f_cstms_decl_cnt_cd" maxlength="2" dataformat="eng" caption="Forwarder Country">
								</td>
						 		<td width="70" class="tr_head2">Zip</td>
								<td width="">
									<input type="text" style="width:87;" class="input" name="f_cust_zip_id" maxlength="10" dataformat="etc" caption="Forwarder Zip">
								</td>
							</tr>
							<tr class="h23" style="display:none;">
								<td class="tr_head2">Street</td>
								<td width="170">
									<input type="text" name="f_eur_cstms_st_nm" dataformat="etc" style="width:150;" maxlength="50" class="input" style="ime-mode:disabled">
								</td>
						 		<td width="70" class="tr_head2">EORI#</td>
								<td width="120" colspan=5>
									<input type="text" name="f_eori_no" dataformat="etc" style="width:80;" maxlength="20" class="input" style="ime-mode:disabled">
									<input type="hidden" name="f_eori_no_ori" dataformat="etc" style="width:80;" maxlength="20" class="input" style="ime-mode:disabled">
								</td>
							</tr>
						</table>
						<table class="height_8"><tr><td></td></tr></table>
						<table class="height_8"><tr><td></td></tr></table>
						<table class="height_8"><tr><td></td></tr></table>
						<table class="height_8"><tr><td></td></tr></table>
						<table class="height_8"><tr><td></td></tr></table>
						<table class="height_8"><tr><td></td></tr></table>
						<table class="height_8"><tr><td></td></tr></table>
						<table class="grid2" border="0" style="width:100%;">
							<tr class="h23">
								<td width="110" style="text-align:center; background-color:#F3F2F8;border-top:1px solid #E8EFF9;border-right:1px solid #E8EFF9;border-left:1px solid #E8EFF9;">Notify</td>
								<td colspan="5" style=" background-color:#F3F2F8;border-top:1px solid #E8EFF9;border-right:1px solid #E8EFF9;">
									<input type="text" style="width:30;" class="input" name="n_cust_cnt_cd" maxlength="2" dataformat="engup" caption="Notify Country Code">&nbsp;
									<input type="text" style="width:60;text-align:right;" class="input"  name="n_cust_seq" maxlength="6" dataformat="eng" caption="Notify Sequence">&nbsp;
									<img class="cursor" name="pop_notify" src="img/btns_inquiry.gif" width="19" height="20" border="0" align="absmiddle">
								</td>
							</tr>
							<tr class="h23">
								<td class="tr_head2">Name</td>
								<td colspan="3"><textarea rows="2" name="n_cust_nm" maxlength="500" dataformat="etc" caption="Notify Name" 	style="width:100%;text-indent:0px;overflow-y:scroll;overflow-x:hidden" class="textarea_img2" wrap="physical"></textarea></td>
							</tr>
							<tr class="h23">
								<td class="tr_head2">Address</td>
								<td colspan="5"><textarea rows="3" name="n_cust_addr" maxlength="350" dataformat="etc" caption="Notify Address" style="width:100%;text-indent:0px;overflow-y:scroll;overflow-x:hidden" class="textarea_img3" wrap="physical"></textarea></td>
							</tr>
							<tr class="h23">
						 		<td class="tr_head2">City</td>
								<td width="200">
									<input type="text" style="width:135;" class="input" name="n_cust_cty_nm" maxlength="500" dataformat="etc" caption="Notify City">
								</td>
						 		<td class="tr_head2">Country</td>
								<td width="30">
									<input type="text" style="width:25;" class="input" name="n_cstms_decl_cnt_cd" maxlength="2" dataformat="eng" caption="Notify Country">
								</td>
						 		<td width="70" class="tr_head2">Zip</td>
								<td width="">
									<input type="text" style="width:87;" class="input" name="n_cust_zip_id" maxlength="10" dataformat="etc" caption="Notify Zip">
								</td>
							</tr>
							<tr class="h23">
								<td class="tr_head2">Street</td>
								<td width="170">
									<input type="text" name="n_eur_cstms_st_nm" dataformat="etc" style="width:150;" maxlength="50" class="input" style="ime-mode:disabled">
								</td>
						 		<td width="70" class="tr_head2">EORI#</td>
								<td width="120" colspan=5>
									<input type="text" name="n_eori_no" dataformat="etc" style="width:80;" maxlength="20" class="input" style="ime-mode:disabled">
									<input type="hidden" name="n_eori_no_ori" dataformat="etc" style="width:80;" maxlength="20" class="input" style="ime-mode:disabled">
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
            <!-- Grid  (S) -->
            <table width="100%"  id="mainTable" style="display:none">
                <tr>
                    <td width="100%">
                        <script language="javascript">ComSheetObject('t2sheet1');</script>
                    </td>
                </tr>
            </table>
            <!-- Grid (E) -->
		</td>
	</tr>
</table>
</div>
<!-- (TAB) Customer Info (E) -->
<!-- (TAB) Container Info (S) -->
<div id="tabLayer">
<table class="search">
	<tr>
		<td class="bg">
<!-- Grid  (S) -->
			<table width="100%"  id="mainTable">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('t1sheet1');</script>
					</td>
				</tr>
			</table>
<!-- Grid (E) -->
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
											<td class="btn2" name="btn_RowAdd1">Row&nbsp;Add</td>
											<td class="btn2_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn2_left"></td>
											<td class="btn2" name="btn_RowDel1">Row&nbsp;Delete</td>
											<td class="btn2_right"></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<br>
<!-- Button_Sub (E) -->
<!-- Grid  (S) -->
			<table width="100%"  id="mainTable">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('t4sheet1');</script>
					</td>
				</tr>
			</table>
<!-- Grid (E) -->			
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
											<td class="btn2" name="btn_RowAdd2">Row&nbsp;Add</td>
											<td class="btn2_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn2_left"></td>
											<td class="btn2" name="btn_RowDel2">Row&nbsp;Delete</td>
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
</div>
<!-- (TAB) Container Info (E) -->

<!-- (TAB) Danger Info.(S) -->
<div id="tabLayer" style="display:none">
<table class="search">
   	<tr>
		<td class="bg">
			<!-- Grid  (S) -->
			<table width="100%"  id="mainTable">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('t3sheet1');</script>
					</td>
				</tr>
			</table>
			<!-- Grid (E) -->
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
											<td class="btn2" name="btn_RowAdd3">Row&nbsp;Add</td>
											<td class="btn2_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn2_left"></td>
											<td class="btn2" name="btn_RowDel3">Row&nbsp;Delete</td>
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
</div>
<!-- (TAB) Danger Info. (E) -->

<!-- : ( Button : pop ) (S) -->
<table width="100%" border="0">
	<tr>
		<td align="center">
			<table width="998" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:13;"> 
      			<tr>
					<td class="btn1_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_New">New</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td class="btn1_line"></td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Save">Save</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="b_MrnDelete" style="display:none">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_MrnDelete">MRN Delete</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="b_MrnReactivate" style="display:none">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_MrnReactivate">MRN Reactivate</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td class="btn1_line"></td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Transmit">Transmit Manifest</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<table class="search" id="mainTable" style="display:none"> 
				<tr>
					<td class="bg">	
<!--  biz_1  (S) -->
						<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
								<td width="145">FlatFile</td>
							</tr> 
							<tr class="h23">
								<td>
									<textarea name="flatfile" cols="600" rows="20"  wrap="hard" style="width: 100%; background-color: #FBFBFB; border: 1 solid #AEAEAE;"  style="overflow:hidden; ime-mode:disabled;"></textarea>
								</td>
							</tr> 
						</table>
<!--  biz_1   (E) -->					
					</td>
				</tr>
			</table>			
<!-- : ( Button : pop ) (E) -->
		</td>
	</tr>
</table>
<!-- 본문끝 -->
<table width="100%"  id="mainTable"> 
	<tr>
		<td width="100%">
			<script language="javascript">ComSheetObject('sheet2');</script>
		</td>
    </tr>
</table>  
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>