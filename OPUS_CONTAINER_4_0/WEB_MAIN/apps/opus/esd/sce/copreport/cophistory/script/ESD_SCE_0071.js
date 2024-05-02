/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_0071.js
*@FileTitle  : COP Main Search 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

var sheetObjects=new Array();
var sheetCnt=0;
/* Event handler processing by button click event */
document.onclick=processButtonClick;

// Event handler processing by button name
function processButtonClick(){
	 var sheetObj=sheetObjects[0];
	 var formObj=document.form;
	try{
		var srcName=ComGetEvent("name");
		switch(srcName) {
			case "btn_retrieve":
				if(validateForm(sheetObj, formObj, IBSEARCH)){
					doActionIBSheet(sheetObj,formObj,IBSEARCH);
				}
				break;
			case "btn_new":
				sheetObj.RemoveAll();
				formObj.reset();
				break;
			case "btn_downexcel":
				doActionIBSheet(sheetObj,formObj,IBDOWNEXCEL);
				break;
			case "btn_close":
				ComClosePopup(); 
				break;
		}
	}catch(e){
		if( e == "[object Error]") {
			ComShowMessage(ComGetMsg('COM12111')) ;
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
function loadPage() {
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
}

/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:	  //IBSheet1 init
		    with(sheetObj){
				var HeadTitle0="SEQ|COP No.|CNTR No.|BKG No.|Event|Event Date|Tp/Sz|Master|MST COP NO|BKG Status|COP Status|RCV Term|O/B Route|Oecan Route|I/B Route|Del Term|User ID|Unmatched" ;
				var HeadTitle1="SEQ|COP No.|CNTR No.|BKG No.|Event|Event Date|Tp/Sz|Master|MST COP NO|BKG Status|COP Status|RCV Term|O/B Route|Oecan Route|I/B Route|Del Term|User ID|Unmatched" ;

				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:5, DataRowMerge:1 } );

				var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle0, Align:"Center"},
	                  { Text:HeadTitle1, Align:"Center"} ];
				InitHeaders(headers, info);

				var cols = [ {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"cop_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"event",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"cre_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"mst_lcl_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"mst_cop_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bkg_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cop_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"r_term",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"ob_route",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:320,  Align:"Center",  ColMerge:1,   SaveName:"ocn_route",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"ib_route",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"d_term",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"umch_sts_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"totcnt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	       
				InitColumns(cols);

				SetEditable(0);
//				SetSheetHeight(350);
				resizeSheet(); 
			}
		    break;
	}
}

// handling sheet process
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false );
	switch(sAction) {
		case IBSEARCH:	  
			formObj.page_no.value="1";		
			formObj.f_cmd.value=SEARCHLIST ;
			sheetObj.DoSearch("ESD_SCE_0071GS.do", FormQueryString(formObj) );
			break;
        case IBDOWNEXCEL:
        	if(sheetObj.RowCount() < 1){//no data
				ComShowCodeMessage("COM132501");
			}else{
				sheetObj.Down2Excel({ HiddenColumn:true,Merge:true});
			}
			break;
 		
    }
}

/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
    var result=true;
	if(sAction == IBSEARCH) {
		if( !isInputField(formObj) ) {
			result=false ;
	    } 
	}
	return result;
}

function isInputField(formObj){
	var result=false ;
	var fieldType=null ;
	for(i=0; i<formObj.length; i++){
		fieldType=formObj[i].type
		if((fieldType=="checkbox" || fieldType=="radio")){
			if(formObj[i].checked){
				result=true ;
				break ;
			}
		}
		else if(fieldType!="hidden" && !formObj[i].readOnly){
			if(!ComIsEmpty(formObj[i])){
				result=true ;
				break ;
			}
		}
	}
	if(!result){
		ComShowMessage(ComGetMsg('SCE90016')) ;
        formObj.bkg_no.focus() ;
	}
	return result ;
}

function sheet1_OnSearchEnd(sheetObj) {
	var totalCnt=sheetObj.GetCellValue(3, "totcnt");
	if(sheetObj.GetTotalRows()> 0){
		sheetObj.SetTotalRows(totalCnt);
	}
}

//method change[check again]CLT function sheet1_OnScrollNext(sheetObj,CondParam, PageNo, OnePageRow){
var iPageNo = 1;
function sheet1_OnVScroll(sheetObj, vpos, oldvpos, isTop, isBottom) {
    if (!isBottom || sheetObj.RowCount() >= sheetObj.GetTotalRows()) return;
	var formObj=document.form ;
	selectVal=SceFrmQryString(formObj);
//method change[check again]CLT
	sheetObj.DoSearch("ESD_SCE_0071GS.do", selectVal+"&"+ "cur_page=" + PageNo,{Append:true} );
}

function ChkObjValid(obj, len, msg) {
	var result=true ;
	if(obj.value.length!==len){
		ComShowMessage(ComGetMsg('SCE90026', msg, len));
        obj.focus() ;
        result=false ;
	}
	return result ;
}

function onEnterKey(textname) {
	if (event.keyCode == 13) {
		var formObj=document.form;
		if( validateForm(formObj) ) {
			formObj.f_cmd.value="" ;
		}
	}
}

function CheckDigit(obj){
    var rtnval=cntrCheckDigit(obj);
    obj.value=rtnval;
}

function CheckDigitSplit( obj, bitTarget, valueTarget){
	var cntrNo=obj.value;
	if (cntrNo.length < 10){
		document.getElementById(bitTarget).value='';
		document.getElementById(valueTarget).value=cntrNo;
		return;
	}
	ChkObjValid(obj, 10, 'eng_num');
	var sum=0;
 	cntrNo=cntrNo.toUpperCase();
	sum=ComGetCntrChkDgt( cntrNo.substr(0,10));
	var mod=sum % 11;
	if (mod == 10) mod=0;
	if( isNaN(mod)){
		document.getElementById(bitTarget).value='';
		document.getElementById(valueTarget).value=obj.value;
	}else{
		obj.value=cntrNo.substr(0,10);		
		document.getElementById(bitTarget).value=mod;
		document.getElementById(valueTarget).value=obj.value + mod;
	}
}
function resizeSheet(){
    ComResizeSheet(sheetObjects[0]);
} 