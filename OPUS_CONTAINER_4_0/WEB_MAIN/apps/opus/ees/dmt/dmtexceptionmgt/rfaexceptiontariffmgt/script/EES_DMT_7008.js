/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_7008.js
*@FileTitle  : Approval Authority Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

	// Common Global variables
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
 	//Event handler processing by button click event */
	document.onclick=processButtonClick;
	
 	//Event handler processing by button name */
	function processButtonClick(){
 	 /***** case in Sheet count are more two by Tab, defining adding sheet *****/
		var sheetObject1=sheetObjects[0];
		var sheetObject2=sheetObjects[1];
 	 /*******************************************************/
		var formObj=document.form;
		try {
			var srcName=ComGetEvent("name");
			var srcObj=window.event.srcElement;
			switch(srcName) {
	 			case "btn_retrieve":
					doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
					break;
	 			case "btn_new":
	 				ComResetAll();
 					break;
	 			case "btn_downexcel":
	 				// Before Booking & After Booking
	 				if(sheetObject1.RowCount() < 1){//no data
	 					ComShowCodeMessage("COM132501");
	 				}else{
	 					sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1 });
	 				}
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
	
	function t1sheet1_OnDownFinish(downloadType, result) {
		if(t2sheet1.RowCount() < 1 ){//no data sheet1	
			ComShowCodeMessage("COM132501");
		}else{	
			t2sheet1.Down2Excel( {DownCols: makeHiddenSkipCol(t2sheet1), SheetDesign:1,Merge:1 });
			doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
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
	 * IBTab Object is defined as an array.
	 * adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	 */
	function setTabObject(tab_obj){
		 tabObjects[tabCnt++]=tab_obj;
	}
	
    /**
     * Initialization Tab
     * Setting Tab's entry.
     */
	function initTab(tabObj , tabNo) {
    	 switch(tabNo) {
    	 	case 1:
    	 		with (tabObj) {
	                var cnt=0 ;
	                InsertItem( "Before Booking" , "");
	                InsertItem( "After Booking" , "");
	            }
	            break;
	    }
	}
	
     /**
      * Click on Tab event-related
      * Elements selected tab is active.
      */
	function tab1_OnChange(tabObj , nItem)
	{
		var objs=document.all.item("tabLayer");
		objs[nItem].style.display="Inline";
		objs[beforetab].style.display="none";
		objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
		//------------------------------------------------------//
		beforetab=nItem;
	}
	
	/** 
	 * Register as an array IBCombo Object
  	 * param : combo_obj ==> combo object
  	 * The next batch of other items when you need treatment of fiberglass can add to an array that holds the process
  	 * Array defined at the top of the source
	 */ 
	function setComboObject(combo_obj) {  
	    comboObjects[comboCnt++]=combo_obj;  
	} 
	/**
	 * Combo basic setting 
	 * param : comboObj ==> combo object, comboNo ==> Combo object ID of the tag attached to the serial number
	 * If the number of combo a combo by adding the number of case sheets to initialize the module configuration
	 */ 
	function initCombo(comboObj, comboNo) {
	    var formObject=document.form;
		switch(comboNo) {
			case 1:
				with (comboObj) { 
  					SetMultiSelect(0);
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "50");
					SetColWidth(1, "190");
  					SetDropHeight(160);
  					ValidChar(2, 2);
					SetMaxLength(2);
		    	}
				break;
	     }  
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
	    for(var k=0 ; k < comboObjects.length ; k++){
	        initCombo(comboObjects[k],k+1);
	    }
	 	for(k=0;k<tabObjects.length;k++){
	 		initTab(tabObjects[k],k+1);
    		tabObjects[k].SetSelectedIndex(0);
	 	}
		//initializing html control event
		initControl();
		
		doActionIBCombo2(sheetObjects[0], document.form, comboObjects[0], COMMAND06);
		var usrRhqOfcCd=ComGetObjValue(document.form.usr_rhq_ofc_cd);
   		ComSetObjValue(comboObjects[0], usrRhqOfcCd);		
//   		comboObjects[0].SetSelectIndex(0,true);
	}
	
	function initControl() {
        //axon_event.addListenerForm  ( 'blur'     , 'obj_blur'      , document.form ); //- out of focus
        //axon_event.addListenerFormat( 'focus'    , 'obj_focus'     , document.form ); // Get focus
        axon_event.addListener('keydown', 'ComKeyEnter', 'form');  
		//axon_event.addListenerFormat('keypress','obj_keypress', document.form); //- on press keyboard
	}
	
	//business javascript OnKeyPress event handling
	function obj_keypress() {
    	 switch(event.srcElement.dataformat){
         	case "engup":
		    	// upper case + numbers 
         		ComKeyOnlyAlphabet('uppernum', ',');
		        break;
         	case "engup2":
		    	//  upper case + numbers + exceptional letters
         		DmtComKeyOnlyAlphabet('uppernum', ',');
		        break;
         	case "int":
    	        //only numbers
    	        ComKeyOnlyNumber(event.srcElement);
    	        break;
         	default:
	         	// only numbers(integer, date, time)
	            ComKeyOnlyNumber(event.srcElement);
    	 }
	}
	
	function obj_blur(){
         //check inputing Validation + Inserting separator 
         var obj=event.srcElement;
	}
	
	function obj_focus() {
		ComClearSeparator(event.srcElement);
		ComSetFocus(event.srcElement);
	}
	
   /**
	* setting sheet initial values and header
	* param : sheetObj, sheetNo
	* adding case as numbers of counting sheets
	*/
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
    	switch(sheetID) {
        	case "t1sheet1":      // t1sheet1 init
        	    with(sheetObj){
        			var HeadTitle="|Seq.|Approval Office|User Office|ID|Name";

        			SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

        			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
        			var headers = [ { Text:HeadTitle, Align:"Center"} ];
        			InitHeaders(headers, info);

        			var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
        			             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
        			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"ar_hd_qtr_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"ofc_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"usr_id",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        			             {Type:"Text",      Hidden:0,  Width:170,  Align:"Left",    ColMerge:0,   SaveName:"usr_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
               
        			InitColumns(cols);

        			SetEditable(1);
        			SetCountPosition(0);
        			SetSheetHeight(482);
        		}
        	    break;
        	case "t2sheet1":      // t1sheet1 init
        	    with(sheetObj){
        			var HeadTitle="|Seq.|Approval Office|User Office|ID|Name";

        			SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

        			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
        			var headers = [ { Text:HeadTitle, Align:"Center"} ];
        			InitHeaders(headers, info);

        			var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
        			             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
        			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"ar_hd_qtr_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"ofc_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"usr_id",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        			             {Type:"Text",      Hidden:0,  Width:170,  Align:"Left",    ColMerge:0,   SaveName:"usr_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
               
        			InitColumns(cols);

        			SetEditable(1);
        			SetCountPosition(0);
        			SetSheetHeight(482);
        		}
        	    break;
    	}
	}
	
	// Process of Sheet
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
	 		case IBSEARCH:     // Search
	 			//ComOpenWait Start
	 			sheetObj.SetWaitImageVisible(0);
	 			ComOpenWait(true);
 				formObj.f_cmd.value=SEARCH;
 				sheetObj.SetDataAutoTrim(0);
//parameter changed[check again]CLT
 				var sXml=sheetObj.GetSearchData("EES_DMT_7008-1GS.do",	FormQueryString(formObj));
 				var arrXml=sXml.split("|$$|");
 				sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
 				sheetObjects[1].LoadSearchData(arrXml[1],{Sync:1} );
 				//ComOpenWait End
				ComOpenWait(false);
	 			break;
		}
	}
	
    
    
    /**
     *  doActionIBCombo
     */
    function doActionIBCombo2(sheetObj, formObj, comboObj, formCmd) {
      	 sheetObj.ShowDebugMsg(false);
      	 sheetObj.SetWaitImageVisible(0);
      	 formObj.f_cmd.value=formCmd;
      	 var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
      	 switch(formCmd) {
      	 	case COMMAND06:	// RHQ
      	 		with (comboObj) { 
   	    	 		RemoveAll();
   					SetMultiSelect(0);
   					SetColWidth(0, "80");
   					ValidChar(2);	
   					//MaxLength = 6;
      	 		}
      	 		var data=ComGetEtcData(sXml, "common_cd");
   				if (data != undefined && data != '') {
   					comboObj.InsertItem(0, "All", "");
   					var comboItems=data.split("|");
   					for (var i=0 ; i < comboItems.length ; i++) {
   		    	    	comboObj.InsertItem(i+1, comboItems[i], comboItems[i]);		
   		         	}
   				}
   			break;
		
      	 	}
      	 
   	}	    
    

	
	
	/*
  	 * Each common pop-up function calls 
  	 */
  	function openPopup(flag, arg) {
  		var sheetObj=sheetObjects[0];
  		var formObj=document.form;
  		var sUrl='';
  		var sWidth='';
  		var sHeight='';
  		with(sheetObj) {
	  		switch(flag) {
	  			case 'usr_nm':		// user name Inquiry Popup
					ComOpenPopup('COM_ENS_091.do', 770, 570, "setUsrNm", "1,0,1,1,1,1,1", true);
					break;
	  			case 'ofc_cd':
	  				ComOpenPopup('COM_ENS_071.do', 770, 470, "getCtrtOfcCd", "1,0,1,1,1,1,1", true);
	  				break;
	  		} // switch-end
  		} // with-end
  		if(sUrl.indexOf('.do') != -1) {
  			var sWinName=ComReplaceStr(sUrl, '.do', '');
  			ComOpenWindowCenter(sUrl, sWinName, sWidth, sHeight, true);
  		} 
  		else if(sUrl != '') {
  			ComOpenWindow(sUrl, "", "scrollbars=no,toolbar=no,location=no,resizable=yes,menubar=no, width=" + sWidth + ",height=" + sHeight + ",left=0,top=0");
  		}
  	}
  	
	function setUsrNm(aryPopupData){
		document.form.usr_nm.value=aryPopupData[0][5];
 	}
	
    /*
   	 *Set in a field is selected in the Customer Code  as Cstomer pop-up 
   	 */
    function getCtrtOfcCd(aryPopupData) {
    	document.form.ofc_cd.value=aryPopupData[0][3];
    }	 
