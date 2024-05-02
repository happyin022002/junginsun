<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_opf_0037.jsp
*@FileTitle : Excludefrom TPR Save
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2009.07.06 장석현
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
<%@ page import="com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.event.VopOpf0037Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%
	VopOpf0037Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String strOpenerReson	= "";
	Logger log = Logger.getLogger("com.hanjin.apps.CargoLoadingResultMgt.TerminalDepartureReport");

	String vsl_cd			=	StringUtil.xssFilter(request.getParameter("vsl_cd"));
	String skd_voy_no		=	StringUtil.xssFilter(request.getParameter("skd_voy_no"));
	String skd_dir_cd		=	StringUtil.xssFilter(request.getParameter("skd_dir_cd"));
	String clpt_ind_seq		=	StringUtil.xssFilter(request.getParameter("clpt_ind_seq"));
	String port_cd			=	StringUtil.xssFilter(request.getParameter("port_cd"));

	String authbtn          =   StringUtil.xssFilter(request.getParameter("authbtn"))==null?"":StringUtil.xssFilter(request.getParameter("authbtn"));
	String sTitle        =   "Creation";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (VopOpf0037Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
        if(!authbtn.equals("")){
            sTitle = "Inquiry";
        }
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}

	// 현재날짜
	String strCurdate = DateTime.getFormatDate(new Date(), "yyyy-MM-dd HH:mm");
%>

<html>
<head>
<title>Restow Reason Code Help</title>


<script language="javascript">

    function setupPage(){  

	    loadPage();
    }

</script>


<body class="popup_bg" onLoad="setupPage();"> 

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="vsl_cd" value="<%=vsl_cd%>">
<input type="hidden" name="skd_voy_no" value="<%=skd_voy_no%>">
<input type="hidden" name="skd_dir_cd" value="<%=skd_dir_cd%>">
<input type="hidden" name="clpt_ind_seq" value="<%=clpt_ind_seq%>">
<input type="hidden" name="port_cd" value="<%=port_cd%>">
<input type="hidden" name="status1" value="<%=authbtn%>">
<input type="hidden" name="tml_prod_rpt_rsn_cd" value="">



<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="./img/icon_title_dot.gif" align="absmiddle">&nbsp;Reason Selection for Excluding from TPR (<%=sTitle %>)
</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
				<table class="search" border="0" style="width:466;"> 
				<tr class="h23">
					<td width="25">ID</td>
					<td width="100"><input type="text" style="width:66;" class="input2" value=" <%=strUsr_id%>" readonly></td>
					<td width="75">Office Code</td>
					<td width="100"><input type="text" style="width:66;" class="input2" value=" <%=strOfc_cd%>" readonly></td>
					<td width="35">Date</td>
					<td width=""><input type="text" style="width:117;" class="input2" value=" <%=strCurdate%>" readonly></td></tr>
				</table>
				
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
				
				
				<!-- : ( Grid ) (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- : ( Grid ) (E) -->	
				 <table class="height_8"><tr><td></td></tr></table>	
				<table width="100%" class="grid2"> 
			<tr class="tr2_head">
				<td width="15%" rowspan="2">Remark(s)</td>
				<td><textarea cols="" rows="5" style="width:100%" name="tml_prod_rpt_rsn_rmk" style="ime-mode:disabled"></textarea></td></tr>
				</table> 
				<!-- : ( Button : Grid ) (S) -->
				<!--  Button_Sub (S) -->
			<table width="100%" class="button" id="btn_save_table"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Save" id="btn_Save"> Save</td>
						<td class="btn2_right"></td>
					</tr></table>
			</td></tr>
			</table>

	    	<!-- Button_Sub (E) -->
		    <!-- : ( Button : Grid ) (E) -->	
			
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
</td></tr>
</table> 

<table class="height_5"><tr><td></td></tr></table>
	</td></tr>
</table> 
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				
			<td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right"></td>
			</tr>
			</table>
		</td></tr>
		</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

</form>
</body>
</html>