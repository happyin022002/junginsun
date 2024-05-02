<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_1089.jsp
*@FileTitle : General Inventory
*@FileName : EES_CGM_1122.jsp
*@FileTitle : General Inventory Graphic
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.06
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.07.09 김창식
* 2009.08.06 조재성
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.event.EesCgm1089Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%>

<%
	EesCgm1089Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id   = "";
	String strUsr_nm   = "";
	String strOfc_id   = "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.ChassisMgsetMgt.ChassisMgsetInventory");
	
	String xml = HttpUtil.makeXML(request,response);
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_id = account.getOfc_cd();
		
		event = (EesCgm1089Event)request.getAttribute("Event");
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
<title>General Inventory</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
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
<input type="hidden" name="pagerows">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="iPage">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="eq_knd_cd">
<input type="hidden" name="intg_cd_id">
<input type="hidden" name="yd_cd">
<input type="hidden" name="loc_cd">
<input type="hidden" name="eq_orz_cht_chktype">
<input type="hidden" name="eq_orz_cht_rcc_cd">
<input type="hidden" name="eq_orz_cht_lcc_cd">
<input type="hidden" name="eq_orz_cht_scc_cd">
<input type="hidden" name="s_usr_id" value="<%=strUsr_id %>" >
<input type="hidden" name="s_ofc_id" value="<%=strOfc_id %>" >

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
					<td width="190"><script language="javascript">ComComboObject('location', 1, 50, 0, 1, 1, true);</script>&nbsp;<input type="text" name="crnt_loc_cd" dataformat="engup" style="width:68;ime-mode:disabled" class="input1" value="" maxlength="5">&nbsp;<img name="btns_crnt_loc_cd" class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="35">Yard </td>
					<td width="216"><input type="text" name="crnt_yd_cd" dataformat="engup" style="width:161;ime-mode:disabled" class="input" value="">&nbsp;<img name="btns_crnt_yd_cd" class="cursor" src="img/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="244">Include 'NP'<input type="checkbox" name="include_np" value="" class="trans"></td>
					
					<td>
						<table class="search_sm2" border="0"  style="width:95%;">
							<tr class="h23">
								<td><input type="radio" name="doc_type" value="" class="trans" checked>Summary&nbsp;&nbsp;&nbsp;<input type="radio" name="doc_type" value="" class="trans">Graphic</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="80">Active St.</td>
					<td width="190"><script language="javascript">ComComboObject('aciac_div_cd', 1, 144, 0, 0, 1, true);</script></td>
					<td width="76">Co-Op Pool</td>
					<td width="420"><script language="javascript">ComComboObject('chss_pool_cd', 1, 276, 0, 0, 1, true);</script></td>
					<td width="150">Staying Days&nbsp;<input type="text" name="staying_days" dataformat="int" style="width:65;text-align:right;ime-mode:disabled" class="input" value=""></td>
					<td class="stm">&nbsp;or Over</td>
				</tr>
			</table>
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="80">1. Group By</td>
					<td width="190"><script language="javascript">ComComboObject('group1', 1, 144, 0, 0, 1, true);</script></td>
					<td width="255">2. Group By&nbsp;<script language="javascript">ComComboObject('group2', 1, 144, 0, 0, 1, true);</script></td>
					<td>3. Group By&nbsp;<script language="javascript">ComComboObject('group3', 1, 144, 0, 0, 1, true);</script></td>
				</tr>
				</table>
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="80">Type/Size</td>
					<td width="190"><script language="javascript">ComComboObject('eq_tpsz_cd', 1, 144, 0, 0, 1, true);</script>&nbsp;<!--img class="cursor" src="img/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle"--></td>
					<td width="76">Lease Term</td>
					<td width="180"><script language="javascript">ComComboObject('agmt_lstm_cd', 1, 144, 0, 0, 1, true);</script>&nbsp;<!--img class="cursor" src="img/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle"--></td>
					<td width="73">Lessor</td>
					<td width="168"><input type="text" name="vndr_seq" dataformat="eng" style="width:121;ime-mode:disabled" class="input" value="">&nbsp;<img name="btns_vndr" class="cursor" src="img/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="87">MVMT Status</td>
					<td><script language="javascript">ComComboObject('chss_mvmt_sts_cd', 1, 115, 0, 0, 1, true);</script>&nbsp;<!--img class="cursor" src="img/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle"--></td>
				</tr>
				</table>
				<!--  biz_1  (E) -->
		</td></tr>
		</table>

		<div id="chartLayer" style="display:none;"><!-- TABLE '#D' : ( Search Options : Speed ) (S) -->
		<table class="height_8"><tr><td></td></tr></table>
			<!-- TABLE '#D' : ( Search Options ) (E) -->
					<!-- TABLE '#D' : ( Search Options ) (S) -->
					<table class="search" id="mainTabe">
						<tr><td class="bg">

											<table width="100%" id="mainTable">
												<tr>
													<td width="100%" height="330">
													<script language="javascript">comTChartObject();comRdObject('EES_CGM_1122');</script>
													</td>
												</tr>
											</table>

						</td></tr>
					</table>
					<!-- TABLE '#D' : ( Search Options ) (E) -->
		</div>

		<div id="sheetLayer">			
			<table class="height_8"><tr><td></td></tr></table>
			<table class="search" id="mainTabe"> 
	       	<tr><td class="bg">
					
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
		</div>				
				
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
				<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_print">Print</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->			
			
	
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>