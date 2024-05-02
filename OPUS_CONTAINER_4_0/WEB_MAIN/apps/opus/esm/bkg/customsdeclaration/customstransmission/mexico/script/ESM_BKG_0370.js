/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0370.js
*@FileTitle  : Mexico Customs Transmit 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/28
=========================================================*/
/**
 * @extends
 * @class ESM_BKG-0370 : ESM_BKG-0370 business script for
 */


// Common global variable
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1; 
var sheetObjects=new Array();
var sheetCnt=0;
var intervalId="";
// Event handler processing by button click event */
document.onclick=processButtonClick;

	// Event handler processing by button name */
    function processButtonClick(){
         /* */
		 var sheetObject=sheetObjects[0];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObject,document.form,IBSEARCH);
				break; 
				case "btn_Transmit":
					doActionIBSheet(sheetObjects[0], document.form, MULTI);
				break;                     
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e);
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
		for(var i=0; i < form.search_flg.length; i++){
			if(form.search_flg[i].checked){
				form.search_flg[i].click();
			}
		}
    }
    
    function obj_KeyUp() {
    	var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
    	var formObject=document.form;
	    var srcName=ComGetEvent("name");
	    var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
	    var srcValue=window.event.srcElement.getAttribute("value");
	    if (keyValue != 9 && keyValue !=16 &&ComChkLen(srcValue, srcMaxLength) == "2") {
	    	ComSetNextFocus();
	    }
    }
    
	function initControl() {
		DATE_SEPARATOR="-";
		var formObject=document.form;
//		axon_event.addListenerFormat('keypress',       'obj_KeyPress',    formObject); //- 키보드 입력할때
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
		axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
		axon_event.addListenerForm("click", "obj_Clicked", document.form);
		axon_event.addListenerForm("change", "obj_OnChange", document.form);		
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
	                //no support[check again]CLT if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	                var HeadTitle1="|Seq.|VVD|B/L No.|BKG No.|R|D|T/S|POR|V.POL|V.POD|DEL|WGT|WGT|PKG|FRT|STOW|RF|Send Date||||";
	                var headCount=ComCountHeadTitle(HeadTitle1);

	                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

	                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	                InitHeaders(headers, info);

	                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                       {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
		                       {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vvd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"bl_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"bkg_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"r",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"d",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ts",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"por_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"del_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0, Width:70,   Align:"Right",   ColMerge:0,   SaveName:"act_wgt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"wgt_ut_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0, Width:70,   Align:"Right",   ColMerge:0,   SaveName:"pck_qty",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"frt_term_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"stwg_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rc_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"snd_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"o_bl_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"cpol",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"cpod",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                       {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"stwg_desc",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                 
	                InitColumns(cols);

	                SetEditable(1);
//	                SetCountPosition(2);
//	                SetSheetHeight(400);
	                ComResizeSheet(sheetObj);

            	}
                break;
        }
    }
    
    // handling process for Sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			case IBSEARCH:      //retrieve
				if(!validateForm(sheetObj,formObj,sAction)) return;
				formObj.f_cmd.value=SEARCH;	  			
				var sXml=sheetObj.GetSearchData("ESM_BKG_0370GS.do ", FormQueryString(formObj));
                if (sXml != "") sheetObj.LoadSearchData(sXml,{Sync:1} );

			break;
			case MULTI:        //Transmit
				if( ! validateForm(sheetObj,formObj,sAction)) return;
				for(var i=1; i < sheetObj.rowCount+1; i++){
					sheetObj.SetRowStatus(i,"U");
				}
				if(ComShowCodeConfirm("BKG40056", sheetObj.GetCellValue(1, "vvd"), sheetObj.GetCellValue(1, "cpol"), sheetObj.GetCellValue(1, "cpod"))){
					formObj.f_cmd.value=MULTI;
//					var sParam=ComGetSaveString(sheetObj)+ "&" + FormQueryString(formObj);
					var sParam=sheetObj.GetSaveString(true) + "&" + FormQueryString(formObj);
					
					sheetObj.SetWaitImageVisible(0);
    				ComOpenWait(true);
					var sXml=sheetObj.GetSearchData("ESM_BKG_0370GS.do", sParam);
					var key=ComGetEtcData(sXml, "KEY");
    				intervalId=setInterval("doActionValidationResult(sheetObjects[0], '" + key + "');", 3000);
					for(var i=1; i < sheetObj.rowCount+1; i++){
						sheetObj.SetRowStatus(i,"");
					}
				}
			break;	

			case COMMAND01:			//POD Combo
				formObj.f_cmd.value = COMMAND01; 
				var sXml =sheetObj.GetSearchData("ESM_BKG_0370GS.do", FormQueryString(formObj));
				ComXml2ComboItem(sXml,pod_cd,"val", "val");
				if (ComIsEmpty(formObj.pod_cd)) {
	       			ComSetObjValue(formObj.pod_cd,formObj.pod_cd.Text);
	       			
	       			pod_cd.SetSelectText();
	       		}
				break;
				
        }
  	}
    
    /**
     * BackEndJob
     */
    function doActionValidationResult(sheetObj, sKey) {
     	var sXml=sheetObj.GetSearchData("ESM_BKG_0370GS.do?f_cmd=" + SEARCH03
    			+ "&key=" + sKey);
    	var sJbStsFlg=ComGetEtcData(sXml, "jb_sts_flg");
    	if (!ComBkgErrMessage(sheetObj, sXml)) {
    		clearInterval(intervalId);
    		ComOpenWait(false);
    		return;
    	}
    	if (sJbStsFlg == "SUCCESS") {
    		clearInterval(intervalId);
    		ComOpenWait(false);
    		ComShowCodeMessage('BKG00101');	
    		return;
    	} else if (sJbStsFlg == "FAIL") {
    		// error
    		clearInterval(intervalId);
    		ComOpenWait(false);
    		// Show the error message
    		ComShowMessage(ComResultMessage(sXml));
    	}
    }
    
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
    	 switch(sAction) {
			case IBSEARCH:
				if(!ComChkRequired(formObj)) return false;
				var sFlgVal="";
				for(var i=0; i < form.search_flg.length; i++){
					if(form.search_flg[i].checked){
						sFlgVal=form.search_flg[i].value;
						break;
					}
				}
				if(sFlgVal == "O"){
					if(form.pol_cd.value == ""){
						ComShowCodeMessage("BKG00626", "Please input POL to retrieve O/B");
						return false;
					}					
				}else if(sFlgVal == "T"){
					if(form.pod_cd.value == "" && form.pol_cd.value == ""){
						ComShowCodeMessage("BKG00626", "Please input POL or POD to retrieve T/S");
						return false;
					}							
				}else if(sFlgVal == "I"){
					if(form.pod_cd.value == "" || form.pol_cd.value == ""){
						ComShowCodeMessage("BKG00626", "Please input POL and POD to retrieve I/B");
						return false;
					}	
				}
				break;
			case MULTI:
				if(sheetObjects[0].RowCount()== 0){
					ComShowCodeMessage("BKG00889"); //No data found
					return false;
				}
				break;
			case IBDOWNEXCEL:
				if(sheetObjects[0].RowCount()== 0){
					ComShowCodeMessage("BKG00889"); //No data found
					return false;
				}
				break;	
    	 }
        return true;
    }
    
    /**
     * Search End Event
     */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		form.total_bl.value="";
		var totBlCnt=0;
		if(sheetObj.RowCount()> 0) {
			var idx=0;
			// Count the Distinct BL
			for(var i=1; i < sheetObj.RowCount()+ 1; i++) {				
				idx=0;
				if(i == 1){
					totBlCnt++;
				}else {
					idx=sheetObj.FindText("bl_no", sheetObj.GetCellValue(i, "bl_no"), 1);
					if(idx == i) {
						totBlCnt++;
					}
				}
				sheetObj.SetToolTipText(i, "stwg_cd",sheetObj.GetCellValue(i, "stwg_desc"));
			}			
		}
		
		form.total_bl.value=ComAddComma(totBlCnt);

		if(sheetObj.GetEtcData("vsl_eng_nm") != undefined){
			form.vsl_eng_nm.value=sheetObj.GetEtcData("vsl_eng_nm");
		}
		if(sheetObj.GetEtcData("call_sign") != undefined){
			form.call_sgn_no.value=sheetObj.GetEtcData( "call_sign");
		}
		if(sheetObj.GetEtcData("eta") != undefined){
			if(form.pod_cd.value != ""){
				form.eta.value=sheetObj.GetEtcData("eta");
				form.etd.value="";
			}else{
				form.eta.value="";
				form.etd.value=sheetObj.GetEtcData("eta");
			}
		}
		if(sheetObj.GetEtcData("etd") != undefined){
			if(sheetObj.GetEtcData("etd") != ""){
				form.etd.value=sheetObj.GetEtcData("etd");
			}
		}
	}
    function obj_Clicked() {
    	var formObject=document.form;
    	var srcName=ComGetEvent("name");
    	var srcValue=window.event.srcElement.getAttribute("value");
    	if(srcName == "search_flg"){
	    	if(srcValue == "O"){
	    		form.pol_cd.className="input1";
//	    		form.pod_cd.className="input";
//	    		pod_cd.SetRequired(false)
//	    		pod_cd.SetRequired(false);
	    		pod_cd.SetBackColor("white");	    		
//	    		pod_cd.Style=1;//0 -편집 가능,1 -편집 불가능	    		
	    	}else if (srcValue == "T"){
	    		form.pol_cd.className="input";
//	    		form.pod_cd.className="input";  
//	    		pod_cd.SetRequired(false);
	    		pod_cd.SetBackColor("white");	    		
	    	}else{
	    		form.pol_cd.className="input1";
//	    		form.pod_cd.className="input1";  
//	    		pod_cd.SetRequired(true, "POD");
	    	    pod_cd.SetBackColor("#CCFFFD");	    		
	    	}
    	}
    } 
    
	/**
	 * Form Element의 OnChange 이벤트
	 */
	function obj_OnChange() {
		var sheetObj=sheetObjects[0];
		var elementName=ComGetEvent("name");
		with (document.form) {
			switch (elementName) {
				case "vvd":
				case "pol_cd":
					if(document.form.vvd.value!="" && document.form.pol_cd.value!="" ){
						doActionIBSheet(sheetObj,document.form, COMMAND01);
					}
				break;
			}
		}
	}   
	
    /**
     * Booking Creation 화면 이동
     * @param sheetObj Sheet
     * @param Row Row Index
     * @param Col Col Index
     */
    function sheet1_OnDblClick(sheetObj, Row, Col) {
    	var srcCol = sheetObj.ColSaveName(Col);
    	if (srcCol != "bl_no" && srcCol != "bkg_no") return;
    	
    	ComBkgCall0079(sheetObj.GetCellValue(Row, "bl_no"));

    }
	