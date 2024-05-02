<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0001_03.jsp
*@FileTitle : Commodity Group
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.21
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.04.21 공백진
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
<%@ page import="com.hanjin.apps.alps.esm.pri.scguideline.scgroupcommodityguideline.event.EsmPri000103Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri000103Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String[] strCust_nm  = new String[4];
	
	
	//Logger log = Logger.getLogger("com.hanjin.apps.SCGuideline.SCGroupCommodityGuideline");
	java.util.ArrayList<com.hanjin.framework.component.util.code.CodeInfo> custList = null;
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();	   
	   
		event = (EsmPri000103Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		//GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		custList = (java.util.ArrayList<com.hanjin.framework.component.util.code.CodeInfo>)com.hanjin.framework.component.util.code.CodeUtil.getInstance().getCodeSelect("CD01714", 0);
		
		if (custList != null && custList.size() > 0) {
			for (int i = 0; i < custList.size(); i++) {
				com.hanjin.framework.component.util.code.CodeInfo row = custList.get(i);
				strCust_nm[i] = row.getName();				
			}
		}
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Commodity Group</title>
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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- 개발자 작업	-->
<input type="hidden" name="svc_scp_cd" value="">
<input type="hidden" name="gline_seq" value="">
<input type="hidden" name="prc_cust_tp_cd" value="N">
<input type="hidden" name="grp_cmdt_seq" value="">
<input type="hidden" name="cd" value="">
<input type="hidden" name="yn_data" value="N">
<table class="search"> 
	<tr><td class="bg">			
		<!--Button (S) -->
		<table width="100%" border="0" class="button" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DownExcel">Down&nbsp;Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
    		<!--Button (E) -->
					
			<table class="search" width="1000">
				<tr><td>
				<table class="search_sm2">
					<tr class="h23">
						<td width="100">&nbsp;Customer Type</td>
						<td class="stm">
							<input type="radio" name="prc_cust_cd" class="trans" checked><span id="cust_tp1"> <%= strCust_nm[0]%></span>&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="prc_cust_cd"  class="trans"><span id="cust_tp2">  <%= strCust_nm[1]%></span>&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="prc_cust_cd"  class="trans"><span id="cust_tp3">  <%= strCust_nm[2]%></span>&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="prc_cust_cd"  class="trans"><span id="cust_tp4">  <%= strCust_nm[3]%></span>&nbsp;&nbsp;&nbsp;&nbsp;
						</td>				
					</tr>
				</table>
				</td></tr>
			</table>				
					
			 <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				<table class="search">
					<tr>
						<td width="335" valign="top">
						<!--grid (s)-->
							<table width="100%"  id="mainTable"> 
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('sheet1');</script>
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
						<td class="btn2" name="btn_Copy">CMDT Group Copy</a></td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>	
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Add">Row&nbsp;Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>	
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Del">Delete</td>
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
						<td class="btn2" name="btn_Add2">Row&nbsp;Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>	
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Del2">Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>					
					</tr></table>
				</td></tr></table>
				<!--grid button (E)-->	
						</td>
					</tr>				
				</table>
			</td></tr>
		</table>
	
		<table class="height_10"><tr><td colspan="8"></td></tr></table>
		
		<!--grid (s) Excel Download-->
		<div id="sheetHidden" style="display:none">		
		<table width="100%"> 
			<tr>
				<td>
					<script language="javascript">ComSheetObject('sheet3');</script>
				</td>
			</tr>
		</table>
		</div>
		<!--grid(E)-->			
   
	</td></tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>