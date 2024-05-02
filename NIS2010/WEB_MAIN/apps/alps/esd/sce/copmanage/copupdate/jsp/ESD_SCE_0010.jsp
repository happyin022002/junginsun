<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0010.jsp
*@FileTitle : COP Manual Batch Update
*Open Issues :
*Change history :
    요건 및 UI 변경에 따른 수정
*@LastModifyDate : 2006-10-19
*@LastModifier : Seong-mun Kang
*@LastVersion : 1.0
* 2006-10-02 Seong-mun Kang
* 1.0 최초생성
=========================================================*/ 
--%>

<%@ page import="com.hanjin.apps.alps.esd.sce.copmanage.copupdate.event.ESD_SCE_0010EventResponse" %>
<%@ page import="com.hanjin.apps.alps.esd.sce.common.util.basic.RequestDataSetBC" %>

<%
	ESD_SCE_0010EventResponse eventResponse = (ESD_SCE_0010EventResponse)request.getAttribute("EventResponse");
	RequestDataSetBC         dataSet       = eventResponse.getDataSet() ;
%>

<html>
<head>
<title>Welcome to enis!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<body> 
<!-- OUTER - POPUP (S)tart -->
<table width="600" class="popup" cellpadding="10" border="0"> 
<form name="form" method="post">
<input type="hidden" name="f_cmd">
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="580" border="0">
		<tr><td class="title"><img src="/hanjin/img/enis/ico_t1.gif" width="20" height="12">COP Update - Batch Update</td></tr>
		</table>
		
		<!-- TABLE '#D' : ( Search Options : Speed ) (S) -->
     	<table class="search"> 
       	<tr><td class="bg_a">
				
				
				<table class="search" border="0" style="width:670;">
				<tr class="h23">
					<td><img class="star">Current Activity </td>
					<td colspan="3"><select name="cop_value" onChange="" style="width:410">
<%	String[] dataSetKeyArr   = null ;
	String[] dataSetValueArr = null ;
	String   actCd           = null ;
	String   actNm           = null ;
	String   nodCd           = null ;
	for(int i=0; i<dataSet.getSize(); i++){
		dataSetKeyArr   = dataSet.getName(i).split("_") ;
		dataSetValueArr = dataSet.getString(dataSet.getName(i)).split("#") ;
		actCd = dataSetKeyArr[0] ;
		nodCd = dataSetKeyArr[1] ;
		actNm = dataSetValueArr[0] ;
		//System.out.println("data : " + dataSetValueArr[1]);
	 
%>					
							<option value="<%=dataSetValueArr[1]%>">[<%=actCd%>] <%=actNm%> (<%=nodCd%>)</option>
<%	}%>							
							</select></td>
				</tr>
				<tr class="h23">
					<td width="22%"><input type="radio" name="estm_act_dt" value="E" class="trans">Estimated Date/Time</td>
					<td width="30%">&nbsp;<input type="text" style="width:70; text-transform:uppercase;" value="" name="estm_date">&nbsp;<img class="cursor" src="/hanjin/img/enis/button/btns_calendar.gif" width="19" height="20" border="0" name="btns_calendar1" align="absmiddle">
								<select name="estm_hour">
<%	String dateValue = null ;
	for(int i=0; i<24; i++){
		dateValue = i<10 ? "0"+i : i+"" ;	
%>
									<option value="<%=dateValue%>"><%=dateValue%></option>
<%	}%>									
								</select> : 
								<select name="estm_minute">
<%	for(int i=0; i<60; i++){
		dateValue = i<10 ? "0"+i : i+"" ;	
%>
									<option value="<%=dateValue%>"><%=dateValue%></option>
<%	}%>	
								</select></td>
					<td width="18%"><input type="radio" name="estm_act_dt" value="A" class="trans">Actual Date/Time</td>
					<td width="30%"><input type="text" style="width:70; text-transform:uppercase;" value="" name="act_date">&nbsp;<img class="cursor" src="/hanjin/img/enis/button/btns_calendar.gif" width="19" height="20" border="0" name="btns_calendar2" align="absmiddle">
								<select name="act_hour">
<%	for(int i=0; i<24; i++){
		dateValue = i<10 ? "0"+i : i+"" ;	
%>
									<option value="<%=dateValue%>"><%=dateValue%></option>
<%	}%>									
								</select> : 
								<select name="act_minute">
<%	for(int i=0; i<60; i++){
		dateValue = i<10 ? "0"+i : i+"" ;	
%>
									<option value="<%=dateValue%>"><%=dateValue%></option>
<%	}%>	
								</select></td>
				</tr>
						
					</table>
					
		</td></tr>
		</table>
					
				
		
	
	
</td></tr>
</table> 
<!-- OUTER - POPUP (E)nd -->



<table class="height_10"><tr><td></td></tr></table> 
	
	
<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table class="sbutton">
		<tr><td class="p_bt"><img name="btn_save" class="cursor" src="/hanjin/img/enis/button/btn_save.gif" width="66" height="20" border="0"></td>
		<td class="p_bt"><img class="cursor" src="/hanjin/img/enis/button/btn_close.gif" width="66" height="20" border="0" onClick="self.close()"></td></tr>
		</table>
	
	</td></tr>
</form>	
</table>
<!-- : ( Button : Sub ) (E) -->
			
</body>
</html>


