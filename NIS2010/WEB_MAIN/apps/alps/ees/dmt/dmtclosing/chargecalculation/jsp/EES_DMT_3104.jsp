<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_3104.jsp
*@FileTitle : Inactivation Reason Entry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.16
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.08.16 황효근
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
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.event.EesDmt3104Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt3104Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String sysAreaGrpId     = "";
	String cntrNo			= "";
	String cntrCycNo        = "";
	String dmdtTrfCd        = "";
	String dmdtChgLocDivCd  = "";
	String chgSeq           = "";
	String chgOfcCd         = "";
	String deltSeq          = "";
	String prntMenuId       = "";
	String chgDeltStsCd     = "";
	
	String saveFlg			= "";
	
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String tabCd            = "";
	Logger log = Logger.getLogger("com.hanjin.apps.DMTClosing.ChargeCalculation");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();


		event = (EesDmt3104Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		sysAreaGrpId     = JSPUtil.getParameter(request, "sys_area_grp_id");
		cntrNo			 = JSPUtil.getParameter(request, "cntr_no");
		cntrCycNo        = JSPUtil.getParameter(request, "cntr_cyc_no");
		dmdtTrfCd        = JSPUtil.getParameter(request, "dmdt_trf_cd");
		dmdtChgLocDivCd  = JSPUtil.getParameter(request, "dmdt_chg_loc_div_cd");
		chgSeq           = JSPUtil.getParameter(request, "chg_seq");
		chgOfcCd         = JSPUtil.getParameter(request, "chg_ofc_cd");
		deltSeq          = JSPUtil.getParameter(request, "delt_seq");	
		prntMenuId       = JSPUtil.getParameter(request, "prnt_mnu_id");
		chgDeltStsCd	 = JSPUtil.getParameter(request, "chg_delt_sts_cd");
		saveFlg			 = JSPUtil.getParameter(request, "save_flg");
		tabCd			 = JSPUtil.getParameter(request, "tab_cd");
		if ( "".equals(tabCd)) tabCd = "P";

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Inactivation Reason Entry</title>
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
<input type="hidden" name="svr_id"              value="<%=sysAreaGrpId%>"/>
<input type="hidden" name="sys_area_grp_id"     value="<%=sysAreaGrpId%>"/>
<input type="hidden" name="cntr_no"             value="<%=cntrNo%>"/>
<input type="hidden" name="cntr_cyc_no"         value="<%=cntrCycNo%>"/>
<input type="hidden" name="dmdt_trf_cd"         value="<%=dmdtTrfCd%>"/>
<input type="hidden" name="dmdt_chg_loc_div_cd" value="<%=dmdtChgLocDivCd%>"/>
<input type="hidden" name="chg_seq2"            value="<%=chgSeq%>"/>
<input type="hidden" name="chg_ofc_cd"          value="<%=chgOfcCd%>"/>
<input type="hidden" name="delt_seq"            value="<%=deltSeq%>"/>
<input type="hidden" name="prnt_mnu_id"         value="<%=prntMenuId%>"/>
<input type="hidden" name="chg_delt_sts_cd"    	value="<%=chgDeltStsCd%>"/>
<input type="hidden" name="save_flg"    		value="<%=saveFlg%>"/>

<input type="hidden" name="chg_delt_path_cd">

<input type="hidden" name="h_detail_1_rsn_field_name">
<input type="hidden" name="h_detail_1_rsn_field_type">
<input type="hidden" name="h_detail_1_rsn_field_size">
<input type="hidden" name="h_detail_1_rsn_field_format">
<input type="hidden" name="h_detail_1_rsn_field_item">
<input type="hidden" name="h_detail_1_rsn_field_cond">
<input type="hidden" name="h_detail_1_rsn_field_popup">
<input type="hidden" name="h_detail_1_rsn_field_value">
<input type="hidden" name="h_detail_2_rsn_field_name">
<input type="hidden" name="h_detail_2_rsn_field_type">
<input type="hidden" name="h_detail_2_rsn_field_size">
<input type="hidden" name="h_detail_2_rsn_field_format">
<input type="hidden" name="h_detail_2_rsn_field_item">
<input type="hidden" name="h_detail_2_rsn_field_cond">
<input type="hidden" name="h_detail_2_rsn_field_popup">
<input type="hidden" name="h_detail_2_rsn_field_value">
<input type="hidden" name="h_detail_3_rsn_field_name">
<input type="hidden" name="h_detail_3_rsn_field_type">
<input type="hidden" name="h_detail_3_rsn_field_size">
<input type="hidden" name="h_detail_3_rsn_field_format">
<input type="hidden" name="h_detail_3_rsn_field_item">
<input type="hidden" name="h_detail_3_rsn_field_cond">
<input type="hidden" name="h_detail_3_rsn_field_popup">
<input type="hidden" name="h_detail_3_rsn_field_value">
<input type="hidden" name="h_detail_4_rsn_field_name">
<input type="hidden" name="h_detail_4_rsn_field_type">
<input type="hidden" name="h_detail_4_rsn_field_size">
<input type="hidden" name="h_detail_4_rsn_field_format">
<input type="hidden" name="h_detail_4_rsn_field_item">
<input type="hidden" name="h_detail_4_rsn_field_cond">
<input type="hidden" name="h_detail_4_rsn_field_popup">
<input type="hidden" name="h_detail_4_rsn_field_value">
<input type="hidden" name="h_detail_5_rsn_field_name">
<input type="hidden" name="h_detail_5_rsn_field_type">
<input type="hidden" name="h_detail_5_rsn_field_size">
<input type="hidden" name="h_detail_5_rsn_field_format">
<input type="hidden" name="h_detail_5_rsn_field_item">
<input type="hidden" name="h_detail_5_rsn_field_cond">
<input type="hidden" name="h_detail_5_rsn_field_popup">
<input type="hidden" name="h_detail_5_rsn_field_value">

<input type="hidden" name="h_detail_6_rsn_field_name">
<input type="hidden" name="h_detail_6_rsn_field_type">
<input type="hidden" name="h_detail_6_rsn_field_size">
<input type="hidden" name="h_detail_6_rsn_field_format">
<input type="hidden" name="h_detail_6_rsn_field_item">
<input type="hidden" name="h_detail_6_rsn_field_cond">
<input type="hidden" name="h_detail_6_rsn_field_popup">
<input type="hidden" name="h_detail_6_rsn_field_value">

<input type="hidden" name="h_detail_7_rsn_field_name">
<input type="hidden" name="h_detail_7_rsn_field_type">
<input type="hidden" name="h_detail_7_rsn_field_size">
<input type="hidden" name="h_detail_7_rsn_field_format">
<input type="hidden" name="h_detail_7_rsn_field_item">
<input type="hidden" name="h_detail_7_rsn_field_cond">
<input type="hidden" name="h_detail_7_rsn_field_popup">
<input type="hidden" name="h_detail_7_rsn_field_value">

<input type="hidden" name="h_detail_8_rsn_field_name">
<input type="hidden" name="h_detail_8_rsn_field_type">
<input type="hidden" name="h_detail_8_rsn_field_size">
<input type="hidden" name="h_detail_8_rsn_field_format">
<input type="hidden" name="h_detail_8_rsn_field_item">
<input type="hidden" name="h_detail_8_rsn_field_cond">
<input type="hidden" name="h_detail_8_rsn_field_popup">
<input type="hidden" name="h_detail_8_rsn_field_value">

<input type="hidden" name="h_detail_9_rsn_field_name">
<input type="hidden" name="h_detail_9_rsn_field_type">
<input type="hidden" name="h_detail_9_rsn_field_size">
<input type="hidden" name="h_detail_9_rsn_field_format">
<input type="hidden" name="h_detail_9_rsn_field_item">
<input type="hidden" name="h_detail_9_rsn_field_cond">
<input type="hidden" name="h_detail_9_rsn_field_popup">
<input type="hidden" name="h_detail_9_rsn_field_value">

<input type="hidden" name="h_detail_rsn_mandatory_rows">
<!-- 개발자 작업	-->

<input type="hidden" name="spec_rsn_cd">
<input type="hidden" name="dmdt_chg_delt_rsn_cd">
<input type="hidden" name="dmdt_chg_delt_spec_rsn_cd">
<!-- 선택한 Specific Reason 에 해당되는 1 ~ 6 단계로 입력받은 삭세 상세사유 -->
<input type="hidden" name="chg_delt_spec_rsn_rmk">

<input type="hidden" name="upd_ofc_cd" value="<%=strOfc_cd%>">
<input type="hidden" name="tab_cd" value="<%=tabCd%>">

<input type="hidden" name="bkg_no">
<input type="hidden" name="io_bnd_cd">
<input type="hidden" name="dmdt_inv_no">
<input type="hidden" name="tpb_no">
<input type="hidden" name="vvd_cd">
<input type="hidden" name="loc_cd">
<input type="hidden" name="curr_cd">
<input type="hidden" name="s_cust_cd">
<input type="hidden" name="s_cust_gubun">

<!--Reason Code : SLIKRG  -->
<input type="hidden" name="temp_bkg_no">
<input type="hidden" name="temp_cntr_no">
<input type="hidden" name="temp_cntr_cyc_no">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Inactivation Request</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
		
		
		<table class="search" border="0" style="width:750;"> 
			<tr class="h23">
				<td width="90">Inactive NBR.</td>
				<td width="150"><input type="text" name="inact_rqst_no" value="" style="width:120;" class="input2" readonly ></td>
				<td width="75">APVL NBR. </td>
				<td width="150"><input type="text" name="inact_apro_no" value="" style="width:120;" class="input2" readonly ></td>
				<td width="50">Status</td>
				<td width=""><input type="text" name="inact_sts_cd" value="" style="width:140;" class="input2" readonly ></td>
				
			</tr>
		</table>
 
		<table class="height_10"><tr><td></td></tr></table>
		<!--  
		<table class="search" border="0">
			<tr><td class="title_h"></td>
					<td class="title_s">Reason for Inactivation request</td></tr>
		</table>
		-->
		
		<table class="search" style="width:750;"> 
   		<tr><td class="bg">
			<!-- : ( Grid ) (S) -->
			<table width="100%"  id="mainTable"> 
			<tr><td width="100%"><script language="javascript">ComSheetObject('sheet1');</script></td></tr>
			</table>
		</td></tr>
		</table>
		
		<table class="height_10"><tr><td></td></tr></table>
				
		<table class="search" style="width:750;"> 
   		<tr><td class="bg">
			<!-- : ( Grid ) (S) -->
			<table width="100%"  id="mainTable"> 
			<tr><td width="100%"><script language="javascript">ComSheetObject('sheet2');</script></td></tr>
			</table>

	    	<% if ("R".equals(saveFlg) || "".equals(saveFlg) || "RA".equals(saveFlg)) { %>	    
			<table width="730" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr><!-- td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_row_add">Row Add</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td-->
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_row_delete">Row Delete</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>							
					</tr></table>
			</td></tr>
			</table>
			<% } %>
		</td></tr>
		</table>
				
		<table class="height_10"><tr><td></td></tr></table>
		
		<table class="search" border="0">
			<tr><td class="title_h"></td>
					<td class="title_s">Attached File (5MB limit per file)</td></tr>
		</table>
				
		<table class="search" style="width:750;"> 
   		<tr><td class="bg">
			<!-- : ( Grid ) (S) -->
			<table width="100%"  id="mainTable"> 
			<tr><td width="100%"><script language="javascript">ComSheetObject('sheet3');</script></td></tr>
			</table>
			
	    	<% if ("R".equals(saveFlg) || "".equals(saveFlg) || "RA".equals(saveFlg)) { %>	    	
			<table width="730" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" id="btn_upload" name="btn_upload">File Upload</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" id="btn_file_delete" name="btn_file_delete">File Delete</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>							
					</tr></table>
			</td></tr>
			</table>
			<% } %>
			
		</td></tr>
		</table>		
		
		<table class="height_10"><tr><td></td></tr></table>
		<!--	
		<table width="100%" class="grid"> 
		<tr>
			<td width="105" class="tr2_head">Remark(s)</td>
			<td width=""><textarea name="corr_rmk" 	cols="" rows="4"  style="width:495"></textarea></td>
		</tr>
		</table> 
		<!-- : ( Grid ) (E) -->	
		
		
		<table class="search" border="0" style="width:750;"> 
			<tr class="h23">
				<td width="550" valign="top">
					<table class="search" border="0">
						<tr><td class="title_h"></td>
								<td class="title_s">Comment History</td></tr>
					</table>
					<!-- Grid  (S) -->
					<table width="100%" id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet4');</script>
							</td>
						</tr>
					</table>
					<!-- Grid  (E) -->
				</td>
				
			    <td width="19"></td>
				<td width="320" valign="top">
					<table class="search">
						<tr class="h23"><td class="title_s" width="205"><input type="checkbox" name="chkComment" class="trans" onClick="checkComment()">Comment </td>
						</tr> 
					</table>
					<table width="100%" class="grid"> 
					<tr>
						<td width=""><textarea name="corr_rmk" 	dataformat="engup3" style="width:310;height:52;" class="input1"></textarea></td>
					</tr>
					</table>				
				</td>
				</tr>
			</table>
			
		<!-- : ( Button : Grid ) (S)
		<table width="100%" class="search"> 
      	<tr class="h23">
			<td width="40">Office<td>
			<td width="80"><input type="text" name="upd_ofc_cd" style="width:52;" class="input2" readOnly value="<%=strOfc_cd%>"><td>
			<td width="33">Name<td>
			<td width=""><input type="text" name="usr_nm" style="width:100%;" class="input2" readOnly value="<%=strUsr_nm%>"><td>
		</tr>
		</table>
		 Button_Sub (S) -->
    	<!-- Button_Sub (E) -->
	    <!-- : ( Button : Grid ) (E) -->	
		
	</td></tr>
	</table>
<!-- : ( Search Options ) (E) -->
</td></tr>
</table> 		

	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="0" class="popup">
	
	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
      	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
		    	<% if ("R".equals(saveFlg) || "".equals(saveFlg) || "RA".equals(saveFlg)) { %>	    
				<td width="100">
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr>
						<td class="btn1_left"></td>
						<td class="btn1" id="btn_request" name="btn_request">Request</td>
						<td class="btn1_right"></td>
					</tr>
					</table>
				</td>    
				<% } %>
				<% if ("R".equals(saveFlg) || "RA".equals(saveFlg)) { %>
				<td width="100">
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr>
						<td class="btn1_left"></td>
						<td class="btn1" id="btn_ReqCancel" name="btn_ReqCancel">REQ Cancel</td>
						<td class="btn1_right"></td>
					</tr>
					</table>
				</td>
				<td class="btn1_line"></td>
				<% } %>
				<% if ("A".equals(saveFlg)|| "RA".equals(saveFlg)) { %>	    
				<td width="100">
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr>
						<td class="btn1_left"></td>
						<td class="btn1" id="btn_approval" name="btn_approval">Approval</td>
						<td class="btn1_right"></td>
					</tr>
					</table>
				</td>    
				<td width="100">
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr>
						<td class="btn1_left"></td>
						<td class="btn1" id="btn_reject" name="btn_reject">Reject</td>
						<td class="btn1_right"></td>
					</tr>
					</table>
				</td>
				<td class="btn1_line"></td>
				<% } %>
				<td width="100">
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr>
						<td class="btn1_left"></td>
						<td class="btn1" id="btn_Close" name="btn_close">Close</td>
						<td class="btn1_right"></td>
					</tr>
					</table>
				</td>
			</tr>
			</table>
   	<!--Button (E) -->

		</td></tr>
	</table>
	<!-- : ( Button : pop ) (E) -->


	<!-- Grid  (S) -->
	<table width="100%"  id="mainTable2" style=display:none;> 
		<tr>
			<td width="100%">
				<script language="javascript">ComSheetObject('sheet5');</script>
			</td>
		</tr>
	</table>
	<!-- Grid  (E) -->	

</td></tr>
</table>

<script language="javascript">ComUploadObject("upload1", '<%=session.getId()%>');</script>
<!-- 개발자 작업  끝 -->
</form>
<iframe name="hiddenFrame" style="visibility:hiddden" height="0" width="0"></iframe>
</body>
</html>