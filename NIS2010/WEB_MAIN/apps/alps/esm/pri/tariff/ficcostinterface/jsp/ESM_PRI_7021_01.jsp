<%
/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_PRI_7021_01.jsp
 *@FileTitle : Cost Table Interface - Add-on(Ocean Feeder) Tab
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.05.07
 *@LastModifier : 이은섭
 *@LastVersion : 1.0
 =========================================================
 * History                                      
 * 2012.10.30 서미진 [CHM-201220395] Add-on management T/F Project                                          
 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.event.EsmPri702101Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
    EsmPri702101Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.hanjin.apps.SCGuideline.SCGuidelineMain");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmPri702101Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Cost Table Interface - Add-on(Ocean Feeder) Tab</title>
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
<input type="hidden" name="cd" value="<%=request.getParameter("rhq_cd")%>">
<input type="hidden" name="etc1">
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
						<td width="50">In/Out</td>
						<td width="110"><script language="javascript">ComComboObject('org_dest_tp_cd', 1, 100, 1, 1, 0, false);</script></td>
						<td width="90">Service Scope</td>
						<td width="600" style="padding-left:2px;"><script language="javascript">ComComboObject("svcScpCd", 2, 80, 0, 0, 0, false);</script>
						&nbsp;<input name="svc_scp_nm" type="text" style="width:330;"  value="" class="input2" caption="Service Scope" readonly></td>
					</tr>
				</table>
				
				<div id="flagLayer1" style="display:none">   
				<table>
					<tr>
					    <td width="">RHQ_CD</td>
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
							<td width="100%"><script language="javascript">ComSheetObject('sheet2');</script>
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
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>