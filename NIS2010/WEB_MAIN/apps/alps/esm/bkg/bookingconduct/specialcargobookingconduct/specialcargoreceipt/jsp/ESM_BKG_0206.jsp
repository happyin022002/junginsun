<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0206.jsp
*@FileTitle : Copy To
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.17
*@LastModifier : 이병규
*@LastVersion : 1.0
* 2009.06.17 이병규
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.event.EsmBkg0206Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0206Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	String in_imdg_pck_cd1 = ""; 
	String in_imdg_pck_cd2 = "";  
	String intmd_imdg_pck_cd1 = ""; 
	String intmd_imdg_pck_cd2 = "";  
	String out_imdg_pck_cd1 = "";  
	String out_imdg_pck_cd2 = "";  
	String in_imdg_pck_desc1 = "";  
	String in_imdg_pck_desc2 = "";  
	String intmd_imdg_pck_desc1 = "";  
	String intmd_imdg_pck_desc2 = "";  
	String out_imdg_pck_desc1 = "";  
	String out_imdg_pck_desc2 = "";  
	String in_imdg_pck_qty1 = "";  
	String in_imdg_pck_qty2 = ""; 
	String intmd_imdg_pck_qty1 = "";  
	String intmd_imdg_pck_qty2 = ""; 
	String out_imdg_pck_qty1 = "";  
	String out_imdg_pck_qty2 = "";   
	String max_in_pck_qty = "";   
	String max_in_pck_tp_cd = "";   
	String hcdg_intmd_bc_rstr_desc = "";   
	String hcdg_pck_rstr_desc = "";   
	String hcdg_tnk_rstr_desc = "";   
	String ltd_qty = "";  
	String imdg_expt_qty_cd = "";
	String grs_wgt = "";
	String net_wgt = "";
	String grs_capa_qty = "";
	String grs_capa_ut_cd = "";
	String dcgo_sts_cd = "";
	String imdg_lmt_qty_flg = "";
		
	Logger log = Logger.getLogger("com.hanjin.apps.SpecialCargoBookingConduct.SpecialCargoReceipt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0206Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		in_imdg_pck_cd1 = JSPUtil.getParameter(request, "in_imdg_pck_cd1"); 
		in_imdg_pck_cd2 = JSPUtil.getParameter(request, "in_imdg_pck_cd2"); 
		intmd_imdg_pck_cd1 = JSPUtil.getParameter(request, "intmd_imdg_pck_cd1"); 
		intmd_imdg_pck_cd2 = JSPUtil.getParameter(request, "intmd_imdg_pck_cd2"); 
		out_imdg_pck_cd1 = JSPUtil.getParameter(request, "out_imdg_pck_cd1"); 
		out_imdg_pck_cd2 = JSPUtil.getParameter(request, "out_imdg_pck_cd2"); 
		in_imdg_pck_desc1 = JSPUtil.getParameter(request, "in_imdg_pck_desc1"); 
		in_imdg_pck_desc2 = JSPUtil.getParameter(request, "in_imdg_pck_desc2");
		intmd_imdg_pck_desc1 = JSPUtil.getParameter(request, "intmd_imdg_pck_desc1"); 
		intmd_imdg_pck_desc2 = JSPUtil.getParameter(request, "intmd_imdg_pck_desc2"); 
		out_imdg_pck_desc1 = JSPUtil.getParameter(request, "out_imdg_pck_desc1"); 
		out_imdg_pck_desc2 = JSPUtil.getParameter(request, "out_imdg_pck_desc2"); 
		in_imdg_pck_qty1 = JSPUtil.getParameter(request, "in_imdg_pck_qty1"); 
		in_imdg_pck_qty2 = JSPUtil.getParameter(request, "in_imdg_pck_qty2");	
		intmd_imdg_pck_qty1 = JSPUtil.getParameter(request, "intmd_imdg_pck_qty1"); 
		intmd_imdg_pck_qty2 = JSPUtil.getParameter(request, "intmd_imdg_pck_qty2");	
		out_imdg_pck_qty1 = JSPUtil.getParameter(request, "out_imdg_pck_qty1"); 
		out_imdg_pck_qty2 = JSPUtil.getParameter(request, "out_imdg_pck_qty2");		
		hcdg_intmd_bc_rstr_desc = JSPUtil.getParameter(request, "hcdg_intmd_bc_rstr_desc");  
		hcdg_pck_rstr_desc = JSPUtil.getParameter(request, "hcdg_pck_rstr_desc");  
		hcdg_tnk_rstr_desc = JSPUtil.getParameter(request, "hcdg_tnk_rstr_desc");  
		ltd_qty = JSPUtil.getParameter(request, "ltd_qty"); 
		imdg_expt_qty_cd = JSPUtil.getParameter(request, "imdg_expt_qty_cd"); 
		grs_wgt = JSPUtil.getParameter(request, "grs_wgt"); 
		net_wgt = JSPUtil.getParameter(request, "net_wgt"); 
		grs_capa_qty = JSPUtil.getParameter(request, "grs_capa_qty"); 
		dcgo_sts_cd = JSPUtil.getParameter(request, "dcgo_sts_cd");
		imdg_lmt_qty_flg = JSPUtil.getParameter(request, "imdg_lmt_qty_flg");

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		if(dcgo_sts_cd.equals("L")){
			//grs_wgt_ut_cd = "L";
			//net_wgt_ut_cd = "L";
			grs_capa_ut_cd = "L";			
		} else {
			//grs_wgt_ut_cd = "KGS";
			//net_wgt_ut_cd = "KGS";
			grs_capa_ut_cd = "KGS";
		}

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>DG Package Q'ty & Type</title>
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

<body class="popup_bg" onLoad="setupPage()">
<form name="form">

<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="imdg_pck_tp_cd">
<input type="hidden" name="temp_pck_tp_cd">
<input type="hidden" name="temp_imdg_pck_desc">
<input type="hidden" name="pck_tp_seq">
<input type="hidden" name="imdg_pck_cd">

<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; DG Package Q'ty & Type</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
			<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Outer Package</td></tr>
				</table>
				
				<table class="search" border="0" style="width:666;"> 
				<tr class="h23">
					<td width="60">1st Q'TY</td>
					<td width="100"><input type="text" name="out_imdg_pck_qty1" style="width:60;text-align:right" class="input1" value="<%=out_imdg_pck_qty1%>" dataformat="float" maxlength="5"></td>
					<td width="40">Type</td>
					<td><input type="text" name="out_imdg_pck_cd1" style="width:45;" class="input1" value="<%=out_imdg_pck_cd1%>" maxlength="5">&nbsp;<input type="text" name="out_imdg_pck_desc1" style="width:401;" class="input" value="<%=out_imdg_pck_desc1%>" readonly>&nbsp;<img name="out_btn1" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td></tr>
				<tr class="h23">
					<td width="60">2nd Q'TY</td>
					<td width="100"><input type="text" name="out_imdg_pck_qty2" style="width:60;text-align:right" class="input" value="<%=out_imdg_pck_qty2%>" dataformat="float" maxlength="5"></td>
					<td width="40">Type</td>
					<td><input type="text" name="out_imdg_pck_cd2" style="width:45;" class="input" value="<%=out_imdg_pck_cd2%>" maxlength="5">&nbsp;<input type="text" name="out_imdg_pck_desc2" style="width:401;" class="input" value="<%=out_imdg_pck_desc2%>" readonly>&nbsp;<img name="out_btn2" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td></tr>
				</table>
				
				<table class="height_8"><tr><td></td></tr></table>
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Intermediate Package</td></tr>
				</table>
				
				<table class="search" border="0" style="width:666;"> 
				<tr class="h23">
					<td width="60">1st Q'TY</td>					
					<td width="100"><input type="text" name="intmd_imdg_pck_qty1" style="width:60;text-align:right" class="input" value="<%=intmd_imdg_pck_qty1%>" dataformat="float" maxlength="6"></td>
					<td width="40">Type</td>
					<td><input type="text" name="intmd_imdg_pck_cd1" style="width:45;" class="input" value="<%=intmd_imdg_pck_cd1%>" maxlength="5">&nbsp;<input type="text" name="intmd_imdg_pck_desc1" style="width:401;" class="input" value="<%=intmd_imdg_pck_desc1%>" readonly>&nbsp;<img name="intmd_btn1" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td></tr>
				<tr class="h23">
					<td width="60">2nd Q'TY</td>
					<td width="100"><input type="text" name="intmd_imdg_pck_qty2" style="width:60;text-align:right" class="input" value="<%=intmd_imdg_pck_qty2%>" dataformat="float" maxlength="6"></td>
					<td width="40">Type</td>
					<td><input type="text" name="intmd_imdg_pck_cd2" style="width:45;" class="input" value="<%=intmd_imdg_pck_cd2%>" maxlength="5">&nbsp;<input type="text" name="intmd_imdg_pck_desc2" style="width:401;" class="input" value="<%=intmd_imdg_pck_desc2%>" readonly>&nbsp;<img name="intmd_btn2" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td></tr>
				</table>
				
				<table class="height_8"><tr><td></td></tr></table>
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Inner Package</td></tr>
				</table>
				
				<table class="search" border="0" style="width:666;"> 
				<tr class="h23">
					<td width="60">1st Q'TY</td>
					<td width="100"><input type="text" name="in_imdg_pck_qty1" style="width:60;text-align:right" class="input" value="<%=in_imdg_pck_qty1%>" dataformat="float" maxlength="6"></td>
					<td width="40">Type</td>
					<td><input type="text" name="in_imdg_pck_cd1" style="width:45;" class="input" value="<%=in_imdg_pck_cd1%>" maxlength="5">&nbsp;<input type="text" name="in_imdg_pck_desc1" style="width:401;" class="input" value="<%=in_imdg_pck_desc1%>" readonly>&nbsp;<img name="in_btn1" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td></tr>
				<tr class="h23">
					<td width="60">2nd Q'TY</td>
					<td width="100"><input type="text" name="in_imdg_pck_qty2" style="width:60;text-align:right" class="input" value="<%=in_imdg_pck_qty2%>" dataformat="float" maxlength="6"></td>
					<td width="40">Type</td>
					<td><input type="text" name="in_imdg_pck_cd2" style="width:45;" class="input" value="<%=in_imdg_pck_cd2%>" maxlength="5">&nbsp;<input type="text" name="in_imdg_pck_desc2" style="width:401;" class="input" value="<%=in_imdg_pck_desc2%>" readonly>&nbsp;<img name="in_btn2" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td></tr>
				</table>						
				
				<table class="height_8"><tr><td></td></tr></table>
				
				<table class="search" border="0" style="width:666;"> 
				<tr class="grid2">
					<td width="120" class="title_s" style="width:120;text-align:left">Gross Weight</td>
					<td width="80"><input type="text" class="input2" style="width:80;text-align:right" name="grs_wgt" value="<%=grs_wgt%>" readonly></td>
					<td width="50"><input type="text" class="input2" style="width:30;text-align:left" value="KGS" readonly></td>
					<td width="100" class="title_s" style="width:100;text-align:left">Net Weight</td>
					<td width="80"><input type="text" class="input2" style="width:80;text-align:right" name="net_wgt" value="<%=net_wgt%>" readonly></td>
					<td width="50"><input type="text" class="input2" style="width:30;text-align:left" value="KGS" readonly></td>
					<td width="100" class="title_s" style="width:100;text-align:left">Total Capacity</td>
					<td width="80"><input type="text" class="input" style="width:80;text-align:right" name="grs_capa_qty" value="<%=grs_capa_qty%>" dataformat="float" maxlength="6"></td>
					<td width="30"><input type="text" class="input2" style="width:30;text-align:left" value="<%=grs_capa_ut_cd%>" readonly></td>
				</tr>
				<tr class="grid2">
					<td width="250" class="title_s" style="width:250;text-align:left" colspan="3">Gross Weight / Outer Package Q'ty</td>
					<td width="230" class="title_s" style="width:230;text-align:left" colspan="3">Net Weight / Inner Package Q'ty</td>
					<td width="210" class="title_s" style="width:210;text-align:left" colspan="3">Capacity / Inner Package Q'ty</td>
				</tr>
				<tr class="grid2">
					<td width="120" class="title_s"></td>
					<td width="80"><input type="text" class="input2" style="width:80;text-align:right" name="grs_per_unit" readonly></td>
					<td width="50"><input type="text" class="input2" style="width:30;text-align:left" value="KGS" readonly></td>
					<td width="100" class="title_s"></td>
					<td width="80"><input type="text" class="input2" style="width:80;text-align:right" name="net_per_unit" readonly></td>
					<td width="50"><input type="text" class="input2" style="width:30;text-align:left" value="KGS" readonly></td>
					<td width="100" class="title_s"></td>
					<td width="80"><input type="text" class="input2" style="width:80;text-align:right" name="max_per_unit"></td>
					<td width="30"><input type="text" class="input2" style="width:30;text-align:left" value="<%=grs_capa_ut_cd%>" readonly></td>
				</tr>
				</table>
				
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Restrictions</td></tr>
				</table>
				
				<table border="0" style="width:100%; background-color:white;" class="grid2"> 
				<tr>
				<td  width="80" class="tr2_head">Packing</td>
				<td class="input2"><input type="text" name="hcdg_pck_rstr_desc" style="width:100%" class="noinput2" value="<%=hcdg_pck_rstr_desc%>" readonly></td></tr></table>
				
				<table class="height_2"><tr><td></td></tr></table>
				
				<table border="0" style="width:100%; background-color:white;" class="grid2"> 
				<tr>
				<td  width="200" class="tr2_head">Intermediate Bulk Container - IBC</td>
				<td class="input2"><input type="text" name="hcdg_intmd_bc_rstr_desc" style="width:100%" class="noinput2" value="<%=hcdg_intmd_bc_rstr_desc%>" readonly></td></tr>
				</table>
				<table class="height_2"><tr><td></td></tr></table>
				
				<table border="0" style="width:100%; background-color:white;" class="grid2"> 
				<tr>
				<td  width="80" class="tr2_head">Tank</td>
				<td class="input2"><input type="text" name="hcdg_tnk_rstr_desc" style="width:100%" class="noinput2" value="<%=hcdg_tnk_rstr_desc%>" readonly></td></tr>
				</table>
				<table class="height_2"><tr><td></td></tr></table>
				
				<table border="0" style="width:100%; background-color:white;" class="grid2"> 
				<tr>
				<td  width="80" class="tr2_head">LTD QTY</td>
				<td class="input2"><input type="text" name="ltd_qty" style="width:100%" class="noinput2" value="<%=ltd_qty%>" readonly></td></tr>
				</table>
				<table class="height_2"><tr><td></td></tr></table>
				
				<table border="0" style="width:100%; background-color:white;" class="grid2"> 
				<tr>
				<td width="80" class="tr2_head">Excepted QTY</td>
				<td class="input2"><input type="text" name="imdg_expt_qty_cd" style="width:100%" class="noinput2" value="<%=imdg_expt_qty_cd%>" readonly></td></tr>
				</table>
				
				<table width="0"  id="mainTable">
						<tr>
							<td width="0">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
				</table>
				
				<!-- : ( Button : Grid ) (S) -->
				
		    <!-- : ( Button : Grid ) (E) -->	
			
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->

<table class="height_5"><tr><td></td></tr></table>
</td></tr>
</table> 
<input type="hidden" name="imdg_lmt_qty_flg" value="<%=imdg_lmt_qty_flg%>">	
<input type="hidden" name="dcgo_sts_cd" value="<%=dcgo_sts_cd%>">
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td width="72"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_ok">Ok</td>
					<td class="btn1_right"></td>
			</tr>
			</table>
		</td>
		<td class="btn1_line"></td>
				<td width="72"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right"></td>
			</tr>
			</table>
		</td></tr>
		</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
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
		
		var i_len = item.length;

		

		var rArray =  new Array(1); //데이터를 담고 있는 배열
		rArray[0] = new Array(i_len);

		for (var i=0; i < i_len; i++) {
			
			if ( item[i].type == "text" || item[i].type == "hidden" ) {
				
				rArray[0][i] = item[i].value;
			}		
		}		

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
		 	
			
		}
	}


</SCRIPT>