<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_1092.jsp
*@FileTitle : 체류 기간별 Chassis 수량집계 inventory
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.07.17 조재성
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
<%@ page import="com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.event.EesCgm1092Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%>

<%
	EesCgm1092Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.ChassisMgsetMgt.ChassisMgsetInventory");

	String xml = HttpUtil.makeXML(request,response);
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EesCgm1092Event)request.getAttribute("Event");
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
<title>Chassis Inventory by Staying Days</title>
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

<body  onLoad="setupPage();">
<form name="form2">
<input type="hidden" name="sXml" value="<%=xml.replace("\"","'")%>">
</form>
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="eq_knd_cd">
<input type="hidden" name="intg_cd_id">
<input type="hidden" name="yd_cd">
<input type="hidden" name="n1st_inq_fm_dys">
<input type="hidden" name="n1st_inq_to_dys">
<input type="hidden" name="n2nd_inq_fm_dys">
<input type="hidden" name="n2nd_inq_to_dys">
<input type="hidden" name="n3rd_inq_fm_dys">
<input type="hidden" name="n3rd_inq_to_dys">
<input type="hidden" name="n4th_inq_fm_dys">
<input type="hidden" name="n4th_inq_to_dys">
<input type="hidden" name="n5th_inq_fm_dys">
<input type="hidden" name="n5th_inq_to_dys">
<input type="hidden" name="loc_cd">
<input type="hidden" name="eq_orz_cht_chktype">
<input type="hidden" name="eq_orz_cht_rcc_cd">
<input type="hidden" name="eq_orz_cht_lcc_cd">
<input type="hidden" name="eq_orz_cht_scc_cd">
<input type="hidden" name="pgmNo">
<!-- radio에서 combo로 대체됨. 
<input type="hidden" name="atch_bare">
<input type="hidden" name="dmg_snd">
-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	
	<tr><td valign="top">
	
	

	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
            <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
            <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->
	
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="80">Location </td>
					<td width="52"><script language="javascript">ComComboObject('location', 1, 50, 0, 1, 1, true);</script></td>
					<td width="118"><input type="text" name="crnt_loc_cd" dataformat="engup" maxlength="5" style="width:68;ime-mode:disabled" class="input1" value="">&nbsp;<img name="btns_crnt_loc_cd" class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>					
					<td width="35">Yard </td>
					<td width="250"><input type="text" name="crnt_yd_cd" dataformat="engup" style="width:184;ime-mode:disabled" class="input" value="">&nbsp;<img name="btns_crnt_yd_cd" class="cursor" src="img/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle"></td>
                    <td width="44">CP</td>
                    <td width="195"><script language="javascript">ComComboObject('chss_pool_cd', 1, 161, 0, 0, 1, true);</script></td>
                    <td width="88">L/S Days</td>
                    <td class="stm"><input type="text" name="staying_days" dataformat="int" style="width:68;text-align:right;ime-mode:disabled" class="input" value="">&nbsp;or Over</td>                    
                    					
				</tr>
			</table>
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="80">Active St.</td>
					<td width="170"><script language="javascript">ComComboObject('aciac_div_cd', 1, 100, 0, 0, 1, true);</script></td>
					<td width="70">Group By</td>
					<td width=""><script language="javascript">ComComboObject('group1', 1, 150, 0, 0, 1, true);</script></td>
					  </tr>
			</table>
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="80">Type/Size</td>
					<td width="170"><script language="javascript">ComComboObject('eq_tpsz_cd', 1, 100, 0, 0, 1, true);</script>&nbsp;<!--img class="cursor" src="img/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle"--></td>
					<td width="100">Lease Term</td>
					<td width="185"><script language="javascript">ComComboObject('agmt_lstm_cd', 1, 120, 0, 0, 1, true);</script>&nbsp;<!--img class="cursor" src="img/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle"--></td>
					<td width="44">Lessor</td>
					<td width="195"><input type="text" name="vndr_seq" dataformat="eng" style="width:134;ime-mode:disabled" class="input" value="">&nbsp;<img name="btns_vndr" class="cursor" src="img/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="90">MVMT Status</td>
					<td><script language="javascript">ComComboObject('chss_mvmt_sts_cd', 1, 70, 0, 0, 1, true);</script>&nbsp;<!--img class="cursor" src="img/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle"--></td>
				</tr>
				</table>
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="80">Attach/Bare</td>
                    <td width="170"><script language="javascript">ComComboObject('atch_bare', 1, 100, 1, 0, 1, true);</script></td>
					 <td width="100">Damage/Sound</td>
                    <td width="185"><script language="javascript">ComComboObject('dmg_snd', 1, 120, 1, 0, 1, true);</script></td>
                     <td width="161">Status 'LST'&nbsp;&nbsp;<input type="checkbox" name="include_status_lst" value="" class="trans"></td>
                     <td width="151">Out-gated&nbsp;&nbsp;<input type="checkbox" name="include_out_gated" value="" class="trans"></td>
                  	<td>Include 'NP'<input type="checkbox" name="include_np" value="" class="trans"></td>
				
                    <!--
					<td width="185"><input type="radio" name="rdo_atch_bare" value="ATTACHED" class="trans" >Attached&nbsp;&nbsp;&nbsp;<input type="radio" name="rdo_atch_bare" value="BARE" class="trans" checked>Bare</td>
					<td width="49"></td>
					
					<td width="200"><input type="radio" name="rdo_dmg_snd" value="DAMAGE" class="trans" >Damage&nbsp;&nbsp;&nbsp;<input type="radio" name="rdo_dmg_snd" value="SOUND" class="trans" checked>Sound</td>
					<td width="90"></td>
					-->
				</tr>
				</table>
			
				<!--  biz_1  (E) -->
		</td></tr>
		</table>
			
		<table class="height_8"><tr><td></td></tr></table>
		<table class="search" id="mainTable"> 
       	<tr><td class="bg">
			<!--  biz_2  (S)  -->
				<!-- Grid  (S) -->
					<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
			<!-- Grid (E) -->
			<!--  biz_2  (E)  -->
			</td></tr>
		</table>

		</td></tr>
		</table>	
			
			
	<!--biz page (E)-->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel">Down&nbsp;Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_env_setting">ENV.&nbsp;Setting</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
<div id="tabLayer" style="display:none"> 
	<!-- Grid  (S) -->
		<table width="100%"  id="mainTable"> 
			<tr>
				<td width="100%">
					<script language="javascript">ComSheetObject('sheet2');</script>
				</td>
			</tr>
		</table>
	<!-- Grid  (E) -->
</div>	

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>