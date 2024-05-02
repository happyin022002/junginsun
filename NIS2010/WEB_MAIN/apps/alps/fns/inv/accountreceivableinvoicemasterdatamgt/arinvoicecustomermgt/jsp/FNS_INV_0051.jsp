<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0051.jsp
*@FileTitle : Customer Preferable Report -Item Select
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.28
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2009.08.28 한동훈
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
<%@ page import="com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.event.FnsInv0051Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsInv0051Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";

	Logger log = Logger.getLogger("com.hanjin.apps.AccountReceivableInvoiceMasterDataMgt.ARInvoiceCustomerMgt");
		
	String func  = request.getParameter("func");
	if(func == null || func.equals("")) func = "a";
	String row = request.getParameter("row");
	if(row == null || row.equals("")) row = "1";
	String col = request.getParameter("col");
	if(col == null || col.equals("")) col = "1";
	String tmpltNm  = request.getParameter("rpt_tmplt_nm");
	if(tmpltNm == null || tmpltNm.equals("")) tmpltNm = "";
	String pop_yn = request.getParameter("pop_yn");
	if(pop_yn == null || pop_yn.equals("")) pop_yn = "";
	String noType  = request.getParameter("noType");
	if(noType == null || noType.equals("")) noType = "";
	String noVal  = request.getParameter("noVal");
	if(noVal == null || noVal.equals("")) noVal = "";
	String tmpltOfc  = request.getParameter("tmplt_ofc_cd");
	if(tmpltOfc == null || tmpltOfc.equals("")) tmpltOfc = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();


		event = (FnsInv0051Event)request.getAttribute("Event");
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
<title>Customer Preferable Report -Item Select</title>
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
	
		<!-- : ( Title ) (S) -->
		<%
			if(pop_yn.equals("Y")){
		%>

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- 개발자 작업	-->
<input type="hidden" name="func" value="<%=func%>">
<input type="hidden" name="row" value="<%=row%>">
<input type="hidden" name="col" value="<%=col%>">
<input type="hidden" name="tmpltNm" value="<%=tmpltNm%>">
<input type="hidden" name="pop_yn" value="<%=pop_yn%>">
<input type="hidden" name="ofc_cd_s" value="<%=strOfc_cd%>">
<input type="hidden" name="template_name_tmp">
<input type="hidden" name="retrieve_yn">
<input type="hidden" name="tmplt_ofc_cd" value="">
<input type="hidden" name="select_tmplt" value="">
<input type="hidden" name="tmplt_auth_id" value="">
<input type="hidden" name="noType" value="<%=noType%>">
<input type="hidden" name="noVal" value="<%=noVal%>">		
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Customer Preferable Report -Item Select</td></tr>
		</table>
		<%
			}else{
		%>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- 개발자 작업	-->
<input type="hidden" name="func" value="<%=func%>">
<input type="hidden" name="row" value="<%=row%>">
<input type="hidden" name="col" value="<%=col%>">
<input type="hidden" name="tmpltNm" value="<%=tmpltNm%>">
<input type="hidden" name="pop_yn" value="<%=pop_yn%>">
<input type="hidden" name="ofc_cd_s" value="<%=strOfc_cd%>">
<input type="hidden" name="template_name_tmp">
<input type="hidden" name="retrieve_yn">
<input type="hidden" name="tmplt_ofc_cd" value="">
<input type="hidden" name="select_tmplt" value="">
<input type="hidden" name="tmplt_auth_id" value="">		
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
<tr><td valign="top">		
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<%
			}
		%>
		<!-- : ( Title ) (E) -->
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!-- biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="95">Template Name</td>   
					<td width="280">
						<!-- select style="width:250;" class="input1">
						<option value="0" selected></option>
						<option value="1"></option>
						</select-->
						<script language="javascript"  style="ime-mode:disabled" dataformat="uppernum">ComComboObject('rpt_tmplt_nm', 3, 250, 0, 1, 3, true,true);</script>
						<!-- <script language="javascript">ComComboObject('rpt_tmplt_nm', 1, 100, 2);</script>-->
					</td>
					<td width="">
						<table class="search_sm2" border="0" style="width:93%;"> 
						<tr class="h23">
							<td width="95">Display Option</td> 
							<td class="stm"><input type="radio" name="rpt_auth_id" value="OFC" class="trans" onClick="fncRptAuthId(this);" checked>&nbsp;Public in my office&nbsp;&nbsp;
											<input type="radio" name="rpt_auth_id" value="RHQ" class="trans" onClick="fncRptAuthId(this);">&nbsp;Public in my H/Q&nbsp;&nbsp;
											<input type="radio" name="rpt_auth_id" value="ONLY" class="trans" onClick="fncRptAuthId(this);">&nbsp;Not public&nbsp;&nbsp;
											<input type="radio" name="rpt_auth_id" value="ALL" class="trans" onClick="fncRptAuthId(this);">&nbsp;Public to all 
							</td>   
						</tr>
						</table>	
					</td> 
					</tr>
				</table>	
				<!-- biz_1  (E) -->
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="400" valign="top">
					
					<!-- biz_2  (S) -->
					<table class="search" border="0">
						<tr><td class="title_h"></td>
							<td class="title_s">From</td></tr>
					</table>
					<!-- biz_2 (E) -->
						<!-- Grid  (S) -->
						<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet');</script>
							</td>
						</tr>
						</table> 
						<!-- Grid (E) -->
			
					</td>
					<td width="100" align="center">
						<table>
							<tr>
								<td align="center">
									<img class="cursor" src="img/btns_add.gif" width="26" height="26" border="0" align="absmiddle" name="btn_add">
								</td>
							</tr>
							<tr><td align="center" height="10"></td></tr>
							<tr>
								<td align="center">
									<img class="cursor" src="img/btns_del.gif" width="26" height="26" border="0" align="absmiddle" name="btn_del">
								</td>
							</tr>
						</table>
					</td>
					<td height="" valign="top">
					<!-- biz_3  (S) -->
					<table class="search" border="0">
						<tr><td class="title_h"></td>
							<td class="title_s">To</td></tr>
					</table>
					<!-- biz_3  (E) -->
					<!-- Grid  (S) -->
					<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
					</table>			
					<!-- Grid  (S) -->
					<!-- Charge (S) -->
				    <table width="400">
					<tr>
						<td width="100%" ><!--  <td width="100%" style="display: none"> --> 
						<script language="javascript">ComSheetObject('sheet2');</script></td>
					</tr>
				    </table>
				   <!-- Charge (E) -->
					
					<!--  Button_Sub (S) -->
				<table width="100%" class="button">
					<tr>
						<td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
							<td width="170">Charge break-down S/C(RFA)</td>
							<td align="left">
							<img src="img/btns_search.gif" width="19" height="20" alt=""
							     border="0" align="absmiddle" class="cursor"
							     onclick="javascript:openCharge();" id="popup3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							</td>						
						
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0"
									class="button">
									<tr>
										<td style=" height:19; width:13; background-image: url(/hanjin/img/btn_2_left_up.gif);"></td>
										<td class="btn2" name="btns_up">Seq. Up</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0"
									class="button">
									<tr>
										<td style=" height:19; width:13; background-image: url(/hanjin/img/btn_2_left_down.gif);"></td>
										<td class="btn2" name="btns_down">Seq. Down</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				<!-- Button_Sub (E) -->
					</td>
				</tr>
				</table>	
					
					
		</td></tr>
		</table>
	
	<!--biz page (E)-->		
	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr>
       		<td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
		    	<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve">Retrieve</td>
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
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_delete">Delete</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td width="72"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<%
						if(pop_yn.equals("Y")){
					%>
					<td class="btn1" name="btn_select">Apply</td>
					<% 
						}else{
					%>
					<td class="btn1" name="btn_select" disabled>Apply</td>
					<% 
						}
					%>
					<td class="btn1_right"></td>
					</tr>
				</table></td>		
			</tr>
			</table>
		
    <!--Button (E) -->
	</td></tr>
</table>

</td></tr>
</table>
<%
	if(pop_yn.equals("Y")){
%>
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

    	<!--Button (S) -->	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;" align="left"> 
       	<!--tr><td class="btn3_bg" align="right"-->
       	<tr>
       		<td align="center">
			    <table border="0" cellpadding="0" cellspacing="0">
				    <tr>
				    	
				    	<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_close">Close</td>
							<td class="btn1_right">
							</tr></table>
						</td>
				    	
					</tr>
				</table>
			</td>
				
			</tr>
		</table>
    	<!--Button (E) -->
	
</td></tr>
</table>
<% } %>
<!-- 개발자 작업  끝 -->
</form>
<span style="display:none"><script language="javascript">ComSheetObject('sheet3');</script></span>

</body>
</html>

<SCRIPT LANGUAGE="javascript">
	function callParent(){
		var formObject = document.form;
		
		var rArray = getCheckedRows();
		if(rArray == null) {
			ComShowCodeMessage("COM12114", "row");
			return;
		}
		var func = formObject.func.value;
		var row = formObject.row.value;
		var col = formObject.col.value;
		var rpt_tmplt_nm = formObject.rpt_tmplt_nm.text;
		var tmplt_ofc_cd = formObject.tmplt_ofc_cd.value;

		opener.<%= func %>(rArray, <%=row%>, "<%=col%>", rpt_tmplt_nm+"|"+tmplt_ofc_cd);
		window.close();
	}	
	
	function getCheckedRows(colName) {
		var checkRows;
		var sheetObj = sheetObjects[1];
		var colsCnt = sheetObj.LastCol + 1;
		var rows = sheetObj.Rows;
		var formObject = document.form;
		
		var rArray = null; //행데이터를 담고 있는 배열
    	var cArray = null; //열데이터를 담고 있는 배열
    	
		
 		var idx = 0;
  		rArray = new Array(checkRows);
  		var chgFlg ="N";
  		
  		
		for(var i = 1; i < rows; i++) {

			if(sheetObj.CellValue(i, "ibflag") != "D" && sheetObj.CellValue(i, "rpt_itm_id") != "INV143") {
	  			cArray = null;
	  			
	  			// 특정 컬럼명이 지정된 경우
	  			if(colName != null && colName != "") {
	  				cArray = sheetObj.CellValue(i, colName);
	  			} else {
	  				cArray = new Array(colsCnt);
	  				
		  			for(var j=0; j<cArray.length; j++) {
	                   	cArray[j] = sheetObj.CellValue(i, j);
	                   		                 }
	             }
                 rArray[idx++] = cArray;
              } 
 	  	   }
	  	return rArray;
	}	
</SCRIPT>