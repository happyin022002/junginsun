<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_spc_0123.jsp
*@FileTitle : Standby BKG Report
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.23
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2015.07.23 김성욱
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
<%@ page import="com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.event.EsmSpc0123Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hanjin.apps.alps.esm.bkg.common.*" %>
<%@ page import="com.hanjin.framework.core.controller.DefaultViewAdapter"%>
<%@ page import="com.hanjin.apps.alps.esm.coa.common.Utils"%>

<%
	EsmSpc0123Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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
		
		event = (EsmSpc0123Event)request.getAttribute("Event");
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


<!-- 개발자 작업	-->
<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>

	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->
	
	<!-- TABLE '#D' : ( Search Options) (S) -->
		<table class="search"> 
		<tr><td style="height:2px">&nbsp;</td></tr>
       		<tr>
       		<td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;">
					<tr class="h23">
						<td><img class="nostar" id="id_aloc_sts_cd">BKG Status<!-- Standby Status 의 이름이 바뀜 --></td>
						<td>&nbsp;<script language="javascript" >ComComboObject('f_aloc_sts_cd', 2, 60, 1, 0, 2)</script></td><!-- aloc_sts_cd -->
						<td><img class="nostar">Standby Type</td>
						<td><img src="img/tm.gif" style="width:2"/><select name="f_sb_rsn_tp_cd" style="width:60px;" onchange="f_sb_rsn_tp_cd_OnChange()"></select></td>	<!-- lst_sb_rsn_tp_cd -->
						<td><img class="nostar">L.OFC</td><!-- ob_sls_ofc_cd -->
						<td><input type="text"  name="f_sls_ofc_cd" style="width:80;" class="input" maxlength=6 dataformat="engup" style="ime-mode:disabled"></td>
						<td><img class="nostar">BKG NO</td>
						<td colspan="3"><input class="input1" type="text" style="width:94; ime-mode:disabled;" class="input" name="f_bkg_no" dataformat="engupnum" maxlength="13" ></td>
						<td>&nbsp;</td>				
					</tr> 
					<!-- tr>
					<td colspan="12">
						<table class="line_bluedot"><tr><td></td></tr></table>	
					</td>
					</tr -->
					<tr class="h23">
						<td width="85"><img class="nostar">Start Week</td>
						<td width="130" style="padding-left:1">
							<select class="input1" name="f_year" style="width:60;" onchange="checkWeek();"></select><!-- year -->
							<select class="input1" name="f_week" style="width:40;"></select><!-- week -->
						</td>
						<td width="100"><img class="nostar">Duration</td>
						<td width="85">
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
						<td width="55"><img class="nostar">VVD</td><!-- bkg_vvd_cd -->
						<td width="105"><input type="text" name="f_vvd_cd" class="input1" style="width:80" value="<%=vvd%>" maxlength=9 dataformat="engupnum" style="ime-mode:disabled" ></td>
						<td width="80"><img class="nostar">BKG Date</td>
						<td colspan="3">
							<input class="input1" type="text" style="width:72;ime-mode:disabled;" value="" name="f_sdate" maxlength="8" onkeypress="checkDateFormat();" onfocus="initDate();" onchange="checkDate_0116();" onblur="convertDateFnc();checkDate_0116();">&nbsp;<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" name="btns_calendar1" align="absmiddle">
							~
							<input class="input1" type="text" style="width:72;ime-mode:disabled;" value="" name="f_edate" maxlength="8" onkeypress="checkDateFormat();" onfocus="initDate();" onchange="checkDate_0116();" onblur="convertDateFnc();checkDate_0116();">&nbsp;<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" name="btns_calendar2" align="absmiddle">
						</td>
						<td>&nbsp;</td>	
					</tr>
					<tr class="h23">
						<td><img class="nostar">Rep.Trade</td>
						<td>&nbsp;<script language="JavaScript">ComComboObject('f_trd_cd', 2, 60, 1, 1, 2)</script></td>
						<td><img class="nostar">Sub Trade</td>
						<td><img src="img/tm.gif" style="width:2"/><script language="JavaScript">ComComboObject("f_sub_trd_cd", 3, 60, 0, 1);</script></td>
						<td><img class="nostar">Lane</td>
						<td><img src="img/tm.gif" style="width:2"/><script language="JavaScript">ComComboObject('f_rlane_cd', 4, 80, 0, 0)</script></td>
						<td><img class="nostar">Bound</td>
						<td width="92"><img src="img/tm.gif" style="width:2"/><select name="f_dir_cd" style="width:50;" class="input1"></select></td>
						<td width="90"><img class="nostar">Haul Bound</td>
						<td width="80"><select class="input1" name="f_hul_bnd_cd" size="1">
						        <option value=""></option>
								<option value="1">HH</option>
								<option value="2">BH</option>
						</select></td>
						<td>&nbsp;</td>	
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
      	 	<tr><td class="btn1_bg">
			    <table border="0" cellpadding="0" cellspacing="0">
				    <tr>
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
<table class="height_10"><tr><td colspan="8"></td></tr></table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
