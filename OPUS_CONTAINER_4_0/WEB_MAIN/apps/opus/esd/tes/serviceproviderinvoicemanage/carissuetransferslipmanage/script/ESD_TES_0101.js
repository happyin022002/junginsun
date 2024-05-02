/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TES_0101.js
*@FileTitle  : Invoice List Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/15
=========================================================*/	
	// global variable
	var sheetObjects=new Array();
	var sheetCnt=0;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
         /***** using extra sheet valuable if there are more 2 sheets *****/
         var sheetObject=sheetObjects[0];
		 var sheetObject1=sheetObjects[1];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
				case "btn_close":
					ComClosePopup(); 
				  break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(ComGetMsg('ES23028')); //ComShowMessage(OBJECT_ERROR);
    		}
    	}
    }
    /**
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items
     * defining list on the top of source
     * @param {ibsheet} sheet_obj	ib sheet object
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
            ComConfigSheet (sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
		var formObj=document.form;
		//tes_isNumD(formObj.due_dt,"Y"); 
		//formObj.csr_amt.value = tes_chkAmtFmt(formObj.csr_amt.value);

		if(!ComIsNull(csr_no)){
			doActionIBSheet1(sheetObjects[1],formObj,IBSEARCH);
			doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
        } else {
			ComShowMessage(ComGetMsg('TES40015','CSR No.'));
		}
    }
     /**
     * setting sheet initial values and header
     * param : sheetObj ==> , sheetNo ==>  
     * adding case as numbers of counting sheets
     * @param {ibsheet} sheetObj	ib sheet object
     * @param {int}		sheetNo		sheet number
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1: 
                with(sheetObj){
		              var HeadTitle="|SEQ|Invoice No.|Net Amount|Tax Amount|W.H.T.|Total Amount|Issue Date|Receive Date|Confirm Date" ;
		
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Status",    Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",             KeyField:0,   CalcLogic:"" },
		                     {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:0,   SaveName:"inv_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"ttl_inv_amt",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"vat_amt",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"whld_tax_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"total_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"iss_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rcv_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"inv_cfm_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"tml_so_ofc_cty_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"tml_so_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		               
		              InitColumns(cols);
		
		              SetEditable(1);
		              SetSheetHeight(ComGetSheetHeight(sheetObj,11));
                    }


                break;
             case 2: 
            	    with(sheetObj){
		               var HeadTitle1="|CSR No.|Payment S/P|Payment S/P|I/F\nStatus|I/F Status\nUpdated Time|Error Reason|No of\n Invoice|Currency|Total\nAmount|Payment\nDue Date|ASA No." ;
		
		               SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		               var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		               var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		               InitHeaders(headers, info);
		
		               var cols = [ {Type:"Status",    Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",        KeyField:0,   CalcLogic:"" },
		                      {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"csr_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"vndr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"inv_desc",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"no_of_inv",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"csr_curr_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"csr_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"due_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"attr_ctnt2",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"iss_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"rcv_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"vndr_term_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		                
		               InitColumns(cols);
		
		               SetEditable(1);
                     }

                break;
        }
    }
    /** handling sheet process
     * @param {ibsheet} sheetObj	ib sheet object
     * @param {form} 	formObj		form object
     * @param {String}	sAction		action value
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
           case IBSEARCH:      //Retrieve
                if (!validateForm(sheetObj,formObj,sAction)){
			        return false;
			    }
			    formObj.f_cmd.value=SEARCHLIST;
			    sheetObj.DoSearch("ESD_TES_0101GS.do", tesFrmQryStr(formObj) );
			    break;
        }
    }
    /**
     * 
     * @param {ibsheet} sheetObj	ib sheet object
     * @param {form} 	formObj		form object
     * @param {String}	sAction		action value
     * @return
     */
    function doActionIBSheet1(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
           case IBSEARCH:      //Retrieve
                if (!validateForm(sheetObj,formObj,sAction)){
			        return false;
			    }
			    formObj.f_cmd.value=SEARCHLIST01;
			    sheetObj.DoSearch("ESD_TES_0101GS.do", tesFrmQryStr(formObj) );
			    break;
        }
    }
    /**	sheet2_OnSearchEnd
     * 
     * @param {ibsheet} sheet2	ibsheet ojbect
     * @param {String}  ErrMsg	err message
     * @return
     */
	function sheet2_OnSearchEnd(sheet2, ErrMsg){
		if (sheet2.RowCount()> 0){
			document.form.vndr_no.value=tes_lpad(sheet2.GetCellValue(1,'vndr_no'),6,"0") ;
			document.form.inv_desc.value=sheet2.GetCellValue(1,'inv_desc');
			document.form.no_of_inv.value=sheet2.GetCellValue(1,'no_of_inv');
			document.form.csr_curr_cd.value=sheet2.GetCellValue(1,'csr_curr_cd');
			document.form.csr_amt.value=sheet2.GetCellValue(1,'csr_amt');
			document.form.attr_ctnt2.value=sheet2.GetCellValue(1,'attr_ctnt2');
			document.form.iss_dt.value=sheet2.GetCellValue(1,'iss_dt');
			document.form.rcv_dt.value=sheet2.GetCellValue(1,'rcv_dt');
			document.form.vndr_term_nm.value=sheet2.GetCellValue(1,'vndr_term_nm');
			document.form.due_dt.value=sheet2.GetCellValue(1,'due_dt');
			//tes_isNumD(document.form.due_dt,"Y"); 
			document.form.csr_amt.value=tes_chkAmtFmt(document.form.csr_amt.value);
		}
	}
    /**
     * handling process for input validation
     * @param {ibsheet} sheetObj	ib sheet object
     * @param {form} 	formObj		form object
     * @param {String}	sAction		action value     
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//            if (!isNumber(formObj.iPage)) {
//                return false;
//            }
        }
        return true;
    }
