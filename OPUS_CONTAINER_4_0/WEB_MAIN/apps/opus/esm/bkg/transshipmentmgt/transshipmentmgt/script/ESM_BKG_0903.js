/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0903.js
*@FileTitle  : Next VVD Assign T/S Remark
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/10
=========================================================*/
/****************************************************************************************
 *Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					          MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					          Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// public variable
var sheetObjects=new Array();
var sheetCnt=0;
var prefix1="sheet1_";
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
    function processButtonClick(){
         /***** If sheets are more than 2 in one tab, use additional sheet variables *****/
         var sheetObject=sheetObjects[0];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
				switch(srcName) {
					case "btn_save":
						doActionIBSheet(sheetObjects[0],formObject,IBSAVE);
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
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
        }	
        sheet1_OnLoadFinish(sheetObj);
    }
	/*
	* Sheet processing to eliminate screen blinks
	 */
 	function sheet1_OnLoadFinish(sheetObj) {   
		doActionIBSheet(sheetObj,document.form,IBSEARCH);   
	}  
 	/**
     * setting sheet initial values and header
     * 
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		var sheetId=sheetObj.id;
        switch(sheetId) {
            case "sheet1":
                with(sheetObj){
	            var HeadTitle="|BKG No.";
	
	            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	            var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	            var headers = [ { Text:HeadTitle, Align:"Center"} ];
	            InitHeaders(headers, info);
	
	            var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"ibflag" },
	             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix1+"bkg_no", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	             
	            InitColumns(cols);
	            SetVisible(0);
	            SetWaitImageVisible(0);
	            SetEditable(1);
	         }
             break;
        }
    }
  // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
		var arrPreFix=sheetObj.id+"_"; 
        switch(sAction) {
          case IBSEARCH:      //retrieve
		       formObj.f_cmd.value=SEARCH;
 			   var sXml=sheetObj.GetSearchData("ESM_BKG_0903GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(arrPreFix));
			   sheetObj.LoadSearchData(sXml,{Sync:1} );
			   ComSetObjValue(formObj.ts_rmk,ComGetEtcData(sXml, "ts_rmk"));
            break;
	 	  case IBSAVE:        //save
			formObj.f_cmd.value=MULTI;  
			var params=FormQueryString(formObj);
            params=params + "&" + ComSetPrifix(sheetObj.GetSaveString(true));
 			var sXml=sheetObj.GetSaveData("ESM_BKG_0903GS.do", params);
			var State=ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
 			sheetObj.LoadSaveData(sXml);
			if(State == "S"){
				 window.returnValue="T";
				 ComClosePopup(); 
			}
		break;
        }
    }
