/*=========================================================

*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_LSE_0005.js
*@FileTitle  : Term Change Creation
*@author     : CLT
*@version    : 1.0 
*@since      : 2014/06/16

=========================================================*/
/****************************************************************************************
    Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends
     * @class EES_LSE_0005 : business script for EES_LSE_0005
     */
	   	/* developer job */
	// common global variables
	var sheetObjects=new Array();
	var sheetCnt=0;
	var CheckAlert = "N";
	var seqValue = 0;
	//Event handler processing by button click event */
	document.onclick=processButtonClick;
	//Event handler processing by button name */
	    function processButtonClick(){
	         /**********/
	         var sheetObject=sheetObjects[0];
	         /*******************************************************/
	         var formObj=document.form;
	    	try {
	    		var srcObj= ComGetEvent();
	    		var srcName=ComGetEvent("name");
					switch(srcName) {
						case "di_flag":
		  					div_dcond1.style.display=srcObj.checked ? "inline" : "none"; 
							div_dcond2.style.display=srcObj.checked ? "inline" : "none";
							clearForm("di_vndr_seq");
			  				break;
						case "btn_Retrieve":
							if(ComChkValid(formObj) == true) {
								ComEnableObject(formObj.act_dt, false);
								ComEnableObject(formObj.ofc_cd, false);
								ComEnableObject(formObj.btns_calendar, false);
								ComEnableObject(formObj.btns_search, false);
								doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
							}
		 					break;
						case "btn_Load_Excel":
							if(ComChkValid(formObj) == true) {
								ComEnableObject(formObj.act_dt, false);
								ComEnableObject(formObj.ofc_cd, false);
								ComEnableObject(formObj.btns_calendar, false);
								ComEnableObject(formObj.btns_search, false);
								sheetObjects[1].LoadExcel();
							}
		 					break;
						case "btn_DownExcel":	
							if(sheetObjects[0].RowCount() < 1){//no data
								ComShowCodeMessage("COM132501");
							}else{
								sheetObjects[0].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[0]), SheetDesign:1,Merge:1 });
							} 			
							break;	
						case "btn_New":
							ComResetAll();
							formObj.eff_dt.value = "";
							formObj.exp_dt.value = "";
							div_diFlag.style.display="none";
							div_dcond1.style.display="none";
							div_dcond2.style.display="none";
							ComEnableObject(formObj.act_dt, true);
							ComEnableObject(formObj.ofc_cd, true);
							ComEnableObject(formObj.btns_calendar, true);
							ComEnableObject(formObj.btns_search, true);							
							ComSetFocus(formObj.cur_agmt_seq);
							break;
						case "btn_Save":
							doActionIBSheet(sheetObjects[0], formObj, IBSAVE);
							break;
						case "btns_calendar":		// Activity Date
							if ( srcObj.style.filter == "" ) {
								var cal=new ComCalendar();
				                cal.select(formObj.act_dt, "yyyy-MM-dd");
							}
							break;
						case "btns_search2":	//Current AGMT No.
		 					openPopup("1");
		 					break;
		 				case "btns_search3":	//After AGMT No.
		 					openPopup("2");
		 					break;
						case "btns_search":		//Office Code
		 					openPopup("3");
		 					break;
		 				case "btns_search1":	//Lessor Search
		 					openPopup("4");
		 					break;
						case "cntr_no_multi":	// inputting multi
						    rep_Multiful_inquiry("cntr_list");
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
		function sheet2_OnLoadExcel(sheetObj, result, code, msg) {
			if(isExceedMaxRow(msg))return;
			var formObj = document.form;
			ComOpenWait(true);
		    setTimeout( function () {
		    	doActionIBSheet(sheetObjects[1], formObj, IBSAVE);
		    } , 50);
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
			var formObj=document.form;
	        for(i=0;i<sheetObjects.length;i++){
				ComConfigSheet (sheetObjects[i] );
		        initSheet(sheetObjects[i],i+1);
	            ComEndConfigSheet(sheetObjects[i]);
	        }
			/* Axon Control Setting*/
	    	initControl();
	    	/* Focus Setting */
	    	ComSetFocus(formObj.cur_agmt_seq);
	    	/* act_dt Setting */
	        // $("#act_dt").attr("value", ComGetDateAdd(null, "d", 0));
	    }
		/** registering initial event */
	  	function initControl() {
	  		var formObj=document.form;
	  		axon_event.addListenerFormat('blur',		'obj_blur',		formObj); 
	//		axon_event.addListenerForm('focus',			'obj_focus',	formObj); 
	//  		axon_event.addListenerFormat('keypress',	'obj_keypress',	formObj); 
	//		axon_event.addListenerFormat('keyup',		'obj_keyup',	formObj); 
	//		axon_event.addListenerForm('keydown',		'obj_keydown',	formObj); 
			axon_event.addListenerFormat('change',   	'obj_change',  	formObj); 
	  	}
		//setting event Duplicate
		var preEventType=null;
	  	/**
		 * handling Location blur event
		 **/
		function obj_blur() {
			var obj=ComGetEvent();
			var formObj=document.form;
			if(preEventType == event.type) {
				//preEventType = null;
				//return;
			}
		    switch(ComGetEvent("name")) {
		    	case "cur_agmt_seq" :
		    	case "aft_agmt_seq" :
		    		/* checking number */
		            ComChkObjValid(obj, true, false, false);
		    		break;
		    	case "act_dt":
		    		var now=new Date();
				    var stryear=now.getFullYear();
				    var strmonth=now.getMonth() + 1; // cause jan=0,dec=11
				    var strday=now.getDate();
				    if (("" + strmonth).length == 1) { strmonth="0" + strmonth; }
				    if (("" + strday).length   == 1) { strday="0" + strday;   }
				    var strnowDate ="" + stryear+strmonth+strday;
				    if(parseInt(replaceAll(formObj.act_dt.value,"-","")) > parseInt(strnowDate)) {
				    	ComShowCodeMessage("LSE01162");
				    	formObj.act_dt.value = "" + stryear+"-"+strmonth+"-"+strday
				    	formObj.act_dt.focus();
				    	return false;
				    }
				    
		    		ComChkObjValid(obj);
		    		break;
		    	case "di_vndr_seq" :
		    		/* checking number */
		            ComChkObjValid(obj, true, false, false);
		            break;
		    	default:
		            /* checking Validation */
		            ComChkObjValid(obj);
		        	break;
		    }
		    preEventType=event.type;
		}
		
		/*
		 *  gubun1 = seperator 
		 *  gubun2 = word to be 
		 */
		function replaceAll(Str ,gubun1 ,gubun2){
			var Strname=Str.split(gubun1);
			var returnStr="";
			for(i=0 ; i < Strname.length ; i++) {
				if ( i == Strname.length-1 ){
					returnStr=returnStr + Strname[i];  
				} else {
					returnStr=returnStr + Strname[i]+gubun2;
				}
			}
			return returnStr;
		}
		
		/**
		 * handling event in case of Change
		 */
		function obj_change() {
			var obj=ComGetEvent();
			var formObj=document.form;
			switch(ComGetEvent("name")) {
	  			case "cur_agmt_seq":	//Current Agreement No.
	  				if ( ComTrim(obj.value) != "" ) {
						doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC02);
					}
					break;
				case "aft_agmt_seq":	//After Agreement No.
					if ( ComTrim(obj.value) != "" ) {
						doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC03);
					}
					break;
				case "act_dt":			//Activity Date
	  				if ( ComTrim(obj.value) != "" ) {
		        		doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC04);
	  				}
					break;
				case "ofc_cd":			//Office Code
	  				if ( ComTrim(obj.value) != "" ) {
		        		doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC01);
	  				}
					break;
				case "di_vndr_seq":		//Lessor Code
	  				if ( ComTrim(obj.value) != "" ) {
		        		doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC05);
	  				}
	  				break;
			}
		}
		
	  	/**
	     * setting sheet initial values and header
	     * param : sheetObj, sheetNo
	     * adding case as numbers of counting sheets
	     */
	    function initSheet(sheetObj,sheetNo) {
	        var cnt=0;
			var sheetid=sheetObj.id;
	        switch(sheetid) {
	            case "sheet1":      // sheet1 init
	                with (sheetObj) {
	
		                var HeadTitle="||Seq.|Check|CNTR No.|TP/SZ|On-hire DT|Pick Up Yard|Current Yard|Status|MVMT|MVMT Date||Pick Up Charge|Pick Up Credit|Min O/H Days|Free Days|DII/DIO Fee||||||||||||||||||||||";
		                var headCount=ComCountHeadTitle(HeadTitle);
		                //(headCount, 0, 0, true);
		
		                SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		
		                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		                var headers = [ { Text:HeadTitle, Align:"Center"} ];
		                InitHeaders(headers, info);
		
		                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                       {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"del_chk" },
		                       {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq_no" },
		                       {Type:"Combo",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"err_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"cntr_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Date",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"dp_onh_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"lst_sts_yd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"crnt_yd_cd",	        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"dp_cntr_sts_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"dp_cnmv_sts_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Date",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"cnmv_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:1,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"cntr_pkup_chg_amt",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"cntr_pkup_psv_amt",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
		                       {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"cntr_pkup_ngv_amt",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
		                       {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"cntr_min_onh_dys",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
		                       {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"rntl_chg_free_dys",   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
		                       {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"dii_fee",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
		                       {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"onh_dt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cur_agmt_cty_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cur_agmt_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"aft_agmt_cty_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"aft_agmt_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"act_dt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"di_flag",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"row_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"term_cng_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"seq_set",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"aft_lstm_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"aft_vndr_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cntr_full_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ofc_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"dir_itchg_vndr_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_sts_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"yd_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"loc_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"scc_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ecc_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"lcc_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cntr_sts_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },	
		                       {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cnmv_sts_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },		                     
		                       {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rcc_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
		                       /*{Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rstr_usg_tp_lbl_nm3",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rstr_usg_tp_lbl_nm8",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }*/
		                 
		                InitColumns(cols);
		
		                SetEditable(1);
		                SetShowButtonImage(1);
		                SetColProperty("err_cd", {ComboText:"Total Loss|Disposal|Activity Date|O.K", ComboCode:"T|D|E|O.K"} );
		                SetCountFormat("[SELECTDATAROW / TOTALROWS]");
		                SetSheetHeight(310);
		                ComResizeSheet(sheetObj);
	               }
	                break;
	                
	            case "sheet2":      // sheet2 init
	                with (sheetObj) {
	
		                var HeadTitle="||Seq.|Check|CNTR No.|Pick Up Charge|Pick Up Credit|Min O/H Days|Free Days|DII/DIO Fee";
		                var headCount=ComCountHeadTitle(HeadTitle);
		                //(headCount, 0, 0, true);
		
		                SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		
		                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		                var headers = [ { Text:HeadTitle, Align:"Center"} ];
		                InitHeaders(headers, info);
		
		                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                       {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"del_chk" },
		                       {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq_no" },
		                       {Type:"Combo",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"err_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"cntr_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"cntr_pkup_psv_amt",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
		                       {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"cntr_pkup_ngv_amt",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
		                       {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"cntr_min_onh_dys",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
		                       {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"rntl_chg_free_dys",   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
		                       {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"dii_fee",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 }];
		                 
		                InitColumns(cols);
		
		                SetEditable(1);
		                SetShowButtonImage(1);
		                SetCountFormat("[SELECTDATAROW / TOTALROWS]");
		                SetSheetHeight(220);
	               }
	                break;
	        }
	    }
		/**
		 * handling process for Sheet
		 * @param sheetObj
		 * @param formObj
		 * @param sAction
		 * @param CondParam
		 * @param PageNo
		 */
	    function doActionIBSheet(sheetObj, formObj, sAction, CondParam, PageNo) {
	        sheetObj.ShowDebugMsg(false);
			switch(sAction) {
				case IBSEARCH:
					if(validateForm(sheetObj, formObj, sAction)) {
						if(sheetObj.id == "sheet1") {
							formObj.f_cmd.value=SEARCH;
							//sheetObj.DoSearch4Post("EES_LSE_0005GS.do",FormQueryString(formObj));
							//handing process SpeedOption
							sheetObj.WaitImageVisible = false;
							ComOpenWait(true);
							sheetObj.DoSearch("EES_LSE_0005GS.do",FormQueryString(formObj) );
	          				
						}else if(sheetObj.id == "sheet2") {
							formObj.f_cmd.value=SEARCH02;
							//sheetObjects[0].WaitImageVisible = true;
							ComOpenWait(true);
							sheetObjects[0].DoSearch("EES_LSE_0005GS.do",FormQueryString(formObj)+ "&tmp_seq="+seqValue);
						}
					}
					break;
				case IBSAVE:
					if(validateForm(sheetObj, formObj, sAction)) {
						if(sheetObj.id == "sheet1") {
							if(sheetObj.FindCheckedRow("del_chk") != "") {
								sheetObj.SetWaitImageVisible(0);
								ComOpenWait(true);
								formObj.f_cmd.value=MULTI;			    		
				    			var sParam=sheetObj.GetSaveString(true);
				    			sParam += "&" + FormQueryString(formObj);
								var sXml=sheetObj.GetSaveData("EES_LSE_0005GS.do", sParam);
								sheetObj.LoadSaveData(sXml);
								ComOpenWait(false);
								sheetObj.SetWaitImageVisible(1);
							} else {
								//ComShowMessage(MessageText("UserMsg13"));
							}
						}else if(sheetObj.id == "sheet2") {
							sheetObj.SetWaitImageVisible(0);
							ComOpenWait(true);
							formObj.f_cmd.value=MULTI01;			    		
			    			var sParam=sheetObj.GetSaveString(true);
			    			sParam += "&" + FormQueryString(formObj);
							var sXml=sheetObj.GetSaveData("EES_LSE_0005GS.do", sParam);
							seqValue=ComGetEtcData(sXml, "seqValue");
							sheetObj.LoadSaveData(sXml);
							//ComOpenWait(false);
							//sheetObj.SetWaitImageVisible(1);
						}
					}
					break;
				case IBSEARCH_ASYNC01:	// checking Office Code validation
					if(validateForm(sheetObj,formObj,sAction)) {
			        	var param="f_cmd="+SEARCH16+"&ofc_cd="+ComGetObjValue(formObj.ofc_cd);
						sheetObj.SetWaitImageVisible(0);
						var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do",param);
						sheetObj.SetWaitImageVisible(1);
						if ( sXml != "" ) {
							if ( ComGetEtcData(sXml, "ofc_cd") != undefined ) {
								if ( ComGetEtcData(sXml, "ofc_cd") != "" ) {
									formObj.ofc_cd.value=ComGetEtcData(sXml, "ofc_cd") ;
									ComSetNextFocus(formObj.ofc_cd);
								}else{
									ComShowCodeMessage("LSE01035");
									formObj.ofc_cd.value="";
									ComSetFocus(formObj.ofc_cd);
								}
							} else {
								var errMsg=LseComGetErrMsg(sXml);
								if ( errMsg != "" ) {
									ComShowMessage(errMsg);
								}
								formObj.ofc_cd.value="";
								ComSetFocus(formObj.ofc_cd);
							}
						}
					}
		        	break;
				case IBSEARCH_ASYNC02:	//retrieving when input 'Form Current Agreement No'.
	 				if(validateForm(sheetObj,formObj,sAction)) {
	 					if ( sheetObj.id == "sheet1") {
	 						//handling process for invoice validation
	 						if(formObj.cur_agmt_seq.value == formObj.aft_agmt_seq.value) {
								ComShowCodeMessage('LSE01072');
								clearForm("cur_agmt_seq");
								return;
				            }
	 						ComSetObjValue(formObj.f_cmd, SEARCH03);
	 						var param="f_cmd="+SEARCH03+"&agmt_cty_cd="+ComGetObjValue(formObj.cur_agmt_cty_cd)
	 								  + "&agmt_seq="+ComGetObjValue(formObj.cur_agmt_seq);
	 						sheetObj.SetWaitImageVisible(0);
	 						var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do",param);
							sheetObj.SetWaitImageVisible(1);
							if ( sXml != "" ) {
								if ( ComGetEtcData(sXml, "lstm_cd") != undefined ) {
									ComSetObjValue(formObj.cur_vndr_seq, ComGetEtcData(sXml, "vndr_seq"));
									ComSetObjValue(formObj.cur_vndr_nm,  ComGetEtcData(sXml, "vndr_nm"));
									ComSetObjValue(formObj.cur_lstm_cd,  ComGetEtcData(sXml, "lstm_cd"));
									ComSetObjValue(formObj.cur_ref_no,   ComGetEtcData(sXml, "ref_no"));
									ComSetObjValue(formObj.cur_ctrt_no,   ComGetEtcData(sXml, "lse_ctrt_no"));
									if(/MI|MO/.test(formObj.cur_lstm_cd.value)) {
										div_diFlag.style.display="inline";
									} else {
										div_diFlag.style.display="none";
									}
								} else {
									var errMsg=LseComGetErrMsg(sXml);
									if ( errMsg != "" ) {
										ComShowMessage(errMsg);
									}
									clearForm("cur_agmt_seq");
									ComSetFocus(formObj.cur_agmt_seq);
								}
								div_dcond1.style.display="none";
								div_dcond2.style.display="none";
								formObj.di_flag.checked=false;
								clearForm("di_vndr_seq");
							}
	 					}
					}
					break;
				case IBSEARCH_ASYNC03:	//retrieving when input 'Form After Agreement No.'
	 				if(validateForm(sheetObj,formObj,sAction)) {
	 					if ( sheetObj.id == "sheet1") {
	 						//handling process for invoice validation
	 						if(formObj.cur_agmt_seq.value == formObj.aft_agmt_seq.value) {
								ComShowCodeMessage('LSE01072');
								clearForm("aft_agmt_seq");
								return;
				            }
	 						ComSetObjValue(formObj.f_cmd, SEARCH03);
	 						var param="f_cmd="+SEARCH03+"&agmt_cty_cd="+ComGetObjValue(formObj.aft_agmt_cty_cd)
	 								  + "&agmt_seq="+ComGetObjValue(formObj.aft_agmt_seq);
	 						sheetObj.WaitImageVisible = false;
	 						var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do",param);
							sheetObj.SetWaitImageVisible(1);
							if ( sXml != "" ) {
								if ( ComGetEtcData(sXml, "lstm_cd") != undefined ) {
									ComSetObjValue(formObj.aft_vndr_seq, ComGetEtcData(sXml, "vndr_seq"));
									ComSetObjValue(formObj.aft_vndr_nm,  ComGetEtcData(sXml, "vndr_nm"));
									ComSetObjValue(formObj.aft_lstm_cd,  ComGetEtcData(sXml, "lstm_cd"));
									ComSetObjValue(formObj.aft_ref_no,   ComGetEtcData(sXml, "ref_no"));
									ComSetObjValue(formObj.aft_ctrt_no,   ComGetEtcData(sXml, "lse_ctrt_no"));
									
									ComSetObjValue(formObj.eff_dt,   ComGetEtcData(sXml, "eff_dt"));
									ComSetObjValue(formObj.exp_dt,   ComGetEtcData(sXml, "exp_dt"));
								} else {
									var errMsg=LseComGetErrMsg(sXml);
									if ( errMsg != "" ) {
										ComShowMessage(errMsg);
									}
									clearForm("aft_agmt_seq");
									ComSetFocus(formObj.aft_agmt_seq);
								}
							}
	 					}
					}
					break;
		        case IBSEARCH_ASYNC05:	//retrieving when input Form Lessor No.
					if ( validateForm(sheetObj, formObj, sAction) ) {
						var param="f_cmd="+SEARCH06+"&vndr_seq="+ComGetObjValue(formObj.di_vndr_seq);
						sheetObj.SetWaitImageVisible(0);
						var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do", param);
						sheetObj.SetWaitImageVisible(1);
						if ( sXml != "" ) {
							if ( ComGetEtcData(sXml, "vndr_lgl_eng_nm") != undefined ) {
								ComSetObjValue(formObj.di_vndr_nm, ComGetEtcData(sXml, "vndr_lgl_eng_nm"));
								ComSetFocus(formObj.di_vndr_nm);
	 						} else {
	 							ComShowCodeMessage("LSE01019");
	 							clearForm("di_vndr_seq");
	 						}
						} else {
							var errMsg=LseComGetErrMsg(sXml);
							if ( errMsg != "" ) {
								ComShowMessage(errMsg);
							}
							clearForm("di_vndr_seq");
						}
					}
					break;
			}
	    }
		/**
	     * handling after saving
		 * @param sheetObj
		 * @param ErrMsg
	     */
	    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
	    	if(!/Error/.test(ErrMsg)) {
	    		ComShowCodeMessage("LSE10001");
	    		doActionIBSheet(sheetObj,document.form,IBSEARCH);
	    	}
	    }
	    /**
	     * calling event after retrieving Sheet
		 * @param sheetObj
		 * @param ErrMsg
	     */
	    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	    	//do nothing
	    	for(var i=1;i<=sheetObj.RowCount();i++) {
	    		if(sheetObj.GetCellValue(i,"err_cd") == "T") {
	    			sheetObj.SetRangeFontColor(i, 3, i, 3, "FF0000");
	    		} else if(sheetObj.GetCellValue(i,"err_cd") == "D") {
	    			sheetObj.SetRangeFontColor(i, 3, i, 3, "FF0000");
	    		} else if(sheetObj.GetCellValue(i,"err_cd") == "E") {
	    			sheetObj.SetRangeFontColor(i, 3, i, 3, "FF0000");	    			
	    		}
		    }
	    	sheetObjects[0].WaitImageVisible = false;
	    	ComOpenWait(false);
	    }
	    
	    
	    function sheet2_OnSaveEnd(sheetObj , ErrMsg) { 
	    	var formObject=document.form; 
	    	formObject.cur_ctrt_no.value = "";
	    	sheetObjects[1].RemoveAll();
	    	sheetObjects[0].WaitImageVisible = false;
	    	doActionIBSheet(sheetObjects[1], formObject, IBSEARCH);
	    }
	    
		/**
		 * handling event when changing Sheet.<br>
		 * @param sheetObj
		 * @param Row
		 * @param Col
		 * @param Value
		 */
		function sheet1_OnChange(sheetObj, Row, Col, Value) {
			var formObj=document.form;
			with(sheetObj) {
				var sName=ColSaveName(Col);
				switch(sName) {
					case "cntr_pkup_psv_amt":
						if(Value < 0) {
							SetCellValue(Row,"cntr_pkup_psv_amt",0,0);
						} else {
							SetCellValue(Row,"cntr_pkup_ngv_amt",0,0);
						}
						break;
					case "cntr_pkup_ngv_amt":
						if(Value < 0) {
							SetCellValue(Row,"cntr_pkup_ngv_amt",0,0);
						} else {
							SetCellValue(Row,"cntr_pkup_psv_amt",0,0);
						}
						break;
					case "cntr_min_onh_dys":
					case "rntl_chg_free_dys":
					case "dii_fee":
						if(Value < 0) {
							SetCellValue(Row,Col,0,0);
						}
						break;
				}
	 		}
	 	}
		/**
	     * handing process Pop-up<br>
	     * @param type 1:Agreement(include Ver.) for FORM, 2:Lessor for FORM, 3:Currency for FORM
	     * @param object
	     * @param Row index
	     */
	    function openPopup(type, Row, Col) {
	    	if ( type == "1" ) {
	    		ComOpenPopup('/opuscntr/EES_LSE_0091.do', 820, 480, 'setPopData_CurAgreement', '1,0', true);
	    	} else if ( type == "2" ) {
	    		ComOpenPopup('/opuscntr/EES_LSE_0091.do', 820, 480, 'setPopData_AftAgreement', '1,0', true);
	    	} else if ( type == "3" ) {
				ComOpenPopupWithTarget('/opuscntr/COM_ENS_071.do', 755, 635, "ofc_cd:ofc_cd", "1,0,1,1,1,1,1,1", true);
	    	} else if( type == "4") {
	    		ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 615, 450, 'setPopData_Lessor', '1,0,1,1,1,1,1,1', true);
	    	}
	    	return;
	    }
	    /**
	     * handing process CurAgreement Pop-up Return Value <br>
	     * @param Return value array
	     * @param Row index
	     * @param Col index
	     * @param Sheet Array index
	     */
	    function setPopData_CurAgreement(aryPopupData, Row, Col, SheetIdx) {
	    	var sheetObj=sheetObjects[SheetIdx];
	    	var formObj=document.form;
	    	if ( aryPopupData.length > 0 ) {
	    		ComSetObjValue(formObj.cur_agmt_seq, aryPopupData[0][5]);
	    		ComSetObjValue(formObj.cur_ctrt_no,  aryPopupData[0][15]);
	    		ComSetObjValue(formObj.cur_ref_no,   aryPopupData[0][6]);
	    		ComSetObjValue(formObj.cur_vndr_seq, aryPopupData[0][8]);
	    		ComSetObjValue(formObj.cur_vndr_nm,  aryPopupData[0][9]);
	    		ComSetObjValue(formObj.cur_lstm_cd,  aryPopupData[0][7]);
	    		if(/MI|MO/.test(formObj.cur_lstm_cd.value)) {
					div_diFlag.style.display="inline";
				} else {
					div_diFlag.style.display="none";
				}
				div_dcond1.style.display="none";
				div_dcond2.style.display="none";
				formObj.di_flag.checked=false;
				clearForm("di_vndr_seq");
				if(formObj.cur_agmt_seq.value == formObj.aft_agmt_seq.value) {
					ComShowCodeMessage('LSE01072');
					clearForm("cur_agmt_seq");
				}
	    	}
	    }
	    /**
	     * handing process AftAgreement Pop-up Return Value <br>
	     * @param Return value array
	     * @param Row index
	     * @param Col index
	     * @param Sheet Array index
	     */
	    function setPopData_AftAgreement(aryPopupData, Row, Col, SheetIdx) {
	    	var sheetObj=sheetObjects[SheetIdx];
	    	var formObj=document.form;
	    	if ( aryPopupData.length > 0 ) {
	    		ComSetObjValue(formObj.aft_agmt_seq, aryPopupData[0][5]);
	    		ComSetObjValue(formObj.aft_ctrt_no,  aryPopupData[0][15]);
	    		ComSetObjValue(formObj.aft_ref_no,   aryPopupData[0][6]);
	    		ComSetObjValue(formObj.aft_vndr_seq, aryPopupData[0][8]);
	    		ComSetObjValue(formObj.aft_vndr_nm,  aryPopupData[0][9]);
	    		ComSetObjValue(formObj.aft_lstm_cd,  aryPopupData[0][7]);
	    		
	    		ComSetObjValue(formObj.eff_dt,  aryPopupData[0][10]);
	   	        ComSetObjValue(formObj.exp_dt,  aryPopupData[0][11]);
	    		if(formObj.cur_agmt_seq.value == formObj.aft_agmt_seq.value) {
					ComShowCodeMessage('LSE01072');
					clearForm("aft_agmt_seq");
				}
	    	}
	    }
	    /**
	     * handing process Lessor(Service Provider) Pop-up Return Value <br>
	     * @param Return value array
	     * @param Row index
	     * @param Col index
	     * @param Sheet Array index
		 */
		function setPopData_Lessor(aryPopupData, Row, Col, SheetIdx) {
			var sheetObj=sheetObjects[SheetIdx];
			var formObj=document.form;
			if ( aryPopupData.length > 0 ) {
				ComSetObjValue(formObj.di_vndr_seq, ComLtrim(aryPopupData[0][2],"0"));
				ComSetObjValue(formObj.di_vndr_nm,  aryPopupData[0][4]);
			}
		}
	    /**
	     * handling process for input validation
	     */
	    function validateForm(sheetObj,formObj,sAction){
	        with(formObj) {
	    		switch(sAction) {
	    			case IBSEARCH:
	    				if(ComChkValid(formObj, true)) {
		    				var vAgmtSeq=ComGetObjValue(formObj.cur_agmt_seq);
		    				if(ComGetObjValue(formObj.cur_lstm_cd) == "") {
								ComShowCodeMessage('LSE01056');
								clearForm("cur_agmt_seq");
								return false;
		    				} else if(ComGetObjValue(formObj.aft_lstm_cd) == "") {
								ComShowCodeMessage('LSE01056');
								clearForm("aft_agmt_seq");
								return false;
							} else if(vAgmtSeq == formObj.aft_agmt_seq.value) {
								ComShowCodeMessage('LSE01072');
								clearForm("aft_agmt_seq");
								return false;
		    				}
		    				/* Acvitity Date 체크 로직 제거
		    				var vMiniDate=ComGetDateAdd(null, "M", -1, "").substring(0,6);
		    				if(ComIsDate(formObj.act_dt.value) &&
		    					!/OW|LP|OL/.test(formObj.cur_lstm_cd.value)) {
		    					if(ComReplaceStr(formObj.act_dt.value,"-") < vMiniDate) {
					        		ComShowCodeMessage('LSE01067');
					        		ComSetObjValue(formObj.act_dt, "");
					        		ComSetFocus(formObj.act_dt);
									return false;
		    					}
		    				}
		    				*/
	    				}
						return true;
						break;
	    			case IBSEARCH_ASYNC04:
	    				if(ComChkValid(formObj, true)) {
	    					/*
		    				var vMiniDate=ComGetDateAdd(null, "M", -1, "").substring(0,6);
		    				if(ComIsDate(formObj.act_dt.value) &&
		    					!/OW|LP|OL/.test(formObj.cur_lstm_cd.value)) {
		    					if(ComReplaceStr(formObj.act_dt.value,"-") < vMiniDate) {
					        		ComShowCodeMessage('LSE01067');
					        		ComSetObjValue(formObj.act_dt, "");
					        		ComSetFocus(formObj.act_dt);
									return false;
		    					}
		    				}
		    				*/
	    				}
	    				return true;
	    				break;
	    			case IBSAVE:
						formObj.f_cmd.value=SEARCH23;
						sheetObj.SetWaitImageVisible(0);
						var str_agmt_seq = formObj.aft_agmt_seq.value;
						var chk_date = formObj.act_dt.value;
						
						var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do",FormQueryString(formObj)+"&sch_date="+chk_date+"&sch_agmt_no="+str_agmt_seq);
						sheetObj.SetWaitImageVisible(1);

						if ( sXml != "" ) {
							if ( ComGetEtcData(sXml, "check_date_yn") != undefined && ComGetEtcData(sXml, "check_date_yn") != "") {
								if(ComGetEtcData(sXml, "check_date_yn") == "N") {
									ComShowCodeMessage("LSE10018");
									ComOpenWait(false);
									formObj.act_dt.focus();
									return false;
								}
							} 
						}

						return true;
	    				break;
					default :	//do nothing
	    		}
	    	}
		    with(sheetObj) {
	    		switch(sAction) {
		    		case IBSAVE:
		    			var vDiVndrCd=formObj.di_vndr_seq.value;
		    			if(formObj.di_flag.checked && vDiVndrCd == "") {
		    				ComShowCodeMessage('LSE01044');
				        	ComSetFocus(formObj.di_vndr_seq);
		    				return false;
		    			} else if(vDiVndrCd != "") {
							for(var idx=HeaderRows(); idx <= SearchRows(); idx++) {
								if(GetCellValue(idx,"del_chk") == 1) {
									SetCellValue(idx,"dir_itchg_vndr_seq",vDiVndrCd,0);
			    				}
							}
		    			}
		    			return true;
		    			break;
		    		default : 	//do nothing
	    		}
	    	}
	        return true;
		}
	  	/**
		 * handling process for Form Element Clear<br>
		 * @param fieldName
		 */
		function clearForm(fieldName) {
			var formObj=document.form;
			switch(fieldName) {
				case "cur_agmt_seq":
					ComSetObjValue(formObj.cur_agmt_seq,    "");
					ComSetObjValue(formObj.cur_ctrt_no,     "");
					ComSetObjValue(formObj.cur_ref_no,      "");
					ComSetObjValue(formObj.cur_vndr_seq, 	"");
					ComSetObjValue(formObj.cur_vndr_nm,  	"");
					ComSetObjValue(formObj.cur_lstm_cd,     "");
					div_diFlag.style.display="none";
					div_dcond1.style.display="none";
					div_dcond2.style.display="none";
					formObj.di_flag.checked=false;
					clearForm("di_vndr_seq");
					sheetObjects[0].RemoveAll();
					ComSetFocus(formObj.cur_agmt_seq);
					break;
				case "aft_agmt_seq":
					ComSetObjValue(formObj.aft_agmt_seq,    "");
					ComSetObjValue(formObj.aft_ctrt_no,     "");
					ComSetObjValue(formObj.aft_ref_no,      "");
					ComSetObjValue(formObj.aft_vndr_seq, 	"");
					ComSetObjValue(formObj.aft_vndr_nm,  	"");
					ComSetObjValue(formObj.aft_lstm_cd,     "");
					ComSetObjValue(formObj.act_dt,     	    "");
					sheetObjects[0].RemoveAll();
					ComSetFocus(formObj.aft_agmt_seq);
					break;
				case "di_vndr_seq":
					ComSetObjValue(formObj.di_vndr_seq, 	"");
					ComSetObjValue(formObj.di_vndr_nm,  	"");
					sheetObjects[0].RemoveAll();
					ComSetFocus(formObj.di_vndr_seq);
					break;
			}
		}
		

		function getLse_Multi(rowArray,ret_val) {
			var formObj = document.form;
			var tempText = "";
			//initializing
			formObj.cntr_list.value = '';
			for(var i=0; i<rowArray.length; i++) {
				var colArray = rowArray[i];
				tempText +=  rowArray[i] + ',';
			}
			//clearing comma(,)
			tempText = LseDelLastDelim(tempText);
			tempText = tempText.toUpperCase();
			eval("document.form." + ret_val + ".value = '" + tempText + "';");
		}		
		
		
		function sheet1_OnCheckAllEnd(Col, Value) {
			CheckAlert = "N";
			if(sheetObjects[0].RowCount() > 0) {				
				for(var i=1;i<=sheetObjects[0].RowCount();i++) {
		    		if(sheetObjects[0].GetCellValue(i,"err_cd") == "T" || sheetObjects[0].GetCellValue(i,"err_cd") == "D" || sheetObjects[0].GetCellValue(i,"err_cd") == "E" ) {
		    			sheetObjects[0].SetCellValue(i,"del_chk","N");
		    			CheckAlert = "Y";
		    		}
			    }
				
				if(CheckAlert == "Y") {
					ComShowCodeMessage("LSE10012");		
				}
			}
		}
		
		/**
		 * handling event when OnClick Sheet.
		 */
		function sheet1_OnClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH) {
			var formObj=document.form;
			var sName=sheetObj.ColSaveName(Col);
			with(sheetObj) {
                switch(sName) {
                    case "del_chk":
	                    	switch(sheetObj.GetCellValue(Row, "err_cd")) {
		                    	case "D":
		                    		SetCellValue(Row,"del_chk","N");
		                    		ComShowCodeMessage("LSE10011", sheetObj.GetCellText(Row, "cntr_no"));		                    		
		                    		break;
		                    	case "T":
		                    		SetCellValue(Row,"del_chk","N");
		                    		ComShowCodeMessage("LSE10010", sheetObj.GetCellText(Row, "cntr_no"));		                    		
		                    		break;  
		                    	case "E":
		                    		SetCellValue(Row,"del_chk","N");
		                    		ComShowCodeMessage("LSE10015", sheetObj.GetCellText(Row, "cntr_no"));		                    		
		                    		break;    		                    		
	                    	}
                        break;
                }
			}
		}		
		/* end of developer job */
