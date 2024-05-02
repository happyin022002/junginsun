/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_4012.jsp
*@FileTitle  : Outstanding Issue Preview
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/30
=========================================================*/
var sheetObjects=new Array();
var sheetCnt=0;
    // Common Global variables
    var docObjects=new Array();
    var sheetCnt=0;
//    var rdObjects=new Array();
//	rdObjects[0] = document.getElementById("csrPrevie"); 
//    var rdCnt=0;
    /*Click the button event handler defined to handle the event takes */
    document.onclick=processButtonClick;
    /* Event handler processing by button name */
    function processButtonClick(){
         /***** case in Sheet count are more two by Tab, defining adding sheet *****/
         var sheetObject=docObjects[0];
         var sheetObject1=docObjects[1];
         var sheetObject2=docObjects[2];
         /*******************************************************/
         var formObject=document.form; 
//         var rdObject=rdObjects[0];
//        try {
            var srcName=ComGetEvent("name");
            switch(srcName) {
                case "btn_Close":
                	ComClosePopup(); 
                break;
                case "btn_remark":
                    var opener_obj=window.dialogArguments;
                    if(!opener_obj) opener_obj = parent;
                    var invno=opener_obj.document.form.rpt_custcode.value;
                    ComOpenPopupWithTarget('EES_DMT_4105.do?jspno=4012&invno='+invno, 920, 240, "", "0,1,1,1,1,1,1", true);
                break;
                case "btn_OTS_Print":
                	rdOpenPrint();
                break;
                case "btn_Sheet_Set":
                    ComOpenPopupWithTarget('EES_DMT_4101.do?issoff='+formObject.h_usr_off.value+'&tftp2='+formObject.tftp2.value+'&sheetp=O&jspno=EES_DMT_4012', 725, 780, "", "0,1,1,1,1,1,1", true);
                break;
                case "btn_Sheet_Option":
                    ComOpenPopupWithTarget('/EES_DMT_4103.do?issoff='+formObject.h_usr_off.value+'&jspno=EES_DMT_4012', 625, 680, "", "0,1,1,1,1,1,1", true);
                break;
                case "btn_Fax_Email":
                    var url="EES_DMT_4104.do"
                        +"?s_ofc_cd=" +ComGetObjValue(formObject.h_usr_off)
                        +"&s_cust_cd="+ComGetObjValue(formObject.payc)
                        +"&s_bkg_no=" +ComGetObjValue(formObject.bkgno)
                        +"&s_pod_cd="; // +ComGetObjValue(formObject.pod_cd)
                    var returnValue=ComOpenWindowCenter(url, "EES_DMT_4104", "825","600", true);                    
                break;
                case "btn1_fax_send":
                    var opener_obj=window.dialogArguments;
                    if(!opener_obj) opener_obj = parent;
//                    if(ComGetObjValue(opener_obj.payr_faxnos) == "") {
//                        ComShowCodeMessage("DMT01090");
//                        return;
//                    } 
                    formObject.rd_fxeml_sys_cd         .value="DMT";
                    if        ( opener_obj.document.form.cntrinvno.value == "0" && opener_obj.document.form.rpt_leftright.value == "L" ) {
                        formObject.rd_fxeml_file_name      .value="EES_DMT_4903.mrd";                        
                    } else if ( opener_obj.document.form.cntrinvno.value == "0" && opener_obj.document.form.rpt_leftright.value == "R" ) {
                        formObject.rd_fxeml_file_name      .value="EES_DMT_4904.mrd";
                    } else if ( opener_obj.document.form.cntrinvno.value == "1" && opener_obj.document.form.rpt_leftright.value == "L" ) {
                        formObject.rd_fxeml_file_name      .value="EES_DMT_4905.mrd";
                    } else if ( opener_obj.document.form.cntrinvno.value == "1" && opener_obj.document.form.rpt_leftright.value == "R" ) {
                        formObject.rd_fxeml_file_name      .value="EES_DMT_4906.mrd";
                    }
                    formObject.rd_fxeml_bat_flg        .value="N";
                    formObject.rd_fxeml_title          .value="Statement of Accounts(Custmer Code: "+document.form.payc.value+")";
                    formObject.rd_fxeml_doc_tp         .value="O";
                    formObject.rd_fxeml_rd_param       .value="/rp [" + opener_obj.document.form.arif .value +"] " +
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
                               "[" + opener_obj.document.form.rpt_comref   .value +"] " +
                               "[" + opener_obj.document.form.rpt_attnname .value +"] " +
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
//                    var arr_faxnos  = ComGetObjValue(opener_obj.payr_faxnos).split(";");
//                    var re_faxnos   = "";
//                    var msg1 = "";
//                    for(var iII=0; iII< arr_faxnos.length; iII++) {
//                        re_faxnos   += ComGetObjValue(opener_obj.payer_cd)+";"+arr_faxnos[iII];
//                        msg1        += arr_faxnos[iII] +"\n\t";
//                    }
//                
//                    if ( !ComShowCodeConfirm( "DMT01092" , msg1 ) ) {                    
//                        return false;
//                    }
//                    formObject.rd_fxeml_fax_no         .value = ComGetObjValue(opener_obj.payr_faxnos);
                    formObject.rd_fxeml_fax_sndr_id    .value="COMPANY";
                    formObject.rd_fxeml_eml_sndr_nm    .value="COMPANY";
                    formObject.rd_fxeml_eml_rcvr_add   .value="";
                    var currDateEmail=ComGetNowInfo();
                    formObject.rd_fxeml_eml_atch_file  .value=currDateEmail+"_"+document.form.payc .value;
                    formObject.rd_fxeml_eml_templt     .value="EES_DMT_4011_01.html"; // Template Location C:/sitectx/OPUSCNTR\APP-INF/config/template/mailtemplate/template.htmlmail
                    formObject.rd_fxeml_eml_tmplt_param.value="";
                    //doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC05);
                    var attachYN="N";
                    if ( document.form.attachYN.checked ) {
                    	attachYN="Y";
                        formObject.rd_fxeml_file_name2      .value="EES_DMT_4907.mrd";                        
                        formObject.rd_fxeml_rd_param2       .value="/rp [" + document.form.invno.value + "] [" + document.form.isof.value + "] [" + document.form.creof.value + "]";
                        //doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC05);                        
                    }       
                    // pop up
        			//var ofc_cd=ComGetObjValue(formObject.isof);
        			var ofc_cd=ComGetObjValue(formObject.h_usr_off); //2016.04.06 Modify
        			var url="EES_DMT_4107.do"
        				+"?s_ofc_cd="+ofc_cd
        				+"&s_cust_cd="+ComGetObjValue(formObject.payc)
        				+"&s_bkg_no="+ComGetObjValue(formObject.bkgno)
        				+"&s_pod_cd="
        				+"&jspno=4012"
        				+"&telno="+ComGetObjValue(formObject.tel_val)
        				+"&faxno="+ComGetObjValue(formObject.fax_val)
        				+"&email="+ComGetObjValue(formObject.eml_val)
        				+"&cntc_seq="+attachYN										
        				;
        			ComOpenWindowCenter(url, "EES_DMT_4107", "520","250", true);
                break;   
                case "btn1_email_send":
                    var opener_obj=window.dialogArguments;
                    if (!opener_obj)  opener_obj=window.opener; //20160623  
                    if(!opener_obj) opener_obj = parent;
//                    if(ComGetObjValue(opener_obj.payr_emailnos) == "" || ComGetObjValue(opener_obj.payr_emailnos) == undefined) {
//                        ComShowCodeMessage("DMT01091");
//                        return;
//                    }                    
//                    
                    opener_obj = opener_obj.document.form;

                    formObject.rd_fxeml_sys_cd         .value="DMT";
                    if        ( opener_obj.cntrinvno.value == "0" && opener_obj.rpt_leftright.value == "L" ) {
                        formObject.rd_fxeml_file_name      .value="EES_DMT_4903.mrd";                        
                    } else if ( opener_obj.cntrinvno.value == "0" && opener_obj.rpt_leftright.value == "R" ) {
                        formObject.rd_fxeml_file_name      .value="EES_DMT_4904.mrd";
                    } else if ( opener_obj.cntrinvno.value == "1" && opener_obj.rpt_leftright.value == "L" ) {
                        formObject.rd_fxeml_file_name      .value="EES_DMT_4905.mrd";
                    } else if ( opener_obj.cntrinvno.value == "1" && opener_obj.rpt_leftright.value == "R" ) {
                        formObject.rd_fxeml_file_name      .value="EES_DMT_4906.mrd";
                    }
                    formObject.rd_fxeml_bat_flg        .value="N";
                    formObject.rd_fxeml_title          .value="Statement of Accounts(Custmer Code: "+formObject.payc.value+")";
                    formObject.rd_fxeml_doc_tp         .value="O";
                    formObject.rd_fxeml_rd_param       .value="/rp [" + opener_obj.arif .value +"] " +
                               "[" + opener_obj.frdt .value +"] " +
                               "[" + opener_obj.todt .value +"] " +
                               "[" + opener_obj.isof .value +"] " +
                               "[" + opener_obj.payc .value +"] " +
                               "[" + opener_obj.payc .value +"] " +
                               "[" + opener_obj.payc .value +"] " +
                               "[" + opener_obj.payc .value +"] " +
                               "[" + opener_obj.payc .value +"] " +
                               "[" + document.form.tftp2.value +"] " +
                               "[" + opener_obj.scno .value +"] " +
                               "[" + opener_obj.scno .value +"] " +
                               "[" + opener_obj.rfan .value +"] " +
                               "[" + opener_obj.rfan .value +"] " +
                               "[" + opener_obj.cuno .value +"] " +
                               "[" + opener_obj.cuno .value +"] " +
                               "[" + opener_obj.cuno .value +"] " +
                               "[" + opener_obj.cuno .value +"] " +
                               "[" + opener_obj.cuno .value +"] " +
                               "[" + opener_obj.cutp .value +"] " +
                               "[" + opener_obj.cutp .value +"] " +
                               "[" + opener_obj.cutp .value +"] " + 
                               "[*** " + opener_obj.rpt_opttitle .value +" ***] " +
                               "[" + opener_obj.rpt_ofcadd01 .value +"] " +
                               "[" + opener_obj.rpt_ofcadd02 .value +"] " +
                               "[" + opener_obj.rpt_ofcadd03 .value +"] " +
                               "[" + ComReplaceStr(opener_obj.rpt_custname .value,"'"," ") +"] " +
                               "[" + opener_obj.rpt_address01.value +"] " +
                               "[" + opener_obj.rpt_address02.value +"] " +
                               "[" + opener_obj.rpt_address03.value +"] " +
                               "[" + opener_obj.rpt_address04.value +"] " +
                               "[" + opener_obj.rpt_comref   .value +"] " +
                               "[" + opener_obj.rpt_attnname .value +"] " +
                               "[" + opener_obj.rpt_custcode .value +"] " +
                               "[" + opener_obj.rpt_telno    .value +"] " +
                               "[" + opener_obj.rpt_faxno    .value +"] " +
                               "[" + opener_obj.rpt_custvat  .value +"] " +
                               "[" + opener_obj.remark01     .value +"] " +
                               "[" + opener_obj.remark02     .value +"] " +
                               "[" + opener_obj.rpt_header01 .value +"] " +
                               "[" + opener_obj.rpt_header02 .value +"] " +
                               "[" + opener_obj.rpt_header03 .value +"] " +
                               "[" + opener_obj.rpt_header04 .value +"] " +
                               "[" + opener_obj.rpt_header05 .value +"] " +
                               "[" + opener_obj.rpt_header06 .value +"] " +
                               "[" + opener_obj.rpt_header07 .value +"] " +
                               "[" + opener_obj.rpt_header08 .value +"] " +
                               "[" + opener_obj.rpt_header09 .value +"] " +
                               "[" + opener_obj.rpt_header10 .value +"] " +
                               "[" + opener_obj.rpt_custref  .value +"] " +
                               "[" + opener_obj.rpt_telfax   .value +"] " +
                               "[" + opener_obj.rpt_custvatno.value +"] " + 
                               "[" + document.form.invno.value +"] " +
                               "[" + document.form.creof.value +"] "
                               ;
//                    var arr_faxnos  = ComGetObjValue(opener_obj.payr_faxnos).split(";");
//                    var re_faxnos   = "";
//                    
//                    for(var i=0; i< arr_faxnos.length; i++) {
//                        re_faxnos   += ComGetObjValue(opener_obj.payer_cd)+";"+arr_faxnos[i];
//                        re_faxnos   += ";";
//                    }
//                    var msg1 = "";
//                    rcvr_email      = ComGetObjValue(opener_obj.payr_emailnos);
//                    var arr_emails  = ComGetObjValue(opener_obj.payr_emailnos).split(";");
//                    
//                    for(var i=0 ; i < arr_emails.length; i++) {
//                        msg1        += arr_emails[i] +"\n\t";
//                    }
//                    if ( !ComShowCodeConfirm( "DMT01093" , msg1 ) ) {                    
//                        return false;
//                    }
//                    
                    formObject.rd_fxeml_fax_no         .value="";
                    formObject.rd_fxeml_fax_sndr_id    .value="COMPANY";
                    formObject.rd_fxeml_eml_sndr_nm    .value="COMPANY";
                    formObject.rd_fxeml_eml_rcvr_add   .value="";
                    var currDateEmail=ComGetNowInfo();
                    formObject.rd_fxeml_eml_atch_file  .value=currDateEmail+"_"+document.form.payc .value;
                    formObject.rd_fxeml_eml_templt     .value="EES_DMT_4011_01.html"; // Template Location C:/sitectx/OPUSCNTR\APP-INF/config/template/mailtemplate/template.htmlmail
                    formObject.rd_fxeml_eml_tmplt_param.value="";
                    var attachYN="N";
                    if ( document.form.attachYN.checked ) {
                    	attachYN="Y";
                    }       
                    // pop up
        			var ofc_cd=ComGetObjValue(formObject.h_usr_off);//isof
        			var url="EES_DMT_4108.do"
        				+"?s_ofc_cd="+ofc_cd
        				+"&s_cust_cd="+ComGetObjValue(formObject.payc)
        				+"&s_bkg_no="+ComGetObjValue(formObject.bkgno)
        				+"&s_pod_cd="
        				+"&jspno=4012"
        				+"&telno="+ComGetObjValue(formObject.tel_val)
        				+"&faxno="+ComGetObjValue(formObject.fax_val)
        				+"&email="+ComGetObjValue(formObject.eml_val)
        				+"&cntc_seq="+attachYN										
        				;
        			ComOpenWindowCenter(url, "EES_DMT_4108", "520","250", true);
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
       sheetObjects[sheetCnt++]=sheet_obj;
    }    
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
                //doActionIBSheet(sheetObjects[i],document.form,IBSEARCH);
        }         
        rdOpen();
        //rdObjects[0].PrintDialog();
    }
    /**
     * print screen Open
     * print screen Open
     * print Screen Open
     */
    function rdOpen(){
        var sXml="";      
        var i=0;
        var j=0; 
        var opener_obj=window.dialogArguments;
        if(!opener_obj) opener_obj = parent;
        var opnrInvno="";
        var opnrTrftp="";
        var opnrCreOf="";	//cre_ofc_cd
        if ( opener_obj.document.form.cntrinvno.value == "1" ) {
            var opener_sheet_obj1=opener_obj.sheet1;
            var fromObj=new Array();
            var rdObj=new Array();
            fromObj[1]=document.form;                            // arry for sending RD 
            rdObj[0]=opener_sheet_obj1;     
            sXml="<?xml version='1.0' encoding='UTF-8'?><SHEET>";
            sheetCnt=1;
            for(i=0;i<1;i++){
                sheetCnt=i+1;
                if(rdObj[i].RowCount()==0){
                    sXml  += "<SHEET"+sheetCnt+"><DATA TOTAL='0'><TR>";
                    for(j=0;j<=rdObj[i].LastCol();j++){
                        sXml +="<TD></TD>";
                    }
                    sXml +="</TR></DATA></SHEET"+sheetCnt+">";
                }else{
                    //sXml +=RD_GetDataSearchXml(rdObj[i],sheetCnt);
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
//							opnrInvno=rdObj[i].GetCellValue(ir,"invnoo") + "," + opnrInvno;
//							opnrTrftp=rdObj[i].GetCellValue(ir,"tarftp") + "," + opnrTrftp;
//							opnrCreOf=rdObj[i].GetCellValue(ir,"isseof") + "," + opnrCreOf;
                        }                    
                    }
                    allXml += "  </DATA></SHEET" + sheetCnt + ">";
                    sXml += allXml;
                }           
            }
            document.form.cntrinvno2.value=opener_obj.document.form.cntrinvno            .value;
            document.form.atn_val   .value=opener_obj.document.form.dmdt_payr_cntc_pnt_nm.value;
            document.form.tel_val   .value=opener_obj.document.form.payr_cntc_pnt_phn_no .value;
            document.form.fax_val   .value=opener_obj.document.form.payr_cntc_pnt_fax_no .value;
            document.form.eml_val   .value=opener_obj.document.form.payr_cntc_pnt_eml    .value;            
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
            sXml +="    <COM_REF>"   + opener_obj.document.form.rpt_comref   .value + "</COM_REF>"  ;
            sXml +="    <ATTN_NAME>" + opener_obj.document.form.rpt_attnname .value + "</ATTN_NAME>";
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
            if ( rdObj[0].RowCount()== "0")
            {
                errMsg='No data found.';
                showErrMessage(errMsg);
                return;
            }
//            rdObjects[0].AutoAdjust=false;
            viewer.zoom = 100;
//            rdObjects[0].HideStatusBar();
//            rdObjects[0].ViewShowMode(0);
//            rdObjects[0].SetPageLineColor(255,255,255);            
//            rdObjects[0].ApplyLicense("0.0.0.0");    
            viewer.setRData(sXml);            

            for ( var z01=1 ; z01 < rdObj[0].RowCount()+1 ; z01++  ) {
            	if ( rdObj[0].GetCellValue(z01,1) == 1 ) {
            		opnrInvno=rdObj[0].GetCellValue(z01,"invnoo") + "," + opnrInvno;
            		opnrTrftp=rdObj[0].GetCellValue(z01,"tarftp") + "," + opnrTrftp;
            		opnrCreOf=rdObj[0].GetCellValue(z01,"isseof") + "," + opnrCreOf;
                }
            }
            
            document.form.tftp2.value=opnrTrftp;
            document.form.invno.value=opnrInvno;            
            document.form.creof.value=opnrCreOf;
            
            var rdParam2="/rp [" + opener_obj.document.form.arif .value +"] " +
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
                               "[" + opener_obj.document.form.rpt_comref   .value +"] " +
                               "[" + opener_obj.document.form.rpt_attnname .value +"] " +
                               "[" + opener_obj.document.form.rpt_custcode .value +"] " +
                               "[" + opener_obj.document.form.payr_cntc_pnt_phn_no    .value +"] " +
                               "[" + opener_obj.document.form.payr_cntc_pnt_fax_no    .value +"] " +
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
            
//            rdObjects[0].SetAppendReport(0);
            var mrdpath1 = '';
            if ( opener_obj.document.form.cntrinvno.value == "1" && opener_obj.document.form.rpt_leftright.value == "L" ) {
//                rdObjects[0].FileOpen(RD_path+'apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4905.mrd',RDServerBAT + " " + rdParam2);
            	mrdpath1 = RD_path+'apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4905.mrd';
            } else if ( opener_obj.document.form.cntrinvno.value == "1" && opener_obj.document.form.rpt_leftright.value == "R" ) {
//                rdObjects[0].FileOpen(RD_path+'apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4906.mrd',RDServerBAT + " " + rdParam2);
            	mrdpath1 = RD_path+'apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4906.mrd';
            }
            var param1 = RDServerBAT + " " + rdParam2;
            
            appendReport = [
                    {mrdPath : mrdpath1, mrdParam : param1}
            ];
            
            if ( document.form.attachYN.checked ) {
                var rdParamAttach=" /rwait /rp [" + opener_obj.document.form.invno.value + "] [" + opener_obj.document.form.isof.value + "] ["+ opnrCreOf +"]" ;
//                rdObjects[0].SetAppendReport(1);
                var mrdpath2 = RD_path+'apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4907.mrd';
                var param2 = RDServerBAT + " " + rdParamAttach;
                
                appendReport = [
                        {mrdPath : mrdpath1, mrdParam : param1},
                        {mrdPath : mrdpath2, mrdParam : param2}
                ];
//                rdObjects[0].FileOpen(RD_path+'apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4907.mrd', RDServerBAT + " " + rdParamAttach);
            }
            
            viewer.openFile(appendReport, {timeout:1800});
        } else {
            var opener_sheet_obj1=opener_obj.sheet1;
            var fromObj=new Array();
            var rdObj=new Array();
            fromObj[1]=document.form;                           
            rdObj[0]=opener_sheet_obj1;     
            sXml="<?xml version='1.0' encoding='UTF-8'?><SHEET>";
            sheetCnt=1;
            for(i=0;i<1;i++){
                sheetCnt=i+1;
                if(rdObj[i].RowCount()==0){
                    sXml  += "<SHEET"+sheetCnt+"><DATA TOTAL='0'><TR>";
                    for(j=0;j<=rdObj[i].LastCol();j++){
                        sXml +="<TD></TD>";
                    }
                    sXml +="</TR></DATA></SHEET"+sheetCnt+">";
                }else{
                    //sXml +=RD_GetDataSearchXml(rdObj[i],sheetCnt);
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
//							opnrInvno=rdObj[i].GetCellValue(ir,"invnoo") + "," + opnrInvno;
//							opnrTrftp=rdObj[i].GetCellValue(ir,"tarftp") + "," + opnrTrftp;
//							opnrCreOf=rdObj[i].GetCellValue(ir,"isseof") + "," + opnrCreOf;
                        }                    
                    }
                    allXml += "  </DATA></SHEET" + sheetCnt + ">";
                    sXml += allXml;
                }           
            }

            document.form.cntrinvno2.value=opener_obj.document.form.cntrinvno            .value;
            document.form.atn_val   .value=opener_obj.document.form.dmdt_payr_cntc_pnt_nm.value;
            document.form.tel_val   .value=opener_obj.document.form.payr_cntc_pnt_phn_no .value;
            document.form.fax_val   .value=opener_obj.document.form.payr_cntc_pnt_fax_no .value;
            document.form.eml_val   .value=opener_obj.document.form.payr_cntc_pnt_eml    .value;
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
            sXml +="    <COM_REF>"   + opener_obj.document.form.rpt_comref   .value + "</COM_REF>"  ;
            sXml +="    <ATTN_NAME>" + opener_obj.document.form.rpt_attnname .value + "</ATTN_NAME>";
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
            if ( rdObj[0].RowCount()== "0")
            {
                errMsg='No data found.';
                showErrMessage(errMsg);
                return;
            }
//            rdObjects[0].AutoAdjust=false;
            viewer.zoom = 100;
//            rdObjects[0].HideStatusBar();
//            rdObjects[0].ViewShowMode(0);
//            rdObjects[0].SetPageLineColor(255,255,255);          
//            rdObjects[0].ApplyLicense("0.0.0.0");       
//            rdObjects[0].SetAppendReport(1);   
            viewer.setRData(sXml);

            for ( var z01=1 ; z01 < rdObj[0].RowCount()+1 ; z01++  ) {
            	if ( rdObj[0].GetCellValue(z01,1) == 1 ) {
            		opnrInvno=rdObj[0].GetCellValue(z01,"invnoo") + "," + opnrInvno;
            		opnrTrftp=rdObj[0].GetCellValue(z01,"tarftp") + "," + opnrTrftp;
            		opnrCreOf=rdObj[0].GetCellValue(z01,"isseof") + "," + opnrCreOf;
                }
            }
            
            document.form.tftp2.value=opnrTrftp;
            document.form.invno.value=opnrInvno;            
            document.form.creof.value=opnrCreOf;
            
            var rdParam2="/rp [" + opener_obj.document.form.arif .value +"] " +
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
                               "[" + opener_obj.document.form.rpt_comref   .value +"] " +
                               "[" + opener_obj.document.form.rpt_attnname .value +"] " +
                               "[" + opener_obj.document.form.rpt_custcode .value +"] " +
                               "[" + opener_obj.document.form.payr_cntc_pnt_phn_no    .value +"] " +
                               "[" + opener_obj.document.form.payr_cntc_pnt_fax_no    .value +"] " +
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
           
//            rdObjects[0].SetAppendReport(0);
            var appendReport = [];
            var mrdpath1 = '';
            if ( opener_obj.document.form.cntrinvno.value == "0" && opener_obj.document.form.rpt_leftright.value == "L" ) {
//                rdObjects[0].FileOpen(RD_path+'apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4903.mrd',RDServerBAT + " " + rdParam2);
            	mrdpath1 = RD_path+'apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4903.mrd'
            } else if ( opener_obj.document.form.cntrinvno.value == "0" && opener_obj.document.form.rpt_leftright.value == "R" ) {
//                rdObjects[0].FileOpen(RD_path+'apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4904.mrd',RDServerBAT + " " + rdParam2);
            	mrdpath1 = RD_path+'apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4904.mrd';
            }
            var param1 = RDServerBAT + " " + rdParam2;
            
            appendReport = [
                    {mrdPath : mrdpath1, mrdParam : param1}
            ];
            
            if ( document.form.attachYN.checked ) {
                var rdParamAttach=" /rwait /rp [" + opener_obj.document.form.invno.value + "] [" + opener_obj.document.form.isof.value + "] ["+ opnrCreOf +"]" ;
//                rdObjects[0].SetAppendReport(1);
                var mrdpath2 = RD_path+'apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4907.mrd';
                var param2 = RDServerBAT + " " + rdParamAttach
                
                appendReport = [
                        {mrdPath : mrdpath1, mrdParam : param1},
                        {mrdPath : mrdpath2, mrdParam : param2}
                ];
//                rdObjects[0].FileOpen(RD_path+'apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4907.mrd', RDServerBAT + " " + rdParamAttach);
            }
            
            viewer.openFile(appendReport, {timeout:1800});
        }
		var hiddenParam = ["save"];
        viewer.hideToolbarItem(hiddenParam);

        //rdObjects[0].PrintDialog();
    }
     /**
      * printscreen Open
      * printscreen Open
      */
     function rdOpenPrint(){      
         var sXml="";      
         var i=0;
         var j=0; 
         var opener_obj=window.dialogArguments;
         if(!opener_obj) opener_obj = parent;
         var opnrInvno="";
         var opnrTrftp="";
         var opnrCreOf="";	//cre_ofc_cd
         if ( opener_obj.document.form.cntrinvno.value == "1" ) {
             var opener_sheet_obj1=opener_obj.sheet1;
             var fromObj=new Array();
             var rdObj=new Array();
             fromObj[1]=document.form;                           
             rdObj[0]=opener_sheet_obj1;     
             sXml="<?xml version='1.0' encoding='UTF-8'?><SHEET>";
             sheetCnt=1;
             for(i=0;i<1;i++){
                 sheetCnt=i+1;
                 if(rdObj[i].RowCount()==0){
                     sXml  += "<SHEET"+sheetCnt+"><DATA TOTAL='0'><TR>";
                     for(j=0;j<=rdObj[i].LastCol();j++){
                         sXml +="<TD></TD>";
                     }
                     sXml +="</TR></DATA></SHEET"+sheetCnt+">";
                 }else{
                     //sXml +=RD_GetDataSearchXml(rdObj[i],sheetCnt);
//                     if (typeof rdObj[i] != "object" || rdObj[i].tagName != "OBJECT") {
//                         return "";
//                     }
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
//							opnrInvno=rdObj[i].GetCellValue(ir,"invnoo") + "," + opnrInvno;
//							opnrTrftp=rdObj[i].GetCellValue(ir,"tarftp") + "," + opnrTrftp;
//							opnrCreOf=rdObj[i].GetCellValue(ir,"isseof") + "," + opnrCreOf;
                         }                    
                     }
                     allXml += "  </DATA></SHEET" + sheetCnt + ">";
                     sXml += allXml;
                 }           
             }
             document.form.cntrinvno2.value=opener_obj.document.form.cntrinvno            .value;
             document.form.atn_val   .value=opener_obj.document.form.dmdt_payr_cntc_pnt_nm.value;
             document.form.tel_val   .value=opener_obj.document.form.payr_cntc_pnt_phn_no .value;
             document.form.fax_val   .value=opener_obj.document.form.payr_cntc_pnt_fax_no .value;
             document.form.eml_val   .value=opener_obj.document.form.payr_cntc_pnt_eml    .value;            
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
             sXml +="    <COM_REF>"   + opener_obj.document.form.rpt_comref   .value + "</COM_REF>"  ;
             sXml +="    <ATTN_NAME>" + opener_obj.document.form.rpt_attnname .value + "</ATTN_NAME>";
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
             if ( rdObj[0].RowCount()== "0")
             {
                 errMsg='No data found.';
                 showErrMessage(errMsg);
                 return;
             }
//             rdObjects[0].AutoAdjust=false;
             viewer.zoom = 100;
//             rdObjects[0].HideStatusBar();
//             rdObjects[0].ViewShowMode(0);
//             rdObjects[0].SetPageLineColor(255,255,255);        
//             rdObjects[0].ApplyLicense("0.0.0.0");       

             for ( var z01=1 ; z01 < rdObj[0].RowCount()+1 ; z01++  ) {
             	if ( rdObj[0].GetCellValue(z01,1) == 1 ) {
             		opnrInvno=rdObj[0].GetCellValue(z01,"invnoo") + "," + opnrInvno;
             		opnrTrftp=rdObj[0].GetCellValue(z01,"tarftp") + "," + opnrTrftp;
             		opnrCreOf=rdObj[0].GetCellValue(z01,"isseof") + "," + opnrCreOf;
                 }
             }
             
             document.form.tftp2.value=opnrTrftp;
             document.form.invno.value=opnrInvno;            
             document.form.creof.value=opnrCreOf;
             
             var rdParam2="/rp [" + opener_obj.document.form.arif .value +"] " +
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
                                "[" + opener_obj.document.form.rpt_comref   .value +"] " +
                                "[" + opener_obj.document.form.rpt_attnname .value +"] " +
                                "[" + opener_obj.document.form.rpt_custcode .value +"] " +
                                "[" + opener_obj.document.form.payr_cntc_pnt_phn_no    .value +"] " +
                                "[" + opener_obj.document.form.payr_cntc_pnt_fax_no    .value +"] " +
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

//             rdObjects[0].SetAppendReport(0);
             var appendReport = [];
             var mrdpath1 = '';
             if ( opener_obj.document.form.cntrinvno.value == "1" && opener_obj.document.form.rpt_leftright.value == "L" ) {
//                 rdObjects[0].FileOpen(RD_path+'apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4905.mrd',RDServerBAT + " " + rdParam2);
            	 mrdpath1 = RD_path+'apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4905.mrd';
             } else if ( opener_obj.document.form.cntrinvno.value == "1" && opener_obj.document.form.rpt_leftright.value == "R" ) {
//                 rdObjects[0].FileOpen(RD_path+'apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4906.mrd',RDServerBAT + " " + rdParam2);
            	 mrdpath1 = RD_path+'apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4906.mrd';
             }
             var param1 = RDServerBAT + " " + rdParam2;
             
             appendReport = [
	                 {mrdPath : mrdpath1, mrdParam : param1}
	         ];
             
             if ( document.form.attachYN.checked ) {
            	 var rdParamAttach=" /rwait /rp [" + opener_obj.document.form.invno.value + "] [" + opener_obj.document.form.isof.value + "] ["+ opnrCreOf +"]" ;
//                 rdObjects[0].SetAppendReport(1);
            	 var mrdpath2 = RD_path+'apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4907.mrd';
            	 var param2 = RDServerBAT + " " + rdParamAttach;
            	 
            	 appendReport = [
    	                 {mrdPath : mrdpath1, mrdParam : param1},
    	                 {mrdPath : mrdpath2, mrdParam : param2}
    	         ];
//                 rdObjects[0].FileOpen(RD_path+'apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4907.mrd', RDServerBAT + " " + rdParamAttach);
             }
             
             viewer.openFile(appendReport, {timeout:1800});
             viewer.print({isServerSide:true});
         } else {
             var opener_sheet_obj1=opener_obj.sheet1;
             var fromObj=new Array();
             var rdObj=new Array();
             fromObj[1]=document.form;                            
             rdObj[0]=opener_sheet_obj1;     
             sXml="<?xml version='1.0' encoding='UTF-8'?><SHEET>";
             sheetCnt=1;
             for(i=0;i<1;i++){
                 sheetCnt=i+1;
                 if(rdObj[i].RowCount()==0){
                     sXml  += "<SHEET"+sheetCnt+"><DATA TOTAL='0'><TR>";
                     for(j=0;j<=rdObj[i].LastCol();j++){
                         sXml +="<TD></TD>";
                     }
                     sXml +="</TR></DATA></SHEET"+sheetCnt+">";
                 }else{
                     //sXml +=RD_GetDataSearchXml(rdObj[i],sheetCnt);
//                     if (typeof rdObj[i] != "object" || rdObj[i].tagName != "OBJECT") {
//                         return "";
//                     }
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
//							opnrInvno=rdObj[i].GetCellValue(ir,"invnoo") + "," + opnrInvno;
//							opnrTrftp=rdObj[i].GetCellValue(ir,"tarftp") + "," + opnrTrftp;
//							opnrCreOf=rdObj[i].GetCellValue(ir,"isseof") + "," + opnrCreOf;
                         }                    
                     }
                     allXml += "  </DATA></SHEET" + sheetCnt + ">";
                     sXml += allXml;
                 }           
             }
             document.form.cntrinvno2.value=opener_obj.document.form.cntrinvno            .value;
             document.form.atn_val   .value=opener_obj.document.form.dmdt_payr_cntc_pnt_nm.value;
             document.form.tel_val   .value=opener_obj.document.form.payr_cntc_pnt_phn_no .value;
             document.form.fax_val   .value=opener_obj.document.form.payr_cntc_pnt_fax_no .value;
             document.form.eml_val   .value=opener_obj.document.form.payr_cntc_pnt_eml    .value;
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
             sXml +="    <COM_REF>"   + opener_obj.document.form.rpt_comref   .value + "</COM_REF>"  ;
             sXml +="    <ATTN_NAME>" + opener_obj.document.form.rpt_attnname .value + "</ATTN_NAME>";
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
             if ( rdObj[0].RowCount()== "0")
             {
                 errMsg='No data found.';
                 showErrMessage(errMsg);
                 return;
             }
//             rdObjects[0].AutoAdjust=false;
             viewer.zoom = 100;
//             rdObjects[0].HideStatusBar();
//             rdObjects[0].ViewShowMode(0);
//             rdObjects[0].SetPageLineColor(255,255,255);         
//             rdObjects[0].ApplyLicense("0.0.0.0");        
//             rdObjects[0].SetAppendReport(1);
             
             for ( var z01=1 ; z01 < rdObj[0].RowCount()+1 ; z01++  ) {
             	if ( rdObj[0].GetCellValue(z01,1) == 1 ) {
             		opnrInvno=rdObj[0].GetCellValue(z01,"invnoo") + "," + opnrInvno;
             		opnrTrftp=rdObj[0].GetCellValue(z01,"tarftp") + "," + opnrTrftp;
             		opnrCreOf=rdObj[0].GetCellValue(z01,"isseof") + "," + opnrCreOf;
                 }
             }
             
             document.form.tftp2.value=opnrTrftp;
             document.form.invno.value=opnrInvno;            
             document.form.creof.value=opnrCreOf;
             
             var rdParam2="/rp [" + opener_obj.document.form.arif .value +"] " +
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
                                "[" + opener_obj.document.form.rpt_comref   .value +"] " +
                                "[" + opener_obj.document.form.rpt_attnname .value +"] " +
                                "[" + opener_obj.document.form.rpt_custcode .value +"] " +
                                "[" + opener_obj.document.form.payr_cntc_pnt_phn_no    .value +"] " +
                                "[" + opener_obj.document.form.payr_cntc_pnt_fax_no    .value +"] " +
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

//             rdObjects[0].SetAppendReport(0);
             var appendReport = [];
             var mrdpath1 = '';
             if ( opener_obj.document.form.cntrinvno.value == "0" && opener_obj.document.form.rpt_leftright.value == "L" ) {
//                 rdObjects[0].FileOpen(RD_path+'apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4903.mrd',RDServerBAT + " " + rdParam2);
            	 mrdpath1 = RD_path+'apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4903.mrd';
             } else if ( opener_obj.document.form.cntrinvno.value == "0" && opener_obj.document.form.rpt_leftright.value == "R" ) {
//                 rdObjects[0].FileOpen(RD_path+'apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4904.mrd',RDServerBAT + " " + rdParam2);
            	 mrdpath1 = RD_path+'apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4904.mrd'
             }
             var param1 = RDServerBAT + " " + rdParam2;
             
             appendReport = [
                     {mrdPath : mrdpath1, mrdParam : param1}
             ];

             if ( document.form.attachYN.checked ) {
            	 var rdParamAttach=" /rwait /rp [" + opener_obj.document.form.invno.value + "] [" + opener_obj.document.form.isof.value + "] ["+ opnrCreOf +"]" ;
//                 rdObjects[0].SetAppendReport(1);
            	 var mrdpath2 = RD_path+'apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4907.mrd';
            	 var param2 = RDServerBAT + " " + rdParamAttach;
            	 
            	 appendReport = [
                         {mrdPath : mrdpath1, mrdParam : param1},
                         {mrdPath : mrdpath2, mrdParam : param2}
                 ];
//                 rdObjects[0].FileOpen(RD_path+'apps/opus/ees/dmt/dmtinvoicemgt/invoiceissuecollectionmgt/report/EES_DMT_4907.mrd', RDServerBAT + " " + rdParamAttach);
             }
             
             viewer.openFile(appendReport, {timeout:1800});
             viewer.print({isServerSide:true});
         }
		var hiddenParam = ["save"];
        viewer.hideToolbarItem(hiddenParam);
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
        var cnt=0;
        var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":
                with(sheetObj){
                
              var HeadTitle="";
              var headCount=ComCountHeadTitle(HeadTitle);
             

              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
              var headers = [ { Text:HeadTitle, Align:"Center"}];
              InitHeaders(headers, info);


              SetEditable(1);
              //SetSheetHeight(102);
                }
                break;             
        }
    }
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
            case IBSEARCH_ASYNC05:      //fax
                formObj.f_cmd.value=SEARCH05;
                ComOpenWait(true);
                sheetObj.SetWaitImageVisible(0);
                 var sXml06=sheetObj.GetSaveData("DMTCommonFaxEmailGS.do", FormQueryString(formObj));
                 ComOpenWait(false);
                if ( document.form.attachYN.checked && formObj.rd_fxeml_file_name.value == "EES_DMT_4907.mrd" ) {
                    alert(dmtGetMsgText(sXml06));
                } else if ( !document.form.attachYN.checked ) {
                    alert(dmtGetMsgText(sXml06));
                }
            break;
            case IBSEARCH_ASYNC06:      //email single
                formObj.f_cmd.value=SEARCH06;
                ComOpenWait(true);
                sheetObj.SetWaitImageVisible(0);
                 var sXml06=sheetObj.GetSaveData("DMTCommonFaxEmailGS.do", FormQueryString(formObj));
                 ComOpenWait(false);
                alert(dmtGetMsgText(sXml06));
            break;
            case IBSEARCH_ASYNC07:      //email multi
                formObj.f_cmd.value=SEARCH07;
                ComOpenWait(true);
                sheetObj.SetWaitImageVisible(0);
                 var sXml06=sheetObj.GetSaveData("DMTCommonFaxEmailGS.do", FormQueryString(formObj));
                 ComOpenWait(false);
                alert(dmtGetMsgText(sXml06));
            break;
        }
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
