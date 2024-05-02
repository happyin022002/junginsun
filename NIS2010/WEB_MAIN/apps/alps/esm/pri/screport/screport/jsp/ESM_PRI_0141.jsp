<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESM_PRI_0141.jsp
*@FileTitle : MOT/SSE Tariff 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.25
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2014.04.25 송호진
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
<%@ page import="com.hanjin.apps.alps.esm.pri.screport.screport.event.EsmPri0141Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>

<%
	EsmPri0141Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.SCReport.SCReport");
	
	String[] motOrgBsePortCdList = null;
	
	String[] motFileCntrTpCdList = null;
	String[] motFileCmdtTpCdList = null;
	String[] motFileCntrSzCdList = null;
	/*
	ArrayList<CodeInfo> motFileCntrTpCdList = null;
	ArrayList<CodeInfo> motFileCmdtTpCdList = null;
	ArrayList<CodeInfo> motFileCntrSzCdList = null;
	*/

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri0141Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		motOrgBsePortCdList = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("motOrgBsePortCdList"), false, "|", "\t", "getCd", "getCd");
		
		motFileCntrTpCdList = PRIUtil.getValueObject2StringArray((ArrayList<CodeInfo>)eventResponse.getCustomData("motFileCntrTpCdList"), false, "|", "\t", "getCode", "getName" );
		motFileCmdtTpCdList = PRIUtil.getValueObject2StringArray((ArrayList<CodeInfo>)eventResponse.getCustomData("motFileCmdtTpCdList"), false, "|", "\t", "getCode", "getName" );
		motFileCntrSzCdList = PRIUtil.getValueObject2StringArray((ArrayList<CodeInfo>)eventResponse.getCustomData("motFileCntrSzCdList"), false, "|", "\t", "getCode", "getName" );

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>MOT/SSE Tariff </title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">

	var motOrgBsePortCdValue = " |<%=motOrgBsePortCdList[0]%>";
	var motOrgBsePortCdText  = " |<%=motOrgBsePortCdList[1]%>";
	
	var motCntrTpCdValue = " |<%=motFileCntrTpCdList[0]%>";
	var motCntrTpCdText  = " |<%=motFileCntrTpCdList[1]%>";
	
	var motCmdtTpCdValue = " |<%=motFileCmdtTpCdList[0]%>";
	var motCmdtTpCdText  = " |<%=motFileCmdtTpCdList[1]%>";
	
	var motCntrSzCdValue = " |<%=motFileCntrSzCdList[0]%>";
	var motCntrSzCdText  = " |<%=motFileCntrSzCdList[1]%>";
	

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

<input type="hidden" name="lane_list">
<input type="hidden" name="inq_tp_cd">
<input type="hidden" name="usr_id" value="<%=strUsr_id%>">
<input type="hidden" name="cfm_dt" value="">

<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	</table>
	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve">Retrieve</td>
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
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_confirm">Confirm</td>
	
				<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_confirmcancel">Confirm&nbsp;Cancel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_delete">Delete</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_loadexcel">Load Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	<!--Page Title, Historical (E)-->
	
	<table class="search" border="0"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				
				<table class="search" border="0" width="100%">
				<tr class="h23">
					<td width="100" colspan="10" >Service Scope</td>
					<td width="340" colspan="34" style="padding-left:2px;"><script language="javascript">ComComboObject("svc_scp_cd", 2, 50, 0, 1, 0, false);</script>
					&nbsp;<input name="svc_scp_nm" type="text" style="width:270;"  value="" class="input2" readonly caption="Service Scope"></td>
					<td width="100" colspan="10" >Effective Date</td>
					<td width="120" colspan="12" style="padding-left:2px;">
					<script language="javascript">ComComboObject("mot_trf_seq", 5, 90, 0, 1, 4, true );</script>
					<input name="eff_dt" type="hidden" value="" class="input1" caption="Effective Date" required>
					<img src="img/btns_calendar.gif" class="cursor" name="btns_calendar" width="19" height="20" alt="" border="0" align="absmiddle" >
					<input name="eff_dt_hidden" type="text" value="" class="input1" style="width:0;height:0" ></td>

					<td width="70" colspan="7" >File Date</td>
					<td width="90" colspan="9" ><input name="file_dt" type="text" style="width:77;"  value="" class="input1" caption="File Date"></td>
					<td width="90" colspan="9" >Confirmation</td>
					<td width="70" colspan="7" ><input name="cfm_flg" type="text" style="width:58;"  value="" class="input2" readonly caption="Confirmation"></td></tr>

				<tr class="h23">
					<td width="100" colspan="10" >Lane Code</td>
					<td width="90" colspan="9" style="padding-left:2px;">
					<script language="javascript">ComComboObject("f_lane_cd", 2, 90, 0, 0, 1, true );</script></td>
					<td width="80" colspan="8" align="center" >CNTR Type</td>
					<td width="90" colspan="9" style="padding-left:2px;">
					<script language="javascript">ComComboObject("f_cntr_tp_cd", 1, 90, 0, 0, 0, true );</script></td>
					<td width="70" colspan="7" align="center" >CNTR Size</td>
					<td width="90" colspan="9" style="padding-left:2px;">
					<script language="javascript">ComComboObject("f_cntr_sz_cd", 1, 90, 0, 0, 0, true );</script></td>
					<td width="80" colspan="8" align="center" >Cargo Type</td>
					<td width="90" colspan="9" style="padding-left:2px;">
					<script language="javascript">ComComboObject("f_cmdt_tp_cd", 1, 90, 0, 0, 0, true );</script></td>
					<td width="50" colspan="5" align="center" >POL</td>
					<td width="90" colspan="9" style="padding-left:2px;">
					<script language="javascript">ComComboObject("f_org_cd", 1, 90, 0, 0, 0, true );</script></td>
					<td width="50" colspan="5" align="center" >POD</td>
					<td width="100" colspan="10" style="padding-left:2px;">
					<script language="javascript">ComComboObject("f_dest_cd", 1, 90, 0, 0, 0, true );</script></td>
					</tr>
				
				</table>
				
				<!--  biz_1   (E) -->
			
			</td>
		</tr>
	</table>
	
 	<table class="height_8"><tr><td colspan="8"></td></tr></table>
 	
	<table class="search"> 
       	<tr><td class="bg">	
       	
	<!-- Hidden sheet for Transaction (S) -->
		<!-- script language="javascript">ComSheetObject('sheet0');</script -->
	<!-- Hidden sheet for Transaction (E) -->
	
				
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
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_add">Row&nbsp;Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_del">Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						
				</table>
			</td></tr>
			</table>
				
			</td></tr>
		</table>
	
		<!--Button (S) -->
		
		
		
    <!--Button (E) -->
	
	<!--biz page (S)-->
		
   
	</td></tr>
</table>

 <table class="height_10"><tr><td colspan="8"></td></tr></table>
				
		</td>				
			</tr>
			</table>



<!-- 개발자 작업  끝 -->
</form>
</body>
</html>