/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_LSE_0095.jsp
*@FileTitle  : Lease Agreement Inquery
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/26
=========================================================*/
/****************************************************************************************
    Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	/**
	 * @extends 
	 * @class ees_lse_0095 : business script for ees_lse_0095
	 */
	/* developer job */
	/* common global variables Start *****************************************************/
	// Tab Object Array
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	// Sheet Object Array
	var sheetObjects=new Array();
	var sheetCnt=0;
	// Combo Object Array
	var comboObjects=new Array(); 
	var comboCnt=0;
	/* page setting : retrieve/new inserting/modification */
	var formActionType;
	/* Active status CNTR type/size code string : "|" */
	var orgCntrTpSzCd;
	/* Active status CNTR type/size code array */
	var arrOrgCntrTpSzCd;
	/* page setting code */
	var MODE_CREATE=1001;
	var MODE_MODIFY=1002;
	var MODE_SEARCH=1003;
	var MODE_VRSNUP=1004;
	/* column each tap */
	var t2TabColCnt=0;
	var t3TabColCnt=0;
	var t4TabColCnt=0;
	var t5TabColCnt=0;
	var SEARCH_ENABLE=true;
	var t5sheet1_leftHeaders = [{Text:"Rate/Day", Align:"Left"}];
	/* common global variables End *****************************************************/
	document.onclick=processButtonClick;
	/**
	 *  Event handler processing by button name
	 */
	function processButtonClick() {
		/**********/
		var sheetObject1=sheetObjects[0];   //t1sheet1. General
		var sheetObject2=sheetObjects[1];   //t2sheet1. Per-diem
		var sheetObject3=sheetObjects[2];   //t3sheet1. Handling Charges
		var sheetObject4=sheetObjects[3];   //t4sheet1. DOL/DOC
		var sheetObject5=sheetObjects[4];   //t4sheet2. Desc.
		var sheetObject6=sheetObjects[5];   //t5sheet1. Penalty
		var sheetObject7=sheetObjects[6];   //t6sheet1. DPP
		/*******************************************************/
		var formObj=document.form;
		try {
			var srcObj=ComGetEvent();
			var srcName=ComGetEvent("name");
			switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObject1, formObj, IBSEARCH);
					break;
				case "btn_New":
					ComResetAll();
					/* General Tab - Container Spec No. Column Hidden handling */
					sheetObject1.SetColHidden("cntr_spec_no",1);
					/* retrieve Form setting */
					//setFormEnable(MODE_SEARCH, formObj);	
					tabObjects[0].SetSelectedIndex(0);
					break;
				case "btns_search1":		// Agreement Pop-up
					if ( srcObj.style.filter == "" ) {
						openPopupPage("1");
					}
					break;
				case "btn_t1DownExcel":
					if ( ComIsBtnEnable(srcName) ) {
						doActionIBSheet(sheetObject1, formObj, IBDOWNEXCEL);
					}
					break;
				case "btn_t2DownExcel":
					if ( ComIsBtnEnable(srcName) ) {
						doActionIBSheet(sheetObject2, formObj, IBDOWNEXCEL);
					}
					break;
				case "btn_t3DownExcel":
					if ( ComIsBtnEnable(srcName) ) {
						doActionIBSheet(sheetObject3, formObj, IBDOWNEXCEL);
					}
					break;
				case "btn_t4DownExcel":
					if ( ComIsBtnEnable(srcName) ) {
						doActionIBSheet(sheetObject4, formObj, IBDOWNEXCEL);
					}
					break;
				case "btn_t5DownExcel":
					if ( ComIsBtnEnable(srcName) ) {
						doActionIBSheet(sheetObject6, formObj, IBDOWNEXCEL);
					}
					break;
				case "btn_t6DownExcel":
					if ( ComIsBtnEnable(srcName) ) {
						doActionIBSheet(sheetObject7, formObj, IBDOWNEXCEL);
					}
					break;
			} // end switch
		} catch(e) {
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
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++]=sheet_obj;
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
     * registering IBMultiCombo Object as list
* adding process for list in case of needing batch processing with other items 
* defining list on the top of source
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
		orgCntrTpSzCd=ComGetObjValue(formObj.org_cntr_tpsz_cd);
		arrOrgCntrTpSzCd=orgCntrTpSzCd.split("|");
		/* IBTab init */
		for ( var i=0 ; i < tabObjects.length ; i++ ) {
			initTab(tabObjects[i], i+1);
			tabObjects[i].SetSelectedIndex(0);
		}
		/* IBSheet init */
		for ( var j=0 ; j < sheetObjects.length ; j++ ) {
			ComConfigSheet(sheetObjects[j]);
			initSheet(sheetObjects[j], j+1);
			ComEndConfigSheet(sheetObjects[j]);
		}
		/* initializing IBMultiCombo */
		for ( var k=0 ; k < comboObjects.length ; k++ ) {
	        initCombo(comboObjects[k], k+1);
	    }
		/* Axon Control Setting*/
		initControl();
		/* Form Field GetEnable()/Disable Setting*/
		//setFormEnable(MODE_SEARCH, formObj);
		t1sheet1_OnLoadFinish(t1sheet1);
		
		var vReqAgmtSeq=ComGetObjValue(formObj.req_agmt_seq);
		if ( vReqAgmtSeq != "" ) {
			ComSetObjValue(formObj.agmt_seq, vReqAgmtSeq);
			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);			
		}
	}
  	/* Axon event handling Start ****************************************************************************/
  	function initControl() {
  		var formObj=document.form;
		//axon_event.addListenerFormat('beforedeactivate', 'obj_blur',		formObj); 
  		axon_event.addListenerFormat('blur', 		'obj_blur',		formObj); 
//		axon_event.addListenerFormat('focus',		'obj_focus',	formObj); 
//  	axon_event.addListenerFormat('keypress',	'obj_keypress',	formObj); 
//		axon_event.addListenerFormat('keyup',		'obj_keyup',	formObj); 
//		axon_event.addListenerFormat('keydown',		'obj_keydown',	formObj); 
		axon_event.addListenerForm('change',		'obj_change',	formObj); 
		axon_event.addListenerForm('click',			'obj_click',	formObj); 
  	}
  	// 2. event handling function -- Start
  	/**
	 * handling Location blur event
	 */
	function obj_blur() {
		var obj=ComGetEvent();
	    switch(ComGetEvent("name")){
	        case "agmt_seq":
	        	/* checking number */
	            //if ( !ComChkObjValid(obj, true, false, false) ) {
	            //	ComSetObjValue(obj, "");
	    		//}
	            break;
	        case "vndr_seq":
	            /* checking number */
	            ComChkObjValid(obj, true, false, false);
	            break;
	        default:
	            /* checking Validation */
	            ComChkObjValid(obj);
	        	break;
	    }
  	}
	/**
	 * handling event in case of focus
	 */
//	function obj_focus(){
//		var obj=ComGetEvent();
//		if( obj.readOnly ) {
//			ComSetNextFocus(obj);
//		} else {
//		    /* deleting data unit separator */
//		    ComClearSeparator(ComGetEvent());
//		}
//	}
	/**
	 * Handling in case of HTML Control Value change.
	 */
	function obj_change(){
		var obj=ComGetEvent();
		var formObj=document.form;
		if ( ComTrim(ComGetObjValue(obj)) != "" ) {
			switch(ComGetEvent("name")) {
	    		case "agmt_seq":
	    			ComSetObjValue(formObj.agmt_ver_seq, "");
	    			if ( SEARCH_ENABLE ) {
	    				doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
	    			}
					break;
	    		case "exp_dt":
	    			setDuration();
	    			break;
	    		case "agmt_chg_val":
	    			sheetObjects[5].SetCellValue(1, "agmt_chg_val",ComGetObjValue(formObj.agmt_chg_val));
	    			break;
			}
	    }else{
	    	if(ComGetEvent("name") == "agmt_seq") {
	    		ComResetAll();
	    	}
	    }
	}
	/**
	 * HTML Control handling event in case of Key-Press.
	 */
  /*	function obj_keypress() {
		var obj=ComGetEvent();
		//alert(event.keyCode);
		switch(obj.dataformat) {
	        case "ymd":
	        case "ym":
	        case "hms":
	        case "hm":
	        case "jumin":
	        case "saupja":
	        case "int":
	            ComKeyOnlyNumber(obj);
	            break;
	        case "float":
	            ComKeyOnlyNumber(obj, "-.");
	            break;
	        case "eng":
	        	if ( obj.name == "lse_ctrt_no" || obj.name == "ref_no" ) {
	        		ComKeyOnlyAlphabet("num","45|95");
	        	} else {
	        		ComKeyOnlyAlphabet();
	        	}
	            break;
	        case "engup":
	            ComKeyOnlyAlphabet('upper');
	            break;
	        case "engdn":
	            ComKeyOnlyAlphabet('lower');
	            break;
	        default:
	            ComKeyOnlyNumber(obj);
	        	break;
	    }
  	}*/
  	/**
  	 * HTML Control handling event in case of Key-Up.
  	 */
 /* 	function obj_keyup() {
  		var obj=ComGetEvent();
  		var formObj=document.form;
  		switch(ComGetEvent("name")) {
			case "agmt_seq":
  				if ( ComTrim(ComGetObjValue(obj)) != "" ) {
  					ComKeyEnter('LengthNextFocus');
  				}
  				break;
 			case "vndr_seq":
  				if ( ComTrim(ComGetObjValue(obj)) == "" ) {
  					ComSetObjValue(formObj.vndr_nm,"");
  				} else {
  					ComKeyEnter('LengthNextFocus');
  				}
  				break;
 			default:
  				ComKeyEnter('LengthNextFocus');
  				break;
  		}
  	}*/
  	/**
   	 * HTML Control handling event in case of Key-Down.
   	 */
  	/*function obj_keydown() {
  		var obj=ComGetEvent();
  		var vKeyCode=event.keyCode;
  		var formObj=document.form;
  		switch(ComGetEvent("name")) {
  			case "agmt_seq": 
		  		if ( vKeyCode == 13 ) {
		  			ComSetObjValue(formObj.agmt_ver_seq, "");
		  			SEARCH_ENABLE=false;
		  			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
		  			SEARCH_ENABLE=true;
		  		}
		  		break;
  			case "agmt_rmk":
	  			if ( ComGetLenByByte(obj) > 999) {
	  				ComShowCodeMessage("LSE01021");
	  				return false;
	  			}
	  			break;
  		}
  	}*/
   	function obj_click() {
   		var obj=ComGetEvent();
   		var formObj=document.form;
   		switch(ComGetEvent("name")) {
   			case "lse_vndr_url" :
   				if ( ComGetObjValue(formObj.lse_vndr_url) != "" ) {
   					var url=ComGetObjValue(formObj.lse_vndr_url);
   					if ( (url.substr(0,4)).toLowerCase() != "http" ) {
   						url="http://" + url;
   					}
   					window.open(url,"_blank");
   					return;
   				}
   				break;
   		}
   	}
  	// 2. event handling function -- End
  	/* Axon event handling End ****************************************************************************/
	/**
* setting sheet initial values and header
* param : sheetObj, sheetNo
* adding case as numbers of counting sheets
	 */
   	var leftHeaders = [{Text:"Rate/Day", Align:"Left"}];
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		switch(sheetID) {
			case "t1sheet1":      // t1sheet1 init
			    with(sheetObj){
		      
					var HeadTitle1="||TP/SZ|Spec No.|Qty|REPL Value|PUR OPT Price|PUR OPT Period|Gate In|Gate Out|Remark(s)||";

					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

					var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);

					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
		             {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Popup",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_spec_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"qty",           KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"repl_value",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
		             {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"pur_price",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
		             {Type:"Int",       Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"pur_period",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
		             {Type:"Float",     Hidden:0,  Width:95,   Align:"Right",   ColMerge:0,   SaveName:"gate_in",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
		             {Type:"Float",     Hidden:0,  Width:95,   Align:"Right",   ColMerge:0,   SaveName:"gate_out",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
		             {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:0,   SaveName:"gen_rmk",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:500 },
		             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"loc_cd",        KeyField:0,   CalcLogic:"",   Format:"" },
		             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"eq_loc_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"" }];
		       
					InitColumns(cols);

					SetEditable(0);
		            SetColHidden("cntr_spec_no",1);
		            SetColHidden("del_chk",1);
		            //SetSheetHeight(160);
		            ComResizeSheet(sheetObj);
		            SetColProperty(0 ,"eq_loc_tp_cd" , {DefaultValue:"SC"});
		      }
			break;
			case "t2sheet1":      // t2sheet1 init
			    with(sheetObj){
					var HeadTitle1="||Level|Place|No. of Box|"+orgCntrTpSzCd;
					//t2TabColCnt=ComCountHeadTitle(HeadTitle1);

					SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

					var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);

					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
		             {Type:"Combo",    		Hidden:1, Width:120, Align:"Left",   ColMerge:1, SaveName:"eq_loc_tp_cd",            KeyField:1, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:1, EditLen:2 },
		             {Type:"PopupEdit", Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"loc_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
		             {Type:"Int",       Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:"agmt_chg_val",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:6 } ];
		            for ( var i = 0 ; i < arrOrgCntrTpSzCd.length ; i++ ) {
		            	cols.push({Type:"Float",     Hidden:1,  Width:55,   Align:"Right",   ColMerge:0,   SaveName:"cntr"+(i+1)+"_n1_amt",KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:6});
		            }
		           /* for ( var i = 0 ; i < arrOrgCntrTpSzCd.length ; i++ ) {
		            	eval('GetColHidden("cntr'+(i+1)+'_n1_amt",1);');
		            }*/
		            InitColumns(cols);
		            SetEditable(0);
		            SetColProperty(0 ,"loc_cd" , {AcceptKeys:"E"});
		            SetColProperty(0, 'eq_loc_tp_cd',         {ComboText:eq_loc_tp_cdText,             ComboCode:eq_loc_tp_cdCode} );
		            SetColHidden("del_chk",1);
			        SetSheetHeight(230);
		      }
			break;
			case "t3sheet1":      // t3sheet1 init
			    with(sheetObj){
					var HeadTitle1="|||Level|Place";
					var HeadTitle2="|||Level|Place";
					for ( var i=0 ; i < arrOrgCntrTpSzCd.length ; i++ ) {
						HeadTitle1=HeadTitle1 + "|" + arrOrgCntrTpSzCd[i] + "|" + arrOrgCntrTpSzCd[i];
						HeadTitle2=HeadTitle2 + "|HDL ON|HDL OFF";
					}
					t3TabColCnt=ComCountHeadTitle(HeadTitle1);

					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

					var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
					InitHeaders(headers, info);

					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"del_chk" },
		             {Type:"Text",      Hidden:1, Width:90,   Align:"Right",   ColMerge:1,   SaveName:"agmt_chg_val" },
		             {Type:"Combo",    		Hidden:0, Width:120, Align:"Left",   ColMerge:1, SaveName:"eq_loc_tp_cd",            KeyField:1, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:1, EditLen:2 },
		             {Type:"PopupEdit", Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"loc_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 } ];
		            for ( var i = 0 ; i < arrOrgCntrTpSzCd.length ; i++ ) {
		            	cols.push({Type:"Float",     Hidden:1,  Width:55,   Align:"Right",   ColMerge:0,   SaveName:"cntr"+(i+1)+"_n1_amt",KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 });
		            	cols.push({Type:"Float",     Hidden:1,  Width:55,   Align:"Right",   ColMerge:0,   SaveName:"cntr"+(i+1)+"_n2_amt",KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 });
		            }
		           /* for ( var i = 0 ; i < arrOrgCntrTpSzCd.length ; i++ ) {
		            	eval('GetColHidden("cntr'+(i+1)+'_n1_amt",1);');
		            	eval('GetColHidden("cntr'+(i+1)+'_n2_amt",1);');
		            }*/
		            InitColumns(cols);
		            SetEditable(0);
		            SetColProperty(0 ,"loc_cd" , {AcceptKeys:"E"});
		            SetColProperty(0,'eq_loc_tp_cd',         {ComboText:eq_loc_tp_cdText,             ComboCode:eq_loc_tp_cdCode} );
		            SetColHidden("del_chk",1);
		            SetSheetHeight(180);
//		            SetSheetWidth(1240);
		      }
			break;
			case "t4sheet1":      // t4sheet1 init
			    with(sheetObj){
					var HeadTitle1="||Level|Place";
					var HeadTitle2="||Level|Place";
					for ( var i=0 ; i < arrOrgCntrTpSzCd.length ; i++ ) {
						HeadTitle1=HeadTitle1 + "|" + arrOrgCntrTpSzCd[i] + "|" + arrOrgCntrTpSzCd[i];
						HeadTitle2=HeadTitle2 + "|DOL |DOC";
					}
					t4TabColCnt=ComCountHeadTitle(HeadTitle1);

					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

					var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"},
		                  { Text:HeadTitle2, Align:"Center"} ];
					InitHeaders(headers, info);

					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"del_chk" },
		             {Type:"Combo",    		Hidden:0, Width:120, Align:"Left",   ColMerge:1, SaveName:"eq_loc_tp_cd",            KeyField:1, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:1, EditLen:2 },
		             {Type:"PopupEdit", Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"loc_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 } ];
		            for ( var i = 0 ; i < arrOrgCntrTpSzCd.length ; i++ ) {
		            	cols.push({Type:"Int",       Hidden:1,  Width:55,   Align:"Right",   ColMerge:0,   SaveName:"cntr"+(i+1)+"_chg_val",KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 });
		            	cols.push({Type:"Float",     Hidden:1,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"cntr"+(i+1)+"_n1_amt",KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 });
		            }
		            /*for ( var i = 0 ; i < arrOrgCntrTpSzCd.length ; i++ ) {
		            	eval('GetColHidden("cntr'+(i+1)+'_chg_val",1);');
		            	eval('GetColHidden("cntr'+(i+1)+'_n1_amt",1);');
		            }*/
		            InitColumns(cols);
		            SetEditable(0);
		            SetColProperty(0 ,"loc_cd" , {AcceptKeys:"E"});
		            SetColProperty(0,'eq_loc_tp_cd',         {ComboText:eq_loc_tp_cdText,             ComboCode:eq_loc_tp_cdCode} );
		            SetColHidden("del_chk",1);
		            SetSheetHeight(170);
		      }
			break;
			case "t4sheet2":      // t4sheet2 init
			    with(sheetObj){
					var HeadTitle1="||LOC|Depot|Address|E-mail|PIC|Contract No.|Turn in Ref. No.|";
					SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
					var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
		             {Type:"PopupEdit", Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"loc_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:180,  Align:"Left",    ColMerge:0,   SaveName:"dpt_desc",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:400,  Align:"Left",    ColMerge:0,   SaveName:"addr_desc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:0,   SaveName:"lse_pson_ctrt_eml",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"ctrt_pson_desc",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"ctrt_no_desc",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"turn_ref_no_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:true,UpdateEdit:1 } ,
		             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"eq_loc_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"" }];
					InitColumns(cols);
					SetEditable(0);
					SetColProperty(0 ,"loc_cd" , {AcceptKeys:"E"});
					SetColProperty(0 ,"eq_loc_tp_cd" , {DefaultValue:"SC"});
					SetColHidden("del_chk",1);
					SetSheetHeight(130);
		      }
				break;
			case "t5sheet1":      // t5sheet1 init  
			    with(sheetObj){
					var HeadTitle1="TP/SZ|"+orgCntrTpSzCd+"||||";
					SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
					var info    = { Sort:0, ColMove:1, ColResize:1, HeaderCheck:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);
					var cols = [ {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"TP/SZ" } ];
		            for ( var i = 0 ; i < arrOrgCntrTpSzCd.length ; i++ ) {
		            		  cols.push({Type:"Float",     Hidden:1,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"cntr"+(i+1)+"_n1_amt",KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:8 });
		            }		           
		            cols.push({Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" });
		            cols.push({Type:"Text",      Hidden:1, Width:90,   Align:"Right",   ColMerge:1,   SaveName:"loc_cd" });
		            cols.push({Type:"Text",      Hidden:1, Width:90,   Align:"Right",   ColMerge:1,   SaveName:"agmt_chg_val" });
		            				      cols.push({Type:"Text",      Hidden:1, Width:90,   Align:"Right",   ColMerge:1,   SaveName:"eq_loc_tp_cd" });
		            
		            InitColumns(cols);
		            InitHeadColumn(t5sheet1_leftHeaders,sheetObj);
				      for ( var i=0 ; i < arrOrgCntrTpSzCd.length ; i++ ) {
				    	  SetColHidden("cntr"+i+1+"_n1_amt",1);
				      }	
				      SetCountPosition(0);
				      SetSheetHeight(200);
				      SetColProperty(0 ,"eq_loc_tp_cd" , {DefaultValue:"SC"});
		      }
			    break;
             case "t6sheet1":      // t6sheet1 init  
                 with(sheetObj){
            	 	var HeadTitle1="||TP/SZ|Level|Place|DPP|DPP|DPP|DPP";
            	 	var HeadTitle2="||TP/SZ|Level|Place|Free Days|Coverage Amt|Lump sum Rate|Daily Rate";

            	 	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

            	 	var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            	 	var headers = [ { Text:HeadTitle1, Align:"Center"},
                        { Text:HeadTitle2, Align:"Center"} ];
            	 	InitHeaders(headers, info);
            	 	 
            	 	var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                  {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_rntl_chg_tp_cd",  KeyField:0 },
                  {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                  {Type:"Combo",    	Hidden:0, Width:120, Align:"Left",   ColMerge:1, SaveName:"eq_loc_tp_cd",            KeyField:1, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:1, EditLen:2 },
                  {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"loc_cd",               KeyField:0 },
                  {Type:"Int",       Hidden:0,  Width:195,  Align:"Right",   ColMerge:1,   SaveName:"agmt_chg_dys",         KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
                  {Type:"Float",     Hidden:0,  Width:195,  Align:"Right",   ColMerge:1,   SaveName:"n1st_chg_amt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
                  {Type:"Float",     Hidden:0,  Width:195,  Align:"Right",   ColMerge:1,   SaveName:"agmt_chg_val",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
                  {Type:"Float",     Hidden:0,  Width:195,  Align:"Right",   ColMerge:1,   SaveName:"n2nd_chg_amt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 } ];
            	 	InitColumns(cols);
            	 	SetColProperty(0,'eq_loc_tp_cd',         {ComboText:eq_loc_tp_cdText,             ComboCode:eq_loc_tp_cdCode} );
            	 	SetEditable(0);
            	 	SetSheetHeight(140);
              }
              break;
         }
     }
     /**
      * Tab setting
      */
     function initTab(tabObj , tabNo) {
         switch(tabNo) {
             case 1:
                 with (tabObj) {
                     var cnt=0 ;
					InsertItem( "General", "");
					InsertItem( "Per Diem", "");
					InsertItem( "Handling Charge", "");
					InsertItem( "DOL/DOC", "");
					InsertItem( "Penalty", "");
					InsertItem( "DPP", "");
                 }
                 break;
         }
     }
	function initCombo(comboObj, comboNo) {
		switch(comboObj.options.id) {
			//lstm_cd
			case "combo1":
				with(comboObj) {
					SetDropHeight(250);
					SetMultiSelect(0);
					SetEnable(0);
					//UseAutoComplete = true;
					//ValidChar(2,0);
				}
  	        	break;
  	        //cntr_dpc_lvl_cd
			case "combo2":
				with(comboObj) {
					SetDropHeight(250);
					SetMultiSelect(0);
					SetEnable(0);
					//UseAutoComplete = true;
					//ValidChar(2,0);
				}
  	        	break;
  	        //dpc_val_flg
			case "combo3":
				with(comboObj) {
					SetDropHeight(250);
					SetMultiSelect(0);
					SetEnable(0);
					//UseAutoComplete = true;
					//ValidChar(2,0);
				}
  	        	break;
  	        	 //lse_pay_tp_cd
			case "lse_pay_tp_cd":
				with(comboObj) {
					SetDropHeight(250);
					SetMultiSelect(0);
					SetEnable(0);
					//UseAutoComplete = true;
					//ValidChar(2,0);
				}
  	        	break;
		}
	}
	/**
	 * handling process for Sheet
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 * @return
	 */ 
	
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			case IBCREATE:
				sheetObj.SetWaitImageVisible(0);
				/* Lease Term Form Combo Item Setting */
				ComSetObjValue(formObj.f_cmd, SEARCH01);
 		     	var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do", FormQueryString(formObj));
		        if ( sXml != "" ) {
		        	LseComXml2ComboItem(sXml, comboObjects[0], "lease_term_nm", "lease_term_cd", "|");
		        }
		        /* DEPR Level Form Combo Item Setting */
				var strText="Daily|Monthly|Yearly";
        		var strCode="D|M|Y";
        		LseComText2ComboItem(comboObjects[1], strText, strCode, "|");
		        /* DPC_VAL_FLG Level Form Combo Item Setting */
				var strText2="Manufacture Date|On-Hire Date";
        		var strCode2="N|Y";
        		LseComText2ComboItem(comboObjects[2], strText2, strCode2, "|");
        		/* Container Type/Size Grid Combo Item Setting */
        		if ( orgCntrTpSzCd != "" ) {
        			sheetObj.SetColProperty("cntr_tpsz_cd", {ComboText:"|"+orgCntrTpSzCd, ComboCode:"|"+orgCntrTpSzCd} );
        		}
        		/* Lease Payment Type Code Combo Item Setting 
     		    Blueprint(#9405) : LSE Accrual Function - Modification Request / Question & Expected Process*/
        		ComSetObjValue(formObj.f_cmd, SEARCH09);
				var intgCdId = 'CD30090';
				var param="&intgCdId="+intgCdId;
				var xml=sheetObj.GetSearchData("EES_MST_COMGS.do", FormQueryString(formObj)+param);
				var chk=xml.indexOf("ERROR");
				if (xml.indexOf("ERROR") != -1 || xml.indexOf("Error") != -1){
				   sheetObj.LoadSearchData(xml,{Sync:1} );
				   return;
			    } 
				if (xml != "") {
					var sCntrMtrlCdNm=ComGetEtcData(xml, "code_nm");
					var arrCntrMtrlCdNm=sCntrMtrlCdNm.split("@");
					MakeComboObject(comboObjects[3], arrCntrMtrlCdNm, 1, 0);
				}
        		ComSetFocus(formObj.agmt_seq);
		        sheetObj.SetWaitImageVisible(1);
		        break;
			case IBSEARCH:      //retrieve
				/* Org CNTR type/size code re-setting : Org CNTR type/size code data delete re-setting in case of Form Data setting  */
				ComSetObjValue(formObj.org_cntr_tpsz_cd, orgCntrTpSzCd);
				if(validateForm(sheetObj,formObj,sAction)) {
					if ( sheetObj.id == "t6sheet1" ) {
						/* DPP Tab */
						ComSetObjValue(formObj.f_cmd, SEARCH01);
	            	} else {
//						sheetObj.RenderSheet(0);
	            		ComSetObjValue(formObj.f_cmd, SEARCH);
	            	}
					sheetObj.SetWaitImageVisible(0);
					ComOpenWait(true);
 					var sXml=sheetObj.GetSearchData("EES_LSE_0095GS.do" , FormQueryString(formObj));
					if ( sheetObj.id == "t6sheet1" ) {
						sheetObj.LoadSearchData(sXml,{Sync:1} );
						sheetObj.SetWaitImageVisible(1);
					} else {
						var arrXml=sXml.split("|$$|");
						if (arrXml.length > 0) sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
						if (arrXml.length > 1) sheetObjects[1].LoadSearchData(arrXml[1],{Sync:1} );
						if (arrXml.length > 2) sheetObjects[2].LoadSearchData(arrXml[2],{Sync:1} );
						if (arrXml.length > 3) sheetObjects[3].LoadSearchData(arrXml[3],{Sync:1} );
						if (arrXml.length > 4) sheetObjects[4].LoadSearchData(arrXml[4],{Sync:1} );
						if (arrXml.length > 5) sheetObjects[5].LoadSearchData(arrXml[5],{Sync:1} );
						if (arrXml.length > 6) sheetObjects[6].LoadSearchData(arrXml[6],{Sync:1} );
					}
					ComOpenWait(false);
				}
	            break;
			case IBDOWNEXCEL:
 				with(sheetObj) {
 					var vSheetName=ComReplaceStr(tabObjects[0].GetTabTitle(tabObjects[0].GetSelectedIndex()),"/","_");
					if ( TotalRows < 1 ) {
						var row=DataInsert(0);
						SetRowHidden(row,1);
						Down2Excel({ HiddenColumn:1,Merge:true,TreeLevel:false,SheetName:"vSheetName"});
						RowDelete(row, false);
					} else {
						Down2Excel({ HiddenColumn:1,Merge:true,TreeLevel:false,SheetName:"vSheetName"});
					}
 				}
 				break;
		}
	}
 	function t1sheet1_OnLoadFinish(sheetObj) {
		var formObj=document.form;
		/* IBMulti Combo Item Setting */
		doActionIBSheet(sheetObj, formObj, IBCREATE);
	}
	/**
	 * Lease Agreement Master/General Tab IBSheet Object Search-End Event
	 */
	function t1sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		var formObj=document.form;
		if ( ErrMsg == "" ) {
			ComEtcDataToForm(formObj, sheetObj);
			/* InActive CheckBox Setting */
			if ( ComGetObjValue(formObj.agmt_act_flg) == "Y" ) {
				formObj.chk_agmt_act_flg.checked=true;
			} else {
				formObj.chk_agmt_act_flg.checked=false;
			}
			/* ICF Flag CheckBox Setting */
			if ( ComGetObjValue(formObj.itchg_fee_flg) == "Y" ) {
				formObj.chk_itchg_fee_flg.checked=true;
			} else {
				formObj.chk_itchg_fee_flg.checked=false;
			}
			/* SLB CheckBox Setting */
			if ( ComGetObjValue(formObj.slb_flg) == "Y" ) {
				formObj.chk_slb_flg.checked=true;
			} else {
				formObj.chk_slb_flg.checked=false;
			}
			
			comboObjects[0].SetSelectCode(ComGetObjValue(formObj.lstm_cd));
			comboObjects[1].SetSelectCode(ComGetObjValue(formObj.cntr_dpc_lvl_cd));
			comboObjects[2].SetSelectCode(ComGetObjValue(formObj.dpc_val_flg));
			/* DPP Coverage value == 'N' -> DPP Tab disable */
			if ( ComGetObjValue(formObj.dpp_tp_cd) == "Y" ) {
					tab1.SetTabDisable(5, false)
			} else {
					tab1.SetTabDisable(5, true);
			}
			/* Mask add */
			ComAddSeparator(form.eff_dt, "ymd");
			ComAddSeparator(form.exp_dt, "ymd");
			ComAddSeparator(form.agmt_dt, "ymd");
			ComAddSeparator(form.bld_up_dt, "ymd");
			/* Duration calc */
			setDuration();
			/* (Lease Term) General Sheet Control */
			control_Spec_No(ComGetObjValue(formObj.combo1));
			sheetObj.RenderSheet(1);
			/* retrieve mode */
			//setFormEnable(MODE_SEARCH, formObj);
			
			// <begin> 2015.11.25 BluePrint#7808: Office user access restriction to screens that have Per diem/lease related info By Jun Kato 
			//To check if the office code is not stored in Internal Info. Setup ( BCM_CCD_0041 )
			//Pre condition : When login user is not HO office user.
			if (!OfficeCodeMgr.checkContainOfficeCode("000002", "LSE", ComGetObjValue(formObj.usr_ofc_cd)) ) {
				//To disable “General”, “Per Diem” and “Penalty” tabs
				tab1.SetTabDisable(0, true);
				tab1.SetTabDisable(1, true);
				tab1.SetTabDisable(4, true);
				tabObjects[0].SetSelectedIndex(2);
			}else{
			tabObjects[0].SetSelectedIndex(0);
		
			}
			//<end> 2015.11.25 BluePrint#7808: Office user access restriction to screens that have Per diem/lease related info By Jun Kato  
			
			
		} else {
			ComResetAll();
			/* retrieve Form setting */
			//setFormEnable(MODE_SEARCH, formObj);
		}
		sheetObj.RenderSheet(1);
		/* Org CNTR type/size code re-setting : Org CNTR type/size code data delete re-setting in case of Form Data setting  */
		ComSetObjValue(formObj.org_cntr_tpsz_cd, orgCntrTpSzCd);
	}
	/**
	 * Penalty Tab IBSheet Object Search-End Event
	 */
	function t5sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		if( sheetObj.RowCount() < 1){
		   InitHeadColumn(t5sheet1_leftHeaders,sheetObj);
	    } else {
		   InitHeadText(t5sheet1_leftHeaders,sheetObj);
  	    }
	    sheetObj.SetCellFontColor(1, 0, "#000000");
		   
		var formObj=document.form;
		if ( sheetObj.SearchRows()> 0 ) {
			ComSetObjValue(formObj.agmt_chg_val, sheetObj.GetCellValue(1,"agmt_chg_val"));
		} else {
			ComSetObjValue(formObj.agmt_chg_val, "");
			sheetObj.SetCellValue(1, "loc_cd",ConstantMgr.getBaseLocationCode());
			sheetObj.SetRowStatus(1,"R");
		}
		
		var lstcol = sheetObj.LastCol();
        for ( var i=0 ; i < lstcol ; i++ ) {
        	if(sheetObj.GetCellValue(1, i) == ""){
        		sheetObj.SetColHidden("cntr"+i+1+"_n1_amt",1);
        	}
        }	

	}
	
	function tab1_OnChange(tabObj , nItem)
	{
		var formObj=document.form;
		var objs=document.all.item("tabLayer");
		objs[nItem].style.display="Inline";	
		//---------------------------------------------//
		for(var i = 0; i<objs.length; i++){
			  if(i != nItem){
			   objs[i].style.display="none";
			   objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
			  }
			}
		//--------------------------------------------------------//
		beforetab=nItem;
		resizeSheet();
		//if ( formActionType == MODE_MODIFY ) {
			switch(nItem) {
				case 1 :	// Per-diem
					if ( ComGetObjValue(formObj.combo1) == "LT" ) {
						sheetObjects[1].SetColHidden("agmt_chg_val",1);
						sheetObjects[1].SetColHidden("eq_loc_tp_cd",0);
						sheetObjects[1].SetColHidden("loc_cd",0);
					} else {
						sheetObjects[1].SetColHidden("agmt_chg_val",0);
						sheetObjects[1].SetColHidden("eq_loc_tp_cd",1);
						sheetObjects[1].SetColHidden("loc_cd",1);
					}
					break;
			}
		//}
		/* General Tab Container Type/Size Column Show */
		switch(nItem) {
			case 1 :	// Per-diem
				setCntrTypeSizeColumns(sheetObjects[0], sheetObjects[1]);
				break;
			case 2 :	// Handling Charges
				setCntrTypeSizeColumns(sheetObjects[0], sheetObjects[2]);
				break;
			case 3 :	// DOL/DOC
				setCntrTypeSizeColumns(sheetObjects[0], sheetObjects[3]);
				break;
			case 4 :	// Penalty
				setCntrTypeSizeColumns(sheetObjects[0], sheetObjects[5]);
				break;
			case 5 :	// DPP
				//setCntrTypeSizeRows(sheetObjects[0], sheetObjects[6]);
				break;
		}
	}
	/**
	 * Sheet Object Container Type/Size code string return
	 * @param sourceSheetObj : Source Sheet of Container Type/Size
	 * @param targetSheetObj : Target Sheet of Container Type/Size
	 */
	/*
	function getGeneralCntrTypeSizes(sheetObj) {
		var vSelectedCntrTpSz="";
		if ( sheetObj.RowCount()> 0 ) {
			for ( var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++ ) {
				if ( sheetObj.GetRowHidden(i) == false ) {
					if ( vSelectedCntrTpSz != "" ) {vSelectedCntrTpSz=vSelectedCntrTpSz + "|" + sheetObj.GetCellValue(i, "cntr_tpsz_cd");
					} 
					else {vSelectedCntrTpSz=sheetObj.GetCellValue(i, "cntr_tpsz_cd");
					}
				}
			}
		}
		return vSelectedCntrTpSz;
	}
	*/
	
	function getGeneralCntrTypeSizes(sheetObj) {
		var vSelectedCntrTpSz="";
		if ( sheetObj.RowCount()> 0 ) {
			for ( var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++ ) {
				if ( sheetObj.GetRowHidden(i) == false ) {
					if ( vSelectedCntrTpSz != "" ) {
						vSelectedCntrTpSz=vSelectedCntrTpSz + "|" + sheetObj.GetCellValue(i, "cntr_tpsz_cd");
					} else {
						vSelectedCntrTpSz=sheetObj.GetCellValue(i, "cntr_tpsz_cd");
					}
				}
			}
		}
		return vSelectedCntrTpSz;
	}
    /**
	 * Per-diem/Handling Charges/DOLDOC/Penalty Tab Container Type/Size Setting
	 * Target Sheet Container Type/Size Column 
	 * @param sourceSheetObj : Source Sheet of Container Type/Size
	 * @param targetSheetObj : Target Sheet of Container Type/Size
	 */
	function setCntrTypeSizeColumns(sourceSheetObj, targetSheetObj) {
		var vSelectedCntrTpSz=getGeneralCntrTypeSizes(sourceSheetObj);
		var vShowSheetWidth=0;
		var vStartCntrColIdx=0;
		
		if ( vSelectedCntrTpSz != "" || vSelectedCntrTpSz == "") {
			with(targetSheetObj) {
				RenderSheet(0);
				
				if ( targetSheetObj.id == "t2sheet1") {
					if ( ComGetObjValue(document.form.combo1) == "LT" ) {
						vStartCntrColIdx=4;
						SetColWidth(3, 80);
					}else{
						vStartCntrColIdx=5;
						SetColWidth(4, 80);
					}
				} else if ( targetSheetObj.id == "t3sheet1"){
					vStartCntrColIdx=5;
					SetColWidth(4, 80);
				} else if ( targetSheetObj.id == "t4sheet1"){
					vStartCntrColIdx=4;
					SetColWidth(3, 80);
				} else if ( targetSheetObj.id == "t5sheet1"){
					SetColWidth(0, 80);
					vStartCntrColIdx=1;
				} else {
					vStartCntrColIdx=1;
				}
				
				/* Frozened Column Width calc(Hidden Column except) */
				for ( var colIdx=0 ; colIdx < vStartCntrColIdx ; colIdx++ ) {
					if ( GetColHidden(colIdx) == false ) {
						vShowSheetWidth=vShowSheetWidth + GetColWidth(colIdx);
					}
				}
				
				/* General Tab inserted Container Type/Size Column Width calc  */
				var viewColCount = 0;
				for ( var colIdx=vStartCntrColIdx ; colIdx <= LastCol(); colIdx++ ) {
					if ( GetCellValue(0, colIdx) != "" ) {
						if ( vSelectedCntrTpSz.match(GetCellValue(0, colIdx)) ) {
							if ( GetColHidden(colIdx) == true ) {
								SetColHidden(colIdx,0);
							}
							vShowSheetWidth=vShowSheetWidth + GetColWidth(colIdx)+10;
						} else {
							if ( GetColHidden(colIdx) == false ) {
								//for ( var i = HeaderRows ; i <= RowCount+(HeaderRows-1) ; i++ ) {
								SetColWidth(colIdx, 80);
//								for ( var i=HeaderRows(); i <= LastRow(); i++ ) {
//									SetCellValue(i, colIdx,"",0);
//								}
								SetColHidden(colIdx,1);
							}
						}
					}
					viewColCount += GetColHidden(colIdx);
				}
				
				SetSheetWidth(120 * (LastCol() - viewColCount + 1));
 				if ( RowCount()>= 3 ) {
					vShowSheetWidth=vShowSheetWidth + 30;
				} else {
					vShowSheetWidth=vShowSheetWidth + 20;
				}
 				
				if ( vShowSheetWidth > mainTable.clientWidth-20 ) {
					SetSheetWidth(mainTable.clientWidth-20);
				} else {
					SetSheetWidth(vShowSheetWidth);
				}
				RenderSheet(1);
			}
		}
		targetSheetObj.SetVisible(1);
	}
    /**
	 * DPP Tab Container Type/Size Setting
	 * Target Sheet Container Type/Size Row 
	 * @param sourceSheetObj : Source Sheet of Container Type/Size
	 * @param targetSheetObj : Target Sheet of Container Type/Size
	 */
	function setCntrTypeSizeRows(sourceSheetObj, targetSheetObj) {
		var formObj=document.form;
		/* Source Sheet Container Type/Size */
		var vGeneralCntrTpSz=getGeneralCntrTypeSizes(sourceSheetObj);
		/* Target Sheet Container Type/Size */
		var vDppCntrTpSz=getGeneralCntrTypeSizes(targetSheetObj);
		with(targetSheetObj) {
			if ( RowCount()> 0 ) {
				/* Target Sheet Container Type/Size existing -> compare, insert  */
				if ( (vGeneralCntrTpSz != "") && (vGeneralCntrTpSz != vDppCntrTpSz) ) {
					var arrGeneralCntrTpSz=vGeneralCntrTpSz.split("|");
					for ( var i=0 ; i < arrGeneralCntrTpSz.length ; i++ ) {
						if ( !vDppCntrTpSz.match(arrGeneralCntrTpSz[i]) ) {
							var Row=DataInsert(-1);
							SetCellValue(Row, "cntr_tpsz_cd",arrGeneralCntrTpSz[i],0);
							//SetCellValue(Row, "loc_cd",ConstantMgr.getBaseLocationCode(),0);
							SetCellValue(Row, "loc_cd","ALL",0);
							InitCellProperty(Row,"loc_cd" , {Type:"Text",Edit:"0"});
							SetCellValue(Row, "cntr_rntl_chg_tp_cd","DPPV",0);
						}
					}
					var arrDppCntrTpSz=vDppCntrTpSz.split("|");
					for ( var i=0 ; i < arrDppCntrTpSz.length ; i++ ) {
						if ( !vGeneralCntrTpSz.match(arrDppCntrTpSz[i]) ) {
							var Row=FindText("cntr_tpsz_cd", arrDppCntrTpSz[i]);
							SetRowHidden(Row,1);
							SetRowStatus(Row,"D");
						}
					}
				}
			} else {
				if ( vGeneralCntrTpSz != "" ) {
					var arrGeneralCntrTpSz=vGeneralCntrTpSz.split("|");
					for ( var i=0 ; i < arrGeneralCntrTpSz.length ; i++ ) {
						var Row=DataInsert(-1);
						SetCellValue(Row, "cntr_tpsz_cd",arrGeneralCntrTpSz[i],0);
						SetCellValue(Row, "loc_cd",ConstantMgr.getBaseLocationCode(),0);;
						SetCellValue(Row, "cntr_rntl_chg_tp_cd","DPPV",0);
					}
				}
			}
		}
	}
	/**
	 * Pop-up Open <br>
	 * @param type 1:Agreement(include Ver.) for FORM, 2:Lessor for FORM, 3:Currency for FORM
	 * @param object  Object
	 * @param Row Row index
	 */
	function openPopupPage(type, Row, Col, SheetIdx) {
		var formObj=document.form;
		if ( type == "1" ) {
			if ( ComGetObjValue(formObj.agmt_ver_seq) != "" ) {
				ComOpenPopup('/opuscntr/EES_LSE_0002.do?agmt_seq='+ComGetObjValue(formObj.agmt_seq), 850, 470, 'setPopData_AgreementVer', '1,0', true);
			} else {
				ComOpenPopup('/opuscntr/EES_LSE_0091.do', 805, 480, 'setPopData_Agreement', '1,0', true);
			}
		}
	}
	/**
	 * Agreement Pop-up Return Value handling<br>
	 * @param {arry} returnedValues Pop-up page Return value array
	 * @param Row Row index
	 * @param Col Col index
	 * @param IBSheet Sheet Array index
	 */
	function setPopData_Agreement(aryPopupData, Row, Col, SheetIdx) {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		if ( aryPopupData.length > 0 ) {
			document.form.agmt_seq.value=aryPopupData[0][5];
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
		}
	}
	/**
	 * Agreement Pop-up Return Value handling<br>
	 * @param {arry} returnedValues Pop-up 화면의 Return value array
	 * @param Row Row index
	 * @param Col Col index
	 * @param 대상IBSheet의 Sheet Array index
	 */
	function setPopData_AgreementVer(aryPopupData, Row, Col, SheetIdx) {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		if ( aryPopupData.length > 0 ) {
			ComSetObjValue(formObj.agmt_seq,     aryPopupData[0][4]);
			ComSetObjValue(formObj.agmt_ver_seq, aryPopupData[0][8]);
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
      	}
	}
	/**
	 * Form by page setting, Objects using/unusing handling<br>
	 * @param type
	 * @param formObj
	 */
	function setFormEnable(type, formObj) {
		switch(type) {
			case MODE_SEARCH :
				if ( formActionType != MODE_SEARCH ) {
					formActionType=MODE_SEARCH;
					LseComEnableForm(false, formObj, "agmt_cty_cd|agmt_ver_seq|dt_drtn|vndr_nm|ofc_cd");
					LseComMndtForm(formObj,"agmt_seq");
					if ( formObj.vndr_seq.className != "input2" ) {
						//ComEnableManyObjects(false, formObj.vndr_seq);
						ComEnableObject(formObj.vndr_seq, false);
					}
					if ( formObj.eff_dt.className != "input2" ) {
						//ComEnableManyObjects(false, formObj.eff_dt);
						ComEnableObject(formObj.eff_dt, false);
					}
					if ( formObj.exp_dt.className != "input2" ) {
						//ComEnableManyObjects(false, formObj.eff_dt);
						ComEnableObject(formObj.exp_dt, false);
					}
					ComEnableManyObjects(true, btns_search1);
				}
				//ComSetFocus(formObj.agmt_seq);
				break
		}
	}
	/**
	 * handling process for input validation
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 */
	function validateForm(sheetObj, formObj, sAction) {
		switch(sAction) {
			case IBSEARCH:
				if ( ComGetObjText(formObj.agmt_seq) == "" ) {
					ComShowCodeMessage("LSE01006");
					ComSetFocus(formObj.agmt_seq);
					return false;
				} else {
					if ( !ComChkObjValid(formObj.agmt_seq, true, false, false) ) {
						ComSetFocus(formObj.agmt_seq);
						return false;
					}
				}
				break;
			case IBSEARCH_ASYNC01:
				if( ComGetObjText(formObj.vndr_seq) == "" ) {
					ComShowCodeMessage("LSE01044");
					ComSetFocus(formObj.vndr_seq);
					return false;
				}
				break;
		}
		return true;
    }
	/**
	 * Effective Date insert, Duration calc handling<br>
	 */
    function setDuration() {
    	var formObj=document.form;
    	if ( !checkEffDate() ) {
       		ComSetFocus(formObj.exp_dt);
       		return;
       	}
   		var input1=ComReplaceStr(ComGetObjValue(formObj.eff_dt), "-", "");
   		var input2=ComReplaceStr(ComGetObjValue(formObj.exp_dt), "-", "");
   		var duration=LseComGetMonthsDateDiffNew(input1, input2);
		ComSetObjValue(formObj.dt_drtn, duration);
    }
	/**
	 * Effective Date Validation handling<br>
	 */
    function checkEffDate() {
    	var formObj=document.form;
		/* Effective Date Validation(eff_dt) */
		if( ComGetObjValue(formObj.eff_dt) == "" ) {
			ComShowCodeMessage("LSE01010");
			ComSetFocus(formObj.eff_dt);
			return false;
		} else if ( !ComIsDate(formObj.eff_dt) ) {
			ComShowCodeMessage("LSE01020");
			ComSetObjValue(formObj.eff_dt,"");
			ComSetFocus(formObj.eff_dt);
			return false;
		}
		/* Effective Date Validation(exp_dt) */
		if( ComGetObjValue(formObj.exp_dt) == "" ) {
			ComShowCodeMessage("LSE01011");
			ComSetFocus(formObj.exp_dt);
			return false;
		} else if ( !ComIsDate(formObj.exp_dt) ) {
			ComShowCodeMessage("LSE01026");
			ComSetObjValue(formObj.exp_dt,"");
			ComSetFocus(formObj.exp_dt);
			return false;
		}
		/* Effective Date Validation(eff_dt < exp_dt) */
		var vEffDt=ComReplaceStr(ComGetObjValue(formObj.eff_dt),"-","");
		var vExpDt=ComReplaceStr(ComGetObjValue(formObj.exp_dt),"-","");
		if ( ComChkPeriod(vEffDt, vExpDt) != 1 ) {
			ComShowCodeMessage("LSE01051");
			ComSetObjValue(formObj.exp_dt,"");
			ComSetFocus(formObj.exp_dt);
			return false;
		}
		return true;
    }
	/*
	 * Container Spec No. Cell Control
	 * - Lease Term == 'LT' & 'ST' & 'SI -> Genearl Data Spec No. insert.
	 */
	function control_Spec_No (text) {
		var sheetObj=sheetObjects[0];
		if ( text == "LT" || text == "ST" || text == "SI" ) {
			sheetObj.SetColHidden("cntr_spec_no",0);
		} else {
			sheetObj.SetColHidden("cntr_spec_no",1);
		}
	}
	
	function resizeSheet(){
        for (i=0; i<sheetObjects.length; i++){
        	if(i == 3 || i==4) {
        	}else{
            	ComResizeSheet(sheetObjects[i]);
        	}
        }
    }
	/**
	 * creating combo object(Spec No * Type/Size)
	 */
	function MakeComboObject(cmbObj, arrStr, txtCol, codeCol) {
		cmbObj.RemoveAll();
		cmbObj.InsertItem(0, "", "");
		for (var i=0; i<arrStr.length; i++) {
			var arrCode=arrStr[i].split("|");
			cmbObj.InsertItem(i+1, arrCode[codeCol] + '|' + arrCode[txtCol], arrCode[codeCol]);
		}
		cmbObj.SetSelectIndex("" ,false);
	}	

	/* end of developer job */
