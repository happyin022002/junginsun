<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0567.jsp
*@FileTitle : CA Inquiry
*Open Issues : ESM_BKG_0567 화면
*Change history :
*@LastModifyDate : 2009.08.28
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.08.28 이남경
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingcorrection.bdrcorrection.event.EsmBkg0567Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0567Event  event           = null;	//PDTO(Data Transfer Object including Parameters)
	Exception        serverException = null;	//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	String bkgNo  = "";
	String popFlg = "";
	Logger log = Logger.getLogger("com.hanjin.apps.BookingCorrection.BdrCorrection");
	
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
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>CA Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		}
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- 개발자 작업	-->
<input type="hidden" name="com_mrdPath"      value="">
<input type="hidden" name="com_mrdArguments" value="">
<input type="hidden" name="com_mrdTitle"     value="">
<input type="hidden" name="com_mrdBodyTitle" value="">
<input type="hidden" name="com_mrdSaveDialogDir" value="<%=System.getProperty("user.home")+System.getProperty("file.separator")%>">
<input type="hidden" name="com_mrdSaveDialogFileName">
<input type="hidden" name="com_mrdSaveDialogFileExt" value="pdf">
<input type="hidden" name="com_mrdSaveDialogFileExtLimit" value="xls@pdf@bmp@tif">
<input type="hidden" name="com_mrdDisableToolbar" value="3">
<input type="hidden" name="com_mrdPrintPaperSize">

<input type="hidden" name="com_zoomIn" size="200" value="3"> 
<input type="hidden" name="bkg_no_mst" value="">
<input type="hidden" name="ca_no_mst"  value="">
<input type="hidden" name="oldBkgNo"   value="">
<input type="hidden" name="oldBlNo"    value="">
<input type="hidden" name="oldCaNo"    value="">
<input type="hidden" name="popFlg"     value="N">

<% 
if(popFlg.equals("Y")){
%>

<table width="100%" class="popup" cellpadding="10" border="0"> 
	<tr><td class="top"></td></tr>
	<tr>
		<td valign="top">
			<table width="100%" border="0">
			<tr><td height="79" class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;<span id="title"></span></td></tr>
			</table>
<%
}else {
%>     
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top: 2; padding-left: 5; padding-right:5;" >            
	<tr><td valign="top">
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
            <tr><td class="history"><img src="img/icon_history_dot.gif"  align="absmiddle"><span id="navigation"></span></td>
            </tr>
            <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td>
            </tr>
        </table>
<%
}
%>   
		
		<!--biz page (S)-->
		<!-- 1 (S) -->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			
				<!--  biz_1 (S) -->
				<table class="search" border="0" style="width:100%;"> 
					<tr><td height="3"></td></tr>
					<tr class="h23">
						<td width="77">Booking No.</td>
						<td width="160">
						    <input type="text" style="width:120;" class="input1" name="bkg_no" value="" caption="Booking No." maxlength="13" style="ime-mode:disabled" dataformat="uppernum" value="<%=bkgNo%>"></td>
						<td width="47">B/L No.</td>
						<td width="200">
						    <input type="text" style="width:120;" class="input"  name="bl_no"  value="" maxlength="13" style="ime-mode:disabled" dataformat="uppernum"></td>
						<td width="50">C/A No.</td>
						<td><input type="text" style="width:120;" class="input"  name="ca_no"  value="" maxlength="10" style="ime-mode:disabled" dataformat="uppernum"></td>
					</tr>
				</table>
				
				<table class="search" border="0" style="width:979;"> 
					<tr><td height="3"></td></tr>
					<tr class="h23">
						<td width="77">T/VVD</td>
						<td width="160">
						    <input type="text" style="width:120;" class="input2" name="t_vvd"      value="" readonly></td>
						<td width="147">Sailed Date of 1st VVD</td>
						<td width="100">
						    <input type="text" style="width:75;"  class="input2" name="sailed_vvd" value="" readonly></td>
						<td width="30">POR</td>
						<td width="100">
						    <input type="text" style="width:50;"  class="input2" name="por_cd"     value="" readonly>
						    <input type="text" style="width:30;"  class="input2" name="por_nod_cd" value="" readonly></td>
						<td width="25">POL</td>
						<td width="100">
						    <input type="text" style="width:50;"  class="input2" name="pol_cd"     value="" readonly>
						    <input type="text" style="width:30;"  class="input2" name="pol_nod_cd" value="" readonly></td>
						<td width="25">POD</td>
						<td width="100">
						    <input type="text" style="width:50;"  class="input2" name="pod_cd"     value="" readonly>
						    <input type="text" style="width:30;"  class="input2" name="pod_nod_cd" value="" readonly></td>
						<td width="25">DEL</td>
						<td width="">
						    <input type="text" style="width:50;"  class="input2" name="del_cd"     value="" readonly>
						    <input type="text" style="width:30;"  class="input2" name="del_nod_cd" value="" readonly></td>
					</tr>
				</table>
	
				<table class="search" border="0" style="width:100%;"> 
					<tr class="h23">
						<td width="77">Shipper</td>
						<td width=""><input type="text" style="width:30;"  class="input2" name="cust_cnt_cd" value="" readonly>
						             <input type="text" style="width:86;"  class="input2" name="cust_seq"    value="" readonly>
						             <input type="text" style="width:773;" class="input2" name="cust_nm"     value="" readonly></td>
					</tr>
				</table>
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				
				<!-- Grid  (S) -->
					<table width="100%" id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
				<!-- Grid  (S) -->
		</td></tr>
		</table>	
		
		<table class="height_8"><tr><td></td></tr></table>
			
		<!-- Tab (S) -->
  		<table class="tab" border="0" cellpadding="0" cellspacing="0" width="100%">
			<tr>
				<td width="100%">
					<script language="javascript">ComTabObject('tab1')</script>
				</td>
			</tr>
		</table>
	    <!-- Tab (E) -->
				
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
				<!-- Grid  (S) -->
				<!-- Tab1 (S) -->
				<div id="tabLayer" style="display:inline">
					<table class="search">
						<tr>
							<td>
							<!-- : ( Grid ) (S) -->
								<table width="100%"  id="mainTable"> 
									<tr>
										<td width="100%">
											<script language="javascript">ComSheetObject('t1sheet1');</script>
										</td>
									</tr>
								</table>
							<!-- : ( Grid ) (E) -->
							</td>
						</tr>
					</table>
				</div>
				<!-- Tab1 (E) -->

				<!-- Tab2 (S) -->
				<div id="tabLayer" style="display:none">
					<table class="search">
						<tr>
							<td>
							<!-- : ( Grid ) (S) -->
								<table width="100%" id="mainTable"> 
									<tr>
										<td width="100%">
											<script language="javascript">ComSheetObject('t2sheet1');</script>
										</td>
									</tr>
								</table>
							<!-- : ( Grid ) (E) -->
							</td>
						</tr>
					</table>
				</div>
				<!-- Tab2 (E) -->

				<!-- Tab3 (S) -->
				<div id="tabLayer" style="display:none">
					<table class="search">
						<tr>
							<td>
							<!-- : ( Grid ) (S) -->
								<table width="100%"  id="mainTable"> 
									<tr>
										<td width="100%">
											<script language="javascript">ComSheetObject('t3sheet1');</script>
										</td>
									</tr>
								</table>
							<!-- : ( Grid ) (E) -->
							</td>
						</tr>
					</table>
				</div>
				<!-- Tab3 (E) -->
				
				<table class="height_2"><tr><td></td></tr></table>	

				<table class="search" border="0" style="width:100%;"> 
					<tr class="h23">
						<td width="75">Remark(s)</td>
						<td><textarea style="width:100%; height:70;" class="input2" name="remark" value="" readonly></textarea></td>
					</tr>
				</table>
				<!--  biz_1   (E) -->
				
		</td></tr>
		</table>
		<!-- 1 (E) -->
		<!--biz page (E)--> 

   
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td>
			                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn_retrieve">Retrieve</td>
									<td class="btn1_right"></td>
								</tr>
						    </table></td>
						<td class="btn1_line"></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn_ca_kind_detail">C/A Kind Detail</td>
									<td class="btn1_right"></td>
								</tr>
							</table></td>	
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn_down_excel">Down Excel</td>
									<td class="btn1_right"></td>
								</tr>
						    </table></td>	
						 <td class="btn1_line"></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn_print">Print</td>
									<td class="btn1_right"></td>
								</tr>
							</table></td>
				    </tr>
				</table>
			</td></tr>
		</table>
    	<!--Button (E) -->
	
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
<!-- : ( Button : pop ) (E) -->


<!-- RD (S) -->
<table>
    <tr>
      <td width="500" height="1">
          <script language="javascript">comRdObject('report1');</script>
      </td>
   </tr>
</table>
<!-- RD (E) -->

<!-- hidden -->
<table id="mainTable" width="1">
	<tr>
		<td>
			<script language="javascript">ComSheetObject('msgsheet1');</script>
		</td>
	</tr>
</table>
 
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>

<SCRIPT LANGUAGE="javascript">
<!--
      /* 
       * 유저가 입력한 정보를 event를 통해서 다시 넘겨받아 화면에 뿌려주는 부분
       */
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
</SCRIPT>
<%@include file="/bizcommon/include/common_alps.jsp"%>
