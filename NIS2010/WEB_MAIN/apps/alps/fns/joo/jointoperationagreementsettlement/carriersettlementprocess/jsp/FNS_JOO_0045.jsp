<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_JOO_0045.jsp
*@FileTitle : Adjustment Slot Hire
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.07.20 박희동
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
<%@ page import="com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event.FnsJoo0045Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsJoo0045Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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
	
	String crrCombo = "";	
	String stlCombo = "";
	String stlComnm = "";
    String clzYn    = "O";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (FnsJoo0045Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		crrCombo = eventResponse.getETCData("jo_crr_cd");
		stlCombo = eventResponse.getETCData("stl_jb_combo");
		stlComnm = eventResponse.getETCData("stl_jb_comnm");
		clzYn    = eventResponse.getETCData("clz_yn");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Adjustment Slot Hire</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
var gCrrCombo    = "<%=crrCombo%>";
var gStlCombo    = "<%=stlCombo%>";
var gStlComnm    = "<%=stlComnm%>";
var gYYYYMM      = "<%=yyyyMM%>";
var gClzYn       = "<%=clzYn%>";

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
<input type="hidden" name="code">
<input type="hidden" name="name">
<input type="hidden" name="super_cd1">
<input type="hidden" name="super_cd2">
<input type="hidden" name="cur_row" value="0">
<input type="hidden" name="jo_stl_itm_cd" value="S/H">
<input type="hidden" name="jo_mnu_nm" value="S/H">
<input type="hidden" name="locl_curr_cd">
<input type="hidden" name="stl_adj_irr_flg">
<!-- 개발자 작업	-->
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
					<td width="50">Period</td>
					<td width="270"><input type="text" style="width:60" class="input1" name="fm_acct_yrmon" value="<%=yyyyMM%>"  dataformat="ym" maxlength="6">&nbsp;<img class="cursor" src="img/btns_back.gif" width="19" height="20" border="0" align="absmiddle" name="btn_left_fm" disabled>&nbsp;<img class="cursor" src="img/btns_next.gif" width="19" height="20" border="0" align="absmiddle" name="btn_right_fm" disabled>&nbsp;~&nbsp;<input type="text" style="width:60" class="input1" name="to_acct_yrmon" value="<%=yyyyMM%>"  dataformat="ym"  maxlength="6">&nbsp;<img class="cursor" src="img/btns_back.gif" width="19" height="20" border="0" align="absmiddle" name="btn_left_to" disabled>&nbsp;<img class="cursor" src="img/btns_next.gif" width="19" height="20" border="0" align="absmiddle" name="btn_right_to" disabled></td>
					<td width="110">Account Month</td>
					<td width="170"><input type="text" style="width:60" class="input1" name="acct_yrmon" value="<%=yyyyMM%>" dataformat="ym"  maxlength="6">&nbsp;<img class="cursor" src="img/btns_back.gif" width="19" height="20" border="0" align="absmiddle" name="btns_back">&nbsp;<img class="cursor" src="img/btns_next.gif" width="19" height="20" border="0" align="absmiddle" name="btns_next"></td>
					<td width="44">Carrier</td>
					<td width="110"><script language="javascript">ComComboObject('jo_crr_cd',1,55,0,1);</script></td>
					<td width="" >
					 	<table border="0" style="width:250;" class="search_sm2">
					 	<tr  class="h23"><td width="65">Rev./Exp.</td>
						 <td width="" class="noinput1" style="font-size:12;"><input type="radio" name="re_divr_cd" value="R" class="trans" checked> Revenue <input type="radio" name="re_divr_cd" value="E" class="trans"> Expense 
						 </td>
						 </tr>
						 </table>
					</td>
					</tr>
					</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="50">Trade</td>
					<td width="80"><script language="javascript">ComComboObject('trd_cd',1,55,0,1);</script></td>
					<td width="35">Lane</td>
					<td width="127"><script language="javascript">ComComboObject('rlane_cd',3,76,0,1);</script></td>
					<td width="125">
						<table class="search_sm2" border="0" style="width:100;"> 
						<tr class="h23">
						<td><input type="checkbox" name="diff_only_yn" id="diff_only_yn" value="Y" class="trans" checked>&nbsp;&nbsp;Diff.Only</td>
						</tr> 
						</table>
					</td>
					<td width="" >
					 	<table border="0" style="width:250;" class="search_sm2">
					 	<tr  class="h23"><td width="80"></td>
					 	<td width="" class="noinput2" ></td></tr>
<!-- 2010.03.23 임시로 막음 					
					 	<tr  class="h23"><td width="80">Irregular Adj</td>
						 <td width="" class="noinput2" ><input type="radio" name="stl_adj_irr_flg" value="" class="trans" checked> All <input type="radio" name="stl_adj_irr_flg" value="Y" class="trans"> Yes <input type="radio" name="stl_adj_irr_flg" value="N" class="trans"> No
						 </td>
						 </tr>
-->						
						 </table>
					</td>
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
					<table width="100%"  id="mainTable">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet2');</script>
							</td>
						</tr>
					</table>
			<!-- Grid (E) -->
			<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td>
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table class="search" border="0" style="width:886;"> 
				<tr class="h23">
				<td width="40"></td>
				<td width="">
				</tr>
				</table></td>
				<td  class="btn2_bg"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_delete" id="btn_delete" auth="C">Row Delete</td>
					<td class="btn2_right"></td>
					</tr>
				</table></td>
		</td></tr>
		</table>
    <!--Button (E) -->
    </td></tr>
		</table>
			<!--  biz_1  (S) -->
				<!--  biz_1   (E) -->
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
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new" id="btn_new" auth="R">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				<td class="btn1_line"></td>
				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
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
</td></tr>
</table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>