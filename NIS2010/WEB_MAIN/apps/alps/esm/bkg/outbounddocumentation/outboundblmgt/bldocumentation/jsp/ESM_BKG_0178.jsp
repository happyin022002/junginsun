<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0178.jsp
*@FileTitle : C/M by Container
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.06.11 김영출
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg0178Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg0178Event  event = null;                    //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;            //서버에서 발생한 에러
    String strErrMsg = "";                        //에러메세지
    int rowCount     = 0;                        //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    Logger log = Logger.getLogger("com.hanjin.apps.OutboundBLMgt.BLDocumentation");
	
	String cntrNo = "";
	String cntrTpCd = "";
	String tVvd = "";

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id =    account.getUsr_id();
        strUsr_nm = account.getUsr_nm();


        event = (EsmBkg0178Event)request.getAttribute("Event");
		cntrNo = event.getCntrNo();
		tVvd   = event.getTVvd();
				
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
<title>C/M by Container</title>
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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업    -->
<input type="hidden" name="bkg_no">
<input type="hidden" name="bdr_flg">

<!-- 
<table width="978" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
    <tr><td valign="top">
 -->

        <!--Page Title, Historical (S)-->
        <!--table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
            <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle">&nbsp;M&amp;R >> Equipment Repair Approval Authority Creation</td></tr>
            <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; C/M (Container by Manifest) by Container</td></tr>
        </table-->
        <!-- table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
            <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
            <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
        </table -->
        <!--Page Title, Historical (E)-->

<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp" %>

        <!--biz page (S)-->
        <table width="100%" class="search">
            <tr><td class="bg">

                <!--  biz_1 (S) -->
                <table class="search" border="0" style="width:979;">
                    <tr class="h23">
                        <td width="87">Container No.</td>
                        <td width="231"><input type="text" name="cntr_no" value="<%=cntrNo%>" style="ime-mode:disabled;width:104;" dataformat="engupnum" class="input1">&nbsp;<input type="text" name="cntr_tpsz_cd" value="<%=cntrTpCd%>" style="ime-mode:disabled;width:30;" dataformat="engupnum" class="input2" readOnly></td>
                        <td width="70">Seal No.</td>
                        <td width="137"><select name="cntr_seal_no" style="width:100;" class="input2"></select></td>
                        <td width="63">T/VVD</td>
                        <td width="130"><input type="text" name="t_vvd" value="<%=tVvd%>" style="ime-mode:disabled;width:80;" dataformat="engupnum" class="input1"></td>
                        <td width="70">BKG Office</td>
                        <td width=""><input type="text" name="bkg_ofc_cd" style="ime-mode:disabled;width:50;" dataformat="engupnum" class="input2" readOnly ></td>
                    </tr>
                </table>
                <table class="search" border="0" style="width:979;">
                    <tr class="h23">
                        <td width="87">Route</td>
                        <td width="231"><input type="text" name="por_cd" style="ime-mode:disabled;width:50;" dataformat="engupnum" class="input2" readOnly>&nbsp;<input type="text" name="pol_cd" style="ime-mode:disabled;width:50;" dataformat="engupnum" class="input2" readOnly>&nbsp;<input type="text" name="pod_cd" style="ime-mode:disabled;width:50;" dataformat="engupnum" class="input2" readOnly>&nbsp;<input type="text" name="del_cd" style="ime-mode:disabled;width:50;" dataformat="engupnum" class="input2" readOnly>&nbsp;</td>
                        <td width="70">R/D Term</td>
                        <td width="60"><input type="text" name="rcv_term_cd" style="ime-mode:disabled;width:20;" dataformat="engupnum" class="input2" readOnly>&nbsp;<input type="text" name="de_term_cd" style="ime-mode:disabled;width:20;" dataformat="engupnum" class="input2" readOnly></td>
                        <td width="140">Ahead / Short-ship</td>
                        <td width="80"><input type="text" name="adv_shtg_cd"  style="ime-mode:disabled;width:35;" dataformat="engupnum" class="input2" readOnly></td>
                        <td width="" align="right">DG<input type="checkbox" name="dcgo_flg" class="trans">&nbsp;&nbsp;&nbsp;BB<input type="checkbox" name="bb_cgo_flg" class="trans">&nbsp;&nbsp;&nbsp;AK<input type="checkbox" name="awk_cgo_flg" class="trans">&nbsp;&nbsp;&nbsp;RF<input type="checkbox" name="rc_flg" class="trans">&nbsp;&nbsp;&nbsp;RD<input type="checkbox" name="rd_cgo_flg" class="trans">&nbsp;&nbsp;&nbsp;HG<input type="checkbox" name="hngr_flg" class="trans"></td>
                    </tr>
                </table>
                <table class="search" border="0" style="width:979;">
                    <tr class="h23">
                        <td width="87">Package</td>
                        <td width="231"><input type="text" name="pck_qty"  style="width:50;text-align:right;" class="input2" readOnly dataformat="int" maxlength="7">&nbsp;<input type="text" name="pck_tp_cd" style="ime-mode:disabled;width:25;" dataformat="engup" maxlength="2" class="input2" readOnly></td>
                        <td width="70">Weight</td>
                        <td width="140"><input type="text" name="cntr_wgt" style="width:80;text-align:right;" class="input2" readOnly dataformat="float" maxlength="13" pointcount="3">&nbsp;<input type="text" name="wgt_ut_cd" style="ime-mode:disabled;width:35;" dataformat="engupnum" class="input2" readOnly></td>
                        <td width="60">Measure</td>
                        <td><input type="text" name="meas_qty" style="width:80;text-align:right;" class="input2" readOnly dataformat="float" maxlength="9" pointcount="3">&nbsp;<input type="text" name="meas_ut_cd" style="ime-mode:disabled;width:35;" dataformat="engupnum"  class="input2" readOnly></td>
                        </tr>
                </table>
                <table class="line_bluedot"><tr><td></td></tr></table>
                <!--  biz_1   (E) -->

                <!-- Grid_1  (S) -->
                <table width="100%"  id="mainTable">
                    <tr>
                        <td width="100%">
                            <script language="javascript">ComSheetObject('sheet1');</script>
                        </td>
                    </tr>
                </table>
                <!-- Grid_1 (E) -->

        </td></tr>
	</table>
	
	<table class="height_8"><tr><td></td></tr></table>

	<table width="100%" class="search">
        <tr><td class="bg">

        <!-- Grid_2 (S) -->
        <table width="100%"  id="mainTable">
            <tr>
                <td width="100%">
                    <script language="javascript">ComSheetObject('sheet2');</script>
                </td>
            </tr>
        </table>
        <!-- Grid_2 (E) -->
 <!--  Button_Sub (S) -->
        <table width="100%" class="button"table border="0">
            <tr><td class="btn2_bg">
                <table border="0" cellpadding="0" cellspacing="0">
                <tr>
                    <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn2_left"></td>
                    <td class="btn2" name="btn_add">Row Add</td>
                    <td class="btn2_right"></td>
                    </tr>
                    </table></td>
                    <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn2_left"></td>
                    <td class="btn2" name="btn_del">Row Delete</td>
                    <td class="btn2_right"></td>
                    </tr>
                    </table></td>		
                </tr>
                </table>

            </td></tr>
        </table>
        <!-- Button_Sub (E) -->
		<!--  -->
		<table border="0">
			<tr class="h23">
				<td>Total Package</td>
				<td><input name="cm_pck_qty" type="text" style="width:90; text-align:right" class="input2" readOnly dataformat="int" maxlength="7"></td>
				<td width="7"></td>
				<td>Total Weight</td>
				<td><input name="cm_cntr_wgt" type="text" style="width:90; text-align:right" class="input2" readOnly dataformat="float" maxlength="13" pointcount="3"></td>
				<td width="7"></td>
				<td>Total Measure</td>
				<td><input name="cm_meas_qty" type="text" style="width:90; text-align:right" class="input2" readOnly dataformat="float" maxlength="9" pointcount="3"></td>
			</tr>
		</table>
		<!--  -->
		
       



            </td></tr>
        </table>
        <!--biz page (E)-->
		
		<table class="height_8"><tr><td></td></tr></table>

        <!--Button (S) -->
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;">
            <tr><td class="btn1_bg">

                <table border="0" cellpadding="0" cellspacing="0">
                <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn1_left"></td>
                        <td class="btn1" name="btn_retrieve">Retrieve</td>
                        <td class="btn1_right"></td>
                        </tr>
                    </table></td>
                    
                    <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn1_left"></td>
                        <td class="btn1" name="btn_new">New</td>
                        <td class="btn1_right"></td>
                        </tr>
                    </table></td>
                    
                    <td class="btn1_line"></td>
                    <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn1_left"></td>
                        <td class="btn1" name="btn_save">Save</td>
                        <td class="btn1_right"></td>
                        </tr>
                    </table></td>
                    <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn1_left"></td>
                        <td class="btn1" name="btn_cntrlist">CNTR List</td>
                        <td class="btn1_right"></td>
                        </tr>
                    </table></td></tr>
                </table>
            </td></tr>
        </table>
        <!--Button (E) -->

    </td></tr>
</table>


<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_CLOSE.jsp" %>

<!-- 개발자 작업  끝 -->
</form>
<form name="form2">
<input type="hidden" name="func">
<input type="hidden" name="mk_desc">
<input type="hidden" name="gds_desc">
</form>

</body>
</html>