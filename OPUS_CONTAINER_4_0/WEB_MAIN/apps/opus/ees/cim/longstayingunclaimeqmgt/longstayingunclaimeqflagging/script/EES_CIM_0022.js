﻿/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CIM_0022.js
*@FileTitle  : Container Staying Days (Summary)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/16
=========================================================*/
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var IBSEARCH01=29;
var IBSEARCH02=30;
var tot_cntr_tpsz_cd="";
var tot_cnmv_sts_cd="";
var comboObjects=new Array();
var comboCnt=0 ;
var pendingFalg=false;
var focCntrTpszCd="";
var focCnmvStsCd="";
var focFullFlg="";
var focLocTypeCode="";
var focLocCd="";
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
						document.form.cntr_tpsz_cd.value=comboObjects[0].GetSelectCode();
						document.form.cnmv_sts_cd.value=comboObjects[1].GetSelectCode();
						
						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
						break;
					case "btn_loc_cd":	//retrieving Location popup
		    	        var cnt_cd="";
		    	        var loc_cd="";
			            cnt_cd=formObject.loc_type_code.value;
			            loc_cd=formObject.loc_cd.value;
			            if ( formObject.loc_type_code.value != '' ) {	
		        			var loc_code="";
		        			if ( form.loc_type_code.value == "1" ) {
		        				loc_code="rcc_cd";
		        			} else if ( form.loc_type_code.value == "2" ) {
		        				loc_code="ecc_cd";
		        			} else if ( form.loc_type_code.value == "3" ) {
		        				loc_code="scc_cd";
		        			}
							var param="?cnt_cd="+cnt_cd+"&loc_cd="+loc_cd;
							ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 1000, 456, loc_code+":loc_cd", "0,1,1,1,1,1", true);
			            }
						break; 	
					case "search_cust_cd":
						ComOpenPopupWithTarget('/opuscntr/COM_ENS_041.do', 770, 490, "cust_cd:cust_cd", '1,0,1,1,1,1,1,1,1,1', true);
						break; 	
					case "search_rep_cmdt_cd":
						ComOpenPopupWithTarget('/opuscntr/COM_ENS_011.do', 770, 440, "3:rep_cmdt_nm|2:rep_cmdt_cd", '0,0,1,1,1,1,1', true);
						break; 	
					case "btn_New":
						formObject.reset();
						sheet1.SetWaitImageVisible(0);
						sheet1.SetColHidden("uc_flg",0);
						sheet1.SetColHidden("uclm_dt",0);
					    comboObjects[0].SetSelectText("");
					    comboObjects[1].SetSelectText("");
						sheet1.RemoveAll();
					    break;
					case "btn_Save":
						doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
						break;
		            case "btn_DownExcel":
		            	doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
		                break;
		            case "btn_SelectAll":
		            	if ( pendingFalg ) {
		            		pendingFalg=false;
		            	} else {
		            		pendingFalg=true;
		            	}
		            	for ( var i=1; i<=sheetObjects[0].RowCount(); i++ ) {
		            		if ( sheetObjects[0].GetCellValue(i,"uc_flg") ==0 ) {
			            		if ( pendingFalg ) {
			            			sheetObjects[0].SetCellValue(i,"ls_flg",1);
			            		} else {
			            			sheetObjects[0].SetCellValue(i,"ls_flg",0);
			            		}
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
			                                    , "EES_CTM_0408", 1020, 682);						
						}
						break;		                
	                case "btn_Close":
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
    function loadPage( cnmv_sts_cd, cnmv_sts_nm, cntrTpszCd, cnmvStsCd, fullFlg, locTypeCode, locCd ) {
        for(i=0;i<sheetObjects.length;i++){
             ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
	    for(p=0;p< comboObjects.length;p++){
		       initCombo (comboObjects[p],p+1);
		} 
        initControl();
        makeCnmvStsInfo(cnmv_sts_cd , cnmv_sts_nm);
        focCntrTpszCd=cntrTpszCd;
        focCnmvStsCd=cnmvStsCd;
        focFullFlg=fullFlg;
        focLocTypeCode=locTypeCode;
        focLocCd=locCd;
        sheet1_OnLoadFinish(sheetObjects[0]);
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
    function sheet1_OnLoadFinish(sheetObj) {
    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH01); //TP/SZ,MVMT Status,Lease Term 데이타 가져오기
    	ComSetFocus(document.form.loc_cd);
    	document.getElementById("bkg_bl_type_cd").setAttribute("maxLength",13);
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
    /**
     * registering initial event 
     */
    function initControl() {
		axon_event.addListener('change', 'bkg_bl_type_code_change', 'bkg_bl_type_code');	
    	axon_event.addListenerFormat('beforeactivate', 'obj_activate', form); 				
    	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form); 			
    	axon_event.addListener('blur', 'obj_blur', 'loc_cd');
        axon_event.addListener('change', 'loc_type_code_onchange', 'loc_type_code');		//handling event when changing Location by 
    }
	/**
     * handlig TP/SZ click event
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
	* handling LOC_CD keyup event
	*/
    function loc_cd_onkeyUp() {
        var formObject=document.form;
        if ( (event.keyCode < 37 || event.keyCode >40) && event.keyCode != 16 ) {
            document.getElementById("loc_cd").setAttribute("maxLength",5);
    	    if ( formObject.loc_cd.value.length == 5 ) {
    	    	ComSetFocus(document.form.over_stay_days);
    	    }
	        formObject.loc_cd.value=formObject.loc_cd.value.toUpperCase();
        }
    }
    /**
     * handling event when changing Location by 
     * deactivating input column in case of ALL (by RCC) 
     * activatin the others
     */
    function loc_type_code_onchange() {
    	var formObject=document.form;
//        formObject.loc_cd.value = "";
        ComSetFocus(document.form.loc_cd);
    }
	/**
	 * handling Location  blur event
	 * validating Location code
	 */	
	function obj_blur() {
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH02);
	}
    /**
     * list of key event
     */
 	function obj_keypress() {
		var formObject=document.form;
		switch (ComGetEvent("name")) {
			case "loc_cd":
				ComKeyOnlyAlphabet('uppernum');// upper case, numbers onlypper case, numbers only
				break;
			case "cust_cd":
				ComKeyOnlyAlphabet('uppernum');// upper case, numbers only
				break;
			case "bkg_bl_type_cd":
				ComKeyOnlyAlphabet('uppernum');// upper case, numbers only
				break;
			case "over_stay_days":
				ComKeyOnlyNumber(ComGetEvent());// upper case, numbers only
				break;
		}
	} 
    /**
     * handling key up event
     */ 	
 	function obj_keyup() {
		var formObject=document.form;
		if ( formObject.rep_cmdt_nm.value =='' ) {
			formObject.rep_cmdt_cd.value='';
		}
	}  	
    /**
     * handling beforeactivate event
     */    
  	function obj_activate() {
  		ComClearSeparator(ComGetEvent());
  	}
      /**
  	* handling Period to  beforedeactivate event
  	* YYYY-MM format
  	*/	
  	function obj_deactivate() {
  		ComClearSeparator(ComGetEvent());
  	}
     /**
      * handling event when changing BKG.NO,B/L NO,CNTR_NO 
      */   
     function bkg_bl_type_code_change() {
         var formObject=document.form;
         if ( formObject.bkg_bl_type_code.value == 'bkg' ) {
        	 document.getElementById("bkg_bl_type_cd").setAttribute("maxLength",13);
         } else if ( formObject.bkg_bl_type_code.value == 'bl' ) {
        	 document.getElementById("bkg_bl_type_cd").setAttribute("maxLength",12);
         } else if ( formObject.bkg_bl_type_code.value == 'cntr' ) {
        	 document.getElementById("bkg_bl_type_cd").setAttribute("maxLength",11);
         }
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
                with (sheetObj) { 
                var HeadTitle1="|Seq.|CNTR No.|TP/SZ|MVMT|Yard|BKG No.|B/L No.|Event Date|S.Days|L/S|U/C|U/C Date|F.Days|F/T End Date|Act S.Ds|Reason|Plan/Progress|Contact Point|SHPR|CNEE|NTFY|CMDT|CMDT(Customs)|Lane|VVD|Sales OFC|DMG|DMG Flg DT|DMG Unflg DT|DISP|User ID|Update Date(S)|||||||||";
                var headCount=ComCountHeadTitle(HeadTitle1);
                SetConfig( { SearchMode:2, FrozenCol:8, MergeSheet:5, Page:20, DataRowMerge:1 } );
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
                InitHeaders(headers, info);
                var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                          {Type:"Seq",       Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                          {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"cntr_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                          {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                          {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cnmv_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                          {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"crnt_yd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                          {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                          {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:0,   SaveName:"bl_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                          {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cnmv_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd" },
                          {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"stay_days",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                          {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ls_flg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                          {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"uc_flg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                          {Type:"Date",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:"uclm_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                          {Type:"Int",       Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:"ft_dys",            KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                          {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"ft_end_dt",         KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                          {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"act_dys",           KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                          {Type:"Combo",   	 Hidden:0,  Width:140,  Align:"Left",    ColMerge:0,   SaveName:"uclm_rsn",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:200 },
                          {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"uclm_pln_rmk",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:200 },
                          {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"uclm_cntc_pnt_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
                          {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"shpr",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                          {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"cnee",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                          {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"ntfy",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                          {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"rep_cmdt_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                          {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"mk_desc",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                          {Type:"Text",      Hidden:1, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"vsl_slan_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                          {Type:"Text",      Hidden:1,  Width:70,   Align:"Left",    ColMerge:0,   SaveName:"vvd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                          {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"ob_sls_ofc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                          {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"dmg_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                          {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"dmg_flg_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                          {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"dmg_unflg_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                          
                          
                          {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"disp_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                          {Type:"Text",      Hidden:0, Width:80,   Align:"Left",    ColMerge:0,   SaveName:"upd_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                          {Type:"Text",      Hidden:0, Width:180,   Align:"Center",  ColMerge:0,   SaveName:"upd_dt",            KeyField:0,   CalcLogic:"",   Format:"",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                          {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cnmv_yr",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                          {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cnmv_id_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                          {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cnmv_gmt_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                          {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"uclm_free_dys",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                          {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"uclm_end_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                          {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"full_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                          {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"temp_uclm_rsn",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                          {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"org_ls_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                          {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"org_uc_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
                 
                InitColumns(cols);
                //SetSheetHeight(402);
                resizeSheet();
                SetEditable(1);
                SetEditableColorDiff(0);
                InitComboNoMatchText(true,"");
                //FrozenCols=8;
                var itemPlus = "|Warehouse Working Delay, under pushing|Confiscated by Customs|Documentation Clearance Problems|Free time Extention|Unclaimed Cargo|Consignee/ Notifier Bankruptcy|Will be delivered soon|Others";
        		sheetObj.SetColProperty("uclm_rsn", {ComboText:itemPlus, ComboCode:itemPlus} );
                }
                
                break;
        }
    }
    // Sheet의 높이 자동으로 변경
    function resizeSheet(){
        ComResizeSheet(sheetObjects[0]);
    }
    /**
     * handling process for Sheet
     */    
    function doActionIBSheet(sheetObj,formObj,sAction) {
      //  sheetObj.ShowDebugMsg(false);
        switch(sAction) {
        	case IBSEARCH:   
         		if(!validateForm(sheetObj,formObj,sAction)) return;
         		sheetObj.SetWaitImageVisible(0);
         		ComOpenWait(true); 
         		//sheetObj.RenderSheet(0);
	            formObj.f_cmd.value=SEARCH;
 		        sheetObj.DoSearch("EES_CIM_0022GS.do",FormQueryString(formObj) );
		        
         		break;
        	case IBSEARCH01:     
         		sheetObj.SetWaitImageVisible(0);
    			form.f_cmd.value=SEARCH01;
     			var sXml=sheetObj.GetSearchData("EES_CIM_0022GS.do" , FormQueryString(form));
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
    	        if ( focCntrTpszCd != '' ) {
    	        	comboObjects[0].SetSelectCode(focCntrTpszCd);
    	        }
    	        if ( focCnmvStsCd != '' ) {
    	        	comboObjects[1].SetSelectCode(focCnmvStsCd);
    	        }
    	        if ( focFullFlg != '' ) {
    	        	document.form.full_flg.value=focFullFlg;
    	        }
    	        if ( focLocTypeCode != '' ) {
    	        	document.form.loc_type_code.value=focLocTypeCode;
    	        }
    	        if ( focLocTypeCode != '' ) {
    	        	document.form.loc_cd.value=focLocCd;
    	        }
    			break; 
        	case IBSEARCH02:      //validating location cd
				var inquiryLevel="";
				if ( formObj.loc_type_code.value == '1') {
					inquiryLevel="L";
				} else if  ( formObj.loc_type_code.value == '2' ) {
					inquiryLevel="E";
				} else if  ( formObj.loc_type_code.value == '3' ) {
					inquiryLevel="S";
				} 
				formObj.inquiryLevel.value=inquiryLevel;
				formObj.location.value=formObj.loc_cd.value;
				formObj.f_cmd.value=SEARCH02;
				if (formObj.loc_cd.value == "") {
					return false;
				}
				sheetObj.SetWaitImageVisible(0);
 				var sXml=sheetObj.GetSearchData("EES_CIM_0022GS.do",FormQueryString(formObj));
				var sCheck=ComGetEtcData(sXml, "check");
				if (sCheck != "OK") {
					if (document.form.loc_cd.value != "") {
						ComShowCodeMessage("CIM30013","Location code");
						document.form.loc_cd.value="";
						ComSetFocus(document.form.loc_cd);
						return false;
					} else {
						ComSetFocus(document.form.loc_cd);
						return true;
					}
				} else {
					ComSetFocus(document.form.over_stay_days);
					return false;
				}
				break;	    			
			 case IBSAVE:       
				 var saveFlag=false;
			 	 if(!ComShowCodeConfirm("CIM00008")) return; 
				 for ( var i=0; i<=sheetObj.RowCount(); i++ ) {
					 if ( sheetObj.GetRowStatus(i) == "U" ) {
						 if ( sheetObj.GetCellValue(i,"org_ls_flg") != sheetObj.GetCellValue(i,"ls_flg")) {
							 if ( sheetObj.GetCellValue(i,"ls_flg") == 0 && sheetObj.GetCellValue(i,"uc_flg") == 0 ) {
								 ComShowCodeMessage("CIM30014","L/S or U/C"); 
								 sheetObj.SelectCell(i, "ls_flg", true);
								 return;
							 }
						 }
						 if ( sheetObj.GetCellValue(i,"org_uc_flg") == sheetObj.GetCellValue(i,"uc_flg")) {
							 if ( ComTrimAll(sheetObj.GetCellValue(i,"uclm_rsn")) != '') {
								 if ( sheetObj.GetCellValue(i,"ls_flg") == 0 && sheetObj.GetCellValue(i,"uc_flg") == 0 ) {
									 ComShowCodeMessage("CIM30014","L/S or U/C");
									 sheetObj.SelectCell(i, "ls_flg", true);
									 return;
								 } else {
									 if ( ComTrimAll(sheetObj.GetCellValue(i,"uclm_rsn")) == '') {
										 ComShowCodeMessage("CIM30022","'REASON'");
										 sheetObj.SelectCell(i, "uclm_rsn", true);
										 return;
									 }
								 }
							 } else {
								 ComShowCodeMessage("CIM30022","'REASON'");
								 sheetObj.SelectCell(i, "uclm_rsn", true);
								 return;
							 }	
						 }
						if ( ComTrimAll(sheetObj.GetCellValue(i,"uclm_rsn")) == '') {
							 ComShowCodeMessage("CIM30022","'REASON'");
							 sheetObj.SelectCell(i, "uclm_rsn", true);
							 return;
						 }
						sheetObj.SetCellValue(i,"org_ls_flg",sheetObj.GetCellValue(i,"ls_flg"),0);
						sheetObj.SetCellValue(i,"org_uc_flg",sheetObj.GetCellValue(i,"uc_flg"),0);
						saveFlag=true;
					 }	    	   
				 }
				 if(validateForm(sheetObj,formObj,sAction))
				 //if(saveFlag && !ComShowCodeConfirm("CIM00008")) return; 
				 if (!saveFlag)  return; 
				 formObj.f_cmd.value=MULTI;
				 sheetObj.DoSave("EES_CIM_0022GS.do",FormQueryString(formObj),"ibflag",false);
				 break;
			case IBDOWNEXCEL:     
				if(sheetObj.RowCount() < 1){//no data
        			ComShowCodeMessage("COM132501");
        		}else{
        			sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(				sheetObj), SheetDesign:1,Merge:1 });
        		}
				break;
        }
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
     	    if ( doActionIBSheet(sheetObjects[0], document.form, IBSEARCH02) ) {	//Location 유효성체크
     	        return false;
     	    } else {
     	    	if (!ComChkValid(formObj)) return false;
     	    }
        }
        return true;
    }
    /**
     * event when clicking sheet1
     */
    function sheet1_OnClick(sheetObj, row, col, value) {
    	switch (sheetObj.ColSaveName(col)) {
    		case "uclm_rsn" :	    			
    			break;
    		case "uclm_pln_rmk" :	
    			ComShowMemoPad(sheetObj,row,col,false,300,200);
    			break;
    		case "ls_flg" :	
    			if ( sheetObj.GetCellValue(row,"ls_flg") == 0  ) {
    				if ( ComTrimAll(sheetObj.GetCellValue(row,"uclm_dt")) != ''  ) {
    					sheetObj.SetCellValue(row,"uclm_dt",'',0);
    				}
					sheetObj.SetCellEditable(row,"uclm_dt",0);
    			} else {
    				sheetObj.SetCellEditable(row,"uclm_dt",1);
				}
    			break;
    		case "uc_flg" :	
    			if ( sheetObj.GetCellValue(row,"uc_flg") == 0  ) {
					sheetObj.SetCellEditable(row,"uclm_dt",1);
				}
    			break;
    	}
    }
    /**
     * event when clicking sheet1
     */
    function sheet1_OnKeyDown(sheetObj, Row, Col, KeyCode, Shift) {
		if ( sheetObj.GetCellText(Row,Col) !='' ) {
	    	switch (sheetObj.ColSaveName(Col)) {
	    		case "uclm_rsn" :
    				sheetObj.SetToolTipText(Row,Col,sheetObj.GetCellText(Row,Col));
	                break;
	    		case "uclm_pln_rmk" :
    				sheetObj.SetToolTipText(Row,Col,sheetObj.GetCellText(Row,Col));
	                break;
	    		case "uclm_cntc_pnt_nm" :
    				sheetObj.SetToolTipText(Row,Col,sheetObj.GetCellText(Row,Col));
	                break;
	    	}
		}
    }
    /**
     * event when clicking sheet1
     */
    function sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift) {
    	switch (sheetObj.ColSaveName(Col)) {
    		case "uclm_dt" :
    			//alert("sheet1_OnKeyUp")
            	if ( sheetObj.GetEditText().length == 8 && ComIsDate(sheetObj.GetEditText()) ) {
            		sheetObj.SelectCell(Row, "uclm_rsn", true);
            	}    
            	break;
    	}
    }
    /**
     * when moving focus in sheet1 
     */
    function sheet1_OnSelectCell(OldRow, OldCol, NewRow, NewCol) {
    	if ( NewRow ==15 ) {	//uclm_rsn
    		//alert("sheet1_OnSelectCell")
//    		if (  document.form.param_full_flg.value == 'N' ) {
//    			if ( sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"uclm_rsn") != '' ) {
//					sheetObjects[0].CellComboItem(sheetObjects[0].SelectRow,"uclm_rsn", {ComboText:sheetObjects[0].GetCellValue(sheetObjects[0].SelectRow, ComboCode:"uclm_rsn")+"|Idling|Damaged|ForSale|ForOff-hire|ForDisposal|Others"} );
//				} else {
//					sheetObjects[0].CellComboItem(sheetObjects[0].SelectRow,"uclm_rsn", {ComboText:"|Idling|Damaged|ForSale|ForOff-hire|ForDisposal|Others", ComboCode:"|Idling|Damaged|ForSale|ForOff-hire|ForDisposal|Others"} );
//					sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(),"uclm_rsn",'');
//				}
//			} else if ( document.form.param_full_flg.value == 'Y' ) {
//				if ( sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"uclm_rsn") != '' ) {
//					sheetObjects[0].CellComboItem(sheetObjects[0].SelectRow,"uclm_rsn", {ComboText:sheetObjects[0].GetCellValue(sheetObjects[0].SelectRow, ComboCode:"uclm_rsn")+"|WarehouseWorkingDelay} );
//				} else {
//					sheetObjects[0].CellComboItem(sheetObjects[0].SelectRow,"uclm_rsn", {ComboText:"|WarehouseWorkingDelay, ComboCode:underpushing|ConfiscatedbyCustoms|DocumentationClearanceProblems|FreetimeExtention|UnclaimedCargo|Consignee/NotifierBankruptcy|Willbedeliveredsoon|Others"} );
//					sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(),"uclm_rsn",'');
//				}
//			}
    	}
    }
    /**
     * event when clicking sheet1 
     */
    function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) {
		Row=sheetObjects[0].MouseRow();
		Col=sheetObjects[0].MouseCol();
        var colSaveName=sheetObjects[0].ColSaveName(Col);
		if(colSaveName == "uclm_rsn") {
			sText=sheetObjects[0].GetCellText(Row,Col);
		} else {
			sText="";
		}
//no support[check again]CLT 		sheetObjects[0].MouseToolTipText=sText;	//풍선도움말 만들기
    }    
    
    /**
     * event when changing sheet1 combo
     */
    //function sheet1_OnComboChange(sheetObj,Row, Col, Code, Text) {
    //	if ( sheetObj.GetCellValue(Row,"uclm_rsn") == "Others" || sheetObj.GetCellValue(Row,"uclm_rsn") == "select") {
    //		sheetObj.SetCellText(Row, Col ,"");
    //	} else {
    //	}
    //}
    
    /**
     * handling process after retrieving screen
     */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
		ComOpenWait(false); 
		if ( document.form.uclm_ls_div_cd.value == 'P' ) {
			ComBtnEnable('btn_SelectAll');			
		} else {
			ComBtnDisable('btn_SelectAll');			
		}
//			sheetObj.SetColBackColor("ls_flg",sheetObj.WebColor2SysColor("#FFEAEA"));;
//			sheetObj.SetColBackColor("uc_flg",sheetObj.WebColor2SysColor("#FFEAEA"));
//			sheetObj.SetColBackColor("uclm_dt",sheetObj.WebColor2SysColor("#FFEAEA"));
//			sheetObj.SetColBackColor("uclm_rsn",sheetObj.WebColor2SysColor("#FFEAEA"));
//			sheetObj.SetColBackColor("uclm_pln_rmk",sheetObj.WebColor2SysColor("#FFEAEA"));
//			sheetObj.SetColBackColor("uclm_cntc_pnt_nm",sheetObj.WebColor2SysColor("#FFEAEA"));
		if ( document.form.full_flg.value == 'N' && document.form.uclm_ls_div_cd.value=='P' ) {
			sheetObj.SetColHidden("uc_flg",1);
			sheetObj.SetColHidden("uclm_dt",1);
		} else {
			sheetObj.SetColHidden("uc_flg",0);
			sheetObj.SetColHidden("uclm_dt",0);
		}
		document.form.param_full_flg.value=document.form.full_flg.value;
		sheetObj.RenderSheet(1);
	}
	
	 function sheet1_OnSaveEnd(sheetObj, ErrMsg){
         if (ErrMsg == "") {
             doActionIBSheet(sheetObj,document.form,IBSEARCH);
         } 
	  }
    /**
     * event when changing sheet1 value
     */
	function sheet1_OnChange(sheetObj, Row, Col, Val)
	{
		with(sheetObj)
		{
			var sName=ColSaveName(Col);
			switch(sName)
			{
				case "ls_flg":		// only one of L/S, U/C 
					SetCellValue(Row, "uclm_dt","");
					if (1 == Val) {
						if (document.form.param_full_flg.value == 'N'&& document.form.uclm_ls_div_cd.value=='C' ){
							SetCellValue(Row, "ls_flg",0,0);
						}else{
							SetCellValue(Row, "uc_flg",0,0);
							//sheetObj.SelectCell(Row, "uclm_rsn", true);
							sheet1_OnClick(sheetObj, Row, SaveNameCol("uclm_rsn"), GetCellValue(Row, "uclm_rsn"));
							sheetObj.SelectCell(Row, "uclm_rsn", true);
						}						
					} else {
						if ( sheetObj.GetCellValue(Row,"org_ls_flg") ==1 ) {
							SetCellValue(Row, "ls_flg",1,0);
							SetCellValue(Row, "uc_flg",0,0);
						}
					}
					break;
				case "uc_flg":		// only one of L/S, U/C 
					SetCellValue(Row, "uclm_dt","");
					
					var yyyymmdd=new Date();
	    	 	    var year=yyyymmdd.getFullYear();
	                var month=yyyymmdd.getMonth() + 1;  
	                var date=yyyymmdd.getDate();
	                
	                year=""+year;
	                month=""+month;
	                date=""+date;
	                
	                if(month.length == 1){
	                    month="0" + month;
	                }
	                
	                if(date.length == 1){
	                    date="0" + date;
	                }
	                
	                var localDate=year+month+date;
					if (1 == Val) {
						if (document.form.param_full_flg.value == 'N' ){
							if ( sheetObj.GetCellValue(Row,"org_uc_flg") ==0 ) {
								SetCellValue(Row, "uc_flg",0,0);
								ComShowCodeMessage("CIM29045");
							}else{
								SetCellValue(Row, "ls_flg",0,0);
								SetCellValue(Row, "uclm_dt",localDate);
							}
						}else{
							SetCellValue(Row, "ls_flg",0,0);
							sheetObj.SelectCell(Row, "uclm_dt", true);
							SetCellValue(Row, "uclm_dt",localDate);
						}
					} else {
						if ( sheetObj.GetCellValue(Row,"org_ls_flg") == 1 && sheetObj.GetCellValue(Row,"org_uc_flg") == 0 ) {
							if ( sheetObj.GetCellValue(Row,"uc_flg") == 0 ) {
								SetCellValue(Row, "uc_flg",1,0);
							}
						}
					}
					break;
			}
		}
	}

