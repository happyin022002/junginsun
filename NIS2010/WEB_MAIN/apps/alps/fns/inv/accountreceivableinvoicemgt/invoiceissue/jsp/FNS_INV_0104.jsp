<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0104.jsp
*@FileTitle : CPR Download History Inquiry - Search
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2009.08.18 한동훈
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
<%@ page import="com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.event.FnsInv0104Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsInv0104Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.AccountReceivableInvoiceMgt.InvoiceIssue");
	
	String cust_rpt_id = request.getParameter("cust_rpt_id");
	if(cust_rpt_id == null){
		cust_rpt_id = "";
	}
	
	String func  = request.getParameter("func");
	String row = request.getParameter("row");
	String col = request.getParameter("col");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (FnsInv0104Event)request.getAttribute("Event");
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
<title>CPR Download History Inquiry - Search</title>
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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="func" value="<%=func%>">
<input type="hidden" name="row" value="<%=row%>">
<input type="hidden" name="col" value="<%=col%>">
<!-- OUTER - POPUP (S)tart -->
<table width="700" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;CPR Download History Inquiry - Search
			</td>
		</tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 		<table class="search"> 
       		<tr><td class="bg">
				<table class="search" border="0" style="width:100%;"> 
					<tr class="h23">
						<td width="160">Report ID Creation Date</td>
						<td width="" class="stm">
							&nbsp;From&nbsp;&nbsp;
							<input type="text" name="from_cre_dt" style="width:85" class="input1" dataformat="ymd" maxlength="10" size="10" cofield="to_cre_dt" caption="start date">&nbsp;
							<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_calendar1">								
							&nbsp;~&nbsp;&nbsp;To&nbsp;&nbsp;
							<input type="text" name="to_cre_dt" style="width:85" class="input1" dataformat="ymd" maxlength="10" size="10" cofield="from_cre_dt" caption="end date">&nbsp;
							<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_calendar2">
						</td>
					</tr>
				</table>
				<table class="search" border="0" style="width:100%;"> 
					<tr class="h23">
						<td width="40">Office</td>
						<td width="200"><input type="text" name="ar_ofc_cd" style="width:100" class="input" style="ime-mode:disabled" dataformat="uppernum" maxlength="5"></td>
						<td width="50">User ID</td>
						<td width=""><input type="text" name="cre_usr_id" style="width:100" class="input" style="ime-mode:disabled" dataformat="uppernum"></td>						
					</tr>
				</table>		
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table> 
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
</td></tr>
</table> 

<table class="height_5"><tr><td></td></tr></table>
	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
	<tr><td height="71" class="popup">	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr>
	       	<td class="btn3_bg">
			    <table border="0" cellpadding="0" cellspacing="0">
			    <tr>
					<td width="80">
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_Retrieve">Retrieve</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td width="72">
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_ok">OK</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td width="72">
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_New">New</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td width="72">
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_close">Close</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
				</tr>
				</table>	
			</td></tr>
		</table>
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