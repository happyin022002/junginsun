/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0384.js
*@FileTitle  : Booking Notice Remark 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
 // global variable

    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1; 

    var sheetObjects = new Array();
    var sheetCnt = 0;

    // Event handler processing by button click event */
    document.onclick = processButtonClick;

    // Event handler processing by button name */
    function processButtonClick(){
        var formObject=document.form;
   	try {
   		var srcName=ComGetEvent("name");
           switch(srcName) {
               case "btn_AddRow":
					doActionIBSheet(sheetObjects[0], formObject, IBINSERT);
               break;
				case "btn_DeleteRow":
					doActionIBSheet(sheetObjects[0], formObject, IBDELETE);
               break;
				case "btn_Save":
					doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
               break;
	    		case "btn_Select":
	    			//comPopupOK();
	    			callPopupOK(sheetObjects[0]);
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
		
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}
 /**
    * setting sheet initial values and header
    * param : sheetObj, sheetNo
    * adding case as numbers of counting sheets
    */
   function initSheet(sheetObj,sheetNo) {
       var cnt=0;
       switch(sheetNo) {
           case 1:      //sheet1 init
        	   with(sheetObj){
	        	   var HeadTitle1="Sel||tp cd|Template Seq.|User Id|Title|Remark(s)";
	
	        	   SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	        	   var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	        	   var headers = [ { Text:HeadTitle1, Align:"Center"}];
	        	   InitHeaders(headers, info);
	
	        	   var cols = [ {Type:"Radio", Hidden:0, Width:27,   Align:"Center",  ColMerge:0,   SaveName:"check",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   Wrap:1 },
				        	    {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",        Wrap:1 },
				        	    {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"tmplt_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10,    Wrap:1 },
				        	    {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"tmplt_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10,    Wrap:1 },
				        	    {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"usr_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10,    Wrap:1 },
				        	    {Type:"Text",      Hidden:0,  Width:140,  Align:"Left",    ColMerge:0,   SaveName:"tmplt_hdr_nm",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100,   Wrap:1 },
				        	    {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"tmplt_ctnt",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2000,  Wrap:1, MultiLineText:1} ];
	
	        	   InitColumns(cols);

	        	   SetEditable(1);
	        	   SetSheetHeight(222);
	        	   SetAutoRowHeight(1);
       	   }
               break;
       }
   }
 // handling of Sheet 
   function doActionIBSheet(sheetObj,formObj,sAction) {
       sheetObj.ShowDebugMsg(false);
       switch(sAction) {
           case IBSEARCH:      //search
   			if(validateForm(sheetObj, formObj, sAction)) {
   				formObj.f_cmd.value=SEARCH;
  				sheetObj.DoSearch("ESM_BKG_0384GS.do", FormQueryString(formObj) );
   			}
   		break;
   		case IBINSERT:      // insert
   			var newRow=sheetObj.DataInsert(-1);
   			sheetObj.SetCellValue(newRow, "tmplt_tp_cd","R",0);
   		break;
   		case IBDELETE:      // delete
   			ComRowHideDelete(sheetObj, "check");
   			sheetObj.SetCellValue(sheetObj.GetSelectRow(), "ibflag","D",0);
   		break;
   		case IBSAVE:        //save
   			if(validateForm(sheetObj,formObj,sAction)) {
   				formObj.f_cmd.value=MULTI;
   				sheetObj.DoSave("ESM_BKG_0384GS.do", FormQueryString(formObj));
   			}
   		break;
       }
   }
   function sheet1_OnSaveEnd(sheetObj, ErrMsg) {	
	 	 	if (ErrMsg == "") {
	 		ComBkgSaveCompleted();  //handling server message
	 		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		} 	 	
   }
   function sheet1_OnChange(shtObj, Row, Col, Value) {  
       with (shtObj) {
           switch (ColSaveName(Col)) {
               case "tmplt_ctnt":
            	   
            	   Value = rdParameterErrorCheckStr(Value);
            	   
	        		var arrVal = Value.split("\n");
	        		var strVal = "";
	        		if (arrVal.length > 0) {
	        	        for (var i=0; i < arrVal.length; i++) {
	        	          	var cnt = Math.ceil(arrVal[i].length / 70);
	        	            if (cnt > 1) {
	        	            	for (var j=0; j < cnt; j++) {
	        		            	strVal = strVal + arrVal[i].substring((j*70),(j*70)+70) + "\n";	            		
	        	            	}
	        	            }else{
	        	            	if (arrVal[i].length > 0) strVal = strVal + arrVal[i] + "\n";
	        	            }
	        	        }
	        		}
	        		shtObj.SetCellValue(Row, Col, strVal.trim(), 0);
	        		break;

           }
       }
   }   
   /**
	 *  sending value to parent screen when checked in pop up. <br>
	 * 
	 * @param {ibsheet}
	 *            sheetObj IBSheet Object
	 * @param {String}
	 *            value sheetObj
	 */
	function callPopupOK(sheetObj) {
		var formObj=document.form;
		var calllFunc;
		var rArray=null; // list of row data
		// single selection (Radio) or multiple selection (CheckBox)
		rArray=getLocalCheckedRows(sheetObj);
		if(rArray == null) {
			ComShowCodeMessage("COM12114", "row");
			return;
		}
		calllFunc=formObj.calllFunc.value;
		if (ComFuncCheck("opener." + calllFunc)) ComFunc(rArray);
		else if (ComFuncCheck("parent." + calllFunc)) ComFunc(rArray);
		ComClosePopup(); 
	}
	function getLocalCheckedRows(sheetObj,colName) {
		var checkRows;
		var colsCnt=sheetObj.LastCol()+ 1;
 		var rows=sheetObj.LastRow()+1;
		var rArray=null; // list of row data
		var cArray=null; // list of column data
		checkRows=sheetObj.FindCheckedRow('check');
		if(checkRows == "")  return null;
		var idx=0;
		var arrRow = checkRows.split("|");
		rArray=new Array(arrRow.length);
		for(var i=0; i < arrRow.length; i++) {
			var iRow = arrRow[i];
			cArray=null;
			// in case of indicating certain column name
			if(colName != null && colName != "") {
				cArray=sheetObj.GetCellValue(iRow, colName);
			} else {
				cArray=new Array(colsCnt);
		  		for(var j=0; j<cArray.length; j++) {
		  			cArray[j]=sheetObj.GetCellValue(iRow, j);
		        }
			}
			rArray[idx++]=cArray;
		}
	  	return rArray;
	}
   /**
    * handling process for input validation
    */
   function validateForm(sheetObj,formObj,sAction){
       with(formObj){
       	for (i=1; i<= sheetObj.LastRow(); i++) {  //sheetObj.LastRow()
       		if (sheetObj.GetCellValue(i, "tmplt_hdr_nm").length < 3){
   				alert(ComGetMsg('COM12143',"Title", 3));
   				sheetObj.SelectCell(i, "tmplt_hdr_nm");
   				return false;	
   			}
   		}
       }
       return true;
   }
/* the end of developer's work */
