<%
/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : esm_bkg_0004.jsp
 *@FileTitle : Customer Advisory Body Set-up
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.06.30
 *@LastModifier : 이인영
 *@LastVersion : 1.0
 * 2011.06.30 이인영
 * 1.0 Creation
 ===============================================================================
 * History
 * 2012.03.22 변종건 [CHM-201216424-01] ALPS Customer Advisory 기능 보완 검토 요청 (Template 문서 첨부 등)
 * 2013.02.19 김보배 [CHM-201322482] [BKG] 개발:Split 01-Customer Advisory 기능 추가 (BST Download)
 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.core.controller.util.WebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg0004Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%
	EsmBkg0004Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_email	    = "";
	String strOfc_cd		= "";
	String strRmkUseFlg		= "";
	String strSearchType	= "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		event = (EsmBkg0004Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		strRmkUseFlg = JSPUtil.getNull(request.getParameter("rmk_use_flg"));
		strSearchType = JSPUtil.getNull(request.getParameter("search_type"));

	}catch(Exception e) {
		out.println(e.toString());
	} 
%>
<html>
<head>
<title>Customer Advisory Body Set-up</title>
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
<body onLoad="setupPage();" class="popup_bg">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="delt_flg">
<input type="hidden" name="dir_cd" value="E">
<input type="hidden" name="keys" value="">
<input type="hidden" name="file_path_rmk" value="">
<input type="hidden" name="exist_ofc_cd_flg" value="">
<input type="hidden" name="rmk_use_flg" value="<%=strRmkUseFlg%>">
<input type="hidden" name="pre_eml_subj_ctnt_seq" value="">
<input type="hidden" name="btn_type" value="">
<input type="hidden" name="search_type" value="<%=strSearchType%>">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0">
	<tr>
    	<td class="top"></td>
  	</tr>
  	<tr>
    	<td valign="top">
    		<!-- : ( Title ) (S) -->
      		<table width="100%" border="0">
        		<tr>
          			<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Customer Advisory Body Set-up</td>
        		</tr>
      		</table>
		    <!-- : ( Title ) (E) -->
		    <!-- : ( Search Options ) (S) -->
      		<table class="search">
      		<!-- Grid  (S) style="width:100%"-->
        		<tr>
        			<td>
			       		<table width="100%"  id="mainTable" style="display:none">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table>
					</td>
				</tr>
        		<tr>
          			<td class="bg">
          				<table width="100%" border="0" class="search">
              				<tr class="h23">
				                <td width="100">VVD</td>
				                <td width="120"><input type="text" style="width:100;" class="input" name="vvd" value="<%= JSPUtil.getParameter(request, "vvd")%>" disabled></td>
				                <td width="110">Office&nbsp;(Set up by)</td>
				                <td width="130">&nbsp;&nbsp;<input type="text" style="width:100;ime-mode:disabled" class="input1" onKeyPress="ComKeyOnlyAlphabet('uppernum');" maxlength="6" name="ofc_cd" value="<%= JSPUtil.getParameter(request, "ofc_cd")%>"></td>
				                <td width="90">Creation Date</td>
				                <td width="120"><input type="text" style="width:100;" class="input2" name="cre_dt" value="" disabled></td>
				                <td>&nbsp;</td>
			              	</tr>
			            </table>
			            <table class="line_bluedot">
			              	<tr class="h23">
			                	<td></td>
			              	</tr>
			            </table>
			            <table width="100%" border="0" class="search">
			              	<tr class="h23">
				                <td width="100">Subject</td>
				                <td width="500"><input type="text" style="width:465;" class="input" name="eml_subj_ctnt" value=""></td>
				                
				                <td width="107" style="text-align: right;">Selected Seq.</td>
				                <td width="9">&nbsp;</td>
				                <td width=""><input type="text" style="width:35;" class="input2" name="sel_seq" value="" readonly></td>
			              	</tr>
			            </table>
						<table width="100%" border="0" class="search">
							<tr class="h23">
								<td width="100">
									<div id="attach_button" style="display: none">
										<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr>
												<td class="btn1_left"></td>
												<td class="btn1" name="btn_attach">Attach File</td>
												<td class="btn1_right"></td>
											</tr>
											<tr>
												<td>&nbsp;</td>
											</tr>
										</table>
									</div>
									<div id="delete_button" style="display: inline">
										<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr>
												<td class="btn1_left"></td>
												<td class="btn1" name="btn_delete">Delete File</td>
												<td class="btn1_right"></td>
											</tr>
											<tr>
												<td>&nbsp;</td>
											</tr>
										</table>
									</div>
								</td>
								<td width="500"><script language="javascript">
									ComSheetObject('sheet2');
								</script>
								</td>

								<td valign="top">
									<table width="100%" border="0" class="search">
										<tr class="h23">
											<td width="107" style="text-align: right;">Ver Seq.</td>
											<td width="9">&nbsp;</td>
											<td width="55">
												<script language="javascript">
													ComComboObject( 'eml_subj_ctnt_seq', 1, 50, 1, 0);
												</script>
											</td>
											<td width="70">
												<table width="100%" border="0" class="button">
													<tr>
														<td class="btn1_left"></td>
														<td class="btn1" name="btn_select">Select</td>
														<td class="btn1_right"></td>
													</tr>
												</table>
											</td>
											<td>&nbsp;</td>
										</tr>
										<tr class="h23">
											<td width="105" style="text-align: right;">B/L No, CNTR No</td>
											<td colspan="2" style="padding-left: 4px;">
												<input type="checkbox" style="border-style: none;" name="file_desc" id="file_desc" value="Y" />
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
						<table class="line_bluedot">
							<tr class="h23">
								<td>&nbsp;</td>
							</tr>
						</table>
						<table class="search" border="0" style="width: 100%;">
							<tr class="h23"><td>&nbsp;Dear Valued Customer,</td></tr>
							<tr class="tr2_head">
								<td width="">
									<textarea style="width: 100%" ; height="30%" rows="20" cols="92" style="font-family:Courier New; font-size:15px; text-indent:0px;overflow-y:scroll;overflow-x:hidden" wrap="physical" dataformat="etc" name="impt_ntc_rmk"></textarea>
								</td>
								<td width=""></td>
							</tr>
						</table>
					</td>
        		</tr>
            	
				<!-- Grid  (E) -->
      		</table>
      <!-- : ( Search Options ) (E) --></td>
  		</tr>
	</table>
<!-- : ( Button : pop ) (S) -->
	<table width="100%" class="sbutton">
  		<tr>
    		<td height="71" class="popup">
    			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
        			<tr>
        				<td class="btn3_bg">
        					<table border="0" cellpadding="0" cellspacing="0">
        						<tr>
            						<td>
            							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    						<tr>
                    							<td class="btn1_left"></td>
                      							<td class="btn1" name="btn_retrieve">Retrieve</td>
                      							<td class="btn1_right"></td>
                    						</tr>
                						</table>
            						</td>
            						<td>
						            	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						                    <tr>
						                    	<td class="btn1_left"></td>
						                    	<td class="btn1" name="btn_save">Save</td>
						                    	<td class="btn1_right"></td>
						                    </tr>
						                </table>
            						</td>
            						<td class="btn1_line"></td>
						            <td>
						            	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						                    <tr>
						                      	<td class="btn1_left"></td>
						                      	<td class="btn1" name="btn_close">Close</td>
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
<!-- : ( Button : pop ) (E) -->
</form>
<iframe name="hiddenFrame" style="visibility:hiddden" height="0" width="0"></iframe>
</body>
</html>
