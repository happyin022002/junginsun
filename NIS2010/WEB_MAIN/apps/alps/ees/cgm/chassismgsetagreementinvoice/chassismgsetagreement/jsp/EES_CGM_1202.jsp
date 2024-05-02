<%
/*=========================================================
 *Copyright(c) 2013 CyberLogitec
 *@FileName : EES_CGM_1202.jsp
 *@FileTitle : Agreement Creation and Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2013.07.09
 *@LastModifier : 조경완
 *@LastVersion : 1.0
 * 2013.03.08 이영헌
 * 1.0 Creation
 *--------------------------------------------------
 * History
 * 2013.07.09 조경완 [CHM-201325340-01] Role Hard Coding 제거 및 대체 기능 개발
 * 2014-09-25 Chang Young Kim 10만불 비용지급 결재건 3차 
 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.event.EesCgm1202Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%>
<%@ page import="com.hanjin.syscommon.common.util.UserRoleUtil" %>
<%@ page import="com.hanjin.syscommon.common.table.ComUsrRoleVO" %>
<%@ page import="com.hanjin.framework.core.config.SubSystemConfigFactory"%>

<%
	EesCgm1202Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String ofc_cd  			= "";
	String tRole = ""; //Transaction Role //chungpa 20100304 transaction role apply
	
	String csrGwUrl = "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.ChassisMgsetAgreementInvoice.ChassisMgsetAgreement");
	String xml = HttpUtil.makeXML(request,response);
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		ofc_cd = account.getOfc_cd();


		event = (EesCgm1202Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		//2013-07-09 조경완 Rold Code 하드코딩 대체 
		// if("SELCOE".equals(ofc_cd)||"NYCNA".equals(ofc_cd)||"ATLSC".equals(ofc_cd)||"PHXSC".equals(ofc_cd)){
		// 2015 조직코드개편 Chang-Young Kim
		if("SELCON".equals(ofc_cd)||"NYCRA".equals(ofc_cd)||"ATLSA".equals(ofc_cd)||"PHXSA".equals(ofc_cd)){
			tRole = "Authenticated";
		}else{
			tRole = "Not Authenticated";
		}
		
		csrGwUrl = SubSystemConfigFactory.get("CSR.GW.URL");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Agreement Creation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		
		document.form.ofc_cd.value = "<%=ofc_cd%>";
		loadPage();
		
		
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form2">
<input type="hidden" name="sXml" value="<%=xml.replace("\"","'")%>">
</form>
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- Form Hidden -->
<input type="hidden" name ="action_flag">
<input type="hidden" name="ofc_cd">
<input type="hidden" name="chk_yd_cd">
<input type="hidden" name="eq_orz_cht_chktype">
<input type="hidden" name="eq_orz_cht_scc_cd">
<input type="hidden" name="scc">
<input type="hidden" name="yd_nm">

<input type="hidden" name="agmt_ofc_cty_cd">
<input type="hidden" name="agmt_seq">
<input type="hidden" name="lst_ver_flg">

<!--  Previous Data -->
<input type="hidden" name="pre_eff_dt">
<input type="hidden" name="pre_exp_dt">

<input type="hidden" name="pre_agmt_exp_dt">
<input type="hidden" name="trole" value="<%=tRole%>">

<input type="hidden" name="csr_gw_url" value="<%=csrGwUrl%>">
<input type="hidden" name="gw_uq_doc_no">

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
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="94">Agreement No.</td>
					<td width="125" style="padding-left:2"><input type="text" name="agmt_no" dataformat="engup" maxlength="9" style="width:80;ime-mode:disabled" class="input" value="">&nbsp;<img name="btns_agmtno" class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" id="btn_popup1"></td>
					<td width="50">Version</td>
					<td width="70"><script language="javascript">ComComboObject('agmt_ver_no', 1, 40, 1, 0, 0, false);</script><!--input type="text" name="agmt_ver_no" style="width:30;ime-mode:disabled" class="input2" value=""--></td>
					<td width="75">Lease Term</td>
					<td width="70" style="padding-left:2"><input type="text" name="agmt_lstm_cd" readonly style="width:40;text-align:center;ime-mode:disabled" class="input2" value="ZP"></td>
					<td width="95">Pool Name</td>
					<td width="130" style="padding-left:2"><script language="javascript">ComComboObject('chss_pool_cd', 1, 80, 1, 1, 0, false);</script></td>
					<td width="89">Currency</td>
					<td width=""><input type="text" name="curr_cd" readonly style="width:60;text-align:center;ime-mode:disabled" class="input2" value="USD">
				</tr> 
				</table>
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="96">G/W Contract</td>
					<td width="490"><input type="text" name="gw_uq_doc_tit_nm" style="width:453;" class="input2" value="" readonly>&nbsp;<img name="btns_gwUqDoc" class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" id="btn_popup1"></td>
					<td width="75">
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr>
						<td class="btn2_left"></td>
						<td class="btn2" name="btn_gwDelete">Delete</td>
						<td class="btn2_right"></td>
					</tr>
					</table>
					</td>
					<td width="">&nbsp;</td>
				</tr>
				</table>
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="96">Effective Date</td>
					<td width="220" colspan="5">
					   <input type="text" style="width:80;text-align:center;ime-mode:disabled" dataformat="ymd" maxlength='8' class="input1"  name="agmt_eff_dt" value="">&nbsp;
					    ~&nbsp;
					   <input type="text" style="width:80;text-align:center;ime-mode:disabled"  maxlength='8' dataformat="ymd" class="input1" value="" name="agmt_exp_dt">&nbsp;
					   <img class="cursor" name="btns_Calendar_effDt" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
					</td>
					<td width="78">Duration</td>
					<td width="70"><input type="text" name="duration" readonly style="width:40;text-align:center;ime-mode:disabled" class="input2" value=""></td>
					<td width="95">Contract No.</td>
					<td width="132"><input type="text" name="ctrt_no" dataformat="engup" maxlength="50" style="width:115;ime-mode:disabled" class="input1" value=""></td>
					<td width="90">Reference No.</td>
					<td width="175"><input type="text" name="agmt_ref_no" dataformat="engup" maxlength="15" style="width:115;ime-mode:disabled" class="input1" value=""></td>
				</tr>
				</table>
			
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="96">Lessor</td>
					<td width="392"><input type="text" name="vndr_seq" dataformat="int" maxlength="6" style="width:70;text-align:center;ime-mode:disabled" class="input2" value="">&nbsp;<input type="text" name="vndr_lgl_eng_nm" readonly style="width:288;ime-mode:disabled" class="input2" value=""></td>
					<td width="95">Payment Term</td>
					<td width="132" class="sm"><input type="text" name="pay_term_dys" dataformat="int" maxlength="5" style="width:60;text-align:right;ime-mode:disabled" class="input" value="">&nbsp;&nbsp;days</td>
					<td width="89">AGMT Office</td>
					<td width=""><input type="text" name="agmt_iss_ofc_cd" dataformat="engup" maxlength="6" readonly style="width:80;text-align:center;ime-mode:disabled" class="input2" value=""></td>
				</tr> 
				</table>
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="96">Created By</td>
					<td width="182"><input type="text" name="cre_usr_id" dataformat="engup" maxlength="20" style="width:70;text-align:center;ime-mode:disabled" class="input" value=""></td>
					<td width="100">Creation Date</td>
					<td width=""><input type="text" name="cre_dt" dataformat="ymd" maxlength="8" style="width:80;text-align:center;ime-mode:disabled" class="input" value=""></td>
				</tr>
				</table>
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="95">Remarks</td>
					<td width=""><textarea name="diff_rmk" maxlength="1000" style="width:90%;height:70;ime-mode:disabled" value=""></textarea></td>
				</tr>
				</table>
				<!--  biz_1  (E) -->
			</td></tr>
		</table>
		<!-- : ( Search Options ) (E) -->
		<table class="height_8"><tr><td colspan="8"></td></tr></table>
		
		<!-- Tab ) (S) -->
     		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%> 
       		<tr><td width="100%">
				<script language="javascript">ComTabObject('tab1')</script>
			</td></tr>
			</table>
		<!-- Tab ) (E) --> 

		<!--TAB Rental Rate (S) -->
		
	<div id="tabLayer" style="display:Inline">
	
	<!-- Tab BG Box  (S) -->
		<table class="search"> 
       		<tr><td class="bg" style="height:160" valign="top">
       		
			<!-- Grid  (S) -->
			<table width="90%"  id="mainTable">
				<tr>
					<td width="100%">
					<script language="javascript">ComSheetObject('t1sheet1');</script>
				</td>
				</tr>
			</table>
			<!-- Grid (E) -->
			
			<!--  Button_Sub (S) -->
			<table width="90%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_t1RowAdd">Row&nbsp;Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_t1Delete">Row Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
	    	
	    	</td></tr>
		</table>
		<!-- Tab BG Box  (S) -->
		
		</div>
		<!--TAB Rate (E) -->

		<!--TAB 2 (S) -->
		<div id="tabLayer" style="display:none">
		<!-- Tab BG Box  (S) -->
		<table class="search"> 
       		<tr><td class="bg" style="height:160" valign="top">
			<!-- Grid  (S) -->
			<table width="100%"  id="mainTable">
				<tr>
					<td width="100%">
					<script language="javascript">ComSheetObject('t2sheet1');</script>
					</td>
				</tr>
			</table>
			<!-- Grid (E) -->
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_t2RowAdd">Row&nbsp;Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_t2Delete">Row Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
	    	
	    	</td></tr>
		</table>
		<!-- Tab BG Box  (S) -->
		
		</div>
		<!--TAB Rental Remark (E) -->  

	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new" id="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
					<td class="btn1_line"></td>
					
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save" id="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_delete" id="btn_delete">Delete</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_versionUp" id="btn_versionUp">Version Up</td>
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

<div id="hiddenLayer" style="display:none">
	<script language="javascript">ComSheetObject('sheet');</script>  
</div>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>