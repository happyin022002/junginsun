<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TRS_0111.jsp
*@FileTitle : Surcharge Report
*Open Issues :
*Change history :
*@LastModifyDate : 2013-10-16
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
<%@ page import="com.hanjin.apps.alps.esd.trs.report.scgreport.event.EsdTrs0111Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.Date"%>
<%
	EsdTrs0111Event  event = null;				//PDTO(Data Transfer Object including Parameters)
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
		
		event = (EsdTrs0111Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
    // change to table name
	String transModeCd  = JSPUtil.getCodeCombo("f_trsp_crr_mod_cd" , "01", "style='width:120'", "CD00283", 0, "000010:ALL:ALL");
%>
<html>
<head>
<title>Surcharge Report</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">

	<%= JSPUtil.getIBCodeCombo("f_trsp_crr_mod_cd" , "", "CD00283", 0, "")%>

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
<input type="hidden" name="sel_wo_ofc_cd">
<input type="hidden" name="sel_inv_ofc_cd">
<input type="hidden" name="sel_op_tp">
<input type="hidden" name="sel_month">
<input type="hidden" name="scg_type">
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
					<td width="250">Date(YYYYMMDD)&nbsp;&nbsp;&nbsp;<select name="sel_date">
								<option value="wo" selected>W/O Issued</option>
								<option value="inv" >Invoice Confirmed</option></select></td>
					<td width="280">
						<input type="text" name="from_date" required style="width:75;ime-mode:disabled;text-align:center" maxlength="8" dataformat="ymd" fullfill caption="Year-Month-Date(From Date)" class="input1" value="">&nbsp;&nbsp;~&nbsp;
						<input type="text" name="to_date" required style="width:75;ime-mode:disabled;text-align:center" maxlength="8" dataformat="ymd" fullfill caption="Year-Month-Date(To Date)" class="input1" value="">&nbsp;<img src="img/btns_calendar.gif" name="btns_calendar" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
					</td>
					<td width="80">Office Code</td>
					<td width="230">
						<table class="search_sm2" border="0"  style="width:100%;">
						<tr class="h23">
							<td class="sm"><input name="input_office" type="text" class="input1" style="width:70" onkeyup="upper(this)" value="<%=strOfc_cd%>" ><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_office">&nbsp;&nbsp;<input type="checkbox" name="chk_office" value="Y" class="trans" onClick="javascript:fun_chkOffice();">Incl. Sub OFC</td>
						</tr>
						</table>
					</td>
					<td width="90"></td>

				</tr>
				</table>
				
				<table class="search_in" border="0">
				<tr class="h23">
					<td width="110">Surcharge Type</td>
					<td>
                        <input name="scg_radio" type="radio" value="" class="trans" onChange="setScgType();" checked>&nbsp;&nbsp;W/O&nbsp;&nbsp;&nbsp;&nbsp;
                        <input name="scg_radio" type="radio" value="" class="trans" onChange="setScgType();">&nbsp;&nbsp;Invoice
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
		<!--  Button_Sub (S) -->
		<table width="100%" class="button"> 
       	<tr><td class="btn2_bg">
			<table border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td>
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_detail">Go to Detail</td>
						<td class="btn2_right"></td>
						</tr>
					</table>
				</td>
			</tr>
			</table>
		</td></tr>
		</table>
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