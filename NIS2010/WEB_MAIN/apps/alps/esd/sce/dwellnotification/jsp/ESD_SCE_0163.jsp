<%
/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESD_SCE_0154.jsp
*@FileTitle : SCE
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.07
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2011.07.07 채창호
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
<%@ page import="com.hanjin.apps.alps.esd.sce.dwellnotification.event.EsdSce0163Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdSce0163Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String sc_no            = "";
	String row              = "";
	String cust_cd			= "";
	String emailcnt_gubun    = "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.DwellNotification.DwellNotification");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsdSce0163Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	}catch(Exception e) {
		out.println(e.toString());
	}
	
	sc_no =JSPUtil.getParameter(request, "sc_no".trim(), "");
	row =JSPUtil.getParameter(request, "row".trim(), "");
	cust_cd = JSPUtil.getParameter(request, "cust_cd".trim(), "");
	emailcnt_gubun = JSPUtil.getParameter(request, "emailcnt_gubun".trim(), "");
%>
<html>
<head>
<title>E-mail List</title>
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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="sc_no" value="<%=sc_no%>">
<input type="hidden" name="row" value="<%=row%>">
<input type="hidden" name="totalCount">
<input type="hidden" name="emailcnt_gubun" value="<%=emailcnt_gubun%>">
<!-- 개발자 작업	-->
<table width="100%" class="popup" cellpadding="10" border="0">
  <tr>
    <td class="top"></td>
  </tr>
  <tr>
    <td valign="top"><!-- : ( Title ) (S) -->
      <table width="100%" border="0">
        <tr>
         <td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;E-mail List</td>
        </tr>
      </table>
     
      <!-- : ( Title ) (E) -->
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

      <!-- : ( Search Options ) (S) -->
      <table class="search">
        <tr>
          <td class="bg" >
          <table><tr><td width=25% align=left>
            <table class="search" border="0" style="width:550;" >
              <tr class="h23">
              <td width="60">S/C NO :</td>
                <td width="*"><input type="text" style="width:90;" class="input2" value="<%=sc_no %>" Readonly></td>
                <td width="110">Customer Code :</td>
                <td width="*"><input type="text" style="width:80;" class="input2" name="cust_cd" value="<%=cust_cd%>" Readonly></td>
                <td width="50">Type :</td>
                <td width="*"><td><select name="frm_rvis_cntr_cust_tp_cd" style="width:80;" class="input" disabled>
						                    <option value=""> </option>
						                    <option value="N">Non-BCO</option>
                    						<option value="B">BCO</option>
                  							</select>	</td>
              </tr>
            </table>
            </td>
            <td width="90%"></td>
            <td  align=right>


          <table class="search" border="0" style="width:300;">
              <tr>
              <td width="65">&nbsp;E-mail </td>
			  <td width="*"><input name="eml_addr"  type="text" class="input" maxlength="50" style="width:150;" value="" ></td>
              <td width="49">Del Flag</td>
                <td width="*"><input type="checkbox" class="trans" name="i_del_flg" value="Y" onClick="changeDeltFlg()" unchecked ></td>
              </tr>
            </table>
            </td></tr></table>
            <table class="line_bluedot">
              <tr>
                <td colspan="8"></td>
              </tr>
            </table>
            <!-- : ( Grid ) (S) -->
            <table width="100%"  id="mainTable">
             <tr>
				<td width="100%">
					<script language="javascript">ComSheetObject('sheet1');</script>
				</td>
			</tr>
            </table>
                        <table border=0 cellpadding=0 cellspacing=0 style="align: left">
	                        <tr  align="left"><td align="left" width=100%><font color='red'><b>* The E-mail Address with One Time send history can't be send any more.</b>
					        </font>
					        </td>
					        </tr>
					         <tr  align="left"><td align="left" width=100%><font color='red'>&nbsp;&nbsp;<b>  If you use that in the future, please remove tick mark on One Time Only</b>
					        </font>
					        </td>
					        </tr>
					    </table>
            <!--  Button_Sub (S)--> 
            <table width="100%" class="button">
              <tr>
                <td class="btn2_bg"><table border="0" cellpadding="0" cellspacing="0">
                    <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn2_left"></td>
                            <td class="btn2" name="btng_rowadd" id="btng_rowadd">Row Add</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table></td>
                      <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn2_left"></td>
                            <td class="btn2" name="btng_rowdelete" id="btng_rowdelete">Row Delete</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table></td>
                  </table></td>
              </tr>
            </table> 
            </td> <!-- Button_Sub (E) -->
        </tr>
      </table>
      <table class="height_5">
        <tr>
          <td></td>
        </tr>
      </table>
      <!-- : ( Search Options ) (E) --></td>
  </tr>
</table>
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
                      <td class="btn1" name="btn_save" id="btn_save">Save</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table></td>
                <td class="btn1_line"></td>
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
<!-- Outer Table (E)-->

</form>
<!-- 개발자 작업  끝 -->
</body>
</html>