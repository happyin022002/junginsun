<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0034_01.jsp
*@FileTitle : B/L Inquiry_Customs
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.06
*@LastModifier : 이수빈
*@LastVersion : 1.0
* 2009.05.06 이수빈
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.event.EsmBkg0034Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
    EsmBkg0034Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.hanjin.apps.SCGuideline.SCGuidelineMain");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0034Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>B/L Inquiry_Customs Result</title>
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
<input type="hidden" name="pagerows" value="<%=pageRows %>">
<input type="hidden" name="shpr_ibflag">
<input type="hidden" name="cnee_ibflag">
<input type="hidden" name="ntfy_ibflag">
<input type="hidden" name="tab_no" value="1">
<input type="hidden" name="bl_no">
<input type="hidden" name="shpr_bkg_cust_tp_cd" value="S">
<input type="hidden" name="cnee_bkg_cust_tp_cd" value="C">
<input type="hidden" name="ntfy_bkg_cust_tp_cd" value="N">
<input type="hidden" name="cust_tp">

<!-- 개발자 작업	-->
        <table class="search"> 
        <tr><td class="bg">
                <!--  biz_1  (S) -->
                <table class="search" border="0" style="width:979;height:285;">
                    <tr class="h23">
                        <td width="480" valign="top">
                        <table class="grid2" border="0" style="width:100%;">
                            <tr class="h23">
                                <td width="81" style="text-align:center; background-color:#F3F2F8;border-top:1px solid #E8EFF9;border-right:1px solid #E8EFF9;border-left:1px solid #E8EFF9;">Shipper</td>
                                <td width="350" colspan="3" style=" background-color:#F3F2F8;border-top:1px solid #E8EFF9;border-right:1px solid #E8EFF9;">
                                <input type="text" name="shpr_cust_cnt_cd" style="width:30; ime-mode: disabled" 
                                    dataformat="engup" maxlength="2" required fullfill caption="Shipper Country Code" class="input">
                                <input type="text" name="shpr_cust_seq" style="width:60;text-align:right; ime-mode: disabled"
                                    dataformat="int" maxlength="6" required caption="Consignee Customer Seq." class="input">
                                <img class="cursor" name="btn_cust_s" src="img/btns_inquiry.gif" width="19" height="20" border="0" align="absmiddle"></td>
                            </tr>
                            <tr class="h23">
                                <td class="tr_head2">Name</td>
                                <td colspan="3"><textarea name="shpr_cust_nm" style="width:100%;overflow-y:hidden;" rows="2"></textarea></td>
                            </tr>
                            <tr class="h23">
                                <td class="tr_head2">Address</td>
                                <td colspan="3"><textarea name="shpr_cust_addr" style="width:100%;overflow-y:hidden;" rows="3"></textarea></td>
                            </tr>
                            <tr class="h23">
                                <td class="tr_head2">Tel.</td>
                                <td width="150"><input type="text" name="shpr_phn_no" style="width:100%;" dataformat="saupja" class="input"></td>
                                <td width="70" class="tr_head2">Fax.</td>
                                <td width="180"><input type="text" name="shpr_fax_no" style="width:100%;" dataformat="saupja" class="input"></td>
                            </tr>
                        </table>
                        
                        <table class="height_8"><tr><td></td></tr></table>
                        <table class="grid2" border="0" style="width:100%;">
                            <tr class="h23">
                                <td width="81" style="text-align:center; background-color:#F3F2F8;border-top:1px solid #E8EFF9;border-right:1px solid #E8EFF9;border-left:1px solid #E8EFF9;">Consignee</td>
                                <td width="270" colspan="3" style=" background-color:#F3F2F8;border-top:1px solid #E8EFF9;border-right:1px solid #E8EFF9;">
                                <input type="text" name="cnee_cust_cnt_cd" style="width:30; ime-mode: disabled"
                                    dataformat="engup" maxlength="2" required fullfill caption="Consignee Country Code" class="input">
                                <input type="text" name="cnee_cust_seq" style="width:60;text-align:right; ime-mode: disabled" 
                                    dataformat="int" maxlength="6" required caption="Consignee Customer Seq." class="input">
                                <img class="cursor" name="btn_cust_c" src="img/btns_inquiry.gif" width="19" height="20" border="0" align="absmiddle"></td>
                                </tr>
                            <tr class="h23">
                                <td class="tr_head2">Name</td>
                                <td colspan="3"><textarea name="cnee_cust_nm" style="width:100%;overflow-y:hidden;" rows="2"></textarea></td>
                            </tr>
                            <tr class="h23">
                                <td class="tr_head2">Address</td>
                                <td colspan="3"><textarea name="cnee_cust_addr" style="width:100%;overflow-y:hidden;" rows="3"></textarea></td>
                            </tr>
                            <tr class="h23">
                                <td class="tr_head2">Tel.</td>
                                <td width="150"><input type="text" name="cnee_phn_no" style="width:100%;" dataformat="saupja" class="input"></td>
                                <td width="70" class="tr_head2">Fax.</td>
                                <td width="180"><input type="text" name="cnee_fax_no" style="width:100%;" dataformat="saupja" class="input"></td>
                            </tr>
                        </table>
                        </td> 
                        <td width="19"></td>
                        <td width="480" valign="top">
                            <table class="grid2" border="0" style="width:100%;">
                            <tr class="h23">
                                <td width="80" style="text-align:center; background-color:#F3F2F8;border-top:1px solid #E8EFF9;border-right:1px solid #E8EFF9;border-left:1px solid #E8EFF9;">Notify</td>
                                <td width="350" colspan="3" style=" background-color:#F3F2F8;border-top:1px solid #E8EFF9;border-right:1px solid #E8EFF9;">
                                <input type="text" name="ntfy_cust_cnt_cd" style="width:30; ime-mode: disabled" 
                                    dataformat="engup" maxlength="2" required fullfill caption="Notify Country Code" class="input">
                                <input type="text" name="ntfy_cust_seq" style="width:60;text-align:right; ime-mode: disabled" 
                                    dataformat="int" maxlength="6" required caption="Consignee Customer Seq." class="input">
                                <img class="cursor" name="btn_cust_n" src="img/btns_inquiry.gif" width="19" height="20" border="0" align="absmiddle"></td>
                            </tr>
                            <tr class="h23">
                                <td class="tr_head2">Name</td>
                                <td colspan="3"><textarea name="ntfy_cust_nm" style="width:100%;overflow-y:hidden;" rows="2"></textarea></td>
                            </tr>
                            <tr class="h23">
                                <td class="tr_head2">Address</td>
                                <td colspan="3"><textarea name="ntfy_cust_addr" style="width:100%;overflow-y:hidden;" rows="3"></textarea></td>
                            </tr>
                            
                            <tr class="h23">
                                <td width="80" class="tr_head2">Tel.</td>
                                <td width="150"><input type="text" name="ntfy_phn_no" style="width:100%;" dataformat="saupja" class="input"></td>
                                <td width="70" class="tr_head2">Fax.</td>
                                <td width="180"><input type="text" name="ntfy_fax_no" style="width:100%;" dataformat="saupja" class="input"></td>
                            </tr>
                        </table>
                        
                        </td>
                </tr>
                </table>
                <!--  biz_1   (E) -->
            
	            <!-- Hidden sheet for Transaction (S) -->
	            <table width="100%" id="mainTable">
	                <tr>
	                    <td width="100%"><script language="javascript">ComSheetObject('t1sheet1');</script></td>
	                </tr>
                    <tr>
                        <td width="100%"><script language="javascript">ComSheetObject('t1sheet2');</script></td>
                    </tr>
	            </table>
	            <!-- Hidden sheet for Transaction (E) -->
            
            </td></tr>
        </table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>