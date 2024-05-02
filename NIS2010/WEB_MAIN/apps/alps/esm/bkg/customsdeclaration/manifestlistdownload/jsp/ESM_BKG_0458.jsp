
<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : esm_bkg_0458.jsp
	 *@FileTitle : ESM_BKG-0458
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.06.03
	 *@LastModifier : 김승민
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
	import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.event.EsmBkg0458Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0458Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	//int rowCount = 0; //DB ResultSet 리스트의 건수

	//String successFlag = "";
	//String codeList = "";
	//String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String bl_no= "";
	String gubun= "";
	String callPgm = "";
	//Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");

	try {
		bl_no= request.getParameter("bl_no")==null?"":request.getParameter("bl_no");
		gubun= request.getParameter("gubun")==null?"MFR":request.getParameter("gubun");
		callPgm = request.getParameter("callPgm")==null?"":request.getParameter("callPgm");
		
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0458Event) request.getAttribute("Event");
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
<title>ESM_BKG-0458</title>
<meta http-eqEsmv="Content-Type" content="text/html; charset=UTF-8">
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

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows"> 
<input type="hidden" name="bl_number" value="<%=bl_no%>">
<!-- 개발자 작업	-->
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
<% if(callPgm.equals("ESM_BKG_0730")) { %>				
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> Manifest Registration(MFR)_Marks And Description</span></td></tr>
<% } else if(callPgm.equals("ESM_BKG_0457")) { %>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> Manifest Correction(CMF)_Marks And Description</span></td></tr>
<% } else {%>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> Manifest Registration(MFR)_Marks And Description</span></td></tr>
<% } %>

		</table>	
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
			
			<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Marks And Description</td></tr>
				<tr><td class="height_5"></td></tr>
				</table>
				
				
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="78">Seq.</td>
					<td width="80"><select style="width:60;" name="select_bl_seq" onchange="changeSeq(this)">>
						<!--option value="0" selected>01</option>
						<option value="1"></option-->
						</select></td>
					<td width="55">TTL PKG</td>
					<td width="134"><input type="text" style="width:50;text-align:right" value="" name="pck_qty" dataformat="num3" maxlength="12" style="ime-mode:disabled">&nbsp;<input type="text" style="width:50;" name="pck_tp_cd" dataformat="upper" maxlength="2" value="" style="ime-mode:disabled"></td>
					<td width="55">TTL WGT</td>
					<td width="175"><input type="text" style="width:82;text-align:right" value="" name="grs_wgt" dataformat="num2" maxlength="18" style="ime-mode:disabled">&nbsp;<select style="width:57;" name="wgt_ut_cd" style="ime-mode:disabled">
						<option value="KGS" selected>KGS</option>
						<option value="LBS">LBS</option>
						</select></td>
					<td width="55">TTL MEA</td>
					<td width=""><input type="text" style="width:87;text-align:right" value="" name="meas_qty" dataformat="num2" maxlength="18" style="ime-mode:disabled">&nbsp;<select style="width:57;" name="meas_ut_cd" style="ime-mode:disabled">
						<option value="CBM" selected>CBM</option>
						<option value="CBF">CBF</option>
						</select></td>
				</tr></table>
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
				<tr class="h23">
					<td width="75">Local / TS</td>
					<td width="80"><select style="width:60;" name="locl_ts_flg">
						<option value="L" selected>Local</option>
						<option value="T">TS</option>
						</select></td>
					<td width="104">L / TS using CD</td>
					<td width="85"><select style="width:57;" name="jp_cstms_trns_cd">
						<option value="TRS" selected>TRS</option>
						<option value="TRT">TRT</option>
						<option value="REV">REV</option>
						<option value="POS">POS</option>
						</select></td>
					<td width="125">L / TS using Period</td>
					<td width="106"><input type="text" style="width:72" value="" dataformat="num3" maxlength="15" name="lmt_no" style="ime-mode:disabled"></td>
					<td width="105">CY Operator CD</td>
					<td width=""><input type="text" style="width:96" value="" dataformat="uppernum" maxlength="5" name="cy_opr_cd" style="ime-mode:disabled"></td>
				</tr>
			</table>
			
			<table class="height_5"><tr><td></td></tr></table>
			<table class="search" border="0" style="width:100%;"> 
			<tr class="h23">
			   <td width="316">
					<table border="0" style="width:100%; background-color:white;" class="grid2"> 
					<tr class="tr2_head">
					<td>Marks  &  No.</td>
					</tr>
					<tr>
					<td><textarea style="width:100%;" rows="11" name="diff_rmk" dataformat="uppernum2" style="ime-mode:disabled"></textarea></td>
					</tr>
					</table>
				</td>	
				<td width="25"></td>
				<td>
					<table border="0" style="width:100%; background-color:white;" class="grid2"> 
					<tr class="tr2_head">
					<td>Description</td>
					</tr>
					<tr>
					<td><textarea style="width:100%;" rows="11" name="bl_desc" dataformat="uppernum2" style="ime-mode:disabled"></textarea></td>
					</tr>
					</table>
				</td>	
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
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr></table></td>
					<td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr></table></td>
					<!-- >td class="btn1_line"></td>
					<td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_add">Seq. Add</td>
					<td class="btn1_right"></td>
					</tr></table></td>
					<td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_delete">Delete</td>
					<td class="btn1_right"></td>
					</tr></table></td-->
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