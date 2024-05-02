/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : STM_SCO_0410.js
 *@FileTitle : TES Manual Cancellation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
              MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
              OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

// common global variable
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();        
var comboCnt=0;
var gCurRow=0;
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	/***** setting sheet object *****/
	var sheetObject=getCurrentSheet();
	/*******************************************************/
	var formObj=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
			case "accl_yrmon_cal":
				var cal=new ComCalendar();
				cal.setDisplayType('month');
				cal.select(formObj.accl_yrmon, 'yyyy-MM');
				break;
			case "btn_retrieve":
			    ComSetObjValue(formObj.key, "");
				doActionIBSheet(sheetObject, formObj, IBSEARCH);
				break;
			case "btn_new":
			    initSearchReset(sheetObj);
                break;
			case "btn_downexcel":
    	    	if(sheetObject.RowCount() < 1){//no data
    	    		ComShowCodeMessage("COM132501");
	    		}else{
	    		    sheetObject.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject), SheetDesign:1,Merge:1 });
	    		}					
    	    	break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage(OBJECT_ERROR);
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
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
/** 
 * registering IBCombo Object as list
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
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	// initializing IBMultiCombo
    for ( var k=0; k < comboObjects.length; k++) {
        initCombo(comboObjects[k], k + 1);
    }
    for(k=0;k<tabObjects.length;k++){
        initTab(tabObjects[k],k+1);
        tabObjects[k].SetSelectedIndex(0);
    }
	// sheet 사이즈 고정
	//sheetObjects[0].SetExtendLastCol(0);
    initControl();
}

/**
 * setting Combo basic info
 * @param comboObj 
 * @param comboIndex Number
 */
function initCombo(comboObj, comboNo) {
    var formObject=document.form
    switch (comboNo) {
        case 1: 
            with (comboObj) { 
                SetMultiSelect(0);
                SetUseAutoComplete(0);
                SetColAlign(0, "left");
                SetDropHeight(160);
                ValidChar(2,1);//only upper case
                SetMaxLength(3);
            }
            mdl_tp_cd.InsertItem(-1, "TES", "TES");  //ALL
            mdl_tp_cd.InsertItem(-1, "TRS", "TRS");  //ALL
            
            mdl_tp_cd.SetSelectIndex(0);
            
            
            break; 
        case 2: 
            with (comboObj) { 
                SetMultiSelect(0);
                SetUseAutoComplete(1);
                SetTitleVisible(0);//title
                SetTitle("Code|Name");
                SetColAlign(0, "center");
                SetColAlign(1, "left");
                SetColWidth(0, "60");
                SetColWidth(1, "200");
                
                SetDropHeight(160);
                ValidChar(2,1);//only upper case, numbers
                SetMaxLength(3);
            }
            break;
        case 3: 
            with (comboObj) { 
                SetMultiSelect(0);
                SetUseAutoComplete(1);
                SetTitleVisible(0);//title
                SetTitle("Code|Name");
                SetColAlign(0, "center");
                SetColAlign(1, "left");
                SetColWidth(0, "80");
                SetColWidth(1, "250");
                
                SetDropHeight(160);
                ValidChar(2,1);//only upper case
                SetMaxLength(6);
            }
            break;
    }
}
/**
 * loading HTML Control event <br>
 * {@link #loadPage} function call this. so IBSheet Object is initialized. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sequence number in sheetObjects array
 **/
function initControl() {
	//** Date Separator **/
	DATE_SEPARATOR="-";
	var formObj=document.form;
	
	initAccrualMonth();
	
	//combo data 
	doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC01);
}
/**
 * registering IBTab Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 */
function setTabObject(tab_obj){
    tabObjects[tabCnt++]=tab_obj;
}
/**
 * initializing Tab
 * setting Tab items
 */
function initTab(tabObj , tabNo) {
     switch(tabNo) {
         case 1:
            with (tabObj) {
                var cnt=0 ;
                InsertItem( "Summary" , "");
                InsertItem( "Detail" , "");
            }
         break;
     }
}
/**
 * Event when clicking Tab
 * activating selected tab items
 */
function tab1_OnChange(tabObj , nItem)
{
    var objs=document.all.item("tabLayer");
    objs[nItem].style.display="Inline";
    objs[beforetab].style.display="none";
    //--------------- important --------------------------//
    objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
    //------------------------------------------------------//
    beforetab=nItem;
    
    if (beforetab == 0) {
        initConditionObject("S");      
    }else{
        initConditionObject("D");
    }
    
    resizeSheet();
}

function initAccrualMonth(){
    var formObj=document.form;
    var today = ComGetNowInfo("ymd",DATE_SEPARATOR);
    var tmpToDay = ComGetDateAdd(today,"M", -1);
    tmpToDay = tmpToDay.replace(/\/|\-|\.|\:|\ /g,"");
    
    tmpToDay = ComGetMaskedValue(tmpToDay.substring(0,6),"ym");
    
    ComSetObjValue(formObj.accl_yrmon, tmpToDay);
    ComSetObjValue(formObj.locl_curr_cd, "USD");
    ComSetObjValue(formObj.key, "");
}

/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
    switch (sheetNo) {
        case 1: //t1sheet1 init
            with(sheetObj){ 
                var HeadTitle1="|Act Month|Terminal Invoice (USD)|Terminal Invoice (USD)|Terminal Invoice (USD)|Accrual (USD)|Accrual (USD)|Accrual (USD)|mdl_tp_cd|accl_yrmon";
                var HeadTitle2="|Act Month|Estimate Cost|Actual Cost|Accrual Cost|Estimate Cost|Actual Cost|Accrual Cost|mdl_tp_cd|accl_yrmon";
                var headCount=ComCountHeadTitle(HeadTitle1);
            
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
            
                var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
                InitHeaders(headers, info);
            
                var cols = [ {Type:"Status",    Hidden:1,   Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                             {Type:"Text",      Hidden:0,   Width:180,  Align:"Center",  ColMerge:1,   SaveName:"act_yrmon",     KeyField:0,   CalcLogic:"",   Format:"Ym",          PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"AutoSum",   Hidden:0,   Width:180,  Align:"Right",   ColMerge:1,   SaveName:"trgt_estm_usd", KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"AutoSum",   Hidden:0,   Width:180,  Align:"Right",   ColMerge:1,   SaveName:"trgt_act_usd",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"AutoSum",   Hidden:0,   Width:180,  Align:"Right",   ColMerge:1,   SaveName:"trgt_accl_usd", KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"AutoSum",   Hidden:0,   Width:180,  Align:"Right",   ColMerge:1,   SaveName:"accl_estm_usd", KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"AutoSum",   Hidden:0,   Width:180,  Align:"Right",   ColMerge:1,   SaveName:"accl_act_usd",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"AutoSum",   Hidden:0,   Width:180,  Align:"Right",   ColMerge:1,   SaveName:"accl_accl_usd", KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:1,   Width:0,    Align:"Center",  ColMerge:1,   SaveName:"mdl_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:1,   Width:0,    Align:"Center",  ColMerge:1,   SaveName:"accl_yrmon",    KeyField:0,   CalcLogic:"",   Format:"Ym",          PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
                 
                InitColumns(cols);
                SetEditable(1);
                
            }
        break;
    	case 2: //t2sheet1 init
		    with(sheetObj){	
	    		var HeadTitle1="|Act Month|OPUS\nAccount|Trade|Terminal Invoice (USD)|Terminal Invoice (USD)|Terminal Invoice (USD)|Accrual (USD)|Accrual (USD)|Accrual (USD)|mdl_tp_cd|accl_yrmon";
	    		var HeadTitle2="|Act Month|OPUS\nAccount|Trade|Estimate Cost|Actual Cost|Accrual Cost|Estimate Cost|Actual Cost|Accrual Cost|mdl_tp_cd|accl_yrmon";
			    var headCount=ComCountHeadTitle(HeadTitle1);
			
			    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			
			    var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
			    var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
			    InitHeaders(headers, info);
			
			    var cols = [ {Type:"Status",    Hidden:1, 	Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			                 {Type:"Text",      Hidden:0, 	Width:110,  Align:"Center",  ColMerge:1,   SaveName:"act_yrmon",     KeyField:0,   CalcLogic:"",   Format:"Ym",          PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  	Width:120,  Align:"Center",  ColMerge:1,   SaveName:"acct_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  	Width:100,  Align:"Center",  ColMerge:1,   SaveName:"trd_cd",	     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"AutoSum",   Hidden:0,  	Width:150,  Align:"Right",   ColMerge:1,   SaveName:"trgt_estm_usd", KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"AutoSum",  	Hidden:0, 	Width:150,  Align:"Right",   ColMerge:1,   SaveName:"trgt_act_usd",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"AutoSum",   Hidden:0, 	Width:150,  Align:"Right",   ColMerge:1,   SaveName:"trgt_accl_usd", KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"AutoSum",   Hidden:0, 	Width:150,  Align:"Right",   ColMerge:1,   SaveName:"accl_estm_usd", KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"AutoSum",   Hidden:0, 	Width:150,  Align:"Right",   ColMerge:1,   SaveName:"accl_act_usd",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"AutoSum",   Hidden:0, 	Width:150,  Align:"Right",   ColMerge:1,   SaveName:"accl_accl_usd", KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:1,   Width:0,    Align:"Center",  ColMerge:1,   SaveName:"mdl_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:1,   Width:0,    Align:"Center",  ColMerge:1,   SaveName:"accl_yrmon",    KeyField:0,   CalcLogic:"",   Format:"Ym",          PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
			     
			    InitColumns(cols);
			    SetEditable(1);
	    		
    		}
		break;
	}
}

function resizeSheet(){
    if(beforetab == 0){
        ComResizeSheet(sheetObjects[0]);
    }else{
        ComResizeSheet(sheetObjects[1]);
    }
}

// handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
	var sheetId=sheetObj.id;
	if (!validateForm(sheetObj, formObj, sAction)) return;
	switch (sAction) {
		case IBSEARCH: //retrieve
			formObj.f_cmd.value=SEARCH;
			setJobFlagParam(sheetObj);//job_flg 셋팅.
			
			var sXml=sheetObj.GetSearchData("STM_SAC_0040GS.do", FormQueryString(formObj));
			var key = ComGetEtcData(sXml, "key");
			if(!ComIsEmpty(key)){
			    ComSetObjValue(formObj.key, key);
                ComOpenWait(true);
                sheetObj.SetWaitTimeOut(10000);
                //sheetObj.RequestTimeOut = 600;  //10분
                intervalId = setInterval("doBackEndJobResult();",3000);
			}
			break;
        case IBSEARCH_ASYNC02: //backendjob status check
            formObj.f_cmd.value=SEARCH01;
            var sXml=sheetObj.GetSearchData("STM_SAC_0040GS.do", FormQueryString(formObj));
            
            var jbStsFlg = ComGetEtcData(sXml, "jb_sts_flg");
            
            if (!ComIsNotErrMessage(sheetObj, sXml)) {
                clearInterval(intervalId);
                ComOpenWait(false);
                return;
            }
            if ("SUCCESS"==jbStsFlg) {
                clearInterval(intervalId);
                doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC03);
                //getCntrExcelBackEndJobLoadFile();
            } else if ("FAIL"==jbStsFlg) {
                clearInterval(intervalId);
                ComOpenWait(false);
                ComShowMessage(ComGetSelectSingleNode(sXml,"MESSAGE"));
            }
            break;
        case IBSEARCH_ASYNC03: //backendjob result
            formObj.f_cmd.value=SEARCH02;
            var sXml=sheetObj.GetSearchData("STM_SAC_0040GS.do", FormQueryString(formObj));
            sheetObj.LoadSearchData(sXml,{Sync:0} );
            ComOpenWait(false);
            
            break;
            
		case IBSEARCH_ASYNC01: 	// Combo Data : Trade, Account
            formObj.f_cmd.value=COMMAND01;
            var sXml=sheetObj.GetSearchData("STM_SAC_0040GS.do", FormQueryString(formObj));
            
            var arrXml = sXml.split("|$$|");            
            
            var resultKey=ComGetEtcData(arrXml[0], "TRANS_RESULT_KEY");
            if("S" == resultKey){
                ComXml2ComboItem(arrXml[0], trd_cd, "code", "code|name");
                ComXml2ComboItem(arrXml[1], acct_cd, "code", "code|name");
            }
            
            break;			 
	}
}

function doBackEndJobResult(){
    var sheetObj = getCurrentSheet();
    doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC02);
}

function ComIsNotErrMessage(SheetObj, xmlStr){
    if(xmlStr == null  || xmlStr == "" ) return true;
    try {
      var vPrefix = xmlStr.substring(1,6);
   
       if (vPrefix == "ERROR") {
            SheetObj.LoadSearchXml(xmlStr);
            return false;
       } else {
           return true;
       }

    } catch(err) { ComFuncErrMsg(err.message); }
}

function mdl_tp_cd_OnChange(comboObj, OldIndex, OldText, OldCode, NewIndex, NewText, NewCode){
    initHeaderText(NewCode);
}

function initHeaderText(mdlTpCd){
    //Module 조건이 변경 되었을때 Tab별 Sheet 초기화.
    sheetObjects[0].RemoveAll();
    sheetObjects[1].RemoveAll();
    
    var headerText = "";
    if("TES" == mdlTpCd){
        headerText = "Terminal Invoice (USD)";
    }else if("TRS" == mdlTpCd){
        headerText = "Transportation Invoice (USD)";      
    }
    
    for (i=0; i < sheetObjects.length; i++) {
        sheetObjects[i].SetCellText(0, "trgt_estm_usd", headerText);
        sheetObjects[i].SetCellText(0, "trgt_act_usd", headerText);
        sheetObjects[i].SetCellText(0, "trgt_accl_usd", headerText);  
    }    
}

/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
		case IBSEARCH:
			if (!ComChkValid(formObj)) return false;
			break;
	}
	return true;
}


/**
 * after search data
 */
function t1sheet1_OnSearchEnd(sheetObj, ErrMsg){
    var rowCnt = sheetObj.RowCount();

    sheetObj.SetRowBackColor(sheetObj.LastRow(), "#F7E1EC");
    //sheetObj.SetMergeCell(sheetObj.LastRow(), 0, 1, 0);
    sheetObj.SetSumText(0, 1,"Total");//TOTAL이라는 글자가 잘리지 않게 넓은데로 옮김

}
/**
 * after search data
 */
function t2sheet1_OnSearchEnd(sheetObj, ErrMsg){
    var rowCnt = sheetObj.RowCount();

    sheetObj.SetRowBackColor(sheetObj.LastRow(), "#F7E1EC");
    sheetObj.SetMergeCell(sheetObj.LastRow(), 0, 1,3);
    sheetObj.SetSumText(0, 3,"Total");//TOTAL이라는 글자가 잘리지 않게 넓은데로 옮김

}
function initConditionObject(flag){
    
    var formObj = document.form;
    var tmpMdlTpCd = ComGetObjValue(formObj.mdl_tp_cd);
    var tmpAcclYrmon = ComGetUnMaskedValue(ComGetObjValue(formObj.accl_yrmon), "ym");
    var rowCnt = 0; 
    if("S" == flag){//Summary Tab
        //기존에 조회 데이타가 조건과 일치 하지 않으면 자동 재조회.(Module, Accrual Month)
        rowCnt = sheetObjects[0].RowCount();
        if(rowCnt > 0){
            var tmpSheetMdlTpCd = sheetObjects[0].GetCellValue(rowCnt, "mdl_tp_cd");
            var tmpSheetAcclYrmon = sheetObjects[0].GetCellValue(rowCnt, "accl_yrmon");
            
            if(tmpMdlTpCd != tmpSheetMdlTpCd || tmpAcclYrmon != tmpSheetAcclYrmon){
                sheetObjects[0].RemoveAll();
                doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
            }
        }
        //sheetObjects[1].RemoveAll();        
    }else if("D" == flag){//Detail Tab 설정시.        
        //sheetObjects[0].RemoveAll();
        rowCnt = sheetObjects[1].RowCount();
        if(rowCnt > 0){
            var tmpSheetMdlTpCd = sheetObjects[1].GetCellValue(rowCnt, "mdl_tp_cd");
            var tmpSheetAcclYrmon = sheetObjects[1].GetCellValue(rowCnt, "accl_yrmon");
            
            if(tmpMdlTpCd != tmpSheetMdlTpCd || tmpAcclYrmon != tmpSheetAcclYrmon){
                sheetObjects[1].RemoveAll();
                doActionIBSheet(sheetObjects[1], formObj, IBSEARCH);
            }
        }
    }
}
function initSearchReset(sheetObj) {
    initAccrualMonth();
    
    comboObjects[0].SetSelectIndex(0);
    comboObjects[1].SetSelectIndex(-1,false);
    comboObjects[2].SetSelectIndex(-1,false);
    
    for (i=0; i<sheetObjects.length; i++){
        sheetObjects[i].RemoveAll();
    }    
    if (beforetab == 0) {
        initConditionObject("S");
    }else{
        initConditionObject("D");
    }
}
function setJobFlagParam(sheetObj){
    var sheetId=sheetObj.id;
    var formObj = document.form;
    var mdlTpCd =  mdl_tp_cd.GetSelectCode();
    var jobFlg = ""
    if(sheetId == "t1sheet1"){
        if(mdlTpCd == "TRS"){
            jobFlg = "TRS_SUM";
        } else {
            jobFlg = "TES_SUM";
        }
    }else if(sheetId == "t2sheet1"){
        jobFlg = mdlTpCd;
    }

    ComSetObjValue(formObj.job_flg, jobFlg);
    sheetObj.RemoveAll();
    //ComOpenWait(true);
}
function getCurrentSheet(){
    var sheetObj=null;
    if(beforetab == 0){
        sheetObj=sheetObjects[0];
    }else{
        sheetObj=sheetObjects[1];
    }    
    return sheetObj;
}


