<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_1012.jsp
*@FileTitle : Port Inventory Balance Simulation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2013.09.17 
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.eqr.cntrfcstsimul.surplusarea.event.EesEqr1012Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EesEqr1012Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;            //서버에서 발생한 에러
    String strErrMsg = "";                        //에러메세지
    int rowCount     = 0;                        //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    
    String levelCd = "";
    String ofcCd = "";
    
    String currYrwk = "";
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id =    account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        ofcCd     = account.getOfc_cd();
        currYrwk  = DateTime.getFormatDate(new java.util.Date(), "yyyyww");

        event = (EesEqr1012Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

        levelCd   = JSPUtil.getNull(eventResponse.getETCData("level_cd"));
    }catch(Exception e) {
        out.println(e.toString());
    }
    
    String optionStr2 = "000000: :ALL";
    String cntrTpsz  = JSPUtil.getCodeCombo("cntrTpsz","","style='width:70;'","CD00263",0,optionStr2);
%>
<script language="javascript">
    parent.window.moveTo(0,0);
    parent.window.resizeTo("1600","900");
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
<input type="hidden" name="level_cd" value="<%= levelCd %>">
<input type="hidden" name="ofc_cd" value="<%= ofcCd %>">

<input type="hidden" name="curr_yrwk" value="<%= currYrwk %>">
<input type="hidden" name="loc_chk" value="">


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
	    --><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!-- 
	    --><button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button><!-- 
	    --><button type="button" class="btn_normal" name="btn_downExcel" id="btn_downExcel">Down Excel</button>
		</div>
		<!-- opus_design_btn(E) -->	
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
</div>
<!-- page_location(E) -->




	<!-- TAB  -->
	<div class="opus_design_inquiry">
		<!-- no TAB  -->
		<table>
			<colgroup>
				<col width="40px" />
				<col width="90px" />
				<col width="50px" />
				<col width="90px" />
				<col width="40px" />
				<col width="90px" />
				<col width="85px" />
				<col width="90px" />
				<col width="119px" />
				<col width="300px" />
			</colgroup>
			<tbody>
				<tr>
					<th>Trade</th>
                    <td><script language="javascript">ComComboObject('trade' , 2, 70, 0, 1 )</script></td>
                    <th>S.Trade</th>
                    <td><script language="javascript">ComComboObject('subtrade' , 4, 90, 0, 1 )</script></td>
                    <th>Lane</th>
                    <td><script language="javascript">ComComboObject('lane' , 5, 70, 0, 0 )</script></td>
                    <th>POL Location</th>
                    <td><script language="javascript">ComComboObject('subconti' , 2, 70, 0, 1)</script></td>
                    
                    <th>Inventory Include</th>
                    <td>
                    <table border="0" style="width:300px;" class="search_sm2"> 
                        <tr class="h23">
                            <th width="50px">Damage</th>
                            <td width="50px"><select style="width:70px;" name="chk_im" class="input">
                                           <option value="Y" selected>Y</option>
                                           <option value="N" >N</option>
                                           </select></td>
                            <th width="50px">Disposal</th>
                            <td width="50px"><select style="width:70px;" name="chk_id" class="input">
                                           <option value="Y">Y</option>
                                           <option value="N" selected>N</option>
                                           </select></td>
                            <th width="50px">&nbsp;&nbsp;SOC</th>
                            <td width="50px"><select style="width:70px;" name="chk_is" class="input">
                                           <option value="Y" >Y</option>
                                           <option value="N" selected>N</option>
                                           </select></td>                              
                        </tr>
                    </table>
                    </td>
                    <td width=""></td>
				</tr>
			</tbody>
		</table>
		
		
		<table>
			<colgroup>
				<col width="40px" />
				<col width="90px" />
				<col width="140px" />
				<col width="5px" />
				<col width="175px" />
				<col width="120px" />
				<col width="412px" />
			</colgroup>
			<tbody>
				<tr>
					<th>TP/SZ</th>
                    <td width="80"><%= cntrTpsz %></td>
                    <td width="140">&nbsp;<script language="javascript">ComComboObject('tpsztype' , 1, 127, 1 )</script></td>
                    <td width="5"></td>
                    <th><input type="checkbox" name="show_history" class="trans" OnClick="showHistory();" >Past 3 weeks history&nbsp;&nbsp;</th>
                    <th><input type="checkbox" name="show_detail" class="trans" OnClick="showDetail();" >Show Detail&nbsp;&nbsp;</th>
                    
                    <td width="412"></td>
                   </tr>
			</tbody>
		</table>
	</div>
	<!-- inquiry_area(E) -->


	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script language="javascript">ComSheetObject('sheet1');</script>
		<!-- opus_grid_design_btn(E) -->
	</div>
	<!-- opus_design_grid(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script language="javascript">ComSheetObject('sheet2');</script>
		<!-- opus_grid_design_btn(E) -->
	</div>
	<!-- opus_design_grid(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script language="javascript">ComSheetObject('sheet3');</script>
		<!-- opus_grid_design_btn(E) -->
	</div>
	<!-- opus_design_grid(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script language="javascript">ComSheetObject('sheet4');</script>
		<!-- opus_grid_design_btn(E) -->
	</div>
	<!-- opus_design_grid(E) -->

<!-- 개발자 작업    -->

</form>