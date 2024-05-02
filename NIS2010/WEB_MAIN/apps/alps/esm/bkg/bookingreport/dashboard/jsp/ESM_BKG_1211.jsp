<%
	/*=========================================================
	 *Copyright(c) 2013 CyberLogitec
	 *@FileName : esm_bkg_1211.jsp
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2013.10.16
	 *@LastModifier : Eun jung Park
	 *@LastVersion : 1.0
	 * 2013.10.16 Eun jung Park
	 * 1.0 Creation
	 =========================================================*/ 
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingreport.dashboard.event.EsmBkg1211Event"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.common.util.basic.CodeUtilBC" %>
<%@ page import="com.hanjin.apps.alps.esd.sce.common.util.basic.CodeUtilBCImpl" %>

<%
        EsmBkg1211Event  event        = null;                       
        Exception serverException     = null;                   

        String strErrMsg              = "";                              
        DBRowSet rowSet               = null;                        
        int rowCount                  = 0;                               
        SignOnUserAccount account     =(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        String userId                 = account.getUsr_id();

        try{
            serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
            if (serverException != null) {
                strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
            }else{
                event = (EsmBkg1211Event)request.getAttribute("Event");
            }
        } catch(Exception e) {
            out.println(e.toString());
        }
%>

<html>
<head>
<title>Welcome to alps!</title>
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

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="row_size">
<input type="hidden" name='strUsr_id' value='<%=account.getUsr_id()%>'>

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>


        <!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
            <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
                <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
                <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
            </table>
        <!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->


        <!-- TABLE '#D' : ( Button : Main ) (S) -->
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
                                <tr><td class="btn1_bg">

                                        <table border="0" cellpadding="0" cellspacing="0">
                                        <tr>
                                            <!-- Repeat Pattern -->
                                            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                <tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
                                                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                <tr><td class="btn1_left"></td><td class="btn1" name="btn_save" id="btn_save">Save</td><td class="btn1_right"></td></tr></table></td>
                                                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                <tr><td class="btn1_left"></td><td class="btn1" name="btn_default" id="btn_default">Default</td><td class="btn1_right"></td></tr></table></td>
                                        </tr></table>

                                </td></tr>
                        </table>
        <!-- TABLE '#D' : ( Button : Main ) (E) -->
		<table class="search">
            <tr>
                <td class="bg">
                    <table class="search_in" border="0">
                        <tr><td>
                        <table class="search">
                        <tr class="h23">
                        <td width='5'></td>
                            <td width='68'>LOGIN ID</td>
                            <td width="100"><input name="login_id" type="text" class="input1" value="<%=userId%>" style="width:120;" Disabled ></td>
                            <td width='65'>&nbsp;</td>
                            <td width='60'>BKG OFC</td>
                            <td width="100"><input name="bkg_ofc" type="text" class="input1" dataformat="engup" style="width:120;" onBlur='this.value=this.value.toUpperCase();'></td>
                            <td width='700'>&nbsp;</td>                            
                        </tr>
                        </table>
                       
                        
                        
                        </td></tr>
                    </table>
                </td></tr>
        </table>
        <!-- TABLE '#D' : ( Search Options ) (E) -->
         <table class="height_10"><tr><td></td></tr></table>
      

        <!-- TABLE '#D' : ( Tab BG Box ) (S) -->
        <div id="tabLayer" style="display: inline;">
        <table class="search" border="0">
            <tr>
                <td class="bg">
                    <table class="height_10"><tr><td></td></tr></table>

                    <!-- : ( grid ) (S) -->
                    <table width="100%" id="mainTable" onresize="ChangeSize(this.clientWidth)">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet1');</script>
                        </td></tr>
                    </table>
                    <!-- : ( grid ) (E) -->
            </td></tr>
        </table>
        </div>
        <!-- TABLE '#D' : ( Tab BG Box ) (E) -->
        
        <table width="100" class="search" style="margin-top:10px">
    <tr>
        <td class="bg"><!-- Grid  (S) -->
            <table width="100%" border="0" cellpadding="0" cellspacing="0" style="margin-top:10px">
                            <tr>
                                <td>1. Standard Critical Point among colors</td>
                            </tr>
                        </table>
            <table width="100%" cellpadding="10" class="grid" style="margin-TOP:10PX ; padding: 10px">
                <colgroup>
                <col width="">
                <col width="28%">
                <col width="28%">
                <col width="28%">
   
                </colgroup>
                <tr class="tr_head">
                    <td >Color</td>
                    <td>Green</td>
                    <td>Yellow</td>
                    <td>Red</td>
                </tr>
                <tr class="tr" style="padding:5px">
                    <td align="center">Critical Point 
                        (btwn Colors) </td>
                    <td align="center">Less than 1% </td>
                    <td align="center">More than 1% ~ Less than Average</td>
                    <td align="center">More than Average</td>
                </tr>
                <tr class="tr">
                    <td align="center">Example</td>
                    <td align="center" style="line-height:20px">IRR count in a cell / Total Count in a cell X 100 <br>
                        < <br>
                        1 %</td>
                    <td align="center"  style="line-height:20px">1%
                        ≤
                        IRR count in a cell / Total Count in a cell X 100 <br>
                        <<br>
                        IRR counts in whole batch (all live bookings)/ <br>
                        Total counts in whole batch (all live bookings)</td>
                    <td align="center"  style="line-height:20px">IRR count in a cell / Total Count in a cell X 100<br>
                        ≤<br>
                        IRR counts in whole batch (all live bookings)/ <br>
                        Total counts in whole batch (all live bookings)</td>
                </tr>
                <tr class="tr">
                    <td align="center">Remark</td>
                    <td align="center" style="line-height:20px">The Top priority, supersede the condition of Yellow critical point</td>
                    <td align="center" style="line-height:20px">The 2nd priority, unless the cell is not green</td>
                    <td align="left">&nbsp;</td>
                </tr>
            </table>
            <table width="100%" border="0" cellpadding="0" cellspacing="0"  style="margin-top:10px">
                <tr>
                    <td>2. If your own critical points are set at this screen, they will supersede the above standard points.</td>
                </tr>
            </table>
            <p>&nbsp;</p>
            <!-- Grid  (e) --></td>
    </tr>
</table>
        
        <table class="height_10"><tr><td></td></tr></table>
    </td></tr>
</table>
</form>
<!-- TABLE '#B' : 'Left + Right Body' Table (E)nd -->
    </td></tr>
</table>
<!-- Outer Table (E)-->
</body>
</html>