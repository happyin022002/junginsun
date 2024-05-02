/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SCO_0010.js
*@FileTitle  : Period Closing
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/04
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
              MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
              OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends 
 * @class STM_SCO_0010 : business script for STM_SCO_0010
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
	/*******************************************************/
	var formObj=document.form;
	try {
		var srcName=ComGetEvent("name");
		//alert("aaaaaaa : " + srcName);
		switch (srcName) {
			case "eff_yrmon_cal":
				var cal=new ComCalendar();
				cal.setDisplayType('month'); 
       			cal.select(form.eff_yr_mon, 'yyyy-MM'); 
	            break;
			case "btn_retrieve":
				doActionIBSheet(sheetObject1, formObj, IBSEARCH);
				break;
			case "btn_save":
				doActionIBSheet(sheetObject1, formObj ,IBSAVE);	
				break; 
			case "btn_new":
				formObj.eff_yr_mon.value="";
				formObj.prd_appl_cd.value="";
            	sheetObject1.RemoveAll();
                break;
			case "btn_add":
				var row=sheetObject1.DataInsert(-1);
                break;
			case "btn_del": 
				rowRemove(sheetObject1);				
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
    //doActionIBSheet(sheetObjects[0], document.form , SEARCH01);
   // document.form.lu_tp_cd.focus();
}
/**
 * Removing IBSheet Row <br>
 * param : sheetObj    IBSheet Object
 **/
function rowRemove(sheetObj) {
	ComRowHideDelete(sheetObj, "chk");
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
	//axon_event.addListenerFormat('beforedeactivate', 'obj_blur'    , formObj); 	//- handling code when OnBeforeDeactivate(blur) event
	//axon_event.addListenerFormat('beforeactivate'  , 'obj_focus'   , formObj);            //- handling code when OnBeforeActivate event in case of existing dataformat property
    //axon_event.addListenerFormat('keyup'           , 'form_keyup'  , formObj);
    //axon_event.addListenerForm('keypress'          , 'obj_keypress', formObj); 
	}
//handling Axon event 2
/*function obj_blur(){
    ComChkObjValid(event.srcElement);
	var src=ComGetEvent("name")
	}
function obj_focus(){
    ComClearSeparator(event.srcElement);
	}
function obj_keypress(){
	var src=ComGetEvent("name")
	}
function form_keyup(){
	ComKeyEnter('lengthnextfocus');
	}
function obj_onclick(){
	var src=ComGetEvent("name")
	}*/
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
		      var HeadTitle1="|Del|Year Month|Division|Closing Status";
		      var headCount=ComCountHeadTitle(HeadTitle1);

		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

		      var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);

		      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		             {Type:"DummyCheck", Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
		             {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",    ColMerge:1,   SaveName:"eff_yrmon",    KeyField:1,   CalcLogic:"",   Format:"Ym",          PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"prd_appl_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Combo",     Hidden:0, Width:100,  Align:"Left",    ColMerge:1,   SaveName:"prd_sts_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		       
		      	InitColumns(cols);
		        //SetSheetHeight(360);
		      	resizeSheet();
		      	SetEditable(1);
		  		SetColProperty("prd_appl_cd", {ComboText:"AP|AR", ComboCode:"AP|AR"} );
		  		SetColProperty("prd_sts_cd", {ComboText:"Open|Closing", ComboCode:"O|C"} );
		}
   break;
	}
}
// handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {  
	//if (!validateForm(sheetObj, formObj, sAction))		
	//	return;
	switch (sAction) {		
		case IBSEARCH: //retrieve
			formObj.f_cmd.value=SEARCH01;		
 			var sXml=sheetObj.GetSearchData("STM_SCO_0010GS.do", FormQueryString(formObj));
			sheetObj.LoadSearchData(sXml,{Sync:1} );
			break;			
		case IBSAVE:        //save				
			if (!validateForm(sheetObj,formObj,sAction)) {		 				
				return false;
			}
            var sParamSheet1=sheetObjects[0].GetSaveString(true);
			if (sheetObjects[0].IsDataModified()&& sParamSheet1 == "") {
			    return;
			}
 			formObj.f_cmd.value=MULTI;	
 			var sParam=FormQueryString(formObj);
	 		if( sParamSheet1 != "" ){
				sParam += "&" + ComPriSetPrifix(sParamSheet1, "sheet1_");
			}
  			var sXml=sheetObj.GetSaveData("STM_SCO_0010GS.do", sParam);
  			/*
 			//var currentRowStatus = sheetObjects[1].RowStatus(sheetObjects[1].SelectRow);
 			var sav=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
  			sheetObj.LoadSaveData(sXml);
            */
			
			sheetObj.LoadSaveData(sXml);
			ComOpenWait(false);
			var result=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
            if(result != "F"){
            	ComShowCodeMessage("COM130102", "Data"); 
    			doActionIBSheet(sheetObj, document.form, IBSEARCH);
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
		case IBSEARCH: //retrieve
			break;
		case IBINSERT: //insert	
			break;
		case IBSAVE:			
			for (var i=sheetObj.HeaderRows(); i<= sheetObj.LastRow(); i++) {
				if (sheetObj.GetCellValue(i, "ibflag") == "I") {
					//alert(sheetObj.CellValue(i, "eff_yrmon"));
					formObj.f_cmd.value=SEARCH01;
 					var sXml=sheetObj.GetSearchData("STM_SCO_0010GS.do?eff_yr_mon="+sheetObj.GetCellValue(i, "eff_yrmon")+"&prd_appl_cd="+sheetObj.GetCellValue(i, "prd_appl_cd"), FormQueryString(formObj));
					var sGetTotalRows = ComGetTotalRows(sXml);
					if (sGetTotalRows != 0) {
						ComShowCodeMessage('SCO00004', 'Check Period, Appl!', 'Period, Apple should not be duplicated!');
						return false;
					}
				}
			}
			break;
		case IBDELETE:
			if (ComPriSheetCheckedRows(sheetObj, "chk") == "") {
				ComShowCodeMessage('SCO00004', 'Select', 'checkbox');
				return false;	  
			}
			break;	
	}
	return true;
}
/**
 * calling function when occurring OnClick Event <br>
 * showing memopad when clicking desc cell (MemoPad editable)<br>
 */ 
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	var sName=sheetObj.ColSaveName(Col);
	var formObj=document.form;
}
function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
	//if combined data
	for (var i=sheetObj.HeaderRows(); i<= sheetObj.LastRow(); i++){
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
	var iCheckRow=sheetObj.FindCheckedRow(selChk).slice(0, -1);
	if(iCheckRow != "") {
     chkArr=iCheckRow.split("|");
	}
 return chkArr;
}
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
	for (var i=1; i < arrStr.length; i++ ) {
		cmbObj.InsertItem(i-1, arrStr[i], arrStr[i]);			 
	}
	cmbObj.SetDropHeight(190);
}  

function resizeSheet(){
	ComResizeSheet(sheetObjects[0]);
}