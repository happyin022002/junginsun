/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_4106.js
*@FileTitle  : Invoice Cancel Reason Entry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/18
=========================================================*/
/****************************************************************************************
   Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                  OTHER CASE : COMMAND01=11; ~ COMMAND20=30;	
 ***************************************************************************************/
    /**
     * @extends 
     * @class EES_DMT_4002 :  business script for EES_DMT_4002.
     */
	// Common Global variables
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var ROWMARK="|";
	var FIELDMARK="=";
	var IBCANCEL=51;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
    	/***** case in Sheet count are more two by Tab, defining adding sheet *****/
    	var sheetObject1=sheetObjects[0];
    	/*******************************************************/
    	var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
            	case "btn_save":
            		doActionIBSheet(sheetObject1,formObject,IBSAVE);
				break;								
				case "btn_close":
					ComPopUpReturnValue("Y");
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
        var formObject=document.form;
        doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
    }
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      // sheet1 init
                with(sheetObj){
               
		             var HeadTitle=" |SEQ|Sel.|Invoice Cancel Reason|INTG_CD_VAL_CTNT";
		             var headCount=ComCountHeadTitle(HeadTitle);
		            // (headCount, 0, 0, true);
		
		             SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		
		             var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		             var headers = [ { Text:HeadTitle, Align:"Center"} ];
		             InitHeaders(headers, info);
		
		             var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                 {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"SEQ" },
		                 {Type:"Radio",     Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"radioCheckBox",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:180,  Align:"Left",    ColMerge:0,   SaveName:"intg_cd_val_dp_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"intg_cd_val_ctnt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		              
		             InitColumns(cols);
		
		             SetEditable(1);
		             //SetSheetHeight(182);
		             SetSheetHeight(207);
             //SetGetCountPosition()(0);
                      }


                break;
        }
    }
	// Process of Sheet
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			case IBSEARCH:     // Search
				//1.Setting parametor condition, before retrieving
				if (sheetObj.id == "sheet1") {
					ComSetObjValue(formObj.f_cmd, SEARCH);
					if (validateForm(sheetObj,formObj,sAction)) {
	                    //ComOpenWait Start
	                    sheetObj.SetWaitImageVisible(0);
	                    ComOpenWait(true);
 	                    sheetObj.DoSearch("EES_DMT_4106GS.do", FormQueryString(formObj) );
	                    //ComOpenWait End
	                    ComOpenWait(false);
					}
				}
				break;
			case IBSAVE:
				ComSetObjValue(formObj.f_cmd, MULTI);
				if(!validateForm(sheetObj,formObj,sAction)) return;
				var sParam1=sheetObjects[0].GetSaveString(false);
				var sParam=sParam1+"&"+FormQueryString(formObj);
                //ComOpenWait Start
                sheetObj.SetWaitImageVisible(0);
                ComOpenWait(true);
 				var sXml=sheetObj.GetSaveData("EES_DMT_4106GS.do", sParam );
 				sheetObj.LoadSaveData(sXml,{Sync:1} );
                //ComOpenWait End
                ComOpenWait(false);
				ComSetObjValue(formObj.success_yn, ComGetEtcData(sXml, "SUCCESS_YN"));
				//Upon successful close the pop-up window
				if(ComGetObjValue(formObj.success_yn) == "Y"){
//					window.returnValue="Y";
//					ComClosePopup(); 
					ComPopUpReturnValue("Y");
				}
				break;		
		}
	}
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
        	switch(sAction) {
				case IBSAVE:
					//Selected reason do not exist
					if(sheetObj.CheckedRows("radioCheckBox") == 0) {
             			ComShowCodeMessage('DMT00173');
             			return false;
             		}
					//if Selected reason is Other(s) and  Remark is not inputed
					var chkRows=sheetObj.FindCheckedRow("radioCheckBox").split("|");
             		for(var i=0; i < chkRows.length-1; i++) {
             			var cancel_code=sheetObj.GetCellValue(chkRows[i], "intg_cd_val_ctnt");
         				if(cancel_code == 'OTH') {
         					if(ComGetObjValue(formObj.cxl_rmk) == "") {
         						ComShowCodeMessage('DMT01038');
             					return false;
         					}
         				}
             		}
				break;
        	}
        }
        return true;
    }
    /*
     * After saving message
     */
//	function sheet1_OnSaveEnd(sheetObj, code, ErrMsg) {
//		var formObj=document.form;
////		if(ErrMsg != "") {
////			ComShowCodeMessage(ErrMsg);
////		}
//        //ComOpenWait End
//        ComOpenWait(false);
//        alert(ComGetObjValue(formObj.success_yn));
//		//Upon successful close the pop-up window
////		if(ComGetObjValue(formObj.success_yn) == "Y"){ 
//		if(ComGetObjValue(formObj.success_yn) == "Y"){
//			alert("YYYYYYYY");
//			window.returnValue="Y";
//			ComClosePopup(); 
//		}
//	}
