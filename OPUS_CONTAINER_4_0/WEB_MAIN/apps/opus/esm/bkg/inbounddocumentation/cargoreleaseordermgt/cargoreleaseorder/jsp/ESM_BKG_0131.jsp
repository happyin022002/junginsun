<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0131.jsp
*@FileTitle  : Cargo Release Order_Do List Check Report
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0131Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg0131Event  event = null;                    //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;            //error from server
    String strErrMsg = "";                        //error message
    int rowCount     = 0;                        //count of DB resultSET list
    
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    Logger log = Logger.getLogger("com.clt.apps.InboundBLMgtSC.FullReleaseOrderBC");
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id =    account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
       
       
        event = (EsmBkg0131Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        
        // get data from server when load page ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<script type="text/javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if
        
        $('<button type="button" class="btn_accent" name="btn_Retrieve"	id="btn_Retrieve">Retrieve</button>').appendTo("#btnArea");
        $('<button type="button" class="btn_normal" name="btn_DownExcel"  	id="btn_DownExcel">Down-Excel</button>').appendTo("#btnArea");
        $('<button type="button" class="btn_normal" name="btn_CargoRelease"   id="btn_CargoRelease">Cargo Release</button>').appendTo("#btnArea");
        $('<button type="button" class="btn_normal" name="btn_Print"   id="btn_Print">Print</button>').appendTo("#btnArea");
        
        loadPage();
    }
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows" value="<%=pageRows %>">
<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp" %>
  
  	<!-- opus_design_inquiry(S) -->  	
	<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
	    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <table>
	        <colgroup>
	            <col width="105px" />
	            <col width="210px" />
	            <col width="10px" />
	            
	            <col width="325px" />
	            <col width="10px" />
	            
	            
	            <col width="180px" />
	            <col width="" />
	        </colgroup>
	        <tbody>
				<tr class="h23">
					<th><input type="radio" value="F" class="trans" name="rd_flag" >Release Date</th>
					<td  class="bg" style="height:25px;background-color: #E9E9E9;padding-left:10">
						<table>
					        <colgroup>
					            <col width="110px" />
					            <col width="20px" />
					            <col width="30px" />
					            <col width="30px" />
					            <col width="30px" />
					        </colgroup>
							<tbody>
								<tr class="h23">
									<td>
										<input type="text" style="width:80px" class="input1" name="evnt_dt_fm" dataformat="ymd" 
				                           maxlength="10" caption="Release Date From" 
				                           cofield="evnt_dt_to" required="true" style="width:100;ime-mode:disabled" />&nbsp;~
				                    	<input type="text" style="width:80px" class="input1" name="evnt_dt_to" dataformat="ymd" 
				                           maxlength="10" caption="Release Date To" 
				                           cofield="evnt_dt_fm" required="true" style="width:100;ime-mode:disabled" />
				                    	<button type="button" id="btn_evnt_dt" name="btn_evnt_dt" class="calendar ir"></button>
									</td>
									<th>OFC</th>
									<td><input type="text" style="width:50px;" class="input" name="evnt_ofc_cd" caption="OFC" 
					                          minlength="5" maxlength="6" style="ime-mode:disabled" dataformat="engup"></td>
									<th>ID</th>
									<td><input type="text" style="width:50px;" class="input" name="evnt_usr_id" caption="ID" maxlength="20" style="ime-mode:disabled" dataformat="engup"></td>
								</tr>
							</tbody>
						</table>
					</td>
					<td></td>
					
					<td  class="bg" style="height:25px;background-color: #E9E9E9;padding-left:10">
						<table>
					        <colgroup>
					            <col width="50px" />
					            <col width="100px" />
					            <col width="30px" />
					            <col width="75px" />
					            <col width="25px" />
					            <col width="75px" />
					        </colgroup>
							<tbody>
								<tr class="h23">
									<td>
										<input type="radio" value="T" class="trans" name="rd_flag" checked="true">VVD
									</td>
									<td>
										<input type="text" style="width:90px" class="input1" name="vvd" caption="VVD" 
					                         minlength="9" maxlength="9" fullfill="true" style="ime-mode:disabled" dataformat="engup">
					                  <input type="hidden" name="vsl_cd" />
					                  <input type="hidden" name="skd_voy_no" />
					                  <input type="hidden" name="skd_dir_cd" />
									</td>
									<td>POD</td>
									<td>
					                  <input type="text" style="width:55px" class="input1" name="pod_cd" caption="POD" maxlength="5" fullfill="true" dataformat="engup"
					                         style="ime-mode:disabled" />
					                </td>
					                <td>DEL</td>
					                <td>
					                  <input type="text" style="width:50px" class="input" name="del_cd" cpation="DEL" 
					                   minlength="5" maxlength="5" fullfill="true" style="ime-mode:disabled"  dataformat="engup">
					                </td>
								</tr>
							</tbody>
						</table>
					</td>
					<td></td>
					
					<td  class="bg" style="height:25px;background-color: #E9E9E9;padding-left:10">
						<table>
					        <colgroup>
					            <col width="80px" />
					            <col width="" />
					        </colgroup>
							<tbody>
								<tr class="h23">
									<td><input type="radio" value="S" class="trans" name="rd_flag" >B/L No.</td>
					                  <td>
					                    <input type="text" style="width:95px;" class="input1" name="bl_no" caption="B/L No." 
					                           maxlength="12" style="ime-mode:disabled" dataformat="engup">
					                  </td>
								</tr>
							</tbody>
						</table>
					</td>
					
					
					<td></td>
				</tr>
			</tbody>
		</table>
	    <!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	</div>
	<!-- opus_design_inquiry(E) -->
	
    <!-- opus_design_grid(S) -->
    <div class="wrap_result">
	<div class="opus_design_grid">
	    
	    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script type="text/javascript">ComSheetObject('sheet1');</script>
	    <script type="text/javascript">ComSheetObject('sheet2');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	</div>
	<!-- opus_design_grid(E) -->

</form> 