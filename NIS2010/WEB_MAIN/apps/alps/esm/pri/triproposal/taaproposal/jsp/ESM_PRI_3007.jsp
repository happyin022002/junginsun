<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_3007.jsp
*@FileTitle : TAA Creation & Amendment
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.18
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.11.18 문동규
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
<%@ page import="com.hanjin.apps.alps.esm.pri.triproposal.taaproposal.event.EsmPri3007Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>

<%
	EsmPri3007Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String usrId = null;
	String usrSrepCd = null;
	String usrOfcCd	 = null;
    String condTaaNo = null;
    String[] svcScpCds = null;
    String[] svcScpTrfs = null;
	Logger log = Logger.getLogger("com.hanjin.apps.TRIProposal.TAAProposal");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		usrId = account.getUsr_id();
		usrSrepCd = account.getSrep_cd();
		usrOfcCd = account.getOfc_cd();

		event = (EsmPri3007Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        condTaaNo = JSPUtil.getNull(request.getParameter("cond_taa_no"));
        // Service Scope Combo Data 생성
        svcScpCds = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("svcScpCd"));
        
        svcScpTrfs = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("svcScpCd"),false ,"|","\t","getCd","getEtc4"); 
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>TAA Creation & Amendment</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
    var svcScpComboValue = "|<%=svcScpCds[0]%>";
    var svcScpComboText = " \t |<%=svcScpCds[1]%>";
    
    var svcScpTrfsValue = "<%=svcScpTrfs[0]%>";
    var svcScpTrfsText  = "<%=svcScpTrfs[1]%>";

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
<input type="hidden" name="usr_id" value="<%=usrId %>">
<input type="hidden" name="usr_srep_cd" value="<%=usrSrepCd %>">
<input type="hidden" name="usr_ofc_cd" value="<%=usrOfcCd %>">
<input type="hidden" name="old_svc_scp_cd">
<input type="hidden" name="taa_prop_no">
<input type="hidden" name="cond_taa_no" value="<%=condTaaNo %>">
<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">

    <tr><td valign="top">
    <!--Page Title, Historical (S)-->
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
            <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
            <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
        </table>
    <!--Page Title, Historical (E)-->
    <!--Button (S) -->
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:0;">
        <tr><td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Retrieve" id="btn_retrieve">Retrieve</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_New">New</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td class="btn1_line"></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Amend">Amend</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Save">Save</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Confirm">Confirm</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="btn_ConfirmCancel">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_ConfirmCancel">Confirm Cancel</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="btn_Cancel">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Cancel">Cancel</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
            </tr>
            </table>
        </td>
        </tr>
        </table>

    <!--Button (E) -->
    <table class="height_2"><tr><td colspan="8"></td></tr></table>
    <!--biz page (S)-->
    <table class="search">
        <tr><td class="bg">
                <table class="search" border="0" style="width:979;">
                <tr class="h23">
                    <td width="85">TAA No.</td>
                    <td width="85"><input type="text" caption="TAA Number" name="taa_no" maxlength="12" 
                        style="width:80;ime-mode:disabled;text-align:center;" dataformat="engup" class="input"></td>
                    <td width="90">
                    <table><tr><td><img src="img/btns_search.gif" width="19" height="20" alt="" border="0" 
                        align="absmiddle" name="btn_taa_no" class="cursor">
                    </td></tr></table>
                    </td>
                    <td width="60">AMD  No.</td>
                    <td width="100"><script language="javascript">ComComboObject('amdt_seq', 2, 60, 1, 0, 0, false);</script>
                    </td>
                    <td width="60">Duration</td>
                    <td width="86"><input type="text" caption="Effective date" name="eff_dt" cofield="exp_dt" maxlength="10" 
                        dataformat="ymd" style="width:80;text-align:center;" class="input1" required>
                    </td>
                    <td width="20">
                        <table><tr><td><img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btns_calendar1" class="cursor"></td></tr></table>
                    </td>
                    <td width="102">&nbsp;~&nbsp;<input type="text" caption="Expiration date" name="exp_dt" cofield="eff_dt" maxlength="10" 
                        dataformat="ymd" style="width:80;text-align:center;" class="input1" required>
                    </td>
                    <td width="80">
                        <table><tr><td><img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btns_calendar2" class="cursor"></td></tr></table>
                    </td>
                    <td width="80">Confirmation</td>
                    <td width=""><input type="text" name="cfm_nm" style="width:70;text-align:center;" class="input2" readonly="readonly"></td>
                </tr></table>
                <table class="line_bluedot"><tr><td></td></tr></table>
                <table class="search" border="0" style="width:979;">
                <tr class="h23">
                    <td width="85">Service Scope</td>
                    <td width="85"><script language="javascript">ComComboObject('svc_scp_cd', 2, 80, 0, 1, 0, false);</script></td>
                    <td width="" style="padding-bottom:1"><input name="svc_scp_nm" type="text" style="width:393;text-align:left;" class="input2" readonly="readonly" caption="Service Scope">
                    </td>
                </tr></table>
                <table class="search" border="0" style="width:979;">
                <tr class="h23">
                    <td width="85">Customer</td>
                    <td width="90"><input type="text" style="width: 25;"
                        dataformat="engup" maxlength="2" minlength="2" name="ctrt_cust_cnt_cd"
                        class="input1" caption="Customer Code" required>&nbsp;<input
                        type="text" style="width: 55;" dataformat="int" name="ctrt_cust_seq"
                        maxlength="6" class="input1" caption="Customer Sequence"
                        required>&nbsp;</td>
                    <td width="20">
                    <table>
                        <tr>
                            <td><img src="img/btns_search.gif" width="19" height="20"
                                alt="" border="0" align="absmiddle" name="btn_ctrt_cust"
                                class="cursor"></td>
                        </tr>
                    </table>
                    </td>
                    <td width="230"><input type="text" style="width: 187;"
                        name="ctrt_cust_nm" readonly="readonly" class="input2"></td>
                    <td width="60">Office</td>
                    <td width="90"><input type="text" name="respb_sls_ofc_cd" dataformat="engup" readonly="readonly"
                        style="width:78;text-align:left;" class="input2" caption="Request Office Code" 
                        required></td>
                    <td width="70">Sales Rep.</td>
                    <td width="82"><script language="javascript">ComComboObject('respb_srep_cd', 3, 80, 0, 1);</script></td>
                    <td width="" style="padding-bottom:1"><input type="text" style="width:200;text-align:left;" 
                        name="respb_srep_nm" readonly="readonly" class="input2"></td>
                </tr></table>

    </td></tr></table>

    <table class="height_8"><tr><td></td></tr></table>

    <table class="search">
        <tr><td class="bg">
                <!-- : ( Grid ) (S) -->
                <table width="100%"  id="mainTable" style="display:none;">
                <tr>
                    <td width="100%">
                    <script language="javascript">ComSheetObject('sheet1');</script>
                    </td>
                </tr>
                </table>
                <table width="100%"  id="mainTable">
                <tr>
                    <td width="100%">
                    <script language="javascript">ComSheetObject('sheet2');</script>
                    </td>
                </tr>
                </table>
                <!-- : ( Grid ) (E) -->
                <table width="100%" class="button">
                            <tr><td class="btn2_bg">
                            <table border="0" cellpadding="0" cellspacing="0"><tr>
                                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                <tr><td class="btn2_left"></td>
                                <td class="btn2" name="btn_RowAdd">Row Add</td>
                                <td class="btn2_right"></td></tr>
                                </table></td>
                                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                <tr><td class="btn2_left"></td>
                                <td class="btn2" name="btn_RowDelete">Delete</td>
                                <td class="btn2_right"></td></tr>
                                </table></td>
                            </tr></table>
                        </td></tr>
                        </table>

                <table class="height_8"><tr><td></td></tr></table>

                <table class="grid2" border="0" style="width:100%;">
                <tr class="tr2_head">
                    <td width="25%">Origin</td>
                    <td width="25%">Origin Via</td>
                    <td width="25%">Desination Via</td>
                    <td width="25%">Desination </td>
                </tr>
                <tr class="input2">
                    <td><textarea name="org_pnt_loc_nm" style="width:100%; height:95;" class="textarea2" readonly="readonly"></textarea></td>
                    <td><textarea name="org_via_port_nm" style="width:100%; height:95;" class="textarea2" readonly="readonly"></textarea></td>
                    <td><textarea name="dest_via_port_nm" style="width:100%; height:95;" class="textarea2" readonly="readonly"></textarea></td>
                    <td><textarea name="dest_pnt_loc_nm" style="width:100%; height:95;" class="textarea2" readonly="readonly"></textarea></td>

                </tr></table>
            </td>
            </tr></table>

        <!-- <table class="height_10"><tr><td></td></tr></table> -->

</td></tr>
</table>


<!-- 개발자 작업  끝 -->
</form>
</body>
</html>