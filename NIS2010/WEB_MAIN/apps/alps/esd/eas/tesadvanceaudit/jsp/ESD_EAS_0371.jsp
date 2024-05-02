<%--
/*=========================================================
*Copyright(c) 2009 CyberLogitec 
*@FileName : ESD_EAS_0371.jsp
*@FileTitle : Batch Result Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2015-04-14
*@LastModifier : Jong-Ock Kim
*@LastVersion : 1.0
* 1.0 최초 생성 
-------------------------------------------------------------------
* History

=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.eas.tesadvanceaudit.event.EsdEas0371Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%
    Exception serverException = null;	//서버에서 발생한 에러
    String strErrMsg = "";              //에러메세지
	String strOfc_cd = "";
    Logger log = Logger.getLogger("com.hanjin.apps.alps.esd.eas.ESD_EAS_0380");
	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strOfc_cd = account.getOfc_cd();
		
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        
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
<title>Batch Result Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		loadPage();
	}
</script>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="usr_ofc_cd" value="<%=strOfc_cd%>">

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>
	<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	</table>
	<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->

     <!--Button_L (S) -->
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
        <tr>
          <td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <!-- Repeat Pattern -->
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_new" name="btn_new">New</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td class="btn1_line"></td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_down_excel" name="btn_down_excel">Down Excel</td>
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
      <!--Button_L (E) -->
	
	<!--biz page (S)-->
		<table class="search" > 
       	<tr><td class="bg">		
			<!-- biz_1  (S) -->
			<table class="search" border="0" style="width: 979;">
				<tr class="h23">
					<td width="100">RHQ</td>
					<td width="120" style="padding-left:2"><script language="javascript">ComComboObject('s_rhq_ofc_cd',1,80,0);</script></td>
					<td width="90">Invoice OFC</td>
					<td width="120" style="padding-left:2"><script language="javascript">ComComboObject('s_inv_ofc_cd',1,78,0);</script></td>
					<td width="110">Confirm Period</td>
					<td width="220">
					<input type="text" style="width:70; text-align:Center" name="s_from_inv_cfm_dt" dataformat="ymd" maxlength="8" class="input1" onkeyPress="ComKeyOnlyNumber(window);" onfocus="ComClearSeparator(this,'', '-');this.select();" onblur="fnYearSet(this)">
					<img name="btns_from_inv_cfm_dt" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" class="cursor">
					&nbsp;~&nbsp;
					<input type="text" style="width:70; text-align:Center" name="s_to_inv_cfm_dt" dataformat="ymd" maxlength="8" class="input1" onkeyPress="ComKeyOnlyNumber(window);" onfocus="ComClearSeparator(this,'', '-');this.select();" onblur="fnYearSet(this)">
					<img name="btns_to_inv_cfm_dt" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" class="cursor">
					</td>
					<td width="">&nbsp;</td>
				</tr>
			</table>
			<table class=""><tr><td></td></tr></table>
			<table class="search" border="0" style="width: 979;">
				<tr class="h23">
					<td width="100">Batch Result</td>
					<td width="120" style="padding-left:2;"><script language="javascript">ComComboObject('s_bat_rslt_cd',1,80,1);</script></td>
					<td width="90">Invoice No.</td>
					<td width="140"><input type="text" name="s_inv_no" style="width:77" maxlength="30"></td>
					<td colspan="3" width="">&nbsp;</td>
				</tr>
			</table>
			</td>
		</tr>
	</table>
	
	<!-- TABLE '#D' : ( Search Options ) (E) -->			
	<table class="height_5"><tr><td></td></tr></table>
	<!-- TABLE '#D' : ( Grid ) (S) -->
    	<table class="search">
      		<tr><td class="bg">
			<!-- <table class="height_10"><tr><td></td></tr></table> -->
			<!-- : ( POR ) (S) -->
			<table width="100%" id="mainTable">
	              <tr><td>
	                     <script language="javascript">ComSheetObject('sheet1');</script>
	              </td></tr>
			</table>
			<!-- : ( POR ) (E) -->
			<table width="100%" class="button">
			<tr>
				<td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
	                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
	                            <tr>
	                                <td class="btn2_left"></td>
	                                <td class="btn2" name="btn_inv_detail">Inv. Details</td>
	                                <td class="btn2_right"></td>
	                            </tr>
	                        </table>
	                    </td>								
					</tr>
				</table>
				</td>
			</tr>
			</table>
		</td></tr>
	</table>
	<!-- TABLE '#D' : ( Grid ) (E) -->

    </td></tr>
</table>
<div style="display:none;">
	<script language="javascript">ComSheetObject('sheet2');</script>
</div>
</form>
</body>
</html>