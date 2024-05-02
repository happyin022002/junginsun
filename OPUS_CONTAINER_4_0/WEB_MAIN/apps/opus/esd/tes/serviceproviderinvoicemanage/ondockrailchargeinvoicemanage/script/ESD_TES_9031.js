/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_903_2.js
*@FileTitle : Revised Volume Popup-On-Dock Rail Charge Invoice
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/

var sheetObjects = new Array();
var sheetCnt = 0;

/* Event handler processing by button click event */
document.onclick = processButtonClick;

/* Event handler processing by button name */
    function processButtonClick(){
         /***** using extra sheet valuable if there are more 2 sheets *****/
         /*******************************************************/
         var sheetObj = sheetObjects[0];
         var formObj = document.form;

    	 try {
    		 var srcName=ComGetEvent("name");
            switch(srcName) {
        	    case "btn_ok":
     	            doActionIBSheet(sheetObj,formObj,IBSAVE);
     	            ComClosePopup(); 
        	        break;

         	    case "btn_close":
         	    	ComClosePopup(); 
        	        break;


            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(ComGetMsg('TES21506')); //ComShowMessage(OBJECT_ERROR);
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
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }

   /**
     * setting sheet initial values and header
     * param : sheetObj ==> , sheetNo ==>  
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
        switch(sheetNo) {
            case 1: 
                with (sheetObj) {
            	
            	var HeadTitle = "STS|Seq.|cntr Seq.|dtl Seq.|rvis Seq.|chk|Cost Code|CNTR No.|TP|F/M|INV TP|CALC GROUP|RVIS TP|Booking No|bkg_no_split|vsl_cd|skd_voy_no|skd_dir_cd";
            	
            	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
            	
            	var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	            var headers = [ { Text:HeadTitle, Align:"Center"} ];
	            InitHeaders(headers, info);
            	
	            var cols = [ 
		                      {Type:"Status",    Hidden:1, 	Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                      {Type:"Seq",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"",                      		KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:1,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"rvis_tml_so_cntr_list_seq",    KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",   	 Hidden:1, 	Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rvis_tml_so_dtl_seq",          KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",   	 Hidden:1, 	Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rvis_tml_so_rvis_list_seq",    KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      
		                      {Type:"CheckBox",  Hidden:0, 	Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rvis_ind_flg",           		KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",   	 Hidden:0, 	Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rvis_lgs_cost_cd",           	KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:0, AcceptKeys:"E", InputCaseSensitive:1 },
		                      {Type:"Text",   	 Hidden:0, 	Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rvis_cntr_no",           		KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:0, AcceptKeys:"E|N", InputCaseSensitive:1 },
		                      {Type:"Text",   	 Hidden:1, 	Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rvis_cntr_tpsz_cd",           	KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",   	 Hidden:1, 	Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rvis_cntr_sty_cd",           	KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      
		                      {Type:"Text",   	 Hidden:1, 	Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rvis_tml_inv_tp_cd",           KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",   	 Hidden:1, 	Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rvis_calc_cost_grp_cd",        KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",   	 Hidden:1, 	Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rvis_tml_rvis_tp_cd",          KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",   	 Hidden:0, 	Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rvis_bkg_no",           		KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:0, AcceptKeys:"E|N", InputCaseSensitive:1 },
		                      {Type:"Text",   	 Hidden:1, 	Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rvis_bkg_no_split",           	KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      
		                      {Type:"Text",   	 Hidden:1, 	Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rvis_vsl_cd",          	 	KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",   	 Hidden:1, 	Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rvis_skd_voy_no",           	KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",   	 Hidden:1, 	Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rvis_skd_dir_cd",           	KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",   	 Hidden:1, 	Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rvis_calc_tp_cd",           	KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 }
		             ];
		                
                InitColumns(cols);
                SetEditable(1);
                SetSheetHeight(260);
               }
                
               break;
        }
    }


    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {
            case IBSEARCH:	  //Retrieve
                formObj.f_cmd.value = SEARCH01;
//                var searchXml = sheetObj.GetSearchXml("ESD_TES_9031GS.do",  tesFrmQryStr(formObj));
                var searchXml = sheetObj.GetSearchData("ESD_TES_9031GS.do",  tesFrmQryStr(formObj));
//                sheetObj.RemoveAll();
                if(searchXml != null) sheetObj.LoadSearchData(searchXml,{Sync:1});
                break;

//            case IBSEARCH_ASYNC01:	  //Retrieve
//                formObj.f_cmd.value = SEARCH02;
//                var searchXml = sheetObj.GetSearchXml("ESD_TES_903_1GS.do",  FormQueryString(formObj));
//                if (searchXml != "") sheetObj.LoadSearchXml(searchXml,true);
//                break;

            case IBSAVE:
                formObj.f_cmd.value = MODIFY;
                formObj.rvis_vol_qty.value = getRVISQty();

                var param = sheetObj.GetSaveString();
                var saveXml = sheetObj.GetSaveData("ESD_TES_9031GS.do", param+'&'+tesFrmQryStr(formObj));
                if(searchXml != null) sheetObj.LoadSaveData(saveXml);
        }
    }

    function sheet_OnSaveEnd(sheetObj){//alert("start sheet_OnSaveEnd");
        //window.dialogArguments.document.t3sheet1.CellValue(document.form.opener_row.value,'rvis_vol_qty') = getRVISQty();
    }


	function getRVISQty(){
	    var sheetObj = sheetObjects[0];
	    var qty = 0;
	    var cntr_tpsz = document.form.cntr_tpsz_cd.value;
	    var calc_tp = 0;

	    for(var i=sheetObj.HeaderRows(); i<sheetObj.HeaderRows()+sheetObj.RowCount(); i++){
	        if(sheetObj.GetCellValue(i,'rvis_ind_flg') == calc_tp){
	            qty = parseInt(qty) + 1;
	        }
	    }

	    if(document.form.vol_tr_ut_cd.value == 'T'){
	        if(cntr_tpsz == 'D4'){
                return parseFloat(qty) * 2;
            }else if(cntr_tpsz == 'D7'){
                return parseFloat(qty) * 2.25;
            }else if(cntr_tpsz == 'D8'){
                return parseFloat(qty) * 2.4;
            }else if(cntr_tpsz == 'D9'){
                return parseFloat(qty) * 2.4;
            }else if(cntr_tpsz == 'DW'){
                return parseFloat(qty) * 2.65;
            }else if(cntr_tpsz == 'DX'){
                return parseFloat(qty) * 2.25;
            }
	    }
	    return qty;
	}