/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0680.js
*@FileTitle  : India Cargo Release (D/O)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/05
=========================================================*/
/****************************************************************************************
  EVENT CODE :	INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
				MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7
				OTHER COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * business script for ESM_BKG_0680
 */
    // global variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    var sheetNames=new Array("blInfo", "refInfo", "cstmsInfo", "cntrRlseSts", "doRlseSts", "blIss", "otsRcvInfo", "demInfo", "demDtl",  "totBlbAmt", "partial", "otsRcvPop");
    
    var chkRowCnt=0;
    
    var chkRowCount = 0;
    var chkReleaseCount = 0;
    var chkNoReleaseCount = 0;
    
    // Event handler processing by button click event  */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
        var formObject=document.form;
        try {
        	var srcName=ComGetEvent("name");
        	
        	var releaseYn = fnReleaseYn();

        	if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
                //Retrieve
                case "btn_retrieve":
                    doActionIBSheet(sheetObjects["blInfo"], formObject,IBSEARCH);
                break;
                //Save
                case "btn_save":
                    doActionIBSheet(sheetObjects["blIss"], formObject,IBSAVE);
                break;
                //Release
                case "btn_release":
                    if (releaseYn == true || chkReleaseCount > 0) {
                        ComShowCodeMessage("BKG00778");
                        return;
                    }
                	
                    doActionIBSheet(sheetObjects["doRlseSts"], formObject, MULTI01);
                break;
                //Cancel
                case "btn_cancel":
//                	if(!ComShowCodeConfirm("BKG00670")) return;
//                	doActionIBSheet(sheetObjects["doRlseSts"], formObject, REMOVE);
//                	doActionIBSheet(sheetObjects["blInfo"], formObject,IBSEARCH);
                	
                    if (document.form.refInfo_do_hld_flg.value == "Y") {
                        // B/L was Held
                    	ComShowCodeMessage("BKG40107", sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no"));
                        return;
                    }                	
                    
                    if (releaseYn == false) {
                        // in case of per BL
                        if (formObject.refInfo_do_split_flg.value == "N") {
                            if (sheetObjects["doRlseSts"].RowCount() > 0 && chkRowCnt == 0) {
                                ComShowCodeMessage("BKG40069", "Cancel");
                            } else {
                                //alert message
                                var blNo = "";
                                if (sheetObjects["blInfo"].RowCount() > 0) {
                                    blNo = sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no");
                                }
                                ComShowCodeMessage("BKG40059", blNo);
                            }
                        } else {
                            if (sheetObjects["cntrRlseSts"].RowCount() > 0 && chkRowCnt == 0) {
                                ComShowCodeMessage("BKG40069", "Cancel");
                            } else {
                                var blNo = "";
                                if (sheetObjects["blInfo"].RowCount() > 0) {
                                    blNo = sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no");
                                }
                                ComShowCodeMessage("BKG02120", blNo);
                            }
                        }
                        return;
                    }

                    if (document.form.refInfo_do_split_flg[0].checked == true) {
                        doActionIBSheet(sheetObjects["doRlseSts"], formObject, REMOVE);      // per BL
                    } else {
                        doActionIBSheet(sheetObjects["cntrRlseSts"], formObject, REMOVE);    // per Cntr
                    }     
                	break;
                //Hold
                case "btn_hold":
                    doActionIBSheet(sheetObjects["blInfo"], formObject, MULTI02);
                break;
                //Un-Hold
                case "btn_unhold":
                    doActionIBSheet(sheetObjects["blInfo"], formObject, MULTI03);
                break;
                case "img_exp_del_dt":
                    var cal=new ComCalendar();
                    cal.select(formObject.exp_del_dt, "yyyy-MM-dd");
                break;
                //OBL Cancel
                case "btn_obl_cancel":
                    if (sheetObjects["blInfo"].LastRow()== 0 ) {return;}
                    oblInit();
                break;
                case "btn_preview":
                    if (sheetObjects["blInfo"].LastRow()== 0 ) {return;}
                    fnPreview();
                    break;
                case "btn_print":
                    if (sheetObjects["blInfo"].LastRow()== 0 ) {return;}
             	    var appendReport = [];
                    
             	    if (document.form.refInfo_do_split_flg[0].checked == true) {
                    	fnPrint();
                    } else {
                        if (document.form.refInfo_do_hld_flg.value == "Y") {
                            // B/L was Held
                        	ComShowCodeMessage('BKG40107', sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no"), "Print");
                            return;
                        }
                    	
                        var prefix="cntrRlseSts";
                        // CHECK ROW Validation
                        var doNo="";
                        for (var idx=1; idx <= sheetObjects[prefix].LastRow(); idx ++) {
                        	if (sheetObjects[prefix].GetCellValue(idx, prefix+"_check") == 1) {
                                // validation for checked Info
                        		doNo=sheetObjects[prefix].GetCellValue(idx, prefix+ "_do_no") + sheetObjects[prefix].GetCellValue(idx, prefix+ "_do_no_split");
                                if (doNo == "") {
                                    // not Release
                                	ComShowCodeMessage("BKG40071", sheetObjects[prefix].GetCellValue(idx, prefix+ "_cntr_no"));
                                    return;
                                }
                            }
                        }
                        
                        //하나도 선택된 것이 없는 경우 오류 처리
                        if (doNo.trim() == "") {
                            // [{?msg1}] Button is available only when you select Containers by clicking a check box.\nPlease click a check box then press '{?msg1}' Button once again.
                            ComShowCodeMessage("BKG40069", "Print");
                            return;
                        }
                        
                        for (var idx=1; idx <= sheetObjects[prefix].LastRow(); idx ++) {
                        	if (sheetObjects[prefix].GetCellValue(idx, prefix+"_check") == 1) {
                                // validation for checked Info
                        		doNo=sheetObjects[prefix].GetCellValue(idx, prefix+ "_do_no") + sheetObjects[prefix].GetCellValue(idx, prefix+ "_do_no_split");
                               
                               var mrdId = document.form.h_mrd_id.value;
                               var mrdParam = document.form.h_mrd_param.value;
                               
                               if(mrdId == ""){
                                   ComShowCodeMessage("BKG40080");
                                   return;
                               }
                               formObject.com_mrdPath.value="apps/opus/esm/bkg/inbounddocumentation/cargoreleaseordermgt/cargoreleaseorder/report/"
                                   + mrdId
                                   + ".mrd";
                               var strArg="/rv ";
                               strArg += " form_bkgNo['" + sheetObjects["blInfo"].GetCellValue(1, "blInfo_bkg_no") + "']";
                               strArg += " form_doNo['" + doNo + "']";
                               strArg += " form_usrId['" + lginUsrId + "']";
                               strArg += " form_mainOnly['Y']";
                               strArg += " form_ofcCd['" + lginOfcCd + "']";
                               strArg += " " + mrdParam; 
                               
                                var rdParam=strArg + " /riprnmargin /rwait";
                                // setting open RD file
                                var strPath=RD_path+ formObject.com_mrdPath.value;
                    	           appendReport.push({mrdPath:strPath, mrdParam:RDServer + rdParam});
                        		//rdLoad(document.form, document.form.h_mrd_id.value, document.form.h_mrd_param.value, doNo, "Print");                        
                        	}
                        }
                        directReportDownload(appendReport);
//                    	 viewer.openFile(appendReport, {timeout:1800});
//                     	 viewer.print({isServerSide:true}); 
                    } 
                    
                break;
                case "img_exp_del_dt":
                    var cal=new ComCalendar();
                    cal.select(formObject.exp_del_dt, 'yyyy-MM-dd');
                break;
                case "btn_bl_surr_rmk":
                    if (sheetObjects["blInfo"].LastRow()== 0 ) {return;}
                    if (formObject.bl_surr_rmk_flg.value == "Y") {
                        fnShowSurrRemark();
                    }
                break;
                case "btn_history":
                    if (sheetObjects["blInfo"].LastRow()== 0 ) {return;}
                    fnShowHistory();
                break;
                case "btn_form_setup":
                    fnShowFormSetup();
                break;
                case "btn_receiverinfo":
                    if (sheetObjects["blInfo"].LastRow()== 0 ) {return;}
                    fnShowRcvrInfo();
                break;
                case "btn_remark":
                    if (sheetObjects["blInfo"].LastRow()== 0 ) {return;}
                    fnShowRemark();
                break;
                case "btn_cct":
                    blOutstandingAmountPopOpen(true);
                break;
                case "btn_third_cct":
                    blOutstandingAmountPopOpen(false);
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
                    ComOpenWindow('/opuscntr/ESD_TPB_0134.do'+condition, 'win4', 'width=1024,height=318');
                break;
                case "btn_dem_retrieve":
                    doActionIBSheet(sheetObjects["blInfo"], formObject,COMMAND05);
                break;
                case "btn_dmdt":
                	var bkgNo=sheetObjects["blInfo"].GetCellValue(1, "blInfo_bkg_no");
                	var blNo=sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no");
                    var trfCd=document.getElementById("demur_type").value;
                    var paramVal="?call_flag=P&bkg_no=" + bkgNo + "&bl_no=" + blNo + "&dmdt_trf_cd=" + trfCd + "&pgmNo=EES_DMT_3002P";
                    ComOpenWindow('/opuscntr/EES_DMT_3002P.do' + paramVal, 'win4', 'width=1010,height=670');
                break;
                case "btn_hold_remark":
                    var paramVal="?sheet_name=R&pgmNo=ESM_BKG_1089";
                    ComOpenWindowCenter('/opuscntr/ESM_BKG_1089.do' + paramVal, 'win4', 600, 270, false);
                break;
                case "btn_close":
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
     * @param sheet_obj IBSheet Object
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheet_obj.id]=sheet_obj;
    }
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
    	var formObj=document.form;
    	fnInSetComboBox(formObj.refInfo_ida_do_dmdt_pay_tp_cd, evtCode, evtValue, "|", null, null, true, "G");
        for(i=0;i<sheetNames.length;i++){
            if(sheetObjects[sheetNames[i]].name =='doRlseSts' || sheetObjects[sheetNames[i]].id =='cntrRlseSts' || sheetObjects[sheetNames[i]].id =='demInfo'){
                ComConfigSheet (sheetObjects[sheetNames[i]] );
            }
            initSheet(sheetObjects[sheetNames[i]], i + 1);
            if(sheetObjects[sheetNames[i]].id =='doRlseSts' || sheetObjects[sheetNames[i]].id =='cntrRlseSts' || sheetObjects[sheetNames[i]].id =='demInfo'){
                ComEndConfigSheet(sheetObjects[sheetNames[i]]);
            }
        }
        initControl();
        
        // set focus B/L No
         ComSetFocus(document.form.bl_no)
        // deactivate all button except retrieve button
        document.getElementById("btn_tpb").style.visibility="hidden";
         
         //@ Test Code Start ----------
// 		form.bkg_no.value = 'NYK400569200'; //NYK400569200 컨테이너
 		//@ Test Code End   ----------
         
         if(document.getElementById("bkg_no").value !='' ){
             doActionIBSheet(sheetObjects["blInfo"], document.form,IBSEARCH);
         }

//         initRdConfig(rdObjects[0]);
         
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
	 * init control
	 */
    function initControl(){
        axon_event.addListenerForm("click"    , "obj_click"      , form);
        axon_event.addListenerForm("change"   , "obj_change"     , form);
        axon_event.addListenerForm("blur"     , "obj_deactivate" , form);
        obl_rdem_knt_change(document.getElementById("blIss_obl_rdem_knt"));
        axon_event.addListenerForm('keydown' , 'obj_keypress'   , form);
    }
    /**
     * handling process for OnKeyPress
     */
   function obj_keypress(){
        var keyCode=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
        var srcName=ComGetEvent("name");
        // Enter (13key)
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
                doActionIBSheet(sheetObjects["blInfo"], document.form, COMMAND05);
            }
        }
    }
    /**
      * HTML control click event handling
      */
    function obj_click(){
        var form=document.form;
        // setting B/L no Select Box in case of Click
        if (ComGetEvent("name") == "bl_no") {
            showHideLayers();
        } else if (ComGetEvent("name") == "refInfo_do_split_flg") {
            if (form.refInfo_do_split_flg[0].checked) {
            	cntrRlseSts.SetVisible(false);
                doRlseSts.SetVisible(true);
                doRlseSts.SetSheetHeight(150);
                document.getElementById("div_remain_cnt").style.visibility="hidden";
            } else {
            	
            	cntrRlseSts.SetVisible(1);
            	doRlseSts.SetVisible(0);
            	cntrRlseSts.SetSheetHeight(150);
                document.getElementById("div_remain_cnt").style.visibility="visible";
            }
        }
    }
    /**
     * object change handling 
     */
  //@ 조회 후 세팅시 bkg_no bl_no conditionReset발생 안하게 하기 위함 
    var onchangeFlag = true;
    function obj_change(){
        var oForm=document.form;
        //trim retrieve condition
        conditionTrim();
        if(ComGetEvent("name") == "bl_no" || ComGetEvent("name") == "bkg_no" ){
         	//@ 조회 후 세팅시 bkg_no bl_no conditionReset발생 안하게 하기 위함 
        	if(onchangeFlag){
        		conditionReset();
        	}
        }
        if(!ComChkObjValid(oForm.bl_no) || !ComChkObjValid(oForm.bkg_no) || !ComChkObjValid(oForm.cntr_no)) {
            return false;
        }
        if( ComGetEvent("name") == "blIss_obl_rdem_knt" ||
            ComGetEvent("name") == "blIss_bl_otr_doc_rcv_cd" ||
            ComGetEvent("name") == "blIss_ibd_doc_rcv_flg" ||
            ComGetEvent("name") == "blIss_otr_doc_cgor_flg"){
            if (ComGetEvent("name") == 'blIss_bl_otr_doc_rcv_cd') {
               if (document.getElementById("blIss_bl_otr_doc_rcv_cd").selectedIndex > 0) {
                   document.getElementById("blIss_otr_doc_cgor_flg").disabled=false;
                   document.getElementById("blIss_otr_doc_cgor_flg").value='N';
               } else {
                   document.getElementById("blIss_otr_doc_cgor_flg").selectedIndex=0;
                   document.getElementById("blIss_otr_doc_cgor_flg").disabled=true;
               }
           }
            /*
             * [India]
             * 1. editing disable in cae of bl is Redemption
             * 2. editing disable and status is 'N'
             *    in case of Obl is not Redemption or Other Document Receive & Accept
             * 3. other can editing enable
             */
            if(document.getElementById("blIss_obl_rdem_flg").value == "Y" ) {
                document.getElementById("blIss_ibd_doc_rcv_flg").disabled=true;
            }else if((document.getElementById("blIss_obl_rdem_knt").value ==""  || document.getElementById("blIss_obl_rdem_knt").value.parseInt() == 0) &&
                     (document.getElementById("blIss_bl_otr_doc_rcv_cd").selectedIndex < 1 || document.getElementById("blIss_otr_doc_cgor_flg").selectedIndex < 2)) {
            }else{
                document.getElementById("blIss_ibd_doc_rcv_flg").disabled=false;
            }
            //log history in case of Original Bill of Lading Status N => Y
            if( document.getElementById("blIss_obl_rdem_flg").value =='Y'){
                return;
            }
            //log history in case of obl cancel or obl clear.
            //(India different other : blIss_ibd_doc_rcv_flg)
            if((document.getElementById("blIss_obl_rdem_knt").value >0 && document.getElementById("blIss_ibd_doc_rcv_flg").value=='Y')  ||
                (document.getElementById("blIss_otr_doc_cgor_flg").value =='Y' && document.getElementById("blIss_ibd_doc_rcv_flg").value=='Y')){
                document.getElementById("obl_cng_flg").value='Y';
                document.getElementById("do_cng_evnt_cd").value='RB';
            }
        }
    }
    /**
      * object deactivate handling 
      */
    function obj_deactivate(){
        var objName=ComGetEvent("name");
        var formObj=document.form;
        //setting B/L No SelectBox in case of event
        if(blLayer.style.visibility == "visible"){
            blLayer.style.visibility="hidden";
        }
        /*****************************************
        switch(objName) {
            case "exp_del_dt":
                ComChkObjValid(event.srcElement);
            break;
            case "refInfo_ida_do_vty_dt":
                ComChkObjValid(event.srcElement);
            break;
        }
        *****************************************/
    }
    /**
     * on focus handling 
     */
    function obj_focus(){
        var objName=ComGetEvent("name");
        var formObj=document.form;
        switch(objName) {
            case "exp_del_dt":
                formObj.exp_del_dt.value=formObj.exp_del_dt.value.replace(eval("/-/gi"), "");
            break;
        }
    }
    /**
     * all button disable 
     */
    function buttonDisabledAll(){
        ComBtnDisable("btn_do_id_save");
        ComBtnDisable("btn_obl_cancel");
        ComBtnDisable("btn_erp");
        ComBtnDisable("btn_dem_retrieve");
        ComBtnDisable("btn_dmdt");
        ComBtnDisable("btn_save");
        ComBtnDisable("btn_hold");
        ComBtnDisable("btn_history");
        ComBtnDisable("btn_form_setup");
        ComBtnDisable("btn_receiverinfo");
        ComBtnDisable("btn_remark");
        ComBtnDisable("btn_assign");
        ComBtnDisable("btn_cancel");
        ComBtnDisable("btn_if");
        ComBtnDisable("btn_dorcancel");
        ComBtnDisable("btn_print");
        ComBtnDisable("btn_receipt");
        ComBtnDisable("btn_preview");
        ComBtnDisable("btn_release");
        ComBtnDisable("btn_unhold");
    }
    /**
     * all button enable 
     */
    function buttonEnable(name) {
        var tds=document.getElementsByTagName("td");
        for(var i=0; i < tds.length; i++) {
            var td=tds[i];
            if(td.name == undefined || td.name.length == 0 ){
                continue;
            }
            if (td.className.length > 0 && td.name == name) {
                if (td.className.indexOf("_1") > 0){
                    td.className=td.className.replace(/_1/i, "");
                }
                td.name=name;
            }
        }
    }
    /**
      * reset input parameter except search condition
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
        //init sheet
        var resetSheetNames=new Array("blInfo", "refInfo", "cstmsInfo", "cntrRlseSts", "doRlseSts", "blIss", "otsRcvInfo", "demInfo", "demDtl",  "totBlbAmt", "otsRcvPop");
        for(var idx=0; idx < resetSheetNames.length; idx++){
            sheetObjects[resetSheetNames[idx]].RemoveAll();
        }
        document.getElementById("refInfo_inter_rmk").value="";
        document.getElementById("blIss_otr_doc_cgor_flg").value='';
        document.getElementById("blIss_bl_otr_doc_rcv_cd").value='';
        document.getElementById("blIss_ibd_doc_rcv_flg").value='';
        document.getElementById("tot_ots_amt").value='';
        document.getElementById("tot_bil_amt").value='';
    }
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     * @param sheetObj sheet Object
     * @param sheetNo 
     */
    function initSheet(sheetObj, sheetNo) {
        var cnt=0;
        var sheetID=sheetObj.id;
        switch(sheetID) {
            case "blInfo":
                with(sheetObj){
		              var HeadTitle=" |POR|POL|POD|DEL|DELTerm|ArrivalVessel|ETA|PKG1|PKG2|WGT1|WGT2|MEA1|MEA2|Partial|SOC|Consignee Nm|Consignee Addr|Notify Nm|Notify Addr|Shipper Nm|Shipper Addr|Split_flg|BKG NO|BL NO|BL_TP_CD|DE_TERM_DESC|BL_TP_CD|OBL_ISS_RMK|lcloblissueflg";
		              var headCount=ComCountHeadTitle(HeadTitle);
		              var prefix="blInfo_";
		              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		              var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);
		              var cols = [ 
		                      {Type:"Status",    Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"por_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pol_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pod_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"del_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"de_term_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"arrival_vessel", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"vps_eta_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pck_qty",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pck_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"act_wgt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"wgt_ut_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"meas_qty",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"meas_ut_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_prt_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"soc_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ccust_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ccust_addr",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ncust_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ncust_addr",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"scust_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"scust_addr",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"split_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bkg_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"de_term_desc",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"dsch_loc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_iss_rmk",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"lcloblissueflg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
		              InitColumns(cols);
		              SetVisible(false);
		              SetEditable(0);
                    }
                break;
            case "refInfo":
                with(sheetObj){
		              var HeadTitle=" |BKG_NO|INTER_RMK|DO_HLD_FLG|CSTMS_REF_NM|CSTMS_REF_CTNT|CSTMS_ASGN_NM|CSTMS_ASGN_CTNT|CY_OP_CD|INFO_CGO_FLG|IDA_IMP_GEN_MF_NO|IDA_CGOR_ORD_YR|IDA_CSTMS_ASGN_LINE_NO|DO_SPLIT_FLG";
		              var prefix="refInfo_";
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		              var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);
		              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
		                     {Type:"Text",      Hidden:0, Width:200,  Align:"Center",  ColMerge:0,   SaveName:prefix+"bkg_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:200,  Align:"Center",  ColMerge:0,   SaveName:prefix+"inter_rmk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"do_hld_flg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:200,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cstms_ref_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:200,  Align:"Right",   ColMerge:0,   SaveName:prefix+"cstms_ref_ctnt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:200,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cstms_asgn_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:200,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cstms_asgn_ctnt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cy_op_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"info_cgo_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:200,  Align:"Center",  ColMerge:0,   SaveName:prefix+"ida_imp_gen_mf_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:200,  Align:"Center",  ColMerge:0,   SaveName:prefix+"ida_cgor_ord_yr",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ida_cstms_asgn_line_no", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"do_split_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
		              InitColumns(cols);
		              sheetObj.SetVisible(false);
		              SetEditable(0);
                    }
            break;
            case "cstmsInfo":
                with(sheetObj){
		              var HeadTitle=" |loc_nm|troi_flg";
		              var prefix="cstmsInfo_";
		              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		              var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);
		              var cols = [ 
		                     {Type:"Status",    Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
		                     {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"loc_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"troi_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
		              InitColumns(cols);
		              sheetObj.SetVisible(false);
		              SetEditable(0);
                    }
            break;
            case "cntrRlseSts":
                with(sheetObj){
		              var HeadTitle="|Check|CNTR No|Status|D/O No|Validate Date|DMDT Payment type|Update Time|User ID|BKG NO |RLSE SEQ|RLSE STS SEQ|DO NO SPLIT|Status Code";
		              var headCount=ComCountHeadTitle(HeadTitle);
		              var prefix="cntrRlseSts_";
		              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		              var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);
		              var cols = [ 
		                     {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
		                     {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"check",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"rlse_sts_ctnt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:0,   SaveName:prefix+"do_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:prefix+"do_vty_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:130,  Align:"Center",  ColMerge:0,   SaveName:prefix+"do_dmdt_pay_tp_ctnt", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:prefix+"evnt_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"evnt_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"bkg_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"rlse_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"rlse_sts_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"do_no_split",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"rlse_sts_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
		              InitColumns(cols);
		              SetVisible(false);
		              SetEditable(1);
		              SetColProperty(prefix+"evnt_dt", {Format:"####-##-####:##"} );
		              SetSheetHeight(150);
             	}
            break;
            case "doRlseSts":
                with(sheetObj){
		              var HeadTitle=" |Status|Status|D/O No.|Validate Date|DMDT Payment type|Update Time|User ID|User Name|Office|BKG NO |RLSE SEQ|RLSE STS SEQ|DO NO SPLIT";
		              var headCount=ComCountHeadTitle(HeadTitle);
		              var prefix="doRlseSts_";
		              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		              var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);
		              var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"rlse_sts_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:0,   SaveName:prefix+"rlse_sts_ctnt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:0,   SaveName:prefix+"do_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"do_vty_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:130,  Align:"Center",  ColMerge:0,   SaveName:prefix+"do_dmdt_pay_tp_ctnt", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:0,   SaveName:prefix+"evnt_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:75,   Align:"Center",  ColMerge:0,   SaveName:prefix+"evnt_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:prefix+"evnt_usr_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"evnt_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"bkg_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"rlse_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"rlse_sts_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"do_no_split",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
		              InitColumns(cols);
		              SetEditable(1);
		              SetColProperty(prefix+"evnt_dt", {Format:"####-##-####:##"} );
		              SetSheetHeight(150);
            	}
            break;
            case "blIss":
                with(sheetObj){
		              var HeadTitle=" |BL회수여부|BL발행통수|O/BL ISSUE|OFFICE|DATE|O/BL RECEIVED|OFFICE|DATE|OTHER DOC RECEIVE|OFFICE|DATE|OTR DOC CGOR FLG| | ||||||";
		              var prefix="blIss_";
		              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);
		              var cols = [ 
		                     {Type:"Status",    Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_rdem_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_cpy_knt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_iss_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_iss_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_iss_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_rdem_knt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_rdem_ofc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_rdem_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_otr_doc_rcv_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"otr_doc_rcv_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"otr_doc_rcv_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"otr_doc_cgor_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_iss_usr_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_rdem_usr_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"otr_doc_rcv_usr_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibd_doc_rcv_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibd_doc_rcv_old_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibd_doc_rcv_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibd_doc_rcv_usr_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibd_doc_rcv_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_tp_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"del_cnt_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
		              InitColumns(cols);
		              SetVisible(false);
		              SetEditable(0);
                    }
            break;
            case "otsRcvInfo":
                with(sheetObj){
		              var HeadTitle=" |TOT_OTS_STS_CD|TOT_OTS_CURR_CD1|TOT_OTS_CURR_CD2|TOT_OTS_CURR_CD3|TOT_OTS_CURR_CD4|TOT_OTS_CURR_CD5|TOT_OTS_AMT1|TOT_OTS_AMT2|TOT_OTS_AMT3|TOT_OTS_AMT4|TOT_OTS_AMT5|PPT_STS_CD|PPT_RCV_OFC_CD|PPT_RCV_USR_ID|PPT_RCV_DT|CCT_STS_CD|CCT_RCV_OFC_CD|CCT_RCV_USR_ID|CCT_RCV_DT|CCT_OTS_CURR_CD1|CCT_OTS_CURR_CD2|CCT_OTS_CURR_CD3|CCT_OTS_CURR_CD4|CCT_OTS_CURR_CD5|CCT_OTS_AMT1|CCT_OTS_AMT2|CCT_OTS_AMT3|CCT_OTS_AMT4|CCT_OTS_AMT5|N3PTY_PPT_STS_CD|N3PTY_PPT_RCV_OFC_CD|N3PTY_PPT_RCV_USR_ID|N3PTY_PPT_RCV_DT|N3PTY_CCT_STS_CD|N3PTY_CCT_RCV_OFC_CD|N3PTY_CCT_RCV_USR_ID|N3PTY_CCT_RCV_DT|N3PTY_CCT_OTS_CURR_CD1|N3PTY_CCT_OTS_CURR_CD2|N3PTY_CCT_OTS_CURR_CD3|N3PTY_CCT_OTS_CURR_CD4|N3PTY_CCT_OTS_CURR_CD5|N3PTY_CCT_OTS_AMT1|N3PTY_CCT_OTS_AMT2|N3PTY_CCT_OTS_AMT3|N3PTY_CCT_OTS_AMT4|N3PTY_CCT_OTS_AMT5";
		              var headCount=ComCountHeadTitle(HeadTitle);
		              var prefix="otsRcvInfo_";
		              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);
		              var cols = [ {Type:"Status",    Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
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
		                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_amt5",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
		              InitColumns(cols);
		              SetVisible(false);
		              SetEditable(0);
                    }


            break;
            case "demInfo":
                with(sheetObj){
		              var HeadTitle=" |Seq\n|Container No.|F/T\nOver|Billable\nAmount|Billable\nAmount|Estimate\nFree Time|SAT\nExcl|SUN\nExcl|HOLI\nExcl|Estimate\nPOD LFD|Daily\nDemurrage|Fixed\nFree Time|Fixed\nPOD LFD";
		              var prefix="demInfo_";
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		              var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
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
		              SetSheetHeight(120);
		              SetEditable(0);
                    }
                break;
            case "demDtl":
                with(sheetObj){
		              var HeadTitle=" |Invoicing|Settled|DEMCMNC|PaidUpto|Paid Amount|Paid Amount|CNTR_NO|BIL_AMT";
		              var prefix="demDtl_";
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		              var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
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
		              SetVisible(false);
		              SetEditable(0);
                    }
                break;
                
            case "totBlbAmt":
                with(sheetObj){
		              var HeadTitle1="|curr_cd|tot_bil_amt";
		              var headCount=ComCountHeadTitle(HeadTitle1);
		              prefix="totBlbAmt_";
		              SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:1 } );
		              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		              InitHeaders(headers, info);
		              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
				                     {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"curr_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				                     {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"tot_bil_amt", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
		              InitColumns(cols);
		              SetVisible(false);
		              SetEditable(1);
                    }
                break;
                
            case "partial":
                with(sheetObj){
		              var HeadTitle1="|Seq.||B/L NO.|CNEE NAME|BKG No|BL_TP_CD";
		              var headCount=ComCountHeadTitle(HeadTitle1);
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
		              SetVisible(false);
		              SetEditable(1);
                    }


            break;
            case "otsRcvPop":
                with(sheetObj){
		              var HeadTitle1="|OUTSTANDING|OUTSTANDING";
		              var headCount=ComCountHeadTitle(HeadTitle1);
		              prefix="otsRcvPop_";
		              SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:1 } );
		              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		              InitHeaders(headers, info);
		              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
		                     {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"curr_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"tot_ots_amt", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
		               
		              InitColumns(cols);
		              SetVisible(false);
		              SetEditable(1);
                }
            break;
        }
    }
    /**
     * Sheet process handling
     * @param sheetObj
     * @param formObj
     * @param sAction
     * @return
     */
    function doActionIBSheet(sheetObj, formObj, sAction) {
        //setting Debug
        //sheetObj.ShowDebugMsg = false;
        switch(sAction) {
            case IBSEARCH: //Retrieve
                if(!validateForm(sheetObj,formObj,sAction)){
                	return;
                }
                    //init param
                    inputParamReset();
                    //setting button
                    //buttonDisabledAll();
                    ComOpenWait(true);
                    
                    
                    setTimeout( function () { //@ setTimeout ###########################################################
                    	//@ 조회 후 세팅시 bkg_no bl_no conditionReset발생 안하게 하기 위함 
                    	onchangeFlag = false;
                    	
                    	
                    		formObj.f_cmd.value=SEARCH;
		                    //remove BL_TP_CD in case of BL_TP_CD = W or S 
		                    if(formObj.bl_no.value !=''){
		                        var blNo=formObj.bl_no.value;
		                        var suffix=blNo.substring(formObj.bl_no.value.length-1)
		                        if(suffix =='W' || suffix =='S'){
		                            formObj.bl_no.value=blNo.substring(0, blNo.lastIndexOf(suffix));
		                        }
		                    }
		                    //multi retrieve
		                    var aryPrefix=new Array("blInfo_", "refInfo_", "cstmsInfo_", "cntrRlseSts_", "doRlseSts_", "blIss_", "otsRcvInfo_", "demInfo_", "demDtl_",  "totBlbAmt_"); 
		                    //parameter changed[check again]CLT                     
		                    var sXml=sheetObjects["blInfo"].GetSearchData("ESM_BKG_0680GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
		                    var arrXml=sXml.split("|$$|");
		                    // init "DMDT Payment Type'
		                    document.getElementById("refInfo_ida_do_dmdt_pay_tp_cd").options[0].selected=true;
		                    document.getElementById("refInfo_ida_do_vty_dt").removeAttribute("required");
		                    //ETC DATA transaction : 
		                    // OnSearchEnd Event before LoadSearchXml 
		                    if(undefined != ComGetEtcData(arrXml[0], "demurType") && ComGetEtcData(arrXml[0], "demurType") != "null"){
		                        document.getElementById("demur_type").value=ComGetEtcData(arrXml[0], "demurType");
		                    }
		                    if(undefined != ComGetEtcData(arrXml[0], "mrdId") && ComGetEtcData(arrXml[0], "mrdId") != 'null'){
		                        var mrdId=ComGetEtcData(arrXml[0], "mrdId");
		                        var arrMrd=mrdId.split("@@");
		                        document.getElementById("h_mrd_id").value=arrMrd[0];
		                        if (arrMrd.length > 1) {
		                            document.getElementById("h_mrd_param").value=arrMrd[1];
		                        } else {
		                            document.getElementById("h_mrd_param").value="";
		                        }
		                    }
		                    if(undefined != ComGetEtcData(arrXml[0], "dorStsCd") && ComGetEtcData(arrXml[0], "dorStsCd") != "null"){
		                        document.getElementById("dorStsCd").value=ComGetEtcData(arrXml[0], "dorStsCd");
		                    }
		                    if(undefined != ComGetEtcData(arrXml[0], "dorStowage") && ComGetEtcData(arrXml[0], "dorStowage") != "null"){
		                        document.getElementById("dorStowage").value=ComGetEtcData(arrXml[0], "dorStowage");
		                    }
		                    if(undefined != ComGetEtcData(arrXml[0], "tpbStatus") && ComGetEtcData(arrXml[0], "tpbStatus") != "null"){
		                        document.getElementById("tpb_status").value=ComGetEtcData(arrXml[0], "tpbStatus");
		                    }
		                    if(undefined != ComGetEtcData(arrXml[0], "remain_cnt") && ComGetEtcData(arrXml[0], "remain_cnt") != "null"){
		                        document.getElementById("remain_cnt").value=ComGetEtcData(arrXml[0], "remain_cnt");
		                    }
		                    //fnPreRetrieve(); // init in case of search
		                    for(var idx=0; idx < arrXml.length; idx++){
		                        //sheetObjects[sheetNames[idx]].RenderSheet(0);
		                        if(idx > 0) {
		                            sheetObjects[sheetNames[idx]].SetWaitImageVisible(0);
		                        }
		                        sheetObjects[sheetNames[idx]].LoadSearchData(arrXml[idx],{Sync:1} );
		                        //sheetObjects[sheetNames[idx]].RenderSheet(1);
		                    }
		                    
		                    //fnButtonControl();
		                    
		                    //@ 조회 후 세팅시 bkg_no bl_no conditionReset발생 안하게 하기 위함 
		                    onchangeFlag = true;
		                    
		                    //@releaseRemarkFlag 초기화 한다. 
		                    releaseRemarkFlag = false;
		                    
	                    
                    } , 100);//@ setTimeout end ###########################################################		                    
                
                break;
            case COMMAND05: //Dem retrieve
                if(!validateForm(sheetObj,formObj,sAction)){
                	return;
                }
    	        	//check retrieve condition existing change
    	        	if(ComIsNull(formObj.bl_no) && ComIsNull(formObj.bkg_no)){
    	                ComShowCodeMessage('BKG01072'); 
    	                ComSetFocus(formObj.bl_no)
    	                return false;
    	            }
                    //setting button
                    //buttonDisabledAll();
                    ComOpenWait(true);
                    
                    //@ 조회 후 세팅시 bkg_no bl_no conditionReset발생 안하게 하기 위함 
                    onchangeFlag = false;
                    
               setTimeout( function () { //@ setTimeout ###########################################################

		                    formObj.f_cmd.value=SEARCH;
		                    //multi retrieve
		                    var aryPrefix=new Array("blInfo_", "refInfo_", "cstmsInfo_", "cntrRlseSts_", "doRlseSts_", "blIss_", "otsRcvInfo_", "demInfo_", "demDtl_",  "totBlbAmt_"); 
		                    //parameter changed[check again]CLT                     
		                    var sXml=sheetObjects["blInfo"].GetSearchData("ESM_BKG_0680GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
		                    var arrXml=sXml.split("|$$|");
		                    //ETC DATA transaction : 
		                    // OnSearchEnd Event before LoadSearchXml
		                    if(undefined != ComGetEtcData(arrXml[0], "demurType") && ComGetEtcData(arrXml[0], "demurType") != "null"){
		                        document.getElementById("demur_type").value=ComGetEtcData(arrXml[0], "demurType");
		                    }
		                    for(var idx=7; idx < arrXml.length; idx++){
		                        //sheetObjects[sheetNames[idx]].RenderSheet(0);
		                        if(idx > 0) {
		                            sheetObjects[sheetNames[idx]].SetWaitImageVisible(0);
		                        }
		                        sheetObjects[sheetNames[idx]].LoadSearchData(arrXml[idx],{Sync:1} );
		                        //sheetObjects[sheetNames[idx]].RenderSheet(1);
		                    }
        		} , 100);//@ setTimeout end ###########################################################		                    
                
            break;
            case IBSAVE:   //Save
                if(validateForm(sheetObj, formObj, sAction)){
    	        	//check retrieve condition existing change
    	        	if(ComIsNull(formObj.bl_no) && ComIsNull(formObj.bkg_no)){
    	                ComShowCodeMessage('BKG01072'); 
    	                ComSetFocus(formObj.bl_no)
    	                return false;
    	            }
                	formObj.f_cmd.value=MODIFY;
                    //Copy value of Form to Sheet Row
                	if( sheetObjects["refInfo"].RowCount() < 1 || sheetObjects["blIss"].RowCount() < 1  || sheetObjects["cstmsInfo"].RowCount() < 1 ){
                		ComShowMessage(OBJECT_ERROR);
                		return;
                	}
                	
                    CopyFormToRow(formObj, sheetObjects["refInfo"], 1, "");
                    CopyFormToRow(formObj, sheetObjects["blIss"], 1, "");
                    CopyFormToRow(formObj, sheetObjects["cstmsInfo"], 1, "");
                    if(document.getElementsByName("refInfo_do_split_flg")[0].checked == true){
                    	sheetObjects["refInfo"].SetCellValue(1, "refInfo_do_split_flg",'N')
                    }else{
                    	sheetObjects["refInfo"].SetCellValue(1, "refInfo_do_split_flg",'Y')
                    }
                    //check Grid change Y/N
                    if(! sheetObjects["refInfo"].IsDataModified()&& ! sheetObjects["blIss"].IsDataModified()&& ! sheetObjects["cstmsInfo"].IsDataModified()){
                        ComShowCodeMessage("BKG95005");
                        return false;
                    }
                    if( !ComShowCodeConfirm("COM12147" , "data" ) ){
                        return false;
                    }
                    sheetObjects["refInfo"].SetRowStatus(1,"U");
                    sheetObjects["blIss"].SetRowStatus(1,"U");
                    sheetObjects["doRlseSts"].SetRowStatus(1,"U");
                    var sParam1=sheetObjects["refInfo"].GetSaveString();   //India D/O Release Reference Info
                    var sParam2=sheetObjects["blIss"].GetSaveString();     //Original B/L return Y/N, Issue Count and Detail Info
                    var sParam3=sheetObjects["cstmsInfo"].GetSaveString(); //B/L INFO for a customs[india] declaration
                    var aryPrefix=new Array("refInfo_", "blIss_", "cstmsInfo_");    
                    var sparam=sParam1 + "&" + sParam2 + "&" + sParam3 + "&" + FormQueryString(formObj)+ "&" + ComGetPrefixParam(aryPrefix);
                    //parameter changed[check again]CLT                     
                    var sXml=sheetObj.GetSaveData("ESM_BKG_0680GS.do", sparam);
                    //parameter changed[check again]CLT                     
                    sheetObjects["refInfo"].LoadSaveData(sXml);
                    sXml=ComDeleteMsg(sXml); 
                }
                break;
            case MULTI01:// Release
	        	//check retrieve condition existing change
	        	if(ComIsNull(formObj.bl_no) && ComIsNull(formObj.bkg_no)){
	                ComShowCodeMessage('BKG01072'); 
	                ComSetFocus(formObj.bl_no)
	                return false;
	            }
            	// check HOLD 
                if (formObj.refInfo_do_hld_flg.value == "Y") {
                    // B/L was Held
                	ComShowCodeMessage("BKG40061", sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no"));
                    return;
                }
                
                // check OBL Status
                if (formObj.blIss_obl_rdem_flg.value == "N") {
                    // You can't release because B/L Status is "N".
                    // B/L Status will turn "Y" only when one out of items 1) Seaway Bill, 2) O.B/L Surrenderred, 3) O. B/L received, 4) LG received with "accepted" is satified with. please check it.
                    ComShowCodeMessage("BKG40066");
                    return;
                }
                if (formObj.blInfo_cntr_prt_flg.value == "Y") {
                    // The B/L is Partial One
                    ComShowCodeMessage("BKG40063");
                }
                // mandatory in case of not General
                if( formObj.refInfo_ida_do_dmdt_pay_tp_cd[0].selected == false) {
                    document.getElementsByName("refInfo_ida_do_vty_dt")[0].setAttribute("required", true);
                }
                if(!validateForm(sheetObj,formObj,sAction)){
                    // remove temporary mandatory
                    document.getElementsByName("refInfo_ida_do_vty_dt")[0].removeAttribute("required");
                    return ;
                }
                
                // check FOC
                if (!fnCheckFOC()) {
                    return;
                }
                
            	//GAP Display Credit Risk (2014.10.14 An Jin Eung)
            	if(!fnExistBlackListedCustomer(formObj.bkg_no.value)){
//                    return false;
                }
            	
                //Are you sure to Release?
                if(!ComShowCodeConfirm("BKG00673")){
                    return false;
                }
                
                ComOpenWait(true);
                setTimeout( function () { //@ setTimeout ###########################################################
	                	
	                formObj.f_cmd.value=MULTI01;
	                formObj.do_cng_evnt_cd.value="RE";
	                CopyFormToRow(formObj, sheetObjects["doRlseSts"], 1, "");
	                CopyFormToRow(formObj, sheetObjects["blIss"], 1, "");
	                CopyFormToRow(formObj, sheetObjects["refInfo"], 1, "");
	                // protect unusual data to Radio
	                if(document.getElementsByName("refInfo_do_split_flg")[0].checked == true){
	                	sheetObjects["refInfo"].SetCellValue(1, "refInfo_do_split_flg",'N')
	                }else{
	                	sheetObjects["refInfo"].SetCellValue(1, "refInfo_do_split_flg",'Y')
	                }
	                sheetObjects["doRlseSts"].SetRowStatus(1,"U");
	                sheetObjects["blIss"].SetRowStatus(1,"U");
	                sheetObjects["refInfo"].SetRowStatus(1,"U");
	                var aryPrefix=new Array("doRlseSts_", "blIss_");    
	                var sParam1=sheetObjects["doRlseSts"].GetSaveString();
	                var sParam2=sheetObjects["blIss"].GetSaveString();
	                var sParam3=sheetObjects["cntrRlseSts"].GetSaveString();
	                var sParam4=sheetObjects["refInfo"].GetSaveString();
	                var sparam=sParam1 + "&" + sParam2 + "&" + sParam3 + "&" + sParam4 + "&" + FormQueryString(formObj)+ "&" + ComGetPrefixParam(aryPrefix);
	                //parameter changed[check again]CLT                 
	                var sXml=sheetObj.GetSaveData("ESM_BKG_0680GS.do", sparam);
	                //parameter changed[check again]CLT                 
	                sheetObjects["doRlseSts"].LoadSaveData(sXml, {Sync:1} );
	                sXml=ComDeleteMsg(sXml);
	                formObj.refInfo_ida_do_dmdt_pay_tp_cd[0].selected=true;
	                formObj.refInfo_ida_do_vty_dt.value="";
	                
                } , 100);//@ setTimeout end ###########################################################
            break;
            case MULTI02:// Hold
	        	//check retrieve condition existing change
	        	if(ComIsNull(formObj.bl_no) && ComIsNull(formObj.bkg_no)){
	                ComShowCodeMessage('BKG01072'); 
	                ComSetFocus(formObj.bl_no)
	                return false;
	            }
            	if (sheetObjects["blInfo"].LastRow()== 0 ) {return;}
                if (formObj.blInfo_cntr_prt_flg.value == "Y") {
                    // The B/L is Partial One
                    ComShowCodeMessage("BKG40063");
                }
                //Are you sure to Hold?
                if(!ComShowCodeConfirm("BKG00671")){
                    return false;
                }
                formObj.f_cmd.value=MULTI02;
                //setting status to 'U'
                sheetObjects["blInfo"].SetRowStatus(1,"U");
                var aryPrefix=new Array("blInfo_");    
                var sParam1=sheetObjects["blInfo"].GetSaveString();
                var sparam=sParam1 + "&" + FormQueryString(formObj)+ "&" + ComGetPrefixParam(aryPrefix);
                //parameter changed[check again]CLT                 
                var sXml=sheetObj.GetSaveData("ESM_BKG_0680GS.do", sparam);
                //parameter changed[check again]CLT                 
                sheetObjects["blInfo"].LoadSaveData(sXml);
                sXml=ComDeleteMsg(sXml);
            break;
            case MULTI03:// Un-Hold
	        	//check retrieve condition existing change
	        	if(ComIsNull(formObj.bl_no) && ComIsNull(formObj.bkg_no)){
	                ComShowCodeMessage('BKG01072'); 
	                ComSetFocus(formObj.bl_no)
	                return false;
	            }
            	if (sheetObjects["blInfo"].LastRow()== 0 ) {return;}
                formObj.f_cmd.value=MULTI03;
                //setting status to 'U'
                sheetObjects["blInfo"].SetRowStatus(1,"U");
                var aryPrefix=new Array("blInfo_");    
                var sParam1=sheetObjects["blInfo"].GetSaveString();
                var sparam=sParam1 + "&" + FormQueryString(formObj)+ "&" + ComGetPrefixParam(aryPrefix);
                //parameter changed[check again]CLT                 
                var sXml=sheetObj.GetSaveData("ESM_BKG_0680GS.do", sparam);
                //parameter changed[check again]CLT                 
                sheetObjects["blInfo"].LoadSaveData(sXml);
                sXml=ComDeleteMsg(sXml);
            break;
            case REMOVE:// Cancel
/*
        	 //check retrieve condition existing change
        	if(ComIsNull(formObj.bl_no) && ComIsNull(formObj.bkg_no)){
                ComShowCodeMessage('BKG01072'); 
                ComSetFocus(formObj.bl_no)
                return false;
            }
            formObj.f_cmd.value=REMOVE;
            var sparam=FormQueryString(formObj);
            //parameter changed[check again]CLT             
            var sXml=sheetObj.GetSaveData("ESM_BKG_0680GS.do", sparam);
            //parameter changed[check again]CLT             
            sheetObjects["doRlseSts"].LoadSaveData(sXml);
            sXml=ComDeleteMsg(sXml); 
            break;
            */
        	if(ComIsNull(formObj.bl_no) && ComIsNull(formObj.bkg_no)){
                ComShowCodeMessage('BKG01072'); 
                ComSetFocus(formObj.bl_no)
                return false;
            }
             //Are you sure to Cancel?
             if(!ComShowCodeConfirm('BKG00670')){
                 return false;
             }
             formObj.f_cmd.value=REMOVE;
             
             if (document.form.refInfo_do_split_flg[0].checked == true) {
                 document.form.split_flg.value = "N";
             } else {
                 document.form.split_flg.value = "Y";
             }              
             
             if (document.form.refInfo_do_split_flg[0].checked == true) {     //per BL
             	 sheetObjects["doRlseSts"].SetRowStatus(1,"U");
                 sheetObj.DoSave("ESM_BKG_0680GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("doRlseSts_"),-1,0);
             } else {

                 var aryPrefix = new Array("cntrRlseSts_");
                 var sParam1 = sheetObjects["cntrRlseSts"].GetSaveString();
                 var sparam = sParam1 + "&" + FormQueryString(formObj)+ "&" + ComGetPrefixParam(aryPrefix);
                 var sXml = sheetObj.GetSaveData("ESM_BKG_0680GS.do", sparam);

                 sheetObjects["cntrRlseSts"].LoadSaveData(sXml,{Sync:1});
                 sXml = ComDeleteMsg(sXml); 
             }
             
             
         break;
            
        }
    }
    /**
	 * handling process for input validation
	 * @param sheetObj sheet Object
	 * @param formObj  form Object
	 * @param sAction 
	 */
    function validateForm(sheetObj, formObj, sAction){
        var oForm=document.form;
        if(sAction ==IBSAVE){
            if(document.getElementById("blIss_obl_cpy_knt").value < parseInt(document.getElementById("blIss_obl_rdem_knt").value)){
                //The number of B/L Received you inputted is bigger than B/Ls released in B/L Issue Screen.\nYou have input the number in Received field less or the same number of B/L Released.
                ComShowCodeMessage("BKG40065");
                document.getElementById("blIss_obl_rdem_knt").focus();
                return false;
            }
            if(oForm.blIss_obl_rdem_flg.value == "Y"
            	&& sheetObjects["blIss"].GetCellValue(1, "blIss_obl_rdem_knt") > 0
                && oForm.blIss_obl_rdem_knt.value == 0) {
                // You can't change the number of B/L Received "[Value]" by manually inputting
                // Please amend the input to "0" by pressing [RCV Cancel] Button and [Save] Button.
                // Then input the correct Number once again.
                ComShowCodeMessage("BKG40072");
                return false;
            }
        }else if(sAction ==IBSEARCH){
            //trim retrieve condition
            conditionTrim();
            //if(ComIsNull(oForm.bl_no) && ComIsNull(oForm.cntr_no) && ComIsNull(oForm.bkg_no)){
            if(ComIsNull(oForm.bl_no) && ComIsNull(oForm.bkg_no)){
                ComShowCodeMessage("BKG40097");
                ComSetFocus(oForm.bl_no)
                return false;
            }
            if(!ComChkObjValid(oForm.bl_no) || !ComChkObjValid(oForm.bkg_no) || !ComChkObjValid(oForm.cntr_no)) {
                return false;
            }
        }else if(sAction == MULTI01) {  // Release
            if (formObj.refInfo_do_split_flg[1].checked == true
                    && sheetObjects["cntrRlseSts"].GetSaveString() == "") {
                // [{?msg1}] Button is available only when you select Containers by clicking a check box.\nPlease click a check box then press '{?msg1}' Button once again.
                ComShowCodeMessage("BKG40069", "Release");
                return false;
            }
            if(oForm.blIss_obl_rdem_flg.value == "Y"
            	&& sheetObjects["blIss"].GetCellValue(1, "blIss_obl_rdem_knt") > 0
                && oForm.blIss_obl_rdem_knt.value == 0) {
                // You can't change the number of B/L Received "[Value]" by manually inputting
                // Please amend the input to "0" by pressing [RCV Cancel] Button and [Save] Button.
                // Then input the correct Number once again.
                ComShowCodeMessage("BKG40072");
                return false;
            }
            if(document.getElementById("blIss_obl_rdem_flg").value == "N"){
                //'Orgin B/L not released!
                ComShowCodeMessage('BKG40066');
                return false;
            }
        //DEM.DET Retrieve
        }else if(sAction == COMMAND05){
            if(!ComChkObjValid(oForm.exp_del_dt)) {
                return false;
            }
            var toDay=ComGetNowInfo('ymd','-').replace(eval("/-/gi"), "");
            var expDelDt=formObj.exp_del_dt.value.replace(eval("/-/gi"), "");
            if(toDay > expDelDt){
                ComShowCodeMessage('BKG40114', expDelDt);
                return false;
            }
        }
        return true;
    }
    /* *************************************************************
        TRIC SELECT BOX CODE START
    ************************************************************* */
    /**
     * show hide layers <br>
     **/
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
      * draw TRiC SELECT BOX.
      * @param aryPopupData
      * @return
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
     * call popup for select B/L No in case of Container partial 
     */
    function blSelectPopOpen(){
        var sXml=IBS_GetDataSearchXml(sheetObjects["partial"]);
        document.form.xmlData.value=sXml;
        ComOpenPopup("/opuscntr/ESM_BKG_0942.do", 500, 300, "conditionSet", "1,0", true);
    }
     /**
      * select B/L No
      * @param idx
      * @return
      */
    function blNoSelect(idx){
    	document.getElementById("bkg_no").value=sheetObjects["partial"].GetCellValue(idx, "partial_"+"bkg_no");
    	document.getElementById("bl_no").value=sheetObjects["partial"].GetCellValue(idx, "partial_"+"bl_no");
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
      * when typing B/L no reset condition.
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
            try {
                oTbl.removeNode(true);
            }catch(e){}
        }
    }
    /**
     * trim contition
     */
    function conditionTrim(){
        document.getElementById("bl_no").value=document.getElementById("bl_no").value.trim();
        document.getElementById("bkg_no").value=document.getElementById("bkg_no").value.trim();
        document.getElementById("cntr_no").value=document.getElementById("cntr_no").value.trim();
    }
     /**
      * setting by O/BL Received
      * @param obj
      * @return
      */
    function obl_rdem_knt_change(obj){
         var sheetObj=sheetObjects["blIss"];
         if (sheetObj.LastRow()== 0 ) {return;}
			var blTpCd=sheetObj.GetCellValue(1, "blIss_bl_tp_cd");
			var oblRedmFlg=sheetObj.GetCellValue(1, "blIss_obl_rdem_flg");
			var delCntCd=sheetObj.GetCellValue(1, "blIss_del_cnt_cd");
	       if (blTpCd == "S" || blTpCd == "W") {
             // can not Cancel in case of Way Bill, Surrendered
             ComBtnDisable("btn_obl_cancel");
             document.getElementById("blIss_obl_rdem_knt").disabled=true;
             document.getElementById("blIss_bl_otr_doc_rcv_cd").disabled=true;
             document.getElementById("blIss_otr_doc_cgor_flg").disabled=true;
             document.getElementById("blIss_ibd_doc_rcv_flg").disabled=true; // India
         } else if (document.form.blIss_obl_rdem_flg.value == "Y") {
             ComBtnEnable("btn_obl_cancel");
             document.getElementById("blIss_obl_rdem_knt").disabled=false;
             document.getElementById("blIss_bl_otr_doc_rcv_cd").disabled=true;
             document.getElementById("blIss_otr_doc_cgor_flg").disabled=true;
             document.getElementById("blIss_ibd_doc_rcv_flg").disabled=true; // India
         } else {
             ComBtnDisable("btn_obl_cancel");
             document.getElementById("blIss_obl_rdem_knt").disabled=false;
             document.getElementById("blIss_bl_otr_doc_rcv_cd").disabled=false;
             if (document.getElementById("blIss_bl_otr_doc_rcv_cd").selectedIndex > 0) {
                 document.getElementById("blIss_otr_doc_cgor_flg").disabled=false;
             } else {
                 document.getElementById("blIss_otr_doc_cgor_flg").disabled=true;
             }
             /* for india */
             if (document.getElementById("blIss_obl_rdem_knt").value != "" && document.getElementById("blIss_obl_rdem_knt").value.parseInt() > 0) {
                 document.getElementById("blIss_ibd_doc_rcv_flg").disabled=false; // India
             } else if(document.getElementById("blIss_bl_otr_doc_rcv_cd").selectedIndex && document.getElementById("blIss_otr_doc_cgor_flg").selectedIndex > 1) {
                 document.getElementById("blIss_ibd_doc_rcv_flg").disabled=false; // India
             } else {
                 document.getElementById("blIss_ibd_doc_rcv_flg").disabled=true; // India
             }
         }
    }
    /**
     * compose select box from ERP data
     * @param sheetObj
     * @return
     */
    function addSel(sheetObj) {
         var sel=document.form.tot_ots_amt;
         var prefix="otsRcvInfo_";
         for (i=sel.length-1; i>=0; i--){
             sel.options[i]=null
         }
         if(sheetObj.GetCellValue(1, prefix+"tot_ots_sts_cd")=='Y' || sheetObj.GetCellValue(1, prefix+"tot_ots_sts_cd")=='C'){
             // btn_cct disable
             document.getElementById("div_btn_cct").style.visibility="hidden";
             document.getElementById("div_btn_third_cct").style.visibility="hidden";
         } else if(sheetObj.GetCellValue(1, prefix+"tot_ots_sts_cd")=='N'){
             // btn_cct, div_btn_third_cct visible
        	 if (sheetObj.GetCellValue(1, prefix+"cct_ots_curr_cd1") == "N") {
               document.getElementById("div_btn_cct").style.visibility="visible";
             }else {
               document.getElementById("div_btn_cct").style.visibility="hidden";
             }
        	 if (sheetObj.GetCellValue(1, prefix+"n3pty_cct_ots_curr_cd1") == "N") {
               document.getElementById("div_btn_third_cct").style.visibility="visible";
             } else {
               document.getElementById("div_btn_third_cct").style.visibility="hidden";
             }
         } else {
        	 document.form['tot_ots_amt'][0]=new Option(sheetObj.GetCellValue(1, prefix+"tot_ots_amt1"));
 			document.getElementById("tot_ots_amt").className="input2_1";
             // btn_cct disable
             document.getElementById("div_btn_cct").style.visibility="hidden";
             document.getElementById("div_btn_third_cct").style.visibility="hidden";
             return;
         }
         var unit="";
         var amount="";
         var colorFlg="";
         for (j=0; j<5; j++){
        	 unit=sheetObj.GetCellValue(1, "otsRcvInfo_"+"tot_ots_curr_cd"+parseInt(j+1));
        	 amount=sheetObj.GetCellValue(1, "otsRcvInfo_"+"tot_ots_amt"+parseInt(j+1));
             if(! ComIsEmpty(unit)){
	            	if (amount > 0) {
	            		colorFlg="Y";
	            	}
             	    document.form['tot_ots_amt'][j]=new Option(unit+' '+ComAddCommaRun(amount), j);                
             }
         }
         if (colorFlg == "Y") {
         	//setting font : RED, bold
         	document.getElementById("tot_ots_amt").className="input2_1";
         } else {
         	document.getElementById("tot_ots_amt").className="input2";
         }
    }
     /**
      * compose image and recode from TPB data
      * @param tpbStatus
      * @return
      */
    function tpbImgSet(tpbStatus) {
        if(tpbStatus) null ? document.getElementById("tpb_status").value : tpbStatus;
        if(document.getElementById("tpb_status").value == "1"){
            document.getElementById("tpb_icon").src="img/btng_icon_green.gif";
            document.getElementById("tpb_cd").value="C";
            document.getElementById("btn_tpb").style.visibility="visible";
            //tooltip C=Cleared
            document.getElementById("tpb_cd").setAttribute("title", "Cleared");
        }else if(document.getElementById("tpb_status").value == "0"){
            document.getElementById("tpb_icon").src="img/btng_icon_r.gif";
            document.getElementById("tpb_cd").value="P";
            document.getElementById("btn_tpb").style.visibility="visible";
            //tooltip P=Processing
            document.getElementById("tpb_cd").setAttribute("title", "Processing");
        }else{
            document.getElementById("tpb_icon").src="img/btng_icon_g.gif";
            document.getElementById("tpb_cd").value="";
            document.getElementById("btn_tpb").style.visibility="hidden";
            document.getElementById("tpb_cd").removeAttribute("title");  
        }
    }
    /**
     * OBL data clear after OBL Cancel button click
     */
    function oblInit(){
        if (document.getElementById("blIss_obl_rdem_flg").value != "Y" ) {
            // init in case of blIss_obl_rdem_flg = 'Y'
            return;
        }
        document.getElementById("blIss_otr_doc_cgor_flg").value='';
        document.getElementById("blIss_bl_otr_doc_rcv_cd").value='';
        document.getElementById("blIss_obl_rdem_knt").value='0';
        document.getElementById("blIss_ibd_doc_rcv_flg").value='N'; // India
        document.getElementById("blIss_obl_rdem_ofc_cd").value='';
        document.getElementById("blIss_obl_rdem_usr_id").value='';
        document.getElementById("blIss_obl_rdem_dt").value='';
        document.getElementById("bl_surr_rmk_flg").value='';
        document.getElementById("blIss_otr_doc_rcv_ofc_cd").value='';
        document.getElementById("blIss_otr_doc_rcv_usr_id").value='';
        document.getElementById("blIss_otr_doc_rcv_dt").value='';
        document.getElementById("blIss_ibd_doc_rcv_ofc_cd").value=''; // india
        document.getElementById("blIss_ibd_doc_rcv_usr_id").value=''; // india
        document.getElementById("blIss_ibd_doc_rcv_dt").value='';   // india
        //CR : Cancelled O/BL Received
        document.getElementById("do_cng_evnt_cd").value='CR';
        //old value of pre_ctnt [before D/O EVENT]
        document.getElementById("pre_ctnt").value='N';
        //old value of crnt_ctnt [before D/O EVENT]
        document.getElementById("crnt_ctnt").value='Y';
        //setting OBL_CNG_FLG = 'Y'
        document.getElementById("obl_cng_flg").value='Y';
        //setting OB/L Redemption Flg = 'N'
        document.getElementById("blIss_obl_rdem_flg").value="N";
        // disable button
        ComBtnDisable("btn_obl_cancel");
    }
    /************************************************************************************
        IBSHEET OnSaveEnd Event Process Start
    ************************************************************************************/
    /**
     * handling process after ending refInfo save
     * @param sheetObj
     * @param ErrMsg
     * @return
     */
    function refInfo_OnSaveEnd(sheetObj, ErrMsg){
            doActionIBSheet(sheetObj, document.form,IBSEARCH);
    }
    /**
     * handling process after ending doRlseSts save
     * @param sheetObj
     * @param ErrMsg
     * @return
     */
    function doRlseSts_OnSaveEnd(sheetObj, ErrMsg){
            doActionIBSheet(sheetObj, document.form,IBSEARCH);
    }
    /**
     * handling process after ending blInfo save
     * @param sheetObj
     * @param ErrMsg
     * @return
     */
    function blInfo_OnSaveEnd(sheetObj, ErrMsg){
            doActionIBSheet(sheetObj, document.form,IBSEARCH);
    }
    
    /**
     * handling process after ending doRlseStsCntr save
     * @param sheetObj
     * @param ErrMsg
     * @return
     */
    function cntrRlseSts_OnSaveEnd(sheetObj, ErrMsg){
            doActionIBSheet(sheetObj, document.form,IBSEARCH);
    }
   
       
    /************************************************************************************
    /************************************************************************************
        IBSHEET OnSearchEnd Event Process Start
    ************************************************************************************/
    /**
	 * handling process after ending partial retrieve
	 * 
	 * @param sheetObj
	 * @param ErrMsg
	 * @return
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
 	 * handling process after ending blInfo retrieve
 	 * 
 	 * @param sheetObj
 	 * @param ErrMsg
 	 * @return
 	 */
    function blInfo_OnSearchEnd(sheetObj, ErrMsg){
        //Wait Image Show Hidden
        ComOpenWait(false);
        if (ErrMsg == "") {
            if(sheetObj.RowCount()> 0){
                ComCopyRowToForm(sheetObj, 1, form, "");
                //retrieve condition
                document.getElementById("bkg_no").value=sheetObj.GetCellValue(1,"blInfo_bkg_no")
                document.getElementById("bl_no").value=sheetObj.GetCellValue(1,"blInfo_bl_no")
                //append BL_TP_CD to BL_NO
                if(sheetObj.GetCellValue(1,"blInfo_bl_tp_cd") !='B'){
                	document.getElementById("bl_no").value=sheetObj.GetCellValue(1,"blInfo_bl_no")+sheetObj.GetCellValue(1,"blInfo_bl_tp_cd");
                }else{
                	document.getElementById("bl_no").value=sheetObj.GetCellValue(1,"blInfo_bl_no");
                }
                // "Validity Date" validation attribute init by "DMDT Payment Type" 
                if(document.getElementById("refInfo_ida_do_dmdt_pay_tp_cd").options[0].selected == true) {
                    document.getElementById("refInfo_ida_do_vty_dt").removeAttribute("required");
                } else {
                    document.getElementById("refInfo_ida_do_vty_dt").setAttribute("required", true);
                }
                if (sheetObj.GetCellValue(1,"blInfo_lcloblissueflg") == "Y") {
                	ComShowCodeMessage("BKG00667");
                }
                if (document.getElementById("blInfo_cntr_prt_flg").value == "Y") {
                	//setting font : RED, bold
                	document.getElementById("blInfo_cntr_prt_flg").style.color="red";            	
                	document.getElementById("blInfo_cntr_prt_flg").style.fontWeight="bold";
                } else {
                	document.getElementById("blInfo_cntr_prt_flg").style.color="";
                	document.getElementById("blInfo_cntr_prt_flg").style.fontWeight="normal";
                }
                if (document.getElementById("blInfo_soc_flg").value == "Y") {
                	//setting font : RED, bold
                	document.getElementById("blInfo_soc_flg").style.color="red";            	
                	document.getElementById("blInfo_soc_flg").style.fontWeight="bold";
                } else {
                	document.getElementById("blInfo_soc_flg").style.color="";
                	document.getElementById("blInfo_soc_flg").style.fontWeight="normal";
                }
            }
            /*************************************************************
                TPB Setting Start 0 : RED 1 : GREEN -1 : GRAY
            *************************************************************/
            tpbImgSet(document.getElementById("tpb_status").value);
        }else{
            //sheet inti in case of Error
            var resetSheetNames=new Array("blInfo", "refInfo", "cstmsInfo", "cntrRlseSts", "doRlseSts", "blIss", "otsRcvInfo", "demInfo", "demDtl",  "totBlbAmt", "otsRcvPop");
            for(var idx=0; idx < resetSheetNames.length; idx++){
                sheetObjects[resetSheetNames[idx]].RemoveAll();
            }
        }
    }
    /**
  	 * handling process after ending refInfo retrieve
  	 * 
  	 * @param sheetObj
  	 * @param ErrMsg
  	 * @return
  	 */
    function refInfo_OnSearchEnd(sheetObj, ErrMsg){
        if (ErrMsg == "") {
            if(sheetObj.RowCount()> 0){
            	if (sheetObj.GetCellValue(1, "refInfo_do_hld_flg") == "") {
                    sheetObj.SetCellValue(1, "refInfo_do_hld_flg","N",0);
                }
                ComCopyRowToForm(sheetObj, 1, form, "");
                //setting RED or GRAY by Hold Y/N
                if(sheetObj.GetCellValue(1, "refInfo_do_hld_flg") =="N"){
                    document.getElementById("hold_flag").className="input2";
                    //setting by Hold Event :Hold / Un-Hold reference by CargoReleaseOrderBCImpl.java holdDo
                    document.getElementById("evnt_flag").value="H";
                    document.getElementById("hld").style.display="";
                    document.getElementById("uhld").style.display="none";
                }else if(sheetObj.GetCellValue(1, "refInfo_do_hld_flg") =="Y"){
                    document.getElementById("hold_flag").className="input2_1";
                    document.getElementById("hold_flag").value="Hold";
                    //setting by Hold Event :Hold / Un-Hold reference by CargoReleaseOrderBCImpl.java holdDo
                    document.getElementById("evnt_flag").value="R";
                    document.getElementById("hld").style.display="none";
                    document.getElementById("uhld").style.display="";
                }else{
                    document.getElementById("hold_flag").className="input2";
                    //document.getElementById("hold_flag").value = 'Hold'; India D/O (Hold : RED)
                    //setting by Hold Event :Hold / Un-Hold reference by CargoReleaseOrderBCImpl.java holdDo
                    document.getElementById("evnt_flag").value='H';
                    document.getElementById("hld").style.display="";
                    document.getElementById("uhld").style.display="none";
                }
                //setting DO Split Flg 
                //(default : N)
                if (sheetObj.GetCellValue(1, "refInfo_do_split_flg") ==  "Y") {
                    sheetObjects["doRlseSts"].SetVisible(0);
                    sheetObjects["cntrRlseSts"].SetVisible(true);
//                    sheetObjects["cntrRlseSts"].SetSheetHeight(320);
                    document.getElementById("div_remain_cnt").style.visibility="visible";
                    document.getElementsByName("refInfo_do_split_flg")[1].checked=true; 
                } else {
                    sheetObjects["cntrRlseSts"].SetVisible(0);
                    sheetObjects["doRlseSts"].SetVisible(true);
//                    sheetObjects["doRlseSts"].SetSheetHeight(320);
                    document.getElementById("div_remain_cnt").style.visibility="hidden";
                    document.getElementsByName("refInfo_do_split_flg")[0].checked=true; 
                }
                chkRemark();
            } else {
                document.getElementsByName("refInfo_do_split_flg")[0].checked=true; 
            }
        }
    }
    /**
   	 * handling process after ending blIss retrieve
   	 * 
   	 * @param sheetObj
   	 * @param ErrMsg
   	 * @return
   	 */
    function blIss_OnSearchEnd(sheetObj, ErrMsg){
        if (ErrMsg == "") {
            if(sheetObj.RowCount()> 0){
                ComCopyRowToForm(sheetObj, 1, form, "");
            }
            if (document.form.blIss_bl_tp_cd.value == "") {
                document.form.blIss_bl_tp_cd.value="B";
            }
            //Original B/L return Y/N : Y - BLUE, N - RED
            if( document.getElementById("blIss_obl_rdem_flg").value =="Y"){
                document.getElementById("blIss_obl_rdem_flg").style.color="blue";
            }else if(document.getElementById("blIss_obl_rdem_flg").value =="N"){
                document.getElementById("blIss_obl_rdem_flg").style.color="red";
            }
            //setting default to O/BL return Y/N
            document.getElementById("h_ori_obl_rdem_flg").value=document.getElementById("blIss_obl_rdem_flg").value;
            document.getElementById("h_aft_obl_rdem_flg").value=document.getElementById("blIss_obl_rdem_flg").value;
            //old value of BLISS OBL RDEM KNT [before D/O EVENT]
            document.getElementById("pre_ctnt").value=document.getElementById("blIss_obl_rdem_knt").value;
            //setting by O/BL Received
            obl_rdem_knt_change(document.getElementById("blIss_obl_rdem_knt"));
            // OB/L Received Remark Retrieve Button enable and setting 'Y' in case of BL =Surrender
            // other button disable
            if (sheetObj.GetCellValue(1, "blIss_bl_tp_cd") == "S") {
                document.getElementById("bl_surr_rmk_flg").value="Y";
                document.getElementById("bl_surr_rmk_flg").className="input2";
                document.getElementById("btn_bl_surr_rmk").style.visibility="visible";
            } else {
                document.getElementById("bl_surr_rmk_flg").value="";
                document.getElementById("bl_surr_rmk_flg").className="noinput2";
                document.getElementById("btn_bl_surr_rmk").style.visibility="hidden";
            }
            buttonEnableAll();
        }
        //setting value [before O/BL Received]
        document.getElementById("old_obl_rdem_knt").value=sheetObj.GetCellValue(1, "blIss_obl_rdem_knt");
    }
    /**
     * handling process after ending demInfo retrieve
     * 
     * @param sheetObj
     * @param ErrMsg
     * @return
     */
    function demInfo_OnSearchEnd(sheetObj){
        //Wait Image Show Hidden
        ComOpenWait(false);
        ComBtnEnable("btn_dem_retrieve"); //DMDT
        ComBtnEnable("btn_dmdt");         //RCV Cancel
    }
     /**
      * handling process after ending demDtl retrieve
      * 
      * @param sheetObj
      * @param ErrMsg
      * @return
      */
    function demDtl_OnSearchEnd(sheetObj){
        var invTotBilAmt=0;
        //first Container Info
        var fist_cntr_no=sheetObjects["demInfo"].GetCellValue(1, "demInfo_cntr_no");
        for(var idx=1; idx <= sheetObj.RowCount(); idx++){
        	if(fist_cntr_no != sheetObjects["demDtl"].GetCellValue(idx, "demDtl_cntr_no")){
                sheetObjects["demDtl"].SetRowHidden(idx,1);
            }
            // Logic add by SC : invTotBilAmt += parseInt(sheetObjects["demDtl"].CellValue(idx, "demDtl_bil_amt"));
        }
        // Logic add by SC : document.getElementById("invTotBilAmt").value = invTotBilAmt;
    }
     /**
      * handling process after ending totBlbAmt retrieve
      * 
      * @param sheetObj
      * @param ErrMsg
      * @return
      */
     function totBlbAmt_OnSearchEnd(sheetObj, ErrMsg){
         var sel=document.form.tot_bil_amt;
         //SELECT BOX Init
         for (i=sel.length-1; i>=0; i--){
             sel.options[i]=null;
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
             document.form['tot_bil_amt'][0]=new Option('0');
             document.getElementById("demur_sts").style.color='blue';
             document.getElementById("tot_bil_amt").className="input2";
         }
     }
     /**
      * handling process after ending cstmsInfo retrieve
      * 
      * @param sheetObj
      * @param ErrMsg
      * @return
      */
    function cstmsInfo_OnSearchEnd(sheetObj, ErrMsg){
        if (ErrMsg == "") {
            if(sheetObj.RowCount()> 0){
                ComCopyRowToForm(sheetObj, 1, form, "");
            }
        }
    }
    /**
     * handling process after ending otsRcvInfo retrieve
     * 
     * @param sheetObj
     * @param ErrMsg
     * @return
     */
    function otsRcvInfo_OnSearchEnd(sheetObj, ErrMsg){
        if (ErrMsg == "") {
            if(sheetObj.RowCount()> 0){
                ComCopyRowToForm(sheetObj, 1, form, "");
                addSel(sheetObj);
                //Y -> BLUE, N -> RED
                if( document.getElementById("otsRcvInfo_tot_ots_sts_cd").value =='Y'){
                    document.getElementById("otsRcvInfo_tot_ots_sts_cd").style.color='blue';
                }else if(document.getElementById("otsRcvInfo_tot_ots_sts_cd").value =='N'){
                    document.getElementById("otsRcvInfo_tot_ots_sts_cd").style.color='red';
                }
            }
        }
    }
    /**
     * handling process after ending doRlseSts retrieve
     * 
     * @param sheetObj
     * @param ErrMsg
     * @return
     */
    function doRlseSts_OnSearchEnd(sheetObj, ErrMsg){
        if (ErrMsg == "") {
            if(sheetObj.RowCount()> 0){
                //setting D/O status to Hidden Value
                for(var idx=1; idx <= sheetObj.RowCount(); idx++){
                    //keep data before cancel
                	if(sheetObj.GetCellValue(idx, "doRlseSts_rlse_sts_cd") != 'C'){
                		document.getElementById("rlse_sts_cd").value=sheetObj.GetCellValue(idx, "doRlseSts_rlse_sts_cd");
                    }
                    //setting last row
                    if(idx == sheetObj.RowCount()){
                    	document.getElementById("last_rlse_sts_cd").value=sheetObj.GetCellValue(idx, "doRlseSts_rlse_sts_cd");
                    }
                    //control button
                    if(sheetObj.GetCellValue(idx, "doRlseSts_rlse_sts_cd") == 'I'){
                        //enable Release button
                        buttonEnable("btn_assign");
                        buttonEnable("btn_hold");
                    }else if(sheetObj.GetCellValue(idx, "doRlseSts_rlse_sts_cd") == 'D'){
                    }
                }
                //setting D/O no to hidden value
                document.getElementById("h_do_no").value=sheetObj.GetCellValue(1, "doRlseSts_do_no");
                document.getElementById("h_do_no_split").value=sheetObj.GetCellValue(1, "doRlseSts_do_no_split");

                //when all data Cancel 
                if(sheetObj.RowCount() == 1 && sheetObj.GetCellValue(1, "doRlseSts_rlse_sts_cd") == 'C'){
                    document.form.refInfo_do_split_flg[0].disabled = false;
                    document.form.refInfo_do_split_flg[1].disabled = false;
                    
                    if(sheetObjects["cntrRlseSts"].RowCount() > 0){
                    	var splitYn = false;
                        
                        for(var idx=1; idx <= sheetObjects["cntrRlseSts"].RowCount(); idx++){
                        	if (sheetObjects["cntrRlseSts"].GetCellValue(idx, "cntrRlseSts_rlse_sts_cd") == 'R') {
                                splitYn = true;
                            }
                        }

                        //all data is Cancel
                        if(splitYn == false){
                            document.form.refInfo_do_split_flg[0].disabled = false;
                            document.form.refInfo_do_split_flg[1].disabled = false;
                        } else {
                            document.form.refInfo_do_split_flg[0].disabled = true;
                            document.form.refInfo_do_split_flg[1].disabled = true;
                        }
                    }            
                    
                } else {
                    document.form.refInfo_do_split_flg[0].disabled = true;
                    document.form.refInfo_do_split_flg[1].disabled = true;
                }                
                
                //keep data before D/O EVENT
                document.getElementById("pre_ctnt").value=sheetObj.GetCellValue(1, "doRlseSts_rlse_sts_cd");
            } else {
            	if(sheetObjects["cntrRlseSts"].RowCount() > 0){
                    var splitYn = false;
                    
                    for(var idx=1; idx <= sheetObjects["cntrRlseSts"].RowCount(); idx++){
                    	if (sheetObjects["cntrRlseSts"].GetCellValue(idx, "cntrRlseSts_rlse_sts_cd") == 'R') {
                            splitYn = true;
                        }
                    }

                    //all data is Cancel
                    if(splitYn == false){
                        document.form.refInfo_do_split_flg[0].disabled = false;
                        document.form.refInfo_do_split_flg[1].disabled = false;
                    } else {
                        document.form.refInfo_do_split_flg[0].disabled = true;
                        document.form.refInfo_do_split_flg[1].disabled = true;
                    }
                }                 	
            }
        }
    }
    
    /************************************************************************************
        IBSHEET OnSearchEnd Event Process End
    ************************************************************************************/
    /************************************************************************************
        IBSHEET OnClick Event Process Start
    ************************************************************************************/
    /**
     * demInfo double click event handling
     * @param sheetObj
     * @param row
     * @param col
     * @return
     */
    function demInfo_OnDblClick(sheetObj, row, col){
        //first Container Info
    	var click_cntr_no=sheetObj.GetCellValue(row, "demInfo_cntr_no");
        //popup 
        demDtlPopOpen(click_cntr_no)
    }
    /**
     * DEM.DET Detail Popup
     */
    function demDtlPopOpen(cntr_no){
        var sXml=IBS_GetDataSearchXml(sheetObjects["demDtl"]);
        document.form.demDtlXmlData.value=sXml;
        var condition="?";
            condition += "cntr_no="+cntr_no;
//        ComOpenWindow('/opuscntr/ESM_BKG_1072.do'+condition, 'demDtl', 'width=500,height=275');
        ComOpenWindowCenter('/opuscntr/ESM_BKG_1072.do'+condition, 'demDtl', 500, 275, true);
    }
     /**
      * container release status click event handling
      * @param sheetObj
      * @param Row
      * @param Col
      * @param value
      * @return
      */
    function cntrRlseSts_OnClick(sheetObj, row, col, value){
        var colName=sheetObj.ColSaveName(col);
        switch (colName) {
            case "cntrRlseSts_evnt_usr_id":
                if (value != "") {
                    ComUserPopup(value);
                }
                break;
        }
    }
     /**
      * Per B/L release sheet click event handling
      * @param sheetObj
      * @param Row
      * @param Col
      * @param value
      * @return
      */
     function doRlseSts_OnClick(sheetObj, row, col, value){
        var colName=sheetObj.ColSaveName(col);
        switch (colName) {
            case "doRlseSts_evnt_usr_id":
                if (value != "") {
                    ComUserPopup(value);
                }
                break;
        }
     }
    /**
     * preview button click event handling
     */
    function fnPreview() {
        var formObj=document.form;
        if (formObj.refInfo_do_hld_flg.value == "Y") {
            // B/L was Held
            ComShowCodeMessage("BKG00649");
            return;
        }
        var doNo=fnSelectedDoNo("Preview");
        if (doNo == "") {return; }
        rdLoad(formObj, formObj.h_mrd_id.value, formObj.h_mrd_param.value, doNo, "Preview");
    }
    /**
     * print button click event handling
     */
    function fnPrint() {
        var formObj=document.form;
        if (formObj.refInfo_do_hld_flg.value == "Y") {
            // B/L was Held
        	ComShowCodeMessage('BKG40107', sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no"), "Print");
            return;
        }
        var doNo=fnSelectedDoNo("Print");
        if (doNo == "") {return; }
        rdLoad(formObj, formObj.h_mrd_id.value, formObj.h_mrd_param.value, doNo, "Print");
    }
    /**
 	 * RD Loading
 	 * 
 	 * @param formObject
 	 * @param mrdId
 	 * @param mrdParam
 	 * @param doNo
 	 * @param openType
 	 * @return
 	 */
    function rdLoad(formObject, mrdId, mrdParam, doNo, openType) {
    	var appendReport = [];
    	if(mrdId == ""){
            ComShowCodeMessage("BKG40080");
            return;
        }
        formObject.com_mrdPath.value="apps/opus/esm/bkg/inbounddocumentation/cargoreleaseordermgt/cargoreleaseorder/report/"
            + mrdId
            + ".mrd";
        var strArg="/rv ";
        strArg += " form_bkgNo['" + sheetObjects["blInfo"].GetCellValue(1, "blInfo_bkg_no") + "']";
        strArg += " form_doNo['" + doNo + "']";
        strArg += " form_usrId['" + lginUsrId + "']";
        strArg += " form_mainOnly['Y']";
        strArg += " form_ofcCd['" + lginOfcCd + "']";
        strArg += " " + mrdParam;        
        if (openType == "Preview") {
            formObject.com_mrdArguments.value=strArg;
            formObject.com_mrdTitle.value="India Cargo Release Order";
            formObject.com_mrdDisableToolbar.value="";
            formObject.com_mrdBodyTitle.value="India Cargo Release Order";
            ComOpenRDPopup();
        } else if (openType == "Print") {
            var rdParam=strArg + " /riprnmargin /rwait";
            // setting open RD file
            var strPath=RD_path+ formObject.com_mrdPath.value;

            appendReport.push({mrdPath:strPath, mrdParam:RDServer + rdParam});
            directReportDownload(appendReport);
//            viewer.openFile(strPath, RDServer + rdParam, {timeout:1800});
//            viewer.print({isServerSide:true}); 
        } else if (openType == "Survey") {
            formObject.com_mrdArguments.value=strArg;
            formObject.com_mrdTitle.value="India Cargo Release Order Survey Letter";
            formObject.com_mrdDisableToolbar.value="";
            formObject.com_mrdBodyTitle.value="India Cargo Release Order Survey Letter";
            ComOpenRDPopup();
        }
    }
    /**
     * All button enable
     */
    function buttonEnableAll(){
        ComBtnEnable("btn_do_id_save");
        ComBtnEnable("btn_erp");
        ComBtnEnable("btn_dem_retrieve");
        ComBtnEnable("btn_dmdt");
        ComBtnEnable("btn_save");
        ComBtnEnable("btn_hold");
        ComBtnEnable("btn_history");
        ComBtnEnable("btn_form_setup");
        ComBtnEnable("btn_receiverinfo");
        ComBtnEnable("btn_remark");
        ComBtnEnable("btn_assign");
        ComBtnEnable("btn_cancel");
        ComBtnEnable("btn_if");
        ComBtnEnable("btn_dorcancel");
        ComBtnEnable("btn_print");
        ComBtnEnable("btn_receipt");
        ComBtnEnable("btn_preview");
        ComBtnEnable("btn_release");
        ComBtnEnable("btn_unhold");
        fnBtnOblCancelEnable();
    }
    /**
     * button enable or disable in case of OBL cancel is possible
     */
    function fnBtnOblCancelEnable() {
        var sheetObj=sheetObjects["blIss"];
        if (sheetObj.LastRow()== 0 ) {return;}
        if(sheetObj.GetCellValue(1, "blIss_obl_rdem_flg") != "Y") {
            ComBtnDisable("btn_obl_cancel");
            return;
        }
	var blTpCd=sheetObj.GetCellValue(1, "blIss_bl_tp_cd");
	var oblRedmFlg=sheetObj.GetCellValue(1, "blIss_obl_rdem_flg");
	var delCntCd=sheetObj.GetCellValue(1, "blIss_del_cnt_cd");
        if (blTpCd == "S" || blTpCd == "W") {
            // Way Bill, Surrendered can not OB/L Cancel
            document.getElementById("blIss_obl_rdem_flg").value="Y";
            ComBtnDisable("btn_obl_cancel");
        }else if (oblRedmFlg != "Y") {
            // can not cancel in case of not OB/L Redemption
            ComBtnDisable("btn_obl_cancel");
        }else if (delCntCd != lginCntCd) {
            // can not operate if country code of delevery is not equal office code of login user
            ComBtnDisable("btn_obl_cancel");
        } else {
            ComBtnEnable("btn_obl_cancel");
        }
    }
    /**
     * check FOC
     */
    function fnCheckFOC() {
        var formObj=document.form;
        // OB/L Status Check
        if (formObj.blIss_obl_rdem_flg.value != "Y" && formObj.blIss_obl_rdem_flg.value != "C") {
            // Orgin B/L not released!
            ComShowCodeMessage("BKG40066");
            return false;
        }
        // Freight Check
        //keep Remark for Release in case of Freight Received Status != Y
		if(formObj.otsRcvInfo_tot_ots_sts_cd.value == "N"){
            if(!remarkForReleasePop()){
                return false;
            }
        }
        // Customs Check
        // else OKAY
        return true;
    }
    /**
     * retrieve DO History
     */
    function fnShowHistory() {
        //Window open
        var condition="?";
        condition += "bkg_no="+sheetObjects["blInfo"].GetCellValue(1, "blInfo_bkg_no");
	condition += "&bl_no="+sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no");
        ComOpenWindowCenter('ESM_BKG_0711.do'+condition, 'history', 900, 430, false);
    }
    /**
     * call form setup screen
     */
    function fnShowFormSetup(){
        var condition="?";
        condition += "pgmNo=ESM_BKG_0137";
        condition += "&office="+lginOfcCd;
        ComOpenWindowCenter('ESM_BKG_0137_POP.do'+condition, 'setting', 1024, 480, false,"yes");
    }
    /**
     * retrieve Receiver Info
     */
    function fnShowRcvrInfo(){
        var doNo=fnSelectedDoNo("Receiver Info");
        if (doNo == "") {return; }
        //Window Open
        var condition="?";
            condition += "do_no="+doNo;
        ComOpenWindowCenter('ESM_BKG_0936.do'+condition, 'receiverinfo', 800, 330,true);
    }
    /**
     * show remark
     */
    function fnShowRemark() {
        var doNo=fnSelectedDoNo("Remark");
        if (doNo == "") {return; }
        //Window Open
        var condition="?";
            condition += "do_no="+doNo;
        ComOpenWindowCenter('ESM_BKG_1018.do'+condition, 'remark', 530, 290, false);
    }
    /**
     * show Surrender Remark
     */
    function fnShowSurrRemark() {
        //Window Open
        var condition="?";
        condition += "bkg_no="+sheetObjects["blInfo"].GetCellValue(1, "blInfo_bkg_no");
            condition += "&inquery_only=Y";
        ComOpenWindowCenter('ESM_BKG_0400_POP.do'+condition, 'bl_surr_rmk', 900, 300, true);
    }
     /**
      * Remark For Release Popup
      */
    //@ Pop Up에서 모달로 값을 받아야 하나 IE처럼 동기화가 되지않고 값을 받기 전에 다음으로 진행되어,
    //@ CallBack 메소드에서 다시 doAction메소드를 호출 시 체크하여 진행여부를 결정하게 한다.
    var releaseRemarkFlag = false;
     function remarkForReleasePop(){
    	 if(releaseRemarkFlag == false){
	         var condition = "?bkg_no="+sheetObjects["blInfo"].GetCellValue(1, "blInfo_bkg_no");
	         ComOpenPopup("ESM_BKG_0954.do"+condition, 600, 250, "callBack0954", '0,1,1,1,1,1,1', true);
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
	        	 doActionIBSheet(sheetObjects["doRlseSts"], formObject, MULTI01);
        	 } , 100);//@ setTimeout end ###########################################################
         }
      }     
     /**
      * Popup B/L out standing Amount screen
      * @param flag
      * @returns
      */
     function blOutstandingAmountPopOpen(flag){
        if (sheetObjects["otsRcvInfo"].RowCount()== 0) {
             alert("Outstanding Amount 값이 존재하지 않습니다.")
             return;
         }
        sheetObjects["otsRcvPop"].RemoveAll();
         var maxRow=sheetObjects["otsRcvInfo"].LastRow();
        var cellValue="";
        var prefix="otsRcvInfo_";
        var curr_cd="";
        var ots_amt=0;
        for(i=1;i <= maxRow ; i++){
            //setting font color by status
            for(var q=1;q<6;q++){
            	if (flag == true) { // CCT select
            		if (sheetObjects["otsRcvInfo"].GetCellValue(i, prefix + "cct_ots_amt" + q) > 0) {
            			curr_cd=sheetObjects["otsRcvInfo"].GetCellValue(i, prefix + "cct_ots_curr_cd" + q);
            			ots_amt=sheetObjects["otsRcvInfo"].GetCellValue(i, prefix + "cct_ots_amt" + q);
                        sheetObjects["otsRcvPop"].DataInsert(-1);
                        sheetObjects["otsRcvPop"].SetCellValue(sheetObjects["otsRcvPop"].LastRow(), "otsRcvPop_curr_cd",curr_cd,0);
                        sheetObjects["otsRcvPop"].SetCellValue(sheetObjects["otsRcvPop"].LastRow(), "otsRcvPop_tot_ots_amt",ots_amt,0);
                    }
                } else {            // Third Office(CCT)
                	if (sheetObjects["otsRcvInfo"].GetCellValue(i, prefix + "n3pty_cct_ots_amt" + q) > 0) {
                		curr_cd=sheetObjects["otsRcvInfo"].GetCellValue(i, prefix + "n3pty_cct_ots_curr_cd" + q);
                		ots_amt=sheetObjects["otsRcvInfo"].GetCellValue(i, prefix + "n3pty_cct_ots_amt" + q);
                        sheetObjects["otsRcvPop"].DataInsert(-1);
                        sheetObjects["otsRcvPop"].SetCellValue(sheetObjects["otsRcvPop"].LastRow(), "otsRcvPop_curr_cd",curr_cd,0);
                        sheetObjects["otsRcvPop"].SetCellValue(sheetObjects["otsRcvPop"].LastRow(), "otsRcvPop_tot_ots_amt",ots_amt,0);
                    }
                }
            }
        }
        if (sheetObjects["otsRcvPop"].RowCount()> 0) {
            var sXml=IBS_GetDataSearchXml(sheetObjects["otsRcvPop"]);
            document.form.oaXmlData.value=sXml;
            ComOpenPopup("/opuscntr/ESM_BKG_1022.do", 400, 320, "", "1,0", true);
        }
     }
     /**
      * return doNo
      * include common validation
      * @param buttonName
      * @returns 
      */
     function fnSelectedDoNo(buttonName) {
         var sheetObj=null;
         var formObj=document.form;
         var prefix="";
         var doNo="";
         var rlseStsCd="";
         var blNo=""; // for message
         // SHEET select
         if (formObj.refInfo_do_split_flg[0].checked == true) {  // DO Split by Container=N
            prefix="doRlseSts";
            sheetObj=sheetObjects[prefix];
            // SELECTION ROW select
            var sRowStr=sheetObj.GetSelectionRows("|");
            var sRowArr=sRowStr.split("|");
            if (sRowStr != "0" ) {
            	doNo=sheetObj.GetCellValue(sRowArr[0], prefix+ "_do_no") + sheetObj.GetCellValue(sRowArr[0], prefix+ "_do_no_split");
            	rlseStsCd=sheetObj.GetCellValue(sRowArr[0], prefix+ "_rlse_sts_cd");
            }
            if (sheetObj.RowCount() == 0 || doNo.trim() == "" || rlseStsCd != "R") {
                // If you want to go one step further, the B/L [{?msg1}] should be on 'Release' Status. \nPlease press 'Release' button then try it again.
            	ComShowCodeMessage("BKG40059", sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no"));
                return "";
            }
         } else {
            prefix="cntrRlseSts";
            sheetObj=sheetObjects[prefix];
            // CHECK ROW Validation
            var doNoTmp="";
            for (var idx=1; idx <= sheetObj.LastRow(); idx ++) {
            	if (sheetObj.GetCellValue(idx, prefix+"_check") == 1) {
                    // validation for checked Info
            		doNoTmp=sheetObj.GetCellValue(idx, prefix+ "_do_no") + sheetObj.GetCellValue(idx, prefix+ "_do_no_split");
                    if (doNoTmp == "") {
                        // not Release
                    	ComShowCodeMessage("BKG40071", sheetObj.GetCellValue(idx, prefix+ "_cntr_no"));
                        return "";
                    }
                    if (doNo != "" && doNoTmp != doNo) {
                        // in case of selected double DO no
                        // You can't select the Containers which were assigned to different D/O No.
                        // Please check the D/O No of the containers you clicked.
                        // Then, mouse-click the check box of containers with same D/O No and press [value] Button once again.
                        ComShowCodeMessage("BKG40073");
                        return "";
                    }
                    if (doNo == "") {
                        doNo=doNoTmp;
                    }
                }
            }
            if (doNo.trim() == "") {
                // [{?msg1}] Button is available only when you select Containers by clicking a check box.\nPlease click a check box then press '{?msg1}' Button once again.
                ComShowCodeMessage("BKG40069", buttonName);
                return "";
            }
         }
         return doNo;
     }
     /**
      * adjustment max line of Hold / Internal Remark 
      * @param obj
      * @returns 
      */
     function fncTextareaMaxLine(obj)
     {
         var str_line=obj;
         line=str_line.split("\r\n");
         ln=line.length;
         if(ln == 5 && event.keyCode == 13){
             event.returnValue=false;
         }
     }
    /**
     * retrieve Booking No and B/L No by container No.
     */
    function fnSearchContainer(){
        var formObj=document.form;
        if (ComIsNull(formObj.cntr_no)) return;
        if(document.getElementById("h_cntr_no").value == document.getElementById("cntr_no").value) {
            return;
        }
        //protecting duplicate retrieve
        document.getElementById("h_cntr_no").value=document.getElementById("cntr_no").value;
        //call popup
        formObj.f_cmd.value=SEARCH01;
        //parameter changed[check again]CLT         
        sheetObjects["partial"].DoSearch("ESM_BKG_0292GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("partial_") );
    }
     /**
      * checking remark
      */
     function chkRemark() {
  	   if (document.form.refInfo_inter_rmk.value.length > 0 ) {
  		   // not existing data
  		   buttonColorSet("btn_hold_remark", "red");
  	   } else {
  		   // existing data
  		   buttonColorSet("btn_hold_remark", "gray");
  	   }
     }
      /**
       * disable button
       * @param  btn_name
       * @param color
       * @return
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
     /**
      * setting remark
      * @param  remark
      * @return
      **/
     function funcSetRemark(remark) {
       document.form.refInfo_inter_rmk.value=remark;
  	   chkRemark();
     }

     
     function fnButtonControl(){
         var rlse_sts_cd=document.form.rlse_sts_cd.value;
         var holdFlg=document.form.evnt_flag.value;
         if (sheetObjects["blInfo"].RowCount()== 0) {
             buttonDisabledAll();
             ComBtnEnable("btn_Retrieve");
             return;
         }
         if (holdFlg == "R") {
             ComBtnEnable("btn_Retrieve");
             ComBtnEnable("btn_save");
             ComBtnEnable("btn_history");
             ComBtnDisable("btn_release");
             ComBtnDisable("btn_cancel");
             if (rlse_sts_cd == "R") {
                 ComBtnDisable("btn_preview");
                 ComBtnDisable("btn_print");
                 ComBtnEnable("btn_receiverinfo");
                 ComBtnEnable("btn_remark");
             } else {
                 ComBtnDisable("btn_preview");
                 ComBtnDisable("btn_print");
                 ComBtnDisable("btn_receiverinfo");
                 ComBtnDisable("btn_remark");
             }
             document.getElementById("btn_hold").style.display="none";
             document.getElementById("btn_unhold").style.display="";
             ComBtnEnable("btn_unhold")
             ComBtnDisable("btn_hold")
         } else {
         	document.getElementById("btn_hold").style.display="";
             document.getElementById("btn_unhold").style.display="none";
         	ComBtnEnable("btn_hold")
             ComBtnDisable("btn_unhold")
             if (rlse_sts_cd == "") {
                 ComBtnEnable("btn_Retrieve");
                 ComBtnEnable("btn_save");
                 ComBtnDisable("btn_preview");
                 ComBtnDisable("btn_print");
                 ComBtnEnable("btn_release");
                 ComBtnEnable("btn_history");
                 ComBtnDisable("btn_receiverinfo");
                 ComBtnDisable("btn_cancel");
                 ComBtnDisable("btn_remark");
             } else if (rlse_sts_cd == "R") {
                 ComBtnEnable("btn_Retrieve");
                 ComBtnEnable("btn_save");
                 ComBtnEnable("btn_preview");
                 ComBtnEnable("btn_print");
                 ComBtnDisable("btn_release");
                 ComBtnEnable("btn_history");
                 ComBtnEnable("btn_receiverinfo");
                 ComBtnEnable("btn_cancel");
                 ComBtnEnable("btn_remark");
             }
         }
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
 
     
     function fnReleaseYn() {
         var formObj = document.form;
         var chkCount=0;
         chkRowCnt=0;
         if(sheetObjects["blInfo"].RowCount()== 0) return false;
         
         if (document.form.refInfo_do_split_flg[0].checked == true) {
             document.form.split_flg.value = "N";
         } else {
             document.form.split_flg.value = "Y";
         }   
         
         if (formObj.split_flg.value == "N") {
             chkRowCnt=1;
             
        	 chkRowCount = 0;
        	 chkReleaseCount = 0;
        	 chkNoReleaseCount = 0;
             
             if(sheetObjects["doRlseSts"].RowCount()== 1 && sheetObjects["doRlseSts"].GetCellValue(1, "doRlseSts_rlse_sts_cd") == 'R'){
                 return true;
             } else {
                 return false;
             }
         } else {
             if(sheetObjects["cntrRlseSts"].RowCount()> 0) {
            	 chkRowCount = 0;
            	 chkReleaseCount = 0;
            	 chkNoReleaseCount = 0;
            	 
                 if (sheetObjects["cntrRlseSts"].CheckedRows("cntrRlseSts_check") != 0) {
                     // read row of check row in case of SaveName = 'Pass_yn'
                     var iCheckRow2=sheetObjects["cntrRlseSts"].FindCheckedRow("cntrRlseSts_check");
                     // composition array
                     var arrRow=iCheckRow2.split("|");
                     
                     var releaseYn = "";
                     
                     chkRowCount = arrRow.length;
                     
                     for (idx=0; idx<arrRow.length; idx++){
                         chkRowCnt=chkRowCnt + 1;
                         if (sheetObjects["cntrRlseSts"].GetCellValue(arrRow[idx], "cntrRlseSts_rlse_sts_cd") == 'R') {
                        	 chkReleaseCount = chkReleaseCount + 1;
                      	     releaseYn = "Y";
                         } else {
                        	 chkNoReleaseCount = chkNoReleaseCount + 1;
                        	 releaseYn = "";
                         }
                     }
                     
//                     if (releaseYn == "Y") {
//                     	return true;
//                     } else {
//                     	return false;
//                     }
                     if (chkRowCount == chkReleaseCount) {
                    	 return true;
                     } else {
                    	 return false;
                     }
                     
                 } else {
                     // no checked row
                     chkRowCnt=0;
                     return false;
                 }
             } else {
                 return false;
             }
         }
     }     