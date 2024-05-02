<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1048.jsp
*@FileTitle : China: Customs Result View
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier : 오동현
*@LastVersion : 1.0
* 2009.09.18 오동현
* 1.0 Creation
=========================================================*/%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
    String rcv_snd_div_cd = "";
    String sheet_msg_snd_dt = "";
    String sheet_bl_no = "";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String edi_ref_id		= "";
	String vvd_cd			= "";
	String pol_cd			= "";
	String pod_cd			= "";
	//Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");
	
	try {
	   	//SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		//strUsr_id =	account.getUsr_id();
		//strUsr_nm = account.getUsr_nm();
		
		edi_ref_id = request.getParameter("edi_ref_id")==null?"":request.getParameter("edi_ref_id");
		vvd_cd = request.getParameter("vvd_cd")==null?"":request.getParameter("vvd_cd");
		pol_cd = request.getParameter("pol_cd")==null?"":request.getParameter("pol_cd");
		pod_cd = request.getParameter("pod_cd")==null?"":request.getParameter("pod_cd");
		
		//serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		//if (serverException != null) {
		//	strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		//}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		//GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>China: Customs Result View</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
    function setupPage(){
        loadPage();
    }
</script>
</head>
<body  onLoad="setupPage();"> 

<form name="form"> 
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows"> 
<input type="hidden" name="edi_ref_id" value="<%=edi_ref_id%>">
<input type="hidden" name="vvd_cd" value="<%=vvd_cd%>">
<input type="hidden" name="pol_cd" value="<%=pol_cd%>">
<input type="hidden" name="pod_cd" value="<%=pod_cd%>">

<!-- OUTER - POPUP (S)tart -->
<table width="1020" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;China: Customs Result View</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23"> 
					<td width="40">VVD</td> 
					<td width="120"><input type="text" style="width:80;" class="input2" value="<%=vvd_cd%>"></td>
					<td width="40">POL</td> 
					<td width="120"><input type="text" style="width:80;" class="input2" value="<%=pol_cd%>"></td>
					<td width="40">POD</td> 
					<td width=""><input type="text" style="width:200;" class="input2" value="<%=pod_cd%>"></td>
					
  						
   				</tr>
   					</table>	
              					
				<!--  biz_1   (E) -->	
              			
			
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<tr width = "100%">
							<td width="100%" style="font size:11;">* Beijing Standard Time (GMT +08:00)</td>
						</tr> 
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>			
			<!-- Grid (E) -->	
			<table class="height_8"><tr><td></td></tr></table>			
			<table class="search" border="0" style="width:100%;"> 
				<tr class="h23"> 
					<td width="70"> B/L Count</td> 
					<td width="120"><input type="text" name="bl_cnt" style="width:80;text-align:right;" class="input2" readonly></td>					                
					<td width="110"> Container Count</td> 
					<td width=""><input type="text" name="cntr_cnt" style="width:80;text-align:right;" class="input2" readonly></td>
  						
   				</tr>
   					</table>	
			</td></tr>
		</table>
		<!--biz page (E)-->


	</td></tr>
</table> 

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
                    <td class="btn1" name="btn_excel">Down Excel</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
				 <td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right">
				</tr></table></td>
			</tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
</td></tr>
</table>			
</form>			
</body>
</html>
