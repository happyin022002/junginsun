/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : stm_sco_0300.js
 *@FileTitle : SAKURA Code Conversion
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
			case "btn_retrieve":
				doActionIBSheet(sheetObject, formObj, IBSEARCH);
				break;
    	    case "btn_new" :
    	    	formObj.reset();
    	    	sheetObjects[0].RemoveAll();
				comboObjects[0].RemoveAll();
    	    	doActionIBSheet(sheetObject, formObj, COMMAND01);
    	    	break;				
			case "btn_save":
				doActionIBSheet(sheetObject, formObj, MULTI);
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
	for (var k=0; k<comboObjects.length; k++) {
		initCombo(comboObjects[k],k+1);
	}
    initControl();
    doActionIBSheet(sheetObjects[0], document.form, COMMAND01); // OFC, DATE, COMBO Setting
    lu_tp_cd.SetSelectIndex(0);
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
    //handling Axon event. event catch
    axon_event.addListenerFormat('focus'           , 'obj_activate',   formObj);
    axon_event.addListenerFormat('blur'            , 'obj_deactivate', formObj);
}
//handling Axon event 2
function obj_blur(){
}
function obj_keypress(){
	switch(event.srcElement.dataformat){
	case "engup":
		ComKeyOnlyAlphabet('uppernum');
		break;
	case "engnum":
		ComKeyOnlyAlphabet('uppernum');
		break;	
	case "int":
		//숫자 만입력하기
		ComKeyOnlyNumber(event.srcElement);
		break;
	case "ymd":
		ComKeyOnlyNumber(event.srcElement);
		break;
	case "float":
		ComKeyOnlyNumber(event.srcElement, "-.");
		break;
	default:
		//common standard: recognization only number, english
		ComKeyOnlyAlphabet("num");
		break;     
	}	
}
function obj_keyup(){
	var formObj=document.form;
	switch (event.srcElement.name) {
	case "ofc_cd":
		ComKeyOnlyAlphabet('uppernum');
		break;
	}//end of switch
}
/** 
 * handling work javascript OnFocus event  <br>
 */    
function obj_activate() {
   	//delete mask separator
    ComClearSeparator(event.srcElement);        
} 
/**
 * HTML Control onfocus validate event <br>
 **/
function obj_deactivate(){
	ComChkObjValid(event.srcElement);	
}
/**
 * Combo Setting default
 * @param	{IBMultiCombo}	combo_obj.
 * @param	{Number}	comboNo		Sequence number from combo object tag id
 */
function initCombo (comboObj, comboNo) {
    switch(comboObj.id) {
		   case "lu_tp_cd":
				with (comboObj) {
	        	   SetTitle("Code|Desc");
	        	   SetTitleVisible(true);
	        	   SetColAlign(0, "left");
	        	   SetColAlign(1, "left");
	        	   SetColWidth(0, "120");
	        	   SetColWidth(1, "150");
	        	   SetDropHeight(200);
				   }
	            break;
		   default :
	           with (comboObj) {
		       }
           break;
     }
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
    var sheetID=sheetObj.id;
    var prefix=sheetID + "_";
    switch (sheetNo) {
    	case 1: //t1sheet1 init
		    with(sheetObj){	
	    		var HeadTitle1="|No|OPUS|OPUS|SAKURA|SAKURA|Enable|conv_tp_cd";
	    		var HeadTitle2="|No|Code|Desc|Code|Desc|Enable|conv_tp_cd";
			    var headCount=ComCountHeadTitle(HeadTitle1);
			
			    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			
			    var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
			    var headers = [ { Text:HeadTitle1, Align:"Center"},
			                    { Text:HeadTitle2, Align:"Center"} ];
			    InitHeaders(headers, info);
			
			    var cols = [ {Type:"Status",    Hidden:1, 	Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
			                 {Type:"Seq",       Hidden:0, 	Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  	Width:100,  Align:"Left",    ColMerge:1,   SaveName:prefix+"src_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  	Width:300,  Align:"Left",    ColMerge:1,   SaveName:prefix+"src_desc",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  	Width:100,  Align:"Left",    ColMerge:1,   SaveName:prefix+"tgt_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
			                 {Type:"Text",      Hidden:0,  	Width:300,  Align:"Left",    ColMerge:1,   SaveName:prefix+"tgt_desc",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:500 },
			                 {Type:"CheckBox",  Hidden:0, 	Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"use_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:1, 	Width:50,   Align:"Left",    ColMerge:1,   SaveName:prefix+"conv_tp_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			     
			    InitColumns(cols);
			    SetEditable(1);
			    resizeSheet();	//SetSheetHeight(430);
	    		   
	    		SetColProperty(0 ,prefix+"tgt_cd" , {AcceptKeys:"N|E", InputCaseSensitive:1});
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
	var prefix=sheetID + "_";
	if (!validateForm(sheetObj, formObj, sAction)) return;
	switch (sAction) {		
		case COMMAND01: // RETRIEVE AP OFFICE, AP OFFICE LOCAL CURRENTY
			//Conversion Type ComboBox			
			var saburaConvCd=ScoGetComboItems(sheetObj, "STM_SCO_0300GS.do", SEARCH01, "", "sabura_conv_cd");

			MakeComboObject2(lu_tp_cd, saburaConvCd, "N");
			//Default Setting
			ComSetObjValue(lu_tp_cd, "ALL");
			
	 		break;
	 		
		case IBSEARCH: //retrieve
			formObj.f_cmd.value=SEARCH;			
			var sXml=sheetObj.GetSearchData("STM_SCO_0300GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
			sheetObj.LoadSearchData(sXml,{Sync:1} );
			
			break;
			
		case MULTI: // Save
			if (ComShowCodeConfirm("SCO00009", "save?")) {
				formObj.f_cmd.value=MULTI;
				var sParam=ComGetSaveString(sheetObj);
		    	if (sParam == "") return;
		    	sParam += "&" + FormQueryString(formObj);
		    	ComOpenWait(true);
		    	var sXml=sheetObj.GetSaveData("STM_SCO_0300GS.do", sParam);
				ComOpenWait(false);
				
				if (SCODecideErrXml(sheetObj, sXml)) {
					return;
				} else {
					ComShowCodeMessage("SCO00001");
				}
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
			}
		    break;			
	}
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
		case MULTI: 			
			if (!sheetObj.IsDataModified()) {
				ComShowCodeMessage("SCO00010");
				return false;
			} 
			break;
	}
	return true;
}

function MakeComboObject2(cmbObj, arrStr, vacantRow) {
	var cnt=0;
	if (vacantRow == "Y") {
		cmbObj.InsertItem(0, "", "");
		cnt=1;
	}
	for (var i=1; i < arrStr.length; i++ ) {
		var arrStr2=arrStr[i].split("^");
		var code=arrStr2[0];
		cmbObj.InsertItem(cnt, code + "|" + arrStr2[1] , code);
		cnt++;
	}
	cmbObj.SetDropHeight(190);
}
