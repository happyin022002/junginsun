/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   STM_SCO_0020.js
*@FileTitle  : Lookup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/06
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
              MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
              OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends 
 * @class STM_SCO_0020 : business script for STM_SCO_0020
 */
// common global variable
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();        
var comboCnt=0;
var gCurRow=0;
var now_select_sheet1=0 ;
var max_lu_tp_cd=0 ;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	/***** setting sheet object *****/
	var sheetObject1=sheetObjects[0];
	var sheetObject2=sheetObjects[1];
	/*******************************************************/
	var formObj=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject1, formObj, IBSEARCH);
				break;
			case "btn_save":
				doActionIBSheet(sheetObject1, formObj ,IBSAVE);	
				break; 
			case "btn_new":
				formObj.lu_tp_cd.value="";
				comboObjects[0].SetSelectCode("",false);//초기화
            	sheetObject1.RemoveAll();
            	sheetObject2.RemoveAll();
                break;
			case "btn_add_h":
				doActionIBSheet(sheetObject1, formObj, IBINSERT);
				break;
			case "btn_del_h": 
				doActionIBSheet(sheetObject1, formObj, IBDELETE);					
				break;	
			case "btn_add_d":
				doActionIBSheet(sheetObject2, formObj, MODIFY01);
				break;
			case "btn_del_d": 
				doActionIBSheet(sheetObject2, formObj, MODIFY02);					
				break;			
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage('SAP00001');
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
    doActionIBSheet(sheetObjects[0], document.form , SEARCH01);
    document.form.lu_tp_cd.focus();
}
/**
 * Removing IBSheet Row
 **/
function rowRemove(sheetObj){
	ComRowHideDelete(sheetObj, "DelChk");
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
	axon_event.addListenerFormat('blur', 'obj_blur'    , formObj); 	//- handling code when OnBeforeDeactivate(blur) event
	axon_event.addListenerFormat('focus'  , 'obj_focus'   , formObj);            //- handling code when OnBeforeActivate event in case of existing dataformat property
    //axon_event.addListenerFormat('keypress'        , 'obj_keypress', formObj); 	//- handling code when onkeypress event in case of existing dataformat property
    //axon_event.addListenerFormat('keyup'           , 'form_keyup'  , formObj);
    //axon_event.addListenerForm('keypress'          , 'obj_keypress', formObj);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
}
//handling Axon event 2
function obj_blur(){
    ComChkObjValid(ComGetEvent());
	var src=ComGetEvent("name")
}
function obj_focus(){
    ComClearSeparator(ComGetEvent());
}
function obj_keypress(){
	var src=ComGetEvent("name");
}
function form_keyup(){
	ComKeyEnter('lengthnextfocus');
}
function obj_onclick(){
	var src=ComGetEvent("name")
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;	
	switch (sheetObj.id) {
	case "sheet1": //t1sheet1 init
	    with(sheetObj){
			var HeadTitle1="|Del|Type|Application|Description|Conv.";
			var headCount=ComCountHeadTitle(HeadTitle1);
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

			var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			InitHeaders(headers, info);

			var cols = [ {Type:"Status",     Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                         {Type:"DummyCheck", Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"chk_h"  },
                         {Type:"Text",       Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"lu_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,	EditLen:25,		InputCaseSensitive:1  },
                         {Type:"Combo",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"lu_appl_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,	EditLen:5   },
                         {Type:"Text",       Hidden:0,  Width:250,  Align:"Left",    ColMerge:1,   SaveName:"lu_desc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,	EditLen:500 },
                         {Type:"Combo",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cd_conv_nd_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,	EditLen:1   }];
       
			InitColumns(cols);
			//SetSheetHeight(360);
			resizeSheet();
			SetEditable(1);
			SetSelectionMode(smSelectionRow); 
			InitDataCombo(0,"cd_conv_nd_flg",'N|Y','N|Y','N');  
        }
	    break;
	case "sheet2": //t1sheet1 init
	    with(sheetObj){
			var HeadTitle2="|Del|SEQ|Type|Code|Description|From|To|Attribute1|Attribute2|Attribute3|Attribute4|Attribute5|Enable";
			var headCount=ComCountHeadTitle(HeadTitle2);
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

			var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle2, Align:"Center"} ];
			InitHeaders(headers, info);

			var cols = [ {Type:"Status",     Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                         {Type:"DummyCheck", Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"chk_d" },
                         {Type:"Text",       Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dp_seq",      KeyField:0,   CalcLogic:"",   Format:"Number",      PointCount:0,   UpdateEdit:1,   InsertEdit:1,	EditLen:4   },
                         {Type:"Text",       Hidden:1,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"lu_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,	EditLen:25  },
                         {Type:"Text",       Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"lu_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,	EditLen:25,		InputCaseSensitive:1  },
                         {Type:"Text",       Hidden:0,  Width:400,  Align:"Left",    ColMerge:1,   SaveName:"lu_desc",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,	EditLen:500 },
                         {Type:"PopupEdit",  Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"lu_st_dt",    KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1,	EditLen:8   },
                         {Type:"PopupEdit",  Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"lu_end_dt",   KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1,	EditLen:8   },
                         {Type:"Text",       Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"attr_ctnt1",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,	EditLen:200 },
                         {Type:"Text",       Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"attr_ctnt2",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,	EditLen:200 },
                         {Type:"Text",       Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"attr_ctnt3",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,	EditLen:200 },
                         {Type:"Text",       Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"attr_ctnt4",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,	EditLen:200 },
                         {Type:"Text",       Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"attr_ctnt5",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,	EditLen:200 },
                         {Type:"CheckBox",   Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"enbl_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,	EditLen:1   } ];
       
			InitColumns(cols);
			//SetSheetHeight(360);
			resizeSheet();
			SetEditable(1);
        }
	    break;
	}
}
// handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
	if (!validateForm(sheetObj, formObj, sAction))		
		return;
	switch (sAction) {		
	    case SEARCH01: //retrieve
			//retrieve aPPLICATION
			formObj.f_cmd.value=COMMAND01;
			var sXml=sheetObj.GetSearchData("STM_SCO_0020GS.do", FormQueryString(formObj));
			var sStr=ComGetEtcData(sXml,"appl_cd_list");
			sStr = sStr.replace(/\s+/, '').replace(/\|\|/, '|');
			var arrStr=sStr.split("|");
			MakeApplCdComboObject(lu_appl_cd, arrStr);				
		   	sheetObj.SetColProperty("lu_appl_cd", {ComboText:sStr, ComboCode:sStr} );
			break;
		case IBSEARCH: //retrieve
			formObj.f_cmd.value=SEARCH01;		
			var sXml=sheetObj.GetSearchData("STM_SCO_0020GS.do", FormQueryString(formObj));
			sheetObj.LoadSearchData(sXml,{Sync:1} );
			break;			
		case IBSEARCH_ASYNC01:
            formObj.f_cmd.value=SEARCH02;		
            formObj.h_lu_tp_cd.value=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "lu_tp_cd");
            var sXml=sheetObj.GetSearchData("STM_SCO_0020GS.do", FormQueryString(formObj));
			sheetObj.LoadSearchData(sXml,{Sync:1} );
			break;			
		case IBSAVE:        //save				
			if (!validateForm(sheetObj,formObj,sAction)) {		 				
				return false;
			}
            var sParamSheet1=sheetObjects[0].GetSaveString(true); //AS-IS has param true
			if (sheetObjects[0].IsDataModified()&& sParamSheet1 == "") {
			    return;
			}
            var sParamSheet2=sheetObjects[1].GetSaveString(true); //AS-IS has param true
			if (sheetObjects[1].IsDataModified()&& sParamSheet2 == "") {
			    return;
			}
 			formObj.f_cmd.value=MULTI01;	
 			var sParam=FormQueryString(formObj);
 			if(sParamSheet1 == "" && sParamSheet2 == ""){
 				return;
 			}
	 		if( sParamSheet1 != "" ){
				sParam += "&" + ComPriSetPrifix(sParamSheet1, "sheet1_");
			}
	 		if( sParamSheet2 != "" ){
				sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
			}
	 		ComOpenWait(true);
	 		setTimeout(function(){
	 			var sXml=sheetObj.GetSaveData("STM_SCO_0020GS.do", sParam);
		 		var currentGetRowStatus=sheetObjects[1].GetRowStatus(sheetObjects[1].GetSelectRow());
			
				if (SCODecideErrXml(sheetObj, sXml)) {
					return;
				} else {
					ComShowCodeMessage("SCO00001");
				}
	 			sheetObj.LoadSaveData(sXml);
	 			ComOpenWait(false);
	 		}, 100);
 			break;			 			
		case IBINSERT: //Header Row Insert		
			if (!validateForm(sheetObj, document.form, sAction)) {
				return false;
			}			
			var idx=sheetObj.DataInsert();
			break; 
		case IBDELETE: // Header Row Delete
			if (!validateForm(sheetObj,formObj,sAction)) {		 				
				return false;
			}
			ComRowHideDelete(sheetObj, "chk_h");
			sheetObjects[1].RemoveAll();
	 		break; 
		case MODIFY01: //Detail Row Insert
			if (!validateForm(sheetObj, document.form, sAction)) {
				return false;
			}	
			with (sheetObjects[1]) { 
 			var nowRow=GetSelectRow();
 			maxRow=DataInsert(-1);
 			sheetObj.SetCellValue(maxRow, "lu_tp_cd",sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "lu_tp_cd"));
  			sheetObj.SetCellValue(maxRow, "enbl_flg",1);
			}
			break; 
		case MODIFY02: // Detail Row Delete
			if (!validateForm(sheetObj,formObj,sAction)) {		 				
				return false;
			}
			ComRowHideDelete(sheetObj, "chk_d");
	 		break; 
	  }
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
		case IBSEARCH: //retrieve
			break;
		case IBINSERT: //insert	
			break;
		case MODIFY01:		
			if (sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "lu_tp_cd") == "") {
				ComShowCodeMessage('SCO00004', 'input', 'Type');
				return false;				
			} else if (sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "lu_appl_cd") == "") {
				ComShowCodeMessage('SCO00004', 'input', 'Application');
				return false;				
			}
			break;
		case IBSAVE:			
            var dupRow1=sheetObjects[0].ColValueDup("lu_tp_cd");
            var dupRow2=sheetObjects[1].ColValueDup("lu_cd");
            
            if (sheetObjects[0].IsDataModified()== false && sheetObjects[1].IsDataModified()== false) {
            	ComShowCodeMessage('SCO00010');
            	return false;
            }

            // Dup data pre-check before saving
            if (dupRow1>0) {  
            	sheetObjects[0].SetSelectRow(dupRow1);
            	ComShowCodeMessage('SCO00004', 'Check', 'Duplicated Type');
                ComSetFocus(sheetObjects[0].ColValueDupRows("lu_tp_cd"));	
                return false;
            }
            if (dupRow2>0) {
            	sheetObjects[1].SetSelectRow(dupRow2);
            	ComShowCodeMessage('SCO00004', 'Check', 'Duplicated Code');
                ComSetFocus(sheetObjects[1].ColValueDupRows("lu_cd"));	
                return false;
            }
            if (sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "lu_tp_cd") == "") {
				ComShowCodeMessage('SCO00004', 'input', 'Type');
				return false;				
            } else if (sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "lu_appl_cd") == "") {
				ComShowCodeMessage('SCO00004', 'input', 'Application');
				return false;				
			} 
			// Detail row validation
			if (sheetObjects[1].length > 0) {
				for (var i=sheetObjects[1].HeaderRows(); i<= sheetObjects[1].LastRow(); i++){
					if (sheetObjects[1].GetCellValue(i, "dp_seq") == "") {
		     			ComShowCodeMessage('SCO00004', 'input', 'SEQ');
						return false;	
					} else if (sheetObjects[1].GetCellValue(i, "lu_tp_cd") == ""){
		     			ComShowCodeMessage('SCO00004', 'input', 'Type');
						return false;
					} else if (sheetObjects[1].GetCellValue(i, "lu_cd") == ""){
		     			ComShowCodeMessage('SCO00004', 'input', 'Code');
						return false;		     			 
					}
				}
	     	}	
		
			break;
		case IBDELETE:
			if (ComPriSheetCheckedRows(sheetObj, "chk_h") == "") {
				ComShowCodeMessage('SCO00004', 'Select', 'checkbox');
				return false;	  
			}
			break;
		case MODIFY02:
			if (ComPriSheetCheckedRows(sheetObj, "chk_d") == "") {
				ComShowCodeMessage('SCO00004', 'Select', 'checkbox');
				return false;	  
			}
			break;
	}
	return true;
}
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	if(sheetObj.GetEtcData(ComWebKey.Trans_Result_Key) == "S") {
			doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC01);
	}
}
/**
 * calling function when occurring OnClick Event <br>
 * showing memopad when clicking desc cell (MemoPad editable)<br>
 */ 
function sheet1_OnClick(sheetObj, Row, Col, Value) {
	if(Col != 5){
		doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC01);
	} 
		//sheetObj.SelectCell(Row, Col);
}


function sheet2_OnChange(sheetObj, Row, Col, Value) {

	with (sheetObj) {
		var luStDt  = GetCellValue(Row, "lu_st_dt");
		var luEndDt = GetCellValue(Row, "lu_end_dt");
		
		if ( ColSaveName(Col) == "lu_st_dt" || ColSaveName(Col) == "lu_end_dt") {
			if ( luStDt != "" && luEndDt != "" ) {
				if ( luStDt > luEndDt ) {
					ComShowCodeMessage('SCO00011');
					SetCellValue(Row, Col,"");
					SelectCell(Row, Col);
				}
			}
		}		
	}	
}


function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
	//if combined data
	for (var i=sheetObj.HeaderRows(); i<= sheetObj.LastRow(); i++){
		}	
}


/**
 * IBSeet내의 데이터 셀의 팝업 버튼이 눌러졌을 때 발생하는 Event<br>
 * @param {sheetObj} String : 해당 IBSheet셀 명
 * @param {Row} Long : 해당 셀의 Row Index
 * @param {Col} Long : 해당 셀의 Column Index
 */	
function sheet2_OnPopupClick(sheetObj, Row, Col){
	var sheetID=sheetObj.id;
	with (sheetObj) {
        switch (ColSaveName(Col)) {
            case  "lu_st_dt": 
            	var cal=new ComCalendarGrid(ColSaveName(Col));
    			cal.select(sheetObj, Row, Col, 'yyyy-MM-dd');        			
            	break;
            case  "lu_end_dt": 
            	var cal=new ComCalendarGrid(ColSaveName(Col));
    			cal.select(sheetObj, Row, Col, 'yyyy-MM-dd');
            	break;
        }
    }
}


/**
 * 한 화면에 여러개의 Sheet가 있는 경우, SaveString에 prefix를 붙여준다 <br>
 *
 * @param {string} sStr 필수, QueryString from IBSheet.GetSaveString().
 * @param {string} sPrefix 필수, Prefix.
 * @return string 쿼리스트링의 각 name앞에, 주어진 prefix가 붙여진 쿼리스트링.
 * @author  HJPARK
 * @version 2013.04.01
 */
function ComPriSetPrifix(sStr, sPrefix) {
    if (sStr == null || sStr == "" || sPrefix == null || sPrefix == "") {
        return sStr;
    }
    var regexp=RegExp(/&/g);
    sStr=sPrefix + sStr.replace(regexp, "&" + sPrefix);
    return sStr;
}
/**
 * SHEET에서 CHECK된 ROW의 INDEX를 배열로 리턴한다. <br>
 * <br><b>Example :</b>
 * <pre>
 *  var chkArr = ComPriSheetCheckedRows(sheetObj, "chk");
 *  for(var i=0;i < chkArr.length;i++){
 *      ComDebug(sheetObj.CellValue(Number(chkArr[i]), "note_seq"));
 *  }
 * </pre>
 * @param  {ibsheet} sheetObj 필수 IBSheet Object
 * @param  {string} Column Index(SaveName)
 * @return chkArr Array
 * @author 최성민
 * @version 2009.08.13
 */
function ComPriSheetCheckedRows(sheetObj, selChk) {
	var chkArr=new Array();
	var iCheckRow=sheetObj.FindCheckedRow(selChk);//.slice(0, -1);
	if(iCheckRow != "") {
		chkArr=iCheckRow.split("|");
	}
	return chkArr;
}
/** 
 * handling OnKeyPress events <br>
 * handling process for input validation by object's dataformat   <br>
 */ 
/* 
function obj_keypress() {
	var formObj=document.form;
	switch (ComGetEvent("name")) {
		case "lu_tp_cd":
			var luTpCd=formObj.lu_tp_cd.value;
			formObj.lu_tp_cd.value=luTpCd.toUpperCase();
			break;
	}
}
*/ 

/**
 * create combo box<br>
 * <br><b>Example : </b>
 * <pre>
 *    MakeApplCdComboObject(cmbObj, arrStr);
 * </pre>
 * @param object cmbObj
 * @param String arrStr
 * @author Park hee jin
 * @version 2014.04.02
 */
function MakeApplCdComboObject(cmbObj, arrStr) {
	for (var i = 0; i < arrStr.length; i++ ) {
		cmbObj.InsertItem(i, arrStr[i], arrStr[i]);			 
	}
	cmbObj.SetDropHeight(190);
}  

function resizeSheet(){
	ComResizeSheet(sheetObjects[0]);
	ComResizeSheet(sheetObjects[1]);
}