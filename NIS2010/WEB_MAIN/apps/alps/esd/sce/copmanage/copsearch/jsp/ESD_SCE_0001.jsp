<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_SCE_0001_T.jsp
*@FileTitle : COP Main Search
*Open Issues :
*Change history :
*   - 2006-10-12 : UI
*   - 2009-03-24 CSR:N200903230050
*@LastModifyDate : 2009-02-17
*@LastModifier : Jeong-seon An
*@LastVersion : 2.0
* 2009-02-17 Jeong-seon An
* 2009-04-13 CSR:N200904100050 user Add ID : dalfano
* 2012-04-26 [CHM-201217462]
=========================================================*/
%>

<%@ page import="com.hanjin.framework.component.util.JSPUtil" %>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.common.util.basic.CodeUtilBC" %>
<%@ page import="com.hanjin.apps.alps.esd.sce.common.util.basic.CodeUtilBCImpl" %>
<%@ page import="com.hanjin.apps.alps.esd.sce.copmanage.copsearch.event.EsdSce0001Event"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.copmanage.copsearch.vo.COPInquiryVO"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>

<%@ page import="org.apache.log4j.Logger" %>

<%
	CodeUtilBC codeUtil = new CodeUtilBCImpl() ;


	EsdSce0001Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String userId		= "";
	String userNm		= "";
	COPInquiryVO inqVO = null;
	String adm_flg = "";
	
	
	try {
	 		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
			userId =	account.getUsr_id();
			userNm = account.getUsr_nm();

			event = (EsdSce0001Event)request.getAttribute("Event");
			inqVO = event.getConditionVO();		
			if(inqVO == null){
				inqVO = new COPInquiryVO();
			}
			adm_flg = request.getParameter("adm_flg");

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
<title>Welcome to NMS!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<script language="javascript">
	function setupPage(){
		loadPage();
		//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	}
</script>
<!--
  <Script language="javascript" for="sheet1" event="OnScrollNext(CondParam, PageNo,OnePageRow)">
      alert("fefe");
  </script>
  <Script language="javascript" for="sheet1" event="OnLoadFinish()">
      alert("로드 완료되었습니다.");
  </script>
-->
<body onLoad="setupPage();">

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
		<form name="form" method="post">
		<input type="hidden" name="f_cmd">
		<input type="hidden" name="cust_cnt_seq">
		<input type="hidden" name="cust_tp_cd">
		<input type="hidden" name="pagerows" value="<%=pageRows%>">
		<input type="hidden" name="page_no" value="1">		
		<input type="hidden" name="cust_tp_cd">
		<input type="hidden" name="adm_flg" value="<%=adm_flg%>">				
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

		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="80">Booking No.</td>
							<td width="160">
								<input name="bkg_no" type="text" style="width:120 ; text-transform:uppercase;" value="" onKeyup='enterCheck(this)' Onkeydown="onEnterKey(this)"  onBlur='javascript:this.value=this.value.toUpperCase();' >
								<img onClick="openAddPaste('bkg_no')" class="cursor" src="/hanjin/img/button/btng_plus.gif" width="19" height="20" border="0" align="absmiddle" name='btns_bkg_no'>					
							</td>
							<td width="50">B/L No.</td>
							<td width="140"><input name="bl_no" type="text" style="width:110px ; text-transform:uppercase;" maxlength="13"  Onkeydown="onEnterKey(this)"  onKeyUp="ComChkObjValid(this, false, true, true)" onBlur='javascript:this.value=this.value.toUpperCase();'></td>
							<td width="90">Container No.</td>
							<td width=""><input name ="cntr_no" id ="cntr_no" type = "hidden" value ="<%=inqVO.getCntrNo()%>"></td>
							<td width="160"><input name="cntr_no_nonbit" type="text" value ="<%=inqVO.getCntrNo()%>" style="width:100px ; text-transform:uppercase;" maxlength="11" Onkeydown="onEnterKey(this)"   onBlur='javascript:this.value=this.value.toUpperCase();'  onChange="CheckDigitSplit(this,'cntr_no_split', 'cntr_no')"  onKeyUp="CheckDigitSplit(this, 'cntr_no_split', 'cntr_no')">&nbsp;<input id ="cntr_no_split" type="text" style="width:22" maxlength="2" readonly></td>
							<td width="90">Booking Date</td>
							<td width=""><input type="text" style="width:78 ; text-transform:uppercase;" name="bkg_cre_dt1"  maxlength="10"  dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)" >&nbsp;&nbsp;~&nbsp;&nbsp;<input type="text" style="width:78" name="bkg_cre_dt2"  maxlength="10" dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)">&nbsp;<img name="btns_calendar1" class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
						</tr>
					</table>
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="80">S/O No.</td>
							<td width="160"><input name="so_no" type="text" style="width:120 ; text-transform:uppercase;" Onkeydown="onEnterKey(this)"  onBlur='javascript:this.value=this.value.toUpperCase();' ></td>
							<td width="50">COP No.</td>
							<td width="140"><input name="cop_no" type="text" style="width:110px; text-transform:uppercase;" maxlength="14"  Onkeydown="onEnterKey(this)"   onBlur='javascript:this.value=this.value.toUpperCase();' ></td>
							<td width="90">Reference No.</td>
							<td><input name="ref_no" type="text" style="width:100px; text-transform:uppercase;" maxlength="50" Onkeydown="onEnterKey(this)"  onBlur='javascript:this.value=this.value.toUpperCase();' ></td>

						</tr>
					</table>
				</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->


    	<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
		<form name="form" action="ESD_SCE_0002Search.do" method="post">
		<!--  input type="hidden" name="cop_no"-->
		<input type="hidden" name="row_size" value="<%=pageRows%>">
		<!--
<%//		for(int i=0; i<dataSet.getSize(); i++){  %>

		<input type="hidden" name="<%//=dataSet.getName(i)%>" value="<%//dataSet.getString(i)%>">
<%//}%>
-->
				<tr><td class="btn1_bg">

						<table border="0" cellpadding="0" cellspacing="0">
						<tr>

<%
	// - CSR:N200903230050
	//    * user Add ID : hjse06310
	// - CSR:N200904100050
	//    * user Add ID : dalfano
	//2010.02.02  CHM-201002482  MSfunction(UserID : 0810240) add
	//2010.04.16  2002701, 2007510, 9009633  add
	//if("system1".equals(userId) || "0060442".equals(userId) || "0110062".equals(userId) || "04900035".equals(userId) || "hjse09182".equals(userId) || "hjse06310".equals(userId)  || "dalfano".equals(userId) ) {
	if("Y".equals(adm_flg)) { //* 2012-04-26 [CHM-201217462]
%>
	
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_mastersave" id="btn_mastersave" alt="Master Save">M / S</td><td class="btn1_right"></td></tr></table></td>
<% } %>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_statuschange" id="btn_statuschange" alt="Status Change">Status Change</td><td class="btn1_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_bkginfo" id="btn_bkginfo">BKG Info</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
<%
	if("Y".equals(adm_flg)) {
%>
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_copchange" id="btn_copchange">COP Change</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
<% } %>
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_history" id="btn_history">COP History</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
							<!-- Repeat Pattern -->

						</tr></table>

				</td></tr>
		</table>
		<!-- TABLE '#D' : ( Button : Main ) (E) -->


		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">
					<table class="height_10"><tr><td></td></tr></table>

					<!-- TABLE '#D' : ( Grid ) (S) -->
					<!-- 'HEAD1-BGCOLOR : 192 235 163' , 'HEAD2-BGCOLOR : 231 250 249' , 'BORDER : 90 138 158' , 'HEAD1-FONT : 0 83 116' , 'DATA GRID BG (2 colors) : 255 255 255, 249 249 249 ' -->
					<table width="100%" id="mainTable">
				       <tr><td>
				           <script language="javascript">ComSheetObject('sheet1');</script>
				       </td></tr>
				</table>
					<!-- TABLE '#D' : ( Grid ) (E) -->
				</td></tr>
		</form>
		<span id="new_form"></form>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
<table class="height_10"><tr><td></td></tr></table>


    </td></tr>
</table>
<!-- Outer Table (E)-->

</body>
</html>

