<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_AOC_3010.jsp
*@FileTitle : Inland Cost Inquiry(EUR)
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :
*@LastVersion : 1.0
*=========================================================
* History
2014.03.07 서미진 [CHM-201429273] Confirmed cost만 보도록 수정 (Date 조건 삭제, Incl. Unconfirmed Cost 조건 삭제)
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.aoc.eurcostmgt.eurinlandcostmanage.event.EsdAoc3010Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.Date"%>
<%
	EsdAoc3010Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsdAoc3010Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String transModeCd  = JSPUtil.getCodeCombo("f_trsp_crr_mod_cd" , "01", "style='width:120'", "CD00283", 0, "000010:ALL:ALL");
	String costFactorCd  = JSPUtil.getCodeCombo("f_sys_src_cd" , "01", "style='width:120'", "CD03050", 0, "000010:ALL:ALL");
%>
<html>
<head>
<title>Inland Cost Management</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">

	<%= JSPUtil.getIBCodeCombo("f_trsp_crr_mod_cd" , "", "CD00283", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("f_sys_src_cd" , "", "CD03050", 0, "")%>

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
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="cost_sel_rout_flg" value="N">
<input type="hidden" name="bnt_flg" value="N">

<input type="hidden" name="excel_date_flg">
<input type="hidden" name="excel_trsp_crr_mod_cd">
<input type="hidden" name="excel_io_bnd_cd">
<input type="hidden" name="excel_rcv_de_term_cd">
<input type="hidden" name="excel_cost_factor_cd">
<input type="hidden" name="excel_sys_src_cd">
<input type="hidden" name="excel_adjustment_cd">
<input type="hidden" name="excel_eff_to_dt">
<input type="hidden" name="excel_loc_nod_cd">
<input type="hidden" name="excel_hub_nod_cd">
<input type="hidden" name="excel_port_nod_cd">
<input type="hidden" name="excel_cost_trf_no">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;padding-right:5;">
	<tr><td valign="top">
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->
	
		<!--Button (S) -->
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
        <tr><td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_retrieve">Retrieve</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_disp_excel">Down Excel without Displaying</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
            </tr>
            </table>
        </td></tr>
        </table>
		<!--Button (E) -->
    	
		<!--biz page (S)-->
		<table class="search"> 
       		<tr><td class="bg">
				<!-- biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="96">Effective as of</td>
					<td width="165"><input type="text" name="eff_to_dt" style="width:100;text-align:center;" class="input1" dataformat="ymd" maxlength="8" value="<%=DateTime.getFormatDate(new Date(),"yyyy-MM-dd")%>">&nbsp;<img src="img/btns_calendar.gif" name="bnt_eff_to_dt" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
					<td width="94">Cost Tariff No</td>
					<td width="165">
						<input name="cost_trf_no" type="text" dataformat="uppernumcomma" style="width:100;">
						<img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" onClick="so_OnPopupClick('cost_trf_no');">
					</td>
					<td width="103">Bound</td>
					<td><script language="javascript">ComComboObject('io_bnd_cd', 1, 122, 1, 0);</script></td>						
				</tr>
				</table>

				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="101">Port</td>
					<td width="170">
						<input name="port_nod_cd" type="text" dataformat="engupcomma" style="width:100;">
						<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_port">
						<img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" onClick="so_OnPopupClick('port');">
					</td>
					<td width="99">Hub</td>
					<td width="171">
						<input name="hub_nod_cd" type="text" dataformat="engupcomma" style="width:100;">
						<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_hub">
						<img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" onClick="so_OnPopupClick('hub');">
					</td>
					<td width="105">Location</td>
					<td width="169">
						<input name="loc_nod_cd" type="text" dataformat="engupcomma" style="width:100;">
						<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_loc">
						<img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" onClick="so_OnPopupClick('loc');">
					</td>
					<td width="94">Trans Mode</td>
					<td width="100"><script language="javascript">ComComboObject('trsp_crr_mod_cd', 1, 104, 1, 0);</script></td>
				</tr>
				</table>

				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="98">R/D Term</td>
					<td width="164"><script language="javascript">ComComboObject('rcv_de_term_cd', 1, 122, 1, 0);</script></td>
					<td width="96">Cost Factor</td>
					<td width="164"><script language="javascript">ComComboObject('cost_factor_cd', 1, 122, 1, 0);</script></td>
					<td width="101">System Source</td>
					<td width="163"><script language="javascript">ComComboObject('sys_src_cd', 1, 122, 1, 0);</script></td>
					<td width="89">Adjustment</td>
					<td><script language="javascript">ComComboObject('adjustment_cd', 1, 104, 1, 0);</script></td>
				</tr>
				</table>
			</td></tr>
		</table>
		<!-- biz_1  (E) -->				
		<table class="height_8"><tr><td></td></tr></table>

		<!-- Tab (S) -->
		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%>
			<tr><td width="100%">
				<script language="javascript">ComTabObject('tab1')</script>
			</td></tr>
		</table>
		<!-- Tab (E) -->

		<!-- TAB [ Dry ] (S) -->
		<div id="tabLayer" style="display:inline">
			<table class="search"> 
			<tr><td class="bg" style="height:338" valign="top">
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) -->
				
				<!--  Button_Sub (S) -->
				<table width="100%" class="button"> 
		       	<tr><td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn_cost_detail">Cost Detail</td>
								<td class="btn2_right"></td>
								</tr>
							</table>
						</td>
						<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn_down_excel">Down Excel</td>
								<td class="btn2_right"></td>
								</tr>
							</table>
						</td>
					</tr>
					</table>
				</td></tr>
				</table>
		    	<!-- Button_Sub (E) -->
				
			</td></tr>
			</table>
		</div>
		<!-- TAB [ Dry ] (E) -->
		
			
		<!-- TAB [ DG, Overweight ] (S) -->
		<div id="tabLayer" style="display:none">
			<table class="search"> 
			<tr><td class="bg" style="height:338" valign="top">
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) -->

				<!--  Button_Sub (S) -->
				<table width="100%" class="button"> 
		       	<tr><td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn2_down_excel">Down Excel</td>
								<td class="btn2_right"></td>
								</tr>
							</table>
						</td>
					</tr>
					</table>
				</td></tr>
				</table>
		    	<!-- Button_Sub (E) -->
				
			</td></tr>
			</table>
		</div>
		<!-- TAB [ DG, Overweight  ] (E) -->
		
		<!-- TAB [ Reefer ] (S) -->
		<div id="tabLayer" style="display:none">
			<table class="search"> 
			<tr><td class="bg" style="height:338" valign="top">
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet3');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) -->

				<!--  Button_Sub (S) -->
				<table width="100%" class="button"> 
		       	<tr><td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn3_down_excel">Down Excel</td>
								<td class="btn2_right"></td>
								</tr>
							</table>
						</td>
					</tr>
					</table>
				</td></tr>
				</table>
		    	<!-- Button_Sub (E) -->
				
			</td></tr>
			</table>
		</div>
		<!-- TAB [ Reefer  ] (E) -->

	</td></tr>
</table>

<div id="tabLayer" style="display:none">
	<table class="search" id="mainTable"> 
      	<tr><td class="bg">	
			<table width="100%"  id="mainTable">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet4');</script>
					</td>
				</tr>
			</table>
		</td></tr>
	</table>
</div>

<!-- 개발자 작업  끝 -->
</form>
<iframe name="CommandFrame" style="display:none"></iframe>
</body>
</html>