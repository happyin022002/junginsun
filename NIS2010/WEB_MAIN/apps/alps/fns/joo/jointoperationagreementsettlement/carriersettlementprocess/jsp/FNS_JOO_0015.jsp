<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_JOO_0015.jsp
*@FileTitle : Monthly Clearance Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.08.11 장강철
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
<%@ page import="com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event.FnsJoo0015Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsJoo0015Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.JointOperationAgreementSettlement.CarrierSettlementProcess");
	String yyyyMM = JSPUtil.getKST("yyyy-MM");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (FnsJoo0015Event)request.getAttribute("Event");
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
<title>Monthly Clearance Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
    var yyyyMM ="<%=yyyyMM%>";
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
 
<input type="hidden"   name="com_mrdPath"      value="">
<input type="hidden"   name="com_mrdArguments" value="">
<input type="hidden"   name="com_mrdTitle"     value="Combined Monthly Clearance Inquiry">
<input type="hidden"   name="com_mrdBodyTitle" value="Combined Monthly Clearance Inquiry">
<input type="hidden"   name="com_mrdSaveDialogFileExt" value="ppt">
<input type="hidden"   name="com_mrdSaveDialogFileExtLimit" value="xls@pdf@doc@ppt">
<input type="hidden"   name="com_mrdSaveDialogFileName" value="CombinedMonthlyClearance">
<input type="hidden"   name="com_mrdSaveDialogDir" value="">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">

	<!--top menu (S)-->
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
					<td width="100">Account Month</td>
					<td width="130"><input type="text" style="width:60" class="input1" required style="ime-mode:disabled" dataformat='ym' maxlength='6' value="<%=yyyyMM %>" name='acct_yrmon'>&nbsp;<img class="cursor" src="img/btns_back.gif"  name='btn_back'   id='btn_back'   width="19" height="20" border="0" align="absmiddle">&nbsp;<img class="cursor" src="img/btns_next.gif" name='btn_next'  id='btn_next'  width="19" height="20" border="0" align="absmiddle"></td>
					<td width="40">Carrier </td>
					<td width="90">&nbsp;<script language="javascript">ComComboObject('jo_crr_cd', 1, 60, 0, 1, 0 );</script>&nbsp;</td>
					<td width="90">Combined No.</td>
					<td width="">&nbsp;<script language="javascript">ComComboObject('stl_cmb_seq', 1, 60, 0, 1,0 );</script>&nbsp;</td>
				</table>
				<!--  biz_1   (E) -->				
			</td>
	    </tr>
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
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>

						</td>
					</tr>
				</table> 
			<!-- Grid (E) -->
	<!-- Tab BG Box  (S) -->
		    <table class="search" border="0" style="width:979;"> 
		        <tr class="h23">
		        <td width="849">
		            <table width="100%"  id="mainTable"> 
		            <tr class="h23">
		                <td width="5%" align="right">Carrier</td>
		                <td width="5%"><input type="text" style="width:40;text-align:center" class="input1" name="bal_jo_crr_cd" readOnly></td>
		                <td width="15%" align="right">Balance Amount</td>
		                <td width="20%"><input type="text" style="width:120;text-align:right" class="input1" name="balance" pointcount=2 dataformat="float" readOnly></td>
		                <td width="">&nbsp;</td>
		                </tr> 
		            </table>
		        </td>
		       </tr>
		   </table>
	<!--biz page (E)-->	
	    </td></tr>
		</table>

	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
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
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Down_Excel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
                <td class="btn1_line"></td>
                <td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_print">Print</td>
                    <td class="btn1_right"></td>
  
                    </tr>
                </table></td>
		</td></tr>
		</table>
    <!--Button (E) -->
	</td></tr>
</table>
	</td></tr>
</table>
 
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>