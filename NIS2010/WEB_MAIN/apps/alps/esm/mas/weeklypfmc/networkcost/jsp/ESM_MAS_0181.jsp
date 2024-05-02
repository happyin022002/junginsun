<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0181.jsp
*@FileTitle : Port Tariff Inquiry PopUp
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.01
*@LastModifier : 이석준
*@LastVersion : 1.0 
=========================================================
* History
* 2013.05.07 최성민 [CHM-201324181] [MAS] Port tariff 로직 수정
* =========================================================
*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%
    Exception serverException   = null;             //서버에서 발생한 에러
    String strErrMsg    = "";                       //에러메세지
    Logger log = Logger.getLogger("com.hanjin.alps.esm.mas.ESM_MAS_0181");
    String f_selrlane = ((request.getParameter("f_selrlane")==null )?"":request.getParameter("f_selrlane"));
    try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
    } catch(Exception e) {
        log.error("JSP Exception : " + e.toString());
    }
    
      String f_yearweek   			= JSPUtil.getNull(JSPUtil.getParameter(request,"f_yearweek"));
	  String f_yrtype   			= JSPUtil.getNull(JSPUtil.getParameter(request,"f_yrtype"));  
	  String slan_cd		        = JSPUtil.getNull(JSPUtil.getParameter(request,"slan_cd")); 
	  String vsl_cd    			    = JSPUtil.getNull(JSPUtil.getParameter(request,"vsl_cd")); 
	  String skd_voy_no  			= JSPUtil.getNull(JSPUtil.getParameter(request,"skd_voy_no")); 
	  String skd_dir_cd   			= JSPUtil.getNull(JSPUtil.getParameter(request,"skd_dir_cd"));

//      String cost_yrmon   			= "201101";
//	  String slan_cd		        = "AEX"; 
//	  String vsl_cd    			    = "DDDD"; 
//	  String skd_voy_no  			= "1234"; 
//	  String skd_dir_cd   			= "D";
%>
<html>
<head>
<title>Port Tariff Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }

</script>
</head>

<body onload="javascript:setupPage();" >
<form method="post" name="form" onKeyDown="ComKeyEnter();">
<input  type="hidden" name="f_cmd">

<input type="hidden" name="f_slan_cd"    value="<%=slan_cd%>"> 
<input type="hidden" name="f_yearweek"    value="<%=f_yearweek%>"> 
<input type="hidden" name="f_yrtype"    value="<%=f_yrtype%>"> 
<input type="hidden" name ="f_selrlane" value="<%=f_selrlane%>">

<!-- Outer Table (S)-->
<table width="100%" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

      <!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr>
          <td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;&nbsp;Port Tariff Inquiry</td>
        </tr>
      </table>
      <!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->

      <!-- TABLE '#D' : ( Search Options ) (S) -->
      <table class="search">
        <tr>
          <td class="bg">
            <!-- : ( Year ) (S) -->

            <table border="0">              
              <tr class="h23">                
                <td>VVD</td>
                <td width = "65%">
                    <input type="text" size="4" name="f_vsl_cd"     maxlength="4" onKeyPress="ComKeyOnlyAlphabet('uppernum');" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled; width:60;text-align:center;" value="<%=vsl_cd%>">
                    <input type="text" size="4" name="f_skd_voy_no" maxlength="4" onKeyPress="ComKeyOnlyNumber(window);" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled; width:60;text-align:center;" value="<%=skd_voy_no%>">
                    <input type="text" size="1" name="f_dir_cd"     maxlength="1" onKeyPress="ComKeyOnlyAlphabet('upper');" style="ime-mode:disabled;text-align:center; width:30;" value="<%=skd_dir_cd%>">
                </td>
                <td>Cre. Req DT</td>
                <td> <input type="text" name="f_rqst_dt" style='text-align:center;' class='input2'></input>             
                </td>
                
              </tr>
            </table>
            <!-- : ( Year ) (E) -->
          </td>
        </tr>
      </table>
      <!-- TABLE '#D' : ( Search Options ) (E) -->

      <table class="height_10"><tr><td></td></tr></table>

      <!-- TABLE '#D' : ( Search Options ) (S) -->
      <table class="search">
        <tr>
          <td class="bg">
            <!-- : ( POR ) (S) -->
            <table width="100%" id="mainTable">
              <tr>
                <td>
                  <script language="javascript">ComSheetObject('sheet1');</script>
                </td>
              </tr>
            </table>
            <!-- : ( POR ) (E) -->
          </td>
        </tr>
      </table>
      <!-- TABLE '#D' : ( Search Options ) (E) -->     
      
    </td>
  </tr>
</table>
<!-- Outer Table (E)-->
             
<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

 <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td class="btn1_line"></td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_Save">Save</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td class="btn1_line"></td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_downExcel">Down Excel</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td class="btn1_line"></td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_Close">Close</td>
								<td class="btn1_right"></td>
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
<!-- : ( Button : Sub ) (E) -->         


</form>
</body>
</html>
