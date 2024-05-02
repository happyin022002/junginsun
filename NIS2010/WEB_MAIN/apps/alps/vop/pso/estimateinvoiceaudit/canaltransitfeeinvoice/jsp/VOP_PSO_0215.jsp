<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_pso_0215.jsp
*@FileTitle : File Download
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.09
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.03.05 진마리아
* 1.0 Creation
*
* History
* 2012.04.09 진마리아 CHM-201217036-01 SPP-Port SO/ Actual Invoice 화면 변경 및 기능, 로직 추가
* 2016.03.14 CHM-201640418 승인 단계에서 파일 첨부 기능 추가
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.event.VopPso0215Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	VopPso0215Event  event = null;					//PDTO(Data Transfer Object including Parameters)
    Exception serverException = null;
    String strErrMsg = "";
    int rowCount = 0; 

    String successFlag = "";
    String codeList = "";
    String pageRows = "100";

    String userId = "";
    String userName = "";
    String userOffice = "";
    String vvd = "";
    String vslCd = "";
    String skdVoyNo = "";
    String skdDirCd = "";
    
    String ydCd = "";
    String callSeq = "";
    String lgsCostCd = "";
    
    Logger log = Logger.getLogger("com.hanjin.apps.alps.vop.pso.EstimateInvoiceAudit.CanalTransitFeeEstimate");
    
    
    try
    {
        SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        userId = account.getUsr_id();
        userName = account.getUsr_nm();
        userOffice = account.getOfc_cd();
        
        event = (VopPso0215Event) request.getAttribute("Event");
        serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null)
        {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
        vvd	    = StringUtil.xssFilter((String) request.getParameter("vvd"));
		ydCd    = StringUtil.xssFilter((String) request.getParameter("ydCd"));
		callSeq = StringUtil.xssFilter((String) request.getParameter("callSeq"));
		lgsCostCd = StringUtil.xssFilter((String) request.getParameter("lgsCostCd"));
		if(vvd.length()>=9) {
			vslCd = vvd.substring(0, 4);
			skdVoyNo = vvd.substring(4, 8);
			skdDirCd = vvd.substring(8);
			
		}

    }
    catch (Exception e)
    {
        out.println(e.toString());
    }
    
%>

<%@page import="com.hanjin.framework.component.util.StringUtil"%><html>
<head>
<title>File Upload</title>
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

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows">

<!-- 개발자 작업 -->
<input type="hidden" name="vvd" value="<%=vvd%>">
<input type="hidden" name="vslCd" value="<%=vslCd%>">
<input type="hidden" name="skdVoyNo" value="<%=skdVoyNo%>">
<input type="hidden" name="skdDirCd" value="<%=skdDirCd%>">
<input type="hidden" name="yd_cd" value="<%=ydCd%>">
<input type="hidden" name="call_seq" value="<%=callSeq%>">
<input type="hidden" name="lgs_cost_cd" value="<%=lgsCostCd%>">


<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
    
        <!-- : ( Title ) (S) -->
        <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; File Upload/Download</td></tr>
        </table>
        <!-- : ( Title ) (E) -->
        
        <!-- : ( Search Options ) (S) -->
        <table class="search"> 
            <tr><td class="bg">
            
         <!-- Grid  (S) -->
            <table width="100%"  id="mainTable"> 
                <tr>
                    <td width="100%">
                        <script language="javascript">ComSheetObject('sheet1');</script>
                    </td>
                </tr>
            </table> 
            <!-- Grid (E) -->
            </td></tr>
        </table>
<!-- : ( Search Options ) (E) -->

<table class="height_5"><tr><td></td></tr></table>
</td></tr>
</table> 
    
    
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
    
    	<!--Button (S) -->	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" id="btn_upload" name="btn_upload">File Upload</td>
					<td class="btn1_right"></td>	
				</tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" id="btn_delete" name="btn_delete">File Delete</td>
					<td class="btn1_right"></td>	
				</tr></table></td>	
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" id="btn_save" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>		
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"></td>	
				</tr></table></td>	
				
			</tr>
		</table></td>	
				
			</tr>
		</table>
    	<!--Button (E) -->
    </td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
</td></tr>
</table>
<!-- 개발자 작업  끝 -->
<script language="javascript">ComUploadObject('upload1', '<%=session.getId()%>');</script>
</form>
<iframe name="hiddenFrame" style="visibility:hiddden" height="0" width="0"></iframe>
</body>
</html>