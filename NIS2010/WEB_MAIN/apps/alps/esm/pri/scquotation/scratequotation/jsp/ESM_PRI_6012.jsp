<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_6012.jsp
*@FileTitle : S/C Quotation - Rate Adjust
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.19
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.08.19 송민석
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
<%@ page import="com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.event.EsmPri6012Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%
	EsmPri6012Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.SCQuotation.SCRateQuotation");
	
	String cust_cnt_cd=null;
	String cust_seq=null;
	String qttn_no=null;
	String qttn_ver_no=null;
	String gen_spcl_rt_tp_cd=null;
	String cmdt_hdr_seq=null;
	String creationDate = null;
 
	
	
	
	String[] custName = null;
	String[] currency = null;
	String[] per = null;
	String[] cargo = null;
	String[] receiveTerm = null;
	String[] destTerm = null;
	String[] app = null;
	String[] oriLoc = null;
	String[] destLoc = null;
	String[] oriVia = null;
	String[] destVia = null;
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri6012Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		
		cust_cnt_cd = request.getParameter("cust_cnt_cd");
		cust_seq = request.getParameter("cust_seq");
		qttn_no = request.getParameter("qttn_no");
		qttn_ver_no = request.getParameter("qttn_ver_no");
		gen_spcl_rt_tp_cd = request.getParameter("gen_spcl_rt_tp_cd");
		cmdt_hdr_seq = request.getParameter("cmdt_hdr_seq");
		
		

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		//Customer Name
		List<RsltCdListVO> comboData = (List<RsltCdListVO>)eventResponse.getCustomData("CustomerName");
		custName = PRIUtil.getValueObject2StringArray(comboData,false);
		
		//currency
		comboData = (List<RsltCdListVO>)eventResponse.getCustomData("Currency");
		currency = PRIUtil.getValueObject2StringArray(comboData,false);
		
		//per 
		comboData = (List<RsltCdListVO>)eventResponse.getCustomData("Per");
		per = PRIUtil.getValueObject2StringArray(comboData,false);
		
		//cargo 
		comboData = (List<RsltCdListVO>)eventResponse.getCustomData("Cargo");
		cargo = PRIUtil.getValueObject2StringArray(comboData,false);
		
		// CD02070 SC RECEIVING TERM CODE     	
		comboData = (List<RsltCdListVO>)eventResponse.getCustomData("ReceiveTerm");
		receiveTerm = PRIUtil.getValueObject2StringArray(comboData,false);
		
		// CD02071 SC TRANS TERM CODE     	
		comboData = (List<RsltCdListVO>)eventResponse.getCustomData("DestTerm");
		destTerm = PRIUtil.getValueObject2StringArray(comboData,false);
		
		// CD01706 GRI APPLICATION DIVISION CODE
		comboData = (List<RsltCdListVO>)eventResponse.getCustomData("Application");
		app = PRIUtil.getValueObject2StringArray(comboData,false);
		
		//Creation Date
		RsltCdListVO rsltVO = (RsltCdListVO)eventResponse.getCustomData("CreationDate");
		creationDate = rsltVO.getNm();
		
		
		// Origion
		comboData = (List<RsltCdListVO>)eventResponse.getCustomData("OriLoc");
		oriLoc = PRIUtil.getValueObject2StringArray(comboData,false);

		// Dest
		comboData = (List<RsltCdListVO>)eventResponse.getCustomData("DestLoc");
		destLoc = PRIUtil.getValueObject2StringArray(comboData,false);
		 
		// Ori Via
		comboData = (List<RsltCdListVO>)eventResponse.getCustomData("OriVia");
		oriVia = PRIUtil.getValueObject2StringArray(comboData,false);
		
		// Dest. Via
		comboData = (List<RsltCdListVO>)eventResponse.getCustomData("DestVia");
		destVia = PRIUtil.getValueObject2StringArray(comboData,false);
		 

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>S/C Quotation - Rate Adjust</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	
	var currencyValue = "<%=currency[0]%>";
	var currencyText = "<%=currency[1]%>";
	
	var perValue = "<%=per[0]%>";
	var perText = "<%=per[1]%>";
	
	var cargoValue = "<%=cargo[0]%>";
	var cargoText = "<%=cargo[1]%>";
	
	var receiveTermValue = "<%=receiveTerm[0]%>";
	var receiveTermText = "<%=receiveTerm[1]%>";
	
	var destTermValue = "<%=destTerm[0]%>";
	var destTermText = "<%=destTerm[1]%>";
 
	var applicationValue = "<%=app[0]%>";
	var applicationText = "<%=app[1]%>";
	
	var oriLocValue = "<%=oriLoc[0]%>";
	var oriLocText = "<%=oriLoc[1]%>";
	var destLocValue = "<%=destLoc[0]%>";
	var destLocText = "<%=destLoc[1]%>";
	var oriViaValue = "<%=oriVia[0]%>";
	var oriViaText = "<%=oriVia[1]%>";
	var destViaValue = "<%=destVia[0]%>";
	var destViaText = "<%=destVia[1]%>";
	
		
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
<input type="hidden" name="gen_spcl_rt_tp_cd" value="<%=gen_spcl_rt_tp_cd%>">
<input type="hidden" name="cmdt_hdr_seq_____" value="<%=cmdt_hdr_seq%>">


<!-- OUTER - POPUP (S)tart -->
<table width="900" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;S/C Quotation- Rate Adjust</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			
			
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="90">Quotation No.</td>
					<td width="100"><input type="text" style="width:80;" class="input2" value="<%=qttn_no%>" name="qttn_no"></td>
					<td width="50">Ver. No.</td>
					<td width="60"><input type="text" style="width:40;" class="input2" value="<%=qttn_ver_no%>" name="qttn_ver_no"></td> 
					<td width="50">Customer</td>
					<td width="330"><input type="text" style="width:30;" class="input2" value="<%=cust_cnt_cd %>" name="cust_cnt_cd">&nbsp;<input type="text" style="width:50;" class="input2" value="<%=cust_seq %>" name="cust_seq">&nbsp;<input type="text" style="width:220;" class="input2" value="<%=custName[1]%>" name="cust_nm"></td>
					<td width="92">Creation Date</td>
					<td width=""><input type="text" style="width:80;" class="input2" value="<%=creationDate %>"></td>
				</tr>
				</table>
				
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
				
				
				<!-- : ( Grid ) (S) -->
				<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table> 
				<!-- : ( Grid ) (E) -->	
				<table class="height_8"><tr><td></td></tr></table>
				<table class="search" border="0">
				
				<tr><td class="title_h"></td>
					<td class="title_s" width="150">Rate Adjust</td>
					<td>
						<table class="search"  bgcolor="E9E9E9" border="0" style="width:200;"> 
							<tr class="h23">
								<td width="50">&nbsp;&nbsp;&nbsp;Unit</td>
								<td class="stm"><input type="radio" value="AMT" class="trans" name="rate_adjust" checked >Per Type&nbsp;&nbsp;&nbsp;<input type="radio" value="PCT" class="trans" name="rate_adjust">%</td>
							</tr>	
						</table>
					</td>
				</tr>
				</table>
				<table class="search">
					<tr>
						<td width="530" valign="top">
						<!--grid (s)-->
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet2');</script>
								</td>
							</tr>
						</table> 
						<!--grid(E)-->
						<!--grid button (S)-->
				<table width="100%" class="button"> 
	       			<tr><td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Add">Row&nbsp;Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>	
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Copy">Row&nbsp;Copy</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>	
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Delete">Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>					
					</tr></table>
				</td></tr></table>
				<!--grid button (E)-->	
						
						</td>
						<td width="49" align="center"><img src="img/btn_add.gif" width="26" height="26" alt="" border="0" align="absmiddle">&nbsp;</td>	
						<td width="" valign="top">
						
						<!--grid (s)-->
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet3');</script>
								</td>
							</tr>
						</table> 
						<!--grid(E)-->
						<!--grid button (S)-->
				<table width="100%" class="button"> 
	       			<tr><td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn1_Add">Row&nbsp;Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>	
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn1_Copy">Row&nbsp;Copy</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>	
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn1_Delete">Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>					
					</tr></table>
				</td></tr></table>
				<!--grid button (E)-->	
						
						</td>
					</tr>
				
				</table>
		
		
			
		</td></tr></table>
		
		<!--biz page (E)--> 

</td></tr></table>

<table class="height_5"><tr><td></td></tr></table>
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

    	<!--Button (S) -->	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
			<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_OK">OK</td>
					<td class="btn1_right"></td></tr></table></td>
					<td class="btn1_line"></td>
				    <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Close">Close</td>
					<td class="btn1_right"></td></tr></table></td>
			</tr>
		</table></td>
			</tr>
		</table>
    	<!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
			
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>