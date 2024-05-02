<%
/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ees_cim_1061.jsp
*@FileTitle : Location M/B by COA BKG
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.17
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2011.03.17 박명신
* 1.0 Creation	
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%> 
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.event.EesCim1061Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%	
	EesCim1061Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";	
	String pageRows  = "100";	

	String strUsr_id		= "";	
	String strUsr_nm		= "";	
	String strCnt_cd		= "";	
	Logger log = Logger.getLogger("com.hanjin.apps.CNTROperatioNPerformanceMgt.EQMatchBackNLoadFactorMgt");
	String xml = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strCnt_cd = account.getCnt_cd();


		event = (EesCim1061Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		xml = HttpUtil.makeXML(request,response);
	
	}catch(Exception e) {	
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Welcome to nis2010!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if		
		loadPage();	
		document.form.froms.focus();
	}		
</script>
<script language="javascript">ComSheetObject('sheet1');</script> 
</head>
<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="from_dt">
<input type="hidden" name="to_dt">
<input type="hidden" name="usr_id" value="<%=strUsr_id%>">							
<input type="hidden" name="tpsz_list">						
<input type="hidden" name="work_type" value="MBD1">									
<input type="hidden" name="week_list" value="">		
<input type="hidden" name="transmode" value="">							
	
<!-- Report End -->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
       	<tr><td class="btn1_bg">
		
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve"  id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
                <td class="btn1_line"></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_SaveFormat">Save Format</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>	   
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_RecallFormat">Recall Format</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>	 
                
				</tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">	
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="45">Period</td>
					<td width="127"><select style="width:125;" class="input1" name="period" >
						<option value="M" selected>Month(YYYY-MM)</option>
						<option value="W">Week(YYYY-WW)</option>	
						</select></td>
					<td width="250">
					<input type="text" style="width:55;" class="input1" value="" name="froms" caption="FM" required dataformat="ym" maxlength="6">&nbsp;~&nbsp;
					<input type="text" style="width:55;" class="input1" value="" name="tos"   caption="TO" required dataformat="ym" maxlength="6">
					</td>
					<td width="100">Location by</td>
					<td width="150"><img class="cursor" name="btn_loc_cd" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
					</td>	
					<td width="450">			
						<table border="0" style="width:450;" class="search"> 
						<tr class="h23">
							<td width="45">TP/SZ</td>
							<td width="450" style="font-size:12;">		
						<input type="radio" class="trans"  checked name="tpsz" value="D">&nbsp;DRY&nbsp;&nbsp;
						<input type="radio" class="trans"  name="tpsz" value="O">&nbsp;OT&nbsp;&nbsp;
						<input type="radio" class="trans"  name="tpsz" value="F">&nbsp;FR&nbsp;&nbsp;
						<input type="radio" class="trans"  name="tpsz" value="R">&nbsp;Reefer&nbsp;
						<select style="width:100;" class="input" name="rdtype" disabled>	
						<option value="I" selected>Include R/D</option>	
						<option value="E">Exclude R/D</option>	
						<option value="O">Only R/D</option>				
						</select></td>	
						</tr>	
						</table>
					</td>
					</tr>	
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">	
					<td width="45">Trade</td>
					<td width="317">								
					<script language="javascript">ComComboObject('trade_cd', 2, 124 ,0, 1)</script>	
					</td>	
					<td width="76">S.O.C</td>		
					<td width="122"><select style="width:80;" class="input1" name="soc">
						<option value="E" selected>Exclude</option>
						<option value="I">Include</option>	
						<option value="O">Only </option>	
						</select>				
					</td>	
					<td width="">&nbsp;		
					</td>
				</tr> 
				</table>
				<!--  biz_1   (E) -->
				
				</td></tr>
			</table>
			
			<table class="height_10"><tr><td colspan="8"></td></tr></table>
			
			
		<!-- Tab ) (S) -->
     		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%> 
       		<tr><td width="100%">
						<script language="javascript">ComTabObject('tab1')</script>
						<!-- img src="img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
					</td></tr>
				</table>
		<!-- Tab ) (E) --> 		

<!--TAB M/B Detail (S) -->
<div id="tabLayer" style="display:none">

		<!-- Tab BG Box  (S) -->
     	<table class="search"> 
       	<tr><td class="bg">
			 														
			<!-- Grid  (S) -->
			
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">	
							<script language="javascript">ComSheetObject1('t1sheet1');</script>
						</td>	
					</tr>
				</table>			

			<!-- Grid (E) -->
			<!--  Button_Sub (S) -->
	    	<!-- Button_Sub (E) -->
			</td></tr>
		</table>	
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->
</div>
<!--TAB M/B Detail (E) -->  
	
<!--TAB M/B Trend (S) -->
<div id="tabLayer" style="display:none">

		<!-- Tab BG Box  (S) -->
     	<table class="search"> 
       	<tr><td class="bg">
			 															
			<!-- Grid  (S) -->
				
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject1('t2sheet1');</script>
						</td>
					</tr>
				</table>				

			<!-- Grid (E) -->

			<!--  Grid_button (S) -->
			</td></tr>
		</table>
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->

</div>
<!--TAB M/B Trend (E) --> 
<table class="height_10"><tr><td colspan="8"></td></tr></table>
	</td></tr>
</table>
</form>
</body>
</html>
