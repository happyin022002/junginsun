/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0014.js
*@FileTitle  : S/C Prefix Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
    // global variables
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event
    document.onclick=processButtonClick;
    
	/**
     * Event handler processing by button name  <br>
     */
    function processButtonClick(){
    	var sheetObject1=sheetObjects[0];
    	var sheetObject2=sheetObjects[1];
    	/** **************************************************** */
    	var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
    		switch(srcName) {
	    		case "btn_RowAdd":
	    			doActionIBSheet(sheetObject1,formObject,IBINSERT);
	    			break;
	    		case "btn_Delete":
	    			doActionIBSheet(sheetObject1,formObject,IBDELETE);
	    			break;
	    		case "btn_Retrieve":
	    			sheetObject1.ColumnSort();
	    			doActionIBSheet(sheetObject1,formObject,IBSEARCH);
	    			break;
	    		case "btn_Save":
	    			doActionIBSheet(sheetObject1,formObject,IBSAVE);
	    			break;
    		} // end switch
    	} catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e.message);
    		}
        } finally {
            ComOpenWait(false);
    	}
    }
    
    /**
     * registering IBSheet Object as list <br>
     * adding process for list in case of needing batch processing with other items  <br>
     * defining list on the top of source <br>
     */
    function setSheetObject(sheet_obj){
    	sheetObjects[sheetCnt++]=sheet_obj;
    }
    
    /**
     * Initializing and setting Sheet basics <br>
     * Setting body tag's onLoad event handler <br>
     * Adding pre-handling function after loading screen on the browser  <br>
     */
    function loadPage() {
        try {
            for(i=0;i<sheetObjects.length;i++){
        		ComConfigSheet (sheetObjects[i] );
        		initSheet(sheetObjects[i],i+1);
        		ComEndConfigSheet(sheetObjects[i]);
        	}
            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        } catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e.message);
            }
        } finally {
            ComOpenWait(false);
        }
    }
    
    /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets <br>
     */
    function initSheet(sheetObj,sheetNo) {
    	var cnt=0;
    	switch(sheetNo) {
    		case 1:      // sheet1 init
        	    with(sheetObj){
    				//no support[check again]CLT 		if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
    				var HeadTitle="|Sel.|Seq.|Code|Description";
    				var headCount=ComCountHeadTitle(HeadTitle);

    				SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

    				var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
    				var headers = [ { Text:HeadTitle, Align:"Center"} ];
    				InitHeaders(headers, info);

    				var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
    				             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"chk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    				             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
    				             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"sc_pfx_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3, InputCaseSensitive:1, AcceptKeys:"E|N"},
    				             {Type:"Text",      Hidden:0,  Width:95,   Align:"Left",    ColMerge:1,   SaveName:"sc_pfx_desc",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 } ];
               
    				InitColumns(cols);
    				
    				SetEditable(1);
    				SetWaitImageVisible(0);
    				resizeSheet();//SetSheetHeight(480);
              }
              break;
    	}
    }
    function resizeSheet(){
    	ComResizeSheet(sheetObjects[0]);
    }
    
    /**
     * Handling sheet process <br>
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg(false);
    	switch(sAction) {
	    	case IBSEARCH:      //retrieve
	    	    ComOpenWait(true);
	    		if ( sheetObj.id == "sheet1"){
	    		    ComOpenWait(true);
	    			formObj.f_cmd.value=SEARCH01;
 	    			sheetObj.DoSearch("ESM_PRI_0014GS.do", FormQueryString(formObj) );
	    			ComOpenWait(false);
	    		}
	    		ComOpenWait(false);
		    	break;
	    	case IBSAVE:       
	    	    ComOpenWait(true);
                if(!ComPriConfirmSave()){
                    return;
                }
		    	if(!validateForm(sheetObj,formObj,sAction)){
		    		return;
		    	}
		    	formObj.f_cmd.value=MULTI01;
		    	sheetObj.DoSave("ESM_PRI_0014GS.do", FormQueryString(formObj), -1, false);
		    	ComOpenWait(false);
		    	break;
	    	case IBINSERT:     
	    		var row=sheetObj.DataInsert();
	    	    sheetObj.SelectCell(row, "sc_pfx_cd");
	    	    sheetObj.ReNumberSeq();
		    	break;
	    	case IBDELETE:      
	    		deleteRowCheck(sheetObj, "chk", true);
		    	break;
	    }
    }
    
    /**
     * checking validation process of inputed form data <br>
     */
    function validateForm(sheetObj,formObj,sAction){
    	with(sheetObj){
    	    var Row=ColValueDup("sc_pfx_cd");
    	    if(Row > -1){
    	        ComShowCodeMessage('PRI00302');
    	        sheetObj.SelectCell(Row, "sc_pfx_cd");
    	        return false;
    	    }
            var sParam=GetSaveString();
    	    if (sParam != "" && IsDataModified()) {
                formObj.f_cmd.value=SEARCH02;
                sParam=FormQueryString(formObj) + "&" + sParam;
                var sXml=GetSearchData("ESM_PRI_0014GS.do", sParam);
                var usedData=ComGetEtcData(sXml, "usedData");
                
                var insData=FindStatusRow("I");
                var insArr=insData.split(";");
                var insRow;
                for (var i=0, n=insArr.length ; i < n ; i++) {
                	insRow=Number(insArr[i]);
                	if(insRow != 0 && sheetObj.GetCellValue(insRow, "sc_pfx_cd").length != 3) {
                		ComShowCodeMessage("PRI00314", insRow +" Recode [" + sheetObj.GetCellValue(0, "sc_pfx_cd") + "] 3");
                		return false;
                	}
                }
                
                if (usedData != "") {
                    ComShowCodeMessage("PRI01113");
                    var delData=FindStatusRow("D");
                    var dupArr=delData.split(";");
                    var row;
                    for (var i=0, n=dupArr.length ; i < n ; i++) {
                        row=Number(dupArr[i]);
                        SetRowHidden(row,0);
                        SetRowStatus(row,"R");
                        SetCellValue(row, "chk","1");
                        if (i == 0) {
                            SetSelectRow(row);
                        }
                    }
                    return false;
                }
    	    }
    	}
    	return true;
    }
    
    /**
     * calling function when occurring OnSaveEnd event  <br>
     * showing origin deleted row when saving error
     * 
     * <br>
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
        if (sheetObj.GetEtcData(ComWebKey.Trans_Result_Key) != "S") {
            var sRow=sheetObj.FindStatusRow("D");
            var arRow=sRow.split(";");
            for (var i=0, n=arRow.length-1 ; i < n ; i++) {
                sheetObj.SetRowHidden(arRow[i],0);
                sheetObj.SetRowStatus(arRow[i],"R");
            }
        }
        //sheetObj.ReNumberSeq();
    }
        
    function sheet1_OnSort(sheetObj ,Col, SortArrow){
    	  sheet1.ReNumberSeq();   
    	 }
