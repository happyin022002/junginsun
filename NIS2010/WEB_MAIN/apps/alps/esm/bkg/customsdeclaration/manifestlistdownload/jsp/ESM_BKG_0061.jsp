<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ui_bkg_0661.jsp
*@FileTitle : ROCS_CRN Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.08
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.06.08 임재택
* 1.0 Creation
* 2015.04.20 [CHM-201534307] [ROCS] 네덜란드 세관 더블콜링 보완 관련  
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
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
String vvd_no= ""; 
String pop_up= ""; 
Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");

try {
   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
   	
   	cn_no = StringUtil.xssFilter(request.getParameter("crn_no"))==null?"":StringUtil.xssFilter(request.getParameter("crn_no"));
   	vvd_no =StringUtil.xssFilter(request.getParameter("vvd_no"))==null?"":StringUtil.xssFilter(request.getParameter("vvd_no"));
    
	strUsr_id =	account.getUsr_id();
	ofc_cd    = account.getOfc_cd();  
	strUsr_nm = account.getUsr_nm();

	//event = (EsmBkg0440Event)request.getAttribute("Event");
	serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

	if (serverException != null) {
		strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
	}

	// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
	//GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	 //http//127.0.0.1:7001/hanjin/nis2010Main.screen?pgmNo=ESM_BKG_M001&url=^hanjin^ESM_BKG_0013.do&id=ESM_BKG_0013 						 

}catch(Exception e) {
	out.println(e.toString());
}
	
%>
<html>
<head>
<title>ROCS:Manifest Transmit</title>
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
<input type="hidden" name="bl_no"> 
<input type="hidden" name="bkg_no">
<input type="hidden" name="crn_number">
<input type="hidden" name="user_id" value ="<%=strUsr_id%>">
<input type="hidden" name="cn_no" value="<%=cn_no%>">
<input type="hidden" name="vvd_no" value="<%=vvd_no%>">
<!-- 개발자 작업	-->
<%@include file="../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp" %>
	<!--Page Title, Historical (E)-->
	
	<!--Button (S) -->
		
    <!--Button (E) -->
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">

				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="30">CRN</td>
					<td width="150"><input name="frm_crn_number" maxlength="14" dataformat="uppernum" style="ime-mode: disabled" type="text" style="width:110" value="" class="input1"></td>
					<td width="30">VVD</td>
					<td width="150"><input name="frm_vvd_number"  maxlength="9" dataformat="uppernum"  style="ime-mode: disabled" type="text" style="width:110" value="" class="input1"></td>
					<td width="63">POL</td>
					<td width="150" ><input name="pol_cd"  maxlength="5" dataformat="engupnum"  style="ime-mode: disabled" type="text" style="width:110" value="" class="input"></td>
					 
					<td width="30">POD</td>
					<td width="120"><input name = "pod_cd" type="text" style="width:80" READONLY value=" NLRTM" class="input2"></td>
					<td width="75">Calling Seq.</td>
					<td width="80"><input name = "pod_clpt_ind_seq" type="text" style="width:20" READONLY value="" class="input2"></td>
					
					<td width=""><input type="checkbox" id="cargoType" value="" class="trans">&nbsp;&nbsp;Empty</td>
				</tr>
				<tr class="h23">
					<td width="30">ETA</td>
					<td width="150"><input name="eta_dt"   READONLY type="text" style="width:110" value="" class="input2"></td>
					<td width="30">ETD</td>
					<td width="150"><input name="etd_dt"   type="text" style="width:110" value="" class="input2" READONLY></td>
					<td width="63">VSL Name</td>
					<td width="" colspan="6"><input name="eng_nm" READONLY type="text" style="width:140" value="" class="input2"></td>
				</tr>
				</table>
				
				
				</td></tr>
			</table>
			<table class="height_8"><tr><td></td></tr></table>
		<table class="search"> 
       	<tr><td class="bg">
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
				<td width="75%" valign="top">
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table> 			
				<!-- Grid (E) -->
			</td>
			<td width="1%"></td>			
			<td align="right" width="20%" valign="top">
				<table class="height_8"><tr><td colspan="6"></td></tr></table>	
				<table class="height_8"><tr><td colspan="6"></td></tr></table>	
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="300">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table> 			
            </td> 
            </tr>  
			</table>
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						 
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" id="btn_reject" name="btn_reject">Reject Select</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_confirm">Confirm All</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			
			
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>	
			
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet3');</script>
						</td>
					</tr>
				</table> 			
				<!-- Grid (E) -->
				
		</td></tr>
		</table>
			
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
					<td class="btn1" name="btn_save" id="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>				
				
				<td class="btn1_line"></td>
				<td><table border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>	
				
				<td><table border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_add">Add B/L</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>	
				<td><table border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_del">Row Delete</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>	
				<td><table border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_trans">Trans to PortInfoLink</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>	
				<td><table border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_view">B/L View</td>
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
		
		<br>
	    <!-임시 (S)-->
	    <!--  <table style="width:979;height:100">
	    	<tr><td>result : </td></tr>
	        <tr>
	            <td><textarea name="output" cols="100" rows="20"></textarea></td>
	        </tr>
	    </table>-->
	    
<%@include file="../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_CLOSE.jsp" %>	 
</form>
 
</body>
</html>