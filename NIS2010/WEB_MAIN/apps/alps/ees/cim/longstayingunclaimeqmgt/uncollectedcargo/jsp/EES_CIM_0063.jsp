<%
/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EES_CIM_0063.jsp
 *@FileTitle : Uncollected Cargo 
 *Open Issues :
 *Change history : 
 *@LastModifyDate : 2014.06.05
 *@LastModifier : KIMHYUNJOO
 *@LastVersion : 1.0
 * 1.0 Creation
 * -------------------------------------------------------- 
 * History
 * 
 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%> 
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.event.EesCim0063Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.Date" %>

<%
	EesCim0063Event  event 	= null;		// PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;		// 서버에서 발생한 에러
	String strErrMsg 				= "";			// 에러메세지
	int rowCount	 				= 0;			// DB ResultSet 리스트의 건수
	
	String successFlag 				= "";
	String codeList  				= "";
	String pageRows  				= "100";

	// SignOnUserAccount Info
	String strUsr_id				= "";
	String strUsr_nm				= "";
	String ibflag					= "";
	String page_rows				= "";
	String usr_id 					= "";
	String usr_nm					= "";
	String usr_pwd					= "";
	String use_flg					= "";
	String mphn_no					= "";
	String usr_eml					= ""; 
	String cnt_cd					= "";
	String lang_tp_cd				= "";
	String cre_usr_id				= "";
	String upd_usr_id				= "";
	String upd_dt					= "";
	//=access_system " + account.getAccess_system() );      
	String dflt_eml					= "";
	String cre_dt					= "";
	String ofc_cd					= "";
	String ofc_eng_nm				= "";
	String ofc_krn_nm				= "";
	String usr_auth_tp_cd			= "";
	String usr_locl_nm				= "";
	String mn_scrn_opt_id			= "";
	String rhq_ofc_cd				= "";
	String xtn_phn_no				= "";
	String fax_no					= "";
	String srep_cd					= "";
	String ofc_org_cd				= "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.AccountReceivableInvoiceMgt.ARInvoiceCorrection");
	
	String toDay = DateTime.getFormatDate(new Date(),"yyyy-MM-dd");
	try {
	   	SignOnUserAccount account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id 			= account.getUsr_id();
		strUsr_nm 			= account.getUsr_nm();
		ibflag       		= account.getIbflag();      
		page_rows    		= account.getPage_rows();      
		usr_id       		= account.getUsr_id();      
		usr_nm       		= account.getUsr_nm();      
		usr_pwd      		= account.getUsr_pwd();      
		use_flg      		= account.getUse_flg();      
		mphn_no      		= account.getMphn_no();      
		usr_eml      		= account.getUsr_eml();      
		cnt_cd       		= account.getCnt_cd();      
		lang_tp_cd   		= account.getLang_tp_cd();      
		cre_usr_id   		= account.getCre_usr_id();      
		upd_usr_id   		= account.getUpd_usr_id();      
		upd_dt       		= account.getUpd_dt();      
		//access_system= account.getAccess_system();      
		dflt_eml     		= account.getDflt_eml();      
		usr_eml      		= account.getUsr_eml();      
		cre_dt       		= account.getCre_dt();      
		ofc_cd      		= account.getOfc_cd();      
		ofc_eng_nm   		= account.getOfc_eng_nm();      
		ofc_krn_nm   		= account.getOfc_krn_nm();      
		usr_auth_tp_cd 		= account.getUsr_auth_tp_cd();      
		usr_locl_nm  		= account.getUsr_locl_nm();      
		mn_scrn_opt_id 		= account.getMn_scrn_opt_id();      
		rhq_ofc_cd   		= account.getXtn_phn_no();      
		xtn_phn_no   		= account.getXtn_phn_no();      
		fax_no       		= account.getFax_no();      
		srep_cd      		= account.getSrep_cd();      
		ofc_org_cd   		= account.getOfc_org_cd();   
		
		/* System.out.println( " &&&&&&&&&&&&&&&& SignOnUserAccount Info S - &&&&&&&&&&&&&&&&&&&&& " ); */
		log.info("ibflag ->" 			+ account.getIbflag() );      
		log.info("page_rows ->" 		+ account.getPage_rows() );      
		log.info("usr_id ->" 			+ account.getUsr_id() );      
		log.info("usr_nm ->" 			+ account.getUsr_nm() );      
		log.info("usr_pwd ->" 			+ account.getUsr_pwd() );      
		log.info("use_flg ->" 			+ account.getUse_flg() );      
		log.info("mphn_no ->" 			+ account.getMphn_no() );      
		log.info("usr_eml ->" 			+ account.getUsr_eml() );      
		log.info("cnt_cd ->" 			+ account.getCnt_cd() );      
		log.info("lang_tp_cd ->" 		+ account.getLang_tp_cd() );      
		log.info("cre_usr_id ->" 		+ account.getCre_usr_id() );      
		log.info("upd_usr_id ->" 		+ account.getUpd_usr_id() );      
		log.info("upd_dt ->" 			+ account.getUpd_dt() );      
		//log.info("access_system " + account.getAccess_system() );      
		log.info("dflt_eml ->" 			+ account.getDflt_eml() );      
		log.info("usr_eml ->" 			+ account.getUsr_eml() );      
		log.info("cre_dt ->" 			+ account.getCre_dt() );      
		log.info("ofc_cd ->" 			+ account.getOfc_cd() );      
		log.info("ofc_eng_nm ->" 		+ account.getOfc_eng_nm() );      
		log.info("ofc_krn_nm ->" 		+ account.getOfc_krn_nm() );      
		log.info("usr_auth_tp_cd ->" 	+ account.getUsr_auth_tp_cd() );      
		log.info("usr_locl_nm ->" 		+ account.getUsr_locl_nm() );      
		log.info("mn_scrn_opt_id ->" 	+ account.getMn_scrn_opt_id() );      
		log.info("rhq_ofc_cd ->" 		+ account.getXtn_phn_no() );      
		log.info("xtn_phn_no ->" 		+ account.getXtn_phn_no() );      
		log.info("fax_no ->" 			+ account.getFax_no() );      
		log.info("srep_cd ->" 			+ account.getSrep_cd() );      
		log.info("ofc_org_cd ->" 		+ account.getOfc_org_cd());         
		/* System.out.println( " &&&&&&&&&&&&&&&& SignOnUserAccount Info E - &&&&&&&&&&&&&&&&&&&&& " ); */
	   
		log.info("toDay ->" 		+ toDay );     
		event = (EesCim0063Event)request.getAttribute("Event");
		/* System.out.println( " event : " + event.toString() ); */
		
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		/* System.out.println( " eventResponse : " + event.toString() ); */

		//Login User Office Code 정보 
		ofc_cd = eventResponse.getETCData("RTNVAL");
		rhq_ofc_cd = account.getRhq_ofc_cd();
	}catch(Exception e) {
		out.println(e.toString());
	}
	
	// PopUp 일 경우 인자 받음.
	String strUCNo = JSPUtil.getNull(request.getParameter("uc_cs_no"));

%>
<html>
<head>
<title>UnCollected</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			///showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form" id="form">
<input type="hidden" name="session_usr_nm" value="<%=strUsr_nm %>">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="pagetype" 	value = "I">
<input type="hidden" name="usr_id" 		value="<%=usr_id%>" >
<input type="hidden" name="ofc_cd" 		value="<%=ofc_cd%>" >
<input type="hidden" name="rhq_ofc_cd" 	value="<%=rhq_ofc_cd%>" >
<input type="hidden" name="auth_cd" >
<input type="hidden" name="dt_type" 	value = "G">
<input type="hidden" name="bk_uc_sts_cd" >
<input type="hidden" name="uc_rsn_desc" >
<input type="hidden" name="frst_pod_eta" >
<input type="hidden" name="intg_cd" >
<!-- 관리자인지 사용자인지 구분 -->
<input type="hidden" name="isauthority" >

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

			
		<!--Button (S) -->
	    <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 0; padding-bottom: 2;">
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
							<td class="btn1" name="btn_new" >New</td>
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
<!-- 					<td class="btn1_line"></td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"	class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_close">Close</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td> -->
				</tr>
				</table>
			</td>
		</tr>
		</table>
		<!--Button (E) -->
		 
		<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">		
			<!-- biz_1  (S) -->
			<table class="search" border="0" style="width: 979;">
			<tr class="h23">
				<td width="68">UC Case No</td>
				<td width="160">
					<input name="uc_cs_no" type="text" style="width:150; text-align:center;" class="input" dataformat="engup" value = "<%=strUCNo %>">
				</td>
				<td width="500">
					<input type="checkbox" class="trans" name="search_flg" >Search
				</td>  
				<td width="90">Creation Date</td>
				<td width="85">
					<input name="cre_dt" dataformat="ymd" type="text" style="width:80; text-align:center;" class="input2" readonly>
				</td>
				<td width="12">
					<table border="0" cellpadding="0" cellspacing="0" class="button">
					<tr>
						<td class="btn1_bg">
							<table border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_line"></td>
							</tr>
							</table>
						</td>
					</tr>
					</table>
				</td>
				<td width="" ><img src="img/btns_inquiry.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btn_hidden" class="cursor"></td>
			</tr>
			</table>
							
			<table class="search" border="0" style="width: 979;">
			<tr class="h23">
				<td width="145">Handling Office&nbsp;&nbsp;|&nbsp;RHQ</td>
				<td width="130">
					<input name="hndl_rhq_cd" type="text" style="width:80; text-align:center;" class="input2" readonly>
				</td>
				<td width="95">Branch/Agent</td>
				<td width="130">
					<input name="hndl_brnc_cd" type="text" style="width:80; text-align:center;" class="input1" dataformat="engup">
				</td>
				<td width="52">Handler</td>
				<td width="130">
					<input name="hndl_hdlr_usr_id" type="text" style="width:80; text-align:center;" class="input1" dataformat="engnum" >
				</td>
				<td width="52">Update</td>
				<td>
					<input name="hndl_upd_id" type="text" style="width:80; text-align:center;" class="input2" readonly>
					<input name="hndl_upd_dt" dataformat="ymd" type="text" style="width:80; text-align:center;" class="input2" readonly>
				</td>
			</tr>
			</table>			
			
			<table class="search" border="0" style="width: 979;">
			<tr class="h23">
				<td width="145">Counter Office&nbsp;&nbsp;&nbsp;|&nbsp;RHQ</td>
				<td width="130">
					<input name="kntr_rhq_cd" type="text" style="width:80; text-align:center;" class="input2" readonly>
				</td>
				<td width="95">Branch/Agent</td>
				<td width="130">
					<input name="kntr_brnc_cd" type="text" style="width:80; text-align:center;" class="input1" dataformat="engup">
				</td>
				<td width="52">Handler</td>
				<td width="130">
					<input name="kntr_hdlr_usr_id" type="text" style="width:80; text-align:center;" class="input" dataformat="engnum">
				</td>
				<td width="52">Update</td>
				<td>
					<input name="kntr_upd_id" type="text" style="width:80; text-align:center;" class="input2" readonly>
					<input name="kntr_upd_dt" dataformat="ymd" type="text" style="width:80; text-align:center;" class="input2" readonly>
				</td>
			</tr>
			</table>
							
			<table class="">
				<tr>
					<td colspan="6"></td>
				</tr>
				</table>
					
			<table class="search" border="0"  style="width: 979;" >
			<tr class="h23">
				<td width="50">Status</td>
				<td width="160" style="padding-left:2;">
					<script language="javascript">ComComboObject('uc_sts_cd',2,153,1,0,0);</script>
				</td>
				<td width="70" id = "reopen_display">
					<input type="hidden" name="uc_ropn_flg">
					<input type="checkbox" class="trans" name="chk_uc_ropn_flg" disabled>Reopen
				</td>  
				<td width="130">
					<input type="hidden" name="uc_ofc_trns_flg">
					<input type="checkbox" class="trans" name="chk_uc_ofc_trns_flg" >OFC Transfer
				</td> 
				<td width="60">UC Date</td>
				<td width="110">
					<input type="text" dataformat="ymd" style="width: 82; text-align:center;" class="input1" name="cnee_uc_dt"> 
				</td>  
				<td width="85">Close Date</td>
				<td width="100">
					<input type="text" dataformat="ymd" style="width: 82; text-align:center;" class="input" name="uc_clz_dt"> 
				</td>  
				<td width="55">UC Days</td>
				<td width="60">
					<input name="uc_dys" type="text" style="width:40; text-align:center;" class="input2" readonly >
				</td>  
				<td width="120">Days from Disch.</td>
				<td width = "50">
					<input name="uc_dchg_dys" type="text" style="width:40; text-align:center;" class="input2" readonly>
				</td>
			</tr>
			</table>
										
			<table class="search" border="0"  style="width: 979;" >
			<tr class="h23">
				<td width="70">Sequence</td>
				<td width=2y0>
					<table>
					<tr>
						<td style="padding-left:2;">
							<script language="javascript">ComComboObject('uc_seq',1,46,1,0,1);</script>
						</td>
						<td>
							<input name="uc_seq_ttl" type="text" style="width:40; text-align:center;" class="input" readonly>
						</td>
						<td>
							<table width="80" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn2_left"></td>
								<td class="btn2" name="btn_add_seq" id="btn_add_seq">Add Seq</td>
								<td class="btn2_right"></td>
							</tr>
							</table>
						</td>
						<td>
							<table width="80" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn2_left"></td>
								<td class="btn2" name="btn_del_seq" id="btn_del_seq">DEL Seq</td>
								<td class="btn2_right"></td>
							</tr>
							</table>
						</td>
					</tr>
					</table>
				</td>
				<td width="75">B/L Inquiry</td>
				<td width="170" style="padding-left:2;">
					<script language="javascript">ComComboObject('bl_no_lst',1,130,1,0,1,null,null,false);</script>
				</td>
				<td width="100" >Total CNTR Vol</td>
				<td>
					<table>
					<tr>
						<td>
							<input name="uc_ctrt_ttl_vol" type="text" style="width:80; text-align:center;" class="input2" readonly >
						</td>
						<td width = "150">
							<table width="120" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn2_left"></td>
								<td class="btn2" style="color:3D5A7A;"  name="btn_uc_cntr_dtl" id="btn_uc_cntr_dtl">CNTR Inquiry</td>
								<td class="btn2_right"></td>
							</tr>
							</table>
						</td>
					</tr>
					</table>
				</td>
				<td>
					<table width="80" border="0" cellpadding="1" cellspacing="0" class="button">
					<tr>
						<td class="btn2_left"></td>
						<td class="btn2" style="color:3D5A7A;"  name="btn_uc_activity" id="btn_uc_activity">File</td>
						<td class="btn2_right"></td>
					</tr>
					</table>
				</td>																							
			</tr>
			</table>
			
					
			<!-- biz_1  (E) -->
			<div id="subterms">
							
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				
			<!-- biz_2  (S) -->
							
			<table>
			<tr>
				<td class="title_h"></td>
				<td class="title_s" width="200">Contract of Carriage</td>
			</tr>
			</table>
							
			<table class="search_sm" border="0" style="width: 979;" name="main1" id="main1">
			<tr class="h23">
				<td width="45">B/L No</td>
				<td width = "225">
					<table>
					<tr>
						<td>
							<input name="bl_no" type="text" dataformat="engup" style="width:130; text-align:center;" class="input1">
						</td>
						<td>
							<table width="60" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn2_left"></td>
								<td class="btn2" style="color:3D5A7A;"  name="btn_info" id="btn_info">Info</td>
								<td class="btn2_right"></td>
							</tr>
							</table>
						</td>
					</tr>
					</table>
				</td>
				<td width="70" >CNTR Vol</td>
				<td>
					<table>
					<tr>
						<td>
							<input name="ctrt_ttl_vol_ctnt" type="text" style="width:80; text-align:center;" class="input1" readonly>
						</td>
						<td width = "150">
							<table width="120" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn2_left"></td>
								<td class="btn2" style="color:3D5A7A;"  name="btn_bl_cntr_dtl" id="btn_bl_cntr_dtl">CNTR Inquiry</td>
								<td class="btn2_right"></td>
							</tr>
							</table>
						</td>
						<td>
							<input name="cntr_list" type="hidden" style="width:80; text-align:center;" class="input1" >
						</td>
					</tr>
					</table>
				</td>
			</tr>
			</table>
	
			<table class="search_sm" border="0" style="width: 979;" name="main1_1" id="main1_1">
			<tr class="h23">
				<td width="220">
					<table class="search" border="0" style="width: 250;">
					<tr class="h23">
						<td width=30">VVD</td>
						<td width="80">
							<input name="vvd" type="text" style="width:80; text-align:center;" class="input2" readonly> 
						</td>
						<td width="125"> 
							<input name="vsl_nm" type="text" style="width:125; text-align:left;" class="input2" readonly >
						</td>
					</tr>
	 				<tr class="h23">
						<td width="30">POR</td>
						<td width="80">
							<input name="por" type="text" style="width:80; text-align:center;" class="input2" readonly > 
						</td>
						<td width="125"> 
							<input name="por_dt" dataformat="ymd"  type="text" style="width:125; text-align:center;" class="input2" readonly>
						</td>
					</tr>
					<tr class="h23">
						<td width="30">POL</td>
						<td width="80">
							<input name="pol" type="text" style="width:80; text-align:center;" class="input2" readonly > 
						</td>
						<td width="125"> 
							<input name="pol_etd" dataformat="ymd" type="text" style="width:125; text-align:center;" class="input2" readonly >
						</td>
					</tr>
					<tr class="h23">
						<td width="30">POD</td>
						<td width="80">
							<input name="pod" type="text" style="width:80; text-align:center;" class="input2" readonly > 
						</td>
						<td width="125"> 
							<input name="pod_eta" dataformat="ymd" type="text" style="width:125; text-align:center;" class="input2" readonly >
						</td>
					</tr>
					<tr class="h23">
						<td width="30">DEL</td>
						<td width="80">
							<input name="del_cd" type="text" style="width:80; text-align:center;" class="input2" readonly > 
						</td>
						<td width="125"> 
					 		<input name="del_dt" dataformat="ymd"  type="text" style="width:125; text-align:center;" class="input2" readonly>
						</td>
					</tr> 
					</table>
				</td>
								
				<td width="370">
					<table class="search" border="0" style="width:332;">
					<tr class="h23">
						<td>Shipper</td>
						<td>
							<input name="shpr" type="text" style="width:260; text-align:left;" class="input2" readonly >
						</td>
					</tr>
					<tr class="h23">
						<td>F/Agent</td>
						<td>
							<input name="frwd" type="text" style="width:260; text-align:left;" class="input2" readonly >
						</td>
					</tr>
					<tr class="h23">
						<td>Consignee</td>
						<td>
							<input name="cnee" type="text" style="width:260; text-align:left;" class="input2" readonly >
						</td>
					</tr>
					<tr class="h23">
						<td>Notify Party</td>
						<td>
							<input name="noti" type="text" style="width:260; text-align:left;" class="input2" readonly >
						</td>
					</tr>
					<tr class="h23">
						<td>Commodity</td>
						<td>
							<input name="cmdt" type="text" style="width:260; text-align:left;" class="input2" readonly >
						</td>
					</tr>
					</table>
				</td>
									
				<td width="335" >
					<table class="search" border="0" >
					<tr class="h23">
						<td width="70"> O/Freight</td>
						<td>
							<table class="grid1" border="0" style="width: 200;">
							<tr class="h23">
								<td width="60">Prepaid</td>
								<td width="140">USD&nbsp;&nbsp;<input name="prepaid" type="text"   dataformat="float" pointcount = "2"  maxLength = "14" style="width:100; text-align:right;" class="input2"  readonly></td>
							</tr>
							<tr class="h23">
								<td width="60">Collect</td>
								<td width="140">USD&nbsp;&nbsp;<input name="collect" type="text"  dataformat="float" pointcount = "2"  maxLength = "14" style="width:100; text-align:right;" class="input2" readonly ></td>
							</tr>
							</table>
						</td>
					</tr>
					</table>
					<table class="search" border="0" style="width: 100%;">
					<tr class="h23">
						<td width="45" >Remarks</td>
						<td>
							<textarea name="uc_ctrt_rmk" rows="4" cols="60" ></textarea>
						</td>
					</tr>
					</table>
				</td>					
			</tr>
			</table>
							
			<!-- biz_2  (E) -->
				
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				
			<!-- biz_3  (S) -->	
									
			<table>
			<tr>
				<td class="title_h"></td>
				<td class="title_s" width="200">UC Details</td>
			</tr>
			</table>
			
							
			<table class="search_sm" border="0" style="width: 979;"name="main2" id="main2">
			<tr class="h23" >
				<td width="75">UC Reasons</td>
				<td width="90" style="padding-left:2;">
					<script language="javascript">ComComboObject('uc_rsn_cd',2,80,1,1,0);</script>
				</td>	
				<td width="110">Disposal/Solution</td>
				<td width="90" style="padding-left:2;">
					<script language="javascript">ComComboObject('uc_disp_opt_cd',2,80,1,0,0);</script>
				</td>
				<td width="85">Invoice Value</td>
				<td>
					<input name="uc_inv_curr_cd" type="text" style="width:50; text-align:center;" class="input" readonly>
					<input name="uc_inv_amt" type="text" style="width:100; text-align:right;" class="input" readonly>
				</td>
				<td>Exchange</td>
				<td>
					<input name="uc_inv_xch_rt" type="text" style="width:100; text-align:right;" class="input" readonly>
					<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_inv_exchange">
				</td>
				<td width="25">USD</td>
				<td>
					<input name="uc_inv_usd_amt" type="text" style="width:100; text-align:right;" class="input" readonly>
				</td>
			</tr>				
			<tr class="h23">
				<td width="75">D/O Issued</td>
				<td width="90">
					<input name="uc_do_iss_dt" dataformat="ymd"  type="text" style="width:80; text-align:center;" class="input2" readonly>
				</td>
				<td width="110">OB/L Holder</td>
				<td width="90" style="padding-left:2;">
					<script language="javascript">ComComboObject('uc_obl_hld_cd',2,80,1,0,0);</script>
				</td>
				<td width="92">Current Value</td>
				<td>
					<input name="uc_crnt_curr_cd" type="text" style="width:50; text-align:center;" class="input" readonly>
					<input name="uc_crnt_amt" type="text" style="width:100; text-align:right;" class="input" readonly>
				</td>
				<td>Exchange</td>
				<td>
					<input name="uc_crnt_xch_rt" type="text" style="width:100; text-align:right;" class="input" readonly>
					<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_cur_exchange">
				</td>
				<td>USD</td>
				<td>
					<input name="uc_crnt_usd_amt" type="text" style="width:100; text-align:right;" class="input" readonly>
				</td>
			</tr>
			</table>
					
			<table class="search_sm" border="0" style="width: 979;" name="main2_2" id="main2_2">
			<tr class="h23">
				<td width="110">Abandonment Letter</td>
				<td width="160">
					<table class="search" border="0">
					<tr class="h23">
						<td width="70">&nbsp;Shipper</td>
						<td>
							<input name="aban_ltr_shpr_dt" dataformat="ymd" type="text" style="width:80; text-align:center;" >
						</td>
					</tr>
					<tr class="h23">
						<td width="70">&nbsp;Consignee</td>
						<td>
							<input name="aban_ltr_cnee_dt" dataformat="ymd" type="text" style="width:80; text-align:center;" >
						</td>
					</tr>
					</table> 
				</td>
	
				<td width="330">
					<table class="search" border="0" style="width: 100%;">
					<tr class="h23">
						<td width="80">1st Notice</td>
						<td width="90">
							<input name="uc_cgo_n1st_ntc_dt" dataformat="ymd" type="text" style="width:80; text-align:center;"> 
						</td>
						<td width="85">2nd Notice</td>
						<td width="90">
							<input name="uc_cgo_n2nd_ntc_dt" dataformat="ymd" type="text" style="width:80; text-align:center;" = > 
						</td>
					</tr>
					
					<tr class="h23">
						<td width="80">3rd Notice</td>
						<td width="90">
							<input name="uc_cgo_n3rd_ntc_dt" dataformat="ymd" type="text" style="width:80; text-align:center;" > 
						</td>
						<td width="85">Final Notice</td>
						<td width="90">
							<input name="uc_cgo_fnl_ntc_dt" dataformat="ymd" type="text" style="width:80; text-align:center;" > 
						</td>
					</tr>
					</table> 
				</td>
				
				<td width="52">Remarks</td>
				<td>
					<textarea name="uc_cgo_ntc_rmk" rows="4" cols="60" ></textarea>
				</td>
			</tr>
			</table>
							
			<table class="search_sm" border="0" style="width: 979;" name="main2_3" id="main2_3">
			<tr class="h23">
				<td width="88">CGO Location</td>
				<td width="230">
					<input name="uc_cgo_loc_nm" type="text" style="width:200; text-align:left;" class="input" maxlength="100"> 
				</td>
				<td width="60">P&I Club</td>
				<td width="230" style="padding-left:2;">
					<script language="javascript">ComComboObject('uc_piclb_cd',2,200,1,0,0);</script>
				</td>
				<td width="55">P&I Ref</td>
				<td>
					<input name="uc_piclb_ref_no" type="text" style="width:225; text-align:left;" class="input" maxlength="100" >
				</td>
			</tr>
			</table>
				
			<!-- biz_3  (E) -->
				
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				
			<!-- biz_4  (S) -->							
			<table class=" ">
			<tr>
				<td class="title_h"></td>
				<td class="title_s" width="200">Outstanding Charge & Cost</td>
			</tr>
			</table>
							
			<table class="search_sm" border="0" style="width: 979;" name="main3" id="main3">
			<tr class="h23">
				<td width="152">O/Freight OFT</td>
				<td width="200">
					<table>
					<tr>
						<td>
							USD<input name="ots_oft_amt" caption = "O/Freight OFT" dataformat="float" pointcount = "2" maxLength = "14" style="width:100; text-align:right;" class="input">
						</td>
					</tr>
					</table>
				</td>
				<td width="150">
					<table width="130" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr>
						<td class="btn2_left"></td>
						<td class="btn2" style="color:3D5A7A;"  name="btn_help_exchange" id="btn_help_exchange" tabindex = 0>Help Exchange</td>
						<td class="btn2_right"></td>
					</tr>
					</table>
				</td>
				<td width="132">Recovery Amount</td>
				<td>
					<table>
					<tr>
						<td>
							USD<input name="ots_rcvr_amt" type="text" dataformat="float" pointcount = "2" maxLength = "14" style="width:100; text-align:right;" class="input" >
						</td>
					</tr>
					</table>
				</td>
			</tr>
				
			<tr class="h23">
				<td width="152">O/Freight Others</td>
				<td>
					<table>
					<tr>
						<td>
							USD<input name="ots_otr_amt" type="text" dataformat="float" pointcount = "2" maxLength = "14" style="width:100; text-align:right;" class="input"  >
						</td>
					</tr>
					</table>
				</td>
				<td>
					<table width="130" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr>
						<td class="btn2_left"></td>
						<td class="btn2" style="color:3D5A7A;"  name="btn_dem_det_info" id="btn_dem_det_info">DEM/DET Info</td>
						<td class="btn2_right"></td>
					</tr>
					</table>
				</td>
				<td width="82">Net Loss</td>
				<td>
					<table>
					<tr>
						<td>
							USD<input name="net_loss" type="text" dataformat="float" pointcount = "2" maxLength = "14" style="width:100; text-align:right;" class="input2" readonly >
						</td>
					</tr>
					</table>
				</td>
			</tr>
							
			<tr class="h23">
				<td width="82">DEM/DET</td>
				<td colspan="2">
					<table>
					<tr>
						<td>
							USD<input name="ots_dmdt_amt" type="text" dataformat="float" pointcount = "2" maxLength = "14" style="width:100; text-align:right;" class="input">
						</td>
						<td>
							&nbsp;As of&nbsp;<input name="ots_dmdt_dt" dataformat="ymd" type="text" style="width:80; text-align:center;" class="input">
						</td>
					</tr>
					</table>
				</td>
				<td>Insurance Cover</td>
				<td>
					<table>
					<tr>
						<td>
							USD<input name="ots_insur_cvr_amt" type="text" dataformat="float" pointcount = "2" maxLength = "14" style="width:100; text-align:right;" class="input">
						</td>
					</tr>
					</table>
				</td>
			</tr>
						
			<tr class="h23">
				<td width="82">Storage</td>
				<td colspan="2">
				<table>
				<tr>
						<td>
							USD<input name="ots_sto_amt" type="text" dataformat="float" pointcount = "2" maxLength = "14" style="width:100; text-align:right;" class="input">
						</td>
						<td>
							&nbsp;As of&nbsp;<input name="ots_sto_dt" type="text" dataformat="ymd" style="width:80; text-align:center;" class="input">
						</td>
					</tr>
					</table>
				</td>
				<td>Remarks</td>
				<td colspan="3" rowspan="3">
					<textarea name="ots_rmk" rows="4" cols="70%" ></textarea>
				</td>
			</tr>
							
			<tr class="h23">
				<td width="92">Other Cost</td>
				<td colspan="3">
					<table border="0">
					<tr>
						<td>
							USD<input name="ots_otr_cost_amt" type="text" dataformat="float" pointcount = "2" maxLength = "14" style="width:100; text-align:right;" class="input">
						</td>
						<td>
							&nbsp;As of&nbsp;<input name="ots_otr_cost_dt" type="text" dataformat="ymd" style="width:80; text-align:center;" class="input">
						</td>
					</tr>
					</table>
				</td>
			</tr>
			
			<tr class="h23">
				<td width="152">Total Charge & Cost</td>
				<td>
					<table>
					<tr>
						<td>
							USD<input name="ots_total" type="text" dataformat="float" pointcount = "2" maxLength = "14" style="width:100; text-align:right;" class="input2" readonly>
						</td>
					</tr>
					</table>
			</td>
			</tr>
			</table>
			<!-- biz_4  (E) -->
		</td></tr>
		</table>
		<!--biz page (E)-->
 	</td>
</tr>			
</table>
				
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
<tr> 
	<td valign="top">		
		<!-- Tab Header (S) -->
		<table class="height_8"><tr><td colspan="8"></td></tr></table>
		<!-- Tab (S) -->
     		<table class="tab" border="0" cellpadding="0" cellspacing="0" style="width:998;"> 
       			<tr>
       			    <td width="100%">
				       <script language="javascript">ComTabObject('tab1')</script>
			        </td>
			     </tr>
		     </table>
		<!-- Tab Header (E) -->	
        <table  border="0" cellpadding="0" cellspacing="0" style="width:998px;" >
	         <tr>
	             <td width="100%">
  		
	         	 <!--TAB Fact Finding & Activity (S) -->
				 <div id="tabLayer" style="display:inline">
				 <table class="search" > 
						<tr>
							<td width="100%" >
								<textarea name="fact_fnd_act_desc" rows="32" cols="192" ></textarea>
							</td>
						</tr>
				 </table>
				 </div>
				<!--TAB Fact Finding & Activity (E) -->
				<!--TAB Handling OFC Opinion (S) -->
				<div id="tabLayer" style="display:none" >
				<table class="search" > 
						<tr>
							<td width="100%">
								<textarea name="hndl_ofc_opin_desc" rows="32" cols="192"></textarea>
							</td>
						</tr>
				</table>
				</div>
				<!--TAB Handling OFC Opinion (E) -->
				<!--TAB Counter Office Opinion (S) -->
				<div id="tabLayer" style="display:none">
				<table class="search" > 
						<tr>
							<td width="100%">
								<textarea name="kntr_ofc_opin_desc" rows="32" cols="192"></textarea>
							</td>
						</tr>
				</table>
				</div>
				<!--TAB Counter Office Opinion (E) -->	
				<!--TAB Counter Office Opinion (S) -->
				<div id="tabLayer" style="display:none">
				<table class="search"> 
                    <tr> 
					    <td align="right" style="padding-bottom:2; padding-top:7; padding-right:12;">
							<table width=70  border="0" cellpadding="0" cellspacing="0" class="button"  >
							<tr>
								<td class="btn2_left"></td>
								<td class="btn2" name="btn_mSave">Save</td>
								<td class="btn2_right"></td>
							</tr>
							</table>
						</td>
					</tr>
						<tr>
							<td width="100%">
								<textarea name="manager_memo" rows="30" cols="192"></textarea>
							</td>
						</tr>
				</table>
				</div>
		 	</td>
		</tr>			
	</table>
<!--biz page (E)--> 
<!-- Grid  (S) -->														
<table width="100%" id="mainTable"> 
<tr>
	<td width="100%">
		<script language="javascript">ComSheetObject('sheet1');</script>
	</td>
</tr>
</table> 
<!-- Grid (E) -->
	
	
<!-- 개발자 작업  끝 -->
</table>
</form>
</body>
</html>



