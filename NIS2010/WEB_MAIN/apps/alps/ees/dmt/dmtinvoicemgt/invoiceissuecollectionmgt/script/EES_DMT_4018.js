/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_4018.js
*@FileTitle : Outstanding Inquiry by Customer & Issue - Detail(s)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.03
*@LastModifier : Mun Jung Cheol
*@LastVersion : 1.0
* 2009.09.03 Mun Jung Cheol
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
                    [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
                    기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------ 다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
   /**
     * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
     * @author 한진해운
     */

    /**
     * @extends 
     * @class ui_dmt_4018 : ui_dmt_4018 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ui_dmt_4018() {
        this.processButtonClick     = processButtonClick;
        this.setSheetObject         = setSheetObject;
        this.loadPage               = loadPage;
        this.initSheet              = initSheet;
        this.initControl            = initControl;
        this.doActionIBSheet        = doActionIBSheet;
        this.setTabObject           = setTabObject;
        this.validateForm           = validateForm;
    }

// 공통전역변수

var sheetObjects = new Array();
var sheetCnt = 0;

    var comboObjects = new Array();
    var comboCnt = 0;
    
    var ROWMARK = "|";
    var FIELDMARK = "=";
    
    var IBSEARCH02 = 51;

    var rdObjects = new Array();
    var rdCnt = 0;
    var queryStr = "";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         
         var sheetObject1 = sheetObjects[sheetCnt++];
         var sheetObject2 = sheetObjects[sheetCnt++];
         var rdObject = rdObjects[0];
         
         /*******************************************************/
         var formObject = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

                case "btn1_preview": // 4012 OPEN
                    if( sheetObjects[0].rowcount==0 ) {
                        errMsg = 'No data found.';
                        ComShowMessage(msgs["CIM29030"]);
                        return;
                    }
                    
                    //sheet set check
                    document.form.trftpp.value = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,  "tarftp");
                    
                    formObject.f_cmd.value = SEARCH;
                    var sXml = sheetObjects[0].GetSearchXml("EES_DMT_4101GS.do",FormQueryString(formObject));
                    var rtnRemark = ComGetEtcData(sXml, "rtnRemark");
                    if ( rtnRemark == undefined || rtnRemark == '' ) {
                        ComShowMessage(msgs["DMT01096"]);
                        return false;
                    }                    
                    
                    document.form.tftp2.value = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,  "tarftp");
                    
                    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC02);
                    formObject.f_cmd.value = IBSEARCH02;
                    for ( var sh3 = 1 ; sh3 < sheetObjects[0].RowCount+1 ; sh3++ ) {
                        sheetObjects[2].CellValue2( sh3 , 1 ) = sheetObjects[0].CellValue( sh3 , 1 ); 
                    }
                    var tInvNo = "";
                    var tTftp = ""; 
                    for ( var z01 = 1 ; z01 < sheetObjects[0].RowCount+1 ; z01++  ) {
                        if ( sheetObjects[0].CellValue(z01,1) == 1 ) {
                            tInvNo = sheetObjects[0].CellValue(z01, 3) + "," + tInvNo;
                            tTftp  = sheetObjects[0].CellValue(z01,11) + "," + tTftp;
                        }
                    }
                    document.form.invno.value = tInvNo;
                    document.form.tftp2.value = tTftp;

                    var tArif = formObject.arif.value;
                    var logInOff = document.form.h_rhq_off.value;
                    if ( logInOff != "NYCRA" && logInOff != "SELHO" ) {
                        if ( tArif == "A" ) {
                            formObject.arif.value = "Y,N";
                        }
                    }
                    var attyn = "";
                    if ( document.form.attachYN.checked ) {
                    	attyn = "Y";
                    }

                    var urlParam = "/hanjin/EES_DMT_4012.do?tftp2=&sheetp=O&isof="+document.form.isof.value
                                                          +"&payc="+document.form.payc.value
                                                          +"&bkgno="+sheetObjects[0].CellValue(sheetObjects[0].SelectRow,  "bkgnoo")
                                                          +"&invno="
                                                          +"&attyn="+attyn
                                                          ;
                    ComOpenPopupWithTarget(urlParam, 940, 758, "", "0,1,1,1,1,1,1", true,"yes");
                break;

                case "btn2_sheetset": // 4101 OPEN
                    ComOpenPopupWithTarget('/hanjin/EES_DMT_4101.do?issoff='+formObject.h_usr_off.value+'&tftp2='+sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"tarftp")+'&sheetp=O&jspno=EES_DMT_4018', 725, 770, "", "0,1,1,1,1,1,1", true,true);
                break;
                
                case "btn2_sheetoption": // 4103 OPEN
                    ComOpenPopupWithTarget('/hanjin/EES_DMT_4103.do?issoff='+formObject.h_usr_off.value+'&jspno=EES_DMT_4018', 625, 650, "", "0,1,1,1,1,1,1", true);
                break;
                
                case "btn1_payer_info": // 4104
                    var url = "EES_DMT_4104.do"
                        +"?s_ofc_cd="+ComGetObjValue(formObject.h_usr_off)
                        +"&s_cust_cd="+ComGetObjValue(formObject.payc)
                        +"&s_bkg_no="+sheetObjects[0].CellValue(sheetObjects[0].SelectRow,  "bkgnoo")
                        +"&s_pod_cd="
                        +"&jspno=EES_DMT_4018"
                        +"&attn="+ComGetObjValue(formObject.dmdt_payr_cntc_pnt_nm)
                        +"&telno="+ComGetObjValue(formObject.payr_cntc_pnt_phn_no)
                        +"&faxno="+ComGetObjValue(formObject.payr_cntc_pnt_fax_no)
                        +"&email="+ComGetObjValue(formObject.payr_cntc_pnt_eml)
                        ;                    
                    var returnValue = ComOpenWindowCenter(url, "EES_DMT_4104", "825","620", true);                    
                    break;

                case "btn1_detail": // INVOICE NO 로 분기 4004 OR 4002
                	openPopupWindow(sheetObj, formObject, srcName);
                	break;

                case "btn1_remark": // PAYER INFO REMARK SAVE
	        		//버튼권한 추가(2010.04.08)
	        		if(ComGetObjValue(formObject.sec_invoice) == "N") {
	        			ComShowCodeMessage("DMT01145", "Save Remark");
	        			return;
	        		}
                    doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
                    break;

                case "btn1_ots_print": // RD PRINT DIALOG 띄우기 MAIN SHEET PRINT
                    document.form.trftpp.value = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,  "tarftp");
                    
                    formObject.f_cmd.value = SEARCH;
                    var sXml = sheetObjects[0].GetSearchXml("EES_DMT_4101GS.do",FormQueryString(formObject));
                    var rtnRemark = ComGetEtcData(sXml, "rtnRemark");
                    if ( rtnRemark == undefined || rtnRemark == '' ) {
                        ComShowMessage(msgs["DMT01096"]);
                        return false;
                    }
                    
                    
                    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC02);
                    for ( var sh3 = 1 ; sh3 < sheetObjects[0].RowCount+1 ; sh3++ ) {
                        sheetObjects[2].CellValue2( sh3 , 1 ) = sheetObjects[0].CellValue( sh3 , 1 ); 
                    }
                    rdOpen4012();
                    break;

                case "btn2_down_excel": // 
                    sheetObjects[0].SpeedDown2Excel(-1, false, false, '', '', false, false, '', false,'CheckBox','',false,'',true);
                break;
                
                case "btn1_fax_send":
                    
                    // TARIFF TYPE
                    document.form.trftpp.value = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,  "tarftp");
                    
                    // REMARK
                    formObject.f_cmd.value = SEARCH;
                    var sXml = sheetObjects[0].GetSearchXml("EES_DMT_4101GS.do",FormQueryString(formObject));
                    var rtnRemark = ComGetEtcData(sXml, "rtnRemark");
                    if ( rtnRemark == undefined || rtnRemark == '' ) {
                        ComShowMessage(msgs["DMT01096"]);
                        return false;
                    }                    

                    // OFFICE HEADER01-10 LEFTRIGHT TITLE REF TEL FAX VAT 구하기
                    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC02);
                    
//                    //fax no가 존재하지 않으면
//                    if( ComGetObjValue(formObject.payr_faxnos) == "" || ComGetObjValue(formObject.payr_faxnos) == undefined ) {
//                        ComShowCodeMessage("DMT01090");
//                        return;
//                    }                    
                    
                    // 선택한 INVOICE NO 구하기
                    var tInvNo = "";
                    var tTrfType = "";
                    var tCreOf = "";	//cre_ofc_cd
                    
                    for ( var z01 = 1 ; z01 < sheetObjects[0].RowCount+1 ; z01++  ) {
                        if ( sheetObjects[0].CellValue(z01,1) == 1 ) {
                            tInvNo = sheetObjects[0].CellValue(z01,"invnoo") + "," + tInvNo;
                            tTrfType = sheetObjects[0].CellValue(z01,"tarftp") + "," + tTrfType;
                            tCreOf = sheetObjects[0].CellValue(z01,"isseof") + "," + tCreOf;

                        }
                    }
                    document.form.invno.value = tInvNo;
                    document.form.creof.value = tCreOf;
                    
                    // EMAIL FAX 전송위한 HIDDEN 값 설정
                    formObject.rd_fxeml_sys_cd         .value = "DMT";
                    if        ( document.form.cntrinvno.value == "0" && document.form.rpt_leftright.value == "L" ) {
                        formObject.rd_fxeml_file_name      .value = "EES_DMT_4903.mrd";                        
                    } else if ( document.form.cntrinvno.value == "0" && document.form.rpt_leftright.value == "R" ) {
                        formObject.rd_fxeml_file_name      .value = "EES_DMT_4904.mrd";
                    } else if ( document.form.cntrinvno.value == "1" && document.form.rpt_leftright.value == "L" ) {
                        formObject.rd_fxeml_file_name      .value = "EES_DMT_4905.mrd";
                    } else if ( document.form.cntrinvno.value == "1" && document.form.rpt_leftright.value == "R" ) {
                        formObject.rd_fxeml_file_name      .value = "EES_DMT_4906.mrd";
                    }
                    formObject.rd_fxeml_bat_flg        .value = "N";
                    formObject.rd_fxeml_title          .value = "FAX DO NOT USE KOREAN ONLY ENGLISH";
                    formObject.rd_fxeml_doc_tp         .value = "O";
                    formObject.rd_fxeml_rd_param       .value = " /rp [" + document.form.arif .value +"] " +
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
                                                                   "[" + document.form.rpt_hjsref   .value +"] " +
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
                    
                    // FAX 전송 전에 사용자에게 FAX 번호 확인하기 보내시겠습니까 ?
//                    var arr_faxnos  = ComGetObjValue(formObject.payr_faxnos).split(";");
//                    var re_faxnos   = "";
//                    var msg1 = "";
//                    for(var iII=0; iII< arr_faxnos.length; iII++) {
//                        re_faxnos   += ComGetObjValue(formObject.payer_cd)+";"+arr_faxnos[iII];
//                        msg1        += arr_faxnos[iII] +"\n\t";
//                    }
//                
//                    if ( !ComShowCodeConfirm( "DMT01092" , msg1 ) ) {                    
//                        return false;
//                    }
    
//                    formObject.rd_fxeml_fax_no         .value = ComGetObjValue(formObject.payr_faxnos);
                    formObject.rd_fxeml_fax_sndr_id    .value = "SM Line";
                    formObject.rd_fxeml_eml_sndr_nm    .value = "SM Line";
                    formObject.rd_fxeml_eml_rcvr_add   .value = "";
                    var currDateEmail = ComGetNowInfo();
                    formObject.rd_fxeml_eml_atch_file  .value = currDateEmail+"_"+document.form.payc .value;
                    formObject.rd_fxeml_eml_templt     .value = "EES_DMT_4011_01.html"; // 템플릿 위치 C:/sitectx/ALPS\APP-INF/config/template/mailtemplate/template.htmlmail
                    formObject.rd_fxeml_eml_tmplt_param.value = ""; // "name;mjchang|message;DMT EMAIL SEND TEST"
//                    doActionIBSheet(sheetObjects[3],document.form,IBSEARCH_ASYNC05);
                    
                    var attachYN = "N";
                    // DETAIL 도 같이 보낼것인가
                    if ( document.form.attachYN.checked ) {
                    	attachYN = "Y";
                        formObject.rd_fxeml_file_name2      .value = "EES_DMT_4907.mrd";                        
                        formObject.rd_fxeml_rd_param2       .value = "/rp [" + document.form.invno.value + "] [" + document.form.isof.value + "] [" + document.form.creof.value + "]";
//                        doActionIBSheet(sheetObjects[3],document.form,IBSEARCH_ASYNC05);                        
                    }
                    
                    // 팝업 호출
        			var ofc_cd = ComGetObjValue(formObject.h_usr_off);

        			var url = "EES_DMT_4107.do"
        				+"?s_ofc_cd="+ofc_cd
        				+"&s_cust_cd="+ComGetObjValue(formObject.payc)
        				+"&s_bkg_no="+sheetObjects[0].CellValue(sheetObjects[0].SelectRow,  "bkgnoo")
        				+"&s_pod_cd="
        				+"&jspno=4018"
        				+"&telno="+ComGetObjValue(formObject.payr_cntc_pnt_phn_no)
        				+"&faxno="+ComGetObjValue(formObject.payr_cntc_pnt_fax_no)
        				+"&email="+ComGetObjValue(formObject.payr_cntc_pnt_eml)
        				+"&cntc_seq="+attachYN										//attach check 여부 컬럼으로 치환하여 사용함
        				;
        			ComOpenWindowCenter(url, "EES_DMT_4107", "500","300", true);
                    
                break;   
                
                case "btn1_email_send":
                	
                    // TARIFF TYPE
                    document.form.trftpp.value = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,  "tarftp");
                    
                    // REMARK
                    formObject.f_cmd.value = SEARCH;
                    var sXml = sheetObjects[0].GetSearchXml("EES_DMT_4101GS.do",FormQueryString(formObject));
                    var rtnRemark = ComGetEtcData(sXml, "rtnRemark");
                    if ( rtnRemark == undefined || rtnRemark == '' ) {
                        ComShowMessage(msgs["DMT01096"]);
                        return false;
                    }

                    // OFFICE HEADER01-10 LEFTRIGHT TITLE REF TEL FAX VAT 구하기
                    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC02);
                    
//                    //email no가 존재하지 않으면
//                    if( ComGetObjValue(formObject.payr_emailnos) == "" || ComGetObjValue(formObject.payr_emailnos) == undefined ) {
//                        ComShowCodeMessage("DMT01091");
//                        return;
//                    }
//                    
                    // 선택된 INVOICE NO 가져오기
                    var tInvNo = "";
                    var tTrfType = "";
                    var tCreOf = "";	//cre_ofc_cd
                    var chnOfcCd = ""; // Change Office Code
                    
                    for ( var z01 = 1 ; z01 < sheetObjects[0].RowCount+1 ; z01++  ) {
                        if ( sheetObjects[0].CellValue(z01,1) == 1 ) {
                            tInvNo = sheetObjects[0].CellValue(z01,"invnoo") + "," + tInvNo;
                            tTrfType = sheetObjects[0].CellValue(z01,"tarftp") + "," + tTrfType;
                            tCreOf = sheetObjects[0].CellValue(z01,"isseof") + "," + tCreOf;
                        }
                    }
                    document.form.invno.value = tInvNo;
                    document.form.creof.value = tCreOf;
                    
                    // EMAIL FAX 전송위한 HIDDEN 값 설정
                    formObject.rd_fxeml_sys_cd         .value = "DMT";
                    if        ( document.form.cntrinvno.value == "0" && document.form.rpt_leftright.value == "L" ) {
                        formObject.rd_fxeml_file_name      .value = "EES_DMT_4903.mrd";                        
                    } else if ( document.form.cntrinvno.value == "0" && document.form.rpt_leftright.value == "R" ) {
                        formObject.rd_fxeml_file_name      .value = "EES_DMT_4904.mrd";
                    } else if ( document.form.cntrinvno.value == "1" && document.form.rpt_leftright.value == "L" ) {
                        formObject.rd_fxeml_file_name      .value = "EES_DMT_4905.mrd";
                    } else if ( document.form.cntrinvno.value == "1" && document.form.rpt_leftright.value == "R" ) {
                        formObject.rd_fxeml_file_name      .value = "EES_DMT_4906.mrd";
                    }
                    formObject.rd_fxeml_bat_flg        .value = "N";
                    
                    chnOfcCd = document.form.h_usr_off.value;
                    
                    if (chnOfcCd == "SAOSC") {
                    	// SAOSC 일 경우
                    	formObject.rd_fxeml_title          .value = "DEM/DET Statement of Accounts (SM Line)---Payer Name : "+document.form.rpt_custname.value;
                    	formObject.rd_fxeml_eml_templt     .value = "EES_DMT_4011_02.html"; // 템플릿 위치 C:/sitectx/ALPS\APP-INF/config/template/mailtemplate/template.htmlmail
                    } else {
                    	// SAOSC 아닌 경우
                    	formObject.rd_fxeml_title          .value = "Statement of Accounts (SM Line)---Cust. Code : "+document.form.payc.value;
                    	formObject.rd_fxeml_eml_templt     .value = "EES_DMT_4011_01.html"; // 템플릿 위치 C:/sitectx/ALPS\APP-INF/config/template/mailtemplate/template.htmlmail
                    }
                    
                    formObject.rd_fxeml_doc_tp         .value = "O";
                    formObject.rd_fxeml_rd_param       .value = " /rp [" + document.form.arif .value +"] " +
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
                                                                   "[" + document.form.rpt_hjsref   .value +"] " +
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
                    
                    //RCV 전송하는 EMAIL 사용자가 확인하기
//                    var arr_faxnos  = ComGetObjValue(formObject.payr_faxnos).split(";");
//                    var re_faxnos   = "";
//                    
//                    for(var i=0; i< arr_faxnos.length; i++) {
//                        re_faxnos   += ComGetObjValue(formObject.payer_cd)+";"+arr_faxnos[i];
//                        re_faxnos   += ";";
//                    }
//                    var msg1 = "";
//                    rcvr_email      = ComGetObjValue(formObject.payr_emailnos);
//                    var arr_emails  = ComGetObjValue(formObject.payr_emailnos).split(";");
//                    
//                    for(var i=0 ; i < arr_emails.length; i++) {
//                        msg1        += arr_emails[i] +"\n\t";
//                    }
//                    
//                    if ( !ComShowCodeConfirm( "DMT01093" , msg1 ) ) {                    
//                        return false;
//                    }
//                    formObject.rd_fxeml_fax_no         .value = ComGetObjValue(formObject.payr_faxnos);
                    formObject.rd_fxeml_fax_sndr_id    .value = "SM Line";
                    formObject.rd_fxeml_eml_sndr_nm    .value = "SM Line";
                    formObject.rd_fxeml_eml_rcvr_add   .value = ""; // ||mjchang@hanjin.com||gbkim@hanjin.com||d.leys@be.hanjin.com
                    var currDateEmail = ComGetNowInfo();
                    formObject.rd_fxeml_eml_atch_file  .value = currDateEmail+"_"+document.form.payc.value;
                    formObject.rd_fxeml_eml_tmplt_param.value = "";

                    // DETAIL 같이 보내는가 아닌가
                    var attachYN = "N";
                    if ( document.form.attachYN.checked )	attachYN = "Y"; 
                    
                 // 팝업 호출
        			var ofc_cd = ComGetObjValue(formObject.h_usr_off);

        			var url = "EES_DMT_4108.do"
        				+"?s_ofc_cd="+ofc_cd
        				+"&s_cust_cd="+ComGetObjValue(formObject.payc)
        				+"&s_bkg_no="+sheetObjects[0].CellValue(sheetObjects[0].SelectRow,  "bkgnoo")
        				+"&s_pod_cd="
        				+"&jspno=4018"
        				+"&telno="+ComGetObjValue(formObject.payr_cntc_pnt_phn_no)
        				+"&faxno="+ComGetObjValue(formObject.payr_cntc_pnt_fax_no)
        				+"&email="+ComGetObjValue(formObject.payr_cntc_pnt_eml)
        				+"&cntc_seq="+attachYN										//attach check 여부 컬럼으로 치환하여 사용함
        				;
        			ComOpenWindowCenter(url, "EES_DMT_4108", "500","300", true);

                break;                 
                    
                case "btn1_close":
                    window.close();
                break;
                    
                case "btn1_detail_print": // DETAIL RD PRINT
                    if( sheetObjects[0].RowCount==0 ) {
                        errMsg = 'No data found.';
                        ComShowMessage(msgs["CIM29030"]);
                        return;
                    }                    
                    rdOpen(rdObjects[0], document.form);
                break;

                case "btn1_down_excel":
                    if( sheetObjects[0].RowCount == 0 ) {
                        errMsg = 'No data found.';
                        ComShowMessage(msgs["CIM29030"]);
                        return;
                    }                   
                    
//                    if( formObject.attachYN.checked ){
                    	formObject.cntrflg.value = "Y";
//                    } else {
//                    	formObject.cntrflg.value = "";
//                    }
                    
                    doActionIBSheet(sheetObjects[1],document.form,IBSEARCH_ASYNC03);
                    
//                    if( formObject.attachYN.checked ){
//                    	sheetObjects[1].ColHidden("cntr_no") = false;
//                    } else {
//                    	sheetObjects[1].ColHidden("cntr_no") = true;
//                    }
                    
                    sheetObjects[1].SpeedDown2Excel(-1);
//sheetObjects[1].SpeedDown2Excel(-1,false,false,"","/apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/script/EES_DMT_4018_XSL.xml");                    
                break;

                case "btn_sendinghistory": // 7006 OPEN
                    if(ComIsBtnEnable(srcName)) {
                        openPopupWindow(sheetObjects[0], formObject, srcName);
                    }
                break;
                

                case "btn1_save": // PAYER INFO REMARK SAVE
	        		//버튼권한 추가(2010.04.08)
	        		if(ComGetObjValue(formObject.sec_invoice) == "N") {
	        			ComShowCodeMessage("DMT01145", "Save Remark");
	        			return;
	        		}
                    doActionIBSheet(sheetObjects[0],document.form,COMMAND02);
                    break;

                case "btn2_salse_save": 
                    doActionIBSheet(sheetObjects[0],document.form,IBINSERT);
                    break;
                    
            } // end switch
        }catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        }
    }

    function openPopupWindow(sheetObj, formObj, srcName) {
    	
		if (srcName == "btn1_detail") {
			var invTpCd   = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "dmdt_inv_tp_cd");
			var dmdtInvNo = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "invnoo");
			
			if (invTpCd == "M") {
				var url = "EES_DMT_4004P.do"
					+"?dmdt_inv_no="+dmdtInvNo
					+"&caller=4018"
					;
				var returnValue = ComOpenWindowCenter(url, "EES_DMT_4004", "1036","738", true);
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
				doActionIBCombo(sheetObjects[3], document.form, COMMAND02, COMMAND02, "", "");
			} 
			else {
				var url = "EES_DMT_4002.do"
					+"?group_by=2"
					+"&chg_type=A"
					+"&ofc_cd="+sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"isseof")
					+"&bkg_no="+sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"bkgnoo")
					+"&dmdt_trf_cd="+sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"tarftp")
					+"&cntr_no="
				   // +"&invoice_no="+ComGetObjValue(formObject.invno)
					+"&invoice_no="+dmdtInvNo
					+"&invoice_issue=2" //Invoice Issue BEFORE
					;
				var returnValue = ComOpenWindowCenter(url, "EES_DMT_4002", EES_DMT_4002_WIDTH, EES_DMT_4002_HEIGHT, true);
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
				doActionIBCombo(sheetObjects[3], document.form, COMMAND02, COMMAND02, "", "");
			}
		}
		else if (srcName == "btn_sendinghistory") {
            var url = "EES_DMT_7006_P.do"
                +"?jspno=EES_DMT_4018"
                +"&invoice=&selectOpt=2"
                ;
            var returnValue = ComOpenWindowCenter(url, "EES_DMT_7006_P", "1036","690", true);
        }
    }     
    
    /**
     * print화면 오픈
     * print화면 오픈
     * print할수 있는 화면 오픈
     */
    function rdOpen4012(){ // RD PRINT DIALOG OPEN - OTS PRINT BTN
        
        var sXml4012 = "";      
        var i=0;
        var j=0; 

        if ( document.form.cntrinvno.value == "1" ) { // CNTR NO RD
            
            var opener_sheet_obj1 =  sheetObjects[2];
            
            var fromObj = new Array();
            var rdObj = new Array();
                        
            fromObj[1] = document.form;                            // RD 로 보내기 위해 배열로담는다
            rdObj[0] = opener_sheet_obj1;     
             
            sXml4012 = "<?xml version='1.0' encoding='UTF-8'?><SHEET>";
            
            sheetCnt = 1;
            //i = 시트 카운트,
            for(i=0;i<1;i++){
                sheetCnt = i+1;
                if(rdObj[i].RowCount ==0){
                    sXml4012  += "<SHEET"+sheetCnt+"><DATA TOTAL='0'><TR>";
                    for(j=0;j<=rdObj[i].LastCol;j++){
                        sXml4012 +="<TD></TD>";
                    }
                    sXml4012 +="</TR></DATA></SHEET"+sheetCnt+">";
                }else{
                    
                    //sXml4012 +=RD_GetDataSearchXml(rdObj[i],sheetCnt);
    
                    //함수 인자 유효성 확인
                    if (typeof rdObj[i] != "object" || rdObj[i].tagName != "OBJECT") {
//                        alert("Data2SearchXml 함수의 sheet_obj 인자는 IBSheet가 아닙니다.");
                        return "";
                    }
    
                    var rowXml = "";
                    var allXml = "<SHEET" + sheetCnt + ">  <DATA TOTAL='"+ rdObj[i].TotalRows +"'>";
    
                    var rowcount = rdObj[i].RowCount + rdObj[i].headerRows - 1;
                    for (ir = rdObj[i].HeaderRows; ir <= rowcount; ir++) {
                        if ( rdObj[i].CellValue(ir,1) == 1 ) {                    
                            rowXml = "<TR>";
                            for (ic = 0; ic<= rdObj[i].LastCol; ic++) {
                                rowXml += "<TD><![CDATA[" + rdObj[i].CellValue(ir,ic) + "]]></TD>";
                            }
                            rowXml += "</TR>";
                            allXml += rowXml;
                        }                    
                    }
    
                    allXml += "  </DATA></SHEET" + sheetCnt + ">";
    
                    sXml4012 += allXml;
    
                }           
            }
            
            //document.form.cntrinvno2.value = document.form.cntrinvno .value;
            
            sXml4012 +="<ETC>"; 
            sXml4012 +="    <OFC_ADD01>" + document.form.rpt_ofcadd01.value  + "</OFC_ADD01>";
            sXml4012 +="    <OFC_ADD02>" + document.form.rpt_ofcadd02.value  + "</OFC_ADD02>";
            sXml4012 +="    <OFC_ADD03>" + document.form.rpt_ofcadd03.value  + "</OFC_ADD03>";        
            sXml4012 +="    <CUST_NAME>" + document.form.rpt_custname .value + "</CUST_NAME>";
            sXml4012 +="    <ADDRESS01>" + document.form.rpt_address01.value + "</ADDRESS01>";
            sXml4012 +="    <ADDRESS02>" + document.form.rpt_address02.value + "</ADDRESS02>";
            sXml4012 +="    <ADDRESS03>" + document.form.rpt_address03.value + "</ADDRESS03>";
            sXml4012 +="    <ADDRESS04>" + document.form.rpt_address04.value + "</ADDRESS04>";
            sXml4012 +="    <HJS_REF>"   + document.form.rpt_hjsref   .value + "</HJS_REF>"  ;
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
    
            if ( rdObj[0].RowCount  == "0")                     // RD 로 보낼 sheet 에 데이타가 없으면 Error
            {
                errMsg = 'No data found.';
                showErrMessage(errMsg);
                return;
            }
            rdObjects[0].AutoAdjust = 0;
            rdObjects[0].ZoomRatio = 0
            rdObjects[0].HideToolbar();
            rdObjects[0].HideStatusbar();
            rdObjects[0].ViewShowMode(1);
                    
            rdObjects[0].setbackgroundcolor(255,255,255);
            rdObjects[0].SetPageLineColor(255,255,255);         
            rdObjects[0].SetRData(sXml4012);
            
            var tInvNo = "";
            var tTrfType = "";
            var tCreOf = "";	//cre_ofc_cd

            for ( var z01 = 1 ; z01 < sheetObjects[0].RowCount+1 ; z01++  ) {
                if ( sheetObjects[0].CellValue(z01,1) == 1 ) {
                    tInvNo = sheetObjects[0].CellValue(z01,"invnoo") + "," + tInvNo;
                    tTrfType = sheetObjects[0].CellValue(z01,"tarftp") + "," + tTrfType;
                    tCreOf = sheetObjects[0].CellValue(z01,"isseof") + "," + tCreOf;
                }
            }
            document.form.invno.value = tInvNo;
            document.form.creof.value = tCreOf;
                    
                    
            
            var rdParam = " /rwait /rp [" + document.form.arif .value +"] " +
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
                                                                   "[" + document.form.rpt_hjsref   .value +"] " +
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
            
            rdObjects[0].SetAppendReport(0);
            if ( document.form.cntrinvno.value == "1" && document.form.rpt_leftright.value == "L" ) {
                rdObjects[0].FileOpen(RD_path+'apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4905.mrd',RDServer+rdParam);
            } else if ( document.form.cntrinvno.value == "1" && document.form.rpt_leftright.value == "R" ) {
                rdObjects[0].FileOpen(RD_path+'apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4906.mrd',RDServer+rdParam);
            }  
            
            if ( document.form.attachYN.checked ) {
                
                var tInvNo = "";            
                for ( var z01 = 1 ; z01 < sheetObjects[0].RowCount+1 ; z01++  ) {
                    if ( sheetObjects[0].CellValue(z01,1) == 1 ) {
                        tInvNo = sheetObjects[0].CellValue(z01,3) + "," + tInvNo;
                    }
                }
                document.form.invno.value = tInvNo;
                var rdParam2 = "/rp [" + document.form.invno.value + "] [" + document.form.isof.value + "] [" + document.form.creof.value + "]" ;
                rdObjects[0].SetAppendReport(1);
                rdObjects[0].FileOpen(RD_path+'apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4907.mrd', RDServerBAT + rdParam2);
               
            }
            
            rdObjects[0].PrintDialog();
            
        } else { // INVOICE NO RD
            
            
            var opener_sheet_obj1 =  sheetObjects[0];
            
            var fromObj = new Array();
            var rdObj = new Array();
                        
            fromObj[1] = document.form;                            // RD 로 보내기 위해 배열로담는다
            rdObj[0] = opener_sheet_obj1;     
             
            sXml4012 = "<?xml version='1.0' encoding='UTF-8'?><SHEET>";
            
            sheetCnt = 1;
            //i = 시트 카운트,
            for(i=0;i<1;i++){
                sheetCnt = i+1;
                if(rdObj[i].RowCount ==0){
                    sXml4012  += "<SHEET"+sheetCnt+"><DATA TOTAL='0'><TR>";
                    for(j=0;j<=rdObj[i].LastCol;j++){
                        sXml4012 +="<TD></TD>";
                    }
                    sXml4012 +="</TR></DATA></SHEET"+sheetCnt+">";
                }else{
                    
                    //sXml4012 +=RD_GetDataSearchXml(rdObj[i],sheetCnt);
    
                    //함수 인자 유효성 확인
                    if (typeof rdObj[i] != "object" || rdObj[i].tagName != "OBJECT") {
//                        alert("Data2SearchXml 함수의 sheet_obj 인자는 IBSheet가 아닙니다.");
                        return "";
                    }
    
                    var rowXml = "";
                    var allXml = "<SHEET" + sheetCnt + ">  <DATA TOTAL='"+ rdObj[i].TotalRows +"'>";
    
                    var rowcount = rdObj[i].RowCount + rdObj[i].headerRows - 1;
                    for (ir = rdObj[i].HeaderRows; ir <= rowcount; ir++) {
                        if ( rdObj[i].CellValue(ir,1) == 1 ) {                    
                            rowXml = "<TR>";
                            for (ic = 0; ic<= rdObj[i].LastCol; ic++) {
                                rowXml += "<TD><![CDATA[" + rdObj[i].CellValue(ir,ic) + "]]></TD>";
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
            sXml4012 +="    <HJS_REF>"   + document.form.rpt_hjsref   .value + "</HJS_REF>"  ;
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
    
            if ( rdObj[0].RowCount  == "0")                     // RD 로 보낼 sheet 에 데이타가 없으면 Error
            {
                errMsg = 'No data found.';
                showErrMessage(errMsg);
                return;
            }
            rdObjects[0].AutoAdjust = 0;
            rdObjects[0].ZoomRatio = 0
            rdObjects[0].HideToolbar();
            rdObjects[0].HideStatusbar();
            rdObjects[0].ViewShowMode(1);
                    
            rdObjects[0].setbackgroundcolor(255,255,255);
            rdObjects[0].SetPageLineColor(255,255,255);         
            rdObjects[0].SetRData(sXml4012);
            
            document.form.rpt_contents.value = sXml4012;
            
            var tInvNo = "";
            var tTrfType = "";
            for ( var z01 = 1 ; z01 < sheetObjects[0].RowCount+1 ; z01++  ) {
                if ( sheetObjects[0].CellValue(z01,1) == 1 ) {
                    tInvNo = sheetObjects[0].CellValue(z01,"invnoo") + "," + tInvNo;
                    tTrfType = sheetObjects[0].CellValue(z01,"tarftp") + "," + tTrfType;
                    tCreOf = sheetObjects[0].CellValue(z01,"isseof") + "," + tCreOf;
                }
            }
            document.form.invno.value = tInvNo;
            document.form.creof.value = tCreOf;
            
            var rdParam = " /rwait /rp [" + document.form.arif .value +"] " +
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
                                                                   "[" + document.form.rpt_hjsref   .value +"] " +
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
           
            rdObjects[0].SetAppendReport(0);
            
            if ( document.form.cntrinvno.value == "0" && document.form.rpt_leftright.value == "L" ) {
                rdObjects[0].FileOpen(RD_path+'apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4903.mrd',RDServer+rdParam);
            } else if ( document.form.cntrinvno.value == "0" && document.form.rpt_leftright.value == "R" ) {
                rdObjects[0].FileOpen(RD_path+'apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4904.mrd',RDServer+rdParam);
            }            
            
            if ( document.form.attachYN.checked ) {
            
//                var tInvNo = "";            
//                for ( var z01 = 1 ; z01 < sheetObjects[0].RowCount+1 ; z01++  ) {
//                    if ( sheetObjects[0].CellValue(z01,1) == 1 ) {
//                        tInvNo = sheetObjects[0].CellValue(z01,3) + "," + tInvNo;
//                    }
//                }
//                document.form.invno.value = tInvNo;
                var rdParam2 = "/rp [" + document.form.invno.value + "] [" + document.form.isof.value + "] [" + document.form.creof.value + "]" ;
                rdObjects[0].SetAppendReport(1);
                rdObjects[0].FileOpen(RD_path+'apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4907.mrd', RDServerBAT + rdParam2);
               
            }
            rdObjects[0].PrintDialog();
        }
        

    }    
    
    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){

       sheetObjects[sheetCnt++] = sheet_obj;

    }

    function setComboObject(combo_obj) {  
         comboObjects[comboCnt++] = combo_obj;  
    }

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	 
    	 var opener = window.dialogArguments;
    	 var opnSheetObj = opener.document.form.sheet1;
    	 
    	 ComSetObjValue(document.form.payn, opnSheetObj.CellValue(opnSheetObj.SelectRow, "payern"));
    	 ComSetObjValue(document.form.rpt_custname, opnSheetObj.CellValue(opnSheetObj.SelectRow, "payern"));

        for(i=0;i<sheetObjects.length;i++){

        //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);

                //doActionIBSheet(sheetObjects[i],document.form,IBSEARCH);
        }
        
        for(var k=0;k<comboObjects.length;k++){
            initCombo(comboObjects[k],k+1);
        }        
        
//        initControl();

        
        doActionIBCombo(sheetObjects[3], document.form, COMMAND02, COMMAND02, "", ""); // ATTENSINO 조회
//        alert("eamil [" + document.form.payr_emailnos.value + "]");
        

        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01); // REMARK 조회
        doActionIBSheet(sheetObjects[2],document.form,IBSEARCH_ASYNC04);
      
        doInit();
         
        
    }

    function doInit() {
        var sheetObj = sheetObjects[0]; 
        var formObj = document.form;
        ComSetObjValue(formObj.payer_cd, formObj.payc);
        ComSetObjValue(formObj.payer_nm, formObj.payn);
        searchAttentionList();
    }
     
    /**
     * Attention 를 조회하는 함수
     */ 
    function searchAttentionList() {
        //Attention Combo
        setPayerCd();

        var sheetObj = sheetObjects[3];
        var comboObj = comboObjects[0];
        var formObj = document.form;
        
        //payer code가 존재하지 않을때
        if(ComGetObjValue(formObj.payer_cd) == null || ComGetObjValue(formObj.payer_cd) == "") {
            comboObj.RemoveAll();
            return;
        }
        ComSetObjValue(formObj.ofc_cd, ComGetObjValue(formObj.h_usr_off));
        
        doActionIBCombo(sheetObj,formObj,IBSEARCH,SEARCHLIST03,"ATTENTION", comboObj);

    }    
    
    /**
     * Attention Combo를 조회하기 위한 Payer Code
     * @return
     */
    function setPayerCd() {
        var formObj = document.form;
        
        var payer_cd    = ComGetObjValue(formObj.payc);
        var cust_cnt_cd = "";
        var cust_seq    = "";
        
        //Service Provider
        if(payer_cd.length == 6) {
            cust_cnt_cd = "00";
            cust_seq    = payer_cd;
        }else if(payer_cd.length == 8){
            cust_cnt_cd = payer_cd.substring(0,2);
            cust_seq    = payer_cd.substring(2);
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
     * Combo 기본 설정 
     * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
     * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
     */ 
    function initCombo(comboObj, comboNo) {
        var formObj = document.form
        switch(comboNo) { 
            //Attention
            case 1:
                with (comboObj) {
                    MultiSelect = false;
                    SetColAlign("left|left|left|left");
                    DropHeight = 160;
                }
                break;
            
         }      
    } 
     
    function rdOpen(rdObject,formObject){ // DETAIL RD PRINT - Detail Print BTN
        var Rdviewer = rdObject ;
        rdObjects[0].AutoAdjust = 0;
        rdObjects[0].ZoomRatio = 0
        rdObjects[0].HideToolbar();
        rdObjects[0].HideStatusbar();
        rdObjects[0].ViewShowMode(1);
                
        rdObjects[0].setbackgroundcolor(255,255,255);
        rdObjects[0].SetPageLineColor(255,255,255);           
        
        var tInvNo = "";      
        var tCreOf = "";	//cre_ofc_cd
        
        for ( var z01 = 1 ; z01 < sheetObjects[0].RowCount+1 ; z01++  ) {
            if ( sheetObjects[0].CellValue(z01,1) == 1 ) {
                tInvNo = sheetObjects[0].CellValue(z01,"invnoo") + "," + tInvNo;
                tCreOf = sheetObjects[0].CellValue(z01,"isseof") + "," + tCreOf;
            }
        }
        document.form.invno.value = tInvNo;
        document.form.creof.value = tCreOf;
                
        var rdParam = " /rwait /rp [" + document.form.invno.value + "] [" + document.form.isof.value + "] [" + document.form.creof.value + "]" ;

        rdObjects[0].SetAppendReport(0);
        // 열고자 하는 RD 파일을 지정한다.
        rdObjects[0].FileOpen(RD_path+'apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4907.mrd', RDServerBAT + rdParam);
        Rdviewer.PrintDialog();
    }     
     

  /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
        var sheetID = sheetObj.id;
//        ComDebug ( "sheetID [" + sheetID + "]" );
        switch(sheetID) {
        
            case "sheet1":      // sheet1 init 인보이스
                with (sheetObj) {
                    // 높이 설정
                    style.height = 160;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 2, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(39, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle  = "||Seq.|INV No.|AR I/F|VVD CD|BKG No.|B/L No.|POR|POL|POD|DEL|Cur.|Billing AMT|TAX AMT|Payable AMT|Type|Issue DT|INV Over Days|Local S/Rep.|SC|RFA|TAA|SHPR Code|SHPR NM|CNEE Code|CNEE NM|INCURRED|CMDT|EXCEPT|AFTER DC|INV RMK|Sales Team|Salse Rep||||";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
          
                    // 데이터 속성  [ ROW , COL   , DATATYPE       , WIDTH , DATAALIGN , COLMERGE , SAVENAME   , KEYFIELD , CALCULOGIC , DATAFORMAT , POINTCOUNT , UPDATEEDIT , INSERTEDIT , EDITLEN , FULLINPUT , SORTENABLE , TOOLTIP , ALLCHECK , SAVESTATUS , FORMATFIX ]
                    InitDataProperty( 0   , cnt++ , dtHiddenStatus ,  0    , daCenter  , true     , "ibflag"                                           );  
                    InitDataProperty( 0   , cnt++ , dtCheckBox     , 30    , daCenter  , true     , "CheckBox"		, false    , ""			, dfNone,			0,		false,		false);
                    InitDataProperty( 0   , cnt++ , dtSeq          , 30    , daCenter  , true     , "SEQ"           , false    , ""			, dfNone,			0,		false,		false);
                    InitDataProperty( 0   , cnt++ , dtData         , 90    , daCenter  , true     , "invnoo"   		, false    , ""         , dfNone,			0,		false,		false);
                    InitDataProperty( 0   , cnt++ , dtData         , 60    , daCenter  , true     , "dmdt_ar_if_cd"	, false    , ""         , dfNone,			0,		false,		false); 
                    InitDataProperty( 0   , cnt++ , dtData         , 75    , daCenter  , true     , "vvdcdd"   		, false    , ""         , dfNone,			0,		false,		false);
                    InitDataProperty( 0   , cnt++ , dtData         , 95    , daCenter  , true     , "bkgnoo"   		, false    , ""         , dfNone,			0,		false,		false        );
                    InitDataProperty( 0   , cnt++ , dtHidden       , 85    , daCenter  , true     , "blnooo"   		, false    , ""         , dfNone,			0,		false,		false        );
                    InitDataProperty( 0   , cnt++ , dtData         , 45    , daCenter  , true     , "por_cd"   		, false    , ""         , dfNone,			0,		false,		false        );
                    InitDataProperty( 0   , cnt++ , dtData         , 45    , daCenter  , true     , "pol_cd"   		, false    , ""         , dfNone,			0,		false,		false        );
                    InitDataProperty( 0   , cnt++ , dtData         , 45    , daCenter  , true     , "pod_cd"   		, false    , ""         , dfNone,			0,		false,		false        );
                    InitDataProperty( 0   , cnt++ , dtData         , 45    , daCenter  , true     , "del_cd"   		, false    , ""         , dfNone,			0,		false,		false        );
                    InitDataProperty( 0   , cnt++ , dtData         , 40    , daCenter  , true     , "currcy"  		, false    , ""         , dfNone,			0,		false,		false        );
                    InitDataProperty( 0   , cnt++ , dtData         , 110   , daRight   , true     , "bilamt"   		, false    , ""         , dfFloat   , 2,		false,		false );
                    InitDataProperty( 0   , cnt++ , dtData         , 110   , daRight   , true     , "taxamt"   		, false    , ""         , dfFloat   , 2,		false,		false );
                    InitDataProperty( 0   , cnt++ , dtData         , 110   , daRight   , true     , "invamt"   		, false    , ""         , dfFloat   , 2,		false,		false );
                    InitDataProperty( 0   , cnt++ , dtData         , 50    , daCenter  , true     , "tarftp"   		, false    , ""         , dfNone,			0,		false,		false             );
                    InitDataProperty( 0   , cnt++ , dtData         , 80    , daCenter  , true     , "issedt"   		, false    , ""         , dfDateYmd,			0,		false,		false     );
                    InitDataProperty( 0   , cnt++ , dtData         , 90    , daRight   , true     , "invovd"   		, false    , ""         , dfNullInteger,			0,		false,		false );
                    InitDataProperty( 0   , cnt++ , dtData         , 60    , daCenter  , true     , "ob_srep_cd"	, false    , ""         , dfNone,			0,		false,		false 		);                    

                    InitDataProperty( 0   , cnt++ , dtData         , 80    , daCenter  , true     , "sc_no"			, false    , ""         , dfNone,			0,		false,		false 		);
                    InitDataProperty( 0   , cnt++ , dtData         , 80    , daCenter  , true     , "rfa_no"		, false    , ""         , dfNone,			0,		false,		false 		);
                    InitDataProperty( 0   , cnt++ , dtData         , 80    , daCenter  , true     , "taa_no"		, false    , ""         , dfNone,			0,		false,		false 		);
                    InitDataProperty( 0   , cnt++ , dtData         , 80    , daCenter  , true     , "sh_cust_cd"	, false    , ""         , dfNone,			0,		false,		false 		);
                    InitDataProperty( 0   , cnt++ , dtData         , 120   , daLeft	   , true     , "sh_cust_nm"	, false    , ""         , dfNone,			0,		false,		false       );
                    InitDataProperty( 0   , cnt++ , dtData         , 80    , daCenter  , true     , "cn_cust_cd"	, false    , ""         , dfNone,			0,		false,		false 		);
                    InitDataProperty( 0   , cnt++ , dtData         , 120   , daLeft	   , true     , "cn_cust_nm"	, false    , ""         , dfNone,			0,		false,		false 		);
                    InitDataProperty( 0   , cnt++ , dtData         , 110   , daRight   , true     , "org_chg_amt"	, false    , ""         , dfFloat, 			2,		false,		false 		);
                    InitDataProperty( 0   , cnt++ , dtData         , 110   , daRight   , true     , "cmdt_expt_amt"		, false    , ""         , dfFloat , 	2,		false,		false 		);
                    InitDataProperty( 0   , cnt++ , dtData         , 110   , daRight   , true     , "sc_rfa_expt_amt"	, false    , ""         , dfFloat , 	2,		false,		false 		);
                    InitDataProperty( 0   , cnt++ , dtData         , 110   , daRight   , true     , "aft_expt_dc_amt"	, false    , ""         , dfFloat , 	2,		false,		false 		);
                    InitDataProperty( 0   , cnt++ , dtData         , 120   , daLeft	   , true     , "inv_rmk"			, false    , ""         , dfNone,		0,		false,		false 		);
                    InitDataProperty( 0   , cnt++ , dtData         , 80   , daCenter   , true     , "ib_sls_ofc_cd"		, false    , ""         , dfEngUpKey,	0,		true,		false, 6 	);
                    InitDataProperty( 0   , cnt++ , dtData         , 80   , daCenter   , true     , "ib_srep_cd"		, false    , ""         , dfEngUpKey,	0,		true,		false, 5 	);
                    
                    InitDataProperty( 0   , cnt++ , dtHidden       , 80    , daCenter  , true     , "comamt"   		, false    , ""         , dfNone        );
                    InitDataProperty( 0   , cnt++ , dtHidden       , 80    , daCenter  , true     , "isseof"   		, false    , ""         , dfNone        );
                    InitDataProperty( 0   , cnt++ , dtHidden       , 80    , daCenter  , true     , "payrcd"   		, false    , ""         , dfNone        );                    
                    InitDataProperty( 0   , cnt++ , dtHidden       , 80    , daCenter  , true     , "sheetp"   		, false    , ""         , dfNone        );
                    InitDataProperty( 0   , cnt++ , dtHidden       , 80    , daCenter  , true     , "dmdt_inv_tp_cd", false    , ""         , dfNone        );

//                    CountPosition = 0;
                    InitDataValid(0, "ib_srep_cd", vtNumericOther, "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
                    
                    ToolTipOption = "balloon:true;width:50;";
                    ToolTipText(0,"invovd") = "Over Days from Invoice Issued date";
                    AutoRowHeight = false;
               }
            break;
            
            case "sheet2":      // sheet1 init 엑셀
                with (sheetObj) {
                    // 높이 설정
                    style.height = 0;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;
                    
                    Visible = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 2, 100);
                    
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle  = "Seq.|Payer CD|Payer Name|SHPR Code|SHPR NM|CNEE Code|CNEE NM|NFTY Code|NFTY NM|VVD CD|BKG No.|B/L No.|CNTR No.|POR|POL|POD|DEL|SC|RFA|TAA|CMDT Code|CMDT|Type"
                    	           + "|F/D|Over|From YD|To YD|From Date|To Date|F/D CMNC|F/D END|Incur Cur.|INCURRED|CMDT|EXCEPT|Estibillable bilable|AFTER DC Cur|AFTER DC|" +
                    	           		"Billing Cur.|Billing AMT|TAX AMT|Payable AMT|INV No.|INV RMK|AR|AR Date|Issue DT|INV Over Days|Local S/Rep.|Sales OFC|Sales Rep.";

                    var headCount = ComCountHeadTitle(HeadTitle); 
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL   , DATATYPE   , WIDTH, DATAALIGN, COLMERGE, SAVENAME   , KEYFIELD, CALCULOGIC, DATAFORMAT    , POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]

                    InitDataProperty( 0   , cnt++ , dtSeq          , 30    , daCenter  , true     , "SEQ"                                              );
                    InitDataProperty( 0   , cnt++ , dtData         , 70    , daCenter  , true     , "payerc"   	    , false    , ""         , dfNone        );
                    InitDataProperty( 0   , cnt++ , dtData         , 320   , daLeft    , true     , "payern"   	    , false    , ""         , dfNone        );
                    InitDataProperty( 0   , cnt++ , dtData         , 80    , daCenter  , true     , "sh_cust_cd"	, false    , ""         , dfNone 		);
                    InitDataProperty( 0   , cnt++ , dtData         , 120   , daLeft	   , false     , "sh_cust_nm"	, false    , ""         , dfNone        );
                    InitDataProperty( 0   , cnt++ , dtData         , 80    , daCenter  , true     , "cn_cust_cd"	, false    , ""         , dfNone 		);
                    InitDataProperty( 0   , cnt++ , dtData         , 120   , daLeft	   , false     , "cn_cust_nm"	, false    , ""         , dfNone 		);
                    InitDataProperty( 0   , cnt++ , dtData         , 80    , daCenter  , true     , "nf_cust_cd"	, false    , ""         , dfNone 		);
                    InitDataProperty( 0   , cnt++ , dtData         , 120   , daLeft	   , false     , "nf_cust_nm"	, false    , ""         , dfNone 		);
                    
                    InitDataProperty( 0   , cnt++ , dtData         , 75    , daCenter  , true     , "vvdcdd"   		, false    , ""         , dfNone        );
                    InitDataProperty( 0   , cnt++ , dtData         , 95    , daCenter  , true     , "bkgnoo"   		, false    , ""         , dfNone        );
                    InitDataProperty( 0   , cnt++ , dtHidden       , 85    , daCenter  , true     , "blnooo"   		, false    , ""         , dfNone        );
                    InitDataProperty( 0   , cnt++ , dtData         , 85    , daCenter  , true     , "cntr_no"   	, false    , ""         , dfNone        );
                    InitDataProperty( 0   , cnt++ , dtData         , 45    , daCenter  , true     , "por_cd"   		, false    , ""         , dfNone        );
                    InitDataProperty( 0   , cnt++ , dtData         , 45    , daCenter  , true     , "pol_cd"   		, false    , ""         , dfNone        );
                    InitDataProperty( 0   , cnt++ , dtData         , 45    , daCenter  , true     , "pod_cd"   		, false    , ""         , dfNone        );
                    InitDataProperty( 0   , cnt++ , dtData         , 45    , daCenter  , true     , "del_cd"   		, false    , ""         , dfNone        );
                    InitDataProperty( 0   , cnt++ , dtData         , 80    , daCenter  , true     , "sc_no"			, false    , ""         , dfNone 		);
                    InitDataProperty( 0   , cnt++ , dtData         , 80    , daCenter  , true     , "rfa_no"		, false    , ""         , dfNone 		);
                    
                    InitDataProperty( 0   , cnt++ , dtData         , 80    , daCenter  , true     , "taa_no"		, false    , ""         , dfNone 		);
                    InitDataProperty( 0   , cnt++ , dtData         , 80    , daCenter  , true     , "cmdt_cd"		, false    , ""         , dfNone 		);
                    InitDataProperty( 0   , cnt++ , dtData         , 110   , daCenter  , true     , "cmdt_nm"		, false    , ""         , dfNone		);
                    InitDataProperty( 0   , cnt++ , dtData         , 50    , daCenter  , true     , "tarftp"   		, false    , ""         , dfNone        );
                    InitDataProperty( 0   , cnt++ , dtData         , 50    , daCenter  , true     , "ft_dys"   		, false    , ""         , dfNone        );
                    InitDataProperty( 0   , cnt++ , dtData         , 50    , daCenter  , true     , "fx_ft_ovr_dys"   		, false    , ""         , dfNone        );
                    InitDataProperty( 0   , cnt++ , dtData         , 80    , daCenter  , true     , "fm_mvmt_yd_cd"   		, false    , ""         , dfNone        );
                    InitDataProperty( 0   , cnt++ , dtData         , 80    , daCenter  , true     , "to_mvmt_yd_cd"   		, false    , ""         , dfNone        );
                    InitDataProperty( 0   , cnt++ , dtData         , 80    , daCenter  , true     , "fm_mvmt_dt"   		, false    , ""         , dfDateYmd        );
                    InitDataProperty( 0   , cnt++ , dtData         , 80    , daCenter  , true     , "to_mvmt_dt"   		, false    , ""         , dfDateYmd        );

                    InitDataProperty( 0   , cnt++ , dtData         , 80    , daCenter  , true     , "ft_cmnc_dt"   		, false    , ""         , dfDateYmd        );
                    InitDataProperty( 0   , cnt++ , dtData         , 80    , daCenter  , true     , "ft_end_dt"   		, false    , ""         , dfDateYmd        );   
                    InitDataProperty( 0   , cnt++ , dtData         , 80    , daCenter  , true     , "bzc_trf_curr_cd"   		, false    , ""         , dfNone        );   
                    InitDataProperty( 0   , cnt++ , dtData         , 110   , daRight   , true     , "org_chg_amt"	, false    , ""         , dfFloat   , 2 );
                    InitDataProperty( 0   , cnt++ , dtData         , 110   , daRight   , true     , "cmdt_expt_amt"		, false    , ""         , dfFloat   , 2 );
                    InitDataProperty( 0   , cnt++ , dtData         , 110   , daRight   , true     , "sc_rfa_expt_amt"	, false    , ""         , dfFloat   , 2 );
                    InitDataProperty( 0   , cnt++ , dtData         , 110   , daRight   , true     , "net_expt_amt"	, false    , ""         , dfFloat   , 2 );
                    InitDataProperty( 0   , cnt++ , dtData         , 80    , daCenter  , true     , "chg_curr_cd"   		, false    , ""         , dfNone        );   
                    InitDataProperty( 0   , cnt++ , dtData         , 110   , daRight   , true     , "aft_expt_dc_amt"	, false    , ""         , dfFloat   , 2 );

                    InitDataProperty( 0   , cnt++ , dtData         , 40    , daCenter  , true     , "currcy"  		, false    , ""         , dfNone        );
                    InitDataProperty( 0   , cnt++ , dtData         , 110   , daRight   , true     , "bilamt"   		, false    , ""         , dfFloat   , 2 );
                    InitDataProperty( 0   , cnt++ , dtData         , 110   , daRight   , true     , "taxamt"   		, false    , ""         , dfFloat   , 2 );
                    InitDataProperty( 0   , cnt++ , dtData         , 110   , daRight   , true     , "invamt"   		, false    , ""         , dfFloat   , 2 );
                    
                    InitDataProperty( 0   , cnt++ , dtData         , 70    , daCenter  , true     , "invnoo"   		, false    , ""         , dfNone        );
                    
                    InitDataProperty( 0   , cnt++ , dtData         , 120   , daLeft	   , false     , "inv_rmk"		, false    , ""         , dfNone 		);
                    InitDataProperty( 0   , cnt++ , dtData         , 60    , daCenter  , true     , "dmdt_ar_if_cd"	, false    , ""         , dfNone 		); 
                    InitDataProperty( 0   , cnt++ , dtData         , 60    , daCenter  , true     , "ar_if_dt"	, false    , ""         , dfDateYmd 		);  
                    InitDataProperty( 0   , cnt++ , dtData         , 80    , daCenter  , true     , "issedt"   		, false    , ""         , dfNone     ); 
                    InitDataProperty( 0   , cnt++ , dtData         , 80    , daCenter  , true     , "oveday"   		, false    , ""         , dfNone     ); 
                    InitDataProperty( 0   , cnt++ , dtData         , 60    , daCenter  , true     , "ob_srep_cd"	, false    , ""         , dfNone 		);  
                    InitDataProperty( 0   , cnt++ , dtData         , 120   , daCenter  , false     , "ib_sls_ofc_cd"		, false    , ""         , dfNone 		);
                    InitDataProperty( 0   , cnt++ , dtData         , 120   , daCenter  , false     , "ib_srep_cd"		, false    , ""         , dfNone 		);

                    AutoRowHeight = false;
               }
            break;

            case "sheet3":      // sheet1 init 컨테이너
                with (sheetObj) {
                    // 높이 설정
                    style.height = 0;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;
                    
//                    Visible = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 2, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(23, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle  = "||Seq.|INV No.|VVD CD|BKG No.|B/L No.|POR|POL|POD|DEL|CNTR No.|TP/SZ CD|Cur.|Billing AMT|TAX AMT|Payable AMT|Type|Issue DT|INV Over Days|||";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    // 데이터 속성  [ ROW , COL   , DATATYPE       , WIDTH , DATAALIGN , COLMERGE , SAVENAME   , KEYFIELD , CALCULOGIC , DATAFORMAT , POINTCOUNT , UPDATEEDIT , INSERTEDIT , EDITLEN , FULLINPUT , SORTENABLE , TOOLTIP , ALLCHECK , SAVESTATUS , FORMATFIX ]
                    InitDataProperty( 0   , cnt++ , dtHiddenStatus ,  0    , daCenter  , true     , "Status"                                           );  
                    InitDataProperty( 0   , cnt++ , dtCheckBox     , 30    , daCenter  , true     , "CheckBox"                                         );
                    InitDataProperty( 0   , cnt++ , dtSeq          , 30    , daCenter  , true     , "SEQ"                                              );
                    InitDataProperty( 0   , cnt++ , dtData         , 70    , daCenter  , true     , "invnoo"   , false    , ""         , dfNone        );
                    InitDataProperty( 0   , cnt++ , dtData         , 75    , daCenter  , true     , "vvdcdd"   , false    , ""         , dfNone        );
                    InitDataProperty( 0   , cnt++ , dtData         , 95    , daCenter  , true     , "bkgnoo"   , false    , ""         , dfNone        );
                    InitDataProperty( 0   , cnt++ , dtHidden       , 85    , daCenter  , true     , "blnooo"   , false    , ""         , dfNone        );
                    InitDataProperty( 0   , cnt++ , dtData         , 60    , daCenter  , true     , "por_cd"   , false    , ""         , dfNone        );
                    InitDataProperty( 0   , cnt++ , dtData         , 60    , daCenter  , true     , "pol_cd"   , false    , ""         , dfNone        );
                    InitDataProperty( 0   , cnt++ , dtData         , 60    , daCenter  , true     , "pod_cd"   , false    , ""         , dfNone        );
                    InitDataProperty( 0   , cnt++ , dtData         , 60    , daCenter  , true     , "del_cd"   , false    , ""         , dfNone        );
                    InitDataProperty( 0   , cnt++ , dtData         , 85    , daCenter  , true     , "cntrno"   , false    , ""         , dfNone        );
                    InitDataProperty( 0   , cnt++ , dtData         , 85    , daCenter  , true     , "tpszcd"   , false    , ""         , dfNone        );
                    InitDataProperty( 0   , cnt++ , dtData         , 40    , daCenter  , true     , "currcy"   , false    , ""         , dfNone        );
                    InitDataProperty( 0   , cnt++ , dtData         , 110   , daRight   , true     , "bilamt"   , false    , ""         , dfFloat   , 2 );
                    InitDataProperty( 0   , cnt++ , dtData         , 110   , daRight   , true     , "taxamt"   , false    , ""         , dfFloat   , 2 );
                    InitDataProperty( 0   , cnt++ , dtData         , 110   , daRight   , true     , "invamt"   , false    , ""         , dfFloat   , 2 );
                    InitDataProperty( 0   , cnt++ , dtData         , 50    , daCenter  , true     , "tarftp"   , false    , ""         , dfNone        );
                    InitDataProperty( 0   , cnt++ , dtData         , 80    , daCenter  , true     , "issedt"   , false    , ""         , dfDateYmd     );
                    InitDataProperty( 0   , cnt++ , dtData         , 80    , daCenter  , true     , "invovd"   , false    , ""         , dfNullInteger );

                    InitDataProperty( 0   , cnt++ , dtHidden       , 80    , daCenter  , true     , "comamt"   , false    , ""         , dfNone        );
                    InitDataProperty( 0   , cnt++ , dtHidden       , 80    , daCenter  , true     , "isseof"   , false    , ""         , dfNone        );
                    InitDataProperty( 0   , cnt++ , dtHidden       , 80    , daCenter  , true     , "payrcd"   , false    , ""         , dfNone        );                    

               }
            break;
            
            
            case 4: // DUMMY REQUEST TARGET 처리위한
                with (sheetObj) {
                    // 높이 설정
                    style.height = 0;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 2, 1, 2, 100);

                    var HeadTitle = "";
                    var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    CountPosition = 0;
                }
                break;   
        
            case "sheet5":      // sheet2 init
             
                with (sheetObj) {
                    // 높이 설정
                    style.height = 215;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 2, 100);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle  = "Sales OFC|Incurred Amt|CMDT Amt|Except Amt|Net Amt|After DC Amt|Billing Amt|Tax Amt|Payable Amt|Collected Amt"

                    var headCount = ComCountHeadTitle(HeadTitle);
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL   , DATATYPE   , WIDTH, DATAALIGN, COLMERGE, SAVENAME   , KEYFIELD, CALCULOGIC, DATAFORMAT    , POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    
                    InitDataProperty( 0 , cnt++ , dtData     , 65   , daCenter , true    , "ofc_cd"   	, false   , ""        , dfNone        	, 0         , false     , false    );
                    InitDataProperty( 0 , cnt++ , dtAutoSum  , 110  , daRight  , true    , "org_chg_amt"   	, false   , ""        , dfFloat   	, 2         , false     , false    );
                    InitDataProperty( 0 , cnt++ , dtAutoSum  , 90   , daRight  , true    , "cmdt_expt_amt"   	, false   , ""        , dfFloat   	, 2         , false     , false    );
                    InitDataProperty( 0 , cnt++ , dtAutoSum  , 90   , daRight  , true    , "dmdt_expt_amt"   	, false   , ""        , dfFloat   	, 2         , false     , false    );
                    InitDataProperty( 0 , cnt++ , dtAutoSum  , 110  , daRight  , true    , "net_expt_amt"   	, false   , ""        , dfFloat   	, 2         , false     , false    );
                    InitDataProperty( 0 , cnt++ , dtAutoSum  , 90   , daRight  , true    , "dc_amt"   	, false   , ""        , dfFloat   	, 2         , false     , false    );
                    InitDataProperty( 0 , cnt++ , dtAutoSum  , 110  , daRight  , true    , "bil_amt"   	, false   , ""        , dfFloat   	, 2         , false     , false    );
                    InitDataProperty( 0 , cnt++ , dtAutoSum  , 90   , daRight  , true    , "tax_amt"   	, false   , ""        , dfFloat   	, 2         , false     , false    );
                    InitDataProperty( 0 , cnt++ , dtAutoSum  , 110  , daRight  , true    , "inv_chg_amt"   	, false   , ""        , dfFloat   	, 2         , false     , false    );
                    InitDataProperty( 0 , cnt++ , dtAutoSum  , 110  , daRight  , true    , "inv_amt"   	, false   , ""        , dfFloat   	, 2         , false     , false    );

                    CountPosition = 0;
               }
            break;
        }
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

            case IBSEARCH:      //조회
                formObj.f_cmd.value = SEARCH;
                sheetObj.Reset();
                
                initSheet(sheetObjects[0], 0);
                
				// ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
                
                sheetObj.DoSearch4Post( "EES_DMT_4018GS.do" , FormQueryString(formObj) );

// ComOpenWait(false);
                
            break;
            
            case IBSEARCH_ASYNC09:      //조회
                formObj.f_cmd.value = COMMAND01;
                sheetObj.Reset();
                
                initSheet(sheetObjects[4], 0);
                
				// ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
                
                sheetObj.DoSearch4Post( "EES_DMT_4018GS.do" , FormQueryString(formObj) );

// ComOpenWait(false);
                
            break;

            case IBSEARCH_ASYNC01:      //Remark 조회
                formObj.f_cmd.value = SEARCH01; // searchOTSInquiryByDetailListRemark
            
				// ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
            
                var sXml = sheetObj.GetSearchXml("EES_DMT_4018GS.do",FormQueryString(formObj));
                
// ComOpenWait(false);
                                
                var rtnRemark = ComGetEtcData(sXml, "rtnRemark");
                    if ( rtnRemark != undefined && rtnRemark != '') {
                    var paryInfoArr = rtnRemark.split("|");

                    var paryInfoArr2                  = paryInfoArr[0].split("\n");
                    if ( !ComIsEmpty(paryInfoArr2[0]) ) {
                        document.form.remark01.value= ComReplaceStr(paryInfoArr2[0],"'"," ");
                    } else {
                        document.form.remark01.value= "";
                    }
                    if ( !ComIsEmpty(paryInfoArr2[1]) ) {
                        document.form.remark02.value = ComReplaceStr(paryInfoArr2[1],"'"," ");
                    } else {
                        document.form.remark02.value= "";
                    }

                    if ( !ComIsEmpty ( paryInfoArr[2] ) ) {
                        var paryInfoAddr = paryInfoArr[2].split("\n");
                        var paryInfoAddrCnt = paryInfoAddr.length;
                        if ( paryInfoAddrCnt >= 1 ) {
                            document.form.rpt_address01.value = ComReplaceStr(paryInfoAddr[0],"'"," ");
                        } else {
                            document.form.rpt_address01.value = "";
                        }
                        if ( paryInfoAddrCnt >= 2 ) {
                            document.form.rpt_address02.value = ComReplaceStr(paryInfoAddr[1],"'"," ");
                        } else {
                            document.form.rpt_address02.value = "";
                        }
                        if ( paryInfoAddrCnt >= 3 ) {
                            document.form.rpt_address03.value = ComReplaceStr(paryInfoAddr[2],"'"," ");
                        } else {
                            document.form.rpt_address03.value = "";
                        }
                        if ( paryInfoAddrCnt >= 4 ) {
                            document.form.rpt_address04.value = ComReplaceStr(paryInfoAddr[3],"'"," ");
                        } else {
                            document.form.rpt_address04.value = "";
                        }
//                        
//                        document.form.rpt_address01.value = paryInfoArr[2];
//                        document.form.rpt_address02.value = paryInfoArr[2];
//                        document.form.rpt_address03.value = paryInfoArr[2];
//                        document.form.rpt_address04.value = paryInfoArr[2];
                    } else {
                        document.form.rpt_address01.value = ComReplaceStr(paryInfoArr[2],"'"," ");
                        document.form.rpt_address02.value = ComReplaceStr(paryInfoArr[2],"'"," ");
                        document.form.rpt_address03.value = ComReplaceStr(paryInfoArr[2],"'"," ");
                        document.form.rpt_address04.value = ComReplaceStr(paryInfoArr[2],"'"," ");
                    }
                    document.form.rpt_telno.value     = paryInfoArr[3];
                    document.form.rpt_faxno.value     = paryInfoArr[4];
                    document.form.rpt_custvat.value   = paryInfoArr[6];
                    
                    var otsRmkArr                  = paryInfoArr[7].split("\n");
                    if ( !ComIsEmpty(otsRmkArr[0]) ) {
                        document.form.sls_rmk01.value= ComReplaceStr(otsRmkArr[0],"'"," ");
                    } else {
                        document.form.sls_rmk01.value= "";
                    }
                    if ( !ComIsEmpty(otsRmkArr[1]) ) {
                        document.form.sls_rmk02.value = ComReplaceStr(otsRmkArr[1],"'"," ");
                    } else {
                        document.form.sls_rmk02.value= "";
                    }
                }
                    
            break;
            
            case IBSEARCH_ASYNC02:      //Remark 조회
                formObj.f_cmd.value = SEARCH02; // searchOTSInquiryByDetailListRemark2
            
// ComOpenWait(true);
sheetObj.WaitImageVisible = false;
            
                var sXml = sheetObj.GetSearchXml("EES_DMT_4018GS.do",FormQueryString(formObj));
                
// ComOpenWait(false);

                
                var rtnRemark = ComGetEtcData(sXml, "rtnRemark");
                if ( rtnRemark != undefined && rtnRemark != '') {
                    //PAYR.DMDT_PAYR_OTS_RMK
                    //PAYR.DMDT_PAYR_ADDR
                    //PAYR.DMDT_PAYR_PHN_NO
                    //PAYR.DMDT_PAYR_FAX_NO
                    //CUST.CUST_RGST_NO
                    var paryInfoArr = rtnRemark.split("|");
                    document.form.rpt_ofcadd01 .value = ComReplaceStr(paryInfoArr[0],"'"," ");
                    document.form.rpt_ofcadd02 .value = ComReplaceStr(paryInfoArr[1],"'"," ");
                    document.form.rpt_ofcadd03 .value = ComReplaceStr(paryInfoArr[2],"'"," ");
                    document.form.rpt_header01 .value = ComReplaceStr(paryInfoArr[3],"'"," ");
                    document.form.rpt_header02 .value = ComReplaceStr(paryInfoArr[4],"'"," ");
                    document.form.rpt_header03 .value = ComReplaceStr(paryInfoArr[5],"'"," ");
                    document.form.rpt_header04 .value = ComReplaceStr(paryInfoArr[6],"'"," ");
                    document.form.rpt_header05 .value = ComReplaceStr(paryInfoArr[7],"'"," ");
                    document.form.rpt_header06 .value = ComReplaceStr(paryInfoArr[8],"'"," ");
                    document.form.rpt_header07 .value = ComReplaceStr(paryInfoArr[9],"'"," ");
                    document.form.rpt_header08 .value = ComReplaceStr(paryInfoArr[10],"'"," ");
                    document.form.rpt_header09 .value = ComReplaceStr(paryInfoArr[11],"'"," ");
                    document.form.rpt_header10 .value = ComReplaceStr(paryInfoArr[12],"'"," ");
                    document.form.rpt_leftright.value = paryInfoArr[13];
                    document.form.rpt_opttitle .value = paryInfoArr[14];
                    document.form.rpt_custref  .value = paryInfoArr[15];
                    document.form.rpt_telfax   .value = paryInfoArr[16];
                    document.form.rpt_custvatno.value = paryInfoArr[17];
                    
                } else {
                    document.form.rpt_leftright.value = "L";
                }
            break;            

            case IBSEARCH_ASYNC03:      //조회
                formObj.f_cmd.value = SEARCH03; // searchOTSInquiryByDetailList2
                sheetObj.Reset();
                initSheet(sheetObjects[1], 1);
                var tInvNo = "";            
                var tCreOf = "";
                for ( var z01 = 1 ; z01 < sheetObjects[0].RowCount+1 ; z01++  ) {
                    if ( sheetObjects[0].CellValue(z01,1) == 1 ) {
                        tInvNo = sheetObjects[0].CellValue(z01,"invnoo") + "," + tInvNo;
                        tCreOf = sheetObjects[0].CellValue(z01,"isseof") + "," + tCreOf;
                    }
                }
                document.form.invno.value = tInvNo;
                document.form.creof.value = tCreOf;
                
// ComOpenWait(true);
sheetObj.WaitImageVisible = false;
                
                sheetObj.DoSearch4Post( "EES_DMT_4018GS.do" , FormQueryString(formObj) );
                
// ComOpenWait(false);
                
            break; 
            
            case IBSEARCH_ASYNC04:      // CNTR NO 기준 SHEET3 조회
                formObj.f_cmd.value = SEARCH04; // searchOTSInquiryByDetailList3
                sheetObj.Reset();
                initSheet(sheetObjects[2], 1);
                
// ComOpenWait(true);
sheetObj.WaitImageVisible = false;
                
                sheetObj.DoSearch4Post( "EES_DMT_4018GS.do" , FormQueryString(formObj) );
                
// ComOpenWait(false);
                
            break;
            
            case IBSEARCH_ASYNC05:      // FAX SEND
                formObj.f_cmd.value = SEARCH05; // searchCountryListByRHQ
                sheetObj.Reset();
                initSheet(sheetObjects[2], 1);
                var sXml05 = sheetObj.GetSaveXml("DMTCommonFaxEmailGS.do", FormQueryString(formObj));
                if ( document.form.attachYN.checked && formObj.rd_fxeml_file_name.value == "EES_DMT_4907.mrd" ) {
                    alert(dmtGetMsgText(sXml05));
                } else if ( !document.form.attachYN.checked ) {
                    alert(dmtGetMsgText(sXml05));
                }
            break;

            case IBSEARCH_ASYNC06:      // EMAIL SEND
                formObj.f_cmd.value = SEARCH06; // searchCountryListByContinent
                var sXml06 = sheetObj.GetSaveXml("DMTCommonFaxEmailGS.do", FormQueryString(formObj));
                alert(dmtGetMsgText(sXml06));
            break;
            
            case IBSEARCH_ASYNC07:      // EMAIL SEND + DETAIL RD
                formObj.f_cmd.value = SEARCH07; // searchRHQHierarchyByRegion
                var sXml06 = sheetObj.GetSaveXml("DMTCommonFaxEmailGS.do", FormQueryString(formObj));
                alert(dmtGetMsgText(sXml06));
            break;
            
            case IBSEARCH_ASYNC08:      // SEND2EMALL ALL OF THEM
                    formObj.f_cmd.value = SEARCH; // searchOTSInquiryByDetailList
                    var sXml = sheetObj.GetSearchXml("EES_DMT_4101GS.do",FormQueryString(formObj));
                    var rtnRemark = ComGetEtcData(sXml, "rtnRemark");
                    if ( rtnRemark == undefined || rtnRemark == '' ) {
                        ComShowMessage(msgs["DMT01096"]);
                        return f;
                    }
            break;            
            
            case IBSAVE:        //저장
                document.form.rmrk.value = document.form.remark01.value + "\n" + document.form.remark02.value;
                document.form.sls_rmrk.value = document.form.sls_rmk01.value + "\n" + document.form.sls_rmk02.value;
                formObj.f_cmd.value = MULTI; // updateOTSInquiryByDetailListRemark
                
// 				ComOpenWait(true);
                sheetObj.WaitImageVisible = false;
                
                var sXml = sheetObj.GetSaveXml("EES_DMT_4018GS.do", FormQueryString(formObj));
                
// 				ComOpenWait(false);
                
                sheetObjects[0].LoadSaveXml(sXml);
                
// 				ComOpenWait(true);
                sheetObj.WaitImageVisible = false;
                
                doActionIBSheet( sheetObjects[0] , document.form , IBSEARCH_ASYNC01 );
                
// 				ComOpenWait(false);
                
            break;
            
            case IBINSERT:        //저장
            	
                formObj.f_cmd.value = MULTI01; // updateOTSInquiryByDetailListRemark
                sheetObj.WaitImageVisible = false;          
                
				var saveFlg = sheetObj.DoSave("EES_DMT_4018GS.do", FormQueryString(formObj));

				if ( saveFlg == true ){
					doActionIBSheet(sheetObjects[4],document.form,IBSEARCH_ASYNC09);
				}
				
				break;
        }
    }



    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
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
//        
//        axon_event.addListenerFormat( 'blur'      , 'obj_blur'      , form); //- 포커스 나갈때
//        axon_event.addListenerFormat( 'focus'     , 'obj_focus'     , form); //- 포커스 들어갈때
//        axon_event.addListenerFormat( 'keypress'  , 'obj_keypress'  , form); //- 키보드 입력할때
//        axon_event.addListenerForm  ( 'keydown'   , 'obj_keydown'   , document.form, 'rmrk');
//        axon_event.addListener      ( 'mouseover' , 'obj_mouseover' , 'td_ch', 'ch', 'rlse_dt');
//        axon_event.addListener      ( 'mouseout'  , 'obj_mouseout'  , 'td_ch', 'ch', 'rlse_dt');
        
    }
    
    function sheet1_OnSearchEnd( sheetObj , ErrMsg ) {
    	
    	with (sheetObj) {
            CheckAll(1) = 1;
            for ( var x = 1 ; x < LastRow + 1 ; x++ ) {
                sheet1_OnClickXTC( sheetObj , x , 0 , 0 );
            }

            document.form.vinvqty.value = RowCount;
            document.form.tftp2.value = sheetObjects[0].CellValue(1,15);
            document.form.invno.value = sheetObjects[0].CellValue(1,3);
            document.form.sheetp.value = sheetObjects[0].CellValue(1,21);
            
            doActionIBSheet(sheetObjects[4],document.form,IBSEARCH_ASYNC09);
            
        }
    }
    
    function sheet1_OnClickXTC( sheetObj , Row , Col , Value ) {
        with (sheetObj) {

            var vChk = CellValue(Row,1);
            var val01 = ComReplaceStr(document.form.vbilamt.value,",");
            var val02 = ComReplaceStr(document.form.vtaxamt.value,",");
            var val03 = ComReplaceStr(document.form.vpayamt.value,",");
            
            var vincamt = ComReplaceStr(document.form.vincamt.value,",");
            var vcmdtamt = ComReplaceStr(document.form.vcmdtamt.value,",");
            var vexcepamt = ComReplaceStr(document.form.vexcepamt.value,",");
            var vdcamt = ComReplaceStr(document.form.vdcamt.value,",");
           
            if( ComIsNull(val01) ) { val01 = 0; }
            if( ComIsNull(val02) ) { val02 = 0; }
            if( ComIsNull(val03) ) { val03 = 0; }

            if( ComIsNull(vincamt) ) { vincamt = 0; }
            if( ComIsNull(vcmdtamt) ) { vcmdtamt = 0; }
            if( ComIsNull(vexcepamt) ) { vexcepamt = 0; }
            if( ComIsNull(vdcamt) ) { vdcamt = 0; }
            
            if( val01 < 0 ) { val01 = 0; }
            if( val02 < 0 ) { val02 = 0; }
            if( val03 < 0 ) { val03 = 0; }

            if( vincamt < 0 ) { vincamt = 0; }
            if( vcmdtamt < 0 ) { vcmdtamt = 0; }
            if( vexcepamt < 0 ) { vexcepamt = 0; }
            if( vdcamt < 0 ) { vdcamt = 0; }
            
            if ( vChk == 1 ) { // 선택해제
            	
                document.form.vbilamt.value = DmtAddComma( ComRound ( eval(val01) - eval(CellValue(Row,13 )) ) + "" , "#,###.00");
                document.form.vtaxamt.value = DmtAddComma( ComRound ( eval(val02) - eval(CellValue(Row,14 )) ) + "" , "#,###.00");
                document.form.vpayamt.value = DmtAddComma( ComRound ( eval(val03) - eval(CellValue(Row,15)) ) + "" , "#,###.00");
                
                document.form.vincamt.value = DmtAddComma( ComRound ( eval(vincamt) - eval(sheetObjects[0].CellValue(Row,'org_chg_amt' )) ) + "" , "#,###.00");
                document.form.vcmdtamt.value = DmtAddComma( ComRound ( eval(vcmdtamt) - eval(sheetObjects[0].CellValue(Row,'cmdt_expt_amt' )) ) + "" , "#,###.00");
                document.form.vexcepamt.value = DmtAddComma( ComRound ( eval(vexcepamt) - eval(sheetObjects[0].CellValue(Row,'sc_rfa_expt_amt' )) ) + "" , "#,###.00");
                document.form.vdcamt.value = DmtAddComma( ComRound ( eval(vdcamt) - eval(sheetObjects[0].CellValue(Row,'aft_expt_dc_amt' )) ) + "" , "#,###.00");
                
                
                CellValue(Row,1) = 0;
                CheckAll( 1 ) = 0;
                sheetObjects[2].CellValue(Row,1) = 0;
            } else { // 선택해제
                document.form.vbilamt.value = DmtAddComma( ComRound ( eval(CellValue(Row,13 )) + eval(val01) ) + "" , "#,###.00");
                document.form.vtaxamt.value = DmtAddComma( ComRound ( eval(CellValue(Row,14 )) + eval(val02) ) + "" , "#,###.00"); 
                document.form.vpayamt.value = DmtAddComma( ComRound ( eval(CellValue(Row,15)) + eval(val03) ) + "" , "#,###.00");

                document.form.vincamt.value = DmtAddComma( ComRound ( eval(sheetObjects[0].CellValue(Row,'org_chg_amt' )) + eval(vincamt) ) + "" , "#,###.00");
                document.form.vcmdtamt.value = DmtAddComma( ComRound ( eval(sheetObjects[0].CellValue(Row,'cmdt_expt_amt' )) + eval(vcmdtamt) ) + "" , "#,###.00");
                document.form.vexcepamt.value = DmtAddComma( ComRound ( eval(sheetObjects[0].CellValue(Row,'sc_rfa_expt_amt' )) + eval(vexcepamt) ) + "" , "#,###.00");
                document.form.vdcamt.value = DmtAddComma( ComRound ( eval(sheetObjects[0].CellValue(Row,'aft_expt_dc_amt' )) + eval(vdcamt) ) + "" , "#,###.00");
                
                CellValue(Row,1) = 1;
                sheetObjects[2].CellValue(Row,1) = 1;
            }
        }
    }    
    
    function sheet1_OnMouseDown( sheetObj , Button , Shift , X , Y ) {
        with (sheetObj) {
            if ( MouseRow == 0 && MouseCol == 1 && Button == 1 ) {
                if ( CheckAll( 1 ) == 0 ) {
                    document.form.vbilamt.value = "0.00";
                    document.form.vtaxamt.value = "0.00";
                    document.form.vpayamt.value = "0.00";

                    document.form.vincamt.value = "0.00";
                    document.form.vcmdtamt.value = "0.00";
                    document.form.vexcepamt.value = "0.00";
                    document.form.vdcamt.value = "0.00";                    
                    
                    for ( var x = 1 ; x < LastRow + 1 ; x++ ) {
                        CellValue( x , 1 ) = 0;
                        sheetObjects[2].CellValue( x , 1 ) = 0;
                    }
                    sheet1_OnSearchEndXTC( sheetObj , "" );
                    document.form.vinvqty.value = RowCount;
                } else if ( CheckAll( 1 ) == 1 ) {
                    document.form.vbilamt.value = "0.00";
                    document.form.vtaxamt.value = "0.00";
                    document.form.vpayamt.value = "0.00";
                    
                    document.form.vincamt.value = "0.00";
                    document.form.vcmdtamt.value = "0.00";
                    document.form.vexcepamt.value = "0.00";
                    document.form.vdcamt.value = "0.00";    
                    
                    for ( var x = 1 ; x < LastRow + 1 ; x++ ) {
                        CellValue( x , 1 ) = 0;
                        sheetObjects[2].CellValue( x , 1 ) = 0;
                    }
                    document.form.vinvqty.value = "0";
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
            for ( var x = 1 ; x < LastRow + 1 ; x++ ) {
                sheet1_OnClickXTC( sheetObj , x , 0 , 0 );
            }
        }
    }    
    
    function sheet1_OnClick( sheetObj , Row , Col , Value ) {
        with (sheetObj) {
            if ( Row > 0 && Col == 1 ) {
                var vChk = sheetObjects[0].CellValue(Row,1);
                var val01 = ComReplaceStr(document.form.vbilamt.value,",");
                var val02 = ComReplaceStr(document.form.vtaxamt.value,",");
                var val03 = ComReplaceStr(document.form.vpayamt.value,",");
                var val04 = ComReplaceStr(document.form.vinvqty.value,",");
                
                var vincamt = ComReplaceStr(document.form.vincamt.value,",");
                var vcmdtamt = ComReplaceStr(document.form.vcmdtamt.value,",");
                var vexcepamt = ComReplaceStr(document.form.vexcepamt.value,",");
                var vdcamt = ComReplaceStr(document.form.vdcamt.value,",");
                
                if( ComIsNull(val01) ) { val01 = 0; }
                if( ComIsNull(val02) ) { val02 = 0; }
                if( ComIsNull(val03) ) { val03 = 0; }
                if( ComIsNull(val04) ) { val04 = 0; }
                
                if( ComIsNull(vincamt) ) { vincamt = 0; }
                if( ComIsNull(vcmdtamt) ) { vcmdtamt = 0; }
                if( ComIsNull(vexcepamt) ) { vexcepamt = 0; }
                if( ComIsNull(vdcamt) ) { vdcamt = 0; }

                if ( vChk == 1 ) { // 선택해제
                    document.form.vbilamt.value = DmtAddComma( ComRound ( eval(val01) - eval(sheetObjects[0].CellValue(Row,13 )) ) + "" , "#,###.00");
                    document.form.vtaxamt.value = DmtAddComma( ComRound ( eval(val02) - eval(sheetObjects[0].CellValue(Row,14 )) ) + "" , "#,###.00");
                    document.form.vpayamt.value = DmtAddComma( ComRound ( eval(val03) - eval(sheetObjects[0].CellValue(Row,15)) ) + "" , "#,###.00");
                    document.form.vinvqty.value = DmtAddComma(          ( eval(val04) - eval("1"                              ) ) + "" , "#,###"   );
                    
                    document.form.vincamt.value = DmtAddComma( ComRound ( eval(vincamt) - eval(sheetObjects[0].CellValue(Row,'org_chg_amt' )) ) + "" , "#,###.00");
                    document.form.vcmdtamt.value = DmtAddComma( ComRound ( eval(vcmdtamt) - eval(sheetObjects[0].CellValue(Row,'cmdt_expt_amt' )) ) + "" , "#,###.00");
                    document.form.vexcepamt.value = DmtAddComma( ComRound ( eval(vexcepamt) - eval(sheetObjects[0].CellValue(Row,'sc_rfa_expt_amt' )) ) + "" , "#,###.00");
                    document.form.vdcamt.value = DmtAddComma( ComRound ( eval(vdcamt) - eval(sheetObjects[0].CellValue(Row,'aft_expt_dc_amt' )) ) + "" , "#,###.00");
                    
                    CellValue( Row ,1 ) = 0;
                    CheckAll( 1 ) = 0;
                    sheetObjects[2].CellValue( Row ,1 ) = 0;
                    sheetObjects[2].CheckAll( 1 ) = 0;
                } else if ( vChk == 0 ) { // 선택해제
                    document.form.vbilamt.value = DmtAddComma( ComRound ( eval(sheetObjects[0].CellValue(Row,13 )) + eval(val01) ) + "" , "#,###.00");
                    document.form.vtaxamt.value = DmtAddComma( ComRound ( eval(sheetObjects[0].CellValue(Row,14 )) + eval(val02) ) + "" , "#,###.00"); 
                    document.form.vpayamt.value = DmtAddComma( ComRound ( eval(sheetObjects[0].CellValue(Row,15)) + eval(val03) ) + "" , "#,###.00");
                    document.form.vinvqty.value = DmtAddComma(          ( eval("1"                              ) + eval(val04) ) + "" , "#,###"   );

                    document.form.vincamt.value = DmtAddComma( ComRound ( eval(sheetObjects[0].CellValue(Row,'org_chg_amt' )) + eval(vincamt) ) + "" , "#,###.00");
                    document.form.vcmdtamt.value = DmtAddComma( ComRound ( eval(sheetObjects[0].CellValue(Row,'cmdt_expt_amt' )) + eval(vcmdtamt) ) + "" , "#,###.00");
                    document.form.vexcepamt.value = DmtAddComma( ComRound ( eval(sheetObjects[0].CellValue(Row,'sc_rfa_expt_amt' )) + eval(vexcepamt) ) + "" , "#,###.00");
                    document.form.vdcamt.value = DmtAddComma( ComRound ( eval(sheetObjects[0].CellValue(Row,'aft_expt_dc_amt' )) + eval(vdcamt) ) + "" , "#,###.00");
                    
                    CellValue( Row , 1 ) = 1;
                    sheetObjects[2].CellValue( Row , 1 ) = 1;
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
            document.form.tftp2.value  = sheetObjects[0].CellValue(Row,15);
            document.form.invno.value  = sheetObjects[0].CellValue(Row,3);
            document.form.sheetp.value = sheetObjects[0].CellValue(Row,21);
        }
    }
    
    function sheet1_OnClickXTC2( sheetObj , Row , Col , Value ) {
        with (sheetObj) {
            var vChk = sheetObjects[0].CellValue(Row,1);
            var val01 = ComReplaceStr(document.form.vbilamt.value,",");
            var val02 = ComReplaceStr(document.form.vtaxamt.value,",");
            var val03 = ComReplaceStr(document.form.vpayamt.value,",");
            
            var vincamt = ComReplaceStr(document.form.vincamt.value,",");
            var vcmdtamt = ComReplaceStr(document.form.vcmdtamt.value,",");
            var vexcepamt = ComReplaceStr(document.form.vexcepamt.value,",");
            var vdcamt = ComReplaceStr(document.form.vdcamt.value,",");            
            
            if( ComIsNull(val01) ) { val01 = 0; }
            if( ComIsNull(val02) ) { val02 = 0; }
            if( ComIsNull(val03) ) { val03 = 0; }
            
            if( ComIsNull(vincamt) ) { vincamt = 0; }
            if( ComIsNull(vcmdtamt) ) { vcmdtamt = 0; }
            if( ComIsNull(vexcepamt) ) { vexcepamt = 0; }
            if( ComIsNull(vdcamt) ) { vdcamt = 0; }
            
            if( val01 < 0 ) { val01 = 0; }
            if( val02 < 0 ) { val02 = 0; }
            if( val03 < 0 ) { val03 = 0; }

            if( vincamt < 0 ) { vincamt = 0; }
            if( vcmdtamt < 0 ) { vcmdtamt = 0; }
            if( vexcepamt < 0 ) { vexcepamt = 0; }
            if( vdcamt < 0 ) { vdcamt = 0; }
            
            if ( vChk == 1 ) { // 선택해제
                document.form.vbilamt.value = DmtAddComma( ( eval(val01) - eval(sheetObjects[0].CellValue(Row,8 )) )+"" , "#,###.00");
                document.form.vtaxamt.value = DmtAddComma( ( eval(val02) - eval(sheetObjects[0].CellValue(Row,9 )) )+"" , "#,###.00");
                document.form.vpayamt.value = DmtAddComma( ( eval(val03) - eval(sheetObjects[0].CellValue(Row,10)) )+"" , "#,###.00");
            } else if ( vChk == 0 ) { // 선택해제
                document.form.vbilamt.value = DmtAddComma( ( eval(sheetObjects[0].CellValue(Row,8 )) + eval(val01) )+"" , "#,###.00");
                document.form.vtaxamt.value = DmtAddComma( ( eval(sheetObjects[0].CellValue(Row,9 )) + eval(val02) )+"" , "#,###.00"); 
                document.form.vpayamt.value = DmtAddComma( ( eval(sheetObjects[0].CellValue(Row,10)) + eval(val03) )+"" , "#,###.00");
            } else {
            }
        }
    }
    
    function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH) {
    	
    	if (Col != 1 && Col != 31 && Col != 32) {
    		openPopupWindow(sheetObj, document.form, "btn1_detail");
    	}
    }    
    
    /**
     * 문자열을 숫자포멧에 맞게 변경하여 리턴한다. 숫자포멧으로 설정할수 있는 값은 다음과 같다. <br>
     * sFormat="#,###"    : 천단위구분만 하는것으로 {@link #ComAddComma} 함수와 동일하다. <br>
     * sFormat="#,###.0"  : 천단위구분과 소숫점한자리를 표시한다. <br>
     * sFormat="#,###.00" : 천단위구분과 소숫점두자리를 표시한다. <br>
     * <br><b>Example : </b>
     * <pre>
     *     ret = ComAddComma2("1000", "#,###")        //결과 : "1,000"
     *     ret = ComAddComma2("1000", "#,###.0")      //결과 : "1,000.0"
     *     ret = ComAddComma2("1000", "#,###.00")     //결과 : "1,000.00"
     *     ret = ComAddComma2("1000.1", "#,###")      //결과 : "1,000.1"
     *     ret = ComAddComma2("1000.1", "#,###.0")    //결과 : "1,000.1"
     *     ret = ComAddComma2("1000.1", "#,###.00")   //결과 : "1,000.1"
     *     ret = ComAddComma2("-1,000.12", "#,###.0") //결과 : "-1,000.12"
     * </pre>
     * @param {string,object}   obj      필수,숫자문자열 또는 HTML태그(Object)
     * @param {string}          sFormat  숫자 포멧
     * @returns string, 숫자포멧이 설정된 문자열<br>
     *          "":sVal인자의 값이 잘못된 경우 공백("")을 리턴한다.
     * @see #ComAddComma
     * @see #ComGetMaskedValue
     */
    function DmtAddComma(obj,sFormat)
    {
        try {
            //첫번째 인자가 문자열 또는 HTML태그(Object)인 경우 처리
            var sVal = getArgValue(obj);

            switch(sFormat)
            {
                case "#,###" :
                        return ComAddComma(sVal);
                case "#,###.0" :
                        p = sVal.split(".");
                        p[0] = ComAddComma(p[0]);
                        if      (p.length == 1) return p[0]+".0";
                        else if (p.length == 2) return p[0]+"."+p[1];
                        else return "";
                case "#,###.00" :
                        p = sVal.split(".");
                        p[0] = ComAddComma(p[0]);
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
        var xmlDoc = new ActiveXObject("Microsoft.XMLDOM" );
        xmlDoc.loadXML(xmlStr);

        var xmlRoot = xmlDoc.documentElement;
        if(xmlRoot == null) return;

        var msgNode = xmlRoot.getElementsByTagName("MESSAGE").item(0);
        if(msgNode == null) 
         return;
        else
         return msgNode.firstChild.nodeValue;
   } catch(err) { ComFuncErrMsg(err.message); }
   
}






    //조회조건필드인 Combo 데이터 조회
    function doActionIBCombo(sheetObj,formObj,sAction,sComboAction,sComboKey,sObj) {
        
        sheetObj.ShowDebugMsg = false;
        sheetObj.WaitImageVisible = false;
        
        switch(sAction) {
        
            case IBSEARCH:      // 조회
                if (sheetObj.id == "sheet4") {
                    //1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
                    setComboParameters(sComboAction, sObj);
                    //2.조회조건으로 조회실행                 
                    var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
                    
                    //3.조회후 결과처리
                    var comboDatas;
                    var comboItems;
                    

                    switch(sComboAction) {
                        //1. ATTENTION LIST
                        case SEARCHLIST03:
                            comboItems = ComGetEtcData(sXml, sComboKey).split(ROWMARK);
                            comboObjects[0].Code = "-1";
                            comboObjects[0].RemoveAll();
                            addComboItem1(sObj,comboItems);
                        break;                          
                    } //end of the switch(sComboAction) 
                }
            break;
                
            //Payer별 Email, FAX 번호를 조회한다.
            case COMMAND02:
                //1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
                //setComboParameters(sComboAction, sObj);
                
                formObj.ofc_cd.value = formObj.h_usr_off.value;
                formObj.dmdt_trf_cd.value = document.form.tftp.value;
                formObj.payer_cd.value = document.form.payc.value;

                var param = "f_cmd=" + COMMAND02
                		  + "&payer_cd=" + formObj.payer_cd.value 
                		  + "&dmdt_trf_cd=" + formObj.dmdt_trf_cd.value 
                		  + "&ofc_cd=" + formObj.ofc_cd.value
                		  ;              
                var sXml = sheetObj.GetSearchXml("EES_DMT_4002GS.do", param);
                //sheetObj.LoadSearchXml(sXml);                
                //2.조회조건으로 조회실행                 
                //var sXml = sheetObj.GetSearchXml("EES_DMT_4002GS.do", FormQueryString(formObj));
                
                
                 if ( sXml != undefined && sXml != "" ) {            
                    //3.조회후 결과처리
                    ComSetObjValue(formObj.payr_faxnos  , ComGetEtcData(sXml, "FAX_NO"  ));
                    ComSetObjValue(formObj.payr_emailnos, ComGetEtcData(sXml, "EMAIL_NO"));
                 } else {
                    ComSetObjValue(formObj.payr_faxnos  , "");
                    ComSetObjValue(formObj.payr_emailnos, "");
                 }
            break;
            
        }
        
        sheetObj.WaitImageVisible = true;
        
    }     
     
     
        
    function setComboParameters(sComboAction, sObj) {
        var formObj = document.form;
        ComSetObjValue(formObj.f_cmd, sComboAction);
        if(sComboAction == COMMAND02) {
            ComSetObjValue ( formObj.ofc_cd , ComGetObjValue ( formObj.h_usr_off ) );
        }
    }   
    
     
     /**
      * 콤보필드에 데이터를 추가해준다.
      */    
    function addComboItem(comboObj,comboDatas,isOnlyCode) {
        var comboItem;
        var comboItems;
        var val;
        var txt;
        if (comboDatas != undefined) {
            comboItems = comboDatas.split(ROWMARK); 
            for (var i = 0 ; i < comboItems.length ; i++) {
                comboItem = comboItems[i].split(FIELDMARK);
                val = comboItem[0];
                txt = isOnlyCode ? comboItem[0] : comboItem[1];
                
                ComAddComboItem(comboObj,val,txt);
            }
        }           
    }
    /**
      * 콤보필드에 데이터를 추가해준다.
      */    
    function addComboItem1(comboObj, comboItems) {
        var tCode = "";
        for (var i = 0 ; i < comboItems.length ; i++) {
            var comboItem = comboItems[i].split(FIELDMARK);
            comboObj.InsertItem(i, comboItem[0]+"|"+comboItem[1]+"|"+comboItem[2]+"|"+comboItem[3], comboItem[4]);      
            
            if ( i == 0 ) {
                tCode = comboItem[4];
            }
        }
        comboObjects[0].Code = tCode;
    }     
     
      
    //Payer 체크
    function doActionText(sheetObj, formObj, object, formCmd) {
        sheetObj.ShowDebugMsg = false;
        sheetObj.WaitImageVisible = false;
        
        //Payer 체크

        //cust_cd
        ComSetObjValue(formObj.s_cust_cd, ComGetObjValue(formObj.payer_cd));
        var cust_len = parseInt(ComGetLenByByte(ComGetObjValue(formObj.s_cust_cd)));
        
        if(cust_len == 0){
            ComSetObjValue(formObj.s_cust_gubun, "");
            ComSetObjValue(formObj.s_cust_cd, "");
            ComSetObjValue(formObj.payer_cd, "");
            ComSetObjValue(formObj.payer_nm, "");
            //attention  reset
            attentionReset();
            return;
        }
        
        var cre_cnt_cd = ComGetObjValue(formObj.session_cnt_cd);
        //미주 : customer + vendor 
        if(cre_cnt_cd == "CA" || cre_cnt_cd == "US"){
            if(cust_len > 2) {
                var char_chk = ComGetObjValue(formObj.s_cust_cd).substring(0,2);
                //2자리가 영문자이면 CUSTOMER 조회
                if(ComIsAlphabet(char_chk)) {
                    ComSetObjValue(formObj.s_cust_gubun, "2");
                //아니면 VENDOR 조회
                }else{
                    //service provider는 Detention 만 가능하게 함
                    if(ComGetObjValue(formObj.dmdt_trf_cd).substring(1,2) == 'T'){
                        ComSetObjValue(formObj.s_cust_gubun, "1");
                    } else {
                        ComShowCodeMessage("DMT00165", "Payer");
                        ComSetObjValue(formObj.s_cust_gubun, "");
                        ComSetObjValue(formObj.s_cust_cd, "");
                        ComSetObjValue(formObj.payer_cd, "");
                        ComSetObjValue(formObj.payer_nm, "");
                        attentionReset();
                        return;
                    }
                }
            } else {
                //service provider는 Detention 만 가능하게 함
                if(ComGetObjValue(formObj.dmdt_trf_cd).substring(1,2) == 'T'){
                    ComSetObjValue(formObj.s_cust_gubun, "1");
                } else {
                    ComShowCodeMessage("DMT00165", "Payer");
                    ComSetObjValue(formObj.s_cust_gubun, "");
                    ComSetObjValue(formObj.s_cust_cd, "");
                    ComSetObjValue(formObj.payer_cd, "");
                    ComSetObjValue(formObj.payer_nm, "");
                    attentionReset();
                    return;
                }
            }
        } else {
            // 미주 외 : customer만 적용 ( vendor 는 제외 에러 처리) 
            if(cust_len > 2) {
                var char_chk = ComGetObjValue(formObj.s_cust_cd).substring(0,2);
                //2자리가 영문자이면 CUSTOMER 조회
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
        }
        
        ComSetObjValue(formObj.f_cmd, formCmd);
        
        var sXml    = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
        var cust_cd = ComGetEtcData(sXml, "PAYER_CODE");
        var cust_nm = ComGetEtcData(sXml, "PAYER_NM");
        var delt_flg = ComGetEtcData(sXml, "DELT_FLG");
        
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
        var formObj = document.form;
        comboObjects[0].RemoveAll();
        ComSetObjValue(formObj.dmdt_payr_cntc_pnt_nm, "");
        ComSetObjValue(formObj.payr_cntc_pnt_phn_no , "");
        ComSetObjValue(formObj.payr_cntc_pnt_fax_no , "");
        ComSetObjValue(formObj.payr_cntc_pnt_eml    , "");
    }
     
     
    //Attention 선택 이벤트
    function combo1_OnChange(comboObj, Index_Code, Text) {
        search_combo1(comboObj, Index_Code, Text);
    }
    
    function search_combo1(comboObj, searchIndex, searchText) {
        
        var formObj = document.form;

        ComSetObjValue ( formObj.rpt_attnname          , comboObj.GetText( searchIndex , 0 ) );
        ComSetObjValue ( formObj.dmdt_payr_cntc_pnt_nm , comboObj.GetText( searchIndex , 0 ) );
        ComSetObjValue ( formObj.payr_cntc_pnt_phn_no  , comboObj.GetText( searchIndex , 1 ) );
        ComSetObjValue ( formObj.payr_cntc_pnt_fax_no  , comboObj.GetText( searchIndex , 2 ) );
        ComSetObjValue ( formObj.payr_cntc_pnt_eml     , comboObj.GetText( searchIndex , 3 ) );
//        ComSetObjValue ( formObj.payr_faxnos           , comboObj.GetText( searchIndex , 2 ) );
//        ComSetObjValue ( formObj.payr_emailnos         , comboObj.GetText( searchIndex , 3 ) );
    }
    
    function getPayerInfoData(fax_nos, email_nos, cntc_pnt_nm, cntc_pnt_seq){
        var formObj = document.form;
        ComSetObjValue(formObj.payr_faxnos,             fax_nos);
        ComSetObjValue(formObj.payr_emailnos,           email_nos);
        ComSetObjValue(formObj.dmdt_payr_cntc_pnt_nm,   cntc_pnt_nm);
        ComSetObjValue(formObj.cust_cntc_pnt_seq,       cntc_pnt_seq);
        searchAttentionList();
        var setCode = ComGetObjValue(formObj.cust_cnt_cd)+"^"+ComGetObjValue(formObj.cust_cntc_pnt_seq)+"^"+ComParseInt(ComGetObjValue(formObj.cust_seq));
        
        //setting
        if(ComGetObjValue(formObj.payer_cd) == "") {
            comboObjects[0].Code = -1;
            ComSetObjValue(formObj.payr_cntc_pnt_phn_no, "");
            ComSetObjValue(formObj.payr_cntc_pnt_fax_no, "");
            ComSetObjValue(formObj.payr_cntc_pnt_eml, "");
            ComSetObjValue(formObj.cust_cntc_pnt_seq, "");
        }else{
            //Attention Setting
            comboObjects[0].Code = setCode;
            if(comboObjects[0].Code == ""){
                ComSetObjValue(formObj.payr_cntc_pnt_phn_no, "");
                ComSetObjValue(formObj.payr_cntc_pnt_fax_no, "");
                ComSetObjValue(formObj.payr_cntc_pnt_eml, "");
                ComSetObjValue(formObj.cust_cntc_pnt_seq, "");
            }
        }
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
    }   