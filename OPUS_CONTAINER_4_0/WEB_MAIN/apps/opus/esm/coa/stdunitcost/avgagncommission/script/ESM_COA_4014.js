/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ESM_COA_4014.js
 *@FileTitle : ..
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
var TAB_OFC = "OFC";
var TAB_CNT = "CNT";
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
			case "f_cost_yrmon_cal":
				var cal=new ComCalendar();
				cal.setDisplayType('month');
				cal.select(formObj.f_cost_yrmon, 'yyyy-MM');
				break;
			case "btn_retrieve":
				doActionIBSheet(sheetObject, formObj, IBSEARCH);
				break;
			case "btn_creation":
			    var strUrl="ESM_COA_4011.do" + "?f_cost_yrmon="+formObj.f_cost_yrmon.value+"&f_cost_type=acm_gen";
                ComOpenPopup(strUrl, '380', '260', '', '0,0', true);
                break;
			case "btn_downexcel":
    	    	if(sheetObject.RowCount() < 1){//no data
    	    		ComShowCodeMessage("COM132501");
	    		}else{
	    		    sheetObject.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject), SheetDesign:1,Merge:1 });
	    		}					
    	    	break;
            case "t1btn_rowadd":
                var nRow = sheetObject.DataInsert(-1);
                var tmpCommYrmon = ComGetObjValue(formObj.f_cost_yrmon);
                tmpCommYrmon = ComGetUnMaskedValue(tmpCommYrmon, "ym");
                sheetObject.SetCellValue(nRow, "t1sheet1_comm_yrmon", tmpCommYrmon, 0);
                
                break;
            case "t1btn_save":
            case "t2btn_save":
                doActionIBSheet(sheetObject, formObj, IBSAVE);
                break;
            case "t2btn_rowadd":
                var nRow = sheetObject.DataInsert(-1);
                var tmpCommYrmon = ComGetObjValue(formObj.f_cost_yrmon);
                tmpCommYrmon = ComGetUnMaskedValue(tmpCommYrmon, "ym");
                sheetObject.SetCellValue(nRow, "t2sheet1_comm_yrmon", tmpCommYrmon, 0);
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

    initControl();
    
    for(k=0;k<tabObjects.length;k++){
        initTab(tabObjects[k],k+1);
        tabObjects[k].SetSelectedIndex(0);
    }
	// sheet 사이즈 고정
	//sheetObjects[0].SetExtendLastCol(0);
    
    doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
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
	
	/*
    var today = ComGetNowInfo("ymd",DATE_SEPARATOR);
    var tmpToDay = ComGetDateAdd(today,"M", 0);
    tmpToDay = tmpToDay.replace(/\/|\-|\.|\:|\ /g,"");
    
    tmpToDay = ComGetMaskedValue(tmpToDay.substring(0,6),"ym");
    ComSetObjValue(formObj.f_cost_yrmon, tmpToDay);
    */
    var today = ComGetNowInfo("ym",DATE_SEPARATOR);
    ComSetObjValue(formObj.f_cost_yrmon, today);
    
    ComSetObjValue(formObj.f_selgroup, TAB_OFC);
    
    for (i=0; i<sheetObjects.length; i++){
        sheetObjects[i].RemoveAll();
    }	
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
                InsertItem( "Office AVG" , "");
                InsertItem( "Country AVG" , "");
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
        initConditionObject(TAB_OFC);      
    }else{
        initConditionObject(TAB_CNT);
    }
    
    resizeSheet();
}

function initConditionObject(flag){
    var formObj = document.form;

    if(TAB_OFC == flag){//Summary Tab
        sheetObjects[0].RemoveAll();
        ComSetObjValue(formObj.f_selgroup, TAB_OFC);
        ComEnableObject(formObj.f_ofc_cd, true);
        doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);      
    }else if(TAB_CNT == flag){//Detail Tab 설정시.        
        sheetObjects[1].RemoveAll();
        ComSetObjValue(formObj.f_selgroup, TAB_CNT);
        ComEnableObject(formObj.f_ofc_cd, false);
        doActionIBSheet(sheetObjects[1], formObj, IBSEARCH);
    }
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
                
                var HeadTitle="|Del.|Month|Office|Account|Account|Bound|Type/Size|Cost Code|Cost Code|Trade|Sub Trade|Qty|Total Amount|Unit Amount" ;
                var prefix="t1sheet1_";
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
                
                var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);
                
                var cols = [ {Type:"Status",    Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
                             {Type:"DelCheck",  Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"" },
                             {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"comm_yrmon",        KeyField:1,   CalcLogic:"",   Format:"Ym",     PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ofc_cd",            KeyField:1,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
                             {Type:"Combo",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ac_tp_cd",          KeyField:1,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:180,  Align:"Left",    ColMerge:0,   SaveName:prefix+"ac_tp_nm",          KeyField:1,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Combo",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"io_bnd_cd",         KeyField:1,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                             {Type:"Combo",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_tpsz_cd",      KeyField:1,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                             {Type:"Combo",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"comm_stnd_cost_cd", KeyField:1,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:160,  Align:"Left",    ColMerge:0,   SaveName:prefix+"comm_stnd_cost_nm", KeyField:1,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"trd_cd",            KeyField:1,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
                             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"sub_trd_cd",        KeyField:1,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
                             {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:prefix+"bkg_qty",           KeyField:0,   CalcLogic:"",   Format:"Float",  PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
                             {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:prefix+"comm_ttl_amt",      KeyField:0,   CalcLogic:"",   Format:"Float",  PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:25 },
                             {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:prefix+"comm_ut_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",  PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:25 } ];
                
                InitColumns(cols);
                
                SetEditable(1);
                SetColProperty(0 ,prefix+"comm_yrmon"          , {AcceptKeys:"N"   , InputCaseSensitive:1});
                SetColProperty(0 ,prefix+"ofc_cd"              , {AcceptKeys:"N|E" , InputCaseSensitive:1});
                SetColProperty(0 ,prefix+"trd_cd"              , {AcceptKeys:"N|E" , InputCaseSensitive:1});
                SetColProperty(0 ,prefix+"sub_trd_cd"          , {AcceptKeys:"N|E" , InputCaseSensitive:1});
            }
        break;
    	case 2: //t2sheet1 init
		    with(sheetObj){	

            var HeadTitle="|Del.|Month|Country|Account|Account|Bound|Type/Size|Cost Code|Cost Code|Trade|Sub Trade|Qty|Total Amount|Unit Amount" ;
            var prefix="t2sheet1_";
            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
            
            var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
            var headers = [ { Text:HeadTitle, Align:"Center"} ];
            InitHeaders(headers, info);
            
            var cols = [ {Type:"Status",    Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
                         {Type:"DelCheck",  Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"" },
                         {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"comm_yrmon",        KeyField:1,   CalcLogic:"",   Format:"Ym",     PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cnt_cd",            KeyField:1,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
                         {Type:"Combo",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ac_tp_cd",          KeyField:1,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0,  Width:180,  Align:"Left",    ColMerge:0,   SaveName:prefix+"ac_tp_nm",          KeyField:1,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Combo",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"io_bnd_cd",         KeyField:1,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                         {Type:"Combo",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_tpsz_cd",      KeyField:1,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                         {Type:"Combo",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"comm_stnd_cost_cd", KeyField:1,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0,  Width:160,  Align:"Left",    ColMerge:0,   SaveName:prefix+"comm_stnd_cost_nm", KeyField:1,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                         {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"trd_cd",            KeyField:1,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
                         {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"sub_trd_cd",        KeyField:1,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
                         {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:prefix+"bkg_qty",           KeyField:0,   CalcLogic:"",   Format:"Float",  PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
                         {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:prefix+"comm_ttl_amt",      KeyField:0,   CalcLogic:"",   Format:"Float",  PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:25 },
                         {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:prefix+"comm_ut_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",  PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:25 } ];
            
            InitColumns(cols);
            
            SetEditable(1);
            SetColProperty(0 ,prefix+"comm_yrmon"          , {AcceptKeys:"N"   , InputCaseSensitive:1});
            SetColProperty(0 ,prefix+"cnt_cd"              , {AcceptKeys:"N|E" , InputCaseSensitive:1});
            SetColProperty(0 ,prefix+"trd_cd"              , {AcceptKeys:"N|E" , InputCaseSensitive:1});
            SetColProperty(0 ,prefix+"sub_trd_cd"          , {AcceptKeys:"N|E" , InputCaseSensitive:1});
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
	    case IBCLEAR:          //Inquiry
            ComOpenWait(true);
    
            var sXml=document.form.sXml.value; 
            var arrXml=sXml.split("|$$|"); 
            var State=ComGetEtcData(arrXml[0],ComWebKey.Trans_Result_Key); 
            if(State != "S"){ 
                ComOpenWait(false);
                return;
            }   
            if (arrXml.length > 0){                
                ComCoaSetIBCombo(sheetObjects[0], arrXml[0], "t1sheet1_ac_tp_cd", true, 0, 0,"","", true);
                ComCoaSetIBCombo(sheetObjects[1], arrXml[0], "t2sheet1_ac_tp_cd", true, 0, 0,"","", true);
            }   
            if (arrXml.length > 1){
                ComCoaSetIBCombo(sheetObjects[0], arrXml[1], "t1sheet1_io_bnd_cd", true, 0);
                ComCoaSetIBCombo(sheetObjects[1], arrXml[1], "t2sheet1_io_bnd_cd", true, 0);
            }
            if (arrXml.length > 2){
                ComCoaSetIBCombo(sheetObjects[0], arrXml[2], "t1sheet1_cntr_tpsz_cd", true, 0);
                ComCoaSetIBCombo(sheetObjects[1], arrXml[2], "t2sheet1_cntr_tpsz_cd", true, 0);
            }
            if (arrXml.length > 3){
                ComCoaSetIBCombo(sheetObjects[0], arrXml[3], "t1sheet1_comm_stnd_cost_cd", true, 0, 0,"","", true);
                ComCoaSetIBCombo(sheetObjects[1], arrXml[3], "t2sheet1_comm_stnd_cost_cd", true, 0, 0,"","", true);
            }
            document.form.sXml.value="";
            ComOpenWait(false);             
            break;
		case IBSEARCH: //retrieve
		    formObj.f_cmd.value=SEARCH;
            var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam(sheetId+"_");
            
			ComOpenWait(true);
            var sXml=sheetObj.GetSearchData("ESM_COA_4014GS.do", sParam);
            sheetObj.LoadSearchData(sXml,{Sync:1} );
            ComOpenWait(false);            
			break;
			
        case IBSAVE:
            if(sheetId == "t1sheet1"){
                formObj.f_cmd.value=MULTI;
            }else{
                formObj.f_cmd.value=MULTI01;
            }
            var sParam=ComGetSaveString(sheetObj, true, true, -1);
            if (sParam == "") return;
            sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(sheetId+"_");
            var sXml=sheetObj.GetSaveData("ESM_COA_4014GS.do", sParam);
            sheetObj.LoadSaveData(sXml, {Sync:1});
            doActionIBSheet(sheetObj, formObj, IBSEARCH);  //재Retrieving
            
            break;
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
			
		case IBSAVE:  
		    var chkDupRow = 0;
		    var tmpMsg = "";
		    var sheetId=sheetObj.id;
		    var dupCols ="";
		    if(sheetId == "t1sheet1"){
		        dupCols = "t1sheet1_comm_yrmon|t1sheet1_ofc_cd|t1sheet1_ac_tp_cd|t1sheet1_io_bnd_cd|t1sheet1_cntr_tpsz_cd|t1sheet1_comm_stnd_cost_cd|t1sheet1_trd_cd|t1sheet1_sub_trd_cd";
		        chkDupRow = sheetObj.ColValueDup(dupCols, {IncludeDelRow:0}); // Status Del 대상은 Dup check 하지 않는 옵션 설정 IncludeDelRow:0
		    }else{
		        dupCols = "t2sheet1_comm_yrmon|t2sheet1_cnt_cd|t2sheet1_ac_tp_cd|t2sheet1_io_bnd_cd|t2sheet1_cntr_tpsz_cd|t2sheet1_comm_stnd_cost_cd|t2sheet1_trd_cd|t2sheet1_sub_trd_cd";
		        chkDupRow = sheetObj.ColValueDup(dupCols, {IncludeDelRow:0}); // Status Del 대상은 Dup check 하지 않는 옵션 설정 IncludeDelRow:0
		    } 
            if(chkDupRow > -1){
                tmpMsg = "("+chkDupRow+") row data ";
                ComShowCodeMessage('COM12115', tmpMsg);
                sheetObj.SelectCell(chkDupRow, sheetId+"_comm_yrmon");
                return false;
            }
            break;
	}
	return true;
}

function t1sheet1_OnSearchEnd(sheetObj, ErrMsg){}
function t2sheet1_OnSearchEnd(sheetObj, ErrMsg){}

function t1sheet1_OnChange(sheetObj, Row, Col, Value) {
    var colName=sheetObj.ColSaveName(Col);
    var formObj=document.form;
    var prefix = sheetObj.id+"_";
    switch(colName)
    {
        case prefix+"ac_tp_cd":
            if (Value != ""){
                // setting DESC
                var sText=sheetObj.GetComboInfo(Row, Col, "Text");
                var arrText=sText.split("|");                   
                var sIdx=sheetObj.GetComboInfo(Row, Col, "SelectedIndex");
                var sDesc=arrText[sIdx].split("\t");
                sheetObj.SetCellValue(Row, prefix+"ac_tp_nm",sDesc[1],0);
            } else {
                sheetObj.SetCellValue(Row, prefix+"ac_tp_nm","",0);
            }               
            break;
        case prefix+"comm_stnd_cost_cd":
            if (Value != ""){
                // setting DESC
                var sText=sheetObj.GetComboInfo(Row, Col, "Text");
                var arrText=sText.split("|");                   
                var sIdx=sheetObj.GetComboInfo(Row, Col, "SelectedIndex");
                var sDesc=arrText[sIdx].split("\t");
                sheetObj.SetCellValue(Row, prefix+"comm_stnd_cost_nm",sDesc[1],0);
            } else {
                sheetObj.SetCellValue(Row, prefix+"comm_stnd_cost_nm","",0);
            }               
            break;
    }
}

function t2sheet1_OnChange(sheetObj, Row, Col, Value) {
    var colName=sheetObj.ColSaveName(Col);
    var formObj=document.form;
    var prefix = sheetObj.id+"_";
    switch(colName)
    {
        case prefix+"ac_tp_cd":
            if (Value != ""){
                // setting DESC
                var sText=sheetObj.GetComboInfo(Row, Col, "Text");
                var arrText=sText.split("|");                   
                var sIdx=sheetObj.GetComboInfo(Row, Col, "SelectedIndex");
                var sDesc=arrText[sIdx].split("\t");
                sheetObj.SetCellValue(Row, prefix+"ac_tp_nm",sDesc[1],0);
            } else {
                sheetObj.SetCellValue(Row, prefix+"ac_tp_nm","",0);
            }               
            break;
        case prefix+"comm_stnd_cost_cd":
            if (Value != ""){
                // setting DESC
                var sText=sheetObj.GetComboInfo(Row, Col, "Text");
                var arrText=sText.split("|");                   
                var sIdx=sheetObj.GetComboInfo(Row, Col, "SelectedIndex");
                var sDesc=arrText[sIdx].split("\t");
                sheetObj.SetCellValue(Row, prefix+"comm_stnd_cost_nm",sDesc[1],0);
            } else {
                sheetObj.SetCellValue(Row, prefix+"comm_stnd_cost_nm","",0);
            }               
            break;
    }
}

function getCurrentSheet(){
    var sheetObj=null;
    var formObj = document.form;
    if(beforetab == 0){
        sheetObj=sheetObjects[0];
        ComSetObjValue(formObj.f_selgroup, TAB_OFC);
    }else{
        sheetObj=sheetObjects[1];
        ComSetObjValue(formObj.f_selgroup, TAB_CNT);
    }    
    return sheetObj;
}


