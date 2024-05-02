/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_7005.js
*@FileTitle  : Tariff Type Set-up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

 // Common Global variables
 var sheetObjects=new Array();
 var sheetCnt=0;
 var comboObjects=new Array();
 var comboCnt=0;
 var COMMON_TARIFF_CD="common_tariff_cd";
 var USER_TARIFF_TYPE="user_tariff_type"; 
 var ROWMARK="|";
 var FIELDMARK="=";
 
 // Event handler processing by button click event */
 document.onclick=processButtonClick;
     
    // Event handler processing by button name */
    function processButtonClick(){
    	/***** case in Sheet count are more two by Tab, defining adding sheet *****/
		var sheetObject1=sheetObjects[0];
		 /*******************************************************/
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
     		switch(srcName) {
     			case "btn_Save":
     				doActionIBSheet(sheetObject1,formObject,IBSAVE);
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
    
	//comboObjects array generated in the registration page to IB Combo Object
	function setComboObject(combo_obj){
		comboObjects[comboCnt++]=combo_obj;
	}
	
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
    	for(var i=0;i<sheetObjects.length;i++){
			initSheet(sheetObjects[i],i+1);
		}
		//IBMultiCombo initializing
	    for(var k=0;k<comboObjects.length;k++){
	        initCombo(comboObjects[k],k+1);
	    }
		doActionIBCombo(sheetObjects[0], document.form, IBROWSEARCH, comboObjects[0]);
 	}
    
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
    	switch(sheetNo) {
        	case 1:
        		with(sheetObj){
                 
            		var HeadTitle="";

            		SetConfig( { SearchMode:2, Page:20, FrozenCol:0, DataRowMerge:1 } );

            		var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
            		var headers = [ { Text:HeadTitle, Align:"Center"} ];
            		InitHeaders(headers, info);

            		var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" } ];
                
            		InitColumns(cols);
            		SetVisible(false);

        		}
            	break;
    	}
	}
	
	/**
	* After saving handling
	*/
	function sheet1_OnSaveEnd(sheetObj, code, ErrMsg) {
		if(ErrMsg != '') return;
		ComShowCodeMessage('DMT00007');
 	}
	
    /**
   	 * Initializing Combo 
   	 * param : comboObj , comboNo
   	 * adding case as numbers of counting Combos 
   	 */ 
	function initCombo(comboObj, comboNo) {
   	    var formObject=document.form
   	    switch(comboNo) {  
   	    	case 1: 
   	    		with (comboObj) { 
   					SetMultiSelect(1);
   					SetDropHeight(160);
   					SetColWidth(0, "50");
   					SetColWidth(1, "310");
   		    	}
   				break; 
   	     }
   	}
	
	// Process of Sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        sheetObj.SetWaitImageVisible(0);
        switch(sAction) {
	        case IBSAVE:	// save
		 		if(!validateForm(sheetObj,formObj,sAction)) return;
		 		setFormDataTrfTp(formObj);
		 		formObj.f_cmd.value=MULTI;
//parameter changed[check again]CLT
		 		var sXml=sheetObj.GetSaveData("EES_DMT_7005GS.do", FormQueryString(formObj));
//parameter changed[check again]CLT
		 		sheetObj.LoadSaveData(sXml);
	            break;
        }
        sheetObj.SetWaitImageVisible(1);
    }
    
   	function doActionIBCombo(sheetObj,formObj,sAction, comboObj) {
        sheetObj.ShowDebugMsg(false);
		sheetObj.SetWaitImageVisible(0);
        switch(sAction) {
	        case IBROWSEARCH:      
		 		//1. Tariff type comboList
				formObj.f_cmd.value=SEARCHLIST;
				var xmlStr=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
				var data=ComGetEtcData(xmlStr, COMMON_TARIFF_CD);
				if (data != undefined && data != '') {
					var comboItems=data.split(ROWMARK);
					addComboItem(comboObj,comboItems);
					comboItem=comboItems[0].split(FIELDMARK);
				}
				var data2=ComGetEtcData(xmlStr, USER_TARIFF_TYPE);
				if(data2 == 'All') {
					for(var i=0; i < comboObj.GetItemCount(); i++) {
		    			comboObj.SetItemCheck(i,1);
			    	}
				} else
					comboObj.SetSelectCode(data2,false);
				break;
        }
		sheetObj.SetWaitImageVisible(1);
    }
   	
    /**
    * add data  combo field 
    */	
	function addComboItem(comboObj,comboItems) {
		comboObj.InsertItem(0, "All|All", "All");
		for (var i=0 ; i < comboItems.length ; i++) {
	   		var comboItem=comboItems[i].split(FIELDMARK);
				comboObj.InsertItem(i+1, comboItem[0] + "|" + comboItem[1], comboItem[0]);
	   	}
	}
	
//	//Multi Combo click event
//	function combo1_OnCheckClick(comboObj, index, code) {
//	    if(index==0) {
//	    	//checked
//	    	var bChk=comboObj.GetItemCheck(index);
//    		for(var i=1 ; i < comboObj.GetItemCount() ; i++) {
//    			comboObj.SetItemCheck(i,!bChk);
//	    	}
//	    } else {
//    		comboObj.SetItemCheck(0,0);
//	    }
//	}
	var selComboIndex, selComboCode;
	function combo1_OnSelect(comboObj, index, text, code) {
	    selComboIndex = index;
	    selComboCode  = code;
	}
	 
	function combo1_OnChange(comboObj) {	    
		ComSetMultiCombo(comboObj, selComboIndex, selComboCode);
	}
	
    /**
     *  handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
    	with(formObj){
    		if( ComIsEmpty(comboObjects[0].GetSelectCode()) ) {
				 ComShowCodeMessage('COM12113', "Tariff Type in Charge");
				 return false;
			}
    	}
        return true;
    }
    
    var trfTpfldNm=new Array();
    var trfTp=new Array('DMIF', 'DMOF', 'DTIC', 'DTOC', 'CTIC', 'CTOC', 'All');
    trfTpfldNm['DMIF']='dem_ib_flg';
    trfTpfldNm['DMOF']='dem_ob_flg';
    trfTpfldNm['DTIC']='det_ib_flg';
    trfTpfldNm['DTOC']='det_ob_flg';
    trfTpfldNm['CTIC']='cmb_ib_flg';
    trfTpfldNm['CTOC']='cmb_ob_flg';
    trfTpfldNm['All']='all_trf_tp_flg';
    function setFormDataTrfTp(formObj) {
    	with(formObj) {
    		for(var i=0; i < trfTp.length; i++) {
    			var obj=eval(trfTpfldNm[trfTp[i]]);
	    		obj.value='N';
	    	}
	    	var selTrpTp=comboObjects[0].GetSelectCode();
	    	var arrSelTrpTp=selTrpTp.split(",");
	    	if(arrSelTrpTp.length >= 6) { 
	    		formObj.all_trf_tp_flg.value='Y';
	    	} else {
	    		for(var i=0; i < arrSelTrpTp.length; i++) {
	    			var obj=eval(trfTpfldNm[arrSelTrpTp[i]]);
		    		obj.value='Y';
	    		}
	    	}
    	}
    }