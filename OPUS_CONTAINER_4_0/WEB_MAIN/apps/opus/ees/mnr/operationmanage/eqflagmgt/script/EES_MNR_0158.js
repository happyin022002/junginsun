/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0158.js
*@FileTitle  : M&R Disposal Candidate Inquiry_Pop Up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/13
=========================================================*/
	/****************************************************************************************
	  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
						MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
						OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
	 ***************************************************************************************/
	/**
	 * @extends 
	 * @class ees_mnr_0158 : business script for ees_mnr_0158.
	 */
	/* developer job	*/
	//common global variables
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var nowLoad=0;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick(){
		var sheetObject1=sheetObjects[0];
		/*******************************************************/
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
				break;
			case "btn_ok":
				if(sheetObjects[0].FindCheckedRow("checkbox") == ""){
					ComShowCodeMessage("MNR00038","SELECT ");             	   
				} else {     
					if(window.dialogArguments != undefined)
					{	
						var checkValue=sheetObjects[0].GetRangeText(sheetObjects[0].GetSelectRow(), 1, sheetObjects[0].GetSelectRow(),  sheetObjects[0].LastCol(), "|", "^");
						//window.dialogArguments.setPopUpParam_EES_MNR_0214(checkValue);
						ComClosePopup(); 
					}else{
						comPopupOK();    	
					}
				}   
				break;
			case "btn_close":
				ComClosePopup(); 
				break;
			case "btn_location":
				ComOpenPopup("COM_ENS_051.do", 800, 420, 'setPopUpParam_COM_ENS_051', '1,0', true);
				break;	
			case "btn_downExcel":
				if(sheetObjects[0].RowCount() < 1){//no data	
					ComShowCodeMessage("COM132501");
				}else{	
					sheetObjects[0].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[0]), SheetDesign:1,Merge:1 });
				}	
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
    function setPopUpParam_COM_ENS_051(array) {
    	if(array == null)return;
    	var formObj=document.form;
    	var str=array + "";
    	var arr=str.split(",");
    	formObj.location_cd.value=arr[3];
    	if(arr[3] !="")
    	{
    		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    	}
    }    
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
		MnrWaitControl(true);
		initControl();
		for(i=0;i<sheetObjects.length;i++){
			//
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i + 1);
			//
			ComEndConfigSheet(sheetObjects[i]);
		}
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		MnrWaitControl(false);	
    }
  	function initControl() {       
  		//Axon handling event1. event catch  
  		var formObject=document.form;       
  		axon_event.addListenerForm  ('blur',     'obj_deactivate',  formObject);	
  	//	axon_event.addListenerFormat('focus',    'obj_activate',    formObject);    
  		axon_event.addListenerFormat('keypress', 'obj_keypress', 	formObject);    
  		axon_event.addListenerFormat('change',	 'obj_change',		formObject); 	
  	}             
  	//Axon handling event2. handling event   
  	function obj_deactivate(){      
  		ComChkObjValid(event.srcElement); 
  	} 
  	function obj_activate(){   
  		ComClearSeparator(event.srcElement);
  	}        
  	function obj_change(){	     
  		var obj=event.srcElement; 
  		var formObj=document.form; 
  		var sheetObj=sheetObjects[0]; 
  		if ( ComTrim(obj.value) != "" ) {
  			switch(ComGetEvent("name")) {      
  			case "empty":    
  				break;   
  			}        
  		} 
  	}    
  	function obj_keypress(){   
  		obj=event.srcElement;    
  		keys=event.keyCode;	
  		if(obj.dataformat == null) return; 
  		window.defaultStatus=obj.dataformat;
  		var formObj=document.form; 
  		if ( ComTrim(obj.value) != "" ) {
  			switch(ComGetEvent("name")) { 	     
  			case "location_cd":   
  				var strMnrOrdSeqAll=formObj.location_cd.value;
  				var strMnrOrdSeqTail="";
  				if(strMnrOrdSeqAll.length >= 5)
  				{ 
  					if(keys==13)
  					{
  						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
  					}
  				}
  				break;   
  			}       
  		}				 			              
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
    /**
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items
     * defining list on the top of source
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
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
            case "sheet1":
                with(sheetObj){
		              var HeadTitle1="|Sel|Seq|Sale Category|EQ No|TP/SZ|TERM|MVMT|YARD|EventDate|S/Days|BKG No|Material|Maker Name|Unit Model|M/Date|CRE DT|DV Value|";
		              var headCount=ComCountHeadTitle(HeadTitle1);
		              (21, 0, 0, true);
		              var prefix="sheet1_";
		
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
		                     {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"checkbox",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
		                     {Type:"Combo",     Hidden:0, Width:100,  Align:"Left",    ColMerge:1,   SaveName:prefix+"disp_rsn_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"eq_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"eq_tpsz_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"lstm_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"mvmt_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"mnr_dmg_flg_yd_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"mvmt_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"sdays_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:prefix+"bkg_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:prefix+"mtrl_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:prefix+"eq_mkr_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:prefix+"eq_mdl_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"manu_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cre_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:prefix+"dv_value",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"mtrl_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"ut_price",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"rpr_cost_amt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		               
		              InitColumns(cols);
		
		              SetEditable(1);
		              SetEditableColorDiff(1);
		              SetSelectionMode(smSelectionRow);
		              SetSheetHeight(285);
              }
		break;
        }
    }
    // handling process for sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg(false);
    	switch(sAction) {
    	case IBCLEAR:
    		MnrWaitControl(true);
			if(MnrNullToBlank(formObj.cost_ofc_cd.value) == ""){
				formObj.cost_ofc_cd.value=currOfcCd;
			}	
    		formObj.location_cd.value="";
    		sheetObjects[0].RemoveAll();
			sheet1_disp_rsn_cd_Initialize();
    		MnrWaitControl(false);
    		break;
    	case IBSEARCH:      //retrieving
    		MnrWaitControl(true);
    		if(!validateForm(sheetObj,formObj,sAction))
    		{
    			MnrWaitControl(false);
    			return;
    		}
    		nowLoad=1;
    		sheetObjects[0].RemoveAll();
    		formObj.f_cmd.value=SEARCH; 
    		var sParam="";
    		var aryPrefix=new Array("sheet1_");
    		sParam += ComGetPrefixParam(aryPrefix)+ "&" + FormQueryString(formObj);
    		//alert("IBSEARCH : " + "\n"+ sParam);
     		var sXml=sheetObj.GetSearchData("EES_MNR_0158GS.do", sParam);
    		arrDataSearchDbXml=sXml.split("|$$|");
    		for ( var i=0; i < arrDataSearchDbXml.length; i++) {
    			sheetObjects[i].RenderSheet(0);
    			sheetObjects[i].SetWaitImageVisible(0);
    			sheetObjects[i].LoadSearchData(arrDataSearchDbXml[i],{Sync:0} );
    			sheetObjects[i].RenderSheet(1);
    		}   		 	   
    		break;
    	}
    }
	function sheet1_disp_rsn_cd_Initialize(){
		var sheetObj=sheetObjects[0];
		//retrieving Combo
		var sCondition=new Array (
			new Array("MnrGenCd","CD00038", "COMMON") //Sale Category		
		);
		var comboList=MnrComSearchCombo(sheetObj,sCondition);
		//setting sheet
		var sheetComboText="";
		var sheetComboCode="";
		var sheetComboCodeText="";
		var sheetComboDefault="";
		for(var i=0; i < comboList.length;i++)
		{
			//initializing sheetCombo
			sheetComboText="";
			sheetComboCode="";
			sheetComboCodeText="";
			sheetComboDefault=""; 
			if(comboList[i] != null)
			{	
				for(var j=0; j < comboList[i].length;j++)
				{ 
					var tempText=comboList[i][j].split("|");   
					sheetComboText +=  tempText[1] + "|";
					sheetComboCode +=  tempText[0] + "|";
					sheetComboCodeText +=  tempText[0] + "\t" + tempText[1] + "|";
					if(j ==0)
					{	
						sheetComboDefault=tempText[0];      	
					}
				}
				//setting sheet combo
				if(i == 0)
				{
					sheetObjects[0].SetColProperty(0,"sheet1_disp_rsn_cd", {ComboText:sheetComboText, ComboCode:sheetComboCode} );
				}
			}
		}		
	}    	
    function sheet1_OnSearchEnd(sheetObj,errMsg){
        if(errMsg!=""){
            showErrMessage(errMsg);
        }
        MnrWaitControl(false);
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
			switch(sAction) {  	
				case IBSEARCH:      
					if (!ComChkValid(formObj)) return false;
				break;
			}	
        }
        return true;
    }	
	function sheet1_OnChange(sheetObj,Row, Col, Value){ 
		if(sheetObj.ColSaveName(Col) == "checkbox"){
			MnrCheckRowColChange(sheetObj,sheetObj.GetCellValue(Row,"checkbox"),Row);
		}	
	}
	function sheet1_OnClick(sheetObj,Row,Col){   
		if(sheetObj.ColSaveName(Col) != "checkbox"){
			if(sheetObj.GetCellValue(Row,"checkbox") == "1"){
				sheetObj.SetCellValue(Row,"checkbox","0");
			} else {
				sheetObj.SetCellValue(Row,"checkbox","1");
			}   
		}
 	}
