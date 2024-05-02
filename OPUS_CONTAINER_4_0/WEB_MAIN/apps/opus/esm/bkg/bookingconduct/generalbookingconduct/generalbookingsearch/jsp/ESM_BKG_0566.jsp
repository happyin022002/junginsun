<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved. 
*@FileName   : esm_bkg_0566.jsp
*@FileTitle  : Booking History (B/L Data)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg0566Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0566Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//Error message

	Logger log = Logger.getLogger("com.clt.apps.GeneralBookingConduct.GeneralBookingSearch");
	
	StringBuffer fileDir = new StringBuffer();
	String home = System.getProperty("user.home");
	if (home != null){
	 	fileDir.append(home);
	}
	String separator = System.getProperty("file.separator");
	if (separator != null){
	 	fileDir.append(separator);
	}
	
	try {	

		event = (EsmBkg0566Event)request.getAttribute("Event");		
		GeneralEventResponse eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript" src="/opuscntr/rpt/script/common_rd.js"></script>
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		}
		loadPage();
	}
</script>
</head>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="com_mrdPath"      value="">
<input type="hidden" name="com_mrdArguments" value="">
<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdArguments">
<input type="hidden" name="com_mrdSaveDialogDir" value="<%=fileDir.toString()%>">
<input type="hidden" name="com_mrdSaveDialogFileName">
<input type="hidden" name="com_mrdSaveDialogFileExt" value="pdf">
<input type="hidden" name="com_mrdSaveDialogFileExtLimit" value="xls@pdf@bmp@tif">
<input type="hidden" name="com_mrdTitle">
<input type="hidden" name="com_mrdDisableToolbar" value="3">
<input type="hidden" name="com_mrdBodyTitle">

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Booking History</span></h2>
		
		<div class="opus_design_btn"><!-- 
		 	--><button type="button" class="btn_normal" name="btn_print" id="btn_print">Print</button><!-- 
			--><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button><!-- 
		--></div>
	</div>	
</div>

<div class="layer_popup_contents">
	<div class="opus_design_inquiry">
		<table>
			<tbody>
				<tr class="h23">
					<th>Booking No.</th>
					<td><input type="text" style="width:120px;" class="input2" name="bkg_no" value="" readonly></td>
					<th>1st VVD</th>
					<td><input type="text" style="width:120px;" class="input2" name="n1st_vvd" value="" readonly></td>			
					<th>T/VVD</th>
					<td><input type="text" style="width:120;" class="input2" name="trnk_vvd" value="" readonly></td>		
				</tr> 
				<tr class="h23">
					<th>B/L No.</th>
					<td><input type="text" style="width:120;" class="input2" value="" name="bl_no"    readonly></td>
					<th title="Port of Loading">POL</th>
					<td><input type="text" style="width:120;" class="input2" value="" name="n1st_pol" readonly></td>			
					<th title="Port of Loading">POL</th>
					<td><input type="text" style="width:120;" class="input2" value="" name="trnk_pol" readonly></td>	
				</tr> 
				<tr class="h23">
					<th>Port Closing</th>
					<td><input type="text" style="width:120;" class="input2" value="" name="port_closing" readonly></td>
					<th>ETB</th>
					<td><input type="text" style="width:120;" class="input2" value="" name="n1st_etb" readonly></td>			
					<th>ETB</th>
					<td><input type="text" style="width:120;" class="input2" value="" name="trnk_etb" readonly></td>						
				</tr> 
				<tr class="h23">
					<th>BDR</th>
					<td><input type="text" style="width:120;" class="input2" value="" name="bdr_dt" readonly></td>
					<th>ETD</th>
					<td><input type="text" style="width:120;" class="input2" value="" name="n1st_etd" readonly></td>			
					<th>ETD</th>
					<td><input type="text" style="width:120;" class="input2" value="" name="trnk_etd" readonly></td>						
				</tr> 
				<tr class="h23">
					<th></th>
					<td><input type="checkbox" name="ca_only"  value="Y" class="trans" id="exID03"><label for="exID03">C/A Only</label></td>
					<th>Search by Item</th>
					<td colspan="3"><script type="text/javascript">ComComboObject('search_by_item', 1, 135, 1);</script></td>						
				</tr>
			</tbody>
		</table>
	</div>
	<div class="opus_design_tab">
		<script type="text/javascript">ComTabObject('tab1')</script>
	</div>
	
	<div class="opus_design_grid"  id="tabLayer" style="display:inline">
			<script type="text/javascript">ComSheetObject('t1sheet1');</script>
	</div>
	<div class="opus_design_grid"  id="tabLayer" style="display:none">
			<script type="text/javascript">ComSheetObject('t2sheet1');</script>
	</div>
	<div class="opus_design_grid"  id="tabLayer" style="display:none">
			<script type="text/javascript">ComSheetObject('t3sheet1');</script>
	</div>
	<div class="opus_design_grid"  id="tabLayer" style="display:none">
			<script type="text/javascript">ComSheetObject('t4sheet1');</script>
	</div>
	
		<script type="text/javascript">comRdObject('report1');</script>
</div>

</form>


<SCRIPT type="text/javascript">
<!--

      with(document.form)
      {
        <%
        if(event != null){ 
            String bkgNo = event.getBkgBlNoVO().getBkgNo();
            String blNo = event.getBkgBlNoVO().getBlNo();
        %>
            eval("bkg_no").value = "<%=bkgNo%>";
            eval("bl_no").value = "<%=blNo%>";
        <% } %>
       }
-->
</SCRIPT>
