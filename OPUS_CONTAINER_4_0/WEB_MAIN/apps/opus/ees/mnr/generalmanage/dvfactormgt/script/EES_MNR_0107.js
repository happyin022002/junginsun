/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName:  :EES_MNR_0107.js
*@FileTitle  : DV Factor 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/19
=========================================================*/
/****************************************************************************************
  Eevent classification code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/* Developer's task	*/
/* ********* General Functions ************* */
// Common global variable
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
//Variable for saving status of clicked retrieve button
var retrieveClick=0;
// Defining event handler of button click */
document.onclick=processButtonClick;
	/**
	 * Event handler to diverge process by button name
	 */
    function processButtonClick(){
        /***** Adding variable of sheet object in case of more than 2 sheets per tabs *****/
        var sheetObject1=sheetObjects[0];
        var sheetObject2=sheetObjects[1];
        var sheetObject3=sheetObjects[2];
        /*******************************************************/
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
				switch(srcName) {
					case "btn_Retrieve":
						doActionIBSheet(sheetObject1,formObject,IBSEARCH);
						break;
					case "btn_Save":
						doActionIBSheet(sheetObject1,formObject,IBSAVE);
						break;
					case "btn_New":
						doActionIBSheet(sheetObject1,formObject,IBCLEAR);
						break;
					case "dpc_yr_cal":
						var cal=new ComCalendar();
						cal.setDisplayType('year');
						cal.select(formObject.eq_dpc_yr, 'yyyy');
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
    	//Setting button
    	MnrWaitControl(true);
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
            tabObjects[k].SetSelectedIndex(0);
        }
	    //Initializing event handler
	    initControl();
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		var formObject=document.form;
		formObject.eq_dpc_yr.focus();
    }
	function resizeSheet( sheetObj ){
	    ComResizeSheet( sheetObj );
	}
  	/**
     * Initializing variable for IBSheet and defining header
     * @param	{IBSheet}	sheetObj	IBSheet object for initial setting
     * @param	{String}	sheetNo		Sequence number from sheet object tag id
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		var sheetID=sheetObj.id;
        switch(sheetID) {
            case "t1sheet1":
                with(sheetObj){
               
			           var HeadTitle1="|Seq.|TP/SZ|Description|Currency|Max Depreciation Rate(%)|Monthly Depreciation Rate(%)|Price";
			           var headCount=ComCountHeadTitle(HeadTitle1);
			           (headCount+2, 0, 0, true);
			           SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			           var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			           var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			           InitHeaders(headers, info);
			           var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
							         {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
							         {Type:"Text",      Hidden:0,  Width:170,  Align:"Center",  ColMerge:1,   SaveName:"cd_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							         {Type:"Text",      Hidden:0,  Width:400,  Align:"Left",    ColMerge:1,   SaveName:"cd_desc",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							         {Type:"Text",      Hidden:0,  Width:180,  Align:"Center",  ColMerge:1,   SaveName:"curr_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							         {Type:"Float",     Hidden:0,  Width:200,  Align:"Right",   ColMerge:1,   SaveName:"max_dpc_rto",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
							         {Type:"Float",     Hidden:0,  Width:200,  Align:"Right",   ColMerge:1,   SaveName:"eq_dpc_rt",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:4,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
							         {Type:"Int",       Hidden:0,  Width:130,  Align:"Right",   ColMerge:1,   SaveName:"eq_init_prc",  KeyField:1,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:11 },
							         {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"eq_dpc_yr",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							         {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"eq_knd_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
			            
			           InitColumns(cols);
			           SetEditable(1);
			           SetCountPosition(0);
//			           SetSheetHeight(420);
			           SetSelectionMode(smSelectionRow);
			           resizeSheet( sheetObj );
          	  }
                break;
            case "t2sheet1":
                with(sheetObj){
               
			             var HeadTitle1="|Seq.|TP/SZ|Description|Currency|Max Depreciation Rate(%)|Monthly Depreciation Rate(%)|Price";
			             var headCount=ComCountHeadTitle(HeadTitle1);
			             (headCount+2, 0, 0, true);
			             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			             var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			             var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			             InitHeaders(headers, info);
			             var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			                 {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
			                 {Type:"Text",      Hidden:0,  Width:170,  Align:"Center",  ColMerge:1,   SaveName:"cd_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:400,  Align:"Left",    ColMerge:1,   SaveName:"cd_desc",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:180,  Align:"Center",  ColMerge:1,   SaveName:"curr_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Float",     Hidden:0,  Width:200,  Align:"Right",   ColMerge:1,   SaveName:"max_dpc_rto",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
			                 {Type:"Float",     Hidden:0,  Width:200,  Align:"Right",   ColMerge:1,   SaveName:"eq_dpc_rt",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:4,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
			                 {Type:"Int",       Hidden:0,  Width:130,  Align:"Right",   ColMerge:1,   SaveName:"eq_init_prc",  KeyField:1,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:11 },
			                 {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"eq_dpc_yr",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"eq_knd_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
			              
			             InitColumns(cols);			
			             SetEditable(1);
			             SetCountPosition(0);
			             SetSheetHeight(500);
			             SetSelectionMode(smSelectionRow);
               }
                break;
            case "t3sheet1":
                with(sheetObj){
               
			             var HeadTitle1="|Seq.|TP/SZ|Description|Currency|Max Depreciation Rate(%)|Monthly Depreciation Rate(%)|Price";
			             var headCount=ComCountHeadTitle(HeadTitle1);
			             (headCount+2, 0, 0, true);
			             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			             var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			             var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			             InitHeaders(headers, info);
			
			             var cols = [ 	 {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
						                 {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
						                 {Type:"Text",      Hidden:0,  Width:170,  Align:"Center",  ColMerge:1,   SaveName:"cd_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						                 {Type:"Text",      Hidden:0,  Width:400,  Align:"Left",    ColMerge:1,   SaveName:"cd_desc",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						                 {Type:"Text",      Hidden:0,  Width:180,  Align:"Center",  ColMerge:1,   SaveName:"curr_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						                 {Type:"Float",     Hidden:0,  Width:200,  Align:"Right",   ColMerge:1,   SaveName:"max_dpc_rto",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
						                 {Type:"Float",     Hidden:0,  Width:200,  Align:"Right",   ColMerge:1,   SaveName:"eq_dpc_rt",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:4,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
						                 {Type:"Int",       Hidden:0,  Width:130,  Align:"Right",   ColMerge:1,   SaveName:"eq_init_prc",  KeyField:1,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:11 },
						                 {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"eq_dpc_yr",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						                 {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"eq_knd_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
			              
			             InitColumns(cols);
			             SetEditable(1);
			             SetCountPosition(0);
			             SetSheetHeight(500);
			             SetSelectionMode(smSelectionRow);
             }
                break;
        }
    }
    /**
     * Tab Setting default
     * Setting tab's item
     */
    function initTab(tabObj , tabNo) {
         switch(tabNo) {
             case 1:
                with (tabObj) {
                    var cnt=0 ;
						InsertItem( "Container", "");
						InsertItem( "Chassis", "");
						InsertItem( "MG Set", "");
                }
             break;
         }
    }
	/**
	 * Defining event. <br>
	 **/
	function initControl() {
	    //Axon event handling 1. Catching event
//	    axon_event.addListenerForm  ('blur', 		'obj_deactivate',	document.form);
//	    axon_event.addListenerFormat('focus',  		'obj_activate',    	document.form);
	    //axon_event.addListenerForm	('keypress', 	'obj_keypress', 	document.form);
    }
    /**
     * Assigning array of IBSheet object
     * Array defined at the top of the source
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * Assigning array of IBTab object
     * Array defined at the top of the source
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++]=tab_obj;
    }
	/**
     * Onblur event handling <br>
     **/
    function obj_deactivate(){
        ComChkObjValid(ComGetEvent());
	}
	/**
     * Event handling of activate
     **/
	function obj_activate(){
	    ComClearSeparator(ComGetEvent());
	}
	/**
	 * Event handling of keypress
	 **/
//	function obj_keypress(){
//	    obj=event.srcElement;
//	    if(obj.dataformat == null) return;
//	    window.defaultStatus=obj.dataformat;
//	    switch(obj.dataformat) {
//	        case "yyyy":
//				ComKeyOnlyNumber(obj);
//	            break;
//	    }
//	}
  	/**
     * Sheet related process processing
     * @param	{IBSheet}	sheetObj	Used sheet object
     * @param	{Form}		formObj		Used form object
     * @param	{Number}	sAction		Variable for diverge (Define from CoObject.js)
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			case IBCLEAR:      // Initializing
				//Setting for button and progress bar
				sheetObj.SetWaitImageVisible(0);
				MnrWaitControl(true);
				var formObject=document.form;
				formObject.eq_dpc_yr.value="";
				//Initializing all sheet
			    for(i=0;i<sheetObjects.length;i++){
			    	sheetObjects[i].RemoveAll();
	            }
				//Initializing clicked status of retrieve button
				retrieveClick=0;
				var arrXml=MnrComSearchGrid(sheetObj,"type_size_search_ind");
				for(var i=0; i < arrXml.length; i++){
					sheetObjects[i].LoadSearchData(arrXml[i],{Sync:1} );
					
				}
				//inputting mandatory item
				for(var i=0; i < arrXml.length; i++){
					for(var j=1; j <=sheetObjects[i].RowCount(); j++){
						sheetObjects[i].SetCellValue(j, "curr_cd","USD",0);//Currency
						sheetObjects[i].SetCellValue(j, "eq_init_prc",0,0);//Price
						if(i==0) {
							sheetObjects[i].SetCellValue(j, "eq_dpc_rt",0.45,0);//Monthly Depreciation Rate(%)
							sheetObjects[i].SetCellValue(j, "max_dpc_rto", 50,0);//Max Depreciation Rate(%)
							sheetObjects[i].SetCellValue(j, "eq_knd_cd","U",0);//KindCode
						} else if (i==1) {
							sheetObjects[i].SetCellValue(j, "eq_dpc_rt",0.45,0);//Monthly Depreciation Rate(%)
							sheetObjects[i].SetCellValue(j, "max_dpc_rto", 50,0);//Max Depreciation Rate(%)
							sheetObjects[i].SetCellValue(j, "eq_knd_cd","Z",0);//KindCode
						} else if (i==2){
							sheetObjects[i].SetCellValue(j, "eq_dpc_rt",0.55,0);//Monthly Depreciation Rate(%)
							sheetObjects[i].SetCellValue(j, "max_dpc_rto", 50,0);//Max Depreciation Rate(%)
							sheetObjects[i].SetCellValue(j, "eq_knd_cd","G",0);//KindCode
						} else {
							ComShowCodeConfirm("MNR00028");
						}
					}
				}
				//====================================================================
				//Setting for button and progress bar
				MnrWaitControl(false);
				sheetObj.SetWaitImageVisible(1);
                break;
            case IBSEARCH:      //Retrieving
				formObj.f_cmd.value=SEARCH01;
                if(validateForm(sheetObj,formObj,sAction)) {
					//Retrieving multi data
                	var sXml=sheetObj.GetSearchData("EES_MNR_0107GS.do", FormQueryString(formObj));
					var arrXml=sXml.split("|$$|");
					for(var i=0; i < arrXml.length; i++){
						sheetObjects[i].LoadSearchData(arrXml[i],{Sync:1} );
					}
					retrieveClick=1;
			    }
                break;
            case IBSAVE:        //Saving
                if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value=MULTI;
					var sParam=ComGetSaveString(sheetObjects);
				    if (sParam == "") return;
				    sParam += "&" + FormQueryString(formObj);
				    var sXml=sheetObjects[0].GetSaveData("EES_MNR_0107GS.do", sParam);
				    sheetObjects[0].LoadSaveData(sXml);
				    sheetObjects[1].LoadSaveData(sXml);
				    sheetObjects[2].LoadSaveData(sXml);
				}
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
        with(formObj){
			var eqDpcYrObj=formObj.eq_dpc_yr; //Base year
			//Retrieving
			if(sAction==IBSEARCH) {
				if(!checkMandatory(eqDpcYrObj)){return false;}	//Mandatory
			}
			//Saving
			if(sAction==IBSAVE) {
				if(!checkMandatory(eqDpcYrObj)){return false;}	//Mandatory
				//In case of saving the data without retrieving
				if(retrieveClick==0) {
					if(!ComShowCodeConfirm("MNR00160")){return false;}
					setGridEqDpcYr(eqDpcYrObj); //Inputting base year
				//In case of saving the data after retrieving
				} else {
					var eqDpcYrCond=eqDpcYrObj.value;     						//Condition part Base year
					var eqDpcYrGrid=sheetObjects[0].GetCellValue(1, "eq_dpc_yr");	//Sheet part Base year
					if(eqDpcYrCond!=eqDpcYrGrid) {
						if(!ComShowCodeConfirm("MNR00160")){return false;} 
						setGridEqDpcYr(eqDpcYrObj); //Inputting base year
					}
				}
			}
        }
        return true;
    }
/* ********* User Functions ************* */
	/**
	 * Checking mandatory
	 * @param	{Object}	obj		Element object of form
	 * @return  {Boolean}   true/false
	 */
    function checkMandatory(obj) {
		if(ComIsEmpty(obj)) {
		    ComShowCodeMessage("MNR00003");
		    obj.focus();
		    return false;
		}
		return true;
	}
	/**
	 * Inputting base year
	 * Inputting base year at condition part of all sheet
	 * @param	{Object}	obj		Element object of form
	 */
	function setGridEqDpcYr(obj) {
		for(var i=0; i < sheetObjects.length; i++){
			for(var j=1; j <=sheetObjects[i].RowCount(); j++){
				sheetObjects[i].SetCellValue(j, "eq_dpc_yr",obj.value,0);
			}
		}
	}
/* ********* Event Functions ************* */
	/**
	 * Showing result message after saving
	 * @param	{IBSheet}	sheetObj	target object
	 * @param	{String}	ErrMsg
	 */
	function t1sheet1_OnSaveEnd(sheetObj,ErrMsg){
		if (ErrMsg == "") {
			ComShowCodeMessage("MNR00023",'');
		} else {
			ComShowCodeMessage("MNR00008",ErrMsg);
		}
	}
    /**
     * Event handling of changing tab
     * Activating tab for selected
     */
    function tab1_OnChange(tabObj , nItem) {
		selectedTab=nItem;
        var objs=document.all.item("tabLayer");
    	objs[nItem].style.display="Inline";
    	objs[beforetab].style.display="none";
    	 for(var i = 0; i<objs.length; i++){
		       if(i != nItem){
		        objs[i].style.display="none";
		        objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
		       }
		      }
    	beforetab=nItem;
    }
    
    function t1sheet1_OnChange(sheetObj,Row, Col, Value)	{
		if (sheetObj.ColSaveName(Col) == "eq_dpc_rt"){
			var val = sheetObj.GetCellValue(Row, Col);
			if(val > sheetObj.GetCellValue(Row, "max_dpc_rto")){
				ComShowCodeMessage('MNR00380', val+"%");
				sheetObj.SetCellValue(Row, Col, 0, 0);
				sheetObj.SelectCell(Row, Col);
				return false;
			}
		}
	}
    
    function t2sheet1_OnChange(sheetObj,Row, Col, Value)	{
    	if (sheetObj.ColSaveName(Col) == "eq_dpc_rt"){
			var val = sheetObj.GetCellValue(Row, Col);
			if(val > sheetObj.GetCellValue(Row, "max_dpc_rto")){
				ComShowCodeMessage('MNR00380', val+"%");
				sheetObj.SetCellValue(Row, Col, 0, 0);
				sheetObj.SelectCell(Row, Col);
				return false;
			}
		}
	}
    
    function t3sheet1_OnChange(sheetObj,Row, Col, Value)	{
    	if (sheetObj.ColSaveName(Col) == "eq_dpc_rt"){
			var val = sheetObj.GetCellValue(Row, Col);
			if(val > sheetObj.GetCellValue(Row, "max_dpc_rto")){
				ComShowCodeMessage('MNR00380', val+"%");
				sheetObj.SetCellValue(Row, Col, 0, 0);
				sheetObj.SelectCell(Row, Col);
				return false;
			}
		}
	}
/* End of developer's task */
