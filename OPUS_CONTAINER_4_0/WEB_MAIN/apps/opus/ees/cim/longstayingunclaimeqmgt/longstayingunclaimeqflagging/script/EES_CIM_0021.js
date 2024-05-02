/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_CIM_0021.js
*@FileTitle  : Container Staying Days (Summary)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/18
=========================================================*/
    /**
     * @extends 
     * @class EES_CIM_0021 : business script for EES_CIM_0021 
     */
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0 ;
 	var IBSEARCH01=29;
 	var IBSEARCH02=30;
 	var IBSEARCH03=31;
 	var IBSEARCH04=32;
 	var tot_cntr_tpsz_cd="";
    var tot_cnmv_sts_cd="";
    var tot_lstm_cd="";
    var totHeadCount=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
 	// Event handler processing by button name */
    function processButtonClick(){
    	var shtCnt=0;
        var sheetObject1=sheetObjects[shtCnt++];
        var sheetObject2=sheetObjects[shtCnt++];
        var sheetObject3=sheetObjects[shtCnt++];
        /*******************************************************/
        var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
     		if(ComGetBtnDisable(srcName)) return false;
        	var row;
        	var titleFlag='';
        	var rsheetObjects;
        	if ( beforetab == 0 ) {	  //retrieving from first tab
        		row=sheetObjects[0].RowCount();
        		rsheetObjects=sheetObjects[0];
        	} else if ( beforetab == 1 ) {	  //retrieving from second tab
        		row=sheetObjects[1].RowCount();
        		rsheetObjects=sheetObjects[1];
        	} else if ( beforetab == 2 ) {	  //retrieving from third tab
        		row=sheetObjects[2].RowCount();
        		rsheetObjects=sheetObjects[2];
        	}
			switch(srcName) {
				case "btn_Retrieve":
					document.form.cntr_tpsz_cd.value=comboObjects[0].GetSelectCode();
					document.form.cnmv_sts_cd.value=comboObjects[1].GetSelectCode();
					document.form.lstm_cd.value=comboObjects[2].GetSelectCode();
					
					if ( beforetab == 0 ) {	  //retrieving from first tab
						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					} else if ( beforetab == 1 ) {	//retrieving from second tab
						doActionIBSheet(sheetObjects[1],document.form,IBSEARCH02);
					} else if ( beforetab == 2 ) {	//retrieving from third tab
						doActionIBSheet(sheetObjects[2],document.form,IBSEARCH03);
					}
					break;
				case "btn_new":
					comboObjects[0].SetSelectCode('');
					comboObjects[1].SetSelectCode('');
					comboObjects[2].SetSelectCode('');
		        	formObject.reset();
					loc_type_code_onchange();
					sheetObject1.RemoveAll();
					sheetObject2.RemoveAll();
					sheetObject3.RemoveAll();
					
					sheetObjects[0].SetCellText(0, "loc_cd", "RCC");
		    		sheetObjects[1].SetCellText(0, "loc_cd", "RCC");
		    		sheetObjects[2].SetCellText(0, "loc_cd", "RCC");
					tabObjects[0].SetSelectedIndex(0);
					break;
				case "btn_downexcel":
					if(rsheetObjects.RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
	        	    }else{
//	        	    	doActionIBSheet(rsheetObjects,formObject,IBDOWNEXCEL);
	        	    	rsheetObjects.Down2Excel( {DownCols: makeHiddenSkipCol(rsheetObjects), SheetDesign:1, Merge:1 });
	        	    }
					break;
				case "btn_loc_cd":	//retrieving Location popup
	    	        var cnt_cd="";
	    	        var loc_cd="";
		            cnt_cd=formObject.loc_type_code.value;
		            loc_cd=formObject.loc_cd.value;
		            if ( formObject.loc_type_code.value != '' ) {	
						if ( formObject.loc_type_code.value == '6' ) {	//yard
							var param="?cnt_cd="+cnt_cd+"&loc_cd="+loc_cd;
							ComOpenPopup("/opuscntr/COM_ENS_061.do",1000, 477, "popupFinish", "1,0,1,1,1,1,1,1", true);
		           		} else {
		        			var loc_code="";
		        			if ( form.loc_type_code.value == "1" ) {
		        				loc_code="rcc_cd";
		        			} else if ( form.loc_type_code.value == "2" ) {
		        				loc_code="lcc_cd";
		        			} else if ( form.loc_type_code.value == "3" ) {
		        				loc_code="lcc_cd";
		        			} else if ( form.loc_type_code.value == "4" ) {
		        				loc_code="ecc_cd";
		        			} else if ( form.loc_type_code.value == "5" ) {
		        				loc_code="scc_cd";
		        			}
							var param="?cnt_cd="+cnt_cd+"&loc_cd="+loc_cd;
							ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 1000, 460, loc_code+":loc_cd", "0,1,1,1,1,1", true);
		           		}
		            }
					break; 					
                case "btn_t1detail1":
                	titleFlag='Summary';	
					break; 					
                case "btn_t1detail3":
                	titleFlag='By Movement';	
					break; 					
				case "btn_t1detail2":
                	if(row > 0){
	                	var loc_type_code=formObject.param_loc_type_code.value;
	                	if ( loc_type_code == '2' || loc_type_code == '3' ) {
	                		loc_type_code='1'
	                	} else if ( loc_type_code == '4' ) {
	                		loc_type_code='2'
	                	} else if ( loc_type_code == '5' ) {
	                		loc_type_code='3'
	                	} else {
	                		loc_type_code=''
	                	}
                		var loc_cd=formObject.param_loc_cd.value;
                		var over_stay_days=formObject.param_over_stay_days.value;
                		var cntr_tpsz_cd=formObject.param_cntr_tpsz_cd.value;
                		var cnmv_sts_cd=formObject.param_cnmv_sts_cd.value;
                		var full_flg=formObject.param_full_flg.value;
						var param="";
                		if ( loc_type_code == '' ) {
							param="?popup_mode=Y";
                		} else {
							param="?loc_type_code="+loc_type_code+"&loc_cd="+loc_cd+"&over_stay_days="+over_stay_days+"&cntr_tpsz_cd="+cntr_tpsz_cd+"&cnmv_sts_cd="+cnmv_sts_cd+"&full_flg="+full_flg+"&popup_mode=Y";
                		}
						ComOpenPopup("/opuscntr/EES_CIM_0022_POP.do"+param,1150, 690, "", "1,0,1,1,1,1,1,1", true);
                	}
                    break;
                case "btn_t3ByMVMTStatus":
                	if(row > 0){
                    	var formObject=document.form;
						var sub_cntr_tpsz_cd=rsheetObjects.GetCellValue(rsheetObjects.GetSelectRow(),"cntr_tpsz_cd");
						var sub_loc_cd=rsheetObjects.GetCellValue(rsheetObjects.GetSelectRow(),"loc_cd");
						var sub_cnmv_sts_cd=rsheetObjects.GetCellValue(rsheetObjects.GetSelectRow(),"cnmv_sts_cd");
                    	if ( sub_loc_cd=='Total' ) {	
                    		return;
                    	}
                    	if ( sub_loc_cd=='Total' ) {
                    		sub_loc_cd='';
                    	}
                    	if ( sub_cntr_tpsz_cd=='Total' ) {
                    		sub_cntr_tpsz_cd="";
                    	}
                    	if ( typeof(sub_cnmv_sts_cd)=='undefined' ) {
                    		sub_cnmv_sts_cd=formObject.param_cnmv_sts_cd.value
                    	}
                    	
                    	var  selColCheck = ""
        	            selColCheck = rsheetObjects.GetCellValue(0,rsheetObjects.GetSelectCol());
                    	
                    	var mvmt_status_cd = selColCheck;
    	            	
                    	if(mvmt_status_cd == "Total") {
    	            		mvmt_status_cd = "";
    	            	}
    	            	
                    	
                    	param="?loc_type_code="+formObject.param_loc_type_code.value
                    		   +"&loc_cd="+formObject.param_loc_cd.value
                    		   +"&cntr_tpsz_cd="+formObject.param_cntr_tpsz_cd.value
                    		   +"&dmg_flg="+formObject.param_dmg_flg.value
                    		   +"&over_stay_days="+formObject.param_over_stay_days.value
                    		   +"&cnmv_sts_cd="+formObject.param_cnmv_sts_cd.value
                    		   +"&uclm_ls_div_cd="+formObject.param_uclm_ls_div_cd.value
                    		   +"&full_flg="+formObject.param_full_flg.value
                    		   +"&lstm_cd="+formObject.param_lstm_cd.value
                    		   +"&soc_cd="+formObject.param_soc_cd.value
                    		   +"&sub_cntr_tpsz_cd="+sub_cntr_tpsz_cd
                    		   +"&sub_loc_cd="+sub_loc_cd
                    		   +"&sub_cnmv_sts_cd="+sub_cnmv_sts_cd
                    		   +"&mvmt_status_cd="+mvmt_status_cd;
                    	if(rsheetObjects.GetSelectCol() > 1  ) {
                    		ComOpenPopup("/opuscntr/EES_CIM_0041.do"+param,900, 445, "", "1,0,1,1,1,1,1,1", true);
                    	}
                	}
                    break;   	                    
				case "btn_t3detail":
	               	if(row > 0){
                    	var formObject=document.form;
						var sub_cntr_tpsz_cd=rsheetObjects.GetCellValue(rsheetObjects.GetSelectRow(),"cntr_tpsz_cd");
						var sub_loc_cd=rsheetObjects.GetCellValue(rsheetObjects.GetSelectRow(),"loc_cd");
						var sub_cnmv_sts_cd=rsheetObjects.GetCellValue(rsheetObjects.GetSelectRow(),"cnmv_sts_cd");
                    	if ( sub_loc_cd=='Total' ) {	
                    		//return;
                    	}
                    	if ( sub_loc_cd=='Total' ) {
                    		sub_loc_cd='';
                    	}
                    	if ( sub_cntr_tpsz_cd=='Total' ) {
                    		sub_cntr_tpsz_cd="";
                    	}
                    	if ( typeof(sub_cnmv_sts_cd)=='undefined' ) {
                    		sub_cnmv_sts_cd=formObject.param_cnmv_sts_cd.value
                    	}
                    	
                    	var  selColCheck = ""
            	            selColCheck = rsheetObjects.GetCellValue(0,rsheetObjects.GetSelectCol());
                        	
                        	var mvmt_status_cd = selColCheck;
        	            	
                        	if(mvmt_status_cd == "Total") {
        	            		mvmt_status_cd = "";
        	            	}
                        	
                        	if(sub_cntr_tpsz_cd == "G.Total") {
                        		sub_cntr_tpsz_cd = "";
                        	}
                        	
                        	if(sub_loc_cd == "G.Total") {
                        		sub_loc_cd = "";
                        	}
                        	
                    	param="?loc_type_code="+formObject.param_loc_type_code.value
                    		   +"&loc_cd="+formObject.param_loc_cd.value
                    		   +"&cntr_tpsz_cd="+formObject.param_cntr_tpsz_cd.value
                    		   +"&dmg_flg="+formObject.param_dmg_flg.value
                    		   +"&over_stay_days="+formObject.param_over_stay_days.value
                    		   +"&cnmv_sts_cd="+formObject.param_cnmv_sts_cd.value
                    		   +"&uclm_ls_div_cd="+formObject.param_uclm_ls_div_cd.value
                    		   +"&full_flg="+formObject.param_full_flg.value
                    		   +"&lstm_cd="+formObject.param_lstm_cd.value
                    		   +"&soc_cd="+formObject.param_soc_cd.value
                    		   +"&sub_cntr_tpsz_cd="+sub_cntr_tpsz_cd
                    		   +"&sub_loc_cd="+sub_loc_cd
                    		   +"&sub_cnmv_sts_cd="+sub_cnmv_sts_cd
                    		   +"&mvmt_status_cd="+mvmt_status_cd;
                    	if(rsheetObjects.GetSelectCol() > 1  ) {
                    		ComOpenPopup("/opuscntr/EES_CIM_0042.do"+param,900, 455, "", "1,0,1,1,1,1,1,1", true);
                    	}
                	}
	               	break; 
			} // end switch
			
			if ( titleFlag == 'Summary' || titleFlag == 'By Movement' ) {	//Symmary,Movement detail 타이틀 구분
				if(row > 0) {
	            	var formObject=document.form;
	            	// var srcValue= window.event.srcElement.getAttribute("value");
	            	var srcValue = ComGetEvent('value');
					var sub_cntr_tpsz_cd=rsheetObjects.GetCellValue(rsheetObjects.GetSelectRow(),"cntr_tpsz_cd");
					var sub_loc_cd=rsheetObjects.GetCellValue(rsheetObjects.GetSelectRow(),"loc_cd");
					var sub_cnmv_sts_cd=rsheetObjects.GetCellValue(rsheetObjects.GetSelectRow(),"cnmv_sts_cd");
	            	if ( sub_loc_cd=='Total' ) {	
	            		//return;
	            	}
	            	if ( sub_loc_cd=='Total' ) {
	            		sub_loc_cd='';
	            	}
	            	if ( sub_cntr_tpsz_cd=='Total' ) {
	            		sub_cntr_tpsz_cd=formObject.param_cntr_tpsz_cd.value;
	            	}
	            	if ( typeof(sub_cnmv_sts_cd)=='undefined' ) {
	            		sub_cnmv_sts_cd=formObject.param_cnmv_sts_cd.value;
	            	}
	            	
	            	if(titleFlag == 'Summary' ){
	            		sub_cnmv_sts_cd = "";
	            	}
	            	
	            	var  selColCheck = ""
	            	selColCheck = rsheetObjects.GetCellValue(0,rsheetObjects.GetSelectCol());
	            	
	            	
	            	var start_stay_days = "";
	            	var end_stay_days = "";
	            	
	            	if(selColCheck == "Total") {
	            		start_stay_days = "0";
	            		end_stay_days  = "0";
	            	}else if(selColCheck == "31 or Over") {
	            		start_stay_days = "31";
	            	}else if(selColCheck == "1~15") {
	            		start_stay_days = "1";
	            		end_stay_days  = "15";
	            	}else if(selColCheck == "16~30") {
	            		start_stay_days = "16";
	            		end_stay_days  = "30";
	            	}else if(selColCheck == "31~60") {
	            		start_stay_days = "31";
	            		end_stay_days  = "60";
	            	}else if(selColCheck == "61~120") {
	            		start_stay_days = "61";
	            		end_stay_days  = "120";
	            	}else if(selColCheck == "121~180") {
	            		start_stay_days = "121";
	            		end_stay_days  = "180";
	            	}else if(selColCheck == "181~365") {
	            		start_stay_days = "181";
	            		end_stay_days  = "365";
	            	}else if(selColCheck == "366 or Over") {
	            		start_stay_days = "366";
	            	}else {
	            		start_stay_days = formObject.over_stay_days.value;
	            	}
	            	
	            	if(sub_cntr_tpsz_cd=="G.Total") {
	            		sub_cntr_tpsz_cd = "";
	            	}
	            	
	            	if(sub_loc_cd == "G.Total") {
	            		sub_loc_cd = "";
	            	}
	            	
	            	param="?loc_type_code="+formObject.param_loc_type_code.value
	            		   +"&loc_cd="+formObject.param_loc_cd.value
	            		   +"&cntr_tpsz_cd="+formObject.param_cntr_tpsz_cd.value
	            		   +"&dmg_flg="+formObject.param_dmg_flg.value
	            		   +"&over_stay_days="+formObject.param_over_stay_days.value
	            		   +"&cnmv_sts_cd="+formObject.param_cnmv_sts_cd.value
	            		   +"&uclm_ls_div_cd="+formObject.param_uclm_ls_div_cd.value
	            		   +"&full_flg="+formObject.param_full_flg.value
	            		   +"&lstm_cd="+formObject.param_lstm_cd.value
	            		   +"&soc_cd="+formObject.param_soc_cd.value
	            		   +"&sub_cntr_tpsz_cd="+sub_cntr_tpsz_cd
	            		   +"&sub_loc_cd="+sub_loc_cd
	            		   +"&titleFlag="+titleFlag
	            		   +"&start_stay_days=" + start_stay_days
	            		   +"&end_stay_days=" + end_stay_days
	            		   +"&sub_cnmv_sts_cd="+sub_cnmv_sts_cd
	            		   ;
	            	
	            	//if((rsheetObjects.GetSelectCol() > 1 && titleFlag == 'Summary') ) {
	            	if((rsheetObjects.GetSelectCol() > 1) ) {
	            		ComOpenPopup("/opuscntr/EES_CIM_0044.do"+param,900, 455, "", "1,0,1,1,1,1,1,1", true);
	            	}
	            	
	            	//if((rsheetObjects.GetSelectCol() > 2 && titleFlag == 'By Movement') ) {
	            	if((rsheetObjects.GetSelectCol() > 2) ) {
	            		ComOpenPopup("/opuscntr/EES_CIM_0044.do"+param,900, 455, "", "1,0,1,1,1,1,1,1", true);
	            	}
	        	}
			}
     	}catch(e) {
     		if( e == "[object Error]") {
     			ComShowMessage(OBJECT_ERROR);
     		} else {
     			ComShowMessage(e.message);
     		}
     	}
    }
    /**
     * setting options when retrieving detail popup
     */    
    function setParamValue() {
    	var formObject=document.form;
    	formObject.param_loc_type_code.value=formObject.loc_type_code.value; 
    	formObject.param_loc_cd.value=formObject.loc_cd.value; 
    	formObject.param_cntr_tpsz_cd.value=comboObjects[0].GetSelectCode();
    	formObject.param_dmg_flg.value=formObject.dmg_flg.value; 
    	formObject.param_over_stay_days.value=formObject.over_stay_days.value; 
    	formObject.param_cnmv_sts_cd.value=comboObjects[1].GetSelectCode();
    	formObject.param_uclm_ls_div_cd.value=formObject.uclm_ls_div_cd.value; 
    	formObject.param_full_flg.value=formObject.full_flg.value; 
    	formObject.param_lstm_cd.value=comboObjects[2].GetSelectCode();
    	formObject.param_soc_cd.value=formObject.soc_cd.value; 
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
    function loadPage( cnmv_sts_cd, cnmv_sts_nm ) {
    	ComOpenWait(true);
        sheetObjects[0].SetWaitImageVisible(0);
        setTimeout( function () {
	    	for(i=0;i<sheetObjects.length;i++){
	             ComConfigSheet (sheetObjects[i] );
	            initSheet(sheetObjects[i],i+1);
	            ComEndConfigSheet(sheetObjects[i]);
	        }
    	
	    	resizeSheet();
	    	sheetObjects[0].SetWaitImageVisible(1);
            
            ComOpenWait(false);
            
	        for(k=0;k<tabObjects.length;k++){
	            initTab(tabObjects[k],k+1);
	            tabObjects[k].SetSelectedIndex(0);
	        }
		    for(p=0;p< comboObjects.length;p++){
			       initCombo (comboObjects[p],p+1);
			}        
	        initControl();
	        makeCnmvStsInfo(cnmv_sts_cd , cnmv_sts_nm);
	        sheet1_OnLoadFinish(sheetObjects);
        } , 100);
    }
    /**
     * creating MVMT Status 
     */
    function makeCnmvStsInfo(cnmv_sts_cd , cnmv_sts_nm) {
        var arr_cnmv_sts_cd=cnmv_sts_cd.split("|");
        var arr_cnmv_sts_nm=cnmv_sts_nm.split("|");
        tot_cnmv_sts_cd=arr_cnmv_sts_cd;
        with (combo_cnmv_sts_cd) {
        	SetMultiSelect(1);
            SetMultiSeparator(",");
        	SetDropHeight(320);
        	InsertItem(0 , 'ALL','');
        	for ( var i=1; i<=arr_cnmv_sts_cd.length; i++) {
        		InsertItem(i, arr_cnmv_sts_cd[i-1], arr_cnmv_sts_nm[i-1]);
        	}
        } 
    }    
	function sheet1_OnLoadFinish(sheetObj) {
    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH01); //getting TP/SZ,MVMT Status,Lease Term data
    	viewUsData( true ) ;	 //showing 'CM','CP','CI','CO','CD','CT' data in case Location by='US'
    }        
    /**
     * showing 'CM','CP','CI','CO','CD','CT' data in case Location by = 'US'
     */
    function viewUsData( usFlag) {
    	for ( var i=9; i<=15; i++ ) {
    		sheetObjects[2].SetColHidden("qty"+i,usFlag);
    		sheetObjects[2].SetColHidden("avg"+i,usFlag);
    		sheetObjects[2].SetColHidden("rate"+i,usFlag);
    	}
    }
    /**
     * registering IBCombo Object as list
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     */
    function setComboObject(combo_obj){
         comboObjects[comboCnt++]=combo_obj;
    }
    /**
     * initializing Tab
     * setting Tab items
     */
    function initCombo (comboObj, comboNo) {
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
    * registering initial event
    */
    function initControl() {
        //axon_event.addListener('change', 'op_trnd_tp_cd_onchange', 'op_trnd_tp_cd');		//handling event when changing Period
        axon_event.addListener('change', 'loc_type_code_onchange', 'loc_type_code');		//handling event when changing Location by 
        //axon_event.addListener('keyup', 'loc_cd_onkeyUp', 'loc_cd');						//handling LOC_CD keyup event
        //axon_event.addListener('keydown', 'ComKeyEnter', 'form');							//handling Enter key retrieving event
        axon_event.addListenerFormat('beforeactivate', 'obj_activate', form); 				
        axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form); 			
    	//axon_event.addListenerForm('keypress', 'obj_keypress'  , form);						//upper case, numbers only
    	// axon_event.addListenerFormat('blur', 'obj_blur', form);
    }
    /**
     * handling beforeactivate event
     */    
	function obj_activate() {
		ComClearSeparator(ComGetEvent());
	}
	/**
	 * handling beforedeactivate event
	 * YYYY-MM format
	 */	
	function obj_deactivate() {
		ComClearSeparator(ComGetEvent());
	}
	/**
     * handling event when clicking TP/SZ 
     */
    function combo_cntr_tpsz_cd_OnCheckClick(comboObj, index, code) {
    	if(index==0) { 	    	
    		var bChk=comboObj.GetItemCheck(index);
    		if(bChk){
    			for(var i=1 ; i < comboObj.GetItemCount() ; i++) {
    				comboObj.SetItemCheck(i,0);
    			}
    		}
    	} else {
    		var bChk=comboObj.GetItemCheck(index);
    		if (bChk) {
    			comboObj.SetItemCheck(0,0);
    		}
    	}
    }
	/**
     * registering MVMT Status click event
     */
    function combo_cnmv_sts_cd_OnCheckClick(comboObj, index, code) {
    	if(index==0) { 	    	
    		var bChk=comboObj.GetItemCheck(index);
    		if(bChk){
    			for(var i=1 ; i < comboObj.GetItemCount() ; i++) {
    				comboObj.SetItemCheck(i,0);
    			}
    		}
    	} else {
    		var bChk=comboObj.GetItemCheck(index);
    		if (bChk) {
    			comboObj.SetItemCheck(0,0);
    		}
    	}
    }    
	/**
     * registering Lease Term click event
     */       
    function combo_lstm_cd_OnCheckClick(comboObj, index, code) {
    	if(index==0) { 	    	
    		var bChk=comboObj.GetItemCheck(index);
    		if(bChk){
    			for(var i=1 ; i < comboObj.GetItemCount() ; i++) {
    				comboObj.SetItemCheck(i,0);
    			}
    		}
    	} else {
    		var bChk=comboObj.GetItemCheck(index);
    		if (bChk) {
    			comboObj.SetItemCheck(0,0);
    		}
    	}
    }
	/**
	 * handling Location  blur event
	 * validating Location code
	 */	
	function obj_blur() {
		switch (event.srcElement.name) {
			case "loc_cd":
				if ( document.form.loc_cd.value !='') {
					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH04);
				}
				break;
		}
	}
	/**
     * registering key event
     */  
// 	function obj_keypress() {
//		var formObject=document.form;
//		switch (event.srcElement.name) {
//			case "loc_cd":
//				ComKeyOnlyAlphabet('uppernum');// upper case, numbers only
//				break;
//			case "over_stay_days":
//				ComKeyOnlyNumber(event.srcElement);// upper case, numbers only
//				break;
//		}
//	} 
    /**
	 * handling LOC_CD keyup event
	 */
    function loc_cd_onkeyUp() {
        var formObject=document.form;
        if ( (event.keyCode < 37 || event.keyCode >40) && event.keyCode != 16 ) {
	        if ( formObject.loc_type_code.value == '6' ) {
	            if ( formObject.loc_cd.value.length > 1) {
	        	    document.getElementById("loc_cd").setAttribute("maxLength",7);
	        	    formObject.loc_cd.value=formObject.loc_cd.value.substring(0,7).toUpperCase();
	        	    if ( formObject.loc_cd.value.length == 7 ) {
	        	    	ComSetFocus(document.form.combo_cntr_tpsz_cd);
	        	    }
	            }
	        } else {
	            document.getElementById("loc_cd").setAttribute("maxLength",5);
        	    if ( formObject.loc_cd.value.length == 5 ) {
        	    	ComSetFocus(document.form.combo_cntr_tpsz_cd);
        	    }
	        }
	        formObject.loc_cd.value=formObject.loc_cd.value.toUpperCase();
        }
    }
    /**
     * handling event when changing Location by 
     * deactivatin input column when selecting ALL (by RCC)
     * activatin the others
     */
    function loc_type_code_onchange() {
    	var formObject=document.form;
        if ( formObject.loc_type_code.value != '' ) {
     	   formObject.loc_cd.readOnly=false;
     	   formObject.loc_cd.className="input1";
        } else {
     	   formObject.loc_cd.readOnly=true;
     	   formObject.loc_cd.className="input2";
     	   formObject.loc_cd.value="";
        }
//        formObject.loc_cd.value = "";
        ComSetFocus(document.form.loc_cd);
    }
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
    	var cnt=0;
    	var shtID=sheetObj.id;
    	switch(shtID) {
    		case "sheet1":      //sheet1 init
    		    with(sheetObj){    	       
			    	      var HeadTitle1="RCC|TP&SZ|Total|Total|31 or Over|31 or Over|31 or Over|1~15|1~15|1~15|16~30|16~30|16~30|31~60|31~60|31~60|61~120|61~120|61~120|121~180|121~180|121~180|181~365|181~365|181~365|366 or Over|366 or Over|366 or Over|";
			    	      var HeadTitle2="RCC|TP&SZ|CNTR|AVG|CNTR|AVG|%|CNTR|AVG|%|CNTR|AVG|%|CNTR|AVG|%|CNTR|AVG|%|CNTR|AVG|%|CNTR|AVG|%|CNTR|AVG|%|";
			    	      var headCount=ComCountHeadTitle(HeadTitle1);
			    	      totHeadCount=headCount;
			    	      SetConfig( { SearchMode:0, FrozenCol:7, MergeSheet:7, Page:2000, DataRowMerge:0, PrevColumnMergeMode:1 } );
			    	      var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
			    	      var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
			    	      InitHeaders(headers, info);
			    	      var cols = [ 
			    	             {Type:"Text",   Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"loc_cd",        KeyField:0,   CalcLogic:"",   Format:"" },
			    	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"" },
			    	             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"total_qty",     KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
			    	             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"total_avg",     KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
			    	             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"over_qty",      KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
			    	             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"over_avg",      KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
			    	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"over_rate",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 },
			    	             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"qty1",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
			    	             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"avg1",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
			    	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"rate1",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 },
			    	             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"qty2",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
			    	             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"avg2",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
			    	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"rate2",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 },
			    	             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"qty3",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
			    	             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"avg3",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
			    	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"rate3",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 },
			    	             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"qty4",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
			    	             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"avg4",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
			    	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"rate4",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 },
			    	             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"qty5",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
			    	             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"avg5",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
			    	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"rate5",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 },
			    	             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"qty6",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
			    	             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"avg6",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
			    	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"rate6",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 },
			    	             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"qty7",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
			    	             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"avg7",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
			    	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"rate7",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 },
			    	             {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"lvl",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 }
			    	            // {Type:"AutoSum",      Hidden:1, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 }
			    	             ];
			    	       
			    	      InitColumns(cols);
			    	      SetEditable(0);
			    	      //SetSheetHeight(450);
			    	      ComResizeSheet(sheetObj);
			    	      FrozenCols=7;
    	      	}
    		    	break;
    		case "sheet2":      //sheet1 init
    		    with(sheetObj){    	        
		    	      var HeadTitle1="SCC|MVMT|TP&SZ|Total|Total|31 or Over|31 or Over|31 or Over|1~15|1~15|1~15|16~30|16~30|16~30|31~60|31~60|31~60|61~120|61~120|61~120|121~180|121~180|121~180|181~365|181~365|181~365|366 or Over|366 or Over|366 or Over|";
		    	      var HeadTitle2="SCC|MVMT|TP&SZ|CNTR|AVG|CNTR|AVG|%|CNTR|AVG|%|CNTR|AVG|%|CNTR|AVG|%|CNTR|AVG|%|CNTR|AVG|%|CNTR|AVG|%|CNTR|AVG|%|";
		    	      var headCount=ComCountHeadTitle(HeadTitle1);
		    	      totHeadCount=headCount;
		    	      (headCount, 0, 0, true);
		    	      SetConfig( { SearchMode:2, FrozenCol:8, MergeSheet:7, Page:2000, DataRowMerge:0, PrevColumnMergeMode:1 } );
		    	      var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
		    	      var headers = [ { Text:HeadTitle1, Align:"Center"},
		    	                  { Text:HeadTitle2, Align:"Center"} ];
		    	      InitHeaders(headers, info);
		    	      var cols = [ 
	    	                 {Type:"Text",   Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"loc_cd",        KeyField:0,   CalcLogic:"",   Format:"" },
		    	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cnmv_sts_cd",   KeyField:0,   CalcLogic:"",   Format:"" },
		    	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"" },
		    	             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"total_qty",     KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		    	             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"total_avg",     KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		    	             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"over_qty",      KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		    	             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"over_avg",      KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		    	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"over_rate",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 },
		    	             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"qty1",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		    	             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"avg1",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		    	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"rate1",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 },
		    	             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"qty2",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		    	             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"avg2",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		    	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"rate2",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 },
		    	             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"qty3",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		    	             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"avg3",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		    	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"rate3",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 },
		    	             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"qty4",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		    	             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"avg4",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		    	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"rate4",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 },
		    	             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"qty5",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		    	             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"avg5",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		    	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"rate5",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 },
		    	             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"qty6",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		    	             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"avg6",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		    	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"rate6",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 },
		    	             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"qty7",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		    	             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"avg7",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		    	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"rate7",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 },
		    	             {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"lvl",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 }
		    	             //{Type:"AutoSum",      Hidden:1, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 }
		    	             ];
		    	       
		    	      InitColumns(cols);
		    	      SetEditable(0);
		    	      SetSheetHeight(370);
		    	      //resizeSheet();
		    	      FrozenCols=8;
		    	 }
    	        break;
             case "sheet3":      //sheet1 init
            	    with(sheetObj){                 
		               var loc_cd=document.form.loc_cd.value.substr(0,2);
		               var HeadTitle1="SCC|TP&SZ|Total|Total|Total|IC|IC|IC|ID|ID|ID|MT|MT|MT|OP|OP|OP|OC|OC|OC|TN|TN|TN|EN|EN|EN|TS|TS|TS|CI|CI|CI|CD|CD|CD|CM|CM|CM|CP|CP|CP|CO|CO|CO|CT|CT|CT|CE|CE|CE|";
		               var HeadTitle2="SCC|TP&SZ|A/CNTR|Count|AVG|Count|AVG|%|Count|AVG|%|Count|AVG|%|Count|AVG|%|Count|AVG|%|Count|AVG|%|Count|AVG|%|Count|AVG|%|Count|AVG|%|Count|AVG|%|Count|AVG|%|Count|AVG|%|Count|AVG|%|Count|AVG|%|Count|AVG|%|";
		               var headCount=ComCountHeadTitle(HeadTitle1);
		               totHeadCount=headCount;
		               (headCount, 0, 0, true);
		               SetConfig( { SearchMode:2, FrozenCol:5, MergeSheet:7, Page:1000, DataRowMerge:0, PrevColumnMergeMode:1 } );
		               var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
		               var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
		               InitHeaders(headers, info);		
		               var cols = [ 
		                      {Type:"Text",   Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"loc_cd",        KeyField:0,   CalcLogic:"",   Format:"" },
		                      {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"" },
		                      {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"act_qty",       KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                      {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"total_qty",     KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                      {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"total_avg",     KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                      {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"qty1",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                      {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"avg1",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                      {Type:"Text",      Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"rate1",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 },
		                      {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"qty2",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                      {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"avg2",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                      {Type:"Text",      Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"rate2",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 },
		                      {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"qty3",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                      {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"avg3",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                      {Type:"Text",      Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"rate3",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 },
		                      {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"qty4",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                      {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"avg4",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                      {Type:"Text",      Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"rate4",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 },
		                      {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"qty5",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                      {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"avg5",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                      {Type:"Text",      Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"rate5",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 },
		                      {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"qty6",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                      {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"avg6",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                      {Type:"Text",      Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"rate6",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 },
		                      {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"qty7",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                      {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"avg7",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                      {Type:"Text",      Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"rate7",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 },
		                      {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"qty8",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                      {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"avg8",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                      {Type:"Text",      Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"rate8",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 },
		                      {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"qty9",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                      {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"avg9",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                      {Type:"Text",      Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"rate9",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 },
		                      {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"qty10",         KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                      {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"avg10",         KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                      {Type:"Text",      Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"rate10",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 },
		                      {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"qty11",         KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                      {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"avg11",         KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                      {Type:"Text",      Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"rate11",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 },
		                      {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"qty12",         KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                      {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"avg12",         KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                      {Type:"Text",      Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"rate12",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 },
		                      {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"qty13",         KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                      {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"avg13",         KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                      {Type:"Text",      Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"rate13",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 },
		                      {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"qty14",         KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                      {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"avg14",         KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                      {Type:"Text",      Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"rate14",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 },
		                      {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"qty15",         KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                      {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"avg15",         KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                      {Type:"Text",      Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"rate15",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 },
		                      {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"lvl",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 }
		                      //{Type:"AutoSum",      Hidden:1, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 }
		                      ];
		               InitColumns(cols);
		               SetEditable(0);
		               SetSheetHeight(370);
		               //resizeSheet();
		               FrozenCols=5;
               }
            	   break;
         	}
    }
    // Sheet의 높이 자동으로 변경
    function resizeSheet(){
        for (i=0; i<sheetObjects.length; i++){
            ComResizeSheet(sheetObjects[i]);
        }
    }
	/**
     * handling process for Sheet
     */  
    function doActionIBSheet(sheetObj,formObj,sAction, cnmv_sts_cd , cnmv_sts_nm) {
    	//    	 sheetObj.ShowDebugMsg = false;
         switch(sAction) {
         	case IBSEARCH:      
         		if(!validateForm(sheetObj,formObj,sAction)) return;
	            //sheetObj.RenderSheet(0);
    			setParamValue();	//setting initial options when retrieving detail popup
         		setHeaderOver(form,sheetObj,4);
         		sheetObj.SetCellValue(0,4,form.over_stay_days.value+" or Over");
         		sheetObj.SetCellValue(0,5,form.over_stay_days.value+" or Over");
         		sheetObj.SetCellValue(0,6,form.over_stay_days.value+" or Over");
	            formObj.f_cmd.value=SEARCH;
	            sheetObj.SetWaitImageVisible(0);
	            ComOpenWait(true); 
	            sheetObj.DoSearch("EES_CIM_0021GS.do",FormQueryString(formObj) );
	            
         		break;
         	case IBSEARCH01:    
         		sheetObj.SetWaitImageVisible(0);
    			form.f_cmd.value=SEARCH01;
    			var sXml=sheetObj.GetSearchData("EES_CIM_0021GS.do" , FormQueryString(form));
    			var cntr_tpsz_cd=ComGetEtcData(sXml,"cntr_tpsz_cd");	   //retrieving TP/SZ
    			tot_cntr_tpsz_cd=cntr_tpsz_cd;
    			var strCntrTpszCd=cntr_tpsz_cd.split("|");
    			//initializing multi Combo
    			with (combo_cntr_tpsz_cd) {
    				SetMultiSelect(1);
    				SetMultiSeparator(",");
    				SetDropHeight(330);
    				InsertItem(0 , 'ALL','');
    				for ( var i=1; i<=cntr_tpsz_cd.split("|").length; i++) {
    					InsertItem(i, strCntrTpszCd[i-1], strCntrTpszCd[i-1]);
    				}
    			} 
			 	//Lease Term
			 	var sLeaseTermNm=ComGetEtcData(sXml,"lease_term_nm");
			 	var sLeaseTermCd=ComGetEtcData(sXml,"lease_term_cd");
			 	var arrLeaseTermNm=sLeaseTermNm.split("|");
			 	var arrLeaseTermCd=sLeaseTermCd.split("|");
			 	tot_lstm_cd=arrLeaseTermCd;	 
			 	with (combo_lstm_cd) {
			 		SetMultiSelect(1);
			 		SetMultiSeparator(",");
			 		SetDropHeight(320);
			 		InsertItem(0 , 'ALL','');
			 		for ( var i=1; i<=arrLeaseTermCd.length; i++) {
			 			InsertItem(i, arrLeaseTermCd[i-1], arrLeaseTermNm[i-1]);
			 		}
			 	}
    			break; 
         	case IBSEARCH02:      //By Movement
         		if(!validateForm(sheetObj,formObj,sAction)) return;
         		//sheetObj.RenderSheet(0);
    			setParamValue();	//setting initial option when retrieving detail pop up
         		setHeaderOver(formObj,sheetObj,5);
         		sheetObj.SetCellValue(0,5,formObj.over_stay_days.value+" or Over");
         		sheetObj.SetCellValue(0,6,formObj.over_stay_days.value+" or Over");
         		sheetObj.SetCellValue(0,7,formObj.over_stay_days.value+" or Over");
	            sheetObj.SetWaitImageVisible(0);
	            ComOpenWait(true); 
	            formObj.f_cmd.value=SEARCH02;
	            sheetObj.DoSearch("EES_CIM_0021GS.do",FormQueryString(formObj) );
		        
         		break;    			
         	case IBSEARCH03:      //Total/Days
        		if ( beforetab == 2 ) {	  //retrieving third tab
             		if ( formObj.loc_type_code.value == '' || formObj.loc_type_code.value == '1') {
             			ComShowCodeMessage("CIM30009");	  
             			return;
             		}
        		}
         		if(!validateForm(sheetObj,formObj,sAction)) return;
         		//sheetObj.RenderSheet(0);
    			setParamValue();	//setting initial option when retrieving detail pop up
         		setHeaderOver(form,sheetObj,4);
	            sheetObj.SetWaitImageVisible(0);
	            ComOpenWait(true); 
	            formObj.f_cmd.value=SEARCH03;
	            sheetObj.DoSearch("EES_CIM_0021GS.do",FormQueryString(formObj) );
	            
         		break;    			
			case IBSEARCH04: //location focusOut
				var inquiryLevel="";
				if ( formObj.loc_type_code.value == 1 ) {
					inquiryLevel="R";
				} else if  ( formObj.loc_type_code.value == 2 ) {
					inquiryLevel="L";
				} else if  ( formObj.loc_type_code.value == 3 ) {
					inquiryLevel="L";
				} else if  ( formObj.loc_type_code.value == 4 ) {
					inquiryLevel="E";
				} else if  ( formObj.loc_type_code.value == 5 ) {
					inquiryLevel="S";
				} else if  ( formObj.loc_type_code.value == 6 ) {
					inquiryLevel="Y";
				}
				formObj.inquiryLevel.value=inquiryLevel;
				formObj.location.value=formObj.loc_cd.value;
				formObj.f_cmd.value=SEARCH04;
				if (formObj.loc_cd.value == "") {
					return false;
				}
				sheetObj.SetWaitImageVisible(0);
				var sXml=sheetObj.GetSearchData("EES_CIM_0021GS.do",FormQueryString(formObj));
				var sCheck=ComGetEtcData(sXml, "check");
				if (sCheck != "OK") {
					if (document.form.loc_cd.value != "") {
						if ( document.form.loc_type_code.value == '1' ) {
							ComShowCodeMessage("CIM30021","RCC");
						} else if ( document.form.loc_type_code.value == '2' ) {
							ComShowCodeMessage("CIM30021","LCC");
						} else if ( document.form.loc_type_code.value == '3' ) {
							ComShowCodeMessage("CIM30021","LCC");
						} else if ( document.form.loc_type_code.value == '4' ) {
							ComShowCodeMessage("CIM30021","ECC");
						} else if ( document.form.loc_type_code.value == '5' ) {
							ComShowCodeMessage("CIM30021","SCC");
						} else if ( document.form.loc_type_code.value == '6' ) {
							ComShowCodeMessage("CIM30021","Yard");
						}
						document.form.loc_cd.value="";
						ComSetFocus(document.form.loc_cd);
						return false;
					} else {
						ComSetFocus(document.form.loc_cd);
						return true;
					}
				} else {
					ComSetFocus(document.form.combo_cntr_tpsz_cd);
					return false;
				}
				break;         		
            case IBDOWNEXCEL:    
            	if ( sheetObj.RowCount() != 0 ) {
            		sheetObj.Down2Excel( { Merge:1, HiddenColumn :1 } );
            	} else {
            		ComShowMessage(msgs["CIM30008"]);	//No data found
            		return;
            	}
          	  	break;
         }
     }
    function setHeaderOver(form,sheetObj,cnt){
    	var str_loc_nm="";
 		if ( form.loc_type_code.value == "" ) {
 			str_loc_nm="RCC";
 		} else if ( form.loc_type_code.value == "1" ) {
 			str_loc_nm="LCC";
 		} else if ( form.loc_type_code.value == "2" ) {
 			str_loc_nm="ECC";
 		} else if ( form.loc_type_code.value == "3" ) {
 			str_loc_nm="SCC";
 		} else if ( form.loc_type_code.value == "4" ) {
 			str_loc_nm="SCC";
 		} else if ( form.loc_type_code.value == "5" ) {
 			str_loc_nm="Yard";
 		} else if ( form.loc_type_code.value == "6" ) {
 			str_loc_nm="Yard";
 		}
 		sheetObj.SetCellValue(0,0,str_loc_nm);
 		sheetObj.SetCellValue(1,0,str_loc_nm);
    }
    /**
     * registering IBTab Object as list
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     */
    function setTabObject(tab_obj){
    	tabObjects[tabCnt++]=tab_obj;
    }
    /**
     * initializing Tab
     * setting Tab items
     */
    function initTab(tabObj , tabNo) {
    	switch(tabNo) {
    	case 1:
    		with (tabObj) {
    			var cnt=0 ;
					InsertItem( "Summary" , "");
					InsertItem( "By Movement" , "");
					InsertItem( "Total S/Days" , "");
    		}
    		break;
    	 }
    }
    /**
     * event when clicking Tab
     * activating selected tab items
     */
    function tab1_OnChange(tabObj , nItem)
    {
        var objs=document.all.item("tabLayer");
     	objs[nItem].style.display="Inline";
     	for(var i = 0; i<objs.length; i++){
		    if(i != nItem){
		        objs[i].style.display="none";
		        objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
		   }
		}
     	resizeSheet();
     	beforetab=nItem;
    }
    /**
     * event when clicking Tab
     * retrieving selected tab data
     */
    function tab1_OnClick(tabObj , nItem)
    {
    	if ( nItem == 0 ) {
 		    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
     	} else if ( nItem == 1 ) {
 			doActionIBSheet(sheetObjects[1],document.form,IBSEARCH02);
     	} else if ( nItem == 2 ) {
 			doActionIBSheet(sheetObjects[2],document.form,IBSEARCH03);
     	}
     }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
    	with(formObj){
    	  	var formObject=document.form;
    	  	if ( doActionIBSheet(sheetObj, document.form, IBSEARCH04) ) {	//Location 유효성체크
     	        return false;
     	    } else {
	    	  	if(formObject.loc_type_code.value != "" && formObject.loc_cd.value == "") {
	    	  		ComShowMessage(msgs["CIM30002"]);	//Location Input is Mandatory.
	    	  		formObject.loc_cd.focus();
	    	  		return false;
	    	  	}
	    	  	if (!ComChkValid(formObj)) return false;
	    	  	return true;
     	    }
    	}
    	return true;
    }
    /**
     * event after retrieving Tab1
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg)
    {
    	ComOpenWait(false); 
    	if ( sheetObj.RowCount() != 0 ) {
    		with(sheetObj)
    		{
    			for(var i=1; i <= LastRow(); i ++)
    			{
    				var lvl=GetCellValue(i, "lvl");
    				if ( lvl == '01' ) {
    					sheetObj.SetRowBackColor(i,"#C9D5EB");
    				}
    			}
    			
    			sheetObj.SetRowBackColor(sheetObj.LastRow(),"#F7E1EC");
    			sheetObj.SetRangeFontBold(sheetObj.LastRow(), 0, sheetObj.LastRow(), sheetObj.LastCol(), 1);
    			sheetObj.SetRangeFontColor(sheetObj.LastRow(), 0, sheetObj.LastRow(), sheetObj.LastCol(), "#FF0000");
    			//sheetObj.RowDelete(sheetObj.LastRow()-1 , false);
    			sheetObj.SetMergeCell(sheetObj.LastRow(), 0, 1, 2);
    			sheetObj.SetCellValue(sheetObj.LastRow(),0,'G.Total');
    		}
    	}
    	//sheetObj.RenderSheet(1);
    	sheetObj.SetSelectRow(2,2);
    }
    /**
     * event after retrieving Tab2
     */
    function sheet2_OnSearchEnd(sheetObj, ErrMsg)
    {
    	ComOpenWait(false); 
    	if ( sheetObj.RowCount() != 0 ) {
    		with(sheetObj)
    		{
    			for(var i=1; i <= LastRow(); i ++)
    			{
    				var lvl=GetCellValue(i, "lvl");
    				if ( lvl == '001' || lvl=='101' ) {
    					sheetObj.SetRowBackColor(i,"#C9D5EB");
    				}
    			}
    			
    			sheetObj.SetRowBackColor(sheetObj.LastRow(),"#F7E1EC");
    			sheetObj.SetRangeFontBold(sheetObj.LastRow(), 0, sheetObj.LastRow(), sheetObj.LastCol(), 1);
    			sheetObj.SetRangeFontColor(sheetObj.LastRow(), 0, sheetObj.LastRow(), sheetObj.LastCol(), "#FF0000");
    			//sheetObj.RowDelete(sheetObj.LastRow()-1 , false);
    			sheetObj.SetMergeCell(sheetObj.LastRow(), 0, 1, 3);
    			sheetObj.SetCellValue(sheetObj.LastRow(),0,'G.Total');
    		}
    	}
    	
    	
    	//sheetObj.RenderSheet(1);
    	sheetObj.SetSelectRow(2,2);
    }
    /**
     * event after retrieving Tab3
     */
    function sheet3_OnSearchEnd(sheetObj, ErrMsg)
    {
    	ComOpenWait(false); 
    	
    	if ( sheetObj.RowCount() != 0 ) {
    		with(sheetObj)
    		{
    			
    			for(var i=1; i <= LastRow(); i ++)
    			{
    				var lvl=GetCellValue(i, "lvl");
    				if ( lvl == '01' ) {
    					sheetObj.SetRowBackColor(i,"#C9D5EB");
    				}
    			}
    			
    			sheetObj.SetRowBackColor(sheetObj.LastRow(),"#F7E1EC");
    			sheetObj.SetRangeFontBold(sheetObj.LastRow(), 0, sheetObj.LastRow(), sheetObj.LastCol(), 1);
    			sheetObj.SetRangeFontColor(sheetObj.LastRow(), 0, sheetObj.LastRow(), sheetObj.LastCol(), "#FF0000");
    			//sheetObj.RowDelete(sheetObj.LastRow()-1 , false);
    			sheetObj.SetMergeCell(sheetObj.LastRow(), 0, 1, 2);
    			sheetObj.SetCellValue(sheetObj.LastRow(),0,'G.Total');
    		}
    	}
        var loc_cd=document.form.loc_cd.value.substr(0,2);
        var usViewFlag=true;
        if ( loc_cd == 'US' ) {
        	usViewFlag=false;
        }
		viewUsData( usViewFlag ) ;
    	//sheetObj.RenderSheet(1);
    	sheetObj.SetSelectRow(2,2);
    }    
    /**
     * setting selected value from Location by loc_cd popup
     */
    function popupFinish(aryPopupData, row, col, sheetIdx){
    	var sheetObject=sheetObjects[0];
        var formObject=document.form;
        formObject.loc_cd.value=aryPopupData[0][3] 
    }
    /**
     * event when clicking cell
     * setting background color for selected row
     */
    function sheet1_OnClick(sheetObj, row, col, value) {
     //no support[implemented common]CLT 	sheetObj.SelectHighLight=true;
    }
    /**
     * event when clicking cell
     * setting background color for selected row
     */
    function sheet2_OnClick(sheetObj, row, col, value) {
     //no support[implemented common]CLT 	sheetObj.SelectHighLight=true;
    }
    /**
     * event when clicking cell
     * setting background color for selected row
     */
    function sheet3_OnClick(sheetObj, row, col, value) {
     //no support[implemented common]CLT 	sheetObj.SelectHighLight=true;
    }    
    /*
    function combo_cntr_tpsz_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
    	combo_cntr_tpsz_cd_text.value = newCode;
    }
   
    function combo_cntr_tpsz_cd_OnBlur(comboObj) {
	   combo_cntr_tpsz_cd_text.value = comboObj.GetSelectCode();
    }
   
    function combo_cnmv_sts_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
    	combo_cnmv_sts_cd_text.value = newCode;
    }
   
    function combo_cnmv_sts_cd_OnBlur(comboObj) {
	   combo_cnmv_sts_cd_text.value = comboObj.GetSelectCode();
    }
    
    function combo_lstm_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
    	combo_lstm_cd_text.value = newCode;
    }
   
    function combo_lstm_cd_OnBlur(comboObj) {
	   combo_lstm_cd_text.value = comboObj.GetSelectCode();
    }
    */