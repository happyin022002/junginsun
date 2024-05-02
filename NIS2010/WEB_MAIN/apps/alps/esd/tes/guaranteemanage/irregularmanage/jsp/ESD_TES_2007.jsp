<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TES_2007.jsp
*@FileTitle : Irregular Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.29
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.10.29 yOng hO lEE
* 1.0 Creation
* 2012.02.03 박성호 [CHM-201215762] [TES] US Irregular/Guarantee 보완 사항 구현
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.tes.guaranteemanage.irregularmanage.event.EsdTes2007Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdTes2007Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.GuaranteeManage.IrregularManage");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();


		event = (EsdTes2007Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
	/** 조회 화면 이동시 재조회하기 추가    **/
	
	String pre_cond_irr_no 				= request.getParameter("pre_cond_irr_no")!=null&&!request.getParameter("pre_cond_irr_no").trim().equals("")?request.getParameter("pre_cond_irr_no"):"";
	String pre_cond_cost_ofc_cd 		= request.getParameter("pre_cond_cost_ofc_cd")!=null&&!request.getParameter("pre_cond_cost_ofc_cd").trim().equals("")?request.getParameter("pre_cond_cost_ofc_cd"):"";
	String pre_cond_cre_usr_id 			= request.getParameter("pre_cond_cre_usr_id")!=null&&!request.getParameter("pre_cond_cre_usr_id").trim().equals("")?request.getParameter("pre_cond_cre_usr_id"):"";
	String pre_cond_gnte_tp_cd 			= request.getParameter("pre_cond_gnte_tp_cd")!=null&&!request.getParameter("pre_cond_gnte_tp_cd").trim().equals("")?request.getParameter("pre_cond_gnte_tp_cd"):"";
	String pre_cond_fm_cre_dt 			= request.getParameter("pre_cond_fm_cre_dt")!=null&&!request.getParameter("pre_cond_fm_cre_dt").trim().equals("")?request.getParameter("pre_cond_fm_cre_dt"):"";
	String pre_cond_to_cre_dt 			= request.getParameter("pre_cond_to_cre_dt")!=null&&!request.getParameter("pre_cond_to_cre_dt").trim().equals("")?request.getParameter("pre_cond_to_cre_dt"):"";
%>
<html>
<head>
<title>Irregular Inquiry</title>
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
<input type="hidden" name="DB_DATE"		value="" >
<input type="hidden" name="is_valid_gnte_cust_cd">
<input type="hidden" name="gnte_cust_cd_hidden">
<input type="hidden" name="cre_ofc_cd"	value="<%=strOfc_cd%>">
<input type="hidden" name="usr_id" 		value="<%=strUsr_id%>">

<!--	상세조회 화면에서 이동해 왔을 경우 바로 다시 조회 화면으로 돌아갔을때 이전 조회 조건들로 자동 조회하기 위한 값들. 	-->
<input name="pre_cond_irr_no" 			type="hidden" value="<%=JSPUtil.getNull(pre_cond_irr_no)%>">
<input name="pre_cond_cost_ofc_cd" 		type="hidden" value="<%=JSPUtil.getNull(pre_cond_cost_ofc_cd)%>">
<input name="pre_cond_cre_usr_id" 		type="hidden" value="<%=JSPUtil.getNull(pre_cond_cre_usr_id)%>">
<input name="pre_cond_gnte_tp_cd" 		type="hidden" value="<%=JSPUtil.getNull(pre_cond_gnte_tp_cd)%>">
<input name="pre_cond_fm_cre_dt" 		type="hidden" value="<%=JSPUtil.getNull(pre_cond_fm_cre_dt)%>">
<input name="pre_cond_to_cre_dt" 		type="hidden" value="<%=JSPUtil.getNull(pre_cond_to_cre_dt)%>">

<!-- DEPART Validation Check Use -->
<input type="hidden" name="is_valid_ofc_cd">
<input type="hidden" name="ofc_cd">
<%--  Cost Office Code 가져오기 위한 임의 값 설정. 여기에서는 의미 없는 값. TESCommon에 기 구현된 로직 사용키 위함. --%>
<input type="hidden" name="yd_cd" value='___'>
<input type="hidden" name="is_valid_print">
<input type="hidden" name="irr_no_hidden">

<!-- 개발자 작업	-->
<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>


		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="/hanjin/img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->


		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
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
					<td class="btn1" name="btn_guarantee">Guarantee</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>

				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_irregular">Irregular</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_print">Print</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>

		</tr>
		</table></td>
		</tr>
		</table>
    <!--Button (E) -->

		<!-- TABLE '#D' : ( Search Options ) (S) -->
	     	<table class="search">
	       	<tr><td class="bg">

						<!-- : ( Year ) (S) -->
						<table class="search_in" border="0"">
							<tr class="h23">
								<td width="120">Reference Number</td>
								<td width="150">
									<input type="text" style="width:100" name="irr_no" maxlength="12" OnKeyUp="isApNum2(this)">
									&nbsp;<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_refno">
								</td>
								<td width="80">Office Code</td>
								<td width="80"><input type="text" style="width:70" name="cost_ofc_cd"  maxlength="6" OnKeyUp='tes_isApNum(this);upper(this);' OnBlur='validateDeptNo();'></td>
								<td width="60">USER ID</td>
								<td width="85"><input type="text" style="width:75" name="cre_usr_id" maxlength="20"></td>
								<td width="40">Type</td>
								<td width="80">
									<select name="gnte_tp_cd">
										<option value=""></option>
										<option value="ST">Storage</option>
										<option value="FL">Flip</option>
										<option value="CY">Other</option>
									</select>
								</td>
								<td width="90">Creation Date</td>
								<td width="" class="stm">
									<input type="text" style="width:70" name="fm_cre_dt" maxlength="10" class="input1" onKeyUp='tes_isNumD(this,"Y"); tes_moveFocus(this,this.form.to_cre_dt,10);' onKeyDown='tes_chkInput(this); tes_isNumD(this,"Y");' OnBlur='this.value=ComGetMaskedValue(this.value, "ymd");'>&nbsp;<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar1">&nbsp;~&nbsp;
									<input type="text" style="width:70" name="to_cre_dt" maxlength="10" class="input1" onKeyUp='tes_isNumD(this,"Y");' onKeyDown='tes_chkInput(this); tes_isNumD(this,"Y");' OnBlur='this.value=ComGetMaskedValue(this.value, "ymd");'>&nbsp;<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar2">
								</td>
							</tr>
						</table>

						<!-- : ( Year ) (E) -->


			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->
		<table class="height_10"><tr><td></td></tr></table>


		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
	     	<table class="search" border="0">
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
			</td></tr>
		</table>



			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
		<table class="height_10"><tr><td></td></tr></table>
		
     	<table class="search" style='display:none'>
       		<tr><td class="bg">
       		
				<table class="search_in" border="0">
					<tr class="h23">
						<td width="105" align='right'>Total Count&nbsp;</td>
						<td width="150" align='left'><input type="text" style="width:100" name="ttl_cnt" class="input2" readonly></td>
						<td width="105" align='right'>Total Amount&nbsp;</td>
						<td width="150" align='left'><input type="text" style="width:100" name="ttl_amt" class="input2" readonly></td>
						<td width="500"></td>
					</tr>
				</table>
				
				</td>
			</tr>
		</table>

<div style='display:'>
<!-- Header Info Grid  (S) -->
<table width="100%"  id="mainTable">
	<tr>
		<td width="100%">
			<script language="javascript">ComSheetObject('sheet2');</script>
		</td>
	</tr>
</table>
<!-- Header Info Grid (E) -->

</div>

<!-- Outer Table (E)-->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>