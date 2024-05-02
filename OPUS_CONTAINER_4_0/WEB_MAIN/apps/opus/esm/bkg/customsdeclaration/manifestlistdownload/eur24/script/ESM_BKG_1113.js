/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1113.js
*@FileTitle  : Transmit / Receive History 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/
=========================================================
*/
/****************************************************************************************
Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ESM_BKG_1113 : business script for ESM_BKG_1113 
     */
	// common global variables
	var sheetObjects=new Array();
	var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;
    var intervalId="";
    
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
    	var sheetObject1=sheetObjects[0];
    	var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			
			switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;
				case "btn_Close":
					ComClosePopup(); 
					break;
				default:
					break;
            } // end switch
    	} catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e.message);
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
	 * register combo Object to comboObjects array
	 * 
	 * @param combo_obj
	 * @return
	 */
    function setComboObject(combo_obj) {
    	comboObjects[comboCnt++]=combo_obj; 
    }
	/**
	 * initializing sheet
	 * implementing onLoad event handler in body tag
	 * adding first-served functions after loading screen.
	 */                  
    function loadPage() {
    	var formObj=document.form;
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		initControl();
		doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
	}
     function initControl() {
     	var formObject=document.form;
     	
     	axon_event.addListenerForm  ('blur', 'bkg_blur',  formObject); //- focus out 
//        axon_event.addListenerFormat('focus', 'bkg_focus',    formObject); //- 포커스 들어갈때
//        axon_event.addListenerFormat('beforedeactivate', 'bkg_deactivate',  formObject); //- 포커스 나갈때     
//        axon_event.addListenerFormat('beforeactivate', 'bkg_activate',    formObject); //- 포커스 들어갈때
        axon_event.addListener      ('keydown', 'ComKeyEnter', 'form');
     }
 	/**
 	 * Combo basic setting
 	 */
   	function initCombo(comboObj, comboId) {
   	    var formObject=document.form
  			initComboEditable(comboObj, comboId)
   	}
 	/**
	 * Select Box basic setting
	 */
 	function initComboEditable(combo, comboId) {
 		with (combo) {
	 		if(comboId == "p_pofe" ){
	 			SetMultiSelect(0);
	 			SetUseEdit(0);
	 		}
 		}
 	} 
/*********************** KEY EVENT START ********************/ 	 
  
	var preVvd;
	var prePodCd;
     
	
    function bkg_blur() {
    	var formObj = document.form;    	
	    switch (event.srcElement.getAttribute("name")) {
	    	case "p_vvd_cd":
				break;
				
	    	case "p_from_dt":
	    		ComAddSeparator(event.srcElement);
					break;	    		
	    	case "p_to_dt":
	    		ComAddSeparator(event.srcElement);
					break;	    		
	    	case "bkg_from_dt":
	    		ComAddSeparator(event.srcElement);
					break;	    		
	    	case "bkg_to_dt":
	    		ComAddSeparator(event.srcElement);
					break;	    		
				default:
					break;
	    }
    }           

    
    /**
     * double click event
     * @param sheetObj Sheet
     * @param Row Row Index
     * @param Col Col Index
     */
    function sheet1_OnDblClick(sheetObj, row, col) {
		var colSaveName=sheetObj.ColSaveName(col);
		switch(colSaveName) {
			case "bl_no" :
				//	ComBkgCall0079(sheetObj.CellValue(row, "bkg_no"));
				break;
	        } // end switch
     }	     
 	 
    /**
	 * event after Sheet retrieve
	 * >> ToolTipText설정
	 */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
        with (sheetObj) {
        	var blueColor ="#0000FF";
        	var redColor  ="#FF0000";
        	
        	for(var i=sheetObj.HeaderRows(); i<=sheetObj.LastRow();i++){
    			
        		if(sheetObj.GetCellValue(i,"by_name") != ""){
        			var sText = GetCellValue(i,"by_name");
    				SetToolTipText(i,"by_id", sText);
        			SetCellFontColor(i, "by_id", blueColor);
            	}
    			
    			if (sheetObj.GetCellValue(i,"result") == "Rejected" || sheetObj.GetCellValue(i,"result") == "Hold") {
                 	SetCellFontColor(i,"result", redColor);
                } else if (GetCellValue(i,"result") == "Release") {
                	SetCellFontColor(i, "result", blueColor);
                }
        	
        	}
        	
        }//end width
    }		
		// handling of Sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			case IBSEARCH : // retrieve
				if(!validateForm(sheetObj,formObj,sAction)) return;
				sheetObj.RenderSheet(0);
				sheetObj.SetWaitImageVisible(1);
				formObj.f_cmd.value=SEARCH;
				//sheetObj.RemoveAll();
				var sXml=sheetObj.GetSearchData("ESM_BKG_1113GS.do", FormQueryString(formObj));
				sheetObj.LoadSearchData(sXml,{Sync:0} );
				sheetObj.RenderSheet(1);
				sheetObj.SetWaitImageVisible(0);
				break;
			default:
				break;
        }
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
	    switch(sAction) {
	    	case IBSEARCH:
    			if (ComIsNull(formObj.p_bl_no)) {
    				ComShowCodeMessage('BKG00104','B/L_No');
 					return false;    
    			}
				break;
	    }
        return true;
    }
    /**
     * handling input search condition
     */
    function obj_KeyUp() {
    }
    function obj_change() {
    }
    /**
     * sheet click event
     */
    function sheet1_OnClick(sheetObj, row, col) {
        var colSaveName=sheetObj.ColSaveName(col);
        var check=sheetObj.GetCellValue(row,"sel");
        var keySeq=sheetObj.GetCellValue(row,"dt_seq");
        switch(colSaveName) {
	    	case "msg_img":
	    		 if(sheetObj.ColSaveName(col) == "msg_img") {
//	    		if( sheetObj.GetCellValue(row,"msg_img") == '0' ){ GetCellValue 가 이미지 경로가 나와 변경
	    			var edi_rcv_dt=sheetObj.GetCellValue(row, "edi_rcv_dt");
	    			var edi_rcv_seq=sheetObj.GetCellValue(row, "edi_rcv_seq");
	    			var cnt_cd=document.form.p_cstms_port_cd.value.substring(0,2);
			       	ComOpenWindowCenter("/opuscntr/ESM_BKG_1112.do?pgmNo=ESM_BKG_1112&edi_rcv_dt=" + edi_rcv_dt + "&edi_rcv_seq=" + edi_rcv_seq+"&cnt_cd="+cnt_cd, "1104", 600, 680, false);
			       	break;
	    	 }
	    	break;
        } // end switch
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
			case "sheet1":
			    with(sheetObj){
			      var HeadTitle1="|Seq.|Type|Message|Time|Time|RCV_MSG|Result|Result|MRN|By|By|BY_NAME|edi_rcv_dt|edi_rcv_seq";
			      var HeadTitle2="|Seq.|Type|Message|GMT|Local|RCV_MSG|Result|Result|MRN|By|By|BY_NAME|edi_rcv_dt|edi_rcv_seq";
			      var headCount=ComCountHeadTitle(HeadTitle1);
			      SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:1 } );
			      var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"},
			                      { Text:HeadTitle2, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"type_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"msg_type",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:130,  Align:"Center",  ColMerge:1,   SaveName:"gmt_time",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:130,  Align:"Center",  ColMerge:1,   SaveName:"local_time",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rcv_msg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"result",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Image",     Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"msg_img",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:140,  Align:"Center",  ColMerge:1,   SaveName:"mrn_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"by_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"by_ofc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"by_name",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"edi_rcv_dt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"edi_rcv_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			      InitColumns(cols);
			      SetEditable(0);
			      SetImageList(0,"img/btns_search.gif");
			      SetImageList(1,"img/blank.gif");
			      SetShowButtonImage(0);
			      // SetMergeCell(0, 7, 2, 2);
			      SetSheetHeight(350);
			      
			      SetCountPosition(0); 
			      SetRangeBackColor(1, 2, 1, 36,"#777777");
		      }
			break;
		}//end switch
 	}     