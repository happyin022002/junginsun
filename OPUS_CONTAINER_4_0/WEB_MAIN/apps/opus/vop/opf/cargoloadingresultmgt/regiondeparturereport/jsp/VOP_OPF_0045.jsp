<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_OPF_0045.jsp
*@FileTitle  : RDR Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/1 
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.event.VopOpf0045Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@page import="m2soft.rdsystem.server.core.rddbagent.util.serverexport.ExportInfo"%>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr"%>

<%
	VopOpf0045Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

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
	Logger log = Logger.getLogger("com.clt.apps.CargoLoadingResultMgt.RegionDepartureReport");

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

		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		//Parameters in case of Retrieving TDR
		popYn		= request.getParameter("pop_mode") == null ? "N" : "Y";
		strVslCd	= request.getParameter("vsl_cd") == null ? "" : request.getParameter("vsl_cd");
		strVoyNo	= request.getParameter("voy_no") == null ? "" : request.getParameter("voy_no");
		strDirCd	= request.getParameter("dir_cd") == null ? "" : request.getParameter("dir_cd");
		strRegion	= request.getParameter("region") == null ? "" : request.getParameter("region");
		
		/** In case of Calling in JOO, Set initial Tab Page   **/
		joo_init_tab= request.getParameter("joo_init_tab") == null ? "" : request.getParameter("joo_init_tab");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	var preConds = {
		pop_yn      : "<%=popYn%>",
		vsl_cd   	: "<%=StringUtil.xssFilter(strVslCd)%>",
		voy_no   	: "<%=StringUtil.xssFilter(strVoyNo)%>",
		dir_cd		: "<%=StringUtil.xssFilter(strDirCd)%>",
		region		: "<%=StringUtil.xssFilter(strRegion)%>",
       joo_init_tab : "<%=StringUtil.xssFilter(joo_init_tab)%>"
	};

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();

		if("Y" == preConds.pop_yn) {		

			//Showing close button
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
<%=ConstantMgr.getCompanyCodeToJS()%>	
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" size="200" name="skd_voy_no" value="" id="skd_voy_no" />
<input type="hidden" size="200" name="skd_dir_cd" value="" id="skd_dir_cd" />

<input type="hidden" size="200" name="popYn" value="<%=popYn %>" id="popYn" />
<!-- Developer Performance	-->

<!-- Sending Mail relevant item -->
<input type="hidden" name="com_rdSubSysCd" value="OPF" id="com_rdSubSysCd" />
<input type="hidden" name="com_from" value="<%=strUsr_eml%>" id="com_from" />
<input type="hidden" name="com_recipient" value="" id="com_recipient" />
<input type="hidden" name="com_carbonCopy" value="<%=strUsr_eml%>" id="com_carbonCopy" />
<input type="hidden" name="com_blindCarbonCopy" id="com_blindCarbonCopy" />
<input type="hidden" name="com_subject" value="" id="com_subject" />
<input type="hidden" name="com_fileKey" id="com_fileKey" />
<input type="hidden" name="com_content" id="com_content" />
<input type="hidden" name="com_templateMrd" value="apps/opus/vop/opf/cargoloadingresultmgt/regiondeparturereport/report/VOP_OPF_0146.mrd" id="com_templateMrd" />

<input type="hidden" name="com_rdExportFileName" value="RegionalDepartureReport.txt;RegionalDepartureReport.xls" id="com_rdExportFileName" />
<input type="hidden" name="com_templateMrdArguments" id="com_templateMrdArguments" />
<input type="hidden" name="com_templateMrdDescription" value="UI_OPF_0146.mrd 파일이 첨부되었습니다." id="com_templateMrdDescription" />
<input type="hidden" name="com_rdExportFileType" value="<%=ExportInfo.FTYPE_TXT%>;<%=ExportInfo.FTYPE_XLS%>" id="com_rdExportFileType" />
<!-- Report Pop-up relevant item -->
<input type="hidden" size="200" name="com_mrdPath" value="apps/opus/vop/opf/cargoloadingresultmgt/regiondeparturereport/report/VOP_OPF_0146.mrd" id="com_mrdPath" />
<input type="hidden" size="200" name="com_mrdArguments" id="com_mrdArguments" />
<input type="hidden" size="200" name="com_mrdSaveDialogDir" value="c:\\MyFolder\\" id="com_mrdSaveDialogDir" />
<input type="hidden" size="200" name="com_mrdSaveDialogFileName" value="RegionalDepartureReport" id="com_mrdSaveDialogFileName" />
<input type="hidden" size="200" name="com_mrdSaveDialogFileExt" value="pdf" id="com_mrdSaveDialogFileExt" />

<input type="hidden" size="200" name="com_mrdSaveDialogFileExtLimit" value="xls@pdf@bmp@tif@txt" id="com_mrdSaveDialogFileExtLimit" />
<input type="hidden" size="200" name="com_mrdDisableToolbar" id="com_mrdDisableToolbar" />
<input type="hidden" size="200" name="com_mrdTitle" value="Regional Departure Report" id="com_mrdTitle" />
<input type="hidden" size="200" name="com_mrdBodyTitle" value="Regional Departure Report" id="com_mrdBodyTitle" />
<input type="hidden" size="200" name="com_isBatch" value="Y" id="com_isBatch" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_New" id="btn_New" type="button">New</button><!--
		--><button class="btn_normal" name="btn_Mail" id="btn_Mail" type="button">Mail</button><!--
		--><button class="btn_normal" name="btn_Print" id="btn_Print" type="button">Print</button><!--
		--><a id="popLayer" style="display:none;"><button class="btn_normal" name="btn_Close" id="btn_Close" type="button">Close</button></a>
	</div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search_tab">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table class="search">
			<tbody>
				<colgroup>
					<col width="60">
					<col width="170">
					<col width="55">
					<col width="180">
					<col width="50">
					<col width="350">
					<col width="65">
					<col width="*">
				</colgroup>
				<tr class="h23">
					<th>VVD CD</th>
					<td><input type="text" name="vsl_cd" id="vsl_cd" caption="VVD CD" dataformat="engup" style="width:55px;ime-mode:disabled;" class="input1" maxLength="4" required><!--  
						--><input type="text" name="voy_no" id="voy_no" caption="VVD CD" dataformat="engup" style="width:40px;ime-mode:disabled;" class="input1" maxLength="4" required><!--  
						--><input type="text" name="dir_cd" id="dir_cd" caption="VVD CD" dataformat="enguponly" style="width:20px;ime-mode:disabled;" class="input1" maxLength="1" required><!--
						--><button type="button" class="input_seach_btn" name="vsl_cd_pop" id="vsl_cd_pop"></button><!--  
						--><input type="hidden" style="width:0px;" name="noname" id="noname"></td>
					<th>Region</th>
					<td><script type="text/javascript">ComComboObject('region',2,180,1,1,1);</script></td>
                    <th>Port</th>
                    <td><input type="text" name="port_cd" id="port_cd" caption="Port Code"  style="width:80px"  class="input2" readonly maxLength="5" ><!-- 
                       --><input type="text" style="width:260px;" class="input2" readonly name="port_cd_nm" id="port_cd_nm"></td>
					<th>Operator</th>
					<td><script type="text/javascript">ComComboObject('opr_cd',1,120,0,1,0);</script></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
	<!-- wrap_result(S) -->
	<div class="wrap_result">
<!-- opus_tab_btn(S) -->
<div class="opus_design_tab">
	<script type="text/javascript">ComTabObject('tab1')</script>
</div>
<!-- opus_tab_btn(E) -->

<!-- opus_design_grid(S) -->	
<div class="opus_design_grid clear" id="tabLayer" style="display:inline;">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('t1sheet1');</script>		
	</div>
	<div class="opus_design_data">
		<table class="line_bluedot"><tr><td></td></tr></table>
		<table>
			<tbody>
				<colgroup>
					<col width="100">
					<col width="*">
				</colgroup>
				<tr>
					<th>ETA Next Port</th>
					<td class="pad_btm_4"><input type="text" name="next_port" id="next_port" style="width:50px;" class="input2" readonly><!--  
						--><input type="text" name="next_date" id="next_date" style="width:110px;" class="input2" readonly></td>
				</tr>
				<tr>
					<th>Canal</th>
					<td><input type="text" name="next_canal" id="next_canal" id="next_canal" style="width:50px;" class="input2" readonly><!--  
						--><input type="text" name="eta_canal" id="eta_canal" style="width:110px;" class="input2" readonly></td>
				</tr>
			</tbody>
		</table>
	</div>	
</div>

<!-- TAB [ Add Slot ] (S) -->
<div id="tabLayer" style="display:none;">
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
<!-- opus_design_grid(E) -->

<!-- div class="opus_design_grid clear" id="tabLayer" style="display:none">
	<textarea style="width:100%;height:420px;resize:none;" name="remark" class="input2" readonly></textarea></td>
</div-->
<!-- TAB [ Remark ] (S) -->
<div name="tabLayer" id="tabLayer" style="display:none">
    <textarea style="width:100%;height:420px;resize:none;" name="remark" class="input2" readonly></textarea>
</div>
<!-- TAB [ Remark ] (E) -->

</div>

<!-- opus_design_grid(S) -->
<!-- wrap_result(S) -->
<div class="wrap_result">
	<div class="opus_design_grid" style="display:none;">
		<script type="text/javascript">ComSheetObject('t14sheet1');</script>
	</div>
<!-- opus_design_grid(E) -->
</div>
</form>