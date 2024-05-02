<%/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0503.jsp
 *@FileTitle : Transmit Cross-Check
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.01.17
 *@LastModifier : 이수진
 *@LastVersion : 1.0
 * 2011.01.17 이수진
 * 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.event.EsmBkg0503Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0503Event  event = null;				//PDTO(Data Transfer Object including Parameters)

	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList    = "";
	String pageRows    = "100";

	String strUsr_id   = "";
	String strUsr_nm   = "";
    String strCnt_cd   = "";
    String strOff_cd   = "";

	String strPgmNo    = "";
	String strTransMode = "";
    String strLocNm    = "";

    String toDate = "";

	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.customstransmission");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strCnt_cd = account.getCnt_cd();
		strOff_cd = account.getOfc_cd();

		toDate = DateTime.getDateString();
		toDate = toDate.replace(".","-");

		event = (EsmBkg0503Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        strPgmNo = request.getParameter("pgmNo");


	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Transmit Cross-Check</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage("<%=strOff_cd%>");
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="cnt_cd" value="<%=strCnt_cd.substring(0,2)%>">
<input type="hidden" name="loc_cd">
<input type="hidden" name="loc_nm" value="<%=strLocNm%>">
<input type="hidden" name="trans_mode" value="<%=strTransMode%>">
<input type="hidden" name="gubun">
<input type="hidden" name="portCd" value="">
<input type="hidden" name="offCd" value="<%=strOff_cd %>">

<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td valign="top">

		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->

        <!--biz page (S)-->
        <table class="search">
            <tr><td class="bg">

                <!--  biz_1  (S) -->
                <table class="search" border="0" style="width:979;">
                <tr class="h23">
                    <td width="270">
                    	<table class="" border="0" style="width:270;">
               				<tr class="h23">
               				<td width="80"><input type="radio" class="trans" name="rad_dep_type" value = "date"  checked>
                	    		<select style="width:50;" class="input" name = "dep_type">
                        		<option value="ETD" selected>ETD</option>
                       		    <option value="ETA">ETA</option>
                                </select></td>
                            <td width="">
					     	<input type="text" style="width:70;" value="<%=toDate%>" maxlength="10" dataformat="ymd" class="input1"  name="start_dt"  >
						    ~&nbsp;<input type="text" style="width:70;" value="<%=toDate%>" maxlength="10" name="end_dt" dataformat="ymd" class="input1">
					        <img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar"></td>
                            </tr></table>
                    </td>

                    <td width="280">
                    	<table class="search_sm2" border="0" style="width:250;">
               				<tr class="h23">
               				<td width="110">POL &nbsp;<input type="text" style="width:70;" class="input1" name="pol" dataformat="engupnum" caption="POL" fullfill maxlength="5"></td>
                            <td width="">POD &nbsp;<input type="text" style="width:60;" class="input2" name="pod" dataformat="engupnum" caption="POD" fullfill maxlength="5"></td>
                            </tr></table>
                   </td>

                   <td width="110">
                    	<table class="search_sm2" border="0" style="width:150;">
               				<tr class="h23">
               				<td width="62"><input type="radio" class="trans" name="rad_vvd" value="vvd" >&nbsp;VVD</td>
                            <td width=""><input type="text" style="width:70" class="input2" name="vvd" required dataformat="eng" maxlength="9" fullfill caption="VVD">
                            </td>
                            </tr></table>
                   </td>
                    <td width="10"></td>
                    <td width="122">
                    	<table class="search_sm2" border="0" style="width:122;">
               				<tr class="h23">
               				<td width="70">OPR&nbsp;</td>
                            <td width="60"><select style="width:75;" name="opr_type" class="input">
                        		<option value="" selected>ALL </option>
                       		    <option value="NYK">NYK       </option>
                       		    <option value="OTHERS">OTHERS </option>
                                </select></td>
                            </tr></table>
                   </td>
                </tr>
                </table>
                <table class="search" border="0" style="width:979;"><tr class="h23"><td height="5"></td></tr></table>
                 <table class="search" border="0" style="width:979;">
                <tr class="h23">
                    <td width="192">
                    	<table class="search_sm2" border="0" style="width:160;">
               				<tr class="h23">
               				<td width="270">Type&nbsp;<select style="width:130;" class="input" name="sel_type" >
               				                        <option value="" selected >ALL     </option>
                        		     				<option value="A">A : 미주 Local     </option>
                       		   					    <option value="B">B : 아/구주 Local   </option>
                       		   					    <option value="C">C : T/S           </option>
                       		   					    <option value="D" >D        </option>
                                                    </select></td>
                            </tr></table>
                    </td>

                    <td width="200">
                    	<table class="search_sm2" border="0" style="width:100%;">
               				<tr class="h23">
               				<td width="50"><input type="radio" class="trans" name="rad_trans_type" value="ALL"  >&nbsp;All</td>
                            <td width="55"><input type="radio" class="trans" name="rad_trans_type" value="SEND" >&nbsp;Send</td>
                           <td width=""><input type="radio" class="trans" name="rad_trans_type" value="UNSEND" checked >&nbsp;Un-Send</td>
                           </tr></table>
                   </td>

                    <td width="200">
                    	<table class="search_sm2" border="0" style="width:100%;">
               				<tr class="h23">
               				<td width="50"><input type="radio" class="trans" name="rad_lane_type" value="" checked>&nbsp;All</td>
                            <td width="55"><input type="radio" class="trans" name="rad_lane_type" value="TRUNK" >&nbsp;Trunk</td>
                           <td width=""><input type="radio" class="trans" name="rad_lane_type" value="OFFLINE" >&nbsp;Off-line</td>
                           </tr></table>
                     </td>
                    <td width=""></td>
                </tr>
                </table>







                <!--  biz_1   (E) -->
                <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>

                <!-- Grid  (S) -->
                <table width="100%"  id="mainTable">
                    <tr>
                        <td width="100%">
                            <script language="javascript">ComSheetObject('sheet1');</script>
                        </td>
                    </tr>

                </table>
                <!-- Grid (E) -->


                <div style="display:none" id="col1">
					<table class="search" border="0" style="width:979;">

						<tr><td class="stm" width="100%" style=" font-weight:bold;" > * TYPE_A (미주 Local)</td></tr>
						<tr><td class="stm" width="100%" style=" font-weight:bold;"> * TYPE_B (아/구주 Local)</td></tr>
						<tr><td class="stm" width="100%" style=" font-weight:bold;"> * TYPE_C (TS/MTY)</td></tr>
						<tr><td class="stm" width="100%" style=" font-weight:bold;"> * TYPE_D (A+B+C)</td></tr>
						<tr><td class="stm" width="" style=" font-weight:bold;"> * TYPE_OTH (NYK - NO BKG, CUST OPR BKG ONLY)</td></tr>

					</table>
				</div>
				<div id="col2">
					<table class="search" border="0" style="width:979;">

					<tr><td class="stm" width="100%" style=" font-weight:bold;"> * TYPE (General)</td></tr>
					<tr><td class="stm" width="" style=" font-weight:bold;"> * TYPE_OTH (NYK - NO BKG, CUST OPR BKG ONLY)</td></tr>

					</table>
				</div>



	        </td></tr>
        </table>
        <!--biz page (E)-->

        <!--Button (S) -->
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
        <tr><td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
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
                    <td class="btn1" name="btn_manifest_generate">Manifest Generate</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
            </tr>
            </table>
        </td></tr>
        </table>
        <!--Button (E) -->

</td></tr>
</table>

<!-- 본문끝 -->

<!-- 개발자 작업  끝 -->
</form>
<iframe name="download" id="download" style="display:none;width:1px;height:1px;" onreadystatechange="ComOpenWait(false);"></iframe>
</body>
</html>