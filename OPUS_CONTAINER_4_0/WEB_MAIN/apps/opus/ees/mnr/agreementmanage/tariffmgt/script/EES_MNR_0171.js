/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ees_mnr_0171.js
*@FileTitle : MNR Tariff Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/16
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ees_mnr_0171 : business script for ees_mnr_0171.
     */
/* developer job	*/
/* ********* General Functions ************* */
	// common global variables
	var comboObjects=new Array();
	var comboCnt=0;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var saveType=0; //(0:Approval, 1:Reject, 2:Delete)
	var saveMsg=""; 
	var strMnrOfficeLevel="";	// Office level of login user :  HO level -> L1, RHQ level -> L2, Office level -> L3   (setting at MnrOfficeLevel function(CoMnr.js reference))
	// Event handler processing by button click event */
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
				//S/Provider Code PopUp
				case "provider_popup":
				    ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 705, 555, 'setPopData_Sp', '1,0,1,1,1,1,1,1', true);
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
                    doActionIBSheet(sheetObject,document.form,IBDOWNEXCEL);
                    break;
            	case "btn_TariffDetailInfo":
				    var selectedRow=sheetObject.GetSelectRow();
					if(selectedRow < 0) {return;}
					var trfNo=sheetObject.GetCellValue(selectedRow, "trf_no");
					var iWidth=1015;
					var iHeight=670;
		            var leftpos=(window.screen.width - iWidth)/2;    if(leftpos<0) leftpos=0;
		            var toppos=(window.screen.height- iHeight)/2;   if(toppos<0)  toppos=0;
					ComOpenWindow('/opuscntr/EES_MNR_0215.do?trf_no='+trfNo,  '',"status=no, resizable=yes, scrollbars=no, width="+iWidth+", height="+iHeight+", left="+leftpos+", top="+toppos);
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
		//retrieving Office Level and setting strMnrOfficeLevel
		MnrOfficeLevel(currOfcCd,rhqOfcCd);
		//initializing Axon event
		initControl();
		// initializing event
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		// initial focus
//		cbRegionalHq.focus();
		
		
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
//					SetSelectIndex(0);
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
//					SetSelectIndex(0);
		    	}      
	        	break;    
			case 3:
	    	case 4: 
	            with (comboObj) { 
					SetColAlign(0, "left");
					SetDropHeight(160);
					SetUseAutoComplete(1);
//					SetSelectIndex(0);
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
							
						  var HeadTitle1="|Seq.|Regional HQ|Tariff Office|Tariff No.|Agreement No|EQ Type|Service Provider\nCode|Service Provider\n Name|Applied Material Cost Total to Tariff|Applied Material Cost Total to Tariff|Applied Material Cost Total to Tariff|Applied Material Cost Total to Tariff|Applied Material Cost Total to Tariff|Applied Material Cost Total to Tariff|Applied Material Cost Total to Tariff|Apro No|Apro User|Apro Date|Request Date|Status|Status Date|Remark(s)";
						  var HeadTitle2="|Seq.|Regional HQ|Tariff Office|Tariff No.|Agreement No|EQ Type|Service Provider\nCode|Service Provider\n Name|Dry|Reefer Box|Reefer Unit|S/Dry|Chassis|MG Set|Total Ratio|Apro No|Apro User|Apro Date|Request Date|Status|Status Date|Remark(s)";
						  var headCount=ComCountHeadTitle(HeadTitle1);

						  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:4, DataRowMerge:1 } );

						  var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
						  var headers = [ { Text:HeadTitle1, Align:"Center"},
									  { Text:HeadTitle2, Align:"Center"} ];
						  InitHeaders(headers, info);

						  var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
								 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
								 {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"ar_hd_qtr_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"rqst_ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"trf_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"agmt_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:55,   Align:"Left",    ColMerge:1,   SaveName:"eq_knd_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vndr_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:140,  Align:"Left",    ColMerge:1,   SaveName:"vndr_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:"dry",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"reefer_box",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"reefer_unit",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:"special_dry",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:"chassis",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:"genset",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"total_ratio",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"apro_ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:75,   Align:"Left",    ColMerge:1,   SaveName:"apro_usr_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"apro_dt",           KeyField:0,   CalcLogic:"",   Format:"",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"cre_dt",            KeyField:0,   CalcLogic:"",   Format:"",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"mnr_trf_sts_nm",    KeyField:0,   CalcLogic:"",   Format:"",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"mnr_trf_sts_dt",    KeyField:0,   CalcLogic:"",   Format:"",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"mnr_trf_rmk",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"mnr_trf_sts_cd",    KeyField:0,   CalcLogic:"",   Format:"",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
						   
								InitColumns(cols);

								SetEditable(1);
								SetSelectionMode(smSelectionRow);
								SelectHighLight=true;
								SelectFontBold=false;
								SelectBackColor="#NANNANNAN";
								MultiSelection=false;
								SetShowButtonImage(2);
//								SetSheetHeight(400);
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
	 //   axon_event.addListenerFormat('focus',  		'obj_focus',    document.form); 
	    //axon_event.addListenerForm	('keypress',	'obj_keypress', document.form);	
	    axon_event.addListenerFormat('change',	 	'obj_change',	document.form);	
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
    function cbRegionalHq_OnChange(comboObj,OldIndex, OldText, OldCode, NewIndex, NewText, NewCode){
		getAgmtOffice(NewCode);
	}  
    
	/**
     * checking validation onblur event of HTML Control. <br>
     **/
    function obj_blur(){
		ComChkObjValid(ComGetEvent());
	}	
	/**
     * checking validation focus event of HTML Control. <br>
     **/
    function obj_focus(){
		ComClearSeparator(ComGetEvent());
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
	          	if(obj.name=="vndr_seq"){
					ComKeyOnlyNumber(obj);
				} else {
					ComKeyOnlyAlphabet('uppernum');	
				}          
	            break;
			case "yyyy":
				ComKeyOnlyNumber(ComGetEvent());
				break;
	    } 
	}
	/**
	 * checking validation onChange event of HTML Control. <br>
	 **/
	function obj_change(){     
//		alert("11");
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
	        	//initializing Combo Data
				for(var i=0; i < comboObjects.length;i++){
					if(i!=1) {
						comboObjects[i].RemoveAll(); //except AGMT Combo
					}
				}
				//retrieviing Combo
				var sCondition=new Array (
					new Array("MdmOrganization","RHQ","FALSE"),
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
							if(i == 0) {		
								cbRegionalHq.InsertItem(j, comboList[i][j] , tempText[0]);			
							//Status
							} else if(i == 1) {
								//HA:Apporval, HJ:Reject, HR:Request
								if(tempText[0]=="HA"||tempText[0]=="HJ"||tempText[0]=="HR") {
									cbTariffStatus.InsertItem(cnt++, tempText[1] ,tempText[0]);
								}
							//EQ Type
							} else if(i == 2) {
								cbEqType.InsertItem(j, tempText[1] ,tempText[0]);
							}
						}
					}
				}
				cbRegionalHq.InsertItem(0, "ALL" ,"A" );
				cbTariffStatus.InsertItem(0, "ALL" ,"A" );
				cbAgmtOffice.InsertItem(0, "ALL" ,"A" );
				cbEqType.InsertItem(0, "ALL" ,"A" ); 
				//setting combo initial value
				if(strMnrOfficeLevel=="L1"){
					cbRegionalHq.SetSelectCode("A");
				} else {
					cbRegionalHq.SetEnable(0);
					cbRegionalHq.SetSelectCode(rhqOfcCd);
				}
				cbEqType.SetSelectCode("A");//EQ Type
				cbTariffStatus.SetSelectCode("A");//Tariff Status
//				cbAgmtOffice.SetSelectCode("A");
				//setting other
				formObj.vndr_seq.value="";
				formObj.vndr_nm.value="";
				formObj.eff_dt_to.value=ComGetNowInfo("yy");
				formObj.eff_dt_fr.value=ComGetNowInfo("yy") - 1;
				MnrWaitControl(false);
				sheetObj.SetWaitImageVisible(1);
//				cbTariffStatus.SetSelectIndex(0);
				break;
			//retrieving
            case IBSEARCH:      
				if(validateForm(sheetObj,formObj,sAction)) {
					sheetObj.SetWaitImageVisible(1);
					formObj.f_cmd.value=SEARCH;
					//setting retrieve condition
					formObj.ar_hd_qtr_ofc_cd.value=ComGetObjValue(cbRegionalHq);		//Regional HQ
					formObj.rqst_ofc_cd.value=ComGetObjValue(cbAgmtOffice);		//AGMT Office
					formObj.eq_knd_cd.value=ComGetObjValue(cbEqType);			//EQ Type
					formObj.mnr_trf_sts_cd.value=ComGetObjValue(cbTariffStatus);	//Tariff Status
					//retrieving
					var sXml=sheetObj.GetSearchData("EES_MNR_0171GS.do", FormQueryString(formObj));
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
            //Down Excel
			case IBDOWNEXCEL:		
			 if(sheetObj.RowCount() < 1){//no data
				  ComShowCodeMessage("COM132501");
				}else{
					sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
				}
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
			//retrieving시
			if(sAction==IBSEARCH){
				//checking IBMultiCombo mandatory
				var arHdQtrOfcCd=ComGetObjValue(cbRegionalHq);		//Regional HQ
				var rqstOfcCd=ComGetObjValue(cbAgmtOffice);		//AGMT Office
				if(arHdQtrOfcCd=='') {
					ComShowCodeMessage("MNR00036","Regional HQ");
					cbRegionalHq.focus();
				    return false;
				}
				if(rqstOfcCd=='') {
					ComShowCodeMessage("MNR00036","AGMT Office");
					cbAgmtOffice.focus();
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
 		var formObj=document.form;
 		cbAgmtOffice.RemoveAll();
		var sCondition=new Array (         
			new Array("MdmOrganization","SEARCH",Index_Code)
		) 	 	       
		var comboList=MnrComSearchCombo(sheetObjects[0],sCondition);      
		if(comboList[0] != null){
			for(var j=0; j < comboList[0].length;j++){ 
				var tempText=comboList[0][j].split("|");
				cbAgmtOffice.InsertItem(j, comboList[0][j] ,tempText[0]);
			}
			cbAgmtOffice.InsertItem(0, "ALL" , "A");
			//setting initial value
			if(strMnrOfficeLevel=="L3"){
				cbAgmtOffice.SetSelectCode(currOfcCd);
				cbAgmtOffice.SetEnable(0); //Local Office 
			}else {
				cbAgmtOffice.SetSelectCode("A");
			}
		}
	} 
	/**
	 * (Service Provider) handling Pop-up Return Value<br>
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
/* developer job	*/
