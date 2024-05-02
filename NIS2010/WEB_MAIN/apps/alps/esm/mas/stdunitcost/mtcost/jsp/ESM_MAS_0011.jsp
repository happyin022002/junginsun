<%
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_MAS_0011.jsp
*@FileTitle : EQ Repo Cost Route별 Detail Movement 조회
*Open Issues :
*Change history : 
*@LastModifyDate : 2013.07.09
*@LastModifier : KIM SUJUNG
*@LastVersion : 
* 1.0 최초 생성 
* Change history : 
=========================================================*/ 
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.mas.stdunitcost.mtcost.event.EsmMas0011Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmMas0011Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	
	//사용 변수
	String f_cost_yrmon = JSPUtil.getNullNoTrim(request.getParameter("f_cost_yrmon"));
	String f_cntr_tpsz_cd = JSPUtil.getNullNoTrim(request.getParameter("f_cntr_tpsz_cd"));
	String f_ecc_cd = JSPUtil.getNullNoTrim(request.getParameter("f_ecc_cd"));
	
	Logger log = Logger.getLogger("com.hanjin.apps.STDUnitCost.MTCost");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();


		event = (EsmMas0011Event)request.getAttribute("Event");
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
<title>EQ Repo Cost_Route Detail </title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
        var errMessage = "<%=strErrMsg%>";

        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if

        loadPage();
        ComSetFocus(document.form.f_cost_yrmon);
    }
</script>
</head>

<body  onLoad="setupPage();">
<form name="form" onKeyDown="changeSearchSheet();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="v_ofc_cd" value="<%=strOfc_cd %>"> 


<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>


		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->

		<!--Button_L (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
	       	<tr><td class="btn1_bg">

				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<!-- Repeat Pattern -->
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_Retrieve" name="btn_Retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>

					<td class="btn1_line"></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_DownExcel" name="btn_DownExcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->

				</tr></table>

			</td></tr>
		</table>
		<!--Button_L (E) -->


		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">

				<!-- : ( Month ) (S) -->
				<table class="search_in" border="0">
					<tr class="h23">
						<td width="55">YYYY-MM</td>
						<td width="90"><input type="text" class="input1" name="f_cost_yrmon" style="width:60" maxlength="7" onKeyPress="ComKeyOnlyNumber(window)" onBlur="addDash(this , 4);"  onChange="setPeriod(this);" onFocus="this.value=ComReplaceStr(this.value, '-', '');" ></td>
						<td width="160" class='sm'><div id='div_period'></div></td>
						<td width="80">ECC</td>
						<td width="130">
							<script language="javascript">ComComboObject('f_ecc_cd', 1, 80 , 0, 1 )</script></div>
						</td>
						
						<td width="90">Origin/Dest</td>
						<td width="300"><select name="f_ori_dest" style='width:60'>
							<OPTION value='O' selected>Origin</OPTION>
							<OPTION value='D'>Dest.</OPTION>
						</select></td>
						
						
					</tr>
			<!-- 	</table>
				<table class="search" border="0"> -->
					<tr class="h23">
						<td>Type/Size</td>
						<td><script language="javascript">ComComboObject('f_cntr_tpsz_cd', 1, 60 , 0, 1 )</script></td>
						
				 		<td>&nbsp;</td> 
						<td>Location Level</td>
						<td><select name="f_cost_loc_grp_cd" style='width:80' onChange="reSearch1();">
							<OPTION value='Y' selected>Yard</OPTION>
							<OPTION value='L'>Location</OPTION>
						</select></td>
						
						<td><input type="radio" name="f_excl_sts" value="0" class="trans" checked onClick="reSearch();">&nbsp;Within Conti.</td>
						<td><input type="radio" name="f_excl_sts" value="1" class="trans" onClick="reSearch();">&nbsp;Whole Route</td>
						
					</tr>
				</table>
				<!-- : ( Month ) (E) --></td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

		<table class="height_10">
			<tr>
				<td></td>
			</tr>
		</table>

		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">
				<table width="100%" id="mainTable">
					<tr>
						<td><script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

</td></tr>
</table>
<!-- Outer Table (E)-->

<br>

</form>
</body>
</html>