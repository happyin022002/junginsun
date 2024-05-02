<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0111.jsp
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.event.EsmBkg0111Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0111Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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


		event = (EsmBkg0111Event)request.getAttribute("Event");
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
						<td width="50">Shipper</td>
						<td width="140"><input type="text" name="cust_cnt_cd" style="width:30;" value="" dataformat="engup" maxlength="2">&nbsp;<input type="text" name="cust_seq" style="width:80;" value="" dataformat="int" maxlength="6"></td>
						<td width="50">US Filer</td>
						<td width="105"><script language="javascript">ComComboObject('usa_cstms_file_cd', 2, 70, true, '');</script></td>
						<td width="50">CA Filer</td>
						<td width="105"><script language="javascript">ComComboObject('cnd_cstms_file_cd', 2, 70, true, '');</script></td>
						<td width="" align="right">
								<table border="0" style="width:100%;" class="search_sm2"> 
								<tr style="height:13;">
									<td class="sm">
										<input type="radio" name="chk_err" class="trans" value="1" checked>&nbsp;All&nbsp;&nbsp;
										<input type="radio" name="chk_err" class="trans" value="0" >&nbsp;Error</td></tr>
								</table>
						</td>
					</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="94">Booking Office</td>
						<td width="105"><input type="text" name="bkg_ofc_cd" style="width:60;" value="" dataformat="engup" maxlength="6"></td>
						<td width="90">Booking Staff</td>
						<td width="107"><input type="text" name="cre_usr_id" style="width:60;" value="" maxlength="20"></td>
						<td width="68">B/L Office</td>
						<td width="87"><input type="text" name="obl_iss_ofc_cd" style="width:60;" value="" dataformat="engup" maxlength="6"></td>
						<td width="66">B/L Staff</td>
						<td width="92"><input type="text" name="obl_iss_usr_id" style="width:70;" value="" maxlength="20"></td>
						<td width="64">Sales Rep.</td>
						<td width="" colspan="3"><input name="ob_srep_cd" type="text" style="width:70;" value="" dataformat="engupnum" maxlength="5"></td>
					</tr>
				</table>
				<!--  biz_1   (E) -->		
			
		</td></tr></table>
		<table class="height_8"><tr><td></td></tr></table>	
		
		<!-- Tab (S) -->
     		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%> 
       		<tr><td width="200">
						<script language="javascript">ComTabObject('tab1')</script>
						<!-- img src="img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
				</td>
				<td width="10">
				</td>
				<td width="">
					<table class="search" border="0" cellpadding="0" cellspacing="0"> 
       					<tr><td class="stm">
							<span id="tab_tot">Total : </span></td>
						</tr>
					</table>
				</td>
			</tr>
			</table>
		<!-- Tab (E) -->

<!--TAB Master B/L (S) -->

<div id="tabLayer" style="display:inline">

		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
			
			
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t1sheet1');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->		
			
			
			
			</td></tr>
		</table>
		<!--biz page (E)-->

</div>

<!--TAB Master B/L (E) -->


<!--TAB House B/L (S) -->

<div id="tabLayer" style="display:none">

		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
			
			
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t2sheet1');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->		
			
			
			
			</td></tr>
		</table>
		<!--biz page (E)-->

</div>

<!--TAB House B/L (E) -->
	
	
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