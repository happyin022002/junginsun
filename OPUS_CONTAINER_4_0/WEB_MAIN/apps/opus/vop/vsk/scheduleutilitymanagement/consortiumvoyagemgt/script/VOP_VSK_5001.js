/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_VSK_5001.js
*@FileTitle  : Consortium Voyage Update
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/26
=========================================================*/


	/**
	 * @extends 
	 * @class vop_vsk_5001 : business script for vop_vsk_5001
	 */
	// public variable	
	var sheetObjects=new Array();	
	var sheetCnt=0;	
	var comboObjects=new Array();
    var comboCnt=0;

	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick(){
		var sheetObj = sheetObjects[0];
		var formObj  = document.form;
		try {
			var srcName=ComGetEvent("name");
			if (!ComIsBtnEnable(srcName)) return;  
			if(ComGetEvent().className.indexOf('_1') > 0){
				return;
			}
			switch(srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObj, formObj, IBSEARCH);
					break;
				case "btn_new":
					doActionIBSheet(sheetObj, formObj, IBCLEAR);
					break;
				case "btn_save":
					doActionIBSheet(sheetObj, formObj, IBSAVE);
					break;
				case "btn_slan_cd":
					doActionIBSheet(sheetObj, formObj, COMMAND01);
					break;
				case "btn_vvd":
					doActionIBSheet(sheetObj, formObj, COMMAND02);
					break;
				case "btn_etb":
					doActionIBSheet(sheetObj,formObj, COMMAND03);
					break;
				case "btn_apply":					
					fn_setVoyage(sheetObj);
					break;
			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowCodeMessage('VSK00011');
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
	 * registering IBCombo Object as list
	 * @param combo_obj
	 * @return
	 */
	function setComboObject(combo_obj){
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
		
		for(var k=0;k<comboObjects.length;k++){
            initCombo(comboObjects[k],k+1);
        }
		
		initControl();
		
		ComBtnDisable("btn_apply");
		formObj.voyage.disabled = true;
		formObj.fm_dt.value = ComGetNowInfo(); 
		formObj.to_dt.value = ComGetDateAdd(null, "M", 1);
		
		formObj.vsl_slan_cd.focus();
	}
	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		var prefix=sheetID + "_";
		switch(sheetNo) {
			case 1:      // sheet1 init
			    with(sheetObj){
//				      
				      var HeadTitle1="|Lane|VVD|VVD|VVD|Port Code|clpt_ind_seq|vt|IND.|first_turn_port_clpt_seq|real_clpt_seq|vir_port_clpt_seq||||||||ETA|ETB|ETD|Consortium Voyage|Consortium Voyage|VoyageFlg|Updated Info.|Updated Info.";
				      var HeadTitle2="|Lane|VSL|VOY|DIR|Port Code|clpt_ind_seq|vt|IND.|first_turn_port_clpt_seq|real_clpt_seq|vir_port_clpt_seq||||||||ETA|ETB|ETD|Arr Ext Voy Ref|Dep Ext Voy Ref|VoyageFlg|User ID|Date(S)";
		
				      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
				      var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
				      var headers = [ { Text:HeadTitle1, Align:"Center"},
				                      { Text:HeadTitle2, Align:"Center"} 
				                    ];
				      InitHeaders(headers, info);
		
				      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
						           {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_slan_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						           {Type:"Text",      Hidden:0, Width:65,  	Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						           {Type:"Text",      Hidden:0, Width:65,  	Align:"Center",  ColMerge:1,   SaveName:prefix+"skd_voy_no",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						           {Type:"Text",      Hidden:0, Width:65,  	Align:"Center",  ColMerge:1,   SaveName:prefix+"skd_dir_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						           {Type:"Text",      Hidden:0, Width:100, 	Align:"Center",  ColMerge:1,   SaveName:prefix+"vps_port_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						           {Type:"Text",      Hidden:1, Width:100, 	Align:"Center",  ColMerge:1,   SaveName:prefix+"clpt_ind_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						           {Type:"Text",      Hidden:1, Width:100, 	Align:"Center",  ColMerge:1,   SaveName:prefix+"vt_add_call_flg",KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						           {Type:"Text",      Hidden:1, Width:100, 	Align:"Center",  ColMerge:1,   SaveName:prefix+"real_turn_port_ind_cd",    KeyField:0,   CalcLogic:"",   Format:"",  PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						           
						           {Type:"Text",      Hidden:1, Width:100, 	Align:"Center",  ColMerge:1,   SaveName:prefix+"first_turn_port_clpt_seq",    KeyField:0,   CalcLogic:"",   Format:"",          PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						           {Type:"Text",      Hidden:1, Width:100, 	Align:"Center",  ColMerge:1,   SaveName:prefix+"real_clpt_seq",    KeyField:0,   CalcLogic:"",   Format:"",          PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						           
						           {Type:"Text",      Hidden:1, Width:100, 	Align:"Center",  ColMerge:1,   SaveName:prefix+"vir_port_clpt_seq",    KeyField:0,   CalcLogic:"",   Format:"",          PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						           
						           {Type:"Text",      Hidden:1, Width:100, 	Align:"Center",  ColMerge:1,   SaveName:prefix+"turn_port_ind_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						           {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"pf_eta_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						           {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"pf_etb_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						           {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:0,   SaveName:prefix+"pf_etd_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						           {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:0,   SaveName:prefix+"init_eta_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						           {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:0,   SaveName:prefix+"init_etb_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						           {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"init_etd_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						           {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"vps_eta_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						           {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"vps_etb_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						           {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"vps_etd_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						           {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"ib_cssm_voy_no", keyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, InputCaseSensitive:1, EditLen:10},
						           {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"ob_cssm_voy_no", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, InputCaseSensitive:1, EditLen:10 },
						           {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"voy_all_set_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						           {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_usr_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						           {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_dt",         KeyField:0,   CalcLogic:"",   Format:"YmdHms",	     PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, 
						           {Type:"Text",      Hidden:1, Width:100, 	Align:"Center",  ColMerge:1,   SaveName:prefix+"turn_port_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						           {Type:"Text",      Hidden:1, Width:100, 	Align:"Center",  ColMerge:1,   SaveName:prefix+"turn_skd_voy_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						           {Type:"Text",      Hidden:1, Width:100, 	Align:"Center",  ColMerge:1,   SaveName:prefix+"turn_skd_dir_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						           {Type:"Text",      Hidden:1, Width:100, 	Align:"Center",  ColMerge:1,   SaveName:prefix+"clpt_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						           {Type:"Text",      Hidden:1, Width:100, 	Align:"Center",  ColMerge:1,   SaveName:prefix+"cssm_voy_init_cre_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						                    
						           ];
				      InitColumns(cols);		
				      SetEditable(1);	
				      resizeSheet();
				      
				      
			}
			   break;
		}
	}
	/**
   	 * setting combo initial values and header 
   	 * param : comboObj, comboNo
   	 * adding case as numbers of counting combos 
   	 */ 
   	function initCombo(comboObj, comboNo) {
   	    var formObj=document.form;
   	    switch(comboObj.options.id) {
//	    	case "cv_cbm1":
//   	    		with (comboObj) {
//   					SetMultiSelect(0);
//   	   				SetUseAutoComplete(1);
//   					SetColAlign(0, "left");
//   					SetColWidth(0, "100");
//   	   				SetBackColor("#FFFFFF");
//   	   				SetFontColor("#000000");
//   	   				SetColBackColor(0,"#FFFFFF");
//   	   				SetColFontColor(0,"#000000");
//   					SetDropHeight(160);
//   					
//   					comboObj.InsertItem(0, "ALL", "ALL");
//   		   	     	comboObj.InsertItem(1, "Arr ExtVoyRef", "I/B");
//   		   	     	comboObj.InsertItem(2, "Dep ExtVoyRef", "O/B");
//   		   	     	
//   		   	     	comboObj.SetSelectIndex(0, true);
//   		    	}
//   	    		break;
// 2015-06-25, 변경 로직 적용 (하나라도 변경 된 것에 대한 display구분 처리)
	    	case "cv_cbm2":
   	    		with (comboObj) {
   					SetMultiSelect(0);
   	   				SetUseAutoComplete(1);
   					SetColAlign(0, "left");
   					SetColWidth(0, "120");
   	   				SetBackColor("#FFFFFF");
   	   				SetFontColor("#000000");
   	   				SetColBackColor(0,"#FFFFFF");
   	   				SetColFontColor(0,"#000000");
   					SetDropHeight(160);
   					
   					comboObj.InsertItem(0, "ALL" , "0");
   					comboObj.InsertItem(1, "Initial" , "1");
   		   	     	comboObj.InsertItem(2, "Updated", "2");
   		   	     	
   		   	     	comboObj.SetSelectIndex(0, true);
   		    	}
   	    		break;
   	     }
   	    
   	     
   	}
	// handling sheet process
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		var prefix=sheetObj.id + "_";
		switch(sAction) {
			case IBSEARCH:      //Retrieve
				if(validateForm(sheetObj,formObj,sAction)){
					if ( sheetObj.id == "sheet1"){
						doActionSearch(sheetObj, formObj, SEARCH);
					}
				}
				break;
			
			case IBSAVE:        //Save
				//IsDataModified : 데이터 행의 트랜잭션 여부를 확인한다.
				//트랜잭션 상태가 "조회" 이외의 데이터가 한건이라도 있으면 1을 반환하고, 없으면 0을 반환한다.
				if (!sheetObj.IsDataModified) return;
				
				var sParam=ComGetSaveString(sheetObj, false);
				if (sParam == ""){
					ComShowCodeMessage('VSK00012');
					return;
				} else {
					formObj.f_cmd.value = MULTI;
					sParam=sParam + "&" + FormQueryString(formObj);
				}
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				var sXml=sheetObj.GetSaveData("VOP_VSK_5001GS.do", sParam);
				ComOpenWait(false);
				sheetObj.LoadSaveData(sXml);
				var nodeText=ComGetSelectSingleNode(sXml, "TR-ALL");
				if(nodeText == "OK"){
					doActionSearch(sheetObj, formObj, SEARCH);
				}
				
				break;
			case IBCLEAR:      			// New
				clearData(sheetObj, formObj);
				break;
			case COMMAND01:      // Lane Pop-up				
				sUrl="/opuscntr/VOP_VSK_0202.do?vsl_slan_cd=" + formObj.vsl_slan_cd.value;
				ComOpenPopup(sUrl, 500, 470, "getLaneCodeData", "0,0", true);
				break;
			case COMMAND02:        	// VVD Search
				var vslCd=document.form.vsl_cd.value;
            	var sUrl="";
            	if(vslCd == ""){
            		sUrl="/opuscntr/VOP_VSK_0219.do";
            		ComOpenPopup(sUrl, 460, 500, "getVslCdData", "0,0", true);
            	}else{
            		sUrl="/opuscntr/VOP_VSK_0230.do?ctrl_cd=NORL&vsl_cd="+vslCd;
            		ComOpenPopup(sUrl, 440, 420, "getVvdData", "0,0", true);
            	}
            	break;
			case COMMAND03:        //btn_period
				var cal=new ComCalendarFromTo();
				cal.select(formObj.fm_dt, formObj.to_dt, 'yyyy-MM-dd');
				break;
			case COMMAND04:
				if(formObj.vsl_slan_cd.value == ""){
	      			  return;
	      		}
	      		sheetObj.SetWaitImageVisible(0);
	      		ComOpenWait(true);
	      		formObj.f_cmd.value=SEARCH03;
	      		var sXml=sheetObj.GetSearchData("VSK_COMGS.do" , FormQueryString(formObj));
	      		var checkLane=ComGetEtcData(sXml, "checkLane");
    			if(checkLane == undefined){
    				sheetObj.LoadSearchData(sXml,{Sync:1} );
    				formObj.vsl_slan_cd.value="";	
    				formObj.vsl_slan_cd.focus();
    			}else{
    				var vslSlanNm=ComGetEtcData(sXml, "checkLane").split("|");
    				if(vslSlanNm == ""){
    					ComShowCodeMessage('VSK00021', formObj.vsl_slan_cd.value);
    					formObj.vsl_slan_cd.value="";	
    				}
    			}
    			ComOpenWait(false);
				break;
		   
			case SEARCH16:// Vessel Code 조회
				formObj.f_cmd.value=COMMAND16;
				
				ComOpenWait(true);
				var sParam=FormQueryString(formObj);
	 			var sXml=sheetObj.GetSearchData("VSK_GLOGS.do", sParam);
				ComOpenWait(false);
				var vsl_eng_nm=ComGetEtcData(sXml, "vsl_eng_nm");
		    	if(!vsl_eng_nm){ // undefined
		    		ComShowCodeMessage('VSK00021', formObj.vsl_cd.value);					
					formObj.vsl_cd.value="";
					formObj.vsl_cd.focus();
					return false;
		    	}
		    	dateEnabled();
				break;
				
		}
	}
	
	function dateEnabled() {
		var formObj = document.form;
		if (!ComIsNull(formObj.vsl_cd.value) && ComIsNull(formObj.skd_voy_no.value)) {
			$("#fm_dt").prop('disabled', false);
			$("#to_dt").prop('disabled', false);
			
			$("#fm_dt").addClass("input1");
			$("#to_dt").addClass("input1");
				
			ComBtnEnable("btn_etb");
			
		} 
		else if(ComIsNull(formObj.vsl_cd.value) && !ComIsNull(formObj.skd_voy_no.value)){
			$("#fm_dt").prop('disabled', false);
			$("#to_dt").prop('disabled', false);
			
			$("#fm_dt").addClass("input1");
			$("#to_dt").addClass("input1");
				
			ComBtnEnable("btn_etb");   // 2015-06-30 VVD입력과 ETB 간의 조건 수정 
		}
		
		else {
			
			$("#fm_dt").prop('disabled', true);
			$("#to_dt").prop('disabled', true);

			$("#fm_dt").removeClass();
			$("#to_dt").removeClass();
			
			ComBtnDisable("btn_etb");
			
		}		
	}
	
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction) {
		var prefix=sheetObj.id + "_";
		var headCnt=sheetObj.HeaderRows();
		var rowCnt=sheetObj.RowCount();
		var totCnt=sheetObj.LastRow();
    	switch(sAction) {
			case IBSEARCH:      //Retrieve
				if(ComIsNull(formObj.vsl_slan_cd.value) && ComIsNull(formObj.vsl_cd.value)){
					ComShowCodeMessage('VSK00027', "Lane Code");
					formObj.vsl_slan_cd.focus();
					return false;
				}
				
				if (ComIsNull(formObj.vsl_cd.value) && !ComIsNull(formObj.skd_voy_no.value)) {
					ComShowCodeMessage('VSK00027', "Vessel Code");
					formObj.vsl_cd.focus();
					return false;
				}
				
				if (ComIsNull(formObj.vsl_cd.value) || ComIsNull(formObj.skd_voy_no.value)) {
					if (ComIsNull(formObj.fm_dt.value)) {
						ComShowCodeMessage('VSK00027', "from ETB");
						formObj.fm_dt.focus();
						return false;
					}  else if (ComIsNull(formObj.to_dt.value)) {
						ComShowCodeMessage('VSK00027', "to ETB");
						formObj.fm_dt.focus();
						return false;
					}
					// Checking fm_dt < to_dt
					if(!checkPeriod(formObj.fm_dt, formObj.to_dt)) {
						ComShowCodeMessage("VSK00025", "End date", "start date");
						formObj.fm_dt.focus();
						return false;
					}
				}
				
				break;
		}
        return true;
    }
    /**
     * Retrieve
     * 
     * @param sheetObj
     * @param formObj
     * @param sAction
     * @return
     */
    function doActionSearch(sheetObj, formObj, sAction) {

    	formObj.f_cmd.value=SEARCH;
    	var prefix=sheetObj.id + "_";
		var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
		sheetObj.SetWaitImageVisible(0);
		ComOpenWait(true);
 		var sXml=sheetObj.GetSearchData("VOP_VSK_5001GS.do", sParam);
		ComOpenWait(false);
		
		sheetObj.LoadSearchData(sXml,{Sync:1} );

    }

	/*
	 * =====================================================================
	 * Object Event
	 * =====================================================================
	 */
    function initControl() {
    	axon_event.addListenerForm('change' , 'obj_change', form);
    	axon_event.addListenerForm('click'  , 'obj_click'   , document.form); 
    	axon_event.addListenerForm('blur'   , 'obj_deactivate'   , document.form); 
	}
    
	function obj_change() {
		var formObj  = document.form;
	    var sheetObj = sheetObjects[0];
	     /*******************************************************/
		try {
			var srcName  = ComGetEvent("name");
			var srcValue = ComGetEvent("value");
	        switch(srcName) {
	            case "vsl_cd":	            	
	            	checkVslCd(sheetObj, formObj);            		
	            	break;
	            case "skd_voy_no":
	            	if(srcValue.length == 4){
	            		formObj.skd_dir_cd.focus();	            		
			    	}
	            	dateEnabled();
	            	break;
	            case "skd_dir_cd":
	            	break;
	            case "vsl_slan_cd":
	            	pfValid(sheetObj, formObj);
	            	break;
           
	        } // end switch
	                
		}catch(e) {
			if( e == "[object Error]") {
				ComShowCodeMessage('VSK00011');
			} else {
				ComShowMessage(e.message);
			}
		}
	}
	
	function obj_deactivate() {
        var formObj = document.form;  
        var eleName = event.srcElement.name;

        switch(eleName){
            case "fm_dt":               
                if(ComGetDaysBetween(formObj.fm_dt.value, formObj.to_dt.value) > 32) {
                	ComShowCodeMessage('COM132001', "ETB", "1month");
                	formObj.fm_dt.value = "";
                }
                break;
            case "to_dt":
                ComChkObjValid(event.srcElement);
                if(ComGetDaysBetween(formObj.fm_dt.value, formObj.to_dt.value) > 32) {
                	ComShowCodeMessage('COM132001', "ETB", "1month");
                	formObj.to_dt.value = "";
                }
                break;  
        }
        
    }   
	
	function obj_click() {
		var eleObj = event.srcElement;
		var formObj = document.form;
		
		switch (eleObj.name) {
		    case "chk_voyage":
		    	
		    	formObj.voyage.value = ""; 
				if (formObj.chk_voyage.checked == true) {
					formObj.voyage.disabled = false;
		    		ComBtnEnable("btn_apply");
		    	} else {
		    		ComBtnDisable("btn_apply");
		    		formObj.voyage.disabled = true;
		    	}
			break;
		}
    }

    /**
     * Handling Slan Code Pop-up
     * @param rtnObjs
     * @return
     */
	function getLaneCodeData(rtnObjs){
		var formObj=document.form;
		
    	if(rtnObjs){	
    		formObj.vsl_slan_cd.value=rtnObjs[0][1];		
    	}
	}
	/**
	 * Setting data from VSL Code Help (Pop-Up)
	 * @param rtnObjs
	 * @return
	 */
	function getVslCdData(rtnObjs){
    	if(rtnObjs){
			var rtnDatas=rtnObjs[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					document.form.vsl_cd.value=rtnDatas[1];
				}
			}
    	}
    	dateEnabled();
    }
    /**
     * Setting data from VVD Code Help (Pop-Up)
     * @param rtnObjs
     * @return
     */
	function getVvdData(rtnObjs){
    	if(rtnObjs){
			var rtnDatas=rtnObjs[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					document.form.skd_voy_no.value=rtnDatas[2];
					document.form.skd_dir_cd.value=rtnDatas[3];
				}
			}
    	}
    	dateEnabled();
    }
    
    /**
     * Initializing screen
     * @param sheetObj
     * @param formObj
     * @return
     */
    function clearData(sheetObj, formObj) {
    	
    	formObj.vsl_slan_cd.value = "";
    	formObj.vsl_cd.value      = "";
    	formObj.skd_voy_no.value  = "";
    	formObj.skd_dir_cd.value  = "";
    	sheetObj.RemoveAll();
    	formObj.fm_dt.value = ComGetNowInfo(); 
		formObj.to_dt.value = ComGetDateAdd(null, "M", 1);
//		:: NEW 클릭 이후 이벤트 처리 수정 ::
		
//   	formObj.fm_dt.value = ComGetDateAdd(null, "D", -30);
//		formObj.to_dt.value = ComGetNowInfo();

		$("#fm_dt").prop('disabled', false);
		$("#to_dt").prop('disabled', false);
		$("#fm_dt").addClass("input1");
		$("#to_dt").addClass("input1");
		ComBtnEnable("btn_etb");
		//dateEnabled();
		//cv_cbm1.SetSelectIndex(0, true);
		cv_cbm2.SetSelectIndex(0, true);
    	formObj.vsl_slan_cd.focus();
    }
    
    /**
     * Checking inputed direction is exist in inputed Lane Code
     * @param sheetObj
     * @param formObj
     * @return
     */
    function pfValid(sheetObj, formObj){
    	if (formObj.vsl_slan_cd.value == "") {
    		return;
    	}
    	doActionIBSheet(sheetObj, formObj, COMMAND04);    	
    }
    

    
    
    /**
     * Checking Vessel Code is exist in MDM_VSL_CNTR
     * 
     * @param sheetObj
     * @param formObj
     * @return
     */
    function checkVslCd(sheetObj, formObj) {
    	if(formObj.vsl_cd.value == null || formObj.vsl_cd.value == undefined || formObj.vsl_cd.value == "") {
    		dateEnabled();
    		return false;
    	}
		doActionIBSheet(sheetObj, formObj, SEARCH16);
	}
    
    function sheet1_OnSearchEnd(sheetObj,ErrMsg) {
    	
    	var sheetID = sheetObj.id;
		var prefix  = sheetID + "_";
		
    	for (var nRow = sheetObj.HeaderRows(); nRow < (sheetObj.HeaderRows() + sheetObj.RowCount()); nRow++) {
    		
    		if	(	sheetObj.GetCellValue(nRow, prefix+"turn_port_ind_cd") == "D"
				||	sheetObj.GetCellValue(nRow, prefix+"turn_port_ind_cd") == "V"
				||	sheetObj.GetCellValue(nRow, prefix+"turn_port_ind_cd") == "F" 
				)
    		{
    			sheetObj.SetCellEditable(nRow, prefix+"ib_cssm_voy_no",false);
    			sheetObj.SetCellEditable(nRow, prefix+"ob_cssm_voy_no",false);	
    			
    		}else if(	sheetObj.GetCellValue(nRow, prefix+"clpt_seq") < sheetObj.GetCellValue(nRow, prefix+"first_turn_port_clpt_seq"))
    		{
        		sheetObj.SetCellEditable(nRow, prefix+"ib_cssm_voy_no",false);
        		sheetObj.SetCellEditable(nRow, prefix+"ob_cssm_voy_no",true);
    		}else if(	sheetObj.GetCellValue(nRow, prefix+"clpt_seq")			== "1" 
    				&&	sheetObj.GetCellValue(nRow, prefix+"turn_skd_voy_no") 	== ""
    				)
    		{
    			sheetObj.SetCellEditable(nRow,prefix + "ib_cssm_voy_no",false);
    			sheetObj.SetCellEditable(nRow,prefix + "ob_cssm_voy_no",true);
			}else{
				sheetObj.SetCellEditable(nRow,prefix + "ib_cssm_voy_no",true);
				sheetObj.SetCellEditable(nRow,prefix + "ob_cssm_voy_no",true);
			}
			
    	}

		
    	if (document.form.chk_virtual_port.checked == true) {
    		sheetObj.SetColHidden(8, 0);
    	} else {
    		sheetObj.SetColHidden(8, 1);
    	}

    	// 2015-06-25 updated / Initial 구분 cssm_voy_init_cre_flg
    	for(var nRow = sheetObj.HeaderRows(); nRow < (sheetObj.HeaderRows() + sheetObj.RowCount()); nRow++) {
    	
    		 if(sheetObj.GetCellValue(nRow, prefix + "cssm_voy_init_cre_flg")=="N"){
    			 sheetObj.SetRowBackColor(nRow,"#FFFF99");
     	  		 }
		  
    		// 2015-06-25 첫 I/B 미발생에 대한 입력 방지 처리
 			//if(		sheetObj.GetCellValue(nRow, prefix + "turn_port_ind_cd")=="N" && sheetObj.GetCellValue(nRow, prefix + "turn_port_flg")=="N"
			//	&& 	sheetObj.GetCellValue(nRow, prefix + "turn_skd_voy_no")=="" //&& sheetObj.GetCellValue(nRow, prefix + "clpt_seq")=="1"
			//	)
			//{
 			//	sheetObj.SetCellEditable(nRow,prefix + "ib_cssm_voy_no",false);
			//}
 			
 			//Virtual ADD Call Port 조건 추가
			if(sheetObj.GetCellValue(nRow, prefix + "vt_add_call_flg")=="Y"){
				sheetObj.SetCellEditable(nRow,prefix + "ob_cssm_voy_no",false);
				sheetObj.SetCellFontColor(nRow, prefix+"vps_port_cd", "#FF5E00");
			}
 		
		 }//for 
    }
    
    function sheet1_OnChange(sheetObj, Row, Col, Value, OldValue) {
    	var prefix=sheetObj.id + "_";
    	var formObj=document.form;
    	var colName=sheetObj.ColSaveName(Col);
    	if(colName == "sheet1_ob_cssm_voy_no" || colName == "sheet1_ib_cssm_voy_no" ){
    	if(Value != OldValue){
    		sheetObj.SetCellValue(Row, prefix + "voy_all_set_flg" , "", 0);
    		}
    	}
    	
    }

    function fn_setVoyage(sheetObj) {
    	
    	var sheetID = sheetObj.id;
		var prefix  = sheetID + "_";
		var selRow  = sheetObj.GetSelectRow();
		var voyage  = document.form.voyage.value;
		var blank = "";
		var voyAllSetFlg = "Y";
		
		//if (selRow < 0 || voyage.length == 0) return;
		if (selRow < 0) return;
		
		var strVvd = sheetObj.GetCellValue(selRow,  prefix+ "vsl_cd") + sheetObj.GetCellValue(selRow,  prefix+ "skd_voy_no") + sheetObj.GetCellValue(selRow,  prefix+ "skd_dir_cd");
		
		if (!ComShowCodeConfirm("VSK55005", strVvd)) return;
		
    	for (var nRow = sheetObj.HeaderRows(); nRow < (sheetObj.HeaderRows() + sheetObj.RowCount()); nRow++) {

			//:2016-04-05://if ((strVvd == sheetObj.GetCellValue(nRow,  prefix+ "vsl_cd") + sheetObj.GetCellValue(nRow,  prefix+ "skd_voy_no") + sheetObj.GetCellValue(nRow,  prefix+ "skd_dir_cd")) 
    		//:2016-04-05://		&& (sheetObj.GetCellValue(nRow,  prefix+ "turn_port_ind_cd") != "D" && sheetObj.GetCellValue(nRow,  prefix+ "turn_port_ind_cd") != "V" && sheetObj.GetCellValue(nRow,  prefix+ "turn_port_ind_cd") != "F")
    		//:2016-04-05://		)
    		
			if (strVvd == sheetObj.GetCellValue(nRow,  prefix+ "vsl_cd") + sheetObj.GetCellValue(nRow,  prefix+ "skd_voy_no") + sheetObj.GetCellValue(nRow,  prefix+ "skd_dir_cd"))
			{	
				
				if(		(		sheetObj.GetCellValue(nRow, prefix+ "real_clpt_seq") 	!= "1" 
						&& 	(	sheetObj.GetCellValue(nRow, prefix+ "turn_port_ind_cd") == "Y" 
							|| 	sheetObj.GetCellValue(nRow, prefix+ "turn_port_ind_cd") == "N"))
					||	
						((		sheetObj.GetCellValue(nRow, prefix+ "turn_port_ind_cd") == "D" 
							|| 	sheetObj.GetCellValue(nRow, prefix+ "turn_port_ind_cd") == "V" 
							|| 	sheetObj.GetCellValue(nRow, prefix+ "turn_port_ind_cd") == "F")
						&&		sheetObj.GetCellValue(nRow, prefix+ "vir_port_clpt_seq")== "1")
				){
					sheetObj.SetCellValue(nRow, prefix + "ib_cssm_voy_no"	, voyage);
					sheetObj.SetCellValue(nRow, prefix + "voy_all_set_flg"	, voyAllSetFlg, 0);
				}
				
				if(		(strVvd == sheetObj.GetCellValue(selRow,  prefix+ "vsl_cd") + sheetObj.GetCellValue(selRow,  prefix+ "skd_voy_no") + sheetObj.GetCellValue(selRow,  prefix+ "skd_dir_cd"))
					&&	(sheetObj.GetCellValue(nRow, prefix + "turn_port_ind_cd")=="N" && sheetObj.GetCellValue(nRow, prefix + "turn_port_flg")=="N"
					&& 	sheetObj.GetCellValue(nRow, prefix + "turn_skd_voy_no")=="" && sheetObj.GetCellValue(nRow, prefix + "real_clpt_seq")=="1")
					&& 	sheetObj.GetCellValue(nRow, prefix + "ib_cssm_voy_no")=="" )
				{
					sheetObj.SetCellValue(nRow,prefix + "ib_cssm_voy_no", blank );
				}
			
				
//			if(	(strVvd == sheetObj.GetCellValue(selRow,  prefix+ "vsl_cd") + sheetObj.GetCellValue(selRow,  prefix+ "skd_voy_no") + sheetObj.GetCellValue(selRow,  prefix+ "skd_dir_cd"))
//				&&(sheetObj.GetCellValue(nRow,  prefix+ "turn_port_ind_cd") != "D" && sheetObj.GetCellValue(nRow,  prefix+ "turn_port_ind_cd") != "V" && sheetObj.GetCellValue(nRow,  prefix+ "turn_port_ind_cd") != "F")	
//				|| sheetObj.GetCellValue(nRow, prefix + "clpt_seq")=="1")
//				{
//				sheetObj.SetCellValue(nRow, prefix + "ob_cssm_voy_no", voyage);
//				}
			
				
				if (sheetObj.GetCellValue(nRow,  prefix+ "turn_port_ind_cd") != "D" && sheetObj.GetCellValue(nRow,  prefix+ "turn_port_ind_cd") != "V" && sheetObj.GetCellValue(nRow,  prefix+ "turn_port_ind_cd") != "F")
				{
					/////////////top.top.top
					sheetObj.SetCellValue(nRow,prefix + "ob_cssm_voy_no", voyage);
					sheetObj.SetCellValue(nRow, prefix + "voy_all_set_flg", voyAllSetFlg, 0);
				}
				
				if(		sheetObj.GetCellValue(nRow, prefix+"clpt_seq")			== "1" 
					&&	sheetObj.GetCellValue(nRow, prefix+"turn_skd_voy_no") 	== ""
				){
					sheetObj.SetCellValue(nRow, prefix + "ib_cssm_voy_no"	, blank);
					sheetObj.SetCellValue(nRow, prefix + "voy_all_set_flg"	, voyAllSetFlg, 0);
				}
			
			}else if(strVvd == sheetObj.GetCellValue(nRow, prefix + "vsl_cd") + sheetObj.GetCellValue(nRow,  prefix+ "turn_skd_voy_no") + sheetObj.GetCellValue(nRow, prefix + "turn_skd_dir_cd")){
				
				if(	((		sheetObj.GetCellValue(nRow, prefix+ "turn_port_ind_cd") == "D" 
						|| 	sheetObj.GetCellValue(nRow, prefix+ "turn_port_ind_cd") == "V" 
						|| 	sheetObj.GetCellValue(nRow, prefix+ "turn_port_ind_cd") == "F")
					&&		sheetObj.GetCellValue(nRow, prefix+ "vir_port_clpt_seq")!= "1"
					)
					||
					sheetObj.GetCellValue(nRow, prefix + "real_clpt_seq") == "1")
				{
					sheetObj.SetCellValue(nRow, prefix + "ib_cssm_voy_no", voyage);  
				}

			}
			
			//Virtual ADD Call Port 조건 추가
			if(sheetObj.GetCellValue(nRow, prefix + "vt_add_call_flg")=="Y"){
				sheetObj.SetCellValue(nRow, prefix + "ob_cssm_voy_no", blank);
			}
    	}
    }

    function checkPeriod(fromDate, toDate){
		var fmDt = ComReplaceStr(fromDate.value, "-", "");
		var toDt = ComReplaceStr(toDate.value, "-", "");
		if(ComChkPeriod(fmDt, toDt) < 1){
			return false;
		}else{
			return true;
		}
	}
    
    function resizeSheet(){        
    	ComResizeSheet(sheetObjects[0], 80);        
    }