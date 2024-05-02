<%
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VOP_OPF_0047.jsp
*@FileTitle : RDR Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.21
*@LastModifier : 임옥영
*@LastVersion : 1.0
* 2010.03.03 임옥영
* 1.0 Creation
* ---------------------------------------------------------------
* History
* 2013.11.21 임옥영 [CHM-201327237] [VOP-OPF] RDR Summary 메뉴 추가 
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.event.VopOpf0047Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopOpf0047Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd = "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.CargoLoadingResultMgt.RegionDepartureReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (VopOpf0047Event)request.getAttribute("Event");
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
<title>RDR Summary</title  >
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	var frDt = ComGetDateAdd('<%=JSPUtil.getKST("yyyy-MM-dd")%>', "M", -3);
	var toDt = "<%=JSPUtil.getKST("yyyy-MM-dd")%>";
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
<input type="hidden" name="ofc_cd" value="<%=strOfc_cd%>">
<input type="hidden" size="200" name="skd_voy_no" value="">
<input type="hidden" size="200" name="skd_dir_cd" value="">
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
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="60">VVD CD</td>
					<td width="290"><input type="text" name="vsl_cd" caption="VVD CD" style="width:40;ime-mode:disabled;" class="input" maxLength="4" required>&nbsp;<input type="text" name="voy_no" caption="VVD CD" style="width:40;ime-mode:disabled;" class="input" maxLength="4" required>&nbsp;<input type="text" name="dir_cd" caption="VVD CD" style="width:20;ime-mode:disabled;" class="input" maxLength="1" required>&nbsp;<img src="img/btns_search.gif" name="vsl_cd_pop" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">&nbsp;<input name="vsl_eng_nm" type="text" style="width:130;" class="input2" value="" readonly></td>
					<td width="60">Region</td>
					<td width="140"><script language="javascript">ComComboObject('region',2,120,0,0,1);</script></td>
					<td width="60">&nbsp;</td>
					<td width="60">Week</td>
					<td width="210"><input type="text" name="fr_week_no" style="width:60;ime-mode:disabled; text-align:center;" class="input" dataformat="yw" maxlength="6" caption="From Week">&nbsp;~&nbsp;<input type="text" name="to_week_no" style="width:60;ime-mode:disabled; text-align:center;" class="input" dataformat="yw" maxlength="6" caption="To Week"></td>
					<td>&nbsp;</td>
				</tr>	
				<TR class="h23">
					<td width="60">Lane</td>
					<td width="290"><input name="slan_cd" type="text" style="width:40;" class="input" value=""  dataformat="engup" maxlength="3" caption="Lane" fullfill>&nbsp;<img src="img/btns_search.gif" name="btns_slan" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">&nbsp;<input name="slan_nm" type="text" style="width:198;" class="input2" value="" readOnly></td>
					<td width="60">&nbsp;</td>
					<td width="140">&nbsp;</td>
					<td width="60">&nbsp;</td>
					<td width="60">Duration</td>
					<td width="210"><input type="text" name="fr_dt" style="width:80; text-align:center;" class="input" dataformat="ymd" maxlength="8" caption="From Date">&nbsp;~&nbsp;<input type="text" name="to_dt" style="width:80; text-align:center;" class="input" dataformat="ymd" maxlength="8" caption="To Date">&nbsp;<img src="img/btns_calendar.gif" id="btns_period" name="btns_period" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
					<td>&nbsp;</td>
				</TR>
				</table>
	<!--  biz_1   (E) -->			
			</td>
			</tr>	
			</table>
				
				
		
		<table class="height_10"><tr><td colspan="8"></td></tr></table>
		
		<!-- Grid BG Box  (S) -->
     	<table width="100%"  class="search"> 
       	<tr><td class="bg">
				<!-- Grid (S) -->
				<table width="100%" id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) -->
	</td></tr>
	</table>
	<!-- Grid BG Box  (S) -->
	
	
	<!--biz page (E)-->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;display:inline;" id="btnTblRDR">
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new" id="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name=btn_downexcel>Down Excel</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	</td></tr>
</table>
	
	</td></tr>
	</table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html></body>