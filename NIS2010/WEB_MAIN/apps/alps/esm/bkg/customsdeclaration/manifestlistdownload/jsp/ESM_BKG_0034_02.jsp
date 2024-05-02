<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0034_02.jsp
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
<input type="hidden" name="fwdr_ibflag">
<input type="hidden" name="antf_ibflag">
<input type="hidden" name="tab_no" value="2">
<input type="hidden" name="bl_no">
<input type="hidden" name="fwdr_bkg_cust_tp_cd" value="F">
<input type="hidden" name="antf_bkg_cust_tp_cd" value="A">
<input type="hidden" name="cust_tp">

<!-- 개발자 작업	-->
        <table class="search"> 
        <tr><td class="bg">
                <!--  biz_1  (S) -->
                
                <table class="search" border="0" style="width:979;height:285;">
                    <tr class="h23">
                        <td width="480" valign="top">
                        
                            <table class="search" border="0" style="width:480;">
                                <tr class="h23">
                                    <td width="82" style="text-align:center; background-color:#F3F2F8;border:1px solid #E8EFF9;">F/Forward</td>
                                    <td width="">
	                                    <input type="text" name="fwdr_cust_cnt_cd" style="width:30; ime-mode: disabled" 
	                                       dataformat="engup" maxlength="2" required fullfill caption="F/Fowarder Country Code" class="input">
	                                    <input type="text" name="fwdr_cust_seq" style="width:60;text-align:right; ime-mode: disabled" 
	                                       dataformat="int" maxlength="6" required caption="F/Fowarder Customer Seq." class="input">
                                        <img class="cursor" name="btn_cust_f" src="img/btns_inquiry.gif" width="19" height="20" border="0" align="absmiddle">
                                    </td>
                                </tr>
                            </table>
                            <table class="grid2" border="0" style="width:480;">
                                <tr class="h23">
                                    <td width="80" class="tr_head2">Name</td>
                                    <td colspan="3"><textarea name="fwdr_cust_nm" style="width:100%;overflow-y:hidden;" rows="2"></textarea></td>
                                </tr>
                                <tr class="h23">
                                    <td width="80" class="tr_head2">Address</td>
                                    <td colspan="3"><textarea name="fwdr_cust_addr" style="width:100%;overflow-y:hidden;" rows="3"></textarea></td>
                                </tr>
                                <tr class="h23">
                                    <td width="80" class="tr_head2">Tel.</td>
                                    <td width="160"><input type="text" name="fwdr_phn_no" style="width:100%;" dataformat="saupja" class="input"></td>
                                    <td width="80" class="tr_head2">Fax</td>
                                    <td width="160"><input type="text" name="fwdr_fax_no" style="width:100%;" dataformat="saupja" class="input"></td>
                                </tr>
                            </table>
                        
                        </td>
                        <td width="19"></td>
                        <td width="480" valign="top">
                        
                            <table class="search" border="0" style="width:480;">
                                <tr class="h23">
                                    <td width="82" style="text-align:center; background-color:#F3F2F8;border:1px solid #E8EFF9;">A/Notify</td>
                                    <td width="">
	                                    <input type="text" name="antf_cust_cnt_cd" style="width:30; ime-mode: disabled" 
	                                       dataformat="engup" maxlength="2" required fullfill caption="A/Notify Country Code" class="input">
	                                    <input type="text" name="antf_cust_seq" style="width:60;text-align:right; ime-mode: disabled" 
	                                       dataformat="int" maxlength="6" required caption="A/Notify Customer Seq." class="input">
                                        <img class="cursor" name="btn_cust_a" src="img/btns_inquiry.gif" width="19" height="20" border="0" align="absmiddle">
                                    </td>
                                </tr>
                            </table>
                            <table class="grid2" border="0" style="width:480;">
                                <tr class="h23">
                                    <td width="80" class="tr_head2">Name</td>
                                    <td colspan="3"><textarea name="antf_cust_nm" style="width:100%;overflow-y:hidden;" rows="2"></textarea></td>
                                </tr>
                                <tr class="h23">
                                    <td width="80" class="tr_head2">Address</td>
                                    <td colspan="3"><textarea name="antf_cust_addr" style="width:100%;overflow-y:hidden;" rows="3"></textarea></td>
                                </tr>
                                <tr class="h23">
                                    <td width="80" class="tr_head2">Tel.</td>
                                    <td width="160"><input type="text" name="antf_phn_no" style="width:100%;" dataformat="saupja" class="input"></td>
                                    <td width="80" class="tr_head2">Fax</td>
                                    <td width="160"><input type="text" name="antf_fax_no" style="width:100%;" dataformat="saupja" class="input"></td>
                                </tr>
                            </table>
                        
                        </td>
                    </tr>
                </table>
                <!--  biz_1   (E) -->
            
	            <!-- Hidden sheet for Transaction (S) -->
	            <table width="100%" id="mainTable">
	                <tr>
	                    <td width="100%"><script language="javascript">ComSheetObject('t2sheet1');</script></td>
	                </tr>
                    <tr>
                        <td width="100%"><script language="javascript">ComSheetObject('t2sheet2');</script></td>
                    </tr>
	            </table>
	            <!-- Hidden sheet for Transaction (E) -->
            
            </td></tr>
        </table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>