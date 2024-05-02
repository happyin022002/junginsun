/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EES_MNR_0230.js
*@FileTitle : ACEP Candidate Cntr List 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/19
*
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
						MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
						OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/* ********* General Functions ************* */
	// common global variables
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
		var sheetObject1=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
				//Date
				case "cur_dt_cal":
					var cal=new ComCalendar();
					cal.select(formObject.cur_dt, 'yyyy-MM-dd');
					break;
				case "btn_Retrieve":
					doActionIBSheet(sheetObject1,document.form,IBSEARCH);
					break; 
				case "btn_Detail":
				    var selectedRow=sheetObject1.GetSelectRow();
//					var selectedRow=sheetObject1.RowCount();
					if(selectedRow < 1) {return;}
					var eqNo=sheetObject1.GetCellValue(selectedRow, "eq_no");
					ComOpenPopup('/opuscntr/EES_MNR_0191.do?eq_no='+eqNo, 901, 495, '', '0,1,1,1,1,1,1,1,1,1,1,1', true);
					break; 
				case "btn_DownExcel":
					if(sheetObject1.RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
					}else{
						sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1 });
					}					
					break;                   
            } // end switch
    	}catch(e) {
    		if (e == "[object Error]") {
    			ComFuncErrMsg(e); 
    		} else {
    			ComFuncErrMsg(e);
    		}
    	}
    }
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
    	// setting button
    	MnrWaitControl(true);
    	//initializing IBMultiCombo
    	for ( var k=0; k < comboObjects.length; k++) {
    		initCombo(comboObjects[k], k + 1);
    	}
    	// initializing IBSheet
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i + 1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        // initializing Axon event
		initControl();
		// initializing form
		doActionIBSheet(sheetObjects[0], document.form, IBCLEAR, 0);
		//focus
    }
    /**
     * IBsetting combo basic info
     * @param {IBCombo} comboObj initializing ComboObject
     * @param {Number} comboNo ComboObject tag serial number
     */
    function initCombo(comboObj, comboNo) {
    	var cnt=0;
    	var formObject=document.form
    	switch (comboNo) {
    	case 1:
    		with (comboObj) {
    			SetColAlign(0, "center");
				SetUseAutoComplete(1);
				SetUseEdit(1);
				SetMaxLength("2");
    		}
    		break;
    	case 2:
    	case 3:
    		with (comboObj) {
    			SetColAlign(0, "left");
    		}
    		break;
    	}
    }
	function resizeSheet( sheetObj ){
	    ComResizeSheet( sheetObj );
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
                with(sheetObj){            
                 var HeadTitle="|Seq.|CNTR No.|TP/SZ|Location|Yard|ACEP Due Date|Next ACEP Date|Over Months";	
	             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );	
	             var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	             var headers = [ { Text:HeadTitle, Align:"Center"} ];
	             InitHeaders(headers, info);
	
	             var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"eq_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"eq_tpsz_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"loc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"yd_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"rpr_dt",         KeyField:0,   CalcLogic:"",   Format:"Hm",          PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:160,  Align:"Center",  ColMerge:0,   SaveName:"next_audit_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"over_month",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	              
	             InitColumns(cols);
	             SetEditable(1);
	             SetSelectionMode(smSelectionRow);    
//	             SetSheetHeight(423);
	             resizeSheet( sheetObj );
	             }
                break;
        }
    }
	/**
	 * initializing  HTML Control event. <br>
	 **/
	function initControl() {
	    axon_event.addListenerForm  ('blur', 		'obj_blur',		document.form); 	
	//    axon_event.addListenerFormat('focus',  		'obj_focus',    document.form); 	
	    axon_event.addListenerForm	('keypress',	'obj_keypress', document.form);		
    }
    /**
     * registering IBCombo Object as list
     * @param {IBCombo} combo_obj IBCombo Object as list
     */
    function setComboObject(combo_obj) {
    	comboObjects[comboCnt++]=combo_obj;
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
     * checking on HTML Control's onblur event. <br>
     **/
    function obj_blur(){
		ComChkObjValid(ComGetEvent());
	}	
	/**
     * checking on HTML Control's focus event. <br>
     **/
    function obj_focus(){
		ComClearSeparator(ComGetEvent());
    }
	/**
	 * checking on HTML Control's onkeypress event. <br>
	 **/	
	/** 
	 * COMBO changing event
	 * settng format of loc_cd in case of changing ACEP Type
	 * @param	{IBMultiCombo}	comboObj	changed comboObject
	 * @param	{Number}		Index_Code	changed combo code
	 * @param	{String}		Text		changed combo name
	 */
	function acep_type_OnChange(comboObj, oldindex, oldtext, oldcode, newindex, newtext, newcode){//(comboObj, Index_Code, Text){
		var formObj=document.form;
		//ALL
		if(newcode == "A") {
			$('#loc_cd').prop('readonly', true).prop('required', false);
		//ETC
		} else {
			$('#loc_cd').prop('readonly', false).prop('required', true);
			//Yard
			if(newindex == "YARD") {
				$('#loc_cd').prop('maxLength', 7);
			//ETC
			} else {
				$('#loc_cd').prop('maxLength', 5);
			}
		}
		$('#loc_cd').val('');
	}
    /**
     * handling process sheet
     * 
     * @param {IBSheet}sheetObj handling sheetObject
     * @param {Form}formObj handling formObject
     * @param {Number}sAction Action constants 
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
	    	// initializing
	    	case IBCLEAR:
	    		// settng button and progressing bar
	    		sheetObj.SetWaitImageVisible(0);
	    		MnrWaitControl(true);
	    		//initializing sheet
	    		sheetObjects[0].RemoveAll();
	        	//initializing Combo Data
				for(var i=0; i < comboObjects.length;i++){ 
					comboObjects[i].RemoveAll();
				}
				//(cb_month)setting combo data
				for ( var i=0; i < 30; i++) {
					cb_month.InsertItem(i, i + 1 + '', i + 1 + '');
					//comboObjects[0].InsertItem(i, i,i);
				}
				//retrieving combo data(Term,ACEP)
				var sCondition=new Array (
					new Array("MnrGenCd","CD00060", "COMMON") 	//Term Type
				   ,new Array("MnrGenCd","CD00061", "COMMON") 	//ACEP Type
				)             
				var comboList=MnrComSearchCombo(sheetObj,sCondition);
				//setting combo data        
				for(var i=0; i < comboList.length;i++){
					if(comboList[i] != null){
						for(var j=0; j < comboList[i].length;j++){ 
							var tempText=comboList[i][j].split("|");    
							//Display[CODE_NAME]:Term Type
							if(i==0) {
								term_type.InsertItem(j, tempText[1] ,tempText[0]);
							//Display[CODE_NAME]:ACEP Type
							} else if(i==1) {
								acep_type.InsertItem(j, tempText[1] ,tempText[0]);
							}
						}
					}
				}
				term_type.InsertItem(0, "ALL" ,"A" );
				//setting initial value
				formObj.cur_dt.value=ComGetNowInfo("ymd"); //Date
				cb_month.SetSelectCode("1",false);//Months after ACEP Audit
				term_type.SetSelectCode("A",false);//Term Type
				acep_type.SetSelectCode("RCC");//ACEP Type
				//end settng button and progressing bar
	    		MnrWaitControl(false);
	    		sheetObj.SetWaitImageVisible(1);
	    		break;
	    	//retrieving
			case IBSEARCH:      
				if(validateForm(sheetObj,formObj,sAction)) {
					sheetObj.SetWaitImageVisible(1);
					formObj.f_cmd.value=SEARCH;
					formObj.month.value = cb_month.GetSelectCode();
					var sXml=sheetObj.GetSearchData("EES_MNR_0230GS.do", FormQueryString(formObj));
					sheetObj.RenderSheet(0);
					sheetObj.LoadSearchData(sXml,{Sync:0} );
					sheetObj.RenderSheet(1);
					
					//sheetObj.LoadSearchData(sXml,{Sync:0} );
				}
				break;
        }
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
		//retrieving시
		if(sAction==IBSEARCH){
			//Dataformat
			if (!ComChkValid(formObj)) {return false;}
			//checking Multi Combo mandatory
			
			//var cb_month=ComIsNull(formObj.cb_month.value);
			if(ComIsNull(formObj.cb_month.value)) {
				ComShowCodeMessage("MNR00036","Months After ACEP Audit");
			    return false;
			}
		}
    	return true;
    }
