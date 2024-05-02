<%
/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESD_SCE_0145.jsp
*@FileTitle : Dwell E-mailing History
*Open Issues :
*Change history :
*   - 2011-07-26 : Dwell E-mailing History
*@LastModifyDate : 2011-07-26
*@LastModifier : eunju son
*@LastVersion : 1.0
* 2011-07-26 eunju son
* 1.0 최초 생성
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.dwellnotification.event.EsdSce0140Event" %>

<%
String dwll_tm_tp_cd = "";
String sc_no = "";
String eml_snd_dt = "";
String cntr_no = "";
String cust_cd = "";
SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
String userId=account.getUsr_id();

EsdSce0140Event  event = null;                		//PDTO(Data Transfer Object including Parameters)

Exception serverException   = null;
String strErrMsg = "";


try {
	
	event = (EsdSce0140Event)request.getAttribute("Event");	
	dwll_tm_tp_cd = JSPUtil.getParameter(request, "dwll_tm_tp_cd".trim(), "");
	sc_no = JSPUtil.getParameter(request, "sc_no".trim(), "");
	eml_snd_dt = JSPUtil.getParameter(request, "eml_snd_dt".trim(), "");
	cntr_no = JSPUtil.getParameter(request, "cntr_no".trim(), "");
	cust_cd = JSPUtil.getParameter(request, "cust_cd".trim(), "");
	
	
	serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

	if (serverException != null) {
	          strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
	      }
} catch(Exception e){
	out.println(e.toString());
}


%>

<html>
<head>
<title>Welcome to ALPS!</title>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">

    function setupPage(){
        loadPage();
        var formObject = document.form ;
    }

</script>
</head>

<body onLoad="setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="dwll_tm_tp_cd" value="<%=dwll_tm_tp_cd %>">
<input type="hidden" name="sc_no" value="<%=sc_no %>">
<input type="hidden" name="eml_snd_dt" value="<%=eml_snd_dt %>">
<input type="hidden" name="cntr_no" value="<%=cntr_no %>">
<input type="hidden" name="f_cmd">


<!-- Outer Table (S)-->
<table width="100%" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">

					<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
						<table width="100%" border="0">
							<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;E-mailing History</td></tr>
						</table>
					<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->


					<!-- TABLE '#D' : ( Button : Main ) (S) -->
						<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
								<tr><td class="btn1_bg">

										<table border="0" cellpadding="0" cellspacing="0">
										<tr>
											<!-- Repeat Pattern -->
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
											<!-- Repeat Pattern -->

										</tr></table>

								</td></tr>
						</table>
				    	<!-- TABLE '#D' : ( Button : Main ) (E) -->

					<table class="search">
						<tr>
							<td class="bg">
								<table class="search" border="0" style="width:750;">
									<tr class="h23">
										<td width="60">&nbsp;S/C NO: </td>
										<td><input name="frm_sc_no"  type="text" class="input2" maxlength="50" style="width:90;" value="<%=sc_no%>" readonly></td>
										<td width="120">&nbsp;Customer Code: </td>
										<td><input name="cust_cd"  type="text" class="input2" maxlength="50" style="width:90;" value="<%=cust_cd%>" readonly></td>
										<td width="50">&nbsp;Type: </td>
										<td><select name="frm_rvis_cntr_cust_tp_cd" style="width:80;" class="input2" disabled>
						                    <option value=""> </option>
						                    <option value="N">Non-BCO</option>
                    						<option value="B">BCO</option>
                  							</select>	</td>
                  							<td width="100">&nbsp;Container NO: </td>
										<td><input name="cntr_no"  type="text" class="input2" maxlength="50" style="width:90;" value="<%=cntr_no%>" readonly></td>
									</tr>
									<tr class="h23">
										<td width="65">&nbsp;E-mail </td>
										<td colspan=3><input name="eml_addr"  type="text" class="input" maxlength="50" style="width:150;" value="" ></td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
					<table class="height_10"><tr><td></td></tr></table>

					<!--Sheet (S) -->
					<table class="search" border="0">
						<tr>
							<td class="bg">
							<table width="100%" height="0" id="mainTable">
								<tr>
									<td width="100%"><script language="javascript">ComSheetObject("sheet1");</script>
									</td>
								</tr>
							</table>
							</td>
						</tr>
					</table>
					<!--Sheet (E) -->
</td></tr>
</table>
<!-- OUTER - POPUP (E)nd -->


<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
  <tr>
    <td height="71" class="popup"><table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
        <tr>
          <td class="btn3_bg"><table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td width="72"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_close" id="btn_close">Close</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table></td>
              </tr>
            </table></td>
        </tr>
      </table>
      <!--Button (E) --></td>
  </tr>
</table>
</form>
</body>
</html>
