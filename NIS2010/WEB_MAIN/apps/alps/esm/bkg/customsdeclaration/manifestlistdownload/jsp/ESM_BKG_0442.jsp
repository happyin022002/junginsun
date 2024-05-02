<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ui_bkg_0442.jsp
*@FileTitle : B/L Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.13
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.06.08 임재택
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>

<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.framework.core.controller.util.WebKeys"%>
<%@ page import="com.hanjin.framework.core.view.template.Screen"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.event.EsmBkg007905Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>

<%
 
Exception serverException   = null;			//서버에서 발생한 에러
String strErrMsg = "";						//에러메세지
int rowCount	 = 0;						//DB ResultSet 리스트의 건수

String successFlag = "";
String codeList  = "";
String pageRows  = "100";

String strUsr_id		= "";
String strUsr_nm		= "";
String ofc_cd           = "";
String cn_no= "";
String frm_bl_no= ""; 
Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");

try {
   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
   	
   	cn_no = StringUtil.xssFilter(request.getParameter("crn_no"))==null?"":StringUtil.xssFilter(request.getParameter("crn_no"));
   	frm_bl_no = StringUtil.xssFilter(request.getParameter("frm_bl_no"))==null?"":StringUtil.xssFilter(request.getParameter("frm_bl_no"));
	
	strUsr_id =	account.getUsr_id();
	ofc_cd    = account.getOfc_cd();  
	strUsr_nm = account.getUsr_nm();

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
<title>ROCS:B/L Inquiry</title>
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
<input type="hidden" name="f_flag" value ="SEARCH">
<input type="hidden" name="pagerows">
<input type="hidden" name="vsl_cd"> 
<input type="hidden" name="skd_voy_no"> 
<input type="hidden" name="skd_dir_cd">
<input type="hidden" name="mt_flag">
<input type="hidden" name="pol_cd">
<input type="hidden" name="cntr_no">  
<input type="hidden" name="dif_chr">
<input type="hidden" name="bkg_no">
<input type="hidden" name="bl_tp_cd">
<input type="hidden" name="etc_bkg_no">
<input type="hidden" name="user_id" value ="<%=strUsr_id%>">
<input type="hidden" name="cn_no" value="<%=cn_no%>">
<input type="hidden" name="frm_bl_no" value="<%=frm_bl_no%>">
<!-- 개발자 작업	-->
<%@include file="../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp" %>
	<!--Page Title, Historical (E)-->

	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">

				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="45">CRN</td>
					<td width="160"><input name="frm_crn_number"  style="ime-mode: disabled" dataformat="uppernum" maxlength="14" type="text" style="width:110;" class="input1" value=""></td>
					<td width="41">VVD</td>
					<td width="140"><input name="vvd_number" maxlength="9" READONLY type="text" style="width:90;" class="input2" value=""></td>
					<td width="51">B/L No.</td>
					<td width="170"><input name="bl_no"  style="ime-mode: disabled" maxlength="13" dataformat="uppernum" type="text" style="width:120;" class="input1" value=""></td>
					<td width="91">Freight Term</td>
					<td width="140"><select name="frt_term_cd" style="width:80;">
						<option value="P" selected>PPT</option>
						<option value="C">CCT</option>
						</select></td>
					<td width="61">CUST PRC</td>
					<td width=""><select name="t1_doc_cd" style="width:80;">
						<option value="0" selected> </option>
						<option value="D">T1</option>
						<option value="T">TS</option>
						</select></td>
				</tr></table>
		</td>
		</tr>
		</table>	
		<table class="height_8"><tr><td></td></tr></table>
		<table class="search"> 
       	<tr><td class="bg">
				<!-- >table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="45">Fax No.</td>
					<td width="160"><input name="fax_no"  dataformat="saupja" style="ime-mode: disabled" type="text" style="width:110;"   maxlength="20"  class="input" value=""></td>
					<td width="41">E-Mail</td>
					<td width=""><input name="cust_eml"  style="ime-mode: disabled" type="text" style="width:312;"   maxlength="200"  class="input" value=""></td>
				</tr>
				</table-->
			
			
			<table class="height_2"><tr><td></td></tr></table>
	
			<table border="0" style="width:979; background-color:white;" class="grid2"> 
			<tr class="tr2_head">
				<td width="33%">Shipper &nbsp;&nbsp;
				<input type="text" name="shpr_cnt_cd" dataformat="uppernum" style="width:30;" maxlength="2" class="input" style="ime-mode:disabled">
                <input type="text" name="shpr_cust_seq" dataformat="int" style="width:60;text-align:right;" maxlength="6" class="input" style="ime-mode:disabled">
                <img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name='pop_shipper'></td>
				<td width="33%">Consignee &nbsp;&nbsp;
				<input type="text" name="cnee_cnt_cd" dataformat="uppernum" style="width:30;" maxlength="2" class="input" style="ime-mode:disabled">
                <input type="text" name="cnee_cust_seq" dataformat="int" style="width:60;text-align:right;" maxlength="6" class="input" style="ime-mode:disabled">
                <img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name='pop_consignee'></td>
				<td>Notify &nbsp;&nbsp;
				<input type="text" name="ntfy_cnt_cd" dataformat="uppernum" style="width:30;" maxlength="2" class="input" style="ime-mode:disabled">
                <input type="text" name="ntfy_cust_seq" dataformat="int" style="width:60;text-align:right;" maxlength="6" class="input" style="ime-mode:disabled">
                <img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name='pop_notify'></td>
			</tr>
			<tr>
				<td><textarea name="shpr_addr1"  style="ime-mode: disabled"  id="shpr_addr1"  rows="3" style="width:100%"></textarea></td>
				<td><textarea name="cnee_addr1"  style="ime-mode: disabled"  rows="3" style="width:100%"></textarea></td>
				<td><textarea name="ntfy_addr1"  style="ime-mode: disabled"  rows="3" style="width:100%"></textarea></td>
			</tr>
			<tr>
				<td><textarea name="shpr_addr2"  style="ime-mode: disabled"  rows="3" style="width:100%"></textarea></td>
				<td><textarea name="cnee_addr2"  style="ime-mode: disabled"  rows="3" style="width:100%"></textarea></td>
				<td><textarea name="ntfy_addr2"  style="ime-mode: disabled"  rows="3" style="width:100%"></textarea></td>
			</tr>
			<tr class="tr2_head">
				<td>
				City
				<input type="text" name="shpr_cty_nm" dataformat="etc" style="width:65;" maxlength="500" class="input" style="ime-mode:disabled">
				&nbsp;Country
				<input type="text" name="shpr_cstms_decl_cnt_cd" dataformat="engup" style="width:25;" maxlength="2" class="input" style="ime-mode:disabled">
				&nbsp;ZIP Code
				<input type="text" name="shpr_zip_id" dataformat="zipcode" style="width:85" maxlength="10" class="input" style="ime-mode:disabled"></td>
				
				<td>
				City
				<input type="text" name="cnee_cty_nm" dataformat="etc" style="width:65;" maxlength="500" class="input" style="ime-mode:disabled">
				&nbsp;Country
				<input type="text" name="cnee_cstms_decl_cnt_cd" dataformat="engup" style="width:25;" maxlength="2" class="input" style="ime-mode:disabled">
				&nbsp;ZIP Code
				<input type="text" name="cnee_zip_id" dataformat="zipcode" style="width:85" maxlength="10" class="input" style="ime-mode:disabled"></td>
				
				<td>
				City
				<input type="text" name="ntfy_cty_nm" dataformat="etc" style="width:65;" maxlength="500" class="input" style="ime-mode:disabled">
				&nbsp;Country
				<input type="text" name="ntfy_cstms_decl_cnt_cd" dataformat="engup" style="width:25;" maxlength="2" class="input" style="ime-mode:disabled">
				&nbsp;ZIP Code
				<input type="text" name="ntfy_zip_id" dataformat="zipcode" style="width:85" maxlength="10" class="input" style="ime-mode:disabled"></td>
			</tr>
			<tr class="tr2_head">
				<td>Street
				<input type="text" name="shpr_st_nm" dataformat="etc" style="width:150;" maxlength="50" class="input" style="ime-mode:disabled">
				&nbsp;EORI#
				<input type="text" name="shpr_eori_no" dataformat="etc" style="width:80;" maxlength="20" class="input" style="ime-mode:disabled"></td>
				
				<td>Street
				<input type="text" name="cnee_st_nm" dataformat="etc" style="width:150;" maxlength="50" class="input" style="ime-mode:disabled">
				&nbsp;EORI#
				<input type="text" name="cnee_eori_no" dataformat="etc" style="width:80;" maxlength="20" class="input" style="ime-mode:disabled"></td>
				
				<td>Street
				<input type="text" name="ntfy_st_nm" dataformat="etc" style="width:150;" maxlength="50" class="input" style="ime-mode:disabled">
				&nbsp;EORI#
				<input type="text" name="ntfy_eori_no" dataformat="etc" style="width:80;" maxlength="20" class="input" style="ime-mode:disabled"></td>
			</tr>
			</table>
 
				<!--  biz_1   (E) -->
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Container</td></tr>
				</table>
				
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>			
			<!-- Grid (E) -->
		<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_add1">Row Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_delete1">Row Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Cargo</td></tr>
				</table>
				
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"  style="display:none"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>	
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet3');</script>
						</td>
					</tr>
					
				</table>
					
			<!-- Grid (E) -->
		<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr>
	       	 
	       	<td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">				   
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_add2">Row Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_delete2">Row Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table>
					</td>
				</table>
			</td></tr>
			</table>	
			 
	    	<!-- Button_Sub (E) -->
			</td></tr>
		</table>
 
	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
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
</form>
</body>
</html>