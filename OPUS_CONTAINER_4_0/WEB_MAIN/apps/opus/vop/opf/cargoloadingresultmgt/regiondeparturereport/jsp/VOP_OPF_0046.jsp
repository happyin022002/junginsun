<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_OPF_0046.jsp
*@FileTitle  : RDR Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/17
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.event.VopOpf0046Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopOpf0046Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_eml       = "";
	Logger log = Logger.getLogger("com.clt.apps.CargoLoadingResultMgt.RegionDepartureReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
        strUsr_eml = account.getUsr_eml();

		event = (VopOpf0046Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />

<input type="hidden" name="call_ind2" id="call_ind2" />
<!-- Developer Performance	-->
<input type="hidden" name="flagRetrieveYn" value="N" id="flagRetrieveYn" />


<!-- Report Pop-up relevant item -->
<input type="hidden" size="200" name="com_mrdPath" value="apps/opus/vop/opf/cargoloadingresultmgt/regiondeparturereport/report/VOP_OPF_0145.mrd" id="com_mrdPath" />
<input type="hidden" size="200" name="com_mrdArguments" id="com_mrdArguments" />
<input type="hidden" size="200" name="com_mrdSaveDialogDir" value="c:\\MyFolder\\" id="com_mrdSaveDialogDir" />
<input type="hidden" size="200" name="com_mrdSaveDialogFileName" value="RegionalDepartureReport" id="com_mrdSaveDialogFileName" />
<input type="hidden" size="200" name="com_mrdSaveDialogFileExt" value="pdf" id="com_mrdSaveDialogFileExt" />
<input type="hidden" size="200" name="com_mrdSaveDialogFileExtLimit" value="xls@pdf@bmp@tif" id="com_mrdSaveDialogFileExtLimit" />
<input type="hidden" size="200" name="com_mrdDisableToolbar" id="com_mrdDisableToolbar" />
<input type="hidden" size="200" name="com_mrdTitle" value="Regional Departure Report" id="com_mrdTitle" />
<input type="hidden" size="200" name="com_mrdBodyTitle" id="com_mrdBodyTitle" value='<span style="color:red">Regional Departure Report</span>'/>
<input type="hidden" size="200" name="com_isBatch" value="Y" id="com_isBatch" />

<input type="hidden" name="subFrameid" id="subFrameid" />
<input type="hidden" name="subFrameSrc" id="subFrameSrc" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_New" id="btn_New" type="button">New</button><!--		
		--><button class="btn_normal" name="btn_Delete" id="btn_Delete" type="button">Delete</button><!--
		--><button class="btn_normal" name="btn_Save" id="btn_Save" type="button">Save</button><!--
		--><%-- <button class="btn_normal" name="btn_Print" id="btn_Print" type="button">Print</button> --%>
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
		<table>
			<tbody>
				<colgroup>
					<col width="50px">
					<col width="180px">
					<col width="50px">
					<col width="140px">
					<col width="30px">
					<col width="460px">
				</colgroup>
				<tr class="h23">
                    <th>VVD CD</th>
                    <td>
                        <input type="text" style="width:55px;" class="input1" name="vsl_cd" id="vsl_cd" caption="Vessel Code" maxlength="4" required fullfill dataformat="engup" style="ime-mode:disabled"><input type="text" style="width:38px;" class="input1" name="voy_no" id="voy_no" caption="Schedule Voyage Number" maxlength="4" required fullfill dataformat="engup" style="ime-mode:disabled"><input type="text" style="width:22px;" class="input1" name="dir_cd" id="dir_cd" caption="Schedule Direction Code" maxlength="1" required fullfill  dataformat="engup" style="ime-mode:disabled"><button type="button" class="input_seach_btn" name='btns_searchVvd' id='btns_searchVvd'></button><input type="hidden" name="noname" id="noname">
                    </td>
                    <th>Port</th>
                    <td>
                        <script type="text/javascript">ComComboObject('port_cd', 3, 100, 1, 1, 0);</script><input type="text" style="width:300px;" class="input2" readonly name="port_cd_nm" id="port_cd_nm">
                    </td>
                    <th>Region</th>
                    <td><script type="text/javascript">ComComboObject('region', 2, 180, 0, 1, 1);</script></td>
                    <td width="" align="right"><input type="text" style="width:120;" class="input2" name="sys_create_desc" value="" readonly class="input2"></td>
                </tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
<!-- opus_tab_btn(S) -->
<div class="opus_design_tab">
	<script type="text/javascript">ComTabObject('tab1')</script>
</div>
<!-- opus_tab_btn(E) -->

<!-- TAB [ VSL Mvmt ] (S) -->
<div name="tabLayer" id="tabLayer" style="display:inline">
    <iframe name="ifrVslMvmt" id="ifrVslMvmt" frameborder="0" scrolling="no" width="100%" height="480"></iframe>
</div>
<!-- TAB [ VSL Mvmt ] (E) -->

<!-- TAB [ Slot/WGT Util ] (S) -->
<div name="tabLayer" id="tabLayer" style="display:none">
    <iframe name="ifrSlotWgtUtil" id="ifrSlotWgtUtil" src="" frameborder="0" scrolling="no" width="100%" height="460"></iframe>
</div>
 
<!-- TAB [ Slot/WGT Util ] (E) -->
 
<!-- TAB [ HC/45' ] (S) -->
<div name="tabLayer" id="tabLayer" style="display:none">
    <iframe name="ifrHc45" id="ifrHc45" frameborder="0" src=""  scrolling="no" width="100%" height="450"></iframe>
</div>
<!-- TAB [ HC/45' ] (E) -->


<!-- TAB [ RF ] (S) Other Logic-->
<div name="tabLayer" id="tabLayer" style="display:none">
    <iframe name="ifrRf" id="ifrRf" frameborder="0"  src="" scrolling="no" width="100%" height="450"></iframe>
</div>
<!-- TAB [ RF ] (E) -->
 
<!-- TAB [ VSL Alloc. ] (S) -->
<div name="tabLayer" id="tabLayer" style="display:none">
    <iframe name="ifrVslAlloc" id="ifrVslAlloc" frameborder="0"  src=""  scrolling="no" width="100%" height="450"></iframe>
</div>
<!-- TAB [ VSL Alloc. ] (E) -->

<!-- TAB [ Remark ] (S) -->
<div name="tabLayer" id="tabLayer" style="display:none">
    <iframe name="ifrRemark" id="ifrRemark" frameborder="0" scrolling="no"  src=""  width="100%" height="450"></iframe>
</div>
<!-- TAB [ Remark ] (E) -->

<!-- opus_design_grid(S) -->
<div class="opus_design_grid" style="display:none;">
	<script type="text/javascript">ComSheetObject('sheet1');</script>
	<script type="text/javascript">ComSheetObject('sheet2');</script>
</div>
<!-- opus_design_grid(E) -->
</div>
</form>