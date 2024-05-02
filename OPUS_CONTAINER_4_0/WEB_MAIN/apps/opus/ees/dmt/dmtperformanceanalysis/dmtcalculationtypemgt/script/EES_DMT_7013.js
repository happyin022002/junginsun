/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_7013.js
*@FileTitle  : Tariff Type Entry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

    /* Common global variable */
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;	
	//Event handler processing by button click event
	document.onclick=processButtonClick;
	
	//Event handler processing by button name
    function processButtonClick(){
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
    	try {
     		var srcName=ComGetEvent("name");
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
        switch(sheetNo) {
            case 1:      // sheet1 init
                with(sheetObj){
            		
            		
            	    var HeadTitle="||Seq.|Tariff Type|Tariff Name|In/Out|Calculation Type|Dem/Det Type|Create User|Create Date|Update User|Update Date";
            	    var headCount=ComCountHeadTitle(HeadTitle);

            	    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

            	    var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
            	    var headers = [ { Text:HeadTitle, Align:"Center"} ];
            	    InitHeaders(headers, info);

            	    var cols = [ {Type:"Status",    Hidden:1, Width:10,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
            	                 {Type:"CheckBox",  Hidden:0, Width:25,   Align:"Center",  ColMerge:1,   SaveName:"del_chk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	                 {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
            	                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"dmdt_trf_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:4 },
            	                 {Type:"Text",      Hidden:0,  Width:260,  Align:"Center",  ColMerge:1,   SaveName:"dmdt_trf_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
            	                 {Type:"Combo", 	Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"io_bnd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
            	                 {Type:"Combo", 	Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"mgmt_calc_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
            	                 {Type:"Combo", 	Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"mgmt_trf_div_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
            	                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cre_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"upd_usr_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"upd_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
            	     
            	    InitColumns(cols);
            	    SetEditable(1);
            	    SetColProperty("io_bnd_cd", {ComboText:"Inbound|Outbound", ComboCode:"I|O"} );
            		SetColProperty("mgmt_calc_tp_cd", {ComboText:"Dual|Combine", ComboCode:"D|C"} );
            		SetColProperty("mgmt_trf_div_cd", {ComboText:"DEM|DET", ComboCode:"DEM|DET"} );
            	    SetSheetHeight(530);
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
	    		// 조회결과 초기화 및 Sort 기능이 적용된 경우, 적용해제해 준다.
	    		sheetObj.RemoveAll();	
	    		
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				ComSetObjValue(formObj.f_cmd, SEARCH);
				sheetObj.DoSearch("EES_DMT_7013GS.do", FormQueryString(formObj) );
	            ComOpenWait(false);
				break;
			case IBSAVE:
				for(var i=1; i < sheetObj.rowCount+1; i++){
					if(sheetObj.GetCellValue(i, "dmdt_trf_cd") == "" || sheetObj.GetCellValue(i, "dmdt_trf_cd") == null){
	    				ComShowCodeMessage("COM130403", "Tariff Type");
	    				return;
	    			}
	    		}
				ComSetObjValue(formObj.f_cmd, MULTI);
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				sheetObj.DoSave("EES_DMT_7013GS.do", FormQueryString(formObj));
				ComOpenWait(false);
				break;
        }
    }
	
	/**
	 * sheet1 change event
	 */
	function sheet1_OnChange(sheetObj, Row, Col) {
	 	var cdCol=sheetObj.SaveNameCol("dmdt_trf_cd");
	 	if (Col == cdCol && Row !=0) { 
	 		var GetCellValue=sheetObj.cellValue(Row, Col);
	 		var Row2=sheetObj.FindText(Col, GetCellValue, 0, -1, false);
	 		if(Row2 > 0){
	 			Row2=sheetObj.FindText(Col, GetCellValue, Row2+1);
	 			if (Row2 > 0) {
		        	ComShowCodeMessage('COM12115', 'Tariff Type');
					sheetObj.SetCellValue(Row, Col,'',0);
					sheetObj.SelectCell(Row, Col, true);
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

	function sheet1_OnSort(sheetObj, Col, SortArrow){
		sheetObj.ReNumberSeq();   
	}