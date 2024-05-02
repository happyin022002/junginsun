/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : VOP_SCG_0041.js
*@FileTitle  : Packing Group (Creation) 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/26
=========================================================*/

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
     				descCopy(sheetObject);
     				var row=sheetObject.DataInsert(-1);
					//descCopy(sheetObject);
					sheetObject.SelectCell(row, 3);
					break;
				case "btn_RowInsert":
					descCopy(sheetObject);
					var row=sheetObject.DataInsert();
					sheetObject.SelectCell(row, 3);
					break; 
				case "btn_RowCopy":
					var row=sheetObject.DataCopy();
					descClear();
					sheetObject.SelectCell(row, 3);
					break;
				case "btn_RowDelete":
					ComRowHideDelete(sheetObject, "del_chk");
					descClear();
					break;	
				case "btn_Retrieve":
					descClear();
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;
				case "btn_Save":
					descCopy(sheetObject);
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
        	 //
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             //
             ComEndConfigSheet(sheetObjects[i]);
         }
         sheet1_OnLoadFinish(sheetObjects[0]);
     }
     function sheet1_OnLoadFinish(sheetObj) {
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
         switch(sheetNo) {
         	case 1:      //t1sheet1 init
         	    with(sheetObj){
		              var HeadTitle="|Sel.|No.|Special Provisions||";
		              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);
		              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				                     {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"del_chk",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                     {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"NONE" },
				                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"imdg_spcl_provi_no",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:4 },
				                     {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"imdg_spcl_provi_desc",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:4000 },
				                     {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"delt_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		               
		              InitColumns(cols);
		              SetEditable(1);
		              SetSheetHeight(445);
                    }
         		break;
         }
     }
     // Sheet related process handling
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
	      	case IBSEARCH:      //retrieve
				if(validateForm(sheetObj,formObj,sAction)) {
					if(sheetObj.id == "sheet1") {
		        		formObj.f_cmd.value=SEARCH;
		        		var sXml = sheetObj.GetSearchData("VOP_SCG_0041GS.do", FormQueryString(formObj));
		        		sheetObj.LoadSearchData(sXml, {Sync:1});
		        		if(sheetObj.RowCount() > 0) {
			        	   	sheetObj.SelectCell(1,3);
			        	   	sheet1_OnClick(sheetObj,1,3,"16");		        			
		        		}
					}
				}			
	    	   	break;
			case IBSAVE:        //save
	 			if(!validateForm(sheetObj,formObj,sAction))return;
 				if(!ComShowCodeConfirm('SCG50001', 'data')) return;
        		formObj.f_cmd.value=MULTI;
        		sheetObj.DoSave("VOP_SCG_0041GS.do", FormQueryString(formObj), '-1', false);
        		sheet1_OnClick(sheetObj,sheetObj.GetSelectRow(),3,"16");
				break;
         }
     }
  	/**
      * Dynamically load HTML Control event in page. <br>
      * Initialize IBSheet Object by calling this function from {@link #loadPage} function. <br>
      * @param {ibsheet} sheetObj    IBSheet Object
      * @param {int}     sheetNo     sheetObjects list in turn
      **/
     function initControl() {    	
         //Axon event handling1. event catch
//         axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
//         axon_event.addListenerForm('keypress','obj_keypress',    form  );         
     }
     /**
      * Handling Form Object obj_keypress event
      * @param  void
      * @return void
      */     
//      function obj_keypress (){
//          var obj=event.srcElement;
//          switch(ComGetEvent("name")){
//               case 'imdg_spcl_provi_no':
//                    ComKeyOnlyNumber(obj);
//                    break;
//          }
  //    }
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
     	if (sAction == IBSAVE) {
 			var dupRow = sheetObj.ColValueDupRows("imdg_spcl_provi_no", false, true);
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
      * Clicking IBSheet Object
      */
     function sheet1_OnClick(sheetObj,Row, Col, Value) {
 		var formObj=document.form;
  		if (sheetObj.ColSaveName(Col) == "imdg_spcl_provi_no") {
  			formObj.imdg_spcl_provi_no2.value=sheetObj.GetCellValue(Row,"imdg_spcl_provi_no");
  			formObj.imdg_spcl_provi_desc1.value=sheetObj.GetCellValue(Row,"imdg_spcl_provi_desc");
  			formObj.rowNo.value=Row;
		}
     }
 	function descCopy(sheetObject)  {   		
 		var formObj=document.form;
		var rowNo=sheetObject.GetSelectRow();
		sheetObject.SetCellValue(sheetObject.GetSelectRow(),"imdg_spcl_provi_desc",formObj.imdg_spcl_provi_desc1.value);
		descClear();
     }
     function descClear()  {
 		var formObj=document.form;
 		formObj.rowNo.value="";
 		formObj.imdg_spcl_provi_no2.value="";
 		formObj.imdg_spcl_provi_desc1.value="";	
     }     
