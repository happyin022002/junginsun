<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0567.jsp
*@FileTitle  : Common 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/06
=========================================================
*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.event.EsmBkg0567Event"%>
<%@ page import="java.util.Properties"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0567Event event = null;	//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;	//error from server
	String strErrMsg = "";						//error message
	String bkgNo  = "";
	String popFlg = "";
	String userName = "";
	String fileSeperator = "";
	Logger log = Logger.getLogger("com.clt.apps.BookingCorrection.BdrCorrection");
	StringBuffer fileDir = new StringBuffer();
	try {	
		event = (EsmBkg0567Event)request.getAttribute("Event");		
		GeneralEventResponse eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
		popFlg = JSPUtil.getParameter(request, "popFlg");
		if(popFlg.equals("Y")){
        	bkgNo  = JSPUtil.getNullNoTrim(JSPUtil.getParameter(request, "bkg_no"));
		} else {
        	bkgNo  = JSPUtil.getNullNoTrim(event.getBkgBlNoVO().getBkgNo());			
		}
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
	        strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		String home = System.getProperty("user.home");
		if (home != null){
		 	fileDir.append(home);
		}
		String separator = System.getProperty("file.separator");
		if (separator != null){
		 	fileDir.append(separator);
		}
	
// 		Properties prop = System.getProperties();
// 		userName = prop.getProperty("user.home");
// 		fileSeperator = prop.getProperty("file.separator");
		
		log.debug("[userName]"+userName+"[fileSeperator]"+fileSeperator);
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript" src="/opuscntr/rpt/script/rdviewer50.js"></script>
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		}
		loadPage();
	}
</script>

<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="com_mrdPath" id="com_mrdPath" value="">
<input type="hidden" name="com_mrdArguments" id="com_mrdArguments" value="">
<input type="hidden" name="com_mrdTitle" id="com_mrdTitle" value="">
<input type="hidden" name="com_mrdBodyTitle" id="com_mrdBodyTitle"  value="">
<input type="hidden" name="com_mrdSaveDialogDir" id="com_mrdSaveDialogDir" value="<%= fileDir.toString()%>">
<input type="hidden" name="com_mrdSaveDialogFileName" id="com_mrdSaveDialogFileName">
<input type="hidden" name="com_mrdSaveDialogFileExt" id="com_mrdSaveDialogFileExt" value="pdf">
<input type="hidden" name="com_mrdSaveDialogFileExtLimit" id="com_mrdSaveDialogFileExtLimit" value="xls@pdf@bmp@tif">
<input type="hidden" name="com_mrdDisableToolbar" id="com_mrdDisableToolbar" value="3">
<input type="hidden" name="com_mrdPrintPaperSize" id="com_mrdPrintPaperSize">
<input type="hidden" name="com_zoomIn" id="com_zoomIn" size="200" value="3"> 
<input type="hidden" name="bkg_no_mst" id="bkg_no_mst" value="">
<input type="hidden" name="ca_no_mst" id="ca_no_mst" value="">
<input type="hidden" name="oldBkgNo" id="oldBkgNo"  value="">
<input type="hidden" name="oldBlNo" id="oldBlNo" value="">
<input type="hidden" name="oldCaNo"  id="oldCaNo" value="">
<input type="hidden" name="popFlg" id="popFlg" value="N">
<% 
if(popFlg.equals("Y")){
%>

<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--  
		--><button type="button" class="btn_normal" name="btn_ca_kind_detail" id="btn_ca_kind_detail">C/A Kind Detail</button><!--  
		--><button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button><!--  
		--><button type="button" class="btn_normal" name="btn_print" id="btn_print">Print</button>
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<%
}else {
%>     
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_ca_kind_detail" id="btn_ca_kind_detail">C/A Kind Detail</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_print" id="btn_print">Print</button>
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>

<%
}
%>   

<div class= "wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class= "opus_design_inquiry wFit">
		<table>
			<tbody>
				<tr>
					<th>Booking No.</th>
					<td>
						<input type="text" style="width:120px;" class="input1" name="bkg_no" id="bkg_no" value="" maxlength="13" style="ime-mode:disabled" dataformat="engup" value="<%=bkgNo%>" onkeydown="bkg0567_keydown();">
					</td>
					<th>B/L No.</th>
					<td>
						<input type="text" style="width:120px;" class="input"  name="bl_no" id="bl_no" value="" maxlength="13" style="ime-mode:disabled" dataformat="engup" onkeydown="bkg0567_keydown();">
					</td>
					<th>C/A No.</th>
					<td colspan="7">
						<input type="text" style="width:120px;" class="input"  name="ca_no" id="ca_no" value="" maxlength="10" style="ime-mode:disabled" dataformat="engup" onkeydown="bkg0567_keydown();">
					</td>
				</tr>
				<tr>
					<th width="60">T/VVD</th>
					<td width="60">
						<input type="text" style="width:120px;" class="input2" name="t_vvd" id="t_vvd" value="" readonly>
					</td>
					<th width="140">Sailed Date of 1st VVD</th>
					<td width="130">
						<input type="text" style="width:75px;" class="input2" name="sailed_vvd" id="sailed_vvd" value="" readonly>
					</td>
					<th width="60">POR</th>
					<td width="90">
						<input type="text" style="width:50px;"  class="input2" name="por_cd" id="por_cd" value="" readonly><!--
						--><input type="text" style="width:30px;"  class="input2" name="por_nod_cd" id="por_nod_cd"  value="" readonly>
					</td>
					<th width="30">POL</th>
					<td width="90">
						<input type="text" style="width:50px;"  class="input2" name="pol_cd" id="pol_cd"  value="" readonly><!--
						--><input type="text" style="width:30px;"  class="input2" name="pol_nod_cd" id="pol_nod_cd"  value="" readonly>
					</td>
					<th width="30">POD</th>
					<td width="60">
						 <input type="text" style="width:50px;"  class="input2" name="pod_cd"  id="pod_cd"    value="" readonly><!--
						 --><input type="text" style="width:30px;"  class="input2" name="pod_nod_cd" id="pod_nod_cd"  value="" readonly>
					</td>
					<th width="30">DEL</th>
					<td>
						  <input type="text" style="width:50px;"  class="input2" name="del_cd"  id="del_cd"     value="" readonly><!--
						  --><input type="text" style="width:30px;"  class="input2" name="del_nod_cd" id="del_nod_cd"  value="" readonly>
					</td>
				</tr>
			<tr>
				<th>Shipper</th>
				<td colspan="11">
					<input type="text" style="width:30px;"  class="input2" name="cust_cnt_cd" id="cust_cnt_cd"  value="" readonly><!--
		            --><input type="text" style="width:86px;"  class="input2" name="cust_seq"  id="cust_seq"    value="" readonly><!--
		            --><input type="text" style="width:812px;" class="input2" name="cust_nm"  id="cust_nm"    value="" readonly>
				</td>
			</tr>
		</tbody>
	</table>
	
</div>	
</div>
	
<div class="wrap_result">	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
	
<!-- opus_design_inquiry(E) -->
	
<!-- opus_tab_btn(S) -->
<div class="opus_design_tab">
	<script type="text/javascript">ComTabObject('tab1')</script>
</div>
<!-- opus_tab_btn(E) -->

<!-- opus_design_grid(S) -->
<div class="opus_design_grid clear"  name="tabLayer" id="tabLayer">
	<script type="text/javascript">ComSheetObject('t1sheet1');</script>
</div>
<div class="opus_design_grid clear"  name="tabLayer" id="tabLayer">
	<script type="text/javascript">ComSheetObject('t2sheet1');</script>
</div>
<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">
	<script type="text/javascript">ComSheetObject('t3sheet1');</script>
</div>
<!-- opus_design_grid(E) -->


	<table class="grid2 mar_top_12"> 
		<tr>
			<td style="width: 80px; padding-left: 10px; font-weight: bold;">
				Remark(s)
			</td>
			<td style="padding-right: 20px;">
				<textarea style="width :100%; height: 70px;" class="input2" name="remark" id="remark" value="" readonly></textarea>
			</td>
		</tr>
	</table>
	

<%
if(popFlg.equals("Y")){
%>
<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup">
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
				<tr>
					<td class="btn3_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td>
										<td class="btn1" name="btn_Close" onClick="self.close()">Close</td>
										<td class="btn1_right"></td>
									</tr>
								</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<script>
	if(typeof(document.getElementById("title")) != "undefined"){
		document.getElementById("title").innerHTML = curTitle;
		document.body.className ="popup_bg";
	}
</script>
<%
}
%>		

<!-- <div class="opus_design_grid" style="width:50%"> -->
<!-- 	<div class="opus_design_grid clear"> -->
<!-- 		<script type="text/javascript">ComSheetObject('report1');</script> -->
<!-- 	</div> -->
<!-- </div> -->

<!-- <div class="opus_design_grid" style="width:50%"> -->
<!-- 	<div class="opus_design_grid clear"> -->
<!-- 		<script type="text/javascript">ComSheetObject('msgsheet1');</script> -->
<!-- 	</div> -->
<!-- </div> -->
</div>	
<script type="text/javascript">
<!--
      with(document.form)
      {
        <%
        if(event != null){ 
            bkgNo  = JSPUtil.getNullNoTrim(event.getBkgBlNoVO().getBkgNo());
            popFlg = JSPUtil.getNullNoTrim(event.getPopFlg());
        %>
            eval("bkg_no").value = "<%=bkgNo%>"; 
            eval("popFlg").value = "<%=popFlg%>"; 
        <% } %>
     }
-->
</script>
</form>