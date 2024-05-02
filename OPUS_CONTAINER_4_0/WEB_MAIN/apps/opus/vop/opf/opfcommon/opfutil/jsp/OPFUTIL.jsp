<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : opfutil.jsp
*@FileTitle : OpfUtil Common
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2009.05.26 장석현
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.opf.opfcommon.opfutil.event.OpfutilEvent"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	OpfutilEvent  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.OpfCommon.OpfUtil");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (OpfutilEvent)request.getAttribute("Event");
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
<title>OpfUtil Common</title>
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

<%
/*=========================================================
	예약어			예제)

	* Mappign
	$Author		:	"Jang Suk Hyun"
	$Create_Dt	:	"Jang Suk Hyun"
	$Ui_Nm		:	"VOP_OPF_0007"
	$GSys_nm	:	"com.clt.apps.opus"
	$Sys_Nm		:	"vop"
	$Sub_Nm		:	"opf"
	$Sc_Nm		:	"VesselOperationSupportMgt"
	$Bc_Nm		:	"TerminalInformationMgt"
	$Sc_Dir		:	$Sc_Nm.toLowerCase()
	$Bc_Dir		:	$Sc_Nm.toLowerCase()
	$ActionNm	:	$Ui_Nm + "HTMLAction"
	$EventNm	:	replace($Ui_Nm, "_", "") + "Event"
	
	<!-- Jang Suk Hyun : 2009-05-25 start -->
	<url-mapping url="VOP_OPF_0007.do" screen="VOP_OPF_0007.screen" >
        <web-action-class>com.clt.apps.opus.vop.opf.vesseloperationsupportmgt.terminalinformationmgt.event.VOP_OPF_0007HTMLAction</web-action-class>
    </url-mapping>

    <url-mapping url="VOP_OPF_0007GS.do" screen="com.clt.framework.core.controller.DefaultViewAdapter" >
        <web-action-class>com.clt.apps.opus.vop.opf.vesseloperationsupportmgt.terminalinformationmgt.event.VOP_OPF_0007HTMLAction</web-action-class>
    </url-mapping>

    <event-mapping>
        <event-class>com.clt.apps.opus.vop.opf.vesseloperationsupportmgt.terminalinformationmgt.event.VopOpf0007Event</event-class>
        <service-action-class>com.clt.apps.opus.vop.opf.vesseloperationsupportmgt.VesselOperationSupportMgtSC</service-action-class>
    </event-mapping>
	<!-- Jang Suk Hyun : 2009-05-25 end -->

	* Screen
	$Title_Nm	:	"Terminal Information"
	$Ui_NmLower :	$Ui_Nm.toLowerCase() + ".jsp"

    <screen name="VOP_OPF_0007">
        <parameter key="title"    value="Terminal Information" direct="true"/>
        <parameter key="body"     value="apps/opus/vop/opf/vesseloperationsupportmgt/terminalinformationmgt/jsp/vop_opf_0007.jsp"/>
    </screen>

	필요 함수	:	ComReplaceStr
=========================================================*/
%>
<!--  -->
<div style="display:none;">
<TEXTAREA NAME="mappingData" style="width:100%;height:150">
	<!-- $Author : $Create_Dt Start -->
    <url-mapping url="$Ui_Nm.do" screen="$Ui_Nm.screen" >
        <web-action-class>$GSys_nm.$Sys_Nm.$Sub_Nm.$Sc_Dir.$Bc_dir.event.$ActionNm</web-action-class>
    </url-mapping>

    <url-mapping url="$Ui_NmGS.do" screen="com.clt.framework.core.controller.DefaultViewAdapter" >
        <web-action-class>$GSys_nm.$Sys_Nm.$Sub_Nm.$Sc_Dir.$Bc_dir.event.$ActionNm</web-action-class>
    </url-mapping>

    <event-mapping>
        <event-class>$GSys_nm.$Sys_Nm.$Sub_Nm.$Sc_Dir.$Bc_dir.event.$EventNm</event-class>
        <service-action-class>$GSys_nm.$Sys_Nm.$Sub_Nm.$Sc_Dir.$Sc_NmSC</service-action-class>
    </event-mapping>
	<!-- $Author : $Create_Dt End -->
</TEXTAREA>
<TEXTAREA NAME="screenData" style="width:100%;height:150">
	<!-- $Author : $Create_Dt Start -->
    <screen name="$Ui_Nm">
        <parameter key="title"    value="$Title_Nm" direct="true"/>
        <parameter key="body"     value="$GSys_nm/$Sys_Nm/$Sub_Nm/$Sc_Dir/$Bc_dir/jsp/$Jsp_Nm"/>
    </screen>
	<!-- $Author : $Create_Dt End -->
</TEXTAREA>
</div>


<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	
	
	
		<!--Page Title, Historical (S)-->
		
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->

		<!-- Tab (S) -->
 		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%>
   		<tr><td width="100%">
				<script language="javascript">ComTabObject('tab1')</script>
				<!-- img src="img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
			</td></tr>
		</table>
		<!-- Tab (E) -->

<div id="tabLayer" style="display:inline">
		<!--biz page (S)-->
		<table class="search" id="mainTable">
       		<tr><td class="bg">

				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="125">Group Sys</td>
					<td width="130"><input type="text" style="width:150;" class="input1" name="gsys_nm" maxlength="100" caption="Port Code" value="com.clt.apps.opus">&nbsp;</td>
					<td width="10"></td>
					<td width="50">Sys</td>
					<td width="130"><input type="text" style="width:50;" class="input1" name="sys_nm" maxlength="10" caption="Port Code" value="vop">&nbsp;</td>
					<td width="10"></td>
					<td width="50">Sub Sys</td>
					<td width="130"><input type="text" style="width:50;" class="input1" name="sub_nm" maxlength="10" caption="Port Code" value="opf">&nbsp;</td>
					<td>&nbsp;</td>
					</tr>
				</table>
				<!--  biz_1   (E) -->

		</td></tr></table>
		<table class="height_8"><tr><td></td></tr></table>

		<table class="search" id="mainTable">
       		<tr><td class="bg">
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t1sheet1');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->
			<!--  Button_Sub (S) -->
			<table width="100%" class="button">
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_t1LoadExcel">Load Excel</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>

					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_t1Generater">XML Generater</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>

					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_t1CopyMapping">Mapping Copy</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>

					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_t1CopyScreen">Screen Copy</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>

					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_t1RowInsert">Row Insert</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>

					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_t1Delete">Row Delete</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>

			</td></tr>
			</table>
			<!--  Button_Sub (E) -->
			<table class="height_8"><tr><td></td></tr></table>
			<table border="0" style="width:100%; background-color:white;" class="grid2">
			<tr class="tr_head2"></tr>
				<td width="15%" class="tr2_head" rowspan="2"> Mapping	</td>
				<td width="%" rowspan="2"> <textarea style="width:100%;height:60" name="map_rmk"></textarea></td>
 				</tr>
			</table>
			<table class="height_8"><tr><td></td></tr></table>
			<table border="0" style="width:100%; background-color:white;" class="grid2">
			<tr class="tr_head2"></tr>
				<td width="15%" class="tr2_head" rowspan="2"> Screen	</td>
				<td width="%" rowspan="2"> <textarea style="width:100%;height:60" name="screen_rmk"></textarea></td>
 				</tr>
			</table>



			</td></tr>
		</table>
</div>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>