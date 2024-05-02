<%
/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EES_EQR_1009.jsp
*@FileTitle : Empty Repo Guideline Add/Amend.
*Open Issues :
*Change history :
*@LastModifyDate : 2013.5.27
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 2013.05.27 SHIN DONG IL 
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
<%@ page import="com.hanjin.apps.alps.ees.eqr.cntrplanguide.cntrplanguidelinemanage.event.EesEqr1009Event"%>
<%@ page import="com.hanjin.apps.alps.ees.eqr.cntrplanguide.cntrplanguidelinemanage.vo.EesEqr1009ConditionVO"%>

<%
	EesEqr1009Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd 		= "";
	String vvd_cd 			= "";
	String eff_st_dt		= "";
	String eta_dt			= "";	
	String pol_cd 			= "";
	String combo_pol_cd 	= "";
	
	// 2015.02.25 CHM-201534210 EQR 소스 보안
	String event_div  		= JSPUtil.getParameter(request, "event_div");
	String hidden_eta_dt  	= JSPUtil.getParameter(request, "h_eta_dt");	
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		
		event = (EesEqr1009Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		EesEqr1009ConditionVO conditionVO = new EesEqr1009ConditionVO();
		conditionVO = event.getEesEqr1009ConditionVO();
		
		vvd_cd = conditionVO.getSVvdCd();
		eff_st_dt = conditionVO.getSEffStDt();
		pol_cd = conditionVO.getSPolCd();
		eta_dt = conditionVO.getSEtaDt();

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
<title>Mty Repo Guideline Guideline Add/Amend</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var formObj = document.form;
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		
		if("<%= event_div %>" =="M"){ //Amend일 경우
			formObj.s_vvd_cd.value		=	"<%=vvd_cd%>";
			formObj.s_pol_cd.value		=	"<%=pol_cd%>";
			formObj.s_eff_st_dt.value	=	"<%=eff_st_dt%>";
			formObj.s_eta_dt.value		=	"<%=eta_dt%>";
			formObj.h_eta_dt.value		=	"<%=hidden_eta_dt%>";
		}else{
			formObj.s_vvd_cd.value		=	"";
			formObj.s_pol_cd.value		=	"";
			formObj.s_eff_st_dt.value	=	"";
			formObj.s_eta_dt.value		=	"";
			formObj.h_eta_dt.value		=	""; 
		}
		ComOpenWait(true);
		loadPage();
	}
</script>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="setupPage();">
<form method="post" name="form" onSubmit="return false;">
	<input type="hidden" name="f_cmd">
	<input type="hidden" name="event_div"  	value="<%= event_div %>">
	<input type="hidden" name="s_eff_st_dt" value="">
	<input type="hidden" name="h_eta_dt" value="">
	<input type="hidden" name="cntr_tpsz_cd" value="">
	
	<!-- Outer Table (S)-->
	<table width="840" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
		<tr>
			<td>
				<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
			     <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
					<tr>
						<td class="history"></td>
					</tr>
					<tr>
						<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Guideline Add/Amend</td>
					</tr>
				</table>
				<table class="search"><tr><td class="height_10"></td></tr></table>
				<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->
		        <!-- TABLE '#D' : ( Search ) (S) -->
		        <table class="search" border="0"  width="100%">
					<tr>
		                <td class="bg">
		                    <table border="0" width="100%">
								<tr class="h23">
									<td width="42" align="center">Trade</td>
									<td width="95">
										<script language="JavaScript">ComComboObject("trade", 2, 80, 0, 1);</script>
									</td>
									<td width="88" align="center">Sub Trade</td>
									<td width="90">
										<script language="JavaScript">ComComboObject("subtrade", 4, 80, 0, 1);</script>
									</td>
									<td width="42" align="center">Lane</td>
									<td width="100">
										<!-- script language="JavaScript">ComComboObject("lane", 5, 85, 0, 1);</script -->
										<script language="JavaScript">ComComboObject("lane", 2, 85, 0, 0);</script><!-- 정길수 부장님 작업용 -->	
									</td>
									<td width="38" align="right">VVD</td>
									<td width="100">
										<input type="text" name="s_vvd_cd" class="input1" style="width:80" maxlength="9"  onKeyPress= "form_keypress();" onChange="change_vvd();" > 
									</td>
									<td width="38" align="right">POL</td>
									<td width="100">
										<select name="s_pol_cd"  style="width:80" maxlength="7" onChange="change_pol();" class="input1">
										</select> 
									</td>
									<td width="38" align="right">ETA</td>									
									<td width="100">
										<input type="text" name="s_eta_dt" class="input2" style="width:80" dataformat="ymd" maxlength="8"  readonly>
									</td> 
									<td>&nbsp;</td>
								</tr>
							</table>
		                </td>
		            </tr>
		        </table>
	        	<!-- TABLE '#D' : ( Search ) (E) -->
				<table class="search"><tr><td class="height_10"></td></tr></table>
				<table class="search" border="0">
					<tr>
						<td>
							<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
								<tr>
									<td class="btn3_bg">
										<table border="0" cellpadding="0" cellspacing="0">
											<tr>
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn1_left"></td>
															<td class="btn1" name="btn_apply" id="btn_apply">Apply</td>
															<td class="btn1_right"></td>
														</tr>
													</table>
												</td>
												<td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn1_left"></td>
															<td class="btn1" name="btn_close" id="btn_close">Close</td>
															<td class="btn1_right"></td>
														</tr>
													</table>
												</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
					    	<!-- TABLE '#D' : ( Button : Sub ) (E) -->
							<!-- : ( Grid ) (S) -->
							<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->
		        	        <table width="100%" id="mainTable" >
		        				<tr>
		        					<td>
			        				   <script language="javascript">ComSheetObject('sheet1');</script> <!-- hidden grid -->
			        				</td>
			        			</tr>
		        			</table>
							<!-- : ( Grid ) (E) -->
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</form>
</body>
</html>