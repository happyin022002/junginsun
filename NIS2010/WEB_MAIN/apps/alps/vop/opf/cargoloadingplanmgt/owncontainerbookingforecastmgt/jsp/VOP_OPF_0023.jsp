<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_opf_0023.jsp
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.13
*@LastModifier : 김도현
*@LastVersion : 1.0
* 2015.10.13 김도현
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
<%@ page import="com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.event.VopOpf0022Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>

<%
	VopOpf0022Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList    = "";
	String pageRows    = "100";

	String strUsr_id   = "";
	String strUsr_nm   = "";
	Logger log = Logger.getLogger("com.hanjin.apps.CargoLoadingPlanMgt.OwnContainerBookingForecastMgt");
	
	String vsl_cd      		= StringUtil.xssFilter(request.getParameter("vsl_cd"))== null?"":StringUtil.xssFilter(request.getParameter("vsl_cd"));
	String skd_voy_no      	= StringUtil.xssFilter(request.getParameter("skd_voy_no"))== null?"":StringUtil.xssFilter(request.getParameter("skd_voy_no"));
	String skd_dir_cd      	= StringUtil.xssFilter(request.getParameter("skd_dir_cd"))== null?"":StringUtil.xssFilter(request.getParameter("skd_dir_cd"));
	String yd_cd      		= StringUtil.xssFilter(request.getParameter("yd_cd"))== null?"":StringUtil.xssFilter(request.getParameter("yd_cd"));
	String pol_clpt_ind_seq = StringUtil.xssFilter(request.getParameter("pol_clpt_ind_seq"))== null?"":StringUtil.xssFilter(request.getParameter("pol_clpt_ind_seq"));
	String crr_cd 			= StringUtil.xssFilter(request.getParameter("crr_cd"))== null?"":StringUtil.xssFilter(request.getParameter("crr_cd"));
	String pod_cd      		= StringUtil.xssFilter(request.getParameter("pod_cd"))== null?"":StringUtil.xssFilter(request.getParameter("pod_cd"));
	String blck_stwg_cd     = StringUtil.xssFilter(request.getParameter("blck_stwg_cd"))== null?"":StringUtil.xssFilter(request.getParameter("blck_stwg_cd"));
	String cbf_spcl_smry_seq= StringUtil.xssFilter(request.getParameter("cbf_spcl_smry_seq"))== null?"":StringUtil.xssFilter(request.getParameter("cbf_spcl_smry_seq"));
	String imdg_un_no		= StringUtil.xssFilter(request.getParameter("imdg_un_no"))== null?"":StringUtil.xssFilter(request.getParameter("imdg_un_no"));
	String imdg_clss_cd		= StringUtil.xssFilter(request.getParameter("imdg_clss_cd"))== null?"":StringUtil.xssFilter(request.getParameter("imdg_clss_cd"));
	String imdg_subs_rsk_lbl_cd= StringUtil.xssFilter(request.getParameter("imdg_subs_rsk_lbl_cd"))== null?"":StringUtil.xssFilter(request.getParameter("imdg_subs_rsk_lbl_cd"));
	String mrn_polut_flg	= StringUtil.xssFilter(request.getParameter("mrn_polut_flg"))== null?"":StringUtil.xssFilter(request.getParameter("mrn_polut_flg"));
	String imdg_lmt_qty_flg	= StringUtil.xssFilter(request.getParameter("imdg_lmt_qty_flg"))== null?"":StringUtil.xssFilter(request.getParameter("imdg_lmt_qty_flg"));

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (VopOpf0022Event)request.getAttribute("Event");
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
<title>DG-Cargo Information</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	var userId = '<%=strUsr_id%>';
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="condition_gb" value="manageSOverDms">
<input type="hidden" name="vsl_cd" value="<%=vsl_cd%>">
<input type="hidden" name="skd_voy_no" value="<%=skd_voy_no%>">
<input type="hidden" name="skd_dir_cd" value="<%=skd_dir_cd%>">
<input type="hidden" name="yd_cd" value="<%=yd_cd%>">
<input type="hidden" name="pol_clpt_ind_seq" value="<%=pol_clpt_ind_seq%>">
<input type="hidden" name="crr_cd" value="<%=crr_cd%>">
<input type="hidden" name="pod_cd" value="<%=pod_cd%>">
<input type="hidden" name="blck_stwg_cd" value="<%=blck_stwg_cd%>">
<input type="hidden" name="cbf_spcl_smry_seq" value="<%=cbf_spcl_smry_seq%>">
<input type="hidden" name="param_imdg_un_no" value="<%=imdg_un_no%>">
<input type="hidden" name="param_imdg_clss_cd" value="<%=imdg_clss_cd%>">
<input type="hidden" name="param_imdg_subs_rsk_lbl_cd" value="<%=imdg_subs_rsk_lbl_cd%>">
<input type="hidden" name="param_mrn_polut_flg" value="<%=mrn_polut_flg%>">
<input type="hidden" name="param_imdg_lmt_qty_flg" value="<%=imdg_lmt_qty_flg%>">
<input type="hidden" name="imdg_un_no">
<input type="hidden" name="imdg_subs_rsk_lbl_cd">

<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">	
	<tr>
		<td valign="top">
			<!--Page Title, Historical (S)->
			<!--Page Title, Historical (E)-->
			<!--Button (S) -->
    		<!--Button (E) -->
			<!--biz page (S)-->
			
   			<table class="height_8"><tr><td></td></tr></table>
			<!-- Tab (S) -->
			<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%>
			<tr>
				<td width=38%>	
	    			<table class="" border="0" cellpadding="0" cellspacing="0" width="100%" id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t1sheet1');</script>
						</td>
					</tr>
					</table>
					<!--  Button_Sub (S) -->
					<table width="100%" class="button"> 
	       				<tr>
	       					<td class="btn2_bg">
								<table border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td>
											<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr>
													<td class="btn2_left"></td>
													<td class="btn2" name="btn_RowAdd">Row Add</td>
													<td class="btn2_right"></td>
												</tr>
											</table>
										</td>
										<td>
											<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr>
													<td class="btn2_left"></td>
													<td class="btn2" name="btn_RowDelete">Row Delete</td>
													<td class="btn2_right"></td>
												</tr>
											</table>
										</td>
										<td>
											<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr>
													<td class="btn2_left"></td>
													<td class="btn2" name="btn_Save">Save</td>
													<td class="btn2_right"></td>
												</tr>
											</table>
										</td>
										<td>
											<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr>
													<td class="btn2_left"></td>
													<td class="btn2" name="btn_close">CLOSE</td>
													<td class="btn2_right"></td>
												</tr>
											</table>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
	    			<!-- Button_Sub (E) --> 
			</td>
			<td width=3%>&nbsp;</td>
			</tr>
			</table>
			<!-- Tab BG Box(E) -->
			<!--biz page (E)-->
			<table class="height_10"><tr><td></td></tr></table>
		</td>
	</tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>