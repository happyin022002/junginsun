	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : ees_mnr_0211.js 
	 *@FileTitle : W/O Inquiry - Popup
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 
	 *@LastModifier : 
	 *@LastVersion : 1.0
	=========================================================*/
	/****************************************************************************************
	 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
						MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
						OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
	 ***************************************************************************************/
	/**
	 * @extends
	 * @class ees_mnr_0211 :  business script for ees_mnr_0211.
	 */
	//common global variables
	var sheetObjects=new Array();
	var sheetCnt=0;
	var initInd='N'
	var mainMsg='W/O Inquiry Popup'
	var subMsg='XXX'
	var eqcode="";
	var eqdesc="";
	var opener = window.dialogArguments;
	//Event handler processing by button click event */
	document.onclick=processButtonClick;
	//Event handler processing by button name */
	function processButtonClick() {
		var sheetObject=sheetObjects[0];
		/** **************************************************** */
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch (srcName) {
			case "btn1_Retrieve":
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;
			case "btn1_New":
				doActionIBSheet(sheetObject,formObject,IBCLEAR);
				break;
			case "btn1_OK":
				doActionIBSheet(sheetObject,formObject,COMMAND01);
				break;
			case "btn1_Close":
				ComClosePopup(); 
				break;
			case "btn_calendar":
				var cal=new ComCalendarFromTo();
				cal.select(formObject.fromcal, formObject.tocal, 'yyyy-MM-dd');
				break;
			} // end switch
		} catch (e) {
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
		MnrWaitControl(true);
		if (!opener) opener = parent;
		initControl();   
		for (i=0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		initCombo();
		//retrieving Combo
		var sheetObj=sheetObjects[0];
		var formObj=document.form;
		var sCondition=new Array (
				new Array("MnrGenCd","CD00020", "COMMON") //Buyer Type _MNR_PRNR_KND_CD and Buyer Type Infomation _MNR_PRNR_KND_CD2			
				,new Array("MnrGenCd","","CUSTOM9")  //Buyer Detail Type _mnr_prnr_knd_dtl_cd
		);
		var comboList=MnrComSearchCombo(sheetObj,sCondition);
		//setting sheet
		var sheetComboText="";
		var sheetComboCode="";
		var sheetComboCodeText="";
		var sheetComboDefault="";
		for(var i=0; i < comboList.length;i++){
			//initializing sheetCombo
			sheetComboText="";
			sheetComboCode="";
			sheetComboCodeText="";
			sheetComboDefault=""; 
			if(comboList[i] != null){
				for(var j=0; j < comboList[i].length;j++){ 
					var tempText=comboList[i][j].split("|");   
					sheetComboText +=  tempText[1] + "|";
					sheetComboCode +=  tempText[0] + "|";
					sheetComboCodeText +=  tempText[0] + "\t" + tempText[1] + "|";
					if(j ==0){	
						sheetComboDefault=tempText[0];      	
					}
					if(i==0) {
						combo1.InsertItem(j, tempText[0]+"|"+tempText[1]  ,tempText[0]);
					}else if (i==1) {
						combo2.InsertItem(j, tempText[1] ,tempText[0]);
					}
				}
				if(i==0){
					combo1.InsertItem(0, "ALL" , "ALL");
					combo1.SetSelectCode("ALL");
				}else if(i==1){
					combo2.InsertItem(0, "ALL" , "ALL");
					combo2.SetSelectCode("ALL");
				}
			}
		}
		formObj.tocal.value=ComGetNowInfo();
		formObj.fromcal.value=ComGetDateAdd(ComGetNowInfo("ymd"), "d", -15); //previous 15 days
		if(opener != undefined)
		{
			var formObject=document.form;
			if(opener.document.form.mnr_wo_tp_cd!=undefined)
			{
				combo1.SetSelectCode(opener.document.form.mnr_wo_tp_cd.value,false);
				combo1.SetEnable(0);
			}
			if(opener.document.form.cost_ofc_cd!=undefined)
			{
				formObject.cost_ofc_cd.value=opener.document.form.cost_ofc_cd.value;
			}
			doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
		}
		MnrWaitControl(false);
	}
	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		var sheetId=sheetObj.id;
		switch (sheetId) {
		case "sheet1":
		    with(sheetObj){
		      var HeadTitle1="|Sel|Seq|W/O Type|W/O No.|S/P Code|Service Provider Name|W/O Send Type|W/O Send Date|Agreement No|W/O Date|W/O Amount";
		      var headCount=ComCountHeadTitle(HeadTitle1) + 1;
	
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
	
		      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"NONE" } ];
		            if(window.dialogArguments != undefined)
		      {
			      if(typeof(window.dialogArguments.document.form.sel_type)!="undefined")
			      {
				      if(window.dialogArguments.document.form.sel_type.value=="M")
				    	  cols.push({Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"selchk" });
				      else if(window.dialogArguments.document.form.sel_type.value=="S")
				    	  cols.push({Type:"Radio",     Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"selchk" });
			      }else{
			    	  cols.push({Type:"Radio",     Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"selchk" });
			      }
		      }else{
		    	  cols.push({Type:"Radio",     Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"selchk" });
		      }
		      cols.push({Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" });
		      cols.push({Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"mnr_grp_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
		      cols.push({Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"wono",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
		      cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"vndr_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
		      cols.push({Type:"Text",      Hidden:0,  Width:140,  Align:"Left",    ColMerge:1,   SaveName:"vndr_lgl_eng_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
		      cols.push({Type:"Text",      Hidden:0,  Width:95,   Align:"Left",    ColMerge:1,   SaveName:"trsm_mod_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
		      cols.push({Type:"Text",      Hidden:0,  Width:95,   Align:"Left",    ColMerge:1,   SaveName:"senddt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
		      cols.push({Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"agmt_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
		      cols.push({Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:"cre_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
		      cols.push({Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"mnr_wrk_amt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 });
		      cols.push({Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"eq_knd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
		 
		      InitColumns(cols);

		      SetEditable(1);
	            SetSelectionMode(smSelectionRow);

		        SetSheetHeight(200);
	      }


			break;
		}
	}
	/**
	 * initializing multi Combo 
	 * @return
	 */
	function initCombo() {
		with (combo1) {
			SetMultiSeparator("|");
			SetColAlign(0, "left");
			SetColAlign(1, "left");
			SetColWidth(0, "100");
			SetColWidth(1, "150");
			SetDropHeight(160);
		} 
		with (combo2) { 
			SetMultiSeparator("|");
			SetColAlign(0, "left");
			SetColAlign(1, "left");
			SetColWidth(0, "100");
			SetColWidth(1, "0");
			SetDropHeight(160);
		} 
	}
	/**
	* registering IBSheet Object as list
	* adding process for list in case of needing batch processing with other items
	* defining list on the top of source
	*/
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	function sheet1_OnSearchEnd(sheetObj, errMsg)
	{
		ComOpenWait(false);
		nowLoad=0; 
		MnrWaitControl(false); 
	}
	function sheet1_OnDblClick(sheetObj,Row, Col, CellX, CellY, CellW, CellH){
		document.form.retfld.value=sheetObj.GetCellValue(Row,"wono");
		comPopupOK(); 
	} 
	// handling process for sheet 
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) 
		{    
		case IBSEARCH:      //retrieving 
			if(!validateForm(sheetObj,formObj,sAction))return;
			sheetObj.RenderSheet(1);
			sheetObj.SetWaitImageVisible(1);
			formObj.f_cmd.value=SEARCH;
			var sParam=FormQueryString(formObj);
			sParam += "&currOfcCd="+ currOfcCd; 
			var sXml=sheetObj.GetSearchData("EES_MNR_0211GS.do",  sParam);
			ComOpenWait(true);
			sheetObj.LoadSearchData(sXml,{Sync:1} );
			//sheetObj.WaitImageVisible = false;
			//sheetObj.Redraw = false; 
			MnrWaitControl(false);                
			break;   	       
		case IBCLEAR:      //initializing  
			sheetObj.RemoveAll();
			break;           
		case COMMAND01:      //ok 			
			if(sheetObj.RowCount()< 1)
			{
				ComClosePopup(); 
				return false;
			}
			var selCheck=sheetObj.FindCheckedRow("selchk");
			if(sheetObj.FindCheckedRow("selchk") == ""){
				ComShowCodeMessage("MNR00038","Select ");
				return false;             	   
			}
			if(opener != undefined)
			{
				if(typeof(opener.document.form.wo_no) != "undefined")
				{
					var splCheck=selCheck.split("|");
					var strWoNO="";
					for(var i=0;i<splCheck.length;i++)
					{
						if(i==0)strWoNO+=sheetObj.GetCellValue(splCheck[i],"wono");
						else 
						{
							if(splCheck[i]!="")
								strWoNO+=","+sheetObj.GetCellValue(splCheck[i],"wono");
						}
					}
					opener.document.form.wo_no.value=strWoNO;
					ComClosePopup(); 
					return false;     
				}else{
					comPopupOK(); 
					return false;  
				}
			}else{
				comPopupOK(); 
				return false;     
			}
			break;  
		}  
	}      
	/**
	* handling process for input validation
	*/
	function validateForm(sheetObj, formObj, sAction) {
		with (formObj)
		{
        	switch(sAction) 
        	{  	
			case IBSEARCH: 
				if (!ComChkObjValid(formObj)) {return false;}
				if(ComGetDaysBetween(formObj.fromcal.value, formObj.tocal.value) > 90)
				{
					ComShowCodeMessage("MNR00325","W/O Date","3Months");
					return false;
				}
			 	break;	
        	}
		}
			return true;
	}
	function initControl() {       
	    //Axon handling event1. event catch  
		var formObject=document.form;       
	    axon_event.addListenerForm  ('blur',     'obj_deactivate',  formObject); 			  
	  //  axon_event.addListenerFormat('focus',    'obj_activate',    formObject);             
	    //axon_event.addListenerFormat('keypress', 'obj_keypress', 	formObject);            
	}             
	//Axon handling event2. handling event   
	function obj_deactivate(){      
	    ComChkObjValid(ComGetEvent()); 
	} 
	function obj_activate(){   
	    ComClearSeparator(ComGetEvent());
	}        
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
	            ComKeyOnlyNumber(obj, "-.");
	            break; 
	        case "eng":   
	            ComKeyOnlyAlphabet();
				break;   
	        case "engup":   
				ComKeyOnlyAlphabet('uppernum');            
	            break; 
	    }         
	}	
/* ending developer job */
