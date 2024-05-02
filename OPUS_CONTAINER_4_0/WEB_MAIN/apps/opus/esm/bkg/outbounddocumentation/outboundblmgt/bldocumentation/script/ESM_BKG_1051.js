/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1051.js
*@FileTitle  : Container And Booking Comparison
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	// Common global variable
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	// Event handler processing by button click event */
	document.onclick = processButtonClick;
	
	// Event handler processing by button name */
    function processButtonClick(){
         /* */
		 var sheetObject1=sheetObjects[0];
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
			ComConfigSheet (sheetObjects[i] );
			//initSheet
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
        }
		//
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		//
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
                    var HeadTitle1="TP/SZ|Category|DR|DG|RF|AK|BB|HG|SOC|Receive Term|Receive Term|Receive Term|Receive Term|Receive Term|Delivery Term|Delivery Term|Delivery Term|Delivery Term|Delivery Term|Vol";
                    var HeadTitle2="TP/SZ|Category|DR|DG|RF|AK|BB|HG|SOC|Y|D|S|T|I|Y|D|S|T|O|Vol";
                    
                    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
                    
                    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                    var headers = [ { Text:HeadTitle1, Align:"Center"},
                                    { Text:HeadTitle2, Align:"Center"} ];
                    InitHeaders(headers, info);
                    
                    var cols = [ {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"category",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"dry_cgo_flg",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"dcgo_flg",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"rc_flg",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"awk_cgo_flg",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"bb_cgo_flg",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"hngr_flg",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"soc_flg",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"rcv_term_y",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"rcv_term_d",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"rcv_term_s",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"rcv_term_t",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"rcv_term_i",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"de_term_y",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"de_term_d",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"de_term_s",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"de_term_t",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"de_term_o",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                                 {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"op_cntr_qty",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 } ];
                    
                    InitColumns(cols);
                    
                    SetEditable(0);
                    SetSheetHeight(290);
                }
                

                break;
        }
    }
  // handling process for Sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			case IBSEARCH:      //retrieve
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value=SEARCH;
                     var rXml=sheetObj.GetSearchData("ESM_BKG_1051GS.do", FormQueryString(formObj));
					if(rXml == '' || rXml.length < 7) return false;
					if(rXml.substring(1, 6) == "ERROR"){
						ComShowMessage(ComResultMessage(rXml));
						return false;
					}
					sheetObj.LoadSearchData(rXml,{Sync:1});
				}
			break;
        }
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        return true;
    }
	function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
		var sheetObj=sheetObjects[0];
		for(ir=sheetObj.HeaderRows();ir<=sheetObj.LastRow();ir++ ){
            var tpSz=sheetObj.GetCellValue(ir, "cntr_tpsz_cd");
            var cate=sheetObj.GetCellValue(ir, "category");
			var varFlg=false;
			//alert(ir + " -> " + tpSz + " : " + cate);
			if(cate == "BKG"){
				sheetObj.SetMergeCell(ir, 0, 3, 1);
			}
			if(cate == "CNTR"){
				opener = (opener || parent);
				if(opener != undefined){
					var cntrQtyArr=opener.getCntrQtyByType(tpSz);
					if(cntrQtyArr != null){
						for(ic=2 ;ic<=sheetObj.LastCol();ic++){
							sheetObj.SetCellValue(ir, ic,(cntrQtyArr[ic] == 0) ? '' : cntrQtyArr[ic],0);
						}
					}
				}
			}
			if(cate == "Difference"){  
				for(ic=2 ;ic<=sheetObj.LastCol();ic++){
                    var p1=(sheetObj.GetCellValue(ir-2, ic)=="") ? 0 : parseFloat(sheetObj.GetCellValue(ir-2, ic)); 
                    var p2=(sheetObj.GetCellValue(ir-1, ic)=="") ? 0 : parseFloat(sheetObj.GetCellValue(ir-1, ic));
					//alert(sheetObj.CellValue(ir-2, ic) +" - "+ sheetObj.CellValue(ir-1, ic) + " = " + (p1 - p2));
					//sheetObj.CellValue2(ir, ic) = ((p1-p2)==0) ? '' : (p1-p2);
                    sheetObj.SetCellValue(ir, ic,((sheetObj.GetCellValue(ir-2, ic)=="") && (sheetObj.GetCellValue(ir-1, ic)=="")) ? '' : (p1-p2),0);
					if((p1-p2) != 0){
						varFlg=true;
 						sheetObj.SetCellFontBold(ir, ic,1);
 						sheetObj.SetCellFontColor(ir, ic,"#FF0000");
					}
				}
			}
		}
	}
