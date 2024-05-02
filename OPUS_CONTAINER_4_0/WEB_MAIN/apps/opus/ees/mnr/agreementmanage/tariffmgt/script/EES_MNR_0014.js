/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : EES_MNR_0014.js
 *@FileTitle  : MNR Standard Tariff Creation and Inquiry
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/05/20
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
/* developer job	*/
/* ********* General Functions ************* */
	// common global variables
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
	//arraylist containing tab menu
	var tabList=new Array();
	var uTab=new Array();  
	var gTab=new Array(); 
	var zTab=new Array(); 
	var initflag=false;
	var dummyEvent=false;  
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	/** 
	 * Event handler processing by button name
	 */	
    function processButtonClick(){
        //var sheetObject7=sheetObjects[0];  //hidden sheet
        var sheetObject1=sheetObjects[0];
        var sheetObject2=sheetObjects[1];
        var sheetObject3=sheetObjects[2];
        var sheetObject4=sheetObjects[3];
        var sheetObject5=sheetObjects[4];
        var sheetObject6=sheetObjects[5];
        /*******************************************************/
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)){
				return false;
			}
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
				case "btn_Confirm":
					doActionIBSheet(sheetObject2,document.form,IBSAVE);
					break;
				case "btn_Copy":
					doActionIBSheet(sheetObject1,document.form,"COPY");
					break;
                //Tafiff No. PopUp
				case "trf_no_popup":
				    ComOpenPopup('/opuscntr/EES_MNR_0188.do?mnr_trf_knd_cd=STD', 1000, 520, 'setEES_MNR_0188', '0,1,1,1,1,1,1,1,1,1,1,1', true);
					break;
                //Eff.from Calendar
				case "eff_dt_cal":
					var status = combo1.GetSelectCode();
					if(status!="HA") {
						var cal=new ComCalendar();
						cal.select(formObject.eff_dt, 'yyyy-MM-dd');
					}
					break;
				/** Dry All (S) **/
				case "btn_t1Delete":
					doActionIBSheet(sheetObject1,formObject,IBDELETE);
					break;
				case "btn_t1RowAdd":
					doActionIBSheet(sheetObject1,formObject,IBINSERT);
					break;
				case "btn_t1RowCopy":
					doActionIBSheet(sheetObject1,formObject,IBCOPYROW);
					break;
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
				case "btn_t2Delete":
					doActionIBSheet(sheetObject2,formObject,IBDELETE);
					break;
				case "btn_t2RowAdd":
					doActionIBSheet(sheetObject2,formObject,IBINSERT);
					break;
				case "btn_t2RowCopy":
					doActionIBSheet(sheetObject2,formObject,IBCOPYROW);
					break;
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
				case "btn_t3Delete":
					doActionIBSheet(sheetObject3,formObject,IBDELETE);
					break;
				case "btn_t3RowAdd":
					doActionIBSheet(sheetObject3,formObject,IBINSERT);
					break;
				case "btn_t3RowCopy":
					doActionIBSheet(sheetObject3,formObject,IBCOPYROW);
					break;
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
				case "btn_t4Delete":
					if(ComGetBtnDisable(srcName)){
						return false;
					}
					doActionIBSheet(sheetObject4,formObject,IBDELETE);
					break;
				case "btn_t4RowAdd":
					if(ComGetBtnDisable(srcName)){
						return false;
					}
					doActionIBSheet(sheetObject4,formObject,IBINSERT);
					break;
				case "btn_t4RowCopy":
					if(ComGetBtnDisable(srcName)){
						return false;
					}
					doActionIBSheet(sheetObject4,formObject,IBCOPYROW);
					break;
				case "btn_t4LoadExcel":
					if(ComGetBtnDisable(srcName)){
						return false;
					}
					doActionIBSheet(sheetObject4,formObject,IBLOADEXCEL);
					break;
				case "btn_t4DownExcel":
					if(ComGetBtnDisable(srcName)){
						return false;
					}
					if(sheetObject4.RowCount() < 1){//no data
 						ComShowCodeMessage("COM132501");
 					}else{
 						doActionIBSheet(sheetObject4,formObject,IBDOWNEXCEL);
 					}					
					break;
				/** Special Dry (E) **/
				/** Chassis (S) **/
				case "btn_t5Delete":
					if(ComGetBtnDisable(srcName)){
						return false;
					}
					doActionIBSheet(sheetObject5,formObject,IBDELETE);
					break;
				case "btn_t5RowAdd":
					if(ComGetBtnDisable(srcName)){
						return false;
					}
					doActionIBSheet(sheetObject5,formObject,IBINSERT);
					break;
				case "btn_t5RowCopy":
					if(ComGetBtnDisable(srcName)){
						return false;
					}
					doActionIBSheet(sheetObject5,formObject,IBCOPYROW);
					break;
				case "btn_t5LoadExcel":
					if(ComGetBtnDisable(srcName)){
						return false;
					}
					doActionIBSheet(sheetObject1,formObject,IBLOADEXCEL);
					break;
				case "btn_t5DownExcel":
					if(ComGetBtnDisable(srcName)){
						return false;
					}
					if(sheetObject5.RowCount() < 1){//no data
 						ComShowCodeMessage("COM132501");
 					}else{
 						doActionIBSheet(sheetObject5,formObject,IBDOWNEXCEL);
 					}					
					break;
				/** Chassis (E) **/
				/** MG Set (S) **/
				case "btn_t6Delete":
					if(ComGetBtnDisable(srcName)){
						return false;
					}
					doActionIBSheet(sheetObject6,formObject,IBDELETE);
					break;
				case "btn_t6RowAdd":
					if(ComGetBtnDisable(srcName)){
						return false;
					}
					doActionIBSheet(sheetObject6,formObject,IBINSERT);
					break;
				case "btn_t6RowCopy":
					if(ComGetBtnDisable(srcName)){
						return false;
					}
					doActionIBSheet(sheetObject6,formObject,IBCOPYROW);
					break;
				case "btn_t6LoadExcel":
					if(ComGetBtnDisable(srcName)){
						return false;
					}
					doActionIBSheet(sheetObject6,formObject,IBLOADEXCEL);
					break;
				case "btn_t6DownExcel":
					if(ComGetBtnDisable(srcName)){
						return false;
					}
					if(sheetObject5.RowCount() < 1){//no data
 						ComShowCodeMessage("COM132501");
 					}else{
 						doActionIBSheet(sheetObject6,formObject,IBDOWNEXCEL);
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
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {

    	ComOpenWait(true);
        sheetObjects[0].SetWaitImageVisible(0);		
		setTimeout( function () {
		
			//setting button
	    	MnrWaitControl(true);
	        //initializing IBMultiCombo
	 	    for(var k=0; k < comboObjects.length; k++){
	 	        initCombo(comboObjects[k], k + 1);	       
	 	    }
	 	    for(var k=0;k<tabObjects.length;k++){
	 			initTab(tabObjects[k],k+1);
	 			tabObjects[0].SetSelectedIndex(0);
	 		}
	 	    //tab1_OnChange();
	 	   	//document.form.tab1.SetSelectedIndex(0);
			//starting i=1 because of hidden sheet
	        for(i=0;i<sheetObjects.length;i++){
	        	//
	            ComConfigSheet (sheetObjects[i] );
	            initSheet(sheetObjects[i]);
				//
	            ComEndConfigSheet(sheetObjects[i]);
	        }
			//initializing Axon event
			initControl();
			initflag=true;
			//setting tab name
			setTabName();
			// initializing event
			doActionIBSheet(sheetObjects[0],document.form,IBCLEAR,0);
			initflag=false;
			//set Focus
			document.form.search_trf_no.focus();
			
			sheetObjects[0].SetWaitImageVisible(1);    
	        ComOpenWait(false);
		} , 2000);
			
    }
  	/**
     * IBsetting combo basic info
     * @param	{IBCombo}	comboObj	initializing ComboObject 
     * @param	{Number}	comboNo		comboObjcet tag serial number
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
		        }
	            break;
	     } 
	}
    /**
     * initializing Tab
     * setting Tab items.
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
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     * @param	{IBSheet}	sheetObj	initial sheetObject 
     * @param	{String}	sheetNo		sheetObject tag serial number
     */
    function initSheet(sheetObj) {
        var cnt=0;
		var sheetid=sheetObj.id;
		switch(sheetid) {
            case "t1sheet1":
            	with(sheetObj){
					var HeadTitle1="|Sel|Seq.|Mandatory|Mandatory|Option|Description|Range Type|Volume|Volume|Volume|Limitation|Limitation|Man-Hour||Component Group|Remark(s)";
					var HeadTitle2="|Sel|Seq.|Component|Repair|Division|Description|Range Type|Type|Q'ty|Size/Square|Min|Max|Man-Hour||Component Group|Remark(s)";
					var headCount=ComCountHeadTitle(HeadTitle1);
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
					 {Type:"DummyCheck", Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"del_chk" },
					 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
					 {Type:"Combo", 	Hidden:0, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"eq_cmpo_cd",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
					 {Type:"Combo", 	Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"eq_rpr_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
					 {Type:"Text",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trf_div_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:230,  Align:"Left",    ColMerge:1,   SaveName:"dtl_desc",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:500 },
					 {Type:"Combo",     Hidden:0, Width:90,   Align:"Left",    ColMerge:1,   SaveName:"mnr_rng_tp_cd_view",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Combo",     Hidden:0, Width:60,   Align:"Left",    ColMerge:1,   SaveName:"vol_tp_cd_view",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"rpr_qty",             KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
					 {Type:"Text",       Hidden:0,  Width:85,   Align:"Right",   ColMerge:1,   SaveName:"rpr_sz_no",           KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
					 {Type:"Text",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"fm_rng_sz_no",        KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
					 {Type:"Text",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"to_rng_sz_no",        KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
					 {Type:"Text",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"rpr_lbr_hrs",         KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
					 {Type:"Text",      Hidden:1, Width:103,  Align:"Right",   ColMerge:1,   SaveName:"mtrl_reco_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
					 {Type:"Text",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:1,   SaveName:"eq_cmpo_up_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:83,   Align:"Left",    ColMerge:1,   SaveName:"dtl_rmk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4000 },
					 {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"trf_no" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:1,   SaveName:"trf_dtl_seq" },
					 {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"cost_grp_cd" },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Right",   ColMerge:1,   SaveName:"inch_size" },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Right",   ColMerge:1,   SaveName:"cm_size" },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Right",   ColMerge:1,   SaveName:"inch_fm" },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Right",   ColMerge:1,   SaveName:"cm_fm" },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Right",   ColMerge:1,   SaveName:"inch_to" },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Right",   ColMerge:1,   SaveName:"cm_to" },
					 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:1,   SaveName:"mnr_rng_tp_cd" },
					 {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:1,   SaveName:"vol_tp_cd" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:1,   SaveName:"div_flag" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:1,   SaveName:"rpr_flag" }];
					   
					InitColumns(cols);
					SetSheetHeight(392);
					SetEditable(1);
					SetColProperty(0 ,"eq_cmpo_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
					SetColProperty(0 ,"eq_rpr_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
					SetColProperty(0 ,"rpr_qty" , {AcceptKeys:"N" , InputCaseSensitive:1});
					SetColProperty(0 ,"rpr_sz_no" , {AcceptKeys:"N" , InputCaseSensitive:1});
					SetColProperty(0 ,"fm_rng_sz_no" , {AcceptKeys:"N" , InputCaseSensitive:1});
					SetColProperty(0 ,"to_rng_sz_no" , {AcceptKeys:"N" , InputCaseSensitive:1});
					SetColProperty(0 ,"rpr_lbr_hrs" , {AcceptKeys:"N|[.]" , InputCaseSensitive:1});
					
					SetRangeBackColor(1, 3, 1, 12,"#555555"); 
					SetSelectionMode(smSelectionRow);
					SetShowButtonImage(2);
					InitComboNoMatchText(1);
				}
            	break;
			case "t2sheet1":
				with(sheetObj){
					var HeadTitle1="|Sel|Seq.|Mandatory|Mandatory|Option|Description|Range Type|Volume|Volume|Volume|Limitation|Limitation|Man-Hour||Component Group|Remark(s)";
					var HeadTitle2="|Sel|Seq.|Component|Repair|Division|Description|Range Type|Type|Q'ty|Size/Square|Min|Max|Man-Hour||Component Group|Remark(s)";
					var headCount=ComCountHeadTitle(HeadTitle1);
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
					 {Type:"DummyCheck", Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"del_chk" },
					 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
					 {Type:"Combo", Hidden:0, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"eq_cmpo_cd",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
					 {Type:"Combo", Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"eq_rpr_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
					 {Type:"Text",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trf_div_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:230,  Align:"Left",    ColMerge:1,   SaveName:"dtl_desc",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:500 },
					 {Type:"Combo",     Hidden:0, Width:90,   Align:"Left",    ColMerge:1,   SaveName:"mnr_rng_tp_cd_view",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Combo",     Hidden:0, Width:60,   Align:"Left",    ColMerge:1,   SaveName:"vol_tp_cd_view",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"rpr_qty",             KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
					 {Type:"Text",       Hidden:0,  Width:85,   Align:"Right",   ColMerge:1,   SaveName:"rpr_sz_no",           KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
					 {Type:"Text",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"fm_rng_sz_no",        KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
					 {Type:"Text",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"to_rng_sz_no",        KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
					 {Type:"Text",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"rpr_lbr_hrs",         KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
					 {Type:"Text",      Hidden:1, Width:103,  Align:"Right",   ColMerge:1,   SaveName:"mtrl_reco_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
					 {Type:"Text",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:1,   SaveName:"eq_cmpo_up_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:83,   Align:"Left",    ColMerge:1,   SaveName:"dtl_rmk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4000 },
					 {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"trf_no" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:1,   SaveName:"trf_dtl_seq" },
					 {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"cost_grp_cd" },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Right",   ColMerge:1,   SaveName:"inch_size" },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Right",   ColMerge:1,   SaveName:"cm_size" },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Right",   ColMerge:1,   SaveName:"inch_fm" },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Right",   ColMerge:1,   SaveName:"cm_fm" },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Right",   ColMerge:1,   SaveName:"inch_to" },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Right",   ColMerge:1,   SaveName:"cm_to" },
					 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:1,   SaveName:"mnr_rng_tp_cd" },
					 {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:1,   SaveName:"vol_tp_cd" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:1,   SaveName:"div_flag" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:1,   SaveName:"rpr_flag" }];
					   
					InitColumns(cols);
					SetSheetHeight(392);
					SetEditable(1);
					SetColProperty(0 ,"eq_cmpo_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
					SetColProperty(0 ,"eq_rpr_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
					SetColProperty(0 ,"rpr_qty" , {AcceptKeys:"N" , InputCaseSensitive:1});
					SetColProperty(0 ,"rpr_sz_no" , {AcceptKeys:"N" , InputCaseSensitive:1});
					SetColProperty(0 ,"fm_rng_sz_no" , {AcceptKeys:"N" , InputCaseSensitive:1});
					SetColProperty(0 ,"to_rng_sz_no" , {AcceptKeys:"N" , InputCaseSensitive:1});
					SetColProperty(0 ,"rpr_lbr_hrs" , {AcceptKeys:"N|[.]" , InputCaseSensitive:1});
					SetRangeBackColor(1, 3, 1, 12,"#555555"); 
					SetSelectionMode(smSelectionRow);
					SetShowButtonImage(2);
					InitComboNoMatchText(1);
				}
				break;
			case "t3sheet1":
				with(sheetObj){
					var HeadTitle1="|Sel|Seq.|Mandatory|Mandatory|Option|Description|Range Type|Volume|Volume|Volume|Limitation|Limitation|Man-Hour||Component Group|Remark(s)";
					var HeadTitle2="|Sel|Seq.|Component|Repair|Division|Description|Range Type|Type|Q'ty|Size/Square|Min|Max|Man-Hour||Component Group|Remark(s)";
					var headCount=ComCountHeadTitle(HeadTitle1);
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
					 {Type:"DummyCheck", Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"del_chk" },
					 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
					 {Type:"Combo", Hidden:0, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"eq_cmpo_cd",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
					 {Type:"Combo", Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"eq_rpr_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
					 {Type:"Text",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trf_div_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:230,  Align:"Left",    ColMerge:1,   SaveName:"dtl_desc",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:500 },
					 {Type:"Combo",     Hidden:0, Width:90,   Align:"Left",    ColMerge:1,   SaveName:"mnr_rng_tp_cd_view",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Combo",     Hidden:0, Width:60,   Align:"Left",    ColMerge:1,   SaveName:"vol_tp_cd_view",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"rpr_qty",             KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
					 {Type:"Text",       Hidden:0,  Width:85,   Align:"Right",   ColMerge:1,   SaveName:"rpr_sz_no",           KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
					 {Type:"Text",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"fm_rng_sz_no",        KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
					 {Type:"Text",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"to_rng_sz_no",        KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
					 {Type:"Text",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"rpr_lbr_hrs",         KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
					 {Type:"Text",      Hidden:1, Width:103,  Align:"Right",   ColMerge:1,   SaveName:"mtrl_reco_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
					 {Type:"Text",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:1,   SaveName:"eq_cmpo_up_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:83,   Align:"Left",    ColMerge:1,   SaveName:"dtl_rmk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4000 },
					 {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"trf_no" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:1,   SaveName:"trf_dtl_seq" },
					 {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"cost_grp_cd" },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Right",   ColMerge:1,   SaveName:"inch_size" },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Right",   ColMerge:1,   SaveName:"cm_size" },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Right",   ColMerge:1,   SaveName:"inch_fm" },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Right",   ColMerge:1,   SaveName:"cm_fm" },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Right",   ColMerge:1,   SaveName:"inch_to" },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Right",   ColMerge:1,   SaveName:"cm_to" },
					 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:1,   SaveName:"mnr_rng_tp_cd" },
					 {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:1,   SaveName:"vol_tp_cd" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:1,   SaveName:"div_flag" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:1,   SaveName:"rpr_flag" }];
					   
					InitColumns(cols);
					SetSheetHeight(392);
					SetEditable(1);
					SetColProperty(0 ,"eq_cmpo_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
					SetColProperty(0 ,"eq_rpr_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
					SetColProperty(0 ,"rpr_qty" , {AcceptKeys:"N" , InputCaseSensitive:1});
					SetColProperty(0 ,"rpr_sz_no" , {AcceptKeys:"N" , InputCaseSensitive:1});
					SetColProperty(0 ,"fm_rng_sz_no" , {AcceptKeys:"N" , InputCaseSensitive:1});
					SetColProperty(0 ,"to_rng_sz_no" , {AcceptKeys:"N" , InputCaseSensitive:1});
					SetColProperty(0 ,"rpr_lbr_hrs" , {AcceptKeys:"N|[.]" , InputCaseSensitive:1});
					SetRangeBackColor(1, 3, 1, 12,"#555555"); 
					SetSelectionMode(smSelectionRow);
					SetShowButtonImage(2);
					InitComboNoMatchText(true);
				}
				break;
			case "t4sheet1":
				with(sheetObj){
					var HeadTitle1="|Sel|Seq.|Mandatory|Mandatory|Option|Description|Range Type|Volume|Volume|Volume|Limitation|Limitation|Man-Hour||Component Group|Remark(s)";
					var HeadTitle2="|Sel|Seq.|Component|Repair|Division|Description|Range Type|Type|Q'ty|Size/Square|Min|Max|Man-Hour||Component Group|Remark(s)";
					var headCount=ComCountHeadTitle(HeadTitle1);
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
					 {Type:"DummyCheck", Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"del_chk" },
					 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
					 {Type:"Combo", Hidden:0, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"eq_cmpo_cd",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
					 {Type:"Combo", Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"eq_rpr_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
					 {Type:"Text",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trf_div_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:230,  Align:"Left",    ColMerge:1,   SaveName:"dtl_desc",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:500 },
					 {Type:"Combo",     Hidden:0, Width:90,   Align:"Left",    ColMerge:1,   SaveName:"mnr_rng_tp_cd_view",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Combo",     Hidden:0, Width:60,   Align:"Left",    ColMerge:1,   SaveName:"vol_tp_cd_view",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"rpr_qty",             KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
					 {Type:"Text",       Hidden:0,  Width:85,   Align:"Right",   ColMerge:1,   SaveName:"rpr_sz_no",           KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
					 {Type:"Text",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"fm_rng_sz_no",        KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
					 {Type:"Text",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"to_rng_sz_no",        KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
					 {Type:"Text",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"rpr_lbr_hrs",         KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
					 {Type:"Text",      Hidden:1, Width:103,  Align:"Right",   ColMerge:1,   SaveName:"mtrl_reco_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
					 {Type:"Text",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:1,   SaveName:"eq_cmpo_up_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:83,   Align:"Left",    ColMerge:1,   SaveName:"dtl_rmk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4000 },
					 {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"trf_no" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:1,   SaveName:"trf_dtl_seq" },
					 {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"cost_grp_cd" },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Right",   ColMerge:1,   SaveName:"inch_size" },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Right",   ColMerge:1,   SaveName:"cm_size" },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Right",   ColMerge:1,   SaveName:"inch_fm" },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Right",   ColMerge:1,   SaveName:"cm_fm" },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Right",   ColMerge:1,   SaveName:"inch_to" },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Right",   ColMerge:1,   SaveName:"cm_to" },
					 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:1,   SaveName:"mnr_rng_tp_cd" },
					 {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:1,   SaveName:"vol_tp_cd" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:1,   SaveName:"div_flag" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:1,   SaveName:"rpr_flag" }];
					   
					InitColumns(cols);
					SetSheetHeight(392);
					SetEditable(1);
					SetColProperty(0 ,"eq_cmpo_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
					SetColProperty(0 ,"eq_rpr_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
					SetColProperty(0 ,"rpr_sz_no" , {AcceptKeys:"N" , InputCaseSensitive:1});
					SetColProperty(0 ,"fm_rng_sz_no" , {AcceptKeys:"N" , InputCaseSensitive:1});
					SetColProperty(0 ,"to_rng_sz_no" , {AcceptKeys:"N" , InputCaseSensitive:1});
					SetColProperty(0 ,"rpr_lbr_hrs" , {AcceptKeys:"N|[.]" , InputCaseSensitive:1});
					SetRangeBackColor(1, 3, 1, 12,"#555555"); 
					SetSelectionMode(smSelectionRow);
					SetShowButtonImage(2);
					InitComboNoMatchText(true);
				}
				break;
			case "t5sheet1":
				with(sheetObj){
					var HeadTitle1="|Sel|Seq.|Mandatory|Mandatory|Option|Description|Range Type|Volume|Volume|Volume|Limitation|Limitation|Man-Hour||Component Group|Remark(s)";
					var HeadTitle2="|Sel|Seq.|Component|Repair|Division|Description|Range Type|Type|Q'ty|Size/Square|Min|Max|Man-Hour||Component Group|Remark(s)";
					var headCount=ComCountHeadTitle(HeadTitle1);
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
					 {Type:"DummyCheck", Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"del_chk" },
					 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
					 {Type:"Combo", Hidden:0, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"eq_cmpo_cd",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
					 {Type:"Combo", Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"eq_rpr_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
					 {Type:"Text",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trf_div_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:230,  Align:"Left",    ColMerge:1,   SaveName:"dtl_desc",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:500 },
					 {Type:"Combo",     Hidden:0, Width:90,   Align:"Left",    ColMerge:1,   SaveName:"mnr_rng_tp_cd_view",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Combo",     Hidden:0, Width:60,   Align:"Left",    ColMerge:1,   SaveName:"vol_tp_cd_view",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"rpr_qty",             KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
					 {Type:"Text",       Hidden:0,  Width:85,   Align:"Right",   ColMerge:1,   SaveName:"rpr_sz_no",           KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
					 {Type:"Text",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"fm_rng_sz_no",        KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
					 {Type:"Text",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"to_rng_sz_no",        KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
					 {Type:"Text",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"rpr_lbr_hrs",         KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
					 {Type:"Text",      Hidden:1, Width:103,  Align:"Right",   ColMerge:1,   SaveName:"mtrl_reco_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
					 {Type:"Text",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:1,   SaveName:"eq_cmpo_up_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:83,   Align:"Left",    ColMerge:1,   SaveName:"dtl_rmk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4000 },
					 {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"trf_no" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:1,   SaveName:"trf_dtl_seq" },
					 {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"cost_grp_cd" },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Right",   ColMerge:1,   SaveName:"inch_size" },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Right",   ColMerge:1,   SaveName:"cm_size" },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Right",   ColMerge:1,   SaveName:"inch_fm" },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Right",   ColMerge:1,   SaveName:"cm_fm" },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Right",   ColMerge:1,   SaveName:"inch_to" },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Right",   ColMerge:1,   SaveName:"cm_to" },
					 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:1,   SaveName:"mnr_rng_tp_cd" },
					 {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:1,   SaveName:"vol_tp_cd" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:1,   SaveName:"div_flag" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:1,   SaveName:"rpr_flag" }];
					   
					InitColumns(cols);
					SetSheetHeight(392);
					SetEditable(1);
					SetColProperty(0 ,"eq_cmpo_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
					SetColProperty(0 ,"eq_rpr_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
					SetColProperty(0 ,"rpr_qty" , {AcceptKeys:"N" , InputCaseSensitive:1});
					SetColProperty(0 ,"rpr_sz_no" , {AcceptKeys:"N" , InputCaseSensitive:1});
					SetColProperty(0 ,"fm_rng_sz_no" , {AcceptKeys:"N" , InputCaseSensitive:1});
					SetColProperty(0 ,"to_rng_sz_no" , {AcceptKeys:"N" , InputCaseSensitive:1});
					SetColProperty(0 ,"rpr_lbr_hrs" , {AcceptKeys:"N|[.]" , InputCaseSensitive:1});
					SetSelectionMode(smSelectionRow);
					SetShowButtonImage(2);
					InitComboNoMatchText(true);
					SetRangeBackColor(1, 3, 1, 12,"#555555"); 
				}
				break;
			case "t6sheet1":
				with(sheetObj){
					var HeadTitle1="|Sel|Seq.|Mandatory|Mandatory|Option|Description|Range Type|Volume|Volume|Volume|Limitation|Limitation|Man-Hour||Component Group|Remark(s)";
					var HeadTitle2="|Sel|Seq.|Component|Repair|Division|Description|Range Type|Type|Q'ty|Size/Square|Min|Max|Man-Hour||Component Group|Remark(s)";
					var headCount=ComCountHeadTitle(HeadTitle1);
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
					 {Type:"DummyCheck", Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"del_chk" },
					 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
					 {Type:"Combo", Hidden:0, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"eq_cmpo_cd",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
					 {Type:"Combo", Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"eq_rpr_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
					 {Type:"Text",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trf_div_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:230,  Align:"Left",    ColMerge:1,   SaveName:"dtl_desc",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:500 },
					 {Type:"Combo",     Hidden:0, Width:90,   Align:"Left",    ColMerge:1,   SaveName:"mnr_rng_tp_cd_view",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Combo",     Hidden:0, Width:60,   Align:"Left",    ColMerge:1,   SaveName:"vol_tp_cd_view",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"rpr_qty",             KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
					 {Type:"Text",       Hidden:0,  Width:85,   Align:"Right",   ColMerge:1,   SaveName:"rpr_sz_no",           KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
					 {Type:"Text",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"fm_rng_sz_no",        KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
					 {Type:"Text",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"to_rng_sz_no",        KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
					 {Type:"Text",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"rpr_lbr_hrs",         KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
					 {Type:"Text",      Hidden:1, Width:103,  Align:"Right",   ColMerge:1,   SaveName:"mtrl_reco_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
					 {Type:"Text",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:1,   SaveName:"eq_cmpo_up_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:83,   Align:"Left",    ColMerge:1,   SaveName:"dtl_rmk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4000 },
					 {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"trf_no" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:1,   SaveName:"trf_dtl_seq" },
					 {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"cost_grp_cd" },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Right",   ColMerge:1,   SaveName:"inch_size" },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Right",   ColMerge:1,   SaveName:"cm_size" },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Right",   ColMerge:1,   SaveName:"inch_fm" },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Right",   ColMerge:1,   SaveName:"cm_fm" },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Right",   ColMerge:1,   SaveName:"inch_to" },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Right",   ColMerge:1,   SaveName:"cm_to" },
					 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:1,   SaveName:"mnr_rng_tp_cd" },
					 {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:1,   SaveName:"vol_tp_cd" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:1,   SaveName:"div_flag" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:1,   SaveName:"rpr_flag" }];
					   
					InitColumns(cols);
					SetSheetHeight(392);
					SetEditable(1);
					SetColProperty(0 ,"eq_cmpo_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
					SetColProperty(0 ,"eq_rpr_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
					SetColProperty(0 ,"rpr_qty" , {AcceptKeys:"N" , InputCaseSensitive:1});
					SetColProperty(0 ,"rpr_sz_no" , {AcceptKeys:"N" , InputCaseSensitive:1});
					SetColProperty(0 ,"fm_rng_sz_no" , {AcceptKeys:"N" , InputCaseSensitive:1});
					SetColProperty(0 ,"to_rng_sz_no" , {AcceptKeys:"N" , InputCaseSensitive:1});
					SetColProperty(0 ,"rpr_lbr_hrs" , {AcceptKeys:"N|[.]" , InputCaseSensitive:1});
					SetSelectionMode(smSelectionRow);
					SetShowButtonImage(2);
					InitComboNoMatchText(true);
					SetRangeBackColor(1, 3, 1, 12,"#555555"); 
				}
                break;
			default:
				break;
        }
    }
	/**
	 * initializing event of HTML Control. <br>
	 **/
	function initControl() {
	 //   axon_event.addListenerFormat('focus', 'obj_focus',    document.form); 	
	 //   axon_event.addListenerForm  ('blur', 'obj_deactivate',	document.form);
	    axon_event.addListenerForm  ('blur', 'obj_blur',	document.form);
	    axon_event.addListenerForm	('keypress',	'obj_keypress', document.form);
    }
	/** 
	 * registering IBCombo Object as list
	 * @param    {IBCombo}	combo_obj	 IBCombo Object
	 */	
    function setComboObject(combo_obj){
 		comboObjects[comboCnt++]=combo_obj; 
 	}
    /**
     * registering IBTab Object as list
     * adding process for list in case of needing batch processing with other items
     * defining list on the top of source
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++]=tab_obj;
    }
	/** 
	 * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items
     * defining list on the top of source
	 * @param    {IBSheet}	sheet_obj	adding IBSheet Object
	 */	
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    
    function obj_deactivate(){
//    	obj=event.srcElement;
    	switch (ComGetEvent("name")){
    		case "eff_dt":
    			ComAddSeparator(event.srcElement, "ymd");
    	}
    }
	/**
     * checking validation onblur event of HTML Control. <br>
     **/
    function obj_blur(){
    	ComChkObjValid(event.srcElement);
	}	
	/**
     * checking validation focus event of HTML Control. <br>
     **/
    function obj_focus(){
		ComClearSeparator(event.srcElement);
    }
	/**
	 * checking validation onkeypress event of HTML Control. <br>
	 **/
	function obj_keypress(){
		obj=ComGetEvent();
	    if(obj.dataformat == null) return;
	    window.defaultStatus=obj.dataformat;
		switch(obj.dataformat) {
	        case "engup":
	          	ComKeyOnlyAlphabet('uppernum','45');//"-"          
	            break;
			case "ymd":
				ComKeyOnlyNumber(event.srcElement);
				break;
	    } 
	}
	/** 
	 * COMBO change event
	 * resetting tab in case of changing EQ Type
	 * @param	{IBMultiCombo}	comboObj	Changed combo object
	 * @param	{Number}		Index_Code	Changed combo code
	 * @param	{String}		Text		Changed combo name
	 */
	function combo2_OnChange(comboObj,Index_Code, Text){
		//Whether a value exists on the sheet
		var cnt=0;
		for (var i=1; i<sheetObjects.length; i++){
			cnt += sheetObjects[i].RowCount();
		}
		if(cnt>0) {
			//Intent to change
			if(!ComShowCodeConfirm("MNR00192")) {
				comboObj.SetSelectCode(comboValue,false);
				return;
			}
			//initialzing sheet 
		    for(i=0;i<sheetObjects.length;i++){
		    	sheetObjects[i].RemoveAll();
            }
			//retrieviing sheetCombo
			setSheetCombo(sheetObjects[1]);
		}
		//EQ Type
		comboValue=comboObj.GetSelectCode();
		// resetting Tab, retrieving sheetCombo
		if(comboValue=="U") {
			initTab(tabObjects[0],uTab);  
			setSheetCombo(sheetObjects[1]);
		} 
		else if(comboValue=="Z") {
			initTab(tabObjects[0],zTab);  
			setSheetCombo(sheetObjects[1]);
		} else if(comboValue=="G") {
			initTab(tabObjects[0],gTab);  
			setSheetCombo(sheetObjects[1]);
		}
		//retrieviing default per EQ TYPE       
		var defUnitOfMeasure=MnrDefaultUnitOfMeasure(sheetObjects[0],comboObj.GetSelectCode());
		combo4.SetSelectCode(defUnitOfMeasure);//UnitOfMass
	}   
	/** 
	 * COMBO change event
	 *    setting Size/Square in case of changing Unit Of Measure to inch/cm
	 *     
	 * @param	{IBMultiCombo}	comboObj	Changed combo object
	 * @param	{Number}		Index_Code	Changed combo code
	 * @param	{String}		Text		Changed combo name
	 */
	function combo4_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
		if(initflag == false){
			ComOpenWait(true,true);
			var mnrMeasUtCd= newText == "inch" ? "INC" : "CMT";
			if(mnrMeasUtCd == "INC") {
				for (var i=0; i<sheetObjects.length; i++){
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
				for (var i=0; i<sheetObjects.length; i++){
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
			ComOpenWait(false,true);
		}
	}
    /**
     * Event when clicking Tab
     * activating selected tab items.
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
    	//--------------- importance --------------------------//
    	//objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
    	//------------------------------------------------------//
    	beforetab=nItem;
    }
	/** 
	 * setting after retrieving
	 * @param	{IBSheet}	sheetObj sheetObject
	 * @param	{String}	ErrMsg		errorMessage
	 */
	function t1sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		for(var j=sheetObj.HeaderRows(); j<=sheetObj.LastRow(); j++) {
			setEditableByVolumeType(sheetObj,j);
		}
		if(!checkIsDetailRow(sheetObj)) {return;}
		doAfterSearch(sheetObj);
	}
	/** 
	 * setting after retrieving
	 * @param	{IBSheet}	sheetObj sheetObject
	 * @param	{String}	ErrMsg		errorMessage
	 */
	function t2sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		for(var j=sheetObj.HeaderRows(); j<=sheetObj.LastRow(); j++) {
			setEditableByVolumeType(sheetObj,j);
		}
		if(!checkIsDetailRow(sheetObj)) {return;}
		doAfterSearch(sheetObj);
	}
	/** 
	 * setting after retrieving
	 * @param	{IBSheet}	sheetObj sheetObject
	 * @param	{String}	ErrMsg		errorMessage
	 */
	function t3sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		for(var j=sheetObj.HeaderRows(); j<=sheetObj.LastRow(); j++) {
			setEditableByVolumeType(sheetObj,j);
		}
		if(!checkIsDetailRow(sheetObj)) {return;}
		doAfterSearch(sheetObj);
	}
	/** 
	 * setting after retrieving
	 * @param	{IBSheet}	sheetObj sheetObject
	 * @param	{String}	ErrMsg		errorMessage
	 */
	function t4sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		for(var j=sheetObj.HeaderRows(); j<=sheetObj.LastRow(); j++) {
			setEditableByVolumeType(sheetObj,j);
		}
		if(!checkIsDetailRow(sheetObj)) {return;}
		doAfterSearch(sheetObj);
	}
	/** 
	 * setting after retrieving
	 * @param	{IBSheet}	sheetObj sheetObject
	 * @param	{String}	ErrMsg		errorMessage
	 */
	function t5sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		for(var j=sheetObj.HeaderRows(); j<=sheetObj.LastRow(); j++) {
			setEditableByVolumeType(sheetObj,j);
		}
		if(!checkIsDetailRow(sheetObj)) {return;}
		doAfterSearch(sheetObj);
	}
	/** 
	 * setting after retrieving
	 * @param	{IBSheet}	sheetObj sheetObject
	 * @param	{String}	ErrMsg		errorMessage
	 */
	function t6sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		for(var j=sheetObj.HeaderRows(); j<=sheetObj.LastRow(); j++) {
			setEditableByVolumeType(sheetObj,j);
		}
//		setTabSelect(); //tab select
//		ComOpenWait(false,true);
		if(!checkIsDetailRow(sheetObj)) {return;}
		doAfterSearch(sheetObj);
	}
	/** 
	 * showing message after saving
	 * @param	{IBSheet}	sheetObj	sheetObject
	 * @param	{String}	ErrMsg		errorMessage
	 */
	function t1sheet1_OnSaveEnd(sheetObj,ErrMsg){
		if (ErrMsg == "") { 
			//0:save, 1:confirm, 2:Delete
			if(saveType==0) {
				ComShowCodeMessage("MNR00023");
			} else if (saveType==1) {
				ComShowCodeMessage("MNR00313");
			} else if (saveType==2) {
				ComShowCodeMessage("MNR00020");
			}
			doAfterSave();
		} 
		else { 
		} 
	}     
	/** 
	 * in case of changing sell value
	 * setting Size/Square depending on  Volume Type combo value.
	 * Volume Type:Q -> Size/Square=0, Volume Type:S -> Q'ty=0 
	 * @param	{IBSheet}	sheetObj sheetObject
	 * @param	{Int}		Row			Row
	 * @param	{String}	Col			Column
	 * @param	{String}	Val			Value
	 */
	function t1sheet1_OnChange(sheetObj,Row,Col,Value) {
		with(sheetObj) {		
			if(!dummyEvent){
				var colname=ColSaveName(Col);
				//Volume Type Code
				if(colname=='vol_tp_cd'){
					setEditableByVolumeType(sheetObj,Row);  		//Editalbe
				}
				//Component Code
				else if(colname=='eq_cmpo_cd'){
					checkIsComboValue(sheetObj,Row,Col,Value,0);		//checking whether or not
					setRprCombo(sheetObj,Row);							//Repair GridCombo Set
					setDivCombo(sheetObj,Row);							//Div GridCombo Set	
					setDescripton(sheetObj,Row);						//setting Description								
				}
				//Repair Code
				else if(colname=='eq_rpr_cd'){
					checkIsComboValue(sheetObj,Row,Col,Value,1);  	//checking whether or not
					setDivCombo(sheetObj,Row);						//Div GridCombo Set
					setDescripton(sheetObj,Row);					//setting Description
				}
				//Div Code
				else if(colname=='trf_div_cd'){
					setDescripton(sheetObj,Row);					//setting Description
				}
				//Range Type
				else if(colname=='mnr_rng_tp_cd_view'){
					checkRangeType(sheetObj,Row,Value);				//First Volume checking whether or not
				}
				//Voulume Type
				else if(colname=='vol_tp_cd_view') {
					setVolumeTypeHidden(sheetObj,Row,Value);	//input hidden column.
				}
			}	
		}
	}
	/** 
	 * in case of changing sell value
	 * setting Size/Square depending on  Volume Type combo value.
	 * Volume Type:Q -> Size/Square=0, Volume Type:S -> Q'ty=0 
	 * @param	{IBSheet}	sheetObj sheetObject
	 * @param	{Int}		Row			Row
	 * @param	{String}	Col			Column
	 * @param	{String}	Val			Value
	 */
	function t2sheet1_OnChange(sheetObj,Row,Col,Value) {
		with(sheetObj) {
			if(!dummyEvent){
				var colname=ColSaveName(Col);
				//Volume Type Code
				if(colname=='vol_tp_cd'){
					setEditableByVolumeType(sheetObj,Row);  		//setting Editalbe
				}
				//Component Code
				else if(colname=='eq_cmpo_cd'){
					checkIsComboValue(sheetObj,Row,Col,Value,0);  		//checking whether or not
					setRprCombo(sheetObj,Row);							//Repair GridCombo Set
					setDivCombo(sheetObj,Row);							//Div GridCombo Set
					setDescripton(sheetObj,Row);						//setting Description
				}
				//Repair Code
				else if(colname=='eq_rpr_cd'){
					checkIsComboValue(sheetObj,Row,Col,Value,1); 	//checking whether or not
					setDivCombo(sheetObj,Row);						//Div GridCombo Set
					setDescripton(sheetObj,Row);					//setting Description
				}
				//Div Code
				else if(colname=='trf_div_cd'){
					setDescripton(sheetObj,Row);					//setting Description
				}
				//Range Type
				else if(colname=='mnr_rng_tp_cd_view'){
					checkRangeType(sheetObj,Row,Value);				//First Volume checking whether or not
				}
				//Voulume Type
				else if(colname=='vol_tp_cd_view') {
					setVolumeTypeHidden(sheetObj,Row,Value);		//input hidden column.
				}
			}	
		}
	}
	/** 
	 * in case of changing sell value
	 * setting Size/Square depending on  Volume Type combo value.
	 * Volume Type:Q -> Size/Square=0, Volume Type:S -> Q'ty=0 
	 * @param	{IBSheet}	sheetObj sheetObject
	 * @param	{Int}		Row			Row
	 * @param	{String}	Col			Column
	 * @param	{String}	Val			Value
	 */
	function t3sheet1_OnChange(sheetObj,Row,Col,Value) {
		with(sheetObj) {
			if(!dummyEvent){
				var colname=ColSaveName(Col);
				//Volume Type Code
				if(colname=='vol_tp_cd'){
					setEditableByVolumeType(sheetObj,Row);  		//setting Editalbe
				}
				//Component Code
				else if(colname=='eq_cmpo_cd'){
					checkIsComboValue(sheetObj,Row,Col,Value,0);  		//checking whether or not
					setRprCombo(sheetObj,Row);							//Repair GridCombo Set
					setDivCombo(sheetObj,Row);							//Div GridCombo Set
					setDescripton(sheetObj,Row);						//setting Description
				}
				//Repair Code
				else if(colname=='eq_rpr_cd'){			
					checkIsComboValue(sheetObj,Row,Col,Value,1);  	//checking whether or not
					setDivCombo(sheetObj,Row);						//Div GridCombo Set
					setDescripton(sheetObj,Row);						//setting Description
				}
				//Div Code
				else if(colname=='trf_div_cd'){
					setDescripton(sheetObj,Row);					//setting Description
				}
				//Range Type
				else if(colname=='mnr_rng_tp_cd_view'){
					checkRangeType(sheetObj,Row,Value);				//First Volume checking whether or not
				}
				//Voulume Type
				else if(colname=='vol_tp_cd_view') {
					setVolumeTypeHidden(sheetObj,Row,Value);		//input hidden column.
				}
			}	
		}
	}
	/** 
	 * in case of changing sell value
	 * setting Size/Square depending on  Volume Type combo value.
	 * Volume Type:Q -> Size/Square=0, Volume Type:S -> Q'ty=0 
	 * @param	{IBSheet}	sheetObj sheetObject
	 * @param	{Int}		Row			Row
	 * @param	{String}	Col			Column
	 * @param	{String}	Val			Value
	 */
	function t4sheet1_OnChange(sheetObj,Row,Col,Value) {
		with(sheetObj) {
			if(!dummyEvent){
				var colname=ColSaveName(Col);
				//Volume Type Code
				if(colname=='vol_tp_cd'){
					setEditableByVolumeType(sheetObj,Row);  		//setting Editalbe
				}
				//Component Code
				else if(colname=='eq_cmpo_cd'){
					checkIsComboValue(sheetObj,Row,Col,Value,0);  		//checking whether or not
					setRprCombo(sheetObj,Row);							//Repair GridCombo Set
					setDivCombo(sheetObj,Row);							//Div GridCombo Set
					setDescripton(sheetObj,Row);						//setting Description
					//sheetObj.CellValue(Row, "eq_cmpo_up_cd") = Value;	//2nd Component Code Name set 
				}
				//Repair Code
				else if(colname=='eq_rpr_cd'){
					checkIsComboValue(sheetObj,Row,Col,Value,1);	//checking whether or not
					setDivCombo(sheetObj,Row);						//Div GridCombo Set
					setDescripton(sheetObj,Row);					//setting Description
				}
				//Div Code
				else if(colname=='trf_div_cd'){
					setDescripton(sheetObj,Row);					//setting Description
				}
				//Range Type
				else if(colname=='mnr_rng_tp_cd_view'){
					checkRangeType(sheetObj,Row,Value);				//First Volume checking whether or not
				}
				//Voulume Type
				else if(colname=='vol_tp_cd_view') {
					setVolumeTypeHidden(sheetObj,Row,Value);		//input hidden column.
				}
			}	
		}
	}
	/** 
	 * in case of changing sell value
	 * setting Size/Square depending on  Volume Type combo value.
	 * Volume Type:Q -> Size/Square=0, Volume Type:S -> Q'ty=0 
	 * @param	{IBSheet}	sheetObj sheetObject
	 * @param	{Int}		Row			Row
	 * @param	{String}	Col			Column
	 * @param	{String}	Val			Value
	 */
	function t5sheet1_OnChange(sheetObj,Row,Col,Value) {
		with(sheetObj) {
			if(!dummyEvent){
				var colname=ColSaveName(Col);
				//Volume Type Code
				if(colname=='vol_tp_cd'){
					setEditableByVolumeType(sheetObj,Row);  		//setting Editalbe
				}
				//Component Code
				else if(colname=='eq_cmpo_cd'){
					checkIsComboValue(sheetObj,Row,Col,Value,0);  		//checking whether or not
					setRprCombo(sheetObj,Row);							//Repair GridCombo Set
					setDivCombo(sheetObj,Row);							//Div GridCombo Set
					setDescripton(sheetObj,Row);						//setting Description
				}
				//Repair Code
				else if(colname=='eq_rpr_cd'){
					checkIsComboValue(sheetObj,Row,Col,Value,1);  	//checking whether or not
					setDivCombo(sheetObj,Row);						//Div GridCombo Set
					setDescripton(sheetObj,Row);						//setting Description
				}			
				//Div Code
				else if(colname=='trf_div_cd'){
					setDescripton(sheetObj,Row);					//setting Description
				}
				//Range Type
				else if(colname=='mnr_rng_tp_cd_view'){
					checkRangeType(sheetObj,Row,Value);				//First Volume checking whether or not
				}
				//Voulume Type
				else if(colname=='vol_tp_cd_view') {
					setVolumeTypeHidden(sheetObj,Row,Value);		//input hidden column.
				}
			}	
		}
	}
	/** 
	 * in case of changing sell value
	 * setting Size/Square depending on  Volume Type combo value.
	 * Volume Type:Q -> Size/Square=0, Volume Type:S -> Q'ty=0 
	 * @param	{IBSheet}	sheetObj sheetObject
	 * @param	{Int}		Row			Row
	 * @param	{String}	Col			Column
	 * @param	{String}	Val			Value
	 */	
	function t6sheet1_OnChange(sheetObj,Row,Col,Value) {
		with(sheetObj) {
			if(!dummyEvent){
				var colname=ColSaveName(Col);
				//Volume Type Code
				if(colname=='vol_tp_cd'){
					setEditableByVolumeType(sheetObj,Row);  		//setting Editalbe
				}
				//Component Code
				else if(colname=='eq_cmpo_cd'){
					checkIsComboValue(sheetObj,Row,Col,Value,0);  		//checking whether or not
					setRprCombo(sheetObj,Row);							//Repair GridCombo Set
					setDivCombo(sheetObj,Row);							//Div GridCombo Set
					setDescripton(sheetObj,Row);						//setting Description
				}
				//Repair Code
				else if(colname=='eq_rpr_cd'){
					checkIsComboValue(sheetObj,Row,Col,Value,1);  	//checking whether or not
					setDivCombo(sheetObj,Row);						//Div GridCombo Set
					setDescripton(sheetObj,Row);						//setting Description
				}		
				//Div Code
				else if(colname=='trf_div_cd'){
					setDescripton(sheetObj,Row);					//setting Description
				}
				//Range Type
				else if(colname=='mnr_rng_tp_cd_view'){
					checkRangeType(sheetObj,Row,Value);				//First Volume checking whether or not
				}
				//Voulume Type
				else if(colname=='vol_tp_cd_view') {
					setVolumeTypeHidden(sheetObj,Row,Value);		//input hidden column.
				}		
			}				
		}
	}
	/** 
	 * event in case of clicking
	 *     
	 * @param	{IBSheet}	sheetObj sheetObject
	 * @param	{Int}		Button		Lett:1, Right:2
	 * @param	{Int}		Shift		Shift:1, Ctrl:2, Etc..:0
	 * @param	{Long}		X			Value
	 * @param	{Long}		Y			Value
	 */
    function t1sheet1_OnMouseDown(sheetObj,Button, Shift, X, Y){
		var Row=sheetObj.MouseRow();
		var Col=sheetObj.MouseCol();
		var ColSaveName=sheetObj.ColSaveName(Col);
		if(ColSaveName=="eq_rpr_cd") { //RPR Code
			var rprFlag=sheetObj.GetCellValue(Row, "rpr_flag");
			if(rprFlag=="1") {return} 
			setRprCombo(sheetObj,Row);	
			var divFlag=sheetObj.GetCellValue(Row, "div_flag");
			if(divFlag=="1") {return} 
			setDivCombo(sheetObj,Row); 
		} else if(ColSaveName=="trf_div_cd") { //Div Code
			var divFlag=sheetObj.GetCellValue(Row, "div_flag");
			if(divFlag=="1") {return}	
			setDivCombo(sheetObj,Row); 
		}
	}
    /** 
     * event in case of clicking
     *     
     * @param	{IBSheet}	sheetObj sheetObject
     * @param	{Int}		Button		Lett:1, Right:2
     * @param	{Int}		Shift		Shift:1, Ctrl:2, Etc..:0
     * @param	{Long}		X			Value
     * @param	{Long}		Y			Value
     */
    function t2sheet1_OnMouseDown(sheetObj,Button, Shift, X, Y){
    	var Row=sheetObj.MouseRow();
    	var Col=sheetObj.MouseCol();
    	var ColSaveName=sheetObj.ColSaveName(Col);
    	if(ColSaveName=="eq_rpr_cd") { //RPR Code
    		var rprFlag=sheetObj.GetCellValue(Row, "rpr_flag");
			if(rprFlag=="1") {return} 
			setRprCombo(sheetObj,Row);	
			var divFlag=sheetObj.GetCellValue(Row, "div_flag");
			if(divFlag=="1") {return} 
			setDivCombo(sheetObj,Row); 
		} else if(ColSaveName=="trf_div_cd") { //Div Code
			var divFlag=sheetObj.GetCellValue(Row, "div_flag");
			if(divFlag=="1") {return}	
			setDivCombo(sheetObj,Row); 
		}
    }
    /** 
     * event in case of clicking
     *     
     * @param	{IBSheet}	sheetObj sheetObject
     * @param	{Int}		Button		Lett:1, Right:2
     * @param	{Int}		Shift		Shift:1, Ctrl:2, Etc..:0
     * @param	{Long}		X			Value
     * @param	{Long}		Y			Value
     */
    function t3sheet1_OnMouseDown(sheetObj,Button, Shift, X, Y){
    	var Row=sheetObj.MouseRow();
    	var Col=sheetObj.MouseCol();
    	var ColSaveName=sheetObj.ColSaveName(Col);
    	if(ColSaveName=="eq_rpr_cd") { //RPR Code
    		var rprFlag=sheetObj.GetCellValue(Row, "rpr_flag");
			if(rprFlag=="1") {return} 
			setRprCombo(sheetObj,Row);	
			var divFlag=sheetObj.GetCellValue(Row, "div_flag");
			if(divFlag=="1") {return} 
			setDivCombo(sheetObj,Row); 
		} else if(ColSaveName=="trf_div_cd") { //Div Code
			var divFlag=sheetObj.GetCellValue(Row, "div_flag");
			if(divFlag=="1") {return}	
			setDivCombo(sheetObj,Row); 
		}
    }
    /** 
     * event in case of clicking
     *     
     * @param	{IBSheet}	sheetObj sheetObject
     * @param	{Int}		Button		Lett:1, Right:2
     * @param	{Int}		Shift		Shift:1, Ctrl:2, Etc..:0
     * @param	{Long}		X			Value
     * @param	{Long}		Y			Value
     */
    function t4sheet1_OnMouseDown(sheetObj,Button, Shift, X, Y){
    	var Row=sheetObj.MouseRow();
    	var Col=sheetObj.MouseCol();
    	var ColSaveName=sheetObj.ColSaveName(Col);
    	if(ColSaveName=="eq_rpr_cd") { //RPR Code
    		var rprFlag=sheetObj.GetCellValue(Row, "rpr_flag");
			if(rprFlag=="1") {return} 
			setRprCombo(sheetObj,Row);	
			var divFlag=sheetObj.GetCellValue(Row, "div_flag");
			if(divFlag=="1") {return} 
			setDivCombo(sheetObj,Row); 
		} else if(ColSaveName=="trf_div_cd") { //Div Code
			var divFlag=sheetObj.GetCellValue(Row, "div_flag");
			if(divFlag=="1") {return}	
			setDivCombo(sheetObj,Row); 
		}
    }
    /** 
     * event in case of clicking
     *     
     * @param	{IBSheet}	sheetObj sheetObject
     * @param	{Int}		Button		Lett:1, Right:2
     * @param	{Int}		Shift		Shift:1, Ctrl:2, Etc..:0
     * @param	{Long}		X			Value
     * @param	{Long}		Y			Value
     */
    function t5sheet1_OnMouseDown(sheetObj,Button, Shift, X, Y){
    	var Row=sheetObj.MouseRow();
    	var Col=sheetObj.MouseCol();
    	var ColSaveName=sheetObj.ColSaveName(Col);
    	if(ColSaveName=="eq_rpr_cd") { //RPR Code
    		var rprFlag=sheetObj.GetCellValue(Row, "rpr_flag");
			if(rprFlag=="1") {return} 
			setRprCombo(sheetObj,Row);	
			var divFlag=sheetObj.GetCellValue(Row, "div_flag");
			if(divFlag=="1") {return} 
			setDivCombo(sheetObj,Row); 
		} else if(ColSaveName=="trf_div_cd") { //Div Code
			var divFlag=sheetObj.GetCellValue(Row, "div_flag");
			if(divFlag=="1") {return}	
			setDivCombo(sheetObj,Row); 
		}
    }
    /** 
     * event in case of clicking
     *     
     * @param	{IBSheet}	sheetObj sheetObject
     * @param	{Int}		Button		Lett:1, Right:2
     * @param	{Int}		Shift		Shift:1, Ctrl:2, Etc..:0
     * @param	{Long}		X			Value
     * @param	{Long}		Y			Value
     */
    function t6sheet1_OnMouseDown(sheetObj,Button, Shift, X, Y){
    	var Row=sheetObj.MouseRow();
    	var Col=sheetObj.MouseCol();
    	var ColSaveName=sheetObj.ColSaveName(Col);
    	if(ColSaveName=="eq_rpr_cd") { //RPR Code
    		var rprFlag=sheetObj.GetCellValue(Row, "rpr_flag");
			if(rprFlag=="1") {return} 
			setRprCombo(sheetObj,Row);	
			var divFlag=sheetObj.GetCellValue(Row, "div_flag");
			if(divFlag=="1") {return} 
			setDivCombo(sheetObj,Row); 
		} else if(ColSaveName=="trf_div_cd") { //Div Code
			var divFlag=sheetObj.GetCellValue(Row, "div_flag");
			if(divFlag=="1") {return}		
			setDivCombo(sheetObj,Row); 
		}			
    }
  	/**
     * handling Sheet1 reference
     * @param	{IBSheet}	sheetObj	SheetObject 
     * @param	{Form}		formObj		formObject
     * @param	{Number}	sAction		action constants(CoObject.js defined) 
     */
    function doActionIBSheet(sheetObj,formObj,sAction,sActionIdx) {
	   	sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			//initialzing
			case IBCLEAR:
				ComOpenWait(true);
				MnrWaitControl(true);
	    		// initializing sheet
	    		for (i=0; i < sheetObjects.length; i++) {
	    			sheetObjects[i].RemoveAll();
	    		}
				//retrieviing only initial loading
				if(sActionIdx==0) {	
		        	//initializing Combo Data
					for(var i=0; i < comboObjects.length;i++){ 
						comboObjects[i].RemoveAll();
					}
					//retrieviing Combo(UnitOfMass, Currency)
					var sCondition=new Array (
						new Array("MnrGenCd","CD00007", "COMMON"), 	//Status	
						new Array("MnrGenCd","","CUSTOM9") ,  	//EQ Type
						new Array("MdmCurrency","", "COMMON"),		//Currency			
						new Array("MnrGenCd","CD00010", "COMMON"), 	//UnitOfMass
						new Array("MnrEqCmpoCd","3","COMMON"), 		//Component
						new Array("MnrCedexOthCd","RPR","COMMON"), 	//Repair
						new Array("MnrGenCd","CD00012", "COMMON"),	//RangeType
						new Array("MnrGenCd","CD00013", "COMMON")	//Type
					)             
					var comboList=MnrComSearchCombo(sheetObj,sCondition);
					var sheetComboText="";  
					var sheetComboCode="";
					var sheetComboDefault="";
					//sheetCombo SAVE_NAME
					var comboSaveNames=new Array();
					comboSaveNames[0]="eq_cmpo_cd";
					comboSaveNames[1]="eq_rpr_cd";
					comboSaveNames[2]="mnr_rng_tp_cd_view";  
					comboSaveNames[3]="vol_tp_cd_view";  
					//setting on combo data        
					for(var i=0; i < comboList.length;i++){
						//comboObjects[i].RemoveAll();   
						if(comboList[i] != null){
							//initializing sheetCombo
							sheetComboText="";
							sheetComboCode="";
							sheetComboCodeText="";
							sheetComboDefault=""; 
							//Display[CODE_NAME]:Status,UnitOfMass 
							if(i==0||i==1||i==3) {
								for(var j=0; j < comboList[i].length;j++){ 
									var tempText=comboList[i][j].split("|");    
									//Status 
									if(i==0) {
										combo1.InsertItem(j, tempText[1] ,tempText[0]);
									//EQ Type
									} else if(i==1) {
										combo2.InsertItem(j, tempText[1] ,tempText[0]);
									//UnitOfMass
									} else if(i==3) {
										combo4.InsertItem(j, tempText[1] ,tempText[0]);
									}
								}
							//Display[CODE]:Currency
							} else if(i==2){
								for(var j=0; j < comboList[i].length;j++){ 
									combo3.InsertItem(j, comboList[i][j] ,j);
								}
							//sheetCombo
							} else if (i==4||i==5||i==6||i==7) {
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
							//setting sheetcombo per tab
							for(var k=0; k<sheetObjects.length; k++) {
								//[CODE][NAME]:Component,Repair	
								if(i==5) {
									sheetObjects[k].InitDataCombo (0, comboSaveNames[i - 4], sheetComboCodeText, sheetComboCode ,sheetComboDefault); 
								}
								//[NAME]:RangeType,Type 
								else if(i==6||i==7) {  
									sheetObjects[k].InitDataCombo (0, comboSaveNames[i - 4], sheetComboText, sheetComboCode ,sheetComboDefault); 
								} 
							}							
						}
					}
				}
				//setting combo initial value
				combo1.SetSelectCode(-1);//Status
				combo2.SetSelectCode("U");//EQ Type
				combo3.SetSelectText("USD");//Currency
				combo4.SetSelectCode("INC");//UnitOfMass
				//initializing condition
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
				formObj.eff_dt.value=ComGetNowInfo("ymd"); //Eff.from
				formObj.eff_dt.readOnly=false; 				//Eff.from
				formObj.eff_dt.className="input1"; 			//Eff.from
				formObj.mnr_trf_sts_cd.value="";					//Tariff Status 
				formObj.mnr_trf_rmk.value="";					//Remark(s)
				//enable Currency,EQ Type combo
				combo1.SetEnable(0);//Status
				combo2.SetEnable(1);//EQ Type
				combo3.SetEnable(0);//Currency
				combo4.SetEnable(1);//Unit Of Measure
				//enable Button
				setButtonEnDisable();
				//setting button, progressing bar
				MnrWaitControl(false);
				ComOpenWait(false);
				break;
			//retrieving
            case IBSEARCH:
				formObj.f_cmd.value=SEARCH;      
                if(validateForm(sheetObj,formObj,sAction)) {
					//multiple retrieving
                	var sXml=sheetObj.GetSearchData("EES_MNR_0014GS.do", FormQueryString(formObj));
					var arrXml=sXml.split("|$$|");
					//Header
					var arrResult=MnrXmlToArray(arrXml[0]);
					if(arrResult != null){
						formObj.trf_no.value=arrResult[0][19];	//triff No    
						formObj.eff_dt.value=arrResult[0][6];  //Contract Start Date
						formObj.rqst_ofc_cd.value=arrResult[0][4];	//Tariff Office
						formObj.cre_dt.value=arrResult[0][9];  //creating date
						formObj.cre_usr_id.value=arrResult[0][14]; //creating User ID
						formObj.mnr_trf_sts_cd.value=arrResult[0][23]; //Tariff Status Code(SS:Save[SPP],SR:Request[SPP],SD:Delete[SPP],HR:Request,HS:Save,HJ:Reject,HD:Delete,HE:Expired,HA:Approval)
						formObj.mnr_trf_rmk.value=arrResult[0][18]; //Remark(s)
						combo1.SetSelectCode(arrResult[0][23]);//Tariff Status Code
						combo2.SetSelectCode(arrResult[0][24]);//EQ Type(U:CONTAINER,Z:CHASSIS,G:GENSET)
						combo3.SetSelectText(arrResult[0][7]);//Currency
						combo4.SetSelectCode(arrResult[0][10]);//Unit Of Mass (CMT:CM, INC:inch)
						setButtonEnDisable();  //Button GetEnable()
					} else {
						ComShowCodeMessage("MNR00204");
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
						ComOpenWait(true,true);
						for(var i=0; i < arrXml.length-1; i++){
							sheetObjects[i].LoadSearchData(arrXml[i+1]);
							//setting Editalbe
//							for(var j=sheetObjects[i].HeaderRows(); j<=sheetObjects[i].LastRow(); j++) {
//								setEditableByVolumeType(sheetObjects[i],j);	
//							}
						}
//						setTabSelect(); //tab select
//						ComOpenWait(false,true);
					} 
					else if (eqTypeCd=="Z") {
						sheetObjects[0].LoadSearchData(arrXml[5],{Sync:1} );
					}
					else if (eqTypeCd=="G") {
						sheetObjects[0].LoadSearchData(arrXml[6],{Sync:1} );
//							
					}
				}

                break;
			// saving
            case IBSAVE:
                if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value=MULTI;
					formObj.mnr_meas_ut_cd.value=combo4.GetSelectCode();  	//Unit Of Mass
					formObj.curr_cd.value=combo3.GetSelectText();  	//Currency
					formObj.eq_knd_cd.value=combo2.GetSelectCode();  	//EQ Type
					formObj.eq_knd_nm.value=combo2.GetSelectText();  	//EQ Type Name
					formObj.mnr_trf_knd_cd.value="STD";  				 	//setting Tariff kind(STD:Standard Tariff, LCL:Local Tariff)
					formObj.pre_trf_no.value="COM("+comboValue+")-S-";	//Tariff_No의 prefix
					//Tariff Status Code  (SS:Save[SPP],SR:Request[SPP],SD:Delete[SPP],HR:Request,HS:Save,HJ:Reject,HD:Delete,HE:Expired,HA:Approval)
					//Save
					if(sheetObj.id == 't1sheet1') {  
						formObj.mnr_trf_sts_cd.value="HS";
						saveType=0;  
					} 
					//Confirm
					else if (sheetObj.id == 't2sheet1') {
						formObj.mnr_trf_sts_cd.value="HA";
						setRowStausByConfirm();	
						saveType=1;
					}
					//Delete
					else {
						formObj.mnr_trf_sts_cd.value="HD";
						setRowStausByConfirm();	
						saveType=2;
					}
					//var sParam = ComGetSaveString(sheetObjects);
					var sParam="";
					for(var i=0; i<=3; i++) {
						if(sheetObjects[i].RowCount()> 0) {
							sParam=sParam + "&" +	MnrGetAllSaveText(sheetObjects[i], true, "ibflag");
						}
					}
					if (sParam == "") return;
				    sParam += "&" + FormQueryString(formObj);
					//return Tariff No.
				    sSaveRtnXml=sheetObjects[0].GetSaveData("EES_MNR_0014GS.do", sParam);
				    sheetObjects[0].LoadSaveData(sSaveRtnXml);
				}
                break;
			//copy 
			case "COPY":
				if(validateForm(sheetObj,formObj,sAction)) {
					//initializing condition
					formObj.trf_no.value="NEW"; 	  			//trf_no for save
					formObj.search_trf_no.value="NEW";				//trf_no for search
					formObj.search_trf_no.className="input1";				//trf_no for search
					formObj.search_trf_no.readOnly=false;				//trf_no for search
					combo2.SetEnable(0);//EQ Type
					formObj.rqst_ofc_cd.value=currOfcCd;			//Tariff Office
					formObj.cre_usr_id.value=usrId;				//Creation User
					formObj.cre_dt.value=ComGetNowInfo("ymd");	//Creation Date
					formObj.eff_dt.value=ComGetNowInfo("ymd"); //Eff.from
					formObj.eff_dt.readOnly=false; 				//Eff.from
					formObj.eff_dt.className="input1"; 			//Eff.from
					formObj.mnr_trf_sts_cd.value="";					//Status
//					combo1.SetSelectCode("",false);//Status
					combo1.SetSelectIndex(-1,false);//Status
					combo4.SetEnable(1);
					//changing sheet status, trf_no
					setRowStausByCopy(formObj);
					//Button Enable 설정  
					setButtonEnDisable();    
				}
				break;
            //input Row
			case IBINSERT:
			    if(validateForm(sheetObj,formObj,sAction)) {
				    var Row=sheetObj.DataInsert(-1);
					//Tariff No
					sheetObj.SetCellValue(Row, "trf_no",formObj.trf_no.value,0);
					//setting Volume Edit
					setEditableByVolumeType(sheetObj,Row);  
					//setting cost_grp_cd
					if(comboValue=="U") {
						if(sheetObj.id == 't1sheet1') {
							sheetObj.SetCellValue(Row, "cost_grp_cd","MRDR",0);
						}
						else if (sheetObj.id == 't2sheet1') {   
							sheetObj.SetCellValue(Row, "cost_grp_cd","MRRF",0);
				   	   	}
						else if (sheetObj.id == 't3sheet1') {   
							sheetObj.SetCellValue(Row, "cost_grp_cd","MRRU",0);
				   	   	}
						else if (sheetObj.id == 't4sheet1') {   
							sheetObj.SetCellValue(Row, "cost_grp_cd","MRDS",0);
				   	   	}
					} else if(comboValue=="Z"){
						sheetObj.SetCellValue(Row, "cost_grp_cd","MRZS",0);
					} else if (comboValue=="G") {
						sheetObj.SetCellValue(Row, "cost_grp_cd","MRGS",0);
					}
					//set Value Init
					sheetObj.SetCellValue(Row, "eq_cmpo_cd","",0);//Component
					sheetObj.SetCellValue(Row, "eq_rpr_cd","",0);//Repair
					sheetObj.SetCellValue(Row, "trf_div_cd","",0);//Div
					sheetObj.SetCellValue(Row, "eq_cmpo_up_cd","",0);//Component Group
					sheetObj.SetCellValue(Row, "mnr_rng_tp_cd","F",0);//Hidden Range Type
					sheetObj.SetCellValue(Row, "vol_tp_cd","Q",0);//Hidden Volume Type
					//set Focus
					sheetObj.SelectCell(Row, "eq_cmpo_cd");
				}
                break;
			//Row Copy
			case IBCOPYROW:
			    if(validateForm(sheetObj,formObj,sAction)) {
					var Row=sheetObj.DataCopy();
					setDivCombo(sheetObj,Row);	//Div GridCombo Set
				}    
				break;
			//deleting Row
			case IBDELETE:
			    if(validateForm(sheetObj,formObj,sAction)) {
					ComRowHideDelete(sheetObj, "del_chk");
				}    
				break;
            //Load Excel
			case IBLOADEXCEL:
				if(validateForm(sheetObj,formObj,sAction)) {
					var eqTypeCd=combo2.GetSelectCode(); //EQ Type
				    ComOpenPopup('/opuscntr/EES_MNR_0190.do?eqTypeCd='+eqTypeCd, 1020, 591, 'setEES_MNR_190', '1,0,1,1,1,1,1,1,1,1,1,1', true);
					searchType=1;
				}   
				break;
            //Down Excel
			case IBDOWNEXCEL:
			    //sheetObj.Down2Excel(-1);
				if(sheetObj.RowCount() < 1){//no data
					ComShowCodeMessage("COM132501");
				}else{
					sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1, KeyFieldMark:0 });
				}				
				break;
        }
    }
  	/**
     * handling process for input validation
     * @param	{IBSheet}	sheetObj	sheetObject 
     * @param	{Form}		formObj		formObject
     * @param	{Number}	sAction		action constants(CoObject.js defined) 
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
			//retrieving
			if(sAction==IBSEARCH){
				//Dataformat
				if (!ComChkValid(formObj)) {return false;}
				//checking Tarff No
				var trfNo=formObj.search_trf_no.value;
				if(trfNo=="NEW") {
					ComShowCodeMessage("MNR00003");
					formObj.search_trf_no.focus();
					return false;
				}
			}
			// saving(Confirmation,deletioin)
			else if(sAction==IBSAVE) {
				//checking Tariff status
				if(!checkTariffStatus()) {return false;}
				//mandatory
				if(!checkMandatory(eff_dt)) {return false;}
				//grid whether or not 
				if(!checkIsDetailRow1()) {return false;}
				//check Duplicate per sheet
				for (var i=0; i<sheetObjects.length; i++){
					var Row=sheetObjects[i].ColValueDup("eq_cmpo_cd|eq_rpr_cd|trf_div_cd|fm_rng_sz_no|to_rng_sz_no|mnr_rng_tp_cd|vol_tp_cd|rpr_qty|rpr_sz_no");
					if(sheetObjects[i].IsDataModified()){
						if(Row>0){
							ComShowCodeMessage("MNR00006",(i+1) + "th sheet of " + sheetObjects[i].GetCellValue(Row, "Seq") + " row ");	
							sheetObjects[i].SelectCell(Row, "eq_cmpo_cd", true);
							return false;
						}
					}
				}
				// checking Q'ty,Size/Square, Man-Hour, FmTo per VolumnType of sheets
				for (var i=0; i<sheetObjects.length; i++){
					var temp = sheetObjects[i].id;
					if(sheetObjects[i].RowCount()> 0) {
						for(var j=sheetObjects[i].HeaderRows(); j<=sheetObjects[i].LastRow(); j++) {
							var volTpCd=sheetObjects[i].GetCellValue(j, "vol_tp_cd");	//Type
							var rprQty=sheetObjects[i].GetCellValue(j, "rpr_qty");		//Q'ty
							var rprSzNo=sheetObjects[i].GetCellValue(j, "rpr_sz_no");	//Size/Square
							var rprLbrHrs=sheetObjects[i].GetCellValue(j, "rpr_lbr_hrs");	//Man-Hour
							var fmRngSzNo=sheetObjects[i].GetCellValue(j, "fm_rng_sz_no");	//Fm
							var toRngSzNo=sheetObjects[i].GetCellValue(j, "to_rng_sz_no");	//To
						    rprQty=ComParseInt(rprQty);		//Q'ty
						    rprSzNo=ComParseInt(ComTrim(rprSzNo));		//Size/Square
						    fmRngSzNo=ComParseInt(fmRngSzNo);	//Fm
						    toRngSzNo=ComParseInt(toRngSzNo);	//To
						    if(isNaN(fmRngSzNo)) {fmRngSzNo=0};  //Fm
						    if(isNaN(toRngSzNo)) {toRngSzNo=0};  //To

							//Q'ty
							if(volTpCd=='Q') {
								if(rprQty < 1){
									ComShowCodeMessage("MNR00175",(i) + "th sheet of " + sheetObjects[i].GetCellValue(j, "Seq") + "row\'s Q'ty");
									sheetObjects[i].SelectCell(j, "rpr_qty", true);
									return false;
								}
							} 
							//Size/Square
							else {
								if(rprSzNo < 1){
									ComShowCodeMessage("MNR00175",(i) + "th sheet of " + sheetObjects[i].GetCellValue(j, "Seq") + "row\' Size/Square");
									sheetObjects[i].SelectCell(j, "rpr_sz_no", true);
									return false;
								}
								if(fmRngSzNo > toRngSzNo){
									ComShowCodeMessage("MNR00166");
									sheetObjects[i].SelectCell(j, "to_rng_sz_no", true);
									return false;
								}
								//checking Size range
								var mnrRngTpCdView=sheetObjects[i].GetCellValue(j, "mnr_rng_tp_cd_view"); //Range Type
								if(mnrRngTpCdView=="F") {
									if(toRngSzNo < rprSzNo){
										ComShowCodeMessage("MNR00166");
										sheetObjects[i].SelectCell(j, "rpr_sz_no", true);
										return false;
									}
									if(fmRngSzNo > rprSzNo){
										ComShowCodeMessage("MNR00166");
										sheetObjects[i].SelectCell(j, "rpr_sz_no", true);
										return false;
									}
								}
							}
							//Man-Hour
							if(rprLbrHrs == "") {
								ComShowCodeMessage("MNR00175",(i+1) + "th sheet of " + sheetObjects[i].GetCellValue(j, "Seq") + " row\'s  Man-Hour");
								sheetObjects[i].SelectCell(j, "rpr_lbr_hrs", true);
								return false;
							}
						}
					}
				}
  				//clicking Delete button
				if(sheetObj.id == 't3sheet1'){
					if(!ComShowCodeConfirm("MNR00026")){return false}
				}
				//clicking Confirm button
				if(sheetObj.id == 't2sheet1'){
					if(!ComShowCodeConfirm("MNR00197")){return false}
				}
			}
			//copy
			else if (sAction=="COPY") {
				//grid whether or not 
				if(!checkIsDetailRow1()) {return false;}
			}
			//deleting Row
			else if (sAction==IBDELETE) {
				if(sheetObj.FindCheckedRow("del_chk") == ""){
					ComShowCodeMessage("MNR00038","DELETE ");
					return false;             	   
				}
			}
			//copy Row
			else if (sAction==IBCOPYROW) {
				//grid whether or not 
				if(!checkIsDetailRow1()) {return false;}
			}
			//Load Excel
			else if (sAction==IBLOADEXCEL) {
				//checking Tariff status
				if(!checkTariffStatus()) {return false;}
			}
        }
        return true;
    }
/* ********* User Functions ************* */
	/**
	 * EES_MNR_0188 return from popup     
	 */
	function setEES_MNR_0188(aryPopupData, row, col, shhetIdx){
    	 var formObj=document.form; 
		 if(aryPopupData[0][3] != null && aryPopupData[0][3] != "") {
    	 	formObj.search_trf_no.value=aryPopupData[0][3];
		 }
		 doActionIBSheet(sheetObjects[1],formObj,IBSEARCH); 
	}      
    /**
     * checking mandatory in case of saving
     * @param	{Element}	obj	check Form Element
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
	 * checking grid whether or not in case of saving
	 */
	function checkIsDetailRow1(){
		var cnt=0;
		for (var i=0; i<sheetObjects.length; i++) {
			if(sheetObjects[i].RowCount()> 0) {
				cnt++;
			}
		}
		if(cnt<1) { return false}
		return true;
	}
	
	function checkIsDetailRow(sheetObj){
		var cnt=0;

		if(sheetObj.RowCount()> 0) {
			cnt++;
		}
		
		if(cnt<1) { return false}
		return true;
	}
	/**
	 * Confirm/clicking Delete button  
	 * 
	 */
	function setRowStausByConfirm(){
		for (var i=0; i<sheetObjects.length; i++) {  
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
	 * clicking copy button
	 * @param	{Form}		formObj		formObject
	 */
	function setRowStausByCopy(formObj){
		for (var i=0; i<sheetObjects.length; i++) {
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
	 * setting Size/Square depending on  Volume Type combo value.
	 * Volume Type:Q -> Size/Square=0, 		Volume Type:S -> Q'ty=0 
	 * Volume Type:Q -> Q'ty=Edit,			Volume Type:S -> Size/Square=Edit 
	 * @param	{IBSheet}	sheetObj sheetObject
	 * @param	{Int}		Row			Row
	 * @param	{String}	Val			Value
	 */
    function setEditableByVolumeType(sheetObj,Row){
    	var volTpCd=sheetObj.GetCellValue(Row, "vol_tp_cd_view");
		//Q'ty
		if(volTpCd=='Q'){
			sheetObj.SetCellValue(Row, "rpr_sz_no","",0);
			sheetObj.SetCellEditable(Row, "rpr_sz_no",0);
			sheetObj.SetCellEditable(Row, "rpr_qty",1);
			sheetObj.ReturnCellData(Row, "rpr_qty");
		//Size/Square
		} else {
			sheetObj.SetCellValue(Row, "rpr_qty","",0);
			sheetObj.SetCellEditable(Row, "rpr_qty",0);
			sheetObj.SetCellEditable(Row, "rpr_sz_no",1);
			sheetObj.ReturnCellData(Row, "rpr_sz_no");
		}
	}	
	/** 
	 * checking combo value whether or not
	 * 
	 * @param	{IBSheet}	sheetObj sheetObject
	 * @param	{Int}		Row			Row
	 * @param	{String}	Col			Column
	 * @param	{String}	Val			Value
	 * @param	{Int}		comboSeq	combo sequence
	 */
	function checkIsComboValue(sheetObj,Row,Col,Value,comboSeq){
 		for(var j=0; j < comboListGrid[comboSeq].length;j++){ 
			var tempText=comboListGrid[comboSeq][j].split("|");
			//is code
			if(tempText[0]==Value) {return ;}   
		}
		//Code that not exist
		ComShowCodeMessage("MNR00165",Value);
		sheetObj.SetCellValue(Row,Col,"",0);
		sheetObj.SelectCell(Row,Col, true);
	}
	/** 
	 * setting Description
	 * setting Description in case of changing Component,Repair,Div Combo
	 * @param	{IBSheet}	sheetObj sheetObject
	 * @param	{Int}		Row			Row
	 */
	function setDescripton(sheetObj,Row) {
		var componentCode=sheetObj.GetCellValue(Row,"eq_cmpo_cd");
		var componentDesc=getDescription(componentCode,0);
		var divCode=sheetObj.GetCellValue(Row,"trf_div_cd");
		var divDesc="";
		var repairCode=sheetObj.GetCellValue(Row,"eq_rpr_cd");
		var repairDesc=getDescription(repairCode,1);
		sheetObj.SetCellValue(Row, "dtl_desc","["+componentCode+"]"+componentDesc +" - ["+repairCode+"]"+ repairDesc+" - ["+divCode+"]",0);
	} 
	/** 
	 * return sheet combo value
	 * get Component,Repair code name.
	 * @param	{String}	Val			Value
	 * @param	{Int}		comboSeq	combo sequence
	 * @return  {String}    tempDesc    CodeName
	 */
	function getDescription(Value,comboSeq){
		var tempDesc="";
 		for(var j=0; j < comboListGrid[comboSeq].length;j++){ 
			var tempText=comboListGrid[comboSeq][j].split("|");
			if(tempText[0]==Value) {
				tempDesc=tempText[1];
				return tempDesc; 
			}   
		}
		return tempDesc; 
	}
	/**  
	 *     
	 *     (Component, Repair, Loc, Div, Fm, To)
	 * @param	{IBSheet}	sheetObj sheetObject
	 * @param	{Int}		Row			Row
	 * @param	{String}	Col			Column
	 * @param	{String}	Val			Value
	 * @param	{Int}		comboSeq	combo sequence
	 */
	function checkRangeType(sheetObj,Row,Value) {
		var rowEqCmpoCd=sheetObj.GetCellValue(Row,"eq_cmpo_cd");		//Component
		var rowEqRprCd=sheetObj.GetCellValue(Row,"eq_rpr_cd");		//Repair
		var rowTrfDivCd=sheetObj.GetCellValue(Row,"trf_div_cd");		//Option Div
		var rowFmRngSzNo=sheetObj.GetCellValue(Row,"fm_rng_sz_no");	//Size Section Fm
		var rowToRngSzNo=sheetObj.GetCellValue(Row,"to_rng_sz_no");	//Size Section To
		var rowSpec=rowEqCmpoCd + rowEqRprCd + rowTrfDivCd + rowFmRngSzNo + rowToRngSzNo;
		for(var i=sheetObj.HeaderRows(); i<=sheetObj.LastRow(); i++) {
			if(Row!=i){
				var iEqCmpoCd=sheetObj.GetCellValue(i,"eq_cmpo_cd");	//Component
				var iEqRprCd=sheetObj.GetCellValue(i,"eq_rpr_cd");	//Repair
				var iTrfDivCd=sheetObj.GetCellValue(i,"trf_div_cd");	//Option Div
				var iFmRngSzNo=sheetObj.GetCellValue(i,"fm_rng_sz_no");	//Size Section Fm
				var iToRngSzNo=sheetObj.GetCellValue(i,"to_rng_sz_no");	//Size Section To
				var iSpec=iEqCmpoCd + iEqRprCd + iTrfDivCd + iFmRngSzNo + iToRngSzNo;
				if(rowSpec==iSpec) {
					var iMnrRngTpCd=sheetObj.GetCellValue(i,"mnr_rng_tp_cd_view");
					if(Value=='A') {
						if(iMnrRngTpCd=='F') {
							sheetObj.SetCellValue(Row,"mnr_rng_tp_cd",Value,0);
							return;
						}	
					} else if(Value=='L') {
						if(iMnrRngTpCd=='A') {
							sheetObj.SetCellValue(Row,"mnr_rng_tp_cd",Value,0);
							return;
						}
					} else {
						sheetObj.SetCellValue(Row,"mnr_rng_tp_cd",Value,0);
						return;
					}
				}
			}
		}
		if(Value=='A') {
			ComShowCodeMessage("MNR00176");
		} else if(Value=='L') {
			ComShowCodeMessage("MNR00214");
		}
		sheetObj.SetCellValue(Row,"mnr_rng_tp_cd_view","F",0);
		sheetObj.SetCellValue(Row,"mnr_rng_tp_cd","F",0);
		sheetObj.SelectCell(Row, "mnr_rng_tp_cd_view");
	}
	/** 
	 * handling after retrieving
	 */
	function doAfterSearch(sheetObj) {
		//search
		if(searchType==0) {
			var formObject=document.form;
			formObject.search_trf_no.readOnly="true";		//Tariff No ReadOnly
			formObject.search_trf_no.className="input2";	//Tariff No Class
			combo2.SetEnable(0);//setting EQ_Type Edit
			//Status(Tariff Approval)
			var status=combo1.GetSelectCode();
			if(status=="HA") {
				formObject.eff_dt.readOnly="true";	//Eff.from
				formObject.eff_dt.className="input2";	//Eff.from
				combo4.SetEnable(0);//Unit Of Measure
			} else {
				formObject.eff_dt.readOnly="false";	//Eff.from
				formObject.eff_dt.className="input1";	//Eff.from
				combo4.SetEnable(1);//Unit Of Measure
			}
			ComOpenWait(false,true);
		}
		//load excel
		else if(searchType==1) {
			ComOpenWait(true,true);
			for(var i=0; i<sheetObjects.length; i++) {
				for(var j=sheetObjects[i].HeaderRows(); j<= sheetObjects[i].LastRow(); j++){
					setEditableByVolumeType(sheetObjects[i],j);	//set Edit Qty/Size by VolumeType
					var trfNo=sheetObjects[i].GetCellValue(j, "trf_no");
					if(trfNo=="NEW") {
						sheetObjects[i].SetRowStatus(j,"I");
					}
				}
			}
			ComOpenWait(false,true);
		}
		//setting no match combo
//		for(var i=1; i<sheetObjects.length; i++) {
//			setNoMatchCombo(sheetObjects[i]);
//		}
		setNoMatchCombo(sheetObj);

	}
	/** 
	 * handlinig after saving.
	 */
	function doAfterSave() {
		//initializing after deleting
		if(saveType==2) {
			doActionIBSheet(sheetObjects[1],document.form,IBCLEAR,1);
		}  
		// retrieviing atfer saving or Confirmation
        else {
			var arrResult=MnrXmlToArray(sSaveRtnXml);
			document.form.search_trf_no.value=arrResult[0][19];
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		}
	}
	/**
	 * return from setEES_MNR_190 
	 * @param Array[]	rArray				return value
	 */
	function setEES_MNR_190(rArray){
		//handling in popup.
		sheetObjects[0].LoadSearchData(rArray[0],{Sync:1} );
		sheetObjects[1].LoadSearchData(rArray[1],{Sync:1} );
		sheetObjects[2].LoadSearchData(rArray[2],{Sync:1} );
		sheetObjects[3].LoadSearchData(rArray[3],{Sync:1} );
    }    
	/** 
	 * enable or disable according to status
	 * disable in case of Confirm status
	 * (Delete, Save, Confirm, LoadExcel) 
	 */
    function setButtonEnDisable() {
		var mnrTrfStsCd=document.form.mnr_trf_sts_cd.value;
		if(mnrTrfStsCd=="HA"){
			ComBtnDisable("btn_Delete");
			ComBtnDisable("btn_Save");
			ComBtnDisable("btn_Confirm");
			ComBtnDisable("btn_t1LoadExcel");
			ComBtnDisable("btn_t1RowAdd");
			ComBtnDisable("btn_t1Delete");
			ComBtnDisable("btn_t1RowCopy");
			ComBtnDisable("btn_t2LoadExcel");
			ComBtnDisable("btn_t2RowAdd");
			ComBtnDisable("btn_t2Delete");
			ComBtnDisable("btn_t2RowCopy");
			ComBtnDisable("btn_t3LoadExcel");
			ComBtnDisable("btn_t3RowAdd");
			ComBtnDisable("btn_t3Delete");
			ComBtnDisable("btn_t3RowCopy");
			ComBtnDisable("btn_t4LoadExcel");
			ComBtnDisable("btn_t4RowAdd");
			ComBtnDisable("btn_t4Delete");
			ComBtnDisable("btn_t4RowCopy");
		} else {
			ComBtnEnable("btn_Delete");
			ComBtnEnable("btn_Save");
			ComBtnEnable("btn_Confirm");
			ComBtnEnable("btn_t1LoadExcel");
			ComBtnEnable("btn_t1RowAdd");
			ComBtnEnable("btn_t1Delete");
			ComBtnEnable("btn_t1RowCopy");
			ComBtnEnable("btn_t2LoadExcel");
			ComBtnEnable("btn_t2RowAdd");
			ComBtnEnable("btn_t2Delete");
			ComBtnEnable("btn_t2RowCopy");
			ComBtnEnable("btn_t3LoadExcel");
			ComBtnEnable("btn_t3RowAdd");
			ComBtnEnable("btn_t3Delete");
			ComBtnEnable("btn_t3RowCopy");
			ComBtnEnable("btn_t4LoadExcel");
			ComBtnEnable("btn_t4RowAdd");
			ComBtnEnable("btn_t4Delete");
			ComBtnEnable("btn_t4RowCopy");
		}
	}
	/**
	 * return false in case of Confirm status
	 * other return true
	 * @return  {Boolean}    true/false
	 */
	function checkTariffStatus() {
		var mnrTrfStsCd=document.form.mnr_trf_sts_cd.value; //mnr_trf_sts_cd
		if(mnrTrfStsCd=="HA"){
			ComShowCodeMessage("MNR00190","Tariff");
			return false;
		}
		return true;
	}
	/**
	 * setting tab name
	 */
	function setTabName() {
		var sCondition=new Array (
			new Array("MnrGenCd","CC", "CUSTOM3") //retrieving tab name
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
	 * retrieving sheet combo data
	 * @param	{IBSheet}	sheetObj sheetObject
	 */
	function setSheetCombo(sheetObj) {
		//retrieving sheet combo data	
		var sCondition=new Array (					      
			new Array("MnrEqCmpoCdByEqType","3",combo2.GetSelectCode()), //Component
			new Array("MnrCedexOthCd","RPR","COMMON"), 	//Repair
			new Array("MnrGenCd","CD00012", "COMMON"),	//RangeType
			new Array("MnrGenCd","CD00013", "COMMON")	//Type
		)		             
		comboListGrid=MnrComSearchCombo(sheetObj,sCondition);
		//setting value on sheet combo data	
		var sheetComboText="";	  
		var sheetComboCode="";	
		var sheetComboDefault="";	
		//sheetCombo SAVE_NAME
		var comboSaveNames=new Array();
		comboSaveNames[0]="eq_cmpo_cd";
		comboSaveNames[1]="eq_rpr_cd";
		comboSaveNames[2]="mnr_rng_tp_cd_view";  
		comboSaveNames[3]="vol_tp_cd_view";  
		for(var i=0; i < comboListGrid.length;i++){
		 	if(comboListGrid[i] != null){
				//initializing sheetCombo
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
				//setting sheetcombo per tab
				for(var k=0; k<sheetObjects.length; k++) {
					//[CODE][NAME]:Component,Repair
					if(i==0) {
						sheetObjects[k].InitDataCombo (0, comboSaveNames[i], sheetComboCodeText, sheetComboCode ,sheetComboDefault); 
					}
					//[NAME]:RangeType,Type 
					else if(i==2||i==3) {  
						sheetObjects[k].InitDataCombo (0, comboSaveNames[i], sheetComboText, sheetComboCode ,sheetComboDefault); 
					} 
				}
			}    
		}       
		//setting sheet combo
		if (sheetComboText != "") {
	        sheetComboText=sheetComboText.substr(0, sheetComboText.length - 1);	
		}
		if (sheetComboCode != "") {
	        sheetComboCode=sheetComboCode.substr(0, sheetComboCode.length - 1);
		}
		//initialzing sheet 
	    for(i=0;i<sheetObjects.length;i++){
	    	sheetObjects[i].RemoveAll();
        }
	}
	/** 
	 * setting Div sheetCombo
	 * retrieviing Div in case of changing Component,Repair sheetCombo
	 * @param	{IBSheet}	sheetObj sheetObject
	 * @param	{Int}		Row			Row
	 */
	function setDivCombo(sheetObj,Row) {
		var eqCmpoCd=sheetObj.GetCellValue(Row, "eq_cmpo_cd");
		var eqRprCd=sheetObj.GetCellValue(Row, "eq_rpr_cd");
		var costGrpCd=sheetObj.GetCellValue(Row, "cost_grp_cd");
		var prefixCostGrpCd=costGrpCd.substring(0,3);
		if(eqCmpoCd != "") {	
			var compRprJoinStr=ComTrimAll(eqCmpoCd) + ComTrimAll(eqRprCd);	
			var sCondition=new Array (         
			 	new Array("MnrDivCd",compRprJoinStr +','+ prefixCostGrpCd, "COMMON1")
			) 	 	       
			var comboList=MnrComSearchCombo(sheetObj,sCondition);      
			var lbComboText="";   
			var lbComboCode=""; 
			var lbComboCodeText=""; 
			//TS type comboType
			if(comboList[0] != null){     
				for(var j=0; j < comboList[0].length;j++){ 
					var tempText=comboList[0][j].split("|");  
					lbComboCode +=  tempText[0] + "|";       
					lbComboText +=  tempText[1] + "|";
					lbComboCodeText += tempText[0] + "\t" + tempText[1] + "|";
				}      
			}	 	  	
			lbComboCode=MnrDelLastDelim(lbComboCode);
			lbComboCodeText=MnrDelLastDelim(lbComboCodeText);
			dummyEvent=true;
			var origin_trf_div_cd = sheetObj.GetCellValue(Row, "trf_div_cd");
			var info = {"ComboCode":lbComboCode, "ComboText":lbComboCodeText};
			var info1 = {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trf_div_cd",          KeyField:0,   CalcLogic:"",   Format:"", ComboCode:origin_trf_div_cd, ComboText:origin_trf_div_cd,    PointCount:0,   UpdateEdit:1,   InsertEdit:1 };

			sheetObj.InitCellProperty(Row, "trf_div_cd", info1);
			sheetObj.SetCellValue(Row, "trf_div_cd", origin_trf_div_cd);
			sheetObj.SetCellText(Row, "trf_div_cd", origin_trf_div_cd);
			sheetObj.CellComboItem (Row, "trf_div_cd", info); 
			dummyEvent=false;
			sheetObj.SetCellValue(Row, "div_flag","1");//setting search flag
		}
	}
	/** 
	 * setting repair sheetCombo
	 * retrieviing Div in case of changing Component,Repair sheetCombo
	 * @param	{IBSheet}	sheetObj sheetObject
	 * @param	{Int}		Row			Row
	 */
	function setRprCombo(sheetObj,Row) {	
		var eqCmpoCd=sheetObj.GetCellValue(Row, "eq_cmpo_cd");
		if(eqCmpoCd != "") {
			var sCondition=new Array (	  		    
	 			new Array("MnrRprCd",eqCmpoCd,"COMMON")		
	 		)							
			var comboList=MnrComSearchCombo(sheetObjects[0],sCondition);
			var sheetComboCode="";
			var sheetComboText=""; 
			var sheetComboCodeText=""; 
	 		var comboSaveNames=new Array();	
			for(var i=0; i < comboList.length;i++){
			 	if(comboList[i] != null){
					sheetComboText=""; 
					sheetComboCode="";
					sheetComboCodeText="";
			 		for(var j=0; j < comboList[i].length;j++){ 
						var tempText=comboList[i][j].split("|");    
						sheetComboCode +=  tempText[0] + "|";    
						sheetComboText +=  tempText[1] + "|";
						sheetComboCodeText +=  tempText[0] + "\t" + tempText[1] + "|";
					}	
					sheetComboCode=MnrDelLastDelim(sheetComboCode); 																				
			     	sheetComboText=MnrDelLastDelim(sheetComboText);  
			        sheetComboCodeText=MnrDelLastDelim(sheetComboCodeText);
					dummyEvent=true;
					var info = {"ComboCode":sheetComboCode, "ComboText":sheetComboCodeText};
					sheetObj.CellComboItem (Row, "eq_rpr_cd", info);
					dummyEvent=false;
				}   	 
		 	}			
			sheetObj.SetCellValue(Row, "rpr_flag","1");//setting search flag
			//sheetObj.CellValue2(Row ,"eq_rpr_cd") = "";		
		}	
	}
	/** 
	 * setting no match combo 
	 * @param	{IBSheet}	sheetObj sheetObject
	 */
	function setNoMatchCombo(sheetObj) {
		for(var i=sheetObj.HeaderRows(); i<=sheetObj.LastRow(); i++){
			//setting no match combo
			var divCd=sheetObj.GetCellValue(i, "trf_div_cd");
			if(divCd=="") {
				divCd=sheetObj.GetCellText(i,"trf_div_cd");
				sheetObj.SetCellValue(i,"trf_div_cd",divCd);
			}
		}
	}
	/**
	 * showing tab in case of existing value of tabs
	 * @return
	 */
	function setTabSelect(){
		for (var i=0; i<sheetObjects[i].length; i++) {
			var rowCnt=sheetObjects[i].RowCount();
			if(rowCnt>0) {
				tabObjects[0].SetSelectedIndex((i-1));
				return;
			}
		}
	}
	/**
	 * input hidden RangeType in case of changing displayed RangeType
	 * @param sheetObj
	 * @param Row
	 * @param Value
	 * @return
	 */
	function setRangeTypeHidden(sheetObj,Row,Value) {
		sheetObj.SetCellValue(Row, "mnr_rng_tp_cd",Value,0);
	}
	/**
	 * input hidden VolumnType in case of changing displayed VolumnType.
	 * @param sheetObj
	 * @param Row
	 * @param Value
	 * @return
	 */
	function setVolumeTypeHidden(sheetObj,Row,Value) {
		sheetObj.SetCellValue(Row, "vol_tp_cd",Value,1);
	}
	
	function eq_cmpo_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	   eq_cmpo_cd_text.value = newCode;
   }
   
   function eq_cmpo_cd_OnBlur(comboObj) {
	   eq_cmpo_cd_text.value = comboObj.GetSelectCode();
   }