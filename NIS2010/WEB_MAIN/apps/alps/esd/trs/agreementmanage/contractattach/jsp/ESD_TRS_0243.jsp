<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TRS_0243.jsp
*@FileTitle : Contract Attach
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
===============================================================================
 History
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.bizcommon.util.BizComUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.agreementmanage.contractattach.event.EsdTrs0243Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.core.config.SubSystemConfigFactory"%>

<%
	EsdTrs0243Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id	= "";
	String strUsr_nm	= "";
	String strRhq_ofc_cd= "";
	String csrGwUrl = "";
	String    chk_agmt_no   = ((request.getParameter("chk_agmt_no")==null )?"":request.getParameter("chk_agmt_no"));

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strRhq_ofc_cd  = account.getRhq_ofc_cd();

		event = (EsdTrs0243Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		// 10만불 gwlink 추가-4347-09-24
		csrGwUrl = SubSystemConfigFactory.get("CSR.GW.URL");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Delivery Monitor Detail</title>
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
<form  name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="f_ctrt_mn_flg">
<input type="hidden" name="f_sheet">
<input type="hidden" name="f_row">
<input type="hidden" name="agmt_no" value="<%=chk_agmt_no%>" >
<input type="hidden" name="csr_gw_rul" value="<%=csrGwUrl%>" >

<!-- 개발자 작업	-->
<table width="100%" class="popup" cellpadding="10">
  <tr>
    <td class="top"></td>
  </tr>
	<tr>
		<td valign="top">
			<!--Page Title, Historical (S)-->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> Contract Link</td></tr>
			</table>
			<!--Page Title, Historical (E)-->

			<!--biz page (S)-->			
			<table class="height_8"><tr><td></td></tr></table>
						
			<table class="search"> 
				<tr class="bg">
					<td style="height:115" valign="top">
						<div id="sheetLayer" style="display:inline">
							<!-- Grid  (S) -->
							
							<table width="100%"  id="mainTable">
								<tr class="h23">
									<td width="100"> Main Contract</td>
								</tr>
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('sheet1');</script>
									</td>
								</tr>
							</table>
							<!-- Grid (E) -->
						</div>

						<!--  Button_Sub (S) -->
						<table width="100%" class="button"> 
					       	<tr>
						       	<td class="btn2_bg">
									<table border="0" cellpadding="0" cellspacing="0">
										<tr>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btng_save">Save</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btng_delete">Delete</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
				    	<!-- Button_Sub (E) -->
					</td>
				</tr>
			</table>
			
			<table class="search"> 
				<tr class="bg">
					<td style="height:315" valign="top">
						<div id="sheetLayer" style="display:inline">
							<!-- Grid  (S) -->
							
							<table width="100%"  id="mainTable">
								<tr class="h23">
									<td width="100"> Sub Contract</td>
								</tr>
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject('sheet2');</script>
									</td>
								</tr>
							</table>
							<!-- Grid (E) -->
						</div>

						<!--  Button_Sub (S) -->
						<table width="100%" class="button"> 
					       	<tr>
						       	<td class="btn2_bg">
									<table border="0" cellpadding="0" cellspacing="0">
										<tr>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btng_rowadd2">Row Add</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btng_save2">Save</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btng_delete2">Delete</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
				    	<!-- Button_Sub (E) -->
					</td>
				</tr>
			</table>
			
      <table width="100%" class="sbutton">
        <tr>
          <td height="71" class="popup"><table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
              <tr>
                <td class="btn3_bg"><table border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="72"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
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
			
		</td>
	</tr>
</table>

<!-- 개발자 작업  끝 -->
</form>

</body>
</html>