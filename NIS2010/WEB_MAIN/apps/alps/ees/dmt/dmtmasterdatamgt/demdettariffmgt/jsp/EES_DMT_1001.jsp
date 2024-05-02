<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_1001.jsp
*@FileTitle : Basic Tariff Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.06.04 김태균
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
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.event.EesDmt1001Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EesDmt1001Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.DMTMasterDataMgt.DemDetTariffMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesDmt1001Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	    
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Basic Tariff Creation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">

	<%= JSPUtil.getIBCodeCombo("f_dmdt_de_term_cd" , "", "CD03257", 0, "")%>

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
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="conti_cd">
<input type="hidden" name="cnt_cd">
<input type="hidden" name="rgn_cd">
<input type="hidden" name="ste_cd">
<input type="hidden" name="loc_cd">
<input type="hidden" name="yd_cd">

<input type="hidden" name="dmdt_trf_cd">
<input type="hidden" name="cvrg_conti_cd">
<input type="hidden" name="cvrg_cnt_cd">
<input type="hidden" name="cvrg_rgn_cd">
<input type="hidden" name="cvrg_ste_cd">
<input type="hidden" name="cvrg_loc_cd">
<input type="hidden" name="cvrg_yd_cd">
<input type="hidden" name="dmdt_de_term_cd">
<input type="hidden" name="dmdt_de_term_nm">
<input type="hidden" name="org_dest_conti_cd">
<input type="hidden" name="org_dest_cnt_cd">
<input type="hidden" name="org_dest_rgn_cd">
<input type="hidden" name="org_dest_ste_cd">
<input type="hidden" name="org_dest_loc_cd">
<input type="hidden" name="svr_id">
<input type="hidden" name="trf_seq">
<input type="hidden" name="trf_grp_seq">

<input type="hidden" name="wknd1" value="SAT">
<input type="hidden" name="wknd2" value="SUN">

<input type="hidden" name="sysdate" value="">

<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></tr>
		</table>
	<!--Page Title, Historical (E)-->
	
	
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="82">Tariff Type</td>
					<td width="500"><script language="javascript">ComComboObject('combo1', 2, 96 , 0, 1, 0, true)</script>
					&nbsp;<input type="text" name="dmdt_trf_nm" style="width:368;" class="input2" readonly value=""></td>
					<td width="68">Confirmed</td>
					<td width=""><input type="text" name="confirm_yn" style="width:50;" class="input2" value="" readonly></td>
					</tr> 
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="80">Coverage</td>
					<td width="120" class="stm">Continent&nbsp;<script language="javascript">ComComboObject('combo2', 2, 40 , 0, 1, 0, true)</script></td>
					<td width="120" class="stm">Country&nbsp;<script language="javascript">ComComboObject('combo3', 2, 50 , 0, 1, 0, true)</script></td>
					<td width="42" class="stm"><span id="Region">Region</span></td>
					<td width="78">&nbsp;<script language="javascript">ComComboObject('combo4', 2, 60 , 0, 0, 0, true)</script></td>
					<td width="120" class="stm">Location&nbsp;<input type="text" id="cvrg_location" name="cvrg_location" caption="Location" maxlength="5" fullfill style="width:60;" class="input" value="" dataformat="engup" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('upper')" OnKeyUp="checkLocation1(this)"></td>
					<td width="160" class="stm">Yard&nbsp;<input type="text" id="yd_cd1" name="yd_cd1" style="width:60;" class="input" value="" dataformat="engup" maxlength="5" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('upper')" OnKeyUp="checkYard1(this)" >&nbsp;<script language="javascript">ComComboObject('combo5', 2, 50 , 0, 0, 0, true)</script></td>
					<td             class="stm">BKG Term&nbsp;<script language="javascript">ComComboObject('combo6', 2, 60, 1, 1, 0, true);</script></td></tr>
				<tr class="h23">
					<td><span id="OriginDest">Origin</span></td>
					<td class="stm">Continent&nbsp;<script language="javascript">ComComboObject('combo7', 2, 40 , 0, 1, 0, true)</script></td>
					<td class="stm">Country&nbsp;<script language="javascript">ComComboObject('combo8', 2, 50 , 0, 0, 0, true)</script></td>
					<td class="stm"><span id="Region2">Region</span></td>
					<td>&nbsp;<script language="javascript">ComComboObject('combo9', 2, 60 , 0, 0, 0, true)</script></td>
					<td class="stm">Location&nbsp;<input type="text" id="org_dest_location" name="org_dest_location" caption="Location" maxlength="5" fullfill style="width:60;" class="input" value="" dataformat="engup" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('upper')" OnKeyUp="checkLocation2(this)"></td>
					<td class="stm"></td></tr>
				</table>
				
				<!--  biz_1   (E) -->
				
				</td></tr>
			</table>
			<table class="height_10"><tr><td colspan="8"></td></tr></table>
		
		<!-- Tab BG Box  (S) -->
     	<table class="search"> 
       	<tr><td class="bg">
			
			<!-- Grid  (S) -->
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table>
			<!-- Grid  (E) -->
			
			<table class="height_5"><tr><td colspan="8"></td></tr></table>
			
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="300" valign="top">
					<!-- biz_3 (S) -->
					<table class="search" border="0"> 
						<tr class="h23">
							<td width="110">&nbsp;F/Time Exclusion</td>
							<td class="stm"><input type="checkbox" name="xcld_sat_flg" value="" class="trans" disabled><span id="wknd1">SAT</span>&nbsp;&nbsp;<input type="checkbox" name="xcld_sun_flg" value="" disabled class="trans"><span id="wknd2">SUN</span>&nbsp;&nbsp;<input type="checkbox" name="xcld_hol_flg" value="" disabled class="trans">HOLIDAY</td>
						</tr>
					</table>
					<!-- Grid  (S) -->
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet2');</script>
								</td>
							</tr>
						</table>
					<!-- Grid (E) -->	
					<!-- biz_3 (E) -->
					</td>
					<td width="19"></td>
					<td width="660" valign="top">
					<!-- biz_4 (S) -->
					<table class="search" border="0"> 
						<tr class="h23">
							<td width="130">&nbsp;F/Time Commence</td>
							<td class="stm" width="200"><input type="text" name="dmdt_chg_cmnc_tp_nm" style="width:100;" class="input2" readonly value="">&nbsp;<input type="text" name="cmnc_hr" class="input2" readonly style="width:30;" class="input" value="">&nbsp;HR</td>
							<td width="70">Currency</td>
							<td><input type="text" name="curr_cd" style="width:60;" class="input2" readonly value=""></td>
						</tr>
					</table>
					<!-- Grid  (S) -->
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet3');</script>
								</td>
							</tr>
						</table>
					<!-- Grid (E) -->	
					<!-- biz_4 (E) -->
					
					
					
					</td></tr>
			</table>
			
			
			</td></tr>
		</table>
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" id="btn_Retrieve" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" id="btn_Create" name="btn_Create">Create</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Update">Update</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Confirm">Confirm</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Expire">Expire</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_ConfirmCancel">Confirm Cancel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Delete">Delete</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Copy">Copy</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Downexcel">Down&nbsp;Excel</td>
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
<!-- 개발자 작업  끝 -->
    </td></tr>
</table>
<table width="100%"  id="mainTable2" style=display:none;>
    <tr>
        <td width="100%">
<!-- hidden 처리 (S)--> <script language="javascript">ComSheetObject('sheet4');</script> <!-- hidden 처리 (E)-->
        </td>
    </tr>
</table>
</form>
</body>
</html>