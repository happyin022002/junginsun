<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_opf_0042.jsp
*@FileTitle : TOR Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.20
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
<%@ page import="com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.event.VopOpf0042Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="m2soft.rdsystem.server.core.rddbagent.util.serverexport.ExportInfo"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%
	VopOpf0042Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_eml		= "";
	String strVslCd			= "";
	String strVoyNo			= "";
	String strDirCd			= "";
	String strYdCd			= "";
	String popYn			= "";
	Logger log = Logger.getLogger("com.hanjin.apps.CargoLoadingResultMgt.TerminalDepartureReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_eml = account.getUsr_eml();

		event = (VopOpf0042Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		//TOR조회시 파라메터 값들.......
		popYn		= StringUtil.xssFilter(request.getParameter("pop_mode")) == null ? "N" : "Y";
		strVslCd	= StringUtil.xssFilter(request.getParameter("vsl_cd")) == null ? "" : StringUtil.xssFilter(request.getParameter("vsl_cd"));
		strVoyNo	= StringUtil.xssFilter(request.getParameter("voy_no")) == null ? "" : StringUtil.xssFilter(request.getParameter("voy_no"));
		strDirCd	= StringUtil.xssFilter(request.getParameter("dir_cd")) == null ? "" : StringUtil.xssFilter(request.getParameter("dir_cd"));
		strYdCd		= StringUtil.xssFilter(request.getParameter("yd_cd")) == null ? "" : StringUtil.xssFilter(request.getParameter("yd_cd"));
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>TOR Creation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<script language="javascript">
	//팝업호출 및 초기조회조건
	//SCG_0016에서 팝업 조회
	var preConds = {
		pop_yn      : "<%=popYn%>",
		vsl_cd   	: "<%=strVslCd%>",
		voy_no   	: "<%=strVoyNo%>",
		dir_cd		: "<%=strDirCd%>",
		yd_cd		: "<%=strYdCd%>"
	}

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();

		if("Y" == preConds.pop_yn) {		

			//닫기버튼 보이기
			document.all.popLayer.style.display = "";
			
			//Set title of page
			var titleStr = "TOR Inquiry";
			try {
				var appName = navigator.appName;
			 	if (appName.indexOf("Netscape") == -1) {
			  		document.all.title.innerHTML = '&nbsp; '+titleStr;
			  		document.title = titleStr;
			 	} else {
			  		document.getElementById("title").innerHTML = '&nbsp; '+titleStr;
			  		document.title = titleStr;
			 	}

				if(preConds.vsl_cd != "" && preConds.voy_no != "" && preConds.dir_cd != "" && preConds.yd_cd != ""){
					document.form.vsl_cd.value = preConds.vsl_cd;
					document.form.skd_voy_no.value = preConds.voy_no;
					document.form.skd_dir_cd.value = preConds.dir_cd;

					searchVVDInfo();

					document.form.yd_cd.Code = preConds.yd_cd;
					doActionIBSheet(0, document.form, IBSEARCH);
				}
			}catch(err) {
			 	ComShowMessage(err);
			}
		}

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
<input type="hidden" name="authbtn">

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

<!-- TOR Mail Send -->
<input type="hidden" name="com_rdSubSysCd" value="OPF">
<input type="hidden" name="com_from" value="<%=strUsr_eml%>">
<input type="hidden" name="com_recipient" value="">
<input type="hidden" name="com_carbonCopy" value="<%=strUsr_eml%>">
<input type="hidden" name="com_blindCarbonCopy">
<input type="hidden" name="com_subject" value="">
<input type="hidden" name="com_fileKey">
<input type="hidden" name="com_content">
<input type="hidden" name="com_templateMrd" value="apps/alps/vop/opf/cargoloadingresultmgt/terminaldeparturereport/report/VOP_OPF_1036.mrd">
<input type="hidden" name="com_templateMrdArguments">
<input type="hidden" name="com_templateMrdDescription" value="UI_OPF_0036.mrd 파일이 첨부되었습니다.">

<input type="hidden" name="com_rdExportFileName" value="TerminalDepartureReport.pdf">
<input type="hidden" name="com_rdExportFileType" value="<%=ExportInfo.FTYPE_PDF%>">


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
					<td width="180">
						<input type="text" style="width:40;" class="input1" name="vsl_cd" required fullfill caption="Vessel Code" maxlength="4" dataformat="engup"  style="ime-mode:disabled">
						<input type="text" style="width:38;" class="input1" name="skd_voy_no" required fullfill caption="Schedule Voyage Number" maxlength="4" dataformat="engup" style="ime-mode:disabled">
						<input type="text" style="width:22;" class="input1" name="skd_dir_cd" caption="Schedule Direction Code" maxlength="1" dataformat="engup" style="ime-mode:disabled">
						<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btns_searchVvd">
						
					</td>
					<td width="30">Port</td>
					<td width="450">
						<script language="javascript">ComComboObject('yd_cd', 2, 100, 0, 0, true);</script>&nbsp;<input type="text" style="width:340;" class="input2" name="yd_nm">&nbsp;
					</td>
					<td width="" align="right"><input type="text" style="width:130;" class="input2" name="sys_create_desc" value="" readonly class="input2"></td>
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
	<!-- Grid - 1 (E) -->			

<!-- TAB [ Port Log ] (S) -->
<div id="tabLayer" style="display:none">

	<table class="search">
    <tr><td class="bg">
		<!-- biz_1  (S) -->

				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="150">Number of Used Crane</td>
					<td width="150"><input type="text" style="width:60;text-align:center" class="input" value="" dataformat="int" name="used_crane"></td>
					<td width="200">Average Number of Used Crane</td>
					<td width=""><input type="text" style="width:60;text-align:center" class="input" value="" name="avg_gang" readonly></td>
				</tr>
				</table>


				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Working Hours</td></tr>
				</table>


			<table width="979" class="grid2">
			<tr>
				<td class="tr2_head" width="20%">Gross Work Hours</td>
				<td width="12%"><input type="text" style="width:110;text-align:right;" class="input" value="" name="gross_work" maxlength="8"></td>
				<td class="tr2_head" width="20%">Net Work Hours</td>
				<td width="12%"><input type="text" style="width:110;text-align:right;" class="input" value="" name="net_work"></td>
				<td class="tr2_head" width="24%" name="net_work">Lost Time by G/Crane</td>
				<td width="%"><input type="text" style="width:110;text-align:right;" class="input" value="" name="lost_time"></td>
			</tr>
			<tr>
				<td class="tr2_head" width="%">Gross Gang Hours</td>
				<td width="%"><input type="text" style="width:110;text-align:right;" class="input" value="" name="gross_gang"></td>
				<td class="tr2_head" width="%">Net Gang Hours</td>
				<td width="%"><input type="text" style="width:110;text-align:right;" class="input" value="" name="net_gang"></td>
				<td class="input2" colspan="2"></td>
			</tr>
			</table>


			<table class="height_5"><tr><td></td></tr></table>
			<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Handling Moves</td></tr>
				</table>


			<table width="979" class="grid2">
			<tr>
				<td class="tr2_head" width="20%">Hatch Cover Handling</td>
				<td width="12%"><input type="text" style="width:110;text-align:right;" class="input" value="" name="hatch_handl" dataformat="int" maxlength="4"></td>
				<td class="tr2_head" width="20%">Gear Box Handling</td>
				<td width="%12"><input type="text" style="width:110;text-align:right;" class="input" value="" name="gear_handl" dataformat="int" maxlength="4"></td>
				<td class="tr2_head" width="24%">Total Container Handling Moves</td>
				<td width="%"><input type="text" style="width:110;text-align:right;" class="input" value="" name="move_handl" dataformat="int" maxlength="6"></td>
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
					<td width="10%"><input type="text" style="width:100%;text-align:right;" class="input" value="" name="tmnl_gross" dataformat="float" maxlength="7"></td>
					<td class="tr2_head2" width="5%">Net</td>
					<td width="10%"><input type="text" style="width:100%;text-align:right;" class="input" value="" name="tmnl_net" dataformat="float" maxlength="7"></td>
					<td class="tr2_head" width="10%">Per Gang</td>
					<td class="tr2_head2" width="5%">Gross</td>
					<td width="10%"><input type="text" style="width:100%;text-align:right;" class="input" value="" name="per_gang_gross" dataformat="float" maxlength="7"></td>
					<td class="tr2_head2" width="5%">Net</td>
					<td width="10%"><input type="text" style="width:100%;text-align:right;" class="input" value="" name="per_gan_net" dataformat="float" maxlength="7"></td>
				</tr>
			</table>
			
			<table class="height_5"><tr><td></td></tr></table>
			<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Terminal Working Time</td></tr>
				</table>


			<table width="979" class="grid2">
			<tr>
				<td class="tr2_head" width="20%">Work Commenced</td>
				<td width="12%"><input type="text" style="width:110;text-align:right;" class="input" value="" name="work_comm" dataformat="int" maxlength="4"></td>
				<td class="tr2_head" width="20%">Work Completed</td>
				<td width="%12"><input type="text" style="width:110;text-align:right;" class="input" value="" name="work_comp" dataformat="int" maxlength="4"></td>
			</tr>
			</table>
				
			<table class="height_5"><tr><td></td></tr></table>

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
    <iframe name="t3frame" id="t3frame" frameborder="0" scrolling="no" width="100%" height="445"></iframe>
</div>
<!-- TAB [ Disch. Vol. ] (E) -->

<!-- TAB [ Load. Vol. ] (S) -->
<div id="tabLayer" style="display:none">
    <iframe name="t4frame" id="t4frame" frameborder="0" scrolling="no" width="100%" height="445"></iframe>
</div>
<!-- TAB [ Load. Vol. ] (E) -->
<!-- TAB [ COD ] (S) -->
<div id="tabLayer" style="display:none">
    <iframe name="t5frame" id="t5frame" frameborder="0" scrolling="no" width="100%" height="445"></iframe>
</div>
<!-- TAB [ COD ] (E) -->
<!-- TAB [ R/H ] (S) -->
<div id="tabLayer" style="display:none">
    <iframe name="t6frame" id="t6frame" frameborder="0" scrolling="no" width="100%" height="445"></iframe>
</div>
<!-- TAB [ R/H ] (E) -->
<!-- TAB [ Mishandle ] (S) -->
<div id="tabLayer" style="display:none">
    <iframe name="t7frame" id="t7frame" frameborder="0" scrolling="no" width="100%" height="445"></iframe>
</div>
<!-- TAB [ Mishandle ] (E) -->

<!-- TAB [ Slot ] (S) -->
<div id="tabLayer" style="display:none">
    <iframe name="t8frame" id="t8frame" frameborder="0" scrolling="no" width="100%" height="445"></iframe>
</div>
<!-- TAB [ Slot ] (E) -->

<!-- TAB [ Temp. STWG ] (S) -->
<div id="tabLayer" style="display:none">
    <iframe name="t9frame" id="t9frame" frameborder="0" scrolling="no" width="100%" height="445"></iframe>
</div>
<!-- TAB [ Temp. STWG ] (E) -->

<!-- TAB [ Remark ] (S) -->
<div id="tabLayer" style="display:none">

	<table class="search"> 
    <tr><td class="bg">
		<!-- biz_1  (S) -->
				<!--  Button_Sub (S) 
			<span id="buttonOperator">
			<table width="100%" class="button"> 
	       		<tr><td><table width="120" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_t10RowAdd">TOR Remark(s)</td>
						<td class="btn2_right"></td>
						</tr></table></td>
			</tr>
			</table>
			</span>

	    	<!-- Button_Sub (E) --> 
			<table class="height_2"><tr><td></td></tr></table>
			
				<table width="100%">
					<tr><td><textarea style="width:99%;height:420" name="tdr_info" class="input2" readonly></textarea></td>
					</tr>
				</table>
				
			
			
			</td></tr>
		</table>
		<!-- Tab BG Box(E) -->
	<!--biz page (E)-->

</div>
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
                    <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn1_left" name="btn_ExcludefromTPRLeft" id="btn_ExcludefromTPRLeft">
                            <td class="btn1" name="btn_ExcludefromTPR" id="btn_ExcludefromTPR">Exclude from TPR</td>
                            <td class="btn1_right" name="btn_ExcludefromTPRRight" id="btn_ExcludefromTPRRight"></tr>
                        </table>
                    </td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Mail">Mail</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
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
<!--  -->
<div id="tdrHeader" style="display:none;">
<script language="javascript">ComSheetObject('sheetTdrH');</script>
</div>

<div id="popLayer" style="display:none">
<table class="height_5"><tr><td></td></tr></table>	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup">
	
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"> 
       			<tr>
       				<td class="btn3_bg">
		    			<table border="0" cellpadding="0" cellspacing="0">
		    				<tr>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Close">Close</td>
											<td class="btn1_right">
										</tr>
									</table>
								</td>
							</tr>
						</table>
    					<!--Button (E) -->
	
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<!-- : ( Button : pop ) (E) -->
</div>

<!-- <TEXTAREA NAME="s_parameter" style="width:100%;height:50;display:none;"></TEXTAREA> -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>