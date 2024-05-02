/*=========================================================

*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_LSE_0018.js
*@FileTitle  :	Estimate expense
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/17

*=========================================================*/
/****************************************************************************************
    Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class EES_LSE_0018 : business script for EES_LSE_0018
     */
    function EES_LSE_0018() {
    	this.processButtonClick=processButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.setComboObject=setComboObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;    	
    	this.validateForm=validateForm;
    	this.obj_change=obj_change;
    	this.obj_keypress=obj_keypress;
    	this.validateForm=validateForm;    	
    	this.sheet1_OnSort=sheet1_OnSort;
    	this.sheet1_OnDblClick=sheet1_OnDblClick;   
    }
   	/* developer job */
    // common global variables
    var sheetObjects=new Array();
    var sheetCnt=0;
	// Combo Object Array
	var comboObjects=new Array();
	var comboCnt=0;
	var calFlg  = "N";
    //Event handler processing by button click event */
    document.onclick=processButtonClick;
    function initControl() {
    	var formObj=document.form;
    	axon_event.addListenerForm('click','obj_click',formObj);         
    	axon_event.addListenerFormat('change','obj_change',formObj);       	
//    	axon_event.addListenerFormat('keypress','obj_keypress',formObj); 
    	axon_event.addListenerFormat('blur','obj_blur',formObj);         
//    	axon_event.addListenerFormat('focus','obj_focus',formObj);       
//    	axon_event.addListenerForm('keydown', 'obj_keydown',  formObj);   
    }
    //Event handler processing by button name */
    function processButtonClick(){
    	/**********/
    	var sheetObject1=sheetObjects[0];
    	/*******************************************************/
    	var obj = event.target || event.srcElement;
    	   if ($(obj).prop('disabled')) {
    	 return;
    	 }
    	var formObject=document.form;
    	try {
    		var srcObj=window.event.srcElement;
    		var srcName=ComGetEvent("name");
    		switch(srcName) {
    		case "btn_calendar":
    			if ( srcObj.style.filter == "" ) {
    				var cal=new ComCalendar();
    				cal.setDisplayType('month');
    				cal.select(formObject.period_eddt, "yyyy-MM");
    				break;		
    			}
    			break;
    		case "btn_calendar1":
    			if ( srcObj.style.filter == "" ) {
    				var cal=new ComCalendar();
    				cal.setDisplayType('month');
    				cal.select(formObject.rev_month, "yyyy-MM");
    				break;		
    			}
    			break;    			
    		case "btn_Retrieve":
    			if ( srcObj.style.filter == "" ) {
    				sheetObjects[0].RemoveAll(); 				
    				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);    					
    			}
    			break;
    		case "btn_downexcel":	 
    			if(sheetObjects[0].RowCount() < 1){//no data
    				ComShowCodeMessage("COM132501");
    				}else{
    					sheetObjects[0].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[0]), SheetDesign:1,Merge:1 });
    				}

    			break;			
    		case "btn_New":
    			sheetObjects[0].RemoveAll();
    			ComBtnDisable("btn_save");
    			ComBtnDisable("btn_Calculation");
    			formObject.period_eddt.value="";
    			formObject.rev_month.value="";
    			formObject.lstm_cd.value="";
    			formObject.lse_pay_chg_tp_cd.value="";
    			formObject.agmt_cty_cd.value="HHO";
    			formObject.agmt_seq.value="";
    			formObject.lse_ctrt_no.value="";
    			formObject.vndr_lgl_eng_nm.value="";
    			formObject.vndr_seq.value="";
    			formObject.skr_acct_cd.value="";
    			
    			comboObjects[0].SetSelectIndex(0);
    			comboObjects[1].SetSelectIndex(0);
    			comboObjects[2].SetSelectIndex(0);
    			comboObjects[2].SetItemCheck(0, false);
    			break;
    		case "btn_Calculation":
    			if ( srcObj.style.filter == "" ) {
    				sheetObjects[0].RemoveAll();
    				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);    				
    			}	
    			break;
    		case "btn_save":
    			if(ComIsBtnEnable("btn_save")){				
    				doActionIBSheet(sheetObjects[0],formObject,IBSAVE);
    			}
    			break;	
			case "btns_agmt": // Form Agreement Search
				openPopup("1");
				break;  
			case "btns_vndr": // Form Agreement Search
				openPopup("2");
				break;    				
    		} // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e.message);
    		}
    	}
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
	 * registering IBMultiCombo Object as list
	 * adding process for list in case of needing batch processing with other items 
	 * defining list on the top of source
	 */
	function setComboObject(combo_obj) {
		comboObjects[comboCnt++]=combo_obj;
	}    
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
    	for(i=0;i<sheetObjects.length;i++){
    		ComConfigSheet (sheetObjects[i] );
    		initSheet(sheetObjects[i],i+1);
    		ComEndConfigSheet(sheetObjects[i]);
    	}
    	initControl();
    	/* initializing IBMultiCombo */
    	for ( var k=0 ; k < comboObjects.length ; k++ ) {
    		initCombo(comboObjects[k], k+1);
    	} 
    	doActionIBSheet(sheetObjects[0], document.form, IBCREATE);  
		ComBtnDisable("btn_Calculation");
		ComBtnDisable("btn_save");	    	
    	sheet1_OnLoadFinish();
    }
    function sheet1_OnLoadFinish(){
    	document.form.period_eddt.focus();

    }
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
    	var cnt=0;
    	var sheetID=sheetObj.id;
    	switch(sheetID) {
    	case "sheet1":      //sheet1 init
    	with (sheetObj) {

    	    var HeadTitle1="|Seq.|Accrual Month|SYS Name|REV Month|ACCT Code|Sakura Code|AGMT No.|Term|Contract No.|Lessor|Lessor Name|BIZ Unit|Charge Type|REV VVD|TP/SZ|Currency|EST Q'ty|Estimated Cost|Actual Cost|Accrual AMT|Created UserID|Created Date|Update UserID|Update Date"
    	    + "|H_loc_cd|H_vsl_cd|H_skd_voy_no|H_skd_dir_cd|H_REV_DIR_CD";
    	    var headCount=ComCountHeadTitle(HeadTitle1);
    	    //(headCount, 0, 0, true);

    	    SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );

    	    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
    	    var headers = [ { Text:HeadTitle1, Align:"Center"} ];
    	    InitHeaders(headers, info);

    	    var cols = [{Type:"Status",  Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
    	              {Type:"Seq",       Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"actual_month",      KeyField:0,   CalcLogic:"",   Format:"####-##",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    	              {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"sys_name",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    	              {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rev_month",         KeyField:0,   CalcLogic:"",   Format:"####-##",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    	              {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"acct_code",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    	              {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"skr_acct_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    	              {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"agmt_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    	              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"lstm_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"lse_ctrt_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    	              {Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"vndr_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    	              {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"vndr_lgl_eng_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    	              {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"biz_unit",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    	              {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"lse_pay_chg_tp_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    	              {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"rev_vvd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    	              {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"tp_sz",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    	              {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"locl_curr_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    	              {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"est_qty",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    	              {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"estimated_cost",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
    	              {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"actual_cost",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
    	              {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"accural_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
    	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cre_usr_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cre_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"upd_usr_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    	              {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"upd_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    	              {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"act_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    	              {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"act_plc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    	              {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"slan_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    	              {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"acct_dtl_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    	              {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"cost_act_plc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    	              {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"loc_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    	              {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"vsl_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    	              {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"skd_voy_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    	              {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"skd_dir_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    	              {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"rev_dir_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                      {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"if_chk_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
    	     
    	    InitColumns(cols);
    	    SetAutoSumPosition(-1);
    	    SetEditable(0);
    	    SetSheetHeight(422);
    	}
    	break;
    	}
    }
    //handling process for Sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg(false);
    	switch (sAction) {
		case IBCREATE:
			formObj.f_cmd.value=SEARCH09;	
			var intgCdId='CD30094';
			var param="&intgCdId="+intgCdId;
			var xml=sheetObj.GetSearchData("EES_MST_COMGS.do", FormQueryString(formObj)+param);
			var chk=xml.indexOf("ERROR");
			if (xml.indexOf("ERROR") != -1 || xml.indexOf("Error") != -1){
			   sheetObj.LoadSearchData(xml,{Sync:1} );
			   return;
		    } 
			if (xml != "") {
				var slstmCd=ComGetEtcData(xml, "code_nm");
				var arrlstmCd=slstmCd.split("@");
				MakeComboObject(comboObjects[0], arrlstmCd, 1, 0);
			}
			
			formObj.f_cmd.value=SEARCH09;	
			var intgCdId='CD30024';
			var param="&intgCdId="+intgCdId;
			var xml=sheetObj.GetSearchData("EES_MST_COMGS.do", FormQueryString(formObj)+param);
			var chk=xml.indexOf("ERROR");
			if (xml.indexOf("ERROR") != -1 || xml.indexOf("Error") != -1){
			   sheetObj.LoadSearchData(xml,{Sync:1} );
			   return;
		    } 
			if (xml != "") {
				var schargeType=ComGetEtcData(xml, "code_nm");
				var arrchargeType=schargeType.split("@");
				MakeComboObject(comboObjects[1], arrchargeType, 1, 0);
				comboObjects[1].InsertItem(1, "OPL|Operation Lease Invoice", "OPL");
			}
			
			formObj.f_cmd.value=SEARCH12;	
			var xml=sheetObj.GetSearchData("EES_MST_COMGS.do", FormQueryString(formObj)+param);
			var chk=xml.indexOf("ERROR");
			if (xml.indexOf("ERROR") != -1 || xml.indexOf("Error") != -1){
			   sheetObj.LoadSearchData(xml,{Sync:1} );
			   return;
		    } 
			if (xml != "") {
				var schargeType=ComGetEtcData(xml, "sakura_nm");
				var arrchargeType=schargeType.split("@");
				MakeSakuraComboObject(comboObjects[2], arrchargeType, 1, 0);
				//comboObjects[1].InsertItem(1, "OPL|Operation Lease Invoice", "OPL");
			}
			break;			
		break;			
    	case IBSEARCH:
    	if(validateForm(sheetObj,formObj,sAction)){
    		if(sheetObj.id == "sheet1"){
    			formObj.f_cmd.value=SEARCH;
    			calFlg="N";
    			ComOpenWait(true);
    			sheetObj.DoSearch("EES_LSE_0018GS.do",FormQueryString(formObj) );
    			ComOpenWait(false);
    		}	
    	}
    	break;
    	case IBSEARCH_ASYNC01:	
    	if ( validateForm(sheetObj, formObj, sAction) ) {    		
    		formObj.f_cmd.value=SEARCH01;
    		calFlg="Y";
			ComOpenWait(true);
			sheetObj.DoSearch("EES_LSE_0018GS.do",FormQueryString(formObj) );
    		ComOpenWait(false);
    	}
    	break;	
    	case IBSAVE:  		
	    	if(validateForm(sheetObj,formObj,sAction)) {
	    		if ( sheetObj.id == "sheet1") {    	
	    			formObj.f_cmd.value=MULTI;			    		
	    			var sParam=sheetObj.GetSaveString(true);
	    			sParam += "&" + FormQueryString(formObj);
	    			var sXml=sheetObj.GetSaveData("EES_LSE_0018GS.do", sParam);
	    			sheetObj.LoadSaveData(sXml);	    			
	    		}
	    	}
	    	break;    
		case IBSEARCH_ASYNC03:	//retrieving when input Form Lessor No.
			if ( validateForm(sheetObj, formObj, sAction) ) {
				var param="f_cmd="+SEARCH06+"&vndr_seq="+ComGetObjValue(formObj.vndr_seq);
				var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do", param);
				if ( sXml != "" ) {
					if ( ComGetEtcData(sXml, "vndr_lgl_eng_nm") != undefined ) {
						ComSetObjValue(formObj.vndr_lgl_eng_nm, ComGetEtcData(sXml, "vndr_lgl_eng_nm"));
					} else {
						ComShowCodeMessage("LSE01019");
						clearForm("vndr_seq");
					}
				} else {
					var errMsg=LseComGetErrMsg(sXml);
					if ( errMsg != "" ) {
						ComShowMessage(errMsg);
					}
					clearForm("vndr_seq");
				}
			}
			break;    	
    	}
    }
    /**
    * handling process for input validation
    */
    function validateForm(sheetObj,formObj,sAction){
    	with(sheetObj){
    		with(formObj){
    			switch(sAction) {
    			case IBSEARCH:					      
    			if ( formObj.period_eddt.value == "" ) {
    				ComShowCodeMessage("LSE01010");
    				ComSetFocus(formObj.period_eddt);
    				return false;
    				break;
    			}
    			break;
    			case IBSEARCH_ASYNC01:  	
    			if ( formObj.period_eddt.value == "" ) {
        			ComShowCodeMessage("LSE01010");
        			ComSetFocus(formObj.period_eddt);
        			return false;
        			break;
        		}   
    			break;
    			}
    		}
    	}
    	return true;
    }		
    /**
    * handling Location blur event
    */
    function obj_blur(){
    	var obj=ComGetEvent();
    	switch(ComGetEvent("name")){
    	case "period_eddt":
    		//checking number
    		ComChkObjValid(obj);
    		break;      
    	default:
    		//checking Validation
    	break;
    	}
    }
    
    /**
     * handling after saving
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
    	if ( ErrMsg == "" ) {
    		if(document.form.f_cmd.value == MULTI){
    			ComShowCodeMessage("LSE10001");
    		}
    	} else {
    		ComShowMessage(ErrMsg);
    	}
    }
 
    /**
     * Sum 처리
     */
    function setCurrencySum(sheetObj) {
    	var arrCurrency = "";
		for(var i=1;i<=sheetObj.RowCount();i++) {
			if(arrCurrency.indexOf(sheetObj.GetCellValue(i,"locl_curr_cd")) > -1) {
				//값이 있다면
			}else{
				//값이 없다면
				if(arrCurrency == "") {
					arrCurrency = sheetObj.GetCellValue(i,"locl_curr_cd");
				}else{
					arrCurrency = arrCurrency+","+sheetObj.GetCellValue(i,"locl_curr_cd");
				}
			}
		}
		
		var arrCurrencySplit = "";
		var Row= "";
		var strEstQty = 0;
		var strEstimatedCost= 0;
		var strActualCost = 0;
		var strAccuralAmt = 0;
		if(arrCurrency != "") {
			arrCurrencySplit = arrCurrency.split(",")
			for(var j=0;j<arrCurrencySplit.length;j++) {
				strEstQty = 0;
				strEstimatedCost = 0.00;
				strActualCost = 0.00;
				strAccuralAmt = 0.00;
				
				Row = sheetObj.DataInsert(-1);										
				sheetObj.SetRowBackColor(Row,"#FEE7E0");				
				for(var i=1;i<=sheetObj.RowCount();i++) {
					
					
					if(arrCurrencySplit[j] == sheetObj.GetCellValue(i,"locl_curr_cd")) {
						strEstQty = strEstQty + parseInt(sheetObj.GetCellValue(i,"est_qty"));
						strEstimatedCost = strEstimatedCost + parseFloat(sheetObj.GetCellValue(i,"estimated_cost"));
						strActualCost = strActualCost + parseFloat(sheetObj.GetCellValue(i,"actual_cost"));
						strAccuralAmt = strAccuralAmt + parseFloat(sheetObj.GetCellValue(i,"accural_amt"));
						
						sheetObj.SetCellValue(Row,"Seq","Sum");
						
						sheetObj.SetCellValue(Row,"est_qty",strEstQty.toFixed(2));
						sheetObj.SetCellValue(Row,"estimated_cost",strEstimatedCost.toFixed(2));
						sheetObj.SetCellValue(Row,"actual_cost",strActualCost.toFixed(2));
						sheetObj.SetCellValue(Row,"accural_amt",strAccuralAmt.toFixed(2));
					}							
				}
				
				sheetObj.SetCellValue(Row,"locl_curr_cd",arrCurrencySplit[j]);
				sheetObj.SetRowStatus(Row, "R");
			}
		}
    }
    
    /**
     * handling after searching
     */    
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		if(sheetObj.RowCount()> 0){
			if(calFlg=="Y") {
				if(sheetObj.GetCellValue(1,"if_chk_flg") == "Y"){
					ComBtnDisable("btn_Calculation");
					ComBtnDisable("btn_save");	
				} else {
					ComBtnEnable("btn_Calculation");
					ComBtnEnable("btn_save");	
				}				
				setCurrencySum(sheetObj);
			} else {
				if(sheetObj.GetCellValue(1,"if_chk_flg") == "Y"){
					ComBtnDisable("btn_Calculation");					
				} else {
					ComBtnEnable("btn_Calculation");
					ComBtnDisable("btn_save");	
				}
				setCurrencySum(sheetObj);				
			}	    
		} else {
			ComBtnEnable("btn_Calculation");
			ComBtnDisable("btn_save");
		}
		
		calFlg=="N";
    }

    /**
     * Object Change Event
     */     
    function obj_change(){	 
    	var obj=ComGetEvent();
    	var formObj=document.form;
    	//if ( ComTrim(ComGetObjValue(obj)) != "" ) {
    	switch(ComGetEvent("name")) {
    	case "period_eddt":		//Location Code
    	break; 	
    	}
    //}
    }	
	/**
	 * creating combo object(Spec No * Type/Size)
	 */
	function MakeComboObject(cmbObj, arrStr, txtCol, codeCol) {
		cmbObj.RemoveAll();
		cmbObj.InsertItem(0, "", "");
		for (var i=0; i<arrStr.length; i++) {
			var arrCode=arrStr[i].split("|");
			cmbObj.InsertItem(i+1, arrCode[codeCol] + '|' + arrCode[txtCol], arrCode[codeCol]);
		}
		cmbObj.SetSelectIndex("" ,false);
	}
	
	/**
	 * creating combo object(Spec No * Type/Size)
	 */
	function MakeSakuraComboObject(cmbObj, arrStr, txtCol, codeCol) {
		cmbObj.RemoveAll();
		cmbObj.InsertItem(0, "", "");
		for (var i=0; i<arrStr.length; i++) {
			var arrCode=arrStr[i].split("|");
			cmbObj.InsertItem(i+1, arrCode[0] + '|' + arrCode[1]+ '|' + arrCode[2], arrCode[codeCol]);
		}
		cmbObj.SetSelectIndex("" ,false);
	}   
	
	/**
	 * setting combo initial values and header
	 * param : comboObj ==> combo object, sheetNo ==> combo object combo object no.
	 * 
	 */
	function initCombo(comboObj, comboNo) {
		switch (comboObj.options.id) {
			case "lstm_cd":
				with (comboObj) {
				SetColAlign(0, "left");
				SetColAlign(1, "left");
				SetColWidth(0, "55");
				SetColWidth(1, "150");
			    SetDropHeight(160);
				}
			 break;
			 case "lse_pay_chg_tp_cd": 
				   with (comboObj) { 
						SetColAlign(0, "left");
						SetColAlign(1, "left");
						SetColWidth(0, "50");
						SetColWidth(1, "150");
					    SetDropHeight(160);
				   }     
			 break;
			 case "skr_acct_cd": 
				   with (comboObj) { 
				 		SetMultiSelect(1);
				 		SetMultiSeparator(",");
				 		SetTitleVisible(true);
				 		SetTitle("Sakura Account|OPUS Account|Account Name");
						SetColAlign(0, "center");
						SetColAlign(1, "center");
						SetColAlign(2, "left");
						SetColWidth(0, "120");
						SetColWidth(1, "100");
						SetColWidth(2, "320");
					    SetDropHeight(160);
				   }     
			 break; 		
		}
	}	
	
  	/* Axon event handling Start ****************************************************************************/
  	function initControl() {
  		var formObj=document.form;
  		axon_event.addListenerFormat('blur',	'obj_blur',		formObj);   		
		axon_event.addListenerForm('change',	'obj_change',	formObj); 
  	}

	/**
	 * Handling in case of HTML Control Value change.
	 */
	function obj_change(){
		var obj=ComGetEvent();
		var formObj=document.form;
		if ( ComTrim(ComGetObjValue(obj)) != "" ) {
			switch(ComGetEvent("name")) {
	    		case "vndr_seq":
	  				if ( ComTrim(obj.value) != "" ) {
		        		doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC03);
	  				}
	  				break;
			}
	    }else{

	    }
	}
	
    /**
	 * handling process for Form Element Clear<br>
	 * @param fieldName
	 */
	function clearForm(fieldName) {
		var formObj=document.form;
		switch(fieldName) {
			case "vndr_seq":
				ComSetObjValue(formObj.vndr_seq, 	"");
				ComSetObjValue(formObj.vndr_lgl_eng_nm,"");
				ComSetFocus(formObj.vndr_seq);
				break;
		}
	}	
	
	/**
	 * handling Location blur event
	 */
	function obj_blur(){
		var obj=ComGetEvent();
	    switch(ComGetEvent("name")){
	    	case "vndr_seq" :
	    		/* checking number */
	            ComChkObjValid(obj, true, false, false);
	            break;
	        default:
	            //checking Validation
	            ComChkObjValid(obj);
	        	break;
	    }
	}
	
	/**
     * handing process Pop-up<br>
     * @param type 1:Agreement(include Ver.) for FORM, 2:Lessor for FORM, 3:Currency for FORM
     * @param object
     * @param Row index
     */
    function openPopup(type, Row, Col) {
    	var formObj=document.form;
    	if ( type == "1" ) {
    		ComOpenPopup('/opuscntr/EES_LSE_0091.do', 805, 480, 'setPopData_Agreement', '1,0', true);
    	} else if ( type == "2" ) {
    		ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 805, 540, 'setPopData_Lessor', '1,0,1,1,1,1,1,1', true);
    	}
    	return;
    }	
    
	/**
     * handling process for Agreement Pop-up Return Value<br>
     * @param Return value array
     * @param Row index
     * @param Col index
     * @param Sheet Array index
     */
    function setPopData_Agreement(aryPopupData, Row, Col, SheetIdx) {
    	var sheetObj=sheetObjects[SheetIdx];
    	var formObj=document.form;
    	if ( aryPopupData.length > 0 ) {
			ComSetObjValue(formObj.agmt_seq, aryPopupData[0][5]);
    	}
    }
    /**
	 * handling process for Lessor(Service Provider) Pop-up Return Value<br>
	 * @param Return value array
	 * @param Row index
	 * @param Col index
	 * @param Sheet Array index
	 */
	function setPopData_Lessor(aryPopupData, Row, Col, SheetIdx) {
		var sheetObj=sheetObjects[SheetIdx];
		var formObj=document.form;
		if ( aryPopupData.length > 0 ) {
			ComSetObjValue(formObj.vndr_seq, ComLtrim(aryPopupData[0][2],"0"));
			ComSetObjValue(formObj.vndr_lgl_eng_nm,  aryPopupData[0][4]);
		}
	}    
	
	/**
     * MultiSelect
     * @return
     */
    function skr_acct_cd_OnCheckClick(comboObj, index, code) {
    	if(index==0) { 	    	
    		var bChk=comboObj.GetItemCheck(index);
    		if(bChk){
    			for(var i=1 ; i < comboObj.GetItemCount() ; i++) {
    				comboObj.SetItemCheck(i,0);
    			}
    		}
    	} else {
    		var bChk=comboObj.GetItemCheck(index);
    		if (bChk) {
    			comboObj.SetItemCheck(0,0);
    		}
    	}
    }
	/* end of developer job */
