<%
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_BKG_1171.jsp
*@FileTitle : A/N with MRNs (FI)
*Open Issues :
*Change history :
*@LastModifyDate : 2010-09-07
*@LastModifier : 계기훈
*@LastVersion : 1.0
* 2010-09-07 계기훈
* 1.0 Creation
*--------------------------------------------------------
* History
* 2013.05.13 김보배 [CHM-201324814] [ENS FI] Finland 세관 ENS 개발 요청 (IE344, IE347)
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event.EsmBkg1171Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EsmBkg1171Event  event = null;		//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;	//서버에서 발생한 에러
	String strErrMsg = "";				//에러메세지
	int rowCount	 = 0;				//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");

	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmBkg1171Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		//GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>esm_bkg_1171</title>
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
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="f_cmd_detail">
<input type="hidden" name="p_vvd_cd">
<input type="hidden" name="vvd">
<input type="hidden" name="cvy_ref_no">
<input type="hidden" name="form_cstms_port_cd">
<input type="hidden" name="form_cstms_yd_cd">
<input type="hidden" name="cstms_yd_cd">
<input type="hidden" name="form_port_net_no">
<input type="hidden" name="form_cvy_ref_no_hidden">
<input type="hidden" name="form_cvy_ref_no">
<input type="hidden" name="form_ibflag">
<input type="hidden" name="eur_edi_msg_tp_id" value = "ARN">
<input type="hidden" name="form_an_edi_svc_flg">
<input type="hidden" name="cvy_ref_no">
<input type="hidden" name="port_net_no">


<!-- 개발자 작업 -->
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
				<tr>
					<td class="bg">
					<!--  biz_1  (S) -->		
		
						<!-- Finland start -->
						<div id="fiView" style="display:inline">
							<table class="search" border="0" style="width:979;"> 
								<tr class="h23">
									<td width="120">VVD CODE</td>
									<td width="180">
										<input type="text" style="width:80" class="input1" name="form_fi_vvd" dataformat="" maxlength="9" fullfill caption="VVD" >
									</td>
									
									<td width="120">B/L No.</td>
									<td width="150">
										<input type="text" style="width:100" class="input" name="form_bl_no" dataformat="eng" maxlength="13" caption="BL No" style="ime-mode:disabled">
									</td>
									
								   <td width="120">Port net NO.</td>
									<td width="150">
										<input type="text" style="width:80" class="input" name="form_fi_cvy_ref_no" dataformat="etc" maxlength="50" caption="Port net No" >
									</td>
									<td width="100">POD</td>
									<td width="150">
										<input type="text" style="width:60" class="input2" readOnly="true" name="form_fi_cstms_yd_cd" value="FIKTK" dataformat="engup" maxlength="5">
									</td>	
											
									<td width="20"><input type="checkbox" name="chk_all" Style="border-style:none"></td>	
					                <td width="250">All BKGs </td>					
								</tr> 
							</table>
						</div>
						<!-- Finland end -->
						
						<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
						<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
								<td width="120">Vessel Name</td>
								<td width="170" >
									<input type="text" style="width:160" class="input2" readOnly="true" name="form_vsl_eng_nm" maxlength="50">
								</td>
								<td width="120">Lloyd No.(IMO)</td>
								<td width="100">
									<input type="text" style="width:80" class="input2" readOnly="true" name="form_lloyd_no" dataformat="eng" maxlength="20">
								</td>
								<td width="120">Vessel Flag</td>
								<td width="">
									<input type="text" style="width:150" class="input2" readOnly="true" name="form_piclb_desc" dataformat="eng" maxlength="100">
								</td>
								<td width="80">Operator</td>
								<td width="" >
									<input type="text" style="width:40" class="input2" readOnly="true" name="form_crr_cd" dataformat="eng" maxlength="10">
								</td>									
							</tr> 

							<!-- ENS end -->
			
							<!-- Finland start -->
							<tr class="h23" id="fiEtaView">
								<td width="">ETA</td>
								<td width="">
									<input type="text" style="width:120" class="input2" readOnly="true" name="form_eta_dt" caption="Estimated Time of Arrival">
								</td>
								<td width="">ETD</td>
								<td width="" colspan=3>
									<input type="text" style="width:120" class="input2" readOnly="true" name="form_etd_dt" caption="Estimated Departure Date">
								</td>
							</tr>
							<!-- Finland end -->
											
							<tr class="h23">	
								<td width="">First Office</td>
								<td>
									<input type="text" style="width:80" class="input2" readOnly="true" name="form_n1st_port_ofc_cd" dataformat="eng" maxlength="10" caption="First Port Office Code">
								</td>
								<td width="">Calling Terminal</td>
								<td colspan=3>
									<input type="text" style="width:80" class="input2" readOnly="true" name="form_tml_cd" dataformat="engup" maxlength="15" caption="Terminal Code">
									<input type="text" style="width:240" class="input2" readOnly="true" name="form_tml_nm" dataformat="engup" maxlength="50" caption="Terminal Name">
								</td>
							</tr> 
							<tr class="h23">
								<td width="">Last Calling Port</td>
								<td width="" >
									<input type="text" style="width:80" class="input2" name="form_lst_clpt_cd" dataformat="engup" maxlength="5" readOnly="true">
								</td>
								<td width="">Next Calling Port</td>
								<td width="">
									<input type="text" style="width:80" class="input2" name="form_nxt_clpt_cd" dataformat="engup" maxlength="5" readOnly="true">
								</td>
							</tr> 
							<tr class="h23">
								<td width="">Cert. Reg No.</td>
								<td width="" >
									<input type="text" style="width:80" class="input2" name="form_rgst_no" dataformat="eng" maxlength="15">
								</td>
								<td width="">Cert. Reg Date</td>
								<td width="">
									<input type="text" style="width:100" class="input2" name="form_rgst_dt" dataformat="ymd" maxlength="10">
								</td>
								<td width="">Cert. Reg Location</td>
								<td width="">
									<input type="text" style="width:80" class="input2" name="form_rgst_port_cd" dataformat="engup" maxlength="5">
								</td>
								
								<td width="">Ack. Status</td>
						        <td width="">
							    <select style="width: 147;" name="p_ack_status">
								 <option value="" selected>All</option>
								 <option value="A">Accepted</option>
								 <option value="R">Rejected</option>
								 <option value="NR">Not Received</option>
								 <option value="NA">N/A</option>
								 <option value="CA">Conditionally Accepted</option>
								 <option value="H">Customs Hold</option>
								 <option value="L">Customs Release</option>
								 <option value="D">Customs Release rejection</option>
							    </select>
						       </td>
									
							</tr> 
							<tr class="h23">	
								<td width="">Gross Ton</td>
								<td>
									<input type="text" style="width:80" class="input2" name="form_grs_rgst_tong_wgt" dataformat="num" maxlength="15">
								</td>
								<td width="">Net Ton</td>
								<td colspan=5>
									<input type="text" style="width:80" class="input2" name="form_net_rgst_tong_wgt" dataformat="num" maxlength="15">
								</td>
							</tr> 
						</table>
<!--  biz_1   (E) -->
					</td>
				</tr>
			</table>	
<!-- 1 (E) -->

<!-- 2 (S) -->		
			<table class="height_8"><tr><td></td></tr></table>	
		
<!-- 2 (E) -->		
<!--biz page (E)-->
<!--biz page 2 (S)-->

<table class="search"> 
       	<tr><td class="bg">	
			<table width="100%" id="mainTable"  style="display:none">
				<tr>
	
					<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script></td>
				</tr>
			</table>
			
			<table width="100%" id="mainTable" >
				<tr>
	
					<td width="100%"><script language="javascript">ComSheetObject('sheet2');</script></td>
				</tr>
			</table>
				
			<table width="100%" class="button"> 
	       	<tr>
	       		<td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
				    <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_History">Transmit & Receive History</td>
					<td class="btn2_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_viewMsg">View Message</td>
					<td class="btn2_right"></td>
					</tr>
				</table></td>				
					</tr></table>
			</td></tr>
			</table>
<!--biz page 2 (E)-->
		</td>
	</tr>
</table>
<!--Button (S) -->
<table width="100%" class="button" border="0" cellpadding="10" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
	<tr>
		<td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_new">New</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td class="btn1_line"></td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_downExcel">Down  Excel</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_save">Save</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_transmit">Transmit</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<table class="height_8"><tr><td></td></tr></table>	
		

			<table class="search" id="mainTable"style="display:none"> 
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
		</td>
	</tr>
</table>
<!--Button (E) -->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>