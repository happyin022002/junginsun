<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_1115.jsp
*@FileTitle : ESP Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.31
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.08.31 조재성
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
<%@ page import="com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.event.EesCgm1115Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%>

<%
	EesCgm1115Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.ChassisMgsetMgt.ChassisMgsetInventory");

	String xml = HttpUtil.makeXML(request,response);
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesCgm1115Event)request.getAttribute("Event");
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
<title>ESP Report</title>
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
<form name="form2">
<input type="hidden" name="sXml" value="<%=xml.replace("\"","'")%>">
</form>
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="eq_orz_cht_chktype">
<input type="hidden" name="eq_orz_cht_rcc_cd">
<input type="hidden" name="eq_orz_cht_lcc_cd">
<input type="hidden" name="eq_orz_cht_scc_cd">
<input type="hidden" name="back_end_job_key">
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
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:;,padding-bottom:2;"> 
       	<tr><td class="btn1_bg">
		
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="30">SCC</td>
					<td width="116"><input name="crnt_scc_cd" type="text" style="width:60;text-align:center;ime-mode:disabled" class="input1" value="" dataformat="engup" maxlength="5">&nbsp;<img name="btns_scc_cd" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
					<td width="125">Throughput Period</td>
					<td width="232">
						<input type="text" name="troughput_inq_fm_dys"  style="width:60;text-align:center;ime-mode:disabled" dataformat="ym" class="input1" maxlength='6' value= "">&nbsp;<img name="btns_troughput_inq_fm_dys" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
						&nbsp;~&nbsp;<input name="troughput_inq_to_dys" type="text" style="width:60;text-align:center;ime-mode:disabled" class="input1" value="" dataformat="ym" maxlength='6'>&nbsp;<img name="btns_troughput_inq_to_dys" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="108">Turn Time Period</td>
					<td><input name="turn_time_inq_fm_dys" type="text" style="width:60;text-align:center;ime-mode:disabled" class="input1" value="" dataformat="ym" maxlength='6'>&nbsp;<img name="btns_turn_time_inq_fm_dys" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
					&nbsp;~&nbsp;<input name="turn_time_inq_to_dys" type="text" style="width:60;text-align:center;ime-mode:disabled" class="input1" value="" dataformat="ym" maxlength='6'>&nbsp;<img name="btns_turn_time_inq_to_dys" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
					</td>
				</tr> 
				</table>				
				<!--  biz_1   (E) -->
			
		</td></tr></table>
		<table class="height_8"><tr><td></td></tr></table>	
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
					
				<!-- Grid (S) -->
					<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
				<!-- Grid (E) -->	

			</td></tr>
		</table>
		<!--biz page (E)-->


		
		
	
	</td></tr>
	</table>

<div id="tabLayer" style="display:none"> 
    <!-- Grid  (S) -->
        <table width="100%"  id="mainTable"> 
            <tr>
                <td width="100%">
                    <script language="javascript">ComSheetObject('sheet2');</script>
                </td>
            </tr>
        </table>
    <!-- Grid  (E) -->
</div>  

<!-- 개발자 작업  끝 -->

</form>
</body>
</html>