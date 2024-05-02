<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_vsk_0009.jsp
*@FileTitle : Terminal Information
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.15
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.05.25 장석현
* 1.0 Creation
*
* History
* 2011.04.15 진마리아 padding-right 설정
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.event.VopVsk0509Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0509Event event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id	= "";
	String strUsr_nm	= "";
	String pop_yn       = "";
	String loc_cd		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.VesselOperationSupportMgt.TerminalInformationMgt");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (VopVsk0509Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		pop_yn      = JSPUtil.replaceForHTML(request.getParameter("pop_mode"))==null?"N":"Y";
		loc_cd  	= JSPUtil.replaceForHTML(request.getParameter("loc_cd"))==null?"":JSPUtil.replaceForHTML(request.getParameter("loc_cd"));		
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Terminal Information</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	//팝업호출 및 초기조회조건
	//SCG_0016에서 팝업 조회
	var preConds = {
		pop_yn      : "<%=pop_yn%>",
		loc_cd   	: "<%=loc_cd%>"
	}

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		
		if('Y' == preConds.pop_yn) {		
			
			//닫기버튼 보이기
			document.all.popLayer.style.display = "";
			
			//Set title of page
			var titleStr = "Terminal Information";
			try {
				var appName = navigator.appName;
			 	if (appName.indexOf("Netscape") == -1) {
			  		document.all.pophistory.innerHTML = "";
			  		document.all.title.innerHTML = '&nbsp; '+titleStr;
			  		document.title = titleStr;
			 	} else {
			  		document.getElementById("pophistory").innerHTML = "";
			  		document.getElementById("title").innerHTML = '&nbsp; '+titleStr;
			  		document.title = titleStr;
			 	}
			}catch(err) {
			 	ComShowMessage(err);
			}
		}
		
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="comboCd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;padding-right:5;">
	<tr><td valign="top">
	
	
	
		<!--Page Title, Historical (S)-->
		
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history" id="pophistory"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->


		<!--biz page (S)-->
		<table class="search" id="mainTable">
       		<tr><td class="bg">

				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="35">Port</td>
					<td width="100"><input type="text" style="width:60;text-align:center;" class="input1" value="" name="loc_cd" maxlength="5" fullfill caption="Port Code" style="ime-mode:disabled">&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="ComOpenPopupWithTarget"> <!-- <input type="text" style="width:60;" class="input" value=" " name="port_nm">&nbsp;<img class="cursor" src="img/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle"> --></td>
					<td width="35">RHQ</td>
					<td width="110">
						<div id="enablePorRhq" style="display:none;"><script language="javascript">ComComboObject('por_rhq');</script></div>
						<div id="disablePorRhq" style="display:inline;"><input type="text" style="width:90;" class="input2" value="" name="por_rhq_diable" readonly></div>
					</td>
					<td width="450"></td>
					<td width="90">Updated Date</td>   
					<td width="116"><input type="text" name="upd_dt_view" style="width:115;text-align:center;" class="input2" readOnly></td>
					<td width="70" align="right"><input type="text" name="upd_id_view" style="width:70;" class="input2" readOnly></td>

					</tr>
				</table>
				<!--  biz_1   (E) -->

		</td></tr></table>
		<table class="height_8"><tr><td></td></tr></table>

		<!-- Tab (S) -->
 		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%>
   		<tr><td width="100%">
				<script language="javascript">ComTabObject('tab1')</script>
				<!-- img src="img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
			</td></tr>
		</table>
		<!-- Tab (E) -->
		
<!-- TAB [ G/Crane ] (S) -->
<div id="tabLayer" style="display:inline">

		<table class="search" id="mainTable">
       		<tr><td class="bg" style="height:438" valign="top">


			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t1sheet1');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->


			<table class="height_8"><tr><td></td></tr></table>
			<table border="0" style="width:100%; background-color:white;" class="grid2">
			<tr class="tr_head2"></tr>
				<td width="15%" class="tr2_head" rowspan="2"> Remark(s)	</td>
				<td width="%" rowspan="2"> <textarea style="width:100%;height:60" name="gntr_rmk"></textarea></td>
 				</tr>
			</table>

			<table class="height_8"><tr><td></td></tr></table>
			<table border="0" style="width:100%; background-color:white;" class="grid2">
			<tr class="tr_head2"></tr>
				<td width="15%" class="tr2_head" rowspan="2"> AWK/BB<br>Handling Information</td>
				<td width="%" rowspan="2"> <textarea style="width:100%;height:100" maxlength="4000" name=spcl_cgo_hndl_rmk style="ime-mode:disabled"></textarea></td>
 				</tr>
			</table>

			<br>
			<table class="search" border="0" style="width:100%;">
			<tr class="h23">
				<td width="75%"></td>
				<td width="250" align="right">
					Attach File
					&nbsp;
					<input type="text" style="width:35;text-align:center;" class="input2" value="" name="atch_file_knt" readonly>
					&nbsp;
					<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="VskOpenPopupPortGantryCraneHandlingInfoAttachFile">						
				</td>
				</tr>
			</table>

			</td></tr>
		</table>
		<!--biz page (E)-->
		
</div>
<!-- TAB [ G/Crane ] (E) -->


<!-- TAB [ F/Crane ] (E) -->
<div id="tabLayer" style="display:none">

		<table class="search" id="mainTable"> 
       		<tr><td class="bg" style="height:438" valign="top">	
			
			
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t2sheet1');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->			
			
			
			<table class="height_8"><tr><td></td></tr></table>
			<table border="0" style="width:100%; background-color:white;" class="grid2"> 
			<tr class="tr_head2"></tr>
				<td width="15%" class="tr2_head" rowspan="2">  Remark(s)	</td>
				<td width="%" rowspan="2"> <textarea style="width:100%;height:60" name="fltg_rmk"></textarea></td>
 				</tr>
			</table> 
			
			
			
			</td></tr>
		</table>
		<!--biz page (E)-->

</div>
<!-- TAB [ F/Crane ] (E) -->


<!-- TAB [ Gang Structure ] (E) -->
<div id="tabLayer" style="display:none">

		<table class="search" id="mainTable"> 
       		<tr><td class="bg" style="height:438" valign="top">	
			
			
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t3sheet1');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->			
			</td></tr>
		</table>
		<!--biz page (E)-->

</div>
<!-- TAB [ Gang Structure ] (E) -->


<!-- TAB [ Berth Window ] (E) -->
<div id="tabLayer" style="display:none">

		<table class="search" id="mainTable"> 
       		<tr><td class="bg" style="height:438" valign="top">
			
			
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t4sheet1');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->			
			
			</td></tr>
		</table>
		<!--biz page (E)-->

</div>
<!-- TAB [ Berth Window ] (E) -->


		<!-- Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left">
					<td class="btn1" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right">
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
					<td class="btn1" name="btn_DownExcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table></td>

			</tr>
			</table>
			<!-- Button (E) -->

<!--  -->
<div id="divSheet1" style="display:none;"><script language="javascript">ComSheetObject('sheet1');</script></div>

	</td></tr>
		</table>

<div id="popLayer" style="display:none">
<table class="height_5"><tr><td></td></tr></table>	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup">
	
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"> 
       			<tr>
       				<td class="btn3_bg">
		    			<table border="0" cellpadding="0" cellspacing="0">
		    				<tr>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Close">Close</td>
											<td class="btn1_right">
										</tr>
									</table>
								</td>
							</tr>
						</table>
    					<!--Button (E) -->
	
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<!-- : ( Button : pop ) (E) -->
</div>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>