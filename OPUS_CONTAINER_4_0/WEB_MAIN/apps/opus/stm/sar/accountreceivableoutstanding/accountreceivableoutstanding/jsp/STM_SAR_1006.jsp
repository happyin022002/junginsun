<%--/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : STM_SAR_1006.jsp
*@FileTitle  : Payment Request Letter by Customer
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================*/--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.event.StmSar1006Event"%> 
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List"%>
<%@ page import="com.clt.bizcommon.util.BizComUtil"%>
<%@ page import="java.text.DecimalFormat"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>

<%
    StmSar1006Event event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	String cust_code = "";
	String cust_name = "";
	String cust_nm = "";
	String rct_cust_cnt_cd = "";
	String rct_cust_seq = "";
	String usdcurrcd = "";
	String usd_ttl_amt = "";
	String usd_count = "";
	String localcurrcd = "";
	String local_ttl_amt = "";
	String local_count = "";
	String eml_seq = "";
	String email = "";
	String fax = "";
	String ots_smry_cd = "";
	String strUsr_id = "";
	String strUsr_nm = "";
	String strUsr_ofc = "";
	String ar_ofc_cd = "";
	String rhq_cd = ""; 
	String cnsd_cust_flg = "N";
	Logger log = Logger.getLogger("com.clt.apps.opus.stm.sar.accountreceivableoutstanding.AccountReceivableOutstandingSC"); //수정
	String asofDt = JSPUtil.getKST("yyyy-MM-dd");
	try {
		/*
		꼭 유저의 정보를 받을 필요는 없습니다. 화면에서 유저의 이름이나 
		권한같은 정보를 이용할 필요가 있을 경우에만 사용하면 됩니다.
		덧붙여 USER 정보에 대해서 한마디로 정리하면 user 의 정보를 이용할수 있는 곳은 jsp 와 command 입니다.
		jsp에서는 유저의 정보를 가지고 권한에 따른 버튼 처리등을 할수가 있는 것이고 (enable/disable)
		command에서는 역시 유저의 정보로 예를 들어 update 권한등이 있는지를 확인할 수가 있는 것입니다.
			 
		주의> 사용자 테이블이 변경됨에 따라 변경 될 것입니다.
			SignOnUserAccount 의 메서드를 확인 하십시오.
			getAuth 메서드는 현재 미정이지만 권한 관련 value를 가져올 메서드가 있겠죠? 
	     */
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();
		/* 
		일단 화면에서 USER가 입력한 정보를 다시 화면에서 사용해야 하는 경우 
		request에 담아 서버로 전송시켰다가 다시 그 request에서 받아야 한다고 했습니다.
		이때 유저가 작성한 자료는 event 에 서버로부터 전송된 자료는 eventResponse에 담기게 됩니다.
		이렇게 받은 정보는 jsp 맨 하단에 있는 java script로부터 폼의 value로 값을 전달하게 됩니다.
		본 jsp소스 맨 하단을 참조하십시오.
		*/
		
		event = (StmSar1006Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		cust_code = StringUtil.xssFilter(request.getParameter("cust_code"));
		cust_code = cust_code==null?"":cust_code;
		
		rct_cust_cnt_cd = cust_code.substring(0, 2);
		rct_cust_seq = cust_code.substring(2, 8);
		
		cust_name = StringUtil.xssFilter(request.getParameter("cust_name"));
		cust_name = cust_name==null?"":cust_name;
		cust_nm = cust_name;
		
		if(StringUtil.xssFilter(request.getParameter("firstCurrCd")) == "USD"){
			usdcurrcd = StringUtil.xssFilter(request.getParameter("firstCurrCd"));
			usdcurrcd = usdcurrcd==null?"":usdcurrcd;
			
			usd_ttl_amt = StringUtil.xssFilter(request.getParameter("first_ttl_amt"));
			usd_ttl_amt = usd_ttl_amt==null?"":usd_ttl_amt;
			
			usd_count = StringUtil.xssFilter(request.getParameter("first_count"));
			usd_count = usd_count==null?"":usd_count;
			
			localcurrcd = StringUtil.xssFilter(request.getParameter("secondCurrCd"));
			localcurrcd = localcurrcd==null?"LOCAL":localcurrcd;
			
			local_ttl_amt = StringUtil.xssFilter(request.getParameter("second_ttl_amt"));
			local_ttl_amt = local_ttl_amt==null?"":local_ttl_amt;
			
			local_count = StringUtil.xssFilter(request.getParameter("second_count"));
			local_count = local_count==null?"":local_count;
		} else {
			localcurrcd = StringUtil.xssFilter(request.getParameter("firstCurrCd"));
			localcurrcd = localcurrcd==null?"LOCAL":localcurrcd; 
			
			local_ttl_amt = StringUtil.xssFilter(request.getParameter("first_ttl_amt"));
			local_ttl_amt = local_ttl_amt==null?"":local_ttl_amt;
			
			local_count = StringUtil.xssFilter(request.getParameter("first_count"));
			local_count = local_count==null?"":local_count;
			
			usdcurrcd = StringUtil.xssFilter(request.getParameter("secondCurrCd"));
			usdcurrcd = usdcurrcd==null?"":usdcurrcd;
			
			usd_ttl_amt = StringUtil.xssFilter(request.getParameter("second_ttl_amt"));
			usd_ttl_amt = usd_ttl_amt==null?"":usd_ttl_amt;
			
			usd_count = StringUtil.xssFilter(request.getParameter("second_count"));
			usd_count = usd_count==null?"":usd_count; 
		}
				 
	    DecimalFormat df = new DecimalFormat("#,##0.00");
	    local_ttl_amt = local_ttl_amt.replaceAll(",", "");
	    usd_ttl_amt = usd_ttl_amt.replaceAll(",", "");
	    local_ttl_amt = df.format(Float.parseFloat(local_ttl_amt));  
	    usd_ttl_amt = df.format(Float.parseFloat(usd_ttl_amt)); 
	    DecimalFormat df2 = new DecimalFormat("#,##0");
	    local_count = local_count.replaceAll(",", "");
	    usd_count = usd_count.replaceAll(",", "");
	    local_count = df2.format(Integer.parseInt(local_count));  
	    usd_count = df2.format(Integer.parseInt(usd_count));
		
		eml_seq = StringUtil.xssFilter(request.getParameter("eml_seq"));
		eml_seq = eml_seq==null?"":eml_seq;
		
		email = StringUtil.xssFilter(request.getParameter("email"));
		email = email==null?"":email;
		
		fax = StringUtil.xssFilter(request.getParameter("fax"));
		fax = fax==null?"":fax;
		
		ots_smry_cd = StringUtil.xssFilter(request.getParameter("ots_smry_cd"));
		ots_smry_cd = ots_smry_cd==null?"":ots_smry_cd;
		
		ar_ofc_cd = StringUtil.xssFilter(request.getParameter("ar_ofc_cd"));
		ar_ofc_cd = ar_ofc_cd==null?"":ar_ofc_cd;
		
		cnsd_cust_flg = StringUtil.xssFilter(request.getParameter("cnsd_cust_flg"));
		cnsd_cust_flg = cnsd_cust_flg==null?"N":cnsd_cust_flg;
		
		rhq_cd = StringUtil.xssFilter(request.getParameter("rhq_cd"));
		rhq_cd = rhq_cd==null?"":rhq_cd;
		
		/* 
		아래부분은 꼭 지켜주셔야 에러메세지가 정상적으로 전달이 됩니다. 
		보시다시피 먼저 에러를 받고 에러가 아닐시에 EventResponse로 값을 전달하셔야 합니다. 
		*/
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
				
	} catch(Exception ex) {
		log.error("err " + ex.toString(), ex);
		//out.println(e.toString());
	}
%>
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="ar_ofc_cd" id="ar_ofc_cd" value="<%=ar_ofc_cd%>"/>
<input type="hidden" name="cust_cnt_cd" id="cust_cnt_cd" />
<input type="hidden" name="cust_seq" id="cust_seq" />
<input type="hidden" name="rhq_cd" id="rhq_cd" />
<input type="hidden" name="ots_smry_cd" id="ots_smry_cd" value="<%=ots_smry_cd%>">
<input type="hidden" name="com_mrdPath" value="" id="com_mrdPath" />
<input type="hidden" name="com_mrdArguments" value="" id="com_mrdArguments" />
<input type="hidden" name="com_mrdBodyTitle" value="" id="com_mrdBodyTitle" />
<input type="hidden" name="eml_seq" value="<%=eml_seq%>" id="eml_seq" />
<input type="hidden" name="cnsd_cust_flg" value="<%=cnsd_cust_flg%>" id="cnsd_cust_flg" />
<input type="hidden" name="rd_name">
<input type="hidden" name="state">
<div class="layer_popup_title">
		<!-- page_title_area(S) -->
		<div class="page_title_area clear">
		   <!-- page_title(S) -->
			<h2 class="page_title"><span>Payment Request Letter by Customer</span></h2>
			<!-- page_title(E) -->
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_print" 	id="btn_print">Print</button><!--
				--><button type="button" class="btn_accent" name="btn_send" id="btn_send">Send</button>	 
				<button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
			</div>
			<!-- opus_design_btn(E) -->
		</div>
		<!-- page_title_area(E) -->
</div>
<div class="layer_popup_contents">		
	<!-- opus_design_inquiry(S) -->
	<div class= "wrap_search">
		<div class= "opus_design_inquiry wFit">
			<table>
					<colgroup>
						<col width="100"/>
						<col width="180"/>
						<col width="100"/>
						<col width="*"/>
				    </colgroup>
				    <tbody>
					<tr>
						<th>Customer Code</th>
		                <td><input name="cust_code" type="text" style="width:100px;" class="input2" value="<%=cust_code%>" readonly id="cust_code" /> </td>
		               	<th>Customer Name</th>
		                <td><input name="cust_name" type="text" style="width:307px;" class="input2" value="<%=cust_name%>" readonly id="cust_name" /> </td>
					</tr>
					<tr>
						<th>Send Type </th>
		                <td><select name="send_type" id="send_type" class="input2" style="width:100px;"><option value="ALL">ALL</option><option value="EMAIL" selected>E-MAIL</option><option value="FAX">FAX</option></select></td>
		                <th>Recipient </th>
		                <td> <input type="text" style="width:30px;" class="input" name="rct_cust_cnt_cd" maxlength="2" dataformat="engup" value="<%=rct_cust_cnt_cd%>" id="rct_cust_cnt_cd" />
		                <input type="text" style="width:62px;" class="input" name="rct_cust_seq" maxlength="6" dataformat="num" value="<%=rct_cust_seq%>" id="rct_cust_seq" />
		                <button type="button" id="btn_pop_credit_cust" name="btn_pop_credit_cust" class="input_seach_btn"></button>
		                <input type="text" style="width:178px;" class="input2" name="cust_nm" readonly tabindex="-1" value="<%=cust_nm%>" id="cust_nm" /> 
		                <button type="button" id="btn_pop_cust_cd" name="btn_pop_cust_cd" class="input_seach_btn"></button>
		                </td>
					</tr>	
					<tr>
						<th>FAX</th>
                 		<td><input name="fax" type="text" style="width:100px;" class="input2" value="<%=fax%>" readonly id="fax" /> </td>
                 		<th>E-MAIL</th>
                 		<td><input name="email" type="text" style="width:307px;" class="input" value="<%=email%>" id="email" /> </td>
					</tr>
					<tr>
						 <th><%=localcurrcd%> Amount</th>
		                 <td><input name="local_amt" type="text" style="width:100px;text-align:right" class="input2" value="<%=local_ttl_amt%>" readonly id="ttl_amt" /> </td>
		                 <th><%=localcurrcd%> Count</th>
		                 <td><input name="local_cnt" type="text" style="width:95px;text-align:right" class="input2" value="<%=local_count%>" readonly id="bl_cnt" /> </td>
					</tr>
					<tr>
						 <th>USD Amount</th>
		                 <td><input name="usd_amt" type="text" style="width:100px;text-align:right" class="input2" value="<%=usd_ttl_amt%>" readonly id="ttl_amt" /> </td>
		                 <th>USD Count</th>
		                 <td><input name="usd_cnt" type="text" style="width:95px;text-align:right" class="input2" value="<%=usd_count%>" readonly id="bl_cnt" /> </td>
					</tr>
				</tbody> 
			</table>
		</div>
	</div>
	<!-- opus_design_inquiry(E) -->
	<!-- opus_design_grid(S) -->
	<div style="display: none;">
		<div class="wrap_result">
			<div class="opus_design_grid clear" >
				<script type="text/javascript">ComSheetObject('sheet1');</script>
			</div>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</div>	
</form>

<%@include file="/bizcommon/include/common_alps.jsp"%>