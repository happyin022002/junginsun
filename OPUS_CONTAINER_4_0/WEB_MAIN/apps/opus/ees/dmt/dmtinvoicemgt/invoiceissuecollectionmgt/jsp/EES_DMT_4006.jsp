<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_DMT_4006.jsp
*@FileTitle  : Manual Invoice Report by Office
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/22
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt4006Event"%>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EesDmt4006Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //count of DB ResultSet list
    
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String strUsr_of        = "";
    String strRhq_ofc_cd    = "";
    Logger log = Logger.getLogger("com.clt.apps.DMTInvoiceMgt.InvoiceIssueCollectionMgt");
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strUsr_of = account.getOfc_cd();
        strRhq_ofc_cd = account.getRhq_ofc_cd();

        event = (EesDmt4006Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        
        // in loading page, Get data from server.
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

        
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

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="h_user_office"  value="<%= strUsr_of %>"  >
<input type="hidden" name="usr_rhq_ofc_cd" value="<%=strRhq_ofc_cd%>">

<input type="hidden" name="ofc_cd">
<input type="hidden" name="tmp_ofc_cd">

<input type="hidden" name="start_dt">
<input type="hidden" name="end_dt">

<input type="hidden" name="ofc_flg">
<input type="hidden" name="usr_ofc_cd" value="<%= strUsr_of %>">
<input type="hidden" name="head_office"	value="<%=ConstantMgr.getHeadOfficeCode()%>"><!-- HEAD OFFICE -->

	<!-- page_title_area(S) -->
	<div class="page_title_area clear ">
		<!-- page_title(S) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button>
		</h2>
		<!-- page_title(E) -->
	
		    <!-- opus_design_btn(S) -->
		    <div class="opus_design_btn">
		        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
				<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button>
				<button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button>
				<button type="button" class="btn_normal" name="btn_minimize" id="btn_minimize">Minimize</button>
				<button type="button" class="btn_normal" name="btn_detatil" id="btn_detatil">Detail</button>
				<button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>						
		    </div>
		    <!-- opus_design_btn(E) -->
	    
		<!-- page_location(S) -->
		<div class="location">
			<!-- location 내용 동적생성 (별도 코딩 불필요) -->
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->
	
	</div>
	<!-- page_title_area(E) -->
	
	<div class="wrap_search">
		<div class="opus_design_inquiry" id="sch_cond_div" style="display:block">
	        <table> 
	            <colgroup>
	                <col width="87px" />
	                <col width="400px" />
	                 <col width="50px" />
	                <col width="60px" />
	                <col width="85px" />
	                <col width="" />
	            </colgroup>
	            <tbody>
	                <tr>
	                    <th>Issued Date</th>
		                <td colspan="3">
		                	<input type="text" name="fm_dt" dataformat="ymd" style="width:80px" class="input1">~&nbsp;<!--
	                        --><input type="text" name="to_dt" dataformat="ymd" style="width:80px" class="input1" cofield="fm_dt"><!--
	                        --><button type="button" class="calendar" name="btns_calendar" id="btns_calendar"></button>	                        		                	
		                </td>
		                <td></td>
					</tr>
					<tr>
		                <th class="sm">Issue Office</th>
		                <td class="sm">
		                	<input type="radio" name="ofc_rdo_flg" id="ofc_rdo_flg_1" value="R" class="trans" onClick="ofc_rdo_flg_click()" checked><label for="ofc_rdo_flg_1">RHQ</label><!--
                            --><input type="radio" name="ofc_rdo_flg" id="ofc_rdo_flg_2" value="O" class="trans" onClick="ofc_rdo_flg_click()" ><label for="ofc_rdo_flg_2">Office</label><!--
                            --><script language="javascript">ComComboObject('office',1,80,0,1,0,true);</script><!--
                            --><button type="button" class="multiple_inq"></button><!--                            
                            --><input type="checkbox" name="chk_sub_ofc" value="Y" onClick="doInclSubOfc()"  class="trans">&nbsp;Incl. Sub Office		                	
		                </td>
		                 <th></th>
		                <th>Group by</th>
		                <td>
		                	<select style="width:85px;" class="input" name="grpbyor">
                                <option value="0" selected>Office</option>
                                <option value="1">RHQ</option>
                            </select>
		                </td>
		                <td></td>
					</tr>
					<tr>
						<th>Reason</th>
						<td colspan="3">
							<script language="javascript">ComComboObject('reasoncd',2,300,0,1,0,true);</script>
						</td>						
		                <td></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid " id="mainTable" >										
		<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
			<script language="javascript">ComSheetObject('sheet1');</script>
		<!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->					
		</div>
		<!-- opus_design_grid(E) -->
	</div>
</form>
