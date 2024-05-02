<% 
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0031.jsp
*@FileTitle : 상세운송계획 재생성 List 조회 
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-25
*@LastModifier : Jongwon Park
*@LastVersion : 1.0
* 2006-08-25 Jongwon Park
* 1.0 최초 생성
=========================================================*/ 
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.copmanage.copreplan.event.ESD_SCE_0031Event"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.copmanage.copreplan.event.ESD_SCE_0031EventResponse"%>
<%
    ESD_SCE_0031Event  event = null;                //PDTO(Data Transfer Object including Parameters)
    ESD_SCE_0031EventResponse eventResponse = null;	//RDTO(Data Transfer Object including DB ResultSet)
    Exception serverException   = null;			//서버에서 발생한 에러
    DBRowSet rowSet      = null;                           	//DB ResultSet
	
	String strErrMsg = "";                             	//에러메세지
    int rowCount     = 0;                              	//DB ResultSet 리스트의 건수

    /*
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";   
    */

    
    try {
        event = (ESD_SCE_0031Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{

            eventResponse = (ESD_SCE_0031EventResponse)request.getAttribute("EventResponse");
            if (eventResponse != null) {
    
                rowSet = eventResponse.getRs();
                if(rowSet != null){
					 rowCount = rowSet.getRowCount();
                } // end if
             
            } // end if
        } // end else
    }catch(Exception e) {
        out.println(e.toString());
    }

%>

<html>
<head>
<title>Welcome to NMS!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<script language="javascript">

    function setupPage(){
	    loadPage();

		var formObject = document.form ;
		//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }

</script>

<body onLoad="setupPage();">
<!-- OUTER FRAME : "to make sum of components' HEIGHTS 100%" (S)tart -->
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
<tr><td valign="top">

<!-- ################# TABLE '#B' ::: 'LEFT + RIGHT' FRAME (START) ################## -->
<!-- TABLE '#B' : 'Left + Right Body' Table (S)tart -->
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
<tr><td class="bodyleft">

	</td>
	<td class="bodyright">




		<!-- ####### TABLE '#D' ::: 'RIGHT' FRAME (START) ####### -->

		<!-- Put your 'STYLESHEET' into the <HEAD> tag on the corresponding page if you make 'FRAMESET's -->

		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<%@include file="/sys/common/menu/jsp/commonHeader.jsp"%>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->
        
        <form method="post" name="form"	action="ESD_SCE_0031.do">
        	<input type="hidden" name="f_cmd">
        	<input type="hidden" name="iPage">
        	<input type="hidden" name="ibflag">


		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button">
		<tr><td class="align">

			<table class="button">
				<tr>
					<td><img class="cursor" src="/hanjin/img/button/btn_retrieve.gif" width="66" height="20" border="0" name="btn_retrieve"></td>
					<td><img class="cursor" src="/hanjin/img/button/btn_createcop.gif" width="80" height="20" border="0" name="btn_createcop"></td>
					</tr>
				</table></td></tr>
		</table>
		<!-- TABLE '#D' : ( Button : Main ) (E) -->










		<!-- TABLE '#D' : ( Search Options : Speed ) (S) -->
     	<table class="search">
       	<tr><td class="bg_a">

				<!-- : ( Speed ) (S) -->
				<table width="100%" id="mainTable">
					<tr><td>
					   <script language="javascript">ComSheetObject('sheet1');</script>
    
					</td></tr>
				</table>
				<!-- : ( Speed ) (E) -->
   

			</td></tr>

		</table>
		</form>

		<!-- TABLE '#D' : ( Search Options : Speed ) (E) -->
		<!-- ####### TABLE '#D' ::: 'RIGHT' FRAME (END) ####### -->


	</td></tr>
</table>
<!-- TABLE '#B' : 'Left + Right Body' Table (E)nd -->
<!-- ################# TABLE '#B' ::: 'LEFT + RIGHT' FRAME (END) ################## -->





</td></tr>


<tr><td class="bgdybottom_copy">

	<!-- ####### TABLE '#E' ::: 'BOTTOM' FRAME (START) ####### -->
	<!-- TABLE '#E' : 'Family Site + Copyright' Table (S)tart -->
	<table class="copy">
	<tr>
		<td class="copy"><img src="/hanjin/img/copy2.gif" width="460" height="16"></td></tr>
	</table>
	<!-- TABLE '#E' : 'Family Site + Copyright' Table (E)nd -->
	<!-- ####### TABLE '#E' ::: 'BOTTOM' FRAME (END) ####### -->

</td></tr>
</table>
<!-- OUTER FRAME : "to make sum of components' HEIGHTS 100%" (E)nd -->
</body>
</html>

