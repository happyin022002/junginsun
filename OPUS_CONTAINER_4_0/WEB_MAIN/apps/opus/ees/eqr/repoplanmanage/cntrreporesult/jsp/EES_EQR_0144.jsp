<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : EES_EQR_0144.jsp
*@FileTitle : Empty Repo Result
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/01
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.eqr.repoplanmanage.cntrreporesult.event.EesEqr0144Event"%>
<%@ page import="com.clt.apps.opus.ees.eqr.common.eqrcommon.basic.CommonBC"%>
<%@ page import="com.clt.apps.opus.ees.eqr.common.eqrcommon.basic.CommonBCImpl"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesEqr0144Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수

	try {
		event = (EesEqr0144Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
	}catch(Exception e) {
		out.println(e.toString());
	}

	String optionStr = "000000:ALL:ALL";
	String optionStr1 = "000000: : ";

	String fmType    = JSPUtil.getCodeCombo("fmType", "", "width='55'", "CD00242", 0, optionStr);
	String toType    = JSPUtil.getCodeCombo("toType", "", "width='55'", "CD00242", 0, optionStr);

	String fmTypeBy  = JSPUtil.getCodeCombo("fmTypeBy", "E", " style='width:80;'", "CD00265", 0, "");
	String toTypeBy  = JSPUtil.getCodeCombo("toTypeBy", "E", " style='width:80;'", "CD00265", 0, "");

	//String tpsz = JSPUtil.getCodeCombo("tpsz","","onChange='javascript:tpszChange(document.form.tpsz.options[document.form.tpsz.selectedIndex].value)' style='width:55;'","CD00263",0,optionStr);
	String tpsz = JSPUtil.getCodeCombo("tpsz","","onChange='javascript:tpszChange(document.form.tpsz.options[document.form.tpsz.selectedIndex].value)' style='width:55;'","CD01527",0,optionStr);
	CommonBC tpszUtil = new CommonBCImpl(); 	//Combo BOX
%>

<script type="text/javascript">
	// mode (Truck, Rail, Water)
	<%= JSPUtil.getIBCodeCombo("item",    "01", "CD00566", 0, "")%>
	// Type Size
	<%//= JSPUtil.getIBCodeCombo("tpszall", "01", "CD00830", 0, "")%> // ALL TYPE SIZE
	<%//= JSPUtil.getIBCodeCombo("tpszdry", "01", "CD00751", 0, "")%> // DRY TYPE SIZE
	<%//= JSPUtil.getIBCodeCombo("tpszrfr", "01", "CD00752", 0, "")%> // RFR TYPE SIZE
	<%//= JSPUtil.getIBCodeCombo("tpszot",  "01", "CD00828", 0, "")%> // OT  TYPE SIZE
	<%//= JSPUtil.getIBCodeCombo("tpszfr",  "01", "CD00829", 0, "")%> // FR  TYPE SIZE

	<%= tpszUtil.getTpSzCodeCombo("eqr", "tpszall", "", "", "", "", "")%>
	<%= tpszUtil.getTpSzCodeCombo("eqr", "tpszdry", "", "D", "", "", "")%>
	<%= tpszUtil.getTpSzCodeCombo("eqr", "tpszspc", "", "S", "", "", "")%>
	<%= tpszUtil.getTpSzCodeCombo("eqr", "tpszrb", "", "R", "", "", "")%>
	
    // ------- type 변수선언 -------------- START
    var consTpsz      = replaceAll(tpszallText, "|", ",");
    var consTpszArr   = consTpsz.split(',');
    var consTpszDry   = replaceAll(tpszdryText, "|", ",");
	var consTpszSpc   = replaceAll(tpszspcText, "|", ",");
	var consTpszZrb   = replaceAll(tpszrbText, "|", ",");
    //var consTpszRfr   = replaceAll(tpszrfrText, "|", ",");
    //var consTpszOt    = replaceAll(tpszotText,  "|", ",");
    //var consTpszFr    = replaceAll(tpszfrText,  "|", ",");
    // ------- type 변수선언 -------------- END

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		// InitTab();
		loadPage();
	}
</script>

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="tpszall" value="" id="tpszall" />
<input type="hidden" name="tpcnt" value="" id="tpcnt" />
<input type="hidden" name="transmode" value="" id="transmode" />
<div class="page_title_area clear">
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->
		<!-- btn_div -->
	<div class="opus_design_btn">
	    <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
	    --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button>
	</div>
   <!-- page_location(S) -->
   <div class="location">
		<span id="navigation"></span>
   </div>
</div>
<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
         <table>
			<colgroup>
				<col width="50" />				
				<col width="80" />				
				<col width="50" />				
				<col width="61" />				
				<col width="90" />				
				<col width="100" />
				<col width="50" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
            <tr>
                <th>SO Sent Period</th>
                <td><select name="period" id="period" onChange="changeFmDateMaxLength(this);" style="width:100px;">
                   <option value="Day" selected>YYYYMMDD</option><!-- 
                    --><option value="Week" >YYYYWW</option><!-- 
                    --><option value="Month" >YYYYMM</option>
                   </select><!-- 
                 --><input name="fmdate" value="" type="text" class="input1" style="width:75px;ime-mode:disabled;text-align:center;" dataformat="num" onkeyup="moveTabNormal(this,todate);" id="fmdate" />~ <input name="todate" value="" class="input1" type="text" style="width:75px;ime-mode:disabled;;text-align:center;" dataformat="num" maxlength="8" id="todate" /></td>
                <td></td>
                <th>Mode</th>
                <td><script type="text/javascript">ComComboObject('item_code' , 1, 150, 1 )</script><input type="hidden" name="item" id="item" /></td>
                 <td></td>
                 <td></td>
                 <td></td>
             </tr>
             <tr>
                 <th>Fm LOC</th>
                 <td><%=fmType %><!-- 
                      --><input type="text" name="fmloc" id="fmloc" style="width:60px;ime-mode:disabled;text-align:center;" value="" dataformat='engup' otherchar=","><!--                      
                      --><button type="button" class="input_seach_btn" name="fmloc_btn" id="fmloc_btn"></button>
                 </td>
                 <td></td>
                 <th>To LOC</th>
                 <td  ><%=toType %><!-- 
                      --><input type="text" name="toloc" id="toloc" style="width:59px;ime-mode:disabled;text-align:center;" value="" dataformat='engup' otherchar=","><!--                      
                      --><button type="button" class="input_seach_btn" name="toloc_btn" id="toloc_btn"></button>
                 </td>
                 <th>TP/SZ</th>
                 <th><%=tpsz%></th><!-- 
                 --><td><script type="text/javascript">ComComboObject('cntrtpszcd' , 1 , 220, 1 )</script></td>
             </tr>
         </table>		
	</div>
</div>
<div class="wrap_result">
	<div class="opus_design_grid">
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>	
</div>
<iframe frameborder="0" width="0"  name="037iframe" scrolling="no" frameborder="0" width="0" height="0">
</iframe>
<iframe frameborder="0" width="0"  name="periorIframe" scrolling="no" frameborder="0" width="0" height="0"/></iframe>
</form>
