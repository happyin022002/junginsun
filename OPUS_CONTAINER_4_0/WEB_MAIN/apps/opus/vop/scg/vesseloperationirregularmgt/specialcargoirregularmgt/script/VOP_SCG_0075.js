/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_SCG_0075.js
*@FileTitle : SPCL CGO Irregular Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/


   /**
     * @fileoverview commonly used javascript file, calendar related functions are defined.
     */

    /**
     * @extends 
     * @class vop_scg_0075 : business script for vop_scg_0075
     */
    function vop_scg_0075() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	
    
    /*****************************************************************************************
     * common global variable start *
     ****************************************************************************************/  
    
    // common global variable
    var sheetObjects = new Array();
    var sheetCnt = 0;
    var prefixs = new Array("sheet1_","sheet2_");  
    
    var uploadObjects = new Array();
	var uploadCnt = 0;
	
	var comboObjects = new Array();
	var comboCnt = 0;
    
    //VVD CD related items
    var strVVDOptions = "vsl_cd|skd_voy_no|skd_dir_cd|vsl_eng_nm|vsl_slan_cd|vsl_slan_nm|vsl_opr_tp_cd|vsl_opr_tp_nm";
    //BKG No. related items
    var strBKGOptions = "bkg_no|bl_no|por_cd|pol_cd|pod_cd|del_cd|s_cust_nm|f_cust_nm|c_cust_nm|dcgo_flg|rc_flg|awk_cgo_flg|bb_cgo_flg|set_bkg_no|set_bl_no";   
    
    /*****************************************************************************************
     * common global variable end *
     ****************************************************************************************/  

//////////////////////////////////////////////////////////////////////////////////////////////
//
// ▩Step-By-Step▩
//--------------------------------------------------------------------------------------------
//    
// 
 // ►0. screen loading
//  .desc  : Option as basic, Dangerous Goods.
//  .step1 : Select Option and perform basic steps.
//  .step2 : file upload related Sheet, initialize Upload Component.  
//  .step3 : Place initial focus in VVD.
//  .goto  : [#0-0]
// 
// 
// 
//►1. Setting using VVD Key In or popup
//  .desc  : Fill VVD, Lane, Vessel Operator.
//  .see   : Perform ►3.
//  .goto  : [#1-1][#1-2][#1-3]
//
//
//
//►2. Setting using Irregular Occurred Key In or popup
// .desc  : Fill Irregular Occurred Date.
// .see   : Perform ►3.
// .goto  : [#3-1]
// 
// 
// 
//►3. Setting using Cargo Operator Key In or popup
//  .desc  : Change to input Key In in Booking information in case if other shipping company.
//  .step1 : change related Container information to delete status and set parameter in case changing Cargo Operator.
//  .step2 : Initialize Booking information.
//  .step3 : Change Container information(Sheet)'s CNTR No. TP/SZ column type to Combo/Text Box according to Cargo Operator type.
//  .event : Focus-Out, Pop-Up CallBack
//  .goto  : [#3-1][#3-2]
// 
// 
// 
//►4. Selecting Option
//  .desc  : Container input item changes according to option.
//  .req   : Cargo Operator should be input.   
//  .step1 : change related Container information to delete status and set parameter in case changing option.
//  .step2 : Fill Irregulars Type Combo Box according to option.
//  .step3 : Select Sheet type and initialize.
//  .step4 : Initialize Booking information.
//  .step5 : Change Container information(Sheet)'s CNTR No. TP/SZ column type to Combo/Text Box according to Cargo Operator type.
//  .event : Select Radio
//  .goto  : [#4-1]
// 
// 
// 
//►5. BKG No. or B/L No. Key In
//  .desc  : Set Booking and related information and fill Container Combo Box.
//  .step1 : Set Booking and related information.
//  .step2 : Fill Sheet's Container Combo Box.
//  .event : Key-In
//  .goto  : [#5-1][#5-2]
// 
// 
// 
//►9. Retrieve
//  .desc  : Maintain existing status or change to modify status according to retrieve result.
//           retrieve participating item : (compulsory)VVD CD, Irregular Occurred, Cargo Operator (optional) BKG No.  --> according to this, retrieve by max value
//  .step1 : Check wheter retrieved Irregular Sequence exists or not. Below steps are handling retrieve success status.
//  .step2 : Initialize screen.
//  .step3 : Set retrieved Irregular general information.
//  .step4 : Set retrieved VVD general information.
//  .step5 : Select Option and perform basic steps.
//  .step6 : Set Irregular general information again.
//  .step7 : Set retrieved Booking general information.
//  .step8 : Fill Container information in Sheet.
//  .goto  : [#9-9]
//
//////////////////////////////////////////////////////////////////////////////////////////////    

	/*****************************************************************************************
	 * Handling event start *
	 ****************************************************************************************/    
    
    // business javascript OnKeyPress event Catch
    function initControl() {
        // Axon event handling1. event catch
        axon_event.addListenerFormat ('keypress', 'obj_keypress',   form);
        axon_event.addListenerFormat ('focus',    'obj_activate',   form);
        axon_event.addListenerFormat ('blur', 	  'obj_deactivate', form);
        axon_event.addListenerForm 	 ('focusout', 'obj_focusout',   form);
        axon_event.addListenerForm   ("keyup",    'obj_keyup',      form);
    }
    
    // Event handler processing by button click event */
    document.onclick = processButtonClick;
    
    // Handling business javascript OnFocusOut event
    function obj_focusout() {
    	switch(event.srcElement.name){ 
	    	case "skd_dir_cd":
	        	//[#1-1]VVD info retrieve
	        	searchVVDInfo();
	        	//[#1-3]Initialize according to Cargo Operator
	        	resetBKGCntrInfo(false, false); 

	        	break;
	    	case "irr_occr_dt":
	        	//[#3-1]Initialize according to Cargo Operator
	        	resetBKGCntrInfo(false, false); 	
	        	
	        	//changed Irregular Occurred Date setting
 				setObjValue("set_irr_occr_dt", getObjValue("irr_occr_dt"));
 				
 				//move focus
 				setFocus("cgo_opr_cd");
	        	break;
	        case "bkg_no":
	        	//[#5-1]Booking info retrieve
	        	searchBKGInfo(0);
	        	break; 
	        case "bl_no":
	        	//[#5-2]Booking info retrieve
	        	searchBKGInfo(2);
	        	break;	   
	        case "cgo_opr_cd":
	        	//[#3-1]Initialize according to Cargo Operator
	        	resetBKGCntrInfo(false, true); 	   			
	        	break;	  
    	}
    } 

    // Handling business javascript OnKeyUp event
    function obj_keypress() {
    	switch(event.srcElement.dataformat){
    	    case "engup":
    	    	switch(event.srcElement.name){
	    	    	case "vsl_cd":	
	    	        	//input english upper
	    	    		ComKeyOnlyAlphabet('uppernum');
	    	        	break;
	    	        case "skd_voy_no":	
	    	        	//숫자입력하기
	        	    	ComKeyOnlyNumber(event.srcElement);
	    	        	break;
	    	        case "skd_dir_cd":	
	    	        	//input english upper
	    	        	ComKeyOnlyAlphabet('upper');
	    	        	break;
	    	        case "vsl_opr_tp_cd":	
	    	        	//input english upper
	    	        	ComKeyOnlyAlphabet('upper');
	    	        	break;
	    	        case "cgo_opr_cd":	
	    	        	//input english upper	    	        	
	    	        	ComKeyOnlyAlphabet('uppernum');
	    	        	break;
	    	        case "bkg_no":	
	    	        	//input english upper
	    	        	ComKeyOnlyAlphabet('uppernum');
	    	        	break;
	    	        case "bl_no":	
	    	        	//input english upper
	    	        	ComKeyOnlyAlphabet('uppernum');
	    	        	break;
    	    	}
    	    	break;
    	    default:
    	    	//common code : only English, number
    	    	ComKeyOnlyAlphabet("num");
    	    	break;     
    	}
    }  
    
    // Handling business javascript OnFocus event
    function obj_activate() {
    	// deleting mask separator
    	ComClearSeparator (event.srcElement);
    }

    // Handling business javascript OnBlur event
    function obj_deactivate() {
    	// add mask separator
    	ComAddSeparator (event.srcElement);    
    	// 하나의 컨트롤의 Validation을 확인
    	ComChkObjValid(event.srcElement);
    }
    
    // Handling business javascript OnKeyUp event
    function obj_keyup() {
    	obj_nextfocus(event.srcElement);
    }  
    
    // move focus - recieved parameter HTML tag(Object)'s next HTML tag(Object)
    function obj_nextfocus(obj) {
    	var objMaxLength = obj.getAttribute("maxlength");
    	var objValue = obj.getAttribute("value");
    	
    	if (ComChkLen(objValue, objMaxLength) == 2) {
    		ComSetNextFocus(obj);
    	}
    }
    
    // Event handler processing by button name */
    function processButtonClick(){
        var sheetObj = sheetObjects[0];
         
        /*******************************************************/
        var formObj = document.form;

    	try {
    		var eventObj = window.event.srcElement;
    		var srcName  = eventObj.getAttribute("name");
    		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
	            case "btn_Retrieve":
	            	doActionIBSheet(sheetObj,formObj,IBSEARCH,'SELF');
	            	break;
				case "btn_New":
					doActionIBSheet(sheetObj,formObj,IBCLEAR,'SELF');
					break;					
				case "btn_Close":
					window.close();
					break;
				case "btn_VVDpop":
					//VVD select popup open					
					var vsl_cd = getObjValue("vsl_cd");
                	var sUrl = "";
                	
                	if(vsl_cd == ""){
                		sUrl = "/opuscntr/VOP_VSK_0219.do?op=0219";
                		ComOpenPopup(sUrl, 465, 485, "setCallBackVSL", "0,0", true);
                	}else{
                		sUrl = "/opuscntr/VOP_VSK_0230.do?op=0230&ctrl_cd=NORL&vsl_cd="+vsl_cd;
                		ComOpenPopup(sUrl, 335, 385, "setCallBackVVD", "0,0", true);
                	}
					break;
				case "btn_calendar": 
					//calendar
					var cal = new ComCalendar();
		            cal.select(formObj.irr_occr_dt, "yyyy-MM-dd"); 
   	                break;	
				case "btn_carrier":
					//Cargo Operator popup open
					ComOpenPopup('/opuscntr/COM_ENS_0N1.do?crr_cd='+ComGetObjValue(document.form.cgo_opr_cd), 423, 420, "setCallBackCP", '0,0,1,1,1', true);	
					break;				
				case "spcl_cgo_cate_cd":					
					//[#4-1]Option select
					setSelectedOption(eventObj.value);
					break;
				case "btn_etc":
					setDelCNTRToForm(sheetObj, false);
					break;
				case "btn_file":
					//Supporting Documents or Pictures popup open
					formObj.f_cmd.value = "";
					ComOpenPopup('/opuscntr/VOP_SCG_2013_01.do?'+FormQueryString(formObj), 605, 270, "setFileUpload", 'none', false);	
					break;
					
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }
    
    /*****************************************************************************************
     * Handling event end *
     ****************************************************************************************/  
    
    /*****************************************************************************************
     * Sheet event start *
     ****************************************************************************************/ 
    
    /**
     * Handling Sheet1 Combo Change Event
     * param : sheetObj ==> sheet object, changed Row ==> Row, changed Col ==> Col
     * 
     */
    function sheet1_OnChange(sheetObj, Row, Col, Value)  {
    	//Container Combo OnChange
    	if(Col == sheetObj.SaveNameCol(prefixs[0]+"cntr_no")) {
    		//Combo Box retrieve
			var idx = sheetObj.GetComboInfo(Row,Col, "SelectedIndex");
			
			Value = sheetObj.CellText(Row,prefixs[0]+"cntr_no");
			if(idx != -1) {
				if(idx != 0) {
		    		//Container No setting
		    		setObjValue("set_cntr_no", Value);
		    		//Container info retrieve
		    		searchCNTRInfo(sheetObj, Row, Col, Value);
				} else {
					sheetObj.CellValue2(Row, prefixs[0]+"cntr_no") = beforeComboCntrNo;
					
					setFilterCNTRCombo(sheetObj, Row, Col);
				}				
			}
    	} else if(sheetObj.ColSaveName(Col) == prefixs[0]+"imdg_clss_cd") {
    		var selVal = sheetObj.CellValue(Row, Col);
    		if (selVal == "1" || selVal == "1.1" || selVal == "1.2" || selVal == "1.3" || selVal == "1.4" || selVal == "1.5" || selVal == "1.6" ){
    			sheetObj.CellEditable(Row, prefixs[0]+"imdg_comp_grp_cd") = true;
    			sheetObj.CellValue2(Row, prefixs[0]+"imdg_comp_grp_cd") = "A";
    		} else {
    			sheetObj.CellEditable(Row, prefixs[0]+"imdg_comp_grp_cd") = false;
    			sheetObj.CellValue2(Row, prefixs[0]+"imdg_comp_grp_cd") = "";
    		}
    	}
	}
    
    /**
     * Handling Sheet1 Popup Click Event
     * param : sheetObj ==> sheet object, selected Row ==> Row, selected Col ==> Col
     * 
     */
    function sheet1_OnPopupClick(sheetObj, Row, Col) {
		with(sheetObj) { 
			var imdgUnNo = sheetObj.CellValue(Row, prefixs[0]+"imdg_un_no");
			var imdgUnNoSeq = sheetObj.CellValue(Row, prefixs[0]+"imdg_un_no_seq");
			var vsl_slan_cd = getObjValue("vsl_slan_cd"); 
			ComOpenPopup("/opuscntr/VOP_SCG_3005.do?imdg_un_no="+imdgUnNo+"&imdg_un_no_seq="+imdgUnNoSeq+"&lane_cd="+vsl_slan_cd, 940, 400, "setCallBackUNNo", "0,0,1,1,1,1,1,1", false,false, Row, Col, 0);
 		}
 	}
    
    /**
     * Handling Sheet1 Cell Select Event
     * param : sheetObj ==> sheet object, OldRow ==> before selecting Row, OldCol ==> before selecting Col, selected Row ==> NewRow, selected Col ==> NewCol
     * 
     */
    var beforeComboCntrNo;
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
    	if(sheetObj.ColSaveName(OldCol) == prefixs[0]+"imdg_un_no_seq" 
    	&& sheetObj.CellValue(OldRow, OldCol-1) != ""
    	&& sheetObj.CellValue(OldRow, OldCol) != ""
    	&& !isOWNSEN()) {
    		searchUNNoInfo(sheetObj, OldRow, OldCol);
    	} else if(sheetObj.ColSaveName(NewCol) == prefixs[0]+"cntr_no" && isOWNSEN()) {
    		//Combo Filtering
    		setFilterCNTRCombo(sheetObj, NewRow, NewCol);
    	}
	}
    
    /**
     * Handling Sheet1 OnAfterEdit Event
     * param : sheetObj ==> sheet object, changed Row ==> Row, changed Col ==> Col
     * 
     */
    function sheet1_OnAfterEdit(sheetObj, Row, Col)  {
    	if(sheetObj.ColSaveName(Col) == prefixs[0]+"cell_psn_no") {
    		var cellPsnNo = sheetObj.CellText(Row, prefixs[0]+"cell_psn_no");
    		if(cellPsnNo == "") {
    			var stanCntrNo = sheetObj.CellText(Row, prefixs[0]+"cntr_no");
    			var rowCntrNo;
    			for(var rowIdx=Row; rowIdx<=sheetObj.LastRow; rowIdx++) {
    				rowCntrNo = sheetObj.CellText(rowIdx, prefixs[0]+"cntr_no");
    				if(stanCntrNo == rowCntrNo) sheetObj.CellValue(rowIdx, prefixs[0]+"cell_psn_no") = "0";
    			}
    		}
    	}
    }
    
    /*****************************************************************************************
     * Sheet event end *
     ****************************************************************************************/ 
    
    /*****************************************************************************************
     * screen initializing start *
     ****************************************************************************************/  

    /**
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items
     * defining list on the top of source
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }
    
    /**
     * register IBUpload Object created in page as uploadObjects list. <br>
     * @param {ibupload} uploadObj    IBUpload Object
     **/
	function setUploadObject(uploadObj) {
		uploadObjects[uploadCnt++] = uploadObj;
	}
	
	/**
     * register IBCombo Object created in page as comboObjects list
     * @param {IBMultiCombo} combo_obj    IBMultiCombo Object  
     **/
    function setComboObject(combo_obj){
       comboObjects[comboCnt++] = combo_obj;
    }

    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage(preCondition) {
    	//Initializing Combo
    	for(var k=0; k<comboObjects.length; k++){
        	initCombo(comboObjects[k], k + 1);
        }
    	
    	//[#0-0]initializing sheet
    	setSelectedOption('init');
    	
    	//Upload initializing sheet
    	initUpload();
        
        //register event listner
        initControl();
        
        //initial condition setting
        for(var condIdx=0; condIdx<4; condIdx++) {
        	setObjValue(preCondition[condIdx][0],preCondition[condIdx][1]);
        	if(condIdx<3) setObjValue("set_"+preCondition[condIdx][0],preCondition[condIdx][1]);
        }
        
        //retrieve
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,"POP");
    }
    
    /**
     * Initialize according to Option
     */
    function setSelectedOption(selVal) { 
    	
    	var cgo_opr_cd = getObjValue("cgo_opr_cd");
    	if (selVal==null || selVal==undefined) 
    		selVal = getObjValue("spcl_cgo_cate_cd");    	
    	
    	if(selVal == 'init' || cgo_opr_cd != '') {
	    	var sheetObj = sheetObjects[0];
	    	var formObj = document.form;
	    	
	    	//Select Dangerous Goods as basic option when loading screen.
	    	if(selVal == 'init') selVal = "DG";
	    	
	    	//Setting select Option --> decide Sheet header type 
	    	setObjValue("set_spcl_cgo_cate_cd", selVal);
	    	
	    	//0. Change container info to delete status and set as parameter when changing option.
			setDelCNTRToForm(sheetObj, true);
	    	
	    	//1. Retrieve Irregulars Type according to option.    	
	    	doActionIBCombo(sheetObj,formObj,IBSEARCH_ASYNC01);
	    	
	    	//2. Sheet type select and initialize.
	    	//setSheet(sheetObj, selVal=='DG'?1:2);
	    	
	    	sheetObj = sheetObj.Reset();
	    	sheetObjects[0] = sheetObj; 
	    	ComConfigSheet(sheetObj);
	    	initSheet(sheetObj,selVal=='DG'?1:2);    
	    	ComEndConfigSheet(sheetObj);
	    	
	    	
	    	//3. Initialize according to change of Cargo Operator --> Sheet column type decision and fill
			resetBKGCntrInfo(true, false);	    	
	    	
    	} else {
    		if(selVal == 'AC') selVal = "DG";
    		else if(selVal == 'DG') selVal = "AC";
	    	
    		ComShowCodeMessage('SCG50007', 'Cargo Operator Code');	//'Please input {?msg1}.'	
    		
    		setObjValue("spcl_cgo_cate_cd", selVal);
    		setFocus("cgo_opr_cd");    		
    	}
    }
    
    /**
     * initializing sheet
     */
    function setSheet(sheetObj, sheetNo) { 
    	sheetObj.Reset();

    	ComConfigSheet(sheetObj);
    	initSheet(sheetObj,sheetNo);    
    	ComEndConfigSheet(sheetObj);
    }
    
    /**
     * Initializing Combo
     * setting Combo items
     */
    function initCombo(comboObj) {
	    switch(comboObj.id) {
	        case "spcl_cgo_irr_tp_cd":
	            with(comboObj) {
	            	SetTitle("Name|Code|Description");
	            	SetColWidth("100|50|200")
	            	DropHeight = 230;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	UseAutoComplete = true;
	            }
	            break;	   
	    }
	}
    
    /**
     * Upload initializing sheet
     */
    function initUpload() { 
    	//Hidden Initializing Sheet
    	//setSheet(sheetObjects[1], 3);
    	
    	sheetObj = sheetObj.Reset();
    	sheetObjects[1] = sheetObj; 
    	ComConfigSheet(sheetObj);
    	initSheet(sheetObj,3);    
    	ComEndConfigSheet(sheetObj);

        for(var i=0;i<uploadObjects.length;i++){
		    ComConfigUpload(uploadObjects[i], "/opuscntr/VOP_SCG_0013GS.do");
		}
    }
    
    /**
     * Initializing value while maintaining screen setting
     */
    function initUI() { 
    	//1. initialize screen
 	   	resetObjs();	 	
 	   	
 	    //2. Upload initializing sheet
    	initUpload();	
    	
    	//3. initialize Sheet
    	sheetObjects[1].removeAll();
    	
    	//set focus
        setFocus("vsl_cd");
    }

    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
        sheetObj.WaitImageVisible = false;
        switch(sheetNo) {
            case 1:      // sheet1 init : Dangerous Goods
               with (sheetObj) {
                    // setting height
                    style.height = 340;
                    //setting width
                    SheetWidth = mainTable.clientWidth;

                    //setting Host information[compulsory][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //Merge kind [optional, Default msNone]
                    MergeSheet = msPrevColumnMerge + msHeaderOnly;

                    //Edit kind [optional, Default false]
                    Editable = false;

                    //setting Row information[compulsory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 15, 100);

                    // setting function handling header
                    InitHeadMode(true, true, false, true, false,false);

                    var HeadTitle1 = "CNTR No.|TP/SZ|Cell Position|Sel|Seq.|UN No./Seq.|UN No./Seq.|Class|Class|Proper Shipping Name||";
                    
                    var headCount = ComCountHeadTitle(HeadTitle1);
                    
                    //setting Column information[compulsory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    //header row info[compulsory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //data property    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtData,			95,		daCenter,	true,	prefixs[0]+"cntr_no",			false,           "",      dfNone, 			0,     true,       true,	14);
					InitDataProperty(0, cnt++ , dtCombo,		55,		daCenter,	true,	prefixs[0]+"cntr_tpsz_cd",		false,           "",      dfNone, 			0,     true,       true,	4);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	prefixs[0]+"cell_psn_no",		false,           "",      dfNone, 			0,     true,       true,	6);
					
					InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	false,	prefixs[0]+"del_chk");
					InitDataProperty(0, cnt++ , dtData,			35,		daCenter,	false,	prefixs[0]+"cgo_seq",			false,           "",      dfNone, 			0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,			75,		daCenter,	false,	prefixs[0]+"imdg_un_no",		false,           "",      dfNone, 			0,     true,       true,	4, true);
					InitDataProperty(0, cnt++ , dtPopupEdit,	55,		daCenter,	false,	prefixs[0]+"imdg_un_no_seq",	false,           "",      dfNone, 			0,     true,       true,	4);
					InitDataProperty(0, cnt++ , dtCombo,		65,		daCenter,	false,	prefixs[0]+"imdg_clss_cd",		false,           "",      dfNone, 			0,     true,       true,	3);
					InitDataProperty(0, cnt++ , dtCombo,		45,		daCenter,	false,	prefixs[0]+"imdg_comp_grp_cd",  false,           "",      dfNone, 			0,     false,      false);
					
					InitDataProperty(0, cnt++ , dtData,			400,	daLeft,		false,	prefixs[0]+"prp_shp_nm",		false,           "",      dfNone, 			0,     true,       true,	500);
					
					InitDataProperty(0, cnt++ , dtHidden,	    0,		daCenter,	false,	prefixs[0]+"spcl_cgo_irr_cntr_seq");
					InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	false,	prefixs[0]+"ibflag");
					
					InitDataValid(0, prefixs[0]+"cell_psn_no", vtNumericOther, "");
					
					ShowButtonImage = 1;

               }
               break;

            case 2:      // sheet2 init : Awkward Cargo
                with (sheetObj) {

                	// setting height
                    style.height = 340;
                    //setting width
                    SheetWidth = mainTable.clientWidth;

                    //setting Host information[compulsory][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //Merge kind [optional, Default msNone]
                    MergeSheet = msPrevColumnMerge + msHeaderOnly;

                    //Edit kind [optional, Default false]
                    Editable = false;

                    //setting Row information[compulsory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 15, 100);

                    // setting function handling header
                    InitHeadMode(true, true, false, true, false,false);

                    var HeadTitle1 = "CNTR No.|TP/SZ|AWK Type|Cell Position||Sel|Seq.|Weight(kg)|Weight(kg)|Dimension(cm)|Dimension(cm)|Dimension(cm)|Commodity||";
                    var HeadTitle2 = "CNTR No.|TP/SZ|AWK Type|Cell Position||Sel|Seq.|Gross|Net|L|W|H|Commodity||";
                    
                    var headCount = ComCountHeadTitle(HeadTitle1);
                    
                    //setting Column information[compulsory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
                    
                    //header row info[compulsory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //data property    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtData,					95,		daCenter,	true,		prefixs[0]+"cntr_no",			false,           "",      dfNone, 			0,     true,       true,	14);
					InitDataProperty(0, cnt++ , dtCombo,				55,		daCenter,	true,		prefixs[0]+"cntr_tpsz_cd",		false,           "",      dfNone, 			0,     true,       true,	4);
					InitDataProperty(0, cnt++ , dtCombo,				70,		daCenter,	true,		prefixs[0]+"spcl_cgo_cate_cd",  false,           "",      dfNone, 			0,     true,       true,	2);
					InitDataProperty(0, cnt++ , dtData,					100,	daCenter,	true,		prefixs[0]+"cell_psn_no",		false,           "",      dfNone, 			0,     true,       true,	6);
					
					InitDataProperty(0, cnt++ , dtHidden,				0,		daCenter,	false,		prefixs[0]+"seq",               false,           prefixs[0]+"cgo_seq");
					InitDataProperty(0, cnt++ , dtHidden,				30,		daCenter,	true,		prefixs[0]+"del_chk");
					InitDataProperty(0, cnt++ , dtData,					35,		daCenter,	true,		prefixs[0]+"cgo_seq",			false,           "",      dfNone, 			0,     true,       true);

					InitDataProperty(0, cnt++ , dtData,					70,		daRight,	true,		prefixs[0]+"awk_cgo_grs_wgt",	false,           "",      dfFloat, 			3,     true,       true,	18);
					InitDataProperty(0, cnt++ , dtData,					70,		daRight,	true,		prefixs[0]+"awk_cgo_net_wgt",	false,           "",      dfFloat, 			3,     true,       true,	18);
					
					InitDataProperty(0, cnt++ , dtData,					70,		daRight,	true,		prefixs[0]+"dim_len",			false,           "",      dfFloat, 			2,     true,       true,	7);
					InitDataProperty(0, cnt++ , dtData,					70,		daRight,	true,		prefixs[0]+"dim_wdt",			false,           "",      dfFloat, 			2,     true,       true,	7);					
					InitDataProperty(0, cnt++ , dtData,					70,		daCenter,	true,		prefixs[0]+"dim_hgt",			false,           "",      dfFloat, 			3,     true,       true,	8);
					
					InitDataProperty(0, cnt++ , dtData,					200,	daLeft,		true,		prefixs[0]+"cmdt_desc",		    false,           "",      dfNone, 			0,     true,       true,	4000);
										
					InitDataProperty(0, cnt++ , dtHidden,	    		10,		daCenter,	false,		prefixs[0]+"spcl_cgo_irr_cntr_seq");
					InitDataProperty(0, cnt++ , dtHiddenStatus,			30,		daCenter,	false,		prefixs[0]+"ibflag");
					
					InitDataValid(0, prefixs[0]+"cell_psn_no", vtNumericOther, "");
					
					InitDataCombo(0, prefixs[0]+"spcl_cgo_cate_cd", " |AW|RF|BB", " |AW|RF|BB");
					
               }
               break;
            case 3:      // sheet3 init
                with (sheetObj) {
                    // setting height
                    style.height = 0;
                    // setting width
                    SheetWidth = mainTable.clientWidth;

                    //setting Host information[compulsory][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //setting Row information[compulsory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 6, 100);

                    //setting Column information[compulsory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(8, 0, 0, true);

                    var HeadTitle = "|Seq.||File Name||ID|Date|";

                    //header row info[compulsory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);


                    //data property    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtData,	        30,		daCenter,	false,	prefixs[1]+"ibflag");
					InitDataProperty(0, cnt++ , dtSeq,			35,		daCenter,	false,	prefixs[1]+"No");
					InitDataProperty(0, cnt++ , dtHidden,       0,      daCenter,   false,  prefixs[1]+"file_set_yn",	false,  "",     dfNone,         0,     		true,    	true);
					InitDataProperty(0, cnt++ , dtData,			245,	daCenter,	false,	prefixs[1]+"file_nm",		false,	"",		dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,	    daCenter,	false,	prefixs[1]+"file_path_desc",false,	"",		dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	false,	prefixs[1]+"cre_usr_id",	false,	"",		dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	false,	prefixs[1]+"cre_dt",		false,	"",		dfDateYmd,		0,			true,		true);

					InitDataProperty(0, cnt++ , dtHidden,	    30,		daCenter,	false,	prefixs[1]+"spcl_cgo_irr_file_seq");
			   }
			   break;

        }
    }
    
    /*****************************************************************************************
     * screen initializing end *
     ****************************************************************************************/ 
    
    /*****************************************************************************************
     * initializing start *
     ****************************************************************************************/ 
    
    /**
     * Initialize according to change ofCargo Operator : Booking info Key In in case of other company
     */
    function resetBKGCntrInfo(forceYn, keyInYn) {
    	var sheetObj = sheetObjects[0];
    	var formObj  = document.form;
    	
    	var set_cgo_opr_cd = getObjValue("set_cgo_opr_cd");   
    	var cgo_opr_cd 	   = getObjValue("cgo_opr_cd");    
    	
    	var set_vvd_cd = getObjValue("set_vsl_cd")+getObjValue("set_skd_voy_no")+getObjValue("set_skd_dir_cd");   
    	var vvd_cd = getObjValue("vsl_cd")+getObjValue("skd_voy_no")+getObjValue("skd_dir_cd");   
    	
    	var set_irr_occr_dt = ComReplaceStr(getObjValue("set_irr_occr_dt"),"-","");   
    	var irr_occr_dt = ComReplaceStr(getObjValue("irr_occr_dt"),"-","");    
    	
    	//perform in case change occurs
    	if(forceYn || set_cgo_opr_cd != cgo_opr_cd || set_vvd_cd != vvd_cd || set_irr_occr_dt != irr_occr_dt) {
    		//0. Change container info to delete status and set as parameter when changing Cargo Operator.
			setDelCNTRToForm(sheetObj, true);
			
	    	//1. Initialize Booking info
			initObjs("form", formObj, strBKGOptions, -1, "");
			
	    	//2. Initialize Container info <-- Initialize Sheet Grid
	    	sheetObj.RemoveAll();
	    	
			//3. Container info Key In OR select option type decision <-- Column type change
			setSheetColProp(sheetObj, formObj); 
			
			//4. Cargo Operator item setting
			if(keyInYn && cgo_opr_cd != '') searchCarrierInfo(cgo_opr_cd);
	   		
			//5. changed Cargo Operator code setting
			setObjValue("set_cgo_opr_cd", cgo_opr_cd);
			
			//6. 
			setRequiredForm();
    	}
    }  
    
    /**
     * Initialize selected Object and move focus
     */
    function initObjs(type, sheetObj, nameVars, focusIdx, etcVal) {
    	var nameArrs = nameVars.split("|");
    	
    	for(var objIdx=0; objIdx<nameArrs.length; objIdx++) {
    		
    		if(type == 'sheet') sheetObj.CellValue2(etcVal, prefixs[0]+nameArrs[objIdx]) = "";
    		else ComClearObject(eval("document.form."+nameArrs[objIdx]));
    		
    		if(focusIdx == objIdx) {
    			if(type == 'sheet') sheetObj.SelectCell(etcVal, focusIdx);
    			else setFocus(nameArrs[objIdx]);
    		}
    	}
    }
    
    /**
     * Initialize selected Cell and move focus
     */
    function initCell(sheetObj, Row, Col) {
    	sheetObj.CellValue2(Row,Col) = "";
		sheetObj.SelectCell(Row,Col);
    }
    
    /**
     * Initialize all Objects in document
     */
    function resetObjs() {
    	ComResetAll();
    }  
    
    /**
     * Initialize after retrieving
     */
    function resetExCondObj(sheetObj){
    	//1. Initialize form
    	setObjValue("spcl_cgo_irr_seq", "");
    	setObjValue("irr_smry_rmk", ""); 
    	setObjValue("irr_rsn_rmk", "");       
    	setObjValue("cmsr_desc", "");   
    	setObjValue("file_cnt", "0");  
    	
    	//2. Upload initializing sheet
    	initUpload();	
    	
    	//3. Delete parameter form
    	setDelCNTRToForm(sheetObj, false);
    }
    
    /*****************************************************************************************
     * Initializing end *
     ****************************************************************************************/ 

    /*****************************************************************************************
     * Handling Popup Call Back start *
     ****************************************************************************************/  
    
    /**
  	 * Setting data from VSL Code Help (Pop-Up).<br>
  	 * @param {arry} rtnObjs
  	 */
  	function setCallBackVSL(rtnObjs) {
  		if(rtnObjs){
			var rtnDatas = rtnObjs[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					setObjValue("vsl_cd", rtnDatas[1]);
					
					setFocus("skd_voy_no");
				}
			}
    	}
  	} 
  	
    /**
  	 * Setting data from VVD Code Help (Pop-Up).<br>
  	 * @param {arry} obj
  	 */
  	function setCallBackVVD(obj) {
  		if(obj){
			var rtnDatas = obj[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					setObjValue("skd_voy_no", rtnDatas[2]);
					setObjValue("skd_dir_cd", rtnDatas[3]);
				}
			}
    	}
  		
  		searchVVDInfo();
  		
    	resetBKGCntrInfo(false, false); 	
  	} 
  	
  	/**
  	 * Carrier Code Inquiry부분.<br>
  	 * @param {arry} aryPopupData
  	 */
  	function setCallBackCP(aryPopupData) {
  		setObjValue("cgo_opr_cd", aryPopupData[0][3]);
  		setObjValue("cgo_opr_nm", aryPopupData[0][4]);
  		
  		resetBKGCntrInfo(false, false);
  	} 
  	
  	/**
	 * Sheet1 OnPopupClick ImdgUnNoSeq 이벤트 처리에 대한 CallBack 함수 
	 * @param aryPopupData
	 * @param row
	 * @param col
	 * @param seetIdx 
	 * @return
	 */
	function setCallBackUNNo(aryPopupData, row, col, seetIdx){
		//UN No., Seq., Class, Class Comp Group, Proper Shipping Name	
		setUNNoInfo(seetIdx, row, aryPopupData[0][2], aryPopupData[0][3], aryPopupData[0][4], aryPopupData[0][10], aryPopupData[0][6]);
	}
  	
  	/*****************************************************************************************
     * Handling Popup Call Back end *
     ****************************************************************************************/  
  	
  	/*****************************************************************************************
     * Setter/Getter start *
     ****************************************************************************************/ 
  	
  	/**
     * VVD info related item setting : VVD, Lane, Vessel Operator
     */
    function setVVDInfo(formObj, sXml) { 	 
    	var vvdData = ComScgXml2Array(sXml, strVVDOptions);
    	
 	   	if(vvdData == null) {
 		    ComShowCodeMessage("SCG50010", 'Data');	//'{?msg1} is invalid.'
 		    initObjs("form", formObj, strVVDOptions, 0, "");
 	   	} else {
 	   		if(vvdData.length > 1) {
 	   			ComShowCodeMessage("SCG50010", 'Data');	//'{?msg1} is invalid.'
 	   			initObjs("form", formObj, strVVDOptions, 0, "");
 	   		} else {
 	   			var arrHeads = strVVDOptions.split("|");
 	   			for(var headIdx=3; headIdx<arrHeads.length; headIdx++) {
 	   				setObjValue(arrHeads[headIdx], vvdData[0][headIdx]);
 	   			}
 	   			var subjectStr = "["+vvdData[0][4]+"] "+vvdData[0][0]+vvdData[0][1]+vvdData[0][2]+" - "; 	
 	   			setObjValue("irr_subj_nm", subjectStr);
 	   			
 				setObjValue("set_vsl_cd", 	  getObjValue("vsl_cd"));
 				setObjValue("set_skd_voy_no", getObjValue("skd_voy_no"));
 				setObjValue("set_skd_dir_cd", getObjValue("skd_dir_cd"));
 				
 				setFocus("irr_occr_dt");
 	   		}
 	   	}
 	   	setObjValue("spcl_cgo_irr_seq", "");
    }
    
    /**
     * Cargo Operator item setting : Cargo Operator
     */
    function setCarrierInfo(formObj, sXml, cgoOprCd) { 	
    	var carrierData = ComScgXml2Array(sXml, "crr_cd|crr_nm");
    	
 	   	if(carrierData == null) {
 		    ComShowCodeMessage("SCG50010", 'Data');	//'{?msg1} is invalid.'
 		    initObjs("form", formObj, "cgo_opr_cd|cgo_opr_nm", 0, "");
 	   	} else {
 	   		if(carrierData.length > 1) {
 	   			ComShowCodeMessage("SCG50010", 'Data');	//'{?msg1} is invalid.'
 	   		} else {
 	   			setObjValue("cgo_opr_nm", carrierData[0][1]);
 	   		}
 	   	}
    }
    
    /**
     * Booking info related item setting : BKG No., B/L No., POR, POL, POD, Delivery, SHPR, FWDR, CNEE, dcgo_flg, rc_flg, awk_cgo_flg, bb_cgo_flg
     */
    function setBKGInfo(sheetObj, formObj, sXml, focusIdx) {    	
    	var bkgData = ComScgXml2Array(sXml, strBKGOptions);
 	    
    	var set_bkg_no = "", set_bl_no = "";
 	   	if(bkgData == null) {
 		    ComShowCodeMessage("SCG50010", 'Data'");	//'{?msg1} is invalid.'
 		    initObjs("form", formObj, strBKGOptions, focusIdx, "");
 	   	} else {
 	   		if(bkgData.length > 1) {
 	   			ComShowCodeMessage("SCG50010", 'Data');	//'{?msg1} is invalid.'
 	   			initObjs("form", formObj, strBKGOptions, focusIdx, "");
 	   		} else {
 	   			var arrHeads = strBKGOptions.split("|");
 	   			for(var headIdx=0; headIdx<arrHeads.length; headIdx++) {
 	   				setObjValue(arrHeads[headIdx], bkgData[0][headIdx]);
 	   			}
 	   			set_bkg_no = bkgData[0][0];
 	   			set_bl_no = bkgData[0][1];
 	   			
 	      		searchCNTRList(sheetObj, formObj);
 	   		}
 	   	}
 	   	setObjValue("set_bkg_no",set_bkg_no);
		setObjValue("set_bl_no", set_bl_no);
    }
    
    /**
     * Define Sheet Column
     */
    function setSheetColProp(sheetObj, formObj) {
    	//Column type change(2x2)
    	with (sheetObj) {
    		var selIdx = getObjValue("set_spcl_cgo_cate_cd");
    		
    		removeAll();
    		
    		if(isOWNSEN()) {
    			if(selIdx == 'DG') {
		    		InitDataProperty(0, sheetObj.SaveNameCol(prefixs[0]+"cntr_no"),          dtCombo, 95, daCenter, true,  prefixs[0]+"cntr_no",          false, "", dfNone, 0, true,  true,14);
		    		InitDataProperty(0, sheetObj.SaveNameCol(prefixs[0]+"cntr_tpsz_cd"),     dtData,  55, daCenter, true,  prefixs[0]+"cntr_tpsz_cd",     false, "", dfNone, 0, true,  true, 4);
		    		InitDataProperty(0, sheetObj.SaveNameCol(prefixs[0]+"imdg_un_no_seq"),   dtData,  55, daCenter, false, prefixs[0]+"imdg_un_no_seq",   false, "", dfNone, 0, true,  true, 4);
		    		InitDataProperty(0, sheetObj.SaveNameCol(prefixs[0]+"imdg_clss_cd"),     dtData,  65, daCenter, false, prefixs[0]+"imdg_clss_cd",     false, "", dfNone, 0, true,  true, 3);
		    		InitDataProperty(0, sheetObj.SaveNameCol(prefixs[0]+"imdg_comp_grp_cd"), dtData,  45, daCenter, false, prefixs[0]+"imdg_comp_grp_cd", false, "", dfNone, 0, false, false);
    			} else {
    				InitDataProperty(0, sheetObj.SaveNameCol(prefixs[0]+"cntr_no"),      dtCombo, 95, daCenter, true,  prefixs[0]+"cntr_no",          false, "", dfNone, 0, true, true, 14);
		    		InitDataProperty(0, sheetObj.SaveNameCol(prefixs[0]+"cntr_tpsz_cd"), dtData,  55, daCenter, true,  prefixs[0]+"cntr_tpsz_cd",     false, "", dfNone, 0, true, true, 4);
    			}
    		} else {
    			if(selIdx == 'DG') {
	    			InitDataProperty(0, sheetObj.SaveNameCol(prefixs[0]+"cntr_no"),          dtData,      95, daCenter, true,  prefixs[0]+"cntr_no",          false, "", dfNone, 0, true,  true,14);
		    		InitDataProperty(0, sheetObj.SaveNameCol(prefixs[0]+"cntr_tpsz_cd"),     dtCombo,     55, daCenter, true, prefixs[0]+"cntr_tpsz_cd",      false, "", dfNone, 0, true,  true, 4);
		    		InitDataProperty(0, sheetObj.SaveNameCol(prefixs[0]+"imdg_un_no_seq"),   dtPopupEdit, 55, daCenter, false, prefixs[0]+"imdg_un_no_seq",   false, "", dfNone, 0, true,  true, 4);
		    		InitDataProperty(0, sheetObj.SaveNameCol(prefixs[0]+"imdg_clss_cd"),     dtCombo,     65, daCenter, false, prefixs[0]+"imdg_clss_cd",     false, "", dfNone, 0, true,  true, 3);
		    		InitDataProperty(0, sheetObj.SaveNameCol(prefixs[0]+"imdg_comp_grp_cd"), dtCombo,     45, daCenter, false, prefixs[0]+"imdg_comp_grp_cd", false, "", dfNone, 0, false, false);
		    		
	    	   		searchClsList(formObj);
	    	   		searchClsCompGrpList(formObj);
    			} else {
    				InitDataProperty(0, sheetObj.SaveNameCol(prefixs[0]+"cntr_no"),      dtData,  95, daCenter, true, prefixs[0]+"cntr_no",      false, "", dfNone, 0, true, true, 14);
		    		InitDataProperty(0, sheetObj.SaveNameCol(prefixs[0]+"cntr_tpsz_cd"), dtCombo, 55, daCenter, true, prefixs[0]+"cntr_tpsz_cd", false, "", dfNone, 0, true, true, 4);
    			}
    			InitDataValid(0, prefixs[0]+"cntr_no", vtEngUpOther, "1234567890-");
    	   		searchTPSZList(formObj);
    		}
    	}
    }
    
    /**
     * Setting Container Combo list
     */
    var arrCombo;
    function setCNTRCombo(sXml, sheetObj) {
    	arrCombo = ComXml2ComboString(sXml, prefixs[0]+"cntr_no", prefixs[0]+"cntr_no");
    	if(arrCombo != null && arrCombo.length > 0) 
    		sheetObj.InitDataCombo(0, prefixs[0]+"cntr_no", "| |"+arrCombo[0], "| |"+arrCombo[1], "", "");
    }
    
    /**
     * Filtering Container Combo List
     */
    var beforeComboCntrNo;
    function setFilterCNTRCombo(sheetObj, Row, Col) {  
    	if(arrCombo != null) {
    		var cCombos = arrCombo[0].split("|");
			
			var cCombo = new Array();
			var selVal = sheetObj.CellValue(Row, Col);
    		if(selVal != '') {
    			for(var comIdx1=0; comIdx1<cCombos.length; comIdx1++) {
    				if(selVal == cCombos[comIdx1]) cCombo[comIdx1]  = cCombos[comIdx1];
    			}
    			
    			beforeComboCntrNo = selVal;
    		} else {
    			var isCt = 0, cIdx = 0;
    			for(var comIdx2=0; comIdx2<cCombos.length; comIdx2++) {
    				isVal = 0;
	    			for(var rowIdx=sheetObj.HeaderRows; rowIdx<sheetObj.LastRow; rowIdx++) {
	    				if(sheetObj.CellValue(rowIdx, Col) == cCombos[comIdx2]) isVal++;
	    			}
	    			if(isVal == 0) cCombo[cIdx++] = cCombos[comIdx2];
    			}
    		}
    		
    		sheetObj.CellComboItem(Row, Col, "| |"+cCombo.join("|"), "|NULL|"+cCombo.join("|"), 0);
		}
    }
    
    /**
     * Setting TP/SZ Combo list
     */
    function setTPSZCombo(sXml) {    	
    	var arrCombo = ComXml2ComboString(sXml, "cntr_tpsz_cd", "cntr_tpsz_cd");
		if(arrCombo != null && arrCombo.length > 0) 
			sheetObjects[0].InitDataCombo(0, prefixs[0]+"cntr_tpsz_cd", "| |"+arrCombo[0], "| |"+arrCombo[1], "", "");
    }
    
    /**
     * Setting Class Combo list
     */
    function setClsCombo(sXml) {    	
    	var arrCombo = ComXml2ComboString(sXml, "imdg_clss_cd", "imdg_clss_cd_desc");
    	if(arrCombo != null && arrCombo.length > 0) {
    		var comboCds = arrCombo[0].split("|");
    		var comboTxts = arrCombo[1].split("|");
    		var comboTxtStrs = "";
    		for(var colIdx=0; colIdx<comboCds.length; colIdx++) {
    			comboTxtStrs += "|"+comboCds[colIdx]+"\t"+comboTxts[colIdx];
    		}
    		
    		sheetObjects[0].InitDataCombo(0, prefixs[0]+"imdg_clss_cd", "| "+comboTxtStrs, "| |"+arrCombo[0], "", "", 0);
    	}
    }
    
    /**
     * Setting Class Comp Group Combo list
     */
    function setClsCompGrpCombo(sXml) {    	
    	var arrCombo = ComXml2ComboString(sXml, "imdg_comp_grp_cd", "imdg_comp_grp_cd");
    	
    	if(arrCombo != null && arrCombo.length > 0) 
    		sheetObjects[0].InitDataCombo(0, prefixs[0]+"imdg_comp_grp_cd", "| |"+arrCombo[0], "| |"+arrCombo[1], "", "");    	
    }
    
    /**
     * Setting UN No. related info
     */
    function setUNNoInfo(seetIdx, Row, imdg_un_no, imdg_un_no_seq, imdg_clss_cd, imdg_comp_grp_cd, prp_shp_nm) {    
    	sheetObjects[seetIdx].CellValue2(Row, prefixs[0]+"imdg_un_no")       = imdg_un_no;			//UN No.
		sheetObjects[seetIdx].CellValue2(Row, prefixs[0]+"imdg_un_no_seq")   = imdg_un_no_seq;		//Seq.
		sheetObjects[seetIdx].CellValue2(Row, prefixs[0]+"imdg_clss_cd")     = imdg_clss_cd;		//Class
		sheetObjects[seetIdx].CellValue2(Row, prefixs[0]+"imdg_comp_grp_cd") = imdg_comp_grp_cd;	//Class Comp Group
	 
		sheetObjects[seetIdx].CellValue2(Row, prefixs[0]+"prp_shp_nm")       = prp_shp_nm;			//Proper Shipping Name	
    }
    
    /**
     * Setting Container info related item setting : 
     * 1. Dangerous Goods : TP/SZ, UN No/Seq, Class, Proper Shipping Name	
     * 2. Awkward Cargo : TP/SZ, AWK_Type, Gross, Net, L, W, H, Commodity
     */
    function setCNTRInfo(sheetObj, Row, Col, sXml, Value) {
    	var sArr = ComScgXml2Array(sXml, prefixs[0]+"cntr_no");
		if(sArr == null) {
			ComShowCodeMessage("SCG50010", 'Data');	//'{?msg1} is invalid.'
			
			//Initialize Sheet Row
			var nameVars = "", nameVar = "";
			for(var paramIdx=0; paramIdx<sheetObj.LastCol-1; paramIdx++) {
				nameVar = sheetObj.ColSaveName(paramIdx);
				nameVars += nameVar.substring(7,nameVar.length);
				nameVars += "|";
			}
			if (nameVars != "") nameVars = nameVars.substr(0, nameVars.length -1);
			
			initObjs("sheet", sheetObj, nameVars, -1, Row);
		} else {			
			var cntrNoCol = sheetObj.SaveNameCol(prefixs[0]+"cntr_no");
			var cntrNo = "", cgoSeq = "", dupRowIdx = -1, colValue = "";
			for(var rsltRowIdx = 0; rsltRowIdx<sArr.length; rsltRowIdx++) {
				cntrNo = ComScgXml2Array(sXml,prefixs[0]+"cntr_no")[rsltRowIdx];
				cgoSeq = ComScgXml2Array(sXml,prefixs[0]+"cgo_seq")[rsltRowIdx];
				
				dupRowIdx = colDupCheck(sheetObj, cntrNo+cgoSeq);
				if(rsltRowIdx != 0 && dupRowIdx == -1) sheetObj.DataInsert(Row-1,0);
				for(var paramIdx=sheetObj.SaveNameCol(prefixs[0]+"cntr_no"); paramIdx<sheetObj.LastCol-1; paramIdx++) {
					colValue = ComScgXml2Array(sXml,sheetObj.ColSaveName(paramIdx))[rsltRowIdx];
					if(colValue != "" && sheetObj.CellValue(Row, paramIdx) == "") {
						sheetObj.CellValue(Row, paramIdx) = colValue;
						sheetObj.CellText(Row, paramIdx) = colValue;
					}
				}
				
				sheetObj.CellValue(Row, sheetObj.SaveNameCol(prefixs[0]+"cell_psn_no")) = "0";
	    		
				Row++;
			}
		}
	}
		
	/**
     * Change related Container information to delete status and set parameter in case changing Option.
     */
    function setDelCNTRToForm(sheetObj, option) {  
    	var paramObj = document.getElementById('cntr_del_param');
    	if(option) {    		
    		if(paramObj == null && sheetObj.RowCount > 0) {
		    	var formObj = document.form;
		    	var dyParamDiv = document.createElement("<div name='cntr_del_param' id='cntr_del_param' style='display:'></div>");
		    	var ibFlag, valParam1, valParam2;
		    	for(var rowIdx=sheetObj.HeaderRows; rowIdx<=sheetObj.LastRow; rowIdx++) {   
		    		ibFlag = sheetObj.CellValue(rowIdx, prefixs[0]+"ibflag");
		    		if(ibFlag != 'I') {
			    		valParam1 = document.createElement("<input type='hidden' name='sheet1_ibflag' value='D'>");
			    		valParam2 = document.createElement("<input type='hidden' name='sheet1_spcl_cgo_irr_cntr_seq' value='"+sheetObj.CellValue(rowIdx, prefixs[0]+"spcl_cgo_irr_cntr_seq")+"'>");
			    		dyParamDiv.appendChild(valParam1);
			    		dyParamDiv.appendChild(valParam2);   
		    		}
		    	}
		    	formObj.appendChild(dyParamDiv);
    		}
    	} else {
    		if(paramObj != null) paramObj.removeNode(true);
    	}
    }
    
    /**
     * create specific Object value as parameter in document
     */
    function FormParamString(form, type) {
        var name = new Array(form.elements.length);
        var value = new Array(form.elements.length);
        var j = 0;
        var plain_text="";

        var len = form.elements.length;
        var objType;
        for (var i = 0; i < len; i++) {
        	objType = form.elements[i].type;
        	if(type == objType) {
        		switch (form.elements[i].type) {
        			case "hidden":
        				name[j] = form.elements[i].name;
        				name[j] = ComReplaceStr(name[j],"set_","");
                        value[j] = form.elements[i].value;
                        j++;
                        break;
        		}
            }
        }

        var webBrowserName = navigator.appName;
        var webBrowserVer  = navigator.appVersion.substring(navigator.appVersion.indexOf("MSIE") + 5,
                                                            navigator.appVersion.indexOf("MSIE") + 8)

        if(webBrowserName == "Microsoft Internet Explorer" && webBrowserVer >= 5.5) {
            for (i = 0; i < j; i++) {
                if (name[i] != '') plain_text += name[i]+ "=" + encodeURIComponent(value[i]) + "&";
            }
        }

        if (plain_text != "") plain_text = plain_text.substr(0, plain_text.length -1);
        
        return plain_text;
    }
    
    /**
     * Set Form of EtcData value.
     */
    function setXmlEtcDataToForm(formObj, sXml) {
    	var iMatchCnt = 0;
    	try {
    		var elements = formObj.elements;

    		for ( var i = 0; i < elements.length; i++) {
    			var sValue, eNmPrefix, eName;
    			if (elements[i].classid == undefined) {
    				eName = elements[i].name;
    			} else {
    				eName = elements[i].id;
    			}
    			
    			if (eName == "" || eName == "vsl_slan_cd" || eName == "vsl_slan_nm" || eName == "vsl_opr_tp_cd")
    				continue;
    			
    			eNmPrefix = eName.substring(0,4);
    			if(eNmPrefix == 'set_') eName = eName.substring(4,eName.length);

    			sValue = ComGetEtcData(sXml, eName);
    			
    			if (sValue == undefined)
    				continue;

    			if (elements[i].type == "radio") {
    				var eRadio = document.all[eName];
    				if (eRadio.length > 1)
    					i += (eRadio.length - 1);

    				if (sValue != undefined) {
    					ComSetObjValue(eRadio, sValue);
    					iMatchCnt++;
    				}
    				continue;
    			}

    			ComSetObjValue(elements[i], sValue);

    			iMatchCnt++;
    		}// for
    	} catch (err) {
    		ComFuncErrMsg(err.message);
    	}

    	return iMatchCnt;
    }
    
    /**
     * Cargo Operator's OWN Company code or SEN input status
     */
    function isOWNSEN() {
    	
    	var value = getObjValue("cgo_opr_cd");
    	
    	if(value == '' || value == ConstantMgr.getCompanyCode())
    		return true;
    	
    	return false;
    }
    
    /**
     * Show B/L No. as compulsory input item and change input digit in case Cargo Operator is  OWN Company code.
     */
    function setRequiredForm() {
    	var itemObj;
    	var arrForms = strBKGOptions.split("|");
		for(var itemIdx=0; itemIdx<2; itemIdx++) {
			itemObj = document.getElementsByName(arrForms[itemIdx])[0];
			if(isOWNSEN()) {
				itemObj.className = "input";
				itemObj.setAttribute("required", "true");
				if(itemObj.name == 'bkg_no') itemObj.setAttribute("maxLength", 11);
				itemObj.setAttribute("fullfill", "true");
				itemObj.readOnly = false;
			} else {
				if(itemObj.name == 'bl_no') {
					itemObj.className = "input2";
					itemObj.readOnly = true;
				} else {
					itemObj.className = "input";
				}
				
				itemObj.removeAttribute("required");
				if(itemObj.name == 'bkg_no') itemObj.setAttribute("maxLength", 30);
				itemObj.removeAttribute("fullfill");
			}
		}
    }
    
    /**
	 * Add selected files to 팝업 IBUpload
	 **/
	function setFileUpload(aryPopupData) {
		var sheetObj  = sheetObjects[1];
		var uploadObj = uploadObjects[0];
		
		uploadObj.Files="";
		sheetObj.removeAll();
		
		var file_cnt = 0;
		for (var rowIdx=0; rowIdx<aryPopupData.length; rowIdx++){ 
			var fileSetYn = aryPopupData[rowIdx][2];	
			var ibFlag    = aryPopupData[rowIdx][0];	
			
			if(fileSetYn == 'Y') {
				var sFile = aryPopupData[rowIdx][3];
				if (sFile=="") ComShowCodeMessage('SCG50004', 'Data');	//'{?msg1} is not available.'
				
				var ret = uploadObj.AddFile(sFile);
			}
			
			if(ibFlag != 'D') file_cnt++;
			
			sheetObj.DataInsert(-1,0);	
			for (var colIdx=0; colIdx<=sheetObj.LastCol; colIdx++){ 
				sheetObj.CellValue2(rowIdx+1, colIdx) = aryPopupData[rowIdx][colIdx];
			}
		}
		setObjValue("file_cnt", file_cnt);
	
		return; 
	}
	
	/**
	 * Retrieve Hidden IBSheet for upload.
	 **/
	function getFileUpload() {
	
		return sheetObjects[1]; 
	}
	
	/**
     * sceen setting after retrieving
     */
    function setAfterSearch(sXml, sheetObj, formObj) {
    	//parameter deciding retrieve success|fail
    	var spcl_cgo_irr_seq = ComGetEtcData(sXml,"spcl_cgo_irr_seq");
    	
    	if(spcl_cgo_irr_seq != '' && spcl_cgo_irr_seq != 'null') {
    		
	    	//1. Initialize screen
	 	   	resetObjs();	 	    
	    	initUpload();	//Upload initializing sheet
	    	
	 	   	//2. Set retrieved Irregular general information.
	 	   	setXmlEtcDataToForm(formObj, sXml);
	 	   	
	 	   	//3. Set retrieved VVD general information.
	 	   	searchVVDInfo();
	 	    
	 	   	//4. Perform basic steps after selecting Option.
	 	    setSelectedOption();
	 	   
	 	    //5. Set retrieved Irregular general information again.
	 	    setXmlEtcDataToForm(formObj, sXml);
	 	   
	 	    //6. Set retrieved Booking general information.
	 	    searchBKGInfo(-1);
	 	    
	 	    //7. Fill sheet with Container information.
	 	    if(sXml.length>0) sheetObj.LoadSearchXml(sXml);	 	    

    	} else {
    		if(sXml.length>0) sheetObj.LoadSearchXml(sXml);
    		
    		resetExCondObj(sheetObj);
    	}
    }
    
    /**
     * Get Count of Search List
     */
    function getTotal(sXml){
	    if ( sXml == null  || sXml == "" ) return;

	    try {
	        var xmlDoc = new ActiveXObject("Microsoft.XMLDOM" );
	        xmlDoc.loadXML(sXml);

	        var xmlRoot = xmlDoc.documentElement;
	        if(xmlRoot == null) return;

	        var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
	      
	        if(dataNode == null) return "";

	        return dataNode.getAttribute("TOTAL");
	    } catch(err) { ComFuncErrMsg(err.message); }
	} 
	
	/**
     * Get Object Value
     */
    function getObjValue(name) {
    	return ComGetObjValue(eval("document.form."+name));
    }
    
    /**
     * Set Object Value
     */
    function setObjValue(name, value) {
    	ComSetObjValue(eval("document.form."+name), value);
    }
    
    /**
     * Move Focus in Object
     */
    function setFocus(name) {
    	ComSetFocus(eval("document.form."+name));
    }
  	
  	/*****************************************************************************************
     * Setter/Getter end *
     ****************************************************************************************/ 
    
    /*****************************************************************************************
     * Transaction start *
     ****************************************************************************************/ 
    
    // Sheet related process handling
    function doActionIBSheet(sheetObj,formObj,sAction,source) {
    	sheetObj.ShowDebugMsg = false;   
        switch(sAction) {

           case IBSEARCH:      //retrieve        	   
        	   if(!validateForm(sheetObj,formObj,sAction)) return false;
        	   
        	   //Initializing Sequence 
        	   if(source == 'SELF') setObjValue("spcl_cgo_irr_seq","");
        	   
        	   formObj.f_cmd.value = SEARCH;
        	   var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam(prefixs[0]);
        	   
        	   var sXml = sheetObj.GetSearchXml("VOP_SCG_0013GS.do", sParam);
        	   
        	   setAfterSearch(sXml, sheetObj, formObj);

               break;
           
           case IBCLEAR:      
        	   if(!validateForm(sheetObj,formObj,sAction)) return false;
        	   
    		   initUI();
    		   
    	       setFocus("vsl_cd");
        		   
               break;  
        }
        
    	setDelCNTRToForm(sheetObj, false);
    }
    
    // IBCombo related process handling
    function doActionIBCombo(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg = false;
        switch(sAction) {
        	//Get Irregulars Type Combo Box Item - Option type separate
        	case IBSEARCH_ASYNC01:
        		formObj.f_cmd.value = SEARCH04;        	   
        		var set_spcl_cgo_cate_cd = getObjValue("set_spcl_cgo_cate_cd");
        	   
        		var sParam = FormQueryString(formObj);
        		if(set_spcl_cgo_cate_cd == 'DG') 
        			sParam += "&dg_flg=Y";
        		else 
        			sParam += "&awk_flg=Y";
        		
        		var sXml = sheetObj.GetSearchXml("SCG_COM_INTERNALGS.do", sParam);
        		ComXml2ComboItem(sXml, formObj.spcl_cgo_irr_tp_cd, "spcl_cgo_irr_tp_cd", "spcl_cgo_irr_tp_nm|spcl_cgo_irr_tp_cd|spcl_cgo_irr_tp_desc");
        		formObj.spcl_cgo_irr_tp_cd.Index = 0;
			   
        		break;
        }
    }
  	
  	/**
     * VVD info retrieve
     */
    function searchVVDInfo() {
    	var formObj = document.form;
    	
    	formObj.f_cmd.value = SEARCH05;
 	   	var sXml = sheetObjects[0].GetSearchXml("SCG_COM_EXTERNALGS.do", FormQueryString(formObj)); 	   	
 	    
 	    setVVDInfo(formObj, sXml);
    }
    
    /**
     * Cargo Operator info retrieve
     */
    function searchCarrierInfo(cgoOprCd) {
    	var formObj = document.form;
    	
    	formObj.f_cmd.value = SEARCH01;
 	   	var sXml = sheetObjects[0].GetSearchXml("SCG_COM_EXTERNALGS.do", FormQueryString(formObj)+"&crr_cd="+cgoOprCd); 	   	
 	    
 	    setCarrierInfo(formObj, sXml, cgoOprCd);
    }
    
    /**
     * Booking 정보 조회
     */
    function searchBKGInfo(focusIdx) {
    	if(isOWNSEN()) {
    		var sheetObj = sheetObjects[0];
	    	var formObj = document.form;
	    	
	    	if(getObjValue("bkg_no") == "" && getObjValue("bl_no") == "") return; 
	    	
	    	if(focusIdx == 0 && getObjValue("set_bkg_no") == getObjValue("bkg_no")) return;
	    	if(focusIdx == 2 && getObjValue("set_bl_no") == getObjValue("bl_no")) return;
	    	
    		if(!ComChkObjValid(formObj.vsl_cd) || !ComChkObjValid(formObj.skd_voy_no) || !ComChkObjValid(formObj.skd_dir_cd)) {
    			setObjValue("set_bl_no","");
	    		setObjValue("bl_no","");
	    		setObjValue("set_bkg_no","");
	    		setObjValue("bkg_no","");
	    			
	    		return;
    		}
    		
	    	if(focusIdx == 0 && getObjValue("bkg_no") != "") {
	    		setObjValue("set_bl_no","");
	    		setObjValue("bl_no","");
	    	} else if(focusIdx == 2 && getObjValue("bl_no") != "") {
	    		setObjValue("set_bkg_no","");
	    		setObjValue("bkg_no","");
	    	}
	    	
	    	formObj.f_cmd.value = SEARCH01;
	 	   	var sXml = sheetObj.GetSearchXml("VOP_SCG_0013GS.do", FormQueryString(formObj));
	 	   	
	 	    setBKGInfo(sheetObj, formObj, sXml, focusIdx);
    	}
    }
    
    /**
     * Container Combo list info
     */
    function searchCNTRList(sheetObj, formObj) {  
    	formObj.f_cmd.value = SEARCH02;
		var sXml = sheetObj.GetSearchXml("VOP_SCG_0013GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(prefixs[0]));

		setCNTRCombo(sXml, sheetObj);
    }
    
    /**
     * Container info retrieve
     */
    function searchCNTRInfo(sheetObj, Row, Col, Value)  {
    	var formObj = document.form;    	
    	formObj.f_cmd.value = SEARCH03;
    	var sParam = FormParamString(formObj, "hidden");
 	    
		var sXml = sheetObj.GetSearchXml("VOP_SCG_0013GS.do", sParam+ "&" + ComGetPrefixParam(prefixs[0]));
		
		setCNTRInfo(sheetObj, Row, Col, sXml, Value);		
	}
    
    /**
     * TP/SZ Combo list retrieve
     */
    function searchTPSZList(formObj) {  
    	formObj.f_cmd.value = SEARCH06;
    	
		var sXml = sheetObjects[0].GetSearchXml("SCG_COM_EXTERNALGS.do", FormQueryString(formObj));
		
		setTPSZCombo(sXml);
    }
    
    /**
     * Class Combo list retrieve
     */
    function searchClsList(formObj) {  
    	formObj.f_cmd.value = SEARCH02;
    	
		var sXml = sheetObjects[0].GetSearchXml("SCG_COM_INTERNALGS.do", FormQueryString(formObj));
		
		setClsCombo(sXml);
    }
    
    /**
     * Class Comp Group Combo list retrieve
     */
    function searchClsCompGrpList(formObj) {  
    	formObj.f_cmd.value = SEARCH08;
    	
		var sXml = sheetObjects[0].GetSearchXml("SCG_COM_EXTERNALGS.do", FormQueryString(formObj));
		
		setClsCompGrpCombo(sXml);
    }
    
    /**
     * UN No. related info retrieve
     */
    function searchUNNoInfo(sheetObj, Row, Col) {  
    	var formObj = document.form;
    	formObj.f_cmd.value = SEARCH05;
    	
    	var imdgUnNo = sheetObj.CellValue(Row, prefixs[0]+"imdg_un_no");
		var imdgUnNoSeq = sheetObj.CellValue(Row, prefixs[0]+"imdg_un_no_seq");
		
		var sXml = sheetObjects[0].GetSearchXml("SCG_COM_INTERNALGS.do", FormQueryString(formObj)+"&imdg_un_no="+imdgUnNo+"&imdg_un_no_seq="+imdgUnNoSeq);
		
		var sArr = ComScgXml2Array(sXml, "imdg_un_no");
		
		var imdg_un_no       = "";
		var imdg_un_no_seq   = ""; 
		var imdg_clss_cd     = "";
		var imdg_comp_grp_cd = "";
		var prp_shp_nm       = "";
		
		if(sArr == null) {
			ComShowCodeMessage("SCG50010", 'Data');	//'{?msg1} is invalid.'
			
			initObjs("sheet", sheetObj, prefixs[0]+"imdg_un_no|"+prefixs[0]+"imdg_un_no_seq", 0, Row);
		} else {
			imdg_un_no       = ComScgXml2Array(sXml, "imdg_un_no")[0];
			imdg_un_no_seq   = ComScgXml2Array(sXml, "imdg_un_no_seq")[0];
			imdg_clss_cd     = ComScgXml2Array(sXml, "imdg_clss_cd")[0];
			imdg_comp_grp_cd = ComScgXml2Array(sXml, "imdg_comp_grp_cd")[0];
			prp_shp_nm       = ComScgXml2Array(sXml, "prp_shp_nm")[0];
		}	
		
		setUNNoInfo(0, Row, imdg_un_no, imdg_un_no_seq, imdg_clss_cd, imdg_comp_grp_cd, prp_shp_nm);
    }
    
    /*****************************************************************************************
     * Transaction end *
     ****************************************************************************************/ 
    
    /*****************************************************************************************
     * Validation start *
     ****************************************************************************************/ 
    
    /**
     * Column duplication check in Grid
     */
    function colDupCheck(sheetObj, Value) {    	
    	if(Value != '') {       		
    		var loopVal;
	    	for(var rowIdx=sheetObj.HeaderRows; rowIdx<=sheetObj.LastRow; rowIdx++) {
	    		loopVal = sheetObj.CellText(rowIdx, prefixs[0]+"cntr_no") + sheetObj.CellValue(rowIdx, prefixs[0]+"cgo_seq");	    		
	    		if(loopVal == Value) {
		    		return rowIdx;
		    	}
	    	}
    	}

    	return -1;
    }

    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
    	switch(sAction) {

        	case IBSEARCH:
        		if(!ComChkObjValid(formObj.vsl_cd)) 	return false;
        		if(!ComChkObjValid(formObj.skd_voy_no)) return false;
        		if(!ComChkObjValid(formObj.skd_dir_cd)) return false;
        		
        		var spcl_cgo_irr_seq = getObjValue("spcl_cgo_irr_seq");
        		if(spcl_cgo_irr_seq == '') {
	        		if(!ComChkObjValid(formObj.irr_occr_dt)) return false;
	        		
	        		if(!ComChkObjValid(formObj.cgo_opr_cd)) return false;
        		}
        		
        		if(getObjValue("bkg_no") != '' && !ComChkObjValid(formObj.cgo_opr_cd)) return false;
        		break;
    	}

        return true;
    }
    
    /*****************************************************************************************
     * Validation end *
     ****************************************************************************************/ 

	