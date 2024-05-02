/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1070.js
*@FileTitle  : China: Manifest Transmission(CNYIT)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/08
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends 
 * @class esm_bkg_1070 : business script for esm_bkg_1070
 */
   //Common global variable
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var selecteRowCnt =0;
	//Event handler processing by button click event */
	document.onclick=processButtonClick;
	//Event handler processing by button name */
	function processButtonClick(){
		/***** using extra sheet valuable if there are more 2 sheets *****/
	    var sheetObject1=sheetObjects[0];
	    var sheetObject2=sheetObjects[1];
	    /*******************************************************/
	    var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
				break;
				case "btn_new":
					doActionIBSheet(sheetObject1,formObject,IBRESET);
				break;
				case "btn_excel":
					if(sheetObject1.RowCount() < 1){//no data
	        	     	ComShowCodeMessage("COM132501");
	        	    } else{
	        	    	doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL)
	        	    }
				break;
				case "btn_Transmit":
					doActionIBSheet(sheetObject2,formObject,IBSEARCH_ASYNC01);
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
		    initSheet(sheetObjects[i],i+1);
		    ComEndConfigSheet(sheetObjects[i]);
	    }
		var formObj=document.form;
		//necessary event on the screen
		axon_event.addListenerForm("Click","obj_Click", formObj);
		//  axon_event.addListenerForm("KeyUp","obj_KeyUp", formObj);
		//  axon_event.addListenerFormat("KeyPress","obj_KeyPress", formObj);
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
		//ComBtnDisable("btn_Transmit");
		ComBtnDisable("btn_Transmit");
		formObj.vvd.focus();
	}
	/**
	 * move next tab in case of typing MaxLength
	 */
	function obj_KeyUp() {
		var formObject=document.form;
		var srcMaxLength= ComGetEvent("maxlength");
		var srcValue= ComGetEvent("value");
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		if ((srcName == "vvd" || srcName == "pol_cd" ) && ComChkLen(srcValue, srcMaxLength) == "2" ) {
			ComSetNextFocus();
		}
	}
	/**
	  * setting sheet initial values and header
	  * @param sheetObj
	  * @param sheetNo
	  * @return
	  */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		switch(sheetID) {
	     	case "sheet1":      //sheet1 init
	     	    with(sheetObj){
			          var HeadTitle1="|Sel.|Seq.|B/L No.|BKG No.|STS|POL|POD|DEL|Package|Package|Weight|Weight|Seal|Seal|SHPR|SHPR|CNEE|CNEE|NTFY|NTFY|TP|TR|DG|RF|CNTR|Transmit Status|Transmit Status";
			          var HeadTitle2="|Sel.|Seq.|B/L No.|BKG No.|STS|POL|POD|DEL|Package|Package|Weight|Weight|Seal|Seal|N|A|N|A|N|A|TP|TR|DG|RF|CNTR|User|Time";
			          var headCount=ComCountHeadTitle(HeadTitle1);
			          SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			          var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			          var headers = [ { Text:HeadTitle1, Align:"Center"},
			                          { Text:HeadTitle2, Align:"Center"} ];
			          InitHeaders(headers, info);
			          var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			                 {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Chk" },
			                 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
			                 {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"bl_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bkg_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"del_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"pck_qty",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"pck_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"act_wgt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"wgt_ut_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seal_no_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"sealer_cd_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"shpr_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"shpr_addr",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cnee_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cnee_addr",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ntfy_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ntfy_addr",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"bkg_cgo_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"tr",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"dcgo_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"rc_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_cnt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"trsm_msg_tp_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"mf_snd_dt",       KeyField:0,   CalcLogic:"",   Format:"YmdHms",      PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 } ];
			          InitColumns(cols);
			          SetEditable(1);
			          SetSheetHeight(360);
			          SetCountPosition(0);
			          
			          sheetObj.SetMergeCell(0, 9, 2, 2);
			          sheetObj.SetMergeCell(0, 11, 2, 2);
			          sheetObj.SetMergeCell(0, 13, 2, 2);
			          SetRangeBackColor(1,1,1,40,"#555555");
			          }
		        break;
	     	case "sheet2":      //sheet1 init
	     	    with(sheetObj){
			          var HeadTitle="flag||Seq|B/L No.|BKG No.";
			          var headCount=ComCountHeadTitle(HeadTitle);
			          SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			          var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			          var headers = [ { Text:HeadTitle, Align:"Center"} ];
			          InitHeaders(headers, info);
			          var cols = [ {Type:"Status",    Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			                 {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Chk" },
			                 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
			                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bl_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
			          InitColumns(cols);
			          SetEditable(1);
			          sheetObj.SetVisible(0);
	                }
		        break;
		}
	}
	/**
	 * handling after retrieve
	 * @param sheetObj
	 * @param ErrMsg
	 * @return
	 */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		var tot_cntr=0;
	    
		for (i=2; i<sheetObj.RowCount()+2; i++){
		   	for(j=9; j<20; j++){
		   		if(sheetObj.GetCellValue(i, j) == 'N'){
		   			sheetObj.SetCellFontColor(i, j, "#FF0000");
				}
		   	}
		   	tot_cntr=tot_cntr + parseInt(sheetObj.GetCellValue(i, "cntr_cnt"));
		}
		
	    document.form.bl_cnt.value=ComAddComma(sheetObj.GetTotalRows());
	    document.form.cntr_cnt.value=ComAddComma(tot_cntr);
	}
	/**
	 * clicking same row of hidden sheet at checkbox in case of clicking checkbox of sheet
	 */
	function sheet1_OnChange(sheetObj, row, col, val) {
		var sheetObj2=sheetObjects[1];
		if(sheetObj.ColSaveName(col) == "Chk"){
			sheetObj2.SetCellValue(row-1, "Chk",sheetObj.GetCellValue(row, "Chk"),0);
		}
		
		selecteRowCnt =sheetObj.CheckedRows("Chk");
	
	}
	/**
	 * Sorting in case of clicking header
	 */
	//function sheet1_OnSort(sheetObj, Col, SortArrow) {
	//	var sheet2 = sheetObjects[1];
	//	sheet2.ColumnSort(Col, SortArrow);
	//}
	
	 /**
	  * handling sheet process
	  */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.SetWaitImageVisible(0);
		switch(sAction) {
			case IBSEARCH:      //Retrieve
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				ComOpenWait(true);
				formObj.f_cmd.value=SEARCH;
				var sXml=sheetObj.GetSearchData("ESM_BKG_1070GS.do", FormQueryString(formObj));
				var State=ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
		        if(State == "S"){
		        	 var sheetObj2=sheetObjects[1];
	                 
		        	 sheetObj.LoadSearchData(sXml,{Sync:1} );
	                 sheetObj2.LoadSearchData(sXml,{Sync:1} );
	     			 if(sheetObj.GetTotalRows()> 0){
		                 sheetObj.CheckAll("Chk",1,1);
		                 sheetObj2.CheckAll("Chk",1,1);
	     			 }
	                 
	     			 document.form.call_sgn_no.value=ComGetEtcData(sXml,"call_sgn_no") == "null" ? "" : ComGetEtcData(sXml,"call_sgn_no");
	                 document.form.pre_port.value=ComGetEtcData(sXml,"pre_port") 	 == "null" ? "" : ComGetEtcData(sXml,"pre_port");
	                 document.form.nxt_port.value=ComGetEtcData(sXml,"nxt_port") 	 == "null" ? "" : ComGetEtcData(sXml,"nxt_port");
	                 document.form.vps_eta_dt.value=ComGetEtcData(sXml,"vps_eta_dt")  == "null" ? "" : ComGetEtcData(sXml,"vps_eta_dt");
	                 document.form.vps_etd_dt.value=ComGetEtcData(sXml,"vps_etd_dt")  == "null" ? "" : ComGetEtcData(sXml,"vps_etd_dt");
	                 document.form.vsl_eng_nm.value=ComGetEtcData(sXml,"vsl_eng_nm")  == "null" ? "" : ComGetEtcData(sXml,"vsl_eng_nm");
	                 document.form.snd_date.value=ComGetEtcData(sXml,"snd_date")  == "null" ? "" : ComGetEtcData(sXml,"snd_date");
	                 document.form.eta_flg.value=ComGetEtcData(sXml,"eta_flg") == "null" ? "" : ComGetEtcData(sXml,"eta_flg");
	                 document.form.etd_flg.value=ComGetEtcData(sXml,"etd_flg") == "null" ? "" : ComGetEtcData(sXml,"etd_flg");
	             	if( formObj.bl_type.value != 'A' ){
	             		if(sheetObj.GetTotalRows()> 0){
	                 		ComBtnEnable("btn_Transmit");
	             		}
	             	} else{
	             		ComBtnDisable("btn_Transmit");
	             	}
		        } else{
		        	// print error message
		    		ComShowMessage(ComResultMessage(sXml));
		        }
				ComOpenWait(false);
			break;
			
	        case IBRESET:        //New
	    	    formObj.reset();
	    	    sheetObjects[0].RemoveAll();
	    	    sheetObjects[1].RemoveAll();
	    	    sheetObjects[0].CheckAll("Chk",0,1);
	    	    sheetObjects[1].CheckAll("Chk",0,1);
	    	    ComBtnDisable("btn_Transmit");
	    	break;
	    	
			case IBDOWNEXCEL: 	//Down Excel
			   	if (sheetObj.RowCount()== 0 ) {
			   		ComShowCodeMessage("BKG00389"); // No data to dowload as Excel
			   	    return;
			   	} else {
					ComOpenWait(true);
					sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
					ComOpenWait(false);
			   	}
			break;
			case IBSEARCH_ASYNC01:	//Transmit Manifest
				
				formObj.f_cmd.value=COMMAND01;
				
				if(selecteRowCnt ==0){
					ComShowCodeMessage("BKG00149"); 
					return;
					
				} else { 
					ComOpenWait(true);
					var sParam=FormQueryString(formObj) + "&" + sheetObjects[0].GetSaveString(false);
					var sXml=sheetObj.GetSaveData("ESM_BKG_1070GS.do", sParam);
					var State=ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
			        ComOpenWait(false);
					
			        ComShowMessage(ComResultMessage(sXml));
			        
			        if(State == "S"){
			        	//formObj.output.value = ComGetEtcData(sXml, "flatFile");
				        doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
			        }
				}
			break;
		}
	}
	 /**
	  * handling process for input validation <br>
	  * @param sheetObj
	  * @param formObj
	  * @param sAction
	  * @return boolean
	  */
	function validateForm(sheetObj,formObj,sAction){
	    switch (sAction) {
		    case IBSEARCH: // retrieve
				if(!ComChkRequired(formObj)) return false;
		        return true;
		        break;
	    }
	}