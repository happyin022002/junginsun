/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CIM_0025.js
*@FileTitle  : Land Inventory With CNTR List
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/23 
=========================================================*/
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0 ;
	var head_cntr_tpsz_cd="";
	var headTitle="";
	var tot_cnmv_sts_cd="";
	var tot_lstm_cd="";
	var IBSEARCH01=29;
	var IBSEARCH02=30;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick(){
	     var shtCnt=0;
	     var sheetObject=sheetObjects[shtCnt++];
	     /*******************************************************/
	     var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			switch(srcName) {
				case "btn_Retrieve":
					sheetObjects[0].RemoveAll();
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;
		        case "btn_new":
		        	formObject.reset();
					comboObjects[0].SetSelectText('');
					comboObjects[1].SetSelectText('');
					comboObjects[2].SetSelectText('');
					sheetObjects[0].RemoveAll();
				    //document.form.view_flg[0].checked = true;
				    //view_flg_click(); 
				    setHeadData(sheetObjects[0])
//				    document.form.loc_cd.focus();
					break;
				case "btn_loc_cd":	//retrieving Location popup
	    	        var cnt_cd="";
	    	        var loc_cd="";
		            cnt_cd=formObject.loc_type_code.value;
		            loc_cd=formObject.loc_cd.value;
		            if ( formObject.loc_type_code.value != '0' ) {	
						if ( formObject.loc_type_code.value == '5' ) {	//yard
							var param="?cnt_cd="+cnt_cd+"&loc_cd="+loc_cd;
							ComOpenPopupWithTarget('/opuscntr/COM_ENS_061.do', 800, 480, "3:loc_cd", "1,0,1,1,1,1,1", true);
		           		} else {
		        			var loc_code="";
		        			if ( form.loc_type_code.value == "1" )  {
		        				loc_code="rcc_cd";
		        			} else if ( form.loc_type_code.value == "2" ) {
		        				loc_code="lcc_cd";
		        			} else if ( form.loc_type_code.value == "3" ) {
		        				loc_code="ecc_cd";
		        			} else if ( form.loc_type_code.value == "4" ) {
		        				loc_code="scc_cd";
		        			}
							var param="?cnt_cd="+cnt_cd+"&loc_cd="+loc_cd;
							ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 1000, 460, loc_code+":loc_cd", "0,1,1,1,1,1", true);		           		
		           		}
		            }
					break;
				case "btn_movement":
					if ( sheetObjects[0].RowCount()!= 0 ) {
						var cnmv_dt=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"cnmv_dt");
		                ComOpenWindowCenter("/opuscntr/EES_CTM_0408_POP.do?" +
		                		"p_cntrno=" 	+ sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"cntr_no").substring(0,10) + "&" +
		                		"check_digit=" 	+ sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"cntr_no").substring(10,11) + "&" +
		                		"ctnr_tpsz_cd=" + sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"cntr_tpsz_cd") + "&" +
		                                    "p_date1=" 		+ ComGetDateAdd(cnmv_dt, "M", -6, "-", true) + "&" +
		                                    "p_date2=" 		+ ComGetDateAdd(cnmv_dt, "M", 0, "-", true) + "&" +
		                                    "pop_mode=1"
		                                    ,"EES_CTM_0408", 1020, 682, false, 'yes');						
					}
					break;
				case "btn_bkginq":
					if ( sheetObjects[0].RowCount()!= 0 ) {
						var full_flg=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"bkg_cgo_tp_cd");
						if (full_flg == 'P'){
							ComOpenWindowCenter("/opuscntr/ESM_BKG_9425.do?" +
									"bkg_no="+ sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"bkg_no") + "&" +
									"pop_mode=1"
									,"ESM_BKG_9425", 1380, 650, false, 'yes');
						}else{ //2010.08.26 Link 수정 및 Popup Size수정 
							ComOpenWindowCenter("/opuscntr/ESM_BKG_0079_Q_POP.do?" +
									"bkg_no="+ sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"bkg_no") + "&" +
									"pop_mode=1"
									,"ESM_BKG_0079_Q", 1380, 680, false, 'yes');						
						}
					}
					break;
				case "btn_master":
					if ( sheetObjects[0].RowCount()!= 0 ) {
						var cntr_no=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"cntr_no");
						var cntr_no_len=cntr_no.length;
						if ( cntr_no_len > 10 ) {
							cntr_no=cntr_no.substring(0,10);
						} 
//						ComOpenPopup("/opuscntr/EES_MST_0019_POP.do?cntr_no="+cntr_no+"&popup_mode=Y",1100, 730, "", "1,0,1,1,1,1,1,1", true);
						ComOpenWindowCenter("/opuscntr/EES_MST_0019_POP.do?cntr_no="+cntr_no+"&popup_mode=Y","",1200, 750, false,'yes');
					}
					break;
				case "btn_downexcel":
					//doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
					sheetObjects[0].Down2Excel({DownCols: makeHiddenSkipCol(sheetObjects[0]), SheetDesign:1 , Merge:1 });
					break;
		        case "btn_print":
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
     * setting selected value from Location by loc_cd popup
    */
    function popupFinish(aryPopupData, row, col, sheetIdx){
        var sheetObject=sheetObjects[0];
        var formObject=document.form;
        formObject.loc_cd.value=aryPopupData[0][3] 
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
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function loadPage( cnmv_sts_cd, cnmv_sts_nm) {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        initControl();     	
        makeCnmvStsInfo(cnmv_sts_cd , cnmv_sts_nm);
//        document.form.loc_cd.focus();
        sheet1_OnLoadFinish(sheet1)
    } 
    /**
     * getting Period,HEAD,TPSZ data
     */
    function sheet1_OnLoadFinish(sheetObj) {
    	doActionIBSheet(sheetObj,document.form,IBSEARCH01); //getting Period,HEAD,TPSZ data
    	ComSetFocus(document.form.loc_cd);
    }
    /**
     * creating MVMT Status 
     */    
    function makeCnmvStsInfo(p_cnmv_sts_cd , p_cnmv_sts_nm) {
        //MVMT Status
        var arr_cnmv_sts_cd=p_cnmv_sts_cd.split("|");
        var arr_cnmv_sts_nm=p_cnmv_sts_nm.split("|");
        tot_cnmv_sts_cd=arr_cnmv_sts_cd;
        with (cnmv_sts_cd) {
        	SetMultiSelect(1);
            SetMultiSeparator(",");
            SetDropHeight(320);
        	InsertItem(0 , 'ALL','');
        	for ( var i=1; i<=arr_cnmv_sts_cd.length; i++) {
        		InsertItem(i, arr_cnmv_sts_cd[i-1], arr_cnmv_sts_nm[i-1]);
        	}
        } 
    }
    /**
     * registering initial event
     */
	function initControl() {
     	//axon_event.addListener('click', 'view_flg_click', 'view_flg');						//handling event when changing view 
     	axon_event.addListener('click', 'ts_cntr_behind_click', 'ts_cntr_behind');			//handling event when changing EQ-wise,BKG-wise
    	axon_event.addListenerFormat('beforeactivate', 'obj_activate', form); 				
    	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form); 			
    	axon_event.addListener('blur', 'obj_blur', 'loc_cd');
    	axon_event.addListener('change', 'loc_type_code_onchange', 'loc_type_code');	//handling event when changing Location by 
	}
	/**
     * handling event when clicking TP/SZ 
     */
    function cntr_tpsz_cd_OnCheckClick(comboObj, index, code) {
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
     * handling event when clicking MVMT Status
     */
    function cnmv_sts_cd_OnCheckClick(comboObj, index, code) {
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
     * event when clicking Lease Term  
     */    
    function lstm_cd_OnCheckClick(comboObj, index, code) {
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
    * event when changing Location by 
    * deactivating input column when selecting ALL (by RCC) 
    * activating the other
    */
    function loc_type_code_onchange() {
        var formObject=document.form;
//        formObject.loc_cd.value = "";
        ComSetFocus(document.form.loc_cd);
    }
    /**
     * handling Location  beforeactivate event
     */    
	function obj_activate() {
		ComClearSeparator(event.srcElement);
	}
	/**
	 * handling Location  beforedeactivate event
	 * YYYY-MM format
	 */	
	function obj_deactivate() {
		ComClearSeparator(event.srcElement);
		obj=event.srcElement;
	}
	/**
	 * handling Location  blur  event
	 * validating Location code
	 */	
	function obj_blur() {
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH02);
	}
    /**
	 * handling view_flg keyup event
	 */
    function view_flg_click() {
/*    	if ( document.form.view_flg[1].checked ) {
    		document.form.ts_cntr_behind.readOnly=false;
    		document.form.ts_cntr_behind.disabled=false;
    		document.form.ts_cntr_behind.className="input";
    		document.form.view_customer.checked=true;
    		document.form.view_commodity.checked=true;
    	} else {
*/
    		document.form.ts_cntr_behind.readOnly=false;
    		document.form.ts_cntr_behind.disabled=false;
    		document.form.ts_cntr_behind.checked=false;
    		document.form.ts_cntr_behind.className="input2";
    		document.form.next_vvd.disabled=true;
    		document.form.next_vvd.className="input2";
    		document.form.next_vvd.value="";    		
    		document.form.view_customer.checked=false;
    		document.form.view_commodity.checked=false;
//    	}
    }
    /**
	* event view_vvd click event
	* showing Load VVD, Disc VVD, POL ETD information by option
	*/	
    function view_vvd_click() {
    	if ( document.form.view_vvd.checked ) {
    		sheetObjects[0].SetColHidden("load_vvd",0);
    		sheetObjects[0].SetColHidden("disc_vvd",0);
    		sheetObjects[0].SetColHidden("pol_etd",0);
    	} else {
    		sheetObjects[0].SetColHidden("load_vvd",1);
    		sheetObjects[0].SetColHidden("disc_vvd",1);
    		sheetObjects[0].SetColHidden("pol_etd",1);
    	}
    }
    /**
	* handling view_customer click event
	* showing shpr cnee information by option
	*/	
    function view_customer_click() {
    	if ( document.form.view_customer.checked ) {
    		sheetObjects[0].SetColHidden("shpr",0);
    		sheetObjects[0].SetColHidden("cnee",0);
    	} else {
    		sheetObjects[0].SetColHidden("shpr",1);
    		sheetObjects[0].SetColHidden("cnee",1);
    	}
    }
    /**
	* handling view_commodity_click click event
	* showing rep_cmdt_nm information by option
	*/	
    function view_commodity_click() {
    	if ( document.form.view_commodity.checked ) {
    		sheetObjects[0].SetColHidden("rep_cmdt_nm",0);
    	} else {
    		sheetObjects[0].SetColHidden("rep_cmdt_nm",1);
    	}
    }
    /**
	* handling view_salesrep_click click event
	* showing rep_cmdt_nm information by option
	*/	
    function view_salesrep_click() {
    	if ( document.form.view_salesrep.checked ) {
    		sheetObjects[0].SetColHidden("ob_srep_cd",0);
    	} else {
    		sheetObjects[0].SetColHidden("ob_srep_cd",1);
    	}
    }
	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
    function initSheet(sheetObj,sheetNo,headTitle) {
        var cnt=0;
        switch(sheetNo) {
        	case 1:      //sheet1 init
        		with (sheetObj) {
        	    if (headTitle==null || headTitle =="") {
        	    headTitle="Seq.|Sub Loc.|Yard|CNTR No.|TP/SZ|MVMT|F/M|Event Date|S.Days|F.Days|R/D Term|BKG No.|B/L No.|POR|DEL|";
        	    headTitle += "Disc VVD|Load VVD|POL ETD|SC/RFA No|"
        	    headTitle += "SHPR|CNEE|CMDT|DMG|DMG Flg DT|DMG Unflg DT|Sales OFC|Sales Rep.|UC|MT";
        	    }
        	    var headCount=ComCountHeadTitle(headTitle);
        	    SetConfig( { SearchMode:2, FrozenCol:9, MergeSheet:5, Page:20, DataRowMerge:1 } );
        	    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
        	    var headers = [ { Text:headTitle, Align:"Center"} ];
        	    InitHeaders(headers, info);
        	    var cols = [ {Type:"Seq",       Hidden:0, Width:40,   Align:"Right",   ColMerge:1,   SaveName:"Seq",            KeyField:0,   CalcLogic:"",   Format:"" },
        	              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"sub_loc_cd",     KeyField:0,   CalcLogic:"",   Format:"" },
        	              {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"crnt_yd_cd",     KeyField:0,   CalcLogic:"",   Format:"" },
        	              {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",        KeyField:0,   CalcLogic:"",   Format:"" },
        	              {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",   KeyField:0,   CalcLogic:"",   Format:"" },
        	              {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cnmv_sts_cd",    KeyField:0,   CalcLogic:"",   Format:"" },
        	              {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"full_flg",       KeyField:0,   CalcLogic:"",   Format:"" },
        	              {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cnmv_dt",        KeyField:0,   CalcLogic:"",   Format:"" },
        	              {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"stay_days",      KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
        	              {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"free_days",      KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
        	              {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"de_term_cd",     KeyField:0,   CalcLogic:"",   Format:"" },
        	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",         KeyField:0,   CalcLogic:"",   Format:"" },
        	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bl_no",          KeyField:0,   CalcLogic:"",   Format:"" },
        	              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"por_cd",         KeyField:0,   CalcLogic:"",   Format:"" },
        	              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"del_cd",         KeyField:0,   CalcLogic:"",   Format:"" },
        	              {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"disc_vvd",       KeyField:0,   CalcLogic:"",   Format:"" },
        	              {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"load_vvd",       KeyField:0,   CalcLogic:"",   Format:"" },
        	              {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pol_etd",        KeyField:0,   CalcLogic:"",   Format:"" },
        	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"sc_rfa_no",      KeyField:0,   CalcLogic:"",   Format:"" },
        	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"shpr",           KeyField:0,   CalcLogic:"",   Format:"" },
        	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"cnee",           KeyField:0,   CalcLogic:"",   Format:"" },
        	              {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"rep_cmdt_nm",    KeyField:0,   CalcLogic:"",   Format:"" },
        	              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dmg_flg",        KeyField:0,   CalcLogic:"",   Format:"" },
        	              {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"dmg_flg_dt",     KeyField:0,   CalcLogic:"",   Format:"" },
        	              {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"dmg_unflg_dt",   KeyField:0,   CalcLogic:"",   Format:"" },
        	              {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ob_sls_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"" },
        	              {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ob_srep_cd",     KeyField:0,   CalcLogic:"",   Format:"" },
        	              {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"uclm_ls_flg",    KeyField:0,   CalcLogic:"",   Format:"" },
        	              {Type:"Text",      Hidden:1, Width:50,    Align:"Center",  ColMerge:0,   SaveName:"bkg_cgo_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"" } ];
        	    InitColumns(cols);
        	    //SetSheetHeight(340);
        	    resizeSheet();
        	    SetEditable(0);
               }
               break;
        }
    }
    // Sheet의 높이 자동으로 변경
    function resizeSheet(){
        ComResizeSheet(sheetObjects[0]);
    }
    /**
     * 시트 헤더 세팅
     * EQ-wise,BKG-wise에 체크 여부에 따른 헤더부분 변경
     */
    function setHeadData(sheetObj) {
	 	var headTitle="";
	 	var viewFlag="";
	 	var subLoc="";
	 	if ( document.form.loc_type_code.value == '1') {
	 		subLoc="LCC";
	 	} else if  ( document.form.loc_type_code.value == '2') {
	 		subLoc="SCC";
	 	} else if  ( document.form.loc_type_code.value == '3') {
	 		subLoc="SCC";
	 	} else if  ( document.form.loc_type_code.value == '4') {
	 		subLoc="SCC";
	 	} else if  ( document.form.loc_type_code.value == '5') {
	 		subLoc="SCC";
	 	}
        var strPolEtc='';
 		if (document.form.ts_cntr_behind.checked && (document.form.next_vvd.value == '' || document.form.next_vvd.value != '') ) {
 			strPolEtc='POL ATD';
 		} else if ( !document.form.ts_cntr_behind.checked && document.form.next_vvd.value == '' ) {
 			strPolEtc='POL ETD';
 		}
        if (headTitle==null || headTitle =="") {
            headTitle="Seq.|Sub Loc.|Yard|CNTR No.|TP/SZ|MVMT|F/M|Event Date|S.Days|F.Days|R/D Term|BKG No.|B/L No.|POR|DEL|";
            headTitle += "Disc VVD|Load VVD|"+strPolEtc+"|SC/RFA No|"     
            headTitle += "SHPR|CNEE|CMDT|DMG|DMG Flg DT|DMG Unflg DT|Sales OFC|Sales Rep.|UC|MT";
        }
//	 	sheet1.RenderSheet(0);
//	 	sheet1.RemoveAll();
        sheetObjects[0] = sheetObjects[0].Reset();
	 	initSheet(sheetObjects[0],1,headTitle);
//	 	sheet1.RenderSheet(1);
    }
    /**
     * handling process for Sheet
     */    
    function doActionIBSheet(sheetObj, formObj, sAction, cnmv_sts_cd , cnmv_sts_nm) {
//        sheetObj.ShowDebugMsg = false;  
        switch(sAction) {
	      	case IBSEARCH:    
	            if(!validateForm(sheetObjects[0],formObj,sAction)) return;
	            sheetObjects[0].SetWaitImageVisible(0);
	            ComOpenWait(true);
	            setTimeout( function () {
		            formObj.cnt_cd.value=formObj.loc_cd.value.substring(0,2);	  //US separator
		            setHeadData(sheetObjects[0]);	  // changing header by t/s check
		            view_vvd_click();
		            view_customer_click();
		            view_commodity_click(); 
		            view_salesrep_click(); 
		  	        formObj.f_cmd.value=SEARCH;
		  	        if ( formObj.speed.checked ) {
		  	        	sheetObjects[0].DoSearch("EES_CIM_0025GS.do",FormQueryString(formObj) );
		  	        } else {
		  	        	sheetObjects[0].DoSearch("EES_CIM_0025GS.do",FormQueryString(formObj), {Sync:2} );
		  	        }
		            ComOpenWait(false); 
	            } , 100);
	            break;
	       	case IBSEARCH01:      
	       		sheetObj.SetWaitImageVisible(0);
	           	form.f_cmd.value=SEARCH01;
 	           	var sXml=sheetObj.GetSearchData("EES_CIM_0025GS.do" , FormQueryString(form));
	           	//retrieving TP/SZ 
	           	var v_cntr_tpsz_cd=ComGetEtcData(sXml,"cntr_tpsz_cd");	   
	           	head_cntr_tpsz_cd=v_cntr_tpsz_cd;
	           	document.form.head_cntr_tpsz_cd.value=head_cntr_tpsz_cd;
	           	var strCntrTpszCd=v_cntr_tpsz_cd.split("|");
	           	with (cntr_tpsz_cd) {
	          	 	SetMultiSelect(1);
	          	 	SetMultiSeparator(",");
	          	 	SetDropHeight(330);
	          	 	InsertItem(0 , 'ALL','');
	          	 	for ( var i=1; i<=v_cntr_tpsz_cd.split("|").length; i++) {
	          	 		InsertItem(i, strCntrTpszCd[i-1], strCntrTpszCd[i-1]);
	          	 	}
	           	}                  
			 	//Lease Term
			 	var sLeaseTermNm=ComGetEtcData(sXml,"lease_term_nm");
			 	var sLeaseTermCd=ComGetEtcData(sXml,"lease_term_cd");
			 	var arrLeaseTermNm=sLeaseTermNm.split("|");
			 	var arrLeaseTermCd=sLeaseTermCd.split("|");
			 	tot_lstm_cd=arrLeaseTermCd;
			 	with (lstm_cd) {
			 		SetMultiSelect(1);
			 		SetMultiSeparator(",");
			 		SetDropHeight(320);
			 		InsertItem(0 , 'ALL','');
			 		for ( var i=1; i<=arrLeaseTermCd.length; i++) {
			 			InsertItem(i, arrLeaseTermCd[i-1], arrLeaseTermNm[i-1]);
			 		}
			 	}                     
			 	break;
			case IBSEARCH02: //location focusOut
				var inquiryLevel="";
				if ( formObj.loc_type_code.value == 2 ) {
					inquiryLevel="L";
				} else if  ( formObj.loc_type_code.value == 3 ) {
					inquiryLevel="E";
				} else if  ( formObj.loc_type_code.value == 4 ) {
					inquiryLevel="S";
				} else if  ( formObj.loc_type_code.value == 5 ) {
					inquiryLevel="Y";
				}
				formObj.inquiryLevel.value=inquiryLevel;
				formObj.location.value=formObj.loc_cd.value;
				formObj.f_cmd.value=SEARCH02;
				if (formObj.loc_cd.value == "") {
					return false;
				}
				sheetObj.SetWaitImageVisible(0);
 				var sXml=sheetObj.GetSearchData("EES_CIM_0025GS.do",FormQueryString(formObj));
				var sCheck=ComGetEtcData(sXml, "check");
				if (sCheck != "OK") {
					if (document.form.loc_cd.value != "") {
						ComShowCodeMessage("CIM29013");
						document.form.loc_cd.value="";
						ComSetFocus(document.form.loc_cd);
						return false;
					} else {
						return true;
					}
				} else {
					ComSetFocus(document.form.full_flg);
					return false;
				}
				break;
	   		case IBDOWNEXCEL:
	   			if(sheetObj.RowCount() < 1){//no data
	      			ComShowCodeMessage("COM132501");
	      		}else{
	      			sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(	   			sheetObj), SheetDesign:1,Merge:1 });
	      		}
	   			break;
        }
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
    	with(formObj){
    	  	var formObject=document.form;
    	  	if ( doActionIBSheet(sheetObjects[0], document.form, IBSEARCH02) ) {	//Location 유효성체크
//    	  		formObject.loc_cd.focus();
     	        return false;
     	    } else {
	    	  	if(formObject.loc_type_code.value != "" && formObject.loc_cd.value == "") {
	    	  		ComShowMessage(msgs["CIM30002"]);	//Location Input is Mandatory.
//	    	  		formObject.loc_cd.focus();
	    	  		return false;
	    	  	}
	    	  	if (!ComChkValid(formObj)) return false;
	    	  	return true;
     	    }
    	}
    	return true;
    }
    function ts_cntr_behind_click() {
    	if ( document.form.ts_cntr_behind.checked ) {
    		document.form.next_vvd.disabled=false;
    		document.form.next_vvd.className="input";
    		document.form.next_vvd.readOnly=false;
    	} else {
    		document.form.next_vvd.disabled=true;
    		document.form.next_vvd.readOnly=true;
    		document.form.next_vvd.className="input2";
    		document.form.next_vvd.value="";
    	}
    }

    function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
        ComOpenWait(false);
    }