/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_4012.js
*@FileTitle : Outstanding Issue Preview
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.09
*@LastModifier : 문중철
*@LastVersion : 1.0 
* 2009.09.09 문중철
* 1.0 최초 생성 
=========================================================*/ 
    
    function ui_dmt_4012() {
        this.processButtonClick     = processButtonClick;
        this.setSheetObject         = setSheetObject;
        this.loadPage               = loadPage;
        this.initSheet              = initSheet;
        this.initControl            = initControl;
        this.doActionIBSheet        = doActionIBSheet;
    }

var sheetObjects = new Array();
var sheetCnt = 0;
    
    // 공통전역변수
    var docObjects = new Array();
    var sheetCnt = 0;
    
    var rdObjects = new Array();
    var rdCnt = 0;
    
    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러  정의 */
    document.onclick = processButtonClick;
    
    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject  = docObjects[0];
         var sheetObject1 = docObjects[1];
         var sheetObject2 = docObjects[2];

         /*******************************************************/
         var formObject = document.form; 
          
         var rdObject = rdObjects[0];

//        try {
            
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
            
                case "btn_Close":
                    window.close();
                break;
                
                case "btn_remark":
                    var opener_obj = window.dialogArguments;
                    var invno = opener_obj.document.form.rpt_custcode.value;
                    ComOpenPopupWithTarget('/hanjin/EES_DMT_4105.do?jspno=4012&invno='+invno, 920, 240, "", "0,1,1,1,1,1,1", true);
                break;
                
                case "btn_OTS_Print":
                	
                	rdOpenPrint();
                	
                    
                break;
                
                case "btn_Sheet_Set":
                    ComOpenPopupWithTarget('/hanjin/EES_DMT_4101.do?issoff='+formObject.h_usr_off.value+'&tftp2='+formObject.tftp2.value+'&sheetp=O&jspno=EES_DMT_4012', 725, 780, "", "0,1,1,1,1,1,1", true);
                break;
                
                case "btn_Sheet_Option":
                    ComOpenPopupWithTarget('/hanjin/EES_DMT_4103.do?issoff='+formObject.h_usr_off.value+'&jspno=EES_DMT_4012', 625, 650, "", "0,1,1,1,1,1,1", true);
                break;
                
                case "btn_Fax_Email":
                    var url = "EES_DMT_4104.do"
                        +"?s_ofc_cd=" +ComGetObjValue(formObject.isof)
                        +"&s_cust_cd="+ComGetObjValue(formObject.payc)
                        +"&s_bkg_no=" +ComGetObjValue(formObject.bkgno)
                        +"&s_pod_cd="; // +ComGetObjValue(formObject.pod_cd)
                    var returnValue = ComOpenWindowCenter(url, "EES_DMT_4104", "825","620", true);                    
                break;
                
                case "btn1_fax_send":
                    var opener_obj = window.dialogArguments;
                    
                    //fax no가 존재하지 않으면
//                    if(ComGetObjValue(opener_obj.document.form.payr_faxnos) == "") {
//                        ComShowCodeMessage("DMT01090");
//                        return;
//                    } 
                    
                    formObject.rd_fxeml_sys_cd         .value = "DMT";
                    if        ( opener_obj.document.form.cntrinvno.value == "0" && opener_obj.document.form.rpt_leftright.value == "L" ) {
                        formObject.rd_fxeml_file_name      .value = "EES_DMT_4903.mrd";                        
                    } else if ( opener_obj.document.form.cntrinvno.value == "0" && opener_obj.document.form.rpt_leftright.value == "R" ) {
                        formObject.rd_fxeml_file_name      .value = "EES_DMT_4904.mrd";
                    } else if ( opener_obj.document.form.cntrinvno.value == "1" && opener_obj.document.form.rpt_leftright.value == "L" ) {
                        formObject.rd_fxeml_file_name      .value = "EES_DMT_4905.mrd";
                    } else if ( opener_obj.document.form.cntrinvno.value == "1" && opener_obj.document.form.rpt_leftright.value == "R" ) {
                        formObject.rd_fxeml_file_name      .value = "EES_DMT_4906.mrd";
                    }
                    formObject.rd_fxeml_bat_flg        .value = "N";
                    formObject.rd_fxeml_title          .value = "Statement of Accounts (SM Line)---Cust. Code : "+document.form.payc.value;
                    formObject.rd_fxeml_doc_tp         .value = "O";
                    formObject.rd_fxeml_rd_param       .value = "/rp [" + opener_obj.document.form.arif .value +"] " +
                               "[" + opener_obj.document.form.frdt .value +"] " +
                               "[" + opener_obj.document.form.todt .value +"] " +
                               "[" + opener_obj.document.form.isof .value +"] " +
                               "[" + opener_obj.document.form.payc .value +"] " +
                               "[" + opener_obj.document.form.payc .value +"] " +
                               "[" + opener_obj.document.form.payc .value +"] " +
                               "[" + opener_obj.document.form.payc .value +"] " +
                               "[" + opener_obj.document.form.payc .value +"] " +
                               "[" + document.form.tftp2.value +"] " +
                               "[" + opener_obj.document.form.scno .value +"] " +
                               "[" + opener_obj.document.form.scno .value +"] " +
                               "[" + opener_obj.document.form.rfan .value +"] " +
                               "[" + opener_obj.document.form.rfan .value +"] " +
                               "[" + opener_obj.document.form.cuno .value +"] " +
                               "[" + opener_obj.document.form.cuno .value +"] " +
                               "[" + opener_obj.document.form.cuno .value +"] " +
                               "[" + opener_obj.document.form.cuno .value +"] " +
                               "[" + opener_obj.document.form.cuno .value +"] " +
                               "[" + opener_obj.document.form.cutp .value +"] " +
                               "[" + opener_obj.document.form.cutp .value +"] " +
                               "[" + opener_obj.document.form.cutp .value +"] " + 
                               
                               "[*** " + opener_obj.document.form.rpt_opttitle .value +" ***] " +
                               "[" + opener_obj.document.form.rpt_ofcadd01 .value +"] " +
                               "[" + opener_obj.document.form.rpt_ofcadd02 .value +"] " +
                               "[" + opener_obj.document.form.rpt_ofcadd03 .value +"] " +
                               "[" + ComReplaceStr(opener_obj.document.form.rpt_custname .value,"'"," ") +"] " +
                               "[" + opener_obj.document.form.rpt_address01.value +"] " +
                               "[" + opener_obj.document.form.rpt_address02.value +"] " +
                               "[" + opener_obj.document.form.rpt_address03.value +"] " +
                               "[" + opener_obj.document.form.rpt_address04.value +"] " +
                               "[" + opener_obj.document.form.rpt_hjsref   .value +"] " +
                               "[" + ComReplaceStr(opener_obj.document.form.rpt_attnname .value,"'"," ") +"] " +
                               "[" + opener_obj.document.form.rpt_custcode .value +"] " +
                               "[" + opener_obj.document.form.rpt_telno    .value +"] " +
                               "[" + opener_obj.document.form.rpt_faxno    .value +"] " +
                               "[" + opener_obj.document.form.rpt_custvat  .value +"] " +
                               "[" + opener_obj.document.form.remark01     .value +"] " +
                               "[" + opener_obj.document.form.remark02     .value +"] " +
                               "[" + opener_obj.document.form.rpt_header01 .value +"] " +
                               "[" + opener_obj.document.form.rpt_header02 .value +"] " +
                               "[" + opener_obj.document.form.rpt_header03 .value +"] " +
                               "[" + opener_obj.document.form.rpt_header04 .value +"] " +
                               "[" + opener_obj.document.form.rpt_header05 .value +"] " +
                               "[" + opener_obj.document.form.rpt_header06 .value +"] " +
                               "[" + opener_obj.document.form.rpt_header07 .value +"] " +
                               "[" + opener_obj.document.form.rpt_header08 .value +"] " +
                               "[" + opener_obj.document.form.rpt_header09 .value +"] " +
                               "[" + opener_obj.document.form.rpt_header10 .value +"] " +
                               "[" + opener_obj.document.form.rpt_custref  .value +"] " +
                               "[" + opener_obj.document.form.rpt_telfax   .value +"] " +
                               "[" + opener_obj.document.form.rpt_custvatno.value +"] " + 
                               "[" + document.form.invno.value +"] " +
                               "[" + document.form.creof.value +"] " 
                               ;
                    
//                    var arr_faxnos  = ComGetObjValue(opener_obj.document.form.payr_faxnos).split(";");
//                    var re_faxnos   = "";
//                    var msg1 = "";
//                    for(var iII=0; iII< arr_faxnos.length; iII++) {
//                        re_faxnos   += ComGetObjValue(opener_obj.document.form.payer_cd)+";"+arr_faxnos[iII];
//                        msg1        += arr_faxnos[iII] +"\n\t";
//                    }
//                
//                    if ( !ComShowCodeConfirm( "DMT01092" , msg1 ) ) {                    
//                        return false;
//                    }
                    
//                    formObject.rd_fxeml_fax_no         .value = ComGetObjValue(opener_obj.document.form.payr_faxnos);
                    formObject.rd_fxeml_fax_sndr_id    .value = "SM Line";
                    formObject.rd_fxeml_eml_sndr_nm    .value = "SM Line";
                    formObject.rd_fxeml_eml_rcvr_add   .value = "";
                    var currDateEmail = ComGetNowInfo();
                    formObject.rd_fxeml_eml_atch_file  .value = currDateEmail+"_"+document.form.payc .value;
                    formObject.rd_fxeml_eml_templt     .value = "EES_DMT_4011_01.html"; // 템플릿 위치 C:/sitectx/ALPS\APP-INF/config/template/mailtemplate/template.htmlmail
                    formObject.rd_fxeml_eml_tmplt_param.value = "";
                    //doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC05);
                    
                    var attachYN = "N";
                    if ( document.form.attachYN.checked ) {
                    	attachYN = "Y";
                        formObject.rd_fxeml_file_name2      .value = "EES_DMT_4907.mrd";                        
                        formObject.rd_fxeml_rd_param2       .value = "/rp [" + document.form.invno.value + "] [" + document.form.isof.value + "] [" + document.form.creof.value + "]";
                        //doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC05);                        
                    }       
                    // 팝업 호출
        			var ofc_cd = ComGetObjValue(formObject.isof);

        			var url = "EES_DMT_4107.do"
        				+"?s_ofc_cd="+ofc_cd
        				+"&s_cust_cd="+ComGetObjValue(formObject.payc)
        				+"&s_bkg_no="+ComGetObjValue(formObject.bkgno)
        				+"&s_pod_cd="
        				+"&jspno=4012"
        				+"&telno="+ComGetObjValue(formObject.tel_val)
        				+"&faxno="+ComGetObjValue(formObject.fax_val)
        				+"&email="+ComGetObjValue(formObject.eml_val)
        				+"&cntc_seq="+attachYN										//attach check 여부 컬럼으로 치환하여 사용함
        				;
        			ComOpenWindowCenter(url, "EES_DMT_4107", "500","300", true);
                break;   
                
                case "btn1_email_send":
                    var opener_obj = window.dialogArguments;
//                    if(ComGetObjValue(opener_obj.document.form.payr_emailnos) == "" || ComGetObjValue(opener_obj.document.form.payr_emailnos) == undefined) {
//                        ComShowCodeMessage("DMT01091");
//                        return;
//                    }                    
//                    
                    formObject.rd_fxeml_sys_cd         .value = "DMT";

                    if        ( opener_obj.document.form.cntrinvno.value == "0" && opener_obj.document.form.rpt_leftright.value == "L" ) {
                        formObject.rd_fxeml_file_name      .value = "EES_DMT_4903.mrd";                        
                    } else if ( opener_obj.document.form.cntrinvno.value == "0" && opener_obj.document.form.rpt_leftright.value == "R" ) {
                        formObject.rd_fxeml_file_name      .value = "EES_DMT_4904.mrd";
                    } else if ( opener_obj.document.form.cntrinvno.value == "1" && opener_obj.document.form.rpt_leftright.value == "L" ) {
                        formObject.rd_fxeml_file_name      .value = "EES_DMT_4905.mrd";
                    } else if ( opener_obj.document.form.cntrinvno.value == "1" && opener_obj.document.form.rpt_leftright.value == "R" ) {
                        formObject.rd_fxeml_file_name      .value = "EES_DMT_4906.mrd";
                    }

                    formObject.rd_fxeml_bat_flg        .value = "N";
                    formObject.rd_fxeml_title          .value = "Statement of Accounts (SM Line)---Cust. Code : "+document.form.payc.value;
                    formObject.rd_fxeml_doc_tp         .value = "O";
                    formObject.rd_fxeml_rd_param       .value = "/rp [" + opener_obj.document.form.arif .value +"] " +
                               "[" + opener_obj.document.form.frdt .value +"] " +
                               "[" + opener_obj.document.form.todt .value +"] " +
                               "[" + opener_obj.document.form.isof .value +"] " +
                               "[" + opener_obj.document.form.payc .value +"] " +
                               "[" + opener_obj.document.form.payc .value +"] " +
                               "[" + opener_obj.document.form.payc .value +"] " +
                               "[" + opener_obj.document.form.payc .value +"] " +
                               "[" + opener_obj.document.form.payc .value +"] " +
                               "[" + document.form.tftp2.value +"] " +
                               "[" + opener_obj.document.form.scno .value +"] " +
                               "[" + opener_obj.document.form.scno .value +"] " +
                               "[" + opener_obj.document.form.rfan .value +"] " +
                               "[" + opener_obj.document.form.rfan .value +"] " +
                               "[" + opener_obj.document.form.cuno .value +"] " +
                               "[" + opener_obj.document.form.cuno .value +"] " +
                               "[" + opener_obj.document.form.cuno .value +"] " +
                               "[" + opener_obj.document.form.cuno .value +"] " +
                               "[" + opener_obj.document.form.cuno .value +"] " +
                               "[" + opener_obj.document.form.cutp .value +"] " +
                               "[" + opener_obj.document.form.cutp .value +"] " +
                               "[" + opener_obj.document.form.cutp .value +"] " + 
                               
                               "[*** " + opener_obj.document.form.rpt_opttitle .value +" ***] " +
                               "[" + opener_obj.document.form.rpt_ofcadd01 .value +"] " +
                               "[" + opener_obj.document.form.rpt_ofcadd02 .value +"] " +
                               "[" + opener_obj.document.form.rpt_ofcadd03 .value +"] " +
                               "[" + ComReplaceStr(opener_obj.document.form.rpt_custname .value,"'"," ") +"] " +
                               "[" + opener_obj.document.form.rpt_address01.value +"] " +
                               "[" + opener_obj.document.form.rpt_address02.value +"] " +
                               "[" + opener_obj.document.form.rpt_address03.value +"] " +
                               "[" + opener_obj.document.form.rpt_address04.value +"] " +
                               "[" + opener_obj.document.form.rpt_hjsref   .value +"] " +
                               "[" + ComReplaceStr(opener_obj.document.form.rpt_attnname .value,"'"," ") +"] " +
                               "[" + opener_obj.document.form.rpt_custcode .value +"] " +
                               "[" + opener_obj.document.form.rpt_telno    .value +"] " +
                               "[" + opener_obj.document.form.rpt_faxno    .value +"] " +
                               "[" + opener_obj.document.form.rpt_custvat  .value +"] " +
                               "[" + opener_obj.document.form.remark01     .value +"] " +
                               "[" + opener_obj.document.form.remark02     .value +"] " +
                               "[" + opener_obj.document.form.rpt_header01 .value +"] " +
                               "[" + opener_obj.document.form.rpt_header02 .value +"] " +
                               "[" + opener_obj.document.form.rpt_header03 .value +"] " +
                               "[" + opener_obj.document.form.rpt_header04 .value +"] " +
                               "[" + opener_obj.document.form.rpt_header05 .value +"] " +
                               "[" + opener_obj.document.form.rpt_header06 .value +"] " +
                               "[" + opener_obj.document.form.rpt_header07 .value +"] " +
                               "[" + opener_obj.document.form.rpt_header08 .value +"] " +
                               "[" + opener_obj.document.form.rpt_header09 .value +"] " +
                               "[" + opener_obj.document.form.rpt_header10 .value +"] " +
                               "[" + opener_obj.document.form.rpt_custref  .value +"] " +
                               "[" + opener_obj.document.form.rpt_telfax   .value +"] " +
                               "[" + opener_obj.document.form.rpt_custvatno.value +"] " + 
                               "[" + document.form.invno.value +"] " +
                               "[" + document.form.creof.value +"] "
                               ;

//                    var arr_faxnos  = ComGetObjValue(opener_obj.document.form.payr_faxnos).split(";");
//                    var re_faxnos   = "";
//                    
//                    for(var i=0; i< arr_faxnos.length; i++) {
//                        re_faxnos   += ComGetObjValue(opener_obj.document.form.payer_cd)+";"+arr_faxnos[i];
//                        re_faxnos   += ";";
//                    }
//                    var msg1 = "";
//                    rcvr_email      = ComGetObjValue(opener_obj.document.form.payr_emailnos);
//                    var arr_emails  = ComGetObjValue(opener_obj.document.form.payr_emailnos).split(";");
//                    
//                    for(var i=0 ; i < arr_emails.length; i++) {
//                        msg1        += arr_emails[i] +"\n\t";
//                    }
//                    if ( !ComShowCodeConfirm( "DMT01093" , msg1 ) ) {                    
//                        return false;
//                    }
//                    
                    formObject.rd_fxeml_fax_no         .value = "";
                    formObject.rd_fxeml_fax_sndr_id    .value = "SM Line";
                    formObject.rd_fxeml_eml_sndr_nm    .value = "SM Line";
                    formObject.rd_fxeml_eml_rcvr_add   .value = "";
                    var currDateEmail = ComGetNowInfo();
                    formObject.rd_fxeml_eml_atch_file  .value = currDateEmail+"_"+document.form.payc .value;
                    formObject.rd_fxeml_eml_templt     .value = "EES_DMT_4011_01.html"; // 템플릿 위치 C:/sitectx/ALPS\APP-INF/config/template/mailtemplate/template.htmlmail
                    formObject.rd_fxeml_eml_tmplt_param.value = "";

                    var attachYN = "N";
                    if ( document.form.attachYN.checked ) {
                    	attachYN = "Y";
                    }       
                    // 팝업 호출
        			var ofc_cd = ComGetObjValue(formObject.isof);

        			var url = "EES_DMT_4108.do"
        				+"?s_ofc_cd="+ofc_cd
        				+"&s_cust_cd="+ComGetObjValue(formObject.payc)
        				+"&s_bkg_no="+ComGetObjValue(formObject.bkgno)
        				+"&s_pod_cd="
        				+"&jspno=4012"
        				+"&telno="+ComGetObjValue(formObject.tel_val)
        				+"&faxno="+ComGetObjValue(formObject.fax_val)
        				+"&email="+ComGetObjValue(formObject.eml_val)
        				+"&cntc_seq="+attachYN										//attach check 여부 컬럼으로 치환하여 사용함
        				;
        			ComOpenWindowCenter(url, "EES_DMT_4108", "500","300", true);
                break; 
                
            } // end switch
            
//        }catch(e) {
//            if( e == "[object Error]") {
//                ComShowMessage(OBJECT_ERROR);
//            } else {
//                ComShowMessage(e);
//            }
//        }
    }

    function setSheetObject(sheet_obj){

       sheetObjects[sheetCnt++] = sheet_obj;

    }    
    
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){

        //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);

                //doActionIBSheet(sheetObjects[i],document.form,IBSEARCH);
        }         
         
        rdOpen();   
        //rdObjects[0].PrintDialog();
    }

    /**
     * print화면 오픈
     * print화면 오픈
     * print할수 있는 화면 오픈
     */
    function rdOpen(){      
        
        var sXml = "";      
        var i=0;
        var j=0; 
        var opener_obj = window.dialogArguments;
        
        var opnrInvno = "";
        var opnrTrftp = "";
        var opnrCreOf = "";	//cre_ofc_cd
        
        if ( opener_obj.document.form.cntrinvno.value == "1" ) {
            
            var opener_sheet_obj1 =  opener_obj.document.sheet1;
            
            var fromObj = new Array();
            var rdObj = new Array();
                        
            fromObj[1] = document.form;                            // RD 로 보내기 위해 배열로담는다
            rdObj[0] = opener_sheet_obj1;     
             
            sXml = "<?xml version='1.0' encoding='UTF-8'?><SHEET>";
            
            sheetCnt = 1;
            //i = 시트 카운트,
            for(i=0;i<1;i++){
                sheetCnt = i+1;
                if(rdObj[i].RowCount ==0){
                    sXml  += "<SHEET"+sheetCnt+"><DATA TOTAL='0'><TR>";
                    for(j=0;j<=rdObj[i].LastCol;j++){
                        sXml +="<TD></TD>";
                    }
                    sXml +="</TR></DATA></SHEET"+sheetCnt+">";
                }else{
                    
                    //sXml +=RD_GetDataSearchXml(rdObj[i],sheetCnt);
    
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
                            opnrInvno = rdObj[i].CellValue(ir,"invnoo") + "," + opnrInvno;
                            opnrTrftp = rdObj[i].CellValue(ir,"tarftp") + "," + opnrTrftp;
                            opnrCreOf = rdObj[i].CellValue(ir,"isseof") + "," + opnrCreOf;
                        }                    
                    }
    
                    allXml += "  </DATA></SHEET" + sheetCnt + ">";
    
                    sXml += allXml;
    
                }           
            }

            document.form.cntrinvno2.value = opener_obj.document.form.cntrinvno            .value;
            document.form.atn_val   .value = opener_obj.document.form.dmdt_payr_cntc_pnt_nm.value;
            document.form.tel_val   .value = opener_obj.document.form.payr_cntc_pnt_phn_no .value;
            document.form.fax_val   .value = opener_obj.document.form.payr_cntc_pnt_fax_no .value;
            document.form.eml_val   .value = opener_obj.document.form.payr_cntc_pnt_eml    .value;            
            sXml +="<ETC>"; 
            sXml +="    <OPT_TITLE>" + opener_obj.document.form.rpt_opttitle.value  + "</OPT_TITLE>";
            sXml +="    <OFC_ADD01>" + opener_obj.document.form.rpt_ofcadd01.value  + "</OFC_ADD01>";
            sXml +="    <OFC_ADD02>" + opener_obj.document.form.rpt_ofcadd02.value  + "</OFC_ADD02>";
            sXml +="    <OFC_ADD03>" + opener_obj.document.form.rpt_ofcadd03.value  + "</OFC_ADD03>";        
            sXml +="    <CUST_NAME>" + opener_obj.document.form.rpt_custname .value + "</CUST_NAME>";
            sXml +="    <ADDRESS01>" + opener_obj.document.form.rpt_address01.value + "</ADDRESS01>";
            sXml +="    <ADDRESS02>" + opener_obj.document.form.rpt_address02.value + "</ADDRESS02>";
            sXml +="    <ADDRESS03>" + opener_obj.document.form.rpt_address03.value + "</ADDRESS03>";
            sXml +="    <ADDRESS04>" + opener_obj.document.form.rpt_address04.value + "</ADDRESS04>";
            sXml +="    <HJS_REF>"   + opener_obj.document.form.rpt_hjsref   .value + "</HJS_REF>"  ;
            sXml +="    <ATTN_NAME>" + ComReplaceStr(opener_obj.document.form.rpt_attnname .value,"'"," ") + "</ATTN_NAME>";
            sXml +="    <CUST_CODE>" + opener_obj.document.form.rpt_custcode .value + "</CUST_CODE>";
            sXml +="    <TEL_NO>"    + opener_obj.document.form.rpt_telno    .value + "</TEL_NO>"   ;
            sXml +="    <FAX_NO>"    + opener_obj.document.form.rpt_faxno    .value + "</FAX_NO>"   ;
            sXml +="    <CUST_VAT>"  + opener_obj.document.form.rpt_custvat  .value + "</CUST_VAT>" ;
            sXml +="    <OTS_RMK_1>" + opener_obj.document.form.remark01     .value + "</OTS_RMK_1>";
            sXml +="    <OTS_RMK_2>" + opener_obj.document.form.remark02     .value + "</OTS_RMK_2>";
            sXml +="    <HEADER01>"  + opener_obj.document.form.rpt_header01 .value + "</HEADER01>" ;
            sXml +="    <HEADER02>"  + opener_obj.document.form.rpt_header02 .value + "</HEADER02>" ;
            sXml +="    <HEADER03>"  + opener_obj.document.form.rpt_header03 .value + "</HEADER03>" ;
            sXml +="    <HEADER04>"  + opener_obj.document.form.rpt_header04 .value + "</HEADER04>" ;
            sXml +="    <HEADER05>"  + opener_obj.document.form.rpt_header05 .value + "</HEADER05>" ;
            sXml +="    <HEADER06>"  + opener_obj.document.form.rpt_header06 .value + "</HEADER06>" ;
            sXml +="    <HEADER07>"  + opener_obj.document.form.rpt_header07 .value + "</HEADER07>" ;
            sXml +="    <HEADER08>"  + opener_obj.document.form.rpt_header08 .value + "</HEADER08>" ;
            sXml +="    <HEADER09>"  + opener_obj.document.form.rpt_header09 .value + "</HEADER09>" ;
            sXml +="    <HEADER10>"  + opener_obj.document.form.rpt_header10 .value + "</HEADER10>" ;
            sXml +="    <CUSTREF>"   + opener_obj.document.form.rpt_custref  .value + "</CUSTREF>"  ;
            sXml +="    <TELFAX>"    + opener_obj.document.form.rpt_telfax   .value + "</TELFAX>"   ;
            sXml +="    <CUSTVATNO>" + opener_obj.document.form.rpt_custvatno.value + "</CUSTVATNO>";
            sXml +="</ETC>";
            sXml +="</SHEET>";
    
            if ( rdObj[0].RowCount  == "0")                     // RD 로 보낼 sheet 에 데이타가 없으면 Error
            {
                errMsg = 'No data found.';
                showErrMessage(errMsg);
                return;
            }
            rdObjects[0].AutoAdjust = true;
            rdObjects[0].HideStatusbar();
            rdObjects[0].ViewShowMode(0);
                    
            rdObjects[0].SetPageLineColor(255,255,255);       
 
            var rdParam2 = "/rp [" + opener_obj.document.form.arif .value +"] " +
                               "[" + opener_obj.document.form.frdt .value +"] " +
                               "[" + opener_obj.document.form.todt .value +"] " +
                               "[" + opener_obj.document.form.isof .value +"] " +
                               "[" + opener_obj.document.form.payc .value +"] " +
                               "[" + opener_obj.document.form.payc .value +"] " +
                               "[" + opener_obj.document.form.payc .value +"] " +
                               "[" + opener_obj.document.form.payc .value +"] " +
                               "[" + opener_obj.document.form.payc .value +"] " +
                               "[" + opnrTrftp +"] " +
                               "[" + opener_obj.document.form.scno .value +"] " +
                               "[" + opener_obj.document.form.scno .value +"] " +
                               "[" + opener_obj.document.form.rfan .value +"] " +
                               "[" + opener_obj.document.form.rfan .value +"] " +
                               "[" + opener_obj.document.form.cuno .value +"] " +
                               "[" + opener_obj.document.form.cuno .value +"] " +
                               "[" + opener_obj.document.form.cuno .value +"] " +
                               "[" + opener_obj.document.form.cuno .value +"] " +
                               "[" + opener_obj.document.form.cuno .value +"] " +
                               "[" + opener_obj.document.form.cutp .value +"] " +
                               "[" + opener_obj.document.form.cutp .value +"] " +
                               "[" + opener_obj.document.form.cutp .value +"] " + 
                               
                               "[*** " + opener_obj.document.form.rpt_opttitle .value +" ***] " +
                               "[" + opener_obj.document.form.rpt_ofcadd01 .value +"] " +
                               "[" + opener_obj.document.form.rpt_ofcadd02 .value +"] " +
                               "[" + opener_obj.document.form.rpt_ofcadd03 .value +"] " +
                               "[" + ComReplaceStr(opener_obj.document.form.rpt_custname .value,"'"," ") +"] " +
                               "[" + opener_obj.document.form.rpt_address01.value +"] " +
                               "[" + opener_obj.document.form.rpt_address02.value +"] " +
                               "[" + opener_obj.document.form.rpt_address03.value +"] " +
                               "[" + opener_obj.document.form.rpt_address04.value +"] " +
                               "[" + opener_obj.document.form.rpt_hjsref   .value +"] " +
                               "[" + ComReplaceStr(opener_obj.document.form.rpt_attnname .value,"'"," ") +"] " +
                               "[" + opener_obj.document.form.rpt_custcode .value +"] " +
                               "[" + opener_obj.document.form.rpt_telno    .value +"] " +
                               "[" + opener_obj.document.form.rpt_faxno    .value +"] " +
                               "[" + opener_obj.document.form.rpt_custvat  .value +"] " +
                               "[" + opener_obj.document.form.remark01     .value +"] " +
                               "[" + opener_obj.document.form.remark02     .value +"] " +
                               "[" + opener_obj.document.form.rpt_header01 .value +"] " +
                               "[" + opener_obj.document.form.rpt_header02 .value +"] " +
                               "[" + opener_obj.document.form.rpt_header03 .value +"] " +
                               "[" + opener_obj.document.form.rpt_header04 .value +"] " +
                               "[" + opener_obj.document.form.rpt_header05 .value +"] " +
                               "[" + opener_obj.document.form.rpt_header06 .value +"] " +
                               "[" + opener_obj.document.form.rpt_header07 .value +"] " +
                               "[" + opener_obj.document.form.rpt_header08 .value +"] " +
                               "[" + opener_obj.document.form.rpt_header09 .value +"] " +
                               "[" + opener_obj.document.form.rpt_header10 .value +"] " +
                               "[" + opener_obj.document.form.rpt_custref  .value +"] " +
                               "[" + opener_obj.document.form.rpt_telfax   .value +"] " +
                               "[" + opener_obj.document.form.rpt_custvatno.value +"] " + 
                               "[" + opnrInvno +"] " +
                               "[" + opnrCreOf +"] "	//cre_ofc_cd 추가
                               ;
            document.form.tftp2.value = opnrTrftp;
            document.form.invno.value = opnrInvno;
            document.form.creof.value = opnrCreOf;
            
            rdObjects[0].SetAppendReport(0);            
            if ( opener_obj.document.form.cntrinvno.value == "1" && opener_obj.document.form.rpt_leftright.value == "L" ) {
                rdObjects[0].FileOpen(RD_path+'apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4905.mrd',RDServerBAT + " " + rdParam2);
            } else if ( opener_obj.document.form.cntrinvno.value == "1" && opener_obj.document.form.rpt_leftright.value == "R" ) {
                rdObjects[0].FileOpen(RD_path+'apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4906.mrd',RDServerBAT + " " + rdParam2);
            }
            if ( document.form.attachYN.checked ) {
                var rdParamAttach = " /rwait /rp [" + opener_obj.document.form.invno.value + "] [" + opener_obj.document.form.isof.value + "] ["+ opnrCreOf +"]" ;
                rdObjects[0].SetAppendReport(1);
                rdObjects[0].FileOpen(RD_path+'apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4907.mrd', RDServerBAT + " " + rdParamAttach);
            }
            
            
        } else {
            
            
            var opener_sheet_obj1 =  opener_obj.document.sheet1;
            
            var fromObj = new Array();
            var rdObj = new Array();
            
                        
            fromObj[1] = document.form;                            // RD 로 보내기 위해 배열로담는다
            rdObj[0] = opener_sheet_obj1;     
             
            sXml = "<?xml version='1.0' encoding='UTF-8'?><SHEET>";
            
            sheetCnt = 1;
            //i = 시트 카운트,
            for(i=0;i<1;i++){
                sheetCnt = i+1;
                if(rdObj[i].RowCount ==0){
                    sXml  += "<SHEET"+sheetCnt+"><DATA TOTAL='0'><TR>";
                    for(j=0;j<=rdObj[i].LastCol;j++){
                        sXml +="<TD></TD>";
                    }
                    sXml +="</TR></DATA></SHEET"+sheetCnt+">";
                }else{
                    
                    //sXml +=RD_GetDataSearchXml(rdObj[i],sheetCnt);
    
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
                            opnrInvno = rdObj[i].CellValue(ir,"invnoo") + "," + opnrInvno;
                            opnrTrftp = rdObj[i].CellValue(ir,"tarftp") + "," + opnrTrftp;
                            opnrCreOf = rdObj[i].CellValue(ir,"isseof") + "," + opnrCreOf;
                        }                    
                    }
    
                    allXml += "  </DATA></SHEET" + sheetCnt + ">";
    
                    sXml += allXml;
    
                }           
            }
            
            document.form.cntrinvno2.value = opener_obj.document.form.cntrinvno            .value;
            document.form.atn_val   .value = opener_obj.document.form.dmdt_payr_cntc_pnt_nm.value;
            document.form.tel_val   .value = opener_obj.document.form.payr_cntc_pnt_phn_no .value;
            document.form.fax_val   .value = opener_obj.document.form.payr_cntc_pnt_fax_no .value;
            document.form.eml_val   .value = opener_obj.document.form.payr_cntc_pnt_eml    .value;

            sXml +="<ETC>"; 
            sXml +="    <OPT_TITLE>" + opener_obj.document.form.rpt_opttitle.value  + "</OPT_TITLE>";
            sXml +="    <OFC_ADD01>" + opener_obj.document.form.rpt_ofcadd01.value  + "</OFC_ADD01>";
            sXml +="    <OFC_ADD02>" + opener_obj.document.form.rpt_ofcadd02.value  + "</OFC_ADD02>";
            sXml +="    <OFC_ADD03>" + opener_obj.document.form.rpt_ofcadd03.value  + "</OFC_ADD03>";        
            sXml +="    <CUST_NAME>" + opener_obj.document.form.rpt_custname .value + "</CUST_NAME>";
            sXml +="    <ADDRESS01>" + opener_obj.document.form.rpt_address01.value + "</ADDRESS01>";
            sXml +="    <ADDRESS02>" + opener_obj.document.form.rpt_address02.value + "</ADDRESS02>";
            sXml +="    <ADDRESS03>" + opener_obj.document.form.rpt_address03.value + "</ADDRESS03>";
            sXml +="    <ADDRESS04>" + opener_obj.document.form.rpt_address04.value + "</ADDRESS04>";
            sXml +="    <HJS_REF>"   + opener_obj.document.form.rpt_hjsref   .value + "</HJS_REF>"  ;
            sXml +="    <ATTN_NAME>" + ComReplaceStr(opener_obj.document.form.rpt_attnname .value,"'"," ") + "</ATTN_NAME>";
            sXml +="    <CUST_CODE>" + opener_obj.document.form.rpt_custcode .value + "</CUST_CODE>";
            sXml +="    <TEL_NO>"    + opener_obj.document.form.rpt_telno    .value + "</TEL_NO>"   ;
            sXml +="    <FAX_NO>"    + opener_obj.document.form.rpt_faxno    .value + "</FAX_NO>"   ;
            sXml +="    <CUST_VAT>"  + opener_obj.document.form.rpt_custvat  .value + "</CUST_VAT>" ;
            sXml +="    <OTS_RMK_1>" + opener_obj.document.form.remark01     .value + "</OTS_RMK_1>";
            sXml +="    <OTS_RMK_2>" + opener_obj.document.form.remark02     .value + "</OTS_RMK_2>";            
            sXml +="    <HEADER01>"  + opener_obj.document.form.rpt_header01 .value + "</HEADER01>" ;
            sXml +="    <HEADER02>"  + opener_obj.document.form.rpt_header02 .value + "</HEADER02>" ;
            sXml +="    <HEADER03>"  + opener_obj.document.form.rpt_header03 .value + "</HEADER03>" ;
            sXml +="    <HEADER04>"  + opener_obj.document.form.rpt_header04 .value + "</HEADER04>" ;
            sXml +="    <HEADER05>"  + opener_obj.document.form.rpt_header05 .value + "</HEADER05>" ;
            sXml +="    <HEADER06>"  + opener_obj.document.form.rpt_header06 .value + "</HEADER06>" ;
            sXml +="    <HEADER07>"  + opener_obj.document.form.rpt_header07 .value + "</HEADER07>" ;
            sXml +="    <HEADER08>"  + opener_obj.document.form.rpt_header08 .value + "</HEADER08>" ;
            sXml +="    <HEADER09>"  + opener_obj.document.form.rpt_header09 .value + "</HEADER09>" ;
            sXml +="    <HEADER10>"  + opener_obj.document.form.rpt_header10 .value + "</HEADER10>" ;
            sXml +="    <CUSTREF>"   + opener_obj.document.form.rpt_custref  .value + "</CUSTREF>"  ;
            sXml +="    <TELFAX>"    + opener_obj.document.form.rpt_telfax   .value + "</TELFAX>"   ;
            sXml +="    <CUSTVATNO>" + opener_obj.document.form.rpt_custvatno.value + "</CUSTVATNO>";
            sXml +="</ETC>";
            sXml +="</SHEET>";
    
            if ( rdObj[0].RowCount  == "0")                     // RD 로 보낼 sheet 에 데이타가 없으면 Error
            {
                errMsg = 'No data found.';
                showErrMessage(errMsg);
                return;
            }
            rdObjects[0].AutoAdjust = true;
            rdObjects[0].HideStatusbar();
            rdObjects[0].ViewShowMode(0);

            rdObjects[0].SetPageLineColor(255,255,255);         
            rdObjects[0].SetAppendReport(1);
            
            var rdParam2 = "/rp [" + opener_obj.document.form.arif .value +"] " +
                               "[" + opener_obj.document.form.frdt .value +"] " +
                               "[" + opener_obj.document.form.todt .value +"] " +
                               "[" + opener_obj.document.form.isof .value +"] " +
                               "[" + opener_obj.document.form.payc .value +"] " +
                               "[" + opener_obj.document.form.payc .value +"] " +
                               "[" + opener_obj.document.form.payc .value +"] " +
                               "[" + opener_obj.document.form.payc .value +"] " +
                               "[" + opener_obj.document.form.payc .value +"] " +
                               "[" + opnrTrftp +"] " +
                               "[" + opener_obj.document.form.scno .value +"] " +
                               "[" + opener_obj.document.form.scno .value +"] " +
                               "[" + opener_obj.document.form.rfan .value +"] " +
                               "[" + opener_obj.document.form.rfan .value +"] " +
                               "[" + opener_obj.document.form.cuno .value +"] " +
                               "[" + opener_obj.document.form.cuno .value +"] " +
                               "[" + opener_obj.document.form.cuno .value +"] " +
                               "[" + opener_obj.document.form.cuno .value +"] " +
                               "[" + opener_obj.document.form.cuno .value +"] " +
                               "[" + opener_obj.document.form.cutp .value +"] " +
                               "[" + opener_obj.document.form.cutp .value +"] " +
                               "[" + opener_obj.document.form.cutp .value +"] " + 
                               
                               "[*** " + opener_obj.document.form.rpt_opttitle .value +" ***] " +
                               "[" + opener_obj.document.form.rpt_ofcadd01 .value +"] " +
                               "[" + opener_obj.document.form.rpt_ofcadd02 .value +"] " +
                               "[" + opener_obj.document.form.rpt_ofcadd03 .value +"] " +
                               "[" + ComReplaceStr(opener_obj.document.form.rpt_custname .value,"'"," ") +"] " +
                               "[" + opener_obj.document.form.rpt_address01.value +"] " +
                               "[" + opener_obj.document.form.rpt_address02.value +"] " +
                               "[" + opener_obj.document.form.rpt_address03.value +"] " +
                               "[" + opener_obj.document.form.rpt_address04.value +"] " +
                               "[" + opener_obj.document.form.rpt_hjsref   .value +"] " +
                               "[" + ComReplaceStr(opener_obj.document.form.rpt_attnname .value,"'"," ") +"] " +
                               "[" + opener_obj.document.form.rpt_custcode .value +"] " +
                               "[" + opener_obj.document.form.rpt_telno    .value +"] " +
                               "[" + opener_obj.document.form.rpt_faxno    .value +"] " +
                               "[" + opener_obj.document.form.rpt_custvat  .value +"] " +
                               "[" + opener_obj.document.form.remark01     .value +"] " +
                               "[" + opener_obj.document.form.remark02     .value +"] " +
                               "[" + opener_obj.document.form.rpt_header01 .value +"] " +
                               "[" + opener_obj.document.form.rpt_header02 .value +"] " +
                               "[" + opener_obj.document.form.rpt_header03 .value +"] " +
                               "[" + opener_obj.document.form.rpt_header04 .value +"] " +
                               "[" + opener_obj.document.form.rpt_header05 .value +"] " +
                               "[" + opener_obj.document.form.rpt_header06 .value +"] " +
                               "[" + opener_obj.document.form.rpt_header07 .value +"] " +
                               "[" + opener_obj.document.form.rpt_header08 .value +"] " +
                               "[" + opener_obj.document.form.rpt_header09 .value +"] " +
                               "[" + opener_obj.document.form.rpt_header10 .value +"] " +
                               "[" + opener_obj.document.form.rpt_custref  .value +"] " +
                               "[" + opener_obj.document.form.rpt_telfax   .value +"] " +
                               "[" + opener_obj.document.form.rpt_custvatno.value +"] " + 
                               "[" + opnrInvno +"] " +
                               "[" + opnrCreOf +"] "
                               ;

            document.form.tftp2.value = opnrTrftp;
            document.form.invno.value = opnrInvno;            
            document.form.creof.value = opnrCreOf;
            
            rdObjects[0].SetAppendReport(0);
            if ( opener_obj.document.form.cntrinvno.value == "0" && opener_obj.document.form.rpt_leftright.value == "L" ) {
                rdObjects[0].FileOpen(RD_path+'apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4903.mrd',RDServerBAT + " " + rdParam2);
            } else if ( opener_obj.document.form.cntrinvno.value == "0" && opener_obj.document.form.rpt_leftright.value == "R" ) {
                rdObjects[0].FileOpen(RD_path+'apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4904.mrd',RDServerBAT + " " + rdParam2);
            }
            if ( document.form.attachYN.checked ) {
                var rdParamAttach = " /rwait /rp [" + opener_obj.document.form.invno.value + "] [" + opener_obj.document.form.isof.value + "] ["+ opnrCreOf +"]" ;
                rdObjects[0].SetAppendReport(1);
                rdObjects[0].FileOpen(RD_path+'apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4907.mrd', RDServerBAT + " " + rdParamAttach);
            }
            
            
        }
        rdObjects[0].DisableToolbar (0);
        rdObjects[0].DisableToolbar (13);
        rdObjects[0].DisableToolbar (14);
        rdObjects[0].DisableToolbar (15);
        rdObjects[0].DisableToolbar (16);
        rdObjects[0].DisableToolbar (17);
    }
     

     /**
      * print화면 오픈
      * print화면 오픈
      * print할수 있는 화면 오픈
      */
     function rdOpenPrint(){      
         
         var sXml = "";      
         var i=0;
         var j=0; 
         var opener_obj = window.dialogArguments;
         
         var opnrInvno = "";
         var opnrTrftp = "";
         var opnrCreOf = "";	//cre_ofc_cd
         
         if ( opener_obj.document.form.cntrinvno.value == "1" ) {
             
             var opener_sheet_obj1 =  opener_obj.document.sheet1;
             
             var fromObj = new Array();
             var rdObj = new Array();
                         
             fromObj[1] = document.form;                            // RD 로 보내기 위해 배열로담는다
             rdObj[0] = opener_sheet_obj1;     
              
             sXml = "<?xml version='1.0' encoding='UTF-8'?><SHEET>";
             
             sheetCnt = 1;
             //i = 시트 카운트,
             for(i=0;i<1;i++){
                 sheetCnt = i+1;
                 if(rdObj[i].RowCount ==0){
                     sXml  += "<SHEET"+sheetCnt+"><DATA TOTAL='0'><TR>";
                     for(j=0;j<=rdObj[i].LastCol;j++){
                         sXml +="<TD></TD>";
                     }
                     sXml +="</TR></DATA></SHEET"+sheetCnt+">";
                 }else{
                     
                     //sXml +=RD_GetDataSearchXml(rdObj[i],sheetCnt);
     
                     //함수 인자 유효성 확인
                     if (typeof rdObj[i] != "object" || rdObj[i].tagName != "OBJECT") {
//                         alert("Data2SearchXml 함수의 sheet_obj 인자는 IBSheet가 아닙니다.");
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
                             opnrInvno = rdObj[i].CellValue(ir,"invnoo") + "," + opnrInvno;
                             opnrTrftp = rdObj[i].CellValue(ir,"tarftp") + "," + opnrTrftp;
                             opnrCreOf = rdObj[i].CellValue(ir,"isseof") + "," + opnrCreOf;
                         }                    
                     }
     
                     allXml += "  </DATA></SHEET" + sheetCnt + ">";
     
                     sXml += allXml;
     
                 }           
             }

             document.form.cntrinvno2.value = opener_obj.document.form.cntrinvno            .value;
             document.form.atn_val   .value = opener_obj.document.form.dmdt_payr_cntc_pnt_nm.value;
             document.form.tel_val   .value = opener_obj.document.form.payr_cntc_pnt_phn_no .value;
             document.form.fax_val   .value = opener_obj.document.form.payr_cntc_pnt_fax_no .value;
             document.form.eml_val   .value = opener_obj.document.form.payr_cntc_pnt_eml    .value;            
             sXml +="<ETC>"; 
             sXml +="    <OPT_TITLE>" + opener_obj.document.form.rpt_opttitle.value  + "</OPT_TITLE>";
             sXml +="    <OFC_ADD01>" + opener_obj.document.form.rpt_ofcadd01.value  + "</OFC_ADD01>";
             sXml +="    <OFC_ADD02>" + opener_obj.document.form.rpt_ofcadd02.value  + "</OFC_ADD02>";
             sXml +="    <OFC_ADD03>" + opener_obj.document.form.rpt_ofcadd03.value  + "</OFC_ADD03>";        
             sXml +="    <CUST_NAME>" + opener_obj.document.form.rpt_custname .value + "</CUST_NAME>";
             sXml +="    <ADDRESS01>" + opener_obj.document.form.rpt_address01.value + "</ADDRESS01>";
             sXml +="    <ADDRESS02>" + opener_obj.document.form.rpt_address02.value + "</ADDRESS02>";
             sXml +="    <ADDRESS03>" + opener_obj.document.form.rpt_address03.value + "</ADDRESS03>";
             sXml +="    <ADDRESS04>" + opener_obj.document.form.rpt_address04.value + "</ADDRESS04>";
             sXml +="    <HJS_REF>"   + opener_obj.document.form.rpt_hjsref   .value + "</HJS_REF>"  ;
             sXml +="    <ATTN_NAME>" + ComReplaceStr(opener_obj.document.form.rpt_attnname .value,"'"," ") + "</ATTN_NAME>";
             sXml +="    <CUST_CODE>" + opener_obj.document.form.rpt_custcode .value + "</CUST_CODE>";
             sXml +="    <TEL_NO>"    + opener_obj.document.form.rpt_telno    .value + "</TEL_NO>"   ;
             sXml +="    <FAX_NO>"    + opener_obj.document.form.rpt_faxno    .value + "</FAX_NO>"   ;
             sXml +="    <CUST_VAT>"  + opener_obj.document.form.rpt_custvat  .value + "</CUST_VAT>" ;
             sXml +="    <OTS_RMK_1>" + opener_obj.document.form.remark01     .value + "</OTS_RMK_1>";
             sXml +="    <OTS_RMK_2>" + opener_obj.document.form.remark02     .value + "</OTS_RMK_2>";
             sXml +="    <HEADER01>"  + opener_obj.document.form.rpt_header01 .value + "</HEADER01>" ;
             sXml +="    <HEADER02>"  + opener_obj.document.form.rpt_header02 .value + "</HEADER02>" ;
             sXml +="    <HEADER03>"  + opener_obj.document.form.rpt_header03 .value + "</HEADER03>" ;
             sXml +="    <HEADER04>"  + opener_obj.document.form.rpt_header04 .value + "</HEADER04>" ;
             sXml +="    <HEADER05>"  + opener_obj.document.form.rpt_header05 .value + "</HEADER05>" ;
             sXml +="    <HEADER06>"  + opener_obj.document.form.rpt_header06 .value + "</HEADER06>" ;
             sXml +="    <HEADER07>"  + opener_obj.document.form.rpt_header07 .value + "</HEADER07>" ;
             sXml +="    <HEADER08>"  + opener_obj.document.form.rpt_header08 .value + "</HEADER08>" ;
             sXml +="    <HEADER09>"  + opener_obj.document.form.rpt_header09 .value + "</HEADER09>" ;
             sXml +="    <HEADER10>"  + opener_obj.document.form.rpt_header10 .value + "</HEADER10>" ;
             sXml +="    <CUSTREF>"   + opener_obj.document.form.rpt_custref  .value + "</CUSTREF>"  ;
             sXml +="    <TELFAX>"    + opener_obj.document.form.rpt_telfax   .value + "</TELFAX>"   ;
             sXml +="    <CUSTVATNO>" + opener_obj.document.form.rpt_custvatno.value + "</CUSTVATNO>";
             sXml +="</ETC>";
             sXml +="</SHEET>";
     
             if ( rdObj[0].RowCount  == "0")                     // RD 로 보낼 sheet 에 데이타가 없으면 Error
             {
                 errMsg = 'No data found.';
                 showErrMessage(errMsg);
                 return;
             }
             rdObjects[0].AutoAdjust = true;
             rdObjects[0].HideStatusbar();
             rdObjects[0].ViewShowMode(0);
                     
             rdObjects[0].SetPageLineColor(255,255,255);       
  
             var rdParam2 = "/rp [" + opener_obj.document.form.arif .value +"] " +
                                "[" + opener_obj.document.form.frdt .value +"] " +
                                "[" + opener_obj.document.form.todt .value +"] " +
                                "[" + opener_obj.document.form.isof .value +"] " +
                                "[" + opener_obj.document.form.payc .value +"] " +
                                "[" + opener_obj.document.form.payc .value +"] " +
                                "[" + opener_obj.document.form.payc .value +"] " +
                                "[" + opener_obj.document.form.payc .value +"] " +
                                "[" + opener_obj.document.form.payc .value +"] " +
                                "[" + opnrTrftp +"] " +
                                "[" + opener_obj.document.form.scno .value +"] " +
                                "[" + opener_obj.document.form.scno .value +"] " +
                                "[" + opener_obj.document.form.rfan .value +"] " +
                                "[" + opener_obj.document.form.rfan .value +"] " +
                                "[" + opener_obj.document.form.cuno .value +"] " +
                                "[" + opener_obj.document.form.cuno .value +"] " +
                                "[" + opener_obj.document.form.cuno .value +"] " +
                                "[" + opener_obj.document.form.cuno .value +"] " +
                                "[" + opener_obj.document.form.cuno .value +"] " +
                                "[" + opener_obj.document.form.cutp .value +"] " +
                                "[" + opener_obj.document.form.cutp .value +"] " +
                                "[" + opener_obj.document.form.cutp .value +"] " + 
                                
                                "[*** " + opener_obj.document.form.rpt_opttitle .value +" ***] " +
                                "[" + opener_obj.document.form.rpt_ofcadd01 .value +"] " +
                                "[" + opener_obj.document.form.rpt_ofcadd02 .value +"] " +
                                "[" + opener_obj.document.form.rpt_ofcadd03 .value +"] " +
                                "[" + ComReplaceStr(opener_obj.document.form.rpt_custname .value,"'"," ") +"] " +
                                "[" + opener_obj.document.form.rpt_address01.value +"] " +
                                "[" + opener_obj.document.form.rpt_address02.value +"] " +
                                "[" + opener_obj.document.form.rpt_address03.value +"] " +
                                "[" + opener_obj.document.form.rpt_address04.value +"] " +
                                "[" + opener_obj.document.form.rpt_hjsref   .value +"] " +
                                "[" + ComReplaceStr(opener_obj.document.form.rpt_attnname .value,"'"," ") +"] " +
                                "[" + opener_obj.document.form.rpt_custcode .value +"] " +
                                "[" + opener_obj.document.form.rpt_telno    .value +"] " +
                                "[" + opener_obj.document.form.rpt_faxno    .value +"] " +
                                "[" + opener_obj.document.form.rpt_custvat  .value +"] " +
                                "[" + opener_obj.document.form.remark01     .value +"] " +
                                "[" + opener_obj.document.form.remark02     .value +"] " +
                                "[" + opener_obj.document.form.rpt_header01 .value +"] " +
                                "[" + opener_obj.document.form.rpt_header02 .value +"] " +
                                "[" + opener_obj.document.form.rpt_header03 .value +"] " +
                                "[" + opener_obj.document.form.rpt_header04 .value +"] " +
                                "[" + opener_obj.document.form.rpt_header05 .value +"] " +
                                "[" + opener_obj.document.form.rpt_header06 .value +"] " +
                                "[" + opener_obj.document.form.rpt_header07 .value +"] " +
                                "[" + opener_obj.document.form.rpt_header08 .value +"] " +
                                "[" + opener_obj.document.form.rpt_header09 .value +"] " +
                                "[" + opener_obj.document.form.rpt_header10 .value +"] " +
                                "[" + opener_obj.document.form.rpt_custref  .value +"] " +
                                "[" + opener_obj.document.form.rpt_telfax   .value +"] " +
                                "[" + opener_obj.document.form.rpt_custvatno.value +"] " + 
                                "[" + opnrInvno +"] " +
                                "[" + opnrCreOf +"] "	//cre_ofc_cd 추가
                                ;

             document.form.tftp2.value = opnrTrftp;
             document.form.invno.value = opnrInvno;
             document.form.creof.value = opnrCreOf;
             
             rdObjects[0].SetAppendReport(0);            
             if ( opener_obj.document.form.cntrinvno.value == "1" && opener_obj.document.form.rpt_leftright.value == "L" ) {
                 rdObjects[0].FileOpen(RD_path+'apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4905.mrd',RDServerBAT + " " + rdParam2);
             } else if ( opener_obj.document.form.cntrinvno.value == "1" && opener_obj.document.form.rpt_leftright.value == "R" ) {
                 rdObjects[0].FileOpen(RD_path+'apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4906.mrd',RDServerBAT + " " + rdParam2);
             }
             if ( document.form.attachYN.checked ) {
            	 var rdParamAttach = " /rwait /rp [" + opener_obj.document.form.invno.value + "] [" + opener_obj.document.form.isof.value + "] ["+ opnrCreOf +"]" ;
                 rdObjects[0].SetAppendReport(1);
                 rdObjects[0].FileOpen(RD_path+'apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4907.mrd', RDServerBAT + " " + rdParamAttach);
             }
             rdObjects[0].PrintDialog();
             
             
         } else {
             
             
             var opener_sheet_obj1 =  opener_obj.document.sheet1;
             
             var fromObj = new Array();
             var rdObj = new Array();
                         
             fromObj[1] = document.form;                            // RD 로 보내기 위해 배열로담는다
             rdObj[0] = opener_sheet_obj1;     
              
             sXml = "<?xml version='1.0' encoding='UTF-8'?><SHEET>";
             
             sheetCnt = 1;
             //i = 시트 카운트,
             for(i=0;i<1;i++){
                 sheetCnt = i+1;
                 if(rdObj[i].RowCount ==0){
                     sXml  += "<SHEET"+sheetCnt+"><DATA TOTAL='0'><TR>";
                     for(j=0;j<=rdObj[i].LastCol;j++){
                         sXml +="<TD></TD>";
                     }
                     sXml +="</TR></DATA></SHEET"+sheetCnt+">";
                 }else{
                     
                     //sXml +=RD_GetDataSearchXml(rdObj[i],sheetCnt);
     
                     //함수 인자 유효성 확인
                     if (typeof rdObj[i] != "object" || rdObj[i].tagName != "OBJECT") {
//                         alert("Data2SearchXml 함수의 sheet_obj 인자는 IBSheet가 아닙니다.");
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
                             opnrInvno = rdObj[i].CellValue(ir,"invnoo") + "," + opnrInvno;
                             opnrTrftp = rdObj[i].CellValue(ir,"tarftp") + "," + opnrTrftp;
                             opnrCreOf = rdObj[i].CellValue(ir,"isseof") + "," + opnrCreOf;
                         }                    
                     }
     
                     allXml += "  </DATA></SHEET" + sheetCnt + ">";
     
                     sXml += allXml;
     
                 }           
             }
             
             document.form.cntrinvno2.value = opener_obj.document.form.cntrinvno            .value;
             document.form.atn_val   .value = opener_obj.document.form.dmdt_payr_cntc_pnt_nm.value;
             document.form.tel_val   .value = opener_obj.document.form.payr_cntc_pnt_phn_no .value;
             document.form.fax_val   .value = opener_obj.document.form.payr_cntc_pnt_fax_no .value;
             document.form.eml_val   .value = opener_obj.document.form.payr_cntc_pnt_eml    .value;

             sXml +="<ETC>"; 
             sXml +="    <OPT_TITLE>" + opener_obj.document.form.rpt_opttitle.value  + "</OPT_TITLE>";
             sXml +="    <OFC_ADD01>" + opener_obj.document.form.rpt_ofcadd01.value  + "</OFC_ADD01>";
             sXml +="    <OFC_ADD02>" + opener_obj.document.form.rpt_ofcadd02.value  + "</OFC_ADD02>";
             sXml +="    <OFC_ADD03>" + opener_obj.document.form.rpt_ofcadd03.value  + "</OFC_ADD03>";        
             sXml +="    <CUST_NAME>" + opener_obj.document.form.rpt_custname .value + "</CUST_NAME>";
             sXml +="    <ADDRESS01>" + opener_obj.document.form.rpt_address01.value + "</ADDRESS01>";
             sXml +="    <ADDRESS02>" + opener_obj.document.form.rpt_address02.value + "</ADDRESS02>";
             sXml +="    <ADDRESS03>" + opener_obj.document.form.rpt_address03.value + "</ADDRESS03>";
             sXml +="    <ADDRESS04>" + opener_obj.document.form.rpt_address04.value + "</ADDRESS04>";
             sXml +="    <HJS_REF>"   + opener_obj.document.form.rpt_hjsref   .value + "</HJS_REF>"  ;
             sXml +="    <ATTN_NAME>" + ComReplaceStr(opener_obj.document.form.rpt_attnname .value,"'"," ") + "</ATTN_NAME>";
             sXml +="    <CUST_CODE>" + opener_obj.document.form.rpt_custcode .value + "</CUST_CODE>";
             sXml +="    <TEL_NO>"    + opener_obj.document.form.rpt_telno    .value + "</TEL_NO>"   ;
             sXml +="    <FAX_NO>"    + opener_obj.document.form.rpt_faxno    .value + "</FAX_NO>"   ;
             sXml +="    <CUST_VAT>"  + opener_obj.document.form.rpt_custvat  .value + "</CUST_VAT>" ;
             sXml +="    <OTS_RMK_1>" + opener_obj.document.form.remark01     .value + "</OTS_RMK_1>";
             sXml +="    <OTS_RMK_2>" + opener_obj.document.form.remark02     .value + "</OTS_RMK_2>";            
             sXml +="    <HEADER01>"  + opener_obj.document.form.rpt_header01 .value + "</HEADER01>" ;
             sXml +="    <HEADER02>"  + opener_obj.document.form.rpt_header02 .value + "</HEADER02>" ;
             sXml +="    <HEADER03>"  + opener_obj.document.form.rpt_header03 .value + "</HEADER03>" ;
             sXml +="    <HEADER04>"  + opener_obj.document.form.rpt_header04 .value + "</HEADER04>" ;
             sXml +="    <HEADER05>"  + opener_obj.document.form.rpt_header05 .value + "</HEADER05>" ;
             sXml +="    <HEADER06>"  + opener_obj.document.form.rpt_header06 .value + "</HEADER06>" ;
             sXml +="    <HEADER07>"  + opener_obj.document.form.rpt_header07 .value + "</HEADER07>" ;
             sXml +="    <HEADER08>"  + opener_obj.document.form.rpt_header08 .value + "</HEADER08>" ;
             sXml +="    <HEADER09>"  + opener_obj.document.form.rpt_header09 .value + "</HEADER09>" ;
             sXml +="    <HEADER10>"  + opener_obj.document.form.rpt_header10 .value + "</HEADER10>" ;
             sXml +="    <CUSTREF>"   + opener_obj.document.form.rpt_custref  .value + "</CUSTREF>"  ;
             sXml +="    <TELFAX>"    + opener_obj.document.form.rpt_telfax   .value + "</TELFAX>"   ;
             sXml +="    <CUSTVATNO>" + opener_obj.document.form.rpt_custvatno.value + "</CUSTVATNO>";
             sXml +="</ETC>";
             sXml +="</SHEET>";
     
             if ( rdObj[0].RowCount  == "0")                     // RD 로 보낼 sheet 에 데이타가 없으면 Error
             {
                 errMsg = 'No data found.';
                 showErrMessage(errMsg);
                 return;
             }
             rdObjects[0].AutoAdjust = true;
             rdObjects[0].HideStatusbar();
             rdObjects[0].ViewShowMode(0);

             rdObjects[0].SetPageLineColor(255,255,255);         
             rdObjects[0].SetAppendReport(1);
             
             var rdParam2 = "/rp [" + opener_obj.document.form.arif .value +"] " +
                                "[" + opener_obj.document.form.frdt .value +"] " +
                                "[" + opener_obj.document.form.todt .value +"] " +
                                "[" + opener_obj.document.form.isof .value +"] " +
                                "[" + opener_obj.document.form.payc .value +"] " +
                                "[" + opener_obj.document.form.payc .value +"] " +
                                "[" + opener_obj.document.form.payc .value +"] " +
                                "[" + opener_obj.document.form.payc .value +"] " +
                                "[" + opener_obj.document.form.payc .value +"] " +
                                "[" + opnrTrftp +"] " +
                                "[" + opener_obj.document.form.scno .value +"] " +
                                "[" + opener_obj.document.form.scno .value +"] " +
                                "[" + opener_obj.document.form.rfan .value +"] " +
                                "[" + opener_obj.document.form.rfan .value +"] " +
                                "[" + opener_obj.document.form.cuno .value +"] " +
                                "[" + opener_obj.document.form.cuno .value +"] " +
                                "[" + opener_obj.document.form.cuno .value +"] " +
                                "[" + opener_obj.document.form.cuno .value +"] " +
                                "[" + opener_obj.document.form.cuno .value +"] " +
                                "[" + opener_obj.document.form.cutp .value +"] " +
                                "[" + opener_obj.document.form.cutp .value +"] " +
                                "[" + opener_obj.document.form.cutp .value +"] " + 
                                
                                "[*** " + opener_obj.document.form.rpt_opttitle .value +" ***] " +
                                "[" + opener_obj.document.form.rpt_ofcadd01 .value +"] " +
                                "[" + opener_obj.document.form.rpt_ofcadd02 .value +"] " +
                                "[" + opener_obj.document.form.rpt_ofcadd03 .value +"] " +
                                "[" + ComReplaceStr(opener_obj.document.form.rpt_custname .value,"'"," ") +"] " +
                                "[" + opener_obj.document.form.rpt_address01.value +"] " +
                                "[" + opener_obj.document.form.rpt_address02.value +"] " +
                                "[" + opener_obj.document.form.rpt_address03.value +"] " +
                                "[" + opener_obj.document.form.rpt_address04.value +"] " +
                                "[" + opener_obj.document.form.rpt_hjsref   .value +"] " +
                                "[" + ComReplaceStr(opener_obj.document.form.rpt_attnname .value,"'"," ") +"] " +
                                "[" + opener_obj.document.form.rpt_custcode .value +"] " +
                                "[" + opener_obj.document.form.rpt_telno    .value +"] " +
                                "[" + opener_obj.document.form.rpt_faxno    .value +"] " +
                                "[" + opener_obj.document.form.rpt_custvat  .value +"] " +
                                "[" + opener_obj.document.form.remark01     .value +"] " +
                                "[" + opener_obj.document.form.remark02     .value +"] " +
                                "[" + opener_obj.document.form.rpt_header01 .value +"] " +
                                "[" + opener_obj.document.form.rpt_header02 .value +"] " +
                                "[" + opener_obj.document.form.rpt_header03 .value +"] " +
                                "[" + opener_obj.document.form.rpt_header04 .value +"] " +
                                "[" + opener_obj.document.form.rpt_header05 .value +"] " +
                                "[" + opener_obj.document.form.rpt_header06 .value +"] " +
                                "[" + opener_obj.document.form.rpt_header07 .value +"] " +
                                "[" + opener_obj.document.form.rpt_header08 .value +"] " +
                                "[" + opener_obj.document.form.rpt_header09 .value +"] " +
                                "[" + opener_obj.document.form.rpt_header10 .value +"] " +
                                "[" + opener_obj.document.form.rpt_custref  .value +"] " +
                                "[" + opener_obj.document.form.rpt_telfax   .value +"] " +
                                "[" + opener_obj.document.form.rpt_custvatno.value +"] " + 
                                "[" + opnrInvno +"] " +
                                "[" + opnrCreOf +"] "	//cre_ofc_cd 추가
                                ;

             document.form.tftp2.value = opnrTrftp;
             document.form.invno.value = opnrInvno;
             document.form.creof.value = opnrCreOf;
             

             rdObjects[0].SetAppendReport(0);
             if ( opener_obj.document.form.cntrinvno.value == "0" && opener_obj.document.form.rpt_leftright.value == "L" ) {
                 rdObjects[0].FileOpen(RD_path+'apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4903.mrd',RDServerBAT + " " + rdParam2);
             } else if ( opener_obj.document.form.cntrinvno.value == "0" && opener_obj.document.form.rpt_leftright.value == "R" ) {
                 rdObjects[0].FileOpen(RD_path+'apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4904.mrd',RDServerBAT + " " + rdParam2);
             }
             
             if ( document.form.attachYN.checked ) {
            	 var rdParamAttach = " /rwait /rp [" + opener_obj.document.form.invno.value + "] [" + opener_obj.document.form.isof.value + "] ["+ opnrCreOf +"]" ;
                 rdObjects[0].SetAppendReport(1);
                 rdObjects[0].FileOpen(RD_path+'apps/alps/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4907.mrd', RDServerBAT + " " + rdParamAttach);
             }
             rdObjects[0].PrintDialog();
             
         }
         rdObjects[0].DisableToolbar (0);
         rdObjects[0].DisableToolbar (13);
         rdObjects[0].DisableToolbar (14);
         rdObjects[0].DisableToolbar (15);
         rdObjects[0].DisableToolbar (16);
         rdObjects[0].DisableToolbar (17);
     }     
     
/*  
UI_DMT_4903 OTS Issue Preview - by INV No - Left
UI_DMT_4904 OTS Issue Preview - by INV No - Right
UI_DMT_4905 OTS Issue Preview - by CNTR No - Left
UI_DMT_4906 OTS Issue Preview - by CNTR No - Right
UI_DMT_4907 OTS Detail Preview - Print
UI_DMT_4908 OTS Detail Preview - Down Excel
*/     


    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
        var sheetID = sheetObj.id;
//        ComDebug ( "sheetID [" + sheetID + "]" );
        switch(sheetID) {
        
            case "sheet1":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 102;
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
        }
    }

    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
            case IBSEARCH_ASYNC05:      //fax
                formObj.f_cmd.value = SEARCH05;
            
ComOpenWait(true);
sheetObj.WaitImageVisible = false;
            
                var sXml06 = sheetObj.GetSaveXml("DMTCommonFaxEmailGS.do", FormQueryString(formObj));
                
ComOpenWait(false);
                
                if ( document.form.attachYN.checked && formObj.rd_fxeml_file_name.value == "EES_DMT_4907.mrd" ) {
                    alert(dmtGetMsgText(sXml06));
                } else if ( !document.form.attachYN.checked ) {
                    alert(dmtGetMsgText(sXml06));
                }
            break;

            case IBSEARCH_ASYNC06:      //email single
                formObj.f_cmd.value = SEARCH06;
            
ComOpenWait(true);
sheetObj.WaitImageVisible = false;
            
                var sXml06 = sheetObj.GetSaveXml("DMTCommonFaxEmailGS.do", FormQueryString(formObj));
                
ComOpenWait(false);
                
                alert(dmtGetMsgText(sXml06));
            break;
            
            case IBSEARCH_ASYNC07:      //email multi
                formObj.f_cmd.value = SEARCH07;
            
ComOpenWait(true);
sheetObj.WaitImageVisible = false;
            
                var sXml06 = sheetObj.GetSaveXml("DMTCommonFaxEmailGS.do", FormQueryString(formObj));
                
ComOpenWait(false);
                
                alert(dmtGetMsgText(sXml06));
            break;
        }
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