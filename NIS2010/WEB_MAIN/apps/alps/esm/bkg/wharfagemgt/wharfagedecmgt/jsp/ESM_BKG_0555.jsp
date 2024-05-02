<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ui_bkg_0555.jsp
*@FileTitle : ACI_Vessel Information
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 정재엽
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.event.EsmBkg0555Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0555Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd        = "";
	Logger log = Logger.getLogger("com.hanjin.apps.wharfagemgt.wharfagedecmgt");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EsmBkg0555Event)request.getAttribute("Event");
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
<title>Ancs ACI: Vessel Arrival Manifest (A6)</title>
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
<input type="hidden" name="ofc_cd" value="<%= strOfc_cd %>">

<!-- 개발자 작업	-->
<%
	String keyAddr     = (request.getParameter("keyAddr") == null)? "":request.getParameter("keyAddr");
%>


<!-- OUTER - POPUP (S)tart -->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">

	
	<tr><td valign="top">
	
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title">Wharfage Charge List</span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->
	
		<!--biz page (S)-->
		
				<!--  biz_1  (S) -->
				
				
				<!--  biz_1   (E) -->
				
			
		<!-- Tab ) (S) -->
     	
		<!-- Tab ) (E) -->
		
		<!-- Grid BG Box  (S) -->
     	<table class="search" id="mainTable">
       	<tr><td class="bg">
			<!--  biz_2  (S) -->
			
			<table border="0" style="width:979;" class="search"> 
				<tr class="h23">
				<td width="30">VVD</td>
				<td width="110"><input type="text" style="width:77;ime-mode:disabled" class="input1" name="vvd" dataformat="ennum" maxlength="9"></td>
				<td width="35">POL</td>
				<td width="90"><input type="text" style="width:49;ime-mode: disabled" class="input" name="pol_cd" dataformat="engupnum" maxlength="5"></td>
				<td width="35">POD</td>
				<td width="90"><input type="text" style="width:49;ime-mode: disabled" class="input" name="pod_cd" dataformat="engupnum" maxlength="5"></td>
				<td width="290">
					<table border="0" style="width:260;" class="search_sm"> 
					<tr><td width="55"><strong>Bound</strong></td>
					<td width="" class="" style="font-size:12;">
						<input type="radio" value="S"class="trans" checked="checked" name="bkg_cust_tp_cd">&nbsp;&nbsp;Outbound   &nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" value="C"class="trans" name="bkg_cust_tp_cd">&nbsp;&nbsp;Inbound</td>
					</tr>
					</table></td>
				<td width="54">Option</td>
				<td width="">
					<select style="width:100;" name="bkg_sts_cd">
						<option value="A" selected="selected">All</option>
						<option value="N">OFT (Incl.)</option>
						<option value="Y">EXEM</option>
						<option value="X">Not EXEM</option>
					</select>
				</td>
				</tr>
				</table>
				<!--  biz_2  (E) -->
<!--  Button_Sub (S) -->
			
	    	<!-- Button_Sub (E) -->
	
	<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
			<table border="0" style="width:979;" class="search"> 
				<tr class="h23">
				<td width="100%" class="stm"><input type="text" style="width='100%';height='100%';border='0px';text-align:left" class="input2" name="retrieve_info" maxlength="15" readonly="readonly"></td>
				</tr>
				</table>
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) -->
				<table border="0" style="width:979;" class="search"> 
				<tr class="h23">
					<td width="50">Rate</td>
					<td width="35">TEU :</td>
					<td width="90"><input type="text" style="width:50;text-align:right" class="input2" name="rt_teu" maxlength="15" readonly="readonly"></td>
					<td width="35">FEU :</td>
					<td width="90"><input type="text" style="width:50;text-align:right" class="input2" name="rt_feu" maxlength="15" readonly="readonly"></td>
					<td width="35">45FT  :</td>
					<td width="90"><input type="text" style="width:50;text-align:right" class="input2" name="rt_hcb" maxlength="15" readonly="readonly"></td>
					<td width="60">TTL AMT :</td>
					<td width="150"><input type="text" style="width:100;text-align:right" class="input2" name="ttl_amt" maxlength="15" readonly="readonly"></td>
					<td width="80">B/L Count :</td>
					<td width=""><input type="text" style="width:50;text-align:right" class="input2" name="bl_cnt" maxlength="4" readonly="readonly"></td>
				</tr>
				<tr class="h23">
					<td width="50">BKG</td>
					<td width="35">TEU :</td>
					<td width="90"><input type="text" style="width:50;text-align:right" class="input2" name="bkg_teu" maxlength="11" readonly="readonly"></td>
					<td width="35">FEU :</td>
					<td width="90"><input type="text" style="width:50;text-align:right" class="input2" name="bkg_feu" maxlength="11" readonly="readonly"></td>
					<td width="35">45FT  :</td>
					<td width="" colspan="5"><input type="text" style="width:50;text-align:right" class="input2" name="bkg_hcb" maxlength="11" readonly="readonly"></td>
	
				</tr>
				</table>
				<!--  biz_2  (S) -->
			
			
				<!--  Button_Sub (S) -->
			
	    	<!-- Button_Sub (E) -->
			<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
			
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
							<script language="javascript">ComSheetObject('sheet3');</script>
							<script language="javascript">ComSheetObject('sheet4');</script>
							<script language="javascript">ComSheetObject('sheet5');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) -->
				
				<table border="0" style="width:979;" class="search"> 
				<tr class="h23" align="right">
				<td width="">Confirm 담당자</td>
				<td width="210"><input type="text" style="width:114;" class="input2" name="cfm_usr_id">&nbsp;
				<input type="text" style="width:77;" class="input2" name="upd_dt"></td>
				</tr>
				</table>
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
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DownExcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Confirm">Confirm</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_SumPrint">Sum Print</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Print" >Print</td>
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
<!-- : ( Button : pop ) (E) -->
	

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>