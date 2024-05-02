/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TES_9220.jsp
*@FileTitle  : Get Container List Pop Up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/27
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

// global variable


var sheetObjects = new Array();
var sheetCnt = 0;

/* Event handler processing by button click event */
document.onclick = processButtonClick;

/* Event handler processing by button name */
	function processButtonClick(){
		 /***** using extra sheet valuable if there are more 2 sheets *****/
		 /*******************************************************/
		 var sheetObject = sheetObjects[0];
		 var formObject = document.form;

		 try {
			var srcName=ComGetEvent("name");
			switch(srcName) {
				case "btn_oK":
					ComShowMessage ("btn_ok button click");
					break;

				case "btn_close":
					ComClosePopup();
					break;

			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(ComGetMsg('TES21506')); //ComShowMessage(OBJECT_ERROR);
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
	   sheetObjects[sheetCnt++] = sheet_obj;
	}

	/**
	 * initializing sheet
	 * implementing onLoad event handler in body tag
	 * adding first-served functions after loading screen.
	 */
	function loadPage() {
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		initValue();
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	}

	function initValue(){
		var opener = window.dialogArguments;
		if (!opener) opener = parent;
		document.form.vndr_seq.value = opener.form.vndr_seq.value;
		document.form.yd_cd.value = opener.form.yd_cd.value;
	}

   /**
	 * setting sheet initial values and header
	 * param : sheetObj ==> , sheetNo ==>  
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj,sheetNo) {

		var cnt = 0;
		switch(sheetNo) {
			 case 1:      //sheet1 init
				with (sheetObj) {
				 	
				 	var HeadTitle1 = " |Seq.|UOM|Period|Period|Accoumulated Vol|VNDR_SEQ|ACCM_SEQ";
					var HeadTitle2 = " |Seq.|UOM|From|To|Accoumulated Vol|VNDR_SEQ|ACCM_SEQ";
					var headCount=ComCountHeadTitle(HeadTitle1);
					
					var headers = [ { Text:HeadTitle1, Align:"Center"},
				                    { Text:HeadTitle2, Align:"Center"} ];
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				 
					InitHeaders(headers, info);
					SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:1 } );
					
					 var cols = [  {Type:"Radio",     Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"radio",        	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		        	               {Type:"Seq",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq",          	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                           {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"tml_accm_ut_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                           {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"accm_fm_dt",   	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                           {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"accm_to_dt",   	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                           {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"pay_vol_qty",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                           {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",     	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                           {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"accm_seq",  		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
					 InitColumns(cols);
					 SetRangeBackColor(1, 3, 1, 5,"#555555");
					 resizeSheet();//SetSheetHeight(240);
			   }
				break;
		}
	}
	function resizeSheet(){
		ComResizeSheet(sheetObjects[0]);
	}

  // handling sheet process
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;

		switch(sAction) {
		   case IBSEARCH:      //Save
                formObj.f_cmd.value = SEARCH;
		        var searchXml = sheetObj.GetSearchData("ESD_TES_9220GS.do",  tesFrmQryStr(formObj));
								sheetObj.RemoveAll();
								//ComShowMessage(searchXml);
								if (searchXml != "") sheetObj.LoadSearchData(searchXml,true);
				break;
		}
	}

   /**
	 * handling process for input validation
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
//            if (!isNumber(iPage)) {
//
//                return false;
//            }
		}

		return true;
	}

	/**
	 * IBSheetConfig.js DataSheetObject.prototype.event_OnSearchEnd
	 */
	function sheet_OnSearchEnd(sheetObj,errMsg){
		if(errMsg!=null){
			ComShowMessage(errMsg);
		}
	}


	function value2Form(){
		if(sheetObjects[0].RowCount > 0){
			if(sheetObjects[0].CheckedRows("chk") < 1){
				ComShowMessage(ComGetMsg('TES22008'));
				return false;
			}
			for(var i=sheetObjects[0].HeaderRows ; i<sheetObjects[0].HeaderRows + sheetObjects[0].RowCount; i++){
				if(sheetObjects[0].CellValue(i, "chk")){
					window.dialogArguments.form.pay_vol_qty.value = sheetObjects[0].CellValue(i, "pay_vol_qty");
					window.dialogArguments.form.accm_seq		.value = sheetObjects[0].CellValue(i, "accm_seq"	 );
				}
			}
		}
		window.close();
	}