<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_0043.jsp
*@FileTitle  : Car Location Message Inquiry 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>

<%@ page import="com.clt.framework.component.util.DateTime" %>

<%
	int    rowSize = 500 ;
	String toDate  = DateTime.getFormatString("yyyy-MM-dd") ;
	String fmDate  = DateTime.addMonths(toDate, -3, "yyyy-MM-dd") ;

    String r_row_size = request.getParameter("row_size");
    String r_cntr_no  = request.getParameter("cntr_no");
	String r_toDate   = request.getParameter("arr_dt1");
	String r_fmDate   = request.getParameter("arr_dt2");
	String r_method   = request.getMethod();
	boolean getDecision = false;
	
	if(("".equals(r_toDate) || "".equals(r_fmDate) || "".equals(r_cntr_no)   || "".equals(r_row_size) ) ||
	   (r_toDate == null    || r_fmDate == null    || r_cntr_no == null      || r_row_size == null    )       
	   ){
	       getDecision  = false;
	   }else{
		   getDecision  = true;
	   }

%>

<script language="javascript">

    function setupPage(){
    	<%if(!getDecision){%>
        loadPage();
        <%}%>
    }

    function calanderSetting(){
		var cal = new ComCalendarFromTo();
	    cal.select(form.arr_dt1,  form.arr_dt2,  'yyyy-MM-dd');
	}
</script>

<%if(getDecision){%>
<body>
<%}else{%>
<body onLoad="setupPage();">
<%}%>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="row_size" value="<%=rowSize%>">
<input type="hidden" name="r_fmDate" value="<%=fmDate%>">
<input type="hidden" name="r_toDate" value="<%=toDate%>">

<!-- page(S) -->
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	
	<!-- page_title(S) -->
    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
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
	<div class="opus_design_inquiry wFit">
	    <table>
	    	<colgroup>
	            <col width="100" />
	            <col width="250" />
	            <col width="60" />
	            <col width="" />
	        </colgroup>
	        <tbody>
				<tr>
					<th>Container No.</th>
					<td>
						<input name="cntr_no" type="text" class="input" style="width:90px; text-transform:uppercase;" maxlength="14" value="" onBlur='javascript:this.value=this.value.toUpperCase();'><!--
					 --><input name="cntr_tpsz_cd" type="text" class="input" style="width:30px" readonly ></td>
					<th>Duration</th>
					<td>
						<input name="arr_dt1" type="text" dataformat="ymd"  required  onBlur='ComChkObjValid(this, false, false, true)' class="input" style="width:75px" value="<%=fmDate%>">&nbsp;~&nbsp;
						<input name="arr_dt2" type="text" dataformat="ymd"  required  onBlur='ComChkObjValid(this, false, false, true)'  class="input" style="width:75px; text-transform:uppercase;" value="<%=toDate%>"><!--
				     --><button type="button" class="calendar ir" name="btns_calendar" id="btns_calendar" onClick="calanderSetting();" style="cursor:hand"></button>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>

<div class="wrap_result">
	<div class="opus_design_grid">
	    <script language="javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
</form>
<%
    String opCode   =  "<script>" +
	                   "var r_cntr_tpsz_cd = document.forms[0].cntr_tpsz_cd.value;" + 
	                   "remoteOperation('" + r_row_size + "','" + r_cntr_no + "','" + r_toDate + "','" + r_fmDate + "');" + 
					   "</script>" ;
%>
<%if(getDecision){%>
	<%=opCode%>
<%}%>

