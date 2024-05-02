<%--=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESD_PRD_0071.jsp
*@FileTitle : Block Stowage Group Creation & Inquiry 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2010-01-01
*@LastModifier : jungsunyong
*@LastVersion : 1.0
* 2006-09-04 jungsunyong
* 1.0 최초 생성
=========================================================--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.prd.networknodemanage.blockstowage.event.EsdPrd0071Event"%>
<%
	EsdPrd0071Event  event = null;                //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;            //서버에서 발생한 에러
    DBRowSet rowSet      = null;                               //DB ResultSet
    String strErrMsg = "";                                 //에러메세지
    int rowCount     = 0;                                  //DB ResultSet 리스트의 건수
    //String successFlag = "";

    try {
      
        event = (EsdPrd0071Event)request.getAttribute("Event");

        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<%@include file="/apps/alps/esd/prd/common/prdcommon/jsp/ESD_PRD_AUTH.jsp"%>
<html>
<head>
<title> Group Creation & Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
    function setupPage(){
	    loadPage();
    }
</script>
</head>

<body onLoad="setupPage();">
<form name="form" >
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
    <tr>
        <td><!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr>
				<td class="history"><img src="/hanjin/img/icon_history_dot.gif"	align="absmiddle"><span id="navigation"></span></td>
			</tr>
			<tr>
				<td class="title"><img src="/hanjin/img/icon_title_dot.gif"	align="absmiddle"><span id="title"></span></td>
			</tr>
		</table>
        <!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) --> <!-- TABLE '#D' : ( Button : Main ) (S) -->
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom: 5;">
            <tr>
                <td class="btn1_bg">

                <table border="0" cellpadding="0" cellspacing="0">
                    <tr>
                        <!-- Repeat Pattern -->
                        <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr>
                                <td class="btn1_left"></td>
                                <td class="btn1" name="btn_Retrieve" id="btn_retrieve">Retrieve</td>
                                <td class="btn1_right"></td>
                            </tr>
                        </table>
                        </td>
                        <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr>
                                <td class="btn1_left"></td>
                                <td class="btn1" name="btn_New" id="btn_new">New</td>
                                <td class="btn1_right"></td>
                            </tr>
                        </table>
                        </td>
                        <td class="btn1_line"></td>
                        <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr>
                                <td class="btn1_left"></td>
                                <td class="btn1" name="btn_Save" id="btn_save">Save</td>
                                <td class="btn1_right"></td>
                            </tr>
                        </table>
                        </td>
                        <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr>
                                <td class="btn1_left"></td>
                                <td class="btn1" name="btn_DownExcel" id="btn_downexcel">Down Excel</td>
                                <td class="btn1_right"></td>
                            </tr>
                        </table>
                        </td>
                        <!-- Repeat Pattern -->

                    </tr>
                </table>

                </td>
            </tr>
        </table>
        <!-- TABLE '#D' : ( Button : Main ) (E) --> <!-- TABLE '#D' : ( Search Options ) (S) -->
        <table class="search">
            <tr>
                <td class="bg">
                <table class="search_in" border="0">
                    <tr class="h23">

                        <td width="50">Status</td>
                        <td width="180"><select name="del_flag" style="width: 70;">
                            <option value="A">All</option>
                            <option value="N" selected>Live</option>
                            <option value="Y">Deleted</option>
                        </select></td>
                        <td width="30">POD</td>
                        <td width="180"><input type="text" name="pod_code" value="" maxlength="5"  style="width: 60" dataformat="engup"  ></td>
                        <td width="30">HUB</td>
                        <td width="180"><input type="" name="hub_code" value="" maxlength="5" style="width: 60" dataformat="engup"></td>
                        <td width="35">LANE</td>
                        <td width="180"><input type="" name="lane_code" value="" maxlength="3" style="width: 60" dataformat="engup"></td>
                        <td width="45">GROUP</td>
                        <td width=""><input type="" name="group_code" value="" maxlength="3" style="width: 60" dataformat="engup"></td>
                    </tr>
                </table>
                </td>
            </tr>
        </table>
        <!-- TABLE '#D' : ( Search Options ) (E) -->

        <table class="height_10">
            <tr>
                <td></td>
            </tr>
        </table>

        <!-- Grid  (S) -->
        <table class="search">
            <tr>
                <td class="bg">

                <table width="100%" id="mainTable">
                    <tr>
                        <td width="100%"><script language="javascript">ComSheetObject('sheet1');</script></td>
                    </tr>
                </table>
                <!-- Grid (E) --> <!-- Button : Sub (S) -->
                <table width="100%" class="button">
                    <tr>
                        <td class="btn2_bg">
                        <table border="0" cellpadding="0" cellspacing="0">
                            <tr>

                                <!-- Repeat Pattern -->
                                <td>
                                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                    <tr>
                                        <td class="btn2_left"></td>
                                        <td class="btn2" name="btn_RowAdd" id="btng_rowadd">Row Add</td>
                                        <td class="btn2_right"></td>
                                        <td class="btn2_left"></td>
                                        <td class="btn2" name="btn_RowCopy" id="btng_rowcopy">Row Copy</td>
                                        <td class="btn2_right"></td>
                                    </tr>
                                </table>
                                </td>
                                <!-- Repeat Pattern -->
                            </tr>
                        </table>
                        </td>
                    </tr>
                </table>
                <!-- Button : Sub (E) --></td>
                <!-- Grid (E) -->
            </tr>
        </table>
        <!-- TABLE '#D' : ( Grid BG Box ) (E) --></td>
    </tr>
</table>
<!-- Outer Table (E)--></form>
</body>
</html>
