/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0162.js
*@FileTitle  : Container List on Stowage & B/L
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

/* developer job	*/
// common global variables
 var sheetObjects=new Array();
 var sheetCnt=0;
 var comboObjects=new Array();
 var combo1=null;
 var comboCnt=0; 
 // Event handler processing by button click event
 document.onclick=processButtonClick;
	
 	// Event handler processing by button name
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
 	         var sheetObject1=sheetObjects[0];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			break;
			case "btn_downexcel":
				if(sheetObject1.RowCount() < 1){
					ComShowCodeMessage("COM132501");
				}else{
					sheetObject1.Down2Excel({DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1 });
				}
			break;	
			case "btn_history":
				var srow=sheetObject1.GetSelectRow();
				if(srow < 0){
					ComShowCodeMessage('BKG40055');
					return;
				}
				var tmp=sheetObject1.GetCellValue(srow, "cntr_no");
				if (tmp == "" || tmp.length != 11 ){
					ComShowCodeMessage('BKG40055');
					return;
				}
				var cntrNo=(tmp != null && tmp.length>10) ? tmp.substring(0,10) : tmp;;
                   var checkDigit=(tmp != null && tmp.length>10) ? tmp.substring(10) : '';
                   var typeSize=sheetObject1.GetCellValue(srow, "cntrts_cd");
				var url="EES_CTM_0411_POP.do?mainPage=false&func=&cntrNo="+cntrNo+"&checkDigit="+checkDigit+"&typeSize="+typeSize;
				ComOpenWindowCenter(url, "EES_CTM_0411", 1050, 650, false);
				break;
			case "btn_print":
				alert(srcName);
			break;																											
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowCodeMessage("COM12111");
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }
     
 	/**
 	* registering IBSheet Object as list adding process for list in case of needing batch processing with other items 
 	* defining list on the top of source
 	*/
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    
    function setComboObject(combo_obj){
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
	 	//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	 	initControl();
	 	doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
	 	//IBMultiCombo초기화
		for(var j=0; j<comboObjects.length; j++){
		    initCombo(comboObjects[j]);
		}
    }
     
   	/**
     * Dynamically load HTML Control event in page. <br>
     * Initialize IBSheet Object by calling this function from {@link #loadPage} function.
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects list in turn
     **/
    function initControl() {
    	//** Date SEPARATOR **/
    	DATE_SEPARATOR="-";
    	var formObject=document.form;
    	axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject); //- 키보드 입력할때
    	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    }
    
    /**
	 * combo basic value
	 * @param {IBMultiCombo} comboObj  comboObj
	 */
	function initCombo(comboObj) {
	var formObj=document.form;  
		comboObj.SetDropHeight(250);
		comboObj.SetUseAutoComplete(1);
		comboObj.index=0;
		switch(comboObj.id) {
			case "bkg_cgo_ty_cd": 
				ComSetObjValue(formObj.bkg_cgo_ty_cd,"U");
				break;
			case "sp_cntr_ty_cd": 
				ComSetObjValue(formObj.sp_cntr_ty_cd,"AL");	
				break;
			case "cgo_tp": 
				ComSetObjValue(formObj.cgo_tp,"ALL");
				break;
		}		
	}
	
	function resizeSheet(){
        ComResizeSheet(sheetObjects[0]);
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
           	 with(sheetObj){
           	 
	               
	               var HeadTitle1="Seq.|Container No.|T/P|Load|BKG No.|F/M|B/L No.|B/L|B/L|Stowage|Stowage|Stowage|Special Container|Special Container|Special Container|Special Container|Special Container|H B/L";
	               var HeadTitle2="Seq.|Container No.|T/P|Load|BKG No.|F/M|B/L No.|POL|POD|POL|POD|Cell Position|DG|BB|AK|RF|PC|H B/L";
	
	               SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:0, DataRowMerge:0 } );
	
	               var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	               var headers = [ { Text:HeadTitle1, Align:"Center"},
	                           { Text:HeadTitle2, Align:"Center"} ];
	               InitHeaders(headers, info);
	
	               var cols = [ {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
	                            {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"cntr_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                            {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cntrts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                            {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                            {Type:"Text",      Hidden:0, Width:115,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                            {Type:"Text",      Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"cgo_tp",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                            {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                            {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"bk_pol",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                            {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"bk_pod",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                            {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"bay_pol",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                            {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"bay_pod",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                            {Type:"Text",      Hidden:0, Width:75,   Align:"Center",  ColMerge:0,   SaveName:"stwg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                            {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"dg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                            {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"bb",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                            {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ak",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                            {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"rf",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                            {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"pc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                            {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"hbl",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	                
	               InitColumns(cols);
	               SetWaitImageVisible(0);
	               SetEditable(0);
	               //SetSheetHeight(400);
	               resizeSheet();
                    }
                break;
        }
    }
	
    // handling of Sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
	        case IBCLEAR: // onload
				formObj.f_cmd.value=COMMAND01;
 				var sXml=sheetObj.GetSearchData("ESM_BKG_0162GS.do", FormQueryString(formObj));
 				console.log('-------------------------------------------------------');
 				console.log(sXml);
 				console.log('-------------------------------------------------------');
				var arrXml=sXml.split("|$$|");
				if (arrXml.length > 4) {
					ComXml2ComboItem(arrXml[4], cgo_tp, "val", "val");
					cgo_tp.SetSelectCode("ALL");
				}
				if (arrXml.length > 3) {
					ComXml2ComboItem(arrXml[3], sp_cntr_ty_cd, "val", "name");
					sp_cntr_ty_cd.SetSelectCode("AL");
				}
				if (arrXml.length > 2) {
					ComXml2ComboItem(arrXml[2], bkg_cgo_ty_cd, "val", "name");
					bkg_cgo_ty_cd.SetSelectCode("U");
				}
				if (arrXml.length > 1) { 
					ComXml2ComboItem(arrXml[1], stwg_status, "val", "name");
					stwg_status.SetSelectCode("C");
				}
				if (arrXml.length > 0) { 
					ComXml2ComboItem(arrXml[0], bound_type, "val", "name");
					bound_type.SetSelectCode("I");
					document.form.bkg_ofc_cd.disabled=true;
				}
				break;
		case IBSEARCH:      // retrieve
			if(validateForm(sheetObj,formObj,sAction)){
				  ComOpenWait(true);
	        	  formObj.f_cmd.value=SEARCH;
 	        	  sheetObj.DoSearch("ESM_BKG_0162GS.do", FormQueryString(formObj )+ "&" + ComGetPrefixParam(""));
			}	  
	        break;
		break;
        }
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
        	switch(sAction) {
				case IBSEARCH: // save
					if (!ComChkValid(formObj)) return false;
					break;
       	 	}	
        }
        return true;
    }
     
 	function bound_type_OnChange(comboObj,value,text){
 		var formObj=document.form;
 		var bound=value;
 		
 		if(bound =='I' || bound =='1')
 		{
 			pol.innerHTML="POD";
 			formObj.bkg_ofc_cd.value="";
 			formObj.bkg_ofc_cd.disabled=true;
 		}
 		else if(bound =='O'|| bound =='0')
 		{
 			pol.innerHTML="POL" ;
 			formObj.bkg_ofc_cd.disabled=false;
 		}
 	}
 	
 	function sheet1_OnSearchEnd(sheetObj, Code, ErrMsg){
 		ComOpenWait(false);
 		with (sheetObj)
 		var redColor="#FF0000";
 		var sheetObj=sheetObjects[0];
 		for(var i=2; i < sheetObj.LastRow() + 1; i++){
 			if(sheetObj.GetCellValue(i,"hbl") =="Y") {
  				sheetObj.SetCellFontColor(i, "bkg_no",redColor);
 			}
 			if(sheetObj.GetCellValue(i,"flg") =="No") {
  				sheetObj.SetCellFontColor(i, "cntr_no",redColor);
  				sheetObj.SetCellFontColor(i, "flg",redColor);
 			}
 		}
 	}
 	
 	/* developers work end */  