/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_1002.js
*@FileTitle  : Chassis Specification Creation 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/
=========================================================
*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class ees_cgm_1002 : ees_cgm_1002 business script for
 */
	function ees_cgm_1002() {
		this.processButtonClick=tprocessButtonClick;
		this.setSheetObject=setSheetObject;
		this.setComboObjects=setComboObjects;
		this.loadPage=loadPage;
		this.initSheet=initSheet;
		this.initControl=initControl;
		this.doActionIBSheet=doActionIBSheet;
		this.setTabObject=setTabObject;
		this.validateForm=validateForm;
	}
	/* developer jop */
	// common global variables
	var sheetObjs=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var tmp_eq_spec_no = "";
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick() {
		/** *** use additional sheet var in case of more than 2 tap each sheet *****/
		var sheetObj=sheetObjs[0];
		/** *****************************************************/
		var formObject=document.form;
		//try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		var formObj=document.form;
		switch (srcName) {
			case "btn_retrieve":
				if(ComIsEmpty(eq_spec_no.GetSelectText())){
					ComShowCodeMessage("CGM10004", "Specification No");
					return;
				}
				doActionIBSheet(sheetObj, formObject, IBSEARCH);
				sheetObj.SetCellValue(1, "eq_knd_cd","Z");
	  	        with(eq_spec_no) { 
	  	        	Style=1; //setting edit unable
	  	        	SetUseEdit(0);
	 	  	    }			
	  	        formObj.eq_spec_no_ins.disabled=true;
				break;
				
			case "btn_new":
				sheetObj.RemoveAll();
				var row=sheetObj.DataInsert(0);
				sheetObj.SetRowStatus(1,"I");
				sheetObj.SetCellValue(1, "eq_knd_cd","Z");
				objectClear();
				formObj.eq_spec_no_ins.disabled=false;
				break;
			case "btn_save":
				
				if(formObj.eq_spec_no_ins.value == null || formObj.eq_spec_no_ins.value ==""){
					ComShowCodeMessage("CGM10004", "Specification No");
					if(formObj.eq_spec_no_ins.disabled == false)
					{
					}
					return;
				}
				tmp_eq_spec_no=formObj.eq_spec_no_ins.value;
				
				if(ComIsEmpty(eq_tpsz_cd.GetSelectText())){
					ComShowCodeMessage("CGM10004", "Chassis Type/Size");
					return;
				}
				
				if(ComIsEmpty(vndr_seq.GetSelectText())){
					ComShowCodeMessage("CGM10004", "Manufacturer");
					return;
				}
				
				if((sheetObj.GetCellValue(1, "ibflag")) == "R"){
//					alert("ibflag : " + sheetObj.GetCellValue(1, "ibflag"));
					return;
				}
				
				doActionIBSheet(sheetObj,formObject,IBSAVE);
				break;
			case "btn_delete":
				if(eq_spec_no.GetSelectCode() == null || eq_spec_no.GetSelectCode() == ""){
					ComShowCodeMessage("CGM10004");
					return;
				}
				formObj.f_cmd.value=SEARCH01;
				var sXml=sheetObj.GetSearchData("EES_CGM_1002GS.do", FormQueryString(formObj));
	     		// data count
	  	        var dataCount= ComGetTotalRows(sXml);
	  	        if(dataCount > 0){
	  	        	ComShowCodeMessage('CGM10052');
	  	        	return;
	  	        }
				if ( ComShowCodeConfirm("CGM10051" ,"delete specification number") ){  
					sheetObj.SetRowStatus(1,"D");
					sheetObj.SetRowHidden(1,1);
					doActionIBSheet(sheetObj,formObject,IBDELETE);
				} else
				{
					return;
				}
				//init object  call
				objectClear();
				var row=sheetObj.DataInsert(0);
				sheetObj.SetRowStatus(1,"I");
				sheetObj.SetCellValue(1, "eq_knd_cd","Z");
	  	        with(eq_spec_no) { // setting edit enable in case of click new
	  	        	Style=1; //setting edit unable
	  	        	SetUseEdit(0);
	 	  	    }				
	  	        formObj.eq_spec_no_ins.disabled=true;
				break;
			}
			tRoleApply();
	}
	/**
	 * registering IBSheet Object as list
	 * adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	 */
	function setSheetObject(sheet_obj) {
		sheetObjs[sheetCnt++]=sheet_obj;
	}
	/**
	 * registering IBCombo Object as list
	 * adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	 */
	function setComboObjects(combo_obj) {
		comboObjects[comboCnt++]=combo_obj;
	}
	/**
	 * initializing sheet
	 * implementing onLoad event handler in body tag
	 * adding first-served functions after loading screen.
	 */
	function loadPage() {
		var sheetObj=sheetObjs[0];
		var formObj=document.form;
		var obj=ComGetEvent();
	    for(i=0; i<sheetObjs.length; i++){
	    	ComConfigSheet (sheetObjs[i] );
	    	initSheet(sheetObjs[i],i+1);
	    	ComEndConfigSheet(sheetObjs[i]);
	    }
	    initControl(sheetObjs[0]);
	    // add first row for error prevent
		sheetObj.RemoveAll();
		var row=sheetObj.DataInsert(0);
		sheetObj.SetRowStatus(1,"I");
		sheetObj.SetCellValue(1, "eq_knd_cd","Z");
	//	axon_event.addListenerFormat("focusin",		"obj_focusin",		form);
		axon_event.addListener      ("focusout",	"obj_focusout",		"chss_tare_wgt", "chss_tare_wgtlb", "chss_payld_wgt", "chss_payld_wgtlb", "chss_ttl_dim_len", "chss_ttl_dim_wdt", "chss_ttl_dim_hgt", "chss_ttl_dim_len_ft", "chss_ttl_dim_len_in", "chss_ttl_dim_wdt_ft", "chss_ttl_dim_wdt_in", "chss_ttl_dim_hgt_ft", "chss_ttl_dim_hgt_in");
		if(formObj.param_eq_spec_no.value != "")
		{
			eq_spec_no.SetSelectText(formObj.param_eq_spec_no.value);
		}    
		tRoleApply();
	}
	/**
	 * sheet setting and init in case of load finish <br>
	 * @param 
	 * @return 
	 * @author 
	 * @version 
	 */     
	 function sheet1_OnLoadFinish(sheetObj) {
	    sheetObj.SetWaitImageVisible(0);
	    doActionIBSheet(sheetObj,document.form,IBCLEAR);
	    sheetObj.SetWaitImageVisible(1);
	 }
	/**
	 * Axon event handling 2. even handling function
	 */
	function obj_deactivate(){
	    ComChkObjValid(ComGetEvent());
	}
	/**
	 * Axon event handling 2. even handling function
	 */
	function obj_focusin(){
		ComClearSeparator(ComGetEvent());
	}

	/**
	 * init control of form
	 */
	function initControl(sheetObj){
		// Form object
		var formObj=document.form;
		var sheetObj=sheetObjs[0];
		formObj.eq_spec_no_ins.disabled=true;
//		setComboObjects(eq_spec_no);
//		setComboObjects(eq_tpsz_cd);
//		setComboObjects(vndr_seq);
		for(var i=0; i< comboCnt; i++)
		{
			initCombo(comboObjects[i]);
		}
	   	doActionIBSheet(sheetObj, document.form, IBRESET);
	}
	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj,sheetNo) {
	    var cnt=0;
	    switch(sheetNo) {
	        case 1:      //t1sheet1 init
	            with(sheetObj){
		          var HeadTitle="|eq_spec_no|eq_tpsz_cd|vndr_seq|chss_tare_wgt|chss_payld_wgt|chss_ttl_dim_len|chss_ttl_dim_wdt|chss_ddl_dim_hgt|eq_knd_cd";
		          SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		          var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		          var headers = [ { Text:HeadTitle, Align:"Center"} ];
		          InitHeaders(headers, info);
		          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		                 {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"eq_spec_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"vndr_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
		                 {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"chss_tare_wgt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"chss_payld_wgt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"chss_ttl_dim_len",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"chss_ttl_dim_wdt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 },
		                 {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"chss_ttl_dim_hgt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eq_knd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 } ];
		          InitColumns(cols);
		          SetEditable(1);
		          SetSheetHeight(160);
                }
            break;
	    }
	}
	/**
	 * handling process for Sheet
	 */
	function doActionIBSheet(sheetObj, formObj, sAction) {
		var formObj=document.form;
		var sheetObj=sheetObjs[0];
		switch (sAction) {
			// Search
			case IBSEARCH:
				formObj.f_cmd.value=SEARCH;
//				prompt("1", FormQueryString(formObj)); return;
				var sXml = sheetObj.GetSearchData("EES_CGM_1002GS.do",FormQueryString(formObj));
				
				if (sXml != "") sheetObj.LoadSearchData(sXml,{Sync:1} );
				if(sheetObj.RowCount("R") == 0){
					sheetObj.RemoveAll();
					var row=sheetObj.DataInsert(0);
					sheetObj.SetRowStatus(1,"I");
					sheetObj.SetCellValue(1, "eq_spec_no",eq_spec_no.GetSelectText());
					//Weight reset
					formObj.reset();
				}else
				{
				    with(eq_spec_no) { // reset prevention in case of press enter
					  	Style=1; //setting edit unable
					  	SetUseEdit(0);
				    }
				}
				
				formObj.eq_spec_no_ins.disabled=true; // 
				formObj.eq_spec_no_ins.value=sheetObj.GetCellValue(1,"eq_spec_no");
				eq_tpsz_cd.SetSelectCode(sheetObj.GetCellValue(1, "eq_tpsz_cd"));
				vndr_seq.SetSelectText('',false);// lessor display null bug
				vndr_seq.SetSelectCode(sheetObj.GetCellValue(1, "vndr_seq"));
				// setting value
				form.chss_tare_wgt.value=ComAddComma(sheetObj.GetCellValue(1, "chss_tare_wgt"));
				form.chss_payld_wgt.value=ComAddComma(sheetObj.GetCellValue(1, "chss_payld_wgt"));
				form.chss_ttl_dim_len.value=ComAddComma(sheetObj.GetCellValue(1, "chss_ttl_dim_len"));
				form.chss_ttl_dim_wdt.value=ComAddComma(sheetObj.GetCellValue(1, "chss_ttl_dim_wdt"));
				form.chss_ttl_dim_hgt.value=ComAddComma(sheetObj.GetCellValue(1, "chss_ttl_dim_hgt"));
				// retrieve -> return Unit (Weight).replaceStr(",");
				document.forms[0].chss_tare_wgtlb.value=ComAddComma((document.forms[0].chss_tare_wgt.value.replaceStr(",")*2.2046).toFixed(0));
				document.forms[0].chss_payld_wgtlb.value=ComAddComma((document.forms[0].chss_payld_wgt.value.replaceStr(",")*2.2046).toFixed(0));
				document.forms[0].gross_wgt.value=ComAddComma(ComRound(Number(document.forms[0].chss_tare_wgt.value.replaceStr(",")) + Number(document.forms[0].chss_payld_wgt.value.replaceStr(","))), 0);
				document.forms[0].gross_wgtlb.value=ComAddComma((ComRound(document.forms[0].chss_tare_wgt.value.replaceStr(",")*2.2046, 0)) + (ComRound(document.forms[0].chss_payld_wgt.value.replaceStr(",")*2.2046, 0)));
				// retrieve -> return Unit (Dimension Lengt)
				setLenmm=((document.forms[0].chss_ttl_dim_len.value.replaceStr(",")) * 0.03937) / 12 + "";
				strIndex=setLenmm.indexOf(".");
				setLenft=setLenmm.substring(0, strIndex);
				setLenin=ComRound((setLenmm.substring(strIndex) * 10), 0);
				document.forms[0].chss_ttl_dim_len_ft.value=ComAddComma(setLenft);
				document.forms[0].chss_ttl_dim_len_in.value=ComAddComma(setLenin);
				// retrieve -> return Unit (Dimension Width)
				setWdtmm=((document.forms[0].chss_ttl_dim_wdt.value.replaceStr(",")) * 0.03937) / 12 + "";
				strIndex=setWdtmm.indexOf(".");
				setWdtft=setWdtmm.substring(0, strIndex);
				setWdtin=ComRound((setWdtmm.substring(strIndex) * 10), 0);
				document.forms[0].chss_ttl_dim_wdt_ft.value=ComAddComma(setWdtft);
				document.forms[0].chss_ttl_dim_wdt_in.value=ComAddComma(setWdtin);
				// retrieve -> return Unit (Dimension Height)
				setHgtmm=((document.forms[0].chss_ttl_dim_hgt.value.replaceStr(",")) * 0.03937) / 12 + "";
				strIndex=setHgtmm.indexOf(".");
				setHgtft=setHgtmm.substring(0, strIndex);
				setHgtin=ComRound((setHgtmm.substring(strIndex) * 10), 0);
				document.forms[0].chss_ttl_dim_hgt_ft.value=ComAddComma(setHgtft);
				document.forms[0].chss_ttl_dim_hgt_in.value=ComAddComma(setHgtin);
				break;
				
	       	case IBSAVE:
	 			formObj.f_cmd.value=MULTI;
		 		sheetObj.SetWaitImageVisible(0);
//		 		prompt("1", FormQueryString(formObj));
		 		ComOpenWait(true);		  			
	 			if(sheetObj.DoSave("EES_CGM_1002GS.do", FormQueryString(formObj)))
	 			{
	 				ComShowCodeMessage("CGM00003");
	 			}else
	 			{
	 			}
		 		ComOpenWait(false);		 
	            break;
	            
	       	case IBDELETE:
	 			formObj.f_cmd.value=REMOVE;
		 		sheetObj.SetWaitImageVisible(0);
		 		ComOpenWait(true);		 
	 			var sXml = sheetObj.DoSave("EES_CGM_1002GS.do", FormQueryString(formObj),-1,0);
//	 			sheetObj.LoadSaveData(sXml);
	 			doActionIBSheet(sheetObj, formObj, IBRESET);
		 		ComOpenWait(false);		 
	            break;
	            
	    	case IBSEARCH_ASYNC03:
	    		formObj.f_cmd.value=SEARCH03;
	    		var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj));
				var sStr=ComGetEtcData(sXml,"comboList1002");
				var arrStr=sStr.split("@");
				MakeComboObject2_2(eq_spec_no, arrStr, 0);
	    		break;
	    		
	    	case IBSEARCH_ASYNC04:
	    		formObj.f_cmd.value=SEARCH04;
	    		var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj));
				var sStr=ComGetEtcData(sXml,"comboList");
				var arrStr=sStr.split("@");
				MakeComboObject1(eq_tpsz_cd, arrStr, 0, 0);
	    		break;
	    		
	    	case IBSEARCH_ASYNC05:
	    		formObj.f_cmd.value=SEARCH05;
	    		var sXml=sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj));
				var sStr=ComGetEtcData(sXml, "comboList");
				var arrStr=sStr.split("@");
				MakeComboObjectManufacture(vndr_seq, arrStr, 0, 0);
				break;
				
	    	case IBRESET:
	    		var idx=0
	    		var sXml2=document.form2.sXml.value;
	    		var arrXml=sXml2.split("|$$|");
	    		if ( arrXml[idx] == null ) {return;}
	    		var vArrayListData=ComCgmXml2ListMap(arrXml[idx]);
	    	    var arrStr1=new Array();
	    		for ( var i=0; i < vArrayListData.length; i++) {
	    		    vListData=vArrayListData[i];
	    		    arrStr1[i]=vListData["code1"] + "|" + vListData["desc2"];
	    		}
	    		MakeComboObject2_2(eq_spec_no, arrStr1, 0);
	    		idx++;        		
	    		if ( arrXml[idx] == null ) {return;}
	    		var vArrayListData2=ComCgmXml2ListMap(arrXml[idx]);
	    	    var arrStr2=new Array();
	    		for ( var i=0; i < vArrayListData2.length; i++) {
	    		    vListData=vArrayListData2[i];
	    		    arrStr2[i]=vListData["code1"] + "|" + vListData["desc1"];
	    		}
	    		MakeComboObject1(eq_tpsz_cd, arrStr2, 0, 0);
		  		idx++;
	    		// Manufacturer
	    		if ( arrXml[idx] == null ) {return;}
	    		var vArrayListData3=ComCgmXml2ListMap(arrXml[idx]);
	    	    var arrStr3=new Array();
	    		for ( var i=0; i < vArrayListData3.length; i++) {
	    		    vListData=vArrayListData3[i];
	    		    arrStr3[i]=vListData["code1"] + "|" + vListData["desc1"];
	    		}
	    		MakeComboObjectManufacture(vndr_seq, arrStr3, 0, 0);
		  		idx++;
	    		break;			
		}
	}
	/**
	 * multi combo creation
	 */
	function initCombo(comboObj) {
		switch(comboObj.options.id) {
		    case "eq_spec_no":
		    	with(comboObj){
		        	SetDropHeight(220);
		        	SetMultiSelect(0);
		        	SetMaxSelect(1);
		            SetMaxLength(20);
		    	}
		    	break;
		    	
		    case "eq_tpsz_cd":
		    	with(comboObj){
		        	SetDropHeight(220);
		        	SetMultiSelect(0);
		        	SetMaxSelect(1);
		    	}
		    	break;
		    	
		    case "vndr_seq":
		        with(comboObj) {
		        	SetDropHeight(220);
		        	SetMultiSelect(0);
		        	SetMaxSelect(1);
		        }
		        break;
	    }
	}
	/** 
	 * add combo(Spec No * Type/Size)
	 * @author 
	 * @version 
	 */ 
	function ComCgmMakeMultiCombo1(cmbObj, arrStr, txtCol, codeCol) {
		cmbObj.RemoveAll();
		cmbObj.InsertItem(0, "", "");
		var arrCode=arrStr[0].split("|");
		for (var i=0; i < arrCode.length;i++ ) {
			var arrCode2=arrCode[i].split("|");
			cmbObj.InsertItem(i+1, arrCode2[txtCol], arrCode2[codeCol]);
		}
		cmbObj.SetSelectIndex("" ,false);
	}
	/**
	 * combo object creation(Spec No * Type/Size)
	 */
	function MakeComboObject1(cmbObj, arrStr, txtCol, codeCol) {
		cmbObj.RemoveAll();
		cmbObj.InsertItem(0, "", "");
		for (var i=0; i<arrStr.length; i++) {
			var arrCode=arrStr[i].split("|");
			cmbObj.InsertItem(i+1, arrCode[codeCol], arrCode[txtCol]);
		}
		cmbObj.SetSelectIndex("" ,false);
	}
	/**
	 * combo object creation(Manufacturer)
	 * 
	 */
	function MakeComboObjectManufacture(cmbObj, arrStr, txtCol, codeCol) {
		cmbObj.RemoveAll();
		cmbObj.InsertItem(0, "", "");
//		cmbObj.InsertItem(1, "Thermo King Corporation","113272"); 
		for (var i=0; i<arrStr.length; i++) {
			var arrCode=arrStr[i].split("|");
			cmbObj.InsertItem(i+2, arrCode[1], arrCode[codeCol]);
		}
		cmbObj.SetSelectIndex("" ,false);
	}
	 /**
	  * combo object creation
	  * @author 
	  * @version 
	  */
	 function MakeComboObject2_2(cmbObj, arrStr, col) {
	 	cmbObj.RemoveAll();
	 	cmbObj.InsertItem(0, "", "");
	 	for (var i=0; i < arrStr.length;i++ ) {
	 		var arrCode=arrStr[i].split("|");
	 		cmbObj.InsertItem(i+1, arrStr[i], arrCode[col]);
	 	}
	 	cmbObj.SetSelectIndex("" ,false);
	 }
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj,formObj,sAction){
	    with(formObj){
	    }
	    return true;
	}
	/** 
	 * Setting grid value in case of Combo Spec No change
	 */
	function eq_spec_no_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {//CHECK OLD CODE: OnChange(comboObj, Index_Code, Text){
//		alert("eq_spec_no_OnChange : " + newText);
		var formObj		= document.form;
		var sheetObj	= sheetObjs[0];

		sheetObj.SetCellValue(1, "eq_spec_no", newText);
		
		if(newText.length > 20)
		{
			ComShowCodeMessage('CGM10019','eq_spec_no(20)');
			eq_spec_no.SetSelectText('',false);
		}
		
		if(newText == null || newText == ""){
			objectClear(); // 
			return;
		}
		doActionIBSheet(sheetObj, formObj, IBSEARCH);
		sheetObj.SetCellValue(1, "eq_knd_cd","Z");
	}
	/** 
	 * Combo Chassis Type/Size chage -> setting grid value
	 */
	function eq_tpsz_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {//CHECK OLD CODE: OnChange(comboObj, Index_Code, Text){
//		alert(typeof comboObj + ", " + typeof oldIndex + ", " + typeof oldText + ", " + typeof oldCode + ", " + typeof newIndex + ", " + typeof newText + ", " + typeof newCode)
		var sheetObj	= sheetObjs[0];

		sheetObj.SetCellValue(1, "eq_tpsz_cd", newText);
	}
	/** 
	 * Combo Manufacturer chage -> setting grid value
	 */
	function vndr_seq_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {//CHECK OLD CODE: OnChange(comboObj, Index_Code, Text){
		var sheetObj	= sheetObjs[0];

		sheetObj.SetCellValue(1, "vndr_seq", newCode);
	}

	/**
	 * init object 
	 */
	function objectClear(){
		var formObj=document.form;
		//IBMultiCombo reset
		formObj.reset();
		formObj.eq_spec_no_ins.value="";
		eq_spec_no.SetSelectCode("", false);
		eq_tpsz_cd.SetSelectCode("", false);
		vndr_seq.SetSelectCode("", false);
	}
	/**
	 * HTML Object event handling
	 */
	function obj_focusout() {
		var sheetObj=sheetObjs[0];
		var formObj=document.form;
		var obj=ComGetEvent();
	    ComChkObjValid(ComGetEvent());
		switch(ComGetEvent("name")){
	        case "chss_tare_wgt":
	        	var chss_tare_wgt=formObj.chss_tare_wgt.value.replaceStr(",");
	    		if(formObj.chss_payld_wgt.value == ""){
	    			var chss_payld_wgt=0;
	    		} else {
	    			var chss_payld_wgt=formObj.chss_payld_wgt.value.replaceStr(",");
	    		}
	    		if(ComTrim(obj.value) != "" ){
	        		formObj.chss_tare_wgtlb.value=ComAddComma(chgKgLbs(obj.value.replaceStr(",")));
	        		var chss_tare_wgtlb=chgKgLbs(obj.value.replaceStr(","));
	        		var chss_payld_wgtlb=formObj.chss_payld_wgtlb.value.replaceStr(",");
	        		formObj.gross_wgt.value=ComAddComma(Number(chss_tare_wgt)   + Number(chss_payld_wgt));
	        		formObj.gross_wgtlb.value=ComAddComma(Number(chss_tare_wgtlb) + Number(chss_payld_wgtlb));
	        	}
	    		sheetObj.SetCellValue(1, "chss_tare_wgt",document.forms[0].chss_tare_wgt.value.replaceStr(","));
	    		obj.value = ComAddComma(obj.value.replaceStr(","));
	        	break;
	        case "chss_payld_wgt":
	        	if(formObj.chss_tare_wgt.value == ""){
	        		var chss_tare_wgt=0;
	        	} else {
	        		var chss_tare_wgt=formObj.chss_tare_wgt.value.replaceStr(",");
	        	}
	        	var chss_payld_wgt=formObj.chss_payld_wgt.value.replaceStr(",");
	        	if(ComTrim(obj.value) != "" ){
	        		formObj.chss_payld_wgtlb.value=ComAddComma(chgKgLbs(obj.value.replaceStr(",")));
	        		var chss_tare_wgtlb=formObj.chss_tare_wgtlb.value.replaceStr(",");
	        		var chss_payld_wgtlb=chgKgLbs(obj.value.replaceStr(","));
	        		formObj.gross_wgt.value=ComAddComma(Number(chss_tare_wgt)   + Number(chss_payld_wgt));
	        		formObj.gross_wgtlb.value=ComAddComma(Number(chss_tare_wgtlb) + Number(chss_payld_wgtlb));
	        	}
	        	sheetObj.SetCellValue(1, "chss_payld_wgt",document.forms[0].chss_payld_wgt.value.replaceStr(","));
	        	obj.value = ComAddComma(obj.value.replaceStr(","));
	        	break;
	        case "chss_tare_wgtlb":
	    		var chss_tare_wgtlb=formObj.chss_tare_wgtlb.value.replaceStr(",");
	        	if(formObj.chss_payld_wgtlb.value == ""){
	        		var chss_payld_wgtlb=0;
	        	} else {
	        		var chss_payld_wgtlb=formObj.chss_payld_wgtlb.value.replaceStr(",");        		
	        	}
	        	if(ComTrim(obj.value) != ""){
	        		formObj.chss_tare_wgt.value=ComAddComma(chgLbKgs(obj.value.replaceStr(",")));
	        		var chss_tare_wgt=chgLbKgs(obj.value.replaceStr(","));
	        		var chss_payld_wgt=formObj.chss_payld_wgt.value.replaceStr(",");
	        		formObj.gross_wgt.value=ComAddComma(Number(chss_tare_wgt)   + Number(chss_payld_wgt));
	        		formObj.gross_wgtlb.value=ComAddComma(Number(chss_tare_wgtlb) + Number(chss_payld_wgtlb));
	        	}
	        	sheetObj.SetCellValue(1, "chss_tare_wgt",document.forms[0].chss_tare_wgt.value.replaceStr(","));
	        	obj.value = ComAddComma(obj.value.replaceStr(","));
	        	break;
	        case "chss_payld_wgtlb":
	        	if(formObj.chss_tare_wgtlb.value == ""){
	        		var chss_tare_wgtlb=0;
	        	} else {
	        		var chss_tare_wgtlb=formObj.chss_tare_wgtlb.value.replaceStr(",");
	        	}
	        	var chss_payld_wgtlb=formObj.chss_payld_wgtlb.value.replaceStr(",");
	        	if(ComTrim(obj.value) != "" ){
	        		formObj.chss_payld_wgt.value=ComAddComma(chgLbKgs(obj.value.replaceStr(",")));
	        		var chss_tare_wgt=formObj.chss_tare_wgt.value.replaceStr(",");
	        		var chss_payld_wgt=chgLbKgs(obj.value.replaceStr(","));
	        		formObj.gross_wgt.value=ComAddComma(Number(chss_tare_wgt)   + Number(chss_payld_wgt));
	        		formObj.gross_wgtlb.value=ComAddComma(Number(chss_tare_wgtlb) + Number(chss_payld_wgtlb));
	        	}
	        	sheetObj.SetCellValue(1, "chss_payld_wgt",document.forms[0].chss_payld_wgt.value.replaceStr(","));
	        	obj.value = ComAddComma(obj.value.replaceStr(","));
	        	break;
	        case "chss_ttl_dim_len":
	        	var sheetObj=sheetObjs[0];
	        	var setLenmm=document.forms[0].chss_ttl_dim_len.value.replaceStr(",");
	        	var setLenft=document.forms[0].chss_ttl_dim_len_ft.value.replaceStr(",");
	        	var setLenin=document.forms[0].chss_ttl_dim_len_in.value.replaceStr(",");
	        	setLenmm=((setLenmm)*0.03937)/12 + "";
	        	strIndex=setLenmm.indexOf(".");
	        	setLenft=setLenmm.substring(0, strIndex);
	        	setLenin=(setLenmm.substring(strIndex)*10).toFixed(0);
	        	document.forms[0].chss_ttl_dim_len_ft.value=setLenft;
	        	document.forms[0].chss_ttl_dim_len_in.value=setLenin;
	        	sheetObj.SetCellValue(1, "chss_ttl_dim_len",document.forms[0].chss_ttl_dim_len.value.replaceStr(","));
	        	obj.value = ComAddComma(obj.value.replaceStr(","));
	        	break;
	        case "chss_ttl_dim_wdt":
	        	var sheetObj=sheetObjs[0];
	        	var setWdtmm=document.forms[0].chss_ttl_dim_wdt.value.replaceStr(",");
	        	var setWdtft=document.forms[0].chss_ttl_dim_wdt_ft.value.replaceStr(",");
	        	var setWdtin=document.forms[0].chss_ttl_dim_wdt_in.value.replaceStr(",");
	        	setWdtmm=((setWdtmm) * 0.03937)/12 + "";
	        	strIndex=setWdtmm.indexOf(".");
	        	setWdtft=setWdtmm.substring(0, strIndex);
	        	setWdtin=(setWdtmm.substring(strIndex)*10).toFixed(0);
	        	document.forms[0].chss_ttl_dim_wdt_ft.value=setWdtft;
	        	document.forms[0].chss_ttl_dim_wdt_in.value=setWdtin;
	        	sheetObj.SetCellValue(1, "chss_ttl_dim_wdt",document.forms[0].chss_ttl_dim_wdt.value.replaceStr(","));
	        	obj.value = ComAddComma(obj.value.replaceStr(","));
	        	break;
	        case "chss_ttl_dim_hgt":
	        	var sheetObj=sheetObjs[0];
	        	var setHgtmm=document.forms[0].chss_ttl_dim_hgt.value.replaceStr(",");
	        	var setHgtft=document.forms[0].chss_ttl_dim_hgt_ft.value.replaceStr(",");
	        	var setHgtin=document.forms[0].chss_ttl_dim_hgt_in.value.replaceStr(",");
	        	setHgtmm=((setHgtmm) * 0.03937) / 12 + "";
	        	strIndex=setHgtmm.indexOf(".");
	        	setHgtft=setHgtmm.substring(0, strIndex);
	        	setHgtin=(setHgtmm.substring(strIndex) * 10).toFixed(0);
	        	document.forms[0].chss_ttl_dim_hgt_ft.value=setHgtft;
	        	document.forms[0].chss_ttl_dim_hgt_in.value=setHgtin;
	        	sheetObj.SetCellValue(1, "chss_ttl_dim_hgt",document.forms[0].chss_ttl_dim_hgt.value.replaceStr(","));
	        	obj.value = ComAddComma(obj.value.replaceStr(","));
	        	break;
	        case "chss_ttl_dim_len_ft":
	        	var sheetObj=sheetObjs[0];
	        	var setLenmm=document.forms[0].chss_ttl_dim_len.value.replaceStr(",");
	        	var setLenft=document.forms[0].chss_ttl_dim_len_ft.value.replaceStr(",");
	        	var setLenin=document.forms[0].chss_ttl_dim_len_in.value.replaceStr(",");
	        	setLenmm=(Number(setLenft * 304.79999) + (Number(setLenin) * 25.4)).toFixed(0);
	        	document.forms[0].chss_ttl_dim_len.value=ComAddComma(setLenmm);
	        	sheetObj.SetCellValue(1, "chss_ttl_dim_len",document.forms[0].chss_ttl_dim_len.value.replaceStr(","));
	        	obj.value = ComAddComma(obj.value.replaceStr(","));
		        break;
	        case "chss_ttl_dim_len_in":
	        	var sheetObj=sheetObjs[0];
	        	var setLenmm=document.forms[0].chss_ttl_dim_len.value.replaceStr(",");
	        	var setLenft=document.forms[0].chss_ttl_dim_len_ft.value.replaceStr(",");
	        	var setLenin=document.forms[0].chss_ttl_dim_len_in.value.replaceStr(",");
	        	setLenmm=(Number(setLenft * 304.79999) + (Number(setLenin) * 25.4)).toFixed(0);
	        	document.forms[0].chss_ttl_dim_len.value=ComAddComma(setLenmm);
	        	sheetObj.SetCellValue(1, "chss_ttl_dim_len",document.forms[0].chss_ttl_dim_len.value.replaceStr(","));
	        	obj.value = ComAddComma(obj.value.replaceStr(","));
		        break;
	        case "chss_ttl_dim_wdt_ft":
	        	var sheetObj=sheetObjs[0];
	        	var setWdtmm=document.forms[0].chss_ttl_dim_wdt.value.replaceStr(",");
	        	var setWdtft=document.forms[0].chss_ttl_dim_wdt_ft.value.replaceStr(",");
	        	var setWdtin=document.forms[0].chss_ttl_dim_wdt_in.value.replaceStr(",");
	        	setWdtmm=(Number(setWdtft * 304.79999) + (Number(setWdtin) * 25.4)).toFixed(0);
	        	document.forms[0].chss_ttl_dim_wdt.value=ComAddComma(setWdtmm);
	        	sheetObj.SetCellValue(1, "chss_ttl_dim_wdt",document.forms[0].chss_ttl_dim_wdt.value.replaceStr(","));
	        	obj.value = ComAddComma(obj.value.replaceStr(","));
		        break;
	        case "chss_ttl_dim_wdt_in":
	        	var sheetObj=sheetObjs[0];
	        	var setWdtmm=document.forms[0].chss_ttl_dim_wdt.value.replaceStr(",");
	        	var setWdtft=document.forms[0].chss_ttl_dim_wdt_ft.value.replaceStr(",");
	        	var setWdtin=document.forms[0].chss_ttl_dim_wdt_in.value.replaceStr(",");
	        	setWdtmm=(Number(setWdtft * 304.79999) + (Number(setWdtin) * 25.4)).toFixed(0);
	        	document.forms[0].chss_ttl_dim_wdt.value=ComAddComma(setWdtmm);
	        	sheetObj.SetCellValue(1, "chss_ttl_dim_wdt",document.forms[0].chss_ttl_dim_wdt.value.replaceStr(","));
	        	obj.value = ComAddComma(obj.value.replaceStr(","));
		        break;
	        case "chss_ttl_dim_hgt_ft":
	        	var sheetObj=sheetObjs[0];
	        	var setHgtmm=document.forms[0].chss_ttl_dim_hgt.value.replaceStr(",");
	        	var setHgtft=document.forms[0].chss_ttl_dim_hgt_ft.value.replaceStr(",");
	        	var setHgtin=document.forms[0].chss_ttl_dim_hgt_in.value.replaceStr(",");
	        	setHgtmm=(Number(setHgtft * 304.79999) + (Number(setHgtin) * 25.4)).toFixed(0);
	        	document.forms[0].chss_ttl_dim_hgt.value=ComAddComma(setHgtmm);
	        	sheetObj.SetCellValue(1, "chss_ttl_dim_hgt",document.forms[0].chss_ttl_dim_hgt.value.replaceStr(","));
	        	obj.value = ComAddComma(obj.value.replaceStr(","));
		        break;
	        case "chss_ttl_dim_hgt_in":
	        	var sheetObj=sheetObjs[0];
	        	var setHgtmm=document.forms[0].chss_ttl_dim_hgt.value.replaceStr(",");
	        	var setHgtft=document.forms[0].chss_ttl_dim_hgt_ft.value.replaceStr(",");
	        	var setHgtin=document.forms[0].chss_ttl_dim_hgt_in.value.replaceStr(",");
	        	setHgtmm=(Number(setHgtft * 304.79999) + (Number(setHgtin) * 25.4)).toFixed(0);
	        	document.forms[0].chss_ttl_dim_hgt.value=ComAddComma(setHgtmm);
	        	sheetObj.SetCellValue(1, "chss_ttl_dim_hgt",document.forms[0].chss_ttl_dim_hgt.value.replaceStr(","));
	        	obj.value = ComAddComma(obj.value.replaceStr(","));
		        break;
	    }
	}
	/**
	 * unit transfer : Kg >> Lbs
	 * formular : Kg = Lbs * 0.45359
	 */
	function chgKgLbs(kgs){
		return ComRound(kgs * 2.2046, 0);
	}
	/**
	 * unit transfer : Lbs >> Kg
	 * formular : Lbs = Kg * 2.2046
	 */
	function chgLbKgs(lbs){
		return ComRound(lbs * 0.45359, 0);
	}
	 /**
	 * function(ex:btn_save) role(trole) apply  <br>
	 * @param 
	 * @return 
	 * @author 
	 * @version
	 */     
	 function tRoleApply() {
//		  var formObj=document.form;
//		  if(formObj.trole.value == "Authenticated")
//		  {
//		  }else
//		  {
//			  ComBtnDisable("btn_save");
//			  ComBtnDisable("btn_delete");
//		  }
	 } 
	 
	 function sheet1_OnSaveEnd(sheetObj,ErrMsg) {
		 doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC03);
		 eq_spec_no.SetSelectText(tmp_eq_spec_no);//
	     with(eq_spec_no) { // setting edit enable in case of click new
	    	 Style=1; //setting edit unable
	       	 SetUseEdit(0);
		 }

	     formObj.eq_spec_no_ins.disabled=true;
	 }
	 