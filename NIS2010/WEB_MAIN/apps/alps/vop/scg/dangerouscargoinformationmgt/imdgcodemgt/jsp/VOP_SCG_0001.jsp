<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_scg_0001.jsp
*@FileTitle : UN Number (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.14
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.05.14 이도형
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.event.VopScg0001Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopScg0001Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg 	= "";						//에러메세지
	int rowCount	 	= 0;						//DB ResultSet 리스트의 건수
	
	String successFlag 	= "";
	String codeList  	= "";
	String pageRows  	= "100";
	String strUsr_id	= "";
	String strUsr_nm	= "";
	String pop_yn       = "";
	String imdg_un_no   = "";
	String imdg_un_no_seq  = "";
	Logger log = Logger.getLogger("com.hanjin.apps.DangerousCargoInformationMgt.IMDGCodeMgt");
	
	// popflg 값 가져오기.
	String popflag = StringUtil.xssFilter(request.getParameter("popflag"));
	if(popflag == null){
		popflag = "";
	}
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
		event = (VopScg0001Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		//pop_yn      = StringUtil.xssFilter(request.getParameter("pop_mode"))==null?"N":"Y";
		pop_yn      = StringUtil.xssFilter(request.getParameter("pop_mode"))==""?"N":"Y";
		imdg_un_no  = StringUtil.xssFilter(request.getParameter("imdg_un_no"))==null?"":StringUtil.xssFilter(request.getParameter("imdg_un_no"));		
		imdg_un_no_seq = StringUtil.xssFilter(request.getParameter("imdg_un_no_seq"))==null?"":StringUtil.xssFilter(request.getParameter("imdg_un_no_seq"));
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>UN Number (Creation)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	//팝업호출 및 초기조회조건
	var preConds = {
		pop_yn       : "<%=pop_yn%>",
		imdg_un_no   : "<%=imdg_un_no%>",
		imdg_un_no_seq  : "<%=imdg_un_no_seq%>"
	}

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if

		if('Y' == preConds.pop_yn) {		
			//닫기버튼 보이기
			document.all.popLayer.style.display = "";
			
			//Set title of page
			var titleStr = "UN Number";
			try {
				var appName = navigator.appName;
			 	if (appName.indexOf("Netscape") == -1) {
			  		document.all.pophistory.innerHTML = "";
			  		document.all.title.innerHTML = '&nbsp; '+titleStr;
			  		document.title = titleStr;
			 	} else {
			  		document.getElementById("pophistory").innerHTML = "";
			  		document.getElementById("title").innerHTML = '&nbsp; '+titleStr;
			  		document.title = titleStr;
			 	}
			 	document.getElementById("mainTbl").cellPadding = "10";
			}catch(err) {
			 	ComShowMessage(err);
			}
		}else{
			var toDay = new Date();
		    var year  = toDay.getUTCFullYear();
		    var month = toDay.getUTCMonth() + 1;
		    var day   = toDay.getUTCDate();
		    var hours = toDay.getUTCHours();
		    var minutes = toDay.getUTCMinutes();
		    if(month < 10) month = '0' + month;
		    if(day < 10) day = '0' + day;
		    if(hours < 10) hours = '0' + hours;
		    if(minutes < 10) minutes = '0' + minutes;
		    var toDays = year + '-' + month + '-' + day + ' ' + hours + ':' + minutes;
			//document.form.frm_upd_usr_id.value = '<%//=strUsr_id%>';
			//document.form.frm_upd_dt.value = toDays;
	    }
		loadPage();
	}
</script>
</head>


<!-- 개발자 작업	-->
<% if (pop_yn=="Y") { %>
<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="popflag" value="<%=popflag%>">
<table width="100%" class="popup" cellpadding="0" border="0"> 
	<tr>
		<td class="top"></td>
	</tr>
<% }else{ %>
<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<table width="100%" border="0" cellpadding="0" cellspacing="0">
<% } %>
	<tr>
		<td valign="top">
			<table id="mainTbl" width="100%" height="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
				<tr height="100%">
					<td valign="top" height="100%">
						<!--Page Title, Historical (S)-->
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
							<tr><td class="history" id="pophistory"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
							<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
						</table>
						<!--Page Title, Historical (E)-->
			
						<!--biz page (S)-->
						<table class="search"> 
					       	<tr>
					       		<td class="bg">
									<!--  biz_1  (S) -->
									<table class="search" border="0" style="width:100%;"> 
										<tr class="h23">
											<td width="110">(1) UN No.</td>
											<td width="130"><input type="text" name="imdg_un_no" caption="UN No." maxlength="4" style="width:50;ime-mode:disabled;" class="input1" value=""></td>
											<td width="30">Seq.</td>
											<td width="130"><input type="text" name="imdg_un_no_seq" caption="Seq." readonly style="width:40;text-align:center;" class="input1" value="">&nbsp;<img src="img/btns_back.gif" name="btn_SeqPrev" width="19" height="20" alt="" border="0" style="cursor:hand;" align="absmiddle">&nbsp;<img src="img/btns_next.gif" name="btn_SeqNext" width="19" height="20" alt="" border="0" style="cursor:hand;" align="absmiddle"></td> 
											<td width="30">Max.</td>
											<td width="60"><input type="text" name="imdg_un_no_seq_max" caption="Max." readonly style="width:40;text-align:center;" class="input2" value=""></td> 
											<td width="30">Min.</td>
											<td width="140"><input type="text" name="imdg_un_no_seq_min" caption="Min." readonly style="width:40;text-align:center;" class="input2" value=""></td> 
											<td width="120">Total Data Count</td>
											<td width="219"><input type="text" name="imdg_un_no_seq_cnt" caption="Total Date Count" readonly style="width:40;text-align:center;" class="input2" value=""></td>
										</tr>
										<tr class="h23">
											<td>SML Restrictions</td>
											<td colspan="7"><input type="text" name="frm_imdg_crr_rstr_expt_nm" style="width:90;" readonly class="input2" value=""></td>
											<td>Update By</td>
											<td><input type="text" name="frm_upd_usr_id" style="width:100;" class="input2" readonly value="">&nbsp;<input type="text" name="frm_upd_dt" style="width:110;" readonly class="input2" value=""></td></tr>
											<tr><td colspan="15" class="line_bluedot"></td>
										</tr>
										<tr class="h23">
											<td colspan="13">(2) Proper Shipping Name&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="frm_prp_shp_nm" id="prp_shp_nm" style="width:810;ime-mode:disabled;" class="input1" value=""></td>
										</tr>
									</table>
									<!--  biz_1   (E) -->
								</td>
							</tr>
						</table>
						<table class="height_8"><tr><td></td></tr></table>
					    <!--biz page (S)-->
			
					    <!-- table width="100%" id="mainTable" style="display:none"-->
					    <table width="100%" id="mainTable" >
					        <tr>
					            <td width="100%">
					            	<script language="javascript">ComSheetObject('sheet1');</script>
					            </td>
					        </tr>
					    </table>
					    <!--biz page (E)-->
			
						<!-- Tab ) (S) -->
			     		<table class="tab" border="0" cellpadding="0" cellspacing="0" style="width:100%;"> 
			       			<tr>
			       				<td width="100%">
									<script language="javascript">ComTabObject('tab1');</script>
								</td>
							</tr>
						</table>
						<!-- Tab ) (E) -->
			
						<!--TAB Substance Details (S) -->
						<div id="tabLayer" style="display:inline">
						<!-- Grid BG Box  (S) -->
						<table class="search" id="mainTable">
					    	<tr>
					       		<td class="bg" valign="top">
									<!--  biz_2  (S) -->
									<table class="search" border="0" style="width:100%;"> 
										<tr class="h23">
											<td width="130">(3) Class or Division</td>
											<td width="210">&nbsp;&nbsp;
										   		<script language="javascript">ComComboObject('frm_imdg_clss_cd', 2, 50, 1, 1);</script>&nbsp;
										   		<script language="javascript">ComComboObject('frm_imdg_comp_grp_cd', 1, 40, 1);</script>
											</td>
											<td width="140">(4) Subsidiary risk(s)</td>
											<td width="240">&nbsp;&nbsp;
										   		<script language="javascript">ComComboObject('frm_imdg_subs_rsk_lbl_cd1', 1, 50, 0);</script>&nbsp;
										   		<script language="javascript">ComComboObject('frm_imdg_subs_rsk_lbl_cd2', 1, 50, 0);</script>&nbsp;
										   		<script language="javascript">ComComboObject('frm_imdg_subs_rsk_lbl_cd3', 1, 50, 0);</script>&nbsp;
										   		<script language="javascript">ComComboObject('frm_imdg_subs_rsk_lbl_cd4', 1, 50, 0);</script>
											</td>
											<td width="140">(4) Marine pollutant</td>
											<td>&nbsp;
												<script language="javascript">ComComboObject('frm_imdg_mrn_polut_cd', 1, 60, 0, 0, 0, false, '', true);</script>
											</td> 
										</tr>
										<tr class="h23">
											<td width=""colspan="2"></td>
											<td width="">SRL Remark(s)</td>
											<td width="" colspan="3">&nbsp;
												<input type="text" name="frm_imdg_subs_rsk_lbl_rmk" maxlength="4000" style="width:472;ime-mode:disabled;" class="input" value="">
											</td>
										</tr>
										<tr class="h23">
											<td>(5) Packing group</td>
											<td>&nbsp;&nbsp;
												<script language="javascript">ComComboObject('frm_imdg_pck_grp_cd', 1, 60, 0, 0, 0, false, '', true);</script>
											</td>
											<td>(6) Special Provisions</td>
											<td colspan="3">&nbsp;
												<input type="text" name="frm_imdg_spcl_provi_no1" id="frm_imdg_spcl_provi_no1" caption="Special Provisions 1" dataformat="int" maxlength="3" style="width:33;text-align:right;ime-mode:disabled;" class="input" value="">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btn_imdg_spcl_provi_no1" width="19" height="20" border="0" align="absmiddle">
												<input type="text" name="frm_imdg_spcl_provi_no2" id="frm_imdg_spcl_provi_no2" caption="Special Provisions 2" dataformat="int" maxlength="3" style="width:33;text-align:right;ime-mode:disabled;" class="input" value="">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btn_imdg_spcl_provi_no2" width="19" height="20" border="0" align="absmiddle">
												<input type="text" name="frm_imdg_spcl_provi_no3" id="frm_imdg_spcl_provi_no3" caption="Special Provisions 3" dataformat="int" maxlength="3" style="width:33;text-align:right;ime-mode:disabled;" class="input" value="">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btn_imdg_spcl_provi_no3" width="19" height="20" border="0" align="absmiddle">
												<input type="text" name="frm_imdg_spcl_provi_no4" id="frm_imdg_spcl_provi_no4" caption="Special Provisions 4" dataformat="int" maxlength="3" style="width:30;text-align:right;ime-mode:disabled;" class="input" value="">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btn_imdg_spcl_provi_no4" width="19" height="20" border="0" align="absmiddle">
												<input type="text" name="frm_imdg_spcl_provi_no5" id="frm_imdg_spcl_provi_no5" caption="Special Provisions 5" dataformat="int" maxlength="3" style="width:40;text-align:right;ime-mode:disabled;" class="input" value="">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btn_imdg_spcl_provi_no5" width="19" height="20" border="0" align="absmiddle">
												<input type="text" name="frm_imdg_spcl_provi_no6" id="frm_imdg_spcl_provi_no6" caption="Special Provisions 6" dataformat="int" maxlength="3" style="width:30;text-align:right;ime-mode:disabled;" class="input" value="">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btn_imdg_spcl_provi_no6" width="19" height="20" border="0" align="absmiddle">
												<input type="text" name="frm_imdg_spcl_provi_no7" id="frm_imdg_spcl_provi_no7" caption="Special Provisions 7" dataformat="int" maxlength="3" style="width:30;text-align:right;ime-mode:disabled;" class="input" value="">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btn_imdg_spcl_provi_no7" width="19" height="20" border="0" align="absmiddle">
												<input type="text" name="frm_imdg_spcl_provi_no8" id="frm_imdg_spcl_provi_no8" caption="Special Provisions 8" dataformat="int" maxlength="3" style="width:30;text-align:right;ime-mode:disabled;" class="input" value="">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btn_imdg_spcl_provi_no8" width="19" height="20" border="0" align="absmiddle">
											</td>
										</tr>
										<tr class="h23">
											<td>(7a) Limited Q'ty</td>
											<td>&nbsp;
												<input type="text" name="frm_imdg_lmt_qty" caption="Limited Q'ty" maxlength="4" style="width:50;text-align:center;ime-mode:disabled;" class="input" value="">
												<select name="frm_imdg_lmt_qty_meas_ut_cd" style="width:65;">
													<option value=""></option>
													<option value="Ml">ml</option>
													<option value="L">l</option>
													<option value="G">g</option>
													<option value="KG">kg</option>
													<option value="ML">ml or g</option>
													<option value="LKG">l or kg</option>
												</select>&nbsp;
												<input type="text" name="frm_imdg_lmt_qty_desc" caption="Limited Q'ty Desc" maxlength="5" style="width:50;ime-mode:disabled;" class="input" value="">
											</td>
											<td>(7b) Excepted Q'ty</td>
											<td>&nbsp;&nbsp;
										   		<script language="javascript">ComComboObject('frm_imdg_expt_qty_cd', 1, 60, 0);</script>&nbsp;
												<input type="text" name="frm_imdg_expt_qty_desc" caption="Excepted Q'ty Desc" maxlength="5" style="width:50;ime-mode:disabled;" class="input" value="">
											</td>
											<td colspan="2">(15) EmS No.&nbsp;&nbsp;
												<input type="text" name="frm_imdg_emer_no" maxlength="14" style="width:173;text-align:left;ime-mode:disabled;" class="input" value="">
											</td>
										</tr>
										<tr class="h23">
											<td>Stowage category</td>
											<td>&nbsp;
												<input type="text" name="frm_imdg_stwg_cate_cd" caption="Stowage category" dataformat="engup" maxlength="2" style="width:142;text-align:center;ime-mode:disabled;" class="input" value="">
											</td>
											<td>Flash Point</td>
											<td>&nbsp;
												<input type="text" name="frm_flsh_pnt_temp_ctnt" caption="Flash Point" maxlength="100" style="width:83;text-align:right;ime-mode:disabled;" class="input" value="">&nbsp;&deg;C c.c
											</td>
											<td colspan="2">ERG&nbsp;
												<input type="text" name="frm_emer_rspn_gid_no" caption="ERG" maxlength="3" style="width:108;text-align:center;ime-mode:disabled;" class="input" value="">
												<input type="text" name="frm_emer_rspn_gid_chr_no" maxlength="2" style="width:121;text-align:center;ime-mode:disabled;" class="input" value="">
											</td>
										</tr>
										<tr class="h23">
											<td colspan="2">First schedule for Singapore&nbsp;<input type="text" name="frm_psa_no" style="width:104;text-align:center;ime-mode:disabled;" maxlength="12" class="input" value=""></td>
											<td colspan="2">BPT&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												<input type="text" name="frm_n1st_bom_port_trst_no" maxlength="2" dataformat="engup" style="width:52;text-align:center;ime-mode:disabled;" class="input" value="">
												<input type="text" name="frm_n2nd_bom_port_trst_no" maxlength="2" dataformat="engup" style="width:52;text-align:center;ime-mode:disabled;" class="input" value="">
												<input type="text" name="frm_n3rd_bom_port_trst_no" maxlength="2" dataformat="engup" style="width:52;text-align:center;ime-mode:disabled;" class="input" value="">
												<input type="text" name="frm_n4th_bom_port_trst_no" maxlength="2" dataformat="engup" style="width:52;text-align:center;ime-mode:disabled;" class="input" value="">
											</td>
											<td>LPK&nbsp;
												<input type="text" name="frm_pkg_auth_no" maxlength="7" style="width:108;text-align:center;ime-mode:disabled;" class="input" value="">
											</td>
											<td>&nbsp;&nbsp;SLPA&nbsp;&nbsp;<input type="text" name="frm_lk_port_auth_no" maxlength="7" style="width:77;text-align:center;ime-mode:disabled;" class="input" value=""></td>
										</tr>
										<tr class="h23">
											<td colspan="">Technical Name</td>
											<td colspan="5">&nbsp;
												<input type="text" name="frm_imdg_tec_nm_desc" style="width:847;text-align:left" readonly class="input2" value="">
											</td>
										</tr>
									</table>
									<table class="search" border="0" style="width:100%;"> 
										<tr class="h23">
											<td width="220" valign="top">(17) Properties and Observations</td>
											<td><textarea name="frm_imdg_sbst_ppt_desc" maxlength="4000" style="ime-mode:disabled;" cols="149" rows="5"></textarea></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
						<!-- Grid BG Box  (S) -->
						</div>
						<!--TAB Substance Details (E) -->
						
						<!--TAB CFR/Segregation/Others (S) -->
						<div id="tabLayer" style="display:none">
						<!-- Grid BG Box  (S) -->
				     	<table class="search" id="mainTable">
					       	<tr>
					       		<td class="bg" valign="top">
									<!--  biz_2  (S) -->
									<table class="search" border="0">
										<tr>
											<td class="title_h"></td>
											<td class="title_s">CFR Information</td>
										</tr>
										<tr><td class="height_5"></td></tr>
									</table>
									<table class="search" border="0" style="width:100%;"> 
										<tr class="h23">
											<td width="70">RQ</td>
											<td width="150"><input type="text" name="frm_cfr_rpt_qty" caption="Reportable Quantity" dataformat="float" pointcount="3" maxlength="8" style="width:80;text-align:right;ime-mode:disabled;" class="input" value=""></td>
											<td width="150">Poison Inhalation Zone</td>
											<td width="609"><input type="text" name="frm_cfr_psn_inh_zn_cd" maxlength="10" style="width:80;text-align:right;ime-mode:disabled;" class="input" value=""></td>  
										</tr>
										<tr class="h23">
											<td>TOXIC</td>
											<td><input type="text" name="frm_cfr_toxc_cd" maxlength="7" style="width:80;text-align:right;ime-mode:disabled;" class="input" value=""></td>
											<td>Dangerous when wet</td>
											<td><input type="text" name="frm_cfr_dg_wet_cd" maxlength="20" style="width:80;text-align:right;ime-mode:disabled;" class="input" value=""></td>  
										</tr>
										<tr class="h23">
											<td>Port Rest.</td>
											<td colspan="3"><input type="text" name="frm_cfr_rstr_port_nm" maxlength="50" style="width:382;ime-mode:disabled;" class="input" value=""></td> 
										</tr>
										<tr class="h23">
											<td>OPR Rest.</td>
											<td><input type="text" name="frm_cfr_rstr_opr_nm" maxlength="20" style="width:80;text-align:right;ime-mode:disabled;" class="input" value=""></td>
											<td>Extend Class.</td>
											<td style="padding-left:2"><script language="javascript">ComComboObject('frm_cfr_xtd_clss_cd', 1, 50, 0);</script></td>  
										</tr>
									</table>
									<table  class="line_bluedot"><tr><td colspan="8"></td></tr></table>
									<!--  biz_4  (S) -->
									<table class="search" border="0">
										<tr>
											<td class="title_h"></td>
											<td class="title_s"> HCDG</td>
										</tr>
										<tr><td class="height_5"></td></tr>
									</table>
									<table class="search" border="0" style="width:100%;"> 
										<tr class="h23">
											<td>
												<input type="checkbox" name="frm_hcdg_flg" value="Y" class="trans">HCDG&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												<input type="checkbox" name="frm_hcdg_dpnd_qty_flg" value="Y" class="trans">Depends on Q'ty
											</td>
										</tr>
									</table>
									<table class="grid2" border="0" style="width:100%;"> 
										<tr class="h23">
											<td width="120" class="tr2_head">HCDG<br>Remark(s)</td>
											<td><textarea name="frm_hcdg_rmk" maxlength="4000" style="ime-mode:disabled;" cols="167" rows="3"></textarea></td>
										</tr>
									</table>
									<!--  biz_4  (E) -->
								</td>
							</tr>
						</table>
						<!-- Grid BG Box  (S) -->
						</div>
						<!--TAB CFR/Segregation/Others (E) -->
						
						<!--TAB Packing/IBC/Tank Instruction & Provision & Restrictions (S) -->
						<div id="tabLayer" style="display:none">
						<!-- Grid BG Box  (S) -->
				     	<table class="search" id="mainTable">
					       	<tr>
					       		<td class="bg" valign="top">
									<!--  biz_2  (S) -->
									<table class="search" border="0">
										<tr>
											<td class="title_h"></td>
											<td class="title_s">Packing / IBC / Tank Instructions & Provisions</td>
										</tr>
										<tr><td class="height_5"></td></tr>
									</table>
									<table class="search" border="0" style="width:100%;"> 
										<tr class="h23">
											<td width="143">Packing Instructions</td>
											<td width="839">
												<input type="text" name="frm_n1st_imdg_pck_instr_cd" maxlength="10" style="width:100;text-align:center;text-decoration:underline;color:#3a7cbf;ime-mode:disabled;" class="input" value=""><img class="cursor" name="btns_n1st_imdg_pck_instr_cd" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">&nbsp;
												<input type="text" name="frm_n2nd_imdg_pck_instr_cd" maxlength="10" style="width:100;text-align:center;text-decoration:underline;color:#3a7cbf;ime-mode:disabled;" class="input" value=""><img class="cursor" name="btns_n2nd_imdg_pck_instr_cd" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">&nbsp;
												<input type="text" name="frm_n3rd_imdg_pck_instr_cd" maxlength="10" style="width:100;text-align:center;text-decoration:underline;color:#3a7cbf;ime-mode:disabled;" class="input" value=""><img class="cursor" name="btns_n3rd_imdg_pck_instr_cd" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
												<input type="hidden" name="frm_n1st_imdg_pck_instr_seq" value="">
												<input type="hidden" name="frm_n2nd_imdg_pck_instr_seq" value="">
												<input type="hidden" name="frm_n3rd_imdg_pck_instr_seq" value="">
												
												
											</td>
										</tr>
										<tr class="h23">
											<td>Packing Provisions</td>
											<td>
												<input type="text" name="frm_n1st_imdg_pck_provi_cd" maxlength="10" style="width:100;text-align:center;text-decoration:underline;color:#3a7cbf;ime-mode:disabled;" class="input" value=""><img class="cursor" name="btns_n1st_imdg_pck_provi_cd" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">&nbsp;
												<input type="text" name="frm_n2nd_imdg_pck_provi_cd" maxlength="10" style="width:100;text-align:center;text-decoration:underline;color:#3a7cbf;ime-mode:disabled;" class="input" value=""><img class="cursor" name="btns_n2nd_imdg_pck_provi_cd" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">&nbsp;
												<input type="text" name="frm_n3rd_imdg_pck_provi_cd" maxlength="10" style="width:100;text-align:center;text-decoration:underline;color:#3a7cbf;ime-mode:disabled;" class="input" value=""><img class="cursor" name="btns_n3rd_imdg_pck_provi_cd" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">&nbsp;
												<input type="text" name="frm_n4th_imdg_pck_provi_cd" maxlength="10" style="width:100;text-align:center;text-decoration:underline;color:#3a7cbf;ime-mode:disabled;" class="input" value=""><img class="cursor" name="btns_n4th_imdg_pck_provi_cd" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">&nbsp;
												<input type="text" name="frm_n5th_imdg_pck_provi_cd" maxlength="10" style="width:100;text-align:center;text-decoration:underline;color:#3a7cbf;ime-mode:disabled;" class="input" value=""><img class="cursor" name="btns_n5th_imdg_pck_provi_cd" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
												<input type="hidden" name="frm_n1st_imdg_pck_provi_seq" value="">
												<input type="hidden" name="frm_n2nd_imdg_pck_provi_seq" value="">
												<input type="hidden" name="frm_n3rd_imdg_pck_provi_seq" value="">
												<input type="hidden" name="frm_n4th_imdg_pck_provi_seq" value="">
												<input type="hidden" name="frm_n5th_imdg_pck_provi_seq" value="">
											</td> 
										</tr>
										<tr class="h23">
											<td>IBC Instructions</td>
											<td>
												<input type="text" name="frm_n1st_imdg_ibc_instr_cd" maxlength="10" style="width:100;text-align:center;text-decoration:underline;color:#3a7cbf;ime-mode:disabled;" class="input" value=""><img class="cursor" name="btns_n1st_imdg_ibc_instr_cd" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">&nbsp;
												<input type="text" name="frm_n2nd_imdg_ibc_instr_cd" maxlength="10" style="width:100;text-align:center;text-decoration:underline;color:#3a7cbf;ime-mode:disabled;" class="input" value=""><img class="cursor" name="btns_n2nd_imdg_ibc_instr_cd" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">&nbsp;
												<input type="text" name="frm_n3rd_imdg_ibc_instr_cd" maxlength="10" style="width:100;text-align:center;text-decoration:underline;color:#3a7cbf;ime-mode:disabled;" class="input" value=""><img class="cursor" name="btns_n3rd_imdg_ibc_instr_cd" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">&nbsp;
												<input type="text" name="frm_n4th_imdg_ibc_instr_cd" maxlength="10" style="width:100;text-align:center;text-decoration:underline;color:#3a7cbf;ime-mode:disabled;" class="input" value=""><img class="cursor" name="btns_n4th_imdg_ibc_instr_cd" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">&nbsp;
												<input type="text" name="frm_n5th_imdg_ibc_instr_cd" maxlength="10" style="width:100;text-align:center;text-decoration:underline;color:#3a7cbf;ime-mode:disabled;" class="input" value=""><img class="cursor" name="btns_n5th_imdg_ibc_instr_cd" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
												<input type="hidden" name="frm_n1st_imdg_ibc_instr_seq" value="">
												<input type="hidden" name="frm_n2nd_imdg_ibc_instr_seq" value="">
												<input type="hidden" name="frm_n3rd_imdg_ibc_instr_seq" value="">
												<input type="hidden" name="frm_n4th_imdg_ibc_instr_seq" value="">
												<input type="hidden" name="frm_n5th_imdg_ibc_instr_seq" value="">
											</td> 
										</tr>
										<tr class="h23">
											<td>IBC Provisions</td>
											<td>
												<input type="text" name="frm_n1st_imdg_ibc_provi_cd" maxlength="10" style="width:100;text-align:center;text-decoration:underline;color:#3a7cbf;ime-mode:disabled;" class="input" value=""><img class="cursor" name="btns_n1st_imdg_ibc_provi_cd" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">&nbsp;
												<input type="text" name="frm_n2nd_imdg_ibc_provi_cd" maxlength="10" style="width:100;text-align:center;text-decoration:underline;color:#3a7cbf;ime-mode:disabled;" class="input" value=""><img class="cursor" name="btns_n2nd_imdg_ibc_provi_cd" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">&nbsp;
												<input type="text" name="frm_n3rd_imdg_ibc_provi_cd" maxlength="10" style="width:100;text-align:center;text-decoration:underline;color:#3a7cbf;ime-mode:disabled;" class="input" value=""><img class="cursor" name="btns_n3rd_imdg_ibc_provi_cd" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">&nbsp;
												<input type="text" name="frm_n4th_imdg_ibc_provi_cd" maxlength="10" style="width:100;text-align:center;text-decoration:underline;color:#3a7cbf;ime-mode:disabled;" class="input" value=""><img class="cursor" name="btns_n4th_imdg_ibc_provi_cd" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">&nbsp;
												<input type="text" name="frm_n5th_imdg_ibc_provi_cd" maxlength="10" style="width:100;text-align:center;text-decoration:underline;color:#3a7cbf;ime-mode:disabled;" class="input" value=""><img class="cursor" name="btns_n5th_imdg_ibc_provi_cd" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
												<input type="hidden" name="frm_n1st_imdg_ibc_provi_seq" value="">
												<input type="hidden" name="frm_n2nd_imdg_ibc_provi_seq" value="">
												<input type="hidden" name="frm_n3rd_imdg_ibc_provi_seq" value="">
												<input type="hidden" name="frm_n4th_imdg_ibc_provi_seq" value="">
												<input type="hidden" name="frm_n5th_imdg_ibc_provi_seq" value="">
											</td> 
										</tr>
										<tr class="h23">
											<td>UN Tank Instructions</td>
											<td>
												<input type="text" name="frm_n1st_imdg_un_tnk_instr_cd" maxlength="10" style="width:100;text-align:center;text-decoration:underline;color:#3a7cbf;ime-mode:disabled;" class="input" value=""><img class="cursor" name="btns_n1st_imdg_un_tnk_instr_cd" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">&nbsp;
												<input type="text" name="frm_n2nd_imdg_un_tnk_instr_cd" maxlength="10" style="width:100;text-align:center;text-decoration:underline;color:#3a7cbf;ime-mode:disabled;" class="input" value=""><img class="cursor" name="btns_n2nd_imdg_un_tnk_instr_cd" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
												<input type="hidden" name="frm_n1st_imdg_un_tnk_instr_seq" value="">
												<input type="hidden" name="frm_n2nd_imdg_un_tnk_instr_seq" value="">
											</td> 
										</tr>
										<tr class="h23">
											<td>Tank Special Provisions</td>
											<td>
												<input type="text" name="frm_n1st_imdg_tnk_instr_provi_cd" maxlength="10" style="width:100;text-align:center;text-decoration:underline;color:#3a7cbf;ime-mode:disabled;" class="input" value=""><img class="cursor" name="btns_n1st_imdg_tnk_instr_provi_cd" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">&nbsp;
												<input type="text" name="frm_n2nd_imdg_tnk_instr_provi_cd" maxlength="10" style="width:100;text-align:center;text-decoration:underline;color:#3a7cbf;ime-mode:disabled;" class="input" value=""><img class="cursor" name="btns_n2nd_imdg_tnk_instr_provi_cd" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">&nbsp;
												<input type="text" name="frm_n3rd_imdg_tnk_instr_provi_cd" maxlength="10" style="width:100;text-align:center;text-decoration:underline;color:#3a7cbf;ime-mode:disabled;" class="input" value=""><img class="cursor" name="btns_n3rd_imdg_tnk_instr_provi_cd" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">&nbsp;
												<input type="text" name="frm_n4th_imdg_tnk_instr_provi_cd" maxlength="10" style="width:100;text-align:center;text-decoration:underline;color:#3a7cbf;ime-mode:disabled;" class="input" value=""><img class="cursor" name="btns_n4th_imdg_tnk_instr_provi_cd" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">&nbsp;
												<input type="text" name="frm_n5th_imdg_tnk_instr_provi_cd" maxlength="10" style="width:100;text-align:center;text-decoration:underline;color:#3a7cbf;ime-mode:disabled;" class="input" value=""><img class="cursor" name="btns_n5th_imdg_tnk_instr_provi_cd" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
												<input type="hidden" name="frm_n1st_imdg_tnk_instr_provi_seq" value="">
												<input type="hidden" name="frm_n2nd_imdg_tnk_instr_provi_seq" value="">
												<input type="hidden" name="frm_n3rd_imdg_tnk_instr_provi_seq" value="">
												<input type="hidden" name="frm_n4th_imdg_tnk_instr_provi_seq" value="">
												<input type="hidden" name="frm_n5th_imdg_tnk_instr_provi_seq" value="">
											</td> 
										</tr>
									</table>
									<table  class="line_bluedot"><tr><td colspan="8"></td></tr></table>
									<table class="search" border="0">
										<tr>
											<td class="title_h"></td>
											<td class="title_s"> HCDG - Packing / IBC / Tank Restrictions</td>
										</tr>
										<tr><td class="height_5"></td></tr>
									</table>
									<table class="search" border="0" style="width:100%;"> 
										<tr class="h23">
											<td width="143">Packaging</td>
											<td width=""><input type="text" name="frm_hcdg_pck_rstr_desc" maxlength="100" style="width:100%;ime-mode:disabled;" class="input" value=""></td> 
										</tr>
										<tr class="h23">
											<td>Intermediate Bulk</td>
											<td width=""><input type="text" name="frm_hcdg_intmd_bc_rstr_desc" maxlength="100" style="width:100%;ime-mode:disabled;" class="input" value=""></td> 
										</tr>
										<tr class="h23">
											<td>Tank</td>
											<td><input type="text" name="frm_hcdg_tnk_rstr_desc" maxlength="500" style="width:850;ime-mode:disabled;" class="input" value=""></td> 
										</tr>
									</table>
								</td>
							</tr>
						</table>
						<!-- Grid BG Box  (S) -->
						</div>
						<!--TAB Packing/IBC/Tank Instruction & Provision & Restrictions (E) -->
						
						<!--TAB Stowage and Segregation (S) -->
						<div id="tabLayer" style="display:none">
						<!-- Grid BG Box  (S) -->
				     	<table class="search" id="mainTable">
					       	<tr>
					       		<td class="bg" valign="top">
									<!--  biz_  (S) -->
									<table class="search" border="0" style="width:100%;"> 
										<tr class="h23">
											<td width="210">(16) Stowage and Segregation</td>
											<td width=""><input type="text" name="frm_segr_desc" maxlength="1000" style="width:780;ime-mode:disabled;" class="input" value=""></td>
										</tr>
									</table>
									<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
									<table class="search" border="0">
										<tr>
											<td class="title_h"></td>
											<td class="title_s">Stowage</td>
										</tr>
									</table>
									<table class="search" border="0" style="width:100%;"> 
										<tr class="h23">
											<td width="130">Clear of Living Q'tr</td>
											<td width="150">
												<select name="frm_clr_liv_qtr_stwg_flg" style="width:96;">
													<option value="N">No</option>
													<option value="Y">Yes</option>
												</select>
											</td>
											<td width="80">Foodstuffs</td>
											<td width="150">
												<select name="frm_imdg_fd_stuf_stwg_cd" style="width:96;">
													<option value="0">None</option>
													<option value="1">Away from</option>
													<option value="2">Separate from</option>
												</select>
											</td>
											<td width="100">Source of Heat</td>
											<td width="">
												<select name="frm_imdg_ht_src_stwg_cd" style="width:96;">
													<option value="0">None</option>
													<option value="1">Away from</option>
													<option value="2">Separate from</option>
												</select>
											</td>
										</tr>
									</table>
									<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
									<table class="search" border="0">
										<tr>
											<td class="title_h"></td>
											<td class="title_s" style="width:100;"> Segregation</td>
											<td style="width:760;"><input type="checkbox" name="frm_imdg_un_no_hld_flg" value="" class="trans"><b>Pre-Checking  hold</b></td>
						    				<td class="btn2_bg">
												<table border="0" cellpadding="0" cellspacing="0">
													<tr>
														<td>
															<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
																<tr>
																	<td class="btn2_left"></td>
																	<td class="btn2" name="btn_AutoCreation">Auto Creation</td>
																	<td class="btn2_right"></td>
																</tr>
															</table>
														</td>										
													</tr>
												</table>
											</td>
										</tr>
									</table>
									<table class="search_sm" border="0" style="width:100%;"> 
										<tr class="h23">
											<td>	
												<table width="962" align="center" id="mainTable"> 
													<tr>
														<td width="100%">
															<script language="javascript">ComSheetObject('sheet2');</script>
														</td>
													</tr>
												</table>
												<table width="962" align="center" id="mainTable"> 
													<tr>
														<td width="100%">
															<script language="javascript">ComSheetObject('sheet3');</script>
														</td>
													</tr>
												</table>
									    		<table class="height_8"><tr><td colspan="8"></td></tr></table>
												<table class="search" border="0" style="width:100%"> 
													<tr class="h23">
														<td width="150"><input type="checkbox" name="frm_segr_as_for_imdg_clss_flg" value="" class="trans">&nbsp;Segregation as for </td>
														<td width="60">&nbsp;
													   		<script language="javascript">ComComboObject('frm_segr_as_for_imdg_clss_cd', 1, 45, 0);</script>
														</td>
														<td width="285"><input type="checkbox" name="frm_away_fm_imdg_clss_flg" value="" class="trans">&nbsp;Away from Class</td>
														<td width="130">&nbsp;
													   		<script language="javascript">ComComboObject('frm_away_fm_imdg_clss_cd', 1, 120, 0);</script>
														</td>
														<td width="215"><input type="checkbox" name="frm_sprt_fm_imdg_clss_flg" value="" class="trans">&nbsp;Separated from Class</td>
														<td width="">&nbsp;
													   		<script language="javascript">ComComboObject('frm_sprt_fm_imdg_clss_cd', 1, 120, 0);</script>
														</td>
													</tr>
													<tr class="h23">
														<td>&nbsp;</td>
														<td>&nbsp;</td>
														<td><input type="checkbox" name="frm_sprt_hld_fm_imdg_clss_flg" value="" class="trans">&nbsp;Separated by comptmnt or hold fm Class</td>
														<td>&nbsp;
													   		<script language="javascript">ComComboObject('frm_sprt_hld_fm_imdg_clss_cd', 1, 120, 0);</script>
														</td>
														<td><input type="checkbox" name="frm_sprt_lon_fm_imdg_clss_flg" value="" class="trans">&nbsp;Separated longtdn’ly fm Class</td>
														<td width="">&nbsp;
													   		<script language="javascript">ComComboObject('frm_sprt_lon_fm_imdg_clss_cd', 1, 120, 0);</script>
														</td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
						    		<table class="height_8"><tr><td colspan="8"></td></tr></table>
									<table class="search_sm" border="0" style="width:100%;"> 
										<tr class="h23">
											<td>	
												<table class="search" border="0" style="width:100%;"> 
													<tr class="h23">
														<td width="150">&nbsp;Segregation Groups </td>
														<td width="225">
															<input type="text" name="frm_hcdg_tnk_rstr_desc1" readonly style="width:40;text-align:center" class="input2" value="">
															<input type="text" name="frm_hcdg_tnk_rstr_desc2" readonly style="width:40;text-align:center" class="input2" value="">
															<input type="text" name="frm_hcdg_tnk_rstr_desc3" readonly style="width:40;text-align:center" class="input2" value="">
															<input type="text" name="frm_hcdg_tnk_rstr_desc4" readonly style="width:40;text-align:center" class="input2" value="">
														</td>
														<td width="120"><input type="checkbox" name="frm_away_fm_imdg_segr_grp_flg" value="" class="trans">&nbsp;Away from SG</td>
														<td width="130">&nbsp;
													   		<script language="javascript">ComComboObject('frm_away_dp_seq', 1, 120, 0);</script>
														</td>
														<td width="215"><input type="checkbox" name="frm_sprt_fm_imdg_segr_grp_flg" value="" class="trans">&nbsp;Separated from SG</td>
														<td width="">&nbsp;
													   		<script language="javascript">ComComboObject('frm_sprt_dp_seq', 1, 120, 0);</script>
														</td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
									<!-- Grid BG Box  (S) -->
								</td>
							</tr>
						</table>
						</div>
						<!--TAB Stowage and Segregation (E) -->
			
						<!--TAB Organic Peroxides & Self-Reactive Substances (S) -->			
						<div id="tabLayer" style="display:none">
				     	<table class="search" id="mainTable">
					       	<tr>
					       		<td class="bg" valign="top">
									<!--  biz_  (S) -->
									<table class="search" border="0" style="width:100%;"> 
										<tr class="h23">
											<td width="140">Classification</td>
											<td width="">
												<select name="frm_imdg_org_ract_tp_cd" style="width:170;">
													<option value=""></option>
													<option value="P">Organic Peroxides</option>
													<option value="S">Self-Reactive Substance</option>
												</select>
											</td>
										</tr>
										<tr class="h23">
											<td width="">Technical Name</td>
											<td width=""><input type="text" name="frm_imdg_tec_nm" maxlength="500" style="width:850;ime-mode:disabled;" class="input" value=""></td>
										</tr>
										<tr class="h23">
											<td width="">Concentration (%)</td>
											<td width=""><input type="text" name="frm_imdg_conc_rt_ctnt" maxlength="50" style="width:228;ime-mode:disabled;" class="input" value=""></td>
										</tr>
										<tr class="h23">
											<td width="">Packing Method</td>
											<td width=""><input type="text" name="frm_imdg_pck_mzd_cd" maxlength="20" style="width:228;ime-mode:disabled;" class="input" value=""></td>
										</tr>
										<tr class="h23">
											<td width="">Control Temp (℃)</td>
											<td width=""><input type="text" name="frm_imdg_ctrl_temp" caption="Control Temp (℃)" maxlength="6" dataformat="float" pointcount="3" style="width:228;text-align:right;ime-mode:disabled;" class="input" value=""></td>
										</tr>
										<tr class="h23">
											<td width="">Emergency Temp (℃)</td>
											<td width=""><input type="text" name="frm_imdg_emer_temp" caption="Emergency Temp (℃)" maxlength="6" dataformat="float" pointcount="3" style="width:228;text-align:right;ime-mode:disabled;" class="input" value=""></td>
										</tr>
										<tr class="h23">
											<td width="">Subsidiary risk(s)</td>
											<td width="">
												<input type="text" name="frm_n1st_imdg_subs_rsk_lbl_cd" readonly style="width:54;text-align:center" class="input2" value="">
												<input type="text" name="frm_n2nd_imdg_subs_rsk_lbl_cd" readonly style="width:54;text-align:center" class="input2" value="">
												<input type="text" name="frm_n3rd_imdg_subs_rsk_lbl_cd" readonly style="width:54;text-align:center" class="input2" value="">
												<input type="text" name="frm_n4th_imdg_subs_rsk_lbl_cd" readonly style="width:54;text-align:center" class="input2" value="">
											</td>
										</tr>
									</table>
									
				<table class="height_5"><tr><td></td></tr></table>
								</td>
							</tr>
						</table>
						</div>
						<!--TAB Organic Peroxides & Self-Reactive Substances (E) -->	
<%
if(popflag == "") {				// 팝업으로 호출될 경우
%>		
						<!--Button (S) -->
						<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;padding-bottom:10;"> 
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
												<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn1_left"></td>
														<td class="btn1" name="btn_Copy">Copy</td>
														<td class="btn1_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn1_left"></td>
														<td class="btn1" name="btn_Delete">Delete</td>
														<td class="btn1_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn1_left"></td>
														<td class="btn1" name="btn_Save">Save</td>
														<td class="btn1_right"></td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
<%
}				// 메인으로 호출될 경우.
%>
					    <!--Button (E) -->
					</td>
				</tr>				
			</table>
		</td>
	</tr>
</table>
<div id="popLayer" style="display:none">	
				<!-- : ( Button : pop ) (S) -->
				<table width="100%" class="sbutton">
					<tr>
						<td height="71" class="popup">	
							<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
				       			<tr>
				       				<td class="btn3_bg">
						    			<table border="0" cellpadding="0" cellspacing="0">
						    				<tr>
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
				<!-- : ( Button : pop ) (E) -->
			</div>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>