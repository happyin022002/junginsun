<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_spc_0116.jsp
*@FileTitle : Compulsory Firm
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.02
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2015.02.02 김성욱
* 1.0 Creation

* 2015.06.26 Title/Navigation, 디자인 변경
* 2015.07.30 create Date 기준 SB BKG조회조건 추가
* 2015.08.17 CHM-201537550 SB BKG management 및 Control Option Registration 보완 요청(7.30내용 포함)
* 2015.08.24 이혜민 standby booking management에서 reprocess시 같은 조건으로 수행중일때 동일 reprocess 못하도록 alert 띄워줌.
* 2016.01.07 week 추가, SC/RFA 검색조건 추가, RPT Form 에 항목4개 추가
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.event.EsmSpc0116Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hanjin.apps.alps.esm.bkg.common.*" %>
<%@ page import="com.hanjin.framework.core.controller.DefaultViewAdapter"%>
<%@ page import="com.hanjin.apps.alps.esm.coa.common.Utils"%>

<%
	EsmSpc0116Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String sXml      = "";	
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc_cd   	= "";
	String StrRhq_ofc_cd    = "";

	String isAdmin     = "";
	String rhq_cd      = "";
	String rgn_ofc_cd  = "";
	String level = "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.esm.spc.basicdatamanage");

	String vvd = (request.getParameter("vvd_no") == null)? ""  : request.getParameter("vvd_no");
	String orgOfc = (request.getParameter("origin") == null)? ""  : request.getParameter("origin"); //이전 화면에 setting된 origin office 
	String polCd = (request.getParameter("pol_cd") == null)? ""  : request.getParameter("pol_cd"); //이전 화면에 setting된 origin office 
	String podCd = (request.getParameter("pod_cd") == null)? ""  : request.getParameter("pod_cd"); //이전 화면에 setting된 origin office 
	String ofcVw = (request.getParameter("ofc_vw") == null)? ""  : request.getParameter("ofc_vw"); //이전 화면에 setting된 origin office 
	String custCtrlCd = (request.getParameter("cust_ctrl_cd") == null)? ""  : request.getParameter("cust_ctrl_cd"); //이전 화면에 setting된 origin office 
	String trade = (request.getParameter("trade") == null)? ""  : request.getParameter("trade"); //이전 화면에 setting된 origin office 
	String rlaneCd = (request.getParameter("rlane_cd") == null)? ""  : request.getParameter("rlane_cd"); //이전 화면에 setting된 origin office 
	String usMod = (request.getParameter("usa_bkg_mod_cd") == null)? ""  : request.getParameter("usa_bkg_mod_cd"); //이전 화면에 setting된 origin office 
	String iocCd = (request.getParameter("ioc_cd") == null)? ""  : request.getParameter("ioc_cd"); //이전 화면에 setting된 origin office 
	String fAcctCd = (request.getParameter("acct_cd") == null)? ""  : request.getParameter("acct_cd");  
	String menu = (request.getParameter("MENU") == null)? ""  : request.getParameter("MENU");  
	//vvd = "HSJU0006E";
    //String ofc_cd = orgOfc ; //"NKGSC"
	
	//report관련 소스추가
	String col_desc="";
	String col_nm="";
	String selGroup = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id     =	account.getUsr_id();
		strUsr_nm     = account.getUsr_nm();
		strUsr_ofc_cd = account.getOfc_cd();
		StrRhq_ofc_cd = account.getRhq_ofc_cd();
		
		event = (EsmSpc0116Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		//report관련 소스추가
		col_desc = Utils.iif(request.getParameter("col_desc")==null, "", request.getParameter("col_desc"));
	    col_nm   = Utils.iif(request.getParameter("col_nm")==null, "", request.getParameter("col_nm"));
	    selGroup = "";
	    
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		DefaultViewAdapter adapter = new DefaultViewAdapter();
		sXml = adapter.makeXML(request, response);		
		
		
		if (serverException == null) {
			// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
			isAdmin    = eventResponse.getETCData("adm");
			rhq_cd     = eventResponse.getETCData("rhq_cd");
			rgn_ofc_cd = eventResponse.getETCData("rgn_ofc_cd");
			if(eventResponse.getETCData("rgn_ofc_cd").equals("")) strUsr_ofc_cd = eventResponse.getETCData("ofc_cd") ;
		}
		
	    
	    if (isAdmin.equals("Y"))       level="1";
	    else if(!rgn_ofc_cd.equals(""))level="3";
	    else if(!rhq_cd.equals(""))    level="2";
	    
	}catch(Exception e) {
		out.println(e.toString());
	}

%>
<html>
<head>
<title>Compulsory Firm</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	var isWindow="<%=menu%>";
	
	function setupPage(){
		var errMessage = '<%=strErrMsg%>';
		
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		
		//Rpt form용
		var col_desc = document.form.f_header.value;
        var col_nm = document.form.f_headernm.value;      
		loadPage();
	}
</script>
</head>
<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="sXml" value ="<%=sXml%>">
<input type="hidden" name="f_ofc_cd" value = "<%=strUsr_ofc_cd%>"> <!-- usr_ofc_cd -->
<input type="hidden" name="f_rhq_cd" value = "<%=StrRhq_ofc_cd%>"> <!-- rhq_ofc_cd -->
<input type="hidden" name="f_org_ofc_cd" id="org_ofc_cd" value = "<%=orgOfc%>"><!-- org_ofc_cd -->
<input type="hidden" name="f_bkg_pol_cd" id="f_pol_cd" value = "<%=polCd%>"><!-- org_ofc_cd -->
<input type="hidden" name="f_bkg_pod_cd" id="f_pod_cd" value = "<%=podCd%>"><!-- org_ofc_cd -->
<input type="hidden" name="f_ofc_vw" id="f_ofc_vw" value = "<%=ofcVw%>"><!-- org_ofc_cd -->
<input type="hidden" name="f_cust_tp" id="f_cust_tp" value = "<%=custCtrlCd%>"><!-- org_ofc_cd -->
<input type="hidden" name="f_h_trd_cd" id="f_h_trd_cd" value = "<%=trade%>"><!-- org_ofc_cd -->
<input type="hidden" name="f_h_rlane_cd" id="f_h_rlane_cd" value = "<%=rlaneCd%>"><!-- org_ofc_cd -->
<input type="hidden" name="f_usa_bkg_mod_cd" id="f_usa_bkg_mod_cd" value = "<%=usMod%>"><!-- org_ofc_cd -->
<input type="hidden" name="f_h_ioc_cd" id="f_h_ioc_cd" value = "<%=iocCd%>"><!-- org_ofc_cd -->
<input type="hidden" name="f_acct_cd" id="f_acct_cd" value = "<%=fAcctCd%>"><!-- f_acct_cd -->

<!-- RPT Form 용 -->
<input type="hidden" name="f_header" id="f_header"  value="<%=col_nm%>">
<input type="hidden" name="f_headernm" id="f_headernm" value="<%=col_desc%>">
<input type="hidden" name="pgm" id="pgm">
<input type="hidden" name="rpt_fom_nm" id="rpt_fom_nm"><!-- 선택한 Combo 의 Text 를 저장 -->
<input type="hidden" name="f_savename" id="f_savename">
<input type="hidden" name="f_level"  id="f_level" value="<%= level %>">
<input type="hidden" name="backendJobKey"  id="backendJobKey" >



<!-- 개발자 작업	-->
<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>

	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history" id="naviTxt"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->
		</td></tr>
		<tr><td height="5px"></td></tr>
		<tr><td>	
	<!-- TABLE '#D' : ( Search Options) (S) -->
		<table class="search"> 
       		<tr>
       		<td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" width="100%">
					<tr class="h23">
						<td width="100"><img class="nostar" id="id_aloc_sts_cd">BKG Status<!-- Standby Status 의 이름이 바뀜 --></td>
						<td>&nbsp;<script language="javascript" >ComComboObject('f_aloc_sts_cd', 2, 60, 1, 0, 2);</script></td><!-- aloc_sts_cd -->
						<td width="100"><img class="nostar">Standby Type</td>
						<td><img src="img/tm.gif" style="width:2"/><script language="javascript" >ComComboObject('f_sb_rsn_tp_cd', 2, 60, 1, 0, 2)</script>
						<!-- select name="f_sb_rsn_tp_cd" style="width:60px;"></select -->
						</td>	<!-- lst_sb_rsn_tp_cd -->
						<td width="50"><img class="nostar">L.OFC</td><!-- ob_sls_ofc_cd -->
						<td width="80"><input type="text"  name="f_sls_ofc_cd"  style="width:80" class="input" maxlength=6 dataformat="engup" style="ime-mode:disabled"></td>
						<td  width="50"><img class="nostar">C.OFC</td><!-- ctrt_ofc_cd -->
						<td><input type="text"  name="f_ctrt_ofc_cd"  style="width:80" class="input" maxlength=6 dataformat="engup" style="ime-mode:disabled"></td>
						<td width="60"><img class="nostar">BKG No</td>
						<td width="80"><input class="input1" type="text" style="width:100;ime-mode:disabled;" class="input" name="f_bkg_no" dataformat="engupnum" maxlength="13" ></td>
						<td><img class="nostar">SC/RFA</td>
						<td>&nbsp;<script language="javascript" >ComComboObject('f_bkg_ctrt_tp_cd', 1, 50, 1, 0);</script></td><!-- aloc_sts_cd -->
						<td > 	<input type="text"  name="f_ctrt_no"  style="width:80;" class="input1" maxlength=20 dataformat="engupnum" style="ime-mode:disabled"></td>
					</tr> 

					<tr class="h23">
						<td ><img class="nostar">Start Week</td>
						<td width="120" style="padding-left:1">
							<select class="input1" name="f_year" style="width:60;" onchange="checkWeek();"></select><!-- year -->
							<select class="input1" name="f_week" style="width:40;"></select><!-- week -->
						</td>
						<td><img class="nostar">Duration</td>
						<td>
							<select class="input1" name="f_duration" size="1" style="width:60px;"><!-- duration -->
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5" selected>5</option>
								<option value="6">6</option>
								<option value="7">7</option>
								<option value="8">8</option>
								<option value="9">9</option>
								<option value="10">10</option>
								<option value="11">11</option>
								<option value="12">12</option>
							</select>
						</td>	
						<td><img class="nostar">Lane</td>
						<td><img src="img/tm.gif" style="width:2"/><script language="JavaScript">ComComboObject('f_rlane_cd', 4, 80, 0, 0)</script></td>						
						<td><img class="nostar">BKG Date</td>
						<td colspan="6">
						  <input type="text" style="width:80" value="" class="input1"  name="f_sdate"  maxlength='10' dataformat="ymd" >
						 &nbsp;~&nbsp;
						  <input type="text" style="width:80" value="" class="input1"  name="f_edate"  maxlength='10' dataformat="ymd" >
						  <img class="cursor" src="img/btns_calendar.gif"  height="20" border="0" align="absmiddle" name="btns_calendar">
						  (Limit:7days)
						</td>
					</tr>
					
					<tr class="h23">
						<td><img class="nostar">Rep.Trade</td>
						<td>&nbsp;<script language="JavaScript">ComComboObject('f_trd_cd', 2, 60, 1, 1, 2)</script></td>
						<td><img class="nostar">Sub Trade</td>
						<td><img src="img/tm.gif" style="width:2"/><script language="JavaScript">ComComboObject("f_sub_trd_cd", 3, 60, 0, 1);</script></td>
						<td ><img class="nostar">VVD</td><!-- bkg_vvd_cd -->
						<td width="95"><input type="text" name="f_vvd_cd" class="input1" style="width:80" value="<%=vvd%>" maxlength=9 dataformat="engupnum" style="ime-mode:disabled" ></td>
						<td colspan="2"><input type="checkbox" value="Y" class="trans" name="f_chk_dummy" id="f_chk_dummy">Include Dummy VVD</td>
						<td colspan="3">
							<table class="search" >
							    <tr class="h23">
									<td width="55"><img class="nostar">Bound</td>
									<td><img src="img/tm.gif" style="width:2"/><select name="f_dir_cd" style="width:50;" class="input1"></select></td>
									<td width="40"><img class="nostar">Haul</td>
									<td width="85"><select class="input1" name="f_hul_bnd_cd" size="1" style="width:50px;">
									        <option value=""></option>
											<option value="HH">HH</option>
											<option value="BH">BH</option>
									</select></td>							    	
							    </tr>
							</table>
						</td>	

					</tr>
					
				</table>
			</td>
		</tr>	
	</table>	
				<!--  biz_1   (E) -->
	
				
	<table class="height_10"><tr><td></td></tr></table>
	<table class="search">
       	<tr><td class="bg">
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="50%">
							Select Customized RPT Form&nbsp;
							<script language="javascript">ComComboObject('f_selgroup',1, 150 , 0 )</script>
						</td>
						<td width="50%" style="text-align:right; ">
							<img class="cursor" src="/hanjin/img/alps/ico_newwin.gif" width="11" height="12" align="absmiddle" hspace="5">
					        <a href="javascript:openRPTFormPopUp();" class="purple">Set Customized RPT Form</a><span id="selected_rpt_form"></span>
						</td>
					</tr>
					<tr>
						<td width="100%" colspan="2">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) -->	
			</td>
			</tr>
		</table>
		
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;"> 
      	 	<tr>
      	 	
      	 	<td style="font-family: Arial; font-size: 9px;">
※Initial CMPB : Criteria CMPB is used for changing BKG's status to Standby<br>
※ Estimated CMPB : The primary CMPB when BKG is created and afterward, can be recalculated when only Revenue factors such as RFA/SC changed.<br>
※ MAS CMPB : CMPB calucated by MAS Logic when Revenue & Cost factors are changed.<br>
※ Estimated CMPB = <b>Valid Rate in Contract</b> +Cost as per COP<br>
※ MAS CMPB = Revenue(Auto rating or Avg Rev) + Cost as per COP<br>
※ Initial CMPB : Same with Estimated CMPB or MAS CMPB<br>
			</td>
      	 	<td width="600" class="btn1_bg" valign='top'>
			    <table border="0" cellpadding="0" cellspacing="0">
				    <tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_BranchSave" id="btn_BranchSave">B.Check Save</td>
							<td class="btn1_right"></td>
							</tr>
							</table>
						</td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_Reprocess" id="btn_Reprocess">Reprocess</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>						
						<td id="btn_StandbyToFirm">
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="StandbyToFrim">
								<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn_StandbyToFirm">Standby&nbsp;->&nbsp;Firm</td>
									<td class="btn1_right"></td>
								</tr>
							</table>	
						</td> 
						<td class="btn1_line"></td>
						<td></td>
						<td></td>
						<td></td> 
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>						
						<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_New">New</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
						<td id="btn_FirmToStandby"></td> 
					</tr>
				</table>
			</td></tr>
		</table>
    <!--Button (E) -->
	</td></tr>
</table>
<!-- Grid BG Box  (S) -->
<!--biz page (E)-->
<!-- <table class="height_10"><tr><td colspan="8"></td></tr></table>  -->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
