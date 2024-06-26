<%
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : FNS_JOO_0083.jsp
*@FileTitle : Office Mapping Management
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.16
*@LastModifier : 원종규
*@LastVersion : 1.0
* 2010.11.16 원종규
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
<%@ page import="com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.event.FnsJoo0083Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsJoo0083Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd        = "";
	String strRhq_ofc_cd    = "";	
	Logger log = Logger.getLogger("com.hanjin.apps.JointOperationMasterDataMgt.JointOperationMasterDataMgt");
	
	String sysdate = JSPUtil.getKST("yyyy-MM-dd");

	String offList = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		strRhq_ofc_cd = account.getRhq_ofc_cd();
		
		event = (FnsJoo0083Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		offList    	 = eventResponse.getETCData("office");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Office Mapping Management</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
var gOffList   = "<%=offList%>";
var gUserId	   = "<%=strUsr_id%>";
var gUserOfcCd = "<%=strOfc_cd%>";
var gUserRhqOfcCd = "<%=strRhq_ofc_cd%>";
var gSysDate 	= "<%=sysdate%>";
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
			<tr><td class="title"><img src="img/icon_title_dot.gif" width="9" height="9" alt="" border="0">&nbsp;Office Mapping Management</td></tr>
		</table>
	<!--Page Title, Historical (E)-->	
	<!--biz page (S)-->
	
	    <!-- Grid BG Box  (S) -->
		<table class="search"> 
       	<tr><td class="bg">			
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
				
					<td width="75">Log in RHQ</td>
					<!-- ComComboObject(comboid, iColCnt, iWidth , iStyle, iCss, iShowCol, iEdit, iTab, iUseCode) -->
					<td width=""><script language="javascript">ComComboObject('ofc_cd_rhq', 1, 80, 0, 0,0 );</script></td>
					<td width="70">Log in OFC</td>
					<td width="160"><input type="text" style="width:70;" class="input" value="" name="ofc_cd" dataformat="engup">
					<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absbottom" name="btn_pop_ofc_cd"></td>
					<td width="60">JOO RHQ</td>
					<td width=""><script language="javascript">ComComboObject('cng_ofc_rhq', 1, 80, 0, 0,0 );</script></td>
					<td width="60">JOO OFC</td>
					<td width="150"><input type="text" style="width:70;" class="input" value="" name="cng_ofc_cd" dataformat="engup">
					<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absbottom" name="btn_pop_cng_ofc_cd"></td>
					<td width="40">Delete</td>
					<td width=""><select style="width:80;" class="input" name="delt_flg">
							<option value="N" selected>NO</option>
							<option value="Y" >YES</option>
							<option value="A" >ALL</option>
							</select></td>
				</tr>	
				</table>
			</td></tr>
			</table>
			<table class="height_10"><tr><td colspan="8"></td></tr></table>
		
		<!-- Grid BG Box  (S) -->
     	<table class="search" id="mainTable"> 
       	<tr><td class="bg">
       	
       	<table class="search" border="0" style="width:979;"> 
          <tr class="h23">
            <td>                     
			<!-- Grid  (S) -->
			<table width="100%"  id="mainTable"> 
                            <tr>
                                <td width="100%">
                                     <script language="javascript">ComSheetObject('sheet1');</script> 
                                </td>
                            </tr>
            </table>  
			<!-- Grid (E) -->
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr>
	       		<td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_add" id="btn_add" auth="C">Row&nbsp;Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_insert" id="btn_insert">Row Insert</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_delete" id="btn_delete" auth="C">Row Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
	    	</td></tr>
			</table>
			
		</td></tr>
		</table>
		
	<!-- Grid BG Box  (E) -->
	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_retrieve" auth="R">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new" id="btn_new" auth="R">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save" id="btn_save" auth="C">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DownExcel" id="btn_downexcel" auth="R">Downexcel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	<!--biz page (E)-->	
	</td></tr>
	</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>