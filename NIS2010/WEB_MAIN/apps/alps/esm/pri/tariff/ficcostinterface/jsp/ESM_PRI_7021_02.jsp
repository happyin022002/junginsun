<%
/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : ESM_PRI_7021_02.jsp
 *@FileTitle : Cost Table Interface - IHC(Barge/Rail/Truck) Tab
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.05.07
 *@LastModifier : 이은섭
 *@LastVersion : 1.0
 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.event.EsmPri702102Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
    EsmPri702102Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	Logger log = Logger.getLogger("com.hanjin.apps.SCGuideline.SCGuidelineMain");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();

		event = (EsmPri702102Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Cost Table Interface - IHC(Barge/Rail/Truck) Tab</title>
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

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="svc_scp_cd">
<input type="hidden" name="menu_rhq_cd" value="<%=request.getParameter("rhq_cd")%>">
<input type="hidden" name="cd">
<input type="hidden" name="etc1">
<input type="hidden" name="etc2">

<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0">
	<tr><td valign="top">
		
		<table class="search">
       	<tr><td class="bg">
		
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_down_excel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>		
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_opn_trf">Open Creation</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>			
			</tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->
    	
    	<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
	
		<!--biz page (S)-->
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width: 979;"> 
					<tr class="h23">
						<td width="60">In/Out</td>
						<td width="130"><script language="javascript">ComComboObject('org_dest_tp_cd', 1, 100, 1, 1, 0, false);</script></td>	
	                    <td width="65">Country</td>
	                    <td width="100">
	                       <nobr>
	                       	<input type="text" name="cntCd" id="cntCd" style="width:50;text-align:left;ime-mode:disabled" class="input" onpaste="DoPaste()" onKeyPress="ComKeyOnlyAlphabet('upper','44')"><img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_ctryPopup">
	                       </nobr>
	                    </td>
	                    <td width="100">Service Scope</td>
						<td width="" style="padding-left:2px;"><script language="javascript">ComComboObject("svcScpCd", 2, 80, 0, 0, 0, false);</script>
						&nbsp;<input name="svc_scp_nm" type="text" style="width:320;"  value="" class="input2" caption="Service Scope" readonly></td>
					</tr>
				</table>	
				
			  	<div id="flagLayer1" style="display:none">   
				<table>
					<tr>
					    <td width="">Menu</td>
						<td width=""><script language="javascript">ComComboObject('rhq_cd', 1, 80, 1, 0, 0, false);</script></td>
					</tr>	
				</table>
				</div>
				<!--  biz_1   (E) -->
				</td></tr>
			</table>	
			<table class="search">
				<tr>
					<td class="bg">
					<!-- : ( Grid ) (S) -->
					<table width="100%" id="mainTable">
						<tr>
							<td width="100%"><script language="javascript">ComSheetObject('sheet3');</script>
							</td>
						</tr>
					</table>
					<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
					     <tr><td class="btn2_bg">
					         <table border="0" cellpadding="0" cellspacing="0">
					         <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					                 <tr><td class="btn2_left"></td>
					                 <td class="btn2" name="btn_copy_scope" id="btn_copy_scope">Copy to other service scope</td>
					                 <td class="btn2_right"></td>
					                 </tr>
					             </table></td> 
  
					             <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					                 <tr><td class="btn2_left"></td>
					                 <td class="btn2" name="btn_costIf" id="btn_costIf">Cost I/F</td>
					                 <td class="btn2_right"></td>
					                 </tr>
					             </table></td>
					         </tr>
					         </table>
					     </td></tr>
					</table>
					<!-- : ( Grid ) (E) --> 
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>	
</form>
</body>
</html>