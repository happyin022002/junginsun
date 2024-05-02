/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_PSO_0210.js
*@FileTitle  : ID Link Condition
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/22
=========================================================*/
 // public variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
    	var sheetObject1=sheetObjects[0];
    	/*******************************************************/
    	var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		switch(srcName) {
    			case "btn_close":
    				ComClosePopup(); 
    				break;
    		} // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowCodeMessage('PSO090005');	//Original
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
     * adding first-served functions after loading screen
     */
    function loadPage() {
    	for(i=0;i<sheetObjects.length;i++){
    		ComConfigSheet (sheetObjects[i] );
    		initSheet(sheetObjects[i],i+1);
    		ComEndConfigSheet(sheetObjects[i]);
    	}
    	initControl();
    	xsheet1_OnLoadFinish(sheetObjects[0]);
    }
    /**
     * registering initial event 
     */
    function initControl() {
    	//axon_event.addListenerFormat("keypress", "obj_keypress", form);
    	//axon_event.addListenerFormat("keyup",    "obj_keyup" ,   form);
    }
    function initSheet(sheetObj,sheetNo) {
    	var cnt=0;
    	switch(sheetNo) {
    	case 1:      // sheet1 init
    		with (sheetObj) {
            var HeadTitle="Terminal|Account|Cost|Service Provider|Version|Charge Type|";
            var headCount=ComCountHeadTitle(HeadTitle);
            var prefix="sheet1_";
            SetConfig( { SearchMode:2, MergeSheet:2, Page:20, DataRowMerge:1 } );
            var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
            var headers = [ { Text:HeadTitle, Align:"Center"} ];
            InitHeaders(headers, info);
            var cols = [ {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"yd_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				       {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"acct_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				       {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cost_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				       {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:prefix+"vndr_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				       {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ver",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				       {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"chg_tp_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				       {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"chg_tp",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
        InitColumns(cols);
        SetEditable(0);
        SetSheetHeight(237);
    		}
    		break;
    	}
    }
    // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg(false);
    	switch(sAction) {
    		case IBSEARCH:      //Retrieving
    			if(validateForm(sheetObj, formObj, sAction)){
    				sheetObj.SetWaitImageVisible(0);
        	        ComOpenWait(true);
    				formObj.f_cmd.value=SEARCH;
    				var prefix="sheet1_";	//prefix 
    				var sXml=sheetObj.GetSearchData("VOP_PSO_0210GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
    				sheetObj.LoadSearchData(sXml,{Sync:1} );
    				ComOpenWait(false);
    			}
    		break;
    	}
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
    	switch(sAction) {
    	case IBSEARCH:      //Retrieving
    		break;
    	}
    	return true;
    }
    
    function xsheet1_OnLoadFinish(sheetObj){
     	var formObject = document.form;	
     	var sheetObject1 = sheetObjects[0];
     	if(formObject.id_tp.value.length != 0 && formObject.id_no.value.length != 0){	
     		doActionIBSheet(sheetObject1, formObject, IBSEARCH);
      	}
    } 
