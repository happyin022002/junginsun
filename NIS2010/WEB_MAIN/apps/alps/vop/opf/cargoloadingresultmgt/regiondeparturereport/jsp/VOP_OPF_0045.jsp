<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_OPF_0045.jsp
*@FileTitle : RDR Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 이선영
*@LastVersion : 1.0
* 2009.07.20 이선영
* 1.0 Creation 
* History --------------------------------------------------
* No. Date       Modifier  CSR No.        Content
* 1.  2012.05.22 전상화 [CHM-201217915]     [VOP-OPF] RDR Inquiry : 소스 내용 변경 없이, 재 태깅 작업 

=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.event.VopOpf0045Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="m2soft.rdsystem.server.core.rddbagent.util.serverexport.ExportInfo"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%
	VopOpf0045Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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
	String strRegion		= "";
	String popYn			= "";
	String joo_init_tab   = "";
	Logger log = Logger.getLogger("com.hanjin.apps.CargoLoadingResultMgt.RegionDepartureReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_eml = account.getUsr_eml();

		event = (VopOpf0045Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		//TDR조회시 파라메터 값들.......
		popYn		= StringUtil.xssFilter(request.getParameter("pop_mode")) == null ? "N" : "Y";
		strVslCd	= StringUtil.xssFilter(request.getParameter("vsl_cd")) == null ? "" : StringUtil.xssFilter(request.getParameter("vsl_cd"));
		strVoyNo	= StringUtil.xssFilter(request.getParameter("voy_no")) == null ? "" : StringUtil.xssFilter(request.getParameter("voy_no"));
		strDirCd	= StringUtil.xssFilter(request.getParameter("dir_cd")) == null ? "" : StringUtil.xssFilter(request.getParameter("dir_cd"));
		strRegion	= StringUtil.xssFilter(request.getParameter("region")) == null ? "" : StringUtil.xssFilter(request.getParameter("region"));
		
		/** 공동운항(JOO)에서 Call시, 초기 Tab Page 설정.  **/
		joo_init_tab= StringUtil.xssFilter(request.getParameter("joo_init_tab")) == null ? "" : StringUtil.xssFilter(request.getParameter("joo_init_tab"));
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>RDR Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	var preConds = {
		pop_yn      : "<%=popYn%>",
		vsl_cd   	: "<%=strVslCd%>",
		voy_no   	: "<%=strVoyNo%>",
		dir_cd		: "<%=strDirCd%>",
		region		: "<%=strRegion%>",
       joo_init_tab : "<%=joo_init_tab%>"
	};

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
			var titleStr = "RDR Inquiry";
			try {
				var appName = navigator.appName;
			 	if (appName.indexOf("Netscape") == -1) {
			  		document.all.title.innerHTML = '&nbsp; '+titleStr;
			  		document.title = titleStr;
			 	} else {
			  		document.getElementById("title").innerHTML = '&nbsp; '+titleStr;
			  		document.title = titleStr;
			 	}

				if(preConds.vsl_cd != "" && preConds.voy_no != "" && preConds.dir_cd != "" && preConds.region != ""){
					document.form.vsl_cd.value = preConds.vsl_cd;
					document.form.voy_no.value = preConds.voy_no;
					document.form.dir_cd.value = preConds.dir_cd;
					document.form.region.Code  = preConds.region;
					if(preConds.joo_init_tab== ""){
					    doActionIBSheet(sheetObjects[0], document.form, IBSEARCH, "search01");
					}
					
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
<input type="hidden" size="200" name="skd_voy_no" value="">
<input type="hidden" size="200" name="skd_dir_cd" value="">

<input type="hidden" size="200" name="popYn" value="<%=popYn %>">
<!-- 개발자 작업	-->

<!-- 메일전송 관련 항목 -->
<input type="hidden" name="com_rdSubSysCd" value="OPF">
<input type="hidden" name="com_from" value="<%=strUsr_eml%>">
<input type="hidden" name="com_recipient" value="">
<input type="hidden" name="com_carbonCopy" value="<%=strUsr_eml%>">
<input type="hidden" name="com_blindCarbonCopy">
<input type="hidden" name="com_subject" value="">
<input type="hidden" name="com_fileKey">
<input type="hidden" name="com_content">
<input type="hidden" name="com_templateMrd" value="apps/alps/vop/opf/cargoloadingresultmgt/regiondeparturereport/report/VOP_OPF_0145.mrd">
  
<input type="hidden" name="com_rdExportFileName" value="RegionalDepartureReport.pdf">
<input type="hidden" name="com_templateMrdArguments">
<input type="hidden" name="com_templateMrdDescription" value="UI_OPF_0145.mrd 파일이 첨부되었습니다.">
<input type="hidden" name="com_rdExportFileType" value="<%=ExportInfo.FTYPE_PDF%>">

<!-- 리포트 팝업 관련 항목 -->
<input type="hidden" size="200" name="com_mrdPath" value="apps/alps/vop/opf/cargoloadingresultmgt/regiondeparturereport/report/VOP_OPF_0145.mrd">
<input type="hidden" size="200" name="com_mrdArguments">
<input type="hidden" size="200" name="com_mrdSaveDialogDir" value="c:\\MyFolder\\">
<input type="hidden" size="200" name="com_mrdSaveDialogFileName" value="RegionalDepartureReport">
<input type="hidden" size="200" name="com_mrdSaveDialogFileExt" value="pdf">
<input type="hidden" size="200" name="com_mrdSaveDialogFileExtLimit" value="xls@pdf@bmp@tif">
<input type="hidden" size="200" name="com_mrdDisableToolbar">
<input type="hidden" size="200" name="com_mrdTitle" value="Regional Departure Report">
<input type="hidden" size="200" name="com_mrdBodyTitle" value="Regional Departure Report">
<input type="hidden" size="200" name="com_isBatch" value="Y">


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
					<td width="60">VVD CD</td>
					<td width="170"><input type="text" name="vsl_cd" caption="VVD CD" style="width:40;ime-mode:disabled;" class="input1" maxLength="4" required>&nbsp;<input type="text" name="voy_no" caption="VVD CD" style="width:40;ime-mode:disabled;" class="input1" maxLength="4" required>&nbsp;<input type="text" name="dir_cd" caption="VVD CD" style="width:20;ime-mode:disabled;" class="input1" maxLength="1" required>&nbsp;<img src="img/btns_search.gif" name="vsl_cd_pop" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"><input type="text" style="width:0;" name="noname"></td>
					<td width="53">Region</td>
					<td width="140"><script language="javascript">ComComboObject('region',2,120,0,1,1);</script></td>
                    <td width="30">Port</td>
                    <td width="400">
                       <input type="text" name="port_cd" caption="Port Code"  style="width:60;ime-mode:disabled;"  class="input2" readonly maxLength="5" required>&nbsp;<input type="text" style="width:260;" class="input2" readonly name="port_cd_nm">&nbsp;
                    </td>
					<td width="63">Operator</td>
					<td><script language="javascript">ComComboObject('opr_cd',1,120,0,1,0);</script></td>
				</tr>
				</table>

				<!-- biz_1  (E) -->


		</td></tr>
			</table>
   <table class="height_8"><tr><td></td></tr></table>
			<!-- Tab (S) -->
     		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%>
       		<tr><td width="100%">
						<script language="javascript">ComTabObject('tab1')</script>
						<!-- img src="img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
					</td></tr>
				</table>
			<!-- Tab (E) -->
<!-- TAB [ VSL Mvmt ] (S) -->
<div id="tabLayer" style="display:inline">

	<table class="search">
    <tr><td class="bg">
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t1sheet1');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->

				<table class="line_bluedot"><tr><td></td></tr></table>


				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="100">ETA Next Port</td>
					<td width=""><input type="text" name="next_port" style="width:50;" class="input2" readonly>&nbsp;<input type="text" name="next_date" style="width:110;" class="input2" readonly></td>
				</tr>
				<tr class="h23">
					<td width="100">Canal</td>
					<td width=""><input type="text" name="next_canal" style="width:50;" class="input2" readonly>&nbsp;<input type="text" name="eta_canal" style="width:110;" class="input2" readonly></td>
				</tr>
				</table>
			</td></tr>
		</table>
		<!-- Tab BG Box(E) -->
</div>
<!-- TAB [ VSL Mvmt ] (E) -->


<!-- TAB [ Add Slot ] (S) -->
<div id="tabLayer" style="display:none">
    <iframe name="t2frame" id="t2frame" frameborder="0" scrolling="no" width="100%" height="450"></iframe>
</div>
<!-- TAB [ Add Slot ] (E) -->


<!-- TAB [ Slot/WGT Util ] (S) -->
<div id="tabLayer" style="display:none">
    <iframe name="t3frame" id="t3frame" frameborder="0" scrolling="no" width="100%" height="450"></iframe>
</div>
<!-- TAB [ Slot/WGT Util ] (E) -->


<!-- TAB [ AK ] (S) -->
<div id="tabLayer" style="display:none">
    <iframe name="t4frame" id="t4frame" frameborder="0" scrolling="no" width="100%" height="450"></iframe>
</div>
<!-- TAB [ AK ] (E) -->


<!-- TAB [ B/B ] (S) -->
<div id="tabLayer" style="display:none">
    <iframe name="t5frame" id="t5frame" frameborder="0" scrolling="no" width="100%" height="450"></iframe>
</div>
<!-- TAB [ B/B ] (E) -->


<!-- TAB [ HC/45' ] (S) -->
<div id="tabLayer" style="display:none">
    <iframe name="t6frame" id="t6frame" frameborder="0" scrolling="no" width="100%" height="450"></iframe>
</div>
<!-- TAB [ HC/45' ] (E) -->


<!-- TAB [ RF ] (S) Other Logic-->
<div id="tabLayer" style="display:none">
    <iframe name="t7frame" id="t7frame" frameborder="0" scrolling="no" width="100%" height="450"></iframe>
</div>
<!-- TAB [ RF ] (E) -->


<!-- TAB [ DG ] (S) -->
<div id="tabLayer" style="display:none">
    <iframe name="t8frame" id="t8frame" frameborder="0" scrolling="no" width="100%" height="450"></iframe>
</div>
<!-- TAB [ DG ] (E) -->


<!-- TAB [ VSL Alloc. ] (S) -->
<div id="tabLayer" style="display:none">
    <iframe name="t9frame" id="t9frame" frameborder="0" scrolling="no" width="100%" height="450"></iframe>
</div>
<!-- TAB [ VSL Alloc. ] (E) -->


<!-- TAB [ Slot Rel. ] (S) -->
<div id="tabLayer" style="display:none">
    <iframe name="t10frame" id="t10frame" frameborder="0" scrolling="no" width="100%" height="450"></iframe>
</div>
<!-- TAB [ Slot Rel. ] (E) -->


<!-- TAB [ Slot Swap ] (S) -->
<div id="tabLayer" style="display:none">
    <iframe name="t11frame" id="t11frame" frameborder="0" scrolling="no" width="100%" height="450"></iframe>
</div>
<!-- TAB [ Slot Swap ] (E) -->


<!-- TAB [ Load ] (S) -->
<div id="tabLayer" style="display:none">
    <iframe name="t12frame" id="t12frame" frameborder="0" scrolling="no" width="100%" height="450"></iframe>
</div>
<!-- TAB [ Load ] (E) -->


<!-- TAB [ IPC Over Used ] (S) -->
<div id="tabLayer" style="display:none">
    <iframe name="t13frame" id="t13frame" frameborder="0" scrolling="no" width="100%" height="450"></iframe>
</div>
<!-- TAB [ IPC Over Used ] (E) -->


<!-- TAB [ Remark ] (S) -->
<div id="tabLayer" style="display:none">

	<table class="search"> 
    <tr><td class="bg">
		
			<table class="height_2"><tr><td></td></tr></table>
			
				<table width="100%">
					<tr><td><textarea style="width:99%;height:420" name="remark" class="input2" readonly></textarea></td>
					</tr>
				</table>
			
				<!-- Grid (E) -->

			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable" style="display:none;">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t14sheet1');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->
			
			
			</td></tr>
		</table>
		<!-- Tab BG Box(E) -->

</div>
<!-- TAB [ Remark ] (E) -->
		
	<!--biz page (E)-->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;display:inline;" id="btnTblRDR">
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New" id="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Mail">Mail</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Print"> Print</td>
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

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>