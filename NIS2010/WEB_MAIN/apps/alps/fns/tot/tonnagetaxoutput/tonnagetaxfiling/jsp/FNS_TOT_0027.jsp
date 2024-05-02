<%/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : FNS_TOT_0027.jsp
*@FileTitle : Summary Creation - Batch
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.16
*@LastModifier : 이병훈
*@LastVersion : 1.0
* 2010.12.16 이병훈
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxfiling.event.FnsTot0027Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsTot0027Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	Logger log = Logger.getLogger("com.hanjin.apps.TonnageTaxOutput.TonnageTaxStandardProfitConclusion");
	String year = JSPUtil.getKST("yyyy");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

		event = (FnsTot0027Event)request.getAttribute("Event");
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
<title>TOT</title>
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
<input type="hidden" name="bat_itm_nm">

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
		<table class="search"> 
       	<tr><td class="bg">
				
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="80">Batch Period</td>
					<td width=""><input type="text" style="width:40;text-align:center" class="input1" name="batch_year" maxlength="4" value="<%=year%>" onkeyup="onlyYearInput(event);" dataformat="yyyy" caption="Batch Period" >&nbsp;<img class="cursor" src="img/btns_back.gif" width="19" height="20" border="0" align="absmiddle" name = "btns_back" >&nbsp;<img class="cursor" src="img/btns_next.gif" width="19" height="20" border="0" align="absmiddle" name = "btns_next"></td>
					
					<td width="90">Starting Date</td>
					<td width="270"><input type="text" name= "st_date" dataformat="ymd" style="width:80" class="input1" >&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="btn_Calendar" width="19" height="20" border="0" align="absmiddle">&nbsp;
					    <select style="width:45;" name="st_date_hh" class="input1">&nbsp;
				        <option value="">HH</option>
					    <% for(int h = 1; h<25; h++){ %>
							<option value="<%if(h<10)%>0<%=h%>"><%if(h<10)%>0<%=h%></option>
	                    <% } %> 
						</select>
						<select style="width:45;" name="st_date_mm" class="input1">&nbsp;
				        <option value="">MM</option>
				   	 	<% for(int m = 0; m<60; m++){ %>
						<option value="<%if(m<10)%>0<%=m%>"><%if(m<10)%>0<%=m%></option>
                   		 <% } %> 
						</select>
						</td>
				</tr> 
				<tr class="h23">
					<td width="80">Run the Job</td>
					<td width="120" style="padding-left:2">
					<script language="javascript">ComComboObject('run_job',2,130,1,1);</script>
					</td>
					<td width="80">Item</td>
					<td width="270" style="padding-left:2">
					<script language="javascript">ComComboObject('bat_id',2,150,1,1);</script>
					</td>
				</tr> 

				</table>	

			
			</td></tr>
		</table>
	<!--biz page (E)-->

	
	

	<!--biz page (S)-->
		
		<table class="height_8"><tr><td colspan="8"></td></tr></table>
	<!--biz page (E)-->    
	<table class="search"> 
       	<tr><td class="bg">	
       	<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="45"> Period</td>
					<td>
						<input type="text" style="width:40;" class="input1" name="search_year" value="<%=year%>" maxlength="4" onkeyup="onlyYearInput(event);" dataformat="yyyy" caption="Period">
						<img src="img/btns_back.gif" name="btns_back2" width="19" height="20" border="0" align="absmiddle">&nbsp;<img src="img/btns_next.gif" name="btns_next2" width="19" height="20" border="0" align="absmiddle">
					</td>
				</tr> 
				</table>		
			<!-- Grid  (S) -->
			<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
			</table>
			<!-- Grid (E) -->
		
			</td></tr>
	</table>
	
	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr>
		<td  align="left"">
	
	
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:0;"> 
       	<tr><td>
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Submit">Submit</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>

			
		</td></tr>
		</table>
	</td></tr>
    </table>	
    <!--Button (E) -->
    </td>
    <td>
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:0;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
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
					<td class="btn1" name="btn_Cancel">Cancel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>		
		</td></tr>
		</table>
	</td></tr>
    </table>	
	</td></tr>
</table>
<!-- 개발자 작업  끝 -->
</td></tr>
</table>
</form>
</body>
<%@include file="/bizcommon/include/common_nis2010.jsp"%>
</html>