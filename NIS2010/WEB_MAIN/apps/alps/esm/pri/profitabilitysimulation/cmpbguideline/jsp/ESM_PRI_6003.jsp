<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_6003.jsp
*@FileTitle : CMPB Guideline Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.29
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.06.30 이승준
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
<%@ page import="com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmpbguideline.event.EsmPri6003Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri6003Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_office_cd = "";
	Logger log = Logger.getLogger("com.hanjin.apps.ProfitabilitySimulation.CMPBGuideline");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_office_cd =	account.getOfc_cd();

		event = (EsmPri6003Event)request.getAttribute("Event");
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
<title>CMPB Guideline Creation</title>
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

<body  onLoad="setupPage();" onResize="sheetColResize();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input name="cd" type="hidden" value="">
<input name="etc1" type="hidden" value="">
<input name="etc2" type="hidden" value="">
<input name="etc3" type="hidden" value="">
<input name="etc4" type="hidden" value="">
<input name="etc5" type="hidden" value="">

<!-- dt combo select 여부 -->
<input type="hidden" name="exp_dt_hidden_select" value="">
<!-- vsl_slan_cd sql in param -->
<input type="hidden" name="vsl_slan_cd" value="">
<!-- 키값이 아닌 조회조건의 수 -->
<input type="hidden" name="search_count" value="">

<input type="hidden" name="cre_ofc_cd" value="">
<input type="hidden" name="gline_seq" value="">
<input type="hidden" name="prs_cust_tp_cd" value="">
<!-- BASE SEQ -->
<input type="hidden" name="bse_seq" value="">
<!-- PER TYPE 조회시 MAPPING PARAM -->
<input type="hidden" name="rat_ut_cd" value="">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	
	
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	</table>
	
	<!-- Hidden sheet for Transaction (S) -->
		<script language="javascript">ComSheetObject('sheet0');</script>
	<!-- Hidden sheet for Transaction (E) -->
	
	<!--Page Title, Historical (E)-->
	
		<!--Button (S) -->
		<table width="100%" border="0" class="button" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
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
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table></td>
			</tr>
			</table>
    	<!--Button (E) -->
	
	
	
		<table class="search"> 
       		<tr><td class="bg">	
			<!-- biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="100">SVC Scope</td>
					<td width="280" style="padding-left:2"><script language="javascript"> ComComboObject('svc_scp_cd', 2, 78, 0, 1, 0, false);</script>
					&nbsp;<input name="svc_scp_nm" type="text" style="width:177;"  value="" class="input2" readonly></td>
					<td width="68">Duration</td>   
					<td width="284">
					<!--
					<input name="eff_dt" type="text" style="width:72;text-align:center;"  value="" class="input1" caption="Effective Date" maxlength="10" dataformat="ymd" required>
					&nbsp;~
					<input name="exp_dt" type="text" style="width:72;text-align:center;"  value="" class="input" caption="Expire Date" maxlength="10" dataformat="ymd" required>
					 -->
					 
					<nobr>
					<input name="eff_dt" type="text" style="width:75;text-align:center;"  value="" class="input1" caption="Effective" maxlength="10" dataformat="ymd" required>
					<img class="cursor" src="img/btns_calendar.gif" name="btns_calendar1" width="19" height="20" border="0" align="absmiddle">&nbsp;~
					<input name="exp_dt" type="text" style="width:75;text-align:center;"  value="" class="input" caption="Expire Date" maxlength="10" dataformat="ymd" required>
					<img class="cursor" src="img/btns_calendar.gif" name="btns_calendar2" width="19" height="20" border="0" align="absmiddle">
					</nobr>
					
					</td>
					<!-- 
					<td width="106" style="padding-left:2">
					<img src="img/btns_calendar.gif" class="cursor" name="btns_calendar" valign="bottom">
					</td>
					 -->
					<td width="96">Creation Office</td>
					<td width="" style="padding-left:2">
					<script language="javascript">ComComboObject('cre_ofc_cd_in', 1, 81, 0, 0, 0, false);</script>
					</td>
					</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="100">Customer Type</td>
					<td width="280" style="padding-left:2">
					<script language="javascript">ComComboObject('prs_cust_tp_cd_in', 1, 78, 0, 0, 0, false);</script>
					</td>
					<td width="68">SVC Lane</td>
					<td width="284"><input type="text" name="vsl_slan_cds" dataformat="engup" style="width:191;text-align:center;" class="input" value="" required> 
					<a href="javascript:popupSvcLane();">
					<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></a></td>
					<td width="96">Commodity</td>
					<td width=""><input type="text" name="prc_cmdt_def_cd" dataformat="engup" maxlength="6" style="width:58;text-align:center;" class="input" value="" required>
					<a href="javascript:popupCommodity();">
					<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></a></td>
					
				</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="40">Origin</td>
					<td width="140"><input type="text" name="origin_cd" dataformat="engup" maxlength="5" style="width:55;text-align:center;" class="input" value="" required>
					<a href="javascript:popupOrigin();">
					<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></a></td>
					<td width="60">Destination</td>
					<td width="129"  style="padding-left:2"><input type="text" name="dest_cd" dataformat="engup" maxlength="5" style="width:55;text-align:center;" class="input" value="" required>
					<a href="javascript:popupDest();">
					<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></a></td>
					<td width="70">R/D Term</td>
					<td width="195">
					<script language="javascript">ComComboObject('r_rcv_de_term_cd', 1, 84, 0, 0, 0, false);</script>
					&nbsp;
					<script language="javascript">ComComboObject('d_rcv_de_term_cd', 1, 84, 0, 0, 0, false);</script>	
					</td>
					<td width="25">Per</td>
					<td width="62">
					<script language="javascript">ComComboObject('rat_ut_cd_in', 2, 40, 0, 0, 0, false);</script>
					</td>
					<td width="96">CGO Type</td>
					<td style="padding-left:2">
					<script language="javascript">ComComboObject('prc_cgo_tp_cd', 2, 81, 0, 0, 0, false);</script>
					</td>
				</tr>
				</table>
				
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
				
					<!--grid (s)-->
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table>
					<!--grid(E)-->
						<!--  
						<table class="height_5"><tr><td colspan="8"></td></tr></table>
						<table border="0" style="width:100%;" class="grid2"> 
							<tr class="tr2_head">
								<td width="16%">SVC Lane</td>
								<td width="16%">Commodity	</td>
								<td width="16%">Origin	</td>
								<td width="16%">Origin Via		</td>
								<td width="16%">Destination Via	</td>
								<td width="%">	Destination</td>
							</tr>
							<tr class="h23">
								<td><textarea  style="width:100%;height:80" class="textarea2">PSXAXPNN</textarea></td>
								<td><textarea  style="width:100%;height:80" class="textarea2">GARMENTS,NOS	</textarea></td>
								<td><textarea  style="width:100%;height:80" class="textarea2">QINGDAO,SHANDONG(CY)XINGANG(CY)SHANGHAI(CY)</textarea></td>
								<td><textarea  style="width:100%;height:80" class="textarea2">North PRC Base Port</textarea></td>
								<td><textarea  style="width:100%;height:80" class="textarea2">US West Coast</textarea></td>
								<td><textarea  style="width:100%;height:80" class="textarea2">NASHVILLE, TN(Door) MOUNT JULIET, TN(Door)</textarea></td>
							</tr>
						</table>
						-->
						<!--grid (s)-->
						<br>
						<table class="height_5"><tr><td colspan="8"></td></tr></table>
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet2');</script>
								</td>
							</tr>
						</table>
						<!--grid(E)-->
				
				
			<!-- biz_1  (E) -->	
				
			</td></tr>
		</table>
	
 </td></tr>
</table>

<div id="hiddenSheetLayer" style="display: none">
	<script language="javascript">ComSheetObject('sheet3');</script>
	<script language="javascript">ComSheetObject('sheet4');</script>
	<script language="javascript">ComSheetObject('sheet5');</script>
	<script language="javascript">ComSheetObject('sheet6');</script>
	<script language="javascript">ComSheetObject('sheet7');</script>
	<script language="javascript">ComSheetObject('sheet8');</script>
	<script language="javascript">ComSheetObject('sheet9');</script>
</div>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>