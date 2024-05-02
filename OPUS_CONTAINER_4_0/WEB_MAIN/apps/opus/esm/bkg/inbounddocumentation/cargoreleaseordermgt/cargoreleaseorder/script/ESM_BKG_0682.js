/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   :ESM_BKG_0682.js
*@FileTitle  : Korea Cargo Release (D/O)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/07
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
                    [modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
                    character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    var sheetObjects=new Array();
    var sheetNames=new Array("blInfo", "doRlseSts", "demInfo", "demDtl", "totBlbAmt", "partial");
    var sheetCnt=0;
    var blInfoHeadCount="";
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            if(!ComIsBtnEnable(srcName)){
                return;
            }
            switch(srcName) {
                //Retrieve
                case "btn_retrieve":
                    doActionIBSheet(sheetObjects["blInfo"], formObject,IBSEARCH);
                break;
                //Save
                case "btn_Save":
                    doActionIBSheet(sheetObjects["blInfo"], formObject,IBSAVE);
                break;
                //Preview
                case "btn_preview":
                    preview();
                break;
                case "btn_print":
                	print();
                break;                //Assign
                case "btn_assign":
                    doActionIBSheet(sheetObjects["blInfo"], formObject, MULTI04);
                break;
                //Release
                case "btn_release":
                    doActionIBSheet(sheetObjects["doRlseSts"], formObject, MULTI06);
                break;
                //Hold
                case "btn_Hold":
                    doActionIBSheet(sheetObjects["blInfo"], formObject, MULTI07);
                break;
                //History
                case "btn_History":
                    go_history();
                break;
                //Form Setting
                case "btn_form_setup":
                    go_formSetting();
                break;
                //Receiver Info
                case "btn_receiverinfo":
                    go_receiver();
                break;
                //Cancel
                case "btn_cancel":
                    doActionIBSheet(sheetObjects["doRlseSts"], formObject, MULTI05);
                break;
                //Remark
                case "btn_remark":
                    go_remark();
                break;            
                case "btn_cct":
                    blOutstandingAmountPopOpen(true);
                break;
                case "btn_third_cct":
                    blOutstandingAmountPopOpen(false);
                break;
                case "btn_dmdt":
                    go_dmdt();
                break;
                case "btn_tpb":
                    var frDate=ComGetDateAdd(null, "D", -60);
                    var toDate=ComGetNowInfo("ymd", "");
                    var otsStsCd="";
                    if (document.form.tpb_status.value == "1") {
                        otsStsCd="P";
                    } else {
                        otsStsCd="T";
                    }
                    var condition="?";
                        condition += "s_state=BKG";
                        condition += "&s_bkg_no_all="+sheetObjects["blInfo"].GetCellValue(1, "blInfo_bkg_no");
                        condition += "&s_bl_no_all="+sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no");
                        condition += "&s_ots_sts_cd=" + otsStsCd;
                        condition += "&pgmNo=ESD_TPB_0134";
                    ComOpenWindowCenter('/opuscntr/ESD_TPB_0134.do'+condition, 'win4', 1024, 318, false);
                break;
                case "btn_bl_surr_rmk":
                    var condition="?";
                    condition += "bkg_no="+ sheetObjects["blInfo"].GetCellValue(1, "blInfo_bkg_no");
                        condition += "&inquery_only=Y";
                        condition += "&pgmNo=ESM_BKG_0400";
                    ComOpenWindowCenter('/opuscntr/ESM_BKG_0400_POP.do'+ condition, 'bl_surr_rmk', 900, 300, false);
                break;
                case "btn_bl_preview":
                	//checking retrieve option              
                 	if(ComIsEmpty(formObject.bkg_no.value)){
                        ComShowCodeMessage('BKG40031', formObject.bkg_no.value);
                        formObject.bkg_no.focus();
                        return false;
                    }
    	        	var bkg_no=formObject.bkg_no.value;                
        	        var blType="";
        			var param='bkg_no=' + bkg_no + '&pgmNo=ESM_BKG_0927' + '&bl_tp_cd=D&form_level=6';
        			var url="ESM_BKG_0927.do?" + param;
        			ComOpenWindowCenter('ESM_BKG_0927_POP.do?' + param, "PopupEsmBkg0927", 900, 700, false);
        			break;               
                break;
                case "btn_msnbonded":
                    go_msnbonded();
                break;
                case "btn_attorney":
                    go_attorney();
                break;
                case "btn_edoinquiry":
                    //calling popup
                    go_edoinquiry();
                break;
                case "btn_edotransmit":
                    //calling popup
                    go_edotransmit();
                break;
                case "btn_edoresult":
                    //calling popup
                    go_edoresult();
                break;
                case "btn_stcancel":
                    pressSelfTransToTMNL('SC')
                    doActionIBSheet(sheetObjects["blInfo"], formObject, MULTI08);
                break;
                case "btn_edisend":
                    pressSelfTransToTMNL('ES');
                    doActionIBSheet(sheetObjects["blInfo"], formObject, MULTI08);
                break;
                case "img_exp_del_dt":
                    var cal=new ComCalendar();
                    cal.select(formObject.exp_del_dt, 'yyyy-MM-dd');
                break;
                //RCV Cancel
                case "btn_obl_cancel":
                    oblInit();
                break;
                case "btn_dem_retrieve":
                    doActionIBSheet(sheetObjects["blInfo"], formObject,COMMAND07);
                break;
                case "btn_do":
                    if(sheetObjects["blInfo"].RowCount() == 0){
                        ComShowCodeMessage("BKG00149");
                        return false;
                    }
                    if (sheetObjects["blInfo"].GetCellValue(1,"blInfo_edo_rqst_seq_5jn") == "") {
                        ComShowCodeMessage("BKG40113");
                        return false;
                    }
                    var param="?";
                    	param += "edo_rqst_no="+sheetObjects["blInfo"].GetCellValue(1 ,"blInfo_edo_rqst_no");
                        param += "&edo_tp_cd=5JN";
                        param += "&edo_rqst_seq_5jn="+sheetObjects["blInfo"].GetCellValue(1,"blInfo_edo_rqst_seq_5jn");
                        param += "&edo_rqst_seq_5jm="+sheetObjects["blInfo"].GetCellValue(1,"blInfo_edo_rqst_seq_5jm");
                        param += "&edo_rqst_seq_5jk="+sheetObjects["blInfo"].GetCellValue(1,"blInfo_edo_rqst_seq_5jk");
                        param += "&pgmNo=ESM_BKG_0133";
                    ComOpenPopup("/opuscntr/ESM_BKG_0133.do"+param, 960, 670, "do", '0,0,1,1,1', false);
                break;
                case "btn_self":
                    if(sheetObjects["blInfo"].RowCount() == 0){
                        ComShowCodeMessage("BKG00149");
                        return false;
                    }
                    if (sheetObjects["blInfo"].GetCellValue(1,"blInfo_edo_rqst_seq_5jm") == "") {
                        ComShowCodeMessage("BKG40111");
                        return false;
                    }
                    var param="?";
                    param += "edo_rqst_no="+sheetObjects["blInfo"].GetCellValue(1 ,"blInfo_edo_rqst_no");
                        param += "&edo_tp_cd=5JM";
						param += "&edo_rqst_seq_5jn="+sheetObjects["blInfo"].GetCellValue(1,"blInfo_edo_rqst_seq_5jn");
						param += "&edo_rqst_seq_5jm="+sheetObjects["blInfo"].GetCellValue(1,"blInfo_edo_rqst_seq_5jm");
						param += "&edo_rqst_seq_5jk="+sheetObjects["blInfo"].GetCellValue(1,"blInfo_edo_rqst_seq_5jk");
                        param += "&pgmNo=ESM_BKG_0136";
                    ComOpenPopup("ESM_BKG_0136.do"+param, 960, 670, "self", '0,0,1,1,1', false);
                    
                break;
                case "btn_bonded":
                    if(sheetObjects["blInfo"].RowCount() == 0){
                        ComShowCodeMessage("BKG00149");
                        return false;
                    }
                    if (sheetObjects["blInfo"].GetCellValue(1,"blInfo_edo_rqst_seq_5jk") == "") {
                        ComShowCodeMessage("BKG40112");
                        return false;
                    }
                    var param="?";
                    param += "edo_rqst_no="+sheetObjects["blInfo"].GetCellValue(1 ,"blInfo_edo_rqst_no");
                        param += "&edo_tp_cd=5JK";
                        param += "&edo_rqst_seq_5jn="+sheetObjects["blInfo"].GetCellValue(1,"blInfo_edo_rqst_seq_5jn");
                        param += "&edo_rqst_seq_5jm="+sheetObjects["blInfo"].GetCellValue(1,"blInfo_edo_rqst_seq_5jm");
                        param += "&edo_rqst_seq_5jk="+sheetObjects["blInfo"].GetCellValue(1,"blInfo_edo_rqst_seq_5jk");
                        param += "&pgmNo=ESM_BKG_0135";
                    ComOpenPopup("/opuscntr/ESM_BKG_0135.do"+param, 960, 670, "bonded", '0,0,1,1,1', false);

                break;
                case "btn_hold_remark":
                    var paramVal="?sheet_name=B&pgmNo=ESM_BKG_1089";
                    ComOpenWindowCenter('ESM_BKG_1089.do' + paramVal, 'Hold Remark', 600, 270, false);
                break;
                case "btn_Close":
                	ComClosePopup();
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
    /**
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items
     * defining list on the top of source
     */
    function setSheetObject(sheet_obj){
       //sheetObjects[sheetCnt++] = sheet_obj;
       sheetObjects[sheet_obj.id]=sheet_obj; 
    }
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
    	var formObj=document.form;
   
    	fnInSetComboBox(formObj.blInfo_bl_otr_doc_rcv_cd, evtCode, evtValue, "|", "", "", true, "");
        for(i=0;i<sheetNames.length;i++){
            if(sheetObjects[sheetNames[i]].id =='doRlseSts' || sheetObjects[sheetNames[i]].id =='demInfo'){
                ComConfigSheet (sheetObjects[sheetNames[i]]);
            }
            initSheet(sheetObjects[sheetNames[i]],i+1);
            if(sheetObjects[sheetNames[i]].id =='doRlseSts' || sheetObjects[sheetNames[i]].id =='demInfo'){
                ComEndConfigSheet(sheetObjects[sheetNames[i]]);
            }
        }
        
//        for(i=0;i<rdObjects.length;i++){
//            initRdConfig(rdObjects[i]);
//        }
        
        initControl();
        
        //focus on retrieve condition BL number
        ComSetFocus(document.form.bl_no)
        //deactivating all button except retrieve button
        buttonDisabledAll();
        
        //@ Test Code Start ----------
//		form.bkg_no.value = 'NYC400230200';
//        form.cntr_no.value ='NYKU8057001'
		//@ Test Code End   ----------
        
        if(document.getElementById("bkg_no").value !='' ){
            doActionIBSheet(sheetObjects["blInfo"], document.form,IBSEARCH);
        }
    }
    /**
     * handling event screen
     * Axon event handling
     */
    function initControl(){
        //1. event catch
        axon_event.addListenerForm('keydown' , 'obj_keypress'   , form);
        axon_event.addListenerForm('click'    , 'obj_click'      , form);
        axon_event.addListenerForm('change'   , 'obj_change'     , form);
        axon_event.addListenerForm('blur'     , 'obj_deactivate' , form);
        axon_event.addListenerForm('focus'    , 'obj_focus'      , form);
//        axon_event.addListenerForm('keydown', 'ComKeyEnter', form);
    }
    /************************************************************************************
     handling event screen start
    ************************************************************************************/
    /**
     * process onkeypress event of HTML Control
     */
    function obj_keypress(){
        var keyCode=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
        var srcName=ComGetEvent("name");
        if (keyCode == 13 && (srcName == 'bl_no' || srcName == 'bkg_no' || srcName == 'cntr_no')) {
            conditionReset();
            if (srcName == 'cntr_no'){
                if(!ComChkObjValid(document.form.cntr_no)) {
                    return false;
                }
                fnSearchContainer();
            } else {
                doActionIBSheet(sheetObjects["blInfo"], document.form,IBSEARCH);
            }
        } // end if
        else if (keyCode == 13 && srcName == 'exp_del_dt') {
        	if(sheetObjects["blInfo"].GetCellValue(1,"blInfo_bkg_no") != undefined){
                doActionIBSheet(sheetObjects["blInfo"], document.form, COMMAND07);
            }
        }
        
    }
    /**
     * process onClick event of HTML Control
     */
    function obj_click(){
        if (ComGetEvent("name") == "bl_no") {
            showHideLayers();
        }
    }
    /**
     * checking onchange event of HTML Control validation
     */
    var onchangeFlag = true;
    function obj_change(){
        var oForm=document.form;
        //var ComGetEvent();
        conditionTrim();
        if(ComGetEvent("name") == "bl_no" || ComGetEvent("name") == "bkg_no" ){
        	//@ 조회 후 세팅시 bkg_no bl_no conditionReset발생 안하게 하기 위함 
        	if(onchangeFlag){
        		conditionReset();
        	}
        }
//        if(!ComChkObjValid(oForm.bl_no) || !ComChkObjValid(oForm.bkg_no) || !ComChkObjValid(oForm.cntr_no)) {
//            return false;
//        }
        if(ComGetEvent("name") == 'blInfo_obl_rdem_knt' || ComGetEvent("name") == 'blInfo_bl_otr_doc_rcv_cd' || ComGetEvent("name") == 'blInfo_otr_doc_cgor_flg'){
            if( document.getElementById("blInfo_obl_rdem_flg").value =='Y'){
                return;
            }
            
            if( document.getElementById("blInfo_obl_rdem_knt").value >0 || (document.getElementById("blInfo_bl_otr_doc_rcv_cd").selectedIndex > 0 && document.getElementById("blInfo_otr_doc_cgor_flg").value =='Y')){
                document.getElementById("obl_cng_flg").value='Y';
                document.getElementById("do_cng_evnt_cd").value='RB';
            }
        }
    }
    /**
     * event handling when deactivating the form object
     * @return
     */
    function obj_deactivate(){
        var objName=ComGetEvent("name");
        var formObj=document.form;
        if(blLayer.style.visibility == "visible"){
            blLayer.style.visibility="hidden";
        }
        /*****************************************
        switch(objName) {
            case "exp_del_dt":
                ComChkObjValid(event.srcElement);
            break;
        }
        *****************************************/
    }
    function obj_focus(){
        var objName=ComGetEvent("name");
        var formObj=document.form;
        switch(objName) {
        }
    }
    /************************************************************************************
    handling event screen end
    ************************************************************************************/
    /**
     * deactivating button of screen
     */
    function buttonDisabledAll(){
        ComBtnDisable("btn_Save");
        ComBtnDisable("btn_assign");
        ComBtnDisable("btn_release");
        ComBtnDisable("btn_Hold");
        ComBtnDisable("btn_History");
        ComBtnDisable("btn_cancel");
        ComBtnDisable("btn_remark");
        ComBtnDisable("btn_msnbonded");
        ComBtnDisable("btn_attorney");
      //ComBtnDisable("btn_edoinquiry");   //ED/O Inquiry
        ComBtnDisable("btn_edotransmit");  //ED/O Transmit
        ComBtnDisable("btn_edoresult");    //E-D/O Result
        ComBtnDisable("btn_demdet");       //DEM.DETretrieve
        ComBtnDisable("btn_stcancel");     //S/T Cancel
        ComBtnDisable("btn_edisend");      //EDI Send
        ComBtnDisable("btn_obl_cancel");   //RCV Canceld
        ComBtnDisable("btn_dem_retrieve"); //DMDT
        ComBtnDisable("btn_dmdt");         //em retrieve
        ComBtnDisable("btn_preview");      //Preview
        ComBtnDisable("btn_print");        //Print
        ComBtnDisable("btn_bl_preview");    //BLPreview
        ComBtnDisable("btn_receiverinfo"); //Receiver Info
        document.getElementById("selfTransToTMN").disabled=true;
        document.getElementById("btn_tpb").style.visibility="hidden";
    }
    /**
     * initializing all data except retrieve condition
     */
    function inputParamReset(){
        for(var i=0; i<document.form.getElementsByTagName("input").length; i++) {
            if ( document.form.getElementsByTagName("input")[i].name != "bl_no"   &&
                 document.form.getElementsByTagName("input")[i].name != "cntr_no" &&
                 document.form.getElementsByTagName("input")[i].name != "bkg_no"
                ){
                    document.form.getElementsByTagName("input")[i].value="";
                }
        }
        //initializing sheet
        var resetSheetNames=new Array("blInfo", "doRlseSts", "demInfo", "demDtl", "totBlbAmt");
        for(var idx=0; idx < resetSheetNames.length; idx++){
            sheetObjects[sheetNames[idx]].RemoveAll();
        }
        document.getElementById("blInfo_inter_rmk").value="";
        document.getElementById("blInfo_obl_iss_rmk").value="";
        document.getElementById("blInfo_otr_doc_cgor_flg").value='';
        document.getElementById("blInfo_bl_otr_doc_rcv_cd").value='';
        document.getElementById("tot_ots_amt").value='';
        document.getElementById("tot_bil_amt").value='';
        display_init();
//        document.getElementById("refInfo_inter_rmk").value="";
//        document.getElementById("blIss_otr_doc_cgor_flg").value='';
//        document.getElementById("blIss_bl_otr_doc_rcv_cd").value='';
//        document.getElementById("blIss_ibd_doc_rcv_flg").value='';
//        document.getElementById("tot_ots_amt").value='';
//        document.getElementById("tot_bil_amt").value='';
    }
    /**
     * initializing screen factor
     */
    function display_init(){
        document.getElementsByName("edo_rqst_sts")[0].checked=false;
        document.getElementsByName("edo_rqst_sts")[1].checked=false;
        document.getElementsByName("edo_rqst_sts")[2].checked=false;
        //initializing Demurrage Type
        document.getElementById("demur_type").value="";
        //Hold / Internal Remark(s
        document.getElementById("blInfo_inter_rmk").value="";
        document.getElementById("blInfo_otr_doc_cgor_flg").value='';
        document.getElementById("blInfo_bl_otr_doc_rcv_cd").value='';
        document.getElementById("selfTransToTMN").checked=false;
    }
     /**
      * setting sheet initial values and header
      * @param sheetObj
      * @param sheetNo
      * @return
      */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        var sheetID=sheetObj.id;
        switch(sheetID) {
            case "blInfo":
                with(sheetObj){
		              var HeadTitle="|POR|POL|POD|DEL|DELTerm|DELTerm Desc|ArrivalVessel|ETA|PKG1|PKG2|WGT1|WGT2|MEA1|MEA2|Partial|SOC|Consignee Nm|Consignee Addr|Notify Nm|Notify Addr|Shipper Nm|Shipper Addr|Split_flg|BKG NO|BL NO|DSCH_LOC|OBL_ISS_RMK"
		              + "|INTER_RMK|DO_HLD_FLG"
		              + "|BL회수여부|BL발행통수|OFFICE|DATE|O/BL RECEIVED|OFFICE|DATE|OTHER DOC RECEIVE|OFFICE|DATE|OTR DOC CGOR FLG|OBL_ISS_USR_ID |OBL_RDEM_USR_ID|OTR_DOC_RCV_USR_ID|BL_TP_CD"
		              + "|MRN|MSN|ENTRY TYPE| |Warehouse Cd|Warehouse|Discharging CY| DISC_LOC_CD"
		              + "|TOT_OTS_STS_CD|TOT_OTS_CURR_CD1|TOT_OTS_CURR_CD2|TOT_OTS_CURR_CD3|TOT_OTS_CURR_CD4|TOT_OTS_CURR_CD5|TOT_OTS_AMT1|TOT_OTS_AMT2|TOT_OTS_AMT3|TOT_OTS_AMT4|TOT_OTS_AMT5|PPT_STS_CD|PPT_RCV_OFC_CD|PPT_RCV_USR_ID|PPT_RCV_DT|CCT_STS_CD|CCT_RCV_OFC_CD|CCT_RCV_USR_ID|CCT_RCV_DT|CCT_OTS_CURR_CD1|CCT_OTS_CURR_CD2|CCT_OTS_CURR_CD3|CCT_OTS_CURR_CD4|CCT_OTS_CURR_CD5|CCT_OTS_AMT1|CCT_OTS_AMT2|CCT_OTS_AMT3|CCT_OTS_AMT4|CCT_OTS_AMT5|N3PTY_PPT_STS_CD|N3PTY_PPT_RCV_OFC_CD|N3PTY_PPT_RCV_USR_ID|N3PTY_PPT_RCV_DT|N3PTY_CCT_STS_CD|N3PTY_CCT_RCV_OFC_CD|N3PTY_CCT_RCV_USR_ID|N3PTY_CCT_RCV_DT|N3PTY_CCT_OTS_CURR_CD1|N3PTY_CCT_OTS_CURR_CD2|N3PTY_CCT_OTS_CURR_CD3|N3PTY_CCT_OTS_CURR_CD4|N3PTY_CCT_OTS_CURR_CD5|N3PTY_CCT_OTS_AMT1|N3PTY_CCT_OTS_AMT2|N3PTY_CCT_OTS_AMT3|N3PTY_CCT_OTS_AMT4|N3PTY_CCT_OTS_AMT5"
		              + "|SEQ"
		              + "|DO|SELF|BONDED|DO_EDO_ACK_CD|SELF_EDO_ACK_CD|BONDED_EDO_ACK_CD|EDO_RQST_NO|EDORQSTSEQ5JN|EDORQSTSEQ5JM|EDORQSTSEQ5JK|MS_PTY_RGST_NO|ATTORNEY_VAL_CHK |ERR_FLG|lcloblissueflg||||";
		              blInfoHeadCount=ComCountHeadTitle(HeadTitle);
		              (blInfoHeadCount, 0, 0, true);
		              var prefix="blInfo_";
		
		              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		
		              var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Status",    Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"por_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pol_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pod_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"del_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"de_term_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"de_term_desc",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"arrival_vessel",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"vps_eta_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pck_qty",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pck_tp_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"act_wgt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"wgt_ut_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"meas_qty",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"meas_ut_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_prt_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"soc_flg",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ccust_nm",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ccust_addr",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ncust_nm",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ncust_addr",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"scust_nm",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"scust_addr",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"split_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bkg_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_no",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"dsch_loc",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_iss_rmk",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:200,  Align:"Center",  ColMerge:0,   SaveName:prefix+"inter_rmk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"do_hld_flg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_rdem_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_cpy_knt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_iss_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_iss_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_rdem_knt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_rdem_ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_rdem_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_otr_doc_rcv_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"otr_doc_rcv_ofc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"otr_doc_rcv_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"otr_doc_cgor_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_iss_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_rdem_usr_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"otr_doc_rcv_usr_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_tp_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"mf_ref_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"mf_seq_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cstms_clr_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cstms_clr_loc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cstms_clr_wh_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"wh_nm",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"loc_nm",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cstms_dchg_loc_wh_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_sts_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_curr_cd1",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_curr_cd2",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_curr_cd3",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_curr_cd4",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_curr_cd5",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_amt1",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_amt2",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_amt3",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_amt4",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_amt5",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ppt_sts_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ppt_rcv_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ppt_rcv_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ppt_rcv_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_sts_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_rcv_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_rcv_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_rcv_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_curr_cd1",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_curr_cd2",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_curr_cd3",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_curr_cd4",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_curr_cd5",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_amt1",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_amt2",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_amt3",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_amt4",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_amt5",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_ppt_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_ppt_rcv_ofc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_ppt_rcv_usr_id",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_ppt_rcv_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_rcv_ofc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_rcv_usr_id",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_rcv_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_curr_cd1", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_curr_cd2", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_curr_cd3", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_curr_cd4", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_curr_cd5", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_amt1",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_amt2",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_amt3",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_amt4",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_amt5",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"Seq" },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"do_issue",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"self_transportation",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bonded_transportation",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"do_edo_ack_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"self_edo_ack_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bonded_edo_ack_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"edo_rqst_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"edo_rqst_seq_5jn",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"edo_rqst_seq_5jm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"edo_rqst_seq_5jk",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ms_pty_rgst_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"attorney_val_chk",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"err_flg",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"lcloblissueflg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibd_doc_rcv_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibd_doc_rcv_ofc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibd_doc_rcv_usr_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibd_doc_rcv_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 }];
		               
		              InitColumns(cols);
		              sheetObj.SetVisible(false);
		              SetEditable(0);
            
                    }


            break;
            case "doRlseSts":
                with(sheetObj){
              
	              var HeadTitle=" |Status|Status|D/O No.|Update Time|User ID|User Name|Office|BKG NO |RLSE SEQ|RLSE STS SEQ|DO NO SPLIT|SELF_TRNS_FLG";
	              var headCount=ComCountHeadTitle(HeadTitle);
	              (headCount, 0, 0, true);
	              var prefix="doRlseSts_";
	
	              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	
	              var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
	              var headers = [ { Text:HeadTitle, Align:"Center"} ];
	              InitHeaders(headers, info);
	
	              var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
                     {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:0,   SaveName:prefix+"rlse_sts_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0, Width:150,  Align:"Center",  ColMerge:0,   SaveName:prefix+"rlse_sts_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0, Width:150,  Align:"Center",  ColMerge:0,   SaveName:prefix+"do_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0, Width:200,  Align:"Center",  ColMerge:0,   SaveName:prefix+"evnt_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0, Width:150,  Align:"Center",  ColMerge:0,   SaveName:prefix+"evnt_usr_id",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0, Width:150,  Align:"Center",  ColMerge:0,   SaveName:prefix+"upd_usr_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"evnt_ofc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"bkg_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"rlse_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"rlse_sts_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"do_no_split",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"self_trns_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
               
	              InitColumns(cols);
	              SetSheetHeight(150);
              SetEditable(1);
                    }
            break;
            case "demInfo":
                with(sheetObj){
	              var HeadTitle=" |Seq\n|Container No.|F/T\nOver|Billable\nAmount|Billable\nAmount|Estimate\nFree Time|SAT\nExcl|SUN\nExcl|HOLI\nExcl|Estimate\nPOD LFD|Daily\nDemurrage|Fixed\nFree Time|Fixed\nPOD LFD";
	              (ComCountHeadTitle(HeadTitle), 0, 0, true);
	              var prefix="demInfo_";
	
	              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	              var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
	              var headers = [ { Text:HeadTitle, Align:"Center"} ];
	              InitHeaders(headers, info);
	
	              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
                     {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Seq" },
                     {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"fx_ft_ovr_dys", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"curr_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:prefix+"bil_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ft_dys",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"CheckBox",  Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"xcld_sat_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N" },
                     {Type:"CheckBox",  Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"xcld_sun_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N" },
                     {Type:"CheckBox",  Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"xcld_hol_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N" },
                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_rt_amt",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ft_dys_calc",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ft_end_dt",     KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
               
              InitColumns(cols);
              SetSheetHeight(150);
              SetEditable(0);
         
                    }


            break;
            case "demDtl":
                /****************************************************************
                //Demurrage each container
                *****************************************************************/
                with(sheetObj){
               
              var HeadTitle=" |Invoicing|Settled|DEMCMNC|PaidUpto|Paid Amount|Paid Amount|CNTR_NO|BIL_AMT";
              (ComCountHeadTitle(HeadTitle), 0, 0, true);
              var prefix="demDtl_";

              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

              var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
              var headers = [ { Text:HeadTitle, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
                     {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"dmdt_inv_sts_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"dmdt_ar_if_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ft_end_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"to_mvmt_dt",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"inv_curr_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bil_amt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:0,   SaveName:prefix+"inv_chg_amt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
               
              InitColumns(cols);
              SetSheetHeight(110);
              SetEditable(0);
             
                    }


            break;
            case "totBlbAmt":
                /****************************************************************
                //Total Billable Amount
                *****************************************************************/
                with(sheetObj){
                
		              var HeadTitle1="|curr_cd|tot_bil_amt";
		              var headCount=ComCountHeadTitle(HeadTitle1);
		              (headCount, 0, 0, true);
		              prefix="totBlbAmt_";
		
		              SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:1 } );
		
		              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
		                     {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"curr_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"tot_bil_amt", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
		               
		              InitColumns(cols);
		              SetEditable(1);
		              SetVisible(false);
            
                }
            break;
            case "partial":
                /****************************************************************
                //retrieve partial container info
                *****************************************************************/
                with(sheetObj){
               
              var HeadTitle1="|SEQ||B/L NO.|CNEE NAME|BKG No|BL_TP_CD";
              var headCount=ComCountHeadTitle(HeadTitle1);
              (headCount, 0, 0, true);
              prefix="partial_";

              SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:1 } );

              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
                     {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"Seq" },
                     {Type:"Radio",     Hidden:0, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"radio",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"cstms_desc", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"bkg_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
               
              InitColumns(cols);
              sheetObj.SetVisible(false);
              SetEditable(1);
            
                    }


            break;
        }
    }
    // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
        switch(sAction) {
            case IBSEARCH: //retrieve
                if(!validateForm(sheetObj,formObj,sAction)){
                	return;
                }
                    //initializing parameter
                    inputParamReset();
                    //setting button
                    buttonDisabledAll();
                    formObj.f_cmd.value=SEARCH;
                    var temp_bl=formObj.bl_no.value;
                    var temp_bkg=formObj.bkg_no.value;
                    ComOpenWait(true);
                    formObj.bl_no.value=temp_bl;
                    formObj.bkg_no.value=temp_bkg;
                    //if BL_TP_CD is W or S, remove BL_TP_CD
                    if(formObj.bl_no.value !=''){
                        var blNo=formObj.bl_no.value;
                        var suffix=blNo.substring(formObj.bl_no.value.length-1)
                        if(suffix =='W' || suffix =='S'){
                            formObj.bl_no.value=blNo.substring(0, blNo.lastIndexOf(suffix));
                        }
                    }
                    
                    //@ 조회 후 세팅시 bkg_no bl_no conditionReset발생 안하게 하기 위함 
                    onchangeFlag = false;
                    
                    setTimeout( function () { //@ setTimeout ###########################################################
                    	
		                    //multiple retrieve
		                    var aryPrefix=new Array("blInfo_", "doRlseSts_", "demInfo_", "demDtl_",  "totBlbAmt_"); //prefix 문자열 배열
		                    //parameter changed[check again]CLT                     
		                    var sXml=sheetObjects["blInfo"].GetSearchData("ESM_BKG_0682GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
		                    var arrXml=sXml.split("|$$|");
		                    if(undefined != ComGetEtcData(arrXml[0], "demurType")){
		                        document.getElementById("demur_type").value=ComGetEtcData(arrXml[0], "demurType");
		                    }
		                    if(undefined != ComGetEtcData(arrXml[0], "tpbStatus") && ComGetEtcData(arrXml[0], "tpbStatus") != 'null'){
		                        document.getElementById("tpb_status").value=ComGetEtcData(arrXml[0], "tpbStatus");
		                    }
		                    if(undefined != ComGetEtcData(arrXml[0], "mrdId") && ComGetEtcData(arrXml[0], "mrdId") != 'null'){
		                        var mrdId=ComGetEtcData(arrXml[0], "mrdId");
		                        var arrMrd=mrdId.split("@@");
		                        document.getElementById("mrd_id").value=arrMrd[0];
		                        if(undefined != arrMrd[1] && arrMrd[1] != 'null'){
		                            document.getElementById("mrd_param").value=arrMrd[1];
		                        }
		                    }
		                    for(var idx=0; idx < arrXml.length; idx++){
		                        if(idx > 0) {
		                            sheetObjects[sheetNames[idx]].SetWaitImageVisible(0);
		                        }
		                        sheetObjects[sheetNames[idx]].LoadSearchData(arrXml[idx],{Sync:1} );
		                    }
		                    
		                  //@ 조회 후 세팅시 bkg_no bl_no conditionReset발생 안하게 하기 위함 
		                    onchangeFlag = true;
		                    
		                    //@releaseRemarkFlag 초기화 한다. 
		                    releaseRemarkFlag = false;
		                    
                   } , 100);//@ setTimeout end ###########################################################
            break;
            case COMMAND07: //Dem retrieve
                if(!validateForm(sheetObj,formObj,sAction)){
                	return;
                }
    	        	if(ComIsNull(formObj.bl_no) && ComIsNull(formObj.bkg_no)){
    	                ComShowCodeMessage('BKG01072'); 
    	                ComSetFocus(formObj.bl_no)
    	                return false;
    	            }
                    //setting button
                    buttonDisabledAll();
                    formObj.f_cmd.value=SEARCH;
                    ComOpenWait(true);
                    
                    setTimeout( function () { //@ setTimeout ###########################################################                    
	                    //multiple retrieve
	                    var aryPrefix=new Array("blInfo_", "doRlseSts_", "demInfo_", "demDtl_",  "totBlbAmt_"); //prefix 문자열 배열
	                    //parameter changed[check again]CLT                     
	                    var sXml=sheetObjects["blInfo"].GetSearchData("ESM_BKG_0682GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
	                    var arrXml=sXml.split("|$$|");
	                    if(undefined != ComGetEtcData(arrXml[0], "demurType")){
	                        document.getElementById("demur_type").value=ComGetEtcData(arrXml[0], "demurType");
	                    }
	                    for(var idx=0; idx < arrXml.length; idx++){
	                        if(idx > 0) {
	                            sheetObjects[sheetNames[idx]].SetWaitImageVisible(0);
	                        }
	                        sheetObjects[sheetNames[idx]].LoadSearchData(arrXml[idx],{Sync:1});
	                    }
        		} , 100);//@ setTimeout end ###########################################################
            break;
            case IBSAVE:   
                if(!validateForm(sheetObj, formObj, sAction)){
                	return;
                }
                
    	        	if(ComIsNull(formObj.bl_no) && ComIsNull(formObj.bkg_no)){
    	                ComShowCodeMessage('BKG01072'); 
    	                ComSetFocus(formObj.bl_no)
    	                return false;
    	            }
                    formObj.f_cmd.value=MODIFY;
                    CopyFormToRow(formObj, sheetObjects["blInfo"], 1, "");
                    var midifyCnt=0; 
                    for(var i=1; i < blInfoHeadCount; i++){
                        saveName=sheetObjects["blInfo"].ColSaveName(i);
                        idx=sheetObjects["blInfo"].SaveNameCol(saveName);
                        if(saveName =='blInfo_ncust_nm' || saveName =='blInfo_ncust_addr' || saveName == 'blInfo_Seq'){
                            continue;
                        }
                        var OrgValue=sheetObjects["blInfo"].CellSearchValue(1,idx);
                        if (OrgValue != sheetObjects["blInfo"].GetCellValue(1,idx)){
                              midifyCnt ++;
                        }
                    }
                    if(midifyCnt == 0){
                        ComShowCodeMessage('BKG00797');
                        return false;
                    }
                    var sParam1=sheetObjects["blInfo"].GetSaveString(true);
                    if( !ComShowCodeConfirm('COM12147' , 'data' ) ){
                        return false;
                    }
                    var aryPrefix=new Array("blInfo_");
                    var sparam=sParam1 + "&" + sParam2 + "&" + FormQueryString(formObj)+ "&" + ComGetPrefixParam(aryPrefix);
                    	sparam += "&bkg_no="+sheetObjects["blInfo"].GetCellValue(1,"blInfo_bkg_no");
                    	//parameter changed[check again]CLT                     
                    	var sXml=sheetObj.GetSaveData("ESM_BKG_0682GS.do", sparam);
                    	//parameter changed[check again]CLT                     
                    	sheetObjects["blInfo"].LoadSaveData(sXml);
                    sXml=ComDeleteMsg(sXml);   
            break;
            case MULTI04:// Assign
	        	if(ComIsNull(formObj.bl_no) && ComIsNull(formObj.bkg_no)){
	                ComShowCodeMessage('BKG01072'); 
	                ComSetFocus(formObj.bl_no)
	                return false;
	            }
                //Not proceed Release, if Original Bill of Lading Status is N
                //if(document.getElementById("blIss_obl_rdem_flg").value =='N'){
                //    ComShowCodeMessage('BKG40066');
                //    return;
                //}
                if(document.getElementById("evnt_flag").value == 'R'){
                	ComShowCodeMessage('BKG40107', sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no"), "Assign");
                    return;
                }
                //Are you sure to Assign?
                if(!ComShowCodeConfirm('BKG00672')){
                    return false;
                }
                formObj.f_cmd.value=MULTI04;
                var aryPrefix=new Array("blInfo_"); //prefix array of strings
                var sParam1=sheetObjects["blInfo"].GetSaveString(true);
                var sparam=sParam1 + "&" + FormQueryString(formObj)+ "&" + ComGetPrefixParam(aryPrefix);
                //parameter changed[check again]CLT                 
                var sXml=sheetObj.GetSaveData("ESM_BKG_0682GS.do", sparam);
                //parameter changed[check again]CLT                 
                sheetObjects["blInfo"].LoadSaveData(sXml);
                sXml=ComDeleteMsg(sXml);   
            break;
            case MULTI05:// Cancel
	        	//checking whether the retrieve condition changes
	        	if(ComIsNull(formObj.bl_no) && ComIsNull(formObj.bkg_no)){
	                ComShowCodeMessage('BKG01072'); 
	                ComSetFocus(formObj.bl_no)
	                return false;
	            }
                if(document.getElementById("evnt_flag").value == 'R'){
                	ComShowCodeMessage('BKG40107', sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no"), "D/O Cancel");
                    return;
                }
               //Not proceed, if MRN and MSN information is not reported
//               if(document.form.blInfo_mf_ref_no.value =='' || document.form.blInfo_mf_ref_no.value ==null){
//                   ComShowCodeMessage('BKG40062');
//                  return;
//               }    
                //Are you sure to Cancel?
                if(!ComShowCodeConfirm('BKG00670')){
                    return false;
                }
                var selfTrnsFlg='N';
                if(document.getElementById("selfTransToTMN").checked){
                    selfTrnsFlg='Y'
                }else{
                    selfTrnsFlg='N'
                }
                document.getElementById("self_trns_flg").value=selfTrnsFlg;
                formObj.f_cmd.value=MULTI05;
                sheetObjects["doRlseSts"].SetRowStatus(1,"U");
                sheetObj.DoSave("ESM_BKG_0682GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("doRlseSts_"),-1,false);
            break;
            case MULTI06:// Release
	        	//checking whether the retrieve condition changes
	        	if(ComIsNull(formObj.bl_no) && ComIsNull(formObj.bkg_no)){
	                ComShowCodeMessage('BKG01072'); 
	                ComSetFocus(formObj.bl_no)
	                return false;
	            }
            	//Not proceed Release, if Original Bill of Lading Status is N
//                if(document.form.blInfo_mf_ref_no.value =='' || document.form.blInfo_mf_seq_no.value ==''){
//                   ComShowCodeMessage('BKG40062');
//                   return;
//                }    
               // in case of invalid request
                if( sheetObjects["blInfo"].GetCellValue(1, "blInfo_edo_rqst_no") !="" ){
                	if( sheetObjects["blInfo"].GetCellValue(1, "blInfo_edo_rqst_no") != ( document.form.blInfo_mf_ref_no.value
                		                                                             + document.form.blInfo_mf_seq_no.value)  ){
                		ComShowCodeMessage("BKG43044");  
                		return;
                	}
                }
                if(document.getElementById("blInfo_obl_rdem_flg").value =='N'){
                    ComShowCodeMessage('BKG40066');
                    return;
                }
                if(document.getElementById("evnt_flag").value == 'R'){
                	ComShowCodeMessage('BKG40107', sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no"), "Release");
                    return;
                }
                var partial=document.getElementById("blInfo_cntr_prt_flg").value
                if(sheetObjects["doRlseSts"].RowCount()== 1 && sheetObjects["doRlseSts"].GetCellValue(1, "doRlseSts_rlse_sts_cd") == 'C'){
                    document.getElementById("rlse_sts_cd").value='';
                }

            	//GAP Display Credit Risk (2014.10.14 An Jin Eung)
            	if(!fnExistBlackListedCustomer(formObj.bkg_no.value)){
//                    return false;
                }	
            	
                //Freight Received Status Y가 아니면 Remark for Release를 로 남겨야 한다.
				if(document.getElementById("blInfo_tot_ots_sts_cd").value =='N'){
                    if(!remarkForReleasePop()){
                        return false;
                    }
                }
				
                //Are you sure to Release?
                if(!ComShowCodeConfirm('BKG00673')){
                    return false;
                }
                document.getElementById("self_trns_flg").value=document.getElementById("selfTransToTMN").checked ? 'Y' : 'N';
                formObj.f_cmd.value=MULTI06;
                var aryPrefix=new Array("blInfo_", "doRlseSts_");    //prefix array of strings
                var sParam1=sheetObjects["blInfo"].GetSaveString(true);
                var sParam2=sheetObjects["doRlseSts"].GetSaveString(true);
                var sparam=sParam1 + "&" + sParam2 + "&" + FormQueryString(formObj)+ "&" + ComGetPrefixParam(aryPrefix);
                //parameter changed[check again]CLT                 
                var sXml=sheetObj.GetSaveData("ESM_BKG_0682GS.do", sparam);
                //parameter changed[check again]CLT                 
                sheetObjects["blInfo"].LoadSaveData(sXml);
                sXml=ComDeleteMsg(sXml);  
            break;
            case MULTI07:// Hold
	        	//checking whether the retrieve condition changes
	        	if(ComIsNull(formObj.bl_no) && ComIsNull(formObj.bkg_no)){
	                ComShowCodeMessage('BKG01072'); 
	                ComSetFocus(formObj.bl_no)
	                return false;
	            }
            	if(document.getElementById("evnt_flag").value =='H'){
                    //Are you sure to Hold?
                    if(!ComShowCodeConfirm('BKG00671')){
                        return false;
                    }
                }
                formObj.f_cmd.value=MULTI07;
                var aryPrefix=new Array("blInfo_");    //prefix array of strings
                var sParam1=sheetObjects["blInfo"].GetSaveString(true);
                var sparam=sParam1 + "&" + FormQueryString(formObj)+ "&" + ComGetPrefixParam(aryPrefix);
                //parameter changed[check again]CLT                 
                var sXml=sheetObj.GetSaveData("ESM_BKG_0682GS.do", sparam);
                //parameter changed[check again]CLT                 
                sheetObjects["blInfo"].LoadSaveData(sXml);
                sXml=ComDeleteMsg(sXml);
            break;
            case MULTI08:// S/T Cancel or EDI Send
	        	//checking whether the retrieve condition changes
	        	if(ComIsNull(formObj.bl_no) && ComIsNull(formObj.bkg_no)){
	                ComShowCodeMessage('BKG01072'); 
	                ComSetFocus(formObj.bl_no)
	                return false;
	            }
                formObj.f_cmd.value=MULTI08;
                document.getElementById("self_trns_flg").value=document.getElementById("selfTransToTMN").checked ? 'Y' : 'N';
                var aryPrefix=new Array("blInfo_");    //prefix array of strings
                var sParam1=sheetObjects["blInfo"].GetSaveString(true);
                var sparam=sParam1 + "&" + FormQueryString(formObj)+ "&" + ComGetPrefixParam(aryPrefix);
                //parameter changed[check again]CLT                
                var sXml=sheetObj.GetSaveData("ESM_BKG_0682GS.do", sparam);
                //parameter changed[check again]CLT                 
                sheetObjects["blInfo"].LoadSaveData(sXml);
                sXml=ComDeleteMsg(sXml); 
            break;
        }
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj, formObj, sAction){
        var oForm=document.form;
        if(sAction ==IBSAVE){
             if(document.getElementById("blInfo_obl_cpy_knt").value < parseInt(document.getElementById("blInfo_obl_rdem_knt").value)){
                //The number of B/L Received you inputted is bigger than B/Ls released in B/L Issue Screen.\nYou have input the number in Received field less or the same number of B/L Released.
                ComShowCodeMessage('BKG40065');
                 document.getElementById("blInfo_obl_rdem_knt").focus();
                return false;
            }
        }else if(sAction ==IBSEARCH){
            conditionTrim();
            if(ComIsNull(oForm.bl_no) && ComIsNull(oForm.bkg_no)){
                ComShowCodeMessage('BKG40097');
                ComSetFocus(oForm.bl_no)
                return false;
            }
            if(!ComChkObjValid(oForm.bl_no) || !ComChkObjValid(oForm.bkg_no) || !ComChkObjValid(oForm.cntr_no)) {
                return false;
            }
        //DEM.DET Retrieve
        }else if(sAction == COMMAND07){
            var toDay=ComGetNowInfo('ymd','-').replace(eval("/-/gi"), "");
            var expDelDt=formObj.exp_del_dt.value.replace(eval("/-/gi"), "");
            if(toDay > expDelDt){
                ComShowCodeMessage('BKG40114', expDelDt);
                return false;
            }
        }
        return true;
    }
    /**************************************************************
        TRIC SELECT BOX CODE START
    **************************************************************/
    /**
     * HTML Control deactivate event handling <br>
     */
    function showHideLayers() {
        var el=ComGetEvent();
        if(el.tagName.toLowerCase() !='input'){
            return;
        }
        if(blLayer.style.visibility == "visible"){
            blLayer.style.visibility="hidden";
        }else{
            var rect=el.getBoundingClientRect();
            $('#blLayer').css('top', (rect.top + 25) + 'px')
                         .css('left', rect.left + 'px')
                         .css('border-color',rgbToHex($(el).css('borderTopColor')))
                         .css('width', (rect.width - 2) + 'px');

            blLayer.style.visibility="visible";
        }
    }
    
    /**
     * Convert rgb color to hex
     * @param val - rgb(r, g, b)
     */
    function rgbToHex(rgbString) {
    	var parts = rgbString.match(/^rgb\((\d+),\s*(\d+),\s*(\d+)\)$/);
    	delete(parts[0]);
    	for (var i = 1; i <= 3; ++i) {
    	    parts[i] = parseInt(parts[i]).toString(16);
    	    if (parts[i].length == 1) parts[i] = '0' + parts[i];
    	} 
    	return '#' + parts.join('').toUpperCase();
    }
    
    /**
     * draw TRiC SELECT BOX
     */
  
    function conditionSet(aryPopupData){
	   	
		if(aryPopupData != undefined){
            document.getElementById("bl_no").value  = aryPopupData[0][3]+aryPopupData[0][6];
            document.getElementById("bkg_no").value = aryPopupData[0][5];
        }
		
		$("#blLayer").empty();
		
        for (idx=1; idx<=sheetObjects["partial"].RowCount(); idx++) {
            if(document.getElementById("bl_no").value == sheetObjects["partial"].GetCellValue(idx, "partial_"+"bl_no")){
                $("#blLayer").append("<table><tr><td><input  type='text' name='hdn_bl_no' id='hdn_bl_no' class='input'  value='"+sheetObjects["partial"].GetCellValue(idx, "partial_bl_no")+' '+sheetObjects["partial"].GetCellValue(idx, "partial_bl_tp_cd")+"' readonly style='border:0; height:15;background-color:rgb(49,106,197);COLOR:#FFFFFF' onmouseover='blNoSelect("+idx+");' onclick='blNoSelect("+idx+")'></td></tr></table>");
            }else{
            	$("#blLayer").append("<table><tr><td><input type='text' name='hdn_bl_no' id='hdn_bl_no'  class='input' value='"+sheetObjects["partial"].GetCellValue(idx, "partial_bl_no")+' '+sheetObjects["partial"].GetCellValue(idx, "partial_bl_tp_cd")+"' readonly style='border:0; height:15;' onmouseover='blNoSelect("+idx+");' onclick='blNoSelect("+idx+")'></td></tr></table>");
            }
        }
        ComSetFocus(document.form.bl_no);
    }
    
    /**
     * Rd Print setting
     */
    function initRdConfig(rdObject) {
    	var Rdviewer=rdObject;
    	Rdviewer.AutoAdjust=true;
    	Rdviewer.ViewShowMode(0);
    	Rdviewer.IsShowDlg=0;
    	Rdviewer.SetBackgroundColor(128, 128, 128);
    	Rdviewer.ApplyLicense("0.0.0.0");
    	Rdviewer.SetPageLineColor(128, 128, 128);
    	Rdviewer.style.height = 0;
       
    } 
    /**
     * setting O/BL Received input
     */
    function obl_rdem_knt_change(sheetObj, obj){
        var sheetObj=sheetObj;
        if (sheetObj.LastRow()== 0 ) {return;}
        var blTpCd=sheetObj.GetCellValue(1, "blInfo_bl_tp_cd");
        var oblRedmFlg=sheetObj.GetCellValue(1, "blInfo_obl_rdem_flg");
        //var delCntCd   = sheetObj.CellValue(1, "blInfo_del_cnt_cd");
        if (blTpCd == "S" || blTpCd == "W") {
            // Way Bill and Surrendered can't OB/L Cancel
            ComBtnDisable("btn_obl_cancel");
            document.getElementById("blInfo_obl_rdem_knt").disabled=true;
            document.getElementById("blInfo_bl_otr_doc_rcv_cd").disabled=true;
            document.getElementById("blInfo_otr_doc_cgor_flg").disabled=true;
        } else if (document.form.blInfo_obl_rdem_flg.value == "Y") {
            ComBtnEnable("btn_obl_cancel");
            document.getElementById("blInfo_obl_rdem_knt").disabled=false;
            document.getElementById("blInfo_bl_otr_doc_rcv_cd").disabled=true;
            document.getElementById("blInfo_otr_doc_cgor_flg").disabled=true;
        } else {
            ComBtnDisable("btn_obl_cancel");
            document.getElementById("blInfo_obl_rdem_knt").disabled=false;
            document.getElementById("blInfo_bl_otr_doc_rcv_cd").disabled=false;            
            document.getElementById("blInfo_otr_doc_cgor_flg").disabled=false;
        }
    }
    //getting information from ERP consists of Select Box.
    function addSel(sheetObj) {
        var sel=document.form.tot_ots_amt;
        var prefix="blInfo_";
        for (i=sel.length-1; i>=0; i--){
            sel.options[i]=null
        }
        if(sheetObj.GetCellValue(1, prefix+"tot_ots_sts_cd")=='Y' || sheetObj.GetCellValue(1, prefix+"tot_ots_sts_cd")=='C'){
            // btn_cct disable
            document.getElementById("btn_cct").style.visibility="hidden";
            document.getElementById("btn_third_cct").style.visibility="hidden";
        } else if(sheetObj.GetCellValue(1, prefix+"tot_ots_sts_cd")=='N'){
            // btn_cct, div_btn_third_cct visible
        	if (sheetObj.GetCellValue(1, prefix+"cct_ots_curr_cd1") == "N") {
              document.getElementById("btn_cct").style.visibility="visible";
            }else {
              document.getElementById("btn_cct").style.visibility="hidden";
            }
        	if (sheetObj.GetCellValue(1, prefix+"n3pty_cct_ots_curr_cd1") == "N") {
              document.getElementById("btn_third_cct").style.visibility="visible";
            } else {
              document.getElementById("btn_third_cct").style.visibility="hidden";
            }
        } else {
        	document.form['tot_ots_amt'][0]=new Option(sheetObj.GetCellValue(1, prefix+"tot_ots_amt1"));
			document.getElementById("tot_ots_amt").className="input2_1";
            // btn_cct disable
            document.getElementById("btn_cct").style.visibility="hidden";
            document.getElementById("btn_third_cct").style.visibility="hidden";
            return;
        }
        var unit="";
        var amount="";
        var colorFlg="";
        for (j=0; j<5; j++){
        	unit=sheetObj.GetCellValue(1, "blInfo_"+"tot_ots_curr_cd"+parseInt(j+1));
        	amount=sheetObj.GetCellValue(1, "blInfo_"+"tot_ots_amt"+parseInt(j+1));
            if(! ComIsEmpty(unit)){
            	if (amount > 0) {
            		colorFlg="Y";
            	}
            	document.form['tot_ots_amt'][j]=new Option(unit+' '+ComAddCommaRun(amount), j);                
            }
        }
        if (colorFlg == "Y") {
        	//font color is red and bold
        	document.getElementById("tot_ots_amt").className="input2_1";
        } else {
        	document.getElementById("tot_ots_amt").className="input2";
        }
    }
    /**
     * calling History popup <br>
     */
    function go_history(){
        //open Window
        var condition="?";
        condition += "bkg_no="+sheetObjects["blInfo"].GetCellValue(1, "blInfo_bkg_no");
        condition += "&bl_no="+sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no");
            condition += "&pgmNo=ESM_BKG_0711";
        ComOpenWindowCenter('/opuscntr/ESM_BKG_0711.do'+condition, 'history', 930, 500, false);    
    }
    /**
     * calling Form Setting popup <br>
     */
    function go_formSetting(){
        var condition="?";
            condition += "pgmNo=ESM_BKG_0137";
            condition += "&office="+lginOfcCd;
        ComOpenWindowCenter('/opuscntr/ESM_BKG_0137_POP.do'+condition, 'setting', 1024, 510, false);
    }
    /**
     * calling Receiver Info popup <br>
     */
    function go_receiver(){
    	var doNo=sheetObjects["doRlseSts"].GetCellValue(1, "doRlseSts_do_no");
        //setting initial value to DO No in case of clicking button without retrieve
        if(doNo == undefined){
            doNo='';
        }
        var condition="?";
            condition += "do_no="+doNo;
            condition += "&pgmNo=ESM_BKG_0130";
        ComOpenWindowCenter('/opuscntr/ESM_BKG_0130.do'+condition, 'receiver', 530, 200, false);
    }
    /**
     * calling Remark popup <br>
     */
    function go_remark(){
        var condition="?";
            condition += "do_no="+document.getElementById("h_do_no").value;
            condition += "&pgmNo=ESM_BKG_1018";
        ComOpenWindowCenter('/opuscntr/ESM_BKG_1018.do'+condition, 'remark', 530, 230, false);
    }
    /**
     * calling Dmdt <br>
     */
    function go_dmdt(){
    	var bkgNo=sheetObjects["blInfo"].GetCellValue(1, "blInfo_bkg_no");
    	var blNo=sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no");
        var trfCd=document.getElementById("demur_type").value;
        var paramVal="?call_flag=P&bkg_no=" + bkgNo + "&bl_no=" + blNo + "&dmdt_trf_cd=" + trfCd + "&pgmNo=EES_DMT_3002P";
        paramVal += "&pgmNo=EES_DMT_3002P";
        ComOpenWindowCenter('/opuscntr/EES_DMT_3002P.do' + paramVal, 'dmdt', 1248, 710, false);
    }
    /**
     * calling E/DO Inquiry popup <br>
     */
    function go_edoinquiry(){
        var podCd=document.form.blInfo_pod_cd.value;
        var param="?";
            param += "&edo_rct_loc_cd="+podCd;
            param += "&autoSearchFlg=Y";
            param += "&pgmNo=ESM_BKG_0132";
        //open Window
        ComOpenWindowCenter('ESM_BKG_0132_POP.do'+param, 'edoinquiry', 1260, 692, false);
    }
    /**
     * calling MSN & Bonded popup <br>
     */
    function go_msnbonded(){
        var param="?";
        param += "bl_no="+sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no");
            param += "&pgmNo="+"ESM_BKG_0333";
        //open Window
        ComOpenWindowCenter('ESM_BKG_0333_POP.do'+param, 'msnbonded', 1024, 558, false);
    }
    /**
     * calling E/DO Result popup <br>
     */
    function go_edoresult(){
        var param="?";
        param += "bl_no="+sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no");
            param += "&autoSearchFlg=Y";
            param += "&pgmNo=ESM_BKG_0134";
        //open Window
        ComOpenWindowCenter('ESM_BKG_0134_POP.do'+param, 'edoresult', 1260, 620, false);
        
    }
    /**
     * calling E/DO Transmit popup <br>
     */
    function go_edotransmit(){
        var approvals='';
        // Not proceed Release, if MRN information is not reported
//        if(document.form.blInfo_mf_ref_no.value =='' || document.form.blInfo_mf_seq_no.value ==null){
//           ComShowCodeMessage('BKG40062');
//           return;
//        }    
     // in case of invalid request
        if( sheetObjects["blInfo"].GetCellValue(1, "blInfo_edo_rqst_no") != ( document.form.blInfo_mf_ref_no.value
            		                                                     + document.form.blInfo_mf_seq_no.value)  ){
        	ComShowCodeMessage("BKG43044");  
        	return;
        }
        if (document.getElementsByName("edo_rqst_sts")[0].checked == true) {
            approvals += 'T;';
        }else{
            approvals += 'F;';
        }
        if (document.getElementsByName("edo_rqst_sts")[1].checked == true) {
            approvals += 'T;';
        }else{
            approvals += 'F;';
        }
        if (document.getElementsByName("edo_rqst_sts")[2].checked == true) {
            approvals += 'T;';
        }else{
            approvals += 'F;';
        }
        var param="?";
            param += "approvals="+approvals;
            param += "&last_rlse_sts_cd="+document.form.last_rlse_sts_cd.value;
            param += "&bkg_no="+document.form.bkg_no.value ;
            param += "&rqst_no="+document.form.blInfo_mf_ref_no.value+document.form.blInfo_mf_seq_no.value;
            param += "&mrn_no="+document.form.blInfo_mf_ref_no.value;
            param += "&msn_no="+document.form.blInfo_mf_seq_no.value;
            param += "&pod_cd="+document.form.blInfo_pod_cd.value;
            param += "&del_cd="+document.form.blInfo_del_cd.value;
            param += "&de_term_desc="+document.form.blInfo_de_term_desc.value;
            param += "&pgmNo=ESM_BKG_0737";
        //open Window
        //ComOpenWindowCenter('/opuscntr/ESM_BKG_0737.do'+param, "edotransmit", 718, 286, false);
        ComOpenWindowCenter("ESM_BKG_0737.do" + param, "edotransmit", 718, 186, false);
        
    }
    function go_attorney(){
        var param="?";
        param += "cust_biz_no="+sheetObjects["blInfo"].GetCellValue(1, "blInfo_ms_pty_rgst_no");
            param += "&pgmNo=ESM_BKG_0999";
        //open Window
        ComOpenWindowCenter('/opuscntr/ESM_BKG_0999.do'+param, 'attorney', 900, 460, false);
    }
    /**
     * calling Bl No selection popup in case of Container partial<br>
     */
    function blSelectPopOpen(){
        var sXml=IBS_GetDataSearchXml(sheetObjects["partial"]);
        document.form.xmlData.value=sXml;
        ComOpenPopup("/opuscntr/ESM_BKG_0942.do", 500, 300, "conditionSet", "1,0", true);
    }
    /**
     * BKG_NO is set to the value selected in BL_NO SELECT BOX.<br>
     * changing selected value BG color
     */
    function blNoSelect(idx){
    	document.getElementById("bkg_no").value=sheetObjects["partial"].GetCellValue(idx, "partial_"+"bkg_no");
    	document.getElementById("bl_no").value=sheetObjects["partial"].GetCellValue(idx, "partial_"+"bl_no")+sheetObjects["partial"].GetCellValue(idx, "partial_"+"bl_tp_cd");
        var length=document.getElementsByName("hdn_bl_no").length;
        if(document.getElementsByName("hdn_bl_no").length > 1){
            for(var i=1; i<=length; i++){
                if(i==idx){
                    document.all.hdn_bl_no[i-1].style.backgroundColor='rgb(49,106,197)';
                    document.all.hdn_bl_no[i-1].style.color='#FFFFFF';
                }else{
                    document.all.hdn_bl_no[i-1].style.backgroundColor='#FFFFFF';
                    document.all.hdn_bl_no[i-1].style.color='black';
                }
            }
        }
    }
    /**
     * initializing BKG_NO and CNTR_NO in case of typing BL_NO<br>
     */
    function conditionReset(){
        if (ComGetEvent("name") == "bl_no") {
            document.getElementById("bkg_no").value='';
            document.getElementById("blInfo_split_flg").value='';
            document.getElementById("cntr_no").value='';
            document.getElementById("h_cntr_no").value='';
        }else if (ComGetEvent("name") == "bkg_no") {
            document.getElementById("bl_no").value='';
            document.getElementById("cntr_no").value='';
            document.getElementById("h_cntr_no").value='';
        }else if (ComGetEvent("name") == "cntr_no") {
            document.getElementById("bl_no").value='';
            document.getElementById("bkg_no").value='';
            document.getElementById("blInfo_split_flg").value='';
            document.getElementById("h_cntr_no").value='';
        }
        if(ComGetEvent("name") == "bkg_no" ){
            //delete object
            try {
                oTbl.removeNode(true);
            }catch(e){}
        }
    }
    /**
     * remove end space of retrieve condition
     */
    function conditionTrim(){
        document.getElementById("bl_no").value=document.getElementById("bl_no").value.trim();
        document.getElementById("bkg_no").value=document.getElementById("bkg_no").value.trim();
        document.getElementById("cntr_no").value=document.getElementById("cntr_no").value.trim();
    }
    /**
     * automatically clicking Self Trans To TMNL of parents window in case of self transport approved EDI transmission
     */
    function pressSelfTransToTMNL(flag){
        if(flag =='ES'){
            document.getElementById("selfTransToTMN").checked=true;
        }else{
            document.getElementById("selfTransToTMN").checked=false;
        }
    }
    /**
     * setting to color of checkbox depending on the status
     */
    function edoCheckBoxColorSet(str){
        var strArr=str.split(",");
        for(var idx=0; idx < strArr.length; idx++){
            if (strArr[idx]=='A') {//approve,Blue
                if(idx == '0') {
                    document.getElementById("btn_do").style.color='rgb(0,0,255)';
                }
                if(idx == '1') {
                    document.getElementById("btn_self").style.color='rgb(0,0,255)';
                }
                if(idx == '2') {
                    document.getElementById("btn_bonded").style.color='rgb(0,0,255)';
                }
            }
            if (strArr[idx]=='R') { //denial,Red
            	  if(idx == '0') {
                      document.getElementById("btn_do").style.color='rgb(255,0,0)';
                  }
                  if(idx == '1') {
                      document.getElementById("btn_self").style.color='rgb(255,0,0)';
                  }
                  if(idx == '2') {
                      document.getElementById("btn_bonded").style.color='rgb(255,0,0)';
                  }
            }
            if (strArr[idx]=='P') {//hold,Green
            	 if(idx == '0') {
                     document.getElementById("btn_do").style.color='rgb(128,255,0)';
                 }
                 if(idx == '1') {
                     document.getElementById("btn_self").style.color='rgb(128,255,0)';
                 }
                 if(idx == '2') {
                     document.getElementById("btn_bonded").style.color='rgb(128,255,0)';
                 }
             }
        }
    }
    //calling Remark For Release Popup
    //@ Pop Up에서 모달로 값을 받아야 하나 IE처럼 동기화가 되지않고 값을 받기 전에 다음으로 진행되어,
    //@ CallBack 메소드에서 다시 doAction메소드를 호출 시 체크하여 진행여부를 결정하게 한다. 
    var releaseRemarkFlag = false;
    function remarkForReleasePop(){
   	 if(releaseRemarkFlag == false){
	         var condition = "?bkg_no="+sheetObjects["blInfo"].GetCellValue(1, "blInfo_bkg_no");
	         ComOpenPopup("/opuscntr/ESM_BKG_0954.do"+condition, 600, 250, "callBack0954", '0,1,1,1,1,1,1', true);
            return false;
        }
        return true;
    }
    /**
     * Popup Ok Event Handling.<br>
     */
    function callBack0954(result){
   	 if(!ComIsNull(result)){
   		 ComShowCodeMessage("BKG00166"); //Data Saved Successfully!!
       	 document.getElementById("releaseRemark").value=result;
       	 releaseRemarkFlag = true;
       	 
       	 //@ Pop-Up 레이어를 닫기 위해 시간차를 둠
       	 setTimeout( function () { //@ setTimeout ###########################################################
	        	 //Release 함.
	        	 var formObject=document.form;
	        	 doActionIBSheet(sheetObjects["doRlseSts"], formObject, MULTI06);
       	 } , 100);//@ setTimeout end ###########################################################
        }
     }    
    
    //consist of image and setting code value getting information from TPB
    function tpbImgSet(tpbStatus) {
        if(tpbStatus) null ? document.getElementById("tpb_status").value : tpbStatus;
        if(document.getElementById("tpb_status").value == "1"){
            document.getElementById("tpb_icon").src="img/btng_icon_green.gif";
            document.getElementById("tpb_cd").value='C';
            document.getElementById("btn_tpb").style.visibility="visible";
            //tooltip C=Cleared
            document.getElementById("tpb_cd").setAttribute("title", "Cleared");
        }else if(document.getElementById("tpb_status").value == "0"){
            document.getElementById("tpb_icon").src="img/btng_icon_r.gif";
            document.getElementById("tpb_cd").value='P';
            document.getElementById("btn_tpb").style.visibility="visible";
            //tooltip P=Processing
            document.getElementById("tpb_cd").setAttribute("title", "Processing");
        }else{
            document.getElementById("tpb_icon").src="img/btng_icon_g.gif";
            document.getElementById("tpb_cd").value='';
            document.getElementById("btn_tpb").style.visibility="hidden";
            document.getElementById("tpb_cd").removeAttribute("title");
        }
    }
    //initializing OBL value in case of clicking OBL Cancel button
    function oblInit(){
        document.getElementById("blInfo_otr_doc_cgor_flg").value='';
        document.getElementById("blInfo_bl_otr_doc_rcv_cd").value='';
        document.getElementById("blInfo_obl_rdem_knt").value='0';
        document.getElementById("blInfo_obl_rdem_ofc_cd").value='';
        document.getElementById("blInfo_obl_rdem_usr_id").value='';
        document.getElementById("blInfo_obl_rdem_dt").value='';
        document.getElementById("bl_surr_rmk_flg").value='';
        document.getElementById("blInfo_otr_doc_rcv_ofc_cd").value='';
        document.getElementById("blInfo_otr_doc_rcv_usr_id").value='';
        document.getElementById("blInfo_otr_doc_rcv_dt").value='';
        //CR : Cancelled O/BL Received
        document.getElementById("do_cng_evnt_cd").value='CR';
        //Before change value of D/O EVENT
        document.getElementById("pre_ctnt").value='N';
        //Before change value of D/O EVENT
        document.getElementById("crnt_ctnt").value='Y';
        //setting to Y if OBL is changed
        document.getElementById("obl_cng_flg").value='Y';
        document.getElementById("new_obl_rdem_knt").value='0';
    }
    /************************************************************************************
        SaveEnd Event of IBSHEET의 start
    ************************************************************************************/
    /**
     * handle the details after blInfo save
     */
    function blInfo_OnSaveEnd(sheetObj, ErrMsg){
            doActionIBSheet(sheetObj, document.form,IBSEARCH);
    }
    /**
     * handle the details after refInfo save
     */
    function refInfo_OnSaveEnd(sheetObj, ErrMsg){
            doActionIBSheet(sheetObj, document.form,IBSEARCH);
    }
    /**
     * handle the details after doRlseSts save
     */
    function doRlseSts_OnSaveEnd(sheetObj, ErrMsg){
            doActionIBSheet(sheetObj, document.form,IBSEARCH);
    }
    /**
     * handle the details after stCancel save
     */
    function stCancel_OnSaveEnd(sheetObj, ErrMsg){
            doActionIBSheet(sheetObj, document.form,IBSEARCH);
    }
    /************************************************************************************
        OnSaveEnd Event of IBSHEET end
    ************************************************************************************/
    /************************************************************************************
        OnSearchEnd Event of IBSHEET start
    ************************************************************************************/
    /**
     * handle the details after IBSheet retrieve
     * calling selected popup if BL NO that corresponds to the container number is multi
     */
    function partial_OnSearchEnd(sheetObj, ErrMsg){
        if (ErrMsg == "") {
            try {
                oTbl.removeNode(true);
            }catch(e){}
            if(sheetObj.RowCount()> 1){
                blSelectPopOpen();
            }else if(sheetObj.RowCount()== 1){
            	document.getElementById("bl_no").value=sheetObjects["partial"].GetCellValue(1, "partial_"+"bl_no")+sheetObjects["partial"].GetCellValue(1, "partial_"+"bl_tp_cd");
            	document.getElementById("bkg_no").value=sheetObjects["partial"].GetCellValue(1, "partial_"+"bkg_no");
                conditionSet();
                doActionIBSheet(sheetObjects["blInfo"], document.form ,IBSEARCH);
            }else{
                sheetObjects["partial"].RemoveAll();
                ComShowCodeMessage('BKG00379');
            }
        }
    }
    /**
     * Kor D/O Release basic information retrieve handle the details IBSheet after retrieve
     */
    function blInfo_OnSearchEnd(sheetObj, ErrMsg){
        //Wait Image Show Hidden
        ComOpenWait(false);
        if (ErrMsg == "") {
            if(sheetObj.RowCount()> 0){
                ComCopyRowToForm(sheetObj, 1, form, "");
                //activating save button
                ComBtnEnable("btn_Save");
                //activating hold button
                ComBtnEnable("btn_Hold");
                //retrieve condition
                document.getElementById("bkg_no").value=sheetObj.GetCellValue(1,"blInfo_bkg_no");
                if(sheetObj.GetCellValue(1,"blInfo_bl_tp_cd") !='B'){
                	document.getElementById("bl_no").value=sheetObj.GetCellValue(1,"blInfo_bl_no")+sheetObj.GetCellValue(1,"blInfo_bl_tp_cd");
                }else{
                	document.getElementById("bl_no").value=sheetObj.GetCellValue(1,"blInfo_bl_no");
                }
            }
            /*************************************************************
                TPB setting start 0 : Red 1 : Green -1 : Gray
            *************************************************************/
            tpbImgSet(document.getElementById("tpb_status").value);
            refInfo_OnSearchEnd(sheetObj, ErrMsg);
            cstmsInfo_OnSearchEnd(sheetObj, ErrMsg);
            blIss_OnSearchEnd(sheetObj, ErrMsg);
            otsRcvInfo_OnSearchEnd(sheetObj, ErrMsg);
            ktNet_OnSearchEnd(sheetObj, ErrMsg);
            //activating button
            ComBtnEnable("btn_erp");
            ComBtnEnable("btn_dem_retrieve");
            ComBtnEnable("btn_dmdt");
            ComBtnEnable("btn_History");
            ComBtnEnable("btn_attorney");
            ComBtnEnable("btn_msnbonded");
            ComBtnEnable("btn_bl_preview");
            ComBtnEnable("btn_edotransmit"); //ED/O Transmit
            ComBtnEnable("btn_edoinquiry");  //ED/O Transmit
            ComBtnEnable("btn_edoresult");   //ED/O Transmit
            chkRemark();
            // checking LCL O/BL Release
            if (sheetObj.GetCellValue(1,"blInfo_lcloblissueflg") == "Y") {
            	ComShowCodeMessage("BKG00667");
            }
            // Checking the attorney existence
            if (sheetObj.GetCellValue(1,"blInfo_attorney_val_chk") == "N") {
            	ComShowCodeMessage("BKG43036");
            }           
            // Checking the attorney expiration
            if (sheetObj.GetCellValue(1,"blInfo_attorney_val_chk") == "E") {
            	ComShowCodeMessage("BKG43037");
            }          
            if( sheetObj.GetCellValue(1,"blInfo_edo_rqst_no") !="" &&
                document.form.blInfo_mf_ref_no.value != "" ){          	
            	if( sheetObj.GetCellValue(1,"blInfo_edo_rqst_no") != ( document.form.blInfo_mf_ref_no.value
            		                                              + document.form.blInfo_mf_seq_no.value)  ){
            		ComShowCodeMessage("BKG43044");           		
            	}
            }
            if (document.getElementById("blInfo_cntr_prt_flg").value == "Y") {
            	//font color is Bold and red.
            	document.getElementById("blInfo_cntr_prt_flg").style.color="red";            	
            	document.getElementById("blInfo_cntr_prt_flg").style.fontWeight="bold";
            } else {
            	document.getElementById("blInfo_cntr_prt_flg").style.color="";
            	document.getElementById("blInfo_cntr_prt_flg").style.fontWeight="normal";
            }
            if (document.getElementById("blInfo_soc_flg").value == "Y") {
            	//font color is Bold and red.
            	document.getElementById("blInfo_soc_flg").style.color="red";            	
            	document.getElementById("blInfo_soc_flg").style.fontWeight="bold";
            } else {
            	document.getElementById("blInfo_soc_flg").style.color="";
            	document.getElementById("blInfo_soc_flg").style.fontWeight="normal";
            }
        }else{
            //initial sheet in case of error
            var resetSheetNames=new Array("blInfo", "doRlseSts", "demInfo", "demDtl", "totBlbAmt");
            for(var idx=0; idx < resetSheetNames.length; idx++){
                sheetObjects[resetSheetNames[idx]].RemoveAll();
            }
            display_init();
        }
    }
    /**
     * Kor D/O Release Reference information retrieve handle the details IBSheet after retrieve
     */
    function refInfo_OnSearchEnd(sheetObj, ErrMsg){
        if (ErrMsg == "") {
            if(sheetObj.RowCount()> 0){
            	if(	sheetObj.GetCellValue(1, "blInfo_do_hld_flg") =='N'){
                    document.getElementById("hold_flag").className="input2";
                    document.getElementById("evnt_flag").value='H';
                    document.getElementById("hld").style.display="";
                    document.getElementById("uhld").style.display="none";
            	}else if(sheetObj.GetCellValue(1, "blInfo_do_hld_flg") =='Y'){
                    document.getElementById("hold_flag").className="input2_1";
                    document.getElementById("hold_flag").value='Hold';
                    document.getElementById("evnt_flag").value='R';
                    document.getElementById("hld").style.display="none";
                    document.getElementById("uhld").style.display="";
                }else{
                    document.getElementById("hold_flag").className="input2";
                    document.getElementById("evnt_flag").value='H';
                    document.getElementById("hld").style.display="";
                    document.getElementById("uhld").style.display="none";
                }
            }
        }
    }
    /**
     * handle the details after IBSheet retrieve
     * B/L INFO extraction to report Korea Customs
     */
    function cstmsInfo_OnSearchEnd(sheetObj, ErrMsg){
        if (ErrMsg == "") {
            if(sheetObj.RowCount()> 0){
//                ComCopyRowToForm(sheetObj, 1, form, "");
                //query condition value to retrieve EDI ID
            	document.getElementById("disc_loc_cd").value=sheetObj.GetCellValue(1, "blInfo_cstms_dchg_loc_wh_cd");
            }
        }
    }
    /**
     * handle the details after IBSheet retrieve
     */
     function blIss_OnSearchEnd(sheetObj, ErrMsg){
        if (ErrMsg == "") {
            /*
            if(sheetObj.RowCount()> 0){
                ComCopyRowToForm(sheetObj, 1, form, "");
            }
            */
            if (document.form.blInfo_bl_tp_cd.value == "") {
                document.form.blInfo_bl_tp_cd.value="B";
            }
            if( document.getElementById("blInfo_obl_rdem_flg").value =='Y'){
                document.getElementById("blInfo_obl_rdem_flg").style.color='blue';
            }else if(document.getElementById("blInfo_obl_rdem_flg").value =='N'){
                document.getElementById("blInfo_obl_rdem_flg").style.color='red';
            }
            document.getElementById("h_ori_obl_rdem_flg").value=document.getElementById("blInfo_obl_rdem_flg").value;
            document.getElementById("h_aft_obl_rdem_flg").value=document.getElementById("blInfo_obl_rdem_flg").value;
            document.getElementById("pre_ctnt").value=document.getElementById("blInfo_obl_rdem_knt").value;
            obl_rdem_knt_change(sheetObj, document.getElementById("blInfo_obl_rdem_knt"))
            if (sheetObj.GetCellValue(1, "blInfo_bl_tp_cd") == "S") {
                document.getElementById("bl_surr_rmk_flg").value="Y";
                document.getElementById("bl_surr_rmk_flg").className="input2";
                document.getElementById("btn_bl_surr_rmk").style.visibility="visible";
            } else {
                document.getElementById("bl_surr_rmk_flg").value="";
                document.getElementById("bl_surr_rmk_flg").className="noinput2";
                document.getElementById("btn_bl_surr_rmk").style.visibility="hidden";
            }            
        }
        document.getElementById("old_obl_rdem_knt").value=sheetObj.GetCellValue(1, "blInfo_obl_rdem_knt");
        //ComBtnEnable("btn_obl_cancel");
    }
    /**
     * handle the details after IBSheet retrieve
     * Outstanding Amounts informaition extraction and Whether the fare payment
     */
    function otsRcvInfo_OnSearchEnd(sheetObj, ErrMsg){
        if (ErrMsg == "") {
            if(sheetObj.RowCount()> 0){
                ComCopyRowToForm(sheetObj, 1, form, "");
                addSel(sheetObj);
                if( document.getElementById("blInfo_tot_ots_sts_cd").value =='Y'){
                    document.getElementById("blInfo_tot_ots_sts_cd").style.color='blue';
                }else if(document.getElementById("blInfo_tot_ots_sts_cd").value =='N'){
                    document.getElementById("blInfo_tot_ots_sts_cd").style.color='red';
                }
            }
        }
    }
    /**
     * handle the details after IBSheet retrieve
     */
    function demDtl_OnSearchEnd(sheetObj){
        var invTotBilAmt=0;
        //first container number of container information
        var fist_cntr_no=sheetObjects["demInfo"].GetCellValue(1, "demInfo_cntr_no");
        for(var idx=1; idx <= sheetObj.RowCount(); idx++){
        	if(fist_cntr_no != sheetObjects["demDtl"].GetCellValue(idx, "demDtl_cntr_no")){
                sheetObjects["demDtl"].SetRowHidden(idx,1);
            }
        }
    }
    /**
     * handle the details after IBSheet retrieve
     */
    function totBlbAmt_OnSearchEnd(sheetObj, ErrMsg){
        var sel=document.form.tot_bil_amt;
        //initializing SELECT BOX
        for (i=sel.length-1; i>=0; i--){
            sel.options[i]=null
        }
        var currCd="";
        var bilAmt="";
        var demSts=false;
        if (sheetObj.RowCount()> 0) {
            for (j=0; j<sheetObj.RowCount(); j++){
            	currCd=sheetObj.GetCellValue(parseInt(j+1), "totBlbAmt_"+"curr_cd");
            	bilAmt=sheetObj.GetCellValue(parseInt(j+1), "totBlbAmt_"+"tot_bil_amt");
                if (parseInt(bilAmt) > 0) {
                    demSts=true;
                }
                document.form['tot_bil_amt'][j]=new Option(currCd+' '+ComAddCommaRun(bilAmt), j);
            }
            if (demSts == true) {
                document.getElementById("demur_sts").value="N";
                document.getElementById("demur_sts").style.color='red';
                document.getElementById("tot_bil_amt").className="input2_1";
            } else {
                document.getElementById("demur_sts").value="Y";
                document.getElementById("demur_sts").style.color='blue';
                document.getElementById("tot_bil_amt").className="input2";
            }
        } else {
            document.getElementById("demur_sts").value="Y";
            document.getElementById("demur_sts").style.color='blue';
            document.form['tot_bil_amt'][0]=new Option('0');
            document.getElementById("tot_bil_amt").className="input2";
        }
    }
    /**
     * handle the details after IBSheet retrieve
     */
    function doRlseSts_OnSearchEnd(sheetObj, ErrMsg){
        if (ErrMsg == "") {
            if(sheetObj.RowCount()> 0){
                //setting last status of D/O to Hidden Value
                for(var idx=1; idx <= sheetObj.RowCount(); idx++){
                	if(sheetObj.GetCellValue(idx, "doRlseSts_rlse_sts_cd") != 'C'){
                		document.getElementById("rlse_sts_cd").value=sheetObj.GetCellValue(idx, "doRlseSts_rlse_sts_cd");
                    }
                    if(idx == sheetObj.RowCount()){
                    	document.getElementById("last_rlse_sts_cd").value=sheetObj.GetCellValue(idx, "doRlseSts_rlse_sts_cd");
                    }
                    //control button
                    if(sheetObj.GetCellValue(idx, "doRlseSts_rlse_sts_cd") == 'A'){
                        //initializing Cancel button
                        ComBtnDisable("btn_cancel");
                        //Release 버튼 activating
                        ComBtnEnable("btn_release");
                        ComBtnEnable("btn_remark");
                        ComBtnEnable("btn_receiverinfo");
                        ComBtnEnable("btn_obl_cancel");
                    }else if(sheetObj.GetCellValue(idx, "doRlseSts_rlse_sts_cd") == 'R'){
                        //initializing Cancel button
                        ComBtnEnable("btn_cancel");
                        ComBtnDisable("btn_release");
                        ComBtnEnable("btn_remark");
                        ComBtnEnable("btn_preview");
                        ComBtnEnable("btn_print");
                        ComBtnDisable("btn_obl_cancel");
                        if(sheetObj.GetCellValue(idx, "doRlseSts_self_trns_flg") == 'Y'){
                            document.getElementById("selfTransToTMN").checked=true;
                            ComBtnDisable("btn_edisend");
                            ComBtnEnable("btn_stcancel");
                        }else{
                            document.getElementById("selfTransToTMN").checked=false;
                            ComBtnEnable("btn_edisend");
                            ComBtnDisable("btn_stcancel");
                        }
                    //retrieve result exists only Cancel
                    }else if(sheetObj.GetCellValue(idx, "doRlseSts_rlse_sts_cd") == 'C'){
                        ComBtnDisable("btn_edisend");
                        ComBtnDisable("btn_stcancel");
                        ComBtnEnable("btn_release");
                        ComBtnEnable("btn_assign");
                        ComBtnEnable("btn_obl_cancel");
                    }
                }
                //setting D/O number to Hidden Value
                document.getElementById("h_do_no").value=sheetObj.GetCellValue(1, "doRlseSts_do_no");
                document.getElementById("h_do_no_split").value=sheetObj.GetCellValue(1, "doRlseSts_do_no_split");
                ComBtnEnable("btn_history");
//                sheetObj.SelectCell(sheetObj.RowCount(),0)
            }else{
                ComBtnEnable("btn_assign");
                ComBtnEnable("btn_release");
            }
        }
    }
    /**
     * handle the details after IBSheet retrieve
     */
    function ktNet_OnSearchEnd(sheetObj, ErrMsg){
        if (ErrMsg == "") {
            var checkCnt=0;
            if(sheetObj.RowCount()> 0){
            	if (sheetObj.GetCellValue(1, "blInfo_err_flg")=='Y') { //Red
            		document.getElementById("btn_edoresult").style.color='rgb(255,0,0)';
            	}else {
            		document.getElementById("btn_edoresult").style.color='';
            	}          	
            	if (sheetObj.GetCellValue(1, "blInfo_do_issue")=='5JN') {
                    document.getElementsByName("edo_rqst_sts")[0].checked=true;
                    checkCnt ++;
                }
            	if (sheetObj.GetCellValue(1, "blInfo_self_transportation")=='5JM') {
                    document.getElementsByName("edo_rqst_sts")[1].checked=true;
                    checkCnt ++;
                }
            	if (sheetObj.GetCellValue(1, "blInfo_bonded_transportation")=='5JK') {
                    document.getElementsByName("edo_rqst_sts")[2].checked=true;
                    checkCnt ++;
                }
            	if (sheetObj.GetCellValue(1, "blInfo_do_edo_ack_cd")=='A') {
                    //Blue
                    document.getElementById("btn_do").style.color='rgb(0,0,255)';
            	}else if (sheetObj.GetCellValue(1, "blInfo_do_edo_ack_cd")=='R') {
                    //Red
                    document.getElementById("btn_do").style.color='rgb(255,0,0)';
            	}else if (sheetObj.GetCellValue(1, "blInfo_do_edo_ack_cd")=='P') {
                    //Green
                    document.getElementById("btn_do").style.color='rgb(128,255,0)';
                }else{
                	document.getElementById("btn_do").style.color='';
                }
            	if (sheetObj.GetCellValue(1, "blInfo_self_edo_ack_cd")=='A') {
                    //Blue
                    document.getElementById("btn_self").style.color='rgb(0,0,255)';
            	}else if (sheetObj.GetCellValue(1, "blInfo_self_edo_ack_cd")=='R') {
                    //Red
                    document.getElementById("btn_self").style.color='rgb(255,0,0)';
            	}else if (sheetObj.GetCellValue(1, "blInfo_self_edo_ack_cd")=='P') {
                    //Green
                    document.getElementById("btn_self").style.color='rgb(128,255,0)';
                }else{
                	document.getElementById("btn_self").style.color='';
                }
            	if (sheetObj.GetCellValue(1, "blInfo_bonded_edo_ack_cd")=='A') {
                    //Blue
                    document.getElementById("btn_bonded").style.color='rgb(0,0,255)';
            	}else if (sheetObj.GetCellValue(1, "blInfo_bonded_edo_ack_cd")=='R') {
                    //Red
                    document.getElementById("btn_bonded").style.color='rgb(255,0,0)';
            	}else if (sheetObj.GetCellValue(1, "blInfo_bonded_edo_ack_cd")=='P') {
                    //Green
                    document.getElementById("btn_bonded").style.color='rgb(128,255,0)';
                }else{
                	document.getElementById("btn_bonded").style.color='';
                }
            }
            if(checkCnt > 0){
            }
        }
    }
    /************************************************************************************
        OnSearchEnd Event of IBSHEET end
    ************************************************************************************/
    /************************************************************************************
        OnClick Event of IBSHEET start
    ************************************************************************************/
    /**
     * handle the details in case of Onclick event of Grid : shoeswing INVOICE that corresponds to the clicked container number
     */
    function demInfo_OnDblClick(sheetObj, row, col){
        //first container number of container information
    		var click_cntr_no=sheetObj.GetCellValue(row, "demInfo_cntr_no");
        //calling detail popup in case of clicking
        demDtlPopOpen(click_cntr_no)
    }
    /**
     * DEM.DET detail information popup
     */
    function demDtlPopOpen(cntr_no){
        var sXml=IBS_GetDataSearchXml(sheetObjects["demDtl"]);
        document.form.demDtlXmlData.value=sXml;
        var condition="?";
            condition += "cntr_no="+cntr_no;
        ComOpenWindowCenter('/opuscntr/ESM_BKG_1072.do'+condition, 'demDtl', 500, 275, false);
    }
    //This function limits typing more 5 line
    function fncTextareaMaxLine(obj){
        var str_line=obj;
        line=str_line.split("\r\n");
        ln=line.length;
        if(ln == 5 && event.keyCode == 13){
            event.returnValue=false;
        }
    }
    /**
     * CCT,Third Office(CCT)  retrieve handler for popup <br>
     */
    function blOutstandingAmountPopOpen(flag){
        var maxRow=sheetObjects["blInfo"].LastRow();
        var cellValue="";
        var prefix="blInfo_";
        var curr_cd="";
        var ots_amt=0;
        var strXmlBody="";
        var xmlCnt=0;
        for(i=1;i <= maxRow ; i++){
            //setting font color depending on transmission status
            for(var q=1;q<6;q++){
                if (flag == true) { // in case of CCT
                	if (sheetObjects["blInfo"].GetCellValue(i, prefix + "cct_ots_amt" + q) > 0) {
                		curr_cd=sheetObjects["blInfo"].GetCellValue(i, prefix + "cct_ots_curr_cd" + q);
                		ots_amt=sheetObjects["blInfo"].GetCellValue(i, prefix + "cct_ots_amt" + q);
                        strXmlBody=strXmlBody + "<TR><![CDATA[" + curr_cd + "☜☞" + ots_amt + "☜☞]]></TR>";
                        xmlCnt=parseInt(xmlCnt) + 1;
                    }
                } else {            
                	if (sheetObjects["blInfo"].GetCellValue(i, prefix + "n3pty_cct_ots_amt" + q) > 0) {
                		curr_cd=sheetObjects["blInfo"].GetCellValue(i, prefix + "n3pty_cct_ots_curr_cd" + q);
                		ots_amt=sheetObjects["blInfo"].GetCellValue(i, prefix + "n3pty_cct_ots_amt" + q);
                        strXmlBody=strXmlBody + " <TR><![CDATA[" + curr_cd + "☜☞" + ots_amt + "☜☞]]></TR>";
                        xmlCnt=parseInt(xmlCnt) + 1;
                    }
                }
            }
        }
        if (parseInt(xmlCnt) > 0) {
            var sXml="";
            sXml="<SHEET> ";
            sXml=sXml + "<DATA COLORDER='otsRcvPop_curr_cd|otsRcvPop_ibflag|otsRcvPop_tot_ots_amt|otsRcvPop_pagerows|' COLSEPARATOR='☜☞' TOTAL='" + xmlCnt + "'>"
            sXml=sXml + strXmlBody;
            sXml=sXml + "</DATA> </SHEET>";
            document.form.oaXmlData.value=sXml;
            ComOpenPopup("/opuscntr/ESM_BKG_1022.do", 400, 320, "", "1,0", true);
       }
    }
    /**
     * handle the details after IBSheet retrieve
     */
    function demInfo_OnSearchEnd(sheetObj){
        //Wait Image Show Hidden
        ComOpenWait(false);
        ComBtnEnable("btn_dem_retrieve"); //DMDT
        ComBtnEnable("btn_dmdt");         //RCV Cancel
    }
    function fnSearchContainer(){
        var formObj=document.form;
        if (ComIsNull(formObj.cntr_no)) return;
        if(document.getElementById("h_cntr_no").value == document.getElementById("cntr_no").value) {
            return;
        }
        document.getElementById("h_cntr_no").value=document.getElementById("cntr_no").value;
        //calling popup
        formObj.f_cmd.value=SEARCH01;
        //parameter changed[check again]CLT         
        sheetObjects["partial"].DoSearch("ESM_BKG_0292GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("partial_") );
    }
    function preview() {
        if(document.getElementById("evnt_flag").value == 'R'){
        	ComShowCodeMessage('BKG40107', sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no"), "Preview");
            return;
        }
        if(document.getElementById("mrd_id").value == ""){
            ComShowCodeMessage("BKG40080");
            return;
        }
        var formObject=document.form;
        var doNo=sheetObjects["doRlseSts"].GetCellValue(1, "doRlseSts_do_no");
        var bkgNo=sheetObjects["blInfo"].GetCellValue(1, "blInfo_bkg_no")
        formObject.com_mrdPath.value="apps/opus/esm/bkg/inbounddocumentation/cargoreleaseordermgt/cargoreleaseorder/report/" + formObject.mrd_id.value + ".mrd";
        formObject.com_mrdArguments.value="/rv form_doNo['"+doNo+"'] form_bkgNo['"+bkgNo+"'] form_usrId['"+strUsr_id+"']  form_mainOnly[N] form_ofcCd['" + lginOfcCd + "'] " + formObject.mrd_param.value; // *.mrd에 맞게 파라메터 변경
        formObject.com_mrdBodyTitle.value="DELIVERY ORDER";
        ComOpenRDPopup();
    }
    function print() {
    	var appendReport = [];
    	if(document.getElementById("evnt_flag").value == 'R'){
        	ComShowCodeMessage('BKG40107', sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no"), "Print");
            return;
        }
        if(document.getElementById("mrd_id").value == ""){
            ComShowCodeMessage("BKG40080");
            return;
        }
        var formObject=document.form;
        var doNo=sheetObjects["doRlseSts"].GetCellValue(1, "doRlseSts_do_no");
        var bkgNo=sheetObjects["blInfo"].GetCellValue(1, "blInfo_bkg_no")
//        var Rdviewer=rdObjects[0];
        var rdParam="/rv form_doNo['"+doNo+"']  form_bkgNo['"+bkgNo+"'] form_usrId['"+strUsr_id+"']  form_mainOnly[N] form_ofcCd['" + lginOfcCd + "'] " + formObject.mrd_param.value; // *.mrd에 맞게 파라메터 변경
        var strPath=RD_path+"apps/opus/esm/bkg/inbounddocumentation/cargoreleaseordermgt/cargoreleaseorder/report/" + formObject.mrd_id.value + ".mrd"; // *.mrd 확인요망
        
        appendReport.push({mrdPath:strPath, mrdParam:RDServer + rdParam});
        directReportDownload(appendReport);
//        viewer.openFile(strPath, RDServer + rdParam, {timeout:1800});
//        viewer.print({isServerSide:true});   
    }
    /**
    * if Hold/Internal Remarks have value, button sets Enable and change red to button
    */
   function chkRemark() {
	   if (document.form.blInfo_inter_rmk.value.length > 0 ) {
		   buttonColorSet("btn_hold_remark", "red");
	   } else {
		   buttonColorSet("btn_hold_remark", "gray");
	   }
   }
    /**
     * deactivating button of screen
     * @param  btn_name
     * @param  color
     * @return void
     **/
   function buttonColorSet(btn_name, color){
       var tds=document.getElementsByTagName("td");
       var curFlag=null;
       curFlag="hand";
       for(var i=0; i < tds.length; i++) {
           var td=tds[i];
           if(td.name == '•' + btn_name){
          	    td.style.color=color;
          	    td.style.cursor=curFlag;
          	    if (btn_name == "btn_hold_remark") {
           	    document.form.h_hold_remark.value=color;
           	}
               break;
           }else if(td.name == btn_name){
          	    td.style.color=color;
          	    td.style.cursor=curFlag;
          	    if (btn_name == "btn_hold_remark") {
       		    document.form.h_hold_remark.value=color;
       	    }
               break;
           }else{
          	    continue;
           }
       }
   }
   function funcSetRemark(remark) {
	   document.form.blInfo_inter_rmk.value=remark;
	   chkRemark();
   }

   //GAP Display Credit Risk (2014.10.14 An Jin Eung)
   /**
    * fnExistBlackListedCustomer  
    * param :_val
    */
   function fnExistBlackListedCustomer(bkgNo) {
   	
   	var formObj = document.form;
   	var sheetObj = sheetObjects["blInfo"];

   	var param = "&f_cmd=" + COMMAND02 + "&input_text=" + bkgNo;
   	
		var sXml = sheetObj.GetSearchData("ESM_Booking_UtilGS.do", param);
		var output_text=ComGetEtcData(sXml, "output_text");    	

   	if (output_text != '') {
   		ComShowMessage(ComGetMsg("BKG43055", output_text ));
   		return false;// Y-> error
   	}
   	return true;
   }   