<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EES_EQR_1004.jsp
*@FileTitle : Sales Forecast Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.27
*@LastModifier : 전지예
*@LastVersion : 1.0
* 2014.11.27 전지예
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
<%@ page import="com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.mtyequipmentforecast.event.EesEqr1004Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesEqr1004Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String repoPlnWrwk 	= ""; 
	String repoPlnWrwkView = ""; // 화면표현
	String fcastYrwk 	= "";
	String fcastYrwkView= "";    // 화면표현
	String locGrpCd 	= "L";
	String locCd    	= "";
	String locLevel     = "";
	String searchFlag   = "";
	
	String popMode = (request.getParameter("pop_mode") == null)? "N": "Y";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		event = (EesEqr1004Event)request.getAttribute("Event");
		
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		if (popMode.equals("Y")) {
			
			repoPlnWrwk = (String)event.getAttribute("repo_pln_yrwk");
			if(!repoPlnWrwk.equals("")) repoPlnWrwkView = repoPlnWrwk.substring(0, 4) + "-" + repoPlnWrwk.substring(4, 6);
			
			fcastYrwk 	= (String)event.getAttribute("fcast_yrwk");
			if(!fcastYrwk.equals("")) fcastYrwkView = fcastYrwk.substring(0, 4) + "-" + fcastYrwk.substring(4, 6);
			locGrpCd 	= (String)event.getAttribute("loc_grp_cd");
			locCd    	= (String)event.getAttribute("loc_cd");
			searchFlag  = (String)event.getAttribute("search_flag");
			
			if("E".equals(locGrpCd)){
				locLevel = "ECC";
			}else if("L".equals(locGrpCd)){
				locLevel = "LCC";
			}else if("S".equals(locGrpCd)){
				locLevel = "SCC";
			}
		}
		
	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String locSelectBox = JSPUtil.getCodeCombo("loc_grp_cd", locGrpCd,"","CD03052",0,"");
	
%>
<html>
<head>
<title>Sales Projection Detail</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		
		loadPage();
	}
</script>
</head>


<% if (popMode.equals("Y")) { %>
<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<table class="popup" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;padding-right:5;border:0;width:100%;">
    <tr><td class="top"></td></tr>
    <tr><td valign="top">
    <!--Page Title, Historical (S)-->
    <table cellpadding="0" cellspacing="0" class="title" style="width:100%; border:0;">
        <tr><td class="title"><br><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Sales Forecast Detail</td></tr>
    </table>
<% } else { %>
<body onLoad="setupPage();">
<form name="form">
<table cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;width:100%;border:0;">
    <tr><td valign="top">
    <!--Page Title, Historical (S)-->
    <table cellpadding="0" cellspacing="0" class="title" style="width:100%; border:0;">
        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
    </table>
<% } %>

<input type="hidden" name="f_cmd" />
<input type="hidden" name="inquiryLevel" value="" />
<input type="hidden" name="location" value="" />
<input type="hidden" name="popMode" value="<%=popMode %>" />
<input type="hidden" name="fcast_yrwk" 	  value="<%=fcastYrwk %>" />
<input type="hidden" name="repo_pln_yrwk" value="<%=repoPlnWrwk %>" />
<input type="hidden" name="search_flag"   value="<%=searchFlag %>" />

	<!--Button (S) -->
    <table class="button" cellpadding="0" cellspacing="0" style="width:100%;border:0px; padding-top:0;,padding-bottom:2;">
       <tr><td class="btn1_bg">
        <table cellpadding="0" cellspacing="0" style="border:0px;">
        <tr>
            <td><table cellpadding="0" cellspacing="0" class="button" style="width:100%;border:0;">
                <tr><td class="btn1_left"></td>
                <td class="btn1" name="btn_retrieve" id="btn_Retrieve">Retrieve</td>
                <td class="btn1_right"></td>
                </tr>
            </table></td>
            <td><table cellpadding="0" cellspacing="0" class="button" style="width:100%;border:0;">
                <tr><td class="btn1_left"></td>
                <td class="btn1" name="btn_new" id="btn_new">New</td>
                <td class="btn1_right"></td>
                </tr>
            </table></td>
            <td><table cellpadding="0" cellspacing="0" class="button" style="width:100%;border:0;">
                <tr><td class="btn1_left"></td>
                <td class="btn1" name="btn_downExcel">Down Excel</td>
                <td class="btn1_right"></td>
                </tr>
            </table></td>
        </tr>
        </table>
    </td></tr>
    </table>
	<!--Button (E) -->

	<!--biz page (S)-->
	<!-- 1 (S) -->
	<table class="search">
	   <tr><td class="bg">
	        <!--  biz_1  (S) -->
	   <table class="search" style="width:979; border:0;"> 
	        <tr class="h23">
	            <td width="50">Location</td>
	            <td width="50"><%= locSelectBox %></td> <!-- loc_tp_cd -->
	            <td width="120">
	                <input type="text" dataformat="engup" size="5" maxlength="5" required caption="Location CD" style="width:50;" class="input1" name="loc_cd" value="<%=locCd %>"> <img src="img/btns_search.gif" name="btn_loc_cd" width="19" height="20" border="0" align="absmiddle" class="cursor">
	            </td>
	            
	            <td width="30">Lane</td>
	            <td width="80"><input type="text" size="5" maxlength="5" caption="Lane CD" style="width:50;" class="input" name="rlane_cd" value="" onKeyPress= "obj_keypress();"></td>
	            
	            <td width="60">OP Week</td>
	            <td width="180">
	            	<input type="text" style="width:60"  required maxlength="7" caption="Week From" dataformat="yw" class="input1" name="fm_week" value="<%= fcastYrwkView %>">&nbsp;~&nbsp;<input type="text" style="width:60" caption="Week To" required maxlength="7" dataformat="yw"  class="input1" name="to_week" value="<%= fcastYrwkView %>">
	            </td>
	            
	            <td width="120"><input type="checkbox" name="create_chk_box" class="trans" onclick="creatioin_date();" value="N">&nbsp;&nbsp;Creation Date</td>
	            <td width="130">
	                <input type="text" dataformat="int" size="5" maxlength="2" caption="Creation Date From" style="width:50;" class="input2" name="fm_date" value="" >&nbsp;~&nbsp;<input type="text" dataformat="int" size="5" maxlength="2" caption="Creation Date To" style="width:50;" class="input2" name="to_date" value="">
	            </td>
	            <td width="40">(1~28)</td>
	        </tr>
	    </table>
	    <!--  biz_1   (E) -->
	    
	    <table class="line_bluedot"><tr><td></td></tr></table>
	    <!-- 1 (E) -->
	
	    <!-- 2 (S) -->
		
	    <!-- grid box (S) -->
	    <table class="search" style="width:100%; border:0;">
	        <tr><td valign="top" align=left>
	        <!-- Grid - 1 (S) -->
	        <table id="mainTable" style="width:100%; border:0;">
	            <tr>
	                <td style="width:100%;" align=left><script type="text/javascript">ComSheetObject('sheet1');</script></td>
	            </tr>
	        </table>
	        <!-- Grid - 1 (E) -->
	        </td></tr>
	    </table>
	    <!-- grid box (E) -->
	    
	</td></tr>
	</table>
	<!-- 2 (E) -->
	<!--biz page (E)-->
    
	<table class="height_10"><tr><td colspan="8"></td></tr></table>
	    </td></tr>
	</table>

<% if (popMode.equals("Y")) { %>
    <!-- : ( Button : pop ) (S) -->
    <table class="sbutton" style="width:100%;">
        <tr>
          <td height="71" class="popup"><table class="button" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;width:100%;border:0;">
              <tr>
                <td class="btn3_bg"><table cellpadding="0" cellspacing="0" style="border:0;">
                    <tr>
                      <td width="72"><table cellpadding="0" cellspacing="0" class="button" style="width:100%;border:0;">
                          <tr>
                            <td class="btn1_left"></td>
                            <td class="btn1" name="btn_close">Close</td>
                            <td class="btn1_right"></td>
                          </tr>
                        </table></td>
                    </tr>
                  </table></td>
              </tr>
            </table></td>
        </tr>
    </table>
    <!-- : ( Button : pop ) (E) -->
<% } %>
	
<!-- : ( Button : pop ) (E) -->
</form>
</body>
</html>
