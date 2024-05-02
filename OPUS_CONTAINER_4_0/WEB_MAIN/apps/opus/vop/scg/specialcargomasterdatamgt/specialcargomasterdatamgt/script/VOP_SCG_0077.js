/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : VOP_SCG_0077.jsp
 *@FileTitle : Setup Mail Contents for SPCL CGO Application
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/17
 =========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
             MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
             OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   /**
     * @fileoverview commonly used javascript file, calendar related functions are defined.
     */
    /**
     * @extends 
     * @class VOP_SCG_0077 : business script for VOP_SCG_0077
     */
    // common global variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
    	var sheetObject=sheetObjects[0];
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
				case "btn_save":
					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
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
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
        	//
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            //
            ComEndConfigSheet(sheetObjects[i]);
        }
        initControl();
        sheet1_OnLoadFinish(sheetObjects[0]);
    }
    // event Catch Listener
    function initControl() {
          // Axon event handling1. event catch
//          axon_event.addListenerForm   ('keyup',    'obj_keyup',      form);
    	$('textarea, input[type="text"]').on('change', function(){
    		obj_keyup();
    	});
          axon_event.addListenerForm   ('click',    'obj_click',      form);
    }
    // Handling business javascript OnClick event
	function obj_click() {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		switch (ComGetEvent("name")) {
			case "auto_eml_flg":
				if (formObj.auto_eml_flg.checked) {
					for(var rowIdx=sheetObj.HeaderRows(); rowIdx<=sheetObj.LastRow(); rowIdx++) {
	    				sheetObj.SetCellValue(rowIdx,"auto_eml_flg","Y",0);
	    			}
				} else {
					for(var rowIdx=sheetObj.HeaderRows(); rowIdx<=sheetObj.LastRow(); rowIdx++) {
	    				sheetObj.SetCellValue(rowIdx,"auto_eml_flg","N",0);
	    			}
				}
				break;
		}
	}
    // Handling business javascript OnKeyUp event
    function obj_keyup() {
    	var sheetObj=sheetObjects[0];
    	var obj = ComGetEvent();
    	var value = $(obj).val();
    	var strLen= value.length;
		if(strLen > 4000) {
			ComSetObjValue(obj, ComGetObjValue(obj).substring(0, 4000));
		}
    	switch(ComGetEvent("name")) {
    		case "dg_hdr_ctnt":
    			sheetObj.SetCellValue(1,"hdr_ctnt",value,0);
    			break;
    		case "dg_ftr_ctnt":
    			sheetObj.SetCellValue(1,"ftr_ctnt",value,0);
    			break;
    		case "ak_hdr_ctnt":
    			sheetObj.SetCellValue(2,"hdr_ctnt",value,0);
    			break;
    		case "ak_ftr_ctnt":
    			sheetObj.SetCellValue(2,"ftr_ctnt",value,0);
    			break;
    		case "bb_hdr_ctnt":
    			sheetObj.SetCellValue(3,"hdr_ctnt",value,0);
    			break;
    		case "bb_ftr_ctnt":
    			sheetObj.SetCellValue(3,"ftr_ctnt",value,0);
    			break;
    		case "rf_hdr_ctnt":
    			sheetObj.SetCellValue(4,"hdr_ctnt",value,0);
    			break;
    		case "rf_ftr_ctnt":
    			sheetObj.SetCellValue(4,"ftr_ctnt",value,0);
    			break;
    	}
    } 
    /**
     * Handling sheet1 OnSearchEnd Event
     * param : sheetObj ==> sheet object, ErrMsg ==> result Message
     * 
     */
     function sheet1_OnLoadFinish(sheetObj) {	
    	doActionIBSheet(sheetObj,document.form,IBSEARCH);
    }  
    /**
     * Handling Sheet1 OnSearchEnd Event
     * param : sheetObj ==> sheet object, ErrMsg ==> result Message
     * 
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	var formObj=document.form;
		ComSetObjValue(formObj.dg_hdr_ctnt, sheetObj.GetCellValue(1,"hdr_ctnt"));
		ComSetObjValue(formObj.dg_ftr_ctnt, sheetObj.GetCellValue(1,"ftr_ctnt"));
		ComSetObjValue(formObj.ak_hdr_ctnt, sheetObj.GetCellValue(2,"hdr_ctnt"));
		ComSetObjValue(formObj.ak_ftr_ctnt, sheetObj.GetCellValue(2,"ftr_ctnt"));
		ComSetObjValue(formObj.bb_hdr_ctnt, sheetObj.GetCellValue(3,"hdr_ctnt"));
		ComSetObjValue(formObj.bb_ftr_ctnt, sheetObj.GetCellValue(3,"ftr_ctnt"));
		ComSetObjValue(formObj.rf_hdr_ctnt, sheetObj.GetCellValue(4,"hdr_ctnt"));
		ComSetObjValue(formObj.rf_ftr_ctnt, sheetObj.GetCellValue(4,"ftr_ctnt"));
		if(sheetObj.GetCellValue(1,"auto_eml_flg") == "Y") {
    		formObj.auto_eml_flg.checked=true;
    	}
    }
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      //t1sheet1 init
                with (sheetObj) {
                    // setting height
//            	SetSheetHeight(0);
//            	(7, 0, 0, true);
            	var HeadTitle="||Type|Header (Introduction)|Footer (Signature)||";

            	SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );

            	var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
            	var headers = [ { Text:HeadTitle, Align:"Center"} ];
            	InitHeaders(headers, info);

            	var cols = [ {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
            	             {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibstatus" },
            	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"spcl_cgo_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:0,  Width:580,  Align:"Left",    ColMerge:1,   SaveName:"hdr_ctnt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4000 },
            	             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"ftr_ctnt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4000 },
            	             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"eml_snd_usr_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4000 },
            	             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"auto_eml_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
            	 
            	InitColumns(cols);
            	SetVisible(0);
            	SetEditable(1);
//            	SetGetEditEnterBehavior()("newline");
                }
                break;
        }
    }
    // Sheet related process handling
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			case IBSEARCH:      //retrieve
				formObj.f_cmd.value=SEARCH;
 				var sXml=sheetObj.GetSearchData("VOP_SCG_0077GS.do", FormQueryString(formObj));
				if(sXml.length > 0) sheetObj.LoadSearchData(sXml,{Append:1 , Sync:1} );
				break;
			case IBSAVE:        //save
				var sParam=ComGetSaveString(sheetObj, true, true);
				if (!sheetObj.IsDataModified()) return;
        		if(!ComShowCodeConfirm('SCG50001', 'data')) return false;	//'Do you want to save {?msg1}?'
				formObj.f_cmd.value=MULTI;
				sParam += "&" + FormQueryString(formObj);
 				var sXml=sheetObj.GetSaveData("VOP_SCG_0077GS.do", sParam);
     			sheetObj.LoadSaveData(sXml);
    			
				break;
        }
    }

    function sheet1_OnSaveEnd(sheetObj, errMsg) {
    	for(var rowIdx=sheetObj.HeaderRows(); rowIdx<=sheetObj.LastRow(); rowIdx++) {
			if(sheetObj.GetCellValue(rowIdx,"ibflag") == 'I') {
				sheetObj.SetCellValue(rowIdx,"ibflag","U",0);
				sheetObj.SetRowStatus(rowIdx,"R");
			}
		}
    }