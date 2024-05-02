<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_1144.jsp
*@FileTitle : Pool Chassis M&R Performance
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.08.13 최민회
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
<%@ page import="com.hanjin.apps.alps.ees.cgm.movementmnrhistory.poolchassishistory.event.EesCgm1144Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@page import="com.hanjin.framework.component.util.io.HttpUtil"%>
<%
	EesCgm1144Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.MovementMnrHistory.PoolChassisHistory");
	String xml = HttpUtil.makeXML(request,response);
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesCgm1144Event)request.getAttribute("Event");
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
<title>Pool Chassis M&R Performance</title>
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

<body  onLoad="setupPage();" onkeyup="ComKeyEnter('search');">
<form name="form2">
<input type="hidden" name="sXml" value="<%=xml.replace("\"","'")%>">
</form>
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->
	
	
		<!--biz page (S)-->
		<!-- 1 (S) -->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="50">Pool</td>
					<td width="82" style="padding-left:2;"><script language="javascript">ComComboObject('chss_pool_cd', 1, 150, 0, 1, 1);</script></td>
					<td width="370"><input type="text" style="width:339" class="input2" name="chss_pool_nm" readonly="readonly"></td>
					<td width="50">&nbsp;MGMT</td>
					<td width=""><input type="text" style="width:100%" class="input2" name="pool_mgmt_co_nm" readonly="readonly"> </td>
				</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
                <tr class="h23">
					<td  width="50">Sort by</td>
 					<td width=" 221"><select style="width:150;" class="input1" onchange="sort_OnChange()" name="sort">
										<option value="0"selected>Invoice Month</option>
										<option value="1" >Repair Request Date</option>
									</select>
				    </td>
				    <td width="">Period
				     &nbsp;<input type="text" style="width:80;text-align:center;ime-mode:disabled" dataformat="ym" name='mvmt_dt_fr' class="input1" value="" maxlength='6'>
		            <img name="btns_Calendar1" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
                              ~
                     <input type="text" style="width:80;text-align:center;ime-mode:disabled" dataformat="ym" name='mvmt_dt_to'class="input1" value="" maxlength='6'>
                              <img name="btns_Calendar2" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
                             <td width=""></td>
                             <td width=""></td>
				</tr> 
				</table>
				<!--  biz_1   (E) -->
				<table class="height_8"><tr><td></td></tr></table>	
				<!-- Grid - 1 (S) -->
			<table width="100%" class="grid2"> 
			<tr class="tr2_head">
				<td width="%">	</td>
				<td width="12%">Cases/Units	</td>
				<td width="12%">Labor Total			</td>
				<td width="12%">Material Total			</td>
				<td width="12%">Tax Total		</td>
				<td width="12%">Total Amount	</td>
				<td width="12%">Unit Cost	</td>
			</tr>
			<tr class="input" align="right">
				<td class="tr_head2" align="center">Chassis Repair Cases			</td>
				<td><input type="text" name="chss_cnt" style="width:120;text-align:right"class="noinput" value="" readonly="readonly" dataformat="int"></td>
				<td><input type="text" name="chss_lbr" style="width:120;text-align:right"class="noinput" value="" readonly="readonly" dataformat="int"></td>
				<td><input type="text" name="chss_mtrl" style="width:120;text-align:right"class="noinput" value="" readonly="readonly" dataformat="int"></td>
				<td><input type="text" name="chss_amt" style="width:120;text-align:right"class="noinput" value="" readonly="readonly" dataformat="int"></td>
				<td><input type="text" name="chss_ttl" style="width:120;text-align:right"class="noinput" value="" readonly="readonly" dataformat="int"></td>
				<td><input type="text" name="chss_cost" style="width:120;text-align:right"class="noinput" value="" readonly="readonly" dataformat="int"></td>
			</tr>
			<tr class="input" align="right">
				<td class="tr_head2" align="center">Repaired Chassis Units	</td>
				<td><input type="text" name="un_chss_cnt" style="width:120;text-align:right"class="noinput" value="" readonly="readonly"></td>
				<td><input type="text" name="un_chss_lbr" style="width:120;text-align:right"class="noinput" value="" readonly="readonly"></td>
				<td><input type="text" name="un_chss_mtrl" style="width:120;text-align:right"class="noinput" value="" readonly="readonly"></td>
				<td><input type="text" name="un_chss_amt" style="width:120;text-align:right"class="noinput" value="" readonly="readonly"></td>
				<td><input type="text" name="un_chss_ttl" style="width:120;text-align:right"class="noinput" value="" readonly="readonly"></td>
				<td><input type="text" name="un_chss_cost" style="width:120;text-align:right"class="noinput" value="" readonly="readonly"></td>
			</tr>
			</table>
			<!-- Grid - 1 (E) -->
		</td></tr></table>
		<!-- 1 (E) -->
		
		
		<!-- 2 (S) -->
		<table class="height_8"><tr><td></td></tr></table>	
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	

			
			
			<!-- Grid - 1 (S) -->
			<table width="100%" id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table>
			<!-- Grid - 1 (E) -->	
			
		
			
			</td></tr>
		</table>
		<!-- 2 (E) -->
		<!--biz page (E)-->


		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve"  ID ="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
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
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->
	
	</td></tr>
		</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>