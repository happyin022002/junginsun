/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0969.js
*@FileTitle  : ESM_BKG_0969
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/04
=========================================================*/
/****************************************************************************************
  Event Code: 	[Initializing]INIT=0; [Insert]ADD=1; [Retrieve]SEARCH=2; [List retrieve]SEARCHLIST=3;
				[Modify]MODIFY=4; [Remove]REMOVE=5; [List remove]REMOVELIST=6 [Multi process]MULTI=7
				[Constant]  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ESM_BKG_0969 : Defining logic script for ESM_BKG_0969 screen
     */
    /* Global Variables */
    var sheetObjects=new Array();
    var sheetCnt=0;
    /* Event handler defined process to button click event */
	document.onclick=processButtonClick;
	/* Event handler is branch processing by name of button */
    function processButtonClick(){
    	  /***** Assignment sheet in case of over 2 by tab****/
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
     * Register as an IBSheet Object array
     * This is called from comSheetObject(id)
     * Process can add in case of future necessity to process other items
     * Array defined at the top of the source
     */
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
     }
     /**
      * Initializing sheet
      * To implement onLoad event of body tag
      * Add functionality to after loading screen.
      */
     function loadPage() {
         for(i=0;i<sheetObjects.length;i++){
 			ComConfigSheet (sheetObjects[i] );
 			initSheet(sheetObjects[i],i+1);
 			ComEndConfigSheet(sheetObjects[i]);
         }
        sheet1.DataInsert(-1);
 		//event
     	axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
//     	axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
    	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
     }
    /**
   	 * Initializing sheet. Defining header
   	 * param : sheetObj ==> sheet object, sheetNo ==> sheet No.
   	 * Composition a initial module in case of multi sheet
   	 */
     function initSheet(sheetObj,sheetNo) {
        var cnt=0;
 		var sheetId=sheetObj.id;
         switch(sheetId) {
             case "sheet1":
                 with (sheetObj) {
            	    var HeadTitle1="|Sel.|Forwarder Code|Forwarder Name|old";
            	    var headCount=ComCountHeadTitle(HeadTitle1);
            	    var prefix="sheet1_";

            	    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

            	    var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
            	    var headers = [ { Text:HeadTitle1, Align:"Center"} ];
            	    InitHeaders(headers, info);

            	    var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
            	              {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"anr_fwrd_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
            	              {Type:"Text",      Hidden:0, Width:250,  Align:"Left",    ColMerge:1,   SaveName:prefix+"fwrd_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:1,   SaveName:prefix+"old_anr_fwrd_id", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
            	     
            	    InitColumns(cols);

            	    SetEditable(1);
            	    SetWaitImageVisible(0);
            	    SetColProperty(0 ,prefix+"anr_fwrd_id" , {AcceptKeys:"E" , InputCaseSensitive:1});
            	    SetColProperty(0 ,prefix+"fwrd_nm" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
            	    SetSheetHeight(260);
            	    SetCountPosition(0);
//            	    DataInsert(-1);
 				}
 			break;
         }
     }
     /* Processing Sheet */
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
 			case IBSEARCH:		//retrieve
 				if(!validateForm(sheetObj,formObj,sAction)) return false;
 				ComOpenWait(true);
				formObj.f_cmd.value=SEARCH;
				sheetObj.DoSearch("ESM_BKG_0969GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_") );
 				ComOpenWait(false);
 				break;
 			case IBINSERT:      // row add
				sheetObj.DataInsert(-1);
				break;
    	    case IBSAVE:        //save
    	    	if(!validateForm(sheetObj,formObj,sAction)) return false;
    	    	ComOpenWait(true);
    	    	formObj.f_cmd.value=MULTI;
				sheetObj.DoSave("ESM_BKG_0969GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
				ComOpenWait(false);
				break;
 			case IBDELETE:		// remove
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
   	 * Checking validation of input value
   	 */
     function validateForm(sheetObj,formObj,sAction){
    	var sheet1RowCnt=sheetObj.RowCount();
  	    switch(sAction) {
			case IBSEARCH: { // retrieve
    			//checking format
    			if (!ComChkValid(formObj)) return false;
				break;
			}
			case IBSAVE: {
				if(sheet1RowCnt == 0) {
					ComShowCodeMessage('BKG00095');
					return false;
				}
				for(var i=1; i <= sheet1RowCnt; i++) {
					//alert(">> " + sheetObj.CellValue(i,"sheet1_anr_fwrd_id"));
					if(sheetObj.GetCellValue(i,"sheet1_anr_fwrd_id") == "") {
						ComShowCodeMessage('BKG06093');
						sheetObj.SelectCell(i,"sheet1_anr_fwrd_id");
						return false;
					}
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
				//alert('sheet1RowCnt : ' + sheet1RowCnt + "["+sheetObj.CellValue(1,"sheet1_anr_fwrd_id")+"]");
				if(sheet1RowCnt == 0 || (sheet1RowCnt == 1 && (sheetObj.GetCellValue(sheetObj.GetSelectRow(),"sheet1_anr_fwrd_id") == "" || sheetObj.GetCellValue(sheetObj.GetSelectRow(),"sheet1_anr_fwrd_nm") == ""))) {
					ComShowCodeMessage('BKG00095');
					return false;
				}
				break;
  	    }
	    return true;
     }
     /**
      * calling event in case of data section cell mouse double clicking
      * @param sheetObj
      * @param Row
      * @param Col
      * @return
      */
     function sheet1_OnDblClick(sheetObj,Row,Col) {
    	var pageType=document.form.pageGubun.value;
    	if(pageType != "MAIN") {
			var obj=new Object(); 
			obj.cd=sheetObj.GetCellValue(Row, "sheet1_anr_fwrd_id");
			obj.nm=sheetObj.GetCellValue(Row, "sheet1_fwrd_nm");
			if(obj.cd !="" && obj.nm != "") {
		    	if(!opener) opener=window.dialogArguments;
		    	if(!opener) opener=parent;

				window.returnValue=obj;
				opener.setCallBackFwrd(obj); 	
				ComClosePopup(); 
			}
    	}
     }
	/**
	 * event after save
	 * @param sheetObj
	 * @param ErrMsg
	 * @return
	 */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
		sheetObj.CheckAll("sheet1_del_chk",0);
		if (ErrMsg == "") {
			var maxSheetLen=sheetObj.RowCount();
	    	for(i=1; i <= maxSheetLen; i++) {
	    		sheetObj.SetCellValue(i, 'sheet1_old_anr_fwrd_id',sheetObj.GetCellValue(i, 'sheet1_anr_fwrd_id'));
	    	}
	    	if (document.form.f_cmd.value == MULTI) {
	    		ComShowCodeMessage('BKG00102');
				doActionIBSheet(sheetObj, document.form, IBSEARCH); // re-retrieve
			}
		} 
    }
    /**
     * keyboard key up event
     */
    function obj_KeyUp() {
    	var formObject=document.form;
    	var srcName=ComGetEvent("name");
    	var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
    	var srcValue=window.event.srcElement.getAttribute("value");
    	if (srcName == "anr_fwrd_id" && ComChkLen(srcValue, srcMaxLength) == "2") {
    		ComSetNextFocus();
    	}
    }
    /**
  	 * Processing function in case of error to result of retrieve
  	 * Defined by DataSheetObject.prototype.event_OnSearchEnd
  	 */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		sheetObj.CheckAll("sheet1_del_chk",0);
    	if(sheetObj.RowCount()== 0) {
    		//ComShowMessage("There is no data to search");
    		//ComShowCodeMessage('BKG00095');
    		sheetObj.DataInsert(-1);
    	}
    }
 