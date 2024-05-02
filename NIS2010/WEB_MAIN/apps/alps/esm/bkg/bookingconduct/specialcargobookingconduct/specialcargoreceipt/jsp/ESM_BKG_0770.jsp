<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0770.jsp
*@FileTitle : Special Cargo Remark
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier : 이병규
*@LastVersion : 1.0
* 2009.06.19 이병규
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.event.EsmBkg0770Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0770Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.SpecialCargoBookingConduct.SpecialCargoReceipt");
	
	String imdg_pck_tp_cd = "";
	String pck_tp_seq = "";
	String imdg_emer_no = "";
	String ctrl_temp_ctnt = "";
	String emer_rspn_gid_no = "";
	String emer_rspn_gid_chr_no = "";
	String emer_temp_ctnt = "";	

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0770Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		imdg_pck_tp_cd =  JSPUtil.getParameter(request, "imdg_pck_tp_cd");
		pck_tp_seq =  JSPUtil.getParameter(request, "pck_tp_seq");
		imdg_emer_no =  JSPUtil.getParameter(request, "imdg_emer_no");
		ctrl_temp_ctnt =  JSPUtil.getParameter(request, "ctrl_temp_ctnt");
		emer_rspn_gid_no =  JSPUtil.getParameter(request, "emer_rspn_gid_no");
		emer_rspn_gid_chr_no =  JSPUtil.getParameter(request, "emer_rspn_gid_chr_no");
		emer_temp_ctnt =  JSPUtil.getParameter(request, "emer_temp_ctnt");
		

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Other Emergency Information</title>
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
<input type="hidden" name="imdg_pck_tp_cd">
<input type="hidden" name="pck_tp_seq">

<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Other Emergency Information</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 		<table class="search"> 
  		<tr><td class="bg">

			<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="53">EMS No</td>
					<!-- 2010.07.12 수정 read only처리함 By KHH-->	
					<!--  <td width="170"><input name="imdg_emer_no" type="text" style="width:124;" class="input" value="<%=imdg_emer_no%>" maxlength="10"></td> -->
					<td width="170"><input name="imdg_emer_no" type="text" style="width:124;" class="input2" value="<%=imdg_emer_no%>" maxlength="14" readOnly ></td> 
					<td width="110">Control Temp</td>
					<td class="stm"><input name="ctrl_temp_ctnt" type="text" style="width:90; text-align:right;" class="input" value="<%=ctrl_temp_ctnt%>" maxlength="5">&nbsp;&deg;C</td>
				</tr>
				<tr class="h23">
					<td>ERG</td>
					<td><input name="emer_rspn_gid_no" type="text" style="width:90;" class="input" value="<%=emer_rspn_gid_no%>" maxlength="3">&nbsp;<input name="emer_rspn_gid_chr_no" type="text" style="width:30;" class="input" value="<%=emer_rspn_gid_chr_no%>" maxlength="2"></td>
					<td>Emergency Temp</td>
					<td class="stm"><input name="emer_temp_ctnt" type="text" style="width:90; text-align:right;" class="input" value="<%=emer_temp_ctnt%>" maxlength="4">&nbsp;&deg;C</td>
				</tr>
			</table>
		
					
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
<table class="height_5"><tr><td></td></tr></table>
</td></tr>
</table> 

	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0" align="center">
		    <tr>
				<td width="71"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_ok">Ok</td>
					<td class="btn1_right"></td>
				</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td width="71"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"></td>
				</tr>
				</table></td>
			</tr>		
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>

</td>
</tr>
</table>

<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>

<SCRIPT LANGUAGE="javascript">


<%
	// Popup 모드 (1: function 호출형, 2: target 세팅형)
	String pop_mode = request.getParameter("pop_mode");	
	if(pop_mode == null || pop_mode.equals(""))
		pop_mode = "1";

	// 호출할 부모창의 스크립트 메소드 (pop_mode가 1(function 호출형) 인 경우)
	String func  = request.getParameter("func");

	// 값을 세팅할 부모창의 Object목록 (pop_mode가 2(target 세팅형) 인 경우)
	String targetObjList = request.getParameter("targetObjList");
	
	// Multi Sheet인 경우, 데이터를 가져올 Sheet 정보
	String sheet = request.getParameter("sheet");	
	
	// Multi Sheet인 경우, Sheet의 Index 정보
	String sheetIdx = request.getParameter("sheetIdx");
	
	// Sheet에서 팝업 호출시, Target이 되는 Cell의 row/col 정보
	String row = request.getParameter("row");
	String col = request.getParameter("col");	
	
	String strDisplay = request.getParameter("display");
	String strPopOpt  = null;
	String popKind	  = null;
%>

	// 부모창의 function을 호출
	function comPopupOK() {
		<%
			if(func == null || func.equals("")) {
		%>
				window.close();
				return;
		<%
			}
		%>

		var item = document.getElementsByTagName("input");

		//alert("item.length : [" + item.length + "]");

		var rArray =  new Array(1); //데이터를 담고 있는 배열
		rArray[0] = new Array(item.length);

		for (var i=0; i < item.length; i++) {
			//
			if ( item[i].type == "text" || item[i].type == "hidden" ) {
				//
				rArray[0][i] = item[i].value;
			}
		}

		//alert("rArray[0] : [" + rArray[0] + "]");

		// 모달창인 경우는 window 객체로부터 opener를 획득
		if(!opener)
			opener = window.dialogArguments;
		
		try {
			<%
				if(func != null && !func.equals("")) {					
					if(row != null && col != null) {
						if(sheetIdx != null && sheetIdx != "") {
			%>
							opener.<%= func %>(rArray, <%=row%>, "<%=col%>", <%=sheetIdx%>);
							window.close();
			<%
						} else {
			%>
							opener.<%= func %>(rArray, <%=row%>, "<%=col%>");
							window.close();
			<%
						}
					} else {
			%>
						opener.<%= func %>(rArray);
						window.close();
			<%
					}
				}
			%>
		}
		catch(e) {
		 	//ComShowCodeMessage("COM12111");
			
		}
	}


</SCRIPT>