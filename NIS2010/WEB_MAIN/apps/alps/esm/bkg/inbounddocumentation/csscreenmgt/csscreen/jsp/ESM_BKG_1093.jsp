<%
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESK_BKG_1093.jsp
*@FileTitle : Inbound C/S USA_Instruction Pop-up
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.07
*@LastModifier : 안진응
*@LastVersion : 1.0
* 2010.05.07 안진응
* 1.0 Creation
* ---------------------------------------------------------
* History
* 2010.10.05 이지영 [CHM-201006263-01] INBOUND C/S USA_INSTRUCTION MAX 변경 요청
* 2012.05.16 김보배 [CHM-201217815] [BKG] Inbound CS_USA 화면 및 기능 변경사항 요청
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.event.EsmBkg1093Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1093Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

    // Param : bl_no, bl_tp_cd, bkg_no, bkg_split_no, cntr_no  
	String blNo       = "";
    String blTpCd     = "";
	String bkgNo      = "";
	String cntrNo     = "";
    String blTpCdClass = "input2";
	
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.CsScreenMgt.CsScreen");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();	   
	   
		event = (EsmBkg1093Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
        if(event != null) {       		
            bkgNo      = event.getBkgNo();
        }
		
	} catch(Exception e) {
		out.println(e.toString());
	}	
%>
<html>
<head>
<title>Inbound C/S USA_Instruction Pop-up</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
    var strUsr_id    = "<%=strUsr_id%>";

    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if
            
        with(document.form){
            eval("bkg_no").value       = "<%=bkgNo%>";
        }
            
        loadPage();
    }
</script>
</head>

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->

<input type="hidden" name="bkg_no" caption="Booking No." />
<input type="hidden" name="instr_rmk_seq" value ="" />


<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
    <tr><td class="top"></td></tr>
    <tr>
        <td valign="top">
        
            <!-- : ( Title ) (S) -->
            <table width="100%" border="0">
                <tr>
                    <td class="title">
                        <img src="img/icon_title_dot.gif" align="absmiddle" />&nbsp;Inbound C/S USA_Instruction 
                    </td>
                </tr>
            </table>
            <!-- : ( Title ) (E) -->
            
            <!-- : ( Search Options ) (S) -->                
		<table class="search" style="width:100%;" border="0"> 
       		<tr><td class="bg">
				
				<div id="div1" name="div1"></div>
			
				 <table class="height_5"><tr><td></td></tr></table> 
				<table class="search" border="0" style="width:;"> 
				<tr class="h23">
					<td width="670"><input type="text" name="instr_rmk" maxlength="150" style="width:660" value="" class="input"></td>
					<td width="170" style="padding-left:3;">
						<script language="javascript" >ComComboObject('rmk_tp', 1, 160, 1)</script></td>
					
					<td width="67"><table width="65" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_save">Save</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					<td> &nbsp;</td>
				</tr>
				</table>
			
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
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
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"></td>
					</tr></table></td>
			</tr>
		</table>
    <!--Button (E) -->
   	 </td></tr>
	</table>
	
</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
<!-- Grid  (S) -->
<table width="100%"  id="mainTable"> 
	<tr>
		<td width="100%">
			<script language="javascript">ComSheetObject('sheet1');</script>
		</td>
	</tr>
</table>			
<div id="helpbox" style="border-width: 0px; border-style: none; width: 0px; height: 0px; position: absolute; left: 0px; top: 0px; z-index: 1;"></div>

<!-- Grid (E) -->	
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
<%@include file="/bizcommon/include/common_nis2010.jsp"%>