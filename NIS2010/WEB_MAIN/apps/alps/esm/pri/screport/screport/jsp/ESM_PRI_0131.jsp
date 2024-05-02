<%
/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ESM_PRI_0131.jsp
*@FileTitle : Charge Summary Report - BL Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.27
*@LastModifier : 이혜민
*@LastVersion : 1.0
*=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.screport.screport.event.EsmPri0131Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri0131Event  event = null;			//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();

		event = (EsmPri0131Event)request.getAttribute("Event");
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
<% 
String f_year = JSPUtil.getNull(request.getParameter("f_year"));	
String f_fm_wk = JSPUtil.getNull(request.getParameter("f_fm_wk"));	
String f_to_wk = JSPUtil.getNull(request.getParameter("f_to_wk"));	
String f_fm_mon = JSPUtil.getNull(request.getParameter("f_fm_mon"));	
String f_to_mon = JSPUtil.getNull(request.getParameter("f_to_mon"));	
String start_dt = JSPUtil.getNull(request.getParameter("start_dt"));	
String end_dt = JSPUtil.getNull(request.getParameter("end_dt"));	
String f_sls_mon = JSPUtil.getNull(request.getParameter("f_sls_mon"));	
String rvis_cntr_cust_tp_cd = JSPUtil.getNull(request.getParameter("rvis_cntr_cust_tp_cd"));	
String ctrt_cust_cnt_cd = JSPUtil.getNull(request.getParameter("ctrt_cust_cnt_cd"));	
String ctrt_cust_seq = JSPUtil.getNull(request.getParameter("ctrt_cust_seq"));	
String rep_chg_cd = JSPUtil.getNull(request.getParameter("rep_chg_cd"));	
String chg_cd = JSPUtil.getNull(request.getParameter("chg_cd"));	
String mdtr_cd = JSPUtil.getNull(request.getParameter("mdtr_cd"));
String cust_clss = JSPUtil.getNull(request.getParameter("cust_clss"));
String cust_grp_id = JSPUtil.getNull(request.getParameter("cust_grp_id"));
String svc_scp_cd = JSPUtil.getNull(request.getParameter("svc_scp_cd"));
String ctrt_ofc_cd = JSPUtil.getNull(request.getParameter("ctrt_ofc_cd"));
String per_cd = JSPUtil.getNull(request.getParameter("per_cd"));
String rhq_cd = JSPUtil.getNull(request.getParameter("rhq_cd"));
String bkg_ofc_cd = JSPUtil.getNull(request.getParameter("bkg_ofc_cd"));
String por_cd = JSPUtil.getNull(request.getParameter("por_cd"));
String pol_cd = JSPUtil.getNull(request.getParameter("pol_cd"));
String pod_cd = JSPUtil.getNull(request.getParameter("pod_cd"));
String del_cd = JSPUtil.getNull(request.getParameter("del_cd"));
String cgo_cate_cd = JSPUtil.getNull(request.getParameter("cgo_cate_cd"));
String ui_id = JSPUtil.getNull(request.getParameter("ui_id"));

%>
<html>
<head>
<title>Charge Summary Report - BL Inquiry</title>
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

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="f_year" value="<%=f_year%>">
<input type="hidden" name="f_fm_wk" value="<%=f_fm_wk%>">
<input type="hidden" name="f_to_wk" value="<%=f_to_wk%>">
<input type="hidden" name="f_fm_mon" value="<%=f_fm_mon%>">
<input type="hidden" name="f_to_mon" value="<%=f_to_mon%>">
<input type="hidden" name="start_dt" value="<%=start_dt%>">
<input type="hidden" name="end_dt" value="<%=end_dt%>">
<input type="hidden" name="f_sls_mon" value="<%=f_sls_mon%>">
<input type="hidden" name="rvis_cntr_cust_tp_cd" value="<%=rvis_cntr_cust_tp_cd%>">
<input type="hidden" name="ctrt_cust_cnt_cd" value="<%=ctrt_cust_cnt_cd%>">
<input type="hidden" name="ctrt_cust_seq" value="<%=ctrt_cust_seq%>">
<input type="hidden" name="rep_chg_cd" value="<%=rep_chg_cd%>">
<input type="hidden" name="chg_cd" value="<%=chg_cd%>">
<input type="hidden" name="mdtr_cd" value="<%=mdtr_cd%>">
<input type="hidden" name="cust_clss" value="<%=cust_clss%>">
<input type="hidden" name="cust_grp_id" value="<%=cust_grp_id%>">
<input type="hidden" name="svc_scp_cd" value="<%=svc_scp_cd%>">
<input type="hidden" name="ctrt_ofc_cd" value="<%=ctrt_ofc_cd%>">
<input type="hidden" name="per_cd" value="<%=per_cd%>">
<input type="hidden" name="rhq_cd" value="<%=rhq_cd%>">
<input type="hidden" name="bkg_ofc_cd" value="<%=bkg_ofc_cd%>">
<input type="hidden" name="por_cd" value="<%=por_cd%>">
<input type="hidden" name="pol_cd" value="<%=pol_cd%>">
<input type="hidden" name="pod_cd" value="<%=pod_cd%>">
<input type="hidden" name="del_cd" value="<%=del_cd%>">
<input type="hidden" name="cgo_cate_cd" value="<%=cgo_cate_cd%>">
<input type="hidden" name="ui_id" value="<%=ui_id%>">
<input type="hidden" name="jb_id" >


<!-- 개발자 작업	-->
<table width="100%" class="popup" cellpadding="10" border="0">
	<tr>
		<td class="top"></td>
	</tr>
	<tr>
		<td valign="top">
			<!-- : ( Title ) (S) -->
			<table width="100%" border="0">
				<tr>
					<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Charge Summary Report - BL Inquiry</td>
				</tr>
			</table>
			<!-- : ( Title ) (E) -->
			<table class="search" id="mainTable"> 
	       		<tr>
	       			<td class="bg">	
						<!-- Grid  (S) -->
						<table width="100%"  id="mainTable">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table>
						<!-- Grid (E) -->
					</td>
				</tr>
			</table>			
		</td>
	</tr>
</table>
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup">
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       			<tr>
       				<td class="btn3_bg">
		    			<table border="0" cellpadding="0" cellspacing="0">
		    				<tr>
								<td>
									<table width="105" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Downexcel">Down Excel</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Close">Close</td>
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
<!-- : ( Button : pop ) (E) -->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>