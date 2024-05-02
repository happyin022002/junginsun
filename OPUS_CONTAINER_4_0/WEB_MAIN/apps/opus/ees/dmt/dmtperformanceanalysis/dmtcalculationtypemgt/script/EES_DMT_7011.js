/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_7011.js
*@FileTitle  : Combination Set-up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    			MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     			OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   /**
     * @fileoverview
     * @author OPUS
     */
    /**
     * @extends 
     * @class EES_DMT_7011 : business script for Combination Set-up
     */
 
    /* Common global variable */
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;	
	//Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
    	try {
     		var srcObj=ComGetEvent();
     		var srcName=srcObj.getAttribute("name");;
            switch(srcName) {
				case "btn_RowAdd":
					doActionIBSheet(sheetObj,formObj,IBINSERT);
					break;
				case "btn_RowDelete":
					doActionIBSheet(sheetObj,formObj,IBDELETE);
					break;
				case "btn_Retrieve":
					doActionIBSheet(sheetObj,formObj,IBSEARCH);
					break;
				case "btn_Save":
					doActionIBSheet(sheetObj,formObj,IBSAVE);
					break;
            } // end switch
    	} catch(e) {
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
        for (i=0 ; i < sheetObjects.length ; i++) {
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        
        //IBSheet Web 버전에서는 아래 함수가 자동으로 호출되지 않기 때문에,
        //아래와 같이 명시적으로 호출해줘야 됨.
        sheet1_OnLoadFinish(sheetObjects[0]);
    }
    /**
     * handling process after ending sheet1 load
     */
    function sheet1_OnLoadFinish(sheetObj) {
	    sheetObj.SetWaitImageVisible(0);
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	    sheetObj.SetWaitImageVisible(1);
	}
   /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        var cntrTpCombo="Dry|Reefer|Flat Rack|Open Top|TANK";
        var cgoTpCombo="OUT OF GAUGE|DANGEROUS|GENERAL|TEMPERATURE CONTROL";
        switch(sheetNo) {
            case 1:      // sheet1 init
                with(sheetObj){
               
            var HeadTitle="||Seq.|Container Type|Cargo Type|Create User|Create Date|Update User|Update Date";
            var headCount=ComCountHeadTitle(HeadTitle);
            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
            var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
            var headers = [ { Text:HeadTitle, Align:"Center"} ];
            InitHeaders(headers, info);
            var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"del_chk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
             {Type:"Combo", 	Hidden:0, Width:150,  Align:"Center",  ColMerge:1,   SaveName:"dmdt_cntr_tp_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1 },
             {Type:"Combo", 	Hidden:0, Width:250,  Align:"Center",  ColMerge:1,   SaveName:"dmdt_cgo_tp_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"cre_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"upd_usr_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"upd_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
             
            InitColumns(cols);
            SetSheetHeight(535);
            SetEditable(1);
            SetColProperty("dmdt_cntr_tp_cd", {ComboText:cntrTpCombo, ComboCode:"D|R|F|O|T"} );
            SetColProperty("dmdt_cgo_tp_cd", {ComboText:cgoTpCombo, ComboCode:"AWK|DGR|DRY|RFR"} );
            }


                break;
        }
    }
	// handling of Sheet process
	function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
	        case IBINSERT:
	        	sheetObj.DataInsert(-1);
	        	break;				
	        case IBDELETE:
	        	ComRowHideDelete(sheetObj, "del_chk");
	        	break;
			case IBSEARCH:
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				ComSetObjValue(formObj.f_cmd, SEARCH);
				sheetObj.DoSearch("EES_DMT_7011GS.do", FormQueryString(formObj) );
	            ComOpenWait(false);
				break;
			case IBSAVE:
				for(var i=1; i <= sheetObj.RowCount()+1; i++){
					/*if((sheetObj.GetCellValue(i, "dmdt_cntr_tp_cd") == "" || sheetObj.GetCellValue(i, "dmdt_cntr_tp_cd") == null)|| (sheetObj.GetCellValue(i, "dmdt_cgo_tp_cd") == "" || sheetObj.GetCellValue(i, "dmdt_cgo_tp_cd") == null)){
	    				ComShowCodeMessage("COM130403", "Container Type and Cargo Type");
	    				return;
	    			}*/
	    		}
				ComSetObjValue(formObj.f_cmd, MULTI);
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				sheetObj.DoSave("EES_DMT_7011GS.do", FormQueryString(formObj));
				ComOpenWait(false);
				break;
        }
    }
	/**
	 * sheet1 change event
	 */
	function sheet1_OnChange(sheetObj, Row, Col) {
		var sheetObj=sheetObjects[0];
	 	var formObj=document.form;
	 	if((sheetObj.GetCellValue(Row, "dmdt_cntr_tp_cd") != "" && sheetObj.GetCellValue(Row, "dmdt_cntr_tp_cd") != null)
	 			&& (sheetObj.GetCellValue(Row, "dmdt_cgo_tp_cd") != "" && sheetObj.GetCellValue(Row, "dmdt_cgo_tp_cd") != null)){
	 		var insVal=sheetObj.GetCellValue(Row, "dmdt_cntr_tp_cd") + sheetObj.GetCellValue(Row, "dmdt_cgo_tp_cd");
	 		for(var i=1; i <= sheetObj.RowCount()+1; i++){
	 			if(i == Row) {
	 				continue;
	 			}
	 			var orgVal=sheetObj.GetCellValue(i, "dmdt_cntr_tp_cd") + sheetObj.GetCellValue(i, "dmdt_cgo_tp_cd");
	 			if(insVal == orgVal) {
	 				ComShowCodeMessage("COM131302", "Container Type and Cargo Type");
    				return;
	 			}
	 		}
		}
	}
	/**
	 * handling process after ending sheet1 save
	 */
	function sheet1_OnSaveEnd(sheetObj,  code, ErrMsg) {
		var formObj=document.form;
		doActionIBSheet(sheetObj,formObj,IBSEARCH);
	}
