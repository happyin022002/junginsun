/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   :  EES_CIM_0017.js
*@FileTitle  : Sea Inventory  
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/18
=========================================================*/
	// common global variables
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var polPodDelFlag="";
	var head_cntr_tpsz_cd="";
	var headTitle="";
	var tot_cnmv_sts_cd="";
	var tot_lstm_cd="";
	var comboObjects=new Array();
	var comboCnt=0 ;
	var IBSEARCH01=29;
	var IBSEARCH02=30;
	var IBSEARCH03=31;
	var IBSEARCH04=32;
	var appendPageNo = 1;
   	var appendCondParam = "";
   	var rtv_total = 0;
	/**
	 * @extends 
	 * @class ees_cim_0017 : business script for ees_cim_0017
	 */
	
	/* Event handler processing by button click event */
    document.onclick=processButtonClick;
    /* Event handler processing by button name */
    function processButtonClick(){
         var shtCnt=0;
         var sheetObject=sheetObjects[shtCnt++];
         var sheetObject=sheetObjects[shtCnt++]; 
         var sheetObject=sheetObjects[shtCnt++];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
				switch(srcName) {
					case "btn_Retrieve":
//						t1sheet1.RemoveAll();
//						t2sheet1.RemoveAll();
//						t3sheet1.RemoveAll();
						if ( beforetab == 0 ) {	  //retrieving first tab
							doActionIBSheet(t1sheet1,document.form,IBSEARCH);
						} else if ( beforetab == 1 ) {	//retrieving second tab
							doActionIBSheet(t2sheet1,document.form,IBSEARCH02);
						} else if ( beforetab == 2 ) {	//retrieving third tab
							doActionIBSheet(t3sheet1,document.form,IBSEARCH03);
						}
						break;
			        case "btn_new":
			        	formObject.reset();
						comboObjects[0].SetSelectCode('');
						comboObjects[1].SetSelectCode('');
						t1sheet1.RemoveAll();
						t2sheet1.RemoveAll();
						t3sheet1.RemoveAll();
						formObject.rstr_usg_lbl.value="";
						formObject.hid_rulabel_type.value="";
						document.form.head_cntr_tpsz_cd.value=head_cntr_tpsz_cd;
						
						form.ru_lable_type.options[0].selected = true;
						comboObjects[2].RemoveAll();
				        comboObjects[2].InsertItem(0 , 'ALL',''); 
				        
				        comboObjects[2].SetItemCheck(0,1);
				        comboObjects[2].SetEnable(1);
				        
				        tabObjects[0].SetSelectedIndex(0);
						break;
					case "btn_lane":	//retrieving Lane 
						var param='?mode=svc&lane_cd='+formObject.slan_cd.value+'&lane_nm=&svc_tp=&classId=';
						ComOpenPopup('/opuscntr/COM_ENS_081.do' + param , 1000, 410, 'getLineInfo', '1,0,1,1,1,1,1,1', true);
						break;
					case "btn_vvd":  	//retrieving  vvd
						ComOpenPopup('/opuscntr/COM_ENS_0B2.do', 780, 520, "getVvdInfo", '1,0,1,1,1,1,1,1', true);
						break;
					case "btns_pol_search":
						getPolPodDelInfo("POL");
						break;
					case "btns_pod_search":
						getPolPodDelInfo("POD");
						break;
					case "btn_rulabel_cd":	//RU Label 조회 팝업
						var par_rulabel_type = form.hid_rulabel_type.value;
						var par_rstr_usg_lbl = ComToHtml2(form.rstr_usg_lbl.value);
						var param="?par_rulabel_type="+par_rulabel_type+"&par_rstr_usg_lbl="+par_rstr_usg_lbl;
						var loc_code="";
						ComOpenPopup("/opuscntr/EES_MST_0054.do"+param, 460, 560, "", "1,0,1,1,1,1", true);		   
						break;
					case "btns_del_search":
						getPolPodDelInfo("DEL");
						break;
					case "btn_DownExcel":
						if ( beforetab == 0 ) {	  //retrieving first tab
							doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
						} else if ( beforetab == 1 ) {	//retrieving second tab
							doActionIBSheet(sheetObjects[1],formObject,IBDOWNEXCEL);
						} else if ( beforetab == 2 ) {	//retrieving third tab
							doActionIBSheet(sheetObjects[2],formObject,IBDOWNEXCEL);
						}
						break;
					case "btn_more":
		                doActionIBSheet1(sheetObjects[2], formObject, IBSEARCHAPPEND, appendCondParam, appendPageNo);
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
     * 인자로 받은 문자열 중 HTML에서 특수문자를 변환문자로 바꿔서 결과를 리턴한다. <br>
     * @param {string,object} obj   필수,문자열 또는 HTML태그(Object)
     * @returns string <br>
     */
    function ComToHtml2(obj){
        try {
            //첫번째 인자가 문자열 또는 HTML태그(Object)인 경우 처리
            var str = getArgValue(obj);

            str = str.replace(/&/gi, "@amp;");
            return str;
        } catch(err) { ComFuncErrMsg(err.message); }
    } 
    /**
     * calling popup for retrieving POL,POD,DEL information
     */
    function getPolPodDelInfo(flag) {
    	polPodDelFlag=flag;
		ComOpenPopup("/opuscntr/COM_ENS_051.do",755, 460, "popupFinish", "1,0,1,1,1,1,1,1", true);
    }
    /**
     * setting selected values from popup to POL,POD,DEL
     */
    function popupFinish(aryPopupData, row, col, sheetIdx){
        var formObject=document.form;
        if ( polPodDelFlag == 'POL' ) {
            formObject.pol_cd.value=aryPopupData[0][3] 
        } else if ( polPodDelFlag == 'POD' ) {
            formObject.pod_cd.value=aryPopupData[0][3] 
        } else if ( polPodDelFlag == 'DEL' ) {
            formObject.del_cd.value=aryPopupData[0][3]
        }
    }
    /**
     * getLineInfo 1
     */
    function getLineInfo(rowArray) {
        var colArray=rowArray[0];
        var formObject=document.form;
        formObject.slan_cd.value=colArray[3];
    }
  	/**
  	 * Vessel SKD & Code Inquiry
  	 * @param {arry} aryPopupData
  	 */
  	function getVvdInfo(aryPopupData) {
  		var formObject=document.form;
  		var vvd=aryPopupData[0][7];
  		if ( formObject.vvd1.value == ''  ) {
  	  		formObject.vvd1.value=vvd;
  		} else if  ( formObject.vvd2.value == ''  ) {
  	  		formObject.vvd2.value=vvd;
  		} else if  ( formObject.vvd3.value == ''  ) {
  	  		formObject.vvd3.value=vvd;
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
     * registering IBSheet Combo as list
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
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage( ) {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        resizeSheet();
        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
            tabObjects[k].SetSelectedIndex(0);
        }
        for(p=0;p< comboObjects.length;p++){
            initCombo (comboObjects[p],p+1);
        }
        ComBtnDisable("btn_more");
        sheet1_OnLoadFinish(sheetObjects[0]);
        
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH01); //getting data for combo TP/SZ,MVMT Status,Lease Term
	         
        comboObjects[2].RemoveAll();
        comboObjects[2].InsertItem(0 , 'ALL',''); 
        
        comboObjects[2].SetItemCheck(0,1);
        comboObjects[2].SetEnable(1);
	        
        
        initControl();     	
    }
    
    /**
     * registering initial event 
     */
	function initControl() {
//     	axon_event.addListener('keyup', 'cntr_no_onkeyUp', 'cntr_no');						//cntr_no keyup event
     	axon_event.addListener('click', 'pol_pod_wise_click', 'pol_pod_wise', '');			//when clicking POL-POD Pair View
//     	axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
//     	axon_event.addListenerFormat('keypress', 'obj_keypress'  , form);					
    	axon_event.addListenerFormat('beforeactivate', 'obj_activate', form); 					
    	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form); 		
    	axon_event.addListener('change', 'ru_lable_type_OnChange', 'ru_lable_type', '');
	}
    /**
     * key event 
     */
	
    /**
     * registering clicking TP/SZ event
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
     * registering clicking Lease Term event
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
     * regitsting event when focus in 
     */
	function obj_activate() {
		ComClearSeparator(ComGetEvent());
	}
	/**
	* handling when clicking POL-POD Pair View 
	* retrieving POL-POD Pair View by options
	*/ 
	function pol_pod_wise_click() {
//	   if ( document.form.pol_pod_wise[0].checked ) {
//		   curr_pol_pod_wise=document.form.pol_pod_wise[0].value;
//	   } else if ( document.form.pol_pod_wise[1].checked ) {
//		   curr_pol_pod_wise=document.form.pol_pod_wise[1].value;
//	   }
	   doActionIBSheet(sheetObjects[1],document.form,IBSEARCH02);
	}
    /**
    * handling event for cntr_no keyup
    * upper in case of cntr_no keyup
    */
    
    /**
    * setting sheet initial values and header
    * param : sheetObj, sheetNo
    * adding case as numbers of counting sheets
    */
    function initSheet(sheetObj,sheetNo,headTitle,viewFlag) {
        var cnt=0;
        var shtID=sheetObj.id;
        switch(sheetNo) {
            case 1:      //sheet1 init
                with (sheetObj) {
	                if (headTitle==null || headTitle =="") {
	                	headTitle="VVD|F/M|L/Term|Total|D2|D4|D5|D7|R2|R5|O2|O4|S2|S4|F2|F4|F5|A4|A2|R7|P2|P4|T2|T4|D8|D9|DW|DX";
	                }
	                var headCnt=ComCountHeadTitle(headTitle);
	                SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0 ,PrevColumnMergeMode:0} );
	                var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
	                var headers = [ { Text:headTitle, Align:"Center"} ];
	                InitHeaders(headers, info);
	                var cols = [ {Type:"Text",   Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vvd",        KeyField:0,   CalcLogic:"",   Format:"" },
		                       {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"division",   KeyField:0,   CalcLogic:"",   Format:"" },
		                       {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"lstm_cd",    KeyField:0,   CalcLogic:"",   Format:"" },
		                       {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"total_cnt",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" } ];
	                for(var i=1 ; i <= headCnt - 4 ; i++){
	                	cols.push({Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"qty"+i,      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
	                }
	                cols.push({Type:"AutoSum",   Hidden:1, Width:100,  Align:"Left",    ColMerge:1});
	                InitColumns(cols);
	                SetEditable(0);
	                sheetObj.FrozenCols=4;
	              //SetSheetHeight(320);
	                ComResizeSheet(sheetObj);
               }
               break;
            case 2:      //sheet2 init
                with (sheetObj) {
                if (headTitle==null || headTitle =="") {
                	headTitle="VVD|POL|ETD\nPOL|POD|ETA\nPOD|Total|D2|D4|D5|D7|R2|R5|O2|S2|O4|S4|F2|A2|F4|A4|F5|R7|P2|P4|T2|T4";
                }
                var headCnt=ComCountHeadTitle(headTitle);
                SetConfig( { SearchMode:2, MergeSheet:2, Page:20, DataRowMerge:0 ,PrevColumnMergeMode:0} );
                var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
                var headers = [ { Text:headTitle, Align:"Center"} ];
                InitHeaders(headers, info);
                var cols = [ {Type:"Text",   Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vvd",        KeyField:0,   CalcLogic:"",   Format:"" } ];
                if ( viewFlag == 'CHG') {
	                cols.push({Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"pod",        KeyField:0,   CalcLogic:"",   Format:"" });
	                cols.push({Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"eta_dt",     KeyField:0,   CalcLogic:"",   Format:"Ymd" });
	                cols.push({Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"pol",        KeyField:0,   CalcLogic:"",   Format:"" });
	                cols.push({Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"etd_dt",     KeyField:0,   CalcLogic:"",   Format:"Ymd" });
                } else {
	                cols.push({Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"pol",        KeyField:0,   CalcLogic:"",   Format:"" });
	                cols.push({Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"etd_dt",     KeyField:0,   CalcLogic:"",   Format:"Ymd" });
	                cols.push({Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"pod",        KeyField:0,   CalcLogic:"",   Format:"" });
	                cols.push({Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"eta_dt",     KeyField:0,   CalcLogic:"",   Format:"Ymd" });
                }
                cols.push({Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"total_cnt",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" });
                for(var i=1 ; i <= headCnt - 6 ; i++){
                	cols.push({Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"qty"+i,      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                }
                cols.push({Type:"AutoSum",   Hidden:1, Width:100,  Align:"Left",    ColMerge:1});
                InitColumns(cols);
                SetEditable(0);
                //SetSheetHeight(350);
                //resizeSheet();
                sheetObj.FrozenCols=6;
               }
               break;
            case 3:      //sheet3 init
                with (sheetObj) {
                var HeadTitle1="Seq.|VVD|CNTR No.|TP/SZ|F/M|Term|POL|Loading Date|POD|DEL|S. Days|Gross Weight(KG)|Tare Weight(KG)|Pay Load(KG)|BKG No|B/L No.|CMDT|RU Label Type|RU Label Value|Maker|Model No.|Unit Type|Humidity Control|CMDT(Customs)|DMG|DMG Flg DT|DMG Unflg DT|HRT|HBT|HBQ|DP|IM|AGMT No.|Lessor Code|Lessor";
                var headCount=ComCountHeadTitle(HeadTitle1);
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
                InitHeaders(headers, info);
                var cols = [ {Type:"Seq",       Hidden:0, Width:35,   Align:"Right",   ColMerge:1,   SaveName:"seq",                     KeyField:0,   CalcLogic:"",   Format:"" },
                       {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vvd",                     KeyField:0,   CalcLogic:"",   Format:"" },
                       {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",                 KeyField:0,   CalcLogic:"",   Format:"" },
                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",            KeyField:0,   CalcLogic:"",   Format:"" },
                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"full_flg",                KeyField:0,   CalcLogic:"",   Format:"" },
                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"lstm_cd",                 KeyField:0,   CalcLogic:"",   Format:"" },
                       {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",                  KeyField:0,   CalcLogic:"",   Format:"" },
                       {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cnmv_dt",                 KeyField:0,   CalcLogic:"",   Format:"" },
                       {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",                  KeyField:0,   CalcLogic:"",   Format:"" },
                       {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"del_cd",                  KeyField:0,   CalcLogic:"",   Format:"" },
                       {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"stay_days",               KeyField:0,   CalcLogic:"",   Format:"" },
                       {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_grs_wgt",            KeyField:0,   CalcLogic:"",   Format:"" },
                       {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"tare_wgt",                KeyField:0,   CalcLogic:"",   Format:"" },
                       {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"pay_load",                KeyField:0,   CalcLogic:"",   Format:"" },
                       {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",                  KeyField:0,   CalcLogic:"",   Format:"" },
                       {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:"bl_no",                   KeyField:0,   CalcLogic:"",   Format:"" },
                       {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"rep_cmdt_nm",             KeyField:0,   CalcLogic:"",   Format:"" },
                       //{Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"rstr_usg_lbl_nm",         KeyField:0,   CalcLogic:"",   Format:"" },
                       {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"rstr_usg_lbl_tp",         KeyField:0,   CalcLogic:"",   Format:"" },
                       {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"rstr_usg_lbl_desc",       KeyField:0,   CalcLogic:"",   Format:"" },
                       {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"rf_mkr_seq",         		KeyField:0,   CalcLogic:"",   Format:"" },
                       {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"rf_mdl_nm",         		KeyField:0,   CalcLogic:"",   Format:"" },
   	        	       {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"rf_tp_cd",                KeyField:0,   CalcLogic:"",   Format:"" },	        	    
                       {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"rf_humid_ctrl_val_cd",    KeyField:0,   CalcLogic:"",   Format:"" },
                       {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"mk_desc",                 KeyField:0,   CalcLogic:"",   Format:"" },
                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"dmg_flg",                 KeyField:0,   CalcLogic:"",   Format:"" },
                       {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"dmg_flg_dt",              KeyField:0,   CalcLogic:"",   Format:"" },
                       {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"dmg_unflg_dt",            KeyField:0,   CalcLogic:"",   Format:"" },
                       {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"cntr_hngr_rck_cd",        KeyField:0,   CalcLogic:"",   Format:"" },
                       {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"mnr_hngr_bar_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"" },
                       {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"cntr_hngr_bar_atch_knt",  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"disp_flg",                KeyField:0,   CalcLogic:"",   Format:"" },
                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"imdt_ext_flg",            KeyField:0,   CalcLogic:"",   Format:"" },
                       {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"agmt_no",                 KeyField:0,   CalcLogic:"",   Format:"" },
                       {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"lessor_cd",               KeyField:0,   CalcLogic:"",   Format:"" },
                       {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"lessor",                  KeyField:0,   CalcLogic:"",   Format:"" }];
                InitColumns(cols); 
                SetEditable(0);
                //SetSheetHeight(370);
                //resizeSheet();
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
    // handling process for Sheet
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
           	case IBSEARCH:     
	            if(!validateForm(sheetObj,formObj,sAction)) return;
	            sheetObj.SetWaitImageVisible(0);
	            ComOpenWait(true); 	            
	  	        formObj.f_cmd.value=SEARCH;
//	  	        sheetObj.RenderSheet(0);
//	  	        sheetObj.RemoveAll();
	  	        sheetObj.DoSearch("EES_CIM_0017GS.do",FormQueryString(formObj) );
		        
                break;
           	case IBSEARCH01:      
               	form.f_cmd.value=SEARCH01;
               	var sXml=sheetObj.GetSearchData("EES_CIM_0017GS.do" , FormQueryString(form));
               	//retrieving TP/SZ 
               	var cntr_tpsz_cd_data=ComGetEtcData(sXml,"cntr_tpsz_cd");	   
               	head_cntr_tpsz_cd=cntr_tpsz_cd_data;
               	document.form.head_cntr_tpsz_cd.value=head_cntr_tpsz_cd;
               	var strCntrTpszCd=cntr_tpsz_cd_data.split("|");
               	with (cntr_tpsz_cd) {
              	 	SetMultiSelect(1);
              	 	SetMultiSeparator(",");
              	 	SetDropHeight(330);
              	 	InsertItem(0 , 'ALL','');
              	 	for ( var i=1; i<=cntr_tpsz_cd_data.split("|").length; i++) {
              	 		InsertItem(i, strCntrTpszCd[i-1], strCntrTpszCd[i-1]);
              	 	}
               	}                  
   			 	var HeadTitle="VVD|F/M|L/Term|Total|"+head_cntr_tpsz_cd;
   			 	var HeadTitle2="VVD|POL|ETD\nPOL|POD|ETA\nPOD|Total|"+head_cntr_tpsz_cd;

   			 	t1sheet1.RemoveAll();
   			 	t1sheet1.RenderSheet(0);  			 	
   			 	sheetObjects[0] = t1sheet1.Reset();
   			 	initSheet(sheetObjects[0],1,HeadTitle);
   			 	sheetObjects[0].RenderSheet(1);
   			 	t2sheet1.RemoveAll();
   			 	t2sheet1.RenderSheet(0);
   			 	sheetObjects[1] = t2sheet1.Reset();
   			 	initSheet(sheetObjects[1],2,HeadTitle2);
   			 	sheetObjects[1].RenderSheet(1);
   			 	
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
           	case IBSEARCH02:     
            	if ( formObj.slan_cd.value.trim() == '' && formObj.vvd1.value == '' && formObj.vvd2.value == '' && formObj.vvd3.value == '' && formObj.pol_cd.value == '' && formObj.pod_cd.value == '' && formObj.del_cd.value == '' && formObj.rstr_usg_lbl.value == '') {
            		ComShowMessage(msgs["CIM30004"]);
            		return false;
            	}
	            if(!validateForm(sheetObj,formObj,sAction)) return;
   			 	var headTitle="";
   			 	var viewFlag="";
	   			 	if ( formObj.pol_pod_wise[0].checked == true ) {
	   			 		headTitle="VVD|POL|ETD\nPOL|POD|ETA\nPOD|Total|"+head_cntr_tpsz_cd;
	   			 	} else {
	   			 		headTitle="VVD|POD|ETA\nPOD|POL|ETD\nPOL|Total|"+head_cntr_tpsz_cd;
	   	   			 	viewFlag="CHG";
	   			 	}
	   			 sheetObj = sheetObj.Reset();
	             sheetObjects[1] = sheetObj;
	             initSheet(sheetObjects[1], 2, headTitle, viewFlag); 

	   			 t2sheet1.SetWaitImageVisible(0);
		         ComOpenWait(true); 	  	        
	   			 formObj.f_cmd.value=SEARCH02;
   			 	 t2sheet1.DoSearch("EES_CIM_0017GS.do",FormQueryString(formObj) );
                break;
           	case IBSEARCH03:    
         	   	if ( eval(formObj.stay_days.value) >= 60 ) {	//enable to search without check in case of over 60 days
         	   	} else {
	            	if ( formObj.slan_cd.value.trim() == '' && formObj.vvd1.value == '' && formObj.vvd2.value == '' && formObj.vvd3.value == '' && formObj.pol_cd.value == '' && formObj.pod_cd.value == '' && formObj.del_cd.value == '' && formObj.rstr_usg_lbl.value == '' ) {
	            		ComShowMessage(msgs["CIM30004"]);
	            		return false;
	            	}
         	   	}
	            if(!validateForm(sheetObj,formObj,sAction)) return;
	            sheetObj.SetWaitImageVisible(0);
	            ComOpenWait(true); 	  	        
	            // deciding CMDT option display by tab
	            view_commodity_click();
   			 	formObj.f_cmd.value=SEARCH03;
   			 	
   			 	rowTotal = 0;
				rtv_total=rowTotal;					
				if(Number(rowTotal) > formObj.pagerows.value) {
					ComBtnEnable("btn_more");
				}else{
					ComBtnDisable("btn_more");
				}
				
				appendPageNo=1;
				appendCondParam = FormQueryString(formObj);	
//
	  	        if ( formObj.speed.checked ) {
	  	        	sheetObj.DoSearchFx("EES_CIM_0017GS.do",FormQueryString(formObj) );
	  	        } else {
	  	        	sheetObj.DoSearch("EES_CIM_0017GS.do",FormQueryString(formObj) );
	  	        }
                break;                
            case IBDOWNEXCEL:      
				if ( beforetab == 0 || beforetab == 1 ) {	  
	            	if ( sheetObj.RowCount()> 1000 ) {
	            		sheetObj.Down2Excel({ HiddenColumn:true});
	            	} else {
	            		if(sheetObj.RowCount() < 1){//no data
	            			ComShowCodeMessage("COM132501");
	            			}else{
	            				sheetObj.Down2Excel({ HiddenColumn:-1,Merge:true});
	            			}
	            	}
				} else if ( beforetab == 2 ) {	//두번째 탭에서 조회.
					if(sheetObj.RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
						}else{
							sheetObj.Down2Excel({ HiddenColumn:true});
						}
				}
          	  	break;
            case IBSEARCH_ASYNC08:
				formObj.f_cmd.value=SEARCH01;
				var intgCdId='CD30029';
				var param="&intgCdId="+intgCdId;
				var xml=sheetObj.GetSearchData("EES_CIM_COMGS.do", FormQueryString(formObj)+param);
				var chk=xml.indexOf("ERROR");
				if (xml.indexOf("ERROR") != -1 || xml.indexOf("Error") != -1){
				   sheetObj.LoadSearchData(xml,{Sync:1} );
				   return;
			    } 
				if (xml != "") {
					var sCntrMtrlCdNm=ComGetEtcData(xml, "code_nm");
					var arrStr=sCntrMtrlCdNm.split("@");					
					var arrCode=arrStr[0].split("|");
					formObj.pagerows.value=arrCode[0];
				}
				break;
        }
    }
    
    
    /**
     * MultiSelect�띿꽦���댁슜�섎뒗 寃쎌슦, checking諛뺤뒪瑜��대┃�섎뒗 �쒓컙 諛쒖깮�쒕떎.
     * @return
     */
    function rstr_usg_lbl_OnCheckClick(comboObj, index, code) {
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
     * in case of onChange combo event    
     */
    function ru_lable_type_OnChange(){
    	var formObj = document.form;
    	
		var lblVal = formObj.ru_lable_type.value;
		comboOnChange(lblVal);
    }
    
    
    
    /**
     * handling in case of onChange combo event 
     * @param comboObj
     * @param Index_Code
     * @param Text
     * @return
     */   
    function comboOnChange(lblVal){ 	
    	var formObj=document.form;
    	comboObjects[2].RemoveAll();
    	//sheetObjects[1].WaitImageVisible=false;
        form.f_cmd.value=SEARCH02;
        var ruLabelType=lblVal;
    	var param="&ru_label_type="+ruLabelType;
    	var sXml=sheetObjects[0].GetSearchData("EES_MST_0051GS.do", FormQueryString(formObj)+param);
    	var chk=sXml.indexOf("ERROR");
    	if (sXml.indexOf("ERROR") != -1 || sXml.indexOf("Error") != -1){
    		 sheetObjects[0].LoadSearchData(sXml,{Sync:1} );
    		 return;
    	}	             
    	 
    	var rstr_usg_tblnm=ComGetEtcData(sXml,"rstr_usg_tblnm");
        var strRstrUsgTblNm=rstr_usg_tblnm.split("@");
         
        comboObjects[2].InsertItem(0 , 'ALL',''); 
        if(strRstrUsgTblNm.length >= 1) {
        	for ( var i=0; i<strRstrUsgTblNm.length; i++) {
        		 var arrCode=strRstrUsgTblNm[i].split("|");
        		 if(arrCode[0] != ""){
        			 comboObjects[2].InsertItem(i+1, arrCode[0], arrCode[0]);
        		 }
        	}	
        }
        comboObjects[2].SetItemCheck(0,1);
        comboObjects[2].SetEnable(1);
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
					InsertItem( "Inventory" , "");
					InsertItem( "POL-POD Pair" , "");
					InsertItem( "CNTR List" , "");
//					set
                }
             break;
         }
//         tabObj.SetSelectedIndex(0);
    }
    /**
     * event when clicking Tab
     * activating selected tab items
     */

    function tab1_OnChange(tabObj , nItem)
    {
        var objs = document.all.item("tabLayer");

    	objs[nItem].style.display = "Inline";
    	objs[beforetab].style.display = "none";

    	//--------------- important --------------------------//
    	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
    	//------------------------------------------------------//
    	beforetab= nItem;
    	

    	// activating CMDT, Speed options when clicking CNTR List in third tab	

		if (nItem ==2){
			show_add_info.style.display = "";
			hide_add_info.style.display = "none";
		}else{
			show_add_info.style.display = "none";
			hide_add_info.style.display = "";
		}
		
		resizeSheet();
		
    }
    /**
    * event when clicking Tab
    * retrieving data in selected tab
    */
    function tab1_OnClick(tabObj , nItem)
    {
    	if ( nItem == 0 ) {
		    doActionIBSheet(t1sheet1,document.form,IBSEARCH);
     	} else if ( nItem == 1 ) {	//when clicking POL-POD Pair tab
 			doActionIBSheet(t2sheet1,document.form,IBSEARCH02);
     	} else if ( nItem == 2 ) {	//when clicking CNTR List tab
 			doActionIBSheet(t3sheet1,document.form,IBSEARCH03);
     	}   
    }

    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
     	   	if (!ComChkValid(formObj)) return false;
     	   	
        }
        return true;
    }
    
    
    /**
     * end of retrieving Tab1 
     * calling event after retrieving Tab1
     */
	function t1sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
      	if ( sheetObj.RowCount()!= 0 ) {
	     	for(var i=1; i<=sheetObj.LastRow(); i++){
	     		if( sheetObj.GetCellValue(i,"division") == 'Total' && sheetObj.GetCellValue(i,"lstm_cd") == 'Total'){
	     			sheetObj.SetRowBackColor(i,"#C9D5EB");
	     		} 
	     		if( sheetObj.GetCellValue(i,"vvd") == 'Total' && sheetObj.GetCellValue(i,"division") == 'Total' ){
	     			sheetObj.SetRowBackColor(i,"#C9D5EB");
	     		} 
	     	}
		   	HeadTitleCnt=head_cntr_tpsz_cd.split("|").length+3
		   	for ( var j=0; j<=HeadTitleCnt; j++ ) {
		   		sheetObj.SetCellValue(sheetObj.LastRow(),j,sheetObj.GetCellValue(sheetObj.LastRow()-1, j),0);
			}
	    	sheetObj.SetRowBackColor(sheetObj.LastRow(),"#F7E1EC");
	     	sheetObj.SetRowHidden(sheetObj.LastRow()-1,1);
	     	sheetObj.SetCellValue(sheetObj.LastRow()-1,0,'G.Total');
	    	sheetObj.SetCellValue(sheetObj.LastRow(),0,'');
	    	sheetObj.SetCellValue(sheetObj.LastRow(),0,'G.Total');
	    	sheetObj.SetCellValue(sheetObj.LastRow(),2,'');
	    	sheetObj.SetCellAlign(sheetObj.LastRow(),1,"Center");
//	    	sheetObj.SetMergeCell(sheetObj.LastRow(), 0, 0, 3);
	    	sheetObj.SetMergeCell(sheetObj.LastRow(), 0, 1, 3);
     	}
      	ComOpenWait(false); 
      //no support[implemented common]CLT 	sheetObj.SelectHighLight=false;
    	//sheetObj.RenderSheet(1);
	}
	/**
     * end of retrieving Tab2 
     * calling event after retrieving Tab2
     */
	function t2sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
     	if ( sheetObj.RowCount()!= 0 ) {
	     	for(var i=1; i<=sheetObj.LastRow(); i++){
	     		if( sheetObj.GetCellValue(i,1) == 'Total' ){
	     			sheetObj.SetRowBackColor(i,"#C9D5EB");
	     			sheetObj.SetMergeCell(i, 1, 1, 3);
	     		} 
	     		if(sheetObj.GetCellValue(i,"pod") == "CHECK") {
	     			sheetObj.SetCellFontColor(i,"pod","#FF0000") ;
	     		}
	     	}
		   	HeadTitleCnt=head_cntr_tpsz_cd.split("|").length+3
		   	for ( var j=0; j<=HeadTitleCnt; j++ ) {
		   		sheetObj.SetCellValue(sheetObj.LastRow(),j,sheetObj.GetCellValue(sheetObj.LastRow()-1, j),0);
			}
	    	sheetObj.SetRowBackColor(sheetObj.LastRow(),"#F7E1EC");
	    	sheetObj.SetRowHidden(sheetObj.LastRow()-1,1);
	     	sheetObj.SetCellValue(sheetObj.LastRow()-1,0,'G.Total');
	    	sheetObj.SetCellValue(sheetObj.LastRow(),0,'');
	    	sheetObj.SetCellValue(sheetObj.LastRow(),0,'G.Total');
	    	sheetObj.SetCellValue(sheetObj.LastRow(),2,'');
	    	sheetObj.SetCellAlign(sheetObj.LastRow(),1,"Center");
	    	sheetObj.SetCellValue(sheetObj.LastRow(),3,'');
	    	sheetObj.SetCellValue(sheetObj.LastRow(),4,'');	    	
//	    	sheetObj.SetMergeCell(sheetObj.LastRow(), 0, 0, 3);
	    	sheetObj.SetMergeCell(sheetObj.LastRow(), 0, 1, 5);
     	}
     	ComOpenWait(false); 
     //no support[implemented common]CLT 	sheetObj.SelectHighLight=false;
    	//sheetObj.RenderSheet(1);
	}
	
	/**
	 * handling event in case of OnLoadFinish sheet1
	 */
    function sheet1_OnLoadFinish(sheetObj) {
		var formObj=document.form;
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC08); //페이징 갯수 가져오기
    }
	
	/**
     * end of retrieving Tab2 
     * calling event after retrieving Tab2
     */
	function t3sheet1_OnSearchEnd(sheetObj, ErrMsg){
		var formObj = document.form;
		if ( sheetObj.RowCount()!= 0 ) {
	     	for(var i=1; i<=sheetObj.LastRow(); i++){
	     		if(sheetObj.GetCellValue(i,"pod_cd") == "CHECK") {
	     			sheetObj.SetCellFontColor(i,"pod_cd","#FF0000") ;
	     		}
	     	}
     	}
     	
     	var lstTotal = sheetObj.GetEtcData("rtv_total");
    	if (sheetObj.RowCount()< lstTotal) {
            // setting page number for APPEND retrieving
            appendPageNo=Math.ceil(sheetObj.RowCount()/ formObj.pagerows.value) + 1;
            ComBtnEnable("btn_more");
        } else {
        	appendPageNo = 1;
            ComBtnDisable("btn_more");
        }		
     	ComOpenWait(false); 
	}
	
	/**
     * handling process for Sheet
     */    
    function doActionIBSheet1(sheetObj, formObj, sAction, CondParam, PageNo) {
    	switch(sAction) {
    	case IBSEARCHAPPEND:
    		if(!validateForm(sheetObj,formObj,sAction)) return;
            sheetObj.SetWaitImageVisible(0);
            ComOpenWait(true);     	
			sheetObj.SetWaitImageVisible(0);				
			sheetObj.DoSearch("EES_CIM_0017GS.do", CondParam+"&"+ "iPage="+ appendPageNo,{Append:true} );  	   
 			
			break;
    	}
    }
    
    /**
     * event when clicking cell
     * setting background color for selected row
     */
    function t1sheet1_OnClick(sheetObj, row, col, value) {
     //no support[implemented common]CLT 	sheetObj.SelectHighLight=true;
    }	
    /**
     * event when clicking cell
     * setting background color for selected row
     */
    function t2sheet1_OnClick(sheetObj, row, col, value) {
     //no support[implemented common]CLT 	sheetObj.SelectHighLight=true;
    }	
    /**
     * event when clicking cell
     * setting background color for selected row
     */
    function t3sheet1_OnClick(sheetObj, row, col, value) {
     //no support[implemented common]CLT 	sheetObj.SelectHighLight=true;
    }	    
    /**
	* handling view_commodity_click event
	*/	
    function view_commodity_click() {
    	if ( document.form.view_commodity.checked ) {
    		sheetObjects[2].SetColHidden("rep_cmdt_nm",0);
    		sheetObjects[2].SetColHidden("mk_desc",0);
    	} else {
    		sheetObjects[2].SetColHidden("rep_cmdt_nm",1);
    		sheetObjects[2].SetColHidden("mk_desc",1);
    	}
    }