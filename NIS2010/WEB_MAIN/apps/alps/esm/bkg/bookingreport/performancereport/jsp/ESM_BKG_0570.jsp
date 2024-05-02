<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0570.jsp
*@FileTitle : C/A B/L Inquery
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.28
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.09.28 강동윤
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0570Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0570Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String blNo				= "";
	String tabId			= "";
	Logger log = Logger.getLogger("com.hanjin.apps.BookingReport.PerformanceReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		
		blNo  = JSPUtil.getNull(request.getParameter("bl_no"));
		tabId = JSPUtil.getNull(request.getParameter("tab"));

		event = (EsmBkg0570Event)request.getAttribute("Event");
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
<title>C/A B/L Inquery</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		
		if ('<%= blNo %>' != ''){

			document.form.bl_no.value = '<%= blNo %>';
			
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			
			if ('<%= tabId %>' == '1'){
				tabObjects[0].SelectedIndex = 0;
			}else if ('<%= tabId %>' == '2'){
				tabObjects[0].SelectedIndex = 1;
			}else{
				tabObjects[0].SelectedIndex = 2;
			}
		}else{
		
			//document.form.bl_no.value = 'KWAA05385205';
		}
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->

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
						<td width="53">B/L No.</td>
						<td width="158"><input type="text" name="bl_no" dataformat="engupnum" maxlength="12" style="width:100;" class="input1" value="">&nbsp;<input type="text" style="width:25;" class="input2" value="" readonly></td>
						<td width="54">C/A No.</td>
						<td width="132"><input type="text" name="corr_no" style="width:100;" class="input2" value="" readonly></td>
						<td width="110">Customs Ref. No.</td>
						<td width="170"><input type="text" name="cust_ref_no" style="width:80;" class="input2" value="" readonly>&nbsp;<input type="text" style="width:35;" class="input2" value="" readonly></td>
						<td width="100">Empty&nbsp;&nbsp;<input type="checkbox" name="empty" class="input2" style="border:0;" readonly></td>
						<td width="50">Freight </td>
						<td width="72"><input type="text" name="frt_term_cd"style="width:35; text-align:center;" class="input2" value="" readonly></td>
						<td width="40">O_B/L </td>
						<td align="right"><input type="text" name="obl_iss_flg" style="width:35; text-align:center;" class="input2" value="" readonly></td>
					</tr>
					<tr><td colspan="11"><table class="line_bluedot"><tr><td colspan="6"></td></tr></table></td></tr>
				</table>
				
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="53">VVD</td>
						<td width="270"><input type="text" name="vvd" style="width:90;" class="input2" value="" readonly>&nbsp;<input type="text" name="vsl_eng_nm" style="width:140;" class="input2" value="" readonly></td>
						<td width="30">POD</td>
						<td width="95"><input type="text" name="pod_cd" style="width:60;" class="input2" value="" readonly></td>
						<td width="30">ETA</td>
						<td width="150"><input type="text" name="eta" style="width:110;" class="input2" value="" readonly></td>
						<td width="30">POL</td>
						<td width="95"><input type="text" name="pol_cd" style="width:60;" class="input2" value="" readonly></td>
						<td width="30">POR</td>
						<td width="100"><input type="text" name="por_cd" style="width:60;" class="input2" value="" readonly></td>
						<td width="30">DEL</td>
						<td align="right"><input type="text" name="del_cd" style="width:60;" class="input2" value="" readonly></td>
					</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="53">Q,ty</td>
						<td width="181"><input type="text" name="pck_qty" style="width:90; text-align:right;" class="input2" value="" readonly>&nbsp;<input type="text" name="pck_tp_cd" style="width:35;" class="input2" value="" readonly></td>
						<td width="30">WGT</td>
						<td width="184"><input type="text" name="act_wgt" style="width:110; text-align:right;" class="input2" value="" readonly>&nbsp;<input type="text" name="wgt_ut_cd" style="width:35;" class="input2" value="" readonly></td>
						<td width="30">MEA</td>
						<td width="188"><input type="text" name="meas_qty" style="width:110; text-align:right;" class="input2" value="" readonly>&nbsp;<input type="text" name="meas_ut_cd" style="width:35;" class="input2" value="" readonly></td>
						<td width="70">Description</td>
						<td align="right"><input type="text" name="cus_desc" style="width:235;" class="input2" length ='20' value="" readonly></td>
					</tr>
				</table>
				<!--  biz_1   (E) -->		
			
		</td></tr></table>
		<table class="height_8"><tr><td></td></tr></table>	


		<!-- Tab (S) -->
     		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%>
       		<tr><td width="100%">
						<script language="javascript">ComTabObject('tab1')</script>
						<!-- img src="/img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
					</td></tr>
				</table>
		<!-- Tab (E) -->

<!--TAB Customer (S) -->
<div id="tabLayer" style="display:inline">

		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
			
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;">
				<tr class="h23"width="100%">
		 			<td width="65">Shipper</td>
					<td><input type="text" name="s_cnt_cd" style="width:25;" class="input2" value="" readonly>&nbsp;<input type="text" name="s_seq" style="width:80;" class="input2" value="" readonly></td></tr>
				</table>
				<table class="search_sm" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="6%" rowspan="2" class="stm">Name</td>
						<td width="46%" rowspan="2"><textarea  name="s_nm" style="width:405; height:76;" class="textarea2" readonly></textarea></td>
						<td width="6%" class="stm">Address</td>
						<td width="" colspan="3" align="right"><textarea name="s_addr" style="width:405; height:50;" class="textarea2" readonly></textarea></td>
					</tr>			
					<tr class="h23">
						<td width="" class="stm">Tel.</td>
						<td width="250" style="padding-left:1;"><input type="text" name="s_tel" style="width:150;" class="input2" value="" readonly></td>
						<td width="40" class="stm">Fax</td>
						<td width="" align="right"><input type="text" name="s_fax" style="width:150;" class="input2" value="" readonly></td>
					</tr>
				</table>
				<!--  biz_1  (E) -->
				<table class="height_8"><tr><td></td></tr></table>
			
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;">
				<tr class="h23"width="100%">
		 			<td width="65">Consignee</td>
					<td><input type="text" name="c_cnt_cd" style="width:25;" class="input2" value="" readonly>&nbsp;<input type="text" name="c_seq" style="width:80;" class="input2" value="" readonly></td></tr>
				</table>
				<table class="search_sm" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="6%" rowspan="2" class="stm">Name</td>
						<td width="46%" rowspan="2"><textarea  name="c_nm" style="width:405; height:76;" class="textarea2" readonly></textarea></td>
						<td width="6%" class="stm">Address</td>
						<td width="" colspan="3" align="right"><textarea name="c_addr" style="width:405; height:50;" class="textarea2" readonly></textarea></td>
					</tr>			
					<tr class="h23">
						<td width="" class="stm">Tel.</td>
						<td width="250" style="padding-left:1;"><input type="text" name="c_tel" style="width:150;" class="input2" value="" readonly></td>
						<td width="40" class="stm">Fax</td>
						<td width="" align="right"><input type="text" name="c_fax" style="width:150;" class="input2" value="" readonly></td>
					</tr>
				</table>
				<!--  biz_1  (E) -->
				<table class="height_8"><tr><td></td></tr></table>
			
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;">
				<tr class="h23"width="100%">
		 			<td width="65">Notify</td>
					<td><input type="text" name="n_cnt_cd" style="width:25;" class="input2" value="" readonly>&nbsp;<input type="text" name="n_seq" style="width:80;" class="input2" value="" readonly></td></tr>
				</table>
				<table class="search_sm" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="6%" rowspan="2" class="stm">Name</td>
						<td width="46%" rowspan="2"><textarea  name="n_nm" style="width:405; height:76;" class="textarea2" readonly></textarea></td>
						<td width="6%" class="stm">Address</td>
						<td width="" colspan="3" align="right"><textarea name="n_addr" style="width:405; height:50;" class="textarea2" readonly></textarea></td>
					</tr>			
					<tr class="h23">
						<td width="" class="stm">Tel.</td>
						<td width="250" style="padding-left:1;"><input type="text" name="n_tel" style="width:150;" class="input2" value="" readonly></td>
						<td width="40" class="stm">Fax</td>
						<td width="" align="right"><input type="text" name="n_fax" style="width:150;" class="input2" value="" readonly></td>
					</tr>
				</table>
				<!--  biz_1  (E) -->
			
			</td></tr>
		</table>
		<!--biz page (E)-->

</div>
<!--TAB Customer (E) -->


<!--TAB Marks & Desc (S) -->
<div id="tabLayer" style="display:none">

		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
			
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="35">Seq.</td>
					<td width="100"><select name="mk_seq" style="width:60;" class="input2" onChange="javascript:changeMkSeq();">
						</select></td>
					<td width="65">Local/TS</td>
					<td><!-- select name="loc_ts" style="width:80;" class="input2">
						</select-->
						<input type="text" name="loc_ts" style="width:60;" class="input2" value="" readonly>
					</td>
					</tr>
				</table>
				<table class="height_5"><tr><td></td></tr></table>
				
				<table border="0" style="width:100%; background-color:white;" class="grid2"> 
				<tr><td width="30%" class="tr2_head">MARKS &amp; No.</td>
					<td class="tr2_head">DESCRIPTION</td></tr>
				<tr><td><textarea name="mk_desc" style="width:100%; height:200;" class="input2" readonly></textarea></td>
					<td><textarea name="cmdt_desc" style="width:100%; height:200;" class="input2" readonly></textarea></td></tr>
				</table>
				<!--  biz_1  (E) -->
						

			
			</td></tr>
		</table>

</div>
<!--TAB Marks & Desc (E) -->


<!--TAB CNTR Inquiry (S) -->
<div id="tabLayer" style="display:none">

		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
			
			
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t3sheet1');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->	
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t3sheet2');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->	
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t3sheet3');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->	
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t3sheet4');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->			

			
			</td></tr>
		</table>

</div>
<!--TAB CNTR Inquiry (E) -->
	
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
				</table></td></tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>