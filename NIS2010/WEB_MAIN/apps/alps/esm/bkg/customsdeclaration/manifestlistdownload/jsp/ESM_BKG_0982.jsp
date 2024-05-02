<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0982.jsp
*@FileTitle : ESM_BKG_0982
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.07.02 경종윤
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

<%@ page import="org.apache.log4j.Logger" %>

<%
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");
	
	String cntCd 	= "";
	String whCd 	= "";
	String cstmsCd 	= "";
	String whNm 	= "";
	String whAddr 	= "";
	String locCd 	= "";
	String locNm 	= "";
	String psonNm 	= "";
	String phnNo 	= "";
	String faxNo 	= "";
	String diffRmk 	= "";
	

	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
		// 부모창에서 넘오온 파라메터 셋팅
		cntCd 		= (request.getParameter("cntCd") == null) 		? "" : request.getParameter("cntCd");
		whCd 		= (request.getParameter("whCd") == null) 		? "" : request.getParameter("whCd");
		cstmsCd 	= (request.getParameter("cstmsCd") == null) 	? "" : request.getParameter("cstmsCd");
		whNm 		= (request.getParameter("whNm") == null) 		? "" : request.getParameter("whNm");
	    whAddr 	  	= (request.getParameter("whAddr") == null) 		? "" : request.getParameter("whAddr");       
	    locCd 		= (request.getParameter("locCd") == null) 		? "" : request.getParameter("locCd");       
	    locNm 		= (request.getParameter("locNm") == null) 		? "" : request.getParameter("locNm");       
	    psonNm 	  	= (request.getParameter("psonNm") == null) 		? "" : request.getParameter("psonNm");       
	    phnNo 		= (request.getParameter("phnNo") == null) 		? "" : request.getParameter("phnNo");
	    faxNo 		= (request.getParameter("faxNo") == null) 		? "" : request.getParameter("faxNo");       
	    diffRmk 	= (request.getParameter("diffRmk") == null) 	? "" : request.getParameter("diffRmk");       
		
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>esm_bkg_0982</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<form name="form"> 

<!-- OUTER - POPUP (S)tart -->
<table width="520" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="520" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;WareHouse Detail Inform</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
		
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:520;"> 
				<tr class="h23">
					<td width="140">Country Code</td>
					<%--<td width="100"><input type="text" style="width:140;" class="input2" name="cnt_cd" value="<%=cntCd%>" readonly></td>--%>
					<td width="100"><input type="text" style="width:20;" class="input2" name="cnt_cd" value="<%=cntCd%>" readonly></td>
					<td width="130" align="right">W/H Abbr. Code&nbsp;</td>
					<td width="150"><input type="text" style="width:100%;" class="input2" name="wh_cd" value="<%=whCd %>"  readonly></td>	
				</tr>
				<tr class="h23">
					<td width="">Customs Code</td>
					<td width="" colspan="3"><input type="text" style="width:80;" class="input2" name="cstms_cd" value="<%=cstmsCd %>" readonly></td>
				</tr>
					<tr class="h23">
					<td width="">Name</td>
					<td width="" colspan="3"><input type="text" style="width:100%;" class="input2" name="wh_nm" value="<%=whNm %>" readonly></td>
				</tr>
				<tr class="h23">
					<td width="">Address</td>
					<td width="" colspan="3"><input type="text" style="width:100%;" class="input2" name="wh_addr"  value="<%=whAddr %>" readonly></td>
				</tr>
				<tr class="h23">
					<td width="">Location</td>
					<td width="" colspan="3">
						<input type="text" style="width:50;" class="input2" name="loc_cd" value="<%=locCd %>" readonly>&nbsp;<input type="text" style="width:366;" class="input2"  name="loc_nm" value="<%=locNm %>" readonly>
					</td>
				</tr>
				<tr class="h23">
					<td width="">Contact Person</td>
					<td width="" colspan="3"><input type="text" style="width:100%;" class="input2" name="pson_nm" value="<%=psonNm %>" readonly></td>
				</tr>
					<tr class="h23">
					<td width="">Telephone</td>
					<td width=""><input type="text" style="width:140;" class="input2" name="phn_no" value="<%=phnNo %>" readonly>
					<td width="" align="right">Fax&nbsp;</td>
					<td width=""><input type="text" style="width:100%;" class="input2" name="fax_no" value="<%=faxNo %>" readonly></td>
				</tr>
				<tr class="h23">
					<td width="">Remark</td>
					<td width="" colspan="3"><input type="text" style="width:100%;" class="input2" name="diff_rmk" value="<%=diffRmk %>" readonly></td>
				</tr>
				</table>				
				<!--  biz_1   (E) -->
			

		</td></tr></table>
		<!--biz page (E)--> 

</td></tr></table>

<table class="height_5"><tr><td></td></tr></table>
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

    	<!--Button (S) -->	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right">
				</tr></table></td>	
				
			</tr>
		</table>
    	<!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
			
</form>			
</body>
</html>

		