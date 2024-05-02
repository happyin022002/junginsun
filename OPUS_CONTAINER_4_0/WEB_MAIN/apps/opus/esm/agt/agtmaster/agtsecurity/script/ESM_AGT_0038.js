/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_AGT_0038.js
*@FileTitle : Office code info
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
     * @extends 
     * @class ESM_AGT_0038 : ESM_AGT_0038 business script for.
     */
    function ESM_AGT_0038() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    

 // Common Global Variables
    var sheetObjects = new Array();
    var sheetCnt = 0;
    var sRow = 0;

    /* Event handler processing by button click event */
    document.onclick = processButtonClick;

    /* Event handler processing by button name */
    function processButtonClick(){
    	var sheetObject = sheetObjects[0];
    	var formObject = document.form;

//    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
    		
    		switch(srcName) {
    			case "btn_retrieve":
    				doActionIBSheet(sheetObject,formObject,IBSEARCH);
    				break;

    			case "btn_rowadd":
    			    doActionIBSheet(sheetObject,formObject,IBINSERT);
    				break;
    			
    			case "btn_save":
    				doActionIBSheet(sheetObject,formObject,IBSAVE);
    				break;
    		} // end switch
    		
//    	}catch(e) {
//    		if( e == "[object Error]") {
//    			ComShowMessage(ComGetMsg("COM12111", "", ""));
//    		} else {
//    			ComShowMessage(e);
//    		}
//    	}
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
     * adding first-served functions after loading screen
     */
    function loadPage() {
    	for(i=0;i<sheetObjects.length;i++){
    	    //khlee-Changing Start Environment Setting Method's Name
    		ComConfigSheet(sheetObjects[i]);

    		initSheet(sheetObjects[i],i+1);
    	    
    	    //khlee-Adding Last Environment Setting method
    		ComEndConfigSheet(sheetObjects[i]);
    	}
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
    				// setting height
    				style.height = GetSheetHeight(15);
    				
    				//Whole setting width
    				SheetWidth = mainTable.clientWidth;

    				//setting Host information[mandatory][HostIp, Port, PagePath]
    				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

    				//Whole Merge kind [Optional, Default msNone]
    				MergeSheet = msHeaderOnly;

    			   	//Edit kind [Optional, Default false]
    				Editable = true;

    				//setting Row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    				InitRowInfo(1, 1, 9, 100);

    				//setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    				InitColumnInfo(8, 0, 0, true);

    				//Setting Header Function(SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D)
    				InitHeadMode(true, true, false, true, false,false) ;

    				//setting header Row information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    				var HeadTitle = "DEL|STS|SEQ|Office|AR Office|CURR|Description|Delete";
    				InitHeadRow(0, HeadTitle, true);

                    //Data  properties    [ROW, COL,   DATATYPE,    WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtDelCheck,  40,    daCenter,  false,    "del",     false,    "",         dfNone,     0,          true,       true);
                    InitDataProperty(0, cnt++, dtStatus,    50,    daCenter,  false,    "ibflag",  false,    "",         dfNone,     0,          false,      false);
                    InitDataProperty(0, cnt++, dtSeq,       50,    daCenter,  true,     "",        false,    "",         dfNone,     0,          false,      false);
                    InitDataProperty(0, cnt++, dtPopupEdit, 130,    daCenter,  true,     "agn_cd",   true,     "",         dfNone,     0,          false,      true,       6);
                    InitDataProperty(0, cnt++, dtData,      130,    daCenter,  true,     "ar_ofc_cd", true,     "",         dfNone,     0,          true,       true,       6);
                    InitDataProperty(0, cnt++, dtCombo,     130,    daCenter,  true,     "curr_cd",  false,    "",         dfNone,     0,          true,       true);
    				InitDataProperty(0, cnt++, dtData,      350,   daLeft,    true,     "ofc_delt_rsn", false,    "",         dfNone,     0,          true,       true,       500);
                    InitDataProperty(0, cnt++, dtCombo,     80,    daCenter,  true,     "delt_flg", false,    "",         dfNone,     0,          true,       true);
    				
    				InitDataValid(0, "agn_cd",   vtEngUpOther, "");	//Upper case in English: : Only Possible to Input
                    InitDataValid(0, "ar_ofc_cd", vtEngUpOther, "");	//Upper case in English: : Only Possible to Input
                    InitDataCombo(0, "curr_cd", currText, currCode, "USD");
                    InitDataCombo(0, "delt_flg", "Y|N", "Y|N","N");
    			}
    			break;
    	}
    }

       // handling process for Sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg = false;

    	switch(sAction) {
    	    case IBSEARCH:		//Retrieve
//    			if(!validateForm(sheetObj,formObj,sAction)) return false;
    			formObj.f_cmd.value = SEARCH;
    			sheetObj.DoSearch4Post("ESM_AGT_0038GS.do", agtQryStr(formObj));
    			break;
    			
    		case IBSAVE:		//Save
//    			if(!validateForm(sheetObj,formObj,sAction))	return false;
    			formObj.f_cmd.value = MULTI;
    			sheetObj.DoSave("ESM_AGT_0038GS.do", agtQryStr(formObj));
    			break;
    			
    		case IBINSERT:		//Insert
    			var Row = sheetObj.DataInsert();
    			break;
    	}
    }

    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
    	with(formObj){
    		if (!ComIsNumber(pagerows)) {
    			return false;
    		}
    		
    		switch(sAction) {
    		    case IBSEARCH:		//Retrieve
    		    	formObj.hqofccd.readOnly = true;
    		    	
    		    	if(hqofccd.value == ""){
    		    		showErrMessage(getMsg("AGT10001", "H/Q Office Code ", "", ""));
    		    		hqofccd.readOnly = false;
    		    		hqofccd.focus();
    					return false;
    		    	}
    				break;
    				
    			case IBSAVE:		//Save
    				var sCnt = sheetObj.RowCount;
    				if(sCnt < 1){
    					showErrMessage(getMsg("AGT10004", "", "", ""));
    					return false;		    		
    				}
    				
    				var mCnt = sheetObj.RowCount("I") + sheetObj.RowCount("U") + sheetObj.RowCount("D");
    				if(mCnt < 1){
    					showErrMessage(getMsg("AGT10010", "", "", ""));
    					return false;		    		
    				}
    				break;
    		}
    	}

    	return true;
    }

    /**
     * Calling Biz common pop-up from the sheet
     * - ComOpenPopup() call : sending row, col information to the Parameter  
     */
    function sheet1_OnPopupClick(sheetObj, row, col) {
    	//Office Popup Click   
        if (sheetObj.ColSaveName(col) == "agn_cd") {
            var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1";    // Row PopUp
            var classId = "COM_ENS_071";
    	    var param = '?ofc_lev=6';
    		var chkStr = dispaly.substring(0,3) ;         
            
            if(chkStr == "1,0") {
            	//Radio PopUp  
               	ComOpenPopup('/opuscntr/COM_ENS_071.do' + param, 770, 470, 'getESM_AGT_0038_1', "1,0,1,1,1,1,1", true, false, row, col);
            } 
        }
    }

    /**
     * Office : In case of single Optional by Radio buttons at Pop-up..
     */
    function getESM_AGT_0038_1(rowArray, row, col) {
        var sheetObj = sheetObjects[0];
        
    	var colArray = rowArray[0];
    	sheetObj.CellValue(row, col) = colArray[3];
    }

    /*
     * Implementing on changing column value at the Grid
     */
    function sheet1_OnChange(sheetObj, row, col) {
    	var formObj = document.form;

    	if(sheetObj.ColSaveName(col) == "agn_cd"){
    		sRow = row;
    		formObj.param1.value = sheetObj.CellValue(row,col);
    	    formObj.target = "frmHidden";
    	    formObj.action = "ESM_AGT_0038FR.do";
    	    formObj.submit();
    	}
    }

    /*
     * Setting AR_OFFICE information to Grid
     */
    function setAROfficeInfo(){
    	var formObj  = document.form;
    	var sheetObj = sheetObjects[0];
    	
    	sheetObj.CellValue2(sRow, "ar_ofc_cd") = formObj.param2.value;
    }

