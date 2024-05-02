/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_BKG_3012.js
*@FileTitle  : 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/11/24
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;
	var SEARCHKEY = 102;
	var COUNTRY	  = "CNT";
	var EMPLOYEE  = "EMP";
	var ROWMARK   = "|";
	var FIELDMARK = "=";
	
	/**
     * Dynamically load HTML Control event in page. <br>
     * Initialize IBSheet Object by calling this function from {@link #loadPage} function. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects list in turn
     **/
    function initControl() {    	
    	var formObject = document.form;
        axon_event.addListenerFormat('keypress','bkg_keypress',formObject); //- 키보드 입력할때
        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
        axon_event.addListenerForm('blur', 'PlaceofIssueCodeCheck', formObject); //- out of focus    
    }
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
    	/***** In case of more than 2 sheets in a tab, additional sheet variables can be specified *****/
	    var sheetObject=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {                  
				case "btn_save":
					doActionIBSheet(sheetObject,formObject,IBSAVE);					
					break;
 				case "btn_close":
 					self.close();
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
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    function setComboObject(combo_obj){
    	comboObjects[comboCnt++]=combo_obj;
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
        for(var k=0; k < comboObjects.length; k++){
            initCombo(comboObjects[k], k + 1);
        }          
        initControl();
        
 	    var sheetObj = sheetObjects[0];
 	    var formObj = document.form;
 	    initComboSetVal(sheetObj, formObj);
 	    
 	    var formObject = document.form;
 	    if(formObject.bl_esig_asgn_seq.value != '' && formObject.bl_esig_asgn_seq.value.length > 0) {
 	    	doActionIBSheet(sheetObj,formObject,IBSEARCH);
 	    } else {
 	    	doActionIBSheet(sheetObj,formObject,IBCLEAR);
 	    }
    }
    
    function PlaceofIssueCodeCheck(){
    	var formObject = document.form;
    	switch(event.srcElement.name){
    		case "bl_iss_ofc_cd":
    			if(formObject.bl_iss_ofc_cd.value == "") return;
    			doActionIBSheet(sheetObjects[0], formObject, SEARCH01);					
    			
    			break;
    	}
    }
    
    /**
 	 *  Get Receiving Term,Delivery Term combo data
 	 **/
 	 function initComboSetVal(sheetObj, formObj){
 		sheetObj.ShowDebugMsg(false);
 		sheetObj.SetWaitImageVisible(0);
 		ComSetObjValue(formObj.f_cmd, SEARCH02);
 		var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
		var comboItems = ComGetEtcData(sXml, COUNTRY).split(ROWMARK);
		comboObjects[0].RemoveAll();
		addComboItem(comboObjects[0],comboItems);
		

 	 }
 	function addComboItem(comboObj, comboItems, comboType) {
     	for (var i = 0 ; i < comboItems.length ; i++) {
     		var comboItem = comboItems[i].split(FIELDMARK);
     	
     		if (comboType == "ONE-SELECT") {
     			comboObj.InsertItem(i, comboItem[1], comboItem[0]);
     		}
     		else {
     			comboObj.InsertItem(i, comboItem[0] + "|" + comboItem[1], comboItem[0]);
     		}
     	}   		
 	}
    
    function initCombo(comboObj, comboNo) {
         switch(comboObj.options.id) {
         case "cnt_cd":
             with(comboObj) {
        	 	SetMultiSelect(0);    
        	 	SetDropHeight(160);
        		SetColAlign(0, "left");
        		SetColAlign(1, "left");  
                SetColWidth(0, "50");
                SetColWidth(1, "190"); 
                ValidChar(2,3);
                SetMaxLength(2);
             }
             break;        
         }
    }

    function cnt_cd_OnBlur(comboObj) {
    	var formObj = document.form;
    	doActionIBSheet(sheetObj, formObj, IBCLEAR);
    }
    
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj, sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:
                with(sheetObj){
            		var HeadTitle = "|Issue Code|Issue Name|Country|Company Name 1|Company Name 2|Company Name 3|Employee|Desc|Signed|Signed Copy|Counting Original";
	
	                SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:2, DataRowMerge:0 } );
	
	                var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [
        		             {Type:"Status",   Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"ibflag" },      
        		             {Type:"Text",     Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"bl_iss_ofc_cd",  KeyField:1,   CalcLogic:"",   Format:"",    UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",     Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"bl_iss_ofc_nm",  KeyField:1,   CalcLogic:"",   Format:"",    UpdateEdit:1,   InsertEdit:1 },
        		             {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cnt_cd",         KeyField:1,   CalcLogic:"",   Format:"", 	UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",     Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"agn_co_nm1",   	KeyField:1,   CalcLogic:"",   Format:"",    UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",     Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"agn_co_nm2",   	KeyField:1,   CalcLogic:"",   Format:"",    UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",     Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"agn_co_nm3", 	KeyField:1,   CalcLogic:"",   Format:"",    UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",     Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"bl_esig_seq",    KeyField:1,   CalcLogic:"",   Format:"",    UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",     Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"bl_esig_rmk",   	KeyField:1,   CalcLogic:"",   Format:"",    UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text", 	   Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bl_esig_flg",  	KeyField:0,   CalcLogic:"",   Format:"",   	UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text", 	   Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bl_cpy_esig_flg",KeyField:0,   CalcLogic:"",   Format:"",   	UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text", 	   Hidden:0,  Width:100,   Align:"Center", ColMerge:1,   SaveName:"bl_knt_flg",  	KeyField:0,   CalcLogic:"",   Format:"",    UpdateEdit:1,   InsertEdit:1 }
                             ];
	                   
                    InitColumns(cols);
                    SetEditable(1);
                    SetCountPosition(0);
                }
                break;               
        }
    }
    // Sheet related process handling
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {      	
	        case IBCLEAR:
	        	ComSetObjValue(formObj.f_cmd, SEARCH02);
	       	 	var sXml=sheetObj.GetSearchData("ESM_BKG_3012GS.do", FormQueryString(formObj));
	    		var comboItems = ComGetEtcData(sXml, EMPLOYEE).split(ROWMARK);
	    		comboObjects[1].RemoveAll();
	    		addComboItem(comboObjects[1],comboItems,"ONE-SELECT");
	    		employee.SetSelectCode(formObj.bl_esig_seq.value, false);
	    		break;		
			case IBSEARCH:      //retrieve
 				if(!validateForm(sheetObj,formObj,sAction)) return false;
 				formObj.f_cmd.value = SEARCH;
 				sheetObj.DoSearch("ESM_BKG_3012GS.do",FormQueryString(formObj));
				break;
			case IBSAVE:        //save
				if(!validateForm(sheetObj,formObj,sAction)) return false;
 				if(formObj.bl_esig_asgn_seq.value != '' && formObj.bl_esig_asgn_seq.value.length > 0)
 	 				formObj.f_cmd.value = MODIFY;
 				else
 					formObj.f_cmd.value = ADD; 	
 				
 				formObj.bl_esig_seq.value = employee.GetSelectCode(); 	 			
 	 			var sParam = FormQueryString(formObj);
                var saveXml=sheetObj.GetSaveData("ESM_BKG_3012GS.do", sParam);                
                sheetObj.LoadSaveData(saveXml);
                break;
                
			case SEARCH01:
				formObj.f_cmd.value = SEARCH01;
				var saveXml = sheetObj.GetSearchData("ESM_BKG_3012GS.do", FormQueryString(formObj));  
				if(ComGetEtcData(saveXml, "TRANS_RESULT_KEY") == "F"){
					ComShowCodeMessage('BKG08325');
					formObj.bl_iss_ofc_cd.value = "";
					ComSetFocus(formObj.bl_iss_ofc_cd);
				}
				break;					
        }
    }
    /**
     * Event after retrieving Sheet
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	var bl_iss_ofc_cd 	= sheetObj.GetCellValue(sheetObj.GetSelectRow(), "bl_iss_ofc_cd");
    	var bl_iss_ofc_nm 	= sheetObj.GetCellValue(sheetObj.GetSelectRow(), "bl_iss_ofc_nm");
		var cnt_cd 			= sheetObj.GetCellValue(sheetObj.GetSelectRow(), "cnt_cd");
		var agn_co_nm1 		= sheetObj.GetCellValue(sheetObj.GetSelectRow(), "agn_co_nm1");
		var agn_co_nm2 		= sheetObj.GetCellValue(sheetObj.GetSelectRow(), "agn_co_nm2");
		var agn_co_nm3 		= sheetObj.GetCellValue(sheetObj.GetSelectRow(), "agn_co_nm3");
		var bl_esig_seq 	= sheetObj.GetCellValue(sheetObj.GetSelectRow(), "bl_esig_seq");
		var bl_esig_rmk 	= sheetObj.GetCellValue(sheetObj.GetSelectRow(), "bl_esig_rmk");
		
		var bl_esig_flg 	= sheetObj.GetCellValue(sheetObj.GetSelectRow(), "bl_esig_flg");
		var bl_cpy_esig_flg 	= sheetObj.GetCellValue(sheetObj.GetSelectRow(), "bl_cpy_esig_flg");
		var bl_knt_flg 	= sheetObj.GetCellValue(sheetObj.GetSelectRow(), "bl_knt_flg");
		
		var formObject = document.form;
		formObject.bl_iss_ofc_cd.value 	= bl_iss_ofc_cd;
		formObject.bl_iss_ofc_nm.value 	= bl_iss_ofc_nm;
		comboObjects[0].SetSelectCode(cnt_cd);
		formObject.agn_co_nm1.value 	= agn_co_nm1;
		formObject.agn_co_nm2.value 	= agn_co_nm2;
		formObject.agn_co_nm3.value 	= agn_co_nm3;
		//formObject.esig_n1st_nm.value 	= esig_n1st_nm;
		formObject.bl_esig_rmk.value 	= bl_esig_rmk;	
		
		if(bl_esig_flg == 'Y')
			formObject.bl_esig_flg.checked = true;
		
		if(bl_cpy_esig_flg == 'Y')
			formObject.bl_cpy_esig_flg.checked = true;
		
		if(bl_knt_flg == 'Y')
			formObject.bl_knt_flg.checked = true;
		
		
		doActionIBSheet(sheetObj,formObject,IBCLEAR);
	}
    /**
     * Event after saving Sheet
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg)  {						
        if (ErrMsg != "") return;
        ComShowCodeMessage("COM130102", "Place of Issue Association");    // {?msg1} was saved successfully.
        opener.searchESignatureList();
		self.close(); 	
    }

    /**
     * handling process for input validation
     */
    function validateForm(sheetObj, formObj, sAction){
 		switch(sAction) {
			case IBSAVE:
				if(formObj.bl_iss_ofc_cd.value.length == 0) {
					ComShowCodeMessage('COM12114', 'Place of Issue Code');
  					return false;
				}
				if(formObj.bl_iss_ofc_nm.value.length == 0) {
					ComShowCodeMessage('COM12114', 'Place of Issue Name');
  					return false;
				}
				if(cnt_cd.GetSelectCode() == '') {
					ComShowCodeMessage('COM12114', 'Country');
  					return false;
				}	
				if(formObj.agn_co_nm1.value.length == 0) {
					ComShowCodeMessage('COM12114', 'Agent\'s Company Name Clause(Line 1)');
  					return false;
				}
				if(employee.GetSelectCode() == '') {
					ComShowCodeMessage('COM12114', 'Issuing Office\'s Employee');
					return false;
				}					
				break;
 		}
 		return true;
    }
