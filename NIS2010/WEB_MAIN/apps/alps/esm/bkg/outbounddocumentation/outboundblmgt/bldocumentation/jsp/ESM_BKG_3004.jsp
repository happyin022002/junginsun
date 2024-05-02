<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_3004
*@FileTitle : Interface Monitor
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.22
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2013.10.22 김태경
* 1.0 Creation
===============================================================================
 History
 *
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg3004Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO" %>
<%@ page import="com.hanjin.apps.alps.esm.bkg.common.*" %>

<%
	EsmBkg3004Event  event = null;			//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.OutboundBLMgt.BLDocumentation");

	// search Init
	String bkgNo      = "";
	String blNo       = "";
	String scrnAuth   = "";

	//List<BkgComboVO> frt_terms = null;
	List<BkgComboVO> wgt_units = null;
	List<BkgComboVO> meas_units = null;

	try {

	   	SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg3004Event)request.getAttribute("Event");
		bkgNo      = event.getBkgNo();
		blNo       = event.getBlNo();
		
		scrnAuth   = (String)event.getAttribute("SCRN_AUTH");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        //frt_terms = (List<BkgComboVO>) eventResponse.getCustomData("frt_terms");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<script language="javascript">

    function setupPage(){
        loadPage();
    }

</script>
<body onLoad="setupPage();">

	<form name="form" method="post">
		<input type="hidden" name="f_cmd">
		<input type="hidden" name="pagerows" value="<%=pageRows%>">
		<input type="hidden" name="page_no" value="1">		
		<input type="hidden" name="key">  <!-- BackEndJob -->
		
<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>

		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
							<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
							<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> BKG Interface Management</td></tr>
						</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->

			<!-- TABLE '#D' : ( Button : Main ) (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr>
					<td class="btn1_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								</table>
							</td>
							<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								</table>
							</td>
							<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Button : Main ) (E) -->

		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
		<tr>
			<td class="bg">
				<table class="search_in" border="0">
				<tr class="h23">
					<td width="80">Booking No. </td>
					<td width="200"><input name="bkg_no" type="text" id="bkg_no" style="width:120 ; " value=""  dataformat='engupnum' >&nbsp;<img onClick="openAddPaste('bkg_no')" class="cursor" src="img/button/btng_plus.gif" width="19" height="20" border="0" align="absmiddle" name=""></td>
					
					<td width="55">B/L No.</td>
					<td  width="200"><input name="bl_no" type="text" style="width:110px;"  dataformat='engupnum' ></td>
					<td width="65">CNTR No.</td>
					<input name ="cntr_no" id ="cntr_no" type = "hidden" value ="">
					<td width="200">
					<input name="cntr_no_nonbit" type="text" style="width:100px ; "> 
					<input id ="cntr_no_split" type="text" style="width:22" maxlength="2" readonly>
					</td>
					<td width="60">I/F No</td>
					<td width=""><input name="if_no" type="text" style="width:110px; "></td>
				</tr>
				<tr class="h23">
					<td width="80">VVD </td>
					<td width="200"><input name="vvd" type="text" style="width:120;" value=""  dataformat='engupnum' ></td>
					<td width="110">POL</td>
					<td width="" >
						<input name="pol_cd" type="text" style="width:100; " value=""   dataformat='engupnum' >
					</td>
					<td>POD</td><td><input name="pod_cd" type="text" style="width:60 ; " value=""  dataformat='engupnum' ></td>
				</tr>
				
				<tr class="h23">
					<td width="90">ETD </td>
					<td width=""><input type="text" style="width:78 ; " name="fm_dt"  maxlength="10"  dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)" >&nbsp;&nbsp;~&nbsp;&nbsp;<input type="text" style="width:78" name="to_dt"  maxlength="10" dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)">&nbsp;<img name="btns_calendar1" class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
				</tr>
				
				</table>
			</td>
		</tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

		<!-- TABLE '#D' : ( Tab ) (S) -->
		<table class="tab">
            <tr>
            	<td><script language="javascript">ComTabObject('tab1' )</script>
            	</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Tab ) (E) -->

		<div id="tabLayer" style="display:inline">
		
			<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
			<table class="search" border="0">
				<tr>
						<!-- TABLE '#D' : ( Grid ) (S) -->
						<!-- 'HEAD1-BGCOLOR : 192 235 163' , 'HEAD2-BGCOLOR : 231 250 249' , 'BORDER : 90 138 158' , 'HEAD1-FONT : 0 83 116' , 'DATA GRID BG (2 colors) : 255 255 255, 249 249 249 ' -->
						<table width="100%" id="mainTable">
							<tr><td>
							   <script language="javascript">ComSheetObject('t1sheet1');</script>
							</td></tr>
						</table>
				</tr>
			</table>
			<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
		</div>
		
		<div id="tabLayer" style="display:none">
		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">
					<!-- TABLE '#D' : ( Grid ) (S) -->
					<!-- 'HEAD1-BGCOLOR : 192 235 163' , 'HEAD2-BGCOLOR : 231 250 249' , 'BORDER : 90 138 158' , 'HEAD1-FONT : 0 83 116' , 'DATA GRID BG (2 colors) : 255 255 255, 249 249 249 ' -->
					<table width="100%" id="mainTable">
					<tr><td>
					   <script language="javascript">ComSheetObject('t2sheet1');</script>
					</td></tr>
					
					</table>
					<!-- TABLE '#D' : ( Grid ) (E) --></td>
			</tr>
			
		</table>
		<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_RowAdd">Row Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_RowDelete">Row Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</table>
			</td></tr>
			</table>
		
		</div>
		
		<div id="tabLayer" style="display:none">
		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">

					<table width="100%" id="mainTable">
					<tr><td>
					   <script language="javascript">ComSheetObject('t3sheet1');</script>
					</td></tr>
					</table>
					</td>
			</tr>
		</table>
		
		</div>
		
		<div id="tabLayer" style="display:none">
			<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
			<table class="search" border="0">
				<tr>
					<td class="bg">
						<table width="100%" id="mainTable">
							<tr>
								<td>
						   			<script language="javascript">ComSheetObject('t4sheet1');</script>
								</td>
							</tr>
						</table>
						<!-- TABLE '#D' : ( Grid ) (E) -->
					</td>
				</tr>
			</table>
			<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
		</div>
		
		<div id="tabLayer" style="display:none">
		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">

					<!-- TABLE '#D' : ( Grid ) (S) -->
					<!-- 'HEAD1-BGCOLOR : 192 235 163' , 'HEAD2-BGCOLOR : 231 250 249' , 'BORDER : 90 138 158' , 'HEAD1-FONT : 0 83 116' , 'DATA GRID BG (2 colors) : 255 255 255, 249 249 249 ' -->
					<table width="100%" id="mainTable">
					<tr><td>
					   <script language="javascript">ComSheetObject('t5sheet1');</script>
					</td></tr>
					</table>
					<!-- TABLE '#D' : ( Grid ) (E) --></td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
		</div>
		
		<div id="tabLayer" style="display:none">
		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">

					<!-- TABLE '#D' : ( Grid ) (S) -->
					<!-- 'HEAD1-BGCOLOR : 192 235 163' , 'HEAD2-BGCOLOR : 231 250 249' , 'BORDER : 90 138 158' , 'HEAD1-FONT : 0 83 116' , 'DATA GRID BG (2 colors) : 255 255 255, 249 249 249 ' -->
					<table width="100%" id="mainTable">
					<tr><td>
					   <script language="javascript">ComSheetObject('t6sheet1');</script>
					</td></tr>
					</table>
					<!-- TABLE '#D' : ( Grid ) (E) --></td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
		</div>

		<div id="tabLayer" style="display:none">
		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">

					<!-- TABLE '#D' : ( Grid ) (S) -->
					<!-- 'HEAD1-BGCOLOR : 192 235 163' , 'HEAD2-BGCOLOR : 231 250 249' , 'BORDER : 90 138 158' , 'HEAD1-FONT : 0 83 116' , 'DATA GRID BG (2 colors) : 255 255 255, 249 249 249 ' -->
					<table width="100%" id="mainTable">
					<tr><td>
					   <script language="javascript">ComSheetObject('t7sheet1');</script>
					</td></tr>
					</table>
					<!-- TABLE '#D' : ( Grid ) (E) --></td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
		</div>
</td></tr>
</table>
<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;" align="right"> 
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
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_transmit">Transmit</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>				
			</tr>
			</table>
		</td></tr>
		</table>
<!-- OUTER - (E)nd -->
	</form>
</body>
</html>