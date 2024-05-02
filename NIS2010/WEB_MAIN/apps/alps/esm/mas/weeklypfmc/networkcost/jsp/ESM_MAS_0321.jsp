<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0321.js
*@FileTitle : 
*Open Issues :
*Change history :
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%> 
<%@ page import="org.apache.log4j.Logger"%>
<%
    Exception serverException = null;	//서버에서 발생한 에러
    String strErrMsg = "";              //에러메세지
	String strUsr_id = "";
	String strUsr_nm = "";
    String xml = "";
    
    String f_yrtype = "";
	String f_yearweek = "";
	String f_trd_cd = "";
	String f_rlane_cd = "";
	String f_dir_cd = "";
	String f_hul_bnd_cd = "";
	
    Logger log = Logger.getLogger("com.hanjin.alps.esm.mas.ESM_MAS_0321");
	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		xml = HttpUtil.makeXML(request,response); 
        xml = xml.replaceAll("\"", "'");
        
        f_yrtype = request.getParameter("f_yrtype")== null?"":request.getParameter("f_yrtype");
		f_yearweek = request.getParameter("f_yearweek")== null?"":request.getParameter("f_yearweek");
		f_trd_cd = request.getParameter("f_trd_cd")== null?"All":request.getParameter("f_trd_cd");
		f_rlane_cd = request.getParameter("f_rlane_cd")== null?"All":request.getParameter("f_rlane_cd");
		f_dir_cd = request.getParameter("f_dir_cd")== null?"All":request.getParameter("f_dir_cd");
		f_hul_bnd_cd = request.getParameter("f_hul_bnd_cd")== null?"All":request.getParameter("f_hul_bnd_cd");

// 		f_yearweek   = "";
// 		f_vsl_cd     = "HDDH";
// 		f_trd_cd     = "EMS";
// 		f_rlane_cd   = "AL1EM";
// 		f_dir_cd = "E";
// 		f_hul_bnd_cd     = "BH";
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Bunker Fee Modification</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
    function setupPage() {
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }
</script>
</head>
<body onload="javascript:setupPage();" onunload="callParentFnc();">
<!-- <body onload="javascript:setupPage();"> -->
<form method="post" name="form" onKeyUp="ComKeyEnter();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="sXml" value="<%=xml%>">
<input type="hidden" name="f_usr_id" value="<%=strUsr_id%>">
<!-- Outer Table (S)-->

<input type="hidden" name="pf_yrtype"   value="<%=f_yrtype%>">
<input type="hidden" name="pf_yearweek"   value="<%=f_yearweek%>">
<input type="hidden" name="pf_trd_cd"     value="<%=f_trd_cd%>">
<input type="hidden" name="pf_rlane_cd"   value="<%=f_rlane_cd%>">
<input type="hidden" name="pf_dir_cd" value="<%=f_dir_cd%>">
<input type="hidden" name="pf_hul_bnd_cd" value="<%=f_hul_bnd_cd%>">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0">
  <tr><td class="top"></td></tr>
  <tr>
    <td valign="top">
      <!-- : ( Title ) (S) -->
      <table width="100%" border="0">
        <tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp; Bunker Fee Modification</td></tr>
      </table>
      <!-- : ( Title ) (E) -->
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
                <td class="btn1_line"></td>               
<!--                 <td> -->
<!--                   <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button"> -->
<!--                     <tr> -->
<!--                       <td class="btn1_left"></td> -->
<!--                       <td class="btn1" id="btn_creation" name="btn_creation">Create</td> -->
<!--                       <td class="btn1_right"></td> -->
<!--                     </tr> -->
<!--                   </table> -->
<!--                 </td> -->
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_save" name="btn_save">Save</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
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
      <table class="search">
        <tr>
          <td class="bg">
          
            <table class="search_in" border="0" style="width:100%;">
              <tr class="h23">
                <td width="20%">
                     YYYY-MM <input type="radio" name="f_yrtype" class="trans" value="yrmon" onClick="setYrMon()" checked>&nbsp;&nbsp;
                     YYYY-WW <input type="radio" name="f_yrtype" class="trans" value="yrwk">&nbsp;&nbsp;
                </td>
                <td width="8%"><input type="text" class="input1" style="width:60" name="f_yearweek" maxlength="6" onkeyPress="ComKeyOnlyNumber(window);" onfocus="ComClearSeparator(this,'', '-');this.select();" onblur="javascript:fnYearWeekSet(this);"></td>
                <td class="sm"><div id="div_period"></div></td>
              </tr>
            </table>
            <table class="search_in" border="0" style="width:100%;">
              <tr><td class="line_bluedot" colspan="10"></td></tr>
              <tr class="h23">
<!--                 <td width="68">YYYY-WW</td> -->
<!--                 <td width="62"><input type="text" class="input1" style="width:56" name="f_yearweek" maxlength="6" onkeyPress="ComKeyOnlyNumber(window);" onfocus="ComClearSeparator(this,'', '-');this.select();" onblur="javascript:fnYearWeekSet(this);"></td> -->
<!--                 <td width="190" class="sm"><div id="div_period"></div></td> -->
                <td width="30">Trade</td>
				<td width="80" style="padding-left: 5;">
					<script language="javascript">ComComboObject('f_trd_cd',1, 65 , 0 )</script>
				</td>
                <td width="62">Sub Trade</td>
				<td width="80" style="padding-left: 0;">
					<script language="javascript">ComComboObject('f_sub_trd_cd',1, 55 , 0 )</script>
				</td>
				<td width="30">Lane</td>
				<td width="95" style="padding-left: 5;">
					<script language="javascript">ComComboObject('f_rlane_cd',1, 70 , 0 )</script>
				</td>
				<td width="40">Bound</td>
				<td width="70" style="padding-left: 5;">
					<script language="javascript">ComComboObject('f_dir_cd',1, 55 , 0 )</script>
				</td>
				<td width="60">Trade Dir.</td>
				<td width="90" style="padding-left: 5;">
					<script language="javascript">ComComboObject('f_hul_bnd_cd',1, 65 , 0 )</script>
				</td>
                <td width="">&nbsp;</td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
      <table class="height_10"><tr><td></td></tr></table>
        <table class="search" border="0">
        <tr>
          <td class="bg">
            <table width="100%" id="mainTable">
              <tr>
                <td>
                  <script language="javascript">ComSheetObject("sheet1");</script>
                </td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
    </td>
  </tr>
</table>
<!-- Outer Table (E)-->
<table class="height_5"><tr><td></td></tr></table>
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
  <tr>
    <td height="71" class="popup">
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
        <tr>
          <td class="btn3_bg">
            <table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <!-- Repeat Pattern -->
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_close" id="btn_close">Close</td>
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
    </td>
  </tr>
</table>
<div style="display:none;">
	<script language="javascript">ComSheetObject('sheet2');</script>
</div>
<!-- : ( Button : pop ) (E) -->
</form>
</body>
</html>
