/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ees_mnr_0215.js
*@FileTitle  : MNR Local Tariff Creation & Verify
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/13
=========================================================*/


/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
						MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
						OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

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
	var comboListGrid=new Array();
	//arraylist containing tab menu
	var tabList=new Array();
	var uTab=new Array();  
	var gTab=new Array(); 
	var zTab=new Array(); 
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	/** 
	 * Event handler processing by button name
	 */	
    function processButtonClick(){
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
				case "btn_DownExcel":
					doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
					break;
				case "btn_Close":
					ComClosePopup(); 
					break;
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
    	//setting button
    	MnrWaitControl(true);
        //initializing IBMultiCombo
 	    for(var k=0; k < comboObjects.length; k++){
 	        initCombo(comboObjects[k], k + 1);
 	    }
		//starting i=1 because of hidden sheet
        for(i=1;i<sheetObjects.length;i++){
        	//
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i]);
			//
            ComEndConfigSheet(sheetObjects[i]);
        }
    	setTabName();
    	doActionIBSheet(sheetObjects[1],document.form,IBCLEAR);
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
	    		SetColAlign(1, "left");
	    		SetColWidth(0, "25");
	    		SetColWidth(1, "75");
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
			case "t2sheet1":
			case "t3sheet1":
			case "t4sheet1":
			case "t5sheet1":
			case "t6sheet1":
                with (sheetObj) {
		        var HeadTitle1="|Seq.||Mandatory|Mandatory|Option|Description|Range Type|Volume|Volume|Volume|Limitation|Limitation|Man-Hour||Material|Component Group|Remark(s)";
		        var HeadTitle2="|Seq.||Component|Repair|Division|Description|Range Type|Type|Q'ty|Size/Square|Min|Max|Man-Hour||Material|Component Group|Remark(s)";
		        var headCount=ComCountHeadTitle(HeadTitle1);

		        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

		        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		        var headers = [ { Text:HeadTitle1, Align:"Center"},
		                    { Text:HeadTitle2, Align:"Center"} ];
		        InitHeaders(headers, info);

		        var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		               {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
		               {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:1,   SaveName:"cost_grp_cd" },
		               {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"eq_cmpo_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
		               {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"eq_rpr_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
		               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trf_div_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"dtl_desc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Combo",     Hidden:0, Width:90,   Align:"Left",    ColMerge:1,   SaveName:"mnr_rng_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Combo",     Hidden:0, Width:60,   Align:"Left",    ColMerge:1,   SaveName:"vol_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"rpr_qty",        KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
		               {Type:"Int",       Hidden:0,  Width:85,   Align:"Right",   ColMerge:1,   SaveName:"rpr_sz_no",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
		               {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"fm_rng_sz_no",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:8 },
		               {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"to_rng_sz_no",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:8 },
		               {Type:"Float",     Hidden:0,  Width:65,   Align:"Right",   ColMerge:1,   SaveName:"rpr_lbr_hrs",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
		               {Type:"Text",      Hidden:1, Width:113,  Align:"Right",   ColMerge:1,   SaveName:"mtrl_reco_amt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:18 },
		               {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"mtrl_cost_amt",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:18 },
		               {Type:"Text",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:1,   SaveName:"eq_cmpo_up_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:83,   Align:"Left",    ColMerge:1,   SaveName:"dtl_rmk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"trf_no" },
		               {Type:"Text",      Hidden:1, Width:30,   Align:"Right",   ColMerge:1,   SaveName:"trf_dtl_seq" },
		               {Type:"Text",      Hidden:1, Width:30,   Align:"Right",   ColMerge:1,   SaveName:"inch_size" },
		               {Type:"Text",      Hidden:1, Width:30,   Align:"Right",   ColMerge:1,   SaveName:"cm_size" } ];
		        InitColumns(cols);
		        SetSheetHeight(362);
		        SetEditable(1);
		        SetShowButtonImage(2);
		        SetRangeBackColor(1,3,1,15,"#555555");
                }
                break;
			default:
				break;
        }
    }
	/** 
	 * registering IBCombo Object as list
	 * @param    {IBCombo}	combo_obj	adding ComboObject.
	 */	
    function setComboObject(combo_obj){
 		comboObjects[comboCnt++]=combo_obj; 
 	}
    /**
     * registering IBTab Object as lis
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
	/** 
	 * COMBO change event
	 * resetting tab in case of changing EQ Type
	 * @param	{IBMultiCombo}	comboObj	Changed combo object
	 * @param	{Number}		Index_Code	Changed combo code
	 * @param	{String}		Text		Changed combo name
	 */
	function combo2_OnChange(comboObj,Index_Code, Text){
		//EQ Type
		comboValue=comboObj.GetSelectCode();
		// resetting Tab, retrieving sheetCombo
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
	}   
    /**
     * Event when clicking Tab
     * activating selected tab items.
     */
    function tab1_OnChange(tabObj , nItem){
        var objs=document.all.item("tabLayer");
    	objs[nItem].style.display="Inline";
    	objs[beforetab].style.display="none";
    	//--------------- importance --------------------------//
    	objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
    	//------------------------------------------------------//
    	beforetab=nItem;
    }
	/** 
	 * setting after retrieving
	 * @param	{IBSheet}	sheetObj sheetObject
	 * @param	{String}	ErrMsg		errorMessage
	 */
	function t1sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		if(!checkIsDetailRow()) {return;}
		doAfterSearch();
	}
	/** 
	 * setting after retrieving
	 * @param	{IBSheet}	sheetObj sheetObject
	 * @param	{String}	ErrMsg		errorMessage
	 */
	function t2sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		if(!checkIsDetailRow()) {return;}
		doAfterSearch();
	}
	/** 
	 * setting after retrieving
	 * @param	{IBSheet}	sheetObj sheetObject
	 * @param	{String}	ErrMsg		errorMessage
	 */
	function t3sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		if(!checkIsDetailRow()) {return;}
		doAfterSearch();
	}
	/** 
	 * setting after retrieving
	 * @param	{IBSheet}	sheetObj sheetObject
	 * @param	{String}	ErrMsg		errorMessage
	 */
	function t4sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		if(!checkIsDetailRow()) {return;}
		doAfterSearch();
	}
  	/**
     * handling Sheet1 reference
     * @param	{IBSheet}	sheetObj	SheetObject 
     * @param	{Form}		formObj		formObject
     * @param	{Number}	sAction		action constants(CoObject.js defined) 
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
	   	sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			//initialzing
			case IBCLEAR:
				sheetObj.SetWaitImageVisible(0);
				MnrWaitControl(true);
	        	//initializing Combo Data
				for(var i=0; i < comboObjects.length;i++){ 
					comboObjects[i].RemoveAll();
				}
				//retrieving combo data(UnitOfMass, Currency)
				var sCondition=new Array (
					new Array("MnrGenCd","CD00007", "COMMON"), 	//Status
					new Array("MnrGenCd","","CUSTOM9"),  	//EQ Type
					new Array("MnrGenCd","CD00010", "COMMON"), 	//UnitOfMass
					new Array("MdmCurrency","", "COMMON"),		//Currency
					new Array("MnrGenCd","CD00012", "COMMON"),	//RangeType
					new Array("MnrGenCd","CD00013", "COMMON")	//Type
				)             
				var comboList=MnrComSearchCombo(sheetObj,sCondition);
				var sheetComboText="";  
				var sheetComboCode="";
				var sheetComboDefault="";
				//sheetCombo SAVE_NAME
				var comboSaveNames=new Array();
				comboSaveNames[0]="mnr_rng_tp_cd";  
				comboSaveNames[1]="vol_tp_cd"; 
				//setting on combo data        
				for(var i=0; i<comboList.length ; i++){
					if(comboList[i] != null){
						//initializing sheetCombo
						sheetComboText="";
						sheetComboCode="";
						sheetComboCodeText="";
						sheetComboDefault=""; 
						//Display[CODE_NAME]:Status,EQ Type,UnitOfMass 
						if(i==0 || i==1 || i==2) {
							for(var j=0; j < comboList[i].length;j++){ 
								var tempText=comboList[i][j].split("|");    
								//Status
								if(i==0) {
									combo1.InsertItem(j, tempText[1] ,tempText[0]);
								//EQ Type
								} else if(i==1){
									combo2.InsertItem(j, tempText[1] ,tempText[0]);
								//UnitOfMass
								} else if(i==2) {
									combo3.InsertItem(j, tempText[1] ,tempText[0]);
								}
							}
						//Display[CODE]:Currency
						} else if(i==3){
							for(var j=0; j < comboList[i].length;j++){ 
								combo4.InsertItem(j, comboList[i][j] ,j);
							}
						//setting sheetcombo
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
						//setting sheetcombo per tab
						for(var k=1; k<sheetObjects.length; k++) {
							if(i==4||i==5) {
								sheetObjects[k].InitDataCombo (0, comboSaveNames[i-4], sheetComboText, sheetComboCode ,sheetComboDefault);
							}
						}
					}
				}
				//setting EQ Type,Currency combo enable
				comboObjects[0].SetEnable(0);//Status
				comboObjects[1].SetEnable(0);//EQ Type
				comboObjects[2].SetEnable(0);//UnitOfMass
				comboObjects[3].SetEnable(0);//Currency
				
				formObj.search_trf_no.readOnly = true;
				formObj.eff_dt.readOnly = true;
				formObj.rqst_ofc_cd.readOnly = true;
				formObj.vndr_seq.readOnly = true;
				
				//Search
				doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
				MnrWaitControl(false);
				sheetObj.SetWaitImageVisible(1);
                break;
			//retrieving
            case IBSEARCH:
				sheetObj.SetWaitImageVisible(1);
				formObj.f_cmd.value=SEARCH;      
                if(validateForm(sheetObj,formObj,sAction)) {
					//multiple retrieving
 					var sXml=sheetObj.GetSearchData("EES_MNR_0014GS.do", FormQueryString(formObj));
					var arrXml=sXml.split("|$$|");
					//Header
					var arrResult=MnrXmlToArray(arrXml[0]);
					if(arrResult != null){
						formObj.eff_dt.value=arrResult[0][6];  //Contract Start Date
						formObj.rqst_ofc_cd.value=arrResult[0][4];	//Tariff Office
						formObj.vndr_seq.value=arrResult[0][1];	//S/Provider Code
						formObj.cre_dt.value=arrResult[0][9];  //creating date
						formObj.cre_usr_id.value=arrResult[0][14]; //creating User ID
						formObj.mnr_trf_rmk.value=arrResult[0][18]; //Remark(s)
						if(arrResult[0][1] != "") {
							doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC01); //S/Provider Name
						}
						combo4.SetSelectText(arrResult[0][7]);//Currency
						combo1.SetSelectCode(arrResult[0][23]);//Tariff Status Code
						combo2.SetSelectCode(arrResult[0][24]);//EQ Type(U:CONTAINER,Z:CHASSIS,G:GENSET)
						combo3.SetSelectCode(arrResult[0][10]);//Unit Of Mass (CMT:CM, INC:inch)
					} else {
						ComShowCodeMessage("MNR00204");
						return;
					}
					//0 vndr_seq|1 vndr_nm|2 agmt_no|3 rqst_ofc_cd|4 pagerows|5 eff_dt|6 curr_cd|7 ibflag|8 cre_dt|9 mnr_meas_ut_cd|10 upd_usr_id|11 apro_ofc_cd|12 cre_usr_id|13 mnr_trf_sts_dt|14 mnr_trf_knd_cd|15 sts_ref_no|16 mnr_trf_rmk|17 trf_no|18 cre_usr_nm|19 eq_knd_nm|20 mnr_inp_tp_cd|21 mnr_trf_sts_cd|22 eq_knd_cd|23 upd_dt|24 pre_trf_no|
					//vndr_seq|vndr_nm|agmt_no|rqst_ofc_cd|pagerows|eff_dt|curr_cd|ibflag|cre_dt|mnr_meas_ut_cd|upd_usr_id|apro_ofc_cd|cre_usr_id|mnr_trf_sts_dt|mnr_trf_knd_cd|sts_ref_no|mnr_trf_rmk|trf_no|cre_usr_nm|eq_knd_nm|mnr_inp_tp_cd|mnr_trf_sts_cd|eq_knd_cd|upd_dt|pre_trf_no
					//MnrXmlToArrayDebug('vndr_seq|vndr_nm|agmt_no|rqst_ofc_cd|pagerows|eff_dt|curr_cd|ibflag|cre_dt|mnr_meas_ut_cd|upd_usr_id|apro_ofc_cd|cre_usr_id|mnr_trf_sts_dt|mnr_trf_knd_cd|sts_ref_no|mnr_trf_rmk|trf_no|cre_usr_nm|eq_knd_nm|mnr_inp_tp_cd|mnr_trf_sts_cd|eq_knd_cd|upd_dt|pre_trf_no');
					//Detail
					var eqTypeCd=arrResult[0][24];
					if(eqTypeCd=="U") {
						for(var i=1; i < arrXml.length; i++){
							sheetObjects[i].LoadSearchData(arrXml[i],{Sync:1} );
						}
						setTabSelect(); //tab select
					} 
					else if (eqTypeCd=="Z") {
						sheetObjects[1].LoadSearchData(arrXml[5],{Sync:1} );
					}
					else if (eqTypeCd=="G") {
						sheetObjects[1].LoadSearchData(arrXml[6],{Sync:1} );
					}
				}
                break;
			//retrieving(in case of existing sevice provider No.)
			case IBSEARCH_ASYNC01:	
				if ( validateForm(sheetObj, formObj, sAction) ) { 
					//Service Provider Detail Information  
					var sXml=MnrGetPartner(sheetObj,formObj.vndr_seq.value,"RPR");  
					if(ComGetEtcData(sXml, "vndr_seq") != ""){ 
						//setting Vender nm		
						ComSetObjValue(formObj.vndr_nm, ComGetEtcData(sXml, "vndr_lgl_eng_nm"));  
					} else {       
						ComShowCodeMessage("MNR00005", "Service Provider");              
						ComSetObjValue(formObj.vndr_nm, ""); 
						ComSetObjValue(formObj.vndr_seq, "");
						ComSetFocus(formObj.vndr_seq);
					}   
				}	
				break; 		
            //Down Excel
			case IBDOWNEXCEL:
				var eqTypeCd=comboValue;
				if(eqTypeCd=="U"){
					for(var i=1; i<=4; i++) {
						if(sheetObjects[i].RowCount()> 0){
							//sheetObjects[i].Down2Excel4FreeForm(-1,true);
 							sheetObjects[i].Down2Excel( {DownCols: makeHiddenSkipCol(							sheetObjects[i]), SheetDesign:1,Merge:1 });
						}
					}
				} else {
					//sheetObj.Down2Excel(-1); 
 					sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(					sheetObj), SheetDesign:1,Merge:1 });
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
			if(sAction==IBSEARCH){
			}
        }
        return true;
    }
/* ********* User Functions ************* */
	/**
	 * Checking the existence of the grid
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
	 * setting Size/Square depending on  Volume Type combo value.
	 * Volume Type:Q -> Size/Square=0, 		Volume Type:S -> Q'ty=0 
	 * @param	{IBSheet}	sheetObj sheetObject
	 * @param	{Int}		Row			Row
	 * @param	{String}	Val			Value
	 */
    function setEditableByVolumeType(sheetObj,Row){
var volTpCd=sheetObj.GetCellValue(Row, "vol_tp_cd");  //Volume Type
		//Q'ty
		if(volTpCd=='Q'){
			//sheetObj.CellValue2(Row, "fm_rng_sz_no")	= "";
			//sheetObj.CellValue2(Row, "to_rng_sz_no")	= "";
			sheetObj.SetCellValue(Row, "rpr_sz_no","",0);
		//Size/Square
		} else {
			sheetObj.SetCellValue(Row, "rpr_qty","",0);
		}
	}
	/** 
	 * handling after retrieving
	 */
	function doAfterSearch() {
		for(var i=1; i<sheetObjects.length; i++) {
			for(var j=sheetObjects[i].HeaderRows(); j<=sheetObjects[i].LastRow(); j++){
				setEditableByVolumeType(sheetObjects[i],j);	
			}
		}
	}
	/**
	 * setting tab name
	 */
	function setTabName() {
		var sCondition=new Array (
			new Array("MnrGenCd","CC", "CUSTOM3")  //retrieving tab name
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
			new Array("MnrGenCd","CD00012", "COMMON"),	//RangeType
			new Array("MnrGenCd","CD00013", "COMMON")//,	//Type
		)             
		comboListGrid=MnrComSearchCombo(sheetObj,sCondition);
		//setting value on sheet combo data
		var sheetComboText="";  
		var sheetComboCode="";
		var sheetComboDefault="";
		//sheetCombo SAVE_NAME
		var comboSaveNames=new Array();
		comboSaveNames[0]="mnr_rng_tp_cd";  
		comboSaveNames[1]="vol_tp_cd"; 
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
				for(var k=1; k<sheetObjects.length; k++) {
					sheetObjects[k].InitDataCombo (0, comboSaveNames[i], sheetComboText, sheetComboCode ,sheetComboDefault); 
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
	 * showing tab in case of existing value of tabs
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
/* developer job	*/		
