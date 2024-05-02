/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TPB_0811.js
*@FileTitle  : Container Selection
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/19
=========================================================*/
/****************************************************************************************
  Event Code: [Initializing]INIT=0; [Insert]ADD=1; [Retrieve]SEARCH=2; [List retrieve]SEARCHLIST=3;
			  [Modify]MODIFY=4; [Remove]REMOVE=5; [List remove]REMOVELIST=6 [Multi process]MULTI=7
			  [Constant]  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
  var sheetObjects=new Array();
  var sheetCnt=0;
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
  			//Setting startup environment. Change the name of the function
  			ComConfigSheet(sheetObjects[i]);
  			initSheet(sheetObjects[i],i+1);
  			//Setting final environment.
  			ComEndConfigSheet(sheetObjects[i]);
  		}
            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
  	}
  	/**
  	 * Initializing sheet. Defining header
  	 * param : sheetObj ==> sheet object, sheetNo ==> sheet No.
  	 * Composition a initial module in case of multi sheet
  	 */
  	function initSheet(sheetObj,sheetNo) {
  		sheetObj.UseUtf8=true;
	        var cnt=0;
  		switch(sheetNo) {
  			case 1:	  //IBSheet1 init
  			    with(sheetObj){
	  		      var HeadTitle="|Container No.|TP/SZ";
	
	  		      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	  		      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	  		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
	  		      InitHeaders(headers, info);
	
	  		      var cols = [ {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
			  		             {Type:"Text",      Hidden:0,  Width:160,  Align:"Center",  ColMerge:1,   SaveName:"cntr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			  		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			  		             {Type:"Status",  Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"status",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			  		              ];
	  		       
	  		      InitColumns(cols);
	  		      SetEditable(1);
  		          SetSheetHeight(200);
  		      }


  				break;
  		}
  	}
  	/* Event handler defined process to button click event */
  	document.onclick=processButtonClick;
  	/* Event handler is branch processing by name of button */
  	function processButtonClick(){
  		 /***** Assignment sheet in case of over 2 by tab****/
  		 var sheetObject=sheetObjects[0];
  		 /******************************************************/
  		 var formObject=document.form;
  		try {
  			var srcName=ComGetEvent("name");
  			switch(srcName) {
	  			case "btn_save": /// on save button click
		      		var resultArr=new Array();
		      		var k=0;
		      		for( i=0 ; i<sheetObject.RowCount(); i++ ){
		      			if( sheetObject.GetCellValue(i+1,'chk') == 1 ){
		      				resultArr[k++]=sheetObject.GetCellValue(i+1,'cntr_no')
		      				+ "|$|" + sheetObject.GetCellValue(i+1,'cntr_tpsz_cd');
		      			}
		      		}
		      		ComPopUpReturnValue(resultArr);
		      		break;
  				case "btn_add":
  					var row = sheetObject.DataInsert(-1);
  					break;
  				case "btn_delete":
					for(var i=sheetObject.HeaderRows(); i<sheetObject.HeaderRows()+ sheetObject.RowCount(); i++){
						if(sheetObject.GetCellValue(i,'chk') == true){
							 sheetObject.RowDelete(i, false);
							 i--;
						}
					}        	        
        	        
  					break;
  				case "btn_close":
  				    window.returnValue=false;
  				    ComClosePopup(); 
  				    break;
  			} // end switch
  		}catch(e) {			
  			if( e == "[object Error]") {
  				ComShowCodeMessage('COM12111');
  			} else {
  				ComShowMessage(e.message);
  			}
  		}
  	}
  	/* Processing Sheet */
  	function doActionIBSheet(sheetObj,formObj,sAction) {
  		switch(sAction) {
  		   case IBSEARCH:	  //Retrieve
  				formObj.f_cmd.value=SEARCH;   				
  				sheetObj.DoSearch("ESD_TPB_0811GS.do", tpbFrmQryStr(formObj) );
  				break;
  		}
  	}
  	/**
  	 * Processing function in case of error to result of retrieve
  	 * Defined by DataSheetObject.prototype.event_OnSearchEnd
  	 */
  	function sheet1_OnSearchEnd(sheetObj, code, errMsg){
//  		sheetObj.DataInsert(-1);
  		//if(errMsg!=null){
  			//ComShowMessage(errMsg);
  		//}
  	}
  	/**
  	 * Defined by DataSheetObject.prototype.event_OnSaveEnd
  	 */
  	function sheet1_OnSaveEnd(sheetObj, code, errMsg){
  		if(errMsg==null || errMsg == ''){
  			ComShowCodeMessage('COM12149','Data','','');
  		}
  	}
  	/**
  	 * Defined by DataSheetObject.prototype.event_OnChange
  	 */
   	function sheet1_OnChange(sheetObj, Row, Col, Value){
//   		var colNm=sheetObj.ColSaveName(Col);
//   		if( colNm == 'chk' ){
//   			if(sheetObj.GetCellValue(Row,'cntr_no').length == 0 && sheetObj.GetCellValue(Row,'cntr_tpsz_cd').length == 0 ){
//   				if(sheetObj.GetCellValue(Row,'chk') != '' ){
//   					sheetObj.DataInsert();
//   				}else{
//   					sheetObj.RowDelete(Row, false);
//   				}
//   			}
//   		}


		var colNm=sheetObj.ColSaveName(Col);
  		// Checking digit container EQ No.
  		if( colNm == 'cntr_no' && Value != '' ) {
  			Value=sheetObj.GetCellValue(Row, "cntr_no");
  			document.form.s_eq_no.value=Value;
  			document.form.s_eq_knd_cd.value= "U";
  			getTPBGenCombo('CheckCntrNo','checkEqNo','V','','',new Array('s_eq_knd_cd','s_eq_no'),Value, Row);
  			
  			//getTPBGenCombo(id,method,mode,obj,all,paramName, otherObjs, row)
  		}
   	}
   	/* Finishing work */
