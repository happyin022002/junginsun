<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_opf_0056.jsp
*@FileTitle : SDMS Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.01
*@LastModifier : 이선영
*@LastVersion : 1.0
* 2009.07.01 이선영
* 1.0 Creation
2011.04.01 공창식 [CHM-201109535-01] SDMS Damage Creation 변경 요청사항
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.event.VopOpf0056Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.Date"%>

<%
	VopOpf0056Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.StevedoreDamageMgt.StevedoreDamageMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopOpf0056Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>SDMS Report</title>
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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->
	
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="93">Period</td>
					<td class="sm" width="340">From&nbsp;<input type="text" name="stv_dmg_evnt_dt_from" caption="Period From" style="width:80;" class="input1" value="<%=DateTime.addDays(DateTime.getFormatDate(new Date(),"yyyyMMdd"),-30)%>" dataformat="ymd" maxlength="8" required>&nbsp;&nbsp;~&nbsp;&nbsp;To&nbsp;<input type="text" name="stv_dmg_evnt_dt_to" caption="Period To" style="width:80;" class="input1" value="<%=DateTime.getFormatDate(new Date(),"yyyyMMdd")%>" dataformat="ymd" maxlength="8" required>&nbsp;<img src="img/btns_calendar.gif" name="cal_stv_dmg_evnt_dt_to" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"><input type="text" style="width:0;" name="noname"></td>
					<td width="105">Vessel Category</td>
					<td width="210"><script language="javascript">ComComboObject('vsl_oshp_cntr_blk_tp_cd',1,160,1,0,1);</script></td>
					<td width="60">Group By</td>
					<td align="right">
						<script language="javascript">ComComboObject('group_by',1,165,1,0,1);</script>
					</td>
				</tr> 
				</table>				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="118">Country</td>
					<td width="194"><input type="text" name="loc_cd" caption="Country Code" style="width:96;ime-mode:disabled;" class="input" maxlength="2" fullfill>&nbsp;<img src="img/btns_search.gif" name="loc_cd_pop" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
					<td width="35">Port</td>
					<td width="190"><input type="text" name="vps_port_cd" caption="Port Code" style="width:96;ime-mode:disabled;" class="input" maxlength="5" fullfill>&nbsp;<img src="img/btns_search.gif" name="vps_port_cd_pop" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
					<td width="40">Lane</td>
					<td width="170"><input type="text" name="slan_cd" caption="Lane Code" style="width:96;ime-mode:disabled;" class="input" maxlength="3" fullfill>&nbsp;<img src="img/btns_search.gif" name="slan_cd_pop" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
					<td width="65">Vessel</td>
					<td><input type="text" name="vsl_cd" caption="Vessel Code" style="width:96;ime-mode:disabled;" class="input" maxlength="4" fullfill>&nbsp;<img src="img/btns_search.gif" name="vsl_cd_pop" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				</tr> 
				</table>

				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="120">Damage Category</td>
					<td width="192"><script language="javascript">ComComboObject('stv_dmg_prt_cate_cd',1,120,0,0,1);</script></td>
					<td width="90">Damage Part</td>
					<td width="345"><script language="javascript">ComComboObject('stv_dmg_prt_cd',2,296,0,0,1);</script></td>
					<td width="90">Damage Type</td>
					<td><script language="javascript">ComComboObject('stv_dmg_tp_cd',2,142,0,0,1);</script></td>
				</tr> 
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="120">Responsible Party</td>
					<td width="123">
						<script language="javascript">ComComboObject('stv_dmg_respb_pty_kwn_cd',1,96,0,0,1);</script>
					</td>
					<td width="55">Damage</td>
					<td width="123">
						<script language="javascript">ComComboObject('stv_dmg_step_cd',1,96,0,0,1);</script>
					</td>
					<td width="45">Repair</td>
					<td width="123">
						<script language="javascript">ComComboObject('stv_dmg_rpr_proc_sts_cd',1,96,0,0,1);</script>
					</td>
					<td width="95">Compensation</td>
					<td width="123">
						<script language="javascript">ComComboObject('stv_dmg_cmpn_proc_sts_cd',1,96,0,0,1);</script>
					</td>
					<td width="75">Settlement</td>
					<td align="right">
						<script language="javascript">ComComboObject('stv_dmg_stl_proc_sts_cd',1,96,0,0,1);</script>
					</td>
				</tr> 
				</table>				
				<!--  biz_1   (E) -->
			
		</td></tr></table>
		<table class="height_8"><tr><td></td></tr></table>	

		<!-- Tab (S) -->
	 		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%>
	   		<tr><td width="100%">
					<script language="javascript">ComTabObject('tab1')</script>
				</td></tr>
			</table>
		<!-- Tab (E) -->

<!-- TAB [ Performance ] (S) -->
<div id="tabLayer" style="display:inline">

		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
			
					<!-- Grid  (S) -->
						<table width="100%"  id="mainTable">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table>
					<!-- Grid (E) -->			
			
			
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_t1DownExcel">Down Excel</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
						
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			
			
			</td></tr>
		</table>
		<!--biz page (E)-->

</div>		
<!-- TAB [ Performance ] (E) -->


<!-- TAB [ Damage ] (S) -->
<div id="tabLayer" style="display:none">

		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
			
					<!-- Grid  (S) -->
						<table width="100%"  id="mainTable">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet2');</script>
								</td>
							</tr>
						</table>
					<!-- Grid (E) -->			
			
			
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_t2DownExcel">Down Excel</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
						
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			
			
			</td></tr>
		</table>
		<!--biz page (E)-->

</div>		
<!-- TAB [ Damage ] (E) -->


<!-- TAB [ Repair ] (S) -->
<div id="tabLayer" style="display:none">

		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
			
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
				<tr>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_t3DownExcel">Down Excel</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
						
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			
			
			</td></tr>
		</table>
		<!--biz page (E)-->

</div>		
<!-- TAB [ Repair ] (E) -->


<!-- TAB [ Compensation ] (S) -->
<div id="tabLayer" style="display:none">

		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
			
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
				<tr>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_t4DownExcel">Down Excel</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
						
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			
			
			</td></tr>
		</table>
		<!--biz page (E)-->

</div>		
<!-- TAB [ Compensation ] (E) -->


<!-- TAB [ Settlement ] (S) -->
<div id="tabLayer" style="display:none">

		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
			
					<!-- Grid  (S) -->
						<table width="100%"  id="mainTable">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet5');</script>
								</td>
							</tr>
						</table>
					<!-- Grid (E) -->			
			
			
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_t5DownExcel">Down Excel</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
						
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			
			
			</td></tr>
		</table>
		<!--biz page (E)-->

</div>		
<!-- TAB [ Settlement ] (E) -->


		<!-- Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
			    <table border="0" cellpadding="0" cellspacing="0">
			    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_New">New</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
				</tr>
				</table>
			</td></tr>
			</table>
			<!-- Button (E) -->
	
	
	</td></tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>