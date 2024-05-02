/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ees_mnr_0094.js
 *@FileTitle : Scrapping/Donation Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
=========================================================*/
/****************************************************************************************
 Eevent classification code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
 COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class ees_mnr_0094 : ees_mnr_0094 - Defining a script used by screen
 */
/* ********* General Functions ************* */
	// Common global variable
	var comboObjects=new Array();
	var comboCnt=0;
	var sheetObjects=new Array();
	var sheetCnt=0;
	// Defining event handler of button click */
	document.onclick=processButtonClick;
	// Event handler to diverge process by button name */
    function processButtonClick(){
        /***** Adding variable of sheet object in case of more than 2 sheets per tabs *****/
        var sheetObject1=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObject1, formObject, IBSEARCH);
					break;
				case "btn_New":
					doActionIBSheet(sheetObject1, formObject, IBCLEAR, 1);
					break;
				//Opening calendar
				case "cre_dt_cal":
					var cal=new ComCalendarFromTo();
					cal.select(formObject.cre_dt_fr, formObject.cre_dt_to, 'yyyy-MM-dd');
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
     * Sheet default setting and initializing
     * To implement for onload event of body tag
     * After loading in your browser should display the ability to add pre-processing
     */
    function loadPage() {
    	// Setting button
    	MnrWaitControl(true);
    	// Initializing IBMultiCombo
    	for ( var k=0; k < comboObjects.length; k++) {
    		initCombo(comboObjects[k], k + 1);
    	}
    	// IBSheetInitializing
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
		//Axon Initializing event
		initControl();
		//Initializing screen
    	doActionIBSheet(sheetObjects[0], document.form, IBCLEAR, 0);
    }
  	/**
     * Initializing IBCombo
     * @param	{IBCombo}	comboObj	Object for initialized IBCombo
     * @param	{Number}	comboNo		Sequence number from combo object tag id
     */
    function initCombo(comboObj, comboNo) {
	    var cnt=0 ;
	    var formObject=document.form
	    switch(comboNo) {
	    	case 1:
	    	case 2:
	    		with (comboObj) {
	    			SetColAlign(0, "left");
	    			SetDropHeight(160);
	    		}
	    		break;
	    	case 3:
	            with (comboObj) {
	    			SetColAlign(0, "left");
				    SetDropHeight(160);
			    	SetColWidth(0, "75");
					SetUseAutoComplete(1);
					SetUseEdit(1);
		        }
	            break;
	     }
	}
	function resizeSheet( sheetObj ){
	    ComResizeSheet( sheetObj );
	}
    /**
     * Initializing variable for IBSheet and defining header
     * param : sheetObj ==> sheet object, sheetNo ==> Sequence number from sheet object tag id
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      // sheet1 init
                with(sheetObj){
		          var HeadTitle1="|Seq.|Type|EQ Type|EQ No.|TP/SZ|Curr.|Expense Amount|Income Amount|Request Office|Issue Yard|Issue Date";
		
		          SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		          var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		          var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		          InitHeaders(headers, info);
		
		          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                 {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
		                 {Type:"Combo",     Hidden:0, Width:70,   Align:"Left",    ColMerge:0,   SaveName:"mnr_xtra_disp_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Combo",     Hidden:0, Width:70,   Align:"Left",    ColMerge:0,   SaveName:"eq_knd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"eq_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"eq_tpsz_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Float",     Hidden:0,  Width:110,  Align:"Right",   ColMerge:0,   SaveName:"xtra_disp_expn_amt",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Float",     Hidden:0,  Width:110,  Align:"Right",   ColMerge:0,   SaveName:"xtra_disp_incm_amt",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"iss_ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"iss_yd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"iss_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		           
		          InitColumns(cols);
		
		          SetEditable(1);
                    SetSelectionMode(smSelectionRow);

//                    SetSheetHeight(400);
                    resizeSheet( sheetObj );
              }


         break;
        }
    }
    /**
	 * Defining event. <br>
	 **/
	function initControl() {
	    axon_event.addListenerForm  ('blur', 		'obj_blur',		document.form);
//	    axon_event.addListenerFormat('focus',  		'obj_focus',    document.form);
//	    axon_event.addListenerForm	('keypress',	'obj_keypress', document.form);
//	    axon_event.addListenerFormat('change',	 	'obj_change',	document.form);
    }
    /**
     * Assigning array of IBCombo object
     *
     * @param {IBCombo} combo_obj  IBCombo Object
     */
    function setComboObject(combo_obj) {
    	comboObjects[comboCnt++]=combo_obj;
    }
	/**
     * Assigning array of IBSheet object
     * Array defined at the top of the source
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
	/**
     * Onblur event handling <br>
     **/
    function obj_blur(){
		ComChkObjValid(ComGetEvent());
	}
	/**
     * OnFocus event handling <br>
     **/
    function obj_focus(){
    	ComClearSeparator(ComGetEvent());
    }
	/**
	 * OnKeypress event handling <br>
	 **/
	function obj_keypress(){
		obj=ComGetEvent();
	    if(obj.dataformat == null) return;
	    window.defaultStatus=obj.dataformat;
		switch(obj.dataformat) {
			case "ymd":
				ComKeyOnlyNumber(ComGetEvent());
				break;
			case "engup":
	          	ComKeyOnlyAlphabet("uppernum");
	            break;
	    }
	}
	/**
	 * OnChange event handling <br>
	 **/
	function obj_change(){
		/*
		var obj=ComGetEvent();
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		if ( ComTrim(obj.value) != "" ) {
			switch(ComGetEvent("name")) {
	    		case "eq_no":
	        		doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC01);
				   	break;
			}
	    }
	    */
	}
    /**
     * Sheet related process processing
     *
     * @param {IBSheet}sheetObj Used sheet object
     * @param {Form}formObj Used form object
     * @param {Number}sAction Variable for diverge (Define from CoObject.js)
     */
    function doActionIBSheet(sheetObj,formObj,sAction,sActionIdx) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
	    	// Initializing
	    	case IBCLEAR:
	    		sheetObj.SetWaitImageVisible(0);
	    		MnrWaitControl(true);
	    		// Initializing all sheet
	    		for (i=0; i < sheetObjects.length; i++) {
	    			sheetObjects[i].RemoveAll();
	    		}
	    		// Only Loading
	    		if (sActionIdx == 0) {
	    			for ( var i=0; i < comboObjects.length; i++) {
	    				comboObjects[i].RemoveAll();
	    			}
					var sCondition=new Array (
						new Array("MnrGenCd","CD00032", "COMMON"), 		//Type
						new Array("MnrGenCd","","CUSTOM9"),		//EQ Type
						new Array("MdmOrganization","SEARCH","NOTHQ")	//Request Office
					)
					var comboList=MnrComSearchCombo(sheetObj,sCondition);
					//(Type,EQ Type) Setting combo
					for(var i=0; i<comboList.length ; i++){
						if(comboList[i] != null){
							var sheetComboText="";
							var sheetComboCode="";
							var sheetComboDefault="";
							for(var j=0; j < comboList[i].length;j++){
								var tempText=comboList[i][j].split("|");
								sheetComboText +=  tempText[1] + "|";
								sheetComboCode +=  tempText[0] + "|";
								if(j ==0){
									sheetComboDefault=tempText[0];
								}
								if(i==0) {
									mnr_xtra_disp_tp_cd.InsertItem(j, tempText[1] ,tempText[0]); //Type
								} else if(i==1) {
									eq_knd_cd.InsertItem(j, tempText[1], tempText[0]); //EQ Type
								} else if(i==2) {
									iss_ofc_cd.InsertItem(j, tempText[0], tempText[0]); //Request Office
								}
							}
							//Value setting of sheet combo
							if(i==0) {
								sheetObjects[0].InitDataCombo (0, "mnr_xtra_disp_tp_cd", sheetComboText, sheetComboCode ,sheetComboDefault);
							} else if(i==1) {
								sheetObjects[0].InitDataCombo (0, "eq_knd_cd", sheetComboText, sheetComboCode ,sheetComboDefault);
							}
						}
					}
					mnr_xtra_disp_tp_cd.InsertItem(0, "ALL" ,"A");
					eq_knd_cd.InsertItem(0, "ALL", "A");
					iss_ofc_cd.InsertItem(0, "ALL", "A");
	    		}
	    		// Value setting of initialize
	    		formObj.cre_dt_fr.value=ComGetDateAdd(ComGetNowInfo("ymd"), "y", -1);
	    		formObj.cre_dt_to.value=ComGetNowInfo("ymd");
	    		mnr_xtra_disp_tp_cd.SetSelectCode("A");//Type
	    		eq_knd_cd.SetSelectCode("A");//EQ Type
	    		eq_knd_cd.SetEnable(1);//EQ Type
	    		formObj.eq_no.value=""; 	  		//EQ No
	    		formObj.eq_no.readOnly=false;		//EQ No
	    		iss_ofc_cd.SetSelectCode(currOfcCd);//Creation Office
	    		MnrWaitControl(false);
	    		sheetObj.SetWaitImageVisible(1);
	    		break;
	    	//Retrieving
            case IBSEARCH:
                if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value=SEARCH;
					var sXml=sheetObj.GetSearchData("EES_MNR_0094GS.do",FormQueryString(formObj));
					sheetObj.LoadSearchData(sXml,{Sync:1} );
                }
                break;
        }
    }
    /**
     * Validating process for input form data
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
    		if (sAction == IBSEARCH) {
    			// Dataformat
    			if (!ComChkValid(formObj)) {
    				return false;
    			}
    		}
    		//EQ No Validation check
    		else if (sAction == IBSEARCH_ASYNC01) {
    			var eqKndCd=eq_knd_cd.GetSelectCode();
				if(eqKndCd == "" || eqKndCd == "A"){
					ComShowCodeMessage("MNR00119");
					ComSetObjValue(formObj.eq_no, "");
					eq_knd_cd.focus();
					return false;
				}
    		}
        }
        return true;
    }
