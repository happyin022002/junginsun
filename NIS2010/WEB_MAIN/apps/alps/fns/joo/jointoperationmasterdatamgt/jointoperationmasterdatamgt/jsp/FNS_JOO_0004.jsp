<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_joo_0004.jsp
*@FileTitle : Entry and Inquiry of Basic Port Choose by Settlement Item
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.05.20 박희동
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
<%@ page import="com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.event.FnsJoo0004Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsJoo0004Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strArHqOfcCd     = "";
	Logger log = Logger.getLogger("com.hanjin.apps.JointOperationMasterDataMgt.JointOperationMasterDataMgt");
	
	String crrCombo  = "";
	String abbrCombo = "";
	String dirCombo  = "";
//	String abbrSheet = "";
//	String dirSheet  = "";
//	String staSheet  = "";
	String codeSheet = "";
	String nameSheet = "";
	
	String mnthCondSheet = "";
	String mnthNameSheet = "";
	String portCondSheet = "";
	String portNameSheet = "";
	String portTypeSheet = "";
	String ptTpNameSheet = "";
	String operTypeSheet = "";
	String operNameSheet = "";
	
	String[] dir = null;
//	String[] sta = null;
	String[] tdr = null;
	String[] mnthCond = null;
	String[] portCond = null;
	String[] portType = null;
	String[] operType = null;
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
		event = (FnsJoo0004Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		crrCombo  = eventResponse.getETCData("jo_crr_cd"        );
		abbrCombo = eventResponse.getETCData("jo_stl_cd"        );
		//abbrSheet = eventResponse.getETCData("sheet1_jo_stl_cd" );
		strArHqOfcCd = eventResponse.getETCData("arHqOfcCd");
		

		dir = (String[])eventResponse.getCustomData("DIR");
		//sta = (String[])eventResponse.getCustomData("STA");
		tdr = (String[])eventResponse.getCustomData("TDR");
		mnthCond = (String[])eventResponse.getCustomData("MONTH");
		portCond = (String[])eventResponse.getCustomData("PORT");
		portType = (String[])eventResponse.getCustomData("PORT_TYPE");
		operType = (String[])eventResponse.getCustomData("OPER_TYPE");
		
		dirCombo = dir[0];
		//dirSheet = dir[0];
		//staSheet = sta[0];
		codeSheet = tdr[0];
		nameSheet = tdr[1];
		mnthCondSheet = mnthCond[0];
		mnthNameSheet = mnthCond[1]; 
		portCondSheet = portCond[0];
		portNameSheet = portCond[1];
		portTypeSheet = portType[0];
		ptTpNameSheet = portType[1];
		operTypeSheet = operType[0];
		operNameSheet = operType[1];
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Entry and Inquiry of Basic Port Choose by Settlement Item</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
var gHqOfcCd = "<%=strArHqOfcCd%>";
var gMnthCondSheet = "<%=mnthCondSheet%>";
var gPortCondSheet = "<%=portCondSheet%>";
var gPortTypeSheet = "<%=portTypeSheet%>";
var gOperTypeSheet = "<%=operTypeSheet%>";
var gMnthNameSheet = "<%=mnthNameSheet%>";
var gPortNameSheet = "<%=portNameSheet%>";
var gPtTpNameSheet = "<%=ptTpNameSheet%>";
var gOperNameSheet = "<%=operNameSheet%>";

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage("<%=crrCombo%>","<%=abbrCombo%>","<%=dirCombo%>","<%=codeSheet%>","<%=nameSheet%>");
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="code">
<input type="hidden" name="name">
<input type="hidden" name="super_cd1">
<input type="hidden" name="super_cd2">
<input type="hidden" name="jo_stl_opt_cd">
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
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="45">Carrier</td>
					<td width="120"><script language="javascript">ComComboObject('jo_crr_cd',1,70,0,1,0,false);</script></td>
					<td width="40">Trade</td>
					<td width="120"><script language="javascript">ComComboObject('trd_cd',1,70,0,1);</script></td>
					<td width="35">Lane</td>
					<td width="120"><script language="javascript">ComComboObject('rlane_cd',3,100,0,1);</script></td>
					<td width="35">Item</td>
					<td width="120"><script language="javascript">ComComboObject('jo_stl_itm_cd',1,70,0,0);</script></td>
					<td width="25">Dir</td>
					<td width=""><script language="javascript">ComComboObject('skd_dir_cd',1,70,0,0);</script></td>
					</tr> 
				</table>
				
				<!--  biz_1   (E) -->
				
				</td></tr>
			</table>
			<table class="height_10"><tr><td colspan="8"></td></tr></table>
		
		<!-- Tab BG Box  (S) -->
     	<table class="search"> 
       	<tr><td class="bg">
			
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table> 			
				<!-- 모래시계 보이지 않게 하기 위한 IBSheet -->
				<table width="0%"  id="mainTable"> 
					<tr>
						<td width="0%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table> 			

			<!-- Grid (E) -->
<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_del" id="btn_del" auth="C">Row Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</table>
			</td></tr>
			</table>
			
			</td></tr>
		</table>
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->
	
	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve" id="btn_retrieve" auth="R">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new" id="btn_new" auth="R">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_create" id="btn_create" auth="C">Create</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_copy" id="btn_copy" auth="C">Copy</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save" id="btn_save" auth="C">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel" id="btn_downexcel" auth="R">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			
		</td></tr>
		</table>
    <!--Button (E) -->
	</td></tr>
</table>
<!-- Copyright (S) -->
<!-- Copyright(E)-->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>