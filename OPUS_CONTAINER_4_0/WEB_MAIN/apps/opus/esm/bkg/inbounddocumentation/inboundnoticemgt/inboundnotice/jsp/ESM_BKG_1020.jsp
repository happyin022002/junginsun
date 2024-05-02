 <%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_BKG_1020.jsp
*@FileTitle  : Group Arrival Notice Template
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/28
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg1020Event"%>

<%
    EsmBkg1020Event     event = null;
    Exception serverException = null;
    String strOfc_cd          = "";
    String strErrMsg          = "";
    Logger log = Logger.getLogger("com.clt.apps.InboundBLMgtSC.PickUpNoticeBC");
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strOfc_cd = account.getOfc_cd();
        event = (EsmBkg1020Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
          strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
    } catch(Exception e) {
      out.println(e.toString());
    }
%>

<script type="text/javascript">
    function setupPage(){  
    	$('<button type="button" class="btn_accent" name="btn_Retrieve"	id="btn_Retrieve">Retrieve</button>').appendTo(".opus_design_btn");
        $('<button type="button" class="btn_normal" name="btn_Save"  	id="btn_Save">Save</button>').appendTo(".opus_design_btn");
        $('<button type="button" class="btn_normal" name="btn_Delete" 	id="btn_Delete">Delete</button>').appendTo(".opus_design_btn");
        loadPage();
    }
</script>

<form name="form">
<input type="hidden" name="f_cmd" value = "">
<input type="hidden" name="old_ofc_cd" value="">
<input type="hidden" name="an_seq" value="">

<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp"%>

<% if(!mainPage.equals("true")){ %>
<!-- popup_contens_area(S) -->
<div class="layer_popup_contents">
<% } %>

	<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry">
		    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
		    <table>
		        <colgroup>
		            <col width="110px" />
		            <col width="*" />
		        </colgroup>  
		        <tbody>
					<tr>
						<th>Office</th>
						<td>
							<input type="text" style="width:60px;ime-mode:disabled;" class="input1" name="ofc_cd" value="<%=strOfc_cd %>" caption="EQ Office Code" maxlength="6" minlength="5" dataformat="engup" required="" />
						</td>									
					</tr>
				</tbody>
			</table>
			
			<table>
				<colgroup>
		            <col width="110px" />
		            <col width="*" />
		        </colgroup>  
		          <tr>
		          	<th>Address</th>
		          	<td><input type="text" style="width:100%" name="addr_ctnt"></td>
		          </tr>
	        </table>
	        
	        <table> 
				<colgroup>
		            <col width="110px" />
		            <col width="*" />
		        </colgroup>  	        
	              <tr>
	              	<th>Important Notice</th>
	              	<td colspan=2><textarea style="width:100%;text-indent:0px" rows="8" name="impt_ntc_rmk"></textarea></td>
	              </tr>
	        </table>
		    <!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
		</div>
	<!-- opus_design_inquiry(E) -->
	</div>
	      
	
	<div class="wrap_result">   
	<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" style="display:none">			
			<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->		
			<script type="text/javascript">ComSheetObject('sheet1');</script>							
			<!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->			
		</div>
	<!-- opus_design_grid(E) -->
	</div>

<% if(!mainPage.equals("true")){ %>
</div>
<!-- popup_contens_area(E) -->
<% } %>

     
</form>