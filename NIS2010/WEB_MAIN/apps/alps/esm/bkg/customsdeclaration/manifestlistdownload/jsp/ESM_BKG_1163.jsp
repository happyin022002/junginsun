<%
/*=========================================================
 *Copyright(c) 2013 CyberLogitec
 *@FileName : ESM_BKG_1163.jsp
 *@FileTitle : Russia Customs Manifest
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2013.07.03
 *@LastModifier : 김보배
 *@LastVersion : 1.0
 * 2013.07.03 김보배
 * 1.0 Creation
 * --------------------------------------------------------
 * History
 * 2013.10.14 김보배 [CHM-201326451] Russia/Manifest 기능 보완 요청
 * 2013.11.04 김보배 [CHM-201327164] Russia Manifest 기능 보완
 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.russia.event.EsmBkg1163Event"%>	
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg1163Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	boolean bBtn_Disabled = true;
	Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg1163Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Russia Customs Manifest</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
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

<body onLoad="setupPage();">
<div id="debug"></div>
<form name="form">
	<input type="hidden" name="f_cmd"> 
	<input type="hidden" name="pagerows"> 
	<input type="hidden" name="ch_usr_id">
	<input type="hidden" name="curr_page" value="1">
	<input type="hidden" name="rows_per_page" value="50">
	<input type="hidden" name="order_by" value="">
	<input type="hidden" name="order_by_title" value="">
	
	<input type="hidden" name="com_mrdPath">
	<input type="hidden" name="com_mrdArguments">
	<input type="hidden" name="com_mrdTitle">
	<input type="hidden" name="com_mrdBodyTitle">
	<input type="hidden" name="com_mrdDisableToolbar">

<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top: 2; padding-left: 5;">
	<tr>
		<td valign="top">
		
		<!--Page Title, Historical (S)-->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr>
				<td class="history"><img src="img/icon_history_dot.gif"
					align="absmiddle"><span id="navigation"></span></td>
			</tr>
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif"
					align="absmiddle"><span id="title"></span></td>
			</tr>
			</table>
		<!--Page Title, Historical (E)--> 
		
		<!-- : ( Search Options ) (S) -->
		<table class="search" id="mainTable"> 
    		<tr><td class="bg">	
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="200">
					<table class="search_sm2" border="0" style="width:180;"> 
					<tr class="h23">
					<td>Mode</td>
					<td class="stm"><input type="radio" value="O" class="trans" name="mode_type" checked >Outbound&nbsp;<input type="radio" value="I" class="trans" name="mode_type"  >Inbound</td>
					</tr>
					</table> 
				</td>
				<td width="25">VVD</td>
				<td width="80"><input type="text" style="width:75;ime-mode:disabled" class="input1" value="" name="vvd_cd" maxlength='9' dataformat='engupnum' ></td>
				<td width="25">POL</td>
				<td width="90"><input type="text" style="width:50;" value="" class="input1" name="pol_cd" maxlength='5' dataformat='engup'>&nbsp; <input type="text" style="width:25;" value="" class="input" name="pol_yd_cd" maxlength='2' dataformat='engupnum'></td>
				<td width="25">POD</td>
				<td width="90"><input type="text" style="width:50;" value="" class="input" name="pod_cd" maxlength='5' dataformat='engup' >&nbsp; <input type="text" style="width:25;" value="" class="input" name="pod_yd_cd" maxlength='2' dataformat='engupnum'></td>
				<td width="225">
					<table class="search_sm2" border="0" style="width:220;"> 
					<tr class="h23">
					<td>Cargo Type</td>
					<td class="stm"><input type="radio" value="ALL" class="trans" name="cargo_type" checked>All&nbsp;<input type="radio" value="F" class="trans" name="cargo_type">Full&nbsp;<input type="radio" value="P" class="trans" name="cargo_type">Empty</td>
					</tr>
					</table> 
				</td>
				<td width="">
					<table class="search_sm2" border="0" style="width:220;"> 
					<tr class="h23">
					<td>Cargo Route</td>
					<td class="stm"><input type="radio" value="ALL" class="trans" name="cargo_route" checked>All&nbsp;<input type="radio" value="L" class="trans" name="cargo_route">Local&nbsp;<input type="radio" value="T" class="trans" name="cargo_route">T/S</td>
					</tr>
					</table> 
				</td>
			</tr>
			</table> 
			<!--biz page (E)-->
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
		
		
			<!--biz page (S)-->
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
			<td>
				<table class="search_sm" border="0" style="width:480;"> 
				<tr class="h23">
					<td width="110">Booking Route</td>
					<td class="stm" width="100">POR&nbsp;<input type="text" style="width:50;" value="" class="input" name="br_por_cd" maxlength='5' dataformat='engup'></td>
					<td class="stm" width="100">POL&nbsp;<input type="text" style="width:50;" value="" class="input" name="br_pol_cd" maxlength='5' dataformat='engup'></td>
					<td class="stm" width="100">POD&nbsp;<input type="text" style="width:50;" value="" class="input" name="br_pod_cd" maxlength='5' dataformat='engup'></td>
					<td class="stm" width="">DEL&nbsp;<input type="text"    style="width:50;" value="" class="input" name="br_del_cd" maxlength='5' dataformat='engup'></td>
				</tr>
				</table> 
			</td>
			</tr>
			</table> 
			
			</td></tr>
		</table>
		<!--biz page (E)-->	
	 	<table class="height_8"><tr><td></td></tr></table>


		<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="35">&nbsp;VVD</td>
   				<td width="100"><input type="text" style="width:80;" class="input2" value="" readonly name="hd_vvd_cd"></td>
   				<td width="35" id="hd_pol_pod">POL</td>
   				<td width="70"><input type="text" style="width:50;" class="input2" value="" readonly name="hd_pol_pod_cd"></td>
   				<td width="35" id="hd_eta_etd">ETD</td>
   				<td width="100"><input type="text" style="width:80;" class="input2" value="" readonly name="hd_eta_etd_cd"></td>
   				<td width="35">Mode</td>
   				<td width=""><input type="text" style="width:80;" class="input2" value="" readonly name="hd_mode_type"></td>
    		</tr>
			</table>
				
			<table class="height_8"><tr><td></td></tr></table>
			
			<!-- Grid  (S) -->
			<table width="100%"  id="mainTable">
			<tr>
				<td width="100%">
				<script language="javascript">ComSheetObject('sheet1');</script>
				</td>
			</tr>
			</table>
			<table width="100%"  id="mainTable" style="display:none">
			<tr>
				<td width="100%">
				<script language="javascript">ComSheetObject('sheet2');</script>
				</td>
			</tr>
			</table>
			<!-- Grid (E) -->
		
			<!--  Button_Sub (S) -->
			<table width="100%" class="button">
				<tr>
					<td class="btn2_bg">
						
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- <td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" lass="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_Sort">Sort</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
							</td>  -->
							<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_check_all">Check All</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
							</td>
							<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td class="btn2_left"></td>
									<td class="btn2" name="btn_uncheck_all">Uncheck All</td>
									<td class="btn2_right"></td>
								</tr>
								</table>
							</td>
						</tr>
						</table>
					</td>
				</tr>
				</table>
				<!-- Button_Sub (E) -->
							
				</td>
			</tr>
		</table>
		</td>
	</tr>
</table>		

<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0"
			cellspacing="0" style="padding-top: 5; ">
			<tr>
				<td class="btn1_bg">
				
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0"
								class="button">
								<tr>
									<td class="btn1_left"></td>
									<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
									<td class="btn1_right"></td>
								</tr>
							</table>
							</td>
							<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0"
								class="button">
								<tr>
									<td class="btn1_left"></td>
									<td class="btn1" name="btn_Save" id="btn_Save">Save</td>
									<td class="btn1_right"></td>
								</tr>
							</table>
							</td>
							<td>
							<table width="72" border="0" cellpadding="0" cellspacing="0"
								class="button">
								<tr>
									<td class="btn1_left"></td>
									<td class="btn1" name="btn_New">New</td>
									<td class="btn1_right"></td>
								</tr>
							</table>
							</td>
							<td class="btn1_line"></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
	               			 <tr><td class="btn1_left"></td>
	               			 <td class="btn1" name="btn_Transmit">Terminal Transmission</td>
	               			 <td class="btn1_right"></td>
	                		</tr>
	            			</table>
							<td class="btn1_line"></td>
							
							
							
							
							<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0"
									class="button">
									<tr>
										<td class="btn1_left"></td>
										<td class="btn1" name="btn_DownExcel">Down&nbsp;Excel</td>
										<td class="btn1_right"></td>
									</tr>
								</table>
							</td>
							<td class="btn1_line"></td>
							<td>
								<table width="72" border="0" cellpadding="0" cellspacing="0"
									class="button">
									<tr>
										<td class="btn1_left"></td>
										<td class="btn1" name="btn_Print">Print</td>
										<td class="btn1_right"></td>
									</tr>
								</table>
							</td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
	               			 <tr><td class="btn1_left"></td>
	               			 <td class="btn1" name="btn_CargoDown">Print New Form(Manifest)</td>
	               			 <td class="btn1_right"></td>
	                		</tr>
	            			</table>
	            			</td>
						</tr>
					</table>

		</td>
			</tr>
		</table>

<table border="0" width="100%" height="0" style="display:inline">
	<tr><td><script language='javascript'>comRdObject('report1');</script></td></tr>
</table>  
<!--Button (E) --> 
<!-- 개발자 작업  끝 -->
</form>
<form name="form2" method="POST">
	<input type="hidden" name="message"> 
</form>
<form name="form3" method="post">
	<input type="hidden" name="bkg_no">
	<input type="hidden" name="mode_type">
	<input type="hidden" name="vvd_cd">
	<input type="hidden" name="pol_cd">
	<input type="hidden" name="pol_yd_cd">
	<input type="hidden" name="pod_cd">
	<input type="hidden" name="pod_yd_cd">
</form>
</body>
</html>