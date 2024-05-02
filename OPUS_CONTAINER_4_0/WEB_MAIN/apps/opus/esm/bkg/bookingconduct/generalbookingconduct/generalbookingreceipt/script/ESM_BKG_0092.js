/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0092.js
*@FileTitle  :  Route Detail 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

    var sheetObjects = new Array();
    var sheetCnt = 0;

    var comboObjects = new Array();
    var comboCnt = 0; 
    
    var openPop = "true";
    var gOpen = "Y";
    
 // Event handler processing by button click event */
    document.onclick = processButtonClick;

    // Event handler processing by button name */
    function processButtonClick(){
        /***** using extra sheet valuable if there are more 2 sheets*****/
        var sheetObject=sheetObjects[0];
        var combo1=comboObjects[0];
        var combo2=comboObjects[1];
        /** **************************************************** */
        var formObj=document.form;
        try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
				case "btn_Save":
					if(validateForm(sheetObject, formObj)){   
						if(formObj.ca_flg.value == 'Y' && sheetObject.RowCount()> 4){
							// if the number of vvd is more than 4,separate with SCE
							setParentToPopup(sheetObject, formObj);	            	   			 
						} else {
							doActionIBSheet(sheetObject, formObj, IBSAVE, "", "");
						}
					}
					break;
				case "btn_New":
					clearOceanRoute(sheetObject, formObj);
					break;
				case "btn_RowAdd":
					// caFlag = 'Y', max 7Row, 'N' max 5Row
					var caFlg=formObj.ca_flg.value;
					var rowCnt=sheetObject.RowCount();
					if(caFlg == "Y"){
						if(rowCnt < 7){
							sheetObject.DataInsert(-1);
						}
					}else{
						if(rowCnt < 4){
							sheetObject.DataInsert(-1);
							if(rowCnt > 0 && (sheetObject.GetCellValue(rowCnt, "pod_cd") != formObj.pod_loc_cd.value)){
								sheetObject.SetCellValue(rowCnt + 1, "pol_cd",sheetObject.GetCellValue(rowCnt, "pod_cd"),0);
								sheetObject.SetCellValue(rowCnt + 1, "pol_yd_cd",sheetObject.GetCellValue(rowCnt, "pod_yd_cd"),0);
							}
						}
					} 					 					
					break;
				case "btn_Delete":
					sheetObject.RowDelete(sheetObject.GetSelectRow(),false);
					setVslPrePostCd();
					break;
				case "btn_Close":
					ComClosePopup(); 
					break;
				case "btn_Clear":
					sheetObject.RemoveAll();
					setParentToPopup(sheetObject, formObj);
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
     * registering IBCombo Object as comboObjects list
     * @param {IBMultiCombo} combo_obj    IBMultiCombo Object  
     **/
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
		    ComConfigSheet (sheetObjects[i] );
		    initSheet(sheetObjects[i],i+1);
		    ComEndConfigSheet(sheetObjects[i]);
		}
		initControl();
		// initializaion of IBMultiCombo 
		for(var k=0; k<comboObjects.length; k++){
		    initCombo(comboObjects[k]);
		}
		var sheetObj=sheetObjects[0];
		var formObj=document.form;
		var parentRefSheet;
		var sheetIdx = 0;
		
		if (formObj.callSheetIdx.value !="") sheetIdx=formObj.callSheetIdx.value;
		
		if (opener && opener.sheetObjects) parentRefSheet =opener.sheetObjects[sheetIdx]; 
		else if (parent && parent.sheetObjects) parentRefSheet =parent.sheetObjects[sheetIdx];
		
		var parentRow=parentRefSheet.LastRow()+1 ;
		if(parentRow > 1){
			 // in case of existing data in Main sheet, copy the data       
			for (var i=1 ; i < parentRow ; i++ ){
			     var iRow=sheetObj.DataInsert(-1);
			     var k = -1;
			     for(var j=0 ; j <= parentRefSheet.LastCol(); j++){
//			    	 if ( parentRefSheet.ColSaveName(j) != "" ) {   // condition of checking the current SaveName
			    	 k = sheetObj.SaveNameCol(parentRefSheet.ColSaveName(j));
//			    	 if ( parentRefSheet.ColSaveName(j) != "" ) {   // condition of checking the current SaveName
//			    		 for(var k=0 ; k <= sheetObj.LastCol(); k ++){
//			                 if ( sheetObj.ColSaveName(k) == parentRefSheet.ColSaveName(j)){
//			                	 sheetObj.SetCellValue( iRow, k,parentRefSheet.GetCellValue( i , j) ,0);
//			                }            			 
//			    		 }
//			    	 }
			    	 if(k>-1){ //If parent sheet has same name colmun, set value in this screen sheet
			    		 if(sheetObj.GetCellProperty(iRow, k, "Type")=="Combo"){ // Set combo code first temporarily to set value after this
			    			 sheetObj.CellComboItem(iRow, k, {ComboText:parentRefSheet.GetCellValue( i , j)+'|', ComboCode:parentRefSheet.GetCellValue( i , j)+'|'} );
			    		 }
			    		 sheetObj.SetCellValue( iRow, k, parentRefSheet.GetCellValue( i , j) ,0);
			    	 }
			     }
			}
			doActionIBSheet(sheetObj,document.form,IBSEARCH, "Y", "Y");
			//If there is data in Main sheet, copy data from main sheet
			/* 로직 왜 필요한지 이해 불가 - 주석처리
			for (var i=1 ; i < parentRow ; i++ ){
			     for(var j=0 ; j <= parentRefSheet.LastCol(); j++){
			    	 if ( parentRefSheet.ColSaveName(j) != "" ) {   // 현재 SaveName이 없는것들을 걸러내기위한조건
			    		 for(var k=0 ; k <= sheetObj.LastCol(); k ++){
			                 if ( sheetObj.ColSaveName(k) == parentRefSheet.ColSaveName(j)){
			                	 sheetObj.SetCellValue( i, k,parentRefSheet.GetCellValue( i , j) ,0);
			                }            			 
			    		 }
			    	 }
			     }
			}
			*/
		}else{
		   	// creating the sequence, when there is no data in Main sheet
			for(var idx=0; idx<5; idx++) sheetObj.DataInsert(-1);
			
			sheetObj.SetCellValue(1, "seq","First",0);
			sheetObj.SetCellValue(2, "seq","Second",0);
			sheetObj.SetCellValue(3, "seq","Third",0);
			sheetObj.SetCellValue(4, "seq","Forth",0);
			sheetObj.SetCellValue(5, "seq","Fifth",0);
			sheetObj.SetCellValue(1, "chk_flag","N",0);
			sheetObj.SetCellValue(2, "chk_flag","N",0);
			sheetObj.SetCellValue(3, "chk_flag","N",0);
			sheetObj.SetCellValue(4, "chk_flag","N",0);
			sheetObj.SetCellValue(5, "chk_flag","N",0);
			sheetObj.SetCellValue(1, "pol_cd",document.form.pol_loc_cd.value,0);
			sheetObj.SetCellValue(1, "pol_yd_cd",document.form.pol_nod_cd.value,0);
			sheetObj.SetCellValue(1, "pod_cd",document.form.pod_loc_cd.value,0);
			sheetObj.SetCellValue(1, "pod_yd_cd",document.form.pod_nod_cd.value,0);
			doActionIBSheet(sheetObj,document.form,IBSEARCH, "N", "Y");
		}
//		 // setting initial value
		setDetaultSetting(sheetObj,document.form);   	  	
		if(formObj.displayOnly.value == "Y"){
			ComBtnDisable("btn_Save");
			ComBtnDisable("btn_Clear");
		} else if(formObj.displayOnly.value == "1"){
		}
		combo1.SetDropHeight(250);
		combo1.SetColWidth(0, "20");
		combo1.SetColWidth(1, "100");
		combo2.SetDropHeight(250);
		combo2.SetColWidth(0, "20");
		combo2.SetColWidth(1, "100");
		var podCd=document.form.pod_loc_cd.value;
		if(podCd == "USLGB" || podCd == "USLGB" || podCd == "USTIW" || podCd == "USPDX" 
			 || podCd == "USSEA" || podCd == "CAVAN" || podCd == "CAPRR" || podCd == "USLAX"){
			combo1.SetEnable(false);
			combo2.SetEnable(false);
			formObj.us_west_coast.value=ComGetMsg('BKG02062');
		} else {
			combo1.SetEnable(true);
			combo2.SetEnable(true);
		}
    }
    /**
     * loading the event of HTML Control in page. <br>
     * initializing IBSheet Object by calling init Control function. <br>
     * 
     * @param {ibsheet}
     *            sheetObj IBSheet Object
     * @param {int}
     *            sheetNo sheetObjects 
     */
    function initControl() {
    	var formObj=document.form;
    	axon_event.addListenerForm('click', 'bkg0092_click',    	formObj); 
    }
    /**
     * setting initial combo
     * @param {IBMultiCombo} comboObj  comboObj
     */
    function initCombo(comboObj) {
    	comboObj.SetMultiSelect(0);
    	comboObj.SetColAlign(0, "left");
    	comboObj.SetColAlign(1, "left");
    	comboObj.SetMultiSeparator("|");
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
    			with(sheetObj){
    				var HeadTitle="|Seq.|POL|POL|POL|POD|POD|POD|VVD|Lane|POL ETD|POL ETD|POD ETA|POD ETA";
	
    				SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:0 } );
	
    				var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
    				var headers = [ { Text:HeadTitle, Align:"Center"} ];
    				InitHeaders(headers, info);
	
    				var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	        	                {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	                {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, AcceptKeys:"E|N", InputCaseSensitive:1},
	        	                {Type:"Text",      Hidden:0,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"pol_yd_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2, AcceptKeys:"E|N", InputCaseSensitive:1 },
	        	                {Type:"Combo",     Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"pol_clpt_ind_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	        	                {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, AcceptKeys:"E|N", InputCaseSensitive:1 },
	        	                {Type:"Text",      Hidden:0,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"pod_yd_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2, AcceptKeys:"E|N", InputCaseSensitive:1 },
	        	                {Type:"Combo",     Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"pod_clpt_ind_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	        	                {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bkg_vvd_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9, AcceptKeys:"E|N", InputCaseSensitive:1 },
	        	                {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"slan_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	                {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"etd_day",                KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	                {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"etd_time",               KeyField:0,   CalcLogic:"",   Format:"Hm",          PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	                {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"eta_day",                KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	                {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"eta_time",               KeyField:0,   CalcLogic:"",   Format:"Hm",          PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	                {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"pol_clpt_ind_seq_list" },
	        	                {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"pod_clpt_ind_seq_list" },
	        	                {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"vsl_pre_pst_cd" },
	        	                {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"voyage_time" },
	        	                {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"vsl_seq" },
	        	                {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"etd" },
	        	                {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"eta" } ];
	        	    
    				InitColumns(cols);
	
    				SetEditable(1);
    				SetCountPosition(0);
    				SetShowButtonImage(1);
    				SetSheetHeight(142);
    			}
    			break;
    	}
    }
    
    // handling of Sheet 
    function doActionIBSheet(sheetObj,formObj,sAction, dataYn, isOpen) {
    	gOpen = isOpen;
    	switch(sAction) {
	   
    		case IBSEARCH:      //search
    			formObj.f_cmd.value=SEARCH;
				var params = FormQueryString(formObj);
//				if(pod_clpt_ind_seq_temp != undefined && pod_clpt_ind_seq_temp != null && pod_clpt_ind_seq_temp != ''){
//					sheetObj.CellComboItem(1,"pod_clpt_ind_seq", {ComboText:pod_clpt_ind_seq_temp+'|', ComboCode:pod_clpt_ind_seq_temp+'|'} );
//					sheetObj.SetCellValue(1,"pod_clpt_ind_seq", pod_clpt_ind_seq_temp);
//				}
//				if(pol_clpt_ind_seq_temp != undefined && pol_clpt_ind_seq_temp != null && pol_clpt_ind_seq_temp != ''){
//					sheetObj.CellComboItem(1,"pol_clpt_ind_seq", {ComboText:pol_clpt_ind_seq_temp+'|', ComboCode:pol_clpt_ind_seq_temp+'|'} );
//					sheetObj.SetCellValue(1,"pol_clpt_ind_seq", pol_clpt_ind_seq_temp);
//				}
				
				params=params + "&dataYn=" +dataYn + "&" + ComGetSaveString(sheetObj);
				var sXml=sheetObj.GetSearchData("ESM_BKG_0092GS.do", params);
				var arrXml=sXml.split("|$$|");
				if(isOpen == "Y"){	
					for (var i=sheetObj.HeaderRows(); i < sheetObj.LastRow()+1 ; i++ ){
						if(sheetObj.GetCellValue(i, "bkg_vvd_cd") == formObj.bkgTrunkVvd.value){
							ComSetObjValue(formObj.trunkSeq, i);						
						}
					}
				} else {
					ComSetObjValue(formObj.trunkSeq, ComGetEtcData(arrXml[0],"trunk_seq"));
				}
				if(dataYn == "Y"){					
					if (arrXml.length > 0){
						sheetObj.LoadSearchData(arrXml[1],{Sync:1} );
						for (var i=sheetObj.HeaderRows(); i < sheetObj.LastRow()+1 ; i++ ){
							var cbo1 = sheetObj.GetCellValue(i,"pol_clpt_ind_seq_list");
							var cbo2 = sheetObj.GetCellValue(i,"pod_clpt_ind_seq_list");
							sheetObj.CellComboItem(i,"pol_clpt_ind_seq", {ComboText:cbo1, ComboCode:cbo1} );
							sheetObj.CellComboItem(i,"pod_clpt_ind_seq", {ComboText:cbo2, ComboCode:cbo2} );
						}
						//if combo is set ,sheet handling is finished
						openPop="false";
					}
					if (arrXml.length > 0){
						ComBkgXml2ComboItem(arrXml[0], comboObjects[0], "val", "desc");
						ComBkgXml2ComboItem(arrXml[0], comboObjects[1], "val", "desc");			
					}            	
					if(ComGetEtcData(arrXml[0],"TRANS_RESULT_KEY") == "S"){
						formObj.n1st_eta_day.value=ComGetEtcData(arrXml[0],"n1st_eta_day");
						formObj.n1st_eta_time.value=ComGetEtcData(arrXml[0],"n1st_eta_time");
						formObj.del_eta_day.value=ComGetEtcData(arrXml[0],"del_eta_day");
						formObj.del_eta_time.value=ComGetEtcData(arrXml[0],"del_eta_time");
					}	    				
				}else{
					if (arrXml.length > 0){
						ComBkgXml2ComboItem(arrXml[0], comboObjects[0], "val", "desc");
						ComBkgXml2ComboItem(arrXml[0], comboObjects[1], "val", "desc");     					
					}                    		
				}
				// 20091203  - handling process, if there is no lane after searching 

				if(isOpen == "Y"){	  
					var addFlag=false;
					for(var i=sheetObj.HeaderRows(); i < sheetObj.LastRow()+1 ; i++ ){
						if(sheetObj.GetCellValue(i, "slan_cd") == ""){
							if(sheetObj.GetCellValue(i, "bkg_vvd_cd") != "" && !CheckPseudoVvd(sheetObj.GetCellValue(i, "bkg_vvd_cd"))){
								searchLaneEtaEtd(sheetObj, formObj, i, "bkg_vvd_cd");
								if(sheetObj.GetCellValue(i, "slan_cd") == ""){
									ComShowCodeMessage('BKG00078', sheetObj.GetCellValue(i, "pol_cd"), sheetObj.GetCellValue(i, "pod_cd"), sheetObj.GetCellValue(i, "bkg_vvd_cd"));
									sheetObj.SetCellValue(i, "eta_day","",0);
									sheetObj.SetCellValue(i, "eta_time","",0);
									sheetObj.SetCellValue(i, "etd_day","",0);
									sheetObj.SetCellValue(i, "etd_time","",0);
									sheetObj.SetCellValue(i, "eta","",0);
									sheetObj.SetCellValue(i, "etd","",0);
								}
							}	               				
							addFlag=true;
						}
					}
					if(addFlag){
				   		for(var i=sheetObj.RowCount(); i < 4 ; i++ ){
				   			sheetObj.DataInsert(-1);
				   		}	               			
					}
				}
				comboObjects[0].InsertItem(0,"","");
				comboObjects[1].InsertItem(0,"","");
				break;
          case IBSAVE:      //Validation 
        	  	for (var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow() ; i++ ){
        	  		sheetObj.SetCellValue(i, "ibflag", "U", false);
        	  	}
        	  
        	  	formObj.f_cmd.value = MULTI;
				var params = FormQueryString(formObj);
				params = params + "&" + ComGetSaveString(sheetObj);
				sheetObj.DoSave("ESM_BKG_0092GS.do", FormQueryString(formObj), -1, false);	
				break;
    	}
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj){
    	var rowCnt=sheetObj.RowCount();    	 
    	// 20100118 if there is no data in Row, handling Validation after deleting 
    	for(var k=rowCnt ; k >  sheetObj.HeaderRows(); k--){
    		if(ComTrim(sheetObj.GetCellValue(k, "pod_cd")) == "" && ComTrim(sheetObj.GetCellValue(k, "pol_cd")) == "" && ComTrim(sheetObj.GetCellValue(k, "bkg_vvd_cd")) == ""){
    			sheetObj.RowDelete(k,false);
    		}else{
    			break;
    		}
    	}   
    	rowCnt=sheetObj.RowCount();
    	var isBkgVvd=true;
    	var lstPod = sheetObj.GetCellValue(sheetObj.LastRow(), "pod_cd");
    	var isTrunkVvd=false;	// ,when Row is checked, checking TrunkVvd 
		 
    	for ( var i=sheetObj.HeaderRows(); i < rowCnt ; i++ ){
    		if(ComIsNull(sheetObj.GetCellValue(i, "seq"))){
    			continue;
    		}
    		// 01. checking POL,POD is 5digit.
    		if(ComChkLen(sheetObj.GetCellValue(i, "pol_cd"),5) < 2 || ComChkLen(sheetObj.GetCellValue(i, "pod_cd"),5) < 2){
    			ComShowCodeMessage('BKG00137');
    			return false;
    		}
    		// 03. checking VVD is 9 digit.
    		if(sheetObj.GetCellValue(i, "bkg_vvd_cd").length > 0 && ComChkLen(sheetObj.GetCellValue(i, "bkg_vvd_cd"),9) < 2){
    			ComShowCodeMessage('BKG00144', i);
    			return false;
    		}			 
    		// 06. it is error when POL/POD is same at the same row.
    		if(sheetObj.GetCellValue(i, "pod_cd") == sheetObj.GetCellValue(i, "pol_cd")){
    			ComShowCodeMessage('BKG00141');
    			return false;				 
    		}			 
    		if(sheetObj.GetCellValue(i, "vsl_pre_pst_cd") == "T"){
    			isTrunkVvd=true;
    		}
    		// 08. skip below when last POD is same with BKG POD.
    		if(i+1 < rowCnt && ComIsNull(sheetObj.GetCellValue(i+1, "pod_cd")) && sheetObj.GetCellValue(i, "pod_cd") == formObj.pod_loc_cd.value){
    			for(j=rowCnt ; j >  i; j--){
    				sheetObj.RowDelete(j,false);
    			}
    			break;
    		}
    	}	 
    	
    	/* 해당ROW에 POD ETA 시간이 NEXT ROW에 POL ETD 시간보다 늦읏 수 없다. */
    	for (var i = sheetObj.HeaderRows(); i <= rowCnt; i++) {
			if(i > sheetObj.HeaderRows() && (sheetObj.GetCellValue(i, "etd_day") != "" && sheetObj.GetCellValue(i-1, "eta_day") != "")){		
				var etdDay = sheetObj.GetCellValue(i, "etd_day") + sheetObj.GetCellValue(i, "etd_time");
				var etaDay = sheetObj.GetCellValue(i-1, "eta_day") +  sheetObj.GetCellValue(i-1, "eta_time");
				if(ComChkPeriod(etaDay, etdDay) == 0){
					ComShowCodeMessage('BKG00867');
					return false;	
				}
			}
		}
    	
    	// 04. it is error when last POD is different with BKG_POD.
    	if(lstPod.length == 5){
    		if(lstPod != formObj.pod_loc_cd.value){
    			ComShowCodeMessage('BKG00146', formObj.pod_loc_cd.value); 
    			return false; 
    		} 
    	}
    	// 09. it is error when caFlg is not 'Y' and the number of Row is more than 5
    	if(formObj.ca_flg.value != 'Y' && sheetObj.RowCount()> 4){
    		ComShowCodeMessage('BKG00148');
    		return false;
    	}
    	//if the number of vvd is more then 5, check yard code and calling sequence
    	if (formObj.ca_flg.value == 'Y' ){
    		for (var i=1; i<=sheetObj.RowCount(); i++) {
    			if (!ComIsEmpty(sheetObj.GetCellValue(i,"bkg_vvd_cd"))) {
    				sheetObj.SetCellValue(i,"pod_clpt_ind_seq",sheetObj.GetCellText(i,"pod_clpt_ind_seq"),0);
        
    				if (ComIsEmpty(sheetObj.GetCellValue(i,"pol_yd_cd"))) {
    					ComShowCodeMessage("BKG00104","POL Yard Code (Row : "+i+")");
    					sheetObj.SelectCell(i,"pol_yd_cd");
    					return false;
    				}
    				if (ComIsEmpty(sheetObj.GetCellValue(i,"pol_clpt_ind_seq"))) {
	   					ComShowCodeMessage("BKG00104","POL Clpt Ind Seq (Row : "+i+")");
	   					sheetObj.SelectCell(i,"pol_clpt_ind_seq");
	   					return false;
    				}
					if (ComIsEmpty(sheetObj.GetCellValue(i,"pod_yd_cd"))) {
	   					ComShowCodeMessage("BKG00104","POD Yard Code (Row : "+i+")");
	   					sheetObj.SelectCell(i,"pod_yd_cd");
	   					return false;
					}
					if (ComIsEmpty(sheetObj.GetCellValue(i,"pod_clpt_ind_seq"))) {
						ComShowCodeMessage("BKG00104","POD Clpt Ind Seq (Row : "+i+")");
	   					sheetObj.SelectCell(i,"pod_clpt_ind_seq");
	   					return false;
					}
   				}
   			}
		}
        return true;
    }
	// setting the data when first loading is proceed.
	function setDetaultSetting(sheetObj, formObj){
		var parentObj;
		if (opener && opener.form) parentObj =opener.form; 
		else if (parent && parent.form) parentObj =parent.form;  

		formObj.por_loc_cd.value=parentObj.bkg_por_cd.value;
		formObj.por_nod_cd.value=parentObj.bkg_por_yd_cd.value;
		formObj.pol_loc_cd.value=parentObj.bkg_pol_cd.value;
		formObj.pol_nod_cd.value=parentObj.bkg_pol_yd_cd.value;
		formObj.pod_loc_cd.value=parentObj.bkg_pod_cd.value;
		formObj.pod_nod_cd.value=parentObj.bkg_pod_yd_cd.value;
		formObj.del_loc_cd.value=parentObj.bkg_del_cd.value;
		formObj.del_nod_cd.value=parentObj.bkg_del_yd_cd.value;
		var orgTrnsModCd=parentObj.org_trns_mod_cd.value;
		var destTrnsModCd=parentObj.dest_trns_mod_cd.value;
		comboObjects[0].SetSelectCode(orgTrnsModCd,false);
		comboObjects[1].SetSelectCode(destTrnsModCd,false);
	}
	// handling when New button is clicked.
	function clearOceanRoute(sheetObj, formObj){    
  		formObj.n1st_eta_day.value="";
  		formObj.n1st_eta_time.value="";
  		formObj.del_eta_day.value="";
  		formObj.del_eta_time.value="";    
  		sheetObj.RemoveAll();
  		for(idx=0; idx<5; idx++) sheetObj.DataInsert(-1);
  		sheetObj.SetCellValue(1, "seq","First",0);
  		sheetObj.SetCellValue(2, "seq","Second",0);
  		sheetObj.SetCellValue(3, "seq","Third",0);
  		sheetObj.SetCellValue(4, "seq","Forth",0);
  		sheetObj.SetCellValue(5, "seq","Fifth",0);
  		sheetObj.SetCellValue(1, "pol_cd",formObj.pol_loc_cd.value,0);
  		sheetObj.SetCellValue(1, "pol_yd_cd",formObj.pol_nod_cd.value,0);
  		sheetObj.SetCellValue(1, "pod_cd",formObj.pod_loc_cd.value,0);
  		sheetObj.SetCellValue(1, "pod_yd_cd",formObj.pod_nod_cd.value,0);
	} 	
	// getting Popup contents into Main
	function setParentToPopup(sheetObj, formObj){
		setVslPrePostCd();
		var parentObj;
		if (opener && opener.form) parentObj =opener.form; 
		else if (parent && parent.form) parentObj =parent.form;  

		// 1. Sheet
		var parentRefSheet;
	 	var sheetIdx = 0;
	 	if (formObj.callSheetIdx.value !="") sheetIdx = formObj.callSheetIdx.value;
	 	if (opener && opener.sheetObjects) parentRefSheet =opener.sheetObjects[sheetIdx]; 
	 	else if (parent && parent.sheetObjects) parentRefSheet =parent.sheetObjects[sheetIdx];    	
	 	parentRefSheet.RemoveAll();
	 	for(var i = 1 ; i <= sheetObj.LastRow() ; i++ )
	 	{
	 		var iRow=parentRefSheet.DataInsert(-1);
	 		for(var j=0 ; j <= sheetObj.LastCol(); j++)
	 		{
	 			if ( sheetObj.ColSaveName(j) != "" ) 
	 			{   //   condition of checking SaveName
	 				for(var k=0 ; k <= parentRefSheet.LastCol(); k ++)
	 				{
	 					if ( parentRefSheet.ColSaveName(k) == sheetObj.ColSaveName(j))
	 					{
	 						if(parentRefSheet.ColSaveName(k)=="pol_clpt_ind_seq"||parentRefSheet.ColSaveName(k)=="pod_clpt_ind_seq")
	 						{
	 							parentRefSheet.SetCellValue( iRow, parentRefSheet.ColSaveName(k),sheetObj.GetCellText( i , sheetObj.ColSaveName(j)) );
	 						} else {
	 							parentRefSheet.SetCellValue( iRow, parentRefSheet.ColSaveName(k),sheetObj.GetCellValue( i , sheetObj.ColSaveName(j)) );
	 						}
	 					}                        
	 				}
	 			}
	 		}
	 	}		 
		// 2. setting TransMode.
		parentObj.org_trns_mod_cd.value=comboObjects[0].GetSelectCode();
		parentObj.dest_trns_mod_cd.value=comboObjects[1].GetSelectCode();
		
		var calllFunc=formObj.calllFunc.value;
		if(calllFunc != ''){
			if (ComFuncCheck("opener." + calllFunc)) ComFunc();
			else if (ComFuncCheck("parent." + calllFunc)) ComFunc();
		}
		ComClosePopup(); 
	}
	// resetting the VslPrePostCd when searching is finished.
	function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
		var formObj = document.form;
		if(Msg == "") setVslPrePostCd(); 			

		for (var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow() ; i++ ){
			var cbo1 = sheetObj.GetCellValue(i,"pol_clpt_ind_seq_list");
			var cbo2 = sheetObj.GetCellValue(i,"pod_clpt_ind_seq_list");
			sheetObj.CellComboItem(i,"pol_clpt_ind_seq", {ComboText:cbo1, ComboCode:cbo1} );
			sheetObj.CellComboItem(i,"pod_clpt_ind_seq", {ComboText:cbo2, ComboCode:cbo2} );
		}

		openPop="false";
	}
	// esetting the VslPrePostCd when searching is finished.
	function sheet1_OnSaveEnd(sheetObj, Code, Msg, StCode, StMsg) { 
		if(Msg == ""){
			setParentToPopup(sheetObj, document.form);
		}
	}
	// searching LANE/ETD/ETA, after editing POL,POD,VVD 
 	function sheet1_OnChange(sheetObj, Row, Col){
		//searching saved data first, when pop-up opened first.
		if(openPop == "true"){
			return;
		}
		
		var colName=sheetObj.ColSaveName(Col);
		var formObj=document.form;
		var flg=false;
		if(colName == "pol_cd" || colName == "pol_yd_cd" 
			|| colName == "pod_cd" || colName == "pod_yd_cd"  
			|| colName == "bkg_vvd_cd"){
	 		if(colName == "pod_cd"){
	 			sheetObj.SetCellValue(Row, "pod_yd_cd","",0);
	 			sheetObj.CellComboItem(Row,"pod_clpt_ind_seq", {ComboText:"", ComboCode:""} );
	 			sheetObj.SetCellValue(Row, "pod_clpt_ind_seq"," ",0);
	 			if(sheetObj.GetCellValue(Row, Col) != formObj.pod_loc_cd.value){
	 				// if edited Row is last row, add Row 
	 				if(sheetObj.RowCount()== Row){
	 					addRow=sheetObj.DataInsert(-1);
	 					sheetObj.SetCellValue(addRow, "pol_cd",sheetObj.GetCellValue(Row, Col),0);
	 				}else{
	 					sheetObj.SetCellValue(Row+1, "pol_cd",sheetObj.GetCellValue(Row, Col),0);
	 				}
	 				//sheetObj.CellValue2(Row+1, "pol_cd") = sheetObj.CellValue(Row, Col);    	 				
	 			}    	 			
	 		}else if(colName == "bkg_vvd_cd"){
	 			doActionIBSheet(sheetObj,document.form,IBSEARCH, "Y", "Y");
//	 			if(sheetObj.GetCellValue(Row, Col) == formObj.bkgTrunkVvd.value){
//	 				for ( i=1 ; i <= sheetObj.LastRow() ; i++ ){
//	 					sheetObj.SetCellValue(i, "vsl_pre_pst_cd" ,"",0);
//	 				}
//	 				sheetObj.SetCellValue(Row, "vsl_pre_pst_cd" ,"T",0);
//	 				setPrePstSeq(sheetObj);
//	 			}
	 		}else if(colName == "pol_cd"){
	 			sheetObj.SetCellValue(Row, "pol_yd_cd","",0);
	 			sheetObj.CellComboItem(Row,"pol_clpt_ind_seq", {ComboText:"", ComboCode:""} );
	 			sheetObj.SetCellValue(Row, "pol_clpt_ind_seq"," ",0);
	 		}else if(colName == "pol_yd_cd"){
	 			if(sheetObj.CellSearchValue(Row, Col) != sheetObj.GetCellValue(Row,Col)){
	 				sheetObj.SetCellValue(Row,"pol_clpt_ind_seq","",0);
	 			}
	 		}else if(colName == "pod_yd_cd"){
	 			if(sheetObj.CellSearchValue(Row, Col) != sheetObj.GetCellValue(Row,Col)){
	 				sheetObj.SetCellValue(Row,"pod_clpt_ind_seq","",0);
	 			}    	 			
	 		}   	 		
//	 		if(	sheetObj.GetCellValue(Row, "pol_cd").length > 0 && sheetObj.GetCellValue(Row, "pod_cd").length > 0 && sheetObj.GetCellValue(Row, "bkg_vvd_cd").length > 0){
//	 			searchLaneEtaEtd(sheetObj, formObj, Row, colName);
//	 			if(Row<=sheetObj.LastRow()){
//	 				if(sheetObj.GetCellValue(Row, "pod_cd")!=formObj.pod_loc_cd.value){
//	 					sheetObj.SetCellValue(Row + 1, "pol_cd",sheetObj.GetCellValue(Row, "pod_cd"),0);
//	 					sheetObj.SetCellValue(Row + 1, "pol_yd_cd",sheetObj.GetCellValue(Row, "pod_yd_cd"),0);
//	 					sheetObj.SetCellValue(Row + 1, "pol_clpt_ind_seq","",0);
//	 					searchLaneEtaEtd(sheetObj, formObj, Row+1, "pol_cd");
//	 				}
//	 			}
//	 		}
	 		if(	sheetObj.GetCellValue(Row, "pol_cd").length < 1 || sheetObj.GetCellValue(Row, "pod_cd").length< 1 || sheetObj.GetCellValue(Row, "bkg_vvd_cd").length < 1){
	 			sheetObj.SetCellValue(Row, "slan_cd","",0);
	 			sheetObj.SetCellValue(Row, "etd_day","",0);
	 			sheetObj.SetCellValue(Row, "etd_time","",0);
	 			sheetObj.SetCellValue(Row, "eta_day","",0);
	 			sheetObj.SetCellValue(Row, "eta_time","",0);
	 		}
		}  
		
	} 	 	
	function sheet1_OnComboChange(sheetObj, Row, Col, Text) {
		var formObj=document.form;
		var colName=sheetObj.ColSaveName(Col);
		if(Text==""){
			return;
		}
		if(colName == "pol_clpt_ind_seq"){
			sheetObj.SetCellValue(Row, "pol_yd_cd","",0);
		} else if(colName == "pod_clpt_ind_seq"){
			sheetObj.SetCellValue(Row, "pod_yd_cd","",0);
		}
		searchLaneEtaEtd(sheetObj, formObj, Row, colName);
		
		if(Row<=sheetObj.LastRow()){
			if(sheetObj.GetCellValue(Row, "pod_cd")!=formObj.pod_loc_cd.value){
				var nextRow = (Row + 1);
				sheetObj.SetCellValue(nextRow, "pol_cd",sheetObj.GetCellValue(Row, "pod_cd"),0);
				sheetObj.SetCellValue(nextRow, "pol_yd_cd",sheetObj.GetCellValue(Row, "pod_yd_cd"),0);
				sheetObj.SetCellValue(nextRow, "pol_clpt_ind_seq","",0);
	 			searchLaneEtaEtd(sheetObj, formObj, nextRow, "pol_cd");
			}
		}
	}
	function searchLaneEtaEtd(sheetObj, formObj, Row, colNm){
		if(	sheetObj.GetCellValue(Row, "pol_cd").length > 0 && sheetObj.GetCellValue(Row, "pod_cd").length > 0 && sheetObj.GetCellValue(Row, "bkg_vvd_cd").length > 0){
	   		formObj.f_cmd.value=SEARCH01;
	   		var params=FormQueryString(formObj);
      		params=params + "&edit_row=" + Row + "&" + ComGetSaveString(sheetObj);
      		var sXml=sheetObj.GetSearchData("ESM_BKG_0092GS.do", params);
      		
	   		if (ComIsNull(ComGetEtcData(sXml,"pol_clpt_ind_seq_list")) || ComIsNull(ComGetEtcData(sXml,"pod_clpt_ind_seq_list"))) {
		   		sheetObj.SetCellValue(Row, "eta_day","",0);
		   		sheetObj.SetCellValue(Row, "eta_time","",0);
		   		sheetObj.SetCellValue(Row, "etd_day","",0);
		   		sheetObj.SetCellValue(Row, "etd_time","",0);
		   		sheetObj.SetCellValue(Row, "eta","",0);
		   		sheetObj.SetCellValue(Row, "etd","",0);
	   		} else {
		   		ComSetObjValue(formObj.trunkSeq, ComGetEtcData(sXml,"trunk_seq"));
		   		sheetObj.SetCellValue(Row, "slan_cd",(ComIsNull(ComGetEtcData(sXml,"slan_cd")))	?"":ComGetEtcData(sXml,"slan_cd"),0);
		   		
		   		var pol_clpt_ind_seq_list = ComGetEtcData(sXml,"pol_clpt_ind_seq_list");
		   		var pol_info = {"ComboCode":pol_clpt_ind_seq_list,"ComboText":pol_clpt_ind_seq_list};
		   		var pol_clpt_ind_seq = ComGetEtcData(sXml,"pol_clpt_ind_seq");
		   		
		   		if(ComGetObjValue(formObj.st_pol_clpt_ind_seq) != ''){
		   			pol_clpt_ind_seq = ComGetObjValue(formObj.st_pol_clpt_ind_seq);
		   			ComSetObjValue(formObj.st_pol_clpt_ind_seq, '');
		   		}
		   		
		   		var pol_yd_cd = ComGetEtcData(sXml,"pol_yd_cd");
		   		sheetObj.SetCellValue(Row, "pol_yd_cd", pol_yd_cd);
		   		sheetObj.CellComboItem(Row, "pol_clpt_ind_seq", pol_info);
		   		sheetObj.SetCellValue(Row, 4, pol_clpt_ind_seq);
		   		
		   		var pod_clpt_ind_seq_list = ComGetEtcData(sXml,"pod_clpt_ind_seq_list");	
				var pod_info = {"ComboCode":pod_clpt_ind_seq_list,"ComboText":pod_clpt_ind_seq_list};
		   		sheetObj.CellComboItem(Row, "pod_clpt_ind_seq", pod_info);
		   		
		   		var pod_clpt_ind_seq = ComGetEtcData(sXml,"pod_clpt_ind_seq");
		   		if(ComGetObjValue(formObj.st_pod_clpt_ind_seq) != ''){
		   			pod_clpt_ind_seq = ComGetObjValue(formObj.st_pod_clpt_ind_seq);
		   			ComSetObjValue(formObj.st_pod_clpt_ind_seq, '');
		   		}
		   		
		   		sheetObj.SetCellValue(Row, 7, pod_clpt_ind_seq);
		   		sheetObj.SetCellValue(Row, "pod_yd_cd",(ComIsNull(ComGetEtcData(sXml,"pod_yd_cd")))	?"":ComGetEtcData(sXml,"pod_yd_cd"),0);
		   		sheetObj.SetCellValue(Row, "eta_day",(ComIsNull(ComGetEtcData(sXml,"eta_day")))	?"":ComGetEtcData(sXml,"eta_day"),0);
		   		sheetObj.SetCellValue(Row, "eta_time",(ComIsNull(ComGetEtcData(sXml,"eta_time")))	?"":ComGetEtcData(sXml,"eta_time"),0);
		   		sheetObj.SetCellValue(Row, "etd_day",(ComIsNull(ComGetEtcData(sXml,"etd_day")))	?"":ComGetEtcData(sXml,"etd_day"),0);
		   		sheetObj.SetCellValue(Row, "etd_time",(ComIsNull(ComGetEtcData(sXml,"etd_time")))	?"":ComGetEtcData(sXml,"etd_time"),0);
		   		sheetObj.SetCellValue(Row, "eta",(ComIsNull(ComGetEtcData(sXml,"eta")))		?"":ComGetEtcData(sXml,"eta"),0);
		   		sheetObj.SetCellValue(Row, "etd",(ComIsNull(ComGetEtcData(sXml,"etd")))		?"":ComGetEtcData(sXml,"etd"),0);
		   		setVslPrePostCd();
	   		}
		}
	}
	// setting Trunk Code 
	function setVslPrePostCd(){
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		var zint=ComParseInt(ComGetObjValue(formObj.trunkSeq));
		sheetObj.SetCellValue(zint, "vsl_pre_pst_cd","T",0);
		for ( j=1 ; j <= sheetObj.LastRow() ; j++ ){
			if(j < ComGetObjValue(formObj.trunkSeq)){
 				sheetObj.SetCellValue(j, "vsl_pre_pst_cd","S",0);
			} else if(j > ComGetObjValue(formObj.trunkSeq)){
 				sheetObj.SetCellValue(j, "vsl_pre_pst_cd","U",0);
			}
		}
		setPrePstSeq(sheetObj);	
	}
	// sorting Seq 
	function setPrePstSeq(sheetObj){
      // setting Seq 
      	var isPre=true;
      	var prePostIdx=1;
      	for ( j=1 ; j <= sheetObj.LastRow() ; j++ ){        	   
      		if(sheetObj.GetCellValue(j, "pol_cd").length==0 &&sheetObj.GetCellValue(j, "pod_cd").length==0 &&sheetObj.GetCellValue(j, "bkg_vvd_cd").length==0){
      			continue;
      		}
      		if(sheetObj.GetCellValue(j, "vsl_pre_pst_cd") != "T"){
     			if(isPre){
     				sheetObj.SetCellValue(j, "seq","Pre" + prePostIdx,0);
     				sheetObj.SetCellValue(j, "vsl_pre_pst_cd","S",0);
     				sheetObj.SetCellValue(j, "vsl_seq",prePostIdx,0);
     				prePostIdx++;
     			}else{
     				sheetObj.SetCellValue(j, "seq","Post" + prePostIdx,0);
     				sheetObj.SetCellValue(j, "vsl_pre_pst_cd","U",0);
     				sheetObj.SetCellValue(j, "vsl_seq",prePostIdx,0);
     				prePostIdx++;	        				 
     			}
     		}else{
     			sheetObj.SetCellValue(j, "seq","Trunk",0);
     			sheetObj.SetCellValue(j, "vsl_seq","0",0);
     			isPre=false;
     			prePostIdx=1;
     		}
      	}	  
	}	
	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
		if(sheetObj.ColSaveName(NewCol) == "pod_yd_cd"){
			if(NewRow == sheetObj.LastRow()){
				if(sheetObj.GetCellValue(NewRow, "pod_cd") == ""){
					sheetObj.SelectCell(NewRow, "pod_cd", false);
      			}	        				
			}
		}
	}
	// calling VVD Pop up 
	function sheet1_OnPopupClick( sheetObj, Row, Col ){
		comBkgCallPop0019(	"setBkg0019Popup",
				sheetObj.GetCellValue(Row, "bkg_vvd_cd"),
				sheetObj.GetCellValue(Row, "pol_cd"),
				sheetObj.GetCellValue(Row, "pod_cd"), false);
	}
	function bkg0092_click(){
		var formObj=document.form;
	   	var srcName=ComGetEvent("name");
	   	if(srcName == "mnl_tvvd_flg"){
	   		if(ComIsNull(formObj.bkgTrunkVvd.value)){
	   			ComShowCodeMessage("BKG00058", formObj.bkgTrunkVvd.value);
	   			return false;
	   		}
	   		var foundTvvd="false";
	   		for (var i=sheetObjects[0].HeaderRows(); i <= sheetObjects[0].LastRow() ; i++ ){
	   			if(sheetObjects[0].GetCellValue(i, "bkg_vvd_cd") == formObj.bkgTrunkVvd.value){
					foundTvvd="true";
					ComSetObjValue(formObj.trunkSeq, i);
					setVslPrePostCd();
				}
			}
	   		if("false" == foundTvvd){
	   			ComShowCodeMessage("BKG00022", formObj.bkgTrunkVvd.value);
	   			return false;
	   		}
	   	}
	}
	// Return value after calling VVD PopUp
	function setBkg0019Popup(arrVal){
		var formObj = document.form;
		sheetObjects[0].SetCellValue( sheetObjects[0].GetSelectRow(), "pol_cd",arrVal[0][4] );
		sheetObjects[0].SetCellValue( sheetObjects[0].GetSelectRow(), "pol_clpt_ind_seq", arrVal[0][22] );
		ComSetObjValue(formObj.st_pol_clpt_ind_seq, arrVal[0][22]);
		
		if(arrVal[0][5] != null && arrVal[0][5].length > 5){
			sheetObjects[0].SetCellValue( sheetObjects[0].GetSelectRow(), "pol_yd_cd",arrVal[0][5].substring(5) );
		}
		sheetObjects[0].SetCellValue( sheetObjects[0].GetSelectRow(), "pod_cd",arrVal[0][12] );
		sheetObjects[0].SetCellValue( sheetObjects[0].GetSelectRow(), "pod_clpt_ind_seq",arrVal[0][24] );
		ComSetObjValue(formObj.st_pod_clpt_ind_seq, arrVal[0][24]);
		
		if(arrVal[0][13] != null && arrVal[0][13].length > 5){
			sheetObjects[0].SetCellValue( sheetObjects[0].GetSelectRow(), "pod_yd_cd",arrVal[0][13].substring(5) );
		}    	
		sheetObjects[0].SetCellValue( sheetObjects[0].GetSelectRow(), "bkg_vvd_cd",arrVal[0][3] );
		searchLaneEtaEtd(sheetObjects[0], document.form, sheetObjects[0].GetSelectRow(), "bkg_vvd_cd");
		
		
	}
	
	function setPortSkpFlg(formObj){
		var parentObj;
		if (opener && opener.form) parentObj =opener.form; 
		else if (parent && parent.form) parentObj =parent.form;  
		
		if(parentObj.port_skp_flg != null) {
			if(formObj.port_skp_flg.checked){
				parentObj.port_skp_flg.value=formObj.port_skp_flg.value;
			}else{
				parentObj.port_skp_flg.value='';
			}
		}
	}
	/* End of developer's work */
