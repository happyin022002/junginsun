/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_4026.js
*@FileTitle  : Location Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/



/*
 * 
 * 
 * 
 * 공통팝업입니다.
 * 수정하지 마세요.
 * Parent 파일을 수정하여 사용하시기 바랍니다.
 * 2014.09.02 김은진
 * 
 * 
 * 
 * 
 */


// global variables
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
//Event handler processing by button click event */
document.onclick=processButtonClick;

//다음의 화면들에서 호출됨
//ESM_PRI_0001_02
//ESM_PRI_0001_04
//ESM_PRI_0001_05
//ESM_PRI_0003_01
//ESM_PRI_0003_02
//ESM_PRI_0003_04
//ESM_PRI_0003_05
//ESM_PRI_0003_06
//ESM_PRI_0068
//ESM_PRI_0110
//ESM_PRI_0027
//ESM_PRI_0031
//ESM_PRI_0032
//ESM_PRI_0033
//ESM_PRI_0100
//ESM_PRI_0101
//ESM_PRI_0102


/**
 * Event handler processing by button name  <br>
 */
function processButtonClick() {
	//Location
	var sheetObject1=sheetObjects[0];
	//Group Location
	var sheetObject2=sheetObjects[1];
	//State
	var sheetObject3=sheetObjects[2];
	//Region
	var sheetObject4=sheetObjects[3];
	//Country
	var sheetObject5=sheetObjects[4];
	//Group Location
	var comboObject1=comboObjects[0];
	//State
	var comboObject2=comboObjects[1];
	//Region
	var comboObject3=comboObjects[2];
	/** **************************************************** */
	var formObject=document.form;
	var sheetObj;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		
		var radioType=ComGetObjValue(formObject.radio_type);
		switch (srcName) {
		case "btn_Retrieve":
			if(radioType == "1") {
				sheetObj = sheetObject1;
    		} else if(radioType == "2") {
    			sheetObj = sheetObject2;
    		} else if(radioType == "3") {
    			sheetObj = sheetObject3;
    		} else if(radioType == "4") {
    			sheetObj = sheetObject4;
    		} else if(radioType == "5") {
    			sheetObj = sheetObject5;
    		}
			if (validateForm(sheetObj,document.form,IBSEARCH)) {
				doActionIBSheet(sheetObj,document.form,IBSEARCH);
			}
			break;
		case "btn_New":
			if(radioType == "1") {
				ComClearManyObjects(formObject.loc_cd, formObject.loc_nm);
				sheetObj = sheetObject1;
    		} else if(radioType == "2") {
    			ComClearManyObjects(formObject.combo_grp_loc_nm);
    			sheetObj = sheetObject2;
    		} else if(radioType == "3") {
    			ComClearManyObjects(formObject.ste_cd, formObject.ste_nm, formObject.combo_cnt_nm);
    			sheetObj = sheetObject3;
    		} else if(radioType == "4") {
    			ComClearManyObjects(formObject.rgn_cd, formObject.rgn_nm, formObject.combo2_cnt_nm);
    			sheetObj = sheetObject4;
    		} else if(radioType == "5") {
    			ComClearManyObjects(formObject.cnt_cd, formObject.cnt_nm);
    			sheetObj = sheetObject5;
    		}
			sheetObj.RemoveAll();
			break;
		/** Radio Tab [ Country ] (E) * */
		case "btn_OK":
			if(formObject.multi_yn.value != "Y") {
				returnButtonSheetData(formObject);		
			} else {
				returnButtonSheetDataMulti(formObject);	
			}
			break;
		case "btn_Close":
			ComClosePopup(); 
			break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e.message);
		}
	}
}

/**
 * registering IBSheet Object as list <br>
 * adding process for list in case of needing batch processing with other items  <br>
 * defining list on the top of source <br>
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}

/**
* registering IBCombo Object as list <br>
* adding process for list in case of needing batch processing with other items  <br>
* defining list on the top of source <br>
*/
function setComboObject(combo_obj){
	comboObjects[comboCnt++]=combo_obj;
}

/**
* resizing current screen
*/
function reSize(weight, height)
{
    dialogWidth=getWidth(weight) + 'px';
    dialogHeight=getHeight(height) + 'px';
}

 /**
  * Initializing and setting Sheet basics <br>
  * Setting body tag's onLoad event handler <br>
  * Adding pre-handling function after loading screen on the browser  <br>
  */
function loadPage() {
	
	if (!opener) opener = window.dialogArguments;
	if (!opener) opener = window.opener;
	if (!opener) opener = parent;
	 
	var formObj=document.form;
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		if(formObj.multi_yn.value != "Y") {
			//sheetObjects[i].InitDataProperty2(0, 1, dtHidden, "width=40; data-align=daCenter");
	    }
		ComEndConfigSheet(sheetObjects[i]);
	}
	//initializing IBMultiCombo
    for(var k=0; k < comboObjects.length; k++){
        initCombo(comboObjects[k], k + 1);
    }
    
    var beforeRadioCheck_loc_def_cd = document.form.loc_def_cd.value;
    var beforeRadioCheck_loc_def_nm = document.form.loc_def_nm.value;
    var beforeRadioCheck_loc_cd = document.form.loc_cd.value;
    
    initControl();
    initRadioCheck();
    

    
}

/**
 * setting sheet initial values and header <br>
 * adding case as numbers of counting sheets <br>
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	var sheetid=sheetObj.id;
	switch (sheetid) {
	case "sheet1":
		with(sheetObj){
			var HeadTitle="|Sel.|Seq.|Code|Description|State|Country|UNLoc|sconti_nm";
			var headCount=ComCountHeadTitle(HeadTitle);

			SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

			var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			var headers = [ { Text:HeadTitle, Align:"Center"} ];
			InitHeaders(headers, info);

			var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Status" },
			             {Type:"DummyCheck", Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"chk" },
			             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"loc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:230,  Align:"Left",    ColMerge:0,   SaveName:"loc_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:20 },
			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"ste_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cnt_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"un_loc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             //{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"sconti_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             //{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rgn_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"sconti_nm" } ];
       
			InitColumns(cols);
			SetEditable(1);
			SetEditableColorDiff(0);
			SetSheetHeight(120);
		}
		break;
	case "sheet2":
	    with(sheetObj){
			var HeadTitle="|Sel.|Seq.|Code|Description|State|Country|UNLoc|";
			var headCount=ComCountHeadTitle(HeadTitle);

			SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

			var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			var headers = [ { Text:HeadTitle, Align:"Center"} ];
			InitHeaders(headers, info);

			var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Status" },
			             {Type:"DummyCheck", Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
			             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"loc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:0,   SaveName:"loc_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:20 },
			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"ste_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cnt_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"un_loc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             //{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"sconti_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             //{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rgn_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"zip_cd" } ];
       
			InitColumns(cols);

			SetEditable(1);
			SetEditableColorDiff(0);
			SetVisible(false);
			SetSheetHeight(120);
		}
	    break;
	case "sheet3":
	    with(sheetObj){
			var HeadTitle="|Sel.|Seq.|Country|Code|Description|Continent|S-Conti.";
			var headCount=ComCountHeadTitle(HeadTitle);

			SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

			var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			var headers = [ { Text:HeadTitle, Align:"Center"} ];
			InitHeaders(headers, info);

			var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Status" },
			             {Type:"DummyCheck", Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
			             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"combo_cnt_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ste_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:0,   SaveName:"ste_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:20 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"conti_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"sconti_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
       
			InitColumns(cols);

			SetEditable(1);
			SetEditableColorDiff(0);
			SetVisible(false);
			SetSheetHeight(100);
        }
	    break;
	case "sheet4":
	    with(sheetObj){
			var HeadTitle="|Sel.|Seq.|Code|Description|Continent|S-Conti.";
			var headCount=ComCountHeadTitle(HeadTitle);

			SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

			var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			var headers = [ { Text:HeadTitle, Align:"Center"} ];
			InitHeaders(headers, info);

			var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Status" },
			             {Type:"DummyCheck", Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
			             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rgn_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:320,  Align:"Left",    ColMerge:0,   SaveName:"rgn_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:20 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"conti_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"sconti_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
       
			InitColumns(cols);

			SetEditable(1);
			SetEditableColorDiff(0);
			SetVisible(false);
			SetSheetHeight(100);
		}
	    break;
	case "sheet5":
	    with(sheetObj){
			var HeadTitle="|Sel.|Seq.|Code|Description|Continent|S-Conti.";
			var headCount=ComCountHeadTitle(HeadTitle);

			SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

			var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			var headers = [ { Text:HeadTitle, Align:"Center"} ];
			InitHeaders(headers, info);

			var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Status" },
			             {Type:"DummyCheck", Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
			             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cnt_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:400,  Align:"Left",    ColMerge:0,   SaveName:"cnt_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:20 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"conti_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"sconti_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
       
			InitColumns(cols);

			SetEditable(1);
			SetEditableColorDiff(0);
			SetVisible(false);
			SetSheetHeight(120);
		}
	    break;
	case "sheet6":
	    with(sheetObj){
			var HeadTitle1="|Sel.|Seq.|IAA REGION|IAA REGION|LOCATION|LOCATION";
			var HeadTitle2="|Sel.|Seq.|Code|Description|Code|Description";

			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

			var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"},
                  { Text:HeadTitle2, Align:"Center"} ];
			InitHeaders(headers, info);

			var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Status" },
			             {Type:"DummyCheck", Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
			             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cnt_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"cnt_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:20 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"conti_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:"sconti_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
       
			InitColumns(cols);

			SetEditable(1);
			SetEditableColorDiff(0);
			SetVisible(false);
			SetSheetHeight(123);
		}
	    break;
	}
}

/**
 * initializing IBMultiCombo <br>
 */
function initCombo(comboObj, comboNo) {
    switch(comboObj.options.id) {
        case "combo_cnt_cd":
            var i=0;
            with(comboObj) {
            	//BackColor = "white";
            	SetDropHeight(140);
            	SetMultiSelect(0);
            	SetMaxSelect(1);
            	SetUseAutoComplete(1);
                SetMaxLength(2);
                ValidChar(2);
            }
            break;
        case "combo2_cnt_cd":
            var i=0;
            with(comboObj) {
            	//BackColor = "white";
            	SetDropHeight(140);
            	SetMultiSelect(0);
            	SetMaxSelect(1);
            	SetUseAutoComplete(1);
                SetMaxLength(2);
                ValidChar(2);
            }
            break;
        case "combo_grp_loc_cd":
            var i=0;
            with(comboObj) {
            	//BackColor = "cyan";
            	SetDropHeight(140);
            	SetMultiSelect(0);
            	SetMaxSelect(1);
            	SetUseAutoComplete(1);
                SetMaxLength(4);
                ValidChar(2);
            }
            break;
    }
}

/**
* handling radio button Axon event <br>
*/
function initControl() {
//    axon_event.addListener ('keypress', 'engnum_keypress', 'loc_cd','ste_cd','cnt_cd','rgn_cd');
    axon_event.addListenerForm ('click', 'obj_OnClick', document.form);
//    axon_event.addListener ('keyup', "getKeyEnter('LengthNextFocus')", document.form);
//    axon_event.addListener ('keydown', 'getKeyEnter', 'form');
    axon_event.addListenerFormat ('keydown', 'obj_onKeydown', document.form);  
    axon_event.addListener('keydown',  'ComKeyEnter', 'form');
}

/**
 * handling OnKeyPress event <br>
 */
//function engnum_keypress() {
//    ComKeyOnlyAlphabet('uppernum');
//}

 /**
 * HTML tag (Object)'s onKeyDown event can calling this function, when pressing Enter key handling automatic transaction <br>
 * <br>
 * sFlag = not setting : handling same as sFlag="Search"<br>
 * sFlag = "Search"          : when clicking enter key, handling like clicking retrieve button. calling from OnKeyDown !<br>
 * sFlag = "NextFocus"       : when clicking enter key, changing focus like clicking tab key. calling from OnKeyDown !<br>
 * sFlag = "LengthNextFocus" : when inputed maxlength, changing next focus automatically. when clicking enter key, changing focus like clicking tab key. calling from OnKeyDown !<br>
 * sFlag = Function naming string  : getting Function naming string and clicking enter key, calling relevant function. calling from OnKeyDown !<br>
 * sFlag = "LengthNextFocus" should be called from OnKeyUp event, all remainders should be called from OnKeyDown event<br>
 */
//function getKeyEnter(sFlag)
//{
//	 var formObj=document.form;
//	 var radioType=ComGetObjValue(formObj.radio_type);
//    try {
//    	var keyValue=null;
//    	if(event == undefined || event == null) {
//    		keyValue=13;
//    	}else {
//    		keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
//    	}
//       if (sFlag==undefined || sFlag==null || sFlag.constructor!=String || sFlag.trim() == "") sFlag="search";
//       switch(sFlag.toLowerCase()) {
//        	case "search" :
//        		if (keyValue != 13) return;
//        		var obj=document.getElementById("btn_Retrieve");
//        		if (obj==null) obj=document.getElementById("btn_retrieve");
//        		if (obj) obj.fireEvent("onclick");
//        		break;
//        	case "nextfocus":
//        		if (keyValue == 13) event.keyCode=9;
//        		break;
//        	case "lengthnextfocus":
//		        var iMaxLen=event.srcElement.getAttribute("maxLength");
//		        var sValue=event.srcElement.getAttribute("value");
//		        var bFocusProcess=false;
//		        if (keyValue == 13)  {
//		        	if (event.srcElement.classid != CLSID_IBSHEET) {
//			        	bFocusProcess=true;
//			        }
//		        } else if(iMaxLen!=null && sValue!=null) {
//			        //ComDebug(iMaxLen+"=="+sValue.lengthByte());
//		            if(iMaxLen==sValue.lengthByte()){
//		                if (!((keyValue>=8   && keyValue<=40)  ||  
//		                      (keyValue>=45  && keyValue<=46)  || 
//		                      (keyValue>=91  && keyValue<=93)  || 
//		                      (keyValue>=112 && keyValue<=123) || 
//		                      (keyValue>=144 && keyValue<=145) )) {//NumLock,ScrollLock
//				            bFocusProcess=true;
//		                }
//		            } 
//		        } 
//	            if (bFocusProcess)  ComSetNextFocus();
//        	default :
//        	    if (keyValue==13 && ComFuncCheck(sFlag)) ComFunc();
//        }
//    } catch(err) { ComFuncErrMsg(err.message); }
//}

/**
 * calling function when occurring OnChange Event <br>
 * when selecting multi comboBox, showing description <br>
 */  
//function combo_cnt_cd_OnChange(comboObj, code, text) {
function combo_cnt_cd_OnChange(comboObj, OldIndex, OldText, OldCode, NewIndex, text, code) {
	var formObj=document.form;
	if(code != "") {
		comboObj.SetSelectCode(code);
		var arrText=text.split("|");
		if (arrText != null && arrText.length > 1) {
			formObj.combo_cnt_nm.value=arrText[1];
			formObj.ste_cd.focus();
		} else {
			formObj.combo_cnt_nm.value=comboObj.GetText(code,1);
		}
	} else {
		formObj.combo_cnt_nm.value="";
	}
}

 /**
  * calling event when occurring OnFocus event <br>
  * setting combo code with blank <br>
  */  
//function combo_cnt_cd_OnFocus(comboObj) {
//	comboObj.SetSelectCode(-1);
//}

/**
* calling function when occurring OnChange Event <br>
* when selecting multi comboBox, showing description <br>
*/  
//function combo2_cnt_cd_OnChange(comboObj, code, text) {
function combo2_cnt_cd_OnChange(comboObj, OldIndex, OldText, OldCode, NewIndex, text, code) {
	var formObj=document.form;
	if(code != "") {	
		comboObj.SetSelectCode(code);
		var arrText=text.split("|");
		if (arrText != null && arrText.length > 1) {
			formObj.combo2_cnt_nm.value=arrText[1];
			formObj.rgn_cd.focus();
		} else {
			formObj.combo2_cnt_nm.value=comboObj.GetText(code,1);
		}
	} else {
		formObj.combo2_cnt_nm.value="";
	}
}

/**
* calling event when occurring OnFocus event <br>
* setting combo code with blank <br>
*/ 
//function combo2_cnt_cd_OnFocus(comboObj) {
//	comboObj.SetSelectCode(-1);
//}

/**
* calling function when occurring OnChange Event <br>
* when selecting multi comboBox, showing description <br>
*/  
//function combo_grp_loc_cd_OnChange(comboObj, code, text) {
function combo_grp_loc_cd_OnChange(comboObj, OldIndex, OldText, OldCode, NewIndex, text, code) {
	var formObj=document.form;
	try{	
		if(formObj.group_cmd.value == PRI_CMPB) {
			var arrKey=code.split("|");
			if (arrKey != null && arrKey.length > 1) {
				code=arrKey[0];
				formObj.cre_ofc_cd.value=arrKey[1];
				formObj.gline_seq.value=arrKey[2];
			}
		}
		if(code != "") {			
			comboObj.SetSelectCode(code);
			var arrText=text.split("|");
			if (arrText != null && arrText.length > 1) {
				formObj.combo_grp_loc_nm.value=arrText[1];
				formObj.grp_loc_seq.value=code;
			} else {
				formObj.combo_grp_loc_nm.value=combo_grp_loc_cd.GetText(code,1);	
				formObj.grp_loc_seq.value=code;
			}
			if (validateForm(sheetObjects[1],document.form,IBSEARCH)) {
		 		doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
		 		formObj.combo_grp_loc_cd.focus();
 			}
		} else {
			formObj.combo_grp_loc_nm.value="";
		}
	}catch(e){}	
}

/**
* handling OnClick event
*/ 
function obj_OnClick(sheetObj,Row, Col, Value) {
	var formObj=document.form;
	var objs=document.form.group_cmd.value;	 
	
	if (ComGetEvent("name") != "radio_type") return;

	if(event.srcElement.value == "1") {
		ComSetObjValue(formObj.loc_cd,"");
		ComSetObjValue(formObj.loc_nm,"");
		sheetObjects[0].RemoveAll();
		document.getElementById("radioLayer1").style.display='inline';
		document.getElementById("radioLayer2").style.display='none';
		document.getElementById("radioLayer3").style.display='none';
		document.getElementById("radioLayer4").style.display='none';
		document.getElementById("radioLayer5").style.display='none';
		
		//document.getElementById("sheetLayout1").style.display='inline';
		//document.getElementById("sheetLayout2").style.display='none';
		//document.getElementById("sheetLayout3").style.display='none';
		//document.getElementById("sheetLayout4").style.display='none';
		//document.getElementById("sheetLayout5").style.display='none';
		
		sheetObjects[0].SetVisible(true);
		sheetObjects[1].SetVisible(false);
		sheetObjects[2].SetVisible(false);
		sheetObjects[3].SetVisible(false);
		sheetObjects[4].SetVisible(false);
	} else if(event.srcElement.value == "2") {
		ComSetObjValue(formObj.combo_grp_loc_cd,"");
		ComSetObjValue(formObj.combo_grp_loc_nm,"");
		sheetObjects[1].RemoveAll();
		document.getElementById("radioLayer1").style.display='none';
		document.getElementById("radioLayer2").style.display='inline';
		document.getElementById("radioLayer3").style.display='none';
		document.getElementById("radioLayer4").style.display='none';
		document.getElementById("radioLayer5").style.display='none';
		
		//document.getElementById("sheetLayout1").style.display='none';
		//document.getElementById("sheetLayout2").style.display='inline';
		//document.getElementById("sheetLayout3").style.display='none';
		//document.getElementById("sheetLayout4").style.display='none';
		//document.getElementById("sheetLayout5").style.display='none';
		
		if(objs == PRI_SP_SCP){
			document.form.f_cmd.value=SEARCH09;
			doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC12);
		} else if(objs == PRI_RG){
			document.form.f_cmd.value=SEARCH10;
			doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC12);
		} else if(objs == PRI_SG){
			document.form.f_cmd.value=SEARCH11;
			doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC12);
		} else if(objs == PRI_RP_SCP){
			document.form.f_cmd.value=SEARCH12;
			doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC12);
		} else if(objs == PRI_SCG){
			document.form.f_cmd.value=SEARCH13;
			doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC12);
		} else if(objs == PRI_CMPB){
			document.form.f_cmd.value=SEARCH19;
			doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC12);
		} else if(objs == PRI_SQ){
			document.form.f_cmd.value=SEARCHLIST01;
			doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC12);
		} else if(objs == PRI_RQ){
			document.form.f_cmd.value=SEARCHLIST03;
			doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC12);
		}
		sheetObjects[0].SetVisible(false);
		sheetObjects[1].SetVisible(true);
		sheetObjects[2].SetVisible(false);
		sheetObjects[3].SetVisible(false);
		sheetObjects[4].SetVisible(false);
	} else if(event.srcElement.value == "3") {
		ComSetObjValue(formObj.combo_cnt_cd,"");
		ComSetObjValue(formObj.combo_cnt_nm,"");
		ComSetObjValue(formObj.ste_cd,"");
		ComSetObjValue(formObj.ste_nm,"");
		sheetObjects[2].RemoveAll();
		document.getElementById("radioLayer1").style.display='none';
		document.getElementById("radioLayer2").style.display='none';
		document.getElementById("radioLayer3").style.display='inline';
		document.getElementById("radioLayer4").style.display='none';
		document.getElementById("radioLayer5").style.display='none';
		
		//document.getElementById("sheetLayout1").style.display='none';
		//document.getElementById("sheetLayout2").style.display='none';
		//document.getElementById("sheetLayout3").style.display='inline';
		//document.getElementById("sheetLayout4").style.display='none';
		//document.getElementById("sheetLayout5").style.display='none';
		
		sheetObjects[0].SetVisible(false);
		sheetObjects[1].SetVisible(false);
		sheetObjects[2].SetVisible(true);
		sheetObjects[3].SetVisible(false);
		sheetObjects[4].SetVisible(false);
		doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC10);
	} else if(event.srcElement.value == "4") {		
		ComSetObjValue(formObj.combo2_cnt_cd,"");
		ComSetObjValue(formObj.combo2_cnt_nm,"");
		ComSetObjValue(formObj.rgn_cd,"");
		ComSetObjValue(formObj.rgn_nm,"");
		sheetObjects[3].RemoveAll();
		document.getElementById("radioLayer1").style.display='none';
		document.getElementById("radioLayer2").style.display='none';
		document.getElementById("radioLayer3").style.display='none';
		document.getElementById("radioLayer4").style.display='inline';
		document.getElementById("radioLayer5").style.display='none';
		
		//document.getElementById("sheetLayout1").style.display='none';
		//document.getElementById("sheetLayout2").style.display='none';
		//document.getElementById("sheetLayout3").style.display='none';
		//document.getElementById("sheetLayout4").style.display='inline';
		//document.getElementById("sheetLayout5").style.display='none';
		
		doActionIBSheet(sheetObjects[3], document.form, IBSEARCH_ASYNC11);
		sheetObjects[0].SetVisible(false);
		sheetObjects[1].SetVisible(false);
		sheetObjects[2].SetVisible(false);
		sheetObjects[3].SetVisible(true);
		sheetObjects[4].SetVisible(false);
	} else if(event.srcElement.value == "5") {
		ComSetObjValue(formObj.cnt_cd,"");
		ComSetObjValue(formObj.cnt_nm,"");
		sheetObjects[4].RemoveAll();
		document.getElementById("radioLayer1").style.display='none';
		document.getElementById("radioLayer2").style.display='none';
		document.getElementById("radioLayer3").style.display='none';
		document.getElementById("radioLayer4").style.display='none';
		document.getElementById("radioLayer5").style.display='inline';
//		
//		document.getElementById("sheetLayout1").style.display='none';
//		document.getElementById("sheetLayout2").style.display='none';
//		document.getElementById("sheetLayout3").style.display='none';
//		document.getElementById("sheetLayout4").style.display='none';
//		document.getElementById("sheetLayout5").style.display='inline';
//		
		sheetObjects[0].SetVisible(false);
		sheetObjects[1].SetVisible(false);
		sheetObjects[2].SetVisible(false);
		sheetObjects[3].SetVisible(false);
		sheetObjects[4].SetVisible(true);
	}
}

 /**
  * Handling sheet process <br>
  */
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {	
		case IBSEARCH_ASYNC10: // when screen loading Service Scope retrieve
			formObj.f_cmd.value=SEARCH07;

			var sXml=sheetObj.GetSearchData("ESM_PRI_4026GS.do", FormQueryString(formObj));
			ComPriXml2ComboItem(sXml, combo_cnt_cd, "cd", "cd|nm");
			break;
		case IBSEARCH_ASYNC11: // when screen loading Service Scope retrieve
			formObj.f_cmd.value=SEARCH08;

			var sXml=sheetObj.GetSearchData("ESM_PRI_4026GS.do", FormQueryString(formObj));
			ComPriXml2ComboItem(sXml, combo2_cnt_cd, "cd", "cd|nm");
			break;	
		case IBSEARCH_ASYNC12: // when screen loading Service Scope retrieve

			var sXml=sheetObj.GetSearchData("ESM_PRI_4026GS.do", FormQueryString(formObj));
			ComPriXml2ComboItem(sXml, combo_grp_loc_cd, "grp_loc_seq", "cd|nm");
			break;	
		case IBSEARCH: // retrieve
			if (validateForm(sheetObj, formObj, sAction)) {
				if (sheetObj.id == "sheet1" && formObj.radio_type[0].checked) {
					formObj.f_cmd.value=SEARCH01;

					sheetObj.DoSearch("ESM_PRI_4026GS.do", FormQueryString(formObj) );
				} else if (sheetObj.id == "sheet2" && formObj.radio_type[1].checked) {
					// GROUP LOCATION				
					if(formObj.group_cmd.value == PRI_SP_SCP){
						formObj.f_cmd.value=SEARCH14;
						sheetObj.DoSearch("ESM_PRI_4026GS.do", FormQueryString(formObj) );
					} else if(formObj.group_cmd.value == PRI_RG){
						formObj.f_cmd.value=SEARCH15;
						sheetObj.DoSearch("ESM_PRI_4026GS.do", FormQueryString(formObj) );
					} else if(formObj.group_cmd.value == PRI_SG){
						formObj.f_cmd.value=SEARCH16;
						sheetObj.DoSearch("ESM_PRI_4026GS.do", FormQueryString(formObj) );
					} else if(formObj.group_cmd.value == PRI_RP_SCP){
						formObj.f_cmd.value=SEARCH17;
						sheetObj.DoSearch("ESM_PRI_4026GS.do", FormQueryString(formObj) );
					} else if(formObj.group_cmd.value == PRI_SCG){
						formObj.f_cmd.value=SEARCH18;
						sheetObj.DoSearch("ESM_PRI_4026GS.do", FormQueryString(formObj) );
					} else if(formObj.group_cmd.value == PRI_CMPB){
						formObj.f_cmd.value=SEARCH20;
						sheetObj.DoSearch("ESM_PRI_4026GS.do", FormQueryString(formObj) );
					} else if(formObj.group_cmd.value == PRI_SQ){
						formObj.f_cmd.value=SEARCHLIST02;
						sheetObj.DoSearch("ESM_PRI_4026GS.do", FormQueryString(formObj) );
					} else if(formObj.group_cmd.value == PRI_RQ){
						formObj.f_cmd.value=SEARCHLIST04;
						sheetObj.DoSearch("ESM_PRI_4026GS.do", FormQueryString(formObj) );
					}
				} else if (sheetObj.id == "sheet3" && formObj.radio_type[2].checked) {
					formObj.f_cmd.value=SEARCH03;
					sheetObj.DoSearch("ESM_PRI_4026GS.do", FormQueryString(formObj) );
				} else if (sheetObj.id == "sheet4" && formObj.radio_type[3].checked) {
					formObj.f_cmd.value=SEARCH04;
					sheetObj.DoSearch("ESM_PRI_4026GS.do", FormQueryString(formObj) );
				} else if (sheetObj.id == "sheet5" && formObj.radio_type[4].checked) {
					formObj.f_cmd.value=SEARCH05;
					sheetObj.DoSearch("ESM_PRI_4026GS.do", FormQueryString(formObj) );
				} 
			}
			break;
	}
}

/**
 * checking validation process of inputed form data <br>
 */
function validateForm(sheetObj, formObj, sAction) {
	if (sheetObj.id == "sheet1" && formObj.radio_type[0].checked) {
		if (formObj.loc_cd.value == "" && formObj.loc_nm.value =="") {
			ComShowCodeMessage("PRI00117", "2");
			formObj.loc_cd.focus();
			return false;
		} else if ( formObj.loc_cd.value != "" && formObj.loc_cd.value.length < 2) {	
			ComShowCodeMessage("PRI00117", "2");
			formObj.loc_cd.focus();
			return false;
		} else {
			if(formObj.loc_nm.value != "" && formObj.loc_nm.value.length < 3 ) {
				ComShowCodeMessage("PRI00117", "3");
				formObj.loc_nm.focus();
				return false;
			}
		}	
	} else if (sheetObj.id == "sheet2" && formObj.radio_type[1].checked) {
		if(comboObjects[0].GetSelectCode()== "" ) {
			ComShowCodeMessage("PRI00316","Code");
			return false;
		}
	} else if (sheetObj.id == "sheet3" && formObj.radio_type[2].checked) {		
		if(comboObjects[1].GetSelectCode()== "" ) {
			ComShowCodeMessage("PRI00316","Country Code");
			return false;
		}
		if ( !ComIsEmpty(formObj.ste_nm) &&  (formObj.ste_nm.value.length < 3 ||  formObj.ste_nm.value.length > 30)) {	
			ComShowCodeMessage("PRI00117", "3");
			return false;
		}
	} else if (sheetObj.id == "sheet5" && formObj.radio_type[4].checked) {
		if ( !ComIsEmpty(formObj.cnt_cd) && formObj.cnt_cd.value.length < 2 ) {	
			ComShowCodeMessage("PRI00117", "2");
			return false;
		} else if ( !ComIsEmpty(formObj.cnt_nm) && (formObj.cnt_nm.value.length < 3 || formObj.cnt_nm.value.length > 30)) {
			ComShowCodeMessage("PRI00117", "3");
			return false;
		}
	} else if (sheetObj.id == "sheet4" && formObj.radio_type[3].checked) {
		if(comboObjects[2].GetSelectCode()== "" ) {
			ComShowCodeMessage("PRI00316","Country Code");
			return false;
		}
		if ( !ComIsEmpty(formObj.rgn_cd) &&  (formObj.rgn_cd.value.length < 2 || formObj.rgn_cd.value.length > 3)) {	
			ComShowCodeMessage("PRI00117","2");
			return false;
		} else if ( !ComIsEmpty(formObj.rgn_nm) &&  (formObj.rgn_nm.value.length < 3 ||  formObj.rgn_nm.value.length > 30)) {	
			ComShowCodeMessage("PRI00117", "3");
			return false;
		}
	}
	return true;
}

 /**
  * returning value to opener<br>
  */
function sheet1_OnDblClick(sheetObj, Row, Col) {
	var formObj=document.form;
	var multiYn=formObj.multi_yn.value;
	var array=new Array(); 
	var obj=new Object();
    try{    	
		obj.cd=sheetObj.GetCellValue(Row, "loc_cd");
		obj.nm=sheetObj.GetCellValue(Row, "loc_nm");
		obj.sconti_cd=sheetObj.GetCellValue(Row, "sconti_cd");
		obj.sconti_nm=sheetObj.GetCellValue(Row, "sconti_nm");
//		obj.zip_cd=sheetObj.GetCellValue(Row, "zip_cd");
    	obj.tp="L";
    	if(multiYn != "Y") {
    		ComPopUpReturnValue(obj);
    	} else {
    		array[0]=obj;
    		ComPopUpReturnValue(array);
    	}
    	return false;
    }catch(e){}    
}
 /**
  * returning value to opener<br>
  */
function sheet2_OnDblClick(sheetObj, Row, Col) {
	var formObj=document.form;
	var multiYn=formObj.multi_yn.value; 
    var array=new Array();   	
  	var obj=new Object(); 
	try{
		obj.cd=combo_grp_loc_cd.GetSelectText();
		obj.nm=formObj.combo_grp_loc_nm.value;
   	 	obj.tp="G";
   	 	if(multiYn != "Y") {
    		ComPopUpReturnValue(obj);
   	 	} else {
   	 		array[0]=obj;
    		ComPopUpReturnValue(array);
   	 	}
   	 	return false;
	}catch(e){}    
}

 /**
  * returning value to opener<br>
  */
function sheet3_OnDblClick(sheetObj, Row, Col) {
	var formObj=document.form;
	var multiYn=formObj.multi_yn.value;  
	var array=new Array();   
  	var obj=new Object(); 
	try{   
		obj.cd=sheetObj.GetCellValue(Row, "ste_cd");
		obj.nm=sheetObj.GetCellValue(Row, "ste_nm");
	   	obj.tp="T";
	   	obj.cnt_cd=sheetObj.GetCellValue(Row, "combo_cnt_cd");
    	if(multiYn != "Y") {
    		ComPopUpReturnValue(obj);
    	} else {
    		array[0]=obj;
    		ComPopUpReturnValue(array);
    	}
    	return false;
	}catch(e){}    
}

 /**
  * returning value to opener<br>
  */
function sheet4_OnDblClick(sheetObj, Row, Col) {
	var formObj=document.form;
	var multiYn=formObj.multi_yn.value;  
	var array=new Array();   
  	var obj=new Object(); 
	try{    
		obj.cd=sheetObj.GetCellValue(Row, "rgn_cd");
		obj.nm=sheetObj.GetCellValue(Row, "rgn_nm");
	   	obj.tp="R";
    	if(multiYn != "Y") {
    		ComPopUpReturnValue(obj);
    	} else {
    		array[0]=obj;
    		ComPopUpReturnValue(array);
    	}
    	return false;
	}catch(e){}    
}

/**
 * returning value to opener<br>
 */
function sheet5_OnDblClick(sheetObj, Row, Col) {
	var formObj=document.form;
	var multiYn=formObj.multi_yn.value;  
	var array=new Array();   
  	var obj=new Object(); 
	try{    	
		obj.cd=sheetObj.GetCellValue(Row, "cnt_cd");
		obj.nm=sheetObj.GetCellValue(Row, "cnt_nm");
	   	obj.tp="C";
    	if(multiYn != "Y") {
    		ComPopUpReturnValue(obj);
    	} else {
    		array[0]=obj;
    		ComPopUpReturnValue(array);
    	}
    	return false; 
	}catch(e){}    
}

 /**
 * initializing radio combo <br>
 * checking radio combo based on main value<br>
 */
function initRadioCheck(){
	var formObj=document.form;
	var prcCmdtTdCd=formObj.loc_tp_cd.value;
	var cmd=formObj.location_cmd.value;
	var arr=cmd.split("");
	var radio_cnt=formObj.radio_type.length;
	for(i=0; i<radio_cnt; i++) {
		formObj.radio_type[i].disabled=true;
	}
	var checkedRadioNo=0;
	for(i=0; i<arr.length; i++) {
		if(arr[i] == "L") {
			formObj.radio_type[0].disabled=false;
			if(arr[i] == prcCmdtTdCd){
				formObj.radio_type[0].checked=true;
				checkedRadioNo = 0;
			} else if (i==0){
				formObj.radio_type[0].checked=true;
				checkedRadioNo = 0;
			}
		} else if(arr[i] == "G") {
			formObj.radio_type[1].disabled=false;
			if(arr[i] == prcCmdtTdCd){
				formObj.radio_type[1].checked=true;
				checkedRadioNo = 1;
			} else if(i==0){
				formObj.radio_type[1].checked=true;
				checkedRadioNo = 1;
			}
		} else if(arr[i] == "T") {
			formObj.radio_type[2].disabled=false;
			if(arr[i] == prcCmdtTdCd){
				formObj.radio_type[2].checked=true;
				checkedRadioNo = 2;
			} else if(i==0){
				formObj.radio_type[2].checked=true;
				checkedRadioNo = 2;
			}
		} else if(arr[i] == "R") {
			formObj.radio_type[3].disabled=false;
			if(arr[i] == prcCmdtTdCd){
				formObj.radio_type[3].checked=true;
				checkedRadioNo = 3;
			} else if(i==0){
				formObj.radio_type[3].checked=true;
				checkedRadioNo = 3;
			}
		} else if(arr[i] == "C") {
			formObj.radio_type[4].disabled=false;
			if(arr[i] == prcCmdtTdCd){
				formObj.radio_type[4].checked=true;
				checkedRadioNo = 4;
			} else if(i==0){
				formObj.radio_type[4].checked=true;
				checkedRadioNo = 4;
			}
			//$(formObj.radio_type[4]).trigger("click");
		}
	}
	
	$(formObj.radio_type[checkedRadioNo])[0].click();

	if(prcCmdtTdCd != "") {
		showDivCheck(prcCmdtTdCd);
	} else {
		showDivCheck(arr[0]);
	}
}

 /**
 *  display first layer from location_cmd<br>
 */
function showDivCheck(locationCmd) {
	var objs=document.form.group_cmd.value;
	if(locationCmd == "L") {
		document.getElementById("radioLayer1").style.display='inline';
		document.getElementById("radioLayer2").style.display='none';
		document.getElementById("radioLayer3").style.display='none';
		document.getElementById("radioLayer4").style.display='none';
		document.getElementById("radioLayer5").style.display='none';
	} else if(locationCmd == "G") {
		document.getElementById("radioLayer1").style.display='none';
		document.getElementById("radioLayer2").style.display='inline';
		document.getElementById("radioLayer3").style.display='none';
		document.getElementById("radioLayer4").style.display='none';
		document.getElementById("radioLayer5").style.display='none';
		if(objs == PRI_SP_SCP){
			document.form.f_cmd.value=SEARCH09;
			doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC12);
		} else if(objs == PRI_RG){
			document.form.f_cmd.value=SEARCH10;
			doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC12);
		} else if(objs == PRI_SG){
			document.form.f_cmd.value=SEARCH11;
			doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC12);
		} else if(objs == PRI_RP_SCP){
			document.form.f_cmd.value=SEARCH12;
			doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC12);
		} else if(objs == PRI_SCG){
			document.form.f_cmd.value=SEARCH13;
			doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC12);
		} else if(objs == PRI_CMPB){
			document.form.f_cmd.value=SEARCH19;
			doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC12);
		} else if(objs == PRI_SQ){
			document.form.f_cmd.value=SEARCHLIST01;
			doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC12);
		} else if(objs == PRI_RQ){
			document.form.f_cmd.value=SEARCHLIST03;
			doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC12);
		}
	} else if(locationCmd == "T") {
		document.getElementById("radioLayer1").style.display='none';
		document.getElementById("radioLayer2").style.display='none';
		document.getElementById("radioLayer3").style.display='inline';
		document.getElementById("radioLayer4").style.display='none';
		document.getElementById("radioLayer5").style.display='none';
		doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC10);
	} else if(locationCmd == "R") {
		document.getElementById("radioLayer1").style.display='none';
		document.getElementById("radioLayer2").style.display='none';
		document.getElementById("radioLayer3").style.display='none';
		document.getElementById("radioLayer4").style.display='inline';
		document.getElementById("radioLayer5").style.display='none';
		doActionIBSheet(sheetObjects[3], document.form, IBSEARCH_ASYNC11);
	} else if(locationCmd == "C") {
		document.getElementById("radioLayer1").style.display='none';
		document.getElementById("radioLayer2").style.display='none';
		document.getElementById("radioLayer3").style.display='none';
		document.getElementById("radioLayer4").style.display='none';
		document.getElementById("radioLayer5").style.display='inline';
	}
}

 /**
 * returning selected sheet value to parent screen <br>
 */
 function returnButtonSheetData(formObj) {
	var obj=new Object();
	var Row=0;
	if(formObj.radio_type[0].checked){
		Row=sheetObjects[0].GetSelectRow();
		obj.cd=sheetObjects[0].GetCellValue(Row, "loc_cd");
		obj.nm=sheetObjects[0].GetCellValue(Row, "loc_nm");
		obj.sconti_cd=sheetObjects[0].GetCellValue(Row, "sconti_cd");
		obj.sconti_nm=sheetObjects[0].GetCellValue(Row, "sconti_nm");
	   	obj.tp="L";
	} else if(formObj.radio_type[1].checked){
		obj.cd=combo_grp_loc_cd.GetSelectText();
		obj.nm=formObj.combo_grp_loc_nm.value;
		obj.tp="G";
	} else if(formObj.radio_type[2].checked){
		Row=sheetObjects[2].GetSelectRow();
		obj.cd=sheetObjects[2].GetCellValue(Row, "ste_cd");
		obj.nm=sheetObjects[2].GetCellValue(Row, "ste_nm");
	   	obj.tp="T";
	   	obj.cnt_cd=sheetObjects[2].GetCellValue(Row, "combo_cnt_cd");
	} else if(formObj.radio_type[3].checked){
		Row=sheetObjects[3].GetSelectRow();
		obj.cd=sheetObjects[3].GetCellValue(Row, "rgn_cd");
		obj.nm=sheetObjects[3].GetCellValue(Row, "rgn_nm");
	   	obj.tp="R";
	} else if(formObj.radio_type[4].checked){
		Row=sheetObjects[4].GetSelectRow();
		obj.cd=sheetObjects[4].GetCellValue(Row, "cnt_cd");
		obj.nm=sheetObjects[4].GetCellValue(Row, "cnt_nm");
	   	obj.tp="C";
	}
	if ( formObj.radio_type[1].checked){
		if (formObj.combo_grp_loc_cd.text !=""){
			ComPopUpReturnValue(obj);
		}else{
			ComShowCodeMessage("PRI00310");
		}
	}else{
		if(Row > 0) {
    		ComPopUpReturnValue(obj);
		} else {
			ComShowCodeMessage("PRI00310");
		}
	}
 }
 
/**
 * returning selected sheet value to parent screen <br>
 */
 function returnButtonSheetDataMulti(formObj) {
	 	var array=new Array();
		var arrayCnt=0;
		if(formObj.radio_type[0].checked){
			var chkArr=ComPriSheetCheckedRows(sheetObjects[0], "chk");
			if(chkArr.length == 0){
				sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(),"chk","1",0);
			}	
			chkArr=ComPriSheetCheckedRows(sheetObjects[0], "chk");
			for(var i=0;i < chkArr.length;i++){
				var obj=new Object(); 
				obj.cd=sheetObjects[0].GetCellValue(chkArr[i], "loc_cd");
				obj.nm=sheetObjects[0].GetCellValue(chkArr[i], "loc_nm");
				obj.sconti_cd=sheetObjects[0].GetCellValue(chkArr[i], "sconti_cd");
				obj.sconti_nm=sheetObjects[0].GetCellValue(chkArr[i], "sconti_nm");
			   	obj.tp="L";
			   	array[arrayCnt]=obj;
				arrayCnt++;
			}
		} else if(formObj.radio_type[1].checked){
			var obj=new Object(); 
			obj.cd=combo_grp_loc_cd.GetSelectText();
			obj.nm=formObj.combo_grp_loc_nm.value;
			obj.tp="G";
			array[arrayCnt]=obj;
		} else if(formObj.radio_type[2].checked){
			var chkArr=ComPriSheetCheckedRows(sheetObjects[2], "chk");
			if(chkArr.length == 0){
				sheetObjects[2].SetCellValue(sheetObjects[2].GetSelectRow(),"chk","1",0);
			}	
			chkArr=ComPriSheetCheckedRows(sheetObjects[2], "chk");
			for(var i=0;i < chkArr.length;i++){
				var obj=new Object(); 
				obj.cd=sheetObjects[2].GetCellValue(chkArr[i], "ste_cd");
				obj.nm=sheetObjects[2].GetCellValue(chkArr[i], "ste_nm");
			   	obj.tp="T";
			   	obj.cnt_cd=sheetObjects[2].GetCellValue(chkArr[i], "combo_cnt_cd");
			   	array[arrayCnt]=obj;
				arrayCnt++;
			}		   	
		} else if(formObj.radio_type[3].checked){
			var chkArr=ComPriSheetCheckedRows(sheetObjects[3], "chk");
			if(chkArr.length == 0){
				sheetObjects[3].SetCellValue(sheetObjects[3].GetSelectRow(),"chk","1",0);
			}	
			chkArr=ComPriSheetCheckedRows(sheetObjects[3], "chk");
			for(var i=0;i < chkArr.length;i++){
				var obj=new Object(); 
				obj.cd=sheetObjects[3].GetCellValue(chkArr[i], "rgn_cd");
				obj.nm=sheetObjects[3].GetCellValue(chkArr[i], "rgn_nm");
			   	obj.tp="R";
			   	array[arrayCnt]=obj;
				arrayCnt++;
			}
		} else if(formObj.radio_type[4].checked){
			var chkArr=ComPriSheetCheckedRows(sheetObjects[4], "chk");
			if(chkArr.length == 0){
				sheetObjects[4].SetCellValue(sheetObjects[4].GetSelectRow(),"chk","1",0);
			}	
			chkArr=ComPriSheetCheckedRows(sheetObjects[4], "chk");
			for(var i=0;i < chkArr.length;i++){
				var obj=new Object(); 
				obj.cd=sheetObjects[4].GetCellValue(chkArr[i], "cnt_cd");
				obj.nm=sheetObjects[4].GetCellValue(chkArr[i], "cnt_nm");
			   	obj.tp="C";
			   	array[arrayCnt]=obj;
				arrayCnt++;
			}
		}
		if ( formObj.radio_type[1].checked){
			if (formObj.combo_grp_loc_cd.text !=""){
				ComPopUpReturnValue(array);
			}else{
				ComShowCodeMessage("PRI00310");
			}
		}else{
			if(arrayCnt > 0) {
				ComPopUpReturnValue(array);
			} else {
				ComShowCodeMessage("PRI00310");
			}
		}
	 }
 
 	function obj_onKeydown(){
 		var eleName=ComGetEvent("name");
 		if (eleName == "loc_cd" ){
		   	if (event != null && event.keyCode == 13){
		   		if (validateForm(sheetObjects[0],document.form,IBSEARCH)) {
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				}
		  	}
		}
	}
 	