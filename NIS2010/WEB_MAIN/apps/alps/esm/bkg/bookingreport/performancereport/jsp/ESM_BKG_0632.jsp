<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0632.jsp
*@FileTitle : Sales Performance Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.01
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.09.01 강동윤
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0632Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0632Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.BookingReport.PerformanceReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0632Event)request.getAttribute("Event");
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
<title>Sales Performance Report</title>
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
						<td width="40">T/VVD</td>						
						<td width="300"><input type="text" name="vvd_sig" dataformat="engupnum" maxlength="9" class="input" style="width:80;" value="" onChange="javascript:searchLane(this);">&nbsp;<input type="text" name="slan_cd" dataformat="engup" maxlength="3" class="input2" style="width:35;" value="" readonly>&nbsp;<input type="text" name="vvd_idx" dataformat="engup" maxlength="3" class="input2" style="width:18;" value="" readonly>&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" onClick="javascript:getVvds();">&nbsp;<script language="javascript">ComComboObject('vvd', 1, 100, true, '');</script></td>
						<td width="74">Cargo Type</td>
						<td width="60"><script language="javascript">ComComboObject('bkg_cgo_tp_cd', 2, 40, true, '');</script></td>
						<td width="60">Customer</td>
						<td width="250"><select name="bkg_cust_tp_cd" style="width:45;" class="input">
							<option value="S" selected>SH</option>
							<option value="C">CN</option>
							<option value="N">NT</option>
							<option value="">ALL</option>
							</select>&nbsp;<input type="text" name="cust_cnt_cd" dataformat="engup" maxlength="2" class="input" style="width:30;" value="">&nbsp;<input type="text" name="cust_seq" dataformat="int" maxlength="6" class="input" style="width:40;" value="">&nbsp;<input type="text" name="cust_nm" class="input" style="width:100;" value=""></td>
						<td width="80">Cuntract No.</td>
						<td align=""><select name="cuntract_tp" style="width:70;" class="input2">
							<option value="A" selected>S/C NO</option>
							<option value="B">RFA NO</option>
							</select>&nbsp;<input type="text" name="cuntract_no" class="input" style="width:60;" value="" dataformat="engupnum"></td>
					</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="35">B/POL</td>
						<td width="55"><input type="text" name="pol_cd" dataformat="engupnum" maxlength="5" class="input" style="width:45;" value=""></td>
						<td width="40">B/POD</td>
						<td width="55"><input type="text" name="pod_cd" dataformat="engupnum" maxlength="5" class="input" style="width:45;" value=""></td>
						<td width="25">POR</td>
						<td width="55"><input type="text" name="por_cd" dataformat="engupnum" maxlength="5" class="input" style="width:45;" value=""></td>
						<td width="25">DEL</td>
						<td width="55"><input type="text" name="del_cd" dataformat="engupnum" maxlength="5" class="input" style="width:45;" value=""></td>
						<td width="60">Commodity</td>
						<td width="105"><input type="text" name="rep_cmdt_cd" dataformat="int" maxlength="4" class="input" style="width:35;" value="">&nbsp;<input type="text" name="cmdt_cd" dataformat="int" maxlength="6" class="input" style="width:55;" value=""></td>
						<td width="265">
							
							<table class="search_sm2" border="0" style="width:255;"> 
								<tr class="h23">
									<td width="50">Special</td>
									<td width="" class="stm"><input type="checkbox" name="dcgo_flg" value="Y" class="trans">D/G&nbsp;<input type="checkbox" name="rc_flg" value="Y" class="trans">RF&nbsp;<input type="checkbox" name="awk_cgo_flg" value="Y" class="trans">AK&nbsp;<input type="checkbox" name="bb_cgo_flg" value="Y" class="trans">BB&nbsp;<input type="checkbox" name="rd_cgo_flg" value="Y" class="trans">RD</td>
								</tr>
							</table>
						
						</td>
						<td width="65">Load View</td>
						<td align=""><select name="load_view" style="width:150;" class="input">
							<option value="1" selected>Actual Load include Memo</option>
							<option value="0" >B/L exclude Memo</option>
							
							</select></td>
					</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="90">Booking Office</td>
						<td width="115" class="sm"><input type="text" name="bkg_ofc_cd" dataformat="engup" maxlength="6" class="input" style="width:50;" value=""><input type="checkbox" name="bkg_ofc_sub" value="Y" class="trans">Incl Sub</td>
						<td width="70">Sales Office</td>
						<td width="115" class="sm"><input type="text" name="ob_sls_ofc_cd" dataformat="engup" maxlength="6" class="input" style="width:50;" value=""><input type="checkbox" name="ob_sls_ofc_sub" value="Y" class="trans">Incl Sub</td>
						<td width="60">Sales Rep</td>
						<td width="55"><input type="text" name="ob_srep_cd" dataformat="engupnum" maxlength="6" class="input" style="width:45;" value=""></td>
						<td width="95">Contract Office</td>
						<td width="60"><input type="text" name="ctrt_ofc_cd" dataformat="engup" maxlength="6" class="input" style="width:50;" value=""></td>
						<td width="85">Contract Rep</td>
						<td width="55"><input type="text" name="ctrt_srep_cd" dataformat="engupnum" maxlength="6" class="input" style="width:45;" value=""></td>
						<td width="60">I/B Office</td>
						<td width="" class="sm"><input type="text" name="ib_sls_ofc_cd" dataformat="engup" maxlength="6" class="input" style="width:50;" value=""><input type="checkbox" name="ib_sls_ofc_sub" value="Y" class="trans">Incl Sub</td>
					</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="130">Service Route Origin</td>
						<td align="60"><script language="javascript">ComComboObject('org_rout_cd', 2, 50, true, '');</script></td>
						<td width="120">Service Route Dest</td>
						<td align="60"><script language="javascript">ComComboObject('dest_rout_cd', 2, 50, true, '');</script></td>
						<td width="125">Service Mode Origin</td>
						<td align="60"><script language="javascript">ComComboObject('org_svc_mod_cd', 2, 50, true, '');</script></td>
						<td width="115">Service Mode Dest</td>
						<td align="60"><script language="javascript">ComComboObject('dest_inlnd_svc_mod_cd', 2, 50, true, '');</script></td>
						<td width="90">Country Origin</td>
						<td width="40"><input type="text" name="org_cnt" dataformat="engup" maxlength="2" class="input" style="width:30;" value=""></td>
						<td width="85">Country Dest</td>
						<td width=""><input type="text" name="dest_cnt" dataformat="engup" maxlength="2" class="input" style="width:30;" value=""></td>
					</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="80">Report Kind</td>
						<td width="200"><script language="javascript">ComComboObject('rep_knd', 1, 180, 0, true, '');</script></td>
						<td width="60">Group By</td>
						<td width="212"><script language="javascript">ComComboObject('grp_by', 1, 200, 0, true, '');</script></td>
						<td width="80">Freight Term</td>
						<td width="95"><select name="frt_term_cd" style="width:85;" class="input">
							<option value="" selected>All</option>
							<option value="P">Prepaid</option>
							<option value="C">Collect</option>
							</select></td>
						<td width="">
							<table class="search_sm2" border="0" style="width:246;"> 
								<tr class="h23">
									<td width="80">&nbsp;SVC Scope</td>
									<td width="" class="stm"><input type="radio" name="ioc_cd" value="" class="trans" checked>All&nbsp;<input type="radio" name="ioc_cd" value="O" class="trans">Ocean&nbsp;<input type="radio" name="ioc_cd" value="I" class="trans">IPC</td>
								</tr>
							</table>
						
						</td>
					</tr>
				</table>
				<!--  biz_1   (E) -->		
			
		</td></tr></table>
		<table class="height_8"><tr><td></td></tr></table>	
		
		
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
			
			<!-- Report Kind :General -->
			<div id="reportKind" style="display:inline">
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="240">
							<table class="search_sm2" border="0" style="width:230;"> 
								<tr class="h23">
									<td width="100">Ranking Option</td>
									<td width="" class="stm"><input type="radio" name="r_option" value="V" class="trans" checked>Volume&nbsp;<input type="radio" name="r_option" value="R" class="trans">RPB</td>
								</tr>
							</table>
						
						</td>
						<td width="40">From</td>
						<td width="100"><input type="text" name="op_from" dataformat="int" class="input" style="width:80;" value=""></td>
						<td width="25">To</td>
						<td width=""><input type="text" name="op_to" dataformat="int" class="input" style="width:80;" value=""></td>
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
			</div>								
														
			
			<!-- Report Kind :by Route -->
			<div id="reportKind" style="display:none">	
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>			
			<!-- Grid (E) -->	
			</div>								
														
			
			<!-- Report Kind :by E/Q Type -->	
			<div id="reportKind" style="display:none">
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet3');</script>
						</td>
					</tr>
				</table>			
			<!-- Grid (E) -->	
			</div>
											

			<!-- Report Kind :by Sales Office -->
			<div id="reportKind" style="display:none">
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet4');</script>
						</td>
					</tr>
				</table>			
			<!-- Grid (E) -->						
			</div>
			
			<!-- Report Kind :by Rep Commodity -->
			<div id="reportKind" style="display:none">
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet5');</script>
						</td>
					</tr>
				</table>			
			<!-- Grid (E) -->				
			</div>
			
			<!-- Report Kind :by Shipper Code -->
			<div id="reportKind" style="display:none">
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet6');</script>
						</td>
					</tr>
				</table>			
			<!-- Grid (E) -->		
			</div>
			
			
			<!-- Report Kind :by Group Customer Code -->
			<div id="reportKind" style="display:none">
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet7');</script>
						</td>
					</tr>
				</table>			
			<!-- Grid (E) -->	
			</div>
			
			
			<!-- Report Kind :by Sales Rep -->
			<div id="reportKind" style="display:none">
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet8');</script>
						</td>
					</tr>
				</table>			
			<!-- Grid (E) -->	
			</div>
			
			<!-- Report Kind :by Inbound Office -->
			<div id="reportKind" style="display:none">
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet9');</script>
						</td>
					</tr>
				</table>			
			<!-- Grid (E) -->	
			</div>		
			
			<!-- Report Kind : Data Download --> 
			<div id="reportKind" style="display:none">
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet10');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->			
			</div>
			
			</td></tr>
		</table>
		<!--biz page (E)-->


	
	
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
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_excel">Down Excel</td>
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