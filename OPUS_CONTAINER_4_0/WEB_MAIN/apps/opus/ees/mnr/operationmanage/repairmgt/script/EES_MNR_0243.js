/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0243.js
*@FileTitle  : EDI & Excel Estimate Upload
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/22
=========================================================*/
/****************************************************************************************
  Eevent classification code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   	/* Developer's task	*/
// Common global variable
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var MNR_DISABLE_BACK_COLOR=15723503;
//Result of confirmed
var vComplexPK=null;
// Defining event handler of button click */
	document.onclick=processButtonClick;
	var opener = window.dialogArguments;
// Event handler to diverge process by button name */
    function processButtonClick(){
         /***** Adding variable of sheet object in case of more than 2 sheets per tabs *****/
         var sheetObject=sheetObjects[0];
         var sheetObject2=sheetObjects[1];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
                 case "btn_loadExcel":
                 	doActionIBSheet(sheetObject, formObject, IBLOADEXCEL);
                    break;
				case "btns_DownFile":
 					sheetObject2.Down2Excel({KeyFieldMark:0});
				break;
		        case "btn_Save":
					doActionIBSheet(sheetObject, formObject, IBSAVE);
					break;
		        case "btn_close":
		        	if(vComplexPK != null) {
		        		opener.callbackUploadConfirm(vComplexPK);
		        	}
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
     * Assigning array of IBSheet object
     * Array defined at the top of the source
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
  	/**
	 * Assigning array of IBCombo object
	 * @param	{IBMultiCombo}	combo_obj
	 * Array defined at the top of the source
	 */
	function setComboObject(combo_obj){
    	comboObjects[comboCnt++]=combo_obj;
	}
    /**
     * Sheet default setting and initializing
     * To implement for onload event of body tag
     * After loading in your browser should display the ability to add pre-processing
     */
    function loadPage() {
    	if (!opener) opener = parent;
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i + 1);
            ComEndConfigSheet(sheetObjects[i]);
        }
		for(k=0;k < comboObjects.length;k++){
            initCombo(comboObjects[k],k + 1);
        }
        ComBtnDisable("btn_Save");
    }
  /**
     * Initializing variable for IBSheet and defining header
     * param : sheetObj ==> sheet object, sheetNo ==> Sequence number from sheet object tag id
     */
    function initSheet(sheetObj,sheetNo) {
    	var cnt=0;
        switch(sheetNo) {
            case 1:      //sheet1 init
                with (sheetObj) {
                    // Setting height
            	
            	var HeadTitle="|Seq||EQ No|Estimate No|Damage Date|Currency|EDI ID|Off-Hire|Location|Component|Damage|Repair|Division|Type|Qty|Size/Square|Hour|Rate|Cost|Material|Amount|Verify Result|Verify Result"
            	var headCount=ComCountHeadTitle(HeadTitle)
//            	(headCount, 9, 0, true);

            	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

            	var info    = { Sort:1, ColMove:0, HeaderCheck:1, ColResize:1 };
            	var headers = [ { Text:HeadTitle, Align:"Center"} ];
            	InitHeaders(headers, info);

            	var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
            	             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq_no",         KeyField:0,   CalcLogic:"",   Format:"" },
            	             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"complex_pk",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rqst_eq_no",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:14 },
            	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rqst_ref_no",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:20 },
            	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"eq_dmg_dt",      KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:8 },
            	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
            	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"edi_id",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:20 },
            	             {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rpr_offh_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1 },
            	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"eq_loc_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:4 },
            	             {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"eq_cmpo_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
            	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"eq_dmg_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
            	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"eq_rpr_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
            	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"trf_div_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
            	             {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"vol_tp_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1 },
            	             {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"rpr_qty",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:6 },
            	             {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"rpr_sz_no",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:10 },
            	             {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"rpr_lbr_hrs",    KeyField:1,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1,   EditLen:8 },
            	             {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"rpr_lbr_rt",     KeyField:1,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1,   EditLen:18 },
            	             {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"lbr_cost_amt",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"mtrl_cost_amt",  KeyField:1,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1,   EditLen:21 },
            	             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"mnr_wrk_amt",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"edi_err_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"edi_err_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
            	 
            	InitColumns(cols);
            	SetSheetHeight(310);
            	SetEditable(0);
//            	SetGetCountPosition()(0);
            	SetCountFormat("[SELECTDATAROW / TOTALROWS]");
            	SetColProperty(0,"rpr_offh_flg", {ComboText:"Y|N", ComboCode:"Y|N"} );
            	SetColProperty(0,"vol_tp_cd", {ComboText:"Qty|Size|Square", ComboCode:"Q|Z|S"} );
               }
               break;
			case 2:      //sheet2 init
                with (sheetObj) {
                    // Setting height
				
				var HeadTitle="EQ No|Estimate No|Damage Date|Currency|EDI ID|Off-Hire|Location|Component|Damage|Repair|Type|Qty|Size/Square|Hour|Rate|Material"
				var headCount=ComCountHeadTitle(HeadTitle)
//				(headCount, 0, 0, true);

				SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );

				var info    = { Sort:1, ColMove:0, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);

				var cols = [ {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rqst_eq_no",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:14 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rqst_ref_no",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:20 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"eq_dmg_dt",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:8 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"edi_id",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:20 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rpr_offh_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"eq_loc_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:4 },
				             {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"eq_cmpo_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"eq_dmg_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"eq_rpr_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"vol_tp_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rpr_qty",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:6 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rpr_sz_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:10 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rpr_lbr_hrs",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:1,   EditLen:8 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rpr_lbr_rt",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:18 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"mtrl_cost_amt",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:1,   EditLen:21 } ];
				 
				InitColumns(cols);
				SetSheetHeight(310);
				SetEditable(0);
//				SetGetVisible()(0);
//				SetRowHidden(0, 1);
				var rowIdx=DataInsert(-1);
               }
               break;
        }
    }
	/**
	 * Combo Setting default
	 * @param	{IBMultiCombo}	combo_obj.
	 * @param	{Number}	comboNo		Sequence number from combo object tag id
	 */
	function initCombo (comboObj, comboNo) {
	    //var cnt  = 0 ;
	    var formObject=document.form
	}
  	//Sheet processing-related processes
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			 case IBLOADEXCEL://EXCEL UPLOAD
				if(sheetObj.id == "sheet1") {
 					sheetObj.LoadExcel({ Mode:"HeaderMatch",WorkSheetNo:"1",StartRow:"1",EndRow:"0",WorkSheetName:"",Append:false,ColumnMapping:""});
				}
				break;
			 case IBSAVE:        //check
			 	formObj.f_cmd.value=MULTI;
				if(validateForm(sheetObj, formObj, sAction)) {
				 	var fParam=FormQueryString(formObj);
					var sParam=sheetObj.GetSaveString(false, true);
					sParam=fParam + '&' + sParam;
 				    var sXml=sheetObj.GetSaveData("EES_MNR_0243GS.do", sParam);
				 	if(MnrComGetErrMsg(sXml) == null){
 						sheetObj.LoadSaveData(sXml);
						vComplexPK=ComGetEtcData(sXml, "complex_pk");
				 	}
				}
			 	break;
        }
    }
	/**
	 * Event handling of OnLoadExcel of sheet1
	 * @param sheetObj
	 */
	function sheet1_OnLoadExcel(sheetObj, result, code, msg){
		if(isExceedMaxRow(msg))return;
		
    	with(sheetObj) {
    		SetColBackColor("trf_div_cd",MNR_DISABLE_BACK_COLOR);
    		SetColBackColor("lbr_cost_amt",MNR_DISABLE_BACK_COLOR);
			SetColBackColor("mnr_wrk_amt",MNR_DISABLE_BACK_COLOR);
			SetColBackColor("edi_err_cd",MNR_DISABLE_BACK_COLOR);
			SetColBackColor("edi_err_nm",MNR_DISABLE_BACK_COLOR);
			if(GetSaveString(false, true) == "") {
				checkRecursiveLoadData(sheetObj);
			}
    	}
		if(sheetObj.RowCount()> 0) {
			ComBtnEnable("btn_Save");
		} else {
			ComBtnDisable("btn_Save");
		}
	}
	function checkRecursiveLoadData(sheetObj) {
		with(sheetObj) {
			for(var i=LastRow(); i >= HeaderRows(); i--) {
				if(GetCellValue(i, "rqst_eq_no") == ""  || GetCellValue(i, "rqst_ref_no") == "" 	||
					GetCellValue(i, "eq_dmg_dt") == ""   || GetCellValue(i, "curr_cd") == "" 	 	||
					GetCellValue(i, "edi_id") == "" 	 || GetCellValue(i, "eq_loc_cd") == "" 	||
					GetCellValue(i, "eq_cmpo_cd") == ""  || GetCellValue(i, "eq_dmg_cd") == "" 	||
					GetCellValue(i, "eq_rpr_cd") == "" 	 || GetCellValue(i, "vol_tp_cd") == "" 	||
					GetCellValue(i, "rpr_lbr_hrs") == "" || GetCellValue(i, "rpr_lbr_rt") == "" 	||
					GetCellValue(i, "mtrl_cost_amt") == "") {
					RowDelete(i, false);
				}
			}
		}
	}
	/**
     * Event handling of OnSaveEnd of sheet1
	 * @param sheetObj
	 * @param ErrMsg
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
    	with(sheetObj) {
    		SetColBackColor("trf_div_cd",MNR_DISABLE_BACK_COLOR);
	    	SetColBackColor("lbr_cost_amt",MNR_DISABLE_BACK_COLOR);
			SetColBackColor("mnr_wrk_amt",MNR_DISABLE_BACK_COLOR);
			SetColBackColor("edi_err_cd",MNR_DISABLE_BACK_COLOR);
			SetColBackColor("edi_err_nm","#CEFFFF");
			if(/Error/.test(ErrMsg)) {
				ComShowCodeMessage("MNR00008", "");
				ComBtnEnable("btn_Save");
			} else {
				ComShowCodeMessage("MNR00153");
				ComBtnDisable("btn_Save");
			}
			for(var i=HeaderRows(); i <= SearchRows(); i++) {
				if(GetCellValue(i, "edi_err_cd") == "SS") {
 					SetCellFontColor(i, "edi_err_nm","#0000FF");
				} else {
 					SetCellFontColor(i, "edi_err_nm","#FF0000");
				}
			}
    	}
    }
    /**
     * Validating process for input form data
     */
    function validateForm(sheetObj,formObj,sAction){
    	with(sheetObj) {
    		switch(sAction) {
				case IBSAVE:			//Saving
					if(IsDataModified()== false) {
//no support[implemented common]CLT 						ComShowMessage(MessageText("UserMsg13"));
						return false;
					}
					break;
				default :	//do nothing
    		}
        }
        return true;
    }
	/* End of developer's task */
