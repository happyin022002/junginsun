<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_AGT_008.jsp
*@FileTitle : 구주 FAC 계약 요율 Creation/Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-13
*@LastModifier : Hwang GyeongNam
*@LastVersion : 1.0
* 2006-12-13 Hwang GyeongNam
* 1.0 최초 생성\
* 2009-09-04 : Ho-Jin Lee : Alps 전환
=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>

<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.agt.agtagreement.agtcustomeragreementinfo.event.EsmAgt0008Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.apps.alps.esm.agt.common.ComboUtil"%>
<%@ page import="com.hanjin.apps.alps.esm.agt.common.CodeUtil" %>

<%
		EsmAgt0008Event  event = null;                                 //PDTO(Data Transfer Object including Parameters)
        Exception serverException   = null;                             //서버에서 발생한 에러
               
        String cntCd = "";
        String ofcCd = "";
        String ar_ofc_cd = "HAMUR";
        String modYn = "N";                                                     //수정가능여부

        String strErrMsg = "";                                                  //에러메세지
        String tmpGrpTp = "";                                                   //Location 별 Type 구분
        String tmpFacDiv = "";                                                  //Type 구분
        String tmpFacTp = "";                                                   //Charge Type 구분
        String tmpRcvTerm = "";                                                 //Received Term 구분
        String tmpDelTerm = "";                                                 //Delivery Term 구분
        String grpTpCode = "";                                                  //Location 별 Type 구분 Code
        String grpTpText = "";                                                  //Location 별 Type 구분 Text
        String facDivCode = "";                                                 //Type 구분 Code
        String facDivText = "";                                                 //Type 구분 Text
        String facTpCode = "";                                                  //Charge Type 구분 Code
        String facTpText = "";                                                  //Charge Type 구분 Text
        String rcvTermCode = "*|";                                              //Received Term 구분 Code
        String delTermCode = "*|";                                              //Delivery Term 구분 Code

        String arOfcCd = "";    //AR Office ComboBox
        String selOffice = "";  //AR Office ComboBox
        
        int rowCount     = 0;                                                   //DB ResultSet 리스트의 건수
      
        Logger log = Logger.getLogger("com.hanjin.apps.AGTAgreement.AGTCustomerAgreementinfo");
        
        try {
                // 유저 정보를 가지고 온다.
                SignOnUserAccount account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
                cntCd = JSPUtil.getNull(account.getCnt_cd());
                ofcCd = JSPUtil.getNull(account.getOfc_cd());

                //공통코드 combo string 가져와서 필요한 부분 추출
                tmpGrpTp = JSPUtil.getIBCodeCombo("", "", "CD00616", 0, "");
                tmpFacDiv = JSPUtil.getIBCodeCombo("", "", "CD00993", 0, "");
                tmpFacTp = JSPUtil.getIBCodeCombo("", "", "CD00788", 0, "");
                tmpRcvTerm = JSPUtil.getIBCodeCombo("", "", "CD00764", 0, "");
                tmpDelTerm = JSPUtil.getIBCodeCombo("", "", "CD00765", 0, "");

                if(tmpGrpTp != null && tmpGrpTp.length() > 8) {
                        grpTpCode = tmpGrpTp.substring(tmpGrpTp.indexOf("Code = \"")+8, tmpGrpTp.lastIndexOf("\""));
                        grpTpText = tmpGrpTp.substring(tmpGrpTp.indexOf("Text = \"")+8, tmpGrpTp.indexOf("\";"));
                }

                if(tmpFacDiv != null && tmpFacDiv.length() > 8) {
                        facDivCode = tmpFacDiv.substring(tmpFacDiv.indexOf("Code = \"")+8, tmpFacDiv.lastIndexOf("\""));
                        facDivText = tmpFacDiv.substring(tmpFacDiv.indexOf("Text = \"")+8, tmpFacDiv.indexOf("\";"));
                }

                if(tmpFacTp != null && tmpFacTp.length() > 8) {
                        facTpCode = tmpFacTp.substring(tmpFacTp.indexOf("Code = \"")+8, tmpFacTp.lastIndexOf("\""));
                        facTpText = tmpFacTp.substring(tmpFacTp.indexOf("Text = \"")+8, tmpFacTp.indexOf("\";"));
                }

                if(tmpRcvTerm != null && tmpRcvTerm.length() > 8) {
                        rcvTermCode = rcvTermCode + tmpRcvTerm.substring(tmpRcvTerm.indexOf("Code = \"")+8, tmpRcvTerm.lastIndexOf("\""));
                }

                if(tmpDelTerm != null && tmpDelTerm.length() > 8) {
                        delTermCode = delTermCode + tmpDelTerm.substring(tmpDelTerm.indexOf("Code = \"")+8, tmpDelTerm.lastIndexOf("\""));
                }

                event = (EsmAgt0008Event)request.getAttribute("Event");
                serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

                if (serverException != null) {
                        strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
                } else {
                	GeneralEventResponse eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
//                        if (eventResponse != null) {
//                                rowSet = eventResponse.getRs();
//                                if(rowSet != null){
//                                         rowCount = rowSet.getRowCount();
//                                } // end if
//                        } // end if
                } // end else
        } catch (Exception e) {
                out.println(e.toString());
        }

        //로그인한 USER가 속한 부서의 A/R Office Code를 구한다.
        if(ofcCd.equals("HAMUSG") || ofcCd.equals("HAMUAG")){
                ofcCd = "HAMUR";
        }

        //2007.05.14 수정가능여부를 설정한다.
        if(ar_ofc_cd.equals(ofcCd)) modYn = "Y";

        arOfcCd = CodeUtil.getInstance().getCodeInfo("arOfcCd", ofcCd);

        //Combo Data : getCodeCombo('태그명','초기값', '추가요소', '업무명', '조건코드', '전체유무', '추가옵션')
        selOffice = ComboUtil.getCodeCombo("fac_ofc_cd", arOfcCd, " style='width:85', class='input1'", "arOfcListFac", ofcCd, "&lt;&lt;select&gt;&gt;", "");
%>
<html>
<head>
<title>구주 FAC 계약 요율 Creation/Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
        function setupPage(){
                var errMessage = "<%=strErrMsg%>";
                if (errMessage.length >= 1) {
                        ComShowMessage(errMessage);
                } // end if
                loadPage("<%=grpTpCode%>", "<%=grpTpText%>", "<%=facDivCode%>", "<%=facDivText%>", "<%=facTpCode%>", "<%=rcvTermCode%>", "<%=delTermCode%>");
        }
        
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<iframe height="0" width="0" name="frmHidden"></iframe>

<form name = "hiddenF" mehhod="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="cust_cd">
<input type="hidden" name="sheetId">
<input type="hidden" name="row">
<input type="hidden" name="colNm1">
<input type="hidden" name="colNm2">
<input type="hidden" name="selOffice"><!-- Office Cd -->
<input type="hidden" name="newRow">
<input type="hidden" name="fac_ofc_cd"><!-- Office Cd -->

</form>

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="cntCd" value = "<%=cntCd%>">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="ff_cnt_cd">
<input type="hidden" name="newRow">
<input type="hidden" name="ofc_cd">
<input type="hidden" name="recipients_eml">
<input type="hidden" name="recipients_name">
<input type="hidden" name="cnt">
<input type="hidden" name="mod" value="<%= modYn %>">

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
			<!-- TABLE '#D' : ( Button : Main ) (S) -->
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
                                    		<td class="btn1" name="btn_retrieve">Retrieve</td>
                                    		<td class="btn1_right"></td>
                                    	</tr>
                                    </table>
								</td>
                                <td class="btn1_line"></td>
                                <td>
                                	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_save">Save</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
                                <%
                                if ( ar_ofc_cd.equals(ofcCd) ) {
                               	ar_ofc_cd = "HAMUR";
								%>
								
                                <td>
                                	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_approval">Approval</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
                                <td>
                                	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_reject">Reject</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								  
                                <%
                                } else {
                                	ar_ofc_cd = "HAMUR";
                                %>
                                   
                                <td>
                                	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                    	<tr>
                                    		<td class="btn1_left"></td>
                                    		<td class="btn1" name="btn_request">Request</td>
                                    		<td class="btn1_right"></td>
                                    	</tr>
                                    </table>
								</td>
								 
                                <%
                                }
                                %>
                                <td>
                                	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_uploadexcel">Load Excel</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
                                <td>
                                	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_downexcel">Down Excel</td>
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
            <!-- TABLE '#D' : ( Button : Main ) (E) -->
			<!-- TABLE '#D' : ( Search Options : BKG Information) (S) -->
			<table class="search">
				<tr>
					<td class="bg">
                    	<table class="search_in" border="0" style="width:300">
                        	<tr class="h23">
								<td width="5%">Office</td>
                                <td><%= selOffice %></td>
                                <td width="6%" >Status</td>
                                <td width="14%">
									<SELECT name="s_sts_cd"  style="width:90" onChange="stsCd_OnChange();">
										<OPTION value="AS" selected>Approved</OPTION>
										<OPTION value="RR">Requested</OPTION>
										<OPTION value="RE">Rejected</OPTION>
										<OPTION value="">All</OPTION>
									</SELECT>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
            <!-- TABLE '#D' : ( Search Options  ) (E) -->
			<table class="height_10">
				<tr>
					<td></td>
				</tr>
			</table>
			<!-- TABLE '#D' : ( Search Options ) (S) -->
			<table class="search">
                <tr>
                	<td class="bg">
		                <!-- : ( grid ) (S) -->
		                <table width="100%" id="mainTable">
							<tr>
								<td><script language="javascript">ComSheetObject('sheet1');</script></td>
							</tr>
		                </table>
						<!-- : ( grid ) (E) -->
						<%
                		if ( !ar_ofc_cd.equals(ofcCd) ) {
						%>
		                <!-- : ( Button : Sub ) (S) -->
		                <table width="100%" class="button">
	    					<tr>
	    						<td class="btn2_bg">
	                            	<table border="0" cellpadding="0" cellspacing="0">
	                            		<tr>
	                                		<td>
	                                			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btng_rowadd">Row&nbsp;Add</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
	                                       			<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btng_rowcopy">Row Copy</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
						<!-- : ( Button : Sub ) (E) -->
						<%
		                }
						%>
					</td>
				</tr>
			</table>
			<!-- TABLE '#D' : ( Search Options ) (E) -->
		</td>
	</tr>
</table>
<!-- Outer Table (E)-->
</form>
</body>
</html>
<SCRIPT LANGUAGE="javascript">
<!--
      /*
        ibSheet 를 제외한 폼 입력값(?) 유저가 입력한 정보를 event를 통해서 다시 넘겨받아 화면에 뿌려주는 부분입니다.
      */
      with(document.form)
      {
                eval("ofc_cd").value  = "<%=ofcCd%>";
      }
-->
</SCRIPT>