<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_PRD_0001.jsp
*@FileTitle : NetworkNodeManage
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-23
*@LastModifier : kimyoungchul
*@LastVersion : 1.0
* 2006-10-23 kimyoungchul
* 1.0 최초 생성
* N200903020010 2009-03-02 'Geographical Inquiry' 화면 변경 요청
* 2009.07.01 alps framework 구조로 변경 Noh Seung Bae
=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse" %>
<%@ page import="com.hanjin.apps.alps.esd.prd.common.prdcommon.vo.ContinentVO" %>
<%@ page import="java.util.List" %>
<%
    GeneralEventResponse eventResponse = null;  //RDTO(Data Transfer Object including DB ResultSet)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	List<ContinentVO> list = null;
	//String successFlag = "";
	//String codeList  = "";
	//String pageRows  = "100";

	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
			eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
			if (eventResponse != null) {
				list = eventResponse.getRsVoList();
			} // end if
		} // end else
	}catch(Exception e) {
		//e.printStackTrace();
		out.println(e.toString());
	}
%>
<html>
<head>
<title>NetworkNodeManage</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>
<body onload="javascript:setupPage();">
<form name="form" action="">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
	<tr>
		<td>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr>
				<td class="history"><img src="/hanjin/img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td>
			</tr>
			<tr>
				<td class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->
		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
	       	<tr><td class="btn1_bg">
			    <table border="0" cellpadding="0" cellspacing="0">
			    <tr>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_retrieve"> Retrieve</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_new">New</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
				</tr>
				</table>
			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Button : Main ) (E) -->

		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">
					<table class="search" border="0" style="width:979;">
					<tr class="h23">

						<td width="6%">Continent</td>
						<td width="11%" style="padding-left:3">
							<input type="hidden" name="conti_code" value="">
							<select name="select1" style="width:60;"  tabIndex="1" onChange="changeContinent()">
								<option value="0" >All</option>
								<%
								for(int i=0; i< list.size(); i++){
									ContinentVO vo = (ContinentVO)list.get(i);
									out.println("<option value='"+ vo.getContiCode() +"' >" + vo.getContiCode() + "</option>");
								}
								%>
							</select>
							</td>
						<td width="12%">Sub-Continent</td>
						<td width="12%">
							<input type="hidden" name="subconti_code" value="">
							<select name="select2" style="width:70"  tabIndex="2" onChange="changeSubContinent()">
								<option value="0" selected>All</option>
							</select>
						</td>
						<td width="7%">Country</td>
						<td width="15%">
							<input name="country_code" type="text"  maxlength="2" style="width:60" value="" tabIndex="3" dataformat="engup" >
							<img class="cursor" src="/hanjin/img/alps/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_country" ></td>
						<td width="6%">Region</td>
						<td width="11%">
							<input name="region_code" type="text"  maxlength="3" style="width:60" value="" tabIndex="4" dataformat="engup"></td>
						<td width="7%">Location</td>
						<td width="13%" align="right">
							<input name="location_code" type="text"  maxlength="5" style="width:70" value="" tabIndex="5" dataformat="engup">
							<img class="cursor" src="/hanjin/img/alps/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_location" > </td>
					</tr>
					</table>
				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Grid BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg_b1">
					

					<!-- Grid : Week (S) -->
					<!-- 'HEAD1-BGCOLOR : 192 235 163' , 'HEAD2-BGCOLOR : 231 250 249' , 'BORDER : 90 138 158' , 'HEAD1-FONT : 0 83 116' , 'DATA GRID BG (2 colors) : 255 255 255, 249 249 249 ' -->

					<table width="100%" id="mainTable">
				              <tr><td>
				                     <script type="text/javascript">ComSheetObject('sheet1');</script>
				              </td></tr>
					</table>
					<!-- Grid : Week (E) --></td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Grid BG Box ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>

		

		
		<!-- TABLE '#D' : ( Grid BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg_b1">

					<table class="height_10"><tr><td></td></tr></table>

					<table class="search" border="0" style="width:979;">
						<tr class="h23">
							<td width="14%" rowspan="4">Geo. Hierarchy </td>
							<td width="12%" class="stm">Continent</td>
							<td width="31%">
								<input name="g_cnti_cd" class="noinput1" readonly type="text" style="width:40;text-align:center;" value="">
								<input name="g_cnti_nm" class="noinput1" readonly  type="text" style="width:150;text-align:center;" value="">
							</td>
							<td width="13%" class="stm">State / Province</td>
							<td width="30%">
								<input name="g_ste_cd"  class="noinput1" readonly type="text" style="width:60;text-align:center;" value="">
								<input name="g_ste_nm"  class="noinput1" readonly type="text" style="width:150;text-align:center;" value="">
							</td>
						</tr>
						<tr>
							<td class="stm">Sub-continent</td>
							<td>
								<input name="g_subcnti_cd"  class="noinput1" readonly type="text" style="width:40;text-align:center;" value="">
								<input name="g_subcnti_nm"  class="noinput1" readonly type="text" style="width:150;text-align:center;" value="">
							</td>
							<td class="stm">Location</td>
							<td>
								<input name="g_loc_cd"  class="noinput1" readonly type="text" style="width:60;text-align:center;" value="">
								<input name="g_loc_nm"  class="noinput1" readonly type="text" style="width:150;text-align:center;" value="">
							</td>
						</tr>
						<tr>
							<td class="stm">Country</td>
							<td>
								<input name="g_cntr_cd"  class="noinput1" readonly type="text" style="width:40;text-align:center;" value="">
								<input name="g_cntr_nm"  class="noinput1" readonly type="text" style="width:150;text-align:center;" value="">
							</td>
							<td class="stm">UN Code</td>
							<td>
								<input name="g_un_flag"  class="noinput1" readonly type="text" style="width:60;text-align:center;" value="">
								<input name="g_un_cd"  class="noinput1" readonly type="text" style="width:150;text-align:center;" value="">
							</td>
						</tr>
						<tr>
							<td class="stm">Region</td>
							<td>
								<input name="g_rgn_cd"  class="noinput1" readonly type="text" style="width:40;text-align:center;" value="">
								<input name="g_rgn_nm"  class="noinput1" readonly type="text" style="width:150;text-align:center;" value="">
							</td>
							<td class="stm">Location Grid</td>
							<td>
								<input name="loc_grid"  class="noinput1" readonly type="text" style="width:213;text-align:center;" value="">
							</td>
						</tr>
					</table>

					<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>

					<table class="search" border="0" style="width:979;">
						<tr class="h23">
							<td width="45" rowspan="5">Office<br>Info.</td>
							<td width="75" class="stm">Sales OFC</td>
							<td width="89">
								<input name="sls_ofc"  class="noinput1" readonly type="text" style="width:60;text-align:center;" value="">
							</td>
							<td width="35" rowspan="4">EQ<br>Loc.<br>Info.</td>
							<td width="35" class="stm">RCC</td>
							<td width="85">
								<input name="rcc_cd"  class="noinput1" readonly type="text" style="width:60;text-align:center;" value="">
							</td>
							<td width="50" rowspan="5">Others</td>
							<td width="60" class="stm">B/L Prefix</td>
							<td width="76">
								<input name="bl_frefix"  class="noinput1" readonly type="text" style="width:60;text-align:center;" value="">
							</td>
							<td width="115" class="stm">Commercial Zone</td>
							<td width="72">
								<input name="cms_zone"  class="noinput1" readonly type="text" style="width:60;text-align:center;" value="">
							</td>
						</tr>
						<tr class="h23">
							<td class="stm">EQ OFC</td>
							<td>
								<input name="eq_ofc"  class="noinput1" readonly type="text" style="width:60;text-align:center;" value="">
							</td>
							<td class="stm">LCC</td>
							<td>
								<input name="lcc_cd"  class="noinput1" readonly type="text" style="width:60;text-align:center;" value="">
							</td>
							<td class="stm">Customs</td>
							<td>
								<input name="custms"  class="noinput1" readonly type="text" style="width:60;text-align:center;" value="">
							</td>
							<td class="stm">Rep. Zone</td>
							<td>
								<input name="rep_zn_cd"  class="noinput1" readonly type="text" style="width:60;text-align:center;" value="">
							</td>
						</tr>
						<tr class="h23">
							<td class="stm">Finance OFC</td>
							<td>
								<input name="fin_ofc"  class="noinput1" readonly type="text" style="width:60;text-align:center;" value="">
							</td>
							<td class="stm">ECC</td>
							<td>
								<input name="ecc_cd"  class="noinput1" readonly type="text" style="width:60;text-align:center;" value="">
							</td>
							<td class="stm">Loc. Char.</td>
							<td>
								<input name="loc_char"  class="noinput1" readonly type="text" style="width:60;text-align:center;" value="">
							</td>
							<td class="stm">Rep.MTY PKUP YD</td>
							<td>
								<input name="mty_pkup_yd_cd"  class="noinput1" readonly type="text" style="width:60;text-align:center;" value="">
							</td>
						</tr>
						<tr class="h23">
							<td class="stm">Sen EQ OFC</td>
							<td>
								<input name="sen_ofc"  class="noinput1" readonly type="text" style="width:60;text-align:center;" value="">
							</td>
							<td class="stm">SCC</td>
							<td>
								<input name="scc_cd"  class="noinput1" readonly type="text" style="width:60;text-align:center;" value="">
							</td>
							<td class="stm">GMT</td>
							<td>
								<input name="gmt"  class="noinput1" readonly type="text" style="width:60;text-align:center;" value="">
							</td>
							<td class="stm">Rep.EQ RTN YD</td>
							<td>
								<input name="refre_cy"  class="noinput1" readonly type="text" style="width:60;text-align:center;" value="">
							</td>

						</tr>
						<tr class="h23">
							<td class="stm"></td>
							<td>
							</td>
							<td class="stm"></td>
							<td>
								</td>
							<td class="stm"></td>
							<td>
							</td>
							<td>
							</td>
							<td class="stm">US AMS Code</td>
							<td>
								<input name="ams_cd"  class="noinput1" readonly type="text" style="width:60;text-align:center;" value="">
							</td>

						</tr>						
					</table>

					<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>

					<table class="search" border="0" style="width:979;">
						<tr class="h23">
							<td width="12%">Port Info.</td>
							<td width="16%" class="stm" style="padding-left:4">Port &nbsp;<input name="port_cd"  class="noinput1" readonly type="text" style="width:60;text-align:center;" value=""></td>
							<td class="stm" style="padding-left:3">Calling Port &nbsp;<input name="coll_port"  class="noinput1" readonly type="text" style="width:60;text-align:center;" value=""></td>
						</tr>
					</table>

				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Grid BG Box ) (E) -->



		
		<!-- ####### TABLE '#D' ::: 'RIGHT' FRAME (END) ####### -->

	</td>
</tr>
</table>
</form>
<!-- TABLE '#B' : 'Left + Right Body' Table (E)nd -->
<iframe name="HiddenFrame" id="HiddenFrame" frameborder="0" marginheight="0" marginwidth="0" width="0" height="0"></iframe>
</body>
</html>
