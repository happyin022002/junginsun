<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0393.jsp
*@FileTitle : House B/L Data Input Checklist
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.30
*@LastModifier : 이수빈
*@LastVersion : 1.0
* 2009.07.30 이수빈
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.event.EsmBkg0393Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0393Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strCnt_cd        = "";
    String strPgmNo         = "";
    String strCustoms       = "";
	Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");
	
	String vvdCd = "";
	String polCd = "";
	String podCd = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strCnt_cd = account.getCnt_cd();
	   	   
		event = (EsmBkg0393Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		strPgmNo = request.getParameter("pgmNo");
        if("ESM_BKG_0393".equals(strPgmNo)) strCustoms = "US";
        if("ESM_BKG_0393_3".equals(strPgmNo)) strCustoms = "CA";
		
		vvdCd  = JSPUtil.getParameter(request, "vvd_cd");
		polCd  = JSPUtil.getParameter(request, "pol_cd");
		podCd  = JSPUtil.getParameter(request, "pod_cd");		
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>House B/L Data Input Checklist</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
<script language="javascript">
    var strCntCd = "<%=strCnt_cd%>";
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body  onLoad="javascript:setupPage();">
<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="customs" value="<%=strCustoms%>">
<input type="hidden" name="filer">
<input type="hidden" name="err_flg">

<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;padding-right:5;">
	<tr>
		<td valign="top">
        <!--Page Title, Historical (S)-->
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
            <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
            <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title">House B/L Data Input Checklist</span></td></tr>
        </table>
        <!--Page Title, Historical (E)-->
        
		<!--biz page (S)-->
		<table class="search"> 
	     	<tr><td class="bg">
			<!--  biz_1  (S) -->
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23"><td width="870">	
				
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="60">VVD</td>
					<td width="180"><input type="text" name="vvd" style="width:105; ime-mode: disabled;"  class="input1" value="<%=vvdCd%>"
                        dataformat="eng" maxlength="9" required fullfill caption="VVD"></td>
					<td width="50">POL</td>
					<td width="140"><input type="text" name="pol_cd" style="width:80; ime-mode: disabled;" class="input1" value="<%=polCd%>"
                        dataformat="engupnum" maxlength="5" required caption="POL"></td>
					<td width="30">POD</td>
					<td width="140"><input type="text" name="pod_cd" style="width:80; ime-mode: disabled;" class="input" value="<%=podCd%>"
                        dataformat="engupnum" maxlength="5" fullfill caption="POD"></td>
					<td width="110">Destined to</td>
					<td class="stm"><input type="text" name="conti_cd" style="width:20; ime-mode: disabled; text-align:center" value="M" class="input"
                        dataformat="eng" maxlength="1" fullfill caption="">&nbsp;(Continent)</td>
				</tr>
				<tr class="h23">
					<td width="">BKG OFC</td>
					<td width=""><input type="text" name="bkg_ofc_cd" style="width:105; ime-mode: disabled;" class="input"
                        dataformat="engup" maxlength="5" caption="BKG OFC"></td>
					<td width="">L.REP</td>
					<td width="" colspan="3"><input type="text" name="ob_srep_cd" style="width:80; ime-mode: disabled;" class="input"
                        dataformat="eng" maxlength="5" caption="L.REP"></td>
					<td width=""><%=strCustoms%> Filer</td>
					<td width="" style="padding-left:2">
						<script language="javascript">ComComboObject('mbl_filer', 2, 60, 1, 0);</script>
					</td>
				</tr>
				</table>
				
				</td>	
				<td width="">	
				
				<table class="search_sm2" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width=""><input type="radio" name="chk_err" value="all" class="trans" checked>&nbsp;All</td>
				</tr>
				<tr class="h23">
					<td width=""><input type="radio" name="chk_err" value="err" class="trans">&nbsp;Error</td>
				</tr>
				</table>
				
				</td>	
				</tr>
				</table>
				<!--  biz_1   (E) -->
												
				
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>	
				
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->
			<table class="total" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="50">&nbsp;Total</td>
					<td width="120"><input type="text" name="tot_bkg" class="input" style="width:105" readonly></td>
					<td width="100">&nbsp;</td>
					<td colspan="2"><input type="text" name="tot_mbl_ttl" style="width:400" class="input" readonly></td>
					<td width=""><input type="text" name="tot_bl" style="width:150; font-weight:bold;" class="input" readonly></td>
				</tr>
				<tr class="h23">
					<td>&nbsp;</td>
					<td><input type="text" name="tot_mbl" class="input" style="width:105" readonly></td>
					<td align="right"><%=strCustoms%> Filer 01 : </td>
					<td width="300">
						<input type="text" name="tot_hbl" style="width:150" class="input" readonly>&nbsp;
						<input type="text" name="tot_fileno" style="width:100" class="input" readonly>
					</td>
					<td width="100" align="right"> Other : </td>
					<td width="*">
						<input type="text" name="tot_hbl_etc" style="width:150" class="input" readonly>&nbsp;
						<input type="text" name="tot_fileno_etc" style="width:100" class="input" readonly>
					</td>
				</tr>
				</table>
				
				
				</td></tr>
			</table>

			    <!--biz page 2 (S)-->
			    <table border="0" width="100%" height="0" style="display:inline">
			        <tr>
			            <td><script language="javascript">comRdObject('report1');</script></td>
			        </tr>
			    </table>
			    <!--biz page 2 (E)-->
				
		
			<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DownExcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Print">Print</td>
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
<!-- Grid BG Box  (S) -->
<!--biz page (E)-->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
