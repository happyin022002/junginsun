<%
/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : vop_opf_2019.jsp
 *@FileTitle : CBF Summary Preview
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.27
 *@LastModifier : 우지석
 *@LastVersion : 1.0
 * 2009.05.27 우지석
 * 1.0 Creation
 -----------------------------------------------------------
 * History
 * 2011.11.24 [CHM-201114488-01] 이준범
 * 제목 : CBF내 Block Stowage 칼럼추가 요청 건
 * 내용 : 1. CBF화면 내 MLB->Block Stowage로 명 변경
 *       2. Block Stowage 데이터가 Booking Main내 Service 
 *          Mode & Route data 에서 I/F 되는지 확인
 *       3. 첨부 UI설계와 같이 Block Stowage 칼럼 추가
 =========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.event.VopOpf2019Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%
	//부모창에서 파라메터 받아오기;
	String vsl_cd 		= "";
	String skd_voy_no 	= "";
	String skd_dir_cd 	= "";
	String yd_cd 		= "";
	String crr_cd 		= "";
	String yd_nm 		= "";
	String cbf_ind_flg 	= "";

	String vsl_slan_cd 	= "";
	String vsl_slan_nm 	= "";

	String bkg_shpr_ownr_flg = "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.CargoLoadingPlanMgt.OwnContainerBookingForecastMgt");
	
	VopOpf2019Event event = null; 		//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; 	//서버에서 발생한 에러
	String strErrMsg = ""; 				//에러메세지
	int rowCount = 0; 					//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";

	try {
		SignOnUserAccount account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (VopOpf2019Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		vsl_cd      = StringUtil.xssFilter(request.getParameter("vsl_cd"))== null?"":StringUtil.xssFilter(request.getParameter("vsl_cd"));
		skd_voy_no  = StringUtil.xssFilter(request.getParameter("skd_voy_no"))== null?"":StringUtil.xssFilter(request.getParameter("skd_voy_no"));
		skd_dir_cd  = StringUtil.xssFilter(request.getParameter("skd_dir_cd"))== null?"":StringUtil.xssFilter(request.getParameter("skd_dir_cd"));
		yd_cd       = StringUtil.xssFilter(request.getParameter("yd_cd"))== null?"":StringUtil.xssFilter(request.getParameter("yd_cd"));
		crr_cd      = StringUtil.xssFilter(request.getParameter("crr_cd"))== null?"":StringUtil.xssFilter(request.getParameter("crr_cd"));
		yd_nm       = StringUtil.xssFilter(request.getParameter("yd_nm"))== null?"":StringUtil.xssFilter(request.getParameter("yd_nm"));
		cbf_ind_flg = StringUtil.xssFilter(request.getParameter("cbf_ind_flg"))== null?"":StringUtil.xssFilter(request.getParameter("cbf_ind_flg"));
		vsl_slan_cd = StringUtil.xssFilter(request.getParameter("vsl_slan_cd"))== null?"":StringUtil.xssFilter(request.getParameter("vsl_slan_cd"));
		vsl_slan_nm = StringUtil.xssFilter(request.getParameter("vsl_slan_nm"))== null?"":StringUtil.xssFilter(request.getParameter("vsl_slan_nm"));
		
		bkg_shpr_ownr_flg = StringUtil.xssFilter(request.getParameter("bkg_shpr_ownr_flg"))== null?"":StringUtil.xssFilter(request.getParameter("bkg_shpr_ownr_flg"));
		
	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>CBF Summary Preview</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} 
		loadPage('<%=bkg_shpr_ownr_flg%>');		
	}
</script>
</head>
<body class="popup_bg" onLoad="setupPage();">
<form name="form">

<input type="hidden" name="f_cmd">
<input type="hidden" name="uid">
<input type="hidden" name="pagerows">
<input type="hidden" name="vsl_slan_cd"       value="<%=vsl_slan_cd%>">
<input type="hidden" name="vsl_slan_nm"       value="<%=vsl_slan_nm%>">
<input type="hidden" name="crr_cd"  	      value="<%=crr_cd%>">
<input type="hidden" name="bkg_shpr_ownr_flg" value="<%=bkg_shpr_ownr_flg%>">
<input type="hidden" name="qty1">
<input type="hidden" name="st_1">
<input type="hidden" name="st_2">
<input type="hidden" name="st_3">
<input type="hidden" name="st_4">
<input type="hidden" name="st_5">
<input type="hidden" name="st_6">
<input type="hidden" name="st_7">
<input type="hidden" name="st_8">
<input type="hidden" name="st_9">
<input type="hidden" name="st_10">
<input type="hidden" name="st_11">
<input type="hidden" name="st_12">
<input type="hidden" name="st_13">
<input type="hidden" name="st_14">
<input type="hidden" name="st_15">
<!-- 개발자 작업	--> <!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0">
	<tr>
		<td class="top"></td>
	</tr>
	<tr>
		<td valign="top"><!-- : ( Title ) (S) -->
			<table width="100%" border="0">
				<tr>
					<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;CBF Summary Preview</td>
				</tr>
			</table>
			<!-- : ( Title ) (E) --> <!-- : ( Search Options ) (S) -->

			<table class="search">
				<tr>
					<td class="bg">
						<table class="search" border="0" style="width:100%;">
							<tr class="h23">
								<td width="50">VVD CD</td>
								<td width="150"><input type="text" style="width: 40;text-align:center;" class="input2" value="<%=vsl_cd%>" name="vsl_cd" readOnly>&nbsp;<input type="text" style="width: 40;text-align:center;" class="input2" value="<%=skd_voy_no%>" name="skd_voy_no" readOnly>&nbsp;<input type="text" style="width: 20;text-align:center;" class="input2" value="<%=skd_dir_cd%>" name="skd_dir_cd" readOnly></td>
								<td width="25">POL</td>
								<td width="400"><input type="text" style="width: 70;text-align:center;" class="input2" value="<%=yd_cd.substring(0, yd_cd.length()-1)%>" name="yd_cd2" readOnly><input type="hidden" name="yd_cd" value="<%=yd_cd%>">&nbsp;<input type="text" style="width: 300;" class="input2" value=" <%=yd_nm%>" name="yd_nm" readOnly></td>
								<td arign="right" style="width: 163; height: 31">
									<div id="cbfIndLayer" style="display:">
									<table class="search_sm2" border="0" style="width: 163;">
										<tr class="h23">
											<td width="33">CBF</td>
											<td width="" class="stm"><input type="radio" value="P" name="cbf_ind_flg" class="trans" <% if("P".equals(cbf_ind_flg)) { %>checked<% } %> readOnly disabled>&nbsp;Pre&nbsp;&nbsp;&nbsp;<input type="radio" value="F" name="cbf_ind_flg" class="trans" <% if("F".equals(cbf_ind_flg)) { %>checked<% } %> readOnly disabled>&nbsp;Final&nbsp;&nbsp;&nbsp;</td>
										</tr>
									</table>
									</div>
								</td>								
							</tr>
						</table>	
					</td>
				</tr>
			</table>
			<table class="height_5">
				<tr>
					<td></td>
				</tr>
			</table>
			<!-- Tab (S) -->
			<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%>
				<tr>
					<td width="100%">
						<script language="javascript">ComTabObject('tab1')</script>					
					</td>
				</tr>
			</table>

			<!-- Tab (E) --> <!--  Tab_1 (S) -->
			<div id="tabLayer" style="display: inline">
			<table class="search">
				<tr>
					<td class="bg">
					 <table class="search" border="0">
						<tr>
							<td class="title_h"></td>
							<td class="title_s">Volume/Weight</td>
							<td align="right"><input type="checkbox" value="Y" class="trans" name="t1sheet1_sum_flg" ><b>Incl. sub summary</b></td>
						</tr>
					</table>	
					<table width="100%" id="mainTable">
						<tr>
							<td width="100%"><script language="javascript">ComSheetObject('t1sheet1');</script>
							</td>
						</tr>
					</table>
					</td>
				</tr>
			</table>
			</div>

			<!--  Tab_2 (E) --> <!--  Tab_3 (S) -->
			<div id="tabLayer" style="display: inline">
			<table class="search">
				<tr>
					<td class="bg">
						<table class="search" border="0">
							<tr>
								<td class="title_h"></td>
								<td class="title_s">Special Cargo</td>
								<td align="right"><input type="checkbox" value="Y" class="trans" name="t2sheet1_sum_flg" ><b>Incl. sub summary</b></td>
							</tr>
						</table>	
						<table class="search">
							<tr>
								<td>
									<table width="100%" id="mainTable2">
										<tr>
											<td width="100%">
												<script language="javascript">ComSheetObject('t2sheet1');</script>
											</td>
										</tr>
									</table>		
								</td>
							</tr>
						</table>
						<table class="line_bluedot">
							<tr>
								<td></td>
							</tr>
						</table>
						<table class="search" border="0">
							<tr>
								<td class="title_h"></td>
								<td class="title_s">Stowage Request</td>
								<td align="right"><input type="checkbox" value="Y" class="trans" name="t2sheet2_sum_flg" ><b>Incl. sub summary</b></td>
							</tr>
						</table>	
						<table class="search">
							<tr>
								<td>
									<table width="100%" id="subTable">
										<tr>
											<td width="100%">
												<script language="javascript">ComSheetObject('t2sheet2');</script>
											</td>
										</tr>
									</table>		
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			</div>

			<!--  Tab_2 (E) --> <!-- : ( Search Options ) (E) -->
		</td>
	</tr>
</table>
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton" border="0" >
	<tr>
		<td height="71" class="popup">
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" >
				<tr>
					<td class="btn3_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td width="">
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn1_WGC">Weight Group (Creation)</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td class="btn1_line"></td>
								<td width="">
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn1_Close">Close</td>
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
<!-- : ( Button : pop ) (E) --> <!-- 개발자 작업  끝 -->

</form>
</body>
</html>
<%@include file="/bizcommon/include/common_nis2010.jsp"%>