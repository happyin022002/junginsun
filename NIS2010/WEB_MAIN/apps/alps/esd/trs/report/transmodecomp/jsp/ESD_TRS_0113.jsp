<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TRS_0113.jsp
*@FileTitle :  Inland Transmode Comparison
*Open Issues :
*Change history :
*@LastModifyDate : 2013-12-18
*@LastModifier : 조인영
*@LastVersion : 1.0
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.report.transmodecomp.event.EsdTrs0113Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.Date"%>
<%
	EsdTrs0113Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id	= "";
	String strUsr_nm	= "";
	String strOfc_cd    = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		
		event = (EsdTrs0113Event)request.getAttribute("Event");
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
<title>Inland Trans Mode Comparison</title>
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
<input type="hidden" name="old_ofc_cd" value="<%=strOfc_cd%>">
<input type="hidden" name="incl_sub_ofc_flg">

<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;padding-right:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->
	
    <!--Button (S) -->
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
        <tr><td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_retrieve">Retrieve</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_new">New</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td class="btn1_line"></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_down_excel">Down Excel</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
            </tr>
            </table>
        </td></tr>
        </table>
    <!--Button (E) -->
    	
	<!--biz page (S)-->
		<table class="search"> 
       		<tr><td class="bg">
				<!-- biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="145">Date&nbsp;&nbsp;&nbsp;<select name="sel_date">
								<option value="so" selected>S/O Creation</option>
								<option value="wo" >W/O Issue</option></select></td>
					<td width="220">
						<input type="hidden" name="now_date" value="<%=DateTime.getFormatDate(new Date(),"yyyy-MM-dd")%>">
						<input type="hidden" name="last_day" value="<%=DateTime.lastDayOfMonth(DateTime.getFormatDate(new Date(),"yyyyMMdd"))%>">
						<input type="text" name="from_date" style="width:80;" class="input1" dataformat="ymd" maxlength="8" caption="From to Date">&nbsp;~&nbsp;<input type="text" name="to_date" style="width:80;" class="input1" dataformat="ymd" maxlength="8" onkeyup="javascript:doSearchEnter();" caption="From to Date">&nbsp;<img src="img/btns_calendar.gif" name="from_to_calendar" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
					</td>
					<td width="65">S/O Office</td>
					<td width="210">
						<table class="search_sm2" border="0"  style="width:100%;">
						<tr class="h23">
							<td class="sm"><input name="input_office" type="text" class="input1" style="width:70" onkeyup="javascript:doSearchEnter();" onBlur="setgetUpper(this);" value="<%=strOfc_cd%>" ><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_office">&nbsp;&nbsp;<input type="checkbox" name="chk_office" value="Y" class="trans" onClick="javascript:fun_chkOffice();">Incl. Sub OFC</td>
						</tr>
						</table>
					</td>
					<td width="50">Bound</td>
					<td width="75"><select name="io_bound" style="width:55;">
						<option value="A" selected>ALL</option>
						<option value="I">IN</option>
						<option value="O">OUT</option>
						</select></td>
					<td width="170">W/O Status&nbsp;&nbsp;&nbsp;<select name="sel_wo" style="width:83;">
						<option value="A" selected>ALL</option>
						<option value="I">Issued</option>
						<option value="N">Not Issued</option>
						</select></td>
					<td width="25">
				</tr>
				</table>
				
				<table class="search_in" border="0">
				<tr class="h23">
							<td width="90">Trans Mode</td>
				<td width="340">
					<table border="0" style="height:25; background-color: #E9E9E9;">
						<tr>
							<td width="140">S/O&nbsp;&nbsp;&nbsp;<script language="javascript">ComComboObject('sel_so_trns_mod', 1, 90, 1)</script></td>
							<td width="190">BKG Charge&nbsp;&nbsp;&nbsp;<script language="javascript">ComComboObject('sel_bkg_trns_mod', 1, 90, 1)</script></td>
						</tr>
					</table>
				</td>
					<td width="165">Result&nbsp;&nbsp;&nbsp;<select name="sel_result" style="width:83;">
						<option value="A" selected>ALL</option>
						<option value="M">Match</option>
						<option value="I">Mismatch</option>
						</select></td>
					<td width="180">IHC P&L&nbsp;&nbsp;&nbsp;<select name="sel_pnl" style="width:83;">
						<option value="A" selected>ALL</option>
						<option value="P">Profit</option>
						<option value="S">Same</option>
						<option value="L">Loss</option>
						<option value="U">Unqualified</option>
						</select></td>
					<td width="210"><select name="sel_so_wo">
						<option value="so" selected>S/O No.</option>
						<option value="wo" >W/O No.</option></select>&nbsp;&nbsp;
					    <input name="so_wo_no" type="text" style="width:105" onkeyup="javascript:doSearchEnter();" onBlur="setgetUpper(this);"></td>
					<td width="10">
				</tr>
				</table>
					
				<table class="search_in" border="0">
				<tr class="h23">
					<td width="55">BKG No.</td>
					<td width="115"><input name="sel_bkg_no" type="text" style="width:100" onkeyup="javascript:doSearchEnter();" onBlur="setgetUpper(this);"></td>
					<td width="60">CNTR No.</td>
					<td width="109"><input name="sel_cntr_no" type="text" style="width:90" onkeyup="javascript:doSearchEnter();" onBlur="setgetUpper(this);"></td>
					<td width="80">S/O Route</td>
					<td width ="562">
					<table border="0" style="height:25; background-color: #E9E9E9;">
					<tr>
						<td width="40">From</td>
						<td width="70"><input name="search_fm_node" type="text" style="width:66;" maxlength="7" onkeyup="javascript:doSearchEnter();" onBlur="setgetUpper(this);"></td>
						<td width="40"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_frmnode"></td>
	
						<td width="22">Via</td>
						<td width="70"><input name="search_via_node" type="text" style="width:66;" maxlength="7" onkeyup="javascript:doSearchEnter();" onBlur="setgetUpper(this);"></td>
						<td width="40"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"  name="btns_vianode"></td>
	
						<td width="20">To</td>
						<td width="70"><input name="search_to_node" type="text" style="width:66;" maxlength="7" onkeyup="javascript:doSearchEnter();" onBlur="setgetUpper(this);"></td>
						<td width="40"><img src="/hanjin/img/blank.gif" width="2" hight="1"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"  name="btns_tonode"></td>
	
						<td width="40">Door</td>
						<td width="70"><input name="search_door_node" type="text" style="width:66;" maxlength="7" onkeyup="javascript:doSearchEnter();" onBlur="setgetUpper(this);"></td>
						<td width="26"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"  name="btns_dorloc"></td>
					</tr></table>
				</td>
				</tr>
				</table>
				<table class="search_in" border="0">
				<tr class="h23">
				<td width="85">Contract No.</td>
				<td width="110"><input name="sel_ctrt_no" type="text" style="width:105" onkeyup="javascript:doSearchEnter();" onBlur="setgetUpper(this);"></td>
				<td width="605"></td>
				<td width="50">Format</td>
				<td width="80">
					<table border="0" style="height:25; background-color: #E9E9E9;">
						<tr><td>
							<input type="checkbox" name="chk_compact" value="" class="trans" onclick="chkCompactOption();">Compact
						</td></tr>
					</table>
				</td>
				</tr>
				</table>
				<!-- biz_1  (E) -->
			</td></tr>
		</table>
					
	<table class="height_8"><tr><td></td></tr></table>

<!-- TAB [ Dry ] (S) -->
<div id="tabLayer" style="display:inline">
	<table class="search"> 
	<tr><td class="bg" style="height:416" valign="top">
		<!-- Grid  (S) -->
		<table width="100%"  id="mainTable">
			<tr>
				<td width="100%">
					<script language="javascript">ComSheetObject('sheet1');</script>
				</td>
			</tr>
		</table>
		<!-- Grid (E) -->

    	<!-- Button_Sub (E) -->		
	</td></tr>
	</table>
</div>
<!-- TAB [ Dry ] (E) -->

	</td></tr>
</table>


<!-- 개발자 작업  끝 -->
</form>
</body>
</html>