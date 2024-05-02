<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0924.jsp
*@FileTitle : Yard Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.29
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.05.29 최영희
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.event.EsmBkg0924Event"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.TSRemainListInputVO"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.Calendar"%>
<%@ page import="java.util.Date"%>

<%
	EsmBkg0924Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
    TSRemainListInputVO tSRemainListInputVO = null;
	String strLoc_cd = "";
	String strLoc_Yd_cd =""; 
    String strVps_etb_dt = "";
	String strVps_etd_dt = "";
	String strCnmv_sts_cds = "";
    String strCntr_tpsz_cds = "";
	String strVps_eta_dt = "";
	String strNext_vvd = "";
	String strYmd="";

	Logger log = Logger.getLogger("com.hanjin.apps.TransshipmentMgt.TransshipmentMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0924Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        tSRemainListInputVO = event.getTSRemainListInputVO();
		strLoc_cd=tSRemainListInputVO.getLocCd(); 
		strLoc_Yd_cd = tSRemainListInputVO.getLocYdCd();
		strVps_etb_dt = tSRemainListInputVO.getVpsEtbDt();
		strVps_etd_dt = tSRemainListInputVO.getVpsEtdDt();
		strCnmv_sts_cds = tSRemainListInputVO.getCnmvStsCds();
		strCntr_tpsz_cds = tSRemainListInputVO.getCntrTpszCds();
		strVps_eta_dt = tSRemainListInputVO.getVpsEtaDt();
		strNext_vvd = tSRemainListInputVO.getNextVvd();

		Date curDate = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(curDate);
		strYmd=cal.get(Calendar.YEAR)+"-"+((String.valueOf(cal.get(Calendar.MONTH)+1)).length()<2 ? "0"+(cal.get(Calendar.MONTH)+1):cal.get(Calendar.MONTH)+1 ) +"-"+cal.get(Calendar.DATE);

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Yard Summary</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
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
<input type="hidden" name="loc_cd" value="<%=strLoc_cd%>">
<input type="hidden" name="loc_yd_cd" value="<%=strLoc_Yd_cd%>"> 
<input type="hidden" name="vps_etb_dt" value="<%=strVps_etb_dt%>">
<input type="hidden" name="vps_etd_dt" value="<%=strVps_etd_dt%>">
<input type="hidden" name="cnmv_sts_cds" value="<%=strCnmv_sts_cds%>">
<input type="hidden" name="cntr_tpsz_cds" value="<%=strCntr_tpsz_cds%>">
<input type="hidden" name="vps_eta_dt" value="<%=strVps_eta_dt%>">
<input type="hidden" name="next_vvd" value="<%=strNext_vvd%>">

<!-- 개발자 작업	-->
<!-- OUTER - POPUP (S)tart -->
<table width="900" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;T/S Remain Status by Location_Yard Summary</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
				<table class="search" border="0" style="width:866;"> 
				<tr class="h23">
					<td width="" align="right" class="stm">Date : <%=strYmd%></td>
					</tr>
				</table>
				
				
				<!-- : ( Grid ) (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- : ( Grid ) (E) -->	
				<!-- : ( Button : Grid ) (S) -->
				<!--  Button_Sub (S) -->
			
	    	<!-- Button_Sub (E) -->
		    <!-- : ( Button : Grid ) (E) -->	
			
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
</td></tr>
</table> 

<table class="height_5"><tr><td></td></tr></table>
	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup">

				<table width="100%" class="button" border="0" cellpadding="0"
					cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
					<tr>
						<td class="btn3_bg">
								<table border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td width="">
												<table width="100%" border="0" cellpadding="0" cellspacing="0"
													class="button">
													<tr>
														<td class="btn1_left"></td>
														<td class="btn1" name="btn_Close">Close</td>
														<td class="btn1_right"></td>
													</tr>
												</table>
										</td>
									</tr>
								</table>
						<!--Button (E) --></td>
					</tr>
				</table>
				</td>
			</tr>
		</table>				
		<!-- : ( Button : pop ) (E) --> <!-- 개발자 작업  끝 -->
		</form></body>
</html>