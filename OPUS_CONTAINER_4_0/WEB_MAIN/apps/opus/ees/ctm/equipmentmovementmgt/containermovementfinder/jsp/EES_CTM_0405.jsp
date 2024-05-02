<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ees_ctm_0405.jsp
*@FileTitle : Empty VL List without BKG
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/21
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.event.EesCtm0405Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EesCtm0405Event event = null;        //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //error from server
  String strErrMsg = "";               //error message
  int rowCount = 0;                    //DB ResultSet list count

  String successFlag = "";
  String codeList = "";
  String pageRows = "100";

  String strUsr_id = "";
  String strUsr_nm = "";
  Logger log = Logger.getLogger("com.clt.apps.EquipmentMovementMgt.ContainerMovementMasterDataMgt");

  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();

    event = (EesCtm0405Event)request.getAttribute("Event");
    serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

    if (serverException != null) {
      strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
    }

    
    GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

  } catch(Exception e) {
    out.println(e.toString());
  }


  // current date
  String pDate2 = DateTime.getFormatDate(new java.util.Date(), "yyyy-MM-dd");
  // the date before 1 month
  String pDate1 = DateTime.addMonths(pDate2, -1, "yyyy-MM-dd");
%>

<script type="text/javascript">
  function setupPage() {
    var errMessage = "<%=strErrMsg%>";
    if (errMessage.length >= 1) {
      showErrMessage(errMessage);
    } // end if
    loadPage();
  }
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- developer job -->

<!-- 제목 -->
<div class="page_title_area clear">
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->

		<!-- btn_div -->
	<div class="opus_design_btn">
	    <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
	     --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
	     --><button type="button" class="btn_normal" name="btn_delete" id="btn_delete">Delete</button><!--
	     --><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
	</div>

   <!-- page_location(S) -->
   <div class="location">
		<span id="navigation"></span>
   </div>
</div>
<!-- 제목 -->

<!-- 검색영역 -->
<div class="wrap_search">
<div class="opus_design_inquiry">		
	<table class="search" border="0" style="width:979px;">
		<colgroup>
			<col width="30px" />
			<col width="80px" />
			<col width="80px" />
			<col width="60px" />
			<col width="70px" />
			<col width="100px" />
			<col width="100px" />	
			<col width="150px" />
			<col width="80px" />	
			<col width="150px" />								
			<col width="*" />
			<col />
		</colgroup>
        <tr class="h23">
        	<th>
				RCC
			</th>
          	<!--<td>
          		<input type="text" style="width:50px;" class="input" maxlength="5" style="ime-mode:disabled;" tabindex="1" id="rcc_cd" name="rcc_cd" dataformat ="engup">
          	</td>-->
          	<td>
          		<script language="javascript">ComComboObject('rcc_cd', 1, 70, 1, 0, 0, 0, 3)</script>
          	</td>
          	<th>
				LCC
			</th>
          	<td>
          		<input type="text" style="width:50px;" class="input" maxlength="5" style="ime-mode:disabled;" tabindex="1" id="lcc_cd" name="lcc_cd" dataformat ="engup">
          	</td>
          	<th> 
          		Yard
          	</th>
          	<td style="padding-top:1;">
          		<input type="text" style="width:55px;text-align:center;" class="input" maxlength="5" style="ime-mode:disabled;" tabindex="2" id="yd_cd_disp" name="yd_cd_disp" dataformat ="engup">
                <input type="hidden" name="p_yard1">
            </td>
            <td>
				<script type="text/javascript">ComComboObject("p_yard2", 2, 50, 0, 0, 0, 0, 3)</script>
			</td>
          	<th> 
          		Duration
          	</th>
          	<td>
	          		<input style="width:75px;ime-mode:disabled;" maxlength="8" class="input1" value="<%=pDate1%>" id="p_date1" name="p_date1" >~
	                <input style="width:75px;ime-mode:disabled;" maxlength="8" class="input1" value="<%=pDate2%>" id="p_date2" name="p_date2"><!--
	             --><button type="button" class="calendar ir" name="btn_Calendar" id="btn_Calendar"></button>
            </td>
            <th>VVD Code</th>
                <td><input type="text" style="width:80px;" class="input" tabindex="5" dataformat="engup" maxlength="9" name="vvd_cd"></td>
	        <th>
				Call Sign/Lloyd 
			</th>
          	<td>
          		<input type="text" style="width:90px;" class="input" style="ime-mode:disabled;" tabindex="6" id="lloyd_no" name="lloyd_no" dataformat ="engup">
          	</td>
<!-- 20160518 Updated by Jun Kato (No records from OSCAR)
         	<th>
				Kind
			</th>
          	<td>
          		<select name="kind_flg" id="kind_flg"  caption="Kind Flag" style="width:75px;">
					<option value="">ALL</option> 
					<option value="OPUS" selected>OPUS</option> 
					<option value="OSCAR">OSCAR</option> 
				</select>
          	</td>			-->
        </tr>
    </table>
</div>
<!-- 검색영역 -->
</div>
<!-- 시트영역 -->
<div class="wrap_result">
<div class="opus_design_grid">
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>

<!-- 시트영역 -->
</div>
</form>
