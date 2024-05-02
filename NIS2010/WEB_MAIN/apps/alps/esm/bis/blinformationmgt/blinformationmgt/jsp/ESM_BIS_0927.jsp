<%
/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_BIS_0927.jsp
*@FileTitle : B/L Print
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.14
*@LastModifier : 김기택
*@LastVersion : 1.0
* 2012.08.22 김기택
* 1.0 Creation
===============================================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%>
<%@ page import="com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.event.EsmBis0927Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBis0927Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String strOfc_cd = "";
	String strCnt_cd = "";
	Logger log = Logger.getLogger("com.hanjin.apps.blinformationmgt.BLInformationMgtSC");

	String bkg_no = "";
	String bl_no = "";
	String bl_tp_cd = "";
	String manifest = "";
	String form_corr_no = ""; // B/L history key값

	String form_remark = ""; // Draft B/L의 Remark값 - 값이 없을 경우(사용자의 입력이 없을 경우) 기존방식(테이블에서 쿼리로)으로 처리

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		strCnt_cd = account.getCnt_cd();

		event = (EsmBis0927Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		bkg_no         = JSPUtil.getParameter(request,"bkg_no"        ,"" );
		bl_no          = JSPUtil.getParameter(request,"bl_no"         ,"" );
		bl_tp_cd       = JSPUtil.getParameter(request,"bl_tp_cd"      ,"" );
		manifest       = JSPUtil.getParameter(request,"form_manifest" ,"N");
 		form_corr_no   = JSPUtil.getParameter(request,"form_corr_no"  ,"" );
		form_remark    = JSPUtil.getParameter(request,"form_remark"   ,"" );  // JSPUtil.n2Br(str) JSPUtil.replace(form_remark, "\r\n", "|$$|")
		bl_tp_cd = !"W".equalsIgnoreCase(bl_tp_cd) && !"D".equalsIgnoreCase(bl_tp_cd) ? "" : bl_tp_cd;
	} catch(Exception e) {	
		out.println(e.toString());
	}
%>
<html>
<head>
<title>B/L Print</title>
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

<body class="popup_bg" onLoad="setupPage();" onBeforeUnload="unloadPage()">
<form name="form"> 
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="strOfc_cd" value="<%=strOfc_cd%>">
<input type="hidden" name="strCnt_cd" value="<%=strCnt_cd%>">
<input type="hidden" name="first_bkg_no" value="<%=bkg_no%>">
<input type="hidden" name="first_bl_no" value="<%=bl_no%>">
<input type="hidden" name="strUsr_id" value="<%=strUsr_id%>">
<input type="hidden" name="manifest" value="<%=manifest%>">
<input type="hidden" name="bl_tp_cd_param" value="<%=bl_tp_cd%>">
<input type="hidden" name="form_corr_no" value="<%=form_corr_no%>">
<input type="hidden" name="form_remark" value="<%=form_remark%>">
<input type="hidden" name="org_bkg_no" value="<%=bkg_no%>">

<!-- B/L Type Start -->
<input type="hidden" name="form_type" value="">
<!-- B/L Type End -->

<!-- Charge Type Start -->
<!-- <input type="hidden" name="form_Rate" value="1"> -->
<%-- <input type="hidden" name="form_level" value="<%=form_level%>"> --%>
<!-- Charge Type End -->

<!-- Container Type Start -->
<input type="hidden" name="form_Cntr" value="1">
<!-- Container Type End -->

<%-- <input type="hidden" name="fax_no" value="<%=fax_no%>">
<input type="hidden" name="email" value="<%=email%>"> --%>

<!-- RD Start -->
<input type="hidden" name="zratio" value="">
<!-- RD End -->

<input type="hidden" name="eventSrc" value="onload">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0" style="overflow-y:hidden;"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;B/L Preview</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
			
			
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="310">
						<table class="search_sm2" border="0" style="width:220;"> 
							<tr class="h23">
								<td width="40">&nbsp;Type</td>
								<td  class="stm">
									<input type="radio" name="bl_tp_cd" value="" class="trans" id="bl_tp_cd_1"><label for="bl_tp_cd_1">N/N Copy</label>&nbsp;&nbsp;&nbsp;
									<input type="radio" name="bl_tp_cd" value="W" class="trans" id="bl_tp_cd_2"><label for="bl_tp_cd_2">Waybill</label>&nbsp;&nbsp;
							</tr> 
						</table>	
					
					
					</td>
					<td width="80">Booking No.</td>
					<td width="130"><input type="text" name="bkg_no" style="width:110;" class="input" value="<%=bkg_no%>" maxlength="13" dataformat="engup"></td>
					<td width="50">B/L No.</td>
					<td width="140"><input type="text" name="bl_no" style="width:110;" class="input2" value="<%=bl_no%>" maxlength="13" dataformat="engup" readonly></td>
				 	<td width="">&nbsp;</td>
				</tr/>
				</table>
				
				<table class="height_2"><tr><td></td></tr></table>
				
				<table class="search" border="0" style="width:100%;">
				<tr class="h23">
					<td width="400">
						<table class="search_sm2" border="0" style="width:380;"> 
							<tr class="h23">
								<td width="40">&nbsp;Print</td>
								<td  class="stm"><input type="checkbox" name="bl_face" value="Y" class="trans">B/L Face&nbsp;&nbsp;&nbsp;<input type="checkbox" name="bl_rider" value="Y" class="trans">Rider&nbsp;&nbsp;&nbsp;<input type="checkbox" name="bl_houseD" value="Y" class="trans">NVO H/B(D)&nbsp;&nbsp;&nbsp;<input type="checkbox" name="bl_houseS" value="Y" class="trans">NVO H/B(S)</td>
							</tr> 
						</table>	
					</td>
					<td width="">
					<!-- 2012.08.08 -->	
								<td width="50">&nbsp</td> <td width="">&nbsp</td>
					</td>
				</tr> 
				</table>	
				<table class="height_2"><tr><td></td></tr></table>	
				
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="680" align="right">Zoom</td>
					<td width="45"><input type="text" name="RD_Zoom" style="width:40;text-align:center" class="input" value="" maxlength="3" dataformat="int"></td>
					<td width="">
						<img src="img/btns_plus.gif" name="btn_RD_ZoomOut" width="18" height="19" alt="" border="0" style="cursor:hand">
						<img src="img/btns_minus.gif" name="btn_RD_ZoomIn" width="18" height="19" alt="" border="0" style="cursor:hand">
					</td>
					<td align="right">
						<img src="img/btns_back_1.gif" name="btn_RD_FirstPage" width="18" height="19" alt="" border="0" style="cursor:hand">
						<img src="img/btns_back.gif" name="btn_RD_PreviousPage" width="18" height="19" alt="" border="0" style="cursor:hand">
						<img src="img/btns_next.gif" name="btn_RD_NextPage" width="18" height="19" alt="" border="0" style="cursor:hand">
						<img src="img/btns_next_1.gif" name="btn_RD_LastPage" width="18" height="19" alt="" border="0" style="cursor:hand">
					</td>
				</tr>
				</table>	
				<!--  biz_1   (E) -->
			
		</td></tr></table>
		<table class="height_8"><tr><td></td></tr></table>	
		<!-- Tab (S) -->
     	<table class="tab" border="0" cellpadding="0" cellspacing="0"> 
       	<tr><td><script language="javascript">ComTabObject('tab1', null, 880, 25, true)</script></td></tr>
		</table>
		<!-- Tab (E) -->

<!--TAB B/LFace (S) -->
<div id="tabLayer" style="display:inline;">
		<table class="search"> 
       		<tr><td class="bg" height="496" width="860">	
			
			
			<!-- Grid  (S) -->
			<table width="100%" height="100%" class="grid" id="FaceTab"> 
			<tr class="tr_head">
				<td height="450" width="860"><script language="javascript">comRdObject('report1');</script></td>
			</tr>			
			
			</table> 
			<!-- Grid (E) -->	
			
			
			</td></tr>
		</table>
</div>
<!--TAB B/LFace (E) -->


<!--TAB Rider (S) -->
<div id="tabLayer" style="display:none">
		<table class="search"> 
       		<tr><td class="bg" height="496" width="860">	
			
			
			<!-- Grid  (S) -->
			<table width="100%" height="100%" class="grid" id="RiderTab"> 
			<tr class="tr_head">
				<td height="450" width="860"><script language="javascript">comRdObject('report2');</script></td>
			</tr>			
			
			</table> 
			<!-- Grid (E) -->	
			
			
			</td></tr>
		</table>
</div>
<!--TAB Rider (E) -->


<!--TAB NVO H/B(D) (S) -->
<div id="tabLayer" style="display:none">
		<table class="search"> 
       		<tr><td class="bg" height="496" width="860">	
			
			
			<!-- Grid  (S) -->
			<table width="100%" height="100%" class="grid" id="HouseDTab"> 
			<tr class="tr_head">
				<td height="450" width="860"><script language="javascript">comRdObject('report3');</script></td>
			</tr>			
			
			</table> 
			<!-- Grid (E) -->	
			
			
			</td></tr>
		</table>
</div>
<!--TAB NVO H/B(D) (E) -->

<!--TAB NVO H/B(S) (S) -->
<div id="tabLayer" style="display:none">
		<table class="search"> 
       		<tr><td class="bg" height="496" width="860">	
			
			
			<!-- Grid  (S) -->
			<table width="100%" height="100%" class="grid" id="HouseSTab"> 
			<tr class="tr_head">
				<td height="450" width="860">
					<script language="javascript">comRdObject('report4');</script>
				</td>
			</tr>			
			
			</table> 
			<!-- Grid (E) -->	
			
			
			</td></tr>
		</table>
</div>
<!--TAB NVO H/B(S) (E) -->

		<!--biz page (E)-->
<!-- : ( Search Options ) (E) -->

<table class="height_5"><tr><td></td></tr></table>
	
</td></tr>
</table> 
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr>
			<td width="2%"></td>
			<td width="48%" align="left">

		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
					<!-- 2012.08.08 -->	
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td></tr></table></td>
					<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right"></td></tr></table></td>
			</tr>
			</table>
	
			</td>

			<td width="48%" align="right">

		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
					<!-- 2012.08.08 -->		
				<td>&nbsp</td><td>&nbsp</td>
			</tr>
			</table>

			</td>

			<td width="2%"></td>
		</tr>
		<tr style="display:none;">
			<td height="0" width="0">
				<script language="javascript">ComSheetObject('sheet_search');</script>
			</td>
		</tr>
		</table>
	</td>
</tr>
</table>
<!-- : ( Button : pop ) (E) -->

</form>

</body>
</html>