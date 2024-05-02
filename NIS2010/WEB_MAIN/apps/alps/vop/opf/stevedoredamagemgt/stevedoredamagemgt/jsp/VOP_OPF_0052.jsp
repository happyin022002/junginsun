<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_opf_0052.jsp
*@FileTitle : Damage Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.18
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.05.18 김종옥
* 1.0 Creation
* 2011.04.01 공창식 [CHM-201109535-01] SDMS Damage Creation 변경 요청사항
* 2011.10.21 김민아 [CHM-201113609-01] SDMS 신속 처리를 위한 Auto mailing 기능 추가 - 담당자 선택 기능 추가 및 Auto mailing 기능 추가
* 2011.11.21 김민아 [CHM-201114254-01] [VOP-OPF/SDMS] Repaur VVD 및 Port 설정 기능 변경
* 2012.02.03 김민아 [CHM-201215702-01] [VOP-OPF] SDMS No. 정의 및 칼럼 정리 : SDMS No. 보완 및 Report No. 제거
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.event.VopOpf0052Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopOpf0052Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String strUsr_eml		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.StevedoreDamageMgt.StevedoreDamageMgt");
	
	String vvdPortComboList ="";
	String categoryComboList ="";
	
	String mailContent = "[Concerned Office]"
	                   + "<br> -MOC:pusmoc@hanjin.com"
	                   + "<br> -PLF:chartering@hanjin.com"
	                   + "<br> -LIL:flyminie@hanjin.com"
	                   + "<br> -MFS:hsjin@hanjin.com"
	                   + "<p> ";
	                   /**+ "[PIC of Claim Handling Office]"
	                   + "<br> -Juan Orti:jorti@vlc.isamar.es"
	                   + "<br> -A. SANCHEZ:sanchez@hanjinspain.com"
	                   + "<br> -Olga Garcia:ogarcia@vlc.isamar.es"
	                   + "<br> -Toni MARTINEZ:tmarinez@vlc.isamar.es";**/
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		strUsr_eml = account.getUsr_eml();
	   
		event = (VopOpf0052Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		//vvdPortComboList = eventResponse.getETCData("vvdPortComboList");
		//categoryComboList = eventResponse.getETCData("categoryComboList");
		
	}catch(Exception e) {
		log.error(e.getMessage(),e);
	}
%>
<html>
<head>
<title>Damage Creation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		
		loadPage('<%=strUsr_id%>','<%=strOfc_cd%>');
	}
</script>
</head>

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->

<input type="hidden" name="com_rdSubSysCd" value="OPF">
<input type="hidden" name="com_from" value="<%=strUsr_eml%>">
<input type="hidden" name="com_fromName" value="">
<input type="hidden" name="com_recipient" value="">
<input type="hidden" name="com_carbonCopy" value="<%=strUsr_eml%>">
<input type="hidden" name="com_blindCarbonCopy">
<input type="hidden" name="com_subject" value="Re:SDMS Application">
<input type="hidden" name="com_fileKey">
<input type="hidden" name="com_content">
<input type="hidden" name="default_content" value="<%=mailContent%>">
<input type="hidden" name="com_templateMrd" value="VOP_OPF_1153.mrd">
<input type="hidden" name="com_templateMrdArguments">
<input type="hidden" name="com_templateMrdDescription" value="UI_OPF_1153.mrd 파일이 첨부되었습니다.">
<input type="hidden" name="vsl_oshp_cntr_blk_tp_cd" value="">
<input type="hidden" name="stv_dmg_no" value="">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->
		
		<!--biz page (S)-->
		<!-- 1 (S) -->
		<table class="search" id="mainTable">
       		<tr><td class="bg">
       		
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="50">VVD CD</td>
					<td width="170"><input type="text" style="width:40;ime-mode:disabled;text-align:center;" maxlength="4" fullfill class="input1" name="vsl_cd" caption="VVD CD" required>&nbsp;<input type="text" style="width:40;ime-mode:disabled;text-align:center;" maxlength="4" fullfill class="input1" name="skd_voy_no" required>&nbsp;<input type="text" style="width:25;ime-mode:disabled;text-align:center;" class="input1" maxlength="1" fullfill name="skd_dir_cd" required>&nbsp;<img src="img/btns_search.gif" name="vsl_cd_pop" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"><input type="text" style="width:0;" name="noname"></td>
					<td width="33">Port</td>
					<!-- 
					<td width="70"><input type="text" style="width:50;ime-mode:disabled;" maxlength="5" fullfill class="input1" name="vps_port_cd" caption="VVD CD" required>
					 -->
					<td width="90">
					<div id="comboVpsPortCd" style="display:none;"><script language="javascript">ComComboObject('combo_vps_port_cd', 2, 70, 1,1,0);</script></div>
						<div id="inputVpsPortCd" style="display:inline;"><input type="text" style="width:70;ime-mode:disabled;text-align:center;" maxlength="5" fullfill class="input1" name="input_vps_port_cd" caption="VVD CD" required></div>
					</td>
					<td width="91">Damage Date</td>
					<!-- 
					<td width="135"><input type="text" style="width:75;" class="input1" maxlength="8" dataformat="ymd" name="stv_dmg_evnt_dt" caption="Damage Date" required>&nbsp;<img src="img/btns_calendar.gif" name="btn_stv_dmg_evnt_dt" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
					 -->
					<td style="padding-left:2;"><script language="javascript">ComComboObject('stv_dmg_evnt_dt',1,89,1,1,0);</script></td>
					<td width="33">Lane</td>
					<td width="80"><input type="text" style="width:50;text-align:center;" class="input2" name="slan_cd" readonly></td>
					<td width="105">Vessel Category</td>
					<!-- <td style="padding-left:2;"><script language="javascript">ComComboObject('vsl_oshp_cntr_blk_tp_cd',1,150,1,1,1);</script></td>
					-->
					<td width="150"><input type="text" style="width:150;" class="input2" name="vsl_oshp_cntr_blk_tp_nm" readonly></td>
				</tr>
				<tr class="h23">
					<td>SDMS No.</td>
					<td >
						 	<input type="text" name="stv_dmg_no_prefix" maxlength="4" fullfill style="width:40;ime-mode:disabled;text-align:center;" class="input">
						 	<input type="text" style="width:90;ime-mode:disabled;" maxlength="7" class="input" name="stv_dmg_no_suffix">
					</td>				
					<td colspan="6"></td>
					<td >Damage Category</td>
					<td style="padding-left:2;"> <script language="javascript">ComComboObject('stv_dmg_prt_cate_cd',1,150,1,1,1);</script></td>

				</tr>
				</table>
				<!--  biz_1   (E) -->
			
		</td></tr></table>
		<!-- 1 (E) -->
		
		<table class="height_8"><tr><td></td></tr></table>	

		<!-- 2 (S) -->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;">
				<tr class="h23" style="display:none">
					<td width="" colspan="4">Seq.&nbsp;&nbsp;<input type="text" name="seq" style="width:25;" class="input2" readonly>&nbsp;&nbsp;of&nbsp;&nbsp;<input type="text" name="seq_total" style="width:25;" class="input2" readonly></td>
				</tr> 
				<tr class="h23">
					<td width="175">Claim Handling Office</td>
					<td width="401"><input type="text" style="width:60;ime-mode:disabled;text-align:center;" maxlength="6" class="input2" name="clm_hndl_ofc_cd" caption="Claim Handling Office" required>&nbsp;<!--<img src="img/btns_search.gif" name="clm_hndl_ofc_cd_pop" width="19" height="20" border="0" align="absmiddle" class="cursor">--></td>
					<td width="136">PIC</td>
					<!--<td><input type="text" style="width:240;ime-mode:disabled;text-align:center;" class="input2" name="clm_hndl_usr_id" caption="Claim Handling User" required>&nbsp;<img src="img/btns_search.gif" name="clm_hndl_usr_id_pop" width="19" height="20" border="0" align="absmiddle" class="cursor"></td>-->
					 
					<td width="">
					<table width="100%" border="0">
					<tr>
						<td width="265" style="padding-left:2;padding-top:2;">
						<script language="javascript">ComSheetObject('sheet0');</script>
						</td>
					</tr>
					</table>
					</td>
				</tr> 
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">

					<td width="175">Part</td>
					<td width="401" style="padding-left:2;"><script language="javascript">ComComboObject('stv_dmg_prt_cd',2,240,1,1,1);</script></td>
					<td width="136">Damage</td>
					<td colspan="3" align="left"><script language="javascript">ComComboObject('stv_dmg_tp_cd',2,265,1,0,1);</script></td>
				</tr> 
				<tr class="h23">
					<td>Location / Size / Qty</td>
					<td colspan="5" align="right"><input type="text" style="width:100%;ime-mode:disabled;" class="input" name="stv_dmg_loc_desc" maxlength="500"></td>
				</tr> 
				<tr class="h23">
					<td>Supporting</td>
					<td colspan="5" style="padding-left:2;">
					
							<!-- supporting (S) -->
				    		<table border="0" cellpadding="0" cellspacing="0">
							<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
									<td class="btn2" name="btn_SDR">SDR</td>
									<td class="btn2_right"></td>
									</tr>
									</table></td>
								<td width="160" class="stm">
									<input type="text" name="stv_dmg_rpt_atch_flg" style="width:50; text-align:center;" class="input" value="0" >&nbsp;(Files)</td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
									<td class="btn2" name="btn_Picture">Picture</td>
									<td class="btn2_right"></td>
									</tr>
									</table></td>
								<td width="160" class="stm">
									<input type="text" name="stv_dmg_pict_atch_flg" style="width:50; text-align:center;" class="input" value="0" readonly>&nbsp;(Files)</td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
									<td class="btn2" name="btn_Document">Document</td>
									<td class="btn2_right"></td>
									</tr>
									</table></td>
								<td width="140" class="stm">
									<input type="text" name="stv_dmg_doc_atch_flg" style="width:50; text-align:center;" class="input" value="0" readonly>&nbsp;(Files)</td>
								</tr>
							</table>
							<!-- supporting (S) -->
					
					</td>
				</tr> 
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr><td colspan="8" height="3"></td></tr>
				<tr class="h23">
					<td width="175">Related Damage</td>
					<td width="380">
					
						<table border="0" style="width:332;" class="search_sm2"> 
							<tr class="h23">
								<td width="" class="stm" style="font-size:12;">
									<input type="checkbox" class="trans" name="cntr_dmg_flg" value="Y">&nbsp;Damage on Container&nbsp;&nbsp;
									<input type="checkbox" class="trans" name="cgo_dmg_flg" value="Y">&nbsp;Damage on Cargo</td></tr>
						</table> 
						
					</td>
					<td width="61">CNTR No.</td>
					<td><input type="text" style="width:135;ime-mode:disabled;" class="input" maxlength="14" name="cntr_no"></td>
				</tr> 
				<tr><td colspan="8" height="3"></td></tr>
				</table> 
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="175">Time Loss (Hours)</td>
					<td width="115"><input type="text" style="width:50;" class="input2" name="time_loss_hours" readonly></td>
					<td width="80">From (GMT)</td>
					<td width="184"><input type="text" style="width:135;" class="input" name="fm_tm_lss_dt" caption="From Loss Hour" maxlength="12" dataformat="ymdhm" fullfill></td>
					<td width="62">To (GMT)</td>
					<td><input type="text" style="width:135;" class="input" name="to_tm_lss_dt" caption="To Loss Hour" maxlength="12" dataformat="ymdhm" fullfill></td>
				</tr> 
				</table>
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="174">Remark(s)</td>
					<td colspan="5"><textarea style="width:100%; height:45;ime-mode:disabled;" name="stv_dmg_rmk"></textarea></td>
				</tr> 
				</table>
				
				<table class="search" border="0" style="width:979;"> 
				<tr><td colspan="8" class="line_bluedot"></td></tr>
				<tr class="h23">
					<td width="175">Requirement</td>
					<td width="340">
					
						<table border="0" style="width:300;" class="search_sm2"> 
							<tr class="h23">
								<td width="" class="stm" style="font-size:12;">
									<input type="radio" class="trans" name="stv_dmg_req_cate_cd" value="R" checked>&nbsp;Repair&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="radio" class="trans" name="stv_dmg_req_cate_cd" value="S">&nbsp;Supply&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="radio" class="trans" name="stv_dmg_req_cate_cd" value="Q">&nbsp;Quotation</td></tr>
						</table>
						
					</td>
					<td width="75">Voyage No.</td>
					<td width="112"><input type="text" style="width:53;ime-mode:disabled;" maxlength="5" fullfill class="input" name="req_skd_voy_dir">&nbsp;<img src="img/btns_search.gif" name="req_skd_voy_dir_pop" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"><input type="text" name="noname" style="width:0;"></td>
					<td width="35">Port</td>
					<td width="112">
						<div id="comboReqPortCd" style="display:none;"><script language="javascript">ComComboObject('combo_req_port_cd', 3, 70, 1,1,0);</script></div>
						<div id="inputReqPortCd" style="display:inline;"><input type="text" style="width:70;ime-mode:disabled;text-align:center;" maxlength="5" fullfill class="input" name="req_port_cd"></div>
					</td>
					<td width="30">ETA</td>
					<td align="right"><input type="text" style="width:75;" maxlength="8" fullfill class="input" dataformat="ymd" name="req_eta_dt">&nbsp;<img src="img/btns_calendar.gif" name="btn_req_eta_dt" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				</tr> 
				<tr class="h23">
					<td colspan="2"></td>
					<td>Reason</td>
					<td colspan="5" style="padding-left:2;">
						<script language="javascript">ComComboObject('stv_dmg_qttn_rsn_desc',2,98,1,1,0);</script>&nbsp;<input type="text" style="width:278;" class="input2" maxlength="500" name="req_reason_desc" readOnly>
					</td>
				</tr> 
				<tr><td colspan="8" class="line_bluedot"></td></tr>
				<tr class="h23">
					<td>Responsible Party</td>
					<!-- <td><table border="0" style="width:300;" class="search_sm2"> 
							<tr class="h23">
								<td width="" class="stm">
									<input type="radio" class="trans" name="stv_dmg_respb_pty_kwn_flg" value="Y" checked>&nbsp;Known&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="radio" class="trans" name="stv_dmg_respb_pty_kwn_flg" value="N">&nbsp;Unknown</td></tr>
						</table>						
					</td>
					-->
					<td style="padding-left:2;"><script language="javascript">ComComboObject('stv_dmg_respb_pty_kwn_cd',1,300,1,1,1);</script></td>
					<td>Details</td>
					<td colspan="5" align="right"><input type="text" style="width:100%;ime-mode:disabled;" maxlength="500" class="input" name="stv_dmg_respb_desc_dtl"></td>
				</tr> 
				<tr class="h23">
					<td colspan="2"></td>
					<td>Reason</td>
					<td colspan="5" style="padding-left:2;">
						<script language="javascript">ComComboObject('stv_dmg_respb_desc',2,98,1,1,0);</script>&nbsp;<input type="text" style="width:278;" class="input2" maxlength="500" name="res_reason_desc" readOnly>
					</td>
				</tr> 
				<tr><td colspan="8" class="line_bluedot"></td></tr>
				</table>				
				
				<!--  Button_Sub (S) -->
				<table width="100%" class="button"> 
      			<tr><td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0"><tr>
					<td align="right">
						<input type="text" style="width:50;font-weight:bold;text-align:center;" class="input2" maxlength="1" name="dmg_auth_sts_cd" value="X" readonly>
						<input type="text" style="width:70;font-weight:bold;" class="input2" maxlength="20" name="auth_usr_id" readonly>
						<input type="text" style="width:85;font-weight:bold;" class="input2" name="auth_dt" readonly></td>
					<td width="100" align="center">
			    		<table width="92" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_Approval" id="btnApproval">Approval</td>
							<td class="btn2_right"></td>
						</tr>
						</table>
					</td>
					</tr></table>
				</td></tr>
				</table>
	    		<!-- Button_Sub (E) -->
			
		</td></tr>
		</table>
		<!-- 2 (E) -->

			<!--Button (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"> 
	       	<tr><td class="btn1_bg">
			    <table border="0" cellpadding="0" cellspacing="0">
			    <tr>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_New">New</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Delete">Delete</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>					
					<td class="btn1_line"></td>
					<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Save">Save</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Mail">Mail</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
				</tr>
				</table>
			</td></tr>
			</table>
	   		<!--Button (E) -->
	   		
	   		<div style="display:none;">
	   		<!-- Grid  (S) -->
			<table width="100%"  id="mainTable">
			<tr>
				<td width="100%">
					<script language="javascript">ComSheetObject('sheet1');</script>
					<script language="javascript">ComSheetObject('sheet2');</script>
					<script language="javascript">ComSheetObject('sheet3');</script>
					<script language="javascript">ComSheetObject('sheet4');</script>
					<script language="javascript">ComSheetObject('sheet5');</script>
					<script language="javascript">ComSheetObject('sheet6');</script>
					<script language="javascript">ComUploadObject('upload1', '<%=session.getId()%>', 400,300);</script>
				</td>
			</tr>
			</table>
			<!-- Grid (E) -->
			</div>
	
	</td></tr>
		</table>
		
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>