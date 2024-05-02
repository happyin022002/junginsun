/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0179.js
*@FileTitle  : BL Clause Remark Pop-upn
*@author     : CLT
*@version    : 1.0
*@since      : 2015/03/19
=========================================================*/

	/**
	 * registering IBSheet Object as list
	 * adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	 */
	var sheetObjects=new Array();
	var sheetCnt=0;
	var prefix="sheet1_";

	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	 
	/**
	 * initializing sheet
	 * implementing onLoad event handler in body tag
	 * adding first-served functions after loading screen.
	 */
	function loadPage() {
		for(var i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}	
		doActionIBSheet(sheetObjects[0],form,IBSEARCH);
	}
 
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick(){
		/***** using extra sheet valuable if there are more 2 sheets *****/
        var sheetObject1=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form;
        try {
     		var srcName=ComGetEvent("name");
     		switch(srcName) {
     			case "btn_Apply":
     				var old_rmk = ComGetObjValue(formObject.rmk);
     				setRemark();
     				if(!validateForm(sheetObject1,formObject,"btn_Apply")){
     					ComSetObjValue(formObject.rmk, old_rmk);
     				}
					break;
 				case "btn_Save":
 					if(validateForm(sheetObject1,formObject,"btn_Save")){
 						custPooupOK(formObject);
 					}
 					break;
 				case "btn_close":
 					ComClosePopup(); 
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
     * handling sheet process
     * @param sheetObj
     * @param formObj
     * @param sAction
     * @return void
     */
	function doActionIBSheet(sheetObj,formObj,sAction,Row,Col,PageNo) {
		switch(sAction) {
			case IBSEARCH:      //retrieve
				formObj.f_cmd.value=SEARCH;
				var sXml=sheetObj.GetSearchData("ESM_BKG_0179GS.do", FormQueryString(formObj));
				sheetObj.LoadSearchData(sXml);
			break;
		}
	}
	
	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
		var formObj = document.form;
		if(sheetObj.RowCount()>0){
			ComSetObjValue(formObj.cnt, sheetObj.GetCellValue(1,"cnt"));
			ComSetObjValue(formObj.cus, sheetObj.GetCellValue(1,"cus"));
			ComSetObjValue(formObj.rmk, sheetObj.GetCellValue(1,"rmk"));
		}
	}
	
	function setRemark(){
		var formObj = document.form;
		
		//특수문자 제거 로직 추가
//		var rmk = ComGetObjValue(formObj.rmk);
		var std = chekcSpecialValue(ComGetObjValue(formObj.std));
		var cnt = chekcSpecialValue(ComGetObjValue(formObj.cnt));
		var cus = chekcSpecialValue(ComGetObjValue(formObj.cus));
		
		// 배열 선언
		var arrStr = new Array(std, cnt, cus);
		
		var addRmk = "";
		var lastCnt = 0;
		//last index search
		for(var i=0; i< arrStr.length; i++){
			if(arrStr[i] != "")	lastCnt = i;
		}
		
		for(var i=0; i< arrStr.length; i++){
			if(arrStr[i]!=""){
				if(i == lastCnt){
					addRmk += arrStr[i];
				}else{
					addRmk += arrStr[i]+"\n";
				}
			}
		}
		ComSetObjValue(formObj.rmk, addRmk);
	}

	function custPooupOK(formObj) {
		//특수문자 제거 로직 추가
		var retStr=chekcSpecialValue(formObj.rmk.value);
		
		if(callbackMethod == null){
			ComClosePopup(); 
		}else{
			callbackMethod(retStr);
			ComClosePopup(); 
		}
	}
    /**
     * setting sheet initial values and header
     * @param sheetObj
     * @param sheetNo
     * @return
     */
    function initSheet(sheetObj,sheetNo) {
    	switch(sheetObj.id) {
    		case "sheet1":
    			with(sheetObj){
	            	var HeadTitle="|Standard|Country|Customer|Remark";
	            	var headCount=ComCountHeadTitle(HeadTitle);
		
	            	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
	            	var info = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	            	var headers = [ { Text:HeadTitle, Align:"Center"} ];
	            	InitHeaders(headers, info);

	            	var cols = [ {Type:"Status",    Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	            	             {Type:"Text",      Hidden:0, Width:130,  Align:"Center",  ColMerge:0,   SaveName:"std" },
	            	             {Type:"Text",      Hidden:0, Width:130,  Align:"Center",  ColMerge:0,   SaveName:"cnt" },
	            	             {Type:"Text",      Hidden:0, Width:130,  Align:"Center",  ColMerge:0,   SaveName:"cus" },
	            	             {Type:"Text",      Hidden:0, Width:130,  Align:"Center",  ColMerge:0,   SaveName:"rmk" } ];
       
	            	InitColumns(cols);
	            	SetEditable(1);
	            	SetVisible(1);
	            	SetSheetHeight(400);
    			}
    		break;
    	}
    }
    
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
		//2015.04.07 kimtaekyun checking input length
        switch(sAction) {
            case "btn_Save":
            	if( ComChkLenByByte(ComGetObjValue(formObj.rmk), 4000) == 0){
                    ComShowCodeMessage("COM12142","Remark","4000");
                    return false;
                }
			break;
            case "btn_Apply":
            	if( ComChkLenByByte(ComGetObjValue(formObj.rmk), 4000) == 0){
                    ComShowCodeMessage("COM12142","Remark","4000");
                    return false;
                }
			break;
		}
        return true;
    }
    
    /*
     * KEY UP 이벤트 처리
     */
    function checkUpdate(obj){
    	var updateString = checkSpecial(obj);	//특수문자 제외 로직
    }

    /*
     * MOUSE PASTE 이벤트
     */
    function mousePaste(obj){
    	setTimeout(function(){
        	var updateString = checkSpecial(obj);	//특수문자 제외 로직
    	}, 100)
    }    
