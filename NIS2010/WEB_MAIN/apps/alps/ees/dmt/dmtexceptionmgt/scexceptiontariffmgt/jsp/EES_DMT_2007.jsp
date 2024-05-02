<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_2007.jsp
*@FileTitle : S/C & RFA Exception Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.07.03 이성훈
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
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.event.EesDmt2007Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt2007Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id	 = "";
	String strUsr_nm	 = "";
	String strOfc_cd	 = "";
	String strRhq_ofc_cd = "";
	Logger log = Logger.getLogger("com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt");
	
	String scNo 	= request.getParameter("sc_no") 	!= null ? (String)request.getParameter("sc_no") 	: "" ;
	String rfaNo 	= request.getParameter("rfa_no") 	!= null ? (String)request.getParameter("rfa_no") 	: "" ;
	String trfCd 	= request.getParameter("trf_cd") 	!= null ? (String)request.getParameter("trf_cd") 	: "" ;
	String caller 	= request.getParameter("caller") 	!= null ? (String)request.getParameter("caller") 	: "" ;
	
	String bodyTag	= null;
	String tableTag	= null;
	
	if (caller.length() > 0) {
		//PopUp 화면일 경우
		bodyTag		= "<body class=\"popup_bg\" onLoad=\"setupPage();\">";
		tableTag 	= "<table width=\"100%\" class=\"popup\" cellpadding=\"5\" border=\"0\">";
	}
	else {
		//Main 화면일 경우
		bodyTag		= "<body onLoad=\"setupPage();\">";
		tableTag 	= "<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"padding-top:2;padding-left:5;\">";
	}
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id 	  = account.getUsr_id();
		strUsr_nm 	  = account.getUsr_nm();
		strOfc_cd 	  = account.getOfc_cd();
		strRhq_ofc_cd = account.getRhq_ofc_cd();
	   
		event = (EesDmt2007Event)request.getAttribute("Event");
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
<title>S/C & RFA Exception Inquiry</title>
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

<%= bodyTag %>
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="caller" value="<%= caller %>">
<input type="hidden" name="dmdt_trf_cd_list">
<!-- S/C, Before 상태값을 조회하기 위해서 사용되는 매개변수 -->
<input type="hidden" name="intg_cd_id">
<!-- Ref. Office 를 조회하기 위해서 사용되는 매개변수 -->
<input type="hidden" name="login_usr_id" value="<%=strUsr_id%>">
<input type="hidden" name="login_usr_nm" value="<%=strUsr_nm%>">
<input type="hidden" name="login_ofc_cd" value="<%=strOfc_cd%>">
<input type="hidden" name="ref_ofc_cd">
<input type="hidden" name="tmp_ofc_cd">
<input type="hidden" name="ofc_cd">
<!-- Coverage 를 조회하기 위해서 사용되는 매개변수 -->
<input type="hidden" name="cnt_cd">
<input type="hidden" name="rgn_cd">
<input type="hidden" name="ste_cd">
<input type="hidden" name="loc_cd">
<!-- S/C & RFA Exception Inquiry 를 위해서 사용되는 매개변수 -->
<input type="hidden" name="ver_sts_cd">
<input type="hidden" name="rqst_sts_cd">
<input type="hidden" name="tariff">
<input type="hidden" name="fm_dt">
<input type="hidden" name="to_dt">
<input type="hidden" name="sc_no">
<input type="hidden" name="rfa_no">
<input type="hidden" name="prop_no">
<input type="hidden" name="dar_no">
<input type="hidden" name="apvl_no">
<input type="hidden" name="type">
<input type="hidden" name="cond_tp">
<input type="hidden" name="cust_cd">
<input type="hidden" name="act_cust_cd">
<!-- S/C & RFA Exception Inquiry 의 자식정보를 조회하기 위해서 사용하는 매개변수 -->
<input type="hidden" name="sc_expt_ver_seq">
<input type="hidden" name="sc_expt_grp_seq">
<input type="hidden" name="rfa_expt_dar_no">
<input type="hidden" name="rfa_expt_ver_seq">
<input type="hidden" name="rfa_rqst_dtl_seq">
<!-- Customer Name 를 조회하기 위해서 사용되는 매개변수 -->
<input type="hidden" name="cust_seq">
<input type="hidden" name="cust_cnt_cd">
<!-- 팝업으로 Load 될 때 전달받은 인자 -->
<input type="hidden" name="opener_tariff" value="<%= trfCd %>">
 
<%= tableTag %>
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<script language="javascript">DmtComPageTitle(<%=(caller.length() > 0 ? "true" : "false")%>);</script>
		</table>
	<!--Page Title, Historical (E)-->
	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
       	<tr>
       		<td class="btn1_bg">
		    	<table border="0" cellpadding="0" cellspacing="0">
		    	<tr>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_New">New</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
					<td class="btn1_line"></td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_Minimize">Minimize</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_Detail">Detail</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_DownExcel">Down Excel</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
				</tr>
				</table>
			</td>
		</tr>
		</table>
    <!--Button (E) -->
	
	<div id="conditionLayer" style="display:inline">	
		<table class="search"> 
       	<tr>
       		<td class="bg">
			<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="590">
						
						<table class="search_sm2" border="0" style="width:500;"> 
						<tr class="h23">
							<td width="35">&nbsp;Type</td>
							<td class="stm"><input type="checkbox" name="chkSC" class="trans" checked onClick="checkType(this)">&nbsp;S/C&nbsp;<script language="javascript">ComComboObject('combo1', 1, 80, 0, 1)</script>&nbsp;<img src="img/btns_multisearch.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="chkRFA" class="trans" checked onClick="checkType(this)">&nbsp;RFA (Before BKG DAR)&nbsp;<script language="javascript">ComComboObject('combo2', 1, 80, 0, 1)</script>&nbsp;<img src="img/btns_multisearch.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
						</tr>
						</table>
					</td>
					<td width="87">Tariff Type</td>
					<td width="">&nbsp;<script language="javascript">ComComboObject('combo3', 2, 250, 0, 1)</script>&nbsp;<img src="img/btns_multisearch.gif"width="19"height="20"alt=""border="0"align="absmiddle"class="cursor"></td>
				</tr>
				</table>
				<table class="height_2"><tr><td></td></tr></table>
				<table class="search_sm" border="0" style="width:979;"> 
				<tr class="h23">
					<td>
						<table class="search" border="0"> 
						<tr class="h23">
							<td width="90"><input type="radio" name="cond_type" value="office" class="trans"checked>Office</td>
							<td width="60" class="stm">Ref. Office</td>
							<td width="435" class="stm">&nbsp;<script language="javascript">ComComboObject('combo4', 2, 205, 0, 1, 0,true)</script>&nbsp;<img src="img/btns_multisearch.gif"width="19"height="20"alt=""border="0"align="absmiddle"class="cursor">&nbsp;<input type="checkbox" name="chkSubOfc" value="Y" class="trans" onClick="doInclSubOfc()">Incl. Sub Office</td>
							<td width="85" class="stm">Effective Date</td>
							<td width="" style="padding-left:2">
								<input type="text" name="ofcEffDtFm" style="width:80;" class="input1" dataformat="ymd" maxlength="8" readonly>&nbsp;~&nbsp;
								<input type="text" name="ofcEffDtTo" style="width:80;" class="input1" dataformat="ymd" maxlength="8" readonly>&nbsp;<img src="img/btns_calendar.gif" 
								name="btns_ofcCalendar" width="19" height="20"alt=""border="0"align="absmiddle"class="cursor"></td>
						</tr>
						</table>
						
						<table class="search" border="0"> 
						<tr class="h23">
							<td width="90"><input type="radio" name="cond_type" value="coverage" class="trans">Coverage</td>
							<td width="60" class="stm">Country</td>
							<td width="100">&nbsp;<script language="javascript">ComComboObject('cboCountry', 2, 60, 0, 1)</script></td>
							<td width="45" class="stm"><span id="Region">Region</span></td>
							<td width="110" class="stm">&nbsp;<script language="javascript">ComComboObject('cboRegion', 2, 60 , 0, 0, 0, true)</script></td>
							<td width="70" class="stm">Location</td>
							<td width="110" class="stm" style="padding-left:2"><input type="text" name="location" style="width:90;ime-mode:disabled" class="input" dataformat="engup" maxlength="5" OnKeyUp="checkLocation()"></td>
							<td width="85" class="stm">Effective Date</td>
							<td width="">
								<input type="text" name="cvrgEffDtFm" style="width:80;" class="input1" dataformat="ymd" maxlength="8" readonly>&nbsp;~&nbsp;
								<input type="text" name="cvrgEffDtTo" style="width:80;" class="input1" dataformat="ymd" maxlength="8" readonly>&nbsp;<img src="img/btns_calendar.gif" 
								name="btns_cvrgCalendar" width="19" height="20"alt=""border="0"align="absmiddle"class="cursor"></td>
						</tr>
						</table>
						
						<table class="search" border="0"> 
						<tr class="h23">
							<td width="90"><input type="radio" name="cond_type" value="dar" class="trans">DAR</td>
							<td width="60" class="stm">S/C No.</td>
							<td width="100" style="padding-left:2"><input type="text" name="sCNo" value="<%= scNo %>" style="width:80;ime-mode:disabled" class="input" dataformat="engup" maxlength="9"></td>
							<td width="45" class="stm">RFA No.</td>
							<td width="110" style="padding-left:0" class="stm"><input type="text" name="rFANo" value="<%= rfaNo %>" style="width:85;ime-mode:disabled" class="input" dataformat="engup" maxlength="11"></td>
							<td width="70" class="stm">Proposal No.</td>
							<td width="110" class="stm"><input type="text" name="proposalNo" style="width:90;ime-mode:disabled" class="input" dataformat="engup" maxlength="11"></td>
							<td width="50" class="stm">DAR No.</td>
							<td width="140" class="stm"><input type="text" name="darNo" style="width:115;ime-mode:disabled" class="input" dataformat="engup" maxlength="15"></td>
							<td width="60" class="stm">APVL No.</td>
							<td width="" class="stm"><input type="text" name="approvalNo" style="width:120;ime-mode:disabled" class="input" dataformat="engup" maxlength="15"></td>
						</tr>
						</table>
					</td>
				</tr>
				</table>
				
				<table class="search" border="0" style="width:884;"> 
				<tr class="h23">
					<td width="70">&nbsp;&nbsp;Customer</td>
					<td width=""><select name="custTp" style="width:85;" class="input">
						<option value="" selected>ALL</option>
						<option value="CUST">Main</option>
						<option value="A/CUST">DEM/DET</option>
						</select>&nbsp;<input type="text" name="custCd" style="width:80;ime-mode:disabled" class="input" dataformat="engup" maxlength="8">&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" onClick="openWinSearchCustomer('cust_cd')">&nbsp;<input type="text" name="custNm" style="width:500;" class="input2"></td>
				</tr>
				</table>

				<!--  biz_1  (E) -->
				
			</td>
		</tr>
		</table>
	</div>				
	
		<table class="height_8"><tr><td></td></tr></table>
		<!-- Tab (S) -->
     	 <table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%>
					<tr>
						<td width="100%">
							<script language="javascript">ComTabObject('tab1')</script>
						</td>
					</tr>
				</table>
		<!-- Tab (E) -->
 <!--  Tab_1 (S) -->
	<div id="tabLayer" style="display:inline">
		
		<table class="search"> 
       		<tr><td class="bg">
				<!-- Grid  (S) -->
				<table width="100%" id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t1sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- Grid  (e) -->
					<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				
				<table class="search" border="0" style="width:100%;"> 
					<tr class="h23">
					<td width="">	
				
					<table class="search" border="0" style="width:100%;"> 
					<tr class="h23">
						<td width="300">
							<table class="search" border="0">
							<tr><td class="title_h"></td>
							<td class="title_s">Tiered Free Time</td></tr>
							</table>
							<!-- Grid  (S) -->
							<table width="100%"  id="mainTable"> 
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('t1sheet2');</script>
									</td>
								</tr>
							</table>
							<!-- Grid  (e) -->
						
						
						</td>
						<td width="19">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td width="660">
							<table class="search" border="0">
							<tr class="h23"><td class="title_h"></td>
							<td width="150" class="title_s">Rate Adjustment</td>
							<td>Currency&nbsp;&nbsp;<input type="text" name="scCurrency" style="width:45;text-align:center;" class="input2"></td>
							</tr>
							</table>
							<!-- Grid  (S) -->
							<table width="660"  id="mainTable"> 
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('t1sheet3');</script>
									</td>
								</tr>
							</table>
								<!-- Grid  (e) -->
						</td></tr>
						</table>
						<table class="height_5"><tr><td></td></tr></table>
						<table class="search" border="0" style="width:979;"> 
						<tr class="h23">
						<td width="500">
							<table class="search" border="0">
							<tr><td class="title_h"></td>
							<td class="title_s" width="70">Customer</td><td><input type="text" name="scCustType" style="width:110;" class="input2"></td></tr>
							</table>
							<!-- Grid  (S) -->
							<table width="490"  id="mainTable"> 
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('t1sheet4');</script>
									</td>
								</tr>
							</table>
							<!-- Grid  (e) -->
						
						
						</td>
						<td width="19">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td width="460">
							<table class="search" border="0">
							<tr><td class="title_h"></td>
							<td class="title_s">Commodity</td>
							</tr>
							</table>
							<!-- Grid  (S) -->
							<table width="460"  id="mainTable"> 
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('t1sheet5');</script>
									</td>
								</tr>
							</table>
								<!-- Grid  (e) -->
						</td></tr>
					</table>
					</td></tr>
					</table>
			</td></tr>
					</table>
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->
	 </div>
 	  <!--  Tab_2 (S) -->
	 <div id="tabLayer" style="display:none">
	<table class="search"> 
       		<tr><td class="bg" >
				<!-- Grid  (S) -->
				<table width="100%" id="mainTable"> 
					<tr>
						<td width="100%">
				<table width="100%" id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t2sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- Grid  (e) -->
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				
					
				
					<table class="search" border="0" style="width:100%;"> 
					<tr class="h23">
						<td width="370">
							<table class="search" border="0">
							<tr><td class="title_h"></td>
							<td class="title_s">Multi Origin or Destination</td></tr>
							</table>
							<!-- Grid  (S) -->
							<table width="100%" id="mainTable"> 
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('t2sheet2');</script>
									</td>
								</tr>
							</table>
							<!-- Grid  (e) -->
						
						
						</td>
						<td width="9">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td width="600">
						   <table class="search" border="0" style="width:600;"> 
					           <tr class="h23"><td width="400">
							<table class="search" border="0">
							<tr class="h23"><td class="title_h"></td>
							<td width="150" class="title_s">Rate Adjustment</td>
							<td>Currency&nbsp;&nbsp;<input type="text" name="rfaCurrency" style="width:45;text-align:center;" class="input2"></td>
							</tr>
							</table>
						</td>
						<td align="right"><table width="80" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Affiliate">Affiliate</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						</tr>
						</table>
							
							<!-- Grid  (S) -->
							<table width="100%"  id="mainTable"> 
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('t2sheet3');</script>
									</td>
								</tr>
							</table>
								<!-- Grid  (e) -->
						
					
				
			
			</td></tr>
		</table>
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->

    </div>
			
			
	
			</td></tr>
		</table>				
					
			
			</td></tr>
		</table>
	<!-- Tab BG Box  (S) -->
	</td></tr>
</table>

<div id="btnCloseLayer" style="display:none">	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				
			</tr>
		</table>

	</td></tr>
	</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
</div>



</form>
</body>
</html>
