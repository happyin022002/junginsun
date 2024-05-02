/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MST_0028.js
*@FileTitle  : Container Status Update  
*@author     : CLT
*@version    : 1.0
*@since      : 2014/  
=========================================================
*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   /**
     * @fileoverview 
     * @author 
     */
    /**
     * @extends 
     * @class ees_mst_0028 : business script for ees_mst_0028
     */
    function ees_mst_0028() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
		this.clearForm=clearForm;    
    }
    // common static variable
    var sheetObjects=new Array(); 
    var sheetCnt=0;
    var curdate=""; 
    var tmpdate="";
    var tmpagmtseq="";
    var IBSEARCH01=29;
    var IBSEARCH02=30;
    var Mincount1=0 ;
	var Mincount2=0 ; 
    var SEARCH_ENABLE=true;    
    var sel_sts_cd = "";
    var next_row = 0;
    var strXml = "";
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
    	var sheetObject1=sheetObjects[0];
     	var sheetObject2=sheetObjects[1];
     	/*******************************************************/
     	var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				break;
				case "New":
					formObject.cntr_no.value="";
					formObject.aciac_div_cd.value="";
					formObject.chk_dgt.value="";
					formObject.cntr_tpsz_cd.value="";
					formObject.lstm_cd.value="";
					formObject.cntr_tpsz_iso_cd.value="";
					formObject.ownr_co_cd.value="";
					formObject.cntr_use_co_cd.value="";
					formObject.cntr_use_co_cd.value="";
					sheetObject1.RemoveAll();
					sheetObject2.RemoveAll();
					formObject.chk_dgt.readOnly = true;
	               	formObject.chk_dgt.className="input";		
					ComSetFocus(formObject.cntr_no);
				break;
				case "Save":
					doActionIBSheet(sheetObject2,document.form,IBSAVE);
				break;
				case "Delete":
					doActionIBSheet(sheetObject2,document.form,IBDELETE);
				break;
				case "btn_minimize1":	//minimizing sheet 1
                    Mincount1=(Mincount1+1)%2 ;
                    MinimizeSheet1(Mincount1);
                    break;
                case "btn_minimize2":	//minimizing sheet 2
                    Mincount2=(Mincount2+1)%2 ;
                    MinimizeSheet2(Mincount2);
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
     * registering IBsheet Object as list
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
            ComConfigSheet(sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            sheetObjects[i].SetCountPosition(0);
            ComEndConfigSheet(sheetObjects[i]);
        }
        initControl();
        
        
        sheet1_OnLoadFinish();
    }
    
    
    function sheet1_OnLoadFinish() {
    	var formObj=document.form;
        var strCntrNo = "";
        strCntrNo = formObj.cntr_no.value;
        if(strCntrNo != "") {
        	formObj.cntr_no.value=formObj.cntr_no.value.toUpperCase();  // Copy&paste lower case to upper case
			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
			ComSetFocus(formObj.cntr_no);
        }
    }
    
 	// Axon handling event
 	// 1. event catch
 	function initControl() {
 		var formObj=document.form;
 	    axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); //- handling OnBeforeDeactivate event of all control except rdoCity
 	    axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form);            //- handling OnBeforeDeactivate event of all control that has dataformat attribute
 		// axon_event.addListenerFormat('keydown',	'obj_keydown',	form); //- when key down
 		// axon_event.addListener('keydown',	'ComKeyEnter',	    'form'); //- when key down
 		// axon_event.addListenerFormat('keyup',	'obj_keyup',	form); //- when key down
 		// axon_event.addListenerFormat('keypress','obj_keypress',	form); //- when key down
 		axon_event.addListenerForm('change',	'obj_change',	form); //- when object is changed.		 		
 		formObj.cntr_no.focus();
 	}      
 	//handling event deactivate
 	function obj_deactivate(){
 	    //ComChkObjValid(ComGetEvent());
 	}
 	function obj_activate(){
 	    //ComClearSeparator(ComGetEvent());
 	}	
   	/**
   	 * handling Key-Down Event 
   	 */
//  	function obj_keydown() {
//  		var obj=ComGetEvent();
//  		var vKeyCode=event.keyCode;
//  		var formObj=document.form;
//  		switch(ComGetEvent("name")) {
//			case "cntr_no":
//	  		if ( vKeyCode == 9 || vKeyCode == 13 ) {
//	  			SEARCH_ENABLE=false;
//	  			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
//	  			SEARCH_ENABLE=true;
//	  			ComSetFocus(formObj.cntr_no);	  			
//	  		}
//	  		break;
//		}	  		
//  	}
//   	function obj_keyup() {
//  		var obj=ComGetEvent();
//  		var vKeyCode=event.keyCode;
//  		var formObj=document.form;
//  		switch(ComGetEvent("name")) {
//  			case "cntr_no":
//				if ( ComTrim(ComGetObjValue(obj)) != "" ) {
//					ComKeyEnter('LengthNextFocus');
//				}
//				break;
//		}
//  	}  	 
//  	function obj_keypress(){
// 	    obj=ComGetEvent();
// 	    if(obj.dataformat == null) return;
// 	    window.defaultStatus=obj.dataformat;
// 	    switch(obj.dataformat) {
// 	        case "engup":
// 	            if(obj.name=="cntr_no") ComKeyOnlyAlphabet('uppernum');
// 	        break;
// 	    }        
// 	}
	/**
	 * handling event on change
	 */
	function obj_change(){
		var obj=ComGetEvent();
		var formObj=document.form;
		if ( ComTrim(ComGetObjValue(obj)) != "" ) {
			switch(ComGetEvent("name")) {
	    		case "cntr_no":
	    			if ( SEARCH_ENABLE ) {
	    				formObj.cntr_no.value=formObj.cntr_no.value.toUpperCase();  // Copy&paste lower case to upper case
	    				formObj.chk_dgt.value="";
	    				doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
	    				ComSetFocus(formObj.cntr_no);
	    			}
					break;	
	    		case "chk_dgt":
	    			if ( formObj.chk_dgt.value !="" ) {
	    				formObj.cntr_no.value=formObj.cntr_no.value.toUpperCase() + formObj.chk_dgt.value; // Copy&paste lower case to upper case
	    				doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
	    				ComSetFocus(formObj.cntr_no);
	    			}
					break;	
		    }
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
            case 1: // sheet1 init
                with(sheetObj){
		              var HeadTitle1="|Seq.|H|CYC|STS|Auto|Origin Yard|Return Yard|Input Yard|Event Date|Act|Remark(s)";
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		              var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		              InitHeaders(headers, info);
		              var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		                     {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq1" },
		                     {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cnmv_co_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cnmv_cyc_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"mvmt_sts_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"mvmt_cre_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"crnt_yd_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"dest_yd_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"inp_yd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"cnmv_evnt_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cntr_act_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cnmv_rmk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"cnmv_yr",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"cnmv_id_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		              InitColumns(cols);
		              SetEditable(0);
		              SetColProperty("cnmv_evnt_dt", {Format:"####-##-####:##"} );
		              SetSheetHeight(200);
              	}
                break;
                
		 case 2:    // sheet2 init
			    with(sheetObj){
			      var HeadTitle1="|Seq.|Del.|delt|agmt|date|cnmv_yr|cnmv_id_no|chk_fm|chk_to|pkup_fm|pkup_to|STS|ACT Date|Yard|AGMT No.|AGMT No.|Term|Contract No.|Lessor|Lessor Name|D/I Vendor|D/I Vendor Name|Office|Old/New|Pick Up Charge|Pick Up Credit|Min On-hire Days|Free Days|DII/DIO Fee|DOC Charge|DOC Credit|Handle On/Off Charge|Handle On/Off Charge|Term Change|Created Date|Update Date|Remark(s)|A|B|C|D|Prnt sts seq|Office Chk";
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			      var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			             {Type:"Seq",       Hidden:0, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"seq" },
			             {Type:"DelCheck",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"sel",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"delt_flg",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"agmt_flg",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"date_flg",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cnmv_yr",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cnmv_id_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"chk_fm_dt",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"chk_to_dt",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"pkup_fm_dt",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"pkup_to_dt",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_sts_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"PopupEdit", Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"cntr_sts_evnt_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"PopupEdit",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"yd_cd",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 ,   EditLen:7 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"agmt_cty_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"PopupEdit", Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"agmt_seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"lstm_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"ref_no",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"vndr_seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"vndr_lgl_eng_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"dir_itchg_vndr_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:0,    Align:"Left",    ColMerge:1,   SaveName:"dir_vndr_lgl_eng_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Popup",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ofc_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Combo",     Hidden:0, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cntr_old_van_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Float",     Hidden:0,  Width:0,    Align:"Right",   ColMerge:1,   SaveName:"cntr_pkup_chg_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
			             {Type:"Float",     Hidden:0,  Width:0,    Align:"Right",   ColMerge:1,   SaveName:"cntr_pkup_cr_chg_amt",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
			             {Type:"Int",       Hidden:0,  Width:0,    Align:"Right",   ColMerge:1,   SaveName:"cntr_min_onh_dys",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
			             {Type:"Int",       Hidden:0,  Width:0,    Align:"Right",   ColMerge:1,   SaveName:"rntl_chg_free_dys",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
			             {Type:"Float",     Hidden:0,  Width:0,    Align:"Right",   ColMerge:1,   SaveName:"cntr_dir_itchg_fee_amt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
			             {Type:"Float",     Hidden:0,  Width:0,    Align:"Right",   ColMerge:1,   SaveName:"cntr_drff_amt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Float",     Hidden:0,  Width:0,    Align:"Right",   ColMerge:1,   SaveName:"cntr_drff_cr_amt",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Popup",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"cntr_lft_chg_amt",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
			             {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cntr_lstm_cng_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"cre_dt",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"upd_dt",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"cntr_sts_rmk",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
			             {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"mvmt_sts_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"cntr_sts_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"time_local",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"init_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"del_flg",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"prnr_sts_seq",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"chk_flg",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }];
			      InitColumns(cols);
			      SetEditable(1);
			      SetImageList(0,"img/btns_search.gif");
			      SetImageList(1,"img/btns_search.gif");
			      SetImageList(2,"img/btns_search.gif");
			      SetColProperty("cntr_old_van_flg", {ComboText:"Old|New", ComboCode:"Y|N"} );
			      SetColProperty(0,"yd_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
			      SetColProperty(0,"agmt_seq" , {AcceptKeys:"N" , InputCaseSensitive:1});
			      SetShowButtonImage(1);
			      SetSheetHeight(210);
		      }
         break;
        }
    }
    // handling process for sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			case IBSEARCH:      //retrieve
				if(validateForm(sheetObj,formObj,sAction)){
					sheetObj.SetWaitImageVisible(0);
					ComOpenWait(true);					
	            	formObj.f_cmd.value=SEARCH;
	            	if (formObj.cntr_no.value.trim().length == 0) {
	            		ComOpenWait(false);	            		
	            		ComShowCodeMessage("MST00001","Cntr No.");
	            		formObj.cntr_no.focus();
	            		return;
	            	} 
	            	
	            	if (formObj.cntr_no.value.trim().length == 10){
	            		formObj.cntr_no.value=formObj.cntr_no.value.toUpperCase() + formObj.chk_dgt.value; // Copy&paste lower case to upper case
	            	}
	            	
	            	var sXml=sheetObj.GetSearchData("EES_MST_0028GS.do", FormQueryString(formObj));
	    			if (sXml.indexOf("# ERROR") != -1 || sXml.indexOf("# Error") != -1){
	     			   sheetObj.LoadSearchData(sXml,{Sync:1} );
	     			   ComOpenWait(false);
	     			   return;
	     			}    
	            	var arrXml=sXml.split("|$$|");
	                // fill data to input boxes 	  
	            	var strCntrNo = ComXmlString(arrXml[0], "cntr_no")+"";
	            	formObj.cntr_no.value=strCntrNo.substring(0,10);
	            	formObj.chk_dgt.value=ComXmlString(arrXml[0], "chk_dgt");
	            	formObj.aciac_div_cd.value=ComXmlString(arrXml[0], "aciac_div_cd");
	            	formObj.cntr_tpsz_cd.value=ComXmlString(arrXml[0], "cntr_tpsz_cd");
	            	formObj.lstm_cd.value=ComXmlString(arrXml[0], "lstm_cd");
	            	formObj.cntr_tpsz_iso_cd.value=ComXmlString(arrXml[0], "cntr_tpsz_iso_cd");
	            	formObj.ownr_co_cd.value=ComXmlString(arrXml[0], "ownr_co_cd");
	            	formObj.cntr_use_co_cd.value=ComXmlString(arrXml[0], "cntr_use_co_cd");
	            	//fill data tosheet
	            	if (arrXml.length > 1) sheetObjects[0].LoadSearchData(arrXml[1],{Sync:1} );
	            	if (arrXml.length > 2) sheetObjects[1].LoadSearchData(arrXml[2],{Sync:1} );
	                //setting STS
	            	setFieldOfStatusCode();
	            	sheetObjects[0].SetSelectRow(sheetObjects[0].RowCount());
	            	sheetObjects[0].SetTopRow(sheetObjects[0].RowCount());
	            	sheetObjects[1].SetSelectRow(sheetObjects[1].RowCount());
	            	sheetObjects[1].SetTopRow(sheetObjects[1].RowCount());
	            	
	            	if(strCntrNo == "") {
	        			formObj.chk_dgt.readOnly = true;
	                	formObj.chk_dgt.className="input";			
	    			}else{
	    				formObj.chk_dgt.readOnly = false;
	    				formObj.chk_dgt.className="input1";
	    			}
	            	
	            	ComOpenWait(false);
				}
			break;
			case IBSEARCH02:
				var sel_row = sheetObj.GetSelectRow();		//선택된 현재 row 위치							
				var agmt_seq = "";
				var on_yd_cd = "";
				var off_yd_cd = "";
				var sch_agmt_seq = "";
				
				sch_agmt_seq = sheetObj.GetCellValue(sel_row,"agmt_seq"); //param 설정
				on_yd_cd = sheetObj.GetCellValue(sel_row,"yd_cd");			  //param 설정
				//기존 로직 참조하여 off_yd_cd 를 조회한다.
				//다음 ROW가 off_yd_cd 이다.
				if ((sheetObj.GetCellValue(sel_row, "cntr_sts_cd") == "SBO" || sheetObj.GetCellValue(sel_row, "cntr_sts_cd") == "MUO") && sheetObj.GetSelectRow()!= sheetObj.LastRow()){
	   	    	     
					off_yd_cd = sheetObj.GetCellValue(sel_row+1, "yd_cd"); 
	   	    	     
	   	    	} else if (sheetObj.GetCellValue(sel_row, "cntr_sts_cd") == "LSI"){
	   	    	     for(var k=sel_row+1; k <= sheetObj.LastRow(); k++){
	   	    	    	 if (sheetObj.GetCellValue(k, "cntr_sts_cd") == "LSO" || sheetObj.GetCellValue(k, "cntr_sts_cd") == "LST" || 
	   	    	    			 sheetObj.GetCellValue(k, "cntr_sts_cd") == "FND" || sheetObj.GetCellValue(k, "cntr_sts_cd") == "SCR" || 
	   	    	    			 sheetObj.GetCellValue(k, "cntr_sts_cd") == "DON" || sheetObj.GetCellValue(k, "cntr_sts_cd") == "TLL" || 
	   	    	    			 sheetObj.GetCellValue(k, "cntr_sts_cd") == "SRO"){
	   	    	    		 
	   	    	    		off_yd_cd = sheetObj.GetCellValue(k, "yd_cd"); 
	   	    	    		
	   	    	    	 } else if (sheetObj.GetCellValue(k, "cntr_sts_cd") == "LSI" ||
	   	    	    			 sheetObj.GetCellValue(k, "cntr_sts_cd") == "DII" ||
	   	    	    			 sheetObj.GetCellValue(k, "cntr_sts_cd") == "OWN"){
	   	    	    	    break;
	   	    	    	}
	   	    	    }
	       	    }
				
				/*
				** Free Days 
					 Handle On/Off Charge(Currency) 
					 Handle On/Off Charge
				** 데이타를 조회하여 시트에 Set 하는 로직
				*/
				var cntr_no = formObj.cntr_no.value + formObj.chk_dgt.value;
				var param="f_cmd="+SEARCH01+"&agmt_seq="+sch_agmt_seq + "&on_yd_cd="+on_yd_cd+"&off_yd_cd="+off_yd_cd+"&cntr_no="+cntr_no;
				
				var xml=sheetObj.GetSearchData("EES_MST_0028GS.do",param);
				strXml = xml;
				if ( ComGetTotalRows(xml) != 1 ) {
					sheetObj.SetCellValue(sel_row,"agmt_seq",tmpagmtseq,0);
					return;
				}else if( ComGetTotalRows(xml) == 1 ) {
					var sch_lstm_cd = ComXmlString(xml, "lstm_cd");
					//선택한 ROW의 Term과 조회한 Term이 틀리면 Term Error 메세지 띄우고 agmt_seq 값을 원래대로 돌린다.		
					if(sch_lstm_cd != sheetObj.GetCellValue(sel_row,"lstm_cd")) {
						ComShowCodeMessage("MST01003");
						sheetObj.SetCellValue(sel_row,"agmt_seq",tmpagmtseq,0);
		  	    		return false;
					}else{
						//선택한 ROW의 Term과 조회한 Term이 맞으면 시트에 Set
						//cntr_sts_cd가 LSI, SBO, MUO인 경우 
						setAgmtChange(sheetObj,xml,sel_row);//공통 함수로 처리
						
						//기존 로직 참조하여 연관된 ROW에 데이타 SET 한다.
						for(var i=1; i <= sheetObj.RowCount(); i++){
							if(sheetObj.GetCellValue(sel_row, "cntr_sts_seq") == sheetObj.GetCellValue(i, "prnr_sts_seq")) {
								next_row = i;
								sel_sts_cd = sheetObj.GetCellValue(sel_row, "cntr_sts_cd");
								break;
							}
						}
						
						if(next_row > 0) {
							setAgmtChange(sheetObj,xml,next_row);//공통 함수로 처리
						}
					}
				}
				break;
            case IBSEARCH01:
				formObj.f_cmd.value=SEARCH05;
				var sXml = sheetObj.GetSearchData("EES_MST_COMGS.do", "f_cmd=105&agmt_cty_cd=" + sheetObj.GetCellValue(sheetObj.SetSelectRow, "agmt_cty_cd") + "&agmt_seq=" + sheetObj.GetCellValue(sheetObj.GetSelectRow()), "agmt_seq");
    			var chk=sXml.indexOf("ERROR");
    			if (sXml.indexOf("ERROR") != -1 || sXml.indexOf("Error") != -1){
    			   sheetObj.LoadSearchData(sXml,{Sync:1} );
    			   return;
    			}            	
           	    var lstmcd=ComXmlString(sXml, "lstm_cd");
       	    	if ((lstmcd == "OW" ||  lstmcd == "LP" || lstmcd == "OL" || lstmcd == "SO" || lstmcd == "MO") && sheetObj.GetCellValue(sheetObj.GetSelectRow(), "cntr_sts_cd") == "LSI"){
          	    	 ComShowCodeMessage("MST01003");
          	    	 sheetObj.SetCellValue(sheetObj.GetSelectRow(), "agmt_seq",tmpagmtseq);
          	    	 return;
          	    }       	    	
       	    	if (sheetObj.GetCellValue(sheetObj.GetSelectRow(), "cntr_sts_cd") == "SBO" && lstmcd != "SO"){
      	    		ComShowCodeMessage("MST01003");
      	    		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "agmt_seq",tmpagmtseq);
      	    		return;
      	    	}
       	    	if (sheetObj.GetCellValue(sheetObj.GetSelectRow(), "cntr_sts_cd") == "MUO" && lstmcd != "MO"){
      	    		ComShowCodeMessage("MST01003");
      	    		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "agmt_seq",tmpagmtseq);
      	    		return;
      	    	}       	    	
     	    	if (ComXmlString(sXml, "ref_no") != ""){
	       	    	sheetObj.SetCellValue(sheetObj.GetSelectRow(), "agmt_seq",ComXmlString(sXml, "agmt_seq"));
	       	    	sheetObj.SetCellValue(sheetObj.GetSelectRow(), "lstm_cd",lstmcd);
	       	    	sheetObj.SetCellValue(sheetObj.GetSelectRow(), "ref_no",ComXmlString(sXml, "ref_no"));
	       	    	sheetObj.SetCellValue(sheetObj.GetSelectRow(), "vndr_seq",ComXmlString(sXml, "vndr_seq"));
	       	    	sheetObj.SetCellValue(sheetObj.GetSelectRow(), "vndr_lgl_eng_nm",ComXmlString(sXml, "vndr_lgl_eng_nm"));
	       	    	if ((sheetObj.GetCellValue(sheetObj.GetSelectRow(), "cntr_sts_cd") == "SBO" ||
	       	    			sheetObj.GetCellValue(sheetObj.GetSelectRow(), "cntr_sts_cd") == "MUO") && sheetObj.GetSelectRow()!= sheetObj.LastRow()){
		       	    	sheetObj.SetCellValue(sheetObj.GetSelectRow()+1, "agmt_seq",ComXmlString(sXml, "agmt_seq"));
		       	    	sheetObj.SetCellValue(sheetObj.GetSelectRow()+1, "lstm_cd",lstmcd);
		       	    	sheetObj.SetCellValue(sheetObj.GetSelectRow()+1, "ref_no",ComXmlString(sXml, "ref_no"));
		       	    	sheetObj.SetCellValue(sheetObj.GetSelectRow()+1, "vndr_seq",ComXmlString(sXml, "vndr_seq"));
		       	    	sheetObj.SetCellValue(sheetObj.GetSelectRow()+1, "vndr_lgl_eng_nm",ComXmlString(sXml, "vndr_lgl_eng_nm"));
	       	    	} else if (sheetObj.GetCellValue(sheetObj.GetSelectRow(), "cntr_sts_cd") == "LSI"){
       	    	             for(var k=sheetObj.GetSelectRow()+1; k <= sheetObj.LastRow(); k++){
       	    	            	 if (sheetObj.GetCellValue(k, "cntr_sts_cd") == "LSO" || sheetObj.GetCellValue(k, "cntr_sts_cd") == "LST" || sheetObj.GetCellValue(k, "cntr_sts_cd") == "FND" || sheetObj.GetCellValue(k, "cntr_sts_cd") == "SCR" || sheetObj.GetCellValue(k, "cntr_sts_cd") == "DON" || sheetObj.GetCellValue(k, "cntr_sts_cd") == "TLL" || sheetObj.GetCellValue(k, "cntr_sts_cd") == "SRO"){
       	    	    	        	 	sheetObj.SetCellValue(k, "agmt_seq",ComXmlString(sXml, "agmt_seq"));
       	    	    	        	 	sheetObj.SetCellValue(k, "ref_no",ComXmlString(sXml, "ref_no"));
       	    	    	        	 	sheetObj.SetCellValue(k, "lstm_cd",lstmcd);
       	    	    	        	 	sheetObj.SetCellValue(k, "vndr_seq",ComXmlString(sXml, "vndr_seq"));
       	    	    	        	 	sheetObj.SetCellValue(k, "vndr_lgl_eng_nm",ComXmlString(sXml, "vndr_lgl_eng_nm"));
       	    	            	 } else if (sheetObj.GetCellValue(k, "cntr_sts_cd") == "LSI" ||
       	    	            			 sheetObj.GetCellValue(k, "cntr_sts_cd") == "DII" ||
       	    	            			 sheetObj.GetCellValue(k, "cntr_sts_cd") == "OWN"){
       	    	    	        	 	break;
       	    	    	         }
       	    	    	    }
       	    	       }
     	    	} else {
     	    		ComShowCodeMessage("MST01003");
     	    		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "agmt_seq",tmpagmtseq);
     	    		doActionIBSheet(sheetObj, formObj, IBSEARCH01);
     	    	}
            break;			
            
			case IBSAVE:        //save
				/*if (formObj.chk_dgt.value.trim().length == 0){
			    	   ComShowCodeMessage("MST00001", "Check Digit");
			    	   formObj.chk_dgt.focus();
			    	   return;
			    }*/
				
		    	if (sheetObj.RowCount()== 0){
			       ComShowCodeMessage("MST00001", "Status History Row");
			       return;
			    }
			    var chgflg=false; 
			    var gubun="";
			    for (var i=1; i <= sheetObj.RowCount(); i++){
			    	if (sheetObj.GetRowStatus(i) == "U") {
			    		if (sheetObj.GetCellValue(i, "yd_cd") == ""){
			    			ComShowCodeMessage("MST00001", "Yard");
			    			return;
			    		}
			    		
			    		if (sheetObj.GetCellValue(i, "cntr_sts_evnt_dt") == ""){
			    			ComShowCodeMessage("MST00001", "ACT Date");
			    			return;
			    		}
			    	}
			    	
			    	if (sheetObj.GetRowStatus(i) == "U" || sheetObj.GetRowStatus(i) == "D") {
			    		chgflg=true;
			    		if (sheetObj.GetCellValue(i, "cntr_sts_cd") == "LSI"){
			    			gubun="1";
			    		}
			    	}
			    	var lftamt=parseFloat(sheetObj.GetCellValue(i,"cntr_lft_chg_amt"));
			    	var currcd=sheetObj.GetCellValue(i,"curr_cd");
			    	if (lftamt > 0 && currcd == ""){
			    		ComShowCodeMessage("MST00001", "Lift On/Off Charge Currency.");
			    		sheetObj.SelectCell(i,"cntr_lft_chg_amt");
			    		return;
			    	}
			    }
			    if (chgflg == false){
			       ComShowCodeMessage("MST00012");
			       return;
			    }
			    /* SH LSO도 삭제 하도록 기능 변경
			    if (sheetObj.GetCellValue(sheetObj.RowCount(), "cntr_sts_cd")== "LSO" &&
			    		sheetObj.GetRowStatus(sheetObj.RowCount()) == "D" &&
			    	formObj.lstm_cd.value == "SH"){
			    	ComShowCodeMessage("MST02025");
			    	return;
			    }
			    */
				if(validateForm(sheetObj,formObj,sAction)){
					sheetObj.SetWaitImageVisible(0);
					ComOpenWait(true);					
			    	formObj.f_cmd.value=MULTI;			
	     	        var sParam=ComGetSaveString(sheetObj);
	     	        //in case of last sts = LSI, GUBUN : 1
	     	        if (gubun == "1" && sheetObj.GetRowStatus(sheetObj.RowCount()) == "U") {
	     	            sParam += "&" + FormQueryString(formObj)+"&gubun="+gubun+"&chk_dgt="+formObj.chk_dgt.value;	
	     	        } 
	     	        else if ((sheetObj.GetCellValue(sheetObj.RowCount(), "cntr_sts_cd")== "LSO" || sheetObj.GetCellValue(sheetObj.RowCount(), "cntr_sts_cd")== "SBO" || sheetObj.GetCellValue(sheetObj.RowCount(), "cntr_sts_cd")== "MUO" || sheetObj.GetCellValue(sheetObj.RowCount(), "cntr_sts_cd")== "LST" || sheetObj.GetCellValue(sheetObj.RowCount(), "cntr_sts_cd")== "SRO" || sheetObj.GetCellValue(sheetObj.RowCount(), "cntr_sts_cd")== "DON" || sheetObj.GetCellValue(sheetObj.RowCount(), "cntr_sts_cd")== "SCR" || sheetObj.GetCellValue(sheetObj.RowCount(), "cntr_sts_cd")== "SLD" || sheetObj.GetCellValue(sheetObj.RowCount(), "cntr_sts_cd")== "TLL" ) && sheetObj.GetRowStatus(sheetObj.RowCount()) == "D"){
	     	        	sParam += "&" + FormQueryString(formObj)+"&gubun=2&chk_dgt="+formObj.chk_dgt.value+
	     	        	"&cnmv_yr="+sheetObjects[0].GetCellValue(sheetObjects[0].RowCount(), "cnmv_yr")+
	     	        	"&cnmv_id_no="+sheetObjects[0].GetCellValue(sheetObjects[0].RowCount(), "cnmv_id_no");
	     	        } 
	     	        else if ((sheetObj.GetCellValue(sheetObj.RowCount(), "cntr_sts_cd")== "LSI" || sheetObj.GetCellValue(sheetObj.RowCount(), "cntr_sts_cd")== "SBI" || sheetObj.GetCellValue(sheetObj.RowCount(), "cntr_sts_cd")== "MUI" || sheetObj.GetCellValue(sheetObj.RowCount(), "cntr_sts_cd")== "FND" || sheetObj.GetCellValue(sheetObj.RowCount(), "cntr_sts_cd")== "SRI" ) && sheetObj.GetRowStatus(sheetObj.RowCount()) == "D"){
		     	        sParam += "&" + FormQueryString(formObj)+"&gubun=3&chk_dgt="+formObj.chk_dgt.value+
		     	        "&cnmv_yr="+sheetObjects[0].GetCellValue(sheetObjects[0].RowCount(), "cnmv_yr")+
		     	        "&cnmv_id_no="+sheetObjects[0].GetCellValue(sheetObjects[0].RowCount(), "cnmv_id_no");
		     	        if (sheetObj.GetCellValue(sheetObj.RowCount(), "seq") == "1"){
		     	    	   sParam += "&mst_del_flg=Y"
		     	       }
	     	        }
	     	        else {
	     	            sParam += "&" + FormQueryString(formObj);
	     	        }
	     	        var sXml=sheetObj.GetSaveData("EES_MST_0028GS.do", sParam);
					ComOpenWait(false);
					var chk=sXml.indexOf("ERROR");
					var msg=ComGetSelectSingleNode(sXml, "MESSAGE");
		            
					if (sXml.indexOf("ERROR") == -1 && sXml.indexOf("Error") == -1){
						if ( msg != 'undefined' && msg != '') {	
					           ComShowMessage(msg);
					           return false;
				       }else{
							ComShowCodeMessage("MST01025");
				       }
					} else {
						sheetObj.LoadSearchData(sXml,{Sync:1} );
						return;
					}
					doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
				}
			break;
			
			case IBDELETE:
	   	   		if (sheetObj.id == 'sheet2') {  
		   	   		if(sheetObj.FindCheckedRow("sel") != ""){
						ComRowHideDelete(sheetObj,"sel"); 
					}
				}    			
			    break;				
        }
    }
    
    /**
     * AgmtChange에 따른 값 설정
     */
    function setAgmtChange(sheetObj,xml,sel_row){
    	if (sheetObj.GetCellValue(sel_row, "cntr_sts_cd") == "LSI" || sheetObj.GetCellValue(sel_row, "cntr_sts_cd") == "SBO" ||
	    			sheetObj.GetCellValue(sel_row, "cntr_sts_cd") == "MUO") {
			// Free Days 
	        // Handle On/Off Charge(Currency) 
	        // Handle On/Off Charge
			
			sheetObj.SetCellValue(sel_row,"rntl_chg_free_dys",ComXmlString(xml, "rntl_chg_free_dys").toString(),0);
			sheetObj.SetCellValue(sel_row,"cntr_lft_chg_amt",ComXmlString(xml, "lft_on_amt").toString(),0);
			if(ComXmlString(xml, "lft_on_amt") != "" && ComXmlString(xml, "lft_on_amt") != "0") {
				sheetObj.SetCellValue(sel_row,"curr_cd",ComXmlString(xml, "curr_cd").toString(),0);
			} else {
				sheetObj.SetCellValue(sel_row,"curr_cd","",0);
			}
		}else if(sheetObj.GetCellValue(sel_row, "cntr_sts_cd") == "LSO" || sheetObj.GetCellValue(sel_row, "cntr_sts_cd") == "SBI" ||
	    			sheetObj.GetCellValue(sel_row, "cntr_sts_cd") == "MUI") {
			// Handle On/Off Charge(Currency) 
	        // Handle On/Off Charge
			sheetObj.SetCellValue(sel_row,"cntr_lft_chg_amt",ComXmlString(xml, "lft_off_amt").toString(),0);
			if(ComXmlString(xml, "lft_off_amt") != "" && ComXmlString(xml, "lft_off_amt") != "0") {
				sheetObj.SetCellValue(sel_row,"curr_cd",ComXmlString(xml, "curr_cd").toString(),0);
			} else {
				sheetObj.SetCellValue(sel_row,"curr_cd","",0);
			}
			
			if(sheetObj.GetCellValue(sel_row, "cntr_sts_cd") == "LSO") {
				// DOC Charge
				sheetObj.SetCellValue(sel_row,"cntr_drff_amt",ComXmlString(xml, "cntr_drff_amt").toString(),0);
			}
		}
    }
    
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        return true;
    }
	function setFieldOfStatusCode(){
	  	var formObj=document.form;
	    var sheetObj=sheetObjects[1];
	    var ofcCd=formObj.hid_ofc_cd.value;
		var stsval=sheetObjects[0].GetCellValue(sheetObjects[0].RowCount(), "mvmt_sts_cd");
		var stsrmk=sheetObjects[0].GetCellValue(sheetObjects[0].RowCount(), "cnmv_rmk");
		var ststpcd=sheetObjects[0].GetCellValue(sheetObjects[0].RowCount(), "mvmt_cre_tp_cd");
		var stsyard=sheetObjects[0].GetCellValue(sheetObjects[0].RowCount(), "crnt_yd_cd");   // yard
		stsrmk=stsrmk.substring(0,3);
	    for (var i=1; i <= sheetObj.RowCount(); i++){
	       SetGetCellEditableFalse(i);
	       if (sheetObj.GetCellValue(i,"cntr_lstm_cng_flg") == "N"){
	    	   var edt=sheetObj.GetCellValue(i,"cntr_sts_evnt_dt");
		       var retgap= 6 // Del 체크박스가 활성화 될 수 있도록 일시적으로 변경. (기존 ALPS에서는 7개월의 cntr stst만 변경가능했음.)
		       //var retgap = getMonthInterval(edt.replace("-",""), toTimeString(new Date()).substring(0,8)+"0001");
		       var ydcd=sheetObj.GetCellValue(i,"yd_cd");
		       var initFlg=sheetObj.GetCellValue(i,"init_flg");
		       
		       if (sheetObj.GetCellValue(i, "cntr_sts_cd") == "OWN" && i == sheetObj.RowCount()){
		    	   // New Logic for Delete
	    		   if (sheetObj.GetCellValue(i, "delt_flg") == "Y") {
	    			   sheetObj.SetCellEditable(i,"sel",1);
	    		   } else {
	    			   sheetObj.SetCellEditable(i,"sel",0);
	    		   }
		       } else if (sheetObj.GetCellValue(i, "cntr_sts_cd") == "LSI" && i == sheetObj.RowCount()){
		    	   if (retgap < 7){
	    			   // in case of XX or  auto creation or (MT and remark = LSI, ....), removing available
	    			   if (stsval == "XX" || ststpcd == "E" || (stsval == "MT" && (stsrmk == "LSI" || stsrmk == "SBI" || stsrmk == "MUI" || 
	    				   stsrmk == "DII" || stsrmk == "SBR" || stsrmk == "MUR"))){
	    				  // if (stsyard == ydcd && initFlg != 'Y'){ // in case fo same yd cd, removing available
	    				   if (stsyard == ydcd){ // in case fo same yd cd, removing available
	    					   sheetObj.SetCellEditable(i,"sel",1);
	    				   }
	    			   }		    		   
	    			   sheetObj.SetCellEditable(i,"cntr_sts_evnt_dt",1);
	    			   if (sheetObj.GetCellValue(i,"cntr_lstm_cng_flg") == "Y"){
				          sheetObj.SetCellEditable(i,"yd_cd",1);
				       }
				       //sheetObj.CellEditable(i,"agmt_cty_cd") = true; 
				       sheetObj.SetCellEditable(i,"agmt_seq",1);
				       //3.in case of Old/New, editable
				       sheetObj.SetCellEditable(i,"cntr_old_van_flg",1);
				       sheetObj.SetCellEditable(i,"cntr_pkup_chg_amt",1);
				       sheetObj.SetCellEditable(i,"cntr_pkup_cr_chg_amt",1);
				       sheetObj.SetCellEditable(i,"cntr_min_onh_dys",1);
				       sheetObj.SetCellEditable(i,"rntl_chg_free_dys",1);
				       if (sheetObj.GetCellValue(i,"cntr_sts_cd") != "LSI"){
				           sheetObj.SetCellEditable(i,"curr_cd",1);
				       }
				       sheetObj.SetCellEditable(i,"cntr_lft_chg_amt",1);
				       sheetObj.SetCellEditable(i,"curr_cd",1);
				       sheetObj.SetCellEditable(i,"cntr_sts_rmk",1);
				       sheetObj.SetMinimumValue(i, "cntr_pkup_chg_amt",0);
				       sheetObj.SetMinimumValue(i, "cntr_pkup_cr_chg_amt",0);
				       sheetObj.SetMinimumValue(i, "cntr_min_onh_dys",0);
				       sheetObj.SetMinimumValue(i, "rntl_chg_free_dys",0);
				       sheetObj.SetMinimumValue(i, "cntr_lft_chg_amt",0);

			    	   // New Logic for Delete
		    		   if (sheetObj.GetCellValue(i, "delt_flg") == "Y") {
		    			   sheetObj.SetCellEditable(i,"sel",1);
		    		   } else {
		    			   sheetObj.SetCellEditable(i,"sel",0);
		    		   }
		    		   // New Logic for Event Date
		    		   if (sheetObj.GetCellValue(i, "date_flg") == "Y") {
		    			   sheetObj.SetCellEditable(i,"cntr_sts_evnt_dt",1);
		    		   } else {
		    			   sheetObj.SetCellEditable(i,"cntr_sts_evnt_dt",0);
		    		   }
		    		   // New Logic for Agreement
		    		   if (sheetObj.GetCellValue(i, "agmt_flg") == "Y") {
		    			   sheetObj.SetCellEditable(i,"agmt_seq",1);
		    		   } else {
		    			   sheetObj.SetCellEditable(i,"agmt_seq",0);
		    		   }			    		   
		    	   } else if(retgap >= 7 && sheetObjects[0].RowCount()>0){
		    		   var lstmCd=sheetObj.GetCellValue(i,"lstm_cd");  //for checking SH Term
		    		   if (lstmCd =="SH" && stsval == "MT" && stsrmk == "LSI"){  
		    			   if (stsyard == ydcd ){// in case of same yard code, removing available
	    					   sheetObj.SetCellEditable(i,"sel",1);
	    				   }
		    		   }
		    		   
		    		   // New Logic for Delete
		    		   if (sheetObj.GetCellValue(i, "delt_flg") == "Y") {
		    			   sheetObj.SetCellEditable(i,"sel",1);
		    		   } else {
		    			   sheetObj.SetCellEditable(i,"sel",0);
		    		   }
		    	   }			    		   
		       } else if (sheetObj.GetCellValue(i, "cntr_sts_cd") == "LSI" && i != sheetObj.RowCount()) {
		    	   if (retgap < 7){	       
			    	   sheetObj.SetCellEditable(i,"cntr_sts_evnt_dt",1);
			    	   if (sheetObj.GetCellValue(i,"cntr_lstm_cng_flg") == "Y"){
				          sheetObj.SetCellEditable(i,"yd_cd",1);
				       } 
				       //3.in case of Old/New, editable		       
				    	sheetObj.SetCellEditable(i,"cntr_old_van_flg",1);
			    	   //sheetObj.CellEditable(i,"agmt_cty_cd") = true;            
			    	   sheetObj.SetCellEditable(i,"agmt_seq",1);
			    	   sheetObj.SetCellEditable(i,"cntr_pkup_chg_amt",1);
			    	   sheetObj.SetCellEditable(i,"cntr_pkup_cr_chg_amt",1);
			    	   sheetObj.SetCellEditable(i,"cntr_min_onh_dys",1);
			    	   sheetObj.SetCellEditable(i,"rntl_chg_free_dys",1);
			    	   if (sheetObj.GetCellValue(i,"cntr_sts_cd") != "LSI"){
				           sheetObj.SetCellEditable(i,"curr_cd",1);
				       }
				       sheetObj.SetCellEditable(i,"cntr_lft_chg_amt",1);
				       sheetObj.SetCellEditable(i,"curr_cd",1);
			    	   sheetObj.SetCellEditable(i,"cntr_sts_rmk",1);
				       sheetObj.SetMinimumValue(i, "cntr_pkup_chg_amt",0);
				       sheetObj.SetMinimumValue(i, "cntr_pkup_cr_chg_amt",0);
				       sheetObj.SetMinimumValue(i, "cntr_min_onh_dys",0);
				       sheetObj.SetMinimumValue(i, "rntl_chg_free_dys",0);
				       sheetObj.SetMinimumValue(i, "cntr_lft_chg_amt",0);

				       // New Logic for Event Date
		    		   if (sheetObj.GetCellValue(i, "date_flg") == "Y") {
		    			   sheetObj.SetCellEditable(i,"cntr_sts_evnt_dt",1);
		    		   } else {
		    			   sheetObj.SetCellEditable(i,"cntr_sts_evnt_dt",0);
		    		   }	
		    		   // New Logic for Agreement
		    		   if (sheetObj.GetCellValue(i, "agmt_flg") == "Y") {
		    			   sheetObj.SetCellEditable(i,"agmt_seq",1);
		    		   } else {
		    			   sheetObj.SetCellEditable(i,"agmt_seq",0);
		    		   }		    		   
		    	   }
		    	   
		       } else if (sheetObj.GetCellValue(i, "cntr_sts_cd") == "LSO" && i == sheetObj.RowCount()){
		    	   //ComDebug("retgap : " + retgap);
		    	   if (retgap < 7){		    	   
		    		   sheetObj.SetCellEditable(i,"sel",1);
		    		   sheetObj.SetCellEditable(i,"cntr_sts_evnt_dt",1);
		    		   sheetObj.SetCellEditable(i,"cntr_drff_amt",1);
		    		   sheetObj.SetCellEditable(i,"cntr_drff_cr_amt",1);
		    		   if (sheetObj.GetCellValue(i,"cntr_sts_cd") != "LSI"){
				           sheetObj.SetCellEditable(i,"curr_cd",1);
				       }
		    		   sheetObj.SetCellEditable(i,"cntr_lft_chg_amt",1);
		    		   sheetObj.SetCellEditable(i,"curr_cd",1);
		    		   sheetObj.SetCellEditable(i,"cntr_sts_rmk",1);
		    		   //ComDebug("cntr_sts_rmk - 1 : " + sheetObj.CellEditable(i,"cntr_sts_rmk"));
				       sheetObj.SetMinimumValue(i, "cntr_drff_amt",0);
				       sheetObj.SetMinimumValue(i, "cntr_drff_cr_amt",0);
				       sheetObj.SetMinimumValue(i, "cntr_lft_chg_amt",0);
				       
				       // New Logic for Delete
		    		   if (sheetObj.GetCellValue(i, "delt_flg") == "Y") {
		    			   sheetObj.SetCellEditable(i,"sel",1);
		    		   } else {
		    			   sheetObj.SetCellEditable(i,"sel",0);
		    		   }
		    		   // New Logic for Event Date
		    		   if (sheetObj.GetCellValue(i, "date_flg") == "Y") {
		    			   sheetObj.SetCellEditable(i,"cntr_sts_evnt_dt",1);
		    		   } else {
		    			   sheetObj.SetCellEditable(i,"cntr_sts_evnt_dt",0);
		    		   }				       
		    	   }
		    	   
		       } else if (sheetObj.GetCellValue(i, "cntr_sts_cd") == "LSO" && i != sheetObj.RowCount()){
		    	   if (retgap < 7){	
			    	   sheetObj.SetCellEditable(i,"cntr_sts_evnt_dt",1);
		    		   sheetObj.SetCellEditable(i,"cntr_drff_amt",1);
		    		   sheetObj.SetCellEditable(i,"cntr_drff_cr_amt",1);
		    		   if (sheetObj.GetCellValue(i,"cntr_sts_cd") != "LSI"){
				           sheetObj.SetCellEditable(i,"curr_cd",1);
				       }
		    		   sheetObj.SetCellEditable(i,"cntr_lft_chg_amt",1);
		    		   sheetObj.SetCellEditable(i,"curr_cd",1);
		    		   sheetObj.SetCellEditable(i,"cntr_sts_rmk",1);
				       sheetObj.SetMinimumValue(i, "cntr_drff_amt",0);
				       sheetObj.SetMinimumValue(i, "cntr_drff_cr_amt",0);
				       sheetObj.SetMinimumValue(i, "cntr_lft_chg_amt",0);

				       // New Logic for Event Date
		    		   if (sheetObj.GetCellValue(i, "date_flg") == "Y") {
		    			   sheetObj.SetCellEditable(i,"cntr_sts_evnt_dt",1);
		    		   } else {
		    			   sheetObj.SetCellEditable(i,"cntr_sts_evnt_dt",0);
		    		   }				       
		    	   }
		       } else if (sheetObj.GetCellValue(i, "cntr_sts_cd") == "MUO" && i == sheetObj.RowCount()){
		    	   if (retgap < 7){
		    		   sheetObj.SetCellEditable(i,"sel",1);
			    	   sheetObj.SetCellEditable(i,"cntr_sts_evnt_dt",1);
		    		   sheetObj.SetCellEditable(i,"agmt_seq",1);
		    		   //sheetObj.CellEditable(i,"ofc_cd") = true;
		    		   //3.in case of Old/New, editable
				       sheetObj.SetCellEditable(i,"cntr_old_van_flg",1);
		    		   sheetObj.SetCellEditable(i,"cntr_sts_rmk",1);
		    		   sheetObj.SetCellEditable(i,"cntr_lft_chg_amt",1);
		    		   sheetObj.SetCellEditable(i,"curr_cd",1);
			    	   sheetObj.SetCellEditable(i,"rntl_chg_free_dys",1);
			    	   sheetObj.SetCellEditable(i,"cntr_pkup_chg_amt",1);
			    	   sheetObj.SetCellEditable(i,"cntr_pkup_cr_chg_amt",1);
				       sheetObj.SetMinimumValue(i, "cntr_lft_chg_amt",0);
				       sheetObj.SetMinimumValue(i, "rntl_chg_free_dys",0);
				       sheetObj.SetMinimumValue(i, "cntr_pkup_chg_amt",0);
				       sheetObj.SetMinimumValue(i, "cntr_pkup_cr_chg_amt",0);
				       
				       // New Logic for Delete
		    		   if (sheetObj.GetCellValue(i, "delt_flg") == "Y") {
		    			   sheetObj.SetCellEditable(i,"sel",1);
		    		   } else {
		    			   sheetObj.SetCellEditable(i,"sel",0);
		    		   }
		    		   // New Logic for Event Date
		    		   if (sheetObj.GetCellValue(i, "date_flg") == "Y") {
		    			   sheetObj.SetCellEditable(i,"cntr_sts_evnt_dt",1);
		    		   } else {
		    			   sheetObj.SetCellEditable(i,"cntr_sts_evnt_dt",0);
		    		   }
		    		   // New Logic for Agreement
		    		   if (sheetObj.GetCellValue(i, "agmt_flg") == "Y") {
		    			   sheetObj.SetCellEditable(i,"agmt_seq",1);
		    		   } else {
		    			   sheetObj.SetCellEditable(i,"agmt_seq",0);
		    		   }		    		   
		    	   }		    	   
		       } else if (sheetObj.GetCellValue(i, "cntr_sts_cd") == "MUO" && i != sheetObj.RowCount()){
		    	  if (retgap < 7){		    	   
			    	   sheetObj.SetCellEditable(i,"cntr_sts_evnt_dt",1);
		    		   sheetObj.SetCellEditable(i,"agmt_seq",1);
		    		   //sheetObj.CellEditable(i,"ofc_cd") = true;
		    		   //3.in case of Old/New, editable
				       sheetObj.SetCellEditable(i,"cntr_old_van_flg",1);
		    		   sheetObj.SetCellEditable(i,"cntr_sts_rmk",1);
		    		   sheetObj.SetCellEditable(i,"cntr_lft_chg_amt",1);
		    		   sheetObj.SetCellEditable(i,"curr_cd",1);
			    	   sheetObj.SetCellEditable(i,"rntl_chg_free_dys",1);
			    	   sheetObj.SetCellEditable(i,"cntr_pkup_chg_amt",1);
			    	   sheetObj.SetCellEditable(i,"cntr_pkup_cr_chg_amt",1);
				       sheetObj.SetMinimumValue(i, "cntr_lft_chg_amt",0);
				       sheetObj.SetMinimumValue(i, "rntl_chg_free_dys",0);
				       sheetObj.SetMinimumValue(i, "cntr_pkup_chg_amt",0);
				       sheetObj.SetMinimumValue(i, "cntr_pkup_cr_chg_amt",0);
				       
				       // New Logic for Event Date
		    		   if (sheetObj.GetCellValue(i, "date_flg") == "Y") {
		    			   sheetObj.SetCellEditable(i,"cntr_sts_evnt_dt",1);
		    		   } else {
		    			   sheetObj.SetCellEditable(i,"cntr_sts_evnt_dt",0);
		    		   }	
		    	       // New Logic for Agreement
		    		   if (sheetObj.GetCellValue(i, "agmt_flg") == "Y") {
		    			   sheetObj.SetCellEditable(i,"agmt_seq",1);
		    		   } else {
		    			   sheetObj.SetCellEditable(i,"agmt_seq",0);
		    		   }		    		   
		    	   }	    	   
		       } else if (sheetObj.GetCellValue(i, "cntr_sts_cd") == "MUI" && i != sheetObj.RowCount()){
		    	   if (retgap < 7){		       
		    		   sheetObj.SetCellEditable(i,"cntr_sts_evnt_dt",1);
		    		   //3.in case of Old/New, editable
				       sheetObj.SetCellEditable(i,"cntr_old_van_flg",1);
		    		   sheetObj.SetCellEditable(i,"cntr_sts_rmk",1);
		    		   sheetObj.SetCellEditable(i,"cntr_lft_chg_amt",1);
		    		   sheetObj.SetCellEditable(i,"curr_cd",1);
		    		   sheetObj.SetCellEditable(i,"cntr_drff_amt",1);
		    		   sheetObj.SetCellEditable(i,"cntr_drff_cr_amt",1);
				       sheetObj.SetMinimumValue(i, "cntr_drff_amt",0);
				       sheetObj.SetMinimumValue(i, "cntr_drff_cr_amt",0);
				       sheetObj.SetMinimumValue(i, "cntr_lft_chg_amt",0);
				       
				       // New Logic for Event Date
		    		   if (sheetObj.GetCellValue(i, "date_flg") == "Y") {
		    			   sheetObj.SetCellEditable(i,"cntr_sts_evnt_dt",1);
		    		   } else {
		    			   sheetObj.SetCellEditable(i,"cntr_sts_evnt_dt",0);
		    		   }	
		    	   }		    	   
		       } else if (sheetObj.GetCellValue(i, "cntr_sts_cd") == "MUI" && i == sheetObj.RowCount()){
		    	   if (retgap < 7){		
		    		   sheetObj.SetCellEditable(i,"cntr_sts_evnt_dt",1);
		    		   //3.in case of Old/New, editable
				   	   sheetObj.SetCellEditable(i,"cntr_old_van_flg",1);
	    			   // in case of XX or Movement auto creation or (MT & remark = LSI, ....), removing available
	    			   if (stsval == "XX" || ststpcd == "E" || (stsval == "MT" && (stsrmk == "LSI" || stsrmk == "SBI" || stsrmk == "MUI" || 
	    				   stsrmk == "DII" || stsrmk == "SBR" || stsrmk == "MUR"))){
	    				   sheetObj.SetCellEditable(i,"sel",1);
	    			   }
	    			   //end
		    		   sheetObj.SetCellEditable(i,"cntr_sts_rmk",1);
		    		   sheetObj.SetCellEditable(i,"cntr_lft_chg_amt",1);
		    		   sheetObj.SetCellEditable(i,"curr_cd",1);
		    		   sheetObj.SetCellEditable(i,"cntr_drff_amt",1);
		    		   sheetObj.SetCellEditable(i,"cntr_drff_cr_amt",1);
				       sheetObj.SetMinimumValue(i, "cntr_drff_amt",0);
				       sheetObj.SetMinimumValue(i, "cntr_drff_cr_amt",0);
				       sheetObj.SetMinimumValue(i, "cntr_lft_chg_amt",0);
				       
				       // New Logic for Delete
		    		   if (sheetObj.GetCellValue(i, "delt_flg") == "Y") {
		    			   sheetObj.SetCellEditable(i,"sel",1);
		    		   } else {
		    			   sheetObj.SetCellEditable(i,"sel",0);
		    		   }	
		    		   // New Logic for Event Date
		    		   if (sheetObj.GetCellValue(i, "date_flg") == "Y") {
		    			   sheetObj.SetCellEditable(i,"cntr_sts_evnt_dt",1);
		    		   } else {
		    			   sheetObj.SetCellEditable(i,"cntr_sts_evnt_dt",0);
		    		   }				       
		    	   }
		    	   	
		       } else if ((sheetObj.GetCellValue(i, "cntr_sts_cd") == "SRO" || sheetObj.GetCellValue(i, "cntr_sts_cd") == "DON" || sheetObj.GetCellValue(i, "cntr_sts_cd") == "SCR" || sheetObj.GetCellValue(i, "cntr_sts_cd") == "SLD" || sheetObj.GetCellValue(i, "cntr_sts_cd") == "TLL") && i == sheetObj.RowCount()){
		    	   if (retgap < 7){
		    		   sheetObj.SetCellEditable(i,"sel",1);
			    	   sheetObj.SetCellEditable(i,"cntr_sts_evnt_dt",1);
		    		   sheetObj.SetCellEditable(i,"agmt_seq",1);
		    		   //sheetObj.CellEditable(i,"ofc_cd") = true;
		    		   //3.in case of Old/New, editable
				       sheetObj.SetCellEditable(i,"cntr_old_van_flg",1);
		    		   sheetObj.SetCellEditable(i,"cntr_sts_rmk",1);
		    		   sheetObj.SetCellEditable(i,"cntr_lft_chg_amt",1);
		    		   sheetObj.SetCellEditable(i,"curr_cd",1);
			    	   sheetObj.SetCellEditable(i,"rntl_chg_free_dys",1);
			    	   sheetObj.SetCellEditable(i,"cntr_pkup_chg_amt",1);
			    	   sheetObj.SetCellEditable(i,"cntr_pkup_cr_chg_amt",1);
				       sheetObj.SetMinimumValue(i, "cntr_lft_chg_amt",0);
				       sheetObj.SetMinimumValue(i, "rntl_chg_free_dys",0);
				       sheetObj.SetMinimumValue(i, "cntr_pkup_chg_amt",0);
				       sheetObj.SetMinimumValue(i, "cntr_pkup_cr_chg_amt",0);
				       
				       // New Logic for Delete
		    		   if (sheetObj.GetCellValue(i, "delt_flg") == "Y") {
		    			   sheetObj.SetCellEditable(i,"sel",1);
		    		   } else {
		    			   sheetObj.SetCellEditable(i,"sel",0);
		    		   }	
		    		   // New Logic for Event Date
		    		   if (sheetObj.GetCellValue(i, "date_flg") == "Y") {
		    			   sheetObj.SetCellEditable(i,"cntr_sts_evnt_dt",1);
		    		   } else {
		    			   sheetObj.SetCellEditable(i,"cntr_sts_evnt_dt",0);
		    		   }
		    		   // New Logic for Agreement
		    		   if (sheetObj.GetCellValue(i, "agmt_flg") == "Y") {
		    			   sheetObj.SetCellEditable(i,"agmt_seq",1);
		    		   } else {
		    			   sheetObj.SetCellEditable(i,"agmt_seq",0);
		    		   }		    		   
		    	   }
		    	   	    	   
		       } else if ((sheetObj.GetCellValue(i, "cntr_sts_cd") == "SRO" || sheetObj.GetCellValue(i, "cntr_sts_cd") == "DON" || sheetObj.GetCellValue(i, "cntr_sts_cd") == "SCR" || sheetObj.GetCellValue(i, "cntr_sts_cd") == "SLD" || sheetObj.GetCellValue(i, "cntr_sts_cd") == "TLL")  && i != sheetObj.RowCount()){
		    	  if (retgap < 7){		    	   
			    	   sheetObj.SetCellEditable(i,"cntr_sts_evnt_dt",1);
		    		   sheetObj.SetCellEditable(i,"agmt_seq",1);
		    		   //sheetObj.CellEditable(i,"ofc_cd") = true;
		    		   //3.in case of Old/New, editable
				       sheetObj.SetCellEditable(i,"cntr_old_van_flg",1);
		    		   sheetObj.SetCellEditable(i,"cntr_sts_rmk",1);
		    		   sheetObj.SetCellEditable(i,"cntr_lft_chg_amt",1);
		    		   sheetObj.SetCellEditable(i,"curr_cd",1);
			    	   sheetObj.SetCellEditable(i,"rntl_chg_free_dys",1);
			    	   sheetObj.SetCellEditable(i,"cntr_pkup_chg_amt",1);
			    	   sheetObj.SetCellEditable(i,"cntr_pkup_cr_chg_amt",1);
				       sheetObj.SetMinimumValue(i, "cntr_lft_chg_amt",0);
				       sheetObj.SetMinimumValue(i, "rntl_chg_free_dys",0);
				       sheetObj.SetMinimumValue(i, "cntr_pkup_chg_amt",0);
				       sheetObj.SetMinimumValue(i, "cntr_pkup_cr_chg_amt",0);
				       
				       // New Logic for Event Date
		    		   if (sheetObj.GetCellValue(i, "date_flg") == "Y") {
		    			   sheetObj.SetCellEditable(i,"cntr_sts_evnt_dt",1);
		    		   } else {
		    			   sheetObj.SetCellEditable(i,"cntr_sts_evnt_dt",0);
		    		   }
		    		   // New Logic for Agreement
		    		   if (sheetObj.GetCellValue(i, "agmt_flg") == "Y") {
		    			   sheetObj.SetCellEditable(i,"agmt_seq",1);
		    		   } else {
		    			   sheetObj.SetCellEditable(i,"agmt_seq",0);
		    		   }		    		   
		    	   }	    	   
		       } else if (sheetObj.GetCellValue(i, "cntr_sts_cd") == "SRI" && i != sheetObj.RowCount()){
		    	   if (retgap < 7){		       
		    		   sheetObj.SetCellEditable(i,"cntr_sts_evnt_dt",1);
		    		   //3.in case of Old/New, editable
				       sheetObj.SetCellEditable(i,"cntr_old_van_flg",1);
		    		   sheetObj.SetCellEditable(i,"cntr_sts_rmk",1);
		    		   sheetObj.SetCellEditable(i,"cntr_lft_chg_amt",1);
		    		   sheetObj.SetCellEditable(i,"curr_cd",1);
		    		   sheetObj.SetCellEditable(i,"cntr_drff_amt",1);
		    		   sheetObj.SetCellEditable(i,"cntr_drff_cr_amt",1);
				       sheetObj.SetMinimumValue(i, "cntr_drff_amt",0);
				       sheetObj.SetMinimumValue(i, "cntr_drff_cr_amt",0);
				       sheetObj.SetMinimumValue(i, "cntr_lft_chg_amt",0);
				      
				       // New Logic for Event Date
		    		   if (sheetObj.GetCellValue(i, "date_flg") == "Y") {
		    			   sheetObj.SetCellEditable(i,"cntr_sts_evnt_dt",1);
		    		   } else {
		    			   sheetObj.SetCellEditable(i,"cntr_sts_evnt_dt",0);
		    		   }
		    	   }
		       } else if (sheetObj.GetCellValue(i, "cntr_sts_cd") == "SRI" && i == sheetObj.RowCount()){
		    	   if (retgap < 7){		
		    		   sheetObj.SetCellEditable(i,"cntr_sts_evnt_dt",1);
		    		   //3.in case of Old/New, editable하
				       sheetObj.SetCellEditable(i,"cntr_old_van_flg",1);
	    			   // in case of XX or Movement auto creation or (MT & remark = LSI, ....), removing available	    			   
	    			   if (stsval == "XX" || ststpcd == "E" || (stsval == "MT" && (stsrmk == "LSI" || stsrmk == "SBI" || stsrmk == "MUI" || 
	    				   stsrmk == "SRI" || stsrmk == "DII" || stsrmk == "SBR" || stsrmk == "MUR"))){
	    				   if (stsyard == ydcd ){// in case of same yard code, removing available
	    					   sheetObj.SetCellEditable(i,"sel",1);
	    				   }
	    			   }
	    			   //end
		    		   sheetObj.SetCellEditable(i,"cntr_sts_rmk",1);
		    		   sheetObj.SetCellEditable(i,"cntr_lft_chg_amt",1);
		    		   sheetObj.SetCellEditable(i,"curr_cd",1);
		    		   sheetObj.SetCellEditable(i,"cntr_drff_amt",1);
		    		   sheetObj.SetCellEditable(i,"cntr_drff_cr_amt",1);
				       sheetObj.SetMinimumValue(i, "cntr_drff_amt",0);
				       sheetObj.SetMinimumValue(i, "cntr_drff_cr_amt",0);
				       sheetObj.SetMinimumValue(i, "cntr_lft_chg_amt",0);
				       
				       // New Logic for Delete
		    		   if (sheetObj.GetCellValue(i, "delt_flg") == "Y") {
		    			   sheetObj.SetCellEditable(i,"sel",1);
		    		   } else {
		    			   sheetObj.SetCellEditable(i,"sel",0);
		    		   }
		    		   // New Logic for Event Date
		    		   if (sheetObj.GetCellValue(i, "date_flg") == "Y") {
		    			   sheetObj.SetCellEditable(i,"cntr_sts_evnt_dt",1);
		    		   } else {
		    			   sheetObj.SetCellEditable(i,"cntr_sts_evnt_dt",0);
		    		   }				       
		    	   }
		    	   
		       } else if (sheetObj.GetCellValue(i, "cntr_sts_cd") == "SBO" && i == sheetObj.RowCount()){
		    	   if (retgap < 7){		    	   
		    		   sheetObj.SetCellEditable(i,"sel",1);
		    		   sheetObj.SetCellEditable(i,"cntr_sts_evnt_dt",1);
		    		   sheetObj.SetCellEditable(i,"agmt_seq",1);
		    		   sheetObj.SetCellEditable(i,"cntr_pkup_chg_amt",1);
		    		   sheetObj.SetCellEditable(i,"cntr_pkup_cr_chg_amt",1);
		    		   sheetObj.SetCellEditable(i,"rntl_chg_free_dys",1);
		    		   sheetObj.SetCellEditable(i,"cntr_lft_chg_amt",1);
		    		   sheetObj.SetCellEditable(i,"curr_cd",1);
		    		   sheetObj.SetCellEditable(i,"cntr_sts_rmk",1);
				       sheetObj.SetMinimumValue(i, "cntr_pkup_chg_amt",0);
				       sheetObj.SetMinimumValue(i, "cntr_pkup_cr_chg_amt",0);
				       sheetObj.SetMinimumValue(i, "rntl_chg_free_dys",0);
				       sheetObj.SetMinimumValue(i, "cntr_lft_chg_amt",0);
				       
				       // New Logic for Delete
		    		   if (sheetObj.GetCellValue(i, "delt_flg") == "Y") {
		    			   sheetObj.SetCellEditable(i,"sel",1);
		    		   } else {
		    			   sheetObj.SetCellEditable(i,"sel",0);
		    		   }
		    		   // New Logic for Event Date
		    		   if (sheetObj.GetCellValue(i, "date_flg") == "Y") {
		    			   sheetObj.SetCellEditable(i,"cntr_sts_evnt_dt",1);
		    		   } else {
		    			   sheetObj.SetCellEditable(i,"cntr_sts_evnt_dt",0);
		    		   }	
		    		  // New Logic for Agreement
		    		   if (sheetObj.GetCellValue(i, "agmt_flg") == "Y") {
		    			   sheetObj.SetCellEditable(i,"agmt_seq",1);
		    		   } else {
		    			   sheetObj.SetCellEditable(i,"agmt_seq",0);
		    		   }		    		   
		    	   }
		    	   		    	   
		       } else if (sheetObj.GetCellValue(i, "cntr_sts_cd") == "SBO" && i != sheetObj.RowCount()){
		    	   if (retgap < 7){		    	   
		    		   sheetObj.SetCellEditable(i,"agmt_seq",1);
		    		   sheetObj.SetCellEditable(i,"cntr_sts_evnt_dt",1);
			    	   sheetObj.SetCellEditable(i,"cntr_pkup_chg_amt",1);
		    		   sheetObj.SetCellEditable(i,"cntr_pkup_cr_chg_amt",1);
		    		   sheetObj.SetCellEditable(i,"rntl_chg_free_dys",1);
		    		   sheetObj.SetCellEditable(i,"cntr_lft_chg_amt",1);
		    		   sheetObj.SetCellEditable(i,"curr_cd",1);
		    		   sheetObj.SetCellEditable(i,"cntr_sts_rmk",1);
				       sheetObj.SetMinimumValue(i, "cntr_pkup_chg_amt",0);
				       sheetObj.SetMinimumValue(i, "cntr_pkup_cr_chg_amt",0);
				       sheetObj.SetMinimumValue(i, "rntl_chg_free_dys",0);
				       sheetObj.SetMinimumValue(i, "cntr_lft_chg_amt",0);
				       
				       // New Logic for Event Date
		    		   if (sheetObj.GetCellValue(i, "date_flg") == "Y") {
		    			   sheetObj.SetCellEditable(i,"cntr_sts_evnt_dt",1);
		    		   } else {
		    			   sheetObj.SetCellEditable(i,"cntr_sts_evnt_dt",0);
		    		   }
		    		   // New Logic for Agreement
		    		   if (sheetObj.GetCellValue(i, "agmt_flg") == "Y") {
		    			   sheetObj.SetCellEditable(i,"agmt_seq",1);
		    		   } else {
		    			   sheetObj.SetCellEditable(i,"agmt_seq",0);
		    		   }		    		   
		    	   }
		       } else if (sheetObj.GetCellValue(i, "cntr_sts_cd") == "SBI" && i == sheetObj.RowCount()){
		    	   if (retgap < 7){
		    		   if (sheetObj.GetCellValue(i,"cntr_sts_cd") != "LSI"){
				           sheetObj.SetCellEditable(i,"curr_cd",1);
				       }
	    			   if (stsval == "XX" || ststpcd == "E" || (stsval == "MT" && (stsrmk == "LSI" || stsrmk == "SBI" || stsrmk == "MUI" || 
	    				   stsrmk == "DII" || stsrmk == "SBR" || stsrmk == "MUR"))){
	    				   if (stsyard == ydcd ){// in case of same yard code, removing available
	    					   sheetObj.SetCellEditable(i,"sel",1);
	    				   }
	    			   }
				       sheetObj.SetCellEditable(i,"cntr_sts_evnt_dt",1);
		    		   sheetObj.SetCellEditable(i,"cntr_lft_chg_amt",1);
		    		   sheetObj.SetCellEditable(i,"curr_cd",1);
		    		   sheetObj.SetCellEditable(i,"cntr_sts_rmk",1);
		    		   sheetObj.SetCellEditable(i,"cntr_drff_amt",1);
		    		   sheetObj.SetCellEditable(i,"cntr_drff_cr_amt",1);
				       sheetObj.SetMinimumValue(i, "cntr_drff_amt",0);
				       sheetObj.SetMinimumValue(i, "cntr_drff_cr_amt",0);
				       sheetObj.SetMinimumValue(i, "cntr_lft_chg_amt",0);
				       
				      // New Logic for Delete
		    		   if (sheetObj.GetCellValue(i, "delt_flg") == "Y") {
		    			   sheetObj.SetCellEditable(i,"sel",1);
		    		   } else {
		    			   sheetObj.SetCellEditable(i,"sel",0);
		    		   }
		    		   // New Logic for Event Date
		    		   if (sheetObj.GetCellValue(i, "date_flg") == "Y") {
		    			   sheetObj.SetCellEditable(i,"cntr_sts_evnt_dt",1);
		    		   } else {
		    			   sheetObj.SetCellEditable(i,"cntr_sts_evnt_dt",0);
		    		   }				       
		    	   }
		    	   	    		   
		       } else if (sheetObj.GetCellValue(i, "cntr_sts_cd") == "SBI" && i != sheetObj.RowCount()){
		    	   if (retgap < 7){		    	   
			    	   //3.in case of Old/New, editable
				       sheetObj.SetCellEditable(i,"cntr_old_van_flg",1);
				       sheetObj.SetCellEditable(i,"cntr_sts_evnt_dt",1);
		    		   sheetObj.SetCellEditable(i,"cntr_min_onh_dys",1);
		    		   sheetObj.SetCellEditable(i,"cntr_sts_rmk",1);
		    		   sheetObj.SetCellEditable(i,"cntr_drff_amt",1);
		    		   sheetObj.SetCellEditable(i,"cntr_drff_cr_amt",1);
		    		   sheetObj.SetCellEditable(i,"cntr_lft_chg_amt",1);
		    		   sheetObj.SetCellEditable(i,"curr_cd",1);
				       sheetObj.SetMinimumValue(i, "cntr_min_onh_dys",0);
				       sheetObj.SetMinimumValue(i, "cntr_drff_amt",0);
				       sheetObj.SetMinimumValue(i, "cntr_drff_cr_amt",0);
				       sheetObj.SetMinimumValue(i, "cntr_lft_chg_amt",0);
				       
		    		   // New Logic for Event Date
		    		   if (sheetObj.GetCellValue(i, "date_flg") == "Y") {
		    			   sheetObj.SetCellEditable(i,"cntr_sts_evnt_dt",1);
		    		   } else {
		    			   sheetObj.SetCellEditable(i,"cntr_sts_evnt_dt",0);
		    		   }				       
		    	   }
		       } else if (sheetObj.GetCellValue(i, "cntr_sts_cd") == "TTL"){
		    	   if (retgap < 7){		    	   
			    	   sheetObj.SetCellEditable(i,"sel",1);
		    		   sheetObj.SetCellEditable(i,"cntr_pkup_chg_amt",1);
		    		   sheetObj.SetCellEditable(i,"cntr_pkup_cr_chg_amt",1);
		    		   sheetObj.SetCellEditable(i,"rntl_chg_free_dys",1);
		    		   sheetObj.SetCellEditable(i,"cntr_sts_rmk",1);
				       sheetObj.SetMinimumValue(i, "cntr_pkup_chg_amt",0);
				       sheetObj.SetMinimumValue(i, "cntr_pkup_cr_chg_amt",0);
				       sheetObj.SetMinimumValue(i, "rntl_chg_free_dys",0);
				       
				       // New Logic for Delete
		    		   if (sheetObj.GetCellValue(i, "delt_flg") == "Y") {
		    			   sheetObj.SetCellEditable(i,"sel",1);
		    		   } else {
		    			   sheetObj.SetCellEditable(i,"sel",0);
		    		   }
		    	   }
		    	   			    	   
		       } else if (sheetObj.GetCellValue(i, "cntr_sts_cd") == "LST" && i == sheetObj.RowCount()){
		    	   if (retgap < 7){
		    		   sheetObj.SetCellEditable(i,"sel",1);
			    	   sheetObj.SetCellEditable(i,"cntr_sts_evnt_dt",1);
		    		   sheetObj.SetCellEditable(i,"cntr_sts_rmk",1);
		    		   
		    		   // New Logic for Delete
		    		   if (sheetObj.GetCellValue(i, "delt_flg") == "Y") {
		    			   sheetObj.SetCellEditable(i,"sel",1);
		    		   } else {
		    			   sheetObj.SetCellEditable(i,"sel",0);
		    		   }
		    		   // New Logic for Event Date
		    		   if (sheetObj.GetCellValue(i, "date_flg") == "Y") {
		    			   sheetObj.SetCellEditable(i,"cntr_sts_evnt_dt",1);
		    		   } else {
		    			   sheetObj.SetCellEditable(i,"cntr_sts_evnt_dt",0);
		    		   }		    		   
		    	   }			    	   
		       } else if (sheetObj.GetCellValue(i, "cntr_sts_cd") == "LST" && i != sheetObj.RowCount()){
		    	   if (retgap < 7){	
			    	   sheetObj.SetCellEditable(i,"cntr_sts_evnt_dt",1);
		    		   sheetObj.SetCellEditable(i,"cntr_sts_rmk",1);
		    		   
		    		   // New Logic for Event Date
		    		   if (sheetObj.GetCellValue(i, "date_flg") == "Y") {
		    			   sheetObj.SetCellEditable(i,"cntr_sts_evnt_dt",1);
		    		   } else {
		    			   sheetObj.SetCellEditable(i,"cntr_sts_evnt_dt",0);
		    		   }
		    	   }
		       } else if (sheetObj.GetCellValue(i, "cntr_sts_cd") == "FND" && i == sheetObj.RowCount()){
		    	   if (retgap < 7){
			    	   sheetObj.SetCellEditable(i,"cntr_sts_evnt_dt",1);
		    		   sheetObj.SetCellEditable(i,"cntr_sts_rmk",1);
	    			   if (stsval == "XX" || ststpcd == "E" || (stsval == "MT" && (stsrmk == "LSI" || stsrmk == "SBI" || stsrmk == "MUI" || 
	    				   stsrmk == "DII" || stsrmk == "SBR" || stsrmk == "MUR" || stsrmk == "FND"))){
	    				   if (stsyard == ydcd ){// in case of same yard code, removing available
	    					   sheetObj.SetCellEditable(i,"sel",1);
	    				   }
	    			   }
	    			   // New Logic for Delete
		    		   if (sheetObj.GetCellValue(i, "delt_flg") == "Y") {
		    			   sheetObj.SetCellEditable(i,"sel",1);
		    		   } else {
		    			   sheetObj.SetCellEditable(i,"sel",0);
		    		   }
		    		   // New Logic for Event Date
		    		   if (sheetObj.GetCellValue(i, "date_flg") == "Y") {
		    			   sheetObj.SetCellEditable(i,"cntr_sts_evnt_dt",1);
		    		   } else {
		    			   sheetObj.SetCellEditable(i,"cntr_sts_evnt_dt",0);
		    		   }	    			   
		    	   }		    	   
		       } else if (sheetObj.GetCellValue(i, "cntr_sts_cd") == "FND" && i != sheetObj.RowCount()){
		    	   if (retgap < 7){	 
			    	   sheetObj.SetCellEditable(i,"cntr_sts_evnt_dt",1);
			    	   sheetObj.SetCellEditable(i,"cntr_sts_rmk",1);
			    	   
			    	   // New Logic for Event Date
		    		   if (sheetObj.GetCellValue(i, "date_flg") == "Y") {
		    			   sheetObj.SetCellEditable(i,"cntr_sts_evnt_dt",1);
		    		   } else {
		    			   sheetObj.SetCellEditable(i,"cntr_sts_evnt_dt",0);
		    		   }
		    	   }
		       } else if (sheetObj.GetCellValue(i, "cntr_sts_cd") == "SLD"){
		    	   if (retgap < 7){	
				       sheetObj.SetCellEditable(i,"cntr_sts_evnt_dt",1);
				       sheetObj.SetCellEditable(i,"cntr_sts_rmk",1);
				       
				       // New Logic for Event Date
		    		   if (sheetObj.GetCellValue(i, "date_flg") == "Y") {
		    			   sheetObj.SetCellEditable(i,"cntr_sts_evnt_dt",1);
		    		   } else {
		    			   sheetObj.SetCellEditable(i,"cntr_sts_evnt_dt",0);
		    		   }
		    	   }
		       }
	       }else if(sheetObj.GetCellValue(i,"cntr_lstm_cng_flg") == "Y") {
	    	   //sheetObj.SetCellEditable(i,"cntr_sts_evnt_dt",1);
	    	   //sheetObj.SetCellEditable(i,"yd_cd",1);
	    	   if((sheetObj.GetCellValue(i, "cntr_sts_cd") == "MUO" || sheetObj.GetCellValue(i, "cntr_sts_cd") == "SBO") && i == sheetObj.RowCount()) {
	    		   sheetObj.SetCellEditable(i,"sel",1);
	    	   }
	    	   
	    	   // 추가요청 작업 MUO와 SBO는 마지막 ROW 상관없이 아래 해당하는 칼럼은 수정 가능하게
	    	   // 2015.10.20 Park YoungJin
	    	   if((sheetObj.GetCellValue(i, "cntr_sts_cd") == "MUO" || sheetObj.GetCellValue(i, "cntr_sts_cd") == "SBO")) {
	    		   sheetObj.SetCellEditable(i,"cntr_pkup_chg_amt",1);
	    		   sheetObj.SetCellEditable(i,"cntr_pkup_cr_chg_amt",1);
	    		   sheetObj.SetCellEditable(i,"rntl_chg_free_dys",1);
	    		   sheetObj.SetCellEditable(i,"cntr_sts_rmk",1);
	    		   sheetObj.SetCellEditable(i,"cntr_lft_chg_amt",1);
	    		   sheetObj.SetCellEditable(i,"curr_cd",1);
	    	   }
	    	   // New Logic for Delete
    		   if (sheetObj.GetCellValue(i, "delt_flg") == "Y") {
    			   sheetObj.SetCellEditable(i,"sel",1);
    		   } else {
    			   sheetObj.SetCellEditable(i,"sel",0);
    		   }	
    		   // New Logic for Event Date
    		   if (sheetObj.GetCellValue(i, "date_flg") == "Y") {
    			   sheetObj.SetCellEditable(i,"cntr_sts_evnt_dt",1);
    		   } else {
    			   sheetObj.SetCellEditable(i,"cntr_sts_evnt_dt",0);
    		   }
    		   // New Logic for Agreement
    		   if (sheetObj.GetCellValue(i, "agmt_flg") == "Y") {
    			   sheetObj.SetCellEditable(i,"agmt_seq",1);
    		   } else {
    			   sheetObj.SetCellEditable(i,"agmt_seq",0);
    		   }	    		   
	       }
	       
	       /*
		   if(sheetObj.GetCellValue(i, "chk_flg") == "N") {
			   sheetObj.SetRowEditable(i, 0);
		   }
		   */
	    }
	}
	
	function SetGetCellEditableFalse(cnt){
		var sheetObj=sheetObjects[1];
		sheetObj.SetCellEditable(cnt,"sel",0);
		sheetObj.SetCellEditable(cnt,"cntr_sts_cd",0);
		sheetObj.SetCellEditable(cnt,"cntr_sts_evnt_dt",0);
		sheetObj.SetCellEditable(cnt,"yd_cd",0);
		sheetObj.SetCellEditable(cnt,"agmt_cty_cd",0);
		sheetObj.SetCellEditable(cnt,"agmt_seq",0);
		sheetObj.SetCellEditable(cnt,"lstm_cd",0);
		sheetObj.SetCellEditable(cnt,"ref_no",0);
		sheetObj.SetCellEditable(cnt,"vndr_seq",0);
		sheetObj.SetCellEditable(cnt,"vndr_lgl_eng_nm",0);
		sheetObj.SetCellEditable(cnt,"dir_itchg_vndr_seq",0);
		sheetObj.SetCellEditable(cnt,"dir_vndr_lgl_eng_nm",0);
		sheetObj.SetCellEditable(cnt,"ofc_cd",0);
		sheetObj.SetCellEditable(cnt,"cntr_old_van_flg",0);
		sheetObj.SetCellEditable(cnt,"cntr_pkup_chg_amt",0);
		sheetObj.SetCellEditable(cnt,"cntr_pkup_cr_chg_amt",0);
		sheetObj.SetCellEditable(cnt,"cntr_min_onh_dys",0);
		sheetObj.SetCellEditable(cnt,"rntl_chg_free_dys",0);
		sheetObj.SetCellEditable(cnt,"cntr_dir_itchg_fee_amt",0);
		sheetObj.SetCellEditable(cnt,"cntr_drff_amt",0);
		sheetObj.SetCellEditable(cnt,"cntr_drff_cr_amt",0);
		sheetObj.SetCellEditable(cnt,"cntr_lft_chg_amt",0);
		sheetObj.SetCellEditable(cnt,"cntr_lstm_cng_flg",0);
		sheetObj.SetCellEditable(cnt,"cre_dt",0);
		sheetObj.SetCellEditable(cnt,"upd_dt",0);
		sheetObj.SetCellEditable(cnt,"cntr_sts_rmk",0);
		sheetObj.SetCellEditable(cnt,"curr_cd",0);
	}
    /**
     * handling event clicking pop-up button onsheet
     */
    function sheet2_OnPopupClick(sheetObj, Row,Col,Value){
         if (sheetObj.ColSaveName(Col) == "cntr_sts_evnt_dt" ) {
        	 tmpdate=sheetObj.GetCellValue(Row,"cntr_sts_evnt_dt" );
	         var cal=new ComCalendarGrid("myCal");
	         cal.setEndFunction("nextFocusOut");
	         cal.select(sheetObj, Row, Col, 'yyyy-MM-dd');
         } else if (sheetObj.ColSaveName(Col) == "agmt_seq"){
        	 ComOpenPopup('/opuscntr/EES_LSE_0091.do', 805, 450, 'setPopData_Agreement', '0,0,1', true, true, Row, Col);
         } else if (sheetObj.ColSaveName(Col) == "ofc_cd"){
        	 ComOpenPopup('/opuscntr/COM_ENS_071.do', 770, 510, 'getCOM_ENS_071_1', '1,0,1,1,1,1,1,1', true, true, Row, Col);
         } else if (sheetObj.ColSaveName(Col) == "curr_cd"){
        	 var param="cnt_cd=&curr_cd="+sheetObj.GetCellValue(Row,Col)+"&curr_desc=";
        	 ComOpenPopup('/opuscntr/COM_ENS_N13.do?classId=COM_ENS_N13&' + param, 700, 450, 'setPopData_Currency', '0,0,1', true, true, Row, "curr_cd", 1);
         } else if(sheetObj.ColSaveName(Col) == "yd_cd") {
        	 var param="f_cmd="+SEARCH+"&node_cd=&mode=yard";				
        	 ComOpenPopup("/opuscntr/COM_ENS_061.do?"+param, 800, 500, "setPopData_AvailYard", '1,0', true, false, Row, Col, 0);
         }
    }
    
    
    /**
     * handing process Yard Code Pop-up Return Value <br>
     * @param Return value array
     * @param Row index
     * @param Col index
     * @param Sheet Array index
     */
     function setPopData_AvailYard(aryPopupData, Row, Col, sheetIdx) {
     	if(aryPopupData.length > 0) {
     		sheetObjects[1].SetCellValue(Row, "yd_cd",aryPopupData[0][3]);//Yard
		}
     }
    
    /**
	 * handling event when changing Sheet.<br>
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @param Value
	 */
	function sheet2_OnChange(sheetObj, Row, Col, Value) {
		var formObj=document.form;
		with(sheetObj) {
			var sName=ColSaveName(Col);
			switch(sName) {
				case "yd_cd":		// Grid Yard Code Check
					if(GetCellValue(Row,Col) != "") {
					var param="f_cmd="+SEARCH+"&node_cd="+GetCellValue(Row,Col) + "&mode=yard";
 						sheetObj.SetWaitImageVisible(0);
 						var sXml=sheetObj.GetSearchData("COM_ENS_061GS.do",param);
						sheetObj.SetWaitImageVisible(1);
						if ( ComGetTotalRows(sXml) != 1 ) {
							ComShowCodeMessage("MST01019","Yard");
							SetCellValue(Row,"yd_cd","",0);
							return;
						}
					}
					break;
				case "agmt_seq":
					if(GetCellValue(Row,Col) != "") {						
						doActionIBSheet(sheetObj, formObj, IBSEARCH02);
						
						var sel_row = sheetObj.GetSelectRow();		//선택된 현재 row 위치	
						formObj.f_cmd.value=SEARCH05;
						var sXml = sheetObj.GetSearchData("EES_MST_COMGS.do", "f_cmd=105&agmt_cty_cd=" + sheetObj.GetCellValue(sel_row, "agmt_cty_cd") + "&agmt_seq=" + sheetObj.GetCellValue(sel_row, "agmt_seq"));
						
						var agmtseq=ComXmlString(sXml, "agmt_seq").toString();
		    			var lstmcd=ComXmlString(sXml, "lstm_cd").toString();
		    			var vndrlglengnm=ComXmlString(sXml, "vndr_lgl_eng_nm").toString();
		    			var refno = ComXmlString(sXml, "ref_no").toString();
		    			var vndrseq = ComXmlString(sXml, "vndr_seq").toString();
		    			
		     	    	if (ComXmlString(sXml, "ref_no") != ""){
		     	    		
			       	    	sheetObj.SetCellValue(sel_row, "agmt_seq",agmtseq,0);
			       	    	sheetObj.SetCellValue(sel_row, "lstm_cd",lstmcd,0);
			       	    	sheetObj.SetCellValue(sel_row, "ref_no",refno,0);
			       	    	sheetObj.SetCellValue(sel_row, "vndr_seq",vndrseq,0);
			       	    	sheetObj.SetCellValue(sel_row, "vndr_lgl_eng_nm",vndrlglengnm,0);
			       	    	
			       	    	if ((sheetObj.GetCellValue(sheetObj.GetSelectRow(), "cntr_sts_cd") == "SBO" ||
			       	    			sheetObj.GetCellValue(sheetObj.GetSelectRow(), "cntr_sts_cd") == "MUO") && sheetObj.GetSelectRow()!= sheetObj.LastRow()){
			       	    		
				       	    	sheetObj.SetCellValue(sheetObj.GetSelectRow()+1, "agmt_seq",agmtseq,0);
				       	    	sheetObj.SetCellValue(sheetObj.GetSelectRow()+1, "lstm_cd",lstmcd,0);
				       	    	sheetObj.SetCellValue(sheetObj.GetSelectRow()+1, "ref_no",refno,0);
				       	    	sheetObj.SetCellValue(sheetObj.GetSelectRow()+1, "vndr_seq",vndrseq,0);
				       	    	sheetObj.SetCellValue(sheetObj.GetSelectRow()+1, "vndr_lgl_eng_nm",vndrlglengnm,0);
			       	    	} else if (sheetObj.GetCellValue(sheetObj.GetSelectRow(), "cntr_sts_cd") == "LSI"){
			       	    		for(var k=sheetObj.GetSelectRow()+1; k <= sheetObj.LastRow(); k++){
			       	    			if (sheetObj.GetCellValue(k, "cntr_sts_cd") == "LSO" || sheetObj.GetCellValue(k, "cntr_sts_cd") == "LST" || 
			       	    					sheetObj.GetCellValue(k, "cntr_sts_cd") == "FND" || sheetObj.GetCellValue(k, "cntr_sts_cd") == "SCR" || 
		       	    	            		sheetObj.GetCellValue(k, "cntr_sts_cd") == "DON" || sheetObj.GetCellValue(k, "cntr_sts_cd") == "TLL" || 
		       	    	            		sheetObj.GetCellValue(k, "cntr_sts_cd") == "SRO"){
		       	    	    	        	sheetObj.SetCellValue(k, "agmt_seq",agmtseq,0);
		       	    	    	        	sheetObj.SetCellValue(k, "ref_no",refno,0);
		       	    	    	        	sheetObj.SetCellValue(k, "lstm_cd",lstmcd,0);
		       	    	    	        	sheetObj.SetCellValue(k, "vndr_seq",vndrseq,0);
		       	    	    	        	sheetObj.SetCellValue(k, "vndr_lgl_eng_nm",vndrlglengnm,0);
		       	    	            } else if (sheetObj.GetCellValue(k, "cntr_sts_cd") == "LSI" ||
		       	    	            		sheetObj.GetCellValue(k, "cntr_sts_cd") == "DII" ||
		       	    	            		sheetObj.GetCellValue(k, "cntr_sts_cd") == "OWN"){
		       	    	    	        	break;
		       	    	    	    }
			       	    		}
			       	    	}
			       	    	
			       	    	//같은 Agmt Search
			       	    	//SBO이거나 MUO인 경우 같은 Agmt No를 찾는다.
							var strCprCntrStsSeq = "";
							if((sel_sts_cd == "SBO" || sel_sts_cd == "MUO") && sheetObj.GetCellValue(next_row, "cntr_lstm_cng_flg") == "Y") {
								for(var k=1; k <= sheetObj.RowCount(); k++){
									if(tmpagmtseq == sheetObj.GetCellValue(k,"agmt_seq") ) { //기존 Agmt No와 같은 Agmt No Search
										setAgmtChange(sheetObj,strXml,k);//공통 함수로 처리
										
										//선택한 row의 agmt_seq, lstm_cd.. 값을 Set
										sheetObj.SetCellValue(k, "agmt_seq",sheetObj.GetCellValue(sel_row,"agmt_seq"),0);
						       	    	sheetObj.SetCellValue(k, "lstm_cd",sheetObj.GetCellValue(sel_row,"lstm_cd"),0);
						       	    	sheetObj.SetCellValue(k, "ref_no",sheetObj.GetCellValue(sel_row,"ref_no"),0);
						       	    	sheetObj.SetCellValue(k, "vndr_seq",sheetObj.GetCellValue(sel_row,"vndr_seq"),0);
						       	    	sheetObj.SetCellValue(k, "vndr_lgl_eng_nm",sheetObj.GetCellValue(sel_row,"vndr_lgl_eng_nm"),0);
						       	    	
						       	    	//해당 cntr_sts_seq값을 조회
										strCprCntrStsSeq = sheetObj.GetCellValue(k, "cntr_sts_seq");
										break;
									}
								}
								
								if(strCprCntrStsSeq != "") {
									for(var k=1; k <= sheetObj.RowCount(); k++){
										if(strCprCntrStsSeq == sheetObj.GetCellValue(k,"prnr_sts_seq")) {
											setAgmtChange(sheetObj,strXml,k); //공통 함수로 처리
											
											sheetObj.SetCellValue(k, "agmt_seq",sheetObj.GetCellValue(next_row,"agmt_seq"),0);
							       	    	sheetObj.SetCellValue(k, "lstm_cd",sheetObj.GetCellValue(next_row,"lstm_cd"),0);
							       	    	sheetObj.SetCellValue(k, "ref_no",sheetObj.GetCellValue(next_row,"ref_no"),0);
							       	    	sheetObj.SetCellValue(k, "vndr_seq",sheetObj.GetCellValue(next_row,"vndr_seq"),0);
							       	    	sheetObj.SetCellValue(k, "vndr_lgl_eng_nm",sheetObj.GetCellValue(next_row,"vndr_lgl_eng_nm"),0);
										}
									}
								}
							}
						}
					}
					break;
				default :
					//do nothing
			}
		}
 	}
	
    function nextFocusOut(){
    	checkACTDate();
     }
     function sheet2_OnBeforeEdit(sheetObj, Row,Col){
    	var sName=sheetObj.ColSaveName(Col);
    	var formObj=document.form;
        if (sName == "cntr_sts_evnt_dt"){
        	tmpdate=sheetObj.GetCellValue(sheetObj.GetSelectRow(),"cntr_sts_evnt_dt");
        } else if (sName == "agmt_seq"){
        	tmpagmtseq=sheetObj.GetCellValue(sheetObj.GetSelectRow(),"agmt_seq");
        }
     }
     function sheet2_OnAfterEdit(SheetObj, Row,Col){
    	var sName=SheetObj.ColSaveName(Col);
    	var formObj=document.form;
		switch(sName) {
			case "cntr_sts_evnt_dt":
				checkACTDate();
				break;
			case "agmt_seq":
		    	if (SheetObj.GetCellValue(Row,"agmt_seq").trim().length > 0){
			    	//doActionIBSheet(SheetObj, formObj, IBSEARCH01);
				}
				break;
			case "cntr_pkup_chg_amt":
	           	 if((SheetObj.GetCellEditable(Row,"cntr_pkup_cr_chg_amt") == true || SheetObj.GetCellEditable(Row,"cntr_pkup_chg_amt") == true) && SheetObj.GetCellValue(Row,"cntr_pkup_chg_amt") > 0){
	                  	       SheetObj.SetCellValue(Row,"cntr_pkup_cr_chg_amt",0);
	                	 }
				break;	
			case "cntr_pkup_cr_chg_amt":
	           	 if((SheetObj.GetCellEditable(Row,"cntr_pkup_cr_chg_amt") == true || SheetObj.GetCellEditable(Row,"cntr_pkup_chg_amt") == true) && SheetObj.GetCellValue(Row,"cntr_pkup_cr_chg_amt") > 0){
	            	    SheetObj.SetCellValue(Row,"cntr_pkup_chg_amt",0);
	            	 }
				break;
			case "cntr_drff_amt":
	           	 if((SheetObj.GetCellEditable(Row,"cntr_drff_cr_amt") == true || SheetObj.GetCellEditable(Row,"cntr_drff_amt") == true) && SheetObj.GetCellValue(Row,"cntr_drff_amt") > 0){
	                  	       SheetObj.SetCellValue(Row,"cntr_drff_cr_amt",0);
	                	 }
				break;
			case "cntr_drff_cr_amt":
	           	 if((SheetObj.GetCellEditable(Row,"cntr_drff_cr_amt") == true || SheetObj.GetCellEditable(Row,"cntr_drff_amt") == true) && SheetObj.GetCellValue(Row,"cntr_drff_cr_amt") > 0){
	            	    SheetObj.SetCellValue(Row,"cntr_drff_amt",0);
	            	 }    	
				break;				
		}
			
     }
      
     function checkACTDate(){
    	var sheetObj=sheetObjects[1];
//    	var edt=sheetObj.GetCellValue(sheetObj.GetSelectRow(),"cntr_sts_evnt_dt");
    	var edt=sheetObj.GetCellText(sheetObj.GetSelectRow(),"cntr_sts_evnt_dt");
    	if (ComGetNowInfo("ymd") < edt){
    		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "cntr_sts_evnt_dt",tmpdate);
    		ComShowCodeMessage("MST01006");
    		return;
    	}     

    	var retgap= 6 // Del 체크박스가 활성화 될 수 있도록 일시적으로 변경. (기존 ALPS에서는 7개월의 cntr stst만 변경가능했음.)
    	//var retgap=getMonthInterval(edt.replace("-",""), toTimeString(new Date()).substring(0,8)+"0001");
    	
    	var chk_fm_dt=sheetObj.GetCellText(sheetObj.GetSelectRow(),"chk_fm_dt");
    	var chk_to_dt=sheetObj.GetCellText(sheetObj.GetSelectRow(),"chk_to_dt");
    	var pkup_fm_dt=sheetObj.GetCellText(sheetObj.GetSelectRow(),"pkup_fm_dt");
    	var pkup_to_dt=sheetObj.GetCellText(sheetObj.GetSelectRow(),"pkup_to_dt");    	
    	var ltc_flg=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "cntr_lstm_cng_flg");
    	
	    if (retgap < 7){
	    	
	    	if(ltc_flg=="N") {
				if (chk_fm_dt > sheetObj.GetCellValue(sheetObj.GetSelectRow(), "cntr_sts_evnt_dt")){
	 	    		ComShowCodeMessage("MST02052");
	 	    		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "cntr_sts_evnt_dt",tmpdate);
	 	    		return;
	 	    	}	    			
				if (chk_to_dt < sheetObj.GetCellValue(sheetObj.GetSelectRow(), "cntr_sts_evnt_dt")){
	 	    		ComShowCodeMessage("MST02017");
	 	    		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "cntr_sts_evnt_dt",tmpdate);
	 	    		return;
	 	    	}		    		
	    	}
    	
	    	if(sheetObj.GetSelectRow() == sheetObj.RowCount()) { // 마지막 Row 선택시
	    		if(sheetObj.RowCount()!= 1) {
		    		chk_fm_dt = sheetObj.GetCellValue(sheetObj.GetSelectRow()- 1, "cntr_sts_evnt_dt");
					if (chk_fm_dt > sheetObj.GetCellValue(sheetObj.GetSelectRow(), "cntr_sts_evnt_dt")){
		 	    		ComShowCodeMessage("MST02052");
		 	    		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "cntr_sts_evnt_dt",tmpdate);
		 	    		return;
		 	    	}	    			
	    		}
	    	} else {
	    		if(sheetObj.GetSelectRow() != 1) {
		    		chk_fm_dt = sheetObj.GetCellValue(sheetObj.GetSelectRow()- 1, "cntr_sts_evnt_dt");
					if (chk_fm_dt > sheetObj.GetCellValue(sheetObj.GetSelectRow(), "cntr_sts_evnt_dt")){
		 	    		ComShowCodeMessage("MST02052");
		 	    		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "cntr_sts_evnt_dt",tmpdate);
		 	    		return;
		 	    	}	 	    			
	    		}
	    		chk_to_dt = sheetObj.GetCellValue(sheetObj.GetSelectRow()+ 1, "cntr_sts_evnt_dt");
	     		if (chk_to_dt < sheetObj.GetCellValue(sheetObj.GetSelectRow(), "cntr_sts_evnt_dt")){
	 	    		ComShowCodeMessage("MST02017");
	 	    		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "cntr_sts_evnt_dt",tmpdate);
	 	    		return;
	 	    	} 	    		
	    	}

	    	if(ltc_flg=="N") {
		    	 if (sheetObj.GetCellValue(sheetObj.GetSelectRow(), "cntr_sts_cd") == "LSI" ||
	   	    			 sheetObj.GetCellValue(sheetObj.GetSelectRow(), "cntr_sts_cd") == "SBO" ||
	   	    			 sheetObj.GetCellValue(sheetObj.GetSelectRow(), "cntr_sts_cd") == "MUO"){
						if (pkup_fm_dt > sheetObj.GetCellValue(sheetObj.GetSelectRow(), "cntr_sts_evnt_dt")){
			 	    		ComShowCodeMessage("MST02053");
			 	    		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "cntr_sts_evnt_dt",tmpdate);
			 	    		return;
			 	    	}	
			     		if (pkup_to_dt < sheetObj.GetCellValue(sheetObj.GetSelectRow(), "cntr_sts_evnt_dt")){
			 	    		ComShowCodeMessage("MST02053");
			 	    		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "cntr_sts_evnt_dt",tmpdate);
			 	    		return;
			 	    	}					
		    	 }
	    	}
	    } else {
    		ComShowCodeMessage("MST02018");
	    	sheetObj.SetCellValue(sheetObj.GetSelectRow(), "cntr_sts_evnt_dt",tmpdate);
 	    	return;	    	
	    }    	 
     }
   	/**
   	 * handling Currency Pop-up Return Value <br>
   	 * @param {arry} Return value array of returned Values Pop-up screen
   	 * @param  Row index
   	 * @param Col index
   	 * @paramsheet Array index
   	 */
   	function setPopData_Agreement(aryPopupData, Row, Col, SheetIdx) {
   	    var formObj=document.form;
   	    var sheetObj=sheetObjects[1];
   	    if ( aryPopupData.length > 0 ) {
   	    	if ((aryPopupData[0][7] == "OW" ||  aryPopupData[0][7] == "LP" || aryPopupData[0][7] == "OL" || aryPopupData[0][7] == "SO" || aryPopupData[0][7] == "MO") && sheetObj.GetCellValue(Row, "cntr_sts_cd") == "LSI"){
   	    		ComShowCodeMessage("MST01003");
   	    		return;
   	    	}
   	    	if (sheetObj.GetCellValue(Row, "cntr_sts_cd") == "SBO" && aryPopupData[0][7] != "SO"){
  	    		ComShowCodeMessage("MST01003");
  	    		return;
  	    	}
   	    	if (sheetObj.GetCellValue(Row, "cntr_sts_cd") == "MUO" && aryPopupData[0][7] != "MO"){
  	    		ComShowCodeMessage("MST01003");
  	    		return;
  	    	}
   	    	
   	    	
   	    	
   	    	var poptmpagmtseq = sheetObj.GetCellValue(Row, "agmt_seq");
   	    	tmpagmtseq=sheetObj.GetCellValue(sheetObj.GetSelectRow(),"agmt_seq");
   	    	
   	    	sheetObj.SetCellValue(Row, "agmt_seq",aryPopupData[0][5],0);
   	    	//팝업에서 데이타 선택후 Free Days , Handle On/Off Charge(Currency), Handle On/Off Charge 데이타 Display 처리
   	    	var returnVal = doActionIBSheet(sheetObj, formObj, IBSEARCH02);
   	    	if(returnVal == false) {
   	    		return false;
   	    	}
   	    	
   	    	sheetObj.SetCellValue(Row, "agmt_cty_cd",aryPopupData[0][4],0);   	    	
   	    	sheetObj.SetCellValue(Row, "ref_no",aryPopupData[0][6],0);
   	    	sheetObj.SetCellValue(Row, "vndr_seq",aryPopupData[0][8],0);
   	    	sheetObj.SetCellValue(Row, "vndr_lgl_eng_nm",aryPopupData[0][9],0);   	    	
   	    	sheetObj.SetCellValue(Row, "lstm_cd",aryPopupData[0][7],0);
   	    	if ((sheetObj.GetCellValue(Row, "cntr_sts_cd") == "SBO" || sheetObj.GetCellValue(Row, "cntr_sts_cd") == "MUO") && sheetObj.GetSelectRow()!= sheetObj.LastRow()){
   	    	     sheetObj.SetCellValue(Row+1, "agmt_cty_cd",aryPopupData[0][4],0);
	       	     sheetObj.SetCellValue(Row+1, "agmt_seq",aryPopupData[0][5],0);
	       	     sheetObj.SetCellValue(Row+1, "ref_no",aryPopupData[0][6],0);
	       	     sheetObj.SetCellValue(Row+1, "lstm_cd",aryPopupData[0][7],0);
	       	     sheetObj.SetCellValue(Row+1, "vndr_seq",aryPopupData[0][8],0);
	       	     sheetObj.SetCellValue(Row+1, "vndr_lgl_eng_nm",aryPopupData[0][9],0);
   	    	} else if (sheetObj.GetCellValue(Row, "cntr_sts_cd") == "LSI"){
   	    	     for(var k=Row+1; k <= sheetObj.LastRow(); k++){
   	    	    	 if (sheetObj.GetCellValue(k, "cntr_sts_cd") == "LSO" || sheetObj.GetCellValue(k, "cntr_sts_cd") == "LST" || sheetObj.GetCellValue(k, "cntr_sts_cd") == "FND" || sheetObj.GetCellValue(k, "cntr_sts_cd") == "SCR" || sheetObj.GetCellValue(k, "cntr_sts_cd") == "DON" || sheetObj.GetCellValue(k, "cntr_sts_cd") == "TLL" || sheetObj.GetCellValue(k, "cntr_sts_cd") == "SRO"){
   	    	    		sheetObj.SetCellValue(k, "agmt_cty_cd",aryPopupData[0][4],0);
   	    	    		sheetObj.SetCellValue(k, "agmt_seq",aryPopupData[0][5],0);
   	    	    		sheetObj.SetCellValue(k, "ref_no",aryPopupData[0][6],0);
   	    	    		sheetObj.SetCellValue(k, "lstm_cd",aryPopupData[0][7],0);
   	    	    		sheetObj.SetCellValue(k, "vndr_seq",aryPopupData[0][8],0);
   	    	    		sheetObj.SetCellValue(k, "vndr_lgl_eng_nm",aryPopupData[0][9],0);
   	    	    	 } else if (sheetObj.GetCellValue(k, "cntr_sts_cd") == "LSI" ||
   	    	    			 sheetObj.GetCellValue(k, "cntr_sts_cd") == "DII" ||
   	    	    			 sheetObj.GetCellValue(k, "cntr_sts_cd") == "OWN"){
   	    	    	    break;
   	    	    	}
   	    	    }
       	    }
   	    	
   	    	//같은 Agmt Search
   	    	//SBO이거나 MUO인 경우 같은 Agmt No를 찾는다.
			var strCprCntrStsSeq = "";
			var sel_row = sheetObj.GetSelectRow();		//선택된 현재 row 위치
			if(sel_sts_cd == "SBO" || sel_sts_cd == "MUO" && sheetObj.GetCellValue(next_row, "cntr_lstm_cng_flg") == "Y") {
				for(var k=1; k <= sheetObj.RowCount(); k++){
					if(poptmpagmtseq == sheetObj.GetCellValue(k,"agmt_seq")) { //기존 Agmt No와 같은 Agmt No Search
						setAgmtChange(sheetObj,strXml,k);//공통 함수로 처리
						
						//선택한 row의 agmt_seq, lstm_cd.. 값을 Set
						sheetObj.SetCellValue(k, "agmt_seq",sheetObj.GetCellValue(sel_row,"agmt_seq"),0);
		       	    	sheetObj.SetCellValue(k, "lstm_cd",sheetObj.GetCellValue(sel_row,"lstm_cd"),0);
		       	    	sheetObj.SetCellValue(k, "ref_no",sheetObj.GetCellValue(sel_row,"ref_no"),0);
		       	    	sheetObj.SetCellValue(k, "vndr_seq",sheetObj.GetCellValue(sel_row,"vndr_seq"),0);
		       	    	sheetObj.SetCellValue(k, "vndr_lgl_eng_nm",sheetObj.GetCellValue(sel_row,"vndr_lgl_eng_nm"),0);
		       	    	
		       	    	//해당 cntr_sts_seq값을 조회
						strCprCntrStsSeq = sheetObj.GetCellValue(k, "cntr_sts_seq");
						break;
					}
				}
				
				if(strCprCntrStsSeq != "") {
					for(var k=1; k <= sheetObj.RowCount(); k++){
						if(strCprCntrStsSeq == sheetObj.GetCellValue(k,"prnr_sts_seq")) {
							setAgmtChange(sheetObj,strXml,k); //공통 함수로 처리
							
							sheetObj.SetCellValue(k, "agmt_seq",sheetObj.GetCellValue(next_row,"agmt_seq"),0);
			       	    	sheetObj.SetCellValue(k, "lstm_cd",sheetObj.GetCellValue(next_row,"lstm_cd"),0);
			       	    	sheetObj.SetCellValue(k, "ref_no",sheetObj.GetCellValue(next_row,"ref_no"),0);
			       	    	sheetObj.SetCellValue(k, "vndr_seq",sheetObj.GetCellValue(next_row,"vndr_seq"),0);
			       	    	sheetObj.SetCellValue(k, "vndr_lgl_eng_nm",sheetObj.GetCellValue(next_row,"vndr_lgl_eng_nm"),0);
						}
					}
				}
			}
   	    }    
   	}
	function getCOM_ENS_071_1(aryPopupData, Row, Col, SheetIdx) {
   	    var formObj=document.form;
   	    var sheetObj=sheetObjects[1];
   	    if ( aryPopupData.length > 0 ) {
   	    	sheetObj.SetCellValue(Row, "ofc_cd",aryPopupData[0][3]);
   	    }    
   	}
 	/**
	 *  handlingsheet OnPopupClick Event .<br>
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 */
	function setPopData_Currency(aryPopupData, Row, Col, SheetIdx) {
		var formObj=document.form;
		var sheetObj=sheetObjects[1];
		if ( aryPopupData.length > 0 ) {
			sheetObj.SetCellValue(Row,Col,aryPopupData[0][2]);
		}
	} 		
	
	/**
     * Event when clicking Tab
     * activating selected tab items
     */
    function MinimizeSheet1(nItem)
    {
        var objs=document.all.item("showMin");
        var showsheet1=document.all.item("showsheet1");
        var showsheet2=document.all.item("showsheet2");
        if ( nItem == "1" )
        {
    	    objs.style.display="none";
    	    sheetObjects[0].SetSheetHeight(400);
    	    showsheet1.style.display="block";
    	    showsheet2.style.display="none";
    	    $('#btn_minimize1').removeClass('btn_up').addClass('btn_down');
    	}
    	else
    	{
    	    objs.style.display="block";
    	    sheetObjects[0].SetSheetHeight(200);
    	    showsheet1.style.display="block";
    	    showsheet2.style.display="block";
    	    $('#btn_minimize1').removeClass('btn_down').addClass('btn_up');
    	}
    }
    /**
     * Event when clicking Tab
     * activating selected tab items
     */
    function MinimizeSheet2(nItem)
    {
        var objs=document.all.item("showMin");
        var showsheet1=document.all.item("showsheet1");
        var showsheet2=document.all.item("showsheet2");
        if ( nItem == "1" )
        {
    	    objs.style.display="none";
    	    sheetObjects[1].SetSheetHeight(410);
    	    showsheet1.style.display="none";
    	    showsheet2.style.display="block";
    	    $('#btn_minimize2').removeClass('btn_up').addClass('btn_down');
    	}
    	else
    	{
    	    objs.style.display="block";
    	    sheetObjects[1].SetSheetHeight(210);
    	    showsheet1.style.display="block";
    	    showsheet2.style.display="block";
    	    $('#btn_minimize2').removeClass('btn_down').addClass('btn_up');
    	}
    }
