/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0096.js
*@FileTitle  : Yard Assign by CNTR
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/03
=========================================================*/
/****************************************************************************************
 *Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					          MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					          Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------These code are for making JSDoc well ------------------*/
   /**
     * @fileoverview 
     * @author 
     */
    /**
     * @extends 
     * @class ESM_BKG_0096 : ESM_BKG_0096 - task script definition for screen
     */
    function ESM_BKG_0096() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
// public variable
var sheetObjects=new Array();
var sheetCnt=0;
var arrTpSz=new Array();
var arrQty=new Array();
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
    function processButtonClick(){
         /***** If sheets are more than 2 in one tab, use additional sheet variables *****/
		         var sheetObject1=sheetObjects[0];
         /*******************************************************/
        var formObject = document.form;
		var srcName=ComGetEvent("name");
    	try {
			switch(srcName) {
				case "btn_save":
					doActionIBSheet(sheetObject1,formObject,IBSAVE);
				break;
				case "btn_close":
					ComClosePopup(); 
				break;
				case "btn_add":
					sheetObject1.DataInsert(-1);
 					sheetObject1.SetCellValue(sheetObject1.Rows-1, "bkg_no",formObject.bkg_no.value);					
				break;
				case "btn_delete":
					ComRowHideDelete(sheetObject1, "chk");
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
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }
  /**
     * setting sheet initial values and header
     * 
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		var sheetID=sheetObj.id;
		switch(sheetID) {
			case "sheet1":
			    with(sheetObj){

		     
		      var HeadTitle1="||Sel.|TP/SZ|Q'ty|P/Up CY|BKG_NO|BKG_SEQ|PSA_SER_NO|SUB_PSA_SER_NO|PSA_IF_CD";
		      var headCount=ComCountHeadTitle(HeadTitle1);

		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);

		      var cols = [ 
		                  {Type:"Status",    Hidden:1, 	Width:10,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		                  {Type:"Text",      Hidden:1,  Width:0,   Align:"Center",  ColMerge:1,   SaveName:"" },
		                  {Type:"CheckBox",  Hidden:0, 	Width:40,   Align:"Center",  ColMerge:1,   SaveName:"chk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, InputCaseSensitive:1 },
		                  {Type:"Float",     Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"cntr_qty",        KeyField:1,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0,  Width:180,  Align:"Center",  ColMerge:1,   SaveName:"yd_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7, InputCaseSensitive:1 },
		                  {Type:"Text",      Hidden:1, 	Width:0,    Align:"Center",  ColMerge:1,   SaveName:"bkg_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
		                  {Type:"Text",      Hidden:1, 	Width:0,    Align:"Center",  ColMerge:1,   SaveName:"bkg_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
		                  {Type:"Text",      Hidden:1, 	Width:0,    Align:"Center",  ColMerge:1,   SaveName:"psa_ser_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
		                  {Type:"Text",      Hidden:1, 	Width:0,    Align:"Center",  ColMerge:1,   SaveName:"sub_psa_ser_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
		                  {Type:"Text",      Hidden:1, 	Width:0,    Align:"Center",  ColMerge:1,   SaveName:"psa_if_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 } ];
		       
		      InitColumns(cols);

		      SetEditable(1);
		        SetSheetHeight(160);
		       }

			break;
		}
	}
    
    function sheet1_OnSearchEnd(sheetObj,errMsg){
    	var formObj=document.form;
    	setFormData(formObj, sheetObj);
    }
  // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			case IBSEARCH:      //Retrieve
				formObj.f_cmd.value=SEARCH;
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				var params=FormQueryString(formObj);
				params=params  + "&" + ComGetSaveString(sheetObj);
 				var sXml=sheetObj.GetSearchData("ESM_BKG_0096GS.do", params);
				sheetObj.RenderSheet(0);
			    sheetObj.LoadSearchData(sXml,{Sync:2} );
			    sheetObj.RenderSheet(1);
//				setFormData(formObj, sheetObj);
				ComOpenWait(false);
			break;
			case IBSAVE:        //Save
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				formObj.f_cmd.value=MULTI;
				var params=ComGetSaveString(sheetObj, true, true);
				if (params.length > 0) {
					params="f_cmd=" + MULTI + "&bkg_no=" + formObj.bkg_no.value + "&" + params; 
					if (params)
					sheetObj.SetWaitImageVisible(0);
					ComOpenWait(true);
 					var sXml=sheetObj.GetSaveData("ESM_BKG_0096GS.do", params);
					var State=ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
					ComOpenWait(false);
					if(State == "S") {
						setParentToSheet(sheetObj);
					}else{
						sheetObj.LoadSearchData(sXml,{Sync:2} );
					}				
				}
			break;
        }
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
    		switch(sAction) {
    		case IBSAVE:
    			var cntrSheet=sheetObjects[0];
    			var cntrCount=cntrSheet.RowCount()+ 1;
    			for (ir=1; ir < cntrCount; ir++) {
    				if (ComTrim(sheetObj.GetCellValue(ir, "ibflag")) != 'D') {
    					if (ComTrim(sheetObj.GetCellValue(ir, "cntr_tpsz_cd")) == '') {
							ComShowMessage(ComGetMsg("BKG01101", "TP/SZ"));
							return false;
						}
    					if (ComTrim(sheetObj.GetCellValue(ir, "cntr_qty")) == '0') {
							ComShowMessage(ComGetMsg("BKG01101", "Qty"));
							return false;
						}
    					if (ComTrim(sheetObj.GetCellValue(ir, "yd_cd")) == '') {
							ComShowMessage(ComGetMsg("BKG01101", "P/UP CY"));
							return false;
						}
    				}
				}
    			for (i=1; i < cntrCount; i++) {
    				if (ComTrim(sheetObj.GetCellValue(i, "ibflag")) != 'D') {
						for (j=1; j < cntrCount; j++) {
							if (ComTrim(sheetObj.GetCellValue(j, "ibflag")) != 'D') {
								if (ComTrim(sheetObj.GetCellValue(i, "cntr_tpsz_cd")) == ComTrim(sheetObj.GetCellValue(j, "cntr_tpsz_cd"))
										&& ComTrim(sheetObj.GetCellValue(i, "yd_cd")) == ComTrim(sheetObj.GetCellValue(j, "yd_cd")) && i != j ) {
									ComShowMessage(ComGetMsg("BKG06124"));
									return false;
								}
							}
	    				}
					}    				
    			}
    			break;
    		}
    	}
        return true;
    }
    /*
	* input Data to Form
	*/
	function setFormData(formObj,sheetObj){
		if(sheetObj.GetEtcData("bkg_no") != undefined){
		ComSetObjValue(formObj.bkg_no,sheetObj.GetEtcData("bkg_no"));
		}
		if(sheetObj.GetEtcData("bkg_qty") != undefined){
		ComSetObjValue(formObj.bkg_qty,sheetObj.GetEtcData("bkg_qty"));
		}
		if(sheetObj.GetEtcData("yd_cd") != undefined){
		ComSetObjValue(formObj.yd_cd,sheetObj.GetEtcData("yd_cd"));
		}
		with(sheetObj){
			for(var iRow=1; iRow<Rows; iRow++){ 
				arrTpSz[iRow-1]=GetCellValue(iRow,"cntr_tpsz_cd");
				arrQty[iRow-1]=GetCellValue(iRow,"cntr_qty");
			}
		}
	}
	/*
	* Popup sheet contents return to Main sheet
	*/
	function setParentToSheet(sheetObj){
		var formObj = document.form;
		var parentObj = parent.document.form;
		var parentRefSheet = eval(parent.sheetObjects[formObj.callSheetIdx.value]);
//		console.log(parentRefSheet);
		if (parentObj) {
			with(sheetObj){
				parentRefSheet.RemoveAll();
				for(var iRow=1;iRow<Rows;iRow++){
					parentRefSheet.DataInsert(-1);
					parentRefSheet.SetCellValue(iRow,"cntr_tpsz_cd",GetCellValue(iRow,"cntr_tpsz_cd"),0);
					parentRefSheet.SetCellValue(iRow,"op_cntr_qty",GetCellValue(iRow,"cntr_qty"),0);
					parentRefSheet.SetCellValue(iRow,"full_rtn_yd_cd",GetCellValue(iRow,"yd_cd"),0);
				}
			}
		}
//		var calllFunc = formObj.calllFunc.value;
//		if(calllFunc != ''){
//			eval('parent.'+calllFunc + "()");
//		}
		ComClosePopup(); 
	}
	/*
	* Sheet1 OnAfterEdit Event handling
	*/
	function sheet1_OnAfterEdit(sheetObj,Row,Col){
//	    var sTpSz=false;
//		with(sheetObj){
//			for(var idx=0;idx<arrTpSz.length;idx++){ 
//				if (arrTpSz[idx]==CellValue(Row,"cntr_tpsz_cd")){
//					sTpSz=true;
//					if (qtyCheck(sheetObj,arrTpSz[idx],arrQty[idx])){
//						ComShowCodeMessage("BKG00642");
//						break;
//					}
//				}
//			}
//			if (!sTpSz){
//				ComShowCodeMessage("BKG00062");
//				CellValue2(Row,"cntr_tpsz_cd")="";
//			}
//		}
//		 
	}
	/*
	* the number of Qty check
	*/
	function qtyCheck(sheetObj,cntrTpSz,qty){
		var bFlag=false;
		var fQty=qty;
		with(sheetObj){
			for(var iRow=1;iRow<Rows;iRow++){
				if (cntrTpSz==GetCellValue(iRow,"cntr_tpsz_cd")){
					fQty=ComRound(fQty)-ComRound(GetCellValue(iRow,"cntr_qty"));
					if (ComRound(fQty)<0){ 
						SetCellValue(iRow,"cntr_qty",0,0);
						bFlag=true;
						break;
					}
				}
			}
		}
		return bFlag;
	}
