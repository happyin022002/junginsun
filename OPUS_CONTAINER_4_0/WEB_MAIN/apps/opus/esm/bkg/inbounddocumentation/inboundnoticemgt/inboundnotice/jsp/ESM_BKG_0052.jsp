<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0052.jsp
*@FileTitle : Integrated Customer Data Management
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
* 2009.06.03 
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0052Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%
	EsmBkg0052Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//serverException
	String strErrMsg = "";						//error massage
	int rowCount	 = 0;						//DB ResultSet list count

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_email	    = "";
	String strOfc_cd    = "";

	Logger log = Logger.getLogger("com.clt.apps.InboundBLMgt.ArrivalNotice");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	    strUsr_email = account.getUsr_eml();
	    strOfc_cd = account.getOfc_cd();


		event = (EsmBkg0052Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//when open screen, get data in server..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
    <head>
        <title>Arrival Info. Setting</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script language="javascript">
            var strUsr_nm    = "<%=strUsr_nm %>";
            var strUsr_email = "<%=strUsr_email %>";
            var strOfc_cd    = "<%=strOfc_cd %>";
            var strVvd = "<%=JSPUtil.getNull(request.getParameter("vvd"))%>";


            function setupPage(){
                loadPage();
            }


        </script>
    </head>

    <body  onLoad="setupPage();">
        <form name="form">
            <input name="f_cmd" type="hidden" />
            <input type="hidden" name="pagerows" value="<%=pageRows %>">

<!-- Developer Work	-->



            <!-- OUTER - POPUP (S)tart -->
            <table width="700" class="popup" cellpadding="10" border="0"> 
                <tr><td class="top"></td></tr>
                <tr><td valign="top">

                        <!-- : ( Title ) (S) -->
                        <table width="100%" border="0">
                            <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; MRN & Return yard Setup</td></tr>
                        </table>
                        <!-- : ( Title ) (E) -->

                        <!-- : ( Search Options ) (S) -->
                        <!--biz page-1 (S)-->
                        <table class="search"> 
                            <tr><td class="bg">
                                    <!--  biz_1  (S) -->
                                    <table class="search" border="0" style="width:484;"> 
                                        <tr class="h23">
                                            <td width="30">VVD</td>
                                            <td width="130"><input type="text" style="width:80;" class="input" value="" name="vvd" maxlength="9" onKeyPress="ComKeyOnlyAlphabet('uppernum');" onKeyDown="ComKeyEnter()"></td>
                                            <td width="">
                                                <table class="search_sm" border="0" style="width:200;">
                                                    <tr class="h23">
                                                        <td width="40">POD</td>
                                                        <td class="stm"><input type="radio" value="BEANR" class="trans" name="pod_cd" checked>BEANR&nbsp;&nbsp;&nbsp;<input type="radio" value="NLRTM" class="trans" name="pod_cd" >NLRTM</td></tr>
                                                </table>
                                            </td>
                                        </tr>
                                    </table>
                                    <!--  biz_1   (E) -->
                                    <!-- : ( Grid ) (S) -->
                                    <table width="100%"  id="mainTable"> 
                                        <tr>
                                            <td width="100%">
                                                <script language="javascript">ComSheetObject('sheet1');</script>

                                            </td>
                                        </tr>
                                    </table> 
                                    <table width="100%"  id="mainTable1" style="display:none"> 
                                        <tr>
                                            <td width="100%">

                                                <script language="javascript">ComSheetObject('sheet2');</script>
                                            </td>
                                        </tr>
                                    </table>
                                    <!-- : ( Grid ) (E) -->	
                                    <!-- : ( Button : Grid ) (E) -->	

                                </td></tr>
                        </table>
                        <!-- : ( Search Options ) (E) -->
                    </td></tr>
            </table> 

            <table class="height_5"><tr><td></td></tr></table>


            <!-- : ( Button : pop ) (S) -->
            <table width="100%" class="sbutton">
                <tr><td height="71" class="popup">

                        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;padding-bottom:10;"> 
                            <tr><td class="btn3_bg">
                                    <table border="0" cellpadding="0" cellspacing="0">
                                        <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                    <tr><td class="btn1_left"></td>
                                                        <td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
                                                        <td class="btn1_right">
                                                    </tr></table></td>
                                            <!-- 
                                            <td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
                                                    <tr><td class="btn1_left"></td>
                                                    <td class="btn1" name="btn_new">New</td>
                                                    <td class="btn1_right">
				</tr></table></td>
				 -->
                                            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                    <tr><td class="btn1_left"></td>
                                                        <td class="btn1" name="btn_down_excel">Down Excel</td>
                                                        <td class="btn1_right">
                                                    </tr></table></td>
                                            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                    <tr><td class="btn1_left"></td>
                                                        <td class="btn1" name="btn_upload_excel">Upload Excel</td>
                                                        <td class="btn1_right">
                                                    </tr></table></td>
                                            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                    <tr><td class="btn1_left"></td>
                                                        <td class="btn1" name="btn_save">Setup</td>
                                                        <td class="btn1_right">
                                                    </tr></table></td>
                                            <td class="btn1_line"></td>
                                            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                    <tr><td class="btn1_left"></td>
                                                        <td class="btn1" name="btn_close">Close</td>
                                                        <td class="btn1_right">
                                                    </tr></table></td>
                                        </tr>
                                    </table></td>
                            </tr>
                        </table>
                        <!--Button (E) -->

                    </td></tr>
            </table>
            <!-- : ( Button : pop ) (E) -->

<!-- Developer Work End -->
        </form>
    </body>
</html>