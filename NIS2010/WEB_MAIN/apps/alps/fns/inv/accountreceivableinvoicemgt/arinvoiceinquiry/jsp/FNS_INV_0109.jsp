<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0109.jsp
*@FileTitle : Invoice Search (Pop-Up) _Vietnam
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.27
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.10.27 박정진
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
<%@ page import="com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event.FnsInv0109Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsInv0109Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	
	String issOfcCd = "";
	String selOption = "";
	
	String func  = request.getParameter("func");
	String row = request.getParameter("row");
	String col = request.getParameter("col");

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.AccountReceivableInvoiceMgt.ARInvoiceInquiry");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (FnsInv0109Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		issOfcCd = request.getParameter("iss_ofc_cd") != null ? request.getParameter("iss_ofc_cd") : "";
		selOption = request.getParameter("sel_option") != null ? request.getParameter("sel_option") : "";
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Invoice Search (Pop-Up) _Vietnam</title>
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
<input type="hidden" name="pagetype" value="I">
<input type="hidden" name="office" value="<%=issOfcCd%>">
<input type="hidden" name="sel_option" value="<%=selOption%>">

<!-- OUTER - POPUP (S)tart -->
<table width="800" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr>
	<td valign="top">
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Invoice Search </td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
		<table class="search">
		<tr>
			<td class="bg">
				<table class="search" border="0" style="width:100%;">
				<tr class="h23">
					<td width="90" align="right">Issue Date&nbsp;</td>
					<td width="250" colspan="3"><input type="text" style="width:75" name="iss_fm_dt" class="input1" required caption="start date" dataformat="ymd" maxlength="8" value="" cofield="iss_to_dt">&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="btns_calendar1" width="19" height="20" border="0" align="absmiddle">&nbsp;~&nbsp;<input type="text" style="width:75" name="iss_to_dt" class="input1" required caption="end date" dataformat="ymd" maxlength="8" value="" cofield="iss_fm_dt">&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="btns_calendar2" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="100" align="right">Invoice Type&nbsp;</td>
					<td width=""style="padding-left:2;"><script language="javascript"  style="ime-mode:disabled" dataformat="uppernum">ComComboObject('inv_type', 1, 90, 1, 100, 0, 0);</script></td>
				</tr>
				<tr class="h23">
					<td width="" align="right">Actual Cust.&nbsp;</td>
					<td width="" colspan="3"><input type="text" name="cust_cnt_cd" minlength="2" maxlength="2" dataformat="engup" style="width:30"  value="" class="input">&nbsp;-&nbsp;<input type="text" name="cust_seq" minlength="6" maxlength="6" dataformat="int" style="width:57"  value="" class="input">&nbsp;<input type="text" name="cust_nm" style="width:286"  value="" class="input2" readOnly></td>
					<td width="" align="right">User ID&nbsp;</td>
					<td width=""><input type="text" name="usr_id" maxlength="20" value="" dataformat="eng" style="width:90" value="" class="input"></td>
				</tr>
				<tr class="h23">
					<td width="" align="right">Invoice No.&nbsp;</td>
					<td width="120"><input type="text" style="width:100"  name="inv_no" class="input" minlength="9" maxlength="9" dataformat="engup" value=""></td>
					<td width="100" align="right">B/L No.&nbsp;</td>
					<td width="120"><input type="text" style="width:100"  name="bl_src_no" class="input" minlength="12" maxlength="12" dataformat="engup" value=""></td>
					<td width="" align="right">Actual Inv No&nbsp;</td>
					<td width=""><input type="text" name="act_inv_no" value="" dataformat="engup" style="width:90" value="" class="input" minlength="6" maxlength="6"></td>
				</tr>
				</table>
				<!--grid (S)-->
				<table width="100%"  id="mainTable">
				<tr>
					<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script></td>
				</tr>
				</table>
				<!--grid (E)-->
			</td>
		</tr>
		</table>
		<!-- : ( Search Options ) (E) -->
	</td>
</tr>
</table>

<table class="height_5"><tr><td></td></tr></table>

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr>
	<td height="71" class="popup">
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
		<tr>
			<td class="btn3_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_retrieve">Retrieve</td>
							<td class="btn1_right"></td>
						</tr></table>
					</td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_new">New</td>
							<td class="btn1_right"></td>
						</tr></table>
					</td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_apply">Apply</td>
							<td class="btn1_right"></td>
						</tr></table>
					</td>
					<td class="btn1_line"></td>
					<td width="72"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_close">Close</td>
							<td class="btn1_right"></td>
						</tr></table>
					</td>
				</tr>
				</table>
			</td>
		</tr>
		</table>
		<!--Button (E) -->
	</td>
</tr>
</table>
<!-- : ( Button : pop ) (E) -->
<!-- 개발자 작업  끝 -->
</form>
</body>

<SCRIPT LANGUAGE="javascript">
	function callParent(){
		var formObject = document.form;
		var rArray = getCheckedRows();
		
		// row를 선택하지 않은경우
		if(rArray == null) {
			ComShowCodeMessage("COM12114", "row");
			return;
		}
		// row를 100개이상 선택하고 cancle 버튼을 누른경우
		if(rArray.length == 0) {
			return;
		}
		
		opener.<%=func%>(rArray);
		
		window.close();
	}
	
	function getCheckedRows(colName) {
		var sheetObj = sheetObjects[0];
		var colsCnt = sheetObj.LastCol + 1;
		var rows = sheetObj.Rows;
		var checkRows = sheetObj.CheckedRows("SelChk");
		
		var rArray = null; //행데이터를 담고 있는 배열
		var cArray = null; //열데이터를 담고 있는 배열
		
		var invNos = "";
		
		if(checkRows == 0) {
			return null;
		}
		else if(checkRows > 100) {
			if(ComShowCodeConfirm("INV00078")) {
				var idx = 0;
				invNos = "";
				rArray = new Array();
				
				for(var i = 0; i < rows; i++) {
					if(sheetObj.CellValue(i, "SelChk") == 1) {
						cArray = new Array(colsCnt);
						
						for(var j=0; j<cArray.length; j++) {
							cArray[j] = sheetObj.CellValue(i, j);
						}
						
						if (invNos.indexOf(cArray[2]) == -1) {
							invNos = invNos + cArray[2] + "|" ;
						
							rArray.push(cArray);
						}
					}
				}
			} else {
				rArray = new Array(0);
			}
		}
		else {
			var idx = 0;
			invNos = "";
			rArray = new Array();
			
			for(var i = 0; i < rows; i++) {
				if(sheetObj.CellValue(i, "SelChk") == 1) {
					cArray = new Array(colsCnt);
						
					for(var j=0; j<cArray.length; j++) {
						cArray[j] = sheetObj.CellValue(i, j);
					}
					
					if (invNos.indexOf(cArray[2]) == -1) {
						invNos = invNos + cArray[2] + "|" ;
						
						rArray.push(cArray);
					}
				}
			}
		}
		return rArray;
	}
</SCRIPT>
</html>