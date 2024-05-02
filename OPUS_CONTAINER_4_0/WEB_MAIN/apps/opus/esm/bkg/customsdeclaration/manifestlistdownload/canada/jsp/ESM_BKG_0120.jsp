<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0120.jsp
*@FileTitle  : ACI_Vessel Information
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/29
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strMenuType 		= "Origin";
	
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		if ("ESM_BKG_0120_2".equals(request.getParameter("pgmNo")))
		{
			strMenuType = "Canada";
		}	
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
	
%>

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form" method="post">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="menu_type" value="<%=strMenuType%>" id="menu_type" />


<!-- 개발자 작업	-->
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	    
	    <!-- page_title(S) -->
	    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	    <h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	    <!-- page_title(E) -->
	    
	    <!-- page_location(S) -->
	    <div class="location">
	        <!-- location 내용 동적생성 (별도 코딩 불필요) -->
	        <span id="navigation"></span>
	    </div>
	    <!-- page_location(E) -->
	</div>
	<!-- page_title_area(E) -->
	
	    <!-- layout_wrap(S) -->
    <div class="layout_wrap" style="width:70%">
        <!-- layout_vertical_2(S) -->
        <div class="layout_vertical_2 pad_rgt_8" style="width:50%">
            <!-- background DIV(S) -->
            <div class="pad_rgt_12 pad_left_12 pad_btm_8 pad_top_8 mar_top_12">
            
                <!-- opus_grid_title(S) -->
                <h3 class="title_design">Origin Office</h3>
                <!-- opus_grid_title(E) -->
                <div>
                    <h3>Preparation</h3>
                    <table style="width:100%">
                        <colgroup>
                            <col width="100%" />
                        </colgroup>
                        <tbody>
                            <tr>
                                <td class="pad_btm_4">
                                	<button type="button" style="width:100%" class="btn_etc align_left" name="btn_1_1" id="btn_1_1" onmouseover="obj_MouseOver('btn_1_1')" onmouseout="obj_MouseOut('btn_1_1')" >1. ETL & CRN Inquiry</button>                                	
                               	</td>
                            </tr>
                            <tr>
                                <td class="pad_btm_4">
                                	<button type="button" style="width:100%" class="btn_etc align_left" name="btn_1_2" id="btn_1_2" onmouseover="obj_MouseOver('btn_1_2')" onmouseout="obj_MouseOut('btn_1_2')" >2. Manifest Data Input Cross-Check</button>
                                </td>                               
                            </tr>
                            <tr>
                                <td class="pad_btm_4">
                                	<button type="button" style="width:100%" class="btn_etc align_left" name="btn_1_3" id="btn_1_3" onmouseover="obj_MouseOver('btn_1_3')" onmouseout="obj_MouseOut('btn_1_3')" >3. House B/L Data Input Cross-Check</button>
                               	</td>                                                               
                            </tr>
                        </tbody>
                    </table>
                    <h3>Manifest Transmit</h3>
                    <table style="width:100%">
                        <colgroup>
                            <col width="100%" />
                        </colgroup>
                        <tbody>
                            <tr>
                                <td class="pad_btm_4">
                                	<button type="button" style="width:100%" class="btn_etc align_left" name="btn_1_4" id="btn_1_4" onmouseover="obj_MouseOver('btn_1_4')" onmouseout="obj_MouseOut('btn_1_4')" >1. Customs Data Download (D/L)</button>                                	                                	
                               	</td>
                            </tr>
                            <tr>
                                <td class="pad_btm_4">
                                	<button type="button" style="width:100%" class="btn_etc align_left" name="btn_1_5" id="btn_1_5" onmouseover="obj_MouseOver('btn_1_5')" onmouseout="obj_MouseOut('btn_1_5')" >2. Manifest Transmit(A6A)</button>
                                </td>                               
                            </tr>                           
                        </tbody>
                    </table>
                   	<h3>Manifest  Amend</h3>
                    <table style="width:100%">
                        <colgroup>
                            <col width="100%" />
                        </colgroup>
                        <tbody>
                            <tr>
                                <td class="pad_btm_4">
                                	<button type="button" style="width:100%" class="btn_etc align_left" name="btn_1_6" id="btn_1_6" onmouseover="obj_MouseOver('btn_1_6')" onmouseout="obj_MouseOut('btn_1_6')" >1. Amendment Transmit</button>                                	                                	                                	
                               	</td>
                            </tr>
                            <tr>
                                <td class="pad_btm_4">
                                	<button type="button" style="width:100%" class="btn_etc align_left" name="btn_1_7" id="btn_1_7" onmouseover="obj_MouseOver('btn_1_7')" onmouseout="obj_MouseOut('btn_1_7')" >2. Manifest Details by B/L (Origin Office)</button>
                                </td>                               
                            </tr>                           
                        </tbody>
                    </table> 
                    <h3>Report</h3>
                    <table style="width:100%">
                        <colgroup>
                            <col width="100%" />
                        </colgroup>
                        <tbody>
                            <tr>
                                <td class="pad_btm_4">
                                	<button type="button" style="width:100%" class="btn_etc align_left" name="btn_1_8" id="btn_1_8" onmouseover="obj_MouseOver('btn_1_8')" onmouseout="obj_MouseOut('btn_1_8')" >1. Transmission History</button>                             	                                	                                	
                               	</td>
                            </tr>
                            <tr>
                                <td class="pad_btm_4">
                                	<button type="button" style="width:100%" class="btn_etc align_left" name="btn_1_9" id="btn_1_9" onmouseover="obj_MouseOver('btn_1_9')" onmouseout="obj_MouseOut('btn_1_9')" >2. Receiving History</button>                                	
                                </td>                               
                            </tr>                           
                            <tr>
                                <td class="pad_btm_4">
                                	<button type="button" style="width:100%" class="btn_etc align_left" name="btn_1_10" id="btn_1_10" onmouseover="obj_MouseOver('btn_1_10')" onmouseout="obj_MouseOut('btn_1_10')" >3. ACI Report</button>                                	                                	
                                </td>                               
                            </tr>
                        </tbody>
                    </table>
				</div>
			</div>
		</div>
		<!-- layout_vertical_2(S) -->
        <div class="layout_vertical_2 pad_rgt_8" style="width:50%">
            <!-- background DIV(S) -->
            <div class="pad_rgt_12 pad_left_12 pad_btm_8 pad_top_8 mar_top_12">
            
                <!-- opus_grid_title(S) -->
                <h3 class="title_design">Canada Office</h3>
                <!-- opus_grid_title(E) -->
                <div>
                    <h3>I/B Documentation</h3>
                    <table style="width:100%">
                        <colgroup>
                            <col width="100%" />
                        </colgroup>
                        <tbody>
                            <tr>
                                <td class="pad_btm_4">
                                	<button type="button" style="width:100%" class="btn_etc align_left" name="btn_2_1" id="btn_2_1" onmouseover="obj_MouseOver('btn_2_1')" onmouseout="obj_MouseOut('btn_2_1')" >1. ETL & CRN Inquiry</button>                             	                                	                                	
                               	</td>
                            </tr>
                            <tr>
                                <td class="pad_btm_4">
                                	<button type="button" style="width:100%" class="btn_etc align_left" name="btn_2_2" id="btn_2_2" onmouseover="obj_MouseOver('btn_2_2')" onmouseout="obj_MouseOut('btn_2_2')" >2. Customs Data Download (D/L)</button>                                	                             	                                	                                	
                               	</td>
                            </tr>
                            <tr>
                                <td class="pad_btm_4">
                                <button type="button" style="width:100%" class="btn_etc align_left" name="btn_2_3" id="btn_2_3" onmouseover="obj_MouseOver('btn_2_3')" onmouseout="obj_MouseOut('btn_2_3')" >3. Manifest Transmit(A6A)</button>                                                             	                                	                                	
                               	</td>
                            </tr>
                            <tr>
                                <td class="pad_btm_4">
                                	<button type="button" style="width:100%" class="btn_etc align_left" name="btn_2_4" id="btn_2_4" onmouseover="obj_MouseOver('btn_2_4')" onmouseout="obj_MouseOut('btn_2_4')" >4. Vessel Arrival Transmit (A6)</button>                            	                                	                                	
                               	</td>
                            </tr>
                            <tr>
                                <td class="pad_btm_4">
                                	<button type="button" style="width:100%" class="btn_etc align_left" name="btn_2_5" id="btn_2_5" onmouseover="obj_MouseOver('btn_2_5')" onmouseout="obj_MouseOut('btn_2_5')" >5. C/A Report (I/B)</button>                                	                             	                                	                                	
                               	</td>
                            </tr>
                            <tr>
                                <td class="pad_btm_4">
                                	<button type="button" style="width:100%" class="btn_etc align_left" name="btn_2_6" id="btn_2_6" onmouseover="obj_MouseOver('btn_2_6')" onmouseout="obj_MouseOut('btn_2_6')" >6. Amendment Transmit</button>                            	                                	                                	
                               	</td>
                            </tr>
                            <tr>
                                <td class="pad_btm_4">
                                	<button type="button" style="width:100%" class="btn_etc align_left" name="btn_2_7" id="btn_2_7" onmouseover="obj_MouseOver('btn_2_7')" onmouseout="obj_MouseOut('btn_2_7')" >7. Manifest Details by B/L (CA Office)</button>                             	                                	                                	
                               	</td>
                            </tr>
						</tbody>
					</table>
					<h3>Notice</h3>
                    <table style="width:100%">
                        <colgroup>
                            <col width="100%" />
                        </colgroup>
                        <tbody>
                            <tr>
                                <td class="pad_btm_4">
                                	<button type="button" style="width:100%" class="btn_etc align_left" name="btn_2_8" id="btn_2_8" onmouseover="obj_MouseOver('btn_2_8')" onmouseout="obj_MouseOut('btn_2_8')" >1. Advice Notes</button>                                	                             	                                	                                	
                               	</td>
                            </tr>
						</tbody>
					</table>
					<h3>Code / Set-up</h3>
                    <table style="width:100%">
                        <colgroup>
                            <col width="100%" />
                        </colgroup>
                        <tbody>
                            <tr>
                                <td class="pad_btm_4">
                                	<button type="button" style="width:100%" class="btn_etc align_left" name="btn_2_9" id="btn_2_9" onmouseover="obj_MouseOver('btn_2_9')" onmouseout="obj_MouseOut('btn_2_9')" >1. CRN (Conveyance Ref. No.) Create</button>                                	                                	                             	                                	                                	
                               	</td>
                            </tr>
							<tr>
                                <td class="pad_btm_4">
                                	<button type="button" style="width:100%" class="btn_etc align_left" name="btn_2_10" id="btn_2_10" onmouseover="obj_MouseOver('btn_2_10')" onmouseout="obj_MouseOut('btn_2_10')" >2. Vessel Information Setup</button>                                	                                	                                	                             	                                	                                	
                               	</td>
                            </tr>
                            <tr>
                                <td class="pad_btm_4">
                                	<button type="button" style="width:100%" class="btn_etc align_left" name="btn_2_11" id="btn_2_11" onmouseover="obj_MouseOver('btn_2_11')" onmouseout="obj_MouseOut('btn_2_11')" >3. Location of Goods Setup</button>
                            </tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>

<!-- 개발자 작업  끝 -->
</form>