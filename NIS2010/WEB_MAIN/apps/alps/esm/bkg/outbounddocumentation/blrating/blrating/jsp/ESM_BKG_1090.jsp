<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1090.jsp
*@FileTitle : Surcharge Adjustment
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2011.04.15 KIM JIN JOO
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.event.EsmBkg1090Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1090Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	Logger log = Logger.getLogger("com.hanjin.apps.BlRating.BlRating");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		event = (EsmBkg1090Event)request.getAttribute("Event");
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
<title>Surcharge Adjustment</title>
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

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="ca_flg" value=<%=JSPUtil.getParameter(request, "ca_flg")%>>
<input type="hidden" name="bkg_no" value=<%=JSPUtil.getParameter(request, "bkg_no")%>>
<input type="hidden" name="bkg_ofc_cd" value=<%=JSPUtil.getParameter(request, "bkg_ofc_cd")%>>
<input type="hidden" name="svc_scp_cd" value=<%=JSPUtil.getParameter(request, "svc_scp_cd")%>>
<input type="hidden" name="pol_cd" value=<%=JSPUtil.getParameter(request, "pol_cd")%>>
<!-- 개발자 작업	-->

<table width="100%" class="popup" cellpadding="10" border="0"> 
    <tr><td class="top"></td></tr>

    <tr>
        <td valign="top">
    
            <!-- : ( Title ) (S) -->
            <table width="100%" border="0">
            <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle" />&nbsp;Surcharge Adjustment </td></tr>
            </table>
            <!-- : ( Title ) (E) -->
        
		
   		<table class="tab" border="0" cellpadding="0" cellspacing="0" style="width:550;" > 
     		<tr><td width="100%">
					<script language="javascript">ComTabObject('tab1')</script>
					<!-- img src="img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
				</td></tr>
		</table>
		<table class="iframe" border="0" cellpadding="0" cellspacing="0" style="width:550px;" >
     		<tr><td width="100%">
				<!-- iframe name="outerFrame" id="outerFrame" src="" style="width:998px;height:640px;" frameborder="0" marginwidth="0" marginheight="0" scrolling="no"></iframe>
				
		<!-- Tab ) (E) --> 
		<!-- iFrame (S) -->
		<div id="tabLayer" style="display: none">
		<iframe name="t1frame" id="t1frame" style="width:550px;height:540px;" frameborder="0" marginwidth="0" marginheight="0" scrolling="no" src="about:blank" onload="return setForceFocus()"></iframe></div>
		<div id="tabLayer" style="display: none">
		<iframe name="t2frame" id="t2frame" style="width:550px;height:640px;" frameborder="0" marginwidth="0" marginheight="0" scrolling="no" src="about:blank" onload="return setForceFocus()"></iframe></div>
		<div id="tabLayer" style="display: none;width:550px;height:540px;">
			<table class="search" id="mainTable">
				<tr>
					<td class="bg">          
						
						<table class="search" border="0" style="width:50%;"> 
                            <tr class="h23">
                                <td width="50">BKG No.</td>
                                <td width="140">
                                    <input type="text" style="width:110;text-align:center;" class="input2" readonly="readonly"
                                           dataformat="" maxlength="13" caption="BKG No." name="dhf_bkg_no" value="<%=JSPUtil.getParameter(request, "bkg_no")%>"/>
                                </td>
                                <td></td>
                            </tr> 
                        </table>
                        
                        <table class="line_bluedot"><tr><td></td></tr></table>                
                        <!-- Grid  (S) -->
                        <table width="100%"  id="mainTable"> 
                            <tr>
                                <td width="100%">
                                	<script language="javascript">ComSheetObject('sheet1');</script>
                                </td>
                            </tr>
                        </table>       
                        
                        
                        <table>
                        	<tr>
                        		<td><span id="ui_msg"/></span></td>
                        	</tr>
                        </table> 
                         
					</td>
				</tr>
			</table>
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
                <tr>
                    <td class="btn3_bg">
                        <table border="0" cellpadding="0" cellspacing="0">
                            <tr>
                                <td>
                                    <table border="0" cellpadding="0" cellspacing="0">
                                        <tr>
                                            <td class="btn1_left"></td>
                                            <td class="btn1" name="btn_t3Save" id="btn_t3Save">Save</td>
                                            <td class="btn1_right"></td>
                                        </tr>
                                    </table>
                                </td>
                                <td class="btn1_line"></td>
                                <td>
                                    <table border="0" cellpadding="0" cellspacing="0">
                                        <tr>
                                            <td class="btn1_left"></td>
                                            <td class="btn1" name="btn_t3New">New</td>
                                            <td class="btn1_right"></td>
                                        </tr>
                                    </table>
                                </td>               
                                <td class="btn1_line"></td>
                                <td>
                                    <table border="0" cellpadding="0" cellspacing="0">
                                        <tr>
                                            <td class="btn1_left"></td>
                                            <td class="btn1" name="btn_t3Close">Close</td>
                                            <td class="btn1_right"></td>
                                        </tr>
                                    </table>
                                </td>                        
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
		</div>
		<div id="tabLayer" style="display: none; width:550px;height:540px;">
			<table class="search" id="mainTable">
				<tr>
					<td class="bg">
						
						<table class="search" border="0" style="width:50%;"> 
                            <tr class="h23">
                                <td width="50">BKG No.</td>
                                <td width="140">
                                    <input type="text" style="width:110;text-align:center;" class="input2" readonly="readonly"
                                           dataformat="" maxlength="13" caption="BKG No." name="ddc_bkg_no" value="<%=JSPUtil.getParameter(request, "bkg_no")%>"/>
                                </td>
                            </tr> 
                        </table>
                        
                        <table class="line_bluedot"><tr><td></td></tr></table>  
                        
                        <!-- Grid  (S) -->
                        <table width="100%"  id="mainTable"> 
                            <tr>
                                <td width="100%">
                                	<script language="javascript">ComSheetObject('sheet2');</script>
                                </td>
                            </tr>
                        </table>   
                        
                        <table>
                        	<tr>
                        		<td>※ TPW, ACW scope only</td>
                        	</tr>
                        </table>    
					</td>
				</tr>
			</table>
			
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
                <tr>
                    <td class="btn3_bg">
                        <table border="0" cellpadding="0" cellspacing="0">
                            <tr>
                                <td>
                                    <table border="0" cellpadding="0" cellspacing="0">
                                        <tr>
                                            <td class="btn1_left"></td>
                                            <td class="btn1" name="btn_t4Save" id="btn_Save">Save</td>
                                            <td class="btn1_right"></td>
                                        </tr>
                                    </table>
                                </td>
                                <td class="btn1_line"></td>
                                <td>
                                    <table border="0" cellpadding="0" cellspacing="0">
                                        <tr>
                                            <td class="btn1_left"></td>
                                            <td class="btn1" name="btn_t4New">New</td>
                                            <td class="btn1_right"></td>
                                        </tr>
                                    </table>
                                </td>               
                                <td class="btn1_line"></td>
                                <td>
                                    <table border="0" cellpadding="0" cellspacing="0">
                                        <tr>
                                            <td class="btn1_left"></td>
                                            <td class="btn1" name="btn_t4Close">Close</td>
                                            <td class="btn1_right"></td>
                                        </tr>
                                    </table>
                                </td>                        
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
		</div>
		<!-- iFrame (E) -->				
			</td></tr>
		</table>
            <!--biz page (S)-->
            <!--biz page (E)--> 


<table class="height_5"><tr><td></td></tr></table>
        </td>
    </tr>
</table>
    
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
                                            <td class="btn1" name="btn_Save" id="btn_Save">Save</td>
                                            <td class="btn1_right"></td>
                                        </tr>
                                    </table>
                                </td>
                                <td class="btn1_line"></td>
                                <td>
                                    <table border="0" cellpadding="0" cellspacing="0">
                                        <tr>
                                            <td class="btn1_left"></td>
                                            <td class="btn1" name="btn_New">New</td>
                                            <td class="btn1_right"></td>
                                        </tr>
                                    </table>
                                </td>               
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
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
            <!--Button (E) -->
    
        </td>
    </tr>
</table>


<!-- 개발자 작업  끝 -->
</form>
</body>
</html>