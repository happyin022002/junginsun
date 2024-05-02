<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_AGT_007.jsp
*@FileTitle : America Brokerage Agreement Rate Creation/Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.agt.agtagreement.agtcustomeragreementinfo.event.EsmAgt0007Event"%>

<%
EsmAgt0007Event  event = null;                                 //PDTO(Data Transfer Object including Parameters)
Exception serverException   = null;                             //error from server
DBRowSet rowSet   = null;                                               //DB ResultSet

String strErrMsg = "";                                                  //error message
String tmpGrpTp = "";                                                   //Location Type 
String tmpBrogDiv = "";                                                 //Type 
String tmpBrogTp = "";                                                  //Charge Type 
String tmpBrogKnd = "";                                                 //Kind 
String grpTpCode = "";                                                  //Location Type Code
String grpTpText = "";                                                  //Location Type Text
String brogDivCode = "";                                                //Type Code
String brogDivText = "";                                                //Type Text
String brogTpCode = "";                                                 //Charge Type Code
String brogTpText = "";                                                 //Charge Type Text
String brogKndCode = "";                                                //Kind Code
String brogKndText = "";                                                //Kind Text

int rowCount     = 0;                                                   //count of DB resultSET list

try {

        //Extract necessary part from Common code combo string 
        tmpGrpTp = JSPUtil.getIBCodeCombo("", "", "CD00888", 0, "");
        tmpBrogDiv = JSPUtil.getIBCodeCombo("", "", "CD00598", 0, "");
        tmpBrogTp = JSPUtil.getIBCodeCombo("", "", "CD00788", 0, "");
        tmpBrogKnd = JSPUtil.getIBCodeCombo("", "", "CD00599", 0, "");

        if(tmpGrpTp != null && tmpGrpTp.length() > 8) {
                grpTpCode = tmpGrpTp.substring(tmpGrpTp.indexOf("Code = \"")+8, tmpGrpTp.lastIndexOf("\""));
                grpTpText = tmpGrpTp.substring(tmpGrpTp.indexOf("Text = \"")+8, tmpGrpTp.indexOf("\";"));
        }

        if(tmpBrogDiv != null && tmpBrogDiv.length() > 8) {
                brogDivCode = tmpBrogDiv.substring(tmpBrogDiv.indexOf("Code = \"")+8, tmpBrogDiv.lastIndexOf("\""));
                brogDivText = tmpBrogDiv.substring(tmpBrogDiv.indexOf("Text = \"")+8, tmpBrogDiv.indexOf("\";"));
        }

        if(tmpBrogTp != null && tmpBrogTp.length() > 8) {
                brogTpCode = tmpBrogTp.substring(tmpBrogTp.indexOf("Code = \"")+8, tmpBrogTp.lastIndexOf("\""));
                brogTpText = tmpBrogTp.substring(tmpBrogTp.indexOf("Text = \"")+8, tmpBrogTp.indexOf("\";"));
        }

        if(tmpBrogKnd != null && tmpBrogKnd.length() > 8) {
                brogKndCode = tmpBrogKnd.substring(tmpBrogKnd.indexOf("Code = \"")+8, tmpBrogKnd.lastIndexOf("\""));
                brogKndText = tmpBrogKnd.substring(tmpBrogKnd.indexOf("Text = \"")+8, tmpBrogKnd.indexOf("\";"));
        }

        event = (EsmAgt0007Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

} catch (Exception e) {
        out.println(e.toString());
}
%>
<html>
<head>
<title>미주 Brokerage 계약 요율 Creation/Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
        function setupPage(){
                var errMessage = "<%=strErrMsg%>";
                if (errMessage.length >= 1) {
                        ComShowMessage(errMessage);
                } // end if
                loadPage("<%=grpTpCode%>", "<%=grpTpText%>", "<%=brogDivCode%>", "<%=brogDivText%>", "<%=brogTpCode%>", "<%=brogTpText%>", "<%=brogKndCode%>", "<%=brogKndText%>");
        }
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<iframe height="0" width="0" name="frmHidden"></iframe>

<form name = "hiddenF" mehhod="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="cust_cd">
<input type="hidden" name="sheetId">
<input type="hidden" name="row">
<input type="hidden" name="colNm1">
<input type="hidden" name="colNm2">
</form>

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">


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
                <table width="100%" class="button">
                        <tr><td class="align">

			        <!--Button (S) -->
			       <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
			        <tr><td class="btn1_bg">
			                    <table border="0" cellpadding="0" cellspacing="0">
			                    <tr>
			                                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			                                        <tr><td class="btn1_left"></td>
			                                        <td class="btn1" name="btn_retrieve">Retrieve</td>
			                                        <td class="btn1_right"></td>
			                                        </tr>
			                                </table></td>
			                                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			                                        <tr><td class="btn1_left"></td>
			                                        <td class="btn1" name="btn_save">Save</td>
			                                        <td class="btn1_right"></td>
			                                        </tr>
			                                </table></td>
			                                <td class="btn1_line"></td>
			                                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			                                        <tr><td class="btn1_left"></td>
			                                        <td class="btn1" name="btn_downexcel">Down Excel</td>
			                                        <td class="btn1_right"></td>
			                                        </tr>
			                                </table></td>
			                        </tr>
			                        </table></td>
			                 </tr>
			              </table>
			         <!--Button (E) -->

                </td></tr>
                </table>
                <!-- TABLE '#D' : ( Button : Main ) (E) -->

                <!-- TABLE '#D' : ( Search Options : F.Forwarder ) (S) -->
		        <table class="search">
		        <tr><td class="bg">
                                <table class="search_in" border="0">
                                        <tr class="h23">
                                                <td width="12%">F/Forwarder</td>
                                                <td>&nbsp;<input type="text" name="search_brog_cnt_cust_seq" style="width:100;ime-mode:disabled;" onKeyPress="ComKeyOnlyAlphabet('uppernum')" maxlength="8"><input type="hidden" name="search_brog_cnt_cust_seqName">
                                                        <a href="javascript:openWindowCustomer(document.form);" class="purple"><img class="cursor" src="/opuscntr/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></a></td></tr>
                                </table>
                        </td></tr>
                </table>
                <!-- TABLE '#D' : ( Search Options : F.Forwarder  ) (E) -->

                <table class="height_10"><tr><td></td></tr></table>

                <!-- TABLE '#D' : ( Search Options ) (S) -->
                <table class="search">
                <tr><td class="bg">

	                <!-- : ( grid ) (S) -->
	                <table width="100%" id="mainTable">
	                          <tr><td>
	                         <script language="javascript">ComSheetObject('sheet1');</script>
	                          </td></tr>
	                </table>
		            <!-- : ( grid ) (E) -->

	                <!-- : ( Button : Sub ) (S) -->
	                <table width="100%" class="button">
	                      <tr><td class="btn2_bg">
	                                        <table border="0" cellpadding="0" cellspacing="0">
	                                        <tr>
	                                                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
	                                                        <tr><td class="btn2_left"></td>
	                                                        <td class="btn2" name="btng_rowadd">Row&nbsp;Add</td>
	                                                        <td class="btn2_right"></td>
	                                                        </tr>
	                                                        </table></td>
	                                                                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
	                                                        <tr><td class="btn2_left"></td>
	                                                        <td class="btn2" name="btng_rowcopy">Row Copy</td>
	                                                        <td class="btn2_right"></td>
	                                                        </tr>
	                                                        </table></td>

	                                          </tr></table>
	                   			</td></tr>
	                  </table>
	                  <!-- : ( Button : Sub ) (E) -->

                        </td></tr>
                </table>
                <!-- TABLE '#D' : ( Search Options ) (E) -->



</td></tr>
</table>
<!-- Outer Table (E)-->



</form>
</body>
</html>
