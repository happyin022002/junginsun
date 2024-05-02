/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_OFCINFOMULTI.js
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
						MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
						OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

    /**
     * @extends Mnr
     * @class ees_mnr_ofcinfomulti : business script for ees_mnr_ofcinfomulti.
     */
    function ees_mnr_ofcinfomulti() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
   	/* developer job	*/

	/* common global variables */
	var sheetObjects = new Array();
	var sheetCnt = 0;

	var sheet = null

	if(sheet == 2) {
		var sheetObj = sheetObjects[1];
	} else {
		var sheetObj = sheetObjects[0];
	}

	// common global variables
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var Mincount = 0;
	
	var opener;

	/* Event handler processing by button click event */
	document.onclick = processButtonClick;

	/* Event handler processing by button name */
	function processButtonClick(){
		
		var sheetObject = sheetObjects[0];

		/*******************************************************/
		var formObject = document.form;
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;

				case "btn_RowAdd":
	    			doActionIBSheet(sheetObject,formObject,IBINSERT);
				break;

				case "btn_Apply":
					comPopupOFCOK(sheetObject,formObject);
				break;

				case "btn_Close":
					ComClosePopup(); 
				break;
			} // end switch
		} catch(e) {
			if( e == "[object Error]") {
				ComFuncErrMsg(e);
			} else {
				ComFuncErrMsg(e);
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
		opener = window.dialogArguments;
		if (!opener) opener = parent;
		
		for(i=0;i<sheetObjects.length;i++) {
			//
            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i + 1);
        	//
            ComEndConfigSheet(sheetObjects[i]);
		}
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
	}

	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt = 0;
		switch(sheetNo) {
			case 1:      //sheet1 init
				with (sheetObj) {

					var HeadTitle = "Sel|Seq|Offer Office|Offer Qty";
					SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:0 } );
					var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:0 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"CheckBox",  Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"check",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Seq",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							     {Type:"PopupEdit",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"offr_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1},
					             {Type:"Text",      Hidden:0,  Width:80,  Align:"Center",  ColMerge:0,   SaveName:"offr_qty",  KeyField:0,   CalcLogic:"",   Format:"Integer",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 }];
					InitColumns(cols);
					SetColProperty(0 ,"offr_ofc_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});

					SetCountPosition(0);
					SetSheetHeight(210);
					
				}
			break;
		}
	}

	// handling process for sheet
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
			case IBINSERT:      // saving
				var lvcnt = 0;
				var lvrow = sheetObj.RowCount();
				if( !isNaN(formObj.row_count.value) ) {
					lvcnt = eval(formObj.row_count.value);
					if( !donumberheck(lvcnt) ) {
						for(i=lvrow; i < lvcnt+lvrow; i++){
							sheetObj.DataInsert(i);
						}
					} else {
						sheetObj.DataInsert(-1);
						formObj.row_count.value = "1";
					}
				} else {
					formObj.row_count.value = "1";
				}
			break;

			case IBCLEAR:
				var formObj = document.form;

				sheetObj.RemoveAll();

				var preSetData = formObj.presetData.value;
				if(preSetData != ""){
					var dataArr = preSetData.split("|");

					for ( var i = 0; i < dataArr.length; i++) {
						var tempArr = dataArr[i].split("=");

						var ofcCd = tempArr[0];
						var ofcQty = tempArr[1];

						var Row = sheetObj.DataInsert(-1);

						sheetObj.SetCellValue(Row,"check","1");
						sheetObj.SetCellValue(Row,"offr_ofc_cd",ofcCd);
						sheetObj.SetCellValue(Row,"offr_qty", ofcQty);
					}
				}
			break;

			case IBCOPYROW:        //copy row
				sheetObj.DataCopy();
			break;

			case IBDOWNEXCEL:        //excel download
				sheetObj.Down2Excel();
			break;

			case IBLOADEXCEL:        //excel upload
				sheetObj.LoadExcel();
			break;
		}
	}

	function sheet1_OnPopupClick(sheetObj, row,col){
        if (sheetObjects[0].ColSaveName(col) != "offr_ofc_cd") return;

		var param = "?row=" + row + "&col=" + col;
		ComOpenPopup('/opuscntr/COM_ENS_071.do' + param, 770, 450, 'getCOM_ENS_071', '1,0,1,1,1,1,1,1,1,1,1,1', false);
    }

	/**
	 * COM_ENS_071 receiving function values ​​from Pop-up
	 */
	function getCOM_ENS_071(aryPopupData, row, col, shhetIdx){
    	 var formObj = document.form;

		 if(aryPopupData[0][3] != null && aryPopupData[0][3] != "") {
		  	sheetObjects[0].SetCellValue(row,col,aryPopupData[0][3]);
		 }
    }

	/**
	 * handling event in case of input Location or input Contry Code
	 *
	 */
	function sheet1_OnChange(sheetObj, row, col, value){
		if(sheetObj.ColSaveName(col) == 'check')
		{
//			if(sheetObj.GetCellValue(row,col) == 1){
//				sheetObj.SetRowBackColor(row) = sheetObj.RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB);
//			} else {
//				sheetObj.RowBackColor(row) = sheetObj.RgbColor(SheetEditBackColorR,SheetEditBackColorG,SheetEditBackColorB);
//			}
		}

		var formObj = document.form;
		var colName = sheetObj.ColSaveName(col);
		var checkOffice = delSpace(value);
		switch(colName){
			case 'offr_ofc_cd':
			    retArray = MnrGeneralCodeCheck(sheetObj,"OFC",checkOffice);
				if(retArray == null){
					ComShowCodeMessage("MNR00165",checkOffice);
					sheetObj.SetCellValue(row ,col, "");
					sheetObj.SelectCell(row ,col);
				} else {
					sheetObj.SetCellValue(row ,"offr_ofc_cd", sheetObj.GetCellValue(row ,col));
					sheetObj.SelectCell(row ,col + 1);
				}

				var chkval=trim(sheetObj.GetCellValue(row, 'offr_ofc_cd'));
				if(chkval=="") {
					sheetObj.SetCellValue(row,'check', "0");
					sheetObj.SetCellValue(row,col, "");
				} else {
					if(sheetObj.GetCellValue(row, 'offr_qty') != "0"){
						sheetObj.SetCellValue(row,'check', "1");
					}
				}
			break;

			case 'offr_qty':
				var maxCnt = parseInt(formObj.rpr_qty.value);
				var preChkCnt = 0;

				var sRow = sheetObj.FindCheckedRow("check");
			    //setting row as list.
			    var arrRow = sRow.split("|");

			    for (idx = 0; idx < arrRow.length - 1; idx++){
					var qtyInfo = sheetObj.GetCellValue(arrRow[idx], "offr_qty");
					preChkCnt = preChkCnt + parseInt(qtyInfo);
				}

				var curQty = 0;
				if(sheetObj.GetCellValue(row,'check') != "1"){
					curQty = parseInt(sheetObj.GetCellValue(row ,"offr_qty"));
				}

				if((preChkCnt + curQty) > maxCnt){
					ComShowCodeMessage("MNR00351");
					sheetObj.SetCellValue(row ,"offr_qty", "0");
					return;
				}

				if(sheetObj.GetCellValue(row, 'offr_ofc_cd') != "" && sheetObj.GetCellValue(row, 'offr_qty') != "0"){
					sheetObj.SetCellValue(row,'check',"1");
				} else {
					sheetObj.SetCellValue(row,'check', "0");
				}
			break;
		}
	}

	// Remove spaces from a string
	function delSpace(str) {
		var trimstr = str;
		for (var i=0; i< str.length;i++) {
			trimstr = trimstr.replace(' ' ,'');
		}
		return trimstr;
	}

	/**
     * setting return value to parent form.
     */
	function comPopupOFCOK(sheetObj,formObject) {
		var preChkCnt = 0;
		var formObj = document.form;
		var maxCnt = parseInt(formObj.rpr_qty.value);

	    var sRow = sheetObj.FindCheckedRow("check");
	    //setting row as list.
	    var arrRow = sRow.split("|");
		var retStr = "";

	    for (idx = 0; idx < arrRow.length; idx++){
			 // list containing col data
			var ofcInfo = sheetObj.GetCellValue(arrRow[idx], "offr_ofc_cd");
			var qtyInfo = sheetObj.GetCellValue(arrRow[idx], "offr_qty");
			preChkCnt = preChkCnt + parseInt(qtyInfo);

			retStr = retStr + ofcInfo + "=" + qtyInfo + "|";
		}

		//checking Quantity
		if(preChkCnt != maxCnt){
			ComShowCodeMessage("MNR00352");
			return;
		}

		var shidx = formObj.sheet_id.value;
		var targetRow =  formObj.targetRow.value;
		opener.getMnr_ofcInfoMulti(MnrDelLastDelim(retStr),shidx,targetRow);
		ComClosePopup(); 
	}

	/**
	 *  trim
	 */
    function trim(string)
    {
    	for(;string.indexOf(" ")!= -1;)
    	{
     		string = string.replace(" ","");
    	}

    	return string;
   }

	/**
	 * eck validity for a number.
	 */
	function donumberheck(obj) {
		var lveng = /[0-9]/;
		if( lveng.test(obj) ) {
			return false;
		}
		return true;
	}
	/* developer job */
