<%
/*=========================================================
*Copyright(c) 2009 CybERPogitec
*@FileName : EES_DMT_4011.jsp
*@FileTitle : Outstanding Inquiry by Customer & Issue - Detail(s)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.03
*@LastModifier : 문중철
*@LastVersion : 1.0
* 2009.09.03 문중철
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt4011Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>

<%
    EesDmt4011Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id = "";
    String strUsr_nm = "";
    String strUsr_of = "";
    String strRhq_of = "";
    String strUsr_em = "";
	String[] arrUsrAuth = null;
	String sec_invoice	= "Y";	//Save, Cancel, A/R I/F 버튼 권한 부여
	int i_cnt = 0;
    
    String tIsof = "";
    String tCtof = "";
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
    String tTaano = "";
    
    String tInPayr = "";
    String grop_cust = "";
    String ctrt_cust = "";
    
    String ctrt_ofc_cd = "";
    String ctrt_srep_cd = "";
    String ctrt_tp = "";
    String ctrt_no = "";
    String ctrt_cust_cd = "";
    
	String prg_ex_in_cd = "";
	String coll = "";
	
	String ctrtFlg = "";
	
	String invocr = "";
    
    String mailContents =    "<br>"
                            +"Attached to this e-mail is a Demurrage / Detention Statement from SM Line. <br>" 
                            +"If you have any difficulties or questions pertaining to the statement, <br>"
                            +"please contact our local branch office. <br>"
                            +"<br>"
                            +"SM Line Corporation <br>" 
                            +"<br>"
                            +"www.smlines.com <br>"  
                            +"<br>";
    Logger log = Logger.getLogger("com.hanjin.apps.eqtransportplannperform.eqtransportplannperform");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strUsr_of = account.getOfc_cd();
        strRhq_of = account.getRhq_ofc_cd();
        strUsr_em = account.getUsr_eml();
		arrUsrAuth	= account.getUserAuth();	//COM_USR_ROLE_MTCH의 USR_ROLE_CD
		StringBuffer sb = new StringBuffer();
		
		//권한부여 체크 추가(2010.04.08)-- 로그인 User의 Role이 DMT01, DMT02, DMT03, DMT04가 아닐 경우
		//							   "You have no authority to XXXX!" alert 창을 띄우며 막음
		/*****************************************
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
		************************************************/
		
        event = (EesDmt4011Event)request.getAttribute("Event");
        tIsof = StringUtil.xssFilter(request.getParameter("isof"));
        tCtof = StringUtil.xssFilter(request.getParameter("ctof"));
        tTftp = StringUtil.xssFilter(request.getParameter("tftp"));
        tFrdt = StringUtil.xssFilter(request.getParameter("frdt"));
        tTodt = StringUtil.xssFilter(request.getParameter("todt"));
        tArif = StringUtil.xssFilter(request.getParameter("arif"));
        tPayc = StringUtil.xssFilter(request.getParameter("payc"));
        //tPayn = StringUtil.xssFilter(request.getParameter("payn"));
        tCutp = StringUtil.xssFilter(request.getParameter("cutp"));
        tCuno = StringUtil.xssFilter(request.getParameter("cuno"));
        tCude = StringUtil.xssFilter(request.getParameter("cude"));
        tScno = StringUtil.xssFilter(request.getParameter("scno"));
        tRfan = StringUtil.xssFilter(request.getParameter("rfan"));     
        tTaano = StringUtil.xssFilter(request.getParameter("taano"));    

        tInPayr = StringUtil.xssFilter(request.getParameter("inPayr")); 
        grop_cust = StringUtil.xssFilter(request.getParameter("grop_cust")); 
        ctrt_cust = StringUtil.xssFilter(request.getParameter("ctrt_cust")); 

        ctrt_ofc_cd = StringUtil.xssFilter(request.getParameter("ctrt_ofc_cd"));
        ctrt_srep_cd = StringUtil.xssFilter(request.getParameter("ctrt_srep_cd"));
        ctrt_tp = StringUtil.xssFilter(request.getParameter("ctrt_tp"));
        ctrt_no = StringUtil.xssFilter(request.getParameter("ctrt_no"));      
        ctrt_cust_cd = StringUtil.xssFilter(request.getParameter("ctrt_cust_cd"));  
        
        prg_ex_in_cd = StringUtil.xssFilter(request.getParameter("prg_ex_in_cd"));
        coll = StringUtil.xssFilter(request.getParameter("coll"));        

        ctrtFlg = StringUtil.xssFilter(request.getParameter("ctrtFlg"));
        
        invocr = StringUtil.xssFilter(request.getParameter("invocr")); 
        
        log.debug("\n[prg_ex_in_cd] = "+ prg_ex_in_cd);
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        sec_invoice = eventResponse.getETCData("ROLE_AUTH_FLAG"); // 화면별 사용자 Role 권한 Flag 반환
		log.debug("\n[USER_AUTH] = "+ sec_invoice);
        
    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title>Outstanding Inquiry by Customer & Issue - Detail(s)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
<script language="javascript">
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
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="isof" value="<%=tIsof%>">
<input type="hidden" name="ctof" value="<%=tCtof%>">
<input type="hidden" name="tftp" value="<%=tTftp%>">
<input type="hidden" name="frdt" value="<%=tFrdt%>">
<input type="hidden" name="todt" value="<%=tTodt%>">
<input type="hidden" name="arif" value="<%=tArif%>">
<input type="hidden" name="cutp" value="<%=tCutp%>">
<input type="hidden" name="cuno" value="<%=tCuno%>">
<input type="hidden" name="cude" value="<%=tCude%>">
<input type="hidden" name="scno" value="<%=tScno%>">
<input type="hidden" name="rfan" value="<%=tRfan%>">
<input type="hidden" name="taano" value="<%=tTaano%>">

<input type="hidden" name="inpayr" value="<%=tInPayr%>">
<input type="hidden" name="grop_cust" value="<%=grop_cust%>">
<input type="hidden" name="ctrt_cust" value="<%=ctrt_cust%>">

<input type="hidden" name="ctrt_ofc_cd" value="<%=ctrt_ofc_cd%>">
<input type="hidden" name="ctrt_srep_cd" value="<%=ctrt_srep_cd%>">
<input type="hidden" name="ctrt_tp" value="<%=ctrt_tp%>">
<input type="hidden" name="ctrt_no" value="<%=ctrt_no%>">
<input type="hidden" name="ctrt_cust_cd" value="<%=ctrt_cust_cd%>">

<input type="hidden" name="prg_ex_in_cd" value="<%=prg_ex_in_cd%>">
<input type="hidden" name="coll" value="<%=coll%>">
        
<input type="hidden" name="ctrt_flg" value="<%=ctrtFlg%>">
<input type="hidden" name="invocr" value="<%=invocr%>">

<input type="hidden" name="h_usr_off" value="<%=strUsr_of%>">
<input type="hidden" name="h_rhq_off" value="<%=strRhq_of%>">

<input type="hidden" name="tftp2">
<input type="hidden" name="invno">
<input type="hidden" name="sheetp">
<input type="hidden" name="creof">

<input type="hidden" name="issoff" value="<%=strUsr_of%>">
<input type="hidden" name="trftpp">
<input type="hidden" name="shttpp" value="O">

<input type="hidden" name="rmrk">

<input type="hidden" name="payer_cd">
<input type="hidden" name="payer_nm">
<input type="hidden" name="dmdt_payr_cntc_pnt_nm">
<input type="hidden" name="cust_cntc_pnt_seq">
<input type="hidden" name="cust_cnt_cd"><!-- Attention -->
<input type="hidden" name="cust_seq">   <!-- Attention -->
<input type="hidden" name="ofc_cd">

<input type="hidden" name="payr_faxnos">
<input type="hidden" name="payr_emailnos">
<input type="hidden" name="dmdt_trf_cd">

<input type="hidden" name="sec_invoice" value="<%=sec_invoice %>"><!-- invoice 저장 권한 코드 -->

<input type="hidden" name="rpt_ofcadd01" >
<input type="hidden" name="rpt_ofcadd02" >
<input type="hidden" name="rpt_ofcadd03" >
<input type="hidden" name="rpt_custname" ><!-- tPayn -->
<input type="hidden" name="rpt_address01">
<input type="hidden" name="rpt_address02">
<input type="hidden" name="rpt_address03">
<input type="hidden" name="rpt_address04">
<input type="hidden" name="rpt_hjsref"   value="<%=strUsr_nm%>">
<input type="hidden" name="rpt_attnname" >
<input type="hidden" name="rpt_custcode" value="<%=tPayc%>">
<input type="hidden" name="rpt_telno"    >
<input type="hidden" name="rpt_faxno"    >
<input type="hidden" name="rpt_custvat"  >
<input type="hidden" name="rpt_header01" >
<input type="hidden" name="rpt_header02" >
<input type="hidden" name="rpt_header03" >
<input type="hidden" name="rpt_header04" >
<input type="hidden" name="rpt_header05" >
<input type="hidden" name="rpt_header06" >
<input type="hidden" name="rpt_header07" >
<input type="hidden" name="rpt_header08" >
<input type="hidden" name="rpt_header09" >
<input type="hidden" name="rpt_header10" >
<input type="hidden" name="rpt_leftright">
<input type="hidden" name="rpt_contents">
<input type="hidden" name="rpt_opttitle">
<input type="hidden" name="rpt_custref">
<input type="hidden" name="rpt_telfax">
<input type="hidden" name="rpt_custvatno">

<input type="hidden" name="rd_fxeml_sys_cd"         > <!-- DMT //-->
<input type="hidden" name="rd_fxeml_file_name"      > <!-- RD FILE NAME 파일 이름만 *.mrd //-->
<input type="hidden" name="rd_fxeml_file_name2"     > <!-- attch fax name //-->
<input type="hidden" name="rd_fxeml_bat_flg"        > <!-- N //-->
<input type="hidden" name="rd_fxeml_title"          > <!-- 제목 //-->
<input type="hidden" name="rd_fxeml_doc_tp"         > <!-- I : Invoice D : Demend G : GroupDemand O : OTS //-->
<input type="hidden" name="rd_fxeml_rd_param"       > <!-- RD REPORT PARAMETER //-->
<input type="hidden" name="rd_fxeml_rd_param2"      > <!-- RD REPORT PARAMETER (FAX ATTACH)//-->
<input type="hidden" name="rd_fxeml_fax_no"         > <!-- RECIEVER FAX NO ex) NAME:5336  //-->
<input type="hidden" name="rd_fxeml_fax_sndr_id"    > <!-- SENDER ID //-->
<input type="hidden" name="rd_fxeml_eml_sndr_nm"    > <!-- EMAIL SENDER NAME  //-->
<input type="hidden" name="rd_fxeml_eml_sndr_add" value="<%= strUsr_em %>"> <!-- SENDER EMAIL ADDRESS //-->
<input type="hidden" name="rd_fxeml_eml_rcvr_add"   > <!-- RECIEVER EMAIL ADDRESS //-->
<input type="hidden" name="rd_fxeml_eml_atch_file"  > <!-- ATTACH FILE NAME //-->
<input type="hidden" name="rd_fxeml_eml_templt"     > <!-- C:/sitectx/ALPS/APP-INF/config/template/mailtemplate/ TEMPLETE FILE 메일본문 //-->
<input type="hidden" name="rd_fxeml_eml_tmplt_param"> <!-- MAILETEMPLETE PARAM ex) name;mjchang|message;DMT EMAIL SEND TEST //-->
<input type="hidden" name="offcd" value="<%=tIsof%>">
<input type="hidden" name="mailctnt" value="<%= mailContents %>">


<!-- 개발자 작업 -->

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr>
<td class="top">
</td>
</tr>
<tr>
<td valign="top">
    
<!-- : ( Title ) (S) -->
    <table width="100%" border="0">
    <tr>
    <td class="title">
        <img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Outstanding Inquiry by Customer & Issue- Detail(s)
    </td>
    </tr>
    </table>
<!-- : ( Title ) (E) -->

<!-- : ( Search Options ) (S) -->
    <table class="search"> 
    <tr>
    <td class="bg">

        <table class="search" border="0" style="width:979;"> 
        <tr class="h23">
        <td width="44">
            Payer  
        </td>
        <td width="">
            <input type="text" style="width:70;" class="input2" name="payc" value="<%=tPayc%>" readOnly>&nbsp;
            <input type="text" style="width:500;" class="input2" name="payn" readOnly>
        </td>
        </tr>
        </table>

<!--  biz_1  (E) -->
        <table class="line_bluedot">
        <tr>
        <td colspan="6">
        </td>
        </tr>
        </table>

<!-- Grid  (S) -->
        <table width="100%"  id="mainTable"> 
        <tr>
        <td width="100%">
            <script language="javascript">ComSheetObject('sheet1');</script>
        </td>
        </tr>
        </table>
<!-- Grid  (e) -->

        <table class="height_5">
        <tr>
        <td>
        </td>
        </tr>
        </table>
        
        <table class="search" border="0">
        <tr class="h23">
        <td class="title_h">
        </td>
        <td class="title_s">
         Selected Total
        </td>
        </tr>
        </table>
                        
        <table class="search" border="0" style="width:979;"> 
        <tr class="h23">
        <td width="90">
            INV Qty 
        </td>
        <td width="133">
            <input type="text" name="vinvqty" style="width:80;text-align:right" class="input2" value="" readOnly>
        </td>
        
        <td width="110">
            Incurred AMT
        </td>
        <td width="178">
            <input type="text" name="vincamt" style="width:160;text-align:right" class="input2" value="" readOnly>
        </td>
        <td width="71">
            CMDT AMT
        </td>
        <td width="179">
            <input type="text" name="vcmdtamt" style="width:140;text-align:right" class="input2" value="" readOnly>
        </td>
        <td width="85">
            Expt AMT
        </td>
        <td width="">
        	<input type="text" name="vexcepamt" style="width:100%;text-align:right" class="input2" value="" readOnly>
        </td>
        
        </tr>
        </table>
        
        <table class="search" border="0" style="width:979;"> 
        <tr class="h23">
        <td width="90">
            D/C AMT
        </td>
        <td width="133">
            <input type="text" name="vdcamt" style="width:120;text-align:right" class="input2" value="" readOnly>
        </td>

        <td width="110">
            Billing AMT
        </td>
        <td width="178">
            <input type="text" name="vbilamt" style="width:160;text-align:right" class="input2" value="" readOnly>
        </td>
        <td width="71">
            Tax AMT
        </td>
        <td width="179">
            <input type="text" name="vtaxamt" style="width:140;text-align:right" class="input2" value="" readOnly>
        </td>
        <td width="85">
            Payable AMT
        </td>
        <td width="">
            <input type="text" name="vpayamt" style="width:100%;text-align:right" class="input2" value="" readOnly>
        </td>
        </tr>
        </table>
<!--  biz_1  (E) -->
        <table class="line_bluedot">
        <tr>
        <td colspan="6">
        </td>
        </tr>
        </table>
        <table class="search" border="0" style="width:979;"> 
        <tr class="h23">
        <td width="90">
            ERP Col. Status
        </td>
        <td width="133">
            <input type="text" name="t_col_status" style="width:120;text-align:right" class="input2" value="N" readOnly>
        </td>
        <td width="110">
            ERP Col. Charge
        </td>
        <td width="178">
            <input type="text" name="t_col_charge" style="width:160;text-align:right" class="input2" value="" readOnly>
        </td>
        <td width="71">
            ERP Col. Tax
        </td>
        <td width="179">
            <input type="text" name="t_col_tax" style="width:140;text-align:right" class="input2" value="" readOnly>
        </td>       
        <td width="85">
            ERP Col. Total
        </td>
        <td width="">
            <input type="text" name="t_col_total" style="width:100%;text-align:right" class="input2" value="" readOnly>
        </td>
        </tr>
        </table>

        <table class="search" border="0" style="width:979;"> 
        <tr class="h23">
        <td width="90">
            ERP Col. Date
        </td>
        <td width="133">
            <input type="text" name="t_col_date" style="width:120;text-align:right" class="input2" value="" readOnly>
        </td>
        <td width="110">
            Uncollected AMT
        </td>
        <td width="178">
            <input type="text" name="t_uncol_amt" style="width:160;text-align:right" class="input2" value="" readOnly>
        </td>
        <td width="470" colspan='4'>
        </td>
        </tr>
        </table>        
<!--  biz_1  (E) -->
        <table class="line_bluedot">
        <tr>
        <td colspan="6">
        </td>
        </tr>
        </table>
        <table class="search" border="0" style="width:979"> 
                    <tr class="h23">
                        <td width="90">Attention</td>
                        <td width="191"><script language="javascript">ComComboObject('combo1', 4, 152 , 1, 0, 0, true)</script></td>
                        <td width="52">Tel.</td>
                        <td width="190"><input type="text" name="payr_cntc_pnt_phn_no" style="width:160;" class="input2" value="" readOnly></td>
                        <td width="60">Fax</td>
                        <td width="180"><input type="text" name="payr_cntc_pnt_fax_no" style="width:140;" class="input2" value="" readOnly></td>
                        <td width="45">E-mail</td>
                        <td width="" class="stm"><input type="text" name="payr_cntc_pnt_eml" style="width:100%;" class="input2" value="" readOnly></td>
                    </tr>        
<!-- 
        <tr class="h23">
        <td width="67">
            Attention 
        </td>
        <td width="190">
            <select style="width:120;" class="input" name="atn_sel">
                <option value="ATTN 1st" selected>ATTN 1st</option>
                <option value="1"></option>
            </select>
        </td>
        <td width="30">
            Tel.
        </td>
        <td width="220">
            <input type="text" style="width:160;" class="input2" name="tel_no" value="">
        </td>
        <td width="30">
            Fax
        </td>
        <td width="190">
            <input type="text" style="width:160;" class="input2" name="fax_no" value="">
        </td>
        <td width="50">
            E-mail
        </td>
        <td width="">
            <input type="text" style="width:180;" class="input2" name="e_mail" value="">
        </td>
        </tr>
 -->        
        </table>
        
        <table class="search" border="0" style="width:979;"> 
        <tr class="h23">
        <td>
            <table class="search" border="0" style="width:621;"> 
            <tr class="h23">
            <td width="">
            Ext OTS Remark(s)
            </td>
            </tr>
            <tr class="h23">
            <td width="">
                <table border="0" style="width:100%; background-color:white;" class="grid2"> 
                <tr class="h23">
                <td>
                    <input type="text" style="width:100%;font-family: Courier New;" class="noinput" value="" name="remark01" maxlength="85">
                </td>
                </tr>
                <tr class="h23">
                <td>
                    <input type="text" style="width:100%;font-family: Courier New;" class="noinput" value="" name="remark02" maxlength="85">
                </td>
                </tr>
                </table>
            </td>
            </tr>
            </table>
        </td>
        <td>
            <table class="search" border="0" style="width:221;"> 
            <tr class="h23">
            <td width="">
            Int OTS Remark(s)
            </td>
            </tr>
            <tr class="h23">
            <td width="">
                <table border="0" style="width:100%; background-color:white;" class="grid2"> 
                <tr class="h23">
                <td>
                    <textarea  name="inter_rmk" style="width:230;height:50;" tabindex=91></textarea>
                </td>
                </tr>
                </table>
            </td>
            </tr>
            </table>
        </td>
        <td align="right">
            <table width="110" border="0" cellpadding="0" cellspacing="0" class="button">
            <tr>
            <td class="btn2_left">
            </td>
            <td class="btn2" name="btn1_remark"  title='You can save this OTS remark for this payer code'>
            Save Remark
            </td>
            <td class="btn2_right">
            </td>
            </tr>
            </table>
        </td>
        </tr>
        </table>

        <table class="search" border="0" style="width:979;"> 
        <tr class="h23">
        <td width="90">
            OTS Sheet
        </td>
        <td width="160" class="stm">
            Group by&nbsp;
            <select style="width:100;" class="input" name="cntrinvno">
            <option value="0" selected>INV No</option>                
            <option value="1">CNTR No.</option>
        </select>
        </td>
        <td width="100">
            <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
            <tr>
            <td class="btn2_left">
            </td>
            <td class="btn2" name="btn2_sheetset">
                Sheet Set
            </td>
            <td class="btn2_right">
            </td>
            </tr>
            </table>
        </td>
        <td width="180">
            <table width="110" border="0" cellpadding="0" cellspacing="0" class="button">
            <tr>
            <td class="btn2_left">
            </td>
            <td class="btn2" name="btn2_sheetoption">
                Sheet Option
            </td>
            <td class="btn2_right">
            </td>
            </tr>
            </table>
        </td>
        <td width="130">
            CNTR Rate Detail(s)
        </td>     
        <td class="stm" width="80">
            <input type="checkbox" value="Y" class="trans" name="attachYN" title="Attach CNTR Rate Detail(s) to OTS Invoice Shee">
            &nbsp;Attach
        </td>
        <td width="80">

        </td>
        <td width="100">
            <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
            <tr>
            <td class="btn2_left">
            </td>
            <td class="btn2" name="btn1_down_excel" title="CNTR Rate Detail(s) Down Excel">
                Down Excel
            </td>
            <td class="btn2_right">
            </td>
            </tr>
            </table>
        </td>
        <td width="">
            <table width="100" border="0" cellpadding="0" cellspacing="0" class="button">
            <tr>
            <td class="btn2_left">
            </td>
            <td class="btn2" name="btn1_detail_print" title="CNTR Rate Detail(s) Print">
                Detail Print
            </td>
            <td class="btn2_right">
            </td>
            </tr>
            </table>
        </td>
        </tr>
        </table>
        
<!-- : ( Search Options ) (E) -->
 
    </td>
    </tr>
    </table>

    <!-- Tab BG Box  (S) -->
    <!--biz page (E)-->
    <!--Button (S) -->
    <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;padding-bottom:10;"> 
    <tr>
    <td class="btn1_bg">
        <table border="0" cellpadding="0" cellspacing="0">
        <tr>
        <td>
            <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
            <tr>
            <td class="btn1_left">
            </td>
            <td class="btn1" name="btn1_preview">
                Preview
            </td>
            <td class="btn1_right">
            </td>
            </tr>
            </table>
        </td>
                
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn1_ots_print">OTS Print</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn1_fax_send">Fax Send</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn1_email_send">Email Send</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_sendinghistory">Sending History</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                
		    	<% if (!"Y".equals(ctrtFlg)) { %>	 
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn1_payer_info">Payer  Info</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
				<% } %>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn1_detail">Detail</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn2_down_excel">Down Excel</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                
            
                
        </td></tr>
        </table>
    <!--Button (E) -->
<!-- : ( Search Options ) (E) -->
</td></tr>
</table> 
<table class="height_5"><tr><td></td></tr></table>
</td></tr>
</table> 

    
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
    
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;padding-bottom:10;"> 
        <tr><td class="btn3_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn1_close">Close</td>
                    <td class="btn1_right">
                </tr></table></td>
                
            </tr>
        </table>
    <!--Button (E) -->
    
    </td></tr>
</table>
</td></tr>
</table>

<table><tr><td height="50"></td></tr></table>
<!-- : ( Button : pop ) (E) -->
                    <table width="100%"  id="mainTable"> 
                        <tr>
                            <td width="100%">
                                <script language="javascript">ComSheetObject('sheet2');</script>
                            </td>
                        </tr>
                    </table> 
                    <table width="100%"  id="mainTable"> 
                        <tr>
                            <td width="100%">
                                <script language="javascript">ComSheetObject('sheet3');</script>
                            </td>
                        </tr>
                    </table>
                    <table width="100%" height="1" id="mainTable"> 
                        <tr>
                            <td width="100%">
<script language='javascript'>comRdObject('csrPrevie',0,0);</script>
                            </td>
                        </tr>
                    </table>
                    
<table width="100%"  id="mainTable2" style=display:none;> 
    <tr>
        <td width="100%">
<!-- hidden 처리 (S)--> <script language="javascript">ComSheetObject('sheet4');</script> <!-- hidden 처리 (E)-->
        </td>
    </tr>
</table>                    
</form>
</body>
</html>