/*=========================================================
 
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_LSE_0022.js
*@FileTitle  : Off-Hire Confirm from Lessor
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/18

=========================================================*/
/****************************************************************************************
    Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	 /**
	 * @extends
	 * @class EES_LSE_0022 : business script for EES_LSE_0022
	 */

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
				case "btn_retrieve":
					if(ComChkValid(formObj) == true) {
						//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
						doActionIBSheet(sheetObjects[0],document.form,IBBATCH);
					}
					break;
				case "btn_new":
					var sheetCount=sheetObjects[0].RowCount();
        			var editCount=0;
        			if (sheetCount > 0 ){
        				for (i=0 ; i <= sheetCount+1 ; i++){
        					if (sheetObject.GetRowStatus(i) == 'I' || sheetObject.GetRowStatus(i) == 'U' || sheetObject.GetRowStatus(i) == 'D'){
        						editCount ++;
        					}
        				}
        			}
        			if (editCount > 0 ){
        				ComShowCodeMessage("LSE01156");
        			}else {
        				ComResetAll();
        				ComHiddenResetAll();
        				setEnableSwitch("1");
        				sheetObject.MoveColumnPos("vvd_cd", 38);
        				for ( var k=0 ; k < comboObjects.length ; k++ ) {
        					setDefaultComboCheck(comboObjects[k]);
        				}
        				ComSetFocus(formObj.loc_cd);
        			}
					break;
				case "btn_save":
					doActionIBSheet(sheetObjects[0], formObj, IBSAVE);
					break;
				case "btn_DownExcel":
					if(sheetObject.RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
						}else{
							sheetObject.Down2Excel({ HiddenColumn:-1,Merge:true});
						}
					break;
				case "btns_search1":	//registering Form Location. 
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
				case "btns_search6":	//registering Form Port.
					if(formObj.loc_case.value != "1") {
						openPopup("6");
					}
 					break;
 				case "btns_search7":	//registering Form Lane 
 					if(formObj.loc_case.value != "1") {
						openPopup("7");
 					}
 					break;
 				case "btn_rulabel_cd":	//RU Label 조회 팝업
 					var loc_code="";
					var par_rulabel_type = form.hid_rulabel_type.value;
					var par_rstr_usg_lbl = ComToHtml2(form.rstr_usg_lbl.value);
					var param="?par_rulabel_type="+par_rulabel_type+"&par_rstr_usg_lbl="+par_rstr_usg_lbl;
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
		/* Focus Setting */
		setEnableSwitch("1");
		ComSetFocus(formObj.loc_cd);
    }
	/** registering initial event */
  	function initControl() {
  		var formObj=document.form;
  		axon_event.addListenerFormat('blur',		'obj_blur',		formObj); 
		axon_event.addListenerForm('focus',			'obj_focus',	formObj); 
		//axon_event.addListenerFormat('keypress',	'obj_keypress',	formObj); 
		axon_event.addListenerFormat('keyup',		'obj_keyup',	formObj); 
		axon_event.addListenerForm('keydown',		'obj_keydown',	formObj); 
		axon_event.addListenerForm('change',		'obj_change',	formObj); 
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

		if(obj.name == "del_cd" && formObj.del_cd.value == "") {
			formObj.del_cd.value = formObj.port_cd.value;
		}

		if( obj.readOnly ) {
			ComSetNextFocus(obj);
		} else {
		    //deleting data unit separator
		    ComClearSeparator(event.srcElement);
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
				/*setEnableSwitch(formObj.loc_case.value);
				if(formObj.loc_case.value == "2") {
					ComSetFocus(formObj.port_cd);
					sheetObj.MoveColumnPos("vvd_cd", "crnt_yd_cd");
				} else {
					ComSetFocus(formObj.loc_cd);
					sheetObj.MoveColumnPos("vvd_cd", 38);
				}*/
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
	        		doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC06);
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
	        	if(obj.name == "loc_cd") {
		            if(formObj.loc_cd.maxLength == 7) ComKeyOnlyAlphabet('uppernum');
		            else ComKeyOnlyAlphabet('upper');
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
  	 * handling event in case of Key-Up
  	 */
  	function obj_keyup() {
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
	 * handling event in case of Key-Down
	 */
   	function obj_keydown() {
   		var obj      = ComGetEvent();
   		var vKeyCode = event.keyCode;
   		var formObj  = document.form;
   		if ( vKeyCode == 13 ) {
   			switch(ComGetEvent("name")) {
   				case "loc_cd":
	  				if ( ComTrim(formObj.loc_cd.value) == "" )	doActionIBSheet(sheetObjects[0], formObj, IBBATCH);
					break;
   				case "port_cd":
	  				if ( ComTrim(formObj.port_cd.value) == "" )	doActionIBSheet(sheetObjects[0], formObj, IBBATCH);
					break;
   				case "slan_cd":
	  				if ( ComTrim(formObj.slan_cd.value) == "" )	doActionIBSheet(sheetObjects[0], formObj, IBBATCH);
					break;
   				case "del_cd":		//Delivery SCC
	  				if ( ComTrim(formObj.del_cd.value) == "" )	doActionIBSheet(sheetObjects[0], formObj, IBBATCH);
					break;
   				case "vvd_cd":		//VVD Code Search
	  				if ( ComTrim(formObj.vvd_cd.value) == "" )	doActionIBSheet(sheetObjects[0], formObj, IBBATCH);
					break;
				case "vndr_seq":
	  				if ( ComTrim(formObj.vndr_seq.value) == "" ) doActionIBSheet(sheetObjects[0], formObj, IBBATCH);
					break;
	  			case "agmt_seq":
	  				if ( ComTrim(formObj.agmt_seq.value) == "" ) doActionIBSheet(sheetObjects[0], formObj, IBBATCH);
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

	                var HeadTitle1="|Sel.|Seq.||Lessor|Lessor||AGMT No.|||Ref No.|Lease\nTerm|TP/SZ|CNTR No.|RU Label Type|RU Label Value|Current\nYard|Return\nYard|* Off-Hire  \nStatus|Off-Hire\nCFRM Date|* Off-Hire  \nYard|* Off-Hire  \nDue Date|Off-Hire\nReference No.|MT/Full|MVMT\nStatus|MVMT\nDate|On-hire\nYard"
	                + "|On-hire\nDate|Min On-hire\nDays|Used\nDays|Free\nDays|M&R Cost|BKG No.|B/L No.|POL|POD|DEL|R.Office|ETD-DT|ETA-DT|T.VVD|TRS S/O No.|TRS W/O No.|TRS Invoice No.|TRS S/P\nCode|TRS S/P\nName|||||||||||||Request\nUser ID|Confirm\nUser ID";
	                var headCount=ComCountHeadTitle(HeadTitle1);
	                //(headCount, 14, 0, true);
	
	                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                          {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"del_chk" },
	                          {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq_no" },
	                          {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"scc_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vndr_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"vndr_abbr_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vndr_lgl_eng_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"agmt_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"agmt_cty_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"agmt_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"ref_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"lstm_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rstr_usg_lbl_tp",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rstr_usg_lbl_desc",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"crnt_yd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"PopupEdit", Hidden:0, Width:75,   Align:"Center",  ColMerge:1,   SaveName:"mty_rtn_yd_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0,   EditLen:7 },
	                          {Type:"Combo",     Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"offh_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
	                          {Type:"Date",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"offh_cnfm_dt",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"PopupEdit", Hidden:0, Width:75,   Align:"Center",  ColMerge:1,   SaveName:"offh_yd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:7 },
	                          {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"offh_due_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"offh_ref_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 },
	                          {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"full_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"mvmt_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Date",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"cnmv_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"onh_yd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Date",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"onh_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Int",       Hidden:0,  Width:75,   Align:"Right",   ColMerge:1,   SaveName:"min_onh_dys",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"used_days",         KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"onh_free_dys",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"mnr_cost",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"del_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"evnt_ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Date",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"pol_etd_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Date",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"pod_eta_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vvd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"trs_so_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"trs_wo_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"trs_inv_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"trs_sp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"trs_sp_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"offh_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:1, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"rem_qty",           KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:1, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"cfm_qty",           KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:1, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"tot_qty",           KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:1, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"cntr_qty",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"complex_pk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"org_offh_cnfm_dt",  KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:1, Width:75,   Align:"Center",  ColMerge:1,   SaveName:"org_offh_yd_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"org_offh_due_dt",   KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:1, Width:75,   Align:"Center",  ColMerge:1,   SaveName:"org_rtn_yd_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:1, Width:75,   Align:"Center",  ColMerge:1,   SaveName:"lse_vndr_url",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:1, Width:75,   Align:"Center",  ColMerge:1,   SaveName:"org_offh_ref_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"snd_usr_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                          {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"cfm_usr_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	                 
	                InitColumns(cols);
	
	                SetEditable(1);
	                SetColProperty("offh_sts_cd", {ComboText:"Request|Confirm|Cancel", ComboCode:"R|C|D"} );
	                SetSelectionMode(0);
	                SetCountFormat("[SELECTDATAROW / TOTALROWS]");
	                //InitDataValid(0, "mty_rtn_yd_cd", vtEngUpOnly);
	                SetColProperty(0 ,"mty_rtn_yd_cd" , {AcceptKeys:"E|N",InputCaseSensitive:1});
	                SetColProperty(0 ,"offh_yd_cd" , {AcceptKeys:"E|N",InputCaseSensitive:1});
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
             		//only upper case, special characters - MVMT Status
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
						formObj.f_cmd.value=SEARCH;
						sheetObj.DoSearch("EES_LSE_0022GS.do",FormQueryString(formObj) );
					}
				}
				break;
			case IBBATCH:      //retrieving for BackEndJob
				if(validateForm(sheetObj, formObj, sAction)) {
					if(sheetObj.id == "sheet1") {
						formObj.f_cmd.value=COMMAND01;
						ComOpenWait(true);
						var sXml=sheetObj.GetSearchData("EES_LSE_0022GS.do", FormQueryString(formObj));
						var backendJobKey=ComGetEtcData(sXml, "BackEndJobKey");
						if (backendJobKey.length > 0) {
							ComSetObjValue(formObj.backendjob_key, backendJobKey);
							sheetObj.SetWaitTimeOut(10000);
							timer=setInterval(getBackEndJobStatus, 3000);
						}
						sheetObj.LoadSearchData(sXml,{Sync:1} );
					}
				}
				break;
			case IBSAVE:
				if(validateForm(sheetObj, formObj, sAction)) {
					if(sheetObj.id == "sheet1") {
						formObj.f_cmd.value=MULTI;
						sheetObj.DoSave("EES_LSE_0022GS.do", FormQueryString(formObj), -1, false);
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
 			case IBSEARCH_ASYNC02:	// retrieving for input Form Port
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
			case IBSEARCH_ASYNC03:	//retrieving for input Form VVD Code.
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
			case IBSEARCH_ASYNC06:	// retrieving for input Form Delivery SCC
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
			case IBSEARCH_ASYNC07:	// retrieving for input Form Lane
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
     * handling process for input validation
     * @param sheetObj
	 * @param Row
	 * @param Col
	 * @param Value
     */
    function sheet1_OnValidation(sheetObj, Row, Col, Value) {
    	with(sheetObj) {
			//checking manadtory input
    		if(GetCellValue(Row, "offh_sts_cd") == "C") {
    			if(GetCellValue(Row, "mty_rtn_yd_cd") == "") {
					ComShowCodeMessage("LSE01070");
					ValidateFail(true);
			        SelectCell(Row, "mty_rtn_yd_cd");
					return;
				}
    			if(GetCellValue(Row, "offh_yd_cd") == "") {
					ComShowCodeMessage("LSE01106");
					ValidateFail(true);
			        SelectCell(Row, "offh_yd_cd");
					return;
				}
    			if(GetCellValue(Row, "offh_due_dt") == "") {
					ComShowCodeMessage("LSE01107");
					ValidateFail(true);
			        SelectCell(Row, "offh_due_dt");
					return;
				}
			}
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
			//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			doActionIBSheet(sheetObjects[0],document.form,IBBATCH);
    	}
    }
	/**
     * calling event after retrieving Sheet
	 * @param sheetObj
	 * @param ErrMsg
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	with(sheetObj) {
    		SetColFontColor("snd_usr_id","#0000FF");
    		SetColFontColor("cfm_usr_id","#0000FF");
			for(var i=HeaderRows(); i <= LastRow(); i++) {
				if(GetCellValue(i, "lse_vndr_url") != "") {
					SetCellFontColor(i, "vndr_seq","#0000FF");
				}
				/* TRS Check 하는 로직을 더이상 사용하지 않도록 기능 변경
				if(GetCellValue(i, "trs_so_no") != "") {//TRS check
					//RowEditable(i) = false;
					SetCellEditable(i, "mty_rtn_yd_cd",0);
					SetCellEditable(i, "offh_sts_cd",0);
					SetCellEditable(i, "offh_yd_cd",0);
					SetCellEditable(i, "offh_due_dt",1);
					SetCellEditable(i, "offh_ref_no",0);
				} 
				*/ 
				if(GetCellValue(i, "offh_sts_cd") == "C") {//Confirm check
					SetCellEditable(i, "offh_yd_cd",1);
					SetCellEditable(i, "offh_due_dt",1);
					SetCellEditable(i, "offh_ref_no",1);
					SetCellValue(i, "org_offh_cnfm_dt",GetCellValue(i, "offh_cnfm_dt"),0);
					SetCellValue(i, "org_offh_yd_cd",GetCellValue(i, "offh_yd_cd"),0);
					SetCellValue(i, "org_offh_due_dt",GetCellValue(i, "offh_due_dt"),0);
					SetCellValue(i, "org_offh_ref_no",GetCellValue(i, "offh_ref_no"),0);
					SetRowStatus(i,"R");
				}
    		}
    	}
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
				case "offh_sts_cd":
					var vEditFlag=Value == "C";
					SetCellEditable(Row, "offh_yd_cd",vEditFlag);
					SetCellEditable(Row, "offh_due_dt",vEditFlag);
					SetCellEditable(Row, "offh_ref_no",vEditFlag);
					if(vEditFlag == true) {
						var vChkCount=0;
						var vMaxCount=GetCellValue(Row, "cntr_qty");
						var vComplexPk=GetCellValue(Row, "complex_pk");
						if(GetCellValue(Row, "tot_qty") - GetCellValue(Row, "rem_qty") > 0) {
							for(var i=HeaderRows(); i <= LastRow(); i++) {
								if(vComplexPk == GetCellValue(i, "complex_pk") && GetRowStatus(i) == "U") {
									if(GetCellValue(i, "offh_sts_cd") == "C" && GetCellValue(i, "offh_cnfm_dt") == "") {
										if(GetCellValue(i, "org_offh_cnfm_dt") == "") {
											vChkCount++;
										}
									} else if(/R|D/.test(GetCellValue(i, "offh_sts_cd"))) {
										vChkCount--;
								 	} else {
										vChkCount;
								 	}
								}
							}
							if(vChkCount > vMaxCount) {
								//ComShowCodeMessage("LSE01148", vMaxCount);
								if(ComShowConfirm(ComGetMsg("LSE01152")) == false) {
									SetCellValue(Row, "offh_sts_cd","R");
									return;									
								}
							}
						}
					}
					SetCellValue(Row, "offh_cnfm_dt",vEditFlag ? GetCellValue(Row, "org_offh_cnfm_dt") : "",0);
					SetCellValue(Row, "offh_yd_cd",vEditFlag ? GetCellValue(Row, "org_offh_yd_cd") : "",0);
					SetCellValue(Row, "offh_due_dt",vEditFlag ? GetCellValue(Row, "org_offh_due_dt") : "",0);
					SetCellValue(Row, "offh_ref_no",vEditFlag ? GetCellValue(Row, "org_offh_ref_no") : "",0);
					SetCellValue(Row, "mty_rtn_yd_cd",vEditFlag ? GetCellValue(Row, "crnt_yd_cd") : GetCellValue(Row, "org_rtn_yd_cd"),0);
					break;
				case "mty_rtn_yd_cd":		// Grid Yard Code Check
					if(GetCellValue(Row,Col) != "") {
					var param="f_cmd="+SEARCH+"&node_cd="+GetCellValue(Row,Col) + "&mode=yard";
 						sheetObj.SetWaitImageVisible(0);
 						var sXml=sheetObj.GetSearchData("COM_ENS_061GS.do",param);
						sheetObj.SetWaitImageVisible(1);
						if ( ComGetTotalRows(sXml) != 1 ) {
							SetCellValue(Row,"mty_rtn_yd_cd","",0);
							ComShowCodeMessage("LSE01048");
						}
					}
					break;
				case "offh_yd_cd":		// Off-Hire Yard Code Check
					if(GetCellValue(Row,Col) != "") {
						var param="f_cmd="+SEARCH18+"&yd_cd="+GetCellValue(Row,Col);
						sheetObj.SetWaitImageVisible(0);
						var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do",param);
						sheetObj.SetWaitImageVisible(1);
						if ( sXml != "" ) {
							if ( ComGetEtcData(sXml, "offh_yd_cd") != undefined ) {
								if ( ComGetEtcData(sXml, "offh_yd_cd") != "" ) {
									SetCellValue(Row,"offh_yd_cd",ComGetEtcData(sXml, "offh_yd_cd"),0);
								}else{
									SetCellValue(Row,"offh_yd_cd","",0);
									ComShowCodeMessage("LSE01048");
								}
							} else {
								var errMsg=LseComGetErrMsg(sXml);
								if ( errMsg != "" ) {
									ComShowMessage(errMsg);
								}
								SetCellValue(Row,"offh_yd_cd","",0);
								ComSetFocus(formObj.loc_cd);
							}
						}
					}
					break;
				case "offh_due_dt":		// Off-Hire Due Date Check
					if(GetCellValue(Row,Col) != "") {
						if(ComGetDaysBetween(formObj.h_curr_dt.value, GetCellText(Row,Col)) < 0) {
							ComShowCodeMessage("LSE01118");
							SetCellValue(Row,Col,CellSearchValue(Row, Col),0);
 							SelectCell(Row,Col);
						}
					}
					break;
				default :
					//do nothing
			}
		}
 	}
	/**
	 * calling event after MouseMove Sheet
	 */
	function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) {
		with(sheetObj) {
			Row=MouseRow();
			Col=MouseCol();
			if(Row >= HeaderRows()&& ColSaveName(Col) == "vndr_seq") {
				sText=GetCellText(Row,Col);
//no support[check again]CLT 				MouseToolTipText=GetCellText(Row,"vndr_lgl_eng_nm");
			} else {
//no support[check again]CLT 				MouseToolTipText="";
			}
			var linkFlag=GetCellValue(MouseRow(), MouseCol()) != "";
			SetDataLinkMouse("vndr_seq",GetCellValue(Row, "lse_vndr_url") != "");
			SetDataLinkMouse("snd_usr_id",linkFlag);
			SetDataLinkMouse("cfm_usr_id",linkFlag);
		}
	}
	/**
	 * sheet1_OnDblClick
	 */
	function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH) {
		var formObj=document.form;
		var sName=sheetObj.ColSaveName(Col);
		//if(sheetObj.GetMousePointer!= "Hand") return;
		with(sheetObj) {
			switch(sName) {
				case "vndr_seq":
					var sUrl=GetCellValue(Row, "lse_vndr_url");
					ComOpenWindow2(sUrl, "Agreement Lessor URL", "");
					break;
				case "snd_usr_id":
					//user Info
					ComUserPopup(GetCellValue(Row, Col));
					break;
				case "cfm_usr_id":
					ComUserPopup(GetCellValue(Row, Col));
					break;
			}
		}
	}
	/**
 	 * handling event when OnPopuphandling Sheet.<br>
 	 * @param sheetObj
 	 * @param Row
 	 * @param Col
 	 */
    function sheet1_OnPopupClick(sheetObj,Row,Col) {
 		with(sheetObj) {
			var sName=ColSaveName(Col);
			switch(sName) {
				case "offh_yd_cd":		//Yard Code No Pop-up
					openPopup("9", Row, Col);
					break;
				case "mty_rtn_yd_cd":	//Yard Code No Pop-up
					openPopup("8", Row, Col);
					break;
			}
 		}
    }
	/**
	 * handling event in case of OnCheckClick combo
	 * @return
	 */
	function combo1_OnCheckClick(comboObj, index, code) {
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
	 * combo1_OnKeyDown
	 * handling event when Key-Down combot.<br>
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
	 * @deprecated 2009.09.25 IBCombo Default setting is not used
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
     * @param type 1:Agreement(include Ver.) for FORM, 2:Lessor for FORM, 3:Currency for FORM
     * @param object
     * @param Row index
     */
    function openPopup(type, Row, Col) {
    	var formObj=document.form;
    	if ( type == "1" ) {
    		switch(formObj.loc_tp.value) {
    			case "0" :	//RCC
    				ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 755, 480,"rcc_cd:loc_cd", "1,0,1,1,1,1,1", true);
    				break;
    			case "1" :	//LCC
    				ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 755, 480,"lcc_cd:loc_cd", "1,0,1,1,1,1,1", true);
    				break;
    			case "2" :	//SCC
    				ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 755, 480,"scc_cd:loc_cd", "1,0,1,1,1,1,1", true);
    				break;
    			case "3" :	//Yard
					ComOpenPopup("/opuscntr/COM_ENS_061.do",755, 530, "setPopData_DeliveryLoc", "1,0,1,1,1,1,1,1", true);
    			default:	//do nothing
    		}
    	} else if ( type == "2" ) {
			ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 755, 480,"scc_cd:del_cd", "1,0,1,1,1,1,1", true);
    	} else if ( type == "3" ) {
    		ComOpenPopupWithTarget('/opuscntr/COM_ENS_0B2.do', 770, 520,"vvd:vvd_cd", "1,0,1,1,1,1,1,1", true);
    	} else if ( type == "4" ) {
    		ComOpenPopup('/opuscntr/EES_LSE_0091.do', 805, 480, 'setPopData_Agreement', '1,0', true);
    	} else if ( type == "5" ) {
    		ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 715, 550, 'setPopData_Lessor', '1,0,1,1,1,1,1,1', true);
    	} else if ( type == "6" ) {//Port
    		ComOpenPopupWithTarget('/opuscntr/VOP_VSK_0043.do', 430, 530,"loc_cd:port_cd", "0,0", true);
    	} else if ( type == "7") {//Lane 조회 팝업
			ComOpenPopupWithTarget('/opuscntr/COM_ENS_081.do', 1000, 400, "col1:slan_cd", '1,0,1,1,1,1,1,1', true);
    	} else if ( type == "8" ) {//Return Yard
    		ComOpenPopup("/opuscntr/COM_ENS_061.do", 755, 610, "setPopData_YardCode", "1,0,1,1,1,1,1,1", true, false, Row, Col, 0);
    	} else if ( type == "9" ) {//Off-Hire Yard
    		ComOpenPopup("/opuscntr/EES_LSE_0101.do", 800, 650, "setPopData_AvailYard", '1,0', true, false, Row, Col, 0);
    	}
    	return;
    }
	/**
     * handing process Agreement Pop-up Return Value <br>
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
			ComSetObjValue(formObj.vndr_seq, ComLtrim(aryPopupData[0][2],"0"));
			//ComSetObjValue(formObj.vndr_abbr_nm,  aryPopupData[0][5]);
			ComSetObjValue(formObj.vndr_nm,  aryPopupData[0][4]);
		}
	}
	/**
     * handing process Yard Code Pop-up Return Value <br>
     * @param Return value array
     * @param Row index
     * @param Col index
     * @param Sheet Array index
     */
     function setPopData_YardCode(aryPopupData, Row, Col, sheetIdx) {
     	if(aryPopupData.length > 0) {
			with(sheetObjects[sheetIdx]) {
				SetCellValue(Row, Col,aryPopupData[0][3],0);//Yard
			}
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
			with(sheetObjects[sheetIdx]) {
				//SetCellValue(Row, Col,aryPopupData[0][4],0);//Yard
				SetCellValue(Row, "offh_yd_cd",aryPopupData[0][4]);//Yard
			}
		}
     }
	/**
     * handing process DeliveryLoc(Yard) Pop-up Return Value <br>
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
	 * retrieving status 3 for BackEndJob result
	 */
	function getBackEndJobStatus() {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		formObj.f_cmd.value=COMMAND02;
		ComOpenWait(true);
		var sXml=sheetObj.GetSearchData("EES_LSE_0022GS.do", FormQueryString(formObj));
		var jobState=ComGetEtcData(sXml, "jb_sts_flg");
		//2 => 3 => 5 Finish
		if (jobState == "3") {
			getBackEndJobLoadFile();
			clearInterval(timer);
		} else if (jobState == "4") {
			//ComShowCodeMessage("LSE01124");
			ComOpenWait(false);
			clearInterval(timer);
		} else if (jobState == "5") {
			//ComShowCodeMessage("LSE01125");
			//clearInterval(timer);
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
		ComOpenWait(false);
		var sXml=sheetObj.GetSearchData("EES_LSE_0022GS.do", FormQueryString(form));
		sheetObj.LoadSearchData(sXml,{Sync:0} );
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
    	with(sheetObj) {
    		switch(sAction) {
	    		case IBSAVE:
	    			return true;
	    			break;
	    		default : 	//do nothing
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
		//excluding from in case of 'Division is Location'
		if(formObj.loc_case.value == "1") return true;
    	//not mandator item
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
			
			
			/*ComEnableObject(formObj.btns_search1,  true);
			ComEnableObject(formObj.btns_search2,  true);
			ComEnableObject(formObj.btns_search3,  true);
			ComEnableObject(formObj.btns_search6,  true);
			ComEnableObject(formObj.btns_search7,  true);
			ComEnableObject(formObj.btns_calendar, true);
			ComEnableObject(formObj.loc_cd, 	   true);
			ComEnableObject(formObj.port_cd, 	   true);
			ComEnableObject(formObj.slan_cd, 	   true);
			ComEnableObject(formObj.del_cd, 	   true);
			ComEnableObject(formObj.vvd_cd, 	   true);
			ComEnableObject(formObj.str_estm_dt,   true);
			ComEnableObject(formObj.end_estm_dt,   true);
			formObj.loc_cd.className="input1";
			formObj.port_cd.className="input1";*/
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
			
			if(value != "1" && value != "0") {//loc_case is Port
				var vCurrDate=formObj.h_curr_dt.value;
				formObj.str_estm_dt.value=vCurrDate;
				formObj.end_estm_dt.value=ComGetDateAdd(vCurrDate, "D", 7);
			}			
			
			/*ComEnableObject(formObj.btns_search1,  value == "1");
			ComEnableObject(formObj.btns_search2,  value != "1");
			ComEnableObject(formObj.btns_search3,  value != "1");
			ComEnableObject(formObj.btns_search6,  value != "1");
			ComEnableObject(formObj.btns_search7,  value != "1");
			ComEnableObject(formObj.btns_calendar, value != "1");
			ComEnableObject(formObj.loc_cd, 	   value == "1");
			ComEnableObject(formObj.port_cd, 	   value != "1");
			ComEnableObject(formObj.slan_cd, 	   value != "1");
			ComEnableObject(formObj.del_cd, 	   value != "1");
			ComEnableObject(formObj.vvd_cd, 	   value != "1");
			ComEnableObject(formObj.str_estm_dt,   value != "1");
			ComEnableObject(formObj.end_estm_dt,   value != "1");
			if(value == "1") {
				formObj.loc_cd.className="input1";
			} else {
				formObj.port_cd.className="input1";
			}*/
		}
		/*if(value != "1") {//loc_case is Port
			var vCurrDate=formObj.h_curr_dt.value;
			formObj.str_estm_dt.value=vCurrDate;
			formObj.end_estm_dt.value=ComGetDateAdd(vCurrDate, "D", 7);
		}*/
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
	/* end of developer job */
