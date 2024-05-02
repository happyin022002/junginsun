/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1097.js
*@FileTitle  : ESM_BKG_1097
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/01
=========================================================*/
   	/* Developer Work	*/
    // global variable
    var sheetObjects=new Array();
    var sheetCnt=0;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
          /***** using extra sheet valuable if there are more 2 sheets *****/
          var sheetObject=sheetObjects[0];
          /*******************************************************/
          var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
 				switch(srcName) {
					case "btn_Retrieve":
	 					doActionIBSheet(sheetObject, formObject, IBSEARCH);
						break;
					case "btn_Save":
	                	doActionIBSheet(sheetObject,formObject,IBSAVE);
						break;
 					case "btn2_Delete":
 						doActionIBSheet(sheetObject,formObject,IBDELETE);
						break;
 					case "btn2_RowAdd":
	                	doActionIBSheet(sheetObject,formObject,IBINSERT);
						break;
					case "btn_Select":
 						doActionIBSheet(sheetObject,formObject,COMMAND01);
 						break;
 					case "btn_Close":
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
     	axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
     	axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
    	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
     }
   /**
      * setting sheet initial values and header
      * param : sheetObj, sheetNo
      * adding case as numbers of counting sheets
      */
     function initSheet(sheetObj,sheetNo) {
        var cnt=0;
 		var sheetId=sheetObj.id;
         switch(sheetId) {
             case "sheet1":
                 with (sheetObj) {
                 var HeadTitle1="|Sel.|seq|Feeder Lloyd Code|Feeder Vessel Name|SEQ_KEY";
                 var headCount=ComCountHeadTitle(HeadTitle1);
                 var prefix="sheet1_";
                 SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
                 var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                 var headers = [ { Text:HeadTitle1, Align:"Center"} ];
                 InitHeaders(headers, info);
                 var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
                        {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:prefix+"fdr_vsl_lloyd_no", KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
                        {Type:"Text",      Hidden:0,  Width:0,    Align:"Left",    ColMerge:1,   SaveName:prefix+"fdr_vsl_nm",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:1,   SaveName:prefix+"seq_key",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
                 InitColumns(cols);
                 SetEditable(1);
                 SetWaitImageVisible(0);
	             DataInsert(-1);
	             SetSheetHeight(190);
 			}
 			break;
         }
     }
   // handling sheet process
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
 			case IBSEARCH:		//Retrieve
 				//if(!validateForm(sheetObj,formObj,sAction)) return false;
 				ComOpenWait(true);
				formObj.f_cmd.value=SEARCH;
				sheetObj.DoSearch("ESM_BKG_1097GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_") );
 				ComOpenWait(false);
 				break;
 			case IBINSERT:      // grid add(insert)
				sheetObj.DataInsert(-1);
				break;
    	    case IBSAVE:        //save
    	    	if(!validateForm(sheetObj,formObj,sAction)) return false;
    	    	ComOpenWait(true);
    	    	formObj.f_cmd.value=MULTI;
				sheetObj.DoSave("ESM_BKG_1097GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
				ComOpenWait(false);
				break;
 			case IBDELETE:		// row delete
 				if(!validateForm(sheetObj,formObj,sAction)) return false;
 				if(ComShowCodeConfirm('BKG03037')){
                	ComRowHideDelete(sheetObj,"sheet1_del_chk");
                	sheetObj.CheckAll("sheet1_del_chk",0,1);
				}
 				break;
    	    case COMMAND01 :
    	    	if(!validateForm(sheetObj,formObj,sAction)) return false;
    	    	sheet1_OnDblClick(sheetObj, sheetObj.GetSelectRow());
    	    	break;
         }
     }
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
    	var sheet1RowCnt=sheetObj.RowCount();
  	    switch(sAction) {
			case IBSEARCH: { // Retrieve
    			//if (!ComChkValid(formObj)) return false;
				break;
			}
			case IBSAVE: {
				if(sheet1RowCnt == 0) {
					ComShowCodeMessage('BKG00095');
					return false;
				}
				break;
			}
			case IBDELETE : {
				if(sheet1RowCnt == 0) {
					ComShowCodeMessage('BKG00095');
					return false;
				}
				var checkedCnt=0;
				for(var i=1; i <= sheet1RowCnt; i++) {
					if(sheetObj.GetCellValue(i,"sheet1_del_chk") == "1") {
						checkedCnt++;
					}
				}
				if(checkedCnt == 0) {
					ComShowCodeMessage("BKG00546");
					return false;
				}
				break;
			}
			case COMMAND01 :
				if(sheet1RowCnt == 0 || (sheet1RowCnt == 1 && (sheetObj.GetCellValue(sheetObj.GetSelectRow(),"sheet1_fdr_vsl_lloyd_no") == "" || sheetObj.GetCellValue(sheetObj.GetSelectRow(),"sheet1_fdr_vsl_nm") == ""))) {
//					ComShowCodeMessage('BKG00095');
					ComShowCodeMessage('BKG95001','select valid row which has Code & Name','');
					return false;
				}
				break;
  	    }
	    return true;
     }
     /**
      * Dbl Click Event
      * @param sheetObj
      * @param Row
      * @param Col
      * @return
      */
     function sheet1_OnDblClick(sheetObj,Row,Col) {
//    	var pageType=document.form.pageType.value;
//    	if(pageType != "MAIN") {
//			var obj=new Object(); 
//			obj.cd=sheetObj.GetCellValue(Row, "sheet1_fdr_vsl_lloyd_no");
//			obj.nm=sheetObj.GetCellValue(Row, "sheet1_fdr_vsl_nm");
//			if(obj.cd !="" && obj.nm != "") {
//				window.returnValue=obj;
//				ComClosePopup(); 
//			}
//    	}
		var obj=new Object(); 
		obj.fdr_vsl_lloyd_no = sheetObj.GetCellValue(Row, "sheet1_fdr_vsl_lloyd_no");
		obj.fdr_vsl_nm = sheetObj.GetCellValue(Row, "sheet1_fdr_vsl_nm");
		
   		var callFunc=ComGetObjValue(document.form.func);
    	if(!opener) opener=window.dialogArguments;
    	if(!opener) opener=parent;
    	eval('opener.'+callFunc)(obj);
  		ComClosePopup(); 
     }
	/**
	 * Save End Event
	 * @param sheetObj
	 * @param ErrMsg
	 * @return
	 */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
		sheetObj.CheckAll("sheet1_del_chk",0);
		if (ErrMsg == "") {
	    	if (document.form.f_cmd.value == MULTI) {
				ComShowCodeMessage('BKG00102');
				doActionIBSheet(sheetObj, document.form, IBSEARCH); // retrieve
			}
		} 
    }
    /**
     * when enter retrieve creteria, handling
     */
    function obj_KeyUp() {
    	var formObject=document.form;
    	var srcName=ComGetEvent("name");
    	var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
    	var srcValue=window.event.srcElement.getAttribute("value");
    	if (srcName == "fdr_vsl_lloyd_no" && ComChkLen(srcValue, srcMaxLength) == "2") {
    		ComSetNextFocus();
    	}
    }
    /**
     * Search End Event
     * @param sheetObj
     * @param ErrMsg
     * @return
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		sheetObj.CheckAll("sheet1_del_chk",0);
    	if(sheetObj.RowCount()== 0) {
    		ComShowCodeMessage('BKG00095');
    		sheetObj.DataInsert(-1);
    	}
    }
	/* Developer Work End */
