<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_1605.jsp
*@FileTitle  : EU DG SAVE History
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.event.EsmBkg1605Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1605Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//Error message

	Logger log = Logger.getLogger("com.clt.apps.TerminalDocumentation.SpecialManifest");

	try {

		event = (EsmBkg1605Event)request.getAttribute("Event");
		GeneralEventResponse eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}

	  String blNo = (StringUtil.xssFilter(request.getParameter("blNo")) == null)? "": StringUtil.xssFilter(request.getParameter("blNo"));
	  String cntrNo = (StringUtil.xssFilter(request.getParameter("cntrNo")) == null)? "": StringUtil.xssFilter(request.getParameter("cntrNo"));
	  String portCd = (StringUtil.xssFilter(request.getParameter("portCd")) == null)? "": StringUtil.xssFilter(request.getParameter("portCd"));
	  String vvdCd = (StringUtil.xssFilter(request.getParameter("vvdCd")) == null)? "": StringUtil.xssFilter(request.getParameter("vvdCd"));
	  String originPgm = (StringUtil.xssFilter(request.getParameter("originPgm")) == null)? "": StringUtil.xssFilter(request.getParameter("originPgm"));
	  String dType = (StringUtil.xssFilter(request.getParameter("dType")) == null)? "": StringUtil.xssFilter(request.getParameter("dType"));
	  String polCd = (StringUtil.xssFilter(request.getParameter("polCd")) == null)? "": StringUtil.xssFilter(request.getParameter("polCd"));
	  String podCd = (StringUtil.xssFilter(request.getParameter("podCd")) == null)? "": StringUtil.xssFilter(request.getParameter("podCd"));
	  String declare1Display = "";
	  String declare2Display = "";
	  String titleAnt = "";
	  if ("ESM_BKG_0965".equals(originPgm)){
		  declare2Display = "none";
		  titleAnt = "(Antwerp)";
	  }else{
		  declare1Display = "none";
	  }
	  String declareation2 = ("ESM_BKG_0965".equals(originPgm))? "none": "";
%>
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		}
		loadPage();
	}
</script>
</head>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">


<input type="hidden" name="com_mrdPath"       value="">
<input type="hidden" name="originPgm"         value=<%=originPgm%>>
<input type="hidden" name="eur_dg_decl_tp_cd" value=<%=dType%>>

<!--
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Dangerous Cargo Detail(s) History</span></h2>
	</div>
</div>
 -->
 <div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span><%=titleAnt%>Dangerous Cargo Detail(s) History</span></h2>

		<div class="opus_design_btn"><!--
			--><button type="button" class="btn_normal" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
			--><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button><!--
		--></div>
	</div>

</div>


<div class="layer_popup_contents">
	<div class="opus_design_inquiry">
		<div style="display:<%=declare1Display%>">
			<table>
				<tbody>
					<tr>
						<th width="88" height="35">Declaration</th>
						<td >
							<input type="checkbox" name="d_type1" id="d_type1" value="D"><label for="d_type1">Discharging</label><!--
						 --><input type="checkbox" name="d_type2" id="d_type2" value="T"><label for="d_type2">Transit</label><!--
						 --><input type="checkbox" name="d_type3" id="d_type3" value="L"><label for="d_type3">Loading</label><!--
						 --><input type="checkbox" name="d_type4" id="d_type4" value="P"><label for="d_type4">Pre-carriage</label><!--
						 --><input type="checkbox" name="d_type5" id="d_type5" value="O"><label for="d_type5">On-Carriage</label><!--
						 --><input type="hidden" name="d_type_check" value="D" required caption="Declaration">
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div style="display:<%=declare2Display%>">
			<table>
				<tbody>
					<tr>
						<th width="88" height="35">Declaration</th>
						<td><!--
							 --><input type="radio" name="d_type_radio" value="D" class="trans" checked>&nbsp;Import&nbsp;&nbsp;<!--
							 --><input type="radio" name="d_type_radio" value="T" class="trans">&nbsp;Transit&nbsp;&nbsp;<!--
							 --><input type="radio" name="d_type_radio" value="L" class="trans">&nbsp;Export&nbsp;&nbsp;<!--
						 --></td>
					</tr>
				</tbody>
			</table>
		</div>


		<table>
			<tbody>
				<tr class="h23">
					<th>VVD</th>
					<td><input type="text" style="width:90px;" class="input1" name="vvd_cd" dataformat="engup" maxlength="9" value="<%=vvdCd%>" ></td>
					<th>Port</th>
					<td><input type="text" style="width:70px;" class="input1" name="port_cd" dataformat="engup" maxlength="5" value="<%=portCd%>" ></td>
					<th>B/L No.</th>
					<td><input type="text" style="width:110px;" class="input1" name="bl_no" dataformat="engup" maxlength="13" value="<%=blNo%>" ></td>
					<th>Container No.</th>
					<td><input type="text" style="width:100px;" class="input1" name="cntr_no" dataformat="engup" maxlength="11" value="<%=cntrNo%>" ></td>

				</tr>
				<tr class="h23">
					<th>POL</th>
					<td><input type="text" style="width:70px;" class="input2" name="pol_cd" value="<%=polCd%>" ></td>

					<th>POD</th>
					<td><input type="text" style="width:70px;" class="input2" name="pod_cd" value="<%=podCd%>" ></td>
				</tr>
			</tbody>
		</table>

	</div>
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>

</div>
</form>


