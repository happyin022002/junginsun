<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TES_0039.jsp
*@FileTitle : Terminal Agreement Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.08.10 yOng hO lEE
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
<%@ page import="com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.event.EsdTes0039Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdTes0039Event	event			= null;				//PDTO(Data Transfer Object including Parameters)
	Exception		serverException	= null;				//서버에서 발생한 에러
	String			strErrMsg		= "";				//에러메세지
	String			ofc_cd			= "";
	int				rowCount		= 0;				//DB ResultSet 리스트의 건수

	try {

	    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	    ofc_cd = account.getOfc_cd();

		event = (EsdTes0039Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
		} // end else
	}catch(Exception e) {
		out.println(e.toString());
	}

	String effAgmt = JSPUtil.getCodeCombo("eff_agmt", "01", "", "CD00740", 0, "");
	
	/** 2015-03-04 : [CHM-201533697]detail화면에서 to Summary 버튼 클릭시 이전 화면 검색 결과 유지되도록 설정   **/
	String pre_cond_yd_cd 				= request.getParameter("pre_cond_yd_cd")!=null&&!request.getParameter("pre_cond_yd_cd").trim().equals("")?request.getParameter("pre_cond_yd_cd"):"";
	String pre_cond_vndr_seq 			= request.getParameter("pre_cond_vndr_seq")!=null&&!request.getParameter("pre_cond_vndr_seq").trim().equals("")?request.getParameter("pre_cond_vndr_seq"):"";
	String pre_cond_eff_agmt 			= request.getParameter("pre_cond_eff_agmt")!=null&&!request.getParameter("pre_cond_eff_agmt").trim().equals("")?request.getParameter("pre_cond_eff_agmt"):"";
	String pre_cond_eff_on 				= request.getParameter("pre_cond_eff_on")!=null&&!request.getParameter("pre_cond_eff_on").trim().equals("")?request.getParameter("pre_cond_eff_on"):"";
	String pre_cond_ctrt_ofc_cd 		= request.getParameter("pre_cond_ctrt_ofc_cd")!=null&&!request.getParameter("pre_cond_ctrt_ofc_cd").trim().equals("")?request.getParameter("pre_cond_ctrt_ofc_cd"):"";
	String pre_cond_delt_flg 			= request.getParameter("pre_cond_delt_flg")!=null&&!request.getParameter("pre_cond_delt_flg").trim().equals("")?request.getParameter("pre_cond_delt_flg"):"";	
	String pre_cond_tml_agmt_sts_cd 	= request.getParameter("pre_cond_tml_agmt_sts_cd")!=null&&!request.getParameter("pre_cond_tml_agmt_sts_cd").trim().equals("")?request.getParameter("pre_cond_tml_agmt_sts_cd"):"";
	String pre_cond_cre_ofc_cd2 		= request.getParameter("pre_cond_cre_ofc_cd2")!=null&&!request.getParameter("pre_cond_cre_ofc_cd2").trim().equals("")?request.getParameter("pre_cond_cre_ofc_cd2"):"";

%>
<html>
<head>
<title>Terminal Agreement Summary</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript" src="rpt/script/rdviewer50.js"></script>
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if

		loadPage();
	}

	var ofc_cd = "<%=ofc_cd%>";
</script>
</head>


<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="is_valid_yd_cd">
<input type="hidden" name="yd_cd_hidden">
<input type="hidden" name="yd_cd_deltflg">
<input type="hidden" name="is_valid_vndr_seq">
<input type="hidden" name="vndr_seq_hidden">
<input type="hidden" name="vndr_seq_deltflg">
<!-- ofc_cd 별로 권한제어시 추가 -->
<input type="hidden" name="no_ofc_cd">
<input type="hidden" name="no_yd_cd">
<input type="hidden" name="act_tp" value="AGMT">
<input type="hidden" name="auth_ofc_cd" value="">
<input type="hidden" name="rhq_ofc_cd" value="">
<input type="hidden" name="cre_ofc_cd" value="<%=ofc_cd%>">
<input type="hidden" name="acct_ofc_cd" value="<%=ofc_cd%>">

<!-- 2015-03-04 : [CHM-201533697]detail화면에서 to Summary 버튼 클릭시 이전 화면 검색 결과 유지되도록 설정   -->
<input name="pre_cond_yd_cd" type="hidden" value="<%=JSPUtil.getNull(pre_cond_yd_cd)%>">
<input name="pre_cond_vndr_seq" type="hidden" value="<%=JSPUtil.getNull(pre_cond_vndr_seq)%>">
<input name="pre_cond_eff_agmt" type="hidden" value="<%=JSPUtil.getNull(pre_cond_eff_agmt)%>">
<input name="pre_cond_eff_on" type="hidden" value="<%=JSPUtil.getNull(pre_cond_eff_on)%>">
<input name="pre_cond_ctrt_ofc_cd" type="hidden" value="<%=JSPUtil.getNull(pre_cond_ctrt_ofc_cd)%>">
<input name="pre_cond_delt_flg" type="hidden" value="<%=JSPUtil.getNull(pre_cond_delt_flg)%>">
<input name="pre_cond_tml_agmt_sts_cd" type="hidden" value="<%=JSPUtil.getNull(pre_cond_tml_agmt_sts_cd)%>">
<input name="pre_cond_cre_ofc_cd2" type="hidden" value="<%=JSPUtil.getNull(pre_cond_cre_ofc_cd2)%>">

<input type="hidden" name="sub_ofc_cd1" value="">
<input type="hidden" name="sub_ofc_cd2" value="">
<input type="hidden" name="ofc_cd" value="">

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>


		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->



		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr><td class="btn1_bg">

						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new">New</td><td class="btn1_right"></td></tr></table></td>
							<!-- Repeat Pattern -->

						</tr></table>

				</td></tr>
		</table>
    	<!-- TABLE '#D' : ( Button : Main ) (E) -->




		<!-- TABLE '#D' : ( Search Options :  ) (S) -->
     	<table class="search">
       	<tr><td class="bg">
				<!-- : ( Week ) (S) -->
				<table class="search_in" border="0">

				<tr class="h23">
					<td width="105"><img class="nostar">Yard</td>
					<td width="420">&nbsp;<input type="text" name="yd_cd" style="width:78" maxlength="7" onKeyUp='isApNum2(this);' onKeyDown='tes_chkInput(this);' onBlur='validateYardCode()'>&nbsp;<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_yard">&nbsp;<input type="text" name="yd_cd_name" style="width:230" readonly></td>
					<td width="110">Service Provider</td>
					<td width="">&nbsp;<input type="text" name="vndr_seq" style="width:78" maxlength="6" onKeyUp='isNum(this);' onKeyDown='tes_chkInput(this);' onBlur='validateVendorCode();'>&nbsp;<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_vndr">&nbsp;<input type="text" name="vndr_seq_name" style="width:230" readonly></td></tr>
				</table>

				<table class="search_in" border="0">
				<tr class="h23">
					<td width="107"><img class="nostar">Effective AGMT</td>
					<td width="165"><%=effAgmt%></td>
					<td width="90">Effective On</td>
					<td width="158"><input type="text" style="width:80" name="eff_on" maxlength="10" onKeyUp='isNum1(this);tes_isNumD(this,"Y");' onKeyDown='tes_chkInput(this);'>&nbsp;<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar"></td>
					<td width="110" style="padding-left:5">Contract Office</td>
					<td class="stm">&nbsp;<input type="text" name="ctrt_ofc_cd" maxlength="6" style="width:78" onKeyUp='isApNum2(this);' onKeyDown='tes_chkInput(this);'>&nbsp;<input name="sub_office1" type="checkbox" value="" class="trans" onClick="javascript:getSubOffice1();">&nbsp;Incl. Sub OFC</td></tr>
				</tr>

				<tr class="h23">
					<td width="107"><img class="nostar">Deleted Y/N</td>
					<td width="121"><SELECT name = "delt_flg"  style="width:67">
							<OPTION  value=""> All</OPTION>
							<OPTION  value="N"> Live</OPTION>
							<OPTION  value="Y"> Deleted</OPTION>
							</SELECT></td>
					<td width="90">AGMT Status</td>
					<td width="145"><SELECT name = "tml_agmt_sts_cd"  style="width:80">
							<OPTION  value=""> All</OPTION>
							<OPTION  value="P"> Processing</OPTION>
							<OPTION  value="C"> Registered</OPTION></SELECT></td>
					<td width="110">&nbsp;Creation Office</td>
					<td class="stm">&nbsp;<input type="text" name="cre_ofc_cd2" maxlength="6" style="width:78" value="" onKeyUp='isApNum2(this);' onKeyDown='tes_chkInput(this);'>&nbsp;<input name="sub_office2" type="checkbox" value="" class="trans" onClick="javascript:getSubOffice2();">&nbsp;Incl. Sub OFC</td>
				</tr>


				</table>
				<!-- : ( Week ) (E) -->


			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : ) (E) -->

<!--1 start-->
		<table class="height_10"><tr><td></td></tr></table>



		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
     	<table class="search" border="0">
       	<tr><td class="bg">




			<table class="height_10"><tr><td></td></tr></table>




			<!-- : ( Grid : Week ) (S) -->
			<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,
				 'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->

			<table width="100%" id="mainTable">
				<tr><td>
					 <script language="javascript">ComSheetObject('sheet1');</script>
				</td></tr>
			</table>

			<!-- : ( Grid : Week ) (E) -->






			<!-- : ( Button : Sub ) (S) -->
			<table class="button" border="0" width="100%">
						<tr><td class="btn2_bg" class="align">
							<table border="0" cellpadding="0" cellspacing="0">
								<tr>
									<!-- Repeat Pattern -->
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td><td class="btn2" name="btng_adjustmentscreen" id="btng_adjustmentscreen">Adjustment Screen</td>
									<td class="btn2_right"></td></tr></table></td>
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td><td class="btn2" name="btng_detail" id="btng_detail">Detail</td>
									<td class="btn2_right"></td></tr></table></td>
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td><td class="btn2" name="btng_downexcel" id="btng_downexcel">Down Excel</td>
									<td class="btn2_right"></td></tr></table></td>
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td><td class="btn2" name="btng_print" id="btng_print">Print</td>
									<td class="btn2_right"></td></tr></table></td>
									<!-- Repeat Pattern -->
								</tr>
							</table>
						</td></tr>
					</table>
	    	<!-- : ( Button : Sub ) (E) -->


			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->

 <!--1 end-->

</td></tr>
</table>
<!-- Outer Table (E)-->

</form>
</body>
</html>
<%@ include file="/bizcommon/include/common_auth.jsp"%>