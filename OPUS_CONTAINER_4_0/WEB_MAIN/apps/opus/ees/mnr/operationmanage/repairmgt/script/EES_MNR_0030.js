/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   :EES_MNR_0030.js
*@FileTitle  : W/O Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/19
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
						MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
						OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ees_mnr_0030 : business script for ees_mnr_0030.
     */
/* ********* General Functions ************* */	
	// common global variables
	var comboObjects=new Array();
	var comboCnt=0;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var combo1;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
		var sheetObject=sheetObjects[0];
		var sheetObject1=sheetObjects[1];
		/*******************************************************/
		var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
				case "btn_New":
					doActionIBSheet(sheetObject,document.form,IBCLEAR,1);
					break;
				case "btn_retrive":
			        doActionIBSheet(sheetObject,formObject,IBSEARCH,0);
//			        doActionIBSheet(sheetObject1,formObject,IBSEARCH,0);
			        break;
				case "btn_Creation":
					doActionIBSheet(sheetObject1,formObject,IBSAVE);
			        break;
				case "btn_DocSend":
					doActionIBSheet(sheetObject1,formObject,"docSend");
			        break;
				//calendar
				case "apro_dt_cal":
					 var cal=new ComCalendar();
	                 cal.select(formObject.apro_dt_fr, 'yyyy-MM-dd');
					break;
				//W/O No popup
				case "wo_no_popup":
				    ComOpenPopup("EES_MNR_0211.do?", 725, 400, 'setEES_MNR_0211', '0,0', true);
					break;
				case "btn_Detail":
					if(sheetObjects[1].RowCount()< 1) {
						ComShowCodeMessage("MNR00024");
						return;
					}
					var selectedRow=sheetObjects[1].GetSelectRow();
					var rqstEqNo=sheetObjects[1].GetCellValue(selectedRow, "rqst_eq_no");
					var rprRqstSeq=sheetObjects[1].GetCellValue(selectedRow, "rpr_rqst_seq");
					var rprRqstVerNo=sheetObjects[1].GetCellValue(selectedRow, "rpr_rqst_ver_no");
					var eqKndCd=sheetObjects[1].GetCellValue(selectedRow, "eq_knd_cd");
					ComOpenPopup('/opuscntr/EES_MNR_0192.do?rqst_eq_no='+rqstEqNo+"&rpr_rqst_seq="+rprRqstSeq+"&rpr_rqst_ver_no="+rprRqstVerNo+"&eq_knd_cd="+eqKndCd, 1024, 768, '', '0,0', false);
					break;	
				case "btn_DownExcel":	
					if(sheetObject1.RowCount() < 1){//no data
		        		ComShowCodeMessage("COM132501");
		        	}else{
		        		 sheetObject1.Down2Excel({DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1 });
		        	}
					//sheetObjects[1].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[1]), SheetDesign:1,Merge:1 });
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
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i + 1);
            ComEndConfigSheet(sheetObjects[i]);
        }
		// initializing Axon event
		initControl();
		//initializing form
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR, 0);
		//set Focus
//		document.form.status.focus();
    }
  	/**
     * IBsetting combo basic info
     * @param	{IBCombo}	comboObj	initializing ComboObject 
     * @param	{Number}	comboNo		ComboObject tag serial number
     */
    function initCombo(comboObj, comboId) {
	    var cnt=0 ;
	    var objCb = comboObj.options;
	    var formObject=document.form;
	    switch(objCb.id) {
//	    	case "comboStatus": 
//	    	case "eq_knd_cd": 
//	            with (comboObj) { 
//		    		SetColAlign(0, "left");
//		    		SetColAlign(1, "left");
//		    		SetColWidth(0, "25");
//		    		SetColWidth(1, "75");
//		        }
//	            break;
	    	case "comboVndrSeq": 
	            with (comboObj) { 
			   	  	SetTitle("S/P Name|S/P Code|AGMT No|AGMT Office|EQ TYPE|Effective Date|Reference No|Tariff No"); 
			   	  	SetColAlign(0, "left");
			   	  	SetColAlign(1, "left");
			   	  	SetColAlign(2, "center");
			   	  	SetColAlign(3, "center");
			   	  	SetColAlign(4, "left");
			   	  	SetColAlign(5, "center");
			   	  	SetColAlign(6, "left");
			   	  	SetColAlign(7, "left");
			   	  	SetColWidth(0, "150");
			   	  	SetColWidth(1, "70");
			   	  	SetColWidth(2, "70");
			   	  	SetColWidth(3, "90");
			   	  	SetColWidth(4, "70");
			   	  	SetColWidth(5, "155");
			   	  	SetColWidth(6, "90");
			   	  	SetColWidth(7, "140");
			   	  	SetTitleVisible(true);
					SetDropHeight(160);
	    			}
	            	break;
			case "cost_cd":
				with (comboObj) { 
		    		SetMultiSeparator("|");
					SetTitle("Code|Name");	
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "65");
					SetColWidth(1, "135");
					SetDropHeight(160);
					SetUseAutoComplete(1);
					SetTitleVisible(true);
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
     * @param	{IBSheet}	sheetObj	initializing sheetObject 
     * @param	{String}	sheetNo		sheetObject tag serial number
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      //t1sheet1 init
                with(sheetObj){
               
              var HeadTitle="Seq.|Service\nProvider|Transmission\nMode|Pend.";

              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );

              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
                     {Type:"Text",      Hidden:0,  Width:75,   Align:"Left",    ColMerge:0,   SaveName:"vndr_nm",      KeyField:0,   CalcLogic:"",   Format:"" },
                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"trsm_mod_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pending",      KeyField:0,   CalcLogic:"",   Format:"" },
                     {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"vndr_seq",     KeyField:0,   CalcLogic:"",   Format:"" },
                     {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"trsm_mod_cd",  KeyField:0,   CalcLogic:"",   Format:"" } ];
               
              InitColumns(cols);
//              SetSheetHeight(332);
              SetEditable(0);
              SetSelectionMode(smSelectionRow);
              SetShowButtonImage(2);
              resizeSheet( sheetObj );
              }
                break;
            case 2:      //t1sheet1 init
                with(sheetObj){
                
              (22, 0, 0, true);
              var HeadTitle="|Seq.|Sel|EST No.|EQ Type|EQ No.|TP/SZ|Cost Code|Cost Code Name|Repair\nYard|Cur.|Total\nAmount|Audit\nOffice|Audit\nUSER|Audit\nDate|Input\nDate|DMG\nFlag|W/O No.|W/O Date|W/O Send Date|Booking No|Trade Code";

              SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0 } );

              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
              var headers = [ { Text:HeadTitle, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                     {Type:"Text",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"tmp_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",   ColMerge:1,   SaveName:"sel_chk",             KeyField:0,   CalcLogic:"",   Format:"" },
                     {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:1,   SaveName:"rqst_ref_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:55,   Align:"Left",    ColMerge:1,   SaveName:"eq_knd_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rqst_eq_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0, Width:60,   Align:"Center",   ColMerge:0,   SaveName:"cost_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:0,   SaveName:"cost_cd_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"rpr_yd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"mnr_wrk_amt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"apro_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"apro_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"apro_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"rqst_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"CheckBox",  Hidden:0, Width:55,   Align:"Center",  ColMerge:1,   SaveName:"mnr_dmg_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 , TrueValue:"Y", FalseValue:"N"},
                     {Type:"Text",      Hidden:0,  Width:68,   Align:"Center",  ColMerge:1,   SaveName:"wo_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Date",      Hidden:0,  Width:68,   Align:"Center",  ColMerge:1,   SaveName:"wo_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Date",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"mnr_ord_snd_dt",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rpr_rqst_seq" },
                     {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rpr_rqst_ver_no" },
                     {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"hidden_mnr_dmg_flg" },
                     {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"eq_knd_cd" } ];
               
              InitColumns(cols);
//              SetSheetHeight(332);
              SetEditable(1);
              SetSelectionMode(smSelectionRow);
              SetShowButtonImage(2);
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
	    //axon_event.addListenerFormat('focus',  		'obj_focus',    document.form); 
	    //axon_event.addListenerForm	('keypress',	'obj_keypress', document.form);	
    }
	/** 
	 * registering IBCombo Object as list
	 * @param    {IBCombo}	combo_obj	registering IBCombo Object as list
	 */	
    function setComboObject(combo_obj){
 		comboObjects[comboCnt++]=combo_obj; 
 	}
	/** 
	 * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items
     * defining list on the top of source
	 * @param    {IBSheet}	sheet_obj	registering IBSheet Object as list
	 */	
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
	/**
     * object list for using combo1 
     */
	function combo1List(){
		this.items=[];		
	}
	/**
     * object for using combo1
     */
	function combo1AGMT(vndr_seq,vndr_nm,agmt_no,agmt_ver_no,eff_dt,exp_dt,trf_no,agmt_ref_no,eq_knd_cd,curr_cd,trsm_mod_cd,edi_id){
		this.vndr_seq=vndr_seq;         
		this.vndr_nm=vndr_nm;	        
		this.agmt_no=agmt_no;         
		this.eff_dt=eff_dt;	        
		this.exp_dt=exp_dt;          
		this.agmt_ref_no=agmt_ref_no;      
		this.trf_no=trf_no;          
		this.agmt_ver_no=agmt_ver_no;     
		this.eq_knd_cd=eq_knd_cd;	
		this.curr_cd=curr_cd;         
		this.trsm_mod_cd=trsm_mod_cd; 
		this.edi_id=edi_id;   
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
//	function obj_keypress(){
//		obj=event.srcElement;
//	    if(obj.dataformat == null) return;
//	    window.defaultStatus=obj.dataformat;
//		switch(obj.dataformat) {
//	        case "engup":
//	          	if(obj.name=="wo_no"){
//					ComKeyOnlyAlphabet('uppernum','44'); //','	
//				} else {
//					ComKeyOnlyAlphabet('uppernum');	
//				}          
//	            break;
//			case "ymd":
//				ComKeyOnlyNumber(event.srcElement);
//				break;
//	    } 
//	}
	/** 
	 * COMBO changing event
	 * setting Display (W/O Creation, Doc Send) in case of changing Status
	 * @param	{IBMultiCombo}	comboObj	changed comboObject
	 * @param	{Number}		Index_Code	changed combo code
	 * @param	{String}		Text		changed combo name
	 */
	function comboStatus_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
		// initializing IBSheet All 	
		var formObj=document.form;
		formObj.comboStatus_text.value = comboObj.GetText(parseInt(newIndex), 0);
		formObj.status.value = newCode;
	    for(i=0;i<sheetObjects.length;i++){
	    	sheetObjects[i].RemoveAll();
        }
		var status=ComGetObjValue(comboObj);
		if(status=="I") {
			$('#btn_Creation').show();
			$('#btn_DocSend').hide();
		} else if (status=="R") {
			$('#btn_Creation').hide();
			$('#btn_DocSend').show();
			for (var i=sheetObjects[1].HeaderRows(); i<=sheetObjects[1].LastRow(); i++) {
				sheetObjects[1].SetCellEditable(i, "mnr_dmg_flg",0);
			}
		} else {
			ComShowCodeMessage("MNR00036","Status");
		}
	}   
	/** 
	 * COMBO changing event
	 *     setting EQ Type and Hidden Service Provider in case of changing Service Provider
	 * @param	{IBMultiCombo}	comboObj	changed comboObject
	 * @param	{Number}		Index_Code	changed combo code
	 * @param	{String}		Text		changed combo name
	 */
	function comboVndrSeq_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
		var formObj=document.form;        
		var selectedIndex=comboObj.GetSelectCode();
		if(selectedIndex=="A") {
			formObj.vndr_seq.value="A";
			eq_knd_cd.SetSelectCode("A");
		} else {
			formObj.vndr_seq.value=combo1.items[selectedIndex].vndr_seq;
			eq_knd_cd.SetSelectCode(combo1.items[selectedIndex].eq_knd_cd);
		}
	}   
	/** 
	 * selectCell event on Master Sheet
	 *     retrieving Detail Sheet after Master Sheet
	 * @param	{Sheet}			sheetObj	handling sheetObject
	 * @param	{Long}			OldRow		Row Index of Selected cell 
	 * @param	{Long/String}	OldCol		Column Index or SaveName of Selected cell
	 * @param	{Long}			NewRow		new Row Index
	 * @param	{Long/String}	NewCol		new Column Index or SaveName
	 */
	function sheetMaster_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
        var formObject=document.form;
        formObject.selected_vndr_seq.value=sheetObj.GetCellValue(NewRow, "vndr_seq");
        doActionIBSheet(sheetObjects[1],formObject,IBSEARCH, 1);
	}
	/** 
	 * setting after retrieving
	 * 
	 * @param	{IBSheet}	sheetObj	sheetObject
	 * @param	{String}	ErrMsg		errorMessage
	 */
	function sheetDetail_OnSearchEnd(sheetObj, ErrMsg) {
		
		var status = ComGetObjValue(comboStatus);
		if(status == "R") {
			for (var i=sheetObjects[1].HeaderRows(); i<=sheetObjects[1].LastRow(); i++) {
				sheetObjects[1].SetCellEditable(i, "mnr_dmg_flg",0);
			}
		} else {
			for (var i=sheetObjects[1].HeaderRows(); i<=sheetObjects[1].LastRow(); i++) {
				sheetObjects[1].SetCellEditable(i, "mnr_dmg_flg",1);
			}
		}
	}
	/** 
	 * showing message after saving
	 * @param	{IBSheet}	sheetObj	sheetObject of Saving event
	 * @param	{String}	ErrMsg		errorMessage
	 */
	function sheetDetail_OnSaveEnd(sheetObj,ErrMsg){
		if (ErrMsg == "") {
			ComShowCodeMessage("MNR00073");
			comboStatus.SetSelectCode('R');//Status
			document.form.wo_no.value=sheetObj.GetEtcData("wo_nos");
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH, 0);
		} 
		else { 
			ComShowCodeMessage("MNR00008",ErrMsg);  
		} 
	}     
  	/**
     * handling process sheet
     * @param	{IBSheet}	sheetObj	handling sheetObject 
     * @param	{Form}		formObj		handling formObject
     * @param	{Number}	sAction		Action constants  
     */
    function doActionIBSheet(sheetObj,formObj,sAction, sheetIdx) {
        sheetObj.ShowDebugMsg(false);
    	switch(sAction){
			//initializing
			case IBCLEAR:
				sheetObj.SetWaitImageVisible(0);
		    	MnrWaitControl(true);
				// initializing IBSheet All 	 
			    for(i=0;i<sheetObjects.length;i++){
			    	sheetObjects[i].RemoveAll();
		        }
			    //Only Loading
				if(sheetIdx == 0) {
		        	//initializing Combo Data
					for(var i=0; i < comboObjects.length;i++){ 
						comboObjects[i].RemoveAll();
					}
					//retrieving combo data(Status)
					var sCondition=new Array (
						new Array("MnrGenCd","CD00025", "COMMON"), 	//Status
						new Array("MnrGenCd","","CUSTOM9"));             
					var comboList=MnrComSearchCombo(sheetObj,sCondition);
					//setting combo data        
					for(var i=0; i<comboList.length ; i++){
						if(comboList[i] != null){
							//Display[CODE_NAME]:Status 
							for(var j=0; j < comboList[i].length;j++){ 
								var tempText=comboList[i][j].split("|");    
								comboObjects[i].InsertItem(j, tempText[1].toString() ,tempText[0].toString());
							}
						}
					}
					eq_knd_cd.InsertItem(0, "ALL" ,"A" );
					//Service Provider Combo
					combo1=new combo1List();	
					var sXml=MnrAGMTHdrCombo(sheetObj,formObj.cost_ofc_cd.value);
					var arrResult=MnrXmlToArray(sXml);
					//0 trsm_mod_cd|1 vndr_seq|2 agmt_ref_no|3 eq_type_name|4 agmt_ofc_cty_cd|5 agmt_dt|6 agmt_seq|7 agmt_rmk|8 vndr_nm|9 agmt_no|10 agmt_type_tpsz|11 pagerows|12 agmt_ver_no|13 eff_dt|14 curr_cd|15 exp_dt|16 ibflag|17 cre_dt|18 upd_usr_id|19 delt_flg|20 agmt_prifix|21 pay_term_dys|22 edi_id|23 cre_usr_id|24 agmt_lst_ver_flg|25 trf_no|26 isversionup|27 agmt_display_type|28 eq_knd_cd|29 mnr_meas_ut_nm|30 agmt_ofc_cd|31 upd_dt|
					if(arrResult != null){	  	     
						for(var i=0; i < arrResult.length;i ++){ 			
							combo1.items.push(new combo1AGMT(arrResult[i][1],arrResult[i][8],arrResult[i][9],arrResult[i][12],arrResult[i][13],arrResult[i][15],arrResult[i][25],arrResult[i][2],arrResult[i][28],arrResult[i][14],arrResult[i][0],arrResult[i][22]));		
							var tempComboText=arrResult[i][8] + "|" + arrResult[i][1] + "|" + arrResult[i][9] + "|" + arrResult[i][30] + "|" + arrResult[i][3] + "|" + arrResult[i][13] + " ~ " + arrResult[i][15] + "|" + arrResult[i][2] + "|" + " " + arrResult[i][25];  					
						comboVndrSeq.InsertItem(i, tempComboText ,String(i));                
						}	 			 						
						comboVndrSeq.InsertItem(0, "ALL" ,"A" );
					} else {		
						ComShowCodeMessage("MNR00056");         
					} 	  
				}
				// setting initial combo value
				comboStatus.SetSelectCode("I");//Status
				eq_knd_cd.SetSelectCode("A");//EQ Type
			    comboVndrSeq.SetSelectCode("A");//Service Provider
			    // initializing       
				formObj.apro_dt_fr.value=ComGetDateAdd(ComGetNowInfo("ymd"), "D", -7);
			    formObj.apro_dt_to.value=ComGetNowInfo("ymd");
				formObj.wo_no.value="";
				formObj.rqst_eq_no.value="";
				// setting hidden column
				sheetObjects[1].SetColHidden("hidden_mnr_dmg_flg",1);
				MnrWaitControl(false);
				sheetObj.SetWaitImageVisible(1);
				formObj.status.value = comboStatus.GetSelectCode();
				break;
			//retrieving
            case IBSEARCH:
            	if(validateForm(sheetObj,formObj,sAction)) {
	            	// retrieving Master
	            	if(sheetIdx == 0) {
	                    if(validateForm(sheetObj,formObj,sAction)) {
	    					sheetObj.SetWaitImageVisible(1);
	    					formObj.f_cmd.value=SEARCH;
	    					var sXml=sheetObj.GetSearchData("EES_MNR_0030GS.do", FormQueryString(formObj));
	    					sheetObj.LoadSearchData(sXml,{Sync:0} );
	    				}
	                //retrieving Detail
	            	} else if(sheetIdx == 1){
						sheetObj.SetWaitImageVisible(1);
						formObj.f_cmd.value=SEARCH01;
						var sXml=sheetObj.GetSearchData("EES_MNR_0030GS.do", FormQueryString(formObj));
						sheetObj.LoadSearchData(sXml,{Sync:0} );
	            	}
            	}
                break;
            //saving
            case IBSAVE:        
                if(validateForm(sheetObj,formObj,sAction)) {
                	//setting Status
                	setStatusBySelChk(sheetObj);
                	formObj.f_cmd.value=MULTI;
					var sParam=ComGetSaveString(sheetObjects);
				    if (sParam == "") return;
				    sParam += "&" + FormQueryString(formObj);
				    var sXml=sheetObj.GetSaveData("EES_MNR_0030GS.do", sParam);
				    sheetObj.LoadSaveData(sXml);
				}
                break;
            //Doc Send
            case "docSend":
            	if(validateForm(sheetObj,formObj,sAction)) {
					var wo_nos=new Array();
					var cnt=0;
					for(var i=sheetObjects[1].HeaderRows(); i<=sheetObjects[1].LastRow(); i++) {
						var selChk=sheetObjects[1].GetCellValue(i, "sel_chk");
					    if(selChk=="1") {
					    	wo_nos[cnt]=sheetObjects[1].GetCellValue(i, "wo_no");
					    	cnt++;
					    }
					}
					var wo_no=ComGetAryJoin(wo_nos, "|");
				    ComOpenPopup('/opuscntr/EES_MNR_0036.do?wo_no='+wo_no, 900, 600, '', '0,1', true);
            	}
            	break;
            
            case IBSEARCH_ASYNC02:	//retrieving(in case of changing EQ Type)
				sheetObj.SetWaitImageVisible(0);
				if ( validateForm(sheetObj, formObj, sAction) ) { 
					//Cost Code						
					cost_cd.RemoveAll();
					var sCondition=new Array ( 		 
						new Array("MnrGenCd",eq_knd_cd.GetSelectCode()+ "G", "COMMON")
					)  	                           
					var comboList=MnrComSearchCombo(sheetObjects[0],sCondition); 
					cost_cd.InsertItem(0,"ALL| |ALL","A");		  
					if(comboList[0] != null){		  
						
						for(var j=0; j < comboList[0].length;j++){  
							var tempText=comboList[0][j].split("|");  
							var tempTxt = tempText[0]+"-"+tempText[1];
							cost_cd.InsertItem(j + 1,tempText[0]+"|"+tempText[1]+"|"+tempTxt,tempText[0]);
						} 			      
					}		
				    cost_cd.SetSelectCode("A");
				}		
				sheetObj.SetWaitImageVisible(1);
				break;
				
            default:
                break;
        }
    }
  	/**
     * handling process for input validation
     * @param	{IBSheet}	sheetObj	checking sheetObject 
     * @param	{Form}		formObj		checking comboObject
     * @param	{Number}	sAction		Action constants  
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
	        //W/O Creation
        	if(sAction==IBSAVE) {
        		//not existing retrieving result Detail Sheet  
        		if(sheetObj.RowCount() < 1) {
        			ComShowCodeMessage("MNR00024");
        			return false;
        		}
				if(sheetObj.FindCheckedRow("sel_chk") == ""){
					ComShowCodeMessage("MNR00038","W/O Creation ");
					return false;             	   
				}
				//existing W/O No
				for(var i=sheetObjects[1].HeaderRows(); i<=sheetObjects[1].LastRow(); i++) {
					var selChk=sheetObjects[1].GetCellValue(i, "sel_chk");
					var woNo=sheetObjects[1].GetCellValue(i, "wo_no");
					if(selChk=="1" && woNo!="") {
						ComShowCodeMessage("MNR00208",i+" row\'s W/O No.", "Creation ");
						sheetObjects[1].SelectCell(i, "sel_chk", true);
						return false;
					}
				}
	        }
        	//Doc Send
        	else if (sAction=="docSend") {
        		//not existing retrieving result Detail Sheet  
        		if(sheetObj.RowCount()< 1) {return false;}
				if(sheetObj.FindCheckedRow("sel_chk") == ""){
					ComShowCodeMessage("MNR00038","Doc Send ");
					return false;             	   
				}
        	}
        	else if (sAction==IBSEARCH){
        		if(ComGetDaysBetween(formObj.apro_dt_fr.value, formObj.apro_dt_to.value) < 0){
					ComShowCodeMessage("MNR00366");
    				ComSetFocus(formObj.apro_dt_fr);
    				return false;
				}
        	}
    	}
        return true;
    }
    /* ********* User Functions ************* */
  	/**
     * setting status in case of Saving
     * 
     * @param	{IBSheet}	sheetObj	checking sheetObject 
     */
    function setStatusBySelChk(sheetObj){
		for(var i=sheetObj.HeaderRows(); i<=sheetObj.LastRow(); i++) {
			var selChk=sheetObj.GetCellValue(i, "sel_chk");
			if(selChk=="1") {
				sheetObj.SetRowStatus(i,"U");
			} else {
				sheetObj.SetRowStatus(i,"R");
			}
		}
    }
    /**
     * setting return value from pop up
     * 
     * @param	{Array}	array	return list 
     */
    function setEES_MNR_0211(array) {
        if(array == null)return;
        var formObj=document.form;
           var str=array + "";
           var arr=str.split(',');
           formObj.wo_no.value=arr[4];
     }
    
    function eq_knd_cd_OnChange(comboObj, oldindex, oldtext, oldcode, newindex, newtext, newcode){ 
    	//setting Cost Cd combo
    	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
    } 
