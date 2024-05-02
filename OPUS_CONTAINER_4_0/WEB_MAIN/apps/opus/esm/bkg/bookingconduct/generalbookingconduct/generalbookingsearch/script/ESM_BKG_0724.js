/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0724.js
*@FileTitle  : Roll Over Information
*@author     : CLT
*@version    : 1.0
*@since      : 2015/01/12
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

var sheetObjects = new Array();
var sheetCnt = 0;
var prefix1="sheet1_";
var asCodeList = "";
var asTextList = "";

// Event handler processing by button click event */
document.onclick = processButtonClick;

// Event handler processing by button name */
function processButtonClick(){
    /***** using extra sheet valuable if there are more 2 sheets *****/
    var sheetObject=sheetObjects[0];
//    var rdObject = rdObjects[0];
    /*******************************************************/
    var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
        switch(srcName) {                     
			case "btn_save":
				if (ComGetObjValue(formObject.modifyFlag)!="Y"){
					return false;
			    }
				if (sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),prefix1+"newdate").substring(0,9)==sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),prefix1+"predate").substring(0,9)){
					ComShowCodeMessage("BKG00108");
					return false;
				}
				doActionIBSheet(sheetObjects[0],formObject,IBSAVE);
				ComSetObjValue(formObject.modifyFlag,"N");
            break;
            
			case "btn_print":
			    rdOpen("print");
				break;
            
			case "btn_close": 
				var bflag=true;
				if (formObject.modifyFlag.value=="Y"){ 
					bflag=ComShowCodeConfirm("BKG00168");
				}
				if (bflag){
					ComClosePopup(); 
				}else{							
				}					
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
function loadPage(asCode,asText) {
    asCodeList = " |"+asCode;
	asTextList = " |"+asText;
	 
	for(var i=0;i<sheetObjects.length;i++){
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1,asCodeList,asTextList);
		ComEndConfigSheet(sheetObjects[i]);
	}
	sheet1_OnLoadFinish(sheetObjects[0])
}

function sheet1_OnLoadFinish(sheetObj) {   
	doActionIBSheet(sheetObj,document.form,IBSEARCH);   
} 
 /**	
  * setting sheet initial values and header
  * @param sheetObj
  * @param sheetNo
  * @return
  */
function initSheet(sheetObj,sheetNo,asCodeList,asTextList) {
//	alert(asCodeList);
    var cnt=0;
	var sheetId=sheetObj.id;
    switch(sheetId) {
        case "sheet1":
        	with(sheetObj){
	        	var HeadTitle1=" |||Now|Previous|Reason of Roll Over|User ID|Roll Over Date|Remark(s)|roll_ovr_seq";
	
	        	SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:0 } );
	
	        	var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	        	var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	        	InitHeaders(headers, info);
	
	        	//데이터속성    [ROW, 			COL,  		DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	        	var cols = [ {Type:"Status",    Hidden:1, Width:30,  Align:"Center",  ColMerge:0,   SaveName:prefix1+"ibflag" },
			        	     {Type:"Text",      Hidden:1, Width:80,  Align:"Center",  ColMerge:0,   SaveName:prefix1+"upd_usr_nm",		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			        	     {Type:"Text",      Hidden:0, Width:60,  Align:"Center",  ColMerge:0,   SaveName:prefix1+"title",			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			        	     {Type:"Text",      Hidden:0, Width:190, Align:"Center",  ColMerge:0,   SaveName:prefix1+"newdate",         KeyField:0,   CalcLogic:"",   Format:"",         	PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			        	     {Type:"Text",      Hidden:0, Width:190, Align:"Center",  ColMerge:0,   SaveName:prefix1+"predate",			KeyField:0,   CalcLogic:"",   Format:"",         	PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			        	     {Type:"Combo",     Hidden:0, Width:150, Align:"Center",  ColMerge:0,   SaveName:prefix1+"roll_ovr_rsn_cd",	KeyField:0,   CalcLogic:"",   Format:"",         	PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			        	     {Type:"Text",      Hidden:0, Width:80,  Align:"Center",  ColMerge:0,   SaveName:prefix1+"upd_usr_id",		KeyField:0,   CalcLogic:"",   Format:"",          	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			        	     {Type:"Text",      Hidden:0, Width:110, Align:"Center",  ColMerge:0,   SaveName:prefix1+"evnt_dt",			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			        	     {Type:"Text",  	Hidden:0, Width:150, Align:"Center",  ColMerge:0,   SaveName:prefix1+"diff_rmk",		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 ,TrueValue:"Y",FalseValue:"N"},
			        	     {Type:"Text",      Hidden:1, Width:0,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"roll_ovr_seq",	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, ];
	
	        	InitColumns(cols);
	
	        	SetEditable(1);
	        	SetCountPosition(0);
	        	SetColProperty(prefix1+"title", {AcceptKeys : "E", InputCaseSensitive :1} );
	        	SetColProperty(prefix1+"roll_ovr_rsn_cd", {ComboText:asTextList, ComboCode:asCodeList} );
	        	SetSheetHeight(200);

        	}


            break;
    }
}
/**
 * handling sheet process
 * @param sheetObj
 * @param formObj
 * @param sAction
 * @return void
 */
function doActionIBSheet(sheetObj,formObj,sAction) {
//    sheetObj.ShowDebugMsg(false);
	var arrPreFix=new Array("sheet1_");
    switch(sAction) {
      	case IBSEARCH:      //retrieve
			 formObj.f_cmd.value=SEARCH; 
			 var sXml=sheetObj.GetSearchData("ESM_BKG_0724GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(arrPreFix));
			 sheetObj.LoadSearchData(sXml);
		break;
      	case IBSAVE:        
			formObj.f_cmd.value=MULTI;
			
			var sParam = FormQueryString(formObj);
			sParam = sParam + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(true)); 
			
			var sXml = sheetObj.GetSaveData("ESM_BKG_0724GS.do", sParam);
			var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
			sheetObj.LoadSaveData(sXml);     
			
			if(State == "S"){
				ComClearObject(formObj.modifyFlag);
			}
		break;
    }
}

/*
* bkg_clz_tm table key value inserts at grit
*/
function sheet1_OnSearchEnd(sheetObj, ErrMsg){
	var formObj = document.form;
	sheetObj.SetCellFontUnderline(1,	"upd_usr_id",true);
	setFormData(formObj,sheetObj);
	ComClearObject(formObj.modifyFlag);
}


/*
* 시트 셀의 OnChange이벤트 처리
*/
function sheet1_OnChange(sheetObj,Row, Col, Value){
	var formObj = document.form;
	var sName = sheetObj.ColSaveName(Col);
	if (sName==prefix1+"diff_rmk" || sName==prefix1+"roll_ovr_rsn_cd"){
		ComSetObjValue(formObj.modifyFlag,"Y");
	}
}

/*
* 시트의 OnMouseMove 이벤트 처리
*/
function sheet1_OnMouseMove(sheetObj,Button, Shift, X, Y){
	var col  = sheetObj.MouseCol();
    var row  = sheetObj.MouseRow();
    var sName   = sheetObj.ColSaveName(col);
	if (sName==prefix1+"upd_usr_id"){
		sheetObj.SetToolTipText(row, sName, sheetObj.GetCellValue(row,prefix1+"upd_usr_nm" ))

	}else{
		sheetObj.SetToolTipText(row, sName, "");

	}
}


/*
* Data를 Form에 대입
*/
function setFormData(formObj,sheetObj){
	//ComSetObjValue(formObj.bkg_no,sheetObj.EtcData("bkg_no"));
	ComSetObjValue(formObj.bl_no,sheetObj.GetEtcData("bl_no"));
	ComSetObjValue(formObj.vvd,sheetObj.GetEtcData("vvd"));
	ComSetObjValue(formObj.pol,sheetObj.GetEtcData("pol"));
	ComSetObjValue(formObj.etb,sheetObj.GetEtcData("etb"));
	ComSetObjValue(formObj.etd,sheetObj.GetEtcData("etd"));

	for(var iRow=1;iRow<sheetObj.RowCount()+1;iRow++){
		sheetObj.SetCellValue(iRow,prefix1+"title","VVD/ETA");
		sheetObj.SetCellValue(iRow,prefix1+"ibflag","R");
	}
}

/**
 * 
 * @param viewType
 * @returns {Array}
 */
function getRdData(viewType){
	var rdData = [];
	var rdParam = "/rv " + "BKG_NO[" + ComGetObjValue(document.form.bkg_no) + "]";
	var rdUrl = "apps/opus/esm/bkg/bookingconduct/generalbookingconduct/generalbookingsearch/report/";
	var rdFile = "ESM_BKG_0816.mrd";
	rdData.push({'rdParam' : rdParam, 'rdUrl' : rdUrl, 'rdFile' : rdFile});
	return rdData;
}
