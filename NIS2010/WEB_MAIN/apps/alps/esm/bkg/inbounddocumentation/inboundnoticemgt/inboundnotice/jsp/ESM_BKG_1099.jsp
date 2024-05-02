<%
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_BKG_1099.jsp
*@FileTitle : Integrated Customer Data Update Setup Pop-up
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.27
*@LastModifier : 곽영범
*@LastVersion : 1.0
* 2010.07.27 곽영범
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

	String strUsr_id = "";
	String strUsr_nm = "";
	String strOfc_cd = "";
	Logger log = Logger.getLogger("com.hanjin.apps.InboundBlMgt.PickUpNotice");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		//strOfc_cd = "ddd";
		strOfc_cd = JSPUtil.getNull(request.getParameter("ofc_cd"),strOfc_cd);
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Integrated Customer Data Update Setup</title>
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
<!-- 개발자 작업	-->
     
<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp"%>        
            <!--biz page (S)-->
            <table class="search" id="mainTable"> 
                <tr>
                    <td class="bg">
                    
                        <table class="search" width="100%" > 
                            <tr class="h23">
                                <td width="150">Office</td>
                                <td width="">
                                    <input type="text" style="width:65;text-align:left;ime-mode:disabled;" class="input1" name="ofc_cd" 
                                           caption="Office" maxlength="6" minlength="6" dataformat="" fullfill="true" value="<%=strOfc_cd%>"/>
                                </td>
                            </tr>
                            
                            <tr class="h23">
                                <td width="150">Auto Update</td>
                                <td>
                                     <select style="width:65;" name="auto_upd_flg" onKeyDown="ComKeyEnter(this)">
                                                    <option value="Y" selected>Yes</option>
                                                    <option value="N" >No</option>
                                     </select>
                                </td>
                            </tr>
                            
                            <tr class="h23">
                              <td width="150">Last updated by</td>
                            
                                <td><u><font color="blue"><span id="upd_usr_id"></span></font></u></td>

                            </tr>
                        </table>        
                        
                
                    </td>
                </tr>
            </table>

<!--  Include Pop에서 시작된 table -->            
    </td>
</tr>
</table>            
<!--  Include Pop에서 시작된 table end -->

            <!--biz page (E)--> 

    
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
    <tr>
        <td height="71" class="popup">

            <!--Button (S) -->  
            <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
                <tr>
                    <td class="btn3_bg">
                        <table border="0" cellpadding="0" cellspacing="0">
                            <tr>
                                <td> 
                                    <table border="0" cellpadding="0" cellspacing="0">
                                        <tr>
                                            <td class="btn1_left"></td>
                                            <td class="btn1" name="btn_Retrieve">Retrieve</td>
                                            <td class="btn1_right"></td>
                                        </tr>
                                    </table>
                                </td>
                                <td> 
                                    <table border="0" cellpadding="0" cellspacing="0">
                                        <tr>
                                            <td class="btn1_left"></td>
                                            <td class="btn1" name="btn_Save">Save</td>
                                            <td class="btn1_right"></td>
                                        </tr>
                                    </table>
                                </td>
                                <!-- 
                                <td class="btn1_line"></td>
                                <td> 
                                    <table border="0" cellpadding="0" cellspacing="0">
                                        <tr>
                                            <td class="btn1_left"></td>
                                            <td class="btn1" name="btn_Close">Close</td>
                                            <td class="btn1_right"></td>
                                        </tr>
                                    </table>
                                </td>
                                 -->
                            </tr>
                        </table>                        
                    </td>
                </tr>
            </table>
    
        </td>
    </tr>
</table>
<!-- : ( Button : pop ) (E) -->


<table width="100%"  id="mainTable" style="display:none"> 
	<tr>
		<td width="100%">
			<script language="javascript">ComSheetObject('sheet1');</script>
		</td>
	</tr>
</table>
<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_CLOSE.jsp"%>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
