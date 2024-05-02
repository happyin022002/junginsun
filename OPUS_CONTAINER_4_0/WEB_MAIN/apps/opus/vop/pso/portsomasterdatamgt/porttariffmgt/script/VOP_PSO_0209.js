/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_PSO_0209.js
*@FileTitle  : Search Formula & Condition ID
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/22
=========================================================*/
// public variable
	var sheetObjects=new Array();
	var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;
    var LANE="lane";
    var ROWMARK="|";
    var FIELDMARK=",";
    var TerminalList="";
    var AccountList="";
    var ObjList="";
    var WIDTH_FORMULA_POPUP=630;		//VOP_PSO_0210.do Popup 
    var HEIGHT_FORMULA_POPUP=360;
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
	          	case "btn_Retrieve":
	    				doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;
				case "btn_OK":
					comPopupOK();
					break;
				case "btn_Excel":
					if(sheetObject1.RowCount() < 1){//no data
		           		ComShowCodeMessage("COM132501");
	   	       		}else{
	   	       			sheetObject1.Down2Excel({ HiddenColumn:1,Merge:true,SheetDesign:1});
	   	       		}
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
	 * registering IBCombo Object as list
	 * param : combo_obj
	 * adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	 */ 
	function setComboObject(combo_obj) {  
	    comboObjects[comboCnt++]=combo_obj;  
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
        for(var k=0;k<comboObjects.length;k++){
            initCombo(comboObjects[k],k+1);
        }
       	initControl(sheetObjects[0]);  
       	getIdNo();
       	self.focus();
    }
    /**
     * registering initial event 
     */
    function initControl(sheetObj){
    	var formObj=document.form;
        axon_event.addListenerForm('keypress', 'obj_keypress', form);
  		var data=",|B,Base|S,Surcharge|D,Discount"
        var comboItems=data.split(ROWMARK);
		//ID No.	
  		addComboItem(comboObjects[1],comboItems);
  		//Object
    	comboItems=ObjList.split("↕");
  		addObjectComboItem(comboObjects[2],comboItems);
		comboObjects[2].InsertItem(0, "", ""); 
		comboObjects[2].SetSelectIndex(0);
    }
      /**
       * setting combo initial values and header
       * param : comboObj, comboNo
       * adding case as numbers of counting combos
       */ 
      function initCombo(comboObj, comboNo) {
    	  var formObject=document.form
    	  switch(comboNo) {  
	    	  case 1: 
	    		  with (comboObj) { 
	                    SetMultiSelect(0);
	                    SetUseAutoComplete(1);
		            	SetDropHeight(200);
	                    SetMaxLength(10);
	    		  }
	    	  break; 
	    	  case 3: 
	    		  with (comboObj) { 
	                    SetMultiSelect(0);
	                    SetUseAutoComplete(1);
		            	SetDropHeight(200);
	                    SetMaxLength(40);
						SetColAlign(0, "left");
						SetColAlign(1, "left");
						SetColWidth(0, "180");
						SetColWidth(1, "100");
	    		  }
	    	  break; 
    	  } 
      }
        /**
         * Adding data to combo field
         */	
        function addComboItem(comboObj,comboItems) {
        	for (var i=0 ; i < comboItems.length ; i++) {
        		var comboItem=comboItems[i].split(FIELDMARK);
        		comboObj.InsertItem(i, comboItem[1] , comboItem[0]);
        	}   		
        	//comboObj.InsertItem(0, "ALL","");
       	}
        /**
         * Adding data to object combo field
         */	
        function addObjectComboItem(comboObj,comboItems) {
         	for (var i=0 ; i < comboItems.length ; i++) {
         		var comboItem=comboItems[i].split("↔");
         		comboObj.InsertItem(i, comboItem[1] + "|" + comboItem[2], comboItem[0]);
         	}   		
        } 
	/**
	 * IBCombo Event
	 */
	function combo1_OnChange(comboObj,value,text){
		return;  
		var formObj=document.form;
		var aText=text.split("|");
		//var sText =  comboObj.GetText( value , 1);
		var sText=comboObj.GetText( value , 0);
		if( text == "" ){
			formObj.imdg_clss_cd_desc.value="";
		}else{
			formObj.imdg_clss_cd_desc.value=sText;
		}     	
	}
    /**
     * IBCombo Event
     */
    function combo2_OnChange(comboObj,value,text){
    }
    /**
    * IBCombo Event
    */
    function combo3_OnChange(comboObj,value,text){
    }
    /**
    * IBCombo Event
    */
    function getIdNo(){
    	var formObj=document.form;
		//Initializing combo field
		comboObjects[0].RemoveAll();  //Clearing ID No
		formObj.f_cmd.value=COMMAND01;
		//Retrieving ID No.
		var sXml=sheetObjects[0].GetSearchData("VOP_PSO_0209GS.do", FormQueryString(formObj));
		var comboItems=ComGetEtcData(sXml, "id" ).split(ROWMARK);
		if( comboItems != "" ){ 
			addComboItem(comboObjects[0],comboItems);
			comboObjects[0].InsertItem(0, "", ""); 
			comboObjects[0].SetSelectIndex(0);
		}	
    }
  /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
    	var cnt=0;
		var sheetid=sheetObj.id;
		switch(sheetid) {
			case "sheet1":
				with (sheetObj) {
		        var HeadTitle1="|ID|Description|Link Status.|Updated date|Updated By|UPD_MNU_NO_FOML|UPD_MNU_NO_COND|FOML_SYS_DESC";
		        var headCount=ComCountHeadTitle(HeadTitle1);
		        var prefix="sheet1_";
		        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		        InitHeaders(headers, info);
		        var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Status" },
		               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"id",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:540,  Align:"Left",    ColMerge:1,   SaveName:prefix+"descript",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Popup",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"link"},
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cre_date",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cre_usr",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_mnu_no_foml", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_mnu_no_cond", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"foml_sys_desc",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		        InitColumns(cols);
		        SetEditable(1);
		        SetShowButtonImage(2);
		        //SetSheetHeight(212);
		        resizeSheet();
				}
				break;
		}
    }
  // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
        //sheetObj.ShowDebugMsg(false);
    	var aryPrefix=new Array( "sheet1_" );        
        switch(sAction) {
 		   case IBSEARCH:      // Retrieving
		    	formObj.f_cmd.value=SEARCH;//COMBO
 		   		sheetObj.SetWaitImageVisible(0);
		        ComOpenWait(true);
		        var sXml=sheetObj.GetSearchData("VOP_PSO_0209GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
				var arrXml=sXml.split("|$$|");
				for(var i=0; i < arrXml.length; i++){ 
					if(i > 0) {
						sheetObjects[i].SetWaitImageVisible(0);
					}  
					sheetObjects[i].LoadSearchData(arrXml[i],{Sync:1} );
					sheetObjects[i].RenderSheet(1);
				}
				ComOpenWait(false);
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
     /**
      * Handling grid double click process
      */
     function sheet1_OnDblClick(sheetObj, Row, Col) {
    	 comPopupOK();
     }
     function sheet1_OnPopupClick(sheetObj,Row,Col){
    	 var formObj=document.form;
    	 var prefix="sheet1_";
    	 switch (sheetObj.ColSaveName(Col)) {
	    	case prefix + "link" :				//VOP_PSO_0210.do popup
	    		var turl="/opuscntr/VOP_PSO_0210.do?id_tp=" + formObj.id_tp.value + "&id_no=" + sheetObj.GetCellValue(Row, prefix + "id");
	    	 	ComOpenPopup(turl, WIDTH_FORMULA_POPUP, HEIGHT_FORMULA_POPUP, '', '0,0', false, false, Row, Col, 1);
	    	 break;	 
    	 }
     } 
     
     function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){
    	 var Row=sheetObj.MouseRow();
         var Col=sheetObj.MouseCol();
         var prefix="sheet1_";
         var sText = "";
         var selColName = sheetObj.CellSaveName (Row, Col);
         sText = sheetObj.GetCellText(Row,selColName)
         if(sText != ""){
        	 sheetObj.SetToolTipText(Row,Col,sText);
         }
     }     

     function resizeSheet(){
    	    ComResizeSheet(sheetObjects[0]);
    	}