/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0391.js
*@FileTitle  :  Multi Shipment Detail 
*@author     : CLT
*@version    : 1.0
*@since      : 2016/01/26
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    var sheetObjects = new Array();
    var sheetCnt = 0;

    // Event handler processing by button click event */
    document.onclick = processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
        /***** using extra sheet valuable if there are more 2 sheets*****/
        var sheetObject=sheetObjects[0];
        /** **************************************************** */
        var formObj=document.form;
		try {
			var srcName=ComGetEvent("name");
			switch (srcName) {
			case "btn_retrieve":
				if(ComIsBtnEnable("btn_retrieve")){
					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
				}
				break;
			case "btn_select":
				if(ComIsBtnEnable("btn_select")){
					var sheetTotRow = sheetObjects[0].GetTotalRows();
					if(sheetTotRow == 0){
						return;
					}
					
					var rArray = selectMultiShp(sheetObjects[0]);
					if(!opener) {
						opener=parent;
					}
					try {
						
						//callback_func
						opener.callbackMultiShp(rArray);
						ComClosePopup();
					}catch(e){
						alert(e);
//						ComShowCodeMessage("COM12111");
					} 
				}
				break;
			case "btn_close":
				ComClosePopup(); 
				break;
				
			case "btn_save":
				var rArray = null;
				if(!opener) {
					opener=parent;
				}
				try {
					//callback_func
					opener.callbackMultiShp(sheetObjects[0]);
					ComClosePopup();
				}catch(e){
					ComShowCodeMessage("COM12111");
				} 
				break;
			case "btn_save2":
				if(ComIsBtnEnable("btn_save2")){
					doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
				}
				break;
			case "btn_t6gridadd":
				sheetObjects[0].DataInsert(-1);
				sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(),"prn_flg",1,0);
				sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(),'cntr_seq', 1,0);
				break;
			case "btn_t6griddel":
				ComRowDelete(sheetObjects[0], "sel", 1);
				break;
			} // end switch
		} catch (e) {
			if (e == "[object Error]") {
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
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
	 * initializing sheet
	 * implementing onLoad event handler in body tag
	 * adding first-served functions after loading screen.
	 */
	function loadPage() {
		for (i=0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		if(document.form.uiNo.value == 'ESM_BKG_0229'){
			eBookingMultiShipmentDetailData();
		}else{
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
	}
	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		switch (sheetNo) {
			case 1: //sheet1 init
				with(sheetObj){
					var HeadTitle="|Sel.|CntrSeq|Container No.|MfSeq.|Package|Package|Package|TP/SZ|Weight|WgtUnit|Measure|MeasUnit|Marks|Marks|Description|Vol|Seal No.1|Seal No.2|HTS Code|HTS Code|HS Code|HS Code|NCM Code|NCM Code|P/O No.|Print";
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:5, DataRowMerge:1 } );
	
					var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);
	
					var cols = [ {Type:"Status",		Hidden:1,	Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
					             {Type:"CheckBox",	    Hidden:0,	Width:50,   Align:"Center",  ColMerge:0,   SaveName:"sel" },
					             {Type:"Int",			Hidden:0,	Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cntr_seq",          KeyField:1,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1,	EditLen:3 },
					             {Type:"Text",			Hidden:0,	Width:90,   Align:"Left",    ColMerge:0,   SaveName:"cntr_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      	Hidden:0,	Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cntr_mf_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Int",       	Hidden:0,	Width:50,   Align:"Right",   ColMerge:0,   SaveName:"pck_qty",           KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
					             {Type:"Text",      	Hidden:0,	Width:40,   Align:"Center",  ColMerge:0,   SaveName:"pck_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Popup",     	Hidden:0,	Width:20,   Align:"Center",  ColMerge:0,   SaveName:"PCKPop",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",			Hidden:1,	Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",		 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Float",     	Hidden:0,	Width:80,   Align:"Right",   ColMerge:0,   SaveName:"cntr_mf_wgt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
					             {Type:"Combo",      	Hidden:0,	Width:60,   Align:"Center",  ColMerge:0,   SaveName:"wgt_ut_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Float",     	Hidden:0,	Width:80,   Align:"Right",   ColMerge:0,   SaveName:"meas_qty",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
					             {Type:"Combo",      	Hidden:0,	Width:60,   Align:"Center",  ColMerge:0,   SaveName:"meas_ut_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      	Hidden:0,	Width:80,   Align:"Left",    ColMerge:0,   SaveName:"mk_desc",			 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, MultiLineText:true },
					             {Type:"Popup",     	Hidden:0,	Width:20,   Align:"Center",  ColMerge:0,   SaveName:"MDPop",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      	Hidden:0,	Width:200,  Align:"Left",    ColMerge:0,   SaveName:"cmdt_desc",		 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, MultiLineText:true },
					             {Type:"Float",      	Hidden:1,	Width:60,   Align:"Right",   ColMerge:0,   SaveName:"cntr_vol_qty",		 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      	Hidden:0,	Width:80,   Align:"Center",   ColMerge:0,   SaveName:"cntr_seal_no1",	 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:15, AcceptKeys : "E|N|[~!@#$%^&*()--_+={}[]|\\:;<.>/?]" },
					             {Type:"Text",      	Hidden:0,	Width:80,   Align:"Center",   ColMerge:0,   SaveName:"cntr_seal_no2",	 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:15, AcceptKeys : "E|N|[~!@#$%^&*()--_+={}[]|\\:;<.>/?]" },
					             {Type:"Text",      	Hidden:0,	Width:80,   Align:"Center",   ColMerge:0,   SaveName:"hamo_trf_cd",		 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
					             {Type:"Popup",     	Hidden:0,   Width:20,   Align:"Center",   ColMerge:0,   SaveName:"HTCPop",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      	Hidden:0,	Width:80,   Align:"Center",   ColMerge:0,   SaveName:"cmdt_hs_cd",		 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
					             {Type:"Popup",     	Hidden:0, 	Width:20,   Align:"Center",   ColMerge:0,   SaveName:"CMDTPop",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      	Hidden:0,	Width:80,   Align:"Center",   ColMerge:0,   SaveName:"ncm_no",		     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
					             {Type:"Popup",     	Hidden:0,   Width:20,   Align:"Center",   ColMerge:0,   SaveName:"NCMPop",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      	Hidden:0,	Width:80,   Align:"Center",   ColMerge:0,   SaveName:"po_no",		     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"CheckBox",    	Hidden:0,	Width:50,   Align:"Center",   ColMerge:0,   SaveName:"prn_flg",		     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,TrueValue:"Y", FalseValue:"N" }
					             ];
			       
					InitColumns(cols);
			      
//					SetColProperty("cntr_mf_mk_desc", {AcceptKeys:"N|E|[ ~!@#$%^&*()`_+-={}|[]\\\"\\':;,./<>?\r\n]",  InputCaseSensitive:1} );
//					SetColProperty("cmdt_desc", {AcceptKeys:"N|E|[ ~!@#$%^&*()`_+-={}|[]\\\"\\':;,./<>?\r\n]",  InputCaseSensitive:1} );
					SetColProperty("wgt_ut_cd", {ComboText:"KGS|LBS", ComboCode:"KGS|LBS"} );
					SetColProperty("meas_ut_cd", {ComboText:"CBM|CBF", ComboCode:"CBM|CBF"} );
					SetSheetHeight(350);
					SetEditable(1);
					SetShowButtonImage(2);
					SetAutoRowHeight(0);
				}
			break;
		}
	}
	/**
	 * handling sheet process. <br>
	 **/
	function doActionIBSheet(sheetObj, formObj, sAction, col) {
		//        sheetObj.ShowDebugMsg = true;
		switch (sAction) {
			case IBSEARCH: //Retrieve
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value=SEARCH;
					var rXml=sheetObj.GetSearchData("ESM_BKG_0391GS.do", FormQueryString(formObj));
					ComEtcDataXmlToForm(rXml, formObj);
					sheetObj.LoadSearchData(rXml,{Sync:1} );
				}
				break;
			case IBSAVE:
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value=MULTI;
					var sParam=ComGetSaveString(sheetObj);
					if (sParam == "")
						return false;
					sParam += "&" + FormQueryString(formObj);
					
					var sXml=sheetObj.GetSaveData("ESM_BKG_0391GS.do", sParam);
					var State=ComGetEtcData(sXml,"TRANS_RESULT_KEY");
					if(State != null){
						if ( State == "S" ) {
							sheetObj.LoadSaveData(sXml);
							ComShowMessage(ComGetMsg("BKG06071"));
							doActionIBSheet(sheetObj, formObj, IBSEARCH);
						} else {
							fnExceptionMessage(sXml);
						}
					}
				}
				break;
		}
	}    
	
	function sheet1_OnPopupClick(sheetObj, row, col){
        var col_name=sheetObj.ColSaveName(col);
		switch(col_name) {
			case "PCKPop":
				comBkgCallPop0696("callbackPckTp", sheetObj.GetCellValue(row, "pck_tp_cd"));
			break;
			case "MDPop":
				
				var frm2 = document.form2;
				var width = 450;
				var height = 530;
				var left = (screen.width-width)/2;
				var top = (screen.height-height)/2;
				var win = window.open("", "ESM_BKG_0706", "width="+width+",height="+height+",left="+left+",toolbar=no,directories=no,status=no,scrollbars=no,resizable=no,modal=yes");
				frm2.mk_desc.value = sheetObj.GetCellValue(row, "mk_desc");
				frm2.gds_desc.value = sheetObj.GetCellValue(row, "cmdt_desc");
				frm2.func.value = "callbackMFDesc";
				frm2.action = "ESM_BKG_0706.do";
				frm2.method = "POST";
				frm2.target = "ESM_BKG_0706";
				frm2.submit();	           
			break;
			case "HTCPop":
				var param="?pgmNo=ESM_BKG_0607&hamo_tp_cd=T"+"&hamo_trf_cd="+sheetObj.GetCellValue(row, "hamo_trf_cd");
				ComOpenPopup("ESM_BKG_0607_POP.do"+param, 1010,590, "callbackHTSCode", "1,0,1,1,1", true);
			break;
			case "CMDTPop":
				var param="?pgmNo=ESM_BKG_0607&hamo_tp_cd=H"+"&hamo_trf_cd="+sheetObj.GetCellValue(row, "cmdt_hs_cd");
				ComOpenPopup("ESM_BKG_0607_POP.do"+param, 1010,590, "callbackHSCode", "1,0,1,1,1", true);
			break;
			case "NCMPop":
				var ncm_no=sheetObj.GetCellValue(row, "ncm_no");
				var sUrl="ESM_BKG_0745_P.do?page_gubun=popup&ncm_no="+ncm_no;
				ComOpenPopup(sUrl,1000, 550, "sheet1_SetValues", "1,0", true);  
			break;
		} // end switch
	}	
	
	function sheet1_OnChange(sheetObj, row, col, val){
		var data_type=sheetObj.GetCellProperty(row, col, "Type");
		if(data_type == "Text") {
			sheetObj.SetCellValue(row, col,sheetObj.GetCellValue(row, col).toUpperCase(),0);
		}
        var col_name=sheetObj.ColSaveName(col);
		switch(col_name) {
			case "pck_qty":
			case "cntr_mf_wgt":
			case "meas_qty":
				/* Measure */
	            if(sheetObj.GetCellValue(row, "meas_qty") >= 1000){
					ComShowMessage(ComGetMsg("BKG00174"));
					sheetObj.SetCellValue(row, "meas_qty",0,0);
					sheetObj.SelectCell(row, "meas_qty");
					return false;
				}
	            /* Measure Container No. */
	            var cntr_meas_qty = 0;
	            for(ir=sheetObj.HeaderRows();ir<=sheetObj.RowCount();ir++ ){
	                if(sheetObj.GetRowStatus(ir) != 'D'){
    	                cntr_meas_qty += BkgParseFloat(sheetObj.GetCellValue(ir, "meas_qty"));
	    			}
	    		}
	            cntr_meas_qty=Math.round(cntr_meas_qty * 1000) / 1000;
	            if(cntr_meas_qty >= 1000){
					ComShowMessage(ComGetMsg("BKG00174"));
					sheetObj.SetCellValue(row, "meas_qty",0,0);
					sheetObj.SelectCell(row, "meas_qty");
					return false;
				}
			break;
		} // end switch
	}

	// On After Edit Event Handling
	function sheet1_OnAfterEdit(sheetObj, Row, Col){
        var col_name=sheetObj.ColSaveName(Col);
		switch(col_name) {
			case "mk_desc":
			case "cmdt_desc":
				var str = sheetObj.GetCellValue(Row, col_name);
				sheetObj.SetCellValue(Row, col_name, chekcSpecialValue(str), 0);
			break;
		}
	}
	
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
		switch(sAction) {
			case IBSEARCH:      // Retrieve
			break;
			case IBSAVE:        //저장
				if(sheetObjects[0].GetTotalRows()== 0){
					ComShowMessage(ComGetMsg("BKG95053"));
					return false;
				}
				
				var rcnt=sheetObj.RowCount();
				for(var ix=1;ix<=rcnt;ix++){
					if(sheetObj.GetCellValue(ix, "ibflag") == "D"){ // sheetObj.GetRowHidden(ix)
						continue;
					}
					if(sheetObj.GetCellValue(ix, "cntr_seq") == 0) {
						ComShowMessage(ComGetMsg("BKG00651", "Cntr Seq"));
						return false;
					}
					if(sheetObj.GetCellValue(ix, "cntr_seq") == '') {
						ComShowMessage(ComGetMsg("BKG00651", "cntr_seq"));
						return false;
					}
					
					if(sheetObj.GetCellValue(ix, "pck_qty")!=""){
						// pck qty
					    if(BkgParseInt(sheetObj.GetCellValue(ix, "pck_qty")) < 0){
							ComShowMessage(ComGetMsg("BKG00888", "pck_qty"));
							sheetObj.SelectCell(ix, "pck_qty");
							return false;
						}
						// pck tpye
					    if(sheetObj.GetCellValue(ix, "pck_tp_cd")==""){
							ComShowMessage(ComGetMsg("BKG00888", "pck_tp_cd"));
							sheetObj.SelectCell(ix, "pck_tp_cd");
							return false;
						}							
					}
					
					//Special character check....
					var mf_gds = sheetObj.GetCellValue(ix, "cmdt_desc");
					sheetObj.SetCellValue(ix, "cmdt_desc", chekcSpecialValue(mf_gds), 0);
					var mf_mk = sheetObj.GetCellValue(ix, "mk_desc");
					sheetObj.SetCellValue(ix, "mk_desc", chekcSpecialValue(mf_mk), 0);
					
					if( sheetObj.GetCellValue(ix, "cmdt_desc").length > 3500 ){
		                ComShowCodeMessage("COM12142","Description","3500");
		                return false;
					}
					if( sheetObj.GetCellValue(ix, "mk_desc").length > 3500 ){
		                ComShowCodeMessage("COM12142","Marks","3500");
		                return false;
					}
				} // end of FOR
			break;
		}
        return true;
    }	
	
	function callbackPckTp(returnVal){
		sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "pck_tp_cd",returnVal.cd,0);
	}
	function callbackMFDesc(mk_desc, gds_desc){
		sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "mk_desc",mk_desc,1);
		sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "cmdt_desc",gds_desc,1);
	}
	function setSeq(){
		var rSeq=1;
		var rCnt=sheetObjects[0].RowCount();
		for (rn=1; rn <= rCnt; rn++) {
			var rsts=sheetObjects[0].GetRowStatus(rn);
			if(rsts != 'D' && sheetObjects[0].GetRowHidden(rn) == false){
				sheetObjects[0].SetCellValue(rn, "seq",rSeq++,0);
				sheetObjects[0].SetRowStatus(rn,rsts);
			}
		}
	}
	
	/**
	 * BKG Multi Shippement 선택
	 * @param sheetObject BKG Multi Shippement 선택
	 * @returns [BKG Multi Shippement]1차원 배열로 리턴
	 */
	function selectMultiShp(sheetObject) {
		//old ver.  ibflag|sel|seq|cntr_mf_seq|pck_qty|pck_tp_cd|PCKPop|cntr_tpsz_cd|cntr_mf_wgt|wgt_ut_cd|meas_qty|meas_ut_cd|mk_desc|MDPop|cmdt_desc|cntr_vol_qty|prn_flg
		//new ver.  ibflag|Sel.|CntrSeq|Container No.|MfSeq.|Package|Package|Package|TP/SZ|Weight|WgtUnit|Measure|MeasUnit|Marks|Marks|Description|Vol|Seal No.1|Seal No.2|HS Code|HS Code|HTS Code|HTS Code|NCM Code|NCM Code|P/O No.|Print";
		var arrRow = new Array(2);
    	var rArray = new Array(2);
		
		var colsCnt=sheetObject.LastCol()+ 1;
  		var sCheckRows = sheetObject.FindCheckedRow("sel");
    	arrRow[0] = sCheckRows.split("|");
 		if(sCheckRows == ""){
 			rArray[0]=new Array(0);
 		}else{
 			rArray[0]=new Array(arrRow[0].length);
 	    	for(var idx=0; idx<arrRow[0].length; idx++){ 
 	  			rArray[0][idx]=new Array(colsCnt);
 	  			for(var j=0; j<rArray[0][idx].length; j++) {
 	  				rArray[0][idx][j]=sheetObject.GetCellValue(arrRow[0][idx], j);
 	            }
 	    	}
 		}
	  	return rArray;
	}	

	/**
	 * 
	 */
	function eBookingMultiShipmentDetailData(){
		if(!opener) {
			opener=parent;
		}
		var sheetObj = opener.sheetObjects[3];
		var rowCount = sheetObj.RowCount();
		var headerRows = sheetObj.HeaderRows();
		for (var i = headerRows; i < rowCount + headerRows; i++) {
			var jsonData = sheetObj.GetRowJson(i);
			var newRow = sheetObjects[0].DataInsert();
			sheetObjects[0].SetCellValue(newRow, 'cmdt_desc', jsonData.cmdt_desc);
			sheetObjects[0].SetCellValue(newRow, 'cntr_seq', jsonData.cntr_seq);
			sheetObjects[0].SetCellValue(newRow, 'cntr_mf_seq', jsonData.cntr_mf_seq);
			sheetObjects[0].SetCellValue(newRow, 'cntr_mf_wgt', jsonData.cntr_mf_wgt);
			sheetObjects[0].SetCellValue(newRow, 'cntr_tpsz_cd', jsonData.cntr_tpsz_cd);
			sheetObjects[0].SetCellValue(newRow, 'cntr_vol_qty', jsonData.cntr_vol_qty);
			sheetObjects[0].SetCellValue(newRow, 'meas_qty', jsonData.meas_qty);
			sheetObjects[0].SetCellValue(newRow, 'meas_ut_cd', jsonData.meas_ut_cd);
			sheetObjects[0].SetCellValue(newRow, 'mk_desc', jsonData.mk_desc);
			sheetObjects[0].SetCellValue(newRow, 'pck_qty', jsonData.pck_qty);
			sheetObjects[0].SetCellValue(newRow, 'pck_tp_cd', jsonData.pck_tp_cd);
			sheetObjects[0].SetCellValue(newRow, 'prn_flg', jsonData.prn_flg);
			sheetObjects[0].SetCellValue(newRow, 'wgt_ut_cd', jsonData.wgt_ut_cd);
			
			sheetObjects[0].SetCellValue(newRow, 'cntr_seal_no1', jsonData.cntr_seal_no1);
			sheetObjects[0].SetCellValue(newRow, 'cntr_seal_no2', jsonData.cntr_seal_no2);
			sheetObjects[0].SetCellValue(newRow, 'cmdt_hs_cd', jsonData.cmdt_hs_cd);
			sheetObjects[0].SetCellValue(newRow, 'hamo_trf_cd', jsonData.hamo_trf_cd);
			sheetObjects[0].SetCellValue(newRow, 'ncm_no', jsonData.ncm_no);
			sheetObjects[0].SetCellValue(newRow, 'po_no', jsonData.po_no);
			
		}
		sheetObjects[0].ColumnSort("cntr_seq", "ASC");
	}

	
	function callbackHTSCode(returnValue){
		sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "hamo_trf_cd",returnValue[0][3],0);
	}
	function callbackHSCode(returnValue){
		sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "cmdt_hs_cd",returnValue[0][3],0);
	}
	function sheet1_SetValues(returnValue){
		sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow() , 'ncm_no', returnValue.cd);
	}
