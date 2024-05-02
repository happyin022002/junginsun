<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_0066.jsp
*@FileTitle  : EDI Search
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/31
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.sce.common.util.basic.CodeUtilBC" %>
<%@ page import="com.clt.apps.opus.esd.sce.common.util.basic.CodeUtilBCImpl" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%
	CodeUtilBC codeUtil = new CodeUtilBCImpl() ;

	//main 화면에서 보낸 Parameter
	String bkg_no = JSPUtil.getNull(request.getParameter("bkg_no"));
	String bkg_no_split = JSPUtil.getNull(request.getParameter("bkg_no_split"));
	String cntr_no = JSPUtil.getNull(request.getParameter("cntr_no"));
	String cs_grp_id = JSPUtil.getNull(request.getParameter("cs_grp_id"));
	String f_cmd = JSPUtil.getNull(request.getParameter("f_cmd"));
	String nod = JSPUtil.getNull(request.getParameter("nod"));

	//EDI STS 검색 조건: Default
	//String queryOption = "cgo.edi_grp_cd = '" + cs_grp_id + "' and cgo.edi_stnd_sts_cd = sts.edi_stnd_sts_cd and sts.co_div_cd = cgo.co_div_cd order by edi_sts_seq";
	//Group by 추가
	String queryOption = "cgo.edi_grp_cd = '" + cs_grp_id + "' and cgo.edi_stnd_sts_cd = sts.edi_stnd_sts_cd and sts.co_div_cd = cgo.co_div_cd GROUP BY cgo.edi_stnd_sts_cd, sts.edi_sts_desc order by edi_sts_seq ";
	//EDI STS콤보에서 선택한 값이 있는 경우
	String edi_idx = JSPUtil.getNull(request.getParameter("edi_selected_idx"));
	//EDI STS콤보에서 선택한 값이 없는 경우
	if (edi_idx.equals("")) edi_idx = "0";

	//CUST STS 컬럼 값: Default
	String custQryCOL = " 'VSL:' || decode(EDI_VSL_TP_CD, '1', 'TRUNK', '2', 'NOT TRUNK', '3', 'ALL') || ' / EVENT:' || decode(EDI_EVNT_CD, '1', 'FIRST', '2', 'NOT FIRST', '3', 'LAST', '4', 'NOT LAST', '5', 'ALL') custDesc ";
	String custQryOPT = null ;
	if (request.getParameter("cust_opt") != null && !request.getParameter("cust_opt").equals("")){
		//CUST STS 검색옵션 지정(EDI STS콤보에서 선택 값에 따른)
		custQryOPT =  JSPUtil.getNull(request.getParameter("cust_opt"));
	}else{
		//CUST STS 검색옵션 지정(EDI STS콤보에서 선택 값이 없는 경우): Default
		custQryOPT = " edi_grp_cd = '"+cs_grp_id+"' " ;
	}

	//최종 사용될 CUST STS쿼리
	String combo2= null;
	combo2 = codeUtil.searchCodeCombo("cust_st"," EDI_GRP_CGO where  "+ custQryOPT
	        ,"CUST_EDI_STS_CD cust_st "
	        ,"CUST_EDI_STS_CD || ' - ' || "+custQryCOL+ " " ,""," onChange=javascript:custcomboChange('cust_sts',this.value); ","1:: ");

%>
<script type="text/javascript">

function setupPage(){
    loadPage();
}

function screenReload(){

	form.action = 'ESD_SCE_0066.do';
	form.submit();

}
</script>
<base />
<form method="post" name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="bkg_no" value="<%=bkg_no %>" id="bkg_no" />
<input type="hidden" name="bkg_no_split" value="<%= bkg_no_split %>" id="bkg_no_split" />
<input type="hidden" name="cntr_no" value="<%= cntr_no %>" id="cntr_no" />
<input type="hidden" name="cs_grp_id" value="<%= cs_grp_id %>" id="cs_grp_id" />
<input type="hidden" name="dist" value="" id="dist" />
<input type="hidden" name="cust_sts" value="" id="cust_sts" />
<input type="hidden" name="cust_opt" value="<%= custQryOPT %>" id="cust_opt" />
<input type="hidden" name="load_chk" value="FAIL" id="load_chk" />
<input type="hidden" name="edi_selected_idx" value="<%= edi_idx %>" id="edi_selected_idx" />
<input type="hidden" name="cust_st" id="cust_st" />
<!-- page_title_area(S) -->
<div class="layer_popup_title"> 
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><span id="titles">Cargo Tracking EDI Send - Group</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" type="button" name="btn_ok" id="btn_ok">Ok</button><!--
		--><button class="btn_normal" type="button" name="btn_close" id="btn_close" >Close</button><!--
		--></div>
	<!-- opus_design_btn (E) -->
</div>
</div>
<div style="display:none;"><script type="text/javascript">ComSheetObject('t0sheet');</script></div>
<!-- page_title_area(E) -->
<!-- wrap_search(S) -->
<div class="layer_popup_contents"> 
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="80" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
					<th>EDI STS </th>
					<td><%=codeUtil.searchCodeCombo("edi_sts"," edi_grp_cgo cgo , edi_cgo_stnd_sts sts where " + queryOption
					        ,"cgo.edi_stnd_sts_cd edi_sts "
					        ,"cgo.edi_stnd_sts_cd || ' - ' || sts.edi_sts_desc cs_desc , MIN(sts.edi_sts_seq) edi_sts_seq    " ,""," onChange=javascript:comboChange('edi_sts'); ","1:: ")%></td>
		   		</tr>
		   		<tr>
					<th>CUST STS </th>
					<td><%=combo2%></td>
				</tr>
				<tr>
					<th>Actual Date </th>
					<td><input name="act_dt" onkeyup="enterCheck();" type="text" class="input" style="width:130px; text-transform:uppercase;" value="" id="act_dt" />&nbsp;<b>(YYYY/MM/DD HH:MM:SS)</b></td>
				</tr>
				<tr>
					<th>Location </th>
					<td><input name="nod" type="text" class="input" style="width:130px; text-transform:uppercase;" value="" id="nod" /></td>
				</tr>
		   </tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_search(E) -->
</div>
</form>

</body>
<%
	if(!f_cmd.equals("")){
	    Exception serverException = null;                     //서버에서 발생한 에러	
	    String strErrMsg = "";                                //에러메세지
	    String locCd = null;
	    try {
	        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
	        if (serverException != null) {
	            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
	        }
	       
	    }catch(Exception e) {
	        out.println(e.toString());
	    }		
%>
<script>
	var opener = window.dialogArguments;
	if (!opener) opener=window.opener;  //이 코드 추가할것
	if (!opener) opener=parent; //이 코드 추가할것
		if("<%=strErrMsg%>" == ''){
			opener.researchScreen();
			//self.close();	
			ComClosePopup();
		}else{

			alert("The location code(<%=nod%>) is not registered in DB(location)");		
		}

</script>

<%
	}
%>

