/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_360.js
*@FileTitle  :  Marks And Description by NVO H/BL
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
    /* developer job	*/
    // common global variables
	var sheetObjects=new Array();
	var sheetCnt=0;
	var callback_func='';
	// Event handler processing by button click event
	document.onclick=processButtonClick;
	// Event handler processing by button name
    function processButtonClick(){
		var sheetObject1=sheetObjects[0];
         /*******************************************************/
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(srcName != "btn_splitPop"){
        		if(layList.style.display != "none"){
        			layList.style.display="none";
        		}    	    			
    		}
            switch(srcName) {
				case "btn_splitPop":			
					doActionIBSheet(sheetObject1,formObject,COMMAND04);					
				break;
				case "btn_retrieve":
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
				break;  			
				case "btn_copy":
					var bl_mk_desc='';
					var bl_cmdt_desc='';
					var arrRow=ComFindText(sheetObject1, "sel", "1");
					if(arrRow.length == 0){
						ComShowMessage(ComGetMsg("BKG40076"));
						return;						
					}else{
						for (idx=0; idx<arrRow.length; idx++){
							bl_mk_desc += sheetObject1.GetCellValue(arrRow[idx], "bl_mk_desc");
							bl_cmdt_desc += sheetObject1.GetCellValue(arrRow[idx], "bl_gds_desc");
						}
					}
					var localopener = (opener || parent);
					if(callback_func != ''){
						eval('localopener.'+callback_func)(bl_mk_desc, bl_cmdt_desc);
					}	
				//break; 					
				case "btn_close":
					ComClosePopup(); 
				break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }
	/**
	 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items 
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
			//initSheet
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		//iframe Create 
    	CofigIframe();
		//
		if(document.form.bkg_no.value != ''){
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		}
        //add listener
       // axon_event.addListenerForm('keypress', 'form1_keypress', document.form);
        axon_event.addListenerForm('change', 'form1_change', document.form);
    }
	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
     function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      //sheet1 init
                with(sheetObj){
		             var HeadTitle="|Sel.|Seq.|Bkg No|CntrMf|BlMk|BlGds";
		             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		             var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		             var headers = [ { Text:HeadTitle, Align:"Center"} ];
		             InitHeaders(headers, info);
		
		             var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                 {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"sel" },
		                 {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"hbl_seq" },
		                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no" },
		                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cntr_mf_gds_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"bl_mk_desc",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"bl_gds_desc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
		              
		             InitColumns(cols);
		
		             SetEditable(1);
		             SetCountPosition(0);
		             SetSheetHeight(215);
                 }
        	break;
        }
    }
     
 	function sheet1_OnSearchEnd(sheetObj, ErrCode , ErrMsg){
		var formObj=document.form;
		if(sheetObj.GetTotalRows()> 0){
			formObj.cntr_mf_gds_desc.value=sheetObj.GetCellValue(1, "cntr_mf_gds_desc");
			formObj.bl_mk_desc.value=sheetObj.GetCellValue(1, "bl_mk_desc");
			formObj.bl_gds_desc.value=sheetObj.GetCellValue(1, "bl_gds_desc");
		}
	}
 	
	/**
	* Sheet related process handling
	*/
    function doActionIBSheet(sheetObj,formObj,sAction) {
        //sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			case IBSEARCH:      // retrieve
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value=SEARCH;
 					sheetObj.DoSearch("ESM_BKG_0360GS.do", FormQueryString(formObj) );
				}
			break;
			case COMMAND04:      //booking split no
				if(validateForm(sheetObj,formObj,sAction)) {
					sheetObj.SetWaitImageVisible(0);
					ComSetObjValue(formObj.f_cmd, COMMAND03);
					var sXml=sheetObj.GetSearchData("ESM_BKG_0079_01GS.do", FormQueryString(formObj));
					var bkg_split_no_list=ComGetEtcData(sXml, "bkg_split_no_list");
					bkgSplitNoListPop(formObj.bkg_no, bkg_split_no_list, 30); 
					sheetObj.SetWaitImageVisible(1);
				}else{
					return false;
				}					
			break;			
        }
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        switch(sAction) {
			case IBSEARCH:      // retrieving
				if(formObj.bkg_no.value == '') {
					ComShowMessage(ComGetMsg("BKG00888", "bkg_no"));
					formObj.bkg_no.focus();
					return false;
				}
			break;
			case COMMAND04: 
				with (formObj) {
					if(ComIsEmpty(bkg_no.value)){
						ComShowMessage(ComGetMsg("BKG00463"));
						bkg_no.focus();
						return false;
					}
				}
			break;			
        }		
        return true;
    }

	function form1_keypress(){
		if (event.srcElement.type == "text" && event.keyCode == 13 ) {
   			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			//ComKeyEnter("search");
		}
		switch(event.srcElement.dataformat){
			case "ymd":
				ComKeyOnlyNumber(event.srcElement);
				break;
			case "ym":
			case "yw":
			case "jumin":
			case "saupja":	
				ComKeyOnlyNumber(event.srcElement, "-"); 
			break;
			case "hms":
			case "hm":		
				ComKeyOnlyNumber(event.srcElement, ":"); 
			break;
			case "int":		
				ComKeyOnlyNumber(event.srcElement); 
			break;
			case "float":    
				ComKeyOnlyNumber(event.srcElement, "."); 
			break;	    
			case "engup":
				ComKeyOnlyAlphabet("upper");
			break;
			case "engupnum":
				ComKeyOnlyAlphabet("uppernum");
			break;
			case "engupnumspc":
				//ComKeyOnlyAlphabet("uppernum", "32|45|95");
				var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
				if(keyValue >= 97 && keyValue <= 122){                  
                	event.keyCode=keyValue + 65 - 97;
				}
				//event.returnValue = true;
			break;
		}			
	}
    function form1_change(){
		var sheetObj=sheetObjects[0];
		var formObj=document.form;
        var srcName=ComGetEvent("name");
        switch(srcName){
            case "cntr_mf_gds_desc":
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "cntr_mf_gds_desc",formObj.cntr_mf_gds_desc.value,0);
            break;
            case "bl_mk_desc":
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "bl_mk_desc",formObj.bl_mk_desc.value,0);
            break;
            case "bl_gds_desc":
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "bl_gds_desc",formObj.bl_gds_desc.value,0);
            break;
        }
    }
	function sheet1_OnClick(sheetObj, row, col, val) {
		var formObj=document.form;
	    var col_save_name=sheetObj.ColSaveName(col);
		if (col_save_name == "hbl_seq") {
			formObj.cntr_mf_gds_desc.value=sheetObj.GetCellValue(row, "cntr_mf_gds_desc");
			formObj.bl_mk_desc.value=sheetObj.GetCellValue(row, "bl_mk_desc");
			formObj.bl_gds_desc.value=sheetObj.GetCellValue(row, "bl_gds_desc");
		}
	 }
	//
	function bkgSplitNoList(split_list){
		document.form.bkg_no.value=split_list.options[split_list.selectedIndex].value;
		layList.style.display="none";
	}
	/* developers work end */
