<%
/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ESM_MAS_0162.jsp
*@FileTitle : Revenue Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.28
*@LastModifier : Young-Heon Lee
*@LastVersion : 1.0
* 2016.06.22 Young-Heon Lee
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
<%@ page import="org.apache.log4j.Logger" %>

<%
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String por_cd		= null;
	String pol_cd		= null;
	String pod_cd		= null;
	String del_cd		= null;
	String r_term		= null;
	String d_term		= null;
	String cntr_tpsz_cd = null;
	String cntr_qty = null; 
	String calllFunc = null;
	
	String strUsr_id		= "";
	String strUsr_nm		= "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		por_cd		= JSPUtil.getParameter(request,"f_por_cd");
		pol_cd		= JSPUtil.getParameter(request,"f_pol_cd");
		pod_cd		= JSPUtil.getParameter(request,"f_pod_cd");
		del_cd		= JSPUtil.getParameter(request,"f_del_cd");
		r_term		= JSPUtil.getParameter(request,"f_r_term");
		d_term		= JSPUtil.getParameter(request,"f_d_term");
		cntr_tpsz_cd		= JSPUtil.getParameter(request,"f_cntr_tpsz_cd");
		cntr_qty		= JSPUtil.getParameter(request,"f_qty");
		calllFunc	= JSPUtil.getParameter(request,"func");
		
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		//GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Revenue Detail</title>
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
<!-- 개발자 작업	-->
<input type="hidden" name="por_cd" value="<%=por_cd%>">
<input type="hidden" name="pol_cd" value="<%=pol_cd%>">
<input type="hidden" name="pod_cd" value="<%=pod_cd%>">
<input type="hidden" name="del_cd" value="<%=del_cd%>">
<input type="hidden" name="r_term"  value="<%=r_term%>">
<input type="hidden" name="d_term" value="<%=d_term%>">
<input type="hidden" name="cntr_tpsz_cd" value="<%=cntr_tpsz_cd%>">
<input type="hidden" name="cntr_qty" value="<%=cntr_qty%>">
<input type="hidden" name="upd_usr_nm" value="<%=strUsr_nm%>">
<input type="hidden" name="calllFunc" value="<%=calllFunc%>">

<input type="hidden" name="por_def_cd">
<input type="hidden" name="pol_def_cd">
<input type="hidden" name="pod_def_cd">
<input type="hidden" name="del_def_cd">
<input type="hidden" name="prc_rcv_term_cd">
<input type="hidden" name="prc_de_term_cd">
<input type="hidden" name="rat_ut_cd">
<input type="hidden" name="eff_dt">
<input type="hidden" name="exp_dt">
<input type="hidden" name="org_tp_cd" value="L">
<input type="hidden" name="org_cd" value="">
<input type="hidden" name="dest_tp_cd" value="L">
<input type="hidden" name="dest_cd" value="">
<input type="hidden" name="prc_cgo_tp_cd" value="">

<!-- OUTER - POPUP (S)tart -->
<table width="900" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; Revenue Detail</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
						<table class="search" border="0">
							<tr><td class="title_h"></td>
							<td class="title_s">Applicable Route</td>
							<td width="110" >&nbsp;&nbsp;<b>SVC Scope</b></td>
							<td width="100"><script language="javascript">ComComboObject('svc_scp_cd', 2, 80, 0, 1, 0, false);</script></td>
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
				
				<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_SchgDtl">Retrieve</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
				
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
				
				
						<table class="search" border="0">
							<tr><td class="title_h"></td>
							<td class="title_s">Surcharge Detail</td></tr>
						</table>
						<!-- : ( Grid ) (S) -->
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet2');</script>
								</td>
							</tr>
						</table> 
				<!-- : ( Grid ) (E) -->	
				<table class="search" border="0" style="width:100%;"> 
    				<tr class="h23">
    					<td width="80" >Remark(s)</td>
    					<td class="SM">
    					&raquo; [Schg Detail] is not related to Auto-rating. <br></td>   					
    				</tr>	
    				</table>
    									
				<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Add">Row Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Delete">Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Save">Save</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td class="btn1_line"></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td><td class="btn2" id="btn_downexcel" name="btn_downexcel">Down Excel</td><td class="btn2_right"></td></tr></table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->

	</td></tr>
		</table>
<!-- : ( Button : pop ) (S) -->


<table class="height_5"><tr><td></td></tr></table>

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
					</table>
			</td>
		</tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
	
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>