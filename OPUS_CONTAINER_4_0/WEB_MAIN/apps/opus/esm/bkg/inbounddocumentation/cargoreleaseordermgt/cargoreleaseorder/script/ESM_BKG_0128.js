/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0128.js
*@FileTitle  : General Cargo Release (D/O)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/30
=========================================================*/
/****************************************************************************************
Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @fileoverview business script for General Cargo Release (D/O)
     * @author 
     */
	/* developer job	*/
	// common global variables
    var sheetObjects=new Array();
    var sheetCnt=0;
//    var sheetNames=new Array("blInfo", "doRlseSts", "demInfo", "demDtl",  "totBlbAmt", "partial");
    var sheetNames   = new Array("blInfo", "doRlseStsCntr", "doRlseStsBl", "demInfo", "demDtl",  "totBlbAmt", "partial");
    var comboObjects=new Array();
    var comboCnt=0;
    var comboFlg=null;
    var chkRowCnt=0;
    
    var chkRowCount = 0;
    var chkReleaseCount = 0;
    var chkNoReleaseCount = 0;
    
	// Event handler processing by button click event
    document.onclick=processButtonClick;
	// Event handler processing by button name
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
                    doActionIBSheet(sheetObjects["blInfo"], formObject,IBSAVE);
                break;
                //Preview
                case "btn_preview":
                    if (releaseYn == false) {
                        // in case of per BL
                        if (formObject.refInfo_do_split_flg.value == "N") {
                            if (sheetObjects["doRlseStsBl"].RowCount() > 0 && chkRowCnt == 0) {
                                ComShowCodeMessage("BKG40069", "Preview");
                            } else {
                                //alert message
                                var blNo = "";
                                if (sheetObjects["blInfo"].RowCount() > 0) {
                                    blNo = sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no");
                                }
                                ComShowCodeMessage("BKG40059", blNo);
                            }
                        } else {
                            if (sheetObjects["doRlseStsCntr"].RowCount() > 0 && chkRowCnt == 0) {
                                ComShowCodeMessage("BKG40069", "Preview");
                            } else {
                                var blNo = "";
                                if (sheetObjects["blInfo"].RowCount() > 0) {
                                    blNo = sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no");
                                }
                                ComShowCodeMessage("BKG40071", blNo);
                            }
                        }
                        return;
                    }

                    if (sheetObjects["blInfo"].RowCount() == 0) {
                        ComShowCodeMessage("BKG40060");
                        return;
                    }
                    //get RD Info
                    if (document.form.split_flg[0].checked == true) {
                        doNo = sheetObjects["doRlseStsBl"].GetCellValue(1, "doRlseStsBl_do_no");       //per BL
                    } else {

                        doNo = fnFindDoNo();

                        if (doNo == "") {
                            var blNo = "";
                            if (sheetObjects["blInfo"].RowCount() > 0) {
                                blNo = sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no");
                            }
                            ComShowCodeMessage("BKG40059", blNo);
                            return;
                        }
                    }
                    var mrdId = formObject.h_mrd_id.value;
                    var mrdParam = formObject.h_mrd_param.value;

                    if(mrdId == ""){
                        ComShowCodeMessage("BKG40080");
                        return;
                    }

                    if(doNo == ""){
                        var blNo = "";
                        if (sheetObjects["blInfo"].RowCount() > 0) {
                            blNo = sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no");
                        }
                        ComShowCodeMessage("BKG40059", blNo);
                        return;
                    }

                    formObject.com_mrdPath.value = "apps/opus/esm/bkg/inbounddocumentation/cargoreleaseordermgt/cargoreleaseorder/report/"
                        + mrdId
                        + ".mrd";
                    var strArg = "/rv ";
                    strArg += " form_doNo['" + doNo + "']";
                    strArg += " form_bkgNo['" + sheetObjects["blInfo"].GetCellValue(1, "blInfo_bkg_no") + "']";
                    strArg += " form_usrId['" + strUsr_id + "']";
                    strArg += " form_bkgNo['" + sheetObjects["blInfo"].GetCellValue(1, "blInfo_bkg_no") + "']";
                    strArg += " form_ofcCd['" + lginOfcCd + "']";
                    strArg += " form_mainOnly[N]";
                    strArg += " " + mrdParam;
                  
                    formObject.com_mrdArguments.value = strArg;
                    formObject.com_mrdTitle.value = "Cargo Release Order";
                    formObject.com_mrdDisableToolbar.value = "";
                    formObject.com_mrdBodyTitle.value = "Cargo Release Order";
                    ComOpenRDPopup();

                    break;                	
                	
//                    preview();
//                break;
                case "btn_release":
                	
//                    if (document.form.rlse_sts_cd.value == 'R') {
//                        ComShowCodeMessage("BKG00778");
//                        return;
//                    }
                	
                    //Hold check refInfo ==> blInfo
                    if (sheetObjects["blInfo"].GetCellValue(1, "blInfo_do_hld_flg") =='Y') {
                        var blNo="";
                        if (sheetObjects["blInfo"].RowCount()> 0) {
                        	blNo=sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no");
                        }
                        ComShowCodeMessage('BKG40107', blNo, "Release");
                        return;
                    }

                    
                    if (releaseYn == true  || chkReleaseCount > 0) {
                        ComShowCodeMessage("BKG00778");
                        return;
                    }
                    
                    if (document.form.split_flg[0].checked == true) {
                        doActionIBSheet(sheetObjects["doRlseStsBl"], formObject, MULTI01);
                    } else {
                        if (chkRowCnt == 0) {
                            ComShowCodeMessage("BKG40069", "Release");
                            return;
                        }

                        doActionIBSheet(sheetObjects["doRlseStsCntr"], formObject, MULTI01);
                    }
                    
//                    doActionIBSheet(sheetObjects["doRlseSts"], formObject, MULTI01);
                break;
                //Hold
                case "btn_hold":
                    if (formObject.blInfo_cntr_prt_flg.value == "Y") {
                        ComShowCodeMessage("BKG40074");
                        //The B/L is Partial One
                        return;
                    }
                    doActionIBSheet(sheetObjects["blInfo"], formObject, MULTI04);
                break;
                //Un-Hold
                case "btn_unhold":
                    doActionIBSheet(sheetObjects["blInfo"], formObject, MULTI04);
                break;
                //History
                case "btn_history":
                    //Window Open
                	var bl_tp_cd=sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_tp_cd");
                    if (bl_tp_cd == "B") {
                        bl_tp_cd="";
                    }
                    var condition="?";
                    condition += "bkg_no="+sheetObjects["blInfo"].GetCellValue(1, "blInfo_bkg_no");
                    condition += "&bl_no="+sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no");
                        condition += "&bl_tp_cd="+bl_tp_cd+"&pgmNo=ESM_BKG_0711";
                    ComOpenWindowCenter('ESM_BKG_0711.do'+condition, 'history', 800, 430, false);
                break;
                case "btn_form_setup":
                    var condition="?";
                        condition += "pgmNo=ESM_BKG_0137";
                        condition += "&office="+lginOfcCd;
                        ComOpenWindowCenter('ESM_BKG_0137_POP.do'+condition, 'setting', 1024, 480, false,"yes");
                break;
                //Receiver Info.
                case "btn_receiverinfo":
//                    var doNo="";
//                    doNo=sheetObjects["doRlseSts"].GetCellValue(1, "doRlseSts_do_no");       //BL 단위
//                    var condition="?";
//                        condition += "do_no="+doNo+"&pgmNo=ESM_BKG_0130";
//                    ComOpenWindowCenter('ESM_BKG_0130.do'+condition, 'receiverinfo', 500, 260,true);

                    if (releaseYn == false) {
                        // in case per BL
                        if (formObject.refInfo_do_split_flg.value == "N") {
                            if (sheetObjects["doRlseStsBl"].RowCount() > 0 && chkRowCnt == 0) {
                                ComShowCodeMessage("BKG40069", "Receiver Info.");
                            } else {
                                //alert message
                                var blNo = "";
                                if (sheetObjects["blInfo"].RowCount() > 0) {
                                    blNo = sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no");
                                }
                                ComShowCodeMessage("BKG40059", blNo);
                            }
                        } else {
                            if (sheetObjects["doRlseStsCntr"].RowCount() > 0 && chkRowCnt == 0) {
                                ComShowCodeMessage("BKG40069", "Receiver Info.");
                            } else {
                                var blNo = "";
                                if (sheetObjects["blInfo"].RowCount() > 0) {
                                    blNo = sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no");
                                }
                                ComShowCodeMessage("BKG40071", blNo);
                            }
                        }
                        return;
                    }

                    var doNo = "";

                    if (document.form.split_flg[0].checked == true) {
                        doNo = sheetObjects["doRlseStsBl"].GetCellValue(1, "doRlseStsBl_do_no");       // per BL
                    } else {

                        doNo = fnFindDoNo();

                        if (doNo == "") {
                            var blNo = "";
                            if (sheetObjects["blInfo"].RowCount() > 0) {
                                blNo = sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no");
                            }
                            ComShowCodeMessage("BKG40059", blNo);
                            return;
                        }
                    }

                    var condition="?";
                    condition += "do_no="+doNo+"&pgmNo=ESM_BKG_0130";
                    ComOpenWindowCenter('ESM_BKG_0130.do'+condition, 'receiverinfo', 530, 200,false);
                break;
                //Cancel
                case "btn_cancel":
                	if (sheetObjects["blInfo"].GetCellValue(1, "blInfo_do_hld_flg") =='Y') {
                        var blNo="";
                        if (sheetObjects["blInfo"].RowCount()> 0) {
                        	blNo=sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no");
                        }
                        ComShowCodeMessage('BKG40107', blNo, "Cancel");
                        return;
                    }
                	
                    
                    if (releaseYn == false) {
                        // in case of per BL
                        if (formObject.refInfo_do_split_flg.value == "N") {
                            if (sheetObjects["doRlseStsBl"].RowCount() > 0 && chkRowCnt == 0) {
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
                            if (sheetObjects["doRlseStsCntr"].RowCount() > 0 && chkRowCnt == 0) {
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

                    if (document.form.split_flg[0].checked == true) {
                        doActionIBSheet(sheetObjects["doRlseStsBl"], formObject, MULTI02);      // per BL
                    } else {
                        doActionIBSheet(sheetObjects["doRlseStsCntr"], formObject, MULTI02);    // per Cntr
                    }                	
                	
//                    doActionIBSheet(sheetObjects["doRlseSts"], formObject, MULTI02);//BL unit

                	
                break;
                //Remark
                case "btn_remark":
                    //Window Open
//                    var condition="?";
//                        condition += "do_no="+document.getElementById("h_do_no").value+"&pgmNo=ESM_BKG_1018";
//                    ComOpenWindowCenter('ESM_BKG_1018.do'+condition, 'remark', 530, 290, false);
                	
                    if (releaseYn == false) {
                        //in case of per BL
                        if (formObject.refInfo_do_split_flg.value == "N") {
                            if (sheetObjects["doRlseStsBl"].RowCount() > 0 && chkRowCnt == 0) {
                                ComShowCodeMessage("BKG40069", "Remark(s)");
                            } else {
                                //alert message
                                var blNo = "";
                                if (sheetObjects["blInfo"].RowCount() > 0) {
                                    blNo = sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no");
                                }
                                ComShowCodeMessage("BKG40059", blNo);
                            }
                        } else {
                            if (sheetObjects["doRlseStsCntr"].RowCount() > 0 && chkRowCnt == 0) {
                                ComShowCodeMessage("BKG40069", "Remark(s)");
                            } else {
                                var blNo = "";
                                if (sheetObjects["blInfo"].RowCount() > 0) {
                                    blNo = sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no");
                                }
                                ComShowCodeMessage("BKG40071", blNo);
                            }
                        }
                        return;
                    }
                    var condition = "?";

                    condition += "do_no="+document.getElementById("h_do_no").value+"&pgmNo=ESM_BKG_1018";

                    ComOpenWindowCenter('ESM_BKG_1018.do'+condition, 'remark', 530, 230, false);                	
                	
                break;
                //Print
                case "btn_print":
//                    if (sheetObjects["blInfo"].RowCount()== 0) {
//                        ComShowCodeMessage("BKG40060");
//                        return;
//                    }
//                    rdLoad();

                	if (releaseYn == false) {
                        //in case of per BL
                        if (formObject.refInfo_do_split_flg.value == "N") {
                            if (sheetObjects["doRlseStsBl"].RowCount() > 0 && chkRowCnt == 0) {
                                ComShowCodeMessage("BKG40069", "Print");
                            } else {
                                //alert message
                                var blNo = "";
                                if (sheetObjects["blInfo"].RowCount() > 0) {
                                    blNo = sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no");
                                }
                                ComShowCodeMessage("BKG40059", blNo);
                            }
                        } else {
                            if (sheetObjects["doRlseStsCntr"].RowCount() > 0 && chkRowCnt == 0) {
                                ComShowCodeMessage("BKG40069", "Print");
                            } else {
                                var blNo = "";
                                if (sheetObjects["blInfo"].RowCount() > 0) {
                                    blNo = sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no");
                                }
                                ComShowCodeMessage("BKG40071", blNo);
                            }
                        }
                        return;
                    }

                    if (sheetObjects["blInfo"].RowCount() == 0) {
                        ComShowCodeMessage("BKG40060");
                        return;
                    }

	                    rdLoad();
                break;
                case "img_exp_del_dt":
                    var cal=new ComCalendar();
                    cal.select(formObject.exp_del_dt, 'yyyy-MM-dd');
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
                        ComOpenWindowCenter('ESD_TPB_0134.do'+condition, 'TPB', 1024, 318, true);
                break;
                case "btn_bl_surr_rmk":
                    var condition="?";
                    condition += "bkg_no="+sheetObjects["blInfo"].GetCellValue(1, "blInfo_bkg_no");
                        condition += "&inquery_only=Y"+"&pgmNo=ESM_BKG_0400";
                    ComOpenWindowCenter('ESM_BKG_0400.do'+condition, 'bl_surr_rmk', 900, 300, true);
                break;
                //OBL Cancel
                case "btn_obl_cancel":
                    if (sheetObjects["blInfo"].LastRow()== 0 ) {return;}
                    oblInit();
                break;
                case "btn_dem_retrieve":
                    doActionIBSheet(sheetObjects["blInfo"], formObject,COMMAND05);
                break;
                case "btn_dmdt":
                	var bkgNo=sheetObjects["blInfo"].GetCellValue(1, "blInfo_bkg_no");
                	var blNo=sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no");
                    var trfCd=document.getElementById("demur_type").value;
                    var paramVal="?call_flag=P&bkg_no=" + bkgNo + "&bl_no=" + blNo + "&dmdt_trf_cd=" + trfCd+"&pgmNo=EES_DMT_3002P";
                    ComOpenWindowCenter('EES_DMT_3002P.do' + paramVal, 'dmdt', 1050, 670, false,"yes");
                break;
                case "btn_cy":
                    var condition="?";
                        condition += "do_no="+document.getElementById("h_do_no").value;
                        condition += "&pgmNo=ESM_BKG_1035";
                        condition += "&bkg_no="+sheetObjects["blInfo"].GetCellValue(1, "blInfo_bkg_no"); //2009-12-29 임진영 추가
                    ComOpenWindowCenter('ESM_BKG_1035.do'+condition, 'cy', 430, 190, true);
                break;
                case "btn_hold_remark":
                    var paramVal="?sheet_name=B&pgmNo=ESM_BKG_1089";
                    ComOpenWindowCenter('ESM_BKG_1089.do' + paramVal, 'remark', 600, 270, false);
                break;
                
//                case "btn_dubai_preview":
//                	dubaiPreview();
//                	break;
                	
                
                case "btn_bl_surr_flg":
                    var condition="?";
                    condition += "bkg_no="+ sheetObjects["blInfo"].GetCellValue(1, "blInfo_bkg_no");
                        condition += "&inquery_only=Y";
                        condition += "&pgmNo=ESM_BKG_0400";
                    ComOpenWindowCenter('/opuscntr/ESM_BKG_0400_POP.do'+ condition, 'bl_surr_rmk', 900, 300, false);
                break;                
                case "btn_close":
                   	ComClosePopup(); 
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
    
	/**
	 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items 
	 * defining list on the top of source
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
        for(i=0;i<sheetNames.length;i++){
          	if(sheetObjects[sheetNames[i]].id =='doRlseStsCntr' || sheetObjects[sheetNames[i]].id =='doRlseStsBl'|| sheetObjects[sheetNames[i]].id =='demInfo'){            	
                ComConfigSheet (sheetObjects[sheetNames[i]] );
            }
            initSheet(sheetObjects[sheetNames[i]],i+1);
            if(sheetObjects[sheetNames[i]].id =='doRlseStsCntr' || sheetObjects[sheetNames[i]].id =='doRlseStsBl'|| sheetObjects[sheetNames[i]].id =='demInfo'){
                ComEndConfigSheet(sheetObjects[sheetNames[i]]);
            }
        }
        initControl();
        ComSetFocus(document.form.bl_no)
        buttonDisabledAll();
        if(document.getElementById("bkg_no").value !='' ){
            doActionIBSheet(sheetObjects["blInfo"], document.form,IBSEARCH);
        }
    
//        initRdConfig(rdObjects[0]);
    }

    /**
     * Rd Print setting
     */
    function initRdConfig(rdObject) {
    	var viewer=rdObject;
    	viewer.AutoAdjust=true;
    	viewer.ViewShowMode(0);
    	viewer.IsShowDlg=0;
    	viewer.SetBackgroundColor(128, 128, 128);
    	viewer.ApplyLicense("0.0.0.0");
    	viewer.SetPageLineColor(128, 128, 128);
    	viewer.style.height = 0;
       
    }    
    
  	/**
    * Dynamically load HTML Control event in page. <br>
    * Initialize IBSheet Object by calling this function from {@link #loadPage} function.
    * @param {ibsheet} sheetObj    IBSheet Object
    * @param {int}     sheetNo     sheetObjects list in turn
    **/
    function initControl(){
        axon_event.addListenerForm('keydown' , 'obj_keypress'   , form);
//    	axon_event.addListenerForm('keydown', 'ComKeyEnter', form);
        axon_event.addListenerForm('change'   , 'obj_change'     , form);
        axon_event.addListenerForm('click'    , 'obj_click'      , form);
        axon_event.addListenerForm('blur'     , 'obj_deactivate' , form);
    }
     
    /************************************************************************************
    화면에서 발생하는 이벤트 처리 시작
************************************************************************************/

 /**
  * HTML Control의 onkeypress 이벤트 처리.
  */
 function obj_keypress(){

     var keyCode = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
     var srcName = window.event.srcElement.getAttribute("name");
     
     // 엔터키(13)이면
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
     // 2009-10-26 임진영 D/O 공통 적용
     else if (keyCode == 13 && srcName == 'exp_del_dt') {
         //기본정보가 조회 된 상태가 아니면 엔터키를 입력해도 조회 하지 않는다.
         if(sheetObjects["blInfo"].GetCellValue(1,"blInfo_bkg_no") != undefined){
             doActionIBSheet(sheetObjects["blInfo"], document.form, COMMAND05);
         }
     }


 }
    
    /**
     * HTML Control onClick event.
     */
    function obj_click(){
        if (ComGetEvent("name") == "bl_no") {
            showHideLayers();
        }
    }
     /**
      * change form field
      * 
      */
   //@ 조회 후 세팅시 bkg_no bl_no conditionReset발생 안하게 하기 위함 
    var onchangeFlag = true;
    function obj_change(){
        var oForm=document.form;
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
        // blIss ==> blInfo
        if(ComGetEvent("name") == 'blInfo_obl_rdem_knt' || ComGetEvent("name") == 'blInfo_bl_otr_doc_rcv_cd' || ComGetEvent("name") == 'blInfo_otr_doc_cgor_flg'){
            if (event.srcElement.name == 'blInfo_bl_otr_doc_rcv_cd') {
                if (document.getElementById("blInfo_bl_otr_doc_rcv_cd").selectedIndex > 0) {
                    document.getElementById("blInfo_otr_doc_cgor_flg").disabled=false;
                    document.getElementById("blInfo_otr_doc_cgor_flg").value='N';
                } else {
                    document.getElementById("blInfo_otr_doc_cgor_flg").selectedIndex=0;
                    document.getElementById("blInfo_otr_doc_cgor_flg").disabled=true;
                }
            }
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
     * handling obj_deactivate event
     */
    function obj_deactivate(){
        var objName=ComGetEvent("name");
        var formObj=document.form;
        if(blLayer.style.visibility == "visible"){
            blLayer.style.visibility="hidden";
        }
        switch(objName) {
        	
        }
        /*****************************************
        switch(objName) {
            case "exp_del_dt":
                ComChkObjValid(event.srcElement);
            break;
      
        *****************************************/
    }
  
    /**
     * disable all buttons
     */
    function buttonDisabledAll(){
        ComBtnDisable("btn_obl_cancel");
        ComBtnDisable("btn_erp");
        ComBtnDisable("btn_dem_retrieve");
        ComBtnDisable("btn_dmdt");
        ComBtnDisable("btn_save");
        ComBtnDisable("btn_hold");
        ComBtnDisable("btn_history");
        ComBtnDisable("btn_preview");
        ComBtnDisable("btn_remark");
        ComBtnDisable("btn_release");
        ComBtnDisable("btn_cancel");
        ComBtnDisable("btn_print");
        ComBtnDisable("btn_receiverinfo");
        ComBtnDisable("btn_unhold");
        ComBtnDisable("btn_cct");
        ComBtnDisable("btn_third_cct");
//        ComBtnDisable("btn_dubai_preview");
        if(lginCntCd == "VN") {
            ComBtnEnable("btn_cy");
        }else{
            ComBtnDisable("btn_cy");
        }
        document.getElementById("btn_bl_surr_flg").style.visibility="hidden";
        document.getElementById("btn_tpb").style.visibility="hidden";
    }
    /**
     * initialize all form value
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
//        var resetSheetNames=new Array("blInfo", "doRlseSts", "demInfo", "demDtl",  "totBlbAmt");
        var resetSheetNames = new Array("blInfo", "doRlseStsCntr", "doRlseStsBl", "demInfo", "demDtl",  "totBlbAmt");
        for(var idx=0; idx < resetSheetNames.length; idx++){
            sheetObjects[resetSheetNames[idx]].RemoveAll();
        }
        // refInfo ==> blInfo
        document.getElementById("blInfo_inter_rmk").value="";
        // blIss ==> blInfo
        document.getElementById("blInfo_otr_doc_cgor_flg").value='';
        document.getElementById("blInfo_bl_otr_doc_rcv_cd").value='';
        document.getElementById("blInfo_ibd_doc_rcv_flg").value='';
        document.getElementById("tot_ots_amt").value='';
        document.getElementById("tot_bil_amt").value='';
    }
     /**
      * setting sheet initial values and header
      * param : sheetObj, sheetNo
      * adding case as numbers of counting sheets
      */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetObj.id) {
            case "blInfo":
                with (sheetObj) {
	                var HeadTitle=" |POR|POL|POD|DEL|DELTerm|DELTerm Desc|ArrivalVessel|ETA|PKG1|PKG2|WGT1|WGT2|MEA1|MEA2|Partial|SOC|Consignee Nm|Consignee Addr|Notify Nm|Notify Addr|Shipper Nm|Shipper Addr|Split_flg|BKG NO|BL NO|BL TP CD|DSCH_LOC|OBL_ISS_RMK" +
	                " |INTER_RMK|DO_HLD_FLG|CSTMS_REF_NM|CSTMS_REF_CTNT|CSTMS_ASGN_NM|CSTMS_ASGN_CTNT|CY_OP_CD|INFO_CGO_FLG|SPLIT_FLG" +
	                " |BL회수여부|BL발행통수|O/BL ISSUE|OFFICE|DATE|O/BL RECEIVED|OFFICE|DATE|OTHER DOC RECEIVE|OFFICE|DATE|OTR DOC CGOR FLG| | | | | | | | |" +
	                " |TOT_OTS_STS_CD|TOT_OTS_CURR_CD1|TOT_OTS_CURR_CD2|TOT_OTS_CURR_CD3|TOT_OTS_CURR_CD4|TOT_OTS_CURR_CD5|TOT_OTS_AMT1|TOT_OTS_AMT2|TOT_OTS_AMT3|TOT_OTS_AMT4|TOT_OTS_AMT5|PPT_STS_CD|PPT_RCV_OFC_CD|PPT_RCV_USR_ID|PPT_RCV_DT|CCT_STS_CD|CCT_RCV_OFC_CD|CCT_RCV_USR_ID|CCT_RCV_DT|CCT_OTS_CURR_CD1|CCT_OTS_CURR_CD2|CCT_OTS_CURR_CD3|CCT_OTS_CURR_CD4|CCT_OTS_CURR_CD5|CCT_OTS_AMT1|CCT_OTS_AMT2|CCT_OTS_AMT3|CCT_OTS_AMT4|CCT_OTS_AMT5|N3PTY_PPT_STS_CD|N3PTY_PPT_RCV_OFC_CD|N3PTY_PPT_RCV_USR_ID|N3PTY_PPT_RCV_DT|N3PTY_CCT_STS_CD|N3PTY_CCT_RCV_OFC_CD|N3PTY_CCT_RCV_USR_ID|N3PTY_CCT_RCV_DT|N3PTY_CCT_OTS_CURR_CD1|N3PTY_CCT_OTS_CURR_CD2|N3PTY_CCT_OTS_CURR_CD3|N3PTY_CCT_OTS_CURR_CD4|N3PTY_CCT_OTS_CURR_CD5|N3PTY_CCT_OTS_AMT1|N3PTY_CCT_OTS_AMT2|N3PTY_CCT_OTS_AMT3|N3PTY_CCT_OTS_AMT4|N3PTY_CCT_OTS_AMT5|lcloblissueflg";
	                var headCount=ComCountHeadTitle(HeadTitle);
	                var prefix="blInfo_";
	
	                SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	
	                var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
	                var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Status",    Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
	                          {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"por_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pol_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pod_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"del_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"de_term_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"de_term_desc",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"arrival_vessel",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"vps_eta_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pck_qty",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pck_tp_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"act_wgt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"wgt_ut_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"meas_qty",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"meas_ut_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_prt_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"soc_flg",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ccust_nm",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ccust_addr",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ncust_nm",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ncust_addr",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"shipper_cust_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"shipper_cust_addr",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"split_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bkg_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_no",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_tp_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"dsch_loc",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_iss_rmk",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:prefix+"inter_rmk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"do_hld_flg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cstms_ref_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:200,  Align:"Right",   ColMerge:0,   SaveName:prefix+"cstms_ref_ctnt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cstms_asgn_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cstms_asgn_ctnt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cy_op_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"info_cgo_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"do_split_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_rdem_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_cpy_knt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_iss_tp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_iss_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_iss_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_rdem_knt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_rdem_ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_rdem_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_otr_doc_rcv_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"otr_doc_rcv_ofc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"otr_doc_rcv_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"otr_doc_cgor_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_iss_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_rdem_usr_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"otr_doc_rcv_usr_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"del_cnt_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibd_doc_rcv_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibd_doc_rcv_ofc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibd_doc_rcv_usr_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibd_doc_rcv_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_sts_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_curr_cd1",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_curr_cd2",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_curr_cd3",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_curr_cd4",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_curr_cd5",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_amt1",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_amt2",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_amt3",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_amt4",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_amt5",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ppt_sts_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ppt_rcv_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ppt_rcv_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ppt_rcv_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_sts_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_rcv_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_rcv_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_rcv_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_curr_cd1",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_curr_cd2",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_curr_cd3",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_curr_cd4",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_curr_cd5",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_amt1",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_amt2",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_amt3",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_amt4",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_amt5",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_ppt_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_ppt_rcv_ofc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_ppt_rcv_usr_id",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_ppt_rcv_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_rcv_ofc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_rcv_usr_id",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_rcv_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_curr_cd1", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_curr_cd2", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_curr_cd3", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_curr_cd4", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_curr_cd5", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_amt1",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_amt2",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_amt3",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_amt4",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_amt5",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"lcloblissueflg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
	                 
	                InitColumns(cols);
	                SetEditable(0);
	                SetSheetHeight(300);
	                SetVisible(false);
                }
            break;
/*            
            case "doRlseSts":
                /****************************************************************
                //13. B/L별 D/O의 STATUS(ASSIGN, RELEASE, ISSUE)별 상세 정보 추출
                *****************************************************************
                with (sheetObj) {
	                var HeadTitle=" |Status|Status|D/O No.|Update Time|User ID|User Name|Office|BKG NO |RLSE STS CTNT";
	                var headCount=ComCountHeadTitle(HeadTitle);
	                var prefix="doRlseSts_";
	
	                SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	
	                var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
	                var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
	                          {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:0,   SaveName:prefix+"rlse_sts_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:prefix+"rlse_sts_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:prefix+"do_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:prefix+"evnt_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:prefix+"evnt_usr_id",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:prefix+"upd_usr_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"evnt_ofc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"bkg_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"rlse_sts_ctnt", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
	                 
	                InitColumns(cols);
	                SetEditable(1);
	                SetSheetHeight(110);
                }
            break;
*/            
            case "demInfo":
                /****************************************************************
                //DEM.DET I/F
                *****************************************************************/
                with (sheetObj) {
	                var HeadTitle=" |Seq\n|Container No.|F/T\nOver|Billable\nAmount|Billable\nAmount|Estimate\nFree Time|SAT\nExcl|SUN\nExcl|HOLI\nExcl|Estimate\nPOD LFD|Daily\nDemurrage|Fixed\nFree Time|Fixed\nPOD LFD";
	                var prefix="demInfo_";
	
	                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	                var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
	                var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
	                          {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Seq" },
	                          {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"fx_ft_ovr_dys", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"curr_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:prefix+"bil_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ft_dys",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"CheckBox",  Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"xcld_sat_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N" },
	                          {Type:"CheckBox",  Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"xcld_sun_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N" },
	                          {Type:"CheckBox",  Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"xcld_hol_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N" },
	                          {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_rt_amt",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ft_dys_calc",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ft_end_dt",     KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
	                 
	                InitColumns(cols);
	
	                SetEditable(0);
	                SetSheetHeight(110);
                }
            break;
            case "demDtl":
                /****************************************************************
                //컨테이너 별 Demurrage
                *****************************************************************/
                with (sheetObj) {
	                var HeadTitle=" |Invoicing|Settled|DEMCMNC|PaidUpto|Paid Amount|Paid Amount|CNTR_NO|BIL_AMT";
	                var prefix="demDtl_";
	
	                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	                var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
	                var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
	                          {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"dmdt_inv_sts_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"dmdt_ar_if_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ft_end_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"to_mvmt_dt",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"inv_curr_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Float",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bil_amt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:0,   SaveName:prefix+"inv_chg_amt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
	                 
	                InitColumns(cols);
	                SetEditable(0);
	                SetSheetHeight(110);
                }
            break;
            case "totBlbAmt":
                /****************************************************************
                //Total Billable Amount
                *****************************************************************/
                with (sheetObj) {
	                var HeadTitle1="|curr_cd|tot_bil_amt";
	                var headCount=ComCountHeadTitle(HeadTitle1);
	                prefix="totBlbAmt_";
	
	                SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:1 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
	                          {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"curr_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"tot_bil_amt", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
	                 
	                InitColumns(cols);
	                SetEditable(1);
	                SetVisible(false);
                }
            break;
            case "partial":
                /****************************************************************
                //파샬 컨테이너 정보 조회
                *****************************************************************/
                with (sheetObj) {
	                var HeadTitle1="|SEQ||B/L NO.|CNEE NAME|BKG No|BL_TP_CD";
	                var headCount=ComCountHeadTitle(HeadTitle1);
	                prefix="partial_";
	
	                SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:1 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
	                          {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"Seq" },
	                          {Type:"Radio",     Hidden:0, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"radio",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"cstms_desc", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"bkg_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                          {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
	                 
	                InitColumns(cols);
	                SetEditable(1);
	                //SetSheetHeight(100);
	                SetVisible(false);
                }
            break;
            case "doRlseStsBl":
                /****************************************************************
           	 //17. D/O STATUS(ASSIGN, RELEASE, ISSUE) per B/L detail info 
                *****************************************************************/
           	 with(sheetObj){
           	 	var HeadTitle=" |Status|Status|D/O No.|Update Time|User ID|User Name|Office|BKG NO |RLSE STS CTNT";
           	 	var headCount=ComCountHeadTitle(HeadTitle);
   			   (headCount, 0, 0, true);
   			   var prefix="doRlseStsBl_";
   			
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
   			  {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"rlse_sts_ctnt", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
   			    
   			   InitColumns(cols);
   			
   			   SetEditable(1);
   			   SetSheetHeight(130);
            }
            break;
            case "doRlseStsCntr":
                /****************************************************************
           	 // D/O STATUS(ASSIGN, RELEASE, ISSUE) per Container detail info
                *****************************************************************/
       	    with(sheetObj){
   	             var HeadTitle=" |Check|CNTR No|Status CD|Status|D/O No.|Update Time|User ID|Office|Bkg No|STS SEQ|SEQ";
   		           var headCount=ComCountHeadTitle(HeadTitle);
   		           (headCount, 0, 0, true);
   		           var prefix="doRlseStsCntr_";
   		
   		           SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
   		
   		           var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
   		           var headers = [ { Text:HeadTitle, Align:"Center"} ];
   		           InitHeaders(headers, info);
   		
   		           var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
   		                  {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_chk",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
   		                  {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
   		                  {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:0,   SaveName:prefix+"rlse_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
   		                  {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"rlse_sts_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
   		                  {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"do_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
//   		                  {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"mvmt_ref_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
//   		                  {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"rtn_yd_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
   		                  {Type:"Text",      Hidden:0, Width:200,  Align:"Center",  ColMerge:0,   SaveName:prefix+"evnt_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
   		                  {Type:"Text",      Hidden:0, Width:150,  Align:"Center",  ColMerge:0,   SaveName:prefix+"evnt_usr_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
   		                  {Type:"Text",      Hidden:0, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"evnt_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
   		                  {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"bkg_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
   		                  {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"rlse_sts_seq", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
   		                  {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"rlse_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
   		            
   		           InitColumns(cols);
   		
   		           SetEditable(1);
   		           SetVisible(false);
                }
            break;
        }
    }
	// handling of Sheet process
    function doActionIBSheet(sheetObj, formObj, sAction) {
        var param="";
        switch(sAction) {
            case IBSEARCH: // retrieve
                if(!validateForm(sheetObj,formObj,sAction)){
                	return;
                }
                    inputParamReset();
                    formObj.f_cmd.value=SEARCH;
                    var temp_bl=formObj.bl_no.value;
                    var temp_bkg=formObj.bkg_no.value;
                    ComOpenWait(true);

                    //@ 조회 후 세팅시 bkg_no bl_no conditionReset발생 안하게 하기 위함 
                    onchangeFlag = false;
                    
                    setTimeout( function () { //@ setTimeout ###########################################################
	                    formObj.bl_no.value=temp_bl;
	                    formObj.bkg_no.value=temp_bkg;
	                    if(formObj.bl_no.value !=''){
	                        var blNo=formObj.bl_no.value;
	                        var suffix=blNo.substring(formObj.bl_no.value.length-1)
	                        if(suffix =='W' || suffix =='S'){
	                            formObj.bl_no.value=blNo.substring(0, blNo.lastIndexOf(suffix));
	                        }
	                    }
//	                    var aryPrefix=new Array("blInfo_", "doRlseSts_", "demInfo_", "demDtl_",  "totBlbAmt_"); //prefix string array
	                    var aryPrefix = new Array("blInfo_", "doRlseStsCntr_", "doRlseStsBl_", "demInfo_", "demDtl_",  "totBlbAmt_"); //prefix string array
	                    param="f_cmd=" + formObj.f_cmd.value + "&bkg_no=" + formObj.bkg_no.value + "&bl_no=" + formObj.bl_no.value + "&demur_type=" + formObj.demur_type.value + "&exp_del_dt=" + formObj.exp_del_dt.value + "&obl_cng_flg=" + formObj.obl_cng_flg.value;
	                    var sXml=sheetObjects["blInfo"].GetSearchData("ESM_BKG_0128GS.do", param + "&" + ComGetPrefixParam(aryPrefix));
	                    var arrXml=sXml.split("|$$|");
	                    
//	                    formObj.dubai_mrd_id.value = ComGetEtcData(arrXml[0], "DUBAI_MRD_ID");
	                    
	                   //ETC DATA  : LoadSearchXml OnSearchEnd Event 
	                    if(undefined != ComGetEtcData(arrXml[0], "demurType") && ComGetEtcData(arrXml[0], "demurType") != 'null'){
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
	                    if(undefined != ComGetEtcData(arrXml[0], "localLangFlg") && ComGetEtcData(arrXml[0], "localLangFlg") != 'null'){
	                        document.getElementById("h_local_lang_flg").value=ComGetEtcData(arrXml[0], "localLangFlg");
	                    }
	                    if(undefined != ComGetEtcData(arrXml[0], "tpbStatus") && ComGetEtcData(arrXml[0], "tpbStatus") != 'null'){
	                        document.getElementById("tpb_status").value=ComGetEtcData(arrXml[0], "tpbStatus");
	                    }
	                    
	                    
	                    // 2014.10.31 안진응 추가
	                	
	                    if(undefined != ComGetEtcData(arrXml[0], "splitFlg") && ComGetEtcData(arrXml[0], "splitFlg") != 'null'){
	                        var splitFlg=ComGetEtcData(arrXml[0], "splitFlg");
	                        if (splitFlg == "N") {
	                        	setSplitFlag("N");
	                        	document.form.split_flg[0].checked=true;
	                        } else {
	                            setSplitFlag("Y");
	                            document.form.split_flg[1].checked=true;
	                        }
	                    }
	                    
	                    if(undefined != ComGetEtcData(arrXml[0], "remainCntrCnt") && ComGetEtcData(arrXml[0], "remainCntrCnt") != 'null'){
	                        document.getElementById("remain_cntr_cnt").value=ComGetEtcData(arrXml[0], "remainCntrCnt");
	                    }	                    
	                    
	                    for(var idx=0; idx < arrXml.length; idx++){
	                        if(idx > 0) {
	                            sheetObjects[sheetNames[idx]].SetWaitImageVisible(0);
	                        }
	                        sheetObjects[sheetNames[idx]].LoadSearchData(arrXml[idx],{Sync:1} );
	                    }
	                    fnButtonControl();
	                    //@ 조회 후 세팅시 bkg_no bl_no conditionReset발생 안하게 하기 위함 
	                    onchangeFlag = true;
	                    
	                    //@releaseRemarkFlag 초기화 한다. 
	                    releaseRemarkFlag = false;
                    
                    } , 100);//@ setTimeout end ###########################################################
            break;
            case COMMAND05: //DEM Retrieve
                if(!validateForm(sheetObj,formObj,sAction)){
                	return;
                }
                
    	        	if(ComIsNull(formObj.bl_no) && ComIsNull(formObj.bkg_no)){
    	                ComShowCodeMessage('BKG01072'); 
    	                ComSetFocus(formObj.bl_no)
    	                return false;
    	            }
                    formObj.f_cmd.value=SEARCH;
                    ComOpenWait(true);
                    
                    setTimeout( function () { //@ setTimeout ###########################################################
                    	
//	                    var aryPrefix=new Array("blInfo_", "doRlseSts_", "demInfo_", "demDtl_",  "totBlbAmt_"); //prefix 문자열 배열
//                    	var aryPrefix = new Array("blInfo_", "doRlseStsBl_", "demInfo_", "demDtl_",  "totBlbAmt_"); //prefix 문자열 배열
                    	var aryPrefix = new Array("blInfo_", "doRlseStsCntr_", "doRlseStsBl_", "demInfo_", "demDtl_",  "totBlbAmt_"); //prefix string array
	                    param="f_cmd=" + formObj.f_cmd.value + "&bkg_no=" + formObj.bkg_no.value + "&bl_no=" + formObj.bl_no.value + "&demur_type=" + formObj.demur_type.value + "&exp_del_dt=" + formObj.exp_del_dt.value + "&obl_cng_flg=" + formObj.obl_cng_flg.value;
	                    var sXml=sheetObjects["blInfo"].GetSearchData("ESM_BKG_0128GS.do", param + "&" + ComGetPrefixParam(aryPrefix));
	                    var arrXml=sXml.split("|$$|");
	                    for(var idx=2; idx < arrXml.length; idx++){
	                        if(idx > 0) {
	                            sheetObjects[sheetNames[idx]].SetWaitImageVisible(0);
	                        }
	                        sheetObjects[sheetNames[idx]].LoadSearchData(arrXml[idx],{Sync:1} );
	                    }
	                    //ETC DATA  : LoadSearchXml OnSearchEnd Event 
	                    if(undefined != ComGetEtcData(arrXml[0], "demurType") && ComGetEtcData(arrXml[0], "demurType") != 'null'){
	                        document.getElementById("demur_type").value=ComGetEtcData(arrXml[0], "demurType");
	                    }
	                    
                    } , 100);//@ setTimeout end ###########################################################
                
            break;
            case IBSAVE:   // save
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
                    if(! sheetObjects["blInfo"].IsDataModified()){
                        ComShowCodeMessage('BKG00743');
                        return false;
                    }
                    var bkgNo=sheetObjects["blInfo"].GetCellValue(1, "blInfo_bkg_no");
                    if( !ComShowCodeConfirm('COM12147') ){
                        return false;
                    }
                    
                    
                    setTimeout( function () { //@ setTimeout ###########################################################
                    	var sParam1=sheetObjects["blInfo"].GetSaveString(true, false);   //EU D/O Release Reference
	                    var aryPrefix=new Array("blInfo_");    //prefix 문자열 배열
	                    var sparam=sParam1 + "&" + FormQueryString(formObj)+ "&" + ComGetPrefixParam(aryPrefix);
	                    var sXml=sheetObj.GetSaveData("ESM_BKG_0128GS.do", sparam);
	                    sheetObjects["blInfo"].LoadSaveData(sXml,{Sync:1});
	                    sXml=ComDeleteMsg(sXml);
        			} , 100);//@ setTimeout end ###########################################################                    
            break;
            case MULTI01:// Release
                if(!validateForm(sheetObj, formObj, sAction)){
                	return;
                }
                	if(ComIsNull(formObj.bl_no) && ComIsNull(formObj.bkg_no)){
                        ComShowCodeMessage('BKG01072'); 
                        ComSetFocus(formObj.bl_no)
                        return false;
                    }
                	
                	//GAP Display Credit Risk (2014.10.14 An Jin Eung)
                	if(!fnExistBlackListedCustomer(formObj.bkg_no.value)){
//                        return false;
                    }
                	
                    //Are you sure to Release?
                    if(!ComShowCodeConfirm('BKG00673')){
                        return false;
                    }

					if(document.getElementById("blInfo_tot_ots_sts_cd").value =='N'){
                        if(!remarkForReleasePop()){
                            return;
                        }
                    }
					
					// 2014.11.03 안진응 추가
                    if (document.form.split_flg[0].checked == true) {
                        document.form.refInfo_do_split_flg.value = "N";
                    } else {
                        document.form.refInfo_do_split_flg.value = "Y";
                    }
										
                    //(2010.02.08) refInfo ==> blInfo
                    if (sheetObjects["blInfo"].RowCount()> 0) {
                    	document.form.blInfo_do_hld_flg.value=sheetObjects["blInfo"].GetCellValue(1, "blInfo_do_hld_flg");
                    } else {
                        document.form.blInfo_do_hld_flg.value="N";
                    }
                    
                    
                    formObj.f_cmd.value=MULTI01;
//                    sheetObjects["doRlseSts"].SetRowStatus(1,"U");
                    if (document.form.split_flg[0].checked == true) {     //per BL
                    	sheetObjects["doRlseStsBl"].SetRowStatus(1,"U");
                    }                    
                    sheetObjects["blInfo"].SetRowStatus(1,"U");
//                    var aryPrefix=new Array("doRlseSts_", "blInfo_");    
                    var aryPrefix = new Array("doRlseStsCntr", "doRlseStsBl", "blInfo_");    
                    CopyFormToRow(formObj, sheetObjects["blInfo"], 1, "");
                    
                    setTimeout( function () { //@ setTimeout ###########################################################
                        var sParam1 = sheetObjects["doRlseStsBl"].GetSaveString();
                        var sParam2 = sheetObjects["doRlseStsCntr"].GetSaveString();
                        var sParam3 = sheetObjects["blInfo"].GetSaveString();

                        var sparam = sParam1 + "&" + sParam2 + "&" + sParam3 + "&" + FormQueryString(formObj)+ "&" + ComGetPrefixParam(aryPrefix);

	                    if (document.form.split_flg[0].checked == true) {     //per BL
		                    var sXml=sheetObjects["doRlseStsBl"].GetSaveData("ESM_BKG_0128GS.do", sparam);

	                    	sheetObjects["doRlseStsBl"].LoadSaveData(sXml,{Sync:1});
	                    } else {
	                    	var sXml=sheetObjects["doRlseStsCntr"].GetSaveData("ESM_BKG_0128GS.do", sparam);
	                    	sheetObjects["doRlseStsCntr"].LoadSaveData(sXml,{Sync:1});
	                    }	                    
	                    
	                    sXml=ComDeleteMsg(sXml); 
                    } , 100);//@ setTimeout end ###########################################################
                
            break;
            case MULTI02:// Cancel
	        	if(ComIsNull(formObj.bl_no) && ComIsNull(formObj.bkg_no)){
	                ComShowCodeMessage('BKG01072'); 
	                ComSetFocus(formObj.bl_no)
	                return false;
	            }
                //Are you sure to Cancel?
                if(!ComShowCodeConfirm('BKG00670')){
                    return false;
                }
                formObj.f_cmd.value=MULTI02;
                
                if (document.form.split_flg[0].checked == true) {
                    document.form.refInfo_do_split_flg.value = "N";
                } else {
                    document.form.refInfo_do_split_flg.value = "Y";
                }
                
                if (document.form.split_flg[0].checked == true) {     //per BL
                	sheetObjects["doRlseStsBl"].SetRowStatus(1,"U");
                    sheetObj.DoSave("ESM_BKG_0128GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("doRlseStsBl_"),-1,0);
                } else {

                    var aryPrefix = new Array("doRlseStsCntr_");
                    var sParam1 = sheetObjects["doRlseStsCntr"].GetSaveString();
                    var sparam = sParam1 + "&" + FormQueryString(formObj)+ "&" + ComGetPrefixParam(aryPrefix);
                    var sXml = sheetObj.GetSaveData("ESM_BKG_0128GS.do", sparam);

                    sheetObjects["doRlseStsCntr"].LoadSaveData(sXml,{Sync:1});
                    sXml = ComDeleteMsg(sXml); 
                }
                
                
//                sheetObjects["doRlseSts"].SetRowStatus(1,"U");
//                var formString = FormQueryString(formObj);
//                var prefix = ComGetPrefixParam("doRlseSts_");
//
//                sheetObj.DoSave("ESM_BKG_0128GS.do",  formString+ "&" + prefix,-1,0);
                
            break;
            case MULTI04:// Hold
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
                formObj.f_cmd.value=MULTI04;
                var aryPrefix=new Array("blInfo_");    
                var sParam1=sheetObjects["blInfo"].GetSaveString(true);
                var sparam=sParam1 + "&" + FormQueryString(formObj)+ "&" + ComGetPrefixParam(aryPrefix);
                var sXml=sheetObj.GetSaveData("ESM_BKG_0128GS.do", sparam);
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
        	if (document.form.blInfo_obl_rdem_knt.value != sheetObjects["blInfo"].GetCellValue(1, "blInfo_obl_rdem_knt")) {
            	var chkSkip="N";
            	if( lginCntCd == 'US' && document.getElementById("blInfo_pod_cd").value.substring(0,2) == 'CA' ){            		
            		chkSkip="Y"
            	}
            	if( chkSkip == "N" ){     
            		if (document.getElementById("blInfo_del_cd").value.substring(0,2) != lginCntCd) {
            	        ComShowCodeMessage("BKG00630");
	                  return false;
	                }
            	}
            }
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
        }else if(sAction == MULTI01){
        	  //blIss ==> blInfo
              if(document.getElementById("blInfo_obl_rdem_flg").value == "N"){
//                  //'Orgin B/L not released!
                  ComShowCodeMessage('BKG40066');
                  return false;
              }
                return true;
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
    /**************************************************************
        TRIC SELECT BOX CODE START
    **************************************************************/
    /**
     * Handling HTML Control deactivate event <br>
     **/
    function showHideLayers() {
        var el=ComGetEvent();
        if(el.tagName.toLowerCase() !='input'){
            return;
        }
        var rect=el.getBoundingClientRect();
        var blLayer = document.getElementById("blLayer");
        $('#blLayer').css('top', (rect.top + 25) + 'px')
                     .css('left', rect.left + 'px')
                     .css('border-color', rgbToHex($(el).css('borderTopColor')))
                     .css('width', (rect.width - 2) + 'px');
        if(blLayer.style.visibility == "visible"){
            blLayer.style.visibility="hidden";
        }else{
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
     * Container partial Bl No popup<br>
     */
    function blSelectPopOpen(){
        var sXml=IBS_GetDataSearchXml(sheetObjects["partial"]);
        document.form.xmlData.value=sXml;
        ComOpenPopup("/opuscntr/ESM_BKG_0942.do", 500, 300, "conditionSet", "1,0", true);
    }
    /**
     * control BL_NO SELECT BOX<br>
     **/
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
     * TRiC SELECT BOX
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
     * BL_NO change event<br>
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
     * O/BL Received input event
     */
    function obl_rdem_knt_change(obj){
        // blIss ==> blInfo
    	var sheetObj=sheetObjects["blInfo"];
        if (sheetObj.LastRow()== 0 ) {return;}
        var blTpCd=sheetObj.GetCellValue(1, "blInfo_bl_tp_cd");
        var oblRedmFlg=sheetObj.GetCellValue(1, "blInfo_obl_rdem_flg");
        var delCntCd=sheetObj.GetCellValue(1, "blInfo_del_cnt_cd");
        if (blTpCd == "S" || blTpCd == "W") {
            //document.form.blIss_obl_rdem_flg.value = "Y";
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
            if (document.getElementById("blInfo_bl_otr_doc_rcv_cd").selectedIndex > 0) {
                document.getElementById("blInfo_otr_doc_cgor_flg").disabled=false;
            } else {
                document.getElementById("blInfo_otr_doc_cgor_flg").disabled=true;
            }
        }
    }
    function addSel(sheetObj) {
        var sel=document.form.tot_ots_amt;
        var prefix="blInfo_";
        for (i=sel.length-1; i>=0; i--){
            sel.options[i]=null
        }
        //If the number of accounts receivable US credit if shippers
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
        	//Bold font color is red.
        	document.getElementById("tot_ots_amt").className="input2_1";
        } else {
        	document.getElementById("tot_ots_amt").className="input2";
        }
    }
    //Images from the TPB to receive information on the configuration and code set values
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
    //OBL Cancel at the click of a button resets the values​​.
    function oblInit(){
        // blIss ==> blInfo
    	if (document.getElementById("blInfo_obl_rdem_flg").value != "Y" ) {
            // If the Y values ​​only blInfo_obl_rdem_flg resets.
            return;
        }
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
        document.getElementById("blInfo_ibd_doc_rcv_flg").value='N';
        document.getElementById("blInfo_ibd_doc_rcv_ofc_cd").value='';
        document.getElementById("blInfo_ibd_doc_rcv_dt").value='';
        document.getElementById("blInfo_ibd_doc_rcv_usr_id").value='';
        //CR : Cancelled O/BL Received
        document.getElementById("do_cng_evnt_cd").value='CR';
        //D/O EVENT value before
        document.getElementById("pre_ctnt").value='N';
        //D/O EVENT value before
        document.getElementById("crnt_ctnt").value='Y';
        //OBL Whether to change the Y value is set.
        document.getElementById("obl_cng_flg").value='Y';
        //OB/L Redemption Flag is set to N. blIss ==> blInfo
        document.getElementById("blInfo_obl_rdem_flg").value="N";  
        // OBL Receive, Oth doc, inbound doc receive enable/disable상태를 처리
        obl_rdem_knt_change(document.getElementById("blInfo_obl_rdem_knt"));
        // button을 disable한다.
        ComBtnDisable("btn_obl_cancel");
      }
    /************************************************************************************
        IBSHEET OnSaveEnd Event START
    ************************************************************************************/
    /**
     * store and handle the details after doRlseSts
     */
//    function doRlseSts_OnSaveEnd(sheetObj, ErrMsg){
//            doActionIBSheet(sheetObj, document.form,IBSEARCH);
//    }
    /************************************************************************************
    /************************************************************************************
        IBSHEET OnSearchEnd Event START
    ************************************************************************************/
    /**
     * IBSheet and then look up the information process
     */
    function partial_OnSearchEnd(sheetObj, ErrMsg){
        if (ErrMsg == "") {
            //Delete objects previously placed in the make
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
     * store and handle the details after blInfo
     */
    function blInfo_OnSaveEnd(sheetObj, ErrMsg){
    		ComBkgSaveCompleted();  //Server Msg Handling
            doActionIBSheet(sheetObj, document.form,IBSEARCH);
    }
    /**
     * EU D / O Release and then look up basic information to process your query IBSheet
     */
    function blInfo_OnSearchEnd(sheetObj, ErrMsg){
        //Wait Image Show Hidden
        ComOpenWait(false);
        if (ErrMsg == "") {
            if(sheetObj.RowCount()> 0){
                //Data on the Grid as an argument to Html is Copy.
                ComCopyRowToForm(sheetObj, 1, form, "");
                //Enable the Save button
                ComBtnEnable("btn_save");
                //Enable the Hold button
                ComBtnEnable("btn_hold");
                //searching conditions
//                alert(sheetObj.GetCellValue(1,"blInfo_bkg_no"));
                document.getElementById("bkg_no").value=sheetObj.GetCellValue(1,"blInfo_bkg_no");
                
                //At the end of BL_NO Merges BL_TP_CD
                if(sheetObj.GetCellValue(1,"blInfo_bl_tp_cd") !='B'){
                	document.getElementById("bl_no").value=sheetObj.GetCellValue(1,"blInfo_bl_no")+sheetObj.GetCellValue(1,"blInfo_bl_tp_cd");
                }else{
                	document.getElementById("bl_no").value=sheetObj.GetCellValue(1,"blInfo_bl_no");
                }
                // refInfo ==> blInfo
                //Hold the red or gray, depending on whether the text processing
                if(sheetObj.GetCellValue(1, "blInfo_do_hld_flg") =='N'){
                    document.getElementById("hold_flag").className="input2";
                    //Set of values ​​for Hold Event: CargoReleaseOrderBCImpl.java holdDo Hold or Un-Hold-separated values ​​in
                    document.getElementById("evnt_flag").value='H';
                    
                    ComBtnEnable("btn_hold");
                    ComBtnDisable("btn_unhold");
                    document.getElementById("btn_hold").style.display="";
                    document.getElementById("btn_unhold").style.display="none";
                }else if(sheetObj.GetCellValue(1, "blInfo_do_hld_flg") =='Y'){
                    document.getElementById("hold_flag").className="input2_1";
                    document.getElementById("hold_flag").value='Hold';
                    //Set of values ​​for Hold Event: CargoReleaseOrderBCImpl.java holdDo Hold or Un-Hold-separated values ​​in
                    document.getElementById("evnt_flag").value='R';
                    
                    ComBtnDisable("btn_hold");
                    ComBtnEnable("btn_unhold");
                    document.getElementById("btn_hold").style.display="none";
                    document.getElementById("btn_unhold").style.display="";
                    
                }else{
                    document.getElementById("hold_flag").className="input2";
                    //Set of values ​​for Hold Event: CargoReleaseOrderBCImpl.java holdDo Hold or Un-Hold-separated values ​​in
                    document.getElementById("evnt_flag").value='H';
                    
                    ComBtnEnable("btn_hold");
                    ComBtnDisable("btn_unhold");
                    document.getElementById("btn_hold").style.display="";
                    document.getElementById("btn_unhold").style.display="none";
                }
                // blIss ==> blInfo
                if (document.form.blInfo_bl_tp_cd.value == "") {
                    document.form.blInfo_bl_tp_cd.value="B";
                }
                //Retrieved at the time of Original B / L to recover the value of the Y or N is shown in red blue
                if( document.getElementById("blInfo_obl_rdem_flg").value =='Y'){
                    document.getElementById("blInfo_obl_rdem_flg").style.color='blue';
                }else if(document.getElementById("blInfo_obl_rdem_flg").value =='N'){
                    document.getElementById("blInfo_obl_rdem_flg").style.color='red';
                }
                //O / BL recall whether or not to set an initial value to the Hidden property.
                document.getElementById("h_ori_obl_rdem_flg").value=document.getElementById("blInfo_obl_rdem_flg").value;
                document.getElementById("h_aft_obl_rdem_flg").value=document.getElementById("blInfo_obl_rdem_flg").value;
                //D / O EVENT is changed from the previous value ->
                document.getElementById("pre_ctnt").value=document.getElementById("blInfo_obl_rdem_knt").value;
                obl_rdem_knt_change(document.getElementById("blIss_obl_rdem_knt"))
                //If BL Surrender OB / L Received Remark side views of the Y button to enable and Field Setting, Unless the button disable
                if (sheetObj.GetCellValue(1, "blInfo_bl_tp_cd") == "S") {
                    document.getElementById("bl_surr_rmk_flg").value="Y";
                    document.getElementById("btn_bl_surr_flg").style.visibility="visible";
                } else {
                    document.getElementById("bl_surr_rmk_flg").value="";
                    document.getElementById("btn_bl_surr_flg").style.visibility="hidden";
                }
                // otsRcvInfo ==> blInfo
                addSel(sheetObj);
                ComBtnEnable("btn_cct");
                ComBtnEnable("btn_third_cct");
                ComBtnEnable("btn_erp");
                //If the value is Retrieved at the point Y is shown in red blue N
                if( document.getElementById("blInfo_tot_ots_sts_cd").value =='Y'){
                    document.getElementById("blInfo_tot_ots_sts_cd").style.color='blue';
                }else if(document.getElementById("blInfo_tot_ots_sts_cd").value =='N'){
                    document.getElementById("blInfo_tot_ots_sts_cd").style.color='red';
                }
                
                //setting DO Split Flg
                if (sheetObj.GetCellValue(1, "blInfo_do_split_flg") ==  "Y") {
                  document.getElementById("div_remain_cnt").style.visibility="visible";
                } else {
                  document.getElementById("div_remain_cnt").style.visibility="hidden";
                }             
                
                if (document.getElementById("blInfo_pod_cd").value.substring(0,2) == 'CA') {
                    document.form.split_flg[0].disabled = true;
                    document.form.split_flg[1].disabled = true;
                } else {
                    document.form.split_flg[0].disabled = false;
                    document.form.split_flg[1].disabled = false;
                }
            }
            /*************************************************************
            TPB set start 0: Red 1: Green -1: gray
            *************************************************************/
            tpbImgSet(document.getElementById("tpb_status").value);
            
            //Activate the button
            ComBtnEnable("btn_erp");
            ComBtnEnable("btn_dem_retrieve");
            ComBtnEnable("btn_dmdt");
            ComBtnEnable("btn_history");
            //O / BL Received the value set before changes
            document.getElementById("old_obl_rdem_knt").value=sheetObj.GetCellValue(1, "blInfo_obl_rdem_knt");
            //Hold / Internal Remarks item added check logic
            chkRemark();
            if (sheetObj.GetCellValue(1,"blInfo_lcloblissueflg") == "Y") {
            	ComShowCodeMessage("BKG00667");
            }
            if (document.getElementById("blInfo_cntr_prt_flg").value == "Y") {
            	//Bold font color is red.
            	document.getElementById("blInfo_cntr_prt_flg").style.color="red";            	
            	document.getElementById("blInfo_cntr_prt_flg").style.fontWeight="bold";
            } else {
            	document.getElementById("blInfo_cntr_prt_flg").style.color="";
            	document.getElementById("blInfo_cntr_prt_flg").style.fontWeight="normal";
            }
            if (document.getElementById("blInfo_soc_flg").value == "Y") {
            	//Bold font color is red.
            	document.getElementById("blInfo_soc_flg").style.color="red";            	
            	document.getElementById("blInfo_soc_flg").style.fontWeight="bold";
            } else {
            	document.getElementById("blInfo_soc_flg").style.color="";
            	document.getElementById("blInfo_soc_flg").style.fontWeight="normal";
            }
        }else{
            //When an error occurs, the sheet resets.
//            var resetSheetNames=new Array("blInfo", "doRlseSts", "demInfo", "demDtl",  "totBlbAmt");
        	var resetSheetNames = new Array("blInfo", "doRlseStsCntr", "doRlseStsBl", "demInfo", "demDtl",  "totBlbAmt");
            for(var idx=0; idx < resetSheetNames.length; idx++){
                sheetObjects[resetSheetNames[idx]].RemoveAll();
            }
        }
        
        
    }
    /**
     * Hidden IBSheet and then retrieving the information process
     */
    function demInfo_OnSearchEnd(sheetObj){
        //Wait Image Show Hidden
        ComOpenWait(false);
        ComBtnEnable("btn_dem_retrieve"); //DMDT
        ComBtnEnable("btn_dmdt");         //RCV Cancel
    }
     /**
      * Hidden IBSheet and then retrieving the information process
      */
    function demDtl_OnSearchEnd(sheetObj){
        var invTotBilAmt=0;
        //Number of the first container, the container information
        var fist_cntr_no=sheetObjects["demInfo"].GetCellValue(1, "demInfo_cntr_no");
        for(var idx=1; idx <= sheetObj.RowCount(); idx++){
            //INVOICE of the information that the first container number that matches the rest of the row to show the hidden
        	if(fist_cntr_no != sheetObjects["demDtl"].GetCellValue(idx, "demDtl_cntr_no")){
                sheetObjects["demDtl"].SetRowHidden(idx,1);
            }
        }
    }
    /**
    * Hidden IBSheet and then retrieving the information process
    */
    function totBlbAmt_OnSearchEnd(sheetObj, ErrMsg){
        var sel=document.form.tot_bil_amt;
        //SELECT BOX 
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
        ComSetUIItem(sheetObjects["blInfo"],document.form, "BKG", "ESM_BKG_0128");
    }
    /**
    * Hidden IBSheet and then retrieving the information process
    */
//    function doRlseSts_OnSearchEnd(sheetObj, ErrMsg){
//        if (ErrMsg == "") {
//            if(sheetObj.RowCount()> 0){
//                for(var idx=1; idx <= sheetObj.RowCount(); idx++){
//                	if(sheetObj.GetCellValue(idx, "doRlseSts_rlse_sts_cd") != 'C'){
//                		document.getElementById("rlse_sts_cd").value=sheetObj.GetCellValue(idx, "doRlseSts_rlse_sts_cd");
//                    }
//                    if(idx == sheetObj.RowCount()){
//                    	document.getElementById("last_rlse_sts_cd").value=sheetObj.GetCellValue(idx, "doRlseSts_rlse_sts_cd");
//                    }
//                    if(sheetObj.GetCellValue(idx, "doRlseSts_rlse_sts_cd") == 'R'){
//                        ComBtnEnable("btn_cancel");
//                        ComBtnDisable("btn_release");
//                        ComBtnEnable("btn_preview");
//                    }else if(sheetObj.GetCellValue(idx, "doRlseSts_rlse_sts_cd") == 'C'){
//                        ComBtnDisable("btn_cancel");
//                        ComBtnEnable("btn_release");
//                        ComBtnDisable("btn_preview");
//                    }
//                }
//                //fnButtonControl();
//                ComBtnEnable("btn_receiverinfo");
//                ComBtnEnable("btn_remark");
//                document.getElementById("h_do_no").value=sheetObj.GetCellValue(1, "doRlseSts_do_no");
//                document.getElementById("pre_ctnt").value=sheetObj.GetCellValue(1, "doRlseSts_rlse_sts_cd");
////                sheetObj.SelectCell(sheetObj.RowCount(),0)
//            } else {
//                //fnButtonControl();
//                ComBtnEnable("btn_release");
//            }
//        }
//    }
    /**
     * In case of the OnClick event of the Grid: Click the container that corresponds to the number shows INVOICE information.
     */
    function demInfo_OnDblClick(sheetObj, row, col){
    	var click_cntr_no=sheetObj.GetCellValue(row, "demInfo_cntr_no");
        demDtlPopOpen(click_cntr_no)
    }
    /**
     * DEM.DET
     */
    function demDtlPopOpen(cntr_no){
        var sXml=IBS_GetDataSearchXml(sheetObjects["demDtl"]);
        document.form.demDtlXmlData.value=sXml;
        var condition="?";
            condition += "cntr_no="+cntr_no;
        ComOpenWindowCenter('/opuscntr/ESM_BKG_1072.do'+condition, 'demDtl', 500, 275, true);
    }
    /**
     * CCT,Third Office(CCT) <br>
     */
    function blOutstandingAmountPopOpen(flag){
        var maxRow=sheetObjects["blInfo"].LastRow();
        var GetCellValue="";
        var prefix="blInfo_";
        var curr_cd="";
        var ots_amt=0;
        var strXmlBody="";
        var xmlCnt=0;
        for(i=1;i <= maxRow ; i++){
            for(var q=1;q<6;q++){
                if (flag == true) { // CCT
                	if (sheetObjects["blInfo"].GetCellValue(i, prefix + "cct_ots_amt" + q) > 0) {
                		curr_cd=sheetObjects["blInfo"].GetCellValue(i, prefix + "cct_ots_curr_cd" + q);
                		ots_amt=sheetObjects["blInfo"].GetCellValue(i, prefix + "cct_ots_amt" + q);
                        strXmlBody=strXmlBody + "<TR><![CDATA[" + curr_cd + "☜☞" + ots_amt + "☜☞]]></TR>";
                        xmlCnt=parseInt(xmlCnt) + 1;
                    }
                } else {            // Third Office(CCT)
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
    //Remark For Release call Popup
    var releaseRemarkFlag = false;
    function remarkForReleasePop(){
    	
    	if(releaseRemarkFlag == false){
	        var condition="?";
	        condition += "bkg_no="+sheetObjects["blInfo"].GetCellValue(1, "blInfo_bkg_no");
//	        result=ComOpenWindowCenter('ESM_BKG_0954.do' + condition, "ESM_BKG_0954", 600, 250, true);
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
    		 
    	   	 document.form.releaseRemark.value =result;
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
    * rd LOAD
    */
    function rdLoad() {
    	var appendReport = [];
        var formObject=document.form;
//        doNo=sheetObjects["doRlseSts"].GetCellValue(1, "doRlseSts_do_no");       //BL 단위
        if (document.form.split_flg[0].checked == true) {
            doNo = sheetObjects["doRlseStsBl"].GetCellValue(1, "doRlseStsBl_do_no");       //per BL
            
            var mrdId=formObject.h_mrd_id.value;
            var mrdParam=formObject.h_mrd_param.value;
            if(mrdId == ""){
                ComShowCodeMessage("BKG40080");
                return;
            }
            if(doNo == ""){
                var blNo="";
                if (sheetObjects["blInfo"].RowCount()> 0) {
                	blNo=sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no");
                }
                ComShowCodeMessage("BKG40059", blNo);
                return;
            }
            formObject.com_mrdPath.value="apps/opus/esm/bkg/inbounddocumentation/cargoreleaseordermgt/cargoreleaseorder/report/"+ mrdId+ ".mrd";
            var strArg="/rv ";
            strArg += " form_doNo['" + doNo + "']";
            strArg += " form_bkgNo['" + sheetObjects["blInfo"].GetCellValue(1, "blInfo_bkg_no") + "']";
            strArg += " form_usrId['" + strUsr_id + "']";
            strArg += " form_ofcCd['" + lginOfcCd + "']";
            strArg += " form_mainOnly[N]";  

            strArg += " " + mrdParam;    
            
            var rdParam=strArg + " /riprnmargin /rwait";
            var strPath=RD_path+ formObject.com_mrdPath.value;
            appendReport.push({mrdPath:strPath, mrdParam:RDServer + rdParam});
//            viewer.openFile(strPath, RDServer + rdParam, {timeout:300});
//            viewer.print({isServerSide:true});
            directReportDownload(appendReport);
        } else {

        	var prefix = "doRlseStsCntr";
        	
        	for (var idx=1; idx <= sheetObjects[prefix].LastRow(); idx ++) {
            	if (sheetObjects[prefix].GetCellValue(idx, prefix+"_cntr_chk") == 1) {
                    // validation for checked Info
            		doNo=sheetObjects[prefix].GetCellValue(idx, prefix+ "_do_no") + sheetObjects[prefix].GetCellValue(idx, prefix+ "_do_no_split");

                    if (doNo == "") {
                        var blNo = "";
                        if (sheetObjects["blInfo"].RowCount() > 0) {
                            blNo = sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no");
                        }
                            ComShowCodeMessage("BKG40059", blNo);
                        return;
                    }

                    var mrdId=formObject.h_mrd_id.value;
                    var mrdParam=formObject.h_mrd_param.value;
                    if(mrdId == ""){
                        ComShowCodeMessage("BKG40080");
                        return;
                    }
                    if(doNo == ""){
                        var blNo="";
                        if (sheetObjects["blInfo"].RowCount()> 0) {
                        	blNo=sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no");
                        }
                        ComShowCodeMessage("BKG40059", blNo);
                        return;
                    }
                    formObject.com_mrdPath.value="apps/opus/esm/bkg/inbounddocumentation/cargoreleaseordermgt/cargoreleaseorder/report/"+ mrdId+ ".mrd";
                    var strArg="/rv ";
                    strArg += " form_doNo['" + doNo + "']";
                    strArg += " form_bkgNo['" + sheetObjects["blInfo"].GetCellValue(1, "blInfo_bkg_no") + "']";
                    strArg += " form_usrId['" + strUsr_id + "']";
                    strArg += " form_ofcCd['" + lginOfcCd + "']";
                    strArg += " form_mainOnly[N]";  

                    strArg += " " + mrdParam;    
                    
                    var rdParam=strArg + " /riprnmargin /rwait";
                    var strPath=RD_path+ formObject.com_mrdPath.value;
                    appendReport.push({mrdPath:strPath, mrdParam:RDServer + rdParam});
            	}
            }  
        	 directReportDownload(appendReport);
        }
    }
    
    
    function fncTextareaMaxLine(obj){
        var str_line=obj;
        line=str_line.split("\r\n");
        ln=line.length;
        if(ln == 5 && event.keyCode == 13){
            event.returnValue=false;
        }
    }
    function fnSearchContainer(){
        var formObj=document.form;
        if (ComIsNull(formObj.cntr_no)) return;
        if(document.getElementById("h_cntr_no").value == document.getElementById("cntr_no").value) {
            return;
        }
        document.getElementById("h_cntr_no").value=document.getElementById("cntr_no").value;
        formObj.f_cmd.value=SEARCH01;
        sheetObjects["partial"].DoSearch("ESM_BKG_0292GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("partial_") );
    }
    
    function fnButtonControl(){
        var rlse_sts_cd=document.form.rlse_sts_cd.value;
        var holdFlg=document.form.evnt_flag.value;
        
//        if (document.form.dubai_mrd_id.value != "") {
//        	document.getElementById("dubai").style.display="block";
//        	
//        } else {
//        	document.getElementById("dubai").style.display="none";
//        }
        
        if (sheetObjects["blInfo"].RowCount()== 0) {
            buttonDisabledAll();
            ComBtnEnable("btn_Retrieve");
            return;
        }
        
        if (lginCntCd == "VN") {
            ComBtnEnable("btn_cy");
        } else {
            ComBtnDisable("btn_cy");
        }
        
        if (holdFlg == "R") {
            ComBtnEnable("btn_Retrieve");
            ComBtnEnable("btn_save");
            ComBtnEnable("btn_history");
            
            ComBtnDisable("btn_release");
            ComBtnDisable("btn_cancel");
            
            if (rlse_sts_cd == "R") {
                ComBtnDisable("btn_preview");
//                setButtonDubaiPreview(false);
                ComBtnDisable("btn_print");
                ComBtnEnable("btn_receiverinfo");
                ComBtnEnable("btn_remark");
            } else {
                ComBtnDisable("btn_preview");
//                setButtonDubaiPreview(false);
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
        	ComBtnEnable("btn_hold");
            ComBtnDisable("btn_unhold");
            
            if (rlse_sts_cd == "") {
                ComBtnEnable("btn_Retrieve");
                ComBtnEnable("btn_save");
                ComBtnEnable("btn_preview");
//                setButtonDubaiPreview(false);
                ComBtnEnable("btn_print");
                ComBtnEnable("btn_release");
                ComBtnEnable("btn_history");
                ComBtnDisable("btn_receiverinfo");
                ComBtnEnable("btn_cancel");
                ComBtnDisable("btn_remark");
	        } else if (rlse_sts_cd == "R") {
                ComBtnEnable("btn_Retrieve");
                ComBtnEnable("btn_save");
                ComBtnEnable("btn_preview");
                ComBtnEnable("btn_print");
                ComBtnDisable("btn_release");
//                setButtonDubaiPreview(true);
                ComBtnEnable("btn_history");
                ComBtnEnable("btn_receiverinfo");
                ComBtnEnable("btn_cancel");
                ComBtnEnable("btn_remark");
	        }
        }
    }
    /**
    * trim condition
    */
    function conditionTrim(){
        document.getElementById("bl_no").value=document.getElementById("bl_no").value.trim();
        document.getElementById("bkg_no").value=document.getElementById("bkg_no").value.trim();
        document.getElementById("cntr_no").value=document.getElementById("cntr_no").value.trim();
    }
    function preview() {
        var formObject=document.form;
        if(document.getElementById("evnt_flag").value == 'R'){
        	ComShowCodeMessage('BKG40107', sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no"), "Preview");
            return;
        }
//        doNo=sheetObjects["doRlseSts"].GetCellValue(1, "doRlseSts_do_no");//BL 단위
        if (document.form.split_flg[0].checked == true) {
            doNo = sheetObjects["doRlseStsBl"].GetCellValue(1, "doRlseStsBl_do_no");       //per BL
        } else {

            doNo = fnFindDoNo();

            if (doNo == "") {
                var blNo = "";
                if (sheetObjects["blInfo"].RowCount() > 0) {
                    blNo = sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no");
                }
                    ComShowCodeMessage("BKG40059", blNo);
                return;
            }
        }          
        var mrdId=formObject.h_mrd_id.value;
        var mrdParam=formObject.h_mrd_param.value;
        if(mrdId == ""){
            ComShowCodeMessage("BKG40080");
            return;
        }
        if(doNo == ""){
            var blNo="";
            if (sheetObjects["blInfo"].RowCount()> 0) {
            	blNo=sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no");
            }
            ComShowCodeMessage("BKG40059", blNo);
            return;
        }
        formObject.com_mrdPath.value="apps/opus/esm/bkg/inbounddocumentation/cargoreleaseordermgt/cargoreleaseorder/report/"+ mrdId + ".mrd";
        var strArg="/rv ";
        strArg += " form_doNo['" + doNo + "']";
        strArg += " form_bkgNo['" + sheetObjects["blInfo"].GetCellValue(1, "blInfo_bkg_no") + "']";
        strArg += " form_usrId['" + strUsr_id + "']";
        strArg += " form_ofcCd['" + lginOfcCd + "']";
        strArg += " form_mainOnly[N]";  

        strArg += " " + mrdParam;
        formObject.com_mrdArguments.value=strArg;
        formObject.com_mrdTitle.value="Cargo Release Order";
        formObject.com_mrdDisableToolbar.value="";
        formObject.com_mrdBodyTitle.value="Cargo Release Order";
        ComOpenRDPopup();
    }
    /**
     * check remark
     */
    function chkRemark() {
    	if (document.form.blInfo_inter_rmk.value.length > 0 ) {
    		buttonColorSet("btn_hold_remark", "red");
    	} else {
    		buttonColorSet("btn_hold_remark", "gray");
    	}
    }
     /**
      * button disable
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
    
/*
    function setButtonDubaiPreview(enableFlag) {
    	var formObj = document.form;

        if (document.form.split_flg[0].checked == true) {
        	if (formObj.dubai_mrd_id.value != "" && sheetObjects["doRlseStsBl"].RowCount() > 0) {
        		if (enableFlag) {
        			ComBtnEnable("btn_dubai_preview");
        		} else {
        			ComBtnDisable("btn_dubai_preview");
        		}
        	} else {
        		ComBtnDisable("btn_dubai_preview");
        	}        	
        } else {

            doNo = fnFindDoNo();

            if (doNo != "") {
        		if (enableFlag) {
        			ComBtnEnable("btn_dubai_preview");
        		} else {
        			ComBtnDisable("btn_dubai_preview");
        		}
        	} else {
        		ComBtnDisable("btn_dubai_preview");
        	}        	
        }
    }
    
    function dubaiPreview() {
        var formObject = document.form;
        var doNo = "";
     // POD/DEL이 AEQIV & AEAJM 
      if((formObject.dubai_mrd_id.value == 'ESM_BKG_5035' )|| (formObject.dubai_mrd_id.value == 'ESM_BKG_5036')){ 
        //RD 정보 구해오기
//        var doNo = sheetObjects["doRlseSts"].GetCellValue(1, "doRlseSts_do_no");
    	  
          if (document.form.split_flg[0].checked == true) {
              doNo = sheetObjects["doRlseStsBl"].GetCellValue(1, "doRlseStsBl_do_no");       //per BL
          } else {

              doNo = fnFindDoNo();

              if (doNo == "") {
                  var blNo = "";
                  if (sheetObjects["blInfo"].RowCount() > 0) {
                      blNo = sheetObjects["blInfo"].GetCellValue(1, "blInfo_bl_no");
                  }
                      ComShowCodeMessage("BKG40059", blNo);
                  return;
              }
          }    	  
	        var bkgNo = sheetObjects["blInfo"].GetCellValue(1, "blInfo_bkg_no");
	        var mrdId = formObject.dubai_mrd_id.value;
	
	        formObject.com_mrdPath.value = "apps/alps/esm/bkg/inbounddocumentation/cargoreleaseordermgt/cargoreleaseorder/report/"+ mrdId + ".mrd";
	        var strArg = "/rv ";
	        strArg += " form_doNo['" + doNo + "']";
	        strArg += " form_bkgNo['" + bkgNo + "']";
	        
	        formObject.com_mrdArguments.value = strArg;
	        formObject.com_mrdTitle.value = "Cargo Release Order";
	        formObject.com_mrdDisableToolbar.value = "";
	        formObject.com_mrdBodyTitle.value = "Cargo Release Order";
	        
	        ComOpenRDPopup();
	        // POD/DEL이 AUHBS
        }
    }    
    */
    
    
    /**
     * handling process after ending doRlseStsCntr save
     * @param sheetObj
     * @param ErrMsg
     * @return
     */
    function doRlseStsCntr_OnSaveEnd(sheetObj, ErrMsg){
            doActionIBSheet(sheetObj, document.form,IBSEARCH);
    }

   /**
    * handling process after ending doRlseStsBl save
    * @param sheetObj
    * @param ErrMsg
    * @return
    */
   function doRlseStsBl_OnSaveEnd(sheetObj, ErrMsg){
           doActionIBSheet(sheetObj, document.form,IBSEARCH);
   }    
   
   /**
    * handling process after ending doRlseStsCntr retrieve
    * @param sheetObj
    * @param ErrMsg
    * @return
    */
   function doRlseStsCntr_OnSearchEnd(sheetObj, ErrMsg){
       if (ErrMsg == "") {
           if (document.form.refInfo_do_split_flg.value == "N") return;

           if(sheetObj.RowCount() > 0){

               //setting D/O status to Hidden Value
               for(var idx=1; idx <= sheetObj.RowCount(); idx++){

                   //leave value before cancel
            	   
                   if(sheetObj.GetCellValue(idx, "doRlseStsCntr_rlse_sts_cd") != 'C'){
                       document.getElementById("rlse_sts_cd").value = sheetObj.GetCellValue(idx, "doRlseStsCntr_rlse_sts_cd");
                   }

                   //setting to last row
                   if(idx == sheetObj.RowCount()){
                       document.getElementById("last_rlse_sts_cd").value = sheetObj.GetCellValue(idx, "doRlseStsCntr_rlse_sts_cd");
                   }

               }

               //setting D/O no to Hidden value
               document.getElementById("h_do_no").value = sheetObj.GetCellValue(1, "doRlseStsCntr_do_no");

               var headRow = sheetObjects["doRlseStsCntr"].HeaderRows();
               var splitYn = false;
               
               for(var idx=0; idx <= sheetObjects["doRlseStsCntr"].LastRow(); idx++){
                   if (sheetObjects["doRlseStsCntr"].GetCellValue(idx, "doRlseStsCntr_rlse_sts_cd") == "R") {
                       splitYn = true;
                   }
               }

               if (document.getElementById("blInfo_pod_cd").value.substring(0,2) == 'CA') {
                   document.form.split_flg[0].disabled = true;
                   document.form.split_flg[1].disabled = true;
               } else {
                   //all data is Cancel
                   if(splitYn == false){
                       document.form.split_flg[0].disabled = false;
                       document.form.split_flg[1].disabled = false;
                   } else {
                       document.form.split_flg[0].disabled = true;
                       document.form.split_flg[1].disabled = true;
                   }
               }

               // value before D/O Event
               document.getElementById("pre_ctnt").value = sheetObj.GetCellValue(1, "doRlseSts_rlse_sts_cd");
               //High-Light bottom
//               sheetObj.SelectCell(sheetObj.RowCount(),0)
           }
       }
   }

   /**
    * handling process after ending doRlseStsBl retrieve
    * @param sheetObj
    * @param ErrMsg
    * @return
    */
   function doRlseStsBl_OnSearchEnd(sheetObj, ErrMsg){
       if (ErrMsg == "") {

           if (document.form.refInfo_do_split_flg.value == "Y") return;

           if(sheetObj.RowCount() > 0){

           //setting D/O status to Hidden Value
           for(var idx=1; idx <= sheetObj.RowCount(); idx++){

               //leave value before cancel
               if(sheetObj.GetCellValue(idx, "doRlseStsBl_rlse_sts_cd") != 'C'){
                   document.getElementById("rlse_sts_cd").value = sheetObj.GetCellValue(idx, "doRlseStsBl_rlse_sts_cd");
               }

               //setting last row
               if(idx == sheetObj.RowCount()){
                   document.getElementById("last_rlse_sts_cd").value = sheetObj.GetCellValue(idx, "doRlseStsBl_rlse_sts_cd");
               }
           }

           //setting D/O to Hidden Value
           document.getElementById("h_do_no").value = sheetObj.GetCellValue(1, "doRlseStsBl_do_no");

           if (document.getElementById("blInfo_pod_cd").value.substring(0,2) == 'CA') {
               document.form.split_flg[0].disabled = true;
               document.form.split_flg[1].disabled = true;
           } else {
	           //when all data Cancel 
	           if(sheetObj.RowCount() == 1 && sheetObj.GetCellValue(1, "doRlseStsBl_rlse_sts_cd") == 'C'){
	               document.form.split_flg[0].disabled = false;
	               document.form.split_flg[1].disabled = false;
	           } else {
	               document.form.split_flg[0].disabled = true;
	               document.form.split_flg[1].disabled = true;
	           }
           }
           
           document.getElementById("pre_ctnt").value = sheetObj.GetCellValue(1, "doRlseStsBl_rlse_sts_cd");
           //High-Light bottom
           sheetObj.SelectCell(sheetObj.RowCount(),0)
           }
       }
   }
   
   /**
    * setting split flag
    * @param splitFlg
    * @return
    */
   function setSplitFlag(splitFlg) {
       if (splitFlg == "N") {
           sheetObjects["doRlseStsBl"].SetSheetHeight(130);
           sheetObjects["doRlseStsCntr"].SetVisible(0);
           sheetObjects["doRlseStsBl"].SetVisible(1);
           document.form.refInfo_do_split_flg.value="N";
           document.getElementById("div_remain_cnt").style.visibility="hidden";
       } else {
           document.form.refInfo_do_split_flg.value="Y";
           sheetObjects["doRlseStsBl"].SetVisible(0);
           sheetObjects["doRlseStsCntr"].SetVisible(1);
           sheetObjects["doRlseStsCntr"].SetSheetHeight(130);
           document.getElementById("div_remain_cnt").style.visibility="visible";
       }
   }   
   
   function fnReleaseYn() {
       var formObj = document.form;
       var chkCount=0;
       chkRowCnt=0;
       if(sheetObjects["blInfo"].RowCount()== 0) return false;
       
       if (document.form.split_flg[0].checked == true) {
           document.form.refInfo_do_split_flg.value = "N";
       } else {
           document.form.refInfo_do_split_flg.value = "Y";
       }   
       
       if (formObj.refInfo_do_split_flg.value == "N") {
           chkRowCnt=1;
           
      	   chkRowCount = 0;
    	   chkReleaseCount = 0;
    	   chkNoReleaseCount = 0;
           
           if(sheetObjects["doRlseStsBl"].RowCount()== 1 && sheetObjects["doRlseStsBl"].GetCellValue(1, "doRlseStsBl_rlse_sts_cd") == 'R'){
               return true;
           } else {
               return false;
           }
       } else {
           if(sheetObjects["doRlseStsCntr"].RowCount()> 0) {
               chkRowCount = 0;
          	   chkReleaseCount = 0;
          	   chkNoReleaseCount = 0;
        	   
        	   if (sheetObjects["doRlseStsCntr"].CheckedRows("doRlseStsCntr_cntr_chk") != 0) {
                   // read row of check row in case of SaveName = 'Pass_yn'
                   var iCheckRow2=sheetObjects["doRlseStsCntr"].FindCheckedRow("doRlseStsCntr_cntr_chk");
                   // composition array
                   var arrRow=iCheckRow2.split("|");
                   
                   var releaseYn = "";
                   
                   chkRowCount = arrRow.length;
                   
                   for (idx=0; idx<arrRow.length; idx++){
                       chkRowCnt=chkRowCnt + 1;
                       if (sheetObjects["doRlseStsCntr"].GetCellValue(arrRow[idx], "doRlseStsCntr_rlse_sts_cd") == 'R') {
                    	   chkReleaseCount = chkReleaseCount + 1;
                    	   releaseYn = "Y";
                       } else {
                      	 chkNoReleaseCount = chkNoReleaseCount + 1;
                      	 releaseYn = "";
                       }
                   }
                   
//                   if (releaseYn == "Y") {
//                   	return true;
//                   } else {
//                   	return false;
//                   }
                   
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

   /**
    * find Do No
    */
   function fnFindDoNo() {
       var formObj = document.form;
       var doNo = "";
       if(sheetObjects["doRlseStsCntr"].RowCount() > 0) {

           if (sheetObjects["doRlseStsCntr"].CheckedRows("doRlseStsCntr_cntr_chk") != 0) {
               //read row of check row in case of SaveName = 'Pass_yn'
               var iCheckRow2 = sheetObjects["doRlseStsCntr"].FindCheckedRow("doRlseStsCntr_cntr_chk");

               //composition array
               var arrRow = iCheckRow2.split("|");
               doNo = sheetObjects["doRlseStsCntr"].GetCellValue(arrRow[0], "doRlseStsCntr_do_no");

               return doNo;
           } else {
               // no checked row
               return "";
           }

       } else {
           return "";
       }
   }
