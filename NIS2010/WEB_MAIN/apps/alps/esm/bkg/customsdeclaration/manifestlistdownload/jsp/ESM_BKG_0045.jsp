<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ui_bkg_0045.jsp
*@FileTitle : ACI_Vessel Information
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.04.24 정재엽
* 1.0 Creation
* --------------------------------------------------
* History
* 2011.10.19 김보배 [CHM-201114022] ANCS > BL inquiry< Download 버튼 제거
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>	
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.event.EsmBkg0045Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0045Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0045Event)request.getAttribute("Event");
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
<title>B/L View</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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

<body  onLoad="setupPage();">
<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="frm_sheet1_attr_ctnt2">

<%
	String vvd   = (request.getParameter("vvd") == null)? "":request.getParameter("vvd");
	String ssrNo = (request.getParameter("ssr_no")== null)?"":request.getParameter("ssr_no");
	String pod   = (request.getParameter("pod")== null)?"":request.getParameter("pod");
	String blNo   = (request.getParameter("bl_no")== null)?"":request.getParameter("bl_no");
	String popup   = (request.getParameter("popup")== null)?"":request.getParameter("popup");
	String kind   = (request.getParameter("pKind")== null)?"N":request.getParameter("pKind");
	
%>
<!-- 개발자 작업	-->
<input type="hidden" name="popup" value="<%=popup %>">
<input type="hidden" name="kind" value="<%=kind %>">
<%@include file="../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp" %>
	<!--Page Title, Historical (E)-->
	
	<!--biz page (S)-->
	<table class="search"> 
       	<tr><td class="bg">
			<!--  biz_1  (S) -->
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="50">B/L No.</td>
				<td width="160"><input type="text" style="width:130"  name="bl_no" class="input1" maxlength="12" dataformat="ennum" value="<%=blNo %>"></td>
				<td width="65">Article No.</td>
				<td width="100"><input type="text" style="width:50" name="frm_sheet1_vvd_seq" class="input2" maxlength="3" dataformat="int" readOnly></td>
				<td width="30">VVD</td>
				<td width="110"><input type="text" style="width:80;ime-mode:disabled" name="frm_sheet1_vvd" class="input2" maxlength="9" dataformat="ennum" readOnly value="<%=vvd %>"></td>
				<td width="50">SSR No.</td>
				<td width="100"><input type="text" style="width:60;ime-mode:disabled" name="frm_sheet1_svc_rqst_no" class="input2" maxlength="7" dataformat="int" readOnly value="<%=ssrNo %>"></td>
				<td width="70">CUST PRC</td>
				<td width=""><input type="text" style="width:60"  name="frm_sheet1_cstms_prc_cd" class="input2" maxlength="1" dataformat="ennum" readOnly></td>
			</tr>
			</table>
			<!--  biz_1   (E) -->
			<table class="search" border="0">
			<tr><td class="title_h"></td>
				<td class="title_s">Container</td></tr>
			</table>
				<!-- Grid_2 (S) -->
			<table width="100%"  id="mainTable">
				<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
				</tr>
			</table>
			<!-- Grid_2 (E) -->	
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Article</td></tr>
				</table>	
			<!-- Box  (S) -->
			<table width="979" class="grid2" id="mainTable"> 
				<tr>
					<td class="tr2_head" width="70">Select</td>
					<td width="50" align="center"><input type="checkbox" value="" class="trans" name="frm_article_chk"  onclick="chkCmt()" ></td>
					<td class="tr2_head" width="70">ACPT</td>
					<td class="input2" width="33"><input type="text" style="width:30" name="frm_sheet1_bl_ack" class="noinput2" readOnly></td>
					<td class="tr2_head" width="80">Last EDI</td>
					<td class="input2" width="65"><input type="text" style="width:60" name="frm_sheet1_bl_last_edi2" class="noinput2"  readOnly></td>
					<td class="tr2_head" width="66">N.Fax</td>
					<td class="input" width="105"><input class="noinput" type="text" style="width:100" name="frm_sheet1_fax_no" maxlength="20" dataformat="ennum" ></td>
					<td class="tr2_head" width="66">N.Email</td>
					<td class="input" width=""><input class="noinput" type="text" style="width:100%" name="frm_sheet1_ntfy_eml" maxlength="40"  ></td>
				</tr>							
			</table> 
			<!-- Box (E) -->
			<table class="height_5"><tr><td></td></tr></table>
			<!-- Box  (S) -->
			<table width="979" class="grid2" id="mainTable"> 
			<tr class="tr2_head">
				<td width="300">Shipper Address</td>
				<td width="22"><img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_shipper"></td>
				<td width="300">Consignee Address	</td>
				<td width="22"><img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0"  align="absmiddle" name="btn_cnee"></td>
				<td width="300">Notify Address</td>
				<td><img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0"  align="absmiddle" name="btn_noty"></td>
			</tr>
			<tr>
				<td colspan="2"><textarea style="ime-mode: disabled" rows="3" name="frm_sheet1_shpr_name" style="width:100%" ></textarea></td>
				<td colspan="2"><textarea style="ime-mode: disabled" rows="3" name="frm_sheet1_cnee_name" style="width:100%"></textarea></td>
				<td colspan="2"><textarea style="ime-mode: disabled" rows="3" name="frm_sheet1_ntfy_name" style="width:100%"></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><textarea style="ime-mode: disabled" rows="3" name="frm_sheet1_shpr_addr" style="width:100%"></textarea></td>
				<td colspan="2"><textarea style="ime-mode: disabled" rows="3" name="frm_sheet1_cnee_addr" style="width:100%"></textarea></td>
				<td colspan="2"><textarea style="ime-mode: disabled" rows="3" name="frm_sheet1_ntfy_addr" style="width:100%"></textarea></td>
			</tr>							
			</table> 
			<!-- Box (E) -->		
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>	
			<!-- Grid_2 (S) -->
			<table width="100%"  id="mainTable">
				<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet3');</script>
						</td>
				</tr>
			</table>
			<!-- Grid_2 (E) -->	
			<!--sub Button (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0"> 
			<tr><td class="btn2_bg">
	   			<table border="0" cellpadding="0" cellspacing="0">
	  		  	<tr>
				<td width="170">Transmit As&nbsp;<select style="width:76;" class="input1" name="transmit" onclick="on_transmission()">
				<option value="O" selected="selected" >Original</option>
				<option value="T">Correction</option>
				<option value="C">Cancel</option>
				<option value="N"></option>
				</select></td>
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn2_left"></td>
				<td class="btn2" name="btn_RowAdd">Row Add</td>
				<td class="btn2_right"></td>
				</tr>
				</table></td>	
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn2_left"></td>
				<td class="btn2" name="btn_RowDelete">Row Delete</td>
				<td class="btn2_right"></td>
				</tr>
			</table></td>				
			
			</tr>
			</table>
		</td></tr>
		<tr height="4"><td></td></tr>
		</table>
    	<!--sub Button (E) -->
    	</td></tr>
		</table>
		<!--Space (S) -->
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>				
				<td><table border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>	
				<td><table border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>	
				
				<td><table border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_cuscar">CUSCAR</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>	
				<td><table border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_transfer">CUSCAR Transmit</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>	
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_contact">Contact Point</td>
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
<%@include file="../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_CLOSE.jsp" %>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>