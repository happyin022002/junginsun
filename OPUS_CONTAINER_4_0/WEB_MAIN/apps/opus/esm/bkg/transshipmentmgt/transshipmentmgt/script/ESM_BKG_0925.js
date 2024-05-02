/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0925.js
*@FileTitle  : T/S List by 1st VSL & 2nd VSL T/S Summary
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/04
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ems_bkg_0925 : business script for ems_bkg_0925
     */
var sheetObjects=new Array();
var sheetCnt=0;
var prefix1="sheet1_";
var comboObjects=new Array();
var comboCnt=0; 
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
				case "btn_DownExcel":
					doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
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
        formObj=document.form;
        if(formObj.disc_load_cd.value == 'D'){
        	sheetObjects[0].SetColHidden(2,1);
       	}else{
       		sheetObjects[0].SetColHidden(3,1);
       	}
    	for(var j=0; j<comboObjects.length; j++){
            initCombo(comboObjects[j]);
        }
    	doActionIBSheet(sheetObjects[1],document.form,INIT);
    	sheet1_OnLoadFinish(sheetObjects[0]);
//		axon_event.addListenerForm('Change', 'bkg0925_Change', document.form);
    	$(document.form).on('change', function(){
    		bkg0925_Change();
    	});
    }
     /**
      * combo initial set value
      * @param comboObj
      */
     function initCombo(comboObj) {
     	comboObj.SetMultiSelect(0);
//      	comboObj.UseCode = true;
     //no support[check again]CLT 	comboObj.LineColor="#ffffff";
     	comboObj.SetColAlign(0, "left");
     	comboObj.SetColAlign(1, "left");
     	comboObj.SetMultiSeparator("|");
     }
     /**
      * registering the created IBCombo Object at page as comboObjects list
      * @param combo_obj
      **/
     function setComboObject(combo_obj){
         comboObjects[comboCnt++]=combo_obj;
     }
	/*
	* remove Sheet screen Flashing
	*/
 	function sheet1_OnLoadFinish(sheetObj) {  
		doActionIBSheet(sheetObj, document.form, SEARCH);   
	}   
	/**
	 * setting sheet initial values and header
	 * @param sheetObj
	 * @param sheetNo
	 * @return
	 */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		var sheetId=sheetObj.id;
        switch(sheetId) {
            case "sheet1":
                with(sheetObj){
		            var HeadTitle1="|T/S VVD|TMNL Code|TMNL Code|ETA|40'|20'|R/F40'|R/F20'";
		            var headCount=ComCountHeadTitle(HeadTitle1);
		
		            SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0 } );
		
		            var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		            var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		            InitHeaders(headers, info);
		
		            var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"ibflag" },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix1+"vvd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix1+"pod_yd_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix1+"pol_yd_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix1+"eta",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"ft40",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:-1 },
		             {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:prefix1+"ft20",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:-1 },
		             {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:prefix1+"rf40",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:-1 },
		             {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:prefix1+"rf20",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:-1 } ];
		             
		            InitColumns(cols);
		            SetSheetHeight(280);
		            SetWaitImageVisible(0);
		            SetEditable(0);
                }
			break;
	    	case "sheet2":
	    	    with(sheetObj){
			          var HeadTitle="|";
		
			          SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
		
			          var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
			          var headers = [ { Text:HeadTitle, Align:"Center"} ];
			          InitHeaders(headers, info);
		
			          var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			                 {Type:"Radio",     Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"chk" } ];
			           
			          InitColumns(cols);
			          SetWaitImageVisible(0);
			          SetVisible(false);
			          SetEditable(1);
	                }
	    	break;
        }
    }
    /**
     * handling sheet process
     * @param sheetObj
     * @param formObj
     * @param sAction
     * @return void
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
		var arrPreFix=new Array("sheet1_");
        switch(sAction) {
	    	case INIT:      //Default
	    		ComOpenWait(true);
				formObj.f_cmd.value=INIT;
 				var sXml=sheetObj.GetSearchData("ESM_BKG_0925GS.do", FormQueryString(formObj));
				var arrXml=sXml.split("|$$|");
				if (0 < arrXml.length) {
					ComBkgXml2ComboItem(arrXml[0],selSort, "val", "name");
					selSort.SetSelectIndex(0);
				}
				break;
    		case SEARCH:      //retrieve
    			ComOpenWait(true);
				formObj.f_cmd.value=SEARCH; 
 				var sXml=sheetObj.GetSearchData("ESM_BKG_0925GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(arrPreFix));
				sheetObj.LoadSearchData(sXml,{Sync:1} );
				break; 
			case IBDOWNEXCEL:
				if(sheetObj.RowCount() < 1){//no data
	                   ComShowCodeMessage("COM132501");
	              }else{
	            	  sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1, Merge:1 });
	              }
				break;
        }
    }
    /**
     * handling process for input validation <br>
     * @param sheetObj
     * @param formObj
     * @param sAction
     * @return boolean
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//            if (!isNumber(formObj.iPage)) {
//                return false;
//            }
        }
        return true;
    }
	function selSort_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
		sheetObjects[0].ColumnSort(newCode);
	}
	
	function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
    	ComOpenWait(false);
    	sheetObj.SetSumText(1, "TTL")
	}
	
	function sheet2_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
    	ComOpenWait(false);
    }