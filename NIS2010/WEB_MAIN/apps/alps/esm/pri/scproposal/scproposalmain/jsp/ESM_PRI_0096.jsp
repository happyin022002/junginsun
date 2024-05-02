<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0096.jsp
*@FileTitle : S/C Copy Option
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.10
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.06.10 문동규
* 1.0 Creation
=========================================================
* History
* 2011.05.13 김민아 [CHM-201110785-01] ANW03588 에 대해서 S/C Copy 요청 -  NVOCC Customer의 경우 G.Rate, OAR, DAR Copy를 막아 놨는데 급하게 오늘 구주의 특정 S/C를 copy 하고 싶다는 요청 수용을 위해 임시 코드 작성.
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.event.EsmPri0096Event"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmPri0096Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.SCProposal.SCProposalMain");
	
	String propNo = null;
	String amdtSeq = null;
    String scNo = null;
    String custTp = null;
    
    String isSuper = null;
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmPri0096Event)request.getAttribute("Event");
        
		/*
		RsltPropCopyVO vo = event.getRsltPropCopyVO();
        
        if (vo != null) {
            propNo = vo.getPropNo();
            amdtSeq = vo.getAmdtSeq();
            scNo = vo.getScNo();
        } else {
            propNo = "";
            amdtSeq = "";
            scNo = "";
        }
        */
        
        propNo  = JSPUtil.getNull(request.getParameter("prop_no"));
        amdtSeq = JSPUtil.getNull(request.getParameter("amdt_seq"));
        scNo    = JSPUtil.getNull(request.getParameter("sc_no"));
        custTp  = JSPUtil.getNull(request.getParameter("cust_tp"));
        isSuper = JSPUtil.getNull(request.getParameter("is_super"));
        
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
<title>S/C Copy Option</title>
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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="sc_no"   value="<%=scNo %>">
<input type="hidden" name="cust_tp" value="<%=custTp %>">
<input type="hidden" name="isSuper" value="<%=isSuper %>">
<!-- 개발자 작업	-->
<!-- input type="hidden" name="cd" -->


<!-- OUTER - POPUP (S)tart -->
<table width="900" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; S/C Copy Option</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- 1 (S) -->
		<table class="search" id="mainTable"> 
       	<tr><td class="bg">	
				
				
			<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="60">&nbsp;&nbsp;S/C No.</td>
					<td width="150">
						<input type="text" name="sc_no_fst" style="width:45;" value="<%=(scNo.length() > 3)?scNo.substring(0,3):"" %>" class="input2" readonly="readonly">&nbsp;
						<input type="text" name="sc_no_lst" style="width:60;" value="<%=(scNo.length() > 3)?scNo.substring(3):"" %>" class="input2" readonly="readonly">
					</td>
					<td width="60">AMD No.</td>
					<td width="80">
					<input type="text" name="amdt_seq" style="width:45;text-align:right;" value="<%=amdtSeq%>" class="input2" readonly="readonly"></td>
					<td width="80">Proposal No.</td>
					<td width="">
					<input type="text" name="prop_no" style="width:90;"  value="<%=propNo%>"  class="input2" readonly="readonly"></td>
				</tr>	
				
			</table>
			<table class="search_sm2" border="0" style="width:200;"> 
				<tr class="h23">
					<td width="">
					<input type="checkbox" name="blpl_chk_frm" class="trans" >Boiler Plate&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="checkbox" name="afil_chk_frm" class="trans" >Affiliate</td>
				</tr>	
				
			</table>	
				
            <table width="100%" style="display:inline;">
                <tr>
                    <td width="100%">
                        <script language="javascript">ComSheetObject('sheet1');</script>
                        <script language="javascript">ComSheetObject('sheet2');</script>
                    </td>
                </tr>
            </table>                
                </td></tr>
            </table>			<!-- Grid - 2 (S) -->

			<!-- Grid - 2 (E) -->	

			<!-- grid box (E) -->
			
<table class="height_5"><tr><td></td></tr></table>			
		</td></tr>
		</table>			
		<!-- 1 (E) -->
		

		
		



	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

    	<!--Button (S) -->	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Ok">OK</td>
					<td class="btn1_right"></td>
				</tr></table></td>	
			<td class="btn1_line"></td>		
			
			<td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="72 border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				
			</tr>
		</table>
    	<!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
			

</td></tr></table>
</td></tr></table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>