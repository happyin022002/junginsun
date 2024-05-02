<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0083.jsp
*@FileTitle : Node Search
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : KimByungKyu
*@LastVersion : 1.0
* 2009.05.20 KimByungKyu
* 1.0 Creation
2011.03.30 정선용 [CHM-201109338-01] Split 18-ALPS의 Location 조회불가건 수정 보완 요청.
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg0083Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0083Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	String countryCd = "";
	String locCd = "";
	String ydCd = "";
	String rdTerm = "";
	String locTp = "";
	String calllFunc  = "";
	String ydDisplay = "";
	String znDisplay = "";
	String sheetIdx = "";
	String row = "";
	String col = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmBkg0083Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		calllFunc  = JSPUtil.getParameter(request, "func");
		locCd      = JSPUtil.getParameter(request, "loc_cd");
		ydCd       = JSPUtil.getParameter(request, "yd_cd");
		rdTerm     = JSPUtil.getParameter(request, "rd_term");
		locTp      = JSPUtil.getParameter(request, "loc_tp");
		if(locCd != null && locCd.length() >= 2){
			countryCd = locCd.substring(0,2);
		}
		if("D".equals(rdTerm)){
			ydDisplay = "none";
			znDisplay = "block";
		}else{
			ydDisplay = "block";
			znDisplay = "none";			
		}
		
		sheetIdx = JSPUtil.getParameter(request, "sheetIdx");
		row      = JSPUtil.getParameter(request, "row");
		col      = JSPUtil.getParameter(request, "col");			
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Node Search</title>
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

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="calllFunc" value="<%=calllFunc%>">
<input type="hidden" name="locTp" value="<%=locTp%>">
<input type="hidden" name="sheetIdx" value="<%=sheetIdx%>">
<input type="hidden" name="row" value="<%=row%>">
<input type="hidden" name="col" value="<%=col%>">
<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
	<tr><td class="top">
	</td></tr>
	<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Location Search</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		<!-- Tab ) (S) -->
   		<table class="tab" border="0" cellpadding="0" cellspacing="0" style="width:960;" > 
     		<tr><td width="100%">
					<script language="javascript">ComTabObject('tab1')</script>
				</td></tr>
		</table>
		<!-- Tab ) (E) -->
<div id="tabLayer" style="display:inline">
		<!-- TABLE '#D' : ( Search Options : Scenario ID ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">
					<!-- : ( Scenario ID ) (S) -->
					<table class="search" border="0" style="width:794;"">
						<tr class="h23">
							<td width="60">Country</td>
							<td width="100"><input type="text" name="cnt_cd" style="width:25;text-align:center;" class="input1" value="<%=countryCd %>" style="ime-mode:disabled"  maxlength="2" dataformat="engup"></td>
							<td width="100">Location Code</td>
						    <td width="100">
								<input type="text" name="location_cd" style="width:50;text-align:center;" class="input1" value="<%=locCd %>" style="ime-mode:disabled"  maxlength="5" dataformat="engupnum">
						    </td>
							<td width="100">Location Name</td>
							<td width="114"><input name="loc_nm" type="text" class="input1" style="width:100;ime-mode:disabled" dataformat="etc"></td>
							<td width="45"></td>						    
							<td width="50">State</td>
							<td width="125"><input name="state" type="text" class="input" style="width:100;ime-mode:disabled" maxlength="2" dataformat="etc"></td>						    

						</tr>
					</table>
					<table class="search" border="0" style="width:794;"">
						<tr class="h23">
							<td width="60">RCC</td>
							<td width="100"><select name="rcc_cd">
								<option value="">All</option>
								<option value="CNSHA">CNSHA</option>
								<option value="SGSIN">SGSIN</option>
								<option value="USNYC">USNYC</option>
								<option value="JPTYO">JPTYO</option>
								<option value="KRSEL">KRSEL</option>
								<option value="DEHAM">DEHAM</option>
								<option value="TWTPE">TWTPE</option>
								<option value="CNHKG">CNHKG</option>
								</select>
							</td>
							<td width="100">UN Code</td>
							<td width="100"><input name="un_loc_ind_cd" type="text" style="width:20;ime-mode:disabled" dataformat="engup" maxlength="1"></td>							
							<td width="100">Control Office</td>
							<td width="100"><select name="select">
								<option value=" ">All</option>
								<option value="S">Sales</option>
								<option value="F">Finance</option>
								<option value="E">EQ-Logistics</option>
								</select>
								</td>
							<td width="234"><input name="loc_eq_ofc" type="text" style="width:90%;ime-mode:disabled" dataformat="engup" maxlength="5"></td>
						</tr>
					</table>				
					<!-- TABLE '#D' : ( Search Options : Scenario ID ) (E) -->
					<!-- TABLE '#D' : ( Tab BG Box ) (S) -->		
					<!-- : ( Grid ) (S) -->
					<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,
						 'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->

					<table width="100%" id="mainTable">
						<tr>
							<td><script language="javascript">ComSheetObject('t1sheet1');</script>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->

<!-- OUTER - POPUP (E)nd -->
</div>
<div id="tabLayer" style="display:none">		
		<!-- : ( Search Options ) (S) -->
 			<!--biz page-1 (S)-->
		<table class="search"> 
       		<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:794;"> 
				<tr class="h23">
					<td width="53">Country</td>
					<td width="60">
						<input type="text" name="country_cd" style="width:25;text-align:center;" class="input1" value="<%=countryCd %>" style="ime-mode:disabled"  maxlength=2 dataformat="engup">
						<img src="img/btns_search.gif" width="19" name="btn_008301pop" height="20" alt="" border="0" align="absmiddle" class="cursor">
					</td>
					<td width=100>
						<div id="znCombo" style="display:<%=znDisplay%>">
							<select name="postal_cd" style="width:85;" class="input1">
								<option value="P" selected>Postal Code</option>
								<option value="D">District</option>
							</select>
						</div>
					</td>
					<td width="55">Location</td>
					<td width="135">
						<input type="text" name="loc_cd" style="width:50;text-align:center;" class="input1" value="<%=locCd %>" style="ime-mode:disabled"  maxlength="5" dataformat="engupnum">
						<input type="text" name="loc_cd2" style="width:25;text-align:center;" class="input" value="<%=ydCd %>" style="ime-mode:disabled"  maxlength="2" dataformat="engupnum">
						<img src="img/btns_search.gif" width="19" height="20" name="btn_008302pop"  alt="" border="0" align="absmiddle"class="cursor">
					</td> 
					<td width="95">EQ Control OFC</td>
					<td width="70"><input type="text" name="eq_ctrl_ofc_cd" style="width:50;text-align:center;" class="input" style="ime-mode:disabled"  maxlength="5" dataformat="engup"></td>
					<td width="120">
						<table class="search_sm2" border="0" style="width:120;">
							<tr class="h23"><td><input type="radio" name="yz_flag" value="Y" class="trans" <%if(!"D".equals(rdTerm)){ %>checked<%}%> onClick="javascript:setDisplayTp('Y');">Yard&nbsp;&nbsp;
												<input type="radio" name="yz_flag" value="Z" class="trans" <%if("D".equals(rdTerm)){ %>checked<%}%> onClick="javascript:setDisplayTp('Z');">Zone</td></tr>
						</table>
					</td>
					<td align="right" width="121">
						<div id="ydCheck" style="display:<%=ydDisplay%>">
						<input type="checkbox" name="marine_terminal" value="Y" class="trans">Marine Terminal
						</div>
					</td>
				</tr>
				</table>
				<!--  biz_1   (E) -->
				<!-- : ( Grid ) (S) -->
				<div id="yardTable" style="display:<%=ydDisplay%>">
					<table width="100%"  id="mainTable">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('t2sheet1');</script>
							</td>
						</tr>
					</table>
				</div>
				<!-- : ( Grid ) (E) -->	
				
				<!-- : ( Grid2 ) (S) -->
				<div id="zoneTable" style="display:<%=znDisplay%>">
					<table width="100%"  id="mainTable">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('t2sheet2');</script>
							</td>
						</tr>
					</table>
				</div>
				<!-- : ( Grid2 ) (E) -->	
		    <!-- : ( Button : Grid ) (E) -->	
			
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
		<table class="height_5">
			<tr><td>
			</td></tr>
		</table>
</div>
	</td></tr>
</table>
	

<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
<div id="tabLayer_btn" style="display:inline">		
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_t1Retrieve" id="btn_Retrieve">Retrieve</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
								<td class="btn1" name="Code_Detail">Code Detail</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_t1OK">Select</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td class="btn1_line"></td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_t1Close">Close</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
				</tr>
		</table>
	</td></tr>
</table>		
    <!--Button (E) -->
</div>
<div id="tabLayer_btn" style="display:none">    
<!-- : ( Button : pop ) (S) -->
			<table width="100%" class="button" height="50" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
	       	<tr><td class="btn3_bg">
			    <table border="0" cellpadding="0" cellspacing="0">
			    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_t2Retrieve" id="btn_Retrieve">Retrieve</td>
						<td class="btn1_right"></td>
					</tr></table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_t2Select">Select</td>
						<td class="btn1_right"></td>
					</tr></table></td>
					<td class="btn1_line"></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_t2Close">Close</td>
						<td class="btn1_right"></td>
					</tr></table></td>
				</tr>
			</table>
	    <!--Button (E) -->
		
		</td></tr>
	</table>

<!-- : ( Button : pop ) (E) -->    
</div>
</td></tr>
</table>

<!-- : ( Button : Sub ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>