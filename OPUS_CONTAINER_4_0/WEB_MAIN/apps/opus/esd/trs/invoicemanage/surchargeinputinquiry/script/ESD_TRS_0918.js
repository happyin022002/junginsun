/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0918.js
*@FileTitle  : surcharge managing
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/21
=========================================================*/
/*------------------From here the common JavaScript function is defined.     ------------------*/
/* Common global variable */
var prefix='surcharge_';
var invfix='';
var sheetObjects=new Array();
var sheetCnt=0;
var saveFlag=false;
var openObject = opener;
if(!openObject) {
	openObject = parent;
}


/* Click the button to define an event handler that receives and processes events */
document.onclick=processButtonClick;
/* Button to process certain filename, separated on a quarterly event handler to handle  */
function processButtonClick(){
     var sheetObject=sheetObjects[1];
     var formObject=document.form;
     try {
         var srcName=ComGetEvent("name");
         switch(srcName) {
             case "btn_close":
                 if(saveFlag) return;
                ComClosePopup(); 
            break;
            
            case "btn_save":
                if(saveFlag) return;
                if(formObject.open_mode.value != 'search')
                doActionIBSheet(sheetObject,formObject,IBSAVE);
            break;
            
            case "btns_calendar":
                if(saveFlag) return;
                   if(formObject.open_mode.value != 'search' && formObject.SCPPAL_chk.checked) getCalendar();
            break;
            
            case "btns_calendar2":
                if(saveFlag) return;
                   if(formObject.open_mode.value != 'search' && formObject.SCCDAL_chk.checked) getCalendar2();
            break;
            
            case "btns_stop_loc":
                if(saveFlag) return;
                if(formObject.open_mode.value != 'search' && formObject.SCMDAL_chk.checked) openHireYardPopup('stop_node');
            break;
            
            case "btns_scale_loc":
                if(saveFlag) return;
                if(formObject.open_mode.value != 'search' && formObject.SCSSAL_chk.checked) openHireYardPopup('scale_node');
            break;
            
        } // end switch
    }catch(e) {
        if( e == "[object Error]") {
            ComShowCodeMessage('COM12111');
        } else {
            ComShowMessage(e.message);
        }
    }
}

/**
 * Register as an array IBTab Object
 * The next batch of other items when you need treatment of fiberglass can add to an array that holds the process
 * Array defined at the top of the source
 */
function setSheetObject(sheet_obj) {
   sheetObjects[sheetCnt++]=sheet_obj;
}

 /**
  * initializing sheet
  * implementing onLoad event handler in body tag
  * adding first-served functions after loading screen.
  */
function loadPage() {
    stop_yard.SetEnable(0);
    scale_yard.SetEnable(0);
    
    var formObj=document.form;

    // 2015.07.13 CHAN WOO PARK
    var fuel_scg_txt = eval('formObj.'+formObj.fuel_scg_cd.value+'_txt');
    var fuel_scg_chk = eval('formObj.'+formObj.fuel_scg_cd.value+'_chk');
    var po_fuel_scg_rt = formObj.po_fuel_scg_rt.value;
    fuel_scg_txt.value = Number(po_fuel_scg_rt).toFixed(2);
    
    if (po_fuel_scg_rt > 0) {
    	fuel_scg_chk.checked = true;
    }
    
    var sheetObj=sheetObjects[1];
    for(i=0;i<sheetObjects.length;i++){
        
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        
        ComEndConfigSheet(sheetObjects[i]);
    }
    if (formObj.step_cd.value=='IV'){
        invfix='inv_'
    }else{
        invfix='';
    }
    if(formObj.open_mode.value == 'search'){
        setDisplayForm(sheetObj, formObj);
    	if(formObj.step_cd.value != 'WO') {
    		 doActionIBSheet(sheetObj, formObj, 'SEARCH_BY_SHEET');
    	}
        if(sheetObj.RowCount()< 1){
            doActionIBSheet(sheetObj, formObj, IBSEARCH);
        }
    	
        calCurrencyChange(sheetObj, formObj);
        bindSheettoForm(sheetObj, formObj);
    }else if(formObj.open_mode.value == 'modify'){
        doActionIBSheet(sheetObj, formObj, 'SEARCH_BY_SHEET');
        if(sheetObj.RowCount() < 1){
            doActionIBSheet(sheetObj, formObj, IBSEARCH);
        }
        bindSheettoForm(sheetObj, formObj);
        setEnableForm(sheetObj, formObj);
        if (formObj.cgo_tp_cd.value == 'M') {
            formObj.SCENAL_chk.disabled=true;
        }
    }else if(formObj.open_mode.value == 'modify_supplement'){ // when double-click on ETC AMT column of Supplement(ESD_TRS_0016)
        doActionIBSheet(sheetObj, formObj, 'SEARCH_BY_SHEET');
        bindSheettoForm(sheetObj, formObj);
        setEnableForm(sheetObj, formObj);
        if (formObj.cgo_tp_cd.value == 'M') {
            formObj.SCENAL_chk.disabled=true;
        }
    }else if(formObj.open_mode.value == 'multiple'){
        setEnableForm(sheetObj, formObj); 
        if (formObj.cgo_tp_cd.value == 'M') {
            formObj.SCENAL_chk.disabled=true;
        }
    }
    
    doActionIBSheet(sheetObjects[2], formObj, 'SEARCH_CODE_NAME');
    checkTPBIf();
}
/**
* setting sheet initial values and header
* param : sheetObj, sheetNo
* adding case as numbers of counting sheets
*/
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    switch(sheetNo) {
	    case 1:      //Other sheet
	        with (sheetObj) {
	            var HeadTitle="Curr.|Amt|XCH RT" ;
	           SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1} );
	           var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };

	           var headers = [ { Text:HeadTitle, Align:"Center"} ];
	           InitHeaders(headers, info);
	           // TODO : wo_scg_xch_rt를 Hidden으로 변경
	           var cols = [ {Type:"Text",   Hidden:0, Width:60, Align:"Center", ColMerge:0, SaveName:"curr_cd",       KeyField:0, CalcLogic:"", Format:"",      PointCount:0, UpdateEdit:0, InsertEdit:0 },
	                        {Type:"Float",  Hidden:0, Width:80, Align:"Center", ColMerge:0, SaveName:"org_scg_amt",   KeyField:0, CalcLogic:"", Format:"Float", PointCount:2, UpdateEdit:1, InsertEdit:0 },
	                        {Type:"Float",  Hidden:1, Width:80, Align:"Center", ColMerge:0, SaveName:"wo_scg_xch_rt", KeyField:0, CalcLogic:"", Format:"Float", PointCount:6, UpdateEdit:0, InsertEdit:0 },
	                        {Type:"Status", Hidden:1, Width:0,  Align:"Center", ColMerge:1, SaveName:"ibflag" } ];
	           InitColumns(cols);
	           SetEditable(1);
	           // TODO : WITH를 160으로 변경
	           SetSheetWidth(160);
	           //SetSheetWidth(160);
	           SetCountPosition(0);
	           SetHeaderRowHeight(12);
	           SetDataRowHeight(12);
	           SetSheetHeight(76);
	           SetFocusAfterRowTransaction(false); // 행 추가/삭제/이동/복사 후 포커스 이동 안함
	           SetVisible(true);
	       }
	       break;
        case 2:      //sheet1 init
            with (sheetObj) {
            var HeadTitle="ibflag|ibcheck|unique_cd|trsp_so_ofc_cty_cd|trsp_so_seq|lgs_cost_cd|lgs_cost_full_nm|scg_amt" ;
            SetConfig( { SearchMode:0, MergeSheet:5, Page:20, DataRowMerge:0 } );
            var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
            var headers = [ { Text:HeadTitle, Align:"Center"} ];
            InitHeaders(headers, info);
            var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
                   {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibcheck" },
                   {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+'unique_cd',                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+'trsp_so_ofc_cty_cd',          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+'trsp_so_seq',                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+'lgs_cost_cd',                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+'lgs_cost_full_nm',            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+'scg_amt',                     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+'chss_no',                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'incur_dt',                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'dry_run_rlbl_pty_tp_cd',      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'fne_cuz_desc',                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'fumg_cost_tp_cd',             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'mgst_tpsz_cd',                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'insp_rf_pti_cstms_tp_cd',     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'lftg_knt',                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'lftg_cuz_desc',               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'stop_loc_nod_cd',             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'grs_wgt',                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'incrt_dt',                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'scl_stop_plc_nod_cd',         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'sto_dys',                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'ob_bkg_no',                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'wt_hrs',                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'otr_rmk',                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_scg_amt',                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_chss_no',                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_incur_dt',                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_dry_run_rlbl_pty_tp_cd',  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_fne_cuz_desc',            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_fumg_cost_tp_cd',         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_mgst_tpsz_cd',            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_insp_rf_pti_cstms_tp_cd', KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_lftg_knt',                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_lftg_cuz_desc',           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_stop_loc_nod_cd',         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_grs_wgt',                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_incrt_dt',                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_scl_stop_plc_nod_cd',     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_sto_dys',                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_ob_bkg_no',               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_wt_hrs',                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_otr_rmk',                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'n3pty_bil_flg',               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'cust_cnt_cd',                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'cust_seq',                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'n3pty_vndr_seq',              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'n3pty_ofc_cd',                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'n3pty_amt',                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'n3pty_desc',                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'cre_ofc_cd',                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'cre_usr_id',                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+'curr_cd',                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+'wo_scg_xch_rt',               KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:6,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+'org_scg_amt',                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 } ];
            InitColumns(cols);
            SetEditable(1);
            SetVisible(false);
           }
           break;
            case 3:      //t1sheet1 init
             with (sheetObj) {
                 var HeadTitle="" ;
                SetConfig( { SearchMode:0, MergeSheet:5, Page:20, DataRowMerge:1 } );
                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);
                var cols = [ {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"lgs_cost_full_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"lgs_cost_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Status",    Hidden:0, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" } ];
                InitColumns(cols);
                SetEditable(1);
                 SetVisible(0);
            }
            break;
           case 4:      //t1sheet1 init
            with (sheetObj) {
               var HeadTitle="SO OFC|SO SEQ|IF_FLG";
               SetConfig( { SearchMode:0, MergeSheet:5, Page:20, DataRowMerge:1 } );
               var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
               var headers = [ { Text:HeadTitle, Align:"Center"} ];
               InitHeaders(headers, info);
               var cols = [ {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:'if_so_ofc',  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:4 },
                {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:'if_so_seq',  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:4 },
                {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:'if_flg',     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:4 } ];
               InitColumns(cols);
               SetEditable(1);
               SetVisible(0);
            }
            break;     
    }
}

/**
 * handling of Sheet 
 */
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
        case IBSEARCH:
            formObj.f_cmd.value = SEARCH;
            sheetObj.DoSearch("ESD_TRS_0918GS.do", TrsFrmQryString(formObj) , {Sync:2} );
            break;
        case IBSAVE:
        	ComBtnDisable("btn_save");
        	var sheetObj2 = sheetObjects[3];
            var if_flg = sheetObj2.GetCellValue(1, 'if_flg');
            ComOpenWait(true);
            getSumTotalAmount();
            if (!validateForm(sheetObj,formObj,sAction)) {
                ComBtnEnable("btn_save");
                ComOpenWait(false);
                return false;
            }
            saveFlag = true;
            putData(sheetObj, formObj);
            if(formObj.open_mode.value == 'multiple') {
                setSurchargeInputInquiry_multiple( sheetObj, formObj);
            } else {
                setSurchargeInputInquiry( sheetObj, formObj);
            }
            saveFlag = false;

            ComOpenWait(false);

            if(formObj.open_mode.value == 'multiple') {
                ComShowCodeMessage('COM12116', 'Surcharge Apply');
            }

            ComClosePopup(); 
            break;

        case 'SEARCH_BY_SHEET':
            var queryStr='';
            var colName='';
            var sheetObj_surcharge=openObject.sheetObjects[formObj.sheet_arr_no.value];
            for(var row=1; row<sheetObj_surcharge.RowCount()+1; row++) {
                if(formObj.unique_cd.value == sheetObj_surcharge.GetCellValue(row, prefix+'unique_cd')) {
                    for(var i=0; i<= sheetObj_surcharge.LastCol(); i++) {
                        colName=sheetObj_surcharge.ColSaveName(i);
                        queryStr += '&'+colName +'='+sheetObj_surcharge.GetCellValue(row, colName);
                    }
                }
            }
            sheetObj.DoSearch("ESD_TRS_0969.screen", queryStr+"&"+ TrsFrmQryString(formObj),{Sync:2,Append:true} );
            break;
        case 'SEARCH_CODE_NAME':
        	formObj.f_cmd.value=SEARCH02;
            sheetObj.DoSearch("ESD_TRS_0918GS.do", TrsFrmQryString(formObj) );
            break;
    }
}

/**
 * Surcharge Input Inquiry popup receive data transmission from
 **/
function setSurchargeInputInquiry(pop_sheetObj, formObj){
    var row=formObj.main_row.value;
    var unique_cd=formObj.unique_cd.value;
    var surcharge_sheetObj=openObject.sheetObjects[formObj.sheet_arr_no.value];
    var main_sheetObj=openObject.sheetObjects[0];
    try{
        for(var a = surcharge_sheetObj.RowCount(); a > 0; a--) {
            if( surcharge_sheetObj.GetCellValue(a, prefix+'unique_cd') == unique_cd) 
            	surcharge_sheetObj.RowDelete(a, false);
        }
        
        var queryStr=pop_sheetObj.GetSaveString(true, true);
        if(queryStr != '') {
            var url='?prefix='+prefix;
            surcharge_sheetObj.DoSearch("ESD_TRS_0969.screen"+url, queryStr,{Sync:2, Append:true} );
        }
        
        if(ComIsNull(formObj.surcharge_total.value)) {
            main_sheetObj.SetCellValue(row, invfix+'etc_add_amt', '0.00', 0);
            
        	if(formObj.scg_ind_cd.value == 'S' ) { // W/O Issue(ESD_TRS_0023)에서 MODIFY모드로 팝업한 경우에 수정한 additional amount가 0이면 scg_ind_cd컬럼을 초기화함
        		main_sheetObj.SetCellValue(row, 'scg_ind_cd', '', 0);
        	}
        } else {
        	if (formObj.step_cd.value == "IV") {
        		main_sheetObj.SetCellValue(row, invfix+'etc_add_amt', Number(formObj.surcharge_total.value).toFixed(2), 0);
        	} else {
        		var fuel_scg_txt = eval('formObj.'+formObj.fuel_scg_cd.value+'_txt');
        		main_sheetObj.SetCellValue(row, invfix+'etc_add_amt', Number(formObj.surcharge_add.value), 0);
                main_sheetObj.SetCellValue(row, invfix+'po_fuel_scg_rt', fuel_scg_txt.value, 0);
        	}
        	
        	if(formObj.scg_ind_cd.value == 'S' ) { // W/O Issue(ESD_TRS_0023)에서 MODIFY모드로 팝업한 경우에 수정한 additional amount가 있으면 scg_ind_cd컬럼을 S(Surcharge Popup에서 수정됨)로 설정
        		if(formObj.surcharge_total.value == "0.00") {
            		main_sheetObj.SetCellValue(row, 'scg_ind_cd', '', 0);
        		} else {
            		main_sheetObj.SetCellValue(row, 'scg_ind_cd', 'S', 0);
        		}
        	}
        }
    } catch(e) {
        saveFlag=false;
        ComShowMessage(e.message);
    }
}

/**
 * Surcharge Input Inquiry popup receive data transmission from
 **/
function setSurchargeInputInquiry_multiple(pop_sheetObj, formObj) {
    var row=formObj.main_row.value;
    var unique_cd=formObj.unique_cd.value;
    var surcharge_sheetObj=openObject.sheetObjects[formObj.sheet_arr_no.value];
    var main_sheetObj=openObject.sheetObjects[0];

    try{
        var queryStr=pop_sheetObj.GetSaveString(true, true);
        var url='?prefix='+prefix;
        queryStr    += '&multi_ofc_cty_cdStr='    + multi_ofc_cty_cdStr;
        queryStr    += '&multi_so_seqStr='        + multi_so_seqStr;
        queryStr    += '&multi_cgo_tp_cdStr='    + multi_cgo_tp_cdStr;
        queryStr    += '&mode=copy_surcharge_popup';
        pop_sheetObj.DoSearch("ESD_TRS_0970.screen"+url, queryStr,{Sync:2,Append:false} );
        var main_surcharge_queryStr=surcharge_sheetObj.GetSaveString(true, true);
        main_surcharge_queryStr    += '&multi_ofc_cty_cdStr='    + multi_ofc_cty_cdStr;
        main_surcharge_queryStr    += '&multi_so_seqStr='        + multi_so_seqStr;
        main_surcharge_queryStr += '&mode=main_surcharge_dup_check';
        pop_sheetObj.DoSearch("ESD_TRS_0970.screen"+url, main_surcharge_queryStr,{Sync:2,Append:true} );
        queryStr=pop_sheetObj.GetSaveString(true, true);
        if(queryStr == '') {
            //surcharge_sheetObj.RemoveAll();
        }else{
            var url='?prefix='+prefix;
            surcharge_sheetObj.DoSearch("ESD_TRS_0969.screen"+url, queryStr,{Sync:2,Append:false} );
        }
        for(var k=0; k<multi_ofc_cty_cdArray.length;k++){
            console.log(main_sheetObj.GetCellValue(1, 'etc_add_amt'));
            console.log(main_sheetObj.GetCellValue(2, invfix+'etc_add_amt'));
            console.log(main_sheetObj.GetCellValue(3, invfix+'etc_add_amt'));
            console.log(main_sheetObj.GetCellValue(check_rowArray[k], invfix+'etc_add_amt'));
            
            if (formObj.step_cd.value == "IV") {
        		main_sheetObj.SetCellValue(check_rowArray[k], invfix+'etc_add_amt', Number(formObj.surcharge_total.value).toFixed(2));
        	} else {
        		var fuel_scg_txt = eval('formObj.'+formObj.fuel_scg_cd.value+'_txt');
        		main_sheetObj.SetCellValue(check_rowArray[k], invfix+'etc_add_amt', Number(formObj.surcharge_add.value), 0);
                main_sheetObj.SetCellValue(check_rowArray[k], invfix+'po_fuel_scg_rt', fuel_scg_txt.value, 0);
        	}
            console.log(main_sheetObj.GetCellValue(check_rowArray[k], invfix+'etc_add_amt'));
            if(formObj.step_cd.value != 'IV'){
                searchLocalCurr2UsdCurr(surcharge_sheetObj, main_sheetObj, openObject.document.form, check_rowArray[k]);
            }
            
    		if(formObj.surcharge_total.value == "0.00") {
        		main_sheetObj.SetCellValue(check_rowArray[k], invfix+'scg_ind_cd', '');
    		} else {
        		main_sheetObj.SetCellValue(check_rowArray[k], invfix+'scg_ind_cd', 'S');
    		}
        }
        if(formObj.step_cd.value == 'IV'){
        	openObject.setSumOfInvoiceTotalAmount2(main_sheetObj, openObject.document.form);
        }
    } catch(e) {
        saveFlag=false;
    }
}

function searchLocalCurr2UsdCurr(sheetObj, main_sheetObj, formObj, row){
    sheetObj.RemoveEtcData();
    if(main_sheetObj.GetCellValue(row, 'po_local_curr_cd') == '') return;
    var url='LOCAL_TOT_AMT='+main_sheetObj.GetCellValue(row, 'po_local_curr_tot_amt');
    url += '&CURR_CD='+main_sheetObj.GetCellValue(row, 'po_local_curr_cd');
    formObj.f_cmd.value=SEARCH03;
    sheetObj.DoSearch("ESD_TRS_0023GS.do", url+'&'+TrsFrmQryString(formObj), {Sync:2, Append:true});
    if(sheetObj.GetEtcData('amt_usd') != undefined && sheetObj.GetEtcData('amt_usd') != ''){
        main_sheetObj.SetCellValue(row, 'po_usd_curr_tot_amt',sheetObj.GetEtcData('amt_usd'),0);
    }
}

function calCurrencyChange(sheetObj, formObj){
    if(formObj.cal_logic.value == '' || formObj.cal_logic.value == null) return;
    var rateValue=Number(formObj.rate.value);
    var amt=0;
    switch(formObj.cal_logic.value){
        case('TM'):
            for(var i=1; i<sheetObj.RowCount()+1; i++){
                amt=Number(sheetObj.GetCellValue(i, prefix+invfix+'scg_amt'));
                sheetObj.SetCellValue(i, prefix+invfix+'scg_amt',myRound(amt * rateValue),0);
            }
        break;
        case('DV'):
            for(var i=1; i<sheetObj.RowCount()+1; i++){
                amt=Number(sheetObj.GetCellValue(i, prefix+invfix+'scg_amt'));
                sheetObj.SetCellValue(i, prefix+invfix+'scg_amt',myRound(amt / rateValue),0);
            }
        break;
    }
}

function bindSheettoForm(sheetObj, formObj){
    for(var i=1; i< sheetObj.RowCount()+1; i++) {
    	var lgs_cost_value = sheetObj.GetCellValue(i, prefix+'lgs_cost_cd').substring(2,4);
        if (lgs_cost_value == 'FU' || lgs_cost_value == 'FA') continue;
    	
        var lgs_cost_cd_value_tmp=sheetObj.GetCellValue(i, prefix+'lgs_cost_cd');
        lgs_cost_cd_value_tmp='SC'+lgs_cost_cd_value_tmp.substring(2);
        var chk_obj=eval('formObj.'+lgs_cost_cd_value_tmp+'_chk');
        var txt_obj=eval('formObj.'+lgs_cost_cd_value_tmp+'_txt');
        var scg_amt=sheetObj.GetCellValue(i, prefix+invfix+'scg_amt');
        var curr_obj=eval('formObj.'+lgs_cost_cd_value_tmp+'_txt2');
        var org_scg_obj=eval('formObj.'+lgs_cost_cd_value_tmp+'_txt3');
        var wo_scg_xch_rt_obj=eval('formObj.'+lgs_cost_cd_value_tmp+'_txt4');
        
        if(scg_amt == undefined || Number(scg_amt) == 0) continue;

        var lgs_cost_cd_value=sheetObj.GetCellValue(i, prefix+'lgs_cost_cd');
        
        if(formObj.curr_cd.value == 'JPY' || formObj.curr_cd.value == 'KRW' || formObj.curr_cd.value == 'TWD'){
            txt_obj.value = (Number(txt_obj.value) + Number(chkAmtPos_JPY(sheetObj.GetCellValue(i, prefix+invfix+'scg_amt')))).toFixed(2);
            if(lgs_cost_cd_value.substring(2) != 'OTAL') {
                org_scg_obj.value = (Number(org_scg_obj.value) + Number(chkAmtPos_JPY(sheetObj.GetCellValue(i, prefix+invfix+'org_scg_amt')))).toFixed(2);
            }
        }else{
            txt_obj.value = (Number(txt_obj.value) + Number(sheetObj.GetCellValue(i, prefix+invfix+'scg_amt'))).toFixed(2);
            if(lgs_cost_cd_value.substring(2) != 'OTAL') {
                org_scg_obj.value = (Number(org_scg_obj.value) + Number(sheetObj.GetCellValue(i, prefix+invfix+'org_scg_amt'))).toFixed(2);
            }
        }
        if(txt_obj.value != '' && Number(txt_obj.value) != 0) chk_obj.checked=true;
        if(lgs_cost_cd_value.substring(2) != 'OTAL') {
            curr_obj.value = sheetObj.GetCellValue(i, prefix+invfix+'curr_cd');
            wo_scg_xch_rt_obj.value = sheetObj.GetCellValue(i, prefix+invfix+'wo_scg_xch_rt');
        }
        
        switch(lgs_cost_cd_value.substring(2)) {
            case 'CDAL':
                formObj.chss_no.value=sheetObj.GetCellValue(i, prefix+invfix+'chss_no');
                formObj.incur_dt.value=sheetObj.GetCellValue(i, prefix+invfix+'incur_dt');
                //formObj.chasis_drayage_type_size.value = sheetObj.CellValue(i, prefix+invfix+'chss_mgst_tpsz_cd');
                break;
            case 'DRAL':
                if(sheetObj.GetCellValue(i, prefix+invfix+'dry_run_rlbl_pty_tp_cd') == 'CO') {
                    formObj.reliable_party[0].checked=true;
                }else if (sheetObj.GetCellValue(i, prefix+invfix+'dry_run_rlbl_pty_tp_cd') == 'CS') {
                    formObj.reliable_party[1].checked=true;
                }
                break;
            case 'FIAL':
                formObj.cause.value=sheetObj.GetCellValue(i, prefix+invfix+'fne_cuz_desc');
                break;
            case 'FGAL':
                if(sheetObj.GetCellValue(i, prefix+invfix+'fumg_cost_tp_cd') == 'FE') {
                    formObj.cost_rdo[0].checked=true;
                }else if (sheetObj.GetCellValue(i, prefix+invfix+'fumg_cost_tp_cd') == 'ED') {
                    formObj.cost_rdo[1].checked=true;
                }
                break;
            case 'GNAL':
                formObj.getset_tp_sz.value=sheetObj.GetCellValue(i, prefix+invfix+'mgst_tpsz_cd');
                break;
            case 'INAL':
                if(sheetObj.GetCellValue(i, prefix+invfix+'insp_rf_pti_cstms_tp_cd') == 'RP') {
                    formObj.reefer_rdo[0].checked=true;
                }else if (sheetObj.GetCellValue(i, prefix+invfix+'insp_rf_pti_cstms_tp_cd') == 'CS') {
                    formObj.reefer_rdo[1].checked=true;
                }
                break;
            case 'LFAL':
                formObj.number_lifting.value=sheetObj.GetCellValue(i, prefix+invfix+'lftg_knt');
                formObj.number_cause.value=sheetObj.GetCellValue(i, prefix+invfix+'lftg_cuz_desc');
                break;
            case 'MDAL':
                var nod=sheetObj.GetCellValue(i, prefix+invfix+'stop_loc_nod_cd');
                formObj.stop_loc.value=nod.substring(0,5);
                if(nod.length>5){
                    getComboList(formObj.stop_loc);
                    stop_yard.SetEnable(1);
                    stop_yard.SetSelectCode(nod.substring(5,7));
                }
                break;
            case 'OWAL':
                formObj.gross_weight.value=sheetObj.GetCellValue(i, prefix+invfix+'grs_wgt');
                break;
            case 'PPAL':
                formObj.incurred_date.value=sheetObj.GetCellValue(i, prefix+invfix+'incrt_dt');
                break;
            case 'SSAL':
                var nod=sheetObj.GetCellValue(i, prefix+invfix+'scl_stop_plc_nod_cd');
                formObj.scale_loc.value=nod.substring(0,5);
                if(nod.length>5) {
                    getComboList(formObj.scale_loc);
                    scale_yard.SetEnable(1);
                    scale_yard.SetSelectCode(nod.substring(5,7));
                }
                break;
                break;
            case 'SRAL':
                formObj.days.value=sheetObj.GetCellValue(i, prefix+invfix+'sto_dys');
                break;
            case 'STAL':
                formObj.outbound_booking_no.value=sheetObj.GetCellValue(i, prefix+invfix+'ob_bkg_no');
                break;
            case 'WTAL':
                formObj.waiting_hour.value=sheetObj.GetCellValue(i, prefix+invfix+'wt_hrs');
                break;
            case 'OTAL':
            	var otherSheet = sheetObjects[0];
       	    	var row = otherSheet.DataInsert(-1);
       	    	if(formObj.step_cd.value == 'WO') {
           	    	otherSheet.SetCellValue(row, "curr_cd", sheetObj.GetCellValue(i, prefix+invfix+'curr_cd'), 0);
                	otherSheet.SetCellValue(row, "org_scg_amt", sheetObj.GetCellValue(i, prefix+invfix+'org_scg_amt'), 0);
           	    	otherSheet.SetCellValue(row, "wo_scg_xch_rt", sheetObj.GetCellValue(i, prefix+invfix+'wo_scg_xch_rt'), 0);
       	    	} else {
           	    	otherSheet.SetCellValue(row, "curr_cd", formObj.curr_cd.value, 0);
                	otherSheet.SetCellValue(row, "org_scg_amt", txt_obj.value, 0);
           	    	otherSheet.SetCellValue(row, "wo_scg_xch_rt", 1, 0);
       	    	}
                
                formObj.remarks.value=sheetObj.GetCellValue(i, prefix+invfix+'otr_rmk');
                break;
        }
    }
    getSumTotalAmount();
}

function setDisplayForm(sheetObj, formObj){
	document.all.btn_save.style.display="none";
	formObj.SCALAL_chk.disabled=true;
	formObj.SCLWAL_chk.disabled=true;
	formObj.SCCDAL_chk.disabled=true;
	formObj.SCDPAL_chk.disabled=true;
	formObj.SCDRAL_chk.disabled=true;
	formObj.SCFRAL_chk.disabled=true;
	formObj.SCFIAL_chk.disabled=true;
	formObj.SCFGAL_chk.disabled=true;
	formObj.SCGNAL_chk.disabled=true;
	formObj.SCHZAL_chk.disabled=true;
	formObj.SCINAL_chk.disabled=true;
	formObj.SCLFAL_chk.disabled=true;
	formObj.SCMDAL_chk.disabled=true;
	formObj.SCOSAL_chk.disabled=true;
	formObj.SCOWAL_chk.disabled=true;
	formObj.SCPPAL_chk.disabled=true;
	formObj.SCRCAL_chk.disabled=true;
	formObj.SCSSAL_chk.disabled=true;
	formObj.SCSRAL_chk.disabled=true;
	formObj.SCSTAL_chk.disabled=true;
	formObj.SCSNAL_chk.disabled=true;
	formObj.SCSFAL_chk.disabled=true;
	formObj.SCTDAL_chk.disabled=true;
	formObj.SCTLAL_chk.disabled=true;
	formObj.SCWTAL_chk.disabled=true;
	formObj.SCOTAL_chk.disabled=true;
	formObj.SCENAL_chk.disabled=true;
}

function setEnableForm(sheetObj, formObj){
	document.all.btn_save.style.display="";
    for(var i=1; i< sheetObj.RowCount()+1; i++) {
        var scg_amt=sheetObj.GetCellValue(i, prefix+invfix+'scg_amt');
//        if(scg_amt == undefined || ComTrim(scg_amt) == '') continue;
        if(scg_amt == undefined) continue;
        var cost_cd=sheetObj.GetCellValue(i, prefix+'lgs_cost_cd');
        cost_cd=cost_cd.substr(0,1)+'C'+cost_cd.substr(2);
        // 2015.06.29	CHAN WOO PARK
        // Fuel Surcharge가 아닌 경우에만 text 활성화
        if (cost_cd.substr(2, 2) != 'FU' && cost_cd.substr(2, 2) != 'FA') {
            var txt_obj = eval('formObj.' + cost_cd + '_txt');
        	txt_obj.disabled = false;
    	}
        
        var lgs_cost_cd_value=sheetObj.GetCellValue(i, prefix+'lgs_cost_cd');
        switch(lgs_cost_cd_value.substring(2)){
            case 'CDAL':
                //formObj.chasis_drayage_type_size.disabled = false;
                formObj.chss_no.disabled=false;
                formObj.incur_dt.disabled=false;
                break;
            case 'DRAL':
                formObj.reliable_party[0].disabled=false;
                formObj.reliable_party[1].disabled=false;
                break;
            case 'FIAL':
                formObj.cause.disabled=false;
                break;
            case 'FGAL':
                formObj.cost_rdo[0].disabled=false;
                formObj.cost_rdo[1].disabled=false;
                break;
            case 'GNAL':
                formObj.getset_tp_sz.disabled=false;
                break;
            case 'INAL':
                formObj.reefer_rdo[0].disabled=false;
                formObj.reefer_rdo[1].disabled=false;
                break;
            case 'LFAL':
                formObj.number_lifting.disabled=false;
                formObj.number_cause.disabled=false;
                break;
            case 'MDAL':
                formObj.stop_loc.disabled=false;
                stop_yard.SetEnable(1);
                break;
            case 'PPAL':
                formObj.incurred_date.disabled=false;
                break;
            case 'SSAL':
                formObj.scale_loc.disabled=false;
                scale_yard.SetEnable(1);
                break;
            case 'SRAL':
                formObj.days.disabled=false;
                break;
            case 'STAL':
                formObj.outbound_booking_no.disabled=false;
                break;
            case 'WTAL':
                formObj.waiting_hour.disabled=false;
                break;
            case 'OTAL':
                formObj.remarks.disabled=false;
                break;
        }
    }
}

function getSumTotalAmount(inputObj) {
    var formObj = document.form;
    if(inputObj != undefined &&  inputObj != null && (formObj.curr_cd.value == 'JPY' || formObj.curr_cd.value == 'KRW' || formObj.curr_cd.value == 'TWD')) {
        inputObj.value = chkAmtPos_JPY(inputObj.value);
    }else if(inputObj != undefined && inputObj != null) {
        inputObj.value = chkAmtPos(inputObj.value);
    }
    checkNumber(formObj.SCALAL_txt,true);
    checkNumber(formObj.SCLWAL_txt,true);
    checkNumber(formObj.SCCDAL_txt,true);
    checkNumber(formObj.SCDPAL_txt,true);
    checkNumber(formObj.SCDRAL_txt,true);
    checkNumber(formObj.SCFRAL_txt,true);
    checkNumber(formObj.SCFIAL_txt,true);
    checkNumber(formObj.SCFGAL_txt,true);
    checkNumber(formObj.SCGNAL_txt,true);
    checkNumber(formObj.SCHZAL_txt,true);
    checkNumber(formObj.SCINAL_txt,true);
    checkNumber(formObj.SCLFAL_txt,true);
    checkNumber(formObj.SCMDAL_txt,true);
    checkNumber(formObj.SCOSAL_txt,true);
    checkNumber(formObj.SCOWAL_txt,true);
    checkNumber(formObj.SCPPAL_txt,true);
    checkNumber(formObj.SCRCAL_txt,true);
    checkNumber(formObj.SCSSAL_txt,true);
    checkNumber(formObj.SCSRAL_txt,true);
    checkNumber(formObj.SCSTAL_txt,true);
    checkNumber(formObj.SCSNAL_txt,true);
    checkNumber(formObj.SCSFAL_txt,true);
    checkNumber(formObj.SCTDAL_txt,true);
    checkNumber(formObj.SCTLAL_txt,true);
    checkNumber(formObj.SCWTAL_txt,true);
    checkNumber(formObj.SCOTAL_txt,true);
    checkNumber(formObj.SCENAL_txt,true);
    
	if(inputObj != undefined && inputObj != null) { // inputObj exists : unchecked or surcharge amount is inputted
	    var objName = inputObj.name.split('_');
	    
	    if(objName[1] != "chk") { // not in case of unchecking
	    	if(objName[0] == "SCOTAL") {
			    sheetObjects[0].RemoveAll();
				var row = sheetObjects[0].DataInsert(-1);
				sheetObjects[0].SetCellValue(row, "curr_cd", formObj.curr_cd.value, 0);
				sheetObjects[0].SetCellValue(row, "org_scg_amt", inputObj.value, 0);
				sheetObjects[0].SetCellValue(row, "wo_scg_xch_rt", 1.00, 0);
	    	} else {
	            var curr_obj = eval('formObj.'+inputObj.name+'2');
	            var org_scg_obj = eval('formObj.'+inputObj.name+'3');
	            var wo_scg_xch_rt_obj = eval('formObj.'+inputObj.name+'4');
	            
	            curr_obj.value = formObj.curr_cd.value;
	            org_scg_obj.value = inputObj.value;
	            wo_scg_xch_rt_obj.value = "1";
	    	}
	    }
	}
    
    var totalAmt=
        Number(formObj.SCALAL_txt.value) +
        Number(formObj.SCLWAL_txt.value) +
        Number(formObj.SCCDAL_txt.value) +
        Number(formObj.SCDPAL_txt.value) +
        Number(formObj.SCDRAL_txt.value) +
        Number(formObj.SCFRAL_txt.value) +
        Number(formObj.SCFIAL_txt.value) +
        Number(formObj.SCFGAL_txt.value) +
        Number(formObj.SCGNAL_txt.value) +
        Number(formObj.SCHZAL_txt.value) +
        Number(formObj.SCINAL_txt.value) +
        Number(formObj.SCLFAL_txt.value) +
        Number(formObj.SCMDAL_txt.value) +
        Number(formObj.SCOSAL_txt.value) +
        Number(formObj.SCOWAL_txt.value) +
        Number(formObj.SCPPAL_txt.value) +
        Number(formObj.SCRCAL_txt.value) +
        Number(formObj.SCSSAL_txt.value) +
        Number(formObj.SCSRAL_txt.value) +
        Number(formObj.SCSTAL_txt.value) +
        Number(formObj.SCSNAL_txt.value) +
        Number(formObj.SCSFAL_txt.value) +
        Number(formObj.SCTDAL_txt.value) +
        Number(formObj.SCTLAL_txt.value) +
        Number(formObj.SCWTAL_txt.value) +
        Number(formObj.SCOTAL_txt.value) +
        Number(formObj.SCENAL_txt.value) ;

    formObj.surcharge_add.value = (totalAmt*100/100).toFixed(2);

    // 2015.05.28	CHAN WOO PARK
    // Fuel을 제외한 Surcharge들의 합을 Additional Surcharge에 출력
    var fuel_scg_txt = eval('formObj.'+formObj.fuel_scg_cd.value+'_txt');
    formObj.surcharge_total.value = ((totalAmt + Number(fuel_scg_txt.value)) * 100 / 100).toFixed(2); 
    
    return totalAmt;
}

function setCheckedForm(chkObj) {
    var objName=chkObj.name.split('_')[0];
    var txtObj=eval('document.form.'+objName+'_txt');
    var formObj=document.form;
    if(chkObj.checked){
   		txtObj.disabled = false;
        switch(objName){
            case 'SCCDAL':
                formObj.chss_no.disabled=false;
                formObj.incur_dt.disabled=false;
                break;
            case 'SCDRAL':
                formObj.reliable_party[0].disabled=false;
                formObj.reliable_party[1].disabled=false;
                break;
            case 'SCFIAL':
                formObj.cause.disabled=false;
                break;
            case 'SCFGAL':
                formObj.cost_rdo[0].disabled=false;
                formObj.cost_rdo[1].disabled=false;
                break;
            case 'SCGNAL':
                formObj.getset_tp_sz.disabled=false;
                break;
            case 'SCINAL':
                formObj.reefer_rdo[0].disabled=false;
                formObj.reefer_rdo[1].disabled=false;
                break;
            case 'SCLFAL':
                formObj.number_lifting.disabled=false;
                formObj.number_cause.disabled=false;
                break;
            case 'SCMDAL':
                formObj.stop_loc.disabled=false;
                stop_yard.SetEnable(1);
                break;
            case 'SCOWAL':
                formObj.gross_weight.disabled=false;
                break;
            case 'SCPPAL':
                formObj.incurred_date.disabled=false;
                break;
            case 'SCSSAL':
                formObj.scale_loc.disabled=false;
                scale_yard.SetEnable(1);
                break;
            case 'SCSRAL':
                formObj.days.disabled=false;
                break;
            case 'SCSTAL':
                formObj.outbound_booking_no.disabled=false;
                break;
            case 'SCWTAL':
                formObj.waiting_hour.disabled=false;
                break;
            case 'SCOTAL':
                formObj.remarks.disabled=false;
                //sheet4.SetEditable(true);
                break;
        }    
    }else{
        txtObj.value='';
        txtObj.disabled=true;

        switch(objName){
            case 'SCOTAL':
            	sheetObjects[0].RemoveAll();
                break;
            default :
                var txtObj2 = eval('document.form.' + objName + '_txt2');
	            var txtObj3 = eval('document.form.' + objName + '_txt3');
	            var txtObj4 = eval('document.form.' + objName + '_txt4');
	            txtObj2.value='';
	            txtObj2.disabled=true;
	            txtObj3.value='';
	            txtObj3.disabled=true;
	            txtObj4.value='';
	            txtObj4.disabled=true;
        }
        
        getSumTotalAmount(chkObj);
        switch(objName){
            case 'SCCDAL':
                formObj.chss_no.disabled=true;
                formObj.chss_no.value='';
                formObj.incur_dt.disabled=true;
                formObj.incur_dt.value='';
                break;
            case 'SCDRAL':
                formObj.reliable_party[0].disabled=true;
                formObj.reliable_party[1].disabled=true;
                break;
            case 'SCFIAL':
                formObj.cause.disabled=true;
                formObj.cause.value='';
                break;
            case 'SCFGAL':
                formObj.cost_rdo[0].disabled=true;
                formObj.cost_rdo[1].disabled=true;
                break;
            case 'SCGNAL':
                formObj.getset_tp_sz.disabled=true;
                formObj.getset_tp_sz.value='';
                break;
            case 'SCINAL':
                formObj.reefer_rdo[0].disabled=true;
                formObj.reefer_rdo[1].disabled=true;
                break;
            case 'SCLFAL':
                formObj.number_lifting.disabled=true;
                formObj.number_cause.disabled=true;
                formObj.number_lifting.value='';
                formObj.number_cause.value='';
                break;
            case 'SCMDAL':
                formObj.stop_loc.disabled=true;
                stop_yard.SetEnable(0);
                formObj.stop_loc.value='';
                stop_yard.RemoveAll();
                break;
            case 'SCOWAL':
                formObj.gross_weight.disabled=true;
                formObj.gross_weight.value='';
                break;
            case 'SCPPAL':
                formObj.incurred_date.disabled=true;
                formObj.incurred_date.value='';
                break;
            case 'SCSSAL':
                formObj.scale_loc.disabled=true;
                scale_yard.SetEnable(0);
                formObj.scale_loc.value='';
                scale_yard.RemoveAll();
                break;
            case 'SCSRAL':
                formObj.days.disabled=true;
                formObj.days.value='';
                break;
            case 'SCSTAL':
                formObj.outbound_booking_no.disabled=true;
                formObj.outbound_booking_no.value='';
                break;
            case 'SCWTAL':
                formObj.waiting_hour.disabled=true;
                formObj.waiting_hour.value='';
                break;
            case 'SCOTAL':
                formObj.remarks.disabled=true;
                formObj.remarks.value='';
                //sheet4.SetEditable(false);
                break;
        }    
    }
}
/**
 * enter check
 **/
function enterCheck(obj) {
    if(event.keyCode == 13) {
        switch(ComGetEvent("name")) {
            case 'stop_loc':
            case 'scale_loc':
                getComboList(obj);
                break;
        }
    }
}

/**
 * Get a list of external combo box
 **/
function getComboList(obj) {
    var yard_obj=null;
    var formObj=document.form;
    obj.value=obj.value.toUpperCase();
    if(obj.name == 'stop_loc') yard_obj= stop_yard;
    else if(obj.name == 'scale_loc') yard_obj=scale_yard;
    var locValue=obj.value;
    if(ComTrim(locValue) == ''){
        yard_obj.RemoveAll();
        return;
    }
    getYardCombo(yard_obj, sheetObjects[1], formObj, locValue);
}

/**
* Common Node popup
*/
function openHireYardPopup( btn_obj ) {
    var formObject=document.form;
    var cmdt_cd_val="";   
    var rep_cmdt_cd_val=""; 
    var cmdt_desc_val="";   
    var classId="getCOM_ENS_061_1";
    var xx1="";  //CONTI
    var xx2="";  //SUB CONTI
    var xx3="";  //COUNTRY
    var xx4="";  //STATE
    var xx5="";  //CONTROL OFFIC
    var xx6="";  //LOC CODE
    var xx7="";  //LOC NAME
    var xx8="";
    var xx9="";
    var returnFunction='setStopNode';
    if(btn_obj == 'scale_node') returnFunction='setScaleNode';
    var param="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
    ComOpenPopup('/opuscntr/COM_ENS_061.do' + param, 772, 470, returnFunction, '1,0,1,1,1,1,1,1,1,1,1,1');
}

/**
 * popSearchPiCommCodeGrid process handling
 */
function popSearchPiCommCodeGrid(classID,midCD,cdName,sheetName,sRow,colCode,colName){
    var myUrl=getPopupURL(POPUP_PI_COMM);
    var myOption=getPopupOption(POPUP_PI_COMM);
    var url;
    if(myWin!=null) {
    	ComClosePopup(); 
    }
    url=myUrl+"?class_id="+classID + "&mid_cd="+midCD + "&cdName="+cdName+ "&sheetName="+sheetName+ "&sRow="+sRow+ "&colCode="+colCode+ "&colName="+colName;
    myWin=window.open(url, "piCommCodePop", myOption);
    myWin.focus();
}

/**
* fmNode through a pop-up settings
*/
function setStopNode(rowArray) {
    var formObject=document.form;
    var colArray=rowArray[0];
    var node=colArray[3];
    var loc=node.substring(0,5);
    var yard=node.substring(5,7);
    document.form.stop_loc.value=loc;
    getComboList(document.form.stop_loc);
    stop_yard.SetItemCheck(yard, true); //document.stop_yard.CODE=yard;   
}

/**
* fmNode through a pop-up settings
*/
function setScaleNode(rowArray) {
    var formObject=document.form;
    var colArray=rowArray[0];
    var node=colArray[3];
    var loc=node.substring(0,5);
    var yard=node.substring(5,7);
    document.form.scale_loc.value=loc;
    getComboList(document.form.scale_loc);
    scale_yard.SetItemCheck(yard, true); // document.scale_yard.CODE=yard;
}

function getCalendar(){
    var cal=new ComCalendar();
     cal.displayType="date";
     cal.select(document.form.incurred_date, 'yyyyMMdd');
}

function getCalendar2(){
    var cal=new ComCalendar();
     cal.displayType="date";
     cal.select(document.form.incur_dt, 'yyyyMMdd');
}

/**
 * Screen form validation process for processing the input values
 */
function validateForm(sheetObj,formObj,sAction){
    switch(sAction) {
        case IBSAVE:      
            if(formObj.SCALAL_chk.checked){ 
                if(formObj.SCALAL_txt.value=='') { 
                    ComShowCodeMessage('COM12114','Additional Labor');
                    formObj.SCALAL_txt.focus();
                    return false;
                }else if(!checkNumber(formObj.SCALAL_txt,true)) return false;
            }
            if(formObj.SCLWAL_chk.checked) { 
                if(formObj.SCLWAL_txt.value=='') { 
                    ComShowCodeMessage('COM12114','Barge Low Water');
                    formObj.SCLWAL_txt.focus();
                    return false;
                }
            }
            if(formObj.SCCDAL_chk.checked){ 
                if(formObj.SCCDAL_txt.value=='') { 
                    ComShowCodeMessage('COM12114','Chassis Drayage');
                    formObj.SCCDAL_txt.focus();
                    return false;
                }else if(formObj.chss_no.value=='') { 
                    ComShowCodeMessage('COM12114','Chassis No');
                    formObj.chss_no.focus();
                    return false;
                }else if(formObj.incur_dt.value=='') { 
                    ComShowCodeMessage('COM12114','Incurred Date');
                    formObj.incur_dt.focus();
                    return false;
                }else if(!checkNumber(formObj.SCCDAL_txt,true)) return false;
            }
            if(formObj.SCDPAL_chk.checked){ 
                if(formObj.SCDPAL_txt.value=='') { 
                    ComShowCodeMessage('COM12114','Drop and Pull (Drop and Pick up)');
                    formObj.SCDPAL_txt.focus();
                    return false;
                }else if(!checkNumber(formObj.SCDPAL_txt,true)) return false;
            }
            if(formObj.SCDRAL_chk.checked){ 
                if(formObj.SCDRAL_txt.value=='') { 
                    ComShowCodeMessage('COM12114','Dry Run');
                    formObj.SCDRAL_txt.focus();
                    return false;
                }else if(!formObj.reliable_party[0].checked && !formObj.reliable_party[1].checked) { 
                    ComShowCodeMessage('COM12114','Reliable Party');
                    formObj.reliable_party[0].focus();
                    return false;
                }else if(!checkNumber(formObj.SCDRAL_txt,true)) return false;
            }
            if(formObj.SCFRAL_chk.checked){ 
                if(formObj.SCFRAL_txt.value=='') { 
                    ComShowCodeMessage('COM12114','Ferry Cost ');
                    formObj.SCFRAL_txt.focus();
                    return false;
                }else if(!checkNumber(formObj.SCFRAL_txt,true)) return false;
            }
            if(formObj.SCFIAL_chk.checked){ 
                if(formObj.SCFIAL_txt.value=='') { 
                    ComShowCodeMessage('COM12114','Fine');
                    formObj.SCFIAL_txt.focus();
                    return false;
                }else if(formObj.cause.value=='') { 
                    ComShowCodeMessage('COM12114','Cause');
                    formObj.cause.focus();
                    return false;
                }else if(!checkNumber(formObj.SCFIAL_txt,true)) return false;
            }
            if(formObj.SCFGAL_chk.checked){ 
                if(formObj.SCFGAL_txt.value=='') { 
                    ComShowCodeMessage('COM12114','Fulmigation');
                    formObj.SCFGAL_txt.focus();
                    return false;
                }else if(!formObj.cost_rdo[0].checked && !formObj.cost_rdo[1].checked) { 
                    ComShowCodeMessage('COM12114','Cost');
                    formObj.cost_rdo[0].focus();
                    return false;
                }else if(!checkNumber(formObj.SCFGAL_txt,true)) return false;
            }
            if(formObj.SCGNAL_chk.checked){ 
                if(formObj.SCGNAL_txt.value=='') { 
                    ComShowCodeMessage('COM12114','Gen-Set Usage');
                    formObj.SCGNAL_txt.focus();
                    return false;
                }else if(formObj.getset_tp_sz.value==''){ 
                    ComShowCodeMessage('COM12114','Gen-Set Type/Size');
                    formObj.getset_tp_sz.focus();
                    return false;
                }else if(!checkNumber(formObj.SCGNAL_txt,true)) return false;
            }
            if(formObj.SCHZAL_chk.checked){ 
                if(formObj.SCHZAL_txt.value=='') { 
                    ComShowCodeMessage('COM12114','HAZMAT');
                    formObj.SCHZAL_txt.focus();
                    return false;
                }else if(!checkNumber(formObj.SCHZAL_txt,true)) return false;
            }
            if(formObj.SCINAL_chk.checked){ 
                if(formObj.SCINAL_txt.value=='') { 
                    ComShowCodeMessage('COM12114','Inspection');
                    formObj.SCINAL_txt.focus();
                    return false;
                }else if(!formObj.reefer_rdo[0].checked && !formObj.reefer_rdo[1].checked) { 
                    ComShowCodeMessage('COM12114','Inspection');
                    formObj.reefer_rdo[0].focus();
                    return false;
                }else if(!checkNumber(formObj.SCINAL_txt,true)) return false;
            }
            if(formObj.SCLFAL_chk.checked){ 
                if(formObj.SCLFAL_txt.value=='') { 
                    ComShowCodeMessage('COM12114','Lifting Charge');
                    formObj.SCLFAL_txt.focus();
                    return false;
                }else if(formObj.number_lifting.value=='') { 
                    ComShowCodeMessage('COM12114','Number Of Lifting');
                    formObj.number_lifting.focus();
                    return false;
                }else if(formObj.number_cause.value=='') { 
                    ComShowCodeMessage('COM12114','Cause');
                    formObj.number_cause.focus();
                    return false;
                }else if(!checkNumber(formObj.SCLFAL_txt,true)) return false;
                else if(!checkNumber(formObj.number_lifting,true)) return false;
            }
            if(formObj.SCMDAL_chk.checked){ 
                if(formObj.SCMDAL_txt.value=='') { 
                    ComShowCodeMessage('COM12114','Multiple Delivery');
                    formObj.SCMDAL_txt.focus();
                    return false;
                }else if(formObj.stop_loc.value.length != 0 && formObj.stop_loc.value.length != 5 ) { 
                    ComShowCodeMessage('COM12114','Stop Location');
                    formObj.stop_loc.focus();
                    return false;
                }else if(!checkNumber(formObj.SCMDAL_txt,true)) return false;
            }
            if(formObj.SCOSAL_chk.checked){ 
                if(formObj.SCOSAL_txt.value=='') { 
                    ComShowCodeMessage('COM12114','Over Size');
                    formObj.SCOSAL_txt.focus();
                    return false;
                }else if(!checkNumber(formObj.SCOSAL_txt,true)) return false;
            }
            if(formObj.SCOWAL_chk.checked){ 
                if(formObj.SCOWAL_txt.value=='') { 
                    ComShowCodeMessage('COM12114','Over Weight');
                    formObj.SCOWAL_txt.focus();
                    return false;
                }else if(formObj.gross_weight.value=='') { 
                    ComShowCodeMessage('COM12114','Gross Weight');
                    formObj.gross_weight.focus();
                    return false;
                }else if(!checkNumber(formObj.SCOWAL_txt,true)) return false;
                else if(!checkNumber(formObj.gross_weight,true)) return false;
            }
            if(formObj.SCPPAL_chk.checked){ 
                if(formObj.SCPPAL_txt.value=='') { 
                    ComShowCodeMessage('COM12114','Pre-Pull');
                    formObj.SCPPAL_txt.focus();
                    return false;
                }else if(formObj.incurred_date.value=='') { 
                    ComShowCodeMessage('COM12114','Incurred Date');
                    formObj.incurred_date.focus();
                    return false;
                }else if(!checkNumber(formObj.SCPPAL_txt,true)) return false;
            }
            if(formObj.SCRCAL_chk.checked){ 
                if(formObj.SCRCAL_txt.value=='') { 
                    ComShowCodeMessage('COM12114','Redirection Charge');
                    formObj.SCRCAL_txt.focus();
                    return false;
                }else if(!checkNumber(formObj.SCRCAL_txt,true)) return false;
            }
            if(formObj.SCSSAL_chk.checked){ 
                if(formObj.SCSSAL_txt.value=='') { 
                    ComShowCodeMessage('COM12114','Scale Stop');
                    formObj.SCSSAL_txt.focus();
                    return false;
                }else if(formObj.scale_loc.value.length != 0 && formObj.scale_loc.value.length != 5 ) { 
                    ComShowCodeMessage('COM12114','Scale Stop Place');
                    formObj.scale_loc.focus();
                    return false;
                }else if(!checkNumber(formObj.SCSSAL_txt,true)) return false;
            }
            if(formObj.SCSRAL_chk.checked){ 
                if(formObj.SCSRAL_txt.value=='') { 
                    ComShowCodeMessage('COM12114','Storage');
                    formObj.SCSRAL_txt.focus();
                    return false;
                }else if(formObj.days.value=='') { 
                    ComShowCodeMessage('COM12114','Day');
                    formObj.days.focus();
                    return false;
                }else if(!checkNumber(formObj.SCSRAL_txt,true)) return false;
                else if(!checkNumber(formObj.days,true)) return false;
            }
            if(formObj.SCSTAL_chk.checked){ 
                if(formObj.SCSTAL_txt.value=='') { 
                    ComShowCodeMessage('COM12114','Street Turn');
                    formObj.SCSTAL_txt.focus();
                    return false;
                }else if(formObj.outbound_booking_no.value=='') { 
                    ComShowCodeMessage('COM12114','Outbound Booking No');
                    formObj.outbound_booking_no.focus();
                    return false;
                }else if(!checkNumber(formObj.SCSTAL_txt,true)) return false;
            }
            if(formObj.SCSNAL_chk.checked){ 
                if(formObj.SCSNAL_txt.value=='') { 
                    ComShowCodeMessage('COM12114','Sunday Running');
                    formObj.SCSNAL_txt.focus();
                    return false;
                }else if(!checkNumber(formObj.SCSNAL_txt,true)) return false;
            }
            if(formObj.SCSFAL_chk.checked){ 
                if(formObj.SCSFAL_txt.value=='') { 
                    ComShowCodeMessage('COM12114','Swing / Flip');
                    formObj.SCSFAL_txt.focus();
                    return false;
                }else if(!checkNumber(formObj.SCSFAL_txt,true)) return false;
            }
            if(formObj.SCTDAL_chk.checked){ 
                if(formObj.SCTDAL_txt.value=='') { 
                    ComShowCodeMessage('COM12114','T-DOC Fee');
                    formObj.SCTDAL_txt.focus();
                    return false;
                }else if(!checkNumber(formObj.SCTDAL_txt,true)) return false;
            }
            if(formObj.SCTLAL_chk.checked){ 
                if(formObj.SCTLAL_txt.value=='') { 
                    ComShowCodeMessage('COM12114','T-DOC Fee');
                    formObj.SCTLAL_txt.focus();
                    return false;
                }else if(!checkNumber(formObj.SCTLAL_txt,true)) return false;
            }
            if(formObj.SCWTAL_chk.checked){ 
                if(formObj.SCWTAL_txt.value=='') { 
                    ComShowCodeMessage('COM12114','Waiting Charges');
                    formObj.SCWTAL_txt.focus();
                    return false;
                }else if(formObj.waiting_hour.value=='') { 
                    ComShowCodeMessage('COM12114','Waiting Hour');
                    formObj.waiting_hour.focus();
                    return false;
                }else if(!checkNumber(formObj.SCWTAL_txt,true)) return false;
                else if(!checkNumber(formObj.waiting_hour,true)) return false;
            }
            if(formObj.SCOTAL_chk.checked){ 
                if(formObj.SCOTAL_txt.value=='') { 
                    ComShowCodeMessage('COM12114','Other Surcharge');
                    formObj.SCOTAL_txt.focus();
                    return false;
                }else if(formObj.remarks.value=='') { 
                    ComShowCodeMessage('COM12114','Remarks');
                    formObj.remarks.focus();
                    return false;
                }else if(!checkNumber(formObj.SCOTAL_txt,true)) return false;
            }
            if(formObj.SCENAL_chk.checked){ 
                if(formObj.SCENAL_txt.value=='') { 
                    ComShowCodeMessage('COM12114','ENSF');
                    formObj.SCENAL_txt.focus();
                    return false;
                }else if(!checkNumber(formObj.SCENAL_txt,true)) return false;
            }
        break;
    }
    return true;
}

/**
 * number check
 **/
function checkNumber(obj, delflag) {
    var objName=obj.name.split('_')[0];
    var chars="0123456789.-";
    if(!ComIsContainsCharsOnly(obj,chars)) {
        ComShowCodeMessage('COM12122', eval(objName+'_01').innerText);
        if (delflag) obj.value='';
        return false;
    }
    return true;
}

/**
 * Sheet value of each item applies to
 **/
function putData(sheetObj, formObj) {
    var checkObj=formObj.SCALAL_chk;
    if(checkObj.checked && Number(formObj.SCALAL_txt.value)!=0){
        var row=putDataCommon(sheetObj,checkObj);
    }else{
        removeDataCommon(sheetObj,checkObj);
    }
    checkObj=formObj.SCLWAL_chk;
    if(checkObj.checked && Number(formObj.SCLWAL_txt.value)!=0){ 
        var row=putDataCommon(sheetObj,checkObj);
    }else{
        removeDataCommon(sheetObj,checkObj);
    }
    checkObj=formObj.SCCDAL_chk;
    if(checkObj.checked && Number(formObj.SCCDAL_txt.value)!=0){ 
        var row=putDataCommon(sheetObj,checkObj);
        //sheetObj.CellValue2(row, prefix+invfix+'chss_mgst_tpsz_cd') = formObj.chasis_drayage_type_size.value; 
        sheetObj.SetCellValue(row, prefix+invfix+'chss_no',formObj.chss_no.value,0);
        sheetObj.SetCellValue(row, prefix+invfix+'incur_dt',formObj.incur_dt.value,0);
    }else{
        removeDataCommon(sheetObj,checkObj);
    }
    checkObj=formObj.SCDPAL_chk;
    if(checkObj.checked && Number(formObj.SCDPAL_txt.value)!=0){ 
        var row=putDataCommon(sheetObj,checkObj);
    }else{
        removeDataCommon(sheetObj,checkObj);
    }
    checkObj=formObj.SCDRAL_chk;
    if(checkObj.checked && Number(formObj.SCDRAL_txt.value)!=0){
        var row=putDataCommon(sheetObj,checkObj);
        if(formObj.reliable_party[0].checked)
        sheetObj.SetCellValue(row, prefix+invfix+'dry_run_rlbl_pty_tp_cd',formObj.reliable_party[0].value,0);
        else sheetObj.SetCellValue(row, prefix+invfix+'dry_run_rlbl_pty_tp_cd',formObj.reliable_party[1].value,0);
    }else{
        removeDataCommon(sheetObj,checkObj);
    }
    checkObj=formObj.SCFRAL_chk;
    if(checkObj.checked && Number(formObj.SCFRAL_txt.value)!=0){
        var row=putDataCommon(sheetObj,checkObj);
    }else{
        removeDataCommon(sheetObj,checkObj);
    }
    checkObj=formObj.SCFIAL_chk;
    if(checkObj.checked && Number(formObj.SCFIAL_txt.value)!=0){
        var row=putDataCommon(sheetObj,checkObj);
        sheetObj.SetCellValue(row, prefix+invfix+'fne_cuz_desc',formObj.cause.value,0);
    }else{
        removeDataCommon(sheetObj,checkObj);
    }
    // 2015.06.01 CHAN WOO PARK
//    var fuel_scg_chk = eval('formObj.'+formObj.fuel_scg_cd.value+'_chk');
//    checkObj=fuel_scg_chk;
//    if(checkObj.checked && Number(fuel_scg_chk.value)!=0){
//        var row=putDataCommon(sheetObj,checkObj);
//    }else{
//        removeDataCommon(sheetObj,checkObj);
//    }
    checkObj=formObj.SCFGAL_chk;
    if(checkObj.checked && Number(formObj.SCFGAL_txt.value)!=0){
        var row=putDataCommon(sheetObj,checkObj);
        if(formObj.cost_rdo[0].checked)
        sheetObj.SetCellValue(row, prefix+invfix+'fumg_cost_tp_cd',formObj.cost_rdo[0].value,0);
        else sheetObj.SetCellValue(row, prefix+invfix+'fumg_cost_tp_cd',formObj.cost_rdo[1].value,0);
    }else{
        removeDataCommon(sheetObj,checkObj);
    }
    checkObj=formObj.SCGNAL_chk;
    if(checkObj.checked && Number(formObj.SCGNAL_txt.value)!=0){
        var row=putDataCommon(sheetObj,checkObj);
        sheetObj.SetCellValue(row, prefix+invfix+'mgst_tpsz_cd',formObj.getset_tp_sz.value,0);
    }else{
        removeDataCommon(sheetObj,checkObj);
    }
    checkObj=formObj.SCHZAL_chk;
    if(checkObj.checked && Number(formObj.SCHZAL_txt.value)!=0){
        var row=putDataCommon(sheetObj,checkObj);
    }else{
        removeDataCommon(sheetObj,checkObj);
    }
    checkObj=formObj.SCINAL_chk;
    if(checkObj.checked && Number(formObj.SCINAL_txt.value)!=0){
        var row=putDataCommon(sheetObj,checkObj);
        if(formObj.reefer_rdo[0].checked)
        sheetObj.SetCellValue(row, prefix+invfix+'insp_rf_pti_cstms_tp_cd',formObj.reefer_rdo[0].value,0);
        else sheetObj.SetCellValue(row, prefix+invfix+'insp_rf_pti_cstms_tp_cd',formObj.reefer_rdo[1].value,0);
    }else{
        removeDataCommon(sheetObj,checkObj);
    }
    checkObj=formObj.SCLFAL_chk;
    if(checkObj.checked && Number(formObj.SCLFAL_txt.value)!=0){
        var row=putDataCommon(sheetObj,checkObj);
        sheetObj.SetCellValue(row, prefix+invfix+'lftg_knt',formObj.number_lifting.value,0);
        sheetObj.SetCellValue(row, prefix+invfix+'lftg_cuz_desc',formObj.number_cause.value,0);
    }else{
        removeDataCommon(sheetObj,checkObj);
    }
    checkObj=formObj.SCMDAL_chk;
    if(checkObj.checked && Number(formObj.SCMDAL_txt.value)!=0){
        var row=putDataCommon(sheetObj,checkObj);
        var nod=formObj.stop_loc.value;

        // 2015.03.09    Hyungwook Choi
        //if(document.stop_yard.GetSelectCode()!= undefined) nod+= document.stop_yard.GetSelectCode();
        if(stop_yard.GetSelectCode()!= undefined) nod+= stop_yard.GetSelectCode();

        sheetObj.SetCellValue(row, prefix+invfix+'stop_loc_nod_cd',nod,0);
    }else{
        removeDataCommon(sheetObj,checkObj);
    }
    checkObj=formObj.SCOSAL_chk;
    if(checkObj.checked && Number(formObj.SCOSAL_txt.value)!=0){
        var row=putDataCommon(sheetObj,checkObj);
    }else{
        removeDataCommon(sheetObj,checkObj);
    }
    checkObj=formObj.SCOWAL_chk;
    if(checkObj.checked && Number(formObj.SCOWAL_txt.value)!=0){
        var row=putDataCommon(sheetObj,checkObj);
        sheetObj.SetCellValue(row, prefix+invfix+'grs_wgt',formObj.gross_weight.value,0);
    }else{
        removeDataCommon(sheetObj,checkObj);
    }
    checkObj=formObj.SCPPAL_chk;
    if(checkObj.checked && Number(formObj.SCPPAL_txt.value)!=0){
        var row=putDataCommon(sheetObj,checkObj);
        sheetObj.SetCellValue(row, prefix+invfix+'incrt_dt',formObj.incurred_date.value,0);
    }else{
        removeDataCommon(sheetObj,checkObj);
    }
    checkObj=formObj.SCRCAL_chk;
    if(checkObj.checked && Number(formObj.SCRCAL_txt.value)!=0){
        var row=putDataCommon(sheetObj,checkObj);
    }else{
        removeDataCommon(sheetObj,checkObj);
    }
    checkObj=formObj.SCSSAL_chk;
    if(checkObj.checked && Number(formObj.SCSSAL_txt.value)!=0){
        var row=putDataCommon(sheetObj,checkObj);
        var nod=formObj.scale_loc.value;

        // 2015.03.09    Hyungwook Choi
        //if(document.scale_yard.GetSelectCode()!= undefined) nod+= document.scale_yard.GetSelectCode();
        if(scale_yard.GetSelectCode()!= undefined) nod+= scale_yard.GetSelectCode();

        sheetObj.SetCellValue(row, prefix+invfix+'scl_stop_plc_nod_cd',nod,0);
    }else{
        removeDataCommon(sheetObj,checkObj);
    }
    checkObj=formObj.SCSRAL_chk;
    if(checkObj.checked && Number(formObj.SCSRAL_txt.value)!=0){
        var row=putDataCommon(sheetObj,checkObj);
        sheetObj.SetCellValue(row, prefix+invfix+'sto_dys',formObj.days.value,0);
    }else{
        removeDataCommon(sheetObj,checkObj);
    }
    checkObj=formObj.SCSTAL_chk;
    if(checkObj.checked && Number(formObj.SCSTAL_txt.value)!=0){
        var row=putDataCommon(sheetObj,checkObj);
        sheetObj.SetCellValue(row, prefix+invfix+'ob_bkg_no',formObj.outbound_booking_no.value,0);
    }else{
        removeDataCommon(sheetObj,checkObj);
    }
    checkObj=formObj.SCSNAL_chk;
    if(checkObj.checked && Number(formObj.SCSNAL_txt.value)!=0){
        var row=putDataCommon(sheetObj,checkObj);
    }else{
        removeDataCommon(sheetObj,checkObj);
    }
    checkObj=formObj.SCSFAL_chk;
    if(checkObj.checked && Number(formObj.SCSFAL_txt.value)!=0){
        var row=putDataCommon(sheetObj,checkObj);
    }else{
        removeDataCommon(sheetObj,checkObj);
    }
    checkObj=formObj.SCTDAL_chk;
    if(checkObj.checked && Number(formObj.SCTDAL_txt.value)!=0){
        var row=putDataCommon(sheetObj,checkObj);
    }else{
        removeDataCommon(sheetObj,checkObj);
    }
    checkObj=formObj.SCTLAL_chk;
    if(checkObj.checked && Number(formObj.SCTLAL_txt.value)!=0){
        var row=putDataCommon(sheetObj,checkObj);
    }else{
        removeDataCommon(sheetObj,checkObj);
    }
    checkObj=formObj.SCWTAL_chk;
    if(checkObj.checked && Number(formObj.SCWTAL_txt.value)!=0){
        var row=putDataCommon(sheetObj,checkObj);
        sheetObj.SetCellValue(row, prefix+invfix+'wt_hrs',formObj.waiting_hour.value,0);
    }else{
        removeDataCommon(sheetObj,checkObj);
    }
    checkObj=formObj.SCOTAL_chk;
    if(checkObj.checked && Number(formObj.SCOTAL_txt.value)!=0){
        var row=putDataCommon(sheetObj,checkObj);
//        sheetObj.SetCellValue(row, prefix+invfix+'otr_rmk',formObj.remarks.value,0); // move putDataCommon
    }else{
        removeDataCommon(sheetObj,checkObj);
    }
    checkObj=formObj.SCENAL_chk;
    if(checkObj.checked && Number(formObj.SCENAL_txt.value)!=0){
        var row=putDataCommon(sheetObj,checkObj);
    }else{
        removeDataCommon(sheetObj,checkObj);
    }
}

/**
 * Applied to a common value of the item sheet
 **/
function putDataCommon(sheetObj, chkObj) {
    var objName = chkObj.name.split('_')[0];
    var txtObj = eval('document.form.'+objName+'_txt');
    var txtObj2 = eval('document.form.'+objName+'_txt2');
    var txtObj3 = eval('document.form.'+objName+'_txt3');
    var txtObj4 = eval('document.form.'+objName+'_txt4');
    var row = -1;
    
    var formObj = document.form;
    if(objName != 'SCCDAL') {
        objName='S' + formObj.cgo_tp_cd.value + objName.substring(2);
    }

    if(objName.substring(2) == 'OTAL') {
    	var n = sheetObj.FindText(prefix + 'lgs_cost_cd', objName);
    	while(n > -1) {
    		sheetObj.RowDelete(n, 0);
    		n = sheetObj.FindText(prefix + 'lgs_cost_cd', objName);
    	}
    	
    	var rCount = sheetObjects[0].RowCount(); // other surcharge SHEET

	    for(var i = 1; i < rCount + 1; i++) {
	        row = sheetObj.DataInsert(-1);
	        
	        if(formObj.so_seq.value != undefined && formObj.so_seq.value != '') {
	            sheetObj.SetCellValue(row, prefix + 'trsp_so_ofc_cty_cd', formObj.ofc_cty_cd.value, 0);
	            sheetObj.SetCellValue(row, prefix + 'trsp_so_seq', formObj.so_seq.value, 0);
	        }
	    	
	        if(formObj.unique_cd.value != undefined && formObj.unique_cd.value != ''){
	            sheetObj.SetCellValue(row, prefix + 'unique_cd', formObj.unique_cd.value, 0);
	        }
	    	
	        sheetObj.SetCellValue(row, prefix + 'lgs_cost_cd', objName, 0);
	        sheetObj.SetCellValue(row, prefix + 'lgs_cost_full_nm', getCodeName(objName), 0);

	        var scg_amt = parseFloat(sheetObjects[0].GetCellValue(i, 'wo_scg_xch_rt')) * parseFloat(sheetObjects[0].GetCellValue(i, 'org_scg_amt'));
	        if(formObj.curr_cd.value == 'JPY' || formObj.curr_cd.value == 'KRW' || formObj.curr_cd.value == 'TWD') {
	        	sheetObj.SetCellValue(row, prefix+invfix + 'scg_amt', Number(chkAmtPos_JPY(scg_amt)).toFixed(2), 0);
	        }else{
	        	sheetObj.SetCellValue(row, prefix+invfix + 'scg_amt', Number(scg_amt).toFixed(2), 0);
	        }

	        sheetObj.SetCellValue(row, prefix+invfix + 'curr_cd', sheetObjects[0].GetCellValue(i, 'curr_cd'), 0);
	        sheetObj.SetCellValue(row, prefix+invfix + 'wo_scg_xch_rt', parseFloat(sheetObjects[0].GetCellValue(i, 'wo_scg_xch_rt')), 0);	
        	sheetObj.SetCellValue(row, prefix+invfix + 'org_scg_amt', parseFloat(sheetObjects[0].GetCellValue(i, 'org_scg_amt')), 0);
	        sheetObj.SetCellValue(row, prefix+invfix+'otr_rmk', formObj.remarks.value, 0);
	    }
    	
    } else {
        row = sheetObj.FindText(prefix + 'lgs_cost_cd', objName);
        if(row == -1){
            row = sheetObj.DataInsert(-1);
        }
        if(formObj.so_seq.value != undefined && formObj.so_seq.value != '') {
            sheetObj.SetCellValue(row, prefix + 'trsp_so_ofc_cty_cd', formObj.ofc_cty_cd.value, 0);
            sheetObj.SetCellValue(row, prefix + 'trsp_so_seq', formObj.so_seq.value, 0);
        }
        if(formObj.unique_cd.value != undefined && formObj.unique_cd.value != ''){
            sheetObj.SetCellValue(row, prefix + 'unique_cd', formObj.unique_cd.value, 0);
        }
        sheetObj.SetCellValue(row, prefix + 'lgs_cost_cd', objName, 0);
        sheetObj.SetCellValue(row, prefix + 'lgs_cost_full_nm', getCodeName(objName), 0);
        if($.isNumeric(txtObj.value)) {
        	 sheetObj.SetCellValue(row, prefix+invfix + 'scg_amt', parseFloat(txtObj.value), 0);	
        }

        sheetObj.SetCellValue(row, prefix+invfix + 'curr_cd', txtObj2.value, 0);
        if($.isNumeric(txtObj3.value)) {
        	sheetObj.SetCellValue(row, prefix+invfix + 'org_scg_amt', parseFloat(txtObj3.value), 0);
        }
        sheetObj.SetCellValue(row, prefix+invfix + 'wo_scg_xch_rt', parseFloat(txtObj4.value), 0);	
    }
    return row;
}

/**
 * 존재하지 않는 data를  sheet에서 삭제
 **/
function removeDataCommon(sheetObj, chkObj) {
    var formObj=document.form;
    var objName=chkObj.name.split('_')[0];
    objName='S'+formObj.cgo_tp_cd.value+objName.substring(2);
    var row=sheetObj.FindText(prefix+'lgs_cost_cd', objName);
    var un_invfix=null;
    if (invfix == 'inv_') un_invfix='';
    else un_invfix='inv_';
    if(row != -1) {
        var scg_amt=sheetObj.GetCellValue(row, prefix+un_invfix+'scg_amt');
        if( (scg_amt == undefined || ComTrim(scg_amt) == '' || scg_amt == 0)){
            sheetObj.RowDelete(row, false);
        }else{
            if(formObj.so_seq.value != undefined && formObj.so_seq.value != ''){
                sheetObj.SetCellValue(row, prefix+'trsp_so_ofc_cty_cd',formObj.ofc_cty_cd.value,0);
                sheetObj.SetCellValue(row, prefix+'trsp_so_seq',formObj.so_seq.value,0);
            }
            if(formObj.unique_cd.value != undefined && formObj.unique_cd.value != ''){
                sheetObj.SetCellValue(row, prefix+'unique_cd',formObj.unique_cd.value,0);
            }
        }
    }
}

/**
 * Allows the return to CODE CODE NAME.
 * CODE NAME when loading a page brings.
 **/
function getCodeName(code_val){
    var sheetObj=sheetObjects[2];
    var index=sheetObj.FindText('lgs_cost_cd', code_val);
    return sheetObj.GetCellValue(index, 'lgs_cost_full_nm');
}

function checkIncurredDate(obj){
    var objLength=obj.value.length;
    if( objLength > 0 ){
        if(objLength != 8 ){
            ComShowCodeMessage('COM12114', 'date format : YYYYMMDD');
            obj.value='';
            return;
        }else if (!ComIsDate(obj.value)) {
            ComShowCodeMessage('COM12114', 'date format : YYYYMMDD');
            obj.value='';
            return;
        }
    }
}

function checkTPBIf() {
    var formObj=document.form;
    var sheetObj=sheetObjects[3];
    formObj.f_cmd.value=SEARCH04;
    sheetObj.DoSearch("ESD_TRS_0918GS.do", TrsFrmQryString(formObj) );
//    var if_flg = sheetObj.CellValue(1, 'if_flg')
    var if_flg=sheetObj.GetEtcData('if_flg')
    if (if_flg=='Y'){
    	ComShowMessage("This S/O was already interfaced to TPB and no more interface is available. \n\n Please have them manually processed, if necessary, in TPB " );
    }
 return if_flg;
}

/**
 * enter check
 **/
function enterCheck(obj) {
    var formObj=document.form;
    if(event.keyCode == 13) {
        switch(ComGetEvent("name")){
            case 'incurred_date':
                checkIncurredDate(obj);
                obj.focus();
            break;
        }
    }
}


/**
 * Value change event on Sheet4 column
 */
function sheet4_OnChange(sheetObj, row , col , value) {
    var formObj = document.form;
    
	if( formObj.SCOTAL_chk.checked == true && sheetObj.ColSaveName(col) == "org_scg_amt" ) {
		var otherAmt = 0.0;
		
	    for(var i=1; i< sheetObj.RowCount()+1; i++) {
	    	otherAmt = otherAmt + Number(sheetObj.GetCellValue(i, "org_scg_amt")) * Number(sheetObj.GetCellValue(i, "wo_scg_xch_rt"));
	    }
	    
        if(formObj.curr_cd.value == 'JPY' || formObj.curr_cd.value == 'KRW' || formObj.curr_cd.value == 'TWD'){
            txt_obj.value = (Number(txt_obj.value) + Number(chkAmtPos_JPY(sheetObj.GetCellValue(i, prefix+invfix+'scg_amt')))).toFixed(2);
            formObj.SCOTAL_txt.value = Number(chkAmtPos_JPY(otherAmt)).toFixed(2);
        }else{
            formObj.SCOTAL_txt.value = otherAmt.toFixed(2);
        }
	}
}