<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ui_bkg_0122.jsp
*@FileTitle : Wharfage Cargo Classification
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.01
*@LastModifier : OH DONG HYUN
*@LastVersion : 1.0
* 2009.04.24 정재엽
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.event.EsmBkg0122Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0122Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String sBound = "";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.wharfagemgt.wharfagedecmgt");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0122Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		sBound = (request.getParameter("bound")==null) ? "" : request.getParameter("bound");
		// Inbound / Outbound 메뉴가 다르기 때문
			String sPgmNo = (request.getParameter("pgmNo")==null) ? "" : request.getParameter("pgmNo");
		if ("".equals(sBound)) {
			if (sPgmNo.length() == 12) {
				sBound = "I";
			} else {
				sBound = "O";
			}
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
%>

<html>
<head>
<title>Wharfage Cargo Classification</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="frm_attr_ctnt2">
<input type="hidden" name="kr_whf_cntr_20ft_rt">
<input type="hidden" name="kr_whf_cntr_40ft_rt">
<input type="hidden" name="kr_whf_cntr_45ft_rt">
<input type="hidden" name="kr_whf_blk_rt">
<input type="hidden" name="rton_wgt" >
<input type="hidden" name="expt_ton_wgt" >	

<!-- 개발자 작업	-->
<%
	String keyAddr     = (request.getParameter("keyAddr") == null)? "":request.getParameter("keyAddr");
%>

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
		
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title">&nbsp;Wharfage Cargo Classification</span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->
	
		<!--biz page (S)-->
		
		<!-- Grid BG Box  (S) -->
     	<table class="search" id="mainTable">
       	<tr><td class="bg">
			<!--  biz_2  (S) -->
			
			<table border="0" style="width:990;" class="search"> 
				<tr class="h23">
				<td width="30">VVD</td>
				<td width="95"><input type="text" style="width:77;ime-mode:disabled" class="input1" name="vvd" dataformat="ennum" maxlength="9" onkeyup="condition_KeyUp()" ></td>
				<td width="35">Port</td>
				<td width="65">
					<input type="text" style="width:49;ime-mode:disabled" class="input1" name="port_cd"  dataformat="ennup" maxlength="5" onkeyup="condition_KeyUp()">
				</td>
				<td width="35">Bound</td>
				<td width="155">
					<select style="width:140;" class="input1" name="whf_bnd_cd" onchange="searcgBySelect()">
						<option value="II">II – Inbound Import</option>
						<option value="IN" <%if("I".equals(sBound)) out.println("selected");%>>IN – Inbound </option>
						<option value="IT">IT – Inbound T/S</option>
						<option value="IM">IM – Inbound MT</option>
						<option value="OO" <%if("O".equals(sBound)) out.println("selected");%>>OO – Outbound Export </option>
						<option value="ON">ON – Outbound</option>
						<option value="OT">OT – Outbound T/S</option>
						<option value="OM">OM – Outbound MT</option>
					</select>
				</td>
				<td width="40"><table border="0" style="width:40;" class="search_sm2"> 
					<tr class="h23">
					<td width="">&nbsp;D/C&nbsp;&nbsp;<input type="checkbox" class="trans" name="dc_flg" disabled="disabled"></td>
					</tr>
					</table></td>
				<td width="70">&nbsp;MRN No.</td>
				<td width="100"><input type="text" style="width:90;" class="input2" name="mf_ref_no" maxlength="22" readonly="readonly" ></td>
				<td width="90">Sailing Date</td>
				<td width="90"><input type="text" style="width:75;" class="input2" name="sail_dt" maxlength="10" dataformat="ymd" readonly="readonly" ></td>
				<td width="60">DEC No.</td>
				<td width=""><input type="text" style="width:155;" class="input2" name="whf_decl_no" maxlength="10" dataformat="ymd" readonly="readonly"></td>
				</tr>
				</table>
				<!--  biz_2  (E) -->
<!--  Button_Sub (S) -->
			
	    	<!-- Button_Sub (E) -->
	
	<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
			
				<!-- Grid  (S) -->
				<table border="0" width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				
				<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
						<td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_add"> Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_del">Delete </td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_arif">AR I/F</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_blif">BL I/F</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_rateinquiry">Rate Inquiry</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_blcheck">BL Check</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_bkgcheck">Diff CHK</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
	    	<table class="height_10"><tr><td></td></tr></table>
				<!--  biz_2  (S) -->
			
			<table border="0" style="width:979;" class="search"> 
				<tr class="h23">
				<td width="110">Total B/L Count</td>
				<td width="120"><input type="text" style="width:100;text-align:right" class="input2" name="total_bl_count"></td>
				<td width="95">Total Wharfage</td>
				<td width="120"><input type="text" style="width:100;text-align:right" class="input2" name="total_wharfage"></td>
				<td width="88">Total Amount</td>
				<td width="130"><input type="text" style="width:100;text-align:right" class="input2" name="whf_rt_amt"></td>
				<td width="55">R/Total</td>
				<td width=""><input type="text" style="width:80;text-align:right" class="input2" name="rtotal1">&nbsp;
							 <input type="text" style="width:80;text-align:right" class="input2" name="rtotal2">&nbsp;
							 <input type="text" style="width:80;text-align:right" class="input2" name="rtotal3"></td>
					 
							 
				</tr>
				</table> 
			<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
			
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) -->
			</td></tr>
		</table>
		
	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->
	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	</td></tr>
		</table>


</form>
</body>
</html>