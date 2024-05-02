/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   :ESM_COA_0015.js
*@FileTitle  : Inquiry and update DEM/DET 3RD 
*@author     : CLT
*@version    : 1.0
*@since      : 29/04/2014
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

   	/* Developer's task	*/
 // Grobla Variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    /* Event handler processing by button click event */
    document.onclick=processButtonClick;
    /* Event handler processing by button name */
	function processButtonClick(){
		/***** Specify additional sheet variable in case of using more than two sheet per tab *****/
		var sheetObject=sheetObjects[0];
		/*******************************************************/
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;
				case "btn_downexcel":
					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
					break;
				case "btn_loadexcel":
					doActionIBSheet(sheetObject,formObject,IBLOADEXCEL);
					break; 
				case "btng_save":
					doActionIBSheet(sheetObject,formObject,IBSAVE);
					break;
				case "btn_add":
					doActionIBSheet(sheetObject,formObject,IBINSERT);
					break;
			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(ComGetMsg(OBJECT_ERROR));
			} else {
			ComShowMessage(e.message);
			}
		}
	}
	/**
* initializing sheet
* implementing onLoad event handler in body tag
* adding first-served functions after loading screen.
	*/
	function loadPage() {
		for(i=0;i<sheetObjects.length;i++){
			//Sheet configuration setting function(start)
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			//Sheet configuration setting function(end)
			ComEndConfigSheet(sheetObjects[i]);
		}
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
	}
	/**
* setting sheet initial values and header
* param : sheetObj, sheetNo
* adding case as numbers of counting sheets
	*/
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		switch(sheetNo) {
			case 1:	//sheet2 init
			    with(sheetObj){
			      var HeadTitle="Del.|STS|No.|TP/SZ|C/A Code|Unit Cost|AMT|Vol.|CTRT/AVG" ;
	
			      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	
			      var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			      InitHeaders(headers, info);
			    
			      var cols = [ {Type:"DelCheck",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"" },
			             {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"" },
			             {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
			             {Type:"Combo",     Hidden:0, Width:240,  Align:"Left",    ColMerge:0,   SaveName:"stnd_cost_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             //PCM.20141222.MOD
			             {Type:"Float",     Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"uc_amt",           KeyField:0,   CalcLogic:"|ttl_dmdt_amt|/|bkg_vol_qty|",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:25 }, 
			             {Type:"Int",      Hidden:0, Width:100,   Align:"Right",   ColMerge:0,   SaveName:"ttl_dmdt_amt",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:25 },
			             {Type:"Int",      Hidden:0, Width:70,   Align:"Right",   ColMerge:0,   SaveName:"bkg_vol_qty",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Combo",     Hidden:0, Width:60,   Align:"Left",    ColMerge:0,   SaveName:"cost_ass_bse_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
			       
			      InitColumns(cols);
			      SetEditable(1);//Editkind[optional,Defaultfalse]
//			      SetSheetHeight(430);
				  resizeSheet();
			      SetWaitImageVisible(0);
			}
			break;
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
	function sheet1_OnChange(sheetObj, Row,Col,Value) {
		var sName=sheetObj.ColSaveName(Col);
		if ( sName == "bkg_vol_qty") {
			sheetObj.SetCellValue(Row, "uc_amt",sheetObj.GetCellValue(Row,"ttl_dmdt_amt")/Value);
			sheetObj.SetCellValue(Row, "cost_ass_bse_cd", "F");
		} else if( sName== "ttl_dmdt_amt"){
			if (sheetObj.GetCellValue(Row,"bkg_vol_qty") == 0) {
				sheetObj.SetCellValue(Row, "uc_amt",Value/1);
			} else {
				sheetObj.SetCellValue(Row, "uc_amt",Value/sheetObj.GetCellValue(Row,"bkg_vol_qty"));
			}
			sheetObj.SetCellValue(Row, "cost_ass_bse_cd", "F");
		} 
	}
	// Handling process about the sheet object
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			case IBCLEAR:
				ComOpenWait(true);
				var sXml=document.form.sXml.value; 				
				var arrXml=sXml.split("|$$|");
				if (arrXml.length > 0) {
					ComCoaSetIBCombo(sheetObj, arrXml[0], "stnd_cost_cd", true, 0);
				}
				if (arrXml.length > 1) {
					ComCoaSetIBCombo(sheetObj, arrXml[1], "cost_ass_bse_cd", true, 0);
				}
				if (arrXml.length > 2) {
					ComCoaSetIBCombo(sheetObj, arrXml[2], "cntr_tpsz_cd", true, 0,0,"TEU");
				}
				document.form.sXml.value="";
				setYrMon();
				ComOpenWait(false);
				break;
			case IBSEARCH:	//Inquiry
				if(validateForm(sheetObj,formObj,sAction)){
					// Prohibit button click when a business transaction is processing 
					ComOpenWait(true);
					formObj.f_cmd.value=SEARCH;
					sheetObj.DoSearch("ESM_COA_0015GS.do", FormQueryString(formObj) );
				}
				break;
			case IBSAVE:	//Save
				if(validateForm(sheetObj,formObj,sAction)){
					// Prohibit button click when a business transaction is processing 
					ComOpenWait(true);
					formObj.f_cmd.value=MULTI;
					sheetObj.DoSave("ESM_COA_0015GS.do", FormQueryString(formObj));
		            ComOpenWait(false);
				}
				break;
			case IBDOWNEXCEL:	// Excell download
				var excelType=selectDownExcelMethod(sheetObj);
				break;
        	case IBLOADEXCEL:	        	
        		//20150716.MOD/ADD/DEL
        		sheetObj.SetWaitImageVisible(0);
	        	sheetObj.RemoveAll();
	        	sheetObj.LoadExcel({ Mode:"HeaderMatch", StartRow: "1"});
	        	checkValidationAllData(sheetObj);
				break;
            case IBINSERT:
                var idx=sheetObj.DataInsert(-1);
                sheetObj.SetCellValue(idx, "cntr_tpsz_cd", "TEU");
                break;		
		}
	}
	
	function callBackExcelMethod(excelType){
		 switch (excelType) {
         case "AY":
        	 sheetObjects[0].Down2Excel({ HiddenColumn:0, SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
             break;
         case "AN":
        	 sheetObjects[0].Down2Excel({ HiddenColumn:0, SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
		    	break;
         case "DY":
        	 sheetObjects[0].Down2Excel({ HiddenColumn:1, SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' });
         	break;
         case "DN":
        	 sheetObjects[0].Down2Excel({ HiddenColumn:1, SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' });
		    	break;
		 }
	}
	
	
	function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
		ComOpenWait(false);
	}
	
	function sheet1_OnSaveEnd(sheetObj, Code, Msg, StCode, StMsg) { 
		//SJH.20141223.ADD		
        if(Msg == ""){
        	ComShowMessage(ComGetMsg("COM130102","Data"));
        }else{
            ComShowMessage(ComGetMsg("COM132101"));
        }	
        ComOpenWait(false);
        doActionIBSheet(sheetObj,document.form,IBSEARCH);	
	}
	
	/**
	* Handling process for form object input validation
	*/
	function validateForm(sheetObj,formObj,sAction){
		var rt=false;
		with(formObj){
			if(!isValidYYYYMM(f_cost_yrmon , false, '-', false)){
			}else {
				rt=true;
			}
		}	
		
	  	switch (sAction) {
  		case IBSAVE:
			//SJH.20140725 ADD : SHZ case check type/size items value validation : only [TEU]
			for ( var i = sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
				if (sheetObj.GetCellValue(i, "ibflag") != "D") {
					if (sheetObj.GetCellValue(i, "cntr_tpsz_cd") != "TEU") {						
						ComShowCodeMessage('COM12114','TP/SZ ( '+sheetObj.GetCellValue(i, "cntr_tpsz_cd")+' )');
						return false;
						break;
					}						
				}
			}
			//SJH.20141223.ADD : DUP CHECK
			var dr = sheetObj.ColValueDup("cntr_tpsz_cd|stnd_cost_cd");
  			if(dr>0){
  				if (sheetObj.GetCellValue(dr, "ibflag") == "I") {
  					ComShowCodeMessage('COM12115', 'TP/SZ, C/A Code');
  					sheetObj.SelectCell(dr, "stnd_cost_cd", true);
  					return false;				
  				}
  			}
  			break;  			
		}		
	  	
		return rt;
	}
	/*
	* Function to check in case of saving the upload data<br>
	* <br><b>Example :</b>
	* <pre>
	* 
	* </pre>
* @param {ibsheet} sheetObj mandatory IBSheet Object
* @return nothing
	*/
	function checkValidationAllData(sheetObj) {
		var formObj=document.form;
		//Check items value validation of the window
		for ( var i=sheetObj.HeaderRows(); i < sheetObj.LastRow(); i++) {
		if (sheetObj.GetCellValue(i, "cntr_tpsz_cd") == "") {
						sheetObj.SetCellText(i, "cntr_tpsz_cd" ,"");
					}
		if (sheetObj.GetCellValue(i, "stnd_cost_cd") == "") {
						sheetObj.SetCellText(i, "stnd_cost_cd" ,"");
					}
		if (sheetObj.GetCellValue(i, "cost_ass_bse_cd") == "") {
						sheetObj.SetCellText(i, "cost_ass_bse_cd" ,"");
			}		
		}
		return false;
	}  	
	
	
	

    /**
     * Setting this month
     * setYrMon()
     *
     * @param NONE
     * @return NONE
     */
    function setYrMon(){
        var formObj = document.form;
        with(formObj){
            var nowYear = ComGetNowInfo("yy");
            var nowMon  = ComGetNowInfo("mm");
            if ( nowMon.length == 1 ) nowMon = "0" + nowMon; // conversion : 1month -> 01month 
            var nowYrMon = nowYear + nowMon;
            f_cost_yrmon.value = nowYrMon;
            f_cost_yrmon.dataformat = "ym";
            //isValidYYYYMM(f_yearweek,true,'-',true);
            if(!ComAddSeparator(f_cost_yrmon)) return false;
        }
    }

    function resizeSheet(){
   	 ComResizeSheet(sheetObjects[0]);
    }
    
    //SJH.20150507.ADD : LOADEXCEL OPTION
    function sheet1_OnLoadExcel(sheetObj, result, code, msg) {	
    	ComOpenWait(false);									//20150716.MOD
    	if(isExceedMaxRow(msg)) return;
    }    
    
    //20150716.ADD
    function sheet1_OnLoadFileSelect(sheetObj){
        ComOpenWait(true);
    }

	/* Developer's task ends */
    