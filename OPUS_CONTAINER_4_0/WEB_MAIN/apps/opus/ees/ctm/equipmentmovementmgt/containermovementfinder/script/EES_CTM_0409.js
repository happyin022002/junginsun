/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ees_ctm_0409.js
*@FileTitle : Each Booking
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/22
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// common global variables
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;
var tabName = new Array();
tabName[0] = "  Booking Information  ";
tabName[1] = "EQR Ref. No Information";
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
// Event handler processing by button click event  */
document.onclick=processButtonClick;
// Event handler processing by button name */
    function processButtonClick() {
        var sheetObj=sheetObjects[0];
    	var tabObject = tabObjects[0];
        var frmObj=document.form;
        try {
            var srcName=ComGetEvent("name");
            if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
                case "btn_retrieve":
                    if (!checkFormField()) return;
                    if (frmObj.bkg_no.value.trim() != "") {
                        var bkgNo=frmObj.bkg_no.value.trim();
                        // initializing all Objects
                        obj_clear();
                        // setting variables in HTML Object
                        frmObj.bkg_no.value=bkgNo;
                        tabObjects[0].SetSelectedIndex(0);
                        doActionIBSheet(sheetObj, frmObj, IBSEARCH);
                    } else if (frmObj.bl_no.value.trim() != "") {
                        var fullBlNo=frmObj.bl_no.value.trim();
                        // initializing all Objects
                        obj_clear();
                        // setting variables in HTML Object
                        frmObj.bl_no.value=fullBlNo;
                        tabObjects[0].SetSelectedIndex(0);
                        doActionIBSheet(sheetObj, frmObj, IBSEARCH);
                    } else if (frmObj.mty_pln_no.value.trim() != "") {
                    	var mtyPlnNo=frmObj.mty_pln_no.value.trim();
                        // initializing all Objects
                        obj_clear();
                        // setting variables in HTML Object
                        frmObj.mty_pln_no.value=mtyPlnNo;
                        tabObjects[0].SetSelectedIndex(1);
                        doActionIBSheet(sheetObj, frmObj, SEARCH01);
                    } else {
                        ComShowCodeMessage("CTM00000");
                        frmObj.bkg_no.focus();
                        return;
                    }
                    break;
                case "btn_new":
                    // initializing all Objects
                    obj_clear();
                    frmObj.bkg_no.value="";    
                    frmObj.mty_pln_no.value="";    
                    // making button Disable
                    ComBtnDisable("btn_eachcntr");
                    ComBtnDisable("btn_report");
                    frmObj.bkg_no.focus();
                    break;
                case "btn_eachcntr":
                    // calling function sheet1_OnDblClick
                    sheet1_OnDblClick(sheetObj, sheetObj.GetSelectRow());
                    break;
                case "btn_report":
                    // /rp [bkg_no][usrId][usrOfc][preVvd][postVvd][splitInfo]
                    //     [cntrTpszCd0][opCntrQty0][cntrTpszCd1][opCntrQty1][cntrTpszCd2][opCntrQty2]
                    // /rp [bkg_no][usrId][usrOfc]
                    //     [preVvd][postVvd][splitInfo][cntrTpszCd]
                    var paperType="";
                    if (document.form.cnt_cd.value == "US") {
                        paperType="/rpaper [LETTER] ";
                    } else {
                        paperType="/rpaper [A4] ";
                    }
                    frmObj.com_mrdArguments.value=paperType + "/rp [" + frmObj.bkg_no.value + "][" + frmObj.usrId.value + "][" + frmObj.usrOfc.value + "]" +
                                                    "[" + pre_vvd.GetSelectText()+ "][" + post_vvd.GetSelectText()+ "][" + split_info.GetSelectText()+ "][" + cntr_tpsz_cd.GetSelectText()+ "]";
                    ComOpenRDPopup("resizable=yes, width=1000, height=600");
                    break;
                case "btn_close":
                    ComClosePopup(); 
                    break; 	       
            	case "btn_0472Pop":
            		ComOpenPopup("/opuscntr/EES_CTM_0472_POP.do?", 1000, 600, "setBkgNoFromBKGSearchPopup", "0,1", true);
    				break;
            	case "btn_0473Pop":
            		ComOpenPopup("/opuscntr/EES_CTM_0473_POP.do?", 1000, 600, "setMtyPlnNoFromEQRRefSearchPopup", "0,1", true);
            		break;
            } // end switch
        } catch(e) {
            if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e.message);
            }
        }
    }

    function setBkgNoFromBKGSearchPopup(rtnValue) {
        var frm=document.form;
        var obj1=sheetObjects[0];
        if (rtnValue == "" || rtnValue == undefined) {
        	return;
        } else {
        	obj_clear();
        	frm.bkg_no.value = rtnValue;
        	if (tabObjects[0].GetSelectedIndex() == 0) {
            	doActionIBSheet(sheetObjects[0], frm, IBSEARCH);
        	} else {
        		tabObjects[0].SetSelectedIndex(0);
        	}
        }
    }

    function setMtyPlnNoFromEQRRefSearchPopup(rtnValue) {
        var frm=document.form;
        var obj1=sheetObjects[0];
        if (rtnValue == "" || rtnValue == undefined) {
        	return;
        } else {
        	obj_clear();
        	frm.mty_pln_no.value = rtnValue;
        	if (tabObjects[0].GetSelectedIndex() == 1) {
            	doActionIBSheet(sheetObjects[0], frm, SEARCH01);
        	} else {
        		tabObjects[0].SetSelectedIndex(1);
        	}
        }
    }
    /**
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     */
    function setSheetObject(sheet_obj) {
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * registering IBMultiCombo Object as list
     * param : combo_obj
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     */
    function setComboObject(combo_obj) {
       comboObjects[comboCnt++]=combo_obj;
    }
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i], i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        
        for (k = 0; k < tabObjects.length; k++) {
			initTab(tabObjects[k], k + 1);
			tabObjects[k].SetSelectedIndex(0);
		}
        
        
        // CTM-COMMON
        setEventProcess();
        // making button Disable
        ComBtnDisable("btn_eachcntr");
        ComBtnDisable("btn_report");
        axon_event.addListener('change', 'bkg_Change', 'bkg_no');
        axon_event.addListener('change', 'bl_Change', 'bl_no');
        axon_event.addListener('change', 'ref_Change', 'mty_pln_no');
        // retrieving country code by login user office code
        doActionIBSheet(sheetObjects[0], document.form, COMMAND05);
        if (document.form.bkg_no.value) {
            tabObjects[0].SetSelectedIndex(0);
        } else if (document.form.mty_pln_no.value) {
            tabObjects[0].SetSelectedIndex(1);
        }
        // focusing on page loading
    }
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj, sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      //sheet1 init
                  with(sheetObj){
                       var HeadTitle="Seq.|Container No.|T/S|STS|Event Date|Origin YD|Return YD|Seal No.|Chassis No.|M.G Set|Update Date|Creation Date";
                       SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
                       var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                       var headers = [ { Text:HeadTitle, Align:"Center"} ];
                       InitHeaders(headers, info);
                       var cols = [ {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"SEQ" },
                                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_sts_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"cnmv_evnt_dt",  KeyField:0,   CalcLogic:"",   Format:"YmdHms",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:19 },
                                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"org_yd_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"dest_yd_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cntr_seal_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"chss_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"mgst_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"upd_dt",        KeyField:0,   CalcLogic:"",   Format:"YmdHms",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:19 },
                                 {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"cre_dt",        KeyField:0,   CalcLogic:"",   Format:"YmdHms",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:19 } ];
                        
                       InitColumns(cols);
                       SetEditable(0);
//                       SetSheetHeight(322);
                       resizeSheet();
                  }
               break;
        }
    }
    //handling process for Sheet
    function doActionIBSheet(sheetObj, frmObj, sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
            case IBSEARCH:                  
                if(validateForm(sheetObj, frmObj, sAction)) {             
                    ComOpenWait(true);  
                    sheetObj.DoSearchFx("EES_CTM_0409GS.do", "f_cmd=" + SEARCH + "&bkg_no=" + frmObj.bkg_no.value + "&bl_no=" + frmObj.bl_no.value );         
                    ComOpenWait(false);  
                }
                break;
            case SEARCH01:                  
                if(validateForm(sheetObj, frmObj, sAction)) {  
                    ComOpenWait(true);           
//                    sheetObj.SetWaitImageVisible(0);  
                    sheetObj.DoSearchFx("EES_CTM_0409GS.do", "f_cmd=" + SEARCH01 + "&mty_pln_no=" + frmObj.mty_pln_no.value );       
                    ComOpenWait(false);  
//                    sheetObj.SetWaitImageVisible(0);                           
                }
                break;
            case COMMAND05:
                // retrieving country code by login user office code
                 frmObj.cnt_cd.value=ComGetEtcData(sheetObj.GetSearchData("CTMCommonGS.do?f_cmd=" + COMMAND05), "rtnValue");
                break;
        }
    }
    /**
     * initializing all objects
     */
    function obj_clear() {
        ComResetAll();
        sheetObjects[0].RemoveEtcData();
        for (i=0; i<comboObjects.length; i++) {
            comboObjects[i].RemoveAll();
        }
    }
    /**
     * handling OnSearchEnd event in Sheet1
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {  
        if (ErrMsg == "") {
            with (sheetObj) {
               // checking ETC-DATA 
                if (document.form.bkg_no.value.trim() != "" && tabObjects[0].GetSelectedIndex() == 0) {   
                    var frmObj=document.form;
                    // setting in FORM element from ETC-DATA
                    ComEtcDataToForm(frmObj, sheetObj);
                    // setting initial value for IBMulticombo
                    pre_vvd.SetSelectCode(GetEtcData("pre_pol_cd"));
                    split_info.SetSelectCode(GetEtcData("split_bkg_no_split"));
                    post_vvd.SetSelectCode(GetEtcData("post_pol_cd"));
                    // setting header of IBMulticombo
                    split_info.SetTitle("Booking No.||B/L No.");
                    // making btn_report Enable
                    ComBtnEnable("btn_report");
                    ComBtnEnable("btn_eachcntr");
                    split_info.SetTitleVisible(true);
                    split_info.SetTitle("Booking No.|   |B/L No.");
                    
                    parseMultiCombo(pre_vvd, GetEtcData("preVvd_comboCode"), GetEtcData("preVvd_comboText"));
                    parseMultiCombo(split_info, GetEtcData("splitInfo_comboCode"), GetEtcData("splitInfo_comboText"));
                    parseMultiCombo(post_vvd, GetEtcData("postVvd_comboCode"), GetEtcData("postVvd_comboText"));
                    parseMultiCombo(cntr_tpsz_cd, GetEtcData("cntrTpsz_comboCode"), GetEtcData("cntrTpsz_comboText"));

                    cntr_tpsz_cd.SetSelectIndex(0);
                } else if (document.form.mty_pln_no.value.trim() != "" && tabObjects[0].GetSelectedIndex() == 1) {  
                	var frmObj=document.form;
                    // setting in FORM element from ETC-DATA
                    ComEtcDataToForm(frmObj, sheetObj);
                    // making btn_report Enable
                    ComBtnEnable("btn_eachcntr");

                    parseMultiCombo(wo_no, GetEtcData("woNo_comboCode"), GetEtcData("woNo_comboText"));
                    parseMultiCombo(eq_tpsz_cd, GetEtcData("eqTpsz_comboCode"), GetEtcData("eqTpsz_comboText"));
                    frmObj.bl_no.value = document.form.bkg_no.value.trim();

                    wo_no.SetSelectIndex(0);
                    eq_tpsz_cd.SetSelectIndex(0);
                }
                // calling function sheet1_OnClick
                sheet1_OnClick(sheetObj, GetSelectRow(), "cntr_no");
            }
        }
        ComOpenWait(false);
    }
    /**
     * registering IBTab Object as list adding process for list in case of needing
     * batch processing with other items defining list on the top of source
     */
    function setTabObject(tab_obj) {
    	tabObjects[tabCnt++] = tab_obj;
    }
    /**
     * initializing Tab setting Tab items
     */
    function initTab(tabObj, tabNo) {
    	switch (tabNo) {
    	case 1:
    		with (tabObj) {
    			var cnt = 0;
    			InsertItem(tabName[0], "");
    			InsertItem(tabName[1], "");
    		}
    		break;
    	}
    }
    /**
     * handling changing event on tab
     */
    function tab1_OnChange(tabObj, nItem) {
    	var formObject = document.form;
    	// ------------- tab start -----------------
    	var objs = document.all.item("tabLayer");
    	objs[nItem].style.display = "Inline";
    	objs[beforetab].style.display = "none";
    	// --------------- Important --------------------------//
    	objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1;
    	// ------------------------------------------------------//
    	beforetab = nItem;

    	var sel_tab = tab1.GetSelectedIndex();
    	if (sel_tab == 0) {
    		doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
    	} 
    	if (sel_tab == 1) {        
    		doActionIBSheet(sheetObjects[0], formObject, SEARCH01); 
    	}
    	resizeSheet();
    }

    function bkg_Change(event) {
        eventElement=ComGetEvent();
    	tab1.SetSelectedIndex(0);
    }

    function bl_Change(event) {
        eventElement=ComGetEvent();
    	tab1.SetSelectedIndex(0);
    }

    function ref_Change(event) {
        eventElement=ComGetEvent();
    	tab1.SetSelectedIndex(1);
    }
    /**
     * event when clicking cell in IBSheet data part
     * @param {sheetObj} String :  IBSheet cell name
     * @param {Row} Long : cell Row Index
     * @param {Col} Long : cell Column Index
     * @param {Value} String : changed value
     * @param {CellX} Long : cell x-coordinate
     * @param {CellY} Long : cell y-coordinate
     * @param {CellW} Long : cell width
     * @param {CellH} Long : cell length
     */
    function sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
        with (sheetObj) {
            if (ComGetLenByByte(GetCellValue(Row, "cntr_no")) > 0) {
                // making btn_eachbkg Enable
                ComBtnEnable("btn_eachcntr");
            } else {
                // making btn_eachbkg Disable
                ComBtnDisable("btn_eachcntr");
            }
        }
    }
    /**
     * event when double clicking cell in IBSheet data part
     * @param {sheetObj} String :  IBSheet cell name
     * @param {Row} Long : cell Row Index
     * @param {Col} Long : cell Column Index
     * @param {Value} String : changed value
     * @param {CellX} Long : cell x-coordinate
     * @param {CellY} Long : cell y-coordinate
     * @param {CellW} Long : cell width
     * @param {CellH} Long : cell length
     */
    function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH) {
        with (sheetObj) {
            if (ComGetLenByByte(GetCellValue(Row, "cntr_no")) > 0) {
                var cnmvEvntDt=GetCellValue(Row , "cnmv_evnt_dt").substring(0, 10);
                ComOpenPopup("/opuscntr/EES_CTM_0408_POP.do?" +
                             "p_cntrno=" + GetCellValue(Row , "cntr_no") + "&" +
//                             "check_digit=" + GetCellValue(Row , "cntr_no").substring(10, 11) + "&" +
                             "ctnr_tpsz_cd=" + GetCellValue(Row , "cntr_tpsz_cd") + "&" +
                             "p_date1=" + ComGetDateAdd(cnmvEvntDt, "M", -1) + "&" +
                             "p_date2=" + ComGetDateAdd(cnmvEvntDt, "M", 1), 1020, 700, "", "0,1");
            }
        }
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj, frmObj, sAction) {
        with(frmObj) {
        }
        return true;
    }

    function split_info_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
        split_info_text.value = newCode;
    }
   
    function split_info_OnBlur(comboObj) {
       split_info_text.value = comboObj.GetSelectCode();
    }
    
    function cntr_tpsz_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
//        cntr_tpsz_cd_text.value = newCode;
    }
    
    function wo_no_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
//      eq_tpsz_cd_text.value = newCode;
    }
    
    function eq_tpsz_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
//      eq_tpsz_cd_text.value = newCode;
    }
   
    function cntr_tpsz_cd_OnBlur(comboObj) {
       cntr_tpsz_cd_text.value = comboObj.GetSelectText();
    }
   
    function wo_no_OnBlur(comboObj) {
       wo_no_text.value = comboObj.GetSelectText();
    }
   
    function eq_tpsz_cd_OnBlur(comboObj) {
       eq_tpsz_cd_text.value = comboObj.GetSelectText();
    }
    function resizeSheet(){
		ComResizeSheet(sheetObjects[0]);
	}