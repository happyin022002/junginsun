<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_4011.jsp
*@FileTitle  : Outstanding Inquiry by Customer & Issue - Detail(s)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/30
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt4011Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%
    EesDmt4011Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //count of DB ResultSet list

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id = "";
    String strUsr_nm = "";
    String strUsr_of = "";
    String strRhq_of = "";
    String strUsr_em = "";
	String[] arrUsrAuth = null;
	String sec_invoice	= "Y";	//button authority for Save, Cancel, A/R I/F
	int i_cnt = 0;

    String tIsof = "";
    String tTftp = "";
    String tFrdt = "";
    String tTodt = "";
    String tArif = "";
    String tPayc = "";
    //String tPayn = "";
    String tCutp = "";
    String tCuno = "";
    String tCude = "";
    String tScno = "";
    String tRfan = "";


    String mailContents =    "<br>"
                            +"Attached to this e-mail is a Demurrage / Detention Statement from NYK Line. <br>" 
                            +"If you have any difficulties or questions pertaining to the statement, <br>"
                            +"please contact our local branch office. <br>"
                            +"<br>"
                            +"NYK Line Co., Ltd <br>" 
                            +"<br>"
                            +"www.nyk.com <br>"  
                            +"<br>";
    Logger log = Logger.getLogger("com.clt.apps.eqtransportplannperform.eqtransportplannperform");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strUsr_of = account.getOfc_cd();
        strRhq_of = account.getRhq_ofc_cd();
        strUsr_em = account.getUsr_eml();
		arrUsrAuth	= account.getUserAuth();	// USR_ROLE_CD of COM_USR_ROLE_MTCH
		StringBuffer sb = new StringBuffer();

		// check authority- if Role of login User if not  DMT01, DMT02, DMT03, DMT04
		//					no authority: disply alert "You have no authority to XXXX!" 
		if(arrUsrAuth == null){
			log.debug("[USER_AUTH] null");
			sec_invoice = "N";
		}else{
			log.debug("[USER_AUTH] "+arrUsrAuth.length);
			for(int i = 0; i < arrUsrAuth.length; i++) {
				//test
				sb.append(arrUsrAuth[i]).append("===");

				if(arrUsrAuth[i].equals("DMT01") 
						|| arrUsrAuth[i].equals("DMT02") 
						|| arrUsrAuth[i].equals("DMT03")
						|| arrUsrAuth[i].equals("DMT04"))
				{
					i_cnt++;
				}
			}
			if(i_cnt == 0 ){
				sec_invoice = "N";
			}
		}

		log.debug("[USER_AUTH]"+sb.toString());

        event = (EesDmt4011Event)request.getAttribute("Event");
        tIsof = StringUtil.xssFilter((String)request.getParameter("isof"));
        tTftp = StringUtil.xssFilter((String)request.getParameter("tftp"));
        tFrdt = StringUtil.xssFilter((String)request.getParameter("frdt"));
        tTodt = StringUtil.xssFilter((String)request.getParameter("todt"));
        tArif = StringUtil.xssFilter((String)request.getParameter("arif"));
        tPayc = StringUtil.xssFilter((String)request.getParameter("payc"));
        //tPayn = StringUtil.xssFilter((String)request.getParameter("payn"));
        tCutp = StringUtil.xssFilter((String)request.getParameter("cutp"));
        tCuno = StringUtil.xssFilter((String)request.getParameter("cuno"));
        tCude = StringUtil.xssFilter((String)request.getParameter("cude"));
        tScno = StringUtil.xssFilter((String)request.getParameter("scno"));
        tRfan = StringUtil.xssFilter((String)request.getParameter("rfan"));
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

<head>
<title>Outstanding Inquiry by Customer & Issue - Detail(s)</title>

<script type="text/javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }
</script>

</head>

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />

<input type="hidden" name="isof" value="<%=tIsof%>" id="isof" />
<input type="hidden" name="tftp" value="<%=tTftp%>" id="tftp" />
<input type="hidden" name="frdt" value="<%=tFrdt%>" id="frdt" />
<input type="hidden" name="todt" value="<%=tTodt%>" id="todt" />
<input type="hidden" name="arif" value="<%=tArif%>" id="arif" />
<input type="hidden" name="cutp" value="<%=tCutp%>" id="cutp" />
<input type="hidden" name="cuno" value="<%=tCuno%>" id="cuno" />
<input type="hidden" name="cude" value="<%=tCude%>" id="cude" />
<input type="hidden" name="scno" value="<%=tScno%>" id="scno" />
<input type="hidden" name="rfan" value="<%=tRfan%>" id="rfan" />

<input type="hidden" name="h_usr_off" value="<%=strUsr_of%>" id="h_usr_off" />
<input type="hidden" name="h_rhq_off" value="<%=strRhq_of%>" id="h_rhq_off" />

<input type="hidden" name="tftp2" id="tftp2" />
<input type="hidden" name="invno" id="invno" />
<input type="hidden" name="sheetp" id="sheetp" />
<input type="hidden" name="creof" id="creof" />

<input type="hidden" name="issoff" value="<%=strUsr_of%>" id="issoff" />
<input type="hidden" name="trftpp" id="trftpp" />
<input type="hidden" name="shttpp" value="O" id="shttpp" />

<input type="hidden" name="rmrk" id="rmrk" />

<input type="hidden" name="payer_cd" id="payer_cd" />
<input type="hidden" name="payer_nm" id="payer_nm" />
<input type="hidden" name="dmdt_payr_cntc_pnt_nm" id="dmdt_payr_cntc_pnt_nm" />
<input type="hidden" name="cust_cntc_pnt_seq" id="cust_cntc_pnt_seq" />
<input type="hidden" name="cust_cnt_cd" id="cust_cnt_cd" />
<input type="hidden" name="cust_seq" id="cust_seq" />
<input type="hidden" name="ofc_cd" id="ofc_cd" />

<input type="hidden" name="payr_faxnos" id="payr_faxnos" />
<input type="hidden" name="payr_emailnos" id="payr_emailnos" />
<input type="hidden" name="dmdt_trf_cd" id="dmdt_trf_cd" />

<input type="hidden" name="sec_invoice" value="<%=sec_invoice %>" id="sec_invoice" />

<input type="hidden" name="rpt_ofcadd01" id="rpt_ofcadd01" />
<input type="hidden" name="rpt_ofcadd02" id="rpt_ofcadd02" />
<input type="hidden" name="rpt_ofcadd03" id="rpt_ofcadd03" />
<input type="hidden" name="rpt_custname" id="rpt_custname" />
<input type="hidden" name="rpt_address01" id="rpt_address01" />
<input type="hidden" name="rpt_address02" id="rpt_address02" />
<input type="hidden" name="rpt_address03" id="rpt_address03" />
<input type="hidden" name="rpt_address04" id="rpt_address04" />
<input type="hidden" name="rpt_comref" value="<%=strUsr_nm%>" id="rpt_comref" />
<input type="hidden" name="rpt_attnname" id="rpt_attnname" />
<input type="hidden" name="rpt_custcode" value="<%=tPayc%>" id="rpt_custcode" />
<input type="hidden" name="rpt_telno" id="rpt_telno" />
<input type="hidden" name="rpt_faxno" id="rpt_faxno" />
<input type="hidden" name="rpt_custvat" id="rpt_custvat" />
<input type="hidden" name="rpt_header01" id="rpt_header01" />
<input type="hidden" name="rpt_header02" id="rpt_header02" />
<input type="hidden" name="rpt_header03" id="rpt_header03" />
<input type="hidden" name="rpt_header04" id="rpt_header04" />
<input type="hidden" name="rpt_header05" id="rpt_header05" />
<input type="hidden" name="rpt_header06" id="rpt_header06" />
<input type="hidden" name="rpt_header07" id="rpt_header07" />
<input type="hidden" name="rpt_header08" id="rpt_header08" />
<input type="hidden" name="rpt_header09" id="rpt_header09" />
<input type="hidden" name="rpt_header10" id="rpt_header10" />
<input type="hidden" name="rpt_leftright" id="rpt_leftright" />
<input type="hidden" name="rpt_contents" id="rpt_contents" />
<input type="hidden" name="rpt_opttitle" id="rpt_opttitle" />
<input type="hidden" name="rpt_custref" id="rpt_custref" />
<input type="hidden" name="rpt_telfax" id="rpt_telfax" />
<input type="hidden" name="rpt_custvatno" id="rpt_custvatno" />

<input type="hidden" name="rd_fxeml_sys_cd" id="rd_fxeml_sys_cd" />
<input type="hidden" name="rd_fxeml_file_name" id="rd_fxeml_file_name" />
<input type="hidden" name="rd_fxeml_file_name2" id="rd_fxeml_file_name2" />
<input type="hidden" name="rd_fxeml_bat_flg" id="rd_fxeml_bat_flg" />
<input type="hidden" name="rd_fxeml_title" id="rd_fxeml_title" />
<input type="hidden" name="rd_fxeml_doc_tp" id="rd_fxeml_doc_tp" />
<input type="hidden" name="rd_fxeml_rd_param" id="rd_fxeml_rd_param" />
<input type="hidden" name="rd_fxeml_rd_param2" id="rd_fxeml_rd_param2" />
<input type="hidden" name="rd_fxeml_fax_no" id="rd_fxeml_fax_no" />
<input type="hidden" name="rd_fxeml_fax_sndr_id" id="rd_fxeml_fax_sndr_id" />
<input type="hidden" name="rd_fxeml_eml_sndr_nm" id="rd_fxeml_eml_sndr_nm" />
<input type="hidden" name="rd_fxeml_eml_sndr_add" value="<%= strUsr_em %>" id="rd_fxeml_eml_sndr_add" />
<input type="hidden" name="rd_fxeml_eml_sndr_fixed" id="rd_fxeml_eml_sndr_fixed" />
<input type="hidden" name="rd_fxeml_eml_rcvr_add" id="rd_fxeml_eml_rcvr_add" />
<input type="hidden" name="rd_fxeml_eml_atch_file" id="rd_fxeml_eml_atch_file" />
<input type="hidden" name="rd_fxeml_eml_templt" id="rd_fxeml_eml_templt" />
<input type="hidden" name="rd_fxeml_eml_tmplt_param" id="rd_fxeml_eml_tmplt_param" />
<input type="hidden" name="offcd" value="<%=tIsof%>" id="offcd" />
<input type="hidden" name="mailctnt" value="<%= mailContents %>" id="mailctnt" />

 <div class="layer_popup_title">
 	<div class="page_title_area clear">
		 	<!-- page_title(S) -->
			<h2 class="page_title"><span>Outstanding Inquiry by Customer & Issue- Detail(s)</span></h2>
			<!-- page_title(E) -->
	
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn1_preview" id="btn1_preview">Preview</button><!-- 
				--><button type="button" class="btn_normal" name="btn1_ots_print" id="btn1_ots_print">OTS Print</button><!-- 
				--><button type="button" class="btn_normal" name="btn1_fax_send" id="btn1_fax_send">Fax Send</button><!-- 
				--><button type="button" class="btn_normal" name="btn1_email_send" id="btn1_email_send">Email Send</button><!-- 
				--><button type="button" class="btn_normal" name="btn_sendinghistory" id="btn_sendinghistory">Sending History</button><!-- 
				--><button type="button" class="btn_normal" name="btn1_payer_info" id="btn1_payer_info">Payer  Info</button><!-- 
				--><button type="button" class="btn_normal" name="btn1_detail" id="btn1_detail">Detail</button><!--
				--><button type="button" class="btn_normal" name="btn2_down_excel" id="btn2_down_excel">Down Excel</button><!--
				--><button type="button" class="btn_normal" name="btn1_close" id="btn1_close">Close</button><!-- 
			 --></div>
			<!-- opus_design_btn(E) -->	
		 </div>
 	</div>
	 <div class="layer_popup_contents">
	 	<!-- inquiry_area(S) -->
		<div class="wrap_search">
			<div class="opus_design_inquiry wFit">  <!-- no TAB  -->
				<table> 
					<colgroup>
						<col width="42" />
						<col width="*" />
					</colgroup>
					<tbody>
						<tr>
					       <th>Payer</th>
					       <td>
					           <input type="text" style="width:70px;" class="input2" name="payc" value="<%=tPayc%>" readonly id="payc" /><!-- 
					            --><input type="text" style="width:500px;" class="input2" name="payn" readonly id="payn" />
					       </td>
				       </tr>
					</tbody>
				</table>
				
			</div>
		</div>  
		<div class="wrap_result">	
		<!-- opus_design_grid(S) -->  
			<div class="opus_design_grid" id="mainTable">
				<script type="text/javascript">ComSheetObject('sheet1');</script>
			</div>
		<!-- opus_design_grid(E) -->
		<div class="opus_design_inquiry wFit">  <!-- no TAB  -->
			<table>
				<tr>
					<td><h3 class="title_design">Selected Total</h3></td>
		        </tr>
        	</table>
			<table> 
				<colgroup>
					<col width="70" />
					<col width="143" />
					<col width="75" />
					<col width="189" />
					<col width="61" />
					<col width="179" />
					<col width="85" />
					<col width="*" />
				</colgroup>
				<tbody>
			        <tr>
				        <th>INV Qty</th>
				        <td><input type="text" name="vinvqty" style="width:80px;text-align:right" class="input2" value="" id="vinvqty" readOnly/></td>
				        <th>Billing AMT</th>
				        <td><input type="text" name="vbilamt" style="width:160px;text-align:right" class="input2" value="" id="vbilamt" readOnly/></td>
				        <th>Tax AMT</th>
				        <td><input type="text" name="vtaxamt" style="width:140px;text-align:right" class="input2" value="" id="vtaxamt" readOnly/></td>
				        <th>Payable AMT</th>
				        <td><input type="text" name="vpayamt" style="width:150px;text-align:right" class="input2" value="" id="vpayamt" readOnly/></td>
			        </tr>
			        <tr>
                        <th>Attention</th>
                        <td><script type="text/javascript">ComComboObject('combo1', 4, 152 , 1, 0, 0, true)</script></td>
                        <th>Tel.</th>
                        <td><input type="text" name="payr_cntc_pnt_phn_no" style="width:160px;" class="input2" value="" readonly id="payr_cntc_pnt_phn_no" /> </td>
                        <th>Fax</th>
                        <td><input type="text" name="payr_cntc_pnt_fax_no" style="width:140px;" class="input2" value="" readonly id="payr_cntc_pnt_fax_no" /> </td>
                        <th>E-mail</th>
                        <td><input type="text" name="payr_cntc_pnt_eml" style="width:150px;" class="input2" value="" readonly id="payr_cntc_pnt_eml" /> </td>
                    </tr> 
                </tbody>
           </table>
           <table class="grid_2"> 
				<colgroup>
					<col width="70" />
					<col width="623" />
					<col width="175" />
					<col width="*" />
				</colgroup>
				<tbody>
                    <tr>
                    	<th><strong>OTS</strong></th>
                    	<td><input type="text" style="width:100%;font-family: Courier New;" class="noinput" value="" name="remark01" maxlength="85" id="remark01" /></td>
                    	<td style="border:none"></td>
                    	<td rowspan="2" style="border:none"><button type="button" name="btn1_remark" title='You can save this OTS remark for this payer code' id="btn1_remark" class="btn_etc">Save Remark</button></td>
                   	</tr>
                   	<tr>
						<th><strong>Remark(s)</strong></th>
                    	<td><input type="text" style="width:100%;font-family: Courier New;" class="noinput" value="" name="remark02" maxlength="85" id="remark02" /></td>
                    	<td style="border:none"></td>
                    </tr>
                </tbody>
           </table>
           <table> 
				<colgroup>
					<col width="70" />
					<col width="143" />
					<col width="75" />
					<col width="189" />
					<col width="61" />
					<col width="130" />
					<col width="*" />
				</colgroup>
				<tbody>
                    <tr>
                    	<th>OTS Sheet</th>
					    <td>Group by&nbsp;
					         <select style="width:100px;" class="input" id="cntrinvno" name="cntrinvno">
					         <option value="0" selected>INV No</option>                
					         <option value="1">CNTR No.</option>
					     	</select>
					     </td>
					     <td>
					     	<button type="button" name="btn2_sheetset" id="btn2_sheetset" class="btn_etc">Sheet Set</button><!-- 
					     	 --><button type="button" name="btn2_sheetoption" id="btn2_sheetoption" class="btn_etc">Sheet Option</button>
					     </td>
					     <th>CNTR Rate Detail(s)</th>     
				        <td><input type="checkbox" value="Y" class="trans" name="attachYN" title="Attach CNTR Rate Detail(s) to OTS Invoice Shee" id="attachYN" /><label for="attachYN">Attach</label></td>
				        <td></td>
				        <td>
				        	<button type="button" name="btn1_down_excel" id="btn1_down_excel" class="btn_etc" title="CNTR Rate Detail(s) Down Excel">Down Excel</button><!-- 
					     	 --><button type="button" name="btn1_detail_print" id="btn1_detail_print" class="btn_etc" title="CNTR Rate Detail(s) Print">Detail Print</button>
				        </td>
                    </tr>
				</tbody>
			</table>
		</div>
		<div class="opus_design_grid" id="mainTable" style="display:" >
		<script type="text/javascript">ComSheetObject('sheet2');</script>
		<script type="text/javascript">ComSheetObject('sheet3');</script>
		</div>
		<div class="opus_design_grid" id="mainTable2" style=display:none; >
			<script type="text/javascript">ComSheetObject('sheet4');</script>
		</div>
	<!-- opus_design_grid(E) -->
			
 	</div>

</div>
</form>