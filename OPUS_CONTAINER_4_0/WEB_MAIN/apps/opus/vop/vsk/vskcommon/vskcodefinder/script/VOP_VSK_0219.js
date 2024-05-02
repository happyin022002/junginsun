/**=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : VOP_VSK_0219.js
*@FileTitle  : Vessel Code Inquiry(VSL SKD Update (CCA))
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/29
=========================================================**/

/****************************************************************************************
   Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
               MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
               Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

	 // public variable

	 var sheetObjects=new Array();
	 var sheetCnt=0;
		
	 // Event handler processing by button click event */
	 document.onclick=processButtonClick;
	 // Event handler processing by button name */
	 function processButtonClick(){
	      var sheetObject=sheetObjects[0];
	      /*******************************************************/
	      var formObject=document.form;
	 	try {
	 		var srcName=ComGetEvent("name");
	 		if (!ComIsBtnEnable(srcName)) return;  
	         switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;
				case "btn_ok":
					var cnt=sheetObject.RowCount();
					if(cnt > 0){
						comPopupOK();
					}
					break;
				case "btn_close":
					ComClosePopup(); 
					break;
	         } // end switch
	 	}catch(e) {
	 		if( e == "[object Error]") {
	 			ComShowMessage(OBJECT_ERROR);
	 		} else {
	 			ComShowMessage(e);
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
	     initControl();
	     opener = window.dialogArguments;
	     if (!opener)
	    	 opener = parent;
	 }
	/**
	 * registering initial event 
	 **/
	function initControl() {
		//** Date Separator **/
		DATE_SEPARATOR="/";
		var formObj=document.form;
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');// Enter key
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
			          var HeadTitle="|Code|Vessel Name|Carrier Code";
			
			          SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0} );
			
			          var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			          var headers = [ { Text:HeadTitle, Align:"Center"} ];
			          InitHeaders(headers, info);
			
			          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"vsl_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			              {Type:"Text",      Hidden:0,  Width:260,  Align:"Left",    ColMerge:0,   SaveName:"vsl_eng_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			              {Type:"Text",      Hidden:0,  Width:80,  Align:"Center",  ColMerge:0,   SaveName:"crr_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
			           
			          InitColumns(cols);
			
			          SetEditable(0);
			          tabIndex=-1;
			          SetSheetHeight(237);
	                 }
	                 break;
	         }
	     }
	 // handling sheet process
	 function doActionIBSheet(sheetObj,formObj,sAction) {
	     sheetObj.SetWaitImageVisible(0);
	     switch(sAction) {
	        case IBSEARCH:      //Retrieve
	        	if(validateForm(sheetObj,formObj,sAction)){
	        		ComOpenWait(true);
		        	formObj.f_cmd.value=COMMAND16;
		        	var rXml=sheetObj.GetSearchData("VOP_VSK_0219GS.do", FormQueryString(formObj));
		        	sheetObj.LoadSearchData(rXml,{Sync:1} );
	        	}
		        break;
	     }
	 }
	 /**
	  * handling process for input validation
	  */
	 function validateForm(sheetObj,formObj,sAction){
		 var vsl_cd=formObj.vsl_cd;
		 var vsl_eng_nm=formObj.vsl_eng_nm;
		 var crr_cd=formObj.crr_cd;
	     with(formObj){
	    	 if (ComChkLen(vsl_cd, 2)==1 && ComChkLen(vsl_eng_nm, 2)==1 && ComChkLen(crr_cd, 2)==1){
	    		 vsl_cd.focus();
	    		 ComShowCodeMessage('VSK00022', "2", "vessel code");
	    		 return false;
	    	 }
	     }
	     return true;
	 }
	 /**
	  * Return to Parent Screen
	  */
	function sheet1_OnDblClick(sheetObj, Row, Col) {
		//alert( "sheet1_OnDblClick ");
		//doReturnValue(sheetObj, row, col);
		//ComPopUpReturnValue(sheetObj.GetCellValue(sheetObj.GetSelectRow(), 'vsl_cd'));
//		ComPopUpReturnValue(sheetObj.GetCellValue(sheetObj.GetSelectRow(), 1)); // vsl_cd
		comPopupOK();
	}
	
	function sheet1_OnClick(sheetObj, Row, Col){
		//alert( "sheet1_OnClick");
	
	//	window.returnValue=sheetObj.GetCellValue(sheetObj.GetSelectRow(), 'vsl_cd');
//		ComPopUpReturnValue(sheetObj.GetCellValue(sheetObj.GetSelectRow(), 'vsl_cd'));
	}//end sheet1_OnDblClick
	/**
	 * Handling enter key
	 */
	function enter_keypress(){
		VskKeyEnter();
	}
	
	function sheet1_OnSearchEnd(sheetObj, Code, ErrMsg){
		ComOpenWait(false);
	}

	
	/**
	 * Return VVD of Row to Parent Screen
	 * @param sheetObj
	 * @param row
	 * @param col
	 * @return
	 */
	function doReturnValue(sheetObj, row, col){
		comPopupOK();
	}