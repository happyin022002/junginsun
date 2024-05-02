<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0086.jsp
*@FileTitle : Quick Customer Search
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.28
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2009.05.28 한동훈
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
<%@ page import="com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.event.FnsInv0086Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsInv0086Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String loginOfcCd = "";
	Logger log = Logger.getLogger("com.hanjin.apps.AccountReceivableInvoiceMasterDataMgt.ARInvoiceCustomerMgt");

	String cust_cnt_cd = request.getParameter("cust_cnt_cd");
	if(cust_cnt_cd == null){
		cust_cnt_cd = "";
	}
	
	String cust_seq = request.getParameter("cust_seq");
	if(cust_seq == null){
		cust_seq = "";
	}
	
	String cust_lgl_eng_nm = request.getParameter("cust_lgl_eng_nm");
	if(cust_lgl_eng_nm == null){
		cust_lgl_eng_nm = "";
	}
	
	String cust_rgst_no = request.getParameter("cust_rgst_no");
	if(cust_rgst_no == null){
		cust_rgst_no = "";
	}
	
	String popOffice = request.getParameter("office");
	if(popOffice == null){
		popOffice = "";
	}
	
	String func  = request.getParameter("func");
	String row = request.getParameter("row");
	String col = request.getParameter("col");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		loginOfcCd = account.getOfc_cd();

		event = (FnsInv0086Event)request.getAttribute("Event");
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
<title>Quick Customer Search</title>
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
<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<input type="hidden" name="func" value="<%=func%>">
<input type="hidden" name="row" value="<%=row%>">
<input type="hidden" name="col" value="<%=col%>">
<input type="hidden" name="cust_seq" value="<%=cust_seq%>">
<input type="hidden" name="pagetype" value = "E">
<input type="hidden" name="login_ofc_cd" value="<%=loginOfcCd%>">
<input type="hidden" name="popOffice" value="<%=popOffice%>">
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Quick Customer Search </td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 <table class="search"> 
       		<tr><td class="bg">
				<!-- biz_1  (S) -->
				<table class="search" border="0" style="width:870;"> 
				<tr class="h23">
					<td width="110">Country Code</td>
					<td width="60"><input name="cust_cnt_cd" type="text" style="width:30; text-align:center;" class="input1" maxlength='2'  style="ime-mode:disabled" dataformat="engup" onKeyup="moveNext('cust_cnt_cd','cust_lgl_eng_nm',2);"></td>
					<td width="120">Customer Name</td>					
					<td width="290">						
						<input name="cust_lgl_eng_nm" type="text" style="width:180;" class="input"  style="ime-mode:disabled" dataformat="engup">
						Include<input type="checkbox" value="Y" class="trans" name="chk_nm">
					</td>
					<td width="70">Zip Code</td>   
					<td width="100"><input type="text" name="zip_cd" style="width:60;" class="input"></td>
					<td width="120">TaxPayerID/RegNo</td>   
					<td><input type="text" name="cust_rgst_no"  style="width:80; text-align:center;" class="input" dataformat="num" maxlength="14" value="<%=cust_rgst_no%>"></td>
				</tr>
				</table>
				
				<table class="height_2"><tr><td colspan="8"></td></tr></table>
					<!-- Grid  (S) -->

						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table> 

					<!-- Grid (E) -->
				
				<!-- : ( Button : Grid ) (S) -->
				<!--  Button_Sub (S) -->
			
	    	<!-- Button_Sub (E) -->
		    <!-- : ( Button : Grid ) (E) -->	
			
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
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
			</tr>
			</table>
		</td>
		<td width=""><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
			</tr>
			</table>
		</td>
		<td width=""><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_apply">Apply</td>
					<td class="btn1_right"></td>
			</tr>
			</table>
		</td>
				<td class="btn1_line"></td>
		<td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td width="72"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"></td>
			</tr>
			</table>
		</td>
		</tr>
		</table>
		</td>
		</tr>
		</table></td></tr>
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
		
		opener.<%= func %>(rArray, <%=row%>, "<%=col%>");
		window.close();
	}	
	
	function getCheckedRows(colName) {
		var checkRows;
		var sheetObj = sheetObjects[0];
		var colsCnt = sheetObj.LastCol + 1;
		var rows = sheetObj.Rows;
		
		var rArray = null; //행데이터를 담고 있는 배열
    	var cArray = null; //열데이터를 담고 있는 배열
    	
		checkRows = sheetObj.CheckedRows("SelChk");
		if(checkRows == 0) {
  			return null;
  		}
  		else {
  			var idx = 0;
	  		rArray = new Array(checkRows);
	  		
			for(var i = 0; i < rows; i++) {
				if(sheetObj.CellValue(i, "SelChk") == 1) {					
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
	  	}
	  	return rArray;
	}	
</SCRIPT>	