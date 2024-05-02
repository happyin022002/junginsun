<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1021.jsp
*@FileTitle : Bank In Account No Setup for A/N
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : Son Yun Seuk
*@LastVersion : 1.0
* 2009.07.10 Son Yun Seuk
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg1021Event"%>

<%@ page import="org.apache.log4j.Logger" %>
<%
EsmBkg1021Event event = null;
Exception serverException   = null;	
String ofc_cd = "";
String strErrMsg = "";
try 
{
   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
   	ofc_cd =	account.getOfc_cd();
   
   	event = (EsmBkg1021Event)request.getAttribute("Event");
	serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
	
	if (serverException != null) {
		strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
	}
	
	// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
	GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
}
catch(Exception e) 
{
	out.println(e.toString());
}
%>
<html>
<head>
<title>Bank In Account No Setup for A/N</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<script language="javascript">
    function setupPage()
    {  
	    loadPage();
    }

</script>

</head>
<body onLoad="setupPage();">

<form name="form"><!-- OUTER - POPUP (S)tart -->
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="old_ofc_cd">


           <%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp"%>
    






		<!--biz page (S)-->
		<table class="search">
			<tr>
				<td class="bg">
					<table class="search" border="0" style="width: 479;">
						<tr class="h23">
							<td width="60">&nbsp;&nbsp;Office</td>
							<td width=""><input type="text" style="width:50;ime-mode:disabled;" class="input1" 
							                    name="ofc_cd" dataformat="" caption="Office" minlength="5" maxlength="6" required="" value="<%=ofc_cd %>"></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<table>
			<tr height="5"><td>
			</td></tr>
		</table>
		
		<table class="search">
			<tr>
			    <td class="bg">
				    <table border="0" style="width:100%; background-color:white;" class="grid2"> 
					    <tr>
					        <td width="" class="tr2_head">Bank In Account No.</td>
					    </tr>
					    <tr>
					        <td>
						        <textarea style="width:100%;text-indent:0px" rows="5" name="bank_in_acct_ctnt" ></textarea>
					        </td>
					    </tr>

                        <tr>
                            <td>
                            Display Option : <input type="checkbox" class="trans" name="dp_flg" /> Draft B/L
                            <input type="hidden" name="drft_bl_bank_acct_dp_flg" />
                            </td>
                        </tr>
                        <tr>
                            <td>Last updated by <u><font color="blue"><span id="upd_usr_id"></span></font></u></td>
                        </tr>
					    
				    </table>
			   
	
			</td></tr>
		</table>
		


<!--Button (S) -->
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
        <tr>
          <td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
								<td class="btn1" name="btn_Retrieve">Retrieve</td>
								<td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                 <td class="btn1_line"></td>
                <td>
                  <table width="72" border="0" cellpadding="0" cellspacing="0" class="button" id="inq">
                    <tr>
                     <td class="btn1_left"></td>
								<td class="btn1" name="btn_Save">Save</td>
								<td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="inq">
                    <tr>
                     <td class="btn1_left"></td>
								<td class="btn1" name="btn_Delete">Delete</td>
								<td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
               
              </tr>
            </table>
          </td>
        </tr>
      </table>
      <!--Button (E) -->

	
		</td>
	</tr>
</table>

<table width="100%"  id="mainTable"> 
	<tr><td width="100%">
		<script language="javascript">ComSheetObject('sheet1');</script>
	</td></tr>
</table> 
		
           <%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_CLOSE.jsp"%>
</form>
</body>
</html>
