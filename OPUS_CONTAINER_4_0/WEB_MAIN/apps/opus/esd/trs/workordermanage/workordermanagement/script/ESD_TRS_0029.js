/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0029.js
*@FileTitle  : BFI Management
*@author     : CLT
*@version    : 1.0
*@since      : 2014/11/17
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
                    [modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
                    character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------The following code is added to make a good JSDoc Code ------------------*/
/**
 * @fileoverview For example) Booking service for creating scripts to use on the screen is defined.
 * @author OPUS
 */
/*------------------From here the common JavaScript function is defined.     ------------------*/
// Common global variable
var sheetObjects=new Array();
var sheetCnt=0;
// true : retrieve finished AND input data not changed
// false : not retrieved OR input data changed
var global_sendBFI = false;

/* Click the button to define an event handler that receives and processes events */
document.onclick=processButtonClick;

/* Button to process certain filename, separated on a quarterly event handler to handle */
function processButtonClick(){
    var sheetObject=sheetObjects[0];
    /*******************************************************/
    var formObject=document.form;
    try {
        var srcName=ComGetEvent("name");
        switch(srcName) {
            case "btn_retrieve":
                doActionIBSheet(sheetObject,formObject,IBSEARCH);
                break;
            case "btn_reset":
                sheetObject.RemoveAll();
                formObject.reset();
                break;
            case 'btns_vndr_seq':
                rep_Multiful_inquiry(srcName);
                break;
            case "btng_provider":
                rep_OnPopupClick();
                break;
            case "btn_downexcel":
                doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
                break;
            case 'btns_calendar':
                getCalendar();
                break;
            case "btn_downexcel_inv":
                doActionIBSheet2(sheetObjects[1],formObject,IBSEARCH);
                break;
            case "btn_bfi":		// send email
            		if(global_sendBFI) {
            			doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC01);
            		} else {
            			disableSendBFI();
            			//ComShowMessage("Retry Send BFI after retrieve with only one Service Provider.");
            		}
                break;
        }
    }catch(e) {
        if( e == "[object Error]") {
            ComShowCodeMessage('COM12111');
        } else {
            ComShowMessage(e.message);
        }
    }
}

/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
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
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    initControl();
}

/**
 * HTML Control on the page is dynamically loaded into the event. <br>
 * initControl
 **/
function initControl() {
}

/**
* HTML Control of the onkeypress event to handle the input of numbers in English <br>
 **/
function engnum_keypress() {
//            ComKeyOnlyAlphabet('uppernum');
}

/**
 * Bkg_no checked the manual only be editable. <br>
 **/
function manual_click() {
    //Bkg_no checked the manual only be editable.
//            form.boo_bkg_no.readOnly =!form.manual.checked;
}

/**
 * Booking No BKG Creation tab function changed to handle cases. <br>
 **/
function bkgno_keyup() {
    //bkg_no modify and erase the stored value and if different bl_no, bl_no rescue this case.
    /*
    if (form.boo_bkg_no.value != form.hdn_boo_bkg_no.value) 
    form.boo_bl_no.value="";
    else
    form.boo_bl_no.value=form.hdn_boo_bl_no.value;
    */
}

/**
 * Validation of HTML Control will check in the onblur event. <br>
 **/
function obj_blur(){
    //Input Validation to check
//            return ComChkObjValid(event.srcElement);
}

/**
 * HTML Control for the separator to remove the mask from the onfocus event. <br>
 **/
function obj_focus(){
//            ComClearSeparator(event.srcElement);
}

/**
 * HTML Control from the onkeypress event should be numeric only. <br>
 **/
function obj_keypress(){
//            ComKeyOnlyNumber(event.srcElement);
}

/**
 * Sheet, the initial setting, the header definition
 * initSheet
 */
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    switch(sheetNo) {
        case 1:      //sheet1 init
            with(sheetObj){
                var HeadTitle="Seq.||Office|Fm Date|To Date|S/P Name|Email|File Creation Date|Contact|W/O No|TP/SZ|";
                HeadTitle += "From|Via|To|Door|Door|Date|Currency|Charge Description|Charges|EQ No|Cargo|W/O Status";
                
                SetConfig( { SearchMode:0, FrozenCol:6, DataRowMerge:0, MergeSheet:7} );

                var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [{Type:"Seq",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"CheckBox",  Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"wo_check",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cre_ofc_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1, VAlign:"Top" },
                            {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"fm_dt",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1, VAlign:"Top" },
                            {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"to_dt",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1, VAlign:"Top" },
                            {Type:"Text",      Hidden:0,  Width:220,  Align:"left",    ColMerge:1,   SaveName:"vndr_lgl_eng_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1, VAlign:"Top" },
                            {Type:"Text",      Hidden:0,  Width:200,  Align:"left",    ColMerge:1,   SaveName:"vndr_eml",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1, VAlign:"Top" },
                            {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"today_dt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1, VAlign:"Top" },
                            {Type:"Text",      Hidden:0,  Width:150,  Align:"left",    ColMerge:0,   SaveName:"cntc_pson_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"trsp_wo_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1, VAlign:"Top" },
                            {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1, VAlign:"Top" },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"fm_nod_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1, VAlign:"Top" },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"via_nod_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1, VAlign:"Top" },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"to_nod_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1, VAlign:"Top" },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"dor_nod_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1, VAlign:"Top" },
                            {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"dor_nod_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1, VAlign:"Top" },
                            {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"dor_nod_pln_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, VAlign:"Top" },
                            {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, VAlign:"Top" },
                            {Type:"Text",      Hidden:0,  Width:160,  Align:"left",    ColMerge:0,   SaveName:"bzc_amt_desc",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                            {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"bzc_amt",               KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"eq_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cgo_tp_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                            {Type:"Text",      Hidden:0,  Width:100,  Align:"left",    ColMerge:0,   SaveName:"trs_sub_sts_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                                           
                InitColumns(cols);
                
                SetEditable(1);
                ComResizeSheet(sheetObj);
                ShowSubSum([
                            //{StdCol:"curr_cd",    SumCols:"bzc_amt", Sort:false, ShowCumulate:false, CaptionCol:"bzc_amt_desc", CaptionText:"Grand Total"},
                            //{StdCol:"trsp_wo_no", SumCols:"bzc_amt", Sort:false, ShowCumulate:false, CaptionCol:"bzc_amt_desc", CaptionText:"Total"}
                            {StdCol:"cre_ofc_cd",    SumCols:"bzc_amt", Sort:false, ShowCumulate:false, CaptionCol:"cre_ofc_cd", CaptionText:"%col", OtherColText:"bzc_amt_desc=Grand Total"},
                            {StdCol:"vndr_lgl_eng_nm", SumCols:"bzc_amt", Sort:false, ShowCumulate:false, CaptionCol:"vndr_lgl_eng_nm", CaptionText:"%col", OtherColText:"bzc_amt_desc=Total"}
                          ]);
                
            }

            break;
        case 2:      //sheet2 init
            with(sheetObj){
                var HeadTitle="Seq.|EQ No|EQ TP/SZ|S/O No|W/O No|Reference No|Invoice Total Amount";
                
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
                
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [{Type:"Seq",      Hidden:0,  Width:60,    Align:"Center",  ColMerge:1,   SaveName:"seq" },
                            {Type:"Text",     Hidden:0,  Width:120,   Align:"Center",  ColMerge:1,   SaveName:"eq_no" },
                            {Type:"Text",     Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd" },
                            {Type:"Text",     Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"trsp_so_no" },
                            {Type:"Text",     Hidden:0,  Width:120,   Align:"Center",  ColMerge:1,   SaveName:"trsp_wo_no" },
                            {Type:"Text",     Hidden:0,  Width:120,   Align:"Center",  ColMerge:1,   SaveName:"inv_no" },
                            {Type:"Text",     Hidden:0,  Width:160,   Align:"Center",  ColMerge:1,   SaveName:"tot_inv_amt" } ];
                                           
                InitColumns(cols);
                
                SetEditable(0);
                ComResizeSheet(sheetObj);
                SetVisible(0);
            }

            break;
    }
}

// Sheet processing-related processes
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
        case IBSEARCH:
        	//replaceDateField(formObj);
            if(validateForm(sheetObj,formObj,sAction)) {
                var days_between=ComGetDaysBetween(formObj.fm_dt, formObj.to_dt) ; // Inquiry Period
                if( days_between < 0) {
    				ComShowCodeMessage("TRS90118");
                    formObj.fm_dt.focus();
                    return false;
                } else if (days_between > 30) {
    				ComShowCodeMessage("TRS90424");
                    formObj.fm_dt.focus();
                    return false;
                }

                if(formObj.not_sp.checked) {
                    formObj.temp_not_sp.value = "Y";
                } else {
                    formObj.temp_not_sp.value = "N";
                }

                formObj.f_cmd.value = SEARCH01;
                sheetObj.DoSearch("ESD_TRS_0029GS.do", TrsFrmQryString(formObj) );
            }
            break;
        case IBDOWNEXCEL:        // excel down
            if(validateForm(sheetObj,formObj,sAction)) {
                if(formObj.not_sp.checked) {
                    formObj.temp_not_sp.value = "Y";
                } else {
                    formObj.temp_not_sp.value = "N";
                }
                
//                ComOpenWait(true);
//                formObj.f_cmd.value = SEARCH;
//                formObj.target = "_self";
//                formObj.action = "ESD_TRS_0029DL.do?"+ FormQueryString(formObj);
//                formObj.submit();
//                sheetObj.SetCellVAlign(0, 3, "Top");
//                sheetObj.SetCellVAlign(1, 3, "Top");
//                sheetObj.SetCellVAlign(2, 3, "Top");
                // 2015.02.06    Hyungwook Choi
                sheetObj.Down2Excel({ DownCols: makeHiddenSkipCol_BFI(sheetObj), CheckBoxOnValue:'Y', CheckBoxOffValue:'N', SheetDesign:1, Merge:0 });

                ComOpenWait(false);
            }
            break;
        case IBSEARCH_ASYNC01:		// send email
        	//replaceDateField(formObj);
            if(validateForm(sheetObj,formObj,sAction)) {
                var days_between=ComGetDaysBetween(formObj.fm_dt, formObj.to_dt) ; // Inquiry Period
                if( days_between < 0) {
                    var errMsg=ComGetMsg("TRS90118" );
                    ComShowMessage(errMsg);
                    formObj.fm_dt.focus();
                    return false;
                }     

                if(formObj.not_sp.checked) {
                    formObj.temp_not_sp.value = "Y";
                } else {
                    formObj.temp_not_sp.value = "N";
                }

                formObj.f_cmd.value = MULTI;
                //sheetObj.DoSearch("ESD_TRS_0029GS.do", TrsFrmQryString(formObj) );
                var sXml = sheetObj.GetSearchData("ESD_TRS_0029GS.do", TrsFrmQryString(formObj) );
    			var result = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
    			if(result != "S") {
    				showErrorMsg(sXml);
    				ComOpenWait(false, false);
    			} else {
    				ComShowCodeMessage('TRS90504'); // CoMessage.js COM131503
    			}
            }
            break;
    }
}

//Sheet processing-related processes
function doActionIBSheet2(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
    	case IBSEARCH:
    		//replaceDateField(formObj);
    		if(validateForm(sheetObj, formObj, sAction)) {
    			var days_between = ComGetDaysBetween(formObj.fm_dt, formObj.to_dt) ;
    			if( days_between < 0) {
    				var errMsg = ComGetMsg("TRS90118" );
    				ComShowMessage(errMsg);
    				formObj.fm_dt.focus();
    				return false;
    			}

    			if(formObj.not_sp.checked) {
    				formObj.temp_not_sp.value = "Y";
    			} else {
    				formObj.temp_not_sp.value = "N";
    			}

    			formObj.f_cmd.value = SEARCH02;
    			sheetObj.DoSearch("ESD_TRS_0029GS.do", TrsFrmQryString(formObj) );
    		}
    		break;
    	case IBDOWNEXCEL:        // excel down
    		if(sheetObj.RowCount() < 1) {
                ComShowCodeMessage('TRS90393');
        		ComOpenWait(false);
                break;
    		}
    		
    		sheetObj.Down2Excel({ CheckBoxOnValue:'Y', CheckBoxOffValue:'N', SheetDesign:1, Merge:1 }); // dowunload all columns
    		ComOpenWait(false);
    		break;
	}
}

function sheet1_OnDownFinish(downloadType, result) {
    //alert(downloadType + ' 다운이 완료되었습니다. 다운로드 결과 : ' + result);
}

/**
 * Pop-up call rep_commodity
 */
function rep_Multiful_inquiry(btn_obj) {
    var formObject=document.form;
    var cmdt_cd_val="";   
    var rep_cmdt_cd_val="";
    var cmdt_desc_val="";  
    var classId="getTRS_ENS_979";
    var xx1=btn_obj;  //CONTI
    var xx2="";  //SUB CONTI
    var xx3="";  //COUNTRY
    var xx4="";  //STATE
    var xx5="";  //CONTROL OFFIC
    var xx6="";  //LOC CODE
    var xx7="";  //LOC NAME
    var xx8="";
    var xx9="";
    
    var returntitle="";
    switch(btn_obj) {    
        case "btns_vndr_seq":
            returntitle = "Service Provider";
            break;
    }
    
    var param="&returnval="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9+"&returntitle="+returntitle;
    ComOpenPopup('ESD_TRS_0979.do?parentPgmNo=ESD_TRS_M001'+ param, 430, 410, "getTRS_ENS_979", "1,0", true);
}

/**
 * Location: In the single-selection pop-up hangyeongwoo.
 */
function getTRS_ENS_979(rowArray, x1) {
    var formObject=document.form;
    formObject.vndr_seq.value=rowArray;
    
	// disable Send BFI button
    disableSendBFI();
}

function getCalendar(){
    var cal2=new ComCalendarFromTo();
    cal2.displayType="date";
    cal2.select(document.form.fm_dt,document.form.to_dt,'yyyy-MM-dd');
    
	// disable Send BFI button
    disableSendBFI();
}

/**
 * Pop-up call rep_commodity
 */
function rep_OnPopupClick() {
    var formObject=document.form;
    var cmdt_cd_val="";   
    var rep_cmdt_cd_val="";
    var cmdt_desc_val="";  
    var classId="getCOM_ENS_rep";
    var xx1="";  //CONTI
    var xx2="";  //SUB CONTI
    var xx3="";  //COUNTRY
    var xx4="";  //STATE
    var xx5="";  //CONTROL OFFIC
    var xx6="";  //LOC CODE
    var xx7="";  //LOC NAME
    var xx8="";
    var xx9="";
    var param="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
    ComOpenPopup('/opuscntr/COM_ENS_0C1.do' + param, 700, 478, 'getCOM_ENS_rep', '1,0,1,1,1,1,1,1,1,1,1,1');
}

/**
 * rep_commodity pop-up Call: hangyeongwoo single selection from a pop-up.
 */
function getCOM_ENS_rep(rowArray) {
    var formObj = document.form;
    for(var i = 0; i < rowArray.length; i++) {
        var colArray = rowArray[0];
        var colArray2 = colArray[2];
        var colArray3 = colArray[4];
        formObj.combo_svc_provider.value = colArray2;
        formObj.svc_provider.value = colArray3;
    }
}

/**
 * enter check
 **/
function enterCheck(obj) {
    var sheetObj=sheetObjects[0];
    var formObj=document.form;
    if(ComGetEvent("keycode") == 13) {
        switch(ComGetEvent("name")) {
            case 'combo_svc_provider':
                getTextVendorSeq(sheetObj, formObj, obj.value);
                break;
        }
    }
}

/**
 * Pop-up call ofc
 */
function ofc_OnPopupClick(val) {
    var formObject=document.form;
    var cmdt_cd_val="";   
    var rep_cmdt_cd_val="";
    var cmdt_desc_val="";  
    var classId="getCOM_ENS_so";
    var xx1=val;  //CONTI
    var xx2="";  //SUB CONTI
    var xx3="";  //COUNTRY
    var xx4="";  //STATE
    var xx5="";  //CONTROL OFFIC
    var xx6="";  //LOC CODE
    var xx7="";  //LOC NAME
    var xx8="";
    var xx9="";
    var param="?returnval="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
    ComOpenPopup('/opuscntr/COM_ENS_071.do' + param, 768, 487, 'getCOM_ENS_071', '1,0,1,1,1,1,1,1,1,1,1,1');
}

/**
 * Combo box-cost
 */
function bound_OnChange_2(obj) {
    var codeval=obj.value;
    var formObject=document.form;
    formObject.hid_costmode.value=codeval;
}

/**
 * Combo box-trans
 */
function bound_OnChange_3(obj) {
    var codeval=obj.value;
    var formObject=document.form;
    formObject.hid_transmode.value=codeval;
}

function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
    var formObject=document.form;
    var info = {Type: "Text", Align: "Right", Edit: 0};

    var row = sheetObj.FindSubSumRow();
    var arrRow = row.split("|");

    for(var i = 0; i < arrRow.length ; i++) {
        sheetObj.InitCellProperty(arrRow[i], "bzc_amt_desc", info);
        sheetObj.SetCellFontBold(arrRow[i], "bzc_amt_desc", 1);
    }

    sheetObj.SetSelectRow(-1);
    
    // enable/disable Send BFI button
    if(sheetObj.RowCount() > 0 && !formObject.not_sp.checked) {
    	formObject.btn_bfi.disabled = false;
    	global_sendBFI = true;
    } else {
    	formObject.btn_bfi.disabled = true;
    	global_sendBFI = false;
    }
}

function sheet2_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
	doActionIBSheet2(sheetObj,document.form,IBDOWNEXCEL);
}

/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
    switch(sAction) {
        case IBSEARCH:
            if (!ComChkValid(formObj)) return false;
             break;
        case IBDOWNEXCEL:
            if (!ComChkValid(formObj)) return false;
             break;
    }
    
    return true;
}

/**
 * Pop-up call office code: hangyeongwoo single selection from a pop-up.
 */
function getCOM_ENS_071(rowArray) {
    var formObject=document.form;
    var colArray=rowArray[0];
    var in_val_2=colArray[3];
    formObject.cre_ofc_cd.value=in_val_2;
    
	// disable Send BFI button
    disableSendBFI();
}

function resizeSheet(sheetObj){
    ComResizeSheet(sheetObj);
}

/**
 * Inquiry 전 Date의 '-'를 제거하는 function
 * @param formObj
 */
function replaceDateField(formObj) {
	formObj.fm_dt.value = formObj.fm_dt.value.split('-').join('');
    formObj.to_dt.value = formObj.to_dt.value.split('-').join('');
}


/**
 * validate the condition for Sending email
 * valid conditon : choose only one S/P & retrieved data exists
 * @returns {Boolean}
 */
function disableSendBFI() {
	var formObject = document.form;
	// disable Send BFI button
	formObject.btn_bfi.disabled = true;
	global_sendBFI = false;
}