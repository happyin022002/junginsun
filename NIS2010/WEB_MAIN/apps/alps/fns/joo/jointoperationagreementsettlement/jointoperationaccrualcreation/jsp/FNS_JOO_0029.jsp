<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_joo_0029.jsp
*@FileTitle : Estimate Performance Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.30
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.06.30 장강철
* 1.0 Creation
* -------------------------------------------------------
* History
* [CHM-201640149] [CSR] Estimate Performance Creation Logic adjustment
*   - 추정대상 연도를 3개년으로 수정
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.event.FnsJoo0029Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsJoo0029Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd        = "";
	Logger log = Logger.getLogger("com.hanjin.apps.JointOperationAgreementSettlement.JointOperationAccrualCreation");
	String yyyyMM = JSPUtil.getKST("yyyy-MM");
	
	String joCrrCd = "";
	String trdCd   = "";
	String rlaneCd = "";
	String clzFlg  = "";
	String exeYrmon = "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (FnsJoo0029Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		joCrrCd = eventResponse.getETCData("jo_crr_cd");
		trdCd   = eventResponse.getETCData("trd_cd");
		rlaneCd = eventResponse.getETCData("rlane_cd");
		clzFlg  = eventResponse.getETCData("estm_clz_flg");
		exeYrmon= eventResponse.getETCData("EXE_YRMON");
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Estimate Performance Creation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
var gJoCrrCd = "<%=joCrrCd%>";
var gTrdCd   = "<%=trdCd%>";
var gRlaneCd = "<%=rlaneCd%>";
var gClzFlg  = "<%=clzFlg%>";
var gYyyyMM  = "<%=yyyyMM%>";
var gOfcCd   = "<%=strOfc_cd%>";

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
<form name="form"  >

<input type="hidden" name="f_cmd">
<input type="hidden" name="ofc_cd" value="<%=strOfc_cd%>">
<input type="hidden" name="code">
<input type="hidden" name="name">
<input type="hidden" name="super_cd1">
<input type="hidden" name="super_cd2">
<input type="hidden" name="estm_cond_flg">
<input type="hidden" name="cre_flg" value="N">
<input type="hidden" name="search_gubun">
<input type="hidden" name="pagerows">
<input type="hidden" name="trd_cd">
<input type="hidden" name="rlane_cd">
<input type="hidden" name="jo_crr_cd">
<input type="hidden" name="acct_cd">
<input type="hidden" name="estm_vvd_tp_cd">

<!-- BackEndJob을 위한 Field -->
<input type="hidden" name="key">

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
					<td width="125">Estimated Period</td>
					<td width="130"><input type="text" style="width:60" class="input1"  dataformat='ym' maxlength="6" name='exe_yrmon' value="<%=exeYrmon.substring(0,4)+"-"+exeYrmon.substring(4)%>">&nbsp;<img class="cursor" src="img/btns_back.gif" name='btn_exe_back' width="19" height="20" border="0" align="absmiddle">&nbsp;<img class="cursor"  name='btn_exe_next'  src="img/btns_next.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="340">
							<table class="search_sm" border="0" style="width:330;">
							<tr class="h23">
								<td width="65">Rev./Exp.</td>
								<td width=""class="noinput1">&nbsp;<input type="radio" name='re_divr_cd' value="" checked class="trans" >&nbsp;&nbsp;ALL&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" value="R" name='re_divr_cd' class="trans" >&nbsp;&nbsp;Revenue&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio"  value="E" name='re_divr_cd'  class="trans" >&nbsp;&nbsp;Expense</td>
							</tr>
							</table>
					</td>
					<td width="37">Trade</td>
					<td width="100"><script language="javascript">ComComboObject('trd_cd2', 1, 70, 0, 0);</script></td>
					<td width="34">Lane</td>
					<td width="95"><script language="javascript">ComComboObject('rlane_cd2', 1, 70, 0, 0);</script></td>
					<td width="45">Carrier</td>
					<td width="*"><script language="javascript">ComComboObject('jo_crr_cd2', 1, 60, 0, 0);</script></td>
				</tr> 
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
				    <td width="125">
		                  <select style="width:120;" class="input" name="search_gubun2" disabled>
		                    <option value="2">Target VVD Period</option>
		                    <option value="1" selected>Revenue Month</option>
		                    <option value="3">Revenue Month(I/F)</option>
		                  </select>				    
				    </td>
				    <td width="250"><input type="text" style="width:60" class="input" dataformat='ym' maxlength='6' caption='Target VVD Period Start DateFormat' name='rev_yrmon_fr' value="" cofield="btn_vvd_from_back">&nbsp;<img class="cursor" src="img/btns_back.gif" name='btn_vvd_from_back' width="19" height="20" border="0" align="absmiddle">&nbsp;<img class="cursor" src="img/btns_next.gif"  name='btn_vvd_from_next' width="19" height="20" border="0" align="absmiddle">&nbsp;~&nbsp;<input type="text" style="width:60" class="input"   maxlength='6'  caption='Target VVD Period End DateFormat' dataformat='ym' name='rev_yrmon_to' value="<%=yyyyMM%>" cofield="btn_vvd_to_next">&nbsp;<img class="cursor" src="img/btns_back.gif"  name='btn_vvd_to_back'  width="19" height="20" border="0" align="absmiddle">&nbsp;<img class="cursor" src="img/btns_next.gif"  name='btn_vvd_to_next' width="19" height="20" border="0" align="absmiddle"></td>
				    <td width="35">VVD</td>
					<td width="100"><input type="text" name="vvd" style="width:90;text-align:center" class="input" value="" maxlength='10' dataformat="engup" style="ime-mode:disabled"></td>
					<td width="25">Adjust</td>
   	                <td width="25"><input type="checkbox" value="Y" name="adjust" class="trans"></td>																				
					<td width="55">Account</td>
					<td width="100"><script language="javascript">ComComboObject('acct_cd2', 1, 70, 0, 0);</script></td>
					<td width="34">Type</td>
					<td width="108"><script language="javascript">ComComboObject('estm_vvd_tp_cd2', 1, 70, 0, 0);</script></td>
					<td width="25">Diff.</td>
   	                <td><input type="checkbox" value="Y" name="diff" class="trans"></td>
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
			<table width="100%"  id="mainTable" border="0" cellpadding="0" cellspacing="0"> 
				<tr>
					<td width="100%">
					<!--시트-->
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table>
			<!-- Grid (E) -->

			<!-- Grid  (S) -->
			<table width="100%"  id="mainTable" border="0" cellpadding="0" cellspacing="0"> 
				<tr>
					<td width="100%">
					<!--시트-->
						<script language="javascript">ComSheetObject('sheet2');</script>
					</td>
				</tr>
			</table>
			<!-- Grid (E) -->
			<table width="100%"  id="mainTable" border="0" cellpadding="0" cellspacing="0"> 
				<tr class="h23">
					<td width="10%">Estimated Cost</td>
					<td width="15%"><input type="text" style="width:120;text-align:right" class="input2" name="estm_amt" dataformat="float" readOnly></td>
					<td width="8%">Actual Cost</td>
					<td width="15%"><input type="text" style="width:120;text-align:right" class="input2" name="act_amt" dataformat="float" readOnly></td>
					<td width="8%">Accrual Cost</td>
					<td width="15%"><input type="text" style="width:120;text-align:right" class="input2" name="accl_amt" dataformat="float" readOnly></td>
					<td width="8%">Total Count</td>
					<td width=""><input type="text" style="width:80;text-align:right" class="input2" name="tot_cnt" dataformat="int" readOnly></td>
				</tr> 
			</table>
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
            <table width="100%" border="0" > 
              <tr class="h23">
                <td width="70">Page Size :</td>
                <td width="90">
                  <select style="width:70;" class="input" name="pagerows2" onChange="javascript:reset_all();">
                    <option value="1000">1,000</option>
                    <option value="5000" >5,000</option>
                    <option value="10000">10,000</option>
                    <option value="20000">20,000</option>
                    <option value="30000">30,000</option>
                    <option value="50000" selected>50,000</option>
                    <option value="70000">70,000</option>
                  </select>
                </td>              
			    <td align="left" width="20"><img class="cursor" img src="/hanjin/img/bu_prev02.gif" border="0" name="reward"></td>
                <td align="left" width="45" class="title_s">Page :</td>
                <td align="left" width="32" valign="bottom"><input type="text"  class="input2" style="width:30; valign:bottom; text-align:right;"  name="tot_page_cnt" value="0"></td>
                <td align="left" width="38" valign="bottom"><input type="text" style="width:30; valign:bottom; text-align:right"  name="page_no" value="1" onkeydown="if (event.keyCode == 13) gotopage();"></td>
                <td><img class="cursor" img src="/hanjin/img/bu_next02.gif" border="0" name="forward"></td>
                <td width='30%'>&nbsp;</td>
                <td>
<!--                 
                  <select style="width:90;" class="input" name="search_gubun3" onChange="javascript:changeRetreieveGubun();">
                    <option value="1" selected>Retrieve</option>
                    <option value="2">Target Retrieve</option>
                    <option value="3">I/F Retreive</option>
                  </select>
 -->                  
                </td>                
                <td>
<!--                
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn2_left"></td>
							<td class="btn2" id="btn_next" name="btn_Down_Excel2">Down Excel without Displaying</td>
							<td class="btn2_right"></td>
							<td class="btn2_left"></td>
							<td class="btn2" id="btn_last" name="btn_last">End</td>
							<td class="btn2_right"></td>
						</tr>
						</table>
 -->						                
                </td>                                
              </tr>
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
					<td class="btn1" name="btn1_Retrieve" id="btn1_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_New"  id="btn1_New" >New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1_1" name="btn1_save"  id="btn1_save" auth="C">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Down_Excel"  id="btn1_Down_Excel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="120" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Create"  id="btn1_Create">Target Create</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="130" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Target"  id="btn1_Target">Target Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>				
				<td><table width="100" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1_1" name="btn1_I_F"  id="btn1_I_F"   auth="C">I/F Send</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="110" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1_1" name="btn1_F_R"  id="btn1_F_R"   auth="C">I/F Retrieve</td>
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