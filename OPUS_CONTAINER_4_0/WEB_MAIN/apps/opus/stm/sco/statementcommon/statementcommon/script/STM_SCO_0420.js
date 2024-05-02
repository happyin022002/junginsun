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
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	/***** setting sheet object *****/
	var sheetObject=sheetObjects[0];
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
			    initAccrualMonth();
			    
				comboObjects[0].SetSelectIndex(-1,false);
				sheetObject.RemoveAll();
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
                SetUseAutoComplete(1);
                SetTitleVisible(0);//title
                SetTitle("Code|Name");
                SetColAlign(0, "center");
                SetColAlign(1, "left");
                SetColWidth(0, "120");
                SetColWidth(1, "0");
                
                SetDropHeight(160);
                ValidChar(2,1);//only upper case
                SetMaxLength(15);
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

function initAccrualMonth(){
    var formObj=document.form;
    var today = ComGetNowInfo("ymd",DATE_SEPARATOR);
    var tmpToDay = ComGetDateAdd(today,"M", -1);
    tmpToDay = tmpToDay.replace(/\/|\-|\.|\:|\ /g,"");
    
    tmpToDay = ComGetMaskedValue(tmpToDay.substring(0,6),"ym");
    
    ComSetObjValue(formObj.accl_yrmon, tmpToDay);
    ComSetObjValue(formObj.pfitctr_cd, "");
    ComSetObjValue(formObj.key, "");
    ComSetObjValue(formObj.mdl_tp_cd, "COST");
    ComSetObjValue(formObj.job_flg, "COST");
    ComSetObjValue(formObj.locl_curr_cd, "USD");
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
	    		var HeadTitle1="|Act Month|Profit Center|SAKURA Account|Currency|Accrual|OPR306 I/F|OPR306 I/F";
	    		var HeadTitle2="|Act Month|Profit Center|SAKURA Account|Currency|Accrual Cost|Document Amount|Local Amount";
			    var headCount=ComCountHeadTitle(HeadTitle1);
			
			    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			
			    var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
			    var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
			    InitHeaders(headers, info);
			
			    var cols = [ {Type:"Status",    Hidden:1, 	Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			                 {Type:"Text",      Hidden:0, 	Width:120,  Align:"Center",  ColMerge:1,   SaveName:"act_yrmon",      KeyField:0,   CalcLogic:"",   Format:"Ym",          PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0, 	Width:170,  Align:"Center",  ColMerge:1,   SaveName:"pfitctr_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  	Width:160,  Align:"Center",  ColMerge:1,   SaveName:"gl_acct_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  	Width:120,  Align:"Center",  ColMerge:1,   SaveName:"locl_curr_cd",	  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"AutoSum",   Hidden:0,  	Width:220,  Align:"Right",   ColMerge:1,   SaveName:"accl_doc_amt",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"AutoSum",  	Hidden:0, 	Width:220,  Align:"Right",   ColMerge:1,   SaveName:"opr_doc_amt",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"AutoSum",   Hidden:0, 	Width:220,  Align:"Right",   ColMerge:1,   SaveName:"opr_locl_amt",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 }];
			     
			    InitColumns(cols);
			    SetEditable(1);
	    		
			    resizeSheet();
    		}
		break;
	}
}

function resizeSheet(){
	ComResizeSheet(sheetObjects[0]);
}

// handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
	var sheetID=sheetObj.id;
	if (!validateForm(sheetObj, formObj, sAction)) return;
	switch (sAction) {
		case IBSEARCH: //retrieve
			formObj.f_cmd.value=SEARCH;
			sheetObj.RemoveAll();
            //ComOpenWait(true);
            
			var sXml=sheetObj.GetSearchData("STM_SAC_0050GS.do", FormQueryString(formObj));
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
            var sXml=sheetObj.GetSearchData("STM_SAC_0050GS.do", FormQueryString(formObj));
            
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
            var sXml=sheetObj.GetSearchData("STM_SAC_0050GS.do", FormQueryString(formObj));
            sheetObj.LoadSearchData(sXml,{Sync:0} );
            ComOpenWait(false);
            
            break;
            
		case IBSEARCH_ASYNC01: 	// Combo Data : Trade, Account
            formObj.f_cmd.value=COMMAND01;
            var sXml=sheetObj.GetSearchData("STM_SAC_0050GS.do", FormQueryString(formObj));
            
            var resultKey=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
            if("S" == resultKey){
                ComXml2ComboItem(sXml, gl_acct_no, "code", "code");
            }
            
            break;			 
	}
}

function doBackEndJobResult(){
    doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
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
function sheet1_OnSearchEnd(sheetObj, ErrMsg){
    var rowCnt = sheetObj.RowCount();

    sheetObj.SetRowBackColor(sheetObj.LastRow(), "#F7E1EC");
    sheetObj.SetMergeCell(sheetObj.LastRow(), 0, 1,4);
    sheetObj.SetSumText(0, 4,"Total");//TOTAL이라는 글자가 잘리지 않게 넓은데로 옮김

}



