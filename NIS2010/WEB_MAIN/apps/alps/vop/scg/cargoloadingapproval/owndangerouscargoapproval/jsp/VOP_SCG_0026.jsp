<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_scg_0026.jsp
*@FileTitle : Undeclared History
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.16
*@LastModifier : 김도현
*@LastVersion : 1.0
* 2015.12.16 김도현
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.event.VopScg0026Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    VopScg0026Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strOfc_cd        = "";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.SpecialCargoMasterDataMgt.SpecialCargoMasterDataMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopScg0026Event)request.getAttribute("Event");
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
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">

	var frDt = ComGetDateAdd('<%=JSPUtil.getKST("yyyy-MM-dd")%>', "M", -2);
	var toDt = ComGetDateAdd('<%=JSPUtil.getKST("yyyy-MM-dd")%>', "M", 0);

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
<input type="hidden" name="tmpym">
<input type="hidden" name="chk_bkg_no">
<input type="hidden" name="content">

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
		<table class="search" id="mainTable"> 
       		<tr><td class="bg" style="height:515;" valign="top">
			
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:640;"> 
				<tr class="h23">
					<td width="37"><B>RSO</B></td>
					<td width="90" style="padding-left:3">
				   		<script language="javascript">ComComboObject('rgn_shp_opr_cd', 3, 74, 1, 1);</script>
					</td>
				
					<td width="100">Request Date</td>
					<td width="220">
						<input type="text" name="rqst_dt_fr" style="width:80; text-align:center;" class="input1" dataformat="ymd" maxlength="8" caption="the from date" value="">&nbsp;~&nbsp;<input type="text" name="rqst_dt_to" style="width:80; text-align:center;" class="input1" dataformat="ymd" maxlength="8" caption="the to date" value="">&nbsp;<img src="img/btns_calendar.gif" id="btns_period" name="btns_period" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
					</td>
					<td width="70">BKG NO.</td>
					<td width="120">
					<input type="text" name="bkg_no"  style="ime-mode:disabled"  dataformat="engup" style="width:100;">&nbsp;</td>
				</tr>
				</table>
				<!--  biz_1   (E) -->
		     
		<table class="line_bluedot"><tr><td></td></tr></table>	
		
		
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
			<table width="100%" class="button" border="0" > 
	       	<tr>
	       	    <td>&nbsp;</td>
				<td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_add">Row Add</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
								
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_del">Row Delete</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_update">File Update</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					</tr>
					</table>
					</td></tr>	
			
					<tr><td width="400">(A) Prohibition Cargo/BKG cancel  <br>
                            (B) Prohibition Cargo/Load as general cargo <br>
                            (C) Prohibition Cargo/Remove Prohibition Cargo<br>
                            (D) Prohibition Cargo/Found after load <br>
                            (E) Un-declared DG/Revise to DG 
                         </td>
                         <td> (F) Un-declared DG/BKG cancel<br>
                              (G) Suspicious Cargo/No Feedback<br>
                               H: High risk (KW I, CL 1, 4.2, 4.3 , 5.1, 5.2)<br>
                               M: Medium risk (CL 2.1 , 3 , 4.1)<br>
                               L: Low risk (CL 2.2, 2.3, 6, 7, 8, 9)</td>
                     </tr>		
			</table>
	    	<!-- Button_Sub (E) -->
			
			
			</td></tr>
		</table>
		<!--biz page (E)-->
	
	</td></tr>
		</table>
	

		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"> 
       	<tr><td class="btn1_bg">
		
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				</tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->
	</td></tr>
</table>
<!--IBUpload Component (S) -->
<script language="javascript">ComUploadObject('upload1', '<=session.getId()%>');</script>
<!--IBUpload Component (E) -->    	
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>