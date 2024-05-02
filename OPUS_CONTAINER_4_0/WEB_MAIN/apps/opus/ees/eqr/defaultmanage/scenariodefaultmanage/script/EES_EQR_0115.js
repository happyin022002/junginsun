/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : EES_EQR_0115.js
*@FileTitle : retrieving/modifying ECC info
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/30
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   /**
     * @fileoverview 
     * @author 
     */
    // common static variable
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    var saveFlg0=false;
    var saveFlg1=false;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
        var sheetObject=sheetObjects[0];  
        var sheetObject1=sheetObjects[1]; 
		var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
                case "btn_new":
                    formObject.reset();
                    document.form.location.disabled=true;
                    sheetObject.RemoveAll();
                    sheetObject1.RemoveAll();
                    break;
        	    case "btn_retrieve":
    	            doActionIBSheet(sheetObject,formObject,IBSEARCH);
    	            sheetObject1.RemoveAll();
        	        break;
                case "btn_save":
                	var sRow1=sheetObject.FindStatusRow("U|D");
                	var sRow2=sheetObject1.FindStatusRow("U|D");
					if(sRow1=="" && sRow2 == "") {
						ComShowCodeMessage("EQR90008");
					}else if(sRow1!="" && sRow2 == "") {
						doActionIBSheet(sheetObject,formObject,IBSAVE);
					}else {
                    	doActionIBSheet2(sheetObject1,formObject,IBSAVE);
                    }
                    break;
                case "btn_print":
                	if(sheetObjects[0].RowCount('') > 0){
                     	sheetObjects[0].DoPrint();
                	}
                	if(sheetObjects[1].RowCount('') > 0){
                     	sheetObjects[1].DoPrint();
                	}
                	if(sheetObjects[0].RowCount('') == 0 && sheetObjects[1].RowCount('') == 0){
                		ComShowCodeMessage("EQR90095");
                	}
              		break;
                case "btn_downexcel":
                	if(sheetObject.RowCount() < 1){
                		ComShowCodeMessage("COM132501");
                	}else{
                		doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
                	}                	
                    break;
                case "btn_eqorg":
                    // calling EQR Organization Chart as pop-up
					//var modal =  ComOpenWindow('EES_EQR_0139.do',  self,  "dialogLeft:0px; dialogTop:0px; dialogWidth:500px; dialogHeight:574px; scroll:no; status:no" , true);
					var modal =  ComOpenWindowCenter('EES_EQR_0139.do',  self,  '500', '574' , true);
                    break;
              	case "loc_btn":
                	var display="0,1,1,1,1,1";
                	var targetObjList="loc_dpth_cd:status|loc_cd:location";
  				    var param="?depth=3&classId=COM_ENS_0O1";
  				    ComOpenPopupWithTarget('/opuscntr/COM_ENS_0O1.do' + param, 400, 470, targetObjList, display, true);
  				    break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowCodeMessage("EQR90004");
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
        for(i=0; i<sheetObjects.length; i++) {
            ComConfigSheet (sheetObjects[i]);  
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);  			 
        }
        document.form.location.disabled=true;
        initControl();
    }
  /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      //IBSheet1 init
                with(sheetObj){
                
              var HeadTitle0="STS|ECC|Storage(TEU)|Storage(TEU)|Storage(TEU)|Weekly inflow(Box)|Weekly inflow(Box)|TS|Cost Info(USD)|Cost Info(USD)|Cost Info(USD)|Cost Info(USD)|Cost Info(USD)|Cost Info(USD)|Cost Info(USD)|Cost Info(USD)|Cost Info(USD)|Cost Info(USD)|Cost Info(USD)|Cost Info(USD)|Exceptional Min Bounds|Exceptional Min Bounds|Exceptional Min Bounds|Exceptional Min Bounds" ;
              var HeadTitle1="STS|ECC|Max|Min|Free|Max\nVol.|Min\nVol.|TS|Stevedorage|Stevedorage|Stevedorage|Storage Cost|Storage Cost|Storage Cost|Handling Cost|Handling Cost|Handling Cost|Shuttle Cost|Shuttle Cost|Shuttle Cost|From\nWeek|To\nWeek|Storage|Weekly\nHandling" ;
              var HeadTitle2="STS|ECC|Max|Min|Free|Max\nVol.|Min\nVol.|TS|20'|40'|45'|20'|40'|45'|20'|40'|45'|20'|40'|45'|From\nWeek|To\nWeek|Storage|Weekly\nHandling" ;

              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:2, DataRowMerge:0 } );

              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle0, Align:"Center"},
                          { Text:HeadTitle1, Align:"Center"},
                          { Text:HeadTitle2, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"ecc_cd",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"sto_max_qty",         KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"sto_min_qty",         KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"sto_free_qty",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
                     {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"wky_max_hndl_qty",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
                     {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"wky_min_hndl_qty",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
                     {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ts_div_flg",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"stv_20ft_cost_amt",   KeyField:1,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
                     {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"stv_40ft_cost_amt",   KeyField:1,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
                     {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"stv_45ft_cost_amt",   KeyField:1,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
                     {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"sto_20ft_cost_amt",   KeyField:1,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
                     {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"sto_40ft_cost_amt",   KeyField:1,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
                     {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"sto_45ft_cost_amt",   KeyField:1,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
                     {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"hndl_20ft_cost_amt",  KeyField:1,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
                     {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"hndl_40ft_cost_amt",  KeyField:1,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
                     {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"hndl_45ft_cost_amt",  KeyField:1,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
                     {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"sttl_20ft_cost_amt",  KeyField:1,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
                     {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"sttl_40ft_cost_amt",  KeyField:1,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
                     {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"sttl_45ft_cost_amt",  KeyField:1,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
                     {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"expt_fm_wk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
                     {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"expt_to_wk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
                     {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"expt_sto_qty",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
                     {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"expt_wky_hndl_qty",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
                     {Type:"Text",      Hidden:1, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"timegap",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:13 } ];
               
              InitColumns(cols);

              SetEditable(1);
              SetCellBackColor(1,9,"#555555");
              SetColProperty("expt_fm_wk", {Format:"####-##"} );
              SetColProperty("expt_to_wk", {Format:"####-##"} );
              //SetRangeBackColor(1,2,1,6,"#555555");
              //SetRangeBackColor(1,8,1,23,"#555555");
              //SetRangeBackColor(2,8,2,23,"#555555");
              SetHeaderRowHeight(10);
//              SetSheetHeight(ComGetSheetHeight(sheetObj, 20));
              resizeSheet(sheetObj);
              }
                break;
            case 2:      //IBSheet1 init
                with(sheetObj){
                //SetSheetHeight(0);// (Hidden)
              
              var HeadTitle0="STS|FM Lane|FM Dir|TO Lane|FM Yard|TO Yard|T/S Cost(USD)|T/S Cost(USD)|T/S Cost(USD)" ;
              var HeadTitle1="STS|FM Lane|FM Dir|TO Lane|FM Yard|TO Yard|20'|40'|45'" ;

              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:0 } );

              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle0, Align:"Center"},
                          { Text:HeadTitle1, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag1" },
                     {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"fm_slan_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"lane_dir_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1 },
                     {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"to_slan_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
                     {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"fm_yd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:7 },
                     {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"to_yd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:7 },
                     {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"ts_20ft_uc_amt",  KeyField:1,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
                     {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"ts_40ft_uc_amt",  KeyField:1,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
                     {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"ts_45ft_uc_amt",  KeyField:1,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ecc_cd1",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 } ];
               
              InitColumns(cols);

              SetEditable(1);
                    SetRangeBackColor(1,5,1,8,"#555555");
              SetHeaderRowHeight(10);
              SetVisible(0);
              resizeSheet(sheetObj);
              }
                break;
        }
    }
	function resizeSheet( sheetObj ){
	    ComResizeSheet( sheetObj );
	}
  // handling process for Sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			case IBSEARCH:      //retrieve
               	if(validateForm(sheetObj,formObj,sAction)) {
               		formObj.f_cmd.value=SEARCHLIST;
            			sheetObj.DoSearch("EES_EQR_0115GS.do", eqrFormQryStr(formObj) );
				}
                break;
            case IBSAVE:        //saving
             	if(validateForm(sheetObj,     formObj,sAction))
				if(validateWeekData(sheetObj)) { // checking from week, fo week are fiiled
             		formObj.f_cmd.value=MODIFY;
             		saveFlg0=true;
             		sheetObj.DoSave("EES_EQR_0115GS.do?ibflag1=", eqrFormQryStr(formObj));
                }
                break;
            case IBDOWNEXCEL:
               	sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(              	sheetObj), SheetDesign:1,Merge:1 });
                if(sheetObjects[1].RowCount('') > 0){
                 	sheetObjects[1].Down2Excel( {DownCols: makeHiddenSkipCol(                	sheetObjects[1]), SheetDesign:1,Merge:1 });
                }
                break;
        }
    }
    function doActionIBSheet2(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        var ecc_cd=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 'ecc_cd');
        var cnt=0;
        switch(sAction) {
			case IBSEARCH:     // double click on Sheet1
           		if(validateForm(sheetObj,formObj,sAction))
           		formObj.f_cmd.value=SEARCHLIST01;
            		sheetObj.DoSearch("EES_EQR_0115GS2.do?ecc_cd=ecc_cd", eqrFormQryStr(formObj) );
           		break;
            case IBSAVE:        //saving
   				saveFlg0=true;
		    	saveFlg1=true;
				// submitting all data on SHEET1, SHEET2
      			var params=new Array();
      			params[0]=sheetObjects[0].GetSaveString(true ,false);
      			params[1]=sheetObjects[1].GetSaveString(true ,false);
	  			formObj.f_cmd.value=MODIFY;
 	  			var savexml=sheetObj.GetSaveData("EES_EQR_0115GS2.do", ComGetAryJoin(params, "&")+"&"+eqrFormQryStr(formObj));
       			sheetObjects[0].LoadSaveData(savexml,true);
       			sheetObjects[1].LoadSaveData(savexml,true);
      			break;
        }
    }
    /**
     * registering IBTab Object as list
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++]=tab_obj;
    }
    /**
     * initializing Tab
     * setting Tab items
     */
    function initTab(tabObj , tabNo) {
         switch(tabNo) {
             case 1:
                with (tabObj) {
                    var cnt=0 ;
                    InsertItem( "ST On-hire  " , "");
                    InsertItem( "ST Off-hire " , "");
                    InsertItem( "LT Off-hire " , "");
					InsertItem( "New Van/LT  " , "");
					InsertItem( "US Domestic " , "");
					InsertItem( "Sublease-out" , "");
					InsertItem( "Constraint  " , "");
					InsertItem( "Safety Stock" , "");
					InsertItem( "RLA List    " , "");
					InsertItem( "O/B Forecast" , "");
					InsertItem( "I/B Forecast" , "");
					InsertItem( "ECC info.   " , "");
					InsertItem( "Link info.  " , "");
					InsertItem( "Vessel SKD  " , "");
					InsertItem( "BSA         " , "");
					InsertItem( "Vessel Residual Capa" , "");
                }
             break;
         }
    }
    /**
     * Event when clicking Tab
     * activating selected tab items
     */
    function tab1_OnChange(tabObj , nItem)
    {
        var objs=document.all.item("tabLayer");
    	objs[nItem].style.display="Inline";
    	objs[beforetab].style.display="none";
    	//--------------- Important --------------------------//
    	objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
    	//------------------------------------------------------//
    	beforetab=nItem;
    }
   /**
     * handling process for input validation
     * sAction : IBSEARCH - 0
     */
    function validateForm(sheetObj,formObj,sAction) {
        with(formObj){
			if(sAction==0) {  // IBSEARCH
           		if(!checkLocItem(formObj, 'status', 'location')) {
            		return false;
            	}
			}
        }
        return true;
    }
	// setting location
  	function locChange(key) {
    	var gubun=key;
      	if(gubun =="") {
      		document.form.location.value="";
      		document.form.location.disabled=true;
      	}else {
      		document.form.location.value="" ;
      		document.form.location.disabled=false;
      	}
    }
	/*
	   for max update, max userid info
	*/
  	function sheet1_OnSearchEnd(sheetObj, errMsg) {
  	  ComEtcDataToForm(document.form, sheetObj);
  	  setColor(sheetObj, '3');
  	}
	/*
	 - in case of SHEET1 ONCHAGE, checking modified FROM WEEK, FROM TO value
	  1) checking form is week
	  2) FROM WEEK <= TO WEEK
	  3) FROM WEEK, TO WEEK should be full filled
	*/
	function sheet1_OnChange(sheetObj, row, col, value) {
		var expt_fm_dt="";
		var expt_to_dt="";
		var weekInput="";
		var colName=sheetObj.ColSaveName(col);
		if(colName == "expt_fm_wk" || colName == "expt_to_wk") { // expt_fm_dt, expt_to_dt
			weekInput=sheetObj.GetCellValue(row, col); // input data week
			expt_fm_dt=sheetObj.GetCellValue(row, "expt_fm_wk");
			expt_to_dt=sheetObj.GetCellValue(row, "expt_to_wk");
	  		//1) checking from is week
			if(weekInput.length < 6) {
				ComShowCodeMessage("EQR90056");
				sheetObj.SetCellValue(row, col,"",0);
				return false;
			}else {
				if(weekInput.substring(4,6) < 01 || weekInput.substring(4,6) > 53) {
					ComShowCodeMessage("EQR90056");
					sheetObj.SetCellValue(row, col,"",0);
					return false;
				}
			}
			// 2) FROM WEEK <= TO WEEK
			if(expt_fm_dt != "" && expt_to_dt != "") {
				if(expt_fm_dt > expt_to_dt) {
					ComShowCodeMessage("EQR90033");
					sheetObj.SetCellValue(row, col,"",0);
					return false;
				}
			}
		}
    }
    /*
     - in case of filled only one of from week, to week after save button
       messaging to user
    */
    function validateWeekData(sheetObj) {
		var expt_fm_dt="";
		var expt_to_dt="";
  		var sRow=sheetObj.FindStatusRow("U|D");
  		var arrRow=sRow.split(';');
  		var result=true;
  		for(idx=0; idx<arrRow.length-1; idx++) {
  			expt_fm_dt=sheetObj.GetCellValue(arrRow[idx], "expt_fm_wk");
  			expt_to_dt=sheetObj.GetCellValue(arrRow[idx], "expt_to_wk");
			if(expt_fm_dt == "" && expt_to_dt != "") { // in case of only filled expt_to_dt 
				ComShowCodeMessage("EQR90034", arrRow[idx]-2);
				result=false;
			}
			if(expt_fm_dt != "" && expt_to_dt == "") { // in case of only filled expt_fm_dt 
				ComShowMessage("Please input data To Week at line "+(arrRow[idx]-2)+"  ! ");
				ComShowCodeMessage("EQR90035", arrRow[idx]-2);
				result=false;
			}
  		}
  		return result;
    }
    // messageing after saving
    function sheet1_OnSaveEnd(sheetObj, errMsg) {
    	if(errMsg=='') {
       		if((saveFlg0 == true && saveFlg1 == false) || (saveFlg0 == true && saveFlg1 == true)){
       			ComShowCodeMessage("EQR90106");
        	}
        }
        saveFlg0=false;
        saveFlg1=false;
    }
    // messageing after saving
    function sheet2_OnSaveEnd(sheetObj, errMsg) {
        if(errMsg=='') {
        	if(saveFlg0 == true && saveFlg1 == true){
        		ComShowCodeMessage("EQR90106");
        	}
    	}
        saveFlg0=false;
        saveFlg1=false;
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }
    function form_click(){
    	srcName=ComGetEvent("name");
    	if ( srcName == "userid"){
    		var userId=document.form.userid.value;
    		if ( userId != "" ){
   				ComUserPopup(userId);
    		}
    	}
    }
    function initControl() {
		axon_event.addListenerForm('click', 'form_click',    document.form); //- when clicked
    }
