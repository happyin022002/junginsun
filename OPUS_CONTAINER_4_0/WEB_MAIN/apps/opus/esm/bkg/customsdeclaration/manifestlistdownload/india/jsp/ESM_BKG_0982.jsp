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
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>

<%@ page import="org.apache.log4j.Logger" %>

<%
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");

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
		cntCd 		= JSPUtil.getParameter(request, ("cntCd"));
		whCd 		= JSPUtil.getParameter(request, ("whCd"));
		cstmsCd 	= JSPUtil.getParameter(request, ("cstmsCd"));
		whNm 		= JSPUtil.getParameter(request, ("whNm"));
		whAddr 	  	= JSPUtil.getParameter(request, ("whAddr"));
		locCd 		= JSPUtil.getParameter(request, ("locCd"));
		locNm 		= JSPUtil.getParameter(request, ("locNm"));
		psonNm 	  	= JSPUtil.getParameter(request, ("psonNm"));
		phnNo 		= JSPUtil.getParameter(request, ("phnNo"));
		faxNo 		= JSPUtil.getParameter(request, ("faxNo"));
		diffRmk 	= JSPUtil.getParameter(request, ("diffRmk"));


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


<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>WareHouse Detail Inform</span></h2>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
			<table class="search" border="0">

			<tr><td class="bg">

				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:520;">
				<tr class="h23">
					<td width="140">Country Code</td>
					<td width="100"><input type="text" style="width:20;" class="input2" name="cnt_cd" value="<%=cntCd%>" readOnly></td>
					<td width="130" align="right">W/H Abbr. Code&nbsp;</td>
					<td width="150"><input type="text" style="width:100%;" class="input2" name="wh_cd" value="<%=whCd %>"  readOnly></td>
				</tr>
				<tr class="h23">
					<td width="">Customs Code</td>
					<td width="" colspan="3"><input type="text" style="width:80;" class="input2" name="cstms_cd" value="<%=cstmsCd %>" readOnly></td>
				</tr>
					<tr class="h23">
					<td width="">Name</td>
					<td width="" colspan="3"><input type="text" style="width:100%;" class="input2" name="wh_nm" value="<%=whNm %>" readOnly></td>
				</tr>
				<tr class="h23">
					<td width="">Address</td>
					<td width="" colspan="3"><input type="text" style="width:100%;" class="input2" name="wh_addr"  value="<%=whAddr %>" readOnly></td>
				</tr>
				<tr class="h23">
					<td width="">Location</td>
					<td width="" colspan="3">
						<input type="text" style="width:50;" class="input2" name="loc_cd" value="<%=locCd %>" readOnly>&nbsp;<input type="text" style="width:366;" class="input2"  name="loc_nm" value="<%=locNm %>" readOnly>
					</td>
				</tr>
				<tr class="h23">
					<td width="">Contact Person</td>
					<td width="" colspan="3"><input type="text" style="width:100%;" class="input2" name="pson_nm" value="<%=psonNm %>" readOnly></td>
				</tr>
					<tr class="h23">
					<td width="">Telephone</td>
					<td width=""><input type="text" style="width:140;" class="input2" name="phn_no" value="<%=phnNo %>" readOnly>
					<td width="" align="right">Fax&nbsp;</td>
					<td width=""><input type="text" style="width:100%;" class="input2" name="fax_no" value="<%=faxNo %>" readOnly></td>
				</tr>
				<tr class="h23">
					<td width="">Remark</td>
					<td width="" colspan="3"><input type="text" style="width:100%;" class="input2" name="diff_rmk" value="<%=diffRmk %>" readOnly></td>
				</tr>
				</table>
				<!--  biz_1   (E) -->
		</div>
	</div>
</div>



<div class="opus_design_btn">
		<button type="button" class="btn_normal" name="btn_close" id="btn_close" >Close</button>
</div>

</form>
</body>
</html>

