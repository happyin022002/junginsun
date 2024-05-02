<%--
/*=========================================================
*copyright(c) 2006 cyberlogitec
*@filename : ESD_PRD_0088.jsp
*@filetitle : yardmanage
*open issues :
*change history :
*@lastmodifydate : 2014-12-08
*@lastmodifier : 
*@lastversion : 1.0
* 2014-12-08 kimseungman
* 1.0 최초 생성
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse" %>
<%@ page import="com.hanjin.apps.alps.esd.prd.common.prdcommon.vo.ContinentVO"%>
<%@ page import="java.util.List" %>
<%
	GeneralEventResponse eventResponse = null;	//RDTO(Data Transfer Object including DB ResultSet)
	Exception serverException   = null;				//서버에서 발생한 에러
	List list = null;
	String strErrMsg = "";							//에러메세지
	//String successFlag = "";
	//String codeList  = "";
	//String pageRows  = "100";
	String nodeCd = "";
	String strUsr_id	= "";
	String strUsr_nm	= "";
	String strOfc_cd    = "";
	try {

	   SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
			eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
			if (eventResponse != null) {
				list = eventResponse.getRsVoList();
			} // end if
		} // end else
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<!--%@include file="/apps/alps/esd/prd/common/prdcommon/jsp/ESD_PRD_0AUTH.jsp"%-->
<html>
<head>
<title>Node Default Service Provider</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		nodeCd = "<%=nodeCd%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		//InitTab();
		loadPage();
	}
</script>
<!-- CSS for 'RIGHT' frame -->

</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>
<form method="post" name="form" id="form">
<input	type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden"  name="incl_sub_ofc_flg" id="incl_sub_ofc_flg">
<input type="hidden" name="old_ofc_cd" id="old_ofc_cd" value="">
<input type="hidden" name ="vndr_Nm" id ="vndr_Nm" value="">
<input type="hidden" name ="VndrCntCd" id ="VndrCntCd" value="">
<input type="hidden" name ="VndrSeq" id ="VndrSeq" value="">
<input type="hidden" name ="chk_vndr_seq" id ="chk_vndr_seq" value="">
<input type="hidden" name ="chk_os_all" id ="chk_os_all" value="">
<input type="hidden" name ="chk_os_a" id ="chk_os_a" value="">
<input type="hidden" name ="chk_os_b" id ="chk_os_b" value="">
<input type="hidden" name ="chk_os_c" id ="chk_os_c" value="">
<input type="hidden" name ="chk_os_d" id ="chk_os_d" value="">
<input type="hidden" name ="chk_os_e" id ="chk_os_e" value="">
<input type="hidden" name ="chk_os_f" id ="chk_os_f" value="">



		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->


		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;">
        <tr>
          <td class="btn1_bg"><table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_New" id="btn_New">New</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table></td>
                  <td class="btn1_line"></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_save" id="btn_save">Save</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_excel" id="btn_excel">Down Excel</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table></td>
              </tr>
            </table></td>
        </tr>
      </table>
		<!-- TABLE '#D' : ( Button : Main ) (E) -->



		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
        <tr>
          <td class="bg"><!-- biz_1  (S) -->
            
            <table class="search" border="0" style="width:979;">
              <colgroup>
              <col width="70px" >
              <col width="90px" >
              <col width="70px" >
              <col width="150px" >
              <col width="100px" >
              <col width="80px" >
              <col width="120px" >
              <col width="100px" >
              <col width="110px" >
              </colgroup>
              <tr class="h23" >
                <td>Node Code</td>
                <td><input type="text" style="width:70px;" class="input" value="" name="yd_cd"id="yd_cd" maxlength="7" onkeypress="ComKeyOnlyAlphabet('uppernum')"  ></td>
                <td>Node Name</td>
                <td><input type="text" style="width:130px;" class="input" value="" name="yd_nm"id="yd_nm" onkeypress="ComKeyOnlyAlphabet('uppernum')" ></td>
                <td>Control Office</td>
                <td ><input type="text" style="width:100px;" class="input" value="" name="ofc_cd"id="ofc_cd"  onkeypress="ComKeyOnlyAlphabet('upper')" ></td>
                <td><table  border="0" class="search_sm2">
                    <tr>
                      <td><input type="checkbox" name="chk_office" value="Y" class="trans" onClick="javascript:fun_chkOffice();">Incl. Sub OFC  &nbsp;</td>
                      <td >&nbsp;</td>
                    </tr>
                  </table></td>
                <td>Yard Character</td>
                <td><select name="yd_chr_cd" id="yd_chr_cd" class="input1" style="width:80px">
                    <option value="">All</option>
                    <option value = "N">ON DOCK</option>
                    <option value = "F">OFF DOCK</option>
                  </select></td>
              </tr>
              <tr class="h23">
                <td>Country</td>
                <td><input type="text" style="width:30px;" class="input" value="" name="country" id="country" maxlength="2" onkeypress="ComKeyOnlyAlphabet('upper')" ></td>
                <td>Location</td>
                <td><input type="text" style="width:50px;" class="input" value="" name="loc_cd" id="loc_cd" maxlength="5" onkeypress="ComKeyOnlyAlphabet('upper')" ></td>
                <td>OPR Service</td>
					<td width="" colspan="2">
						<script language="javascript">ComComboObject('os_cd', 1, 150, 1);</script>
						<div style="display: none;"><input type="text" name="chk_os_cd" style="width:150" value="" class="input" readonly></div>
					</td>
                <td colspan="2" align="center"><table  border="0" class="search_sm2">
                  <tr>
                    <td><input type="radio" class="trans" checked="checked" />
                      Yard
                      <input type="radio" class="trans"  disabled="disabled"/>
                      Zone</td>
                  </tr>
                </table></td>
              </tr>
            </table>
            <table class="line_bluedot">
              <tr>
                <td colspan="8"></td>
              </tr>
            </table>
            </td>
        </tr>
      </table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Grid BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">


					<!-- Grid : Week (S) -->
					<!-- 'HEAD1-BGCOLOR : 192 235 163' , 'HEAD2-BGCOLOR : 231 250 249' , 'BORDER : 90 138 158' , 'HEAD1-FONT : 0 83 116' , 'DATA GRID BG (2 colors) : 255 255 255, 249 249 249 ' -->

					<table width="100%" id="mainTable">
				              <tr><td>
				                     <script type="text/javascript">ComSheetObject('sheet1');</script>
				              </td></tr>
					</table>
					<!-- Grid : Week (E) --></td>
			</tr>
		</table>

</form>
    </td></tr>
</table>
<!-- Outer Table (E)-->

<iframe name="HiddenFrame" id="HiddenFrame" frameborder="0" marginheight="0" marginwidth="0" width="0" height="0"></iframe>
</body>
</html>
