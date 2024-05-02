<%
/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ees_cgm_1002.jsp
 *@FileTitle : Chassis Specification Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2013.07.09
 *@LastModifier : 조경완
 *@LastVersion : 1.0
 * 2009.04.28 박의수
 * 1.0 Creation
 *--------------------------------------------------
 * History
 * 2013.07.09 조경완 [CHM-201325340-01] Role Hard Coding 제거 및 대체 기능 개발
 * 2015.04.28 Chang Young Kim [CHM-201534113] 2015년 1월 소스 보안 결함 건 조치 요청
 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event.EesCgm1002Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%>
<%@ page import="com.hanjin.syscommon.common.util.UserRoleUtil" %>
<%@ page import="com.hanjin.syscommon.common.table.ComUsrRoleVO" %>
<%@ page import="com.hanjin.framework.component.util.StringUtil"%>

<%
	EesCgm1002Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String strOfc_cd = "";
	String tRole = ""; //Transaction Role //chungpa 20100304 transaction role apply
	
	Logger log = Logger.getLogger("com.hanjin.apps.ChassisMgsetMgt.ChassisMgsetOnOffhire");
	String xml = HttpUtil.makeXML(request,response);
	
	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EesCgm1002Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
		//2013-07-09 조경완 Rold Code 하드코딩 대체 
		// 2015 조직코드개편 Chang-Young Kim
		if("SELCON".equals(strOfc_cd)||"NYCRA".equals(strOfc_cd)){
			tRole = "Authenticated";
		}else{
			tRole = "Not Authenticated";
		}
        //chungpa 20100304 transaction role apply end
	} catch (Exception e) {
		out.println(e.toString());
	}
	
    String eq_spec_no =  StringUtil.xssFilter(request.getParameter("eq_spec_no"));
    if(eq_spec_no == null) eq_spec_no = "";
%>
<html>
<head>
<title>Chassis Specification Creation</title>
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

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name ="ofc_cd">
<input type="hidden" name ="eq_knd_cd" value="Z">
<input type="hidden" name ="param_eq_spec_no" value = "<%=eq_spec_no %>">
<input type="hidden" name="trole" value="<%=tRole%>">

<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top: 2; padding-left: 5;">
	<tr>
		<td valign="top">
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
            <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
            <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->

		<!-- : ( Search Options ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">
				<table class="search" border="0">

					<tr>
						<td class="height_5"></td>
					</tr>
					<tr>
						<td class="title_h"></td>
						<td class="title_s">Inquiry</td>
					</tr>
				</table>
				<table class="search_sm" border="0" style="width: 500">
					<tr class="h23"><td width="">
					
				
				<table class="search" border="0" style="width: 100%;">
					<tr class="h23">
						<td width="120">Spec. No. & TP/SZ</td>
						<td width="">
							<!--<script language="javascript">ComComboObject('eq_spec_no', 1, 350, 1, 1, 1, true);</script>-->
							<script language="javascript">ComComboObject('eq_spec_no', 2, 350, 0, 0, 0, false);</script>
							<!-- select style="width: 270;" maxlength="20" class="input1" name="eq_spec_no" onChange="SpecificationNoChg();">
							</select -->
						</td>
					</tr>
					</table>
				</td>
					</tr>
					</table>	
					<table><tr><td class="height_10" colspan="8"></td></tr></table>
					<table class="search" border="0">

					<tr>
						<td class="height_5"></td>
					</tr>
					<tr>
						<td class="title_h"></td>
						<td class="title_s">Creation</td>
					</tr>
				</table>
					<table class="search_sm" border="0" style="width: 500">
					<tr class="h23"><td width="">
						
					<table class="search" border="0" style="width: 100%">
					<tr class="h23">
						<td width="120">Specification No.</td>
						<td width="">
							<input type="text" style="text-align:left;width: 350;ime-mode:disabled" maxlength="20" class="input1" name="eq_spec_no_ins">
							<!-- select style="width: 270;" maxlength="20" class="input1" name="eq_spec_no" onChange="SpecificationNoChg();">
							</select -->
						</td>
					</tr>
					<tr class="h23">
						<td width="">Chassis Type/Size</td>
						<td style="padding-left:2">
							<script language="javascript">ComComboObject('eq_tpsz_cd', 1, 80, 1, 1, 1, false);</script>
							<!-- select style="width: 60;" maxlength="3" class="input1" name="eq_tpsz_cd" onChange="ChassisTypeSizeChg();">
							</select -->
						</td>
					</tr>
					<tr class="h23">
						<td width="">Manufacturer</td>
						<td style="padding-left:2">
							<script language="javascript">ComComboObject('vndr_seq', 1, 350, 1, 1, 1, false);</script>
							<!-- select style="width: 270;" maxlength="6" class="input1" name="vndr_seq" onChange="ManufacturerChg();">
							</select -->
						</td>
					</tr>
				</table>

				<table class="search" border="0">

					<tr>
						<td class="height_5"></td>
					</tr>
					<tr>
						<td class=""></td>
						<td class="title_s">Weight</td>
					</tr>
				</table>
				<table border="0" style="width: 470; background-color: white;" class="grid2">
					<tr>
						<td class="tr2_head">Tare Weight</td>
						<td width="30%"><input type="text" style="text-align:right;width: 70;" maxlength="6" class="input" name="chss_tare_wgt" style="ime-mode:disabled" dataformat="int">&nbsp;kg</td>
						<td width="30%"><input type="text" style="text-align:right;width: 70;" maxlength="6" name="chss_tare_wgtlb" style="ime-mode:disabled" dataformat="int">&nbsp;lbs</td>
					</tr>
					<tr>
						<td class="tr2_head">Payload</td>
						<td width="30%"><input type="text" style="text-align:right;width: 70;" maxlength="6" class="input" name="chss_payld_wgt" style="ime-mode:disabled" dataformat="int">&nbsp;kg</td>
						<td width="30%"><input type="text" style="text-align:right;width: 70;" maxlength="6" name="chss_payld_wgtlb" style="ime-mode:disabled" dataformat="int">&nbsp;lbs</td>
					</tr>
					<tr>
						<td class="tr2_head">Gross Weight</td>
						<td width="30%"><input type="text" style="text-align:right;width: 70;" maxlength="6" class="input2" name="gross_wgt">&nbsp;kg</td>
						<td width="30%"><input type="text" style="text-align:right;width: 70;" maxlength="6" class="input2" name="gross_wgtlb">&nbsp;lbs</td>
					</tr>
				</table>
				<table class="search" border="0">
					<tr>
						<td class="height_5"></td>
					</tr>
					<tr>
						<td class=""></td>
						<td class="title_s">Dimension</td>
					</tr>
				</table>
				<table border="0" style="width: 470; background-color: white;" class="grid2">
					<tr>
						<td class="tr2_head">Length</td>
						<td width="30%">
							<input type="text" style="text-align:right;width: 70;" maxlength="6" name="chss_ttl_dim_len" style="ime-mode:disabled" dataformat="int">&nbsp;mm
						</td>
						<td width="30%">
							<input type="text" style="text-align:right;width: 30;" maxlength="6" class="input" name="chss_ttl_dim_len_ft" style="ime-mode:disabled" dataformat="int">&nbsp;ft&nbsp;&nbsp;&nbsp;
							<input type="text" style="text-align:right;width: 30;" maxlength="6" class="input" name="chss_ttl_dim_len_in" style="ime-mode:disabled" dataformat="int">&nbsp;in
						</td>
					</tr>
					<tr>
						<td class="tr2_head">Width</td>
						<td width="30%">
							<input type="text" style="text-align:right;width: 70;" maxlength="6" name="chss_ttl_dim_wdt" style="ime-mode:disabled" dataformat="int">&nbsp;mm</td>
						<td width="30%">
							<input type="text" style="text-align:right;width: 30;" maxlength="6" class="input" name="chss_ttl_dim_wdt_ft" style="ime-mode:disabled" dataformat="int">&nbsp;ft&nbsp;&nbsp;&nbsp;
							<input type="text" style="text-align:right;width: 30;" maxlength="6" class="input" name="chss_ttl_dim_wdt_in" style="ime-mode:disabled" dataformat="int">&nbsp;in
						</td>
					</tr>
					<tr>
						<td class="tr2_head">Height</td>
						<td width="30%">
							<input type="text" style="text-align:right;width: 70;" maxlength="5" name="chss_ttl_dim_hgt" style="ime-mode:disabled" dataformat="int">&nbsp;mm</td>
						<td width="30%">
							<input type="text" style="text-align:right;width: 30;" maxlength="6" class="input" name="chss_ttl_dim_hgt_ft" style="ime-mode:disabled" dataformat="int">&nbsp;ft&nbsp;&nbsp;&nbsp;
							<input type="text" style="text-align:right;width: 30;" maxlength="6" class="input" name="chss_ttl_dim_hgt_in" style="ime-mode:disabled" dataformat="int">&nbsp;in
						</td>
					</tr>
				</table>
				
</td>
					</tr>
					</table>
				</td>
			</tr>
		</table>
		<!--biz page (E)-->

		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 5; , padding-bottom: 0;">
			<tr>
				<td class="btn1_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
					    <!-- chungpa 20090817 EES_CGM_1002 Retrieve 버튼을 삭제처리하고 Model No 콤보의 값을 선택할때 마다 자동으로 Retrieve를 실행하도록 해주세요 ->ROLLBACK됨-->
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_retrieve">Retrieve</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<!---->
						<td>
						<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_new">New</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td class="btn1_line"></td>
						<td>
						<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_save">Save</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td width="72">
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_delete">Delete</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		<!--Button (E) -->
		</td>
	</tr>
</table>

<div style="display:none;">
	<!-- Grid  (S) -->
		<table width="100%"  id="mainTable"> 
			<tr>
				<td width="100%">
					<script language="javascript">ComSheetObject('sheet1');</script>
				</td>
			</tr>
		</table>
	<!-- Grid  (E) -->
</div>

<!-- 개발자 작업  끝 -->
</form>
<form name="form2">
<input type="hidden" name="sXml" value="<%=xml.replace("\"","'")%>">
</form>
</body>
</html>
