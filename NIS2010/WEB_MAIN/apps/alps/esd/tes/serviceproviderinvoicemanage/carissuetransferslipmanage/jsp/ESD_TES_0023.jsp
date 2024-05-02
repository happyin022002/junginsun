<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_0023.jsp
*@FileTitle : Terminal invoice CSR Creation - Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-18
*@LastModifier : jongbaemoon
*@LastVersion : 1.0
* 2006-12-18 jongbaemoon
* 1.0 최초 생성
=========================================================*/ 
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.event.EsdTes0023Event"%>
<%
	EsdTes0023Event  event = null;				//PDTO(Data Transfer Object including Parameters)
//	ESD_TES_0023EventResponse eventResponse = null;	//RDTO(Data Transfer Object including DB ResultSet)
	Exception serverException   = null;			//서버에서 발생한 에러
//	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수
		
	String ofc_cd  = "";
	String cnt_cd = "";

	/**	2013-03-05 CSR Creation 화면에서 이동해 왔을 경우 Main버튼을 통해 다시 CSR Creation 화면으로 돌아갔을때 이전 조회 조건들로 자동 조회하기 위함 **/
	String pre_cond_inv_ofc_cd	  = request.getParameter("pre_cond_inv_ofc_cd")!=null&&!request.getParameter("pre_cond_inv_ofc_cd").trim().equals("")?request.getParameter("pre_cond_inv_ofc_cd"):"";
	String pre_cond_inv_cfm_dt	  = request.getParameter("pre_cond_inv_cfm_dt")!=null&&!request.getParameter("pre_cond_inv_cfm_dt").trim().equals("")?request.getParameter("pre_cond_inv_cfm_dt"):"";
	String pre_cond_vndr_seq 	  = request.getParameter("pre_cond_vndr_seq")  !=null&&!request.getParameter("pre_cond_vndr_seq").trim().equals("")?request.getParameter("pre_cond_vndr_seq"):"";
	String pre_cond_vndr_seq_name = request.getParameter("pre_cond_vndr_seq_name")!=null&&!request.getParameter("pre_cond_vndr_seq_name").trim().equals("")?request.getParameter("pre_cond_vndr_seq_name"):"";
	try {
 
	   SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   //userId=account.getUsr_id();
	   //userAuth=account.getAuth();
	   ofc_cd=account.getOfc_cd(); 
	   cnt_cd =account.getCnt_cd();  
	   
		event = (EsdTes0023Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
/*			
	eventResponse = (ESD_TES_0023EventResponse)request.getAttribute("EventResponse");
	if (eventResponse != null) {
		rowSet = eventResponse.getRs();
		if(rowSet != null){
	 rowCount = rowSet.getRowCount();
		} // end if
	} // end if
*/	
		} // end else
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Terminal invoice CSR Creation - Summary</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	var cnt_cd = "<%=cnt_cd%>";
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
		document.form.inv_ofc_cd.focus();
	}
</script>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="sel_ofc_cd">
<input type="hidden" name="is_valid_vndr_seq">
<input type="hidden" name="vndr_seq_hidden">

<!--	2013-03-05 CSR Creation 화면에서 이동해 왔을 경우 Main 버튼을 통해 다시 CSR Creation 화면으로 돌아갔을때 이전 조회 조건들로 자동 조회하기 위함 -->
<input name="pre_cond_inv_ofc_cd"      type="hidden" value="<%=JSPUtil.getNull(pre_cond_inv_ofc_cd)%>">
<input name="pre_cond_inv_cfm_dt"      type="hidden" value="<%=JSPUtil.getNull(pre_cond_inv_cfm_dt)%>">
<input name="pre_cond_vndr_seq"   	   type="hidden" value="<%=JSPUtil.getNull(pre_cond_vndr_seq)%>">
<input name="pre_cond_vndr_seq_name"   type="hidden" value="<%=JSPUtil.getNull(pre_cond_vndr_seq_name)%>">

<!-- TABLE '#C' : ( Left Menu : Round Frame ) (S) -->
<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>


		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) >
	     	<table width="100%" class="title">
		       	<tr><td class="history"><img src="/hanjin/img/ico_hystory.gif" width="8" height="9" align="absmiddle">SVC Delivery System > Terminal System</td>
		       	</tr>
			<tr>
			<td class="title"><img src="/hanjin/img/ico_t1.gif" width="20" height="12"> CSR Creation</td>
			</tr>
		</table>

		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
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
			<tr>
				<td class="bg">
					<!-- : ( Week ) (S) -->
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="105"><img class="nostar">Invoice Office</td>
							<td width="95">&nbsp;<input name="inv_ofc_cd" type="text" maxlength="6" style="width:80" value="<%=ofc_cd%>" onkeypress="enter();" class="input1" readonly></td>
							<td width="105">Confirmed Date</td>
							<td width="105"><input name="inv_cfm_dt" type="text" maxlength="10" style="width:75" value="" onKeyUp='isNum1(this);tes_isNumD(this,"Y");' onKeyDown='tes_chkInput(this);tes_isNumD(this,"Y");' onBlur='isDate1(this);' onkeypress="enter();">&nbsp;<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar1" onkeypress="enter();"></td>
							<td width="65">Interface</td>
							<td class="stm" width=""><input type="radio" name="asanogb" value="A/P" class="trans" checked onkeypress="enter();">To A/P&nbsp;<input type="radio" name="asanogb" value="ASA" class="trans" onkeypress="enter();" disabled>To ASA</td>
							<%if(ofc_cd!=null && (ofc_cd.trim().equals("SZPSC")||ofc_cd.trim().equals("CANSO"))){ //2015-08-03 그룹사 조직 코드 변경 (SZPBB->SZPSC,CANBS->CANSO)%>	
							<td width="100">Payment Group</td>
							<td class="stm"><input type="radio" name="pay_group_cd" value="RHQ" class="trans" onkeypress="enter();" disabled>For RHQ Payment&nbsp;<input type="radio" name="pay_group_cd" value="Branch" class="trans" onkeypress="enter();" disabled>For Branch Payment</td>
							<%} else {%>
							<td width=""></td>
							<td class="stm"></td>
							<%}%>
						</tr>
						<tr>
							<table border="0">
								<tr class="h23">
									<td width="105"><img class="nostar">Payment S/P</td>
									<td>&nbsp;<input name="vndr_seq" type="text" maxlength="6" style="width:80" value="" onKeyUp='isNum(this);' onKeyDown='tes_chkInput(this);' onBlur=' this.value=tes_lpad(this.value,this.maxLength,"0"); validateVendorCode();' onkeypress="enter();"> <img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_vndr">&nbsp;<input name="vndr_seq_name" type="text" style="width:670" readOnly onkeypress="enter();"></td>
								</tr>
							</table>
						</tr>
					</table>
					<!-- : ( Week ) (E) -->
				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : ) (E) -->


		<table class="height_10"><tr><td></td></tr></table>



		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">


					<!-- : ( Grid : Week ) (S) -->
					<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' , 'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->
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
									<tr><td class="btn2_left"></td><td class="btn2" name="btng_detail" id="btng_detail">Detail</td>
									<td class="btn2_right"></td></tr></table>
									</td>
									<!-- Repeat Pattern -->
								</tr>
							</table>
						</td></tr>
					</table>
					<!-- : ( Button : Sub ) (E) -->
				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
		<!-- ####### TABLE '#D' ::: 'RIGHT' FRAME (END) ####### -->


</td></tr>
</table>
<!-- Outer Table (E)-->

</form>
</body>
</html>

<DIV style="display:none">
	<table width="100%" id="mainTable">
		<tr><td>
		<script language="javascript">ComSheetObject('sheet2');</script>
		</td></tr>
	</table>
</DIV>