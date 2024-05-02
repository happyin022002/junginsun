/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0708.js
*@FileTitle  : C/A Issue Reason Selection
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    var sheetObjects = new Array();
    var sheetCnt = 0;  
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
        /***** using extra sheet valuable if there are more 2 sheets *****/
        sheetObject1=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
			switch(srcName) {
				case "btn_select":				
					var message = '';
					var calllFunc = formObject.calllFunc.value;
					var sRow = sheetObj.FindCheckedRow("radio");
					if(sRow != ''){
						if (sheetObj.GetCellValue(sRow, "val") == 'O') {
							message = formObject.xter_rmk.value;
						} else {
							message = sheetObj.GetCellValue(sRow, "name");
						}
					}
					
					if(message == ''){
						ComShowMessage("Remark is mandatory item.");
						return;
					}
						
					if (ComFuncCheck("opener." + calllFunc))
						ComFunc(message);
					else if (ComFuncCheck("parent." + calllFunc))
						ComFunc(message);
					ComClosePopup();
					break;
				case "btn_close":
					ComClosePopup(); 
					break;
            } // end switch
    	}catch(e) {
    		ComShowMessage(e.message);
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
        for(var i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);         	
            ComEndConfigSheet(sheetObjects[i]);            
        }
        initControl(); 
        //initParam();  
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH); 
    }
    function initControl() {
  	  
  	}
  

    /**
     * setting sheet initial values and header
     * @param sheetObj
     * @param sheetNo
     * @return
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		switch(sheetObj.id) {
			case "sheet1":      //t4sheet1 init
		        with(sheetObj){
		            var HeadTitle=" Chk||Type|Description";
		            SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		            var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		            var headers = [ { Text:HeadTitle, Align:"Center"} ];
		            InitHeaders(headers, info);
		
		            var cols = [ 
		             {Type:"Radio",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"radio",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"val",     KeyField:0,   CalcLogic:"",   Format:"",           PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"name",    KeyField:0,   CalcLogic:"",   Format:"",           PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		             
		            InitColumns(cols);
		            SetCountPosition(0);
		            SetEditable(1);
		            SetSheetHeight(265);
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
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
      	    case IBSEARCH: 
      	    	formObj.f_cmd.value=SEARCH;
          		sheetObj.DoSearch("ESM_BKG_0620GS.do", FormQueryString(formObj) );
            break;
        }
    }
    
    function sheet1_OnClick(sheetObj, Row, Col, Value) {
    	var formObj = document.form;
    	formObj.xter_rmk.setAttribute('disabled', 'disabled');
    	if( sheetObj.ColSaveName(Col) == "radio" && sheetObj.GetCellValue(Row, "radio") == 1){
    		if(sheetObj.GetCellValue(Row, "val") == 'O'){
    			formObj.xter_rmk.removeAttribute('disabled');
    		}else{
    			formObj.xter_rmk.value = "";
    		}
    	}
    }
