/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0136.js
*@FileTitle  : MNR Regional Tariff Approval 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

/* developer job	*/
	// ********* General Functions *************
	// common global variables
	var comboObjects=new Array();
	var comboCnt=0;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var saveType=0; //(0:Approval, 1:Reject, 2:Delete)
	var saveMsg=""; 
	// Office level of login user :  HO level -> L1, RHQ level -> L2, Office level -> L3 (setting at MnrOfficeLevel function(CoMnr.js reference)
	var strMnrOfficeLevel="";	
	// Event handler processing by button click event
	document.onclick=processButtonClick;
	
	/** 
	 * Event handler processing by button name
	 */	
    function processButtonClick(){
        var sheetObject=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
				case "btn_Retrieve":
                    doActionIBSheet(sheetObject,document.form,IBSEARCH);
                    break;
				case "btn_New":
                    doActionIBSheet(sheetObject,document.form,IBCLEAR);
                    break;
				case "btn_Delete":
				    saveType=2;
					saveMsg="Delete";	
                    doActionIBSheet(sheetObject,document.form,IBSAVE);
                    break;
				case "btn_Approval":
					saveType=0;
					saveMsg="Approval";
                    doActionIBSheet(sheetObject,document.form,IBSAVE);
                    break;
				case "btn_Reject":
				    saveType=1;
					saveMsg="Reject";
                    doActionIBSheet(sheetObject,document.form,IBSAVE);
                    break;
				//S/Provider Code PopUp
				case "provider_popup":
				    ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 705, 500, 'setPopData_Sp', '1,0,1,1,1,1,1,1', true);
					break;
				//Calendar From PopUP
				case "eff_dt_fr_cal":
					var cal=new ComCalendar();
					cal.setDisplayType('year');
					cal.select(formObject.eff_dt_fr, 'yyyy');
	                break;
				//Calendar To PopUP
				case "eff_dt_to_cal":
					var cal=new ComCalendar();
					cal.setDisplayType('year');
					cal.select(formObject.eff_dt_to, 'yyyy');
	                break;
            	case "btn_DownExcel":
            		if(sheetObject.RowCount() < 1){//no data
            			ComShowCodeMessage("COM132501");
            		}else{
            			doActionIBSheet(sheetObject,document.form,IBDOWNEXCEL);
            		}
                    break;
            	case "btn_TariffDetailInfo":
				    var selectedRow=sheetObject.GetSelectRow();
					if(selectedRow < 0) {return;}
					var trfNo=sheetObject.GetCellValue(selectedRow, "trf_no");
                    ComOpenPopup('/opuscntr/EES_MNR_0215.do?trf_no='+trfNo, 1248, 690, '', '1,0,1,1,1,1,1,1,1,1,1,1', false);
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
		//initializing IBSheet
        for(i=0;i<sheetObjects.length;i++){
        	//
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+ 1);
			//
            ComEndConfigSheet(sheetObjects[i]);
        }
		//initializing Axon event
		initControl();
		//retrieving Office Level and setting strMnrOfficeLevel
		MnrOfficeLevel(currOfcCd,rhqOfcCd);
		// initializing event
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		// initial focus
		document.form.cbRegionalHq.focus();
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
	           	with (comboObj) { 
					SetTitle("Office Code|Office Name");
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "60");
					SetColWidth(1, "230");
				   	SetDropHeight(160);
					SetUseAutoComplete(1);
					SetUseEdit(1);
		    	}      
	        	break;    
	    	case 2: 
	           	with (comboObj) { 
					SetTitle("Office Code|Office Name");
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "60");
					SetColWidth(1, "270");
				   	SetDropHeight(160);
					SetUseAutoComplete(1);
		    	}      
	        	break;    
			case 3:
	    	case 4: 
	            with (comboObj) { 
	    			SetColAlign(0, "left");
	    			SetDropHeight(160);
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
     * @param	{IBSheet}	sheetObj	initial sheetObject 
     * @param	{String}	sheetNo		sheetObject tag serial number
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      //t1sheet1 init
                with(sheetObj){
            		var HeadTitle1="|Sel|Seq.|Regional HQ|Tariff Office|Tariff No.|EQ Type|Service Provider|Applied Material Cost Total to Tariff|Applied Material Cost Total to Tariff|Applied Material Cost Total to Tariff|Applied Material Cost Total to Tariff|Applied Material Cost Total to Tariff|Applied Material Cost Total to Tariff|Applied Material Cost Total to Tariff|Request Date|Status|Status Date|Remark(s)";
            		var HeadTitle2="|Sel|Seq.|Regional HQ|Tariff Office|Tariff No.|EQ Type|Service Provider|Dry|Reefer Box|Reefer Unit|S/Dry|Chassis|MG Set|Total Ratio|Request Date|Status|Status Date|Remark(s)";
            		var headCount=ComCountHeadTitle(HeadTitle1);

            		SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

            		var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
            		var headers = [ { Text:HeadTitle1, Align:"Center"},
                          { Text:HeadTitle2, Align:"Center"} ];
            		InitHeaders(headers, info);

            		var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
            		             {Type:"CheckBox",  Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"sel_chk" },
			                     {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
			                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"ar_hd_qtr_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rqst_ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"trf_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:"eq_knd_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"vndr_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"dry",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"reefer_box",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"reefer_unit",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"special_dry",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"chassis",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"genset",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"total_ratio",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Date",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:"cre_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"mnr_trf_sts_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Date",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:"mnr_trf_sts_dt",    KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:0,  Width:80,  Align:"Left",    ColMerge:1,   SaveName:"mnr_trf_rmk",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4000 },
			                     {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"mnr_trf_sts_cd",    KeyField:0,   CalcLogic:"",   Format:"",         	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                     {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"agmt_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
               
            		InitColumns(cols);

            		SetEditable(1);
                    SetSelectionMode(smSelectionRow);
//                    SetShowButtonImage(2);
//                    SetSheetHeight(400);
                    SetRangeBackColor(1,7,1,14,"#555555");
                    resizeSheet( sheetObj );
            	}
                break;
        }
    }
    
	/**
	 * initializing event of HTML Control. <br>
	 **/
	function initControl() {
	    axon_event.addListenerForm  ('blur', 		'obj_blur',		document.form); 
//	    axon_event.addListenerFormat('focus',  		'obj_focus',    document.form); 
	    axon_event.addListenerForm	('keypress',	'obj_keypress', document.form);	
	    axon_event.addListenerForm  ('change',	 	'obj_change',	document.form);	
    }
	
	/** 
	 * registering IBCombo Object as list
	 * @param    {IBCombo}	combo_obj	 IBCombo Object
	 */	
    function setComboObject(combo_obj){
 		comboObjects[comboCnt++]=combo_obj; 
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
	 * cbRegionalHq Change event      
	 * @param {IBMultiCombo}  comboObj ComboObject  
	 * @param  {String}    Index_Code   Index or Code
	 * @param  {String}    Text
	 */  
	function cbRegionalHq_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
		getAgmtOffice(newCode);
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
		obj=event.srcElement;
	    if(obj.dataformat == null) return;
	    window.defaultStatus=obj.dataformat;
		switch(obj.dataformat) {
	        case "engup":
	          	if(obj.name=="vndr_seq"){
					ComKeyOnlyNumber(obj);
				} else {
					ComKeyOnlyAlphabet('uppernum');	
				}          
	            break;
			case "yyyy":
				ComKeyOnlyNumber(event.srcElement);
				break;
	    } 
	}
	
	/**
	 * checking validation onChange event of HTML Control. <br>
	 **/
	function obj_change(){     
		var obj=event.srcElement; 
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
	 * showing message after saving
	 * @param	{IBSheet}	sheetObj	sheetObject
	 * @param	{String}	ErrMsg		errorMessage
	 */
	function sheet1_OnSaveEnd(sheetObj,ErrMsg){
		if (ErrMsg == "") { 
			//(0:Approval, 1:Reject, 2:Delete)
			if(saveType==0) {
				ComShowCodeMessage("MNR00315");
			} else if (saveType==1) {
				ComShowCodeMessage("MNR00314");
			} else if (saveType==2) {
				ComShowCodeMessage("MNR00020");
			} else {
				ComShowCodeMessage("MNR00023");
			}
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		} 
		else { 
			ComShowCodeMessage("MNR00008",ErrMsg);  
		} 
	}
	
  	/**
     * handling Sheet1 reference
     * @param	{IBSheet}	sheetObj	SheetObject 
     * @param	{Form}		formObj		formObject
     * @param	{Number}	sAction		action constants(CoObject.js defined) 
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        //sheetObj.ShowDebugMsg = false;
        switch(sAction) {
			//initialzing
			case IBCLEAR:
				sheetObj.SetWaitImageVisible(0);
				MnrWaitControl(true);
				//initializing sheet
	    		sheetObjects[0].RemoveAll();
	        	//조건부 initializing Combo Data
				for(var i=0; i < comboObjects.length;i++){
					if(i!=1) {
						comboObjects[i].RemoveAll(); //except AGMT Combo
					}
				}
				//retrieving Combo
				var sCondition=new Array (
					new Array("MdmOrganization","RHQ","FALSE"),	//Regional HQ
					new Array("MnrGenCd","CD00007", "COMMON"), 	//Status
					new Array("MnrGenCd","","CUSTOM9")  	//EQ Type
				)
				var comboList=MnrComSearchCombo(sheetObj,sCondition); 
				for(var i=0; i < comboList.length;i++){
					if(comboList[i] != null){
						var cnt=0;
						for(var j=0; j < comboList[i].length;j++){ 
							var tempText=comboList[i][j].split("|");
							//Regional HQ
							if(i==0) {
								cbRegionalHq.InsertItem(j, comboList[i][j], tempText[0]);
							//Status
							} else if(i==1) {
								//HA:Apporval, HJ:Reject, HR:Request
								if(tempText[0]=="HA"||tempText[0]=="HJ"||tempText[0]=="HR") {
									cbTariffStatus.InsertItem(cnt++, tempText[1] ,tempText[0]);
								}
							//EQ Type
							} else if(i==2) {
								cbEqType.InsertItem(j, tempText[1] ,tempText[0]);
							}
						}
					}
				}
				cbRegionalHq.InsertItem(0, "ALL" ,"A" );
				cbTariffStatus.InsertItem(0, "ALL" ,"A" );
				cbEqType.InsertItem(0, "ALL" ,"A" );
				//setting combo initial value
				//Regional HQ
				if(strMnrOfficeLevel=="L1"){
					cbRegionalHq.SetSelectCode("A");
				} else {
					cbRegionalHq.SetEnable(0);
					cbRegionalHq.SetSelectCode(rhqOfcCd);
				}
				cbEqType.SetSelectCode("A");//EQ Type
				cbTariffStatus.SetSelectCode("A");//Tariff Status
				//setting other
				formObj.vndr_seq.value="";
				formObj.vndr_nm.value="";
				formObj.eff_dt_to.value=ComGetNowInfo("yy");
				formObj.eff_dt_fr.value=ComGetNowInfo("yy") - 1;
				MnrWaitControl(false);
				sheetObj.SetWaitImageVisible(1);
				break;
			//retrieving
            case IBSEARCH:      
				if(validateForm(sheetObj,formObj,sAction)) {
					sheetObj.SetWaitImageVisible(1);
					formObj.f_cmd.value=SEARCH;
					//setting retrieve condition
					formObj.ar_hd_qtr_ofc_cd.value=ComGetObjValue(formObj.cbRegionalHq);		//Regional HQ
					formObj.rqst_ofc_cd.value=ComGetObjValue(formObj.cbAgmtOffice);		//AGMT Office
					formObj.eq_knd_cd.value=ComGetObjValue(formObj.cbEqType);			//EQ Type
					formObj.mnr_trf_sts_cd.value=ComGetObjValue(formObj.cbTariffStatus);	//Tariff Status
					//retrieving
//parameter changed[check again]CLT
					var sXml=sheetObj.GetSearchData("EES_MNR_0136GS.do", FormQueryString(formObj));
					sheetObj.LoadSearchData(sXml,{Sync:1} );
				}
                break;
			//retrieving(in case of existing sevice provider No.)
			case IBSEARCH_ASYNC01:	
				if ( validateForm(sheetObj, formObj, sAction) ) { 
					formObj.vndr_seq.value=ComLpad(formObj.vndr_seq.value, 6, "0");
					//Service Provider Detail Information  
					var sXml=MnrGetPartner(sheetObj,formObj.vndr_seq.value,"RPR");
					var vndrSeq=ComGetEtcData(sXml, "vndr_seq");
					if(vndrSeq != "" && vndrSeq != undefined){ 
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
			// saving
			case IBSAVE:
				if(validateForm(sheetObj,formObj,sAction)) {
					var mnrTrfStsCd="";   //status
				    if(saveType==0) {
						mnrTrfStsCd="HA"; //Apporval
					} else if(saveType==1) {
						mnrTrfStsCd="HJ"; //Reject
					} else if(saveType==2){
						mnrTrfStsCd="HD"; //Delete
					} else {
						ComShowCodeMessage("MNR00010","Status"); 
						return;
					}
					//set Status to Sheet 
					for(var i=sheetObjects[0].HeaderRows(); i<=sheetObjects[0].LastRow(); i++) {
						var selChk=sheetObjects[0].GetCellValue(i,"sel_chk");
						if(selChk=='1') {
							sheetObjects[0].SetCellValue(i,"mnr_trf_sts_cd",mnrTrfStsCd,0);
						}
					}
					formObj.f_cmd.value=MULTI;
					var sParam=ComGetSaveString(sheetObjects);
				    if (sParam == "") return;
				    sParam += "&" + FormQueryString(formObj);
//parameter changed[check again]CLT
				    var sXml=sheetObj.GetSaveData("EES_MNR_0136GS.do", sParam);
//parameter changed[check again]CLT
				    sheetObj.LoadSaveData(sXml);
				}
				saveType=0;
				saveMsg="";
                break;
            //Down Excel
			case IBDOWNEXCEL:   
//method change[check again]CLT
				sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(			    sheetObj), SheetDesign:1,Merge:1 });
				break;
			default:
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
				//checking IBMultiCombo mandatory
				var arHdQtrOfcCd=ComGetObjValue(formObj.cbRegionalHq);		//Regional HQ
				var rqstOfcCd=ComGetObjValue(formObj.cbAgmtOffice);		//AGMT Office
				if(arHdQtrOfcCd=='') {
					ComShowCodeMessage("MNR00036","Regional HQ");
					formObj.cbRegionalHq.focus();
				    return false;
				}
				if(rqstOfcCd=='') {
					ComShowCodeMessage("MNR00036","AGMT Office");
					formObj.cbAgmtOffice.focus();
				    return false;
				}
				//Dataformat
				if (!ComChkValid(formObj)) {return false;}
				//Effective Period
				var effDtFr=formObj.eff_dt_fr.value;
				var effDtTo=formObj.eff_dt_to.value;
				var effDtFrLen=effDtFr.length;
				var effDtToLen=effDtTo.length;
				if((effDtFrLen==0 && effDtToLen!=0) || (effDtFrLen!=0 && effDtToLen==0)) {
					ComShowCodeMessage("MNR00162");
					formObj.eff_dt_fr.focus();
					return false;
				}
				if(effDtTo - effDtFr < 0){
					ComShowCodeMessage("MNR00162");
					formObj.eff_dt_fr.focus();
					return false;
				}
				//checking whether retrieving
				if(sheetObjects[0].IsDataModified()) {
					if(!ComShowCodeConfirm("MNR00007")) {return false;}
				}
			//in case of saving
			} else if (sAction==IBSAVE) {
				// Checking the existence of the grid
				if(sheetObjects[0].RowCount()< 1) {return false;}
				//Checking the existence of the checked value
				var checkRow=sheetObj.FindCheckedRow("sel_chk");
				if(checkRow=='') {
					ComShowCodeMessage("MNR00038", saveMsg);
					return false;
				}
				// checking status duplicate saving
				if(!checkStatus()) {return false;}
				// Checking the existence of the agreement_no in case of deleting
				if(saveType==2) {
					for(var i=sheetObjects[0].HeaderRows(); i<=sheetObjects[0].LastRow(); i++) {
						var checkValue=sheetObjects[0].GetCellValue(i, "sel_chk");
						if(checkValue == '1') {
							var agmtNo=sheetObjects[0].GetCellValue(i, "agmt_no");
							if(agmtNo!="") {
								//Pls carry out Confirmation/Deletion first
								ComShowCodeMessage("MNR00289");
								sheetObjects[0].SelectCell(i, "trf_no", true);
								return false;
							}
						}
					}
				}
				// checking whether saving
				if(!ComShowCodeConfirm("MNR00039", saveMsg)) {return false;}
			}
        }
        return true;
    }
    
    /* ********* User Functions ************* */
    /**
	 * retrieving cbAgmtOffice in case of cbRegionalHq OnChange
	 * @param comboObj
	 * @param Index_Code
	 * @param Text
	 * @return
	 */   
	function getAgmtOffice(Index_Code){ 
		sheetObjects[0].SetWaitImageVisible(0);
		var formObj=document.form;
		cbAgmtOffice.RemoveAll();
		var sCondition=new Array ( 
			new Array("MdmOrganization","SEARCH",Index_Code) 
		)
		var comboList=MnrComSearchCombo(sheetObjects[0],sCondition); 
		if(comboList[0] != null){      
			for(var j=0; j < comboList[0].length;j++){  
				var tempText=comboList[0][j].split("|");  
				cbAgmtOffice.InsertItem(j,comboList[0][j] ,tempText[0]);
			}             
		}    
		cbAgmtOffice.InsertItem(0,"ALL","A");
		//setting initial value
		if(strMnrOfficeLevel=="L3"){
			cbAgmtOffice.SetEnable(0);
			cbAgmtOffice.SetSelectCode(currOfcCd);
		}else {
			cbAgmtOffice.SetSelectCode("A");
		}	
		sheetObjects[0].SetWaitImageVisible(1);
	}
	
	/**
	 * (Service Provider) Pop-up Return Value <br>
	 * @param {arry} Return value array of returnedValues Pop-up
	 * @param Row Row index of IBSheet
	 * @param Col Col index of IBSheet
	 * @param Array index of IBSheet 
	 */
	function setPopData_Sp(aryPopupData, Row, Col, SheetIdx) {
		var formObj=document.form;   
		if ( aryPopupData.length > 0 ) {
			formObj.vndr_seq.value=aryPopupData[0][2];
			formObj.vndr_nm.value=aryPopupData[0][4];
			var sXml=MnrGetPartner(sheetObjects[0],formObj.vndr_seq.value,"RPR");
			if(ComGetEtcData(sXml, "vndr_seq") != null){ 
				//setting Vender nm		
				ComSetObjValue(formObj.vndr_nm, ComGetEtcData(sXml, "vndr_lgl_eng_nm"));  
			} else {	       
				ComShowCodeMessage("MNR00005", "Service Provider");              
				ComSetObjValue(formObj.vndr_nm, "");  
				ComSetObjValue(formObj.vndr_seq, ""); 
				ComSetFocus(formObj.vndr_seq); 	
			}   	
		}
	}
	
  	/**
     * //checking same status.
     *    Approval return false in case of Approval  
     *    Reject   return false in case of Request
	 * @return	{Boolean}	true/false     
     */
	function checkStatus() {
		//Approval
		if(saveType==0) {
			for(var i=sheetObjects[0].HeaderRows(); i<=sheetObjects[0].LastRow(); i++) {
				var selChk=sheetObjects[0].GetCellValue(i,"sel_chk");
				if(selChk=='1') {
					var mnrTrfStsCd=sheetObjects[0].GetCellValue(i,"mnr_trf_sts_cd");
					if(mnrTrfStsCd == "HA"){
						ComShowCodeMessage("MNR00208",(i- 1)+" row\'s Tariff",saveMsg);  //already Approval 
						sheetObjects[0].SelectCell(i, "sel_chk");
						return false;
					}
				}
			}
		//Reject
		} else if(saveType==1) {
			for(var i=sheetObjects[0].HeaderRows(); i<=sheetObjects[0].LastRow(); i++) {
				var selChk=sheetObjects[0].GetCellValue(i,"sel_chk");
				if(selChk=='1') {
					var mnrTrfStsCd=sheetObjects[0].GetCellValue(i,"mnr_trf_sts_cd");
					if(mnrTrfStsCd == "HJ"){
						ComShowCodeMessage("MNR00208",(i- 1)+" row\'s Tariff",saveMsg);  //already Reject 
						sheetObjects[0].SelectCell(i, "sel_chk");
						return false;
					}
				}
			}
		//Etc..
		} else {
		   return true;	
		}
		return true;
	}
/* developer job	*/