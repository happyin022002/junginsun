/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0235.js
*@FileTitle  : OPUS Container Office Setup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/20
=========================================================
*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------The following code is added to make a good JSDoc ------------------*/
	var currRows=0;
	var tabObjects=new Array();
	var tabCnt=0;
	var beforetab=1; 
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var iterator="|$$|";
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	    function processButtonClick(){
	        /***** using extra sheet valuable if there are more 2 sheets *****/
	        var sheetObject = sheetObjects[0];
	        /*******************************************************/
	        var formObject=document.form;
	    	try {
	    		var srcName= ComGetEvent("name");
	            switch(srcName) {
				case "btn_Retrieve":
					sheetObjects[0].RemoveAll();
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				break;
				case "btn_save":
					comPopupOK();
					break;
	            case "btn_Close":
	            	ComClosePopup(); 
	            	break;
		        } // end switch
	    	}catch(e) {
	    		if( e == "[object Error]") {
	     			ComShowCodeMessage("COM12111");
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
          for(i=0;i<sheetObjects.length;i++){        	  
              ComConfigSheet (sheetObjects[i] );
              initSheet(sheetObjects[i],i+1);
              ComEndConfigSheet(sheetObjects[i]);
          }
          initControl();
          doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }
    
   	function initControl() {
        axon_event.addListenerForm('keydown', 'ComKeyEnter', document.form);
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
		             var HeadTitle="Chk.||Office|Office Name|bkg ntfc_eml|si_ntfc_eml";
		             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		             var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		             var headers = [ { Text:HeadTitle, Align:"Center"} ];
		             InitHeaders(headers, info);
		             var cols = [ {Type:"Radio",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"radio",         KeyField:0,   CalcLogic:"",   Format:"", 	PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		     					  {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"check",         KeyField:0,   CalcLogic:"",   Format:"", 	PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                          {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"hndl_ofc_cd",   KeyField:0,   CalcLogic:"",   Format:"" },
		                          {Type:"Text",      Hidden:0, Width:150,  Align:"Left",  	ColMerge:1,   SaveName:"ofc_eng_nm",	KeyField:0,   CalcLogic:"",   Format:"" },
		                          {Type:"Text",      Hidden:1, Width:50,   Align:"Left",  	ColMerge:1,   SaveName:"bkg_ntfc_eml",  KeyField:0,   CalcLogic:"",   Format:"" },
		                          {Type:"Text",      Hidden:1, Width:50,   Align:"Left",  	ColMerge:1,   SaveName:"si_ntfc_eml",   KeyField:0,   CalcLogic:"",   Format:"" },
		                          {Type:"Text",      Hidden:1, Width:100,  Align:"Left",  	ColMerge:1,   SaveName:"act_dt",   		KeyField:0,   CalcLogic:"",   Format:"" } ];
		             InitColumns(cols);
		             SetEditable(1);
		             SetSheetHeight(250);
                 }
            break;
        }
    }
  // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
        switch(sAction) {
        case IBSEARCH:      //Retrieve
			formObj.f_cmd.value=SEARCH;
			sheetObj.DoSearch("ESM_BKG_0235GS.do", FormQueryString(formObj)+"&"+ "page_no=1" ,{Sync:2} );
			break;
        
        case IBSAVE:
			if(!validateForm(sheetObj,formObj,sAction)) {
			    return false;
			}
			if (sheetObj.id == "sheet1") {
				formObj.f_cmd.value=MULTI;
				var params=FormQueryString(formObj);
				params=params + "&" + ComSetPrifix(sheetObj.GetSaveString(true));
				var sXml=sheetObj.GetSaveData("ESM_BKG_0235GS.do", params);
//				sheetObj.LoadSearchData(sXml,{Sync:0} );
				sheetObj.LoadSaveData(sXml);
				if(ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S"){
					ComBkgSaveCompleted();
				}
	        }
			break;			
        }
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
    	switch (sAction) {
	 	case IBSEARCH: 
	 		if (ComChkLen(formObj.hndl_ofc_cd,2) < 1 ) {
	 			ComShowCodeMessage("BKG00186");
				formObj.cust_cnt_cd.focus();
				return false;
			}
			break;
		case IBDELETE:
			if (sheetObj.CheckedRows("slct_flg") == 0) {
				ComShowMessage(msgs['COM12189']);
				return false;
			} else if (sheetObj.CheckedRows("slct_flg") > 0) {
				ComShowMessage(msgs['COM12188']);
				return true;
			}
			break;
			
		break;
	  }
      return true;
    }
    
