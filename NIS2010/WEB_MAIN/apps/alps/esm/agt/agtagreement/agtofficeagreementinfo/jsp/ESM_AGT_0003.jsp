<%--
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESMAGT0003.jsp
*@FileTitle : Agent Agreement Rate Creation 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2009.08.17 이호진
* 1.0 Creation
* 2009-08-22 Ho-Jin Lee : Alps 전환 수정
=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.apps.alps.esm.agt.agtagreement.agtofficeagreementinfo.event.EsmAgt0003Event"%>
<%@ page import="com.hanjin.apps.alps.esm.agt.common.ComboUtil"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
		EsmAgt0003Event  event = null;                                 //PDTO(Data Transfer Object including Parameters)
		Exception serverException   = null;			//서버에서 발생한 에러
		String strErrMsg = "";						//에러메세지
        int rowCount     = 0;                                                   //DB ResultSet 리스트의 건수
		        
        String successFlag = "";
    	String codeList  = "";
    	String pageRows  = "100";

    	String strUsr_id		= "";
    	String strUsr_nm		= "";
    	Logger log = Logger.getLogger("com.hanjin.apps.AGTAgreement.AGTOfficeAgreementInfo");
    	
        String temp_ac_tp = "";
        String ac_tp_cd = "";
        String ac_tp_text = "";

        try {
        	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    		strUsr_id =	account.getUsr_id();
    		strUsr_nm = account.getUsr_nm();

                //공통코드 combo string 가져와서 필요한 부분 추출
                temp_ac_tp = JSPUtil.getIBCodeCombo("", "", "CD00597", 0, "");
                if(temp_ac_tp != null && temp_ac_tp.length() > 8) {
                        ac_tp_cd = temp_ac_tp.substring(temp_ac_tp.indexOf("Code = \"")+8, temp_ac_tp.lastIndexOf("\""));
                        ac_tp_text = temp_ac_tp.substring(temp_ac_tp.indexOf("Text = \"")+8, temp_ac_tp.indexOf("\";"));
                }

                event = (EsmAgt0003Event)request.getAttribute("Event");
        		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

                if (serverException != null) {
                        strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
                }else{
                	// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
            		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
            	} // end else
        }catch(Exception e) {
                out.println(e.toString());
        }
%>
<html>
<head>
<title>Agent Agreement Rate Creation </title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
        
        function setupPage(){
			var errMessage = "<%=strErrMsg%>";
			if (errMessage.length >= 1) {
				ComShowMessage(errMessage);
			} // end if
			// InitTab();
			loadPage("<%=ac_tp_cd%>", "<%=ac_tp_text%>");
	}

        var mFlag = 0;
    function expandSheet(){
        if(mFlag == 1){
            mFlag = 0;
            document.col_hidden.src = "/hanjin/img/bt_mnopen_off.gif";
            document.form.mFlag.value = "0";
        }else{
            mFlag = 1;
            document.col_hidden.src = "/hanjin/img/bt_mnclose_off.gif";
            document.form.mFlag.value = "1";
        }
    }

</script>

<Script language="javascript">

</Script>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input  type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="mFlag" value="1">
<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
	<tr>
		<td>
			<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr>
					<td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td>
				</tr>
				<tr>
					<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td>
				</tr>
			</table>
			<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->
			<table class="height_10">
				<tr><td></td></tr>
			</table>
            <!-- TABLE '#D' : ( Search Options ) (S) -->
            <table class="search">
            	<tr>
            		<td class="bg">
                    	<table class="search" border="0" style="width:100%;">
                        	<tr>
                            	<td width="240" valign="top">
                                	<!-- : ( BKG Information ) (S) -->
                                    <table class="search" border="0">
                                    	<tr>
                                    		<td class="title_h"></td>
                                            <td class="title_s">Agreement Office</td>
										</tr>
                                        <tr><td class="height_5"></td></tr>
									</table> 
									<table style="width:240;" class="search">
                                    	<tr class="h23">
                                        	<td width="42%">Vendor</td>
                                        	<td><input type="hidden" style="width:45;" name="vndr_cnt_cd" readonly><input class="input1" type="text" style="width:60;" name="vndr_seq" readonly >&nbsp;<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="cnt_btn"></td>
                                    	</tr>
                                        <tr class="h23">
                                        	<td>Agreement No.</td>
                                            <td><input type="text" style="width:60;" name="agmt_ofc_cty_cd" readonly>&nbsp;<input type="text" style="width:60;" name="agn_agmt_seq" readonly><input type="hidden" name="agmt_ofc_cd"><input type="hidden" name="agn_agmt_ver_seq"><input type="hidden" name="s_rownum" value="2"></td>
										</tr>
									</table>
									<table style="width:240;" class="search">
                                    	<tr class="h23">
                                        	<td valign="top" width="41%">Office</td>
                                            <td width="141">
                                            	<!-- : ( grid ) (S) -->
                                                <table width="100%" id="mainTable">
													<tr>
														<td><script language="javascript">ComSheetObject('sheet1');</script></td>
													</tr>
												</table>
												<!-- : ( grid ) (E) -->
											</td>
										</tr>
									</table>
								</td>
								<td width="17" valign="top"></td>
								<td width="100%" valign="top">
                                	<!-- : ( BKG Information ) (S) -->
                                    <table class="search" border="0">
                                        <tr>
                                        	<td class="title_h"></td>
                                        	<td class="title_s">Version Control</td>
                                            <td>
												<!-- : ( Button : Sub ) (S) -->
                                                <table width="100%" class="button">
                                                	<tr>
                                                		<td class="btn2_bg">
                                                        	<table border="0" cellpadding="0" cellspacing="0">
                                                            	<tr>
																	<!-- Repeat Pattern -->
                                                                    <td>
                                                                    	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                                        	<tr>
                                                                        		<td class="btn2_left"></td><td class="btn2" name="btng_rowadd1">Row Add</td><td class="btn2_right"></td>
                                                                        	</tr>
                                                                        </table>
																	</td>
																	<td>
																		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                                        	<tr>
                                                                        		<td class="btn2_left"></td><td class="btn2" name="btng_save1">Save</td><td class="btn2_right"></td>
                                                                        	</tr>
                                                                        </table>
																	</td>
																	<td>
																		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                                    		<tr>
                                                                            	<td class="btn2_left"></td><td class="btn2" name="btng_agreementcopy">Agreement Copy</td><td class="btn2_right"></td>
                                                                            </tr>
																		</table>
																	</td>
																	<td align="right">&nbsp;Version : <input type="text" name="version" style="width:30;ime-mode:disabled;"  maxlength="2"></td>
																</tr>
																<!-- Repeat Pattern -->
															</table>
														</td>
													</tr>
												</table>
												<!-- : ( Button : Sub ) (E) -->
											</td>
										</tr>
										<tr><td class="height_5"></td></tr>
									</table>
									<!-- : ( grid ) (S) -->
                                    <table width="100%" id="mainTable">
                                    	<tr>
                                    		<td><script language="javascript">ComSheetObject('sheet2');</script></td>
                                    	</tr>
									</table>
                                    <!-- : ( grid ) (E) -->
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
            <!-- TABLE '#D' : ( Search Options) (E) -->
			<table class="search_in"><tr><td></td></tr></table>
            <table class="height_10"><tr><td></td></tr></table>
			<!-- TABLE '#D' : ( Search Options ) (S) -->
            <table class="search">
            	<tr>
            		<td class="bg">
		                <!-- : ( BKG Information ) (S) -->
                        <table class="search" border="0">
        					<tr>
        						<td class="title_h"></td>
                                <td class="title_s">Definition & Compensation</td>
                                <td align="right">Version : <input type="text" name="current" style="width:50; align=right" readonly>&nbsp;/&nbsp;<input type="text" name="total" style="width:50; align=right" readonly></td>
							</tr>
							<tr><td class="height_5" colspan="3"></td></tr>
                        </table>
                		<!-- : ( grid ) (S) -->
                		<table width="100%" id="mainTable">
                        	<tr>
                        		<td><script language="javascript">ComSheetObject('sheet3');</script></td>
                        	</tr>
                        </table>
                        <!-- : ( grid ) (E) -->
                        <!-- : ( Button : Sub ) (S) -->
                        <table width="100%" class="button">
                        	<tr>
                        		<td class="btn2_bg">
                        			<table border="0" cellpadding="0" cellspacing="0">
                                        <tr>
                                        	<!-- Repeat Pattern -->
                                            <td>
                                            	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                	<tr>
                                                		<td class="btn2_left"></td><td class="btn2" name="btng_rowadd2">Row Add</td><td class="btn2_right"></td>
                                                	</tr>
                                                </table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                            		<tr>
                                            			<td class="btn2_left"></td><td class="btn2" name="btng_rowcopy">Row Copy</td><td class="btn2_right"></td>
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
											<td valign="top"><a OnClick="JavaScript:expandSheet();"><img class="cursor" src="/hanjin/img/bt_mnopen_off.gif" height="14" border="0" name="col_hidden"></a></td>
											<!-- Repeat Pattern -->
										</tr>
									</table>
                                </td>
							</tr>
						</table>
                        <!-- : ( Button : Sub ) (E) -->
					</td>
				</tr>
			</table>
            <!-- TABLE '#D' : ( Search Options) (E) -->
		</td>
	</tr>
</table>
<!-- Outer Table (E)-->
</form>
</body>
</html>
<%@include file="../../../common/include/common.jsp"%>