/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : EES_MNR_0011.js
 *@FileTitle  : MNR Local Tariff Creation & Verify
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/05/20
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
	var comboObjects=new Array();
	var comboCnt=0;
	var comboValue="";
	var saveType=0;  //0:save, 1:confirm, 2:Delete
	var searchType=0; //0:search, 1:load excel
	var comboListGrid=new Array();
	var sSaveRtnXml="";
	//Variable for handling tab menu
	var tabList=new Array();
	var uTab=new Array();
	var gTab=new Array();
	var zTab=new Array();
	var initflag=false;
	// Defining event handler of button click */
	document.onclick=processButtonClick;
	/**
	 * Event handler to diverge process by button name
	 */
    function processButtonClick(){
        /***** Adding variable of sheet object in case of more than 2 sheets per tabs *****/
        var sheetObject7=sheetObjects[0];  //hidden sheet
        var sheetObject1=sheetObjects[1];
        var sheetObject2=sheetObjects[2];
        var sheetObject3=sheetObjects[3];
        var sheetObject4=sheetObjects[4];
        var sheetObject5=sheetObjects[5];
        var sheetObject6=sheetObjects[6];
        /*******************************************************/
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObject1,document.form,IBSEARCH);
					break;
				case "btn_New":
					doActionIBSheet(sheetObject2,document.form,IBCLEAR,1);
					break;
				case "btn_Delete":
					doActionIBSheet(sheetObject3,document.form,IBSAVE);
					break;
				case "btn_Save":
					doActionIBSheet(sheetObject1,document.form,IBSAVE);
					break;
				case "btn_Request":
					doActionIBSheet(sheetObject2,document.form,IBSAVE);
					break;
				case "btn_Copy":
					doActionIBSheet(sheetObject1,document.form,"COPY");
					break;
                //Tafiff No. PopUp
				case "trf_no_popup":
					ComOpenPopup('/opuscntr/EES_MNR_0188.do?mnr_trf_knd_cd=LCL', 1000, 520, 'setEES_MNR_0188', '0,1,1,1,1,1,1,1,1,1,1,1', true);
					break;
                //Eff.from Calendar
				case "eff_dt_cal":
					var status=combo1.GetSelectCode();
					if(status!="HA" && status!="HR") {
						var cal=new ComCalendar();
						cal.select(formObject.eff_dt, 'yyyy-MM-dd');
					}
					break;
                //S/Provider Code PopUp
				case "provider_popup":
					var status=combo1.GetSelectCode();
					if(status!="HA" && status!="HR") {
						ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 705, 550, 'setPopData_Sp', '1,0,1,1,1,1,1,1', true);
					}
					break;
				/** Dry All (S) **/
				case "btn_t1LoadExcel":
					doActionIBSheet(sheetObject1,formObject,IBLOADEXCEL);
					break;
				case "btn_t1DownExcel":
					if(sheetObject1.RowCount() < 1){//no data
 						ComShowCodeMessage("COM132501");
 					}else{
 						doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
 					}					
					break;
				/** Dry All (E) **/
				/** Reefer Box (S) **/
				case "btn_t2LoadExcel":
					doActionIBSheet(sheetObject2,formObject,IBLOADEXCEL);
					break;
				case "btn_t2DownExcel":
					if(sheetObject2.RowCount() < 1){//no data
 						ComShowCodeMessage("COM132501");
 					}else{
 						doActionIBSheet(sheetObject2,formObject,IBDOWNEXCEL);
 					}					
					break;
				/** Reefer Box (E) **/
				/** Reefer Unit (S) **/
				case "btn_t3LoadExcel":
					doActionIBSheet(sheetObject3,formObject,IBLOADEXCEL);
					break;
				case "btn_t3DownExcel":
					if(sheetObject3.RowCount() < 1){//no data
 						ComShowCodeMessage("COM132501");
 					}else{
 						doActionIBSheet(sheetObject3,formObject,IBDOWNEXCEL);
 					}					
					break;
				/** Reefer Unit (E) **/
				/** Special Dry (S) **/
				case "btn_t4LoadExcel":
					doActionIBSheet(sheetObject4,formObject,IBLOADEXCEL);
					break;
				case "btn_t4DownExcel":
					if(sheetObject4.RowCount() < 1){//no data
 						ComShowCodeMessage("COM132501");
 					}else{
 						doActionIBSheet(sheetObject4,formObject,IBDOWNEXCEL);
 					}					
					break;
				/** Special Dry (E) **/
				/** Chassis (S) **/
				case "btn_t5LoadExcel":
					doActionIBSheet(sheetObject1,formObject,IBLOADEXCEL);
					break;
				case "btn_t5DownExcel":
					if(sheetObject1.RowCount() < 1){//no data
 						ComShowCodeMessage("COM132501");
 					}else{
 						doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
 					}
					break;
				/** Chassis (E) **/
				/** MG Set (S) **/
				case "btn_t6LoadExcel":
					doActionIBSheet(sheetObject1,formObject,IBLOADEXCEL);
					break;
				case "btn_t6DownExcel":
					if(sheetObject1.RowCount() < 1){//no data
 						ComShowCodeMessage("COM132501");
 					}else{
 						doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
 					}					
					break;
				/** MG Set (E) **/
			}
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
		//Axon Initializing event
		initControl();
		//Initializing IBMultiCombo
 	    for(var k=0; k < comboObjects.length; k++){
 	        initCombo(comboObjects[k], k + 1);
 	    }
 	    for(var k=0;k<tabObjects.length;k++){
			initTab(tabObjects[k],k+1);
			tabObjects[0].SetSelectedIndex(0);
		}
        for(i=1;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i]);
            ComEndConfigSheet(sheetObjects[i]);
        }
        resizeSheet();
		setTabName();
		//Initializing screen
		doActionIBSheet(sheetObjects[1],document.form,IBCLEAR,0);
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
	    	case 3:
	            with (comboObj) {
	    			SetColAlign(0, "left");
				    SetDropHeight(160);
		        }
	            break;
	    	case 2:
	            with (comboObj) {
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "100");
					SetColWidth(1, "75");
		        }
	            break;
	     }
	}
    /**
     * Tab Setting default
     * Setting tab's item
     */
    function initTab(tabObj , disPlayArray) {
        with (tabObj) {
			RemoveAll();
			var cnt=0 ;
			for(var j=0; j < disPlayArray.length;j++){
				InsertItem( disPlayArray[j] , "");
		   	}
		}
        tabObj.SetSelectedIndex(0);
    }
  	/**
     * Initializing variable for IBSheet and defining header
     * param : sheetObj ==> sheet object, sheetNo ==> Sequence number from sheet object tag id
     * @param	{IBSheet}	sheetObj	IBSheet object for initial setting
     * @param	{String}	sheetNo		Sequence number from sheet object tag id
     */
    function initSheet(sheetObj) {
        var cnt=0;
		var sheetid=sheetObj.id;
		switch(sheetid) {
            case "t1sheet1":
			case "t2sheet1":
			case "t3sheet1":
			case "t4sheet1":
			case "t5sheet1":
			case "t6sheet1":
				with(sheetObj){
					var HeadTitle1="|Seq.||Mandatory|Mandatory|Option|Description|Range Type|Volume|Volume|Volume|Limitation|Limitation|Man-Hour||Material|Component Group|Remark(s)";
					var HeadTitle2="|Seq.||Component|Repair|Division|Description|Range Type|Type|Q'ty|Size/Square|Min|Max|Man-Hour||Material|Component Group|Remark(s)";
					var headCount=ComCountHeadTitle(HeadTitle1);
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
					 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:1,   SaveName:"cost_grp_cd" },
					 {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"eq_cmpo_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
					 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"eq_rpr_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
					 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trf_div_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"dtl_desc",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Combo",     Hidden:0, Width:90,   Align:"Left",    ColMerge:1,   SaveName:"mnr_rng_tp_cd_view",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Combo",     Hidden:0, Width:60,   Align:"Left",    ColMerge:1,   SaveName:"vol_tp_cd_view",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"rpr_qty",             KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
					 {Type:"Int",       Hidden:0,  Width:85,   Align:"Right",   ColMerge:1,   SaveName:"rpr_sz_no",           KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
					 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"fm_rng_sz_no",        KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:8 },
					 {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"to_rng_sz_no",        KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:8 },
					 {Type:"Float",     Hidden:0,  Width:65,   Align:"Right",   ColMerge:1,   SaveName:"rpr_lbr_hrs",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
					 {Type:"Text",      Hidden:1, Width:113,  Align:"Right",   ColMerge:1,   SaveName:"mtrl_reco_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:18 },
					 {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"mtrl_cost_amt",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
					 {Type:"Text",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:1,   SaveName:"eq_cmpo_up_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:98,   Align:"Left",    ColMerge:1,   SaveName:"dtl_rmk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4000 },
					 {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"trf_no" },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Right",   ColMerge:1,   SaveName:"trf_dtl_seq" },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Right",   ColMerge:1,   SaveName:"inch_size" },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Right",   ColMerge:1,   SaveName:"cm_size" },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Right",   ColMerge:1,   SaveName:"inch_fm" },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Right",   ColMerge:1,   SaveName:"cm_fm" },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Right",   ColMerge:1,   SaveName:"inch_to" },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Right",   ColMerge:1,   SaveName:"cm_to" },
					 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:1,   SaveName:"mnr_rng_tp_cd" },
					 {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:1,   SaveName:"vol_tp_cd" },
					 {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:1,   SaveName:"std_trf_no" } ];
					   
					InitColumns(cols);
					SetSheetHeight(352);
					SetEditable(1);
					SetSelectionMode(smSelectionFree);
					SetShowButtonImage(2);
					SetRangeBackColor(1,3,1,5,"#555555")
					SetRangeBackColor(1,7,1,14,"#555555")
					
				}
                break;
                
			default:
				break;
        }
    }
    
    function resizeSheet(){
//    	for (i=0; i<sheetObjects.length; i++){
//    		ComResizeSheet(sheetObjects[i], 75);
//    	}
    }

    /**
	 * Defining event. <br>
	 **/
	function initControl() {
	 //   axon_event.addListenerForm  ('blur', 		'obj_blur',		document.form);
	 //   axon_event.addListenerFormat('focus',  		'obj_focus',    document.form);
	    //axon_event.addListenerForm	('keypress',	'obj_keypress', document.form);
	    axon_event.addListenerFormat('change',	 	'obj_change',	document.form);
    }
	/**
	 * Assigning array of IBCombo object
	 * @param    {IBCombo}	combo_obj        Registered as an array IBCombo Object
	 */
    function setComboObject(combo_obj){
 		comboObjects[comboCnt++]=combo_obj;
 	}
    /**
     * Assigning array of IBTab object
     * Array defined at the top of the source
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++]=tab_obj;
    }
	/**
	 * Assigning array of IBSheet object
     * Array defined at the top of the source
	 * @param    {IBSheet}	sheet_obj        Registered as an array IBSheet Object
	 */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
	/**
     * Onblur event handling <br>
     **/
    function obj_blur(){
		ComChkObjValid(event.srcElement);
	}
	/**
     * OnFocus event handling <br>
     **/
    function obj_focus(){
		ComClearSeparator(event.srcElement);
    }
	/**
	 * OnKeypress event handling <br>
	 **/
	function obj_keypress(){
		obj=ComGetEvent();//event.srcElement;
	    if(obj.dataformat == null) return;
	    window.defaultStatus=obj.dataformat;
		switch(obj.dataformat) {
	        case "engup":
	          	if(obj.name=="vndr_seq"){
					ComKeyOnlyNumber(obj);
				} else {
					ComKeyOnlyAlphabet('uppernum','45');//"-"
				}
	            break;
			case "ymd":
				ComKeyOnlyNumber(ComGetEvent());
				break;
	    }
	}
	/**
	 * OnChange event handling <br>
	 **/
	function obj_change(){
		var obj=ComGetEvent();
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		if ( ComTrim(obj.value) != "" ) {
			switch(ComGetEvent("name")) {
	    		case "vndr_seq":
	        		doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC01);
				   	break;
			}
	    } else {
			switch(ComGetEvent("name")) {
	    		case "vndr_seq":
	        		formObj.vndr_nm.value="";
				   	break;
			}
		}
	}
	/**
	 * Event handling of Onchange of combo
	 * @param	{IBMultiCombo}	comboObj	Changed combo object
	 * @param	{Number}		Index_Code	Changed combo code
	 * @param	{String}		Text		Changed combo value
	 */
	function combo2_OnChange(comboObj,OldIdx, OldTxt, OldCod, NewIdx, NewTxt, NewCod){
		var formObj=document.form;
		var cnt=0;
		for (var i=1; i<sheetObjects.length; i++){
			cnt += sheetObjects[i].RowCount();
		}
		if(cnt>0) {
			if(!ComShowCodeConfirm("MNR00192")) {
				comboObj.SetSelectCode(comboValue,false);
				return;
			}
			//Initializing all sheet
		    for(i=1;i<sheetObjects.length;i++){
		    	sheetObjects[i].RemoveAll();
            }
			//Resetting combo of sheet
			setSheetCombo(sheetObjects[1]);
		}
		//EQ Type
		comboValue=comboObj.GetSelectCode();
		//Resetting tab, Re-retrieving data of combo of sheet
		if(comboValue=="U") {
			initTab(tabObjects[0],uTab);
			setSheetCombo(sheetObjects[1]);
		} else if(comboValue=="Z") {
			initTab(tabObjects[0],zTab);
			setSheetCombo(sheetObjects[1]);
		} else if(comboValue=="G") {
			initTab(tabObjects[0],gTab);
			setSheetCombo(sheetObjects[1]);
		}
		//only process After DefaultSearch
		if(searchType==2) {
			//default search
			searchDefault(sheetObjects[1]);
		}
		//Setting default value of EQ_TYPE
		var defUnitOfMeasure=MnrDefaultUnitOfMeasure(sheetObjects[1],comboObj.GetSelectCode());
		combo3.SetSelectCode(defUnitOfMeasure,false);//UnitOfMass
	}
	/**
	 * Event handling of Onchange of combo
	 *     Resetting Size/Square when changing unit of measure by inch/cm
	 *
	 * @param	{IBMultiCombo}	comboObj	Changed combo object
	 * @param	{Number}		Index_Code	Changed combo code
	 * @param	{String}		Text		Changed combo value
	 */
	function combo3_OnChange(comboObj,OldIdx, OldTxt, OldCod, NewIdx, NewTxt, NewCod){
		if(initflag == false){
			var mnrMeasUtCd=NewCod;
			if(mnrMeasUtCd == "INC") {
				for (var i=1; i<sheetObjects.length; i++){
					for(var j=sheetObjects[i].HeaderRows(); j<=sheetObjects[i].LastRow(); j++) {
						var volTpCd=sheetObjects[i].GetCellValue(j, "vol_tp_cd");
						if(volTpCd != "Q") {
							var inchSize=sheetObjects[i].GetCellValue(j, "inch_size");
							var inchFm=sheetObjects[i].GetCellValue(j, "inch_fm");
							var inchTo=sheetObjects[i].GetCellValue(j, "inch_to");
							sheetObjects[i].SetCellValue(j, "rpr_sz_no",inchSize);
							sheetObjects[i].SetCellValue(j, "fm_rng_sz_no",inchFm);
							sheetObjects[i].SetCellValue(j, "to_rng_sz_no",inchTo);
						}
					}
				}
			} else if(mnrMeasUtCd == "CMT"){
				for (var i=1; i<sheetObjects.length; i++){
					for(var j=sheetObjects[i].HeaderRows(); j<=sheetObjects[i].LastRow(); j++) {
						var volTpCd=sheetObjects[i].GetCellValue(j, "vol_tp_cd");
						if(volTpCd != "Q") {
							var cmSize=sheetObjects[i].GetCellValue(j, "cm_size");
							var cmFm=sheetObjects[i].GetCellValue(j, "cm_fm");
							var cmTo=sheetObjects[i].GetCellValue(j, "cm_to");
							sheetObjects[i].SetCellValue(j, "rpr_sz_no",cmSize);
							sheetObjects[i].SetCellValue(j, "fm_rng_sz_no",cmFm);
							sheetObjects[i].SetCellValue(j, "to_rng_sz_no",cmTo);
						}
					}
				}
			} else {
				ComShowCodeMessage("MNR00010", "Unit Of Measure");
			}
		}
	}
    /**
     * Event handling of changing tab
     * Activating tab for selected
     */
    function tab1_OnChange(tabObj , nItem){
        var objs=document.all.item("tabLayer");
    	objs[nItem].style.display="Inline";
    	//objs[beforetab].style.display="none";
    	for(var i = 0; i<objs.length; i++){
    		if(i != nItem){
    			objs[i].style.display="none";
    			objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
    		}
    	}
    	//--------------- Important logic --------------------------//
    	//objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
    	//------------------------------------------------------//
    	beforetab=nItem;
    	resizeSheet();
    }
	/**
	 * Setting after retrieving
	 * @param	{IBSheet}	sheetObj	sheet object
	 * @param	{String}	ErrMsg
	 */
	function t1sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		if(!checkIsDetailRow()) {return;}
		doAfterSearch();
	}
	/**
	 * Setting after retrieving
	 * @param	{IBSheet}	sheetObj	sheet object
	 * @param	{String}	ErrMsg
	 */
	function t2sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		if(!checkIsDetailRow()) {return;}
		doAfterSearch();
	}
	/**
	 * Setting after retrieving
	 * @param	{IBSheet}	sheetObj	sheet object
	 * @param	{String}	ErrMsg
	 */
	function t3sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		if(!checkIsDetailRow()) {return;}
		doAfterSearch();
	}
	/**
	 * Setting after retrieving
	 * @param	{IBSheet}	sheetObj	sheet object
	 * @param	{String}	ErrMsg
	 */
	function t4sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		if(!checkIsDetailRow()) {return;}
		doAfterSearch();
	}
	/**
	 * Showing result message after saving
	 * @param	{IBSheet}	sheetObj	target object
	 * @param	{String}	ErrMsg
	 */
	function t1sheet1_OnSaveEnd(sheetObj,ErrMsg){
		if (ErrMsg == "") {
			//0:save, 1:request, 2:Delete
			if(saveType==0) {
				ComShowCodeMessage("MNR00023");
			} else if (saveType==1) {
				ComShowCodeMessage("MNR00034");
			} else if (saveType==2) {
				ComShowCodeMessage("MNR00020");
			}
			doAfterSave();
		}
	}
  	/**
     * Sheet related process processing
     * @param	{IBSheet}	sheetObj	Used sheet object
     * @param	{Form}		formObj		Used form object
     * @param	{Number}	sAction		Variable for diverge (Define from CoObject.js)
     */
    function doActionIBSheet(sheetObj,formObj,sAction,sActionIdx) {
        switch(sAction) {
			//Initializing
			case IBCLEAR:
				//Setting for button and progress bar
				sheetObj.SetWaitImageVisible(1);
				MnrWaitControl(true);
				initflag=true;
	    		// Initializing all sheet
	    		for (i=0; i < sheetObjects.length; i++) {
	    			sheetObjects[i].RemoveAll();
	    		}
				if(sActionIdx==0) {
		        	//Initializing all combo
					for(var i=0; i < comboObjects.length;i++){
						comboObjects[i].RemoveAll();
					}
					//Retrieving combo data(UnitOfMass, Currency)
					var sCondition=new Array (
						new Array("MnrGenCd","CD00007", "COMMON"), 	//Status
						new Array("MnrGenCd","","CUSTOM9"),  	//EQ Type
						new Array("MdmCurrency","", "COMMON"),		//Currency
						new Array("MnrGenCd","CD00010", "COMMON"), 	//UnitOfMass
						new Array("MnrGenCd","CD00012", "COMMON"),	//RangeType
						new Array("MnrGenCd","CD00013", "COMMON")	//Type
					)
					var comboList=MnrComSearchCombo(sheetObj,sCondition);
					var sheetComboText="";
					var sheetComboCode="";
					var sheetComboDefault="";
					var comboSaveNames=new Array();
					comboSaveNames[0]="mnr_rng_tp_cd_view";
					comboSaveNames[1]="vol_tp_cd_view";
					//Setting combo data
					for(var i=0; i<comboList.length ; i++){
						if(comboList[i] != null){
							//Initializing each combo of sheets
							sheetComboText="";
							sheetComboCode="";
							sheetComboCodeText="";
							sheetComboDefault="";
							//Display[CODE_NAME]:Status,UnitOfMass
							if(i==0 || i==1 || i==3) {
								for(var j=0; j < comboList[i].length;j++){
									var tempText=comboList[i][j].split("|");
									//Status
									if(i==0) {
										combo1.InsertItem(j, tempText[1] ,tempText[0]);
									//EQ Type
									} else if(i==1) {
										combo2.InsertItem(j, tempText[1] ,tempText[0]);
									//UnitOfMass
									} else if(i==3){
										combo3.InsertItem(j, tempText[1] ,tempText[0]);
									}
								}
							//Display[CODE]:Currency
							} else if(i==2){
								for(var j=0; j < comboList[i].length;j++){
									combo4.InsertItem(j, comboList[i][j] ,j);
								}
							//Setting each combo of sheets
							} else if (i==4||i==5) {
								for(var j=0; j < comboList[i].length;j++){
									var tempText=comboList[i][j].split("|");
									sheetComboText +=  tempText[1] + "|";
									sheetComboCode +=  tempText[0] + "|";
									sheetComboCodeText +=  tempText[0] + "\t" + tempText[1] + "|";
									if(j ==0){
										sheetComboDefault=tempText[0];
									}
								}
							}
							//Setting each combo of sheets
							for(var k=1; k<sheetObjects.length; k++) {
								if(i==4||i==5) {
									sheetObjects[k].InitDataCombo (0, comboSaveNames[i-4], sheetComboText, sheetComboCode ,sheetComboDefault);
								}
							}
						}
					}
				}
				//Setting initial value for combo
				combo1.SetSelectCode("");//Status
				combo4.SetSelectText("USD");//Currency
				combo2.SetSelectCode("U");//EQ Type
				//Setting value after retrieving "EQ_TYPE"
				var defUnitOfMeasure=MnrDefaultUnitOfMeasure(sheetObj,combo2.GetSelectCode());
				combo3.SetSelectCode(defUnitOfMeasure);//UnitOfMass
				//Initializing condition value
				if(sheetObj.id == 't1sheet1') {	//Tariff No Road
					formObj.search_trf_no.value="";
				} else {						//Tariff No New/Copy
					formObj.search_trf_no.value="NEW";
				}
				formObj.trf_no.value="NEW"; 				//Tariff No for Save
				formObj.search_trf_no.readOnly=false;				//Tariff No ReadOnly
				formObj.search_trf_no.className="input1";				//Tariff No Class
				formObj.rqst_ofc_cd.value=currOfcCd;			//Tariff Office
				formObj.cre_usr_id.value=usrId;				//Creation User
				formObj.cre_dt.value=ComGetNowInfo("ymd");	//Creation Date
				formObj.vndr_seq.value="";					//S/P Code
				formObj.vndr_nm.value="";					//S/P Name
				formObj.vndr_seq.readOnly=false;				//S/P Code
				formObj.vndr_seq.className="input1";				//S/P Code
				formObj.eff_dt.value=ComGetNowInfo("ymd");	//Eff.from
				formObj.eff_dt.readOnly=false;				//Eff.from
				formObj.eff_dt.className="input1";				//Eff.from
				formObj.mnr_trf_sts_cd.value="";					//Tariff Status
				formObj.mnr_trf_rmk.value="";					//Remark(s)
				formObj.mnr_inp_tp_cd.value="";
				formObj.std_trf_no.value="";					//Standard Tariff No
				//Default Search////////
				searchDefault(sheetObj);
				////////////////////////
				//Status,EQ Type,UnitOfMeasure,Currency setting enable of combo
				combo1.SetEnable(0);//Status
				combo2.SetEnable(1);//EQ Type
				combo3.SetEnable(1);//Unit Of Measue
				combo4.SetEnable(1);//Cur
				sheetObj.SetWaitImageVisible(0);
                initflag=false;
				document.form.search_trf_no.focus();
				//Setting for button and progress bar
				MnrWaitControl(false);
				//Setting button option
				setButtonEnDisable();
				break;
			//Retrieving
            case IBSEARCH:
				sheetObj.SetWaitImageVisible(1);
				formObj.f_cmd.value=SEARCH;
                if(validateForm(sheetObj,formObj,sAction)) {
					//Retrieving multi data
                	var sXml=sheetObj.GetSearchData("EES_MNR_0014GS.do", FormQueryString(formObj));
					var arrXml=sXml.split("|$$|");
					//Header
					var arrResult=MnrXmlToArray(arrXml[0]);
					if(arrResult != null){
						formObj.trf_no.value=arrResult[0][19];	//triff No
						formObj.eff_dt.value=arrResult[0][6];  //Contract date
						formObj.rqst_ofc_cd.value=arrResult[0][4];	//Tariff Office
						formObj.vndr_seq.value=arrResult[0][1];	//S/Provider Code
						formObj.vndr_nm.value=arrResult[0][2];	//S/Provider Name
						formObj.cre_dt.value=arrResult[0][9];  //Creation date
						formObj.cre_usr_id.value=arrResult[0][14]; //Creation User ID
						formObj.vndr_seq.value=arrResult[0][1];  //Vendor Sequence
						if(arrResult[0][1] != "") {
							doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC01);
						}
						formObj.mnr_trf_sts_cd.value=arrResult[0][23]; //Tariff Status Code
						formObj.mnr_trf_rmk.value=arrResult[0][18];	//Remark(s)
						formObj.mnr_inp_tp_cd.value=arrResult[0][22];
						combo4.SetSelectText(arrResult[0][7]);//Currency
						combo1.SetSelectCode(arrResult[0][23]);//Tariff Status Code
						combo2.SetSelectCode(arrResult[0][24]);//EQ Type(U:CONTAINER,Z:CHASSIS,G:GENSET)
						combo3.SetSelectCode(arrResult[0][10]);//Unit Of Mass (CMT:CM, INC:inch)
						setButtonEnDisable();  //Setting button option
					} else {
						ComShowCodeMessage("MNR00204");
						doActionIBSheet(sheetObjects[0],document.form,IBCLEAR,1);
						formObj.search_trf_no.focus();
						return;
					}
					//0 vndr_seq|1 vndr_nm|2 agmt_no|3 rqst_ofc_cd|4 pagerows|5 eff_dt|6 curr_cd|7 ibflag|8 cre_dt|9 mnr_meas_ut_cd|10 upd_usr_id|11 apro_ofc_cd|12 cre_usr_id|13 mnr_trf_sts_dt|14 mnr_trf_knd_cd|15 sts_ref_no|16 mnr_trf_rmk|17 trf_no|18 cre_usr_nm|19 eq_knd_nm|20 mnr_inp_tp_cd|21 mnr_trf_sts_cd|22 eq_knd_cd|23 upd_dt|24 pre_trf_no|
					//vndr_seq|vndr_nm|agmt_no|rqst_ofc_cd|pagerows|eff_dt|curr_cd|ibflag|cre_dt|mnr_meas_ut_cd|upd_usr_id|apro_ofc_cd|cre_usr_id|mnr_trf_sts_dt|mnr_trf_knd_cd|sts_ref_no|mnr_trf_rmk|trf_no|cre_usr_nm|eq_knd_nm|mnr_inp_tp_cd|mnr_trf_sts_cd|eq_knd_cd|upd_dt|pre_trf_no
					//MnrXmlToArrayDebug('vndr_seq|vndr_nm|agmt_no|rqst_ofc_cd|pagerows|eff_dt|curr_cd|ibflag|cre_dt|mnr_meas_ut_cd|upd_usr_id|apro_ofc_cd|cre_usr_id|mnr_trf_sts_dt|mnr_trf_knd_cd|sts_ref_no|mnr_trf_rmk|trf_no|cre_usr_nm|eq_knd_nm|mnr_inp_tp_cd|mnr_trf_sts_cd|eq_knd_cd|upd_dt|pre_trf_no');
					//0 mnr_trf_sts_nm|1 vndr_seq|2 vndr_nm|3 agmt_no|4 rqst_ofc_cd|5 pagerows|6 eff_dt|7 curr_cd|8 ibflag|9 cre_dt|10 mnr_meas_ut_cd|11 mnr_trf_knd_nm|12 upd_usr_id|13 apro_ofc_cd|14 cre_usr_id|15 mnr_trf_sts_dt|16 mnr_trf_knd_cd|17 sts_ref_no|18 mnr_trf_rmk|19 trf_no|20 cre_usr_nm|21 eq_knd_nm|22 mnr_inp_tp_cd|23 mnr_trf_sts_cd|24 eq_knd_cd|25 mnr_meas_ut_nm|26 upd_dt|27 pre_trf_no
					//Detail
					var eqTypeCd=arrResult[0][24];
					searchType=0;
					if(eqTypeCd=="U") {
						for(var i=1; i < arrXml.length; i++){
							sheetObjects[i].LoadSearchData(arrXml[i],{Sync:1} );
						}
						setTabSelect(); //Selecting tab
					}
					else if (eqTypeCd=="Z") {
						sheetObjects[1].LoadSearchData(arrXml[5],{Sync:1} );
					}
					else if (eqTypeCd=="G") {
						sheetObjects[1].LoadSearchData(arrXml[6],{Sync:1} );
					}
				}
                break;
			//Retrieving(sevice provider No.)
			case IBSEARCH_ASYNC01:
				if ( validateForm(sheetObj, formObj, sAction) ) {
					formObj.vndr_seq.value=ComLpad(formObj.vndr_seq.value, 6, "0");
					//Service Provider Detail Information
					var sXml=MnrGetPartner(sheetObj,formObj.vndr_seq.value,"RPR");
					var vndrSeq=ComGetEtcData(sXml, "vndr_seq");
					if(vndrSeq != "" && vndrSeq != null && vndrSeq != "undefined"){
						//Setting vendor name
						ComSetObjValue(formObj.vndr_nm, ComGetEtcData(sXml, "vndr_lgl_eng_nm"));
						//Setting currency
						combo4.SetSelectText(ComGetEtcData(sXml, "pay_curr_cd"));
					} else {
						ComShowCodeMessage("MNR00005", "Service Provider");
						ComSetObjValue(formObj.vndr_nm, "");
						ComSetObjValue(formObj.vndr_seq, "");
						ComSetFocus(formObj.vndr_seq);
					}
				}
				break;
			//Saving
            case IBSAVE:
                if(validateForm(sheetObj,formObj,sAction)) {
                	sheetObj.SetWaitImageVisible(1);
					formObj.f_cmd.value=MULTI;
					//set Combo or Hidden Value;
					formObj.mnr_trf_sts_cd.value=combo1.GetSelectCode();  	//Status
					formObj.eq_knd_cd.value=combo2.GetSelectCode();  	//EQ Type
					formObj.eq_knd_nm.value=combo2.GetSelectText();  	//EQ Type Name
					formObj.mnr_meas_ut_cd.value=combo3.GetSelectCode();  	//Unit Of Mass
					formObj.curr_cd.value=combo4.GetSelectText();  	//Currency
					formObj.mnr_trf_knd_cd.value="LCL";  				 	//Displaying tariff type(STD:Standard Tariff, LCL:Local Tariff)
					var rqstOfcCd=formObj.rqst_ofc_cd.value;
					var preOfcCd=rqstOfcCd.trim().substring(0,3);
					formObj.pre_trf_no.value=preOfcCd+"("+comboValue+")-L-";	//Prefix of Tariff_No
					//Tariff Status Code  (SS:Save[SPP],SR:Request[SPP],SD:Delete[SPP],HR:Request,HS:Save,HJ:Reject,HD:Delete,HE:Expired,HA:Approval)
					//Save
					if(sheetObj.id == 't1sheet1') {
						formObj.mnr_trf_sts_cd.value="HS";
						saveType=0;
					}
					//Request
					else if (sheetObj.id == 't2sheet1') {
						formObj.mnr_trf_sts_cd.value="HR";
						setRowStausByConfirm();	//Occurring saving event
						saveType=1;
					}
					//Delete
					else {
						formObj.mnr_trf_sts_cd.value="HD";
						setRowStausByConfirm();	//Occurring saving event
						saveType=2;
					}
					//var sParam = ComGetSaveString(sheetObjects);
					var sParam="";
					for(var i=1; i<=4; i++) {
						if(sheetObjects[i].RowCount()> 0) {
							sParam=sParam + "&" +	MnrGetAllSaveText(sheetObjects[i], true, "ibflag");
						}
					}
					if (sParam == "") return;
				    sParam += "&" + FormQueryString(formObj);
				    //Retrieving tariff number
				    sSaveRtnXml=sheetObjects[1].GetSaveData("EES_MNR_0014GS.do", sParam);
				    sheetObjects[1].LoadSaveData(sSaveRtnXml);
				    sheetObj.SetWaitImageVisible(0);
				}
                break;
			//Copying
			case "COPY":
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.trf_no.value="NEW"; 				//trf_no for save
					formObj.search_trf_no.value="NEW";				//trf_no for search
					formObj.search_trf_no.className="input1";				//trf_no for search
					formObj.search_trf_no.readOnly=false;				//trf_no for search
					formObj.rqst_ofc_cd.value=currOfcCd;			//Tariff Office
					formObj.cre_usr_id.value=usrId;				//Creation User
					formObj.cre_dt.value=ComGetNowInfo("ymd");	//Creation Date
					formObj.vndr_seq.value="";					//S/P Code
					formObj.vndr_nm.value="";					//S/P Name
					formObj.vndr_seq.readOnly=false;				//S/P Code
					formObj.vndr_seq.className="input1";				//S/P Code
					formObj.eff_dt.value=ComGetNowInfo("ymd"); //Eff.from
					formObj.eff_dt.readOnly=false; 				//Eff.from
					formObj.eff_dt.className="input1"; 			//Eff.from
					formObj.mnr_trf_sts_cd.value="";					//Tariff Status
					combo1.SetSelectCode("");//Tariff Status
					combo2.SetEnable(0);//EQ Type
					combo4.SetEnable(1);//Cur
					combo3.SetEnable(1);//Unit Of Measure
					//Changing sheet status and tariff number
					setRowStausByCopy(formObj);
					//Enable setting of button
					setButtonEnDisable();
				}
				break;
            //Load Excel
			case IBLOADEXCEL:
				if(validateForm(sheetObj,formObj,sAction)) {
					var eqTypeCd=combo2.GetSelectCode(); 		//EQ Type
					var stdTrfNo=formObj.std_trf_no.value;	//Standard Tariff No
				    ComOpenPopup('/opuscntr/EES_MNR_0190.do?eqTypeCd='+eqTypeCd+"&programId=ees_mnr_0011"+"&stdTrfNo="+stdTrfNo, 1020, 591, 'setEES_MNR_190', 'none', true);
					searchType=1;
				}
				break;
            //Down Excel
			case IBDOWNEXCEL:
				var eqTypeCd=comboValue;
				if(eqTypeCd=="U"){
					sheetObjects[1].Down2ExcelBuffer(true);
					for(var i=1; i<=4; i++) {
						if(sheetObjects[i].RowCount()> 0){
							sheetObjects[i].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[i]), SheetDesign:1,Merge:1, SheetName:uTab[i-1] });
						}
					}
					sheetObjects[1].Down2ExcelBuffer(false);
				} else {
					sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
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
//        with(formObj){
			//At retrieving
			if(sAction==IBSEARCH){
				//Dataformat
				if (!ComChkValid(formObj)) {return false;}
			}
			//Saving
			else if(sAction==IBSAVE) {
				//Checking tariff status value
				if(!checkTariffStatus()) {return false;}
				//Mandatory field at saving
				if(!checkMandatory(formObj.eff_dt)) {return false;}
				if(!checkMandatory(formObj.vndr_seq)) {return false;}
				if(combo4.GetSelectText() == "") {
					ComShowCodeMessage("MNR00003", "Currency Code");
					return false;}
				//Checking grid row data
				if(!checkIsDetailRow()) {return false;}
  				//In case of "Delete button" click
				if(sheetObj.id == 't3sheet1'){
					var trfNo=document.form.trf_no.value
					if(trfNo=="NEW"){
						ComShowCodeMessage("MNR00199");
						return false;
					}
					if(!ComShowCodeConfirm("MNR00026")){return false}
				}
				//In case of "Request button" click
				if(sheetObj.id == 't2sheet1'){
					var trfNo=document.form.trf_no.value
					if(trfNo=="NEW"){
						ComShowCodeMessage("MNR00199");
						return false;
					}
					//Checking the "Eff.from" and "currency" and "Material"
					if(!checkMaterial()) { return false;}
				}
				//In case of "Save button" click
				if(sheetObj.id == 't1sheet1') {
					//Checking the "Eff.from" and "currency" and "Material"
					if(!checkMaterial()) { return false;}
				}
			}
			//In case of Copying
			else if (sAction=="COPY") {
				//Checking grid row data
				if(!checkIsDetailRow()) {return false;}
			}
			//Load Excel
			else if (sAction==IBLOADEXCEL) {
				//Checking tariff status value
				if(!checkTariffStatus()) {return false;}
			}
//        }
        return true;
    }
/* ********* User Functions ************* */
	/**
	 * Function that is called from the "EES_MNR_0188" pop-up screen
	 */
	function setEES_MNR_0188(aryPopupData, row, col, shhetIdx){
    	 var formObj=document.form;
		 if(aryPopupData[0][3] != null && aryPopupData[0][3] != "") {
    	 	formObj.search_trf_no.value=aryPopupData[0][3];
		 }
		 doActionIBSheet(sheetObjects[1],formObj,IBSEARCH);
	}
    /**
     * Checking mandatory data
     * @param	{Element}	obj : Form element for checking
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
	 * In case of saving : Checking grid row data
	 */
	function checkIsDetailRow(){
		var cnt=0;
		for (var i=1; i<sheetObjects.length; i++) {
			if(sheetObjects[i].RowCount()> 0) {
				cnt++;
			}
		}
		if(cnt<1) { return false}
		return true;
	}
	/**
	 * Changing status for retrieved data ("R" -> "U")
	 */
	function setRowStausByConfirm(){
		for (var i=1; i<sheetObjects.length; i++) {
			if(sheetObjects[i].RowCount()> 0) {
				for(var j=sheetObjects[i].HeaderRows(); j<=sheetObjects[i].LastRow(); j++) {
					if(sheetObjects[i].GetRowStatus(j)== "R") {
					    sheetObjects[i].SetRowStatus(j,"U");
						return;
					}
				}
			}
		}
	}
	/**
	 * Changing status for retrieved data ("D" -> "I")
	 * @param	{Form}		formObj
	 */
	function setRowStausByCopy(formObj){
		for (var i=1; i<sheetObjects.length; i++) {
			if(sheetObjects[i].RowCount()> 0) {
				for(var j=sheetObjects[i].HeaderRows(); j<=sheetObjects[i].LastRow(); j++) {
					if(sheetObjects[i].GetRowStatus(j)!= "D") {
					    sheetObjects[i].SetRowStatus(j,"I");
						sheetObjects[i].SetCellValue(j, "trf_no",formObj.trf_no.value,0);
					}
				}
			}
		}
	}
	/**
	 * Volume Type:Q -> Size/Square=0, 		Volume Type:S -> Q'ty=0
	 * @param	{IBSheet}	sheetObj	sheet object
	 * @param	{Int}		Row			Row
	 * @param	{String}	Val			Value
	 */
    function setEditableByVolumeType(sheetObj,Row){
    	var volTpCd=sheetObj.GetCellValue(Row, "vol_tp_cd");  //Volume Type
		//Q'ty
		if(volTpCd=='Q'){
			sheetObj.SetCellValue(Row, "rpr_sz_no","",0);
		//Size/Square
		} else {
			sheetObj.SetCellValue(Row, "rpr_qty","",0);
		}
	}
	/**
	 * Executing after retrieved
	 */
	function doAfterSearch() {
		var formObject=document.form;
		//search
		if(searchType==0) {
			formObject.search_trf_no.readOnly=true;		//Tariff No ReadOnly
			formObject.search_trf_no.className="input2";	//Tariff No Class
			combo2.SetEnable(0);//Disable editable status of EQ_TYPE field
			//Status(Tariff Approval)
			var status=combo1.GetSelectCode();
			if(status=="HA"||status=="HR") {
				formObject.vndr_seq.readOnly=true;		//S/P Code
				formObject.vndr_seq.className="input2";	//S/P Code
				formObject.eff_dt.readOnly=true;		//Eff.from
				formObject.eff_dt.className="input2";	//Eff.from
				combo4.SetEnable(0);//Curr
				combo3.SetEnable(0);//Unit Of Measure
			} else {
				formObject.vndr_seq.readOnly=false;	//S/P Code
				formObject.vndr_seq.className="input1";	//S/P Code
				formObject.eff_dt.readOnly=false;	//Eff.from
				formObject.eff_dt.className="input1";	//Eff.from
				combo4.SetEnable(1);//Curr
				combo3.SetEnable(1);//Unit Of Measure
			}
		}
		//load
		else if(searchType==1 ) {
			var trfNo=formObject.trf_no.value;
			if(trfNo=="" || trfNo==null || trfNo=="NEW") {
				setSheetStatus("I");
			} else {
				setSheetStatus("U");
			}
		}
		//default search
		else if(searchType==2) {
			setSheetStatus("I");
			setStdTrfNo();
		}
	}
	/**
	 * Executing after saved
	 */
	function doAfterSave() {
		//Initializing after Deleted
		if(saveType==2) {
			doActionIBSheet(sheetObjects[1],document.form,IBCLEAR,1);
		}
		//Retrieving after Saved
        else {
			var arrResult=MnrXmlToArray(sSaveRtnXml);
			document.form.search_trf_no.value=arrResult[0][19];
			doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
		}
		saveType=0;
	}
	/**
	 * Button to enable or disable
	 * (Delete, Save, Confirm, LoadExcel)
	 */
    function setButtonEnDisable() {
		var mnrTrfStsCd=document.form.mnr_trf_sts_cd.value;  //Tariff Status
		//HA:Approval, HR:Request
		if(mnrTrfStsCd=="HA" || mnrTrfStsCd=="HR"){
			ComBtnDisable("btn_Delete");
			ComBtnDisable("btn_Save");
			ComBtnDisable("btn_Request");
			ComBtnDisable("btn_t1LoadExcel");
			ComBtnDisable("btn_t2LoadExcel");
			ComBtnDisable("btn_t3LoadExcel");
			ComBtnDisable("btn_t4LoadExcel");
		} else {
			ComBtnEnable("btn_Delete");
			ComBtnEnable("btn_Save");
			ComBtnEnable("btn_Request");
			ComBtnEnable("btn_t1LoadExcel");
			ComBtnEnable("btn_t2LoadExcel");
			ComBtnEnable("btn_t3LoadExcel");
			ComBtnEnable("btn_t4LoadExcel");
		}
	}
	/**
	 * Checking tariff status
	 * @return  {Boolean}    true/false
	 */
	function checkTariffStatus() {
		var mnrTrfStsCd=document.form.mnr_trf_sts_cd.value; //mnr_trf_sts_cd
		if(mnrTrfStsCd=="HR"){
			ComShowCodeMessage("MNR00190","Tariff");
			return false;
		}
		return true;
	}
	/**
	 * Setting tab name
	 */
	function setTabName() {
		var sCondition=new Array (
			new Array("MnrGenCd","CC", "CUSTOM3")
		)
		tabList=MnrComSearchCombo(sheetObjects[1],sCondition);
		var uCnt=0;
		var gCnt=0;
		var zCnt=0;
		for(var i=0; i < tabList[0].length;i++){
			var tempText=tabList[0][i].split("|");
			if(tempText[0] == "U"){
				uTab[uCnt++]=tempText[1];
			}
			if(tempText[0] == "Z"){
				zTab[zCnt++]=tempText[1];
			}
			if(tempText[0] == "G"){
				gTab[gCnt++]=tempText[1];
			}
		}
	}
	/**
	 * Setting sheet combo
	 * @param	{IBSheet}	sheetObj	sheet object
	 */
	function setSheetCombo(sheetObj) {
		var sCondition=new Array (
			new Array("MnrGenCd","CD00012", "COMMON"),	//RangeType
			new Array("MnrGenCd","CD00013", "COMMON")	//Type
		)
		comboListGrid=MnrComSearchCombo(sheetObj,sCondition);
		var sheetComboText="";
		var sheetComboCode="";
		var sheetComboDefault="";
		var comboSaveNames=new Array();
		comboSaveNames[0]="mnr_rng_tp_cd_view";
		comboSaveNames[1]="vol_tp_cd_view";
		for(var i=0; i < comboListGrid.length;i++){
		 	if(comboListGrid[i] != null){
				//Initializing each combo of sheets
				sheetComboText="";
				sheetComboCode="";
				sheetComboCodeText="";
				sheetComboDefault="";
		 		for(var j=0; j < comboListGrid[i].length;j++){
					var tempText=comboListGrid[i][j].split("|");
					sheetComboText +=  tempText[1] + "|";
					sheetComboCode +=  tempText[0] + "|";
					sheetComboCodeText +=  tempText[0] + "\t" + tempText[1] + "|";
					if(j ==0){
						sheetComboDefault=tempText[0];
					}
				}
				for(var k=1; k<sheetObjects.length; k++) {
					sheetObjects[k].InitDataCombo (0, comboSaveNames[i], sheetComboText, sheetComboCode ,sheetComboDefault);
				}
			}
		}
		if (sheetComboText != "") {
	        sheetComboText=sheetComboText.substr(0, sheetComboText.length - 1);
		}
		if (sheetComboCode != "") {
	        sheetComboCode=sheetComboCode.substr(0, sheetComboCode.length - 1);
		}
		//Initializing all sheet
	    for(i=0;i<sheetObjects.length;i++){
	    	sheetObjects[i].RemoveAll();
        }
	}
	/**
	 * (Service Provider) Setting field by return value<br>
	 * @param aryPopupData : Return value array of popup screen
	 * @param Row : Row index
	 * @param Col : Column index
	 * @param SheetIdx : Sheet Array index
	 */
	function setPopData_Sp(aryPopupData, Row, Col, SheetIdx) {
		var formObj=document.form;
		if ( aryPopupData.length > 0 ) {
			formObj.vndr_seq.value=aryPopupData[0][2];
			formObj.vndr_nm.value=aryPopupData[0][4];
			var sXml=MnrGetPartner(sheetObjects[0],formObj.vndr_seq.value,"RPR");
			if(ComGetEtcData(sXml, "vndr_seq") != null){
				//Setting vendor name
				ComSetObjValue(formObj.vndr_nm, ComGetEtcData(sXml, "vndr_lgl_eng_nm"));
				//Setting Currency
				combo4.SetSelectText(ComGetEtcData(sXml, "pay_curr_cd"));
			} else {
				ComShowCodeMessage("MNR00005", "Service Provider");
				ComSetObjValue(formObj.vndr_nm, "");
				ComSetObjValue(formObj.vndr_seq, "");
				ComSetFocus(formObj.vndr_seq);
			}
		}
	}
	/**
	 * DEFAULT Retrieving data
	 * @param	{IBSheet}	sheetObj	sheet object
	 */
    function searchDefault(sheetObj) {
		//Default Search
		var formObj=document.form;
		formObj.f_cmd.value=SEARCH;
		formObj.eq_knd_cd.value=comboValue;
		//Retrieving multi data
		var sXml=sheetObj.GetSearchData("EES_MNR_0011GS.do", FormQueryString(formObj));
		var arrXml=sXml.split("|$$|");
		//Detail
		var eqTypeCd=comboValue;
		searchType=2;
		if(eqTypeCd=="U") {
			sheetObjects[1].LoadSearchData(arrXml[0],{Sync:1} );
			sheetObjects[2].LoadSearchData(arrXml[1],{Sync:1} );
			sheetObjects[3].LoadSearchData(arrXml[2],{Sync:1} );
			sheetObjects[4].LoadSearchData(arrXml[3],{Sync:1} );
		}
		else if (eqTypeCd=="Z") {
			sheetObjects[1].LoadSearchData(arrXml[4],{Sync:1} );
		}
		else if (eqTypeCd=="G") {
			sheetObjects[1].LoadSearchData(arrXml[5],{Sync:1} );
		}
	}
    /**
     * Checking material
     * @return
     */
    function checkMaterial() {
    	for (var i=1; i<sheetObjects.length; i++){
			if(sheetObjects[i].RowCount()> 0) {
				for(var j=sheetObjects[i].HeaderRows(); j<=sheetObjects[i].LastRow(); j++) {
					var mtrlCostAmt=sheetObjects[i].GetCellValue(j, "mtrl_cost_amt");
					if(mtrlCostAmt == "" || mtrlCostAmt == null) {
						if(!ComShowCodeConfirm("MNR00278")){
							sheetObjects[i].SelectCell(j, "mtrl_cost_amt");
							return false
						} else {
							return true;
						}
					}
				}
			}
	    }
		if(!ComShowCodeConfirm("MNR00279")){
			return false
		}else {
			return true;
		}
    }
    /**
     * Setting sheet status
     * @param status
     * @return
     */
    function setSheetStatus(status) {
		for(var i=1; i<sheetObjects.length; i++) {
			for(var j=sheetObjects[i].HeaderRows(); j<=sheetObjects[i].LastRow(); j++){
				sheetObjects[i].SetRowStatus(j,status);
			}
		}
    }
	/**
	 * Selecting tab
	 * @return
	 */
	function setTabSelect(){
		for (var i=1; i<=4; i++) {
			var rowCnt=sheetObjects[i].RowCount();
			if(rowCnt>0) {
				tabObjects[0].SetSelectedIndex((i-1));
				return;
			}
		}
	}
	/**
	 * Setting form data after retrieved "Standard Tariff No"
	 * @return
	 */
	function setStdTrfNo() {
		for (var i=1; i<=4; i++) {
			var rowCnt=sheetObjects[i].RowCount();
			if(rowCnt>0) {
				var stdTrfNo=sheetObjects[i].GetCellValue(sheetObjects[i].HeaderRows(), "std_trf_no");
				document.form.std_trf_no.value=stdTrfNo;
				return;
			}
		}
	}
	
	function setEES_MNR_190(rArray){
		sheetObjects[1].RemoveAll();
		sheetObjects[2].RemoveAll();
		sheetObjects[3].RemoveAll();
		sheetObjects[4].RemoveAll();
		//handling in popup.
		sheetObjects[1].LoadSearchData(rArray[0],{Sync:1} );
		sheetObjects[2].LoadSearchData(rArray[1],{Sync:1} );
		sheetObjects[3].LoadSearchData(rArray[2],{Sync:1} );
		sheetObjects[4].LoadSearchData(rArray[3],{Sync:1} );
    }
/* Developer's task	*/