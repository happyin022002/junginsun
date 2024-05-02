<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_1022.jsp
*@FileTitle : MTY Repo Inquiry by VVD
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.event.EesEqr1022Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EesEqr1022Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         
    String strErrMsg = "";                      
    int rowCount     = 0;                       //DB ResultSet 

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();


        event = (EesEqr1022Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<script language="javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }
    
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="version">


<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!--
		--><button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
	    --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
	    --><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
		</div>
		<!-- opus_design_btn(E) -->	
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
</div>
<!-- page_location(E) -->



<!-- 검색영역 -->
<div class= "wrap_search">
	<div class= "opus_design_inquiry wFit">
		<table>
			<colgroup>
		  		<col width="35px"></col>
		  		<col width="160px"></col>
		  		<col width="35px"></col>
		  		<col width="100px"></col>
		  		<col width="25px"></col>
		  		<col width="100px"></col>
		  		<col width="260px"></col>
		  		<col width="74px"></col>
		  		<col width="*"></col>	  		
		  	</colgroup>
			<tbody>			
				<tr>
					<th title="Vessel Voyage Direction">VVD</th>
					<td>
						<input type="text" name="vvd" id="vvd" style="width:80;ime-mode:disabled" class="input1" value="" dataformat="engup" maxlength="9">
						<button type="button" class="input_seach_btn" name="btn_vvd"></button>
					</td>		
					<th>Lane</th>
					<td>
						<input type="text" name="lane" id="lane" style="width:35;" class="input2" value=""  readonly>
					</td>
					<th>Bay</th>
					<td>
						<input type="text" name="bay" id="bay" style="width:45;" class="input2" value="" readonly>
					</td>	
					<td></td>		
					<th>Created by</th>
					<td>
						<input type="text" name="user" id="user" style="width:55;" class="input2" value="<%= strUsr_id %>" readonly>
					</td>						
				</tr>					
			</tbody>
		</table>
	</div>
</div>
<!-- 검색영역 -->

<!-- 시트영역 -->
<div class="wrap_result">
	<div class="opus_design_grid">	
		<div class="opus_design_btn">
			<button type="button" class="btn_normal"  onclick="javascript:popHRBTN();" id="HRTEXT"></button>
			<button type="button" class="btn_normal"  onclick="javascript:popRMBTN();" id="RMTEXT"></button>
			<button type="button" class="btn_normal"  onclick="javascript:popDMBTN();" id="DMTEXT"></button>
		</div>
		
                    
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	
	<div class="opus_design_grid">	
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	
	<div class="opus_design_grid">	
		<script type="text/javascript">ComSheetObject('sheet3');</script>
	</div>
	
	<!-- data_area(S) -->
	<div class="opus_design_data">
		<table width="100%" class="grid2"> 
            <tr class="tr2_head">
                <td width="15%" align="center"><b>Remark(s)</b></td>         
                <td width="">
                <textarea  name="remark" style="width:100%;height:50px;"></textarea>
                </td>
            </tr>
        </table> 
	</div>
	<!-- data_area(E) -->
</div>
<!-- 시트영역 -->

</form>