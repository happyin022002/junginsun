/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TES_1003.js
*@FileTitle  : 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/27
=========================================================*/
	// global variable
	var sheetObjects=new Array();
	var sheetCnt=0;
	var opener_obj;
	var opener_sheet_obj;
	var sheet_curr_row;
	/* Event handler processing by button click event */
	document.onclick=processButtonClick;
	/* Event handler processing by button name */
    function processButtonClick(){
         /***** using extra sheet valuable if there are more 2 sheets *****/
         /*******************************************************/
         var sheetObj=sheetObjects[0];
         var formObject=document.form;
    	 try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
        	    case "btn_confirm":
    	            doActionIBSheet(sheetObj,formObject,IBSAVE);
        	        break;
                case "btn_close":
                	ComClosePopup(); 
        	        break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(ComGetMsg('TES23028')); //ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e.message);
    		}
    	}
    }
    /**
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items
     * defining list on the top of source
     * @param {ibsheet} sheet_obj		IBSheet Object
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
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
		var formObj=document.form;
		opener_obj=window.dialogArguments;
		if (!opener_obj) opener_obj = parent;
		opener_sheet_obj=eval('opener_obj.document.t3sheet1');
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
	}
   /**
     * setting sheet initial values and header
     * param : sheetObj ==> , sheetNo ==>  
     * adding case as numbers of counting sheets
     * @param {ibsheet} sheetObj		IBSheet Object 
     * @param {int}	sheetNo				IBSheet number
     */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		switch(sheetNo) {
		 case 1:      //sheet1 init
			with (sheetObj) {
		        var HeadTitle0="Seq|Cost Code|Input\nAmount|Select|VVD|VVD|Bound|Allocated\nVolume|Allocated\nVolume(%)|Allocated\nAmount";

		        SetConfig( { SearchMode:2, MergeSheet:2, Page:20, DataRowMerge:1 } );

		        var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		        var headers = [ { Text:HeadTitle0, Align:"Center"} ];
		        InitHeaders(headers, info);

		        var cols = [ {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"lgs_cost_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"inv_amt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"choice" },
		               {Type:"Text",      Hidden:0,  Width:60,   Align:"Left",    ColMerge:0,   SaveName:"vvd_type",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"vvd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"io_bnd_cd",          KeyField:0,   CalcLogic:"",   Format:"" },
		               {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"cntr_qty_sum",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0 },
		               {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"allocated_volumn",   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0 },
		               {Type:"Text",      Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"calc_amt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
		               {Type:"Text",      Hidden:1, Width:120,  Align:"Right",   ColMerge:0,   SaveName:"tml_so_ofc_cty_cd",  KeyField:0,   CalcLogic:"",   Format:"" },
		               {Type:"Text",      Hidden:1, Width:120,  Align:"Right",   ColMerge:0,   SaveName:"tml_so_seq",         KeyField:0,   CalcLogic:"",   Format:"" },
		               {Type:"Text",      Hidden:1, Width:120,  Align:"Right",   ColMerge:0,   SaveName:"tml_so_dtl_seq",     KeyField:0,   CalcLogic:"",   Format:"" },
		               {Type:"Text",      Hidden:1, Width:120,  Align:"Right",   ColMerge:0,   SaveName:"vsl_cd",             KeyField:0,   CalcLogic:"",   Format:"" },
		               {Type:"Text",      Hidden:1, Width:120,  Align:"Right",   ColMerge:0,   SaveName:"skd_voy_no",         KeyField:0,   CalcLogic:"",   Format:"" },
		               {Type:"Text",      Hidden:1, Width:120,  Align:"Right",   ColMerge:0,   SaveName:"skd_dir_cd",         KeyField:0,   CalcLogic:"",   Format:"" },
		               {Type:"Text",      Hidden:1, Width:120,  Align:"Right",   ColMerge:0,   SaveName:"atb_dt",             KeyField:0,   CalcLogic:"",   Format:"" },
		               {Type:"Text",      Hidden:1, Width:120,  Align:"Right",   ColMerge:0,   SaveName:"cntr_tpsz_cd",       KeyField:0,   CalcLogic:"",   Format:"" },
		               {Type:"Text",      Hidden:1, Width:120,  Align:"Right",   ColMerge:0,   SaveName:"fm_tr_vol_val",      KeyField:0,   CalcLogic:"",   Format:"" },
		               {Type:"Text",      Hidden:1, Width:120,  Align:"Right",   ColMerge:0,   SaveName:"to_tr_vol_val",      KeyField:0,   CalcLogic:"",   Format:"" },
		               {Type:"Text",      Hidden:1, Width:120,  Align:"Right",   ColMerge:0,   SaveName:"dcgo_ind_cd",        KeyField:0,   CalcLogic:"",   Format:"" },
		               {Type:"Text",      Hidden:1, Width:120,  Align:"Right",   ColMerge:0,   SaveName:"vol_tr_ut_cd",       KeyField:0,   CalcLogic:"",   Format:"" },
		               {Type:"Text",      Hidden:1, Width:120,  Align:"Right",   ColMerge:0,   SaveName:"inv_xch_rt",         KeyField:0,   CalcLogic:"",   Format:"" },
		               {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" } ];
		         
		        InitColumns(cols);
		        SetEditable(1);
		        SetSheetHeight(240);

		   }
			break;
		}
	}
     /**
      *  handling IBSheet process
      * 
      * @param {ibsheet} 	sheetObj		IBSheet Object 
      * @param {form}		formObj			form object
      * @param {String}		sAction			form action value
      * @return
      */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
		   case IBSEARCH:
                formObj.f_cmd.value=SEARCH;
                sheetObj.DoSearch("ESD_TES_1003GS.do", tesFrmQryStr(formObj) );
			    break;
            case IBSAVE: 
                var inv_amt=0;
                var calc_amt=0;
                for (var i=sheetObj.HeaderRows(); i<(sheetObj.HeaderRows()+ sheetObj.RowCount()); i++){
                    sheetObj.SetRowStatus(i,'R');
                    if(sheetObj.GetCellValue(i,"choice") == "1" ){
                    	if(sheetObj.GetCellValue(i,"vvd_type") == "Input"){
                            sheetObj.SetRowStatus(i,'U');
                            inv_amt=inv_amt+Number(sheetObj.GetCellValue(i,"inv_amt"));
                        }else{
                            sheetObj.SetRowStatus(i,'I');
                            document.form.io_bnd_cd2.value=sheetObj.GetCellValue(i,"io_bnd_cd");
                        }
                    	calc_amt=calc_amt+Number(sheetObj.GetCellValue(i,"calc_amt"));
                    }
                }
                if(inv_amt != calc_amt){
                    ComShowMessage('Sum of allocated amount is different from input amount!');
                    return false;
                }
                if (sheetObj.RowCount()> 0 && sheetObj.IsDataModified()){
						    formObj.f_cmd.value=MULTI;
						    var param=sheetObj.GetSaveString(false,false);
						    var savexml=sheetObj.GetSaveData("ESD_TES_1003GS.do", param+'&'+tesFrmQryStr(formObj));
						    sheetObj.LoadSaveData(savexml,true);
				}
				sheetObj.MergeSheet=msPrevColumnMerge;
                break;
		}
    }
     /**
      * handling process for input validation
      * @param {ibsheet} 	sheetObj		IBSheet Object 
      * @param {form}		formObj			form object
      * @param {String}		sAction			form action value
      * 
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
    /** Search end event
     * 
     * @param {ibsheet}	sheetObj
     * @param {String}	ErrMsg
     * @return
     */    
	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
		var formObj=document.form;
		var cnt=0;
		if (sheetObj.RowCount()> 0){
		    for (var i=sheetObj.HeaderRows(); i<(sheetObj.HeaderRows()+ sheetObj.RowCount()); i++){
		        if(i%2){
		            sheetObj.SetCellValue(i,'seq',++cnt);
		        }else{
		            sheetObj.SetCellValue(i,'seq',cnt);
		            sheetObj.SetRangeBackColor(i,3,i,10,"#FFD2FF");
		        }
		        if(sheetObj.GetCellValue(i,'vvd_type') == "Input"){
		        	sheetObj.SetCellValue(i,'calc_amt',sheetObj.GetCellValue(i,'inv_amt'));
		        }
		        sheetObj.SetCellValue(i,"choice","1");
		    }
		}
	}
	/** svae end event
	 * 
	 * @param {ibsheet}	sheet	IBsheet object
	 * @param {String}	Row		cell의 row index
	 * @param {String}	Col		celldml col index
	 * @param {String}	Value	
	 * @return
	 */
	function sheet1_OnSaveEnd(sheet, Row, Col, Value) {
		ComClosePopup(); 
	    window.dialogArguments.retrieveAll();
	}
	/**
	 * popup click event
	 * 
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @return
	 */
	function sheet1_OnPopupClick(sheetObj,Row,Col){
		tes_get3rdParty_sheet(sheetObj.GetCellValue(Row,"vndr_cust_div_cd"), Row, Col );
	}
	/** 
	 * sheet click event
	 *  
	 * @param sheetObj
	 * @param row
	 * @param col
	 * @param value
	 * @return
	 */
	function sheet1_OnClick(sheetObj, row, col, value){
	     if(sheetObj.ColSaveName(col) == "choice"){
	    	 var str=sheetObj.GetCellValue(row,"tml_so_dtl_seq") ;
	         for (var i=sheetObj.HeaderRows(); i<(sheetObj.HeaderRows()+ sheetObj.RowCount()); i++){
	        	 if(str == sheetObj.GetCellValue(i,"tml_so_dtl_seq") && row != i){
	        		 if(sheetObj.GetCellValue(row,"choice") == '0'){
	                     sheetObj.SetCellValue(i,"choice","1");
	                 }else{
	                     sheetObj.SetCellValue(i,"choice","0");
	                 }
	             }
	         }
	     }
	}
	/**
	 * change event
	 * 
	 * @param {ibsheet}	sheetObj	IBsheet object
	 * @param {String}	row			row index
	 * @param {String}	col			Column index	
	 * @param {String}	value		
	 * @return
	 */
	function sheet1_OnChange(sheetObj, row, col, value){
		var dtl_seq=sheetObj.GetCellValue(row,"tml_so_dtl_seq");
		var vvd_type=sheetObj.GetCellValue(row,"vvd_type");
	    var cnt=0;
	    var cnt2=0;
	    var cal_vol=0;
	    var cal_vol2=0;
	    var cal_vol3=0;
	    var cal_vol4=0;
	    var colName=sheetObj.ColSaveName(col) ;
	    if(colName == "allocated_volumn" && Number(sheetObj.GetCellValue(row,"allocated_volumn")) > 0){
	    	if(Number(sheetObj.GetCellValue(row,"allocated_volumn")) > 100){
	             sheetObj.SetCellValue(row,"allocated_volumn",0);
	             return false;
	         }else{
	             for (var i=sheetObj.HeaderRows(); i<(sheetObj.HeaderRows()+ sheetObj.RowCount()); i++){
	            	 if(sheetObj.GetCellValue(i,"tml_so_dtl_seq") == dtl_seq && sheetObj.GetCellValue(i,"vvd_type") != vvd_type){
	                     cnt=i;
	                 }
	             }
	             sheetObj.SetCellValue(cnt,"allocated_volumn",100 - Number(sheetObj.GetCellValue(row,"allocated_volumn")));
	         }
	    	cal_vol=Number(sheetObj.GetCellValue(row,"allocated_volumn"));
	    	cal_vol2=Number(sheetObj.GetCellValue(cnt,"allocated_volumn"));
	    	sheetObj.SetCellValue(row,"calc_amt",Number(sheetObj.GetCellValue(row,"inv_amt"))*cal_vol/100 );
	    	sheetObj.SetCellValue(cnt,"calc_amt",Number(sheetObj.GetCellValue(cnt,"inv_amt"))*cal_vol2/100 );
	    	if(Number(sheetObj.GetCellValue(row,"inv_amt")) < Number(sheetObj.GetCellValue(row,"calc_amt"))+Number(sheetObj.GetCellValue(cnt,"calc_amt"))){
	    		cnt2=Number(sheetObj.GetCellValue(row,"calc_amt"))+Number(sheetObj.GetCellValue(cnt,"calc_amt")) - Number(sheetObj.GetCellValue(row,"inv_amt"));
	    		sheetObj.SetCellValue(cnt,"calc_amt",Number(sheetObj.GetCellValue(cnt,"calc_amt")) - cnt2);
	         }
	         sheetObj.SetCellValue(row,"cntr_qty_sum",0);
	         sheetObj.SetCellValue(cnt,"cntr_qty_sum",0);
	     }
	     if(colName == "cntr_qty_sum"){
	          for (var i=sheetObj.HeaderRows(); i<(sheetObj.HeaderRows()+ sheetObj.RowCount()); i++){
	        	  if(sheetObj.GetCellValue(i,"tml_so_dtl_seq") == dtl_seq && sheetObj.GetCellValue(i,"vvd_type") != vvd_type){
	                     cnt=i;
	                 }
	          }
	          cal_vol=Number(sheetObj.GetCellValue(row,"cntr_qty_sum"));
	          cal_vol2=Number(sheetObj.GetCellValue(cnt,"cntr_qty_sum"));
	          if(cal_vol > 0 && cal_vol2 > 0){
	               cal_vol3=cal_vol/(cal_vol+cal_vol2)*100;
	               cal_vol4=cal_vol2/(cal_vol+cal_vol2)*100;
	               sheetObj.SetCellValue(row,"calc_amt",Number(sheetObj.GetCellValue(row,"inv_amt"))*cal_vol3/100 );
	               sheetObj.SetCellValue(cnt,"calc_amt",Number(sheetObj.GetCellValue(cnt,"inv_amt"))*cal_vol4/100 );
	               if(Number(sheetObj.GetCellValue(row,"inv_amt")) < Number(sheetObj.GetCellValue(row,"calc_amt"))+Number(sheetObj.GetCellValue(cnt,"calc_amt"))){
	            	   cnt2=Number(sheetObj.GetCellValue(row,"calc_amt"))+Number(sheetObj.GetCellValue(cnt,"calc_amt")) - Number(sheetObj.GetCellValue(row,"inv_amt"));
	            	   sheetObj.SetCellValue(cnt,"calc_amt",Number(sheetObj.GetCellValue(cnt,"calc_amt")) - cnt2);
	               }
	               sheetObj.SetCellValue(row,"allocated_volumn",0);
	               sheetObj.SetCellValue(cnt,"allocated_volumn",0);
	          }
	     }
	}
