/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : VOP_SCG_0067.jsp
 *@FileTitle : Excepted Quantities - Creation
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/17
 =========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   /**
     * @fileoverview commonly used javascript file, calendar related functions are defined.
     */
    /**
     * @extends 
     * @class vop_scg_0067 : business script for vop_scg_0067
     */

 // common global variable
 var sheetObjects=new Array();
 var sheetCnt=0;
 // Event handler processing by button click event */
 document.onclick=processButtonClick;
 // Event handler processing by button name */
     function processButtonClick(){
 		/***** In case of more than 2 sheets in a tab, additional sheet variables can be specified *****/
 		var sheetObject=sheetObjects[0];
 		/*******************************************************/
 		var formObject=document.form;
 		try {       
 			var srcName=ComGetEvent("name");
 			if(ComGetBtnDisable(srcName)) return false;
 			switch(srcName) {
				case "btn_RowAdd":
					var row=sheetObject.DataInsert(-1);
					sheetObject.SelectCell(row, 2);
					sheetObject.SetTotalRows(row);
					break;
				case "btn_RowInsert":
					var row=sheetObject.DataInsert();
					sheetObject.SelectCell(row, 2);
					break; 
				case "btn_RowCopy":
					var row=sheetObject.DataCopy();
					sheetObject.SelectCell(row, 2);
					break;
				case "btn_RowDelete":
					ComRowHideDelete(sheetObject, "del_chk");
					break;	
				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;
				case "btn_Save":
					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
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
     
     //no support[check again]CLT function sheet1_OnLoadFinish(sheetObj) {
         //Initializing html control event
         initControl();
         doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
     }
   /**
      * setting sheet initial values and header
      * param : sheetObj, sheetNo
      * adding case as numbers of counting sheets
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
         switch(sheetObj.id) {
             case "sheet1":      //t2sheet1 init
                with (sheetObj) {
                     // setting height
            	 
            	 var HeadTitle1="|Sel.|No.|Code|Maximum net quantity \n per inner packaging \n (in grams for solids and ml for liquids and gases)|Maximum net quantity per outer packaging \n (in grams for solids and ml for liquids and gases, \n or sum of grams and ml in the case of mixed packaging)";
            	 var headCount=ComCountHeadTitle(HeadTitle1);
//            	 (headCount, 0, 0, true);
            	 //DataRowMerge 가로머즈 없음 1->0
            	 SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:0 } );

            	 var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            	 var headers = [ { Text:HeadTitle1, Align:"Center"} ];
            	 InitHeaders(headers, info);
            	 //@@숫자만 들어갈수 있도록 처리 : AcceptKeys:"N"
            	 var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
            	              {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"del_chk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"NONE" },
            	              {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"imdg_expt_qty_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
            	              {Type:"Text",      Hidden:0,  Width:300,  Align:"Center",  ColMerge:0,   SaveName:"max_inr_pck_qty",   KeyField:1,   CalcLogic:"",   Format:"",   AcceptKeys:"N",         PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
            	              {Type:"Text",      Hidden:0,  Width:300,    Align:"Center",  ColMerge:0,   SaveName:"max_outr_pck_qty",  KeyField:1,   CalcLogic:"",   Format:"",   AcceptKeys:"N",          PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 } ];
            	  
            	 InitColumns(cols);
            	 //SetSheetHeight(460);
            	 resizeSheet();
            	 SetEditable(1);
 				}
                 break;
         }
     }
     function resizeSheet(){
    	 	ComResizeSheet(sheetObjects[0], 60);
     }
 	// Sheet related process handling
     function doActionIBSheet(sheetObj,formObj,sAction) {
 		sheetObj.ShowDebugMsg(false);
 		switch(sAction) {
	      	case IBSEARCH:      //retrieve
				if(validateForm(sheetObj,formObj,sAction)) {
					if(sheetObj.id == "sheet1") {
		        		formObj.f_cmd.value=SEARCH;
 		        	   	sheetObj.DoSearch("VOP_SCG_0067GS.do", FormQueryString(formObj) );
					}
				}			
	    	   	break;
			case IBSAVE:        //save
	 			if(!validateForm(sheetObj,formObj,sAction))return;
 				if(!ComShowCodeConfirm('SCG50001', 'data')) return;
        		formObj.f_cmd.value=MULTI;
				sheetObj.DoSave("VOP_SCG_0067GS.do", FormQueryString(formObj), '-1', false);
				break;
         }
     }
  	/**
      * Dynamically load HTML Control event in page. <br>
      * Initialize IBSheet Object by calling this function from {@link #loadPage} function.
      * @param {ibsheet} sheetObj    IBSheet Object
      * @param {int}     sheetNo     sheetObjects list in turn
      **/
     function initControl() {    	
         //Axon event handling1. event catch
         axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
     }
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
     	if (sAction == IBSAVE) {
 			var dupRow = sheetObj.ColValueDupRows("imdg_expt_qty_cd", false, true);
 			if(dupRow != "") {
				ComShowCodeMessage('SCG50005', 'Data');
				if (sheetObj.GetRowStatus(dupRow.split("|")[0])=="R") {
					sheetObj.SelectCell(dupRow.split("|")[1], 2);
				}else{
					sheetObj.SelectCell(dupRow.split("|")[0], 2);
				}
				return;
			}
    	}
     	return true;
     }
     /**
      * When value change in IBSheet Object
      */
 	function sheet1_OnChange(sheetObj,Row, Col, Value){
 		if (sheetObj.ColSaveName(Col) == "imdg_expt_qty_cd") {
 			var bfCode=sheetObj.GetCellValue(Row,"imdg_expt_qty_cd");
 			if (bfCode != "" && bfCode.length != 2) { 
 				ComShowCodeMessage('SCG50006', 'Code', '2');
 				sheetObj.SelectCell(Row, Col);
 			}
   		}
   	}
