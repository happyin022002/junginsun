<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_lse_0032.jsp
*@FileTitle : OW/LP/OL Auth creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.18
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2009.06.18 진준성
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
<%@ page import="com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.event.EesLse0032Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesLse0032Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.ContainerLeaseMgt.OnhireApproval");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesLse0032Event)request.getAttribute("Event");
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
<title>OW/LP/OL Auth creation</title>
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
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:;,padding-bottom:2;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
		      <td>
		        <table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table>
			  </td>				
		    </tr>
		    </table>
  
	  </td></tr>
     </table>
       <!--Button (E) -->
		<table class="search"> 
       		<tr><td class="bg" style="height:516" valign="top">
				<!--  biz_1  (S) -->
				<table class="search" border="0" bordercolor="red" style="width:979;"> 
				<tr class="h23">
					<td width="90">On Hire LOC</td>
					<td width="53">
					   <select name="loc_tp" style="width:51">
						<option value="R" >RCC</option>
						<option value="L">LCC</option>								 
					  </select>
					</td>		
					<td width="">
					    <input type="text" style="width:45;ime-mode:disabled" name="loc_cd"  value="" class="input1"  dataformat="engup" maxlength="5" fullfill>&nbsp;<img class="cursor" name="btns_search1" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
					</td>		
				</tr> 
				</table>				
				<table class="height_8"><tr><td></td></tr></table>
				<!--  biz_1  (E) -->	
				<!-- Grid  (S) -->
					<table width="100%"  id="mainTable" border="0" cellpadding="0" cellspacing="0"> 
						<tr>
							<td width="100%">
							<!--?트-->
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
				<!-- Grid  (E) -->		
				<!-- Grid  (S) -->
				<div style="display:none;">
					<table width="100%"  id="mainTable" border="0" cellpadding="0" cellspacing="0"> 
						<tr>
							<td width="100%">
							<!--?트-->
								<script language="javascript">ComSheetObject('sheet2');</script>
							</td>
						</tr>
					</table>
				</div>
				<!-- Grid  (E) -->			
				<!-- : ( Search Options ) (E) -->
 				<!--  Button_Sub (S) -->			
	    		<!-- Button_Sub (E) -->			
			</td>
		  </tr>
		</table>
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->
    
	</td></tr>
</table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>