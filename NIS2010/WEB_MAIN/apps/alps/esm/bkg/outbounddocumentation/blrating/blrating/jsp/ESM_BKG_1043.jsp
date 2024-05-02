<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1043.jsp
*@FileTitle : Container Rate
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.04
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.09.04 김영출
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.event.EsmBkg1043Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1043Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.BlRating.BlRating");

	// search Init
	String bkgNo      = "";
	String blNo       = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg1043Event)request.getAttribute("Event");
		bkgNo      = event.getBkgNo();
		blNo       = event.getBlNo();
				
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
<title>Container Rate</title>
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

<!-- 
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
-->
		<!--Page Title, Historical (S)-->
		<!--table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle">&nbsp;M&amp;R >> Equipment Repair Approval Authority Creation</td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Container Rate
			</td></tr>
		</table-->
        <!-- table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
            <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
            <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
        </table -->		
		<!--Page Title, Historical (E)-->
	
	
		<!--Button (S) -->
		
    	<!--Button (E) -->
		
		<!--biz page (S)-->
<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp" %>
				
		<table class="search" style="width:979;"> 
			<tr><td class="bg">	
    		<table class="search" border="0"> 
			<tr class="h23">
    			<td width="740">
				<table class="search" border="0" width="100%"> 
				<tr class="h23">
				<td width="55">BKG No.</td>
				<td width="225"><input type="text" name="bkg_no" value="<%=bkgNo%>" style="ime-mode:disabled;width:120;" dataformat="engupnum" class="input1">
				<img class="cursor" src="img/btns_inquiry.gif" width="19" height="20" border="0" align="absmiddle" name="btn_splitPop">
				</td>
				<td width="55">B/L No.</td>
				<td width="150"><input type="text" name="bl_no" value="<%=blNo%>" style="ime-mode:disabled;width:114;" dataformat="engupnum" class="input"></td>
				<td width="105">Application Date</td>
				<td width=""><input type="text" name="rt_aply_dt" style="ime-mode:disabled;width:82;" class="input2"></td>
				</tr>
				</table> 
				<table class="search" border="0" width="100%"> 
				<tr class="h23">
				<td width="54">T/VVD</td>
				<td width="145"><input type="text" name="vvd" style="ime-mode:disabled;width:100;" dataformat="engupnum" class="input2"></td>
				<td width="35">Route</td>
				<td width="250"><input type="text" name="por_cd" style="ime-mode:disabled;width:50;" dataformat="engupnum" class="input2">&nbsp;<input type="text" name="pol_cd" style="ime-mode:disabled;width:50;" dataformat="engupnum" class="input2">&nbsp;<input type="text" name="pod_cd" style="ime-mode:disabled;width:50;" dataformat="engupnum" class="input2">&nbsp;<input type="text" name="del_cd" style="ime-mode:disabled;width:50;" dataformat="engupnum" class="input2"></td>
				<td width="70">PRE/POST</td>
				<td width=""><input type="text" name="pre_rly_port_cd" style="ime-mode:disabled;width:50;" dataformat="engupnum" class="input2"> / <input type="text" name="pst_rly_port_cd" style="ime-mode:disabled;width:50;" dataformat="engupnum" class="input2"></td>
				</tr>
				</table> 
				<table class="search" border="0" width="100%"> 
				<tr class="h23">
				<td width="54">SHPR</td>
				<td width="432"><input type="text" name="shpr_cd" style="ime-mode:disabled;width:100;" dataformat="engupnumspc" class="input2">&nbsp;<input type="text" name="shpr_nm" style="ime-mode:disabled;width:291;" dataformat="engupnumspc" class="input2"></td>
				<td width="95">Contract No.</td>
				<td width=""><input type="text" name="contract_no" style="ime-mode:disabled;width:91;" dataformat="engupnum" class="input2"></td>
				</tr>
				</table> 
				<table class="search" border="0" width="100%"> 
				<tr class="h23">
				<td width="54">CNEE</td>
				<td width="432"><input type="text" name="cnee_cd" style="ime-mode:disabled;width:100;" dataformat="engupnumspc" class="input2">&nbsp;<input type="text" name="cnee_nm" style="ime-mode:disabled;width:291;" dataformat="engupnumspc" class="input2"></td>
				<td width="95">Customs Desc.</td>
				<td width=""><input type="text" name="cstms_desc" style="ime-mode:disabled;width:91;" dataformat="engupnumspc" class="input2"></td>
				</tr>
				</table> 
				<table class="search" border="0" width="100%"> 
				<tr class="h23">
				<td width="54">Bill Type</td>
				<td width="110"><input type="text" name="rt_bl_tp_cd" style="ime-mode:disabled;width:30;" dataformat="engupnum" class="input2"></td>
				<td width="75" id="td_cvrd_text">Covered By</td>
				<td width=""><input type="text" name="mst_cvrd_bl_no" style="ime-mode:disabled;width:112;" dataformat="engupnum" class="input2">&nbsp;<img class="cursor" name="btn_findCovered" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
				</tr>
				</table> 
			</td>
			<td width="239" valign="top">
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>			
				<!-- Grid (E) -->
				
				<!--table border="0" style="width:100%; background-color:white;" class="grid2"> 
				<tr class="tr2_head">
					<td width="45%">TP/SZ</td>
					<td width="%">CNTR Q’ty</td>
				</tr>
				<tr class="input2">
					<td width="%">D2</td>
					<td width="%">1.00</td>
				</tr>
				<tr class="input2">
					<td width="%">D4</td>
					<td width="%">2.00</td>
				</tr>
				<tr class="input2">
					<td width="%"></td>
					<td width="%"></td>
				</tr>
				<tr class="input2">
					<td width="%"></td>
					<td width="%"></td>
				</tr>
				</table-->

			</td></tr>
		</table>
		<!--biz page (E)-->
		<table class="height_8"><tr><td></td></tr></table>
		<!--biz page (S)-->

			<!-- Grid  (S) -->
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet2');</script>
					</td>
				</tr>
			</table>			
			<!-- Grid (E) -->
				
			<!--  Button_Sub (S) -->
			<!--
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_add">Row&nbsp;Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_del">Delete</td>
						<td class="btn2_right"></td>

						</tr>
						</table></td>
						
					</tr></table>
			</td></tr>
			</table>
			-->
	    	<!-- Button_Sub (E) -->
			
			
			<!-- Grid  (S) -->
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet3');</script>
					</td>
				</tr>
			</table>			
			<!-- Grid (E) -->
			
			<!-- Grid  (S) -->
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet4');</script>
					</td>
				</tr>
			</table>			
			<!-- Grid (E) -->
						
	    <table class="height_8"><tr><td></td></tr></table>
		
		<table border="0" style="width:979;" class="search"> 
			<tr class="h23">
    			<td width="240">
    				<table border="0" class="grid2"> 
					<tr>
						<td width="40" rowspan="2" class="tr2_head">PPD</td>
						<td width="50" class="tr2_head">Total</td>
						<td width="150" height="48" style="text-indent:0px;"><div id="pn_amt_layer" style="width:150;height:48;overflow:auto;"></div></td>
					</tr>
					<tr>
						<td class="tr2_head">At</td>
						<td height="16" style="text-indent:0px;"><div id="pn_ofc_layer" style="width:150;height:24;overflow:hidden;"></div></td>
					</tr>
					</table>
				</td>
				<td width="10"></td>
				<td width="240">
    				<table border="0" class="grid2"> 
					<tr>
						<td width="40" rowspan="2" class="tr2_head">CCT</td>
						<td width="50" class="tr2_head">Total</td>
						<td width="150" height="48" style="text-indent:0px;"><div id="cn_amt_layer" style="width:150;height:48;overflow:auto;"></div></td>
					</tr>
					<tr>
						<td class="tr2_head">At</td>
						<td height="16" style="text-indent:0px;"><div id="cn_ofc_layer" style="width:150;height:24;overflow:hidden;"></div></td>
					</tr>
					</table>
				</td>
				<td width="10"></td>
				<td width="240">
    				<table border="0" class="grid2"> 
					<tr>
						<td width="40" rowspan="2" class="tr2_head">3RD</td>
						<td width="50" class="tr2_head">Total</td>
						<td width="150" height="48" style="text-indent:0px;"><div id="py_amt_layer" style="width:150;height:48;overflow:auto;"></div></td>
					</tr>
					<tr>
						<td class="tr2_head">At</td>
						<td height="16" style="text-indent:0px;"><div id="py_ofc_layer" style="width:150;height:24;overflow:hidden;"></div></td>
					</tr>
					</table>
				</td>
				<td width="10"></td>
				<td width="240">
    				<table border="0" class="grid2"> 
					<tr>
						<td width="40" rowspan="2" class="tr2_head">3RD</td>
						<td width="50" class="tr2_head">Total</td>
						<td width="150" height="48" style="text-indent:0px;"><div id="cy_amt_layer" style="width:150;height:48;overflow:auto;"></div></td>
					</tr>
					<tr>
						<td class="tr2_head">At</td>
						<td height="16" style="text-indent:0px;"><div id="cy_ofc_layer" style="width:150;height:24;overflow:hidden;"></div></td>
					</tr>
					</table>
				</td>
				</tr>
			</table>
			</td></tr>
		</table>
		<!--biz page (E)-->	

<!--Button (S) -->
		
    <!--Button (E) -->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_exchange">Exchange Rate</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<!--
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				-->
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_remark">Remark</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<!-- 
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_dist">Dist.</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				-->
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
  	</td></tr>
</table>

<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_CLOSE.jsp" %>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>