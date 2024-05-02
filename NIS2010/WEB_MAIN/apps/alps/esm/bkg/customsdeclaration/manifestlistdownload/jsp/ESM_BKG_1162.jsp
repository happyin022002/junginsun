<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1162.jsp
*@FileTitle : ESM_BKG_1162
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.04
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2013.07.04 경종윤
* 1.0 Creation
*--------------------------------------------------------
* history
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.dominican.event.EsmBkg1162Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1162Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");
	//String whereGubun = request.getParameter("pgmNo");
	String whereGubun = "ESM_BKG_1162";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg1162Event)request.getAttribute("Event");
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
<title>ESM_BKG_1162</title>
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
<input type="hidden" name="in_list_type">
<input type="hidden" name="in_cntr_match">
<input type="hidden" name="in_pol_ts">
<input type="hidden" name="in_pod_ts">
<input type="hidden" name="in_cntr_cfm_flg">
<input type="hidden" name="in_bkg_cgo_tp_cd_temp">

<input type="hidden" name="vvd_nkm">
<input type="hidden" name="un_loc_cd">
<input type="hidden" name="vps_eta_dt">
<input type="hidden" name="vps_etd_dt">
<input type="hidden" name="vps_etb_dt">
<input type="hidden" name="in_order_by_type">
<input type="hidden" name="in_ofc_cd_type">
<input type="hidden" name="in_including_type">
<input type="hidden" name="key">
<input type="hidden" name="fax">
<input type="hidden" name="email">
<input type="hidden" name="vessel_name">

<input type="hidden" size="200" name="com_mrdPath" value="apps/alps/esm/bkg/customsdeclaration/customsreport/report/ESM_BKG_0783.mrd">
<input type="hidden" size="200" name="com_mrdArguments" value="">
<input type="hidden" size="200" name="com_mrdTitle" value="Container Loading/Discharging List_Print">
<input type="hidden" size="200" name="com_mrdBodyTitle" value="<span style=&quot;color:red&quot;>Container Loading/Discharging List_Print</span>">
<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--top menu (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			class="title">
			<tr>
				<td class="history"><img src="img/icon_history_dot.gif"
					align="absmiddle"><span id="navigation"></span></td>
			</tr>
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif"
					align="absmiddle"><span id="title"></span></td>
			</tr>
		</table>
	
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">

				
				
				
				<!--  biz_2  (S) -->
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="820">
					<table style="width:100%;" border="0">
					<tr class="h23">
						<td width="35">&nbsp;VVD</td>
						<td width="100"><input type="text" style="width:80;" name="vvd" class="input1" value="" required fullfill maxlength="9" dataformat="uppernum" caption="VVD" style="ime-mode:disabled"></td>
						<td width="30">POD</td>
						<td width="95"><input type="text" id="pod_cd" style="width:50;" class="input1" name="pod_cd" value="" dataformat="upper" style="ime-mode:disabled" caption="POD" fullfill maxlength="5">&nbsp</td>
						<td width="">&nbsp;</td>
					</tr>
					</table>
				</td>
				<td width="" valign="baseline">
					
				<table class="search" border="0"><tr><td class="height_8"></td></tr></table>
			</td></tr></table>
			
				
	
			<table class="line_bluedot"><tr><td></td></tr></table>
		
		
				
			
				<!-- Grid  (S) -->
					<table width="100%"  id="mainTable">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
					
					<table width="100%"  id="mainTable2" style="display:none">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet2');</script>
							</td>
						</tr>
					</table>	
					
					<table width="100%"  id="mainTable2" style="display:none">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet3');</script>
							</td>
						</tr>
					</table>	
			<!-- Grid (E) -->
			
			<table class="height_10"><tr><td colspan="8"></td></tr></table>
			
		</td></tr>
	</table>	
			</td></tr>
		</table>
	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->
	
	</td></tr>
		</table>
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downExcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downXML">Down XML</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>				
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
</form>
</body>
</html>