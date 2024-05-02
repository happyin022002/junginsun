/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_LSE_0011.js
*@FileTitle : Operational Lease Payable Invoice Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================*/
/****************************************************************************************
    Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	/**
	 * @extends
	 * @class EES_LSE_0011 :  business script for EES_LSE_0011
	 */
	function EES_LSE_0011() {
		this.processButtonClick=tprocessButtonClick;
		this.setSheetObject=setSheetObject;
		this.loadPage=loadPage;
		this.initSheet=initSheet;
		this.initControl=initControl;
		this.doActionIBSheet=doActionIBSheet;
		this.setTabObject=setTabObject;
		this.validateForm=validateForm;
	}
	/* developer job */
	// common global variables
	var sheetObjects=new Array(); 
	var sheetCnt=0;
	// Combo Object Array
	var comboObjects=new Array();
	var comboCnt=0;
	var arrAgmtNoInfo=new Array();
	var preVndrSeq="";
	var usrOfcCd="";
	//Event handler processing by button click event */
	document.onclick=processButtonClick;
	//Event handler processing by button name */
	function processButtonClick(){
		/**********/
		var sheetObject1=sheetObjects[0];
		var sheetObject2=sheetObjects[1];
		/*******************************************************/
		var formObj=document.form;
		//try {
			var srcName=ComGetEvent("name");
			switch(srcName) {
				case "btn_RowAdd":
					doActionIBSheet(sheetObject1, formObj, IBINSERT);
					break;
				case "btn_RowDelete":
					if ( ComShowCodeConfirm("COM12165", "") ) {
						doActionIBSheet(sheetObject1, formObj, IBDELETE);
					}
					break;
				case "btn_SoCreate":
					doActionIBSheet(sheetObject1, formObj, IBSAVE);
					break;
				case "btn_Retrieve":
					doActionIBSheet(sheetObject1, formObj, IBSEARCH);
					break;
				case "btn_New":
					ComResetAll();
					sheetObjects[0].ClearHeaderCheck();
					ComSetObjValue(formObj.usr_ofc_cd, usrOfcCd);
					break;
				case "btns_calendar1":
					var cal=new ComCalendarFromTo();
	                //cal.select(formObj.bil_fm_dt, 'yyyy-MM-dd');
					cal.select(formObj.bil_fm_dt, formObj.bil_to_dt, 'yyyy-MM-dd');
					break;
				//case "btns_calendar2":
				//	var cal=new ComCalendar();
	            //  cal.select(formObj.bil_to_dt, 'yyyy-MM-dd');
				//	break;
				case "btns_calendar3":
					var cal=new ComCalendar();
	                cal.select(formObj.inv_rcv_dt, 'yyyy-MM-dd');
					break;
				case "btns_calendar4":
					var cal=new ComCalendar();
	                cal.select(formObj.inv_iss_dt, 'yyyy-MM-dd');
					break;
				case "btn_InvoiceCreation":
					if( ComGetObjText(formObj.inv_rcv_dt) == "" ) {
						ComShowCodeMessage("LSE01123");
						ComSetFocus(formObj.inv_rcv_dt);
						return false;
					}
					
					
					if( ComGetObjText(formObj.inv_iss_dt) == "" ) {
						ComShowCodeMessage("LSE01111");
						ComSetFocus(formObj.inv_iss_dt);
						return false;
					}
					
					var costName = "";
					var costNameChk = "";
					for(var i=1;i<=sheetObjects[1].RowCount();i++) {
						costName = sheetObjects[1].GetCellValue(i,"acct_cd");
						if(costName == "") {
							costNameChk = "Y";
							break;
						}
					}
					
					if ( costNameChk != "Y" && sheetObjects[1].RowCount()> 0 ) {
						if ( ComShowCodeConfirm("LSE01120") ) {
							doActionIBSheet(sheetObject2, formObj, IBSAVE);
						}
					}else{
						ComShowCodeConfirm("LSE01166")
						return false;
					}
					
					
					

					break;
				case "btn_Office":
					openPopupPage("10");
        			break;
				case "btns_search2":	//Currency Code
 					openPopup("2");
 					break;
				case "btns_search3":     // lessor
					openPopup("3");
					break;
				case "btn_minimize1":	//minimizing sheet 1
					if(sheetObjects[0].GetSheetHeight() == "260") {
						sheetObjects[0].SetSheetHeight(170);
						$('#btn_minimize1').removeClass('btn_up').addClass('btn_down');
					}else{
						sheetObjects[0].SetSheetHeight(260);
						$('#btn_minimize1').removeClass('btn_down').addClass('btn_up');
					}
					
                    break;
				case "btn_minimize2":	//minimizing sheet 1
					if(sheetObjects[1].GetSheetHeight() == "200") {
						sheetObjects[1].SetSheetHeight(100);
						$('#btn_minimize2').removeClass('btn_up').addClass('btn_down');
					}else{
						sheetObjects[1].SetSheetHeight(200);
						$('#btn_minimize2').removeClass('btn_down').addClass('btn_up');
					}
					
                    break;
				case "btn_VaTax":
					openPopupPage("11");
        			break;
                case "btn_WhTax":
					openPopupPage("12");
        			break;
			} // end switch
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
		for ( var i=0 ; i < sheetObjects.length ; i++ ) {
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		/* initializing IBMultiCombo */
		for ( var k=0 ; k < comboObjects.length ; k++ ) {
	        initCombo(comboObjects[k], k+1);
	    }
		
		sheet1_OnLoadFinish(sheetObjects[0]);
		/* Axon Control Setting*/
		initControl();
		usrOfcCd=ComGetObjValue(formObj.usr_ofc_cd);
		
		//Container Use Company Code setting
		//ComLseTextCode2ComboItem(vndrSeqComboValue, vndrSeqComboText, getComboObject(comboObjects, 'vndr_seq') ,"|","\t" );
	}
	/** registering initial event */
  	function initControl() {
  		var formObj=document.form;
  		//axon_event.addListenerForm('beforedeactivate',		'obj_blur',		formObj); 
  		axon_event.addListenerForm('blur',		'obj_blur',		formObj); 
		axon_event.addListenerForm('focus',		'obj_focus',	formObj); 
  		axon_event.addListenerFormat('keypress','obj_keypress',	formObj); 
		axon_event.addListenerForm('keyup',		'obj_keyup',	formObj); 
		axon_event.addListenerForm('keydown',	'obj_keydown',	formObj); 
		axon_event.addListenerForm('change',	'obj_change',	formObj); 
  	}
  	/**
	 * handling Location blur event
	 */
	function obj_blur(){
  		var formObj=document.form;
  		var obj=event.srcElement;
	    switch(ComGetEvent("name")){
	    	case "bil_to_dt":
	    		ComChkObjValid(obj);
	    		checkEffDate(formObj.bil_fm_dt, formObj.bil_to_dt);
	    		break;
	    	/*case "agmt_seq":
	    		if ( document.form.agmt_seq.value == null || document.form.agmt_seq.value == "" ) {
	    			document.form.contract_no.value="";
	    			sheetObjects[0].RemoveAll();
					removePage();
	    		}
	    		break;*/
	    	case "vndr_seq":
	    		if ( document.form.vndr_seq.value == null || document.form.vndr_seq.value == "" ) {
	    			document.form.vndr_nm.value="";
	    			document.form.abbr_nm.value="";
	    			sheetObjects[0].RemoveAll();
					removePage();
	    		}
	    		break;
	    	default:
	            //checking Validation
	            ComChkObjValid(obj);
	        	break;
	    }
	}
	/**
	 * handling event in case of focus
	 */
	function obj_focus(){
		var obj=event.srcElement;
		if( obj.readOnly ) {
			ComSetNextFocus(obj);
		} else {
		    //deleting data unit separator
			if(obj.name != "bil_to_dt") {
				//ComClearSeparator(event.srcElement);
			}
		}
	}
	/**
	 * handling event in case of Key-Press
	 */
  	function obj_keypress() {
		var obj=event.srcElement;
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
	            ComKeyOnlyAlphabet();
	            break;
	        case "engup":
	        	if ( obj.name == "cost_ofc_cd" ) {
	        		ComKeyOnlyAlphabet('uppernum');
	        	} else {
	        		ComKeyOnlyAlphabet('upper');
	        	}
	            break;
	        case "engdn":
	            ComKeyOnlyAlphabet('lower');
	            break;
	        default:
	            ComKeyOnlyNumber(obj);
	        	break;
	    }
  	}
  	/**
  	 * handling event in case of Key-Up
  	 */
  	function obj_keyup() {
  		var obj=event.srcElement;
  		var formObj=document.form;
  		var vKeyCode=event.keyCode;
  		switch(ComGetEvent("name")) {
			case "bil_fm_dt":
			case "bil_to_dt":
				if ( vKeyCode == 13 ) {
					doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
				}
  				break;
  		}
  	}
   	/**
	 * handling event in case of Key-Down
	 */
   	function obj_keydown() {
	   	var formObj=document.form;
		var obj=event.srcElement;
   		var vKeyCode=event.keyCode;
   		switch(ComGetEvent("name")) {
	   		case "inv_rmk":
				// 힌글입력방지
	    		if ( event.keyCode == "229" ) {
	    			event.returnValue=false;
	    			return true;
	    		}
				if ( ComGetLenByByte(obj) > 999) {
	  				ComShowCodeMessage("LSE01021");
	  				return false;
	  			}
	  			break;
		}
   	}
	/**
	 * handling event in case of Change
	 */
	function obj_change() {
		var obj=event.srcElement;
		var formObj=document.form;
		if ( ComTrim(ComGetObjValue(obj)) != "" ) {
			switch(ComGetEvent("name")) {
				/*case "agmt_seq":
					if ( formObj.agmt_seq.value != null && formObj.agmt_seq.value != "" ) {
						doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC04);
					}else{
						document.form.contract_no.value="";
						document.form.vndr_seq.value="";
						document.form.abbr_nm.value="";
						document.form.vndr_nm.value="";
						
		    			sheetObjects[0].RemoveAll();
						removePage();
					}
					break;*/
				case "vndr_seq":
					if ( formObj.vndr_seq.value != null && formObj.vndr_seq.value != "" ) {
						doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC05);
					}
					break;
	    		case "curr_cd":
	    			doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC02);
				   	break;
	    		case "cost_ofc_cd":			//Office Code
					if ( ComTrim(obj.value) != "" ) {
						doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC03);
					}
					break;
	    		case "inv_vat_amt":
	    		case "whld_tax_amt":
	    			formObj.inv_ttl_amt.value = 	parseFloat(ComReplaceStr(isGetNull(formObj.inv_amt.value),",","")) + 
	    													parseFloat(ComReplaceStr(isGetNull(formObj.inv_vat_amt.value),",","")) - 
	    													parseFloat(ComReplaceStr(isGetNull(formObj.whld_tax_amt.value),",",""));
	    			
	    			formObj.inv_ttl_amt.value = ComAddComma(Math.round(formObj.inv_ttl_amt.value * 100)/100);
	    			
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
		var sheetID=sheetObj.id;
		switch(sheetID) {
			case "sheet1":
			    with(sheetObj){
		        
		      var HeadTitle1="||STS|Lessor|Lessor Name|Payment Period|Payment Period|REV VVD|REV VVD|REV VVD|REV VVD|Date|TP/SZ|Qty.|AGMT No.|Contract No.|Currency|Principal|Balance|Interest|Libor|Payment|Invoice No|Remarks|||||||||V.A.Tax|W.H.Tax|";
		      var headCount=ComCountHeadTitle(HeadTitle1);

		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

		      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);

		      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"chkbox" },
		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"op_lse_sts_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:140,  Align:"Left",    ColMerge:0,   SaveName:"vndr_lgl_eng_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Date",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"bil_fm_dt",        KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
		             {Type:"Date",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"bil_to_dt",        KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"vsl_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:33,   Align:"Center",  ColMerge:0,   SaveName:"skd_voy_no",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
		             {Type:"Text",      Hidden:0,  Width:14,   Align:"Center",  ColMerge:0,   SaveName:"skd_dir_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:14,   Align:"Center",  ColMerge:0,   SaveName:"rev_dir_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Date",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"pay_dt",           KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
		             {Type:"Combo",     Hidden:0, Width:55,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"op_lse_qty",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		             {Type:"Combo",     Hidden:0, Width:105,   Align:"Center",  ColMerge:0,   SaveName:"agmt_no",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"lse_ctrt_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"PopupEdit",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
		             {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"prin_amt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
		             {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"bal_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
		             {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"int_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
		             {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"libor_amt",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
		             {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"pay_amt",          KeyField:1,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"inv_no",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
		             {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",  ColMerge:0,   SaveName:"diff_rmk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:250 },
		             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"op_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
		             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"agmt_cty_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
		             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"agmt_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
		             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"co_ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
		             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cre_ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
		             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"acct_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
		             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cost_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
		             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cost_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
		             {Type:"Float",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"inv_vat_amt",            KeyField:0,   CalcLogic:"",   Format:"Float",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Float",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"whld_tax_amt",            KeyField:0,   CalcLogic:"",   Format:"Float",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"inv_ttl_amt",            KeyField:0,   CalcLogic:"",   Format:"" ,            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
		       
		      InitColumns(cols);
		      SetSheetHeight(170,1);
		      SetEditable(1);
		      SetCountPosition(0);
		      //InitDataValid(0, "skd_voy_no",	vtNumericOnly);
		      SetColProperty(0 ,"curr_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});
		      SetColProperty(0 ,"skd_voy_no" , {AcceptKeys:"N"});
		      SetColProperty(0 ,"inv_no" , {AcceptKeys:"E|[0123456789 -]" , InputCaseSensitive:1});
		      }
		      break;


			case "sheet2":
			    with(sheetObj){
		        
		      var HeadTitle1="|Seq.|Invoice No.|VVD|Cost Code|Cost Name|AGMT No.|Contract No.|Charge\nType|TP/SZ|Amount|Credit Amount||||||||";
		      var headCount=ComCountHeadTitle(HeadTitle1);

		      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

		      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);

		      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"inv_no",             KeyField:0,   CalcLogic:"",   Format:"" },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"vvd",                KeyField:0,   CalcLogic:"",   Format:"" },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"acct_cd",            KeyField:0,   CalcLogic:"",   Format:"" },
		             {Type:"Text",      Hidden:0,  Width:170,  Align:"Left",    ColMerge:1,   SaveName:"cost_nm",            KeyField:0,   CalcLogic:"",   Format:"" },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"agmt_no",            KeyField:0,   CalcLogic:"",   Format:"" },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"lst_ctrt_no",        KeyField:0,   CalcLogic:"",   Format:"" },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"lse_pay_chg_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"" },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",       KeyField:0,   CalcLogic:"",   Format:"" },
		             {Type:"Float",     Hidden:0,  Width:120,   Align:"Right",   ColMerge:1,   SaveName:"ttl_cost_amt",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2 },
		             {Type:"Float",     Hidden:0,  Width:120,   Align:"Right",   ColMerge:1,   SaveName:"cr_amt",             KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2 },
		             {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"agmt_cty_cd",        KeyField:0,   CalcLogic:"",   Format:"" },
		             {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"agmt_seq",           KeyField:0,   CalcLogic:"",   Format:"" },
		             {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"op_seq",             KeyField:0,   CalcLogic:"",   Format:"" },
		             {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"cost_cd",            KeyField:0,   CalcLogic:"",   Format:"" },
		             {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"op_lse_qty",         KeyField:0,   CalcLogic:"",   Format:"" },
		             {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"inv_vat_amt",            KeyField:0,   CalcLogic:"",   Format:""},
		             {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"whld_tax_amt",            KeyField:0,   CalcLogic:"",   Format:"" },
		             {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"inv_ttl_amt",            KeyField:0,   CalcLogic:"",   Format:"" ,            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
		       
		      InitColumns(cols);
		      SetSheetHeight(100,1);
		      SetEditable(0);
		      SetCountPosition(0);
		            }


			break;
		}
	}
	/**
	 * initializing IBMultiCombo
	 */
	function initCombo(comboObj, comboNo) {
		/*switch(comboObj.id) {
			case "vndr_seq":
				with(comboObj) {
					SetDropHeight(250);
					SetMultiSelect(1);
					SetUseAutoComplete(1);
                    
                    
				}
 	        	break;
		}*/
	}
	// handling process for Sheet
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
		case IBCREATE:
			sheetObj.SetWaitImageVisible(0);
			/* Vendor Combo Item Setting */
			
			var sParam="f_cmd=" + SEARCH04;
			sParam=sParam + "&lstm_cd=LPOL";			
			var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do", sParam);
	        if ( sXml != "" ) {
	        	var vndrNm=ComGetEtcData(sXml, "vndr_nm");
	        	var vndrSeq=ComGetEtcData(sXml, "vndr_seq");
	        	var arrVndrNm=vndrNm.split("|");
	        	var arrVndrSeq=vndrSeq.split("|");
	        	var j=0;
	        	for ( var i=0 ; i < arrVndrSeq.length ; i++ ) {
	        		ComLseTextCode2ComboItem(arrVndrSeq[i], arrVndrNm[i], getComboObject(comboObjects, 'tmp_vndr_seq') ,"|","\t" );	        					        		
	        	}
	        	comboObjects[0].SetColWidth(0, "100");
	        	comboObjects[0].SetColWidth(1, "220");
        		comboObjects[0].SetSelectIndex(0);
    			//sheetObj.SetColProperty("tmp_vndr_seq", {ComboText:ComGetEtcData(sXml ,"vndr_seq"), ComboCode:ComGetEtcData(sXml,"vndr_seq")} );
	        }			
	        
    		/* Sheet Combo Setting : Container Type Size */
			ComSetObjValue(formObj.f_cmd, SEARCH02);
			var sXml1=sheetObj.GetSearchData("EES_LSE_COMGS.do",FormQueryString(formObj));
			if ( ComGetEtcData(sXml1,"TRANS_RESULT_KEY") == "S" ) {
				sheetObj.SetColProperty("cntr_tpsz_cd", {ComboText:'XX|'+ComGetEtcData(sXml1 ,"cntr_tpsz_nm"), ComboCode:'XX|'+ComGetEtcData(sXml1,"cntr_tpsz_cd")} );
				sheetObj.SetColProperty("cntr_tpsz_cd", {DefaultValue:"XX"});				
			}
			
			/* Sheet Combo Setting : Lessor */
			//sheetObj.InitDataCombo(0, "vndr_seq", "ICC\t69|UINTAS\t5588", "69|5588", "ICC", "69", 0);
			/* Sheet Combo Setting : Agreement No. */
			/*var sParam="f_cmd=" + SEARCH15;
			sParam=sParam + "&vndr_seq="+ComGetEtcData(sXml, "vndr_seq")
			var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do", sParam);
			if ( ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S" ) {
				var agmtNoLists=ComGetEtcData(sXml, "agmt_no_list");
				var arrAgmtNoList=agmtNoLists.split("^");
				for ( var i=0 ; i < arrAgmtNoList.length ; i++ ) {
					var agmtNoInfos=arrAgmtNoList[i];
					arrAgmtNoInfo[i]=agmtNoInfos.split("|");
				}
			}
			var agmtNos="";
			for ( var i=0 ; i < arrAgmtNoInfo.length ; i++ ) {
				if ( agmtNos == "" ) {
					agmtNos=arrAgmtNoInfo[i][1] + ComLpad(arrAgmtNoInfo[i][2], 6, "0");
				} else {
					agmtNos=agmtNos + "|" + arrAgmtNoInfo[i][1] + ComLpad(arrAgmtNoInfo[i][2], 6, "0");
				}
			}
			sheetObj.SetColProperty("agmt_no", {ComboText:agmtNos, ComboCode:agmtNos} );
			 초기 Focus Setting 
			ComSetFocus(formObj.bil_fm_dt);*/
			sheetObj.SetWaitImageVisible(1);
			break;
			
			case IBSEARCH:      //조회
				if ( validateForm(sheetObj, formObj, sAction) ) {
					switch (sheetObj.id) {
						case "sheet1":
							ComSetObjValue(formObj.f_cmd, SEARCH);
							sheetObj.SetWaitImageVisible(0);
							ComOpenWait(true);
							var sXml=sheetObj.GetSearchData("EES_LSE_0011GS.do", FormQueryString(formObj));
							if ( ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S" ) {
								sheetObj.LoadSearchData(sXml,{Sync:1} );
							}
							ComOpenWait(false);
							break;
					}
				}
				break;
			case IBSAVE: 
				if ( validateForm(sheetObj, formObj, sAction) ) {
					switch (sheetObj.id) {
						case "sheet1":
							for(var i=1;i<=sheetObjects[0].RowCount();i++) {
								if(sheetObjects[0].GetCellValue(i,"agmt_no") == "") {
									ComShowCodeMessage("LSE01006");
									return false;
								}
							}
							
							ComSetObjValue(formObj.f_cmd, MULTI);
							sheetObj.DoSave("EES_LSE_0011GS.do", FormQueryString(formObj));
							break;
						case "sheet2":
							ComSetObjValue(formObj.f_cmd, COMMAND01);
							var sParam=FormQueryString(formObj);
							var sSheetParam=sheetObjects[0].GetSaveString(false, false, "chkbox");
							sSheetParam=ComSetPrifix(sSheetParam, "sheet1_");
							sParam=sParam + "&" + sSheetParam;
							sheetObj.HideSubSum("ibflag");
							var sSheetParam2=sheetObj.GetSaveString(true);
							sSheetParam2=ComSetPrifix(sSheetParam2, "sheet2_");
							sParam=sParam + "&" + sSheetParam2;
							var sXml=sheetObj.GetSaveData("EES_LSE_0011GS.do" , sParam);
							if ( ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S" ) {
								ComSetObjValue(formObj.backendjob_key, ComGetEtcData(sXml,"BackEndJobKey"));
								sheetObjects[0].SetWaitImageVisible(0);
								sheetObj.SetWaitImageVisible(0);
								ComOpenWait(true);
								sheetObj.SetWaitTimeOut(10000);
								timer=setInterval(getBackEndJobStatus, 3000);
							}
							break;
					}
				}
				break;
			case IBINSERT: 
				if ( validateForm(sheetObj, formObj, sAction) ) {
					var rowIdx=sheetObj.DataInsert(-1);
					
					var now=new Date();
				    var stryear=now.getFullYear();
				    var strmonth=now.getMonth() + 1; // cause jan=0,dec=11
				    var strday=now.getDate();
				    if (("" + strmonth).length == 1) { strmonth="0" + strmonth; }
				    if (("" + strday).length   == 1) { strday="0" + strday;   }
				    var strnowDate ="" + stryear+ "-" + strmonth + "-" + strday;
				    var stryear = ""+stryear;
				    var strmonth = ""+strmonth;
				    //var strYearMM = stryear.substring(2,4)+strmonth;
					
					var strFmDt = ComReplaceStr(ComGetObjValue(formObj.bil_fm_dt), "-", "");
					strYearMM = strFmDt.substring(2,6);
					sheetObj.SetCellValue(rowIdx, "agmt_no","",0);
				    sheetObj.SetCellValue(rowIdx, "pay_dt",strnowDate);
				    sheetObj.SetCellValue(rowIdx, "skd_voy_no",strYearMM,"0");
					sheetObj.SetCellValue(rowIdx, "vndr_seq",ComGetObjValue(formObj.vndr_seq));
					sheetObj.SetCellValue(rowIdx, "vndr_lgl_eng_nm",ComGetObjValue(formObj.vndr_nm));
					sheetObj.SetCellEditable(rowIdx, "vndr_seq",0);
					sheetObj.SetCellValue(rowIdx, "op_lse_sts_cd","H",0);
					sheetObj.SetCellValue(rowIdx, "vsl_cd","CNTC",0);
					sheetObj.SetCellValue(rowIdx, "skd_dir_cd","M",0);
					sheetObj.SetCellValue(rowIdx, "rev_dir_cd","M",0);
					sheetObj.SetCellValue(rowIdx, "co_ofc_cd",usrOfcCd,0);
					sheetObj.SetCellValue(rowIdx, "cre_ofc_cd",usrOfcCd,0);
					sheetObj.SetCellValue(rowIdx, "curr_cd","USD",0);
					sheetObj.SetCellValue(rowIdx, "bil_fm_dt",ComReplaceStr(ComGetObjValue(formObj.bil_fm_dt), "-", ""),0);
					sheetObj.SetCellValue(rowIdx, "bil_to_dt",ComReplaceStr(ComGetObjValue(formObj.bil_to_dt), "-", ""),0);
					/* Sheet Combo Item Setting */
					setSheetComboAgmtNo(sheetObj, rowIdx);
					/* Sheet Data Item Setting */
					setSheetDataCtrtNo(sheetObj, rowIdx);
				}
				break;
			case IBDELETE:
				var sheetObj2=sheetObjects[1];
				var chkRows=sheetObj.FindCheckedRow("chkbox");
				var arrChkRow=chkRows.split("|");
				for ( var i=0 ; i < arrChkRow.length ; i++ ) {
					var delRowIdx=sheetObj2.FindText("inv_no", sheetObj.GetCellValue(arrChkRow[i], "inv_no"));
					sheetObj2.RowDelete(delRowIdx, false);
				}
				removePage2();
				ShowSubSumView(sheetObj2);
				ComRowHideDelete(sheetObj, "chkbox");
				break;
			case IBSEARCH_ASYNC01:	//retrieving when input Form Lessor No.
				if ( validateForm(sheetObj, formObj, sAction) ) {
					if ( sheetObj.id == "sheet1" ) {
						var param="f_cmd="+SEARCH06+"&vndr_seq="+ComGetObjValue(formObj.vndr_seq);
						sheetObj.SetWaitImageVisible(0);
						var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do", param);
						if ( ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S" ) {
							if ( ComGetEtcData(sXml, "vndr_lgl_eng_nm") != undefined ) {
								//ComSetObjValue(formObj.vndr_nm, ComGetEtcData(sXml, "vndr_lgl_eng_nm"));
								ComSetObjValue(formObj.gen_pay_term_cd, ComGetEtcData(sXml, "gen_pay_term_cd"));
								ComSetNextFocus(formObj.vndr_seq);
							} else {
	 							ComShowCodeMessage("LSE01019");
	 							ComResetAll();
	 							sheetObjects[0].ClearHeaderCheck();
	 							ComSetObjValue(formObj.usr_ofc_cd, usrOfcCd);
	 							ComSetFocus(formObj.vndr_seq);
	 						}
						} else {
							ComShowCodeMessage("LSE01019");
							ComResetAll();
							sheetObjects[0].ClearHeaderCheck();
							ComSetObjValue(formObj.usr_ofc_cd, usrOfcCd);
							ComSetFocus(formObj.vndr_seq);
						}
					}
				}
				break;
			case IBSEARCH_ASYNC02:	//retrieving when input Form Curr
				if ( validateForm(sheetObj, formObj, sAction) ) {
					var param="f_cmd="+SEARCH07+"&curr_cd="+ComGetObjValue(formObj.curr_cd);
					sheetObj.SetWaitImageVisible(0);
					var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do", param);
					if ( ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S" ) {
						if ( ComGetEtcData(sXml, "curr_cd") != undefined ) {
							ComSetObjValue(formObj.curr_cd, ComGetEtcData(sXml, "curr_cd"));
							ComSetNextFocus(formObj.curr_cd);
						} else {
							//ComShowCodeMessage("LSE01019");
							ComSetObjValue(formObj.curr_cd, "");
							ComSetFocus(formObj.curr_cd);
						}
					} else {
						var errMsg=LseComGetErrMsg(sXml);
						if ( errMsg != "" ) {
							ComShowMessage(errMsg);
						}
						ComSetObjValue(formObj.curr_cd, "");
						ComSetFocus(formObj.curr_cd);
					}
				}
				break;
			case IBSEARCH_ASYNC03:	// retrieving for Office Code
				if(validateForm(sheetObj,formObj,sAction)) {
		        	var param="f_cmd="+SEARCH16+"&ofc_cd="+ComGetObjValue(formObj.cost_ofc_cd);
					sheetObj.SetWaitImageVisible(0);
					var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do",param);
					if ( sXml != "" ) {
						if ( ComGetEtcData(sXml, "ofc_cd") != undefined ) {
							if ( ComGetEtcData(sXml, "ofc_cd") != "" ) {
								formObj.cost_ofc_cd.value=ComGetEtcData(sXml, "ofc_cd") ;
								ComSetNextFocus(formObj.cost_ofc_cd);
							}else{
								ComShowCodeMessage("LSE01035");
								formObj.cost_ofc_cd.value="";
								ComSetFocus(formObj.cost_ofc_cd);
							}
						} else {
							var errMsg=LseComGetErrMsg(sXml);
							if ( errMsg != "" ) {
								ComShowMessage(errMsg);
							}
							formObj.cost_ofc_cd.value="";
							ComSetFocus(formObj.cost_ofc_cd);
						}
					}
				}
	        	break;
	        	
			case IBSEARCH_ASYNC04:      //retrieving for Lessor
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value=SEARCH03;
					sheetObj.SetWaitImageVisible(0);
					var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do",FormQueryString(formObj));
					sheetObj.SetWaitImageVisible(1);
					if ( ComGetEtcData(sXml, "ref_no") != undefined ) {
						formObj.contract_no.value=ComGetEtcData(sXml, "ref_no");
						
						formObj.vndr_seq.value=ComGetEtcData(sXml, "vndr_seq");
						formObj.abbr_nm.value=ComGetEtcData(sXml, "vndr_abbr_nm");
						formObj.vndr_nm.value=ComGetEtcData(sXml, "vndr_lgl_eng_nm");
						
						sheetObjects[0].RemoveAll();
						removePage();
						
						var strVndrSeq = formObj.vndr_seq.value;
			    		sheetObj.SetColProperty("vndr_seq", {ComboText:strVndrSeq, ComboCode:strVndrSeq} );
			    		
			    		
			    		var sParam="f_cmd=" + SEARCH15;
						sParam=sParam + "&vndr_seq="+strVndrSeq
						var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do", sParam);
						if ( ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S" ) {
							var agmtNoLists=ComGetEtcData(sXml, "agmt_no_list");
							var arrAgmtNoList=agmtNoLists.split("^");
							for ( var i=0 ; i < arrAgmtNoList.length ; i++ ) {
								var agmtNoInfos=arrAgmtNoList[i];
								arrAgmtNoInfo[i]=agmtNoInfos.split("|");
							}
						}
						var agmtNos="";
						var agmtNames="";
						for ( var i=0 ; i < arrAgmtNoInfo.length ; i++ ) {
							if ( agmtNos == "" ) {
								agmtNos=arrAgmtNoInfo[i][1] + ComLpad(arrAgmtNoInfo[i][2], 6, "0") ;
								agmtNames = arrAgmtNoInfo[i][1] + ComLpad(arrAgmtNoInfo[i][2], 6, "0") +"\t" + arrAgmtNoInfo[i][4]  +
								"\t" + arrAgmtNoInfo[i][5]  +" ~ " + arrAgmtNoInfo[i][6]  +"\t" + arrAgmtNoInfo[i][3];
							} else {
								agmtNos=agmtNos + "|" + arrAgmtNoInfo[i][1] + ComLpad(arrAgmtNoInfo[i][2], 6, "0");
								agmtNames = agmtNames + "|" + arrAgmtNoInfo[i][1] + ComLpad(arrAgmtNoInfo[i][2], 6, "0") +"\t" + arrAgmtNoInfo[i][4]  +
								"\t" + arrAgmtNoInfo[i][5]  +" ~ " + arrAgmtNoInfo[i][6]  +"\t" + arrAgmtNoInfo[i][3];
							}
						}
						sheetObj.SetColProperty("agmt_no", {ComboText:agmtNames, ComboCode:agmtNos} );
					} else {
						ComShowCodeMessage("LSE01007");
						/*formObj.agmt_seq.value="";
						formObj.contract_no.value="";
						formObj.vndr_seq.value="";
						formObj.abbr_nm.value="";
						formObj.vndr_nm.value="";*/
		    			sheetObjects[0].RemoveAll();
						removePage();
					}
				}
				break;
				
			case IBSEARCH_ASYNC05:	//retrieving for Lessor No
				if ( validateForm(sheetObj, formObj, sAction) ) {
					var param="f_cmd="+SEARCH06+"&vndr_seq="+ComGetObjValue(formObj.vndr_seq);
					sheetObj.SetWaitImageVisible(0);
					var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do", param);
					sheetObj.SetWaitImageVisible(1);
					if ( sXml != "" ) {
						if ( ComGetEtcData(sXml, "vndr_lgl_eng_nm") != undefined ) {
							var vndrSeqChk = "N";
							for(var i=0;i<comboObjects[0].GetItemCount();i++) {
								if(comboObjects[0].GetText(i,0) ==  ComGetObjValue(formObj.vndr_seq)) {
									vndrSeqChk = "Y";
									break;
								}
							}
							
							if(vndrSeqChk == "Y") {
								ComSetObjValue(formObj.vndr_nm, ComGetEtcData(sXml, "vndr_lgl_eng_nm"));
								ComSetObjValue(formObj.abbr_nm, ComGetEtcData(sXml, "vndr_abbr_nm"));
															
								sheetObjects[0].RemoveAll();
								removePage();
								
								var strVndrSeq = formObj.vndr_seq.value;
					    		sheetObj.SetColProperty("vndr_seq", {ComboText:strVndrSeq, ComboCode:strVndrSeq} );
					    		
					    		var sParam="f_cmd=" + SEARCH15;
								sParam=sParam + "&vndr_seq="+strVndrSeq
								var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do", sParam);
								if ( ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S" ) {
									var agmtNoLists=ComGetEtcData(sXml, "agmt_no_list");
									var arrAgmtNoList=agmtNoLists.split("^");
									for ( var i=0 ; i < arrAgmtNoList.length ; i++ ) {
										var agmtNoInfos=arrAgmtNoList[i];
										arrAgmtNoInfo[i]=agmtNoInfos.split("|");
									}
								}
								var agmtNos="";
								var agmtNames="";
								for ( var i=0 ; i < arrAgmtNoInfo.length ; i++ ) {
									if ( agmtNos == "" ) {
										agmtNos=arrAgmtNoInfo[i][1] + ComLpad(arrAgmtNoInfo[i][2], 6, "0");
										agmtNames = arrAgmtNoInfo[i][1] + ComLpad(arrAgmtNoInfo[i][2], 6, "0") +"\t" + arrAgmtNoInfo[i][4]  +
										"\t" + arrAgmtNoInfo[i][5]  +" ~ " + arrAgmtNoInfo[i][6]  +"\t" + arrAgmtNoInfo[i][3];
									} else {
										agmtNos=agmtNos + "|" + arrAgmtNoInfo[i][1] + ComLpad(arrAgmtNoInfo[i][2], 6, "0") ;
										agmtNames = agmtNames + "|" + arrAgmtNoInfo[i][1] + ComLpad(arrAgmtNoInfo[i][2], 6, "0") +"\t" + arrAgmtNoInfo[i][4]  +
										"\t" + arrAgmtNoInfo[i][5]  +" ~ " + arrAgmtNoInfo[i][6]  +"\t" + arrAgmtNoInfo[i][3];
									}
								}
								sheetObj.SetColProperty("agmt_no", {ComboText:agmtNames, ComboCode:agmtNos} );	
								ComSetFocus(formObj.vndr_nm);
							}else{
								ComShowCodeMessage("LSE10023");
								ComResetAll();
								sheetObjects[0].ClearHeaderCheck();
								ComSetObjValue(formObj.usr_ofc_cd, usrOfcCd);
							}	
							
						} else {
							ComShowCodeMessage("LSE01019");
			    			sheetObjects[0].RemoveAll();
							removePage();
							
							ComResetAll();
							sheetObjects[0].ClearHeaderCheck();
							ComSetObjValue(formObj.usr_ofc_cd, usrOfcCd);
							
							ComSetFocus(formObj.vndr_seq);
						}
					} else {
						ComShowCodeMessage("LSE01019");
		    			sheetObjects[0].RemoveAll();
						removePage();
						
						ComResetAll();
						sheetObjects[0].ClearHeaderCheck();
						ComSetObjValue(formObj.usr_ofc_cd, usrOfcCd);
						ComSetFocus(formObj.vndr_seq);
					}
				}
				break;
		}
	}
	function vndr_seq_OnChange(comboObj, Index, Text) {
		var formObj=document.form;
		if ( preVndrSeq != "" && sheetObjects[0].RowCount()> 0 ) {
			if (ComShowCodeConfirm("LSE01127", "")) {
				preVndrSeq=ComGetObjValue(comboObj);
				sheetObjects[0].RemoveAll();
				removePage();
				/* retrieving for Vendor Pay Term Code */
				doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC01);
			} else {
				comboObj.SetSelectCode(preVndrSeq,false);
			}
		} else {
			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC01);
			preVndrSeq=ComGetObjValue(comboObj);
		}
	}
	
	
	function sheet1_OnLoadFinish(sheetObj) {
		var formObj=document.form;
		/* IBMulti Combo Item Setting */
		doActionIBSheet(sheetObj, formObj, IBCREATE);
		/* retrieving for Vendor Pay Term Code */
		//doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
	}
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		var formObj=document.form;
		if ( ErrMsg == "" ) {
			for ( var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++ ) {
				if ( sheetObj.GetCellValue(i, "op_lse_sts_cd") ==  "I" ) {
					sheetObj.SetRowEditable(i,0);
				} else if ( sheetObj.GetCellValue(i, "op_lse_sts_cd") ==  "S" ) {
					setSheetComboAgmtNo(sheetObj, i);
				}
			}
			removePage();
		}
		
		//Diseditable Invoice No.
		for( var i=1 ; i <= sheetObj.LastRow(); i++ ){
			sheetObj.SetCellEditable(i, "inv_no",0);
		}
	}
	
	
	function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
		var formObj=document.form;
		if ( ErrMsg == "" ) {
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
		}
		removePage();
	}
	
	/**
 	 * handling event in case of Pop-up Click sheet1<br>
 	 * @param sheetObj
 	 * @param Row
 	 * @param Col
 	 */ 
    function sheet1_OnPopupClick(sheetObj,Row,Col) {
 		with(sheetObj) {
			var sName=ColSaveName(Col);
			switch(sName) {
				case "curr_cd":	//Currency Pop-up
					ComOpenPopup('/opuscntr/COM_ENS_N13.do', 700, 450, 'setPopData_Currency', '1,0,1',  true, false, Row, Col, 0);
					break;
			}
 		}
    }
    
    
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		var formObj=document.form;
		var colName=sheetObj.ColSaveName(Col);
		var sheetObj2=sheetObjects[1];
		switch (colName) {
			case "chkbox":
				if ( Value == "1" ) {
					for(var i=0;i<sheetObj.RowCount();i++) {
						if(sheetObj.GetCellValue(i, "chkbox") == "1" && (sheetObj.GetCellValue(Row, "curr_cd") != sheetObj.GetCellValue(i, "curr_cd")) ){
							ComShowCodeMessage("LSE10024");
							sheetObj.SetCellValue(Row, "chkbox" , "0",0);
							return false;
						}
					}
					
					var newRowIdx=sheetObj2.DataInsert(-1);
					sheetObj2.SetCellValue(newRowIdx, "inv_no",sheetObj.GetCellValue(Row, "inv_no"),0);
					sheetObj2.SetCellValue(newRowIdx, "vvd",sheetObj.GetCellValue(Row, "vsl_cd")+sheetObj.GetCellValue(Row, "skd_voy_no")+sheetObj.GetCellValue(Row, "skd_dir_cd")+sheetObj.GetCellValue(Row, "rev_dir_cd"),0);
					sheetObj2.SetCellValue(newRowIdx, "acct_cd",sheetObj.GetCellValue(Row, "acct_cd"),0);
					sheetObj2.SetCellValue(newRowIdx, "cost_nm",sheetObj.GetCellValue(Row, "cost_nm"),0);
					sheetObj2.SetCellValue(newRowIdx, "agmt_no",sheetObj.GetCellValue(Row, "agmt_no"),0);
					sheetObj2.SetCellValue(newRowIdx, "lst_ctrt_no",sheetObj.GetCellValue(Row, "lse_ctrt_no"));
					sheetObj2.SetCellValue(newRowIdx, "lse_pay_chg_tp_cd",'OPL',0);
					sheetObj2.SetCellValue(newRowIdx, "cntr_tpsz_cd",sheetObj.GetCellValue(Row, "cntr_tpsz_cd"),0);
					sheetObj2.SetCellValue(newRowIdx, "ttl_cost_amt",sheetObj.GetCellValue(Row, "pay_amt"),0);
					sheetObj2.SetCellValue(newRowIdx, "cr_amt",0,0);
					sheetObj2.SetCellValue(newRowIdx, "agmt_cty_cd",sheetObj.GetCellValue(Row, "agmt_cty_cd"),0);
					sheetObj2.SetCellValue(newRowIdx, "agmt_seq",sheetObj.GetCellValue(Row, "agmt_seq"),0);
					sheetObj2.SetCellValue(newRowIdx, "op_seq",sheetObj.GetCellValue(Row, "op_seq"),0);
					sheetObj2.SetCellValue(newRowIdx, "cost_cd",sheetObj.GetCellValue(Row, "cost_cd"),0);
					sheetObj2.SetCellValue(newRowIdx, "op_lse_qty",sheetObj.GetCellValue(Row, "op_lse_qty"),0);
					sheetObj2.SetCellValue(newRowIdx, "inv_vat_amt",sheetObj.GetCellValue(Row, "inv_vat_amt"),0);
					sheetObj2.SetCellValue(newRowIdx, "whld_tax_amt",sheetObj.GetCellValue(Row, "whld_tax_amt"),0);
					sheetObj2.SetCellValue(newRowIdx, "inv_vat_amt","0",0);	
					sheetObj2.SetCellValue(newRowIdx, "whld_tax_amt","0",0);	
					
					sheetObj.SetCellEditable(Row, "bil_fm_dt", 0);
					sheetObj.SetCellEditable(Row, "bil_to_dt", 0);					
					sheetObj.SetCellEditable(Row, "skd_voy_no", 0);
					sheetObj.SetCellEditable(Row, "pay_dt", 0);
					sheetObj.SetCellEditable(Row, "cntr_tpsz_cd", 0);
					sheetObj.SetCellEditable(Row, "op_lse_qty", 0);
					if(sheetObj.GetCellValue(Row, "op_lse_sts_cd") == "H") {
						sheetObj.SetCellEditable(Row, "agmt_no", 0);
						sheetObj.SetCellEditable(Row, "inv_no", 0);
					}
					sheetObj.SetCellEditable(Row, "curr_cd", 0);
					sheetObj.SetCellEditable(Row, "prin_amt", 0);
					sheetObj.SetCellEditable(Row, "bal_amt", 0);
					sheetObj.SetCellEditable(Row, "int_amt", 0);
					sheetObj.SetCellEditable(Row, "libor_amt", 0);
					sheetObj.SetCellEditable(Row, "pay_amt", 0);					
					sheetObj.SetCellEditable(Row, "diff_rmk", 0);
					
					ShowCurrency(sheetObjects[0],Row);
					
					formObj.curr_cd.className="input2";
					ComBtnDisable("btns_search2");
				} else {
					var delRowIdx=sheetObj2.FindText("inv_no", sheetObj.GetCellValue(Row, "inv_no"));
					sheetObj2.RowDelete(delRowIdx, false);
					
					sheetObj.SetCellEditable(Row, "bil_fm_dt", 1);
					sheetObj.SetCellEditable(Row, "bil_to_dt", 1);					
					sheetObj.SetCellEditable(Row, "skd_voy_no", 1);
					sheetObj.SetCellEditable(Row, "pay_dt", 1);
					sheetObj.SetCellEditable(Row, "cntr_tpsz_cd", 1);
					sheetObj.SetCellEditable(Row, "op_lse_qty", 1);
					if(sheetObj.GetCellValue(Row, "op_lse_sts_cd") == "H") {
						sheetObj.SetCellEditable(Row, "agmt_no", 1);
						sheetObj.SetCellEditable(Row, "inv_no", 1);
					}
					sheetObj.SetCellEditable(Row, "curr_cd", 1);
					sheetObj.SetCellEditable(Row, "prin_amt", 1);
					sheetObj.SetCellEditable(Row, "bal_amt", 1);
					sheetObj.SetCellEditable(Row, "int_amt", 1);
					sheetObj.SetCellEditable(Row, "libor_amt", 1);
					sheetObj.SetCellEditable(Row, "pay_amt", 1);					
					sheetObj.SetCellEditable(Row, "diff_rmk", 1);
					formObj.curr_cd.className="input1";
					ComBtnEnable("btns_search2");
					
					sheetObjects[0].SetCellFontColor(Row, "inv_vat_amt","#000000") ;
					sheetObjects[0].SetCellFontColor(Row, "inv_vat_amt","#000000") ;
					sheetObjects[0].SetCellValue(Row,"inv_vat_amt","0");
					sheetObjects[0].SetCellValue(Row,"whld_tax_amt","0");
				}
				ShowSubSumView(sheetObj2);
				
				break;
			case "vndr_seq":
				setSheetComboAgmtNo(sheetObj, Row);
				setSheetDataCtrtNo(sheetObj, Row);
				break;
			case "agmt_no":
				setSheetDataCtrtNo(sheetObj, Row);
				break;
			case "skd_voy_no":
				// setting Rev Voyage limit - over 4, setting "0000" 
				if(!(ComChkLen(Value, 4) == 2) || !ComIsMonth(Value.substr(2,2)) ) {
					sheetObj.SetCellValue(Row, Col,"",0);
					return;
				}
				checkVoyageCntrTp(sheetObj, Row, Col, Value);
				break;
			case "cntr_tpsz_cd":
				checkVoyageCntrTp(sheetObj, Row, Col, Value);
				break;
			case "bil_to_dt":
				checkVoyageCntrTp(sheetObj, Row, Col, Value);
				break;
			case "curr_cd":
				if ( validateForm(sheetObj, formObj, IBSEARCH_ASYNC02) ) {
					var param="f_cmd="+SEARCH07+"&curr_cd="+Value;
					sheetObj.SetWaitImageVisible(0);
					var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do", param);
					if ( ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S" ) {
					} else {
						var errMsg=LseComGetErrMsg(sXml);
						if ( errMsg != "" ) {
							ComShowMessage(errMsg);
						}
						sheetObj.SetCellValue(Row, Col, "");
					}
				}
				break;
			default :
				if ( sheetObj.GetCellValue(Row, "ibflag") == "U" && sheetObj.GetCellValue(Row, "chkbox") == "1" ) {
				var rowIdx=sheetObj2.FindText("inv_no", sheetObj.GetCellValue(Row, "inv_no"));
				sheetObj2.SetCellValue(rowIdx, "vvd",sheetObj.GetCellValue(Row, "vsl_cd")+sheetObj.GetCellValue(Row, "skd_voy_no")+sheetObj.GetCellValue(Row, "skd_dir_cd")+sheetObj.GetCellValue(Row, "rev_dir_cd"),0);
				sheetObj2.SetCellValue(rowIdx, "cntr_tpsz_cd",sheetObj.GetCellValue(Row, "cntr_tpsz_cd"),0);
				sheetObj2.SetCellValue(rowIdx, "ttl_cost_amt",sheetObj.GetCellValue(Row, "pay_amt"),0);
				sheetObj2.SetCellValue(rowIdx, "op_lse_qty",sheetObj.GetCellValue(Row, "op_lse_qty"),0);
				ShowSubSumView(sheetObj2);
				}
			

			case "inv_no":
				// INVOICE DUP CHECK
				if(Value != null || Value != undefined || Value != ""){
					/*
					var sParam="f_cmd="+SEARCH09;
					sParam=sParam + "&inv_no="+Value;
					sParam=sParam + "&mdl_cd="+"LSE";
					sParam=sParam + "&vndr_seq="+sheetObj.GetCellValue(Row, "vndr_seq");
					sParam=sParam + "&ref_pk="+"";
					var sXml=sheetObj.GetSearchData("FINCommonGS.do" , sParam);
					if ( ComGetEtcData(sXml,"TRANS_RESULT_KEY") != "S" ) {
						sheetObj.LoadSearchData(sXml,{Sync:1} );
						sheetObj.SetCellValue(Row, "inv_no","",0);
						return false;
					} */
					var CheckText = "N";
					for(var i=1; i<sheetObj.RowCount();i++) {
						if(sheetObj.GetCellValue(i,"inv_no") != "" && i != Row) {
							if(sheetObj.GetCellValue(i,"inv_no") == Value) {
								CheckText = "Y";
								break;
							}
						}
					}
					
					if (CheckText == "Y") {
			        	ComShowCodeMessage('LSE10020');
						sheetObj.SetCellValue(Row, Col,'',0);
						sheetObj.SelectCell(Row, Col, true);
						return false;
		 			}
					
					var sParam="f_cmd="+SEARCH22;
					sParam=sParam + "&inv_no="+Value;
					sParam=sParam + "&mdl_cd="+"LSE";
					sParam=sParam + "&vndr_seq="+formObj.vndr_seq.value;
					sParam=sParam + "&ref_pk="+"";
					var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do" , sParam);
					if ( ComGetEtcData(sXml,"TRANS_RESULT_KEY") != "S" ) {
						//sheetObj.LoadSearchData(sXml,{Sync:1} );
						showErrMessage(ComGetSelectSingleNode(sXml, "MESSAGE"));
						sheetObj.SetCellValue(Row, "inv_no","",0);
						return false;
					} 
				}
				break;
		}
	}
	
	
	/**
	 * handling process for input validation
	 */
	function checkVoyageCntrTp (sheetObj, Row, Col, Value){
		var	i;
		var rowCnt=sheetObj.RowCount();
		var totalCnt=rowCnt;
		var srcData=sheetObj.GetCellValue(Row, "bil_to_dt") + sheetObj.GetCellValue(Row, "skd_voy_no") + sheetObj.GetCellValue(Row, "cntr_tpsz_cd");
		var targetData;
		if (ComIsNull(Value)) return;
		for (i=1; i<=totalCnt ; i++){
			if (i!=Row){
				targetData=sheetObj.GetCellValue(i, "bil_to_dt") + sheetObj.GetCellValue(i, "skd_voy_no") + sheetObj.GetCellValue(i, "cntr_tpsz_cd");
				if (srcData == targetData) {
					ComShowCodeMessage("LSE01005", "Payment Period,REV VVD,TP/SZ");
					sheetObj.SetCellValue(Row, Col,"",0);
					return;
				}
			}
		}		
		return;
	}
	
	
	function setSheetComboAgmtNo(sheetObj, Row) {
		var Value=sheetObj.GetCellValue(Row, "vndr_seq");
		var newAdd=sheetObj.GetCellValue(Row, "op_lse_sts_cd");
		var agmtNos="";
		var agmtNames="";
		var strAgmtNo = "";
		for ( var i=0 ; i < arrAgmtNoInfo.length ; i++ ) {
			if ( Value == arrAgmtNoInfo[i][0] ) {
				if ( agmtNos == "" ) {
					agmtNos=arrAgmtNoInfo[i][1] + ComLpad(arrAgmtNoInfo[i][2], 6, "0") ;
					agmtNames=arrAgmtNoInfo[i][1] + ComLpad(arrAgmtNoInfo[i][2], 6, "0") +"\t" + arrAgmtNoInfo[i][4]  +
					"\t" + arrAgmtNoInfo[i][5]  +" ~ " + arrAgmtNoInfo[i][6]  +"\t" + arrAgmtNoInfo[i][3];
					strAgmtNo = agmtNos;
				} else {
					agmtNos=agmtNos + "|" + arrAgmtNoInfo[i][1] + ComLpad(arrAgmtNoInfo[i][2], 6, "0") ;
					agmtNames=agmtNames + "|" +arrAgmtNoInfo[i][1] + ComLpad(arrAgmtNoInfo[i][2], 6, "0") +"\t" + arrAgmtNoInfo[i][4]  +
					"\t" + arrAgmtNoInfo[i][5]  +" ~ " + arrAgmtNoInfo[i][6]  +"\t" + arrAgmtNoInfo[i][3];
				}
			}
		}
		
		sheetObj.CellComboItem(Row,"agmt_no", {ComboText:agmtNames, ComboCode:agmtNos} );
		if(arrAgmtNoInfo.length > 0) {
			if(newAdd == "H") {
				sheetObj.SetCellValue(Row,"agmt_no", strAgmtNo);
			}
		}
	}
	
	
	function setSheetDataCtrtNo(sheetObj, Row) {
		var agmtNo=sheetObj.GetCellValue(Row, "agmt_no");
		sheetObj.SetCellValue(Row, "agmt_cty_cd",agmtNo.substr(0, 3),0);
		sheetObj.SetCellValue(Row, "agmt_seq",ComLtrim(agmtNo.substr(3), "0"),0);
		var agmtSeq=ComLtrim(agmtNo.substr(3), "0");
		for ( var i=0 ; i < arrAgmtNoInfo.length ; i++ ) {
			if ( agmtSeq == arrAgmtNoInfo[i][2] ) {
				sheetObj.SetCellValue(Row, "lse_ctrt_no",arrAgmtNoInfo[i][3],0);
			}
		}
	}
	
	
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj,formObj,sAction){
		switch (sAction) {
			case IBSEARCH:
			case IBSAVE:
			case IBINSERT:
				if(formObj.vndr_seq.value == "") {
					ComShowCodeMessage("LSE01044");
					ComSetFocus(formObj.vndr_seq);
					return false;
				}
				
				if(formObj.bil_fm_dt.value == "") {
					ComShowCodeMessage("LSE01043");
					ComSetFocus(formObj.bil_fm_dt);
					return false;
				}
				
				if(formObj.bil_to_dt.value == "") {
					ComShowCodeMessage("LSE01043");
					ComSetFocus(formObj.bil_to_dt);
					return false;
				}
				//return ComChkValid(formObj);
				break;
		}
		return true;
	}
	/**
	 * handling process for input Effective Date Validation <br>
	 */
    function checkEffDate(obj1, obj2) {
    	var formObj=document.form;
		/* Date Validation(eff_dt < exp_dt) */
		var vEffDt=ComReplaceStr(ComGetObjValue(obj1),"-","");
		if ( vEffDt == "" ) return false;
		var vExpDt=ComReplaceStr(ComGetObjValue(obj2),"-","");
		if ( vExpDt == "" ) return false;
		if ( ComChkPeriod(vEffDt, vExpDt) != 1 ) {
			ComShowCodeMessage("LSE01115");
			ComSetObjValue(obj2,"");
			ComSetFocus(obj2);
			return false;
		}
		return true;
    }
	function removePage() {
		sheetObjects[1].RemoveAll();
		removePage2();
	}
	function removePage2() {
		var formObj=document.form;
		ComSetObjValue(formObj.lse_op_qty,   "");
		ComSetObjValue(formObj.pay_amt,      "");
		ComSetObjValue(formObj.vndr_term_nm, "");
		ComSetObjValue(formObj.inv_rcv_dt,   "");
		ComSetObjValue(formObj.inv_iss_dt,   "");
		//ComSetObjValue(formObj.inv_eff_dt,   "");
		ComSetObjValue(formObj.inv_ofc_cd,   "");
		ComSetObjValue(formObj.cost_ofc_cd,  "");
		ComSetObjValue(formObj.curr_cd,      "");
		ComSetObjValue(formObj.inv_amt,      "");
		ComSetObjValue(formObj.cr_amt,       "");
		ComSetObjValue(formObj.inv_rmk,      "");
		ComSetObjValue(formObj.inv_vat_amt, "");
		ComSetObjValue(formObj.whld_tax_amt, "");
		ComSetObjValue(formObj.inv_ttl_amt, "");
	}
	/**
	 * retrieving status 3 for BackEndJob result
	 */
	function getBackEndJobStatus() {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		var sheetObj2=sheetObjects[1];
		ComSetObjValue(form.f_cmd, COMMAND02);
		var sXml=sheetObj.GetSearchData("EES_LSE_0011GS.do", FormQueryString(form));
		if ( ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S" ) {
			var jobState=ComGetEtcData(sXml, "jb_sts_flg")
			if (jobState == "3") {
				sheetObj.SetWaitImageVisible(1);
				sheetObj2.SetWaitImageVisible(1);
				ComOpenWait(false);
				clearInterval(timer);
				ComShowCodeMessage("LSE01121");
			} else if (jobState == "4") {
				sheetObj.SetWaitImageVisible(1);
				sheetObj2.SetWaitImageVisible(1);
				ComOpenWait(false);
				clearInterval(timer);
				ComShowCodeMessage("LSE01124");
			} else if (jobState == "5") {
				sheetObj.SetWaitImageVisible(1);
				sheetObj2.SetWaitImageVisible(1);
				ComOpenWait(false);
				clearInterval(timer);
				ComShowCodeMessage("LSE01125");
			}
			removePage();
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
		} else {
			ComOpenWait(false);
			sheetObj.SetWaitImageVisible(1);
			sheetObj2.SetWaitImageVisible(1);
			clearInterval(timer);
			sheetObj2.LoadSearchData(sXml,{Sync:1} );
		}
	}
	
	
	function ShowSubSumView(sheetObj) {
		var formObj = document.form;
		with(sheetObj) {
			HideSubSum("ibflag");
			if ( sheetObj.RowCount() > 0 ) {
				var amt   = sheetObj.ComputeSum("|10|");
				var crAmt = sheetObj.ComputeSum("|11|");
				var qty   = sheetObj.ComputeSum("|16|");

				ComSetObjValue(formObj.lse_op_qty, qty);
				ComSetObjValue(formObj.pay_amt, amt);

				ComSetObjValue(formObj.inv_amt, amt);
				ComSetObjValue(formObj.cr_amt,  crAmt);

				ComAddSeparator(form.lse_op_qty, "int");
				ComAddSeparator(form.pay_amt, "float");
				ComAddSeparator(form.inv_amt, "float");
				ComAddSeparator(form.cr_amt, "float");

				ComSetObjValue(formObj.vndr_term_nm,  ComGetObjValue(formObj.gen_pay_term_cd));
				ComSetObjValue(formObj.inv_ofc_cd,  usrOfcCd);
				ComSetObjValue(formObj.cost_ofc_cd, usrOfcCd);
				if(sheetObj.ComputeSum("|17|") == "0") {
					ComSetObjValue(formObj.inv_vat_amt, "0.00")
					
					var allAmount = 0;
					var intAmount = 0;
					for(var i=0;i<sheetObjects[0].RowCount();i++) {
						if(sheetObjects[0].GetCellValue(i+1,"chkbox",0) == "0") {
							sheetObjects[0].SetCellValue(i+1,"inv_vat_amt","0");
							sheetObjects[0].SetCellFontColor(i+1, "inv_vat_amt","#000000") ;
						}else{
							/*intAmount = sheetObjects[1].GetCellValue(i+1,"inv_vat_amt",0);
							allAmount = parseFloat(allAmount) + parseFloat(intAmount);*/
						}
					}
					
					for(var i=0;i<sheetObjects[0].RowCount();i++) {
						if(sheetObjects[0].GetCellValue(i+1,"chkbox",0) == "1") {
							intAmount = sheetObjects[0].GetCellValue(i+1,"inv_vat_amt",0);
							allAmount = parseFloat(allAmount) + parseFloat(intAmount);
						}
					}
					formObj.inv_vat_amt.value = allAmount.toFixed(2);
					
				}else{
					ComSetObjValue(formObj.inv_vat_amt, sheetObj.ComputeSum("|17|"))
				}
				
				if(sheetObj.ComputeSum("|18|") == "0") {
					ComSetObjValue(formObj.whld_tax_amt, "0.00")
					
					
					var allAmount = 0;
					var intAmount = 0;
					for(var i=0;i<sheetObjects[0].RowCount();i++) {
						if(sheetObjects[0].GetCellValue(i+1,"chkbox",0) == "0") {
							sheetObjects[0].SetCellValue(i+1,"whld_tax_amt","0");
							sheetObjects[0].SetCellFontColor(i+1, "whld_tax_amt","#000000") ;
						}else{
							/*intAmount = sheetObjects[1].GetCellValue(i+1,"whld_tax_amt",0);
							allAmount = parseFloat(allAmount) + parseFloat(intAmount);*/
						}
					}
					
					for(var i=0;i<sheetObjects[0].RowCount();i++) {
						if(sheetObjects[0].GetCellValue(i+1,"chkbox",0) == "1") {
							intAmount = sheetObjects[0].GetCellValue(i+1,"whld_tax_amt",0);
							allAmount = parseFloat(allAmount) + parseFloat(intAmount);
						}
					}
					
					formObj.whld_tax_amt.value = allAmount.toFixed(2);
				}else{
					ComSetObjValue(formObj.whld_tax_amt, sheetObj.ComputeSum("|18|"))
				}
				
				if(sheetObj.ComputeSum("|19|") == "0") {
					ComSetObjValue(formObj.inv_ttl_amt, "0.00")
				}else{
					ComSetObjValue(formObj.inv_ttl_amt, sheetObj.ComputeSum("|19|"))
				}
				
				//ComSetObjValue(formObj.curr_cd,       "USD");
				
				formObj.inv_ttl_amt.value = 	parseFloat(ComReplaceStr(isGetNull(formObj.inv_amt.value),",","")) + 
				parseFloat(ComReplaceStr(isGetNull(formObj.inv_vat_amt.value),",","")) - 
				parseFloat(ComReplaceStr(isGetNull(formObj.whld_tax_amt.value),",",""));

				formObj.inv_ttl_amt.value = ComAddComma((Math.round(formObj.inv_ttl_amt.value * 100)/100).toFixed(2));
			}else{
				removePage2();
			}
			ShowSubSum("ibflag", "10|11", -1, false, false, 0, "inv_no=;vvd=;acct_cd=;cost_nm=Total;agmt_no=;lse_ctrt_no=;lse_pay_chg_tp_cd=;cntr_tpsz_cd=");
		}
	}
	
	
	function ShowCurrency(sheetObj, Row) {
		var formObj = document.form;
		ComSetObjValue(formObj.curr_cd,       sheetObj.GetCellValue(Row,"curr_cd"));
	}
	
	function isGetNull(obj) {
		var rtn = "";
		if(obj == null || obj == "") {
			rtn = "0.00";
		}else{
			rtn = obj;
		}
		return rtn;
	}
	
	
	 /**
	 * Pop-up Open
	 *
	 * @param type
	 * @param Row
	 * @param Col
	 * @param SheetIdx
	 * @return
	 */
	function openPopupPage(type, Row, Col, SheetIdx) {
		var formObj=document.form;
		var sheetObj=sheetObjects[1];
		if ( type == "10" ) {
			var formObj=document.form;
    		var sUrl='/opuscntr/COM_ENS_071.do';
			var iWidth=855;
			var iHeight=435;
			var sTargetObjList="ofc_cd:cost_ofc_cd";
			var sDisplay="1,0,1,1,1,1,1,1";
			ComOpenPopupWithTarget(sUrl, iWidth, iHeight, sTargetObjList, sDisplay, true);
		}else if ( type == "11") {
			if ( sheetObj.RowCount()< 1) {
				ComShowCodeMessage("LSE01048");
				return;
			}
			ComOpenPopup('/opuscntr/EES_LSE_1003.do?sType=vaTaxOperation', 700, 600, '', '1,0', true);
		} else if ( type == "12" ) {
			if ( sheetObj.RowCount()< 1) {
				ComShowCodeMessage("LSE01048");
				return;
			}
			ComOpenPopup('/opuscntr/EES_LSE_1003.do?sType=whTaxOperation', 700, 600, '', '1,0', true);
		}
	}
	/* end of developer job */
	
	
	/**
     * handing process Pop-up<br>
     * @param type 1:Return Location. Popup for FORM, 2:Currency Code Popup for FORM
     * @param Row index
     * @param Col index
     */
    function openPopup(type, Row, Col) {
    	var formObj=document.form;
    	if ( type == "2" ) {
			ComOpenPopup('/opuscntr/COM_ENS_N13.do', 700, 450, 'setPopData_Currency', '1,0,1', true);
    	}else if(type == "3") {
    		ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 705, 540, 'setPopData_Lessor', '1,0,1,1,1,1,1,1', true);
    	}
    	return;
    }
    
    /**
    * handling process for Lessor(Service Provider) Pop-up Return Value<br>
    * @param Return value array
    * @param Row index
    * @param Col index
    * @param Sheet Array index
    */
    function setPopData_Lessor(aryPopupData, Row, Col, SheetIdx) {
    	var sheetObj=sheetObjects[SheetIdx];
    	var formObj=document.form;
    	if ( aryPopupData.length > 0 ) {
    		var vndrSeqChk = "N";
			for(var i=0;i<comboObjects[0].GetItemCount();i++) {
				if(comboObjects[0].GetText(i,0) ==  ComLtrim(aryPopupData[0][2],"0")) {
					vndrSeqChk = "Y";
					break;
				}
			}
			
			if(vndrSeqChk == "Y") {
	    		formObj.vndr_seq.value=ComLtrim(aryPopupData[0][2],"0");
	    		formObj.vndr_nm.value=aryPopupData[0][4];
	    		formObj.abbr_nm.value=aryPopupData[0][5];
	    		
	    		sheetObjects[0].RemoveAll();
				removePage();
				
	    		var strVndrSeq = formObj.vndr_seq.value;
	    		sheetObjects[0].SetColProperty("vndr_seq", {ComboText:strVndrSeq, ComboCode:strVndrSeq} );
	    		
	    		var sParam="f_cmd=" + SEARCH15;
				sParam=sParam + "&vndr_seq="+strVndrSeq
				var sXml=sheetObjects[0].GetSearchData("EES_LSE_COMGS.do", sParam);
				if ( ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S" ) {
					var agmtNoLists=ComGetEtcData(sXml, "agmt_no_list");
					var arrAgmtNoList=agmtNoLists.split("^");
					for ( var i=0 ; i < arrAgmtNoList.length ; i++ ) {
						var agmtNoInfos=arrAgmtNoList[i];
						arrAgmtNoInfo[i]=agmtNoInfos.split("|");
					}
				}
				var agmtNos="";
				var agmtNames="";
				for ( var i=0 ; i < arrAgmtNoInfo.length ; i++ ) {
					if ( agmtNos == "" ) {
						agmtNos=arrAgmtNoInfo[i][1] + ComLpad(arrAgmtNoInfo[i][2], 6, "0");
						agmtNames = arrAgmtNoInfo[i][1] + ComLpad(arrAgmtNoInfo[i][2], 6, "0") +"\t" + arrAgmtNoInfo[i][4]  +
						"\t" + arrAgmtNoInfo[i][5]  +" ~ " + arrAgmtNoInfo[i][6]  +"\t" + arrAgmtNoInfo[i][3];
					} else {
						agmtNos=agmtNos + "|" + arrAgmtNoInfo[i][1] + ComLpad(arrAgmtNoInfo[i][2], 6, "0");
						agmtNames = agmtNames + "|" + arrAgmtNoInfo[i][1] + ComLpad(arrAgmtNoInfo[i][2], 6, "0") +"\t" + arrAgmtNoInfo[i][4]  +
						"\t" + arrAgmtNoInfo[i][5]  +" ~ " + arrAgmtNoInfo[i][6]  +"\t" + arrAgmtNoInfo[i][3];
					}
				}
				sheetObjects[0].SetColProperty("agmt_no", {ComboText:agmtNames, ComboCode:agmtNos} );
			}else{
				ComShowCodeMessage("LSE10023");
				ComResetAll();
				sheetObjects[0].ClearHeaderCheck();
				ComSetObjValue(formObj.usr_ofc_cd, usrOfcCd);
			}
    	}
    }
    
    
    /**
	 * handing process for Currency Pop-up Return Value<br>
	 * @param Return value array
	 * @param Row index
	 * @param Col index
	 * @param Sheet Array index
	 */
	function setPopData_Currency(aryPopupData, Row, Col, SheetIdx) {
		var formObj=document.form;
		if ( aryPopupData.length > 0 ) {
			if(SheetIdx == 0){				
				with(sheetObjects[SheetIdx]) {
					var sName=ColSaveName(Col);
					switch(sName) {
						case "curr_cd":
							SetCellValue(Row, sName,aryPopupData[0][2],0);//Currency Cd
							break;
						default :	//do nothing
					}
				}
			}else{
				ComSetObjValue(curr_cd, aryPopupData[0][2]);
			}
		}
	}
