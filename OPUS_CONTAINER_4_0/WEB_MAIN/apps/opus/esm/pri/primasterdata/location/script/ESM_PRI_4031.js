/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_PRI_4026.js
 *@FileTitle : Location Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.28
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2009.04.28 
 * 1.0 Creation
=========================================================*/
/****************************************************************************************
 Event code: [Initial]INIT=0; [ADD]ADD=1; [SEARCH]SEARCH=2; [SEARCHLIST]SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
 Other extra variable  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @
 * @author 
 */
/**
 * @extends
 * @class ESM_PRI_4026 : Business Script for ESM_PRI_4026
 */
function ESM_PRI_4031() {
	this.processButtonClick=tprocessButtonClick;
	this.setSheetObject=setSheetObject;
	this.loadPage=loadPage;
	this.initSheet=initSheet;
	this.initControl=initControl;
	this.doActionIBSheet=doActionIBSheet;
	this.setTabObject=setTabObject;
	this.validateForm=validateForm;
}
// common global variables
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
/**
 * Event handler processing by button name  <br>
 * <br><b>Example :</b>
 * <pre>
 *     processButtonClick();
 * </pre>
 * @return void
 * @author 
 * @version 2009.10.28
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
	//var sheetObject6 = sheetObjects[5];
	//Group Location
	var comboObject1=comboObjects[0];
	//State
	var comboObject2=comboObjects[1];
	//Region
	var comboObject3=comboObjects[2];
	//var comboObject4 = comboObjects[3];
	/** **************************************************** */
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch (srcName) {
		/** Radio Tab [ Location ] (S) * */
		case "btn_t1Retrieve":
			if (validateForm(sheetObject1,document.form,IBSEARCH)) {
				doActionIBSheet(sheetObject1,document.form,IBSEARCH);
			}			
			break;
		case "btn_t1New":
			// Reset Form Object
			ComClearManyObjects(formObject.loc_cd, formObject.loc_nm);
			// Reset IBSHEET
			sheetObject1.RemoveAll();
			break;
		/** Radio Tab [ Location ] (E) * */
		/** Radio Tab [ Group Location ] (S) * */
		case "btn_t2Retrieve":
			if (validateForm(sheetObject2,document.form,IBSEARCH)) {
				doActionIBSheet(sheetObject2,document.form,IBSEARCH);
			}	
			break;
		case "btn_t2New":
			// Reset Form Object
			ComClearManyObjects(formObject.combo_grp_loc_nm);
			// Reset IBSHEET
			sheetObject2.RemoveAll();
			comboObject1.SetSelectIndex("");
			break;
		/** Radio Tab [ Group Location ] (E) * */
		/** Radio Tab [ State ] (S) * */
		case "btn_t3Retrieve":
			if (validateForm(sheetObject3,document.form,IBSEARCH)) {
				doActionIBSheet(sheetObject3,document.form,IBSEARCH);
			}		
			break;
		case "btn_t3New":
			// Reset Form Object
			ComClearManyObjects(formObject.ste_cd, formObject.ste_nm, formObject.combo_cnt_nm);
			// Reset IBSHEET
			sheetObject3.RemoveAll();
			//AS-IS:comboObject2.SetSelectIndex("-1");
			comboObject2.SetSelectIndex(""); //OR SetSelectIndex(-1, true);

			break;
		/** Radio Tab [ State ] (E) * */
		/** Radio Tab [ Region ] (S) * */
		case "btn_t4Retrieve":
			if (validateForm(sheetObject4,document.form,IBSEARCH)) {
				doActionIBSheet(sheetObject4,document.form,IBSEARCH);
			}
			break;
		case "btn_t4New":
			// Reset Form Object
			ComClearManyObjects(formObject.rgn_cd, formObject.rgn_nm, formObject.combo2_cnt_nm);
			sheetObject4.RemoveAll();
			comboObject3.SetSelectIndex(-1, true);
			break;
		/** Radio Tab [ Region ] (E) * */
		/** Radio Tab [ Country ] (S) * */
		case "btn_t5Retrieve":
			if (validateForm(sheetObject5,document.form,IBSEARCH)) {				
				doActionIBSheet(sheetObject5,document.form,IBSEARCH);
			}
			break;
		case "btn_t5New":
			// Reset Form Object
			ComClearManyObjects(formObject.cnt_cd, formObject.cnt_nm);
			// Reset IBSHEET
			sheetObject5.RemoveAll();
			break;
		/** Radio Tab [ Country ] (E) * */
//		case "btn_OK":
//			returnButtonSheetData(formObject);			
//			break;
//		case "btn_Close":
//			ComClosePopup();
		case "radio_type":
			obj_OnClick();
			break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}
/**
 * registering IBSheet Object as list <br>
 * adding process for list in case of needing batch processing with other items<br>
 * defining list on the top of source <br>
 * <br><b>Example :</b>
 * <pre>
 *     setSheetObject(sheetObj);
 * </pre>
 * @param {ibsheet} sheet_obj mandatory IBSheet Object
 * @return void
 * @author 
 * @version 2009.10.28
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
* registering IBCombo Object as list</b>
* adding process for list in case of needing batch processing with other items<br>
* defining list on the top of source <br>
* <br><b>Example :</b>
* <pre>
*     setComboObject(comboObj);
* </pre>
* @param {ibcombo} combo_obj Mandatory IBCombo Object
* @return void
* @author 
* @version 2009.10.28
*/
function setComboObject(combo_obj){
	comboObjects[comboCnt++]=combo_obj;
}
/**
 * Resize Current Window.
 * @param weight
 * @param height
 * @return void
 * @author 
 * @version 2009.10.28
 */
function reSize(weight, height)
{
    dialogWidth=weight + 'px';
    dialogHeight=height + 'px';
}
 /**
  * initializing sheet <br>
  * implementing onLoad event handler in body tag <br>
  * adding first-served functions after loading screen. <br>
  * <br><b>Example :</b>
  * <pre>
  *     loadPage();
  * </pre>
  * @return void
  * @author 
  * @version 2009.05.17
  */
function loadPage() {
	var formObj=document.form;
	for (i=0; i < sheetObjects.length; i++) {
		// Modify Enviroment Setting Function's name
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		// Add Environment Setting Function 
		ComEndConfigSheet(sheetObjects[i]);
	}
	//Initializing IBMultiCombo
    for(var k=0; k < comboObjects.length; k++){
        initCombo(comboObjects[k], k + 1);
    }
    //Initializing html control event  
    initControl();
    initRadioCheck();
    if(formObj.loc_nm.value != "" && ComGetObjValue(formObj.radio_type) == "1") {
    	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    }

    $("#radioLayer2").css("display", "none");
    $("#radioLayer3").css("display", "none");
    $("#radioLayer4").css("display", "none");
    $("#radioLayer5").css("display", "none");
}
/**
 * setting sheet initial values and header <br>
 * adding case as numbers of counting sheets  <br>
 * <br><b>Example :</b>
 * <pre>
 *     initSheet(sheetObj,1);
 * </pre>
 * @param {ibsheet} sheetObj mandatory IBSheet Object
 * @param {int} sheetNo mandatory IBSheet Object Serial No
 * @return void
 * @author 
 * @version 2009.05.22
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	var sheetid=sheetObj.id;
	switch (sheetid) {
	case "sheet1":
	    with(sheetObj){
       
      var HeadTitle="|Seq.|Code|Description|S-Conti.|Region|sconti_nm";
      var headCount=ComCountHeadTitle(HeadTitle);

      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
      var headers = [ { Text:HeadTitle, Align:"Center"} ];
      InitHeaders(headers, info);

      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Status" },
             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"loc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0,  Width:280,  Align:"Left",    ColMerge:0,   SaveName:"loc_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 },
             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"sconti_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rgn_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"sconti_nm" } ];
       
      InitColumns(cols);

      SetEditable(0);
      resizeSheet();//SetSheetHeight(400);
            }


		break;
	case "sheet2":
	    with(sheetObj){
        
      var HeadTitle="|Seq.|Code|Description|S-Conti.|Region";
      var headCount=ComCountHeadTitle(HeadTitle);

      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
      var headers = [ { Text:HeadTitle, Align:"Center"} ];
      InitHeaders(headers, info);

      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Status" },
             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"loc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0,  Width:380,  Align:"Left",    ColMerge:0,   SaveName:"loc_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 },
             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"sconti_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rgn_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
       
      InitColumns(cols);

      SetEditable(0);
      resizeSheet();//SetSheetHeight(423);
            }


		break;
	case "sheet3":
	    with(sheetObj){
        
      var HeadTitle="|Seq.|Country|Code|Description|Continent|S-Conti.";
      var headCount=ComCountHeadTitle(HeadTitle);

      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
      var headers = [ { Text:HeadTitle, Align:"Center"} ];
      InitHeaders(headers, info);

      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Status" },
             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"combo_cnt_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ste_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:0,   SaveName:"ste_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 },
             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"conti_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"sconti_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
       
      InitColumns(cols);

      SetEditable(0);
      resizeSheet();//SetSheetHeight(380);
            }


		break;
	case "sheet4":
	    with(sheetObj){
       
      var HeadTitle="|Seq.|Code|Description|Continent|S-Conti.";
      var headCount=ComCountHeadTitle(HeadTitle);

      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
      var headers = [ { Text:HeadTitle, Align:"Center"} ];
      InitHeaders(headers, info);

      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Status" },
             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rgn_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0,  Width:320,  Align:"Left",    ColMerge:0,   SaveName:"rgn_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 },
             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"conti_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"sconti_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
       
      InitColumns(cols);

      SetEditable(0);
      resizeSheet();//SetSheetHeight(380);
            }


		break;
	case "sheet5":
	    with(sheetObj){
        
      var HeadTitle="|Seq.|Code|Description|Continent|S-Conti.";
      var headCount=ComCountHeadTitle(HeadTitle);

      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
      var headers = [ { Text:HeadTitle, Align:"Center"} ];
      InitHeaders(headers, info);

      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Status" },
             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cnt_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0,  Width:400,  Align:"Left",    ColMerge:0,   SaveName:"cnt_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 },
             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"conti_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"sconti_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
       
      InitColumns(cols);

      SetEditable(0);
      resizeSheet();//SetSheetHeight(400);
            }


		break;
	case "sheet6":
	    with(sheetObj){
        
      var HeadTitle1="|Seq.|IAA REGION|IAA REGION|LOCATION|LOCATION";
      var HeadTitle2="|Seq.|Code|Description|Code|Description";

      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
      var headers = [ { Text:HeadTitle1, Align:"Center"},
                  { Text:HeadTitle2, Align:"Center"} ];
      InitHeaders(headers, info);

      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Status" },
             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cnt_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"cnt_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 },
             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"conti_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:"sconti_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
       
      InitColumns(cols);

      SetEditable(0);
      SetSheetHeight(383);
            }


		break;
	}
}
function resizeSheet(){
	ComResizeSheet(sheetObjects[0]);
	ComResizeSheet(sheetObjects[1]);
	ComResizeSheet(sheetObjects[2]);
	ComResizeSheet(sheetObjects[3]);
	ComResizeSheet(sheetObjects[4]);
}
  /**
   * Implement ComboBox Initialization module. <br>
   * <br><b>Example :</b>
   * <pre>
   *     initCombo(comboObj, comboNo);
   * </pre>
   * @param {ibcombo} combo_obj Mandatory IBCombo Object
   * @param {int} comboNo Mandatory Sequence No. of IBCombo Object
   * @return void
   * @author 
   * @version 2009.05.22
   */
function initCombo(comboObj, comboNo) {
    switch(comboObj.options.id) {
        case "combo_cnt_cd":
            var i=0;
            with(comboObj) {

            	SetDropHeight(200);
            	SetMultiSelect(0);
            	SetMaxSelect(1);
            	SetUseAutoComplete(1);
            	ValidChar(2);
                SetMaxLength(2);
            }
            break;
        case "combo2_cnt_cd":
            var i=0;
            with(comboObj) {
            	SetDropHeight(200);
            	SetMultiSelect(0);
            	SetMaxSelect(1);
            	SetUseAutoComplete(1);
            	ValidChar(2);
                SetMaxLength(2);
            }
            break;
        case "combo_grp_loc_cd":
            var i=0;
            with(comboObj) {
            	//BackColor = "cyan";
            	SetDropHeight(200);
            	SetMultiSelect(0);
            	SetMaxSelect(1);
            	SetUseAutoComplete(1);
            //no support[check again]CLT 	IMEMode=0;
            //no support[check again]CLT 	ValidChar(2, 0);
            }
            break;
    }
}
/**
 * Initialize business javascript event function. <br>
 * <br><b>Example :</b>
 * <pre>
 *     initCombo(comboObj, comboNo);
 * </pre>
 * @return void
 * @author 
 * @version 2009.05.22
 */
function initControl() {
    // Process Axon Event No.1, Event Catch  
    axon_event.addListener ('click', 'obj_OnClick', 'radio_type');
    axon_event.addListener ('keydown', 'getKeyEnter', 'form');
}
 
 /**
  * This function can be called at onKeyDown event of HTML Tag (Object). When Enter key pressed, process autumatic function. <br>
  * The case of sFlag are as follows. <br>
  * sFlag = Nothing           : the same process as sFlag="Search" case.<br>
  * sFlag = "Search"          : when Enter key pressed, process as Retrieve button clicked. it should be called at OnKeyDown event <br>
  * sFlag = "NextFocus"       : when Enter key pressed, move focus to Next object in order. it should be called at OnKeyDown event <br>
  * sFlag = "LengthNextFocus" : when the contents filled as maxlength of field, move focus to Next Object automatically, when Enter key pressed, move focus to Next object without check the length of text. it should be called at OnKeyUp event<br>
  * sFlag = Function Name     : when Enter key pressed, call the function specified in sFlag.  it should be called at OnKeyDown event <br>
  * sFlag = "LengthNextFocus" case should be called at OnKeyUp event, otherwise at OnKeyDown event.<br>
  * <br><b>Example :</b>
  * <pre>
  *     <form name="form" onKeyDown="ComKeyEnter()">                    //Use it Search Condition form
  *     <form name="form" onKeyDown="ComKeyEnter('NextFocus')">     //Use it Save Form
  *     <form name="form" onKeyUp="ComKeyEnter('LengthNextFocus')"> // Use it Save Form
  * </pre>
  * @param {string} sFlag Optional, Key Process Seperate, default="Search"
  * @see #ComSetNextFocus
  */
 function getKeyEnter(sFlag)
 {
  	
	 var formObj=document.form;
	 var radioType=ComGetObjValue(formObj.radio_type);

     try {
     	
        if (sFlag==undefined || sFlag==null || sFlag.constructor!=String || sFlag.trim() == "") sFlag="search";
        
        switch(sFlag.toLowerCase()) {
         	case "search" :
         		// When Enterkey pressed, progress as retrieve button clicked
         		if (ComGetEvent("keycode") != 13) return;
         		var obj=document.getElementById("btn_Retrieve");
         		if(radioType == "1") {
         			obj=document.getElementById("btn_t1Retrieve");
         		} else if(radioType == "2") {
         			obj=document.getElementById("btn_t2Retrieve");
         		} else if(radioType == "3") {
         			obj=document.getElementById("btn_t3Retrieve");
         		} else if(radioType == "4") {
         			obj=document.getElementById("btn_t4Retrieve");
         		} else if(radioType == "5") {
         			obj=document.getElementById("btn_t5Retrieve");
         		}    
         		if (obj==null) obj=document.getElementById("btn_retrieve");
         		ComFireEvent(obj, "click");
         		break;

         	default :

         }
     } catch(err) { ComFuncErrMsg(err.message); }
 }
 /**
  * Calling Function in case of OnChange event <br>
  * showing Description<br>
  * <br><b>Example :</b>
  * <pre>
  *
  * </pre>
  * @param {ibcombo} comboObj Mandatory IBCombo Object
  * @param {string} code Mandatory Value of ComboBox that OnChange event triggered
  * @param {string} text Mandatory Value of Combo name that OnChange event triggered
  * @return void
  * @author 
  * @version 2009.06.25
  */  
 //
function combo_cnt_cd_OnChange(comboObj, OldIndex, OldText, OldCode, NewIndex, text, code) {
	var formObj=document.form;
	if(code != "") {
		comboObj.SetSelectCode(code);
		formObj.combo_cnt_nm.value = comboObj.GetText(NewIndex,1);
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
   * calling function in case of OnFocus event <br>
   * Set blank to ComboBox Code. <br>
   * <br><b>Example :</b>
   * <pre>
   *
   * </pre>
   * @param {ibcombo} comboObj Mandatory IBCombo Object
   * @return void
   * @author 
   * @version 2009.06.25
   */  
/*function combo_cnt_cd_OnFocus(comboObj) {
	comboObj.SetSelectCode(-1);
}*/
/**
 * Calling Function in case of OnChange event <br>
 * showing Description<br>
 * <br><b>Example :</b>
 * <pre>
 *
 * </pre>
 * @param {ibcombo} comboObj Mandatory IBCombo Object
 * @param {string} code Mandatory Value of ComboBox that OnChange event triggered
 * @param {string} text Mandatory Value of Combo name that OnChange event triggered
 * @return void
 * @author 
 * @version 2009.06.25
 */  
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
 * calling function in case of OnFocus event <br>
 * Set blank to ComboBox Code. <br>
 * <br><b>Example :</b>
 * <pre>
 *
 * </pre>
 * @param {ibcombo} comboObj Mandatory IBCombo Object
 * @return void
 * @author 
 * @version 2009.06.25
 */ 
/*function combo2_cnt_cd_OnFocus(comboObj) {
	comboObj.SetSelectCode(-1);
}*/
/**
* Calling Function in case of OnChange event <br>
* showing Description<br>
* <br><b>Example :</b>
* <pre>
*
* </pre>
* @param {ibcombo} comboObj Mandatory IBCombo Object
* @param {string} code Mandatory Value of ComboBox that OnChange event triggered
* @param {string} text Mandatory Value of Combo name that OnChange event triggered
* @return void
* @author 
* @version 2009.06.25
*/  
function combo_grp_loc_cd_OnChange(comboObj, OldIndex, OldText, OldCode, NewIndex, text, code) {
	var formObj=document.form;
	try{	
		if(code != "") {
			var arrText=text.split("|");		
			formObj.combo_grp_loc_nm.value=formObj.combo_grp_loc_cd.GetText(code,1);	
			formObj.grp_loc_seq.value=code;
			if (validateForm(sheetObjects[1],document.form,IBSEARCH)) {
		 		doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
 			} 
		}
	}catch(e){}	
}
/**
 * Business javascript : Process OnClick Event <br>
 * 
 * Separate Type of group_cmd : Using Group type from parent window.<br>
 * SP_SCP : S/C Proposal<br>
 * RG : RFA Guideline<br>
 * SG : S/C Guideline<br>
 * RP_SCP :RFA Proposal<br>
 * SCG : Surcharge<br>
 * <br><b>Example :</b>
 * <pre>
 *
 * </pre>
 * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
 * @param {int} Row mandatory Onclick ,Cell's Row Index
 * @param {int} Col mandatory Onclick ,Cell's Column Index
 * @param {string} Value Mandatory cell Value
 * @return void
 * @author 
 * @version 2009.06.25
 */ 
function obj_OnClick(sheetObj,Row, Col, Value) {
	var formObj=document.form;
	var objs=document.form.group_cmd.value;	 
	
	if(ComGetEvent().value == "1") {
		ComSetObjValue(formObj.loc_cd,"");
		ComSetObjValue(formObj.loc_nm,"");
		sheetObjects[0].RemoveAll();
		
		document.getElementById("radioLayer1").style.display='';
		document.getElementById("radioLayer2").style.display='none';
		document.getElementById("radioLayer3").style.display='none';
		document.getElementById("radioLayer4").style.display='none';
		document.getElementById("radioLayer5").style.display='none';
		
		document.getElementById("btn1").style.display='';
		document.getElementById("btn2").style.display='none';
		document.getElementById("btn3").style.display='none';
		document.getElementById("btn4").style.display='none';
		document.getElementById("btn5").style.display='none';
		
		document.getElementById("radioSearchLayer1").style.display='';
		document.getElementById("radioSearchLayer2").style.display='none';
		document.getElementById("radioSearchLayer3").style.display='none';
		document.getElementById("radioSearchLayer4").style.display='none';
		document.getElementById("radioSearchLayer5").style.display='none';
		
	} else if(ComGetEvent().value == "2") {
		ComSetObjValue(formObj.combo_grp_loc_cd,"");
		ComSetObjValue(formObj.combo_grp_loc_nm,"");
		sheetObjects[1].RemoveAll();
		document.getElementById("radioLayer1").style.display='none';
		document.getElementById("radioLayer2").style.display='';
		document.getElementById("radioLayer3").style.display='none';
		document.getElementById("radioLayer4").style.display='none';
		document.getElementById("radioLayer5").style.display='none';
		
		document.getElementById("btn1").style.display='none';
		document.getElementById("btn2").style.display='';
		document.getElementById("btn3").style.display='none';
		document.getElementById("btn4").style.display='none';
		document.getElementById("btn5").style.display='none';
		
		document.getElementById("radioSearchLayer1").style.display='none';
		document.getElementById("radioSearchLayer2").style.display='';
		document.getElementById("radioSearchLayer3").style.display='none';
		document.getElementById("radioSearchLayer4").style.display='none';
		document.getElementById("radioSearchLayer5").style.display='none';
		// In case of Group location. Because the retrieved database is different based on type classification of that. 
		// Declare group_cmd, Retrieve separately.
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
	} else if(ComGetEvent().value == "3") {
		ComSetObjValue(formObj.combo_cnt_cd,"");
		ComSetObjValue(formObj.combo_cnt_nm,"");
		ComSetObjValue(formObj.ste_cd,"");
		ComSetObjValue(formObj.ste_nm,"");
		sheetObjects[2].RemoveAll();
		document.getElementById("radioLayer1").style.display='none';
		document.getElementById("radioLayer2").style.display='none';
		document.getElementById("radioLayer3").style.display='block';
		document.getElementById("radioLayer4").style.display='none';
		document.getElementById("radioLayer5").style.display='none';
		
		document.getElementById("btn1").style.display='none';
		document.getElementById("btn2").style.display='none';
		document.getElementById("btn3").style.display='block';
		document.getElementById("btn4").style.display='none';
		document.getElementById("btn5").style.display='none';
		
		document.getElementById("radioSearchLayer1").style.display='none';
		document.getElementById("radioSearchLayer2").style.display='none';
		document.getElementById("radioSearchLayer3").style.display='block';
		document.getElementById("radioSearchLayer4").style.display='none';
		document.getElementById("radioSearchLayer5").style.display='none';
		
		doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC10);
	} else if(ComGetEvent().value == "4") {		
		ComSetObjValue(formObj.combo2_cnt_cd,"");
		ComSetObjValue(formObj.combo2_cnt_nm,"");
		ComSetObjValue(formObj.rgn_cd,"");
		ComSetObjValue(formObj.rgn_nm,"");
		sheetObjects[3].RemoveAll();
		document.getElementById("radioLayer1").style.display='none';
		document.getElementById("radioLayer2").style.display='none';
		document.getElementById("radioLayer3").style.display='none';
		document.getElementById("radioLayer4").style.display='block';
		document.getElementById("radioLayer5").style.display='none';
		
		document.getElementById("btn1").style.display='none';
		document.getElementById("btn2").style.display='none';
		document.getElementById("btn3").style.display='none';
		document.getElementById("btn4").style.display='block';
		document.getElementById("btn5").style.display='none';
		
		document.getElementById("radioSearchLayer1").style.display='none';
		document.getElementById("radioSearchLayer2").style.display='none';
		document.getElementById("radioSearchLayer3").style.display='none';
		document.getElementById("radioSearchLayer4").style.display='block';
		document.getElementById("radioSearchLayer5").style.display='none';
		doActionIBSheet(sheetObjects[3], document.form, IBSEARCH_ASYNC11);
	} else if(ComGetEvent().value == "5") {
		ComSetObjValue(formObj.cnt_cd,"");
		ComSetObjValue(formObj.cnt_nm,"");
		sheetObjects[4].RemoveAll();
		document.getElementById("radioLayer1").style.display='none';
		document.getElementById("radioLayer2").style.display='none';
		document.getElementById("radioLayer3").style.display='none';
		document.getElementById("radioLayer4").style.display='none';
		document.getElementById("radioLayer5").style.display='block';
		
		document.getElementById("btn1").style.display='none';
		document.getElementById("btn2").style.display='none';
		document.getElementById("btn3").style.display='none';
		document.getElementById("btn4").style.display='none';
		document.getElementById("btn5").style.display='block';
		
		document.getElementById("radioSearchLayer1").style.display='none';
		document.getElementById("radioSearchLayer2").style.display='none';
		document.getElementById("radioSearchLayer3").style.display='none';
		document.getElementById("radioSearchLayer4").style.display='none';
		document.getElementById("radioSearchLayer5").style.display='block';
	}
	// timer
	resizeSheet();
	//setTimeout(function(){resizeSheet()}, 500);
}
 /**
  * Handling sheet's processes <br>
  * <br><b>Example :</b>
  * <pre>
  *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
  * </pre>
  * @param {ibsheet} sheetObj mandatory IBSheet Object
  * @param {form} formObj mandatory html form object
  * @param {int} sAction mandatory,Constant Variable
  * @return void
  * @author 
  * @version 2009.05.22
  */
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {	
		case IBSEARCH_ASYNC10: // Retrieving service scope when loading screen
			formObj.f_cmd.value=SEARCH07;
			var sXml=sheetObj.GetSearchData("ESM_PRI_4026GS.do", FormQueryString(formObj));
			ComPriXml2ComboItem(sXml, combo_cnt_cd, "cd", "cd|nm");
			break;
		case IBSEARCH_ASYNC11: // Retrieve Service Scope when screen is loading
			formObj.f_cmd.value=SEARCH08;
			var sXml=sheetObj.GetSearchData("ESM_PRI_4026GS.do", FormQueryString(formObj));
			ComPriXml2ComboItem(sXml, combo2_cnt_cd, "cd", "cd|nm");
			break;	
		case IBSEARCH_ASYNC12: // Retrieve Service Scope when screen is loading
			var sXml=sheetObj.GetSearchData("ESM_PRI_4026GS.do", FormQueryString(formObj));
			ComPriXml2ComboItem(sXml, combo_grp_loc_cd, "grp_loc_seq", "cd|nm");
			break;	
		case IBSEARCH: // retrieving
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
		case IBSAVE: // Saving
			break;
		case IBINSERT:
			break;
	}
}
/**
 * handling process for input validation <br>
 * <br><b>Example :</b>
 * <pre>
 *     if (validateForm(sheetObj,document.form,IBSAVE)) {
 *        handling logic
 *     }
 * </pre>
 * @param {ibsheet} sheetObj mandatory IBSheet Object
 * @param {form} formObj mandatory html form object
 * @param {int} sAction mandatory,Constant Variable
 * @returns bool <br>
 *          true  : valid<br>
 *          false : inValid
 * @author 
 * @version 2009.04.17
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
  * Initialize radio combo <br>
  * Choose Radio combobox items, using values from main. <br>
  * L : radio_type[0] : location<br>
  * G : radio_type[1] : Group location<br>
  * T : radio_type[2] : State<br>
  * R : radio_type[3] : Region<br>
  * C : radio_type[4] : Country<br>
  * <br><b>Example :</b>
  * <pre>
  *     initRadioCheck()
  * </pre>
  * @return void
  * @author 
  * @version 2009.05.19
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
	for(i=0; i<arr.length; i++) {
		if(arr[i] == "L") {
			formObj.radio_type[0].disabled=false;
			if(arr[i] == prcCmdtTdCd){
				formObj.radio_type[0].checked=true;
			} else if (i==0){
				formObj.radio_type[0].checked=true;
			}
		} else if(arr[i] == "G") {
			formObj.radio_type[1].disabled=false;
			if(arr[i] == prcCmdtTdCd){
				formObj.radio_type[1].checked=true;
			} else if(i==0){
				formObj.radio_type[1].checked=true;
			}
		} else if(arr[i] == "T") {
			formObj.radio_type[2].disabled=false;
			if(arr[i] == prcCmdtTdCd){
				formObj.radio_type[2].checked=true;
			} else if(i==0){
				formObj.radio_type[2].checked=true;
			}
		} else if(arr[i] == "R") {
			formObj.radio_type[3].disabled=false;
			if(arr[i] == prcCmdtTdCd){
				formObj.radio_type[3].checked=true;
			} else if(i==0){
				formObj.radio_type[3].checked=true;
			}
		} else if(arr[i] == "C") {
			formObj.radio_type[4].disabled=false;
			if(arr[i] == prcCmdtTdCd){
				formObj.radio_type[4].checked=true;
			} else if(i==0){
				formObj.radio_type[4].checked=true;
			}
		}
	}
	// Display First Layer.
	
	if(prcCmdtTdCd != "") {
		showDivCheck(prcCmdtTdCd);
	} else {
		showDivCheck(arr[0]);
	}
}
 /**
  *  Display first layer among the value from location_cmd. <br>
  * <br><b>Example :</b>
  * <pre>
  *     showDivCheck(locationCmd)
  * </pre>
  * @param {string} locationCmd . Passing from main Window
  * @return void
  * @author 
  * @version 2009.05.19
  */
function showDivCheck(locationCmd) {
	var objs=document.form.group_cmd.value;
	if(locationCmd == "L") {
		document.getElementById("radioLayer1").style.display='block';
		document.getElementById("radioLayer2").style.display='none';
		document.getElementById("radioLayer3").style.display='none';
		document.getElementById("radioLayer4").style.display='none';
		document.getElementById("radioLayer5").style.display='none';
		
		
		document.getElementById("btn1").style.display='block';
		document.getElementById("btn2").style.display='none';
		document.getElementById("btn3").style.display='none';
		document.getElementById("btn4").style.display='none';
		document.getElementById("btn5").style.display='none';
		
		document.getElementById("radioSearchLayer1").style.display='block';
		document.getElementById("radioSearchLayer2").style.display='none';
		document.getElementById("radioSearchLayer3").style.display='none';
		document.getElementById("radioSearchLayer4").style.display='none';
		document.getElementById("radioSearchLayer5").style.display='none';
	} else if(locationCmd == "G") {
		document.getElementById("radioLayer1").style.display='none';
		document.getElementById("radioLayer2").style.display='block';
		document.getElementById("radioLayer3").style.display='none';
		document.getElementById("radioLayer4").style.display='none';
		document.getElementById("radioLayer5").style.display='none';
		
		document.getElementById("btn1").style.display='none';
		document.getElementById("btn2").style.display='block';
		document.getElementById("btn3").style.display='none';
		document.getElementById("btn4").style.display='none';
		document.getElementById("btn5").style.display='none';
		
		document.getElementById("radioSearchLayer1").style.display='none';
		document.getElementById("radioSearchLayer2").style.display='block';
		document.getElementById("radioSearchLayer3").style.display='none';
		document.getElementById("radioSearchLayer4").style.display='none';
		document.getElementById("radioSearchLayer5").style.display='none';
		
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
		document.getElementById("radioLayer3").style.display='block';
		document.getElementById("radioLayer4").style.display='none';
		document.getElementById("radioLayer5").style.display='none';
		
		document.getElementById("btn1").style.display='none';
		document.getElementById("btn2").style.display='none';
		document.getElementById("btn3").style.display='block';
		document.getElementById("btn4").style.display='none';
		document.getElementById("btn5").style.display='none';
		
		document.getElementById("radioSearchLayer1").style.display='none';
		document.getElementById("radioSearchLayer2").style.display='none';
		document.getElementById("radioSearchLayer3").style.display='block';
		document.getElementById("radioSearchLayer4").style.display='none';
		document.getElementById("radioSearchLayer5").style.display='none';
		
		
		doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC10);
	} else if(locationCmd == "R") {
		document.getElementById("radioLayer1").style.display='none';
		document.getElementById("radioLayer2").style.display='none';
		document.getElementById("radioLayer3").style.display='none';
		document.getElementById("radioLayer4").style.display='block';
		document.getElementById("radioLayer5").style.display='none';
		
		document.getElementById("btn1").style.display='none';
		document.getElementById("btn2").style.display='none';
		document.getElementById("btn3").style.display='none';
		document.getElementById("btn4").style.display='block';
		document.getElementById("btn5").style.display='none';
		
		document.getElementById("radioSearchLayer1").style.display='none';
		document.getElementById("radioSearchLayer2").style.display='none';
		document.getElementById("radioSearchLayer3").style.display='none';
		document.getElementById("radioSearchLayer4").style.display='block';
		document.getElementById("radioSearchLayer5").style.display='none';
		doActionIBSheet(sheetObjects[3], document.form, IBSEARCH_ASYNC11);
	} else if(locationCmd == "C") {
		document.getElementById("radioLayer1").style.display='none';
		document.getElementById("radioLayer2").style.display='none';
		document.getElementById("radioLayer3").style.display='none';
		document.getElementById("radioLayer4").style.display='none';
		document.getElementById("radioLayer5").style.display='block';
		
		document.getElementById("btn1").style.display='none';
		document.getElementById("btn2").style.display='none';
		document.getElementById("btn3").style.display='none';
		document.getElementById("btn4").style.display='none';
		document.getElementById("btn5").style.display='block';
		
		document.getElementById("radioSearchLayer1").style.display='none';
		document.getElementById("radioSearchLayer2").style.display='none';
		document.getElementById("radioSearchLayer3").style.display='none';
		document.getElementById("radioSearchLayer4").style.display='none';
		document.getElementById("radioSearchLayer5").style.display='block';
	}
}

//해당 페이지는 팝업으로 사용하지 않음.
// /**
// * Return the selected code of SHEET to parent window. <br>
// * <br><b>Example :</b>
// * <pre>
// *     returnButtonSheetData(formObj);
// * </pre>
// * @return void
// * @author 
// * @version 2009.05.19
// */
// function returnButtonSheetData(formObj) {
//	var obj=new Object(); 
//	var Row=0;
//	if(formObj.radio_type[0].checked){
//		Row=sheetObjects[0].GetSelectRow();
//		obj.cd=sheetObjects[0].GetCellValue(Row, "loc_cd");
//		obj.nm=sheetObjects[0].GetCellValue(Row, "loc_nm");
//		obj.sconti_cd=sheetObjects[0].GetCellValue(Row, "sconti_cd");
//		obj.sconti_nm=sheetObjects[0].GetCellValue(Row, "sconti_nm");
//	   	obj.tp="L";
//	} else if(formObj.radio_type[1].checked){
//		obj.cd=formObj.combo_grp_loc_cd.text;
//		obj.nm=formObj.combo_grp_loc_nm.value;
//		obj.tp="G";
//	} else if(formObj.radio_type[2].checked){
//		Row=sheetObjects[2].GetSelectRow();
//		obj.cd=sheetObjects[2].GetCellValue(Row, "ste_cd");
//		obj.nm=sheetObjects[2].GetCellValue(Row, "ste_nm");
//	   	obj.tp="T";
//	} else if(formObj.radio_type[3].checked){
//		Row=sheetObjects[3].GetSelectRow();
//		obj.cd=sheetObjects[3].GetCellValue(Row, "rgn_cd");
//	obj.nm=sheetObjects[3].GetCellValue(Row, "rgn_nm");
//	   	obj.tp="R";
//	} else if(formObj.radio_type[4].checked){
//		Row=sheetObjects[4].GetSelectRow();
//		obj.cd=sheetObjects[4].GetCellValue(Row, "cnt_cd");
//		obj.nm=sheetObjects[4].GetCellValue(Row, "cnt_nm");
//	   	obj.tp="C";
//	}
//	if ( formObj.radio_type[1].checked){
//		if (formObj.combo_grp_loc_cd.text !=""){
//			window.returnValue=obj;
//			ComClosePopup(); 
//		}else{
//			ComShowCodeMessage("PRI00310");
//		}
//	}else{
//		if(Row > 0) {
//		    window.returnValue=obj;
//		    ComClosePopup(); 
//		} else {
//			ComShowCodeMessage("PRI00310");
//		}
//	}
// }
