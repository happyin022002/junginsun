<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1033.jsp
*@FileTitle : Bangladesh Cargo Manifest
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.06
*@LastModifier : 전창현
*@LastVersion : 1.0
* 2009.10.06 전창현
* 1.0 Creation
=========================================================*/
%>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.bangladesh.event.EsmBkg1033Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1033Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id	= "";
	String strUsr_nm	= "";
	String strCnt_cd	= "";
	String strOfc_cd   	= "";
	
	String strBtnChk = "";
	
	String strPgmNo		= "";
	//boolean saveCsvFlg  = false;  // Save CSV 버튼 활성화여부
	Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strCnt_cd = account.getCnt_cd();
		strOfc_cd = account.getOfc_cd();
	   
		event = (EsmBkg1033Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        strPgmNo = request.getParameter("pgmNo");
        //strTransMode = event.getTransMode();
				
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<html>
<head>
<title>Delivery Mode</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
 	var pgmno= "<%=strPgmNo.substring(13)%>";
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
<form name="form"> 
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="btn_chk" value="<%=strBtnChk%>">
<input type="hidden" name="pgm_no" value="<%=strPgmNo%>">
<input type="hidden" name="io_flag">
<input type="hidden" name="data_flag">
<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr>
		<td valign="top">

		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->
	
	
        <!--biz page (S)-->
        <table class="search" id="mainTable"> 
            <tr><td class="bg">

				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
				<td width="200"><table class="search_sm2" border="0" style="width:190;"> 
					<tr class="h23">
					<td width="30">Data</td>
       				<td width="" class="stm"><input type="radio" name="data_type" value="B" class="trans" checked>&nbsp;&nbsp;B/L List&nbsp;
											 <input type="radio" name="data_type" value="D" class="trans">D/L List</td>
					</tr>
					</table>
				</td>	
				<td width="30">VVD</td>
				<td width="100"><input type="text" style="width:90;ime-mode:disabled" class="input1" name="vvd" dataformat="eng" maxlength="9" required caption="VVD"></td>		
				<td width="30">POL</td>
				<%
       				if(strPgmNo.endsWith("01")){
       			%>
					<td width="100"><input type="text" style="width:50;ime-mode:disabled" class="input1" name="pol_code" dataformat="engupnum" maxlength="5" required caption="POL">
									<input type="text" style="width:30;ime-mode:disabled" class="input" name="pol_yd" dataformat="engnum" maxlength="2" caption="pol_yd"></td>
				<%    
		    		}else{
       			%>
					<td width="100"><input type="text" style="width:50;ime-mode:disabled" class="input" name="pol_code" dataformat="engupnum" maxlength="5" caption="pol_cd">
									<input type="text" style="width:30;ime-mode:disabled" class="input" name="pol_yd" dataformat="engnum" maxlength="2" caption="pol_yd"></td>
       			<%  }
       			%>
       			<td width="30">POD</td>
       			<%
       				if(strPgmNo.endsWith("01")){
       			%>
					<td width="100"><input type="text" style="width:50;ime-mode:disabled" class="input" name="pod_code" dataformat="engupnum" maxlength="5" caption="pod_cd">
									<input type="text" style="width:30;ime-mode:disabled" class="input" name="pod_yd" dataformat="engnum" maxlength="2" caption="pod_yd"></td>
				<%    
		    		}else{
       			%>
					<td width="100"><input type="text" style="width:50;ime-mode:disabled" class="input1" name="pod_code" dataformat="engupnum" maxlength="5" required caption="POD">
									<input type="text" style="width:30;ime-mode:disabled" class="input" name="pod_yd" dataformat="engnum" maxlength="2" caption="pod_yd"></td>
       			<%  }
       			%>
				<td width="240"><table class="search_sm2" border="0" style="width:230;"> 
					<tr class="h23">
					<td width="77">Cargo Type</td>
					<td width="" class="stm"><input type="radio" name="bkg_cgo_tp_code" value="A" class="trans">All&nbsp;
											 <input type="radio" name="bkg_cgo_tp_code" value="F" class="trans" checked>Full&nbsp;
											 <input type="radio" name="bkg_cgo_tp_code" value="P" class="trans">&nbsp;Empty</td>
					</tr>
					</table>
				</td>
				<td width="60">B/L No.</td>
				<td width=""><input type="text" style="width:100;ime-mode:disabled" class="input" name="bl_no" dataformat="eng" maxlength="13" caption="bl_no"></td>		
				</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
				<td width="75">&nbsp;Sailed Year</td>
				<td width="110"><input type="text" style="width:80;ime-mode:disabled" name="sail_dt" dataformat="ymd" class="input" maxlength="10">
				                <img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_Sailed">
				</td>		
				<td width="103"><table width="77" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Assign">Assign</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				<td width="76">Vessel Name</td>
				<td width="98"><input type="text" style="width:90;ime-mode:disabled" class="input" name="vsl_nm" dataformat="engup" caption="vsl_nm" disabled></td>
				<td width="54">Voy. No.</td>
				<td width="77"><input type="text" style="width:40" class="input" name="voy_no" catpion="voy_no" disabled></td>	
				<%
       				if(strPgmNo.endsWith("01")){
       			%>
					<td width="124">Export Rot Number</td>
				<%    
		    		}else{
       			%>
       				<td width="124">Import Rot Number</td>
       			<%  }
       			%>
				<td width="115"><input type="text" style="width:100;ime-mode:disabled" class="input" name="rot_no" maxlength="14" caption="rot_no"></td>		
				<td width="65">MLO Code</td>
				<td width=""><input type="text" style="width:90;ime-mode:disabled" lass="input" name="mlo_cd" dataformat="eng" maxlength="11" caption="mlo_cd"></td>		
				</tr>
				</table>
				<!--  biz_1   (E) -->
				</td></tr>
			</table>
			<table class="height_8"><tr><td></td></tr></table>
			
		<!-- Grid BG Box  (S) -->
     	<table width="100%" class="search" id="mainTable">
       	<%
       		if(strPgmNo.endsWith("01")){
       	%>
            <tr><td class="bg">
			<!-- Mode Outbound ====================-->
				<!-- Grid  (S) -->
                <table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet4');</script>
						</td>
					</tr>
				</table> 			
			    <!-- Grid (E) -->    
            </td></tr>
		<%    
		    }else{
       	%>
            <tr><td class="bg">
			<!-- Mode Inbound  ====================-->
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet3');</script>
						</td>
					</tr>
				</table> 			
			    <!-- Grid (E) -->	
            </td></tr>
		<%  }
       	%>
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
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DownExcel">EDI File Download</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_PopUp">Freight Forward License</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td> 
					<td class="btn1" name="btn_Transmit">EDI Transmit</td>
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
	
<!-- 본문끝 -->

<!-- 개발자 작업  끝 -->
</form>
<iframe name="download" id="download" style="display:none;width:1px;height:1px;"></iframe>
</body>
</html>
