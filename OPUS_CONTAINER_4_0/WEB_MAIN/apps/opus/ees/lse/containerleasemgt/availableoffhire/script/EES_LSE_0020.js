/*=========================================================

*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_LSE_0020.js
*@FileTitle  : Available Off Hire Q'ty List 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/17

=========================================================*/
/****************************************************************************************
    Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	/* developer job */
	// common global variables
	// Combo Object Array
	var comboObjects=new Array();
	var comboCnt=0;
	var vOrcLstmCd="LT|ST|OF|SI|MI";
   	var vOrcCntrTpszCd="";
   	var vCnmvStsCd="MT|VL|TS|VD|IC|ID|EN|TN";
	var sheetObjects=new Array();
	var sheetCnt=0;
	//Event handler processing by button click event */
	document.onclick=processButtonClick;
	//Event handler processing by button name */
    function processButtonClick(){
        /**********/
		var sheetObject=sheetObjects[0];
        /*******************************************************/
        var formObj=document.form;
    	try {
    		var srcObj=ComGetEvent();
    		var srcName=ComGetEvent("name");
            switch(srcName) {
            	case "radio_dol_tp":
  					if(formObj.radio_dol_tp[0].checked){
						ComSetObjValue(formObj.dol_tp, "A");
   					}else if(formObj.radio_dol_tp[1].checked){
						ComSetObjValue(formObj.dol_tp, "E");
   					}else if(formObj.radio_dol_tp[2].checked){
						ComSetObjValue(formObj.dol_tp, "N");
   					}
  					break;				
   				case "radio_sent_tp":
  					if(formObj.radio_sent_tp[0].checked){
						ComSetObjValue(formObj.sent_tp, "A");
   					}else if(formObj.radio_sent_tp[1].checked){
						ComSetObjValue(formObj.sent_tp, "E");
   					}else if(formObj.radio_sent_tp[2].checked){
						ComSetObjValue(formObj.sent_tp, "N");
   					}
  					break;
				case "btn_retrieve":
					if(ComChkValid(formObj) == true) {
						//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
						doActionIBSheet(sheetObjects[0],document.form,IBBATCH);
					}
					break;
				case "btn_new":
					ComResetAll();
					ComHiddenResetAll();
					setEnableSwitch("1");
					for ( var k=0 ; k < comboObjects.length ; k++ ) {
				        setDefaultComboCheck(comboObjects[k]);
				    }
					formObj.rstr_usg_lbl.value="";
					formObj.hid_rulabel_type.value="";
					ComSetFocus(formObj.loc_cd);
					sheetObjects[0].ClearHeaderCheck();
					break;
				case "btn_DownExcel":
					if(sheetObjects[0].RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
					}else{
						//sheetObjects[0].Down2Excel({ HiddenColumn:-1,Merge:true});
						sheetObjects[0].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[0]), SheetDesign:1,Merge:1 }); 
					}
					break;
				case "btn_DetailInquiry":
					openPopup("8");
					break;
				case "btns_search1":	//retrieving for Form Location.
					if(formObj.loc_case.value != "2") {
						openPopup("1");
					}
 					break;
				case "btns_search2": 	// Form Delivery SCC Search
					if(formObj.loc_case.value != "1") {
 						openPopup("2");
					}
 					break;
				case "btns_search3": 	// VVD Code Search
					if(formObj.loc_case.value != "1") {
						openPopup("3");
					}
					break;
				case "btns_search4": 	// Form Agreement Search
					openPopup("4");
					break;
				case "btns_search5": 	// Form Lessor Search
					openPopup("5");
					break;
				case "btns_search6":	//retrieving for Form Port.
					if(formObj.loc_case.value != "1") {
						openPopup("6");
					}
 					break;
 				case "btns_search7":	//retrieving for Form Lane 
 					if(formObj.loc_case.value != "1") {
						openPopup("7");
 					}
 					break;
 				case "btn_rulabel_cd":	//RU Label 조회 팝업
					var par_rulabel_type = form.hid_rulabel_type.value;
					var par_rstr_usg_lbl = ComToHtml2(form.rstr_usg_lbl.value);
					var param="?par_rulabel_type="+par_rulabel_type+"&par_rstr_usg_lbl="+par_rstr_usg_lbl;
					var loc_code="";
					ComOpenPopup("/opuscntr/EES_MST_0054.do"+param, 460, 560, "", "1,0,1,1,1,1", true);		   
					break;
				case "btns_calendar":	// Estimate Duration (FromTo)
					if ( srcObj.style.filter == "" ) {
						var cal=new ComCalendarFromTo();
						cal.select(formObj.str_estm_dt, formObj.end_estm_dt, 'yyyy-MM-dd');
					}
					break;
 				case "cntr_no_multi":	// inputting multi
 					rep_Multiful_inquiry("cntr_no");
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
    
    function rep_Multiful_inquiry(input_obj) {
       	var formObject=document.form;
       	var cmdt_cd_val=""; // 향후 사용가능 예정변수
       	var rep_cmdt_cd_val=""; // 향후 사용가능 예정변수
       	var cmdt_desc_val=""; // 향후 사용가능 예정변수
       	var classId="getLse_Multi";
       	var xx1=input_obj; // CONTI
       	var xx2=""; // SUB CONTI
       	var xx3=""; // COUNTRY
       	var xx4=""; // STATE
       	var xx5=""; // CONTROL OFFIC
       	var xx6=""; // LOC CODE
       	var xx7=""; // LOC NAME
       	var xx8="";
       	var xx9="";
       	var param="?returnval=" + xx1 + "&sconti_cd=" + xx2 + "&cnt_cd=" + xx3
       			+ "&loc_state=" + xx4 + "&loc_eq_ofc=" + xx5 + "&loc_cd=" + xx6
       			+ "&loc_desc=" + xx7 + "&loc_port_ind=" + xx8 + "&iPage=" + xx9;
       	ComOpenPopup('EES_LSE_1002.do' + param, 400, 330, 'getLse_Multi',
       			'1,0');
    }
    
    function getLse_Multi(rowArray,ret_val) {
    	var formObj=document.form;
    	var tempText="";
    	//initializing
    	formObj.cntr_no.value='';
    	for(var i=0; i<rowArray.length; i++) {
    		var colArray=rowArray[i];
    		tempText +=  rowArray[i] + ',';
    	}
    	//clearing comma(,)
    	tempText=LseDelLastDelim(tempText);
    	tempText=tempText.toUpperCase();
    	eval("document.form." + ret_val + ".value='" + tempText + "';");
    }
    
    /**
     * 반복문으로 생성된 라스트 Delim을 제거 ex) '1,2,3,4,5,' => '1,2,3,4,5'
     * 
     * @param {String}
     *            str 제거 대상 String
     * @return {String} str 제거된 String
     * @author 박영진
     * @version 2009.06.04
     */
    function LseDelLastDelim(str) {
    	// 마지막에 &를 없애기 위함
    	if (str != "") {
    		str=str.substr(0, str.length - 1);
    	}
    	return str;
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
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
		/* initializing IBMultiCombo */
		for ( var k=0 ; k < comboObjects.length ; k++ ) {
	        initCombo(comboObjects[k], k+1);
	    }
		//obj_change();
		sheet1_OnLoadFinish(sheet1);
    }
	/**
	 * calling event after Load-Finish
	 */
    function sheet1_OnLoadFinish(sheetObj) {
		var formObj=document.form;
     	/* IBMulti Combo Item Setting */
		doActionIBSheet(sheetObjects[0], document.form, IBCREATE);
		/* Axon Control Setting*/
		initControl();
		// setting button befor retrieve
		LseComBtnControl(false, "btn_DetailInquiry");
		/* Focus Setting */
		setEnableSwitch("1");
		ComSetFocus(formObj.loc_cd);
    }
	/** registering initial event */
  	function initControl() {
  		var formObj=document.form;
  		axon_event.addListenerFormat('blur',		'obj_blur',		formObj); 
		axon_event.addListenerForm('focus',			'obj_focus',	formObj); 
//		axon_event.addListenerFormat('keypress',	'obj_keypress',	formObj); 
		axon_event.addListenerFormat('keyup',		'obj_keyup',	formObj); 
		axon_event.addListenerForm('keydown',		'obj_keydown',	formObj); 
		axon_event.addListenerForm('change',		'obj_change',	formObj); 
	    //axon_event.addListener ('keydown', 'ComKeyEnter', 'form');  
  	}
	//setting event Duplicate
	var preEventType=null;
  	/**
	 * handling Location blur event
	 */
	function obj_blur(){
		var obj=ComGetEvent();
		if(preEventType == event.type) {
			preEventType=null;
			return;
		}
	    switch(ComGetEvent("name")){
	    	case "agmt_seq" :
	    	case "vndr_seq" :
	    		/* checking number */
	            ComChkObjValid(obj, true, false, false);
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
		var obj  = ComGetEvent();
		var formObj = document.form;

		if(ComGetEvent("name") == "del_cd" && formObj.del_cd.value == "") {
			formObj.del_cd.value = formObj.port_cd.value;
		}

		if( obj.readOnly ) {
			ComSetNextFocus(obj);
		} else {
		    //deleting data unit separator
		    ComClearSeparator(obj);
		}
	}	
	
	
	/**
	 * Onhandling event in case of Change
	 */
	function obj_change(){
		var obj=ComGetEvent();
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		switch(ComGetEvent("name")) {
			case "loc_case":	//Location Case
				sheetObj.RemoveAll();
				clearForm("port_loc");
				setEnableSwitch(formObj.loc_case.value);
				if(formObj.loc_case.value == "2") {
					ComSetFocus(formObj.port_cd);
				} else if(formObj.loc_case.value == "3") {
					ComSetFocus(formObj.slan_cd);
				} else {
					ComSetFocus(formObj.loc_cd);
				}
				break;
			case "loc_tp":		//Location Type
				formObj.loc_cd.value="";
				formObj.loc_cd.maxLength=formObj.loc_tp.value == "3" ? 7 : 5;
				ComSetNextFocus(obj);
				break;
			case "loc_cd":		//Location Code
				if ( ComTrim(formObj.loc_cd.value) != "" ) {
					if(obj.maxLength == 5) {
	        			doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC01);
  					} else {
  						doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC08);
  					}
  				}
				break;
			case "port_cd":
				if ( ComTrim(formObj.port_cd.value) != "" ) {
	        		doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC02);
  				}
				break;
			case "slan_cd":
				if ( ComTrim(formObj.slan_cd.value) != "" ) {
	        		doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC07);
  				}
				break;
			case "del_cd":	//Delivery SCC
  				if ( ComTrim(formObj.del_cd.value) != "" ) {
	        	//	doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC06);
  				}
				break;
			case "estm_tp":
				ComSetNextFocus(obj);
				break;
  			case "str_estm_dt":
    		case "end_estm_dt":
    			checkDurationDate(obj);
	    		break;
			case "vvd_cd":		//VVD Code Search
				if ( ComTrim(formObj.vvd_cd.value) != "" ) {
	        		doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC03);
  				}
				break;
  			case "agmt_seq":	//Agreement No.
  				if ( ComTrim(formObj.agmt_seq.value) != "" ) {
					doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC04);
				}
				break;
			case "vndr_seq":	//Lessor Code
  				if ( ComTrim(formObj.vndr_seq.value) != "" ) {
	        		doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC05);
  				}
  				break;
		}
	}
	
	/**
	 * handling event in case of Key-Press
	 */
	function obj_keypress() {
		var obj = ComGetEvent();
		var formObj = document.form;

		switch(obj.dataformat) {
	        case "float":
	            ComKeyOnlyNumber(obj, "-.");
	            break;
	        case "eng":
	            ComKeyOnlyAlphabet();
	            break;
	        case "engup":
	        	if(ComGetEvent("name") == "loc_cd") {
	        		ComKeyOnlyAlphabet('uppernum');
	        	} else if(obj.name == "vvd_cd") {
	        		if(formObj.vvd_cd.value.length > 3 && formObj.vvd_cd.value.length < 8) {
						ComKeyOnlyNumber(obj);
	        		} else {
						ComKeyOnlyAlphabet('upper');
		        	}
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
	 * HTML Control KeyUp event
	 */
	function obj_keyup() {
		if((ComGetEvent("keycode") >= 37)&&(ComGetEvent("keycode") <= 40)) return; 
    
  		var obj = ComGetEvent();
  		var formObj = document.form;

  		switch(ComGetEvent("name")) {
  			case "vndr_seq":
				if ( ComTrim(formObj.vndr_seq.value) == "" ) {
  					clearForm(obj.name);
  				} else {
  					ComKeyEnter('LengthNextFocus');
  				}
  				break;
  			case "agmt_seq":
				if ( ComTrim(formObj.agmt_seq.value) == "" ) {
  					clearForm(obj.name);
  				} else {
  					ComKeyEnter('LengthNextFocus');
  				}
  				break;

  			default :
			  	ComKeyEnter('LengthNextFocus');
  		}	    
	}
	
	/**
	 * HTML Control KeyDowm event
	 */
	function obj_keydown() {
		if((event.keyCode >= 37)&&(event.keyCode <= 40)) return; 	 
	    
   		var obj      = ComGetEvent();
   		var vKeyCode = event.keyCode;
   		var formObj  = document.form;
   		if ( vKeyCode == 13 ) {
   			switch(ComGetEvent("name")) {
   				case "loc_cd":
	  				if ( ComTrim(formObj.loc_cd.value) == "" ) doActionIBSheet(sheetObjects[0], formObj, IBBATCH);
					break;
   				case "port_cd":
	  				if ( ComTrim(formObj.port_cd.value) == "" ) doActionIBSheet(sheetObjects[0], formObj, IBBATCH);
					break;
   				case "slan_cd":
	  				if ( ComTrim(formObj.slan_cd.value) == "" ) doActionIBSheet(sheetObjects[0], formObj, IBBATCH);
					break;
   				case "del_cd":		//Delivery SCC
	  				if ( ComTrim(formObj.del_cd.value) == "" ) doActionIBSheet(sheetObjects[0], formObj, IBBATCH);
					break;
   				case "vvd_cd":		//VVD Code Search
	  				if ( ComTrim(formObj.vvd_cd.value) == "" ) doActionIBSheet(sheetObjects[0], formObj, IBBATCH);
					break;
				case "vndr_seq":
	  				if ( ComTrim(formObj.vndr_seq.value) == "" ) doActionIBSheet(sheetObjects[0], formObj, IBBATCH);
					break;
	  			case "agmt_seq":
	  				if ( ComTrim(formObj.agmt_seq.value) == "" ) {
						doActionIBSheet(sheetObjects[0], formObj, IBBATCH);
					}
					break;
				default :
					doActionIBSheet(sheetObjects[0], formObj, IBBATCH);
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
		var sheetid=sheetObj.id;
        switch(sheetid) {
            case "sheet1":
                with (sheetObj) {

                var HeadTitle1="|Sel.|LOC|AGMT No.|||Ref No.|Lessor|Lessor||Lease\nTerm|TP/SZ|DOL vs PFMC|DOL vs PFMC|DOL vs PFMC|Reserved\nQ'ty|Remained\nQ'ty|Available Off-Hire Q'ty|Available Off-Hire Q'ty|Available Off-Hire Q'ty|Available Off-Hire Q'ty|Available Off-Hire Q'ty|Available Off-Hire Q'ty|CNTR List|CNTR List";
                var HeadTitle2="|Sel.|LOC|AGMT No.|||Ref No.|Lessor|Lessor||Lease\nTerm|TP/SZ|DOL|PFMC|Balance|Reserved\nQ'ty|Remained\nQ'ty|MT|VL/TS|VD/IC|ID|EN/TN|Total|Sent|Rest";
                var headCount=ComCountHeadTitle(HeadTitle1);
                //(headCount, 0, 0, true);

                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"},
                              { Text:HeadTitle2, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                          {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"del_chk" },
                          {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"scc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                          {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"agmt_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                          {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"agmt_cty_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                          {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"agmt_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                          {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"ref_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                          {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vndr_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                          {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"vndr_abbr_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                          {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vndr_lgl_eng_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                          {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"lstm_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                          {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                          {Type:"AutoSum",   Hidden:0, Width:45,   Align:"Right",   ColMerge:1,   SaveName:"dol_qty",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                          {Type:"AutoSum",   Hidden:0, Width:45,   Align:"Right",   ColMerge:1,   SaveName:"pfmc_qty",         KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                          {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"bal_qty",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                          {Type:"AutoSum",   Hidden:0, Width:65,   Align:"Right",   ColMerge:1,   SaveName:"res_qty",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                          {Type:"AutoSum",   Hidden:0, Width:65,   Align:"Right",   ColMerge:1,   SaveName:"rem_qty",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                          {Type:"AutoSum",   Hidden:0, Width:45,   Align:"Right",   ColMerge:1,   SaveName:"mt_qty",           KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                          {Type:"AutoSum",   Hidden:0, Width:45,   Align:"Right",   ColMerge:1,   SaveName:"vl_qty",           KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                          {Type:"AutoSum",   Hidden:0, Width:45,   Align:"Right",   ColMerge:1,   SaveName:"ic_qty",           KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                          {Type:"AutoSum",   Hidden:0, Width:45,   Align:"Right",   ColMerge:1,   SaveName:"id_qty",           KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                          {Type:"AutoSum",   Hidden:0, Width:45,   Align:"Right",   ColMerge:1,   SaveName:"etn_qty",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                          {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"tot_qty",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                          {Type:"AutoSum",   Hidden:0, Width:45,   Align:"Right",   ColMerge:1,   SaveName:"hld_qty",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                          {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"cntr_qty",         KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                 
                InitColumns(cols);

                SetEditable(1);
                SetAutoSumPosition(-1);
                SetCountFormat("[SELECTDATAROW / TOTALROWS]");
                //SetSheetHeight(320);
                ComResizeSheet(sheetObj);
            }
			break;
        }
    }
	/**
	 * initializing IBMultiCombo
	 */
	function initCombo(comboObj, comboNo) {
	    switch(comboObj.options.id) {
	        case "combo1":
	        	with(comboObj) {
	            	SetDropHeight(250);
	            	SetMultiSelect(1);
	            	//MaxSelect = 1;
	            	SetMultiSeparator(",");
	            	Style=0;
             		SetUseAutoComplete(1);
             		//only upper case, special characters - Lease Term
             //no support[check again]CLT 		ValidChar(2,2);
	        	}
	        	break;
	        case "combo2":
	        	with(comboObj) {
	            	SetDropHeight(200);
	            	SetMultiSelect(1);
	            	//MaxSelect = 1;
	            	SetMultiSeparator(",");
	            	Style=0;
             		SetUseAutoComplete(1);
             		//only upper case, special characters, number - TP/SZ
             //no support[check again]CLT 		ValidChar(2,3);
	            }
	        	break;
	        case "combo3":
	        	with(comboObj) {
	            	SetDropHeight(200);
	            	SetMultiSelect(1);
	            	//MaxSelect = 1;
	            	SetMultiSeparator(",");
	            	Style=0;
             		SetUseAutoComplete(1);
             		//영문(대)+특수문자 - MVMT Status
             //no support[check again]CLT 		ValidChar(2,2);
	            }
	        	break;
	    }
	}
  	/**
	 * handling process for Sheet
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
        	case IBCREATE:
				//Lease Term Combo Item Setting
				comboObjects[0].InsertItem(0 , 'ALL','');
				LseComText2ComboItem(comboObjects[0], vOrcLstmCd, vOrcLstmCd, "|");
				setDefaultComboCheck(comboObjects[0]);
				//Container Movement Status Combo Item Setting Start
            	comboObjects[2].InsertItem(0 , 'ALL','');
            	LseComText2ComboItem(comboObjects[2], vCnmvStsCd, vCnmvStsCd, "|");
            	setDefaultComboCheck(comboObjects[2]);
				sheetObj.SetWaitImageVisible(0);
				//Container Type/Size Combo Item Setting Start
				formObj.f_cmd.value=SEARCH02;
				var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do", FormQueryString(formObj));
		        sheetObj.SetWaitImageVisible(1);
	            if ( sXml != "" ) {
	            	comboObjects[1].InsertItem(0 , 'ALL','');
	            	LseComXml2ComboItem(sXml, comboObjects[1], "cntr_tpsz_nm", "cntr_tpsz_cd", "|");
	            	vOrcCntrTpszCd=ComGetEtcData(sXml, "cntr_tpsz_cd");
	            	setDefaultComboCheck(comboObjects[1]);
	            }            
	            break;
			case IBSEARCH:
				if(validateForm(sheetObj, formObj, sAction)) {
					if(sheetObj.id == "sheet1") {
//						formObj.f_cmd.value=SEARCH;
//						sheetObj.RenderSheet(0);
//						sheetObj.DoSearch("EES_LSE_0020GS.do",FormQueryString(formObj) );
						
						formObj.f_cmd.value=SEARCH;
	 		 			var sXml=sheetObj.GetSearchData("EES_LSE_0020GS.do", FormQueryString(formObj));
	 		 			sheetObj.LoadSearchData(sXml,{Sync:0} );
					}
				}
				break;
			case IBBATCH:      //retrieving for BackEndJob
				if(validateForm(sheetObj, formObj, sAction)) {
					if(sheetObj.id == "sheet1") {
						formObj.f_cmd.value=COMMAND01;
						//sheetObj.SetWaitImageVisible(1);
//						sheetObj.RenderSheet(0);
						ComOpenWait(true);
						//setTimeout( function () {
                            var sXml=sheetObj.GetSearchData("EES_LSE_0020GS.do", FormQueryString(formObj));
                            var backendJobKey=ComGetEtcData(sXml, "BackEndJobKey");
                            if (backendJobKey.length > 0) {
                                ComSetObjValue(formObj.backendjob_key, backendJobKey);
                                sheetObj.SetWaitTimeOut(10000);
                                timer1=setInterval(getBackEndJobStatus, 3000);
                            }
//                            sheetObj.SetWaitImageVisible(1);
//                            sheetObj.RenderSheet(1);
                            //sheetObj.SetWaitImageVisible(0);
                            sheetObj.LoadSearchData(sXml,{Sync:1} );
//                            ComOpenWait(false);
						//} , 100);
					}
				}
				break;
			case IBSEARCH_ASYNC01:	// retrieving for Location
 				if(validateForm(sheetObj,formObj,sAction)) {
 					if ( sheetObj.id == "sheet1") {
 						var vLocTp=formObj.loc_tp.value == "0" ? "RCC" :
 									 formObj.loc_tp.value == "1" ? "LCC" : "SCC";
 						var param="f_cmd="+SEARCH05+"&loc_tp="+ vLocTp
 								  +"&loc_cd="+ComGetObjValue(formObj.loc_cd);
 						sheetObj.SetWaitImageVisible(0);
 						var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do",param);
						sheetObj.SetWaitImageVisible(1);
						if ( sXml != "" ) {
							if ( ComGetEtcData(sXml, "rcc_cd") != undefined ) {
								if ( ComGetEtcData(sXml, "rcc_cd") != "" ) {
									var vLocCd="";
									switch (vLocTp) {
										case "RCC":
											vLocCd=ComGetEtcData(sXml, "rcc_cd");
											break;
										case "LCC":
											vLocCd=ComGetEtcData(sXml, "lcc_cd");
											break;
										case "SCC":
											vLocCd=ComGetEtcData(sXml, "scc_cd");
											break;
									}
									formObj.loc_cd.value=vLocCd;
									if(formObj.port_cd.className == "input1") {
										ComSetNextFocus(formObj.loc_cd);
									} else {
										ComSetFocus(comboObjects[0]);
									}
								} else {
									ComShowCodeMessage("LSE01037");
									formObj.loc_cd.value="";
									ComSetFocus(formObj.loc_cd);
								}
							} else {
								var errMsg=LseComGetErrMsg(sXml);
								if ( errMsg != "" ) {
									ComShowMessage(errMsg);
								}
								formObj.loc_cd.value="";
								ComSetFocus(formObj.loc_cd);
							}
						}
					}
				}
 				break;
 			case IBSEARCH_ASYNC02:	// retrieving for 'Form Port'
				if(validateForm(sheetObj,formObj,sAction)) {
					if ( sheetObj.id == "sheet1") {
						var param="f_cmd="+SEARCH13+"&loc_cd="+ComGetObjValue(formObj.port_cd);
						sheetObj.SetWaitImageVisible(0);
						var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do",param);
						sheetObj.SetWaitImageVisible(1);
						if ( sXml != "" ) {
							if ( ComGetEtcData(sXml, "loc_cd") != undefined ) {
								if ( ComGetEtcData(sXml, "loc_cd") != "" ) {
									formObj.port_cd.value=ComGetEtcData(sXml, "loc_cd") ;
									ComSetNextFocus(formObj.port_cd);
								}else{
									ComShowCodeMessage("LSE01048");
									formObj.port_cd.value="";
									ComSetFocus(formObj.port_cd);
								}
							} else {
								var errMsg=LseComGetErrMsg(sXml);
								if ( errMsg != "" ) {
									ComShowMessage(errMsg);
								}
								formObj.port_cd.value="";
								ComSetFocus(formObj.port_cd);
							}
						}
					}
				}
				break;
			case IBSEARCH_ASYNC03:	//retrieving for Form VVD Code.
				if(validateForm(sheetObj,formObj,sAction)) {
 					if ( sheetObj.id == "sheet1") {
 						ComSetObjValue(formObj.f_cmd, SEARCH03);
 						var param="f_cmd="+SEARCH14+"&vvd_cd="+ComGetObjValue(formObj.vvd_cd);
 						sheetObj.SetWaitImageVisible(0);
 						var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do",param);
						sheetObj.SetWaitImageVisible(1);
						if ( sXml != "" ) {
							if ( ComGetEtcData(sXml, "vvd_cd") != undefined ) {
								if ( ComGetEtcData(sXml, "vvd_cd") != "" ) {
									formObj.vvd_cd.value=ComGetEtcData(sXml, "vvd_cd");
									ComSetNextFocus(formObj.vvd_cd);
								}else{
									ComShowCodeMessage("LSE01109");
									formObj.vvd_cd.value="";
									ComSetFocus(formObj.vvd_cd);
								}
							} else {
								var errMsg=LseComGetErrMsg(sXml);
								if ( errMsg != "" ) {
									ComShowMessage(errMsg);
								}
								formObj.vvd_cd.value="";
								ComSetFocus(formObj.vvd_cd);
							}
						}
 					}
				}
				break;
 			case IBSEARCH_ASYNC04:	//retrieving when input Form Agreement No.
 				if(validateForm(sheetObj,formObj,sAction)) {
 					if ( sheetObj.id == "sheet1") {
 						ComSetObjValue(formObj.f_cmd, SEARCH03);
 						var param="f_cmd="+SEARCH03+"&agmt_cty_cd="+ComGetObjValue(formObj.agmt_cty_cd)
 								  + "&agmt_seq="+ComGetObjValue(formObj.agmt_seq);
 						sheetObj.SetWaitImageVisible(0);
 						var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do",param);
						sheetObj.SetWaitImageVisible(1);
						if ( sXml != "" ) {
							if ( ComGetEtcData(sXml, "lstm_cd") != undefined ) {
								ComSetObjValue(formObj.vndr_seq, ComGetEtcData(sXml, "vndr_seq"));
								doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC05);
							} else {
	 							ComShowCodeMessage("LSE01007");
	 							clearForm("agmt_seq");
	 						}
						} else {
							var errMsg=LseComGetErrMsg(sXml);
							if ( errMsg != "" ) {
								ComShowMessage(errMsg);
							}
							clearForm("agmt_seq");
						}
 					}
				}
				break;
			case IBSEARCH_ASYNC05:	//retrieving when input Form Lessor No.
				if ( validateForm(sheetObj, formObj, sAction) ) {
					var param="f_cmd="+SEARCH06+"&vndr_seq="+ComGetObjValue(formObj.vndr_seq);
					sheetObj.SetWaitImageVisible(0);
					var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do", param);
					sheetObj.SetWaitImageVisible(1);
					if ( sXml != "" ) {
						if ( ComGetEtcData(sXml, "vndr_lgl_eng_nm") != undefined ) {
							ComSetObjValue(formObj.vndr_nm, ComGetEtcData(sXml, "vndr_lgl_eng_nm"));
							//ComSetObjValue(formObj.vndr_abbr_nm, ComGetEtcData(sXml, "vndr_abbr_nm"));
							ComSetFocus(formObj.vndr_nm);
 						} else {
 							ComShowCodeMessage("LSE01019");
 							clearForm("vndr_seq");
 						}
					} else {
						var errMsg=LseComGetErrMsg(sXml);
						if ( errMsg != "" ) {
							ComShowMessage(errMsg);
						}
						clearForm("vndr_seq");
					}
				}
				break;
			case IBSEARCH_ASYNC06:	// retrieving for Form Delivery SCC
				if(validateForm(sheetObj,formObj,sAction)) {
					if ( sheetObj.id == "sheet1") {
						var param="f_cmd="+SEARCH05+"&loc_tp=SCC&loc_cd="+ComGetObjValue(formObj.del_cd);
						sheetObj.SetWaitImageVisible(0);
						var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do",param);
						sheetObj.SetWaitImageVisible(1);
						if ( sXml != "" ) {
							if ( ComGetEtcData(sXml, "scc_cd") != undefined ) {
								if ( ComGetEtcData(sXml, "scc_cd") != "" ) {
									formObj.del_cd.value=ComGetEtcData(sXml, "scc_cd");
								}else{
									ComShowCodeMessage("LSE01048");
									formObj.del_cd.value="";
									ComSetFocus(formObj.del_cd);
								}
							} else {
								var errMsg=LseComGetErrMsg(sXml);
								if ( errMsg != "" ) {
									ComShowMessage(errMsg);
								}
								formObj.del_cd.value="";
								ComSetFocus(formObj.del_cd);
							}
						}
					}
				}
				break;
			case IBSEARCH_ASYNC07:	// retrieving for Form Lane
				if(validateForm(sheetObj,formObj,sAction)) {
					if ( sheetObj.id == "sheet1") {
						var param="f_cmd="+SEARCH19+"&slan_cd="+ComGetObjValue(formObj.slan_cd);
						sheetObj.SetWaitImageVisible(0);
						var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do",param);
						sheetObj.SetWaitImageVisible(1);
						if ( sXml != "" ) {
							if ( ComGetEtcData(sXml, "slan_cd") != undefined ) {
								if ( ComGetEtcData(sXml, "slan_cd") != "" ) {
									formObj.slan_cd.value=ComGetEtcData(sXml, "slan_cd") ;
									ComSetNextFocus(formObj.slan_cd);
								}else{
									ComShowCodeMessage("LSE01048");
									formObj.slan_cd.value="";
									ComSetFocus(formObj.slan_cd);
								}
							} else {
								var errMsg=LseComGetErrMsg(sXml);
								if ( errMsg != "" ) {
									ComShowMessage(errMsg);
								}
								formObj.slan_cd.value="";
								ComSetFocus(formObj.slan_cd);
							}
						}
					}
				}
				break;
			case IBSEARCH_ASYNC08:	// retrieving for Yard
 				if(validateForm(sheetObj,formObj,sAction)) {
 					if ( sheetObj.id == "sheet1") {
 						var param="f_cmd="+SEARCH+"&node_cd="+ComGetObjValue(formObj.loc_cd)
 								  + "&mode=yard";
 						sheetObj.SetWaitImageVisible(0);
 						var sXml=sheetObj.GetSearchData("COM_ENS_061GS.do",param);
						sheetObj.SetWaitImageVisible(1);
						if ( ComGetTotalRows(sXml) == 1 ) {
							ComSetFocus(formObj.loc_cd);
						} else {
							ComShowCodeMessage("LSE01048");
							formObj.loc_cd.value="";
							ComSetFocus(formObj.loc_cd);
						}
					}
				}
 				break;
        }
    }
	/**
     * calling event after retrieving Sheet
	 * @param sheetObj
	 * @param ErrMsg
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	with(sheetObj) {
			for(var i=HeaderRows(); i <= LastRow(); i++) {
				var vRemQty=Number(GetCellValue(i, "rem_qty"));
				var vTotQty=Number(GetCellValue(i, "tot_qty"));
				var vHldQty=Number(GetCellValue(i, "hld_qty"));
				var vCntrQty=Number(GetCellValue(i, "cntr_qty"));
				var vDolQty=Number(GetCellValue(i, "dol_qty"));
				var vRstQty=vTotQty - vHldQty;
    			SetCellText(i, "hld_qty" ,vHldQty == 0 ? "" : vHldQty);
    			SetCellFontColor(i, "cntr_qty",vCntrQty < 0 ? "#FF0000":"#0000FF");
    			//parameter changed[check again]CLT SetCellFontColor(i, "cntr_qty",vCntrQty < 0 ? "#FF000000FF");
    			//CellFontColor(i, "cntr_qty") = vCntrQty < 0 ? RgbColor(255, 0, 0) : RgbColor(0, 0, 255);

    		}
			sheetObj.SetMergeCell(LastRow(), 1, 1, 10);
			SetCellAlign(LastRow(), "del_chk","Center");
			sheetObj.SetCellText(LastRow(), "del_chk" ,"G.TTL");
			LseComBtnControl(false, "btn_DetailInquiry");
    		sheetObj.RenderSheet(1);
    	}
    	var formObj=document.form;
    	formObj.h_loc_case.value=ComGetObjValue(formObj.loc_case);
    	formObj.h_loc_tp.value=ComGetObjValue(formObj.loc_tp);
    	formObj.h_loc_cd.value=ComGetObjValue(formObj.loc_cd);
    	formObj.h_port_cd.value=ComGetObjValue(formObj.port_cd);
    	formObj.h_slan_cd.value=ComGetObjValue(formObj.slan_cd);
    	formObj.h_del_cd.value=ComGetObjValue(formObj.del_cd);
    	formObj.h_vvd_cd.value=ComGetObjValue(formObj.vvd_cd);
    	formObj.h_estm_tp.value=ComGetObjValue(formObj.estm_tp);
    	formObj.h_str_estm_dt.value=ComGetObjValue(formObj.str_estm_dt);
    	formObj.h_end_estm_dt.value=ComGetObjValue(formObj.end_estm_dt);
    	formObj.h_lstm_cd.value=ComGetObjValue(formObj.lstm_cd);
    	formObj.h_cntr_tpsz_cd.value=ComGetObjValue(formObj.cntr_tpsz_cd);
    	formObj.h_cnmv_sts_cd.value=ComGetObjValue(formObj.cnmv_sts_cd);
    	formObj.h_agmt_cty_cd.value=ComGetObjValue(formObj.agmt_cty_cd);
    	formObj.h_agmt_seq.value=ComGetObjValue(formObj.agmt_seq);
    	formObj.h_vndr_seq.value=ComGetObjValue(formObj.vndr_seq);
    	formObj.h_used_dys.value=ComGetObjValue(formObj.used_dys);
    	formObj.h_free_dys.value=ComGetObjValue(formObj.free_dys);
    	//formObj.h_min_onh_dys_tp.value = ComGetObjValue(formObj.min_onh_dys_tp);
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
				case "del_chk":
					var vDelCheck=FindCheckedRow("del_chk").split("|");
//					
					var vComplexPk="";
					var vComplexPk2="";
					var vDelCheckCount = 0;
					for(var i=0; i < vDelCheck.length; i++) {
						if(vDelCheck[i] != "") {
							vComplexPk += GetCellValue(vDelCheck[i], "scc_cd");
							vComplexPk += GetCellValue(vDelCheck[i], "agmt_cty_cd");
							vComplexPk += GetCellValue(vDelCheck[i], "agmt_seq");
							vComplexPk += GetCellValue(vDelCheck[i], "vndr_seq");
							vComplexPk += GetCellValue(vDelCheck[i], "lstm_cd");
							vComplexPk += GetCellValue(vDelCheck[i], "cntr_tpsz_cd") +"|";
							vComplexPk2 += GetCellValue(vDelCheck[i], "agmt_cty_cd");
							vComplexPk2 += GetCellValue(vDelCheck[i], "agmt_seq");
							vComplexPk2 += GetCellValue(vDelCheck[i], "vndr_seq");
							vComplexPk2 += GetCellValue(vDelCheck[i], "lstm_cd");
							vComplexPk2 += GetCellValue(vDelCheck[i], "cntr_tpsz_cd") +"|";
							vDelCheckCount++;
						}
					}
					ComSetObjValue(formObj.complex_pk,  vComplexPk.substr(0,vComplexPk.length -1));
					ComSetObjValue(formObj.complex_pk2, vComplexPk2.substr(0,vComplexPk2.length -1));					
//					
//					LseComBtnControl(vDelCheck.length > 0, "btn_DetailInquiry");
					LseComBtnControl(vDelCheckCount != 0, "btn_DetailInquiry");
					break;
				default :
					//do nothing
			}
		}
 	}
	 /**
	 * make_detail_info :: info creation Event for detail
	 */
	function make_detail_info(sheetObj) {
		with(sheetObj) {
			var formObj=document.form;
			var vDelCheck=FindCheckedRow("del_chk").split("|");
			var vComplexPk="";
			var vComplexPk2="";
			var vComplexPk3="";
			var vComplexPk4="";
			var vComplexPk5="";
			var vComplexPk6="";
			var vComplexPk7="";
			var vComplexPk8="";
			var vComplexPk9="";
			var vComplexPk10="";
			var vComplexPk11="";
			var vComplexPk12="";
			var vComplexPk13="";
			var vComplexPk14="";
			var vComplexPk15="";
			var vComplexPk16="";
			var vComplexPk17="";
			var vComplexPk18="";
			var vComplexPk19="";
            for(var i=0; i<vDelCheck.length; i++) {
			  if(i < 200){
                if(vDelCheck[i] != "") {
                  if(i==0){ vComplexPk="|"; };
					vComplexPk += GetCellValue(vDelCheck[i], "scc_cd");
					vComplexPk += GetCellValue(vDelCheck[i], "agmt_no");
					vComplexPk += GetCellValue(vDelCheck[i], "cntr_tpsz_cd") +"|";
                }
			  }else if(i < 400){
                if(vDelCheck[i] != "") {
                  if(i==200){ vComplexPk2="|"; };
					vComplexPk2 += GetCellValue(vDelCheck[i], "scc_cd");
					vComplexPk2 += GetCellValue(vDelCheck[i], "agmt_no");
					vComplexPk2 += GetCellValue(vDelCheck[i], "cntr_tpsz_cd") +"|";
                }
			  }
			  else if(i < 600){
                if(vDelCheck[i] != "") {
                  if(i==400){ vComplexPk3="|"; };
					vComplexPk3 += GetCellValue(vDelCheck[i], "scc_cd");
					vComplexPk3 += GetCellValue(vDelCheck[i], "agmt_no");
					vComplexPk3 += GetCellValue(vDelCheck[i], "cntr_tpsz_cd") +"|";
                }
			  }else if(i < 800){
                if(vDelCheck[i] != "") {
                  if(i==600){ vComplexPk4="|"; };
					vComplexPk4 += GetCellValue(vDelCheck[i], "scc_cd");
					vComplexPk4 += GetCellValue(vDelCheck[i], "agmt_no");
					vComplexPk4 += GetCellValue(vDelCheck[i], "cntr_tpsz_cd") +"|";
                }
			  }else if(i < 1000){
                if(vDelCheck[i] != "") {
                  if(i==800){ vComplexPk5="|"; };
					vComplexPk5 += GetCellValue(vDelCheck[i], "scc_cd");
					vComplexPk5 += GetCellValue(vDelCheck[i], "agmt_no");
					vComplexPk5 += GetCellValue(vDelCheck[i], "cntr_tpsz_cd") +"|";
                }
			  }else if(i < 1200){
                if(vDelCheck[i] != "") {
                  if(i==1000){ vComplexPk6="|"; };
					vComplexPk6 += GetCellValue(vDelCheck[i], "scc_cd");
					vComplexPk6 += GetCellValue(vDelCheck[i], "agmt_no");
					vComplexPk6 += GetCellValue(vDelCheck[i], "cntr_tpsz_cd") +"|";
                }
			  }else if(i < 1400){
                if(vDelCheck[i] != "") {
                  if(i==1200){ vComplexPk7="|"; };
					vComplexPk7 += GetCellValue(vDelCheck[i], "scc_cd");
					vComplexPk7 += GetCellValue(vDelCheck[i], "agmt_no");
					vComplexPk7 += GetCellValue(vDelCheck[i], "cntr_tpsz_cd") +"|";
                }
			  }else if(i < 1600){
                if(vDelCheck[i] != "") {
                  if(i==1400){ vComplexPk8="|"; };
					vComplexPk8 += GetCellValue(vDelCheck[i], "scc_cd");
					vComplexPk8 += GetCellValue(vDelCheck[i], "agmt_no");
					vComplexPk8 += GetCellValue(vDelCheck[i], "cntr_tpsz_cd") +"|";
                }
			  }else if(i < 1800){
                if(vDelCheck[i] != "") {
                  if(i==1600){ vComplexPk9="|"; };
					vComplexPk9 += GetCellValue(vDelCheck[i], "scc_cd");
					vComplexPk9 += GetCellValue(vDelCheck[i], "agmt_no");
					vComplexPk9 += GetCellValue(vDelCheck[i], "cntr_tpsz_cd") +"|";
                }
			  }else if(i < 2000){
                if(vDelCheck[i] != "") {
                  if(i==1800){ vComplexPk10="|"; };
					vComplexPk10 += GetCellValue(vDelCheck[i], "scc_cd");
					vComplexPk10 += GetCellValue(vDelCheck[i], "agmt_no");
					vComplexPk10 += GetCellValue(vDelCheck[i], "cntr_tpsz_cd") +"|";
                }
			  }else if(i < 2200){
                if(vDelCheck[i] != "") {
                  if(i==2000){ vComplexPk11="|"; };
					vComplexPk11 += GetCellValue(vDelCheck[i], "scc_cd");
					vComplexPk11 += GetCellValue(vDelCheck[i], "agmt_no");
					vComplexPk11 += GetCellValue(vDelCheck[i], "cntr_tpsz_cd") +"|";
                }
			  }else if(i < 2400){
                if(vDelCheck[i] != "") {
                  if(i==2200){ vComplexPk12="|"; };
					vComplexPk12 += GetCellValue(vDelCheck[i], "scc_cd");
					vComplexPk12 += GetCellValue(vDelCheck[i], "agmt_no");
					vComplexPk12 += GetCellValue(vDelCheck[i], "cntr_tpsz_cd") +"|";
                }
			  }else if(i < 2600){
                if(vDelCheck[i] != "") {
                  if(i==2400){ vComplexPk13="|"; };
					vComplexPk13 += GetCellValue(vDelCheck[i], "scc_cd");
					vComplexPk13 += GetCellValue(vDelCheck[i], "agmt_no");
					vComplexPk13 += GetCellValue(vDelCheck[i], "cntr_tpsz_cd") +"|";
                }
			  }else if(i < 2800){
                if(vDelCheck[i] != "") {
                  if(i==2600){ vComplexPk14="|"; };
					vComplexPk14 += GetCellValue(vDelCheck[i], "scc_cd");
					vComplexPk14 += GetCellValue(vDelCheck[i], "agmt_no");
					vComplexPk14 += GetCellValue(vDelCheck[i], "cntr_tpsz_cd") +"|";
                }
			  }else if(i < 3000){
                if(vDelCheck[i] != "") {
                  if(i==2800){ vComplexPk15="|"; };
					vComplexPk15 += GetCellValue(vDelCheck[i], "scc_cd");
					vComplexPk15 += GetCellValue(vDelCheck[i], "agmt_no");
					vComplexPk15 += GetCellValue(vDelCheck[i], "cntr_tpsz_cd") +"|";
                }
			  }else if(i < 3200){
                if(vDelCheck[i] != "") {
                  if(i==3000){ vComplexPk16="|"; };
					vComplexPk16 += GetCellValue(vDelCheck[i], "scc_cd");
					vComplexPk16 += GetCellValue(vDelCheck[i], "agmt_no");
					vComplexPk16 += GetCellValue(vDelCheck[i], "cntr_tpsz_cd") +"|";
                }
			  }else if(i < 3400){
                if(vDelCheck[i] != "") {
                  if(i==3200){ vComplexPk17="|"; };
					vComplexPk17 += GetCellValue(vDelCheck[i], "scc_cd");
					vComplexPk17 += GetCellValue(vDelCheck[i], "agmt_no");
					vComplexPk17 += GetCellValue(vDelCheck[i], "cntr_tpsz_cd") +"|";
                }
			  }else if(i < 3600){
                if(vDelCheck[i] != "") {
                  if(i==3400){ vComplexPk18="|"; };
					vComplexPk18 += GetCellValue(vDelCheck[i], "scc_cd");
					vComplexPk18 += GetCellValue(vDelCheck[i], "agmt_no");
					vComplexPk18 += GetCellValue(vDelCheck[i], "cntr_tpsz_cd") +"|";
                }
			  }else if(i < 3800){
                if(vDelCheck[i] != "") {
                  if(i==3600){ vComplexPk19="|"; };
					vComplexPk19 += GetCellValue(vDelCheck[i], "scc_cd");
					vComplexPk19 += GetCellValue(vDelCheck[i], "agmt_no");
					vComplexPk19 += GetCellValue(vDelCheck[i], "cntr_tpsz_cd") +"|";
                }
			  }
            }
            ComSetObjValue(formObj.complex_pk,  vComplexPk);
			ComSetObjValue(formObj.complex_pk2, vComplexPk2);
			ComSetObjValue(formObj.complex_pk3, vComplexPk3);
			ComSetObjValue(formObj.complex_pk4, vComplexPk4);
			ComSetObjValue(formObj.complex_pk5, vComplexPk5);
			ComSetObjValue(formObj.complex_pk6, vComplexPk6);
			ComSetObjValue(formObj.complex_pk7, vComplexPk7);
			ComSetObjValue(formObj.complex_pk8, vComplexPk8);
			ComSetObjValue(formObj.complex_pk9, vComplexPk9);
			ComSetObjValue(formObj.complex_pk10, vComplexPk10);
			ComSetObjValue(formObj.complex_pk11, vComplexPk11);
			ComSetObjValue(formObj.complex_pk12, vComplexPk12);
			ComSetObjValue(formObj.complex_pk13, vComplexPk13);
			ComSetObjValue(formObj.complex_pk14, vComplexPk14);
			ComSetObjValue(formObj.complex_pk15, vComplexPk15);
			ComSetObjValue(formObj.complex_pk16, vComplexPk16);
			ComSetObjValue(formObj.complex_pk17, vComplexPk17);
			ComSetObjValue(formObj.complex_pk18, vComplexPk18);
			ComSetObjValue(formObj.complex_pk19, vComplexPk19);
		}
	 } 	
	/**
	 * handling event in case of Mouse-Move sheet
	 */
	function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) {
		with(sheetObj) {
			Row=MouseRow();
			Col=MouseCol();
			if(Row >= HeaderRows()&& ColSaveName(Col) == "vndr_abbr_nm") {
				sText=GetCellText(Row,Col);
//no support[check again]CLT 				MouseToolTipText=GetCellText(Row,"vndr_seq") +"|"+ GetCellText(Row,"vndr_lgl_eng_nm");
			} else {
//no support[check again]CLT 				MouseToolTipText="";
			}
		}
	}
	/**
	 * handling event in case of OnCheckClick combo
	 * @return
	 */
	function combo1_OnCheckClick(comboObj, index, text, code) {
		if(index==0) {
			var bChk=comboObj.GetItemCheck(index);
			if(bChk){
				for(var i=1 ; i < comboObj.GetItemCount() ; i++) {
					comboObj.SetItemCheck(i,0);
				}
				comboObj.SetItemCheck(0,1);
			}
		} else {
			comboObj.SetItemCheck(0,0);
		}
	}
	
	
	/**
	 * handling event in case of OnCheckClick combo
	 * @return
	 */
	function combo2_OnCheckClick(comboObj, index, code) {
		if(index==0) {
			var bChk=comboObj.GetItemCheck(index);
			if(bChk){
				for(var i=1 ; i < comboObj.GetItemCount() ; i++) {
					comboObj.SetItemCheck(i,0);
				}
				comboObj.SetItemCheck(0,1);
			}
		} else {
			comboObj.SetItemCheck(0,0);
		}
	}
	/**
	 * handling event in case of OnCheckClick combo
	 * @return
	 */
	function combo3_OnCheckClick(comboObj, index, code) {
		if(index==0) {
			var bChk=comboObj.GetItemCheck(index);
			if(bChk){
				for(var i=1 ; i < comboObj.GetItemCount() ; i++) {
					comboObj.SetItemCheck(i,0);
				}
				comboObj.SetItemCheck(0,1);
			}
		} else {
			comboObj.SetItemCheck(0,0);
		}
	}
    /**
	 * combo2_OnBlur
	 */
	//Find or create function combo_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode)
	function combo1_OnBlur(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
		var formObj=document.form;
		formObj.lstm_cd.value=ComGetObjValue(comboObj);
	}
    /**
	 * combo2_OnBlur
	 */
	function combo2_OnBlur(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
		var formObj=document.form;
		formObj.cntr_tpsz_cd.value=ComGetObjValue(comboObj);
	}
	/**
	 * combo3_OnBlur
	 */
	function combo3_OnBlur(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
		var formObj=document.form;
		formObj.cnmv_sts_cd.value=ComGetObjValue(comboObj);
	}
	/**
	 * handling event in case of Key-Down combo
	 */
	function combo1_OnKeyDown(comboObj, KeyCode, Shift) {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		with(comboObj) {
			if ( KeyCode == 8 || KeyCode == 46 ) {
				for ( var i=0 ; i < GetItemCount() ; i++ ) {
					if ( CheckIndex(i) ) {
						//CheckIndex(i) = false;
					}
				}
			} else if(KeyCode == 13) {
				formObj.lstm_cd.value=ComGetObjValue(comboObj);
				doActionIBSheet(sheetObj, formObj, IBBATCH);
			}
		}
	}
	/**
	 * combo2_OnKeyDown
	 */
	function combo2_OnKeyDown(comboObj, KeyCode, Shift) {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		with(comboObj) {
			if ( KeyCode == 8 || KeyCode == 46 ) {
				for ( var i=0 ; i < GetItemCount() ; i++ ) {
					if ( CheckIndex(i) ) {
						//CheckIndex(i) = false;
					}
				}
			} else if(KeyCode == 13) {
				formObj.cntr_tpsz_cd.value=ComGetObjValue(comboObj);
				doActionIBSheet(sheetObj, formObj, IBBATCH);
			}
		}
	}
	/**
	 * combo3_OnKeyDown
	 */
	function combo3_OnKeyDown(comboObj, KeyCode, Shift) {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		with(comboObj) {
			if ( KeyCode == 8 || KeyCode == 46 ) {
				for ( var i=0 ; i < GetItemCount() ; i++ ) {
					if ( CheckIndex(i) ) {
						//CheckIndex(i) = false;
					}
				}
			} else if(KeyCode == 13) {
				formObj.cnmv_sts_cd.value=ComGetObjValue(comboObj);
				doActionIBSheet(sheetObj, formObj, IBBATCH);
			}
		}
	}
	/**
	 * IBMultiCombo Default check
	 * @deprecated 2009.09.25 IBCombo Default setting not use
	 */
	function setDefaultComboCheck(comboObj, code) {
		var formObj=document.form;
		//do nothing
		//if(code) {
		//	comboObj.CheckCode(code) = true;
		//} else {
		//	comboObj.CheckIndex(0) = true;
		//}
	}
	/**
     * handing process Pop-up<br>
     * @param type 1:Lessor Code Popup for FORM, 2:Agreement No. Popup for FORM
     * @param Row index
     * @param Col index
     */
    function openPopup(type, Row, Col) {
    	var formObj=document.form;
    	if ( type == "1" ) {
    		switch(formObj.loc_tp.value) {
    			case "0" :	//RCC
    				ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 800, 450,"rcc_cd:loc_cd", "1,0,1,1,1,1,1", true);
    				break;
    			case "1" :	//LCC 
    				ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 800, 480,"lcc_cd:loc_cd", "1,0,1,1,1,1,1", true);
    				break;
    			case "2" :	//SCC
    				ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 800, 480,"scc_cd:loc_cd", "1,0,1,1,1,1,1", true);
    				break;
    			case "3" :	//Yard
					ComOpenPopup("/opuscntr/COM_ENS_061.do",795, 530, "setPopData_DeliveryLoc", "1,0,1,1,1,1,1,1", true);
    			default:	//do nothing
    		}  
    	} else if ( type == "2" ) {
			ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 800, 460,"scc_cd:del_cd", "1,0,1,1,1,1,1", true);
    	} else if ( type == "3" ) {
    		ComOpenPopupWithTarget('/opuscntr/COM_ENS_0B2.do', 770, 550,"vvd:vvd_cd", "1,0,1,1,1,1,1,1", true);
    	} else if ( type == "4" ) {
    		ComOpenPopup('/opuscntr/EES_LSE_0091.do', 805, 500, 'setPopData_Agreement', '1,0', true);
    	} else if ( type == "5" ) {
    		ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 705, 550, 'setPopData_Lessor', '1,0,1,1,1,1,1,1', true);
    	} else if ( type == "6" ) {//Port
    		var port_cd = formObj.port_cd.value;
    		ComOpenPopup('/opuscntr/VOP_VSK_0043.do?port_cd='+port_cd, 480, 520,"setPortCd", "0,0", true); 
    	} else if ( type == "7") {//Lane 조회 팝업
			ComOpenPopupWithTarget('/opuscntr/COM_ENS_081.do', 800, 400, "col1:slan_cd", '1,0,1,1,1,1,1,1', true);
    	} else if ( type == "8") {
    		var formObj=document.form;
			formObj.f_cmd.value=""; 
			ComPostOpenWindow("/opuscntr/EES_LSE_0021.do", "EES_LSE_0021", "status=no, resizable=no, width=855, height=455");
    		//ComOpenWindowCenter("/opuscntr/EES_LSE_0021.do?"+ FormQueryString(formObj), "EES_LSE_0021", 885,455, true);
    	}
    	return;
    }
	/**
     * handling process for Agreement Pop-up Return Value<br>
     * @param Return value array
     * @param Row index
     * @param Col index
     * @param Sheet Array index
     */
    function setPopData_Agreement(aryPopupData, Row, Col, SheetIdx) {
    	var sheetObj=sheetObjects[SheetIdx];
    	var formObj=document.form;
    	if ( aryPopupData.length > 0 ) {
    		document.form.agmt_seq.value=aryPopupData[0][5];
    		document.form.vndr_seq.value=aryPopupData[0][8];
    		doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC05);
    	}
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
			ComSetObjValue(formObj.vndr_seq, ComLtrim(aryPopupData[0][2],"0"));
			//ComSetObjValue(formObj.vndr_abbr_nm,  aryPopupData[0][5]);
			ComSetObjValue(formObj.vndr_nm,  aryPopupData[0][4]);
		}
	}
	/**
      * handling process for DeliveryLoc(Yard) Pop-up Return Value<br>
      * @param Return value array
      * @param Row index
      * @param Col index
      * @param Sheet Array index
      */
     function setPopData_DeliveryLoc(aryPopupData, Row, Col, SheetIdx) {
     	var sheetObj=sheetObjects[SheetIdx];
     	var formObj=document.form;
     	if ( aryPopupData.length > 0 ) {
     		if ( formObj.loc_tp.value == "3" ) {
				ComSetObjValue(formObj.loc_cd, aryPopupData[0][3]);
			}
     	}
     }
	/**
	 * calling after ending E-mail Pop-up
	 */
	function callbackPopupMail(interval) {
		timer2=setInterval(delayActionIBSheet, interval);
	}
	/**
	 * retrieving status 3 for BackEndJob result
	 */
	function getBackEndJobStatus() {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		formObj.f_cmd.value=COMMAND02;
		ComOpenWait(true);
		var sXml=sheetObj.GetSearchData("EES_LSE_0020GS.do", FormQueryString(formObj));
		var jobState=ComGetEtcData(sXml, "jb_sts_flg");
		//2 => 3 => 5 Finish
		if (jobState == "3") {
			getBackEndJobLoadFile();
			clearInterval(timer1);
		} else if (jobState == "4") {
			//ComShowCodeMessage("LSE01124");
			ComOpenWait(false);
			clearInterval(timer1);
		} else if (jobState == "5") {
			//ComShowCodeMessage("LSE01125");
			//clearInterval(timer1);
			ComOpenWait(false);
		}
	}
	/**
	 * downloading result file of BackEndJob
	 */
	function getBackEndJobLoadFile() {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		formObj.f_cmd.value=COMMAND03;
		var sXml=sheetObj.GetSearchData("EES_LSE_0020GS.do", FormQueryString(form));
		sheetObj.LoadSearchData(sXml,{Sync:0} );
		ComOpenWait(false);
	}
	/**
	 * handling process for delay Sheet
	 */
	function delayActionIBSheet() {
		var formObj=document.form;
		//doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
		doActionIBSheet(sheetObjects[0], formObj, IBBATCH);
		clearInterval(timer2);
	}
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj) {
    		switch(sAction) {
    			case IBSEARCH:
    			case IBBATCH:      	//retrieving for BackEndJob
    				if(formObj.loc_cd.className == "input1" && formObj.loc_cd.value == "") {
    					ComShowCodeMessage("LSE01046");
    					ComSetFocus(formObj.loc_cd);
						return false;
					} else if(formObj.slan_cd.className == "input1" && formObj.slan_cd.value == "") {
    					ComShowCodeMessage("LSE01161");
    					ComSetFocus(formObj.slan_cd);
    					return false;
    				} else if(formObj.port_cd.className == "input1" && formObj.port_cd.value == "") {
    					ComShowCodeMessage("LSE01160");
    					ComSetFocus(formObj.port_cd);
    					return false;
    				} else if (!checkDurationDate()) {
    					return false;
    				}
    				return ComChkValid(formObj, true);
    				break;
				default :	//do nothing
    		}
    	}
        return true;
    }
	/**
	 * handling process for Duration Date Validation<br>
	 */
    function checkDurationDate(eventObj) {
    	var formObj=document.form;
    	var vEffDt=ComReplaceStr(ComGetObjValue(formObj.str_estm_dt),"-","");
		var vExpDt=ComReplaceStr(ComGetObjValue(formObj.end_estm_dt),"-","");
		//Division is Location
		if(formObj.loc_case.value == "1") return true;
    	//handling process for Duration Date Validation
    	if(formObj.str_estm_dt.className == "input") {
	    	if( vEffDt == "" && vExpDt == "" ) {
	    		return true;
	    	}
    	}
		/* Duration Date Validation(str_estm_dt) */
		if(vEffDt == "" && eventObj == null) {
			ComShowCodeMessage("LSE01078");
			ComSetFocus(formObj.str_estm_dt);
			return false;
		} else if(vEffDt == "" && eventObj.name == "str_estm_dt") {
			//ComShowCodeMessage("LSE01078");
			//ComSetFocus(formObj.str_estm_dt);
			//return false;
		} else if (vEffDt != "" && !ComIsDate(formObj.str_estm_dt) ) {
			ComShowCodeMessage("LSE01080");
			ComSetObjValue(formObj.str_estm_dt,"");
			ComSetFocus(formObj.str_estm_dt);
			return false;
		}
		/* Duration Date Validation(end_estm_dt) */
		if(vExpDt == "" && eventObj == null) {
			ComShowCodeMessage("LSE01079");
			ComSetFocus(formObj.end_estm_dt);
			return false;
		} else if(vExpDt == "" && eventObj.name == "end_estm_dt") {
			//ComShowCodeMessage("LSE01079");
			//ComSetFocus(formObj.end_estm_dt);
			//return false;
		} else if (vExpDt != "" && !ComIsDate(formObj.end_estm_dt) ) {
			ComShowCodeMessage("LSE01081");
			ComSetObjValue(formObj.end_estm_dt,"");
			ComSetFocus(formObj.end_estm_dt);
			return false;
		}
		/* Duration Date Validation(str_estm_dt < end_estm_dt) */
		if(vEffDt != "" && vExpDt != "") {
			if ( ComChkPeriod(vEffDt, vExpDt) != 1 ) {
				ComShowCodeMessage("LSE01082");
				if(eventObj == null) {
					ComSetObjValue(formObj.end_estm_dt,"");
					ComSetFocus(formObj.end_estm_dt);
				} else {
					ComSetObjValue(eventObj,"");
					ComSetFocus(eventObj);
				}
				return false;
			}
		}
		return true;
    }
	/**
	 * setting Division
	 */
	function setEnableSwitch(value) {
		var formObj=document.form;
		if(value == "0") {
			ComBtnEnable("btns_search1");
			ComBtnEnable("btns_search2");
			ComBtnEnable("btns_search3");
			ComBtnEnable("btns_search6");
			ComBtnEnable("btns_search7");
			ComBtnEnable("btns_calendar");
			formObj.loc_cd.disabled=true;
			formObj.port_cd.disabled=false;
			formObj.slan_cd.disabled=false;
			formObj.del_cd.disabled=false;
			formObj.vvd_cd.disabled=false;
			formObj.str_estm_dt.disabled=false;
			formObj.end_estm_dt.disabled=false;
			formObj.loc_cd.className="input2";
			formObj.slan_cd.className="input";
			formObj.port_cd.className="input";
		} else {
			formObj.loc_cd.className="input";
			formObj.slan_cd.className="input";
			formObj.port_cd.className="input";
			if(value == "1") {
				ComBtnEnable("btns_search1");
				ComBtnDisable("btns_search2");
				ComBtnDisable("btns_search3");
				ComBtnDisable("btns_search6");
				ComBtnDisable("btns_search7");
				ComBtnDisable("btns_calendar");
				formObj.loc_cd.disabled=false;
				formObj.port_cd.disabled=true;
				formObj.slan_cd.disabled=true;
				formObj.del_cd.disabled=true;
				formObj.vvd_cd.disabled=true;
				formObj.str_estm_dt.disabled=true;
				formObj.end_estm_dt.disabled=true;
				formObj.loc_cd.className="input1";
			} else {
				ComBtnDisable("btns_search1");
				ComBtnEnable("btns_search2");
				ComBtnEnable("btns_search3");
				ComBtnEnable("btns_search6");
				ComBtnEnable("btns_search7");
				ComBtnEnable("btns_calendar");
				formObj.loc_cd.disabled=true;
				formObj.port_cd.disabled=false;
				formObj.slan_cd.disabled=false;
				formObj.del_cd.disabled=false;
				formObj.vvd_cd.disabled=false;
				formObj.str_estm_dt.disabled=false;
				formObj.end_estm_dt.disabled=false;
				if (value==2) formObj.port_cd.className="input1";
				else formObj.slan_cd.className="input1";
			}
		}
		if(value != "1" && value != "0") {//loc_case is Port
			var vCurrDate=formObj.h_curr_dt.value;
			formObj.str_estm_dt.value=vCurrDate;
			formObj.end_estm_dt.value=ComGetDateAdd(vCurrDate, "D", 7);
		}
		LseComBtnControl(false, "btn_DetailInquiry");
	}
    /**
	 * handling process for Form Element Clear<br>
	 * @param fieldName
	 */
	function clearForm(fieldName) {
		var formObj=document.form;
		switch(fieldName) {
			case "agmt_seq":
				ComSetObjValue(formObj.agmt_seq,    "");
				ComSetFocus(formObj.agmt_seq);
				break;
			case "vndr_seq":
				ComSetObjValue(formObj.vndr_seq, 	"");
				ComSetObjValue(formObj.vndr_nm,  	"");
				//ComSetObjValue(formObj.vndr_abbr_nm,"");
				ComSetFocus(formObj.vndr_seq);
				break;
			case "port_loc":
				ComSetObjValue(formObj.loc_cd, 		"");
				ComSetObjValue(formObj.port_cd, 	"");
				ComSetObjValue(formObj.slan_cd, 	"");
				ComSetObjValue(formObj.del_cd, 		"");
				ComSetObjValue(formObj.str_estm_dt,	"");
				ComSetObjValue(formObj.end_estm_dt,	"");
				ComSetObjValue(formObj.vvd_cd,  	"");
				break;
		}
	}
	
    /**
	 * part of Pol Code input.<br>
	 * @param {arry} aryPopupData
	 */
    function setPortCd(aryPopupData){
    	form.port_cd.value=aryPopupData;
    }	
	/* end of developer job */
