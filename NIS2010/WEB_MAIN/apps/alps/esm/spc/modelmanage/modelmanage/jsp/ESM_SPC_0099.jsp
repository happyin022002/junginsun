<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0099.jsp
*@FileTitle : Confirm
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.22
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2013.01.22 진마리아
* 1.0 Creation
* 2013.01.22 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2014.01.03 진마리아 [SRM-201341166] Yield Group의 확대
* 2014.03.06 [CHM-20142960] SMP/Allocation control보완 요청 - 재생성 기능 추가
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String cfmVerPrdTo = null;
	String reCrePrdTo = null;
	String src = null;
	String firVirStWk = null;//confirm에서 쓰임
	String exptYrwk = null;

	Logger log = Logger.getLogger("com.hanjin.apps.modelmanage.modelmanage");

	try {
		cfmVerPrdTo = JSPUtil.getParameter(request, "cfm_ver_prd_to", "");
		reCrePrdTo = JSPUtil.getParameter(request, "re_cre_prd_to", "");
		src = JSPUtil.getParameter(request, "src", "");
		firVirStWk = JSPUtil.getParameter(request, "fir_vir_st_wk", "");
		exptYrwk = JSPUtil.getParameter(request, "expt_yrwk", "");

		cfmVerPrdTo = cfmVerPrdTo==null?"":cfmVerPrdTo;
		reCrePrdTo = reCrePrdTo==null?"":reCrePrdTo;
		src = src==null?"":src;
		firVirStWk = firVirStWk==null?"":firVirStWk;

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

	}catch(Exception e) {
		out.println(e.toString());
	}

%>

<html>
<head>
<title>SMP <%=src%></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<script language="javascript">
    function setupPage(){
		var errMessage = "";
		
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		
		loadPage();
	}
</script>
<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="cfm_ver_prd_to" value="<%=cfmVerPrdTo%>">
<input type="hidden" name="re_cre_prd_to" value="<%=reCrePrdTo%>">
<input type="hidden" name="src" value="<%=src%>">
<input type="hidden" name="fir_vir_st_wk" value="<%=firVirStWk%>">
<input type="hidden" name="expt_yrwk_hidden" value="<%=exptYrwk%>">


<input type="hidden" name="ctrl_grp_xml">
<!-- OUTER - POPUP (S)tart -->
<table width="400" class="popup" cellpadding="10" border="0">
  <tr>
    <td class="top"></td>
  </tr>
  <tr>
    <td valign="top">
      <!-- : ( Title ) (S) -->
      <table width="380" border="0">
        <tr><td class="title"><img src="/hanjin/img/ico_t1.gif" width="20" height="12">SMP <%=src%></td></tr>
      </table>
      <!-- : ( Title ) (E) -->
      <!-- : ( Search Options ) (S) -->
      <table class="search">
        <tr>
          <td class="bg">
            <!-- : ( Grid ) (S) -->
            <table width="362" class="search">
              <tr class="h23">
                <td width="130"><div align="left"><label for="" id="week_txt"></label></div></td>
                <td width="*">
                	<select class="input1" name="from_year" style="width:60;"></select>
					<select class="input1" name="from_week" style="width:40;"></select>
					~
					<select class="input1" name="to_year" style="width:60;"></select>
					<select class="input1" name="to_week" style="width:40;"></select>
                </td>
                
              </tr>
              <%
              if( "CONFIRM".equals(src) ){
              %>
              <tr class="h23">
                <td width="130"><div align="left"><label for="" id="">Exception Week</label></div></td>
                <td width="*">
                    <input type="text" class="input1" name="expt_yrwk" style="width:224;">
                </td>
                
              </tr>
              <%
              }else{
              %>
                   <input type="hidden"  name="expt_yrwk" >
                  
              <%
              }
              %>          
            </table>
            <!-- : ( Grid ) (E) -->

          </td>
        </tr>
      </table>
      <!-- : ( Search Options ) (E) -->

    </td>
  </tr>
</table>
<!-- OUTER - POPUP (E)nd -->

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
                      <td class="btn1" name="btn_ok" id="btn_ok">OK</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td class="btn1_line"></td>
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
<!-- : ( Button : pop ) (E) -->
</form>
</body>
</html>