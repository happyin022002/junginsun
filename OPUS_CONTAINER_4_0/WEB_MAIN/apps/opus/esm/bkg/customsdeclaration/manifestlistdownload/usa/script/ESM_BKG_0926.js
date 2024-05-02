/*=========================================================
 ** **Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0926.js
*@FileTitle  : C/M Data Check Set-up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
                    [modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
                    character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1; 
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
//getting all input element in the form
var j=k=0;
var hideArr=new Array();
var chkArr=new Array();
var frmChild=document.getElementsByTagName("input");
for(var i=0; i<frmChild.length; i++){
	if(frmChild[i].type == "hidden"){
		hideArr[j++]=frmChild[i];
	}
	if(frmChild[i].type == "checkbox"){
		chkArr[k++]=frmChild[i];
	}
}
var checkCnt=0;
// defining Office Code
var availableOfc=new Array();
availableOfc[0]="HAMU";
availableOfc[1]="NYCN";
availableOfc[2]="SHAA";
availableOfc[3]="SINW";
availableOfc[4]="SELH";
var frobVal;
//var retrieveFlag=false;
//var deleteFlag=false;
var retrieveActFlg=false;
var selectedTab=0;
//Event handler processing by button click event */
document.onclick=processButtonClick;
//Event handler processing by button name */
function processButtonClick(){
    /***** using extra sheet valuable if there are more 2 sheets *****/
    var sheetObject=sheetObjects[0];
    /*******************************************************/
    var formObject=document.form;
    if (tabObjects[0].GetSelectedIndex() == 0)  {
		sheetObj=sheetObjects[0];
    } else if (tabObjects[0].GetSelectedIndex() == 1)  {
    	sheetObj=sheetObjects[1];
    }
    selectedTab = tabObjects[0].GetSelectedIndex();
    try {
        var srcName=ComGetEvent("name");
        if (!ComIsBtnEnable(srcName)) return;
        switch(srcName) {
        case "btn_Retrieve":
        	retrieveActFlg=true;
            doActionIBSheet(sheetObject, formObject, IBSEARCH);
            break;
        case "btn_New":
            doActionIBSheet(sheetObject, formObject, IBINSERT);
        	comboObjects[0].SetSelectIndex("0");
        	comboObjects[1].SetSelectIndex("0");
        	//var frobs=formObject.elements("frob_flg");
        	var frobs=formObject.frob_flg;
        	for(i=0; i < frobs.length; i++ ) {
        		if(frobs[i].value == "Y") {
        			frobs[i].checked=true;
        		}else{
        			frobs[i].checked=false;
        		}
        	}
            break; 
        case "btn_Save":
            doActionIBSheet(sheetObject, formObject, IBSAVE); 
            break; 
        case "btn_Delete":
        	var obj = event.target || event.scrElement;
        	if($(obj).prop("disabled")){
        		return;
        	}
            doActionIBSheet(sheetObject, formObject, IBDELETE); 
            break; 
        } // end switch
    }catch(e) {
        if( e == "[object Error]") {
            ComShowMessage(OBJECT_ERROR);
        } else {
            ComShowMessage(e);
        }
    }
}
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {    
	for(i=0; i < comboObjects.length; i++ ) {
		initCombo(comboObjects[i], i+1);
	}
    for (i=0; i < sheetObjects.length; i++) {
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i + 1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    for(var k=0;k<tabObjects.length;k++){
        initTab(tabObjects[k],k+1);
        tabObjects[k].SetSelectedIndex(0);
    }
	toggleButtons("INIT");
    if(document.form.menuCode.value == "R") {
		for(var i=0; i<frmChild.length; i++){
			if(frmChild[i].type == "checkbox"){
				frmChild[i].disabled=true;
			}
    	}
		ComBtnEnable("btn_Retrieve");
    }
	// Necessary event on the screen
	axon_event.addListenerForm("click","obj_click", document.form);
	//axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
	//axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
	$('#cnt_cd_text, #loc_cd_text').on('keypress', function(event) {
        if(null !== String.fromCharCode(event.which).match(/[a-z]/g)) {
            event.preventDefault();
            $(this).val($(this).val() + String.fromCharCode(event.which).toUpperCase());
        }
    });
}
/**
 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 */
function setSheetObject(sheet_obj) {
    sheetObjects[sheetCnt++]=sheet_obj;
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
 * registering the created IBCombo Object at page as comboObjects list
 * @param combo_obj
 * @return
 */
function setComboObject(combo_obj) {
	comboObjects[comboCnt++]=combo_obj; 
}
/**
 * Tab option
 * setting tab list
 */
function initTab(tabObj , tabNo) {
	switch(tabNo) {
		case 1:
		    with (tabObj) {
		        var cnt=0 ;
		        InsertItem( "Export From" , "");
		        InsertItem( "Import To" , "");
		    }
		break;
	}
}
/**
 * event in case of clicking tab
 * activating selected tab
 */
function tab1_OnChange(tabObj , nItem)
{
    var objs=document.all.item("tabLayer");
	objs[nItem].style.display="inline";
	objs[beforetab].style.display="none";
	//---------------important --------------------------//
	objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
	//------------------------------------------------------//
	beforetab=nItem;
}
/**
 * initializing Combo Object initializing
 * @param comboObj
 * @param comNo
 * @return
 */
function initCombo(comboObj, comboNo) {
    switch(comboObj.id) {
        case "cnt_cd":
            var i=0;
            with(comboObj) {
            	//BackColor = "cyan";
            	SetDropHeight(200);
            	SetMultiSelect(0);
            	SetMaxSelect(1);
            }
            break;
        case "loc_cd":
            var i=0;
            with(comboObj) {
            	//UseEdit = true;
            	//BackColor = "cyan";
            	SetDropHeight(200);
            	SetMultiSelect(0);
            	SetMaxSelect(1);
            }
            break;
    }
}
/**
 * cnt_cd combo Change event handling
 * @param comboObj
 * @param value
 * @param text
 * @return
 */
function cnt_cd_OnChange(comboObj, value, text) {
	var str;
//	for(var i=0; i<frmChild.length; i++){
//		if(frmChild[i].type == "hidden"){
//			var prefix=frmChild[i].name.substring(0,3);
//			if(prefix == "exp" || prefix == "imp"){
//				str=frmChild[i].name.substring(7,frmChild[i].name.length);
//	        	if(str == "cnt_cd"){
//	        		frmChild[i].value=value;
//	        	}
//			}
//		}
//    }
//	retrieveFlag=false;
//	deleteFlag=false;
	initCheckbox();
	ComBtnEnable("btn_Retrieve");
	toggleButtons("READONLY");
	document.form.cntCd.value=comboObj.GetSelectCode();
    doActionIBSheet(sheetObjects[0], document.form, SEARCH02);
    
    doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}
/**
 * loc_cd combo Change event handling
 * @param comboObj
 * @param value
 * @param text
 * @return
 */
function loc_cd_OnChange(comboObj, value, text) {
//	var str;
//	for(var i=0; i<frmChild.length; i++){
//		if(frmChild[i].type == "hidden"){
//			var prefix=frmChild[i].name.substring(0,3);
//			if(prefix == "exp" || prefix == "imp"){
//				str=frmChild[i].name.substring(7,frmChild[i].name.length);
//	        	if(str == "loc_cd"){
//	        		frmChild[i].value=value;
//	        	}
//			}
//		}
//    }
	initCheckbox();
	toggleButtons("READONLY");
	
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}
/**
 * handling at retrieve condition when Including FROB is selected
 * @param comboObj
 * @param value
 * @param text
 * @return
 */
function OnClickRadioButton(formObj){
	//var frobs=formObj.elements("frob_flg");
	var frobs=formObj.frob_flg;
	for(i=0; i < frobs.length; i++ ) {
		if(frobs[i].checked) {
//			if(frobVal != frobs[i].value){
//				retrieveFlag=false;
//				deleteFlag=false;
//			}
			frobVal=frobs[i].value;
		}
	}
	initCheckbox();
	toggleButtons("READONLY");
	
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}
/**
 * all checkbox Unchecked
 */
function initCheckbox() {
	for(var i=0; i<frmChild.length; i++){
		if(frmChild[i].type == "checkbox"){
			frmChild[i].checked=false;
		}
	}
}
/**
 * retrieve in case of typing enter key at Location Code
 */
function obj_KeyPress() {
	var formObject=document.form;
	var srcName=ComGetEvent("name");
	var srcMaxLength=ComGetEvent("maxlength");//window.event.srcElement.getAttribute("maxlength");
	var srcValue=ComGetEvent("value");//window.event.srcElement.getAttribute("value");
	if (srcName == "loc_cd" && KeyCode == 13) {
	    doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}
}
/**
 * Click event handling
 */
function obj_click(){
	var formObject=document.form;
    if(!validateForm(sheetObjects[0],formObject,COMMAND01)) return;
	if(!ComIsBtnEnable("btn_Retrieve")) {
		ComShowCodeMessage('BKG06035'); 
		return;
	}
	var srcObj=ComGetEvent();//window.event.srcElement;
	var srcName=srcObj.getAttribute("name");
	var srcVal=srcObj.value;
	if(formObject.menuCode.value == "C" && srcObj.type == "checkbox"){
//		if(!retrieveFlag) {
//			return false;
//		}
        if(srcObj.checked)
        	checkCnt++;
        else
        	checkCnt--;
    	if(checkCnt >= 0) {
            ComBtnEnable("btn_Save");
    	}
    }
}
/**
 * process when input retrieve keyword
 */
function obj_KeyUp() {
	var formObject=document.form;
	var srcName=ComGetEvent("name");
	var srcMaxLength=ComGetEvent("maxlength");//window.event.srcElement.getAttribute("maxlength");
	var srcValue=ComGetEvent("value");//window.event.srcElement.getAttribute("value");
	if (srcName == "loc_cd" && ComChkLen(srcValue, srcMaxLength) == "2") {
		ComSetNextFocus();
	}
}
 /**
  * setting sheet initial values and header
  * @param sheetObj
  * @param sheetNo
  * @return
  */
function initSheet(sheetObj, sheetNo) {
    var cnt=0;
    var sheetID=sheetObj.id;
    switch (sheetID) {
    case "sheet1": // sheet1 init
		with(sheetObj){
			var HeadTitle1="|Information|Information|Information|Information|Information|Information|Shipper|Shipper|Shipper|Shipper|Shipper|Shipper|Shipper|Shipper|Shipper|Shipper|Shipper|Consignee|Consignee|Consignee|Consignee|Consignee|Consignee|Consignee|Consignee|Consignee|Consignee|Consignee|Notify|Notify|Notify|Notify|Notify|Notify|Notify|Notify|Notify|Notify|Notify|B/L Main|B/L Main|B/L Main|B/L Main|B/L Main|Container|Container|Container|Container|Container|C/M|C/M|C/M|C/M|C/M|C/M|C/M|C/M|Export/Import Ref #|Export/Import Ref #|Export/Import Ref #|Export/Import Ref #|Export/Import Ref #|Export/Import Ref #|Export/Import Ref #|Del St.";
			var HeadTitle2="|Exp/Imp Code|B/L Type|Country|Location|Frob|Cstms Div Id|Name|Address|City|State|Country|ZIP|Street|EORI|Tel|Fax|Company Registration No.|Name|Address|City|State|Country|ZIP|Street|EORI|Tel|Fax|Company Registration No.|Name|Address|City|State|Country|ZIP|Street|EORI|Tel|Fax|Company Registration No.|Package|Weight|Measure|Description|Mark|Container No|Seal No|Package|Weight|Measure|Package|Weight|Measure|Description|Mark|HTS|HS|NCM|Ref #1|Ref #2|Ref #3|Ref #4|Ref #5|Ref #6|Ref #7|Del St.";
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			
			var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
			var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
			InitHeaders(headers, info);
			
			var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"xpt_imp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"bl_tp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cnt_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"loc_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"frob_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cstms_div_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"shpr_nm_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N"},
			 {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"shpr_addr_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N"},
			 {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"shpr_cty_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N"},
			 {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"shpr_ste_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N"},
			 {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"shpr_cnt_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N"},
			 {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"shpr_zip_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N"},
			 {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"shpr_phn_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N"},

			 {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"shpr_st_nm_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N"},
			 {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"shpr_eori_no_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N"},

			 
			 {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"shpr_fax_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N"},
			 {Type:"CheckBox",  Hidden:0, Width:150,  Align:"Center",  ColMerge:1,   SaveName:"shpr_co_rgst_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N"},
			 {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cnee_nm_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N"},
			 {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cnee_addr_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N"},
			 {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cnee_cty_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N"},
			 {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cnee_ste_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N"},
			 {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cnee_cnt_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N"},
			 {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cnee_zip_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N"},
			 {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cnee_phn_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N"},

			 {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cnee_st_nm_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N"},
			 {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cnee_eori_no_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N"},
			 
			 {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cnee_fax_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N"},
			 {Type:"CheckBox",  Hidden:0, Width:150,  Align:"Center",  ColMerge:1,   SaveName:"cnee_co_rgst_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N"},
			 {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ntfy_nm_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N"},
			 {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ntfy_addr_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N"},
			 {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ntfy_cty_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N"},
			 {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ntfy_ste_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N"},
			 {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ntfy_cnt_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N"},
			 {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ntfy_zip_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N"},
			 {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ntfy_phn_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N"},

			 {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ntfy_st_nm_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N"},
			 {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ntfy_eori_no_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N"},
			 
			 {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ntfy_fax_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N"},
			 {Type:"CheckBox",  Hidden:0, Width:150,  Align:"Center",  ColMerge:1,   SaveName:"ntfy_co_rgst_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N"},
			 {Type:"CheckBox",  Hidden:0, Width:55,   Align:"Center",  ColMerge:1,   SaveName:"pck_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N"},
			 {Type:"CheckBox",  Hidden:0, Width:55,   Align:"Center",  ColMerge:1,   SaveName:"wgt_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N"},
			 {Type:"CheckBox",  Hidden:0, Width:55,   Align:"Center",  ColMerge:1,   SaveName:"meas_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N"},
			 {Type:"CheckBox",  Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bl_desc_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N"},
			 {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bl_mk_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N"},
			 {Type:"CheckBox",  Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N"},
			 {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"seal_no_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N"},
			 {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_pck_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N"},
			 {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_wgt_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N"},
			 {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cntr_meas_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N"},
			 {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_mf_pck_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N"},
			 {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_mf_wgt_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N"},
			 {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cntr_mf_meas_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N"},
			 {Type:"CheckBox",  Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cntr_mf_desc_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N"},
			 {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_mf_mk_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N"},
			 {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cntr_mf_cmdt_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N"},
			 {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cmdt_hs_cd_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N"},
			 {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cntr_mf_ncm_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N"},
			 {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"xpt_imp_ref_flg1",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N"},
			 {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"xpt_imp_ref_flg2",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N"},
			 {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"xpt_imp_ref_flg3",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N"},
			 {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"xpt_imp_ref_flg4",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N"},
			 {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"xpt_imp_ref_flg5",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N"},
			 {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"xpt_imp_ref_flg6",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N"},
			 {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"xpt_imp_ref_flg7",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, TrueValue:"Y", FalseValue:"N"},
			 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"delt_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			   
			InitColumns(cols);
			SetSheetHeight(180);
			SetEditable(1);
		}
    	sheetObj.DataInsert(-1);
    	sheetObj.DataInsert(-1);
    	sheetObj.DataInsert(-1);
    	sheetObj.DataInsert(-1);
        break;
    }
}
/**
 * initializing sheet data
 * @param sheetObj
 * @return
 */
function initSheetData(sheetObj) {
	sheetObj.RemoveAll();
	sheetObj.DataInsert(-1);
	sheetObj.DataInsert(-1);
	sheetObj.DataInsert(-1);
	sheetObj.DataInsert(-1);
	sheetObj.SetCellValue(2,"xpt_imp_cd",'E',0);
	sheetObj.SetCellValue(3,"xpt_imp_cd",'E',0);
	sheetObj.SetCellValue(4,"xpt_imp_cd",'I',0);
	sheetObj.SetCellValue(5,"xpt_imp_cd",'I',0);
	sheetObj.SetCellValue(2,"bl_tp_cd",'M',0);
	sheetObj.SetCellValue(3,"bl_tp_cd",'H',0);
	sheetObj.SetCellValue(4,"bl_tp_cd",'M',0);
	sheetObj.SetCellValue(5,"bl_tp_cd",'H',0);
	for(var i=2; i<6; i++){
		sheetObj.SetCellValue(i, "cnt_cd",ComGetObjValue(cnt_cd),0);
        sheetObj.SetCellValue(i, "loc_cd",ComGetObjValue(loc_cd),0);
	}
}
/**
 * handling after save
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet1_OnSaveEnd(sheetObj,ErrMsg) {
	ComOpenWait(false); 
	if(sheetObj.GetEtcData("mode") == "D"){
		formObj=document.form;
    	comboObjects[0].SetSelectIndex("-1");
    	comboObjects[1].SetSelectIndex("-1");
    	initSheetData(sheetObj);
        IBS_CopyRowToForm(sheetObj, formObj, 2, "expMst_");
        IBS_CopyRowToForm(sheetObj, formObj, 3, "expHus_");
        IBS_CopyRowToForm(sheetObj, formObj, 4, "impMst_");
        IBS_CopyRowToForm(sheetObj, formObj, 5, "impHus_");
//        deleteFlag=false;
	}else{
		if(document.form.menuCode.value == "C") {
            ComBtnEnable("btn_Delete");
//            deleteFlag=true;
		}
	    doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}
}
/**
 * handling sheet process
 * @param sheetObj
 * @param formObj
 * @param sAction
 * @return
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
    //sheetObj.ShowDebugMsg = false;
    switch (sAction) {
    case SEARCH01: // country code data retrieve
        formObj.f_cmd.value=SEARCH01;
        formObj.comboName.value="country"; 
        var sXml=sheetObj.GetSearchData("ESM_BKG_0926GS.do", FormQueryString(formObj));
		ComBkgXml2ComboItem(sXml, cnt_cd, "cnt_cd", "cnt_nm");
		break;
    case SEARCH02: // port code data retrieve
        formObj.f_cmd.value=SEARCH01;
        formObj.comboName.value="port"; 
        var sXml=sheetObj.GetSearchData("ESM_BKG_0926GS.do", FormQueryString(formObj));
		ComBkgXml2ComboItem(sXml, loc_cd, "port_cd", "port_nm");
    	comboObjects[1].SetSelectCode('ALL');
    	//comboObjects[1].focus();
		break;
    case IBSEARCH: // retrieve
        if (!validateForm(sheetObj,formObj,sAction)) return;
		ComOpenWait(true,true); 
        if (sheetObj.id == "sheet1")
        {   
        	checkCnt=0;
            formObj.f_cmd.value=SEARCH;
        	sheetObj.DoSearch("ESM_BKG_0926GS.do", FormQueryString(formObj) );        	
        }
        break;
    case IBSAVE:    	
        if(!validateForm(sheetObj,formObj,COMMAND01))return;
        if(!validateForm(sheetObj,formObj,IBSEARCH))return;
        if(!validateForm(sheetObj,formObj,sAction))return;
		ComOpenWait(true,true); 
    	for(var i=0; i<frmChild.length; i++){
    		if(frmChild[i].type == "hidden"){
    			var prefix=frmChild[i].name.substring(0,3);
    			if(prefix == "exp" || prefix == "imp"){
    				str=frmChild[i].name.substring(7,frmChild[i].name.length);
    	        	if(str == "frob_flg"){
    	                //var frobs=formObj.elements("frob_flg");
    	                var frobs=formObj.frob_flg;
    	                for (j=0; j<frobs.length; j++) {
    	                	if(frobs[j].checked) {
    	                		frmChild[i].value=frobs[j].value;
    	                		break;
    	                	}
    	                }
    	        	}
    			}
    		}
        }
        IBS_CopyFormToRow(formObj, sheetObj, 2, "expMst_");
        IBS_CopyFormToRow(formObj, sheetObj, 3, "expHus_");
        IBS_CopyFormToRow(formObj, sheetObj, 4, "impMst_");
        IBS_CopyFormToRow(formObj, sheetObj, 5, "impHus_");
        sheetObj.SetRowStatus(2,"U");        
        formObj.f_cmd.value=MULTI;        
        sheetObj.DoAllSave("ESM_BKG_0926GS.do", FormQueryString(formObj));        
        ComOpenWait(false); 
        break;
    case IBINSERT: // initializing    	
        IBS_CopyRowToForm(sheetObj, formObj, 2, "expMst_");
        IBS_CopyRowToForm(sheetObj, formObj, 3, "expHus_");
        IBS_CopyRowToForm(sheetObj, formObj, 4, "impMst_");
        IBS_CopyRowToForm(sheetObj, formObj, 5, "impHus_");        
    	toggleButtons("INIT");
        break;
    case IBDELETE: 
        if(!validateForm(sheetObj,formObj,COMMAND01))return;
        if(!validateForm(sheetObj,formObj,IBSEARCH))return;
        if(!validateForm(sheetObj,formObj,sAction))return;
		ComOpenWait(true); 
    	sheetObj.SetRowStatus(2,"D");
    	sheetObj.SetRowStatus(3,"D");
    	sheetObj.SetRowStatus(4,"D");
    	sheetObj.SetRowStatus(5,"D");
        if (sheetObj.id == "sheet1") {
        	//alert(sheetObj.id);
        	formObj.f_cmd.value=MODIFY;
//        	sheetObj.DoSave("ESM_BKG_0926GS.do", FormQueryString(formObj), -1, false);
        	var sXml=sheetObj.GetSaveData("ESM_BKG_0926GS.do", FormQueryString(formObj), false);
        	sheetObj.LoadSaveData(sXml);
        	break;
        }
    }
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
    switch (sAction) {
    case IBSEARCH: // retrieve
        if (comboObjects[0].GetSelectCode()== "") {
        	ComShowCodeMessage('BKG00104', "Country"); // Mandatory item is missing. Please enter ({?msg1})
        	//comboObjects[0].focus();
        	return false;
        }
        return true;
        break;
    case IBSAVE: 
//    	if(!retrieveFlag){	// can be stored after retrieve
//        	return false;
//			break;
//    	}
    	if(checkCnt < 0) {
    		ComShowCodeMessage('BKG00743'); // There is no updated data to save.
    		return false;
    	}
        return true;
        break;
    case IBDELETE: 
//    	if(!retrieveFlag){	// can be stored after retrieve
//        	ComBtnDisable("btn_Delete");
//        	return false;
//			break;
//    	}
//    	if(!deleteFlag){
//            return false;
//            break;
//    	}
        return true;
        break;
//    case COMMAND01: 
//    	for(var i=0; i<availableOfc.length; i++){
//    		if(userOfficeCode == availableOfc[i]){
//                return true;
//    			break;
//    		}
//    	}
//    	toggleButtons("READONLY");
//    	return false;
//    	break;
    }
    return true;
}

function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
	var formObj=document.form;	
    if(sheetObj.RowCount()> 0){
        IBS_CopyRowToForm(sheetObj, formObj, 2, "expMst_");
        IBS_CopyRowToForm(sheetObj, formObj, 3, "expHus_");
        IBS_CopyRowToForm(sheetObj, formObj, 4, "impMst_");
        IBS_CopyRowToForm(sheetObj, formObj, 5, "impHus_");
        for(var i=2; i<sheetObj.RowCount()+2; i++){
//        	if(i == 3){
//        		if(checkCnt > 0) {
//        			tabObjects[0].SetSelectedIndex(0);
//        		}
//        		else {
//        			tabObjects[0].SetSelectedIndex(1);
//        		}
//        	}
            for(var j=0; j<58; j++){
            	if(sheetObj.GetCellValue(i,j) == 1){
            		checkCnt++;
            	}
            }
        }
//    	if(checkCnt == 0){
//    		tabObjects[0].SetSelectedIndex(0);
//    	}        
        if(formObj.menuCode.value == "C") {
            if(validateForm(sheetObj,formObj,COMMAND01)) {
//	            deleteFlag=true;
            	ComBtnEnable("btn_Delete");
            }
        }
    }
    else{
		for(var i=0; i<frmChild.length; i++){
			if(frmChild[i].type == "checkbox"){
				frmChild[i].checked=false;
			}
    	}            	            	
		if (retrieveActFlg){  //show no data message only when user click retrieve button
			ComShowCodeMessage('BKG00889'); // No data found.            	
		}
		
    }
    tabObjects[0].SetSelectedIndex(selectedTab);

    //sheetObj.SetCellValue(3, 7, 1);
//    retrieveFlag=true;
	ComOpenWait(false); 
	initSheetData(sheetObj);
	
	retrieveActFlg=false;
}

/**
 * activating button
 * @param mode
 * @return
 */
function toggleButtons(mode) {
//	switch (mode) {
//	case "INIT":
//    	ComBtnDisable("btn_Retrieve");
//    	ComBtnDisable("btn_Save");
//    	ComBtnDisable("btn_Delete");
//		break;
//	case "READONLY":
//    	ComBtnDisable("btn_Save");
//    	ComBtnDisable("btn_Delete");
//		break;
//	}
}
