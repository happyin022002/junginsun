<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0933.jsp
*@FileTitle : ESM_BKG_0933
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.07.10 김승민
* 1.0 Creation
* -------------------------------------------------------
* History
* 2012.04.16 김경섭 [BKG][CHM-201217131-01] Load Summary by POD 기능 보완 요청 
						- 부모창에 따라 DAO의 집계쿼리 변경: in parameter 추가
* 2015.04.20 신영재 소스보안 결함 수정
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkg0933Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>

<%
	EsmBkg0933Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	String inVvdCd = "";
	String inPolCd = "";
	String inPolYdCd = "";
	
	String popup_title = "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.TerminalDocumentation.CLLCDLManifest");

	String pgmNo = StringUtil.xssFilter(request.getParameter("pgmNo"));
	try {
		
		if ("ESM_BKG_0951".equals(pgmNo)){
			popup_title = "Load Summary by POD_ Special Stowage";
		} else {
			popup_title = "Container Loading List(KOREA)_Print Preview_Special CGO";
		}
		
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		
		inVvdCd = StringUtil.xssFilter(request.getParameter("inVvdCd"))==null?"":StringUtil.xssFilter(request.getParameter("inVvdCd"));
		inPolCd = StringUtil.xssFilter(request.getParameter("inPolCcd"))==null?"":StringUtil.xssFilter(request.getParameter("inPolCcd"));		
		inPolYdCd = StringUtil.xssFilter(request.getParameter("inPolYdCd"))==null?"":StringUtil.xssFilter(request.getParameter("inPolYdCd"));


		event = (EsmBkg0933Event)request.getAttribute("Event");
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
<title>ESM_BKG_0933</title>
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

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="in_vvd_cd" value="<%=inVvdCd%>">
<input type="hidden" name="in_pol_cd" value="<%=inPolCd%>">
<input type="hidden" name="in_pol_yd_cd" value="<%=inPolYdCd%>">
<input type="hidden" name="in_by_type" value="">
<input type="hidden" name="in_pgm_no" value="<%=pgmNo%>">
<!-- 개발자 작업	-->
<table width="100%" class="popup" cellpadding="10" border="0"> 
	<tr><td class="top"></td></tr>
	<tr>
		<td valign="top">
			<table width="100%" border="0">
			<tr><td height="79" class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;<%=popup_title%></td></tr>
			</table>		
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			

				<!--  biz_1 (S) -->
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">SPECIAL CARGO DETAIL</td>
					</tr></table>
					
					<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="35">VVD :</td>
						<td width="450"><input type="text" style="width:300;" class="input2" name="vvd_cd" readonly></td>
						<td width="40">POL :</td>
						<td width="260"><input type="text" style="width:80;" class="input2" name="un_loc_cd" readonly></td>
						<td width="40">ETD :</td>
						<td width=""><input type="text" style="width:100%;" class="input2" name="vps_etd_dt" readonly></td>
					</tr>
					
				</table>
				<!--  biz_1 (E) -->	
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table> 			
			<!-- Grid (E) -->
			<table width="100%" class="grid2" id="mainTable"> 
			<tr>
				<td class="tr2_head2" width="35">D2	</td>
				<td width="30"><input type="text" name="d2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">D4	</td>
				<td width="30"><input type="text" name="d4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">D5</td>
				<td width="30"><input type="text" name="d5" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">D7	</td>
				<td width="30"><input type="text" name="d7" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">D8</td>
				<td width="30"><input type="text" name="d8" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">D9	</td>
				<td width="30"><input type="text" name="d9" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">DW	</td>
				<td width="30"><input type="text" name="dw" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">DX	</td>
				<td width="30"><input type="text" name="dx" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">R2	</td>
				<td width="30"><input type="text" name="r2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">R4</td>
				<td width="30"><input type="text" name="r4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">R5	</td>
				<td width="30"><input type="text" name="r5" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">F2	</td>
				<td width="30"><input type="text" name="f2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">F4	</td>
				<td width="30"><input type="text" name="f4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">F5	</td>
				<td width="30"><input type="text" name="f5" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
			</tr>
			<tr>
				<td class="tr2_head2">O2	</td>
				<td><input type="text" name="o2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">O4		</td>
				<td><input type="text" name="o4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">O5		</td>
				<td><input type="text" name="o5" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">O7		</td>
				<td><input type="text" name="o7" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">S2	</td>
				<td><input type="text" name="s2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">S4		</td>
				<td><input type="text" name="s4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">T2</td>
				<td><input type="text" name="t2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">T4		</td>
				<td><input type="text" name="t4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">A2	</td>
				<td><input type="text" name="a2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">A4		</td>
				<td><input type="text" name="a4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">A5		</td>
				<td><input type="text" name="a5" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">P2	</td>
				<td><input type="text" name="p2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">P4	</td>
				<td><input type="text" name="p4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">Z2	</td>
				<td><input type="text" name="z2" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
		
				</tr>
			<tr>
				<td class="tr2_head2">Z4	</td>
				<td><input type="text" name="z4" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">D3	</td>
				<td><input type="text" name="d3" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2">R9	</td>
				<td><input type="text" name="r9" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2"  style="font-size:8">ETC		</td>
				<td><input type="text" name="etc" value="" size="2" style="text-align:center;font-weight:bold" readonly></td>
				<td width=""class="tr2_head2"></td>
				<td width=""align="center" class="sm"></td>
				<td width=""class="tr2_head2"></td>
				<td width=""align="center" class="sm"></td>
				<td width=""class="tr2_head2"></td>
				<td width=""align="center" class="sm"></td>
				<td width=""class="tr2_head2"></td>
				<td width=""align="center" class="sm"></td>
				<td width=""class="tr2_head2"></td>
				<td width=""align="center" class="sm"></td>
				<td width=""class="tr2_head2"></td>
				<td width=""align="center" class="sm"></td>
				<td width=""class="tr2_head2"></td>
				<td width=""align="center" class="sm"></td>
				<td width=""class="tr2_head2"></td>
				<td width=""align="center" class="sm"></td>
				<td class="tr2_head2" colspan="2"><b>Total</b>	</td>
				<td colspan="2"><input type="text" name="totalTpSize" value="" size="9" style="text-align:center;font-weight:bold" readonly></td>
			</tr>
			</table>
		<table width="" class="grid2" id="mainTable"> 
		 	<tr>
				<td class="tr2_head" width="37">Local		</td>
				<td width="32"><input type="text" name="local" value="" size="3" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">Full	</td>
				<td width="30"><input type="text" name="localFull" value="" size="3" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">Empty		</td>
				<td width="30"><input type="text" name="localEmpty" value="" size="3" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head" width="35">T/S		</td>
				<td width="30"><input type="text" name="ts" value="" size="3" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">Full			</td>
				<td width="30"><input type="text" name="tsFull" value="" size="3" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head2" width="35">Empty		</td>
				<td width="30"><input type="text" name="tsEmpty" value="" size="3" style="text-align:center;font-weight:bold" readonly></td>
				<td class="tr2_head" width="35">WGT					</td>
				<td width="60"><input type="text" name="wgt" value="" size="15" style="text-align:center;font-weight:bold" readonly></td>
			</tr>
		</table>
		 
				<!-- Grid  (S) -->
				<table class="height_8"><tr><td></td></tr></table>
				&nbsp;
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table> 	
				<table class="height_8"><tr><td></td></tr></table>
				<table width="500"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet3');</script>
						</td>
					</tr>
				</table> 	
			<!-- Grid (E) -->
		</td></tr>
		</table>
			
		
		<!--  Button(S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"> 
       			<tr><td class="btn1_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="">Special CGO</td>
					<td class="btn1_right"></td>
					</tr>
					</table></td>
					
					<td style="font-size:8pt; font-family: Tahoma,Arial; " width="260" align="center"><input type="radio" value="" name="in_by_type_temp" class="trans" onClick="goBySearch()" checked>&nbsp;ALL&nbsp;&nbsp;&nbsp;<input type="radio" value="" name="in_by_type_temp" class="trans" onClick="goBySearch()">&nbsp;LOCAL&nbsp;&nbsp;&nbsp;<input type="radio" name="in_by_type_temp" value="" class="trans" onClick="goBySearch()">&nbsp;T/S&nbsp;&nbsp;&nbsp;&nbsp;
					<select style="width:87;" name="in_sort_type" onChange="goSearch();">
						<option value="1" selected>Sort</option>
						<option value="1">POD</option>
						<option value="2">CGO_TYPE</option>
						<option value="3">CNTR</option>
						<option value="4">MLB</option>
						</select></td>
					<td class="btn1_line"></td>	
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Print">Print</td>
					<td class="btn1_right"></td>
					</tr>
					</table></td>
					
				</tr>
				</table>					
		</td></tr>
		</table>
	
	    	<!-- Button_Sub (E) -->
				
				<table width="100%"  id="mainTable" style="display:none"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet4');</script>
						</td>
					</tr>
				</table> 	
	</td></tr>
	</table>
			
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
			
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       		<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    	<tr>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td>
										<td class="btn1" name="btn_Close" onClick="self.close()">Close</td>
										<td class="btn1_right"></td>
									</tr>
								</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</form>
</body>
</html>