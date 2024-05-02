<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_EAS_0101.jsp
*@FileTitle : Invoice Issue Preview
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.12
*@LastModifier : 김종옥
*@LastVersion : 1.0 
* 2009.09.11 
* 1.0 최초 생성   
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.eas.dodinvoicemgt.event.EsdEas0101Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	String strOfc_cd 	="";
	String strUsr_id 	= "";
	String strUsr_nm 	= "";
	String strUsr_eml	= "";
	String rd_nm        = "ESD_EAS_1004.mrd";
	
	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	strOfc_cd	= account.getOfc_cd();
	strUsr_id 	= account.getUsr_id();
	strUsr_nm 	= account.getUsr_nm();
	strUsr_eml 	= account.getUsr_eml();	

	// 광양의 경우 Report를 분리
//	if ("KA".equals(strOfc_cd.substring(0,2)) ) {
//		rd_nm = "ESD_EAS_1003.mrd";
//	} else {
//		rd_nm = "ESD_EAS_1001.mrd";
//	}
//    String mrd_path = "apps/alps/esd/eas/dodinvoicemgt/report/ESD_EAS_1003.mrd";

	 String mrd_path = "apps/alps/esd/eas/dodinvoicemgt/report/ESD_EAS_1004.mrd";
    
    //String mrd_param = "/rv cntr_no["+cntrNo+"] st_evnt_dt["+stEvntDt+"] ed_evnt_dt["+edEvntDt+"]";
    //조건에 따라 Where 절을 컨트롤 할 수 있는 동적 쿼리를 만들기 위해서는 반드시 /rp 방식을 사용해야 한다.rv방식은 ##인식못한다.
    //String mrd_param = "/rp ["+invoice_no+"]";
    //String param = new String(C.process(mrd_param, type));
%>

<html>
<head>
<title>Invoice Issue Preview</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
<script language="javascript">
    function setupPage(){
	    loadPage();
	}
</script>
</head>

<body class="popup_bg" onLoad="setupPage();">
<form name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="iPage"> 
<input type="hidden" name="mrd" value="<%=mrd_path%>">
<input type="hidden" name="rd_name" value="<%=rd_nm%>">
<input type="hidden" name="rd_parm">
<input type="hidden" name="send_flg">
<input type="hidden" name="dod_inv_no">
<input type="hidden" name="usr_ofc" value="<%=strOfc_cd%>">

<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	<!-- : ( Title ) (S) -->
	<table width="100%" border="0">
	<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Invoice Issue Preview</td></tr>
	</table>
	<!-- : ( Title ) (E) -->
		<table class="search">
       		<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table border="1" style="width:100%;" height="545" class="grid"> 
				<tr><td><script language='javascript'>comRdObject('rd_invoice');</script></td></tr>
				</table>
				<table class="search" border="0" style="width:100%;"> 
					<tr>
						<td width="60">Attention</td>
						<td width="180"><input type="text" name="cntc_pnt_nm" style="width:150;" class="input2" readOnly></td>
						<td width="25">Tel.</td>
						<td width="180"><input type="text" name="cntc_pnt_phn_no" style="width:150;" class="input2" readOnly></td>
						<td width="25">Fax</td>
						<td width="180"><input type="text" name="cntc_pnt_fax_no"  style="width:150;" class="input2"  readOnly></td>
						<td width="40">E-mail</td>
						<td width=""><input type="text" name="cntc_pnt_eml"  style="width:200;" class="input2" readOnly></td>
					</tr>
				</table>
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
	<!-- Tab BG Box  (S) -->
	<table class="height_5"><tr><td></td></tr></table>		
			</td></tr>
		</table>
	<!--biz page (E)-->
	
	<!-- : ( Button : pop ) (S) -->
	<table width="100%" class="sbutton">
	<tr><td height="71" class="popup">
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_print">INV Print</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_fax">Fax Send</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_email">Email Send</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td>
		</tr>
		</table>
	</td></tr>
	</table>
<!-- : ( Button : pop ) (E) -->	
<table width="100%"  id="mainTable" style=display:none;> 
	<tr>
		<td width="100%">
<!-- hidden 처리 (S)--> <script language="javascript">ComSheetObject('sheet1');</script> <!-- hidden 처리 (E)-->
		</td>
	</tr>
</table>
</form>
</body>
</html>
