<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0112.jsp
*@FileTitle : booking report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.08.03 강동윤 
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.event.EsmBkg0112Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0112Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.BookingReport.StatusReport");

	String vvdCd = "";
	String polCd = "";
	String podCd = "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0112Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		vvdCd  = JSPUtil.getParameter(request, "vvd_cd");
		polCd  = JSPUtil.getParameter(request, "pol_cd");
		podCd  = JSPUtil.getParameter(request, "pod_cd");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>booking report</title>
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

<input type="hidden" name="vsl_cd">
<input type="hidden" name="skd_voy_no">
<input type="hidden" name="skd_dir_cd">
<input type="hidden" name="tab_item">
<input type="hidden" name="pol_yd_cd">
<input type="hidden" name="pod_yd_cd">
<input type="hidden" name="master_tot">
<input type="hidden" name="houser_tot">

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
			

				<!--  biz_1 (S) -->
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="30">VVD</td>
						<td width="110"><input type="text" name="vvd" style="width:80;" value="<%=vvdCd%>" dataformat="engupnum" maxlength="9" class="input1"></td>
						<td width="30">POL</td>
						<td width="90"><input type="text" name="pol_cd" style="width:50;" value="<%=polCd%>" dataformat="engupnum" maxlength="5">&nbsp;<input type="text" name="pol_nod_cd" style="width:20;" value="" dataformat="engupnum" maxlength="2" class="input"></td>
						<td width="30">POD</td>
						<td width="90"><input type="text" name="pod_cd" style="width:50;" value="<%=podCd%>" dataformat="engupnum" maxlength="5">&nbsp;<input type="text" name="pod_nod_cd" style="width:20;" value="" dataformat="engupnum" maxlength="2" class="input"></td>
						<td width="120">US Customs type</td>
						<td width="50">
							<!--script language="javascript">ComComboObject('entr_clss_tp_gubun', 1, 50, 1, '');</script -->
							<select style="width: 110;" name="entr_clss_tp_gubun">
							<option value="" >ALL</option>
							<option value="G" >G</option>
							<option value="IE" >IE</option>
							<option value="TE">TE</option>
						</select--> 
						</td>
						<td width="50" align="right">
								<table border="0" style="width:100%;" class="search_sm2"> 
								<tr style="height:13;">
									<td class="sm">
										<input type="radio" name="chk_err" class="trans" value="1" checked>&nbsp;All&nbsp;&nbsp;
										<input type="radio" name="chk_err" class="trans" value="0" >&nbsp;Error</td></tr>
								</table>
						</td>
						<td width="" colspan="4"></td>
					</tr>
				</table>
				<!--  biz_1   (E) -->		
			
		</td></tr></table>
		<table class="height_8"><tr><td></td></tr></table>	
		
			<!--Grid (s)-->
		<table class="search"> 
	       	<tr><td class="bg">
	    		<table class="search" border="0" style="width:979;"> 
					<tr class="st"><td class="stm"><span id="tab_tot">Total : </span></td></tr>	
				</table>
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!--Grid (E)-->
			</td></tr>
		</table>		

	
	</td></tr>
		</table>
	

	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
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
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_SaveExcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>