<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_mnr_0093.jsp
*@FileTitle : Scrapping/Donation Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : WanGyu Kim
*@LastVersion : 1.0
* 2009.09.07 WanGyu Kim
* 1.0 Creation
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.mnr.operationmanage.extradisposalmgt.event.EesMnr0093Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0093Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String rhqOfcCd         = "";
	String currOfcCd       = "";
	String currOfcEngNm     = "";
	Logger log = Logger.getLogger("com.hanjin.apps.PlanManage.PlanMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id    =	account.getUsr_id();
		strUsr_nm    = 	account.getUsr_nm(); 
		rhqOfcCd     = 	account.getRhq_ofc_cd();
		currOfcCd    = 	account.getOfc_cd();
		currOfcEngNm = 	account.getOfc_eng_nm();
		
		event = (EesMnr0093Event)request.getAttribute("Event");
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
<title><span id="title"></span></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	var currOfcCd = "<%=currOfcCd.trim() %>";
	var usrId     = "<%=strUsr_id.trim()%>";
	
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
	
</script>
<script language="javascript">ComSheetObject('sheet1');</script>
</head>
<body  onLoad="setupPage();"> 

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="eq_tpsz_cd">
<input type="hidden" name="pagerows">

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
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Confirm">Confirm</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Cancel">Cancel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				</tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->
	
	
		<!--biz page (S)-->
		<!-- 1 (S) -->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
				<!--  biz_1 (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="55">EQ Type</td>
					<td width="120" style="padding-left:2"><script language="javascript">ComComboObject('eq_knd_cd', 1, 100, 1, 1);</script></td>
					<td width="45">EQ No.</td>
					<td width="110"><input type="text" name="eq_no" style="width:90;" class="input1" dataformat="engup" maxlength="14" required></td>
					<td width="65">EQ Status</td>
					<td width="170" style="padding-left:2"><script language="javascript">ComComboObject('xtra_disp_sts_cd', 1, 150, 1, 0);</script></td>
                    <td width="95">Creation Office</td>
					<td width="70"><input type="text" name="ofc_cd" style="width:50;" class="input2" readOnly="true" value="<%=currOfcCd.trim()%>"></td>
					<td width="90">Creation User</td>
					<td width=""><input type="text" name="cre_usr_id" style="width:80;" class="input2" readOnly="true" value="<%=strUsr_id.trim()%>"></td>
				</tr> 
				</table>
				<!--  biz_1 (E) -->

				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>

			
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s"> Creation</td></tr>
				</table>

				<!-- Grid - 1,2,3 (S) -->
				<table class="search" width="979">
				<tr><td width="659" style="padding-right:20" valign="top">
	
				<table class="search" width="100%"> 
				<tr class="h23">
					<td width="90">Type</td>
					<td width="200" style="padding-left:2"><script language="javascript">ComComboObject('mnr_xtra_disp_tp_cd', 1, 100, 1, 1);</script></td>							
					<td width="90">Issue Date</td>
					<td width=""><input type="text" name="iss_dt" style="width:75;text-align:center" class="input1" dataformat="ymd" maxlength="8">&nbsp;<img src="img/btns_calendar.gif" name="iss_dt_cal" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				</tr> 
				<tr class="h23">
					<td width="">Request Office</td>
					<td width="" style="padding-left:2"><script language="javascript">ComComboObject('iss_ofc_cd', 1, 100, 0, 1);</script></td>
					<td width="">Issue Yard</td>
					<td width=""><input type="text" name="iss_yd_cd" style="width:100;" class="input1" dataformat="engup" maxlength="7">&nbsp;<img src="img/btns_search.gif" name="btn_yard_popup" width="19" height="20" alt="" border="0" align="absmiddle" style="cursor:pointer;cursor:hand"></td>
				</tr> 
				<tr class="h23">
					<td width="">Currency</td>
					<td width="" style="padding-left:2"><script language="javascript">ComComboObject('curr_cd', 1, 100, 0, 1);</script></td>
				</tr> 
				<tr class="h23">
					<td width="">Income Total</td>
					<td width=""><input  type="text" name="xtra_disp_incm_amt" style="width:100;text-align:right" class="input" dataformat="float" maxlength="14" pointcount="2" caption="Float(Maximum Minimum)" ></td>
					<td width="">Expense Total</td>
					<td width=""><input  type="text" name="xtra_disp_expn_amt" style="width:100;text-align:right" class="input" dataformat="float" maxlength="14" pointcount="2" caption="Float(Maximum Minimum)"></td>			
				</tr> 
				</table>
				</td>
				
				<td width="300" valign="top">
				<!-- Grid - 3 - Evidence Attached (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>
				<!-- Grid - 3 - Evidence Attached (E) -->

				<!--  Button_Sub (S) -->
				<table width="100%" class="button"> 
		       	<tr><td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0">
					<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_FileAdd">Row Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_FileDel">Row Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						
						</tr></table>
				</td></tr>
				</table>
		    	<!-- Button_Sub (E) -->
				</td></tr>
			</table>	
			<!-- Grid - 1,2,3 (E) -->

			<!-- Donation Information (S) -->
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			<table class="grid2" border="0" style="width:979;"> 
			<tr>
				<td width="150" class="tr2_head">Donation Information<br>(Given to)</td>
				<td><textarea name="xtra_disp_desc" style="width:100%;" rows="5" maxLength="4000"></textarea></td></tr> 
			<tr class="h23">
				<td  class="tr2_head">Remark(s)</td>
				<td><textarea name="xtra_disp_rmk" style="width:100%;" rows="2" maxLength="4000"></textarea></td></tr> 
			</table>	
			<!-- Donation Information (S) -->
		
		</td></tr>
		</table>		
		<!-- 2 (E) -->		
		
		<!--biz page (E)-->
	</td></tr>
	</table>

	<table class="height_10"><tr><td colspan="8"></td></tr></table>
<script language="javascript">ComUploadObject('upload1', '<%=session.getId()%>');</script>
</form>
</body>
</html>