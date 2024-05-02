<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0156.jsp
*@FileTitle : COD Application at BKG Office
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.27
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.07.27 최영희
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.event.EsmBkg0156Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO" %>
<%@ page import="com.hanjin.apps.alps.esm.bkg.common.*" %>
<%@ page import="com.hanjin.framework.core.controller.util.WebKeys"%>
<%@ page import="com.hanjin.framework.core.view.template.Screen"%>
<%@ page import="com.hanjin.framework.core.controller.DefaultViewAdapter"%>
<%
	EsmBkg0156Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strBkgNo			= "";
	String strBlNo			= "";
	String strcodRqstSeq    = "";
	String strPopFlg		= "";
	String strCodStsCd		= "";
	String screenName		= "";		
	String mainPage 		= "";
	String sXml = null;
	Logger log = Logger.getLogger("com.hanjin.apps.BookingCorrection.CODCorrection");
	
	//List<BkgComboVO> codReasonlist = null;
	//List<BkgComboVO> statuslist = null;
	//List<BkgComboVO> approvalRsolist = null;
	//List<BkgComboVO> rejectReasonlist = null;

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0156Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		strPopFlg = JSPUtil.getParameter(request, "popFlg");
		mainPage = JSPUtil.getNull(request.getParameter("mainPage"));
		if("S".equals(strPopFlg)){
			strBkgNo  		= JSPUtil.getParameter(request, "bkg_no");
			strBlNo   		= JSPUtil.getParameter(request, "bl_no");
			strcodRqstSeq 	= JSPUtil.getParameter(request, "cod_rqst_seq");
		} else {
			strBkgNo		= JSPUtil.getNull(event.getBkgBlNoVO().getBkgNo());
			strBlNo 		= JSPUtil.getNull(event.getBkgBlNoVO().getBlNo());
			strcodRqstSeq 	= JSPUtil.getNull(event.getCodRqstSeq());
			
			DefaultViewAdapter adapter = new DefaultViewAdapter();
			sXml = adapter.makeXML(request, response);
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>COD Application at BKG Office</title>
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
<form name="form" onkeyup="ComKeyEnter('lengthnextfocus');">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="popFlg" value="<%=strPopFlg%>"> 
<input type="hidden" name="codRemark"> 
<input type="hidden" name="codRjctRsnRmk">
<input type="hidden" name="oldBkgNo" value="<%=strBkgNo%>">
<input type="hidden" name="oldBlNo" value="<%=strBlNo%>">
<input type="hidden" name="oldCodRqstSeq" value="<%=strcodRqstSeq%>">
<input type="hidden" name="codStsCd"><!--cod의 현재 상태, 버튼 활성, 비활성화에 사용-->
<input type="hidden" name="saveModeCd" value="C"><!--C : CREATE, U : UPDATE-->
<input type="hidden" name="pctl_no" ><!--P/C를 실행한 결과-->
<input type="hidden" name="map_seq" ><!--P/C를 실행한 결과2-->
<input type="hidden" name="codRjctCd">
<input type="hidden" name="routeRow">
<input type="hidden" name="sXml" value="<%=JSPUtil.replace(sXml, "\"", "&quot;")%>">
<!-- Groupmail시 반영될 Hidden --> 
<input type="hidden" name="gw_subject">
<input type="hidden" name="gw_contents">
<input type="hidden" name="gw_template" value="ESM_BKG_COMM_01T.html">
<input type="hidden" name="gw_args" value="reqcontents;">
<input type="hidden" name="pgm_no" value="ESM_BKG_0156">

<input type="hidden" name="bkg_por_cd"> 
<input type="hidden" name="bkg_por_yd_cd">
<input type="hidden" name="bkg_pol_cd">
<input type="hidden" name="bkg_pol_yd_cd">
<input type="hidden" name="bkg_pod_cd">
<input type="hidden" name="bkg_pod_yd_cd">
<input type="hidden" name="bkg_del_cd">
<input type="hidden" name="bkg_del_yd_cd">
<input type="hidden" name="bkgStsCd">
<!-- RouteDetail시 반영될 Hidden Sheet -->
<input type="hidden" name="org_trns_mod_cd"  value="">
<input type="hidden" name="dest_trns_mod_cd" value="">

<input type="hidden" name="oldVslCd">
<input type="hidden" name="oldSkdVoyNo">
<input type="hidden" name="oldSkdDirCd">
<input type="hidden" name="oldPorYdCd">
<input type="hidden" name="oldPolYdCd">
<input type="hidden" name="oldPodYdCd">
<input type="hidden" name="oldDelYdCd">
<input type="hidden" name="newVslCd">
<input type="hidden" name="newSkdVoyNo">
<input type="hidden" name="newSkdDirCd">
<input type="hidden" name="newPorYdCd">
<input type="hidden" name="newPolYdCd">
<input type="hidden" name="newPodYdCd">
<input type="hidden" name="newDelYdCd"> 
<input type="hidden" name="newDeTermCd"> 
<input type="hidden" name="confirmFlg">
<input type="hidden" name="changePodFlg">
<input type="hidden" name="changeDelFlg">

<!-- mailbody의 항목 -->
<input type="hidden" name="eml_header">
<input type="hidden" name="rhnd_vvd">
<input type="hidden" name="rhnd_vvd_nm">
<input type="hidden" name="rhnd_vvd_voyage">
<input type="hidden" name="rhnd_port_cd">
<input type="hidden" name="rhnd_vvd_old_pol">
<input type="hidden" name="rhnd_vvd_old_pol_nm">
<input type="hidden" name="rhnd_vvd_old_pod">
<input type="hidden" name="rhnd_vvd_old_pod_nm">
<input type="hidden" name="rhnd_vvd_new_pod">
<input type="hidden" name="rhnd_vvd_new_pod_nm">
<!-- CA Reason hidden -->
<input type="hidden" name="ca_rsn_cd">
<input type="hidden" name="ca_remark">
<input type="hidden" name="port_skp_flg">
<input type="hidden" name="check_ts_close_flag">
<input type="hidden" name="cust_ntc_flg">
<input type="hidden" name="vsl_cng_rsn">

<input type="hidden" name="route_modify_flag">

<!-- 개발자 작업	-->
<% 
if(mainPage.equals("true")){
%>
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top: 2; padding-left: 5; padding-right:5;" >            
	<tr><td valign="top">
        <table width="100%" border="0" cellpadding="0" cellspacing="0"class="title">
            <tr><td class="history"><img src="img/icon_history_dot.gif"  align="absmiddle"><span id="navigation"></span></td>
            </tr>
            <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td>
            </tr>
        </table>
<%
}else {
%>     
<table width="100%" class="popup" cellpadding="10" border="0"> 
	<tr><td class="top"></td></tr>
	<tr><td valign="top">
		<table width="100%" border="0">
			<tr><td height="79" class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;<span id="title"></span></td></tr>
		</table>
<%
}
%>  
		<!--Page Title, Historical (E)-->
		<!--biz page (S)-->
		<table class="search"> 
       		<tr><td class="bg">

				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="50">BKG No.</td>
						<td width="160"><input type="text" style="width:100" value="<%=strBkgNo%>" class="input1" dataformat="engup" name="bkg_no" maxlength="13">&nbsp;</td>
						<td width="50">B/L No.</td>
						<td width="160"><input type="text" style="width:100" class="input1" dataformat="engup" name="bl_no"  value="<%=strBlNo%>" maxlength="13"></td>
						<td width="100"><input type="checkbox"  class="trans" name="rob_flag" value="N">ROB</td>
						<td width="100"><input type="checkbox"  class="trans" name="bdr_flag" disabled value="Y">BDR</td>
						<td width="60">Sequence</td>
						<td><select style="width:35;" class="input1" name="cod_rqst_seq" >&nbsp; 
							</select>&nbsp;</td>
						<td width="20"><input type="text" style="width:20" class="input2" name="max_seq"></td>
						<td width="240"></td>
					</tr>
				</table>
				<table class="line_bluedot">
					<tr><td>
					</td></tr>
				</table>
				
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
					<td width="690">	
						<table class="search" border="0" width="100%">
						<tr><td class="height_5"></td></tr>
						<tr><td class="title_h"></td>
					    <td class="title_s">COD Request Information</td>
					    </tr>
						</table>
					</td>
					<td>
						<table class="search" border="0" style="width:100%;"> 
						<tr class="h23">
						<td width="100">Auto&nbsp;<input type="text" style="width:30" class="input2_red" name="auto_cod_flg" readOnly></td>
						<td width="100">Manual&nbsp;<input type="text" style="width:30" class="input2_red" name="cod_mnl_flg" readOnly></td>
						<td>Approval&nbsp;<input type="text" style="width:30" class="input2_red" name="cod_auth_flg" readOnly></td></tr>
						</table>
					</td> 
					</tr>
					</table>
					<!-- Grid  (S) -->
				
					<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table> 			

				<!-- Grid (E) -->				
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="85">COD Reason</td>
						<td width="95"><script language="javascript">ComComboObject('cod_rqst_rsn_cd', 2, 80, 1, 1);</script>
						   <!--<select style="width:67;" class="input1" name="cod_rqst_rsn_cd">
							<option value="0" ></option>
							<option value="1"selected>SQ</option>
							<option value="1">CQ</option>
							<option value="1">TM</option>
							</select>--></td>
						
						<td width=""><table width="130" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left" style="padding:0;border:0;"></td>
							<td class="btn2" name="btn_remark" style="padding:0;border:0;" >COD Remark(s)</td>
							<td class="btn2_right" style="padding:0;border:0;"></td>
							</tr>
							</table>
						</td>
						<td><table border="0" cellpadding="0" cellspacing="0">
							<tr><td><div id="codRemarkView" style="visibility:hidden;position:absolute;overflow:hidden;width:100%; height:100%;"><iframe name="codRemarkIfrm" src="/hanjin/ESM_BKG_1009.do" width="320" height="200" marginWidth="0" marginHeight="0" scrolling="no" frameborder="0"></iframe></div></td>
							</tr>
						</table>
						</td>
					</tr>
					</table>
					<table class="height_8"><tr><td></td></tr></table>
					<!-- Grid  (S) -->
					<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet2');</script>
							</td>
<!-- 							<td width="19">&nbsp;</td> -->
						   	<td width="100" valign="bottom" style="display:none;">
<%if (!strPopFlg.equals("S")) {%>						   	
						   		<table width="90" border="0" cellpadding="0" cellspacing="0" class="button" >
									<tr><td class="btn2_left" style="padding:0;border:0;"></td>
										<td class="btn2" name="btn_pc" style="padding:0;border:0;">P/C</td>
										<td class="btn2_right" style="padding:0;border:0;"></td>
									</tr>
								</table><br>
<%} %>								
							</td> 
						</tr>
					</table> 			

					<!-- Grid (E) -->	
					<!--<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="860">
							<table width="100%" class="grid2"> 
								<tr class="tr2_head">
									<td width="13%">BKG Route</td>
									<td width="8%" colspan="2">POR</td>
									<td width="8%" colspan="2">POL</td>
									<td width="8%" colspan="2">POD	</td>
									<td width="8%" colspan="2">DEL	</td>
									<td width="8%" colspan="2">PRE</td>
									<td width="8%" colspan="2">POST</td>
									<td width="20%">T/VVD</td>
									<td width="%">Detail(s)	</td>
								</tr>
								<tr><td align="center" class="tr2_head2">OLD</td>
									<td align="center" class="input"><input type="text" style="width:45" class="noinput" name="old_por_yd_cd" disabled></td>
									<td align="center" class="input"><input type="text" style="width:30" class="noinput" name="" dataformat="engup"></td>
									<td align="center" class="input"><input type="text" style="width:45" class="noinput" name="old_pol_yd_cd" dataformat="engup"></td>
									<td align="center" class="input"><input type="text" style="width:30" class="noinput" name="" dataformat="engup"></td>
									<td align="center" class="input"><input type="text" style="width:45" class="noinput" name="" dataformat="engup"></td>
									<td align="center" class="input"><input type="text" style="width:30" class="noinput" name="" dataformat="engup"></td>
									<td align="center" class="input"><input type="text" style="width:45" class="noinput" name="" dataformat="engup"></td>
									<td align="center" class="input"><input type="text" style="width:30" class="noinput" name="" dataformat="engup"></td>
									<td align="center" class="input"><input type="text" style="width:45" class="noinput" name="" dataformat="engup"></td>
									<td align="center" class="input"><input type="text" style="width:30" class="noinput" name="" dataformat="engup"></td>
									<td align="center" class="input"><input type="text" style="width:45" class="noinput" name="" dataformat="engup"></td>
									<td align="center" class="input"><input type="text" style="width:30" class="noinput" name="" dataformat="engup"></td>
									<td align="center" class="input"><input type="text" style="width:75" class="noinput" name="" dataformat="engup"></td>
									<td align="center"><table width="90" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left" style="padding:0;border:0;"></td>
									<td class="btn2" name="" style="padding:0;border:0;"><a href="javascript:ComOpenWindow2('http://nis2010.hanjin.com/nis2010/grid/apps/nis2010/bkg/jsp/UI_BKG_0092.jsp','p','scrollbars=no,toolbar=no,location=no,resizable=yes,menubar=no, width=700,height=295,left=0,top=0');">T/S Route</a></td>
									<td class="btn2_right" style="padding:0;border:0;"></td></tr></table>
									</td>
								</tr>
								<tr><td align="center" class="tr2_head2">New</td>
									<td align="center" class="input"><input type="text" style="width:45" class="noinput" name="new_por_yd_cd" disabled></td>
									<td align="center" class="input"><input type="text" style="width:30" class="noinput" name="" dataformat="engup"></td>
									<td align="center" class="input"><input type="text" style="width:45" class="noinput" name="new_pol_yd_cd" dataformat="engup"></td>
									<td align="center" class="input"><input type="text" style="width:30" class="noinput" name="" dataformat="engup"></td>
									<td align="center" class="input"><input type="text" style="width:45" class="noinput" name="" dataformat="engup"></td>
									<td align="center" class="input"><input type="text" style="width:30" class="noinput" name="" dataformat="engup"></td>
									<td align="center" class="input"><input type="text" style="width:45" class="noinput" name="" dataformat="engup"></td>
									<td align="center" class="input"><input type="text" style="width:30" class="noinput" name="" dataformat="engup"></td>
									<td align="center" class="input"><input type="text" style="width:45" class="noinput" name="" dataformat="engup"></td>
									<td align="center" class="input"><input type="text" style="width:30" class="noinput" name="" dataformat="engup"></td>
									<td align="center" class="input"><input type="text" style="width:45" class="noinput" name="" dataformat="engup"></td>
									<td align="center" class="input"><input type="text" style="width:30" class="noinput" name="" dataformat="engup"></td>
									<td align="center" class="input"><input type="text" style="width:75" class="noinput" name="" dataformat="engup"></td>
									<td align="center"><table width="90" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr><td class="btn2_left" style="padding:0;border:0;"></td>
															<td class="btn2" name="btn_tsRoute" style="padding:0;border:0;">T/S Route</td>
															<td class="btn2_right" style="padding:0;border:0;"></td></tr></table>
									</td>
								</tr>
							</table> 
						</td>
						<td width="19">&nbsp;</td>
						<td width="100" valign="bottom"><table width="90" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left" style="padding:0;border:0;"></td>
							<td class="btn2" name="btn_pc" style="padding:0;border:0;">P/C</td>
							<td class="btn2_right" style="padding:0;border:0;"></td>
							</tr>
							</table></td>
					</tr>
					</table>-->
					<table class="search" border="0" style="width:979;"> 
						<tr class="h23">
							<td width="90">Approval RSO</td>
							<td width="" ><script language="javascript">ComComboObject('rgn_cd', 2, 80, 1, 1);</script>
							<!--<select style="width:67;" class="input1" name="rgn_cd" disabled>
								<option value="0" ></option>
								<option value="1"selected>AMR</option>
								<option value="1">ASR</option>
								<option value="1">EUR</option>
								</select>--></td>
						</tr>
					</table>				
					<table class="line_bluedot">
						<tr><td>
						</td></tr>
					</table>
					<table class="search" border="0">
						<tr><td class="height_5"></td></tr>
						<tr><td class="title_h"></td>
							<td class="title_s">Freight & Charges For COD</td>
						</tr>
					</table>
					<table class="search" border="0" style="width:979;"> 
						<tr class="h23">
							<td width="700" valign="top">
							<table class="search" border="0" style="width:700;"> 
								<tr>
									<td width="110"><strong>Re-handling Port</strong></td>
									<td width="90"><input type="text" style="width:70" value="" class="input1" name="cod_rhnd_port_cd" dataformat="engup" maxlength="7"></td>
									<td width="90">
										<table width="90" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left" style="padding:0;border:0;"></td>
												<td class="btn2" name="btn_calculation" style="padding:0;border:0;">Calculation</td>
												<td class="btn2_right" style="padding:0;border:0;"></td>
											</tr>
										</table></td>
									<td width="">&nbsp;</td>
								</tr>
							</table>							
							<!--grid (S)-->							
							<table width="100%"  id="mainTable"> 
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('sheet3');</script>
									</td>
								</tr>
							</table> 
							</td>
							<td width="19">&nbsp;</td>
							<td width="260" valign="top">
								<table class="search" border="0" style="width:;"> 
									<tr class="h23">
										<td width="240" align="center">
											<table width="110" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn2_left" style="padding:0;border:0;"></td>
													<td class="btn2" name="btn_Inquiry" style="padding:0;border:0;">Tariff Inquiry</td>
													<td class="btn2_right" style="padding:0;border:0;"></td>
												</tr>
											</table>
										</td>
									<td width="">&nbsp;</td>
									</tr>
								</table>
								<!--grid (S)-->							
								<table width="100%"  id="mainTable"> 
									<tr>
										<td width="100%">
											<script language="javascript">ComSheetObject('sheet4');</script>
										</td>
									</tr>
								</table> 							
								<!--grid (E)-->								
							</td>
						</tr>
					</table>
							<table class="search" border="0" style="width:900;"> 
								<tr>
									<td  class="stm">* Estimated Re-handling Cost - calculation based on Stevedorage(Loading/Discharging Cost) only. Additional charges may apply based on circumstance.</td>
									</tr>
									<tr>
									<td  style="width: 100%; font-weight:bold; color:red" class="stm">* You don’t need to calculate re-handling cost if stowage information has not transmitted. RSO will inform re-handling cost after your request.</td>
								</tr>
							</table>	
					<table class="line_bluedot">
						<tr><td>
						</td></tr>
					</table>
					<table class="search" border="0">
						<tr><td class="height_5"></td></tr>
						<tr><td class="title_h"></td>
							<td class="title_s">Request Status</td>
						</tr>
					</table>		
					<!--grid (S)-->
					<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet5');</script>
							</td>
						</tr>
					</table>  
					<!--grid (E)-->
					<!--<table width="100%" class="grid2"> 
					<tr class="tr2_head">
						<td width="15%">Status</td>
						<td width="15%">Date</td>
						<td width="14%">By</td>
						<td width="15%">Office	</td>
						<td width="15%">New Read</td>
						<td width="%">Previous</td>
					</tr>
					<tr>
						<td align="center" class="input2"><input type="text" style="width:120" value="" class="noinput2">&nbsp;<img src="img/btns_inquiry.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
						<td align="center" class="input2"><input type="text" style="width:75" value="" class="noinput2"></td>
						<td align="center" class="input2"><input type="text" style="width:75" value="" class="noinput2"></td>
						<td align="center" class="input2"><input type="text" style="width:75" value="" class="noinput2"></td>
						<td align="center" class="input2"><input type="text" style="width:75" value="" class="noinput2"></td>
						<td align="center" class="input2"><input type="text" style="width:75" value="" class="noinput2"></td>
					</tr>
					</table> -->
		
					<table class="search" border="0" style="width:979;"> 
						<tr class="h23">
							<td width="90">Reject Reason</td>
							<td width="600"><script language="javascript">ComComboObject('cod_rjct_cd', 2, 560, 1, 1, 1);</script>
							<!--<input type="text" style="width:560" class="input2" name="cod_rjct_cd" dataformat="engup" disabled>&nbsp;<img src="img/btns_inquiry.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">--></td>
							<td width="90">
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
										<td class="btn2" name="btn_history">History</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
							</td>
							<td width="190">
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
										<td class="btn2" name="btn_reject">Reject Reason Remarks</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
							</td>
							<td>
								<table border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td><div id="codRemarkView1" style="visibility:hidden;position:absolute;overflow:hidden;width:100%; height:100%;"><iframe name="codRemarkIfrm1" src="/hanjin/ESM_BKG_1009.do?isPop=R" width="320" height="200" marginWidth="0" marginHeight="0" scrolling="no" frameborder="0"></iframe></div></td>
									</tr>
								</table>
							</td>
						</tr> 
					</table>
						<!--  biz_1   (E) -->
				</td></tr>
			</table>
			
	<!--biz page (E)-->
	<!--Button (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
	       		<tr><td class="btn1_bg">
				    <table border="0" cellpadding="0" cellspacing="0">
					    <tr>
					    	<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
									<td class="btn1_right"></td>
								</tr>
							</table></td>
<%if (strPopFlg.equals("S")) {%>
							<td style="visibility:hidden;">
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr> 
										<td class="btn1" name="btn_new"></td>
										<td class="btn1" name="btn_save"></td>
										<td class="btn1" name="btn_add"></td>
										<td class="btn1" name="btn_del"></td>
										<td class="btn1" name="btn_request"></td>
										<td class="btn1" name="btn_approve"></td>
										<td class="btn1" name="btn_cancel"></td>
										<td class="btn1" name="btn_bkg_main"></td>
										<td class="btn1" name="btn_confirm"></td>
									</tr>
								</table>
							</td>	
<%}else{%>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn_new">New</td>
									<td class="btn1_right"></td>
								</tr>
							</table></td>
							<td class="btn1_line" ></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn_save">Save</td>
									<td class="btn1_right"></td>
								</tr>
							</table></td>
<%if (strPopFlg.equals("S")){%>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn_close">Close</td>
									<td class="btn1_right"></td>
								</tr>
							</table></td>
<%}%>
				
							<td class="btn1_line" ></td>
							<td ><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_add">Add Seq.</td>
								<td class="btn1_right"></td>
								</tr>
							</table></td>
							<td ><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_del">Delete Seq.</td>
								<td class="btn1_right"></td>
								</tr>
							</table></td>
							
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_request">Request</td>
								<td class="btn1_right"></td>
								</tr>
							</table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_approve">Approve(Manual)</td>
								<td class="btn1_right"></td>
								</tr>
							</table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_cancel">Cancel</td>
								<td class="btn1_right"></td>
								</tr>
							</table></td> 
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_bkg_main"> BKG Main</td>
								<td class="btn1_right"></td>
								</tr>
							</table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_confirm">Confirm</td>
								<td class="btn1_right"></td>
								</tr>
							</table></td>
<%}%> 
						</tr>
					</table>
				    <!--Button (E) -->
					<!--grid (S)-->
					<table width="0"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet6');</script>
							</td>
						</tr>
					</table> 
				    <table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet7');</script>
							</td>
						</tr>
					</table> 
					<table width="0"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet8');</script>
							</td>
						</tr>
					</table> 
					<table width="0"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet9');</script>
							</td>
						</tr>
					</table> 
					<!--grid (E)--> 
				</td>
			</tr>
		</table>
<%
if(!mainPage.equals("true")){
%>
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
			
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       		<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    	<tr>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td>
										<td class="btn1" name="btn_Close" onClick="self.close()">Close</td>
										<td class="btn1_right"></td>
									</tr>
								</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<script>
	if(typeof(document.getElementById("title")) != "undefined"){
		document.getElementById("title").innerHTML = curTitle;
		document.body.className ="popup_bg";
	}
</script>
<%
}
%>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp"%>