/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_4011.jsp
*@FileTitle  : Outstanding Inquiry by Customer & Issue - Detail(s)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/30
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------ The following code added code to make a good  JSDoc ------------------*/
   /**
     * @fileoverview JavaScript is commonly used in business calendar-related functions are defined as.
     * @author Hanjin Shipping
     */
    /**
     * @extends 
     * @class ui_dmt_4011 : ui_dmt_4011 for generating business from the screen using a script is defined.
     */
// common global variables
var sheetObjects=new Array();
var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;
    var ROWMARK="|";
    var FIELDMARK="=";
    var IBSEARCH02=51;
//    var rdObjects=new Array();
//	rdObjects[0] = document.getElementById("csrPrevie");  
//    var rdCnt=0;
    var queryStr="";
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
    function processButtonClick(){
         /***** Tab sheets per case more than two additional sheets are used to specify a variable *****/
         var sheetObject1=sheetObjects[sheetCnt++];
         var sheetObject2=sheetObjects[sheetCnt++];
//         var rdObject=rdObjects[0];
         /*******************************************************/
         var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
                case "btn1_preview": // 4012 OPEN
                    if( sheetObjects[0].rowcount==0 ) {
                        errMsg='No data found.';
                        ComShowMessage(msgs["CIM29030"]);
                        return;
                    }
                    //sheet set check
                    document.form.trftpp.value=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),  "tarftp");
                    formObject.f_cmd.value=SEARCH;
                     var sXml=sheetObjects[0].GetSearchData("EES_DMT_4101GS.do",FormQueryString(formObject));
                    var rtnRemark=ComGetEtcData(sXml, "rtnRemark");
                    if ( rtnRemark == undefined || rtnRemark == '' ) {
                        ComShowMessage(msgs["DMT01096"]);
                        return false;
                    }                    
                    document.form.tftp2.value=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),  "tarftp");
                    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC02);
                    formObject.f_cmd.value=IBSEARCH02;
                    for ( var sh3=1 ; sh3 < sheetObjects[0].RowCount()+1 ; sh3++ ) {
                    	sheetObjects[2].SetCellValue( sh3 , 1 ,sheetObjects[0].GetCellValue( sh3 , 1 ),0);
                    }
                    var tInvNo="";
                    var tTftp=""; 
                    for ( var z01=1 ; z01 < sheetObjects[0].RowCount()+1 ; z01++  ) {
                    	if ( sheetObjects[0].GetCellValue(z01,1) == 1 ) {
                    		tInvNo=sheetObjects[0].GetCellValue(z01, 3) + "," + tInvNo;
                    		tTftp=sheetObjects[0].GetCellValue(z01,11) + "," + tTftp;
                        }
                    }
                    document.form.invno.value=tInvNo;
                    document.form.tftp2.value=tTftp;
                    var tArif=formObject.arif.value;
                    var logInOff=document.form.h_rhq_off.value;
                    if ( tArif == "A" ) {
                        formObject.arif.value="Y,N";
                    }
                    var attyn="";
                    if ( document.form.attachYN.checked ) {
                    	attyn="Y";
                    }
                    var urlParam="EES_DMT_4012.do?tftp2=&sheetp=O&isof="+document.form.isof.value
                                                          +"&payc="+document.form.payc.value
                                                          +"&bkgno="+sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),  "bkgnoo")
                                                          +"&invno="
                                                          +"&attyn="+attyn
                                                          ;
                    ComOpenPopupWithTarget(urlParam, 990, 698, "", "0,1,1,1,1,1,1", true,"yes");
                break;
                case "btn2_sheetset": // 4101 OPEN
                	//ComOpenPopupWithTarget('EES_DMT_4101.do?issoff('+formObject.h_usr_off.value+'&tftp2='+sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"tarftp")+'&sheetp=O&jspno=EES_DMT_4011', 725, 770, "", "0,1,1,1,1,1,1", 1,true);
                	ComOpenPopupWithTarget('EES_DMT_4101.do?issoff('+formObject.h_usr_off.value+'&tftp2='+sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"tarftp")+'&sheetp=O&jspno=EES_DMT_4011', 725, 550, "", "0,1,1,1,1,1,1", 1,true);
                break;
                case "btn2_sheetoption": // 4103 OPEN
                    ComOpenPopupWithTarget('EES_DMT_4103.do?issoff='+formObject.h_usr_off.value+'&jspno=EES_DMT_4011', 625, 680, "", "0,1", true);
                break;
                case "btn1_payer_info": // 4104
                    var url="EES_DMT_4104.do"
                        +"?s_ofc_cd="+ComGetObjValue(formObject.h_usr_off)
                        +"&s_cust_cd="+ComGetObjValue(formObject.payc)
                        +"&s_bkg_no="+sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),  "bkgnoo")
                        +"&s_pod_cd="
                        +"&jspno=EES_DMT_4011"
                        +"&attn="+ComGetObjValue(formObject.dmdt_payr_cntc_pnt_nm)
                        +"&telno="+ComGetObjValue(formObject.payr_cntc_pnt_phn_no)
                        +"&faxno="+ComGetObjValue(formObject.payr_cntc_pnt_fax_no)
                        +"&email="+ComGetObjValue(formObject.payr_cntc_pnt_eml)
                        ;                    
                    var returnValue=ComOpenWindowCenter(url, "EES_DMT_4104", "825","580", true);                    
                break;
                case "btn1_detail": 
                	var tempInvNo=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),  "invnoo")
                    var tempInvNoM=tempInvNo.substring( 2 , 3 );
                    if ( tempInvNoM == "M" ) {
                        var url="EES_DMT_4004P.do"
                            +"?dmdt_inv_no="+tempInvNo
                            +"&caller=4011"
                            +"&main_page=false"
                            ;
                        //팝업함수 호출방법 변경(callback 함수에서 조회를 실행하도록 수정함) 2014.08.26
                        //var returnValue=ComOpenWindowCenter(url, "EES_DMT_4004", "1200","800");
                        ComOpenPopup(url, "1200", "800", "callbackProc", "1,0,1,1,1,1,1", false);

                    } else {
                        var url="EES_DMT_4002.do"
                            +"?group_by=2"
                            +"&chg_type=A"
                            +"&ofc_cd="+sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"isseof")
                            +"&bkg_no="+sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"bkgnoo")
                            +"&dmdt_trf_cd="+sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"tarftp")
                            +"&cntr_no="
                            +"&invoice_no="+tempInvNo
                            +"&invoice_issue=2" //Invoice Issue BEFORE
                            ;
                        //팝업함수 호출방법 변경(callback 함수에서 조회를 실행하도록 수정함) 2014.08.26
                        //var returnValue=ComOpenWindowCenter(url, "EES_DMT_4002", "1200","800");
                        ComOpenPopup(url, "1200", "800", "callbackProc", "1,0,1,1,1,1,1", false);
                    }
                break;
                case "btn1_remark": // PAYER INFO REMARK SAVE
                	if(ComGetObjValue(formObject.sec_invoice) == "N") {
	        			ComShowCodeMessage("DMT01145", "Save Remark");
	        			return;
	        		}
                    doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
                    break;
                case "btn1_ots_print": 
                	document.form.trftpp.value=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),  "tarftp");
                    formObject.f_cmd.value=SEARCH;
                     var sXml=sheetObjects[0].GetSearchData("EES_DMT_4101GS.do",FormQueryString(formObject));
                    var rtnRemark=ComGetEtcData(sXml, "rtnRemark");
                    if ( rtnRemark == undefined || rtnRemark == '' ) {
                        ComShowMessage(msgs["DMT01096"]);
                        return false;
                    }
                    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC02);
                    for ( var sh3=1 ; sh3 < sheetObjects[0].RowCount()+1 ; sh3++ ) {
                    	sheetObjects[2].SetCellValue( sh3 , 1 ,sheetObjects[0].GetCellValue( sh3 , 1 ),0);
                    }
                    rdOpen4012();
                    break;
                case "btn2_down_excel": // 
                     sheetObjects[0].Down2Excel( {DownCols: makeHiddenSkipCol(                    sheetObjects[0]), SheetDesign:1,Merge:1 });
                break;
                case "btn1_fax_send":
                    // TARIFF TYPE
                	document.form.trftpp.value=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),  "tarftp");
                    // REMARK
                    formObject.f_cmd.value=SEARCH;
                     var sXml=sheetObjects[0].GetSearchData("EES_DMT_4101GS.do",FormQueryString(formObject));
                    var rtnRemark=ComGetEtcData(sXml, "rtnRemark");
                    if ( rtnRemark == undefined || rtnRemark == '' ) {
                        ComShowMessage(msgs["DMT01096"]);
                        return false;
                    }                    
                    // OFFICE HEADER01-10 LEFTRIGHT TITLE REF TEL FAX VAT 구하기
                    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC02);
                    var tInvNo="";
                    var tTrfType="";
                    var tCreOf="";	//cre_ofc_cd
                    for ( var z01=1 ; z01 < sheetObjects[0].RowCount()+1 ; z01++  ) {
                    	if ( sheetObjects[0].GetCellValue(z01,1) == 1 ) {
                    		tInvNo=sheetObjects[0].GetCellValue(z01,"invnoo") + "," + tInvNo;
                    		tTrfType=sheetObjects[0].GetCellValue(z01,"tarftp") + "," + tTrfType;
                    		tCreOf=sheetObjects[0].GetCellValue(z01,"isseof") + "," + tCreOf;
                        }
                    }
                    document.form.invno.value=tInvNo;
                    document.form.creof.value=tCreOf;
                    formObject.rd_fxeml_sys_cd         .value="DMT";
                    if        ( document.form.cntrinvno.value == "0" && document.form.rpt_leftright.value == "L" ) {
                        formObject.rd_fxeml_file_name      .value="EES_DMT_4903.mrd";                        
                    } else if ( document.form.cntrinvno.value == "0" && document.form.rpt_leftright.value == "R" ) {
                        formObject.rd_fxeml_file_name      .value="EES_DMT_4904.mrd";
                    } else if ( document.form.cntrinvno.value == "1" && document.form.rpt_leftright.value == "L" ) {
                        formObject.rd_fxeml_file_name      .value="EES_DMT_4905.mrd";
                    } else if ( document.form.cntrinvno.value == "1" && document.form.rpt_leftright.value == "R" ) {
                        formObject.rd_fxeml_file_name      .value="EES_DMT_4906.mrd";
                    }
                    formObject.rd_fxeml_bat_flg        .value="N";
                    formObject.rd_fxeml_title          .value="Statement of Accounts(Custmer Code: "+document.form.payc.value+")";
                    formObject.rd_fxeml_doc_tp         .value="O";
                    formObject.rd_fxeml_rd_param       .value=" /rp [" + document.form.arif .value +"] " +
                                                                   "[" + document.form.frdt .value +"] " +
                                                                   "[" + document.form.todt .value +"] " +
                                                                   "[" + document.form.isof .value +"] " +
                                                                   "[" + document.form.payc .value +"] " +
                                                                   "[" + document.form.payc .value +"] " +
                                                                   "[" + document.form.payc .value +"] " +
                                                                   "[" + document.form.payc .value +"] " +
                                                                   "[" + document.form.payc .value +"] " +
                                                                   //"[" + document.form.tftp2.value +"] " +
                                                                   "[" + tTrfType +"]"+
                                                                   "[" + document.form.scno .value +"] " +
                                                                   "[" + document.form.scno .value +"] " +
                                                                   "[" + document.form.rfan .value +"] " +
                                                                   "[" + document.form.rfan .value +"] " +
                                                                   "[" + document.form.cuno .value +"] " +
                                                                   "[" + document.form.cuno .value +"] " +
                                                                   "[" + document.form.cuno .value +"] " +
                                                                   "[" + document.form.cuno .value +"] " +
                                                                   "[" + document.form.cuno .value +"] " +
                                                                   "[" + document.form.cutp .value +"] " +
                                                                   "[" + document.form.cutp .value +"] " +
                                                                   "[" + document.form.cutp .value +"] " + 
                                                                   "[*** " + document.form.rpt_opttitle .value +" ***] " +
                                                                   "[" + document.form.rpt_ofcadd01 .value +"] " +
                                                                   "[" + document.form.rpt_ofcadd02 .value +"] " +
                                                                   "[" + document.form.rpt_ofcadd03 .value +"] " +
                                                                   "[" + ComReplaceStr(document.form.rpt_custname .value,"'"," ") +"] " +
                                                                   "[" + document.form.rpt_address01.value +"] " +
                                                                   "[" + document.form.rpt_address02.value +"] " +
                                                                   "[" + document.form.rpt_address03.value +"] " +
                                                                   "[" + document.form.rpt_address04.value +"] " +
                                                                   "[" + document.form.rpt_comref   .value +"] " +
                                                                   "[" + document.form.rpt_attnname .value +"] " +
                                                                   "[" + document.form.rpt_custcode .value +"] " +
                                                                   "[" + document.form.payr_cntc_pnt_phn_no.value +"] " +
                                                                   "[" + document.form.payr_cntc_pnt_fax_no.value +"] " +
                                                                   "[" + document.form.rpt_custvat  .value +"] " +
                                                                   "[" + document.form.remark01     .value +"] " +
                                                                   "[" + document.form.remark02     .value +"] " +
                                                                   "[" + document.form.rpt_header01 .value +"] " +
                                                                   "[" + document.form.rpt_header02 .value +"] " +
                                                                   "[" + document.form.rpt_header03 .value +"] " +
                                                                   "[" + document.form.rpt_header04 .value +"] " +
                                                                   "[" + document.form.rpt_header05 .value +"] " +
                                                                   "[" + document.form.rpt_header06 .value +"] " +
                                                                   "[" + document.form.rpt_header07 .value +"] " +
                                                                   "[" + document.form.rpt_header08 .value +"] " +
                                                                   "[" + document.form.rpt_header09 .value +"] " +
                                                                   "[" + document.form.rpt_header10 .value +"] " +
                                                                   "[" + document.form.rpt_custref  .value +"] " +
                                                                   "[" + document.form.rpt_telfax   .value +"] " +
                                                                   "[" + document.form.rpt_custvatno.value +"] " + 
                                                                   "[" + document.form.invno        .value +"] " +
                                                                   "[" + document.form.creof        .value +"] "
                                                                   ;
                    formObject.rd_fxeml_fax_sndr_id    .value="COMPANY";
                    formObject.rd_fxeml_eml_sndr_nm    .value="COMPANY";
                    formObject.rd_fxeml_eml_rcvr_add   .value="";
                    var currDateEmail=ComGetNowInfo();
                    formObject.rd_fxeml_eml_atch_file  .value=currDateEmail+"_"+document.form.payc .value;
                    formObject.rd_fxeml_eml_templt     .value="EES_DMT_4011_01.html"; 
                    formObject.rd_fxeml_eml_tmplt_param.value=""; // "name;mjchang|message;DMT EMAIL SEND TEST"
                    var attachYN="N";
                    if ( document.form.attachYN.checked ) {
                    	attachYN="Y";
                        formObject.rd_fxeml_file_name2      .value="EES_DMT_4907.mrd";                        
                        formObject.rd_fxeml_rd_param2       .value="/rp [" + document.form.invno.value + "] [" + document.form.isof.value + "] [" + document.form.creof.value + "]";
                    }
        			var ofc_cd=ComGetObjValue(formObject.h_usr_off);
        			var url="EES_DMT_4107.do"
        				+"?s_ofc_cd="+ofc_cd
        				+"&s_cust_cd="+ComGetObjValue(formObject.payc)
        				+"&s_bkg_no="+sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),  "bkgnoo")
        				+"&s_pod_cd="
        				+"&jspno=4011"
        				+"&telno="+ComGetObjValue(formObject.payr_cntc_pnt_phn_no)
        				+"&faxno="+ComGetObjValue(formObject.payr_cntc_pnt_fax_no)
        				+"&email="+ComGetObjValue(formObject.payr_cntc_pnt_eml)
        				+"&cntc_seq="+attachYN										
        				;
        			ComOpenWindowCenter(url, "EES_DMT_4107", "520","250", true);
                break;   
                case "btn1_email_send":
                    // TARIFF TYPE
                	document.form.trftpp.value=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),  "tarftp");
                    // REMARK
                    formObject.f_cmd.value=SEARCH;
                     var sXml=sheetObjects[0].GetSearchData("EES_DMT_4101GS.do",FormQueryString(formObject));
                    var rtnRemark=ComGetEtcData(sXml, "rtnRemark");
                    if ( rtnRemark == undefined || rtnRemark == '' ) {
                        ComShowMessage(msgs["DMT01096"]);
                        return false;
                    }
                    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC02);
                    var tInvNo="";
                    var tTrfType="";
                    var tCreOf="";	//cre_ofc_cd
                    for ( var z01=1 ; z01 < sheetObjects[0].RowCount()+1 ; z01++  ) {
                    	if ( sheetObjects[0].GetCellValue(z01,1) == 1 ) {
                    		tInvNo=sheetObjects[0].GetCellValue(z01,"invnoo") + "," + tInvNo;
                    		tTrfType=sheetObjects[0].GetCellValue(z01,"tarftp") + "," + tTrfType;
                    		tCreOf=sheetObjects[0].GetCellValue(z01,"isseof") + "," + tCreOf;
                        }
                    }
                    document.form.invno.value=tInvNo;
                    document.form.creof.value=tCreOf;
                    formObject.rd_fxeml_sys_cd         .value="DMT";
                    if        ( document.form.cntrinvno.value == "0" && document.form.rpt_leftright.value == "L" ) {
                        formObject.rd_fxeml_file_name      .value="EES_DMT_4903.mrd";                        
                    } else if ( document.form.cntrinvno.value == "0" && document.form.rpt_leftright.value == "R" ) {
                        formObject.rd_fxeml_file_name      .value="EES_DMT_4904.mrd";
                    } else if ( document.form.cntrinvno.value == "1" && document.form.rpt_leftright.value == "L" ) {
                        formObject.rd_fxeml_file_name      .value="EES_DMT_4905.mrd";
                    } else if ( document.form.cntrinvno.value == "1" && document.form.rpt_leftright.value == "R" ) {
                        formObject.rd_fxeml_file_name      .value="EES_DMT_4906.mrd";
                    }
                    formObject.rd_fxeml_bat_flg        .value="N";
                    formObject.rd_fxeml_title          .value="Statement of Accounts(Custmer Code: "+formObject.payc.value+")";
                    formObject.rd_fxeml_doc_tp         .value="O";
                    formObject.rd_fxeml_rd_param       .value=" /rp [" + document.form.arif .value +"] " +
                                                                   "[" + document.form.frdt .value +"] " +
                                                                   "[" + document.form.todt .value +"] " +
                                                                   "[" + document.form.isof .value +"] " +
                                                                   "[" + document.form.payc .value +"] " +
                                                                   "[" + document.form.payc .value +"] " +
                                                                   "[" + document.form.payc .value +"] " +
                                                                   "[" + document.form.payc .value +"] " +
                                                                   "[" + document.form.payc .value +"] " +
                                                                   //"[" + document.form.tftp2.value +"] " +
                                                                   "[" + tTrfType +"]"+
                                                                   "[" + document.form.scno .value +"] " +
                                                                   "[" + document.form.scno .value +"] " +
                                                                   "[" + document.form.rfan .value +"] " +
                                                                   "[" + document.form.rfan .value +"] " +
                                                                   "[" + document.form.cuno .value +"] " +
                                                                   "[" + document.form.cuno .value +"] " +
                                                                   "[" + document.form.cuno .value +"] " +
                                                                   "[" + document.form.cuno .value +"] " +
                                                                   "[" + document.form.cuno .value +"] " +
                                                                   "[" + document.form.cutp .value +"] " +
                                                                   "[" + document.form.cutp .value +"] " +
                                                                   "[" + document.form.cutp .value +"] " + 
                                                                   "[*** " + document.form.rpt_opttitle .value +" ***] " +
                                                                   "[" + document.form.rpt_ofcadd01 .value +"] " +
                                                                   "[" + document.form.rpt_ofcadd02 .value +"] " +
                                                                   "[" + document.form.rpt_ofcadd03 .value +"] " +
                                                                   "[" + ComReplaceStr(document.form.rpt_custname .value,"'"," ") +"] " +
                                                                   "[" + document.form.rpt_address01.value +"] " +
                                                                   "[" + document.form.rpt_address02.value +"] " +
                                                                   "[" + document.form.rpt_address03.value +"] " +
                                                                   "[" + document.form.rpt_address04.value +"] " +
                                                                   "[" + document.form.rpt_comref   .value +"] " +
                                                                   "[" + document.form.rpt_attnname .value +"] " +
                                                                   "[" + document.form.rpt_custcode .value +"] " +
                                                                   "[" + document.form.payr_cntc_pnt_phn_no.value +"] " +
                                                                   "[" + document.form.payr_cntc_pnt_fax_no.value +"] " +
                                                                   "[" + document.form.rpt_custvat  .value +"] " +
                                                                   "[" + document.form.remark01     .value +"] " +
                                                                   "[" + document.form.remark02     .value +"] " +
                                                                   "[" + document.form.rpt_header01 .value +"] " +
                                                                   "[" + document.form.rpt_header02 .value +"] " +
                                                                   "[" + document.form.rpt_header03 .value +"] " +
                                                                   "[" + document.form.rpt_header04 .value +"] " +
                                                                   "[" + document.form.rpt_header05 .value +"] " +
                                                                   "[" + document.form.rpt_header06 .value +"] " +
                                                                   "[" + document.form.rpt_header07 .value +"] " +
                                                                   "[" + document.form.rpt_header08 .value +"] " +
                                                                   "[" + document.form.rpt_header09 .value +"] " +
                                                                   "[" + document.form.rpt_header10 .value +"] " +
                                                                   "[" + document.form.rpt_custref  .value +"] " +
                                                                   "[" + document.form.rpt_telfax   .value +"] " +
                                                                   "[" + document.form.rpt_custvatno.value +"] " + 
                                                                   "[" + document.form.invno        .value +"] " +
                                                                   "[" + document.form.creof        .value +"] "
                                                                   ;
                    formObject.rd_fxeml_fax_sndr_id    .value="COMPANY";
                    formObject.rd_fxeml_eml_sndr_nm    .value="COMPANY";
                    formObject.rd_fxeml_eml_rcvr_add   .value=""; // ||mjchang@COMPANY.com||gbkim@COMPANY.com||d.leys@be.COMPANY.com
                    var currDateEmail=ComGetNowInfo();
                    formObject.rd_fxeml_eml_atch_file  .value=currDateEmail+"_"+document.form.payc.value;
                    formObject.rd_fxeml_eml_templt     .value="EES_DMT_4011_01.html"; 
                    formObject.rd_fxeml_eml_tmplt_param.value="";
                    var attachYN="N";
                    if ( document.form.attachYN.checked )	attachYN="Y"; 
        			var ofc_cd=ComGetObjValue(formObject.h_usr_off);
        			var url="EES_DMT_4108.do"
        				+"?s_ofc_cd="+ofc_cd
        				+"&s_cust_cd="+ComGetObjValue(formObject.payc)
        				+"&s_bkg_no="+sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),  "bkgnoo")
        				+"&s_pod_cd="
        				+"&jspno=4011"
        				+"&telno="+ComGetObjValue(formObject.payr_cntc_pnt_phn_no)
        				+"&faxno="+ComGetObjValue(formObject.payr_cntc_pnt_fax_no)
        				+"&email="+ComGetObjValue(formObject.payr_cntc_pnt_eml)
        				+"&cntc_seq="+attachYN										
        				;
        			ComOpenWindowCenter(url, "EES_DMT_4108", "520","250", true);
                break;                 
                case "btn1_close":
                	ComClosePopup(); 
                break;
                case "btn1_detail_print": // DETAIL RD PRINT
                    if( sheetObjects[0].RowCount()==0 ) {
                        errMsg='No data found.';
                        ComShowMessage(msgs["CIM29030"]);
                        return;
                    }                    
                    rdOpen(document.form);
                break;
                case "btn1_down_excel":
                    if( sheetObjects[0].RowCount()== 0 ) {
                        errMsg='No data found.';
                        ComShowMessage(msgs["CIM29030"]);
                        return;
                    }                    
                    doActionIBSheet(sheetObjects[1],document.form,IBSEARCH_ASYNC03);
                     sheetObjects[1].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[1]), SheetDesign:1,Merge:1 });
                     //sheetObjects[1].SpeedDown2Excel(-1,false,false,"","/apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/script/EES_DMT_4011_XSL.xml");                    
                break;
                case "btn_sendinghistory": // 7006 OPEN
                    if(ComIsBtnEnable(srcName)) {
                        openPopupWindow(sheetObjects[0], formObject, srcName);
                    }
                break;
            } // end switch
        }catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e.message);
            }
        }
    }
    function openPopupWindow(sheetObj, formObj, srcName) {
        if(srcName == "btn_sendinghistory") {
            var url="EES_DMT_7006_P.do"
                +"?jspno=EES_DMT_4011"
                +"&invoice=&selectOpt=2"
                ;
            var returnValue=ComOpenWindowCenter(url, "EES_DMT_7006_P", "1036","650", true);
        }
    }     
    /**
     * print view open
     */
    function rdOpen4012(){ // RD PRINT DIALOG OPEN - OTS PRINT BTN
        var sXml4012="";      
        var i=0;
        var j=0; 
        if ( document.form.cntrinvno.value == "1" ) { // CNTR NO RD
            var opener_sheet_obj1=sheetObjects[2];
            var fromObj=new Array();
            var rdObj=new Array();
            fromObj[1]=document.form;                            
            rdObj[0]=opener_sheet_obj1;     
            sXml4012="<?xml version='1.0' encoding='UTF-8'?><SHEET>";
            sheetCnt=1;
            for(i=0;i<1;i++){
                sheetCnt=i+1;
                if(rdObj[i].RowCount()==0){
                    sXml4012  += "<SHEET"+sheetCnt+"><DATA TOTAL='0'><TR>";
                    for(j=0;j<=rdObj[i].LastCol();j++){
                        sXml4012 +="<TD></TD>";
                    }
                    sXml4012 +="</TR></DATA></SHEET"+sheetCnt+">";
                }else{
                    //sXml4012 +=RD_GetDataSearchXml(rdObj[i],sheetCnt);
//                    if (typeof rdObj[i] != "object" || rdObj[i].tagName != "OBJECT") {
//                        return "";
//                    }
                    var rowXml="";
                    var allXml="<SHEET" + sheetCnt + ">  <DATA TOTAL='"+ rdObj[i].GetTotalRows()+"'>";
                    var rowcount=rdObj[i].RowCount()+ rdObj[i].headerRows - 1;
                    for (ir=rdObj[i].HeaderRows(); ir <= rowcount; ir++) {
                    	if ( rdObj[i].GetCellValue(ir,1) == 1 ) {
                            rowXml="<TR>";
                            for (ic=0; ic<= rdObj[i].LastCol(); ic++) {
                            	rowXml += "<TD><![CDATA[" + rdObj[i].GetCellValue(ir,ic) + "]]></TD>";
                            }
                            rowXml += "</TR>";
                            allXml += rowXml;
                        }                    
                    }
                    allXml += "  </DATA></SHEET" + sheetCnt + ">";
                    sXml4012 += allXml;
                }           
            }
            sXml4012 +="<ETC>"; 
            sXml4012 +="    <OFC_ADD01>" + document.form.rpt_ofcadd01.value  + "</OFC_ADD01>";
            sXml4012 +="    <OFC_ADD02>" + document.form.rpt_ofcadd02.value  + "</OFC_ADD02>";
            sXml4012 +="    <OFC_ADD03>" + document.form.rpt_ofcadd03.value  + "</OFC_ADD03>";        
            sXml4012 +="    <CUST_NAME>" + document.form.rpt_custname .value + "</CUST_NAME>";
            sXml4012 +="    <ADDRESS01>" + document.form.rpt_address01.value + "</ADDRESS01>";
            sXml4012 +="    <ADDRESS02>" + document.form.rpt_address02.value + "</ADDRESS02>";
            sXml4012 +="    <ADDRESS03>" + document.form.rpt_address03.value + "</ADDRESS03>";
            sXml4012 +="    <ADDRESS04>" + document.form.rpt_address04.value + "</ADDRESS04>";
            sXml4012 +="    <COM_REF>"   + document.form.rpt_comref   .value + "</COM_REF>"  ;
            sXml4012 +="    <ATTN_NAME>" + document.form.rpt_attnname .value + "</ATTN_NAME>";
            sXml4012 +="    <CUST_CODE>" + document.form.rpt_custcode .value + "</CUST_CODE>";
            sXml4012 +="    <TEL_NO>"    + document.form.rpt_telno    .value + "</TEL_NO>"   ;
            sXml4012 +="    <FAX_NO>"    + document.form.rpt_faxno    .value + "</FAX_NO>"   ;
            sXml4012 +="    <CUST_VAT>"  + document.form.rpt_custvat  .value + "</CUST_VAT>" ;
            sXml4012 +="    <HEADER01>"  + document.form.rpt_header01 .value + "</HEADER01>" ;
            sXml4012 +="    <HEADER02>"  + document.form.rpt_header02 .value + "</HEADER02>" ;
            sXml4012 +="    <HEADER03>"  + document.form.rpt_header03 .value + "</HEADER03>" ;
            sXml4012 +="    <HEADER04>"  + document.form.rpt_header04 .value + "</HEADER04>" ;
            sXml4012 +="    <HEADER05>"  + document.form.rpt_header05 .value + "</HEADER05>" ;
            sXml4012 +="    <HEADER06>"  + document.form.rpt_header06 .value + "</HEADER06>" ;
            sXml4012 +="    <HEADER07>"  + document.form.rpt_header07 .value + "</HEADER07>" ;
            sXml4012 +="    <HEADER08>"  + document.form.rpt_header08 .value + "</HEADER08>" ;
            sXml4012 +="    <HEADER09>"  + document.form.rpt_header09 .value + "</HEADER09>" ;
            sXml4012 +="    <HEADER10>"  + document.form.rpt_header10 .value + "</HEADER10>" ;
            sXml4012 +="</ETC>";
            sXml4012 +="</SHEET>";
            if ( rdObj[0].RowCount()== "0")
            {
                errMsg='No data found.';
                showErrMessage(errMsg);
                return;
            }
//            rdObjects[0].AutoAdjust=0;
//            viewer.zoom=0
//            viewer.hideToolbar();
//            rdObjects[0].HideStatusBar();
//            rdObjects[0].ViewShowMode(1);
//            rdObjects[0].SetBackgroundColor(255,255,255);
//            rdObjects[0].SetPageLineColor(255,255,255);          
//            rdObjects[0].ApplyLicense("0.0.0.0");         
//            viewer.setRData(sXml4012);
            var tInvNo="";
            var tTrfType="";
            var tCreOf="";	//cre_ofc_cd
            for ( var z01=1 ; z01 < sheetObjects[0].RowCount()+1 ; z01++  ) {
            	if ( sheetObjects[0].GetCellValue(z01,1) == 1 ) {
            		tInvNo=sheetObjects[0].GetCellValue(z01,"invnoo") + "," + tInvNo;
            		tTrfType=sheetObjects[0].GetCellValue(z01,"tarftp") + "," + tTrfType;
            		tCreOf=sheetObjects[0].GetCellValue(z01,"isseof") + "," + tCreOf;
                }
            }
            document.form.invno.value=tInvNo;
            document.form.creof.value=tCreOf;
            
    		var appendReport = [];
    		
    		if ( document.form.cntrinvno.value == "1" && document.form.rpt_leftright.value == "L" ) {
    			var mrdPath1 = RD_path+'apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4905.mrd';
    		} else if ( document.form.cntrinvno.value == "1" && document.form.rpt_leftright.value == "R" ) {
    			var mrdPath1 = RD_path+'apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4906.mrd';
    		}
            
            var rdParam1=" /rwait /rp [" + document.form.arif .value +"] " +
                                                                   "[" + document.form.frdt .value +"] " +
                                                                   "[" + document.form.todt .value +"] " +
                                                                   "[" + document.form.isof .value +"] " +
                                                                   "[" + document.form.payc .value +"] " +
                                                                   "[" + document.form.payc .value +"] " +
                                                                   "[" + document.form.payc .value +"] " +
                                                                   "[" + document.form.payc .value +"] " +
                                                                   "[" + document.form.payc .value +"] " +
                                                                   //"[" + document.form.tftp2.value +"] " +
                                                                   "[" + tTrfType +"]"+
                                                                   "[" + document.form.scno .value +"] " +
                                                                   "[" + document.form.scno .value +"] " +
                                                                   "[" + document.form.rfan .value +"] " +
                                                                   "[" + document.form.rfan .value +"] " +
                                                                   "[" + document.form.cuno .value +"] " +
                                                                   "[" + document.form.cuno .value +"] " +
                                                                   "[" + document.form.cuno .value +"] " +
                                                                   "[" + document.form.cuno .value +"] " +
                                                                   "[" + document.form.cuno .value +"] " +
                                                                   "[" + document.form.cutp .value +"] " +
                                                                   "[" + document.form.cutp .value +"] " +
                                                                   "[" + document.form.cutp .value +"] " + 
                                                                   "[*** " + document.form.rpt_opttitle .value +" ***] " +
                                                                   "[" + document.form.rpt_ofcadd01 .value +"] " +
                                                                   "[" + document.form.rpt_ofcadd02 .value +"] " +
                                                                   "[" + document.form.rpt_ofcadd03 .value +"] " +
                                                                   "[" + ComReplaceStr(document.form.rpt_custname .value,"'"," ") +"] " +
                                                                   "[" + document.form.rpt_address01.value +"] " +
                                                                   "[" + document.form.rpt_address02.value +"] " +
                                                                   "[" + document.form.rpt_address03.value +"] " +
                                                                   "[" + document.form.rpt_address04.value +"] " +
                                                                   "[" + document.form.rpt_comref   .value +"] " +
                                                                   "[" + document.form.rpt_attnname .value +"] " +
                                                                   "[" + document.form.rpt_custcode .value +"] " +
                                                                   "[" + document.form.payr_cntc_pnt_phn_no.value +"] " +
                                                                   "[" + document.form.payr_cntc_pnt_fax_no.value +"] " +
                                                                   "[" + document.form.rpt_custvat  .value +"] " +
                                                                   "[" + document.form.remark01     .value +"] " +
                                                                   "[" + document.form.remark02     .value +"] " +
                                                                   "[" + document.form.rpt_header01 .value +"] " +
                                                                   "[" + document.form.rpt_header02 .value +"] " +
                                                                   "[" + document.form.rpt_header03 .value +"] " +
                                                                   "[" + document.form.rpt_header04 .value +"] " +
                                                                   "[" + document.form.rpt_header05 .value +"] " +
                                                                   "[" + document.form.rpt_header06 .value +"] " +
                                                                   "[" + document.form.rpt_header07 .value +"] " +
                                                                   "[" + document.form.rpt_header08 .value +"] " +
                                                                   "[" + document.form.rpt_header09 .value +"] " +
                                                                   "[" + document.form.rpt_header10 .value +"] " +
                                                                   "[" + document.form.rpt_custref  .value +"] " +
                                                                   "[" + document.form.rpt_telfax   .value +"] " +
                                                                   "[" + document.form.rpt_custvatno.value +"] " + 
                                                                   "[" + document.form.invno        .value +"] " +
                                                                   "[" + document.form.creof		.value +"] "
                                                                   ;
//            rdObjects[0].SetAppendReport(0);
            var mrdParam1 = RDServer+rdParam1;
    		appendReport.push({mrdPath:mrdPath1,mrdParam:mrdParam1});
    		
//            var appendReport = [];
//            var mrdpath1 = '';
//            if ( document.form.cntrinvno.value == "1" && document.form.rpt_leftright.value == "L" ) {
////                viewer.openFile(RD_path+'apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4905.mrd',RDServer+rdParam);
//                mrdpath1 = RD_path+'apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4905.mrd';
//            } else if ( document.form.cntrinvno.value == "1" && document.form.rpt_leftright.value == "R" ) {
////            	viewer.openFile(RD_path+'apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4906.mrd',RDServer+rdParam);
//                mrdpath1 = RD_path+'apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4906.mrd';
//            }  
//            var param1 = RDServer+rdParam;
//            
//            appendReport = [
//                    {mrdPath : mrdpath1, mrdParam : param1}
//            ];
            
            if ( document.form.attachYN.checked ) {
                var tInvNo="";            
                for ( var z01=1 ; z01 < sheetObjects[0].RowCount()+1 ; z01++  ) {
                	if ( sheetObjects[0].GetCellValue(z01,1) == 1 ) {
                		tInvNo=sheetObjects[0].GetCellValue(z01,3) + "," + tInvNo;
                    }
                }
                document.form.invno.value=tInvNo;
                var rdParam2="/rp [" + document.form.invno.value + "] [" + document.form.isof.value + "] [" + document.form.creof.value + "]" ;
//                rdObjects[0].SetAppendReport(1);
                var mrdPath2 = RD_path+'apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4907.mrd';
                var mrdParam2 = RDServerBAT + rdParam2;

//        		appendReport.push({mrdPath:mrdPath1,mrdParam:mrdParam1});
        		appendReport.push({mrdPath:mrdPath2,mrdParam:mrdParam2});
//                appendReport = [
//                        {mrdPath : mrdpath1, mrdParam : param1},
//                        {mrdPath : mrdpath2, mrdParam : param2}
//                ];
//                viewer.openFile(RD_path+'apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4907.mrd', RDServerBAT + rdParam2);
            }

    		directReportDownload(appendReport);
//            viewer.openFile(appendReport, {timeout:1800});
//            viewer.print({isServerSide:true});
        } else { // INVOICE NO RD
            var opener_sheet_obj1=sheetObjects[0];
            var fromObj=new Array();
            var rdObj=new Array();
            fromObj[1]=document.form;                            
            rdObj[0]=opener_sheet_obj1;     
            sXml4012="<?xml version='1.0' encoding='UTF-8'?><SHEET>";
            sheetCnt=1;
            for(i=0;i<1;i++){
                sheetCnt=i+1;
                if(rdObj[i].RowCount()==0){
                    sXml4012  += "<SHEET"+sheetCnt+"><DATA TOTAL='0'><TR>";
                    for(j=0;j<=rdObj[i].LastCol();j++){
                        sXml4012 +="<TD></TD>";
                    }
                    sXml4012 +="</TR></DATA></SHEET"+sheetCnt+">";
                }else{
//                    if (typeof rdObj[i] != "object" || rdObj[i].tagName != "OBJECT") {
//                        return "";
//                    }
                    var rowXml="";
                    var allXml="<SHEET" + sheetCnt + ">  <DATA TOTAL='"+ rdObj[i].GetTotalRows()+"'>";
                    var rowcount=rdObj[i].RowCount()+ rdObj[i].headerRows - 1;
                    for (ir=rdObj[i].HeaderRows(); ir <= rowcount; ir++) {
                    	if ( rdObj[i].GetCellValue(ir,1) == 1 ) {
                            rowXml="<TR>";
                            for (ic=0; ic<= rdObj[i].LastCol(); ic++) {
                            	rowXml += "<TD><![CDATA[" + rdObj[i].GetCellValue(ir,ic) + "]]></TD>";
                            }
                            rowXml += "</TR>";
                            allXml += rowXml;
                        }                    
                    }
                    allXml += "  </DATA></SHEET" + sheetCnt + ">";
                    sXml4012 += allXml;
                }           
            }
            sXml4012 +="<ETC>"; 
            sXml4012 +="    <OFC_ADD01>" + document.form.rpt_ofcadd01.value  + "</OFC_ADD01>";
            sXml4012 +="    <OFC_ADD02>" + document.form.rpt_ofcadd02.value  + "</OFC_ADD02>";
            sXml4012 +="    <OFC_ADD03>" + document.form.rpt_ofcadd03.value  + "</OFC_ADD03>";        
            sXml4012 +="    <CUST_NAME>" + document.form.rpt_custname .value + "</CUST_NAME>";
            sXml4012 +="    <ADDRESS01>" + document.form.rpt_address01.value + "</ADDRESS01>";
            sXml4012 +="    <ADDRESS02>" + document.form.rpt_address02.value + "</ADDRESS02>";
            sXml4012 +="    <ADDRESS03>" + document.form.rpt_address03.value + "</ADDRESS03>";
            sXml4012 +="    <ADDRESS04>" + document.form.rpt_address04.value + "</ADDRESS04>";
            sXml4012 +="    <COM_REF>"   + document.form.rpt_comref   .value + "</COM_REF>"  ;
            sXml4012 +="    <ATTN_NAME>" + document.form.rpt_attnname .value + "</ATTN_NAME>";
            sXml4012 +="    <CUST_CODE>" + document.form.rpt_custcode .value + "</CUST_CODE>";
            sXml4012 +="    <TEL_NO>"    + document.form.rpt_telno    .value + "</TEL_NO>"   ;
            sXml4012 +="    <FAX_NO>"    + document.form.rpt_faxno    .value + "</FAX_NO>"   ;
            sXml4012 +="    <CUST_VAT>"  + document.form.rpt_custvat  .value + "</CUST_VAT>" ;
            sXml4012 +="    <HEADER01>"  + document.form.rpt_header01 .value + "</HEADER01>" ;
            sXml4012 +="    <HEADER02>"  + document.form.rpt_header02 .value + "</HEADER02>" ;
            sXml4012 +="    <HEADER03>"  + document.form.rpt_header03 .value + "</HEADER03>" ;
            sXml4012 +="    <HEADER04>"  + document.form.rpt_header04 .value + "</HEADER04>" ;
            sXml4012 +="    <HEADER05>"  + document.form.rpt_header05 .value + "</HEADER05>" ;
            sXml4012 +="    <HEADER06>"  + document.form.rpt_header06 .value + "</HEADER06>" ;
            sXml4012 +="    <HEADER07>"  + document.form.rpt_header07 .value + "</HEADER07>" ;
            sXml4012 +="    <HEADER08>"  + document.form.rpt_header08 .value + "</HEADER08>" ;
            sXml4012 +="    <HEADER09>"  + document.form.rpt_header09 .value + "</HEADER09>" ;
            sXml4012 +="    <HEADER10>"  + document.form.rpt_header10 .value + "</HEADER10>" ;
            sXml4012 +="</ETC>";
            sXml4012 +="</SHEET>";
            if ( rdObj[0].RowCount()== "0")
            {
                errMsg='No data found.';
                showErrMessage(errMsg);
                return;
            }
//            rdObjects[0].AutoAdjust=0;
//            viewer.zoom=0;
//            viewer.hideToolbar();
//            rdObjects[0].HideStatusBar();
//            rdObjects[0].ViewShowMode(1);
//            rdObjects[0].SetBackgroundColor(255,255,255);
//            rdObjects[0].SetPageLineColor(255,255,255);     
//            rdObjects[0].ApplyLicense("0.0.0.0");     
//            viewer.setRData(sXml4012);
            document.form.rpt_contents.value=sXml4012;
            var tInvNo="";
            var tTrfType="";
            for ( var z01=1 ; z01 < sheetObjects[0].RowCount()+1 ; z01++  ) {
            	if ( sheetObjects[0].GetCellValue(z01,1) == 1 ) {
            		tInvNo=sheetObjects[0].GetCellValue(z01,"invnoo") + "," + tInvNo;
            		tTrfType=sheetObjects[0].GetCellValue(z01,"tarftp") + "," + tTrfType;
            		tCreOf=sheetObjects[0].GetCellValue(z01,"isseof") + "," + tCreOf;
                }
            }

            document.form.invno.value=tInvNo;
            document.form.creof.value=tCreOf;
            
    		var appendReport = [];
    		
    		if ( document.form.cntrinvno.value == "0" && document.form.rpt_leftright.value == "L" ) {
    			var mrdPath1 = RD_path+'apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4903.mrd';
    		} else if ( document.form.cntrinvno.value == "0" && document.form.rpt_leftright.value == "R" ) {
    			var mrdPath1 = RD_path+'apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4904.mrd';
    		}
            
            var rdParam1=" /rwait /rp [" + document.form.arif .value +"] " +
                                                                   "[" + document.form.frdt .value +"] " +
                                                                   "[" + document.form.todt .value +"] " +
                                                                   "[" + document.form.isof .value +"] " +
                                                                   "[" + document.form.payc .value +"] " +
                                                                   "[" + document.form.payc .value +"] " +
                                                                   "[" + document.form.payc .value +"] " +
                                                                   "[" + document.form.payc .value +"] " +
                                                                   "[" + document.form.payc .value +"] " +
                                                                   //"[" + document.form.tftp2.value +"] " +
                                                                   "[" + tTrfType +"] " +
                                                                   "[" + document.form.scno .value +"] " +
                                                                   "[" + document.form.scno .value +"] " +
                                                                   "[" + document.form.rfan .value +"] " +
                                                                   "[" + document.form.rfan .value +"] " +
                                                                   "[" + document.form.cuno .value +"] " +
                                                                   "[" + document.form.cuno .value +"] " +
                                                                   "[" + document.form.cuno .value +"] " +
                                                                   "[" + document.form.cuno .value +"] " +
                                                                   "[" + document.form.cuno .value +"] " +
                                                                   "[" + document.form.cutp .value +"] " +
                                                                   "[" + document.form.cutp .value +"] " +
                                                                   "[" + document.form.cutp .value +"] " + 
                                                                   "[*** " + document.form.rpt_opttitle .value +" ***] " +
                                                                   "[" + document.form.rpt_ofcadd01 .value +"] " +
                                                                   "[" + document.form.rpt_ofcadd02 .value +"] " +
                                                                   "[" + document.form.rpt_ofcadd03 .value +"] " +
                                                                   "[" + ComReplaceStr(document.form.rpt_custname .value,"'"," ") +"] " +
                                                                   "[" + document.form.rpt_address01.value +"] " +
                                                                   "[" + document.form.rpt_address02.value +"] " +
                                                                   "[" + document.form.rpt_address03.value +"] " +
                                                                   "[" + document.form.rpt_address04.value +"] " +
                                                                   "[" + document.form.rpt_comref   .value +"] " +
                                                                   "[" + document.form.rpt_attnname .value +"] " +
                                                                   "[" + document.form.rpt_custcode .value +"] " +
                                                                   "[" + document.form.payr_cntc_pnt_phn_no.value +"] " +
                                                                   "[" + document.form.payr_cntc_pnt_fax_no.value +"] " +
                                                                   "[" + document.form.rpt_custvat  .value +"] " +
                                                                   "[" + document.form.remark01     .value +"] " +
                                                                   "[" + document.form.remark02     .value +"] " +
                                                                   "[" + document.form.rpt_header01 .value +"] " +
                                                                   "[" + document.form.rpt_header02 .value +"] " +
                                                                   "[" + document.form.rpt_header03 .value +"] " +
                                                                   "[" + document.form.rpt_header04 .value +"] " +
                                                                   "[" + document.form.rpt_header05 .value +"] " +
                                                                   "[" + document.form.rpt_header06 .value +"] " +
                                                                   "[" + document.form.rpt_header07 .value +"] " +
                                                                   "[" + document.form.rpt_header08 .value +"] " +
                                                                   "[" + document.form.rpt_header09 .value +"] " +
                                                                   "[" + document.form.rpt_header10 .value +"] " +
                                                                   "[" + document.form.rpt_custref  .value +"] " +
                                                                   "[" + document.form.rpt_telfax   .value +"] " +
                                                                   "[" + document.form.rpt_custvatno.value +"] " + 
                                                                   "[" + document.form.invno        .value +"] " +
                                                                   "[" + document.form.creof        .value +"] "
                                                                   ;
//            rdObjects[0].SetAppendReport(0);
            var mrdParam1 = RDServer+rdParam1;
    		appendReport.push({mrdPath:mrdPath1,mrdParam:mrdParam1});
    		
//            var appendReport = [];
//            var mrdpath1 = '';
//            if ( document.form.cntrinvno.value == "0" && document.form.rpt_leftright.value == "L" ) {
////                rdObjects[0].FileOpen(RD_path+'apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4903.mrd',RDServer+rdParam);
//                mrdpath1 = RD_path+'apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4903.mrd';
//            } else if ( document.form.cntrinvno.value == "0" && document.form.rpt_leftright.value == "R" ) {
////                rdObjects[0].FileOpen(RD_path+'apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4904.mrd',RDServer+rdParam);
//                mrdpath1 = RD_path+'apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4904.mrd';
//            }      
//            var param1 = RDServer+rdParam;
//            
//            appendReport = [
//                    {mrdPath : mrdpath1, mrdParam : param1}
//            ];
            
            if ( document.form.attachYN.checked ) {
                var rdParam2="/rp [" + document.form.invno.value + "] [" + document.form.isof.value + "] [" + document.form.creof.value + "]" ;
//                rdObjects[0].SetAppendReport(1);
                var mrdPath2 = RD_path+'apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4907.mrd';
                var mrdParam2 = RDServerBAT + rdParam2;

//        		appendReport.push({mrdPath:mrdPath1,mrdParam:mrdParam1});
        		appendReport.push({mrdPath:mrdPath2,mrdParam:mrdParam2});
        		
//                appendReport = [
//                        {mrdPath : mrdpath1, mrdParam : param1},
//                        {mrdPath : mrdpath2, mrdParam : param2}
//                ];
//                rdObjects[0].FileOpen(RD_path+'apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4907.mrd', RDServerBAT + rdParam2);
            }

    		directReportDownload(appendReport);
//            viewer.openFile(appendReport, {timeout:1800});
//            viewer.print({isServerSide:true});
        }
    }    
    /**
     * Register as an array IBSheet Object
     * The next batch of other items when you need treatment of fiberglass can add to an array that holds the process
     * Array defined at the top of the source
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    function setComboObject(combo_obj) {  
         comboObjects[comboCnt++]=combo_obj;  
    }
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
    	 var opener=window.dialogArguments;
    	 if(!opener) opener=parent;
    	 var opnSheetObj=opener.sheet1;
    	 ComSetObjValue(document.form.payn, opnSheetObj.GetCellValue(opnSheetObj.GetSelectRow(), "payern"));
    	 ComSetObjValue(document.form.rpt_custname, opnSheetObj.GetCellValue(opnSheetObj.GetSelectRow(), "payern"));
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        for(var k=0;k<comboObjects.length;k++){
            initCombo(comboObjects[k],k+1);
        }        
        doActionIBCombo(sheetObjects[3], document.form, COMMAND02, COMMAND02, "", "");
        
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
        doActionIBSheet(sheetObjects[2],document.form,IBSEARCH_ASYNC04);
        
        doInit();
    }
    function doInit() {
        var sheetObj=sheetObjects[0]; 
        var formObj=document.form;
        ComSetObjValue(formObj.payer_cd, formObj.payc);
        ComSetObjValue(formObj.payer_nm, formObj.payn);
        searchAttentionList();
    }
    function searchAttentionList() {
        setPayerCd();
        var sheetObj=sheetObjects[3];
        var comboObj=comboObjects[0];
        var formObj=document.form;
        if(ComGetObjValue(formObj.payer_cd) == null || ComGetObjValue(formObj.payer_cd) == "") {
            comboObj.RemoveAll();
            return;
        }
        ComSetObjValue(formObj.ofc_cd, ComGetObjValue(formObj.h_usr_off));
        doActionIBCombo(sheetObj,formObj,IBSEARCH,SEARCHLIST03,"ATTENTION", comboObj);
    }    
    function setPayerCd() {
        var formObj=document.form;
        var payer_cd=ComGetObjValue(formObj.payc);
        var cust_cnt_cd="";
        var cust_seq="";
        //Service Provider
        if(payer_cd.length == 6) {
            cust_cnt_cd="00";
            cust_seq=payer_cd;
        }else if(payer_cd.length == 8){
            cust_cnt_cd=payer_cd.substring(0,2);
            cust_seq=payer_cd.substring(2);
        }else{
            ComSetObjValue(formObj.payer_cd, "");
            ComSetObjValue(formObj.cust_cnt_cd, "");
            ComSetObjValue(formObj.cust_seq, "");
            return;
        }
        ComSetObjValue(formObj.cust_cnt_cd, cust_cnt_cd);
        ComSetObjValue(formObj.cust_seq, cust_seq);
    }     
     /**
     * Combo basic setting 
     * param : comboObj ==> combo object, comboNo ==> Combo object ID of the tag attached to the serial number
     * If the number of combo a combo by adding the number of case sheets to initialize the module configuration 
     */ 
    function initCombo(comboObj, comboNo) {
        var formObj=document.form
        switch(comboNo) { 
            //Attention
            case 1:
                with (comboObj) {
                    SetMultiSelect(0);
                    SetColAlign(0, "left");
                    SetColAlign(1, "left");
                    SetColAlign(2, "left");
                    SetColAlign(3, "left");
                    SetDropHeight(160);
                }
                break;
         }      
    } 
    function rdOpen(formObject){ // DETAIL RD PRINT - Detail Print BTN
//        var Rdviewer=rdObject ;
//        rdObjects[0].AutoAdjust=0;
//        Rdviewer.zoom=0
//        Rdviewer.hideToolbar();
//        rdObjects[0].HideStatusBar();
//        rdObjects[0].ViewShowMode(1);
//        rdObjects[0].SetBackgroundColor(255,255,255);
//        rdObjects[0].SetPageLineColor(255,255,255);    
//        Rdviewer.ApplyLicense("0.0.0.0");        
        var tInvNo="";      
        var tCreOf="";	//cre_ofc_cd
        for ( var z01=1 ; z01 < sheetObjects[0].RowCount()+1 ; z01++  ) {
        	if ( sheetObjects[0].GetCellValue(z01,1) == 1 ) {
        		tInvNo=sheetObjects[0].GetCellValue(z01,"invnoo") + "," + tInvNo;
        		tCreOf=sheetObjects[0].GetCellValue(z01,"isseof") + "," + tCreOf;
            }
        }
        document.form.invno.value=tInvNo;
        document.form.creof.value=tCreOf;
        
        var appendReport = [];
		var mrdPath = RD_path+'apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4907.mrd';
		var mrdParam = RDServerBAT + " /rwait /rp [" + document.form.invno.value + "] [" + document.form.isof.value + "] [" + document.form.creof.value + "]";
		appendReport.push({mrdPath:mrdPath,mrdParam:mrdParam});
		directReportDownload(appendReport);
        
//        var rdParam=" /rwait /rp [" + document.form.invno.value + "] [" + document.form.isof.value + "] [" + document.form.creof.value + "]" ;
////        rdObjects[0].SetAppendReport(0);
//        Rdviewer.openFile(RD_path+'apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4907.mrd', RDServerBAT + rdParam, {timeout:1800});
//        Rdviewer.print({isServerSide:true});
    }     
  /**
     * Sheet the initial setting, the header definition
     * param : sheetObj ==> sheet object, sheetNo ==> Sheet object ID of the tag attached to the serial number
     * Many case as the number of sheets to add the sheet, a sheet should initialize the module configuration
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        var sheetID=sheetObj.id;
        switch(sheetID) {
        case "sheet1":
			with(sheetObj){
				 var HeadTitle="||Seq.|INV No.|VVD CD|BKG No.|B/L No.|Cur.|Billing AMT|TAX AMT|Payable AMT|Type|Issue DT|INV Over Days||||";
				
				 SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
				
				 var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				 var headers = [ { Text:HeadTitle, Align:"Center"} ];
				 InitHeaders(headers, info);
				
				 var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"Status" },
				{Type:"CheckBox",  Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"CheckBox" },
				{Type:"Seq",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"SEQ" },
				{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"invnoo",    KeyField:0,   CalcLogic:"",   Format:"" },
				{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vvdcdd",    KeyField:0,   CalcLogic:"",   Format:"" },
				{Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:"bkgnoo",    KeyField:0,   CalcLogic:"",   Format:"" },
				{Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"blnooo",    KeyField:0,   CalcLogic:"",   Format:"" },
				{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"currcy",    KeyField:0,   CalcLogic:"",   Format:"" },
				{Type:"Float",     Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:"bilamt",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
				{Type:"Float",     Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:"taxamt",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
				{Type:"Float",     Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:"invamt",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
				{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"tarftp",    KeyField:0,   CalcLogic:"",   Format:"" },
				{Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"issedt",    KeyField:0,   CalcLogic:"",   Format:"Ymd" },
				{Type:"Int",       Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"invovd",    KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
				{Type:"Text",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"comamt",    KeyField:0,   CalcLogic:"",   Format:"" },
				{Type:"Text",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"isseof",    KeyField:0,   CalcLogic:"",   Format:"" },
				{Type:"Text",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"payrcd",    KeyField:0,   CalcLogic:"",   Format:"" },
				{Type:"Text",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"sheetp",    KeyField:0,   CalcLogic:"",   Format:"" } ];
				  
				 InitColumns(cols);
				
				 SetEditable(0);
				 SetToolTipText(0,"invovd","Over Days from Invoice Issued date");
				 SetSheetHeight(339);
        	}
		break;
		
        case "sheet2":     
            with(sheetObj){
                
              var HeadTitle1="SEQ|Invoice No|Charge|VVD|S/C No.|B/L No|LOC|CNTR|TS|From DT|To DT|F/T CMNC|F/T End|F/D|Over|CUR|Net Amount|Tax Amount|Total Amount|Issue Date|INV Over Day";

              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );

              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"SEQ" },
                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"invnoo",  KeyField:0,   CalcLogic:"",   Format:"" },
                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"charge",  KeyField:0,   CalcLogic:"",   Format:"" },
                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vvdcdd",  KeyField:0,   CalcLogic:"",   Format:"" },
                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"scnooo",  KeyField:0,   CalcLogic:"",   Format:"" },
                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"blnooo",  KeyField:0,   CalcLogic:"",   Format:"" },
                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"loccdd",  KeyField:0,   CalcLogic:"",   Format:"" },
                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntrno",  KeyField:0,   CalcLogic:"",   Format:"" },
                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"tyszcd",  KeyField:0,   CalcLogic:"",   Format:"" },
                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"stpdfr",  KeyField:0,   CalcLogic:"",   Format:"" },
                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"stpdto",  KeyField:0,   CalcLogic:"",   Format:"" },
                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ftcmnc",  KeyField:0,   CalcLogic:"",   Format:"" },
                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ftcmpl",  KeyField:0,   CalcLogic:"",   Format:"" },
                     {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"freedy",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                     {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"overdy",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"currcy",  KeyField:0,   CalcLogic:"",   Format:"" },
                     {Type:"Float",     Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:"netamt",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2 },
                     {Type:"Float",     Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:"taxamt",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2 },
                     {Type:"Float",     Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:"totamt",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2 },
                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"issudt",  KeyField:0,   CalcLogic:"",   Format:"" },
                     {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"oveday",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" } ];
               
              InitColumns(cols);

              SetEditable(0);
              SetVisible(0);
              SetSheetHeight(340);
            }
        break;
        
            case "sheet3":      
                with(sheetObj){
		                
		              var HeadTitle="||Seq.|INV No.|VVD CD|BKG No.|B/L No.|CNTR No.|TP/SZ CD|Cur.|Billing AMT|TAX AMT|Payable AMT|Type|Issue DT|INV Over Days|||";
		
		              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		
		              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"Status" },
		                     {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"CheckBox" },
		                     {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"SEQ" },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"invnoo",    KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"vvdcdd",    KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:"bkgnoo",    KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"blnooo",    KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"cntrno",    KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"tpszcd",    KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"currcy",    KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Float",     Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:"bilamt",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
		                     {Type:"Float",     Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:"taxamt",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
		                     {Type:"Float",     Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:"invamt",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2 },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"tarftp",    KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"issedt",    KeyField:0,   CalcLogic:"",   Format:"Ymd" },
		                     {Type:"Int",       Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"invovd",    KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                     {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"comamt",    KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"isseof",    KeyField:0,   CalcLogic:"",   Format:"" },
		                     {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"payrcd",    KeyField:0,   CalcLogic:"",   Format:"" } ];
		               
		              InitColumns(cols);

		              SetEditable(0);
		              SetVisible(0);
		              SetSheetHeight(340);
                    }


            break;
            case 4: 
                with(sheetObj){
                
             var HeadTitle="";
             var headCount=ComCountHeadTitle(HeadTitle);
             (headCount, 0, 0, true);
             }

             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

             var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
             var headers = [ { Text:HeadTitle, Align:"Center"}];
             InitHeaders(headers, info);

             var cols = [  ];
              
             InitColumns(cols);

             SetEditable(1);
            // SetGetCountPosition()(0);
             SetSheetHeight(130);

                break;             
        }
    }
  // Sheet processing-related processes
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
            case IBSEARCH:      
                formObj.f_cmd.value=SEARCH;
                sheetObj = sheetObj.Reset();
                sheetObjects[0] = sheetObj;
                initSheet(sheetObj, 0);
                sheetObj.SetWaitImageVisible(0);
                var sXml=sheetObj.GetSearchData("EES_DMT_4011GS.do", FormQueryString(formObj));
                sheetObj.LoadSearchData(sXml, {Sync:1});
            break;
            
            case IBSEARCH_ASYNC01:      
                formObj.f_cmd.value=SEARCH01; // searchOTSInquiryByDetailListRemark
                sheetObj.SetWaitImageVisible(0);
                 var sXml=sheetObj.GetSearchData("EES_DMT_4011GS.do",FormQueryString(formObj));
                var rtnRemark=ComGetEtcData(sXml, "rtnRemark");
                    if ( rtnRemark != undefined && rtnRemark != '') {
                    var paryInfoArr=rtnRemark.split("|");
                    var paryInfoArr2=paryInfoArr[0].split("\n");
                    if ( !ComIsEmpty(paryInfoArr2[0]) ) {
                        document.form.remark01.value=ComReplaceStr(paryInfoArr2[0],"'"," ");
                    } else {
                        document.form.remark01.value="";
                    }
                    if ( !ComIsEmpty(paryInfoArr2[1]) ) {
                        document.form.remark02.value=ComReplaceStr(paryInfoArr2[1],"'"," ");
                    } else {
                        document.form.remark02.value="";
                    }
                    if ( !ComIsEmpty ( paryInfoArr[2] ) ) {
                        var paryInfoAddr=paryInfoArr[2].split("\n");
                        var paryInfoAddrCnt=paryInfoAddr.length;
                        if ( paryInfoAddrCnt >= 1 ) {
                            document.form.rpt_address01.value=ComReplaceStr(paryInfoAddr[0],"'"," ");
                        } else {
                            document.form.rpt_address01.value="";
                        }
                        if ( paryInfoAddrCnt >= 2 ) {
                            document.form.rpt_address02.value=ComReplaceStr(paryInfoAddr[1],"'"," ");
                        } else {
                            document.form.rpt_address02.value="";
                        }
                        if ( paryInfoAddrCnt >= 3 ) {
                            document.form.rpt_address03.value=ComReplaceStr(paryInfoAddr[2],"'"," ");
                        } else {
                            document.form.rpt_address03.value="";
                        }
                        if ( paryInfoAddrCnt >= 4 ) {
                            document.form.rpt_address04.value=ComReplaceStr(paryInfoAddr[3],"'"," ");
                        } else {
                            document.form.rpt_address04.value="";
                        }
                    } else {
                        document.form.rpt_address01.value=ComReplaceStr(paryInfoArr[2],"'"," ");
                        document.form.rpt_address02.value=ComReplaceStr(paryInfoArr[2],"'"," ");
                        document.form.rpt_address03.value=ComReplaceStr(paryInfoArr[2],"'"," ");
                        document.form.rpt_address04.value=ComReplaceStr(paryInfoArr[2],"'"," ");
                    }
                    document.form.rpt_telno.value=paryInfoArr[3];
                    document.form.rpt_faxno.value=paryInfoArr[4];
                    document.form.rpt_custvat.value=paryInfoArr[6];
                }
            break;
            
            case IBSEARCH_ASYNC02:      
                formObj.f_cmd.value=SEARCH02; // searchOTSInquiryByDetailListRemark2
                sheetObj.SetWaitImageVisible(0);
                 var sXml=sheetObj.GetSearchData("EES_DMT_4011GS.do",FormQueryString(formObj));
                var rtnRemark=ComGetEtcData(sXml, "rtnRemark");
                if ( rtnRemark != undefined && rtnRemark != '') {
                    //PAYR.DMDT_PAYR_OTS_RMK
                    //PAYR.DMDT_PAYR_ADDR
                    //PAYR.DMDT_PAYR_PHN_NO
                    //PAYR.DMDT_PAYR_FAX_NO
                    //CUST.CUST_RGST_NO
                    var paryInfoArr=rtnRemark.split("|");
                    document.form.rpt_ofcadd01 .value=ComReplaceStr(paryInfoArr[0],"'"," ");
                    document.form.rpt_ofcadd02 .value=ComReplaceStr(paryInfoArr[1],"'"," ");
                    document.form.rpt_ofcadd03 .value=ComReplaceStr(paryInfoArr[2],"'"," ");
                    document.form.rpt_header01 .value=ComReplaceStr(paryInfoArr[3],"'"," ");
                    document.form.rpt_header02 .value=ComReplaceStr(paryInfoArr[4],"'"," ");
                    document.form.rpt_header03 .value=ComReplaceStr(paryInfoArr[5],"'"," ");
                    document.form.rpt_header04 .value=ComReplaceStr(paryInfoArr[6],"'"," ");
                    document.form.rpt_header05 .value=ComReplaceStr(paryInfoArr[7],"'"," ");
                    document.form.rpt_header06 .value=ComReplaceStr(paryInfoArr[8],"'"," ");
                    document.form.rpt_header07 .value=ComReplaceStr(paryInfoArr[9],"'"," ");
                    document.form.rpt_header08 .value=ComReplaceStr(paryInfoArr[10],"'"," ");
                    document.form.rpt_header09 .value=ComReplaceStr(paryInfoArr[11],"'"," ");
                    document.form.rpt_header10 .value=ComReplaceStr(paryInfoArr[12],"'"," ");
                    document.form.rpt_leftright.value=paryInfoArr[13];
                    document.form.rpt_opttitle .value=paryInfoArr[14];
                    document.form.rpt_custref  .value=paryInfoArr[15];
                    document.form.rpt_telfax   .value=paryInfoArr[16];
                    document.form.rpt_custvatno.value=paryInfoArr[17];
                } else {
                    document.form.rpt_leftright.value="L";
                }
            break;   
            
            case IBSEARCH_ASYNC03:      
                formObj.f_cmd.value=SEARCH03; // searchOTSInquiryByDetailList2
                sheetObj = sheetObj.Reset();
                sheetObjects[1] = sheetObj;
                initSheet(sheetObj, 1);
                var tInvNo="";            
                var tCreOf="";
                for ( var z01=1 ; z01 < sheetObjects[0].RowCount()+1 ; z01++  ) {
                	if ( sheetObjects[0].GetCellValue(z01,1) == 1 ) {
                		tInvNo=sheetObjects[0].GetCellValue(z01,"invnoo") + "," + tInvNo;
                		tCreOf=sheetObjects[0].GetCellValue(z01,"isseof") + "," + tCreOf;
                    }
                }
                document.form.invno.value=tInvNo;
                document.form.creof.value=tCreOf;
                sheetObj.SetWaitImageVisible(0);

                // 조회처리를 동기방식으로 변경함. 2014.08.26
                //sheetObj.DoSearch("EES_DMT_4011GS.do", FormQueryString(formObj));
                var sXml=sheetObj.GetSearchData("EES_DMT_4011GS.do", FormQueryString(formObj));
                sheetObj.LoadSearchData(sXml, {Sync:1});                
            break; 
            
            case IBSEARCH_ASYNC04:   
                formObj.f_cmd.value=SEARCH04; // searchOTSInquiryByDetailList3
                sheetObj = sheetObj.Reset();
                sheetObjects[2] = sheetObj;
                initSheet(sheetObj, 2);
                sheetObj.SetWaitImageVisible(0);
                
                // 조회처리를 동기방식으로 변경함. 2014.08.26
                //sheetObj.DoSearch("EES_DMT_4011GS.do", FormQueryString(formObj));
                var sXml=sheetObj.GetSearchData("EES_DMT_4011GS.do", FormQueryString(formObj));
                sheetObj.LoadSearchData(sXml, {Sync:1}); 
            break;
            
            case IBSEARCH_ASYNC05:      // FAX SEND
                formObj.f_cmd.value=SEARCH05; // searchCountryListByRHQ
                sheetObj = sheetObj.Reset();
                sheetObjects[1] = sheetObj;
                initSheet(sheetObj, 1);
                 var sXml05=sheetObj.GetSaveData("DMTCommonFaxEmailGS.do", FormQueryString(formObj));
                if ( document.form.attachYN.checked && formObj.rd_fxeml_file_name.value == "EES_DMT_4907.mrd" ) {
                    alert(dmtGetMsgText(sXml05));
                } else if ( !document.form.attachYN.checked ) {
                    alert(dmtGetMsgText(sXml05));
                }
            break;
            
            case IBSEARCH_ASYNC06:      // EMAIL SEND
                formObj.f_cmd.value=SEARCH06; // searchCountryListByContinent
                 var sXml06=sheetObj.GetSaveData("DMTCommonFaxEmailGS.do", FormQueryString(formObj));
                alert(dmtGetMsgText(sXml06));
            break;
            
            case IBSEARCH_ASYNC07:      // EMAIL SEND + DETAIL RD
                formObj.f_cmd.value=SEARCH07; // searchRHQHierarchyByRegion
                 var sXml06=sheetObj.GetSaveData("DMTCommonFaxEmailGS.do", FormQueryString(formObj));
                alert(dmtGetMsgText(sXml06));
            break;
            
            case IBSEARCH_ASYNC08:      // SEND2EMALL ALL OF THEM
                formObj.f_cmd.value=SEARCH; // searchOTSInquiryByDetailList
                 var sXml=sheetObj.GetSearchData("EES_DMT_4101GS.do",FormQueryString(formObj));
                var rtnRemark=ComGetEtcData(sXml, "rtnRemark");
                if ( rtnRemark == undefined || rtnRemark == '' ) {
                    ComShowMessage(msgs["DMT01096"]);
                    return f;
                }
            break;  
            
            case IBSAVE:        
                document.form.rmrk.value=document.form.remark01.value + "\n" + document.form.remark02.value;
                formObj.f_cmd.value=MULTI; // updateOTSInquiryByDetailListRemark
                sheetObj.SetWaitImageVisible(0);
                 var sXml=sheetObj.GetSaveData("EES_DMT_4011GS.do", FormQueryString(formObj));
                 sheetObjects[0].LoadSaveData(sXml, {Sync:1});
                sheetObj.SetWaitImageVisible(0);
                doActionIBSheet(sheetObjects[0] , document.form , IBSEARCH_ASYNC01);
            break;
            
            case IBINSERT:      
            break;
        }
    }
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//            if (!isNumber(formObj.iPage)) {
//                return false;
//            }
        }
        return true;
    }
    function sheet1_OnLoadFinish_EDU(){
    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
        doActionIBSheet(sheetObjects[2],document.form,IBSEARCH_ASYNC04);
        doInit();
    }
    function initControl() {
        axon_event.addListenerFormat( 'blur'      , 'obj_blur'      , form); //- 포커스 나갈때
//        axon_event.addListenerFormat( 'focus'     , 'obj_focus'     , form); //- 포커스 들어갈때
        axon_event.addListenerFormat( 'keypress'  , 'obj_keypress'  , form); //- 키보드 입력할때
        axon_event.addListenerForm  ( 'keydown'   , 'obj_keydown'   , document.form, 'rmrk');
        axon_event.addListener      ( 'mouseover' , 'obj_mouseover' , 'td_ch', 'ch', 'rlse_dt');
        axon_event.addListener      ( 'mouseout'  , 'obj_mouseout'  , 'td_ch', 'ch', 'rlse_dt');
    }
    function sheet1_OnSearchEnd( sheetObj , code,  ErrMsg ) {
    	with (sheetObj) {
            CheckAll(1,1);
            for ( var x=1 ; x < LastRow()+ 1 ; x++ ) {
                sheet1_OnClickXTC( sheetObj , x , 0 , 0 );
            }
            document.form.vinvqty.value=RowCount();
            document.form.tftp2.value=sheetObjects[0].GetCellValue(1,11);
            document.form.invno.value=sheetObjects[0].GetCellValue(1,3);
            document.form.sheetp.value=sheetObjects[0].GetCellValue(1,17);
        }
    }
    function sheet1_OnClickXTC( sheetObj , Row , Col , Value ) {
        with (sheetObj) {
        	var vChk=GetCellValue(Row,1);
        	
            var val01=ComReplaceStr(document.form.vbilamt.value,",");
            var val02=ComReplaceStr(document.form.vtaxamt.value,",");
            var val03=ComReplaceStr(document.form.vpayamt.value,",");
            if( ComIsNull(val01) ) { val01=0; }
            if( ComIsNull(val02) ) { val02=0; }
            if( ComIsNull(val03) ) { val03=0; }
            if( val01 < 0 ) { val01=0; }
            if( val02 < 0 ) { val02=0; }
            if( val03 < 0 ) { val03=0; }
            if ( vChk == 1 ) { // 선택해제
            	document.form.vbilamt.value=DmtAddComma( ComRound ( eval(val01) - eval(GetCellValue(Row,8 )) ) + "" , "#,###.00");
            	document.form.vtaxamt.value=DmtAddComma( ComRound ( eval(val02) - eval(GetCellValue(Row,9 )) ) + "" , "#,###.00");
            	document.form.vpayamt.value=DmtAddComma( ComRound ( eval(val03) - eval(GetCellValue(Row,10)) ) + "" , "#,###.00");
                SetCellValue(Row,1,0);
                sheetObjects[2].SetCellValue(Row,1,0);
            } else { // 선택해제
            	document.form.vbilamt.value=DmtAddComma( ComRound ( eval(GetCellValue(Row,8 )) + eval(val01) ) + "" , "#,###.00");
            	document.form.vtaxamt.value=DmtAddComma( ComRound ( eval(GetCellValue(Row,9 )) + eval(val02) ) + "" , "#,###.00");
            	document.form.vpayamt.value=DmtAddComma( ComRound ( eval(GetCellValue(Row,10)) + eval(val03) ) + "" , "#,###.00");
                SetCellValue(Row,1,1);
                sheetObjects[2].SetCellValue(Row,1,1);
            }
        }
    }    
    function sheet1_OnMouseDown( sheetObj , Button , Shift , X , Y ) {
        with (sheetObj) {
            if ( MouseRow()== 0 && MouseCol()== 1 && Button == 1 ) {
            	if ( CheckAll( 1 ) == 0 ) {
                    document.form.vbilamt.value="0.00";
                    document.form.vtaxamt.value="0.00";
                    document.form.vpayamt.value="0.00";
                    for ( var x=1 ; x < LastRow()+ 1 ; x++ ) {
                        SetCellValue( x , 1 ,0);
                        sheetObjects[2].SetCellValue( x , 1 ,0);
                    }
                    sheet1_OnSearchEndXTC( sheetObj , "" );
                    document.form.vinvqty.value=RowCount();
            	} else if ( CheckAll( 1 ) == 1 ) {
                    document.form.vbilamt.value="0.00";
                    document.form.vtaxamt.value="0.00";
                    document.form.vpayamt.value="0.00";
                    for ( var x=1 ; x < LastRow()+ 1 ; x++ ) {
                        SetCellValue( x , 1 ,0);
                        sheetObjects[2].SetCellValue( x , 1 ,0);
                    }
                    document.form.vinvqty.value="0";
                } else {
                }
                if ( sheetObjects[0].CheckedRows("CheckBox") == 0 ) {
                    ComShowMessage(msgs["DMT01101"]);
                    ComBtnDisable("btn1_down_excel");
                    ComBtnDisable("btn1_detail_print");
                    ComBtnDisable("btn1_preview");
                    ComBtnDisable("btn1_ots_print");
                    ComBtnDisable("btn1_fax_send");
                    ComBtnDisable("btn1_email_send");
                    ComEnableObject(document.form.attachYN, false);
                } else {
                    ComBtnEnable("btn1_down_excel");
                    ComBtnEnable("btn1_detail_print");
                    ComBtnEnable("btn1_preview");
                    ComBtnEnable("btn1_ots_print");
                    ComBtnEnable("btn1_fax_send");
                    ComBtnEnable("btn1_email_send");
                    ComEnableObject(document.form.attachYN, true);
                }                
            }
        }
    }
    function sheet1_OnSearchEndXTC( sheetObj , ErrMsg ) {
        with (sheetObj) {
            for ( var x=1 ; x < LastRow()+ 1 ; x++ ) {
                sheet1_OnClickXTC( sheetObj , x , 0 , 0 );
            }
        }
    }    
    function sheet1_OnClick( sheetObj , Row , Col , Value ) {
        with (sheetObj) {
            if ( Row > 0 && Col == 1 ) {
            	var vChk=sheetObjects[0].GetCellValue(Row,1);
                var val01=ComReplaceStr(document.form.vbilamt.value,",");
                var val02=ComReplaceStr(document.form.vtaxamt.value,",");
                var val03=ComReplaceStr(document.form.vpayamt.value,",");
                var val04=ComReplaceStr(document.form.vinvqty.value,",");
                if( ComIsNull(val01) ) { val01=0; }
                if( ComIsNull(val02) ) { val02=0; }
                if( ComIsNull(val03) ) { val03=0; }
                if( ComIsNull(val04) ) { val04=0; }
                if ( vChk == 1 ) { // 선택해제
                	document.form.vbilamt.value=DmtAddComma( ComRound ( eval(val01) - eval(sheetObjects[0].GetCellValue(Row,8 )) ) + "" , "#,###.00");
                	document.form.vtaxamt.value=DmtAddComma( ComRound ( eval(val02) - eval(sheetObjects[0].GetCellValue(Row,9 )) ) + "" , "#,###.00");
                	document.form.vpayamt.value=DmtAddComma( ComRound ( eval(val03) - eval(sheetObjects[0].GetCellValue(Row,10)) ) + "" , "#,###.00");
                    document.form.vinvqty.value=DmtAddComma(          ( eval(val04) - eval("1"                              ) ) + "" , "#,###"   );
                    SetCellValue( Row ,1 ,0);
                    CheckAll( 1 ,0);
                    sheetObjects[2].SetCellValue( Row ,1 ,0);
                    sheetObjects[2].CheckAll( 1 ,0);
                } else if ( vChk == 0 ) { // 선택해제
                	document.form.vbilamt.value=DmtAddComma( ComRound ( eval(sheetObjects[0].GetCellValue(Row,8 )) + eval(val01) ) + "" , "#,###.00");
                	document.form.vtaxamt.value=DmtAddComma( ComRound ( eval(sheetObjects[0].GetCellValue(Row,9 )) + eval(val02) ) + "" , "#,###.00");
                	document.form.vpayamt.value=DmtAddComma( ComRound ( eval(sheetObjects[0].GetCellValue(Row,10)) + eval(val03) ) + "" , "#,###.00");
                    document.form.vinvqty.value=DmtAddComma(          ( eval("1"                              ) + eval(val04) ) + "" , "#,###"   );
                    SetCellValue( Row , 1 ,1);
                    sheetObjects[2].SetCellValue( Row , 1 ,1);
                } else {
                }
                if ( sheetObjects[0].CheckedRows("CheckBox") == 0 ) {
                    ComShowMessage(msgs["DMT01101"]);
                    ComBtnDisable("btn1_down_excel");
                    ComBtnDisable("btn1_detail_print");
                    ComBtnDisable("btn1_preview");
                    ComBtnDisable("btn1_ots_print");
                    ComBtnDisable("btn1_fax_send");
                    ComBtnDisable("btn1_email_send");
                    ComEnableObject(document.form.attachYN, false);
                } else {
                    ComBtnEnable("btn1_down_excel");
                    ComBtnEnable("btn1_detail_print");
                    ComBtnEnable("btn1_preview");
                    ComBtnEnable("btn1_ots_print");
                    ComBtnEnable("btn1_fax_send");
                    ComBtnEnable("btn1_email_send");
                    ComEnableObject(document.form.attachYN, true);
                }                 
            }
            document.form.tftp2.value=sheetObjects[0].GetCellValue(Row,11);
            document.form.invno.value=sheetObjects[0].GetCellValue(Row,3);
            document.form.sheetp.value=sheetObjects[0].GetCellValue(Row,17);
        }
    }
    function sheet1_OnClickXTC2( sheetObj , Row , Col , Value ) {
        with (sheetObj) {
        	var vChk=sheetObjects[0].GetCellValue(Row,1);
            var val01=ComReplaceStr(document.form.vbilamt.value,",");
            var val02=ComReplaceStr(document.form.vtaxamt.value,",");
            var val03=ComReplaceStr(document.form.vpayamt.value,",");
            if( ComIsNull(val01) ) { val01=0; }
            if( ComIsNull(val02) ) { val02=0; }
            if( ComIsNull(val03) ) { val03=0; }
            if( val01 < 0 ) { val01=0; }
            if( val02 < 0 ) { val02=0; }
            if( val03 < 0 ) { val03=0; }
            if ( vChk == 1 ) { 
            	document.form.vbilamt.value=DmtAddComma( ( eval(val01) - eval(sheetObjects[0].GetCellValue(Row,8 )) )+"" , "#,###.00");
            	document.form.vtaxamt.value=DmtAddComma( ( eval(val02) - eval(sheetObjects[0].GetCellValue(Row,9 )) )+"" , "#,###.00");
            	document.form.vpayamt.value=DmtAddComma( ( eval(val03) - eval(sheetObjects[0].GetCellValue(Row,10)) )+"" , "#,###.00");
            } else if ( vChk == 0 ) {
            	document.form.vbilamt.value=DmtAddComma( ( eval(sheetObjects[0].GetCellValue(Row,8 )) + eval(val01) )+"" , "#,###.00");
            	document.form.vtaxamt.value=DmtAddComma( ( eval(sheetObjects[0].GetCellValue(Row,9 )) + eval(val02) )+"" , "#,###.00");
            	document.form.vpayamt.value=DmtAddComma( ( eval(sheetObjects[0].GetCellValue(Row,10)) + eval(val03) )+"" , "#,###.00");
            } else {
            }
        }
    }
    function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH) {
        var formObject=document.form;
        var tempInvNo=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),  "invnoo")
        var tempInvNoM=tempInvNo.substring( 2 , 3 );
        if ( tempInvNoM == "M" ) {
            var url="EES_DMT_4004P.do"
                    +"?dmdt_inv_no="+tempInvNo
                    +"&caller=4011"
                    ;
            //팝업함수 호출방법 변경(callback 함수에서 조회를 실행하도록 수정함) 2014.08.26
            //var returnValue=ComOpenWindowCenter(url, "EES_DMT_4004", "1200","800");
            ComOpenPopup(url, "1200", "800", "callbackProc", "1,0,1,1,1,1,1", false);
//            var returnValue=ComOpenWindowCenter(url, "EES_DMT_4004", "1036","738", true);
//            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
//            doActionIBCombo(sheetObjects[3], document.form, COMMAND02, COMMAND02, "", "");                
        } else {
            var url="EES_DMT_4002.do"
                    +"?group_by=2"
                    +"&chg_type=A"
                    +"&ofc_cd="+sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"isseof")
                    +"&bkg_no="+sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"bkgnoo")
                    +"&dmdt_trf_cd="+sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"tarftp")
                    +"&cntr_no="
                    //+"&invoice_no="+ComGetObjValue(formObject.invno)
                    +"&invoice_no="+tempInvNo
                    +"&invoice_issue=2" //Invoice Issue AFTER
                    ;

            ComOpenPopup(url, "1200", "800", "callbackProc", "1,0,1,1,1,1,1", false);
//            var returnValue=ComOpenWindowCenter(url, "EES_DMT_4002", "1036","700", true);
//            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
//            doActionIBCombo(sheetObjects[3], document.form, COMMAND02, COMMAND02, "", "");                
        }
    }    
    /**
     * By changing the number format string to match is returned. Numeric values ​​in a format that can be configured as follows:. <br>
     * sFormat="#,###"    : Thousand nine minutes that {@ link # ComAddComma} function is the same as. <br>
     * sFormat="#,###.0"  : Thousands separator and decimal point indicates a place. <br>
     * sFormat="#,###.00" : Thousands separator and decimal point two digits to display. <br>
     * <br><b>Example : </b>
     * <pre>
     *     ret = ComAddComma2("1000", "#,###")        //result : "1,000"
     *     ret = ComAddComma2("1000", "#,###.0")      //result : "1,000.0"
     *     ret = ComAddComma2("1000", "#,###.00")     //result : "1,000.00"
     *     ret = ComAddComma2("1000.1", "#,###")      //result : "1,000.1"
     *     ret = ComAddComma2("1000.1", "#,###.0")    //result : "1,000.1"
     *     ret = ComAddComma2("1000.1", "#,###.00")   //result : "1,000.1"
     *     ret = ComAddComma2("-1,000.12", "#,###.0") //result : "-1,000.12"
     * </pre>
     * @param {string,object}   obj      Required, a numeric string or HTML tags(Object)
     * @param {string}          sFormat  Numeric format
     * @returns string, Set the number format string<br>
     *          "":sVal argument is an invalid value for the space ("") will return.
     * @see #ComAddComma
     * @see #ComGetMaskedValue
     */
    function DmtAddComma(obj,sFormat)
    {
        try {
            var sVal=getArgValue(obj);
            switch(sFormat)
            {
                case "#,###" :
                        return ComAddComma(sVal);
                case "#,###.0" :
                        p=sVal.split(".");
                        p[0]=ComAddComma(p[0]);
                        if      (p.length == 1) return p[0]+".0";
                        else if (p.length == 2) return p[0]+"."+p[1];
                        else return "";
                case "#,###.00" :
                        p=sVal.split(".");
                        p[0]=ComAddComma(p[0]);
                        if      (p.length == 1) {
                            return p[0]+".00";
                        } else if (p.length == 2) {
                            if ( p[1].length == 1 ) {
                                return p[0]+"."+p[1]+"0";                                
                            } else {
                                return p[0]+"."+p[1];
                            }
                        } else {
                            return "";
                        }
            }
        } catch(err) { ComFuncErrMsg(err.message); }
    }    
	function dmtGetMsgText(xmlStr){
	    try {
       	 	return ComGetSelectSingleNode(xmlStr, "MESSAGE");
       	 	/*
       	 	var xmlDoc=new ActiveXObject("Microsoft.XMLDOM" );
	        xmlDoc.loadXML(xmlStr);
	        var xmlRoot=xmlDoc.documentElement;
	        if(xmlRoot == null) return;
	        var msgNode=xmlRoot.getElementsByTagName("MESSAGE").item(0);
	        if(msgNode == null) 
	         return;
	        else
	         return msgNode.firstChild.nodeValue;*/
	   } catch(err) { ComFuncErrMsg(err.message); }
	}
    function doActionIBCombo(sheetObj,formObj,sAction,sComboAction,sComboKey,sObj) {
        sheetObj.ShowDebugMsg(false);
        sheetObj.SetWaitImageVisible(0);
        switch(sAction) {
            case IBSEARCH:      
                if (sheetObj.id == "sheet4") {
                	setComboParameters(sComboAction, sObj);
                 	var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
                    var comboDatas;
                    var comboItems;
                    switch(sComboAction) {
                        //1. ATTENTION LIST
                        case SEARCHLIST03:
                            comboItems=ComGetEtcData(sXml, sComboKey).split(ROWMARK);
                            comboObjects[0].SetSelectCode("-1");
                            comboObjects[0].RemoveAll();
                            addComboItem1(sObj,comboItems);
                        break;                          
                    } //end of the switch(sComboAction) 
                }
            break;
            case COMMAND02:
                formObj.ofc_cd.value=formObj.h_usr_off.value;
                formObj.dmdt_trf_cd.value=document.form.tftp.value;
                formObj.payer_cd.value=document.form.payc.value;
                var param="f_cmd=" + COMMAND02
                		  + "&payer_cd=" + formObj.payer_cd.value 
                		  + "&dmdt_trf_cd=" + formObj.dmdt_trf_cd.value 
                		  + "&ofc_cd=" + formObj.ofc_cd.value
                		  ;              
                 var sXml=sheetObj.GetSearchData("EES_DMT_4002GS.do", param);
                 if ( sXml != undefined && sXml != "" ) {            
                    ComSetObjValue(formObj.payr_faxnos  , ComGetEtcData(sXml, "FAX_NO"  ));
                    ComSetObjValue(formObj.payr_emailnos, ComGetEtcData(sXml, "EMAIL_NO"));
                 } else {
                    ComSetObjValue(formObj.payr_faxnos  , "");
                    ComSetObjValue(formObj.payr_emailnos, "");
                 }
            break;
        }
        sheetObj.SetWaitImageVisible(1);
    }     
    function setComboParameters(sComboAction, sObj) {
        var formObj=document.form;
        ComSetObjValue(formObj.f_cmd, sComboAction);
        if(sComboAction == COMMAND02) {
            ComSetObjValue ( formObj.ofc_cd , ComGetObjValue ( formObj.h_usr_off ) );
        }
    }   
     /**
      * Data in the field adds a combo.
      */    
    function addComboItem(comboObj,comboDatas,isOnlyCode) {
        var comboItem;
        var comboItems;
        var val;
        var txt;
        if (comboDatas != undefined) {
            comboItems=comboDatas.split(ROWMARK); 
            for (var i=0 ; i < comboItems.length ; i++) {
                comboItem=comboItems[i].split(FIELDMARK);
                val=comboItem[0];
                txt=isOnlyCode ? comboItem[0] : comboItem[1];
                ComAddComboItem(comboObj,val,txt);
            }
        }           
    }
    /**
      * Data in the field adds a combo.
      */    
    function addComboItem1(comboObj, comboItems) {
        var tCode="";
        for (var i=0 ; i < comboItems.length ; i++) {
            var comboItem=comboItems[i].split(FIELDMARK);
            comboObj.InsertItem(i, comboItem[0]+"|"+comboItem[1]+"|"+comboItem[2]+"|"+comboItem[3], comboItem[4]);      
            if ( i == 0 ) {
                tCode=comboItem[4];
            }
        }
        comboObjects[0].SetSelectCode(tCode);
    }     
    function doActionText(sheetObj, formObj, object, formCmd) {
        sheetObj.ShowDebugMsg(false);
        sheetObj.SetWaitImageVisible(0);
        //cust_cd
        ComSetObjValue(formObj.s_cust_cd, ComGetObjValue(formObj.payer_cd));
        var cust_len=parseInt(ComGetLenByByte(ComGetObjValue(formObj.s_cust_cd)));
        if(cust_len == 0){
            ComSetObjValue(formObj.s_cust_gubun, "");
            ComSetObjValue(formObj.s_cust_cd, "");
            ComSetObjValue(formObj.payer_cd, "");
            ComSetObjValue(formObj.payer_nm, "");
            //attention  reset
            attentionReset();
            return;
        }
        var cre_cnt_cd=ComGetObjValue(formObj.session_cnt_cd);
        if(cust_len > 2) {
        	var char_chk=ComGetObjValue(formObj.s_cust_cd).substring(0,2);
        	if(ComIsAlphabet(char_chk)) {
        		ComSetObjValue(formObj.s_cust_gubun, "2");
        	}else{
				ComShowCodeMessage("DMT00165", "Payer");
				ComSetObjValue(formObj.s_cust_gubun, "");
				ComSetObjValue(formObj.s_cust_cd, "");
				ComSetObjValue(formObj.payer_cd, "");
				ComSetObjValue(formObj.payer_nm, "");
				attentionReset();
				return;
			}
		} else {
			ComShowCodeMessage("DMT00165", "Payer");
			ComSetObjValue(formObj.s_cust_gubun, "");
			ComSetObjValue(formObj.s_cust_cd, "");
			ComSetObjValue(formObj.payer_cd, "");
			ComSetObjValue(formObj.payer_nm, "");
			attentionReset();
			return;
		}
        ComSetObjValue(formObj.f_cmd, formCmd);

        var cust_cd=ComGetEtcData(sXml, "PAYER_CODE");
        var cust_nm=ComGetEtcData(sXml, "PAYER_NM");
        var delt_flg=ComGetEtcData(sXml, "DELT_FLG");
        if(cust_nm == null || cust_nm == "") {
            ComSetObjValue(formObj.s_cust_gubun, "");
            ComSetObjValue(formObj.s_cust_cd, "");
            ComSetObjValue(formObj.payer_cd, "");
            ComSetObjValue(formObj.payer_nm, "");
            //attention  reset
            attentionReset();
            ComShowCodeMessage("DMT00165", "Payer");
            ComSetFocus(formObj.payer_cd);
        }else{
            ComSetObjValue(formObj.payer_cd, cust_cd);
            ComSetObjValue(formObj.payer_nm, cust_nm);
            searchAttentionList();
        }
    }
    /**
     * attention list reset
     */ 
    function attentionReset(){
        var formObj=document.form;
        comboObjects[0].RemoveAll();
        ComSetObjValue(formObj.dmdt_payr_cntc_pnt_nm, "");
        ComSetObjValue(formObj.payr_cntc_pnt_phn_no , "");
        ComSetObjValue(formObj.payr_cntc_pnt_fax_no , "");
        ComSetObjValue(formObj.payr_cntc_pnt_eml    , "");
    }
    
  	function combo1_OnSelect(comboObj, Index, Text, Code) {
  		search_combo1(comboObj, Index, Code);
  	}

  	function search_combo1(comboObj, Index, Code) {
		var formObj      = document.form;
		var cboAttention = comboObjects[0];
		
		var pntNm = "";
		var phnNo = "";
		var faxNo = "";
		var eml   = "";
		
		if (Index != -1) {
			var pntNm = comboObj.GetText(Index, 0);
			var phnNo = comboObj.GetText(Index, 1);
			var faxNo = comboObj.GetText(Index, 2);
			var eml   = comboObj.GetText(Index, 3);
			
			ComSetObjValue(formObj.dmdt_payr_cntc_pnt_nm, pntNm);
			ComSetObjValue(formObj.payr_cntc_pnt_phn_no,  phnNo);	//To show the text column
			ComSetObjValue(formObj.payr_cntc_pnt_fax_no,  faxNo);	//To show the text column
			ComSetObjValue(formObj.payr_cntc_pnt_eml,     eml);		//To show the text column
		
			var arrCode = Code.split("^");		//code
			if (arrCode != undefined || arrCode != "") {
				ComSetObjValue(formObj.cust_cntc_pnt_seq, arrCode[1]);
			}
		}
  	} 
  	
    function getPayerInfoData(fax_nos, email_nos, cntc_pnt_nm, cntc_pnt_seq){
        var formObj=document.form;
        ComSetObjValue(formObj.payr_faxnos,             fax_nos);
        ComSetObjValue(formObj.payr_emailnos,           email_nos);
        ComSetObjValue(formObj.dmdt_payr_cntc_pnt_nm,   cntc_pnt_nm);
        ComSetObjValue(formObj.cust_cntc_pnt_seq,       cntc_pnt_seq);
        searchAttentionList();
        var setCode=ComGetObjValue(formObj.cust_cnt_cd)+"^"+ComGetObjValue(formObj.cust_cntc_pnt_seq)+"^"+ComParseInt(ComGetObjValue(formObj.cust_seq));
        //setting
        if(ComGetObjValue(formObj.payer_cd) == "") {
            comboObjects[0].SetSelectCode(-1);
            ComSetObjValue(formObj.payr_cntc_pnt_phn_no, "");
            ComSetObjValue(formObj.payr_cntc_pnt_fax_no, "");
            ComSetObjValue(formObj.payr_cntc_pnt_eml, "");
            ComSetObjValue(formObj.cust_cntc_pnt_seq, "");
        }else{
            //Attention Setting
            comboObjects[0].SetSelectCode(setCode);
            if(comboObjects[0].GetSelectCode()== ""){
                ComSetObjValue(formObj.payr_cntc_pnt_phn_no, "");
                ComSetObjValue(formObj.payr_cntc_pnt_fax_no, "");
                ComSetObjValue(formObj.payr_cntc_pnt_eml, "");
                ComSetObjValue(formObj.cust_cntc_pnt_seq, "");
            }
        }
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
    }   

    function callbackProc(rtnVal) {
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
        doActionIBCombo(sheetObjects[3], document.form, COMMAND02, COMMAND02, "", "");
    }