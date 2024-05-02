<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_BKG_0192.jsp
*@FileTitle  : B/L CUSTOMER
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/29
 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg0192Event"%>	
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0192Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //error from server
	String strErrMsg = ""; //error message
	int rowCount = 0; //count of DB resultSET list

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	boolean bBtn_Disabled = true;
	Logger log = Logger
			.getLogger("com.clt.apps.CustomsDeclaration.CndManifestListDownload");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0192Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request
				.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
  String cust_cnt_cd = JSPUtil.getNull(request.getParameter("cust_cnt_cd")); 
  String cust_seq    = JSPUtil.getNull(request.getParameter("cust_seq")); 
  String cust_nm     = JSPUtil.getNull(request.getParameter("cust_nm")); 
  String cust_addr   = JSPUtil.getNull(request.getParameter("cust_addr")); 
  String cty_nm      = JSPUtil.getNull(request.getParameter("cty_nm")); 
  String ste_cd      = JSPUtil.getNull(request.getParameter("ste_cd")); 
  String zip_cd      = JSPUtil.getNull(request.getParameter("zip_cd")); 
  String bco_type    = JSPUtil.getNull(request.getParameter("bco_type")); 
  String custFunc    = JSPUtil.getNull(request.getParameter("func")); 
  String bkg_no      = JSPUtil.getNull(request.getParameter("bkg_no")); 
  String cust_val    = JSPUtil.getNull(request.getParameter("cust_val")); 
  
  if(!cust_cnt_cd.equals("") && !cust_seq.equals("")){
	  cust_nm ="";
  }  
%>
<script  type="text/javascript">
	<%	if(!custFunc.equals("")) {%>
		var opener = window.dialogArguments;
	    if(!opener) opener= parent;  
		var callbackMethod = opener.<%= custFunc%>;
	<%} else{%>
		var callbackMethod = null; 
	<%}%>
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        // InitTab();
        loadPage();
    }
</script>
<form name="form" >
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="bco_type" value="<%=bco_type%>" id="bco_type" />
<input type="hidden" name="curr_page" value="1" id="curr_page" />
<input type="hidden" name="bkg_no" value="<%=bkg_no%>" id="bkg_no" />
<input type="hidden" name="cust_val" value="<%=cust_val%>" id="cust_val" />
<div class="layer_popup_title" >
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><span>B/L Customer</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Retrieve" 	id="btn_Retrieve">Retrieve</button><!--
			--><button type="button" class="btn_normal" name="btn_Save" 		id="btn_Save">Save</button><!--
			--><button type="button" class="btn_normal" name="btn_Select" 		id="btn_Select">Select</button><!--
			--><button type="button" class="btn_normal" name="btn_Close"  		id="btn_Close">Close</button>	
		</div>
		<!-- opus_design_btn(E) -->
		<!-- page_location(E) -->
	</div>
	<!-- page_title_area(E) -->
</div>

<div class="layer_popup_contents" style="overflow:hidden;">
	<!-- opus_design_inquiry(S) -->
	<div class= "wrap_search">
		<div class= "opus_design_inquiry wFit">
			<table>
				<tbody>
					<colgroup>
						<col width="50"/>
						<col width="100"/>
						<col width="80"/>
						<col width="10"/>
						<col width="80"/>
						<col width="10"/>
						<col width="80"/>
						<col width="10"/>
						<col width="80"/>
						<col width="100"/>
						<col width="80"/>
						<col width="*"/>
				    </colgroup>
					<tr>
						<th>Code</th>
						<td><input type="text" style="width:25px;" class="input1" name="cust_cnt_cd" dataformat="engup" maxlength="2" value="<%=cust_cnt_cd%>" id="cust_cnt_cd" /><!-- 
						 --><input type="text" style="width:50px;" class="input" name="cust_seq" dataformat="num" maxlength="6" value="<%=cust_seq %>" id="cust_seq" /></td>
						<th>Name</th>
						<td><input type="text" style="width:80px;" class="input" name="cust_nm" maxlength="100" value="<%=cust_nm%>" id="cust_nm" /> </td>
						<th>Address</th>
						<td><input type="text" style="width:80px;" class="input" name="cust_addr" maxlength="200" value="<%=cust_addr%>" id="cust_addr" /> </td>
						<th>City</th>
						<td><input type="text" style="width:80px;" class="input" name="cty_nm" maxlength="50" value="<%=cty_nm%>" id="cty_nm" /> </td>
						<th>State</th>
						<td><input type="text" style="width:70px;" class="input" name="ste_cd" dataformat="engup" maxlength="3" value="<%=ste_cd%>" id="ste_cd" /> </td>
						<th>Zip Code</th>
						<td><input type="text" style="width:60px;" class="input" name="zip_cd" dataformat="engup" maxlength="10" value="<%=zip_cd%>" id="zip_cd" /> </td>
					</tr>	
				</tbody>
			</table>
		</div>
	</div>
	<!-- opus_design_inquiry(E) -->
	<!-- opus_design_grid(S) -->
	<div class="wrap_result">
		<div class="opus_design_grid clear" >
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		
		<div class="opus_design_grid clear" >
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_RowAdd" id="btn_RowAdd">Row Add</button><!--
				--><button type="button" class="btn_normal" name="btn_RowDelete" 	id="btn_RowDelete">Row Delete</button><!-- 
				--><button type="button" class="btn_normal" name="btn_Copy" 	id="btn_Copy">Copy from MDM</button>
			</div>
			<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>

 <SCRIPT  type="text/javascript">
	sheetObj = sheetObjects[1];
 </script>
 