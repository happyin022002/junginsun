/*=========================================================
*Copyright(c) 2015 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MST_0054
*@FileTitle  : RU Label - Search Condition
*@author     : CLT
*@version    : 1.0
*@since      : 2015/02/17
=========================================================*/

var sheetObjects=new Array();
var comboObjects=new Array();
var sheetCnt=0;
var strRuType = "";
document.onclick=processButtonClick;

function processButtonClick(){
	var sheetObject=sheetObjects[0];
	 var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
			case "btn_OK":
				comPopupRuOk();
				break;
			case "btn_New":
				if ( sheetObject.RowCount()!= 0 ) {
			     	for(var i=1; i<=sheetObject.LastRow(); i++){     	
			     		sheetObject.SetCellValue(i,"checkbox","0");
			     	}
			  	}
				sheetObject.ShowTreeLevel(1,1);
				parent.document.form.hid_rulabel_type.value = "";
				parent.document.form.rstr_usg_lbl.value = "";
			break;
			case "btn_Close":
				ComClosePopup(); 
				break;
		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage('COM12111');
		} else {
			ComShowMessage(e.message);
		}
	}
}


function comPopupRuOk() {
	var sheetObj=sheetObjects[0];
	var CodeInfo = "";
	 if ( sheetObj.RowCount()!= 0 ) {
     	for(var i=1; i<=sheetObj.LastRow(); i++){
     		if(sheetObj.GetCellValue(i,"ru_label_value") != "") {
     			if(sheetObj.GetCellValue(i,"checkbox") == "1") {
     				CodeInfo = CodeInfo +","+sheetObj.GetCellValue(i,"ru_label_value");
     			}
     		}
     	}
     	
     	if(CodeInfo.substr(0,1) == ",") {
     		CodeInfo = CodeInfo.substring(1, CodeInfo.length);
     	}
  	}
	if(strRuType.substr(0,1) == ",") {
		 strRuType = strRuType.substring(1, strRuType.length);
  	}
	
	parent.document.form.hid_rulabel_type.value = strRuType;
	parent.document.form.rstr_usg_lbl.value = CodeInfo;
	ComClosePopup(); 
}


/**
 * Register IBSheet Object with array
 */
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++]=sheet_obj;
}

/**
* Setting sheets and initialization
* Implementing the onLoad event handler of body tag
* Adding the preceding function after loading page
 */
function loadPage() {
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	//initControl();	
}

/**
      * Loading the event of HTML Control <br>
 * {@link #loadPage} Initializing IBSheet Object <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     The order number of sheetObjects array
 **/
//function initControl() {
//}

/**
    * Using English character and number when onkeypress event occurs <br>
 **/
function engnum_keypress() {  
   ComKeyOnlyAlphabet('uppernum');
}

/**
 * Validating the data when onblur event occurred <br>
 **/
function obj_blur(){    
   return ComChkObjValid(event.srcElement);
}

/**
 * Removing the separator when onfocus event occurred <br>
 **/
function obj_focus(){
   ComClearSeparator(event.srcElement);
}

/**
 * Processing to be input only number when onkeypress event occurred <br>
 **/
function obj_keypress(){
   ComKeyOnlyNumber(event.srcElement);
}

/**
 * Define the initial values and headers of sheets
 * 
 * 
 */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetNo) {
	case 1:      //sheet1 init
	    with(sheetObj){
			var HeadTitle="||RU Label Value||" ;
			
	        SetConfig( { SearchMode:2, MergeSheet:5, Page:100, FrozenCol:0, DataRowMerge:1, ChildPage:10 } );
	
	        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	        var headers = [ { Text:HeadTitle, Align:"Center"} ];
	        InitHeaders(headers, info);
			
            var cols = [ {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"checkbox",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:1, Width:10,  Align:"Left",    ColMerge:0,   SaveName:"id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
	                     {Type:"Text",      Hidden:0, Width:110,  Align:"Left",    ColMerge:0,   SaveName:"name",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   TreeCol:1 ,  LevelSaveName:"level"  },
	                     {Type:"Text",      Hidden:1, Width:10,  Align:"Left",    ColMerge:0,   SaveName:"ru_label_type",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1, Width:10,  Align:"Left",    ColMerge:0,   SaveName:"ru_label_value",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
	               
			InitColumns(cols);
			SetEditable(1);
            //sheetObj.SetRowHidden(0,1);
            ShowTreeLevel(2);
			//SetSheetHeight(450);
			resizeSheet();
        }
		break;
	}
}

function resizeSheet(){
  	   ComResizeSheet(sheetObjects[0]);
}
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
		case IBSEARCH:      //Retrieve
			sheetObj.SetWaitImageVisible(0);
 			ComOpenWait(true);			
 			formObj.f_cmd.value=SEARCH;
 			sheetObj.DoSearch("EES_MST_0054GS.do", FormQueryString(formObj) );
 			ComOpenWait(false);
			break;
	}
}

/**
 * handling click event on sheet1.
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 * @return
 */
function sheet1_OnClick(sheetObj,Row, Col, Value){
	var chkYN = false;
	for(var i=1; i<=sheetObj.LastRow(); i++){
		chkYN = false;
		if (sheetObj.GetRowLevel(i) == "1"){
			if(sheetObj.GetCellValue(i,"checkbox") == 1) {
			}else{
				for(var j=i; j<=sheetObj.GetChildNodeCount(i)+i; j++){
					if(sheetObj.GetCellValue(j,"checkbox") == "1") {
						chkYN = true;
						break;
					}
				}
				if(chkYN == false) {
				sheetObj.SetRowExpanded(i,0);
				}
			}
		}
	}
}

/*function sheet1_OnChange(sheetObj,Row, Col, Value){
	//if(sheetObj.ColSaveName(Col) == "ru_label_value"){
	//	strRuType = strRuType+","+sheetObj.GetCellText(Row,"ru_label_type");
	//}
}*/
/**
 * setting combo of operation office.
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 * @return
 */
//function cellSetItems(sheetObj, Row, Col, Value){
//	var formObj=document.form;
//	sheetObjects[0].SetWaitImageVisible(0);
//    form.f_cmd.value=SEARCH02;
//    var ruLabelType=Value;
//	var param="&ru_label_type="+ruLabelType;
//	var sXml=sheetObjects[0].GetSearchData("EES_MST_0051GS.do", FormQueryString(formObj)+param);
//	var chk=sXml.indexOf("ERROR");
//	if (sXml.indexOf("ERROR") != -1 || sXml.indexOf("Error") != -1){
//		 sheetObjects[0].LoadSearchData(sXml,{Sync:1} );
//		 return;
//	}	             
//	sheetObjects[0].SetWaitImageVisible(1);
//    var rstr_usg_tblnm=ComGetEtcData(sXml,"rstr_usg_tblnm");
//    if(rstr_usg_tblnm != ""){
//		var TblNmList="";
//		var strRstrUsgTblNm=rstr_usg_tblnm.split("@");
//		for(var i=0; i < strRstrUsgTblNm.length;i++){ 
//			var code=strRstrUsgTblNm[i];
//			TblNmList=TblNmList + code + "|";
//		}
//		TblNmList=TblNmList.substring(0, TblNmList.length - 1);
//		sheetObjects[0].CellComboItem(Row,Col, {ComboText:TblNmList, ComboCode:TblNmList} );
//	}else{
//		sheetObjects[0].CellComboItem(Row,Col, {ComboText:" ", ComboCode:" "} );
//	}
//}


/**
 * calling event after retrieving Sheet
 * @param sheetObj
 * @param ErrMsg
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	sheetObjects[0].ShowTreeLevel(1,1);
	var formObj=document.form;
	var strHidRuLabeType = formObj.par_rulabel_type.value;
	var strHidRuLabeValue = ComToHtml1(formObj.par_rstr_usg_lbl.value);
	var strHidRuLabeArr = strHidRuLabeValue.split(",");
	//ru_label_type_desc
	var k = 0 ;
	
	if ( sheetObj.RowCount()!= 0 ) {
		var sheetRuTypeValue = "";
		var strAllHidRuLabeValue = ","+strHidRuLabeValue;
		if(strHidRuLabeValue != "") {
			sheetObj.ShowTreeLevel(-1);
			var chkYN = false;
	     	for(var i=1; i<=sheetObj.LastRow(); i++){    
	     		sheetRuTypeValue = sheetObj.GetCellValue(i,"ru_label_type");     
	     		
	     		if(sheetObj.GetCellValue(i,"ru_label_value") != "") {
	     			sheetObj.SetCellEditable(i,"checkbox","1");
	     			sheetObj.SetCellBackColor(i, "ru_label_type_desc", "#FFFFFF");
	     			sheetObj.SetCellBackColor(i, "ru_label_value", "#FFFFFF");
	     		}else{
	     			if(sheetObj.GetChildNodeCount(i) == 0) {
	     				sheetObj.SetCellEditable(i,"checkbox","0");
	     				sheetObj.SetCellBackColor(i, "checkbox", "#F2F4F4");
	     			}
	     		}
	     		
	     		if(strAllHidRuLabeValue.indexOf(sheetObj.GetCellValue(i,"ru_label_value")) > 0) {
	     			if(sheetObj.GetCellValue(i,"ru_label_value") == strHidRuLabeArr[k]) {
	     				sheetObj.SetCellValue(i,"checkbox","1");
	     			}
	     			k=k+1;
	     		}else{
	     			sheetObj.SetCellValue(i,"checkbox","0");	     			
	     		}
	     		
	     		
	     	}
		}else{
			for(var i=1; i<=sheetObj.LastRow(); i++){    
	     		sheetRuTypeValue = sheetObj.GetCellValue(i,"ru_label_type");      
	     		if(sheetObj.GetCellValue(i,"ru_label_value") != "") {
	     			sheetObj.SetCellEditable(i,"checkbox","1");
	     			sheetObj.SetCellBackColor(i, "ru_label_type_desc", "#FFFFFF");
	     			sheetObj.SetCellBackColor(i, "ru_label_value", "#FFFFFF");
	     		}else{
	     			if(sheetObj.GetChildNodeCount(i) == 0) {
	     				sheetObj.SetCellEditable(i,"checkbox","0");
	     				sheetObj.SetCellBackColor(i, "checkbox", "#F2F4F4");
	     			}
	     		}
	     		
	     		
	     		if(strAllHidRuLabeValue.indexOf(sheetObj.GetCellValue(i,"ru_label_value")) > 0) {
	     			if(sheetObj.GetCellValue(i,"ru_label_value") == strHidRuLabeArr[k]) {
	     				sheetObj.SetCellValue(i,"checkbox","1");
	     			}
	     			k=k+1;
	     		}else{
	     			sheetObj.SetCellValue(i,"checkbox","0");
	     		}
	     	}
		}
		
		expendChk();
  	}
	
}


function expendChk() {
	var chkYN = false;
	for(var i=1; i<=sheetObjects[0].LastRow(); i++){
		chkYN = false;
		if (sheetObjects[0].GetRowLevel(i) == "1"){
			if(sheetObjects[0].GetCellValue(i,"checkbox") == 1) {
			}else{
				for(var j=i; j<=sheetObjects[0].GetChildNodeCount(i)+i; j++){
					if(sheetObjects[0].GetCellValue(j,"checkbox") == "1") {
						chkYN = true;
						break;
					}
				}
				if(chkYN == false) {
					sheetObjects[0].SetRowExpanded(i,0);
				}
			}
		}
	}
}

/**
 * 인자로 받은 문자열 중 HTML에서 특수문자를 변환문자로 바꿔서 결과를 리턴한다. <br>
 * @param {string,object} obj   필수,문자열 또는 HTML태그(Object)
 * @returns string <br>
 */
function ComToHtml1(obj){
    try {
        //첫번째 인자가 문자열 또는 HTML태그(Object)인 경우 처리
        var str = getArgValue(obj);

        str = str.replace(/@amp;/gi, "&");
        return str;
    } catch(err) { ComFuncErrMsg(err.message); }
}


/**
 * 인자로 받은 문자열 중 HTML에서 특수문자를 변환문자로 바꿔서 결과를 리턴한다. <br>
 * @param {string,object} obj   필수,문자열 또는 HTML태그(Object)
 * @returns string <br>
 */
//function ComToHtml2(obj){
//    try {
//        //첫번째 인자가 문자열 또는 HTML태그(Object)인 경우 처리
//        var str = getArgValue(obj);
//
//        str = str.replace('&','@amp;');
//        return str;
//    } catch(err) { ComFuncErrMsg(err.message); }
//}



var checkLevel=0 ;
function sheet1_OnChange( sheetObj , Row , Col , Value)
{   
   // if ( Value == "0") return;
    //checking ALL checkBox
    if(sheetObj.GetRowLevel(Row) == "0"){
    	sheetObj.ShowTreeLevel(-1);   
		for(var i=1; i<=sheetObj.LastRow(); i++){
			if(sheetObj.GetRowLevel(i) == "2"){
				/*sheetObj.SetCellValue(i,"checkbox", "1", 0);
			}else{
				sheetObj.SetCellValue(i,"checkbox", "0", 0);*/
				if(sheetObj.GetCellValue(Row,"checkbox") == "1") {
					sheetObj.SetCellValue(i,"checkbox", "1", 0);			
				}else{
					sheetObj.SetCellValue(i,"checkbox", "0", 0);	
				}
			}
		}
    } 
    
    
    if (sheetObj.GetRowLevel(Row) == "1"){
    	if(sheetObj.GetChildNodeCount(Row) != 0) {
	    	sheetObj.ShowTreeLevel(-1);   
	    	
			for(var i=Row; i<=sheetObj.GetChildNodeCount(Row)+Row; i++){
				
				if(sheetObj.GetRowLevel(i) == "2"){
					if(sheetObj.GetCellValue(Row,"checkbox") == "1") {
						sheetObj.SetCellValue(i,"checkbox", "1", 0);			
					}else{
						sheetObj.SetCellValue(i,"checkbox", "0", 0);	
					}
				}else{
					//sheetObj.SetCellValue(i,"checkbox", "0", 0);
					/*if(sheetObj.GetCellValue(Row,"checkbox") == "0") {
						sheetObj.SetCellValue(Row,"checkbox", "1", 0);
					}else{
						sheetObj.SetCellValue(Row,"checkbox", "0", 0);
					}*/
				}
			}
    	}
    }    
   
    /*var chkDepth = "2";
   // chkDepth값이 존재한다면, 특정 Depth만 선택 가능하도록 해야 한다.
    if(chkDepth != "" && chkDepth != null) {
        var intChkDepth=0;
        try {
            intChkDepth=parseInt(chkDepth); // + 1;
        } catch(e) {
            intChkDepth=0;            
        }
        if ( intChkDepth != sheetObj.GetRowLevel( Row) )
        {
            sheetObj.SetCellValue(Row,"checkbox","0",0);
        }
    } else {
        if( sheetObj.ColSaveName(Col) == "checkbox")
        {
            if (sheetObj.CheckedRows("checkbox") != "1" )
            {
                if ( checkLevel != sheetObj.GetRowLevel( Row))
                {
                    sheetObj.SetCellValue(Row,"checkbox","0",0);
                }
            } else {
                checkLevel=sheetObj.GetRowLevel(Row);
            }
        }
    }*/
}
