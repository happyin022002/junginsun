/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0901.js
*@FileTitle  : Container Repor
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
 *Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					          MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					          Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	// public variable
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var callback_func = '';
		

	// Event handler processing by button click event */
	document.onclick = processButtonClick;

	// Event handler processing by button name */
    function processButtonClick(){
         /***** If sheets are more than 2 in one tab, use additional sheet variables *****/
		 var sheetObject1=sheetObjects[0];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObject1, formObject, IBSEARCH);
				break;
				case "btn_select":
					doActionIBSheet(sheetObject1, formObject, IBCOPYROW);
				//break;
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
			//initSheet
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		if(document.form.bkg_no.value != ''){
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		}
    }
  /**
     * setting sheet initial values and header
     * 
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      //sheet1 init
                with(sheetObj){
                    var HeadTitle="|Sel.|Container No|N/P|Booking No|Status|Origin YD|Dest. YD|Event Date";
                    
                    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
                    
                    var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                    var headers = [ { Text:HeadTitle, Align:"Center"} ];
                    InitHeaders(headers, info);
                    
                    var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                                 {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"sel" },
                                 {Type:"Text",      Hidden:0,  Width:90,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                                 {Type:"Text",      Hidden:0,  Width:30,  Align:"Center",  ColMerge:0,   SaveName:"cntr_bkg_atch_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                                 {Type:"Text",      Hidden:0,  Width:90,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                                 {Type:"Text",      Hidden:0,  Width:45,  Align:"Center",  ColMerge:0,   SaveName:"sts",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                                 {Type:"Text",      Hidden:0,  Width:70,  Align:"Center",  ColMerge:0,   SaveName:"org_yd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                                 {Type:"Text",      Hidden:0,  Width:70,  Align:"Center",  ColMerge:0,   SaveName:"dest_yd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                                 {Type:"Text",      Hidden:0,  Width:90,  Align:"Center",  ColMerge:0,   SaveName:"evnt_dt",           KeyField:0,   CalcLogic:"",   Format:"####.##.####:##",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
                    
                    InitColumns(cols);
                    
                    SetEditable(1);
                    SetShowButtonImage(2);
                    SetSheetHeight(200);
                }
                

                break;
        }
    }
  // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			case IBSEARCH:      //retrieve
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value=SEARCH;
 					sheetObj.DoSearch("ESM_BKG_0901GS.do", FormQueryString(formObj) );
					return true;
				}else{
					return false;
				}
			break;
			case IBCOPYROW:        //Select
				if(callback_func != ''){
					var arr=ComFindText(sheetObj, "sel", 1);
					if(arr.length==0){
						ComShowMessage(ComGetMsg("BKG01093"));
					}else if(arr.length==1){
//                        var returnVal=sheetObj.GetCellValue(arr[0], "cntr_no");
                        var returnVal=	sheetObj.GetCellValue(arr[0], "cntr_no") + "|$$| " + 
                        				sheetObj.GetCellValue(arr[0], "org_yd") + "|$$| " +
                        				sheetObj.GetCellValue(arr[0], "evnt_dt");
						//opener.setNotUpdatedContainer(returnVal);
                        if (ComFuncCheck("opener." + callback_func)) ComFunc(returnVal);
                        else if (ComFuncCheck("parent." + callback_func)) ComFunc(returnVal);
						return true;
					}else{
						ComShowMessage(ComGetMsg("BKG08040"));
					}
				}
				return false;
			break;
        }
		return true;
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
        }
        return true;
    }
