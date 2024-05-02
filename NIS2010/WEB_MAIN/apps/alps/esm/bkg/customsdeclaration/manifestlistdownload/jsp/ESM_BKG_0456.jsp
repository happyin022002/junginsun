
<%
	/*=========================================================
	 *Copyright(c) 2017 Hi-Plus Card
	 *@FileName : esm_bkg_0456.jsp
	 *@FileTitle : ESM_BKG-0456
	 *Open Issues :
	 *Change history :
		 2017.09.07 하대성 2017 Renewal Version Transmit 반영
	 *@LastModifyDate : 2017.09.07
	 *@LastModifier : 하대성
	 *@LastVersion : 1.0
	 * 2009.06.03 김승민
	 * 1.0 Creation
	 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page
	import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page
	import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page
	import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page
	import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.event.EsmBkg0456Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0456Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	//int rowCount = 0; //DB ResultSet 리스트의 건수

	//String successFlag = "";
	//String codeList = "";
	//String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String bl_no= "";
	String vvd_cd= "";
	String pod_cd= "";
	//Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");

	try {

		bl_no= request.getParameter("bl_no")==null?"":request.getParameter("bl_no");
		vvd_cd= request.getParameter("vvd_cd")==null?"":request.getParameter("vvd_cd");
		pod_cd= request.getParameter("pod_cd")==null?"":request.getParameter("pod_cd");
		
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0456Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		//GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>ESM_BKG-0456</title>
<meta http-eqEsmv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		//alert("1111");
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows"> 
<input type="hidden" name="cust_type">
<input type="hidden" name="form1_bl_number" value="">
<input type="hidden" name="bl_number" value="<%=bl_no%>">
<input type="hidden" name="form1_vvd_cd" value="">
<input type="hidden" name="vvd_cd" value="<%=vvd_cd%>">
<input type="hidden" name="form1_pod_cd" value="">
<input type="hidden" name="pod_cd" value="<%=pod_cd%>">
<!-- 개발자 작업	-->
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> Manifest Registration(MFR)_Customer Info</span></td></tr>
		</table>	
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
			
			<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Customer  Information</td></tr>
				<tr><td class="height_5"></td></tr>
				</table>
				
				
				<table class="search" border="0" style="width:680;"> 
				<tr class="h23">
					<td width="70">&nbsp;&nbsp;Shipper</td>
					<td width="230"><input type="text" style="width:30;" dataformat="uppernum2" name="form1_cust_cnt_cd" value="" caption="Shipper Country Code" style="ime-mode:disabled" maxlength="2">&nbsp;<input type="text" dataformat="num2" style="width:100;text-align:right" name="form1_cust_seq" value="" style="ime-mode:disabled" maxlength="6">&nbsp;<img class="cursor" src="img/btns_inquiry.gif" width="19" height="20" border="0" name="btn_cust" align="absmiddle"></td>
					<td width="25">Tel.</td>
					<td width="150"><input type="text" style="width:100;" dataformat="num" maxlength="20" name="form1_phn_no" caption="Shipper Tel." style="ime-mode:disabled"></td>
					<td width="30">Fax</td>
					<td><input type="text" style="width:172;" dataformat="num" maxlength="20" name="form1_fax_no" style="ime-mode:disabled"></td>
				</tr>
			</table>
				
				<table border="0" style="width:680; background-color:white;" class="grid2"> 
				<tr class="tr2_head">
					<td width="50">Name</td>
					<td width="200"><textarea style="width:100%" rows="3" dataformat="uppernum" maxlength="500" name="form1_cust_nm" caption="Shipper Name" style="ime-mode:disabled"></textarea></td>
					<td width="60">Address</td>
					<td width=""><textarea style="width:100%" rows="3" dataformat="uppernum" maxlength="500" name="form1_cust_addr" caption="Shipper Address" style="ime-mode:disabled"></textarea></td>
				</tr>
			</table>
			<table class="height_8"><tr><td></td></tr></table>
			
			<table class="search" border="0" style="width:680;"> 
				<tr class="h23">
					<td width="70">&nbsp;&nbsp;Consignee</td>
					<td width="230"><input type="text" style="width:30;" dataformat="uppernum2" name="form1_cust_cnt_cd2" value="" caption="Consignee Country Code" style="ime-mode:disabled" maxlength="2">&nbsp;<input type="text" dataformat="num2" style="width:100;text-align:right" name="form1_cust_seq2" value="" style="ime-mode:disabled" maxlength="6">&nbsp;<img class="cursor" src="img/btns_inquiry.gif" width="19" height="20" border="0" name="btn_cust2" align="absmiddle"></td>
					<td width="25">Tel.</td>
					<td width="150"><input type="text" style="width:100;" dataformat="num" maxlength="20" name="form1_phn_no2" caption="Consignee Tel." style="ime-mode:disabled"></td>
					<td width="30">Fax</td>
					<td><input type="text" style="width:172;" dataformat="num" maxlength="20" name="form1_fax_no2" style="ime-mode:disabled"></td>
				</tr>
			</table>
				
				<table border="0" style="width:680; background-color:white;" class="grid2"> 
				<tr class="tr2_head">
					<td width="50">Name</td>
					<td width="200"><textarea style="width:100%" rows="3" dataformat="uppernum" maxlength="500" name="form1_cust_nm2" caption="Consignee Name" style="ime-mode:disabled"></textarea></td>
					<td width="60">Address</td>
					<td width=""><textarea style="width:100%" rows="3" dataformat="uppernum" maxlength="500" name="form1_cust_addr2" caption="Consignee Address" style="ime-mode:disabled"></textarea></td>
				</tr>
			</table>
			<table class="height_8"><tr><td></td></tr></table>
			
			<table class="search" border="0" style="width:680;"> 
				<tr class="h23">
					<td width="70">&nbsp;&nbsp;Notify</td>
					<td width="230"><input type="text" style="width:30;" dataformat="uppernum2" name="form1_cust_cnt_cd3" value="" caption="Notify Country Code" style="ime-mode:disabled" maxlength="2">&nbsp;<input type="text" dataformat="num2" style="width:100;text-align:right" name="form1_cust_seq3" value="" style="ime-mode:disabled" maxlength="6">&nbsp;<img class="cursor" src="img/btns_inquiry.gif" width="19" height="20" border="0" name="btn_cust3" align="absmiddle"></td>
					<td width="25">Tel.</td>
					<td width="150"><input type="text" style="width:100;" dataformat="num" maxlength="20" name="form1_phn_no3" caption="Notify Tel." style="ime-mode:disabled"></td>
					<td width="30">Fax</td>
					<td><input type="text" style="width:172;" dataformat="num" maxlength="20" name="form1_fax_no3" style="ime-mode:disabled"></td>
				</tr>
			</table>
				
				<table border="0" style="width:680; background-color:white;" class="grid2"> 
				<tr class="tr2_head">
					<td width="50">Name</td>
					<td width="200"><textarea style="width:100%" rows="3" dataformat="uppernum" maxlength="500" name="form1_cust_nm3" caption="Notify Name" style="ime-mode:disabled"></textarea></td>
					<td width="60">Address</td>
					<td width=""><textarea style="width:100%" rows="3" dataformat="uppernum" maxlength="500"name="form1_cust_addr3" caption="Notify Address" style="ime-mode:disabled"></textarea></td>
				</tr>
			</table>
		
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->

<table class="height_5"><tr><td></td></tr></table>
</td></tr>
</table> 
	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
					<td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr></table></td>
					
					<td class="btn1_line"></td>
					
					<td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"></td>
					</tr></table></td>
			</tr>
		</table></td>
			</tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
	    <table width="100%" id="mainTable" style="display:none">
	        <tr>
	            <td width="100%"><script language="javascript">ComSheetObject('sheet1');</script></td>
	        </tr>
	    </table>
</form>	    

</body>
</html>