<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_opf_0036.jsp
*@FileTitle : TOR Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2009.07.06 장석현
* 1.0 Creation 

* 2011.11.07 김민아 [CHM-201114250-01] TOR내 SKD& Condition Tap 삭제 - TOR Creation 및 Inqiury 메뉴상 Schedule& Condition Tap 삭제 처리
* 2011.12.12 김민아 [CHM-201114776-01] [VOP-OPF] TOR Creation 메뉴 수정 및 프린트 화면 변경 요청건 : TDR->TOR
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.event.VopOpf0036Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopOpf0036Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.CargoLoadingResultMgt.TerminalDepartureReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm(); 


		event = (VopOpf0036Event)request.getAttribute("Event");
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
<title>TOR Creation</title>
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
<input type="hidden" name="port_cd">
<input type="hidden" name="voy_no">
<input type="hidden" name="dir_cd">
<input type="hidden" name="clpt_ind_seq">
<input type="hidden" name="sys_create">
<input type="hidden" name="comboCd" value="">

<input type="hidden" name="chkDate" dataformat="ymdhm">
<!-- Container Status -->
<input type="hidden" name="status1">
<input type="hidden" name="status2">
<!-- Specail Carge Status -->
<input type="hidden" name="sc_status1">
<input type="hidden" name="sc_status2">
<input type="hidden" name="sc_status3">
<input type="hidden" name="cargo_type1">
<input type="hidden" name="cargo_type2">
<!-- Container No Search -->
<input type="hidden" name="cntr_no">
<input type="hidden" name="misHandleChk" value="SD">

<!-- TOR_UTILIZE Carge Status -->
<input type="hidden" name="sl_status1">
<input type="hidden" name="sl_status2">

<!-- Report Popup -->
<input type="hidden" size="200" name="com_mrdPath" value="apps/alps/vop/opf/cargoloadingresultmgt/terminaldeparturereport/report/VOP_OPF_1036.mrd">
<input type="hidden" size="200" name="com_mrdArguments">
<input type="hidden" size="200" name="com_mrdSaveDialogDir" value="c:\\MyFolder\\">
<input type="hidden" size="200" name="com_mrdSaveDialogFileName" value="TerminalDepartureReport">
<input type="hidden" size="200" name="com_mrdSaveDialogFileExt" value="pdf">
<input type="hidden" size="200" name="com_mrdSaveDialogFileExtLimit" value="xls@pdf@bmp@tif">
<input type="hidden" size="200" name="com_mrdDisableToolbar">
<input type="hidden" size="200" name="com_mrdTitle" value="Terminal Operation Report">
<input type="hidden" size="200" name="com_mrdBodyTitle" value="Terminal Operation Report">
<input type="hidden" size="200" name="com_isBatch" value="N">

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
		<table class="search">
       	<tr><td class="bg">
				<!-- biz_1  (S) -->
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="50">VVD CD</td>
					<td width="180"><!-- required fullfill  -->
						<input type="text" style="width:40;" class="input1" name="vsl_cd" caption="Vessel Code" maxlength="4" dataformat="engup" style="ime-mode:disabled">
						<input type="text" style="width:38;" class="input1" name="skd_voy_no" caption="Schedule Voyage Number" maxlength="4" dataformat="engup" style="ime-mode:disabled">
						<input type="text" style="width:22;" class="input1" name="skd_dir_cd" caption="Schedule Direction Code" maxlength="1" dataformat="engup" style="ime-mode:disabled">
						<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btns_searchVvd">
						
					</td>
					<td width="30">Port</td>
					<td width="450">
						<script language="javascript">ComComboObject('yd_cd', 2, 100, 0, 0, true);</script>&nbsp;<input type="text" style="width:340;" class="input2" name="yd_nm">&nbsp;
					</td>
					<td width="" align="right"><input type="text" style="width:120;" class="input2" name="sys_create_desc" value="" readonly class="input2"></td>
				</tr>

				</table>

		<!-- biz_1  (E) -->

		</td></tr>
		</table>

	    <table class="height_8"><tr><td></td></tr></table>

<!-- TAB [ SKD & COND ] (S) -->
		<!-- Tab (S) -->
		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%>
		<tr>
			<td width="100%">
					<script language="javascript">ComTabObject('tabTdr')</script>
			</td>
		</tr>
		</table>
		<!-- Tab (E) -->

	<!-- Grid - 1	:	Sheet Search & Save (S)  -->
		<table width="100%"  id="mainTable" style="display:none;"> 
			<tr>
				<td width="100%" height="100">
					<script language="javascript">ComSheetObject('t1sheet1');</script>
				</td>
			</tr>
		</table>			
	<!-- Grid - 1 (E) 
	
<!-- TAB [ Port Log ] (S) -->
<div id="tabLayer" style="display:none">

	<table class="search">
    <tr><td class="bg">
		<!-- biz_1  (S) -->

				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="150">Number of Used Crane</td>
					<td width="150"><input type="text" style="width:60;text-align:center" class="input" value="" dataformat="int" maxlength="2" name="used_crane"></td>
					<td width="200">Average Number of Used Crane</td>
					<td width=""><input type="text" style="width:60;text-align:center" class="input" value="" name="avg_gang" maxlength="4"></td>
				</tr>
				</table>


				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Working Hours</td></tr>
				</table>


			<table width="979" class="grid2">
			<tr>
				<td class="tr2_head" width="20%">Gross Work Hours</td>
				<td width="12%" class="input2"><input type="text" style="width:110;text-align:right;" class="input" value="" name="gross_work" maxlength="6"></td>
				<td class="tr2_head" width="20%">Net Work Hours</td>
				<td width="12%" class="input2"><input type="text" style="width:110;text-align:right;" class="input" value="" name="net_work" maxlength="6"></td>
				<td class="tr2_head" width="24%" name="net_work">Lost Time by G/Crane</td>
				<td width="%" class="input2"><input type="text" style="width:110;text-align:right;" class="input" value="" name="lost_time" maxlength="6"></td>
			</tr>
			<tr>
				<td class="tr2_head" width="%">Gross Gang Hours</td>
				<td width="%" class="input2"><input type="text" style="width:110;text-align:right;" class="input" value="" name="gross_gang" maxlength="6"></td>
				<td class="tr2_head" width="%">Net Gang Hours</td>
				<td width="%" class="input2"><input type="text" style="width:110;text-align:right;" class="input" value="" name="net_gang" maxlength="6"></td>
				<td class="input2" colspan="2"></td>
			</tr>
			</table>


			<table class="height_5"><tr><td></td></tr></table>
			<table class="search" border="0">
				<tr><td class="title_h" ondblclick='document.all.move_handl.readOnly=false;'></td>
					<td class="title_s">Handling Moves</td></tr>
				</table>


			<table width="979" class="grid2">
			<tr>
				<td class="tr2_head" width="20%">Hatch Cover Handling</td>
				<td width="12%"><input type="text" style="width:110;text-align:right;" class="input" value="" name="hatch_handl" dataformat="int" maxlength="4"></td>
				<td class="tr2_head" width="20%">Gear Box Handling</td>
				<td width="%12"><input type="text" style="width:110;text-align:right;" class="input" value="" name="gear_handl" dataformat="int" maxlength="4"></td>
				<td class="tr2_head" width="24%">Total Container Handling Moves</td>
				<td width="%"><input type="text" style="width:110;text-align:right;" class="input2" readonly value="" name="move_handl" dataformat="int" maxlength="6"></td>
			</tr>
			</table>


			<table class="height_5"><tr><td></td></tr></table>
			<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Productivity</td></tr>
			</table>
			
			<table width="979" class="grid2">
				<tr>
					<td class="tr2_head" width="10%">Terminal</td>
					<td class="tr2_head2" width="5%">Gross</td>
					<td width="10%" class="input2"><input type="text" style="width:100%;text-align:right;" class="input" value="" name="tmnl_gross" dataformat="float" maxlength="5"></td>
					<td class="tr2_head2" width="5%">Net</td>
					<td width="10%" class="input2"><input type="text" style="width:100%;text-align:right;" class="input" value="" name="tmnl_net" dataformat="float" maxlength="5"></td>
					<td class="tr2_head" width="10%">Per Gang</td>
					<td class="tr2_head2" width="5%">Gross</td>
					<td width="10%" class="input2"><input type="text" style="width:100%;text-align:right;" class="input" value="" name="per_gang_gross" dataformat="float" maxlength="5"></td>
					<td class="tr2_head2" width="5%">Net</td>
					<td width="10%" class="input2"><input type="text" style="width:100%;text-align:right;" class="input" value="" name="per_gan_net" dataformat="float" maxlength="5"></td>
				</tr>
			</table>
				
			<table class="height_5"><tr><td></td></tr></table>
			<!-- <table class="search" border="0">
				<tr>
					<td><table width="220" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_t2AutoCalcu">Auto Calcu. fm Crane Working</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</tr>
			</table>


			<table class="line_bluedot"><tr><td colspan="8"></td></tr></table> -->

			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t2sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) -->
			</td></tr>
		</table>
		<!-- Tab BG Box(E) -->
	<!--biz page (E)-->

</div>
<!-- TAB [ Port Log ] (E) -->
<!-- TAB [ Disch. Vol. ] (S) -->
<div id="tabLayer" style="display:none">
    <iframe name="t3frame" id="t3frame" frameborder="0" scrolling="no" width="100%" height="440"></iframe>
</div>
<!-- TAB [ Disch. Vol. ] (E) -->

<!-- TAB [ Load. Vol. ] (S) -->
<div id="tabLayer" style="display:none">
    <iframe name="t4frame" id="t4frame" frameborder="0" scrolling="no" width="100%" height="440"></iframe>
</div>
<!-- TAB [ Load. Vol. ] (E) -->
<!-- TAB [ COD ] (S) -->
<div id="tabLayer" style="display:none">
    <iframe name="t5frame" id="t5frame" frameborder="0" scrolling="no" width="100%" height="440"></iframe>
</div>
<!-- TAB [ COD ] (E) -->
<!-- TAB [ R/H ] (S) -->
<div id="tabLayer" style="display:none">
    <iframe name="t6frame" id="t6frame" frameborder="0" scrolling="no" width="100%" height="440"></iframe>
</div>
<!-- TAB [ R/H ] (E) -->
<!-- TAB [ Mishandle ] (S) -->
<div id="tabLayer" style="display:none">
    <iframe name="t7frame" id="t7frame" frameborder="0" scrolling="no" width="100%" height="440"></iframe>
</div>
<!-- TAB [ Mishandle ] (E) -->

<!-- TAB [ Slot ] (S) -->
<div id="tabLayer" style="display:none">
    <iframe name="t8frame" id="t8frame" frameborder="0" scrolling="no" width="100%" height="440"></iframe>
</div>
<!-- TAB [ Slot ] (E) -->

<!-- TAB [ Temp. STWG ] (S) -->
<div id="tabLayer" style="display:none">
    <iframe name="t9frame" id="t9frame" frameborder="0" scrolling="no" width="100%" height="440"></iframe>
</div>
<!-- TAB [ Temp. STWG ] (E) -->

<!-- TAB [ Remark ] (S) -->
<div id="tabLayer" style="display:none">

	<table class="search"> 
    <tr><td class="bg">
		<!-- biz_1  (S) -->
			<table class="height_2"><tr><td></td></tr></table>
			
				<table width="100%">
					<tr><td><textarea style="width:99%;height:400" name="tdr_info"></textarea></td>
					</tr>
				</table>
				
			
			
			</td></tr>
		</table>
		<!-- Tab BG Box(E) -->
	<!--biz page (E)-->
</div>
<div id="tdrHeader" style="display:none;">
<script language="javascript">ComSheetObject('sheetTdrH');</script>
</div>
<div id="tdrTransc" style="display:none;">
<script language="javascript">ComSheetObject('sheetTransc');</script>
</div>
<TEXTAREA NAME="tabLayerStatus" ROWS="2" COLS="200" style="display:none;"></TEXTAREA>
<TEXTAREA NAME="s_parameter" style="width:100%;height:50;display:none;"></TEXTAREA>
<!-- TAB [ Remark ] (E) -->

	<!--Button (S) -->
		<!-- Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr>
			<td class="btn1_bg">
			    <table border="0" cellpadding="0" cellspacing="0">
			    <tr>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Retrieve">Retrieve</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_New">New</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td class="btn1_line"></td>
					<td><DIV id="deleteButton"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Delete" id="btn_Delete">Delete</td>
						<td class="btn1_right"></td>
						</tr>
					</table></DIV></td>
					<td><DIV id="saveButton"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Save" id="btn_Save">Save</td>
						<td class="btn1_right"></td>
						</tr>
					</table></DIV></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left" name="btn_ExcludefromTPRLeft" id="btn_ExcludefromTPRLeft">
							<td class="btn1" name="btn_ExcludefromTPR" id="btn_ExcludefromTPR">Exclude from TPR</td>
							<td class="btn1_right" name="btn_ExcludefromTPRRight" id="btn_ExcludefromTPRRight"></tr>
						</table>
					</td>
					<td class="btn1_line"></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Print">Print</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
				</tr>
				</table>
			</td></tr>
			</table>
			<!-- Button (E) -->
	</td></tr>
</table>
 
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>