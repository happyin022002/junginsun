/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0137
*@FileTitle  : Office Default From Setup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/08
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
                    [modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
                    character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------The following code is added to make a good JSDoc ------------------*/
    /**
     * @fileoverview JavaScript is commonly used in business as a calendar-related functions have been defined.
     * @author
     */
    /**
     * @extends
     * @class esm_bkg_0137 : esm_bkg_0964 business script.
     */
	// global variable
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
    	/***** using extra sheet valuable if there are more 2 sheets *****/
        var sheetObject1=sheetObjects[0];
        /*******************************************************/
     	try {
     		var srcName=ComGetEvent("name");
            switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObject1,document.form,IBSEARCH);
				break;
				case "btn_Delete":
					doActionIBSheet(sheetObject1,document.form,IBDELETE);
				break;
				case "btn_Save":
					doActionIBSheet(sheetObject1,document.form,IBINSERT);
				break;
				case "btn_Close":
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
        initControl();
        
        ComSetFocus(document.form.office);
        fnChangeImeMode();
        if(document.form.office.value !='' ){
            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        }
    }
	/**
	 * Set Initialization value and event of Control in screen
	 */
    function initControl() {
    	var formObject=document.form;
    	formObject.office.value=formObject.office_cd.value;	
    	formObject.do_fom_prv_cd[0].checked=true;			
    	formObject.locl_lang_flg.disabled=false;
    	formObject.locl_lang_flg.value='Y';					
    	axon_event.addListenerForm  ('blur',     'obj_deactivate',  form); 
    	axon_event.addListenerFormat('keypress', 'obj_keypress',    form); 
        axon_event.addListenerForm  ('change'  , 'obj_change', form);
    }
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
 		var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":      //sheet1 init
                with(sheetObj){
	              var HeadTitle1="ibflag|ofc_cd|do_fom_prv_cd|locl_lang_flg|addr_ctnt|do_prn_rmk|auth_ctnt|del_chk";
	              var prefix="sheet1_";
	
	              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:4, DataRowMerge:1 } );
	
	              var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
	              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	              InitHeaders(headers, info);
	
	              var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
	                     {Type:"Text",      Hidden:0, Width:125,  Align:"Center",  ColMerge:1,   SaveName:prefix+"ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"do_fom_prv_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"locl_lang_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"addr_ctnt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"do_prn_rmk",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"auth_ctnt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"DelCheck",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	               
	              InitColumns(cols);
	              SetEditable(1);
	              SetVisible(false)
                }

                break;
        }
    }      
    /**
     * handling sheet process
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	//sheetObj.ShowDebugMsg = false;
        switch(sAction) {
			case IBSEARCH:      //Retrieve
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				formObj.f_cmd.value=SEARCH;
                if(sheetObj.id == "sheet1"){
                	sheetObj.DoSearch("ESM_BKG_0137GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_") );
                }
			break;
			case IBDELETE:        //delete
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				formObj.f_cmd.value=REMOVE;
                var curRow=1;
                var prefix="sheet1_";
            	sheetObj.SetCellValue(curRow,prefix + "del_chk",1,0);
                var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
                sheetObj.DoSave("ESM_BKG_0137GS.do", sParam);
                ComOpenWait(false);
			break;    					
			case IBINSERT:      // insert
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				formObj.f_cmd.value=MULTI;
				copyFormToRow();
                var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
                sheetObj.DoSave("ESM_BKG_0137GS.do", sParam);
                ComOpenWait(false);
			break;
        }
    }     
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
   		switch(sAction) {       	 
		case IBSEARCH:
            if(ComIsEmpty(formObj.office.value)){
                ComShowCodeMessage('BKG00887', 'Office');
                formObj.office.focus();
                return false;
            }
    		break;
    	case IBDELETE:
    		if (document.form.qryFlag.value != "Y") {
				ComShowCodeMessage('BKG00448');
    			return false;
    		}
    		if(sheetObj.RowCount()== 0){
    	    	ComShowCodeMessage("BKG00155");
    	        return false;
    	    }
	        break; 
    	case IBINSERT:
    		if (document.form.qryFlag.value != "Y") {
				ComShowCodeMessage('BKG00448');
    			return false;
    		}
            if(ComIsEmpty(formObj.office.value)){
                ComShowCodeMessage('BKG00715', 'Office');
                formObj.office.focus();
                return false;
            }
            if(ComIsEmpty(formObj.addr_ctnt.value)){
            	formObj.addr_ctnt.value=" ";
            }
            if(ComIsEmpty(formObj.do_prn_rmk.value)){
            	formObj.do_prn_rmk.value=" ";
            }
            if(ComIsEmpty(formObj.auth_ctnt.value)){
            	formObj.auth_ctnt.value=" ";
            }
	        break; 
		}
    	return true;
   	}
    /**
     * Blur event handling
     */
    function obj_deactivate(){
        ComChkObjValid(ComGetEvent());
    }
    /**
     * Keyboard input contol in onkeypress event of HTML Control
     **/
    function obj_keypress(){
//    	switch(ComGetEvent().dataformat){
//            case "float":
//            	//number+"." input
//                ComKeyOnlyNumber(ComGetEvent(), ".");
//                break;
//            case "eng":
//                //Only eng input, eng+num -> ComKeyOnlyAlphabet('num');
//                ComKeyOnlyAlphabet('uppernum');
//                break;
//            case "engdn":
//                //Only lower eng input, lower eng+num -> ComKeyOnlyAlphabet('lowernum');
//                ComKeyOnlyAlphabet('lower');
//                break;
//            case "engup":
//                //Only upper eng input, upper eng+num -> ComKeyOnlyAlphabet('uppernum');
//                ComKeyOnlyAlphabet('upper');
//                break;
//            default:	
//                //Only num input(num,date,time)
//                ComKeyOnlyNumber(ComGetEvent());
//            }
    }
    /**
     * Search End Event Handling
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg){
    	var formObj=document.form;
        if (ErrMsg == "" || ErrMsg== -5) {
            if(sheetObj.RowCount()> 0){
                var curRow=1;
                var prefix="sheet1_";
            	if (sheetObj.GetCellValue(curRow,prefix + "do_fom_prv_cd") == "DO") {
                	formObj.do_fom_prv_cd[0].checked=true;
                	formObj.locl_lang_flg.disabled=false;
            	} else if (sheetObj.GetCellValue(curRow,prefix + "do_fom_prv_cd") == "BL") {
                	formObj.do_fom_prv_cd[1].checked=true;
                	formObj.locl_lang_flg.disabled=true;
                } else {
                	formObj.do_fom_prv_cd[2].checked=true;
                	formObj.locl_lang_flg.disabled=true;
                }
            	formObj.locl_lang_flg.value=sheetObj.GetCellValue(curRow,prefix + "locl_lang_flg");
            	formObj.addr_ctnt.value=sheetObj.GetCellValue(curRow,prefix + "addr_ctnt");
            	formObj.do_prn_rmk.value=sheetObj.GetCellValue(curRow,prefix + "do_prn_rmk");
            	formObj.auth_ctnt.value=sheetObj.GetCellValue(curRow,prefix + "auth_ctnt");
            } else {
            	initForm();
            }
        } else {
            ComShowMessage(ErrMsg);
        }
        formObj.qryFlag.value="Y";
    }
    /**
    * value Initialization.
    */
    function initForm() {
		var formObject=document.form;
		formObject.do_fom_prv_cd[0].checked=true;
		formObject.locl_lang_flg.value='Y';
		formObject.locl_lang_flg.disabled=false;
		formObject.addr_ctnt.value='';
		formObject.do_prn_rmk.value='';
		formObject.auth_ctnt.value='';
    }
    /**
     * Save End Event Handling
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg){
        if (ErrMsg == "") {
	    	if (document.form.f_cmd.value == REMOVE) {
	            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	            ComBkgSaveCompleted();  //Server Msg Handling
	            initForm();            		  
	    	} else {
	    	    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	    		ComBkgSaveCompleted();  //Server Msg Handling
	    		document.form.qryFlag.value="Y";
	    	}
        }
        
	    if (document.form.mainPage.value != "true") {
	    	ComClosePopup(); 
	    }
    }         
    /**
     * copyFormToRow
     */
    function copyFormToRow() {
	    var rowCnt=sheetObjects[0].RowCount();
	    var prefix="sheet1_";
	    if (rowCnt > 0) {		
	    	sheetObjects[0].SetRowStatus(rowCnt,"U");
	    } else {				
		    rowCnt=sheetObjects[0].DataInsert(-1);
	  	    sheetObjects[0].SetRowStatus(rowCnt,"I");
	    }
	    sheetObjects[0].SetCellValue(rowCnt,prefix + "ofc_cd",document.form.office.value,0);
        if (document.form.do_fom_prv_cd[0].checked == true) {
    	    sheetObjects[0].SetCellValue(rowCnt,prefix + "do_fom_prv_cd",document.form.do_fom_prv_cd[0].value,0);
        } else if (document.form.do_fom_prv_cd[1].checked == true) {
    	    sheetObjects[0].SetCellValue(rowCnt,prefix + "do_fom_prv_cd",document.form.do_fom_prv_cd[1].value,0);
        } else {
    	    sheetObjects[0].SetCellValue(rowCnt,prefix + "do_fom_prv_cd",document.form.do_fom_prv_cd[2].value,0);
        }
	    sheetObjects[0].SetCellValue(rowCnt,prefix + "locl_lang_flg",document.form.locl_lang_flg.value,0);
	    sheetObjects[0].SetCellValue(rowCnt,prefix + "addr_ctnt",document.form.addr_ctnt.value,0);
	    sheetObjects[0].SetCellValue(rowCnt,prefix + "do_prn_rmk",document.form.do_prn_rmk.value,0);
	    sheetObjects[0].SetCellValue(rowCnt,prefix + "auth_ctnt",document.form.auth_ctnt.value,0);
    }
    /**
     * value Clear.
     **/
    function office_change() {
    	document.form.qryFlag.value="";
      	return true;
    }
    
    /**
     * in case Object is changed, managing the status of screen <br>
     * @param void
     * @return void
     */
    function obj_change(form){
        var objName=ComGetEvent("name");
        var formObj=document.form;
        //activating in case of changing condition of searching

        switch (objName) {
            case "office":
            	office_change();
                break;
            case "locl_lang_flg":
            	fnChangeImeMode(); 
                break;
        }
    }  
    /**
     * setting ime-mode as locl_lang_flg<br>
     * @param void
     * @return void
     */
    function fnChangeImeMode() {
       var formObj=document.form;
        if (formObj.locl_lang_flg[0].selected == true) {
           formObj.addr_ctnt.style.imeMode  ="disabled";
           formObj.do_prn_rmk.style.imeMode ="disabled";
           formObj.auth_ctnt.style.imeMode  ="disabled";
       } else {
    	   formObj.addr_ctnt.style.imeMode  ="active";
           formObj.do_prn_rmk.style.imeMode ="active";
           formObj.auth_ctnt.style.imeMode  ="active";
       }
    }
    
    /**
    * when Radio button clicked, value Check.
    **/
    function fnRadioCheck() {
        if (document.form.do_fom_prv_cd[0].checked == true) {
    	    document.form.locl_lang_flg.disabled=false;
        } else {
        	document.form.locl_lang_flg.value = "Y";
    	    document.form.locl_lang_flg.disabled=true;
        }
    }
    /* Developer Work End */
 