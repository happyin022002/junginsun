/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_PSO_0003.js
*@FileTitle  : Vessel Information Management
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/26
=========================================================*/
/****************************************************************************************
  Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
                    MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
                    Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// public variable
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick(){
    var sheetObject1=sheetObjects[0];
    /*******************************************************/
    var formObject=document.form;
    try {
        var srcName=ComGetEvent("name");
        switch(srcName) {
            case "btn_retrieve":
                doActionIBSheet(sheetObject1,formObject,IBSEARCH);
                break;
            case "btn_new":
                //Grid Data Clear and Date
                sheetObject1.RemoveAll();
                formObject.srh_cnd.value=1;
                setToday(formObj.from_date,"ym");
                setToday(formObj.to_date,"ym");
                break;
			case "btn_Excel":
				if(sheetObject1.RowCount() < 1){//no data
           		 	ComShowCodeMessage("COM132501");
	       		}else{
	       			sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1 });
	       		}
				break
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
 * adding first-served functions after loading screen
 */
function loadPage() {
    for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    initControl(sheetObjects[0]);  
    
}
/**
 * registering initial event 
 */
function initControl(sheetObj){
    formObj=document.form;
    setToday(formObj.from_date,"ym");
    setToday(formObj.to_date,"ym");
    //axon_event.addListenerFormat('keypress', 'obj_keypress', form);
    axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);
    axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', form);
    //axon_event.addListenerForm('keyup', 'obj_keyup', form);
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    var sheetid=sheetObj.id;
    switch(sheetid) {
        case "sheet1":
            with(sheetObj){
                var tempTilte="Vessel particular";
                var HeadTitle="Vessel particular";
                for (var i=1; i < (12 + 12); i++) {
                    HeadTitle=HeadTitle + "|" + tempTilte;
                }
                var HeadTitle1="Seq.|VSL CD|VSL Name|"+HeadTitle;
                var HeadTitle2="Seq.|VSL CD|VSL Name|GRT|NRT|Design\nCapacity|LOA|DWT|Suez\nNet Tonnage|Suez\nGross Ton|Panama\nAllowance TEU|BM|Summer\nDraft|Flag|Ownership";
                
                var tempTitle2="chk";
                for (var i=1; i <= 12; i++) {
                    HeadTitle2=HeadTitle2 + "|"+tempTitle2+i;
                }
                var headCount=ComCountHeadTitle(HeadTitle2);
                var prefix="sheet1_";
                
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:3, DataRowMerge:0 } );
                
                var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [{Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
                            {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_cd" },
                            {Type:"Text",     Hidden:0,  Width:180,  Align:"Left",    ColMerge:1,   SaveName:prefix+"vsl_eng_nm" },
                            {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"grs_rgst_tong_wgt" },
                            {Type:"Text",     Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix+"net_rgst_tong_wgt" },
                            {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_dzn_capa" },
                            {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"loa_len" },
                            {Type:"Text",     Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:prefix+"dwt_wgt" },
                            {Type:"Text",     Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:prefix+"scnt" },
                            {Type:"Text",     Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:prefix+"scgt" },
                            {Type:"Text",     Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_pnm_capa" },
                            {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_wdt" },
                            {Type:"Text",     Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix+"smr_drft_hgt" },
                            {Type:"Text",     Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_rgst_cnt_cd" },
                            {Type:"Text",     Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_own_ind_cd" },
                            
                            {Type:"Text",     Hidden:1,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix+"chk_grt_yn" },
                            {Type:"Text",     Hidden:1,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix+"chk_nrt_yn" },
                            {Type:"Text",     Hidden:1,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix+"chk_desing_capacity_yn" },
                            {Type:"Text",     Hidden:1,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix+"chk_loa_yn" },
                            {Type:"Text",     Hidden:1,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix+"chk_dwt_yn" },
                            {Type:"Text",     Hidden:1,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix+"chk_scnt_yn" },
                            {Type:"Text",     Hidden:1,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix+"chk_scgt_yn" },
                            {Type:"Text",     Hidden:1,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix+"chk_allowance_teu_yn" },
                            {Type:"Text",     Hidden:1,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix+"chk_bm_yn" },
                            {Type:"Text",     Hidden:1,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix+"chk_summer_draft_yn" },
                            {Type:"Text",     Hidden:1,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix+"chk_flag_yn" },
                            {Type:"Text",     Hidden:1,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix+"chk_ownership_yn" } ];
                        
                InitColumns(cols);
                
                SetEditable(0);
                //SetSheetHeight(522);
                
                resizeSheet();
            }
                        
            break;
    }
}
// handling sheet process
function doActionIBSheet(sheetObj,formObj,sAction) {
    if( !validateForm(sheetObj,formObj,sAction) )
        return;
    sheetObj.ShowDebugMsg(false);
    var aryPrefix=new Array("sheet1_", "sheet2_");
    switch(sAction) {
        case IBSEARCH:      //Retrieving
            sheetObjects[0].SetWaitImageVisible(0);
            ComOpenWait(true);
            formObj.f_cmd.value=SEARCH;
            sheetObj.DoSearch("VOP_PSO_0003GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_") );
            ComOpenWait(false);
            break;
    }
}

function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
	var varBackColor = "#FFFFE4";
	var iStartRow = sheetObj.HeaderRows();
	var iEndRow = sheetObj.LastRow();
	var prefix = "sheet1_";
	var chkUsedYn = "";
	var chkValue = "";
	for(var i=iStartRow; i <= iEndRow; i++){
		//GRT
		chkUsedYn = sheetObj.GetCellValue(i, prefix+"chk_grt_yn");
		if(chkUsedYn =="Y"){
			chkValue =  sheetObj.GetCellValue(i, prefix+"grs_rgst_tong_wgt");
			if(ComIsEmpty(chkValue)){
				sheetObj.SetCellBackColor(i, prefix+"grs_rgst_tong_wgt", varBackColor);
			}
			sheetObj.SetCellBackColor(i, prefix+"chk_grt_yn", varBackColor);
		}
		//NRT
		chkUsedYn = sheetObj.GetCellValue(i, prefix+"chk_nrt_yn");
		if(chkUsedYn =="Y"){
			chkValue =  sheetObj.GetCellValue(i, prefix+"net_rgst_tong_wgt");
			if(ComIsEmpty(chkValue)){
				sheetObj.SetCellBackColor(i, prefix+"net_rgst_tong_wgt", varBackColor);
			}
			sheetObj.SetCellBackColor(i, prefix+"chk_nrt_yn", varBackColor);
		}
		//Design Capacity
		chkUsedYn = sheetObj.GetCellValue(i, prefix+"chk_desing_capacity_yn");
		if(chkUsedYn =="Y"){
			chkValue =  sheetObj.GetCellValue(i, prefix+"cntr_dzn_capa");
			if(ComIsEmpty(chkValue)){
				sheetObj.SetCellBackColor(i, prefix+"cntr_dzn_capa", varBackColor);
			}
			sheetObj.SetCellBackColor(i, prefix+"chk_desing_capacity_yn", varBackColor);
		}
		//LOA
		chkUsedYn = sheetObj.GetCellValue(i, prefix+"chk_loa_yn");
		if(chkUsedYn =="Y"){
			chkValue =  sheetObj.GetCellValue(i, prefix+"loa_len");
			if(ComIsEmpty(chkValue)){
				sheetObj.SetCellBackColor(i, prefix+"loa_len", varBackColor);
			}
			sheetObj.SetCellBackColor(i, prefix+"chk_loa_yn", varBackColor);
		}
		//DWT
		chkUsedYn = sheetObj.GetCellValue(i, prefix+"chk_dwt_yn");
		if(chkUsedYn =="Y"){
			chkValue =  sheetObj.GetCellValue(i, prefix+"dwt_wgt");
			if(ComIsEmpty(chkValue)){
				sheetObj.SetCellBackColor(i, prefix+"dwt_wgt", varBackColor);
			}
			sheetObj.SetCellBackColor(i, prefix+"chk_dwt_yn", varBackColor);
		}		
		//suez net tonnage
		chkUsedYn = sheetObj.GetCellValue(i, prefix+"chk_scnt_yn");
		if(chkUsedYn =="Y"){
			chkValue =  sheetObj.GetCellValue(i, prefix+"scnt");
			if(ComIsEmpty(chkValue)){
				sheetObj.SetCellBackColor(i, prefix+"scnt", varBackColor);
			}
			sheetObj.SetCellBackColor(i, prefix+"chk_scnt_yn", varBackColor);
		}
		//suez gross ton
		chkUsedYn = sheetObj.GetCellValue(i, prefix+"chk_scgt_yn");
		if(chkUsedYn =="Y"){
			chkValue =  sheetObj.GetCellValue(i, prefix+"scgt");
			if(ComIsEmpty(chkValue)){
				sheetObj.SetCellBackColor(i, prefix+"scgt", varBackColor);
			}
			sheetObj.SetCellBackColor(i, prefix+"chk_scgt_yn", varBackColor);
		}
		//panama allwance teu
		chkUsedYn = sheetObj.GetCellValue(i, prefix+"chk_allowance_teu_yn");
		if(chkUsedYn =="Y"){
			chkValue =  sheetObj.GetCellValue(i, prefix+"cntr_pnm_capa");
			if(ComIsEmpty(chkValue)){
				sheetObj.SetCellBackColor(i, prefix+"cntr_pnm_capa", varBackColor);
			}
			sheetObj.SetCellBackColor(i, prefix+"chk_allowance_teu_yn", varBackColor);
		}
		//BM
		chkUsedYn = sheetObj.GetCellValue(i, prefix+"chk_bm_yn");
		if(chkUsedYn =="Y"){
			chkValue =  sheetObj.GetCellValue(i, prefix+"vsl_wdt");
			if(ComIsEmpty(chkValue)){
				sheetObj.SetCellBackColor(i, prefix+"vsl_wdt", varBackColor);
			}
			sheetObj.SetCellBackColor(i, prefix+"chk_bm_yn", varBackColor);
		}
		//Summer Draft
		chkUsedYn = sheetObj.GetCellValue(i, prefix+"chk_summer_draft_yn");
		if(chkUsedYn =="Y"){
			chkValue =  sheetObj.GetCellValue(i, prefix+"smr_drft_hgt");
			if(ComIsEmpty(chkValue)){
				sheetObj.SetCellBackColor(i, prefix+"smr_drft_hgt", varBackColor);
			}
			sheetObj.SetCellBackColor(i, prefix+"smr_drft_hgt", varBackColor);
		}
		//Flag
		chkUsedYn = sheetObj.GetCellValue(i, prefix+"chk_flag_yn");
		if(chkUsedYn =="Y"){
			chkValue =  sheetObj.GetCellValue(i, prefix+"vsl_rgst_cnt_cd");
			if(ComIsEmpty(chkValue)){
				sheetObj.SetCellBackColor(i, prefix+"vsl_rgst_cnt_cd", varBackColor);
			}
			sheetObj.SetCellBackColor(i, prefix+"chk_flag_yn", varBackColor);
		}
		//Ownership
		chkUsedYn = sheetObj.GetCellValue(i, prefix+"chk_ownership_yn");
		if(chkUsedYn =="Y"){
			chkValue =  sheetObj.GetCellValue(i, prefix+"vsl_own_ind_cd");
			if(ComIsEmpty(chkValue)){
				sheetObj.SetCellBackColor(i, prefix+"vsl_own_ind_cd", varBackColor);
			}
			sheetObj.SetCellBackColor(i, prefix+"chk_ownership_yn", varBackColor);
		}
		
	}
	
	ComOpenWait(false);
    
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
    with(formObj){
          if(! ComIsDate( formObj.from_date.value , "ym" ) ) {
            ComShowCodeMessage('PSO00014', "[from_date]");
            return false;
          }
          if(! ComIsDate( formObj.to_date.value , "ym" ) ) {
            ComShowCodeMessage('PSO00014', "[to_date]");
            return false;
          }
          if( ComTrimAll(formObj.from_date.value, "-" ) > ComTrimAll(formObj.to_date.value, "-" ) ) {
            ComShowCodeMessage('PSO00014', "[date]");
            return false;
          } 
    }
    return true;
}
function validMonth(obj){
        if(! ComIsDate( obj.value , "ym" ) ) {
            obj.value="";
            return false;
        }
}
function setMonth(obj){
        var cal=new ComCalendar();
        cal.setDisplayType('month');
        cal.select(obj, "yyyy-MM");
}
function setToDate(obj){
   if( !validMonth(obj) )
    return;
   form.to_date.value=ComGetDateAdd(form.from_date.value, "M", 12, "-").substring(0,7); 
}
function obj_keyup(){
    var eleObj=ComGetEvent();
    var formObj=document.form;
    switch (eleObj.name) {
        case "from_date":
            if(eleObj.value.length == 6){
                formObj.to_date.focus();
            }
            break; 
        case "to_date":
            if(eleObj.value.length == 6){
                formObj.srh_cnd.focus();
            }
            break;
    }
}
/** 
 * Handling key press event
 */ 
function obj_keypress(){
 obj=ComGetEvent();
 if(obj.dataformat == null) return;
 window.defaultStatus=obj.dataformat;
     switch(obj.dataformat) {
        case "ym": case "ymd":
            ComKeyOnlyNumber(obj);
            break;
     }
}
/** 
 * Handling activate event
 */
function obj_activate(){
    ComClearSeparator(ComGetEvent("name"));
}
/** 
 * Handling deactivate event
 */
function obj_deactivate(){
    var formObj=document.form;
    obj=ComGetEvent();       
    with(formObj){
         if(obj.name=="from_date" || obj.name=="to_date"){
             var creDtFr=ComReplaceStr(from_date.value,"-","");
             var creDtTo=ComReplaceStr(to_date.value,"-","");
             switch(ComGetEvent("name")) {
                    case "from_date":   // Agreement From Date
                        if(creDtFr != '' && creDtTo != ''){
                            if(creDtFr > creDtTo){
                                ComShowCodeMessage('COM12133','To date','From date','greater');
                                from_date.value='';
                                document.form.from_date.focus();
                                return false;
                            }
                        }
                        break;
                    case "to_date": // Agreement To Date
                        if(creDtFr != '' && creDtTo != ''){
                            if(creDtFr > creDtTo){
                                ComShowCodeMessage('COM12133','To date','From date','greater');
                                to_date.value='';
                                to_date.focus();
                                return false;
                            }
                        }
                        break;  
                }
                ComChkObjValid(ComGetEvent());
         }
    }
    return true;    
}   

function resizeSheet(){
	//ComResizeSheet(sheetObjects[0]);
	for (var i=0; i<sheetObjects.length; i++){
        ComResizeSheet(sheetObjects[i]);
    }
}
