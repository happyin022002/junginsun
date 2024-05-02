/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1077.js
*@FileTitle  : Rating Application Date Search 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/
=========================================================
*/
/****************************************************************************************
Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends 
 * @class esm_bkg_1077 :business script for esm_bkg_1077
 */
function esm_bkg_1077() {
	this.processButtonClick=tprocessButtonClick;
	this.setSheetObject=setSheetObject;
	this.loadPage=loadPage;
	this.initSheet=initSheet;
	this.initControl=initControl;
	this.doActionIBSheet=doActionIBSheet;
	this.setTabObject=setTabObject;
	this.validateForm=validateForm;
}
//common global variables
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event
document.onclick=processButtonClick;
//Event handler processing by button name */
    function processButtonClick(){
		var sheetObject1=sheetObjects[0];
		/*******************************************************/
		var formObject=document.form;
		try {
    		var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
                case "btn1_Apply":
                	var rApply_dt="";
                	if(ComGetObjValue(form.apply_dt) == ''){
                		ComShowCodeMessage("BKG00442");
                	} else {
                		 
                		if((formObject.bdrflag.value =="N")|(formObject.bdrflag.value =="Y" && formObject.caflag.value == "Y")){
                			rApply_dt=ComGetObjValue(form.apply_dt);
                		}
                	}
                	
                	if(rApply_dt!=null && rApply_dt.length > 1 ){
                		ComPopUpReturnValue(rApply_dt);                		
                	}else{
                		ComClosePopup(); 
                	}
					break;
                case "btn1_Close":
                	ComClosePopup(); 
                    break; 
                case "btn1_New":
					alert(srcName);
                    break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			alert("An unknown error occurred(in JavaScript source). Please verify your entry and try again. If the problem persists, please contact your system administrator.");
    		} else {
    			alert(e);
    		}
    	}
    }
	/**
	 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items 
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
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        options.innerHTML = "Application Date - CRD : From or to US, CA, Latin America";
        options2.innerHTML="ETD of 1st VVD : The other bookings";
        doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
    }
	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
    	var sheetID=sheetObj.id;
    	switch (sheetID) {
            case "sheet1": 
                with(sheetObj){
		              var HeadTitle1="|Booking No.|1st VVD|POL|ETB|ETD";
		              var headCount=ComCountHeadTitle(HeadTitle1);
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		              InitHeaders(headers, info);
		              var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		                     {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"first_vvd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"etb",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"etd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		              InitColumns(cols);
		              SetEditable(1);
		              SetCountPosition(0);
                    }
                break;
                
            case "sheet2": 
                with(sheetObj){
	                  var HeadTitle1="|Container No|1st OC CY|1st OC Date(CRD)";
	                  var headCount=ComCountHeadTitle(HeadTitle1);
	                  SetConfig( { SearchMode:2, MergeSheet:2, Page:20, DataRowMerge:1 } );
	                  var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	                  var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	                  InitHeaders(headers, info);
	                  var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	                         {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"cntr_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                         {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"oc_cy",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                         {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"oc_date",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                         {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                         {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"first_vvd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                         {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"pol_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                         {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"etb",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                         {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"etd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                         {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"apply_dt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	                  InitColumns(cols);
	                  SetEditable(1);
	                  SetSheetHeight(160);
	                  SetCountPosition(0);
                    }
            break;
        }
    }
    
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			case IBSEARCH:      // retrieve
				ComSetObjValue(formObj.f_cmd, SEARCH);
				sheetObj.DoSearch("ESM_BKG_1077GS.do",FormQueryString(formObj) );
				pagedMaxCnt=sheetObj.HeaderRows();//색상 변경을 위한 변수 초기화
			break;
			case IBSAVE:        // save
          		if(validateForm(sheetObj,formObj,sAction))
			break;
			case IBINSERT:      // insert
			break;
        }
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
        }
        return true;
    }
    function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
      	  with(sheetObj)
      	    var formObj=document.form;
      	  	var cnt_row=sheetObj.GetTotalRows();
      	  	var sheetObj1=sheetObjects[0];
      	  	var sheetObj2=sheetObjects[1];
      	  	var newRow=sheetObj1.DataInsert(-1);
      	  	if(cnt_row > 0){
				sheetObj1.SetCellValue(newRow,"bkg_no",sheetObj2.GetCellValue(1,"bkg_no"));
				sheetObj1.SetCellValue(newRow,"first_vvd",sheetObj2.GetCellValue(1,"first_vvd"));
				sheetObj1.SetCellValue(newRow,"pol_cd",sheetObj2.GetCellValue(1,"pol_cd"));
				sheetObj1.SetCellValue(newRow,"etb",sheetObj2.GetCellValue(1,"etb"));
				sheetObj1.SetCellValue(newRow,"etd",sheetObj2.GetCellValue(1,"etd"));
				ComSetObjValue(formObj.apply_dt,sheetObj2.GetCellValue(1,"apply_dt"));
      	  	}
      	  	if(sheetObj2.GetCellValue(newRow,"cntr_no") ==''){
      	  		sheetObj2.SetCellValue(newRow,"cntr_no",'There is no data search');
      	  		sheetObj2.SetCellValue(newRow,"oc_cy",'There is no data search');
      	  		sheetObj2.SetCellValue(newRow,"oc_date",'There is no data search');
      	  		sheetObj2.SetMergeCell(1,1,1,3);
      	  	}
        }       