<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : ees_cgm_1007.jsp
	 *@FileTitle : Chassis Pool Inquiry/Update
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2013.07.09
	 *@LastModifier : 조경완
	 *@LastVersion : 1.0
	 * 2009.06.02 박의수
	 * 1.0 Creation
	 *--------------------------------------------------
	 * History
	 * 2013.07.09 조경완 [CHM-201325340-01] Role Hard Coding 제거 및 대체 기능 개발
	 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event.EesCgm1007Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%>
<%@ page import="com.hanjin.syscommon.common.util.UserRoleUtil" %>
<%@ page import="com.hanjin.syscommon.common.table.ComUsrRoleVO" %>

<%
	EesCgm1007Event event = null; //PDTO(Data Transfer Object including Parameters)
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

		event = (EesCgm1007Event) request.getAttribute("Event");
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
	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Chassis Pool Inquiry/Update</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body onLoad="setupPage();">
<form name="form" onkeyup="ComKeyEnter('search');">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- 개발자 작업	-->
<input type="hidden" name="intg_cd_id" value="CD02117">
<input type="hidden" name="eq_knd_cd" value="Z">
<input type="hidden" name="eq_no">
<input type="hidden" name ="btn_status">
<input type="hidden" name="eq_orz_cht_chktype">
<input type="hidden" name="eq_orz_cht_rcc_cd">
<input type="hidden" name="eq_orz_cht_lcc_cd">
<input type="hidden" name="eq_orz_cht_scc_cd">
<input type="hidden" name="trole" value="<%=tRole%>">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top: 2; padding-left: 5;">
	<tr>
		<td valign="top"><!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
            <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
            <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->
		<!--biz page (S)-->
		<table class="search" id="mainTable">
			<tr>
				<td class="bg">
				<!--  biz_1  (S)  -->
				<table width="100%" class="search">
					<tr class="h23">
						<td width="70">Pool Name</td>
						<td width="120">
							<script language="javascript">ComComboObject('chss_pool_cd', 1, 70, 0, 1, 1, true);</script>
						</td>
						<td width="60">Location</td>
						<td width="180">
							<script language="javascript">ComComboObject('location', 1, 50, 0, 1, 1, true);</script>&nbsp;<input type="text" style="ime-mode:disabled;width: 50;" class="input" dataformat="engbc" name="scc_cd">&nbsp;<img src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" class="cursor" id="btn_popup" name="ComOpenPopupWithTargetLoc">
						</td>
						<td width="30">Yard</td>
						<td width="220">
							<input type="text" dataformat="engbc" style="width: 130;ime-mode:disabled" class="input" name="crnt_yd_cd">&nbsp;<img src="img/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" class="cursor" id="btn_popup" name="ComOpenPopupWithTargetYard">
						</td>
						<td width="70">Active St.</td>
                        <td width=""><script language="javascript">ComComboObject('aciac_div_cd', 1, 144, 0, 1, 1, true);</script></td>
					</tr>
				</table>
				
				<table class="line_bluedot" border="0">
					<tr>
						<td colspan="6"></td>
					</tr>
				</table>
				
				<!-- Grid  (S) -->
				<table width="100%" id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) -->
				
				<!--  Button_Sub (S) -->
				<table width="100%" class="button">
					<tr>
						<td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0"
									class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_add">Row&nbsp;Add</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0"
									class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_delete">Row Delete</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0"
									class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_loadexcel">Load Excel</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>
                                <td>
                                <table width="100%" border="0" cellpadding="0" cellspacing="0"
                                    class="button">
                                    <tr>
                                        <td class="btn2_left"></td>
                                        <td class="btn2" name="btn_downexcel">Down Excel</td>
                                        <td class="btn2_right"></td>
                                    </tr>
                                </table>
                                </td>								
							</tr>
						</table>
						</td>
					</tr>
				</table>
				<!-- Button_Sub (E) -->
				<!--  biz_1  (E)  -->
				</td>
			</tr>
		</table>
		</td>
	</tr>
</table>
<!--biz page (E)-->

<!--Button (S) -->
<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
	<tr>
		<td class="btn1_bg">
		<table border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td>
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr>
						<td class="btn1_left"></td>
						<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
						<td class="btn1_right"></td>
					</tr>
				</table>
				</td>
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
						<td class="btn1" name="btn_update">Save</td>
						<td class="btn1_right"></td>
					</tr>
				</table>
				</td>
				<td>
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr>
						<td class="btn1_left"></td>
						<td class="btn1" name="btn_downexcel">Down Excel</td>
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

<!-- 개발자 작업  끝 -->
 </form>
<form name="form2">
<input type="hidden" name="sXml" value="<%=xml.replace("\"","'")%>">
</form>
</body>
</html>