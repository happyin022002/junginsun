/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_MNR_0016.js
*@FileTitle  : M&R Agreement Inquiry_Pop Up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/13
=========================================================*/
	// Common global variable
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var comboValue="";
	var oldAgmtGrpList = "";
	var agmtGrpList = "";
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
				case "btn_retrieve":
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;
				case "btn_new":
					doActionIBSheet(sheetObject1,formObject,IBCLEAR);
					break;
				case "btn_ok":
					comPopupOK();
					break;
				case "btn_close":
					ComClosePopup(); 
					break;
				case "cre_dt_cal":
					var cal=new ComCalendarFromTo();
					cal.select(formObject.agmt_fm_dt, formObject.agmt_to_dt, 'yyyy-MM-dd');
					break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
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
		initControl()
		MnrWaitControl(true);
		agmtGrpList = getAgmtGrpList(sheetObjects[0], "A");
	    oldAgmtGrpList = agmtGrpList;
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i + 1);
            ComEndConfigSheet(sheetObjects[i]);
        }
	    for(var k=0;k<comboObjects.length;k++){
	        initCombo(comboObjects[k],k + 1);
	    }
		var formObj=document.form;
		doActionIBSheet(sheetObjects[0],formObj,IBCLEAR);
    }
    /**
	 * Combo Setting default
	 * @param	{IBMultiCombo}	combo_obj.
	 * @param	{Number}	comboNo		Sequence number from combo object tag id
	 */
	function initCombo (comboObj, comboNo) {
	    switch(comboNo) {
	        case 1:
	           	with (comboObj) {
				SetColAlign(0, "left");
				SetColAlign(1, "left");
				SetColWidth(0, "80");
				SetColWidth(1, "100");
			   	SetDropHeight(160);
				SetUseAutoComplete(1);
		    	}
	        	break;
	     }
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
	              var HeadTitle="|Sel|Seq|Regional\nH/O|AGMT\nOfc|EQ Type|AGMT\nNo||Tariff\nNo|Reference\nNo|Service\nProvider Code|Service\nProvider Name|Eff Date";
	              var headCount=ComCountHeadTitle(HeadTitle);
	              

				  oldAgmtGrpList = agmtGrpList;
				  var arrAgmtGrpList = "";
				  if (oldAgmtGrpList != "") {
					  arrAgmtGrpList = oldAgmtGrpList.split("|");
				  }
		
				  // handling header title by changing column
				  if (agmtGrpList != "") {
					  HeadTitle += "|" + oldAgmtGrpList;
				  }
					
	              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	              var headers = [ { Text:HeadTitle, Align:"Center"} ];
	              InitHeaders(headers, info);
	              var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"hdnStatus" },
		                     {Type:"Radio",     Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"checkbox" },
		                     {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"SEQ" },
		                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rhq_ofc",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"agmt_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"mnr_cd_dp_desc",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"agmt_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"agmt_ver_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"trf_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:0,   SaveName:"ref_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"vndr_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:140,  Align:"Left",    ColMerge:0,   SaveName:"vndr_lgl_eng_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:0,   SaveName:"eff_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
	              
	              var sCount = "";
					var x = 1;
		
					for (var i = 0; i < arrAgmtGrpList.length; i++) {
						if (arrAgmtGrpList.length > 1) {
							sCount = "chk" + x;
							cols.push({Type : "Text", Hidden : 0, Width : 60, Align : "Center", ColMerge : 0, SaveName : sCount, KeyField : 0, CalcLogic : "", Format : "", PointCount :0, UpdateEdit :0, InsertEdit :0});
							x++;
						}
					}
	               
	              InitColumns(cols);
	              SetEditable(1);
	              SetColProperty(0,"eff_dt", {Format:"####-##-##~####-##-##"} );
	              SetSelectionMode(smSelectionRow);
	              SetSheetHeight(332);
			   }
                break;
        }
    }
	function initControl() {
	    //Axon event handling 1. Catching event
	//    axon_event.addListenerForm  ('blur', 'obj_deactivate',  form);
	//    axon_event.addListenerFormat('focus',   'obj_activate',    form);
	    //axon_event.addListenerFormat('keypress', 'obj_keypress', 	form);
	}
    /**
     * Assigning array of IBSheet object
     * Array defined at the top of the source
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
	 * Assigning array of IBCombo object
	 * @param	{IBMultiCombo}	combo_obj
	 * Array defined at the top of the source
	 */
	function setComboObject(combo_obj){
    	comboObjects[comboCnt++]=combo_obj;
	}
	/**
	 * Disable event handling <br>
	 **/
	function obj_deactivate(){
		obj=ComGetEvent();
	    ComChkObjValid(ComGetEvent());
	}
	/**
	 * Enable event handling <br>
	 **/
	function obj_activate(){
	    ComClearSeparator(ComGetEvent());
	}
	/**
	 * Keypress event handling <br>
	 **/
	function obj_keypress(){
	    obj=ComGetEvent();
	    if(obj.dataformat == null) return;
	    window.defaultStatus=obj.dataformat;
	    switch(obj.dataformat) {
	        case "ymd":
	        case "int":
				ComKeyOnlyNumber(obj);
	            break;
	        case "float":
	            ComKeyOnlyNumber(obj, ".");
	            break;
	        case "eng":
	            ComKeyOnlyAlphabet();
				break;
	        case "engup":
	        	ComKeyOnlyAlphabet('uppernum','45');
	        break;
	    }
	}
	/**
	 * eq type : OnChange event
	 * @param {IBMultiCombo}  comboObj
	 * @param  {String}    Index_Code
	 * @param  {String}    Text
	 */
	function combo1_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
		var formObj=document.form;
		formObj.agmt_eq_type.value=comboObj.GetSelectCode();
		
		sheetObjects[0] = sheetObjects[0].Reset();
		sheetObj = sheetObjects[0];
	    agmtGrpList = getAgmtGrpList(sheetObjects[0], comboObj.GetSelectCode());
	    oldAgmtGrpList = agmtGrpList;
	    for(i=0;i<sheetObjects.length;i++){
	        ComConfigSheet (sheetObjects[i] );
	        initSheet(sheetObjects[i],i + 1);
	        ComEndConfigSheet(sheetObjects[i]);
	    }
	}
	/**
	 * ofc_cd : OnChange event
	 * @param {IBMultiCombo}  comboObj
	 * @param  {String}    Index_Code
	 * @param  {String}    Text
	 */
	function combo2_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
		var formObj=document.form;
		if(comboObj.GetSelectCode()=="A"){
			formObj.agmt_ofc_cd.value=formObj.ofc_cd.value;
		}else{
			formObj.agmt_ofc_cd.value=comboObj.GetSelectCode();
		}
	}
	/**
	 * sheet1 DblClick event
	 * @param {IBSheet}  sheetObj
	 * @param  {String}    Row   Row Index
	 * @param  {String}    Col   Col Index
	 */
	function sheet1_OnDblClick(sheetObj,Row,Col){
		sheetObj.SetCellValue(Row,1,"1");
		comPopupOK();
 	}
  	/**
     * Sheet related process processing
     * @param	{IBSheet}	sheetObj	Used sheet object
     * @param	{Form}		formObj		Used form object
     * @param	{Number}	sAction		Variable for diverge (Define from CoObject.js)
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        switch(sAction) {
            case IBSEARCH:      //Retrieving
                if(validateForm(sheetObj,formObj,sAction)){
					if(sheetObj.id =="sheet1"){
						formObj.f_cmd.value=SEARCH;
 		        		sheetObj.DoSearch("EES_MNR_0016GS.do",FormQueryString(formObj) );
					}
				}
                break;
			case IBCLEAR:        //Initializing
				MnrWaitControl(true);
			    sheetObj.SetWaitImageVisible(0);
				//Initializing sheet
				for(i=0;i<sheetObjects.length;i++){
					sheetObjects[i].RemoveAll();
		        }
				//Initializing combo
				for(var i=0; i < comboObjects.length;i++){
					comboObjects[i].RemoveAll();
				}
				var sCondition=new Array (
					new Array("MnrGenCd","","CUSTOM9"),	//Eq Kind
					new Array("MnrOfcGenInfo","","AGMT")	//Agreement Office
				);
				var comboList=MnrComSearchCombo(sheetObj,sCondition);
				//Setting combo data(Eq Kind,Agreement Office)
				for(var i=0; i < comboList.length;i++){
					if(comboList[i] != null){
						//Initializing each combo of sheets
						sheetComboText="";
						sheetComboCode="";
						for(var j=0; j < comboList[i].length;j++){
							var tempText=comboList[i][j].split("|");
							sheetComboText +=  tempText[1] + "|";
							sheetComboCode +=  tempText[0] + "|";
							//Eq Kind
							if(i==0) {
								combo1.InsertItem(j, tempText[1] ,tempText[0]);
							//Agreement Office
							} else if(i==1){
								combo2.InsertItem(j, tempText[1] ,tempText[0]);
							}
						}
					}
				}
				combo1.InsertItem(0, "ALL" ,"A" );
				combo1.SetSelectCode("A");
				combo2.InsertItem(0, "ALL" ,"A" );
				combo2.SetSelectCode("A");
				formObj.agmt_ofc_cd.value=formObj.ofc_cd.value;
				formObj.agmt_fm_dt.value=ComGetDateAdd(ComGetNowInfo("ymd"), "Y", -1);
				formObj.agmt_to_dt.value=ComGetNowInfo();
				sheetObj.SetWaitImageVisible(1);
				MnrWaitControl(false);
                break;
        }
    }
    /**
     * Validating process for input form data
     * @param	{IBSheet}	sheetObj	Used sheet object
     * @param	{Form}		formObj		Used form object
     * @param	{Number}	sAction		Variable for diverge (Define from CoObject.js)
     */
    function validateForm(sheetObj,formObj,sAction){
    	switch (sAction) {
	 	    case IBSEARCH: // Retrieving
		        with(formObj){
					if(formObj.agmt_fm_dt.value == "") {
						ComAlertFocus(formObj.agmt_fm_dt, ComGetMsg('MNR00003'));
						return;
					} else if(formObj.agmt_to_dt.value == "") {
						ComAlertFocus(formObj.agmt_to_dt, ComGetMsg('MNR00003'));
						return;
					}
		        }
			    break;
   	    }
		return true;
    }
