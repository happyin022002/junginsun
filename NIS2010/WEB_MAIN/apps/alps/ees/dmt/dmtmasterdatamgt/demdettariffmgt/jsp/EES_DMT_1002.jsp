<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_1002.jsp
*@FileTitle : Basic Tariff Creation - Group
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.05.26 김태균
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
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.event.EesDmt1002Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt1002Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.DMTMasterDataMgt.DemDetaariffMgt");
	String today = DateTime.getDateString();
	today = today.replace(".","-");
	
	String dmdt_trf_cd		= "";
	String dmdt_trf_nm		= "";
	String cvrg_conti_cd	= "";
	String cvrg_cnt_cd		= "";
	String cvrg_rgn_cd		= "";
	String cvrg_ste_cd		= "";
	String cvrg_loc_cd		= "";
	String cvrg_yd_cd		= "";
	String dmdt_de_term_cd 	= "";
	String dmdt_de_term_nm 	= "";
	String org_dest_conti_cd= "";
	String org_dest_cnt_cd	= "";
	String org_dest_rgn_cd	= "";
	String org_dest_ste_cd	= "";
	String org_dest_loc_cd	= "";
	String button_mode		= "";
	String wknd1			= "";
	String wknd2			= "";
	String before_exp_dt	= "";
	String svr_id			= "";
	String trf_seq			= "";
	String trf_grp_seq			= "";
	String dmdt_bzc_trf_grp_nm	= "";
	String ui_code			= "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();


		event = (EesDmt1002Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		dmdt_trf_cd 	= JSPUtil.getParameter(request,"dmdt_trf_cd");
		dmdt_trf_nm 	= JSPUtil.getParameter(request,"dmdt_trf_nm");
		cvrg_conti_cd 	= JSPUtil.getParameter(request,"cvrg_conti_cd");
		cvrg_cnt_cd 	= JSPUtil.getParameter(request,"cvrg_cnt_cd");
		cvrg_rgn_cd 	= JSPUtil.getParameter(request,"cvrg_rgn_cd");
		cvrg_ste_cd 	= JSPUtil.getParameter(request,"cvrg_ste_cd");
		cvrg_loc_cd 	= JSPUtil.getParameter(request,"cvrg_loc_cd");
		cvrg_yd_cd 		= JSPUtil.getParameter(request,"cvrg_yd_cd");
		dmdt_de_term_cd	= JSPUtil.getParameter(request, "dmdt_de_term_cd");	// Dem/det Delivery Term Code
		dmdt_de_term_nm	= JSPUtil.getParameter(request, "dmdt_de_term_nm");	// Dem/det Delivery Term Name
		org_dest_conti_cd = JSPUtil.getParameter(request,"org_dest_conti_cd");
		org_dest_cnt_cd = JSPUtil.getParameter(request,"org_dest_cnt_cd");
		org_dest_rgn_cd = JSPUtil.getParameter(request,"org_dest_rgn_cd");
		org_dest_ste_cd = JSPUtil.getParameter(request,"org_dest_ste_cd");
		org_dest_loc_cd = JSPUtil.getParameter(request,"org_dest_loc_cd");
		button_mode			= JSPUtil.getParameter(request,"button_mode");
		wknd1			= JSPUtil.getParameter(request,"wknd1");
		wknd2			= JSPUtil.getParameter(request,"wknd2");
		before_exp_dt	= JSPUtil.getParameter(request,"exp_dt");
		svr_id			= JSPUtil.getParameter(request,"svr_id");
		trf_seq			= JSPUtil.getParameter(request,"trf_seq");
		trf_grp_seq		= JSPUtil.getParameter(request,"trf_grp_seq");
		dmdt_bzc_trf_grp_nm	= JSPUtil.getParameter(request,"dmdt_bzc_trf_grp_nm");
		ui_code			= JSPUtil.getParameter(request,"ui_code");
		

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Basic Tariff Creation - Group</title>
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

<body class="popup_bg" onLoad="setupPage();" onUnLoad="unLoadPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="curr_cd">

<input type="hidden" name="cvrg_rgn_cd" value="<%=cvrg_rgn_cd %>">
<input type="hidden" name="cvrg_ste_cd" value="<%=cvrg_ste_cd %>">
<input type="hidden" name="org_dest_rgn_cd" value="<%=org_dest_rgn_cd %>">
<input type="hidden" name="org_dest_ste_cd" value="<%=org_dest_ste_cd %>">
<input type="hidden" name="button_mode" value="<%=button_mode %>">
<input type="hidden" name="today_dt" value="<%=today %>">
<input type="hidden" name="cnt_cd" >
<input type="hidden" name="wknd1" value="<%=wknd1 %>">
<input type="hidden" name="wknd2" value="<%=wknd2 %>">
<input type="hidden" name="before_exp_dt" value="<%=before_exp_dt %>">
<input type="hidden" name="svr_id" value="<%=svr_id %>">
<input type="hidden" name="trf_seq" value="<%=trf_seq %>">
<input type="hidden" name="trf_grp_seq" value="<%=trf_grp_seq %>">
<input type="hidden" name="dmdt_de_term_cd" value="<%=dmdt_de_term_cd %>">
<input type="hidden" name="ui_code" value="<%=ui_code %>">
<input type="hidden" name="success_yn">

<input type="hidden" name="exp_dt_old" value="">
<input type="hidden" name="exp_dt_1" value="">

<input type="hidden" name="bzc_trf_xtn_flg" value="">

<!-- 개발자 작업	-->
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Basic Tariff Creation - Group</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:884;"> 
				<tr class="h23">
					<td width="80">Tariff Type</td>
					<td width="425"><input type="text" name="dmdt_trf_cd" style="width:96;" class="input2" readonly value="<%=dmdt_trf_cd %>">&nbsp;<input type="text" name="dmdt_trf_nm" style="width:298;" class="input2" value="<%=dmdt_trf_nm %>"></td>
					<td width="70">User Office</td>
					<td width="80">&nbsp;<input type="text" name="ofc_cd" style="width:65;" class="input2" readonly  value="<%=strOfc_cd %>"></td>
					<td width="70">User Name</td>
					<td>&nbsp;<input type="text" name="usr_nm" style="width:150;" class="input2" readonly  value="<%=strUsr_nm %>"></td>
					</tr> 
				</table>
				<table class="search" border="0" style="width:884;"> 
				<tr class="h23">
					<td width="80">Coverage</td>
					<td width="110" class="stm">Continent&nbsp;<input type="text" name="cvrg_conti_cd" style="width:40;" class="input2"  readonly value="<%=cvrg_conti_cd %>"></td>
					<td width="120" class="stm">Country&nbsp;<input type="text" name="cvrg_cnt_cd" style="width:50;" class="input2"  readonly value="<%=cvrg_cnt_cd %>"></td>
					<td width="42" class="stm"><%if(cvrg_cnt_cd.equals("CA") || cvrg_cnt_cd.equals("US")){%>State<%}else{%>Region<%} %></td>
					<td width="78">&nbsp;<input type="text" name="cvrg_rgn_ste_cd" style="width:60;" class="input2" readonly ></td>
					<td width="120" class="stm">Location&nbsp;<input type="text" name="cvrg_loc_cd" style="width:60;" class="input2" readonly value="<%=cvrg_loc_cd %>"></td>
					<td width="105" class="stm">Yard&nbsp;<input type="text" name="cvrg_yd_cd" style="width:65;" class="input2" readonly value="<%=cvrg_yd_cd %>"></td>
					<td class="stm">BKG Term&nbsp;<input type="text" name="dmdt_de_term_nm" style="width:65;" class="input2" readonly value="<%=dmdt_de_term_nm %>"></td></tr>
				<tr class="h23">
					<td><%if(dmdt_trf_cd.equals("DMOF")||dmdt_trf_cd.equals("DTOC")||dmdt_trf_cd.equals("CTOC")){ %>Destination<%}else{ %>Origin<%} %></td>
					<td width="110" class="stm">Continent&nbsp;<input type="text" name="org_dest_conti_cd" style="width:40;" class="input2"  readonly value="<%=org_dest_conti_cd %>"></td>
					<td width="120" class="stm">Country&nbsp;<input type="text" name="org_dest_cnt_cd" style="width:50;" class="input2"  readonly value="<%=org_dest_cnt_cd %>"></td>
					<td width="42" class="stm"><%if(org_dest_cnt_cd.equals("CA") || org_dest_cnt_cd.equals("US")){%>State<%}else{%>Region<%} %></td>
					<td width="78">&nbsp;<input type="text" name="org_dest_rgn_ste_cd" style="width:60;" class="input2" readonly ></td>
					<td width="120" class="stm">Location&nbsp;<input type="text" name="org_dest_loc_cd" style="width:60;" class="input2"  readonly value="<%=org_dest_loc_cd %>"></td>
					<td class="stm"></td></tr>
				</table>
				<!--  biz_1   (E) -->
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				<!--  biz_2   (S) -->
				<table class="search" border="0" style="width:884;"> 
				<tr class="h23">
					<td width="80">Group Name</td>
					<td>
					<%=JSPUtil.getCodeCombo("dmdt_trf_grp_tp_cd", "", "width='90' class='input1' onChange='changeGroupType(this);'", "CD01979", 0, "")%>
					<input type="text" name="dmdt_bzc_trf_grp_nm" style="width:236;" class="input1" caption="Group Name" maxlength="30" style="236;" dataformat="engup3" style="ime-mode:disabled" value="<%=dmdt_bzc_trf_grp_nm %>">
					</td></tr> 
				</table>
				<table class="search" border="0" style="width:884;"> 
				<tr class="h23">
					<td width="520">
						<table class="search" border="0"> 
							<td width="80">Effective DT</td>
							<td width="133"><input type="text" name="eff_dt" style="width:82;" class="input1" value="" maxlength="10" dataformat="ymd"  caption="Effective Date">&nbsp;<img src="img/btns_calendar.gif" id="btns_clendar1" name="btns_calendar1" width="19" height="20" alt="" border="0" align="absmiddle"></td>
							<td width="85">Expiration DT</td>
							<td width="133">&nbsp;<input type="text" name="exp_dt" style="width:82;" class="input1" value=""  maxlength="10" dataformat="ymd"  caption="Expiration Date">&nbsp;<img src="img/btns_calendar.gif" id="btns_clendar2" name="btns_calendar2" width="19" height="20" alt="" border="0" align="absmiddle"></td>
							<td width=""><input type="checkbox" name="xtn_flg" value="N" class="trans" onClick="doXtnFlg()" ><span id="wknd1">&nbsp;Extension</span></td>
						</table>
					</td>
					<td width="">
						<table id="xtn_dt_chk" class="search" border="0" style="display:none;">
							<tr class="h23"> 
								<td width="50">&nbsp;</td>
								<td width="50">EFF DT</td>
								<td width="113"><input type="text" name="xtn_eff_dt" style="width:82;" class="input2" value="" maxlength="10" dataformat="ymd"  caption="Effective Date" readOnly>&nbsp;</td>
								<td width="50">EXP DT</td>
								<td width="">&nbsp;<input type="text" name="xtn_exp_dt" style="width:82;" class="input1" value=""  maxlength="10" dataformat="ymd"  caption="Expiration Date">&nbsp;<img src="img/btns_calendar.gif" id="btns_clendar2" name="btns_calendar4" width="19" height="20" alt="" border="0" align="absmiddle"></td>
							</tr>
						</table>
					</td>
				</tr>
				</table>
				<!--  biz_2   (E) -->
				<table class="search" border="0" style="width:884;"> 
					<tr class="h23"><td class="sm">* Effective Date: Start Day of DEM/DET Incurrence&nbsp;&nbsp;  * Coverage: DEM - From Yard, DET/Combine - BKG POR or BKG DEL<br><br></td></tr>
				</table>
				
				<table class="search" border="0" style="width:884;"> 
					<tr class="h23">
						<td width="400" valign="top">
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
						<td width="84" align="center" valign="middle"><img src="img/btns_add.gif" name="btn_add" width="26" height="26" alt="" border="0" align="absmiddle" class="cursor"><br><br><br><img src="img/btns_del.gif" name="btn_del" width="26" height="26" alt="" border="0" align="absmiddle" class="cursor"></td>
						<td width="400" valign="top">
							<!-- Grid  (S) -->
							<table width="100%"  id="mainTable"> 
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('sheet2');</script>
									</td>
								</tr>
							</table>
							<!-- Grid (E) -->	
						
					</td></tr>
				</table>
				
				<table class="height_5"><tr><td></td></tr></table>
				
				<table class="search" border="0" style="width:884;"> 
				<tr class="h23">
					<td width="284" valign="top">
					<!-- biz_3 (S) -->
					<table class="search" border="0"> 
						<tr class="h23">
							<td width="110">&nbsp;F/Time Exclusion</td>
							<td class="stm"><input type="checkbox" name="xcld_sat_flg" value="Y" class="trans"><span id="wknd1">SAT</span>&nbsp;<input type="checkbox" name="xcld_sun_flg" value="Y"  class="trans"><span id="wknd2">SUN</span>&nbsp;<input type="checkbox" name="xcld_hol_flg" value="Y" class="trans">HOLIDAY</td>
						</tr>
					</table>
					<!-- Grid  (S) -->
					<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet3');</script>
							</td>
						</tr>
					</table>
					<!-- Grid (E) -->	
					<!--  Button_Sub (S) -->
					<table width="100%" class="button"> 
	       			<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_rowadd">Row&nbsp;Add</td>
							<td class="btn2_right"></td></tr>
							</table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_rowdelete">Row&nbsp;Delete</td>
							<td class="btn2_right"></td></tr>
							</table></td>
					</tr></table>
					</td></tr>
					</table>
	    			<!-- Button_Sub (E) -->
					<!-- biz_3 (E) -->
					</td>
					<td width="19"></td>
					<td width="600" valign="top">
					<!-- biz_4 (S) -->
					<table class="search" border="0"> 
						<tr class="h23">
							<td width="120">F/Time Commence</td>
							<td class="stm" width="250">
							<%=JSPUtil.getCodeCombo("dmdt_chg_cmnc_tp_cd","", "width='90' class='input1' onChange='changeGroupCd1(this);'", "CD01964", 0, "")%>
							&nbsp;<input type="text" name="cmnc_hr" style="width:30;" maxlength="2" class="input" onChange="changeCmncHr();" >&nbsp;HR</td>
							<td width="60">Currency</td>
							<td>
							
							<select name="currency" style="width:80;" class="input1">&nbsp;
							</select>
							</td>
						</tr>
					</table>
					<!-- Grid  (S) -->
					<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet4');</script>
							</td>
						</tr>
					</table>
					<!-- Grid (E) -->	
					<!--  Button_Sub (S) -->
					<table width="100%" class="button"> 
	       			<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_rowadd2">Row&nbsp;Add</td>
							<td class="btn2_right"></td></tr>
							</table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_rowdelete2">Row&nbsp;Delete</td>
							<td class="btn2_right"></td></tr>
							</table></td>
					</tr></table>
					</td></tr>
					</table>
	    			<!-- Button_Sub (E) -->
					<!-- biz_4 (E) -->
					
					
					
					</td></tr>
			</table>
				
				
				
				
				
				
				
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
<table class="height_5"><tr><td></td></tr></table>
</td></tr>
</table> 


	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right">
				</tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_next">Next</td>
					<td class="btn1_right">
				</tr></table></td>
				<td class="btn1_line">
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right">
				</tr></table></td>
				
			</tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
</td></tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
