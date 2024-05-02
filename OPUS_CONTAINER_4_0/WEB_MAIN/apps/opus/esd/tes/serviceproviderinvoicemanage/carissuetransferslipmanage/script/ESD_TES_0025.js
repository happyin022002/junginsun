	// global variable
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var Mincount = 0;

	/* Event handler processing by button click event */
	document.onclick = processButtonClick;

	/* Event handler processing by button name */
    function processButtonClick(){
         /***** using extra sheet valuable if there are more 2 sheets *****/
         var sheetObject = sheetObjects[0];

         /*******************************************************/
         var formObject = document.form;

        try {
            var srcName=ComGetEvent("name");

            switch(srcName) {
                case "btng_save":
					if (sheetObjects[0].RowCount() == 0){
						ComShowMessage(ComGetMsg('TES40056'));
					}
					if (!ComShowConfirm('Do you want to save ?')){
						break;
					}
					doActionIBSheet(sheetObject,formObject,IBSAVE);
                    break;
                case "btn_close":
                	ComClosePopup(); 
                    break;
            } // end switch
        }catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(ComGetMsg('TES21025')); //ComShowMessage(OBJECT_ERROR);
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

		var formObj = document.form;
		tes_isNumD(formObj.due_dt,"Y"); 
		formObj.csr_amt.value = tes_chkAmtFmt(formObj.csr_amt.value);

		if(!ComIsNull(csr_no)){
			doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
        } else {
			ComShowMessage(ComGetMsg('TES40015','CSR No.'));
		}
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
            	
                    var HeadTitle = "|SEQ|Incorrect\nOnes|Invoice No.|Net Amount|Tax Amount|W.H.T.|Total Amount|Issue Date|Receive Date|Confirm Date" ;
                    
                    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
                    
                    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                    var headers = [ { Text:HeadTitle, Align:"Center"} ];
                    InitHeaders(headers, info);
                    
                    var cols = [ {Type:"Status",	Hidden:1, Width:20,   Align:"Center",	ColMerge:0,   SaveName:"ibflag",                KeyField:0,   CalcLogic:"" },
                    		{Type:"Seq",				Hidden:0,	Width:30,		Align:"Center",		ColMerge:0,   SaveName:"",                          	KeyField:0,   CalcLogic:"",   Format:"" },
                    		{Type:"CheckBox",   Hidden:0, Width:60,    Align:"Center",  		ColMerge:0,   SaveName:"chk",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    		{Type:"Text",				Hidden:0,	Width:110,	Align:"Left",			ColMerge:0,   SaveName:"inv_no",                    KeyField:0,   CalcLogic:"",   Format:"" },
                    		{Type:"Text",				Hidden:0,	Width:90,		Align:"Right",		ColMerge:0,   SaveName:"ttl_inv_amt",             KeyField:0,   CalcLogic:"",   Format:"Float",            PointCount:2 },
                    		{Type:"Text",				Hidden:0,	Width:90,		Align:"Right",		ColMerge:0,   SaveName:"vat_amt",               	KeyField:0,   CalcLogic:"",   Format:"Float",            PointCount:2 },
                    		{Type:"Text",				Hidden:0,	Width:90,		Align:"Right",		ColMerge:0,   SaveName:"whld_tax_amt",     	KeyField:0,   CalcLogic:"",   Format:"Float",            PointCount:2 },
                    		{Type:"Text",				Hidden:0,	Width:120,	Align:"Right",		ColMerge:0,   SaveName:"total_amt",            	KeyField:0,   CalcLogic:"",   Format:"Float",            PointCount:2 },
                    		{Type:"Text",				Hidden:0,	Width:90,		Align:"Center",		ColMerge:0,   SaveName:"iss_dt",                  	KeyField:0,   CalcLogic:"",   Format:"" },
                    		{Type:"Text",				Hidden:0,	Width:90,		Align:"Center",		ColMerge:0,   SaveName:"rcv_dt",                  	KeyField:0,   CalcLogic:"",   Format:"" },
                    		{Type:"Text",				Hidden:0,	Width:90,		Align:"Center",		ColMerge:0,   SaveName:"inv_cfm_dt",           	KeyField:0,   CalcLogic:"",   Format:"" },
                    		{Type:"Text",				Hidden:1,	Width:100,	Align:"Center",		ColMerge:0,   SaveName:"tml_so_ofc_cty_cd",	KeyField:0,   CalcLogic:"",   Format:"" },
                    		{Type:"Text",				Hidden:1,	Width:100,	Align:"Center",		ColMerge:0,   SaveName:"tml_so_seq",            KeyField:0,   CalcLogic:"",   Format:"" },
                    		{Type:"Text",				Hidden:1,	Width:100,	Align:"Center",		ColMerge:0,   SaveName:"aft_act_flg",             KeyField:0,   CalcLogic:"",   Format:"" } ];
                    
                    InitColumns(cols);
                    SetEditable(1);
                    resizeSheet();
               }
                break;
        }
    }
    // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
           case IBSEARCH:      //Retrieve
                if (!validateForm(sheetObj,formObj,sAction)){
			        return false;
			    }
			    formObj.f_cmd.value = SEARCHLIST;
			    sheetObj.DoSearch("ESD_TES_0025GS.do", tesFrmQryStr(formObj));
			    break;

			case IBSAVE:        //Save
                if (!validateForm(sheetObj,formObj,sAction)){
			        return false;
			    }
				formObj.f_cmd.value = MULTI;
				var param = sheetObj.GetSaveString();
				var sXml = sheetObj.GetSaveData("ESD_TES_0025GS.do", param+'&'+tesFrmQryStr(formObj));
				sheetObj.LoadSaveData(sXml,true);
                break;
        }
    }

	function sheet1_OnClick(sheet1, Row,Col,Value){
		if (sheet1.ColSaveName(Col) == 'inv_no'){
//			ComShowMessage(' cell value:' + sheet1.CellValue(Row,'chk') );
		}
	}

	function sheet1_OnSaveEnd(sheet1, ErrMsg){
		if (sheet1.RowCount() > 0){	
			for (var i=sheet1.HeaderRows(); i<( sheet1.HeaderRows() + sheet1.RowCount() ); i++){
				if (sheet1.GetCellValue(i,'aft_act_flg')!=undefined && sheet1.GetCellValue(i,'aft_act_flg')=='N'){
					parent.retrieve();
					ComClosePopup();
					break;
				}
			}
		}
	}

	function sheet1_OnSearchEnd(sheet1, ErrMsg){
		if (sheet1.RowCount() > 0){	
			for (var i=sheet1.HeaderRows(); i<( sheet1.HeaderRows() + sheet1.RowCount() ); i++){
				sheet1.SetCellValue(i,'chk', 1);
			}
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
     * MInimize click event
     */
    function Minimize(nItem)
    {
        var objs = document.all.item("showMin");
        if ( nItem == "1" )
        {
            objs.style.display = "none";
            sheetObjects[0].SetSheetHeight(ComGetSheetHeight(sheetObj, 20));
    	    sheetObjects[0].GetSheetHeight(20);
			sheetObjects[0].focus();
        }
        else
        {
            objs.style.display = "inline";
    	    sheetObjects[0].SetSheetHeight(ComGetSheetHeight(sheetObj, 10));
			sheetObjects[0].focus();
        }
    }
    // UI 표준화관련 하단 여백 설정
    function resizeSheet() {
    	    ComResizeSheet(sheetObjects[0]);
    }