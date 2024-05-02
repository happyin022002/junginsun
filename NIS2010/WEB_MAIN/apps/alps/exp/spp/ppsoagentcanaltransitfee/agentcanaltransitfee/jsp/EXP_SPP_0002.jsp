<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EXP_SPP_0002.jsp
*@FileTitle : Request Advance Payment
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 김성광
*@LastVersion : 1.0
* 2009.07.22 김성광
* 1.0 Creation
*  
* History
* 2012.02.17 박연진 CHM-201216307 SPP 및 PSO내 Canal invoice 화면 변경 및 File upload 기능 개발 
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.core.config.SiteConfigFactory"%>
<%@ page import="com.hanjin.framework.component.util.io.FileUtils"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.event.ExpSpp0002Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	ExpSpp0002Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	String vndrSeq = "";
	String vvd = "";
	String vslNm = "";
	String ydCd = "";
	String callSeq = "";
	String revYrmon = "";
	String diffRmk = "";
	String vndrCntCd = "";
	
	String vslCd = "";
	String skdVoyNo = "";
	String skdDirCd = "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		
		event = (ExpSpp0002Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		//Main 화면에서 설정된 request값을 가져온다.
		vndrSeq 	= (String) request.getParameter("vndrSeq");  //"100870";  //
		vvd	    	= (String) request.getParameter("vvd");  //"HJAA0002E";  //
		vslNm   	= (String) request.getParameter("vslNm");  //"HANJIN ATLANTA";  //
		ydCd    	= (String) request.getParameter("ydCd");  //"EGSUZT1";  //
		callSeq 	= (String) request.getParameter("callSeq");  //"1";  //
		revYrmon 	= (String) request.getParameter("revYrmon");  //"200905";  //
		diffRmk 	= (String) request.getParameter("diffRmk");  //"Rejected";  //
		vndrCntCd	= (String) request.getParameter("vndrCntCd");  //"PA";  //
		vslCd = vvd.substring(0,4);
		skdVoyNo = vvd.substring(4,8);
		skdDirCd = vvd.substring(8);		
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Advance Payment Request</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<script language="javascript">
	//ComDebug("<%=vndrSeq+"/"+vvd+"/"+ydCd+"/"+callSeq+"/"+revYrmon+"/"+session.getId()%>");
		
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
<input type="hidden" name="pagerows" value="<%=pageRows%>">
<!-- opener 에서 넘겨받은 값 -->
<input type="hidden" name="vndr_seq" value="<%=vndrSeq%>" />
<input type="hidden" name="vvd" value="<%=vvd%>" />
<input type="hidden" name="yd_cd" value="<%=ydCd%>" />
<input type="hidden" name="call_seq" value="<%=callSeq%>" />
<input type="hidden" name="ntc_yrmon" value="<%=revYrmon%>" />
<input type="hidden" name="diff_rmk" value="<%=diffRmk%>" />
<input type="hidden" name="rev_yrmon" value="<%=revYrmon%>" />
<!-- 조회 후 저장되는 ADV Payment Status 값. -->
<input type="hidden" name="cnl_tz_proc_sts_cd" />
<!-- 기타 -->
<input type="hidden" name="cnl_tz_bztp_cd" value="E" />
<input type="hidden" name="vsl_cd" value="<%=vslCd%>" />
<input type="hidden" name="skd_voy_no" value="<%=skdVoyNo%>" />
<input type="hidden" name="skd_dir_cd" value="<%=skdDirCd%>" />
<input type="hidden" name="vndr_cnt_cd" value="<%=vndrCntCd%>" />

<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Advance Payment Request</td></tr>
		</table>
	<!--Page Title, Historical (E)-->
	
	
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
       	
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="100">VVD</td>
					<td width="200"><input name="vvdText" type="text" style="width:180;text-align:center;" class="input2" value="<%=vslNm+" "+skdVoyNo+skdDirCd%>" readonly></td>
					<td width="170">ADV. Payment TTL Amount</td>
					<td width="100"><input name="ttl_amt" type="text" dataformat="float" maxlength="15" pointcount="2" style="width:80;text-align:center" class="input"></td>
					<td width="120">&nbsp;</td>
					<td width="">&nbsp;</td>
				</tr>
				</table>
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
				 <%
				 if(vndrCntCd.equalsIgnoreCase("PA")){
				 %>
					<td width="100">Allowance TEU</td>
					<td width="" colspan="5"><input name="cntr_pnm_capa" type="text" dataformat="float" maxlength="18" pointcount="3" style="width:80;text-align:center" class="input2" readonly></td>
				<%
				 }else{
				%>
					<td width="100">SCNT</td>
					<td width="200"><input name="suz_net_tong_wgt" type="text" dataformat="float" maxlength="9" pointcount="2" style="width:85;text-align:center" class="input"></td>
					<td width="170">SDR</td>
					<td width="100"><input name="locl_xch_rt" type="text" dataformat="float" maxlength="8" pointcount="5" style="width:80;text-align:center" class="input"></td>
					<td width="120">Tier</td>
					<td width=""><input name="tr_vol_val" type="text" dataformat="int" maxlength="1" style="width:60;text-align:center" class="input"></td>
				<%
				 }
				%>	
				</tr>
				</table>
				<!--  biz_1   (E) -->
				
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
				
				<!--  biz_2  (S) -->

				<!-- Grid  (S) -->
					<table width="100%"  id="mainTable">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
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
							<td class="btn2" name="btn_DownExcel" width="70">Down Excel</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
						</tr></table>
				</td></tr>
				</table>
		    	<!-- Button_Sub (E) -->				
				
				<!--  biz_2   (E) -->
				
			</td></tr>
		</table>
	
	<!--biz page (E)-->
	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Request" id="btn_Request">Request</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save" id="btn_Save">Save</td>
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
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>