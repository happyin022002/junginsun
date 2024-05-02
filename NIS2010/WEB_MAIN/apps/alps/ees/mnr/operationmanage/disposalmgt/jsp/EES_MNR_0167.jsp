<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0167.jsp
*@FileTitle : Buyer Inquiry Pop up 
*Open Issues :     
*Change history :   
*@LastModifyDate : 2016.06.17
*@LastModifier : 이율규 
*@LastVersion : 1.0 
* 2016.06.17 이율규		   		
* 1.0 Creation 	 	   
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.event.EesMnr0167Event"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%

    EesMnr0167Event  event = null;                //PDTO(Data Transfer Object including Parameters)
    GeneralEventResponse eventResponse = null;    //RDTO(Data Transfer Object including DB ResultSet)
    Exception serverException   = null;            //서버에서 발생한 에러
    DBRowSet rowSet      = null;                               //DB ResultSet
    String strErrMsg = "";                                 //에러메세지
    
    String disp_no = "";
    String rqst_ofc_cd = "";
    String disp_tp_cd = "";
    String apro_ofc_cd = "";
    String strOfc_cd = "";
    String strRhq_ofc_cd = "";
    String selected_buyer = "";
    
    try {
       SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
       strOfc_cd = account.getOfc_cd();
       strRhq_ofc_cd  = account.getRhq_ofc_cd();
      
        event = (EesMnr0167Event)request.getAttribute("Event");
        disp_no = JSPUtil.getParameter(request, "disp_no".trim(), "");
        rqst_ofc_cd = JSPUtil.getParameter(request, "rqst_ofc_cd".trim(), "");
        disp_tp_cd = JSPUtil.getParameter(request, "disp_tp_cd".trim(), "");
        selected_buyer = JSPUtil.getParameter(request, "selected_buyer".trim(), "");
        
    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title>M&R Buyer Inquiry Pop up</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	var currOfcCd = '<%=strOfc_cd %>';
	var rhqOfcCd  = '<%=strRhq_ofc_cd %>';

    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        // InitTab();
        loadPage();
    }
</script>
</head>
<!-- 
showErrMessage를 써주지 않으면 에러 발생시 처리가 불가합니다.
그리고 지금은 showErrMessage()으로 되어있지만 추후에 고객님이 변덕을 일으켜서 웹페이지를 호출하라고 할경우를 
대비해서 직접 showErrMessage() 하지 마시고 꼭 showErrMessage를 써주십시오. 한방에 바꾸게요. 표준을 안따르면 나중에 후회합니다.  
-->



<!-- OUTER - POPUP (S)tart -->
<body onload="javascript:setupPage();">
<form name="form" onkeyup="ComKeyEnter('lengthnextfocus');">
<input type="hidden" name="f_cmd">
<input type="hidden" name="disp_no" value = "<%=disp_no%>">
<input type="hidden" name="rqst_ofc_cd" value = "<%=rqst_ofc_cd%>">
<input type="hidden" name="disp_tp_cd" value = "<%=disp_tp_cd%>">
<input type="hidden" name="usr_ofc_cd" value = "<%=strOfc_cd%>">
<input type="hidden" name="buyer_string" value = "">
<input type="hidden" name="selected_buyer" value = "<%=selected_buyer%>">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	
		<!--Page Title, Historical (S)-->
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
						    <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> M&R Buyer Inquiry Pop up</td></tr>
						</table>  
						<!--Page Title, Historical (E)-->
		<!-- : ( Title ) (E) -->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
				<table border="0"> 
					<tr class="h23"> 
					    <td class="title_h"></td>
						<td class="title_s">Buyer Type&nbsp;&nbsp;&nbsp;</td> 
						<td> 
						<input type="checkbox" name="Buyer_All" value="ALL" style="border:0;" onClick="buyerControl(this)"> ALL
						<input type="checkbox" name="Buyer_Global" value="G" style="border:0;" onClick="buyerControl(this)"> Global Partner
						<input type="checkbox" name="Buyer_RHQ" value="R" style="border:0;" onClick="buyerControl(this)"> RHQ Partner
						<input type="checkbox" name="Buyer_Local" value="L" style="border:0;" onClick="buyerControl(this)"> Local Partner
						</td>
						<td width="330">
						</td>
						<td>
						<table width="80" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_Retrieve">Retrieve</td>
							<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>

		<!-- TABLE '#D' : ( Search Options : Scenario ID ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">
				
				<!-- : ( Scenario ID ) (S) -->
				<!-- <table class="search" border="0" style="width:735;">
				<tr class="h23">
					<td width="100">Buyer Code</td>
					<td width="150"><input type="text" name="buyer_code1" dataformat="engup" maxlength="2" style="width:25;ime-mode:disabled">&nbsp;
									<input type="text" name="buyer_code2" dataformat="number" maxlength="8" style="width:80;ime-mode:disabled"></td>					
					<td width="100">Buyer Name</td>
					<td width="101"><input type="text" name="buyer_name" maxlength="5" dataformat="engup" style="width:60" style=""></td>
					<td width="100">Buyer Type</td>
					<td ><input type="text" name="buyer_type" maxlength="10" dataformat="engup" style="width:60" style=""></td></tr>
					</table> -->
				<table class="search" border="0" style="width:735;">
				</table>
				<!-- : ( Scenario ID ) (E) -->
		<!-- TABLE '#D' : ( Search Options : Scenario ID ) (E) -->

			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>

			<!-- : ( Grid ) (S) -->
			<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,
				 ' BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->
				    

					<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet1');</script>
                        </td></tr>
		            </table>

					<table width="100%" class="button"> 
		       		<tr><td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0"><TR>
							<td width="100"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn2_Down_Excel">Down Excel</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td></TR>
					</table>
					</td></tr>
				</table>
			<!-- : ( Grid ) (E) -->

				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->

<table class="height_5"><tr><td></td></tr></table>


<!-- OUTER - POPUP (E)nd -->
</td>
					</tr>
				</table>


<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><!-- <td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_New">New</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td> -->
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_OK">OK</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td class="btn1_line"></td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
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

	</td></tr>
</table>
<!-- : ( Button : Sub ) (E) -->


</form>
</body>
</html>