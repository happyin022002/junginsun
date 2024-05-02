<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0034_04.jsp
*@FileTitle : B/L Inquiry_Remarks
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
<input type="hidden" name="ibflag">
<input type="hidden" name="tab_no" value="4">
<input type="hidden" name="bl_no">
<input type="hidden" name="bak_diff_rmk">

<!-- 개발자 작업	-->
        <table class="search" style="width:979;"> 
        <tr><td class="bg">
                <!--  biz_1  (S) -->
			    <table class="search" border="0" style="width:979;height:285;"> 
			    <tr class="h23">
			    <td width="600" valign="top">
			        <table width="100%" class="search"> 
			        <tr><td><textarea name="diff_rmk" style="width:99%;height:280" ></textarea></td>
			        </tr>
			        </table> 
			    </td>
			    <td width="10"></td>
			    <td width="369" valign="top">
			        <!-- table border="0" style="width:100%; background-color:white;" class="grid2"> 
			        <tr class="tr2_head">
				        <td width="33%">Container No.</td>
				        <td width="34%">Rail AMS File No.</td>
				        <td width="33%">P/MIB No.</td>
			        </tr>
			        <tr><td width="" class="input2"><input type="text" name="cntr_no1" style="width:100%;" class="noinput2"></td>
			            <td width="" class="input2"><input type="text" name="rail_crr_ref_no1" style="width:100%;" class="noinput2"></td>
                        <td width="" class="input2"><input type="text" name="usa_ib_trsp_no1" style="width:100%;" class="noinput2"></td>
			        </tr>
			        <tr><td width="" class="input2"><input type="text" name="cntr_no2" style="width:100%;" class="noinput2"></td>
			            <td width="" class="input2"><input type="text" name="rail_crr_ref_no2" style="width:100%;" class="noinput2"></td>
                        <td width="" class="input2"><input type="text" name="usa_ib_trsp_no2" style="width:100%;" class="noinput2"></td>
			        </tr>
			        <tr><td width="" class="input2"><input type="text" name="cntr_no3" style="width:100%;" class="noinput2"></td>
			            <td width="" class="input2"><input type="text" name="rail_crr_ref_no3" style="width:100%;" class="noinput2"></td>
                        <td width="" class="input2"><input type="text" name="usa_ib_trsp_no3" style="width:100%;" class="noinput2"></td>
			        </tr>
			        </table --> 
			        <table width="100%" id="mainTable">
                    <tr>
                        <td width="100%"><script language="javascript">ComSheetObject('t4sheet1');</script></td>
                    </tr>
                    <tr>
                    	<td align="right">
							<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn_railAMS" id="btn_railAMS">Rail AMS History</td>
									<td class="btn1_right"></td>
									</tr>
								</table></td>
			                    </tr>
			                </table>
			            </td>
			        </tr>
                </table>
			    </td></tr>
			    </table>
                <!--  biz_1   (E) -->
            
            </td></tr>
        </table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>